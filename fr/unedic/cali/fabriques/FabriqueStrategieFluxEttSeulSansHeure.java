package fr.unedic.cali.fabriques;

import fr.unedic.cali.outilsfonctionnels.strategies.CritereStrategie;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieFluxEttSeulSansHeureApresMEP;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieFluxEttSeulSansHeureAvantMEP;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieFluxEttSeulSansHeureSpec;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieSpec;
import fr.unedic.util.temps.Damj;

public class FabriqueStrategieFluxEttSeulSansHeure
  implements FabriqueStrategieSpec
{
  private static final Damj DATE_PIVOT = new Damj(2013, 5, 1);
  private static FabriqueStrategieFluxEttSeulSansHeure s_instance = new FabriqueStrategieFluxEttSeulSansHeure();
  
  public static FabriqueStrategieFluxEttSeulSansHeure getInstance()
  {
    return s_instance;
  }
  
  public StrategieSpec getStrategie(CritereStrategie p_critereStrategie)
  {
    StrategieFluxEttSeulSansHeureSpec strategie = null;
    
    Damj datePivot = p_critereStrategie.getDatePivot();
    if (datePivot == null) {
      throw new UnsupportedOperationException("StrategieFluxEttSeulSansHeureSpec : la date pivot est nulle.");
    }
    if (datePivot.estAvant(DATE_PIVOT)) {
      strategie = new StrategieFluxEttSeulSansHeureAvantMEP();
    } else {
      strategie = new StrategieFluxEttSeulSansHeureApresMEP();
    }
    return strategie;
  }
}

/* Location:
 * Qualified Name:     FabriqueStrategieFluxEttSeulSansHeure
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */