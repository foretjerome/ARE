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

public abstract class ProduitRbfAbstrait
  extends ProduitAbstrait
  implements ProduitRbfSpec
{
  private static final long serialVersionUID = 146962573914366789L;
  
  private ProduitRbfDelegueSpec getProduitRbfDelegue()
  {
    return (ProduitRbfDelegueSpec)getProduitDelegue();
  }
  
  public Resultat traiterObjectifAdmission(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitRbfDelegue() == null) {
      return null;
    }
    return getProduitRbfDelegue().traiterObjectifAdmission(contexte);
  }
  
  public void alimenterDecisionsReexamen(DecisionSpec decisionAvant, DecisionSpec decisionApres, ArrayList liste)
    throws CoucheLogiqueException
  {
    if (getProduitRbfDelegue() != null) {
      getProduitRbfDelegue().alimenterDecisionsReexamen(decisionAvant, decisionApres, liste);
    }
  }
  
  public void alimenterBasePivotPeriodeLieu(DossierExamenSpec dossierExamen, int identifiantPeriodeLieu, PeriodeLieu periodeLieuBasePivot)
  {
    if (getProduitRbfDelegue() != null) {
      getProduitRbfDelegue().alimenterBasePivotPeriodeLieu(dossierExamen, identifiantPeriodeLieu, periodeLieuBasePivot);
    }
  }
  
  public Collection retournerListePeriodesHomogenes(DossierExamenSpec dossierExamen)
  {
    if (getProduitRbfDelegue() != null) {
      return getProduitRbfDelegue().retournerListePeriodesHomogenes(dossierExamen);
    }
    return null;
  }
  
  public Resultat constituerMontants(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitRbfDelegue() != null) {
      return getProduitRbfDelegue().constituerMontants(contexte);
    }
    return null;
  }
  
  public Resultat verificationConditionValiditeFormation(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitRbfDelegue() != null) {
      return getProduitRbfDelegue().verificationConditionValiditeFormation(contexte);
    }
    return null;
  }
  
  public Resultat verificationConditionBeneficeAutreProduit(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitRbfDelegue() == null) {
      return null;
    }
    return getProduitRbfDelegue().verificationConditionBeneficeAutreProduit(contexte);
  }
  
  public void alimenterDonneesComplementairesDossierExamen(DossierExamenSpec dossierExamenDecisionne, ActionFormationLiee actionFormationLiee)
  {
    if (getProduitRbfDelegue() != null) {
      getProduitRbfDelegue().alimenterDonneesComplementairesDossierExamen(dossierExamenDecisionne, actionFormationLiee);
    }
  }
  
  public String determinerPeriodeGaecAChargerSurLectureDecision(DemandeSpec demandeDecisionne)
  {
    if (getProduitRbfDelegue() == null) {
      return null;
    }
    return getProduitRbfDelegue().determinerPeriodeGaecAChargerSurLectureDecision(demandeDecisionne);
  }
  
  public String determinerCodeSousProduitPourSigma(AttributionSpec attribution)
  {
    if (getProduitRbfDelegue() == null) {
      return null;
    }
    return getProduitRbfDelegue().determinerCodeSousProduitPourSigma(attribution);
  }
  
  public List recupererListeAttributionsExecutables(AttributionSpec attribution)
  {
    if (getProduitRbfDelegue() != null) {
      return getProduitRbfDelegue().recupererListeAttributionsExecutables(attribution);
    }
    return null;
  }
  
  public List determinerListeDerogation(AttributionSpec attribution)
  {
    if (getProduitRbfDelegue() != null) {
      return getProduitRbfDelegue().determinerListeDerogation(attribution);
    }
    return null;
  }
  
  public String determinerTypeDerogation(AttributionSpec attribution)
  {
    if (getProduitRbfDelegue() != null) {
      return getProduitRbfDelegue().determinerTypeDerogation(attribution);
    }
    return null;
  }
  
  public ElementBaseIndemnisationSpec getElementBaseIndemnisation(AttributionSpec attribution)
  {
    if (getProduitRbfDelegue() != null) {
      return getProduitRbfDelegue().getElementBaseIndemnisation(attribution);
    }
    return null;
  }
  
  public void initialiserAnneeAffectation(DemandeSpec demande)
    throws CoucheLogiqueException
  {
    if (getProduitRbfDelegue() != null) {
      getProduitRbfDelegue().initialiserAnneeAffectation(demande);
    }
  }
  
  public void calculerMontantsAEngager(Contexte contexte)
    throws CoucheLogiqueException
  {
    if (getProduitRbfDelegue() != null) {
      getProduitRbfDelegue().calculerMontantsAEngager(contexte);
    }
  }
  
  public boolean estEligibleSimulationConditions(DemandeSpec demande)
  {
    if (getProduitRbfDelegue() != null) {
      return getProduitRbfDelegue().estEligibleSimulationConditions(demande);
    }
    return false;
  }
  
  public ResultatOutilCalculFraisEngages calculerFraisEngagesInitial(AttributionSpec attribution)
    throws ApplicativeException
  {
    throw new UnsupportedOperationException("Cette méthode ne doit être utilisé qu'en aide à la mobilité");
  }
  
  public void initialiserFraisEngagesInitiaux(AttributionSpec attribution)
    throws ApplicativeException
  {
    throw new UnsupportedOperationException("Cette méthode ne doit être utilisé qu'en aide à la mobilité");
  }
  
  public void forcerMontantADesengager(AttributionSpec attribution, BigDecimal montantADesengager)
    throws ApplicativeException
  {
    throw new UnsupportedOperationException("Cette méthode ne doit être utilisé qu'en aide à la mobilité");
  }
  
  public void traitementPostValidation(DemandeSpec demande)
    throws ApplicativeException
  {
    getProduitRbfDelegue().traitementPostValidation(demande);
  }
}

/* Location:
 * Qualified Name:     ProduitRbfAbstrait
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */