package fr.unedic.cali.dom.affectation;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.util.temps.Damj;

public abstract interface FacadeLiquidationGammeSolSpec
  extends FacadeLiquidationGammeSpec
{
  public abstract Damj recupererDjiParEpuisementDroitSecteurPublic(DemandeSpec paramDemandeSpec);
}

/* Location:
 * Qualified Name:     FacadeLiquidationGammeSolSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */