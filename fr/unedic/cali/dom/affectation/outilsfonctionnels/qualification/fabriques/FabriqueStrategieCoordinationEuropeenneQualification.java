package fr.unedic.cali.dom.affectation.outilsfonctionnels.qualification.fabriques;

import fr.unedic.cali.dom.affectation.outilsfonctionnels.qualification.strategies.StrategieCoordinationEuropeenneQualificationApres;
import fr.unedic.cali.dom.affectation.outilsfonctionnels.qualification.strategies.StrategieCoordinationEuropeenneQualificationAvant;
import fr.unedic.cali.dom.affectation.outilsfonctionnels.qualification.strategies.spec.StrategieCoordinationEuropeenneQualificationSpec;
import fr.unedic.cali.fabriques.FabriqueStrategieSpec;
import fr.unedic.cali.outilsfonctionnels.strategies.CritereStrategie;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieSpec;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;

public class FabriqueStrategieCoordinationEuropeenneQualification
  implements FabriqueStrategieSpec
{
  private static final Damj DATE_APPLICATION = new Damj(2011, 5, 31);
  private static FabriqueStrategieCoordinationEuropeenneQualification s_instance = new FabriqueStrategieCoordinationEuropeenneQualification();
  
  public static FabriqueStrategieCoordinationEuropeenneQualification getInstance()
  {
    return s_instance;
  }
  
  public StrategieSpec getStrategie(CritereStrategie p_critereStrategie)
    throws CoucheLogiqueException
  {
    StrategieCoordinationEuropeenneQualificationSpec strategie = null;
    
    Damj datePivotCoordinationEuropeenne = p_critereStrategie.getDatePivot();
    if (datePivotCoordinationEuropeenne == null) {
      throw new UnsupportedOperationException("FabriqueStrategieCoordinationEuropeenneQualification : la date pivot est null.");
    }
    if (datePivotCoordinationEuropeenne.estApresOuCoincideAvec(DATE_APPLICATION)) {
      strategie = new StrategieCoordinationEuropeenneQualificationApres();
    } else {
      strategie = new StrategieCoordinationEuropeenneQualificationAvant();
    }
    return strategie;
  }
}

/* Location:
 * Qualified Name:     FabriqueStrategieCoordinationEuropeenneQualification
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */