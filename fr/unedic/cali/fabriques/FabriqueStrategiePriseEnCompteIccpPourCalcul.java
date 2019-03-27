package fr.unedic.cali.fabriques;

import fr.unedic.cali.outilsfonctionnels.strategies.CritereStrategie;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategiePriseEnCompteIccpApresPourCalcul;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategiePriseEnCompteIccpAvantPourCalcul;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategiePriseEnCompteIccpSpec;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieSpec;
import fr.unedic.util.temps.Damj;

public class FabriqueStrategiePriseEnCompteIccpPourCalcul
  implements FabriqueStrategieSpec
{
  public static final Damj DATE_PRISE_EN_COMPTE_ICCP_09SI2 = new Damj(2009, 7, 1);
  private static FabriqueStrategiePriseEnCompteIccpPourCalcul s_instance = new FabriqueStrategiePriseEnCompteIccpPourCalcul();
  
  public static FabriqueStrategiePriseEnCompteIccpPourCalcul getInstance()
  {
    return s_instance;
  }
  
  public StrategieSpec getStrategie(CritereStrategie p_critereStrategie)
  {
    StrategiePriseEnCompteIccpSpec strategie = null;
    
    Damj datePivot = p_critereStrategie.getDatePivot();
    if (datePivot == null) {
      throw new UnsupportedOperationException("FabriqueStrategiePriseEnCompteIccp : la date pivot de modification des ressources est null.");
    }
    if (datePivot.estApresOuCoincideAvec(DATE_PRISE_EN_COMPTE_ICCP_09SI2)) {
      strategie = new StrategiePriseEnCompteIccpApresPourCalcul();
    } else {
      strategie = new StrategiePriseEnCompteIccpAvantPourCalcul();
    }
    return strategie;
  }
}

/* Location:
 * Qualified Name:     FabriqueStrategiePriseEnCompteIccpPourCalcul
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */