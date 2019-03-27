package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.util.Mathematiques;
import fr.unedic.util.Quantite;
import fr.unedic.util.Unite;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;

public class ConvertisseurElementComparaisonReexamen
{
  public static final String LIB_BOOLEAN_TRUE = "Oui";
  public static final String LIB_BOOLEAN_FALSE = "Non";
  public static final String LIB_SANS_OBJET = "Sans objet";
  
  public static String convertirElement(Object p_objet)
  {
    return p_objet == null ? "Sans objet" : p_objet.toString();
  }
  
  public static String convertirElement(String p_chaine)
  {
    return p_chaine == null ? "Sans objet" : p_chaine;
  }
  
  public static String convertirElement(Boolean p_boolean)
  {
    if (p_boolean == null) {
      return "Sans objet";
    }
    return p_boolean.booleanValue() ? "Oui" : "Non";
  }
  
  public static String convertirElement(Damj p_date)
  {
    return p_date == null ? "Sans objet" : p_date.formater();
  }
  
  public static String convertirElement(BigDecimal p_numerique)
  {
    return p_numerique == null ? "Sans objet" : Mathematiques.parserBigDecimalEnString(p_numerique, 2);
  }
  
  public static String convertirElement(Integer p_entier)
  {
    return p_entier == null ? "Sans objet" : p_entier.toString();
  }
  
  public static String convertirElement(Quantite p_quantite)
  {
    return convertirElement(p_quantite.getValeur()) + " " + p_quantite.getUnite().getNom();
  }
}

/* Location:
 * Qualified Name:     ConvertisseurElementComparaisonReexamen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */