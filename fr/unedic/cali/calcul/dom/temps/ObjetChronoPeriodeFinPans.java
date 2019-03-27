package fr.unedic.cali.calcul.dom.temps;

import fr.unedic.cali.autresdoms.ga.dom.PeriodeActiviteNonSalariePeriodique;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class ObjetChronoPeriodeFinPans
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = 6498536466520341677L;
  private PeriodeActiviteNonSalariePeriodique m_pansInitiale;
  
  private ObjetChronoPeriodeFinPans() {}
  
  public ObjetChronoPeriodeFinPans(Damj p_date)
  {
    super(p_date, p_date);
  }
  
  public PeriodeActiviteNonSalariePeriodique getPansInitiale()
  {
    return m_pansInitiale;
  }
  
  public void setPansInitiale(PeriodeActiviteNonSalariePeriodique p_pansInitiale)
  {
    m_pansInitiale = p_pansInitiale;
  }
  
  public ObjetMetierSpec copie()
  {
    ObjetChronoPeriodeFinPans copie = new ObjetChronoPeriodeFinPans();
    copieElements(copie);
    return copie;
  }
}

/* Location:
 * Qualified Name:     ObjetChronoPeriodeFinPans
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */