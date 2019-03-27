package fr.unedic.cali.migration.outilsfonctionnels;

import fr.unedic.cali.autresdoms.cohab.parcours.DomMigration;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculPeriodique;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculSpec;
import fr.unedic.cali.calcul.dom.UniteTraitement;
import fr.unedic.cali.calcul.outilsfonctionnels.GestionSuivi;
import fr.unedic.cali.calcul.pbjc.dom.IndividuPbjcNcp;
import fr.unedic.cali.calcul.pbjc.dom.PbjcNcp;
import fr.unedic.cali.calcul.pbjc.dom.PrimePbjcNcp;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.cali.migration.OutilsMigrationLiquidation;
import fr.unedic.cali.outilsfonctionnels.GestionnaireErreur;
import fr.unedic.cali.parcours.ResultatMigrationCalculProduit;
import fr.unedic.cali.parcours.ResultatPilotage;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import fr.unedic.util.temps.Temporel;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class OutilsMigrationCalcul
{
  public static final String LIBELLE_TOP_COMPARAISON_DEPASSEMENT_CUMUL_ASS = "S";
  public static final String LIBELLE_TOP_COMPARAISON_DONNEES_HORS_CUMULS = "P";
  public static final String LIBELLE_TOP_PAS_DE_COMPARAISON = "N";
  public static final String LIBELLE_TOP_COMPARAISON_CUMUL_MOIS_SEULEMENT = "M";
  public static final String LIBELLE_TOP_COMPARAISON_CUMUL_HEURES_SEULEMENT = "H";
  public static final String LIBELLE_TOP_COMPARAISON_CALENDRIER_SIGMA_VIDE = "V";
  public static final String LIBELLE_TOP_COMPARAISON_RELIQUAT = "R";
  public static final Damj DATE_BASCULE_DISPOSITIF_2006 = new Damj("2006, 10, 1");
  public static final int VALEUR_DEPASSEMENT_CUMUL_MOIS_AR_ASS = 12;
  public static final int VALEUR_DEPASSEMENT_CUMUL_HEURE_AR_ASS = 750;
  
  public static void nettoyageTablesEchangesCalcul(List p_listeAttributionsExec, IndividuSpec p_individu)
    throws CoucheLogiqueException
  {
    nettoyagePBJC(p_individu);
    
    GestionSuivi.nettoyerIndividuPbjcNcp(p_individu, Damj.NUIT_DES_TEMPS);
    if (contientUnePrime(p_listeAttributionsExec))
    {
      nettoyagePrimes(p_individu);
      controlerPresencePrimeHorsIndemnisation(p_listeAttributionsExec, p_individu);
    }
  }
  
  public static boolean contientUnePrime(List p_attributions)
  {
    boolean presencePrimes = false;
    
    Iterator iter = p_attributions.iterator();
    while (iter.hasNext())
    {
      AttributionSpec attribution = (AttributionSpec)iter.next();
      if (OutilsMigrationLiquidation.estUneAttributionPFM(attribution)) {
        presencePrimes = true;
      }
    }
    return presencePrimes;
  }
  
  private static void nettoyagePBJC(IndividuSpec p_individu)
    throws CoucheLogiqueException
  {
    ChronologiePeriodes chronoPBJCs = p_individu.getChronoPbjcs();
    
    ListIterator iter = chronoPBJCs.iterer();
    while (iter.hasNext())
    {
      PbjcNcp pbjc = (PbjcNcp)iter.next();
      DomManager.supprimer(pbjc);
      iter.remove();
    }
  }
  
  private static void nettoyagePrimes(IndividuSpec p_individu)
    throws CoucheLogiqueException
  {
    Collection primes = p_individu.getCollectionPrimes();
    if ((primes != null) && (!primes.isEmpty()))
    {
      Iterator iterPrimeASupprimer = primes.iterator();
      while (iterPrimeASupprimer.hasNext())
      {
        PrimePbjcNcp primeNcp = (PrimePbjcNcp)iterPrimeASupprimer.next();
        DomManager.supprimer(primeNcp);
        iterPrimeASupprimer.remove();
      }
    }
  }
  
  public static void initialiseIndividuPbjc(boolean p_resultat, IndividuSpec p_individu)
  {
    if (p_resultat) {
      creerIndividuPbjc(p_individu);
    } else {
      supprimerIndividuPbjc(p_individu);
    }
  }
  
  private static void creerIndividuPbjc(IndividuSpec p_individu)
  {
    IndividuPbjcNcp individuPbjcNcpPersistant = p_individu.getIndividuPbjcNcp();
    if (individuPbjcNcpPersistant == null) {
      p_individu.setIndividuPbjcNcp(individuPbjcNcpPersistant);
    }
  }
  
  private static void supprimerIndividuPbjc(IndividuSpec p_individu)
  {
    IndividuPbjcNcp individuPbjcNcp = p_individu.getIndividuPbjcNcp();
    if (individuPbjcNcp != null) {
      DomManager.supprimerAbsolument(individuPbjcNcp);
    }
  }
  
  private static void controlerCoherenceUniteTraitementFigee(UniteTraitement p_uniteTraitement, IndividuSpec p_individuMigre)
    throws CoucheLogiqueException
  {
    if (!p_uniteTraitement.getDateFin().coincideAvec(p_individuMigre.getDernierJourAtteste())) {
      GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_L_CALCUL_DJA_INCOHERENT_UT_FIGEE");
    }
  }
  
  public static UniteTraitement sauvegardeDerniereUTDroitEnCours(DomMigration p_migration, IndividuSpec p_individu)
  {
    UniteTraitement uniteTraitement = null;
    
    AttributionSpec attribution = OutilsMigration.getAttributionEnCoursDIndemnisation(p_migration, p_individu);
    if (attribution != null)
    {
      CalendrierExecutionCalculPeriodique calendrier = (CalendrierExecutionCalculPeriodique)attribution.getCalendrierExecutionCalcul();
      if ((calendrier != null) && (!calendrier.getChronologieUnitesTraitements().estVide())) {
        uniteTraitement = (UniteTraitement)calendrier.getChronologieUnitesTraitements().dernierElement().copie();
      }
    }
    return uniteTraitement;
  }
  
  public static Resultat sauvegardeResultatCalculAvantAppelFinalise(Resultat p_resultat)
  {
    ResultatPilotage resultat = (ResultatPilotage)p_resultat;
    
    ResultatPilotage copieResultatPilotage = new ResultatPilotage();
    
    List listeResutat = resultat.getResultatsDetailles();
    if ((listeResutat != null) && (!listeResutat.isEmpty()))
    {
      Iterator iter = resultat.getResultatsDetailles().iterator();
      while (iter.hasNext())
      {
        ResultatMigrationCalculProduit resultatProduit = (ResultatMigrationCalculProduit)iter.next();
        
        copieResultatPilotage.ajouteResultatDetaille((ResultatMigrationCalculProduit)resultatProduit.copie());
      }
    }
    return copieResultatPilotage;
  }
  
  public static void corrigerCalendrierDroitEnCours(DomMigration p_migration, IndividuSpec p_individuMigre)
  {
    AttributionSpec attribution = OutilsMigration.getAttributionEnCoursDIndemnisation(p_migration, p_individuMigre);
    
    attribution.getCalendrierExecutionCalcul().setEtatAttribution(2);
    
    attribution.getCalendrierExecutionCalcul().setDernierJourIndemnisable(Damj.FIN_DES_TEMPS);
  }
  
  public static void verificationEtCorrectionCalendrierAss(IndividuSpec p_individuMigre)
    throws CoucheLogiqueException
  {
    boolean existeAnomalie = verifierCoherenceExecutionCalendrier(p_individuMigre);
    if (existeAnomalie)
    {
      correctionDjiCalendrierASS(p_individuMigre);
      existeAnomalie = verifierCoherenceExecutionCalendrier(p_individuMigre);
      if (existeAnomalie) {
        GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_CALCUL_ECHEC_ANO_CAL_ASS_INCOHERENT");
      }
    }
  }
  
  private static boolean verifierCoherenceExecutionCalendrier(IndividuSpec p_individuMigre)
  {
    boolean existeAnomalie = false;
    existeAnomalie = false;
    
    AttributionSpec derniereAttributionFigee = OutilsMigration.getDerniereAttributionFigee(p_individuMigre);
    if ((derniereAttributionFigee != null) && 
      (OutilsMigrationLiquidation.estUneAttributionAssCGE(derniereAttributionFigee))) {
      if ((!derniereAttributionFigee.estMigreeEnSimplifiee()) && 
        (derniereAttributionFigee.getCalendrierExecutionCalcul() != null))
      {
        Damj dji = derniereAttributionFigee.getCalendrierExecutionCalcul().getDernierJourIndemnisable();
        if (dji.estApres(p_individuMigre.getDdorkb())) {
          existeAnomalie = true;
        }
      }
    }
    return existeAnomalie;
  }
  
  private static void correctionDjiCalendrierASS(IndividuSpec p_individuMigre)
  {
    AttributionSpec derniereAttributionFigee = OutilsMigration.getDerniereAttributionFigee(p_individuMigre);
    CalendrierExecutionCalculSpec calendrier = derniereAttributionFigee.getCalendrierExecutionCalcul();
    
    calendrier.setDernierJourIndemnisable(p_individuMigre.getDdorkb().veille());
    
    calendrier.setEtatAttribution(3);
  }
  
  private static void controlerPresencePrimeHorsIndemnisation(List p_listeAttributionsExec, IndividuSpec p_individu)
    throws CoucheLogiqueException
  {
    Collection primes = p_individu.getCollectionPrimes();
    Iterator iteratorPrimes = primes.iterator();
    boolean primeTrouve = false;
    while (iteratorPrimes.hasNext())
    {
      PrimePbjcNcp prime = (PrimePbjcNcp)iteratorPrimes.next();
      Periode periode = new Periode(prime.getDateEffet().getDebutMois(), prime.getDateEffet().getFinMois());
      primeTrouve = false;
      
      Iterator iter = p_listeAttributionsExec.iterator();
      while (iter.hasNext())
      {
        AttributionSpec attribution = (AttributionSpec)iter.next();
        CalendrierExecutionCalculSpec calendrier = attribution.getCalendrierExecutionCalcul();
        Periode periodeCalendrier = new Periode(calendrier.getPremierJourIndemnisable(), calendrier.getDernierJourIndemnisable());
        if ((!OutilsMigrationLiquidation.estUneAttributionPFM(attribution)) && 
          (periode.chevauche(periodeCalendrier))) {
          primeTrouve = true;
        }
      }
      if (!primeTrouve) {
        GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_L_CALCUL_PRESENCE_PFM_HORS_INDEMN");
      }
    }
  }
}

/* Location:
 * Qualified Name:     OutilsMigrationCalcul
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */