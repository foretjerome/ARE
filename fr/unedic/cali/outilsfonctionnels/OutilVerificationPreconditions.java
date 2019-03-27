package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.cali.dom.AttributionAssuranceSpec;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DossierExamenSpec;
import fr.unedic.cali.dom.EvenementReferenceExamenSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.fabriques.FabriqueStrategieRechargement;
import fr.unedic.cali.fabriques.FabriqueStrategieRevision;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreDateDeclenchementExamenAvantOuCoincideDateEtInclusParPriorite;
import fr.unedic.cali.outilsfonctionnels.strategies.CritereStrategie;
import fr.unedic.cali.outilsfonctionnels.strategies.spec.StrategieRechargementARE14Spec;
import fr.unedic.cali.outilsfonctionnels.strategies.spec.StrategieRevisionARE14Spec;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreAttributionSurDecisions;
import fr.unedic.cali.utilitaire.outils.OutilRecherche;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologieDebuts;
import fr.unedic.util.temps.Damj;
import java.util.List;

public class OutilVerificationPreconditions
{
  public static OutilVerificationPreconditions getInstance()
  {
    return new OutilVerificationPreconditions();
  }
  
  public void verifierPreconditions(DemandeSpec demandePrestationsCourante)
    throws CoucheLogiqueException
  {
    IndividuSpec demandeur = demandePrestationsCourante.getDemandeur();
    
    ChronologieDebuts chronoDemandesDuDemandeur = demandeur.getChronoDemandes();
    
    verifierBlocageManuelMF03(demandePrestationsCourante, demandeur);
    
    verifierBlocageIndemnisationConflitGaec(demandePrestationsCourante, demandeur);
    
    verifierBlocageActualisation(demandePrestationsCourante, demandeur);
    
    verifierConditionExamen(demandePrestationsCourante, chronoDemandesDuDemandeur);
    
    controlePresenceFinDroitObligatoire(demandePrestationsCourante, demandeur);
    
    controlePresenceDemandeRechargement(demandePrestationsCourante);
    
    controlePresenceDemandeRevision(demandePrestationsCourante);
    
    verifierTypePriseEnCharge(demandePrestationsCourante);
    
    verifierDemandeRechargementValidee(demandePrestationsCourante);
  }
  
  protected void verifierBlocageManuelMF03(DemandeSpec demandePrestationsCourante, IndividuSpec demandeur)
    throws CoucheLogiqueException
  {
    if ((demandeur.getDateBlocageIndemnisation() != null) && (demandePrestationsCourante.getDateExamen().estApresOuCoincideAvec(demandeur.getDateBlocageIndemnisation()))) {
      GestionnaireErreur.getInstance().genererCoucheLogiqueException("PR_CALI_L_ALERTE_A5AMB1");
    }
  }
  
  protected void verifierBlocageIndemnisationConflitGaec(DemandeSpec demandePrestationsCourante, IndividuSpec demandeur)
    throws CoucheLogiqueException
  {
    if ((demandeur.getDateBlocageIndemnisationConflitGAEC() != null) && (demandePrestationsCourante.getDateExamen().estApresOuCoincideAvec(demandeur.getDateBlocageIndemnisationConflitGAEC()))) {
      GestionnaireErreur.getInstance().genererCoucheLogiqueException("PR_CALI_L_ALERTE_ANOMALIE_CALCUL");
    }
  }
  
  protected void verifierBlocageActualisation(DemandeSpec demandePrestationsCourante, IndividuSpec demandeur)
    throws CoucheLogiqueException
  {
    if ((demandeur.getDateBlocageActualisation() != null) && (demandePrestationsCourante.getDateExamen().estApresOuCoincideAvec(demandeur.getDateBlocageActualisation()))) {
      GestionnaireErreur.getInstance().genererCoucheLogiqueException("PR_CALI_L_ALERTE_A5AMB2");
    }
  }
  
  public void verifierConditionExamen(DemandeSpec demandePrestationsCourante, Chronologie chronoDemandesDuDemandeur)
    throws CoucheLogiqueException
  {
    DemandeSpec demandePrestationsPrecedente = null;
    
    ChronologieDebuts chronoDemandesFiltrees = (ChronologieDebuts)chronoDemandesDuDemandeur.copier(new FiltreDateDeclenchementExamenAvantOuCoincideDateEtInclusParPriorite(demandePrestationsCourante.getDateDeclenchementExamen(), demandePrestationsCourante, demandePrestationsCourante.getEvenementReferenceExamen()));
    
    chronoDemandesFiltrees.supprimer(demandePrestationsCourante);
    if (chronoDemandesFiltrees != null)
    {
      chronoDemandesFiltrees.setComparateur(new ComparateurSurDateDeclenchementEtPrioriteDemande());
      chronoDemandesFiltrees.iterer();
      while (chronoDemandesFiltrees.encoreSuivant())
      {
        demandePrestationsPrecedente = (DemandeSpec)chronoDemandesFiltrees.elementSuivant();
        if (!demandePrestationsPrecedente.estClasseeOuDecisionneeValidee()) {
          GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_L_CONTEXTE_INITIAL_NON_VALIDE", new Object[] { demandePrestationsPrecedente.getEvenementReferenceExamen().getLibelleLong(), demandePrestationsPrecedente.getDateDeclenchementExamen() });
        }
        if (demandePrestationsPrecedente.estEnReExamen()) {
          GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_L_CONTEXTE_INITIAL_REEXAMEN", new Object[] { demandePrestationsPrecedente.getEvenementReferenceExamen().getLibelleLong(), demandePrestationsPrecedente.getDateDeclenchementExamen() });
        }
      }
    }
  }
  
  protected void controlePresenceDemandeRechargement(DemandeSpec demandePrestationsCourante)
    throws CoucheLogiqueException
  {
    CritereStrategie critere = new CritereStrategie();
    critere.setDatePivot(demandePrestationsCourante.getDateExamen());
    StrategieRechargementARE14Spec strategie = (StrategieRechargementARE14Spec)FabriqueStrategieRechargement.getInstance().getStrategie(critere);
    strategie.controlePresenceDemandeRechargement(demandePrestationsCourante);
  }
  
  protected void controlePresenceDemandeRevision(DemandeSpec demandePrestationsCourante)
    throws CoucheLogiqueException
  {
    CritereStrategie critere = new CritereStrategie();
    critere.setDatePivot(demandePrestationsCourante.getDateExamen());
    StrategieRevisionARE14Spec strategie = (StrategieRevisionARE14Spec)FabriqueStrategieRevision.getInstance().getStrategie(critere);
    strategie.controlePresenceDemandeRevision(demandePrestationsCourante);
  }
  
  protected void controlePresenceFinDroitObligatoire(DemandeSpec demandePrestationsCourante, IndividuSpec demandeur)
    throws CoucheLogiqueException
  {
    AttributionSpec attributionPrecedente = (AttributionSpec)OutilRecherche.rechercherDecisionPrecedente(demandePrestationsCourante.getChronologieDemandesAssuranceSansCourante(), demandePrestationsCourante, new FiltreAttributionSurDecisions(true));
    if (attributionPrecedente != null)
    {
      gestionErreurFinDroit(demandePrestationsCourante, attributionPrecedente);
      
      verificationAttributionPrecedente(demandePrestationsCourante);
      if ((!OutilAsp.estDemandeAspOuFinAsp(demandePrestationsCourante)) && (OutilAsp.estFinDroitAspNonInstalle(demandePrestationsCourante, (AttributionAssuranceSpec)attributionPrecedente))) {
        GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_A5MB5_MANQUE_FIN_ASP");
      }
      DossierExamenSpec attributionAspPrecedente = null;
      DemandeSpec demandeDecisionAsp = OutilAsp.getDemandeAspPrecedente(demandePrestationsCourante, demandePrestationsCourante.getDateRecherche());
      if (demandeDecisionAsp != null)
      {
        attributionAspPrecedente = (DossierExamenSpec)demandeDecisionAsp.getListeDossiersExamen().get(0);
        if (OutilDemande.estUneDemandeFinDroitAsp(demandePrestationsCourante))
        {
          DemandeSpec finAsp = OutilDroitAvecFinDroit.rechercherDemandeFinDroitSuivantDemandeNecessitantFinDroit(attributionAspPrecedente.getDemande(), demandePrestationsCourante);
          if ((finAsp != null) && (!finAsp.equals(demandePrestationsCourante))) {
            GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_ERR_FIN_ASP_DEJA_PRESENTE", new Object[] { attributionAspPrecedente.getDateAttribution() });
          }
        }
      }
    }
  }
  
  private void gestionErreurFinDroit(DemandeSpec demandePrestationsCourante, AttributionSpec attributionPrecedente)
    throws CoucheLogiqueException
  {
    boolean estFinAsrInstalle = !OutilAsr.estFinDroitAsrNonInstalle(demandePrestationsCourante, attributionPrecedente);
    if (OutilDemande.estUneDemandeBasculeAsrAtp(demandePrestationsCourante))
    {
      if ((OutilDemande.estUneDemandeFinDroitAsr(attributionPrecedente.getDemande())) && (estFinAsrInstalle)) {
        GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_ERR_FIN_ASR_DETECT ");
      }
    }
    else if (!estFinAsrInstalle) {
      GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_A5MB5_MANQUE_FIN_ASR");
    }
    if ((!OutilAtp.estDemandeAtpOuFinAtp(demandePrestationsCourante)) && (!OutilDemande.estUneDemandeFinancement(demandePrestationsCourante)) && (OutilAtp.estFinDroitAtpNonInstalle(demandePrestationsCourante, attributionPrecedente))) {
      GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_A5MB5_MANQUE_FIN_ATP ");
    }
  }
  
  private void verificationAttributionPrecedente(DemandeSpec demandePrestationsCourante)
    throws CoucheLogiqueException
  {
    DemandeSpec demandeAsrPrecedente = OutilAsr.getDemandeAsrPrecedente(demandePrestationsCourante, demandePrestationsCourante.getDateRecherche());
    if (demandeAsrPrecedente != null)
    {
      DossierExamenSpec attributionAsrPrecedente = (DossierExamenSpec)demandeAsrPrecedente.getListeDossiersExamen().get(0);
      if ((OutilDemande.estUneDemandeFinDroitAsr(demandePrestationsCourante)) && (OutilDroitAvecFinDroit.rechercherDemandeFinDroitSuivantDemandeNecessitantFinDroit(attributionAsrPrecedente.getDemande(), demandePrestationsCourante) != null)) {
        GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_ERR_FIN_ASR_DEJA_PRESENTE", new Object[] { attributionAsrPrecedente.getDateAttribution() });
      }
    }
    DemandeSpec demandeAtpPrecedente = OutilAtp.getDemandeAtpPrecedente(demandePrestationsCourante, demandePrestationsCourante.getDateRecherche());
    if (demandeAtpPrecedente != null)
    {
      DossierExamenSpec attributionAtpPrecedente = (DossierExamenSpec)demandeAtpPrecedente.getListeDossiersExamen().get(0);
      if ((OutilDemande.estUneDemandeFinDroitAtp(demandePrestationsCourante)) && (OutilDroitAvecFinDroit.rechercherDemandeFinDroitSuivantDemandeNecessitantFinDroit(attributionAtpPrecedente.getDemande(), demandePrestationsCourante) != null)) {
        GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_ERR_FIN_ATP_DEJA_PRESENTE", new Object[] { attributionAtpPrecedente.getDateAttribution() });
      }
    }
  }
  
  protected void verifierTypePriseEnChargeMayotte(DemandeSpec demandePrestationsCourante)
    throws CoucheLogiqueException
  {
    IndividuSpec demandeur = demandePrestationsCourante.getDemandeur();
    if (OutillagePEC.estPecMayotte(demandeur, demandePrestationsCourante.getDateExamen())) {
      GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_L_CONTEXTE_PEC_MAYOTTE", new Object[] { demandePrestationsCourante.getDateExamen() });
    }
  }
  
  protected void verifierTypePriseEnChargeMaintienEuropeen(DemandeSpec demandePrestationsCourante)
    throws CoucheLogiqueException
  {
    IndividuSpec demandeur = demandePrestationsCourante.getDemandeur();
    if (OutillagePEC.estPecDroitMaintenuAutreEtatMembreCoordination(demandeur, demandePrestationsCourante.getDateExamen())) {
      GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_L_CTX_MNT_EUROP_DROIT_MAINTENU_ETAT", new Object[] { demandePrestationsCourante.getDateExamen() });
    }
    if (OutillagePEC.estDoubleInscriptionFrontalierCoordination(demandeur, demandePrestationsCourante.getDateExamen())) {
      GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_L_CTX_MNT_EUROPEEN_DOUBLE_INSCRIPTION", new Object[] { demandePrestationsCourante.getDateExamen() });
    }
  }
  
  protected void verifierTypePriseEnCharge(DemandeSpec demandePrestationsCourante)
    throws CoucheLogiqueException
  {
    verifierTypePriseEnChargeMaintienEuropeen(demandePrestationsCourante);
    
    verifierTypePriseEnChargeMayotte(demandePrestationsCourante);
  }
  
  protected void verifierDemandeRechargementValidee(DemandeSpec demandeCourante)
    throws CoucheLogiqueException
  {}
}

/* Location:
 * Qualified Name:     OutilVerificationPreconditions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */