package fr.unedic.cali.autresdoms.ga.dom.spec;

import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import fr.unedic.util.temps.Temporel;
import java.math.BigDecimal;
import java.util.List;

public abstract interface IncidentSpec
  extends Temporel
{
  public static final BigDecimal TEMPS_PLEIN = new BigDecimal("1");
  
  public abstract BigDecimal getIntensite();
  
  public abstract void setIntensite(BigDecimal paramBigDecimal);
  
  public abstract int getNature();
  
  public abstract void setNature(int paramInt);
  
  public abstract boolean estTempsPlein();
  
  public abstract Periode getPeriode();
  
  public abstract int inter(Periode paramPeriode);
  
  public abstract List getListeOrigineInformation();
  
  public abstract void ajouterOrigineInformation(int paramInt);
  
  public abstract void setDateDebut(Damj paramDamj);
  
  public abstract void setDateFin(Damj paramDamj);
}

/* Location:
 * Qualified Name:     IncidentSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */