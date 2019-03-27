package fr.unedic.cali.autresdoms.ga.dom;

import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class DeclareSuspensionContratTravail
  extends PeriodeDeclare
{
  private static final long serialVersionUID = 1L;
  private transient String m_origineInfo;
  
  public DeclareSuspensionContratTravail(Periode p_periode)
  {
    super(p_periode);
  }
  
  public DeclareSuspensionContratTravail(Damj p_dateDebut, Damj p_dateFin)
  {
    super(p_dateDebut, p_dateFin);
  }
  
  public String getOrigineInfo()
  {
    return m_origineInfo;
  }
  
  public void setOrigineInfo(String p_origineInfo)
  {
    m_origineInfo = p_origineInfo;
  }
}

/* Location:
 * Qualified Name:     DeclareSuspensionContratTravail
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */