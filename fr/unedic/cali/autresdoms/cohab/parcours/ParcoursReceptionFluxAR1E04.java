package fr.unedic.cali.autresdoms.cohab.parcours;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.autresdoms.ga.services.AppelServicesGaec;
import fr.unedic.cali.dom.TestProduction;
import fr.unedic.cali.outilsfonctionnels.AlimenterBaseTracker;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteException;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.services.Parcours;
import fr.unedic.util.services.Resultat;

public class ParcoursReceptionFluxAR1E04
  extends Parcours
{
  public void controlerContexte(Contexte p_contexte)
    throws ContexteException
  {}
  
  public Resultat demarrer(Contexte p_contexte)
    throws ApplicativeException
  {
    ContexteService contexteService = DomReceptionFluxAR1E04.getContexteService(p_contexte);
    
    AlimenterBaseTracker.alimenterDonneesEnModeReception(contexteService);
    
    TestProduction testProduction = new TestProduction();
    testProduction.setDateJour(contexteService.getDateTraitement());
    testProduction.marquerGraphePersistant();
    
    AppelServicesGaec.testProductionGaec(contexteService);
    
    return new Resultat();
  }
  
  public ContexteService getContexteService(Contexte p_contexte)
  {
    DomReceptionFluxAR1E04 domTestProd = (DomReceptionFluxAR1E04)p_contexte.getDonnees();
    return domTestProd.getContexteService();
  }
}

/* Location:
 * Qualified Name:     ParcoursReceptionFluxAR1E04
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */