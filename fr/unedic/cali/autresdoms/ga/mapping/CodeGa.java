package fr.unedic.cali.autresdoms.ga.mapping;

import java.math.BigDecimal;

class CodeGa
{
  static int valueOf(String p_valueGa)
  {
    return p_valueGa == null ? 0 : Integer.valueOf(p_valueGa).intValue();
  }
  
  static boolean estLivreIX(BigDecimal p_valueGa)
  {
    if (p_valueGa == null) {
      return false;
    }
    return p_valueGa.intValue() == 1;
  }
  
  static BigDecimal valueOf(BigDecimal p_pourcentage)
  {
    if (p_pourcentage != null) {
      return p_pourcentage.divide(new BigDecimal("100"), 7, 2);
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     CodeGa
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */