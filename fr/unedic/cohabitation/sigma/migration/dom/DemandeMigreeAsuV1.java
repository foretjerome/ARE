package fr.unedic.cohabitation.sigma.migration.dom;

import java.math.BigDecimal;
import org.apache.commons.lang.builder.EqualsBuilder;

public class DemandeMigreeAsuV1
  extends DemandeMigreeV1
{
  private BigDecimal m_allongementDelaiDecheance;
  private BigDecimal m_nbJoursEmploi;
  
  public DecisionMigreeAsuV1 getDecision()
  {
    return (DecisionMigreeAsuV1)getDecisionUnique();
  }
  
  public BigDecimal getAllongementDelaiDecheance()
  {
    return m_allongementDelaiDecheance;
  }
  
  public void setAllongementDelaiDecheance(BigDecimal p_allongementDelaiDecheance)
  {
    m_allongementDelaiDecheance = p_allongementDelaiDecheance;
  }
  
  public boolean equals(Object p_arg0)
  {
    boolean isEqual = false;
    if ((p_arg0 instanceof DemandeMigreeAsuV1))
    {
      DemandeMigreeAsuV1 demandeV1 = (DemandeMigreeAsuV1)p_arg0;
      EqualsBuilder eqb = new EqualsBuilder();
      isEqual = (super.equals(p_arg0)) && (eqb.append(getAllongementDelaiDecheance(), demandeV1.getAllongementDelaiDecheance()).isEquals()) && (eqb.append(getNbJoursEmploi(), demandeV1.getNbJoursEmploi()).isEquals());
    }
    return isEqual;
  }
  
  public BigDecimal getNbJoursEmploi()
  {
    return m_nbJoursEmploi;
  }
  
  public void setNbJoursEmploi(BigDecimal p_nbJoursEmploi)
  {
    m_nbJoursEmploi = p_nbJoursEmploi;
  }
}

/* Location:
 * Qualified Name:     DemandeMigreeAsuV1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */