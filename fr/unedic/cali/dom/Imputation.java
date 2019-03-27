package fr.unedic.cali.dom;

import fr.unedic.util.Quantite;

public class Imputation
  implements ImputationSpec
{
  private boolean m_impute;
  private Quantite m_resteAImputer;
  public QuantiteDroitSpec m_quantiteDroit = null;
  
  public boolean estImpute()
  {
    return m_impute;
  }
  
  public Quantite getResteAImputer()
  {
    return m_resteAImputer;
  }
  
  public void setImpute(boolean p_impute)
  {
    m_impute = p_impute;
  }
  
  public void setResteAImputer(Quantite p_resteAImputer)
  {
    m_resteAImputer = p_resteAImputer;
  }
  
  public QuantiteDroitSpec getQuantiteDroit()
  {
    return m_quantiteDroit;
  }
  
  public void setQuantiteDroit(QuantiteDroitSpec p_quantiteDroit)
  {
    m_quantiteDroit = p_quantiteDroit;
  }
}

/* Location:
 * Qualified Name:     Imputation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */