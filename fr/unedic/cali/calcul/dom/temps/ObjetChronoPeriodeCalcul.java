package fr.unedic.cali.calcul.dom.temps;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoPeriodeSpec;
import fr.unedic.util.temps.Periode;

public abstract interface ObjetChronoPeriodeCalcul
  extends ObjetChronoPeriodeSpec
{
  public abstract void copieElements(ObjetMetierSpec paramObjetMetierSpec);
  
  public abstract Periode getPeriode();
  
  public abstract void setPeriode(Periode paramPeriode);
  
  public abstract void setDateDebut(Damj paramDamj);
  
  public abstract void setDateFin(Damj paramDamj);
}

/* Location:
 * Qualified Name:     ObjetChronoPeriodeCalcul
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */