package fr.unedic.cali.autresdoms.d90.dom;

import java.math.BigDecimal;

public class DeltaProduit
{
  private String m_codeProduit;
  private int m_quantiteIndemniseeAvant = 0;
  private int m_quantiteIndemniseeApres = 0;
  private BigDecimal m_montantAvant = new BigDecimal("0");
  private BigDecimal m_montantApres = new BigDecimal("0");
  
  public String getCodeProduit()
  {
    return m_codeProduit;
  }
  
  public void setCodeProduit(String p_codeProduit)
  {
    m_codeProduit = p_codeProduit;
  }
  
  public int getQuantiteIndemniseeAvant()
  {
    return m_quantiteIndemniseeAvant;
  }
  
  public void setQuantiteIndemniseeAvant(int p_quantiteIndemniseeAvant)
  {
    m_quantiteIndemniseeAvant = p_quantiteIndemniseeAvant;
  }
  
  public int getQuantiteIndemniseeApres()
  {
    return m_quantiteIndemniseeApres;
  }
  
  public void setQuantiteIndemniseeApres(int p_quantiteIndemniseeApres)
  {
    m_quantiteIndemniseeApres = p_quantiteIndemniseeApres;
  }
  
  public BigDecimal getMontantAvant()
  {
    return m_montantAvant;
  }
  
  public void setMontantAvant(BigDecimal p_montantAvant)
  {
    m_montantAvant = p_montantAvant;
  }
  
  public BigDecimal getMontantApres()
  {
    return m_montantApres;
  }
  
  public void setMontantApres(BigDecimal p_montantApres)
  {
    m_montantApres = p_montantApres;
  }
}

/* Location:
 * Qualified Name:     DeltaProduit
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */