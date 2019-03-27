package fr.unedic.cali.autresdoms.cohab.outilsfonctionnels;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.ClassementAdministratif;
import fr.unedic.cali.dom.ComparateurReferenceExterne;
import fr.unedic.cali.dom.FormulaireAbstrait;
import fr.unedic.cali.dom.FormulaireSpec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.affectation.GammeSpec;
import fr.unedic.cali.outilsfonctionnels.AppelServicesCojac;
import fr.unedic.cali.outilsfonctionnels.ConstructionCSOIA;
import fr.unedic.cali.outilsfonctionnels.OutilFluxSigma;
import fr.unedic.cali.parcours.DomCreationDemandePrestation;
import fr.unedic.cali.parcours.ParcoursCali;
import fr.unedic.cali.parcours.ResultatCreationDemandePrestation;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreDecisionneeSurDemande;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreDemandePourClassement;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreDemandePourERE;
import fr.unedic.cali.utilitaire.filtres.logiques.FiltreET;
import fr.unedic.cali.utilitaire.filtres.logiques.FiltreNegation;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologieDebuts;
import fr.unedic.util.temps.Damj;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CreationDemande
{
  private static CreationDemande instance = null;
  
  public static CreationDemande getInstance()
  {
    if (instance == null) {
      instance = new CreationDemande();
    }
    return instance;
  }
  
  public Collection<fr.unedic.cali.dom.DemandeSpec> creerNouvellesDemandesNcp(IndividuSpec individu, ContexteService contexteService, Collection<?> listeNouveauxFormulaires, boolean liquidationAutomatiqueApresCreation)
    throws ApplicativeException
  {
    Collection<fr.unedic.cali.dom.DemandeSpec> listeNouvellesDemandes = new ArrayList();
    if (listeNouveauxFormulaires != null)
    {
      List<FormulaireSpec> listeNouveauxFormulairesSpec = new ArrayList(listeNouveauxFormulaires);
      
      Collections.sort(listeNouveauxFormulairesSpec, new ComparateurReferenceExterne());
      
      Damj derniereDateDepot = null;
      
      Iterator<FormulaireSpec> iterFormulaires = listeNouveauxFormulairesSpec.iterator();
      
      boolean estDernierFormulaireSuiteIde = false;
      if (!listeNouveauxFormulairesSpec.isEmpty())
      {
        FormulaireSpec dernierFormulaire = (FormulaireSpec)listeNouveauxFormulairesSpec.get(listeNouveauxFormulairesSpec.size() - 1);
        derniereDateDepot = dernierFormulaire.getDateDepot();
        String typeExamen = ConstructionCSOIA.getTypeExamenDepuisV1(dernierFormulaire.getNomGamme(), dernierFormulaire.getNomLigne(), dernierFormulaire.getNomProduit(), dernierFormulaire.getMotifEnvoi());
        if ("ASU_01".equals(typeExamen))
        {
          estDernierFormulaireSuiteIde = true;
          
          FiltreET filtreEt = new FiltreET();
          filtreEt.ajouterFiltre(new FiltreDemandePourERE("ASU_01"));
          filtreEt.ajouterFiltre(new FiltreNegation(new FiltreDecisionneeSurDemande()));
          filtreEt.ajouterFiltre(new FiltreNegation(new FiltreDemandePourClassement("tous classement")));
          traiterPrescriptionSurListeDemande(individu.getChronoDemandes().copier(filtreEt).mapperVersCollection(), derniereDateDepot);
        }
      }
      while (iterFormulaires.hasNext())
      {
        FormulaireSpec nouveauFormulaire = (FormulaireSpec)iterFormulaires.next();
        
        Contexte contexte = new Contexte();
        DomCreationDemandePrestation dom = new DomCreationDemandePrestation();
        
        dom.setFormulaire(nouveauFormulaire);
        dom.setIndividu(individu);
        dom.setLiquidationAutomatiqueActivee(liquidationAutomatiqueApresCreation);
        dom.setContexteService(contexteService);
        dom.setDateDepotDerniereDemande(derniereDateDepot);
        dom.setIdeDerniereDemande(estDernierFormulaireSuiteIde);
        
        contexte.setDonnees(dom);
        
        ParcoursCali parcours = nouveauFormulaire.getGamme().getParcoursCreationDemande();
        
        ResultatCreationDemandePrestation resultat = (ResultatCreationDemandePrestation)parcours.effectuerParcours(contexte);
        
        listeNouvellesDemandes.add(resultat.getDemande());
        if (!estDemandeExistante(individu, resultat.getDemande())) {
          individu.ajouterDemande(resultat.getDemande());
        }
      }
    }
    return listeNouvellesDemandes;
  }
  
  private boolean estDemandeExistante(IndividuSpec individu, fr.unedic.cali.dom.DemandeSpec demande)
  {
    Chronologie demandes = individu.getChronoDemandesNonTriees();
    String referenceExterne = demande.getFormulaire().getReferenceExterne();
    boolean demandeTrouvee = false;
    if ((demandes != null) && (!demandes.estVide()))
    {
      demandes.iterer();
      while ((demandes.encoreSuivant()) && (!demandeTrouvee))
      {
        fr.unedic.cali.dom.DemandeSpec demandeCourante = (fr.unedic.cali.dom.DemandeSpec)demandes.elementSuivant();
        demandeTrouvee = demandeCourante.getFormulaire().getReferenceExterne().equals(referenceExterne);
      }
    }
    return demandeTrouvee;
  }
  
  private void traiterPrescriptionSurListeDemande(Collection<fr.unedic.cali.dom.DemandeSpec> demandesAssuranceIdeAttenteDecision, Damj derniereDateDepot)
    throws ApplicativeException
  {
    for (Iterator<fr.unedic.cali.dom.DemandeSpec> iterator = demandesAssuranceIdeAttenteDecision.iterator(); iterator.hasNext();)
    {
      fr.unedic.cali.dom.DemandeSpec demandeSpec = (fr.unedic.cali.dom.DemandeSpec)iterator.next();
      if ((demandeSpec.getFormulaire().estDalNonRecevable()) && (demandeSpec.getGamme() != null)) {
        traiterPrescriptionSurDemande(derniereDateDepot, demandeSpec);
      }
    }
  }
  
  private void traiterPrescriptionSurDemande(Damj derniereDateDepot, fr.unedic.cali.dom.DemandeSpec demandeSpec)
    throws ApplicativeException
  {
    if (demandeSpec.getFormulaire().getDateDepot() == null) {
      ((FormulaireAbstrait)demandeSpec.getFormulaire()).setDateDepot(derniereDateDepot);
    }
    demandeSpec.getGamme().controlerPrescription(demandeSpec.getFormulaire());
    ClassementAdministratif classement = demandeSpec.getClassementAdministratif();
    if ((classement != null) && ("PS".equals(classement.getTypeClassement())))
    {
      ArrayList<fr.unedic.cali.dom.DemandeSpec> listeDemande = new ArrayList();
      listeDemande.add(demandeSpec);
      notifierSigma(demandeSpec.getDemandeur(), listeDemande);
    }
  }
  
  protected void notifierSigma(IndividuSpec individu, Collection<fr.unedic.cali.dom.DemandeSpec> listeDemande)
    throws ApplicativeException
  {
    OutilFluxSigma.notifierSigma(individu, listeDemande, false);
  }
  
  public Collection<?> creerNouvellesDemandesNcp(IndividuSpec individu, ContexteService contexteService, Collection<?> listeNouveauxFormulaires)
    throws ApplicativeException
  {
    return creerNouvellesDemandesNcp(individu, contexteService, listeNouveauxFormulaires, false);
  }
  
  public Collection<FormulaireSpec> creerFormulaires(String codeGamme, ContexteService contexteService, String idDemandeRecue, Individu individu)
    throws ApplicativeException
  {
    Damj dateCreationDALRecue = null;
    
    Collection listeDemandesCojac = new ArrayList();
    boolean dalDuFluxDejaConnueDeCali = false;
    if ("ASU".equals(codeGamme))
    {
      Collection<?> dals = individu.getDemandesV1("DAL");
      fr.unedic.cali.autresdoms.cohab.sigma.demande.dom.spec.DemandeSpec demandeRecue = individu.getUneDemandeV1(idDemandeRecue);
      if (demandeRecue != null) {
        dateCreationDALRecue = demandeRecue.getDateDemande();
      }
      ArrayList<?> resultatCojac = AppelServicesCojac.determinerDalsNonRetournees(dals, individu, "ASU", idDemandeRecue, dateCreationDALRecue);
      listeDemandesCojac = (Collection)resultatCojac.get(0);
    }
    else
    {
      fr.unedic.cali.autresdoms.cohab.sigma.demande.dom.spec.DemandeSpec dal = individu.getUneDemandeV1(idDemandeRecue);
      
      Iterator<?> iter = individu.getChronoDemandes().iterer();
      while (iter.hasNext())
      {
        String refExterneDalConnue = ((fr.unedic.cali.dom.DemandeSpec)iter.next()).getFormulaire().getReferenceExterne();
        if (idDemandeRecue.equals(refExterneDalConnue)) {
          dalDuFluxDejaConnueDeCali = true;
        }
      }
      if ((dal != null) && (!dalDuFluxDejaConnueDeCali)) {
        listeDemandesCojac.add(dal);
      }
    }
    Collection<FormulaireSpec> listeNouveauxFormulairesNcp = FabriqueFormulairesCali.creerFormulairesNcp(listeDemandesCojac, individu, contexteService);
    return listeNouveauxFormulairesNcp;
  }
}

/* Location:
 * Qualified Name:     CreationDemande
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */