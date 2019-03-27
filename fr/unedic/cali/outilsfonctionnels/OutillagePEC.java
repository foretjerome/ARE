package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.cali.autresdoms.cohab.dom.ObjetChronoPeriodePriseEnCharge;
import fr.unedic.cali.autresdoms.cohab.dom.ObjetChronoPeriodePriseEnChargeSansFiltre;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.FormulaireSpec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltrePecAutreEtatMembreCoordination;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltrePecDemandeurEmploi;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.ComparateurTemporelsSurDateDebut;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.FiltreDebutApresDate;
import fr.unedic.util.temps.FiltreDebutAvantDate;
import fr.unedic.util.temps.FiltreFinAvantOuCoincideAvecDate;
import fr.unedic.util.temps.FiltresTemporel;
import fr.unedic.util.temps.Periode;
import fr.unedic.util.temps.Temporel;
import java.util.Comparator;
import java.util.Iterator;

public class OutillagePEC
{
  public static final String TYPE_PEC_CSP_1 = "1";
  public static final String TYPE_PEC_CSP_2 = "2";
  public static final String SOUS_TYPE_PEC_CSP = "6";
  public static final String SITUATION_EMPLOI_CSP = "CSP";
  public static final String SITUATION_PARTICULIERE_PAP = "PAP";
  
  public static ObjetChronoPeriodePriseEnChargeSansFiltre getPeriodePECContenant(IndividuSpec individu, Damj date)
  {
    ObjetChronoPeriodePriseEnChargeSansFiltre retour = null;
    
    Chronologie chronologiePeriodesPEC = individu.getChronologiePecNonFusionneesFinCI();
    if (chronologiePeriodesPEC != null)
    {
      Iterator iterateur = chronologiePeriodesPEC.iterer();
      while (iterateur.hasNext())
      {
        ObjetChronoPeriodePriseEnChargeSansFiltre objetChronoPeriodePriseEnCharge = (ObjetChronoPeriodePriseEnChargeSansFiltre)iterateur.next();
        if (new Periode(objetChronoPeriodePriseEnCharge.getDateDebut(), objetChronoPeriodePriseEnCharge.getDateFin()).contient(date)) {
          retour = objetChronoPeriodePriseEnCharge;
        }
      }
    }
    return retour;
  }
  
  public static ObjetChronoPeriodePriseEnCharge getPeriodePECIndemnisableContenant(IndividuSpec individu, Damj date)
  {
    ObjetChronoPeriodePriseEnCharge retour = null;
    
    Chronologie chronologiePeriodesPEC = individu.getChronologiePecFusionneesFinCI();
    Iterator iterateur = chronologiePeriodesPEC.iterer();
    while (iterateur.hasNext())
    {
      ObjetChronoPeriodePriseEnCharge objetChronoPeriodePriseEnChargeCourant = (ObjetChronoPeriodePriseEnCharge)iterateur.next();
      
      Periode pecCourante = new Periode(objetChronoPeriodePriseEnChargeCourant.getDateDebut(), objetChronoPeriodePriseEnChargeCourant.getDateFin().veille());
      if (pecCourante.contient(date))
      {
        ObjetChronoPeriodePriseEnCharge objetChronoPeriodePriseEnChargeRetenu = (ObjetChronoPeriodePriseEnCharge)objetChronoPeriodePriseEnChargeCourant.copie();
        objetChronoPeriodePriseEnChargeRetenu.setDateFin(objetChronoPeriodePriseEnChargeCourant.getDateFin().veille());
        retour = objetChronoPeriodePriseEnChargeRetenu;
      }
    }
    return retour;
  }
  
  public static ObjetChronoPeriodePriseEnChargeSansFiltre getPeriodePEC(IndividuSpec individu, int idPec)
  {
    ObjetChronoPeriodePriseEnChargeSansFiltre retour = null;
    
    Chronologie chronologiePeriodesPEC = individu.getChronologiePecNonFusionneesFinCI();
    Iterator iterateur = chronologiePeriodesPEC.iterer();
    while ((iterateur.hasNext()) && (retour == null))
    {
      ObjetChronoPeriodePriseEnChargeSansFiltre objetChronoPeriodePriseEnCharge = (ObjetChronoPeriodePriseEnChargeSansFiltre)iterateur.next();
      if (objetChronoPeriodePriseEnCharge.getIdentifiantPec() == idPec) {
        retour = objetChronoPeriodePriseEnCharge;
      }
    }
    return retour;
  }
  
  public static Damj getPremierJourPECNonAnnuleesApresDate(IndividuSpec individu, Damj date)
  {
    Damj retour = null;
    
    Chronologie chronologiePeriodesPEC = individu.getChronologiePecFusionneesFinCI().copier();
    chronologiePeriodesPEC.iterer();
    while ((chronologiePeriodesPEC.encoreSuivant()) && (retour == null))
    {
      ObjetChronoPeriodePriseEnCharge objetChronoPeriodePriseEnCharge = (ObjetChronoPeriodePriseEnCharge)chronologiePeriodesPEC.elementSuivant();
      if (objetChronoPeriodePriseEnCharge.getDateDebut().estApres(date)) {
        retour = objetChronoPeriodePriseEnCharge.getDateDebut();
      }
    }
    return retour;
  }
  
  public static Chronologie getPeriodesPecDebutApresDate(IndividuSpec individu, Damj date)
  {
    Chronologie chronologiePeriodesPEC = individu.getChronologiePecNonFusionneesFinCI().copier(new FiltreDebutApresDate(date));
    if (!chronologiePeriodesPEC.estVide()) {
      chronologiePeriodesPEC.setComparateur(new ComparateurTemporelsSurDateDebut());
    }
    return chronologiePeriodesPEC;
  }
  
  public static Chronologie getPeriodesPecFusionneesDebutApresDate(IndividuSpec individu, Damj date)
  {
    Chronologie chronologiePeriodesPEC = individu.getChronologiePecFusionneesFinCI().copier(new FiltreDebutApresDate(date));
    if (!chronologiePeriodesPEC.estVide()) {
      chronologiePeriodesPEC.setComparateur(new ComparateurTemporelsSurDateDebut());
    }
    return chronologiePeriodesPEC;
  }
  
  public static ObjetChronoPeriodePriseEnChargeSansFiltre getPecDebutAvantDate(IndividuSpec individu, Damj date)
  {
    Chronologie chronologiePeriodesPEC = getPeriodesPecDebutAvantDate(individu, date);
    ObjetChronoPeriodePriseEnChargeSansFiltre objetChronoPeriodePriseEnCharge = null;
    
    Iterator iterateur = chronologiePeriodesPEC.iterer();
    while (iterateur.hasNext()) {
      objetChronoPeriodePriseEnCharge = (ObjetChronoPeriodePriseEnChargeSansFiltre)iterateur.next();
    }
    return objetChronoPeriodePriseEnCharge;
  }
  
  public static Chronologie getPeriodesPecDebutAvantDate(IndividuSpec individu, Damj date)
  {
    Chronologie chronologiePeriodesPEC = individu.getChronologiePecNonFusionneesFinCI().copier(new FiltreDebutAvantDate(date));
    if (!chronologiePeriodesPEC.estVide()) {
      chronologiePeriodesPEC.setComparateur(new ComparateurTemporelsSurDateDebut());
    }
    return chronologiePeriodesPEC;
  }
  
  public static Chronologie getPeriodesPecFinAvantOuCoincideAvecDate(IndividuSpec individu, Damj date)
  {
    Chronologie chronologiePeriodesPEC = individu.getChronologiePecFusionneesFinCI().copier(new FiltreFinAvantOuCoincideAvecDate(date));
    if (!chronologiePeriodesPEC.estVide()) {
      chronologiePeriodesPEC.setComparateur(new ComparateurTemporelsSurDateDebut());
    }
    return chronologiePeriodesPEC;
  }
  
  public static Damj getDebutPecAvantOuCoincideAvecDate(IndividuSpec individu, Damj date)
  {
    Damj dateDebutPec = null;
    if ((individu.getChronologiePecFusionneesFinCI() != null) && (!individu.getChronologiePecFusionneesFinCI().estVide()))
    {
      Chronologie chronologiePeriodesPEC = individu.getChronologiePecFusionneesFinCI().copier(new FiltreDebutAvantDate(date.lendemain()));
      if (!chronologiePeriodesPEC.estVide())
      {
        chronologiePeriodesPEC.setComparateur(new ComparateurTemporelsSurDateDebut());
        
        Temporel dernierElement = chronologiePeriodesPEC.dernierElement();
        if (dernierElement != null) {
          dateDebutPec = dernierElement.getDateDebut();
        }
      }
    }
    return dateDebutPec;
  }
  
  public static Chronologie getPeriodesPecChevauchePeriode(Chronologie chronologiePeriodesPEC, Periode periode)
  {
    Chronologie chronologiePeriodesPECRetour = new ChronologiePeriodes();
    
    Iterator iterateur = chronologiePeriodesPEC.iterer();
    while (iterateur.hasNext())
    {
      ObjetChronoPeriodePriseEnCharge objetChronoPeriodePriseEnChargeCourant = (ObjetChronoPeriodePriseEnCharge)iterateur.next();
      Periode pecCourante = new Periode(objetChronoPeriodePriseEnChargeCourant.getDateDebut(), objetChronoPeriodePriseEnChargeCourant.getDateFin().veille());
      if (periode.chevauche(pecCourante))
      {
        ObjetChronoPeriodePriseEnCharge objetChronoPeriodePriseEnChargeRetenu = (ObjetChronoPeriodePriseEnCharge)objetChronoPeriodePriseEnChargeCourant.copie();
        objetChronoPeriodePriseEnChargeRetenu.setDateFin(objetChronoPeriodePriseEnChargeCourant.getDateFin().veille());
        chronologiePeriodesPECRetour.ajouter(objetChronoPeriodePriseEnChargeRetenu);
      }
    }
    return chronologiePeriodesPECRetour;
  }
  
  public static ObjetChronoPeriodePriseEnCharge getPecIndemnisablePrecedente(IndividuSpec individu, int idPec)
  {
    Damj datePivot = getPeriodePEC(individu, idPec).getDateDebut();
    
    return getPecIndemnisablePrecedente(individu, datePivot);
  }
  
  public static ObjetChronoPeriodePriseEnCharge getPECDemandeurEmploiPrecedente(IndividuSpec individu, int idPec)
  {
    Damj datePivot = getPeriodePEC(individu, idPec).getDateDebut();
    
    return getPecDemandeurEmploiPrecedente(individu, datePivot);
  }
  
  public static ObjetChronoPeriodePriseEnCharge getPecDemandeurEmploiPrecedente(IndividuSpec individu, Damj date)
  {
    Chronologie chronologiePeriodesPEC = individu.getChronologiePecNonFusionneesFinCI().copier(new FiltreFinAvantOuCoincideAvecDate(date));
    if (!chronologiePeriodesPEC.estVide())
    {
      chronologiePeriodesPEC.setComparateur(new ComparateurTemporelSurDateFinDecroissante());
      return (ObjetChronoPeriodePriseEnCharge)chronologiePeriodesPEC.premierElement();
    }
    return null;
  }
  
  public static boolean estContenueDansUnePecIndemnisable(IndividuSpec individu, Damj date)
  {
    return getPeriodePECIndemnisableContenant(individu, date) != null;
  }
  
  public static ObjetChronoPeriodePriseEnChargeSansFiltre getPeriodePECSansFiltreContenant(IndividuSpec individu, Damj date)
  {
    ObjetChronoPeriodePriseEnChargeSansFiltre retour = null;
    
    Chronologie chronologiePeriodesPEC = individu.getChronologiePecNonFusionneesFinCI();
    if (chronologiePeriodesPEC != null)
    {
      Iterator iterateur = chronologiePeriodesPEC.iterer();
      while (iterateur.hasNext())
      {
        ObjetChronoPeriodePriseEnChargeSansFiltre objetChronoPeriodePriseEnChargeCourant = (ObjetChronoPeriodePriseEnChargeSansFiltre)iterateur.next();
        
        Periode pecCourante = new Periode(objetChronoPeriodePriseEnChargeCourant.getDateDebut(), objetChronoPeriodePriseEnChargeCourant.getDateFin().veille());
        if (pecCourante.contient(date))
        {
          ObjetChronoPeriodePriseEnChargeSansFiltre objetChronoPeriodePriseEnChargeRetenu = (ObjetChronoPeriodePriseEnChargeSansFiltre)objetChronoPeriodePriseEnChargeCourant.copie();
          objetChronoPeriodePriseEnChargeRetenu.setDateFin(objetChronoPeriodePriseEnChargeCourant.getDateFin().veille());
          retour = objetChronoPeriodePriseEnChargeRetenu;
        }
      }
    }
    return retour;
  }
  
  public static ObjetChronoPeriodePriseEnCharge getPecIndemnisablePrecedente(IndividuSpec individu, Damj date)
  {
    Chronologie chronologiePeriodesPEC = individu.getChronologiePecFusionneesFinCI().copier(new FiltreFinAvantOuCoincideAvecDate(date));
    if (!chronologiePeriodesPEC.estVide())
    {
      chronologiePeriodesPEC.setComparateur(new ComparateurTemporelSurDateFinDecroissante());
      return (ObjetChronoPeriodePriseEnCharge)chronologiePeriodesPEC.premierElement();
    }
    return null;
  }
  
  public static ObjetChronoPeriodePriseEnCharge getPecIndemnisableSuivante(IndividuSpec individu, Damj date)
  {
    Chronologie chronologiePeriodesPEC = individu.getChronologiePecFusionneesFinCI().copier(new FiltreDebutApresDate(date.lendemain()));
    if (!chronologiePeriodesPEC.estVide()) {
      return (ObjetChronoPeriodePriseEnCharge)chronologiePeriodesPEC.premierElement();
    }
    return null;
  }
  
  public static Damj determinerProchaineDateDansPECIndemnisableSansObjet(DemandeSpec demande, Damj date)
    throws CoucheLogiqueException
  {
    Damj prochaineDateDansPECIndemnisable = date;
    if (date != null)
    {
      ObjetChronoPeriodePriseEnCharge periodePECDjiParEpuisement = getPeriodePECIndemnisableContenant(demande.getDemandeur(), date);
      if (periodePECDjiParEpuisement == null) {
        prochaineDateDansPECIndemnisable = getPremierJourPECNonAnnuleesApresDate(demande.getDemandeur(), date);
      }
    }
    if (prochaineDateDansPECIndemnisable == null) {
      GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_L_ERR_DATE_EXAMEN_PAS_PEC_INDEMN_SO", new Object[] { date });
    }
    return prochaineDateDansPECIndemnisable;
  }
  
  public static ObjetChronoPeriodePriseEnCharge getPeriodePecDemandeurEmploiContenant(IndividuSpec individu, Damj date)
  {
    ObjetChronoPeriodePriseEnCharge retour = null;
    
    Chronologie chronologiePeriodesPEC = individu.getChronologiePecFusionneesFinCI();
    Iterator iterateur = chronologiePeriodesPEC.iterer();
    while (iterateur.hasNext())
    {
      ObjetChronoPeriodePriseEnCharge objetChronoPeriodePriseEnChargeCourant = (ObjetChronoPeriodePriseEnCharge)iterateur.next();
      
      Periode pecCourante = new Periode(objetChronoPeriodePriseEnChargeCourant.getDateDebut(), objetChronoPeriodePriseEnChargeCourant.getDateFin().veille());
      if ((pecCourante.contient(date)) && (objetChronoPeriodePriseEnChargeCourant.getDemandeurEmploi()))
      {
        ObjetChronoPeriodePriseEnCharge objetChronoPeriodePriseEnChargeRetenu = (ObjetChronoPeriodePriseEnCharge)objetChronoPeriodePriseEnChargeCourant.copie();
        objetChronoPeriodePriseEnChargeRetenu.setDateFin(objetChronoPeriodePriseEnChargeCourant.getDateFin().veille());
        retour = objetChronoPeriodePriseEnChargeRetenu;
      }
    }
    return retour;
  }
  
  public static Damj getPremierJourPECDemandeur(IndividuSpec individu, Damj date)
  {
    Damj retour = null;
    
    Chronologie chronologiePeriodesPEC = individu.getChronologiePecFusionneesFinCI().copier();
    chronologiePeriodesPEC.iterer();
    while ((chronologiePeriodesPEC.encoreSuivant()) && (retour == null))
    {
      ObjetChronoPeriodePriseEnCharge objetChronoPeriodePriseEnCharge = (ObjetChronoPeriodePriseEnCharge)chronologiePeriodesPEC.elementSuivant();
      if ((objetChronoPeriodePriseEnCharge.getDateDebut().estApres(date)) && (objetChronoPeriodePriseEnCharge.getDemandeurEmploi())) {
        retour = objetChronoPeriodePriseEnCharge.getDateDebut();
      }
    }
    return retour;
  }
  
  public static Damj getPremierJourPECDemandeurMayotteExclu(IndividuSpec individu, Damj date)
  {
    Damj retour = null;
    
    Chronologie chronologiePeriodesPEC = individu.getChronologiePecFusionneesFinCI().copier();
    chronologiePeriodesPEC.iterer();
    while ((chronologiePeriodesPEC.encoreSuivant()) && (retour == null))
    {
      ObjetChronoPeriodePriseEnCharge objetChronoPeriodePriseEnCharge = (ObjetChronoPeriodePriseEnCharge)chronologiePeriodesPEC.elementSuivant();
      if ((objetChronoPeriodePriseEnCharge.getDateDebut().estApres(date)) && (objetChronoPeriodePriseEnCharge.getDemandeurEmploi()) && (!"M".equals(objetChronoPeriodePriseEnCharge.getContextePECNonIndemnisable()))) {
        retour = objetChronoPeriodePriseEnCharge.getDateDebut();
      }
    }
    return retour;
  }
  
  public static Chronologie getListePecDemandeurEmploiTrie(IndividuSpec individu, Comparator comparateur)
  {
    FiltresTemporel filtre = new FiltresTemporel();
    filtre.ajouterFiltre(new FiltrePecDemandeurEmploi(true));
    
    Chronologie chronologiePeriodesPEC = individu.getChronologiePecFusionneesFinCI().copier(filtre);
    chronologiePeriodesPEC.setComparateur(comparateur);
    
    return chronologiePeriodesPEC;
  }
  
  public static Chronologie getPeriodesPecAutreEtatMembreCoordination(IndividuSpec individu)
  {
    FiltresTemporel filtre = new FiltresTemporel();
    filtre.ajouterFiltre(new FiltrePecAutreEtatMembreCoordination());
    
    ChronologiePeriodes chronologiePecsIndemnisable = new ChronologiePeriodes();
    Chronologie chronologiePeriodesPEC = individu.getChronologiePecFusionneesFinCI().copier(filtre);
    if (!chronologiePeriodesPEC.estVide()) {
      chronologiePeriodesPEC.setComparateur(new ComparateurTemporelsSurDateDebut());
    }
    chronologiePeriodesPEC.iterer();
    while (chronologiePeriodesPEC.encoreSuivant())
    {
      ObjetChronoPeriodePriseEnCharge objetChronoPeriodePriseEnCharge = (ObjetChronoPeriodePriseEnCharge)((ObjetChronoPeriodePriseEnCharge)chronologiePeriodesPEC.elementSuivant()).copie();
      objetChronoPeriodePriseEnCharge.setDateFin(objetChronoPeriodePriseEnCharge.getDateFin().veille());
      chronologiePecsIndemnisable.ajouter(objetChronoPeriodePriseEnCharge);
    }
    return chronologiePeriodesPEC;
  }
  
  public static Chronologie getPeriodesPecAutreEtatMembreCoordinationDebutApresDate(IndividuSpec individu, Damj date)
  {
    return getPeriodesPecAutreEtatMembreCoordination(individu).copier(new FiltreDebutApresDate(date));
  }
  
  public static Chronologie getPeriodesPecAutreEtatMembreCoordinationDebutAvantDate(IndividuSpec individu, Damj date)
  {
    return getPeriodesPecAutreEtatMembreCoordination(individu).copier(new FiltreDebutAvantDate(date));
  }
  
  public static boolean estDoubleInscriptionFrontalierCoordination(IndividuSpec individu, Damj date)
  {
    ObjetChronoPeriodePriseEnCharge pecCourante = getPeriodePECContenant(individu, date);
    if ((pecCourante != null) && (pecCourante.getContexteEESSI() != null) && (pecCourante.getContexteEESSI().equals("3"))) {
      return true;
    }
    return false;
  }
  
  public static boolean estPecDroitMaintenuAutreEtatMembreCoordination(IndividuSpec individu, Damj date)
  {
    ObjetChronoPeriodePriseEnCharge pecCourante = getPeriodePECContenant(individu, date);
    if ((pecCourante != null) && (pecCourante.getContexteEESSI() != null) && (pecCourante.getContexteEESSI().equals("2"))) {
      return true;
    }
    return false;
  }
  
  public static boolean estPecAutreEtatMembreCoordination(ObjetChronoPeriodePriseEnCharge pec)
  {
    boolean retour = false;
    boolean estPecNonNull = (pec != null) && (pec.getTypePec() != null) && (pec.getSousType() != null);
    if ((estPecNonNull) && (pec.getTypePec().equals("2")) && (pec.getSousType().equals("7"))) {
      retour = true;
    }
    return retour;
  }
  
  public static boolean estPecSuivanteAutreEtatMembreCoordination(IndividuSpec individu, Damj date)
  {
    return estPecAutreEtatMembreCoordination(getPecFusionneeSuivante(individu, date));
  }
  
  public static ObjetChronoPeriodePriseEnCharge getPecFusionneeSuivante(IndividuSpec individu, Damj date)
  {
    ObjetChronoPeriodePriseEnCharge retour = null;
    Chronologie chronologiesPecs = getPeriodesPecFusionneesDebutApresDate(individu, date);
    if (chronologiesPecs.getTaille() > 0) {
      retour = (ObjetChronoPeriodePriseEnCharge)chronologiesPecs.premierElement();
    }
    return retour;
  }
  
  public static ObjetChronoPeriodePriseEnCharge getPecFusionneeSuivanteNonAutreEtatMembreCoordination(IndividuSpec individu, Damj date)
  {
    ObjetChronoPeriodePriseEnCharge retour = null;
    boolean trouve = false;
    Chronologie chronologiesPecs = getPeriodesPecFusionneesDebutApresDate(individu, date);
    chronologiesPecs.iterer();
    while ((chronologiesPecs.encoreSuivant()) && (!trouve))
    {
      retour = (ObjetChronoPeriodePriseEnCharge)chronologiesPecs.elementSuivant();
      if (!estPecAutreEtatMembreCoordination(retour)) {
        trouve = true;
      }
    }
    return retour;
  }
  
  public static boolean estPecMayotte(IndividuSpec individu, Damj date)
  {
    ObjetChronoPeriodePriseEnCharge pecCourante = getPeriodePECContenant(individu, date);
    if ((pecCourante != null) && (pecCourante.getContextePECNonIndemnisable() != null) && (pecCourante.getContextePECNonIndemnisable().equals("M"))) {
      return true;
    }
    return false;
  }
  
  public static boolean estPecMayotte(ObjetChronoPeriodePriseEnCharge pecCourante)
  {
    boolean retour = false;
    if ((pecCourante != null) && (pecCourante.getContextePECNonIndemnisable() != null) && (pecCourante.getContextePECNonIndemnisable().equals("M"))) {
      retour = true;
    }
    return retour;
  }
  
  public static boolean demandeSurPecAnnuleeOuFusionneeOuHorsPec(Individu individu, DemandeSpec demande)
  {
    boolean estPecAnnuleeOuFusioneeOuHorsPec = true;
    
    int idPec = demande.getFormulaire().getIdPec();
    ObjetChronoPeriodePriseEnChargeSansFiltre pecDemande;
    ObjetChronoPeriodePriseEnChargeSansFiltre pecDemande;
    if (idPec != 0) {
      pecDemande = getPeriodePEC(individu, idPec);
    } else {
      pecDemande = getPeriodePECContenant(individu, demande.getDateDeclenchementExamen());
    }
    Chronologie chronoPecFusionne = individu.getChronologiePecFusionneesFinCI();
    Iterator ite = chronoPecFusionne.iterer();
    if (pecDemande != null) {
      while (ite.hasNext())
      {
        ObjetChronoPeriodePriseEnCharge pec = (ObjetChronoPeriodePriseEnCharge)ite.next();
        if (pecDemande.getIdentifiantPec() == pec.getIdentifiantPec()) {
          estPecAnnuleeOuFusioneeOuHorsPec = false;
        }
      }
    }
    return estPecAnnuleeOuFusioneeOuHorsPec;
  }
  
  public static Chronologie getChronologiePecsDemandeurEmploiSurPeriode(IndividuSpec individu, Periode periode)
  {
    Chronologie retour = new ChronologiePeriodes();
    Chronologie chronologiePeriodesPEC = getPeriodesPecChevauchePeriode(individu.getChronologiePecFusionneesFinCI(), periode);
    chronologiePeriodesPEC.iterer();
    while (chronologiePeriodesPEC.encoreSuivant())
    {
      ObjetChronoPeriodePriseEnCharge objetChronoPeriodePriseEnCharge = (ObjetChronoPeriodePriseEnCharge)chronologiePeriodesPEC.elementSuivant();
      if (objetChronoPeriodePriseEnCharge.getDemandeurEmploi()) {
        retour.ajouter(objetChronoPeriodePriseEnCharge);
      }
    }
    if (!retour.estVide()) {
      retour.setComparateur(new ComparateurTemporelsSurDateDebut());
    }
    return retour;
  }
  
  public static boolean estUnePECPAP(ObjetChronoPeriodePriseEnCharge pec)
  {
    return ("PAP".equals(pec.getSituationEmploi())) && (pec.estUnePecCTP());
  }
  
  public static boolean estUnePECCSP(ObjetChronoPeriodePriseEnCharge pec)
  {
    return ("CSP".equals(pec.getSituationEmploi())) && ((estUnePecClassiqueCSP(pec)) || (estUnePecFormationCSP(pec)));
  }
  
  private static boolean estUnePecClassiqueCSP(ObjetChronoPeriodePriseEnCharge pec)
  {
    return ("1".equals(pec.getTypePec())) && ("6".equals(pec.getSousType()));
  }
  
  private static boolean estUnePecFormationCSP(ObjetChronoPeriodePriseEnCharge pec)
  {
    return ("2".equals(pec.getTypePec())) && ("6".equals(pec.getSousType()));
  }
}

/* Location:
 * Qualified Name:     OutillagePEC
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */