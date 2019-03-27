package fr.unedic.cali.outilsfonctionnels.strategies;

import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;

public class StrategieDeterminationPriseEnCompteGainSurPANSAvantMEP11SI1
  implements StrategieDeterminationPriseEnCompteGainSurPansSpec
{
  private static final BigDecimal PIVOT_DECLARE = new BigDecimal("0.90");
  
  public boolean priseEnCompteGainSurPANS()
  {
    return false;
  }
  
  public boolean comparerGainsHeuresDeclareJustifie(ProduitSpec produit, Damj datePivot, boolean pansSurMoisSeul, BigDecimal totalGainsJustifiees, BigDecimal totalGainsDeclares, BigDecimal totalHeuresJustifiees, BigDecimal totalHeuresDeclarees)
  {
    return (totalGainsJustifiees.compareTo(totalGainsDeclares.multiply(PIVOT_DECLARE)) >= 0) || (totalHeuresJustifiees.compareTo(totalHeuresDeclarees.multiply(PIVOT_DECLARE)) >= 0);
  }
}

/* Location:
 * Qualified Name:     StrategieDeterminationPriseEnCompteGainSurPANSAvantMEP11SI1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */