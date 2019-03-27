package fr.unedic.cali.outilsfonctionnels.strategies;

import java.math.BigDecimal;

public abstract interface StrategieDeterminationStatutUTGainHeureRenseigneSpec
  extends StrategieEvolutionReglementaireSpec
{
  public abstract boolean presenceGainHeureRenseigne(BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2, boolean paramBoolean1, boolean paramBoolean2);
}

/* Location:
 * Qualified Name:     StrategieDeterminationStatutUTGainHeureRenseigneSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */