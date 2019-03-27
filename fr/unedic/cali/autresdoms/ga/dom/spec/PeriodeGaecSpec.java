package fr.unedic.cali.autresdoms.ga.dom.spec;

import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Temporel;

public abstract interface PeriodeGaecSpec
  extends Temporel
{
  public static final int PERIODE_NON_TYPEE = 999;
  public static final int PERIODE_FORMATION_CIF_CDD = 5;
  public static final int PERIODE_PRIME_NORMALE = 8;
  public static final int PERIODE_ACTIVITE_SALARIEE = 30;
  
  public abstract Damj getDateConnaissanceInfo();
  
  public abstract void setDateConnaissanceInfo(Damj paramDamj);
  
  public abstract String getIdentifiant();
  
  public abstract void setIdentifiant(String paramString);
  
  public abstract boolean estMigree();
  
  public abstract void setEstMigree(boolean paramBoolean);
  
  public abstract void setIncoherencePeriode(String paramString);
  
  public abstract String getIncoherencePeriode();
}

/* Location:
 * Qualified Name:     PeriodeGaecSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */