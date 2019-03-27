package fr.unedic.cali.autresdoms.cohab.sigma.demande.dom.spec;

import fr.unedic.util.temps.Damj;

public abstract interface DemandeSpec
{
  public static final String ORIGINE_INSCRIPTION = "INS";
  public static final String ORIGINE_ECHEANCE = "ECH";
  public static final String ORIGINE_DEMANDE_EXPRESS = "EXP";
  public static final String ORIGINE_RENOUVELLEMENT = "REN";
  public static final String GAMME_ASSURANCE = "ASU";
  public static final String GAMME_SOLIDARITE = "SOL";
  public static final String GAMME_FORMATION = "FOR";
  public static final String GAMME_MAINTIEN = "MNT";
  public static final String LIGNE_ALLOC_RETOUR_EMPLOI = "ASU_CGE01";
  public static final String LIGNE_ALLOC_SPECIFIQUE_SOLIDARITE = "SOL_CGE01";
  public static final String LIGNE_REGIME_STAGIAIRE_PUBLIC = "FOR_RPS02";
  public static final String LIGNE_ALLOC_INSERTION = "SOL_AIG03";
  public static final String LIGNE_ALLOC_EQUIVALENT_RETRAITE = "SOL_AER05";
  public static final String LIGNE_CAS_GENERAL = "ASU_CGE01";
  public static final String LIGNE_SPECTACLE = "ASU_SPE02";
  public static final String LIGNE_CATEGORIE_PARTICUILIERE = "SOL_CPA02";
  public static final String LIGNE_ATA06 = "SOL_ATA06";
  public static final String LIGNE_RFPE = "FOR_RFP04";
  public static final String PRODUIT_ARE2001_CGE = "ASU_CGE01_01";
  public static final String PRODUIT_ARE2003_CGE = "ASU_CGE01_02";
  public static final String PRODUIT_ARE2004_SPE = "ASU_SPE02_01";
  public static final String PRODUIT_ARE2005_SPE = "ASU_SPE02_02";
  public static final String PRODUIT_ARE2003_EXP = "ASU_EXP03_01";
  public static final String PRODUIT_ARE2003_CSR = "ASU_CSR04_01";
  public static final String PRODUIT_ARE_EURO = "ASU_EUR05_01";
  public static final String PRODUIT_C_SAUVEGARDE = "ASU_CSA06_01";
  public static final String PRODUIT_FSP2004 = "ASU_FSP07_01";
  public static final String PRODUIT_DECES_ASSUR = "ASU_DEC08_01";
  public static final String PRODUIT_MAINTIEN = "ASU_MNT09_01";
  public static final String PRODUIT_ASS2004 = "SOL_CGE01_01";
  public static final String PRODUIT_ASS2004_CPAR = "SOL_CPA02_01";
  public static final String PRODUIT_ATA06 = "SOL_ATA06_01";
  public static final String PRODUIT_AI84_GENE = "SOL_AIG03_01";
  public static final String PRODUIT_AI84_ASILE = "SOL_AIA04_01";
  public static final String PRODUIT_AER = "SOL_AER05_01";
  public static final String PRODUIT_ATS = "SOL_AER05_02";
  public static final String PRODUIT_DECES_SOL = "SOL_DEC06_01";
  public static final String PRODUIT_P_FIN_ANNEE = "SOL_PFA07_01";
  public static final String PRODUIT_A_FIN_DROIT = "SOL_AFD08_01";
  public static final String PRODUIT_RFP04 = "FOR_RFP04_01";
  public static final String PRODUIT_RPS_1991 = "FOR_RPS02_01";
  public static final String PRODUIT_AFF2001 = "FOR_AFF03_01";
  public static final String PRODUIT_ASSF_2004 = "FOR_ASS04_01";
  public static final String PRODUIT_FRAIS_HBT = "RBF_HBT01_01";
  public static final String PRODUIT_FRAIS_TPT = "RBF_TPT02_01";
  public static final String PRODUIT_FRAIS_RTN = "RBF_RTN03_01";
  public static final String PRODUIT_FRAIS_PEDAG = "RBF_FPO04_01";
  public static final String PRODUIT_IT_RPS_1991 = "RBF_ITR05_01";
  public static final String PRODUIT_IH_RPS_1991 = "RBF_IHE06_01";
  public static final String PRODUIT_AIDE_MOBIL = "RBF_AMO06_01";
  public static final String PRODUIT_PRERET_PROG = "PRR_PRP01_01";
  public static final String PRODUIT_PRERET_LIC = "PRR_PRL02_01";
  public static final String PRODUIT_PRERET_DECES = "";
  public static final String PRODUIT_ACO = "";
  public static final String PRODUIT_RET_CONSERV = "";
  public static final String PRODUIT_A_CREA_ENT = "";
  public static final String PRODUIT_A_CONGES_NP = "";
  public static final String PRODUIT_ADE = "";
  public static final String PRODUIT_SOUTIEN_JEUNE = "";
  public static final String PRODUIT_FOR_AVT_EMB = "";
  public static final String ETAT_LIQUIDABLE_OUI = "O";
  public static final String ETAT_LIQUIDABLE_RENDU = "R";
  public static final String ETAT_LIQUIDABLE_CONSERVE = "C";
  public static final String EXAMEN_ASU_SUITE_IDE = "5";
  public static final String EXAMEN_ASU_DEMANDE_EXPRESSE = "8";
  public static final String EXAMEN_ASU_FIN_DROIT_SUITE_REPRISE_NON_SAISONNIERE = "I";
  public static final String EXAMEN_ASU_QUESTIONNAIRE_PASSAGE_CP_SUITE_REJET_DV = "Y";
  public static final String EXAMEN_ASU_DEMANDE_AF_CNE = "U";
  public static final String EXAMEN_FOR_DEMANDE_RSP = "E";
  public static final String EXAMEN_FOR_DEMANDE_RFPE = "E1";
  public static final String EXAMEN_SOL_RENOUVELLEMENT_ASS = "17";
  public static final String EXAMEN_SOL_RENOUVELLEMENT_AER = "34";
  public static final String EXAMEN_SOL_FIN_DROIT_ASU = "6";
  public static final String EXAMEN_SOL_CATEGORIE_PARTICULIERE_SUITE_REJET_ASU = "9";
  public static final String EXAMEN_SOL_DROIT_OPTION_ASS = "N";
  public static final String EXAMEN_SOL_DEMANDE_EXPRESSE_PLUS_DE_50ANS = "2";
  public static final String EXAMEN_SOL_DEMANDE_AER = "P";
  public static final String EXAMEN_SOL_DEMANDE_ATS = "P1";
  public static final String EXAMEN_SOL_REPRISE_SOLIDARITE_SUITE_REJET_ASU = "W";
  public static final String EXAMEN_SOL_REMISE_EN_COURS_ASS = "D";
  public static final String EXAMEN_SOL_REMISE_EN_COURS_ATA = "A1";
  public static final String EXAMEN_SOL_ATA_SUITE_REJET_ASU = "A2";
  public static final String EXAMEN_ASU_DEMANDE_MAINTIEN = "07";
  public static final String EXAMEN_ARE_DEMANDE_EGAREE = "1";
  public static final String EXAMEN_____ASS_SUITE_FIN_SP = "3";
  public static final String EXAMEN_____DEMANDE_FNE = "4";
  public static final String EXAMEN_ASU_REEXAMEN_FD_A8_A10 = "7";
  public static final String EXAMEN_SOL_AI_SUITE_FIN_DROIT_AC = "A";
  public static final String EXAMEN_____DEMANDE_AFR_1 = "C";
  public static final String EXAMEN_SOL_AI_SUITE_FIN_SP = "F";
  public static final String EXAMEN_SOL_EXAMEN_AI_POSTERIEUR_FD_AC = "G";
  public static final String EXAMEN_SOL_EXAMEN_POSTERIEUR_FD_AC = "H";
  public static final String EXAMEN_SOL_REEXAMEN_ANNIVERSAIRE_ANNEXE_4 = "J";
  public static final String EXAMEN_____DEMANDE_ARPE = "K";
  public static final String EXAMEN_____DEMANDE_ARI = "L";
  public static final String EXAMEN_____DEMANDE_ACA = "M";
  public static final String EXAMEN_ASU_DEMANDE_APRE_ANTICIPE = "O";
  public static final String EXAMEN_____DEMANDE_AER_SUITE_FD_AC = "Q";
  public static final String EXAMEN_ASU_DEMANDE_AFT_SUITE_REJET_AC = "R";
  public static final String EXAMEN_____DEMANDE_AES = "S";
  public static final String EXAMEN_ASU_DEMANDE_CRP = "T";
  public static final String EXAMEN_ASU_FIN_DROIT_ASR = "T1";
  public static final String EXAMEN_SOL_DEMANDE_ASS_SUITE_FD_AF = "V";
  public static final String EXAMEN_____DEMANDE_AFR_2 = "X";
  public static final String EXAMEN_____DEMANDE_AFRE_2 = "D";
  public static final String EXAMEN_SOL_DEMANDE_AI_SUITE_FD_AF = "Z";
  public static final String EXAMEN_INR_DEMANDE_ARCE = "21";
  public static final String EXAMEN_INR_DEMANDE_ADR = "26";
  public static final String EXAMEN_SOL_DEMANDE_PTS = "P3";
  public static final String EXAMEN_INR_DEMANDE_PAR = "29";
  public static final String EXAMEN_ASU_DEMANDE_REVISION = "12";
  public static final String EXAMEN_ASU_DEMANDE_RECHARGEMENT = "83";
  public static final String EXAMEN_ASU_DEMANDE_REVISION_2014 = "82";
  public static final String EXAMEN_ASU_DEMANDE_REPRISE_VERSEMENT = "81";
  public static final String EXAMEN_DV_FIL_EAU = "84";
  public static final String EXAMEN_ASU_CLAUSE_RATTRAPAGE_SPECTACLE = "73";
  public static final String EXAMEN_SOL_DEMANDE_ASS_SUITE_DECHEANCE = "61";
  public static final String EXAMEN_APS_SUITE_REJET_ASU = "R3";
  public static final String EXAMEN_AT_AFD_SUITE_REJET_ASU = "R6";
  public static final String EXAMEN_APS_FIN_DROIT_SPECTACLE = "R1";
  public static final String EXAMEN_AT_AFD_FIN_DROIT_SPECTACLE = "R4";
  public static final String EXAMEN_ARE_EFE = "71";
  public static final String EXAMEN_APS_EFE = "R2";
  public static final String EXAMEN_AT_AFD_EFE = "R5";
  public static final String EXAMEN_ASU_DEMANDE_ATP = "T2";
  public static final String EXAMEN_ASU_DEMANDE_ATP_SUITE_BASCULE = "T3";
  public static final String EXAMEN_ASU_DEMANDE_FIN_ATP = "T4";
  public static final String EXAMEN_ASU_DEMANDE_ASSOCIEE = "13";
  public static final String EXAMEN_ASU_DEMANDE_ASP = "T5";
  public static final String EXAMEN_ASU_DEMANDE_FIN_ASP = "T6";
  public static final String EXAMEN_SOL_AEPE_SUITE_REJET_ASS = "A3";
  public static final String EXAMEN_SOL_AEPE_SUITE_REJET_ASU = "A4";
  public static final String EXAMEN_SOL_AEPE_SUIVI = "A5";
  public static final String EXAMEN_FOR_DEMANDE_RPS = "E";
  public static final String EXAMEN_ASU_ANTECEDENT = "72";
  public static final String EXAMEN_ASU_ANTECEDENT_FINDROIT_SP = "31";
  public static final String EXAMEN_SOL_ANTECEDENT = "91";
  public static final String EXAMEN_SOL_MAYOTTE_FIN_DROIT_ASU = "92";
  public static final String EXAMEN_SOL_MAYOTTE_REPRISE = "93";
  public static final String EXAMEN_SOL_MAYOTTE_CPA = "94";
  public static final String EXAMEN_RBF_DAF_ANPE = "10";
  public static final String EXAMEN_RBF_DAF_ASSEDIC = "11";
  public static final String EXAMEN_FOR_DEMANDE_AFF = "7";
  public static final String EXAMEN_RBF_AIDE_MOBILITE = "14";
  public static final String EXAMEN_RBF_AGEPI = "15";
  public static final String EXAMEN_RBF_AIDES_BAN = "16";
  public static final String EXAMEN_ARI_BANALISEE = "18";
  public static final String EXAMEN_PRR_FNE = "4";
  public static final String EXAMEN_DEC = "87";
  public static final String PRESENCE_AE_OUI = "O";
  public static final String PRESENCE_AE_NON = "N";
  public static final String PRESENCE_AE_NON_RENSEIGNE = "";
  public static final String FNE_REFUS = "O";
  public static final String FNE_PAS_DE_REFUS = "N";
  public static final String FNE_PAS_REPONSE = "";
  public static final String PROPOSITION_CRP_FAITE = "O";
  public static final String PROPOSITION_CRP_NON_FAITE = "N";
  public static final String PROPOSITION_CTP_FAITE = "C";
  public static final String PROPOSITION_CTP_NON_FAITE = "T";
  
  public abstract String getGamme();
  
  public abstract String getLigne();
  
  public abstract String getProduit();
  
  public abstract String getTypeExamen();
  
  public abstract Damj getDateDepot();
  
  public abstract Damj getDateDemande();
  
  public abstract String getIdentifiantDemande();
  
  public abstract String getEtatLiquidable();
  
  public abstract String getPresenceAE();
  
  public abstract int getIdentifiantPec();
  
  public abstract int getIdentifiantFormation();
  
  public abstract String getPropositionCrpCtp();
  
  public abstract boolean isDroitCongeReclassement();
  
  public abstract String getRefusFNE();
  
  public abstract void setGamme(String paramString);
  
  public abstract void setLigne(String paramString);
  
  public abstract void setProduit(String paramString);
  
  public abstract void setTypeExamen(String paramString);
  
  public abstract void setDateDepot(Damj paramDamj);
  
  public abstract void setDateDemande(Damj paramDamj);
  
  public abstract void setIdentifiantDemande(String paramString);
  
  public abstract void setEtatLiquidable(String paramString);
  
  public abstract void setPresenceAE(String paramString);
  
  public abstract void setIdentifiantPec(int paramInt);
  
  public abstract void setIdentifiantFormation(int paramInt);
  
  public abstract void setPropositionCrpCtp(String paramString);
  
  public abstract void setDroitCongeReclassement(boolean paramBoolean);
  
  public abstract void setRefusFNE(String paramString);
  
  public abstract int getReferenceRejetDV();
  
  public abstract void setReferenceRejetDV(int paramInt);
  
  public abstract String getNumeroSuivi();
  
  public abstract void setNumeroSuivi(String paramString);
  
  public abstract boolean estEnvoiDalEffectue();
  
  public abstract void setEstEnvoiDalEffectue(boolean paramBoolean);
  
  public abstract boolean estDemandeMandatee();
  
  public abstract String getIdentifiantTiersBeneficiaire();
  
  public abstract String getIdentifiantTiersDemandeur();
  
  public abstract void setEstDemandeMandatee(boolean paramBoolean);
  
  public abstract void setIdentifiantTiersBeneficiaire(String paramString);
  
  public abstract void setIdentifiantTiersDemandeur(String paramString);
  
  public abstract String getDeploiementDalInstruction();
  
  public abstract void setDeploiementDalInstruction(String paramString);
}

/* Location:
 * Qualified Name:     DemandeSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */