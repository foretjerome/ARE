package fr.unedic.cali.calcul.pbjc.outilsfonctionnels;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.calcul.aides.FacadeAidesProduitFactory;
import fr.unedic.cali.calcul.aides.FacadeAidesProduitSpec;
import fr.unedic.cali.calcul.dom.ArretProduitAvecRaison;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculPeriodique;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculPonctuel;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculSpec;
import fr.unedic.cali.calcul.dom.EvenementPaiementProduitPonctuel;
import fr.unedic.cali.calcul.dom.QualificationPeriodes;
import fr.unedic.cali.calcul.dom.Somme;
import fr.unedic.cali.calcul.dom.UniteTraitement;
import fr.unedic.cali.calcul.outilsfonctionnels.OutilGestionPoursuite;
import fr.unedic.cali.calcul.pbjc.dom.AideNcp;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.cali.parcours.ContexteParcoursCalcul;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoPeriode;
import fr.unedic.util.temps.Periode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

public class GenerateurAIDEs
{
  private static List<String> s_listeAides = new ArrayList();
  private static List<String> s_aidesANePasFusionner = new ArrayList();
  
  static
  {
    s_listeAides.add("RBF_MOB07_01");
    s_listeAides.add("RBF_MOB07_01_DE");
    s_listeAides.add("RBF_MOB07_01_TR");
    s_listeAides.add("RBF_MOB07_01_HE");
    s_listeAides.add("RBF_MOB07_01_RE");
    s_listeAides.add("RBF_AGE08_01");
    s_listeAides.add("RBF_AIDES_01");
    
    s_aidesANePasFusionner.add("RBF_AGE08_01");
    s_aidesANePasFusionner.add("RBF_AIDES_01");
  }
  
  public static ChronologiePeriodes creerChronologieAIDEs(List p_listeAttributions, Map p_mapCalendrier, Damj p_dateDebutGeneration, Damj p_dateBlocageActualisation, String p_libelleBlocageActualisation, IndividuSpec p_individu)
    throws ApplicativeException
  {
    ChronologiePeriodes chronoAIDEs = new ChronologiePeriodes();
    List<ChronologiePeriodes> listeChronologieAIDEs = new LinkedList();
    
    HashMap<DemandeSpec, List<AttributionSpec>> mapDesAttributions = grouperAttributionsParDemande(p_listeAttributions);
    
    Iterator iterateurAttributionsMemeDemande = mapDesAttributions.keySet().iterator();
    Iterator iterator = null;
    while (iterateurAttributionsMemeDemande.hasNext())
    {
      DemandeSpec demande = (DemandeSpec)iterateurAttributionsMemeDemande.next();
      
      listeChronologieAIDEs = creerChronologieAidesMonoProduit((List)mapDesAttributions.get(demande), p_mapCalendrier, p_dateDebutGeneration, p_dateBlocageActualisation, p_libelleBlocageActualisation, iterator);
      
      chronoAIDEs.ajouter(creerChronologieAIDEsMultiProduit(listeChronologieAIDEs));
    }
    return chronoAIDEs;
  }
  
  private static List<ChronologiePeriodes> creerChronologieAidesMonoProduit(List<AttributionSpec> p_listeAttributions, Map p_mapCalendrier, Damj p_dateDebutGeneration, Damj p_dateBlocageActualisation, String p_libelleBlocageActualisation, Iterator p_iterator)
    throws ApplicativeException
  {
    List<ChronologiePeriodes> listeChronologieAIDEs = new LinkedList();
    
    p_iterator = p_listeAttributions.iterator();
    while (p_iterator.hasNext())
    {
      AttributionSpec attribution = (AttributionSpec)p_iterator.next();
      if (controlerAttributionProduit(attribution))
      {
        FacadeAidesProduitSpec facadeAIDEProduit = creerFacadesAIDEProduit(attribution);
        ChronologiePeriodes chronoPeriodes = null;
        if (p_mapCalendrier.containsKey(attribution))
        {
          CalendrierExecutionCalculSpec calendrierExecutionCalcul = (CalendrierExecutionCalculSpec)p_mapCalendrier.get(attribution);
          if ((calendrierExecutionCalcul instanceof CalendrierExecutionCalculPeriodique))
          {
            chronoPeriodes = creerChronologieAIDEsMonoProduit(attribution, (CalendrierExecutionCalculPeriodique)calendrierExecutionCalcul, p_dateDebutGeneration, p_dateBlocageActualisation, p_libelleBlocageActualisation);
            
            facadeAIDEProduit.traiterAIDEsAPosteriori(chronoPeriodes, attribution);
            listeChronologieAIDEs.add(chronoPeriodes);
          }
          else if ((calendrierExecutionCalcul instanceof CalendrierExecutionCalculPonctuel))
          {
            chronoPeriodes = creerChronologieAIDEs(attribution, (CalendrierExecutionCalculPonctuel)calendrierExecutionCalcul, p_dateDebutGeneration);
            
            listeChronologieAIDEs.add(chronoPeriodes);
          }
        }
      }
    }
    return listeChronologieAIDEs;
  }
  
  private static ChronologiePeriodes creerChronologieAIDEsMonoProduit(AttributionSpec p_attribution, CalendrierExecutionCalculPeriodique p_calendrier, Damj p_dateDebutGeneration, Damj p_dateBlocageActualisation, String p_libelleBlocageActualisation)
    throws ApplicativeException
  {
    ChronologiePeriodes chronoARetourner = null;
    ChronologiePeriodes unitesTraitement = null;
    
    chronoARetourner = new ChronologiePeriodes();
    if (!controlerAttributionProduit(p_attribution)) {
      return chronoARetourner;
    }
    unitesTraitement = (ChronologiePeriodes)p_calendrier.getChronologieUnitesTraitements();
    if (unitesTraitement == null) {
      throw new CoucheLogiqueException("HG_PR_CALI_L_PBJC_UNITES_TRAITEMENT_ABSENTE", "Chronologie des Unités de Traitement vide lors de la création des PBJCs pour le produit", null);
    }
    FacadeAidesProduitSpec facadeAIDEProduit = creerFacadesAIDEProduit(p_attribution);
    if (!facadeAIDEProduit.controlerExecutionAides(p_attribution)) {
      return chronoARetourner;
    }
    chronoARetourner.ajouter(creerChronologieAIDEsMonoProduitPendant(facadeAIDEProduit, p_attribution, p_calendrier, p_dateDebutGeneration, p_dateBlocageActualisation, p_libelleBlocageActualisation));
    
    return chronoARetourner;
  }
  
  private static ChronologiePeriodes creerChronologieAIDEsMonoProduitPendant(FacadeAidesProduitSpec p_facadeAIDEProduit, AttributionSpec p_attribution, CalendrierExecutionCalculPeriodique p_calendrier, Damj p_dateDebutGeneration, Damj p_dateBlocageActualisation, String p_libelleBlocageActualisation)
    throws CoucheLogiqueException
  {
    ChronologiePeriodes chronoARetourner = new ChronologiePeriodes();
    ChronologiePeriodes chronoAIDEsSurUt = null;
    ChronologiePeriodes unitesTraitement = null;
    UniteTraitement ut = null;
    
    unitesTraitement = (ChronologiePeriodes)p_calendrier.getChronologieUnitesTraitements();
    
    ListIterator itUnitesTraitement = unitesTraitement.iterer();
    while (itUnitesTraitement.hasNext())
    {
      ut = (UniteTraitement)itUnitesTraitement.next();
      if ((ut.getDateFin().estApresOuCoincideAvec(p_dateDebutGeneration)) && (!ut.getDateDebut().estApres(p_calendrier.getDernierJourIndemnisable())) && 
      
        (p_facadeAIDEProduit.creerAIDEsurUT(p_attribution, ut)))
      {
        chronoAIDEsSurUt = new ChronologiePeriodes();
        
        chronoAIDEsSurUt.ajouter(traiterPeriodesSuspensives(p_facadeAIDEProduit, p_attribution, ut));
        
        chronoAIDEsSurUt.ajouter(traiterSommes(p_facadeAIDEProduit, p_attribution, ut));
        
        chronoAIDEsSurUt = p_facadeAIDEProduit.supprimerAIDEsANePasPrendreEnCompte(chronoAIDEsSurUt);
        if (chronoAIDEsSurUt.contientChevauchementElements()) {
          chronoAIDEsSurUt = fusionnerAIDEs(chronoAIDEsSurUt);
        }
        chronoARetourner.ajouter(chronoAIDEsSurUt);
      }
    }
    return chronoARetourner;
  }
  
  private static ChronologiePeriodes traiterPeriodesSuspensives(FacadeAidesProduitSpec p_facadeAideProduit, AttributionSpec p_attribution, UniteTraitement p_ut)
    throws CoucheLogiqueException
  {
    Damj pjeNcp = null;
    ChronologiePeriodes chronologieARetourner = null;
    chronologieARetourner = null;
    QualificationPeriodes qualificationPeriodes = null;
    ChronologiePeriodes periodesSuspensives = null;
    ObjetChronoPeriode periode = null;
    AideNcp aideNcp = null;
    Damj dateFinDeProduit = null;
    if ((p_ut.getArretProduitAvecRaison() != null) && (p_ut.getArretProduitAvecRaison().isProduitAArreter())) {
      dateFinDeProduit = p_ut.getArretProduitAvecRaison().recupereLendemainDateArret().veille();
    }
    chronologieARetourner = new ChronologiePeriodes();
    
    qualificationPeriodes = p_ut.getQualificationPeriodes();
    periodesSuspensives = qualificationPeriodes.getPeriodesSuspensives();
    periodesSuspensives = p_facadeAideProduit.traitementPeriodesSuspensives(periodesSuspensives, p_ut);
    ListIterator it = periodesSuspensives.iterer();
    while (it.hasNext())
    {
      periode = (ObjetChronoPeriode)it.next();
      if ((dateFinDeProduit == null) || (!dateFinDeProduit.estAvant(periode.getDateDebut())))
      {
        pjeNcp = OutilGestionPoursuite.getInstance().recupererPremierJourExecutableNcp(p_attribution);
        if (periode.getDateDebut().estAvant(pjeNcp))
        {
          if (periode.getDateFin().estApresOuCoincideAvec(pjeNcp)) {
            periode.setDateDebut(pjeNcp);
          }
        }
        else if (periode.getDateFin().estApres(p_attribution.getCalendrierExecutionCalcul().getDernierJourIndemnisable()))
        {
          if (periode.getDateDebut().estAvantOuCoincideAvec(p_attribution.getCalendrierExecutionCalcul().getDernierJourIndemnisable())) {
            periode.setDateFin(p_attribution.getCalendrierExecutionCalcul().getDernierJourIndemnisable());
          }
        }
        else
        {
          aideNcp = creerAideNiveauPeriodeSuspensive(p_facadeAideProduit, p_attribution, p_ut, periode);
          if (aideNcp != null) {
            chronologieARetourner.ajouter(aideNcp);
          }
        }
      }
    }
    return chronologieARetourner;
  }
  
  private static ChronologiePeriodes traiterSommes(FacadeAidesProduitSpec p_facadeAIDEProduit, AttributionSpec p_attribution, UniteTraitement p_ut)
    throws CoucheLogiqueException
  {
    ChronologiePeriodes chronologieARetourner = null;
    AideNcp aideNcp = null;
    Collection listeDesSommes = null;
    Iterator iterateurDesSommes = null;
    Somme somme = null;
    somme = null;
    
    chronologieARetourner = new ChronologiePeriodes();
    
    listeDesSommes = p_ut.getCollectionSommes();
    iterateurDesSommes = listeDesSommes.iterator();
    while (iterateurDesSommes.hasNext())
    {
      somme = (Somme)iterateurDesSommes.next();
      if (p_facadeAIDEProduit.creerAIDEsurSomme(p_attribution, somme))
      {
        aideNcp = creerAideNiveauSomme(p_facadeAIDEProduit, p_ut, p_attribution, somme);
        if (aideNcp != null) {
          chronologieARetourner.ajouter(aideNcp);
        }
      }
    }
    return chronologieARetourner;
  }
  
  private static AideNcp creerAideNiveauSomme(FacadeAidesProduitSpec p_facadeAIDEProduit, UniteTraitement p_ut, AttributionSpec p_attribution, Somme p_somme)
    throws CoucheLogiqueException
  {
    AideNcp aideNcp = creerAide(p_facadeAIDEProduit, p_ut, p_attribution, p_somme.getDateDebut(), p_somme.getDateFin());
    if (aideNcp != null) {
      p_facadeAIDEProduit.ajouterGroupeMontantProduit(aideNcp, p_attribution, p_somme, p_ut);
    }
    return aideNcp;
  }
  
  private static AideNcp creerAide(FacadeAidesProduitSpec p_facadeAIDEProduit, UniteTraitement p_ut, AttributionSpec p_attribution, Damj p_dateDebut, Damj p_dateFin)
    throws CoucheLogiqueException
  {
    return creerAideNiveauPeriodeSuspensive(p_facadeAIDEProduit, p_attribution, p_ut, p_dateDebut, p_dateFin);
  }
  
  private static AideNcp creerAideNiveauPeriodeSuspensive(FacadeAidesProduitSpec p_facadeAIDEProduit, AttributionSpec p_attribution, UniteTraitement p_ut, Damj p_dateDebut, Damj p_dateFin)
    throws CoucheLogiqueException
  {
    return p_facadeAIDEProduit.creerAideNcp(p_ut, p_attribution, p_dateDebut, p_dateFin);
  }
  
  private static AideNcp creerAideNiveauPeriodeSuspensive(FacadeAidesProduitSpec p_facadeAIDEProduit, AttributionSpec p_attribution, UniteTraitement p_ut, ObjetChronoPeriode p_periode)
    throws CoucheLogiqueException
  {
    AideNcp aideNcp = p_facadeAIDEProduit.creerAideNcp(p_ut, p_attribution, p_periode.getDateDebut(), p_periode.getDateFin());
    if (aideNcp != null) {
      p_facadeAIDEProduit.qualifierAIDESuspensive(aideNcp, p_periode);
    }
    return aideNcp;
  }
  
  private static ChronologiePeriodes creerChronologieAIDEsMultiProduit(List p_listeChronoAIDEs)
  {
    ChronologiePeriodes chronoAIDEsFinale = new ChronologiePeriodes();
    ChronologiePeriodes chronoAIDEsMultiProduits = new ChronologiePeriodes();
    List<ChronologiePeriodes> chronoAIDEsNonMobilite = new ArrayList();
    
    Iterator iterateurChronos = p_listeChronoAIDEs.iterator();
    while (iterateurChronos.hasNext())
    {
      ChronologiePeriodes chrono = (ChronologiePeriodes)iterateurChronos.next();
      ListIterator chronos = chrono.iterer();
      while (chronos.hasNext())
      {
        AideNcp aideNcp = (AideNcp)chronos.next();
        if (controlerFusion(aideNcp)) {
          chronoAIDEsNonMobilite.add(chrono);
        } else {
          chronoAIDEsMultiProduits.ajouter(aideNcp);
        }
      }
    }
    chronoAIDEsMultiProduits = fusionnerAIDEs(chronoAIDEsMultiProduits);
    for (ChronologiePeriodes chrono : chronoAIDEsNonMobilite) {
      chronoAIDEsFinale.ajouter(chrono);
    }
    Iterator chronoAIDEsMobilite = chronoAIDEsMultiProduits.iterer();
    while (chronoAIDEsMobilite.hasNext()) {
      chronoAIDEsFinale.ajouter((AideNcp)chronoAIDEsMobilite.next());
    }
    return chronoAIDEsFinale;
  }
  
  public static ChronologiePeriodes fusionnerAIDEs(ChronologiePeriodes p_chronoAIDEs)
  {
    Damj debutPeriodeA = null;
    Damj debutPeriodeB = null;
    ChronologiePeriodes chronoFiltree = null;
    AideNcp aideNcp = null;
    
    ChronologiePeriodes chronoAIDEsARetourner = new ChronologiePeriodes();
    List datesDeRupture = new ArrayList();
    
    chronoAIDEsARetourner.setOptionChevauchementInterdit();
    
    ListIterator itChronoAIDEs = p_chronoAIDEs.iterer();
    while (itChronoAIDEs.hasNext())
    {
      aideNcp = (AideNcp)itChronoAIDEs.next();
      datesDeRupture.add(aideNcp.getDateDebutAide());
      datesDeRupture.add(aideNcp.getDateFinAide().lendemain());
    }
    datesDeRupture = new ArrayList(new HashSet(datesDeRupture));
    
    Collections.sort(datesDeRupture);
    
    Iterator iterateurDatesDeRupture = datesDeRupture.iterator();
    while (iterateurDatesDeRupture.hasNext()) {
      if (debutPeriodeA == null)
      {
        debutPeriodeA = (Damj)iterateurDatesDeRupture.next();
      }
      else
      {
        debutPeriodeB = (Damj)iterateurDatesDeRupture.next();
        chronoFiltree = filtrerRognerPeriodes(p_chronoAIDEs, debutPeriodeA, debutPeriodeB.veille());
        if (chronoFiltree.getTaille() == 1) {
          chronoAIDEsARetourner.ajouter(chronoFiltree);
        } else if (!chronoFiltree.estVide()) {
          chronoAIDEsARetourner.ajouter(fusionnerAIDEsMultiProduits(chronoFiltree));
        }
        debutPeriodeA = debutPeriodeB;
      }
    }
    return chronoAIDEsARetourner;
  }
  
  private static ChronologiePeriodes filtrerRognerPeriodes(ChronologiePeriodes p_chronoAFiltrer, Damj p_dateDeDebut, Damj p_dateDeFin)
  {
    ChronologiePeriodes chronologieARetourner = null;
    AideNcp aideNcp = null;
    AideNcp aideOriginale = null;
    boolean tropLoin = false;
    
    chronologieARetourner = new ChronologiePeriodes();
    ListIterator itChronoAfiltrer = p_chronoAFiltrer.iterer();
    while ((itChronoAfiltrer.hasNext()) && (!tropLoin))
    {
      aideOriginale = (AideNcp)itChronoAfiltrer.next();
      aideNcp = (AideNcp)aideOriginale.copie();
      if (aideNcp.chevauche(new Periode(p_dateDeDebut, p_dateDeFin)))
      {
        if (!aideNcp.getDateDebut().coincideAvec(p_dateDeDebut))
        {
          aideNcp.setDateDebutAide(p_dateDeDebut);
          
          aideOriginale.setDateFinAide(p_dateDeDebut.veille());
        }
        if (!aideNcp.getDateFin().coincideAvec(p_dateDeFin))
        {
          aideNcp.setDateFinAide(p_dateDeFin);
          
          aideOriginale.setDateDebutAide(p_dateDeFin.lendemain());
        }
        chronologieARetourner.ajouter(aideNcp);
      }
      if (p_dateDeFin.estAvant(aideNcp.getDateDebut())) {
        tropLoin = true;
      }
    }
    return chronologieARetourner;
  }
  
  private static AideNcp fusionnerAIDEsMultiProduits(ChronologiePeriodes p_chronoAIDEs)
  {
    AideNcp aideFusion = (AideNcp)p_chronoAIDEs.premierElement();
    p_chronoAIDEs.supprimer(aideFusion);
    fusionnerAIDEsMultiProduits(aideFusion, p_chronoAIDEs);
    return aideFusion;
  }
  
  private static void fusionnerAIDEsMultiProduits(AideNcp p_aide, ChronologiePeriodes p_chronoAIDEs)
  {
    AideNcp aideIteration = null;
    ListIterator itChronoAIDE = p_chronoAIDEs.iterer();
    while (itChronoAIDE.hasNext())
    {
      aideIteration = (AideNcp)itChronoAIDE.next();
      if (aideIteration.getTypePopulation1() != null) {
        p_aide.ajouterTypeSousTypePopulation(aideIteration.getTypePopulation1(), aideIteration.getSousTypePopulation1());
      }
      if (aideIteration.getTypePopulation2() != null) {
        p_aide.ajouterTypeSousTypePopulation(aideIteration.getTypePopulation2(), aideIteration.getSousTypePopulation2());
      }
      if (aideIteration.getTypePopulation3() != null) {
        p_aide.ajouterTypeSousTypePopulation(aideIteration.getTypePopulation3(), aideIteration.getSousTypePopulation3());
      }
      if (aideIteration.getTypePopulation4() != null) {
        p_aide.ajouterTypeSousTypePopulation(aideIteration.getTypePopulation4(), aideIteration.getSousTypePopulation4());
      }
      if (aideIteration.getTypePopulation5() != null) {
        p_aide.ajouterTypeSousTypePopulation(aideIteration.getTypePopulation5(), aideIteration.getSousTypePopulation5());
      }
      if (aideIteration.getCodeSousProduit1() != null) {
        p_aide.ajouterGroupeMontants(aideIteration.getCodeSousProduit1(), aideIteration.getCodeNatureDerogatoireSousProduit1(), aideIteration.getComplementTypeMontant1(), aideIteration.getNbAidesIndemniseesPeriode1(), aideIteration.getMontantUnitaireAide1(), aideIteration.getMontantTotalAide1());
      }
      if (aideIteration.getCodeSousProduit2() != null) {
        p_aide.ajouterGroupeMontants(aideIteration.getCodeSousProduit2(), aideIteration.getCodeNatureDerogatoireSousProduit2(), aideIteration.getComplementTypeMontant2(), aideIteration.getNbAidesIndemniseesPeriode2(), aideIteration.getMontantUnitaireAide2(), aideIteration.getMontantTotalAide2());
      }
      if (aideIteration.getCodeSousProduit3() != null) {
        p_aide.ajouterGroupeMontants(aideIteration.getCodeSousProduit3(), aideIteration.getCodeNatureDerogatoireSousProduit3(), aideIteration.getComplementTypeMontant3(), aideIteration.getNbAidesIndemniseesPeriode3(), aideIteration.getMontantUnitaireAide3(), aideIteration.getMontantTotalAide3());
      }
      if (aideIteration.getCodeSousProduit4() != null) {
        p_aide.ajouterGroupeMontants(aideIteration.getCodeSousProduit4(), aideIteration.getCodeNatureDerogatoireSousProduit4(), aideIteration.getComplementTypeMontant4(), aideIteration.getNbAidesIndemniseesPeriode4(), aideIteration.getMontantUnitaireAide4(), aideIteration.getMontantTotalAide4());
      }
      itChronoAIDE.remove();
    }
  }
  
  private static boolean controlerAttributionProduit(AttributionSpec p_attribution)
  {
    return s_listeAides.contains(p_attribution.getProduit().getNom());
  }
  
  private static boolean controlerFusion(AideNcp p_aide)
  {
    return s_aidesANePasFusionner.contains(p_aide.getCodeProduit());
  }
  
  private static FacadeAidesProduitSpec creerFacadesAIDEProduit(AttributionSpec p_attribution)
    throws CoucheLogiqueException
  {
    return FacadeAidesProduitFactory.getInstance().getInstanceGestionnaireAidesProduit(p_attribution.getProduit());
  }
  
  public static void enregistrerChronologieAIDEs(ChronologiePeriodes p_chronAIDEs, Damj p_dateDebutGeneration, IndividuSpec p_individu)
    throws CoucheLogiqueException
  {
    ChronologiePeriodes chronoAIDEs = p_individu.getChronoAides();
    ChronologiePeriodes chronoAIDEsASuppr = new ChronologiePeriodes();
    ListIterator itChronoAIDES = chronoAIDEs.iterer();
    boolean trouvee = false;
    if (p_individu.getDateDebutGenerationAides().coincideAvec(Damj.NUIT_DES_TEMPS)) {
      p_individu.setDateDebutGenerationAides(p_dateDebutGeneration);
    } else {
      p_individu.setDateDebutGenerationAides(Damj.min(p_individu.getDateDebutGenerationAides(), p_dateDebutGeneration));
    }
    while ((itChronoAIDES.hasNext()) && (!trouvee))
    {
      AideNcp oldAide = (AideNcp)itChronoAIDES.next();
      if (oldAide.getDateDebutAide().estApresOuCoincideAvec(p_dateDebutGeneration))
      {
        trouvee = true;
        itChronoAIDES.previous();
      }
    }
    if ((itChronoAIDES.hasNext()) && (p_chronAIDEs != null) && (!p_chronAIDEs.estVide()))
    {
      ListIterator itPChronoAIDES = p_chronAIDEs.iterer();
      while ((itChronoAIDES.hasNext()) && (itPChronoAIDES.hasNext()))
      {
        AideNcp oldAide = (AideNcp)itChronoAIDES.next();
        AideNcp newAide = (AideNcp)itPChronoAIDES.next();
        newAide.copieElements(oldAide);
      }
      while (itChronoAIDES.hasNext())
      {
        AideNcp aideASupr = (AideNcp)itChronoAIDES.next();
        chronoAIDEsASuppr.ajouter(aideASupr);
        DomManager.supprimer(aideASupr);
      }
      while (itPChronoAIDES.hasNext()) {
        chronoAIDEs.ajouter((AideNcp)itPChronoAIDES.next());
      }
    }
    else
    {
      if (itChronoAIDES.hasNext()) {
        while (itChronoAIDES.hasNext())
        {
          AideNcp aideASupr = (AideNcp)itChronoAIDES.next();
          chronoAIDEsASuppr.ajouter(aideASupr);
          DomManager.supprimer(aideASupr);
        }
      }
      if ((p_chronAIDEs != null) && (!p_chronAIDEs.estVide()))
      {
        ListIterator itPChronoAIDES = p_chronAIDEs.iterer();
        while (itPChronoAIDES.hasNext()) {
          chronoAIDEs.ajouter((AideNcp)itPChronoAIDES.next());
        }
      }
    }
    Iterator ite = chronoAIDEsASuppr.iterer();
    while (ite.hasNext()) {
      chronoAIDEs.supprimer((AideNcp)ite.next());
    }
  }
  
  public static void nettoyerAides(Damj p_dateDebutNettoyage, IndividuSpec p_individu)
  {
    if (ContexteParcoursCalcul.estPersistant())
    {
      ChronologiePeriodes chronoAIDEs = p_individu.getChronoAides();
      ChronologiePeriodes chronoAIDEsASuppr = new ChronologiePeriodes();
      if (chronoAIDEs != null)
      {
        ListIterator itChronoAIDES = chronoAIDEs.iterer();
        while (itChronoAIDES.hasNext())
        {
          AideNcp oldAide = (AideNcp)itChronoAIDES.next();
          if (oldAide.getDateDebutAide().estApresOuCoincideAvec(p_dateDebutNettoyage))
          {
            chronoAIDEsASuppr.ajouter(oldAide);
            DomManager.supprimer(oldAide);
          }
        }
        Iterator ite = chronoAIDEsASuppr.iterer();
        while (ite.hasNext()) {
          chronoAIDEs.supprimer((AideNcp)ite.next());
        }
      }
    }
  }
  
  private static ChronologiePeriodes creerChronologieAIDEs(AttributionSpec p_attribution, CalendrierExecutionCalculPonctuel p_calendrier, Damj p_dateDebutGeneration)
    throws ApplicativeException
  {
    ChronologiePeriodes chronoARetourner = null;
    EvenementPaiementProduitPonctuel evtPPP = null;
    
    chronoARetourner = new ChronologiePeriodes();
    if (!controlerAttributionProduit(p_attribution)) {
      return chronoARetourner;
    }
    if (p_calendrier.getDernierJourIndemnisable().estAvant(p_dateDebutGeneration)) {
      return chronoARetourner;
    }
    evtPPP = p_calendrier.getEvenementPaiementProduitPonctuel();
    if (evtPPP == null) {
      throw new CoucheLogiqueException("HG_PR_CALI_L_EVT_PRODUIT_PONCTUEL_ABSENTE", "EvenementPaiementProduitPonctuel vide lors de la création des Primes pour le produit", null);
    }
    chronoARetourner.ajouter(creerCollectionAidesPendantPP(p_attribution, p_calendrier));
    
    return chronoARetourner;
  }
  
  private static ChronologiePeriodes creerCollectionAidesPendantPP(AttributionSpec p_attribution, CalendrierExecutionCalculPonctuel p_calendrier)
    throws CoucheLogiqueException
  {
    ChronologiePeriodes chronoARetourner = new ChronologiePeriodes();
    EvenementPaiementProduitPonctuel evtPPP = null;
    
    evtPPP = p_calendrier.getEvenementPaiementProduitPonctuel();
    
    FacadeAidesProduitSpec facadePrime = creerFacadesAIDEProduit(p_attribution);
    if (facadePrime != null)
    {
      AideNcp aide = facadePrime.creerAideProduitPonctuelNcp(evtPPP, p_attribution);
      if (aide != null) {
        chronoARetourner.ajouter(aide);
      }
    }
    return chronoARetourner;
  }
  
  private static HashMap<DemandeSpec, List<AttributionSpec>> grouperAttributionsParDemande(List p_listeAttributions)
  {
    HashMap<DemandeSpec, List<AttributionSpec>> mapDesAttributions = new HashMap();
    Iterator iterator = p_listeAttributions.iterator();
    while (iterator.hasNext())
    {
      AttributionSpec attribution = (AttributionSpec)iterator.next();
      if (controlerAttributionProduit(attribution))
      {
        DemandeSpec demande = attribution.getDemande();
        if (mapDesAttributions.containsKey(demande))
        {
          ((List)mapDesAttributions.get(demande)).add(attribution);
        }
        else
        {
          List<AttributionSpec> listeAttributions = new ArrayList();
          listeAttributions.add(attribution);
          mapDesAttributions.put(demande, listeAttributions);
        }
      }
    }
    return mapDesAttributions;
  }
}

/* Location:
 * Qualified Name:     GenerateurAIDEs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */