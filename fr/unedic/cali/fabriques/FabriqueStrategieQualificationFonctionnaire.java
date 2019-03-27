package fr.unedic.cali.fabriques;

import fr.unedic.cali.outilsfonctionnels.strategies.CritereStrategie;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieQualificationFonctionnaireApres;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieQualificationFonctionnaireAvant;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieQualificationFonctionnaireSpec;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieSpec;
import fr.unedic.util.temps.Damj;

public class FabriqueStrategieQualificationFonctionnaire
  implements FabriqueStrategieSpec
{
  public static final Damj DATE_PIVOT = new Damj(2007, 2, 7);
  private static FabriqueStrategieQualificationFonctionnaire s_instance = new FabriqueStrategieQualificationFonctionnaire();
  
  public static FabriqueStrategieQualificationFonctionnaire getInstance()
  {
    return s_instance;
  }
  
  public StrategieSpec getStrategie(CritereStrategie p_critereStrategie)
  {
    StrategieQualificationFonctionnaireSpec strategie = null;
    
    Damj datePivot = p_critereStrategie.getDatePivot();
    if (datePivot == null) {
      throw new UnsupportedOperationException("StrategieQualificationFonctionnaire : la date pivot pour la qualification des fonctionnaires est null.");
    }
    if (datePivot.estApresOuCoincideAvec(DATE_PIVOT)) {
      strategie = new StrategieQualificationFonctionnaireApres();
    } else {
      strategie = new StrategieQualificationFonctionnaireAvant();
    }
    return strategie;
  }
}

/* Location:
 * Qualified Name:     FabriqueStrategieQualificationFonctionnaire
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */