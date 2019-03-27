package fr.unedic.cali.parcours;

import fr.unedic.util.services.ContexteLocal;
import fr.unedic.util.services.ContexteSpec;

public class ContexteParcoursSimulationChangementARZ
  extends ContexteParcoursSimulationChangementAbstrait
{
  public static boolean isActif()
  {
    ContexteParcoursSimulationChangementARZ contexte = (ContexteParcoursSimulationChangementARZ)getContexte();
    return m_actif;
  }
  
  public static ContexteSpec getContexte()
  {
    ContexteParcoursSimulationChangementARZ contexte = (ContexteParcoursSimulationChangementARZ)ContexteLocal.getContexte(ContexteParcoursSimulationChangementARZ.class);
    if (contexte == null)
    {
      contexte = new ContexteParcoursSimulationChangementARZ();
      ContexteLocal.setContexte(contexte, ContexteParcoursSimulationChangementARZ.class);
    }
    return contexte;
  }
}

/* Location:
 * Qualified Name:     ContexteParcoursSimulationChangementARZ
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */