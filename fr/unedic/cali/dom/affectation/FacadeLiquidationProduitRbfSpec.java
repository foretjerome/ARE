package fr.unedic.cali.dom.affectation;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.ActionFormationLiee;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DecisionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DossierExamenSpec;
import fr.unedic.cali.dom.ElementBaseIndemnisationSpec;
import fr.unedic.cali.dom.ResultatOutilCalculFraisEngages;
import fr.unedic.cali.dom.pivot.PeriodeLieu;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.Resultat;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract interface FacadeLiquidationProduitRbfSpec
  extends FacadeLiquidationProduitSpec
{
  public abstract Resultat traiterObjectifAdmission(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract void alimenterDecisionsReexamen(DecisionSpec paramDecisionSpec1, DecisionSpec paramDecisionSpec2, ArrayList paramArrayList)
    throws CoucheLogiqueException;
  
  public abstract void alimenterBasePivotPeriodeLieu(DossierExamenSpec paramDossierExamenSpec, int paramInt, PeriodeLieu paramPeriodeLieu);
  
  public abstract Collection retournerListePeriodesHomogenes(DossierExamenSpec paramDossierExamenSpec);
  
  public abstract Resultat constituerMontants(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Resultat verificationConditionValiditeFormation(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Resultat verificationConditionBeneficeAutreProduit(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract void alimenterDonneesComplementairesDossierExamen(DossierExamenSpec paramDossierExamenSpec, ActionFormationLiee paramActionFormationLiee);
  
  public abstract String determinerCodeSousProduitPourSigma(AttributionSpec paramAttributionSpec);
  
  public abstract List recupererListeAttributionsExecutables(AttributionSpec paramAttributionSpec);
  
  public abstract List determinerListeDerogation(AttributionSpec paramAttributionSpec);
  
  public abstract String determinerTypeDerogation(AttributionSpec paramAttributionSpec);
  
  public abstract ElementBaseIndemnisationSpec getElementBaseIndemnisation(AttributionSpec paramAttributionSpec);
  
  public abstract void initialiserAnneeAffectation(DemandeSpec paramDemandeSpec)
    throws CoucheLogiqueException;
  
  public abstract void calculerMontantsAEngager(Contexte paramContexte)
    throws CoucheLogiqueException;
  
  public abstract boolean estEligibleSimulationConditions(DemandeSpec paramDemandeSpec);
  
  public abstract ResultatOutilCalculFraisEngages calculerFraisEngagesInitial(AttributionSpec paramAttributionSpec)
    throws ApplicativeException;
  
  public abstract void initialiserFraisEngagesInitiaux(AttributionSpec paramAttributionSpec)
    throws ApplicativeException;
  
  public abstract void forcerMontantADesengager(AttributionSpec paramAttributionSpec, BigDecimal paramBigDecimal)
    throws ApplicativeException;
  
  public abstract void traitementPostValidation(DemandeSpec paramDemandeSpec)
    throws ApplicativeException;
}

/* Location:
 * Qualified Name:     FacadeLiquidationProduitRbfSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */