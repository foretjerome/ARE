package fr.unedic.cali.autresdoms.cohab.sigma.tranchedevie.dom;

import fr.unedic.cali.autresdoms.cohab.sigma.tranchedevie.dom.spec.InfoTrancheDeVieSpec;

public class InfoTrancheDeVie
  implements InfoTrancheDeVieSpec
{
  private String m_codeAntenne;
  private String m_codeAssedic;
  private String m_identifiantBNI;
  private String m_identifiantDNA;
  private String m_identifiantNCP;
  private String m_RSIN;
  private Boolean m_topReferent;
  
  public String getCodeAntenne()
  {
    return m_codeAntenne;
  }
  
  public String getCodeAssedic()
  {
    return m_codeAssedic;
  }
  
  public String getIdentifiantBNI()
  {
    return m_identifiantBNI;
  }
  
  public String getIdentifiantDNA()
  {
    return m_identifiantDNA;
  }
  
  public String getIdentifiantNCP()
  {
    return m_identifiantNCP;
  }
  
  public String getRSIN()
  {
    return m_RSIN;
  }
  
  public int hashCode()
  {
    int PRIME = 31;
    int result = 1;
    result = 31 * result + (m_RSIN == null ? 0 : m_RSIN.hashCode());
    result = 31 * result + (m_codeAntenne == null ? 0 : m_codeAntenne.hashCode());
    result = 31 * result + (m_codeAssedic == null ? 0 : m_codeAssedic.hashCode());
    result = 31 * result + (m_identifiantBNI == null ? 0 : m_identifiantBNI.hashCode());
    result = 31 * result + (m_identifiantDNA == null ? 0 : m_identifiantDNA.hashCode());
    result = 31 * result + (m_identifiantNCP == null ? 0 : m_identifiantNCP.hashCode());
    result = 31 * result + (m_topReferent == null ? 0 : m_topReferent.hashCode());
    return result;
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
    InfoTrancheDeVie other = (InfoTrancheDeVie)obj;
    if (m_RSIN == null)
    {
      if (m_RSIN != null) {
        return false;
      }
    }
    else if (!m_RSIN.equals(m_RSIN)) {
      return false;
    }
    if (m_codeAntenne == null)
    {
      if (m_codeAntenne != null) {
        return false;
      }
    }
    else if (!m_codeAntenne.equals(m_codeAntenne)) {
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
    if (m_identifiantBNI == null)
    {
      if (m_identifiantBNI != null) {
        return false;
      }
    }
    else if (!m_identifiantBNI.equals(m_identifiantBNI)) {
      return false;
    }
    if (m_identifiantDNA == null)
    {
      if (m_identifiantDNA != null) {
        return false;
      }
    }
    else if (!m_identifiantDNA.equals(m_identifiantDNA)) {
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
    if (m_topReferent == null)
    {
      if (m_topReferent != null) {
        return false;
      }
    }
    else if (!m_topReferent.equals(m_topReferent)) {
      return false;
    }
    return true;
  }
  
  public Boolean getTopReferent()
  {
    return m_topReferent;
  }
  
  public void setCodeAntenne(String p_cdant)
  {
    m_codeAntenne = p_cdant;
  }
  
  public void setCodeAssedic(String p_cxass)
  {
    m_codeAssedic = p_cxass;
  }
  
  public void setIdentifiantBNI(String p_cxala)
  {
    m_identifiantBNI = p_cxala;
  }
  
  public void setIdentifiantDNA(String p_isdna)
  {
    m_identifiantDNA = p_isdna;
  }
  
  public void setIdentifiantNCP(String p_cxalak)
  {
    m_identifiantNCP = p_cxalak;
  }
  
  public void setRSIN(String p_cxin)
  {
    m_RSIN = p_cxin;
  }
  
  public void setTopReferent(Boolean p_top_ref)
  {
    m_topReferent = p_top_ref;
  }
}

/* Location:
 * Qualified Name:     InfoTrancheDeVie
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */