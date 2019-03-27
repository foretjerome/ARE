package fr.unedic.cali.outilsfonctionnels.strategies;

import java.math.BigDecimal;

public class StrategieDeterminationStatutUTGainHeureRenseigneApresMEP09SI3
  implements StrategieDeterminationStatutUTGainHeureRenseigneSpec
{
  private static final BigDecimal ZERO = new BigDecimal("0");
  
  public boolean presenceGainHeureRenseigne(BigDecimal p_totalGainJustifiee, BigDecimal p_totalHeureJustifiee, boolean p_presencePANS, boolean p_catPat)
  {
    if (((p_totalGainJustifiee.compareTo(ZERO) != 0) && ((p_totalHeureJustifiee.compareTo(ZERO) != 0) || (p_catPat))) || (p_presencePANS)) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     StrategieDeterminationStatutUTGainHeureRenseigneApresMEP09SI3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */