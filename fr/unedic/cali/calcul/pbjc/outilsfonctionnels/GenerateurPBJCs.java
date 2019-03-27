package fr.unedic.cali.calcul.pbjc.outilsfonctionnels;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.autresdoms.cohab.dom.ObjetChronoPeriodePriseEnCharge;
import fr.unedic.cali.autresdoms.ga.dom.spec.PeriodeGaecSpec;
import fr.unedic.cali.calcul.OutillagePeriodes;
import fr.unedic.cali.calcul.dom.ArretProduitAvecRaison;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculPeriodique;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculSpec;
import fr.unedic.cali.calcul.dom.ConstituantsIndemnisation;
import fr.unedic.cali.calcul.dom.QualificationPeriodes;
import fr.unedic.cali.calcul.dom.Somme;
import fr.unedic.cali.calcul.dom.UniteTraitement;
import fr.unedic.cali.calcul.dom.periode.ActionFormation;
import fr.unedic.cali.calcul.dom.periode.DebutActionFormation;
import fr.unedic.cali.calcul.dom.periode.DsmAbsenceAuPointage;
import fr.unedic.cali.calcul.dom.periode.DsmCongesNonPayes;
import fr.unedic.cali.calcul.dom.periode.DsmMaladie;
import fr.unedic.cali.calcul.dom.periode.DsmSuspensionContratTravail;
import fr.unedic.cali.calcul.dom.periode.DsmTravail;
import fr.unedic.cali.calcul.dom.periode.FinPeriodeFormation;
import fr.unedic.cali.calcul.dom.periode.FinPeriodeFormationNonIndemnisee;
import fr.unedic.cali.calcul.dom.periode.ObjetPeriodeAAH;
import fr.unedic.cali.calcul.dom.periode.PeriodeClca;
import fr.unedic.cali.calcul.dom.periode.PeriodeDisponibilite;
import fr.unedic.cali.calcul.dom.periode.PeriodeEvenementPersonnel;
import fr.unedic.cali.calcul.dom.periode.PeriodeFormationNonIndemnisee;
import fr.unedic.cali.calcul.dom.periode.PeriodeInassiduiteFormation;
import fr.unedic.cali.calcul.dom.periode.PeriodeSuspensionDDTEAvecImputation;
import fr.unedic.cali.calcul.dom.periode.PeriodeSuspensionDDTESansImputation;
import fr.unedic.cali.calcul.dom.periode.PeriodeSuspensionTitreConservatoire;
import fr.unedic.cali.calcul.dom.periode.PeriodeTravail;
import fr.unedic.cali.calcul.dom.periode.PeriodeTravailJustifiee;
import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeRessource;
import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeSuspensionIslr;
import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeValiditeAccordACCREDDTE;
import fr.unedic.cali.calcul.outilsfonctionnels.GestionForcage;
import fr.unedic.cali.calcul.outilsfonctionnels.OutilGestionPoursuite;
import fr.unedic.cali.calcul.outilsfonctionnels.dom.PeriodeAnalyse;
import fr.unedic.cali.calcul.outilsfonctionnels.dom.PeriodeAnalyseSpec;
import fr.unedic.cali.calcul.pbjc.FacadePBJCProduitFactory;
import fr.unedic.cali.calcul.pbjc.FacadePBJCProduitSpec;
import fr.unedic.cali.calcul.pbjc.dom.IndividuPbjcNcp;
import fr.unedic.cali.calcul.pbjc.dom.PbjcNcp;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DossierExamenSpec;
import fr.unedic.cali.dom.DureeIndemnisationAbstraite;
import fr.unedic.cali.dom.DureeProlongationAbstraite;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.MontantBaseSpec;
import fr.unedic.cali.dom.affectation.GammeAsu;
import fr.unedic.cali.dom.affectation.GammeFor;
import fr.unedic.cali.dom.affectation.GammeInr;
import fr.unedic.cali.dom.affectation.GammeRbf;
import fr.unedic.cali.dom.affectation.GammeSol;
import fr.unedic.cali.dom.affectation.GammeSpec;
import fr.unedic.cali.dom.affectation.LigneSpec;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.cali.dom.pnds.PeriodeNonDeclareeSanction;
import fr.unedic.cali.liquidation.pnds.StrategieDeterminationPNDSSpec;
import fr.unedic.cali.liquidation.pnds.outilsfonctionnels.FabriqueStrategieDeterminationPNDS;
import fr.unedic.cali.outilsfonctionnels.GestionnaireErreur;
import fr.unedic.cali.outilsfonctionnels.OutilDemande;
import fr.unedic.cali.outilsfonctionnels.OutillagePEC;
import fr.unedic.cali.outilsfonctionnels.strategies.CritereStrategie;
import fr.unedic.cali.parcours.ContexteParcoursCalcul;
import fr.unedic.util.Mathematiques;
import fr.unedic.util.Quantite;
import fr.unedic.util.Unite;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.DureeCalendaire;
import fr.unedic.util.temps.FiltreChevauchePeriode;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.ObjetChronoPeriode;
import fr.unedic.util.temps.Periode;
import fr.unedic.util.temps.Temporel;
import fr.unedic.util.temps.UniteDuree;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

public final class GenerateurPBJCs
{
  private static List<String> listeNoPbjcs = new ArrayList();
  private static final int ZERO = 0;
  static final BigDecimal QUARANTE = new BigDecimal("40.00");
  
  static
  {
    listeNoPbjcs.add("RBF_FPO04_01");
    listeNoPbjcs.add("RBF_FPO04_02");
    listeNoPbjcs.add("INR_PFM01_01");
    listeNoPbjcs.add("INR_RCE04_01");
    listeNoPbjcs.add("DEC_CGE01_01");
    listeNoPbjcs.add("RBF_AGE08_01");
    listeNoPbjcs.add("RBF_MOB07_01");
    listeNoPbjcs.add("RBF_MOB07_01_DE");
    listeNoPbjcs.add("RBF_MOB07_01_TR");
    listeNoPbjcs.add("RBF_MOB07_01_HE");
    listeNoPbjcs.add("RBF_MOB07_01_RE");
    listeNoPbjcs.add("RBF_AIDES_01");
    listeNoPbjcs.add("FOR_CSP05_01");
    listeNoPbjcs.add("INR_PAR09_01");
    listeNoPbjcs.add("SOL_AER05_04");
  }
  
  public static ChronologiePeriodes creerChronologiePBJCs(List listeAttributions, Map mapCalendrier, Damj dateDebutGeneration, Damj dateBlocageActualisation, String libelleBlocageActualisation, IndividuSpec individu)
    throws ApplicativeException
  {
    ChronologiePeriodes chronoPBJCs = null;
    Iterator iterator = null;
    List listeChronologiePBJCs = new LinkedList();
    
    boolean estFusionnable = false;
    int nbAttributionPostDja = 0;
    Damj premierJourMoisSuivantDja = null;
    ChronologiePeriodes listePeriodes = new ChronologiePeriodes();
    Collection listePeriodesFiltrees = new ArrayList();
    ChronologiePeriodes chronoPBJCsFusionnees = null;
    Collection listeEvtChgtParametres = null;
    FiltreTemporel filtre = null;
    if (individu.getDernierJourAtteste() != null) {
      premierJourMoisSuivantDja = individu.getDernierJourAtteste().getDebutMoisSuivant();
    }
    if (premierJourMoisSuivantDja != null)
    {
      Iterator demandes = individu.getDemandes().iterator();
      while (demandes.hasNext())
      {
        DemandeSpec d = (DemandeSpec)demandes.next();
        if (!OutilDemande.estUneDemandeFinDroit(d)) {
          if ((!d.estEnReExamen()) && (d.getDateFinAbonnement().estApresOuCoincideAvec(premierJourMoisSuivantDja)))
          {
            nbAttributionPostDja++;
          }
          else
          {
            Iterator iterateurDossiersExamen = d.getListeDossiersExamen().iterator();
            while (iterateurDossiersExamen.hasNext())
            {
              DossierExamenSpec dossierExamenSpec = (DossierExamenSpec)iterateurDossiersExamen.next();
              if ((dossierExamenSpec instanceof AttributionSpec))
              {
                Damj dateAttribution = ((AttributionSpec)dossierExamenSpec).getDateAttribution();
                if ((dateAttribution.estApresOuCoincideAvec(premierJourMoisSuivantDja)) && (d.getDateFinAbonnement().estAvant(premierJourMoisSuivantDja))) {
                  nbAttributionPostDja++;
                }
              }
            }
          }
        }
      }
    }
    iterator = listeAttributions.iterator();
    while (iterator.hasNext())
    {
      AttributionSpec attribution = (AttributionSpec)iterator.next();
      
      ChronologiePeriodes chronoPeriodes = null;
      if (controlerAttributionProduit(attribution))
      {
        FacadePBJCProduitSpec facadePBJCProduit = creerFacadesPBJCProduit(attribution);
        if (mapCalendrier.containsKey(attribution))
        {
          CalendrierExecutionCalculSpec calendrierExecutionCalcul = (CalendrierExecutionCalculSpec)mapCalendrier.get(attribution);
          if ((calendrierExecutionCalcul instanceof CalendrierExecutionCalculPeriodique))
          {
            chronoPeriodes = creerChronologiePBJCsMonoProduit(attribution, (CalendrierExecutionCalculPeriodique)calendrierExecutionCalcul, dateDebutGeneration, dateBlocageActualisation, libelleBlocageActualisation);
            
            Chronologie chronoUT = ((CalendrierExecutionCalculPeriodique)calendrierExecutionCalcul).getChronologieUnitesTraitements();
            facadePBJCProduit.traiterPBJCsAPosteriori(chronoPeriodes, attribution, chronoUT);
            listeChronologiePBJCs.add(chronoPeriodes);
            if ((premierJourMoisSuivantDja != null) && (premierJourMoisSuivantDja.estContenueDans(new Periode(calendrierExecutionCalcul.getPremierJourIndemnisable(), calendrierExecutionCalcul.getDernierJourIndemnisable())))) {
              nbAttributionPostDja++;
            }
            if ((nbAttributionPostDja == 1) && (premierJourMoisSuivantDja != null) && (premierJourMoisSuivantDja.estAvantOuCoincideAvec(calendrierExecutionCalcul.getDernierJourIndemnisable())))
            {
              listePeriodes.ajouter(OutillagePeriodes.recuperationDeToutesLesDesPeriodes(individu, attribution, calendrierExecutionCalcul.getDernierJourIndemnisable()));
              
              filtre = new FiltreChevauchePeriode(new Periode(premierJourMoisSuivantDja, calendrierExecutionCalcul.getDernierJourIndemnisable()));
              
              listeEvtChgtParametres = facadePBJCProduit.getEvtsChangementParametre(premierJourMoisSuivantDja, calendrierExecutionCalcul.getDernierJourIndemnisable(), attribution);
              if ((listeEvtChgtParametres != null) && (listeEvtChgtParametres.size() > 0)) {
                listePeriodesFiltrees.add(listeEvtChgtParametres);
              }
              if (!listePeriodes.copier(filtre).estVide()) {
                listePeriodesFiltrees.add(listePeriodes.copier(filtre));
              }
            }
          }
        }
        else if (controlerAttributionProduit(attribution))
        {
          listeChronologiePBJCs.add(creerChronologiePBJCsMonoProduitAvant(creerFacadesPBJCProduit(attribution), attribution, dateDebutGeneration, dateBlocageActualisation, libelleBlocageActualisation));
        }
      }
    }
    chronoPBJCs = creerChronologiePBJCsMultiProduit(listeChronologiePBJCs);
    if ((premierJourMoisSuivantDja != null) && (nbAttributionPostDja <= 1) && ((listePeriodesFiltrees == null) || (listePeriodesFiltrees.size() == 0))) {
      estFusionnable = true;
    }
    if (premierJourMoisSuivantDja != null) {
      chronoPBJCsFusionnees = fusionPbjcs(chronoPBJCs, premierJourMoisSuivantDja);
    }
    if ((chronoPBJCsFusionnees != null) && 
      (estFusionnable)) {
      chronoPBJCs = chronoPBJCsFusionnees;
    }
    if (!chronoPBJCs.estVide()) {
      determinationPNDS(individu, chronoPBJCs.premierElement().getDateDebut().getDebutMois(), chronoPBJCs.dernierElement().getDateFin().getFinMois(), chronoPBJCs, dateDebutGeneration);
    }
    iterator = mapCalendrier.keySet().iterator();
    while (iterator.hasNext())
    {
      AttributionSpec attribution = (AttributionSpec)iterator.next();
      CalendrierExecutionCalculSpec calendrierExecutionCalcul = (CalendrierExecutionCalculSpec)mapCalendrier.get(attribution);
      if ((calendrierExecutionCalcul instanceof CalendrierExecutionCalculPeriodique)) {
        positionnerFinDeProduit(chronoPBJCs, attribution, (CalendrierExecutionCalculPeriodique)calendrierExecutionCalcul, dateDebutGeneration, individu);
      }
    }
    return chronoPBJCs;
  }
  
  private static ChronologiePeriodes creerChronologiePBJCsMonoProduit(AttributionSpec attribution, CalendrierExecutionCalculPeriodique calendrier, Damj dateDebutGeneration, Damj dateBlocageActualisation, String libelleBlocageActualisation)
    throws ApplicativeException
  {
    ChronologiePeriodes chronoARetourner = null;
    ChronologiePeriodes unitesTraitement = null;
    
    chronoARetourner = new ChronologiePeriodes();
    if (!controlerAttributionProduit(attribution)) {
      return chronoARetourner;
    }
    unitesTraitement = (ChronologiePeriodes)calendrier.getChronologieUnitesTraitements();
    if (unitesTraitement == null) {
      throw new CoucheLogiqueException("HG_PR_CALI_L_PBJC_UNITES_TRAITEMENT_ABSENTE", "Chronologie des Unités de Traitement vide lors de la création des PBJCs pour le produit", null);
    }
    FacadePBJCProduitSpec facadePBJCProduit = creerFacadesPBJCProduit(attribution);
    if (!facadePBJCProduit.controlerExecutionPBJCs(attribution)) {
      return chronoARetourner;
    }
    if (!calendrier.getChronologieUnitesTraitements().estVide())
    {
      if (dateDebutGeneration.getDebutMois().estAvant(calendrier.getPremierJourIndemnisable())) {
        chronoARetourner.ajouter(creerChronologiePBJCsMonoProduitAvant(facadePBJCProduit, attribution, dateDebutGeneration, dateBlocageActualisation, libelleBlocageActualisation));
      }
    }
    else {
      chronoARetourner.ajouter(creerChronologiePBJCsMonoProduitAvant(facadePBJCProduit, attribution, dateDebutGeneration, dateBlocageActualisation, libelleBlocageActualisation));
    }
    ChronologiePeriodes chronoMonoProduitPendant = creerChronologiePBJCsMonoProduitPendant(facadePBJCProduit, attribution, calendrier, dateDebutGeneration, dateBlocageActualisation, libelleBlocageActualisation);
    
    chronoARetourner.ajouter(chronoMonoProduitPendant);
    
    return chronoARetourner;
  }
  
  private static void determinationPNDS(IndividuSpec individu, Damj dateDebut, Damj dateFin, ChronologiePeriodes pbjcs, Damj dateDebutGeneration)
    throws CoucheLogiqueException
  {
    Damj start = Damj.max(dateDebutGeneration, dateDebut);
    if (start.estApresOuCoincideAvec(dateFin)) {
      return;
    }
    CritereStrategie critere = new CritereStrategie();
    critere.setDatePivot(Damj.FIN_DES_TEMPS);
    StrategieDeterminationPNDSSpec strategie = FabriqueStrategieDeterminationPNDS.determinerStrategieDeterminationPNDS(critere);
    
    strategie.determinationPNDSPourIndividuSurPeriode(individu, dateDebut, dateFin, OutillagePeriodes.recupererPeriodesGaecNonMapper(individu, start, dateFin), true);
    
    valoriserPNDS(individu.getListePNDSIndividu(), pbjcs);
  }
  
  protected static void valoriserPNDS(Map<PeriodeGaecSpec, PeriodeNonDeclareeSanction> pndss, ChronologiePeriodes pbjcs)
  {
    PbjcNcp pbjc = null;
    PeriodeNonDeclareeSanction pnds = null;
    Temporel temporel = null;
    if ((pbjcs != null) && (!pbjcs.estVide()) && (pndss != null) && (!pndss.isEmpty()))
    {
      Iterator<PbjcNcp> itePbjc = pbjcs.iterer();
      while (itePbjc.hasNext())
      {
        pbjc = (PbjcNcp)itePbjc.next();
        Iterator<PeriodeNonDeclareeSanction> itePnds = pndss.values().iterator();
        while (itePnds.hasNext())
        {
          pnds = (PeriodeNonDeclareeSanction)itePnds.next();
          Iterator<Temporel> iteTemporel = pnds.getChronoPeriodePNDS().iterer();
          while (iteTemporel.hasNext())
          {
            temporel = (Temporel)iteTemporel.next();
            if (pbjc.chevauche(new Periode(temporel.getDateDebut().getDebutMois(), temporel.getDateFin().getFinMois()))) {
              pbjc.setPresencePnds(true);
            }
          }
        }
      }
    }
  }
  
  private static ChronologiePeriodes creerChronologiePBJCsMonoProduitAvant(FacadePBJCProduitSpec facadePBJCProduit, AttributionSpec attribution, Damj dateGeneration, Damj dateBlocageActualisation, String libelleBlocageActualisation)
    throws ApplicativeException
  {
    ChronologiePeriodes chronoARetourner = null;
    if ((!facadePBJCProduit.controlerExecutionPBJCs(attribution)) || ((attribution.getPjiEffectif() != null) && (attribution.getPjiEffectif().estAvantOuCoincideAvec(attribution.getDateAttribution())))) {
      return new ChronologiePeriodes();
    }
    chronoARetourner = facadePBJCProduit.creerChronologiePBJCsAvant(attribution, dateGeneration, dateBlocageActualisation, libelleBlocageActualisation);
    
    return chronoARetourner;
  }
  
  private static ChronologiePeriodes creerChronologiePBJCsMonoProduitPendant(FacadePBJCProduitSpec facadePBJCProduit, AttributionSpec attribution, CalendrierExecutionCalculPeriodique calendrier, Damj dateDebutGeneration, Damj dateBlocageActualisation, String libelleBlocageActualisation)
    throws CoucheLogiqueException
  {
    ChronologiePeriodes chronoARetourner = new ChronologiePeriodes();
    ChronologiePeriodes chronoPBJCsSurUt = null;
    ChronologiePeriodes unitesTraitement = null;
    UniteTraitement ut = null;
    String naturePBJCParDefaut = null;
    
    unitesTraitement = (ChronologiePeriodes)calendrier.getChronologieUnitesTraitements();
    
    ListIterator itUnitesTraitement = unitesTraitement.iterer();
    while (itUnitesTraitement.hasNext())
    {
      ut = (UniteTraitement)itUnitesTraitement.next();
      if ((ut.getDateFin().estApresOuCoincideAvec(dateDebutGeneration)) && (!ut.getDateDebut().estApres(calendrier.getDernierJourIndemnisable())) && 
      
        (facadePBJCProduit.creerPBJCsurUT(attribution, ut)))
      {
        chronoPBJCsSurUt = new ChronologiePeriodes();
        
        naturePBJCParDefaut = determinerNaturePBJCsSurUt(ut);
        
        chronoPBJCsSurUt.ajouter(traiterPeriodesSuspensives(facadePBJCProduit, attribution, ut, naturePBJCParDefaut));
        chronoPBJCsSurUt.ajouter(traiterPeriodesSegmentantes(facadePBJCProduit, attribution, ut, naturePBJCParDefaut));
        
        chronoPBJCsSurUt.ajouter(GenerateurPBJCsNonIndemnisable.traiterPeriodesNonIndemnisable(facadePBJCProduit, attribution, ut, naturePBJCParDefaut));
        
        chronoPBJCsSurUt.ajouter(traiterSommes(facadePBJCProduit, attribution, ut, naturePBJCParDefaut, dateBlocageActualisation, libelleBlocageActualisation));
        if (chronoPBJCsSurUt.contientChevauchementElements()) {
          if ((ut.getCreditDecalagePNDS() != null) && (ut.getCreditDecalagePNDS().getValeurEntiere() != 0)) {
            chronoPBJCsSurUt = decouperEnPBJCsDisjointesAvecPNDs(chronoPBJCsSurUt, false);
          } else {
            chronoPBJCsSurUt = decouperEnPBJCsDisjointes(chronoPBJCsSurUt, false, false);
          }
        }
        chronoPBJCsSurUt = facadePBJCProduit.supprimerPBJCsANePasPrendreEnCompte(chronoPBJCsSurUt);
        
        int dureeReliquatMax = facadePBJCProduit.retournerReliquatDureeMax(ut, chronoARetourner, attribution);
        int cumulJoursImpute = retournerCumulJoursImputes(chronoARetourner, facadePBJCProduit, attribution, dureeReliquatMax, ut);
        if (ut.isNeutralisee()) {
          positionnerQuantitesSurUtNeutralisee(facadePBJCProduit, chronoPBJCsSurUt, ut, dureeReliquatMax, cumulJoursImpute);
        } else {
          positionnerQuantites(facadePBJCProduit, attribution, chronoPBJCsSurUt, ut, dureeReliquatMax, cumulJoursImpute);
        }
        chronoARetourner.ajouter(chronoPBJCsSurUt);
      }
    }
    return chronoARetourner;
  }
  
  private static String determinerNaturePBJCsSurUt(UniteTraitement ut)
  {
    QualificationPeriodes qualificationPeriodes = null;
    ChronologiePeriodes periodesDecalantes = null;
    String natureARetourner = null;
    
    natureARetourner = "CA";
    if (ut.getStatut() == 6)
    {
      natureARetourner = "AB";
    }
    else
    {
      qualificationPeriodes = ut.getQualificationPeriodes();
      periodesDecalantes = qualificationPeriodes.getPeriodesDecalantes();
      if (!periodesDecalantes.estVide())
      {
        ListIterator itPeriodesDecalantes = periodesDecalantes.iterer();
        while (itPeriodesDecalantes.hasNext()) {
          if ((itPeriodesDecalantes.next() instanceof PeriodeTravail)) {
            natureARetourner = "CT";
          }
        }
      }
    }
    return natureARetourner;
  }
  
  private static ChronologiePeriodes traiterPeriodesSuspensives(FacadePBJCProduitSpec facadePBJCProduit, AttributionSpec attribution, UniteTraitement ut, String naturePBJCParDefaut)
    throws CoucheLogiqueException
  {
    Damj pjeNcp = null;
    ChronologiePeriodes chronologieARetourner = null;
    chronologieARetourner = null;
    QualificationPeriodes qualificationPeriodes = null;
    ChronologiePeriodes periodesSuspensives = null;
    ObjetChronoPeriode periode = null;
    PbjcNcp pbjcNcp = null;
    Damj dateFinDeProduit = null;
    if ((ut.getArretProduitAvecRaison() != null) && (ut.getArretProduitAvecRaison().isProduitAArreter())) {
      dateFinDeProduit = ut.getArretProduitAvecRaison().recupereLendemainDateArret().veille();
    }
    chronologieARetourner = new ChronologiePeriodes();
    
    qualificationPeriodes = ut.getQualificationPeriodes();
    periodesSuspensives = qualificationPeriodes.getPeriodesSuspensives();
    periodesSuspensives = facadePBJCProduit.traitementPeriodesSuspensives(periodesSuspensives, ut);
    ListIterator it = periodesSuspensives.iterer();
    while (it.hasNext())
    {
      periode = (ObjetChronoPeriode)it.next();
      if ((dateFinDeProduit == null) || (!dateFinDeProduit.estAvant(periode.getDateDebut())))
      {
        pjeNcp = OutilGestionPoursuite.getInstance().recupererPremierJourExecutableNcp(attribution);
        if (periode.getDateDebut().estAvant(pjeNcp))
        {
          if (periode.getDateFin().estApresOuCoincideAvec(pjeNcp)) {
            periode.setDateDebut(pjeNcp);
          }
        }
        else if (periode.getDateFin().estApres(attribution.getCalendrierExecutionCalcul().getDernierJourIndemnisable()))
        {
          if (periode.getDateDebut().estAvantOuCoincideAvec(attribution.getCalendrierExecutionCalcul().getDernierJourIndemnisable())) {
            periode.setDateFin(attribution.getCalendrierExecutionCalcul().getDernierJourIndemnisable());
          }
        }
        else
        {
          pbjcNcp = creerPbjcNiveauPeriodeSuspensive(facadePBJCProduit, attribution, ut, naturePBJCParDefaut, periode);
          if ((periode instanceof PeriodeDisponibilite))
          {
            if (((PeriodeDisponibilite)periode).estSeulementSuspensif())
            {
              pbjcNcp.setQualificationPeriode(1);
              pbjcNcp.setNaturePBJC("CA");
            }
          }
          else if ((periode instanceof PeriodeClca))
          {
            pbjcNcp.setQualificationPeriode(1);
            pbjcNcp.ajouterComplementDeJustification("FU");
            if (pbjcNcp.getDateDebut().coincideAvec(((PeriodeClca)periode).getPeriodeInitiale().getDebut())) {
              pbjcNcp.ajouterComplementDeJustification("FS");
            }
            if (pbjcNcp.getDateFin().coincideAvec(((PeriodeClca)periode).getPeriodeInitiale().getFin())) {
              pbjcNcp.ajouterComplementDeJustification("FT");
            }
          }
          else if (((periode instanceof PeriodeEvenementPersonnel)) && (((PeriodeEvenementPersonnel)periode).getNature() == 31))
          {
            pbjcNcp.setQualificationPeriode(1);
            pbjcNcp.setNaturePBJC("CA");
            facadePBJCProduit.positionnerRangProlongation(pbjcNcp, ut, attribution);
          }
          else if (((periode instanceof PeriodeEvenementPersonnel)) && (((PeriodeEvenementPersonnel)periode).getNature() == 38))
          {
            pbjcNcp.setNaturePBJC("CA");
            pbjcNcp.ajouterComplementDeJustification("HD");
            facadePBJCProduit.positionnerRangProlongation(pbjcNcp, ut, attribution);
            
            pbjcNcp.setQualificationPeriode(1);
          }
          else if ((((periode instanceof PeriodeEvenementPersonnel)) && (((PeriodeEvenementPersonnel)periode).getNature() != 31) && (((PeriodeEvenementPersonnel)periode).getNature() != 38)) || ((periode instanceof DsmMaladie)) || ((periode instanceof DsmAbsenceAuPointage)))
          {
            pbjcNcp.setNaturePBJC("MA");
            pbjcNcp.ajouterComplementDeJustification("HD");
            facadePBJCProduit.positionnerRangProlongation(pbjcNcp, ut, attribution);
            
            pbjcNcp.setQualificationPeriode(1);
            facadePBJCProduit.positionnerInformationSuspension(pbjcNcp, ut);
            if ((attribution.getDemandeur() != null) && (attribution.getDemandeur().getIndividuPbjcNcp() != null) && (attribution.getDemandeur().getIndividuPbjcNcp().getDateAtteinteMoisNonPaye() != null) && (ut.getDateFin().coincideAvec(attribution.getDemandeur().getIndividuPbjcNcp().getDateAtteinteMoisNonPaye()))) {
              pbjcNcp.ajouterComplementDeJustification("SW");
            }
          }
          else if ((periode instanceof ObjetChronoPeriodeSuspensionIslr))
          {
            if (((ObjetChronoPeriodeSuspensionIslr)periode).getDuree() > 0)
            {
              pbjcNcp.setQualificationPeriode(1);
              if (((ObjetChronoPeriodeSuspensionIslr)periode).getPeriodeGlobaleSuspensionISLR() != null)
              {
                ObjetChronoPeriodeSuspensionIslr periodeGlobaleISLR = ((ObjetChronoPeriodeSuspensionIslr)periode).getPeriodeGlobaleSuspensionISLR();
                if (pbjcNcp.getDateDebut().coincideAvec(periodeGlobaleISLR.getDateDebut())) {
                  pbjcNcp.ajouterComplementDeJustification("EV");
                }
                if (pbjcNcp.getDateFin().coincideAvec(periodeGlobaleISLR.getDateFin())) {
                  pbjcNcp.ajouterComplementDeJustification("SV");
                }
              }
            }
          }
          else if ((periode instanceof PeriodeSuspensionDDTEAvecImputation))
          {
            facadePBJCProduit.positionnerComplementJustification(pbjcNcp, ut, attribution);
            
            pbjcNcp.supprimeComplementDeJustification("EU");
            facadePBJCProduit.positionnerInformationDecisionSanction(pbjcNcp, ut);
            pbjcNcp.setQualificationPeriode(4);
            if (((PeriodeSuspensionDDTEAvecImputation)periode).getCodeSanction().equals("SD")) {
              pbjcNcp.setCodeMotifNonPaiement("13");
            } else if (((PeriodeSuspensionDDTEAvecImputation)periode).getCodeSanction().equals("SE")) {
              pbjcNcp.setCodeMotifNonPaiement("11");
            }
            pbjcNcp.setEtatAdministratifOd("5");
          }
          else if (((periode instanceof PeriodeTravailJustifiee)) || (((periode instanceof DsmTravail)) && (!((DsmTravail)periode).isJustifiee())))
          {
            pbjcNcp.setQualificationPeriode(1);
          }
          else if ((periode instanceof PeriodeSuspensionDDTESansImputation))
          {
            facadePBJCProduit.positionnerComplementJustification(pbjcNcp, ut, attribution);
            facadePBJCProduit.positionnerInformationDecisionSanction(pbjcNcp, ut);
            pbjcNcp.setQualificationPeriode(1);
            if (((PeriodeSuspensionDDTESansImputation)periode).getCodeSanction().equals("SD")) {
              pbjcNcp.setCodeMotifNonPaiement("12");
            } else if (((PeriodeSuspensionDDTESansImputation)periode).getCodeSanction().equals("SE")) {
              pbjcNcp.setCodeMotifNonPaiement("10");
            }
            pbjcNcp.setEtatAdministratifOd("5");
          }
          else if ((periode instanceof PeriodeSuspensionTitreConservatoire))
          {
            facadePBJCProduit.positionnerComplementJustification(pbjcNcp, ut, attribution);
            facadePBJCProduit.positionnerInformationDecisionSanction(pbjcNcp, ut);
            pbjcNcp.setQualificationPeriode(1);
            pbjcNcp.setEtatAdministratifOd("5");
          }
          else if ((periode instanceof PeriodeInassiduiteFormation))
          {
            pbjcNcp.setNaturePBJC("AB");
            pbjcNcp.setQualificationPeriode(1);
            facadePBJCProduit.positionnerRangProlongation(pbjcNcp, ut, attribution);
          }
          else if ((periode instanceof PeriodeFormationNonIndemnisee))
          {
            pbjcNcp.setQualificationPeriode(1);
            if (((PeriodeFormationNonIndemnisee)periode).getPeriodeInitiale().getDebut().coincideAvec(pbjcNcp.getDateDebut())) {
              pbjcNcp.ajouterComplementDeJustification("HC");
            }
            if (((PeriodeFormationNonIndemnisee)periode).getPeriodeInitiale().getFin().coincideAvec(pbjcNcp.getDateFin())) {
              pbjcNcp.ajouterComplementDeJustification("HM");
            }
          }
          else if ((periode instanceof ObjetChronoPeriodeValiditeAccordACCREDDTE))
          {
            pbjcNcp.setQualificationPeriode(1);
          }
          else if (((periode instanceof DsmSuspensionContratTravail)) || ((periode instanceof DsmCongesNonPayes)) || ((periode instanceof ObjetPeriodeAAH)))
          {
            pbjcNcp.setQualificationPeriode(1);
          }
          else if (pbjcNcp.getQualificationPeriode() != 1)
          {
            facadePBJCProduit.positionnerPBJCASupprimer(pbjcNcp, periode);
          }
          chronologieARetourner.ajouter(pbjcNcp);
        }
      }
    }
    return chronologieARetourner;
  }
  
  private static ChronologiePeriodes traiterSommes(FacadePBJCProduitSpec facadePBJCProduit, AttributionSpec attribution, UniteTraitement ut, String naturePBJCParDefaut, Damj dateBlocageActualisation, String libelleBlocageActualisation)
    throws CoucheLogiqueException
  {
    ChronologiePeriodes chronologieARetourner = null;
    PbjcNcp pbjcNcp = null;
    PbjcNcp pbjcNcpPnd = null;
    int decalagePNDs = 0;
    Collection<Somme> listeDesSommes = null;
    Iterator<Somme> iterateurDesSommes = null;
    Somme somme = null;
    somme = null;
    
    chronologieARetourner = new ChronologiePeriodes();
    
    listeDesSommes = ut.getCollectionSommes();
    iterateurDesSommes = listeDesSommes.iterator();
    
    boolean contientPNDS = false;
    int reliquatIndemnisationCourant = ut.getDuree();
    if ((ut.getCreditDecalagePNDS() != null) && (ut.getCreditDecalagePNDS().getValeurEntiere() != 0))
    {
      contientPNDS = true;
      decalagePNDs = ut.getCreditDecalagePNDS().getValeurEntiere();
      if (ut.getConstituantsIndemnisationEnDebutUT().getDureeIndemnisation() != null) {
        reliquatIndemnisationCourant = ut.getConstituantsIndemnisationEnDebutUT().getDureeIndemnisation().getQuantiteCourante().getValeurEntiere();
      }
    }
    while (iterateurDesSommes.hasNext())
    {
      somme = (Somme)iterateurDesSommes.next();
      if (facadePBJCProduit.creerPBJCsurSomme(attribution, somme)) {
        if ((contientPNDS) && (decalagePNDs != 0))
        {
          Damj finPbjc = Damj.min(somme.getDateFin(), attribution.getCalendrierExecutionCalcul().getDernierJourIndemnisable());
          if ((somme.getDuree() > decalagePNDs) && (reliquatIndemnisationCourant > decalagePNDs))
          {
            pbjcNcpPnd = creerPbjcNiveauSomme(facadePBJCProduit, ut, attribution, naturePBJCParDefaut, somme.getDateDebut(), somme.getDateDebut().deplacerVersAvant(new DureeCalendaire(0, 0, decalagePNDs - 1)), somme, true);
            
            chronologieARetourner.ajouter(pbjcNcpPnd);
            
            pbjcNcp = creerPbjcNiveauSomme(facadePBJCProduit, ut, attribution, naturePBJCParDefaut, pbjcNcpPnd.getDateFin().lendemain(), finPbjc, somme, false);
            
            decalagePNDs = 0;
          }
          else
          {
            pbjcNcp = creerPbjcNiveauSomme(facadePBJCProduit, ut, attribution, naturePBJCParDefaut, somme.getDateDebut(), finPbjc, somme, true);
            
            decalagePNDs -= pbjcNcp.getDuree();
          }
          chronologieARetourner.ajouter(pbjcNcp);
        }
        else
        {
          pbjcNcp = creerPbjcNiveauSomme(facadePBJCProduit, ut, attribution, naturePBJCParDefaut, somme.getDateDebut(), somme.getDateFin(), somme, false);
          if ((dateBlocageActualisation != null) && (dateBlocageActualisation.veille().equals(somme.getDateFin())) && 
            (libelleBlocageActualisation != null) && (libelleBlocageActualisation.length() != 0)) {
            if (libelleBlocageActualisation.equals("blocage pour signal. pension d'inval. sur le DSM")) {
              pbjcNcp.ajouterComplementDeJustification("HH");
            } else if (libelleBlocageActualisation.equals("blocage pour signal. pension de retraite sur le DSM")) {
              pbjcNcp.ajouterComplementDeJustification("HI");
            } else if (libelleBlocageActualisation.equals("blocage pour arret recherche d'empl. sign. sur le DSM")) {
              pbjcNcp.ajouterComplementDeJustification("HJ");
            } else if (libelleBlocageActualisation.equals("blocage pour signal maternité sans date sur le DSM")) {
              pbjcNcp.ajouterComplementDeJustification("HK");
            } else if (libelleBlocageActualisation.equals("DSM en multi-déclaration recyclée")) {
              pbjcNcp.ajouterComplementDeJustification("HL");
            } else if ((libelleBlocageActualisation.equals("blocage pour motif divers")) || (libelleBlocageActualisation.equals("blocage pour changement de situation et D.E. en CRP")) || (libelleBlocageActualisation.equals("blocage pour changement de situation et D.E. en CTP")) || (libelleBlocageActualisation.equals("blocage pour D.E. en CTP ayant déclaré du TO"))) {
              pbjcNcp.ajouterComplementDeJustification("HN");
            } else if (libelleBlocageActualisation.equals("blocage ADE si actu sans déclaration TO")) {
              pbjcNcp.ajouterComplementDeJustification("HO");
            } else if (libelleBlocageActualisation.equals("blocage pour signal formation")) {
              pbjcNcp.ajouterComplementDeJustification("HM");
            } else if ((libelleBlocageActualisation.equals("Blocage suite info CNAV décès certifié")) || (libelleBlocageActualisation.equals("Blocage suite info CNAV décès présumé"))) {
              pbjcNcp.ajouterComplementDeJustification("HQ");
            } else if (libelleBlocageActualisation.equals("Blocage indemnisation pour DE en fin de formation")) {
              pbjcNcp.ajouterComplementDeJustification("HR");
            }
          }
          chronologieARetourner.ajouter(pbjcNcp);
        }
      }
    }
    return chronologieARetourner;
  }
  
  private static PbjcNcp creerPbjcNiveauSomme(FacadePBJCProduitSpec facadePBJCProduit, UniteTraitement ut, AttributionSpec attribution, String naturePBJCParDefaut, Damj dateDebut, Damj dateFin, Somme somme, boolean estPND)
    throws CoucheLogiqueException
  {
    PbjcNcp pbjcNcp = null;
    int statutAR = 0;
    
    pbjcNcp = creerPbjcNiveauPND(facadePBJCProduit, ut, attribution, naturePBJCParDefaut, dateDebut, dateFin, somme);
    if (estPND)
    {
      pbjcNcp.setCodeMotifNonPaiement("70");
      
      pbjcNcp.setCodeEtatPND("N");
      
      pbjcNcp.setMontantBaseJustificatifPND(somme.getMontant().getMontantBrut().getValeur());
      
      pbjcNcp.ajouterComplementDeJustification("AI");
      pbjcNcp.ajouterComplementDeJustification("AL");
    }
    else
    {
      facadePBJCProduit.positionnerInformationDecisionSanction(pbjcNcp, ut);
      if (ut.isNeutralisee())
      {
        statutAR = ut.getTypeNeutralisation();
        switch (statutAR)
        {
        case 0: 
          pbjcNcp.setCodeMotifNonPaiement("42");
          break;
        case 1: 
          pbjcNcp.setCodeMotifNonPaiement("41");
          break;
        case 3: 
          pbjcNcp.setCodeMotifNonPaiement("43");
          break;
        case 4: 
          pbjcNcp.setCodeMotifNonPaiement("40");
          break;
        case 9: 
          pbjcNcp.setCodeMotifNonPaiement("99");
          break;
        case 12: 
          pbjcNcp.setCodeMotifNonPaiement("50");
          break;
        case 2: 
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        case 10: 
        case 11: 
        default: 
          pbjcNcp.setCodeMotifNonPaiement("90");
          break;
        }
      }
      else if (pbjcNcp.getStatutPaiement() == 8)
      {
        pbjcNcp.setCodeMotifNonPaiement("57");
      }
      else if ((ut.getCreditDecalage() != null) && (ut.getCreditDecalage().getValeur() != null) && (ut.getCreditDecalage().getValeur().intValue() >= 0))
      {
        pbjcNcp.setCodeMotifNonPaiement("43");
      }
      else
      {
        pbjcNcp.setCodeMotifNonPaiement("99");
      }
      if (ut.getConstituantsCalculActiviteReduiteEnFinUT() != null) {
        facadePBJCProduit.positionnerActiviteReduite(pbjcNcp, ut.getConstituantsCalculActiviteReduiteEnFinUT());
      }
      facadePBJCProduit.positionnerNombreMoisEnPaiementProvisoire(pbjcNcp, ut);
      
      facadePBJCProduit.positionnerDonneesAvantageVieillesse(pbjcNcp, ut, attribution);
      if (pbjcNcp.getStatutPaiement() == 4)
      {
        if (ut.getRaisonStatut() == 1) {
          pbjcNcp.ajouterComplementDeJustification("GU");
        } else if (ut.getRaisonStatut() == 2) {
          pbjcNcp.ajouterComplementDeJustification("GV");
        } else if (ut.getRaisonStatut() == 3) {
          pbjcNcp.ajouterComplementDeJustification("GW");
        } else {
          pbjcNcp.ajouterComplementDeJustification("G9");
        }
        pbjcNcp.ajouterComplementDeJustification("HA");
      }
      else
      {
        if (!pbjcNcp.getNaturePBJC().equals("AB")) {
          facadePBJCProduit.ajouterGroupeMontantProduit(pbjcNcp, attribution, somme, ut);
        }
        if (pbjcNcp.getMontantPensionInvalidite() != null) {
          facadePBJCProduit.positionnerIndicateurInterruptionIndemnisationParPensionInvalidite(pbjcNcp);
        }
      }
      facadePBJCProduit.positionnerComplementJustification(pbjcNcp, ut, attribution);
    }
    return pbjcNcp;
  }
  
  private static PbjcNcp creerPbjcNiveauPND(FacadePBJCProduitSpec facadePBJCProduit, UniteTraitement ut, AttributionSpec attribution, String naturePBJCParDefaut, Damj dateDebut, Damj dateFin, Somme somme)
    throws CoucheLogiqueException
  {
    PbjcNcp pbjcNcp = null;
    QualificationPeriodes qualificationPeriodes = null;
    ChronologiePeriodes periodesSegmentantes = null;
    ObjetChronoPeriode periode = null;
    
    pbjcNcp = creerPbjcNiveauPeriodeSuspensive(facadePBJCProduit, attribution, ut, naturePBJCParDefaut, dateDebut, dateFin);
    
    pbjcNcp.setJustificationCalculMontant(somme.getMontant().getJustificationCalculMontant());
    
    facadePBJCProduit.positionnerMontantSalaireRevalorisePlafonne(pbjcNcp, attribution, ut.getConstituantsIndemnisationEnFinUT(), somme.getMontant());
    
    facadePBJCProduit.positionnerMontantSjc(pbjcNcp, attribution, ut.getConstituantsIndemnisationEnFinUT());
    
    facadePBJCProduit.positionnerCoefficientTempsPartiel(pbjcNcp, ut, attribution);
    
    facadePBJCProduit.positionnerRangProlongation(pbjcNcp, ut, attribution);
    
    pbjcNcp.setPeriodeRessourcesSuperieuresPlafond(facadePBJCProduit.retournerTopPeriodeRessourcesSuperieuresPlafond(somme));
    
    qualificationPeriodes = ut.getQualificationPeriodes();
    periodesSegmentantes = qualificationPeriodes.getPeriodesSegmentantes();
    ListIterator it = periodesSegmentantes.iterer();
    while (it.hasNext())
    {
      periode = (ObjetChronoPeriode)it.next();
      if ((periode instanceof ObjetChronoPeriodeRessource))
      {
        ObjetChronoPeriodeRessource objetChronoPeriodeRessource = (ObjetChronoPeriodeRessource)periode;
        if ((objetChronoPeriodeRessource.estNouvellesRessourcesMontantDifferent()) && (objetChronoPeriodeRessource.getDateEffet().estContenueDans(new Periode(pbjcNcp.getDateDebut(), pbjcNcp.getDateFin())))) {
          pbjcNcp.ajouterComplementDeJustification("DD");
        }
      }
    }
    return pbjcNcp;
  }
  
  private static PbjcNcp creerPbjcNiveauPeriodeSuspensive(FacadePBJCProduitSpec facadePBJCProduit, AttributionSpec attribution, UniteTraitement ut, String naturePBJCParDefaut, Damj dateDebut, Damj dateFin)
    throws CoucheLogiqueException
  {
    PbjcNcp pbjcNcp = null;
    ObjetChronoPeriodePriseEnCharge pec = null;
    
    pbjcNcp = new PbjcNcp(dateDebut, dateFin);
    if (!(attribution.getGamme() instanceof GammeRbf)) {
      pbjcNcp.setProduit(attribution.getProduitExecution().getNom());
    }
    pbjcNcp.setRegimeApplicable(facadePBJCProduit.retournerReglementApplicable(attribution));
    
    pbjcNcp.setStatutPaiement(ut.getStatut());
    
    pbjcNcp.setNaturePBJC(naturePBJCParDefaut);
    
    pbjcNcp.setPlafonnementFTHR(ut.isPlafonnee());
    
    facadePBJCProduit.positionnerReferencesOuvertureDroit(pbjcNcp, attribution);
    
    pbjcNcp.setRefBaseCalculMontantBrut(facadePBJCProduit.retournerReferenceBaseCalcul(attribution));
    
    facadePBJCProduit.positionnerRessources(pbjcNcp, attribution);
    
    facadePBJCProduit.positionnerPriseEnChargeAER(pbjcNcp, ut);
    
    facadePBJCProduit.positionnerEtatsReglementaireEtAdministratif(pbjcNcp);
    
    facadePBJCProduit.positionnerActiviteReduite(pbjcNcp, ut.getConstituantsCalculActiviteReduiteEnFinUT());
    
    pec = OutillagePeriodes.recupererPeriodePECContenant(attribution.getDemandeur(), dateDebut);
    if (pec != null)
    {
      pbjcNcp.setAleIndividu(pec.getAleIndividu());
      if (OutillagePEC.estPecAutreEtatMembreCoordination(pec)) {
        facadePBJCProduit.mapperPecSurPbjc(pbjcNcp, pec);
      }
    }
    facadePBJCProduit.positionnerInfoConventionGestion(pbjcNcp, attribution);
    if (naturePBJCParDefaut.equals("AB")) {
      pbjcNcp.ajouterComplementDeJustification("HD");
    }
    pbjcNcp.setTopPlafonnementDureeDroitParDate(facadePBJCProduit.retournerTopPlafonnementDureeDroitParDate());
    
    facadePBJCProduit.positionnerCoefficientTempsPartiel(pbjcNcp, ut, attribution);
    
    facadePBJCProduit.positionnerSituationParticuliere(pbjcNcp, attribution, ut);
    
    facadePBJCProduit.positionnerCategorieAttribution(pbjcNcp, attribution, ut);
    
    pbjcNcp.setNbJoursAREF(ut.getNbJoursFormationEnDebutDUT());
    
    return pbjcNcp;
  }
  
  private static PbjcNcp creerPbjcNiveauPeriodeSuspensive(FacadePBJCProduitSpec facadePBJCProduit, AttributionSpec attribution, UniteTraitement ut, String naturePBJCParDefaut, ObjetChronoPeriode periode)
    throws CoucheLogiqueException
  {
    PbjcNcp pbjcNcp = creerPbjcNiveauPeriodeSuspensive(facadePBJCProduit, attribution, ut, naturePBJCParDefaut, periode.getDateDebut(), periode.getDateFin());
    
    facadePBJCProduit.qualifierPbjcSuspensive(pbjcNcp, periode);
    
    return pbjcNcp;
  }
  
  private static void positionnerQuantites(FacadePBJCProduitSpec facadePBJCProduit, AttributionSpec attribution, ChronologiePeriodes chronoPBJCs, UniteTraitement ut, int dureeReliquatMax, int cumulJoursImputes)
    throws CoucheLogiqueException
  {
    int quantiteIndemnisable = 0;
    int quantiteIndemnisee = 0;
    int quantiteNonIndemnisee = 0;
    int quantiteImputeeNonIndemnisee = 0;
    int quantiteDecalage = 0;
    int quantiteReliquat = 0;
    int quantiteIndemniseeCumulee = 0;
    int quantiteAImputer = 0;
    int quantiteAIndemniser = 0;
    int quantiteDecalageDuree = 0;
    int quantiteADecaler = 0;
    int maxDureeReglementaire = 0;
    int reliquatDureeReglementaire = 0;
    int reliquatAREF = 0;
    int cumulAREFPlan = ut.getConstituantsIndemnisationEnDebutUT().getCumulTotalAllongementAREF();
    PbjcNcp pbjcNcp = null;
    if (ut.getConstituantsIndemnisationEnDebutUT().getDureeProlongation() != null) {
      reliquatAREF = ut.getConstituantsIndemnisationEnDebutUT().getDureeProlongation().getQuantiteCourante().getValeurEntiere();
    }
    if (ut.getCreditDecalage() != null) {
      quantiteDecalage = ut.getCreditDecalage().getValeurEntiere();
    }
    if (ut.getCreditDecalageDuree() != null)
    {
      quantiteDecalage += ut.getCreditDecalageDuree().getValeurEntiere();
      quantiteDecalageDuree = ut.getCreditDecalageDuree().getValeurEntiere();
    }
    if (ut.getCreditDecalageDureeEnFinUT() != null)
    {
      quantiteDecalage -= ut.getCreditDecalageDureeEnFinUT().getValeurEntiere();
      quantiteDecalageDuree -= ut.getCreditDecalageDureeEnFinUT().getValeurEntiere();
    }
    quantiteReliquat = dureeReliquatMax;
    
    quantiteIndemniseeCumulee = cumulJoursImputes;
    if (ut.getUniteParDefautQuantites().equals(UniteDuree.JOUR))
    {
      quantiteIndemnisable = ut.getQuantiteIndemnisable().getValeurEntiere();
      quantiteIndemnisee = ut.getQuantiteIndemnisee().getValeurEntiere();
      quantiteNonIndemnisee = ut.getQuantiteNonIndemnisee().getValeurEntiere() - quantiteDecalage;
      quantiteImputeeNonIndemnisee = ut.getQuantiteImputeeNonIndemnisee().getValeurEntiere();
    }
    else if (ut.getUniteParDefautQuantites().equals(UniteDuree.MOIS))
    {
      BigDecimal dureeUt = new BigDecimal(ut.getDuree());
      quantiteIndemnisable = ut.getQuantiteIndemnisable().getValeur().multiply(dureeUt).setScale(0, 0).intValue();
      quantiteIndemnisee = ut.getQuantiteIndemnisee().getValeur().multiply(dureeUt).setScale(0, 0).intValue();
      quantiteNonIndemnisee = ut.getQuantiteNonIndemnisee().getValeur().multiply(dureeUt).setScale(0, 0).intValue() - quantiteDecalage;
      
      quantiteImputeeNonIndemnisee = Mathematiques.arrondiASup(ut.getQuantiteImputeeNonIndemnisee().getValeur().multiply(dureeUt), 0).intValue();
    }
    maxDureeReglementaire = facadePBJCProduit.retournerMaxDureeReglementaireCourante(attribution);
    reliquatDureeReglementaire = facadePBJCProduit.retournerReliquatDureeReglementaireCourante(ut);
    
    ListIterator itChronoPBJCs = chronoPBJCs.iterer();
    PeriodeAnalyse anciennePa = null;
    while (itChronoPBJCs.hasNext())
    {
      pbjcNcp = (PbjcNcp)itChronoPBJCs.next();
      
      pbjcNcp.setReliquatDureeMax(quantiteReliquat);
      pbjcNcp.setCumulCourant(quantiteIndemniseeCumulee);
      pbjcNcp.setReliquatAllongementAREF(reliquatAREF);
      
      quantiteIndemnisable -= pbjcNcp.getDuree();
      if ((pbjcNcp.getQualificationPeriode() == 1) || (pbjcNcp.getQualificationPeriode() == 2))
      {
        quantiteNonIndemnisee -= pbjcNcp.getDuree();
      }
      else if (pbjcNcp.getQualificationPeriode() == 4)
      {
        pbjcNcp.setNbJoursImputes(pbjcNcp.getDuree());
      }
      else if (pbjcNcp.getQualificationPeriode() == 5)
      {
        quantiteNonIndemnisee -= pbjcNcp.getDuree();
        pbjcNcp.setNbJoursImputes(quantiteImputeeNonIndemnisee + pbjcNcp.getDuree());
      }
      else if (pbjcNcp.getQualificationPeriode() == 6)
      {
        pbjcNcp.setNbJoursImputes(quantiteImputeeNonIndemnisee);
      }
      else if ((!attribution.getProduit().getNomUnique().equals("ASU_SPE02_05")) && (!attribution.getProduit().getNomUnique().equals("ASU_SSP07_05")) && (!attribution.getProduit().getNomUnique().equals("ASU_SPE02_06")))
      {
        PeriodeAnalyse pa = null;
        boolean paTrouvee = false;
        Iterator<PeriodeAnalyseSpec> ite = ut.getListePeriodesAnalyse().iterer();
        while ((ite.hasNext()) && (!paTrouvee))
        {
          pa = (PeriodeAnalyse)ite.next();
          if (((new Periode(pbjcNcp.getDateDebut(), pbjcNcp.getDateFin()).estContenueDans(pa.getPeriode())) || ((pa.getPeriode().chevauche(new Periode(pbjcNcp.getDateDebut(), pbjcNcp.getDateFin()))) && (ut.isProduitATerminerApresUT()))) && (pa.getQuantiteDecalee() != null) && (estNouvellePa(pa, anciennePa)))
          {
            paTrouvee = true;
            anciennePa = pa;
          }
        }
        if (((quantiteDecalage == 0) || (quantiteDecalageDuree > 0)) && (!GestionForcage.appliquerForcageCreditDecalage(attribution.getDemande(), ut)) && (paTrouvee)) {
          quantiteDecalage += pa.getQuantiteDecalee().getValeurEntiere();
        }
        if ((ut.getQuantitePlafonnee() != null) && (attribution.getProduit().getLigne().getGamme().getNomUnique().equals("ASU")))
        {
          boolean paTrouveeAvecPlafonnement = false;
          Iterator<PeriodeAnalyseSpec> itePa = ut.getListePeriodesAnalyse().iterer();
          while ((itePa.hasNext()) && (!paTrouveeAvecPlafonnement))
          {
            pa = (PeriodeAnalyse)itePa.next();
            if ((new Periode(pbjcNcp.getDateDebut(), pbjcNcp.getDateFin()).estContenueDans(pa.getPeriode())) && (pa.getQuantitePlafonnee() != null) && (pa.getQuantitePlafonnee().getValeurEntiere() != 0))
            {
              paTrouveeAvecPlafonnement = true;
              quantiteDecalage += pa.getQuantitePlafonnee().getValeurEntiere();
            }
          }
        }
        if (quantiteDecalage > 0)
        {
          quantiteADecaler = Math.min(quantiteDecalage, pbjcNcp.getDuree());
          quantiteDecalage -= quantiteADecaler;
          if ((pbjcNcp.getCodeEtatPND() != null) && (pbjcNcp.getCodeEtatPND().equals("N"))) {
            quantiteADecaler = 0;
          }
          pbjcNcp.setNbJoursDecalage(quantiteADecaler);
        }
        if ((pbjcNcp.getDuree() >= pbjcNcp.getNbJoursDecalage() + pbjcNcp.getNbJoursImputes()) && (quantiteIndemnisee >= 0))
        {
          quantiteAIndemniser = Math.min(quantiteIndemnisee, pbjcNcp.getDuree() - pbjcNcp.getNbJoursDecalage());
          if ((pbjcNcp.getCodeEtatPND() != null) && (pbjcNcp.getCodeEtatPND().equals("N")))
          {
            pbjcNcp.setNbJoursImputes(pbjcNcp.getDuree());
          }
          else
          {
            quantiteIndemnisee -= quantiteAIndemniser;
            pbjcNcp.setNbJoursImputes(quantiteAIndemniser);
            if (estUnContexteDallongementAREF(ut, pbjcNcp)) {
              pbjcNcp.setNbJoursAllongementAREF(Math.min(quantiteAIndemniser, reliquatAREF));
            }
          }
          if ((quantiteAImputer < pbjcNcp.getDuree()) && (quantiteNonIndemnisee >= pbjcNcp.getDuree() - quantiteAIndemniser))
          {
            quantiteNonIndemnisee -= pbjcNcp.getDuree() - quantiteAIndemniser;
            quantiteNonIndemnisee = Math.max(0, quantiteNonIndemnisee);
          }
        }
      }
      facadePBJCProduit.miseAJourNombreJoursImputes(ut, pbjcNcp);
      if (!estUnContexteDallongementAREF(ut, pbjcNcp)) {
        quantiteReliquat = Math.max(0, quantiteReliquat - pbjcNcp.getNbJoursImputes());
      }
      ChronologiePeriodes listePeriodes = ut.getQualificationPeriodes().getPeriodesSegmentantes();
      listePeriodes.iterer();
      while (listePeriodes.encoreSuivant())
      {
        ObjetChronoPeriode periode = (ObjetChronoPeriode)listePeriodes.elementSuivant();
        if (((periode instanceof DebutActionFormation)) && (periode.getDateDebut().coincideAvec(pbjcNcp.getDateDebut()))) {
          cumulAREFPlan = 0;
        }
      }
      cumulAREFPlan += pbjcNcp.getNbJoursAllongementAREF();
      pbjcNcp.setCumulAllongementPlan(cumulAREFPlan);
      reliquatAREF -= pbjcNcp.getNbJoursAllongementAREF();
      quantiteIndemniseeCumulee += pbjcNcp.getNbJoursImputes();
      if (maxDureeReglementaire != 0) {
        if (reliquatDureeReglementaire != 0) {
          reliquatDureeReglementaire -= pbjcNcp.getNbJoursImputes();
        } else {
          reliquatDureeReglementaire = maxDureeReglementaire - pbjcNcp.getNbJoursImputes();
        }
      }
      pbjcNcp.setReliquatDureeReglementaire(reliquatDureeReglementaire);
    }
    if (ut.getArretProduitAvecRaison() != null)
    {
      quantiteAImputer = determinerQuantiteAImputerEnFinDIndemnisation(ut);
      quantiteIndemnisable -= quantiteAImputer;
      quantiteNonIndemnisee -= quantiteAImputer;
    }
    quantiteNonIndemnisee = Math.max(0, quantiteNonIndemnisee);
    
    controlerQuantites(quantiteDecalage, quantiteIndemnisable, quantiteIndemnisee, quantiteNonIndemnisee);
  }
  
  private static boolean estUnContexteDallongementAREF(UniteTraitement ut, PbjcNcp pbjc)
  {
    return (pbjc.getComplementTypeMontant1() == 1) && (ut.getConstituantsIndemnisationEnFinUT().getDureeProlongation() != null) && (ut.getConstituantsIndemnisationEnFinUT().getDureeProlongation().isContexteAllongementAref());
  }
  
  private static void positionnerQuantitesSurUtNeutralisee(FacadePBJCProduitSpec facadePBJCProduit, ChronologiePeriodes chronoPBJCs, UniteTraitement ut, int dureeReliquatMax, int cumulJoursImputes)
  {
    int quantiteImputeeNonIndemnisee = 0;
    int reliquatAREF = 0;
    int cumulAREFPlan = ut.getConstituantsIndemnisationEnDebutUT().getCumulTotalAllongementAREF();
    PbjcNcp pbjcNcp = null;
    if (ut.getConstituantsIndemnisationEnDebutUT().getDureeProlongation() != null) {
      reliquatAREF = ut.getConstituantsIndemnisationEnDebutUT().getDureeProlongation().getQuantiteCourante().getValeurEntiere();
    }
    int quantiteReliquat = dureeReliquatMax;
    
    int quantiteIndemniseeCumulee = cumulJoursImputes;
    
    ListIterator it = chronoPBJCs.iterer();
    
    int reliquatDureeReglementaire = facadePBJCProduit.retournerReliquatDureeReglementaireCourante(ut);
    if (ut.getUniteParDefautQuantites().equals(UniteDuree.JOUR))
    {
      quantiteImputeeNonIndemnisee = ut.getQuantiteImputeeNonIndemnisee().getValeurEntiere();
    }
    else if (ut.getUniteParDefautQuantites().equals(UniteDuree.MOIS))
    {
      BigDecimal dureeUt = new BigDecimal(ut.getDuree());
      quantiteImputeeNonIndemnisee = Mathematiques.arrondiASup(ut.getQuantiteImputeeNonIndemnisee().getValeur().multiply(dureeUt), 0).intValue();
    }
    while (it.hasNext())
    {
      pbjcNcp = (PbjcNcp)it.next();
      
      pbjcNcp.setReliquatDureeMax(quantiteReliquat);
      
      pbjcNcp.setCumulCourant(quantiteIndemniseeCumulee);
      
      pbjcNcp.setReliquatAllongementAREF(reliquatAREF);
      pbjcNcp.setCumulAllongementPlan(cumulAREFPlan);
      if ((pbjcNcp.getStatutPaiement() != 4) && (pbjcNcp.getStatutPaiement() != 6)) {
        pbjcNcp.setNbJoursDecalage(pbjcNcp.getDuree());
      }
      if ((pbjcNcp.getCodeEtatPND() != null) && (pbjcNcp.getCodeEtatPND().equals("N")))
      {
        pbjcNcp.setNbJoursImputes(pbjcNcp.getDuree());
        
        pbjcNcp.setNbJoursDecalage(0);
      }
      else if (pbjcNcp.getQualificationPeriode() == 4)
      {
        pbjcNcp.setNbJoursImputes(pbjcNcp.getDuree());
        pbjcNcp.setNbJoursDecalage(0);
      }
      else if (pbjcNcp.getQualificationPeriode() == 5)
      {
        pbjcNcp.setNbJoursImputes(pbjcNcp.getDuree());
      }
      else if (pbjcNcp.getQualificationPeriode() == 6)
      {
        pbjcNcp.setNbJoursImputes(quantiteImputeeNonIndemnisee);
        pbjcNcp.setNbJoursDecalage(0);
      }
      else
      {
        pbjcNcp.setNbJoursImputes(0);
      }
      quantiteIndemniseeCumulee += pbjcNcp.getNbJoursImputes();
      quantiteReliquat -= pbjcNcp.getNbJoursImputes();
      
      pbjcNcp.setReliquatDureeReglementaire(reliquatDureeReglementaire);
    }
  }
  
  private static ChronologiePeriodes creerChronologiePBJCsMultiProduit(List listeChronoPBJCs)
  {
    ChronologiePeriodes chronoPBJCsMultiProduits = null;
    Iterator iterateurChronos = null;
    
    chronoPBJCsMultiProduits = new ChronologiePeriodes();
    
    iterateurChronos = listeChronoPBJCs.iterator();
    while (iterateurChronos.hasNext()) {
      chronoPBJCsMultiProduits.ajouter((ChronologiePeriodes)iterateurChronos.next());
    }
    chronoPBJCsMultiProduits = decouperEnPBJCsDisjointes(chronoPBJCsMultiProduits, false, true);
    
    return chronoPBJCsMultiProduits;
  }
  
  private static void positionnerFinDeProduit(ChronologiePeriodes chronoPBJCs, AttributionSpec attribution, CalendrierExecutionCalculPeriodique calendrier, Damj dateDebutGeneration, IndividuSpec individu)
    throws CoucheLogiqueException
  {
    if (!controlerAttributionProduit(attribution)) {
      return;
    }
    FacadePBJCProduitSpec facadePBJCProduit = creerFacadesPBJCProduit(attribution);
    
    ChronologiePeriodes unitesTraitement = null;
    
    unitesTraitement = (ChronologiePeriodes)calendrier.getChronologieUnitesTraitements();
    if (!unitesTraitement.estVide())
    {
      UniteTraitement ut = (UniteTraitement)unitesTraitement.dernierElement();
      PbjcNcp pbjcNcp = null;
      if ((ut.getDateFin().estApresOuCoincideAvec(dateDebutGeneration)) && (ut.isProduitATerminerApresUT()) && (ut.getArretProduitAvecRaison() != null))
      {
        Damj dji = calendrier.getDernierJourIndemnisable();
        if ((chronoPBJCs == null) || (chronoPBJCs.estVide())) {
          chronoPBJCs = individu.getChronoPbjcs();
        }
        if ((chronoPBJCs != null) && (!chronoPBJCs.estVide()))
        {
          ListIterator itChronoPBJCs = chronoPBJCs.iterer();
          while ((itChronoPBJCs.hasNext()) && (pbjcNcp == null))
          {
            PbjcNcp pbjcNcpTemp = (PbjcNcp)itChronoPBJCs.next();
            if (pbjcNcpTemp.getDateFin().coincideAvec(dji)) {
              pbjcNcp = pbjcNcpTemp;
            }
          }
        }
        if (pbjcNcp != null) {
          facadePBJCProduit.positionnerJustificationFermetureDJI(pbjcNcp, attribution, ut);
        }
      }
    }
  }
  
  public static ChronologiePeriodes decouperEnPBJCsDisjointes(ChronologiePeriodes chronoPBJCs, boolean avant, boolean multiProduit)
  {
    ChronologiePeriodes chronoPBJCsARetourner = null;
    List datesDeRupture = null;
    Damj debutPeriodeA = null;
    Damj debutPeriodeB = null;
    ChronologiePeriodes chronoFiltree = null;
    PbjcNcp pbjcNcp = null;
    Iterator iterateurDatesDeRupture = null;
    
    chronoPBJCsARetourner = new ChronologiePeriodes();
    datesDeRupture = new ArrayList();
    
    chronoPBJCsARetourner.setOptionChevauchementInterdit();
    
    ListIterator itChronoPBJCs = chronoPBJCs.iterer();
    while (itChronoPBJCs.hasNext())
    {
      pbjcNcp = (PbjcNcp)itChronoPBJCs.next();
      datesDeRupture.add(pbjcNcp.getDateDebut());
      datesDeRupture.add(pbjcNcp.getDateFin().lendemain());
    }
    datesDeRupture = new ArrayList(new HashSet(datesDeRupture));
    
    Collections.sort(datesDeRupture);
    
    iterateurDatesDeRupture = datesDeRupture.iterator();
    while (iterateurDatesDeRupture.hasNext()) {
      if (debutPeriodeA == null)
      {
        debutPeriodeA = (Damj)iterateurDatesDeRupture.next();
      }
      else
      {
        debutPeriodeB = (Damj)iterateurDatesDeRupture.next();
        chronoFiltree = filtrerRognerPeriodes(chronoPBJCs, debutPeriodeA, debutPeriodeB.veille(), multiProduit);
        if (chronoFiltree.getTaille() == 1) {
          chronoPBJCsARetourner.ajouter(chronoFiltree);
        } else if (multiProduit)
        {
          if (!chronoFiltree.estVide()) {
            chronoPBJCsARetourner.ajouter(fusionnerPBJCsMultiProduits(chronoFiltree));
          }
        }
        else if (!avant)
        {
          if (!chronoFiltree.estVide()) {
            chronoPBJCsARetourner.ajouter(fusionnerPBJCsMonoProduit(chronoFiltree));
          }
        }
        else if ((chronoFiltree != null) && (!chronoFiltree.estVide())) {
          chronoPBJCsARetourner.ajouter(fusionnerPBJCsMonoProduitAvant(chronoFiltree));
        }
        debutPeriodeA = debutPeriodeB;
      }
    }
    return chronoPBJCsARetourner;
  }
  
  private static ChronologiePeriodes decouperEnPBJCsDisjointesAvecPNDs(ChronologiePeriodes chronoPBJCs, boolean multiProduit)
  {
    ChronologiePeriodes chronoPBJCsARetourner = null;
    ChronologiePeriodes chronoPBJCsTemp = null;
    int decalagePNDs = 0;
    List datesDeRupture = null;
    Damj debutPeriodeA = null;
    Damj debutPeriodeB = null;
    ChronologiePeriodes chronoFiltree = null;
    PbjcNcp pbjcNcp = null;
    PbjcNcp pbjcPnds = null;
    Iterator iterateurDatesDeRupture = null;
    
    chronoPBJCsTemp = new ChronologiePeriodes();
    datesDeRupture = new ArrayList();
    
    chronoPBJCsTemp.setOptionChevauchementInterdit();
    
    ListIterator itChronoPBJCs = chronoPBJCs.iterer();
    while (itChronoPBJCs.hasNext())
    {
      pbjcNcp = (PbjcNcp)itChronoPBJCs.next();
      if ((pbjcNcp.getCodeEtatPND() != null) && (pbjcNcp.getCodeEtatPND().equals("N")))
      {
        decalagePNDs += pbjcNcp.getDuree();
        pbjcPnds = pbjcNcp;
      }
      datesDeRupture.add(pbjcNcp.getDateDebut());
      datesDeRupture.add(pbjcNcp.getDateFin().lendemain());
    }
    datesDeRupture = new ArrayList(new HashSet(datesDeRupture));
    
    Collections.sort(datesDeRupture);
    
    iterateurDatesDeRupture = datesDeRupture.iterator();
    while (iterateurDatesDeRupture.hasNext()) {
      if (debutPeriodeA == null)
      {
        debutPeriodeA = (Damj)iterateurDatesDeRupture.next();
      }
      else
      {
        debutPeriodeB = (Damj)iterateurDatesDeRupture.next();
        chronoFiltree = filtrerRognerPeriodes(chronoPBJCs, debutPeriodeA, debutPeriodeB.veille(), multiProduit);
        if (chronoFiltree.getTaille() == 1) {
          chronoPBJCsTemp.ajouter(chronoFiltree);
        } else if (multiProduit)
        {
          if (!chronoFiltree.estVide()) {
            chronoPBJCsTemp.ajouter(fusionnerPBJCsMultiProduits(chronoFiltree));
          }
        }
        else {
          chronoPBJCsTemp.ajouter(fusionnerPBJCsMonoProduit(chronoFiltree));
        }
        debutPeriodeA = debutPeriodeB;
      }
    }
    chronoPBJCsARetourner = new ChronologiePeriodes();
    ListIterator itChronoPBJCsTemp = chronoPBJCsTemp.iterer();
    while (itChronoPBJCsTemp.hasNext())
    {
      pbjcNcp = (PbjcNcp)itChronoPBJCsTemp.next();
      if (decalagePNDs > 0)
      {
        if (pbjcNcp.getNaturePBJC().equals("CT"))
        {
          if (pbjcNcp.getQualificationPeriode() == 4)
          {
            chronoPBJCsARetourner.ajouter(pbjcNcp);
          }
          else if ((pbjcNcp.getCodeEtatPND() != null) && (pbjcNcp.getCodeEtatPND().equals("N")))
          {
            decalagePNDs -= pbjcNcp.getDuree();
            chronoPBJCsARetourner.ajouter(pbjcNcp);
          }
          else if ((decalagePNDs > 0) && (pbjcNcp.getDuree() <= decalagePNDs))
          {
            pbjcPnds.setDateDebutPbjcsTrans(pbjcNcp.getDateDebut());
            pbjcPnds.setDateFinPbjcsTrans(pbjcNcp.getDateFin());
            pbjcPnds.setNbJoursImputes(pbjcNcp.getDuree());
            pbjcNcp = pbjcPnds;
            chronoPBJCsARetourner.ajouter(pbjcNcp);
            decalagePNDs -= pbjcNcp.getDuree();
          }
          else
          {
            pbjcPnds.setDateDebutPbjcsTrans(pbjcNcp.getDateDebut());
            pbjcPnds.setDateFinPbjcsTrans(pbjcNcp.getDateDebut().deplacerVersAvant(new DureeCalendaire(0, 0, decalagePNDs - 1)));
            pbjcPnds.setNbJoursImputes(pbjcPnds.getDuree());
            
            chronoPBJCsARetourner.ajouter(pbjcPnds);
            decalagePNDs = 0;
            
            pbjcNcp.setDateDebutPbjcsTrans(pbjcPnds.getDateFin().lendemain());
            pbjcNcp.setNbJoursDecalage(Math.max(0, pbjcNcp.getNbJoursDecalage() - pbjcPnds.getDuree()));
            chronoPBJCsARetourner.ajouter(pbjcNcp);
          }
        }
        else {
          chronoPBJCsARetourner.ajouter(pbjcNcp);
        }
      }
      else {
        chronoPBJCsARetourner.ajouter(pbjcNcp);
      }
    }
    return chronoPBJCsARetourner;
  }
  
  private static PbjcNcp fusionnerPBJCsMonoProduit(ChronologiePeriodes chronoPBJCs)
  {
    PbjcNcp pbjcFusion = null;
    PbjcNcp pbjcIteration = null;
    PbjcNcp pbjcDelaiAttente = null;
    PbjcNcp pbjcAbsence = null;
    PbjcNcp pbjcMaladie = null;
    PbjcNcp pbjcASupprimer = null;
    PbjcNcp pbjcChomage = null;
    PbjcNcp pbjcSuspensionAvecImputation = null;
    
    ListIterator itChronoPBJCs = chronoPBJCs.iterer();
    while (itChronoPBJCs.hasNext())
    {
      pbjcIteration = (PbjcNcp)itChronoPBJCs.next();
      if (pbjcIteration.getNaturePBJC().equals("AB")) {
        pbjcAbsence = pbjcIteration;
      } else if ((("ASU_SPE02_05".equals(pbjcIteration.getProduit())) || ("ASU_SPE02_06".equals(pbjcIteration.getProduit()))) && (pbjcIteration.getEtatReglementaireOd() != null) && (pbjcIteration.getEtatReglementaireOd().equals("9"))) {
        pbjcDelaiAttente = pbjcIteration;
      } else if (pbjcIteration.getQualificationPeriode() == 1) {
        pbjcMaladie = pbjcIteration;
      } else if (pbjcIteration.getQualificationPeriode() == 4) {
        pbjcSuspensionAvecImputation = pbjcIteration;
      } else if (pbjcIteration.getQualificationPeriode() == 6) {
        pbjcSuspensionAvecImputation = pbjcIteration;
      } else if (pbjcIteration.getQualificationPeriode() == 5) {
        pbjcSuspensionAvecImputation = pbjcIteration;
      } else if (pbjcIteration.getQualificationPeriode() == 3) {
        pbjcASupprimer = pbjcIteration;
      } else if ((pbjcIteration.getNaturePBJC().equals("CA")) || (pbjcIteration.getNaturePBJC().equals("CT"))) {
        pbjcChomage = pbjcIteration;
      } else {
        throw new IllegalStateException("Erreur dans la fusion de PBJCs Mono Produit.");
      }
    }
    if (pbjcAbsence != null) {
      pbjcFusion = pbjcAbsence;
    } else if (pbjcDelaiAttente != null) {
      pbjcFusion = pbjcDelaiAttente;
    } else if (pbjcSuspensionAvecImputation != null) {
      pbjcFusion = pbjcSuspensionAvecImputation;
    } else if (pbjcMaladie != null) {
      pbjcFusion = pbjcMaladie;
    } else if (pbjcASupprimer != null) {
      pbjcFusion = pbjcASupprimer;
    } else {
      pbjcFusion = pbjcChomage;
    }
    return pbjcFusion;
  }
  
  private static PbjcNcp fusionnerPBJCsMonoProduitAvant(ChronologiePeriodes chronoPBJCs)
  {
    PbjcNcp pbjcFusion = null;
    PbjcNcp pbjcIteration = null;
    PbjcNcp pbjcSuspensive = null;
    PbjcNcp pbjcASupprimer = null;
    PbjcNcp pbjcChomageSansPMC = null;
    PbjcNcp pbjcChomageAvecPMC = null;
    PbjcNcp pbjcSuspensionAvecImputation = null;
    
    ListIterator itChronoPBJCs = chronoPBJCs.iterer();
    while (itChronoPBJCs.hasNext())
    {
      pbjcIteration = (PbjcNcp)itChronoPBJCs.next();
      if (pbjcIteration.getQualificationPeriode() == 1) {
        pbjcSuspensive = pbjcIteration;
      } else if (pbjcIteration.getQualificationPeriode() == 4) {
        pbjcSuspensionAvecImputation = pbjcIteration;
      } else if (pbjcIteration.getQualificationPeriode() == 3) {
        pbjcASupprimer = pbjcIteration;
      } else if ((pbjcIteration.getNaturePBJC().equals("CA")) || (pbjcIteration.getNaturePBJC().equals("CT")))
      {
        if (!pbjcIteration.getEtatReglementaireOd().equals("7")) {
          pbjcChomageSansPMC = pbjcIteration;
        } else {
          pbjcChomageAvecPMC = pbjcIteration;
        }
      }
      else {
        throw new IllegalStateException("Erreur dans la fusion de PBJCs Mono Produit.");
      }
    }
    if (pbjcSuspensionAvecImputation != null)
    {
      if (pbjcChomageSansPMC != null) {
        pbjcSuspensionAvecImputation.setEtatReglementaireOd(pbjcChomageSansPMC.getEtatReglementaireOd());
      } else if (pbjcChomageAvecPMC != null) {
        pbjcSuspensionAvecImputation.setEtatReglementaireOd(pbjcChomageAvecPMC.getEtatReglementaireOd());
      }
      pbjcFusion = pbjcSuspensionAvecImputation;
    }
    else if (pbjcSuspensive != null)
    {
      if (pbjcChomageSansPMC != null) {
        ajoutJustificatifFusion(pbjcSuspensive, pbjcChomageSansPMC);
      } else if (pbjcChomageAvecPMC != null) {
        ajoutJustificatifFusion(pbjcSuspensive, pbjcChomageAvecPMC);
      }
      pbjcFusion = pbjcSuspensive;
    }
    else if (pbjcASupprimer != null)
    {
      pbjcFusion = pbjcASupprimer;
    }
    else if (pbjcChomageSansPMC != null)
    {
      pbjcFusion = pbjcChomageSansPMC;
    }
    else
    {
      pbjcFusion = pbjcChomageAvecPMC;
    }
    return pbjcFusion;
  }
  
  private static void ajoutJustificatifFusion(PbjcNcp pbjcSuspensive, PbjcNcp pbjcChomage)
  {
    pbjcSuspensive.setEtatReglementaireOd(pbjcChomage.getEtatReglementaireOd());
    if (pbjcChomage.contientComplementDeJustification("MF")) {
      pbjcSuspensive.ajouterComplementDeJustification("MF");
    }
    if (pbjcChomage.contientComplementDeJustification("AF")) {
      pbjcSuspensive.ajouterComplementDeJustification("AF");
    }
  }
  
  private static PbjcNcp fusionnerPBJCsMultiProduits(ChronologiePeriodes chronoPBJCs)
  {
    PbjcNcp pbjcFusion = null;
    
    pbjcFusion = determinerPBJCMultiProduitsPrioritaireParNature(chronoPBJCs);
    if (pbjcFusion == null)
    {
      pbjcFusion = determinerPBJCMultiProduitPrioritaireParProduit(chronoPBJCs);
      if (pbjcFusion == null) {
        pbjcFusion = determinerPBJCMultiProduitPrioritaireParGamme(chronoPBJCs);
      }
      if (pbjcFusion == null) {
        pbjcFusion = (PbjcNcp)chronoPBJCs.premierElement();
      }
      chronoPBJCs.supprimer(pbjcFusion);
      
      fusionnerPBJCsMultiProduits(pbjcFusion, chronoPBJCs);
    }
    return pbjcFusion;
  }
  
  private static void fusionnerPBJCsMultiProduits(PbjcNcp pbjc, ChronologiePeriodes chronoPBJCs)
  {
    PbjcNcp pbjcIteration = null;
    
    boolean existeDejaCadt = existeDejaTypeMontant(pbjc, "CADT");
    
    ChronologiePeriodes pbjcsFTHR = new ChronologiePeriodes();
    
    ListIterator itChronoPBJC = chronoPBJCs.iterer();
    while (itChronoPBJC.hasNext())
    {
      pbjcIteration = (PbjcNcp)itChronoPBJC.next();
      if (GammeRbf.getInstance().getProduit(pbjcIteration.getCodeTypeMontant1()) != null) {
        pbjcsFTHR.ajouter(pbjcIteration);
      } else if (GammeRbf.getInstance().getProduit(pbjcIteration.getCodeTypeMontant2()) != null) {
        pbjcsFTHR.ajouter(pbjcIteration);
      } else if (GammeRbf.getInstance().getProduit(pbjcIteration.getCodeTypeMontant3()) != null) {
        pbjcsFTHR.ajouter(pbjcIteration);
      } else if (GammeRbf.getInstance().getProduit(pbjcIteration.getCodeTypeMontant4()) != null) {
        pbjcsFTHR.ajouter(pbjcIteration);
      } else if (GammeRbf.getInstance().getProduit(pbjcIteration.getCodeTypeMontant5()) != null) {
        pbjcsFTHR.ajouter(pbjcIteration);
      } else if (GammeRbf.getInstance().getProduit(pbjcIteration.getCodeTypeMontant6()) != null) {
        pbjcsFTHR.ajouter(pbjcIteration);
      } else if (GammeRbf.getInstance().getProduit(pbjcIteration.getCodeTypeMontant7()) != null) {
        pbjcsFTHR.ajouter(pbjcIteration);
      }
    }
    ListIterator itChronoPBJCs = chronoPBJCs.iterer();
    while (itChronoPBJCs.hasNext())
    {
      pbjcIteration = (PbjcNcp)itChronoPBJCs.next();
      if (pbjcIteration.isPlafonnementFTHR()) {
        pbjc.setPlafonnementFTHR(true);
      }
      if ((pbjcIteration.getCodeTypeMontant1() != null) && ((!pbjcIteration.getCodeTypeMontant1().equals("CADT")) || (!existeDejaCadt))) {
        pbjc.ajouterGroupeMontants(pbjcIteration.getCodeTypeMontant1(), pbjcIteration.getComplementTypeMontant1(), pbjcIteration.getAssiette1(), pbjcIteration.getBaseDeCalcul1(), pbjcIteration.getTaux1(), pbjcIteration.getResultatCalcul1(), pbjcIteration.getPositionExoneration1());
      }
      if ((pbjcIteration.getCodeTypeMontant2() != null) && ((!pbjcIteration.getCodeTypeMontant2().equals("CADT")) || (!existeDejaCadt))) {
        pbjc.ajouterGroupeMontants(pbjcIteration.getCodeTypeMontant2(), pbjcIteration.getComplementTypeMontant2(), pbjcIteration.getAssiette2(), pbjcIteration.getBaseDeCalcul2(), pbjcIteration.getTaux2(), pbjcIteration.getResultatCalcul2(), pbjcIteration.getPositionExoneration2());
      }
      if ((pbjcIteration.getCodeTypeMontant3() != null) && ((!pbjcIteration.getCodeTypeMontant3().equals("CADT")) || (!existeDejaCadt))) {
        pbjc.ajouterGroupeMontants(pbjcIteration.getCodeTypeMontant3(), pbjcIteration.getComplementTypeMontant3(), pbjcIteration.getAssiette3(), pbjcIteration.getBaseDeCalcul3(), pbjcIteration.getTaux3(), pbjcIteration.getResultatCalcul3(), pbjcIteration.getPositionExoneration3());
      }
      if ((pbjcIteration.getCodeTypeMontant4() != null) && ((!pbjcIteration.getCodeTypeMontant4().equals("CADT")) || (!existeDejaCadt))) {
        pbjc.ajouterGroupeMontants(pbjcIteration.getCodeTypeMontant4(), pbjcIteration.getComplementTypeMontant4(), pbjcIteration.getAssiette4(), pbjcIteration.getBaseDeCalcul4(), pbjcIteration.getTaux4(), pbjcIteration.getResultatCalcul4(), pbjcIteration.getPositionExoneration4());
      }
      if ((pbjcIteration.getCodeTypeMontant5() != null) && ((!pbjcIteration.getCodeTypeMontant5().equals("CADT")) || (!existeDejaCadt))) {
        pbjc.ajouterGroupeMontants(pbjcIteration.getCodeTypeMontant5(), pbjcIteration.getComplementTypeMontant5(), pbjcIteration.getAssiette5(), pbjcIteration.getBaseDeCalcul5(), pbjcIteration.getTaux5(), pbjcIteration.getResultatCalcul5(), pbjcIteration.getPositionExoneration5());
      }
      if ((pbjcIteration.getCodeTypeMontant6() != null) && ((!pbjcIteration.getCodeTypeMontant6().equals("CADT")) || (!existeDejaCadt))) {
        pbjc.ajouterGroupeMontants(pbjcIteration.getCodeTypeMontant6(), pbjcIteration.getComplementTypeMontant6(), pbjcIteration.getAssiette6(), pbjcIteration.getBaseDeCalcul6(), pbjcIteration.getTaux6(), pbjcIteration.getResultatCalcul6(), pbjcIteration.getPositionExoneration6());
      }
      if ((pbjcIteration.getCodeTypeMontant7() != null) && ((!pbjcIteration.getCodeTypeMontant7().equals("CADT")) || (!existeDejaCadt))) {
        pbjc.ajouterGroupeMontants(pbjcIteration.getCodeTypeMontant7(), pbjcIteration.getComplementTypeMontant7(), pbjcIteration.getAssiette7(), pbjcIteration.getBaseDeCalcul7(), pbjcIteration.getTaux7(), pbjcIteration.getResultatCalcul7(), pbjcIteration.getPositionExoneration7());
      }
      if (pbjcIteration.getComplementDeJustification0() != null) {
        pbjc.ajouterComplementDeJustification(pbjcIteration.getComplementDeJustification0());
      }
      if (pbjcIteration.getComplementDeJustification1() != null) {
        pbjc.ajouterComplementDeJustification(pbjcIteration.getComplementDeJustification1());
      }
      if (pbjcIteration.getComplementDeJustification2() != null) {
        pbjc.ajouterComplementDeJustification(pbjcIteration.getComplementDeJustification2());
      }
      if (pbjcIteration.getComplementDeJustification3() != null) {
        pbjc.ajouterComplementDeJustification(pbjcIteration.getComplementDeJustification3());
      }
      if (pbjcIteration.getComplementDeJustification4() != null) {
        pbjc.ajouterComplementDeJustification(pbjcIteration.getComplementDeJustification4());
      }
      if (pbjcIteration.getComplementDeJustification5() != null) {
        pbjc.ajouterComplementDeJustification(pbjcIteration.getComplementDeJustification5());
      }
      if (pbjcIteration.getComplementDeJustification6() != null) {
        pbjc.ajouterComplementDeJustification(pbjcIteration.getComplementDeJustification6());
      }
      if (pbjcIteration.getComplementDeJustification7() != null) {
        pbjc.ajouterComplementDeJustification(pbjcIteration.getComplementDeJustification7());
      }
      if (pbjcIteration.getComplementDeJustification8() != null) {
        pbjc.ajouterComplementDeJustification(pbjcIteration.getComplementDeJustification8());
      }
      if (pbjcIteration.getComplementDeJustification9() != null) {
        pbjc.ajouterComplementDeJustification(pbjcIteration.getComplementDeJustification9());
      }
      if (pbjcIteration.getTypePopulation1() != null) {
        pbjc.ajouterTypeSousTypePopulation(pbjcIteration.getTypePopulation1(), pbjcIteration.getSousTypePopulation1());
      }
      if (pbjcIteration.getTypePopulation2() != null) {
        pbjc.ajouterTypeSousTypePopulation(pbjcIteration.getTypePopulation2(), pbjcIteration.getSousTypePopulation2());
      }
      if (pbjcIteration.getTypePopulation3() != null) {
        pbjc.ajouterTypeSousTypePopulation(pbjcIteration.getTypePopulation3(), pbjcIteration.getSousTypePopulation3());
      }
      if (pbjcIteration.getTypePopulation4() != null) {
        pbjc.ajouterTypeSousTypePopulation(pbjcIteration.getTypePopulation4(), pbjcIteration.getSousTypePopulation4());
      }
      if (pbjcIteration.getTypePopulation5() != null) {
        pbjc.ajouterTypeSousTypePopulation(pbjcIteration.getTypePopulation5(), pbjcIteration.getSousTypePopulation5());
      }
      if ((pbjcIteration.getCategorie() != null) && (pbjc.getCategorie() == null)) {
        pbjc.setCategorie(pbjcIteration.getCategorie());
      }
      if (!pbjcsFTHR.estVide())
      {
        PbjcNcp pbjcFTHR = (PbjcNcp)pbjcsFTHR.premierElement();
        pbjc.setIdPlanFormation(pbjcFTHR.getIdPlanFormation());
        pbjc.setTypeDePlan(pbjcFTHR.getTypeDePlan());
        pbjc.setIdStageFormation(pbjcFTHR.getIdStageFormation());
        pbjc.setTypeMesurePourLEmploi(pbjcFTHR.getTypeMesurePourLEmploi());
      }
    }
  }
  
  private static PbjcNcp determinerPBJCMultiProduitsPrioritaireParNature(ChronologiePeriodes chronoPBJCs)
  {
    ChronologiePeriodes pbjcPrioritaires = new ChronologiePeriodes();
    PbjcNcp pbjcIteration = null;
    ChronologiePeriodes pbjcsFTHR = new ChronologiePeriodes();
    PbjcNcp pbjcFTHR = null;
    
    ListIterator itChronoPBJCs = chronoPBJCs.iterer();
    while (itChronoPBJCs.hasNext())
    {
      pbjcIteration = (PbjcNcp)itChronoPBJCs.next();
      if ("MA".equals(pbjcIteration.getNaturePBJC())) {
        pbjcPrioritaires.ajouter(pbjcIteration);
      } else if (GammeRbf.getInstance().getProduit(pbjcIteration.getCodeTypeMontant1()) != null) {
        pbjcsFTHR.ajouter(pbjcIteration);
      } else if (GammeRbf.getInstance().getProduit(pbjcIteration.getCodeTypeMontant2()) != null) {
        pbjcsFTHR.ajouter(pbjcIteration);
      } else if (GammeRbf.getInstance().getProduit(pbjcIteration.getCodeTypeMontant3()) != null) {
        pbjcsFTHR.ajouter(pbjcIteration);
      } else if (GammeRbf.getInstance().getProduit(pbjcIteration.getCodeTypeMontant4()) != null) {
        pbjcsFTHR.ajouter(pbjcIteration);
      } else if (GammeRbf.getInstance().getProduit(pbjcIteration.getCodeTypeMontant5()) != null) {
        pbjcsFTHR.ajouter(pbjcIteration);
      } else if (GammeRbf.getInstance().getProduit(pbjcIteration.getCodeTypeMontant6()) != null) {
        pbjcsFTHR.ajouter(pbjcIteration);
      } else if (GammeRbf.getInstance().getProduit(pbjcIteration.getCodeTypeMontant7()) != null) {
        pbjcsFTHR.ajouter(pbjcIteration);
      }
    }
    if ((!pbjcsFTHR.estVide()) && (!pbjcPrioritaires.estVide()))
    {
      ListIterator itPBJCprioritaires = pbjcPrioritaires.iterer();
      while (itPBJCprioritaires.hasNext())
      {
        pbjcIteration = (PbjcNcp)itPBJCprioritaires.next();
        ListIterator itPBJCsFTHR = pbjcsFTHR.iterer();
        while (itPBJCsFTHR.hasNext())
        {
          pbjcFTHR = (PbjcNcp)itPBJCsFTHR.next();
          
          boolean existeDejaCadt = existeDejaTypeMontant(pbjcIteration, "CADT");
          if ((pbjcFTHR.getCodeTypeMontant1() != null) && ((!pbjcFTHR.getCodeTypeMontant1().equals("CADT")) || (!existeDejaCadt))) {
            pbjcIteration.ajouterGroupeMontants(pbjcFTHR.getCodeTypeMontant1(), pbjcFTHR.getComplementTypeMontant1(), pbjcFTHR.getAssiette1(), pbjcFTHR.getBaseDeCalcul1(), pbjcFTHR.getTaux1(), pbjcFTHR.getResultatCalcul1(), pbjcFTHR.getPositionExoneration1());
          }
          if ((pbjcFTHR.getCodeTypeMontant2() != null) && ((!pbjcFTHR.getCodeTypeMontant2().equals("CADT")) || (!existeDejaCadt))) {
            pbjcIteration.ajouterGroupeMontants(pbjcFTHR.getCodeTypeMontant2(), pbjcFTHR.getComplementTypeMontant2(), pbjcFTHR.getAssiette2(), pbjcFTHR.getBaseDeCalcul2(), pbjcFTHR.getTaux2(), pbjcFTHR.getResultatCalcul2(), pbjcFTHR.getPositionExoneration2());
          }
          if ((pbjcFTHR.getCodeTypeMontant3() != null) && ((!pbjcFTHR.getCodeTypeMontant3().equals("CADT")) || (!existeDejaCadt))) {
            pbjcIteration.ajouterGroupeMontants(pbjcFTHR.getCodeTypeMontant3(), pbjcFTHR.getComplementTypeMontant3(), pbjcFTHR.getAssiette3(), pbjcFTHR.getBaseDeCalcul3(), pbjcFTHR.getTaux3(), pbjcFTHR.getResultatCalcul3(), pbjcFTHR.getPositionExoneration3());
          }
          if ((pbjcFTHR.getCodeTypeMontant4() != null) && ((!pbjcFTHR.getCodeTypeMontant4().equals("CADT")) || (!existeDejaCadt))) {
            pbjcIteration.ajouterGroupeMontants(pbjcFTHR.getCodeTypeMontant4(), pbjcFTHR.getComplementTypeMontant4(), pbjcFTHR.getAssiette4(), pbjcFTHR.getBaseDeCalcul4(), pbjcFTHR.getTaux4(), pbjcFTHR.getResultatCalcul4(), pbjcFTHR.getPositionExoneration4());
          }
          if ((pbjcFTHR.getCodeTypeMontant5() != null) && ((!pbjcFTHR.getCodeTypeMontant5().equals("CADT")) || (!existeDejaCadt))) {
            pbjcIteration.ajouterGroupeMontants(pbjcFTHR.getCodeTypeMontant5(), pbjcFTHR.getComplementTypeMontant5(), pbjcFTHR.getAssiette5(), pbjcFTHR.getBaseDeCalcul5(), pbjcFTHR.getTaux5(), pbjcFTHR.getResultatCalcul5(), pbjcFTHR.getPositionExoneration5());
          }
          if ((pbjcFTHR.getCodeTypeMontant6() != null) && ((!pbjcFTHR.getCodeTypeMontant6().equals("CADT")) || (!existeDejaCadt))) {
            pbjcIteration.ajouterGroupeMontants(pbjcFTHR.getCodeTypeMontant6(), pbjcFTHR.getComplementTypeMontant6(), pbjcFTHR.getAssiette6(), pbjcFTHR.getBaseDeCalcul6(), pbjcFTHR.getTaux6(), pbjcFTHR.getResultatCalcul6(), pbjcFTHR.getPositionExoneration6());
          }
          if ((pbjcFTHR.getCodeTypeMontant7() != null) && ((!pbjcFTHR.getCodeTypeMontant7().equals("CADT")) || (!existeDejaCadt))) {
            pbjcIteration.ajouterGroupeMontants(pbjcFTHR.getCodeTypeMontant7(), pbjcFTHR.getComplementTypeMontant7(), pbjcFTHR.getAssiette7(), pbjcFTHR.getBaseDeCalcul7(), pbjcFTHR.getTaux7(), pbjcFTHR.getResultatCalcul7(), pbjcFTHR.getPositionExoneration7());
          }
          pbjcIteration.setIdPlanFormation(pbjcFTHR.getIdPlanFormation());
          pbjcIteration.setTypeDePlan(pbjcFTHR.getTypeDePlan());
          pbjcIteration.setIdStageFormation(pbjcFTHR.getIdStageFormation());
          pbjcIteration.setTypeMesurePourLEmploi(pbjcFTHR.getTypeMesurePourLEmploi());
        }
      }
    }
    return determinerPBJCMultiProduitPrioritaireParGamme(pbjcPrioritaires);
  }
  
  private static PbjcNcp determinerPBJCMultiProduitPrioritaireParGamme(ChronologiePeriodes chronoPBJCs)
  {
    PbjcNcp pbjcFusion = null;
    PbjcNcp pbjcIteration = null;
    PbjcNcp pbjcAsu = null;
    PbjcNcp pbjcSol = null;
    PbjcNcp pbjcFor = null;
    PbjcNcp pbjcInr = null;
    GammeSpec gammeASU = GammeAsu.getInstance();
    GammeSpec gammeSOL = GammeSol.getInstance();
    GammeSpec gammeFOR = GammeFor.getInstance();
    GammeSpec gammeINR = GammeInr.getInstance();
    
    ListIterator itChronoPBJCs = chronoPBJCs.iterer();
    while (itChronoPBJCs.hasNext())
    {
      pbjcIteration = (PbjcNcp)itChronoPBJCs.next();
      if (gammeASU.getProduit(pbjcIteration.getProduit()) != null) {
        pbjcAsu = pbjcIteration;
      } else if (gammeSOL.getProduit(pbjcIteration.getProduit()) != null) {
        pbjcSol = pbjcIteration;
      } else if (gammeFOR.getProduit(pbjcIteration.getProduit()) != null) {
        pbjcFor = pbjcIteration;
      } else if (gammeINR.getProduit(pbjcIteration.getProduit()) != null) {
        pbjcInr = pbjcIteration;
      }
    }
    if (pbjcFor != null) {
      pbjcFusion = pbjcFor;
    } else if (pbjcAsu != null) {
      pbjcFusion = pbjcAsu;
    } else if (pbjcSol != null) {
      pbjcFusion = pbjcSol;
    } else {
      pbjcFusion = pbjcInr;
    }
    return pbjcFusion;
  }
  
  private static PbjcNcp determinerPBJCMultiProduitPrioritaireParProduit(ChronologiePeriodes chronoPBJCs)
  {
    PbjcNcp pbjcFusion = null;
    PbjcNcp pbjcIteration = null;
    PbjcNcp pbjcRfpe = null;
    
    ListIterator itChronoPBJCs = chronoPBJCs.iterer();
    while (itChronoPBJCs.hasNext())
    {
      pbjcIteration = (PbjcNcp)itChronoPBJCs.next();
      if ("FOR_RFP04_01".equals(pbjcIteration.getProduit())) {
        pbjcRfpe = pbjcIteration;
      }
    }
    if (pbjcRfpe != null) {
      pbjcFusion = pbjcRfpe;
    }
    return pbjcFusion;
  }
  
  private static void controlerQuantites(int quantiteDecalage, int quantiteIndemnisable, int quantiteIndemnise, int quantiteNonIndemnise)
  {
    if (((quantiteDecalage != 0) || (quantiteIndemnisable != 0) || (quantiteIndemnise != 0) || (quantiteNonIndemnise != 0)) && 
      (quantiteDecalage + quantiteNonIndemnise != 0) && (quantiteIndemnisable != quantiteNonIndemnise) && 
      (Log.isTraceActive(GenerateurPBJCs.class, Niveau.DEBUG))) {
      Log.ecritTrace(Niveau.DEBUG, GenerateurPBJCs.class, "Controler", "Il reste des quantites a consommer pour le positionnement des quantites sur les PBJC\nquantiteDecalage \t= " + quantiteDecalage + "\nquantiteIndemnisable \t= " + quantiteIndemnisable + "\nquantiteIndemnise \t= " + quantiteIndemnise + "\nquantiteNonIndemnise \t= " + quantiteNonIndemnise);
    }
  }
  
  private static boolean controlerAttributionProduit(AttributionSpec attribution)
  {
    String codeProduitNcp = null;
    
    codeProduitNcp = attribution.getProduitExecution().getNom();
    
    return !listeNoPbjcs.contains(codeProduitNcp);
  }
  
  private static FacadePBJCProduitSpec creerFacadesPBJCProduit(AttributionSpec attribution)
    throws CoucheLogiqueException
  {
    return FacadePBJCProduitFactory.getInstance().getInstanceGestionnairePBJCProduit(attribution.getProduitExecution());
  }
  
  private static ChronologiePeriodes filtrerRognerPeriodes(ChronologiePeriodes chronoAFiltrer, Damj dateDeDebut, Damj dateDeFin, boolean multiProduit)
  {
    ChronologiePeriodes chronologieARetourner = null;
    PbjcNcp pbjcNcp = null;
    PbjcNcp pbjcOriginale = null;
    boolean tropLoin = false;
    
    chronologieARetourner = new ChronologiePeriodes();
    ListIterator itChronoAfiltrer = chronoAFiltrer.iterer();
    while ((itChronoAfiltrer.hasNext()) && (!tropLoin))
    {
      pbjcOriginale = (PbjcNcp)itChronoAfiltrer.next();
      pbjcNcp = (PbjcNcp)pbjcOriginale.copie();
      if (pbjcNcp.chevauche(new Periode(dateDeDebut, dateDeFin)))
      {
        if (!pbjcNcp.getDateDebut().coincideAvec(dateDeDebut))
        {
          pbjcNcp.setDateDebutPbjcsTrans(dateDeDebut);
          pbjcNcp.supprimerJustificationsOuverture();
          if (multiProduit)
          {
            pbjcOriginale.setDateFinPbjcsTrans(dateDeDebut.veille());
            
            int nbJoursDecalageAPositionner = Math.min(pbjcNcp.getDuree(), pbjcOriginale.getNbJoursDecalage());
            pbjcNcp.setNbJoursDecalage(nbJoursDecalageAPositionner);
            pbjcOriginale.setNbJoursDecalage(pbjcOriginale.getNbJoursDecalage() - nbJoursDecalageAPositionner);
            
            int nbJoursImputesAPositionner = Math.min(pbjcNcp.getDuree() - nbJoursDecalageAPositionner, pbjcOriginale.getNbJoursImputes());
            pbjcNcp.setNbJoursImputes(nbJoursImputesAPositionner);
            pbjcOriginale.setNbJoursImputes(pbjcOriginale.getNbJoursImputes() - nbJoursImputesAPositionner);
            
            pbjcNcp.setCumulCourant(pbjcNcp.getCumulCourant() + nbJoursImputesAPositionner);
            
            pbjcNcp.setReliquatDureeMax(pbjcNcp.getReliquatDureeMax() - nbJoursImputesAPositionner);
            
            pbjcOriginale.setReliquatDureeReglementaire(pbjcOriginale.getReliquatDureeReglementaire() + pbjcNcp.getNbJoursImputes());
          }
        }
        if (!pbjcNcp.getDateFin().coincideAvec(dateDeFin))
        {
          pbjcNcp.setDateFinPbjcsTrans(dateDeFin);
          pbjcNcp.supprimerJustificationsFermeture();
          if (multiProduit)
          {
            pbjcOriginale.setDateDebutPbjcsTrans(dateDeFin.lendemain());
            
            int nbJoursDecalageAPositionner = Math.min(pbjcNcp.getDuree(), pbjcOriginale.getNbJoursDecalage());
            pbjcNcp.setNbJoursDecalage(nbJoursDecalageAPositionner);
            pbjcOriginale.setNbJoursDecalage(pbjcOriginale.getNbJoursDecalage() - nbJoursDecalageAPositionner);
            
            int nbJoursImputesAPositionner = Math.min(pbjcNcp.getDuree() - nbJoursDecalageAPositionner, pbjcOriginale.getNbJoursImputes());
            pbjcNcp.setNbJoursImputes(nbJoursImputesAPositionner);
            pbjcOriginale.setNbJoursImputes(pbjcOriginale.getNbJoursImputes() - nbJoursImputesAPositionner);
            
            pbjcOriginale.setCumulCourant(pbjcOriginale.getCumulCourant() + nbJoursImputesAPositionner);
            
            pbjcOriginale.setReliquatDureeMax(pbjcOriginale.getReliquatDureeMax() - nbJoursImputesAPositionner);
            
            pbjcNcp.setReliquatDureeReglementaire(pbjcNcp.getReliquatDureeReglementaire() + pbjcOriginale.getNbJoursImputes());
          }
        }
        chronologieARetourner.ajouter(pbjcNcp);
      }
      if (dateDeFin.estAvant(pbjcNcp.getDateDebut())) {
        tropLoin = true;
      }
    }
    return chronologieARetourner;
  }
  
  private static int determinerQuantiteAImputerEnFinDIndemnisation(UniteTraitement ut)
  {
    int quantiteARetourner;
    int quantiteARetourner;
    if (ut.getArretProduitAvecRaison().isRaisonsContientRaison(1)) {
      quantiteARetourner = ut.getDateFin().getJour() - ut.getArretProduitAvecRaison().recupereLendemainDateArret().veille().getJour();
    } else {
      quantiteARetourner = 0;
    }
    return quantiteARetourner;
  }
  
  private static int retournerCumulJoursImputes(ChronologiePeriodes chrono, FacadePBJCProduitSpec facadePBJCProduit, AttributionSpec attribution, int reliquat, UniteTraitement ut)
  {
    int cumulARetourner = 0;
    
    PbjcNcp pbjcNcp = null;
    if (!chrono.estVide())
    {
      pbjcNcp = (PbjcNcp)chrono.dernierElement();
      cumulARetourner = pbjcNcp.getCumulCourant() + pbjcNcp.getNbJoursImputes();
    }
    else
    {
      cumulARetourner = facadePBJCProduit.retournerQuantiteIndemnisationInitialeDroit(attribution, ut).getValeurEntiere() - reliquat;
    }
    return cumulARetourner;
  }
  
  public static void enregistrerChronologiePBJCs(ChronologiePeriodes chronoPBJCs, Damj dateDebutGeneration, IndividuSpec individu, int contexteExecution)
    throws CoucheLogiqueException
  {
    ChronologiePeriodes chronoPBJCsIndiv = individu.getChronoPbjcs();
    ChronologiePeriodes chronoPBJCsASuppr = new ChronologiePeriodes();
    ListIterator itChronoPBJCS = chronoPBJCsIndiv.iterer();
    boolean trouvee = false;
    if (individu.getDateDebutGenerationPbjcs().coincideAvec(Damj.NUIT_DES_TEMPS)) {
      individu.setDateDebutGenerationPbjcs(dateDebutGeneration);
    } else {
      individu.setDateDebutGenerationPbjcs(Damj.min(individu.getDateDebutGenerationPbjcs(), dateDebutGeneration));
    }
    if (((contexteExecution == 0 ? 1 : 0) & (!verifierCoherencePBJCs(dateDebutGeneration, individu) ? 1 : 0)) != 0) {
      GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_L_CAL_MISE_A_JOUR_PBJC_DROIT_NEUTRALISE", new Object[] { dateDebutGeneration.toString() });
    }
    while ((itChronoPBJCS.hasNext()) && (!trouvee))
    {
      PbjcNcp oldPbjc = (PbjcNcp)itChronoPBJCS.next();
      if (oldPbjc.getDateDebut().estApresOuCoincideAvec(dateDebutGeneration))
      {
        trouvee = true;
        itChronoPBJCS.previous();
      }
    }
    if ((itChronoPBJCS.hasNext()) && (chronoPBJCs != null) && (!chronoPBJCs.estVide()))
    {
      ListIterator itPChronoPBJCS = chronoPBJCs.iterer();
      while ((itChronoPBJCS.hasNext()) && (itPChronoPBJCS.hasNext()))
      {
        PbjcNcp oldPbjc = (PbjcNcp)itChronoPBJCS.next();
        PbjcNcp newPbjc = (PbjcNcp)itPChronoPBJCS.next();
        newPbjc.copieElements(oldPbjc);
      }
      while (itChronoPBJCS.hasNext())
      {
        PbjcNcp pbjcASupr = (PbjcNcp)itChronoPBJCS.next();
        chronoPBJCsASuppr.ajouter(pbjcASupr);
        DomManager.supprimer(pbjcASupr);
      }
      while (itPChronoPBJCS.hasNext()) {
        chronoPBJCsIndiv.ajouter((PbjcNcp)itPChronoPBJCS.next());
      }
    }
    else
    {
      if (itChronoPBJCS.hasNext()) {
        while (itChronoPBJCS.hasNext())
        {
          PbjcNcp pbjcASupr = (PbjcNcp)itChronoPBJCS.next();
          chronoPBJCsASuppr.ajouter(pbjcASupr);
          DomManager.supprimer(pbjcASupr);
        }
      }
      if ((chronoPBJCs != null) && (!chronoPBJCs.estVide()))
      {
        ListIterator itPChronoPBJCS = chronoPBJCs.iterer();
        while (itPChronoPBJCS.hasNext()) {
          chronoPBJCsIndiv.ajouter((PbjcNcp)itPChronoPBJCS.next());
        }
      }
    }
    Iterator ite = chronoPBJCsASuppr.iterer();
    while (ite.hasNext()) {
      chronoPBJCsIndiv.supprimer((PbjcNcp)ite.next());
    }
  }
  
  public static boolean verifierCoherencePBJCs(Damj dateDebutGeneration, IndividuSpec individu)
    throws CoucheLogiqueException
  {
    Damj djiDerniereAttributionNeutralisee = Damj.NUIT_DES_TEMPS;
    
    List attributions = individu.getListeAttributionsNeutralisees();
    Iterator iterator = attributions.iterator();
    while (iterator.hasNext())
    {
      AttributionSpec attribution = (AttributionSpec)iterator.next();
      if ((attribution.getCalendrierExecutionCalcul() != null) && (attribution.getCalendrierExecutionCalcul().getDernierJourIndemnisable().estApres(djiDerniereAttributionNeutralisee))) {
        djiDerniereAttributionNeutralisee = attribution.getCalendrierExecutionCalcul().getDernierJourIndemnisable();
      }
    }
    if (dateDebutGeneration.estAvant(djiDerniereAttributionNeutralisee)) {
      return false;
    }
    return true;
  }
  
  public static void nettoyerPBJCs(Damj dateDebutNettoyage, IndividuSpec individu)
  {
    if (ContexteParcoursCalcul.estPersistant())
    {
      ChronologiePeriodes chronoPBJCs = individu.getChronoPbjcs();
      ChronologiePeriodes chronoPBJCsASuppr = new ChronologiePeriodes();
      if (chronoPBJCs != null)
      {
        ListIterator itChronoPBJCS = chronoPBJCs.iterer();
        while (itChronoPBJCS.hasNext())
        {
          PbjcNcp oldPbjc = (PbjcNcp)itChronoPBJCS.next();
          if (oldPbjc.getDateDebut().estApresOuCoincideAvec(dateDebutNettoyage))
          {
            chronoPBJCsASuppr.ajouter(oldPbjc);
            DomManager.supprimer(oldPbjc);
          }
        }
        Iterator ite = chronoPBJCsASuppr.iterer();
        while (ite.hasNext()) {
          chronoPBJCs.supprimer((PbjcNcp)ite.next());
        }
      }
    }
  }
  
  private static ChronologiePeriodes traiterPeriodesSegmentantes(FacadePBJCProduitSpec facadePBJCProduit, AttributionSpec attribution, UniteTraitement ut, String naturePBJCParDefaut)
    throws CoucheLogiqueException
  {
    ChronologiePeriodes chronologieARetourner = null;
    QualificationPeriodes qualificationPeriodes = null;
    ChronologiePeriodes periodesSegmentantes = null;
    ObjetChronoPeriode periode = null;
    PbjcNcp pbjcNcp = null;
    Damj dateFinDeProduit = null;
    if ((ut.getArretProduitAvecRaison() != null) && (ut.getArretProduitAvecRaison().isProduitAArreter())) {
      dateFinDeProduit = ut.getArretProduitAvecRaison().recupereLendemainDateArret().veille();
    }
    chronologieARetourner = new ChronologiePeriodes();
    
    qualificationPeriodes = ut.getQualificationPeriodes();
    periodesSegmentantes = qualificationPeriodes.getPeriodesSegmentantes();
    ListIterator it = periodesSegmentantes.iterer();
    while (it.hasNext())
    {
      periode = (ObjetChronoPeriode)it.next();
      if ((dateFinDeProduit == null) || (!dateFinDeProduit.estAvant(periode.getDateDebut())))
      {
        pbjcNcp = creerPbjcNiveauPeriodeSuspensive(facadePBJCProduit, attribution, ut, naturePBJCParDefaut, periode.getDateDebut(), periode.getDateFin());
        if ((periode instanceof FinPeriodeFormationNonIndemnisee))
        {
          facadePBJCProduit.positionnerComplementJustification(pbjcNcp, ut, attribution);
          facadePBJCProduit.positionnerInformationDecisionSanction(pbjcNcp, ut);
          if ((((FinPeriodeFormationNonIndemnisee)periode).getPeriodeFormationNonIndemnisee().estRemuneree()) || (((FinPeriodeFormationNonIndemnisee)periode).getPeriodeFormationNonIndemnisee().getDureeTotale() == null) || (((FinPeriodeFormationNonIndemnisee)periode).getPeriodeFormationNonIndemnisee().getDureeTotale().getValeur().compareTo(QUARANTE) == 1)) {
            pbjcNcp.setQualificationPeriode(6);
          } else {
            pbjcNcp.setQualificationPeriode(5);
          }
          pbjcNcp.setCodeMotifNonPaiement("90");
          
          chronologieARetourner.ajouter(pbjcNcp);
        }
        else if (((periode instanceof FinPeriodeFormation)) && 
          (((FinPeriodeFormation)periode).getActionFormation().getQuantiteHoraireTotal().getValeur().compareTo(QUARANTE) >= 0))
        {
          pbjcNcp.setQualificationPeriode(6);
          
          pbjcNcp.setCodeMotifNonPaiement("90");
          chronologieARetourner.ajouter(pbjcNcp);
        }
      }
    }
    return chronologieARetourner;
  }
  
  private static ChronologiePeriodes fusionPbjcs(ChronologiePeriodes chronologiePbjcs, Damj dateFusion)
  {
    ChronologiePeriodes chronoFusionnee = new ChronologiePeriodes();
    PbjcNcp pbjcFusion = null;
    chronologiePbjcs.iterer();
    while (chronologiePbjcs.encoreSuivant())
    {
      PbjcNcp pbjcNcp = (PbjcNcp)chronologiePbjcs.elementSuivant().copie();
      if (dateFusion.estContenueDans(new Periode(pbjcNcp.getDateDebut(), pbjcNcp.getDateFin())))
      {
        pbjcFusion = pbjcNcp;
      }
      else if (dateFusion.estApres(pbjcNcp.getDateDebut()))
      {
        chronoFusionnee.ajouter(pbjcNcp);
      }
      else if (pbjcFusion == null)
      {
        pbjcFusion = pbjcNcp;
      }
      else
      {
        if (((pbjcFusion.getBaseDeCalcul1() != null) && (pbjcNcp.getBaseDeCalcul1() != null) && (pbjcFusion.getBaseDeCalcul1().compareTo(pbjcNcp.getBaseDeCalcul1()) != 0)) || ((pbjcFusion.getBaseDeCalcul1() == null) && (pbjcNcp.getBaseDeCalcul1() != null)) || ((pbjcFusion.getBaseDeCalcul1() != null) && (pbjcNcp.getBaseDeCalcul1() == null))) {
          return null;
        }
        if (((pbjcFusion.getCodeTypeMontant1() != null) && (pbjcNcp.getCodeTypeMontant1() != null) && (!pbjcFusion.getCodeTypeMontant1().equals(pbjcNcp.getCodeTypeMontant1()))) || ((pbjcFusion.getCodeTypeMontant1() == null) && (pbjcNcp.getCodeTypeMontant1() != null)) || ((pbjcFusion.getCodeTypeMontant1() != null) && (pbjcNcp.getCodeTypeMontant1() == null)) || ((pbjcFusion.getCodeTypeMontant2() != null) && (pbjcNcp.getCodeTypeMontant2() != null) && (!pbjcFusion.getCodeTypeMontant2().equals(pbjcNcp.getCodeTypeMontant2()))) || ((pbjcFusion.getCodeTypeMontant2() == null) && (pbjcNcp.getCodeTypeMontant2() != null)) || ((pbjcFusion.getCodeTypeMontant2() != null) && (pbjcNcp.getCodeTypeMontant2() == null)) || ((pbjcFusion.getCodeTypeMontant3() != null) && (pbjcNcp.getCodeTypeMontant3() != null) && (!pbjcFusion.getCodeTypeMontant3().equals(pbjcNcp.getCodeTypeMontant3()))) || ((pbjcFusion.getCodeTypeMontant3() == null) && (pbjcNcp.getCodeTypeMontant3() != null)) || ((pbjcFusion.getCodeTypeMontant3() != null) && (pbjcNcp.getCodeTypeMontant3() == null))) {
          return null;
        }
        if (((pbjcFusion.getCoefficientTempsPartiel() != null) && (pbjcNcp.getCoefficientTempsPartiel() != null) && (pbjcFusion.getCoefficientTempsPartiel().compareTo(pbjcNcp.getCoefficientTempsPartiel()) != 0)) || ((pbjcFusion.getCoefficientTempsPartiel() == null) && (pbjcNcp.getCoefficientTempsPartiel() != null)) || ((pbjcFusion.getCoefficientTempsPartiel() != null) && (pbjcNcp.getCoefficientTempsPartiel() == null))) {
          return null;
        }
        if (chronologiePbjcs.encoreSuivant())
        {
          if ((pbjcNcp.getComplementDeJustification0() != null) || (pbjcNcp.getComplementDeJustification1() != null) || (pbjcNcp.getComplementDeJustification2() != null) || (pbjcNcp.getComplementDeJustification3() != null) || (pbjcNcp.getComplementDeJustification4() != null) || (pbjcNcp.getComplementDeJustification5() != null) || (pbjcNcp.getComplementDeJustification6() != null) || (pbjcNcp.getComplementDeJustification7() != null) || (pbjcNcp.getComplementDeJustification8() != null) || (pbjcNcp.getComplementDeJustification9() != null)) {
            return null;
          }
        }
        else
        {
          if (pbjcNcp.getComplementDeJustification0() != null) {
            pbjcFusion.ajouterComplementDeJustification(pbjcNcp.getComplementDeJustification0());
          }
          if (pbjcNcp.getComplementDeJustification1() != null) {
            pbjcFusion.ajouterComplementDeJustification(pbjcNcp.getComplementDeJustification1());
          }
          if (pbjcNcp.getComplementDeJustification2() != null) {
            pbjcFusion.ajouterComplementDeJustification(pbjcNcp.getComplementDeJustification2());
          }
          if (pbjcNcp.getComplementDeJustification3() != null) {
            pbjcFusion.ajouterComplementDeJustification(pbjcNcp.getComplementDeJustification3());
          }
          if (pbjcNcp.getComplementDeJustification4() != null) {
            pbjcFusion.ajouterComplementDeJustification(pbjcNcp.getComplementDeJustification4());
          }
          if (pbjcNcp.getComplementDeJustification5() != null) {
            pbjcFusion.ajouterComplementDeJustification(pbjcNcp.getComplementDeJustification5());
          }
          if (pbjcNcp.getComplementDeJustification6() != null) {
            pbjcFusion.ajouterComplementDeJustification(pbjcNcp.getComplementDeJustification6());
          }
          if (pbjcNcp.getComplementDeJustification7() != null) {
            pbjcFusion.ajouterComplementDeJustification(pbjcNcp.getComplementDeJustification7());
          }
          if (pbjcNcp.getComplementDeJustification8() != null) {
            pbjcFusion.ajouterComplementDeJustification(pbjcNcp.getComplementDeJustification8());
          }
          if (pbjcNcp.getComplementDeJustification9() != null) {
            pbjcFusion.ajouterComplementDeJustification(pbjcNcp.getComplementDeJustification9());
          }
        }
        if (pbjcFusion.getCumulHeureActRed() != pbjcNcp.getCumulHeureActRed()) {
          return null;
        }
        pbjcFusion.setDateFinPbjcsTrans(pbjcNcp.getDateFin());
        if (((pbjcFusion.getMontantSjc() != null) && (pbjcNcp.getMontantSjc() != null) && (pbjcFusion.getMontantSjc().compareTo(pbjcNcp.getMontantSjc()) != 0)) || ((pbjcFusion.getMontantSjc() == null) && (pbjcNcp.getMontantSjc() != null)) || ((pbjcFusion.getMontantSjc() != null) && (pbjcNcp.getMontantSjc() == null))) {
          return null;
        }
        if (((pbjcFusion.getNaturePBJC() != null) && (pbjcNcp.getNaturePBJC() != null) && (!pbjcFusion.getNaturePBJC().equals(pbjcNcp.getNaturePBJC()))) || ((pbjcFusion.getNaturePBJC() == null) && (pbjcNcp.getNaturePBJC() != null)) || ((pbjcFusion.getNaturePBJC() != null) && (pbjcNcp.getNaturePBJC() == null))) {
          return null;
        }
        if (pbjcNcp.getNbJoursDecalage() != 0) {
          return null;
        }
        if (((pbjcFusion.getResultatCalcul1() != null) && (pbjcNcp.getResultatCalcul1() != null) && (!pbjcFusion.getResultatCalcul1().equals(pbjcNcp.getResultatCalcul1()))) || ((pbjcFusion.getResultatCalcul1() == null) && (pbjcNcp.getResultatCalcul1() != null)) || ((pbjcFusion.getResultatCalcul1() != null) && (pbjcNcp.getResultatCalcul1() == null)) || ((pbjcFusion.getResultatCalcul2() != null) && (pbjcNcp.getResultatCalcul2() != null) && (!pbjcFusion.getResultatCalcul2().equals(pbjcNcp.getResultatCalcul2()))) || ((pbjcFusion.getResultatCalcul2() == null) && (pbjcNcp.getResultatCalcul2() != null)) || ((pbjcFusion.getResultatCalcul2() != null) && (pbjcNcp.getResultatCalcul2() == null)) || ((pbjcFusion.getResultatCalcul3() != null) && (pbjcNcp.getResultatCalcul3() != null) && (!pbjcFusion.getResultatCalcul3().equals(pbjcNcp.getResultatCalcul3()))) || ((pbjcFusion.getResultatCalcul3() == null) && (pbjcNcp.getResultatCalcul3() != null)) || ((pbjcFusion.getResultatCalcul3() != null) && (pbjcNcp.getResultatCalcul3() == null))) {
          return null;
        }
        if (((pbjcFusion.getTypePopulation1() != null) && (pbjcNcp.getTypePopulation1() != null) && (!pbjcFusion.getTypePopulation1().equals(pbjcNcp.getTypePopulation1()))) || ((pbjcFusion.getTypePopulation1() == null) && (pbjcNcp.getTypePopulation1() != null)) || ((pbjcFusion.getTypePopulation1() != null) && (pbjcNcp.getTypePopulation1() == null)) || ((pbjcFusion.getTypePopulation2() != null) && (pbjcNcp.getTypePopulation2() != null) && (!pbjcFusion.getTypePopulation2().equals(pbjcNcp.getTypePopulation2()))) || ((pbjcFusion.getTypePopulation2() == null) && (pbjcNcp.getTypePopulation2() != null)) || ((pbjcFusion.getTypePopulation2() != null) && (pbjcNcp.getTypePopulation2() == null)) || ((pbjcFusion.getTypePopulation3() != null) && (pbjcNcp.getTypePopulation3() != null) && (!pbjcFusion.getTypePopulation3().equals(pbjcNcp.getTypePopulation3()))) || ((pbjcFusion.getTypePopulation3() == null) && (pbjcNcp.getTypePopulation3() != null)) || ((pbjcFusion.getTypePopulation3() != null) && (pbjcNcp.getTypePopulation3() == null)) || ((pbjcFusion.getTypePopulation4() != null) && (pbjcNcp.getTypePopulation4() != null) && (!pbjcFusion.getTypePopulation4().equals(pbjcNcp.getTypePopulation4()))) || ((pbjcFusion.getTypePopulation4() == null) && (pbjcNcp.getTypePopulation4() != null)) || ((pbjcFusion.getTypePopulation4() != null) && (pbjcNcp.getTypePopulation4() == null)) || ((pbjcFusion.getTypePopulation5() != null) && (pbjcNcp.getTypePopulation5() != null) && (!pbjcFusion.getTypePopulation5().equals(pbjcNcp.getTypePopulation5()))) || ((pbjcFusion.getTypePopulation5() == null) && (pbjcNcp.getTypePopulation5() != null)) || ((pbjcFusion.getTypePopulation5() != null) && (pbjcNcp.getTypePopulation5() == null))) {
          return null;
        }
        pbjcFusion.setNbJoursImputes(pbjcFusion.getNbJoursImputes() + pbjcNcp.getNbJoursImputes());
      }
    }
    if (pbjcFusion != null) {
      chronoFusionnee.ajouter(pbjcFusion);
    } else {
      return null;
    }
    return chronoFusionnee;
  }
  
  private static boolean existeDejaTypeMontant(PbjcNcp pbjc, String typeMontant)
  {
    boolean retour = false;
    if (((pbjc.getCodeTypeMontant1() != null) && (pbjc.getCodeTypeMontant1().equals(typeMontant))) || ((pbjc.getCodeTypeMontant2() != null) && (pbjc.getCodeTypeMontant2().equals(typeMontant))) || ((pbjc.getCodeTypeMontant3() != null) && (pbjc.getCodeTypeMontant3().equals(typeMontant))) || ((pbjc.getCodeTypeMontant4() != null) && (pbjc.getCodeTypeMontant4().equals(typeMontant))) || ((pbjc.getCodeTypeMontant5() != null) && (pbjc.getCodeTypeMontant5().equals(typeMontant))) || ((pbjc.getCodeTypeMontant6() != null) && (pbjc.getCodeTypeMontant6().equals(typeMontant))) || ((pbjc.getCodeTypeMontant7() != null) && (pbjc.getCodeTypeMontant7().equals(typeMontant)))) {
      retour = true;
    }
    return retour;
  }
  
  private static boolean estNouvellePa(PeriodeAnalyse pa, PeriodeAnalyse anciennePa)
  {
    boolean estNouvellePa = false;
    if ((anciennePa == null) || (!pa.getPeriode().coincideAvec(anciennePa.getPeriode()))) {
      estNouvellePa = true;
    }
    return estNouvellePa;
  }
}

/* Location:
 * Qualified Name:     GenerateurPBJCs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */