package fr.unedic.cali.fabriques;

import fr.unedic.cali.outilsfonctionnels.GestionnaireErreur;
import fr.unedic.cali.outilsfonctionnels.strategies.CritereStrategie;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieSpec;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieTypeConventionAfpe;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieTypeConventionAfpeOuAfprSpec;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieTypeConventionAfpr;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;

public class FabriqueStrategieTypeConventionAfpeOuAfpr
  implements FabriqueStrategieSpec
{
  private static final Damj DATE_PIVOT = new Damj(2009, 1, 1);
  
  public StrategieSpec getStrategie(CritereStrategie p_critereStrategie)
    throws CoucheLogiqueException
  {
    StrategieTypeConventionAfpeOuAfprSpec strategie = null;
    
    Damj datePivot = p_critereStrategie.getDatePivot();
    if (datePivot == null) {
      GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_L_CTX_ABS_DATE_VALIDATION_FORMATION");
    }
    if (datePivot.estAvant(DATE_PIVOT)) {
      strategie = new StrategieTypeConventionAfpe();
    } else {
      strategie = new StrategieTypeConventionAfpr();
    }
    return strategie;
  }
}

/* Location:
 * Qualified Name:     FabriqueStrategieTypeConventionAfpeOuAfpr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */