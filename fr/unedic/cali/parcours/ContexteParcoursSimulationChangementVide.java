package fr.unedic.cali.parcours;

import fr.unedic.util.services.ContexteLocal;
import fr.unedic.util.services.ContexteSpec;

public class ContexteParcoursSimulationChangementVide
  extends ContexteParcoursSimulationChangementAbstrait
{
  public static boolean isActif()
  {
    ContexteParcoursSimulationChangementVide contexte = (ContexteParcoursSimulationChangementVide)getContexte();
    return m_actif;
  }
  
  public static ContexteSpec getContexte()
  {
    ContexteParcoursSimulationChangementVide contexte = (ContexteParcoursSimulationChangementVide)ContexteLocal.getContexte(ContexteParcoursSimulationChangementVide.class);
    if (contexte == null)
    {
      contexte = new ContexteParcoursSimulationChangementVide();
      ContexteLocal.setContexte(contexte, ContexteParcoursSimulationChangementVide.class);
    }
    return contexte;
  }
}

/* Location:
 * Qualified Name:     ContexteParcoursSimulationChangementVide
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */