package fr.unedic.cali.outilsfonctionnels.strategies.fabriques;

import fr.unedic.cali.fabriques.FabriqueStrategieSpec;
import fr.unedic.cali.outilsfonctionnels.strategies.CritereStrategie;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieDeterminationPeriodeIndemnisationApres;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieDeterminationPeriodeIndemnisationAvant;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieSpec;
import fr.unedic.cali.outilsfonctionnels.strategies.spec.StrategieDeterminationPeriodeIndemnisationSpec;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;

public class FabriqueDeterminationPeriodeIndemnisation
  implements FabriqueStrategieSpec
{
  public static final Damj DATE_PIVOT = new Damj(2013, 10, 1);
  private static FabriqueDeterminationPeriodeIndemnisation s_instance = null;
  
  public static synchronized FabriqueDeterminationPeriodeIndemnisation getInstance()
  {
    if (s_instance == null) {
      s_instance = new FabriqueDeterminationPeriodeIndemnisation();
    }
    return s_instance;
  }
  
  public StrategieSpec getStrategie(CritereStrategie p_critereStrategie)
    throws CoucheLogiqueException
  {
    StrategieDeterminationPeriodeIndemnisationSpec strategie = null;
    
    Damj datePivot = p_critereStrategie.getDatePivot();
    if (datePivot == null) {
      throw new UnsupportedOperationException("StrategieDeterminationPeriodeIndemnisationSpec : la date pivot (date examen) est nulle.");
    }
    if (datePivot.estApresOuCoincideAvec(DATE_PIVOT)) {
      strategie = new StrategieDeterminationPeriodeIndemnisationApres();
    } else {
      strategie = new StrategieDeterminationPeriodeIndemnisationAvant();
    }
    return strategie;
  }
}

/* Location:
 * Qualified Name:     FabriqueDeterminationPeriodeIndemnisation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */