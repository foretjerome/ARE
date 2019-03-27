package fr.unedic.cohabitation.sigma.migration.dom;

import fr.unedic.util.Quantite;
import fr.unedic.util.UniteMonaitaire;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;
import java.util.HashMap;

public class ConstantesMigration
{
  public static final int DEFAULT_INT = -1;
  public static final String DEFAULT_STRING = "";
  public static final String VALEUR_NC = "NC";
  public static final String DEMANDE_ASU = "Demande d'Assurance ";
  public static final String DEMANDE_SOL = "Demande de Solidarité ";
  public static final String DEMANDE_FOR = "Demande de Formation ";
  public static final String DEMANDE_RBF = "Demande de Rbf ";
  public static final int TYPE_DEMANDE_IDE = 5;
  public static final int CODE_NATURE_DECISION_ADMISSION = 10;
  public static final int CODE_NATURE_DECISION_ADMISSION_RENOUVELLEMENT = 7;
  public static final int CODE_NATURE_DECISION_ADMISSION_REMISE_EN_COURS = 8;
  public static final int CODE_NATURE_DECISION_READMISSION_PRECEDENT = 11;
  public static final int CODE_NATURE_DECISION_READMISSION_COURANT = 12;
  public static final int CODE_NATURE_DECISION_READMISSION_RESULTANT = 26;
  public static final int CODE_NATURE_DECISION_ADMISSION_MAINTIEN = 23;
  public static final int CODE_NATURE_DECISION_ADMISSION_ATTENTE_CP = 24;
  public static final int CODE_NATURE_DECISION_ADMISSION_ABSENCE_INFO = 25;
  public static final int CODE_NATURE_DECISION_ADMISSION_PREVISIONNELLE = 21;
  public static final int CODE_NATURE_DECISION_ADMISSION_EFFECTIVE = 22;
  public static final int CODE_NATURE_DECISION_REPRISE = 3;
  public static final int CODE_NATURE_DECISION_REPRISE_DROIT_COMMUN = 13;
  public static final int CODE_NATURE_DECISION_REPRISE_CONTEXTUELLE = 14;
  public static final int CODE_NATURE_DECISION_REPRISE_SYSTEMATIQUE = 15;
  public static final int CODE_NATURE_DECISION_REJET = 16;
  public static final int CODE_NATURE_DECISION_REJET_NON_RENOUVELLEMENT = 17;
  public static final int CODE_NATURE_DECISION_REJET_NON_REMISE_EN_COURS = 18;
  public static final int CODE_NATURE_DECISION_REJET_ECHEC = 19;
  public static final int CODE_NATURE_DECISION_CLASSEE = 20;
  public static final int CARACTERE_NON_SAISONNIER = 0;
  public static final int CARACTERE_SAISONNIER_RYTHME = 1;
  public static final int CARACTERE_SAISONNIER_NATURE = 2;
  public static final String CLASSEMENT_ADMINISTRATIF_SANS_SUITE = "CS";
  public static final String CLASSEMENT_ADMINISTRATIF_SANS_OBJET = "SO";
  public static final String CLASSEMENT_ADMINISTRATIF_PRESCRIPTION = "PS";
  public static final String CLASSEMENT_ADMINISTRATIF_SECTEUR_PUBLIC = "SP";
  public static final String CLASSEMENT_ADMINISTRATIF_DEPOT_TARDIF = "DT";
  public static final String UNITE_JOUR = "J";
  public static final String UNITE_VACATION = "V";
  public static final String UNITE_EMBARQUEMENT_ADMINISTRATIF = "E";
  public static final String UNITE_HEURE_TRAVAIL = "H";
  public static final String UNITE_ANNEE = "A";
  public static final Quantite MONTANT_NON_DEFINI = new Quantite(new BigDecimal(-1), UniteMonaitaire.EUROS);
  public static final Periode PERIODE_NON_DEFINI = new Periode(Damj.FIN_DES_TEMPS, Damj.FIN_DES_TEMPS);
  public static final String PRODUIT_ASU_ARE2003_CGE = "ASU_CGE01_02";
  public static final String PRODUIT_ASU_ARE2006_CGE = "ASU_CGE01_03";
  public static final String PRODUIT_ASU_EXPAT = "ASU_EXP03_01";
  public static final String PRODUIT_ASU_ARE2009_CGE = "ASU_CGE01_04";
  public static final String PRODUIT_ASU_CSA_ARE2003 = "ASU_CSA06_01";
  public static final String PRODUIT_ASU_CSA_ARE2006 = "ASU_CSA06_02";
  public static final String PRODUIT_SOL_ASS2004 = "SOL_CGE01_01";
  public static final String PRODUIT_SOL_ASS2004_CPAR = "SOL_CPA02_01";
  public static final String PRODUIT_SOL_AER = "SOL_AER05_01";
  public static final String PRODUIT_SOL_ATA06_01 = "SOL_ATA06_01";
  public static final String PRODUIT_FOR_AFF2001 = "FOR_AFF03_01";
  public static final String NC = "NC";
  public static final String PRODUIT_ASU_EXP03_01 = "ASU_EXP03_01";
  public static final String PRODUIT_ASU_CSA_ARE2009 = "ASU_CSA06_03";
  public static final String PRODUIT_ASU_SPE02_03 = "ASU_SPE02_03";
  public static final String CODE_PRODUIT_ASU_ARE2003_CGE = "1";
  public static final String CODE_PRODUIT_ASU_ARE2006_CGE = "2";
  public static final String CODE_PRODUIT_ASU_CSA_ARE2003 = "3";
  public static final String CODE_PRODUIT_ASU_CSA_ARE2006 = "4";
  public static final String CODE_PRODUIT_SOL_ASS2004 = "5";
  public static final String CODE_PRODUIT_SOL_ASS2004_CPAR = "6";
  public static final String CODE_PRODUIT_SOL_AER = "7";
  public static final String CODE_PRODUIT_FOR_AFF2001 = "8";
  public static final String CODE_PRODUIT_INCONNU = "0";
  public static final String CODE_PRODUIT_ASU_SPE02_03 = "9";
  public static final String CODE_PRODUIT_ASU_ARE2009_CGE = "10";
  public static final String CODE_PRODUIT_SOL_ATA06_01 = "11";
  private static final String CODE_PRODUIT_ASU_CSA_ARE2009 = "12";
  private static final String CODE_PRODUIT_ASU_EXP03_01 = "13";
  public static HashMap s_libelleCodeProduit = new HashMap();
  public static final int NIVEAU_CALENDRIER = 0;
  public static final int NIVEAU_UNITE_TRAITEMENT = 1;
  public static final int NIVEAU_SOMME = 2;
  public static final int NIVEAU_TOTAL = 3;
  public static final int STATUT_ATTENTE_JUSTIFICATIF = 1;
  public static final int STATUT_PAIEMENT_PAR_AVANCE = 2;
  public static final int STATUT_DEFINITIF = 3;
  public static final int NEUTRALISATION_AUCUNE = 0;
  public static final int NEUTRALISATION_HEURE = 1;
  public static final int NEUTRALISATION_GAIN = 2;
  public static final int NEUTRALISATION_GAIN_HEURE = 3;
  public static final int NEUTRALISATION_CUMUL = 4;
  public static final int NEUTRALISATION_ATTENTE_JUSTIFICATION = 5;
  public static final int NEUTRALISATION_PRESENCE_TRAVAIL = 6;
  public static final int NEUTRALISATION_REPRISE_AR_MEME_EMPLOYEUR = 7;
  public static final int NEUTRALISATION_CUMUL_ET_HEURE = 8;
  public static final int TYPE_MONTANT_NORMAL = 0;
  public static final int TYPE_MONTANT_AREF_PREVISIONNELLE = 11;
  public static final int TYPE_MONTANT_AREF_EFFECTIVE = 12;
  public static final int TYPE_MONTANT_RPS_REEL = 21;
  public static final int TYPE_MONTANT_RPS_FORFAIT = 22;
  public static final int TYPE_MONTANT_AER_COMPLEMENT = 31;
  public static final int TYPE_MONTANT_AER_REMPLACEMENT = 32;
  
  static
  {
    s_libelleCodeProduit.put("ASU_CGE01_02", "1");
    s_libelleCodeProduit.put("ASU_CGE01_03", "2");
    s_libelleCodeProduit.put("ASU_CSA06_01", "3");
    s_libelleCodeProduit.put("ASU_CSA06_02", "4");
    s_libelleCodeProduit.put("SOL_CGE01_01", "5");
    s_libelleCodeProduit.put("SOL_CPA02_01", "6");
    s_libelleCodeProduit.put("SOL_AER05_01", "7");
    s_libelleCodeProduit.put("FOR_AFF03_01", "8");
    s_libelleCodeProduit.put("NC", "0");
    
    s_libelleCodeProduit.put("ASU_SPE02_03", "9");
    
    s_libelleCodeProduit.put("ASU_CGE01_04", "10");
    
    s_libelleCodeProduit.put("SOL_ATA06_01", "11");
    s_libelleCodeProduit.put("ASU_CSA06_03", "12");
    s_libelleCodeProduit.put("ASU_SPE02_03", "9");
    s_libelleCodeProduit.put("ASU_CGE01_04", "10");
    s_libelleCodeProduit.put("ASU_EXP03_01", "13");
  }
}

/* Location:
 * Qualified Name:     ConstantesMigration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */