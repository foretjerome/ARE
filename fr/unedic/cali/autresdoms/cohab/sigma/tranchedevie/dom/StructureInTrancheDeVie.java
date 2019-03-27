package fr.unedic.cali.autresdoms.cohab.sigma.tranchedevie.dom;

import fr.unedic.cali.autresdoms.cohab.sigma.tranchedevie.dom.spec.StructureInTrancheDeVieSpec;

public class StructureInTrancheDeVie
  implements StructureInTrancheDeVieSpec
{
  private String m_codeAssedic;
  private String m_identifiantNCP;
  private String m_RSIN;
  
  public String getCodeAssedic()
  {
    return m_codeAssedic;
  }
  
  public String getIdentifiantNCP()
  {
    return m_identifiantNCP;
  }
  
  public String getRSIN()
  {
    return m_RSIN;
  }
  
  public void setCodeAssedic(String p_cxass)
  {
    m_codeAssedic = p_cxass;
  }
  
  public void setIdentifiantNCP(String p_cxalak)
  {
    m_identifiantNCP = p_cxalak;
  }
  
  public void setRSIN(String p_cxin)
  {
    m_RSIN = p_cxin;
  }
}

/* Location:
 * Qualified Name:     StructureInTrancheDeVie
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */