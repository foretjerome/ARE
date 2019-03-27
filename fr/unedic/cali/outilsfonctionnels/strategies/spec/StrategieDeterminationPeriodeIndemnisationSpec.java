package fr.unedic.cali.outilsfonctionnels.strategies.spec;

import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieCorrectionSpec;
import fr.unedic.util.temps.Periode;

public abstract interface StrategieDeterminationPeriodeIndemnisationSpec
  extends StrategieCorrectionSpec
{
  public abstract Periode recupererPeriodeIndemnisation(AttributionSpec paramAttributionSpec);
  
  public abstract Periode recupererPeriodeIndemnisee(AttributionSpec paramAttributionSpec);
}

/* Location:
 * Qualified Name:     StrategieDeterminationPeriodeIndemnisationSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */