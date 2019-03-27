package fr.unedic.cali.parcours;

import fr.unedic.cali.autresdoms.d90.dom.Individu;
import fr.unedic.cali.dom.IndicateursGeneriques;
import fr.unedic.util.services.Resultat;

public class ResultatReexecutionCali
  extends Resultat
{
  private static final long serialVersionUID = 4665221556406987268L;
  private boolean m_failure;
  private IndicateursGeneriques m_indicateursGeneriques;
  private Individu m_individuVisu;
  
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
  
  public Individu getIndividuVisu()
  {
    return m_individuVisu;
  }
  
  public void setIndividuVisu(Individu p_individuVisu)
  {
    m_individuVisu = p_individuVisu;
  }
}

/* Location:
 * Qualified Name:     ResultatReexecutionCali
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */