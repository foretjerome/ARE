package fr.unedic.cali.calcul.dom.temps;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class ObjetChronoPeriodeLimiteContratADR
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = 3963243144082534826L;
  
  public ObjetChronoPeriodeLimiteContratADR() {}
  
  public ObjetChronoPeriodeLimiteContratADR(Damj p_date)
  {
    super(p_date, p_date);
  }
  
  public ObjetMetierSpec copie()
  {
    ObjetChronoPeriodeLimiteContratADR copie = new ObjetChronoPeriodeLimiteContratADR();
    copieElements(copie);
    return copie;
  }
}

/* Location:
 * Qualified Name:     ObjetChronoPeriodeLimiteContratADR
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */