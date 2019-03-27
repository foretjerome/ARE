package fr.unedic.cali.dom.affectation;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DossierExamenSpec;
import fr.unedic.cali.dom.FormuleMontantSpec;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;

public abstract class ProduitInrAbstrait
  extends ProduitAbstrait
  implements ProduitInrSpec
{
  protected ProduitInrDelegueSpec getProduitInrDelegue()
  {
    return (ProduitInrDelegueSpec)getProduitDelegue();
  }
  
  public int getTypePaiement()
  {
    return 0;
  }
  
  public Resultat traiterObjectifAdmission(Contexte p_contexte)
    throws ApplicativeException
  {
    if (getProduitInrDelegue() == null) {
      return null;
    }
    return getProduitInrDelegue().traiterObjectifAdmission(p_contexte);
  }
  
  public FormuleMontantSpec getFormuleMontant(String p_code)
  {
    if (getProduitInrDelegue() == null) {
      return null;
    }
    return getProduitInrDelegue().getFormuleMontant(p_code);
  }
  
  public BigDecimal getMontantJournalierAttributionArce(AttributionSpec p_attribution)
  {
    if (getProduitInrDelegue() == null) {
      return null;
    }
    return getProduitInrDelegue().getMontantJournalierAttributionArce(p_attribution);
  }
  
  public Damj getDateAttributionAreLiee(AttributionSpec p_attribution)
  {
    if (getProduitInrDelegue() == null) {
      return null;
    }
    return getProduitInrDelegue().getDateAttributionAreLiee(p_attribution);
  }
  
  public BigDecimal getMontantJournalierAttributionADR(AttributionSpec p_attribution)
  {
    if (getProduitInrDelegue() == null) {
      return null;
    }
    return getProduitInrDelegue().getMontantJournalierAttributionADR(p_attribution);
  }
  
  public BigDecimal getCapitalInitialAttributionADR(AttributionSpec p_attribution)
  {
    if (getProduitInrDelegue() == null) {
      return null;
    }
    return getProduitInrDelegue().getCapitalInitialAttributionADR(p_attribution);
  }
  
  public void alimenterDonneesComplementairesDossierExamen(DossierExamenSpec p_dossierExamenDecisionne)
  {
    if (getProduitInrDelegue() != null) {
      getProduitInrDelegue().alimenterDonneesComplementairesDossierExamen(p_dossierExamenDecisionne);
    }
  }
  
  public String determinerPeriodeGaecAChargerSurLectureDecision(DemandeSpec p_demandeDecisionne)
  {
    if (getProduitInrDelegue() == null) {
      return null;
    }
    return getProduitInrDelegue().determinerPeriodeGaecAChargerSurLectureDecision(p_demandeDecisionne);
  }
  
  public String determinerCodeSousProduitPourSigma(AttributionSpec p_attribution)
  {
    if (getProduitInrDelegue() == null) {
      return null;
    }
    return getProduitInrDelegue().determinerCodeSousProduitPourSigma(p_attribution);
  }
  
  public void verifierPrescription(DemandeSpec p_demande)
    throws CoucheLogiqueException
  {
    if (getProduitInrDelegue() != null) {
      getProduitInrDelegue().verifierPrescription(p_demande);
    }
  }
}

/* Location:
 * Qualified Name:     ProduitInrAbstrait
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */