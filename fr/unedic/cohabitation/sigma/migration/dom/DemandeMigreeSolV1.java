package fr.unedic.cohabitation.sigma.migration.dom;

import java.math.BigDecimal;

public class DemandeMigreeSolV1
  extends DemandeMigreeV1
{
  private BigDecimal m_situationFamiliale;
  private BigDecimal m_allongementDelaiDecheance;
  private BigDecimal m_origineDecision;
  private BigDecimal m_categorie;
  
  public DecisionMigreeSolV1 getDecision()
  {
    return (DecisionMigreeSolV1)getDecisionUnique();
  }
  
  public int getSituationFamiliale()
  {
    if (m_situationFamiliale != null) {
      return m_situationFamiliale.intValue();
    }
    return -1;
  }
  
  public void setSituationFamiliale(BigDecimal p_situationFamiliale)
  {
    m_situationFamiliale = p_situationFamiliale;
  }
  
  public BigDecimal getAllongementDelaiDecheance()
  {
    return m_allongementDelaiDecheance;
  }
  
  public void setAllongementDelaiDecheance(BigDecimal p_allongementDelaiDecheance)
  {
    m_allongementDelaiDecheance = p_allongementDelaiDecheance;
  }
  
  public BigDecimal getOrigineDecision()
  {
    return m_origineDecision;
  }
  
  public void setOrigineDecision(BigDecimal p_origineDecision)
  {
    m_origineDecision = p_origineDecision;
  }
  
  public BigDecimal getCategorie()
  {
    return m_categorie;
  }
  
  public void setCategorie(BigDecimal p_categorie)
  {
    m_categorie = p_categorie;
  }
}

/* Location:
 * Qualified Name:     DemandeMigreeSolV1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */