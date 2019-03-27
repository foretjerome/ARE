package fr.unedic.cali.parcours;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.autresdoms.cohab.dom.DemandeMigreeEnErreur;
import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.DecisionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.DossierAffectationSpec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.cali.dom.persistance.util.ContextePersistance;
import fr.unedic.cali.migration.FabriqueGrapheLiquidation;
import fr.unedic.cali.migration.GrapheLiquidationSpec;
import fr.unedic.cali.outilsfonctionnels.GestionnaireErreur;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreDemandesAff;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreNegation;
import fr.unedic.cohabitation.sigma.migration.dom.DemandeMigreeAsuV1;
import fr.unedic.util.services.ApplicativeRuntimeException;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteException;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.Parcours;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.FiltreTemporel;

public class ParcoursEnregistrerDecisionMigreeEnReexamen
  extends ParcoursServiceAbstrait
{
  public void controlerContexte(Contexte p_contexte)
    throws ContexteException
  {
    IndividuSpec individuCourant = getIndividu(p_contexte);
    if (individuCourant == null) {
      throw new ContexteException("HG_PR_CALI_L_ERR_CTX_ABS_DEMANDEUR", "Individu absent du contexte");
    }
    String idDemande = getIdDemande(p_contexte);
    if (idDemande == null) {
      throw new ContexteException("HG_PR_CALI_L_CONTEXTE_ABSENCE_DEMANDE_ASSURANCE", "Identifiant demande absente du contexte");
    }
    DemandeSpec demande = individuCourant.rechercherDemande(idDemande);
    if (demande == null) {
      throw new ContexteException("HG_PR_CALI_L_ERR_CONTEXTE", "Demande inexistante en base");
    }
    getDom(p_contexte).setDemande(demande);
  }
  
  public Resultat demarrerParcours(Contexte p_contexte)
    throws ApplicativeException
  {
    ResultatEnregistrerDecisionMigreeEnReexamen resultat = new ResultatEnregistrerDecisionMigreeEnReexamen();
    
    DemandeSpec demande = getDom(p_contexte).getDemande();
    if ((!demande.estMigree()) || (!demande.estEnReExamen()) || (!demande.estReexaminable())) {
      throw new CoucheLogiqueException("HG_PR_CALI_L_CONTEXTE_ABSENCE_DEMANDE_ASSURANCE", "La demande ne correspond pas aux critères : seulement les demandes migrées en réexamen non neutralisées");
    }
    if (demande.getNumeroGamme() != 1) {
      throw new CoucheLogiqueException("HG_PR_CALI_L_CONTEXTE_ABSENCE_DEMANDE_ASSURANCE", "La demande ne correspond pas aux critères : seulement les demandes d'Assurance migrées en réexamen et pas neutralisées");
    }
    verifierDecisionPrecedente(demande);
    
    DemandeSpec demandeCopie = (DemandeSpec)demande.copie();
    
    ProduitSpec produit = demande.getDossierAffectation().getProduit();
    boolean classementAdministratif = demande.getClassementAdministratif() != null;
    int natureDecision = 0;
    if (!classementAdministratif)
    {
      DecisionSpec decision = (DecisionSpec)demande.getDossierAffectation().getDossierExamen();
      
      natureDecision = decision.getNatureDecision();
    }
    GrapheLiquidationSpec graphe = FabriqueGrapheLiquidation.creerGraphe(produit.getNom(), classementAdministratif, natureDecision);
    
    DemandeMigreeEnErreur demandeEnErreur = new DemandeMigreeEnErreur();
    DemandeMigreeAsuV1 demandeAsuAEnregistrer = getDom(p_contexte).getDemandeAEnregistrer();
    
    graphe.enregistrerDemande(demandeAsuAEnregistrer, demande, demandeEnErreur);
    if (demandeEnErreur.getNiveauErreurGlobal() == 3)
    {
      try
      {
        ((ContextePersistance)ContextePersistance.getContexte()).modeSimulation();
      }
      catch (TechniqueException te)
      {
        throw new ApplicativeRuntimeException("", te);
      }
    }
    else
    {
      demande.setDemandeLiquidee(true);
      
      annulerReexamen(p_contexte);
      
      emettreCREM(p_contexte, demande, demandeCopie);
    }
    resultat.setListeErreurs(demandeEnErreur.getListeErreurs());
    
    return resultat;
  }
  
  private void annulerReexamen(Contexte p_contexte)
    throws ApplicativeException
  {
    Contexte contexteAnnulerReexamen = new Contexte();
    DomAnnulerReexamen domAnnulerReexamen = new DomAnnulerReexamen();
    domAnnulerReexamen.setContexteService(getDom(p_contexte).getContexteService());
    domAnnulerReexamen.setIdDemande(getDom(p_contexte).getIdDemande());
    domAnnulerReexamen.setIndividu(getDom(p_contexte).getIndividu());
    contexteAnnulerReexamen.setDonnees(domAnnulerReexamen);
    
    Parcours annulerReexamen = new ParcoursAnnulerReexamen();
    
    annulerReexamen.effectuerParcours(contexteAnnulerReexamen);
  }
  
  private void emettreCREM(Contexte p_contexte, DemandeSpec p_demandeApresModif, DemandeSpec p_demandeAvantModif)
    throws ApplicativeException
  {
    Contexte contexteCREM = new Contexte();
    DomLiquidationDemande dom = new DomLiquidationDemande();
    
    dom.setDemande(p_demandeApresModif);
    dom.setDemandeAvantReexamen(p_demandeAvantModif);
    dom.setContexteService(getDom(p_contexte).getContexteService());
    contexteCREM.setDonnees(dom);
    
    Parcours parcoursCREMLiquidation = new ParcoursCREMLiquidation();
    parcoursCREMLiquidation.effectuerParcours(contexteCREM);
  }
  
  private DomEnregistrerDecisionMigreeEnReexamen getDom(Contexte p_contexte)
  {
    return (DomEnregistrerDecisionMigreeEnReexamen)p_contexte.getDonnees();
  }
  
  private String getIdDemande(Contexte p_contexte)
  {
    return getDom(p_contexte).getIdDemande();
  }
  
  private void verifierDecisionPrecedente(DemandeSpec p_demande)
    throws CoucheLogiqueException
  {
    FiltreTemporel filtre = new FiltreNegation(new FiltreDemandesAff());
    
    DecisionSpec decisionPrecedente = p_demande.getDemandeur().getDecisionAvant(p_demande, filtre);
    if (decisionPrecedente != null) {
      if (!decisionPrecedente.getDemande().estMigree()) {
        GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_L_ANNULER_REEXAMEN_DECISION_PREC_NON");
      }
    }
  }
  
  protected int getModeChargementDebrayageDossiersLourds(Individu p_individu)
  {
    return 2;
  }
  
  protected void alimenterAgregatGaec(Individu p_individu, String p_idDemande)
  {
    if (p_individu != null) {
      p_individu.getDonneesChargementGaec().getAgregatGaec().setModeAppel(2);
    }
  }
  
  protected void controlerPostTraitement(Individu p_individu)
    throws AccesDonneesGaecException
  {
    controlerModeAppel(p_individu.getDonneesChargementGaec().getAppelGaecReduit(), 2);
  }
}

/* Location:
 * Qualified Name:     ParcoursEnregistrerDecisionMigreeEnReexamen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */