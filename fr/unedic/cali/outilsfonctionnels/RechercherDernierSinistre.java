package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeActiviteSalarie;
import fr.unedic.cali.autresdoms.ga.dom.spec.TravailSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.PeriodeActiviteSalarieCali;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreActiviteSalarieEtantFCT;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreActiviteSalarieSuspensionChomageSansRCT;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreCategorieEmploiParticulier;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreNegation;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltrePeriodeActiviteNonSalariee;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltrePeriodeActiviteSalarieeE301NonFrontalier;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltrePeriodeFctPrincipale;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltrePeriodesAttestees;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltrePeriodesDeclarees;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltrePeriodesLiquidables;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltrePeriodesQualifiables;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltrePeriodesSurFiltresExclusifs;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreTravailSalarie;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreTravailSpec;
import fr.unedic.cali.utilitaire.filtres.logiques.FiltreET;
import fr.unedic.cali.utilitaire.filtres.objetChronoPeriode.FiltreActiviteSalarieDecoupeePourContexteDecoupage;
import fr.unedic.cali.utilitaire.filtres.objetChronoPeriode.FiltreActiviteSalarieFct;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.OutilFonctionnel;
import fr.unedic.util.services.PasAssezInformationException;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.ComparateurTemporelsSurDateFin;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.FiltreFinActivite;
import fr.unedic.util.temps.FiltreFinAvantOuCoincideAvecDate;
import fr.unedic.util.temps.FiltreMemeDateFin;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.FiltresTemporel;
import fr.unedic.util.temps.Periode;
import fr.unedic.util.temps.Temporel;
import java.math.BigDecimal;

public class RechercherDernierSinistre
  implements OutilFonctionnel
{
  public static TravailSpec rechercherDernierSinistre(Damj date, Chronologie chronologie)
    throws PasAssezInformationException
  {
    TravailSpec dernierSinistre = null;
    if ((chronologie != null) && (!chronologie.estVide())) {
      dernierSinistre = rechercherDernierContratTravailRompu(date, chronologie);
    }
    return dernierSinistre;
  }
  
  public static TravailSpec rechercherDateDernierSinistre(Damj date, Chronologie chronologie)
    throws CoucheLogiqueException
  {
    TravailSpec dernierSinistre = null;
    if ((chronologie != null) && (!chronologie.estVide())) {
      dernierSinistre = rechercherDateDernierContratTravailRompu(date, chronologie);
    }
    return dernierSinistre;
  }
  
  public static TravailSpec rechercherDernierSinistrePourDecor(Damj date, Chronologie chronologie)
    throws CoucheLogiqueException
  {
    TravailSpec dernierSinistre = null;
    if ((chronologie != null) && (!chronologie.estVide()))
    {
      FiltresTemporel filtres = new FiltresTemporel();
      FiltreFinActivite filtreFin = new FiltreFinActivite();
      filtres.ajouterFiltre(filtreFin);
      
      filtres.ajouterFiltre(new FiltreActiviteSalarieEtantFCT());
      
      Chronologie chronoPeriodeActiviteSalarieFinies = chronologie.copier(filtres);
      
      Chronologie chronoSinistres = chronoPeriodeActiviteSalarieFinies.copier(new FiltreFinAvantOuCoincideAvecDate(date));
      
      chronoSinistres = chronoSinistres.copier(new FiltrePeriodeActiviteSalarieeE301NonFrontalier(false));
      if ((chronoSinistres != null) && (!chronoSinistres.estVide()))
      {
        chronoSinistres.setComparateur(new ComparateurTemporelsSurDateFin());
        dernierSinistre = (TravailSpec)chronoSinistres.premierElement();
      }
    }
    return dernierSinistre;
  }
  
  public static TravailSpec rechercherDernierContratTravailRompu(Damj date, Chronologie chronologie)
    throws PasAssezInformationException
  {
    Chronologie chronoSinistres = determinationChronoSinistres(date, chronologie);
    
    return recupererDernierSinistre(chronoSinistres);
  }
  
  public static TravailSpec rechercherDateDernierContratTravailRompu(Damj date, Chronologie chronologie)
    throws CoucheLogiqueException
  {
    Chronologie chronoSinistres = determinationChronoSinistres(date, chronologie);
    
    return recupererDernierSinistreDansChronoSinistres(chronoSinistres);
  }
  
  private static Chronologie determinationChronoSinistres(Damj date, Chronologie chronologie)
  {
    Chronologie chronoPeriodeActiviteSalarieFinies = getPeriodeActiviteSalarieFinies(chronologie);
    
    Chronologie chronoSinistres = chronoPeriodeActiviteSalarieFinies.copier(new FiltreFinAvantOuCoincideAvecDate(date));
    
    return chronoSinistres.copier(new FiltrePeriodeActiviteSalarieeE301NonFrontalier(false));
  }
  
  public static TravailSpec rechercherUneDesPeriodesConcommittantes(Damj date, Chronologie chronologie)
    throws CoucheLogiqueException
  {
    TravailSpec sinistreRetenu = null;
    
    Chronologie chronoPeriodeActiviteSalarieFinies = getPeriodeActiviteSalarieFinies(chronologie);
    
    Chronologie chronoSinistres = chronoPeriodeActiviteSalarieFinies.copier(new FiltreFinAvantOuCoincideAvecDate(date));
    
    chronoSinistres = chronoSinistres.copier(new FiltrePeriodeActiviteSalarieeE301NonFrontalier(false));
    
    chronoSinistres.setComparateur(new ComparateurTemporelsSurDateFin());
    if (chronoSinistres.getTaille() > 0) {
      sinistreRetenu = (TravailSpec)chronoSinistres.premierElement();
    }
    return sinistreRetenu;
  }
  
  private static Chronologie getPeriodeActiviteSalarieFinies(Chronologie chronologieOriginale)
  {
    FiltresTemporel filtres = new FiltresTemporel();
    FiltrePeriodesLiquidables filtrePas = new FiltrePeriodesLiquidables();
    
    FiltrePeriodeActiviteNonSalariee filtreNonPans = new FiltrePeriodeActiviteNonSalariee(false);
    FiltreFinActivite filtreFin = new FiltreFinActivite();
    filtres.ajouterFiltre(filtrePas);
    filtres.ajouterFiltre(filtreFin);
    filtres.ajouterFiltre(filtreNonPans);
    
    return chronologieOriginale.copier(filtres);
  }
  
  private static TravailSpec recupererDernierSinistre(Chronologie chronoSinistres)
    throws PasAssezInformationException
  {
    TravailSpec sinistreRetenu = recupererDernierSinistreDansChronoSinistres(chronoSinistres);
    if (sinistreRetenu != null)
    {
      FiltresTemporel filtreFCT = new FiltresTemporel();
      
      FiltrePeriodeActiviteNonSalariee filtreNonPans = new FiltrePeriodeActiviteNonSalariee(false);
      filtreFCT.ajouterFiltre(new FiltreMemeDateFin(sinistreRetenu.getDateFin()));
      filtreFCT.ajouterFiltre(filtreNonPans);
      Chronologie chronoFctMemeDateFin = chronoSinistres.copier(filtreFCT);
      if ((chronoFctMemeDateFin != null) && (chronoFctMemeDateFin.getTaille() > 1))
      {
        chronoFctMemeDateFin.setComparateur(new ComparateurSurPrioriteStatutPeriode());
        
        FiltresTemporel filtre = new FiltresTemporel();
        filtre.ajouterFiltre(new FiltrePeriodeFctPrincipale(sinistreRetenu.getDateFin()));
        
        Chronologie chronoFctPrincipale = chronoFctMemeDateFin.copier(filtre);
        if ((chronoFctPrincipale != null) && (chronoFctPrincipale.getTaille() == 1)) {
          sinistreRetenu = (ActiviteSalarie)chronoFctPrincipale.premierElement();
        } else {
          sinistreRetenu = trouverDernierSinistreAvecReglePrioriteFctConcomitantes(chronoFctMemeDateFin);
        }
      }
    }
    return sinistreRetenu;
  }
  
  public static TravailSpec recupererDernierSinistreDansChronoSinistres(Chronologie chronoSinistres)
  {
    TravailSpec sinistreRetenu = null;
    if ((chronoSinistres != null) && (!chronoSinistres.estVide()))
    {
      chronoSinistres.setComparateur(new ComparateurTemporelsSurDateFin());
      sinistreRetenu = (TravailSpec)chronoSinistres.premierElement();
    }
    return sinistreRetenu;
  }
  
  private static TravailSpec trouverDernierSinistreAvecReglePrioriteFctConcomitantes(Chronologie chronoFctMemeDateFin)
    throws PasAssezInformationException
  {
    chronoFctMemeDateFin.iterer();
    FiltrePeriodesAttestees filtrePeriodesAttestees = new FiltrePeriodesAttestees();
    Chronologie attestees = chronoFctMemeDateFin.copier(filtrePeriodesAttestees);
    TravailSpec sinistreRetenu;
    TravailSpec sinistreRetenu;
    if (attestees.getTaille() >= 2)
    {
      sinistreRetenu = determinerOrdreVerificationSinistres(attestees);
    }
    else
    {
      TravailSpec sinistreRetenu;
      if (attestees.getTaille() == 1)
      {
        sinistreRetenu = (TravailSpec)attestees.premierElement();
      }
      else
      {
        FiltresTemporel filtrePeriodeNonAttesteesQualifiees = new FiltresTemporel();
        FiltrePeriodesQualifiables filtrePeriodesQualifiables = new FiltrePeriodesQualifiables();
        FiltreTemporel periodeNonAttestees = new FiltrePeriodesAttestees(false);
        filtrePeriodeNonAttesteesQualifiees.ajouterFiltre(filtrePeriodesQualifiables);
        filtrePeriodeNonAttesteesQualifiees.ajouterFiltre(periodeNonAttestees);
        Chronologie nonAttesteesQualifiees = chronoFctMemeDateFin.copier(filtrePeriodeNonAttesteesQualifiees);
        TravailSpec sinistreRetenu;
        if (nonAttesteesQualifiees.getTaille() != 0) {
          sinistreRetenu = (TravailSpec)nonAttesteesQualifiees.premierElement();
        } else {
          sinistreRetenu = (TravailSpec)chronoFctMemeDateFin.premierElement();
        }
      }
    }
    return sinistreRetenu;
  }
  
  private static TravailSpec determinerOrdreVerificationSinistres(Chronologie chronoFctMemeDateFin)
    throws PasAssezInformationException
  {
    FiltreCategorieEmploiParticulier filtresSpectacle = new FiltreCategorieEmploiParticulier();
    filtresSpectacle.ajouterCategorieEmploi(21);
    filtresSpectacle.ajouterCategorieEmploi(39);
    filtresSpectacle.ajouterCategorieEmploi(44);
    filtresSpectacle.ajouterCategorieEmploi(43);
    
    Chronologie chronoSpectacle = chronoFctMemeDateFin.copier(filtresSpectacle);
    if ((chronoSpectacle == null) || (chronoSpectacle.getTaille() == 0)) {
      bloquerPourFCTConcommitantes(chronoFctMemeDateFin);
    }
    if ((chronoSpectacle != null) && (chronoSpectacle.getTaille() == 1)) {
      return (TravailSpec)chronoSpectacle.premierElement();
    }
    Chronologie chronoSpectacleA10A8 = traiteSinistreA10(chronoSpectacle);
    if ((chronoSpectacleA10A8 == null) || (chronoSpectacleA10A8.getTaille() == 0)) {
      chronoSpectacleA10A8 = traiteSinistreA8(chronoSpectacle);
    }
    if ((chronoSpectacleA10A8 == null) || (chronoSpectacleA10A8.getTaille() == 0)) {
      bloquerPourFCTConcommitantes(chronoFctMemeDateFin);
    }
    if ((chronoSpectacleA10A8 != null) && (chronoSpectacleA10A8.getTaille() == 1)) {
      return (TravailSpec)chronoSpectacleA10A8.premierElement();
    }
    TravailSpec sinistreRetenu = rechercheDernierSinistreLePlusLong(chronoSpectacleA10A8);
    if (sinistreRetenu != null) {
      return sinistreRetenu;
    }
    sinistreRetenu = rechercheDernierSinistreOrdreTechnique(chronoSpectacleA10A8);
    
    return sinistreRetenu;
  }
  
  private static void bloquerPourFCTConcommitantes(Chronologie chronoFctMemeDateFin)
    throws PasAssezInformationException
  {
    PeriodeActiviteSalarie pas = null;
    if (chronoFctMemeDateFin.premierElement().estType(ActiviteSalarie.class)) {
      pas = ((ActiviteSalarie)chronoFctMemeDateFin.premierElement()).getPeriodeActiviteSalarieGaec();
    } else if (chronoFctMemeDateFin.premierElement().estType(PeriodeActiviteSalarie.class)) {
      pas = (PeriodeActiviteSalarie)chronoFctMemeDateFin.premierElement();
    }
    try
    {
      GestionnaireErreur.getInstance().genererException("HG_PR_CALI_L_CTX_ABS_FCT_PRINCIPALE_AVEC_DATE", new Object[] { pas != null ? pas.getDateFin() : null }, 2);
    }
    catch (CoucheLogiqueException ex)
    {
      throw new PasAssezInformationException(ex.getCode(), ex.getLibelle(), ex);
    }
  }
  
  private static Chronologie traiteSinistreA10(Chronologie chronoSpectacle)
  {
    FiltreCategorieEmploiParticulier filtresSpectacleA10 = new FiltreCategorieEmploiParticulier();
    filtresSpectacleA10.ajouterCategorieEmploi(21);
    
    return chronoSpectacle.copier(filtresSpectacleA10);
  }
  
  private static Chronologie traiteSinistreA8(Chronologie chronoSpectacle)
  {
    FiltreCategorieEmploiParticulier filtresSpectacleA8 = new FiltreCategorieEmploiParticulier();
    filtresSpectacleA8.ajouterCategorieEmploi(39);
    filtresSpectacleA8.ajouterCategorieEmploi(44);
    filtresSpectacleA8.ajouterCategorieEmploi(43);
    
    return chronoSpectacle.copier(filtresSpectacleA8);
  }
  
  private static TravailSpec rechercheDernierSinistreLePlusLong(Chronologie chronoSpectacle)
  {
    TravailSpec sinistreRetenu = null;
    int duree = 0;
    chronoSpectacle.iterer();
    while (chronoSpectacle.encoreSuivant())
    {
      TravailSpec travail = (TravailSpec)chronoSpectacle.elementSuivant();
      if (travail.getPeriode().getDuree() > duree)
      {
        duree = travail.getPeriode().getDuree();
        sinistreRetenu = travail;
      }
      else if (travail.getPeriode().getDuree() == duree)
      {
        sinistreRetenu = null;
      }
    }
    return sinistreRetenu;
  }
  
  private static TravailSpec rechercheDernierSinistreOrdreTechnique(Chronologie chronoSpectacle)
  {
    TravailSpec sinistreRetenu = null;
    BigDecimal identifiantARetenir = BigDecimal.valueOf(0L);
    chronoSpectacle.iterer();
    while (chronoSpectacle.encoreSuivant())
    {
      ActiviteSalarie travail = (ActiviteSalarie)chronoSpectacle.elementSuivant();
      BigDecimal identifiant = new BigDecimal(travail.getPeriodeActiviteSalarieCali().getIdentifiant());
      if (identifiant.compareTo(identifiantARetenir) > 0)
      {
        identifiantARetenir = identifiant;
        sinistreRetenu = travail;
      }
    }
    return sinistreRetenu;
  }
  
  public static Chronologie determinerChronologieActivitesRechercheDernierSinistre(DemandeSpec demande)
  {
    FiltrePeriodesSurFiltresExclusifs listeFiltresOu = filtresPourRechercheDernierSinistre();
    
    Chronologie chronoPeriodesParticipantesAffectation = demande.getDemandeur().getChronoPeriodePasseProfessionnelLiquidation().copier(listeFiltresOu);
    
    return chronoPeriodesParticipantesAffectation.copier(new FiltreFinAvantOuCoincideAvecDate(demande.getDateRecherche().veille()));
  }
  
  public static Chronologie determinerChronologieActivitesRechercheDernierSinistre(IndividuSpec individu)
  {
    FiltrePeriodesSurFiltresExclusifs listeFiltresOu = filtresPourRechercheDernierSinistre();
    return individu.getChronoPeriodePasseProfessionnelLiquidation().copier(listeFiltresOu);
  }
  
  public static FiltrePeriodesSurFiltresExclusifs filtresPourRechercheDernierSinistre()
  {
    FiltrePeriodesSurFiltresExclusifs listeFiltresOu = new FiltrePeriodesSurFiltresExclusifs();
    
    FiltresTemporel filtrePeriodesSuspensionNonFct = new FiltresTemporel();
    filtrePeriodesSuspensionNonFct.ajouterFiltre(new FiltreActiviteSalarieSuspensionChomageSansRCT());
    filtrePeriodesSuspensionNonFct.ajouterFiltre(new FiltreNegation(new FiltreActiviteSalarieEtantFCT()));
    FiltreTemporel filtreExclusionPeriodesSuspensionNonFct = new FiltreNegation(filtrePeriodesSuspensionNonFct);
    
    FiltresTemporel filtresDeclareTravail = new FiltresTemporel();
    filtresDeclareTravail.ajouterFiltre(new FiltrePeriodesDeclarees());
    filtresDeclareTravail.ajouterFiltre(new FiltreTravailSpec());
    filtresDeclareTravail.ajouterFiltre(filtreExclusionPeriodesSuspensionNonFct);
    
    listeFiltresOu.ajouterFiltre(filtresDeclareTravail);
    
    FiltresTemporel filtresSalarieLiquidable = new FiltresTemporel();
    filtresSalarieLiquidable.ajouterFiltre(new FiltreTravailSalarie());
    filtresSalarieLiquidable.ajouterFiltre(new FiltrePeriodesLiquidables());
    filtresSalarieLiquidable.ajouterFiltre(filtreExclusionPeriodesSuspensionNonFct);
    
    FiltrePeriodesSurFiltresExclusifs filtreDecoupage = new FiltrePeriodesSurFiltresExclusifs();
    filtreDecoupage.ajouterFiltre(new FiltreNegation(new FiltreActiviteSalarieDecoupeePourContexteDecoupage("METIER")));
    
    FiltreET filtreEt = new FiltreET();
    filtreEt.ajouterFiltre(new FiltreActiviteSalarieDecoupeePourContexteDecoupage("METIER"));
    filtreEt.ajouterFiltre(new FiltreActiviteSalarieFct());
    filtreDecoupage.ajouterFiltre(filtreEt);
    
    filtresSalarieLiquidable.ajouterFiltre(filtreDecoupage);
    
    listeFiltresOu.ajouterFiltre(filtresSalarieLiquidable);
    
    return listeFiltresOu;
  }
}

/* Location:
 * Qualified Name:     RechercherDernierSinistre
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */