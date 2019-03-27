package fr.unedic.cali.autresdoms.ga.dom;

import fr.unedic.util.temps.Periode;

public class ChequeEmploiService
  extends TravailSalarie
{
  boolean m_alsaceMoselle;
  
  public ChequeEmploiService(Periode p_periode)
  {
    super(p_periode);
  }
  
  public int getOrigineInformation()
  {
    return 3;
  }
  
  public boolean isAlsaceMoselle()
  {
    return m_alsaceMoselle;
  }
  
  public void setAlsaceMoselle(boolean p_alsaceMoselle)
  {
    m_alsaceMoselle = p_alsaceMoselle;
  }
  
  public boolean estQualifiable()
  {
    return false;
  }
  
  public int getPrioriteStatut()
  {
    return 3;
  }
}

/* Location:
 * Qualified Name:     ChequeEmploiService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */