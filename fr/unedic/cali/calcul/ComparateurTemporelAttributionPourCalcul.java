package fr.unedic.cali.calcul;

import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.util.temps.Damj;
import java.io.Serializable;
import java.util.Comparator;

public class ComparateurTemporelAttributionPourCalcul
  implements Comparator, Serializable
{
  public int compare(Object p_objet1, Object p_objet2)
    throws ClassCastException
  {
    AttributionSpec attribution1 = (AttributionSpec)p_objet1;
    AttributionSpec attribution2 = (AttributionSpec)p_objet2;
    Damj date1;
    Damj date1;
    if (!attribution1.estPjiEffectif()) {
      date1 = attribution1.getDateAttribution();
    } else {
      date1 = attribution1.getPji();
    }
    Damj date2;
    Damj date2;
    if (!attribution2.estPjiEffectif()) {
      date2 = attribution2.getDateAttribution();
    } else {
      date2 = attribution2.getPji();
    }
    return date1.compareTo(date2);
  }
}

/* Location:
 * Qualified Name:     ComparateurTemporelAttributionPourCalcul
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */