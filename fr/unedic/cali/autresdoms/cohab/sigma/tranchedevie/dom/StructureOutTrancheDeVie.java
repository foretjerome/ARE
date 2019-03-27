package fr.unedic.cali.autresdoms.cohab.sigma.tranchedevie.dom;

import fr.unedic.cali.autresdoms.cohab.sigma.tranchedevie.dom.spec.StructureOutTrancheDeVieSpec;
import java.math.BigDecimal;

public class StructureOutTrancheDeVie
  implements StructureOutTrancheDeVieSpec
{
  private String m_codeAntenne;
  private String m_codeAssedic;
  private BigDecimal m_identifiantBNI;
  private String m_identifiantDNA;
  private String m_identifiantNCP;
  private String m_RSIN;
  private String m_topReferent;
  
  public String getCodeAntenne()
  {
    return m_codeAntenne;
  }
  
  public String getCodeAssedic()
  {
    return m_codeAssedic;
  }
  
  public BigDecimal getIdentifiantBNI()
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
  
  public String getTopReferent()
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
  
  public void setIdentifiantBNI(BigDecimal p_cxala)
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
  
  public void setTopReferent(String p_ffref)
  {
    m_topReferent = p_ffref;
  }
}

/* Location:
 * Qualified Name:     StructureOutTrancheDeVie
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */