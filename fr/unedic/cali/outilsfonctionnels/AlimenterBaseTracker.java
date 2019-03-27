package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.autresdoms.ga.services.Abonnement;
import fr.unedic.util.services.ApplicativeRuntimeException;
import fr.unedic.util.services.ContexteServiceSpec;
import fr.unedic.util.services.OutilFonctionnel;
import fr.unedic.util.services.Tracker;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;
import java.util.Collection;

public class AlimenterBaseTracker
  implements OutilFonctionnel
{
  public static void alimenterDonneesEnModeReception(ContexteServiceSpec p_contexte)
  {
    if ((p_contexte.getContexteEmission() == null) || (p_contexte.getContexteEmission().equals("TP")))
    {
      try
      {
        Tracker.ecrireTraceReception(p_contexte);
      }
      catch (TechniqueException e)
      {
        throw new ApplicativeRuntimeException("HG_PR_CALI_L_ERR_ALIMENTATION_BASE_TRACKER", "Erreur lors de l'alimentation en base Tracker : ", e);
      }
      OutilTrace.ecrireTrace(Niveau.INFO, new Object[] { "Alimentation de la base Tracker : ", "\t Id Tracker : " + p_contexte.getIdOrigineTracker(), "\n", "\t Mode : Reception \n", "\t Domaine Destinataire : ", p_contexte.getDstCodeDomaine(), "\n", "\t Domaine Emetteur : ", p_contexte.getSrcCodeDomaine() });
    }
  }
  
  public static TraceTrackerEnModeEmission alimenterDonneesEnModeEmission(ContexteServiceSpec p_contexte, String p_destinataire, String p_codeFlux, Damj p_dateDebut, Collection p_listeActiviteReduite, Abonnement p_abonnement, String p_casUtilisationD90)
  {
    String idTracker = null;
    
    ContexteServiceSpec contexte = (ContexteServiceSpec)p_contexte.copie();
    if (p_contexte.getIdFlux() != null) {
      contexte.setIdFlux(new BigDecimal(p_contexte.getIdFlux().toString()));
    }
    miseAJourContexteServiceEmission(contexte, p_destinataire, p_codeFlux);
    
    idTracker = Tracker.recupererIdentifiantTracker(contexte);
    
    TraceTrackerEnModeEmission trace = new TraceTrackerEnModeEmission(idTracker, p_destinataire, p_codeFlux, contexte, p_dateDebut, p_listeActiviteReduite, p_abonnement, p_casUtilisationD90);
    
    return trace;
  }
  
  public static String alimenterDonneesEnModeEmission(ContexteServiceSpec p_contexte, String p_destinataire, String p_codeFlux)
  {
    String idTracker = null;
    
    miseAJourContexteServiceEmission(p_contexte, p_destinataire, p_codeFlux);
    try
    {
      idTracker = Tracker.ecrireTraceEmission(p_contexte);
    }
    catch (TechniqueException e)
    {
      throw new ApplicativeRuntimeException("HG_PR_CALI_L_ERR_ALIMENTATION_BASE_TRACKER", "Erreur lors de l'alimentation en base Tracker : ", e);
    }
    OutilTrace.ecrireTrace(Niveau.INFO, new Object[] { "Alimentation de la base Tracker : ", "\t Id Tracker : ", idTracker, "\n", "\t Mode : Emission \n", "\t Domaine Destinataire : ", p_destinataire, "\n", "\t Domaine Emetteur : ", p_contexte.getSrcCodeDomaine() });
    
    return idTracker;
  }
  
  public static void ecrireTraceEmissionDiffere(ContexteServiceSpec p_contexte)
    throws TechniqueException
  {
    Tracker.ecrireTraceEmissionDiffere(p_contexte);
  }
  
  private static void miseAJourContexteServiceEmission(ContexteServiceSpec p_contexteService, String p_destinataire, String p_codeFlux)
  {
    AppelServicesAbstrait.miseAJourContexteServiceDomPourTracker(p_contexteService, p_destinataire, p_codeFlux);
  }
}

/* Location:
 * Qualified Name:     AlimenterBaseTracker
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */