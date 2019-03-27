package fr.unedic.cohabitation.sigma.migration.dom;

import java.math.BigDecimal;

public class DecisionMigreeForV1
  extends DecisionMigreeV1
{
  private BigDecimal m_montantBrut;
  private BigDecimal m_dureeIndemnisationMaximale;
  
  public BigDecimal getDureeIndemnisationMaximale()
  {
    return m_dureeIndemnisationMaximale;
  }
  
  public void setDureeIndemnisationMaximale(BigDecimal p_dureeIndemnisationMaximale)
  {
    m_dureeIndemnisationMaximale = p_dureeIndemnisationMaximale;
  }
  
  public BigDecimal getMontantBrut()
  {
    return m_montantBrut;
  }
  
  public void setMontantBrut(BigDecimal p_montantBrut)
  {
    m_montantBrut = p_montantBrut;
  }
}

/* Location:
 * Qualified Name:     DecisionMigreeForV1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */