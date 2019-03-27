package fr.unedic.cali.dom.conteneurs.spec;

import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.Periode;

public abstract interface DonneesEntreeComplementairesDeterminationSjrSpec
{
  public abstract Periode getPeriodePrcBornee();
  
  public abstract void setPeriodePrcBornee(Periode paramPeriode);
  
  public abstract Periode getPeriodePrcInitiale();
  
  public abstract void setPeriodePrcInitiale(Periode paramPeriode);
  
  public abstract int getTypeBornagePrc();
  
  public abstract void setTypeBornagePrc(int paramInt);
  
  public abstract Chronologie getChronologieActivitePourInappartenancePrc();
  
  public abstract void setChronologieActivitePourInappartenancePrc(Chronologie paramChronologie);
  
  public abstract Chronologie getChronologieActiviteSalariePrc();
  
  public abstract void setChronologieActiviteSalariePrc(Chronologie paramChronologie);
  
  public abstract Chronologie getChronologiePeriodeDeductiblePrc();
  
  public abstract void setChronologiePeriodeDeductiblePrc(Chronologie paramChronologie);
  
  public abstract DonneesEntreeComplementairesDeterminationSjrSpec copier();
}

/* Location:
 * Qualified Name:     DonneesEntreeComplementairesDeterminationSjrSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */