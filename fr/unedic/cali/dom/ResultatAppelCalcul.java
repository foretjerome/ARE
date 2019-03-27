package fr.unedic.cali.dom;

import fr.unedic.cali.parcours.ResultatVisualisationCalcul;

public class ResultatAppelCalcul
{
  private boolean m_isExecutionTerminee = false;
  private ResultatVisualisationCalcul m_resultatVisualisationCalcul;
  
  public boolean isExecutionTerminee()
  {
    return m_isExecutionTerminee;
  }
  
  public void setExecutionTerminee(boolean p_isExecutionTerminee)
  {
    m_isExecutionTerminee = p_isExecutionTerminee;
  }
  
  public ResultatVisualisationCalcul getResultatVisualisationCalcul()
  {
    return m_resultatVisualisationCalcul;
  }
  
  public void setResultatVisualisationCalcul(ResultatVisualisationCalcul p_resultatVisualisationCalcul)
  {
    m_resultatVisualisationCalcul = p_resultatVisualisationCalcul;
  }
}

/* Location:
 * Qualified Name:     ResultatAppelCalcul
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */