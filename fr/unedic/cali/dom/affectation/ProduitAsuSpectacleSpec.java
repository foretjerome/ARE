package fr.unedic.cali.dom.affectation;

public abstract interface ProduitAsuSpectacleSpec
  extends FacadeLiquidationProduitAsuSpectacleSpec, ProduitAsuSpec
{
  public abstract boolean estProduitGerantFranchiseCP();
  
  public abstract boolean estProduitGerantFranchiseSalaire();
}

/* Location:
 * Qualified Name:     ProduitAsuSpectacleSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */