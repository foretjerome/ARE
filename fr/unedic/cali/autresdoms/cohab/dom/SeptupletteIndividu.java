package fr.unedic.cali.autresdoms.cohab.dom;

public class SeptupletteIndividu
{
  private String m_topReferent;
  private String m_codeAntenne;
  private String m_identifiantDNA;
  
  public String getCodeAntenne()
  {
    return m_codeAntenne;
  }
  
  public String getIdentifiantDNA()
  {
    return m_identifiantDNA;
  }
  
  public String getTopReferent()
  {
    return m_topReferent;
  }
  
  public void setCodeAntenne(String p_codeAntenne)
  {
    m_codeAntenne = p_codeAntenne;
  }
  
  public void setIdentifiantDNA(String p_identifiantDNA)
  {
    m_identifiantDNA = p_identifiantDNA;
  }
  
  public void setTopReferent(String p_topReferent)
  {
    m_topReferent = p_topReferent;
  }
}

/* Location:
 * Qualified Name:     SeptupletteIndividu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */