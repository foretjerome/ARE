package fr.unedic.cali.autresdoms.ga.dom.spec;

import java.math.BigDecimal;
import java.util.HashMap;

public abstract class ConstantesRegimeRetraite
{
  public static final int TAILLE_HASHMAP = 8;
  public static final int CAISSE_REGIME_INDETERMINE = 0;
  public static final int CAISSE_REGIME_AGRICOLE = 1;
  public static final int CAISSE_REGIME_CLERC_NOTAIRE = 2;
  public static final int CAISSE_REGIME_COMPAGNIE_EAUX = 3;
  public static final int CAISSE_REGIME_FRANCAIS_A_ETRANGER = 4;
  public static final int CAISSE_REGIME_MINES = 5;
  public static final int CAISSE_REGIME_MARINE_MARCHANDE = 6;
  public static final int CAISSE_REGIME_PORT_AUTONOME_BORDEAUX = 7;
  public static final String LIB_CAISSE_REGIME_INDETERMINE = "";
  public static final String LIB_CAISSE_REGIME_AGRICOLE = "Régime Agricole";
  public static final String LIB_CAISSE_REGIME_CLERC_NOTAIRE = "Régime clercs de notaire";
  public static final String LIB_CAISSE_REGIME_FRANCAIS_A_ETRANGER = "Régime compagnie des Eaux";
  public static final String LIB_CAISSE_REGIME_COMPAGNIE_EAUX = "Régime des français à l'étranger";
  public static final String LIB_CAISSE_REGIME_MINES = "Régime des mines";
  public static final String LIB_CAISSE_REGIME_MARINE_MARCHANDE = "Régime marine marchande";
  public static final String LIB_CAISSE_REGIME_PORT_AUTONOME_BORDEAUX = "Régime port autonome de Bordeaux";
  private static HashMap s_libelleCaisseRegime = new HashMap(8);
  
  static
  {
    s_libelleCaisseRegime.put(new BigDecimal(1), "Régime Agricole");
    s_libelleCaisseRegime.put(new BigDecimal(2), "Régime clercs de notaire");
    s_libelleCaisseRegime.put(new BigDecimal(3), "Régime des français à l'étranger");
    s_libelleCaisseRegime.put(new BigDecimal(4), "Régime compagnie des Eaux");
    s_libelleCaisseRegime.put(new BigDecimal(0), "");
    s_libelleCaisseRegime.put(new BigDecimal(6), "Régime marine marchande");
    s_libelleCaisseRegime.put(new BigDecimal(5), "Régime des mines");
    s_libelleCaisseRegime.put(new BigDecimal(7), "Régime port autonome de Bordeaux");
  }
  
  public static String getCaisseRegime(BigDecimal p_codeEtat)
  {
    return (String)s_libelleCaisseRegime.get(p_codeEtat);
  }
}

/* Location:
 * Qualified Name:     ConstantesRegimeRetraite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */