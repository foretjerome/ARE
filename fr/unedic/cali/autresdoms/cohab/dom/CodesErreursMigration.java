package fr.unedic.cali.autresdoms.cohab.dom;

import fr.unedic.cali.dom.Erreur;
import java.util.HashMap;

public class CodesErreursMigration
{
  public static Erreur getErreur(int p_niveau, String p_codeErreur)
  {
    Erreur erreur = new Erreur(p_niveau, p_codeErreur, (String)s_libellesErreursMigration.get(p_codeErreur));
    
    return erreur;
  }
  
  public static Erreur getErreur(int p_niveau, String p_codeErreur, String p_valeur)
  {
    String valeur = "valeur --> ";
    if (p_valeur == null) {
      valeur = valeur + "null";
    } else {
      valeur = valeur + p_valeur;
    }
    Erreur erreur = new Erreur(p_niveau, p_codeErreur, (String)s_libellesErreursMigration.get(p_codeErreur) + " : " + valeur);
    
    return erreur;
  }
  
  public static Erreur getErreurException(int p_niveau, String p_codeErreur, String p_lilbelleException)
  {
    Erreur erreur = new Erreur(p_niveau, p_codeErreur, (String)s_libellesErreursMigration.get(p_codeErreur) + " : " + p_lilbelleException);
    
    return erreur;
  }
  
  public static HashMap s_libellesErreursMigration = new HashMap();
  public static final String CODE_ERR_LIQ_HG_TITRE_DEMANDE = "LIQ_HG_TITRE_DEMANDE";
  public static final String CODE_ERR_LIQ_HG_CL_EXCEPTION = "LIQ_HG_CL_EXCEPTION";
  public static final String CODE_ERR_CAL_HG_CL_EXCEPTION = "CAL_HG_CL_EXCEPTION";
  public static final String CODE_ERR_LIQ_HG_TYPE_EXAMEN_DEMANDE = "LIQ_HG_TYPE_EXAMEN";
  private static final String LIB_ERR_LIQ_HG_TYPE_EXAMEN_DEMANDE = "Type examen de la demande incohérent";
  public static final String CODE_ERR_LIQ_HG_CODE_PRODUIT = "LIQ_HG_CODE_PRODUIT";
  private static final String LIB_ERR_LIQ_HG_CODE_PRODUIT = "Code produit incohérent";
  public static final String CODE_ERR_LIQ_HG_DATE_DEPOT = "LIQ_HG_DATE_DEPOT";
  private static final String LIB_ERR_LIQ_HG_DATE_DEPOT = "Date de dépôt nulle";
  public static final String CODE_ERR_LIQ_HG_ID_PEC = "LIQ_HG_ID_PEC";
  private static final String LIB_ERR_LIQ_HG_ID_PEC = "Identifiant de la Pec nul";
  public static final String CODE_ERR_LIQ_HG_RANG_DAL = "LIQ_HG_RANG_DAL";
  private static final String LIB_ERR_LIQ_HG_RANG_DAL = "Rang de la Dal nul";
  public static final String CODE_ERR_LIQ_HG_CODE_ORIGINE_DAL = "LIQ_HG_ORIGINE_DAL";
  private static final String LIB_ERR_LIQ_HG_CODE_ORIGINE_DAL = "Code origine de la dal nul";
  public static final String CODE_ERR_LIQ_HG_CLASS_ADM = "LIQ_HG_CLASS_ADM";
  private static final String LIB_ERR_LIQ_HG_CLASS_ADM = "Classement administratif incohérent";
  public static final String CODE_ERR_LIQ_HG_EVT_REF_EXAMEN = "LIQ_HG_EVT_REF_EXAM";
  private static final String LIB_ERR_LIQ_HG_EVT_REF_EXAMEN = "Evénement référence examen incohérent";
  public static final String CODE_ERR_LIQ_HG_EVT_REF_EXAMEN_DATE_EXAMEN = "LIQ_HG_EVT_DATE_EXAM";
  private static final String LIB_ERR_LIQ_HG_EVT_REF_EXAMEN_DATE_EXAMEN = "L'événement référence examen ne peux pas etre construit car la date d'examen est nulle";
  public static final String CODE_ERR_LIQ_HG_OBJECTIF_DECISIONNE = "LIQ_HG_OBJECT_DECIS";
  private static final String LIB_ERR_LIQ_HG_OBJECTIF_DECISIONNE = "Objectif décision incohérent";
  public static final String CODE_ERR_LIQ_HG_REF_DECISION = "LIQ_HG_REF_DECISION";
  private static final String LIB_ERR_LIQ_HG_REF_DECISION = "Référence de la décision nulle";
  public static final String CODE_ERR_LIQ_HG_DATE_ATTRIBUTION = "LIQ_HG_DATE_ATTRIB";
  private static final String LIB_ERR_LIQ_HG_DATE_ATTRIBUTION = "Date d'attribution nulle";
  public static final String CODE_ERR_LIQ_HG_PJI = "LIQ_HG_PJI";
  private static final String LIB_ERR_LIQ_HG_PJI = "Pji nul";
  public static final String CODE_ERR_LIQ_HG_DATE_DERNIERE_VALIDATION = "LIQ_ASU_DATE_VALID";
  private static final String LIB_ERR_LIQ_HG_DATE_DERNIERE_VALIDATION = "Date de dernière validation est nulle";
  public static final String CODE_ERR_LIQ_HG_DEMANDE_MIGREE_OK = "LIQ_HG_DEMANDE_OK";
  private static final String LIB_ERR_LIQ_HG_DEMANDE_MIGREE_OK = "La demande a été migrée correctement";
  public static final String CODE_ERR_LIQ_HG_RATTACHER_DEMANDE_INDIVIDU = "LIQ_HG_DEMANDE_DE";
  private static final String LIB_ERR_LIQ_HG_RATTACHER_DEMANDE_INDIVIDU = "Erreur lors du rattachement de la demande à l'individu";
  public static final String CODE_ERR_LIQ_HG_POST_TRAITEMENT = "LIQ_HG_POST_TRAIT";
  private static final String LIB_ERR_LIQ_HG_POST_TRAITEMENT = "Erreur lors de l'appel au post traitement";
  public static final String CODE_ERR_LIQ_HG_ALIMENTATION_BASE_PIVOT = "LIQ_HG_ALIM_B_PIVOT";
  private static final String LIB_ERR_LIQ_HG_ALIMENTATION_BASE_PIVOT = "Erreur lors de l'alimentation de la base pivot";
  public static final String CODE_ERR_LIQ_HG_INSTALLATION_DEMANDE = "LIQ_HG_INSTALL_DEM";
  private static final String LIB_ERR_LIQ_HG_INSTALLATION_DEMANDE = "Une erreur est survenue lors de l'installation de la demande";
  public static final String CODE_ERR_CALCUL_MIGRATION_CALENDRIER_SIGMA_NUL = "CAL_HG_CAL_NUL";
  public static final String LIB_ERR_CALCUL_MIGRATION_CALENDRIER_SIGMA_NUL = "Le calendrier Sigma est nul";
  public static final String CODE_ERR_CALCUL_MIGRATION_CALENDRIER_NCP_NUL = "CAL_HG_CAL_NCP_NUL";
  public static final String LIB_ERR_CALCUL_MIGRATION_CALENDRIER_NCP_NUL = "Le calendrier Ncp est nul";
  public static final String CODE_ERR_CALCUL_MIGRATION_PJI_DIFF_ENTRE_SIGMA_ET_NCP = "CAL_PJI_DIFF";
  public static final String LIB_ERR_CALCUL_MIGRATION_PJI_DIFF_ENTRE_SIGMA_ET_NCP = "Le PJI entre Sigma et Calcul et différent";
  public static final String CODE_ERR_CALCUL_MIGRATION_NB_UT_DIFF_ENTRE_SIGMA_ET_NCP = "CAL_NB_UT_DIFF";
  public static final String LIB_ERR_CALCUL_MIGRATION_NB_UT_DIFF_ENTRE_SIGMA_ET_NCP = "Nombre d'UT différent : ";
  public static final String CODE_ERR_CALCUL_MIGRATION_ECART_DJI_MIGRATION_SIMPLIFIEE = "CAL_ECART_DJI_MIGRATION_DJI";
  public static final String LIB_ERR_CALCUL_MIGRATION_ECART_DJI_MIGRATION_SIMPLIFIEE = "Ecart de type DJI en migration simplifiée";
  public static final String CODE_ERR_LIQ_DEMANDE_ORIGINE_INCONNU = "LIQ_DEM_ORIG_INCONNU";
  private static final String LIB_ERR_LIQ_DEMANDE_ORIGINE_INCONNU = "La demande d'origine n'a pas été trouvé donc elle n'a pu etre rattachée à cette demande";
  public static final String CODE_ERR_LIQ_REF_EXTERNE_DEMANDE = "LIQ_REF_EXT_DEMANDE";
  private static final String LIB_ERR_LIQ_REF_EXTERNE_DEMANDE = "La référence externe de la demande ne doit pas être nulle.";
  public static final String CODE_ERR_LIQ_ASU_MONT_PENSION_INVAL = "LIQ_ASU_MT_P_INVAL";
  private static final String LIB_ERR_LIQ_ASU_MONT_PENSION_INVAL = "Montant de la pension invalidité nulle";
  public static final String CODE_ERR_LIQ_ASU_COEF_AVTG_VIEILLESSE = "LIQ_ASU_COEF_AVT_V";
  private static final String LIB_ERR_LIQ_ASU_COEF_AVTG_VIEILLESSE = "Coefficient avantage vieillesse nul";
  public static final String CODE_ERR_LIQ_ASU_ID_PERIODE_FGD = "LIQ_ASU_ID_PERIO_FGD";
  private static final String LIB_ERR_LIQ_ASU_ID_PERIODE_FGD = "Identifiant de la période de Fgd est null. Impossible de déterminer la date et le motif du Fgd";
  public static final String CODE_ERR_LIQ_ASU_PERIODE_FGD_INCONNU = "LIQ_ASU_PERIO_FGD";
  private static final String LIB_ERR_LIQ_ASU_PERIODE_FGD_INCONNU = "La Période Fgd est inconnu chez Gaec. Impossible de déterminer la date et le motif du Fgd";
  public static final String CODE_ERR_LIQ_ASU_TYPE_PERIODE = "LIQ_ASU_TYPE_PERIO";
  private static final String LIB_ERR_LIQ_ASU_TYPE_PERIODE = "La Période Fgd envoyée par Sigma n'est pas de type Activité Salarié";
  public static final String CODE_ERR_LIQ_ASU_MOTIF_REJET = "LIQ_ASU_MOTIF_REJET";
  private static final String LIB_ERR_LIQ_ASU_MOTIF_REJET = "Motif de rejet incohérent";
  public static final String CODE_ERR_LIQ_ASU_QTE_AFFILIATION_1 = "LIQ_ASU_QTE_AFFI_1";
  private static final String LIB_ERR_LIQ_ASU_QTE_AFFILIATION_1 = "Quantité d'affiliation 1 est nulle";
  public static final String CODE_ERR_LIQ_ASU_UNITE_AFFILIATION_1 = "LIQ_ASU_UNITE_AFFI_1";
  private static final String LIB_ERR_LIQ_ASU_UNITE_AFFILIATION_1 = "L'unité de la quantité d'affiliation 1 est nulle ou inconnue";
  public static final String CODE_ERR_LIQ_ASU_UNITE_AFFILIATION_INCONNUE_1 = "LIQ_ASU_UNITE_AFFI_1";
  private static final String LIB_ERR_LIQ_ASU_UNITE_AFFILIATION_INCONNUE_1 = "L'unité de la quantité d'affiliation 1 est inconnue";
  public static final String CODE_ERR_LIQ_ASU_QTE_AFFILIATION_2 = "LIQ_ASU_QTE_AFFI_2";
  private static final String LIB_ERR_LIQ_ASU_QTE_AFFILIATION_2 = "Quantité d'affiliation 2 est nulle";
  public static final String CODE_ERR_LIQ_ASU_UNITE_AFFILIATION_2 = "LIQ_ASU_UNITE_AFFI_2";
  private static final String LIB_ERR_LIQ_ASU_UNITE_AFFILIATION_2 = "L'unité de la quantité d'affiliation 2 est nulle ou inconnue";
  public static final String CODE_ERR_LIQ_ASU_UNITE_AFFILIATION_INCONNUE_2 = "LIQ_ASU_UNITE_AFFI_2";
  private static final String LIB_ERR_LIQ_ASU_UNITE_AFFILIATION_INCONNUE_2 = "L'unité de la quantité d'affiliation 2 est inconnue";
  public static final String CODE_ERR_LIQ_ASU_MONTANT_BRUT = "LIQ_ASU_MONTANT_BRUT";
  private static final String LIB_ERR_LIQ_ASU_MONTANT_BRUT = "Le montant brut est nul";
  public static final String CODE_ERR_LIQ_ASU_MONTANT_BRUT_DP = "LIQ_ASU_MT_BRUT_DP";
  private static final String LIB_ERR_LIQ_ASU_MONTANT_BRUT_DP = "Le montant brut du droit précédent est nul";
  public static final String CODE_ERR_LIQ_ASU_ID_ADMISSION = "LIQ_ASU_ID_ADMISSION";
  private static final String LIB_ERR_LIQ_ASU_ID_ADMISSION = "La référence externe Sigma d'admission est nulle (RSOD)";
  public static final String CODE_ERR_LIQ_ASU_ID_REPRISE = "LIQ_ASU_ID_REPRISE";
  private static final String LIB_ERR_LIQ_ASU_ID_REPRISE = "La référence externe Sigma de reprise est nulle (RSRP)";
  public static final String CODE_ERR_LIQ_ASU_DELAIS_REPOT_PJI = "LIQ_ASU_DELAIS_PJI";
  private static final String LIB_ERR_LIQ_ASU_DELAIS_REPOT_PJI = "Le lendemain du terme des carences ne coincide pas avec le Pji";
  public static final String CODE_ERR_LIQ_ASU_NB_JOURS_ACTIVITE_COURRIER_ASS = "LIQ_ASU_NB_JOURS_ACT";
  private static final String LIB_ERR_LIQ_ASU_NB_JOURS_ACTIVITE_COURRIER_ASS = "Le nombre de jours d'activité pour l'édition du Courrier Ass est nul";
  public static final String CODE_ERR_LIQ_ASU_CODE_EMPLOI_A2B = "LIQ_ASU_EMPLOI_A2B";
  private static final String LIB_ERR_LIQ_ASU_CODE_EMPLOI_A2B = "Le code emploi (Annexe A2b) n'a pas pu être déterminé";
  public static final String CODE_ERR_LIQ_ASU_NB_HEURES_PLAFONNE = "LIQ_ASU_NBH_PLAFONNE";
  private static final String LIB_ERR_LIQ_ASU_NB_HEURES_PLAFONNE = "Le nombre d'heures travaillées plafonné n'a pas pu être déterminé";
  public static final String CODE_ERR_LIQ_ASU_NB_HEURES_ETENDU = "LIQ_ASU_NBH_ETENDU";
  private static final String LIB_ERR_LIQ_ASU_NB_HEURES_ETENDU = "Le nombre d'heures travaillées étendu n'a pas pu être déterminé";
  public static final String CODE_ERR_LIQ_ASU_PRC = "LIQ_ASU_PRC";
  private static final String LIB_ERR_LIQ_ASU_PRC = "La PRC n'a pas pu être déterminé";
  public static final String CODE_ERR_LIQ_ASU_NB_JOURS_EMPLOI = "LIQ_ASU_NBJ_EMPLOI";
  private static final String LIB_ERR_LIQ_ASU_NB_JOURS_EMPLOI = "Le nombre de jours d'emploi n'a pas pu être déterminé";
  public static final String CODE_ERR_LIQ_ASU_DUREE_THEORIQUE = "LIQ_ASU_DUREE_THEOR";
  private static final String LIB_ERR_LIQ_ASU_DUREE_THEORIQUE = "Durée théorique nulle";
  public static final String CODE_ERR_LIQ_ASU_DUREE_EFFECTIVE = "LIQ_ASU_DUREE_EFFECT";
  private static final String LIB_ERR_LIQ_ASU_DUREE_EFFECTIVE = "Durée effective nulle";
  public static final String CODE_ERR_LIQ_ASU_DUREE_RENOUVELLEMENT = "LIQ_ASU_DUREE_RNV";
  private static final String LIB_ERR_LIQ_ASU_DUREE_RENOUVELLEMENT = "Durée de renouvellement nulle";
  public static final String CODE_ERR_LIQ_ASU_MONTANT_SJRI = "LIQ_ASU_MT_SJRI";
  private static final String LIB_ERR_LIQ_ASU_MONTANT_SJRI = "Montant du SJRI nul";
  public static final String CODE_ERR_LIQ_ASU_MONTANT_SJRIP = "LIQ_ASU_MT_SJRIP";
  private static final String LIB_ERR_LIQ_ASU_MONTANT_SJRIP = "Montant du SJRIP nul";
  public static final String CODE_ERR_LIQ_ASU_MONTANT_SJRRP = "LIQ_ASU_MT_SJRRP";
  private static final String LIB_ERR_LIQ_ASU_MONTANT_SJRRP = "Montant du SJRRP nul";
  public static final String CODE_ERR_LIQ_ASU_DIVISEUR_SJRI = "LIQ_ASU_DIV_SJRI";
  private static final String LIB_ERR_LIQ_ASU_DIVISEUR_SJRI = "Diviseur du SJRI nul";
  public static final String CODE_ERR_LIQ_ASU_DATE_DEBUT_SJRI = "LIQ_ASU_DEBUT_SJRI";
  private static final String LIB_ERR_LIQ_ASU_DATE_DEBUT_SJRI = "Date de début du Sjr Initial du droit courant nulle";
  public static final String CODE_ERR_LIQ_ASU_DATE_FIN_SJRI = "LIQ_ASU_FIN_SJRI";
  private static final String LIB_ERR_LIQ_ASU_DATE_FIN_SJRI = "Date de fin du Sjr Initial du droit courant nulle";
  public static final String CODE_ERR_LIQ_ASU_MONTANT_SJCI = "LIQ_ASU_MONTANT_SJCI";
  private static final String LIB_ERR_LIQ_ASU_MONTANT_SJCI = "Montant du sjci nul";
  public static final String CODE_ERR_LIQ_ASU_DATE_SJCI = "LIQ_ASU_DATE_SJCI";
  private static final String LIB_ERR_LIQ_ASU_DATE_SJCI = "Date d'effet du sjci nulle";
  public static final String CODE_ERR_LIQ_ASU_PERIODES_SJC = "LIQ_ASU_PERIODES_SJC";
  private static final String LIB_ERR_LIQ_ASU_PERIODES_SJC = "Aucune période en activité conservée n'a pu etre trouvée sur ce droit";
  public static final String CODE_ERR_LIQ_ASU_CAPITAL_OD_COURANTE = "LIQ_ASU_CAPITAL_DC";
  private static final String LIB_ERR_LIQ_ASU_CAPITAL_OD_COURANTE = "Capital de l'OD courante nul";
  public static final String CODE_ERR_LIQ_ASU_DUREE_THEORIQUE_DR = "LIQ_ASU_DUREE_T_DR";
  private static final String LIB_ERR_LIQ_ASU_DUREE_THEORIQUE_DR = "Durée théorique du droit retenu nulle";
  public static final String CODE_ERR_LIQ_ASU_DUREE_EFFECTIVE_DR = "LIQ_ASU_DUREE_E_DR";
  private static final String LIB_ERR_LIQ_ASU_DUREE_EFFECTIVE_DR = "Durée effective du droit retenu nulle";
  public static final String CODE_ERR_LIQ_ASU_DUREE_RENOUVELLEMENT_DR = "LIQ_ASU_DUREE_RNV_DR";
  private static final String LIB_ERR_LIQ_ASU_DUREE_RENOUVELLEMENT_DR = "Durée de renouvellement du droit retenu nulle";
  public static final String CODE_ERR_LIQ_ASU_MONTANT_SJRI_DR = "LIQ_ASU_MT_SJRI_DR";
  private static final String LIB_ERR_LIQ_ASU_MONTANT_SJRI_DR = "Montant du Sjr Initial du droit courant nul";
  public static final String CODE_ERR_LIQ_ASU_DATE_FIN_SJRI_DR = "LIQ_ASU_FIN_SJRI_DR";
  private static final String LIB_ERR_LIQ_ASU_DATE_FIN_SJRI_DR = "Date de fin du Sjr Initial du droit retenu nulle";
  public static final String CODE_ERR_LIQ_ASU_CAPITAL_OD_PRECEDENTE = "LIQ_ASU_CAPITAL_DP";
  private static final String LIB_ERR_LIQ_ASU_CAPITAL_OD_PRECEDENTE = "Capital de l'OD précédente nul";
  public static final String CODE_ERR_LIQ_ASU_SJRRP_DR = "LIQ_ASU_SJRRP_DR";
  private static final String LIB_ERR_LIQ_ASU_SJRRP_DR = "Le Sjrrp ne peut pas etre revalorisé";
  public static final String CODE_ERR_LIQ_ASU_NB_JOURS_DIFFERE = "LIQ_ASU_NB_JRS_DIFF";
  private static final String LIB_ERR_LIQ_ASU_NB_JOURS_DIFFERE = "Le nombre de jours du différé ne doit pas etre nul";
  public static final String CODE_ERR_LIQ_ASU_DEBUT_DIFFERE = "LIQ_ASU_DEBUT_DIFF";
  private static final String LIB_ERR_LIQ_ASU_DEBUT_DIFFERE = "La date de début du différé ne doit pas etre nulle";
  public static final String CODE_ERR_LIQ_ASU_FIN_DIFFERE = "LIQ_ASU_FIN_DIFFERE";
  private static final String LIB_ERR_LIQ_ASU_FIN_DIFFERE = "La date de fin du différé ne doit pas etre nulle";
  public static final String CODE_ERR_LIQ_ASU_NB_JOURS_ICCP = "LIQ_ASU_NB_JRS_ICCP";
  private static final String LIB_ERR_LIQ_ASU_NB_JOURS_ICCP = "Le nombre de jours de la carence ICCP ne doit pas etre nul";
  public static final String CODE_ERR_LIQ_ASU_DEBUT_ICCP = "LIQ_ASU_DEBUT_ICCP";
  private static final String LIB_ERR_LIQ_ASU_DEBUT_ICCP = "La date de début de la carence ICCP ne doit pas etre nulle";
  public static final String CODE_ERR_LIQ_ASU_FIN_ICCP = "LIQ_ASU_FIN_ICCP";
  private static final String LIB_ERR_LIQ_ASU_FIN_ICCP = "La date de fin de la carence ICCP ne doit pas etre nulle";
  public static final String CODE_ERR_LIQ_ASU_NB_JOURS_ISLR = "LIQ_ASU_NB_JRS_ISLR";
  private static final String LIB_ERR_LIQ_ASU_NB_JOURS_ISLR = "Le nombre de jours de la carence ISLR ne doit pas etre nul";
  public static final String CODE_ERR_LIQ_ASU_DEBUT_ISLR = "LIQ_ASU_DEBUT_ISLR";
  private static final String LIB_ERR_LIQ_ASU_DEBUT_ISLR = "La date de début de la carence ISLR ne doit pas etre nulle";
  public static final String CODE_ERR_LIQ_ASU_FIN_ISLR = "LIQ_ASU_FIN_ISLR";
  private static final String LIB_ERR_LIQ_ASU_FIN_ISLR = "La date de fin de la carence ISLR ne doit pas etre nulle";
  public static final String CODE_ERR_LIQ_ASU_NB_JOURS_PMC = "LIQ_ASU_NB_JOURS_PMC";
  private static final String LIB_ERR_LIQ_ASU_NB_JOURS_PMC = "Le nombre de jours de la carence PMC ne doit pas etre nul";
  public static final String CODE_ERR_LIQ_ASU_DEBUT_PMC = "LIQ_ASU_DEBUT_PMC";
  private static final String LIB_ERR_LIQ_ASU_DEBUT_PMC = "La date de début de la carence PMC ne doit pas etre nulle";
  public static final String CODE_ERR_LIQ_ASU_FIN_PMC = "LIQ_ASU_FIN_PMC";
  private static final String LIB_ERR_LIQ_ASU_FIN_PMC = "La date de fin de la carence PMC ne doit pas etre nulle";
  public static final String CODE_ERR_LIQ_ASU_NB_JOURS_DIFFERE_STANDARD = "LIQ_ASU_NBJ_DIFF_STD";
  private static final String LIB_ERR_LIQ_ASU_NB_JOURS_DIFFERE_STANDARD = "Le nombre de jours du différé standard ne doit pas etre nul";
  public static final String CODE_ERR_LIQ_ASU_DEBUT_DIFFERE_STANDARD = "LIQ_ASU_DEB_DIFF_STD";
  private static final String LIB_ERR_LIQ_ASU_DEBUT_DIFFERE_STANDARD = "La date de début du différé standard ne doit pas etre nulle";
  public static final String CODE_ERR_LIQ_ASU_FIN_DIFFERE_STANDARD = "LIQ_ASU_FIN_DIFF_STD";
  private static final String LIB_ERR_LIQ_ASU_FIN_DIFFERE_STANDARD = "La date de fin du différé standard ne doit pas etre nulle";
  public static final String CODE_ERR_LIQ_ASU_ARTICLE3 = "LIQ_ASU_ARTICLE3";
  private static final String LIB_ERR_LIQ_ASU_ARTICLE3 = "L' Article 3 ne doit pas etre nul";
  public static final String CODE_ERR_LIQ_ASU_RA = "LIQ_ASU_RA";
  private static final String LIB_ERR_LIQ_ASU_RA = "Le réglement applicable nul ou incohérent";
  public static final String CODE_ERR_LIQ_ASU_COEF_TPS_PARTIEL = "LIQ_ASU_COEF_TPS_P";
  private static final String LIB_ERR_LIQ_ASU_COEF_TPS_PARTIEL = "Le coefficient temps partiel ne doit pas etre nul";
  public static final String CODE_ERR_LIQ_ASU_COEF_SAISONNIER = "LIQ_ASU_COEF_SAIS";
  private static final String LIB_ERR_LIQ_ASU_COEF_SAISONNIER = "Le coefficient saisonnier ne doit pas etre nul";
  public static final String CODE_ERR_LIQ_ASU_TYPE_CARAC_SAISONNIER = "LIQ_ASU_TYPE_CARAC_S";
  private static final String LIB_ERR_LIQ_ASU_TYPE_CARAC_SAISONNIER = "Le type du caractère saisonnier est incohérent";
  public static final String CODE_ERR_LIQ_ASU_ID_PERIODE_VALIDATION = "LIQ_ASU_PERIO_VALID";
  private static final String LIB_ERR_LIQ_ASU_ID_PERIODE_VALIDATION = "La période de validation produit ne doit pas etre nulle";
  public static final String CODE_ERR_LIQ_ASU_ID_PERIODE_VALIDATION_INCONNU = "LIQ_ASU_PERIO_VALID";
  private static final String LIB_ERR_LIQ_ASU_ID_PERIODE_VALIDATION_INCONNU = "La période de validation produit est inconnu chez Gaec";
  public static final String CODE_ERR_LIQ_ASU_PERIODE_VALIDATION = "LIQ_ASU_PER_INVALIDE";
  private static final String LIB_ERR_LIQ_ASU_PERIODE_VALIDATION = "La période Validation Produit provenant de Sigma n'est pas une activité salariée";
  public static final String CODE_ERR_LIQ_ASU_PERIODE_FGD = "LIQ_ASU_PER_FGD";
  private static final String LIB_ERR_LIQ_ASU_PERIODE_FGD = "La période FGD provenant de Sigma n'est pas une activité salariée";
  public static final String CODE_ERR_LIQ_ASU_CAPITAL_PRECEDENT_SP = "LIQ_ASU_PRECEDENT_SP";
  private static final String LIB_ERR_LIQ_ASU_CAPITAL_PRECEDENT_SP = "Le Capital OD courante ne doit pas etre nul";
  public static final String CODE_ERR_LIQ_ASU_COMPETENCE_ADMINISTRATIVE = "LIQ_ASU_COMP_ADMIN";
  private static final String LIB_ERR_LIQ_ASU_COMPETENCE_ADMINISTRATIVE = "La compétence Administrative ne doit pas etre nulle";
  public static final String CODE_ERR_LIQ_ASU_COMPETENCE_FINANCIERE = "LIQ_ASU_COMP_FIN";
  private static final String LIB_ERR_LIQ_ASU_COMPETENCE_FINANCIERE = "La compétence Financière ne doit pas etre nulle";
  public static final String CODE_ERR_LIQ_ASU_NUMERO_GESTION_EMPLOYEUR = "LIQ_ASU_NUM_G_EMPLOY";
  private static final String LIB_ERR_LIQ_ASU_NUMERO_GESTION_EMPLOYEUR = "Le numéro de gestion employeur ne doit pas etre nul";
  public static final String CODE_ERR_LIQ_SOL_SITUATION_FAM = "LIQ_SOL_SITUA_FAM";
  private static final String LIB_ERR_LIQ_SOL_SITUATION_FAM = "La situation familiale est incohérente";
  public static final String CODE_ERR_LIQ_SOL_PARAM_INDEM_RESSOURCES = "LIQ_SOL_PARAM_RESS";
  private static final String LIB_ERR_LIQ_SOL_PARAM_INDEM_RESSOURCES = "Il n'existe pas de plancher/plafond de ressources pour la date d'examen";
  public static final String CODE_ERR_LIQ_SOL_MOTIF_REJET = "LIQ_SOL_MOTIF_REJET";
  private static final String LIB_ERR_LIQ_SOL_MOTIF_REJET = "Le motif de rejet est incohérent";
  public static final String CODE_ERR_LIQ_SOL_MONTANT_BRUT = "LIQ_SOL_MONTANT_BRUT";
  private static final String LIB_ERR_LIQ_SOL_MONTANT_BRUT = "Le montant brut ne doit pas etre nul";
  public static final String CODE_ERR_LIQ_SOL_RESSOURCES_MENSUELLES = "LIQ_SOL_RESS_MENSU";
  private static final String LIB_ERR_LIQ_SOL_RESSOURCES_MENSUELLES = "Les ressources mensuelles ne doivent pas etre nulles";
  public static final String CODE_ERR_LIQ_SOL_DATE_PRR_RESSOURCES = "LIQ_SOL_DATE_PRR";
  private static final String LIB_ERR_LIQ_SOL_DATE_PRR_RESSOURCES = "La date de fin de la Période de Référence des Ressources est nulle";
  public static final String CODE_ERR_LIQ_SOL_RESSOURCES_JOUR_COUPLE = "LIQ_SOL_RESS_COUPLE";
  private static final String LIB_ERR_LIQ_SOL_RESSOURCES_JOUR_COUPLE = "Les ressources journalières couple ne doivent pas etre nulles";
  public static final String CODE_ERR_LIQ_SOL_RESSOURCES_JOUR_INDIV = "LIQ_SOL_RESS_INDIV";
  private static final String LIB_ERR_LIQ_SOL_RESSOURCES_JOUR_INDIV = "Les ressources journalières individuelle ne doivent pas etre nulles";
  public static final String CODE_ERR_LIQ_SOL_QTE_ACTIVITE_ACQUISE = "LIQ_SOL_QTE_ACTIVITE";
  private static final String LIB_ERR_LIQ_SOL_QTE_ACTIVITE_ACQUISE = "La quantité d'activité acquise ne doit pas etre nulle";
  public static final String CODE_ERR_LIQ_SOL_UNITE_QTE_ACTIVITE_ACQUISE = "LIQ_SOL_UNITE_ACTIV";
  private static final String LIB_ERR_LIQ_SOL_UNITE_QTE_ACTIVITE_ACQUISE = "L'unité de la quantité d'activité appartenance est nulle ou inconnue";
  public static final String CODE_ERR_LIQ_SOL_CATEGORIE_PARTICULIERE = "LIQ_SOL_CAT_PART";
  private static final String LIB_ERR_LIQ_SOL_CATEGORIE_PARTICULIERE = "La catégorie particulière est nulle ou inconnue";
  public static final String CODE_ERR_LIQ_SOL_DUREE_INDEMNISATION = "LIQ_SOL_DUREE_INDEM";
  private static final String LIB_ERR_LIQ_SOL_DUREE_INDEMNISATION = "La durée d'indemnisation ne doit pas etre nulle";
  public static final String CODE_ERR_LIQ_SOL_DUREE_INDEMNISATION_TROP_GRANDE = "LIQ_SOL_DUREE_IMP";
  private static final String LIB_ERR_LIQ_SOL_DUREE_INDEMNISATION_TROP_GRANDE = "La durée d'indemnisation est trop importante";
  public static final String CODE_ERR_LIQ_SOL_LIEN_DEMANDE_PRECEDENTE = "LIQ_SOL_DEM_PREC";
  private static final String LIB_ERR_LIQ_SOL_LIEN_DEMANDE_PRECEDENTE = "Impossible de déterminer le lien vers l'atribution précédente";
  public static final String CODE_ERR_LIQ_SOL_PARAM_RESS_INTROUVABLES_A_DATE = "LIQ_SOL_RESS_INTROUV";
  public static final String LIB_ERR_LIQ_SOL_PARAM_RESS_INTROUVABLES_A_DATE = "Impossible de trouver les paramètres de ressources actifs au ";
  public static final String CODE_ERR_SOL_CATEGORIE_DEMANDEUR = "SOL_CAT_DEMANDEUR";
  public static final String LIB_ERR_SOL_CATEGORIE_DEMANDEUR = "La catégorie du demandeur n'est pas fournie ";
  public static final String CODE_ERR_LIQ_FOR_DUREE_INDEMNISATION_MAX = "LIQ_FOR_DUREE_INDEM";
  private static final String LIB_ERR_LIQ_FOR_DUREE_INDEMNISATION_MAX = "La Durée d'indemnisation maximale ne doit pas etre nulle";
  public static final String CODE_ERR_LIQ_FOR_MONTANT_BRUT = "LIQ_FOR_MONTANT_BRUT";
  private static final String LIB_ERR_LIQ_FOR_MONTANT_BRUT = "Le Montant brut ne doit pas etre nul";
  public static final String CODE_ERR_LIQ_FOR_ID_ACTION_FORMATION = "LIQ_FOR_ID_ACT_FORM";
  private static final String LIB_ERR_LIQ_FOR_ID_ACTION_FORMATION = "L'identifiant de l'action de formation ne doit pas etre nul";
  public static final String CODE_ERR_LIQ_FOR_ID_ACTION_FORMATION_INCONNU = "LIQ_FOR_ID_ACT_FORM";
  private static final String LIB_ERR_LIQ_FOR_ID_ACTION_FORMATION_INCONNU = "L'identifiant de l'action de formation ne correspond à aucune période dans le domaine Gaec";
  public static final String CODE_ERR_LIQ_FOR_ID_REF_EXTERNE_DEMANDE_ASU_NULLE = "LIQ_FOR_ID_DEM_ASU_N";
  private static final String LIB_ERR_LIQ_FOR_ID_REF_EXTERNE_DEMANDE_ASU_NULLE = "La référence externe (demande formation liée à une demande d'assurance) ne doit pas être nulle";
  public static final String CODE_ERR_LIQ_FOR_ID_REF_EXTERNE_DEMANDE_ASU = "LIQ_FOR_ID_DEM_ASU";
  private static final String LIB_ERR_LIQ_FOR_ID_REF_EXTERNE_DEMANDE_ASU = "La référence externe (demande formation liée à une demande d'assurance) ne correspond à aucune demande d'assurance installée";
  
  static
  {
    s_libellesErreursMigration.put("LIQ_HG_TYPE_EXAMEN", "Type examen de la demande incohérent");
    s_libellesErreursMigration.put("LIQ_HG_CODE_PRODUIT", "Code produit incohérent");
    s_libellesErreursMigration.put("LIQ_HG_DATE_DEPOT", "Date de dépôt nulle");
    s_libellesErreursMigration.put("LIQ_HG_ID_PEC", "Identifiant de la Pec nul");
    s_libellesErreursMigration.put("LIQ_HG_RANG_DAL", "Rang de la Dal nul");
    s_libellesErreursMigration.put("LIQ_HG_ORIGINE_DAL", "Code origine de la dal nul");
    s_libellesErreursMigration.put("LIQ_HG_CLASS_ADM", "Classement administratif incohérent");
    s_libellesErreursMigration.put("LIQ_HG_EVT_REF_EXAM", "Evénement référence examen incohérent");
    s_libellesErreursMigration.put("LIQ_HG_EVT_DATE_EXAM", "L'événement référence examen ne peux pas etre construit car la date d'examen est nulle");
    s_libellesErreursMigration.put("LIQ_HG_OBJECT_DECIS", "Objectif décision incohérent");
    s_libellesErreursMigration.put("LIQ_HG_REF_DECISION", "Référence de la décision nulle");
    s_libellesErreursMigration.put("LIQ_HG_DATE_ATTRIB", "Date d'attribution nulle");
    s_libellesErreursMigration.put("LIQ_HG_PJI", "Pji nul");
    s_libellesErreursMigration.put("LIQ_ASU_DATE_VALID", "Date de dernière validation est nulle");
    s_libellesErreursMigration.put("LIQ_HG_DEMANDE_OK", "La demande a été migrée correctement");
    s_libellesErreursMigration.put("LIQ_HG_DEMANDE_DE", "Erreur lors du rattachement de la demande à l'individu");
    s_libellesErreursMigration.put("LIQ_HG_POST_TRAIT", "Erreur lors de l'appel au post traitement");
    s_libellesErreursMigration.put("LIQ_HG_ALIM_B_PIVOT", "Erreur lors de l'alimentation de la base pivot");
    s_libellesErreursMigration.put("LIQ_HG_INSTALL_DEM", "Une erreur est survenue lors de l'installation de la demande");
    s_libellesErreursMigration.put("CAL_HG_CAL_NUL", "Le calendrier Sigma est nul");
    s_libellesErreursMigration.put("CAL_NB_UT_DIFF", "Nombre d'UT différent : ");
    s_libellesErreursMigration.put("CAL_PJI_DIFF", "Le PJI entre Sigma et Calcul et différent");
    
    s_libellesErreursMigration.put("CAL_ECART_DJI_MIGRATION_DJI", "Ecart de type DJI en migration simplifiée");
    
    s_libellesErreursMigration.put("LIQ_DEM_ORIG_INCONNU", "La demande d'origine n'a pas été trouvé donc elle n'a pu etre rattachée à cette demande");
    s_libellesErreursMigration.put("LIQ_REF_EXT_DEMANDE", "La référence externe de la demande ne doit pas être nulle.");
    s_libellesErreursMigration.put("LIQ_ASU_MT_P_INVAL", "Montant de la pension invalidité nulle");
    s_libellesErreursMigration.put("LIQ_ASU_COEF_AVT_V", "Coefficient avantage vieillesse nul");
    s_libellesErreursMigration.put("LIQ_ASU_ID_PERIO_FGD", "Identifiant de la période de Fgd est null. Impossible de déterminer la date et le motif du Fgd");
    s_libellesErreursMigration.put("LIQ_ASU_PERIO_FGD", "La Période Fgd est inconnu chez Gaec. Impossible de déterminer la date et le motif du Fgd");
    s_libellesErreursMigration.put("LIQ_ASU_MOTIF_REJET", "Motif de rejet incohérent");
    s_libellesErreursMigration.put("LIQ_ASU_DELAIS_PJI", "Le lendemain du terme des carences ne coincide pas avec le Pji");
    s_libellesErreursMigration.put("LIQ_ASU_NB_JOURS_ACT", "Le nombre de jours d'activité pour l'édition du Courrier Ass est nul");
    s_libellesErreursMigration.put("LIQ_ASU_EMPLOI_A2B", "Le code emploi (Annexe A2b) n'a pas pu être déterminé");
    
    s_libellesErreursMigration.put("LIQ_ASU_NBH_PLAFONNE", "Le nombre d'heures travaillées plafonné n'a pas pu être déterminé");
    s_libellesErreursMigration.put("LIQ_ASU_NBH_ETENDU", "Le nombre d'heures travaillées étendu n'a pas pu être déterminé");
    s_libellesErreursMigration.put("LIQ_ASU_PRC", "La PRC n'a pas pu être déterminé");
    s_libellesErreursMigration.put("LIQ_ASU_NBJ_EMPLOI", "Le nombre de jours d'emploi n'a pas pu être déterminé");
    
    s_libellesErreursMigration.put("LIQ_ASU_DUREE_THEOR", "Durée théorique nulle");
    s_libellesErreursMigration.put("LIQ_ASU_DUREE_EFFECT", "Durée effective nulle");
    s_libellesErreursMigration.put("LIQ_ASU_DUREE_RNV", "Durée de renouvellement nulle");
    s_libellesErreursMigration.put("LIQ_ASU_DEBUT_SJRI", "Date de début du Sjr Initial du droit courant nulle");
    s_libellesErreursMigration.put("LIQ_ASU_FIN_SJRI", "Date de fin du Sjr Initial du droit courant nulle");
    s_libellesErreursMigration.put("LIQ_ASU_MT_SJRI", "Montant du SJRI nul");
    s_libellesErreursMigration.put("LIQ_ASU_MT_SJRRP", "Montant du SJRRP nul");
    s_libellesErreursMigration.put("LIQ_ASU_DIV_SJRI", "Diviseur du SJRI nul");
    s_libellesErreursMigration.put("LIQ_ASU_MONTANT_SJCI", "Montant du sjci nul");
    s_libellesErreursMigration.put("LIQ_ASU_DATE_SJCI", "Date d'effet du sjci nulle");
    s_libellesErreursMigration.put("LIQ_ASU_PERIODES_SJC", "Aucune période en activité conservée n'a pu etre trouvée sur ce droit");
    s_libellesErreursMigration.put("LIQ_ASU_CAPITAL_DC", "Capital de l'OD courante nul");
    
    s_libellesErreursMigration.put("LIQ_ASU_MT_SJRIP", "Montant du SJRIP nul");
    
    s_libellesErreursMigration.put("LIQ_ASU_DUREE_T_DR", "Durée théorique du droit retenu nulle");
    s_libellesErreursMigration.put("LIQ_ASU_DUREE_E_DR", "Durée effective du droit retenu nulle");
    s_libellesErreursMigration.put("LIQ_ASU_DUREE_RNV_DR", "Durée de renouvellement du droit retenu nulle");
    s_libellesErreursMigration.put("LIQ_ASU_CAPITAL_DP", "Capital de l'OD précédente nul");
    s_libellesErreursMigration.put("LIQ_ASU_MT_SJRI_DR", "Montant du Sjr Initial du droit courant nul");
    s_libellesErreursMigration.put("LIQ_ASU_FIN_SJRI_DR", "Date de fin du Sjr Initial du droit retenu nulle");
    s_libellesErreursMigration.put("LIQ_ASU_SJRRP_DR", "Le Sjrrp ne peut pas etre revalorisé");
    s_libellesErreursMigration.put("LIQ_ASU_QTE_AFFI_1", "Quantité d'affiliation 1 est nulle");
    s_libellesErreursMigration.put("LIQ_ASU_UNITE_AFFI_1", "L'unité de la quantité d'affiliation 1 est nulle ou inconnue");
    s_libellesErreursMigration.put("LIQ_ASU_UNITE_AFFI_1", "L'unité de la quantité d'affiliation 1 est inconnue");
    s_libellesErreursMigration.put("LIQ_ASU_QTE_AFFI_2", "Quantité d'affiliation 2 est nulle");
    s_libellesErreursMigration.put("LIQ_ASU_UNITE_AFFI_2", "L'unité de la quantité d'affiliation 2 est nulle ou inconnue");
    s_libellesErreursMigration.put("LIQ_ASU_UNITE_AFFI_2", "L'unité de la quantité d'affiliation 2 est inconnue");
    s_libellesErreursMigration.put("LIQ_ASU_MONTANT_BRUT", "Le montant brut est nul");
    s_libellesErreursMigration.put("LIQ_ASU_MT_BRUT_DP", "Le montant brut du droit précédent est nul");
    s_libellesErreursMigration.put("LIQ_ASU_ID_ADMISSION", "La référence externe Sigma d'admission est nulle (RSOD)");
    s_libellesErreursMigration.put("LIQ_ASU_ID_REPRISE", "La référence externe Sigma de reprise est nulle (RSRP)");
    s_libellesErreursMigration.put("LIQ_ASU_NB_JRS_DIFF", "Le nombre de jours du différé ne doit pas etre nul");
    s_libellesErreursMigration.put("LIQ_ASU_DEBUT_DIFF", "La date de début du différé ne doit pas etre nulle");
    s_libellesErreursMigration.put("LIQ_ASU_FIN_DIFFERE", "La date de fin du différé ne doit pas etre nulle");
    s_libellesErreursMigration.put("LIQ_ASU_NB_JRS_ICCP", "Le nombre de jours de la carence ICCP ne doit pas etre nul");
    s_libellesErreursMigration.put("LIQ_ASU_DEBUT_ICCP", "La date de début de la carence ICCP ne doit pas etre nulle");
    s_libellesErreursMigration.put("LIQ_ASU_FIN_ICCP", "La date de fin de la carence ICCP ne doit pas etre nulle");
    s_libellesErreursMigration.put("LIQ_ASU_NB_JRS_ISLR", "Le nombre de jours de la carence ISLR ne doit pas etre nul");
    s_libellesErreursMigration.put("LIQ_ASU_DEBUT_ISLR", "La date de début de la carence ISLR ne doit pas etre nulle");
    s_libellesErreursMigration.put("LIQ_ASU_FIN_ISLR", "La date de fin de la carence ISLR ne doit pas etre nulle");
    s_libellesErreursMigration.put("LIQ_ASU_NB_JOURS_PMC", "Le nombre de jours de la carence PMC ne doit pas etre nul");
    s_libellesErreursMigration.put("LIQ_ASU_DEBUT_PMC", "La date de début de la carence PMC ne doit pas etre nulle");
    s_libellesErreursMigration.put("LIQ_ASU_FIN_PMC", "La date de fin de la carence PMC ne doit pas etre nulle");
    s_libellesErreursMigration.put("LIQ_ASU_NBJ_DIFF_STD", "Le nombre de jours du différé standard ne doit pas etre nul");
    s_libellesErreursMigration.put("LIQ_ASU_DEB_DIFF_STD", "La date de début du différé standard ne doit pas etre nulle");
    s_libellesErreursMigration.put("LIQ_ASU_FIN_DIFF_STD", "La date de fin du différé standard ne doit pas etre nulle");
    s_libellesErreursMigration.put("LIQ_ASU_ARTICLE3", "L' Article 3 ne doit pas etre nul");
    s_libellesErreursMigration.put("LIQ_ASU_RA", "Le réglement applicable nul ou incohérent");
    s_libellesErreursMigration.put("LIQ_ASU_COEF_TPS_P", "Le coefficient temps partiel ne doit pas etre nul");
    s_libellesErreursMigration.put("LIQ_ASU_COEF_SAIS", "Le coefficient saisonnier ne doit pas etre nul");
    s_libellesErreursMigration.put("LIQ_ASU_TYPE_CARAC_S", "Le type du caractère saisonnier est incohérent");
    s_libellesErreursMigration.put("LIQ_ASU_PERIO_VALID", "La période de validation produit ne doit pas etre nulle");
    s_libellesErreursMigration.put("LIQ_ASU_PERIO_VALID", "La période de validation produit est inconnu chez Gaec");
    s_libellesErreursMigration.put("LIQ_ASU_PER_INVALIDE", "La période Validation Produit provenant de Sigma n'est pas une activité salariée");
    s_libellesErreursMigration.put("LIQ_ASU_TYPE_PERIO", "La Période Fgd envoyée par Sigma n'est pas de type Activité Salarié");
    s_libellesErreursMigration.put("LIQ_ASU_PRECEDENT_SP", "Le Capital OD courante ne doit pas etre nul");
    s_libellesErreursMigration.put("LIQ_ASU_COMP_ADMIN", "La compétence Administrative ne doit pas etre nulle");
    s_libellesErreursMigration.put("LIQ_ASU_COMP_FIN", "La compétence Financière ne doit pas etre nulle");
    s_libellesErreursMigration.put("LIQ_ASU_NUM_G_EMPLOY", "Le numéro de gestion employeur ne doit pas etre nul");
    s_libellesErreursMigration.put("LIQ_ASU_PER_FGD", "La période FGD provenant de Sigma n'est pas une activité salariée");
    
    s_libellesErreursMigration.put("LIQ_SOL_SITUA_FAM", "La situation familiale est incohérente");
    s_libellesErreursMigration.put("LIQ_SOL_PARAM_RESS", "Il n'existe pas de plancher/plafond de ressources pour la date d'examen");
    s_libellesErreursMigration.put("LIQ_SOL_MOTIF_REJET", "Le motif de rejet est incohérent");
    s_libellesErreursMigration.put("LIQ_SOL_MONTANT_BRUT", "Le montant brut ne doit pas etre nul");
    s_libellesErreursMigration.put("LIQ_SOL_RESS_MENSU", "Les ressources mensuelles ne doivent pas etre nulles");
    s_libellesErreursMigration.put("LIQ_SOL_DATE_PRR", "La date de fin de la Période de Référence des Ressources est nulle");
    s_libellesErreursMigration.put("LIQ_SOL_RESS_COUPLE", "Les ressources journalières couple ne doivent pas etre nulles");
    s_libellesErreursMigration.put("LIQ_SOL_RESS_INDIV", "Les ressources journalières individuelle ne doivent pas etre nulles");
    s_libellesErreursMigration.put("LIQ_SOL_QTE_ACTIVITE", "La quantité d'activité acquise ne doit pas etre nulle");
    s_libellesErreursMigration.put("LIQ_SOL_UNITE_ACTIV", "L'unité de la quantité d'activité appartenance est nulle ou inconnue");
    s_libellesErreursMigration.put("LIQ_SOL_CAT_PART", "La catégorie particulière est nulle ou inconnue");
    s_libellesErreursMigration.put("LIQ_SOL_DUREE_INDEM", "La durée d'indemnisation ne doit pas etre nulle");
    s_libellesErreursMigration.put("LIQ_SOL_DUREE_IMP", "La durée d'indemnisation est trop importante");
    s_libellesErreursMigration.put("LIQ_SOL_DEM_PREC", "Impossible de déterminer le lien vers l'atribution précédente");
    s_libellesErreursMigration.put("LIQ_SOL_RESS_INTROUV", "Impossible de trouver les paramètres de ressources actifs au ");
    s_libellesErreursMigration.put("SOL_CAT_DEMANDEUR", "La catégorie du demandeur n'est pas fournie ");
    
    s_libellesErreursMigration.put("LIQ_FOR_DUREE_INDEM", "La Durée d'indemnisation maximale ne doit pas etre nulle");
    s_libellesErreursMigration.put("LIQ_FOR_MONTANT_BRUT", "Le Montant brut ne doit pas etre nul");
    s_libellesErreursMigration.put("LIQ_FOR_ID_ACT_FORM", "L'identifiant de l'action de formation ne doit pas etre nul");
    s_libellesErreursMigration.put("LIQ_FOR_ID_ACT_FORM", "L'identifiant de l'action de formation ne correspond à aucune période dans le domaine Gaec");
    s_libellesErreursMigration.put("LIQ_FOR_ID_DEM_ASU_N", "La référence externe (demande formation liée à une demande d'assurance) ne doit pas être nulle");
    s_libellesErreursMigration.put("LIQ_FOR_ID_DEM_ASU", "La référence externe (demande formation liée à une demande d'assurance) ne correspond à aucune demande d'assurance installée");
  }
}

/* Location:
 * Qualified Name:     CodesErreursMigration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */