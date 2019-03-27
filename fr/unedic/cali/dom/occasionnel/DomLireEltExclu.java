package fr.unedic.cali.dom.occasionnel;

import java.math.BigDecimal;

public class DomLireEltExclu
{
  private BigDecimal m_numElement;
  private BigDecimal m_codeGamme;
  private BigDecimal m_codePoduit;
  
  public BigDecimal getCodeGamme()
  {
    return m_codeGamme;
  }
  
  public void setCodeGamme(BigDecimal p_codeGamme)
  {
    m_codeGamme = p_codeGamme;
  }
  
  public BigDecimal getCodePoduit()
  {
    return m_codePoduit;
  }
  
  public void setCodePoduit(BigDecimal p_codePoduit)
  {
    m_codePoduit = p_codePoduit;
  }
  
  public BigDecimal getNumElement()
  {
    return m_numElement;
  }
  
  public void setNumElement(BigDecimal p_numElement)
  {
    m_numElement = p_numElement;
  }
}

/* Location:
 * Qualified Name:     DomLireEltExclu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */