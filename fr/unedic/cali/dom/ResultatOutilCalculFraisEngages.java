package fr.unedic.cali.dom;

import java.math.BigDecimal;

public class ResultatOutilCalculFraisEngages
{
  private BigDecimal m_montantFraisEngageGlobal;
  private BigDecimal m_montantFraisEngageDerogatoire;
  
  public BigDecimal getMontantFraisEngageGlobal()
  {
    return m_montantFraisEngageGlobal;
  }
  
  public void setMontantFraisEngageGlobal(BigDecimal p_montantFraisEngageGlobal)
  {
    m_montantFraisEngageGlobal = p_montantFraisEngageGlobal;
  }
  
  public BigDecimal getMontantFraisEngageDerogatoire()
  {
    return m_montantFraisEngageDerogatoire;
  }
  
  public void setMontantFraisEngageDerogatoire(BigDecimal p_montantFraisEngageDerogatoire)
  {
    m_montantFraisEngageDerogatoire = p_montantFraisEngageDerogatoire;
  }
}

/* Location:
 * Qualified Name:     ResultatOutilCalculFraisEngages
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */