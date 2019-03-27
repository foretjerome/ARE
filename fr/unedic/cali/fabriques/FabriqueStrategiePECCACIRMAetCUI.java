package fr.unedic.cali.fabriques;

import fr.unedic.cali.outilsfonctionnels.strategies.CritereStrategie;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieEntreeCACIRMAApresMEP;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieEntreeCACIRMAAvantMEP;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieEntreePECActualisableCACIRMAetCUI;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategiePECCACIRMAetCUISpec;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieSpec;
import fr.unedic.util.temps.Damj;

public class FabriqueStrategiePECCACIRMAetCUI
  implements FabriqueStrategieSpec
{
  private static final Damj DATE_PIVOT_CA_CIRMA = new Damj(2009, 6, 1);
  private static final Damj DATE_PIVOT_PEC_ACTUALISABLE = new Damj(2010, 1, 1);
  private static FabriqueStrategiePECCACIRMAetCUI s_instance = new FabriqueStrategiePECCACIRMAetCUI();
  
  public static FabriqueStrategiePECCACIRMAetCUI getInstance()
  {
    return s_instance;
  }
  
  public StrategieSpec getStrategie(CritereStrategie p_critereStrategie)
  {
    StrategiePECCACIRMAetCUISpec strategie = null;
    
    Damj datePivot = p_critereStrategie.getDatePivot();
    if (datePivot == null) {
      throw new UnsupportedOperationException("FabriqueStrategiePECCACIRMAetCUI : la date pivot du contrat est nulle.");
    }
    if (datePivot.estApresOuCoincideAvec(DATE_PIVOT_CA_CIRMA))
    {
      if (datePivot.estApresOuCoincideAvec(DATE_PIVOT_PEC_ACTUALISABLE)) {
        strategie = new StrategieEntreePECActualisableCACIRMAetCUI();
      } else {
        strategie = new StrategieEntreeCACIRMAApresMEP();
      }
    }
    else {
      strategie = new StrategieEntreeCACIRMAAvantMEP();
    }
    return strategie;
  }
}

/* Location:
 * Qualified Name:     FabriqueStrategiePECCACIRMAetCUI
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */