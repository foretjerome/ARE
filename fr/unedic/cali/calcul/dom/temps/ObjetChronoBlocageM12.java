package fr.unedic.cali.calcul.dom.temps;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class ObjetChronoBlocageM12
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = 1L;
  private String m_rsod;
  
  public ObjetChronoBlocageM12() {}
  
  public ObjetChronoBlocageM12(Damj p_date, String p_rsod)
  {
    super(p_date, p_date);
    setRsod(p_rsod);
  }
  
  public ObjetMetierSpec copie()
  {
    ObjetChronoBlocageM12 copie = new ObjetChronoBlocageM12();
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
 * Qualified Name:     ObjetChronoBlocageM12
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */