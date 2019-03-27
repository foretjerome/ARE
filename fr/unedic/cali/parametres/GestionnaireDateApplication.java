package fr.unedic.cali.parametres;

import fr.pe.cali.parametres.dateapplication.persistance.OutilChargementDateApplication;
import fr.unedic.cali.outilsfonctionnels.GestionnaireErreur;
import fr.unedic.cali.outilsfonctionnels.strategies.ContexteExecutionJunit;
import fr.unedic.cali.outilsfonctionnels.strategies.ContexteExecutionVnr;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class GestionnaireDateApplication
{
  private static GestionnaireDateApplication instance = null;
  private static final String PREFIXE_LIBELLE = "LIB_";
  private static final String PREFIXE_DATE = "DATE_";
  private static Map<String, Damj> referentielDateApplication = null;
  private static Map<String, Damj> referentielDateApplicationBaseDonnees = null;
  private static final int TAILLE_LIB_MAX = 100;
  public static final String LIB_ARRET_ATA_ASILE = "Date d'application de l'arret ATA ASILE";
  private static final Damj DATE_ARRET_ATA_ASILE = new Damj(2015, 11, 1);
  public static final String LIB_STRATEGIE_A8A10_CONFRONTATION_GAIN_HEURE = "Date d'application du SM9 IN0965163";
  private static final Damj DATE_STRATEGIE_A8A10_CONFRONTATION_GAIN_HEURE = new Damj(2016, 3, 1);
  public static final String LIB_VALIDATION_AE_WEB = "Date d'application du SM9 IN0989986";
  private static final Damj DATE_VALIDATION_AE_WEB = new Damj(2016, 9, 1);
  public static final String LIB_ABATTEMENT_SUR_AE_SPECTACLE = "Date application prise en compte abattement";
  private static final Damj DATE_ABATTEMENT_SUR_AE_SPECTACLE = new Damj(2017, 7, 1);
  public static final String LIB_DATE_APPLICATION_DROIT_OPTION_ELARGI = "Application du droit d'option élargi.";
  private static final Damj DATE_DATE_APPLICATION_DROIT_OPTION_ELARGI = new Damj(2014, 10, 1);
  public static final String LIB_DATE_APPLICATION_REPRISE_SP = "Reprise SP";
  private static final Damj DATE_DATE_APPLICATION_REPRISE_SP = new Damj(2016, 4, 1);
  public static final String LIB_DATE_APPLICATION_REPRISE_SP_VEILLE = "Veille Reprise SP";
  private static final Damj DATE_DATE_APPLICATION_REPRISE_SP_VEILLE = new Damj(2016, 3, 31);
  public static final String LIB_DATE_APPLICATION_BLOCAGE_DROIT_SP_SPECTACLE = "Blocage antecedent SP pour spectacle.";
  private static final Damj DATE_DATE_APPLICATION_BLOCAGE_DROIT_SP_SPECTACLE = new Damj(2014, 10, 1);
  public static final String LIB_DATE_APPLICATION_DRV_NOUVEAU_DISPOSITIF = "Application du nouveau dispositif sur les DRV";
  private static final Damj DATE_DATE_APPLICATION_DRV_NOUVEAU_DISPOSITIF = new Damj(2015, 7, 8);
  public static final String LIB_DATE_APPLICATION_FIN_DRV_ANCIEN_DISPOSITIF = "Fin application de l'ancien dispositif DRV";
  private static final Damj DATE_DATE_APPLICATION_FIN_DRV_ANCIEN_DISPOSITIF = new Damj(2015, 7, 1);
  public static final String LIB_NUIT_DES_TEMPS = "Date de la nuit des temps";
  private static final Damj DATE_NUIT_DES_TEMPS = Damj.NUIT_DES_TEMPS;
  public static final String LIB_FIN_DES_TEMPS = "Date de la fin des temps";
  private static final Damj DATE_FIN_DES_TEMPS = Damj.FIN_DES_TEMPS;
  private static final Damj DATE_NOUVELLE_CONVENTION_CSP_2014_VEILLE = new Damj(2014, 9, 30);
  private static final Damj DATE_DATE_APPLICATION_DETERMINATION_POPULATION_PAR_PRODUIT = new Damj(2017, 1, 1);
  public static final String LIB_DATE_APPLICATION_DETERMINATION_POPULATION_PAR_PRODUIT = "Determination de la population par le produit indemnise";
  private static final Damj DATE_PRODUCTION_COURRIER_KC2N = new Damj(2017, 3, 1);
  public static final String LIB_PRODUCTION_COURRIER_KC2N = "Date d'application pour le courrier KC2N";
  public static final String LIB_PRISE_EN_COMPTE_CARENCES_SUR_ACTIVITE_CONSERVEE = "Prise en compte des montants ICCP et ISLR sur les activités conservées";
  private static final Damj DATE_PRISE_EN_COMPTE_CARENCES_SUR_ACTIVITE_CONSERVEE = new Damj(2015, 7, 1);
  public static final String LIB_FIN_SANCTION_PNDS = "Date Fin sanction PNDS";
  public static final Damj DATE_FIN_SANCTION_PNDS = new Damj(2015, 10, 22);
  public static final String LIB_DEBUT_5911B_A8_LISTE22 = "Prise en compte des entreprises 5911B pour les A8 liste 22";
  private static final Damj DATE_DEBUT_5911B_A8_LISTE22 = new Damj(2015, 4, 1);
  public static final String LIB_CONNAISSANCE_5911B_A8_LISTE22 = "Prise en compte des entreprises 5911B pour les A8 liste 22 2";
  private static final Damj DATE_CONNAISSANCE_5911B_A8_LISTE22 = new Damj(2015, 12, 14);
  public static final String LIB_MAJ_PRIORISATION_ICCP = "Modification des règles ICCP en 15SI4";
  private static final Damj DATE_MAJ_PRIORISATION_ICCP = new Damj(2016, 1, 1);
  public static final String LIB_DV_FIL_EAU = "Prise en compte des DV pour le DV au fil de l'eau.";
  private static final Damj DATE_DV_FIL_EAU = new Damj(2015, 7, 8);
  public static final String LIB_PRA_OPPOSITION_A4 = "Prise en compte des heures pour la pra d'opposition en A4";
  private static final Damj DATE_PRA_OPPOSITION_A4 = new Damj(2015, 12, 14);
  public static final String LIB_OPPOSITION_DV_ASSIMILATION = "Non prise en compte de l'assimilation pour l'innoposabilité";
  private static final Damj DATE_OPPOSITION_DV_ASSIMILATION = new Damj(2015, 12, 14);
  public static final String LIB_CERTIFICATION_SPECTACLE_DEBUT_CONTRAT = "Prise en compte de la certification sociale des entreprise du spectacle : date début contrat";
  private static final Damj DATE_CERTIFICATION_SPECTACLE_DEBUT_CONTRAT = new Damj(2015, 10, 1);
  public static final String LIB_CERTIFICATION_SPECTACLE_CONNAISSANCE_INFO = "Prise en compte de la certification sociale des entreprise du spectacle : date connaissance info";
  private static final Damj DATE_CERTIFICATION_SPECTACLE_CONNAISSANCE_INFO = new Damj(2016, 3, 21);
  public static final String LIB_PASSS_MEP16SI1 = "Prise en compte des PASSS";
  private static final Damj DATE_PASSS_MEP16SI1 = new Damj(2016, 3, 21);
  public static final String LIB_MISE_EN_PLACE_AR_MAYOTTE = "Re branchement activite reprise a Mayotte";
  private static final Damj DATE_MISE_EN_PLACE_AR_MAYOTTE = new Damj(2016, 3, 1);
  private static final Damj DATE_DETECTION_DEMANDE_ASS_MEP_16SI2 = new Damj(2016, 6, 20);
  public static final String LIB_DETECTION_DEMANDE_ASS_MEP_16SI2 = "Detection nouvelle demande ASS";
  public static final String LIB_APPLICATION_DROIT_PP_ARE_CG = "Application du droit aux paiements provisoires pour ARE CG";
  private static final Damj DATE_APPLICATION_DROIT_PP_ARE_CG = new Damj(2016, 6, 1);
  private static final Damj DATE_APPLICATION_AREM_2016 = new Damj(2016, 5, 1);
  public static final String LIB_APPLICATION_AREM_2016 = "Application des règles métropole pour Mayotte";
  private static final Damj DATE_APPLICATION_REPRISE_REVISION_CLCA = new Damj(2016, 7, 1);
  public static final String LIB_APPLICATION_REPRISE_REVISION_CLCA = "Lever la condition CLCA";
  public static final String LIB_NOUVELLE_CONVENTION_ARE_2014 = "Date d'application de la nouvelle convention ARE 2014";
  private static final Damj DATE_NOUVELLE_CONVENTION_ARE_2014 = new Damj(2014, 10, 1);
  public static final String LIB_APPLICATION_INFO_BAISSE_ALLOCATION_CSP = "Application de la notification lors de la baisse du montant ASP";
  private static final Damj DATE_APPLICATION_INFO_BAISSE_ALLOCATION_CSP = new Damj(2016, 6, 1);
  public static final String LIB_MEP_16SI4 = "Date de la MEP 16SI4";
  private static final Damj DATE_MEP_16SI4 = new Damj(2016, 12, 10);
  public static final String LIB_RECHERCHE_DV_CAPA09 = "Correction point depart recherche DV INC0129309";
  private static final Damj DATE_RECHERCHE_DV_CAPA09 = new Damj(2016, 12, 1);
  public static final String LIB_BLOCAGE_AE_BROUILLON = "Blocage en presence AE brouillon IN0973035";
  private static final Damj DATE_BLOCAGE_AE_BROUILLON = new Damj(2017, 1, 1);
  public static final String LIB_APPLICATION_SEGMENTANT = "Application des segmentant à tort";
  private static final Damj DATE_APPLICATION_SEGMENTANT = new Damj(2017, 1, 1);
  public static final String LIB_REACTIVATION_PNDS_17SI1 = "Réactivation de la détermination des PNDS";
  private static final Damj DATE_REACTIVATION_PNDS_17SI1 = new Damj(2017, 4, 1);
  public static final String LIB_PRISE_EN_COMPTE_PND_SUITE_REACTIVATION = "Date de prise en compte d'une PND suite à la réactivation des PNDS";
  private static final Damj DATE_PRISE_EN_COMPTE_PND_SUITE_REACTIVATION = new Damj(2016, 9, 1);
  public static final String LIB_LISTE_SPECTACLE_17SI1 = "Modification des listes Spectacles en 17SI1";
  private static final Damj DATE_LISTE_SPECTACLE_17SI1 = new Damj(2017, 3, 18);
  public static final String LIB_ACTIVATION_PNDS_SPECTACLE_17SI2 = "Activation des nouvelles sanctions pour les PND Spectacle en 17SI2";
  private static final Damj DATE_ACTIVATION_PNDS_SPECTACLE_17SI2 = new Damj(2017, 7, 1);
  public static final String LIB_ACTIVATION_NON_PRISE_EN_COMPTE_ASSIMILATION_CSA = "Activation de la non prise en compte de l'assimilation pour la ligne CSA";
  private static final Damj DATE_ACTIVATION_NON_PRISE_EN_COMPTE_ASSIMILATION_CSA = new Damj(2017, 7, 1);
  public static final String LIB_DETERMINATION_STATUT_UT_RG = "Determination du statut UT en RG";
  private static final Damj DATE_DETERMINATION_STATUT_UT_RG = new Damj(2017, 10, 1);
  public static final String LIB_PRISE_EN_COMPTE_ANS_SUPRA_MENSUEL = "Prise en compte des ANS mensuel et supra M";
  private static final Damj DATE_PRISE_EN_COMPTE_ANS_SUPRA_MENSUEL = new Damj(2018, 1, 1);
  public static final String LIB_PERIODES_SUSPENSIVES_DISPONIBILITE = "Périodes suspensives en cours";
  private static final Damj DATE_PERIODES_SUSPENSIVES_DISPONIBILITE = new Damj(2018, 1, 1);
  public static final String LIB_ARRET_PAP_CLASSIQUE = "Arret du PAP";
  private static final Damj DATE_ARRET_PAP_CLASSIQUE = new Damj(2017, 9, 17);
  public static final String LIB_DEBUT_PAP_PARLEMENTAIRE = "Debut du PAP Parlementaire";
  private static final Damj DATE_DEBUT_PAP_PARLEMENTAIRE = new Damj(2017, 9, 17);
  public static final String LIB_LIQ_AUTO_REVISION = "Révision liquidées automatiquement";
  private static final Damj DATE_LIQ_AUTO_REVISION = new Damj(2018, 1, 1);
  public static final String LIB_ORDONNANCEMENT_EXAMENS = "Ordonnancement examen";
  private static final Damj DATE_ORDONNANCEMENT_EXAMENS = new Damj(2018, 1, 1);
  public static final String LIB_INDEMNITE_LICENCIEMENT = "Indemnite de licenciement";
  private static final Damj DATE_INDEMNITE_LICENCIEMENT = new Damj(2017, 9, 27);
  public static final String LIB_PENSION_INVALIDITE_MONTANT_NULL = "PI à 0 suite INC0399669";
  private static final Damj DATE_PENSION_INVALIDITE_MONTANT_NULL = new Damj(2018, 3, 1);
  public static final String LIB_CHEVAUCHEMENT_DATE_ANNIVERSAIRE = "Regle de chevauchement date anniversaire";
  private static final Damj DATE_CHEVAUCHEMENT_DATE_ANNIVERSAIRE = new Damj(2018, 1, 26);
  private static final Damj DATE_APPLICATION_ASS_SUITE_DECHEANCE = new Damj(2011, 9, 2);
  public static final String LIB_APPLICATION_ASS_SUITE_DECHEANCE = "Application de la création des demandes ASS suite déchéance";
  private static final Damj DATE_APPLICATION_ASS_DEPOT_TARDIF_SUITE_DECHEANCE = new Damj(2018, 2, 1);
  public static final String LIB_APPLICATION_ASS_DEPOT_TARDIF_SUITE_DECHEANCE = "Application du depot tardif des demandes ASS suite déchéance";
  public static final String LIB_EXTINC_REJET_RESS = "Date d'application du SNOW IN 0993101";
  private static final Damj DATE_EXTINC_REJET_RESS = new Damj(2016, 9, 1);
  public static final String LIB_BLOC_CLCA_ET_ACCRE_ASS = "Date d'application pour le SNOW INC0122770";
  private static final Damj DATE_BLOC_CLCA_ET_ACCRE_ASS = new Damj(2017, 1, 1);
  public static final String LIB_BLOCAGE_PBJC_ATS = "Date de blocage des PBJC pour l'ATS";
  private static final Damj DATE_BLOCAGE_PBJC_ATS = new Damj(2016, 12, 31);
  public static final String LIB_NON_CUMUL_ASS_AAH = "Date d'application du non cumul ASS et AAH";
  private static final Damj DATE_NON_CUMUL_ASS_AAH = new Damj(2017, 1, 1);
  public static final String LIB_ARRET_ATA = "Date d'application pour l'arret des OD ATA";
  private static final Damj DATE_ARRET_ATA = new Damj(2017, 9, 1);
  public static final String LIB_APPLICATION_DATE_BASCULE_ASS_DISPOSITIF_2017 = "Bascule dans le nouveau dispositif ASS 2017";
  private static final Damj DATE_APPLICATION_DATE_BASCULE_ASS_DISPOSITIF_2017 = new Damj(2017, 9, 1);
  public static final String LIB_PRISE_EN_COMPTE_IDCC_CONNAISSANCE_INFO = "Date de prise en compte IDCC à la place des NAF : date connaissance info";
  private static final Damj DATE_PRISE_EN_COMPTE_IDCC_CONNAISSANCE_INFO = new Damj(2017, 10, 21);
  public static final String LIB_PRISE_EN_COMPTE_IDCC_DEBUT_CONTRAT = "Date de prise en compte IDCC à la place des NAF : date debut contrat";
  private static final Damj DATE_PRISE_EN_COMPTE_IDCC_DEBUT_CONTRAT = new Damj(2017, 10, 1);
  public static final String LIB_PRISE_EN_COMPTE_IDCC_FIN_TRANSITOIRE = "Date de fin periode transitoire prise en compte idcc generique";
  private static final Damj DATE_PRISE_EN_COMPTE_IDCC_FIN_TRANSITOIRE = new Damj(2018, 11, 20);
  public static final String LIB_APPLICATION_CONVENTION_2017_DEUXIEME_PARTIE = "Date d'application des changements ARE17 à partir du 1er janvier 2018";
  private static final Damj DATE_APPLICATION_CONVENTION_2017_DEUXIEME_PARTIE = new Damj(2018, 1, 1);
  public static final String LIB_ASS_CUMULAR_FORMATION = "ASS cumul AR Formation INC0417242";
  private static final Damj DATE_ASS_CUMULAR_FORMATION = new Damj(2018, 3, 1);
  public static final String LIB_APPLICATION_BLOCAGE_PR_RETRAITE_ENTICIPE_RFF = "Interruption de paiement la veuille de retraite";
  private static final Damj DATE_APPLICATION_BLOCAGE_PR_RETRAITE_ENTICIPE_RFF = new Damj(2016, 8, 1);
  public static final String LIB_APPLICATION_ARCE_EN_DOUBLE_NON_PERMIS = "Demandes ARCE en double sur même OD non acceptées";
  private static final Damj DATE_APPLICATION_ARCE_EN_DOUBLE_NON_PERMIS = new Damj(2018, 2, 1);
  private static final Damj DATE_APPLICATION_LIQUIDATION_RFF_MAYOTTE = new Damj(2016, 1, 1);
  public static final String LIB_APPLICATION_LIQUIDATION_RFF_MAYOTTE = "Application de la liquidation d'une demande RFF à Mayotte";
  public static final String LIB_APPLICATION_NOUVELLE_CONVENTION_SPECTACLE_2016 = "Date d'application de la nouvelle convention Spectacle 2016";
  private static final Damj DATE_APPLICATION_NOUVELLE_CONVENTION_SPECTACLE_2016 = new Damj(2016, 8, 1);
  private static final Damj DATE_APPLICATION_CONVENTION_2017 = new Damj(2017, 11, 1);
  public static final String LIB_APPLICATION_CONVENTION_2017 = "Date d'application de la convention ARE 2017";
  public static final String LIB_NOUVELLE_CONVENTION_CSP_2015 = "Date d'application de la nouvelle convention CSP 2015";
  private static final Damj DATE_NOUVELLE_CONVENTION_CSP_2015 = new Damj(2015, 2, 1);
  public static final String LIB_NOUVELLE_CONVENTION_CSP_2015_VEILLE = "Date d'application de la Veille nouvelle convention CSP 2015";
  private static final Damj DATE_NOUVELLE_CONVENTION_CSP_2015_VEILLE = new Damj(2015, 1, 31);
  public static final String LIB_NOUVELLE_CONVENTION_CSP_2014 = "Date d'application de la nouvelle convention CSP 2014";
  private static final Damj DATE_NOUVELLE_CONVENTION_CSP_2014 = new Damj(2014, 10, 1);
  public static final String LIB_NOUVELLE_CONVENTION_CSP_2014_VEILLE = "Date d'application de la Veille nouvelle convention CSP 2014";
  private static final Damj DATE_DEBUT_DUREE_REGLEMENTAIRE_2017 = DATE_APPLICATION_CONVENTION_2017;
  public static final String LIB_DEBUT_DUREE_REGLEMENTAIRE_2017 = "Date de durée réglementaire 2017";
  private static final Damj DATE_DEBUT_NCAC17_ARRONDI = new Damj(2017, 11, 1);
  public static final String LIB_DEBUT_NCAC17_ARRONDI = "Date application NCAC17 pour arrondi";
  private static final Damj DATE_FIN_DECOR_REGLEMENTAIRE_2016 = DATE_APPLICATION_CONVENTION_2017.veille();
  public static final String LIB_FIN_DECOR_REGLEMENTAIRE_2016 = "Date de fin du décor réglementaire 2016";
  private static final Damj DATE_DEBUT_DECOR_REGLEMENTAIRE_2017 = DATE_APPLICATION_CONVENTION_2017;
  public static final String LIB_DEBUT_DECOR_REGLEMENTAIRE_2017 = "Date de debut du décor réglementaire 2017";
  private static final Damj DATE_FIN_PRODUIT_ARE_CGE_2014 = DATE_DEBUT_DECOR_REGLEMENTAIRE_2017.veille();
  public static final String LIB_FIN_PRODUIT_ARE_CGE_2014 = "Date de fin du produit ARE CGE et CSA 2014";
  private static final Damj DATE_DEBUT_PRODUIT_ARE_CGE_2017 = DATE_APPLICATION_CONVENTION_2017;
  public static final String LIB_DEBUT_PRODUIT_ARE_CGE_2017 = "Date de debut du produit ARE CGE et CSA 2017";
  private static final Damj DATE_DEBUT_PRODUIT_APS_AFD_2017 = new Damj(2017, 12, 1);
  public static final String LIB_DEBUT_PRODUIT_APS_AFD_2017 = "Date de debut des produits APS17 et AFD17";
  private static final Damj DATE_DEBUT_2EME_CHANGEMENT_CONVENTION_2017 = new Damj(2018, 1, 1);
  public static final String LIB_DEBUT_2EME_CHANGEMENT_CONVENTION_2017 = "Date de debut du 2eme changement convention 2017";
  
  public static synchronized GestionnaireDateApplication getInstance()
    throws CoucheLogiqueException
  {
    if (instance == null) {
      initialiserInstance();
    }
    return instance;
  }
  
  private static void completerReferentielDepuisBaseDonnees()
  {
    referentielDateApplicationBaseDonnees = OutilChargementDateApplication.getInstance().chargerDatesApplication();
  }
  
  public Damj recupererDateApplication(String cle)
  {
    Damj dateApplication;
    Damj dateApplication;
    if ((ContexteExecutionJunit.isActif()) || (ContexteExecutionVnr.isActif())) {
      dateApplication = getDateApplication(cle);
    } else {
      dateApplication = getDateApplicationAvecGestionBaseDonnees(cle);
    }
    return dateApplication;
  }
  
  private static void initialiserInstance()
    throws CoucheLogiqueException
  {
    instance = new GestionnaireDateApplication();
    referentielDateApplication = new HashMap();
    referentielDateApplicationBaseDonnees = new HashMap();
    completerReferentiel();
    if (!ContexteExecutionJunit.isActif()) {
      completerReferentielDepuisBaseDonnees();
    }
  }
  
  private static void completerReferentiel()
    throws CoucheLogiqueException
  {
    try
    {
      Field[] listeChamps = instance.getClass().getDeclaredFields();
      for (int i = 0; i < listeChamps.length; i++)
      {
        Field champCourant = listeChamps[i];
        if ((!champCourant.isSynthetic()) && (!champAIgnorer(champCourant.getName())))
        {
          String nom = champCourant.getName();
          Object obj = champCourant.get(null);
          if ((obj instanceof String))
          {
            String valeur = (String)obj;
            
            traiterVariable(nom, valeur);
          }
        }
      }
    }
    catch (IllegalArgumentException ex)
    {
      GestionnaireErreur.getInstance().genererCoucheLogiqueException("ERR_GESTIONNAIRE_DATE_REFLEXION");
    }
    catch (IllegalAccessException ex)
    {
      GestionnaireErreur.getInstance().genererCoucheLogiqueException("ERR_GESTIONNAIRE_DATE_REFLEXION2");
    }
  }
  
  private static void traiterVariable(String nom, String valeur)
    throws CoucheLogiqueException, IllegalAccessException
  {
    verifierLongeurCode(valeur);
    if (nom.startsWith("LIB_")) {
      traitementDateApplication(nom, valeur);
    } else if (!nom.startsWith("LIB_")) {
      GestionnaireErreur.getInstance().genererCoucheLogiqueException("ERR_GESTIONNAIRE_FORMAT_DATE", new Object[] { "LIB_" });
    }
  }
  
  private static boolean champAIgnorer(String nom)
  {
    return (nom.startsWith("instance")) || (nom.startsWith("referentiel")) || (nom.startsWith("PREFIXE")) || (nom.startsWith("TAILLE"));
  }
  
  private static void traitementDateApplication(String nom, String valeur)
    throws IllegalAccessException, CoucheLogiqueException
  {
    String nomDate = nom.replaceFirst("LIB_", "DATE_");
    try
    {
      Field champDate = instance.getClass().getDeclaredField(nomDate);
      Damj dateApplication = (Damj)champDate.get(null);
      if (referentielDateApplication.get(valeur) != null) {
        GestionnaireErreur.getInstance().genererCoucheLogiqueException("ERR_GESTIONNAIRE_DATE_CODE_DOUBLE", new Object[] { valeur });
      }
      referentielDateApplication.put(valeur, dateApplication);
    }
    catch (NoSuchFieldException ex)
    {
      GestionnaireErreur.getInstance().genererCoucheLogiqueException("ERR_GESTIONNAIRE_DATE_CODE_SOLITAIRE", new Object[] { nom });
    }
  }
  
  private static void verifierLongeurCode(String valeur)
    throws CoucheLogiqueException
  {
    if (valeur.length() > 100) {
      GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_LONGUEUR_DATE_APPLICATION", new Object[] { valeur });
    }
  }
  
  private static Damj getDateApplication(String cle)
  {
    return (Damj)referentielDateApplication.get(cle);
  }
  
  private static Damj getDateApplicationAvecGestionBaseDonnees(String cle)
  {
    Damj dateARetourne = (Damj)referentielDateApplicationBaseDonnees.get(cle);
    if (dateARetourne == null) {
      dateARetourne = getDateApplication(cle);
    }
    return dateARetourne;
  }
}

/* Location:
 * Qualified Name:     GestionnaireDateApplication
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */