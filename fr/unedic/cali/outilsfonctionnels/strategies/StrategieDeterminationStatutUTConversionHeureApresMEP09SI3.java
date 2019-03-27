package fr.unedic.cali.outilsfonctionnels.strategies;

import fr.unedic.cali.calcul.outilsfonctionnels.DeterminerJustificatifsRevenusAR;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;

public class StrategieDeterminationStatutUTConversionHeureApresMEP09SI3
  implements StrategieDeterminationStatutUTConversionHeureSpec
{
  public boolean conversionHeureBS(ChronologiePeriodes p_listePeriodeActivite, Damj p_dateCalculSmicHoraire, AttributionSpec p_attribution)
  {
    DeterminerJustificatifsRevenusAR.traitementRevenusBS(p_listePeriodeActivite, p_dateCalculSmicHoraire, p_attribution);
    return true;
  }
}

/* Location:
 * Qualified Name:     StrategieDeterminationStatutUTConversionHeureApresMEP09SI3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */