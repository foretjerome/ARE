package fr.unedic.cali.outilsfonctionnels;

import java.math.BigDecimal;

public class ConvertisseurUniteIntensite
{
  private static final BigDecimal NOMBRE_MOIS = new BigDecimal("12");
  private static final BigDecimal NOMBRE_SEMAINES = new BigDecimal("52");
  
  public static BigDecimal convertirEnHebdomadaire(BigDecimal p_intensite, int p_unite)
  {
    BigDecimal retour = null;
    switch (p_unite)
    {
    case 2: 
      retour = p_intensite.divide(NOMBRE_SEMAINES, 2, 4);
      break;
    case 3: 
      retour = p_intensite.multiply(NOMBRE_MOIS).divide(NOMBRE_SEMAINES, 2, 4);
      break;
    default: 
      retour = p_intensite;
    }
    return retour;
  }
}

/* Location:
 * Qualified Name:     ConvertisseurUniteIntensite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */