package fr.unedic.cali.outilsfonctionnels.strategies.spec;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieEvolutionReglementaireSpec;
import fr.unedic.util.services.CoucheLogiqueException;

public abstract interface StrategieRechargementARE14Spec
  extends StrategieEvolutionReglementaireSpec
{
  public abstract void controlePresenceDemandeRechargement(DemandeSpec paramDemandeSpec)
    throws CoucheLogiqueException;
}

/* Location:
 * Qualified Name:     StrategieRechargementARE14Spec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */