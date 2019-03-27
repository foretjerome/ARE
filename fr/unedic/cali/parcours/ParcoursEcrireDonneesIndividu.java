package fr.unedic.cali.parcours;

import fr.pe.cali.crem.outils.OutilAjoutCremDalLiquidation;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.EvenementReferenceExamenSpec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.affectation.GammeAsu;
import fr.unedic.cali.outilsfonctionnels.EvenementReexamen;
import fr.unedic.cali.outilsfonctionnels.GestionnaireErreur;
import fr.unedic.cali.outilsfonctionnels.OutilFluxSigma;
import fr.unedic.cali.outilsfonctionnels.OutilVerificationDonneesIndividu;
import fr.unedic.cali.outilsfonctionnels.reexecution.FabriqueGestionnaireReexecution;
import fr.unedic.cali.outilsfonctionnels.reexecution.GestionnaireReexecutionSpec;
import fr.unedic.cali.outilsfonctionnels.reexecution.ResultatGestionnaireReexecutionSpec;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreDemandePourReferenceExterne;
import fr.unedic.cali.utilitaire.outils.OutilRecherche;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteException;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.Dom;
import fr.unedic.util.services.Parcours;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.ChronologieDebuts;
import fr.unedic.util.temps.Damj;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;

public class ParcoursEcrireDonneesIndividu
  extends ParcoursServiceAbstrait
{
  private boolean estBesoinReexecution = true;
  
  public void controlerContexte(Contexte contexte)
    throws ContexteException
  {
    IndividuSpec individuCourant = getIndividu(contexte);
    if (individuCourant == null) {
      throw new ContexteException("HG_PR_CALI_L_ERR_CTX_ABS_DEMANDEUR", "Individu absent du contexte");
    }
  }
  
  public Resultat demarrer(Contexte contexte)
    throws ApplicativeException
  {
    Dom dom = contexte.getDonnees();
    if ((dom instanceof DomDonneesIndividu))
    {
      DomDonneesIndividu domCali = (DomDonneesIndividu)dom;
      IndividuSpec individu = domCali.getIndividu();
      estBesoinReexecution = isReexecutionNecessaire(domCali, individu);
    }
    return super.demarrer(contexte);
  }
  
  public Resultat demarrerParcours(Contexte contexte)
    throws ApplicativeException
  {
    DomDonneesIndividu dom = (DomDonneesIndividu)contexte.getDonnees();
    
    IndividuSpec individu = recupererIndividuValide(dom);
    
    modifierIndividu(dom, individu);
    
    modifierDateDepotDemandeExpresse(dom, individu);
    if (estBesoinReexecution)
    {
      Collection<DemandeSpec> demandesImpactees = reexecution(contexte, dom, individu);
      notifierSigma(individu, demandesImpactees);
      
      determinerCREM(contexte);
    }
    Resultat resultat = new Resultat();
    resultat.setEtat(0);
    
    return resultat;
  }
  
  protected boolean isReexecutionNecessaire(DomDonneesIndividu dom, IndividuSpec individu)
  {
    boolean donneesModifiees = (individu.getAttributionsAfdFiliereCourte() != dom.getAttributionsAfdFiliereCourte()) || (individu.getAttributionsAfdFiliereIntermediaire() != dom.getAttributionsAfdFiliereIntermediaire()) || (individu.getAttributionsAfdFiliereLongue() != dom.getAttributionsAfdFiliereLongue());
    
    return donneesModifiees;
  }
  
  protected void modifierIndividu(DomDonneesIndividu dom, IndividuSpec individu)
  {
    dom.setDonneesIndividuAvant(getDonneesCrem(individu));
    
    individu.setForcageAppelGaecTotal(dom.isEstAppelCalculTotal());
    individu.setAttributionsAfdFiliereCourte(dom.getAttributionsAfdFiliereCourte());
    individu.setAttributionsAfdFiliereIntermediaire(dom.getAttributionsAfdFiliereIntermediaire());
    individu.setAttributionsAfdFiliereLongue(dom.getAttributionsAfdFiliereLongue());
    individu.setDernierJourIndemnisableAreSpe(dom.getDernierJourIndemnisableAreSpe());
    individu.setDateExecutionDifferee(dom.getDateExecutionDifferee());
    individu.setCodeTransaction(dom.getCodeTransaction());
    individu.setDomaineSrcFlux(dom.getDomaineSourceFlux());
    individu.setEstArretReexecution(dom.isEstArretReexecution());
    individu.setEstNonExecutionReceptionFlux(dom.estExecutionDiffereFluxDesactive());
    individu.setEstDesactEFE(dom.estDesactivationEfe());
    
    dom.setDonneesIndividuApres(getDonneesCrem(individu));
  }
  
  protected Damj recupererDateEvenement(Contexte contexte)
  {
    return ((DomDonneesIndividu)contexte.getDonnees()).getContexteService().getDateTraitement();
  }
  
  protected IndividuSpec recupererIndividuValide(DomDonneesIndividu dom)
    throws CoucheLogiqueException
  {
    OutilVerificationDonneesIndividu.verifierDonneesIndividu(dom);
    
    return dom.getIndividu();
  }
  
  protected void notifierSigma(IndividuSpec individu, Collection<DemandeSpec> demandesImpactees)
    throws ApplicativeException
  {
    OutilFluxSigma.notifierSigma(individu, demandesImpactees, true);
  }
  
  protected OutilAjoutCremDalLiquidation initialisationOutilAjouCREM()
  {
    return OutilAjoutCremDalLiquidation.getInstance();
  }
  
  protected Collection<DemandeSpec> reexecution(Contexte contexte, DomDonneesIndividu dom, IndividuSpec individu)
    throws ApplicativeException
  {
    Damj dateEvenement = recupererDateEvenement(contexte);
    
    Damj dateReexamen = recupererDateExamen(individu);
    Collection<DemandeSpec> demandesImpactees;
    if (dateReexamen.estAvant(Damj.FIN_DES_TEMPS))
    {
      ResultatGestionnaireReexecutionSpec resultatReexecution = appelGestionaireReexecution(dom, individu, dateReexamen);
      Collection<DemandeSpec> demandesImpactees = resultatReexecution.getDemandesReliquidees();
      
      OutilAjoutCremDalLiquidation outilAjoutCrem = initialisationOutilAjouCREM();
      outilAjoutCrem.ajouterCREMDemandesReexecutes(demandesImpactees, individu);
    }
    else
    {
      Map etatsDemandeAvant = OutilFluxSigma.sauvegarderEtatDemandes(individu);
      demandesImpactees = OutilFluxSigma.recupererDemandesImpacteesNonNeutralisees(etatsDemandeAvant, individu, dateEvenement);
    }
    return demandesImpactees;
  }
  
  protected Damj recupererDateExamen(IndividuSpec individu)
  {
    return individu.getDateNaissance();
  }
  
  protected ResultatGestionnaireReexecutionSpec appelGestionaireReexecution(DomDonneesIndividu dom, IndividuSpec individu, Damj dateReexamen)
    throws ApplicativeException
  {
    EvenementReexamen evtReexamen = new EvenementReexamen(dateReexamen, "25");
    return FabriqueGestionnaireReexecution.getGestionnaire().executer(dom.getIndividu(), evtReexamen);
  }
  
  private Hashtable<String, String> getDonneesCrem(IndividuSpec individu)
  {
    Hashtable<String, String> donnees = new Hashtable();
    donnees.put("Attr. AFD filiere courte", String.valueOf(individu.getAttributionsAfdFiliereCourte()));
    donnees.put("Attr. AFD filiere int.", String.valueOf(individu.getAttributionsAfdFiliereIntermediaire()));
    donnees.put("Attr. AFD filiere longue", String.valueOf(individu.getAttributionsAfdFiliereLongue()));
    return donnees;
  }
  
  protected int getModeChargementDebrayageDossiersLourds(Individu individu)
  {
    return 2;
  }
  
  protected int getModeChargementGaec()
  {
    int retour = 2;
    if (!estBesoinReexecution) {
      retour = 0;
    }
    return retour;
  }
  
  protected void alimenterAgregatGaec(Individu individu, String idDemande)
  {
    individu.getDonneesChargementGaec().getAgregatGaec().setModeAppel(getModeChargementGaec());
  }
  
  protected void controlerPostTraitement(Individu individu)
    throws AccesDonneesGaecException
  {
    controlerModeAppel(individu.getDonneesChargementGaec().getAppelGaecReduit(), getModeChargementGaec());
  }
  
  protected void determinerCREM(Contexte contexte)
    throws ApplicativeException
  {
    if (isModeTp(contexte))
    {
      Parcours parcoursCREM = new ParcoursCREMIndividu();
      parcoursCREM.effectuerParcours(contexte);
    }
  }
  
  protected boolean isModeTp(Contexte contexte)
  {
    ContexteService contexteService = ((DomCali)contexte.getDonnees()).getContexteService();
    
    return contexteService.getContexteEmission().equalsIgnoreCase("TP");
  }
  
  private void modifierDateDepotDemandeExpresse(DomDonneesIndividu dom, IndividuSpec individu)
    throws CoucheLogiqueException
  {
    if ((dom.getDateDepotDemandeExpresse() != null) || (dom.getReferenceExterneDemandeExpresse() != null))
    {
      Damj dateDepot = dom.getDateDepotDemandeExpresse();
      String refEx = dom.getReferenceExterneDemandeExpresse();
      
      controlerDateDepotDemandeExpresse(dateDepot, refEx);
      DemandeSpec demande = recupererDemandeExpresse(refEx, individu);
      
      controlerTypeDemandeExpresse(demande);
      GammeAsu.getInstance().setDateDepotOrigine(demande, dateDepot);
    }
  }
  
  private void controlerTypeDemandeExpresse(DemandeSpec demande)
    throws CoucheLogiqueException
  {
    if ((demande == null) || (!"ASU_02".equals(demande.getEvenementReferenceExamen().getTypeExamen()))) {
      GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_REFERENCE_DEMANDE_EXPRESSE");
    }
  }
  
  private DemandeSpec recupererDemandeExpresse(String refEx, IndividuSpec individu)
  {
    ChronologieDebuts chronoDemandes = individu.getChronoDemandeAssurance();
    return OutilRecherche.rechercherDemandePrecedente(chronoDemandes, Damj.FIN_DES_TEMPS, new FiltreDemandePourReferenceExterne(refEx));
  }
  
  private void controlerDateDepotDemandeExpresse(Damj dateDepot, String refEx)
    throws CoucheLogiqueException
  {
    if ((dateDepot == null) || (refEx == null)) {
      GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_COHERENCE_DATE_DEPOT_INITIALE");
    }
  }
}

/* Location:
 * Qualified Name:     ParcoursEcrireDonneesIndividu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */