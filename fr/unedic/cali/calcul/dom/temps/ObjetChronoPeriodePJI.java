package fr.unedic.cali.calcul.dom.temps;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class ObjetChronoPeriodePJI
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = 1206507252501271972L;
  
  public ObjetChronoPeriodePJI() {}
  
  public ObjetChronoPeriodePJI(Damj p_date)
  {
    super(p_date, p_date);
  }
  
  public ObjetMetierSpec copie()
  {
    ObjetChronoPeriodePJI copie = new ObjetChronoPeriodePJI();
    copieElements(copie);
    return copie;
  }
}

/* Location:
 * Qualified Name:     ObjetChronoPeriodePJI
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */