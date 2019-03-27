package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.outilsfonctionnels.strategies.ContexteExecutionJunit;
import fr.unedic.util.services.OutilFonctionnel;

public final class OutilTrace
  implements OutilFonctionnel
{
  public static void ecrireTrace(Niveau niveau, Object[] message) {}
  
  public static void ecrireTrace(Niveau niveau, Object[] message, Exception e) {}
  
  public static void tracerDebutParcours() {}
  
  public static void tracerDebutParcours(Niveau niveau) {}
  
  public static void tracerFinParcours() {}
  
  public static void tracerFinParcours(Niveau niveau) {}
  
  public static void ecrireMessagePourNiveauDebug(String message)
  {
    if (isLogActivePourNiveauDebug()) {
      Log.ecritTrace(Niveau.DEBUG, OutilTrace.class, "ecrireMessage(Niveau niveau, String message)", message);
    }
  }
  
  public static boolean isLogActivePourNiveauDebug()
  {
    return (!ContexteExecutionJunit.isActif()) && (Log.isTraceActive(OutilTrace.class, Niveau.DEBUG));
  }
}

/* Location:
 * Qualified Name:     OutilTrace
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */