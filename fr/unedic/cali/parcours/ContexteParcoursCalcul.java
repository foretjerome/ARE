package fr.unedic.cali.parcours;

import fr.unedic.util.services.ContexteLocal;
import fr.unedic.util.services.ContexteParcours;
import fr.unedic.util.services.ContexteSpec;

public class ContexteParcoursCalcul
  extends ContexteParcours
{
  private boolean m_persistant;
  
  public void setPersistant(boolean p_persistant)
  {
    m_persistant = p_persistant;
  }
  
  public static boolean estPersistant()
  {
    ContexteParcoursCalcul contexte = (ContexteParcoursCalcul)getContexte();
    return m_persistant;
  }
  
  public static ContexteSpec getContexte()
  {
    ContexteParcoursCalcul contexte = (ContexteParcoursCalcul)ContexteLocal.getContexte(ContexteParcoursCalcul.class);
    if (contexte == null)
    {
      contexte = new ContexteParcoursCalcul();
      ContexteLocal.setContexte(contexte, ContexteParcoursCalcul.class);
    }
    return contexte;
  }
}

/* Location:
 * Qualified Name:     ContexteParcoursCalcul
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */