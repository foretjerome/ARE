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

public abstract interface FacadeLiquidationProduitInrSpec
  extends FacadeLiquidationProduitSpec
{
  public abstract Resultat traiterObjectifAdmission(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Damj getDateAttributionAreLiee(AttributionSpec paramAttributionSpec);
  
  public abstract BigDecimal getMontantJournalierAttributionArce(AttributionSpec paramAttributionSpec);
  
  public abstract BigDecimal getMontantJournalierAttributionADR(AttributionSpec paramAttributionSpec);
  
  public abstract BigDecimal getCapitalInitialAttributionADR(AttributionSpec paramAttributionSpec);
  
  public abstract FormuleMontantSpec getFormuleMontant(String paramString);
  
  public abstract void alimenterDonneesComplementairesDossierExamen(DossierExamenSpec paramDossierExamenSpec);
  
  public abstract String determinerCodeSousProduitPourSigma(AttributionSpec paramAttributionSpec);
  
  public abstract void verifierPrescription(DemandeSpec paramDemandeSpec)
    throws CoucheLogiqueException;
}

/* Location:
 * Qualified Name:     FacadeLiquidationProduitInrSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */