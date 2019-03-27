package fr.unedic.cali.parametres;

import java.math.BigDecimal;

public class ValeurParametre
  implements ValeursParametre
{
  private BigDecimal m_valeur;
  
  public ValeurParametre() {}
  
  public ValeurParametre(BigDecimal p_big)
  {
    m_valeur = p_big;
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
 * Qualified Name:     ValeurParametre
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */