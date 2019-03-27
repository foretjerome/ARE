package fr.unedic.cali.autresdoms.cohab.sigma.tranchedevie.dom;

import fr.unedic.cali.autresdoms.cohab.sigma.tranchedevie.dom.spec.CriteresTrancheDeVieSpec;

public class CriteresTrancheDeVie
  implements CriteresTrancheDeVieSpec
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
  
  public boolean equals(Object obj)
  {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    CriteresTrancheDeVie other = (CriteresTrancheDeVie)obj;
    if (m_RSIN == null)
    {
      if (m_RSIN != null) {
        return false;
      }
    }
    else if (!m_RSIN.equals(m_RSIN)) {
      return false;
    }
    if (m_codeAssedic == null)
    {
      if (m_codeAssedic != null) {
        return false;
      }
    }
    else if (!m_codeAssedic.equals(m_codeAssedic)) {
      return false;
    }
    if (m_identifiantNCP == null)
    {
      if (m_identifiantNCP != null) {
        return false;
      }
    }
    else if (!m_identifiantNCP.equals(m_identifiantNCP)) {
      return false;
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     CriteresTrancheDeVie
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */