package fr.unedic.cali.calcul.dom.temps;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class ObjetChronoPeriodeLimiteIndemnisationASR
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = 1L;
  private String m_rsod;
  
  public ObjetChronoPeriodeLimiteIndemnisationASR() {}
  
  public ObjetChronoPeriodeLimiteIndemnisationASR(Damj p_date, String p_rsod)
  {
    super(p_date, p_date);
    setRsod(p_rsod);
  }
  
  public ObjetMetierSpec copie()
  {
    ObjetChronoPeriodeLimiteIndemnisationASR copie = new ObjetChronoPeriodeLimiteIndemnisationASR();
    copieElements(copie);
    return copie;
  }
  
  public String getRsod()
  {
    return m_rsod;
  }
  
  public void setRsod(String p_rsod)
  {
    m_rsod = p_rsod;
  }
}

/* Location:
 * Qualified Name:     ObjetChronoPeriodeLimiteIndemnisationASR
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */