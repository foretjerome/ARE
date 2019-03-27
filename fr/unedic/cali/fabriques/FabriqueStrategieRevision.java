package fr.unedic.cali.fabriques;

import fr.unedic.cali.outilsfonctionnels.strategies.CritereStrategie;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieRevisionApresARE14;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieRevisionAvantARE14;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieSpec;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;

public class FabriqueStrategieRevision
  extends FabriqueConvention2014
{
  private static FabriqueStrategieRevision s_instance = new FabriqueStrategieRevision();
  
  public static FabriqueStrategieRevision getInstance()
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
    return new StrategieRevisionAvantARE14();
  }
  
  protected StrategieSpec getStrategieApres()
  {
    return new StrategieRevisionApresARE14();
  }
}

/* Location:
 * Qualified Name:     FabriqueStrategieRevision
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */