package fr.unedic.cali.calcul.dom.temps;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class ObjetChronoPeriodeLimiteIndemnisationACO
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = 1L;
  private String m_rsod;
  
  public ObjetChronoPeriodeLimiteIndemnisationACO() {}
  
  public ObjetChronoPeriodeLimiteIndemnisationACO(Damj p_date, String p_rsod)
  {
    super(p_date, p_date);
    setRsod(p_rsod);
  }
  
  public String getRsod()
  {
    return m_rsod;
  }
  
  public void setRsod(String p_rsod)
  {
    m_rsod = p_rsod;
  }
  
  public ObjetMetierSpec copie()
  {
    ObjetChronoPeriodeLimiteIndemnisationACO copie = new ObjetChronoPeriodeLimiteIndemnisationACO();
    copieElements(copie);
    return copie;
  }
}

/* Location:
 * Qualified Name:     ObjetChronoPeriodeLimiteIndemnisationACO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */