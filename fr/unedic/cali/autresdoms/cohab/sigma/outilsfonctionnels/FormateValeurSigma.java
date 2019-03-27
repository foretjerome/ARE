package fr.unedic.cali.autresdoms.cohab.sigma.outilsfonctionnels;

import java.math.BigDecimal;

public class FormateValeurSigma
{
  public static String formateString(String p_string)
  {
    if (p_string == null) {
      p_string = "";
    }
    return p_string;
  }
  
  public static String formateStringNonVide(String p_string, String p_default)
  {
    if ((p_string == null) || (p_string.trim().length() == 0)) {
      p_string = p_default;
    }
    return p_string;
  }
  
  public static String formateDamj(String p_date)
  {
    String date = null;
    if ((p_date.compareTo("") != 0) || (p_date.compareTo(" ") != 0)) {
      date = p_date;
    }
    return date;
  }
  
  public static BigDecimal formateBigDecimal(BigDecimal p_bigdecimal)
  {
    BigDecimal bigdecimal = null;
    if (p_bigdecimal == null) {
      bigdecimal = new BigDecimal("0");
    } else {
      bigdecimal = p_bigdecimal;
    }
    return bigdecimal;
  }
  
  public static String formateBigDecimalToString(BigDecimal p_bigdecimal)
  {
    String bigdec_st = "";
    BigDecimal bigdecimal = null;
    if (p_bigdecimal == null) {
      bigdecimal = new BigDecimal("0");
    } else {
      bigdecimal = p_bigdecimal;
    }
    bigdec_st = "" + bigdecimal;
    for (int i = bigdec_st.length(); i < 3; i++) {
      bigdec_st = "0" + bigdec_st;
    }
    return bigdec_st;
  }
  
  public static boolean formateStringToBoolean(String p_string)
  {
    return (p_string != null) && (p_string.toUpperCase().equalsIgnoreCase("O"));
  }
}

/* Location:
 * Qualified Name:     FormateValeurSigma
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */