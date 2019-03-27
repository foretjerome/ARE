package fr.unedic.cali.fabriques;

import fr.unedic.cali.outilsfonctionnels.strategies.CritereStrategie;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieDeterminationPriseEnCompteGainSurPANSApresMEP11SI1;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieDeterminationPriseEnCompteGainSurPANSAvantMEP11SI1;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieDeterminationPriseEnCompteGainSurPansSpec;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieSpec;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;

public class FabriqueStrategieDeterminationPriseEnCompteGainsSurPANS
  implements FabriqueStrategieSpec
{
  public static final Damj DATE_PIVOT = new Damj(2011, 4, 1);
  private static FabriqueStrategieDeterminationPriseEnCompteGainsSurPANS s_instance = new FabriqueStrategieDeterminationPriseEnCompteGainsSurPANS();
  
  public static FabriqueStrategieDeterminationPriseEnCompteGainsSurPANS getInstance()
  {
    return s_instance;
  }
  
  public StrategieSpec getStrategie(CritereStrategie p_critereStrategie)
    throws CoucheLogiqueException
  {
    StrategieDeterminationPriseEnCompteGainSurPansSpec strategie = null;
    if (p_critereStrategie.getDatePivot() == null) {
      throw new UnsupportedOperationException("StrategieDeterminationStatutUTGainHeureRenseigne : la date pivot du critère stratégie est null.");
    }
    if (p_critereStrategie.getDatePivot().estAvant(DATE_PIVOT)) {
      strategie = new StrategieDeterminationPriseEnCompteGainSurPANSAvantMEP11SI1();
    } else {
      strategie = new StrategieDeterminationPriseEnCompteGainSurPANSApresMEP11SI1();
    }
    return strategie;
  }
}

/* Location:
 * Qualified Name:     FabriqueStrategieDeterminationPriseEnCompteGainsSurPANS
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */