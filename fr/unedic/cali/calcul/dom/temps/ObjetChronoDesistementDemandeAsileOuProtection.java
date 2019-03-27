package fr.unedic.cali.calcul.dom.temps;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class ObjetChronoDesistementDemandeAsileOuProtection
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = 8812192414366603046L;
  private Damj m_dateEffet;
  private String m_rsod;
  
  private ObjetChronoDesistementDemandeAsileOuProtection() {}
  
  public ObjetChronoDesistementDemandeAsileOuProtection(Damj p_date, String p_rsod)
  {
    super(p_date, p_date);
    setPeriode(new Periode(p_date, p_date));
    setRsod(p_rsod);
  }
  
  public Damj getDateEffet()
  {
    return m_dateEffet;
  }
  
  public void setDateEffet(Damj p_dateEffet)
  {
    m_dateEffet = p_dateEffet;
  }
  
  public ObjetMetierSpec copie()
  {
    ObjetChronoDesistementDemandeAsileOuProtection copie = new ObjetChronoDesistementDemandeAsileOuProtection();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    ObjetChronoDesistementDemandeAsileOuProtection copie = (ObjetChronoDesistementDemandeAsileOuProtection)p_copie;
    super.copieElements(copie);
    copie.setDateEffet(getDateEffet());
    copie.setRsod(getRsod());
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
 * Qualified Name:     ObjetChronoDesistementDemandeAsileOuProtection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */