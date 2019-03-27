package fr.unedic.cali.parcours;

import fr.pe.cali.crem.dom.ObjetMetierCrem;
import fr.pe.cali.crem.outils.OutilAjoutCremDalLiquidation;
import fr.pe.cali.crem.outils.OutilGenerationObjetMetierDalLiquidation;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.autresdoms.cohab.outilsfonctionnels.CreationDemande;
import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.ClassementSansSuite;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.Erreur;
import fr.unedic.cali.dom.FormulaireSpec;
import fr.unedic.cali.dom.Indicateur;
import fr.unedic.cali.dom.IndicateursGeneriques;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.outilsfonctionnels.EvenementReexamen;
import fr.unedic.cali.outilsfonctionnels.OutilFluxSigma;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreDemandesHorsGammeRbf;
import fr.unedic.cali.outilsfonctionnels.reexecution.FabriqueGestionnaireReexecution;
import fr.unedic.cali.outilsfonctionnels.reexecution.GestionnaireReexecutionSpec;
import fr.unedic.cali.outilsfonctionnels.reexecution.ResultatGestionnaireReexecutionSpec;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteException;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologieDebuts;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ParcoursClassementSansSuite
  extends ParcoursServiceAbstrait
{
  public Resultat demarrerParcours(Contexte contexte)
    throws ApplicativeException
  {
    DomClassementSansSuite dom = (DomClassementSansSuite)contexte.getDonnees();
    
    ResultatClassement resultatParcours = new ResultatClassement();
    
    Erreur erreurTraitement = null;
    
    IndividuSpec individuPersistant = getIndividu(contexte);
    if (individuPersistant != null)
    {
      ChronologieDebuts chronoDemandes = individuPersistant.getChronoDemandes();
      
      OutilFluxSigma.sauvegarderEtatDemandes(individuPersistant);
      
      Chronologie demandesSansRbf = recupererDemandesSansRbf(chronoDemandes);
      
      Collection<fr.unedic.cali.dom.DemandeSpec> demandesInvalides = new ArrayList();
      if (demandesSansRbf.estVide()) {
        erreurTraitement = traiterDemandeInconnueCali(contexte, dom, resultatParcours, erreurTraitement, demandesInvalides);
      } else {
        erreurTraitement = traiterDemandes(contexte, dom, resultatParcours, erreurTraitement, demandesSansRbf, demandesInvalides);
      }
      notifierSigma(individuPersistant, demandesInvalides);
    }
    resultatParcours.setContexte(contexte);
    resultatParcours.setErreurTraitement(erreurTraitement);
    
    resultatParcours.setIndicateursGeneriques(new IndicateursGeneriques());
    if (erreurTraitement == null) {
      incrementerIndicateur(dom, resultatParcours);
    }
    return resultatParcours;
  }
  
  protected Erreur traiterDemandes(Contexte contexte, DomClassementSansSuite dom, ResultatClassement resultatParcours, Erreur erreurTraitement, Chronologie demandesSansRbf, Collection<fr.unedic.cali.dom.DemandeSpec> demandesInvalides)
    throws ApplicativeException
  {
    Erreur retour = erreurTraitement;
    
    boolean flag = false;
    
    demandesSansRbf.iterer();
    while (demandesSansRbf.encoreSuivant())
    {
      fr.unedic.cali.dom.DemandeSpec demandeCourante = (fr.unedic.cali.dom.DemandeSpec)demandesSansRbf.elementSuivant();
      if (demandeCourante.getFormulaire().getReferenceExterne().equals(dom.getReferenceExterneFormulaire()))
      {
        flag = true;
        if ((demandeCourante.getClassementAdministratif() != null) || (demandeCourante.estDecisionnee())) {
          retour = remplirErreur(retour, resultatParcours, 2);
        } else {
          classerSansSuiteDemande(contexte, dom, demandesInvalides, demandeCourante);
        }
      }
      if (flag) {
        break;
      }
    }
    if (!flag) {
      retour = traiterDemandeInconnueCali(contexte, dom, resultatParcours, erreurTraitement, demandesInvalides);
    }
    return retour;
  }
  
  protected Erreur traiterDemandeInconnueCali(Contexte contexte, DomClassementSansSuite dom, ResultatClassement resultatParcours, Erreur erreurTraitement, Collection<fr.unedic.cali.dom.DemandeSpec> demandesInvalides)
    throws ApplicativeException
  {
    Erreur retour = erreurTraitement;
    
    ContexteService contexteService = dom.getContexteService();
    String idDemandeRecue = dom.getReferenceExterneFormulaire();
    Individu individu = (Individu)dom.getIndividu();
    fr.unedic.cali.autresdoms.cohab.sigma.demande.dom.spec.DemandeSpec demandeV1 = individu.getUneDemandeV1(idDemandeRecue);
    if (demandeV1 != null)
    {
      String codeGamme = demandeV1.getGamme();
      
      Collection<?> listeFormulairesNonConnus = creerFormulaires(codeGamme, contexteService, idDemandeRecue, individu);
      
      Collection<FormulaireSpec> formulaireDemandeACreer = recupererFormulaire(listeFormulairesNonConnus, idDemandeRecue);
      
      Collection<?> nouvelleDemande = creerNouvellesDemandesNcp(individu, contexteService, formulaireDemandeACreer);
      
      fr.unedic.cali.dom.DemandeSpec demandeAClasserSansSuite = recupererDemande(nouvelleDemande, idDemandeRecue);
      
      classerSansSuiteDemande(contexte, dom, demandesInvalides, demandeAClasserSansSuite);
    }
    else
    {
      retour = remplirErreur(erreurTraitement, resultatParcours, 1);
    }
    return retour;
  }
  
  protected Collection<?> creerFormulaires(String codeGamme, ContexteService contexteService, String idDemandeRecue, Individu individu)
    throws ApplicativeException
  {
    return CreationDemande.getInstance().creerFormulaires(codeGamme, contexteService, idDemandeRecue, individu);
  }
  
  protected Collection<?> creerNouvellesDemandesNcp(Individu individu, ContexteService contexteService, Collection<FormulaireSpec> formulaireDemandeACreer)
    throws ApplicativeException
  {
    return CreationDemande.getInstance().creerNouvellesDemandesNcp(individu, contexteService, formulaireDemandeACreer);
  }
  
  protected fr.unedic.cali.dom.DemandeSpec recupererDemande(Collection<?> demandes, String idDemande)
  {
    Iterator<?> iterDemandes = demandes.iterator();
    fr.unedic.cali.dom.DemandeSpec demandeAClasserSansSuite = null;
    while (iterDemandes.hasNext())
    {
      fr.unedic.cali.dom.DemandeSpec demandeWhile = (fr.unedic.cali.dom.DemandeSpec)iterDemandes.next();
      if (idDemande.equals(demandeWhile.getFormulaire().getReferenceExterne()))
      {
        demandeAClasserSansSuite = demandeWhile;
        break;
      }
    }
    return demandeAClasserSansSuite;
  }
  
  protected void classerSansSuiteDemande(Contexte contexte, DomClassementSansSuite dom, Collection<fr.unedic.cali.dom.DemandeSpec> demandesInvalides, fr.unedic.cali.dom.DemandeSpec demandeAClasserSansSuite)
    throws ApplicativeException
  {
    ResultatGestionnaireReexecutionSpec resultatReexecution = classerSansSuite(demandeAClasserSansSuite, "" + dom.getMotifClassement(), contexte);
    for (Iterator<fr.unedic.cali.dom.DemandeSpec> iter = resultatReexecution.getDemandesReliquidees().iterator(); iter.hasNext();)
    {
      fr.unedic.cali.dom.DemandeSpec demande = (fr.unedic.cali.dom.DemandeSpec)iter.next();
      if (!demandesInvalides.contains(demande)) {
        demandesInvalides.add(demande);
      }
    }
    if (!demandesInvalides.contains(demandeAClasserSansSuite)) {
      demandesInvalides.add(demandeAClasserSansSuite);
    }
  }
  
  protected Collection<FormulaireSpec> recupererFormulaire(Collection<?> listeFormulaires, String idDemande)
  {
    Iterator<?> iterFormulaires = listeFormulaires.iterator();
    Collection<FormulaireSpec> formulaireMemeIdDemande = new ArrayList();
    while (iterFormulaires.hasNext())
    {
      FormulaireSpec nouveauFormulaire = (FormulaireSpec)iterFormulaires.next();
      if (idDemande.equals(nouveauFormulaire.getReferenceExterne()))
      {
        formulaireMemeIdDemande.add(nouveauFormulaire);
        break;
      }
    }
    return formulaireMemeIdDemande;
  }
  
  private void incrementerIndicateur(DomClassementSansSuite dom, ResultatClassement resultatParcours)
  {
    switch (dom.getMotifClassement())
    {
    case 1: 
      resultatParcours.getIndicateursGeneriques().getIndicateur("D12_MOTIF_RNLC").incremente();
      break;
    case 2: 
      resultatParcours.getIndicateursGeneriques().getIndicateur("D12_MOTIF_RSAE").incremente();
      break;
    }
  }
  
  protected void notifierSigma(IndividuSpec individu, Collection<fr.unedic.cali.dom.DemandeSpec> demandesInvalides)
    throws ApplicativeException
  {
    OutilFluxSigma.notifierSigma(individu, demandesInvalides, false);
  }
  
  public void controlerContexte(Contexte contexte)
    throws ContexteException
  {}
  
  protected ResultatGestionnaireReexecutionSpec reexecution(fr.unedic.cali.dom.DemandeSpec demande, EvenementReexamen evt)
    throws ApplicativeException
  {
    return FabriqueGestionnaireReexecution.getGestionnaire().executer(demande, evt);
  }
  
  protected OutilAjoutCremDalLiquidation initialisationOutilAjouCREM()
  {
    return OutilAjoutCremDalLiquidation.getInstance();
  }
  
  protected ResultatGestionnaireReexecutionSpec classerSansSuite(fr.unedic.cali.dom.DemandeSpec demande, String motif, Contexte contexte)
    throws ApplicativeException
  {
    IndividuSpec individu = recupererIndividu(contexte);
    
    ClassementSansSuite css = new ClassementSansSuite();
    css.setMotif(motif);
    
    EvenementReexamen evt = new EvenementReexamen(demande.getDateFinAbonnement(), "3");
    
    demande.setClassementAdministratif(css);
    
    demande.annulerDecisions();
    
    definirDateValidation(contexte, demande);
    
    ajouterCremDemandeSurIndividu(demande, contexte);
    
    ResultatGestionnaireReexecutionSpec resultatReexecution = reexecution(demande, evt);
    
    OutilAjoutCremDalLiquidation outil = initialisationOutilAjouCREM();
    outil.ajouterCREMDemandesReexecutes(resultatReexecution.getDemandesReliquidees(), individu);
    return resultatReexecution;
  }
  
  protected IndividuSpec recupererIndividu(Contexte contexte)
  {
    return getIndividu(contexte);
  }
  
  protected void definirDateValidation(Contexte contexte, fr.unedic.cali.dom.DemandeSpec demande)
  {
    ContexteService contexteService = ((DomClassementSansSuite)contexte.getDonnees()).getContexteService();
    demande.definirDateValidation(contexteService.getDateTraitement());
  }
  
  protected void ajouterCremDemandeSurIndividu(fr.unedic.cali.dom.DemandeSpec demande, Contexte contexte)
    throws ApplicativeException
  {
    OutilGenerationObjetMetierDalLiquidation outil = OutilGenerationObjetMetierDalLiquidation.getInstance();
    IndividuSpec individu = demande.getDemandeur();
    List<ObjetMetierCrem> listeCrem = individu.getListeCrem();
    if (listeCrem != null)
    {
      ObjetMetierCrem crem = outil.genererObjetMetier(demande, getContexteService(contexte));
      if (crem != null) {
        listeCrem.add(crem);
      }
    }
  }
  
  private Erreur remplirErreur(Erreur erreur, ResultatClassement resultatParcours, int origine)
  {
    Erreur retour = erreur;
    switch (origine)
    {
    case 0: 
      retour = new Erreur();
      retour.setNiveau(3);
      retour.setCode("HG_PR_CALI_L_TB_IND");
      retour.setLibelle("Individu non trouvé");
      resultatParcours.setEtat(1);
      
      break;
    case 1: 
      retour = new Erreur();
      retour.setNiveau(3);
      retour.setCode("HG_PR_CALI_L_TB_DDE");
      retour.setLibelle("Demande non trouvée");
      resultatParcours.setEtat(1);
      
      break;
    case 2: 
      retour = new Erreur();
      retour.setNiveau(1);
      retour.setCode("HG_PR_CALI_L_TB_D_ACA");
      retour.setLibelle("Demande portant déjà un classement administratif ou déjà décisionnée");
      resultatParcours.setEtat(0);
      
      break;
    default: 
      retour = null;
      resultatParcours.setEtat(0);
    }
    return retour;
  }
  
  protected Chronologie recupererDemandesSansRbf(Chronologie chronoDemandes)
  {
    return chronoDemandes.copier(new FiltreDemandesHorsGammeRbf());
  }
  
  protected int getModeChargementDebrayageDossiersLourds(Individu individu)
  {
    return 2;
  }
  
  protected void alimenterAgregatGaec(Individu individu, String idDemande)
  {
    individu.getDonneesChargementGaec().getAgregatGaec().setModeAppel(2);
  }
  
  protected void controlerPostTraitement(Individu individu)
    throws AccesDonneesGaecException
  {
    controlerModeAppel(individu.getDonneesChargementGaec().getAppelGaecReduit(), 2);
  }
}

/* Location:
 * Qualified Name:     ParcoursClassementSansSuite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */