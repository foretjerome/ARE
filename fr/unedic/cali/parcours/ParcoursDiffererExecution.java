package fr.unedic.cali.parcours;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.CodeReexamen;
import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.outilsfonctionnels.AlimenterBaseTracker;
import fr.unedic.cali.outilsfonctionnels.TraceTrackerEnModeEmission;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Damj;

public class ParcoursDiffererExecution
  extends ParcoursServiceAbstrait
{
  public Resultat demarrerParcours(Contexte contexte)
    throws ApplicativeException
  {
    Resultat resultat = new Resultat();
    Damj dateExecutionDifferee = null;
    Damj dateDomExecutionDifferee = null;
    DomCaliOptimise domCali = (DomCaliOptimise)contexte.getDonnees();
    if (domCali.isBesoinAlimentationReception()) {
      AlimenterBaseTracker.alimenterDonneesEnModeReception(domCali.getContexteService());
    }
    dateDomExecutionDifferee = domCali.getDateExecutionDifferee();
    dateExecutionDifferee = domCali.getIndividu().getDateExecutionDifferee();
    if (dateExecutionDifferee != null)
    {
      if (dateExecutionDifferee.estApres(dateDomExecutionDifferee)) {
        mettreAJourEvenementReexecution(domCali, dateDomExecutionDifferee);
      }
    }
    else
    {
      mettreAJourEvenementReexecution(domCali, dateDomExecutionDifferee);
      TraceTrackerEnModeEmission trace = AlimenterBaseTracker.alimenterDonneesEnModeEmission(domCali.getContexteService(), "D90", "DCADI", dateDomExecutionDifferee, null, null, "DemandeEcrireEvtAsync");
      if ("TD".equals(domCali.getContexteService().getContexteEmission())) {
        trace.setIdTracker(null);
      }
      domCali.getIndividu().ajouterTraceTrackerEnModeEmission(trace);
    }
    if (!"D11".equals(domCali.getIndividu().getDomaineSrcFlux())) {
      domCali.getIndividu().setDomaineSrcFlux(domCali.getContexteService().getSrcCodeDomaine());
    }
    resultat.setEtat(0);
    return resultat;
  }
  
  private void mettreAJourEvenementReexecution(DomCali domCali, Damj dateReexecution)
  {
    domCali.getIndividu().setDateExecutionDifferee(dateReexecution);
    
    String codeTransaction = domCali.getContexteService().getSrcCodeTransaction();
    if ("D11".equals(domCali.getContexteService().getSrcCodeDomaine())) {
      codeTransaction = "GAEC";
    }
    domCali.getIndividu().setCodeTransaction(CodeReexamen.determineCodeReexamenTP(codeTransaction));
  }
  
  protected int getModeChargementDebrayageDossiersLourds(Individu individu)
  {
    return 0;
  }
  
  protected void alimenterAgregatGaec(Individu individu, String idDemande)
  {
    individu.getDonneesChargementGaec().getAgregatGaec().setModeAppel(0);
  }
  
  protected void controlerPostTraitement(Individu individu)
    throws AccesDonneesGaecException
  {
    controlerModeAppel(individu.getDonneesChargementGaec().getAppelGaecReduit(), 0);
  }
}

/* Location:
 * Qualified Name:     ParcoursDiffererExecution
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */