package fr.unedic.cali.outilsfonctionnels.reexecution;

import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.outilsfonctionnels.AlimenterBaseTracker;
import fr.unedic.cali.outilsfonctionnels.AppelServicesBatch;
import fr.unedic.cali.outilsfonctionnels.TraceTrackerEnModeEmission;
import fr.unedic.cali.parcours.DomCali;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.services.ContexteServiceSpec;
import fr.unedic.util.temps.Damj;

public class OutilExecutionDifferee
{
  private static OutilExecutionDifferee s_instance = null;
  
  public static OutilExecutionDifferee getInstance()
  {
    if (s_instance == null) {
      s_instance = new OutilExecutionDifferee();
    }
    return s_instance;
  }
  
  public boolean existeUneExecutionDifferee(IndividuSpec p_individu)
  {
    return p_individu.getDateExecutionDifferee() != null;
  }
  
  public void supprimerExecutionDifferee(IndividuSpec p_individu)
  {
    p_individu.setDateExecutionDifferee(null);
    p_individu.setCodeTransaction(null);
    p_individu.setDomaineSrcFlux(null);
  }
  
  public void annulerExecutionDifferePourBatch(DomCali p_dom, Damj p_dateExecutionDifferee)
  {
    ContexteServiceSpec contexte = AppelServicesBatch.miseEnConformiteContexteService(p_dom.getContexteService());
    if (p_dom.getContexteService().getContexteEmission().equalsIgnoreCase("TP"))
    {
      TraceTrackerEnModeEmission trace = AlimenterBaseTracker.alimenterDonneesEnModeEmission(contexte, "D90", "ACADI", p_dateExecutionDifferee, null, null, "AnnulerEcrireEvtAsync");
      p_dom.getIndividu().ajouterTraceTrackerEnModeEmission(trace);
    }
  }
}

/* Location:
 * Qualified Name:     OutilExecutionDifferee
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */