package fr.unedic.cali.outilsfonctionnels.strategies.spec;

import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieEvolutionReglementaireSpec;

public abstract interface StrategieControlePresenceFinDroitASPSpec
  extends StrategieEvolutionReglementaireSpec
{
  public abstract boolean estUnDroitASP(AttributionSpec paramAttributionSpec);
}

/* Location:
 * Qualified Name:     StrategieControlePresenceFinDroitASPSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */