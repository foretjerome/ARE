package fr.unedic.cali.autresdoms.ga.mapping;

import fr.unedic.cali.autresdoms.cohab.dom.ObjetChronoPeriodePriseEnChargeSansFiltre;
import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.autresdoms.ga.dom.BulletinSalaire;
import fr.unedic.cali.autresdoms.ga.dom.ContratTravail;
import fr.unedic.cali.autresdoms.ga.dom.DeclareCongesNonPayes;
import fr.unedic.cali.autresdoms.ga.dom.DeclareSuspensionContratTravail;
import fr.unedic.cali.autresdoms.ga.dom.DeclareTravail;
import fr.unedic.cali.autresdoms.ga.dom.Entreprise;
import fr.unedic.cali.autresdoms.ga.dom.Metier;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeActiviteNonSalariePeriodique;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeActiviteNonSalariePonctuelle;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeActiviteSalarie;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeAvecRevenu;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeDeclare;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeGaec;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeIndemnisationCaf;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeMesureActivite;
import fr.unedic.cali.autresdoms.ga.dom.PeriodePansAvecRevenu;
import fr.unedic.cali.autresdoms.ga.dom.PeriodePansSansRevenu;
import fr.unedic.cali.autresdoms.ga.dom.Prime;
import fr.unedic.cali.autresdoms.ga.dom.RevenuPans;
import fr.unedic.cali.autresdoms.ga.dom.Salaire;
import fr.unedic.cali.autresdoms.ga.dom.TravailNonSalarie;
import fr.unedic.cali.autresdoms.ga.dom.TravailSalarie;
import fr.unedic.cali.autresdoms.ga.dom.spec.ConstantesContratTravail;
import fr.unedic.cali.autresdoms.ga.dom.spec.IncidentSpec;
import fr.unedic.cali.autresdoms.ga.outilsfonctionnels.OutilAEDV;
import fr.unedic.cali.calcul.OutillageCalculADate;
import fr.unedic.cali.calcul.OutillagePeriodes;
import fr.unedic.cali.calcul.dom.EvenementParametre;
import fr.unedic.cali.calcul.dom.periode.DebutActionFormation;
import fr.unedic.cali.calcul.dom.periode.DsmAbsenceAuPointage;
import fr.unedic.cali.calcul.dom.periode.DsmCongesNonPayes;
import fr.unedic.cali.calcul.dom.periode.DsmMaladie;
import fr.unedic.cali.calcul.dom.periode.DsmSuspensionContratTravail;
import fr.unedic.cali.calcul.dom.periode.DsmTravail;
import fr.unedic.cali.calcul.dom.periode.FinActionFormation;
import fr.unedic.cali.calcul.dom.periode.FinActionFormationInterruptive;
import fr.unedic.cali.calcul.dom.periode.FinPeriodeFormation;
import fr.unedic.cali.calcul.dom.periode.FinPeriodeFormationNonIndemnisee;
import fr.unedic.cali.calcul.dom.periode.ObjetPeriodeAEDV;
import fr.unedic.cali.calcul.dom.periode.ObjetPeriodeAEDVMayotte;
import fr.unedic.cali.calcul.dom.periode.PansMensuelNonRemuneree;
import fr.unedic.cali.calcul.dom.periode.PansNonInstallee;
import fr.unedic.cali.calcul.dom.periode.PeriodeActiviteEmploiCalcul;
import fr.unedic.cali.calcul.dom.periode.PeriodeActiviteSalarieSansSalaire;
import fr.unedic.cali.calcul.dom.periode.PeriodeClca;
import fr.unedic.cali.calcul.dom.periode.PeriodeClcaOuverte;
import fr.unedic.cali.calcul.dom.periode.PeriodeConflitGAEC;
import fr.unedic.cali.calcul.dom.periode.PeriodeContrat;
import fr.unedic.cali.calcul.dom.periode.PeriodeDisponibilite;
import fr.unedic.cali.calcul.dom.periode.PeriodeFormationNonIndemnisee;
import fr.unedic.cali.calcul.dom.periode.PeriodeFormationNonIndemniseeAbsenceHeure;
import fr.unedic.cali.calcul.dom.periode.PeriodeInassiduiteFormation;
import fr.unedic.cali.calcul.dom.periode.PeriodeInterStageFormation;
import fr.unedic.cali.calcul.dom.periode.PeriodePrime;
import fr.unedic.cali.calcul.dom.periode.PeriodeServiceCivique;
import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeCalcul;
import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeSuspensionIslr;
import fr.unedic.cali.calcul.outilsfonctionnels.GestionPans;
import fr.unedic.cali.calcul.parametres.ParametresIndemnisation;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.fabriques.FabriqueStrategieFluxEttSeulSansHeure;
import fr.unedic.cali.fabriques.FabriqueStrategiePECCACIRMAetCUI;
import fr.unedic.cali.fabriques.FabriqueStrategiePriseEnCompteIccpPourCalcul;
import fr.unedic.cali.outilsfonctionnels.ComparateurPeriodeSalaires;
import fr.unedic.cali.outilsfonctionnels.GestionnaireErreur;
import fr.unedic.cali.outilsfonctionnels.strategies.CritereStrategie;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieFluxEttSeulSansHeureSpec;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategiePECCACIRMAetCUISpec;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategiePriseEnCompteIccpSpec;
import fr.unedic.cali.parametres.GestionnaireDateApplication;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.cons.ConstantesLibelles;
import fr.unedic.util.Mathematiques;
import fr.unedic.util.Quantite;
import fr.unedic.util.QuantiteEuro;
import fr.unedic.util.Unite;
import fr.unedic.util.UniteAffiliation;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.ChronologieStandard;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.DureeCalendaire;
import fr.unedic.util.temps.FiltreChevauchePeriode;
import fr.unedic.util.temps.NonConformiteException;
import fr.unedic.util.temps.ObjetChronoPeriode;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

public final class MapperPeriodesCalcul
{
  private static final int NB_JOURS_INTERSTAGES = 15;
  private static final int NOMBRE_ANNEE_DETECTION_ARRIERE_PASSS = 5;
  private static final Damj DATE_PEC_CUI = new Damj(2010, 1, 1);
  private static final String PERIODE_DISPONIBILITE = "PDISPO";
  private static final String PERIODE_DISPONIBILITE_ENTREE = "EPDISPO";
  private static final String PERIODE_SUSPENSIVE = "PSUSPENSIVE";
  private static final String PERIODE_SUSPENSIVE_ENTREE = "EPSUSPENSIVE";
  private static final String PERIODE_REINTEGRATION_ANTICIPE = "PREINTEGRATION";
  
  public static ChronologiePeriodes mapper(ChronologiePeriodes chronologiePeriodesActivites, IndividuSpec individu, Damj dateExecution)
    throws CoucheLogiqueException
  {
    ChronologiePeriodes chronologiePeriodesActiviteCalcul = new ChronologiePeriodes();
    ChronologiePeriodes chronologieSalaires = new ChronologiePeriodes();
    ObjetChronoPeriode periodeActivite = null;
    if (chronologiePeriodesActivites == null) {
      return null;
    }
    chronologiePeriodesActivites.iterer();
    while (chronologiePeriodesActivites.encoreSuivant())
    {
      periodeActivite = (ObjetChronoPeriode)chronologiePeriodesActivites.elementSuivant();
      if (!estPeriodeAFiltrer(periodeActivite)) {
        try
        {
          if ((periodeActivite instanceof ActiviteSalarie))
          {
            ajouterPeriodeConflitGAEC(chronologiePeriodesActiviteCalcul, periodeActivite);
            
            ActiviteSalarie activiteSalarie = (ActiviteSalarie)periodeActivite;
            if (OutilAEDV.verificationPresenceAEDV(activiteSalarie)) {
              chronologiePeriodesActiviteCalcul.ajouter(new ObjetPeriodeAEDV(activiteSalarie));
            }
            if (OutilAEDV.verificationPresenceAEDVMayotte(activiteSalarie)) {
              chronologiePeriodesActiviteCalcul.ajouter(new ObjetPeriodeAEDVMayotte(activiteSalarie));
            }
            chronologiePeriodesActiviteCalcul.ajouter(mapper(((ActiviteSalarie)periodeActivite).getPeriodeActiviteSalarieGaec(), individu, chronologieSalaires));
            
            chronologiePeriodesActiviteCalcul.ajouter(mapperIncidents(activiteSalarie.getListePeriodesIncident()));
          }
          if ((periodeActivite instanceof TravailSalarie))
          {
            ajouterPeriodeConflitGAEC(chronologiePeriodesActiviteCalcul, periodeActivite);
            
            chronologiePeriodesActiviteCalcul.ajouter(mapper((TravailSalarie)periodeActivite, individu, chronologieSalaires));
          }
          else if ((periodeActivite instanceof IncidentSpec))
          {
            chronologiePeriodesActiviteCalcul.ajouter(mapper((fr.unedic.cali.autresdoms.ga.dom.PeriodeEvenementPersonnel)periodeActivite, chronologiePeriodesActiviteCalcul));
          }
          else if ((periodeActivite instanceof fr.unedic.cali.autresdoms.ga.dom.ActionFormation))
          {
            chronologiePeriodesActiviteCalcul.ajouter(mapper((fr.unedic.cali.autresdoms.ga.dom.ActionFormation)periodeActivite));
          }
          else if ((periodeActivite instanceof PeriodeDeclare))
          {
            chronologiePeriodesActiviteCalcul.ajouter(mapper((PeriodeDeclare)periodeActivite));
          }
          else if ((periodeActivite instanceof PeriodeActiviteNonSalariePeriodique))
          {
            chronologiePeriodesActiviteCalcul.ajouter(mapper((PeriodeActiviteNonSalariePeriodique)periodeActivite));
          }
          else if ((periodeActivite instanceof PeriodeActiviteNonSalariePonctuelle))
          {
            chronologiePeriodesActiviteCalcul.ajouter(mapper((PeriodeActiviteNonSalariePonctuelle)periodeActivite));
          }
          else if ((periodeActivite instanceof fr.unedic.cali.autresdoms.ga.dom.PeriodeFormation))
          {
            chronologiePeriodesActiviteCalcul.ajouter(mapper((fr.unedic.cali.autresdoms.ga.dom.PeriodeFormation)periodeActivite));
          }
        }
        catch (NonConformiteException ex)
        {
          GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_L_CAL_MAPPER_PERIODES_IMPOSSIBLE");
        }
      }
    }
    return chronologiePeriodesActiviteCalcul;
  }
  
  private static Chronologie mapperIncidents(Chronologie listePeriodesIncident)
    throws CoucheLogiqueException
  {
    ChronologiePeriodes chronologiePeriodesMappees = new ChronologiePeriodes();
    if ((listePeriodesIncident != null) && (!listePeriodesIncident.estVide()))
    {
      Iterator<?> itSuspension = listePeriodesIncident.iterer();
      while (itSuspension.hasNext())
      {
        IncidentSpec incident = (IncidentSpec)itSuspension.next();
        if (((incident instanceof fr.unedic.cali.autresdoms.ga.dom.PeriodeEvenementPersonnel)) && (recupererListeNaturePeriodesSuspensives().contains(Integer.valueOf(incident.getNature())))) {
          chronologiePeriodesMappees.ajouter(mapper((fr.unedic.cali.autresdoms.ga.dom.PeriodeEvenementPersonnel)incident, chronologiePeriodesMappees));
        }
      }
    }
    return chronologiePeriodesMappees;
  }
  
  private static ArrayList<Integer> recupererListeNaturePeriodesSuspensives()
  {
    ArrayList<Integer> listeNaturePeriodesSuspensives = new ArrayList();
    listeNaturePeriodesSuspensives.add(Integer.valueOf(55));
    listeNaturePeriodesSuspensives.add(Integer.valueOf(11));
    listeNaturePeriodesSuspensives.add(Integer.valueOf(56));
    listeNaturePeriodesSuspensives.add(Integer.valueOf(57));
    listeNaturePeriodesSuspensives.add(Integer.valueOf(58));
    listeNaturePeriodesSuspensives.add(Integer.valueOf(59));
    return listeNaturePeriodesSuspensives;
  }
  
  private static boolean estPeriodeAFiltrer(ObjetChronoPeriode periodeActivite)
  {
    boolean result = false;
    if ((periodeActivite.getDateFin() == Damj.FIN_DES_TEMPS) && ((periodeActivite instanceof PeriodeDeclare))) {
      result = true;
    }
    if (((periodeActivite instanceof ActiviteSalarie)) && (((ActiviteSalarie)periodeActivite).estMigree()))
    {
      boolean estContratCES = false;
      if (((ActiviteSalarie)periodeActivite).getContratTypeParticulier() == 7) {
        estContratCES = true;
      }
      result = !estContratCES;
    }
    if (((periodeActivite instanceof TravailNonSalarie)) && (((TravailNonSalarie)periodeActivite).estMigree())) {
      result = true;
    }
    if (((periodeActivite instanceof fr.unedic.cali.autresdoms.ga.dom.ActionFormation)) && (((fr.unedic.cali.autresdoms.ga.dom.ActionFormation)periodeActivite).estAnnulee())) {
      result = true;
    }
    if (((periodeActivite instanceof fr.unedic.cali.autresdoms.ga.dom.PeriodeFormation)) && (((fr.unedic.cali.autresdoms.ga.dom.PeriodeFormation)periodeActivite).estMigree())) {
      result = true;
    }
    if ((periodeActivite instanceof PeriodeActiviteSalarie))
    {
      PeriodeActiviteSalarie periode = (PeriodeActiviteSalarie)periodeActivite;
      if (periode.getIncomplete().equals(ConstantesContratTravail.BROUILLON)) {
        result = true;
      }
    }
    else if ((periodeActivite instanceof ActiviteSalarie))
    {
      ActiviteSalarie periode = (ActiviteSalarie)periodeActivite;
      if (periode.getPeriodeActiviteSalarieGaec().getIncomplete().equals(ConstantesContratTravail.BROUILLON)) {
        result = true;
      }
    }
    if (((periodeActivite instanceof fr.unedic.cali.autresdoms.ga.dom.PeriodeEvenementPersonnel)) && (((fr.unedic.cali.autresdoms.ga.dom.PeriodeEvenementPersonnel)periodeActivite).estMigree()) && (estTypeSecuMaladie((fr.unedic.cali.autresdoms.ga.dom.PeriodeEvenementPersonnel)periodeActivite))) {
      result = true;
    }
    return result;
  }
  
  private static ChronologiePeriodes mapper(fr.unedic.cali.autresdoms.ga.dom.PeriodeFormation periodeActivite)
  {
    ChronologiePeriodes chronologiePeriodesMappees = new ChronologiePeriodes();
    
    PeriodeFormationNonIndemnisee periodeNonIndemnise = new PeriodeFormationNonIndemnisee(periodeActivite);
    periodeNonIndemnise.setPeriodeInitiale(periodeActivite.getPeriode());
    chronologiePeriodesMappees.ajouter(periodeNonIndemnise);
    if ((periodeActivite.getOrigineRemuneration() == 1) || (periodeActivite.getOrigineRemuneration() == 2))
    {
      if ((periodeActivite.getDureeTotale() == null) || (periodeActivite.getDureeTotale().getValeurEntiere() == 0))
      {
        PeriodeFormationNonIndemniseeAbsenceHeure periodeFormationNonIndemniseeAbsenceHeure = new PeriodeFormationNonIndemniseeAbsenceHeure(periodeActivite.getDateDebut(), periodeActivite.getDateFin());
        
        chronologiePeriodesMappees.ajouter(periodeFormationNonIndemniseeAbsenceHeure);
      }
      FinPeriodeFormationNonIndemnisee finPeriodeFormationNonIndemnisee = new FinPeriodeFormationNonIndemnisee(periodeNonIndemnise.getDateFin());
      
      finPeriodeFormationNonIndemnisee.setPeriodeFormationNonIndemnisee(periodeNonIndemnise);
      finPeriodeFormationNonIndemnisee.setDateDebutFormation(periodeNonIndemnise.getDateDebut());
      finPeriodeFormationNonIndemnisee.setDateFinFormation(periodeNonIndemnise.getDateFin());
      chronologiePeriodesMappees.ajouter(finPeriodeFormationNonIndemnisee);
    }
    return chronologiePeriodesMappees;
  }
  
  private static Salaire determinerSalaireDeRattachement(TravailSalarie periodeActivite, Prime primeGaec)
  {
    Chronologie chronoPeriodesSalaire = periodeActivite.getListeSalaires();
    Salaire salaire = null;
    if (primeGaec.getDatePaie() != null)
    {
      chronoPeriodesSalaire.iterer();
      while (chronoPeriodesSalaire.encoreSuivant())
      {
        Salaire periodeSalaire = (Salaire)chronoPeriodesSalaire.elementSuivant();
        if ((periodeSalaire.getDatePaie() != null) && (periodeSalaire.getDatePaie().equals(primeGaec.getDatePaie()))) {
          return periodeSalaire;
        }
      }
      chronoPeriodesSalaire.iterer();
      while (chronoPeriodesSalaire.encoreSuivant())
      {
        Salaire periodeSalaire = (Salaire)chronoPeriodesSalaire.elementSuivant();
        if (periodeSalaire.getPeriode().contient(primeGaec.getDatePaie())) {
          return periodeSalaire;
        }
      }
    }
    chronoPeriodesSalaire.iterer();
    while (chronoPeriodesSalaire.encoreSuivant())
    {
      Salaire periodeSalaire = (Salaire)chronoPeriodesSalaire.elementSuivant();
      if (periodeSalaire.getPeriode().contient(primeGaec.getDateFin())) {
        return periodeSalaire;
      }
    }
    Damj dateRetenuePourPrimeGaec = primeGaec.getDatePaie() != null ? primeGaec.getDatePaie() : primeGaec.getDateFin();
    chronoPeriodesSalaire.iterer();
    while (chronoPeriodesSalaire.encoreSuivant())
    {
      Salaire periodeSalaire = (Salaire)chronoPeriodesSalaire.elementSuivant();
      if ((periodeSalaire.getDateFin().estAvant(dateRetenuePourPrimeGaec)) && ((salaire == null) || (periodeSalaire.getPeriode().estApres(salaire.getPeriode())))) {
        salaire = periodeSalaire;
      }
    }
    if ((salaire == null) && (!periodeActivite.getListeSalaires().estVide())) {
      salaire = (Salaire)periodeActivite.getListeSalaires().premierElement();
    }
    return salaire;
  }
  
  private static ChronologiePeriodes mapper(TravailSalarie periodeActivite, IndividuSpec individu, ChronologiePeriodes chronologieSalaires)
    throws CoucheLogiqueException
  {
    Damj dernierJourAtteste = individu.getDernierJourAtteste();
    ChronologiePeriodes chronologiePeriodesMappees = new ChronologiePeriodes();
    
    Chronologie chronoPeriodesSalaire = periodeActivite.getListeSalaires();
    chronologieSalaires.ajouter(chronoPeriodesSalaire);
    
    chronoPeriodesSalaire.setComparateur(new ComparateurPeriodeSalaires());
    chronoPeriodesSalaire.iterer();
    if (((periodeActivite instanceof PeriodeActiviteSalarie)) && ((periodeActivite.getMetier().getContratTypeParticulier() == 22) || (periodeActivite.getMetier().getContratTypeParticulier() == 21)))
    {
      CritereStrategie critereCACIRMA = new CritereStrategie();
      critereCACIRMA.setDatePivot(periodeActivite.getDateDebut());
      StrategiePECCACIRMAetCUISpec strategieCACIRMA = (StrategiePECCACIRMAetCUISpec)FabriqueStrategiePECCACIRMAetCUI.getInstance().getStrategie(critereCACIRMA);
      
      PeriodeContrat periodeContrat = new PeriodeContrat(periodeActivite.getDateDebut(), periodeActivite.getDateFin());
      periodeContrat.setTypeContratParticulier(strategieCACIRMA.mapperTypeContratParticulier(periodeActivite.getMetier().getContratTypeParticulier()));
      chronologiePeriodesMappees.ajouter(periodeContrat);
    }
    if ((chronoPeriodesSalaire.estVide()) && (periodeActivite.getMetier().getContratTypeParticulier() == 7))
    {
      chronologiePeriodesMappees.ajouter(creerPaecCesChaqueMois(periodeActivite));
    }
    else
    {
      Damj dateDebut = periodeActivite.getDateDebut();
      Damj dateFin = null;
      boolean existeUnePeriodeChevauchantLaFCT = false;
      while (chronoPeriodesSalaire.encoreSuivant())
      {
        Salaire periodeSalaire = (Salaire)chronoPeriodesSalaire.elementSuivant();
        
        PeriodeActiviteEmploiCalcul periodeActiviteEmploiCalcul = creerPeriodeSalaire(periodeActivite, periodeSalaire, individu);
        existeUnePeriodeChevauchantLaFCT = (existeUnePeriodeChevauchantLaFCT) || (periodeActiviteEmploiCalcul.isPeriodeChevauchantLaFCT());
        chronologiePeriodesMappees.ajouter(periodeActiviteEmploiCalcul);
        if ((dernierJourAtteste == null) || (dernierJourAtteste.estApresOuCoincideAvec(periodeSalaire.getDateDebut().veille()))) {
          dateFin = periodeSalaire.getDateDebut().veille();
        } else {
          dateFin = dernierJourAtteste;
        }
        if (dateDebut.estAvant(dateFin)) {
          chronologiePeriodesMappees.ajouter(determinerPeriodeActiviteSansSalaire(periodeActivite, dateDebut, dateFin, dernierJourAtteste));
        }
        dateDebut = periodeSalaire.getDateFin().lendemain();
      }
      if ((!(periodeActivite instanceof PeriodeActiviteSalarie)) || (!((PeriodeActiviteSalarie)periodeActivite).getContratTravail().estSuspensionChomageSansRCT()))
      {
        CritereStrategie critereStrategie = new CritereStrategie();
        critereStrategie.setDatePivot(periodeActivite.getDateFin());
        StrategiePriseEnCompteIccpSpec strategiePriseEnCompteIccpCourante = (StrategiePriseEnCompteIccpSpec)FabriqueStrategiePriseEnCompteIccpPourCalcul.getInstance().getStrategie(critereStrategie);
        if ((!existeUnePeriodeChevauchantLaFCT) && (strategiePriseEnCompteIccpCourante.paecACreerSurFctSiAbsenceSalaire()) && (periodeActivite.getQuantiteEuroIccp() != null) && (periodeActivite.getQuantiteEuroIccp().getValeur() != null) && (periodeActivite.getQuantiteEuroIccp().getValeur().compareTo(BigDecimal.ZERO) != 0))
        {
          Salaire periodeSalaire = null;
          if (!chronoPeriodesSalaire.estVide()) {
            periodeSalaire = (Salaire)chronoPeriodesSalaire.dernierElement();
          }
          Salaire periodeSalairePourICCP = null;
          if ((periodeSalaire != null) && (periodeSalaire.getDateFin().estApresOuCoincideAvec(periodeActivite.getDateFin().getDebutMois())))
          {
            periodeSalairePourICCP = new Salaire(periodeSalaire.getDateFin().lendemain(), periodeActivite.getDateFin());
          }
          else
          {
            Damj dateDebutPeriodeSalaire = Damj.max(periodeActivite.getDateDebut(), periodeActivite.getDateFin().getDebutMois());
            periodeSalairePourICCP = new Salaire(dateDebutPeriodeSalaire, periodeActivite.getDateFin());
          }
          periodeSalairePourICCP.setMontantSoumisAContribution(new QuantiteEuro(BigDecimal.ZERO));
          PeriodeActiviteEmploiCalcul periodeActiviteEmploiCalcul = creerPeriodeSalaire(periodeActivite, periodeSalairePourICCP, individu);
          chronologiePeriodesMappees.ajouter(periodeActiviteEmploiCalcul);
        }
      }
      if ((dernierJourAtteste == null) || (dernierJourAtteste.estApresOuCoincideAvec(periodeActivite.getDateFin()))) {
        dateFin = periodeActivite.getDateFin();
      } else {
        dateFin = dernierJourAtteste;
      }
      if (dateDebut.estAvant(dateFin)) {
        chronologiePeriodesMappees.ajouter(determinerPeriodeActiviteSansSalaire(periodeActivite, dateDebut, dateFin, dernierJourAtteste));
      }
      Chronologie primesGaec = null;
      Chronologie primesCalcul = new ChronologieStandard();
      
      primesGaec = periodeActivite.getListePrimesExceptionnelles();
      mapperPrimes(primesCalcul, periodeActivite, primesGaec, 0);
      
      primesGaec = periodeActivite.getListePrimesExceptionnellesExclues();
      mapperPrimes(primesCalcul, periodeActivite, primesGaec, 0);
      
      primesGaec = periodeActivite.getListePrimesNormales();
      mapperPrimes(primesCalcul, periodeActivite, primesGaec, 1);
      
      primesGaec = periodeActivite.getListePrimesNormalesExclues();
      mapperPrimes(primesCalcul, periodeActivite, primesGaec, 1);
      
      primesGaec = periodeActivite.getListePrimesICRS();
      mapperPrimes(primesCalcul, periodeActivite, primesGaec, 2);
      
      primesGaec = periodeActivite.getListePrimesICRSExclues();
      mapperPrimes(primesCalcul, periodeActivite, primesGaec, 2);
      
      chronologiePeriodesMappees.ajouter(primesCalcul);
    }
    return chronologiePeriodesMappees;
  }
  
  private static ChronologiePeriodes determinerPeriodeActiviteSansSalaire(TravailSalarie periodeActivite, Damj debut, Damj fin, Damj dernierJourAtteste)
    throws CoucheLogiqueException
  {
    ChronologiePeriodes listePASS = new ChronologiePeriodes();
    Damj dateDebut = debut;
    Damj dateFin = null;
    if ((periodeActivite instanceof PeriodeActiviteSalarie))
    {
      Chronologie listeIncidents = ((PeriodeActiviteSalarie)periodeActivite).getListePeriodesIncident().copier(new FiltreChevauchePeriode(new Periode(debut, fin)));
      listeIncidents.iterer();
      if ((listeIncidents != null) && (!listeIncidents.estVide()))
      {
        while (listeIncidents.encoreSuivant())
        {
          ObjetChronoPeriode maPeriode = (ObjetChronoPeriode)listeIncidents.elementSuivant();
          if (!dateDebut.estApresOuCoincideAvec(maPeriode.getDateDebut()))
          {
            if ((dernierJourAtteste == null) || (dernierJourAtteste.estApresOuCoincideAvec(maPeriode.getDateDebut()))) {
              dateFin = maPeriode.getDateDebut().veille();
            } else {
              dateFin = dernierJourAtteste;
            }
            detectionPASSS(periodeActivite, listePASS, dateDebut, dateFin);
          }
          dateDebut = maPeriode.getDateFin().lendemain();
        }
        if (dateDebut.estAvantOuCoincideAvec(fin))
        {
          if ((dernierJourAtteste == null) || (dernierJourAtteste.estApresOuCoincideAvec(periodeActivite.getDateFin()))) {
            dateFin = fin;
          } else {
            dateFin = dernierJourAtteste;
          }
          detectionPASSS(periodeActivite, listePASS, dateDebut, dateFin);
        }
      }
      else
      {
        detectionPASSS(periodeActivite, listePASS, debut, fin);
      }
    }
    return listePASS;
  }
  
  protected static void detectionPASSS(TravailSalarie travailSalarie, ChronologiePeriodes listePASSS, Damj debut, Damj fin)
    throws CoucheLogiqueException
  {
    boolean dateConnaissanceInfoValide = (travailSalarie.getDateConnaissanceInfo() != null) && (travailSalarie.getDateConnaissanceInfo().estApresOuCoincideAvec(GestionnaireDateApplication.getInstance().recupererDateApplication("Prise en compte des PASSS")));
    if ((dateConnaissanceInfoValide) && ((travailSalarie.estAtteste()) || (verificationOriginePAS(travailSalarie))))
    {
      Damj dateInfoMoins5Ans = travailSalarie.getDateConnaissanceInfo().deplacerVersArriere(new DureeCalendaire(5, 0, 0));
      Damj debutPASSS = Damj.max(debut, dateInfoMoins5Ans);
      debutPASSS = debutPASSS.estLeDebutDuMois() ? debutPASSS : debutPASSS.getDebutMoisSuivant();
      
      Damj dateFin = fin;
      ContratTravail ct = ((PeriodeActiviteSalarie)travailSalarie).getContratTravail();
      if (verificationDJTP(ct)) {
        dateFin = Damj.min(fin, ct.getDernierJourTravaillePaye());
      }
      Damj finPASSS = dateFin.estLaFinDuMois() ? dateFin : dateFin.getFinMoisPrecedent();
      if ((finPASSS.estApresOuCoincideAvec(dateInfoMoins5Ans)) && (debutPASSS.estAvant(finPASSS))) {
        listePASSS.ajouter(new PeriodeActiviteSalarieSansSalaire(debutPASSS, finPASSS));
      }
    }
  }
  
  private static boolean verificationOriginePAS(TravailSalarie travailSalarie)
  {
    return (((PeriodeActiviteSalarie)travailSalarie).getCollectionOrigineInformationPAS().contains(Integer.valueOf(11))) || (((PeriodeActiviteSalarie)travailSalarie).getCollectionOrigineInformationPAS().contains(Integer.valueOf(110)));
  }
  
  private static boolean verificationDJTP(ContratTravail ct)
  {
    return (ct != null) && (ct.getDernierJourTravaillePaye() != null);
  }
  
  private static PeriodeActiviteEmploiCalcul creerPeriodeSalaire(TravailSalarie periodeActivite, Salaire periodeSalaire, IndividuSpec individu)
  {
    PeriodeActiviteEmploiCalcul periodeActiviteEmploiCalcul = new PeriodeActiviteEmploiCalcul(periodeSalaire.getDateDebut(), periodeSalaire.getDateFin());
    
    periodeActiviteEmploiCalcul.setInformationOrigine(periodeActivite.getOrigineInformation());
    
    periodeActiviteEmploiCalcul.setGain(periodeSalaire.getMontantSoumisAContribution().getValeur());
    
    periodeActiviteEmploiCalcul.setMontantBrutAutreRemuneration(periodeSalaire.getMontantBrutAutreRemuneration());
    
    periodeActiviteEmploiCalcul.setPeriodeOrigine(periodeActivite.getPeriode());
    
    BigDecimal montantIccp = null;
    BigDecimal gain = periodeActiviteEmploiCalcul.getGain();
    
    CritereStrategie critereStrategie = new CritereStrategie();
    critereStrategie.setDatePivot(periodeActivite.getDateFin());
    StrategiePriseEnCompteIccpSpec strategiePriseEnCompteIccpCourante = (StrategiePriseEnCompteIccpSpec)FabriqueStrategiePriseEnCompteIccpPourCalcul.getInstance().getStrategie(critereStrategie);
    if (periodeSalaire.chevauche(new Periode(periodeActivite.getDateFin(), periodeActivite.getDateFin())))
    {
      periodeActiviteEmploiCalcul.setPeriodeChevauchantLaFCT(true);
      
      montantIccp = strategiePriseEnCompteIccpCourante.determinerMontantIccpALaFct(periodeActivite, periodeSalaire);
      if (montantIccp != null)
      {
        periodeActiviteEmploiCalcul.setIccp(montantIccp);
        periodeActiviteEmploiCalcul.setGain(gain.add(montantIccp));
      }
    }
    else if ((periodeSalaire.getMontantIccp() != null) && (!periodeSalaire.getMontantIccp().getValeur().equals(BigDecimal.ZERO)))
    {
      montantIccp = periodeSalaire.getMontantIccp().getValeur();
      periodeActiviteEmploiCalcul.setIccp(montantIccp);
      periodeActiviteEmploiCalcul.setGain(gain.add(montantIccp));
    }
    else
    {
      BigDecimal tauxIccp = periodeSalaire.getTauxIccp();
      if ((tauxIccp != null) && (!tauxIccp.equals(BigDecimal.ZERO)))
      {
        montantIccp = Mathematiques.tronque(gain.multiply(tauxIccp), 2);
        periodeActiviteEmploiCalcul.setIccp(montantIccp);
        periodeActiviteEmploiCalcul.setGain(gain.add(montantIccp));
      }
    }
    periodeActiviteEmploiCalcul.setIdentifiantEmployeur(periodeActivite.getEntreprise().getIdentifiantBNE());
    
    periodeActiviteEmploiCalcul.setCategorieEmploiParticulier(periodeActivite.getMetier().getCategorieEmploiParticulier());
    if (periodeActivite.getMetier().getContratTypeParticulier() == 0)
    {
      Chronologie periodesPriseEnChargeOriginales = OutillagePeriodes.recupererPecsSansFiltre(individu);
      periodesPriseEnChargeOriginales.iterer();
      while (periodesPriseEnChargeOriginales.encoreSuivant())
      {
        ObjetChronoPeriodePriseEnChargeSansFiltre periodePriseEnCharge = (ObjetChronoPeriodePriseEnChargeSansFiltre)periodesPriseEnChargeOriginales.elementSuivant();
        if ((periodePriseEnCharge != null) && (periodePriseEnCharge.chevauche(periodeSalaire.getPeriode()))) {
          if ((periodePriseEnCharge.getCategorie() != null) && (periodePriseEnCharge.getCategorie().equals("5")) && (periodePriseEnCharge.getTypePec().equals("1")) && (periodePriseEnCharge.getSousType().equals("7")))
          {
            if (periodePriseEnCharge.getSituationEmploi().equals("CAE")) {
              periodeActiviteEmploiCalcul.setTypeContratParticulier(14);
            }
            if ((periodePriseEnCharge.getDateDebut().estApresOuCoincideAvec(DATE_PEC_CUI)) && ((periodePriseEnCharge.getSituationEmploi().equals("CUN")) || (periodePriseEnCharge.getSituationEmploi().equals("EAN")) || (periodePriseEnCharge.getSituationEmploi().equals("EAP")))) {
              periodeActiviteEmploiCalcul.setTypeContratParticulier(23);
            }
          }
        }
      }
    }
    else
    {
      periodeActiviteEmploiCalcul.setTypeContratParticulier(periodeActivite.getMetier().getContratTypeParticulier());
    }
    periodeActiviteEmploiCalcul.setQuantiteAbsences(periodeSalaire.getQuantiteAbsence());
    
    periodeActiviteEmploiCalcul.setNombreHeuresDeCompletude(BigDecimal.ZERO);
    
    Chronologie chronoPeriodesMesureActivite = periodeActivite.getListePeriodesMesureActivite().copier(new FiltreChevauchePeriode(periodeSalaire.getPeriode()));
    
    chronoPeriodesMesureActivite.iterer();
    if (chronoPeriodesMesureActivite.encoreSuivant())
    {
      PeriodeMesureActivite periodeMesure = (PeriodeMesureActivite)chronoPeriodesMesureActivite.elementSuivant();
      
      Quantite quantiteAffiliation = (Quantite)periodeMesure.getListeQuantitesAffiliation().get(UniteAffiliation.HEURE_TRAVAIL);
      if (quantiteAffiliation != null) {
        periodeActiviteEmploiCalcul.setNombreHeures(quantiteAffiliation.getValeur());
      }
      if (periodeMesure.isPresenceHeureComplementaire()) {
        periodeActiviteEmploiCalcul.setNombreHeuresDeCompletude(quantiteAffiliation.getValeur());
      }
      Quantite quantiteAffiliationCachets = (Quantite)periodeMesure.getListeQuantitesAffiliation().get(UniteAffiliation.CACHET_GROUPE);
      if (quantiteAffiliationCachets != null)
      {
        periodeActiviteEmploiCalcul.setCachets(quantiteAffiliationCachets.getValeur());
        periodeActiviteEmploiCalcul.setQuantiteAffiliationCachets(quantiteAffiliationCachets);
      }
      quantiteAffiliationCachets = (Quantite)periodeMesure.getListeQuantitesAffiliation().get(UniteAffiliation.CACHET_ISOLE);
      if (quantiteAffiliationCachets != null)
      {
        periodeActiviteEmploiCalcul.setCachets(quantiteAffiliationCachets.getValeur());
        periodeActiviteEmploiCalcul.setQuantiteAffiliationCachets(quantiteAffiliationCachets);
      }
    }
    else
    {
      periodeActiviteEmploiCalcul.setNombreHeures(BigDecimal.ZERO);
    }
    if ((periodeActivite instanceof BulletinSalaire))
    {
      BulletinSalaire bulletinSalaire = (BulletinSalaire)periodeActivite;
      Iterator iterator = bulletinSalaire.getListeInformationOrigine().iterator();
      int indice = 0;
      boolean estETT = false;
      while (iterator.hasNext())
      {
        indice++;
        Object code = iterator.next();
        if ((code instanceof BigDecimal))
        {
          BigDecimal codeBig = (BigDecimal)code;
          if (codeBig.intValue() == 16) {
            estETT = true;
          }
        }
      }
      if ((estETT) && (indice == 1))
      {
        CritereStrategie critereStrategieFluxEttSeulSansHeure = new CritereStrategie();
        critereStrategieFluxEttSeulSansHeure.setDatePivot(periodeActiviteEmploiCalcul.getDateDebut());
        StrategieFluxEttSeulSansHeureSpec strategieFluxEttSeulSansHeure = (StrategieFluxEttSeulSansHeureSpec)FabriqueStrategieFluxEttSeulSansHeure.getInstance().getStrategie(critereStrategieFluxEttSeulSansHeure);
        strategieFluxEttSeulSansHeure.determinerNombreHeureEttSeul(periodeActiviteEmploiCalcul);
      }
      periodeActiviteEmploiCalcul.getListeInformationOrigine().addAll(bulletinSalaire.getListeInformationOrigine());
    }
    if ((periodeSalaire.getCollectionPND() != null) && (!periodeSalaire.getCollectionPND().isEmpty()))
    {
      Collection collectionPNDCalcul = new ArrayList();
      Iterator it = periodeSalaire.getCollectionPND().iterator();
      fr.unedic.cali.autresdoms.ga.dom.PeriodeNonDeclaree pndCourante = null;
      while (it.hasNext())
      {
        pndCourante = (fr.unedic.cali.autresdoms.ga.dom.PeriodeNonDeclaree)it.next();
        collectionPNDCalcul.add(new fr.unedic.cali.calcul.dom.periode.PeriodeNonDeclaree(pndCourante.getDateDebut(), pndCourante.getDateFin()));
      }
      periodeActiviteEmploiCalcul.setCollectionPND(collectionPNDCalcul);
    }
    periodeActiviteEmploiCalcul.setEstMigree(periodeActivite.estMigree());
    
    periodeActiviteEmploiCalcul.setIdentifiant(periodeActivite.getIdentifiant());
    
    return periodeActiviteEmploiCalcul;
  }
  
  private static ChronologiePeriodes mapper(fr.unedic.cali.autresdoms.ga.dom.PeriodeEvenementPersonnel periodeActivite, ChronologiePeriodes chronologiePeriodesActiviteCalcul)
    throws CoucheLogiqueException
  {
    ChronologiePeriodes chronologiePeriodesMappees = new ChronologiePeriodes();
    if (((periodeActivite instanceof PeriodeIndemnisationCaf)) && (((PeriodeIndemnisationCaf)periodeActivite).getNatureAllocation() == 1))
    {
      if (periodeActivite.getDateFin() == Damj.FIN_DES_TEMPS)
      {
        PeriodeClcaOuverte periodeClcaOuverte = new PeriodeClcaOuverte(periodeActivite.getDateDebut());
        periodeClcaOuverte.setNature(periodeActivite.getNature());
        periodeClcaOuverte.setLibelle(ConstantesLibelles.getNaturePEP(periodeActivite.getNature()));
        
        periodeClcaOuverte.setIntensite(periodeActivite.getIntensite());
        chronologiePeriodesMappees.ajouter(periodeClcaOuverte);
      }
      else
      {
        PeriodeClca periodeClca = new PeriodeClca(periodeActivite.getDateDebut(), periodeActivite.getDateFin());
        periodeClca.setNature(periodeActivite.getNature());
        periodeClca.setLibelle(ConstantesLibelles.getNaturePEP(periodeActivite.getNature()));
        periodeClca.setPeriodeInitiale(new Periode(periodeActivite.getDateDebut(), periodeActivite.getDateFin()));
        
        periodeClca.setIntensite(periodeActivite.getIntensite());
        chronologiePeriodesMappees.ajouter(periodeClca);
      }
    }
    else if (estPeriodeTypeServiceCivique(periodeActivite))
    {
      PeriodeServiceCivique periodeServiceCivique = new PeriodeServiceCivique(periodeActivite.getDateDebut(), periodeActivite.getDateFin());
      
      periodeServiceCivique.setNature(periodeActivite.getNature());
      periodeServiceCivique.setLibelle(ConstantesLibelles.getNaturePEP(periodeServiceCivique.getNature()));
      periodeServiceCivique.setPeriodeInitiale(new Periode(periodeActivite.getDateDebut(), periodeActivite.getDateFin()));
      chronologiePeriodesMappees.ajouter(periodeServiceCivique);
    }
    else if (estPeriodeSuspensiveOuDisponibilite(periodeActivite))
    {
      buildPeriodesSuspensives(periodeActivite, chronologiePeriodesMappees, chronologiePeriodesActiviteCalcul);
    }
    else if ((periodeActivite.getNature() != 40) && (periodeActivite.getNature() != 42))
    {
      fr.unedic.cali.calcul.dom.periode.PeriodeEvenementPersonnel incident = new fr.unedic.cali.calcul.dom.periode.PeriodeEvenementPersonnel(periodeActivite.getDateDebut(), periodeActivite.getDateFin());
      incident.setNature(periodeActivite.getNature());
      incident.setLibelle(ConstantesLibelles.getNaturePEP(periodeActivite.getNature()));
      chronologiePeriodesMappees.ajouter(incident);
    }
    return chronologiePeriodesMappees;
  }
  
  private static void buildPeriodesSuspensives(fr.unedic.cali.autresdoms.ga.dom.PeriodeEvenementPersonnel periodeActivite, ChronologiePeriodes chronologiePeriodesMappees, ChronologiePeriodes chronologiePeriodesActiviteCalcul)
    throws CoucheLogiqueException
  {
    PeriodeDisponibilite periodeDebut = new PeriodeDisponibilite(periodeActivite.getDateDebut(), true, periodeActivite);
    PeriodeDisponibilite periodeFin = new PeriodeDisponibilite(periodeActivite.getDateFin().lendemain(), false, periodeActivite);
    periodeFin.setDateDebutRenouvellement(periodeActivite.getDateDebut());
    if (periodeActivite.estPeriodeDisponibilite())
    {
      periodeDebut.setLibelle("EPDISPO");
      periodeFin.setLibelle("PDISPO");
      periodeDebut.setType("OJ");
      periodeFin.setType("OB");
    }
    if (periodeActivite.estPeriodeSuspensive())
    {
      periodeDebut.setLibelle("EPSUSPENSIVE");
      periodeFin.setLibelle("PSUSPENSIVE");
      periodeDebut.setType("OI");
      periodeFin.setType("OC");
    }
    if (periodeFin.estReintegration()) {
      periodeFin.setLibelle("PREINTEGRATION");
    }
    rechercherUnRenouvellement(chronologiePeriodesActiviteCalcul, periodeDebut);
    chronologiePeriodesMappees.ajouter(periodeDebut);
    chronologiePeriodesMappees.ajouter(periodeFin);
    if (periodeActivite.getDateFin().estApres(GestionnaireDateApplication.getInstance().recupererDateApplication("Périodes suspensives en cours")))
    {
      PeriodeDisponibilite periodeDeSuspension = new PeriodeDisponibilite(periodeActivite);
      periodeDeSuspension.setEstSeulementSuspensif(true);
      if ((periodeDeSuspension.estRenouvellementInvolontaire()) || (periodeDeSuspension.estReintegration()) || (periodeDeSuspension.estRuptureVolontaire()) || (periodeDeSuspension.estRuptureInVolontaire())) {
        chronologiePeriodesMappees.ajouter(periodeDeSuspension);
      }
    }
  }
  
  private static void rechercherUnRenouvellement(ChronologiePeriodes chronologiePeriodesActiviteCalcul, PeriodeDisponibilite periodeDebut)
  {
    boolean found = false;
    
    chronologiePeriodesActiviteCalcul.iterer();
    while ((chronologiePeriodesActiviteCalcul.encoreSuivant()) && (!found))
    {
      ObjetChronoPeriode periodeActivite = (ObjetChronoPeriode)chronologiePeriodesActiviteCalcul.elementSuivant();
      if (((periodeActivite instanceof PeriodeDisponibilite)) && (((PeriodeDisponibilite)periodeActivite).estRenouvellementInvolontaire()) && (((PeriodeDisponibilite)periodeActivite).getIdContratTravail().equals(periodeDebut.getIdContratTravail())) && (((PeriodeDisponibilite)periodeActivite).getDateFin().equals(periodeDebut.getDateDebut())))
      {
        periodeDebut.setEstSuiteRenouvellement(true);
        periodeDebut.setDateDebutRenouvellement(Damj.min(((PeriodeDisponibilite)periodeActivite).getDateDebutRenouvellement(), periodeDebut.getDateDebut()));
        found = true;
      }
    }
  }
  
  private static ChronologiePeriodes mapper(fr.unedic.cali.autresdoms.ga.dom.ActionFormation periodeActivite)
    throws CoucheLogiqueException
  {
    ChronologiePeriodes chronologiePeriodesMappees = new ChronologiePeriodes();
    if (10 == periodeActivite.getTypeConvention()) {
      return chronologiePeriodesMappees;
    }
    fr.unedic.cali.calcul.dom.periode.ActionFormation actionFormation = new fr.unedic.cali.calcul.dom.periode.ActionFormation(periodeActivite.getDateDebut(), periodeActivite.getDateFin());
    if (periodeActivite.getIdentifiant() != null) {
      actionFormation.setIdentifiantActionFormation(Integer.parseInt(periodeActivite.getIdentifiant()));
    }
    actionFormation.setTypePlan(periodeActivite.getTypePlanFormation());
    actionFormation.setQuantiteHoraireTotal(periodeActivite.getDureeTotale());
    actionFormation.setQuantiteHoraireHebdo(periodeActivite.getQuantiteHoraireHebdo());
    actionFormation.setTypeConvention(periodeActivite.getTypeConvention());
    actionFormation.setDatePrescription(periodeActivite.getDatePrescription());
    actionFormation.setActiverAREF(verifierActivationAREF(periodeActivite.getTypeConvention()));
    
    chronologiePeriodesMappees.ajouter(actionFormation);
    
    FinActionFormationInterruptive finActionFormationInterruptive = new FinActionFormationInterruptive(periodeActivite.getDateFin().lendemain());
    finActionFormationInterruptive.setActionFormation(actionFormation);
    chronologiePeriodesMappees.ajouter(finActionFormationInterruptive);
    if (actionFormation.estBasculeAutoriserEnContexteFormation())
    {
      FinActionFormation finActionFormation = new FinActionFormation(periodeActivite.getDateFin().lendemain());
      finActionFormation.setActionFormation(actionFormation);
      
      DebutActionFormation debutActionFormation = new DebutActionFormation(periodeActivite.getDateDebut());
      debutActionFormation.setActionFormation(actionFormation);
      chronologiePeriodesMappees.ajouter(debutActionFormation);
      
      chronologiePeriodesMappees.ajouter(finActionFormation);
    }
    ChronologiePeriodes chronologiePeriodesFormation = new ChronologiePeriodes();
    ChronologiePeriodes periodesFormationCali = periodeActivite.getListePeriodeFormation();
    periodesFormationCali.iterer();
    while (periodesFormationCali.encoreSuivant())
    {
      fr.unedic.cali.autresdoms.ga.dom.PeriodeFormation periodeFormationCali = (fr.unedic.cali.autresdoms.ga.dom.PeriodeFormation)periodesFormationCali.elementSuivant();
      
      actionFormation.setNbJourPeriodeFormation(actionFormation.getNbJourPeriodeFormation().ajouter(new Quantite(periodeFormationCali.getDuree(), Unite.get("jour"))));
      
      fr.unedic.cali.calcul.dom.periode.PeriodeFormation periodeFormation = new fr.unedic.cali.calcul.dom.periode.PeriodeFormation();
      
      periodeFormation.setActionFormation(actionFormation);
      if (periodeFormationCali.getIdentifiant() != null) {
        periodeFormation.setIdentifiantPeriodeFormation(Integer.parseInt(periodeFormationCali.getIdentifiant()));
      }
      if (periodeFormationCali.getPeriodePrevisionnnelle() != null)
      {
        periodeFormation.setPeriode(periodeFormationCali.getPeriodePrevisionnnelle());
        periodeFormation.setPeriodePrevisionnelleInitiale(periodeFormationCali.getPeriodePrevisionnnelle());
      }
      if (periodeFormationCali.getPeriodeEffective() != null)
      {
        periodeFormation.setPeriode(periodeFormationCali.getPeriodeEffective());
        periodeFormation.setPeriodeEffectiveInitiale(periodeFormationCali.getPeriodeEffective());
      }
      periodeFormation.setTypeMesureEmploi(periodeFormationCali.getTypeMesurePourEmploi());
      
      FinPeriodeFormation finPeriodeFormation = new FinPeriodeFormation(periodeFormation.getDateFin());
      finPeriodeFormation.setActionFormation(actionFormation);
      chronologiePeriodesMappees.ajouter(finPeriodeFormation);
      if (periodeFormation.estEffective()) {
        chronologiePeriodesFormation.ajouter(periodeFormation);
      }
    }
    ChronologiePeriodes chronologiePeriodesInterStage = OutillageCalculADate.boucheLesTrous(chronologiePeriodesFormation, PeriodeInterStageFormation.class, actionFormation.getDateDebut(), actionFormation.getDateFin());
    
    chronologiePeriodesInterStage.iterer();
    while (chronologiePeriodesInterStage.encoreSuivant())
    {
      ObjetChronoPeriodeCalcul periode = (ObjetChronoPeriodeCalcul)chronologiePeriodesInterStage.elementSuivant();
      if ((periode instanceof PeriodeInterStageFormation))
      {
        if (periode.getDuree() <= 15) {
          actionFormation.setNbJourPeriodeFormation(actionFormation.getNbJourPeriodeFormation().ajouter(new Quantite(periode.getDuree(), Unite.get("jour"))));
        }
        ((PeriodeInterStageFormation)periode).setActionFormation(actionFormation);
        
        chronologiePeriodesFormation.iterer();
        boolean trouve = false;
        while ((chronologiePeriodesFormation.encoreSuivant()) && (!trouve))
        {
          fr.unedic.cali.calcul.dom.periode.PeriodeFormation periodeFormation = (fr.unedic.cali.calcul.dom.periode.PeriodeFormation)chronologiePeriodesFormation.elementSuivant();
          if (periodeFormation.getDateFin().lendemain().coincideAvec(periode.getDateDebut()))
          {
            trouve = true;
            ((PeriodeInterStageFormation)periode).setPeriodeFormation(periodeFormation);
          }
          else if (periodeFormation.getDateFin().lendemain().coincideAvec(periode.getDateDebut()))
          {
            trouve = true;
            ((PeriodeInterStageFormation)periode).setPeriodeFormation(periodeFormation);
          }
        }
      }
      else
      {
        chronologiePeriodesInterStage.supprimer();
      }
    }
    chronologiePeriodesMappees.ajouter(chronologiePeriodesFormation);
    chronologiePeriodesMappees.ajouter(chronologiePeriodesInterStage);
    
    ChronologiePeriodes periodesInassiduiteFormationCali = periodeActivite.getListePeriodeAbsenceFormation();
    periodesInassiduiteFormationCali.iterer();
    while (periodesInassiduiteFormationCali.encoreSuivant())
    {
      PeriodeGaec periodeInassiduiteFormationCali = (PeriodeGaec)periodesInassiduiteFormationCali.elementSuivant();
      
      PeriodeInassiduiteFormation periodeInassiduiteFormation = new PeriodeInassiduiteFormation(periodeInassiduiteFormationCali.getDateDebut(), periodeInassiduiteFormationCali.getDateFin());
      
      periodeInassiduiteFormation.setActionFormation(actionFormation);
      
      chronologiePeriodesMappees.ajouter(periodeInassiduiteFormation);
    }
    return chronologiePeriodesMappees;
  }
  
  private static boolean verifierActivationAREF(int typeConvention)
  {
    return (typeConvention != 12) && (typeConvention != 13) && (typeConvention != 14) && (typeConvention != 15);
  }
  
  private static ChronologiePeriodes mapper(PeriodeDeclare periodeActivite)
    throws CoucheLogiqueException
  {
    ChronologiePeriodes chronologiePeriodesMappees = new ChronologiePeriodes();
    if ((periodeActivite instanceof DeclareTravail))
    {
      DsmTravail dsm = new DsmTravail(periodeActivite.getDateDebut(), periodeActivite.getDateFin());
      dsm.setGain(((DeclareTravail)periodeActivite).getMontant().getValeur());
      dsm.setNombreHeures(((DeclareTravail)periodeActivite).getQuantite().getValeur());
      dsm.setCachets(((DeclareTravail)periodeActivite).getCachets());
      if ((dsm.getCachets() != null) && (dsm.getCachets().intValue() > 0)) {
        dsm.setNombreHeures(dsm.getCachets().multiply(new BigDecimal("12")).add(dsm.getNombreHeures()));
      }
      dsm.setJustifiee(periodeActivite.estJustifie());
      dsm.setStatutDSMTravail(((DeclareTravail)periodeActivite).getStatutDSMTravail());
      dsm.setOrigineInfo(((DeclareTravail)periodeActivite).getOrigineInfo());
      
      dsm.setEstMigree(periodeActivite.estMigree());
      
      dsm.setIdentifiant(periodeActivite.getIdentifiant());
      chronologiePeriodesMappees.ajouter(dsm);
    }
    else if (periodeActivite.getTypePeriodeDeclare() == 1)
    {
      DsmMaladie dsm = new DsmMaladie(periodeActivite.getDateDebut(), periodeActivite.getDateFin());
      dsm.setJustifiee(periodeActivite.estJustifie());
      
      dsm.setEstMigree(periodeActivite.estMigree());
      chronologiePeriodesMappees.ajouter(dsm);
    }
    else if (periodeActivite.getTypePeriodeDeclare() == 3)
    {
      DsmAbsenceAuPointage dsm = new DsmAbsenceAuPointage(periodeActivite.getDateDebut(), periodeActivite.getDateFin());
      dsm.setJustifiee(periodeActivite.estJustifie());
      
      dsm.setEstMigree(periodeActivite.estMigree());
      chronologiePeriodesMappees.ajouter(dsm);
    }
    else if (periodeActivite.getTypePeriodeDeclare() == 4)
    {
      chronologiePeriodesMappees.ajouter(creerPeriodeDeclareeChaqueMois(periodeActivite));
    }
    else if (periodeActivite.getTypePeriodeDeclare() == 5)
    {
      chronologiePeriodesMappees.ajouter(creerPeriodeDeclareeChaqueMois(periodeActivite));
    }
    return chronologiePeriodesMappees;
  }
  
  private static ChronologiePeriodes mapper(PeriodeActiviteNonSalariePeriodique periodeActivite)
    throws CoucheLogiqueException
  {
    ChronologiePeriodes chronologiePeriodesMappees = new ChronologiePeriodes();
    PeriodeAvecRevenu periodeAvecRevenu = null;
    Iterator<?> it = periodeActivite.getCollectionPeriodeAvecRevenu().iterator();
    while (it.hasNext())
    {
      periodeAvecRevenu = (PeriodeAvecRevenu)it.next();
      chronologiePeriodesMappees.ajouter(GestionPans.creerPans(periodeActivite, periodeAvecRevenu));
    }
    PeriodePansAvecRevenu periodePansAvecRevenu = null;
    Iterator<PeriodePansAvecRevenu> iterateurPeriodePans = periodeActivite.getCollectionPeriodePansAvecRevenu().iterator();
    while (iterateurPeriodePans.hasNext())
    {
      periodePansAvecRevenu = (PeriodePansAvecRevenu)iterateurPeriodePans.next();
      chronologiePeriodesMappees.ajouter(GestionPans.creerPansMensuelOuSupraMensuel(periodeActivite, periodePansAvecRevenu));
    }
    PeriodePansSansRevenu periodePansSansRevenu = null;
    Iterator<PeriodePansSansRevenu> iterateurPeriodePansNonRemuneree = periodeActivite.getCollectionPeriodePansSansRevenu().iterator();
    while (iterateurPeriodePansNonRemuneree.hasNext())
    {
      periodePansSansRevenu = (PeriodePansSansRevenu)iterateurPeriodePansNonRemuneree.next();
      chronologiePeriodesMappees.ajouter(new PansMensuelNonRemuneree(periodePansSansRevenu.getDateDebut(), periodePansSansRevenu.getDateFin()));
    }
    return chronologiePeriodesMappees;
  }
  
  private static ChronologiePeriodes mapper(PeriodeActiviteNonSalariePonctuelle periodeActivite)
    throws CoucheLogiqueException
  {
    ChronologiePeriodes chronologiePeriodesMappees = new ChronologiePeriodes();
    
    PansNonInstallee pansNonInstallee = new PansNonInstallee(periodeActivite.getDateDebut(), periodeActivite.getDateFin());
    pansNonInstallee.setGain(periodeActivite.getRevenuPans().getMontant());
    pansNonInstallee.setPeriodeOrigine(periodeActivite.getPeriode());
    
    chronologiePeriodesMappees.ajouter(pansNonInstallee);
    
    return chronologiePeriodesMappees;
  }
  
  private static ChronologiePeriodes creerPaecCesChaqueMois(TravailSalarie periodeActivite)
  {
    ChronologiePeriodes chronoPaec = new ChronologiePeriodes();
    PeriodeActiviteEmploiCalcul periodeActiviteEmploiCourante = null;
    Damj dateFin = null;
    
    BigDecimal gain = null;
    BigDecimal gainMensuel = null;
    BigDecimal heure = null;
    BigDecimal heureMensuel = new BigDecimal("87");
    
    Damj dateCourante = periodeActivite.getDateDebut();
    while (dateCourante.estAvantOuCoincideAvec(periodeActivite.getDateFin()))
    {
      dateFin = dateCourante.getFinMois().estAvantOuCoincideAvec(periodeActivite.getDateFin()) ? dateCourante.getFinMois() : periodeActivite.getDateFin();
      
      periodeActiviteEmploiCourante = new PeriodeActiviteEmploiCalcul(dateCourante, dateFin);
      
      EvenementParametre evenementParametre = ParametresIndemnisation.getParametresIndemnisation().getElementActif(dateCourante);
      
      gainMensuel = evenementParametre.getSmicHoraire().multiply(heureMensuel);
      if (periodeActiviteEmploiCourante.getPeriode().getDuree() < dateCourante.getDebutMois().joursEntre(dateCourante.getFinMois()) + 1)
      {
        gain = Mathematiques.proratiser(gainMensuel, new BigDecimal(Integer.toString(periodeActiviteEmploiCourante.getPeriode().getDuree())), new BigDecimal(Integer.toString(dateCourante.getDebutMois().joursEntre(dateCourante.getFinMois()) + 1)));
        
        heure = heureMensuel.multiply(new BigDecimal(Integer.toString(periodeActiviteEmploiCourante.getPeriode().getDuree()))).divide(new BigDecimal(Integer.toString(dateCourante.getDebutMois().joursEntre(dateCourante.getFinMois()) + 1)), 4);
      }
      else
      {
        gain = gainMensuel;
        heure = heureMensuel;
      }
      periodeActiviteEmploiCourante.setGain(gain);
      
      periodeActiviteEmploiCourante.setNombreHeures(heure);
      
      periodeActiviteEmploiCourante.setIdentifiantEmployeur(periodeActivite.getEntreprise().getIdentifiantBNE());
      
      periodeActiviteEmploiCourante.setCategorieEmploiParticulier(periodeActivite.getMetier().getCategorieEmploiParticulier());
      
      periodeActiviteEmploiCourante.setTypeContratParticulier(periodeActivite.getMetier().getContratTypeParticulier());
      
      periodeActiviteEmploiCourante.setForfait(true);
      
      chronoPaec.ajouter(periodeActiviteEmploiCourante);
      
      dateCourante = dateCourante.getDebutMoisSuivant();
    }
    return chronoPaec;
  }
  
  private static void ajouterPeriodeConflitGAEC(ChronologiePeriodes chronologiePeriodesActiviteCalcul, ObjetChronoPeriode periodeActivite)
  {
    if ((periodeActivite instanceof ActiviteSalarie))
    {
      if (((ActiviteSalarie)periodeActivite).estEnConflit()) {
        controleAjoutConflitGaec(chronologiePeriodesActiviteCalcul, periodeActivite);
      }
    }
    else if (((periodeActivite instanceof TravailSalarie)) && (((TravailSalarie)periodeActivite).estEnConflit())) {
      controleAjoutConflitGaec(chronologiePeriodesActiviteCalcul, periodeActivite);
    }
  }
  
  private static void controleAjoutConflitGaec(ChronologiePeriodes chronologiePeriodesActiviteCalcul, ObjetChronoPeriode periodeActivite)
  {
    boolean conflitDejaAjoute = false;
    if (chronologiePeriodesActiviteCalcul != null)
    {
      Iterator<?> iterateur = chronologiePeriodesActiviteCalcul.iterer();
      while (iterateur.hasNext())
      {
        ObjetChronoPeriodeCalcul objetChronoPeriodeCalcul = (ObjetChronoPeriodeCalcul)iterateur.next();
        if (((objetChronoPeriodeCalcul instanceof PeriodeConflitGAEC)) && (((PeriodeConflitGAEC)objetChronoPeriodeCalcul).getDateDebut().equals(periodeActivite.getDateDebut().getDebutMois()))) {
          conflitDejaAjoute = true;
        }
      }
    }
    if (!conflitDejaAjoute) {
      chronologiePeriodesActiviteCalcul.ajouter(new PeriodeConflitGAEC(periodeActivite.getDateDebut().getDebutMois(), periodeActivite.getDateDebut().getFinMois()));
    }
  }
  
  private static boolean estTypeSecuMaladie(fr.unedic.cali.autresdoms.ga.dom.PeriodeEvenementPersonnel periodeActivite)
  {
    boolean estPeriodeMaladie = false;
    if ((periodeActivite.getNature() == 21) || (periodeActivite.getNature() == 22)) {
      estPeriodeMaladie = true;
    }
    return estPeriodeMaladie;
  }
  
  private static void mapperPrimes(Chronologie primesCalcul, TravailSalarie periodeActivite, Chronologie primesGaec, int typePrime)
    throws CoucheLogiqueException
  {
    if ((primesGaec != null) && (!primesGaec.estVide()))
    {
      primesGaec.iterer();
      while (primesGaec.encoreSuivant())
      {
        Prime primeGaec = (Prime)primesGaec.elementSuivant();
        
        Salaire salaire = determinerSalaireDeRattachement(periodeActivite, primeGaec);
        if (salaire != null)
        {
          PeriodePrime primeCalcul = new PeriodePrime(salaire.getDateDebut(), salaire.getDateFin(), primeGaec.getMontantSoumisAContribution(), typePrime, periodeActivite.getEntreprise().getIdentifiantBNE());
          
          primeCalcul.setEstMigree(periodeActivite.estMigree());
          
          primeCalcul.setIdentifiant(periodeActivite.getIdentifiant());
          
          primeCalcul.setPeriodeOrigine(periodeActivite.getPeriode());
          primesCalcul.ajouter(primeCalcul);
        }
      }
    }
  }
  
  private static ChronologiePeriodes creerPeriodeDeclareeChaqueMois(PeriodeDeclare periodeActivite)
  {
    ChronologiePeriodes chronoDSM = new ChronologiePeriodes();
    Damj dateFin = null;
    
    Damj dateCourante = periodeActivite.getDateDebut();
    while (dateCourante.estAvantOuCoincideAvec(periodeActivite.getDateFin()))
    {
      dateFin = dateCourante.getFinMois().estAvantOuCoincideAvec(periodeActivite.getDateFin()) ? dateCourante.getFinMois() : periodeActivite.getDateFin();
      if (periodeActivite.getTypePeriodeDeclare() == 4)
      {
        DsmSuspensionContratTravail dsmSuspensionContratTravail = new DsmSuspensionContratTravail(dateCourante, dateFin);
        dsmSuspensionContratTravail.setJustifiee(periodeActivite.estJustifie());
        
        dsmSuspensionContratTravail.setEstMigree(periodeActivite.estMigree());
        dsmSuspensionContratTravail.setOrigineInfo(((DeclareSuspensionContratTravail)periodeActivite).getOrigineInfo());
        chronoDSM.ajouter(dsmSuspensionContratTravail);
      }
      else if (periodeActivite.getTypePeriodeDeclare() == 5)
      {
        DsmCongesNonPayes dsmCongesNonPayes = new DsmCongesNonPayes(dateCourante, dateFin);
        dsmCongesNonPayes.setJustifiee(periodeActivite.estJustifie());
        
        dsmCongesNonPayes.setEstMigree(periodeActivite.estMigree());
        dsmCongesNonPayes.setOrigineInfo(((DeclareCongesNonPayes)periodeActivite).getOrigineInfo());
        chronoDSM.ajouter(dsmCongesNonPayes);
      }
      dateCourante = dateCourante.getDebutMoisSuivant();
    }
    return chronoDSM;
  }
  
  private static boolean estPeriodeTypeServiceCivique(fr.unedic.cali.autresdoms.ga.dom.PeriodeEvenementPersonnel periode)
  {
    return (periode.getNature() == 46) || (periode.getNature() == 47) || (periode.getNature() == 45) || (periode.getNature() == 48) || (periode.getNature() == 44);
  }
  
  private static boolean estPeriodeSuspensiveOuDisponibilite(fr.unedic.cali.autresdoms.ga.dom.PeriodeEvenementPersonnel periode)
  {
    return (periode.estPeriodeDisponibilite()) || (periode.estPeriodeSuspensive());
  }
  
  public static ChronologiePeriodes recupererFctIslr(ChronologiePeriodes chronologiePeriodesActiviteCalcul, Damj date)
  {
    ChronologiePeriodes periodesISLR = null;
    periodesISLR = new ChronologiePeriodes();
    ObjetChronoPeriode periodeActivite = null;
    
    chronologiePeriodesActiviteCalcul.iterer();
    while (chronologiePeriodesActiviteCalcul.encoreSuivant())
    {
      periodeActivite = (ObjetChronoPeriode)chronologiePeriodesActiviteCalcul.elementSuivant();
      if ((!estPeriodeAFiltrer(periodeActivite)) && ((periodeActivite instanceof ActiviteSalarie)) && (periodeActivite.getDateFin().estAvant(date)))
      {
        ActiviteSalarie activite = (ActiviteSalarie)periodeActivite;
        periodesISLR.ajouter(new ObjetChronoPeriodeSuspensionIslr(activite));
      }
    }
    return periodesISLR;
  }
}

/* Location:
 * Qualified Name:     MapperPeriodesCalcul
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */