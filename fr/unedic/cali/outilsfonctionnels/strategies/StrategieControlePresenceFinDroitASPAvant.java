package fr.unedic.cali.outilsfonctionnels.strategies;

import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.outilsfonctionnels.OutilAsp;
import fr.unedic.cali.outilsfonctionnels.OutilDemande;
import fr.unedic.cali.outilsfonctionnels.strategies.spec.StrategieControlePresenceFinDroitASPSpec;

public class StrategieControlePresenceFinDroitASPAvant
  implements StrategieControlePresenceFinDroitASPSpec
{
  public boolean estUnDroitASP(AttributionSpec p_attribution)
  {
    return (OutilDemande.estUneDemandeAsp(p_attribution.getDemande())) || (OutilAsp.estUnProduitAsp(p_attribution.getProduit()));
  }
}

/* Location:
 * Qualified Name:     StrategieControlePresenceFinDroitASPAvant
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */