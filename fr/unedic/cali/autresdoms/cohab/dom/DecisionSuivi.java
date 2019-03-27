package fr.unedic.cali.autresdoms.cohab.dom;

import fr.unedic.util.temps.Damj;

public class DecisionSuivi
{
  private Damj m_dateEffet = null;
  private Damj m_dateFin = null;
  private int m_dureeDecision;
  private String m_natureDecision = null;
  private String m_natureSuspension = null;
  private String m_rsod = null;
  private int m_rangActualisation;
  private boolean m_chevauchementSanction;
  
  public boolean getChevauchementSanction()
  {
    return m_chevauchementSanction;
  }
  
  public void setChevauchementSanction(boolean p_chevauchementSanction)
  {
    m_chevauchementSanction = p_chevauchementSanction;
  }
  
  public void setDateFin(Damj p_dateFin)
  {
    m_dateFin = p_dateFin;
  }
  
  public void setDateEffet(Damj p_date)
  {
    m_dateEffet = p_date;
  }
  
  public void setDureeDecision(int p_decision)
  {
    m_dureeDecision = p_decision;
  }
  
  public void setNatureDecision(String p_decision)
  {
    m_natureDecision = p_decision;
  }
  
  public void setNatureSuspension(String p_natureSuspension)
  {
    m_natureSuspension = p_natureSuspension;
  }
  
  public void setRSOD(String p_rsod)
  {
    m_rsod = p_rsod;
  }
  
  public Damj getDateEffet()
  {
    return m_dateEffet;
  }
  
  public Damj getDateFin()
  {
    return m_dateFin;
  }
  
  public int getDureeDecision()
  {
    return m_dureeDecision;
  }
  
  public String getNatureDecision()
  {
    return m_natureDecision;
  }
  
  public String getNatureSuspension()
  {
    return m_natureSuspension;
  }
  
  public String getRSOD()
  {
    return m_rsod;
  }
  
  public int getRangActualisation()
  {
    return m_rangActualisation;
  }
  
  public void setRangActualisation(int p_rangActualisation)
  {
    m_rangActualisation = p_rangActualisation;
  }
}

/* Location:
 * Qualified Name:     DecisionSuivi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */