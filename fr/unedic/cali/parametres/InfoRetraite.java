package fr.unedic.cali.parametres;

import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.DureeCalendaire;

public class InfoRetraite
{
  private int m_nbTrimestreRequisAvantPivot;
  private int m_nbTrimestreRequisApresPivot;
  private int m_nbTrimestrePivot;
  private DureeCalendaire m_ageMinDepart;
  private DureeCalendaire m_ageMaxDepart;
  private Damj m_dateMinDepart;
  private Damj m_dateMaxDepart;
  private Damj m_datePivot;
  
  public InfoRetraite(int p_nbTrimestreRequisApresPivot, int p_nbTrimestreRequisAvantPivot, int p_nbTrimestrePivot, DureeCalendaire p_ageMinDepart, DureeCalendaire p_ageMaxDepart, Damj p_datePivot, Damj p_dateMinDepart, Damj p_dateMaxDepart)
  {
    m_nbTrimestreRequisApresPivot = p_nbTrimestreRequisApresPivot;
    m_datePivot = p_datePivot;
    m_nbTrimestrePivot = p_nbTrimestrePivot;
    m_nbTrimestreRequisAvantPivot = p_nbTrimestreRequisAvantPivot;
    m_ageMinDepart = p_ageMinDepart;
    m_ageMaxDepart = p_ageMaxDepart;
    m_dateMinDepart = p_dateMinDepart;
    m_dateMaxDepart = p_dateMaxDepart;
  }
  
  public void setNbTrimestreRequisAvantPivot(int p_nbTrimestreRequisAvantPivot)
  {
    m_nbTrimestreRequisAvantPivot = p_nbTrimestreRequisAvantPivot;
  }
  
  public int getNbTrimestreRequisAvantPivot()
  {
    return m_nbTrimestreRequisAvantPivot;
  }
  
  public void setDatePivot(Damj p_datePivot)
  {
    m_datePivot = p_datePivot;
  }
  
  public Damj getDatePivot()
  {
    return m_datePivot;
  }
  
  public void setNbTrimestrePivot(int p_nbTrimestrePivot)
  {
    m_nbTrimestrePivot = p_nbTrimestrePivot;
  }
  
  public int getNbTrimestrePivot()
  {
    return m_nbTrimestrePivot;
  }
  
  public void setNbTrimestreRequisApresPivot(int p_nbTrimestreRequisApresPivot)
  {
    m_nbTrimestreRequisApresPivot = p_nbTrimestreRequisApresPivot;
  }
  
  public int getNbTrimestreRequisApresPivot()
  {
    return m_nbTrimestreRequisApresPivot;
  }
  
  public void setAgeMinDepart(DureeCalendaire p_ageMinDepart)
  {
    m_ageMinDepart = p_ageMinDepart;
  }
  
  public DureeCalendaire getAgeMinDepart()
  {
    return m_ageMinDepart;
  }
  
  public void setAgeMaxDepart(DureeCalendaire p_ageMaxDepart)
  {
    m_ageMaxDepart = p_ageMaxDepart;
  }
  
  public DureeCalendaire getAgeMaxDepart()
  {
    return m_ageMaxDepart;
  }
  
  public void setDateMinDepart(Damj p_dateMinDepart)
  {
    m_dateMinDepart = p_dateMinDepart;
  }
  
  public Damj getDateMinDepart()
  {
    return m_dateMinDepart;
  }
  
  public void setDateMaxDepart(Damj p_dateMaxDepart)
  {
    m_dateMaxDepart = p_dateMaxDepart;
  }
  
  public Damj getDateMaxDepart()
  {
    return m_dateMaxDepart;
  }
}

/* Location:
 * Qualified Name:     InfoRetraite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */