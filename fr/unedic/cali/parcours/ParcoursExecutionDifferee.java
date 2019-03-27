package fr.unedic.cali.parcours;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.outilsfonctionnels.AppelServicesBatch;
import fr.unedic.cali.outilsfonctionnels.reexecution.OutilExecutionDifferee;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.services.ContexteServiceSpec;
import fr.unedic.util.services.Parcours;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Damj;

public class ParcoursExecutionDifferee
  extends ParcoursServiceAbstrait
{
  public Resultat demarrerParcours(Contexte p_contexte)
    throws ApplicativeException
  {
    Resultat resultat = new Resultat();
    DomCaliOptimise domCali = (DomCaliOptimise)p_contexte.getDonnees();
    if (OutilExecutionDifferee.getInstance().existeUneExecutionDifferee(domCali.getIndividu()))
    {
      Damj dateExecutionDifferee = domCali.getIndividu().getDateExecutionDifferee();
      
      ContexteServiceSpec contexte = AppelServicesBatch.miseEnConformiteContexteService(domCali.getContexteService());
      DomReexecutionCali domReexecutionCali = new DomReexecutionCali();
      domReexecutionCali.setIndividu(domCali.getIndividu());
      domReexecutionCali.setContexteService((ContexteService)contexte);
      domReexecutionCali.setDate(dateExecutionDifferee);
      Contexte contexteReexecution = new Contexte();
      contexteReexecution.setDonnees(domReexecutionCali);
      contexteReexecution.setCodeService(p_contexte.getCodeService());
      contexteReexecution.setModeTrace(p_contexte.isModeTrace());
      
      Parcours parcours = new ParcoursReexecutionCali();
      
      parcours.controlerContexte(contexteReexecution);
      
      resultat = parcours.demarrer(contexteReexecution);
      
      domCali.setExecutionDiffereeTraitee(true);
      OutilExecutionDifferee.getInstance().annulerExecutionDifferePourBatch(domCali, dateExecutionDifferee);
      OutilExecutionDifferee.getInstance().supprimerExecutionDifferee(domCali.getIndividu());
    }
    resultat.setEtat(0);
    return resultat;
  }
  
  protected int getModeChargementDebrayageDossiersLourds(Individu p_individu)
  {
    return 2;
  }
  
  protected void alimenterAgregatGaec(Individu p_individu, String p_idDemande)
  {
    if (p_individu != null) {
      p_individu.getDonneesChargementGaec().getAgregatGaec().setModeAppel(2);
    }
  }
  
  protected void controlerPostTraitement(Individu p_individu)
    throws AccesDonneesGaecException
  {
    controlerModeAppel(p_individu.getDonneesChargementGaec().getAppelGaecReduit(), 2);
  }
}

/* Location:
 * Qualified Name:     ParcoursExecutionDifferee
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */