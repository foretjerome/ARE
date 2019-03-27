package fr.unedic.cali.parcours;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.autresdoms.d90.dom.spec.ComportementSpec;
import fr.unedic.cali.autresdoms.ga.services.LA2K;
import fr.unedic.cali.avant.FacadeAvantProduitFactory;
import fr.unedic.cali.avant.FacadeAvantProduitSpec;
import fr.unedic.cali.calcul.FacadeCalculProduitFactory;
import fr.unedic.cali.calcul.FacadeCalculProduitSpec;
import fr.unedic.cali.calcul.MoteurCalcul;
import fr.unedic.cali.calcul.OutillagePeriodes;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculPeriodique;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculSpec;
import fr.unedic.cali.calcul.dom.EtatAuDji;
import fr.unedic.cali.calcul.dom.UniteTraitement;
import fr.unedic.cali.calcul.dom.periode.PeriodeEvenementActualisation;
import fr.unedic.cali.calcul.dom.periode.PeriodeEvenementBloquant;
import fr.unedic.cali.calcul.dom.periode.PeriodeNonDeclareeSanction;
import fr.unedic.cali.calcul.outilsfonctionnels.GestionLA2K;
import fr.unedic.cali.calcul.outilsfonctionnels.GestionPersistance;
import fr.unedic.cali.calcul.outilsfonctionnels.GestionSuivi;
import fr.unedic.cali.calcul.pbjc.outilsfonctionnels.GenerateurTablesEchangesCalcul;
import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.AppelGaecReduit;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.MontantBaseAbstrait;
import fr.unedic.cali.dom.Retraite;
import fr.unedic.cali.dom.affectation.GammeAsu;
import fr.unedic.cali.dom.affectation.GammeSpec;
import fr.unedic.cali.dom.affectation.ProduitRbfMob07P01;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.cali.dom.persistance.util.ContextePersistance;
import fr.unedic.cali.migration.outilsfonctionnels.OutilsMigration;
import fr.unedic.cali.migration.outilsfonctionnels.OutilsMigrationCalcul;
import fr.unedic.cali.outilsfonctionnels.Anomalie;
import fr.unedic.cali.outilsfonctionnels.ComparateurSurDateAttribution;
import fr.unedic.cali.outilsfonctionnels.GestionAnomalies;
import fr.unedic.cali.outilsfonctionnels.GestionnaireErreur;
import fr.unedic.cali.outilsfonctionnels.OutilRetraite;
import fr.unedic.cali.outilsfonctionnels.reexecution.OutilDeterminationDateDebutExecution;
import fr.unedic.util.Quantite;
import fr.unedic.util.QuantiteEuro;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteException;
import fr.unedic.util.services.ContexteLocal;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.Dom;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.DureeCalendaire;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class ParcoursCalculPilotage
  extends ParcoursServiceAbstrait
  implements ParcoursCalculPilotageSpec
{
  private int typeDePostTraitement = 0;
  private static final DureeCalendaire CENT_ANS = new DureeCalendaire(100);
  private static List<String> produitsAideMobilite = new ArrayList();
  
  static
  {
    produitsAideMobilite.add("RBF_MOB07_01_DE");
    produitsAideMobilite.add("RBF_MOB07_01_HE");
    produitsAideMobilite.add("RBF_MOB07_01_RE");
    produitsAideMobilite.add("RBF_MOB07_01_TR");
    produitsAideMobilite.add("RBF_MOB07_01");
  }
  
  public void controlerContexte(Contexte contexte)
    throws ContexteException
  {
    Dom dom = null;
    DomCalculPilotage domCalculPilotage = null;
    if (contexte == null) {
      throw new ContexteException("HG_PR_CALI_L_ERR_CONTEXTE_ABSENT", "Le contexte ne doit pas être null", null);
    }
    dom = contexte.getDonnees();
    if (dom == null) {
      throw new ContexteException("HG_PR_CALI_L_CONTEXTE_ABSENCE_DOM", "Le Dom ne doit pas être null.", null);
    }
    if (!(dom instanceof DomCalculPilotage)) {
      throw new ContexteException("HG_PR_CALI_L_ERR_CONTEXTE", "Le type de Dom attendu est: DomCalculPilotage", null);
    }
    domCalculPilotage = (DomCalculPilotage)dom;
    if ((domCalculPilotage.getListeAttributions() == null) || (domCalculPilotage.getListeAttributions().isEmpty())) {
      throw new ContexteException("HG_PR_CALI_L_ERR_CONTEXTE", "Le DomCalculPilotage doit contenir au moins une décision à traiter", null);
    }
    if ((domCalculPilotage.getAttributionAEtudier() != null) && (!domCalculPilotage.getListeAttributions().contains(domCalculPilotage.getAttributionAEtudier()))) {
      throw new ContexteException("HG_PR_CALI_L_ERR_CONTEXTE", "Décision à etudier non présente dans la liste des décision", null);
    }
  }
  
  public Resultat effectuerParcours(Contexte contexte)
    throws ApplicativeException
  {
    Resultat resultatRetourne = null;
    ContexteLocal contexteLocal = new ContexteLocal();
    try
    {
      ContexteParcoursCalcul contexteParcours = new ContexteParcoursCalcul();
      ContexteLocal.setContexte(contexteParcours, ContexteParcoursCalcul.class);
      contexteParcours.setModeTrace(contexte.isModeTrace());
      contexteParcours.setPersistant(((DomCalculPilotage)contexte.getDonnees()).isExecutionPersistante());
      resultatRetourne = super.effectuerParcours(contexte);
    }
    finally
    {
      contexteLocal.close();
      initialiserContexteParcour(contexte);
    }
    return resultatRetourne;
  }
  
  public Resultat demarrerParcours(Contexte contexte)
    throws ApplicativeException
  {
    ResultatPilotage retour = null;
    ResultatVisualisationCalcul resultatVisualisationCalcul = null;
    DomCalculPilotage domCalculPilotage = null;
    Map mapCalendrier = null;
    AttributionSpec attribution = null;
    Damj dateDebutExecution = null;
    Damj dateArretExecution = null;
    
    retour = new ResultatPilotage();
    
    retour.setEtat(0);
    
    domCalculPilotage = (DomCalculPilotage)contexte.getDonnees();
    
    OutilsMigrationCalcul.verificationEtCorrectionCalendrierAss(domCalculPilotage.getIndividu());
    
    dateDebutExecution = OutilDeterminationDateDebutExecution.getInstance().rechercherDateDebutExecution(domCalculPilotage.getListeAttributions(), domCalculPilotage.getDateDebutExecution(), domCalculPilotage.isExecutionDepuisPersistance(), domCalculPilotage.getIndividu());
    
    AppelGaecReduit appelGaecRed = domCalculPilotage.getIndividu().getDonneesChargementGaec().getAppelGaecReduit();
    appelGaecRed.setDateExecutionCalcul(dateDebutExecution);
    if (domCalculPilotage.getDateArretExecution() != null) {
      dateArretExecution = domCalculPilotage.getDateArretExecution().lendemain();
    }
    if (domCalculPilotage.getAttributionAEtudier() != null)
    {
      attribution = domCalculPilotage.getAttributionAEtudier();
      if ((attribution.getCalendrierExecutionCalcul() != null) && (attribution.getCalendrierExecutionCalcul().getDernierJourIndemnisable() != null))
      {
        if (attribution.getCalendrierExecutionCalcul().getDernierJourIndemnisable().estAvant(dateDebutExecution)) {
          dateDebutExecution = attribution.getCalendrierExecutionCalcul().getDernierJourIndemnisable();
        }
        if ((attribution.getCalendrierExecutionCalcul().getEtatAttribution() == 3) && (attribution.getCalendrierExecutionCalcul().getDernierJourIndemnisable().estAvant(dateArretExecution))) {
          dateArretExecution = attribution.getCalendrierExecutionCalcul().getDernierJourIndemnisable().lendemain();
        }
      }
    }
    preTraitement(domCalculPilotage, dateDebutExecution, dateArretExecution);
    
    resultatVisualisationCalcul = initialiserResultatVisualisationCalculAvant(domCalculPilotage);
    if ((domCalculPilotage.isExecutionPersistante()) || ((domCalculPilotage != null) && (domCalculPilotage.getComportement() != null) && (domCalculPilotage.getComportement().isEcrireEnBaseVisu()))) {
      mapCalendrier = MoteurCalcul.executerCalcul(dateDebutExecution, dateArretExecution, domCalculPilotage.getListeAttributions(), true, true);
    } else {
      mapCalendrier = MoteurCalcul.executerCalcul(dateDebutExecution, dateArretExecution, domCalculPilotage.getListeAttributions(), domCalculPilotage.isExecutionDepuisPersistance(), false);
    }
    majResultatVisualisationCalculApres(resultatVisualisationCalcul, domCalculPilotage, mapCalendrier);
    
    retour = postTraitement(domCalculPilotage.getListeAttributions(), mapCalendrier, domCalculPilotage, dateDebutExecution, dateArretExecution);
    
    retour.setResultatVisualisationCalcul(resultatVisualisationCalcul);
    return retour;
  }
  
  public int getTypeDePostTraitement()
  {
    return typeDePostTraitement;
  }
  
  public void setTypeDePostTraitement(int type)
  {
    typeDePostTraitement = type;
  }
  
  public void preTraitement(DomCalculPilotage domCalculPilotage, Damj dateDebutExecution, Damj dateArretExecution)
    throws CoucheLogiqueException
  {
    if ((ContexteParcoursCalcul.estPersistant()) && (domCalculPilotage.isExecutionPersistante()))
    {
      if ((domCalculPilotage.getListeAttributions() != null) && (!domCalculPilotage.getListeAttributions().isEmpty())) {
        GestionSuivi.nettoyerEnquetePbjcNcp(dateDebutExecution, domCalculPilotage.getIndividu());
      }
      GestionAnomalies.supprimeAnomalie(dateDebutExecution, domCalculPilotage.getIndividu());
    }
  }
  
  public ResultatPilotage postTraitement(List listeAttributions, Map mapCalendriers, DomCalculPilotage domCalculPilotage, Damj dateDebutExecution, Damj dateArretExecution)
    throws ApplicativeException
  {
    List<AttributionSpec> listeAttribution = new ArrayList();
    Map<Damj, AttributionSpec> listeNotificationAllongement = new HashMap();
    if ((ContexteParcoursCalcul.estPersistant()) || ((domCalculPilotage != null) && (domCalculPilotage.getComportement() != null) && (domCalculPilotage.getComportement().isEcrireEnBaseVisu())))
    {
      Damj dernierJourIndemnisablePourSuivi = null;
      Damj dateEvtActualisationBloquant = Damj.FIN_DES_TEMPS;
      Periode periodeIneligibilite = null;
      if (domCalculPilotage.getIndividu().getDateBlocageActualisation() != null) {
        dateEvtActualisationBloquant = domCalculPilotage.getIndividu().getDateBlocageActualisation();
      }
      String libelleEvtActualisationBloquant = null;
      ChronologiePeriodes chronoPeriodeEvtActu = domCalculPilotage.getIndividu().getChronoPeriodeEvtActualisation();
      if ((chronoPeriodeEvtActu != null) && (!chronoPeriodeEvtActu.estVide()))
      {
        Iterator ite = chronoPeriodeEvtActu.iterer();
        while (ite.hasNext())
        {
          PeriodeEvenementActualisation periodeEvtActu = (PeriodeEvenementActualisation)ite.next();
          if (((periodeEvtActu instanceof PeriodeEvenementBloquant)) && (((PeriodeEvenementBloquant)periodeEvtActu).getDateEffet().coincideAvec(dateEvtActualisationBloquant))) {
            libelleEvtActualisationBloquant = ((PeriodeEvenementBloquant)periodeEvtActu).getLibelleEvtBloquant();
          }
        }
      }
      Damj dateRetraite = OutilRetraite.getInstance().determinerRetraite(domCalculPilotage.getIndividu()).getDate();
      ChronologiePeriodes chronologiePeriodesEvtActualisation = OutillagePeriodes.recupererPeriodesEvtActualisation(domCalculPilotage.getIndividu());
      
      Damj minDDJINProduit = Damj.FIN_DES_TEMPS;
      Damj maxDJIProduit = Damj.NUIT_DES_TEMPS;
      if (!domCalculPilotage.getIndividu().getListeLA2K().isEmpty())
      {
        Iterator iterateur = domCalculPilotage.getIndividu().getListeLA2K().iterator();
        while (iterateur.hasNext())
        {
          LA2K la2k = (LA2K)iterateur.next();
          Damj dateFinLA2k = new Damj(la2k.getAnnee(), la2k.getMois(), 1).getFinMois();
          if (dateFinLA2k.estApresOuCoincideAvec(dateDebutExecution)) {
            iterateur.remove();
          }
        }
      }
      Iterator it = mapCalendriers.keySet().iterator();
      while (it.hasNext())
      {
        AttributionSpec attribution = (AttributionSpec)it.next();
        listeAttribution.add(attribution);
      }
      Collections.sort(listeAttribution, new ComparateurSurDateAttribution());
      Iterator iter = listeAttribution.iterator();
      Periode dernierePeriodeIneligibilite = null;
      while (iter.hasNext())
      {
        AttributionSpec attribution = (AttributionSpec)iter.next();
        CalendrierExecutionCalculSpec calendrierExecutionCalcul = (CalendrierExecutionCalculSpec)mapCalendriers.get(attribution);
        if ((calendrierExecutionCalcul instanceof CalendrierExecutionCalculPeriodique))
        {
          Chronologie unitesTraitements = ((CalendrierExecutionCalculPeriodique)calendrierExecutionCalcul).getChronologieUnitesTraitements();
          
          unitesTraitements.iterer();
          while (unitesTraitements.encoreSuivant())
          {
            UniteTraitement uniteTraitementCourante = (UniteTraitement)unitesTraitements.elementSuivant();
            if (dateDebutExecution.estAvant(uniteTraitementCourante.getDateFin()))
            {
              Collection collectionPNDS = uniteTraitementCourante.getListePNDs();
              if ((collectionPNDS != null) && (!collectionPNDS.isEmpty()))
              {
                Iterator collectionPNDSIterator = collectionPNDS.iterator();
                while (collectionPNDSIterator.hasNext())
                {
                  ChronologiePeriodes periodesNonDeclareesSanction = (ChronologiePeriodes)collectionPNDSIterator.next();
                  if ((periodesNonDeclareesSanction != null) && (!periodesNonDeclareesSanction.estVide()))
                  {
                    periodesNonDeclareesSanction.iterer();
                    while (periodesNonDeclareesSanction.encoreSuivant())
                    {
                      PeriodeNonDeclareeSanction pnds = (PeriodeNonDeclareeSanction)periodesNonDeclareesSanction.elementSuivant();
                      
                      calendrierExecutionCalcul.ajouterListePNDS(pnds);
                    }
                  }
                }
              }
            }
          }
          dernierePeriodeIneligibilite = recupererPeriodeInegibilite(attribution, calendrierExecutionCalcul);
          if ((dernierePeriodeIneligibilite != null) && ((periodeIneligibilite == null) || (dernierePeriodeIneligibilite.getFin().estApres(periodeIneligibilite.getFin())))) {
            periodeIneligibilite = dernierePeriodeIneligibilite;
          }
        }
        FacadeCalculProduitSpec facadeCalculProduit = FacadeCalculProduitFactory.getInstance().getInstanceGestionnaireCalculProduit(attribution.getProduitExecution());
        if (dateDebutExecution.estAvantOuCoincideAvec(calendrierExecutionCalcul.getDernierJourIndemnisable()))
        {
          Damj dateFinDroitTheorique = GestionSuivi.recupererDateFinDroitTheorique(attribution, calendrierExecutionCalcul, facadeCalculProduit);
          
          GestionSuivi.enregistrerDroitPbjcNcp(attribution, dateFinDroitTheorique, facadeCalculProduit, calendrierExecutionCalcul);
        }
        facadeCalculProduit.annulerReliquatPlafoneeSpecSuiteARCE(attribution);
        
        Damj dateDebutDispositif = GestionSuivi.recupererDateDebutDispositif(attribution, facadeCalculProduit);
        if (dateDebutDispositif != null) {
          listeNotificationAllongement.put(dateDebutDispositif, attribution);
        }
        GestionLA2K.enrichirCollectionPeriodesActiviteReduite(attribution, calendrierExecutionCalcul, facadeCalculProduit, domCalculPilotage.getIndividu().getListeLA2K(), dateDebutExecution);
        if (calendrierExecutionCalcul.getDernierJourIndemnisablePourSuivi() != null) {
          minDDJINProduit = Damj.min(calendrierExecutionCalcul.getDernierJourIndemnisablePourSuivi(), minDDJINProduit);
        }
        if (calendrierExecutionCalcul.getDernierJourIndemnisable() != null) {
          maxDJIProduit = Damj.max(calendrierExecutionCalcul.getDernierJourIndemnisable(), maxDJIProduit);
        }
      }
      dernierJourIndemnisablePourSuivi = GestionSuivi.determinerDDJIQ(dateRetraite, minDDJINProduit, maxDJIProduit, chronologiePeriodesEvtActualisation);
      
      GestionSuivi.enregistrerIndividuPbjcNcp(domCalculPilotage.getIndividu(), dernierJourIndemnisablePourSuivi, domCalculPilotage.getComportement(), periodeIneligibilite);
      
      Damj dateDebutGeneration = dateDebutExecution;
      GenerateurTablesEchangesCalcul.alimenterTableEchangesCalcul(domCalculPilotage.getListeAttributions(), mapCalendriers, dateDebutGeneration, dateEvtActualisationBloquant, libelleEvtActualisationBloquant, domCalculPilotage.getIndividu());
    }
    GestionSuivi.enregistrerDispositifNcp(listeNotificationAllongement);
    
    Collection<AttributionSpec> attibutionsAbandonnees = new ArrayList();
    Iterator it = mapCalendriers.keySet().iterator();
    while (it.hasNext())
    {
      AttributionSpec attribution = (AttributionSpec)it.next();
      CalendrierExecutionCalculSpec calendrierExecutionCalcul = (CalendrierExecutionCalculSpec)mapCalendriers.get(attribution);
      if (calendrierExecutionCalcul.getEtatAttribution() == 4)
      {
        if (ContexteParcoursCalcul.estPersistant())
        {
          attibutionsAbandonnees.add(attribution);
          attribution.setCalendrierExecutionCalcul(null);
        }
        it.remove();
      }
    }
    if (contientDemandeTransferee(domCalculPilotage.getIndividu())) {
      GestionAnomalies.ajouteAnomalie(new Anomalie("M01", domCalculPilotage.getIndividu().getDateNaissance().deplacerVersAvant(CENT_ANS), ""), domCalculPilotage.getIndividu());
    }
    ResultatPilotage resultat = genererResultat(mapCalendriers, domCalculPilotage, getTypeDePostTraitement());
    if (ContexteParcoursCalcul.estPersistant()) {
      if (domCalculPilotage.getIndividu().getDernierJourAtteste() != null) {
        GestionPersistance.purgerCalendriers(mapCalendriers, domCalculPilotage.getIndividu().getDernierJourAtteste(), attibutionsAbandonnees);
      } else {
        GestionPersistance.purgerCalendriers(mapCalendriers, Damj.NUIT_DES_TEMPS, attibutionsAbandonnees);
      }
    }
    return resultat;
  }
  
  public static Damj determinerLendemainDjiMaxDroitNeutralise(IndividuSpec individu, Damj dateDebutExecution)
    throws CoucheLogiqueException
  {
    Damj lendemainDjiMaxDroitNeutralise = null;
    FacadeAvantProduitSpec facadeAvantProduitSpec = null;
    ResultatAvant retour = null;
    
    List listeAttributionsNeutralisees = individu.getListeAttributionsNeutralisees();
    
    Iterator iterator = listeAttributionsNeutralisees.iterator();
    while (iterator.hasNext())
    {
      AttributionSpec attrib = (AttributionSpec)iterator.next();
      if (attrib.getCalendrierExecutionCalcul() != null)
      {
        if (attrib.getCalendrierExecutionCalcul().getDernierJourIndemnisable() != null) {
          lendemainDjiMaxDroitNeutralise = Damj.max(lendemainDjiMaxDroitNeutralise, attrib.getCalendrierExecutionCalcul().getDernierJourIndemnisable().lendemain());
        } else {
          GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_L_CAL_DJI_MANQUANT_SUR_CAL_EXECUTION");
        }
      }
      else {
        try
        {
          facadeAvantProduitSpec = FacadeAvantProduitFactory.getInstance().getInstanceFacadeAvantProduit(attrib.getProduitExecution());
          if ((attrib.getDemande() == null) || (!OutilsMigration.estFigee(attrib.getDemande())) || (attrib.getCalendrierExecutionCalcul() == null) || (attrib.getCalendrierExecutionCalcul().getEtatAuDJI() == null))
          {
            retour = facadeAvantProduitSpec.executerAvant(attrib, true, null, ContextePersistance.isPersistant());
            if (retour.getDernierJourAvant() != null) {
              lendemainDjiMaxDroitNeutralise = Damj.max(lendemainDjiMaxDroitNeutralise, retour.getDernierJourAvant().lendemain());
            } else {
              GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_L_CAL_DERNIER_JOUR_AV_MANQUANT_RESULTAT");
            }
          }
        }
        catch (CoucheLogiqueException ex)
        {
          if ((attrib.getDemande() == null) || (!OutilsMigration.estFigee(attrib.getDemande()))) {
            GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_L_CAL_DATE_EXEC_PENDANT_DROIT_NEUTRA", new Object[] { dateDebutExecution.toString() });
          }
        }
      }
    }
    Damj pjiMinDroitNonNeutralise = Damj.FIN_DES_TEMPS;
    if ((lendemainDjiMaxDroitNeutralise != null) && (!dateDebutExecution.estApresOuCoincideAvec(lendemainDjiMaxDroitNeutralise)))
    {
      List listeAttributionsExecutables = individu.getListeAttributionsExecutables();
      
      Iterator iteratorListeAttribution = listeAttributionsExecutables.iterator();
      while (iteratorListeAttribution.hasNext())
      {
        AttributionSpec attributionIter = (AttributionSpec)iteratorListeAttribution.next();
        if ((attributionIter != null) && (!attributionIter.estNeutralise()) && (attributionIter.getPji() != null)) {
          pjiMinDroitNonNeutralise = Damj.min(pjiMinDroitNonNeutralise, attributionIter.getPji());
        }
      }
      if (pjiMinDroitNonNeutralise.estAvant(lendemainDjiMaxDroitNeutralise)) {
        GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_L_CAL_DATE_EXEC_PENDANT_DROIT_NEUTRA", new Object[] { dateDebutExecution.toString() });
      }
    }
    return lendemainDjiMaxDroitNeutralise;
  }
  
  protected static ResultatPilotage genererResultat(Map mapCalendrier, DomCalculPilotage domCalculPilotage, int p_typeDePostTraitement)
    throws CoucheLogiqueException
  {
    Iterator iterateur = null;
    CalendrierExecutionCalculSpec calendrierExecutionCalcul = null;
    FacadeCalculProduitSpec facadeCalculProduitSpec = null;
    ResultatCalcul resultatCalcul = null;
    ResultatPilotage resultatPilotage = null;
    List listeAttributions = null;
    AttributionSpec attribution = null;
    
    resultatPilotage = new ResultatPilotage();
    resultatPilotage.setEtat(0);
    boolean estUnEtatDroitLincp = false;
    
    listeAttributions = new ArrayList(mapCalendrier.keySet());
    iterateur = listeAttributions.iterator();
    while (iterateur.hasNext())
    {
      attribution = (AttributionSpec)iterateur.next();
      calendrierExecutionCalcul = (CalendrierExecutionCalculSpec)mapCalendrier.get(attribution);
      facadeCalculProduitSpec = FacadeCalculProduitFactory.getInstance().getInstanceGestionnaireCalculProduit(attribution.getProduitExecution());
      switch (p_typeDePostTraitement)
      {
      case 1: 
        resultatCalcul = new ResultatDetailleProduit();
        ((ResultatDetailleProduit)resultatCalcul).setAttribution(attribution);
        break;
      case 2: 
        resultatCalcul = facadeCalculProduitSpec.postTraitementResultatDetaille(attribution, calendrierExecutionCalcul);
        break;
      case 3: 
        if (attribution.equals(domCalculPilotage.getAttributionAEtudier())) {
          resultatCalcul = facadeCalculProduitSpec.postTraitementResultatDetailleNotification(attribution, calendrierExecutionCalcul);
        } else {
          resultatCalcul = facadeCalculProduitSpec.postTraitementResultatDetaille(attribution, calendrierExecutionCalcul);
        }
        break;
      case 4: 
        if ((attribution.equals(domCalculPilotage.getAttributionAEtudier())) || (estAttributionAEtudierMobilite(attribution, domCalculPilotage.getAttributionAEtudier())))
        {
          resultatCalcul = facadeCalculProduitSpec.postTraitementResultatDeterminationEtatDroit(attribution, calendrierExecutionCalcul, domCalculPilotage.getDateEtatDroit());
          
          estUnEtatDroitLincp = true;
        }
        else
        {
          resultatCalcul = facadeCalculProduitSpec.postTraitementResultatDetaille(attribution, calendrierExecutionCalcul);
        }
        break;
      case 5: 
        resultatCalcul = facadeCalculProduitSpec.postTraitementResultatMigrationCalcul(attribution, calendrierExecutionCalcul);
        break;
      default: 
        GestionnaireErreur.getInstance().genererException("HG_PR_CALI_L_TYPE_POST_TRAITEMENT_RESULTAT_INCONNU", new String[] { Integer.valueOf(p_typeDePostTraitement).toString() }, 0);
      }
      resultatCalcul.setCalendrierExecutionCalcul(calendrierExecutionCalcul);
      resultatCalcul.setEtat(0);
      resultatPilotage.ajouteResultatDetaille((ResultatDetailleProduit)resultatCalcul);
    }
    if (estUnEtatDroitLincp)
    {
      BigDecimal montantDerogatoire = BigDecimal.ZERO;
      BigDecimal montantNonDerogatoire = BigDecimal.ZERO;
      Iterator<ResultatDetailleProduit> ite = resultatPilotage.getResultatsDetailles().iterator();
      while (ite.hasNext())
      {
        ResultatDetailleProduit resDetEtatDroitProduit = (ResultatDetailleProduit)ite.next();
        if (((resDetEtatDroitProduit instanceof ResultatDeterminationEtatDroitProduit)) && (resDetEtatDroitProduit.getAttribution().getProduitExecution().getNom().equals(ProduitRbfMob07P01.getInstance().getNom())))
        {
          if (((ResultatDeterminationEtatDroitProduit)resDetEtatDroitProduit).getMontantIndemDerog() != null) {
            montantDerogatoire = montantDerogatoire.add(((ResultatDeterminationEtatDroitProduit)resDetEtatDroitProduit).getMontantIndemDerog().getValeur());
          }
          if (((ResultatDeterminationEtatDroitProduit)resDetEtatDroitProduit).getMontantIndemNonDerog() != null) {
            montantNonDerogatoire = montantNonDerogatoire.add(((ResultatDeterminationEtatDroitProduit)resDetEtatDroitProduit).getMontantIndemNonDerog().getValeur());
          }
        }
      }
      ResultatDeterminationEtatDroitProduit resDetEtatDroitProduit = (ResultatDeterminationEtatDroitProduit)resultatPilotage.getResultatDetaille(domCalculPilotage.getAttributionAEtudier());
      if (resDetEtatDroitProduit.getAttribution().getProduitExecution().getNom().equals(ProduitRbfMob07P01.getInstance().getNom()))
      {
        resDetEtatDroitProduit.setMontantIndemDerog(new QuantiteEuro(montantDerogatoire));
        resDetEtatDroitProduit.setMontantIndemNonDerog(new QuantiteEuro(montantNonDerogatoire));
      }
    }
    return resultatPilotage;
  }
  
  public ResultatVisualisationCalcul initialiserResultatVisualisationCalculAvant(DomCalculPilotage domCalculPilotage)
  {
    ResultatVisualisationCalcul resultatVisualisationCalcul = new ResultatVisualisationCalcul();
    
    AttributionSpec attribution = null;
    Iterator attributions = domCalculPilotage.getListeAttributions().iterator();
    while (attributions.hasNext())
    {
      attribution = (AttributionSpec)attributions.next();
      ResultatVisualisationDetailleeProduit resultatVisualisationDetailleeProduit = new ResultatVisualisationDetailleeProduit();
      resultatVisualisationDetailleeProduit.setAttribution(attribution);
      CalendrierExecutionCalculSpec calendrier = attribution.getCalendrierExecutionCalcul();
      if (calendrier != null)
      {
        resultatVisualisationDetailleeProduit.setPjiAvant(calendrier.getPremierJourIndemnisable());
        resultatVisualisationDetailleeProduit.setDjiAvant(calendrier.getDernierJourIndemnisable());
      }
      resultatVisualisationCalcul.ajouterResultatsVisualisationDetailleeProduit(resultatVisualisationDetailleeProduit);
    }
    return resultatVisualisationCalcul;
  }
  
  public void majResultatVisualisationCalculApres(ResultatVisualisationCalcul resultatVisualisationCalcul, DomCalculPilotage domCalculPilotage, Map mapCalendriers)
  {
    AttributionSpec attribution = null;
    Iterator attributions = domCalculPilotage.getListeAttributions().iterator();
    while (attributions.hasNext())
    {
      attribution = (AttributionSpec)attributions.next();
      CalendrierExecutionCalculSpec calendrierExecutionCalcul = (CalendrierExecutionCalculSpec)mapCalendriers.get(attribution);
      ResultatVisualisationDetailleeProduit resultatVisualisationDetailleeProduit = resultatVisualisationCalcul.getResultatVisualisationDetaillee(attribution);
      if ((resultatVisualisationDetailleeProduit != null) && (attribution != null) && (attribution.getDemande() != null) && (!attribution.estEnReexamen()) && (calendrierExecutionCalcul != null))
      {
        resultatVisualisationDetailleeProduit.setPjiApres(calendrierExecutionCalcul.getPremierJourIndemnisable());
        resultatVisualisationDetailleeProduit.setDjiApres(calendrierExecutionCalcul.getDernierJourIndemnisable());
      }
    }
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
  
  private static boolean contientDemandeTransferee(IndividuSpec individu)
    throws ApplicativeException
  {
    String referenceExterneBlocageTransfert = individu.getIdDemandeSigmaBlocageTransfert();
    return (referenceExterneBlocageTransfert != null) && (!referenceExterneBlocageTransfert.trim().equals(""));
  }
  
  private static boolean estAttributionAEtudierMobilite(AttributionSpec attribution, AttributionSpec attributionAEtudier)
  {
    return (estUnProduitAidesALaMobilite(attribution)) && (attribution.getDemande() != null) && (attribution.getDemande().equals(attributionAEtudier.getDemande()));
  }
  
  private static boolean estUnProduitAidesALaMobilite(AttributionSpec attribution)
  {
    return produitsAideMobilite.contains(attribution.getProduitExecution().getNom());
  }
  
  private static Periode recupererPeriodeInegibilite(AttributionSpec attribution, CalendrierExecutionCalculSpec calendrier)
  {
    Periode periodeIneligibilite = null;
    if (attribution.getGamme().getNomUnique().equals("ASU"))
    {
      BigDecimal areMini = GammeAsu.getInstance().recupereParametresAllocationMinimaleAre(calendrier.getDernierJourIndemnisable());
      if ((calendrier.getEtatAuDJI() != null) && (calendrier.getEtatAuDJI().getMontant() != null) && (calendrier.getEtatAuDJI().getMontant().getMontantPrecompteEffectif() != null) && (calendrier.getEtatAuDJI().getMontant().getMontantPrecompteEffectif().getValeur().compareTo(areMini) > 0)) {
        periodeIneligibilite = new Periode(attribution.getDateAttribution(), calendrier.getDernierJourIndemnisable());
      }
    }
    return periodeIneligibilite;
  }
}

/* Location:
 * Qualified Name:     ParcoursCalculPilotage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */