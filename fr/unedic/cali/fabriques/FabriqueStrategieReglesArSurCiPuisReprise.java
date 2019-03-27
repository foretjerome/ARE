package fr.unedic.cali.fabriques;

import fr.unedic.cali.outilsfonctionnels.strategies.CritereStrategie;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieReglesArSurCiPuisRepriseApresMEP09SI2;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieReglesArSurCiPuisRepriseAvantMEP09SI2;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieReglesArSurCiPuisRepriseSpec;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieSpec;
import fr.unedic.util.temps.Damj;

public class FabriqueStrategieReglesArSurCiPuisReprise
  implements FabriqueStrategieSpec
{
  public static final Damj DATE_MEP_09SI2 = new Damj(2009, 7, 1);
  private static FabriqueStrategieReglesArSurCiPuisReprise s_instance = new FabriqueStrategieReglesArSurCiPuisReprise();
  
  public static FabriqueStrategieReglesArSurCiPuisReprise getInstance()
  {
    return s_instance;
  }
  
  public StrategieSpec getStrategie(CritereStrategie p_critereStrategie)
  {
    StrategieReglesArSurCiPuisRepriseSpec strategie = null;
    
    Damj datePivot = p_critereStrategie.getDatePivot();
    if (datePivot == null) {
      throw new UnsupportedOperationException("FabriqueStrategieReglesArSurCiPuisReprise : la date pivot est nulle.");
    }
    if (datePivot.estApresOuCoincideAvec(DATE_MEP_09SI2)) {
      strategie = new StrategieReglesArSurCiPuisRepriseApresMEP09SI2();
    } else {
      strategie = new StrategieReglesArSurCiPuisRepriseAvantMEP09SI2();
    }
    return strategie;
  }
}

/* Location:
 * Qualified Name:     FabriqueStrategieReglesArSurCiPuisReprise
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */