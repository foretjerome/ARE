package fr.unedic.cali.occasionnel.outilsfonctionnels;

import java.util.HashMap;

public abstract class FabriqueTraitementPopulationAbstrait
  implements FabriqueTraitementPopulationSpec
{
  protected HashMap m_outilsFonctionnels = new HashMap();
  
  public TraitementPopulationSpec getInstance(String p_nomPopulation)
  {
    TraitementPopulationSpec outil = (TraitementPopulationSpec)m_outilsFonctionnels.get(p_nomPopulation);
    if (outil == null)
    {
      outil = instancierOutilFonctionnel(p_nomPopulation);
      m_outilsFonctionnels.put(p_nomPopulation, outil);
    }
    return outil;
  }
  
  protected abstract TraitementPopulationSpec instancierOutilFonctionnel(String paramString);
}

/* Location:
 * Qualified Name:     FabriqueTraitementPopulationAbstrait
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */