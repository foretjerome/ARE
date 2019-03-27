package fr.unedic.cali.fabriques;

import fr.unedic.cali.outilsfonctionnels.strategies.CritereStrategie;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieRechargementApresARE14;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieRechargementAvantARE14;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieSpec;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;

public class FabriqueStrategieRechargement
  extends FabriqueConvention2014
{
  private static FabriqueStrategieRechargement s_instance = new FabriqueStrategieRechargement();
  
  public static FabriqueStrategieRechargement getInstance()
  {
    return s_instance;
  }
  
  public StrategieSpec getStrategie(CritereStrategie p_critereStrategie)
    throws CoucheLogiqueException
  {
    StrategieSpec retour = null;
    
    Damj datePivot = p_critereStrategie.getDatePivot();
    if (datePivot == null) {
      throw new UnsupportedOperationException("FabriqueStrategieContexteRepriseSystematique : la date pivot est null.");
    }
    if (datePivot.estApresOuCoincideAvec(DATE_APPLICATION)) {
      retour = getStrategieApres();
    } else {
      retour = getStrategieAvant();
    }
    return retour;
  }
  
  protected StrategieSpec getStrategieAvant()
  {
    return new StrategieRechargementAvantARE14();
  }
  
  protected StrategieSpec getStrategieApres()
  {
    return new StrategieRechargementApresARE14();
  }
}

/* Location:
 * Qualified Name:     FabriqueStrategieRechargement
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */