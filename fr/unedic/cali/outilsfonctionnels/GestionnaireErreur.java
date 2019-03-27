package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.affectation.GammeSpec;
import fr.unedic.cali.dom.affectation.Parametres;
import fr.unedic.util.services.ApplicativeRuntimeException;
import fr.unedic.util.services.ContexteException;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.PasAssezInformationException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GestionnaireErreur
{
  private static GestionnaireErreur instance = null;
  private Map<String, String> libelleCodesErreurs;
  public static final String ERR_GENERIQUE = "HG_PR_CALI_L_ERR_GENERIQUE";
  public static final String LIB_GENERIQUE = "Erreur inconnue dans l'exécution de l'application";
  public static final String ERR_CONTEXTE = "HG_PR_CALI_L_ERR_CONTEXTE";
  public static final String LIB_CONTEXTE = "Erreur liee au controle de contexte";
  public static final String ERR_CONTEXTE_ABSENT = "HG_PR_CALI_L_ERR_CONTEXTE_ABSENT";
  public static final String LIB_CONTEXTE_ABSENT = "Le contexte ne doit pas être null";
  public static final String ERR_CONTEXTE_ABSENCE_DOM = "HG_PR_CALI_L_CONTEXTE_ABSENCE_DOM";
  public static final String LIB_CONTEXTE_ABSENCE_DOM = "Le Dom ne doit pas être null.";
  public static final String ERR_CONTEXTE_ABSENCE_ID_INDIVIDU = "HG_PR_CALI_L_CONTEXTE_ABSENCE_ID_INDIVIDU";
  public static final String LIB_CONTEXTE_ABSENCE_ID_INDIVIDU = "La demande ne peut être rattachée à aucun individu.";
  public static final String ERR_CONTEXTE_ABSENCE_ID_DEMANDE = "HG_PR_CALI_L_CONTEXTE_ABSENCE_ID_DEMANDE";
  public static final String LIB_CONTEXTE_ABSENCE_ID_DEMANDE = "La demande recherchée en base n'a pas d'identifiant.";
  public static final String ERR_CONTEXTE_ABSENCE_DEMANDEUR = "HG_PR_CALI_L_ERR_CTX_ABS_DEMANDEUR";
  public static final String LIB_CONTEXTE_ABSENCE_DEMANDEUR = "Absence individu demandeur sur la demande";
  public static final String ERR_CONTEXTE_CHEVAUCHEMENT_NON_AUTORISE = "HG_PR_CALI_L_ERR_CHEVAUCHEMENT";
  public static final String LIB_CONTEXTE_CHEVAUCHEMENT_NON_AUTORISE = "Chevauchement de périodes non autorisé";
  public static final String ERR_CONTEXTE_DATE_REEXECUTION_MANQUANTE = "HG_PR_CALI_L_CONTEXTE_DATE_REEXECUTION_MANQUANTE";
  public static final String LIB_CONTEXTE_DATE_REEXECUTION_MANQUANTE = "Flux invalide : La date de réexécution est manquante";
  public static final String ERR_CALI_SUR_REEXECUTION_OPTMISATION = "HG_PR_CALI_L_ERREUR_SUR_REEXECUTION_OPTMISATION";
  public static final String LIB_CALI_SUR_REEXECUTION_OPTMISATION = "erreur lors de la réexécution.";
  public static final String ERR_CALCUL_ABSENCE_ETAT_DROIT_PRODUIT = "HG_PR_CALI_L_CALCUL_ABSENCE_ETAT_DROIT_PRODUIT";
  public static final String LIB_CALCUL_ABSENCE_ETAT_DROIT_PRODUIT = "Il n'y a pas d'état droit pour ce produit";
  public static final String ERR_CALCUL_ATTIBUTION_INCONNUE_DANS_CONTEXTE_UT = "HG_PR_CALI_L_ATTIBUTION_INCONNUE_DANS_CONTEXTE_UT";
  public static final String LIB_CALCUL_ATTIBUTION_INCONNUE_DANS_CONTEXTE_UT = "Attribution inconnue dans le contexte de l'UT";
  public static final String ERR_CALCUL_CONTEXTE_UT_SANS_PERIODE_D_UT = "HG_PR_CALI_L_CALCUL_CONTEXTE_UT_SANS_PERIODE_D_UT";
  public static final String LIB_CALCUL_CONTEXTE_UT_SANS_PERIODE_D_UT = "Contexte de l'UT sans période";
  public static final String ERR_CALCUL_CONTEXTE_UT_TYPE_PERIODE_INTER_PRODUIT_INCONNU = "HG_PR_CALI_L_UT_TYPE_PER_INTER_PROD_INCONNU";
  public static final String LIB_CALCUL_CONTEXTE_UT_TYPE_PERIODE_INTER_PRODUIT_INCONNU = "Type de période inter-produit inconnu";
  public static final String ERR_CALCUL_CREATION_FACADE_AVANT_CLASSE_GESTIONNAIRE_INTROUVABLE = "HG_PR_CALI_L_FACADE_AVANT_GESTIONNAIRE_INTROUVABLE";
  public static final String LIB_CALCUL_CREATION_FACADE_AVANT_CLASSE_GESTIONNAIRE_INTROUVABLE = "Pas de gestionnaire pour l'avant du produit";
  public static final String ERR_CALCUL_CREATION_FACADE_CALCUL_POUR_LIQUIDATION_INTROUVABLE = "HG_PR_CALI_L_FACADE_POUR_LIQ_INTROUVABLE";
  public static final String LIB_CALCUL_CREATION_FACADE_CALCUL_POUR_LIQUIDATION_INTROUVABLE = "Classe de la facade produit pour Liquidation introuvable";
  public static final String ERR_CALCUL_DECOUPAGE_ET_PRORATISATION = "HG_PR_CALI_L_DECOUPAGE_ET_PRORATISATION";
  public static final String LIB_CALCUL_DECOUPAGE_ET_PRORATISATION = "Erreur durant le découpage et la proratisation des périodes d'activités";
  public static final String ERR_CALCUL_STATUT_UT_POPULATION_INATTENDUE = "HG_PR_CALI_L_STATUT_UT_POPULATION_INATTENDUE";
  public static final String LIB_CALCUL_STATUT_UT_POPULATION_INATTENDUE = "Population de l'individu inattendue pour la définition du statut de l'UT";
  public static final String ERR_CALCUL_CREATION_FACADE_AVANT_PRODUIT_NUL = "HG_PR_CALI_L_FACADE_AVANT_PRODUIT_NUL";
  public static final String LIB_CALCUL_CREATION_FACADE_AVANT_PRODUIT_NUL = "Impossible de créer la façade avant Calcul du produit";
  public static final String ERR_CALCUL_CREATION_FACADE_POUR_LIQUIDATION_PRODUIT_NUL = "HG_PR_CALI_L_FACADE_LIQUIDATION_PRODUIT_NUL";
  public static final String LIB_CALCUL_CREATION_FACADE_POUR_LIQUIDATION_PRODUIT_NUL = "Impossible de créer la façade Calcul pour Liquidation du produit";
  public static final String ERR_CALCUL_CREATION_FACADE_PRODUIT_NUL = "HG_PR_CALI_L_CREATION_FACADE_PRODUIT_NUL";
  public static final String LIB_CALCUL_CREATION_FACADE_PRODUIT_NUL = "Impossible de créer la façade calcul du produit";
  public static final String ERR_CALCUL_CREATION_FACADE_POUR_PBJC_PRODUIT_NUL = "HG_PR_CALI_L_FACADE_PBJC_PRODUIT_NUL";
  public static final String LIB_CALCUL_CREATION_FACADE_POUR_PBJC_PRODUIT_NUL = "Impossible de créer la façade Calcul pour PBJC du produit";
  public static final String ERR_CALCUL_CREATION_FACADE_POUR_AIDE_PRODUIT_NUL = "HG_PR_CALI_L_FACADE_AIDE_PRODUIT_NUL";
  public static final String LIB_CALCUL_CREATION_FACADE_POUR_AIDE_PRODUIT_NUL = "Impossible de créer la façade Calcul pour AIDE du produit";
  public static final String ERR_CALCUL_CREATION_FACADE_CALCUL_POUR_AIDE_INTROUVABLE = "HG_PR_CALI_L_FACADE_POUR_AIDE_INTROUVABLE";
  public static final String LIB_CALCUL_CREATION_FACADE_CALCUL_POUR_AIDE_INTROUVABLE = "Classe de la facade produit pour AIDE introuvable";
  public static final String ERR_CALCUL_CREATION_FACADE_CALCUL_POUR_PBJC_INTROUVABLE = "HG_PR_CALI_L_FACADE_POUR_PBJC_INTROUVABLE";
  public static final String LIB_CALCUL_CREATION_FACADE_CALCUL_POUR_PBJC_INTROUVABLE = "Classe de la facade produit pour PBJC introuvable";
  public static final String ERR_CALCUL_PBJC_UNITES_TRAITEMENT_ABSENTE = "HG_PR_CALI_L_PBJC_UNITES_TRAITEMENT_ABSENTE";
  public static final String LIB_CALCUL_PBJC_UNITES_TRAITEMENT_ABSENTE = "Chronologie des Unités de Traitement vide lors de la création des PBJCs pour le produit";
  public static final String ERR_CALCUL_EVT_PRODUIT_PONCTUEL_ABSENTE = "HG_PR_CALI_L_EVT_PRODUIT_PONCTUEL_ABSENTE";
  public static final String LIB_CALCUL_EVT_PRODUIT_PONCTUEL_ABSENTE = "EvenementPaiementProduitPonctuel vide lors de la création des Primes pour le produit";
  public static final String ERR_CALCUL_PAS_DE_PEC_POUR_EXECUTION_AVANT = "HG_PR_CALI_L_PAS_DE_PEC_POUR_EXECUTION_AVANT";
  public static final String LIB_CALCUL_PAS_DE_PEC_POUR_EXECUTION_AVANT = "Attention lors de l'execution de l'avant, impossible de retrouver une periode de prise en charge.";
  public static final String ERR_CALCUL_CREATION_FACADE_CLASSE_GESTIONNAIRE_INTROUVABLE = "HG_PR_CALI_L_FACADE_GESTIONNAIRE_INTROUVABLE";
  public static final String LIB_CALCUL_CREATION_FACADE_CLASSE_GESTIONNAIRE_INTROUVABLE = "Pas de gestionnaire pour l'exécution du produit";
  public static final String ERR_CALCUL_ACTIVITE_REDUITE_STATUT_UT_INATTENDU = "HG_PR_CALI_L_ACTIVITE_REDUITE_STATUT_UT_INATTENDU";
  public static final String LIB_CALCUL_ACTIVITE_REDUITE_STATUT_UT_INATTENDU = "Erreur sur le statut de l'Unité de Traitement lors du traitement de l'activité réduite.";
  public static final String ERR_CALCUL_ARRET_MOTEUR_AVANT_PREMIER_PJI = "HG_PR_CALI_L_CALCUL_ARRET_MOTEUR_AVANT_PREMIER_PJI";
  public static final String LIB_CALCUL_ARRET_MOTEUR_AVANT_PREMIER_PJI = "Moteur Calcul : Date d'arret avant le premier PJI";
  public static final String ERR_CALCUL_PROBLEME_D_INSTANCIATION = "HG_PR_CALI_L_PROBLEME_D_INSTANCIATION";
  public static final String LIB_CALCUL_PROBLEME_D_INSTANCIATION = "Impossible d'instancier un objet";
  public static final String ERR_CALCUL_FORMULE_MONTANT_ABSENTE_SUR_FIN_QUANTITE_INDEMNISATION = "HG_PR_CALI_L_FORMULE_MONTANT_ABSENTE";
  public static final String LIB_CALCUL_FORMULE_MONTANT_ABSENTE_SUR_FIN_QUANTITE_INDEMNISATION = "Calcul : Formule montant introuvable malgré fin de quantite d'indemnisation";
  public static final String ERR_CALCUL_PROBLEME_DEBUT_TRAITEMENT_PERIODE_SEGMENTANTES = "HG_PR_CALI_L_ERREUR_TRAITEMENT_PERIODE_SEGMENTANTE";
  public static final String LIB_CALCUL_PROBLEME_DEBUT_TRAITEMENT_PERIODE_SEGMENTANTES = "Erreur de date de début lors du traitement des périodes segmentantes dans le Calcul.";
  public static final String ERR_CALCUL_DUREE_INDEMNISATION_ABSENTE = "HG_PR_CALI_L_DUREE_INDEMNISATION_ABSENTE";
  public static final String LIB_CALCUL_DUREE_INDEMNISATION_ABSENTE = "Impossible d'indemniser le produit: pas de durée d'indemnisation active ni constituant du montant";
  public static final String ERR_CALCUL_DUREE_INDEMNISATION_MULTIPLE = "HG_PR_CALI_L_DUREE_INDEMNISATION_MULTIPLE";
  public static final String LIB_CALCUL_DUREE_INDEMNISATION_MULTIPLE = "Impossible d'indemniser le produit: il existe plusieurs durées d'indemnisation actives";
  public static final String ERR_CALCUL_BOUCLE_INFINIE = "HG_PR_CALI_L_EXECUTION_ATTRIBUTION_DEMARRE_JAMAIS";
  public static final String LIB_CALCUL_BOUCLE_INFINIE = "Erreur Calcul : L'exécution de l'attribution du %ARG% n'a pas pu démarrer";
  public static final String ERR_CALCUL_TYPE_POST_TRAITEMENT_RESULTAT_INCONNU = "HG_PR_CALI_L_TYPE_POST_TRAITEMENT_RESULTAT_INCONNU";
  public static final String LIB_CALCUL_TYPE_POST_TRAITEMENT_RESULTAT_INCONNU = "Type de post traitement inconnu : %ARG%";
  public static final String ERR_CALCUL_CONTEXTE_DATE_ARRET_NON_RENSEIGNEE = "HG_PR_CALI_L_CONTEXTE_DATE_ARRET_NON_RENSEIGNEE";
  public static final String LIB_CALCUL_CONTEXTE_DATE_ARRET_NON_RENSEIGNEE = "Contrôle du contexte du calcul : la date d'arrêt de l'exécution doit être renseignée";
  public static final String ERR_CALCUL_CONTEXTE_DATE_ARRET_RENSEIGNEE = "HG_PR_CALI_L_CONTEXTE_DATE_ARRET_RENSEIGNEE";
  public static final String LIB_CALCUL_CONTEXTE_DATE_ARRET_RENSEIGNEE = "Contrôle du contexte du calcul : la date d'arrêt de l'exécution ne doit pas être renseignée";
  public static final String ERR_CALCUL_CONTEXTE_EXECUTION_PERSISTANTE = "HG_PR_CALI_L_CALCUL_CONTEXTE_EXECUTION_PERSISTANTE";
  public static final String LIB_CALCUL_CONTEXTE_EXECUTION_PERSISTANTE = "Contrôle du contexte du calcul : l'exécution ne doit pas être persistante";
  public static final String ERR_CALCUL_CONTEXTE_EXECUTION_NON_LUE_EN_BASE = "HG_PR_CALI_L_CONTEXTE_EXECUTION_NON_LUE_EN_BASE";
  public static final String LIB_CALCUL_CONTEXTE_EXECUTION_NON_LUE_EN_BASE = "Contrôle du contexte du calcul : l'exécution doit être lue en base";
  public static final String ERR_CALCUL_CONTEXTE_ABSENCE_DECISION_A_ETUDIER = "HG_PR_CALI_L_CONTEXTE_ABSENCE_DECISION_A_ETUDIER";
  public static final String LIB_CALCUL_CONTEXTE_ABSENCE_DECISION_A_ETUDIER = "Contrôle du contexte du calcul : aucune décision à étudier en entrée";
  public static final String ERR_CALCUL_CONTEXTE_PRESENCE_DECISION_A_ETUDIER = "HG_PR_CALI_L_CONTEXTE_PRESENCE_DECISION_A_ETUDIER";
  public static final String LIB_CALCUL_CONTEXTE_PRESENCE_DECISION_A_ETUDIER = "Contrôle du contexte du calcul : une décision à étudier est présente en entrée";
  private static final String ERR_GESTIONNAIRE_ERREUR_TAILLE_MAX = "ERR_GESTIONNAIRE_ERREUR_TAILLE_MAX";
  private static final String LIB_GESTIONNAIRE_ERREUR_TAILLE_MAX = "Un code d'erreur dépasse les 50 caractères : ";
  private static final String ERR_GESTIONNAIRE_ERREUR_PREFIXE = "ERR_GESTIONNAIRE_PREFIXE";
  private static final String LIB_GESTIONNAIRE_ERREUR_PREFIXE = "Le libellé n'est pas prefixé ";
  private static final String ERR_GESTIONNAIRE_ERREUR_CODE_SOLITAIRE = "ERR_GESTIONNAIRE_CODE_SOLITAIRE";
  private static final String LIB_GESTIONNAIRE_ERREUR_CODE_SOLITAIRE = "Un CodeErreur n'a pas de libellé associé : ";
  private static final String ERR_GESTIONNAIRE_ERREUR_CODE_DOUBLE = "ERR_GESTIONNAIRE_CODE_DOUBLE";
  private static final String LIB_GESTIONNAIRE_ERREUR_CODE_DOUBLE = "Un CodeErreur est en double : ";
  private static final String ERR_GESTIONNAIRE_ERREUR_FORMAT = "ERR_GESTIONNAIRE_FORMAT";
  private static final String LIB_GESTIONNAIRE_ERREUR_FORMAT = "Le champs est mal formaté : ";
  private static final String ERR_GESTIONNAIRE_ERREUR_REFLEXION = "ERR_GESTIONNAIRE_ERREUR_REFLEXION";
  private static final String LIB_GESTIONNAIRE_ERREUR_REFLEXION = "Erreur lors de la reflexion - IllegalArgumentException";
  private static final String ERR_GESTIONNAIRE_ERREUR_REFLEXION2 = "ERR_GESTIONNAIRE_ERREUR_REFLEXION2";
  private static final String LIB_GESTIONNAIRE_ERREUR_REFLEXION2 = "Erreur lors de la reflexion - IllegalAccessException";
  public static final String ERR_GESTIONNAIRE_DATE_REFLEXION = "ERR_GESTIONNAIRE_DATE_REFLEXION";
  public static final String LIB_GESTIONNAIRE_DATE_REFLEXION = "Erreur lors de la reflexion - IllegalArgumentException";
  public static final String ERR_GESTIONNAIRE_DATE_REFLEXION2 = "ERR_GESTIONNAIRE_DATE_REFLEXION2";
  public static final String LIB_GESTIONNAIRE_DATE_REFLEXION2 = "Erreur lors de la reflexion - IllegalAccessException";
  public static final String ERR_GESTIONNAIRE_DATE_CODE_DOUBLE = "ERR_GESTIONNAIRE_DATE_CODE_DOUBLE";
  public static final String LIB_GESTIONNAIRE_DATE_CODE_DOUBLE = "Une date d'application est en double :  %ARG%";
  public static final String ERR_GESTIONNAIRE_DATE_CODE_SOLITAIRE = "ERR_GESTIONNAIRE_DATE_CODE_SOLITAIRE";
  public static final String LIB_GESTIONNAIRE_DATE_CODE_SOLITAIRE = "Une date d'application n'a pas de date associée : %ARG%";
  public static final String ERR_GESTIONNAIRE_DATE_FORMAT = "ERR_GESTIONNAIRE_FORMAT_DATE";
  public static final String LIB_GESTIONNAIRE_DATE_FORMAT = "Le champs est mal formaté : %ARG%";
  public static final String ERR_FABRIQUE_GENERIQUE_DATE_APPEL_NULLE = "ERR_FABRIQUE_GENERIQUE_DATE_APPEL_NULLE";
  public static final String LIB_FABRIQUE_GENERIQUE_DATE_APPEL_NULLE = "La date d'appel ne doit pas être nulle";
  public static final String ERR_FABRIQUE_GENERIQUE_AUCUNE_STRATEGIE = "ERR_FABRIQUE_GENERIQUE_AUCUNE_STRATEGIE";
  public static final String LIB_FABRIQUE_GENERIQUE_AUCUNE_STRATEGIE = "Aucune stratégie n'a été trouvée";
  public static final String ERR_FABRIQUE_GENERIQUE_ERREUR_INSCRIPTION = "ERR_FABRIQUE_GENERIQUE_ERREUR_INSCRIPTION";
  public static final String LIB_FABRIQUE_GENERIQUE_ERREUR_INSCRIPTION = "Erreur lors de l'inscription de la stratégie";
  public static final String ERR_DONNEES_FRAIS_THR_INCOHERENTES = "HG_DONNEES_FRAIS_THR_INCOHERENTES";
  public static final String LIB_DONNEES_FRAIS_THR_INCOHERENTES = "Les données concernant le nb d aller-retour ou le km aller-retour sont incohérentes";
  public static final String ERR_DENEUTRALISER_DEMANDE_FIGEE = "HG_PR_CALI_L_DENEUTRALISER_DEMANDE_FIGEE";
  public static final String LIB_DENEUTRALISER_DEMANDE_FIGEE = "Il n est pas possible de dé-neutraliser en cascade : une demande postérieure est figée";
  public static final String ERR_TOPS_DEMANDE_INCOHERENTS = "HG_PR_CALI_L_TOPS_DEMANDE_INCOHERENTS";
  public static final String LIB_TOPS_DEMANDE_INCOHERENTS = "Les tops Neutralistion Liq., Cal. et de déneutralisation sont incohérents sur la demande du %ARG%";
  public static final String ERR_CALI_DDORKB_NCP_NULLE = "HG_PR_CALI_DDORKB_NCP_NULLE";
  public static final String LIB_CALI_DDORKB_NCP_NULLE = "La Ddorkb n'a pas peux etre redéterminée par Ncp";
  public static final String ERR_CALI_DDORKB_NCP_AVANT_DDORKB_V1 = "HG_PR_CALI_DDORKB_NCP_AVANT_DDORKB_V1";
  public static final String LIB_CALI_DDORKB_NCP_AVANT_DDORKB_V1 = "La Ddorkb Ncp est antérieure à la Ddorkb de Sigma : %ARG% ";
  public static final String ERR_CALI_DDORKB_NCP_APRES_DDORKB_V1 = "HG_PR_CALI_DDORKB_NCP_APRES_DDORKB_V1";
  public static final String LIB_CALI_DDORKB_NCP_APRES_DDORKB_V1 = "La Ddorkb Ncp est après la Ddorkb de Sigma : %ARG%";
  public static final String ERR_CALI_DJI_DROIT_FIGE_APRES_DDORKB_V2 = "HG_PR_CALI_DJI_DROIT_FIGE_APRES_DDORKB_V2";
  public static final String LIB_CALI_DJI_DROIT_FIGE_APRES_DDORKB_V2 = "Le Dji du dernier droit figée est postérieur à la ddorkb Ncp %ARG%";
  public static final String ERR_CALI_FORMULAIRE_V1_NUL = "HG_PR_CALI_CALI_FORMULAIRE_V1_NUL";
  public static final String LIB_CALI_FORMULAIRE_V1_NUL = "Le formulaire de la DAL (%ARG%) n'a pas été trouvé";
  public static final String ERR_CALI_FORM_V1_INCOHERENT_AVEC_FORM_V2 = "HG_PR_CALI_FORM_V1_INCOHERENT_AVEC_FORM_V2";
  public static final String LIB_CALI_FORM_V1_INCOHERENT_AVEC_FORM_V2 = "Incohérence de formulaire V1 de type %ARG% pour la DAL V2 (%ARG%) de type %ARG%";
  public static final String ERR_PRESENCE_DONNEES_CHOMAGE_SANS_RUPTURE_SI_DATE_CHOM = "HG_PR_N_CALI_ERR_PRESENCE_DONNEES_CHOMAGE_SANS_RUP";
  public static final String LIB_PRESENCE_DONNEES_CHOMAGE_SANS_RUPTURE_SI_DATE_CHOM = "Toutes les données du chômage sans rupture doivent être saisies";
  public static final String ERR_PRESENCE_AVIS_FAVO_POUR_ATTRIB_FIXE = "HG_PR_N_CALI_ERR_PRESENCE_AVIS_FAVO_ET_AVIS_DEFAVO";
  public static final String LIB_PRESENCE_AVIS_FAVO_POUR_ATTRIB_FIXE = "la décision de la IPR ne permet pas la saisie d'une date d'attribution";
  public static final String ERR_PRESENCE_AVIS_FAVO_POUR_POURSUITE = "HG_PR_N_CALI_ERR_PRESENCE_AVIS_FAVO_POUR_POURSUITE";
  public static final String LIB_PRESENCE_AVIS_FAVO_POUR_POURSUITE = "la décision de la IPR ne permet pas la saisie d'un accord sur poursuite 128J";
  public static final String ERR_PRESENCE_QUANTITE_JOUR_DIFFERE = "HG_PR_N_CALI_ERR_PRESENCE_QUANTITE_JOUR_DIFFERE";
  public static final String LIB_PRESENCE_QUANTITE_JOUR_DIFFERE = "Différé obligatoire si fin de contrat de travail renseignée";
  public static final String ERR_CONTEXTE_PAS_D_ATTRIBUTION_PRECEDENTE = "HG_PR_CALI_L_ERR_CONTEXTE_PAS_D_ATTRIBUTION";
  public static final String LIB_CONTEXTE_PAS_D_ATTRIBUTION_PRECEDENTE = "Absence d'attribution précédente, reliquider la demande";
  public static final String ERR_CONTEXTE_PERTE_ATTRIBUTION_PRECEDENTE = "HG_PR_CALI_L_ERR_CONTEXTE_PERTE_ATTRIBUTION";
  public static final String LIB_CONTEXTE_PERTE_ATTRIBUTION_PRECEDENTE = "Perte d'informations sur la demande, classez la demande sans objet, déclassez la, puis reliquider la.";
  public static final String ERR_CONTEXTE_D_ATTRIBUTION_PRECEDENTE_AVEC_PRODUIT_DIFFERENT = "HG_PR_CALI_L_ERR_CONTEXTE_D_ATTRIBUTION_PRECEDENTE";
  public static final String LIB_CONTEXTE_D_ATTRIBUTION_PRECEDENTE_AVEC_PRODUIT_DIFFERENT = "L''attribution précédente possède un produit différent de celui de la reprise, reliquider la demande.";
  public static final String ERR_CONTEXTE_CLASSEMENT_SO_SUR_DEMANDE = "HG_PR_CALI_L_ERR_CLASSEMENT_SO_SUR_DEMANDE";
  public static final String LIB_CONTEXTE_CLASSEMENT_SO_SUR_DEMANDE = "Le classement de la demande en sans objet est impossible, veuillez mettre en réexamen la décision";
  public static final String ERR_CONTEXTE_CLASSEMENT_SP_SUR_DEMANDE = "HG_PR_CALI_L_ERR_CLASSEMENT_SP_SUR_DEMANDE";
  public static final String LIB_CONTEXTE_CLASSEMENT_SP_SUR_DEMANDE = "Impossible de classer la demande en secteur public, demande déja décisionnée.";
  public static final String ERR_CALI_ANTECEDENT_AUCUN_PRODUIT_ACTIF = "HG_PR_CALI_ANTECEDENT_AUCUN_PRODUIT_ACTIF";
  public static final String LIB_CALI_ANTECEDENT_AUCUN_PRODUIT_ACTIF = "Impossible de trouver un produit actif pour la valeur %ARG%";
  public static final String ERR_CALI_ANTECEDENT_AUCUNE_PEC_APRES_DJC = "HG_PR_CALI_ANTECEDENT_AUCUNE_PEC_APRES_DJC";
  public static final String LIB_CALI_ANTECEDENT_AUCUNE_PEC_APRES_DJC = "Impossible de trouver la prochaine IDE qui suit le Dernier Jour Calculé de l'antécédent";
  public static final String ERR_CALI_ANTECEDENT_AUCUN_PRODUIT_ACTIF_DATE_ATTRIBUTION = "HG_PR_CALI_ANTECEDENT_AUCUN_PRODUIT_ACTIF_DATE";
  public static final String LIB_CALI_ANTECEDENT_AUCUN_PRODUIT_ACTIF_DATE_ATTRIBUTION = "Le produit n'est pas géré sous NCP à la date du Fait Générateur de Droit.";
  public static final String ERR_CALI_ANTECEDENT_CODE_PRODUIT = "HG_PR_CALI_ANTECEDENT_CODE_PRODUIT";
  public static final String LIB_CALI_ANTECEDENT_CODE_PRODUIT = "Indiquer un produit avant d'installer l'antécédent";
  public static final String ERR_CALI_ANTECEDENT_PRESENCE_DROIT_PRECEDENT = "HG_PR_CALI_ANTECEDENT_PRESENCE_DROIT_PRECEDENT";
  public static final String LIB_CALI_ANTECEDENT_PRESENCE_DROIT_PRECEDENT = "La demande Antécédent ou Solidarité ne peut être créée que sur un 1er droit après migration ou transfert";
  public static final String ERR_CALI_ARI_PJI_HORS_PEC = "HG_PR_CALI_ARI_PJI_HORS_PEC";
  public static final String LIB_CALI_ARI_PJI_HORS_PEC = "Le premier jour indemnisable %ARG% doit être compris dans une prise en charge indemnisable";
  public static final String ERR_CALI_ANTECEDENT_OBLIGATOIRE_PRODUIT = "HG_PR_N_CALI_ANTECEDENT_OBLG_PRODUIT";
  public static final String LIB_CALI_ANTECEDENT_OBLIGATOIRE_PRODUIT = "Vous devez renseigner le produit.";
  public static final String ERR_CALI_ANTECEDENT_OBLIGATOIRE_CONTEXTE = "HG_PR_N_CALI_ANTECEDENT_OBLG_CONTEXTE";
  public static final String LIB_CALI_ANTECEDENT_OBLIGATOIRE_CONTEXTE = "Vous devez renseigner le contexte.";
  public static final String ERR_CALI_ANTECEDENT_OBLIGATOIRE_DATE_ATTRIBUTION = "HG_PR_N_CALI_ANTECEDENT_OBLG_DTE_ATTRIB";
  public static final String LIB_CALI_ANTECEDENT_OBLIGATOIRE_DATE_ATTRIBUTION = "Vous devez renseigner la date d'attribution.";
  public static final String ERR_CALI_ANTECEDENT_OBLIGATOIRE_DJC = "HG_PR_N_CALI_ANTECEDENT_OBLG_DJC";
  public static final String LIB_CALI_ANTECEDENT_OBLIGATOIRE_DJC = "Vous devez renseigner la date du dernier jour calculé.";
  public static final String ERR_CALI_ANTECEDENT_OBLIGATOIRE_RELIQUAT_DUREE = "HG_PR_N_CALI_ANTECEDENT_OBLG_RELIQUAT_DUREE";
  public static final String LIB_CALI_ANTECEDENT_OBLIGATOIRE_RELIQUAT_DUREE = "Vous devez renseigner le reliquat de durée.";
  public static final String ERR_CALI_ANTECEDENT_OBLIGATOIRE_CUMUL_AR = "HG_PR_N_CALI_ANTECEDENT_OBLG_CUMUL_AR";
  public static final String LIB_CALI_ANTECEDENT_OBLIGATOIRE_CUMUL_AR = "Vous devez renseigner le nombre de mois d'activité réduite.";
  public static final String ERR_CALI_ANTECEDENT_COHERENCE_DJC = "HG_PR_N_CALI_ANTECEDENT_COHR_DJC";
  public static final String LIB_CALI_ANTECEDENT_COHERENCE_DJC = "Le dernier jour calculé doit être postérieur ou égal à la date d'attribution.";
  public static final String ERR_CALI_ANTECEDENT_DJC_POSTERIEUR_DATE_JOUR = "HG_PR_N_CALI_ANTECEDENT_DJC_POSTERIEUR_DATE_JOUR";
  public static final String LIB_CALI_ANTECEDENT_DJC_POSTERIEUR_DATE_JOUR = "La date du dernier jour calculé ne peut pas être postérieure à la date du jour.";
  public static final String ERR_CALI_CONVENTION_GESTION_INEXISTANTE = "HG_PR_N_CALI_CONVENTION_GESTION_INEXISTANTE";
  public static final String LIB_CALI_CONVENTION_GESTION_INEXISTANTE = "Convention de Gestion Pôle Emploi inexistante.";
  public static final String ERR_DETERMINATION_ETAT_DROIT_IMPOSSIBLE_SUR_DROIT_FIGEE = "HG_PR_CALI_L_DETERMINATION_ETAT_DROIT_IMP_FIGEE";
  public static final String LIB_DETERMINATION_ETAT_DROIT_IMPOSSIBLE_SUR_DROIT_FIGEE = "La détermination de l'état du droit à la date du %ARG% est impossible sur le droit figée du %ARG% (classer la DAL en SO ou démontage préconisé)";
  public static final String ERR_CALI_TECHNIQUE_GRAPHE_INCOHERENT = "HG_PR_CALI_L_ERR_TECHNIQUE_GRAPHE_INCOHERENT";
  public static final String LIB_CALI_TECHNIQUE_GRAPHE_INCOHERENT = "Le graphe Cali est incohérent, impossible de sauvegarder les données";
  public static final String LIB_CALI_TECHNIQUE_GRAPHE_INCOHERENT_1 = "Erreur technique : Le RSOD (reference externe) sur l'attribution est null";
  public static final String LIB_CALI_TECHNIQUE_GRAPHE_INCOHERENT_2 = "Erreur technique : Il n'existe pas d'objectif satisfait alors que nous avons une attribution";
  public static final String LIB_CALI_TECHNIQUE_GRAPHE_INCOHERENT_3 = "Le graphe Cali est incohérent, impossible de sauvegarder les données : La reference externe de la demande RFPE est vide.";
  public static final String ERR_DETERMINATION_ETAT_DROIT_IMPOSSIBLE_SUR_DROIT_NEUTRALISE = "HG_PR_CALI_L_DETERMINATION_ETAT_DROIT_IMP_NEUTRA";
  public static final String LIB_DETERMINATION_ETAT_DROIT_IMPOSSIBLE_SUR_DROIT_NEUTRALISE = "La détermination de l'état du droit à la date du %ARG% est impossible sur le droit neutralisé du %ARG% (déneutraliser le droit ou forcer la Fct)";
  public static final String ERR_DATE_RECHERCHE_DERNIER_SINISTRE_CSR_INDETERMINEE = "HG_PR_CALI_L_DATE_RECHERCHE_DERNIER_SINISTRE_CSR";
  public static final String LIB_DATE_RECHERCHE_DERNIER_SINISTRE_CSR_INDETERMINEE = "La date de recherche du dernier sinistre (CSR) de la demande du %ARG% est indéterminée";
  public static final String ERR_CALI_TECHNIQUE_REJET_PIVOT_INCOHERENT = "HG_PR_CALI_L_ERR_CALI_TECH_REJET_PIVOT_INCOHERENT";
  public static final String LIB_CALI_TECHNIQUE_REJET_PIVOT_INCOHERENT = "Notification d'un rejet en base pivot sans motif de rejet.";
  public static final String ERR_CONTEXTE_PJI_THEORIQUE_APRES_RETRAITE = "HG_PR_CALI_L_CONTEXTE_PJI_THEORIQUE_APRES_RETRAITE";
  public static final String LIB_CONTEXTE_PJI_THEORIQUE_APRES_RETRAITE = "Le PJI théorique (%ARG%) est après la date de retraite, classer la demande sans objet";
  public static final String ERR_ALERTE_BLOQUANTE_INCOHERENCE_EMPLOYEUR_CTP = "HG_PR_CALI_L_INCOHERENCE_EMPLOYEUR_CTP";
  public static final String LIB_ALERTE_BLOQUANTE_INCOHERENCE_EMPLOYEUR_CTP = "Liquidation impossible : la date d'entrée en CTP n'est pas renseignée pour le CT du %ARG%.";
  public static final String ERR_ACCES_DONNEES_GAEC_FENETRAGE_DEBUT = "HG_PR_CALI_L_ERR_ACCES_DONNEES_GAEC_FENETRAGE_DEB";
  public static final String LIB_ACCES_DONNEES_GAEC_FENETRAGE_DEBUT = "Liquidation impossible suite restriction appel GAEC (%ARG%=%ARG% hors fenêtre (%ARG%-%ARG%))";
  public static final String ERR_ACCES_DONNEES_GAEC_FENETRAGE_FIN = "HG_PR_CALI_L_ERR_ACCES_DONNEES_GAEC_FENETRAGE_FIN";
  public static final String LIB_ACCES_DONNEES_GAEC_FENETRAGE_FIN = "Liquidation impossible suite restriction appel GAEC (%ARG%=%ARG% hors fenêtre (%ARG%-%ARG%))";
  public static final String ERR_ACCES_DONNEES_GAEC_MODE_APPEL = "HG_PR_CALI_L_ERR_ACCES_DONNEES_GAEC_MODE_APPEL";
  public static final String LIB_ACCES_DONNEES_GAEC_MODE_APPEL = "Liquidation impossible suite restriction appel GAEC (Erreur de mode d'appel)";
  public static final String ERR_ACCES_DONNEES_GAEC_TYPE_PERIODES = "HG_PR_CALI_L_ERR_ACCES_DONNEES_GAEC_TYPE_PERIODES";
  public static final String LIB_ACCES_DONNEES_GAEC_TYPE_PERIODES = "Liquidation impossible suite restriction appel GAEC (Erreur de type de période)";
  public static final String ERR_ACCES_DONNEES_GAEC_FENETRAGE = "HG_PR_CALI_L_ERR_ACCES_DONNEES_GAEC_FENETRAGE";
  public static final String LIB_ACCES_DONNEES_GAEC_FENETRAGE = "HG_Appel Calcul impossible suite restriction fenetrage appel GAEC";
  public static final String ERR_ACCES_DONNEES_GAEC_TYPE_PERIODES_CALCUL = "HG_PR_CALI_L_ERR_ACCES_DONNEES_GAEC_PERIODES_CAL";
  public static final String LIB_ACCES_DONNEES_GAEC_TYPE_PERIODES_CALCUL = "Calcul impossible suite restriction appel GAEC (Erreur de type de période)";
  public static final String ERR_ANNULER_REEXAMEN_DECISION_PREC_NON_MIGREE = "HG_PR_CALI_L_ANNULER_REEXAMEN_DECISION_PREC_NON";
  public static final String LIB_ANNULER_REEXAMEN_DECISION_PREC_NON_MIGREE = "La levée du réexamen n est plus possible, la décision précédente du %ARG% a été liquidée sous Ncp";
  public static final String ERR_ANNULER_REEXAMEN_DECISION_PREC_CLASSEE = "HG_PR_CALI_L_ANNULER_REEXAMEN_DECISION_PREC";
  public static final String LIB_ANNULER_REEXAMEN_DECISION_PREC_CLASSEE = "La levée du réexamen n est plus possible, la décision dont dépend celle-ci a été classée administrativement.";
  public static final String ERR_CALI_DONNEES_INDIVIDU_FILIERE_COURTE = "HG_PR_N_CALI_DONNEES_INDIVIDU_FILIERE_COURTE";
  public static final String LIB_CALI_DONNEES_INDIVIDU_FILIERE_COURTE = "Seules les valeurs 0 et 1 sont saisissables.";
  public static final String ERR_CALI_DONNEES_INDIVIDU_FILIERE_INT = "HG_PR_N_CALI_DONNEES_INDIVIDU_FILIERE_INT";
  public static final String LIB_CALI_DONNEES_INDIVIDU_FILIERE_INT = "Seules les valeurs 0, 1 et 2 sont saisissables.";
  public static final String ERR_CALI_DONNEES_INDIVIDU_FILIERE_LONGUE = "HG_PR_N_CALI_DONNEES_INDIVIDU_FILIERE_LONGUE";
  public static final String LIB_CALI_DONNEES_INDIVIDU_FILIERE_LONGUE = "Seules les valeurs 0, 1, 2 et 3 sont saisissables.";
  public static final String ERR_CALI_CODE_ACTIVITE_SIMULATION_CHANGEMENT = "HG_PR_L_CALI_CODE_ACTIVITE_SIMULATION_CHANGEMENT";
  public static final String LIB_CALI_CODE_ACTIVITE_SIMULATION_CHANGEMENT = "Le code activité de traitement n'est pas valide pour cette population.";
  public static final String ERR_CALI_CONTEXTE_SIMULATION_CHANGEMENT = "HG_PR_L_CALI_CONTEXTE_SIMULATION_CHANGEMENT";
  public static final String LIB_CALI_CONTEXTE_SIMULATION_CHANGEMENT = "Les contextes de la population %ARG% ne sont pas tous de type ContexteParcoursSimulationChangementSpec";
  public static final String ERR_CALI_POPULATION_SIMULATION_CHANGEMENT = "HG_PR_L_CALI_POPULATION_SIMULATION_CHANGEMENT";
  public static final String LIB_CALI_POPULATION_SIMULATION_CHANGEMENT = "La population %ARG% n'est pas du type PopulationSimulationChangementSpec";
  public static final String ERR_ARCE_ADR_NON_AUTORISE_PAS_CONV_GEST = "HG_PR_CALI_L_ARCE_ADR_NON_AUTORISE_PAS_CONV_GEST";
  public static final String LIB_ARCE_ADR_NON_AUTORISE_PAS_CONV_GEST = "Attribution %ARG% non permise pour la Convention de gestion Pôle Emploi associé au droit ARE, classer la demande Sans Objet";
  public static final String ERR_RNCPS_INDETERMINE = "HG_PR_CALI_L_RNCPS_INDETERMINE";
  public static final String LIB_RNCPS_INDETERMINE = "La donnée nécessaire au service RNCPS n'a pas pu être détermniné pour le DE %ARG%";
  public static final String ERR_CALI_INVOCATION_METHODE = "HG_PR_CALI_INVOCATION_METHODE";
  public static final String LIB_CALI_INVOCATION_METHODE = "L'invocation de la méthode %ARG% par introspection a rencontré un problème";
  public static final String ERR_GESTIONNAIRE_REEXECUTION_REEXAMEN_DEMANDE_VALIDEE = "HG_PR_CALI_L_GESTIONNAIRE_REEXECUTION_REEXAMEN";
  public static final String LIB_GESTIONNAIRE_REEXECUTION_REEXAMEN_DEMANDE_VALIDEE = "Validation impossible car le dossier est instable : veuillez réexécuter le dossier à partir du %ARG%.";
  public static final String ERR_GESTIONNAIRE_REEXECUTION_DETECTION_BOUCLE_INFINIE = "HG_PR_CALI_L_GESTIONNAIRE_REEXECUTION_BOUCLE";
  public static final String LIB_GESTIONNAIRE_REEXECUTION_DETECTION_BOUCLE_INFINIE = "Erreur lors de la réexécution du dossier : veuillez vérifier l'ordonnancement des demandes (date depôt)";
  public static final String ERR_PERSISTANCE_DOSSIER_AFFECTATION_TRANSIENT_PRESENT = "HG_PR_CALI_L_PERSISTANCE_DOSSIER_AFFECTATION";
  public static final String LIB_PERSISTANCE_DOSSIER_AFFECTATION_TRANSIENT_PRESENT = "Il existe toujours un dossier d'affectation sauvegardé, on va générer un orphelin";
  public static final String ERR_TRAIT_BATCH_CALI_INDIVIDU_NON_TROUVE = "HG_PR_CALI_L_TB_IND";
  public static final String LIB_TRAIT_BATCH_CALI_INDIVIDU_NON_TROUVE = "Individu non trouvé";
  public static final String ERR_TRAIT_BATCH_CALI_DEMANDE_NON_TROUVEE = "HG_PR_CALI_L_TB_DDE";
  public static final String LIB_TRAIT_BATCH_CALI_DEMANDE_NON_TROUVEE = "Demande non trouvée";
  public static final String ERR_TRAIT_BATCH_CALI_DDE_AVEC_CLASS_ADMIN = "HG_PR_CALI_L_TB_D_ACA";
  public static final String LIB_TRAIT_BATCH_CALI_DDE_AVEC_CLASS_ADMIN = "Demande portant déjà un classement administratif ou déjà décisionnée";
  public static final String ERR_APPEL_CALI_CALI = "HG_PR_CALI_L_APPEL_CALI_CALI";
  public static final String LIB_APPEL_CALI_CALI = "Problème lors de l'appel de service de CALI vers CALI";
  public static final String ERR_TECHNIQUE_FAB_DOMAINE_CALI = "HG_PR_CALI_L_ERR_TECHNIQUE_FAB_DOMAINE_CALI";
  public static final String LIB_TECHNIQUE_FAB_DOMAINE_CALI = "Probleme technique lors de la récupération du domaine CALI";
  public static final String ERR_APPEL_CALI_D90 = "HG_PR_CALI_L_APPEL_CALI_D90";
  public static final String LIB_APPEL_CALI_D90 = "Problème lors de l'appel de service de CALI vers D90";
  public static final String ERR_APPEL_CALI_GDP = "HG_PR_CALI_L_APPEL_CALI_GDP";
  public static final String LIB_APPEL_CALI_GDP = "Problème lors de l'appel de service de CALI vers GDP";
  public static final String ERR_APPEL_CALI_GAEC = "HG_PR_CALI_L_APPEL_CALI_GAEC";
  public static final String LIB_APPEL_CALI_GAEC = "Problème lors de l'appel de service de CALI vers GAEC";
  public static final String ERR_APPEL_CALI_D12I = "HG_PR_CALI_L_APPEL_CALI_D12I";
  public static final String LIB_APPEL_CALI_D12I = "Problème lors de l'appel de service de CALI vers Instruction";
  public static final String ERR_MAPPING_GA_ORIGINE_CT_UNDEF = "HG_PR_CALI_L_MAPPING_GA_ORIGINE_CT_UNDEF";
  public static final String LIB_MAPPING_GA_ORIGINE_CT_UNDEF = "Contrat de travail Gaec sans origine d'information";
  public static final String ERR_PERSISTANCE = "HG_PR_CALI_L_ERR_PERSISTANCE";
  public static final String LIB_PERSISTANCE = "Erreur d'accès aux données";
  public static final String ERR_SUPPRESSION = "HG_PR_CALI_L_ERR_SUPPRESSION";
  public static final String LIB_SUPPRESSION = "Erreur lors de la suppresion de l'objet : ";
  public static final String ERR_DOM_MANAGER = "HG_PR_CALI_L_ERR_DOM_MANAGER";
  public static final String LIB_DOM_MANAGER = "Erreur lors de l'appel du DomManager : ";
  public static final String ERR_DOM_MANAGER_BASE_ECHANGES = "HG_PR_CALI_L_ERR_DOM_MANAGER_BASE_ECHANGES";
  public static final String LIB_DOM_MANAGER_BASE_ECHANGES = "Erreur lors de l'appel du DomManager Base Echanges : ";
  public static final String ERR_ALIMENTATION_BASE_TRACKER = "HG_PR_CALI_L_ERR_ALIMENTATION_BASE_TRACKER";
  public static final String LIB_ALIMENTATION_BASE_TRACKER = "Erreur lors de l'alimentation en base Tracker : ";
  public static final String ERR_ALIMENTATION_BASE_CREM = "HG_PR_CALI_L_ERR_ALIMENTATION_BASE_CREM";
  public static final String LIB_ALIMENTATION_BASE_CREM = "Erreur lors de l'alimentation en base CREM";
  public static final String ERR_LECTURE_PARAMETRIQUE_TECHNIQUE = "HG_PR_CALI_L_ERR_LECTURE_PARAMETRIQUE_TECHNIQUE";
  public static final String LIB_LECTURE_PARAMETRIQUE_TECHNIQUE = "Erreur lors de la lecture des paramètres techniques";
  public static final String ERR_LECTURE_DATE_APPLICATION_BD = "HG_LECTURE_DATE_APPLICATION_BD";
  public static final String LIB_LECTURE_DATE_APPLICATION_BD = "Erreur lors de la lecture des dates d'applications en base";
  public static final String ERR_MNT_FORCAGE_APPARTENANCE_UNITE_ANNEES = "HG_PR_CALI_NL_MNT_FORCAGE_APPARTENANCE";
  public static final String LIB_MNT_FORCAGE_APPARTENANCE_UNITE_ANNEES = "Attention, nombre d'années supérieure à 99";
  public static final String ERR_MNT_FORCAGE_APPARTENANCE_UNITE_OBLIGATOIRE = "HG_PR_CALI_NL_MNT_FORCAGE_APPARTENANCE_UNITE";
  public static final String LIB_MNT_FORCAGE_APPARTENANCE_UNITE_OBLIGATOIRE = "Saisie de l'unité obligatoire si l'appartenance est renseignée";
  public static final String ERR_MNT_FORCAGE_APPARTENANCE_VALEUR_OBLIGATOIRE = "HG_PR_CALI_NL_MNT_FORCAGE_APPARTENANCE_VALEUR";
  public static final String LIB_MNT_FORCAGE_APPARTENANCE_VALEUR_OBLIGATOIRE = "Saisie de l'appartenance obligatoire si unité renseignée";
  public static final String ERR_MNT_FORCAGE_ACTIVITE_5_ANS_UNITE_ANNEES = "HG_PR_CALI_NL_MNT_ACT_5_ANS_UNITE_ANNEES";
  public static final String LIB_MNT_FORCAGE_ACTIVITE_5_ANS_UNITE_ANNEES = "La saisie d'un nombre d'années supérieur à 5 n'est pas possible";
  public static final String ERR_MNT_FORCAGE_ACTIVITE_5_ANS_UNITE_OBLIGATOIRE = "HG_PR_CALI_NL_MNT_ACT_5_ANS_UNITE_OBLIGATOIRE";
  public static final String LIB_MNT_FORCAGE_ACTIVITE_5_ANS_UNITE_OBLIGATOIRE = "Saisie de l'unité obligatoire si l'activité est renseignée";
  public static final String ERR_MNT_FORCAGE_ACTIVITE_5_ANS_VALEUR_OBLIGATOIRE = "HG_PR_CALI_NL_MNT_ACT_5_ANS_VALEUR_OBLIGATOIRE";
  public static final String LIB_MNT_FORCAGE_ACTIVITE_5_ANS_VALEUR_OBLIGATOIRE = "Saisie de l'activité obligatoire si l'unité est renseignée";
  public static final String ERR_MNT_FORCAGE_ACTIVITE_5_ANS_FLAG_CONTINUE_OBLIGATOIRE = "HG_PR_CALI_NL_MNT_ACT_5_ANS_FLAG_CONTINUE_OBLIG";
  public static final String LIB_MNT_FORCAGE_ACTIVITE_5_ANS_FLAG_CONTINUE_OBLIGATOIRE = "Précisez si l'activité est continue ou discontinue";
  public static final String ERR_MOIS_CIVIL_COURANT_RENSEIGNE = "HG_PR_CALI_L_RBF_MOIS_CIVIL_COURANT_RENSEIGNE";
  public static final String LIB_MOIS_CIVIL_COURANT_RENSEIGNE = "Données non enregistrées : il ne faut pas renseigner le mois courant ou futur";
  public static final String ERR_MOIS_CIVIL_FUTUR_RENSEIGNE = "HG_PR_CALI_L_RBF_MOIS_CIVIL_FUTUR_RENSEIGNE";
  public static final String LIB_MOIS_CIVIL_FUTUR_RENSEIGNE = "Données non enregistrées : il ne faut pas renseigner une justification postérieure à la date du jour";
  public static final String ERR_DESENGAGEMENT_AIDES_MOTIF_INCONNU = "HG_PR_CALI_L_RBF_DESENGAGEMENT_AIDES_MOTIF_INCONNU";
  public static final String LIB_DESENGAGEMENT_AIDES_MOTIF_INCONNU = "Désengagement du montant des aides impossible (motif %ARG%) car il ne s'agit pas d'un désengagement";
  public static final String ERR_ACTION_FORMATION_INCONNUE = "HG_PR_CALI_L_RBF_ACTION_FORMATION_INCONNUE";
  public static final String LIB_ACTION_FORMATION_INCONNUE = "L'action de formation spécifiée est inconnue : %ARG%.";
  public static final String ERR_A5MB5_MANQUE_FIN_ATP = "HG_A5MB5_MANQUE_FIN_ATP ";
  public static final String LIB_A5MB5_MANQUE_FIN_ATP = "Liquidation impossible : la situation ARE à fin ATP n'est pas installée suite à la radiation CTP";
  public static final String ERR_A5MB5_MANQUE_FIN_ASP = "HG_A5MB5_MANQUE_FIN_ASP";
  public static final String LIB_A5MB5_MANQUE_FIN_ASP = "Liquidation impossible : la situation ARE à fin ASP n'est pas installée suite à la radiation CSP";
  public static final String ERR_A5MB5_MANQUE_FIN_ASR = "HG_A5MB5_MANQUE_FIN_ASR";
  public static final String LIB_A5MB5_MANQUE_FIN_ASR = "Liquidation impossible : la situation ARE à fin ASR n'est pas installée suite à la radiation CRP";
  public static final String ERR_DEMANDE_RECHARG_MANQUANTE = "HG_PR_CALI_L_ERR_DEMANDE_RECHARG_MANQ";
  public static final String LIB_DEMANDE_RECHARG_MANQUANTE = "Liquidation impossible, la décision de rechargement n'est pas installée suite à épuisement du droit du %ARG%.";
  public static final String ERR_FIN_ASR_DETECTE = "HG_ERR_FIN_ASR_DETECT ";
  public static final String LIB_FIN_ASR_DETECTE = "Veuillez classer sans objet la demande de fin de droit ASR.";
  public static final String ERR_FIN_ASR_DEJA_PRESENTE = "HG_ERR_FIN_ASR_DEJA_PRESENTE";
  public static final String LIB_FIN_ASR_DEJA_PRESENTE = "La situation Fin ASR pour le droit ASR du %ARG% est déjà installée. Classer sans objet.";
  public static final String ERR_FIN_ASP_DEJA_PRESENTE = "HG_ERR_FIN_ASP_DEJA_PRESENTE";
  public static final String LIB_FIN_ASP_DEJA_PRESENTE = "La situation Fin ASP pour le droit ASP du %ARG% est déjà installée. Classer sans objet.";
  public static final String ERR_FIN_ATP_DEJA_PRESENTE = "HG_ERR_FIN_ATP_DEJA_PRESENTE";
  public static final String LIB_FIN_ATP_DEJA_PRESENTE = "La situation Fin ATP pour le droit ATP du %ARG% est déjà installée. Classer sans objet.";
  public static final String ERR_CALCUL_ECHEC_PRESENCE_PFM_HORS_INDEMNISATION = "HG_PR_CALI_L_CALCUL_PRESENCE_PFM_HORS_INDEMN";
  public static final String LIB_CALCUL_ECHEC_PRESENCE_PFM_HORS_INDEMNISATION = "Présence de PFM hors Indemnisation : Situation non géré dans Sigma";
  public static final String ERR_CALCUL_ECHEC_DERNIER_JOUR_ATTESTE_INCOHERENT = "HG_PR_CALI_L_CALCUL_DJA_DERNIER_JOUR_ATTESTE_INCO";
  public static final String LIB_CALCUL_ECHEC_DERNIER_JOUR_ATTESTE_INCOHERENT = "La valeur du denier jour atteste n'est pas cohérente, elle ne correspond pas à la fin du mois";
  public static final String ERR_CALCUL_ECHEC_ANOMALIE_CALENDRIER_ASS_INCOHERENT = "HG_PR_CALI_CALCUL_ECHEC_ANO_CAL_ASS_INCOHERENT";
  public static final String LIB_CALCUL_ECHEC_ANOMALIE_CALENDRIER_ASS_INCOHERENT = "Il existe une anomalie sur le dernier calendrier ASS figée";
  public static final String ERR_CALCUL_UT_PERSISTANTE_INCOHERENTE = "HG_PR_CALI_L_CALCUL_UT_PERSISTANTE_INCOHERENTE";
  public static final String LIB_CALCUL_UT_PERSISTANTE_INCOHERENTE = "L'unité de traitement qui sert de référence au calcul est incohérente";
  public static final String ERR_CALCUL_DATE_NAISSANCE_NON_RENSEIGNEE = "HG_PR_CALI_L_CALCUL_DATE_NAISSANCE_NON_RENSEIGNEE";
  public static final String LIB_CALCUL_DATE_NAISSANCE_NON_RENSEIGNEE = "Date de naissance du DE non renseignée";
  public static final String ERR_PARAMETRE_RETRAITE_NON_TROUVE = "HG_PR_CALI_L_PARAMETRE_RETRAITE_NON_TROUVE";
  public static final String LIB_PARAMETRE_RETRAITE_NON_TROUVE = "Le paramètre retraite n'a pas été trouvé";
  public static final String ERR_CALCUL_CALENDRIER_NON_EXISTANT = "HG_PR_CALI_L_CALCUL_CALENDRIER_NON_EXISTANT";
  public static final String LIB_CALCUL_CALENDRIER_NON_EXISTANT = "Le Calendrier du %ARG% n'existe pas";
  public static final String ERR_DOUBLON_FINALISER_RAPPORT_OCCASIONNEL = "HG_PR_CALI_L_DOUBLON_FINALISER_RAPPORT_OCCASIONNEL";
  public static final String LIB_DOUBLON_FINALISER_RAPPORT_OCCASIONNEL = "L'occasionnel a déjà été finalisé";
  public static final String ERR_CONTEXTE_NE_PERMET_PLUS_LIQUIDER_DEMANDE = "HG_PR_CALI_L_CONTEXTE_LIQUIDATION_IMPOSSIBLE";
  public static final String LIB_CONTEXTE_NE_PERMET_PLUS_LIQUIDER_DEMANDE = "Le contexte d'examen n'existe plus, la demande est sans objet";
  public static final String ERR_CONTEXTE_NE_PERMET_PAS_LIQUIDER_DEMANDE_MIGREE = "HG_PR_CALI_L_CONTEXTE_LIQ_IMPOSSIBLE_DMD_MIGREE";
  public static final String LIB_CONTEXTE_NE_PERMET_PAS_LIQUIDER_DEMANDE_MIGREE = "Liquidation NCP impossible pour une décision migrée";
  public static final String ERR_CONTEXTE_NE_PERMET_PAS_CLASSER_DEMANDE_MIGREE = "HG_PR_CALI_L_CTX_CLASSEMENT_IMPOS_DEMANDE_MIGREE";
  public static final String LIB_CONTEXTE_NE_PERMET_PAS_CLASSER_DEMANDE_MIGREE = "Classement SO impossible pour une décision migrée";
  public static final String ERR_CONTEXTE_NE_PERMET_PAS_RENDRE_LIQUIDABLE_ARE_SPEC = "HG_PR_CALI_L_CTX_LIQ_RENDRE_LIQUIDABLE_ARE_SPEC";
  public static final String LIB_CONTEXTE_NE_PERMET_PAS_RENDRE_LIQUIDABLE_ARE_SPEC = "Les décisions migrées ARE Spectacle ne sont pas liquidables sous Ncp";
  public static final String ERR_CALI_PRODUIT_NON_IMPLEMENTE = "HG_PR_CALI_PRODUIT_METHODE_NON_IMPLEMENTE";
  public static final String LIB_CALI_PRODUIT_NON_IMPLEMENTE = "Méthode non implémenté pour ce produit";
  public static final String ERR_SOL_CONTEXTE_OBTENTION_TRIMESTRES = "HG_PR_CALI_L_SOL_CONTEXTE_OBTENTION_TRIMESTRES";
  public static final String LIB_SOL_CONTEXTE_OBTENTION_TRIMESTRES = "Impossible d'obtenir la date d'obtention des %ARG% trimestres.";
  public static final String ERR_SOL_CALI_ABSENCE_RESSOURCE_INDIVIDU = "HG_PR_CALI_L_SOL_CALI_ABSENCE_RESSOURCE_INDIVIDU";
  public static final String LIB_SOL_CALI_ABSENCE_RESSOURCE_INDIVIDU = "La liste des ressources portée par l'individu ne contient pas la ressource liée à la demande %ARG%";
  public static final String ERR_MNT_CONTEXTE_DEMANDE_MAINTENUE = "HG_PR_CALI_L_MNT_CONTEXTE_DEMANDE_MAINTENUE";
  public static final String LIB_MNT_CONTEXTE_DEMANDE_MAINTENUE = "La demande maintenue n'a pas été trouvée, veuillez classer la demande sans objet";
  public static final String ERR_MNT_CONTEXTE_DROIT_MAINTENU_INEXISTANT = "HG_PR_CALI_L_MNT_CTX_DROIT_MAINTENU_INEXISTANT";
  public static final String LIB_MNT_CONTEXTE_DROIT_MAINTENU_INEXISTANT = "Le droit maintenu du %ARG% n'existe plus, veuillez classer la demande sans objet.";
  public static final String ERR_MNT_CONTEXTE_ERRONNE = "HG_PR_CALI_L_MNT_CONTEXTE_ERRONE";
  public static final String LIB_MNT_CONTEXTE_ERRONNE = "Le contexte du maintien n'existe plus, l'attribution maintenue est en réexamen ou classée.";
  public static final String ERR_COD06_ABSENCE_AGE_DEMANDEUR_DOD = "HG_SC_L_ES_ED_COD06_ABSENCE_AGE_DEMANDEUR_DOD";
  public static final String LIB_COD06_ABSENCE_AGE_DEMANDEUR_DOD = "Probleme sur la date de naissance.";
  public static final String ERR_ALERTE_BLOQUANTE_A11MB6_ABSENCE_TRIMESTRES_RETRAITE = "HG_PR_CALI_L_ALERTE_A11MB6_ABSENCE_TRIMESTRES";
  public static final String LIB_ALERTE_BLOQUANTE_A11MB6_ABSENCE_TRIMESTRES_RETRAITE = "Vérification de la condition d'âge impossible : le DE a plus de %ARG% et les informations sur la retraite ne sont pas saisies";
  public static final String LIB_ALERTE_BLOQUANTE_A11MB6_ABSENCE_TRIMESTRES_RETRAITE_1 = "Le nombre de trimestres acquis et sa date de valeur doivent être renseignés.";
  public static final String ERR_CONTEXTE_INCOHERENT_FRAIS_PEDAGO = "HG_SC_L_ES_ED_CTX_INCOHERENT_FRAIS_PEDAGO";
  public static final String LIB_CONTEXTE_INCOHERENT_FRAIS_PEDAGO = "Incohérence montant global frais pédagogiques et montant restant à charge";
  public static final String ERR_CONTEXTE_INCOHERENT_FRAIS_PEDAGO_MONTANT = "HG_SC_L_ES_ED_CTX_INCOHERENT_FRAIS_PEDAGO_MONTANT";
  public static final String LIB_CONTEXTE_INCOHERENT_FRAIS_PEDAGO_MONTANT = "Impossible, le montant indiqué est supérieur au montant global TTC de la formation";
  public static final String ERR_DEMANDE_FIGEE_NON_MODIFIABLE = "HG_PR_CALI_L_ERR_DEMANDE_FIGEE";
  public static final String LIB_DEMANDE_FIGEE_NON_MODIFIABLE = "Une demande figée ne peut pas être modifiée.";
  public static final String ERR_CONTEXTE_PEC_MAYOTTE = "HG_PR_CALI_L_CONTEXTE_PEC_MAYOTTE";
  public static final String LIB_CONTEXTE_PEC_MAYOTTE = "Liquidation impossible : le DE est domicilié à Mayotte au %ARG%, classer la demande sans objet";
  public static final String ERR_DEFINITION_SERVICE_INCONNUE_POUR_DIAGNOSTIC = "HG_PR_CALI_L_ERR_SERVICE_INCONNUE_POUR_DIAGNOSTIC";
  public static final String LIB_DEFINITION_SERVICE_INCONNUE_POUR_DIAGNOSTIC = "La définition du service n'a pas été répercutée dans la gestion du diagnostic";
  public static final String ERR_CONTEXTE_MAINTIEN_EUROPEEN_DOUBLE_INSCRIPTION = "HG_PR_CALI_L_CTX_MNT_EUROPEEN_DOUBLE_INSCRIPTION";
  public static final String LIB_CONTEXTE_MAINTIEN_EUROPEEN_DOUBLE_INSCRIPTION = "Liquidation impossible au %ARG% : contexte de double inscription frontalier";
  public static final String ERR_CONTEXTE_MAINTIEN_EUROPEEN_DROIT_MAINTENU_AUTRE_ETAT = "HG_PR_CALI_L_CTX_MNT_EUROP_DROIT_MAINTENU_ETAT";
  public static final String LIB_CONTEXTE_MAINTIEN_EUROPEEN_DROIT_MAINTENU_AUTRE_ETAT = "Liquidation impossible au %ARG% : contexte de droit maintenu par autre état membre de l'UE";
  public static final String ERR_CALCUL_CALENDRIER_AVANT_DELAI_ATTENTE_ENTAME = "HG_PR_CALI_L_CALCUL_CAL_AV_DELAI_ATTENTE_ENTAME";
  public static final String LIB_CALCUL_CALENDRIER_AVANT_DELAI_ATTENTE_ENTAME = "Si le reliquat délai d'attente est inférieur strictement à %ARG% jours, le délai d'attente doit être entamé (Valeur à Oui)";
  public static final String ERR_CALCUL_CALENDRIER_AVANT_DELAI_ATTENTE = "HG_PR_CALI_L_CALCUL_CAL_AVANT_DELAI_ATTENTE";
  public static final String LIB_CALCUL_CALENDRIER_AVANT_DELAI_ATTENTE = "Le reliquat délai d'attente ne peut être strictement supérieur à %ARG% jours";
  public static final String ERR_CALCUL_DATE_EXECUTION_CALCUL_PENDANT_DROIT_NEUTRALISE = "HG_PR_CALI_L_CAL_DATE_EXEC_PENDANT_DROIT_NEUTRA";
  public static final String LIB_CALCUL_DATE_EXECUTION_CALCUL_PENDANT_DROIT_NEUTRALISE = "Impossible d'exécuter le calcul, la date d'exécution (%ARG%) est sur un droit neutralisé";
  public static final String ERR_CALCUL_ECHEC_IMPOSSIBLE_AJOUTER_UT_FIGEE = "HG_PR_CALI_L_CALCUL_ECHEC_AJOUTER_UT_FIGEE";
  public static final String LIB_CALCUL_ECHEC_IMPOSSIBLE_AJOUTER_UT_FIGEE = "Impossible d'ajouter une UT figée sur un calendrier alors qu'il en existe déjà une";
  public static final String ERR_CALCUL_ECHEC_IMPOSSIBLE_SUPPRIMER_UT_FIGEE = "HG_PR_CALI_L_CALCUL_ECHEC_SUPPRIMER_UT_FIGEE";
  public static final String LIB_CALCUL_ECHEC_IMPOSSIBLE_SUPPRIMER_UT_FIGEE = "Impossible de supprimer une UT figée";
  public static final String ERR_CALCUL_ECHEC_DJA_INCOHERENT_UT_FIGEE = "HG_PR_CALI_L_CALCUL_DJA_INCOHERENT_UT_FIGEE";
  public static final String LIB_CALCUL_ECHEC_DJA_INCOHERENT_UT_FIGEE = "La date de fin de l'UT figée n'est pas cohérente, elle ne correspond pas au DJA";
  public static final String ERR_CALCUL_MAPPER_PERIODES_IMPOSSIBLE = "HG_PR_CALI_L_CAL_MAPPER_PERIODES_IMPOSSIBLE";
  public static final String LIB_CALCUL_MAPPER_PERIODES_IMPOSSIBLE = "Mapper périodes Calcul : Impossible de mapper une période";
  public static final String ERR_CALCUL_ABSENCE_DATE_ANOMALIE = "HG_PR_CALI_L_CAL_ABSENCE_DATE_ANOMALIE";
  public static final String LIB_CALCUL_ABSENCE_DATE_ANOMALIE = "Absence date de l'anomalie";
  public static final String ERR_CALCUL_EXECUTION_DE_NON_NCP = "HG_PR_CALI_L_CAL_EXECUTION_DE_NON_NCP";
  public static final String LIB_CALCUL_EXECUTION_DE_NON_NCP = "Le DE exécuté n'est pas NCP";
  public static final String ERR_CALCUL_EXECUTION_DE_MIGRE_ANO_CCS = "HG_PR_CALI_L_CAL_EXECUTION_DE_MIGRE_ANO_CCS";
  public static final String LIB_CALCUL_EXECUTION_DE_MIGRE_ANO_CCS = "Dossier migré en anomalie Calcul";
  public static final String ERR_CALCUL_MISE_A_JOUR_PBJC_DROIT_NEUTRALISE = "HG_PR_CALI_L_CAL_MISE_A_JOUR_PBJC_DROIT_NEUTRALISE";
  public static final String LIB_CALCUL_MISE_A_JOUR_PBJC_DROIT_NEUTRALISE = "Impossible de mettre à jour les PBJC d'un droit neutralisé (%ARG%)";
  public static final String ERR_CALCUL_DJI_MANQUANT_SUR_CALENDRIER_EXECUTION = "HG_PR_CALI_L_CAL_DJI_MANQUANT_SUR_CAL_EXECUTION";
  public static final String LIB_CALCUL_DJI_MANQUANT_SUR_CALENDRIER_EXECUTION = "Dernier Jour Indemnisé manquant sur calendrier d'exécution";
  public static final String ERR_CALCUL_ECHEC_EXECUTION_AVANT = "HG_PR_CALI_L_CALCUL_ECHEC_EXECUTION_AVANT";
  public static final String LIB_CALCUL_ECHEC_EXECUTION_AVANT = "Echec lors de l'exécution de l'avant";
  public static final String ERR_CALCUL_PEC_NON_TROUVEE_POUR_ATTRIBUTION = "HG_PR_CALI_L_CALCUL_PEC_NON_TROUVEE_ATTRIB";
  public static final String LIB_CALCUL_PEC_NON_TROUVEE_POUR_ATTRIBUTION = "Aucune PEC trouvée pour l'attribution du (%ARG%)";
  public static final String ERR_CALCUL_DERNIER_JOUR_AVANT_MANQUANT_SUR_RESULTAT = "HG_PR_CALI_L_CAL_DERNIER_JOUR_AV_MANQUANT_RESULTAT";
  public static final String LIB_CALCUL_DERNIER_JOUR_AVANT_MANQUANT_SUR_RESULTAT = "Dernier jour de l'avant manquant sur résultat exécution avant";
  public static final String ERR_INDIVIDU_GAEC_NON_CHARGE = "HG_PR_CALI_L_ERR_INDIVIDU_GAEC_NON_CHARGE";
  public static final String LIB_INDIVIDU_GAEC_NON_CHARGE = "L'individu GAEC n'a pas été chargé en début de service.";
  public static final String ERR_RECEPTION_FLUX_V1_DATE_REEXECUTION_NULLE = "HG_PR_CALI_L_RECEPTION_FLUX_V1_DATE_REEXE_NULLE";
  public static final String LIB_RECEPTION_FLUX_V1_DATE_REEXECUTION_NULLE = "Réception du flux %ARG% avec une date de réexécution nulle.";
  public static final String ERR_FLUX_RETOUR_DAL_DEMANDE_V1_NON_RETOURNEE = "HG_PR_CALI_L_FLUX_RETOUR_DAL_DMD_V1_NON_RETOURNEE";
  public static final String LIB_FLUX_RETOUR_DAL_DEMANDE_V1_NON_RETOURNEE = "Le service Demande V1 n'a pas retourné la dal associé à la demande %ARG%.";
  public static final String ERR_PRODUIT_NON_ACTIF_DATE_EXAMEN = "HG_PR_CALI_L_PRODUIT_NON_ACTIF_DATE_EXAMEN";
  public static final String LIB_PRODUIT_NON_ACTIF_DATE_EXAMEN = "Liquidation impossible, le produit %ARG% n'est pas actif à la date d'examen du %ARG%. Classez la demande sans objet.";
  public static final String ERR_EVENEMENT_REFERENCE_EXAMEN_NON_REFERENCE = "HG_PR_CALI_L_ERR_EVEN_REF_EXAMEN_NON_REFERENCE";
  public static final String LIB_EVENEMENT_REFERENCE_EXAMEN_NON_REFERENCE = "Erreur : la demande ne contient pas d'évènement référence examen.";
  public static final String ERR_GAMME_NON_GEREE_LIQUIDATION = "HG_PR_CALI_L_ERR_GAMME_NON_GEREE_LIQ";
  public static final String LIB_GAMME_NON_GEREE_LIQUIDATION = "Erreur : la gamme reçue sur la demande V1 n'est pas gérée par liquidation.";
  public static final String ERR_OCCASIONNEL_INSCRIPTION_POPULATION = "HG_PR_CALI_L_ERR_OCCAS_INSCRIPTION_POP";
  public static final String LIB_OCCASIONNEL_INSCRIPTION_POPULATION = "Erreur : Tentative d'inscription d'une population ou d'une liste population avec un identifiant déjà existant";
  public static final String ERR_OCCASIONNEL_INSCRIPTION_COMPORTEMENT_LIQUIDATION = "HG_PR_CALI_L_OCCASL_INSC_COMPORTEMENT_LIQ";
  public static final String LIB_OCCASIONNEL_INSCRIPTION_COMPORTEMENT_LIQUIDATION = "Erreur produit lors de la récupération des élements de comparaison à exclure pour le comportement occasionnel liquidation";
  public static final String ERR_OCCASIONNEL_DECIDEUR_INDISPONIBLE = "HG_PR_CALI_L_OCCAS_OCCAS_DECIDEUR_INDISPONIBLE";
  public static final String LIB_OCCASIONNEL_DECIDEUR_INDISPONIBLE = "Au décideur associé au comportement de liquidation actuel. Impossible de poursuivre le traitement";
  public static final String ERR_CONTEXTE_INITIAL_NON_VALIDE = "HG_PR_CALI_L_CONTEXTE_INITIAL_NON_VALIDE";
  public static final String LIB_CONTEXTE_INITIAL_NON_VALIDE = "La %ARG% du %ARG% n'a pas été décisionnée validée.";
  public static final String ERR_CONTEXTE_INITIAL_REEXAMEN = "HG_PR_CALI_L_CONTEXTE_INITIAL_REEXAMEN";
  public static final String LIB_CONTEXTE_INITIAL_REEXAMEN = "La %ARG% du %ARG% est en réexamen.";
  public static final String ERR_PLUS_D_UN_REGLEMENT_VALIDE_QUALIF_AUTO = "HG_PR_CALI_L_ERR_PLUS_D_UN_REGLEMENT_VALIDE_AUTO";
  public static final String LIB_PLUS_D_UN_REGLEMENT_VALIDE_QUALIF_AUTO = "Erreur : plus d'un règlement valide a été trouvé lors de la qualif. auto. d'une période";
  public static final String ERR_INIT_COMPTE_RENDU = "HG_PR_CALI_L_INIT_COMPTE_RENDU";
  public static final String LIB_INIT_COMPTE_RENDU = "Impossible d'initialiser le compte-rendu de suivi des modifications de l'individu";
  public static final String ERR_CONTEXTE_ABSENCE_DEMANDE = "HG_PR_CALI_L_ERR_CTX_ABS_DEMANDE";
  public static final String LIB_CONTEXTE_ABSENCE_DEMANDE = "Une demande est obligatoire pour ce produit.";
  public static final String ERR_CONTEXTE_CHGT_ETAT_DOSSIER_EXAMEN = "HG_PR_CALI_L_ERR_CTX_CHGT_DOS_EXAMEN";
  public static final String LIB_CONTEXTE_CHGT_ETAT_DOSSIER_EXAMEN = "Impossible de changer l'etat du dossier d'examen vers le nouvel etat";
  public static final String LIB_LIDONOTFOUNDEXCEPTION_RAFRAICHIR_DOSSIER = "Erreur lors de l'accès aux données : veuillez rafraichir le dossier";
  public static final String LIB_LIDOOPTIMISTICEXCEPTION_RAFRAICHIR_DOSSIER = "Erreur lors d'un accès concurrent aux données : veuillez rafraichir le dossier";
  public static final String ERR_CLASSE_NON_TROUVEE = "HG_PR_CALI_L_ERR_GENERIQUE_CLASSE_NON_TROUVE";
  public static final String LIB_CLASSE_NON_TROUVEE = "Classe non trouvee";
  public static final String ERR_PARCOURS_NULL = "HG_Pas de parcours pour cette population";
  public static final String LIB_PARCOURS_NULL = "Pas de parcours pour cette population";
  public static final String ERR_CONTEXTE_ABSENCE_OD = "HG_PR_CALI_L_ERR_CTX_ABS_OD";
  public static final String LIB_CONTEXTE_ABSENCE_OD = "Une Od est obligatoire pour ce produit.";
  public static final String ERR_CONTEXTE_ABSENCE_FCT_PRINCIPALE = "HG_PR_CALI_L_CTX_ABS_FCT_PRINCIPALE_AVEC_DATE";
  public static final String LIB_CONTEXTE_ABSENCE_FCT_PRINCIPALE = "Attention deux FCT au %ARG%, il faut sélectionner une FCT principale.";
  public static final String ERR_CONTEXTE_ERE_NON_GERE = "HG_PR_CALI_L_ERR_ERE_NON_GERE";
  public static final String LIB_CONTEXTE_ERE_NON_GERE = "Evènement référence examen non géré, classer la demande sans objet";
  public static final String ERR_CONTEXTE_DAL_PRESCRITE = "HG_PR_CALI_L_ERR_DAL_PRESCRITE";
  public static final String LIB_CONTEXTE_DAL_PRESCRITE = "Demande prescrite. Classez la demande sans objet";
  public static final String ERR_CONTEXTE_DAL_NON_RECEVABLE = "HG_PR_CALI_L_ERR_DAL_NON_RECEVABLE";
  public static final String LIB_CONTEXTE_DAL_NON_RECEVABLE = "Demande non liquidable : DAL non recevable.";
  public static final String ERR_CONTEXTE_DATE_EXAMEN_PAS_PEC_INDEMNISABLE_SO = "HG_PR_CALI_L_ERR_DATE_EXAMEN_PAS_PEC_INDEMN_SO";
  public static final String LIB_CONTEXTE_DATE_EXAMEN_PAS_PEC_INDEMNISABLE_SO = "Contexte invalide pour la demande, impossible de trouver une PEC indemnisable à partir du %ARG%. Classez la demande sans objet";
  public static final String ERR_CONTEXTE_DATE_EXAMEN_NON_DETERMINEE = "HG_PR_CALI_L_ERR_DATE_EXAMEN_NON_DETERMINEE";
  public static final String LIB_CONTEXTE_DATE_EXAMEN_NON_DETERMINEE = "La détermination de la date examen est impossible, classer la demande sans objet";
  public static final String ERR_CALCUL_RSOD = "HG_PR_CALI_L_ERR_CALCUL_RSOD";
  public static final String LIB_CALCUL_RSOD = "Liquidation impossible (problème technique) : l'identifiant %ARG% existe déjà pour l'attribution du %ARG%";
  public static final String ERR_POPULATION_NON_PRESENTE = "HG_PR_CALI_L_ERR_POPULATION_NON_PRESENTE";
  public static final String LIB_POPULATION_NON_PRESENTE = "Pas de population.";
  public static final String ERR_CONTEXTE_PEC_INFERIEURE = "HG_PR_CALI_L_ERR_PEC_INFERIEURE";
  public static final String LIB_CONTEXTE_PEC_INFERIEURE = "Demande non valide suite changement de catégorie : classer la demande en sans objet.";
  public static final String ERR_CONTEXTE_PEC_SUPERIEURE = "HG_PR_CALI_L_ERR_PEC_SUPERIEURE";
  public static final String LIB_CONTEXTE_PEC_SUPERIEURE = "PEC (%ARG%) annulée, classer la demande en sans objet.";
  public static final String ERR_CONTEXTE_DEMANDEUR_NON_INSCRIT = "HG_PR_CALI_L_ERR_DEMANDEUR_NON_INSCRIT";
  public static final String LIB_CONTEXTE_DEMANDEUR_NON_INSCRIT = "Le demandeur n'est pas inscrit, classer la demande sans objet";
  public static final String ERR_CONTEXTE_DEMANDEUR_NON_INSCRIT_AVEC_DATE = "HG_PR_CALI_L_ERR_CTX_DEMAND_NON_INSCRIT_AVC_DATE";
  public static final String LIB_CONTEXTE_DEMANDEUR_NON_INSCRIT_AVEC_DATE = "Le demandeur n'est pas inscrit au %ARG%.";
  public static final String ERR_CONTEXTE_ABSENCE_DATE_VALIDATION_FORMATION = "HG_PR_CALI_L_CTX_ABS_DATE_VALIDATION_FORMATION";
  public static final String LIB_CONTEXTE_ABSENCE_DATE_VALIDATION_FORMATION = "La date de validation de la formation n'est pas renseignée";
  public static final String ERR_CALCUL_APPEL_PAR_LIQUIDATION_EXECUTION_INTERROMPUE = "HG_PR_CALI_L_CALCUL_APPEL_PAR_LIQ_EXEC_INTERROMPUE";
  public static final String LIB_CALCUL_APPEL_PAR_LIQUIDATION_EXECUTION_INTERROMPUE = "Calcul : Interruption de l'exécution du Calcul inattendue";
  public static final String ERR_CALCUL_ECHEC_DETERMINATION_DATE_DEBUT_EXECUTION = "HG_PR_CALI_L_CAL_ECHEC_DETERMINAT_DATE_DEBUT_EXEC";
  public static final String LIB_CALCUL_ECHEC_DETERMINATION_DATE_DEBUT_EXECUTION = "Echec lors de la détermination de la date de début d'exécution du calcul";
  public static final String ERR_CONTEXTE_DATES_PERIODES_LIEUX = "HG_PR_CALI_L_CONTEXTE_DATES_PERIODES_LIEUX";
  public static final String LIB_CONTEXTE_DATES_PERIODES_LIEUX = "Dates des périodes lieux non admissibles";
  public static final String ERR_CALCUL_CONTEXTE_DATE_ARRET_EXECUTION_ANTERIEURE_DATE_DECISION = "HG_PR_CALI_L_CAL_CTX_DATE_ARRET_ANTERIEURE_DECIS";
  public static final String LIB_CALCUL_CONTEXTE_DATE_ARRET_EXECUTION_ANTERIEURE_DATE_DECISION = "Contrôle du contexte du calcul : la date d'arrêt de l'exécution est antérieure à la date de la décision";
  public static final String ERR_CALCUL_CONTEXTE_DATE_ARRET_EXECUTION_ANTERIEURE_PJI_DECISION = "HG_PR_CALI_L_CAL_CTX_DATE_ARRET_EXEC_ANTERIEURE";
  public static final String LIB_CALCUL_CONTEXTE_DATE_ARRET_EXECUTION_ANTERIEURE_PJI_DECISION = "Contrôle du contexte du calcul : la date d'arrêt de l'exécution est antérieure au PJI de la décision";
  public static final String ERR_CONTEXTE_ABSENCE_DEMANDE_ASSURANCE = "HG_PR_CALI_L_CONTEXTE_ABSENCE_DEMANDE_ASSURANCE";
  public static final String LIB_CONTEXTE_ABSENCE_DEMANDE_ASSURANCE = "La demande n'existe pas en base";
  public static final String ERR_DATE_NON_SAISIE = "HG_PR_L_DATE_NON_SAISIE";
  public static final String LIB_DATE_NON_SAISIE = "Veuillez saisir une date.";
  public static final String ERR_MOTIF_NON_SAISI = "HG_PR_L_MOTIF_NON_SAISI";
  public static final String LIB_MOTIF_NON_SAISI = "Veuillez sélectionner un motif.";
  public static final String ERR_AIDES_ANCIENNES_MODALITE = "HG_PR_L_AIDES_ANCIENNES_MODALITE";
  public static final String LIB_AIDES_ANCIENNES_MODALITE = "Veuillez créer une aide selon les anciennes modalités.";
  public static final String ERR_AIDES_NOUVELLES_MODALITE = "HG_PR_L_AIDES_NOUVELLES_MODALITE";
  public static final String LIB_AIDES_NOUVELLES_MODALITE = "La création d'une demande AFAF n'est plus possible après le 20/02/2014, sélectionner la demande d'aide à la mobilité.";
  public static final String ERR_DEPOT_POSTERIEUR_DATE_JOUR = "HG_PR_L_DEPOT_POSTERIEUR_DATE_JOUR";
  public static final String LIB_DEPOT_POSTERIEUR_DATE_JOUR = "La date de dépôt ne peut être postérieure à la date du jour.";
  public static final String ERR_CALI_UTILITAIRE_VALEUR_ATTENDUE = "PR_CALI_UTILITAIRE_VALEUR_ATTENDUE";
  public static final String LIB_CALI_UTILITAIRE_VALEUR_ATTENDUE = "Une valeur pour la variable %ARG% est attendue";
  public static final String ERR_CALI_UTILITAIRE_ATTENDUE = "PR_CALI_UTILITAIRE_ATTENDUE";
  public static final String LIB_CALI_UTILITAIRE_ATTENDUE = "La valeur %ARG% est attendue pour la variable %ARG%";
  public static final String ERR_CALI_UTILITAIRE_OBJET_TYPE_ATTENDU = "PR_CALI_OBJET_TYPE_ATTENDUE";
  public static final String LIB_CALI_UTILITAIRE_OBJET_TYPE_ATTENDU = "Un objet de type %ARG% est attendue";
  public static final String ERR_CALI_OBJET_NON_TROUVEE = "PR_CALI_OBJET_NON_TROUVEE";
  public static final String LIB_CALI_OBJET_NON_TROUVEE = "%ARG% n'a pas été trouvé%ARG%";
  public static final String ERR_CALI_EXECUTION_A_TORT = "PR_CALI_EXECUTION_A_TORT";
  public static final String LIB_CALI_EXECUTION_A_TORT = "la méthode %ARG% ne doit pas être appelée";
  public static final String ERR_CALI_OBJET_NON_GERE = "PR_CALI_OBJET_NON_GERE";
  public static final String LIB_CALI_OBJET_NON_GERE = "Objet non géré par la méthode %ARG%";
  public static final String ERR_METHODE_NON_IMPLEMENTEE = "HG_PR_L_METHODE_NON_IMPLEMENTEE_ATTRIBUTION";
  public static final String LIB_METHODE_NON_IMPLEMENTEE = "La méthode n'est pas implémentée pour ce type d'attribution.";
  public static final String ERR_LONGUEUR_DATE_APPLICATION = "HG_LONGUEUR_DATE_APPLICATION";
  public static final String LIB_LONGUEUR_DATE_APPLICATION = "Le code (%ARG%) dépasse les 100 caractères autorisés";
  public static final String ERR_NOMBRE_DECOR_REGLEMENTAIRE = "HG_NOMBRE_DECOR_REGLEMENTAIRE";
  public static final String LIB_NOMBRE_DECOR_REGLEMENTAIRE = "Erreur : Plus d'un décor réglementaire a été déterminé";
  public static final String ERR_REGLEMENT_DUREE_REGLEMENTAIRE = "HG_REGLEMENT_DUREE_REGLEMENTAIRE";
  public static final String LIB_REGLEMENT_DUREE_REGLEMENTAIRE = "Durée règlementaire : le règlement n'est pas géré.";
  public static final String ERR_UNITES_DUREE_REGLEMENTAIRE = "HG_UNITES_DUREE_REGLEMENTAIRE";
  public static final String LIB_UNITES_DUREE_REGLEMENTAIRE = "Durée règlementaire : unités d'affiliation incompatibles.";
  public static final String ERR_UNITES_NON_GEREE_DUREE_REGLEMENTAIRE = "HG_UNITES_DUREE2_REGLEMENTAIRE";
  public static final String LIB_UNITES_NON_GEREE_DUREE_REGLEMENTAIRE = "Durée règlementaire : unités d'affiliation non gérée.";
  public static final String ERR_COHERENCE_DATE_DEPOT_INITIALE = "HG_COHERENCE_DATE_DEPOT_INITIALE";
  public static final String LIB_COHERENCE_DATE_DEPOT_INITIALE = "La date de dépot et la reference externe doivent être renseignées ensemble.";
  public static final String ERR_REFERENCE_DEMANDE_EXPRESSE = "HG_REFERENCE_DEMANDE_EXPRESSE";
  public static final String LIB_REFERENCE_DEMANDE_EXPRESSE = "La référence externe ne correspond pas à une demande expresse.";
  public static final String AB_A5AMB1 = "PR_CALI_L_ALERTE_A5AMB1";
  public static final String LIB_A5AMB1 = "Décision impossible : un blocage (MF03) avec une date d'effet antérieure à la demande est installé";
  public static final String AB_A5AMB2 = "PR_CALI_L_ALERTE_A5AMB2";
  public static final String LIB_A5AMB2 = "Décison impossible : blocage actualisation non traité";
  public static final String AB_TRANSFERT = "PR_CALI_L_ALERTE_TRANSFERT";
  public static final String LIB_TRANSFERT = "Droit bloqué par le transfert";
  public static final String AB_ANOMALIE_CALCUL = "PR_CALI_L_ALERTE_ANOMALIE_CALCUL";
  public static final String LIB_ANOMALIE_CALCUL = "Décision impossible : une anomalie Calcul avec une date d'effet antérieure à la demande existe";
  public static final String AB_A2MB2 = "A2MB2";
  public static final String LIB_A2MB2 = "La date doit être supérieure ou égale au %ARG%";
  public static final String AB_A2MB3 = "A2MB3";
  public static final String LIB_A2MB3 = "La demande ne relève pas de la compétence de Pôle emploi, classer la demande en sans objet";
  public static final String AB_A2MB4 = "A2MB4";
  public static final String LIB_A2MB4 = "Une décision AER n'est pas possible, classer la demande en sans objet";
  public static final String AB_A4MB1 = "A4MB1";
  public static final String LIB_A4MB1 = "Décision impossible : Aucune catégorie n'a été sélectionnée sur la demande ATA du %ARG%";
  public static final String AB_A4MB2 = "A4MB2";
  public static final String LIB_A4MB2 = "Une décision ATA n'est pas possible avant le 16/11/06, classer la demande en sans objet";
  public static final String AB_A4MB3 = "A4MB3";
  public static final String LIB_A4MB3 = "Le reliquat AEPE est épuisé, classer la demande en sans objet";
  public static final String AB_A4MB4 = "A4MB4";
  public static final String LIB_A4MB4 = "Le reliquat AEPE est déchu, classer la demande en sans objet";
  public static final String AB_A4MB5 = "A4MB5";
  public static final String LIB_A4MB5 = "Le reliquat AEPE est éteint, classer la demande en sans objet";
  public static final String AB_A5MB1 = "A5MB1";
  public static final String LIB_A5MB1 = "Le DE n'est pas inscrit à la date du %ARG%, classer la demande en sans objet";
  public static final String AB_A5MB2 = "A5MB2";
  public static final String LIB_A5MB2 = "Le DE n'est pas apte physiquement à la date du %ARG%, classer la demande en sans objet";
  public static final String AB_A5MB3 = "A5MB3";
  public static final String LIB_A5MB3 = "Décision impossible : absence du nombre de trimestres";
  public static final String AB_A5MB4 = "A5MB4";
  public static final String LIB_A5MB4 = "Le DE a atteint l'âge de la retraite au %ARG%, classer la demande en sans objet";
  public static final String AB_A5MB5 = "A5MB5";
  public static final String LIB_A5MB5 = "La condition des ressources n'est pas remplie, classer la demande en sans objet";
  public static final String AB_A5MB6 = "A5MB6";
  public static final String LIB_A5MB6 = "Le DE bénéficie d'une allocation incompatible avec l'AEPE, classer la demande en sans objet";
  public static final String AB_A5MB7 = "A5MB7";
  public static final String LIB_A5MB7 = "Le DE bénéficie d'une prestation familiale incompatible avec l'AEPE, classer la demande en sans objet";
  public static final String AB_A11MB12 = "PR_CALI_L_ALERTE_A11MB12";
  public static final String LIB_A11MB12 = "Le paramètre %ARG% n'existe pas pour la date : %ARG%";
  public static final String AB_A6MB7 = "PR_CALI_L_ALERTE_A6MB7";
  public static final String LIB_A6MB7 = "Décision impossible : date d'engagement de la procédure de licenciement antérieure au %ARG%, à traiter dans Aladin";
  public static final String AB_A6MB8 = "PR_CALI_L_ALERTE_A6MB8";
  public static final String LIB_A6MB8 = "Décision impossible : date de rupture du contrat de travail antérieure au %ARG%, à traiter dans Aladin";
  public static final String ANB_AIS_AUTOMATISE = "ALERTE_AIS_AUTOMATISE";
  public static final String ANB_AD1MNB1 = "AD1MNB1";
  public static final String ANB_A8MNB1 = "A8MNB1";
  public static final String ANB_A16MNB2 = "A16MNB2";
  public static final String ANB_A13MNB1 = "A13MNB1";
  public static final String ANB_SIMU_LIQ_REEXAMEN = "REEXAMEN";
  public static final String ANB_SORTIE_CSP = "ERR_PR_CALI_P_ALERTE_SORTIE_CSP";
  
  protected GestionnaireErreur()
  {
    libelleCodesErreurs = new HashMap();
  }
  
  private String creerMessageParametres(String codeErreur, Object[] args)
  {
    String message = (String)libelleCodesErreurs.get(codeErreur);
    if (args != null) {
      for (int i = 0; i < args.length; i++)
      {
        String param;
        String param;
        if (args[i] == null) {
          param = "?";
        } else {
          param = args[i].toString();
        }
        message = message.replaceFirst("%ARG%", param);
      }
    }
    return message;
  }
  
  public String getLibelleErreur(String codeErreur)
  {
    String message = (String)libelleCodesErreurs.get(codeErreur);
    if (message != null) {
      message = message.replaceAll("%ARG%", "?");
    }
    return message;
  }
  
  public void genererCoucheLogiqueException(String codeErreur, Object[] args)
    throws CoucheLogiqueException
  {
    throw new CoucheLogiqueException(codeErreur, creerMessageParametres(codeErreur, args));
  }
  
  public void genererCoucheLogiqueException(String codeErreur, Object[] args, Map parametres)
    throws CoucheLogiqueException
  {
    CoucheLogiqueException exception = new CoucheLogiqueException(codeErreur, creerMessageParametres(codeErreur, args));
    exception.setParametres(parametres);
    throw exception;
  }
  
  public void genererCoucheLogiqueException(String codeErreur)
    throws CoucheLogiqueException
  {
    String message = (String)libelleCodesErreurs.get(codeErreur);
    throw new CoucheLogiqueException(codeErreur, message);
  }
  
  public void genererCoucheLogiqueException(String codeErreur, String message)
    throws CoucheLogiqueException
  {
    throw new CoucheLogiqueException(codeErreur, message);
  }
  
  public void genererCoucheLogiqueException(String codeErreur, Throwable exception)
    throws CoucheLogiqueException
  {
    String message = null;
    if ((exception instanceof ApplicativeException))
    {
      String codeErreurException = ((ApplicativeException)exception).getCode();
      if (codeErreurException != null) {
        message = ((ApplicativeException)exception).getLibelle();
      }
      if ((message == null) && (codeErreurException != null)) {
        message = (String)libelleCodesErreurs.get(codeErreurException);
      }
      if (message == null) {
        message = (String)libelleCodesErreurs.get(codeErreur);
      }
    }
    else
    {
      message = exception.toString();
    }
    throw new CoucheLogiqueException(codeErreur, message, exception);
  }
  
  public void genererException(String codeErreur, Object[] args, int typeException)
    throws CoucheLogiqueException
  {
    genererException(codeErreur, creerMessageParametres(codeErreur, args), typeException);
  }
  
  public void genererException(String codeErreur, int typeException)
    throws CoucheLogiqueException
  {
    String message = (String)libelleCodesErreurs.get(codeErreur);
    genererException(codeErreur, message, typeException);
  }
  
  public void genererException(String codeErreur, String message, int typeException)
    throws CoucheLogiqueException
  {
    switch (typeException)
    {
    case 3: 
      throw new ApplicativeRuntimeException(codeErreur, message);
    case 2: 
      throw new PasAssezInformationException(codeErreur, message);
    case 1: 
      throw new ContexteException(codeErreur, message);
    }
    throw new CoucheLogiqueException(codeErreur, message);
  }
  
  public static synchronized GestionnaireErreur getInstance()
    throws CoucheLogiqueException
  {
    if (instance == null) {
      initialiserInstance();
    }
    return instance;
  }
  
  private static void initialiserInstance()
    throws CoucheLogiqueException
  {
    instance = new GestionnaireErreur();
    Map<String, String> map = instance.getMapCodesErreurs();
    completerListe(instance.getClass(), null, map);
    
    Iterator<?> i = Parametres.getGammes().iterator();
    while (i.hasNext())
    {
      GammeSpec gamme = (GammeSpec)i.next();
      if (gamme.getClassGestionnaireErreur() != null) {
        completerListe(gamme.getClassGestionnaireErreur(), gamme.getNomUnique(), map);
      }
    }
  }
  
  private static void completerListe(Class classErreurs, String prefixe, Map<String, String> map)
    throws CoucheLogiqueException
  {
    try
    {
      Field[] listeChamps = classErreurs.getDeclaredFields();
      for (int i = 0; i < listeChamps.length; i++)
      {
        Field champCourant = listeChamps[i];
        if ((!champCourant.isSynthetic()) && (!estChampIgnore(champCourant.getName())))
        {
          String nom = champCourant.getName();
          Object obj = champCourant.get(null);
          if ((obj instanceof String))
          {
            String valeur = (String)obj;
            
            traiterCodeErreur(classErreurs, prefixe, map, nom, valeur);
          }
          else
          {
            throw new CoucheLogiqueException("ERR_GESTIONNAIRE_FORMAT", "Le champs est mal formaté : " + nom);
          }
        }
      }
    }
    catch (IllegalArgumentException ex)
    {
      throw new CoucheLogiqueException("ERR_GESTIONNAIRE_ERREUR_REFLEXION", "Erreur lors de la reflexion - IllegalArgumentException");
    }
    catch (IllegalAccessException ex)
    {
      throw new CoucheLogiqueException("ERR_GESTIONNAIRE_ERREUR_REFLEXION2", "Erreur lors de la reflexion - IllegalAccessException");
    }
  }
  
  private static void traiterCodeErreur(Class classErreurs, String prefixe, Map<String, String> map, String nom, String valeur)
    throws CoucheLogiqueException, IllegalAccessException
  {
    if ((nom.startsWith("ERR_")) || (nom.startsWith("AB_")) || (nom.startsWith("ANB_")))
    {
      verifierLongueurCode(nom, valeur);
      if ((nom.startsWith("ERR_")) || (nom.startsWith("AB_"))) {
        inscrireNouveauCodeErreur(classErreurs, prefixe, map, nom, valeur);
      }
    }
    else if (!nom.startsWith("LIB_"))
    {
      throw new CoucheLogiqueException("ERR_GESTIONNAIRE_FORMAT", "Le champs est mal formaté : " + nom);
    }
  }
  
  private static void inscrireNouveauCodeErreur(Class classErreurs, String prefixe, Map<String, String> map, String nom, String valeur)
    throws CoucheLogiqueException, IllegalAccessException
  {
    if ((prefixe != null) && (!valeur.startsWith(prefixe))) {
      throw new CoucheLogiqueException("ERR_GESTIONNAIRE_PREFIXE", "Le libellé n'est pas prefixé " + prefixe + " | " + nom);
    }
    String nomLibelle;
    String nomLibelle;
    if (nom.startsWith("ERR_")) {
      nomLibelle = nom.replaceFirst("ERR_", "LIB_");
    } else {
      nomLibelle = nom.replaceFirst("AB_", "LIB_");
    }
    try
    {
      Field champLibelle = classErreurs.getDeclaredField(nomLibelle);
      String libelle = (String)champLibelle.get(null);
      if (map.get(valeur) != null) {
        throw new CoucheLogiqueException("ERR_GESTIONNAIRE_CODE_DOUBLE", "Un CodeErreur est en double : " + valeur);
      }
      map.put(valeur, libelle);
    }
    catch (NoSuchFieldException ex)
    {
      throw new CoucheLogiqueException("ERR_GESTIONNAIRE_CODE_SOLITAIRE", "Un CodeErreur n'a pas de libellé associé : " + nom);
    }
  }
  
  private static void verifierLongueurCode(String nom, String valeur)
    throws CoucheLogiqueException
  {
    if (valeur.length() > 50) {
      throw new CoucheLogiqueException("ERR_GESTIONNAIRE_ERREUR_TAILLE_MAX", "Un code d'erreur dépasse les 50 caractères : " + nom);
    }
  }
  
  private static boolean estChampIgnore(String nom)
  {
    return (nom.equals("instance")) || (nom.equals("libelleCodesErreurs"));
  }
  
  public Map<String, String> getMapCodesErreurs()
  {
    return libelleCodesErreurs;
  }
}

/* Location:
 * Qualified Name:     GestionnaireErreur
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */