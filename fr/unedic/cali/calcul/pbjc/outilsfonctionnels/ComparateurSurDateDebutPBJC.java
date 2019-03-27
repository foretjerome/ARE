package fr.unedic.cali.calcul.pbjc.outilsfonctionnels;

import fr.unedic.cali.calcul.pbjc.dom.PbjcNcp;
import fr.unedic.util.temps.Damj;
import java.io.Serializable;
import java.util.Comparator;

public class ComparateurSurDateDebutPBJC
  implements Comparator, Serializable
{
  private static final long serialVersionUID = 1L;
  
  public int compare(Object p_arg0, Object p_arg1)
  {
    PbjcNcp pbjc1 = (PbjcNcp)p_arg0;
    PbjcNcp pbjc2 = (PbjcNcp)p_arg1;
    
    Damj date1 = pbjc1.getDateDebutPbjc();
    Damj date2 = pbjc2.getDateDebutPbjc();
    
    return date1.compareTo(date2);
  }
}

/* Location:
 * Qualified Name:     ComparateurSurDateDebutPBJC
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */