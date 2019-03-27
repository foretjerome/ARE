package fr.unedic.cali.outilsfonctionnels.strategies;

import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;

public abstract interface StrategieDeterminationPriseEnCompteGainSurPansSpec
  extends StrategieEvolutionReglementaireSpec
{
  public abstract boolean priseEnCompteGainSurPANS();
  
  public abstract boolean comparerGainsHeuresDeclareJustifie(ProduitSpec paramProduitSpec, Damj paramDamj, boolean paramBoolean, BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2, BigDecimal paramBigDecimal3, BigDecimal paramBigDecimal4)
    throws CoucheLogiqueException;
}

/* Location:
 * Qualified Name:     StrategieDeterminationPriseEnCompteGainSurPansSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */