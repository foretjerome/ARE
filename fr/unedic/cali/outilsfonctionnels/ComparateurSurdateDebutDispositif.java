package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.cali.calcul.pbjc.dom.DispositifNcp;
import fr.unedic.util.temps.Damj;
import java.io.Serializable;
import java.util.Comparator;

public class ComparateurSurdateDebutDispositif
  implements Comparator, Serializable
{
  private static final long serialVersionUID = 6221401214136955597L;
  
  public int compare(Object arg0, Object arg1)
  {
    DispositifNcp dispositifNcp1 = (DispositifNcp)arg0;
    DispositifNcp dispositifNcp2 = (DispositifNcp)arg1;
    
    Damj dateDebut1 = dispositifNcp1.getDateDebutDispositif();
    Damj dateDebut2 = dispositifNcp2.getDateDebutDispositif();
    if (dateDebut1.estApres(dateDebut2)) {
      return -1;
    }
    if (dateDebut1.estAvant(dateDebut2)) {
      return 1;
    }
    return 1;
  }
}

/* Location:
 * Qualified Name:     ComparateurSurdateDebutDispositif
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */