package fr.unedic.cali.outilsfonctionnels.strategies;

import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;

public class StrategieConfrontationGainDeclareJustifie
  implements StrategieDeclarerSansGainOuHeureSpec
{
  private static final BigDecimal PIVOT_DECLARE = new BigDecimal("0.90");
  private static final BigDecimal ZERO = new BigDecimal("0");
  
  public boolean comparerSansGainsHeuresDeclare(Damj p_datePivot, BigDecimal totalGainsJustifiees, BigDecimal totalGainsDeclares, BigDecimal totalHeuresJustifiees, BigDecimal totalHeuresDeclarees)
  {
    if (totalGainsDeclares.compareTo(ZERO) == 0) {
      return totalHeuresJustifiees.compareTo(totalHeuresDeclarees.multiply(PIVOT_DECLARE)) >= 0;
    }
    return totalGainsJustifiees.compareTo(totalGainsDeclares.multiply(PIVOT_DECLARE)) >= 0;
  }
}

/* Location:
 * Qualified Name:     StrategieConfrontationGainDeclareJustifie
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */