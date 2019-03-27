package fr.unedic.cali.fabriques;

import fr.unedic.cali.outilsfonctionnels.strategies.CritereStrategie;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieControlePresenceFinDroitASPApres;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieControlePresenceFinDroitASPAvant;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieSpec;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;

public class FabriqueStrategieControlePresenceFinDroitASP
  extends FabriqueConvention2014
{
  public StrategieSpec getStrategie(CritereStrategie p_critereStrategie)
    throws CoucheLogiqueException
  {
    StrategieSpec retour = null;
    
    Damj datePivot = p_critereStrategie.getDatePivot();
    if (datePivot == null) {
      throw new UnsupportedOperationException("FabriqueStrategieControlePresenceFinDroitASP : la date pivot est null.");
    }
    if (datePivot.estApresOuCoincideAvec(DATE_APPLICATION)) {
      retour = new StrategieControlePresenceFinDroitASPApres();
    } else {
      retour = new StrategieControlePresenceFinDroitASPAvant();
    }
    return retour;
  }
}

/* Location:
 * Qualified Name:     FabriqueStrategieControlePresenceFinDroitASP
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */