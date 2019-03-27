package fr.unedic.cali.autresdoms.cohab.sigma.chaineliaison.dom;

import fr.unedic.cali.autresdoms.cohab.sigma.chaineliaison.dom.spec.ResultatChaineLiaisonSpec;

public class ResultatChaineLiaison
  implements ResultatChaineLiaisonSpec
{
  private boolean m_v1v2;
  private boolean m_v2v1;
  private boolean m_v2v2;
  
  public boolean isFluxV1V2Correct()
  {
    return m_v1v2;
  }
  
  public boolean isFluxV2V1Correct()
  {
    return m_v2v1;
  }
  
  public boolean isFluxV2V2Correct()
  {
    return m_v2v2;
  }
  
  public void setFluxV1V2Correct(boolean p_ok)
  {
    m_v1v2 = p_ok;
  }
  
  public void setFluxV2V1Correct(boolean p_ok)
  {
    m_v2v1 = p_ok;
  }
  
  public void setFluxV2V2Correct(boolean p_ok)
  {
    m_v2v2 = p_ok;
  }
}

/* Location:
 * Qualified Name:     ResultatChaineLiaison
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */