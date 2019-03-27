package fr.unedic.cali.parcours;

import fr.unedic.util.services.ContexteLocal;
import fr.unedic.util.services.ContexteSpec;

public class ContexteParcoursSimulationChangementDeterminationStatutUTRg
  extends ContexteParcoursSimulationChangementAbstrait
{
  public static boolean isActif()
  {
    return getContextem_actif;
  }
  
  public static ContexteSpec getContexte()
  {
    ContexteParcoursSimulationChangementDeterminationStatutUTRg contexte = (ContexteParcoursSimulationChangementDeterminationStatutUTRg)ContexteLocal.getContexte(ContexteParcoursSimulationChangementDeterminationStatutUTRg.class);
    if (contexte == null)
    {
      contexte = new ContexteParcoursSimulationChangementDeterminationStatutUTRg();
      ContexteLocal.setContexte(contexte, ContexteParcoursSimulationChangementDeterminationStatutUTRg.class);
    }
    return contexte;
  }
}

/* Location:
 * Qualified Name:     ContexteParcoursSimulationChangementDeterminationStatutUTRg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */