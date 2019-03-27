package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import java.util.ArrayList;

public class TracesTemps
{
  private static TracesTemps s_instance = new TracesTemps();
  private ArrayList<TracesTemps.Appel> m_appels = new ArrayList();
  
  public static TracesTemps getInstance()
  {
    return s_instance;
  }
  
  public void initialiser()
  {
    m_appels = new ArrayList();
    Long millis = Long.valueOf(System.currentTimeMillis());
    
    StackTraceElement appelant = new Exception().getStackTrace()[1];
    String nomClasse = appelant.getClassName();
    String nomMethode = appelant.getMethodName();
    int numLigne = appelant.getLineNumber();
    String ligne = "DEBUT [ " + nomClasse + "." + nomMethode + "() L(" + numLigne + ").";
    
    m_appels.add(new TracesTemps.Appel(this, millis, ligne));
  }
  
  public void tracerAppel(String p_message)
  {
    Long millis = Long.valueOf(System.currentTimeMillis());
    StackTraceElement appelant = new Exception().getStackTrace()[1];
    String nomClasse = appelant.getClassName();
    String nomMethode = appelant.getMethodName();
    int numLigne = appelant.getLineNumber();
    String ligne = p_message + " [ " + nomClasse + "." + nomMethode + "() L(" + numLigne + ").";
    m_appels.add(new TracesTemps.Appel(this, millis, ligne));
  }
  
  public void finaliser()
  {
    Long millis = Long.valueOf(System.currentTimeMillis());
    StackTraceElement appelant = new Exception().getStackTrace()[1];
    String nomClasse = appelant.getClassName();
    String nomMethode = appelant.getMethodName();
    int numLigne = appelant.getLineNumber();
    String ligne = "FIN [ " + nomClasse + "." + nomMethode + "() L(" + numLigne + ").";
    m_appels.add(new TracesTemps.Appel(this, millis, ligne));
    
    TracesTemps.Appel appelPrecedent = (TracesTemps.Appel)m_appels.get(0);
    Log.ecritTrace(Niveau.DEBUG, TracesTemps.class, "ecrireTraces", appelPrecedent.getLigneCode());
    for (int i = 1; i < m_appels.size(); i++)
    {
      TracesTemps.Appel appelCourant = (TracesTemps.Appel)m_appels.get(i);
      Long difference = Long.valueOf(appelCourant.getMillis().longValue() - appelPrecedent.getMillis().longValue());
      Log.ecritTrace(Niveau.DEBUG, TracesTemps.class, "ecrireTraces", "[" + difference + "]" + appelCourant.getLigneCode());
      appelPrecedent = appelCourant;
    }
  }
}

/* Location:
 * Qualified Name:     TracesTemps
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */