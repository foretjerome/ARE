package fr.unedic.cali.dom;

import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.DureeCalendaire;

public class ElementConditionAge
{
  public static final int SATISFAIT = 0;
  public static final int NON_SATISFAIT = 1;
  public static final int SANS_OBJET = 2;
  private int m_etat;
  private int m_codeMotifEchec;
  private int m_nbTrimestre;
  private Damj m_dateAtteinteRetraite;
  private DureeCalendaire m_ageDemandeurEmploi;
  private DureeCalendaire m_ageMaxDepartRetraite;
  private DureeCalendaire m_ageMinDepartRetraite;
  private DureeCalendaire m_ageADateRetraite;
  
  public DureeCalendaire getAgeDemandeurEmploi()
  {
    return m_ageDemandeurEmploi;
  }
  
  public void setAgeDemandeurEmploi(DureeCalendaire p_ageDemandeurEmploi)
  {
    m_ageDemandeurEmploi = p_ageDemandeurEmploi;
  }
  
  public int getCodeMotifEchec()
  {
    return m_codeMotifEchec;
  }
  
  public void setCodeMotifEchec(int p_codeMotifEchec)
  {
    m_codeMotifEchec = p_codeMotifEchec;
  }
  
  public Damj getDateAtteinteRetraite()
  {
    return m_dateAtteinteRetraite;
  }
  
  public void setDateAtteinteRetraite(Damj p_dateAtteinteRetraite)
  {
    m_dateAtteinteRetraite = p_dateAtteinteRetraite;
  }
  
  public int getEtat()
  {
    return m_etat;
  }
  
  public void setEtat(int p_etat)
  {
    m_etat = p_etat;
  }
  
  public boolean estSatisfait()
  {
    return getEtat() == 0;
  }
  
  public int getNbTrimestre()
  {
    return m_nbTrimestre;
  }
  
  public void setNbTrimestre(int p_nbTrimestre)
  {
    m_nbTrimestre = p_nbTrimestre;
  }
  
  public DureeCalendaire getAgeMinDepartRetraite()
  {
    return m_ageMinDepartRetraite;
  }
  
  public void setAgeMinDepartRetraite(DureeCalendaire p_ageMinDepartRetraite)
  {
    m_ageMinDepartRetraite = p_ageMinDepartRetraite;
  }
  
  public DureeCalendaire getAgeMaxDepartRetraite()
  {
    return m_ageMaxDepartRetraite;
  }
  
  public void setAgeMaxDepartRetraite(DureeCalendaire p_ageMaxDepartRetraite)
  {
    m_ageMaxDepartRetraite = p_ageMaxDepartRetraite;
  }
  
  public DureeCalendaire getAgeADateRetraite()
  {
    return m_ageADateRetraite;
  }
  
  public void setAgeADateRetraite(DureeCalendaire p_ageADateRetraite)
  {
    m_ageADateRetraite = p_ageADateRetraite;
  }
}

/* Location:
 * Qualified Name:     ElementConditionAge
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */