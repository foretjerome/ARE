package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeCalcul;
import fr.unedic.util.ObjetMetierSpec;
import java.math.BigDecimal;

public abstract interface PeriodeTravail
  extends ObjetChronoPeriodeCalcul
{
  public abstract BigDecimal getGain();
  
  public abstract void setGain(BigDecimal paramBigDecimal);
  
  public abstract BigDecimal getNombreHeuresDeCompletude();
  
  public abstract void setNombreHeuresDeCompletude(BigDecimal paramBigDecimal);
  
  public abstract BigDecimal getNombreHeures();
  
  public abstract void setNombreHeures(BigDecimal paramBigDecimal);
  
  public abstract boolean estMigree();
  
  public abstract void setEstMigree(boolean paramBoolean);
  
  public abstract String getIdentifiant();
  
  public abstract void setIdentifiant(String paramString);
  
  public abstract void copieElements(ObjetMetierSpec paramObjetMetierSpec);
}

/* Location:
 * Qualified Name:     PeriodeTravail
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */