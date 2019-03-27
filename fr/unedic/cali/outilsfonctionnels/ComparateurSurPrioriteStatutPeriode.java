package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.cali.autresdoms.ga.dom.spec.TravailSpec;
import java.io.Serializable;
import java.util.Comparator;

public class ComparateurSurPrioriteStatutPeriode
  implements Comparator, Serializable
{
  public int compare(Object arg0, Object arg1)
  {
    TravailSpec periode1 = (TravailSpec)arg0;
    TravailSpec periode2 = (TravailSpec)arg1;
    
    Integer prioriteStatutPeriode1 = Integer.valueOf(periode1.getPrioriteStatut());
    Integer prioriteStatutPeriode2 = Integer.valueOf(periode2.getPrioriteStatut());
    
    return prioriteStatutPeriode1.compareTo(prioriteStatutPeriode2);
  }
}

/* Location:
 * Qualified Name:     ComparateurSurPrioriteStatutPeriode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */