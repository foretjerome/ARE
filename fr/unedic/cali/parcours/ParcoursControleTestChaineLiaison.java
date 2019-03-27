package fr.unedic.cali.parcours;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.autresdoms.ga.services.AppelServicesGaec;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.cali.outilsfonctionnels.AppelServicesCojac;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteException;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.services.Parcours;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Damj;

public class ParcoursControleTestChaineLiaison
  extends Parcours
{
  public void controlerContexte(Contexte p_contexte)
    throws ContexteException
  {}
  
  public Resultat demarrer(Contexte p_contexte)
    throws ApplicativeException
  {
    ResultatControleTestChaineLiaison resultat = new ResultatControleTestChaineLiaison();
    
    resultat.setEtat(1);
    if (Log.isTraceActive(ParcoursControleTestChaineLiaison.class, Niveau.DEBUG)) {
      Log.ecritTrace(Niveau.DEBUG, ParcoursControleTestChaineLiaison.class, "demarrer", "\t\t******** Début Parcours ParcoursControleTestChaineLiaison ********\n");
    }
    ContexteService contexteService = DomControleTestChaineLiaison.getContexteService(p_contexte);
    
    resultat.setPersistanceCali(controlePersistanceCali(contexteService.getDateTraitement()));
    
    AppelServicesGaec.controleTestProductionGaec(contexteService, resultat);
    
    AppelServicesCojac.controleTestProductionCohabitation(contexteService, resultat);
    if (Log.isTraceActive(ParcoursControleTestChaineLiaison.class, Niveau.DEBUG)) {
      Log.ecritTrace(Niveau.DEBUG, ParcoursControleTestChaineLiaison.class, "demarrer", "\t\t******** Fin Parcours ParcoursControleTestChaineLiaison ********\n");
    }
    return resultat;
  }
  
  public ContexteService getContexteService(Contexte p_contexte)
  {
    DomControleTestChaineLiaison domControleTestChaineLiaison = (DomControleTestChaineLiaison)p_contexte.getDonnees();
    return domControleTestChaineLiaison.getContexteService();
  }
  
  private boolean controlePersistanceCali(Damj p_dateDuJour)
  {
    if (DomManager.getTestProduction(p_dateDuJour) != null) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     ParcoursControleTestChaineLiaison
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */