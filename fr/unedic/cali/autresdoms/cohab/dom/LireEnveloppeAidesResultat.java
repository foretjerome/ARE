package fr.unedic.cali.autresdoms.cohab.dom;

public class LireEnveloppeAidesResultat
{
  private boolean m_estEngagementPossible;
  private boolean m_estMontantInsuffisant;
  private String m_motifImpossibliteEngagement;
  
  public boolean estEngagementPossible()
  {
    return m_estEngagementPossible;
  }
  
  public void setEstEngagementPossible(boolean p_estEngagementPossible)
  {
    m_estEngagementPossible = p_estEngagementPossible;
  }
  
  public boolean estMontantInsuffisant()
  {
    return m_estMontantInsuffisant;
  }
  
  public void setEstMontantInsuffisant(boolean p_estMontantInsuffisant)
  {
    m_estMontantInsuffisant = p_estMontantInsuffisant;
  }
  
  public String getMotifImpossibiliteEngagement()
  {
    return m_motifImpossibliteEngagement;
  }
  
  public void setMotifImpossibiliteEngagement(String p_motifImpossibliteEngagement)
  {
    m_motifImpossibliteEngagement = p_motifImpossibliteEngagement;
  }
}

/* Location:
 * Qualified Name:     LireEnveloppeAidesResultat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */