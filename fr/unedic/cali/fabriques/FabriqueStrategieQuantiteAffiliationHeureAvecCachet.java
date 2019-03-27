package fr.unedic.cali.fabriques;

import fr.unedic.cali.outilsfonctionnels.strategies.CritereStrategie;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieQuantiteAffiliationHeureAvecCachetApresMEP09SI3;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieQuantiteAffiliationHeureAvecCachetAvantMEP09SI3;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieQuantiteAffiliationHeureAvecCachetSpec;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieSpec;
import fr.unedic.util.temps.Damj;

public class FabriqueStrategieQuantiteAffiliationHeureAvecCachet
  implements FabriqueStrategieSpec
{
  private static final Damj DATE_PIVOT = new Damj(2010, 1, 1);
  private static FabriqueStrategieQuantiteAffiliationHeureAvecCachet s_instance = new FabriqueStrategieQuantiteAffiliationHeureAvecCachet();
  
  public static FabriqueStrategieQuantiteAffiliationHeureAvecCachet getInstance()
  {
    return s_instance;
  }
  
  public StrategieSpec getStrategie(CritereStrategie p_critereStrategie)
  {
    StrategieQuantiteAffiliationHeureAvecCachetSpec strategie = null;
    
    Damj datePivot = p_critereStrategie.getDatePivot();
    if (datePivot == null) {
      throw new UnsupportedOperationException("FabriqueStrategieQuantiteAffiliationHeureAvecCachet : la date pivot est nulle.");
    }
    if (datePivot.estAvant(DATE_PIVOT)) {
      strategie = new StrategieQuantiteAffiliationHeureAvecCachetAvantMEP09SI3();
    } else {
      strategie = new StrategieQuantiteAffiliationHeureAvecCachetApresMEP09SI3();
    }
    return strategie;
  }
}

/* Location:
 * Qualified Name:     FabriqueStrategieQuantiteAffiliationHeureAvecCachet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */