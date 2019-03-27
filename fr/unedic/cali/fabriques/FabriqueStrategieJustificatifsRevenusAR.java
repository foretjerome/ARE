package fr.unedic.cali.fabriques;

import fr.unedic.cali.outilsfonctionnels.strategies.CritereStrategie;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieJustificatifsRevenusARApresMEP08SI1;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieJustificatifsRevenusARAvantMEP08SI1;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieJustificatifsRevenusARSpec;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieJustificatifsRevenusARSpectacleApresMEP;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieSpec;
import fr.unedic.util.temps.Damj;

public class FabriqueStrategieJustificatifsRevenusAR
  implements FabriqueStrategieSpec
{
  public static final Damj DATE_MEP_08SI1 = new Damj(2008, 3, 1);
  private static FabriqueStrategieJustificatifsRevenusAR s_instance = new FabriqueStrategieJustificatifsRevenusAR();
  
  public static FabriqueStrategieJustificatifsRevenusAR getInstance()
  {
    return s_instance;
  }
  
  public StrategieSpec getStrategie(CritereStrategie p_critereStrategie)
  {
    StrategieJustificatifsRevenusARSpec strategie = null;
    
    Damj datePivot = p_critereStrategie.getDatePivot();
    if (datePivot == null) {
      throw new UnsupportedOperationException("FabriqueStrategieJustificatifsRevenusAR : la date pivot de traitement des justificatifs de revenus d'Activités Réduite est null.");
    }
    if ((datePivot.estApresOuCoincideAvec(DATE_MEP_08SI1)) && (p_critereStrategie.isProduitSpectacle())) {
      strategie = new StrategieJustificatifsRevenusARSpectacleApresMEP();
    } else if (datePivot.estApresOuCoincideAvec(DATE_MEP_08SI1)) {
      strategie = new StrategieJustificatifsRevenusARApresMEP08SI1();
    } else {
      strategie = new StrategieJustificatifsRevenusARAvantMEP08SI1();
    }
    return strategie;
  }
}

/* Location:
 * Qualified Name:     FabriqueStrategieJustificatifsRevenusAR
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */