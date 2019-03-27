package fr.unedic.cali.outilsfonctionnels.strategies.spec;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieEvolutionReglementaireSpec;
import fr.unedic.util.services.CoucheLogiqueException;

public abstract interface StrategieRevisionARE14Spec
  extends StrategieEvolutionReglementaireSpec
{
  public abstract void controlePresenceDemandeRevision(DemandeSpec paramDemandeSpec)
    throws CoucheLogiqueException;
  
  public abstract void controlePresenceDemandeRevisionPostLiquidation(DemandeSpec paramDemandeSpec)
    throws CoucheLogiqueException;
}

/* Location:
 * Qualified Name:     StrategieRevisionARE14Spec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */