package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.services.ContexteServiceSpec;
import fr.unedic.util.services.CoucheLogiqueException;

public class OutilFlux
{
  protected static TraceTrackerEnModeEmission creerTraceTracker(IndividuSpec individu, String codeFluxParam, String domaineDestinataire, String codeActivite)
    throws CoucheLogiqueException
  {
    ContexteService contexteServicePourTracker = (ContexteService)individu.getContexteService().copie();
    String codeFlux = codeFluxParam;
    String codeTransaction = codeFluxParam;
    contexteServicePourTracker.setCodeActivite(codeActivite);
    contexteServicePourTracker.setSrcCodeTransaction(codeTransaction);
    TraceTrackerEnModeEmission trace = alimenterBaseTrackerEmission(contexteServicePourTracker, domaineDestinataire, codeFlux);
    if ((contexteServicePourTracker.getContexteEmission() != null) && (contexteServicePourTracker.getContexteEmission().equals("TD"))) {
      trace.setIdTracker(null);
    }
    return trace;
  }
  
  protected static TraceTrackerEnModeEmission alimenterBaseTrackerEmission(ContexteServiceSpec contexteService, String destinataire, String codeFlux)
    throws CoucheLogiqueException
  {
    return AlimenterBaseTracker.alimenterDonneesEnModeEmission(contexteService, destinataire, codeFlux, null, null, null, null);
  }
}

/* Location:
 * Qualified Name:     OutilFlux
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */