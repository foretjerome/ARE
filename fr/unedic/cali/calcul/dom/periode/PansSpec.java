package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;

public abstract interface PansSpec
{
  public abstract int getTypeActivite();
  
  public abstract void setTypeActivite(int paramInt);
  
  public abstract void setDateDebutActiviteConservee(Damj paramDamj);
  
  public abstract String getIdentifiant();
  
  public abstract BigDecimal getGain();
}

/* Location:
 * Qualified Name:     PansSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */