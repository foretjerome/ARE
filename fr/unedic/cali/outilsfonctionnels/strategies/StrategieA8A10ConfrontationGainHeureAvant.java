package fr.unedic.cali.outilsfonctionnels.strategies;

import fr.unedic.cali.outilsfonctionnels.strategies.spec.StrategieA8A10ConfrontationGainHeureSpec;
import java.math.BigDecimal;

public class StrategieA8A10ConfrontationGainHeureAvant
  implements StrategieA8A10ConfrontationGainHeureSpec
{
  public boolean estSuperieurA90Pourcent(BigDecimal justificationHeure, BigDecimal justificationGain, BigDecimal declarationHeure, BigDecimal declarationGain)
  {
    return (justificationGain.compareTo(declarationGain.multiply(PIVOT_90_POURCENT)) >= 0) || (justificationHeure.compareTo(declarationHeure.multiply(PIVOT_90_POURCENT)) >= 0);
  }
}

/* Location:
 * Qualified Name:     StrategieA8A10ConfrontationGainHeureAvant
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */