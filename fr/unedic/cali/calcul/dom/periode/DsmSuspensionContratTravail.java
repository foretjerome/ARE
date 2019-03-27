package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeCalculTransient;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class DsmSuspensionContratTravail
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = 1L;
  private boolean m_isJustifiee;
  private transient boolean m_estMigree;
  private transient String m_origineInfo;
  
  protected DsmSuspensionContratTravail() {}
  
  public DsmSuspensionContratTravail(Damj p_dateDebut, Damj p_dateFin)
  {
    super(p_dateDebut, p_dateFin);
  }
  
  public void setJustifiee(boolean p_isJustifiee)
  {
    m_isJustifiee = p_isJustifiee;
  }
  
  public boolean isJustifiee()
  {
    return m_isJustifiee;
  }
  
  public ObjetMetierSpec copie()
  {
    DsmSuspensionContratTravail copie = new DsmSuspensionContratTravail();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    DsmSuspensionContratTravail copie = (DsmSuspensionContratTravail)p_copie;
    
    super.copieElements(copie);
    
    m_isJustifiee = isJustifiee();
    m_origineInfo = getOrigineInfo();
  }
  
  public boolean estMigree()
  {
    return m_estMigree;
  }
  
  public void setEstMigree(boolean p_estMigree)
  {
    m_estMigree = p_estMigree;
  }
  
  public String getOrigineInfo()
  {
    return m_origineInfo;
  }
  
  public void setOrigineInfo(String p_origine)
  {
    m_origineInfo = p_origine;
  }
}

/* Location:
 * Qualified Name:     DsmSuspensionContratTravail
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */