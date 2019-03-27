package fr.unedic.cali.dom;

import java.math.BigDecimal;

public class BilanFinancierAidesMobilite
{
  private BigDecimal montantEngage;
  private BigDecimal montantPaye;
  private BigDecimal montantADesengager;
  private AttributionSpec attribution;
  private boolean estDesengagementPossible;
  
  public BilanFinancierAidesMobilite(AttributionSpec attribution, BigDecimal montantEngage, BigDecimal montantPaye)
  {
    this.attribution = attribution;
    this.montantEngage = montantEngage;
    this.montantPaye = montantPaye;
    setMontantADesengager(getMontantEngage().subtract(getMontantPaye()).max(BigDecimal.ZERO));
    setEstDesengagementPossible(getMontantADesengager().signum() == 1);
  }
  
  public BigDecimal getMontantEngage()
  {
    return montantEngage;
  }
  
  public void setMontantEngage(BigDecimal montantEngage)
  {
    this.montantEngage = montantEngage;
  }
  
  public BigDecimal getMontantPaye()
  {
    return montantPaye;
  }
  
  public void setMontantPaye(BigDecimal montantPaye)
  {
    this.montantPaye = montantPaye;
  }
  
  public void setMontantADesengager(BigDecimal montantADesengager)
  {
    this.montantADesengager = montantADesengager;
  }
  
  public BigDecimal getMontantADesengager()
  {
    return montantADesengager;
  }
  
  public AttributionSpec getAttribution()
  {
    return attribution;
  }
  
  public void setAttribution(AttributionSpec attribution)
  {
    this.attribution = attribution;
  }
  
  public boolean estDesengagementPossible()
  {
    return estDesengagementPossible;
  }
  
  public void setEstDesengagementPossible(boolean estDesengagementPossible)
  {
    this.estDesengagementPossible = estDesengagementPossible;
  }
}

/* Location:
 * Qualified Name:     BilanFinancierAidesMobilite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */