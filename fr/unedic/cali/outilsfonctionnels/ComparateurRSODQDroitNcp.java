package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.cali.calcul.pbjc.dom.DroitPbjcNcp;
import java.util.Comparator;

public class ComparateurRSODQDroitNcp
  implements Comparator
{
  public int compare(Object p_arg0, Object p_arg1)
  {
    DroitPbjcNcp droitNcp1 = (DroitPbjcNcp)p_arg0;
    DroitPbjcNcp droitNcp2 = (DroitPbjcNcp)p_arg1;
    
    int rsod1 = droitNcp1.getIdentOuvertureDroit();
    int rsod2 = droitNcp2.getIdentOuvertureDroit();
    if (rsod1 >= rsod2) {
      return 0;
    }
    return 1;
  }
}

/* Location:
 * Qualified Name:     ComparateurRSODQDroitNcp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */