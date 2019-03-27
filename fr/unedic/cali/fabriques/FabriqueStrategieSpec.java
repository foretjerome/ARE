package fr.unedic.cali.fabriques;

import fr.unedic.cali.outilsfonctionnels.strategies.CritereStrategie;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieSpec;
import fr.unedic.util.services.CoucheLogiqueException;

public abstract interface FabriqueStrategieSpec
{
  public abstract StrategieSpec getStrategie(CritereStrategie paramCritereStrategie)
    throws CoucheLogiqueException;
}

/* Location:
 * Qualified Name:     FabriqueStrategieSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */