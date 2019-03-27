package fr.unedic.cali.outilsfonctionnels.strategies.spec;

import fr.unedic.cali.outilsfonctionnels.strategies.StrategieEvolutionReglementaireSpec;
import java.math.BigDecimal;

public abstract interface StrategieA8A10ConfrontationGainHeureSpec
  extends StrategieEvolutionReglementaireSpec
{
  public static final BigDecimal PIVOT_90_POURCENT = new BigDecimal("0.90");
  
  public abstract boolean estSuperieurA90Pourcent(BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2, BigDecimal paramBigDecimal3, BigDecimal paramBigDecimal4);
}

/* Location:
 * Qualified Name:     StrategieA8A10ConfrontationGainHeureSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */