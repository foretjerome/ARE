package fr.unedic.cohabitation.sigma.migration.dom;

import java.math.BigDecimal;

public class DemandeMigreeForV1
  extends DemandeMigreeV1
{
  private String m_idActionFormation;
  private boolean m_estEffective;
  private boolean m_estDerogatoire;
  private BigDecimal m_referenceExterneAttributionAssurance;
  
  public DecisionMigreeForV1 getDecision()
  {
    return (DecisionMigreeForV1)getDecisionUnique();
  }
  
  public boolean isEstDerogatoire()
  {
    return m_estDerogatoire;
  }
  
  public void setEstDerogatoire(boolean p_estDerogatoire)
  {
    m_estDerogatoire = p_estDerogatoire;
  }
  
  public boolean isEstEffective()
  {
    return m_estEffective;
  }
  
  public void setEstEffective(boolean p_estEffective)
  {
    m_estEffective = p_estEffective;
  }
  
  public String getIdActionFormation()
  {
    return m_idActionFormation;
  }
  
  public void setIdActionFormation(String p_idActionFormation)
  {
    m_idActionFormation = p_idActionFormation;
  }
  
  public BigDecimal getReferenceExterneAttributionAssurance()
  {
    return m_referenceExterneAttributionAssurance;
  }
  
  public void setReferenceExterneAttributionAssurance(BigDecimal p_referenceExterneAttributionAssurance)
  {
    m_referenceExterneAttributionAssurance = p_referenceExterneAttributionAssurance;
  }
}

/* Location:
 * Qualified Name:     DemandeMigreeForV1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */