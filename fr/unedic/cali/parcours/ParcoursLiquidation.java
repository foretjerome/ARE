package fr.unedic.cali.parcours;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.DemandeAbstraite;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DossierAffectationSpec;
import fr.unedic.cali.dom.EvenementReferenceExamenSpec;
import fr.unedic.cali.dom.FormulaireSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.cali.dom.persistance.util.ContextePersistance;
import fr.unedic.cali.migration.outilsfonctionnels.OutilsMigration;
import fr.unedic.cali.outilsfonctionnels.GestionnaireErreur;
import fr.unedic.cali.outilsfonctionnels.MiseEnReexamenDemande;
import fr.unedic.cali.outilsfonctionnels.OutilDemande;
import fr.unedic.cali.outilsfonctionnels.OutilDeterminationDateExamen;
import fr.unedic.cali.outilsfonctionnels.OutilVerificationPreconditions;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteException;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.Parcours;
import fr.unedic.util.temps.Damj;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public abstract class ParcoursLiquidation
  extends ParcoursServiceAbstrait
{
  public void controlerContexte(Contexte contexte)
    throws ContexteException
  {
    IndividuSpec individuCourant = getIndividu(contexte);
    if (individuCourant == null) {
      throw new ContexteException("HG_PR_CALI_L_ERR_CTX_ABS_DEMANDEUR", "Individu absent du contexte");
    }
    String idDemande = ((DomLiquidationDemande)contexte.getDonnees()).getIdDemande();
    if (idDemande == null) {
      throw new ContexteException("HG_PR_CALI_L_CONTEXTE_ABSENCE_DEMANDE_ASSURANCE", "Identifiant demande absente du contexte");
    }
    mettreAJourContexte(contexte);
    
    controlerContexteMigration(contexte);
    
    DemandeSpec demandeCourante = null;
    DomLiquidationDemande domCourant = (DomLiquidationDemande)contexte.getDonnees();
    if (domCourant.getDemandeSpec() == null) {
      demandeCourante = getIndividu(contexte).rechercherDemande(domCourant.getIdDemande());
    } else {
      demandeCourante = domCourant.getDemandeSpec();
    }
    ((DemandeAbstraite)demandeCourante).setLiquidationManuelleEnTP(((DomLiquidationDemande)contexte.getDonnees()).isLiquidationManuelleEnTP());
    
    detecterModeSimulation(demandeCourante, domCourant);
  }
  
  protected DemandeSpec getDemande(Contexte contexte)
  {
    return ((DomLiquidationDemande)contexte.getDonnees()).getDemandeSpec();
  }
  
  protected DemandeSpec getDemandeAvantReexamen(Contexte contexte)
  {
    return ((DomLiquidationDemande)contexte.getDonnees()).getDemandeAvantReexamen();
  }
  
  protected void mettreAJourContexte(Contexte contexte)
    throws ContexteException
  {
    DomLiquidationDemande domCourant = (DomLiquidationDemande)contexte.getDonnees();
    DemandeSpec demandeCourante = null;
    if (domCourant.getDemandeSpec() == null)
    {
      demandeCourante = getIndividu(contexte).rechercherDemande(domCourant.getIdDemande());
      if (demandeCourante == null) {
        throw new ContexteException("HG_PR_CALI_L_ERR_CONTEXTE", "Demande inexistante en base");
      }
      domCourant.setDemande(demandeCourante);
    }
    else
    {
      demandeCourante = domCourant.getDemandeSpec();
    }
    demandeCourante.setDemandeLiquidee(true);
  }
  
  protected void controlerContexteMigration(Contexte contexte)
    throws ContexteException
  {
    DomLiquidationDemande domCourant = (DomLiquidationDemande)contexte.getDonnees();
    DemandeSpec demande = domCourant.getDemandeSpec();
    if (OutilsMigration.blocageLiquidationDroitMigree(demande)) {
      if (OutilsMigration.estDroitSpectacle(demande)) {
        try
        {
          GestionnaireErreur.getInstance().genererException("HG_PR_CALI_L_CTX_LIQ_RENDRE_LIQUIDABLE_ARE_SPEC", 1);
        }
        catch (CoucheLogiqueException ex)
        {
          throw new ContexteException(ex.getCode(), ex.getLibelle(), ex);
        }
      } else {
        try
        {
          GestionnaireErreur.getInstance().genererException("HG_PR_CALI_L_CONTEXTE_LIQ_IMPOSSIBLE_DMD_MIGREE", 1);
        }
        catch (CoucheLogiqueException ex)
        {
          throw new ContexteException(ex.getCode(), ex.getLibelle(), ex);
        }
      }
    }
    if (demande.estMigree()) {
      demande.setMigree(0);
    }
  }
  
  protected void sauvegarderDonneesAvantReexamen(Contexte contexte)
    throws CoucheLogiqueException
  {
    DomLiquidationDemande domCourant = (DomLiquidationDemande)contexte.getDonnees();
    
    DemandeSpec demandeCourante = getDemande(contexte);
    
    DemandeSpec demandeCopie = (DemandeSpec)demandeCourante.copie();
    
    domCourant.setDemandeAvantReexamen(demandeCopie);
  }
  
  protected boolean isModeTp(Contexte contexte)
  {
    ContexteService contexteService = ((DomCali)contexte.getDonnees()).getContexteService();
    
    return contexteService.getContexteEmission().equalsIgnoreCase("TP");
  }
  
  protected void determinerCREMModificationLiquidation(Contexte contexte, ResultatServiceDemande resultatServiceDemande)
    throws ApplicativeException
  {
    boolean transactionPersistante = ContextePersistance.isPersistant();
    if ((transactionPersistante) && (isModeTp(contexte)))
    {
      ResultatCREMLiquidation resultat = new ResultatCREMLiquidation();
      
      Parcours parcoursCREMLiquidation = new ParcoursCREMLiquidation();
      resultat = (ResultatCREMLiquidation)parcoursCREMLiquidation.effectuerParcours(contexte);
      
      resultatServiceDemande.setListeComparaisonCREMDecision(resultat.getListeComparaisonCREMDecision());
      resultatServiceDemande.setListeComparaisonCREMConstituant(resultat.getListeComparaisonCREMConstituant());
      resultatServiceDemande.setCREM(resultat.getCREM());
    }
  }
  
  protected void verifierPreconditions(Contexte contexte)
    throws CoucheLogiqueException
  {
    DemandeSpec demandePrestationsCourante = getDemande(contexte);
    
    OutilVerificationPreconditions.getInstance().verifierPreconditions(demandePrestationsCourante);
  }
  
  protected Damj determinerDateExamen(Contexte contexte)
    throws ApplicativeException
  {
    DemandeSpec demande = getDemande(contexte);
    return OutilDeterminationDateExamen.getInstance().determinerDateExamen(demande);
  }
  
  protected void verifierPostContexte(DemandeSpec demande)
    throws CoucheLogiqueException
  {
    demande.getEvenementReferenceExamen().verifierPostContexte(demande);
  }
  
  protected void verifierContexte(DemandeSpec demande)
    throws ApplicativeException
  {
    demande.getEvenementReferenceExamen().verifierContexte(demande);
  }
  
  protected void verifierContexteExamen(DemandeSpec demande)
    throws ApplicativeException
  {
    demande.getEvenementReferenceExamen().verifierContexteExamen(demande);
  }
  
  private List alimenterDecisionsReexamen(Contexte contexte)
    throws CoucheLogiqueException
  {
    ProduitSpec produit = getDemande(contexte).getDossierAffectation().getProduit();
    return produit.alimenterDecisionsReexamen(contexte);
  }
  
  protected void alimenterDecisionsReexamen(Contexte contexte, ResultatServiceDemande resultat)
    throws CoucheLogiqueException
  {
    if ((((DomLiquidationDemande)contexte.getDonnees()).getDemandeAvantReexamen() != null) && (!OutilDemande.estUneDemandeFinDroitAsr(getDemande(contexte))) && (!OutilDemande.estUneDemandeFinDroitAsp(getDemande(contexte))) && (!OutilDemande.estUneDemandeFinDroitAtp(getDemande(contexte))))
    {
      DemandeSpec demandeAvant = ((DomLiquidationDemande)contexte.getDonnees()).getDemandeAvantReexamen();
      if (demandeAvant.getDossierAffectation().getDossierExamen() != null)
      {
        List listeDifferencesReexamen = alimenterDecisionsReexamen(contexte);
        if (listeDifferencesReexamen != null) {
          resultat.setListeDifferencesReexamen((ArrayList)listeDifferencesReexamen);
        }
      }
      if (((DomLiquidationDemande)contexte.getDonnees()).getDemandeAvantReexamen().estEnReExamen())
      {
        resultat.setListeMotifsReexamenAvantReexamen(getDemandeAvantReexamen(contexte).getListeMotifsReexamen());
        resultat.setMotifPrincipalReexamenAvantReexamen(getDemandeAvantReexamen(contexte).getMotifReexamenPrincipal());
      }
    }
  }
  
  protected void traitementPostLiquidation(Contexte contexte)
    throws CoucheLogiqueException
  {
    DemandeSpec demandeCourante = null;
    DomLiquidationDemande domCourant = (DomLiquidationDemande)contexte.getDonnees();
    if (domCourant.getDemandeSpec() == null)
    {
      demandeCourante = getIndividu(contexte).rechercherDemande(domCourant.getIdDemande());
      if (demandeCourante == null) {
        throw new ContexteException("HG_PR_CALI_L_ERR_CONTEXTE", "Demande inexistante en base");
      }
      domCourant.setDemande(demandeCourante);
    }
    else
    {
      demandeCourante = domCourant.getDemandeSpec();
    }
    demandeCourante.setDemandeLiquidee(false);
  }
  
  protected void traitementPreLiquidation(Contexte contexte)
    throws ContexteException
  {
    DemandeSpec demandeCourante = null;
    DomLiquidationDemande domCourant = (DomLiquidationDemande)contexte.getDonnees();
    if (domCourant.getDemandeSpec() == null) {
      demandeCourante = getIndividu(contexte).rechercherDemande(domCourant.getIdDemande());
    } else {
      demandeCourante = domCourant.getDemandeSpec();
    }
    if ((domCourant.isModeSimulation()) && (domCourant.getIdDemande() != null))
    {
      ParcoursMettreEnReexamenDemande parcoursReexamen = new ParcoursMettreEnReexamenDemande();
      try
      {
        parcoursReexamen.demarrerParcours(contexte);
      }
      catch (ApplicativeException ex)
      {
        demandeCourante.getAlertesNonBloquantes().put("REEXAMEN", null);
        MiseEnReexamenDemande.miseEnReexamen(demandeCourante);
      }
    }
    else
    {
      MiseEnReexamenDemande.miseEnReexamen(demandeCourante);
    }
    if (((DemandeAbstraite)demandeCourante).getDemandeEnEntreeService() == null) {
      ((DemandeAbstraite)demandeCourante).setDemandeEnEntreeService((DemandeSpec)demandeCourante.copie());
    }
  }
  
  protected void detecterModeSimulation(DemandeSpec demande, DomLiquidationDemande dom)
  {
    if ((!demande.estEnReExamen()) && (demande.estDecisionnee())) {
      dom.setModeSimulation(true);
    }
  }
  
  public void verifierRecevabiliteDAL(DemandeSpec demande)
    throws CoucheLogiqueException
  {
    if ((demande.getFormulaire().estDalNonRecevable()) && (demande.getClassementAdministratif() == null)) {
      GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_L_ERR_DAL_NON_RECEVABLE");
    }
  }
  
  protected int getModeAppelContexteSimulation(int modeAppel)
  {
    int retour = modeAppel;
    if (((DomLiquidationDemande)getDom()).isModeSimulation()) {
      retour = 2;
    }
    return retour;
  }
}

/* Location:
 * Qualified Name:     ParcoursLiquidation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */