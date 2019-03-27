package fr.unedic.cali.autresdoms.d90.outilsfonctionnels;

import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.autresdoms.d90.dom.comportement.ComportementBatchDefaut;
import fr.unedic.cali.autresdoms.d90.dom.comportement.ComportementBatchDefautMandatementAuto;
import fr.unedic.cali.autresdoms.d90.dom.comportement.ComportementBatchGaec;
import fr.unedic.cali.autresdoms.d90.dom.comportement.ComportementBatchReconductionRejet;
import fr.unedic.cali.autresdoms.d90.dom.comportement.ComportementRepriseStockAsp2015;
import fr.unedic.cali.autresdoms.d90.dom.comportement.ComportementVnrBatch;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationAbstraite;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationBatchCinqCles;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationGenerique;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationICCPConservatoireSurLiquidationSimplifieeNPDE;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationMigrationPans;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationNettoyageOrphelinsTableP1200V;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStock1006275;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStock1031693;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockAREM2012;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockAREM2016;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockASP;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockAntecedentMayotte;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockArretATA;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockContribOuvertureCSP;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockContribsNovation;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockDemandeExpresseSpectaclePNDS;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockGusoAvecAbattement;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockIIN0995664;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockIN0466592;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockIN0813441;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockIN0825668;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockIN0825815;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockIN0827770;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockIN0857223;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockIN0867627;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockIN0890524;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockIN0901531;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockIN0902175;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockIN0907961DelaiAttente;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockIN0912736;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockIN0922314;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockIN093454TypeClassMay;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockIN0962660;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockIN0963499;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockIN0988013;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockIN0993069;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockIN1000355;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockIN1007781;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockIN1020177;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockIN1022129;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockIN1024630;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockIN1024918;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockIN1033563;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockIN1033959;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockIN1035173;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockIN835924;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockIN913138;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockIN937823;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockIN946916;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockINC0034234;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockINC0036443;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockINC0060717PlafondSecu2015et2016;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockINC0067118;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockINC0067879;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockINC0097085;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockINC0111547;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockINC0406843;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockINC0431017;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockInteressementASS;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockJurisprudenceDv;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockNCACLot2;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockPANS2018;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockParametreSmic;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockParametresAvrilA2b;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockParametresAvrilPrr;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockParametresCgfCadt;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockParametresJanvierAsu;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockParametresJanvierForfaitPANS;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockParametresJanvierPrr;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockParametresJanvierSol;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockParametresJuillet;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockParametresJuilletSolMayotte;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockParametresRsaAta;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockPndsRechargementDmdExpress;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockPrimeASPFinancement;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockRejetFaitGenerateurSpectacleIDE;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockRepriseASPPrime;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockRffArem;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockSM9IN1001500;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationRepriseStockUrgentDrv;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationSimulationChangementARZ;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationSimulationChangementDeterminationStatutUTRg;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationVnr;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationVnrReconductionAuto;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationVnrReconductionSystematique;
import fr.unedic.cali.autresdoms.d90.dom.spec.ComportementSpec;
import fr.unedic.cali.autresdoms.d90.dom.spec.PopulationSimulationChangementSpec;
import fr.unedic.cali.autresdoms.d90.dom.spec.PopulationSpec;
import fr.unedic.cali.outilsfonctionnels.GestionnaireErreur;
import fr.unedic.cali.outilsfonctionnels.OutilTrace;
import fr.unedic.cali.parcours.ContexteParcoursSimulationChangementAbstrait;
import fr.unedic.cali.parcours.ContexteParcoursSimulationChangementSpec;
import fr.unedic.util.services.CoucheLogiqueException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class OutilPopulation
{
  private static Map<String, List<PopulationSpec>> mapListePopulation = new HashMap();
  private static Map<String, PopulationSpec> mapPopulation = new HashMap();
  private static boolean estInitialise = false;
  
  private static synchronized void inscrireElements()
    throws CoucheLogiqueException
  {
    mapListePopulation = new HashMap();
    mapPopulation = new HashMap();
    
    inscrirePopulation90AS1();
    inscrirePopulation90AS2();
    inscrirePopulation90AS3();
    
    inscrirePopulation90AS4();
    inscrirePopulation90AS5();
    inscrirePopulation90AS6();
    
    inscrirePopulation90AS7();
    inscrirePopulation90AS8();
    inscrirePopulation90AS9();
    inscrirePopulationClesRestantesATraiter();
    inscrirePopulation90AC1();
    inscrirePopulation90AC2();
    
    inscrirePopulation90ASC();
    inscrirePopulation90ARZ();
    inscrirePopulation90ASD();
    
    inscrirePopulationGaec();
    inscrirePopulationMigrationPans();
    
    inscrirePopulations90AR1();
    inscrirePopulations90AR2();
    inscrirePopulations90AR3();
    inscrirePopulations90AR4();
    
    inscrirePopulationRevalorisationForfaitPANS();
    
    inscrirePopulation90AP1();
    
    inscrirePopulationRevalorisationCotisationGlobaleForfaitaire();
    
    inscrirePopulationVnrBatch();
    
    inscrirePopulationSigma();
    
    inscrirePopulationPaiementAB();
    
    inscrirePopulationsSigmaParametresJuillet2011();
    
    inscrirePopulationsSigmaNcAre14();
    
    inscrirePopulationIN0828742();
    
    inscrirePopulationAct();
    
    inscrirePopulationIN0858532();
    
    inscrirePopulationIthPayeeModuleNon();
    
    inscrirePopulationRevalorisationSurCAE();
    
    inscrirePopulationsSigmaAfdef2009();
    
    inscrirePopulation90AK1();
    
    inscrireAnciennesPopulations();
    
    inscrirePopulationRecyclageRejetBatch();
  }
  
  private static void inscrireListePopulation(String listePopulationId, List<PopulationSpec> listePopulation)
    throws CoucheLogiqueException
  {
    if (listePopulation != null)
    {
      if (mapListePopulation == null) {
        mapListePopulation = new HashMap();
      }
      if (mapPopulation.get(listePopulationId) != null)
      {
        if (Log.isTraceActive(OutilPopulation.class, Niveau.DEBUG)) {
          Log.ecritTrace(Niveau.DEBUG, OutilPopulation.class, "inscrireListePopulation", "HG_PR_CALI_L_ERR_OCCAS_INSCRIPTION_POP la liste population " + listePopulationId + " est déjà inscrite");
        }
        GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_L_ERR_OCCAS_INSCRIPTION_POP");
      }
      else
      {
        if (listePopulationId.equals("SelectionPopC"))
        {
          Iterator<PopulationSpec> iterateur = listePopulation.iterator();
          while (iterateur.hasNext())
          {
            PopulationSpec population = (PopulationSpec)iterateur.next();
            controlerPopulationSimuChangement(population);
          }
        }
        mapListePopulation.put(listePopulationId, listePopulation);
      }
    }
  }
  
  private static void controlerPopulationSimuChangement(PopulationSpec population)
    throws CoucheLogiqueException
  {
    if (!(population instanceof PopulationSimulationChangementSpec)) {
      GestionnaireErreur.getInstance().genererException("HG_PR_L_CALI_POPULATION_SIMULATION_CHANGEMENT", new Object[] { population.getLibelle() }, 1);
    }
  }
  
  private static void inscrirePopulation(PopulationSpec population)
    throws CoucheLogiqueException
  {
    if (population != null)
    {
      if (mapPopulation == null) {
        mapPopulation = new HashMap();
      }
      if (mapPopulation.get(population.getLibelle().toUpperCase()) != null)
      {
        OutilTrace.ecrireTrace(Niveau.DEBUG, new Object[] { "HG_PR_CALI_L_ERR_OCCAS_INSCRIPTION_POP la population " + population.getLibelle() + " est déjà inscrite" });
        
        GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_L_ERR_OCCAS_INSCRIPTION_POP");
      }
      else
      {
        if ((population instanceof PopulationSimulationChangementSpec))
        {
          List<ContexteParcoursSimulationChangementSpec> listeContexte = ((PopulationSimulationChangementSpec)population).getListeContextesSimulation();
          if ((listeContexte == null) || (listeContexte.isEmpty())) {
            GestionnaireErreur.getInstance().genererException("HG_PR_L_CALI_CONTEXTE_SIMULATION_CHANGEMENT", new Object[] { population.getLibelle() }, 1);
          }
          Iterator<ContexteParcoursSimulationChangementSpec> iterateur = listeContexte.iterator();
          while (iterateur.hasNext()) {
            try
            {
              ContexteParcoursSimulationChangementAbstrait contexte = (ContexteParcoursSimulationChangementAbstrait)iterateur.next();
              contexte.setActif(true);
            }
            catch (ClassCastException cCE)
            {
              GestionnaireErreur.getInstance().genererException("HG_PR_L_CALI_CONTEXTE_SIMULATION_CHANGEMENT", new Object[] { population.getLibelle() }, 1);
            }
          }
        }
        mapPopulation.put(population.getLibelle().toUpperCase(), population);
      }
    }
  }
  
  public static synchronized PopulationSpec getPopulation(String idPopulation)
    throws CoucheLogiqueException
  {
    PopulationSpec population = null;
    if (idPopulation != null)
    {
      if (!estInitialise)
      {
        inscrireElements();
        estInitialise = true;
      }
      population = (PopulationSpec)mapPopulation.get(idPopulation.toUpperCase());
    }
    return population;
  }
  
  public static List<PopulationSpec> getListePopulation(String idListePopulation)
    throws CoucheLogiqueException
  {
    List<PopulationSpec> liste = null;
    if (idListePopulation != null)
    {
      if (!estInitialise)
      {
        inscrireElements();
        estInitialise = true;
      }
      liste = (List)mapListePopulation.get(idListePopulation);
    }
    return liste;
  }
  
  public static synchronized PopulationSpec getPopulationParHashCode(int idPopulation)
    throws CoucheLogiqueException
  {
    PopulationSpec pop = null;
    boolean estTrouve = false;
    if (!estInitialise)
    {
      inscrireElements();
      estInitialise = true;
    }
    Iterator<String> iterateur = mapPopulation.keySet().iterator();
    while ((iterateur.hasNext()) && (!estTrouve))
    {
      String key = (String)iterateur.next();
      if (((PopulationSpec)mapPopulation.get(key)).getId() == idPopulation)
      {
        pop = (PopulationSpec)mapPopulation.get(key);
        estTrouve = true;
      }
    }
    return pop;
  }
  
  public static List<PopulationSpec> getListePopulationParDefaut()
    throws CoucheLogiqueException
  {
    return getListePopulation("TraitementSansObjet");
  }
  
  public static PopulationSpec definirPopulationPrioritaire(Collection<PopulationAbstraite> listePopulation)
  {
    PopulationAbstraite population = null;
    if (listePopulation != null)
    {
      Iterator<PopulationAbstraite> iterator = listePopulation.iterator();
      while (iterator.hasNext())
      {
        PopulationAbstraite popCourante = (PopulationAbstraite)iterator.next();
        if ((population == null) || (population.getPriorite() < popCourante.getPriorite())) {
          population = popCourante;
        }
      }
    }
    return population;
  }
  
  private static void inscrirePopulation90ASx(String traitement, PopulationSpec population)
    throws CoucheLogiqueException
  {
    inscrirePopulation(population);
    List<PopulationSpec> lPopulation = new ArrayList();
    lPopulation.add(population);
    inscrireListePopulation(traitement, lPopulation);
  }
  
  private static void inscrirePopulation90AS1()
    throws CoucheLogiqueException
  {
    PopulationSpec population90AS1 = new PopulationVnr();
    inscrirePopulation90ASx("SelectionPop01", population90AS1);
  }
  
  private static void inscrirePopulation90AS2()
    throws CoucheLogiqueException
  {
    PopulationSpec population90AS2 = new PopulationRepriseStockAREM2016();
    inscrirePopulation90ASx("SelectionPop02", population90AS2);
  }
  
  private static void inscrirePopulation90AS3()
    throws CoucheLogiqueException
  {
    PopulationSpec population90AS3 = new PopulationRepriseStockINC0431017();
    inscrirePopulation90ASx("SelectionPop03", population90AS3);
  }
  
  private static void inscrirePopulation90AS4()
    throws CoucheLogiqueException
  {
    PopulationSpec population90AS4 = new PopulationRepriseStockParametresJanvierAsu();
    inscrirePopulation90ASx("SelectionPop04", population90AS4);
  }
  
  private static void inscrirePopulation90AS5()
    throws CoucheLogiqueException
  {
    PopulationSpec population90AS5 = new PopulationRepriseStockParametresAvrilA2b();
    inscrirePopulation90ASx("SelectionPop05", population90AS5);
  }
  
  private static void inscrirePopulation90AS6()
    throws CoucheLogiqueException
  {
    inscrirePopulation90ASx("SelectionPop06", new PopulationRepriseStockParametresJanvierForfaitPANS());
  }
  
  private static void inscrirePopulation90AS7()
    throws CoucheLogiqueException
  {
    PopulationSpec population90AS7 = new PopulationRepriseStockParametreSmic();
    inscrirePopulation90ASx("SelectionPop07", population90AS7);
  }
  
  private static void inscrirePopulation90AS8()
    throws CoucheLogiqueException
  {
    PopulationSpec population90AS8 = new PopulationRepriseStockGusoAvecAbattement();
    inscrirePopulation90ASx("SelectionPop08", population90AS8);
  }
  
  private static void inscrirePopulation90AS9()
    throws CoucheLogiqueException
  {
    PopulationSpec population90AS9 = new PopulationRepriseStockParametresJanvierPrr();
    inscrirePopulation90ASx("SelectionPop09", population90AS9);
  }
  
  private static void inscrirePopulation90AC1()
    throws CoucheLogiqueException
  {
    PopulationSpec population90AC1 = new PopulationBatchCinqCles();
    inscrirePopulation90ASx("SelectionPopCali01", population90AC1);
  }
  
  private static void inscrirePopulation90AC2()
    throws CoucheLogiqueException
  {
    PopulationSpec population90AC2 = new PopulationRepriseStockIN0466592();
    inscrirePopulation90ASx("SelectionPopCali02", population90AC2);
  }
  
  private static void inscrirePopulation90ASC()
    throws CoucheLogiqueException
  {
    PopulationSpec population90ASC = new PopulationSimulationChangementDeterminationStatutUTRg();
    inscrirePopulation90ASx("SelectionPopC", population90ASC);
  }
  
  private static void inscrirePopulation90ARZ()
    throws CoucheLogiqueException
  {
    PopulationSpec population90ARZ = new PopulationSimulationChangementARZ();
    inscrirePopulation(population90ARZ);
  }
  
  private static void inscrirePopulation90ASD() {}
  
  private static void inscrirePopulationGaec()
    throws CoucheLogiqueException
  {
    ComportementSpec comportement = new ComportementBatchGaec();
    
    PopulationSpec populationReanalyseConflit = PopulationGenerique.creerPopulationGenerique("08SI1GAEC_1_ReanalyseConflit", 0, comportement, true);
    
    PopulationSpec populationMesureActiviteDouble = PopulationGenerique.creerPopulationGenerique("08SI1GAEC_2_MesureActiviteDouble", 0, comportement, true);
    
    PopulationSpec populationRepriseStockDSMS42866 = PopulationGenerique.creerPopulationGenerique("09SI2GAEC_1_RepriseDeStock_DSMS_IN_36895", 0, comportement, true);
    
    PopulationSpec populationRepriseStockDSMS44001 = PopulationGenerique.creerPopulationGenerique("09SI2GAEC_2_RepriseDeStock_DSMS_IN_36895", 0, comportement, true);
    
    PopulationSpec populationRepriseStockDSMS46118 = PopulationGenerique.creerPopulationGenerique("10SI1CALI_RepriseDeStock_DSMS_IN_46118", 0, comportement, true);
    
    PopulationSpec populationRepriseStockSM9809507 = PopulationGenerique.creerPopulationGenerique("IN0802356_AED_SANS_INDEMNITE_LEGALE", 0, comportement, true);
    
    PopulationSpec populationVnrBatchGaec = PopulationGenerique.creerPopulationGenerique("POP_Vnr_Batch_Gaec", 0, new ComportementVnrBatch(), true);
    
    PopulationSpec populationRecyclageAED = PopulationGenerique.creerPopulationGenerique("POP_Recyclage_AED", 0, comportement, true);
    
    PopulationSpec populationAGS = PopulationGenerique.creerPopulationGenerique("POP_GAEC_REPRISE_AGS", 0, comportement, true);
    
    PopulationSpec populationIndemnisationLicenciement = PopulationGenerique.creerPopulationGenerique("POP_INC0376568_REPRISE_INDEMNTIE_LEGALE", 0, comportement, true);
    
    PopulationSpec populationIndemniteLicenciementBis = PopulationGenerique.creerPopulationGenerique("POP_INC0404036_REPRISE_INDEMNITE_LEGALE", 0, comportement, true);
    
    inscrirePopulation(populationReanalyseConflit);
    inscrirePopulation(populationMesureActiviteDouble);
    inscrirePopulation(populationRepriseStockDSMS42866);
    inscrirePopulation(populationRepriseStockDSMS44001);
    inscrirePopulation(populationRepriseStockDSMS46118);
    inscrirePopulation(populationRepriseStockSM9809507);
    inscrirePopulation(populationVnrBatchGaec);
    inscrirePopulation(populationRecyclageAED);
    inscrirePopulation(populationAGS);
    inscrirePopulation(populationIndemnisationLicenciement);
    inscrirePopulation(populationIndemniteLicenciementBis);
  }
  
  private static void inscrirePopulationMigrationPans()
    throws CoucheLogiqueException
  {
    ComportementSpec comportementBatchGAEC = new ComportementBatchGaec();
    
    PopulationSpec populationRepriseStockMigrationPANS1 = PopulationGenerique.creerPopulationGenerique("11SI1_GAEC_MIGRATION_PANS_1", 0, comportementBatchGAEC, false);
    
    PopulationSpec populationRepriseStockMigrationPANS2 = new PopulationMigrationPans();
    
    PopulationSpec populationRepriseStockMigrationPANS3 = PopulationGenerique.creerPopulationGenerique("11SI1_GAEC_MIGRATION_PANS_3", 0, comportementBatchGAEC, false);
    
    inscrirePopulation(populationRepriseStockMigrationPANS1);
    inscrirePopulation(populationRepriseStockMigrationPANS2);
    inscrirePopulation(populationRepriseStockMigrationPANS3);
  }
  
  private static void inscrirePopulations90AR1()
    throws CoucheLogiqueException
  {
    PopulationSpec population90AR1MandatementAuto = PopulationGenerique.creerPopulationGenerique("90AR1_Mandatement_Auto", 0, new ComportementBatchDefautMandatementAuto(), true);
    
    PopulationSpec population90AR1MandatementManu = PopulationGenerique.creerPopulationGenerique("90AR1_Mandatement_Manu", 0, new ComportementBatchDefaut(), true);
    
    inscrirePopulation(population90AR1MandatementAuto);
    inscrirePopulation(population90AR1MandatementManu);
  }
  
  private static void inscrirePopulations90AR2()
    throws CoucheLogiqueException
  {
    PopulationSpec population90AR2Manu = PopulationGenerique.creerPopulationGenerique("90AR2_Population_Manu", 0, new ComportementBatchDefaut(), true);
    
    PopulationSpec population90AR2Auto = PopulationGenerique.creerPopulationGenerique("90AR2_Population_Auto", 0, new ComportementBatchDefautMandatementAuto(), true);
    
    inscrirePopulation(population90AR2Manu);
    inscrirePopulation(population90AR2Auto);
  }
  
  private static void inscrirePopulations90AR3()
    throws CoucheLogiqueException
  {
    PopulationSpec population90AR3Manu = PopulationGenerique.creerPopulationGenerique("90AR3_Population_Manu", 0, new ComportementBatchDefaut(), true);
    
    PopulationSpec population90AR3Auto = PopulationGenerique.creerPopulationGenerique("90AR3_Population_Auto", 0, new ComportementBatchDefautMandatementAuto(), true);
    
    inscrirePopulation(population90AR3Manu);
    inscrirePopulation(population90AR3Auto);
  }
  
  private static void inscrirePopulations90AR4()
    throws CoucheLogiqueException
  {
    PopulationSpec population90AR4Manu = PopulationGenerique.creerPopulationGenerique("90AR4_Population_Manu", 0, new ComportementBatchDefaut(), true);
    
    PopulationSpec population90AR4Auto = PopulationGenerique.creerPopulationGenerique("90AR4_Population_Auto", 0, new ComportementBatchDefautMandatementAuto(), true);
    
    inscrirePopulation(population90AR4Manu);
    inscrirePopulation(population90AR4Auto);
  }
  
  private static void inscrirePopulationRevalorisationForfaitPANS()
    throws CoucheLogiqueException
  {
    PopulationSpec population90AR1MandatementAuto = PopulationGenerique.creerPopulationGenerique("08SI4CALI_RepriseDeStockParamsForfaitPANS", 0, new ComportementBatchDefautMandatementAuto(), true);
    
    inscrirePopulation(population90AR1MandatementAuto);
  }
  
  private static void inscrirePopulation90AP1() {}
  
  private static void inscrirePopulationRevalorisationCotisationGlobaleForfaitaire()
    throws CoucheLogiqueException
  {
    PopulationSpec population90SIGMandatementAuto = PopulationGenerique.creerPopulationGenerique("09SI2CALI_RepriseDeStockParamsCgf", 0, new ComportementBatchDefautMandatementAuto(), true);
    
    inscrirePopulation(population90SIGMandatementAuto);
  }
  
  private static void inscrirePopulationRevalorisationSurCAE()
    throws CoucheLogiqueException
  {
    PopulationSpec population90SIGMandatementAuto = PopulationGenerique.creerPopulationGenerique("09SI2CALI_RepriseDeStock_DSMS_IN_41912", 0, new ComportementBatchDefaut(), true);
    
    inscrirePopulation(population90SIGMandatementAuto);
  }
  
  private static void inscrirePopulationsSigmaParametresJuillet2011()
    throws CoucheLogiqueException
  {
    PopulationSpec population90SigmaParametreJuillet2011Dispense = PopulationGenerique.creerPopulationGenerique("POP_PARAMETRES_JUILLET_DE_DISPENSE_15", 0, new ComportementBatchDefautMandatementAuto(), true);
    
    inscrirePopulation(population90SigmaParametreJuillet2011Dispense);
    PopulationSpec population90SigmaParametreJuillet2011Radie = PopulationGenerique.creerPopulationGenerique("POP_PARAMETRES_JUILLET_DE_RADIE_15", 0, new ComportementBatchDefautMandatementAuto(), true);
    
    inscrirePopulation(population90SigmaParametreJuillet2011Radie);
  }
  
  private static void inscrirePopulationsSigmaNcAre14()
    throws CoucheLogiqueException
  {
    PopulationSpec population90SigmaNc14Dispense = PopulationGenerique.creerPopulationGenerique("POP_NC_14_DE_DISPENSE", 0, new ComportementBatchDefautMandatementAuto(), true);
    
    inscrirePopulation(population90SigmaNc14Dispense);
    PopulationSpec population90SigmaNc14Radie = PopulationGenerique.creerPopulationGenerique("POP_NC_14_DE_RADIE", 0, new ComportementBatchDefautMandatementAuto(), true);
    
    inscrirePopulation(population90SigmaNc14Radie);
  }
  
  private static void inscrirePopulationIN0828742()
    throws CoucheLogiqueException
  {
    PopulationSpec pop = PopulationGenerique.creerPopulationGenerique("IN0828742 DA sur AB", 0, new ComportementBatchDefautMandatementAuto(), true);
    
    inscrirePopulation(pop);
  }
  
  private static void inscrirePopulationAct()
    throws CoucheLogiqueException
  {
    PopulationSpec pop = PopulationGenerique.creerPopulationGenerique("14SI4CALI_RS_refacturationDiffereA8A10", 0, new ComportementBatchDefautMandatementAuto(), true);
    
    inscrirePopulation(pop);
  }
  
  private static void inscrirePopulationIN0858532()
    throws CoucheLogiqueException
  {
    PopulationSpec pop = PopulationGenerique.creerPopulationGenerique("IN0858532_RS_PAIEMENT_RFPE", 0, new ComportementBatchDefautMandatementAuto(), true);
    
    inscrirePopulation(pop);
  }
  
  private static void inscrirePopulationVnrBatch()
    throws CoucheLogiqueException
  {
    PopulationSpec populationVNRRecondutionAuto = new PopulationVnrReconductionAuto();
    PopulationSpec populationVNRRecondutionSystematique = new PopulationVnrReconductionSystematique();
    
    inscrirePopulation(populationVNRRecondutionAuto);
    inscrirePopulation(populationVNRRecondutionSystematique);
  }
  
  private static void inscrirePopulationsSigmaAfdef2009()
    throws CoucheLogiqueException
  {
    PopulationSpec population90SigmaAfdef2009 = PopulationGenerique.creerPopulationGenerique("09SI3CALI_RepriseDeStock_DSMS_IN_44332_AFDEF", 0, new ComportementBatchDefaut(), true);
    
    inscrirePopulation(population90SigmaAfdef2009);
  }
  
  private static void inscrirePopulation90AK1()
    throws CoucheLogiqueException
  {
    PopulationSpec population90AK1 = new PopulationNettoyageOrphelinsTableP1200V();
    inscrirePopulation(population90AK1);
  }
  
  private static void inscrirePopulationClesRestantesATraiter()
    throws CoucheLogiqueException
  {
    ComportementSpec comportementOccasionnelRetraite = new ComportementBatchReconductionRejet();
    PopulationSpec populationSigmaDateRetraiteImposee = PopulationGenerique.creerPopulationGenerique("12SI3C_E59211_POP_RP_DATE_RETRAITE_IMPOSEE", 0, comportementOccasionnelRetraite, true);
    
    inscrirePopulation(populationSigmaDateRetraiteImposee);
    
    PopulationSpec populationChangementDeRessources = PopulationGenerique.creerPopulationGenerique("60285 Modification ressources en ASS", 0, new ComportementBatchDefaut(), true);
    
    inscrirePopulation(populationChangementDeRessources);
    
    PopulationSpec populationDsms59426 = PopulationGenerique.creerPopulationGenerique("59636 revision et plafonnement affi.", 0, new ComportementBatchDefaut(), true);
    
    inscrirePopulation(populationDsms59426);
  }
  
  private static void inscrireAnciennesPopulations()
    throws CoucheLogiqueException
  {
    inscrirePopulation(new PopulationRepriseStockIN0825668());
    inscrirePopulation(new PopulationRepriseStockIN0813441());
    inscrirePopulation(new PopulationRepriseStockIN835924());
    inscrirePopulation(new PopulationRepriseStockASP());
    inscrirePopulation(new PopulationRepriseStockParametresJuilletSolMayotte());
    inscrirePopulation(new PopulationRepriseStockIN0827770());
    inscrirePopulation(new PopulationRepriseStockParametresJuillet());
    inscrirePopulation(new PopulationRepriseStockIN0867627());
    inscrirePopulation(new PopulationRepriseStockIN0825815());
    inscrirePopulation(new PopulationRepriseStockArretATA());
    inscrirePopulation(new PopulationRepriseStockParametresRsaAta());
    inscrirePopulation(new PopulationRepriseStockIN0890524());
    inscrirePopulation(new PopulationRepriseStockIN913138());
    inscrirePopulation(new PopulationRepriseStockIN0922314());
    inscrirePopulation(new PopulationRepriseStockIN0902175());
    inscrirePopulation(new PopulationRepriseStockUrgentDrv());
    inscrirePopulation(new PopulationRepriseStockIN0857223());
    inscrirePopulation(new PopulationRepriseStockIN0901531());
    inscrirePopulation(new PopulationRepriseStockIN093454TypeClassMay());
    inscrirePopulation(new PopulationICCPConservatoireSurLiquidationSimplifieeNPDE());
    inscrirePopulation(new PopulationRepriseStockIN937823());
    inscrirePopulation(new PopulationRepriseStockIN946916());
    inscrirePopulation(new PopulationRepriseStockNCACLot2());
    inscrirePopulation(new PopulationRepriseStockIN0963499());
    inscrirePopulation(new PopulationRepriseStockIN0907961DelaiAttente());
    inscrirePopulation(new PopulationRepriseStockIN0962660());
    inscrirePopulation(new PopulationRepriseStockContribsNovation());
    inscrirePopulation(new PopulationRepriseStockIN0988013());
    inscrirePopulation(new PopulationRepriseStockIN0993069());
    inscrirePopulation(new PopulationRepriseStockPrimeASPFinancement());
    inscrirePopulation(new PopulationRepriseStockJurisprudenceDv());
    inscrirePopulation(new PopulationRepriseStockIN1007781());
    inscrirePopulation(new PopulationRepriseStockIN1000355());
    
    inscrirePopulation(new PopulationRepriseStockParametresJanvierSol());
    inscrirePopulation(new PopulationRepriseStockSM9IN1001500());
    inscrirePopulation(new PopulationRepriseStockIIN0995664());
    inscrirePopulation(new PopulationRepriseStockIN0912736());
    inscrirePopulation(new PopulationRepriseStockIN1035173());
    inscrirePopulation(new PopulationRepriseStockIN1033959());
    inscrirePopulation(new PopulationRepriseStock1031693());
    inscrirePopulation(new PopulationRepriseStockPndsRechargementDmdExpress());
    inscrirePopulation(new PopulationRepriseStockIN1024630());
    inscrirePopulation(new PopulationRepriseStockAntecedentMayotte());
    inscrirePopulation(new PopulationRepriseStockRffArem());
    inscrirePopulation(new PopulationRepriseStockIN1020177());
    inscrirePopulation(new PopulationRepriseStockIN1022129());
    inscrirePopulation(new PopulationRepriseStockRepriseASPPrime());
    inscrirePopulation(new PopulationRepriseStockINC0034234());
    inscrirePopulation(new PopulationRepriseStockINC0036443());
    inscrirePopulation(new PopulationRepriseStockIN1033563());
    inscrirePopulation(new PopulationRepriseStockINC0097085());
    inscrirePopulation(new PopulationRepriseStockINC0067118());
    
    inscrirePopulation(new PopulationRepriseStockINC0111547());
    inscrirePopulation(new PopulationRepriseStockParametresCgfCadt());
    inscrirePopulation(new PopulationRepriseStockINC0060717PlafondSecu2015et2016());
    inscrirePopulation(new PopulationRepriseStockAREM2012());
    inscrirePopulation(new PopulationRepriseStockINC0067879());
    inscrirePopulation(new PopulationRepriseStock1006275());
    inscrirePopulation(new PopulationRepriseStockDemandeExpresseSpectaclePNDS());
    inscrirePopulation(new PopulationRepriseStockParametresAvrilPrr());
    inscrirePopulation(new PopulationRepriseStockContribOuvertureCSP());
    inscrirePopulation(new PopulationRepriseStockIN1024918());
    inscrirePopulation(new PopulationRepriseStockPANS2018());
    inscrirePopulation(new PopulationRepriseStockRejetFaitGenerateurSpectacleIDE());
    inscrirePopulation(new PopulationRepriseStockINC0406843());
    inscrirePopulation(new PopulationRepriseStockInteressementASS());
  }
  
  private static void inscrirePopulationRecyclageRejetBatch()
    throws CoucheLogiqueException
  {
    ComportementSpec comportementBatchDefaut = new ComportementBatchDefaut();
    
    PopulationSpec populationRecyclageCAF = PopulationGenerique.creerPopulationGenerique("POP_Recyclage_CAF", 0, comportementBatchDefaut, true);
    
    PopulationSpec populationRecyclageAEM = PopulationGenerique.creerPopulationGenerique("POP_Recyclage_AEM", 0, comportementBatchDefaut, true);
    
    PopulationSpec populationRecyclageETT = PopulationGenerique.creerPopulationGenerique("POP_Recyclage_ETT", 0, comportementBatchDefaut, true);
    
    PopulationSpec populationRecyclageDMM = PopulationGenerique.creerPopulationGenerique("POP_Recyclage_DMM", 0, comportementBatchDefaut, true);
    
    PopulationSpec populationRecyclageBS = PopulationGenerique.creerPopulationGenerique("POP_Recyclage_BS", 0, comportementBatchDefaut, true);
    
    PopulationSpec populationRecyclageGUSO = PopulationGenerique.creerPopulationGenerique("POP_Recyclage_GUSO", 0, comportementBatchDefaut, true);
    
    PopulationSpec populationRecyclageMSA = PopulationGenerique.creerPopulationGenerique("POP_Recyclage_MSA", 0, comportementBatchDefaut, true);
    
    inscrirePopulation(populationRecyclageCAF);
    inscrirePopulation(populationRecyclageAEM);
    inscrirePopulation(populationRecyclageETT);
    inscrirePopulation(populationRecyclageDMM);
    inscrirePopulation(populationRecyclageBS);
    inscrirePopulation(populationRecyclageGUSO);
    inscrirePopulation(populationRecyclageMSA);
  }
  
  private static void inscrirePopulationSigma()
    throws CoucheLogiqueException
  {
    PopulationSpec populationPensionInvalidite = PopulationGenerique.creerPopulationGenerique("12SI1CALI_2011D014DD06_PensionInvalidite", 0, new ComportementBatchDefaut(), true);
    
    inscrirePopulation(populationPensionInvalidite);
    
    PopulationSpec populationTrouPbjcDecEnDouble = PopulationGenerique.creerPopulationGenerique("SM9 - IN0762753 Dec double - Trou PBJC", 0, new ComportementBatchDefaut(), true);
    
    inscrirePopulation(populationTrouPbjcDecEnDouble);
    
    PopulationSpec populationNC14 = PopulationGenerique.creerPopulationGenerique("SM9 - IN0791421 Pop nouvelle convention 14", 0, new ComportementBatchDefaut(), true);
    
    inscrirePopulation(populationNC14);
    
    PopulationSpec populationASP2015 = PopulationGenerique.creerPopulationGenerique("REPRISE_STOCK_ASP_2015", 0, new ComportementRepriseStockAsp2015(), true);
    
    inscrirePopulation(populationASP2015);
    
    PopulationSpec populationASP = PopulationGenerique.creerPopulationGenerique("REPRISE_STOCK_ASP_2015SI3", 0, new ComportementBatchDefaut(), true);
    
    inscrirePopulation(populationASP);
  }
  
  private static void inscrirePopulationPaiementAB()
    throws CoucheLogiqueException
  {
    PopulationSpec populationPensionPaiementAB = PopulationGenerique.creerPopulationGenerique("12SI1CALI_RS_DSMS_56384_PAIEMENT_AB", 0, new ComportementBatchDefaut(), true);
    
    inscrirePopulation(populationPensionPaiementAB);
  }
  
  private static void inscrirePopulationIthPayeeModuleNon()
    throws CoucheLogiqueException
  {
    PopulationSpec population90SIGMandatementAuto = PopulationGenerique.creerPopulationGenerique("IN0541274 AFAF sur plusieurs modules formation", 0, new ComportementBatchDefaut(), true);
    
    inscrirePopulation(population90SIGMandatementAuto);
  }
}

/* Location:
 * Qualified Name:     OutilPopulation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */