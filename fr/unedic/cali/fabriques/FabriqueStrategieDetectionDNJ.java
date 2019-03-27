package fr.unedic.cali.fabriques;

import fr.unedic.cali.outilsfonctionnels.strategies.CritereStrategie;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieDetectionDNJApresMEP08SI3LOT;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieDetectionDNJAvantMEP08SI3LOT;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieDetectionDNJSpec;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieSpec;
import fr.unedic.util.temps.Damj;

public class FabriqueStrategieDetectionDNJ
  implements FabriqueStrategieSpec
{
  public static final Damj DATE_PIVOT_MEP_08SI3 = new Damj(2009, 2, 20);
  private static FabriqueStrategieDetectionDNJ s_instance = new FabriqueStrategieDetectionDNJ();
  
  public static FabriqueStrategieDetectionDNJ getInstance()
  {
    return s_instance;
  }
  
  public StrategieSpec getStrategie(CritereStrategie p_critereStrategie)
  {
    StrategieDetectionDNJSpec strategie = null;
    
    Damj datePivot = p_critereStrategie.getDatePivot();
    if (datePivot == null) {
      throw new UnsupportedOperationException("StrategieDetectionDNJ : la date pivot de détection des DNJ est null.");
    }
    if (datePivot.estApresOuCoincideAvec(DATE_PIVOT_MEP_08SI3)) {
      strategie = new StrategieDetectionDNJApresMEP08SI3LOT();
    } else {
      strategie = new StrategieDetectionDNJAvantMEP08SI3LOT();
    }
    return strategie;
  }
}

/* Location:
 * Qualified Name:     FabriqueStrategieDetectionDNJ
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */