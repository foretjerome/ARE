package fr.unedic.cali.calcul;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.autresdoms.cohab.dom.DonneesMoisMandate;
import fr.unedic.cali.autresdoms.cohab.dom.ObjetChronoPeriodePriseEnChargeSansFiltre;
import fr.unedic.cali.calcul.dom.ArretProduitAvecRaison;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculPeriodique;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculSpec;
import fr.unedic.cali.calcul.dom.ConstituantsCalculActiviteReduiteSpec;
import fr.unedic.cali.calcul.dom.ConstituantsIndemnisation;
import fr.unedic.cali.calcul.dom.Decalage;
import fr.unedic.cali.calcul.dom.EvenementBlocageActualisation;
import fr.unedic.cali.calcul.dom.EvenementDRV;
import fr.unedic.cali.calcul.dom.EvenementSanctionDecisionNonMaintienASSetATA;
import fr.unedic.cali.calcul.dom.EvenementSanctionExclusionDefinitive;
import fr.unedic.cali.calcul.dom.EvenementSuspensionACCREASS;
import fr.unedic.cali.calcul.dom.EvenementSuspensionCaAss;
import fr.unedic.cali.calcul.dom.EvenementSuspensionCirmaAss;
import fr.unedic.cali.calcul.dom.QualificationPeriodes;
import fr.unedic.cali.calcul.dom.Somme;
import fr.unedic.cali.calcul.dom.SyntheseARsurUT;
import fr.unedic.cali.calcul.dom.UniteTraitement;
import fr.unedic.cali.calcul.dom.periode.PeriodeAbsenceAuPointage;
import fr.unedic.cali.calcul.dom.periode.PeriodeAbsenceRetourUL961;
import fr.unedic.cali.calcul.dom.periode.PeriodeActiviteSalarieSansSalaire;
import fr.unedic.cali.calcul.dom.periode.PeriodeChevauchementSanction;
import fr.unedic.cali.calcul.dom.periode.PeriodeContrat;
import fr.unedic.cali.calcul.dom.periode.PeriodeEvenementBloquant;
import fr.unedic.cali.calcul.dom.periode.PeriodeEvenementEntreeCA;
import fr.unedic.cali.calcul.dom.periode.PeriodeEvenementEntreeCIRMA;
import fr.unedic.cali.calcul.dom.periode.PeriodeExclusionDefinitiveDDTE;
import fr.unedic.cali.calcul.dom.periode.PeriodeNonMaintienASSetATA;
import fr.unedic.cali.calcul.dom.periode.PeriodeSuspensionDDTEAvecImputation;
import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeArretCalcul;
import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeCalcul;
import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeValiditeAccordACCREDDTE;
import fr.unedic.cali.calcul.outilsfonctionnels.GestionForcage;
import fr.unedic.cali.calcul.outilsfonctionnels.GestionSuivi;
import fr.unedic.cali.calcul.outilsfonctionnels.dom.ContexteUT;
import fr.unedic.cali.calcul.outilsfonctionnels.dom.ContexteUT.ElementContexteUT;
import fr.unedic.cali.calcul.outilsfonctionnels.dom.PeriodeAnalyseSpec;
import fr.unedic.cali.calcul.outilsfonctionnels.dom.PeriodesPriseEnCompte;
import fr.unedic.cali.calcul.outilsfonctionnels.filtres.FiltrePeriodeTravailCalculCES;
import fr.unedic.cali.calcul.outilsfonctionnels.filtres.FiltrePeriodeTravailCalculCESForfait;
import fr.unedic.cali.calcul.outilsfonctionnels.filtres.FiltrePeriodeTravailCalculHorsCESForfait;
import fr.unedic.cali.calcul.outilsfonctionnels.proratisation.PeriodeProratisationFactory;
import fr.unedic.cali.calcul.pbjc.dom.IndividuPbjcNcp;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DossierAffectationSpec;
import fr.unedic.cali.dom.FormuleMontantSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.OdSpec;
import fr.unedic.cali.dom.QuantiteIndemnisationSpec;
import fr.unedic.cali.dom.RenouvellementSpec;
import fr.unedic.cali.dom.RepriseSpec;
import fr.unedic.cali.dom.RevisionSpec;
import fr.unedic.cali.dom.affectation.GammeSpec;
import fr.unedic.cali.dom.affectation.LigneSpec;
import fr.unedic.cali.dom.affectation.ProduitSolAer05P01;
import fr.unedic.cali.dom.affectation.ProduitSolAta06P01;
import fr.unedic.cali.dom.affectation.ProduitSolCge01P01;
import fr.unedic.cali.dom.affectation.ProduitSolCpa02P01;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.cali.fabriques.FabriqueStrategiePECCACIRMAetCUI;
import fr.unedic.cali.fabriques.FabriqueStrategieReglesArSurCiPuisReprise;
import fr.unedic.cali.outilsfonctionnels.Anomalie;
import fr.unedic.cali.outilsfonctionnels.GestionAnomalies;
import fr.unedic.cali.outilsfonctionnels.OutillagePEC;
import fr.unedic.cali.outilsfonctionnels.strategies.CritereStrategie;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategiePECCACIRMAetCUISpec;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieReglesArSurCiPuisRepriseSpec;
import fr.unedic.cali.utilitaire.filtres.composites.FiltreAttributionAssurance;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreAttributionSurDecisions;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreDecisionPourProduit;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreDemandePourERE;
import fr.unedic.cali.utilitaire.filtres.logiques.FiltreET;
import fr.unedic.cali.utilitaire.filtres.logiques.FiltreOU;
import fr.unedic.cali.utilitaire.outils.OutilRecherche;
import fr.unedic.util.Quantite;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.FiltreChevauchePeriode;
import fr.unedic.util.temps.FiltreDebutDansBornes;
import fr.unedic.util.temps.ObjetChronoPeriode;
import fr.unedic.util.temps.ObjetChronoPeriodeTest;
import fr.unedic.util.temps.Periode;
import fr.unedic.util.temps.Temporel;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class TraitementAttributionPeriodique
{
  public static Damj traiterPeriodeSurUtNeutralisee(AttributionSpec attribution, FacadeCalculProduitPeriodiqueSpec facadeCalculProduit, PeriodesPriseEnCompte periodesPriseEnCompte, ConstituantsIndemnisation constituantsIndemnisation, UniteTraitement ut, PeriodeAnalyseSpec pa, ArretProduitAvecRaison arretProduitAvecRaison, ChronologiePeriodes chronoPeriodesSegmentantes, ChronologiePeriodes periodesAnalyses)
    throws ApplicativeException
  {
    ChronologiePeriodes chronoPeriodesSegmentantesSurPeriode = null;
    
    Periode periode = null;
    Damj dateFin = null;
    if (pa != null) {
      periode = pa.getPeriode();
    } else {
      periode = ut.getPeriode();
    }
    chronoPeriodesSegmentantesSurPeriode = (ChronologiePeriodes)chronoPeriodesSegmentantes.copier(new FiltreDebutDansBornes(periode));
    
    chronoPeriodesSegmentantesSurPeriode.iterer();
    while (chronoPeriodesSegmentantesSurPeriode.encoreSuivant()) {
      facadeCalculProduit.traitementPeriodeSegmentante(attribution, (ObjetChronoPeriode)chronoPeriodesSegmentantesSurPeriode.elementSuivant(), constituantsIndemnisation, ut, pa, arretProduitAvecRaison, periodesAnalyses);
    }
    dateFin = ut.getDateFin();
    if (arretProduitAvecRaison.isProduitAArreter())
    {
      dateFin = arretProduitAvecRaison.recupereLendemainDateArret().veille();
      
      periode.setFin(dateFin);
    }
    if (dateFin.estApresOuCoincideAvec(periode.getDebut()))
    {
      FormuleMontantSpec formuleMontant = recupererFormuleMontant(attribution, constituantsIndemnisation);
      if (ut.getCollectionSommes() == null) {
        ut.setCollectionSommes(new ArrayList());
      }
      ChronologiePeriodes periodesPriseEnCompteInterruptives = periodesPriseEnCompte.getPeriodesParTypologie(2);
      ChronologiePeriodes periodesPriseEnCompteInterruptivesFiltree = (ChronologiePeriodes)periodesPriseEnCompteInterruptives.copier(new FiltreChevauchePeriode(periode));
      
      Temporel temporel = null;
      ListIterator itChrono = periodesPriseEnCompteInterruptivesFiltree.iterer();
      while (itChrono.hasNext())
      {
        temporel = (Temporel)itChrono.next();
        ut.ajouterSomme(new Somme(Damj.max(temporel.getDateDebut(), periode.getDebut()), Damj.min(temporel.getDateFin(), periode.getFin()), new Quantite(BigDecimal.ZERO, ut.getUniteParDefautQuantites()), facadeCalculProduit.calculMontant(formuleMontant, constituantsIndemnisation, periode.getDebut()), null));
      }
    }
    return dateFin;
  }
  
  public static UniteTraitement executerAttribution(AttributionSpec attribution, FacadeCalculProduitPeriodiqueSpec facadeCalculProduit, ConstituantsIndemnisation constituantsIndem, ConstituantsCalculActiviteReduiteSpec constituantsCalculActReduite, Quantite qteDecalageDureeEnCours, Periode perUT, ContexteUT contexteUT, ChronologiePeriodes chronologiePeriodes, PeriodesPriseEnCompte periodesPriseEnCompte, ChronologiePeriodes chronologiePeriodesEvtActualisation, CalendrierExecutionCalculPeriodique calendrier)
    throws ApplicativeException
  {
    Damj dateFin = null;
    UniteTraitement ut = null;
    ConstituantsIndemnisation constituantsIndemnisation = null;
    ConstituantsCalculActiviteReduiteSpec constituantsCalculActiviteReduite = null;
    Periode periodeUT = null;
    QualificationPeriodes qualificationPeriodes = null;
    ChronologiePeriodes periodesAnalyses = null;
    ArretProduitAvecRaison arretProduitAvecRaison = null;
    
    periodeUT = (Periode)perUT.copie();
    
    ut = creerUT(periodeUT, facadeCalculProduit, qteDecalageDureeEnCours, attribution);
    
    constituantsIndemnisation = majConstituantsIndemnisation(constituantsIndem);
    affectationConstituantsIndemnisation(constituantsIndemnisation, ut);
    constituantsCalculActiviteReduite = majConstituantsCalculActiviteReduite(constituantsCalculActReduite, ut, attribution, facadeCalculProduit, constituantsIndemnisation);
    
    affectationConstituantsCalculActiviteReduite(constituantsCalculActiviteReduite, ut);
    
    effectuerTraitementEvtActualisation(ut, attribution.getDemandeur(), chronologiePeriodesEvtActualisation);
    
    facadeCalculProduit.convertionCachets(chronologiePeriodes);
    
    qualificationPeriodes = qualifierPeriodes(attribution, facadeCalculProduit, contexteUT, chronologiePeriodes);
    
    ChronologiePeriodes periodesAlertantes = facadeCalculProduit.decoupageEtProratisationPeriodesActivites(periodesPriseEnCompte, 7, qualificationPeriodes.getPeriodesAlertantes(), perUT);
    
    qualificationPeriodes.setPeriodesAlertantes(periodesAlertantes);
    ut.setQualificationPeriodes(qualificationPeriodes);
    
    effectuerTraitementSanctionsInterruptivesDefinitives(ut, qualificationPeriodes, attribution.getDemandeur());
    
    effectuerTraitementPeriodesCaCirma(ut, qualificationPeriodes, calendrier);
    
    arretProduitAvecRaison = effectuerTraitementPeriodes(attribution, facadeCalculProduit, ut, contexteUT, periodesPriseEnCompte, calendrier);
    
    periodesAnalyses = creerLesPeriodesAnalyses(ut, qualificationPeriodes, periodesPriseEnCompte);
    
    effectuerTraitementSuspension(ut, qualificationPeriodes);
    
    effectuerTraitementActiviteReduite(attribution, facadeCalculProduit, constituantsCalculActiviteReduite, perUT, contexteUT, ut, qualificationPeriodes, arretProduitAvecRaison, constituantsIndemnisation);
    
    facadeCalculProduit.imputerQuantiteIndemnisationDuAuxPNDS(ut, constituantsIndemnisation, arretProduitAvecRaison, attribution);
    
    PeriodeSuspensionDDTEAvecImputation periodeSanction = recupererSanctionDebutantHorsUt(attribution, ut, qualificationPeriodes);
    if (periodeSanction != null)
    {
      facadeCalculProduit.imputerQuantiteIndemnisationDuAuxSanctions(attribution, ut, periodeSanction, constituantsIndemnisation, arretProduitAvecRaison);
      if ((arretProduitAvecRaison.isProduitAArreter()) && (arretProduitAvecRaison.isRaisonsContientRaison(1))) {
        ut.ajouterSomme(new Somme(Damj.max(ut.getDateDebut(), attribution.getPjiEffectif()), arretProduitAvecRaison.recupereLendemainDateArret().veille(), new Quantite(BigDecimal.ZERO, ut.getUniteParDefautQuantites()), facadeCalculProduit.calculMontant(recupererFormuleMontant(attribution, constituantsIndemnisation), constituantsIndemnisation, ut.getDateDebut()), null));
      }
    }
    facadeCalculProduit.postTraitementQualification(ut, qualificationPeriodes);
    
    detectionPASSS(attribution, facadeCalculProduit, contexteUT, ut, constituantsIndemnisation, qualificationPeriodes, periodesAnalyses, arretProduitAvecRaison, periodesPriseEnCompte);
    
    detectionDRV(attribution, facadeCalculProduit, contexteUT, calendrier, ut, constituantsIndemnisation, qualificationPeriodes, periodesAnalyses, arretProduitAvecRaison, periodesPriseEnCompte);
    if (ut.isNeutralisee())
    {
      constituantsIndemnisation = traitementUtNeutralise(attribution, facadeCalculProduit, contexteUT, periodesPriseEnCompte, dateFin, ut, constituantsIndemnisation, qualificationPeriodes, periodesAnalyses, arretProduitAvecRaison);
      if (constituantsIndemnisation.getListListeDureeNonIndemnisables() != null) {
        TraitementDureeNonIndemnisable.miseAJourReliquatFranchiseSurMoisNeutralise(constituantsIndemnisation);
      }
    }
    else if (periodesAnalyses != null)
    {
      constituantsIndemnisation = TraitementPeriodesAnalyses.traitementDesPeriodesAnalyses(attribution, ut, facadeCalculProduit, constituantsIndemnisation, periodesAnalyses, qualificationPeriodes, arretProduitAvecRaison, contexteUT, periodesPriseEnCompte);
    }
    facadeCalculProduit.controleActiviteReduiteMaintienEuropeen(attribution, ut, arretProduitAvecRaison, constituantsIndemnisation);
    
    constituantsCalculActiviteReduite = facadeCalculProduit.miseAJourCumulAR(ut, attribution, constituantsCalculActiviteReduite, contexteUT, arretProduitAvecRaison);
    
    constituantsCalculActiviteReduite = facadeCalculProduit.miseAJourCumulActivite(ut, attribution, constituantsCalculActiviteReduite, contexteUT);
    ut.setConstituantsCalculActiviteReduiteEnFinUT(constituantsCalculActiviteReduite);
    ut.setConstituantsIndemnisationEnFinUT(constituantsIndemnisation);
    facadeCalculProduit.controlerAPosterioriContexteUT(attribution, contexteUT, ut, arretProduitAvecRaison);
    
    controleEtTraitementArretProduit(attribution, ut, arretProduitAvecRaison);
    
    return ut;
  }
  
  private static void controleEtTraitementArretProduit(AttributionSpec attribution, UniteTraitement ut, ArretProduitAvecRaison arretProduitAvecRaison)
  {
    if (arretProduitAvecRaison.isProduitAArreter())
    {
      ut.setProduitATerminerApresUT(true);
      ut.setArretProduitAvecRaison(arretProduitAvecRaison);
      
      ArrayList<?> listSommes = (ArrayList)ut.getCollectionSommes();
      for (int i = listSommes.size() - 1; i >= 0; i--)
      {
        Somme somme = (Somme)listSommes.get(i);
        if (somme.getDateDebut().estApresOuCoincideAvec(arretProduitAvecRaison.recupereLendemainDateArret())) {
          listSommes.remove(i);
        }
      }
      controleDTAT3SurEpuissement(attribution, arretProduitAvecRaison);
    }
  }
  
  private static void controleDTAT3SurEpuissement(AttributionSpec attribution, ArretProduitAvecRaison arretProduitAvecRaison)
  {
    if (((arretProduitAvecRaison.isRaisonsContientRaison(1)) || (arretProduitAvecRaison.isRaisonsContientRaison(2))) && (attribution.getDemandeur().getIndividuPbjcNcp() != null)) {
      attribution.getDemandeur().getIndividuPbjcNcp().setDateAtteinteMoisNonPaye(null);
    }
  }
  
  private static boolean nestPasPostDJA(AttributionSpec attribution, UniteTraitement ut)
  {
    return (attribution.getDemandeur().getDernierJourAtteste() != null) && (ut.getDateDebut().estAvantOuCoincideAvec(attribution.getDemandeur().getDernierJourAtteste()));
  }
  
  private static void detectionDRV(AttributionSpec attribution, FacadeCalculProduitPeriodiqueSpec facadeCalculProduit, ContexteUT contexteUT, CalendrierExecutionCalculPeriodique calendrier, UniteTraitement ut, ConstituantsIndemnisation constituantsIndemnisation, QualificationPeriodes qualificationPeriodes, ChronologiePeriodes periodesAnalyses, ArretProduitAvecRaison arretProduitAvecRaison, PeriodesPriseEnCompte periodesPriseEnCompte)
    throws ApplicativeException
  {
    if ((nestPasPostDJA(attribution, ut)) && (ut.isNeutralisee()) && (ut.getTypeNeutralisation() == 11) && (periodesAnalyses != null))
    {
      boolean quantiteIndemniseeSurPaTrouvee = simulationTraitementPA(attribution, facadeCalculProduit, contexteUT, ut, constituantsIndemnisation, qualificationPeriodes, periodesAnalyses, arretProduitAvecRaison, periodesPriseEnCompte);
      if (quantiteIndemniseeSurPaTrouvee)
      {
        traitementDrv(attribution, facadeCalculProduit, calendrier, ut, arretProduitAvecRaison);
      }
      else
      {
        ut.setNeutralisee(false);
        ut.setTypeNeutralisation(9);
      }
    }
  }
  
  private static void traitementDrv(AttributionSpec attribution, FacadeCalculProduitPeriodiqueSpec facadeCalculProduit, CalendrierExecutionCalculPeriodique calendrier, UniteTraitement ut, ArretProduitAvecRaison arretProduitAvecRaison)
  {
    if (calendrier.getDateDrv() == null)
    {
      calendrier.setDateDrv(ut.getDateDebut());
      calendrier.setDernierJourIndemnisablePourSuivi(ut.getDateDebut().veille());
      if (arretProduitAvecRaison.getPeriodesInterruptivesDefinitives().isEmpty()) {
        arretProduitAvecRaison.ajoutePeriodeInterruptiveDefinitive(new ObjetChronoPeriodeTest(ut.getDateFin(), ut.getDateFin()));
      }
    }
    if ((calendrier.getDateDrv() != null) && (calendrier.getDateDrv().coincideAvec(ut.getDateDebut()))) {
      ut.ajouterEvenement(new EvenementDRV(ut.getDateDebut()));
    }
    FiltreDemandePourERE filtreDemandePourERE = new FiltreDemandePourERE("ASU_27");
    if ((OutilRecherche.rechercherDecisionsSuivantes(attribution.getDemandeur().getChronoDemandeAssurance(), ut.getDateDebut(), filtreDemandePourERE).estVide()) && (GestionSuivi.retourneEnqueteEnPersistance(attribution.getDemandeur().getListEnquetesPbjcNcp(), Integer.parseInt(attribution.getRsod()), 37, retourneRangDrv(attribution)) == null)) {
      GestionSuivi.enregistrerEnquetePbjcNcp(attribution, ut.getDateDebut(), 37, retourneRangDrv(attribution), true, null, facadeCalculProduit, null);
    }
  }
  
  protected static void detectionPASSS(AttributionSpec attribution, FacadeCalculProduitPeriodiqueSpec facadeCalculProduit, ContexteUT contexteUT, UniteTraitement ut, ConstituantsIndemnisation constituantsIndemnisation, QualificationPeriodes qualificationPeriodes, ChronologiePeriodes periodesAnalyses, ArretProduitAvecRaison arretProduitAvecRaison, PeriodesPriseEnCompte periodesPriseEnCompte)
    throws ApplicativeException
  {
    if ((estEligiblePasss(attribution, facadeCalculProduit, ut, periodesAnalyses)) && (verificationForcageNonApplique(attribution, ut)) && (verifierPresencePasss(ut, qualificationPeriodes)))
    {
      boolean quantiteIndemniseeSurPaTrouvee = simulationTraitementPA(attribution, facadeCalculProduit, contexteUT, ut, constituantsIndemnisation, qualificationPeriodes, periodesAnalyses, arretProduitAvecRaison, periodesPriseEnCompte);
      if (quantiteIndemniseeSurPaTrouvee) {
        neutraliseUt(ut, 12);
      }
    }
  }
  
  private static boolean estEligiblePasss(AttributionSpec attribution, FacadeCalculProduitPeriodiqueSpec facadeCalculProduit, UniteTraitement ut, ChronologiePeriodes periodesAnalyses)
  {
    return (nestPasPostDJA(attribution, ut)) && (utNonNeutraliseEtPaPresente(ut, periodesAnalyses)) && (facadeCalculProduit.verifierTraitementPasss(attribution));
  }
  
  private static boolean verificationForcageNonApplique(AttributionSpec attribution, UniteTraitement ut)
  {
    boolean res = true;
    boolean estNeutralisePasssForce = GestionForcage.appliquerForcageEstNeutralisePasss(attribution.getDemande(), ut);
    boolean estTypeNeutralisationPasss = GestionForcage.appliquerForcageTypeNeutralisationPASSS(attribution.getDemande(), ut);
    if ((!estNeutralisePasssForce) && (estTypeNeutralisationPasss))
    {
      res = false;
    }
    else if ((estNeutralisePasssForce) && (estTypeNeutralisationPasss))
    {
      neutraliseUt(ut, 12);
      res = false;
    }
    return res;
  }
  
  private static void neutraliseUt(UniteTraitement ut, int typeNeutralisation)
  {
    ut.setNeutralisee(true);
    ut.setTypeNeutralisation(typeNeutralisation);
  }
  
  private static boolean utNonNeutraliseEtPaPresente(UniteTraitement ut, ChronologiePeriodes periodesAnalyses)
  {
    return (!ut.isNeutralisee()) && (periodesAnalyses != null);
  }
  
  private static boolean simulationTraitementPA(AttributionSpec attribution, FacadeCalculProduitPeriodiqueSpec facadeCalculProduit, ContexteUT contexteUT, UniteTraitement ut, ConstituantsIndemnisation constituantsIndemnisation, QualificationPeriodes qualificationPeriodes, ChronologiePeriodes periodesAnalyses, ArretProduitAvecRaison arretProduitAvecRaison, PeriodesPriseEnCompte periodesPriseEnCompte)
    throws ApplicativeException
  {
    boolean quantiteIndemniseeSurPaTrouvee = false;
    
    ConstituantsIndemnisation copieConstituantsIndemnisation = (ConstituantsIndemnisation)constituantsIndemnisation.copie();
    ArretProduitAvecRaison copieArretProduitAvecRaison = (ArretProduitAvecRaison)arretProduitAvecRaison.copie();
    UniteTraitement utCopie = (UniteTraitement)ut.copie();
    ChronologiePeriodes chronoPeriodeDecalanteCopie = new ChronologiePeriodes();
    Iterator ite = ut.getChronoPeriodeDecalante().iterer();
    while (ite.hasNext())
    {
      ObjetChronoPeriodeCalcul periodeCalcul = (ObjetChronoPeriodeCalcul)ite.next();
      chronoPeriodeDecalanteCopie.ajouter(periodeCalcul);
    }
    utCopie.getChronoPeriodeDecalante().ajouter(chronoPeriodeDecalanteCopie);
    TraitementPeriodesAnalyses.traitementDesPeriodesAnalyses(attribution, utCopie, facadeCalculProduit, copieConstituantsIndemnisation, periodesAnalyses, qualificationPeriodes, copieArretProduitAvecRaison, contexteUT, periodesPriseEnCompte);
    if (!periodesAnalyses.estVide())
    {
      periodesAnalyses.iterer();
      while (periodesAnalyses.encoreSuivant())
      {
        PeriodeAnalyseSpec pa = (PeriodeAnalyseSpec)periodesAnalyses.elementSuivant();
        if (pa.getQuantiteIndemnisee().getValeurEntiere() > 0)
        {
          quantiteIndemniseeSurPaTrouvee = true;
          pa.setQuantiteIndemnisable(new Quantite(0, pa.getUniteParDefautQuantites()));
          pa.setQuantiteIndemnisee(new Quantite(0, pa.getUniteParDefautQuantites()));
        }
        pa.setQuantiteNonIndemnisee(new Quantite(0, pa.getUniteParDefautQuantites()));
      }
    }
    ut.setQuantiteIndemnisable(new Quantite(0, ut.getUniteParDefautQuantites()));
    ut.setQuantiteNonIndemnisee(ut.getQuantiteIndemnisable());
    return quantiteIndemniseeSurPaTrouvee;
  }
  
  private static ConstituantsIndemnisation traitementUtNeutralise(AttributionSpec attribution, FacadeCalculProduitPeriodiqueSpec facadeCalculProduit, ContexteUT contexteUT, PeriodesPriseEnCompte periodesPriseEnCompte, Damj dateFin, UniteTraitement ut, ConstituantsIndemnisation constituantsIndemnisation, QualificationPeriodes qualificationPeriodes, ChronologiePeriodes periodesAnalyses, ArretProduitAvecRaison arretProduitAvecRaison)
    throws ApplicativeException
  {
    Damj dateFinTmp = dateFin;
    ConstituantsIndemnisation constituantsIndemnisationTmp = constituantsIndemnisation;
    
    ut.setQuantiteIndemnisable(facadeCalculProduit.getQuantiteIndemnisableTheorique(ut.getPeriode(), attribution, constituantsIndemnisationTmp, contexteUT));
    
    ut.setQuantiteNonIndemnisee(ut.getQuantiteIndemnisable());
    ChronologiePeriodes chronoPeriodesSegmentantes = qualificationPeriodes.getPeriodesSegmentantes();
    
    Damj dateReval = ut.getDateDebut();
    if ((attribution.getPji() != null) && (attribution.getPji().estContenueDans(ut.getPeriode()))) {
      dateReval = attribution.getPji();
    }
    constituantsIndemnisationTmp = facadeCalculProduit.miseAJourConstituantsIndemnisation(ut, attribution, constituantsIndemnisation, dateReval, new Periode(dateReval, dateReval.getFinMois()));
    if (!periodesAnalyses.estVide())
    {
      periodesAnalyses.iterer();
      while (periodesAnalyses.encoreSuivant())
      {
        PeriodeAnalyseSpec pa = (PeriodeAnalyseSpec)periodesAnalyses.elementSuivant();
        dateFinTmp = traiterPeriodeSurUtNeutralisee(attribution, facadeCalculProduit, periodesPriseEnCompte, constituantsIndemnisationTmp, ut, pa, arretProduitAvecRaison, chronoPeriodesSegmentantes, periodesAnalyses);
      }
    }
    dateFinTmp = traiterPeriodeSurUtNeutralisee(attribution, facadeCalculProduit, periodesPriseEnCompte, constituantsIndemnisationTmp, ut, null, arretProduitAvecRaison, chronoPeriodesSegmentantes, periodesAnalyses);
    if (dateFinTmp.estApresOuCoincideAvec(ut.getDateDebut()))
    {
      Quantite qteDecalageDuree = ut.getCreditDecalageDuree();
      if (qteDecalageDuree != null)
      {
        qteDecalageDuree = qteDecalageDuree.soustraire(new Quantite(dateFinTmp.joursEntre(ut.getDateDebut()) + 1, qteDecalageDuree.getUnite()));
        if (qteDecalageDuree.getValeurEntiere() > 0) {
          ut.setCreditDecalageDureeEnFinUT(qteDecalageDuree);
        }
      }
    }
    return constituantsIndemnisationTmp;
  }
  
  private static boolean verifierPresencePasss(UniteTraitement ut, QualificationPeriodes qualificationPeriodes)
  {
    ObjetChronoPeriodeCalcul periode = null;
    Iterator iterator = null;
    iterator = qualificationPeriodes.getPeriodesNonQualifiees().iterer();
    while (iterator.hasNext())
    {
      periode = (ObjetChronoPeriodeCalcul)iterator.next();
      if (((periode instanceof PeriodeActiviteSalarieSansSalaire)) && (periode.chevauche(ut.getPeriode()))) {
        return true;
      }
    }
    return false;
  }
  
  private static ChronologiePeriodes creerLesPeriodesAnalyses(UniteTraitement ut, QualificationPeriodes qualificationPeriodes, PeriodesPriseEnCompte periodesPriseEnCompte)
    throws CoucheLogiqueException
  {
    ChronologiePeriodes periodesAnalyses = null;
    if (periodesAnalyses == null)
    {
      Iterator iterator = null;
      ChronologiePeriodes chronologie = null;
      ObjetChronoPeriode objetChronoPeriode = null;
      Periode periode = null;
      
      iterator = periodesPriseEnCompte.getPeriodesParTypologie(3).iterer();
      chronologie = new ChronologiePeriodes();
      while (iterator.hasNext())
      {
        objetChronoPeriode = (ObjetChronoPeriode)iterator.next();
        periode = new Periode(objetChronoPeriode.getDateDebut(), objetChronoPeriode.getDateFin());
        chronologie.ajouter((ChronologiePeriodes)qualificationPeriodes.getPeriodesSegmentantes().copier(new FiltreDebutDansBornes(periode)));
      }
      iterator = periodesPriseEnCompte.getPeriodesParTypologie(3).iterer();
      ChronologiePeriodes chronologiePeriodesAnalyses = new ChronologiePeriodes();
      while (iterator.hasNext())
      {
        objetChronoPeriode = (ObjetChronoPeriode)iterator.next();
        periode = new Periode(objetChronoPeriode.getDateDebut(), objetChronoPeriode.getDateFin());
        if (periode.getFin().estApresOuCoincideAvec(periode.getDebut())) {
          chronologiePeriodesAnalyses.ajouter(TraitementPeriodes.traitementPeriodesSegmentantes(periode, ut, chronologie));
        }
      }
      periodesAnalyses = chronologiePeriodesAnalyses;
    }
    return periodesAnalyses;
  }
  
  private static void effectuerTraitementActiviteReduite(AttributionSpec attribution, FacadeCalculProduitPeriodiqueSpec facadeCalculProduit, ConstituantsCalculActiviteReduiteSpec constituantsCalculActiviteReduite, Periode periodeUT, ContexteUT contexteUT, UniteTraitement ut, QualificationPeriodes qualificationPeriodes, ArretProduitAvecRaison arretProduitAvecRaison, ConstituantsIndemnisation constituantsIndemnisation)
    throws CoucheLogiqueException
  {
    DemandeSpec demande = attribution.getDemande();
    if ((periodeUT.contient(attribution.getDateEffet())) && ((attribution instanceof RepriseSpec)) && (attribution.getGamme().getNomUnique().equals("SOL")))
    {
      CritereStrategie critereStrategie = new CritereStrategie();
      critereStrategie.setDatePivot(ut.getDateDebut());
      StrategieReglesArSurCiPuisRepriseSpec strategieReglesArSurCiPuisRepriseCourante = (StrategieReglesArSurCiPuisRepriseSpec)FabriqueStrategieReglesArSurCiPuisReprise.getInstance().getStrategie(critereStrategie);
      if (strategieReglesArSurCiPuisRepriseCourante.estApplicable())
      {
        effectuerTraitementPeriodesActiviteReduite(attribution, facadeCalculProduit, constituantsCalculActiviteReduite, ut, qualificationPeriodes, arretProduitAvecRaison, contexteUT, constituantsIndemnisation);
      }
      else
      {
        int neutralisation = rechercherNeutralisation(attribution, contexteUT);
        Decalage reliquatDecalage = rechercherReliquatDecalage(attribution, facadeCalculProduit, ut, contexteUT);
        if ((neutralisation > 0) || (reliquatDecalage != null))
        {
          ut.setDecalageEnDebutUT(reliquatDecalage);
          ut.setNeutralisee(neutralisation >= 0);
          ut.setTypeNeutralisation(neutralisation);
          ut.setStatut(rechercherStatutUt(attribution, contexteUT));
          
          boolean estContexteContinuiteEtReprise = verifierContexteContinuiteEtReprise(attribution, contexteUT);
          if ((!contexteUT.isTravailSurUt(attribution, facadeCalculProduit)) && (!estContexteContinuiteEtReprise)) {
            facadeCalculProduit.incrementationNbMoisInactivite(constituantsCalculActiviteReduite);
          }
        }
        else
        {
          effectuerTraitementPeriodesActiviteReduite(attribution, facadeCalculProduit, constituantsCalculActiviteReduite, ut, qualificationPeriodes, arretProduitAvecRaison, contexteUT, constituantsIndemnisation);
        }
      }
    }
    else if ((periodeUT.contient(attribution.getDateEffet())) && ((attribution instanceof RenouvellementSpec)))
    {
      AttributionSpec attributionPrecedente = null;
      if (((RenouvellementSpec)attribution != null) && (((RenouvellementSpec)attribution).getDossierAffecte() != null))
      {
        Chronologie chrono = demande.getDemandeur().getChronoDemandeSolidarite();
        chrono.supprimer(demande);
        FiltreET filtre = new FiltreET();
        filtre.ajouterFiltre(new FiltreAttributionSurDecisions(true));
        if (((RenouvellementSpec)attribution).getDossierAffecte().getProduit().getCode() == ProduitSolCge01P01.getInstance().getCode())
        {
          filtre.ajouterFiltre(new FiltreDecisionPourProduit(9));
          attributionPrecedente = (AttributionSpec)OutilRecherche.rechercherDecisionPrecedente(chrono, attribution.getDateExamen().lendemain(), filtre);
        }
        else if (((RenouvellementSpec)attribution).getDossierAffecte().getProduit().getCode() == ProduitSolCpa02P01.getInstance().getCode())
        {
          filtre.ajouterFiltre(new FiltreDecisionPourProduit(10));
          attributionPrecedente = (AttributionSpec)OutilRecherche.rechercherDecisionPrecedente(chrono, attribution.getDateExamen().lendemain(), filtre);
        }
        else if (((RenouvellementSpec)attribution).getDossierAffecte().getProduit().getCode() == ProduitSolAta06P01.getInstance().getCode())
        {
          filtre.ajouterFiltre(new FiltreDecisionPourProduit(30));
          attributionPrecedente = (AttributionSpec)OutilRecherche.rechercherDecisionPrecedente(chrono, attribution.getDateExamen().lendemain(), filtre);
        }
        else if (((RenouvellementSpec)attribution).getDossierAffecte().getProduit().getCode() == ProduitSolAer05P01.getInstance().getCode())
        {
          FiltreOU filtreOu = new FiltreOU();
          filtreOu.ajouterFiltre(new FiltreDemandePourERE("SOL_08"));
          filtreOu.ajouterFiltre(new FiltreDemandePourERE("SOL_02"));
          filtre.ajouterFiltre(filtreOu);
          attributionPrecedente = (AttributionSpec)OutilRecherche.rechercherDecisionPrecedente(chrono, attribution.getDateExamen().lendemain(), filtre);
        }
      }
      if ((attributionPrecedente != null) && (periodeUT.contient(attributionPrecedente.getCalendrierExecutionCalcul().getDernierJourIndemnisable())))
      {
        ut.setStatut(rechercherStatutUt(attribution, contexteUT));
        return;
      }
      effectuerTraitementPeriodesActiviteReduite(attribution, facadeCalculProduit, constituantsCalculActiviteReduite, ut, qualificationPeriodes, arretProduitAvecRaison, contexteUT, constituantsIndemnisation);
    }
    else
    {
      effectuerTraitementPeriodesActiviteReduite(attribution, facadeCalculProduit, constituantsCalculActiviteReduite, ut, qualificationPeriodes, arretProduitAvecRaison, contexteUT, constituantsIndemnisation);
    }
  }
  
  private static void effectuerTraitementPeriodesActiviteReduite(AttributionSpec attribution, FacadeCalculProduitPeriodiqueSpec facadeCalculProduit, ConstituantsCalculActiviteReduiteSpec constituantsCalculActiviteReduite, UniteTraitement ut, QualificationPeriodes qualificationPeriodes, ArretProduitAvecRaison arretProduitAvecRaison, ContexteUT contexteUT, ConstituantsIndemnisation constituantsIndemnisation)
    throws CoucheLogiqueException
  {
    facadeCalculProduit.determinerStatutUT(attribution, qualificationPeriodes.getPeriodesDecalantes(), constituantsCalculActiviteReduite, ut, arretProduitAvecRaison, contexteUT);
    
    ChronologiePeriodes periodeDecalantes = qualificationPeriodes.getPeriodesDecalantes();
    
    Chronologie chronoPeriodeCESDecal = periodeDecalantes.copier(new FiltrePeriodeTravailCalculCES());
    Chronologie chronoPeriodeCESForfaitDecal = periodeDecalantes.copier(new FiltrePeriodeTravailCalculCESForfait());
    if ((!chronoPeriodeCESForfaitDecal.estVide()) && (chronoPeriodeCESDecal.getTaille() != chronoPeriodeCESForfaitDecal.getTaille())) {
      periodeDecalantes = (ChronologiePeriodes)periodeDecalantes.copier(new FiltrePeriodeTravailCalculHorsCESForfait());
    }
    ChronologiePeriodes periodeGelantes = qualificationPeriodes.getPeriodesGelantes();
    
    Chronologie chronoPeriodeCESGel = periodeGelantes.copier(new FiltrePeriodeTravailCalculCES());
    Chronologie chronoPeriodeCESForfaitGel = periodeGelantes.copier(new FiltrePeriodeTravailCalculCESForfait());
    if ((!chronoPeriodeCESForfaitGel.estVide()) && (chronoPeriodeCESGel.getTaille() != chronoPeriodeCESForfaitGel.getTaille())) {
      periodeGelantes = (ChronologiePeriodes)periodeGelantes.copier(new FiltrePeriodeTravailCalculHorsCESForfait());
    }
    TraitementPeriodes.traitementPeriodesGelantes(facadeCalculProduit, attribution, periodeGelantes, constituantsCalculActiviteReduite, ut);
    
    TraitementPeriodes.traitementPeriodesDecalantes(facadeCalculProduit, attribution, periodeDecalantes, constituantsCalculActiviteReduite, ut, constituantsIndemnisation, contexteUT);
    if ((!attribution.getGamme().getNomUnique().equals("INR")) || (attribution.getProduit().getNomUnique().equals("INR_CES06_01"))) {
      if (ut.isNeutralisee())
      {
        if ((ut.getTypeNeutralisation() == 1) || (ut.getTypeNeutralisation() == 0) || (ut.getTypeNeutralisation() == 2) || (ut.getTypeNeutralisation() == 6) || (ut.getTypeNeutralisation() == 7) || (ut.getTypeNeutralisation() == 3)) {
          if (GestionForcage.appliquerForcageCreditDecalage(attribution.getDemande(), ut))
          {
            ut.setNeutralisee(false);
            
            miseAJourSyntheseUTSuiteForcage(ut);
          }
        }
      }
      else if ((facadeCalculProduit.verifierApplicationForcageSurUT(ut, attribution)) && (GestionForcage.appliquerForcageCreditDecalage(attribution.getDemande(), ut))) {
        miseAJourSyntheseUTSuiteForcage(ut);
      }
    }
    if ((attribution.getProduit().getNomUnique().equals("ASU_CGE01_02")) && (attribution.getDemande().estMigree())) {
      GestionForcage.appliquerForcageCreditDecalagePNDS(attribution.getDemande(), ut);
    }
    if ((attribution.getDemande() != null) && (attribution.getDemande().estMigree()))
    {
      GestionForcage.appliquerForcageEstNeutralise(attribution.getDemande(), ut);
      GestionForcage.appliquerForcageTypeNeutralisation(attribution.getDemande(), ut);
    }
    if (attribution.getProduit().getNomUnique().equals("ASU_MAY17_02")) {
      GestionForcage.appliquerForcageCumulARSurUt(attribution.getDemande(), ut, constituantsCalculActiviteReduite);
    }
    if (((attribution.getGamme().getNomUnique().equals("SOL")) || (attribution.getGamme().getNomUnique().equals("ASU"))) && (periodeDecalantes.getTaille() == 0))
    {
      ObjetChronoPeriodePriseEnChargeSansFiltre pecEnDebutUT = OutillagePEC.getPeriodePECContenant(attribution.getDemandeur(), Damj.max(attribution.getDateAttribution(), ut.getDateDebut()));
      if (pecEnDebutUT != null)
      {
        CritereStrategie critereAnomalieM09CUICACIRMA = new CritereStrategie();
        critereAnomalieM09CUICACIRMA.setDatePivot(pecEnDebutUT.getDateDebut());
        
        StrategiePECCACIRMAetCUISpec strategiecritereAnomalieM09CUICACIRMA = (StrategiePECCACIRMAetCUISpec)FabriqueStrategiePECCACIRMAetCUI.getInstance().getStrategie(critereAnomalieM09CUICACIRMA);
        
        strategiecritereAnomalieM09CUICACIRMA.ajouterAnomalieM09(pecEnDebutUT, ut.getDateFin(), attribution.getDemandeur());
      }
    }
  }
  
  private static Chronologie getPeriodeAbsenceAuPointage(ChronologiePeriodes periodes)
  {
    ChronologiePeriodes periodesAbsenceAuPointage = new ChronologiePeriodes();
    periodes.iterer();
    while (periodes.encoreSuivant())
    {
      ObjetChronoPeriodeCalcul objetChronoPeriode = (ObjetChronoPeriodeCalcul)periodes.elementSuivant();
      if ((objetChronoPeriode instanceof PeriodeAbsenceAuPointage)) {
        periodesAbsenceAuPointage.ajouter(objetChronoPeriode);
      }
    }
    return periodesAbsenceAuPointage;
  }
  
  private static QualificationPeriodes qualifierPeriodes(AttributionSpec attribution, FacadeCalculProduitPeriodiqueSpec facadeCalculProduit, ContexteUT contexteUT, ChronologiePeriodes periodesAQualifier)
    throws CoucheLogiqueException
  {
    QualificationPeriodes qualificationPeriodes = null;
    
    facadeCalculProduit.miseAjourPeriodeAV(periodesAQualifier, attribution.getDemandeur());
    
    qualificationPeriodes = facadeCalculProduit.qualificationPeriodes(periodesAQualifier, attribution, contexteUT);
    
    forcerQualificationPeriodesCalcul(periodesAQualifier, qualificationPeriodes);
    
    return qualificationPeriodes;
  }
  
  private static void forcerQualificationPeriodesCalcul(ChronologiePeriodes periodes, QualificationPeriodes qualificationPeriodes)
  {
    ObjetChronoPeriodeCalcul periode = null;
    ListIterator iterator = null;
    
    iterator = periodes.iterer();
    while (iterator.hasNext())
    {
      periode = (ObjetChronoPeriodeCalcul)iterator.next();
      if ((periode instanceof ObjetChronoPeriodeArretCalcul)) {
        qualificationPeriodes.ajouterPeriodesInterruptivesDefinitives(periode);
      }
    }
  }
  
  private static ArretProduitAvecRaison effectuerTraitementPeriodes(AttributionSpec attribution, FacadeCalculProduitPeriodiqueSpec facadeCalculProduit, UniteTraitement ut, ContexteUT contexteUT, PeriodesPriseEnCompte periodesPriseEnCompte, CalendrierExecutionCalculPeriodique calendrier)
    throws CoucheLogiqueException
  {
    QualificationPeriodes qualificationPeriodes = ut.getQualificationPeriodes();
    
    filtrerPeriodesPourUneTypologie(1, qualificationPeriodes, periodesPriseEnCompte);
    filtrerPeriodesPourUneTypologie(2, qualificationPeriodes, periodesPriseEnCompte);
    
    facadeCalculProduit.mettreAjourDateFinDispositif(attribution, ut, calendrier, qualificationPeriodes);
    
    ArretProduitAvecRaison arretProduitAvecRaison = TraitementPeriodes.traitementPeriodesInterruptivesDefinitives(periodesPriseEnCompte, ut, attribution, facadeCalculProduit, calendrier);
    
    TraitementPeriodes.traitementPeriodesInterruptives(periodesPriseEnCompte, qualificationPeriodes.getPeriodesInterruptives());
    
    facadeCalculProduit.filtrePriseEnComptePeriodesActiviteSurUT(periodesPriseEnCompte, ut.getPeriode(), contexteUT, attribution);
    
    filtrerPeriodesParTypologie(qualificationPeriodes, periodesPriseEnCompte);
    
    decouperEtProratiserPeriodes(facadeCalculProduit, ut.getPeriode(), qualificationPeriodes, periodesPriseEnCompte);
    
    return arretProduitAvecRaison;
  }
  
  private static void decouperEtProratiserPeriodes(FacadeCalculProduitPeriodiqueSpec facadeCalculProduit, Periode periodeUT, QualificationPeriodes qualificationPeriodes, PeriodesPriseEnCompte periodesPriseEnCompte)
    throws CoucheLogiqueException
  {
    Iterator iterator = null;
    ChronologiePeriodes chronologie = null;
    ObjetChronoPeriode objetChronoPeriode = null;
    Periode periode = null;
    ChronologiePeriodes chronologiePeriodesDecalantes = null;
    ChronologiePeriodes chronologiePeriodesGelantes = null;
    
    chronologiePeriodesDecalantes = new ChronologiePeriodes();
    chronologiePeriodesGelantes = new ChronologiePeriodes();
    
    iterator = periodesPriseEnCompte.getPeriodesParTypologie(6).iterer();
    chronologie = new ChronologiePeriodes();
    while (iterator.hasNext())
    {
      objetChronoPeriode = (ObjetChronoPeriode)iterator.next();
      periode = new Periode(objetChronoPeriode.getDateDebut(), objetChronoPeriode.getDateFin());
      
      chronologie.ajouter(PeriodeProratisationFactory.decoupeEtProratiseParDefaut(qualificationPeriodes.getPeriodesSuspensives(), periode));
    }
    qualificationPeriodes.setPeriodesSuspensives(chronologie);
    
    chronologiePeriodesGelantes.ajouter(getPeriodeAbsenceAuPointage(qualificationPeriodes.getPeriodesGelantes()));
    
    chronologiePeriodesDecalantes.ajouter(facadeCalculProduit.decoupageEtProratisationPeriodesActivites(periodesPriseEnCompte, 5, qualificationPeriodes.getPeriodesDecalantes(), periodeUT));
    
    chronologiePeriodesGelantes.ajouter(PeriodeProratisationFactory.decoupeEtProratiseParType(qualificationPeriodes.getPeriodesGelantes(), periodeUT));
    
    qualificationPeriodes.setPeriodesDecalantes(chronologiePeriodesDecalantes);
    qualificationPeriodes.setPeriodesGelantes(chronologiePeriodesGelantes);
  }
  
  private static void filtrerPeriodesParTypologie(QualificationPeriodes qualificationPeriodes, PeriodesPriseEnCompte periodesPriseEnCompte)
    throws CoucheLogiqueException
  {
    Iterator iterator = QualificationPeriodes.getTypesList().iterator();
    while (iterator.hasNext())
    {
      int periodeType = ((Integer)iterator.next()).intValue();
      ChronologiePeriodes chronologie = new ChronologiePeriodes();
      
      Iterator it = periodesPriseEnCompte.getPeriodesParTypologie(periodeType).iterer();
      while (it.hasNext())
      {
        ObjetChronoPeriode objetChronoPeriode = (ObjetChronoPeriode)it.next();
        Periode periode = new Periode(objetChronoPeriode.getDateDebut(), objetChronoPeriode.getDateFin());
        ChronologiePeriodes chronoAAjouter = (ChronologiePeriodes)qualificationPeriodes.getPeriodesParTypologie(periodeType).copier(new FiltreChevauchePeriode(periode));
        
        Iterator itChronoAAjouter = chronoAAjouter.iterer();
        while (itChronoAAjouter.hasNext())
        {
          Temporel temporel = (Temporel)itChronoAAjouter.next();
          if (!chronologie.contientElement(temporel)) {
            chronologie.ajouter(temporel);
          }
        }
      }
      qualificationPeriodes.setPeriodesParTypologie(periodeType, chronologie);
    }
  }
  
  private static void filtrerPeriodesPourUneTypologie(int periodeType, QualificationPeriodes qualificationPeriodes, PeriodesPriseEnCompte periodesPriseEnCompte)
    throws CoucheLogiqueException
  {
    ChronologiePeriodes chronologie = new ChronologiePeriodes();
    
    Iterator it = periodesPriseEnCompte.getPeriodesParTypologie(periodeType).iterer();
    while (it.hasNext())
    {
      ObjetChronoPeriode objetChronoPeriode = (ObjetChronoPeriode)it.next();
      Periode periode = new Periode(objetChronoPeriode.getDateDebut(), objetChronoPeriode.getDateFin());
      ChronologiePeriodes chronoAAjouter = (ChronologiePeriodes)qualificationPeriodes.getPeriodesParTypologie(periodeType).copier(new FiltreChevauchePeriode(periode));
      
      Iterator itChronoAAjouter = chronoAAjouter.iterer();
      while (itChronoAAjouter.hasNext())
      {
        Temporel temporel = (Temporel)itChronoAAjouter.next();
        if (!chronologie.contientElement(temporel)) {
          chronologie.ajouter(temporel);
        }
      }
    }
    qualificationPeriodes.setPeriodesParTypologie(periodeType, chronologie);
  }
  
  private static void affectationConstituantsIndemnisation(ConstituantsIndemnisation constituantsIndemnisation, UniteTraitement ut)
  {
    ut.setConstituantsIndemnisationEnDebutUT((ConstituantsIndemnisation)constituantsIndemnisation.copie());
  }
  
  private static void affectationConstituantsCalculActiviteReduite(ConstituantsCalculActiviteReduiteSpec constituantsCalculActiviteReduite, UniteTraitement ut)
  {
    if (constituantsCalculActiviteReduite != null) {
      ut.setConstituantsCalculActiviteReduiteEnDebutUT((ConstituantsCalculActiviteReduiteSpec)constituantsCalculActiviteReduite.copie());
    }
  }
  
  private static ConstituantsIndemnisation majConstituantsIndemnisation(ConstituantsIndemnisation constituantsIndem)
  {
    ConstituantsIndemnisation constituantsIndemnisation = null;
    constituantsIndemnisation = (ConstituantsIndemnisation)constituantsIndem.copie();
    return constituantsIndemnisation;
  }
  
  private static ConstituantsCalculActiviteReduiteSpec majConstituantsCalculActiviteReduite(ConstituantsCalculActiviteReduiteSpec constituantsCalculActReduite, UniteTraitement ut, AttributionSpec attribution, FacadeCalculProduitPeriodiqueSpec facadeCalculProduit, ConstituantsIndemnisation constituantsIndemnisation)
    throws CoucheLogiqueException
  {
    ConstituantsCalculActiviteReduiteSpec constituantsCalculActiviteReduite = null;
    if (constituantsCalculActReduite != null)
    {
      constituantsCalculActiviteReduite = (ConstituantsCalculActiviteReduiteSpec)constituantsCalculActReduite.copie();
      if (ut.getDateDebut().estAvant(attribution.getPji())) {
        constituantsCalculActiviteReduite = facadeCalculProduit.miseAjourConstituantsCalculActiviteReduite(attribution, constituantsCalculActiviteReduite, attribution.getPji(), constituantsIndemnisation);
      } else {
        constituantsCalculActiviteReduite = facadeCalculProduit.miseAjourConstituantsCalculActiviteReduite(attribution, constituantsCalculActiviteReduite, ut.getDateDebut(), constituantsIndemnisation);
      }
    }
    return constituantsCalculActiviteReduite;
  }
  
  private static FormuleMontantSpec recupererFormuleMontant(AttributionSpec attribution, ConstituantsIndemnisation constituantsIndemnisation)
  {
    QuantiteIndemnisationSpec quantiteIndemnisation = null;
    FormuleMontantSpec formuleMontant = null;
    
    quantiteIndemnisation = OutillageQuantites.recupererPremiereQuantiteIndemnisationActive(constituantsIndemnisation.getCollectionQuantiteDroit());
    if (quantiteIndemnisation != null)
    {
      formuleMontant = attribution.getFormuleMontant(quantiteIndemnisation.getCodeFormuleMontant());
    }
    else if (attribution.getGamme().getNomUnique().equals("RBF"))
    {
      quantiteIndemnisation = OutillageQuantites.recupererPremiereQuantiteIndemnisationActiveOuEpuisee(constituantsIndemnisation.getCollectionQuantiteDroit());
      if (quantiteIndemnisation != null) {
        formuleMontant = attribution.getFormuleMontant(quantiteIndemnisation.getCodeFormuleMontant());
      }
    }
    else if (constituantsIndemnisation.getCodeFormuleMontant() != null)
    {
      formuleMontant = attribution.getFormuleMontant(constituantsIndemnisation.getCodeFormuleMontant());
    }
    return formuleMontant;
  }
  
  private static int rechercherNeutralisation(AttributionSpec attrib, ContexteUT contexteUT)
    throws CoucheLogiqueException
  {
    int neutralisation = -1;
    List candidats = null;
    Iterator iterateurDesCandidats = null;
    AttributionSpec attribution = null;
    ContexteUT.ElementContexteUT elementContexteUT = null;
    
    candidats = contexteUT.getListeOrdonneeCandidats();
    iterateurDesCandidats = candidats.iterator();
    while ((iterateurDesCandidats.hasNext()) && (neutralisation < 0))
    {
      attribution = (AttributionSpec)iterateurDesCandidats.next();
      elementContexteUT = contexteUT.getElementContexteUT(attribution);
      if ((elementContexteUT.getEtatAttribution() == 3) && (attribution.getProduit().getLigne().getGamme().equals(attrib.getProduit().getLigne().getGamme()))) {
        neutralisation = elementContexteUT.getTypeNeutralisation();
      }
    }
    return neutralisation;
  }
  
  private static int rechercherStatutUt(AttributionSpec attrib, ContexteUT contexteUT)
    throws CoucheLogiqueException
  {
    int statut = -1;
    List candidats = null;
    Iterator iterateurDesCandidats = null;
    AttributionSpec attribution = null;
    ContexteUT.ElementContexteUT elementContexteUT = null;
    
    candidats = contexteUT.getListeOrdonneeCandidats();
    iterateurDesCandidats = candidats.iterator();
    while ((iterateurDesCandidats.hasNext()) && (statut < 1))
    {
      attribution = (AttributionSpec)iterateurDesCandidats.next();
      elementContexteUT = contexteUT.getElementContexteUT(attribution);
      if ((elementContexteUT.getEtatAttribution() == 3) && (attribution.getProduit().getLigne().getGamme().equals(attrib.getProduit().getLigne().getGamme()))) {
        statut = elementContexteUT.getStatut();
      }
    }
    if (statut == -1) {
      statut = 3;
    }
    return statut;
  }
  
  private static Decalage rechercherReliquatDecalage(AttributionSpec attribution, FacadeCalculProduitPeriodiqueSpec facadeCalculProduit, UniteTraitement ut, ContexteUT contexteUT)
    throws CoucheLogiqueException
  {
    Decalage reliquatDecalage = null;
    AttributionSpec attributionPrecedente = null;
    ContexteUT.ElementContexteUT elementContexteUT = null;
    
    attributionPrecedente = facadeCalculProduit.rechercherAttributionPrecedenteSurLUT(attribution);
    if ((attributionPrecedente != null) && (contexteUT.getListeOrdonneeCandidats().contains(attributionPrecedente)))
    {
      elementContexteUT = contexteUT.getElementContexteUT(attributionPrecedente);
      if (elementContexteUT.getEtatAttribution() == 3)
      {
        reliquatDecalage = new Decalage(ut.getUniteParDefautQuantites());
        reliquatDecalage.setCreditDecalage(elementContexteUT.getReliquatDecalage());
        reliquatDecalage.setCreditDecalageDuree(elementContexteUT.getReliquatDecalageDuree());
      }
    }
    return reliquatDecalage;
  }
  
  private static UniteTraitement creerUT(Periode periodeUT, FacadeCalculProduitPeriodiqueSpec facadeCalculProduit, Quantite qteDecalageDureeEnCours, AttributionSpec attribution)
    throws CoucheLogiqueException
  {
    UniteTraitement ut = null;
    
    ut = facadeCalculProduit.creerUT(periodeUT, attribution);
    
    ut.setCollectionSommes(new ArrayList());
    ut.setCollectionEvenementsFinQuantiteDroit(new ArrayList());
    if (qteDecalageDureeEnCours != null) {
      ut.setCreditDecalageDuree(qteDecalageDureeEnCours);
    }
    return ut;
  }
  
  private static void effectuerTraitementSanctionsInterruptivesDefinitives(UniteTraitement ut, QualificationPeriodes qualificationPeriodes, IndividuSpec individu)
    throws CoucheLogiqueException
  {
    if (qualificationPeriodes.getPeriodesInterruptivesDefinitives() != null)
    {
      ChronologiePeriodes sanctionsInterruptivesDefinitives = qualificationPeriodes.getPeriodesInterruptivesDefinitives();
      sanctionsInterruptivesDefinitives.iterer();
      while (sanctionsInterruptivesDefinitives.encoreSuivant())
      {
        ObjetChronoPeriodeCalcul periodeSanctionInterruptiveDefinitive = (ObjetChronoPeriodeCalcul)sanctionsInterruptivesDefinitives.elementSuivant();
        if ((periodeSanctionInterruptiveDefinitive instanceof PeriodeExclusionDefinitiveDDTE))
        {
          if (periodeSanctionInterruptiveDefinitive.getDateDebut().estContenueDans(ut.getPeriode())) {
            ut.ajouterEvenement(new EvenementSanctionExclusionDefinitive(periodeSanctionInterruptiveDefinitive.getDateDebut(), ((PeriodeExclusionDefinitiveDDTE)periodeSanctionInterruptiveDefinitive).getCodeSanction()));
          }
        }
        else if ((periodeSanctionInterruptiveDefinitive instanceof PeriodeNonMaintienASSetATA))
        {
          if (periodeSanctionInterruptiveDefinitive.getDateDebut().estContenueDans(ut.getPeriode())) {
            ut.ajouterEvenement(new EvenementSanctionDecisionNonMaintienASSetATA(periodeSanctionInterruptiveDefinitive.getDateDebut(), ((PeriodeNonMaintienASSetATA)periodeSanctionInterruptiveDefinitive).getCodeSanction()));
          }
        }
        else if ((periodeSanctionInterruptiveDefinitive instanceof PeriodeChevauchementSanction)) {
          GestionAnomalies.ajouteAnomalie(new Anomalie("M05", periodeSanctionInterruptiveDefinitive.getDateDebut(), ""), individu);
        }
      }
    }
  }
  
  private static PeriodeSuspensionDDTEAvecImputation recupererSanctionDebutantHorsUt(AttributionSpec attribution, UniteTraitement ut, QualificationPeriodes qualificationPeriodes)
    throws CoucheLogiqueException
  {
    if (qualificationPeriodes.getPeriodesSuspensives() != null)
    {
      ChronologiePeriodes sanctions = qualificationPeriodes.getPeriodesSuspensives();
      sanctions.iterer();
      while (sanctions.encoreSuivant())
      {
        ObjetChronoPeriodeCalcul periodeSanctionAQualifier = (ObjetChronoPeriodeCalcul)sanctions.elementSuivant();
        Damj dateDebut = Damj.max(ut.getDateDebut(), attribution.getPji());
        if (((periodeSanctionAQualifier instanceof PeriodeSuspensionDDTEAvecImputation)) && (((PeriodeSuspensionDDTEAvecImputation)periodeSanctionAQualifier).getPeriodeInitiale().getDebut().estAvant(dateDebut))) {
          return (PeriodeSuspensionDDTEAvecImputation)periodeSanctionAQualifier;
        }
      }
    }
    return null;
  }
  
  private static void effectuerTraitementEvtActualisation(UniteTraitement ut, IndividuSpec individu, ChronologiePeriodes chronologiePeriodesEvtActualisation)
    throws CoucheLogiqueException
  {
    if (chronologiePeriodesEvtActualisation != null)
    {
      chronologiePeriodesEvtActualisation.iterer();
      while (chronologiePeriodesEvtActualisation.encoreSuivant())
      {
        ObjetChronoPeriodeCalcul periodeEvtActualisation = (ObjetChronoPeriodeCalcul)chronologiePeriodesEvtActualisation.elementSuivant();
        if ((periodeEvtActualisation instanceof PeriodeAbsenceRetourUL961)) {
          if (periodeEvtActualisation.getPeriode().chevauche(ut.getPeriode())) {
            ut.setAbsenceRetourUL961(true);
          }
        }
        if ((periodeEvtActualisation instanceof PeriodeEvenementBloquant)) {
          if (periodeEvtActualisation.getDateDebut().estContenueDans(ut.getPeriode())) {
            ut.ajouterEvenement(new EvenementBlocageActualisation(periodeEvtActualisation.getDateDebut(), ((PeriodeEvenementBloquant)periodeEvtActualisation).getLibelleEvtBloquant()));
          }
        }
      }
    }
    Collection donneesMoisActu = individu.getListeDonneesMoisActualisation();
    if (donneesMoisActu != null)
    {
      Iterator donneesMoisActuIterator = donneesMoisActu.iterator();
      while (donneesMoisActuIterator.hasNext())
      {
        DonneesMoisMandate donneeMoisMandate = (DonneesMoisMandate)donneesMoisActuIterator.next();
        if (new Periode(donneeMoisMandate.getDateDebut(), donneeMoisMandate.getDateFin()).chevauche(ut.getPeriode())) {
          ut.setTopCoherenceTravailA8A10(donneeMoisMandate.getTopCoherenceTravailA8A10());
        }
      }
    }
  }
  
  private static void effectuerTraitementPeriodesCaCirma(UniteTraitement ut, QualificationPeriodes qualificationPeriodes, CalendrierExecutionCalculPeriodique calendrier)
    throws CoucheLogiqueException
  {
    if (qualificationPeriodes.getPeriodesInterruptivesDefinitives() != null)
    {
      ChronologiePeriodes periodesCaCirma = new ChronologiePeriodes();
      ChronologiePeriodes periodesCaCirmaInterruptives = qualificationPeriodes.getPeriodesInterruptivesDefinitives();
      ChronologiePeriodes periodesCaCirmaSuspensives = qualificationPeriodes.getPeriodesSuspensives();
      periodesCaCirma.ajouter(periodesCaCirmaInterruptives);
      periodesCaCirma.ajouter(periodesCaCirmaSuspensives);
      periodesCaCirma.iterer();
      while (periodesCaCirma.encoreSuivant())
      {
        ObjetChronoPeriodeCalcul periodeCaCirma = (ObjetChronoPeriodeCalcul)periodesCaCirma.elementSuivant();
        if ((periodeCaCirma instanceof PeriodeContrat)) {
          if (periodeCaCirma.getDateDebut().estContenueDans(ut.getPeriode())) {
            if (!periodeCaCirma.getDateDebut().coincideAvec(ut.getDateDebut()))
            {
              if (((PeriodeContrat)periodeCaCirma).getTypeContratParticulier() == 21) {
                ut.ajouterEvenement(new EvenementSuspensionCaAss(periodeCaCirma.getDateDebut().veille()));
              }
              if (((PeriodeContrat)periodeCaCirma).getTypeContratParticulier() == 22) {
                ut.ajouterEvenement(new EvenementSuspensionCirmaAss(periodeCaCirma.getDateDebut().veille()));
              }
            }
            else if ((calendrier.getChronologieUnitesTraitements() != null) && (!calendrier.getChronologieUnitesTraitements().estVide()))
            {
              UniteTraitement utPrecedente = (UniteTraitement)calendrier.getChronologieUnitesTraitements().dernierElement();
              if (((PeriodeContrat)periodeCaCirma).getTypeContratParticulier() == 21) {
                utPrecedente.ajouterEvenement(new EvenementSuspensionCaAss(utPrecedente.getDateFin()));
              }
              if (((PeriodeContrat)periodeCaCirma).getTypeContratParticulier() == 22) {
                utPrecedente.ajouterEvenement(new EvenementSuspensionCirmaAss(utPrecedente.getDateFin()));
              }
            }
          }
        }
      }
      periodesCaCirmaInterruptives.iterer();
      while (periodesCaCirmaInterruptives.encoreSuivant())
      {
        ObjetChronoPeriodeCalcul periodeCaCirma = (ObjetChronoPeriodeCalcul)periodesCaCirmaInterruptives.elementSuivant();
        if ((periodeCaCirma instanceof PeriodeEvenementEntreeCA)) {
          if (periodeCaCirma.getDateDebut().estContenueDans(ut.getPeriode())) {
            if (!periodeCaCirma.getDateDebut().coincideAvec(ut.getDateDebut()))
            {
              ut.ajouterEvenement(new EvenementSuspensionCaAss(periodeCaCirma.getDateDebut().veille()));
            }
            else if ((calendrier.getChronologieUnitesTraitements() != null) && (!calendrier.getChronologieUnitesTraitements().estVide()))
            {
              UniteTraitement utPrecedente = (UniteTraitement)calendrier.getChronologieUnitesTraitements().dernierElement();
              utPrecedente.ajouterEvenement(new EvenementSuspensionCaAss(utPrecedente.getDateFin()));
            }
          }
        }
        if ((periodeCaCirma instanceof PeriodeEvenementEntreeCIRMA)) {
          if (periodeCaCirma.getDateDebut().estContenueDans(ut.getPeriode())) {
            if (!periodeCaCirma.getDateDebut().coincideAvec(ut.getDateDebut()))
            {
              ut.ajouterEvenement(new EvenementSuspensionCirmaAss(periodeCaCirma.getDateDebut().veille()));
            }
            else if ((calendrier.getChronologieUnitesTraitements() != null) && (!calendrier.getChronologieUnitesTraitements().estVide()))
            {
              UniteTraitement utPrecedente = (UniteTraitement)calendrier.getChronologieUnitesTraitements().dernierElement();
              utPrecedente.ajouterEvenement(new EvenementSuspensionCirmaAss(utPrecedente.getDateFin()));
            }
          }
        }
      }
    }
  }
  
  private static void effectuerTraitementSuspension(UniteTraitement ut, QualificationPeriodes qualificationPeriodes)
    throws CoucheLogiqueException
  {
    if (qualificationPeriodes.getPeriodesSuspensives() != null)
    {
      ChronologiePeriodes periodesSuspensives = qualificationPeriodes.getPeriodesSuspensives();
      periodesSuspensives.iterer();
      while (periodesSuspensives.encoreSuivant())
      {
        ObjetChronoPeriodeCalcul periodeSuspensive = (ObjetChronoPeriodeCalcul)periodesSuspensives.elementSuivant();
        if ((periodeSuspensive instanceof ObjetChronoPeriodeValiditeAccordACCREDDTE))
        {
          Damj dateEvenement = ((ObjetChronoPeriodeValiditeAccordACCREDDTE)periodeSuspensive).getPeriodeInitialeAccordACCREDDTE().getDebut();
          if (dateEvenement.estContenueDans(ut.getPeriode())) {
            ut.ajouterEvenement(new EvenementSuspensionACCREASS(dateEvenement));
          }
        }
      }
    }
  }
  
  private static void miseAJourSyntheseUTSuiteForcage(UniteTraitement ut)
  {
    if (ut.getTypeForcage() == 1) {
      ut.getSyntheseARsurUT().setQuantiteDecalageForcee(ut.getCreditDecalage());
    }
  }
  
  private static boolean verifierContexteContinuiteEtReprise(AttributionSpec attribution, ContexteUT contexteUT)
  {
    AttributionSpec attributionSol = attribution;
    
    FiltreOU filtreDemandeAss = new FiltreOU();
    filtreDemandeAss.ajouterFiltre(new FiltreDecisionPourProduit(9));
    filtreDemandeAss.ajouterFiltre(new FiltreDecisionPourProduit(10));
    FiltreET filtre = new FiltreET();
    filtre.ajouterFiltre(filtreDemandeAss);
    filtre.ajouterFiltre(new FiltreAttributionSurDecisions());
    Chronologie chrono = attributionSol.getDemandeur().getChronoDemandeSolidarite();
    chrono.supprimer(attributionSol.getDemande());
    AttributionSpec attributionAssPrecedente = (AttributionSpec)OutilRecherche.rechercherDecisionPrecedente(chrono, attributionSol.getDateEffet().lendemain(), filtre);
    if (((attributionSol instanceof RepriseSpec)) && (attributionAssPrecedente != null) && (attributionAssPrecedente.getCalendrierExecutionCalcul().getDernierJourIndemnisable().lendemain().coincideAvec(((CalendrierExecutionCalculSpec)contexteUT.getMapCalendriers().get(attributionSol)).getPremierJourIndemnisable()))) {
      return true;
    }
    return false;
  }
  
  private static int retourneRangDrv(AttributionSpec attribution)
  {
    int rang = 0;
    if (((attribution instanceof RepriseSpec)) || ((attribution instanceof RevisionSpec)))
    {
      AttributionSpec attributionPrecedente = (AttributionSpec)OutilRecherche.rechercherDecisionPrecedente(attribution.getDemandeur().getChronoDemandeAssurance(), attribution.getDateAttribution(), new FiltreAttributionAssurance(true, true, false, false, null));
      
      rang++;
      while ((attributionPrecedente != null) && (!(attributionPrecedente instanceof OdSpec)))
      {
        rang++;
        attributionPrecedente = (AttributionSpec)OutilRecherche.rechercherDecisionPrecedente(attribution.getDemandeur().getChronoDemandeAssurance(), attributionPrecedente.getDateAttribution(), new FiltreAttributionAssurance(true, true, false, false, null));
      }
    }
    return rang;
  }
}

/* Location:
 * Qualified Name:     TraitementAttributionPeriodique
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */