package fr.unedic.cali.dom;

public abstract interface VisiteurQuantiteDroit
{
  public abstract Object visiter(EtatQuantiteDroitActive paramEtatQuantiteDroitActive);
  
  public abstract Object visiter(EtatQuantiteDroitEpuisee paramEtatQuantiteDroitEpuisee);
  
  public abstract Object visiter(EtatQuantiteDroitInactive paramEtatQuantiteDroitInactive);
}

/* Location:
 * Qualified Name:     VisiteurQuantiteDroit
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */