package fr.unedic.cali.parcours;

import fr.unedic.util.services.ContexteParcours;

public abstract class ContexteParcoursSimulationChangementAbstrait
  extends ContexteParcours
  implements ContexteParcoursSimulationChangementSpec
{
  protected boolean m_actif;
  
  public final void close()
  {
    setActif(false);
  }
  
  public final void setActif(boolean p_estActif)
  {
    m_actif = p_estActif;
  }
}

/* Location:
 * Qualified Name:     ContexteParcoursSimulationChangementAbstrait
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */