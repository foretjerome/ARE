package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.util.temps.Damj;

public class Anomalie
{
  private String m_code;
  private Damj m_date;
  private String m_donnees;
  
  public Anomalie(String p_code, Damj p_date, String p_donnees)
  {
    m_code = p_code;
    m_date = p_date;
    m_donnees = p_donnees;
  }
  
  public String getCode()
  {
    return m_code;
  }
  
  public Damj getDate()
  {
    return m_date;
  }
  
  public String getDonnees()
  {
    return m_donnees;
  }
  
  public boolean estAnomalieBloquant()
  {
    boolean estBloquant = false;
    if (("M01".equals(m_code)) || ("M02".equals(m_code)) || ("M03".equals(m_code)) || ("M04".equals(m_code)) || ("M05".equals(m_code)) || ("M06".equals(m_code)) || ("M07".equals(m_code)) || ("M08".equals(m_code)) || ("M09".equals(m_code)) || ("M10".equals(m_code)) || ("M11".equals(m_code))) {
      estBloquant = true;
    }
    return estBloquant;
  }
}

/* Location:
 * Qualified Name:     Anomalie
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */