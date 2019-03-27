package fr.unedic.cali.outilsfonctionnels.strategies;

import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.outilsfonctionnels.RechercherPeriodeIndemnisation;
import fr.unedic.cali.outilsfonctionnels.strategies.spec.StrategieDeterminationPeriodeIndemnisationSpec;
import fr.unedic.util.temps.Periode;

public class StrategieDeterminationPeriodeIndemnisationApres
  implements StrategieDeterminationPeriodeIndemnisationSpec
{
  public Periode recupererPeriodeIndemnisation(AttributionSpec p_attribution)
  {
    Periode periode = RechercherPeriodeIndemnisation.getPeriodeIndemnisationPourAttribution(p_attribution);
    if (periode == null) {
      periode = new Periode(p_attribution.getDateAttribution(), p_attribution.getDateAttribution());
    }
    return periode;
  }
  
  public Periode recupererPeriodeIndemnisee(AttributionSpec p_attribution)
  {
    return RechercherPeriodeIndemnisation.getPeriodeIndemnisationPourAttribution(p_attribution);
  }
}

/* Location:
 * Qualified Name:     StrategieDeterminationPeriodeIndemnisationApres
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */