package fr.unedic.cali.calcul.pbjc.cons;

import fr.unedic.cali.dom.pivot.Attribution;
import java.util.HashMap;
import java.util.Map;

public final class ConstantesPBJC
{
  public static final String ETAT_INDEMNISATION_AVANT = "AVANT";
  public static final String ETAT_INDEMNISATION_PENDANT = "PENDANT";
  public static final String CODE_NATURE_ABSENCE = "AB";
  public static final String CODE_NATURE_CHOMAGE_ATTESTE = "CA";
  public static final String CODE_NATURE_CHOMAGE_ET_TRAVAIL = "CT";
  public static final String CODE_NATURE_MALADIE = "MA";
  public static final String CODE_NATURE_TRAVAIL_CSP = "TO";
  public static final Map<String, String> LIB_NATURE = new HashMap();
  public static final Map<String, String> LIB_JUSTIFICATION;
  public static final Map<String, String> LIB_JUSTIFICATION_OUVERTURE;
  public static final Map<String, String> LIB_JUSTIFICATION_FERMETURE;
  public static final String OUVERTURE_ADMISSION_OD = "BB";
  public static final String OUVERTURE_DEPART_REPRISE = "BO";
  public static final String OUVERTURE_REPRISE = "BP";
  public static final String OUVERTURE_INTERRUPTION_DATE_EFF_APE = "FS";
  public static final String OUVERTURE_REPRISE_SUITE_PERIODE_APE = "FT";
  public static final String OUVERTURE_EN_COURS_APE = "FU";
  public static final String OUVERTURE_CES_DECAL_AR_SELON_SMIC = "GR";
  public static final String OUVERTURE_INT_AR_PP_POP_EXCLUE = "GU";
  public static final String OUVERTURE_INT_AR_PP_ETAT_INDEM = "GV";
  public static final String OUVERTURE_INT_AR_PP_RECUP_PP = "GW";
  public static final String OUVERTURE_INT_AR_MOIS_INCOM_BLOQ = "G1";
  public static final String OUVERTURE_ABSENCE_JUSTIFICATION = "G9";
  public static final String OUVERTURE_INTERRUPTION_POINTAGE = "HD";
  public static final String OUVERTURE_CHGT_PARAMETRE = "DH";
  public static final String OUVERTURE_READMISSION_OD = "BG";
  public static final String OUVERTURE_REVISION = "CX";
  public static final String OUVERTURE_OD_SUITE_ASR = "BV";
  public static final String OUVERTURE_INT_AR_PLAFOND_MENSUEL_REMUNERATION = "GH";
  public static final String OUVERTURE_AR_MONTANT_MENSUEL_REDUIT = "EU";
  public static final String OUVERTURE_CARENCE_CP = "AD";
  public static final String OUVERTURE_CARENCE_ISLR = "AE";
  public static final String OUVERTURE_CARENCE_SPECTACLE_ISLR = "AG";
  public static final String OUVERTURE_DIFFERE = "AF";
  public static final String OUVERTURE_FRANCHISE_CP = "AM";
  public static final String OUVERTURE_FRANCHISE_SALAIRE = "AS";
  public static final String OUVERTURE_PND_SANCTION_DROIT = "AI";
  public static final String OUVERTURE_ADMISSION_PJI = "BD";
  public static final String OUVERTURE_READMISSION_PJI = "BH";
  public static final String OUVERTURE_MAINTIEN_JUSQU_A_RETRAITE = "B1";
  public static final String OUVERTURE_ADMISSION_PARE_ANTICIPE = "CA";
  public static final String OUVERTURE_ADMISSION_AREF_PARE_ANTICIPE = "CB";
  public static final String OUVERTURE_AV_CHGT_TAUX = "DF";
  public static final String OUVERTURE_CHGT_TAUX_NOUVEL_AV = "DG";
  public static final String OUVERTURE_AV_AVANT_1_10_94 = "DI";
  public static final String OUVERTURE_AV_APRES_1_10_94 = "DJ";
  public static final String OUVERTURE_SUSP_CONSERV_TRANS = "EC";
  public static final String OUVERTURE_SUSP_DDTE_AVEC_IMPUT = "EG";
  public static final String OUVERTURE_SUSP_DDTE_SANS_IMPUT = "EH";
  public static final String OUVERTURE_SUSP_DDTE_AVEC_IMPUT_122J = "EI";
  public static final String OUVERTURE_SUSP_DDTE_SANS_IMPUT_122J = "EJ";
  public static final String OUVERTURE_SUSP_DOUBLE_INDEMN_IMPUT = "EN";
  public static final String OUVERTURE_SUSP_DOUBLE_INDEMN_NON_IMPUT = "EO";
  public static final String OUVERTURE_SUSP_20_POURCENT = "ES";
  public static final String OUVERTURE_SUSP_50_POURCENT = "ET";
  public static final String OUVERTURE_REPRISE_RAC_APRES_AFR_AREF = "E2";
  public static final String OUVERTURE_REPRISE_APRES_RPS = "E6";
  public static final String OUVERTURE_INTERRUPTION_DATE_EFF_PI = "FM";
  public static final String OUVERTURE_PI_COND_CUMUL_NON_REMPLIE = "FN";
  public static final String OUVERTURE_REPRISE_PI_MODIF_PENSION = "FO";
  public static final String OUVERTURE_REPRISE_PI_MODIF_ALLOCATION = "FP";
  public static final String OUVERTURE_PI_DATE_EFFET = "FR";
  public static final String OUVERTURE_AR_ASU_PLAFOND_HORAIRE = "GC";
  public static final String OUVERTURE_AR_ASU_PLAFOND_GAIN = "GD";
  public static final String OUVERTURE_AR_ASU_MEME_EMPLOYEUR = "GE";
  public static final String OUVERTURE_AR_ASU_CUMUL_ATTEINT = "G7";
  public static final String OUVERTURE_CES_DEPAS_PLAF_AR_SIMU = "G8";
  public static final String OUVERTURE_PT_BLOQUE_SUP_40H_FORMATION = "HC";
  public static final String CODE_SOUS_PRODUIT_ETAT = "ET";
  public static final String CODE_SOUS_PRODUIT_RAC = "PE";
  public static final String CODE_SOUS_PRODUIT_PRIME_SEULE = "CE";
  public static final String OUVERTURE_DEBUT_CARENCE_FRANCHISE = "AH";
  public static final String OUVERTURE_ENTREE_STAGE_ALLOC_FS = "E3";
  public static final String OUVERTURE_REVALORISATION = "CD";
  public static final String OUVERTURE_INTERRUPTION_NOUV_RESSOURCE = "FD";
  public static final String OUVERTURE_NOUV_RESSOURCE_MEME_TX = "DA";
  public static final String OUVERTURE_CHGT_TX_NOUV_RESSOURCE = "DD";
  public static final String OUVERTURE_AR_SOL_CUMUL_ATTEINT = "GJ";
  public static final String OUVERTURE_ENTREE_FORMATION_ASSF = "E4";
  public static final String OUVERTURE_ADMISSION_AER = "C1";
  public static final String OUVERTURE_RENOUVELLEMENT_AER = "C2";
  public static final String OUVERTURE_ENTREE_FORMATION_AER_RF = "E7";
  public static final String OUVERTURE_PREMIER_PAIEMENT_AERC = "C3";
  public static final String OUVERTURE_1ER_PAIEMENT_AER_SUITE_RMI = "C4";
  public static final String OUVERTURE_PREMIER_PAIEMENT_AERR = "C7";
  public static final String OUVERTURE_ADMIN_AFR_NOUV_PLAN = "BA";
  public static final String OUVERTURE_AR_SOL_CUMUL_DEJA_ATTEINT = "GK";
  public static final String OUVERTURE_ADMISSION_AREF = "BF";
  public static final String OUVERTURE_PT_DEPART_AFFS_SUITE_RAC = "BJ";
  public static final String OUVERTURE_PT_DEPART_AFDEF_SUITE_SP = "E0";
  public static final String OUVERTURE_DEPART_AFFS_SUR_ASS = "BK";
  public static final String OUVERTURE_ADMISSION_RPS = "BC";
  public static final String OUVERTURE_RPS_CHGT_18_ANS_PRIMO_DE = "D0";
  public static final String OUVERTURE_RPS_CHGT_POPULATION = "D3";
  public static final String OUVERTURE_ENTREE_STAGE_RPS = "E5";
  public static final String OUVERTURE_EN_COURS_STAGE_RPS = "G3";
  public static final String OUVERTURE_RPS_CHGT_TX_INDEMNITE = "DY";
  public static final String OUVERTURE_RPS_CHGT_MOIS_CIVIL = "DZ";
  public static final String OUVERTURE_REPRISE_APRES_CONTRAT_AIDE = "FJ";
  public static final String FERMETURE_RESSOURCES_SUPERIEURES_PLAFOND = "QZ";
  public static final String OUVERTURE_REACTIVATION_NOUVELLES_RESSOURCES = "DB";
  public static final String FERMETURE_RESSOURCES_NON_PRESENTES = "QS";
  public static final String OUVERTURE_CHANGEMENT_TRANCHE = "DP";
  public static final String OUVERTURE_DROIT_ADR = "E8";
  public static final String OUVERTURE_PJI_MAINTIEN_UE = "CY";
  public static final String OUVERTURE_IDE_MAINTIEN_UE = "E9";
  public static final String OUVERTURE_SUSP_TRAVAIL = "HP";
  public static final String OUVERTURE_SUSP_TRAVAIL_CSP = "HB";
  public static final String OUVERTURE_SUSP_CONTRAT_SERVICE_CIVIQUE = "I1";
  public static final String OUVERTURE_INDEMNISATION_POURSUITE = "I2";
  public static final String OUVERTURE_REPRISE_CONTEXTE_DRV = "FE";
  public static final String ATTEINTE_SEUIL_3_MOIS_NI = "SW";
  public static final String EXAMEN_DRV_ABSENTE = "GY";
  public static final String OUVERTURE_SUSP_ISLR = "EV";
  public static final String FERMETURE_PERIODE_PND = "AL";
  public static final String FERMETURE_FIN_PER_SANS_JUSTIF = "HA";
  public static final String FERMETURE_FRANCHISE_CP = "MM";
  public static final String FERMETURE_FRANCHISE_SALAIRE = "HS";
  public static final String FERMETURE_FIN_DE_CARENCE_IND_RUP = "ME";
  public static final String FERMETURE_FIN_DE_CARENCE_IND_RUP_SPECTACLE = "MG";
  public static final String FERMETURE_FIN_DE_DIFFERE = "MF";
  public static final String FERMETURE_FIN_CARENCE_FRANCHISE = "MH";
  public static final String FERMETURE_FIN_DE_CARENCE_PREFIXE = "MP";
  public static final String FERMETURE_DUREE_MAX_ATTEINTE = "ND";
  public static final String FERMETURE_RENOUVELLEMENT_182J_EFFECTUE = "NU";
  public static final String FERMETURE_RENOUVELLEMENT_182J_A_EFFECTUER = "NV";
  public static final String FERMETURE_DATE_RETRAITE_ATTEINTE = "OD";
  public static final String FERMETURE_RETRAITE_ANTICIPE_CARRIERE_LONGUE = "OT";
  public static final String FERMETURE_RETRAITE_ANTICIPE_PENIBILITE = "OU";
  public static final String FERMETURE_RETRAITE_ANTICIPE_AMIANTE = "OV";
  public static final String FERMETURE_RETRAITE_ANTICIPE_TRAVAILLEURS_HANDICAPES = "OW";
  public static final String FERMETURE_RETRAITE_ANTICIPE_INCAPACITE_PERMATENTE = "OX";
  public static final String FERMETURE_FIN_SUITE_NOUVEAUX_DROITS = "OE";
  public static final String FERMETURE_FIN_DUREE_RENOUVELLEMENT_ASS_ET_ATA = "QR";
  public static final String FERMETURE_FIN_PERIODE_AER = "QT";
  public static final String FERMETURE_ARRET_PEC = "TD";
  public static final String FERMETURE_SORTIE_STAGE_AREF = "TH";
  public static final String FERMETURE_DECISION_EXCLU_DEFINITIVE_DDTE = "SI";
  public static final String FERMETURE_DECISION_EXCLU_DEFINITIVE_DDTE_122J = "SJ";
  public static final String FERMETURE_DECISION_SUSP_DDTE = "SG";
  public static final String FERMETURE_DECISION_SUSP_DDTE_122J = "SH";
  public static final String FERMETURE_DECISION_SUSP_DOUBLE_INDEM_IMPUT = "SN";
  public static final String FERMETURE_DECISION_SUSP_DOUBLE_INDEM = "SO";
  public static final String FERMETURE_DECISION_SANCTION_MONTANT = "SS";
  public static final String FERMETURE_DATE_LIMITE_INDEMNISATION = "OM";
  public static final String FERMETURE_BLOC_PENSION_INVALID_DSM = "HH";
  public static final String FERMETURE_BLOC_PENSION_RETRAITE_DSM = "HI";
  public static final String FERMETURE_BLOC_ARRET_RECH_EMPL_DSM = "HJ";
  public static final String FERMETURE_BLOC_MATERNITE = "HK";
  public static final String FERMETURE_BLOC_MULTIDECLARATION_DSM = "HL";
  public static final String FERMETURE_PT_BLOQUE_SUP_40H_FORMATION = "HM";
  public static final String FERMETURE_MOTIF_BLOC_DIVERS = "HN";
  public static final String FERMETURE_BLOC_ACTUALISATION_ADE = "HO";
  public static final String FERMETURE_BLOC_INFO_DECES_CNAV = "HQ";
  public static final String FERMETURE_FIN_FORMATION_RIDE = "HR";
  public static final String FERMETURE_PENSION_INVALIDITE = "QF";
  public static final String FERMETURE_FIN_SUITE_A_DECES = "OH";
  public static final String FERMETURE_FIN_ARE_EN_AREF = "NI";
  public static final String FERMETURE_FIN_AFF_PAR_FIN_FORMATION = "TI";
  public static final String FERMETURE_FIN_FORMATION_ASSF = "TJ";
  public static final String FERMETURE_REJET_DV_SUR_DEM_EXPRESSE = "ST";
  public static final String FERMETURE_REJET_DV = "NX";
  public static final String FERMETURE_AE_DV = "HX";
  public static final String FERMETURE_REJET_SUR_REVISION = "NY";
  public static final String FERMETURE_ENTREE_CONTRAT_AIDE = "RE";
  public static final String FERMETURE_DECISION_DDTE_NON_MAINTIEN_ASS_ET_ATA = "QL";
  public static final String FERMETURE_DECISION_PRISE_EN_CHARGE_DEFINITIVE_DEMANDE_ASILE = "QU";
  public static final String FERMETURE_DECISION_DESISTEMENT_DEMANDE_ASILE_OU_PROTECTION = "QV";
  public static final String FERMETURE_DECISION_PRISE_EN_CHARGE_CENTRE_D_ACCUEIL = "QW";
  public static final String FERMETURE_DECISION_REFUS_PRISE_EN_CHARGE_OFFRE_BENEFICIAIRE = "QX";
  public static final String FERMETURE_FIN_VALIDITE_TITRE_SEJOUR = "QY";
  public static final String FERMETURE_INDEMNISATION_ASR_ATP_AUE = "NF";
  public static final String FERMETURE_INDEMNISATION_PMVS = "NF";
  public static final String FERMETURE_REINT_ANTICIPE = "OA";
  public static final String FERMETURE_DISPONIBILITE = "OB";
  public static final String FERMETURE_SUSPENSION = "OC";
  public static final String ENTREE_DISPONIBILITE = "OJ";
  public static final String ENTREE_SUSPENSION = "OI";
  public static final String FERMETURE_ADR = "R8";
  public static final String FERMETURE_MAINTIEN_UE = "R9";
  public static final String FERMETURE_CONTRAT_AIDE = "RF";
  public static final String FERMETURE_DJI_FORCE_PRODUIT_BANALISE = "ON";
  public static final String FERMETURE_SUSP_CONTRAT_SERVICE_CIVIQUE = "U1";
  public static final String FERMETURE_SUSP_ISLR = "SV";
  public static final String FERMETURE_JUSTIFICATION_BAISSE_MONTANT_ASP = "Q5";
  public static final String CODE_JUSTIFICATION_MONTANT_RELEVE_PLANCHER = "01";
  public static final String CODE_JUSTIFICATION_MONTANT_RELEVE_A_ALLOC_MINI = "02";
  public static final String CODE_JUSTIFICATION_MONTANT_ABAISSE_AU_PLAFOND = "03";
  public static final String CODE_JUSTIFICATION_MONTANT_RELEVE_ALLO_MINI_AFR = "04";
  public static final String CODE_JUSTIFICATION_MONTANT_INFERIEUR_MT_SIMPLE = "07";
  public static final String CODE_JUSTIFICATION_MONTANT_RELEVE_PLANCHER_AV_DELIB_5 = "08";
  public static final String CODE_JUSTIFICATION_MONTANT_SJR_SUP_PJSS = "10";
  public static final String CODE_JUSTIFICATION_MONTANT_ABAISSE_A_MT_NET_RAC = "12";
  public static final String CODE_JUSTIFICATION_MONTANT_RELEVE_MT_CONVERSION = "13";
  public static final String CODE_JUSTIFICATION_MONTANT_CSP_80_PCTS = "14";
  public static final String CODE_JUSTIFICATION_MONTANT_CSP_80_PCTS_SANS_FINAN = "15";
  public static final String CODE_JUSTIFICATION_MONTANT_CSP_AREF_SOUS_JACENT = "16";
  public static final String CODE_JUSTIFICATION_MONTANT_ABAISSE_AU_PLAFOND_MAYOTTE = "17";
  public static final String CODE_JUSTIFICATION_MONTANT_RELEVE_PLANCHER_50_MAYOTTE = "18";
  public static final String CODE_JUSTIFICATION_MONTANT_RELEVE_PLANCHER_35_MAYOTTE = "19";
  public static final String CODE_JUSTIFICATION_MONTANT_ECRETE_PLAF_DE_RESS = "20";
  public static final String CODE_JUSTIFICATION_MONTANT_NON_ECRETE_PLAF_RESS = "21";
  public static final String CODE_JUSTIFICATION_MONTANT_RSP_TEMPS_PARTIEL = "30";
  public static final String CODE_JUSTIFICATION_MONTANT_SPE02_GENERAL = "SR";
  public static final String CODE_JUSTIFICATION_MONTANT_SPE02_AREF = "TR";
  public static final String CODE_JUSTIFICATION_MONTANT_CSP_75_PCTS = "34";
  public static final String CODE_JUSTIFICATION_MONTANT_CSP_75_PCTS_SANS_FINAN = "35";
  public static final Map<String, String> LIB_JUSTIFICATION_MONTANT;
  public static final String CODE_ETAT_REGLEMENTAIRE_DUREE_REGLEMENTAIRE = "1";
  public static final String CODE_ETAT_REGLEMENTAIRE_CARENCE = "3";
  public static final String CODE_ETAT_REGLEMENTAIRE_MAINTIEN_DES_DROITS = "5";
  public static final String CODE_ETAT_REGLEMENTAIRE_FIN_DE_DROITS = "6";
  public static final String CODE_ETAT_REGLEMENTAIRE_PREAVIS_NON_EFFECTUE = "7";
  public static final String CODE_ETAT_REGLEMENTAIRE_DIFFERE_D_INDEMNISATION = "9";
  public static final Map<String, String> LIB_ETAT_REGLEMENTAIRE;
  public static final String CODE_ETAT_ADMINISTRATIF_EN_COURS_D_OD = "1";
  public static final String CODE_ETAT_ADMINISTRATIF_EN_ATTENTE_DE_DECISION = "2";
  public static final String CODE_ETAT_ADMINISTRATIF_POST_INDEMNISATION = "3";
  public static final String CODE_ETAT_ADMINISTRATIF_EXCLUSION_TEMPORAIRE = "5";
  public static final Map<String, String> LIB_ETAT_ADMINISTRATIF;
  public static final String CODE_ETAT_PND = "N";
  public static final String CODE_MNP_DIFF_OU_CARENCE = "00";
  public static final String CODE_MNP_EXCLU_TEMP_DDTE_SANS_IMPUT_122J = "10";
  public static final String CODE_MNP_EXCLU_TEMP_DDTE_AVEC_IMPUT_122J = "11";
  public static final String CODE_MNP_EXCLU_TEMP_DDTE_SANS_IMPUT_AUTRE = "12";
  public static final String CODE_MNP_EXCLU_TEMP_DDTE_AVEC_IMPUT_AUTRE = "13";
  public static final String CODE_MNP_ATTENT_JUSTIF = "40";
  public static final String CODE_MNP_SEUIL_GAIN_AR = "41";
  public static final String CODE_MNP_SEUIL_HORAIRE_AR = "42";
  public static final String CODE_MNP_DECALAGE_POUR_AR = "43";
  public static final String CODE_MNP_PAIEMENT_ATT_REG = "57";
  public static final String CODE_MNP_DEC_NEG_DDTE_PROLONG_CUMUL_AR = "44";
  public static final String CODE_MNP_ATT_DEC_DDTE_PROLONG_CUMUL_AR = "45";
  public static final String CODE_MNP_PRESENCE_PASSS = "50";
  public static final String CODE_MNP_PRISE_EN_CHARGE_SECSOC = "60";
  public static final String CODE_MNP_SANCTION_POUR_PND = "70";
  public static final String CODE_MNP_DEP_PLAFOND_RESSOURCES = "80";
  public static final String CODE_MNP_AUTRE_MOTIF = "90";
  public static final String CODE_MNP_SANS_OBJET = "99";
  public static final Map<String, String> LIB_CODE_MOTIF_DE_NON_PAIEMENT;
  public static final String CODE_POSITION_EXONERATION_TOTALE = "T";
  public static final String CODE_POSITION_EXONERATION_PARTIELLE = "P";
  public static final String CODE_POSITION_EXONERATION_NON = "N";
  public static final Map<String, String> LIB_POSITION_EXONERATION;
  public static final String CARENCE_CONGES_PAYES = "CP";
  public static final String CARENCE_PREFIXE = "FR";
  public static final String CARENCE_ADMISSION_SUITE_DEPART_VOLONTAIRE = "DV";
  public static final String CARENCE_INDEMNITE_SUPRA_LEGALES_RUPTURE = "IR";
  public static final String FRANCHISE_CP = "FC";
  public static final String FRANCHISE_SALAIRE_A8 = "8F";
  public static final String FRANCHISE_SALAIRE_A10 = "10";
  public static final Map<String, String> LIB_CARENCES;
  public static final String MONTANT_PCRC = "PCRC";
  public static final String MONTANT_CADT = "CADT";
  public static final int COMPLEMENT_TYPE_MONTANT_SANS_OBJET = 0;
  public static final int COMPLEMENT_TYPE_MONTANT_TOP_FORMATION = 1;
  public static final int COMPLEMENT_TYPE_MONTANT_CONVENTION_P = 30;
  public static final int COMPLEMENT_TYPE_MONTANT_CONVENTION_H = 30;
  public static final int COMPLEMENT_TYPE_MONTANT_CONVENTION_C = 31;
  public static final int COMPLEMENT_TYPE_MONTANT_CONVENTION_A = 32;
  public static final int COMPLEMENT_TYPE_MONTANT_CONVENTION_C_AFAF = 34;
  public static final int COMPLEMENT_TYPE_MONTANT_CONVENTION_A_AFAF = 35;
  public static final int COMPLEMENT_TYPE_MONTANT_CONVENTION_J_AFAF = 44;
  public static final int COMPLEMENT_TYPE_MONTANT_CONVENTION_CRP_P_FTHR_OU_AFAF = 60;
  public static final int COMPLEMENT_TYPE_MONTANT_CONVENTION_CRP_H_FTHR_OU_AFAF = 60;
  public static final int COMPLEMENT_TYPE_MONTANT_CONVENTION_CRP_C_FTHR = 61;
  public static final int COMPLEMENT_TYPE_MONTANT_CONVENTION_CRP_A_FTHR = 62;
  public static final int COMPLEMENT_TYPE_MONTANT_CONVENTION_CRP_C_AFAF = 64;
  public static final int COMPLEMENT_TYPE_MONTANT_CONVENTION_CRP_A_AFAF = 65;
  public static final int COMPLEMENT_TYPE_MONTANT_CONVENTION_CRP_J_AFAF = 54;
  public static final int COMPLEMENT_TYPE_MONTANT_BENEFICIAIRE_RSA_DROIT_COMMUN_FORMATION_CONVENTIONNEE = 74;
  public static final int COMPLEMENT_TYPE_MONTANT_BENEFICIAIRE_RSA_DROIT_COMMUN_FORMATION_AFPR = 75;
  public static final int COMPLEMENT_TYPE_MONTANT_BENEFICIAIRE_RSA_DEROGATOIRE_FORMATION_CONVENTIONNEE = 84;
  public static final int COMPLEMENT_TYPE_MONTANT_BENEFICIAIRE_RSA_DEROGATOIRE_FORMATION_AFPR = 85;
  public static final int CODE_OD_REFERENCE_AFAF_SANS_PRODUIT_SUPPORT = 999;
  public static final Map<Integer, String> LIB_COMPLEMENT_TYPE_MONTANT;
  public static final Map<Integer, String> LIB_STATUT_PAIEMENT;
  public static final Map<String, String> LIB_REGLEMENT_APPLICABLE;
  public static final String CODE_RAD_REFUS_DE_SIGNATURE_PARP = "01";
  public static final String CODE_NON_PRESENTATION_A_CONVOCATION_CRP = "02";
  public static final String CODE_NON_PRESENTATION_A_UNE_ACTION_DE_RECLASSEMENT = "03";
  public static final String CODE_RAD_REFUS_OFFRE_EMPLOI_CRP = "04";
  public static final String CODE_RAD_REFUS_ACTION_RECLASSEMENT = "05";
  public static final String CODE_RAD_ABONDON_ACTION_RECLASSEMENT = "06";
  public static final String CODE_RAD_DECLARATION_INEXACTES_OU_PRESENTATION_ATTESTATIONS_MESONGERES = "07";
  public static final String CODE_RAD_REPRISE_EMPLOI_SEUL_TPS_PLEIN = "11";
  public static final String CODE_RAD_REPRISE_EMPLOI_SEUL_TPS_PARTIEL = "12";
  public static final String CODE_RAD_REPRISE_EMPLOI_SEUL_TEMP_MOINS_DE_3_MOIS = "13";
  public static final String CODE_RAD_REPRISE_EMPLOI_SEUL_TEMP_PLUS_DE_3_MOIS = "14";
  public static final String CODE_RAD_REPRISE_EMPLOI_SEUL_NON_PRECISE = "15";
  public static final String CODE_RAD_CREATION_ENTREPRISE = "16";
  public static final String CODE_RAD_FIN_CONVENTION_COOPERATION = "17";
  public static final String CODE_RAD_REPRISE_EMPLOI_PAR_AGENCE_CONTRAT_VILLE = "20";
  public static final String CODE_RAD_REPRISE_EMPLOI_PAR_AGENCE_DURABLE_TPS_PLEIN = "21";
  public static final String CODE_RAD_REPRISE_EMPLOI_PAR_AGENCE_TPS_PARTIEL = "22";
  public static final String CODE_RAD_REPRISE_EMPLOI_PAR_AGENCE_TEMP_MOINS_DE_3_MOIS = "23";
  public static final String CODE_RAD_REPRISE_EMPLOI_PAR_AGENCE_TEMP_PLUS_DE_3_MOIS = "24";
  public static final String CODE_RAD_REPRISE_EMPLOI_PAR_AGENCE_NON_PRECISE = "25";
  public static final String CODE_RAD_ENTREE_EN_CES = "26";
  public static final String CODE_RAD_REPRISE_EMPLOI_POUR_CONVENTION_COOPERATION = "28";
  public static final String CODE_RAD_ENTREE_EN_RMA = "29";
  public static final String CODE_RAD_ENTREE_EN_CONTRAT_AVENIR = "30";
  public static final String CODE_RAD_ENTREE_EN_STAGE_PAR_ANPE = "31";
  public static final String CODE_RAD_ENTREE_EN_STAGE_PAR_SES_PROPRES_MOYENS = "32";
  public static final String CODE_RAD_ENTREE_EN_AFR_AREF = "34";
  public static final String CODE_RAD_NON_CONFIRMATION_SUITE_INSCRIPTION_ASSEDIC = "35";
  public static final String CODE_RAD_ABSENCE_LIEU_RESIDENCE_SUP_A_35_JOURS = "36";
  public static final String CODE_RAD_FIN_STAGE_OU_MESURE = "41";
  public static final String CODE_RAD_ABANDON_STAGE_OU_MESURE = "42";
  public static final String CODE_RAD_FCT_TEMP_OU_CDD_CATEGORIE_5 = "43";
  public static final String CODE_RAD_SERVICE_MILITAIRE = "44";
  public static final String CODE_RAD_MALADIE_MATERNITE_ACCIDENT_DU_TRAVAIL = "45";
  public static final String CODE_RAD_CHANGEMENT_ALE_HORS_ASSEDIC = "46";
  public static final String CODE_RAD_TITRE_DE_SEJOUR_NON_VALIDE = "47";
  public static final String CODE_RAD_RETRAITE = "48";
  public static final String CODE_RAD_AUTRES_CAS = "49";
  public static final String CODE_RAD_NON_PRESENTATION_A_PREMIER_ENTRETIEN = "50";
  public static final String CODE_RAD_REFUS_EMPLOI_SUSP_1_MOIS = "51";
  public static final String CODE_RAD_REFUS_EMPLOI_SUSP_2_MOIS = "52";
  public static final String CODE_RAD_REFUS_EMPLOI_SUSP_3_MOIS = "53";
  public static final String CODE_RAD_REFUS_EMPLOI_SUSP_4_MOIS = "54";
  public static final String CODE_RAD_REFUS_EMPLOI_SUSP_5_MOIS = "55";
  public static final String CODE_RAD_REFUS_EMPLOI_SUSP_6_MOIS = "56";
  public static final String CODE_RAD_NON_PRESENTATION_A_ENTRETIEN_LUXEMBOURG = "60";
  public static final String CODE_RAD_REFUS_FORMATION_SUSP_1_MOIS = "61";
  public static final String CODE_RAD_REFUS_FORMATION_SUSP_2_MOIS = "62";
  public static final String CODE_RAD_REFUS_FORMATION_SUSP_3_MOIS = "63";
  public static final String CODE_RAD_REFUS_FORMATION_SUSP_4_MOIS = "64";
  public static final String CODE_RAD_REFUS_FORMATION_SUSP_5_MOIS = "65";
  public static final String CODE_RAD_REFUS_FORMATION_SUSP_6_MOIS = "66";
  public static final String CODE_RAD_FAUSSE_DECLARATION_SUSP_DOUZE_MOIS = "70";
  public static final String CODE_RAD_AUTRES_CAS_ARRET_RECHERCHE_EMPLOI = "71";
  public static final String CODE_RAD_DISPENSE_RECHERCHE_EMPLOI_TOUT_DECRET = "72";
  public static final String CODE_RAD_DECES = "73";
  public static final String CODE_RAD_FAUSSE_DECLARATION_SUSP_6_MOIS = "74";
  public static final String CODE_RAD_FAUSSE_DECLARATION_SUSP_7_MOIS = "75";
  public static final String CODE_RAD_FAUSSE_DECLARATION_SUSP_8_MOIS = "76";
  public static final String CODE_RAD_FAUSSE_DECLARATION_SUSP_9_MOIS = "77";
  public static final String CODE_RAD_FAUSSE_DECLARATION_SUSP_10_MOIS = "78";
  public static final String CODE_RAD_FAUSSE_DECLARATION_SUSP_11_MOIS = "79";
  public static final String CODE_RAD_MANQUE_ACTES_RECHERCHE_SUSP_1_MOIS = "81";
  public static final String CODE_RAD_MANQUE_ACTES_RECHERCHE_SUSP_2_MOIS = "82";
  public static final String CODE_RAD_MANQUE_ACTES_RECHERCHE_SUSP_3_MOIS = "83";
  public static final String CODE_RAD_MANQUE_ACTES_RECHERCHE_SUSP_4_MOIS = "84";
  public static final String CODE_RAD_MANQUE_ACTES_RECHERCHE_SUSP_5_MOIS = "85";
  public static final String CODE_RAD_MANQUE_ACTES_RECHERCHE_SUSP_6_MOIS = "86";
  public static final String CODE_RAD_ABSENCE_AU_CONTROLE_NON_REPONSE_A_DAM = "90";
  public static final String CODE_RAD_NON_REPONSE_A_CONVOC_SUSP_1_MOIS = "91";
  public static final String CODE_RAD_NON_REPONSE_A_CONVOC_SUSP_2_MOIS = "92";
  public static final String CODE_RAD_NON_REPONSE_A_CONVOC_SUSP_3_MOIS = "93";
  public static final String CODE_RAD_NON_REPONSE_A_CONVOC_SUSP_4_MOIS = "94";
  public static final String CODE_RAD_DATE_PEREMPTION_ATTEINTE_CATEGORIES_4_OU_5 = "95";
  public static final String CODE_RAD_NON_REPONSE_A_CONVOC_SUSP_5_MOIS = "96";
  public static final String CODE_RAD_NON_REPONSE_A_CONVOC_SUSP_6_MOIS = "97";
  public static final String CODE_RAD_DSM_IRRECEVABLE_NON_SIGNEE = "98";
  public static final String PI_INTERRUPTION_INDEMNISATION = "O";
  public static final String PI_NON_INTERRUPTION_INDEMNISATION = "N";
  public static final Map<String, String> LIB_TYPE_DISPOSITIF;
  public static final String CODE_SITUATION_PARTICULIERE_SECONDE_TRANCHE = "3";
  public static final Map<String, String> LIB_SITUATION_PARTICULIERE;
  public static final String CODE_PAYS_FRANCE = "000";
  public static final String CODE_PAYS_DANEMARK = "101";
  public static final String CODE_PAYS_ISLANDE = "102";
  public static final String CODE_PAYS_NORVEGE = "103";
  public static final String CODE_PAYS_SUEDE = "104";
  public static final String CODE_PAYS_FINLANDE = "105";
  public static final String CODE_PAYS_ESTONIE = "106";
  public static final String CODE_PAYS_LETTONIE = "107";
  public static final String CODE_PAYS_LITUANIE = "108";
  public static final String CODE_PAYS_ALLEMAGNE = "109";
  public static final String CODE_PAYS_AUTRICHE = "110";
  public static final String CODE_PAYS_BULGARIE = "111";
  public static final String CODE_PAYS_HONGRIE = "112";
  public static final String CODE_PAYS_LIECHTENSTEIN = "113";
  public static final String CODE_PAYS_ROUMANIE = "114";
  public static final String CODE_PAYS_REPUBLIQUE_TCHEQUE = "116";
  public static final String CODE_PAYS_SLOVAQUIE = "117";
  public static final String CODE_PAYS_BOSNIE_HERZEGOVINE = "118";
  public static final String CODE_PAYS_CROATIE = "119";
  public static final String CODE_PAYS_MONTENEGRO = "120";
  public static final String CODE_PAYS_SERBIE = "121";
  public static final String CODE_PAYS_POLOGNE = "122";
  public static final String CODE_PAYS_RUSSIE = "123";
  public static final String CODE_PAYS_ALBANIE = "125";
  public static final String CODE_PAYS_GRECE = "126";
  public static final String CODE_PAYS_ITALIE = "127";
  public static final String CODE_PAYS_SAINT_MARIN = "128";
  public static final String CODE_PAYS_VATICAN = "129";
  public static final String CODE_PAYS_ANDORRE = "130";
  public static final String CODE_PAYS_BELGIQUE = "131";
  public static final String CODE_PAYS_ROYAUME_UNI = "132";
  public static final String CODE_PAYS_GIBRALTAR = "133";
  public static final String CODE_PAYS_ESPAGNE = "134";
  public static final String CODE_PAYS_PAYS_BAS = "135";
  public static final String CODE_PAYS_IRLANDE = "136";
  public static final String CODE_PAYS_LUXEMBOURG = "137";
  public static final String CODE_PAYS_MONACO = "138";
  public static final String CODE_PAYS_PORTUGAL = "139";
  public static final String CODE_PAYS_SUISSE = "140";
  public static final String CODE_PAYS_CHYPRE = "143";
  public static final String CODE_PAYS_MALTE = "144";
  public static final String CODE_PAYS_SLOVENIE = "145";
  public static final String CODE_PAYS_BIELORUSSIE = "148";
  public static final String CODE_PAYS_MOLDAVIE = "151";
  public static final String CODE_PAYS_UKRAINE = "155";
  public static final String CODE_PAYS_MACEDOINE = "156";
  public static final String CODE_PAYS_ILES_FEROES = "157";
  public static final String CODE_PAYS_AUTRES_PAYS = "999";
  public static final Map<String, String> LIB_PAYS;
  public static final String TYPE_POPULATION_CONTEXTE_EESSI_NON_RENSEIGNE = "";
  public static final String TYPE_POPULATION_CONTEXTE_EESSI_MAINTIEN_INDEMNISATION_FRANCE = "ME";
  public static final String TYPE_POPULATION_CONTEXTE_EESSI_MAINTIEN_INDEMNISATION_EUROPE = "MO";
  public static final String TYPE_POPULATION_CONTEXTE_EESSI_DOUBLE_INSCRIPTION_FRANCE = "DI";
  public static final String TYPE_POPULATION_CONVENTION_GESTION = "CG";
  public static final String TYPE_POPULATION_SECTEUR_PUBLIC = "SP";
  public static final String TYPE_POPULATION_CSP = "CS";
  public static final String TYPE_POPULATION_ACT = "AC";
  public static final String TYPE_POPULATION_PP = "PP";
  public static final String TYPE_POPULATION_REFF18 = "RF";
  public static final String TYPE_POPULATION_CONTEXTE_MAYOTTE = "MA";
  public static final Map<String, String> LIB_TYPE_POPULATION;
  public static final String SOUS_TYPE_POPULATION_POLE_EMPLOI = "PE";
  public static final String SOUS_TYPE_POPULATION_FRAIS_REELS = "FR";
  public static final String SOUS_TYPE_POPULATION_EESSI = "";
  public static final String SOUS_TYPE_POPULATION_SECTEUR_PUBLIC = "";
  public static final String SOUS_TYPE_POPULATION_CSP = "";
  public static final String SOUS_TYPE_POPULATION_PP = "";
  public static final String SOUS_TYPE_POPULATION_RFF18 = "18";
  public static final Map<String, String> LIB_SOUS_TYPE_POPULATION;
  public static final Map<String, String> LIB_STATUT;
  public static final String NOM_GROUPE_MONTANT_IH = "RBF_IHE06_01";
  public static final String NOM_GROUPE_MONTANT_IT = "RBF_ITR05_01";
  public static final Map<String, String> LIB_RPS_RBF;
  
  static
  {
    LIB_NATURE.put("AB", "ABSENCE AU POINTAGE");
    LIB_NATURE.put("CA", "CHOMAGE ATTESTE");
    LIB_NATURE.put("CT", "CHOMAGE ET TRAVAIL");
    LIB_NATURE.put("MA", "MALADIE");
    LIB_NATURE.put("TO", "SUSP. TRAV. CSP");
    
    LIB_JUSTIFICATION = new HashMap();
    LIB_JUSTIFICATION_OUVERTURE = new HashMap();
    LIB_JUSTIFICATION_FERMETURE = new HashMap();
    
    LIB_JUSTIFICATION_OUVERTURE.put("BB", "Ouverture de droit(Admis)");
    LIB_JUSTIFICATION_OUVERTURE.put("BO", "Depart en reprise");
    LIB_JUSTIFICATION_OUVERTURE.put("BP", "Reprise (1er jour indemn)");
    LIB_JUSTIFICATION_OUVERTURE.put("FS", "Interruption date eff APE");
    LIB_JUSTIFICATION_OUVERTURE.put("FT", "Reprise suite période APE");
    LIB_JUSTIFICATION_OUVERTURE.put("FU", "En cours APE");
    LIB_JUSTIFICATION_OUVERTURE.put("GR", "CES:décal. AR selon SMIC");
    LIB_JUSTIFICATION_OUVERTURE.put("GU", "INT. AR.: PP (Pop exclue)");
    LIB_JUSTIFICATION_OUVERTURE.put("GV", "INT. AR.: PP (Etat indem,)");
    LIB_JUSTIFICATION_OUVERTURE.put("GW", "INT. AR.: PP (Récup PP)");
    LIB_JUSTIFICATION_OUVERTURE.put("G1", "INT. AR.: Mois incom bloq");
    LIB_JUSTIFICATION_OUVERTURE.put("G9", "Attente Justification");
    LIB_JUSTIFICATION_OUVERTURE.put("HD", "Interruption de pointage");
    LIB_JUSTIFICATION_OUVERTURE.put("DH", "Chgt Taux: Nouv paramètre");
    LIB_JUSTIFICATION_OUVERTURE.put("BG", "Ouverture de droit(Réadm)");
    LIB_JUSTIFICATION_OUVERTURE.put("CX", "Chgt tx:revision SJR(SJC)");
    LIB_JUSTIFICATION_OUVERTURE.put("EU", "AR montant mensuel réduit");
    
    LIB_JUSTIFICATION_OUVERTURE.put("AD", "Début de carence préfixe");
    LIB_JUSTIFICATION_OUVERTURE.put("AE", "Début de carence ind rupture");
    LIB_JUSTIFICATION_OUVERTURE.put("AF", "Début de différé");
    LIB_JUSTIFICATION_OUVERTURE.put("AM", "Début de franchise CP");
    LIB_JUSTIFICATION_OUVERTURE.put("AS", "Début de franchise Salaire");
    LIB_JUSTIFICATION_OUVERTURE.put("AG", "Début de différé spécifique spectacle");
    LIB_JUSTIFICATION_OUVERTURE.put("AI", "D35-PND- sanction droit");
    LIB_JUSTIFICATION_OUVERTURE.put("BD", "Admission (1er jr indemn)");
    LIB_JUSTIFICATION_OUVERTURE.put("BH", "Réadmission (1er j indem)");
    LIB_JUSTIFICATION_OUVERTURE.put("B1", "Maintien jusqu'a retraite");
    LIB_JUSTIFICATION_OUVERTURE.put("CA", "Admis PARE anticipé (1°J)");
    LIB_JUSTIFICATION_OUVERTURE.put("CB", "Adm.AREF PARE antic (1°J)");
    
    LIB_JUSTIFICATION_OUVERTURE.put("DF", "CHGT TX AVANTAGE VIEILLESSE");
    LIB_JUSTIFICATION_OUVERTURE.put("DG", "Chgt Taux: Nouvel A.V.");
    LIB_JUSTIFICATION_OUVERTURE.put("DI", "O93AV:d.effet D5 du 1/10/94");
    LIB_JUSTIFICATION_OUVERTURE.put("DJ", "O93Nouvel AV (D5 1/10/94)");
    
    LIB_JUSTIFICATION_OUVERTURE.put("EC", "Susp. conserv. trans DDTE");
    LIB_JUSTIFICATION_OUVERTURE.put("EG", "Susp.DDTE avec imputation");
    LIB_JUSTIFICATION_OUVERTURE.put("EH", "Susp.DDTE sans imputation");
    LIB_JUSTIFICATION_OUVERTURE.put("EI", "Susp.DDTE avec imp (122j)");
    LIB_JUSTIFICATION_OUVERTURE.put("EJ", "Susp.DDTE sans imp (122j)");
    LIB_JUSTIFICATION_OUVERTURE.put("EN", "Susp double indemn imput.");
    LIB_JUSTIFICATION_OUVERTURE.put("EO", "Susp doub indemn non impu");
    LIB_JUSTIFICATION_OUVERTURE.put("ES", "Susp 20%");
    LIB_JUSTIFICATION_OUVERTURE.put("ET", "Susp 50%");
    LIB_JUSTIFICATION_OUVERTURE.put("E2", "Rep RAC après AFR/AREF");
    LIB_JUSTIFICATION_OUVERTURE.put("E6", "Reprise après RSP");
    LIB_JUSTIFICATION_OUVERTURE.put("FM", "Interruption date eff PI");
    LIB_JUSTIFICATION_OUVERTURE.put("FN", "PI cond cumul non remplie");
    LIB_JUSTIFICATION_OUVERTURE.put("FO", "Reprise PI modif pension");
    LIB_JUSTIFICATION_OUVERTURE.put("FP", "Reprise PI modif allocati");
    LIB_JUSTIFICATION_OUVERTURE.put("FR", "PI date d'effet");
    LIB_JUSTIFICATION_OUVERTURE.put("GC", "AR ASU - Plafond horaire atteint");
    LIB_JUSTIFICATION_OUVERTURE.put("GD", "AR ASU - Plafond gain atteint");
    LIB_JUSTIFICATION_OUVERTURE.put("GE", "AR ASU - Meme employeur");
    LIB_JUSTIFICATION_OUVERTURE.put("G7", "AR ASU - Cumul 18 mois atteint");
    LIB_JUSTIFICATION_OUVERTURE.put("G8", "CES: dépas plaf AR (simu)");
    LIB_JUSTIFICATION_OUVERTURE.put("HC", "PT BLOQUE > 40H FORMATION");
    
    LIB_JUSTIFICATION_OUVERTURE.put("AH", "Debut carence franchise");
    
    LIB_JUSTIFICATION_OUVERTURE.put("E3", "Entrée en stage alloc FS");
    
    LIB_JUSTIFICATION_OUVERTURE.put("CD", "Revalorisation");
    
    LIB_JUSTIFICATION_OUVERTURE.put("FD", "Interrupt. nouv ressource");
    
    LIB_JUSTIFICATION_OUVERTURE.put("DA", "Nouv ressource: Meme taux");
    LIB_JUSTIFICATION_OUVERTURE.put("DD", "Chgt Taux: Nouv ressource");
    LIB_JUSTIFICATION_OUVERTURE.put("GJ", "INT.AR.:>12m 750h atteint");
    LIB_JUSTIFICATION_OUVERTURE.put("E4", "Entrée en formation ASS-F");
    
    LIB_JUSTIFICATION_OUVERTURE.put("C1", "Admission AER");
    LIB_JUSTIFICATION_OUVERTURE.put("C2", "Renouvellement AER");
    LIB_JUSTIFICATION_OUVERTURE.put("E7", "Entrée formation AER-RF");
    LIB_JUSTIFICATION_OUVERTURE.put("C3", "Premier paiement AER-C");
    LIB_JUSTIFICATION_OUVERTURE.put("C4", "1er paiemt AER suite RMI/RSA");
    LIB_JUSTIFICATION_OUVERTURE.put("C7", "Premier paiement AER-R");
    
    LIB_JUSTIFICATION_OUVERTURE.put("BA", "Adm AFR nouv plan (1er j)");
    LIB_JUSTIFICATION_OUVERTURE.put("GJ", "AR SOL - Cumul 750h et 13 mois atteint");
    LIB_JUSTIFICATION_OUVERTURE.put("GK", "AR SOL - Cumul 750h et plus de 13 mois");
    LIB_JUSTIFICATION_OUVERTURE.put("BF", "Adm. AFR/AREF (1er j ind)");
    
    LIB_JUSTIFICATION_OUVERTURE.put("BJ", "Ptdépart AFFS suite à RAC");
    
    LIB_JUSTIFICATION_OUVERTURE.put("E0", "1er jr AFDEF suite SP");
    
    LIB_JUSTIFICATION_OUVERTURE.put("BK", "Pt de départ AFFS sur ASS");
    
    LIB_JUSTIFICATION_OUVERTURE.put("BC", "Admission RPS (1er j ind)");
    LIB_JUSTIFICATION_OUVERTURE.put("D0", "RPS_CHGT_18_ANS_PRIMO_DE");
    LIB_JUSTIFICATION_OUVERTURE.put("D3", "RPS_CHGT POPULATION");
    LIB_JUSTIFICATION_OUVERTURE.put("E5", "Entrée en stage RPS");
    LIB_JUSTIFICATION_OUVERTURE.put("G3", "INT. AR.: En cours Stage");
    LIB_JUSTIFICATION_OUVERTURE.put("DZ", "RPS_CHGT_MOIS_CIVIL");
    LIB_JUSTIFICATION_OUVERTURE.put("DY", "RPS CHGT TX INDEMNITE");
    
    LIB_JUSTIFICATION_OUVERTURE.put("FJ", "Adm/rep apres contra aide");
    
    LIB_JUSTIFICATION_OUVERTURE.put("QZ", "Interruption suite ressources > plafond");
    LIB_JUSTIFICATION_OUVERTURE.put("DB", "Réactivation nouvelles ressources");
    LIB_JUSTIFICATION_OUVERTURE.put("QS", "Ressources non présentes");
    
    LIB_JUSTIFICATION_OUVERTURE.put("DP", "Changement de tranche");
    
    LIB_JUSTIFICATION_OUVERTURE.put("E8", "Ouverture d'un droit ADR");
    
    LIB_JUSTIFICATION_OUVERTURE.put("BV", "OD RAC suite à ASC/ASR");
    
    LIB_JUSTIFICATION_OUVERTURE.put("GH", "INT. AR.: Plaf mens remun");
    
    LIB_JUSTIFICATION_OUVERTURE.put("CY", "Maintien UE (1er jr indem)");
    LIB_JUSTIFICATION_OUVERTURE.put("E9", "Entrée période maint. UE");
    
    LIB_JUSTIFICATION_OUVERTURE.put("HP", "Susp. Travail AEPE");
    
    LIB_JUSTIFICATION_OUVERTURE.put("HB", "Susp. Travail CSP");
    LIB_JUSTIFICATION_OUVERTURE.put("I1", "Ouverture suspension contrat service civique");
    LIB_JUSTIFICATION_OUVERTURE.put("I2", "Ouverture Poursuite Indemnisation sur Antécédent Exécutable");
    LIB_JUSTIFICATION_OUVERTURE.put("SW", "Atteinte seuil 3 mois non indemnisés");
    LIB_JUSTIFICATION_OUVERTURE.put("FE", "Reprise suite examen DRV");
    LIB_JUSTIFICATION_OUVERTURE.put("GY", "INT AR: Examen DRV absente");
    
    LIB_JUSTIFICATION_OUVERTURE.put("SW", "Atteinte seuil 3 mois non indemnisés");
    
    LIB_JUSTIFICATION_OUVERTURE.put("GY", "INT AR: Examen DRV absente");
    
    LIB_JUSTIFICATION_OUVERTURE.put("EV", "Début susp. suite ISLR");
    
    LIB_JUSTIFICATION.putAll(LIB_JUSTIFICATION_OUVERTURE);
    
    LIB_JUSTIFICATION_FERMETURE.put("OA", "Susp - Réint anticipée");
    LIB_JUSTIFICATION_FERMETURE.put("OB", "Susp - Fin disponibilité");
    LIB_JUSTIFICATION_FERMETURE.put("OC", "Susp - Fin suspension");
    LIB_JUSTIFICATION_FERMETURE.put("OJ", "Susp - Entrée disponibilité");
    LIB_JUSTIFICATION_FERMETURE.put("OI", "Susp - Entrée suspension");
    LIB_JUSTIFICATION_FERMETURE.put("AL", "D35:Fin sanction droit");
    LIB_JUSTIFICATION_FERMETURE.put("HA", "Fin per sans justificatif");
    LIB_JUSTIFICATION_FERMETURE.put("MM", "Fin de franchise CP");
    LIB_JUSTIFICATION_FERMETURE.put("HS", "Fin de franchise Salaire");
    LIB_JUSTIFICATION_FERMETURE.put("ME", "Fin de carence ind. rup.");
    LIB_JUSTIFICATION_FERMETURE.put("MF", "Fin de différé");
    LIB_JUSTIFICATION_FERMETURE.put("MG", "Fin de différé spécifique spectacle");
    LIB_JUSTIFICATION_FERMETURE.put("MH", "Fin carence franchise");
    LIB_JUSTIFICATION_FERMETURE.put("MP", "Fin de carence préfixe");
    LIB_JUSTIFICATION_FERMETURE.put("ND", "Durée maximale atteinte");
    LIB_JUSTIFICATION_FERMETURE.put("NU", "Fin durée 182 jours (effectué)");
    LIB_JUSTIFICATION_FERMETURE.put("NV", "Fin durée 182 jours (a effectuer)");
    LIB_JUSTIFICATION_FERMETURE.put("OD", "Date de retraite atteinte");
    LIB_JUSTIFICATION_FERMETURE.put("OV", "RIAC Amiante");
    LIB_JUSTIFICATION_FERMETURE.put("OT", "RIAC Carrière Longue");
    LIB_JUSTIFICATION_FERMETURE.put("OX", "RIAC Incapacité Perm.");
    LIB_JUSTIFICATION_FERMETURE.put("OU", "RIAC Pénibilité");
    LIB_JUSTIFICATION_FERMETURE.put("OW", "RIAC Travail. Handicapé");
    LIB_JUSTIFICATION_FERMETURE.put("OE", "Fin suite nouveaux droits");
    LIB_JUSTIFICATION_FERMETURE.put("QR", "Fin durée renouvellement ASS ou ATA ou AEPE");
    LIB_JUSTIFICATION_FERMETURE.put("QT", "Fin de période AER");
    LIB_JUSTIFICATION_FERMETURE.put("TD", "Arrêt de prise en charge");
    LIB_JUSTIFICATION_FERMETURE.put("TH", "Sortie de stage AFR/AREF");
    LIB_JUSTIFICATION_FERMETURE.put("SI", "Exclusion définitive DDTE");
    LIB_JUSTIFICATION_FERMETURE.put("SJ", "Exclusion déf DDTE (122j)");
    LIB_JUSTIFICATION_FERMETURE.put("SG", "Fin suspension DDTE");
    LIB_JUSTIFICATION_FERMETURE.put("SH", "Fin suspension DDTE (122j)");
    LIB_JUSTIFICATION_FERMETURE.put("SN", "Fin susp double indem imp");
    LIB_JUSTIFICATION_FERMETURE.put("SO", "Fin susp. double indemnis");
    LIB_JUSTIFICATION_FERMETURE.put("SS", "Fin reduction sanction montant");
    LIB_JUSTIFICATION_FERMETURE.put("OM", "Date limite indemnisation");
    LIB_JUSTIFICATION_FERMETURE.put("HH", "Bloc pension invalid DSM");
    LIB_JUSTIFICATION_FERMETURE.put("HI", "Bloc pension retraite DSM");
    LIB_JUSTIFICATION_FERMETURE.put("HJ", "Bloc arrêt rech empl DSM");
    LIB_JUSTIFICATION_FERMETURE.put("HK", "Bloc maternité");
    LIB_JUSTIFICATION_FERMETURE.put("HL", "Bloc multidéclaration DSM");
    LIB_JUSTIFICATION_FERMETURE.put("HM", "PT bloque > 40h formation");
    LIB_JUSTIFICATION_FERMETURE.put("HN", "Motif bloc divers");
    LIB_JUSTIFICATION_FERMETURE.put("HO", "Bloc actualisation ADE");
    LIB_JUSTIFICATION_FERMETURE.put("QF", "Pension invalidité");
    LIB_JUSTIFICATION_FERMETURE.put("OH", "Fin suite a Décés");
    LIB_JUSTIFICATION_FERMETURE.put("NI", "Durée réglem AFR atteinte");
    LIB_JUSTIFICATION_FERMETURE.put("TI", "Sortie de stage alloc FS");
    LIB_JUSTIFICATION_FERMETURE.put("TJ", "Sortie de formation ASS-F");
    LIB_JUSTIFICATION_FERMETURE.put("ST", "Interrup. paiet rejet DV");
    LIB_JUSTIFICATION_FERMETURE.put("HX", "Bloc indem. pour examen DV");
    LIB_JUSTIFICATION_FERMETURE.put("NX", "Fin indem. suite rejet DV");
    LIB_JUSTIFICATION_FERMETURE.put("NY", "Fin ind. rejet sur Révision");
    LIB_JUSTIFICATION_FERMETURE.put("QL", "Non maintien DDTE à 182j");
    LIB_JUSTIFICATION_FERMETURE.put("HR", "RIDE FIN FORM.");
    
    LIB_JUSTIFICATION_FERMETURE.put("RE", "Entree en contrat aide");
    
    LIB_JUSTIFICATION_FERMETURE.put("QU", "Rejet définitif OFPRA/CRR pour une décision SUIVI");
    
    LIB_JUSTIFICATION_FERMETURE.put("QV", "Désistement demande asile pour une décision SUIVI");
    
    LIB_JUSTIFICATION_FERMETURE.put("QW", "Entrée hébergement CADA pour une décision SUIVI");
    
    LIB_JUSTIFICATION_FERMETURE.put("QX", "Refus hébergement CADA pour une décision SUIVI");
    LIB_JUSTIFICATION_FERMETURE.put("TJ", "Sortie de formation ASS-F");
    LIB_JUSTIFICATION_FERMETURE.put("QY", "Fin validité titre séjour");
    
    LIB_JUSTIFICATION_FERMETURE.put("NF", "Fin de droit");
    
    LIB_JUSTIFICATION_FERMETURE.put("R8", "Fermeture ADR");
    
    LIB_JUSTIFICATION_FERMETURE.put("R9", "Fermeture maintien UE");
    
    LIB_JUSTIFICATION_FERMETURE.put("RF", "Fermeture suite contrat aidé");
    
    LIB_JUSTIFICATION_FERMETURE.put("ON", "Fermeture DJI forcé sur produit banalisé");
    
    LIB_JUSTIFICATION_FERMETURE.put("U1", "Fermeture suspension contrat service civique");
    
    LIB_JUSTIFICATION_FERMETURE.put("SV", "Fin suspension suite ISLR");
    
    LIB_JUSTIFICATION_FERMETURE.put("Q5", "Epuisement de la duree post prime");
    
    LIB_JUSTIFICATION.putAll(LIB_JUSTIFICATION_FERMETURE);
    
    LIB_JUSTIFICATION_MONTANT = new HashMap();
    
    LIB_JUSTIFICATION_MONTANT.put("01", "RELEVE AU PLANCHER");
    LIB_JUSTIFICATION_MONTANT.put("02", "RELEVE A ALLOC MINI.");
    LIB_JUSTIFICATION_MONTANT.put("03", "ABAISSE AU PLAFOND");
    LIB_JUSTIFICATION_MONTANT.put("04", "RELEVE A ALLOC MINI AREF");
    LIB_JUSTIFICATION_MONTANT.put("07", "INFERIEUR MT SIMPLE AUD");
    LIB_JUSTIFICATION_MONTANT.put("08", "RELEVE PLANCHER AV DELIB. 5");
    LIB_JUSTIFICATION_MONTANT.put("12", "ABAISSE A MT NET RAC");
    LIB_JUSTIFICATION_MONTANT.put("13", "RELEVE MT CONVERSION");
    LIB_JUSTIFICATION_MONTANT.put("20", "ECRETE PLAF DE RESS.");
    LIB_JUSTIFICATION_MONTANT.put("21", "NON ECRETE PLAF RESS");
    LIB_JUSTIFICATION_MONTANT.put("30", "RSP TEMPS PARTIEL");
    LIB_JUSTIFICATION_MONTANT.put("SR", "AREA8A102006");
    LIB_JUSTIFICATION_MONTANT.put("TR", "AREFA8A102006");
    LIB_JUSTIFICATION_MONTANT.put("14", "CSP 80 PCTS");
    LIB_JUSTIFICATION_MONTANT.put("15", "CSP 80 PCTS SANS FINANCEMENT");
    LIB_JUSTIFICATION_MONTANT.put("16", "CSP AREF SOUS-JACENT");
    LIB_JUSTIFICATION_MONTANT.put("17", "ABAISSE AU PLAFOND MAYOTTE");
    LIB_JUSTIFICATION_MONTANT.put("18", "RELEVE AU PLANCHER 50% SJR");
    LIB_JUSTIFICATION_MONTANT.put("19", "RELEVE AU PLANCHER 35% SJR");
    
    LIB_ETAT_REGLEMENTAIRE = new HashMap();
    
    LIB_ETAT_REGLEMENTAIRE.put("1", "DUREE REGLEMENTAIRE");
    LIB_ETAT_REGLEMENTAIRE.put("3", "CARENCE");
    LIB_ETAT_REGLEMENTAIRE.put("5", "MAINTIEN DES DROITS");
    LIB_ETAT_REGLEMENTAIRE.put("6", "FIN DE DROITS");
    LIB_ETAT_REGLEMENTAIRE.put("7", "EN PREAVIS NON EFFECTUE");
    LIB_ETAT_REGLEMENTAIRE.put("9", "DIFFERE D'INDEMNISATION");
    
    LIB_ETAT_ADMINISTRATIF = new HashMap();
    
    LIB_ETAT_ADMINISTRATIF.put("1", "EN COURS D'OD");
    LIB_ETAT_ADMINISTRATIF.put("2", "EN ATTENTE DE DECISION");
    LIB_ETAT_ADMINISTRATIF.put("3", "POST INDEMNISATION");
    LIB_ETAT_ADMINISTRATIF.put("5", "EXCLUSION TEMPORAIRE");
    
    LIB_CODE_MOTIF_DE_NON_PAIEMENT = new HashMap();
    
    LIB_CODE_MOTIF_DE_NON_PAIEMENT.put("00", "CARENCE, FRANCHISE OU DIFFERE");
    LIB_CODE_MOTIF_DE_NON_PAIEMENT.put("10", "Exclusion temporaire DDTE sans imputation (122j)");
    LIB_CODE_MOTIF_DE_NON_PAIEMENT.put("11", "Exclusion temporaire DDTE avec imputation (122j)");
    LIB_CODE_MOTIF_DE_NON_PAIEMENT.put("12", "Exclusion temporaire DDTE sans imputation (autre)");
    LIB_CODE_MOTIF_DE_NON_PAIEMENT.put("13", "Exclusion temporaire DDTE avec imputation (autre)");
    LIB_CODE_MOTIF_DE_NON_PAIEMENT.put("40", "ATTENTE JUSTIFICATION (AR)");
    LIB_CODE_MOTIF_DE_NON_PAIEMENT.put("41", "DEPASSEMENT SEUIL GAIN POUR AR");
    LIB_CODE_MOTIF_DE_NON_PAIEMENT.put("42", "DEPASSEMENT SEUIL HORAIRE POUR AR");
    LIB_CODE_MOTIF_DE_NON_PAIEMENT.put("43", "DECALAGE POUR AR");
    LIB_CODE_MOTIF_DE_NON_PAIEMENT.put("57", "ATTENTE DE REGUL");
    LIB_CODE_MOTIF_DE_NON_PAIEMENT.put("44", "Décision négative DDTE sur prolongation cumul (AR)");
    LIB_CODE_MOTIF_DE_NON_PAIEMENT.put("45", "Attente décision  DDTE sur prolongation cumul (AR)");
    LIB_CODE_MOTIF_DE_NON_PAIEMENT.put("60", "Prise en charge par la Sécurité Sociale");
    LIB_CODE_MOTIF_DE_NON_PAIEMENT.put("70", "SANCTION POUR PND");
    LIB_CODE_MOTIF_DE_NON_PAIEMENT.put("80", "Dépassement plafond ressources (RSN)");
    LIB_CODE_MOTIF_DE_NON_PAIEMENT.put("50", "Période d'activité salariée sans salaire");
    LIB_CODE_MOTIF_DE_NON_PAIEMENT.put("90", "AUTRE MOTIF");
    LIB_CODE_MOTIF_DE_NON_PAIEMENT.put("99", "SANS OBJET");
    
    LIB_POSITION_EXONERATION = new HashMap();
    
    LIB_POSITION_EXONERATION.put("T", "EXONERATION TOTALE");
    LIB_POSITION_EXONERATION.put("P", "EXONERATION PARTIELLE");
    LIB_POSITION_EXONERATION.put("N", "NON EXONERATION");
    
    LIB_CARENCES = new HashMap();
    
    LIB_CARENCES.put("CP", "CARENCE CONGES PAYES");
    LIB_CARENCES.put("FR", "CARENCE FRANCHISE");
    LIB_CARENCES.put("DV", "CARENCE ADMISSION SUITE A DEPART VOLONTAIRE");
    LIB_CARENCES.put("IR", "CARENCE ISLR");
    
    LIB_COMPLEMENT_TYPE_MONTANT = new HashMap();
    
    LIB_COMPLEMENT_TYPE_MONTANT.put(Integer.valueOf(0), "SANS OBJET");
    LIB_COMPLEMENT_TYPE_MONTANT.put(Integer.valueOf(1), "FORMATION");
    LIB_COMPLEMENT_TYPE_MONTANT.put(Integer.valueOf(30), "TYPE CONVENTION P");
    LIB_COMPLEMENT_TYPE_MONTANT.put(Integer.valueOf(31), "TYPE CONVENTION C");
    LIB_COMPLEMENT_TYPE_MONTANT.put(Integer.valueOf(32), "TYPE CONVENTION A");
    LIB_COMPLEMENT_TYPE_MONTANT.put(Integer.valueOf(34), "TYPE CONVENTION C AFAF");
    LIB_COMPLEMENT_TYPE_MONTANT.put(Integer.valueOf(35), "TYPE CONVENTION A AFAF");
    LIB_COMPLEMENT_TYPE_MONTANT.put(Integer.valueOf(60), "TYPE CONVENTION P CRP");
    LIB_COMPLEMENT_TYPE_MONTANT.put(Integer.valueOf(60), "TYPE CONVENTION H CRP");
    LIB_COMPLEMENT_TYPE_MONTANT.put(Integer.valueOf(61), "TYPE CONVENTION C CRP");
    LIB_COMPLEMENT_TYPE_MONTANT.put(Integer.valueOf(62), "TYPE CONVENTION A CRP");
    LIB_COMPLEMENT_TYPE_MONTANT.put(Integer.valueOf(64), "TYPE CONVENTION C CRP AFAF");
    LIB_COMPLEMENT_TYPE_MONTANT.put(Integer.valueOf(65), "TYPE CONVENTION A CRP AFAF");
    LIB_COMPLEMENT_TYPE_MONTANT.put(Integer.valueOf(74), "TYPE CONVENTION C RSA DC");
    LIB_COMPLEMENT_TYPE_MONTANT.put(Integer.valueOf(75), "TYPE CONVENTION A RSA DC");
    LIB_COMPLEMENT_TYPE_MONTANT.put(Integer.valueOf(84), "TYPE CONVENTION C RSA DERO");
    LIB_COMPLEMENT_TYPE_MONTANT.put(Integer.valueOf(85), "TYPE CONVENTION A RSA DERO");
    
    LIB_STATUT_PAIEMENT = new HashMap();
    
    LIB_STATUT_PAIEMENT.put(Integer.valueOf(0), "SANS OBJET");
    LIB_STATUT_PAIEMENT.put(Integer.valueOf(1), "INDETERMINE");
    LIB_STATUT_PAIEMENT.put(Integer.valueOf(4), "ATTENTE JUSTIFICATIF");
    LIB_STATUT_PAIEMENT.put(Integer.valueOf(3), "PAIEMENT DEFINITIF");
    LIB_STATUT_PAIEMENT.put(Integer.valueOf(5), "PAIEMENT PAR AVANCE");
    
    LIB_REGLEMENT_APPLICABLE = new HashMap();
    
    LIB_REGLEMENT_APPLICABLE.put("A1", "A1");
    LIB_REGLEMENT_APPLICABLE.put("A10", "A10");
    LIB_REGLEMENT_APPLICABLE.put("A11", "A11");
    LIB_REGLEMENT_APPLICABLE.put("A2a", "A2a");
    LIB_REGLEMENT_APPLICABLE.put("A2b", "A2b");
    LIB_REGLEMENT_APPLICABLE.put("A3", "A3");
    LIB_REGLEMENT_APPLICABLE.put("A4", "A4");
    LIB_REGLEMENT_APPLICABLE.put("A5", "A5");
    LIB_REGLEMENT_APPLICABLE.put("A6", "A6");
    LIB_REGLEMENT_APPLICABLE.put("A7", "A7");
    LIB_REGLEMENT_APPLICABLE.put("A8", "A8");
    LIB_REGLEMENT_APPLICABLE.put("A9A", "A9A");
    LIB_REGLEMENT_APPLICABLE.put("A9B", "A9B");
    LIB_REGLEMENT_APPLICABLE.put("RG", "RG");
    LIB_REGLEMENT_APPLICABLE.put("OP", "RGOP");
    LIB_REGLEMENT_APPLICABLE.put("RGP", "RGP");
    
    LIB_TYPE_DISPOSITIF = new HashMap();
    
    LIB_TYPE_DISPOSITIF.put("1", "2004");
    LIB_TYPE_DISPOSITIF.put("2", "2006");
    LIB_TYPE_DISPOSITIF.put("3", "2017");
    
    LIB_SITUATION_PARTICULIERE = Attribution.LIB_SITUATION_PARTICULIERE;
    
    LIB_SITUATION_PARTICULIERE.put("3", "INDEMN 2NDE TRANCHE");
    
    LIB_PAYS = new HashMap();
    
    LIB_PAYS.put("000", "FRANCE");
    LIB_PAYS.put("101", "DANEMARK");
    LIB_PAYS.put("102", "ISLANDE");
    LIB_PAYS.put("103", "NORVEGE");
    LIB_PAYS.put("104", "SUEDE");
    LIB_PAYS.put("105", "FINLANDE");
    LIB_PAYS.put("106", "ESTONIE");
    LIB_PAYS.put("107", "LETTONIE");
    LIB_PAYS.put("108", "LITUANIE");
    LIB_PAYS.put("109", "ALLEMAGNE");
    LIB_PAYS.put("110", "AUTRICHE");
    LIB_PAYS.put("111", "BULGARIE");
    LIB_PAYS.put("112", "HONGRIE");
    LIB_PAYS.put("113", "LIECHTENSTEIN");
    LIB_PAYS.put("114", "ROUMANIE");
    LIB_PAYS.put("116", "REPUBLIQUE TCHEQUE");
    LIB_PAYS.put("117", "SLOVAQUIE");
    LIB_PAYS.put("118", "BOSNIE-HERZEGOVINE");
    LIB_PAYS.put("119", "CROATIE");
    LIB_PAYS.put("120", "MONTENEGRO");
    LIB_PAYS.put("121", "SERBIE EX-YOUGOSLAVIE");
    LIB_PAYS.put("122", "POLOGNE");
    LIB_PAYS.put("123", "RUSSIE");
    LIB_PAYS.put("125", "ALBANIE");
    LIB_PAYS.put("126", "GRECE");
    LIB_PAYS.put("127", "ITALIE");
    LIB_PAYS.put("128", "SAINT-MARIN");
    LIB_PAYS.put("129", "ETAT DE LA CITE DU VATICAN");
    LIB_PAYS.put("130", "ANDORRE");
    LIB_PAYS.put("131", "BELGIQUE");
    LIB_PAYS.put("132", "ROYAUME UNI");
    LIB_PAYS.put("133", "GIBRALTAR");
    LIB_PAYS.put("134", "ESPAGNE");
    LIB_PAYS.put("135", "PAYS BAS");
    LIB_PAYS.put("136", "IRLANDE");
    LIB_PAYS.put("137", "LUXEMBOURG");
    LIB_PAYS.put("138", "MONACO");
    LIB_PAYS.put("139", "PORTUGAL");
    LIB_PAYS.put("140", "SUISSE");
    LIB_PAYS.put("143", "CHYPRE UE");
    LIB_PAYS.put("144", "MALTE");
    LIB_PAYS.put("145", "SLOVENIE");
    LIB_PAYS.put("148", "BIELORUSSIE");
    LIB_PAYS.put("151", "MOLDAVIE");
    LIB_PAYS.put("155", "UKRAINE");
    LIB_PAYS.put("156", "REPUBLIQUE DE    MACEDOINE");
    LIB_PAYS.put("157", "ILES FEROES");
    LIB_PAYS.put("999", "AUTRES PAYS");
    
    LIB_TYPE_POPULATION = new HashMap();
    
    LIB_TYPE_POPULATION.put("ME", "EESSI_MAINTIEN_INDEMNISATION_FRANCE");
    LIB_TYPE_POPULATION.put("CG", "Convention de Gestion");
    LIB_TYPE_POPULATION.put("SP", "Secteur Public");
    LIB_TYPE_POPULATION.put("DI", "EESSI_DOUBLE_INSCRIPTION");
    LIB_TYPE_POPULATION.put("MO", "CONTEXTE_EESSI_MAINTIEN_INDEMNISATION_EUROPE");
    
    LIB_SOUS_TYPE_POPULATION = new HashMap();
    
    LIB_SOUS_TYPE_POPULATION.put("PE", "Pôle Emploi");
    LIB_SOUS_TYPE_POPULATION.put("FR", "Frais Réels");
    
    LIB_STATUT = new HashMap();
    
    LIB_RPS_RBF = new HashMap();
    
    LIB_RPS_RBF.put("RBF_IHE06_01", "IH RPS 1991");
    LIB_RPS_RBF.put("RBF_ITR05_01", "IT RPS 1991");
  }
}

/* Location:
 * Qualified Name:     ConstantesPBJC
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */