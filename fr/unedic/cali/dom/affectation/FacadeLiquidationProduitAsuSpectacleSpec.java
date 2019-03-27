package fr.unedic.cali.dom.affectation;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.spec.ComportementAffiliationSpec;
import fr.unedic.cali.liquidation.outilsfonctionnels.spec.OutilCalculDiffereStandardSpec;
import fr.unedic.cali.liquidation.outilsfonctionnels.spec.OutilPeriodeElementaireSpectacleSpec;
import fr.unedic.cali.liquidation.outilsfonctionnels.spec.ParametresFormuleSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.services.PasAssezInformationException;
import java.math.BigDecimal;

public abstract interface FacadeLiquidationProduitAsuSpectacleSpec
  extends FacadeLiquidationProduitAsuSpec
{
  public abstract OutilCalculDiffereStandardSpec getOutilCalculDiffereStandard();
  
  public abstract Quantite getDiffereStandard(DemandeSpec paramDemandeSpec, BigDecimal paramBigDecimal)
    throws PasAssezInformationException;
  
  public abstract ParametresFormuleSpec recupererParametresCarenceIndemnisationDiffereStandard();
  
  public abstract ComportementAffiliationSpec getComportementAffiliation();
  
  public abstract OutilPeriodeElementaireSpectacleSpec getOutilPeriodeElementaire();
}

/* Location:
 * Qualified Name:     FacadeLiquidationProduitAsuSpectacleSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */