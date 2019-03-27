package fr.unedic.cali.autresdoms.ga.dom.spec;

import java.math.BigDecimal;

public abstract interface ConstantesContratTravail
{
  public static final int CDI = 1;
  public static final int CDD = 2;
  public static final BigDecimal REFUS_FNE_NON_RENSEIGNE = new BigDecimal(0);
  public static final BigDecimal FNE_REFUSE = new BigDecimal(2);
  public static final BigDecimal FNE_ACCEPTE = new BigDecimal(1);
  public static final BigDecimal INDETERMINE = new BigDecimal(0);
  public static final BigDecimal COMPLETE = new BigDecimal(1);
  public static final BigDecimal INCOMPLETE = new BigDecimal(2);
  public static final BigDecimal BROUILLON = new BigDecimal(3);
  public static final BigDecimal AED_A_CONFIRMER_INDETERMINE = new BigDecimal(0);
  public static final BigDecimal AED_A_CONFIRMER = new BigDecimal(1);
  public static final BigDecimal AED_CONFIRMER_SANS_MODIF = new BigDecimal(2);
  public static final BigDecimal AED_CONFIRMER_AVEC_MODIF = new BigDecimal(3);
}

/* Location:
 * Qualified Name:     ConstantesContratTravail
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */