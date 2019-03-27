package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.cali.autresdoms.ga.dom.Salaire;
import fr.unedic.util.temps.Damj;
import java.util.Comparator;

public class ComparateurPeriodeSalaires
  implements Comparator
{
  public int compare(Object p_arg0, Object p_arg1)
  {
    if (((p_arg0 instanceof Salaire)) && ((p_arg1 instanceof Salaire)))
    {
      Salaire periodeSal1 = (Salaire)p_arg0;
      Salaire periodeSal2 = (Salaire)p_arg1;
      
      Damj dateSalaire1 = periodeSal1.getDateDebut();
      Damj dateSalaire2 = periodeSal2.getDateDebut();
      if (dateSalaire1.estAvantOuCoincideAvec(dateSalaire2)) {
        return -1;
      }
      return 1;
    }
    return 0;
  }
}

/* Location:
 * Qualified Name:     ComparateurPeriodeSalaires
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */