package fr.unedic.cali.calcul.dom.temps;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class ObjetChronoPeriodeLendemainDja
  extends ObjetChronoPeriodeCalculTransient
{
  private ObjetChronoPeriodeLendemainDja() {}
  
  public ObjetChronoPeriodeLendemainDja(Damj p_date)
  {
    super(p_date, p_date);
  }
  
  public ObjetMetierSpec copie()
  {
    ObjetChronoPeriodeLendemainDja copie = new ObjetChronoPeriodeLendemainDja();
    copieElements(copie);
    return copie;
  }
}

/* Location:
 * Qualified Name:     ObjetChronoPeriodeLendemainDja
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */