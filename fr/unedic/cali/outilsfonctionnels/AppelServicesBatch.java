package fr.unedic.cali.outilsfonctionnels;

import fr.pe.cali.client.ManagerAppelsServicesD90;
import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.d90.donnees.d90.service.vls.CriteresEcrireEvenementAsynchrone;
import fr.unedic.d90.donnees.d90.service.vls.CriteresEcrireEvtDesengAide;
import fr.unedic.d90.donnees.d90.service.vls.CriteresEcrireEvtDesengAide_listeParametres;
import fr.unedic.d90.donnees.d90.service.vls.CriteresEcrireODF;
import fr.unedic.d90.donnees.d90.service.vls.Flux;
import fr.unedic.d90.donnees.d90.service.vls.FluxCali;
import fr.unedic.d90.donnees.d90.service.vls.FluxCaliDeseng;
import fr.unedic.d90.donnees.d90.service.vls.ListeParametres;
import fr.unedic.d90.donnees.d90.service.vls.ListeRSOD;
import fr.unedic.d90.donnees.d90.service.vls.Parametre;
import fr.unedic.d90.donnees.d90.service.vls.RSOD;
import fr.unedic.util.services.ApplicativeRuntimeException;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.services.ContexteServiceSpec;
import fr.unedic.util.services.OutilFonctionnel;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Iterator;

public final class AppelServicesBatch
  implements OutilFonctionnel
{
  public static void appelServiceEcrireEvenement(ContexteServiceSpec contexteService, Damj date, String casUtilisation)
  {
    try
    {
      ManagerAppelsServicesD90 domaineD90 = new ManagerAppelsServicesD90();
      CriteresEcrireEvenementAsynchrone criteresEcrireEvenementAsynchrone = CriteresEcrireEvenementAsynchrone.getInstance();
      contexteService.setCodeActivite("CALI");
      criteresEcrireEvenementAsynchrone.setContexteService(AppelServicesAbstrait.contexteServiceDomVersVlsD90((ContexteService)contexteService));
      
      criteresEcrireEvenementAsynchrone.getFlux();
      criteresEcrireEvenementAsynchrone.setNewFlux();
      criteresEcrireEvenementAsynchrone.getFlux().setNewFluxCali();
      criteresEcrireEvenementAsynchrone.getFlux().getFluxCali().setCxass(contexteService.getSrcCodeAssedic());
      criteresEcrireEvenementAsynchrone.getFlux().getFluxCali().setCxala(contexteService.getCxala().toString());
      criteresEcrireEvenementAsynchrone.getFlux().getFluxCali().setRsin(contexteService.getRsin());
      criteresEcrireEvenementAsynchrone.getFlux().getFluxCali().setDateReexecution(date);
      criteresEcrireEvenementAsynchrone.getFlux().getFluxCali().setDateTraitement(new Damj());
      criteresEcrireEvenementAsynchrone.setNewListeParametres();
      Parametre vlsParametre = criteresEcrireEvenementAsynchrone.getListeParametres().addParametre();
      vlsParametre.setId("CasUtilisation");
      vlsParametre.setValeur(casUtilisation);
      if ("TD".equals(contexteService.getContexteEmission())) {
        domaineD90.ecrireEvenementAsynchrone(criteresEcrireEvenementAsynchrone);
      } else {
        domaineD90.ecrireEvenementAsynchroneAsync(criteresEcrireEvenementAsynchrone);
      }
    }
    catch (ApplicativeException e)
    {
      throw new ApplicativeRuntimeException("HG_PR_CALI_L_APPEL_CALI_D90", "Problème lors de l'appel de service de CALI vers D90", e);
    }
    catch (TechniqueException e)
    {
      throw new ApplicativeRuntimeException("HG_PR_CALI_L_APPEL_CALI_D90", "Problème lors de l'appel de service de CALI vers D90", e);
    }
  }
  
  public static ContexteServiceSpec miseEnConformiteContexteService(ContexteService contexteService)
  {
    ContexteServiceSpec contexte = (ContexteServiceSpec)contexteService.copie();
    if (contexteService.getIdFlux() != null) {
      contexte.setIdFlux(new BigDecimal(contexteService.getIdFlux().toString()));
    }
    return contexte;
  }
  
  public static void appelServiceEcrireODF(TraceTrackerEnModeEmission trace)
  {
    try
    {
      ContexteServiceSpec contexteService = trace.getContexteService();
      
      CriteresEcrireODF criteresEcrireODF = CriteresEcrireODF.getInstance();
      criteresEcrireODF.setContexteService(AppelServicesAbstrait.contexteServiceDomVersVlsD90((ContexteService)contexteService));
      criteresEcrireODF.setNewListeRSOD();
      
      Collection listeRsod = trace.getListeRsodAttributionFrontaliere();
      
      Iterator iterateur = listeRsod.iterator();
      while (iterateur.hasNext())
      {
        String rsod = (String)iterateur.next();
        RSOD rsodVls = criteresEcrireODF.getListeRSOD().addRSOD();
        rsodVls.setRSOD(rsod);
      }
      boolean estContexteBatch = trace.getContexteService().getContexteEmission().equals("TD");
      if (estContexteBatch)
      {
        ManagerAppelsServicesD90 domaineD90Synch = new ManagerAppelsServicesD90();
        domaineD90Synch.ecrireODF(criteresEcrireODF);
      }
      else
      {
        ManagerAppelsServicesD90 domaineD90 = new ManagerAppelsServicesD90();
        domaineD90.ecrireODFAsync(criteresEcrireODF);
      }
    }
    catch (ApplicativeException e)
    {
      throw new ApplicativeRuntimeException("HG_PR_CALI_L_APPEL_CALI_D90", "Problème lors de l'appel de service de CALI vers D90", e);
    }
    catch (TechniqueException e)
    {
      throw new ApplicativeRuntimeException("HG_PR_CALI_L_APPEL_CALI_D90", "Problème lors de l'appel de service de CALI vers D90", e);
    }
  }
  
  public static void appelEvenementDesengagementAide(ContexteServiceSpec contexteService, String referenceExterne, Damj dateEvenement, String casUtilisation)
  {
    try
    {
      ManagerAppelsServicesD90 domaineD90 = new ManagerAppelsServicesD90();
      
      CriteresEcrireEvtDesengAide criteresEvtDesengAide = CriteresEcrireEvtDesengAide.getInstance();
      criteresEvtDesengAide.setContexteService(AppelServicesAbstrait.contexteServiceDomVersVlsD90((ContexteService)contexteService));
      criteresEvtDesengAide.setNewFlux();
      criteresEvtDesengAide.getFlux().setNewFluxCaliDeseng();
      criteresEvtDesengAide.getFlux().getFluxCaliDeseng().setRsin(contexteService.getRsin());
      criteresEvtDesengAide.getFlux().getFluxCaliDeseng().setCxala(contexteService.getCxala().toString());
      criteresEvtDesengAide.getFlux().getFluxCaliDeseng().setCxass(contexteService.getSrcCodeAssedic());
      criteresEvtDesengAide.getFlux().getFluxCaliDeseng().setDateAppel(dateEvenement);
      criteresEvtDesengAide.getFlux().getFluxCaliDeseng().setIdAide(referenceExterne);
      CriteresEcrireEvtDesengAide_listeParametres listeParametres = CriteresEcrireEvtDesengAide_listeParametres.getInstance();
      criteresEvtDesengAide.setListeParametres(listeParametres);
      Parametre parametre = listeParametres.addParametre();
      parametre.setId("CasUtilisation");
      parametre.setValeur(casUtilisation);
      
      boolean estContexteBatch = contexteService.getContexteEmission().equals("TD");
      if (estContexteBatch) {
        domaineD90.ecrireEvtDesengAide(criteresEvtDesengAide);
      } else {
        domaineD90.ecrireEvtDesengAideAsync(criteresEvtDesengAide);
      }
    }
    catch (ApplicativeException ex)
    {
      throw new ApplicativeRuntimeException("HG_PR_CALI_L_APPEL_CALI_D90", "Problème lors de l'appel de service de CALI vers D90", ex);
    }
    catch (TechniqueException ex)
    {
      throw new ApplicativeRuntimeException("HG_PR_CALI_L_APPEL_CALI_D90", "Problème lors de l'appel de service de CALI vers D90", ex);
    }
  }
}

/* Location:
 * Qualified Name:     AppelServicesBatch
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */