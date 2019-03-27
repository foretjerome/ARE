package fr.unedic.cali.outilsfonctionnels.strategies;

import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;

public abstract interface StrategieDeterminationStatutUTConversionHeureSpec
  extends StrategieEvolutionReglementaireSpec
{
  public abstract boolean conversionHeureBS(ChronologiePeriodes paramChronologiePeriodes, Damj paramDamj, AttributionSpec paramAttributionSpec);
}

/* Location:
 * Qualified Name:     StrategieDeterminationStatutUTConversionHeureSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */