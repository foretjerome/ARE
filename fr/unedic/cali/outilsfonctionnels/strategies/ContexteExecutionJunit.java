package fr.unedic.cali.outilsfonctionnels.strategies;

import fr.unedic.util.services.ContexteLocal;
import fr.unedic.util.services.ContexteParcours;

public class ContexteExecutionJunit
  extends ContexteParcours
{
  protected boolean actif;
  
  public final void close()
  {
    setActif(false);
  }
  
  public final void setActif(boolean estActif)
  {
    actif = estActif;
  }
  
  public static boolean isActif()
  {
    ContexteExecutionJunit contexte = getContexte();
    return actif;
  }
  
  public static ContexteExecutionJunit getContexte()
  {
    ContexteExecutionJunit contexte = (ContexteExecutionJunit)ContexteLocal.getContexte(ContexteExecutionJunit.class);
    if (contexte == null)
    {
      contexte = new ContexteExecutionJunit();
      ContexteLocal.setContexte(contexte, ContexteExecutionJunit.class);
    }
    return contexte;
  }
}

/* Location:
 * Qualified Name:     ContexteExecutionJunit
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */