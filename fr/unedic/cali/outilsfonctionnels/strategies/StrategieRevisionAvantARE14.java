package fr.unedic.cali.outilsfonctionnels.strategies;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.outilsfonctionnels.strategies.spec.StrategieRevisionARE14Spec;
import fr.unedic.util.services.CoucheLogiqueException;

public class StrategieRevisionAvantARE14
  implements StrategieRevisionARE14Spec
{
  public void controlePresenceDemandeRevision(DemandeSpec demandePrestationsCourante)
    throws CoucheLogiqueException
  {}
  
  public void controlePresenceDemandeRevisionPostLiquidation(DemandeSpec demandePrestationsCourante)
    throws CoucheLogiqueException
  {}
}

/* Location:
 * Qualified Name:     StrategieRevisionAvantARE14
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */