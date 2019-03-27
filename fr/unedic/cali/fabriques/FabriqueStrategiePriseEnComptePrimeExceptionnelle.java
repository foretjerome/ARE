package fr.unedic.cali.fabriques;

import fr.unedic.cali.outilsfonctionnels.strategies.CritereStrategie;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategiePriseEnComptePrimeExceptionnelleApresMEP11SI2;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategiePriseEnComptePrimeExceptionnelleAvantMEP11SI2;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategiePriseEnComptePrimeExceptionnelleSpec;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieSpec;
import fr.unedic.util.temps.Damj;

public class FabriqueStrategiePriseEnComptePrimeExceptionnelle
  implements FabriqueStrategieSpec
{
  public static final Damj DATE_MEP_11SI2 = new Damj(2011, 8, 1);
  private static FabriqueStrategiePriseEnComptePrimeExceptionnelle s_instance = new FabriqueStrategiePriseEnComptePrimeExceptionnelle();
  
  public static FabriqueStrategiePriseEnComptePrimeExceptionnelle getInstance()
  {
    return s_instance;
  }
  
  public StrategieSpec getStrategie(CritereStrategie p_critereStrategie)
  {
    StrategiePriseEnComptePrimeExceptionnelleSpec strategie = null;
    
    Damj datePivot = p_critereStrategie.getDatePivot();
    if (datePivot == null) {
      throw new UnsupportedOperationException("FabriqueStrategieReglesArSurCiPuisReprise : la date pivot est nulle.");
    }
    if (datePivot.estApresOuCoincideAvec(DATE_MEP_11SI2)) {
      strategie = new StrategiePriseEnComptePrimeExceptionnelleApresMEP11SI2();
    } else {
      strategie = new StrategiePriseEnComptePrimeExceptionnelleAvantMEP11SI2();
    }
    return strategie;
  }
}

/* Location:
 * Qualified Name:     FabriqueStrategiePriseEnComptePrimeExceptionnelle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */