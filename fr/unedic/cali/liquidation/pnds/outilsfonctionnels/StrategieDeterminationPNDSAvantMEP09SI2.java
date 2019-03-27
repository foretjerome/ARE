package fr.unedic.cali.liquidation.pnds.outilsfonctionnels;

import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.liquidation.pnds.StrategieDeterminationPNDSSpec;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import java.util.Collection;

public class StrategieDeterminationPNDSAvantMEP09SI2
  implements StrategieDeterminationPNDSSpec
{
  private static final String NOM = "StrategieDeterminationPNDSAvantMEP09SI2";
  
  public void determinationPNDSPourIndividuSurPeriode(IndividuSpec individu, Damj dateDebut, Damj dateFin, ChronologiePeriodes chronoGaec, boolean priseEnCompteBS) {}
  
  public String getNomStrategie()
  {
    return "StrategieDeterminationPNDSAvantMEP09SI2";
  }
  
  public Collection determinationPNDSPourCalcul(ChronologiePeriodes chronoPeriodeTravail, IndividuSpec individu)
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     StrategieDeterminationPNDSAvantMEP09SI2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */