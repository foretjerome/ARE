package fr.unedic.cali.parcours;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.autresdoms.ga.services.LA2K;
import fr.unedic.cali.calcul.FacadeCalculProduitFactory;
import fr.unedic.cali.calcul.FacadeCalculProduitSpec;
import fr.unedic.cali.calcul.MoteurCalcul;
import fr.unedic.cali.calcul.OutillagePeriodes;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculPeriodique;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculPonctuel;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculSpec;
import fr.unedic.cali.calcul.dom.EtatAuDji;
import fr.unedic.cali.calcul.dom.UniteTraitement;
import fr.unedic.cali.calcul.dom.periode.PeriodeEvenementActualisation;
import fr.unedic.cali.calcul.dom.periode.PeriodeEvenementBloquant;
import fr.unedic.cali.calcul.dom.periode.PeriodeNonDeclareeSanction;
import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeCalcul;
import fr.unedic.cali.calcul.outilsfonctionnels.GestionLA2K;
import fr.unedic.cali.calcul.outilsfonctionnels.GestionPersistance;
import fr.unedic.cali.calcul.outilsfonctionnels.GestionSuivi;
import fr.unedic.cali.calcul.pbjc.dom.IndividuPbjcNcp;
import fr.unedic.cali.calcul.pbjc.outilsfonctionnels.GenerateurPBJCs;
import fr.unedic.cali.calcul.pbjc.outilsfonctionnels.GenerateurPrimes;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.MontantBaseAbstrait;
import fr.unedic.cali.dom.Retraite;
import fr.unedic.cali.dom.affectation.GammeAsu;
import fr.unedic.cali.dom.affectation.GammeSpec;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.cali.outilsfonctionnels.ComparateurSurDateAttribution;
import fr.unedic.cali.outilsfonctionnels.GestionnaireErreur;
import fr.unedic.cali.outilsfonctionnels.OutilRetraite;
import fr.unedic.util.Quantite;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteException;
import fr.unedic.util.services.ContexteLocal;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.Dom;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
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

public abstract class ParcoursMigrationCalculPilotage
  extends ParcoursServiceAbstrait
  implements ParcoursMigrationCalculPilotageSpec
{
  public static final String CONTEXTE_EXECUTION_INDIVIDU_PBJC_NCP_BATCH = "O";
  public static final String CONTEXTE_EXECUTION_INDIVIDU_PBJC_NCP_TP = " ";
  int m_typeDePostTraitement = 0;
  
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
    }
    return resultatRetourne;
  }
  
  public Resultat demarrerParcours(Contexte contexte)
    throws ApplicativeException
  {
    ResultatPilotage retour = null;
    DomCalculPilotage domCalculPilotage = null;
    Map mapCalendrier = null;
    
    Damj dateDebutExecution = null;
    Damj dateArretExecution = null;
    
    retour = new ResultatPilotage();
    
    retour.setEtat(0);
    
    domCalculPilotage = (DomCalculPilotage)contexte.getDonnees();
    
    dateDebutExecution = rechercherDateDebutExecution(domCalculPilotage.getListeAttributions(), domCalculPilotage.getDateDebutExecution(), domCalculPilotage.isExecutionDepuisPersistance());
    if (domCalculPilotage.getDateArretExecution() != null) {
      dateArretExecution = domCalculPilotage.getDateArretExecution().lendemain();
    }
    if (domCalculPilotage.getAttributionAEtudier() != null)
    {
      AttributionSpec attribution = domCalculPilotage.getAttributionAEtudier();
      if (attribution.getCalendrierExecutionCalcul() != null) {
        if (attribution.getCalendrierExecutionCalcul().getDernierJourIndemnisable() != null)
        {
          if (attribution.getCalendrierExecutionCalcul().getDernierJourIndemnisable().estAvant(dateDebutExecution)) {
            dateDebutExecution = attribution.getCalendrierExecutionCalcul().getDernierJourIndemnisable();
          }
          if (attribution.getCalendrierExecutionCalcul().getEtatAttribution() == 3) {
            if (attribution.getCalendrierExecutionCalcul().getDernierJourIndemnisable().estAvant(dateArretExecution)) {
              dateArretExecution = attribution.getCalendrierExecutionCalcul().getDernierJourIndemnisable().lendemain();
            }
          }
        }
      }
    }
    preTraitement(domCalculPilotage, dateDebutExecution, dateArretExecution);
    if (domCalculPilotage.isExecutionPersistante()) {
      mapCalendrier = MoteurCalcul.executerCalcul(dateDebutExecution, dateArretExecution, domCalculPilotage.getListeAttributions(), true, true);
    } else {
      mapCalendrier = MoteurCalcul.executerCalcul(dateDebutExecution, dateArretExecution, domCalculPilotage.getListeAttributions(), domCalculPilotage.isExecutionDepuisPersistance(), false);
    }
    retour = postTraitement(domCalculPilotage.getListeAttributions(), mapCalendrier, domCalculPilotage, dateDebutExecution, dateArretExecution);
    
    return retour;
  }
  
  public int getTypeDePostTraitement()
  {
    return m_typeDePostTraitement;
  }
  
  public void setTypeDePostTraitement(int type)
  {
    m_typeDePostTraitement = type;
  }
  
  public void preTraitement(DomCalculPilotage domCalculPilotage, Damj dateDebutExecution, Damj dateArretExecution)
    throws CoucheLogiqueException
  {
    if (ContexteParcoursCalcul.estPersistant()) {
      if ((domCalculPilotage.isExecutionPersistante()) && 
        (domCalculPilotage.getListeAttributions() != null) && (!domCalculPilotage.getListeAttributions().isEmpty())) {
        GestionSuivi.nettoyerEnquetePbjcNcp(dateDebutExecution, domCalculPilotage.getIndividu());
      }
    }
  }
  
  public ResultatPilotage postTraitement(List listeAttributions, Map mapCalendriers, DomCalculPilotage domCalculPilotage, Damj dateDebutExecution, Damj dateArretExecution)
    throws ApplicativeException
  {
    Map<Damj, AttributionSpec> listeNotificationAllongement = new HashMap();
    if (ContexteParcoursCalcul.estPersistant())
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
      Damj dateDDJINProduit = dateRetraite;
      List listeAttribution = new ArrayList();
      ChronologiePeriodes chronologiePeriodesEvtActualisation = OutillagePeriodes.recupererPeriodesEvtActualisation(domCalculPilotage.getIndividu());
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
        FacadeCalculProduitSpec facadeCalculProduit = FacadeCalculProduitFactory.getInstance().getInstanceGestionnaireCalculProduit(attribution.getProduit());
        
        Damj dateFinDroitTheorique = GestionSuivi.recupererDateFinDroitTheorique(attribution, calendrierExecutionCalcul, facadeCalculProduit);
        
        GestionSuivi.enregistrerDroitPbjcNcp(attribution, dateFinDroitTheorique, facadeCalculProduit, calendrierExecutionCalcul);
        
        Damj dateDebutDispositif = GestionSuivi.recupererDateDebutDispositif(attribution, facadeCalculProduit);
        if (dateDebutDispositif != null) {
          listeNotificationAllongement.put(dateDebutDispositif, attribution);
        }
        GestionLA2K.enrichirCollectionPeriodesActiviteReduite(attribution, calendrierExecutionCalcul, facadeCalculProduit, domCalculPilotage.getIndividu().getListeLA2K(), dateDebutExecution);
        if (calendrierExecutionCalcul.getDernierJourIndemnisablePourSuivi() != null) {
          if (attribution.getProduit().getNomUnique().equals("SOL_ATA06_01")) {
            dateDDJINProduit = calendrierExecutionCalcul.getDernierJourIndemnisablePourSuivi();
          } else {
            dateDDJINProduit = Damj.min(calendrierExecutionCalcul.getDernierJourIndemnisablePourSuivi(), dateDDJINProduit);
          }
        }
      }
      if (Damj.FIN_DES_TEMPS.coincideAvec(dateDDJINProduit)) {
        dateDDJINProduit = dateRetraite;
      }
      if ((chronologiePeriodesEvtActualisation != null) && (!chronologiePeriodesEvtActualisation.estVide()))
      {
        chronologiePeriodesEvtActualisation.iterer();
        while (chronologiePeriodesEvtActualisation.encoreSuivant())
        {
          ObjetChronoPeriodeCalcul periodeEvtActualisation = (ObjetChronoPeriodeCalcul)chronologiePeriodesEvtActualisation.elementSuivant();
          if ((periodeEvtActualisation instanceof PeriodeEvenementBloquant)) {
            dateEvtActualisationBloquant = Damj.min(dateEvtActualisationBloquant, periodeEvtActualisation.getDateDebut());
          }
        }
      }
      if (Damj.FIN_DES_TEMPS.coincideAvec(dateEvtActualisationBloquant)) {
        dernierJourIndemnisablePourSuivi = dateDDJINProduit;
      } else {
        dernierJourIndemnisablePourSuivi = Damj.min(dateEvtActualisationBloquant, dateDDJINProduit);
      }
      GestionSuivi.enregistrerIndividuPbjcNcp(domCalculPilotage.getIndividu(), dernierJourIndemnisablePourSuivi, domCalculPilotage.getComportement(), periodeIneligibilite);
      
      Damj dateDebutGeneration = dateDebutExecution;
      GenerateurPBJCs.enregistrerChronologiePBJCs(GenerateurPBJCs.creerChronologiePBJCs(domCalculPilotage.getListeAttributions(), mapCalendriers, dateDebutGeneration, dateEvtActualisationBloquant, libelleEvtActualisationBloquant, domCalculPilotage.getIndividu()), dateDebutGeneration, domCalculPilotage.getIndividu(), 1);
      
      GenerateurPrimes.enregistrerPrimePbjcNcp(GenerateurPrimes.creerCollectionPrimes(listeAttributions, mapCalendriers, dateDebutGeneration), dateDebutGeneration, domCalculPilotage.getIndividu());
      
      nettoyageAnomaliePasSansSalairePendantMigration(domCalculPilotage.getIndividu());
    }
    GestionSuivi.enregistrerDispositifNcp(listeNotificationAllongement);
    
    Collection attibutionsAbandonnees = new ArrayList();
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
    Iterator iter = listeAttributions.iterator();
    while (iter.hasNext())
    {
      AttributionSpec attribution = (AttributionSpec)iter.next();
      CalendrierExecutionCalculSpec calendrier = (CalendrierExecutionCalculSpec)mapCalendriers.get(attribution);
      attribution.setCalendrierExecutionCalcul(calendrier);
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
  
  protected static Damj rechercherDateDebutExecution(List listeAttributions, Damj dateDebutExec, boolean executionDepuisPersistance)
  {
    Iterator iterateur = null;
    AttributionSpec attribution = null;
    Damj dateDebutExecution = null;
    
    dateDebutExecution = Damj.FIN_DES_TEMPS;
    
    iterateur = listeAttributions.iterator();
    while (iterateur.hasNext())
    {
      attribution = (AttributionSpec)iterateur.next();
      CalendrierExecutionCalculSpec calendrierExecutionCalcul = attribution.getCalendrierExecutionCalcul();
      
      Damj date = Damj.FIN_DES_TEMPS;
      if ("INR_PFM01_01".equals(attribution.getProduit().getNomUnique()))
      {
        if (attribution.getCalendrierExecutionCalcul() != null)
        {
          CalendrierExecutionCalculSpec calendrier = attribution.getCalendrierExecutionCalcul();
          
          attribution.setPjiEffectif(Damj.max(dateDebutExec, attribution.getDateAttribution()));
          calendrier.setPremierJourIndemnisable(Damj.max(dateDebutExec, attribution.getDateAttribution()));
        }
      }
      else if (!executionDepuisPersistance) {
        date = attribution.getPji();
      } else if (calendrierExecutionCalcul == null) {
        date = attribution.getPji();
      } else if ((calendrierExecutionCalcul instanceof CalendrierExecutionCalculPeriodique))
      {
        if ((((CalendrierExecutionCalculPeriodique)calendrierExecutionCalcul).getChronologieUnitesTraitements() == null) || (((CalendrierExecutionCalculPeriodique)calendrierExecutionCalcul).getChronologieUnitesTraitements().estVide()))
        {
          date = attribution.getPji();
        }
        else
        {
          Damj djc = ((UniteTraitement)((CalendrierExecutionCalculPeriodique)calendrierExecutionCalcul).getChronologieUnitesTraitements().dernierElement()).getDateFin().getDebutMoisSuivant();
          if (djc.estAvantOuCoincideAvec(calendrierExecutionCalcul.getDernierJourIndemnisable())) {
            date = djc;
          } else if (calendrierExecutionCalcul.getEtatAttribution() == 5) {
            date = djc;
          }
          Damj pjc = ((UniteTraitement)((CalendrierExecutionCalculPeriodique)calendrierExecutionCalcul).getChronologieUnitesTraitements().premierElement()).getDateFin().getDebutMoisSuivant();
          if ((dateDebutExec != null) && (dateDebutExec.estAvant(pjc))) {
            date = attribution.getPji();
          }
        }
      }
      else if ((calendrierExecutionCalcul instanceof CalendrierExecutionCalculPonctuel)) {
        if (calendrierExecutionCalcul.getEtatAttribution() == 5) {
          date = calendrierExecutionCalcul.getDernierJourIndemnisable();
        }
      }
      if (date.estAvant(dateDebutExecution)) {
        dateDebutExecution = date;
      }
    }
    if (dateDebutExecution.coincideAvec(Damj.FIN_DES_TEMPS))
    {
      dateDebutExecution = Damj.NUIT_DES_TEMPS;
      
      iterateur = listeAttributions.iterator();
      while (iterateur.hasNext())
      {
        attribution = (AttributionSpec)iterateur.next();
        CalendrierExecutionCalculSpec calendrierExecutionCalcul = attribution.getCalendrierExecutionCalcul();
        
        Damj djc = null;
        if ((calendrierExecutionCalcul instanceof CalendrierExecutionCalculPonctuel)) {
          djc = calendrierExecutionCalcul.getDernierJourIndemnisable();
        } else if ((calendrierExecutionCalcul instanceof CalendrierExecutionCalculPeriodique)) {
          if ((((CalendrierExecutionCalculPeriodique)calendrierExecutionCalcul).getChronologieUnitesTraitements() != null) && (!((CalendrierExecutionCalculPeriodique)calendrierExecutionCalcul).getChronologieUnitesTraitements().estVide())) {
            djc = ((UniteTraitement)((CalendrierExecutionCalculPeriodique)calendrierExecutionCalcul).getChronologieUnitesTraitements().dernierElement()).getDateDebut().getFinMoisPrecedent();
          }
        }
        if ((djc == null) || (djc.coincideAvec(Damj.FIN_DES_TEMPS)) || (djc.estAvant(calendrierExecutionCalcul.getPremierJourIndemnisable()))) {
          djc = calendrierExecutionCalcul.getPremierJourIndemnisable().veille();
        }
        if (djc.estApres(dateDebutExecution)) {
          dateDebutExecution = djc.lendemain();
        }
      }
      if (dateDebutExecution.coincideAvec(Damj.NUIT_DES_TEMPS)) {
        dateDebutExecution = Damj.FIN_DES_TEMPS;
      }
    }
    if ((dateDebutExec != null) && (dateDebutExecution.estApres(dateDebutExec))) {
      dateDebutExecution = dateDebutExec;
    }
    return dateDebutExecution;
  }
  
  protected static ResultatPilotage genererResultat(Map mapCalendrier, DomCalculPilotage domCalculPilotage, int typeDePostTraitement)
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
    
    listeAttributions = new ArrayList(mapCalendrier.keySet());
    iterateur = listeAttributions.iterator();
    while (iterateur.hasNext())
    {
      attribution = (AttributionSpec)iterateur.next();
      
      calendrierExecutionCalcul = (CalendrierExecutionCalculSpec)mapCalendrier.get(attribution);
      
      facadeCalculProduitSpec = FacadeCalculProduitFactory.getInstance().getInstanceGestionnaireCalculProduit(attribution.getProduitExecution());
      switch (typeDePostTraitement)
      {
      case 1: 
        resultatCalcul = facadeCalculProduitSpec.postTraitementResultatMigrationCalcul(attribution, calendrierExecutionCalcul);
        break;
      default: 
        GestionnaireErreur.getInstance().genererException("HG_PR_CALI_L_TYPE_POST_TRAITEMENT_RESULTAT_INCONNU", new String[] { new Integer(typeDePostTraitement).toString() }, 0);
      }
      resultatCalcul.setCalendrierExecutionCalcul(calendrierExecutionCalcul);
      resultatCalcul.setEtat(0);
      
      resultatPilotage.ajouteResultatDetaille((ResultatDetailleProduit)resultatCalcul);
    }
    return resultatPilotage;
  }
  
  private static void nettoyageAnomaliePasSansSalairePendantMigration(IndividuSpec pIndividu)
  {
    IndividuPbjcNcp individu = pIndividu.getIndividuPbjcNcp();
    
    String codeAnomalie = individu.getCodeAnomalieCalcul();
    if ((codeAnomalie != null) && (codeAnomalie.equals("I02")))
    {
      individu.setCodeAnomalieCalcul(null);
      individu.setDonneeAnomalieCalcul(null);
      individu.setEtatDerniereExecution(0);
    }
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
 * Qualified Name:     ParcoursMigrationCalculPilotage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */