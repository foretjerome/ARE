package fr.unedic.cali.outilsfonctionnels.strategies;

import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculSpec;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.outilsfonctionnels.strategies.spec.StrategieDeterminationPeriodeIndemnisationSpec;
import fr.unedic.util.temps.Periode;

public class StrategieDeterminationPeriodeIndemnisationAvant
  implements StrategieDeterminationPeriodeIndemnisationSpec
{
  public Periode recupererPeriodeIndemnisation(AttributionSpec p_attribution)
  {
    Periode periode = new Periode(p_attribution.getDateAttribution(), p_attribution.getDateAttribution());
    
    CalendrierExecutionCalculSpec calendrier = p_attribution.getCalendrierExecutionCalcul();
    if ((calendrier != null) && (calendrier.getDernierJourIndemnisable() != null)) {
      periode.setFin(calendrier.getDernierJourIndemnisable());
    }
    return periode;
  }
  
  public Periode recupererPeriodeIndemnisee(AttributionSpec p_attribution)
  {
    Periode periode = null;
    CalendrierExecutionCalculSpec calendrier = p_attribution.getCalendrierExecutionCalcul();
    if ((calendrier != null) && (calendrier.getDernierJourIndemnisable() != null)) {
      periode = new Periode(p_attribution.getDateAttribution(), calendrier.getDernierJourIndemnisable());
    }
    return periode;
  }
}

/* Location:
 * Qualified Name:     StrategieDeterminationPeriodeIndemnisationAvant
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */