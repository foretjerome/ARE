package fr.unedic.cali.dom.affectation;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.autresdoms.ga.dom.ActionFormation;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.util.services.Contexte;

public abstract interface ProduitForDelegueSpec
  extends ProduitDelegueSpec, FacadeLiquidationProduitForSpec
{
  public abstract void controlerContexteDonneesForcees(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract String getIdActionFormation(AttributionSpec paramAttributionSpec);
  
  public abstract ActionFormation getActionFormation(AttributionSpec paramAttributionSpec);
}

/* Location:
 * Qualified Name:     ProduitForDelegueSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */