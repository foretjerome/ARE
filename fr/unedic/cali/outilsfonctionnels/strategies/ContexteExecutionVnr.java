package fr.unedic.cali.outilsfonctionnels.strategies;

import fr.unedic.util.services.ContexteLocal;
import fr.unedic.util.services.ContexteParcours;

public class ContexteExecutionVnr
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
    ContexteExecutionVnr contexte = getContexte();
    return actif;
  }
  
  public static ContexteExecutionVnr getContexte()
  {
    ContexteExecutionVnr contexte = (ContexteExecutionVnr)ContexteLocal.getContexte(ContexteExecutionVnr.class);
    if (contexte == null)
    {
      contexte = new ContexteExecutionVnr();
      ContexteLocal.setContexte(contexte, ContexteExecutionVnr.class);
    }
    return contexte;
  }
}

/* Location:
 * Qualified Name:     ContexteExecutionVnr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */