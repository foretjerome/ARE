package fr.unedic.cali.fabriques;

import fr.unedic.cali.outilsfonctionnels.strategies.CritereStrategie;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieDeterminationStatutUTConversionHeureApresMEP09SI3;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieDeterminationStatutUTConversionHeureAvantMEP09SI3;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieDeterminationStatutUTConversionHeureSpec;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieSpec;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;

public class FabriqueStrategieDeterminationStatutUTConversionHeure
  implements FabriqueStrategieSpec
{
  public static final int ANNEE_PIVOT = 2009;
  public static final int MOIS_PIVOT = 11;
  public static final int JOUR_PIVOT = 1;
  private static FabriqueStrategieDeterminationStatutUTConversionHeure s_instance = new FabriqueStrategieDeterminationStatutUTConversionHeure();
  
  public static FabriqueStrategieDeterminationStatutUTConversionHeure getInstance()
  {
    return s_instance;
  }
  
  public StrategieSpec getStrategie(CritereStrategie p_critereStrategie)
    throws CoucheLogiqueException
  {
    StrategieDeterminationStatutUTConversionHeureSpec strategie = null;
    if (p_critereStrategie.getDatePivot() == null) {
      throw new UnsupportedOperationException("StrategieDeterminationStatutUTConversionHeure : la date pivot du critère stratégie est null.");
    }
    if (p_critereStrategie.getDatePivot().estAvant(new Damj(2009, 11, 1))) {
      strategie = new StrategieDeterminationStatutUTConversionHeureAvantMEP09SI3();
    } else {
      strategie = new StrategieDeterminationStatutUTConversionHeureApresMEP09SI3();
    }
    return strategie;
  }
}

/* Location:
 * Qualified Name:     FabriqueStrategieDeterminationStatutUTConversionHeure
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */