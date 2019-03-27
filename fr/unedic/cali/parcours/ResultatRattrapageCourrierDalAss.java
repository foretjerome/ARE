package fr.unedic.cali.parcours;

import fr.unedic.cali.dom.IndicateursGeneriques;
import fr.unedic.util.services.Resultat;

public class ResultatRattrapageCourrierDalAss
  extends Resultat
{
  private boolean m_failure;
  private IndicateursGeneriques m_indicateursGeneriques;
  
  public boolean isFailure()
  {
    return m_failure;
  }
  
  public void setFailure(boolean p_failure)
  {
    m_failure = p_failure;
  }
  
  public IndicateursGeneriques getIndicateursGeneriques()
  {
    return m_indicateursGeneriques;
  }
  
  public void setIndicateursGeneriques(IndicateursGeneriques p_indicateursGeneriques)
  {
    m_indicateursGeneriques = p_indicateursGeneriques;
  }
}

/* Location:
 * Qualified Name:     ResultatRattrapageCourrierDalAss
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */