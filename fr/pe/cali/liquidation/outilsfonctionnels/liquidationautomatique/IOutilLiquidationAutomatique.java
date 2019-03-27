package fr.pe.cali.liquidation.outilsfonctionnels.liquidationautomatique;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.util.services.Contexte;

public abstract interface IOutilLiquidationAutomatique
{
  public abstract void demarerLiquidationAutomatique(DemandeSpec paramDemandeSpec, Contexte paramContexte)
    throws ApplicativeException;
}

/* Location:
 * Qualified Name:     IOutilLiquidationAutomatique
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */