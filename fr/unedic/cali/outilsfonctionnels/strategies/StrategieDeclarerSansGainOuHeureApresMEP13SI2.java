package fr.unedic.cali.outilsfonctionnels.strategies;

import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;

public class StrategieDeclarerSansGainOuHeureApresMEP13SI2
  implements StrategieDeclarerSansGainOuHeureSpec
{
  private static final BigDecimal PIVOT_DECLARE = new BigDecimal("0.90");
  private static final BigDecimal ZERO = new BigDecimal("0");
  
  public boolean comparerSansGainsHeuresDeclare(Damj p_datePivot, BigDecimal p_totalGainsJustifiees, BigDecimal p_totalGainsDeclares, BigDecimal p_totalHeuresJustifiees, BigDecimal p_totalHeuresDeclarees)
  {
    if (p_totalGainsDeclares.compareTo(ZERO) == 0) {
      return p_totalHeuresJustifiees.compareTo(p_totalHeuresDeclarees.multiply(PIVOT_DECLARE)) >= 0;
    }
    if (p_totalHeuresDeclarees.compareTo(ZERO) == 0) {
      return p_totalGainsJustifiees.compareTo(p_totalGainsDeclares.multiply(PIVOT_DECLARE)) >= 0;
    }
    return (p_totalGainsJustifiees.compareTo(p_totalGainsDeclares.multiply(PIVOT_DECLARE)) >= 0) || (p_totalHeuresJustifiees.compareTo(p_totalHeuresDeclarees.multiply(PIVOT_DECLARE)) >= 0);
  }
}

/* Location:
 * Qualified Name:     StrategieDeclarerSansGainOuHeureApresMEP13SI2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */