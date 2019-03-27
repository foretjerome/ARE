package fr.unedic.cali.fabriques;

import fr.unedic.cali.outilsfonctionnels.strategies.CritereStrategie;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieInstallationForfaitPANSApresMEP;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieInstallationForfaitPANSAvantMEP;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieInstallationForfaitPANSSpec;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieSpec;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;

public class FabriqueStrategieInstallationForfaitPANS
  implements FabriqueStrategieSpec
{
  private static final Damj DATE_PIVOT = new Damj(2010, 7, 1);
  private static FabriqueStrategieInstallationForfaitPANS s_instance = new FabriqueStrategieInstallationForfaitPANS();
  
  public static FabriqueStrategieInstallationForfaitPANS getInstance()
  {
    return s_instance;
  }
  
  public StrategieSpec getStrategie(CritereStrategie p_critereStrategie)
    throws CoucheLogiqueException
  {
    StrategieInstallationForfaitPANSSpec strategie = null;
    
    Damj datePivot = p_critereStrategie.getDatePivot();
    if (datePivot == null) {
      throw new UnsupportedOperationException("FabriqueStrategieSuspensionRemunerationPANS : la date pivot du contrat est nulle.");
    }
    if (datePivot.estApresOuCoincideAvec(DATE_PIVOT)) {
      strategie = new StrategieInstallationForfaitPANSApresMEP();
    } else {
      strategie = new StrategieInstallationForfaitPANSAvantMEP();
    }
    return strategie;
  }
}

/* Location:
 * Qualified Name:     FabriqueStrategieInstallationForfaitPANS
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */