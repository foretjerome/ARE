package fr.unedic.cali.liquidation.pnds;

import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieCorrectionSpec;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import java.util.Collection;

public abstract interface StrategieDeterminationPNDSSpec
  extends StrategieCorrectionSpec
{
  public static final int LIMITE_DUREE_POUR_SANCTION_PND = 3;
  
  public abstract void determinationPNDSPourIndividuSurPeriode(IndividuSpec paramIndividuSpec, Damj paramDamj1, Damj paramDamj2, ChronologiePeriodes paramChronologiePeriodes, boolean paramBoolean)
    throws CoucheLogiqueException;
  
  public abstract Collection determinationPNDSPourCalcul(ChronologiePeriodes paramChronologiePeriodes, IndividuSpec paramIndividuSpec);
  
  public abstract String getNomStrategie();
}

/* Location:
 * Qualified Name:     StrategieDeterminationPNDSSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */