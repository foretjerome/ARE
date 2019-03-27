package fr.unedic.cali.autresdoms.cohab.sigma.pension.dom.spec;

import fr.unedic.util.QuantiteEuro;
import fr.unedic.util.temps.Damj;

public abstract interface PensionInvaliditeSpec
{
  public static final String NATURE_PENSION_INV1 = "INV1";
  public static final String NATURE_PENSION_INV2 = "INV2";
  public static final String NATURE_PENSION_INV3 = "INV3";
  public static final String NATURE_PENSION_INV2NI = "INV2NI";
  public static final String NATURE_PENSION_INV3NI = "INV3NI";
  public static final String ETAT_INITIALISE = "I";
  public static final String ETAT_REVISE = "R";
  
  public abstract Damj getDateDebut();
  
  public abstract Damj getDateFin();
  
  public abstract String getCodeNature();
  
  public abstract QuantiteEuro getMontant();
  
  public abstract String getOrganismeFinanceur();
  
  public abstract String getEtat();
}

/* Location:
 * Qualified Name:     PensionInvaliditeSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */