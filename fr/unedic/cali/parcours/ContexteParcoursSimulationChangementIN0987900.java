package fr.unedic.cali.parcours;

import fr.unedic.util.services.ContexteLocal;
import fr.unedic.util.services.ContexteSpec;

public class ContexteParcoursSimulationChangementIN0987900
  extends ContexteParcoursSimulationChangementAbstrait
{
  public static boolean isActif()
  {
    return getContextem_actif;
  }
  
  public static ContexteSpec getContexte()
  {
    ContexteParcoursSimulationChangementIN0987900 contexte = (ContexteParcoursSimulationChangementIN0987900)ContexteLocal.getContexte(ContexteParcoursSimulationChangementIN0987900.class);
    if (contexte == null)
    {
      contexte = new ContexteParcoursSimulationChangementIN0987900();
      ContexteLocal.setContexte(contexte, ContexteParcoursSimulationChangementIN0987900.class);
    }
    return contexte;
  }
}

/* Location:
 * Qualified Name:     ContexteParcoursSimulationChangementIN0987900
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */