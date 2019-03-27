package fr.unedic.cali.utilitaire.filtres.generiques.conteneur;

public class ConteneurFiltredemandeNpde
{
  private Boolean estComplete;
  private Boolean estLiquidationStandardAutoPossible;
  
  public ConteneurFiltredemandeNpde(boolean estComplete, boolean estLiquidationStandardAutoPossible)
  {
    this.estComplete = Boolean.valueOf(estComplete);
    this.estLiquidationStandardAutoPossible = Boolean.valueOf(estLiquidationStandardAutoPossible);
  }
  
  public Boolean getEstComplete()
  {
    return estComplete;
  }
  
  public void setEstComplete(Boolean estComplete)
  {
    this.estComplete = estComplete;
  }
  
  public Boolean getEstLiquidationStandardAutoPossible()
  {
    return estLiquidationStandardAutoPossible;
  }
  
  public void setEstLiquidationStandardAutoPossible(Boolean estLiquidationStandardAutoPossible)
  {
    this.estLiquidationStandardAutoPossible = estLiquidationStandardAutoPossible;
  }
}

/* Location:
 * Qualified Name:     ConteneurFiltredemandeNpde
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */