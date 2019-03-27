package fr.unedic.cali.parcours;

import fr.unedic.util.services.Resultat;

public class ResultatNettoyage
  extends Resultat
{
  private boolean m_failure;
  
  public boolean isFailure()
  {
    return m_failure;
  }
  
  public void setFailure(boolean p_failure)
  {
    m_failure = p_failure;
  }
}

/* Location:
 * Qualified Name:     ResultatNettoyage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */