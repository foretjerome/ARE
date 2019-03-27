package fr.unedic.cali.autresdoms.ga.dom;

import fr.unedic.cali.autresdoms.ga.dom.spec.NonSalarieSpec;
import fr.unedic.cali.autresdoms.ga.dom.spec.TravailSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public abstract class TravailNonSalarie
  extends PeriodeGaec
  implements TravailSpec, NonSalarieSpec
{
  private int m_natureActivite;
  private String m_origineInfo;
  private boolean m_estAtteste;
  
  public TravailNonSalarie() {}
  
  public TravailNonSalarie(Damj p_dateDebut, Damj p_dateFin)
  {
    super(p_dateDebut, p_dateFin);
  }
  
  public TravailNonSalarie(Periode p_periode)
  {
    super(p_periode);
  }
  
  public boolean estEnConflit()
  {
    return false;
  }
  
  public void setEnConflit(boolean p_enConflit) {}
  
  public Damj getDateConnaissanceInfo()
  {
    return null;
  }
  
  public void setDateConnaissanceInfo(Damj p_date) {}
  
  public ObjetMetierSpec copie()
  {
    return null;
  }
  
  public int getNatureActivite()
  {
    return m_natureActivite;
  }
  
  public void setNatureActivite(int p_natureActivite)
  {
    m_natureActivite = p_natureActivite;
  }
  
  public boolean estAtteste()
  {
    return m_estAtteste;
  }
  
  public void setEstAtteste(boolean p_estAtteste)
  {
    m_estAtteste = p_estAtteste;
  }
  
  public boolean estParticipantLiquidation()
  {
    return true;
  }
  
  public int getTypePeriode()
  {
    return 30;
  }
  
  public String getOrigineInfo()
  {
    return m_origineInfo;
  }
  
  public void setOrigineInfo(String p_origineInfo)
  {
    m_origineInfo = p_origineInfo;
  }
  
  public int getPrioriteStatut()
  {
    return 100;
  }
}

/* Location:
 * Qualified Name:     TravailNonSalarie
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */