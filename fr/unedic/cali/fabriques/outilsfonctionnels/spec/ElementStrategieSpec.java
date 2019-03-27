package fr.unedic.cali.fabriques.outilsfonctionnels.spec;

import fr.unedic.cali.outilsfonctionnels.strategies.StrategieSpec;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;

public abstract interface ElementStrategieSpec
{
  public abstract boolean estEligible(Damj paramDamj)
    throws CoucheLogiqueException;
  
  public abstract StrategieSpec recupererStrategie(Damj paramDamj)
    throws CoucheLogiqueException;
}

/* Location:
 * Qualified Name:     ElementStrategieSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */