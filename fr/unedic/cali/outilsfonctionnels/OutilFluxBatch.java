package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import java.util.ArrayList;
import java.util.List;

public class OutilFluxBatch
  extends OutilFlux
{
  private static OutilFluxBatch instance;
  public static final String NOM_FLUX_D90_EVT_DESENG_AIDE_E = "DDSAI";
  public static final String NOM_FLUX_D90_EVT_DESENG_AIDE_S = "SDSAI";
  public static final String NOM_D90 = "D90";
  public static final String NOM_CODE_ACTIVITE = "DESAI";
  
  public static OutilFluxBatch getInstance()
  {
    if (instance == null) {
      instance = new OutilFluxBatch();
    }
    return instance;
  }
  
  public void creerTraceTrackerPourD90EvenementDesengagementAide(IndividuSpec individu, String referenceExterne, Damj dateEvenement, String casUtilisaion, String codeFluxParam)
    throws CoucheLogiqueException
  {
    TraceTrackerEnModeEmission trace = creerTraceTracker(individu, codeFluxParam, "D90", "DESAI");
    
    List<TraceTrackerEnModeEmission> tracesExistances = individu.getListeTraceTrackerEnModeEmission();
    if (tracesExistances != null)
    {
      List<TraceTrackerEnModeEmission> tracesASupprimer = new ArrayList();
      for (TraceTrackerEnModeEmission traceExistante : tracesExistances) {
        if ((estTraceDesengagementAide(traceExistante)) && (referenceExterne.equals(traceExistante.getReferenceExterne()))) {
          tracesASupprimer.add(traceExistante);
        }
      }
      for (TraceTrackerEnModeEmission traceASupp : tracesASupprimer) {
        individu.retirerTraceTrackerEnModeEmission(traceASupp);
      }
    }
    individu.ajouterTraceTrackerEnModeEmission(trace);
    trace.setReferenceExterne(referenceExterne);
    trace.setDateEvenementDesengagementAide(dateEvenement);
    trace.setCasUtilisationEvenementDesengagementAide(casUtilisaion);
  }
  
  private boolean estTraceDesengagementAide(TraceTrackerEnModeEmission traceExistante)
  {
    return ("DDSAI".equals(traceExistante.getCodeFlux())) || ("SDSAI".equals(traceExistante.getCodeFlux()));
  }
}

/* Location:
 * Qualified Name:     OutilFluxBatch
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */