package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.OutilFonctionnel;

public abstract interface IOutilFonctionnelTraitementsErreurs
  extends OutilFonctionnel
{
  public abstract void controlesPostLiquidationAutomatique(DemandeSpec paramDemandeSpec)
    throws CoucheLogiqueException;
  
  public abstract void traitementBlocagesFonctionnelsLiquidationAutoNPDE(DemandeSpec paramDemandeSpec, CoucheLogiqueException paramCoucheLogiqueException)
    throws CoucheLogiqueException;
  
  public abstract void traitementBlocagesTechniquesLiquidationAuto(DemandeSpec paramDemandeSpec, Exception paramException);
}

/* Location:
 * Qualified Name:     IOutilFonctionnelTraitementsErreurs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */