package fr.unedic.cali.autresdoms.ga.services;

import fr.pe.cali.client.ManagerAppelsServicesGestionActivite;
import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.autresdoms.ga.dom.IndividuImplPersistant;
import fr.unedic.cali.autresdoms.ga.mapping.LireListePeriodeResultat;
import fr.unedic.cali.autresdoms.ga.mapping.MapperGa;
import fr.unedic.cali.dom.AppelGaecReduit;
import fr.unedic.cali.dom.DossierExamenSpec;
import fr.unedic.cali.dom.IndividuIdSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.outilsfonctionnels.AlimenterBaseTracker;
import fr.unedic.cali.outilsfonctionnels.AppelServicesAbstrait;
import fr.unedic.cali.outilsfonctionnels.OutilAttribution;
import fr.unedic.cali.outilsfonctionnels.OutilTrace;
import fr.unedic.cali.outilsfonctionnels.TraceTrackerEnModeEmission;
import fr.unedic.cali.parcours.DomCali;
import fr.unedic.cali.parcours.ResultatControleTestChaineLiaison;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ActiviteReduite;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ActiviteReduiteCalcul;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.AttributionTypeAsu;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.CriteresControleTestChaineLiaisonGaec;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.CriteresReceptionFluxCaliTestProd;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.CriteresRecherchePeriodes;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.EnregistrerAbonnementIn;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.EnregistrerActiviteReduiteIn;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.EtatPeriodes;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.IdActiviteReduite;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ListeActivitesReduites;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ListeAttributions;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ListeEtatPeriodes;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ListeTypePeriodes;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.RetourControleTestChaineLiaisonGaec;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.RetourLireListePeriodes;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.TypePeriodes;
import fr.unedic.util.services.ApplicativeRuntimeException;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class AppelServicesGaec
{
  public static final int DEVISE_CODE_EURO = 1;
  
  public static void enregistrerAbonnementGaec(Contexte contexte)
    throws CoucheLogiqueException
  {
    IndividuSpec individu = getIndividu(contexte);
    boolean estAbonneGaec = individu.isEstAbonneGaec();
    if (!estAbonneGaec)
    {
      Abonnement abonnement = new Abonnement();
      
      abonnement.setIdentifiantAbonnement(individu.getContexteService().getCxala().toString());
      
      abonnement.setNumeroAllocataire(individu.getNumeroAllocataire());
      
      TraceTrackerEnModeEmission trace = lancerServiceEnregistrerAbonnement(individu, abonnement, ((DomCali)contexte.getDonnees()).getContexteService());
      if (trace != null) {
        individu.ajouterTraceTrackerEnModeEmission(trace);
      }
    }
  }
  
  private static TraceTrackerEnModeEmission lancerServiceEnregistrerAbonnement(IndividuSpec individu, Abonnement pabonnement, fr.unedic.util.services.ContexteService contexteService)
  {
    TraceTrackerEnModeEmission trace = null;
    try
    {
      if ((contexteService != null) && (contexteService.getContexteEmission() != null) && (contexteService.getContexteEmission().equals("TD")))
      {
        EnregistrerAbonnementIn serviceIn = alimentationVlsAbonneGaec(pabonnement);
        
        ManagerAppelsServicesGestionActivite domaineGA = new ManagerAppelsServicesGestionActivite();
        
        AppelServicesAbstrait.miseAJourContexteServiceDomPourTracker(contexteService, "D11", "ABONNE");
        
        OutilTrace.ecrireTrace(Niveau.DEBUG, new Object[] { "\t Appel de service synchrone Gaec - domaineGASync.enregistrerAbonnement \n" });
        
        serviceIn.setContexteService(AppelServicesAbstrait.contexteServiceDomVersVlsGaec(contexteService));
        domaineGA.enregistrerAbonnement(serviceIn);
      }
      else
      {
        Abonnement abonnement = pabonnement.copie();
        
        trace = AlimenterBaseTracker.alimenterDonneesEnModeEmission(contexteService, "D11", "ABONNE", null, null, abonnement, null);
      }
      individu.setEstAbonneGaec(true);
      
      return trace;
    }
    catch (ApplicativeException e)
    {
      OutilTrace.ecrireTrace(Niveau.DEBUG, null, e);
      throw new ApplicativeRuntimeException("HG_PR_CALI_L_APPEL_CALI_GAEC", "Problème lors de l'appel de service de CALI vers GAEC", e);
    }
    catch (TechniqueException e)
    {
      OutilTrace.ecrireTrace(Niveau.DEBUG, null, e);
      throw new ApplicativeRuntimeException("HG_PR_CALI_L_APPEL_CALI_GAEC", "Problème lors de l'appel de service de CALI vers GAEC", e);
    }
  }
  
  private static EnregistrerAbonnementIn alimentationVlsAbonneGaec(Abonnement abonnement)
  {
    EnregistrerAbonnementIn serviceIn = EnregistrerAbonnementIn.getInstance();
    
    fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.Abonnement abonnementIn = fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.Abonnement.getInstance();
    abonnementIn.setDateDebut(abonnement.getPeriodeAbonnement().getDebut());
    abonnementIn.setDateFin(abonnement.getPeriodeAbonnement().getFin());
    abonnementIn.setIdentifiantAbonnementSouscripteur(abonnement.getIdentifiantAbonnement());
    abonnementIn.setOrigineSouscripteur(abonnement.getOrigineSouscripteur());
    abonnementIn.setDomaineSouscripteur(abonnement.getDomaineSouscripteur());
    serviceIn.setNumeroAllocataire(abonnement.getNumeroAllocataire());
    serviceIn.setAbonnement(abonnementIn);
    
    return serviceIn;
  }
  
  public static void appelAsynchroneAbonneGaec(fr.unedic.util.services.ContexteService contexteService, TraceTrackerEnModeEmission trace)
    throws TechniqueException, ApplicativeException
  {
    EnregistrerAbonnementIn serviceIn = alimentationVlsAbonneGaec(trace.getAbonnement());
    
    ManagerAppelsServicesGestionActivite domaineGA = new ManagerAppelsServicesGestionActivite();
    
    serviceIn.setContexteService(AppelServicesAbstrait.contexteServiceDomVersVlsGaec(contexteService));
    
    domaineGA.enregistrerAbonnementAsync(serviceIn);
  }
  
  public static void enregistrerLA2K(IndividuSpec individu, Damj dateDebutExecutionParametre, fr.unedic.util.services.ContexteService contexteService, int contexteExecution)
  {
    String codeFlux = "";
    Damj dateDebutExecution = dateDebutExecutionParametre;
    if (contexteExecution == 0) {
      codeFlux = "MAJAR";
    } else if (contexteExecution == 1) {
      codeFlux = "MAJARM";
    }
    try
    {
      if ((contexteService != null) && (contexteService.getContexteEmission() != null) && (contexteService.getContexteEmission().equals("TD")))
      {
        ManagerAppelsServicesGestionActivite domaineGA = new ManagerAppelsServicesGestionActivite();
        if (individu.getListeLA2K() != null)
        {
          Iterator<?> iter = individu.getListeLA2K().iterator();
          if (iter.hasNext())
          {
            LA2K la2k = (LA2K)iter.next();
            dateDebutExecution = la2k.getDateDebutExecution();
          }
        }
        EnregistrerActiviteReduiteIn serviceIn = alimentationVlsLA2KGaec(individu, dateDebutExecution, individu.getListeLA2K());
        
        AppelServicesAbstrait.miseAJourContexteServiceDomPourTracker(contexteService, "D11", codeFlux);
        
        serviceIn.setContexteService(AppelServicesAbstrait.contexteServiceDomVersVlsGaec(contexteService));
        domaineGA.enregistrerActiviteReduite(serviceIn);
      }
      else
      {
        Collection<?> listeActiviteReduite = alimentationTraceTrackerEnModeEmission(individu);
        if (listeActiviteReduite != null)
        {
          Iterator<?> iter = listeActiviteReduite.iterator();
          if (iter.hasNext())
          {
            LA2K la2k = (LA2K)iter.next();
            dateDebutExecution = la2k.getDateDebutExecution();
          }
        }
        TraceTrackerEnModeEmission trace = AlimenterBaseTracker.alimenterDonneesEnModeEmission(contexteService, "D11", codeFlux, dateDebutExecution, listeActiviteReduite, null, null);
        
        TraceTrackerEnModeEmission traceLA2K = traceTrackerEnModeEmissionContientLA2K(individu);
        if (traceLA2K != null)
        {
          listeActiviteReduite = fusionLA2K(listeActiviteReduite, traceLA2K.getListeActiviteReduite(), dateDebutExecution, traceLA2K.getDateDebut());
          
          trace.setListeActiviteReduite(listeActiviteReduite);
          trace.setDateDebut(Damj.min(dateDebutExecution, traceLA2K.getDateDebut()));
          individu.retirerTraceTrackerEnModeEmission(traceLA2K);
        }
        individu.ajouterTraceTrackerEnModeEmission(trace);
      }
    }
    catch (ApplicativeException e)
    {
      throw new ApplicativeRuntimeException("HG_PR_CALI_L_APPEL_CALI_GAEC", "Problème lors de l'appel de service de CALI vers GAEC", e);
    }
    catch (TechniqueException e)
    {
      throw new ApplicativeRuntimeException("HG_PR_CALI_L_APPEL_CALI_GAEC", "Problème lors de l'appel de service de CALI vers GAEC", e);
    }
  }
  
  public static void appelAsynchroneLA2KGaec(IndividuSpec individu, fr.unedic.util.services.ContexteService contexteService, TraceTrackerEnModeEmission trace)
    throws TechniqueException, ApplicativeException
  {
    EnregistrerActiviteReduiteIn serviceIn = alimentationVlsLA2KGaec(individu, trace.getDateDebut(), trace.getListeActiviteReduite());
    
    ManagerAppelsServicesGestionActivite domaineGA = new ManagerAppelsServicesGestionActivite();
    
    serviceIn.setContexteService(AppelServicesAbstrait.contexteServiceDomVersVlsGaec(contexteService));
    
    domaineGA.enregistrerActiviteReduiteAsync(serviceIn);
  }
  
  private static Collection fusionLA2K(Collection listeActiviteReduitePrincipale, Collection listeActiviteReduiteDiffere, Damj dateDebutPrincipale, Damj dateDebutDifferee)
  {
    Collection listeActiviteReduiteFusionnee = null;
    Collection listeActiviteReduiteFusionneeTemp = new ArrayList();
    LA2K la2k = null;
    if (dateDebutPrincipale.estAvantOuCoincideAvec(dateDebutDifferee)) {
      listeActiviteReduiteFusionnee = listeActiviteReduitePrincipale;
    }
    if (dateDebutPrincipale.estApres(dateDebutDifferee))
    {
      Iterator iter = listeActiviteReduiteDiffere.iterator();
      while (iter.hasNext())
      {
        la2k = (LA2K)iter.next();
        Damj date = new Damj(la2k.getAnnee(), la2k.getMois(), 1);
        if (date.estAvant(dateDebutPrincipale)) {
          listeActiviteReduiteFusionneeTemp.add(la2k);
        }
      }
      if (listeActiviteReduitePrincipale != null) {
        listeActiviteReduiteFusionneeTemp.addAll(listeActiviteReduitePrincipale);
      }
      listeActiviteReduiteFusionnee = listeActiviteReduiteFusionneeTemp;
    }
    return listeActiviteReduiteFusionnee;
  }
  
  private static TraceTrackerEnModeEmission traceTrackerEnModeEmissionContientLA2K(IndividuSpec individu)
  {
    TraceTrackerEnModeEmission trace = null;
    Iterator<?> iter = individu.getListeTraceTrackerEnModeEmission().iterator();
    while (iter.hasNext())
    {
      trace = (TraceTrackerEnModeEmission)iter.next();
      if (("MAJAR".equalsIgnoreCase(trace.getCodeFlux())) || ("MAJARM".equalsIgnoreCase(trace.getCodeFlux()))) {
        break;
      }
      trace = null;
    }
    return trace;
  }
  
  private static EnregistrerActiviteReduiteIn alimentationVlsLA2KGaec(IndividuSpec individu, Damj dateDebutExecution, Collection listeActiviteReduite)
  {
    EnregistrerActiviteReduiteIn serviceIn = EnregistrerActiviteReduiteIn.getInstance();
    
    serviceIn.setDateDebutAnalyse(dateDebutExecution);
    
    ListeActivitesReduites listeActivitesReduites = serviceIn.setNewListeActivitesReduites();
    
    ActiviteReduiteCalcul activiteReduiteCalcul = null;
    ActiviteReduite activiteReduite = null;
    IdActiviteReduite idActiviteReduite = null;
    
    Iterator i = listeActiviteReduite.iterator();
    while (i.hasNext())
    {
      LA2K la2k = (LA2K)i.next();
      
      activiteReduite = listeActivitesReduites.addActiviteReduite();
      
      activiteReduiteCalcul = activiteReduite.setNewActiviteReduiteCalcul();
      
      activiteReduiteCalcul.setNbHeure(la2k.getNbHeure());
      activiteReduiteCalcul.setSalaireBrut(la2k.getSalaireBrut());
      activiteReduiteCalcul.setCodeMemeEmployeur(new BigDecimal(la2k.getCodeMemeEmployeur()));
      activiteReduiteCalcul.setNbJrDecForce(la2k.getNbJrDecForce());
      activiteReduiteCalcul.setNbJrTravailCumul(la2k.getNbJrTravailCumul());
      activiteReduiteCalcul.setCompletude(la2k.getCompletude());
      activiteReduiteCalcul.setSanctionPND(new BigDecimal(la2k.getSanctionPND()));
      activiteReduiteCalcul.setInfoTravailDSM(la2k.getInfoTravailDSM());
      activiteReduiteCalcul.setSalaireBrutPND(la2k.getSalaireBrutPND());
      activiteReduiteCalcul.setSalaireBrutJustifie(la2k.getSalaireBrutJustifie());
      activiteReduiteCalcul.setNbHeureJustifie(la2k.getNbHeureJustifie());
      activiteReduiteCalcul.setNbJrDecCalcul(la2k.getNbJrDecCalcul());
      activiteReduiteCalcul.setValResultJustPND(la2k.getValResultJustPND());
      activiteReduiteCalcul.setIndicateurPeriodeSpectacle(new BigDecimal(la2k.getCodePopulation()));
      activiteReduiteCalcul.setPresenceDNJ(la2k.getPresenceDnj());
      activiteReduiteCalcul.setMontantActiviteReprise(la2k.getSalaireBrutReprise());
      activiteReduiteCalcul.setNbrHeuresActiviteReprise(la2k.getNbHeureReprise());
      activiteReduiteCalcul.setEstForfaitPANS(la2k.getEstForfaitPans());
      activiteReduiteCalcul.setMontantPANS(la2k.getMontantPANS());
      
      idActiviteReduite = activiteReduite.setNewIdActiviteReduite();
      
      idActiviteReduite.setIdAllocataire(individu.getNumeroAllocataire());
      idActiviteReduite.setAnneeImputation(new BigDecimal(la2k.getAnnee()));
      idActiviteReduite.setMoisImputation(new BigDecimal(la2k.getMois()));
    }
    return serviceIn;
  }
  
  public static Collection alimentationTraceTrackerEnModeEmission(IndividuSpec individu)
  {
    Collection listeActiviteReduite = null;
    
    Iterator i = individu.getListeLA2K().iterator();
    if (i.hasNext()) {
      listeActiviteReduite = new ArrayList();
    }
    while (i.hasNext())
    {
      LA2K la2k = (LA2K)i.next();
      LA2K copie = la2k.copie();
      listeActiviteReduite.add(copie);
    }
    return listeActiviteReduite;
  }
  
  public static LireListePeriodeResultat lireListePeriodeAppelGaecReduit(IndividuIdSpec identifiant, AppelGaecReduit appelGaecReduit)
    throws CoucheLogiqueException
  {
    if (appelGaecReduit.getModeAppel() == 2) {
      return lireListePeriode(identifiant);
    }
    if (appelGaecReduit.getModeAppel() == 1)
    {
      CriteresRecherchePeriodes criteresRecherchePeriodes = CriteresRecherchePeriodes.getInstance();
      
      criteresRecherchePeriodes.setDateDebutFinale(appelGaecReduit.getDateFinFenetreAppel());
      criteresRecherchePeriodes.setDateFinInitiale(appelGaecReduit.getDateDebutFenetreAppelValide());
      criteresRecherchePeriodes.setDeterminationDNJ(Boolean.valueOf(appelGaecReduit.isDnj()));
      criteresRecherchePeriodes.setSalaireAvecPND(Boolean.valueOf(appelGaecReduit.isPnd()));
      criteresRecherchePeriodes.setIdentifiant(appelGaecReduit.getIdentifiantPeriodeGaec());
      criteresRecherchePeriodes.setListeTypePeriodes(construireListeTypePeriodes(appelGaecReduit));
      
      return lireListePeriode(identifiant, criteresRecherchePeriodes);
    }
    return null;
  }
  
  private static ListeTypePeriodes construireListeTypePeriodes(AppelGaecReduit appelGaecReduit)
  {
    ListeTypePeriodes listeTypePeriodes = null;
    if (appelGaecReduit.getTypePeriodes() != null)
    {
      Iterator<?> it = appelGaecReduit.getTypePeriodes().iterator();
      if (appelGaecReduit.getTypePeriodes().size() == 1)
      {
        String codeTypePeriode = (String)it.next();
        if ((codeTypePeriode != "999") && (codeTypePeriode != "0"))
        {
          listeTypePeriodes = ListeTypePeriodes.getInstance();
          
          TypePeriodes typePeriode = TypePeriodes.getInstance();
          typePeriode.setTypePeriode(new BigDecimal(codeTypePeriode));
          typePeriode.setIdentifiant(codeTypePeriode);
          
          listeTypePeriodes.addTypePeriodes(typePeriode);
        }
      }
      else
      {
        listeTypePeriodes = ListeTypePeriodes.getInstance();
        while (it.hasNext())
        {
          String codeTypePeriode = (String)it.next();
          
          TypePeriodes typePeriode = TypePeriodes.getInstance();
          typePeriode.setTypePeriode(new BigDecimal(codeTypePeriode));
          typePeriode.setIdentifiant(codeTypePeriode);
          
          listeTypePeriodes.addTypePeriodes(typePeriode);
        }
      }
    }
    return listeTypePeriodes;
  }
  
  public static LireListePeriodeResultat lireListePeriode(IndividuIdSpec identifiant)
    throws CoucheLogiqueException
  {
    CriteresRecherchePeriodes criteresRecherchePeriodes = CriteresRecherchePeriodes.getInstance();
    criteresRecherchePeriodes.setDeterminationDNJ(Boolean.valueOf(true));
    criteresRecherchePeriodes.setSalaireAvecPND(Boolean.valueOf(true));
    
    return lireListePeriode(identifiant, criteresRecherchePeriodes);
  }
  
  private static LireListePeriodeResultat lireListePeriode(IndividuIdSpec identifiant, CriteresRecherchePeriodes criteresRecherchePeriodes)
    throws CoucheLogiqueException
  {
    LireListePeriodeResultat resultat = null;
    
    ListeEtatPeriodes vlsListeEtatPeriodes = null;
    EtatPeriodes vlsEtatPeriodes = null;
    ListeAttributions vlsListeAttributions = null;
    AttributionTypeAsu vlsAttribution = null;
    
    criteresRecherchePeriodes.setNumeroAllocataire(identifiant.getIndividu().getNumeroAllocataire());
    
    List<?> listeAttributions = identifiant.getIndividu().getListeAttributionsASUPendantPeriode(new Periode(Damj.NUIT_DES_TEMPS, Damj.FIN_DES_TEMPS));
    
    vlsListeAttributions = ListeAttributions.getInstance();
    if ((listeAttributions != null) && (!listeAttributions.isEmpty()))
    {
      Iterator<?> iteratorAttributions = listeAttributions.iterator();
      while (iteratorAttributions.hasNext())
      {
        DossierExamenSpec attribution = (DossierExamenSpec)iteratorAttributions.next();
        vlsAttribution = vlsListeAttributions.addAttributionTypeAsu();
        if (attribution != null)
        {
          vlsAttribution.setDateAttribution(attribution.getDateAttribution());
          if (OutilAttribution.getInstance().estUneAttributionSpectacle(attribution)) {
            vlsAttribution.setNature(new BigDecimal(1));
          } else {
            vlsAttribution.setNature(new BigDecimal(0));
          }
        }
        else
        {
          vlsAttribution.setDateAttribution(null);
          vlsAttribution.setNature(null);
        }
      }
    }
    criteresRecherchePeriodes.setListeAttributions(vlsListeAttributions);
    
    vlsListeEtatPeriodes = ListeEtatPeriodes.getInstance();
    vlsEtatPeriodes = vlsListeEtatPeriodes.addEtatPeriodes();
    vlsEtatPeriodes.setEtatPeriode(new BigDecimal(1));
    criteresRecherchePeriodes.setListeEtatPeriodes(vlsListeEtatPeriodes);
    criteresRecherchePeriodes.setCodeDevise(new BigDecimal(1));
    
    fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ContexteService contexteServiceVls = AppelServicesAbstrait.contexteServiceDomVersVlsGaec(identifiant.getIndividu().getContexteService());
    contexteServiceVls.setSrcCodeDomaine("D12");
    contexteServiceVls.setDstCodeDomaine("D11");
    
    criteresRecherchePeriodes.setContexteService(contexteServiceVls);
    try
    {
      ManagerAppelsServicesGestionActivite domaineGa = new ManagerAppelsServicesGestionActivite();
      if (Log.isTraceActive(IndividuImplPersistant.class, Niveau.DEBUG)) {
        Log.ecritTrace(Niveau.DEBUG, IndividuImplPersistant.class, "appelServiceLireListePeriode", "\t Appel de service Gaec - lireListePeriode \n");
      }
      RetourLireListePeriodes serviceOut = domaineGa.lireListePeriode(criteresRecherchePeriodes);
      resultat = MapperGa.mapperPeriodes(serviceOut);
    }
    catch (ApplicativeException e)
    {
      throw new ApplicativeRuntimeException("HG_PR_CALI_L_APPEL_CALI_GAEC", "Problème lors de l'appel de service de CALI vers GAEC", e);
    }
    catch (TechniqueException e)
    {
      throw new ApplicativeRuntimeException("HG_PR_CALI_L_APPEL_CALI_GAEC", "Problème lors de l'appel de service de CALI vers GAEC", e);
    }
    return resultat;
  }
  
  public static void testProductionGaec(fr.unedic.util.services.ContexteService contexteService)
  {
    try
    {
      CriteresReceptionFluxCaliTestProd donneesIn = CriteresReceptionFluxCaliTestProd.getInstance();
      
      ManagerAppelsServicesGestionActivite domaineGa = new ManagerAppelsServicesGestionActivite();
      
      AlimenterBaseTracker.alimenterDonneesEnModeEmission(contexteService, "D11", "ABONNE");
      if (Log.isTraceActive(AppelServicesGaec.class, Niveau.DEBUG)) {
        Log.ecritTrace(Niveau.DEBUG, AppelServicesGaec.class, "testProductionGaec", "\t Appel de service asynchrone Gaec - domaineGaAsync.testProductionGaec \n");
      }
      donneesIn.setContexteService(AppelServicesAbstrait.contexteServiceDomVersVlsGaec(contexteService));
      
      domaineGa.receptionFluxCaliTestProdAsync(donneesIn);
    }
    catch (ApplicativeException e)
    {
      if (Log.isTraceActive(AppelServicesGaec.class, Niveau.DEBUG)) {
        Log.ecritTrace(Niveau.DEBUG, AppelServicesGaec.class, "testProductionGaec", e);
      }
    }
    catch (TechniqueException e)
    {
      if (Log.isTraceActive(AppelServicesGaec.class, Niveau.DEBUG)) {
        Log.ecritTrace(Niveau.DEBUG, AppelServicesGaec.class, "testProductionGaec", e);
      }
    }
  }
  
  public static void controleTestProductionGaec(fr.unedic.util.services.ContexteService contexteService, ResultatControleTestChaineLiaison resultat)
  {
    try
    {
      resultat.setPersistanceGaec(false);
      resultat.setSyncV2(false);
      
      CriteresControleTestChaineLiaisonGaec donneesIn = CriteresControleTestChaineLiaisonGaec.getInstance();
      
      donneesIn.setContexteService(AppelServicesAbstrait.contexteServiceDomVersVlsGaec(contexteService));
      
      ManagerAppelsServicesGestionActivite domaineGa = new ManagerAppelsServicesGestionActivite();
      if (Log.isTraceActive(AppelServicesGaec.class, Niveau.DEBUG)) {
        Log.ecritTrace(Niveau.DEBUG, AppelServicesGaec.class, "testProductionGaec", "\t Appel de service asynchrone Gaec - domaineGaAsync.testProductionGaec \n");
      }
      RetourControleTestChaineLiaisonGaec resulat = domaineGa.controleTestChaineLiaisonGaec(donneesIn);
      
      resultat.setPersistanceGaec(resulat.getRelectureTableTemoinOk().booleanValue());
      
      resultat.setSyncV2(true);
    }
    catch (ApplicativeException e)
    {
      if (Log.isTraceActive(AppelServicesGaec.class, Niveau.DEBUG)) {
        Log.ecritTrace(Niveau.DEBUG, AppelServicesGaec.class, "testProductionGaec", e);
      }
    }
    catch (TechniqueException e)
    {
      if (Log.isTraceActive(AppelServicesGaec.class, Niveau.DEBUG)) {
        Log.ecritTrace(Niveau.DEBUG, AppelServicesGaec.class, "testProductionGaec", e);
      }
    }
  }
  
  private static IndividuSpec getIndividu(Contexte contexte)
  {
    DomCali domCali = (DomCali)contexte.getDonnees();
    return domCali.getIndividu();
  }
}

/* Location:
 * Qualified Name:     AppelServicesGaec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */