package fr.unedic.cali.parcours.population;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DossierAffectationSpec;
import fr.unedic.cali.dom.EvenementReferenceExamenSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.RejetSpec;
import fr.unedic.cali.dom.affectation.GammeSpec;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.cali.dom.pivot.DemandePivot;
import fr.unedic.cali.outilsfonctionnels.AlimenterBaseEchanges;
import fr.unedic.cali.outilsfonctionnels.AlimenterBaseTracker;
import fr.unedic.cali.outilsfonctionnels.GestionIndicateurs;
import fr.unedic.cali.outilsfonctionnels.OutilTrace;
import fr.unedic.cali.outilsfonctionnels.TraceTrackerEnModeEmission;
import fr.unedic.cali.parcours.DomReexecutionCali;
import fr.unedic.cali.parcours.ResultatReexecutionCali;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.services.ContexteServiceSpec;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Chronologie;

public class ParcoursPopulationDemandeFinDroitSpectacle
  extends ParcoursPopulationAbstraite
{
  public Resultat demarrer(Contexte p_contexte)
    throws ApplicativeException
  {
    ResultatReexecutionCali resultatReexecutionCali = new ResultatReexecutionCali();
    
    DomReexecutionCali domReexecutionCali = (DomReexecutionCali)p_contexte.getDonnees();
    IndividuSpec individu = domReexecutionCali.getIndividu();
    
    effectuerTraitement(individu);
    
    resultatReexecutionCali.setEtat(0);
    resultatReexecutionCali.setFailure(false);
    resultatReexecutionCali.setIndicateursGeneriques(GestionIndicateurs.creerIndicateurs(individu, null));
    return resultatReexecutionCali;
  }
  
  private void effectuerTraitement(IndividuSpec p_individu)
    throws ApplicativeException
  {
    ContexteService contexteService = p_individu.getContexteService();
    
    String destinataire = "CID";
    
    Chronologie demandesAsurrance = p_individu.getChronoDemandeAssurance();
    demandesAsurrance.iterer();
    while (demandesAsurrance.encoreSuivant())
    {
      DemandeSpec demande = (DemandeSpec)demandesAsurrance.elementSuivant();
      if ((estUneDemandeSuiteFinDroit(demande)) && (demande.estDecisionnee()))
      {
        if ((demande.getDossierAffectation().getDossierExamen() instanceof RejetSpec)) {
          traitementRejet(demande);
        }
        TraceTrackerEnModeEmission trace = alimenterBaseTrackerEmission(contexteService, destinataire, "A12INT");
        p_individu.ajouterTraceTrackerEnModeEmission(trace);
        
        alimenterBaseEchange(demande, trace.getIdTracker());
      }
    }
  }
  
  private void traitementRejet(DemandeSpec p_demande)
  {
    int motifRejet = p_demande.getDemandePivot().getDecision().getMotifRejet();
    p_demande.setCodeMotifEchecPourSigmaSauvegarde(Integer.toString(motifRejet));
  }
  
  private boolean estUneDemandeSuiteFinDroit(DemandeSpec p_demande)
  {
    EvenementReferenceExamenSpec ere = p_demande.getEvenementReferenceExamen();
    return ("ASU_08".equals(ere.getTypeExamen())) || ("ASU_11".equals(ere.getTypeExamen())) || ("ASU_12".equals(ere.getTypeExamen()));
  }
  
  private TraceTrackerEnModeEmission alimenterBaseTrackerEmission(ContexteServiceSpec p_contexteService, String p_destinataire, String p_codeFlux)
    throws CoucheLogiqueException
  {
    return AlimenterBaseTracker.alimenterDonneesEnModeEmission(p_contexteService, p_destinataire, p_codeFlux, null, null, null, null);
  }
  
  private void alimenterBaseEchange(DemandeSpec p_demande, String p_idTracker)
    throws ApplicativeException
  {
    fr.unedic.cali.dom.echange.Decision demandeBaseEchange = AlimenterBaseEchanges.alimenterDonneesHorsGamme(p_demande, p_idTracker);
    DomManager.persisterEnProfondeur(demandeBaseEchange);
    
    OutilTrace.ecrireTrace(Niveau.INFO, new Object[] { "Alimentation de la base Echange : \t Id Tracker : ", p_idTracker, "\n", "\t Type de demande : ", p_demande.getGamme().getNomUnique(), "\n", "\t Identifiant de la demande : ", p_demande.getIdentifiant() });
  }
}

/* Location:
 * Qualified Name:     ParcoursPopulationDemandeFinDroitSpectacle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */