package fr.unedic.cali.parcours;

import fr.unedic.util.services.ContexteLocal;
import fr.unedic.util.services.ContexteParcours;

public final class ContexteAbsencePNDS
  extends ContexteParcours
{
  private boolean actif;
  
  public void close()
  {
    setActif(false);
  }
  
  public void setActif(boolean pEstActif)
  {
    actif = pEstActif;
  }
  
  public static boolean isActif()
  {
    return getContexteactif;
  }
  
  public static ContexteAbsencePNDS getContexte()
  {
    ContexteAbsencePNDS contexte = (ContexteAbsencePNDS)ContexteLocal.getContexte(ContexteAbsencePNDS.class);
    if (contexte == null)
    {
      contexte = new ContexteAbsencePNDS();
      ContexteLocal.setContexte(contexte, ContexteAbsencePNDS.class);
    }
    return contexte;
  }
}

/* Location:
 * Qualified Name:     ContexteAbsencePNDS
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */