package fr.unedic.cali.autresdoms.cohab.sigma.enveloppe.dom;

import fr.unedic.cali.autresdoms.cohab.sigma.enveloppe.dom.spec.EnveloppeAidesSpec;

public class EnveloppeAides
  implements EnveloppeAidesSpec
{
  private static final long serialVersionUID = 1L;
  private boolean engagementPossible;
  private String m_motifImpossibliteEngagement;
  private boolean montantDisponibleInsuffisant;
  
  public EnveloppeAides()
  {
    engagementPossible = false;
    montantDisponibleInsuffisant = true;
  }
  
  public boolean isEngagementPossible()
  {
    return engagementPossible;
  }
  
  public void setEngagementPossible(boolean p_engagementPossible)
  {
    engagementPossible = p_engagementPossible;
  }
  
  public boolean isMontantDisponibleInsuffisant()
  {
    return montantDisponibleInsuffisant;
  }
  
  public void setMontantDisponibleInsuffisant(boolean p_montantDisponibleInsuffisant)
  {
    montantDisponibleInsuffisant = p_montantDisponibleInsuffisant;
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
 * Qualified Name:     EnveloppeAides
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */