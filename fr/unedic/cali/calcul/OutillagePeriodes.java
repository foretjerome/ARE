package fr.unedic.cali.calcul;

import fr.unedic.cali.autresdoms.cohab.dom.ObjetChronoPeriodePriseEnCharge;
import fr.unedic.cali.autresdoms.cohab.dom.ObjetChronoPeriodePriseEnChargeSansFiltre;
import fr.unedic.cali.autresdoms.cohab.dom.PeriodePensionInvaliditeChainee;
import fr.unedic.cali.autresdoms.cohab.dom.spec.TrimestreRetraiteSpec;
import fr.unedic.cali.autresdoms.ga.mapping.MapperPeriodesCalcul;
import fr.unedic.cali.calcul.dom.periode.ActionFormation;
import fr.unedic.cali.calcul.dom.periode.PeriodeAvantageVieillesse;
import fr.unedic.cali.calcul.dom.periode.PeriodeBlocageIndemnisation;
import fr.unedic.cali.calcul.dom.temps.ObjetChronoAnniversaire50Ans;
import fr.unedic.cali.calcul.dom.temps.ObjetChronoAnniversaire55Ans;
import fr.unedic.cali.calcul.dom.temps.ObjetChronoAnniversaire60Ans;
import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeLendemainDja;
import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeNonPEC;
import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodePEC;
import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeRadiation;
import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeRetraite;
import fr.unedic.cali.calcul.dom.temps.ObjetChronoRetraiteAuPlusTard;
import fr.unedic.cali.calcul.outilsfonctionnels.GestionSanctions;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.ChronologiePeriodesGaec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.FormulaireSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.Retraite;
import fr.unedic.cali.outilsfonctionnels.OutilRetraite;
import fr.unedic.cali.outilsfonctionnels.OutilRetraiteMayotte;
import fr.unedic.cali.outilsfonctionnels.OutilRetraiteSpec;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.DureeCalendaire;
import fr.unedic.util.temps.FiltreChevauchePeriode;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.ObjetChronoPeriode;
import fr.unedic.util.temps.Periode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public final class OutillagePeriodes
{
  private static final int CINQUANTE_ANS = 50;
  private static final int CINQUANTE_CINQ_ANS = 55;
  private static final int SOIXANTE_ANS = 60;
  private transient ChronologiePeriodes chronologiePeriodes = null;
  
  public static ChronologiePeriodes recupererPeriodesEvtActualisation(IndividuSpec individu)
    throws CoucheLogiqueException
  {
    return individu.getChronoPeriodeEvtActualisation();
  }
  
  public static ChronologiePeriodes recupererPeriodesGAEC(IndividuSpec individu, Damj dateDebut, Damj dateFin)
    throws CoucheLogiqueException
  {
    Damj finPeriode = dateFin != null ? dateFin : Damj.FIN_DES_TEMPS;
    
    FiltreTemporel filtre = new FiltreChevauchePeriode(new Periode(dateDebut != null ? dateDebut.veille() : Damj.NUIT_DES_TEMPS, finPeriode));
    if (estCachePeriodeGaecValide(individu, dateDebut, finPeriode))
    {
      ChronologiePeriodes chronoCache = (ChronologiePeriodes)individu.getChronoPeriodesCalcul().getChronologie().copier(filtre);
      
      Damj dateMinActionFormation = detectionBornerDateDebutActionFormation(chronoCache);
      if (dateMinActionFormation != null)
      {
        filtre = new FiltreChevauchePeriode(new Periode(dateDebut != null ? Damj.min(dateMinActionFormation.veille(), dateDebut.veille()) : Damj.NUIT_DES_TEMPS, finPeriode));
        
        chronoCache = (ChronologiePeriodes)individu.getChronoPeriodesCalcul().getChronologie().copier(filtre);
      }
      return chronoCache;
    }
    ChronologiePeriodes chronologiePeriodes = (ChronologiePeriodes)individu.getChronoPeriodePasseProfessionnelSansFiltrageDNJ().copier(filtre);
    ChronologiePeriodes chronologiePeriodesCalcul = MapperPeriodesCalcul.mapper(chronologiePeriodes, individu, dateDebut);
    
    individu.setChronoPeriodesCalcul(new ChronologiePeriodesGaec(chronologiePeriodesCalcul, dateDebut, finPeriode));
    return chronologiePeriodesCalcul;
  }
  
  private static Damj detectionBornerDateDebutActionFormation(ChronologiePeriodes chronoCache)
  {
    Damj dateMinActionFormation = null;
    
    chronoCache.iterer();
    while (chronoCache.encoreSuivant())
    {
      ObjetChronoPeriode periodeActivite = (ObjetChronoPeriode)chronoCache.elementSuivant();
      if ((periodeActivite instanceof ActionFormation)) {
        if (dateMinActionFormation == null) {
          dateMinActionFormation = ((ActionFormation)periodeActivite).getDateDebut();
        } else {
          dateMinActionFormation = Damj.min(dateMinActionFormation, ((ActionFormation)periodeActivite).getDateDebut());
        }
      }
    }
    return dateMinActionFormation;
  }
  
  private static boolean estCachePeriodeGaecValide(IndividuSpec individu, Damj dateDebut, Damj finPeriode)
  {
    return (individu.getChronoPeriodesCalcul() != null) && (!individu.getChronoPeriodesCalcul().getChronologie().estVide()) && (individu.getChronoPeriodesCalcul().getDebut().estAvantOuCoincideAvec(dateDebut)) && (individu.getChronoPeriodesCalcul().getFin().estApresOuCoincideAvec(finPeriode));
  }
  
  public static ChronologiePeriodes recupererPeriodesGaecNonMapper(IndividuSpec individu, Damj dateDebut, Damj dateFin)
    throws CoucheLogiqueException
  {
    FiltreTemporel filtre = new FiltreChevauchePeriode(new Periode(dateDebut != null ? dateDebut.veille() : Damj.NUIT_DES_TEMPS, dateFin != null ? dateFin : Damj.FIN_DES_TEMPS));
    
    return (ChronologiePeriodes)individu.getChronoPeriodePasseProfessionnelSansFiltrageDNJ().copier(filtre);
  }
  
  public static ChronologiePeriodes recupererRadiations(IndividuSpec individu)
  {
    ChronologiePeriodes listeRadiations = null;
    Chronologie periodesPriseEnChargeOriginales = null;
    ObjetChronoPeriodePriseEnCharge periodePriseEnCharge = null;
    ObjetChronoPeriodeRadiation radiation = null;
    Damj dateRadiation = null;
    ObjetChronoPeriodePEC periodePEC = null;
    ObjetChronoPeriodeNonPEC periodeNonPEC = null;
    String motifAnnulation = null;
    
    listeRadiations = new ChronologiePeriodes();
    
    periodesPriseEnChargeOriginales = recupererPecs(individu);
    periodesPriseEnChargeOriginales.iterer();
    while (periodesPriseEnChargeOriginales.encoreSuivant())
    {
      periodePriseEnCharge = (ObjetChronoPeriodePriseEnCharge)periodesPriseEnChargeOriginales.elementSuivant();
      if (dateRadiation != null)
      {
        if (dateRadiation.estAvantOuCoincideAvec(periodePriseEnCharge.getDateDebut()))
        {
          if (dateRadiation.estAvant(periodePriseEnCharge.getDateDebut())) {
            periodeNonPEC = new ObjetChronoPeriodeNonPEC(dateRadiation, periodePriseEnCharge.getDateDebut().veille());
          } else {
            periodeNonPEC = null;
          }
          radiation = new ObjetChronoPeriodeRadiation(dateRadiation);
          radiation.setPEC(periodePEC);
          radiation.setNonPEC(periodeNonPEC);
          radiation.setMotifAnnulationPEC(motifAnnulation);
          if ((periodePriseEnCharge.getTypePec() != null) && (periodePriseEnCharge.getSousType() != null) && (periodePriseEnCharge.getCodeAuTitre() != null)) {
            radiation.setEstTypeArce(periodePriseEnCharge.estDeTypeArce());
          }
          listeRadiations.ajouter(radiation);
        }
        dateRadiation = null;
      }
      if (periodePriseEnCharge.getDateFin().estAvant(Damj.FIN_DES_TEMPS))
      {
        dateRadiation = periodePriseEnCharge.getDateFin().lendemain();
        motifAnnulation = periodePriseEnCharge.getMotifAnnulation();
      }
      periodePEC = new ObjetChronoPeriodePEC(periodePriseEnCharge.getDateDebut(), periodePriseEnCharge.getDateFin());
    }
    if (dateRadiation != null)
    {
      periodeNonPEC = new ObjetChronoPeriodeNonPEC(dateRadiation, Damj.FIN_DES_TEMPS);
      
      radiation = new ObjetChronoPeriodeRadiation(dateRadiation);
      radiation.setPEC(periodePEC);
      radiation.setNonPEC(periodeNonPEC);
      radiation.setMotifAnnulationPEC(periodePriseEnCharge.getMotifAnnulation());
      listeRadiations.ajouter(radiation);
    }
    return listeRadiations;
  }
  
  public static ObjetChronoAnniversaire50Ans genererAnniversaire50Ans(IndividuSpec individu)
    throws CoucheLogiqueException
  {
    Damj jour50Ans = individu.getDateNaissance().deplacerVersAvant(new DureeCalendaire(50, 0, 0));
    
    return new ObjetChronoAnniversaire50Ans(jour50Ans);
  }
  
  public static ObjetChronoAnniversaire55Ans genererAnniversaire55Ans(IndividuSpec individu)
    throws CoucheLogiqueException
  {
    Damj jour55Ans = individu.getDateNaissance().deplacerVersAvant(new DureeCalendaire(55, 0, 0));
    
    return new ObjetChronoAnniversaire55Ans(jour55Ans);
  }
  
  public static ObjetChronoAnniversaire60Ans genererAnniversaire60Ans(IndividuSpec individu)
    throws CoucheLogiqueException
  {
    Damj jour60Ans = individu.getDateNaissance().deplacerVersAvant(new DureeCalendaire(60, 0, 0));
    
    return new ObjetChronoAnniversaire60Ans(jour60Ans);
  }
  
  public static ObjetChronoRetraiteAuPlusTard genererDateRetraiteAuPlusTard(IndividuSpec individu)
    throws CoucheLogiqueException
  {
    OutilRetraite outilRetraite = OutilRetraite.getInstance();
    return new ObjetChronoRetraiteAuPlusTard(outilRetraite.getDateMaxDepartRetraite(individu));
  }
  
  public static ObjetChronoPeriodeRetraite genererPeriodeRetraite(IndividuSpec individu)
    throws CoucheLogiqueException
  {
    Retraite retraite = OutilRetraite.getInstance().determinerRetraite(individu);
    ObjetChronoPeriodeRetraite periodeRetraite = new ObjetChronoPeriodeRetraite(retraite, Damj.FIN_DES_TEMPS);
    
    periodeRetraite.setNbTrimestreInconnu((individu.getTrimestreRetraite() == null) || (individu.getTrimestreRetraite().getDateEffet() == null) || (individu.getTrimestreRetraite().getNombreTrimestre().intValue() == 0));
    
    return periodeRetraite;
  }
  
  public static Collection intersection(Collection collectionPeriode1, Collection collectionPeriode2)
  {
    Collection intersection = new ArrayList();
    Iterator iterateurCollection1 = null;
    Iterator iterateurCollection2 = null;
    Object item = null;
    Object item2 = null;
    Periode periode = null;
    Periode periode2 = null;
    if ((collectionPeriode1 != null) && (collectionPeriode2 != null))
    {
      iterateurCollection1 = collectionPeriode1.iterator();
      while (iterateurCollection1.hasNext())
      {
        item = iterateurCollection1.next();
        if ((item instanceof Periode)) {
          periode = (Periode)item;
        } else if ((item instanceof ObjetChronoPeriode)) {
          periode = new Periode(((ObjetChronoPeriode)item).getDateDebut(), ((ObjetChronoPeriode)item).getDateFin());
        }
        iterateurCollection2 = collectionPeriode2.iterator();
        while (iterateurCollection2.hasNext())
        {
          item2 = iterateurCollection2.next();
          if ((item2 instanceof Periode)) {
            periode2 = (Periode)item2;
          } else if ((item2 instanceof ObjetChronoPeriode)) {
            periode2 = new Periode(((ObjetChronoPeriode)item2).getDateDebut(), ((ObjetChronoPeriode)item2).getDateFin());
          }
          if (periode.chevauche(periode2)) {
            intersection.add(periode.periodeIntersection(periode2));
          }
        }
      }
    }
    return intersection;
  }
  
  public static ObjetChronoPeriode decoupe(ObjetChronoPeriode periodeADecouper, Damj pdebut, Damj pfin)
  {
    Damj debut = pdebut;
    Damj fin = pfin;
    ObjetChronoPeriode periodeResultat = null;
    if (debut.estAvant(periodeADecouper.getDateDebut())) {
      debut = periodeADecouper.getDateDebut();
    }
    if (fin.estApres(periodeADecouper.getDateFin())) {
      fin = periodeADecouper.getDateFin();
    }
    if (debut.estAvantOuCoincideAvec(fin))
    {
      periodeResultat = (ObjetChronoPeriode)periodeADecouper.copie();
      periodeResultat.setDateDebut(debut);
      periodeResultat.setDateFin(fin);
    }
    return periodeResultat;
  }
  
  public static Collection recupererDecisionsSuivi(IndividuSpec individu)
    throws CoucheLogiqueException
  {
    return individu.getDecisionsSuivi();
  }
  
  public static ChronologiePeriodes recupererPensionsInvaliditeEtAvantagesVieillesse(IndividuSpec individu, Boolean contexteMayotte)
    throws CoucheLogiqueException
  {
    ChronologiePeriodes chronoRetour = new ChronologiePeriodes();
    OutilRetraiteSpec outilRetraite = null;
    if (contexteMayotte.booleanValue()) {
      outilRetraite = OutilRetraite.getInstance();
    } else {
      outilRetraite = OutilRetraiteMayotte.getInstance();
    }
    ChronologiePeriodes chronoPiEtAv = individu.getChronoPensionsInvaliditeEtAvantagesVieillesse();
    if (chronoPiEtAv != null)
    {
      chronoPiEtAv.iterer();
      while (chronoPiEtAv.encoreSuivant())
      {
        ObjetChronoPeriode periode = (ObjetChronoPeriode)chronoPiEtAv.elementSuivant();
        ObjetChronoPeriode periodeCopie = (ObjetChronoPeriode)periode.copie();
        if (((periode instanceof PeriodeAvantageVieillesse)) && ((((PeriodeAvantageVieillesse)periode).getCodeNature().equals("1")) || (((PeriodeAvantageVieillesse)periode).getCodeNature().equals("M")))) {
          periodeCopie.setDateDebut(Damj.max(periode.getDateDebut(), individu.getDateNaissance().deplacerVersAvant(outilRetraite.getAgeMinDepartRetraite(individu))));
        }
        chronoRetour.ajouter(periodeCopie);
      }
    }
    return chronoRetour;
  }
  
  public static ChronologiePeriodes recupererPensionsInvaliditeEtAvantagesVieillesseSansModifierBornes(IndividuSpec individu)
    throws CoucheLogiqueException
  {
    ChronologiePeriodes chronoRetour = new ChronologiePeriodes();
    ChronologiePeriodes chronoPiEtAv = individu.getChronoPensionsInvaliditeEtAvantagesVieillesse();
    if (chronoPiEtAv != null)
    {
      chronoPiEtAv.iterer();
      while (chronoPiEtAv.encoreSuivant())
      {
        ObjetChronoPeriode periode = (ObjetChronoPeriode)chronoPiEtAv.elementSuivant();
        ObjetChronoPeriode periodeCopie = (ObjetChronoPeriode)periode.copie();
        chronoRetour.ajouter(periodeCopie);
      }
    }
    return chronoRetour;
  }
  
  public static ChronologiePeriodes recupererPensionsInvaliditeChainees(IndividuSpec individu)
    throws CoucheLogiqueException
  {
    ChronologiePeriodes chronoARetourner = new ChronologiePeriodes();
    ChronologiePeriodes chronoPiChainees = individu.getChronoPensionsInvaliditeChainees();
    
    chronoPiChainees.iterer();
    while (chronoPiChainees.encoreSuivant())
    {
      PeriodePensionInvaliditeChainee piChainee = (PeriodePensionInvaliditeChainee)chronoPiChainees.elementSuivant();
      chronoARetourner.ajouter(piChainee.getListeSousPensionInvalidite());
      chronoARetourner.ajouter(piChainee.getListeFinsPeriodesPensionInvalite());
    }
    return chronoARetourner;
  }
  
  public static Damj calculerDateBlocageTransfert(Chronologie chronoDemandes, String refExterne)
    throws CoucheLogiqueException
  {
    chronoDemandes.iterer();
    while (chronoDemandes.encoreSuivant())
    {
      DemandeSpec demandeCourante = (DemandeSpec)chronoDemandes.elementSuivant();
      if (refExterne.equals(demandeCourante.getFormulaire().getReferenceExterne())) {
        return demandeCourante.getDateExamen();
      }
    }
    return null;
  }
  
  public static ChronologiePeriodes recupererPecsSansFiltre(IndividuSpec individu)
  {
    ChronologiePeriodes chronologiePeriodesPEC = new ChronologiePeriodes();
    
    Chronologie listePecSansFiltre = individu.getChronologiePecNonFusionneesFinCI();
    if (listePecSansFiltre != null)
    {
      listePecSansFiltre.iterer();
      while (listePecSansFiltre.encoreSuivant())
      {
        ObjetChronoPeriodePriseEnChargeSansFiltre periodePecCali = (ObjetChronoPeriodePriseEnChargeSansFiltre)listePecSansFiltre.elementSuivant();
        if (!periodePecCali.getDateDebut().coincideAvec(periodePecCali.getDateFin()))
        {
          ObjetChronoPeriodePriseEnChargeSansFiltre periodePecCaliPourCalcul = (ObjetChronoPeriodePriseEnChargeSansFiltre)periodePecCali.copie();
          periodePecCaliPourCalcul.setDateFin(periodePecCali.getDateFin().veille());
          chronologiePeriodesPEC.ajouter(periodePecCaliPourCalcul);
        }
      }
    }
    return chronologiePeriodesPEC;
  }
  
  public static ChronologiePeriodes recupererPecsRadiationSuiteEntreeFormation(IndividuSpec individu)
  {
    ChronologiePeriodes listeRadiations = null;
    Chronologie periodesPriseEnChargeOriginales = null;
    ObjetChronoPeriodePriseEnCharge periodePriseEnCharge = null;
    ObjetChronoPeriodeRadiation radiation = null;
    Damj dateRadiation = null;
    ObjetChronoPeriodePEC periodePEC = null;
    ObjetChronoPeriodeNonPEC periodeNonPEC = null;
    String motifAnnulation = null;
    
    listeRadiations = new ChronologiePeriodes();
    
    periodesPriseEnChargeOriginales = recupererPecsSansFiltre(individu);
    periodesPriseEnChargeOriginales.iterer();
    while (periodesPriseEnChargeOriginales.encoreSuivant())
    {
      periodePriseEnCharge = (ObjetChronoPeriodePriseEnCharge)periodesPriseEnChargeOriginales.elementSuivant();
      if ((dateRadiation != null) && (motifAnnulation != null))
      {
        if (dateRadiation.estAvantOuCoincideAvec(periodePriseEnCharge.getDateDebut()))
        {
          if (dateRadiation.estAvant(periodePriseEnCharge.getDateDebut())) {
            periodeNonPEC = new ObjetChronoPeriodeNonPEC(dateRadiation, periodePriseEnCharge.getDateDebut().veille());
          } else {
            periodeNonPEC = null;
          }
          if (motifAnnulation.equalsIgnoreCase("34"))
          {
            radiation = new ObjetChronoPeriodeRadiation(dateRadiation);
            radiation.setPEC(periodePEC);
            radiation.setNonPEC(periodeNonPEC);
            radiation.setMotifAnnulationPEC(motifAnnulation);
            listeRadiations.ajouter(radiation);
          }
        }
        dateRadiation = null;
      }
      if (periodePriseEnCharge.getDateFin().estAvant(Damj.FIN_DES_TEMPS))
      {
        dateRadiation = periodePriseEnCharge.getDateFin().lendemain();
        motifAnnulation = periodePriseEnCharge.getMotifAnnulation();
      }
      periodePEC = new ObjetChronoPeriodePEC(periodePriseEnCharge.getDateDebut(), periodePriseEnCharge.getDateFin());
    }
    if ((dateRadiation != null) && (motifAnnulation != null))
    {
      periodeNonPEC = new ObjetChronoPeriodeNonPEC(dateRadiation, Damj.FIN_DES_TEMPS);
      if (motifAnnulation.equalsIgnoreCase("34"))
      {
        radiation = new ObjetChronoPeriodeRadiation(dateRadiation);
        radiation.setPEC(periodePEC);
        radiation.setNonPEC(periodeNonPEC);
        radiation.setMotifAnnulationPEC(periodePriseEnCharge.getMotifAnnulation());
        listeRadiations.ajouter(radiation);
      }
    }
    return listeRadiations;
  }
  
  public static ChronologiePeriodes recupererPecs(IndividuSpec individu)
  {
    ChronologiePeriodes chronologiePeriodesPEC = new ChronologiePeriodes();
    
    Chronologie listePec = individu.getChronologiePecFusionneesFinCI();
    if (listePec != null)
    {
      listePec.iterer();
      while (listePec.encoreSuivant())
      {
        ObjetChronoPeriodePriseEnCharge periodePecCali = (ObjetChronoPeriodePriseEnCharge)listePec.elementSuivant();
        if (!periodePecCali.getDateDebut().coincideAvec(periodePecCali.getDateFin()))
        {
          ObjetChronoPeriodePriseEnCharge periodePecCaliNonAnullees = (ObjetChronoPeriodePriseEnCharge)periodePecCali.copie();
          periodePecCaliNonAnullees.setDateFin(periodePecCali.getDateFin().veille());
          chronologiePeriodesPEC.ajouter(periodePecCaliNonAnullees);
        }
      }
    }
    return chronologiePeriodesPEC;
  }
  
  public static ObjetChronoPeriodePriseEnCharge recupererPeriodePECContenant(IndividuSpec individu, Damj date)
  {
    Chronologie chronologiePeriodesPEC = null;
    Iterator iterateur = null;
    ObjetChronoPeriodePriseEnCharge objetChronoPeriodePriseEnCharge = null;
    ObjetChronoPeriodePriseEnCharge retour = null;
    
    chronologiePeriodesPEC = recupererPecs(individu);
    if (chronologiePeriodesPEC != null)
    {
      iterateur = chronologiePeriodesPEC.iterer();
      while ((iterateur.hasNext()) && (retour == null))
      {
        objetChronoPeriodePriseEnCharge = (ObjetChronoPeriodePriseEnCharge)iterateur.next();
        if ((objetChronoPeriodePriseEnCharge != null) && (new Periode(objetChronoPeriodePriseEnCharge.getDateDebut(), objetChronoPeriodePriseEnCharge.getDateFin()).contient(date))) {
          retour = objetChronoPeriodePriseEnCharge;
        }
      }
    }
    return retour;
  }
  
  public static ChronologiePeriodes recuperationDeToutesLesDesPeriodes(IndividuSpec individu, AttributionSpec attribution, Damj dateFin)
    throws CoucheLogiqueException
  {
    ChronologiePeriodes chronologiePeriodesPourAttribution = new ChronologiePeriodes();
    ChronologiePeriodes chronologieRetraite = new ChronologiePeriodes();
    Collection collectionPeriodesPourAttribution = new LinkedList();
    Collection decisionsSuivi = null;
    
    ChronologiePeriodes chronologiePeriodesGAEC = recupererPeriodesGAEC(individu, attribution.getDateAttribution(), dateFin);
    decisionsSuivi = recupererDecisionsSuivi(individu);
    ChronologiePeriodes chronologiePeriodesSanctions = GestionSanctions.recupererSanctions(decisionsSuivi);
    ChronologiePeriodes chronologiePeriodesPEC = recupererRadiations(individu);
    ObjetChronoPeriodeRetraite chronoRetraite = genererPeriodeRetraite(individu);
    chronologieRetraite.ajouter(chronoRetraite);
    
    collectionPeriodesPourAttribution.addAll(chronologiePeriodesGAEC.mapperVersCollection());
    collectionPeriodesPourAttribution.addAll(chronologiePeriodesPEC.mapperVersCollection());
    collectionPeriodesPourAttribution.addAll(chronologiePeriodesSanctions.mapperVersCollection());
    collectionPeriodesPourAttribution.addAll(chronologieRetraite.mapperVersCollection());
    if (individu.getDateBlocageIndemnisation() != null)
    {
      PeriodeBlocageIndemnisation periodeBlocageIndemnisation = new PeriodeBlocageIndemnisation(individu.getDateBlocageIndemnisation().lendemain());
      
      collectionPeriodesPourAttribution.add(periodeBlocageIndemnisation);
    }
    chronologiePeriodesPourAttribution.ajouter(collectionPeriodesPourAttribution);
    
    return chronologiePeriodesPourAttribution;
  }
  
  public static ObjetChronoPeriodeLendemainDja genererLendemainDja(IndividuSpec individu)
    throws CoucheLogiqueException
  {
    return new ObjetChronoPeriodeLendemainDja(individu.getDernierJourAtteste().lendemain());
  }
  
  public static boolean estRadiationFaisantSuitePecCA(AttributionSpec attribution, Damj dateRadiation)
  {
    ChronologiePeriodes test = recupererPecsSansFiltre(attribution.getDemandeur());
    Iterator ite = test.iterer();
    while (ite.hasNext())
    {
      ObjetChronoPeriodePriseEnChargeSansFiltre pec = (ObjetChronoPeriodePriseEnChargeSansFiltre)ite.next();
      if ((pec.getDateFin().lendemain().coincideAvec(dateRadiation)) && (pec.getTypePec() != null) && (pec.getTypePec().compareTo("1") == 0) && (pec.getCategorie() != null) && (pec.getCategorie().compareTo("5") == 0) && (pec.getSousType() != null) && (pec.getSousType().compareTo("7") == 0) && (pec.getSituationEmploi() != null) && ((pec.getSituationEmploi().compareTo("CAV") == 0) || (pec.getSituationEmploi().compareTo("RMA") == 0) || (pec.getSituationEmploi().compareTo("CAE") == 0) || (pec.getSituationEmploi().compareTo("CUN") == 0) || (pec.getSituationEmploi().compareTo("CUM") == 0) || (pec.getSituationEmploi().compareTo("EAN") == 0) || (pec.getSituationEmploi().compareTo("EAP") == 0) || (pec.getSituationEmploi().compareTo("EAM") == 0))) {
        return true;
      }
    }
    return false;
  }
  
  public ChronologiePeriodes getChronologiePeriodesCalcul()
  {
    return chronologiePeriodes;
  }
  
  public void setChronologiePeriodesCalcul(ChronologiePeriodes chronologiePeriodesCalcul)
  {
    chronologiePeriodes = chronologiePeriodesCalcul;
  }
}

/* Location:
 * Qualified Name:     OutillagePeriodes
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */