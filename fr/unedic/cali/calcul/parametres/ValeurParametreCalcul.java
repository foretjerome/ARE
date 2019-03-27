package fr.unedic.cali.calcul.parametres;

import java.math.BigDecimal;

public class ValeurParametreCalcul
  implements ValeursParametre
{
  private BigDecimal m_valeur;
  
  public ValeurParametreCalcul() {}
  
  public ValeurParametreCalcul(BigDecimal p_valeur)
  {
    m_valeur = p_valeur;
  }
  
  public BigDecimal getValeur()
  {
    return m_valeur;
  }
  
  public void setValeur(BigDecimal p_valeur)
  {
    m_valeur = p_valeur;
  }
}

/* Location:
 * Qualified Name:     ValeurParametreCalcul
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */