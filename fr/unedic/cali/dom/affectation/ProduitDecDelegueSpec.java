package fr.unedic.cali.dom.affectation;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.util.services.Contexte;

public abstract interface ProduitDecDelegueSpec
  extends ProduitDelegueSpec, FacadeLiquidationProduitDecSpec
{
  public abstract void controlerContexteDonneesForcees(Contexte paramContexte)
    throws ApplicativeException;
}

/* Location:
 * Qualified Name:     ProduitDecDelegueSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */