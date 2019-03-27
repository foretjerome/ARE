package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.util.temps.Damj;
import java.util.Comparator;

public class ComparateurSurDateAttribution
  implements Comparator
{
  public int compare(Object p_objet1, Object p_objet2)
    throws ClassCastException
  {
    AttributionSpec attribution1 = (AttributionSpec)p_objet1;
    AttributionSpec attribution2 = (AttributionSpec)p_objet2;
    Damj date1 = null;
    Damj date2 = null;
    
    date1 = attribution1.getDateAttribution();
    date2 = attribution2.getDateAttribution();
    
    return date1.compareTo(date2);
  }
}

/* Location:
 * Qualified Name:     ComparateurSurDateAttribution
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */