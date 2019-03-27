package fr.unedic.cali.occasionnel.outilsfonctionnels;

import java.util.HashMap;

public abstract class FabriqueExecutionPopulationAbstrait
  implements FabriqueExecutionPopulationSpec
{
  protected HashMap outilsFonctionnels = new HashMap();
  
  public ExecutionPopulationSpec getInstance(String nomPopulation)
  {
    ExecutionPopulationSpec outil = (ExecutionPopulationSpec)outilsFonctionnels.get(nomPopulation);
    if (outil == null)
    {
      outil = instancierOutilFonctionnel(nomPopulation);
      outilsFonctionnels.put(nomPopulation, outil);
    }
    return outil;
  }
  
  protected abstract ExecutionPopulationSpec instancierOutilFonctionnel(String paramString);
}

/* Location:
 * Qualified Name:     FabriqueExecutionPopulationAbstrait
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */