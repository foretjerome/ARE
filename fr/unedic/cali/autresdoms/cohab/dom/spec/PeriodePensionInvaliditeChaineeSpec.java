package fr.unedic.cali.autresdoms.cohab.dom.spec;

import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeCalcul;
import java.util.Collection;

public abstract interface PeriodePensionInvaliditeChaineeSpec
  extends ObjetChronoPeriodeCalcul, Comparable
{
  public static final int STATUT_NON_DETERMINE = 0;
  public static final int STATUT_DEDUCTIBLE = 1;
  public static final int STATUT_NON_DEDUCTIBLE = 2;
  
  public abstract String getOrganismeFinanceur();
  
  public abstract void setOrganismeFinanceur(String paramString);
  
  public abstract int getStatut();
  
  public abstract void setStatut(int paramInt);
  
  public abstract Collection getListeSousPensionInvalidite();
}

/* Location:
 * Qualified Name:     PeriodePensionInvaliditeChaineeSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */