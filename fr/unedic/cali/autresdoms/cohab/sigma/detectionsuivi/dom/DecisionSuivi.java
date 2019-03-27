package fr.unedic.cali.autresdoms.cohab.sigma.detectionsuivi.dom;

import fr.unedic.cali.autresdoms.cohab.sigma.detectionsuivi.dom.spec.DecisionSuiviSpec;
import fr.unedic.util.temps.Damj;

public class DecisionSuivi
  implements DecisionSuiviSpec
{
  private Damj m_dateEffet = null;
  private Damj m_dateFin = null;
  private int m_dureeDecision = 0;
  private String m_natureDecision = null;
  private String m_natureSuspension = null;
  private String m_identifiantOuvertureDroit = null;
  private int m_rangProlongation = 0;
  private boolean m_chevauchementSanction;
  
  public boolean getChevauchementSanction()
  {
    return m_chevauchementSanction;
  }
  
  public void setChevauchementSanction(boolean p_chevauchementSanction)
  {
    m_chevauchementSanction = p_chevauchementSanction;
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
  
  public String getIdentifiantOuvertureDroit()
  {
    return m_identifiantOuvertureDroit;
  }
  
  public String getNatureDecision()
  {
    return m_natureDecision;
  }
  
  public String getNatureSuspension()
  {
    return m_natureSuspension;
  }
  
  public int getRangProlongation()
  {
    return m_rangProlongation;
  }
  
  public void setDateEffet(Damj p_dateEffet)
  {
    m_dateEffet = p_dateEffet;
  }
  
  public void setDateFin(Damj p_dateFin)
  {
    m_dateFin = p_dateFin;
  }
  
  public void setDureeDecision(int p_dureeDecision)
  {
    m_dureeDecision = p_dureeDecision;
  }
  
  public void setIdentifiantOuvertureDroit(String p_identifiantOuvertureDroit)
  {
    m_identifiantOuvertureDroit = p_identifiantOuvertureDroit;
  }
  
  public void setNatureDecision(String p_natureDecision)
  {
    m_natureDecision = p_natureDecision;
  }
  
  public void setNatureSuspension(String p_natureSuspension)
  {
    m_natureSuspension = p_natureSuspension;
  }
  
  public void setRangProlongation(int p_rangProlongation)
  {
    m_rangProlongation = p_rangProlongation;
  }
}

/* Location:
 * Qualified Name:     DecisionSuivi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */