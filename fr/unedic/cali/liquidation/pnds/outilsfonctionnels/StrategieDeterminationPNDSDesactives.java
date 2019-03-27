package fr.unedic.cali.liquidation.pnds.outilsfonctionnels;

import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.liquidation.pnds.StrategieDeterminationPNDSSpec;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import java.util.Collection;

public class StrategieDeterminationPNDSDesactives
  implements StrategieDeterminationPNDSSpec
{
  public static final String NOM = "StrategieDeterminationPNDSDesactives";
  
  public void determinationPNDSPourIndividuSurPeriode(IndividuSpec individu, Damj debut, Damj fin, ChronologiePeriodes gaec, boolean priseEnCompteBS)
    throws CoucheLogiqueException
  {
    individu.setListePNDSIndividu(null);
  }
  
  public String getNomStrategie()
  {
    return "StrategieDeterminationPNDSDesactives";
  }
  
  public Collection determinationPNDSPourCalcul(ChronologiePeriodes chronoPeriodeTravail, IndividuSpec individu)
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     StrategieDeterminationPNDSDesactives
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */