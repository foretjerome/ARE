package fr.unedic.cali.autresdoms.cohab.sigma.pension.dom.spec;

import fr.unedic.util.QuantiteEuro;
import fr.unedic.util.temps.Damj;

public abstract interface AvantageVieillesseSpec
{
  public static final String NON_SIGNIFICATIF_BLANC = " ";
  public static final String NON_SIGNIFICATIF_ZERO = "0";
  public static final String AVANTAGE_VIEILLESSE_MILITAIRE_CODE_1 = "1";
  public static final String REG_SPECIAUX_CIVILS_EDF_SNCF = "2";
  public static final String REGIME_DE_BASE_SECURITE_SOCIALE = "3";
  public static final String REGIMES_COMPLEMENTAIRES = "4";
  public static final String REGIMES_SUPLEMENTAIRES = "5";
  public static final String REGIMES_ETRANGERS = "6";
  public static final String AVANTAGE_VIEILLESSE_MILITAIRE_CODE_M = "M";
  
  public abstract Damj getDateDebut();
  
  public abstract Damj getDateFin();
  
  public abstract String getCodeNature();
  
  public abstract QuantiteEuro getMontant();
}

/* Location:
 * Qualified Name:     AvantageVieillesseSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */