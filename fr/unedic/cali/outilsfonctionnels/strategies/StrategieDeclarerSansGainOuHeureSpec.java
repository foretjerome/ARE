package fr.unedic.cali.outilsfonctionnels.strategies;

import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;

public abstract interface StrategieDeclarerSansGainOuHeureSpec
  extends StrategieEvolutionReglementaireSpec
{
  public abstract boolean comparerSansGainsHeuresDeclare(Damj paramDamj, BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2, BigDecimal paramBigDecimal3, BigDecimal paramBigDecimal4);
}

/* Location:
 * Qualified Name:     StrategieDeclarerSansGainOuHeureSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */