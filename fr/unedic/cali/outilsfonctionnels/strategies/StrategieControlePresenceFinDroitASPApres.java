package fr.unedic.cali.outilsfonctionnels.strategies;

import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.affectation.LigneAsuCva10;
import fr.unedic.cali.dom.affectation.LigneSpec;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.cali.outilsfonctionnels.strategies.spec.StrategieControlePresenceFinDroitASPSpec;

public class StrategieControlePresenceFinDroitASPApres
  implements StrategieControlePresenceFinDroitASPSpec
{
  public boolean estUnDroitASP(AttributionSpec p_attribution)
  {
    return LigneAsuCva10.getInstance().getNomUnique().equals(p_attribution.getProduit().getLigne().getNomUnique());
  }
}

/* Location:
 * Qualified Name:     StrategieControlePresenceFinDroitASPApres
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */