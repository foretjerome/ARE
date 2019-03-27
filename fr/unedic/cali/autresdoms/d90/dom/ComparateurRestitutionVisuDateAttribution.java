package fr.unedic.cali.autresdoms.d90.dom;

import fr.unedic.util.temps.Damj;
import java.util.Comparator;

public class ComparateurRestitutionVisuDateAttribution
  implements Comparator
{
  public int compare(Object p_arg0, Object p_arg1)
  {
    Demande demande1 = (Demande)p_arg0;
    Demande demande2 = (Demande)p_arg1;
    
    Damj dateAttribution1 = demande1.getDateAttribution();
    Damj dateAttribution2 = demande2.getDateAttribution();
    
    return -dateAttribution1.compareTo(dateAttribution2);
  }
}

/* Location:
 * Qualified Name:     ComparateurRestitutionVisuDateAttribution
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */