package fr.unedic.cali.autresdoms.cohab.sigma.formation.dom.spec;

import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import fr.unedic.util.temps.Temporel;

public abstract interface PeriodeFormationSpec
  extends Temporel
{
  public abstract int getNumeroPeriodeFormation();
  
  public abstract void setNumeroPeriodeFormation(int paramInt);
  
  public abstract Periode getPeriodeEffective();
  
  public abstract void setPeriodeEffective(Periode paramPeriode);
  
  public abstract Damj getDateDebut();
  
  public abstract Damj getDateFin();
  
  public abstract Periode getPeriode();
  
  public abstract void setPeriode(Periode paramPeriode);
  
  public abstract String getTypeMesureEmploi();
  
  public abstract void setTypeMesureEmploi(String paramString);
}

/* Location:
 * Qualified Name:     PeriodeFormationSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */