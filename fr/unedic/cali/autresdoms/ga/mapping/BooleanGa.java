package fr.unedic.cali.autresdoms.ga.mapping;

import java.math.BigDecimal;

class BooleanGa
{
  static boolean valueOf(BigDecimal p_valueGa)
  {
    boolean value = false;
    if (p_valueGa != null) {
      value = p_valueGa.intValue() == 2;
    }
    return value;
  }
  
  static boolean valueOfTransactionEffective(String p_valueGa)
  {
    boolean value = false;
    if (p_valueGa != null) {
      value = Integer.parseInt(p_valueGa) == 2;
    }
    return value;
  }
  
  static boolean valueOfTransactionEnCours(String p_valueGa)
  {
    boolean value = false;
    if (p_valueGa != null) {
      value = Integer.parseInt(p_valueGa) == 3;
    }
    return value;
  }
  
  static boolean valueOf(String p_valueGa)
  {
    boolean value = false;
    if (p_valueGa != null) {
      value = Integer.parseInt(p_valueGa) == 2;
    }
    return value;
  }
  
  static boolean valueOfEtatProfessionnel(String p_valueGa)
  {
    boolean value = false;
    if (p_valueGa != null) {
      value = Integer.parseInt(p_valueGa) == 1;
    }
    return value;
  }
  
  static boolean valueOfAlsaceMoselle(BigDecimal p_valueGa)
  {
    boolean value = false;
    if (p_valueGa != null) {
      value = p_valueGa.intValue() == 2;
    }
    return value;
  }
  
  static boolean valueOfLienParente(String p_valueGa)
  {
    boolean value = false;
    if (p_valueGa != null) {
      value = Integer.parseInt(p_valueGa) == 2;
    }
    return value;
  }
}

/* Location:
 * Qualified Name:     BooleanGa
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */