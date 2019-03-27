package fr.unedic.cali.dom.spec;

import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;

public abstract interface EvenementReferenceExamenFinDroitSpec
{
  public abstract void setCalculerDateExamenHorsLiquidation(boolean paramBoolean);
  
  public abstract boolean isCalculerDateExamenHorsLiquidation();
  
  public abstract Damj calculerDateExamenHorsLiquidation(DemandeSpec paramDemandeSpec);
  
  public abstract AttributionSpec rechercherAttributionPrecedente(DemandeSpec paramDemandeSpec)
    throws CoucheLogiqueException;
}

/* Location:
 * Qualified Name:     EvenementReferenceExamenFinDroitSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */