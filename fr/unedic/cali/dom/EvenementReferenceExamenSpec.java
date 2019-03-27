package fr.unedic.cali.dom;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Temporel;

public abstract interface EvenementReferenceExamenSpec
  extends Temporel, ObjetPersistantSpec
{
  public static final String LIBELLE_LONG_EVENEMENT_IDE = "demande d'Inscription Demandeur Emploi";
  public static final String LIBELLE_COURT_EVENEMENT_IDE = "IDE";
  public static final String LIBELLE_LONG_EVENEMENT_FIN_DROIT_SPECTACLE = "demande de Fin de droit spectacle";
  public static final String LIBELLE_COURT_EVENEMENT_FIN_DROIT_SPECTACLE = "FIN_DROIT_SPECTACLE";
  public static final String LIBELLE_LONG_EVENEMENT_EXAMEN_DV_122E_JOUR = "demande d'Examen DV au 122ème jour";
  public static final String LIBELLE_COURT_EVENEMENT_EXAMEN_DV_122E_JOUR = "DEX122";
  public static final String LIBELLE_LONG_DEMANDE_EXPRESSE_ASU = "demande expresse ASU";
  public static final String LIBELLE_COURT_DEMANDE_EXPRESSE_ASU = "DEXASU";
  public static final String LIBELLE_LONG_GENERIQUE = "Par défaut";
  public static final String LIBELLE_COURT_GENERIQUE = "GEN_ASU";
  public static final String LIBELLE_LONG_ERE_REPRISE_CONTEXTUELLE = "demande de fin de droit suite reprise non saisonnière";
  public static final String LIBELLE_LONG_EVT_LENDEMAIN_FIN_DUREE = "demande de lendemain fin de durée";
  public static final String LIBELLE_COURT_EVT_LENDEMAIN_FIN_DUREE = "LFD_ASU";
  public static final String LIBELLE_LONG_ERE_DEMANDE_MAINTIEN = "demande de maintien";
  public static final String LIBELLE_LONG_ERE_RETOUR_QUESTIONNAIRE = "Maintien manuel";
  public static final String LIBELLE_COURT_ERE_RETOUR_QUESTIONNAIRE = "MNTMAN";
  public static final String LIBELLE_LONG_REVISION = "demande de Perte act. cons.";
  public static final String LIBELLE_COURT_REVISION = "REV_ASU";
  public static final String LIBELLE_LONG_APS_REJET_ASU = "Demande APS IDE";
  public static final String LIBELLE_COURT_APS_REJET_ASU = "IDE";
  public static final String LIBELLE_LONG_AT_AFD_REJET_ASU = "Demande AT/AFD IDE";
  public static final String LIBELLE_COURT_AT_AFD_REJET_ASU = "IDE";
  public static final String LIBELLE_LONG_APS_FDD = "Demande APS";
  public static final String LIBELLE_COURT_APS_FDD = "EFD";
  public static final String LIBELLE_LONG_AT_AFD_FDD = "Demande AT/AFD";
  public static final String LIBELLE_COURT_AT_AFD_FDD = "EFD";
  public static final String LIBELLE_LONG_ARE_EFE = "Demande Assurance fil de l'eau";
  public static final String LIBELLE_COURT_ARE_EFE = "FDE";
  public static final String LIBELLE_LONG_APS_EFE = "Demande APS fil de l'eau";
  public static final String LIBELLE_COURT_APS_EFE = "FDE";
  public static final String LIBELLE_LONG_AT_AFD_EFE = "Demande AT/AFD fil de l'eau";
  public static final String LIBELLE_COURT_AT_AFD_EFE = "FDE";
  public static final String LIBELLE_LONG_IDE_ASR = "Adhésion CRP";
  public static final String LIBELLE_COURT_IDE_ASR = "IDE";
  public static final String LIBELLE_LONG_FIN_ASR = "Fin CRP";
  public static final String LIBELLE_COURT_FIN_ASR = "FIN ASR";
  public static final String LIBELLE_COURT_IDE_ATP = "IDE";
  public static final String LIBELLE_LONG_IDE_ATP = "Adhésion CTP";
  public static final String LIBELLE_COURT_FIN_ATP = "FIN ATP";
  public static final String LIBELLE_LONG_FIN_ATP = "Fin CTP";
  public static final String LIBELLE_COURT_BASCULE_ATP = "BASCULECTP";
  public static final String LIBELLE_LONG_BASCULE_ATP = "Bascule CRP/CTP";
  public static final String LIBELLE_COURT_FINANCEMENT = "FINANCEMENT";
  public static final String LIBELLE_LONG_FINANCEMENT_ATP = "Financement ATP";
  public static final String LIBELLE_COURT_IDE_ASP = "IDE";
  public static final String LIBELLE_LONG_IDE_ASP = "Adhésion CSP";
  public static final String LIBELLE_COURT_FIN_ASP = "FIN ASP";
  public static final String LIBELLE_LONG_FIN_ASP = "Fin CSP";
  public static final String LIBELLE_COURT_ARI = "ARI";
  public static final String LIBELLE_LONG_ARI = "Ari";
  public static final String LIBELLE_LONG_ARI_BANALISEE = "Demande banalisée";
  public static final String LIBELLE_COURT_ARI_BANALISEE = "ARI_BANALISEE";
  public static final String LIBELLE_LONG_ANTECEDENT = "Saisie antécédent";
  public static final String LIBELLE_COURT_ANTECEDENT = "ANT";
  public static final String LIBELLE_LONG_ANTECEDENT_SP = "Antécédent SP";
  public static final String LIBELLE_COURT_ANTECEDENT_SP = "ANTSO";
  public static final String LIBELLE_LONG_RECHARGEMENT = "Rechargement";
  public static final String LIBELLE_COURT_RECHARGEMENT = "RECHARGT";
  public static final String LIBELLE_LONG_REVISION_2014 = "Demande de Perte act. cons.";
  public static final String LIBELLE_COURT_REVISION_2014 = "REV_2014";
  public static final String LIBELLE_LONG_REPRISE_VERSEMENT = "Demande de Reprise des Versements";
  public static final String LIBELLE_COURT_REPRISE_VERSEMENT = "DRV";
  public static final String LIBELLE_LONG_DV_FIL_EAU = "DV fil de l’eau";
  public static final String LIBELLE_COURT_DV_FIL_EAU = "DV EAU";
  public static final String LIBELLE_LONG_CLAUSE_RATTRAPAGE_SPECTACLE = "Clause de rattrapage Spectacle";
  public static final String LIBELLE_COURT_CLAUSE_RATTRAPAGE_SPECTACLE = "CRA_SPE";
  public static final String LIBELLE_LONG_DEMANDE_EXPRESSE_SOL = "demande expresse ASS";
  public static final String LIBELLE_COURT_DEMANDE_EXPRESSE_SOL = "DEXASS";
  public static final String LIBELLE_LONG_AER = "demande AER";
  public static final String LIBELLE_COURT_AER = "AER";
  public static final String LIBELLE_LONG_ATS = "demande ATS";
  public static final String LIBELLE_COURT_ATS = "ATS";
  public static final String LIBELLE_LONG_REJET_RAC = "Rejet RAC";
  public static final String LIBELLE_COURT_REJET_RAC = "REJET_RAC";
  public static final String LIBELLE_LONG_ERE_SOL_CPA = "demande d'ASS cat. part. suite rejet Asu";
  public static final String LIBELLE_LONG_REJET_RAC_CPA = "Rejet RAC Catégories Particulières";
  public static final String LIBELLE_COURT_REJET_RAC_CPA = "REJET_RAC_CPA";
  public static final String LIBELLE_DROIT_OPTION_ASS = "demande de droit d'option ASS";
  public static final String LIBELLE_LONG_DROIT_OPTION_ASS = "Droit option ASS";
  public static final String LIBELLE_COURT_DROIT_OPTION_ASS = "OPTION_ASS";
  public static final String LIBELLE_LONG_DEMANDE_SUITE_FIN_DROIT_ASU = "demande suite fin droit ASU";
  public static final String LIBELLE_COURT_DEMANDE_SUITE_FIN_DROIT_ASU = "DFINDASU";
  public static final String LIBELLE_LONG_DEMANDE_ASS_SUITE_DECHEANCE = "Demande suite droit ARE déchu";
  public static final String LIBELLE_COURT_DEMANDE_ASS_SUITE_DECHEANCE = "DASSDEC";
  public static final String LIBELLE_LONG_DEMANDE_SUITE_FIN_DROIT_SP = "demande suite fin droit SP";
  public static final String LIBELLE_COURT_DEMANDE_SUITE_FIN_DROIT_SP = "DFINDSP";
  public static final String LIBELLE_LONG_DEMANDE_EXP_SOL_PLUS_50ANS = "demande expresse plus de 50 ans";
  public static final String LIBELLE_COURT_DEMANDE_EXP_SOL_PLUS_50ANS = "SOLDEX50";
  public static final String LIBELLE_LONG_DEMANDE_RENOUVELLEMENT_AER = "demande renouvellement AER";
  public static final String LIBELLE_COURT_DEMANDE_RENOUVELLEMENT_AER = "DRNVAER";
  public static final String LIBELLE_LONG_DEMANDE_RENOUVELLEMENT_ASS = "demande renouvellement ASS";
  public static final String LIBELLE_COURT_DEMANDE_RENOUVELLEMENT_ASS = "DRENASS";
  public static final String LIBELLE_LONG_DEMANDE_REMISE_EN_COURS_ASS = "demande Remise en cours ASS";
  public static final String LIBELLE_COURT_DEMANDE_REMISE_EN_COURS_ASS = "DRECASS";
  public static final String LIBELLE_LONG_DEMANDE_REPRISE_SOL_SUITE_REJET_ASU = "demande reprise solidarité suite rejet ASU";
  public static final String LIBELLE_COURT_DEMANDE_REPRISE_SOL_SUITE_REJET_ASU = "DREPSOLREJASU";
  public static final String LIBELLE_COURT_DEMANDE_RENOUVELLEMENT_ATA = "DRENATA";
  public static final String LIBELLE_LONG_DEMANDE_RENOUVELLEMENT_ATA = "Demande renouvellement ATA";
  public static final String LIBELLE_COURT_DEMANDE_REMISE_EN_COURS_ATA = "DRECATA";
  public static final String LIBELLE_LONG_DEMANDE_REMISE_EN_COURS_ATA = "Demande remise en cours ATA";
  public static final String LIBELLE_COURT_DEMANDE_ATA_SUITE_FIN_DROIT_ASU = "DFINDASU";
  public static final String LIBELLE_LONG_DEMANDE_ATA_SUITE_FIN_DROIT_ASU = "demande suite fin droit ASU";
  public static final String LIBELLE_COURT_DEMANDE_ATA_SUITE_FIN_DROIT_SP = "DFINDSP";
  public static final String LIBELLE_LONG_DEMANDE_ATA_SUITE_FIN_DROIT_SP = "demande suite fin droit SP";
  public static final String LIBELLE_COURT_DEMANDE_ATA_SUITE_IDE = "DIDE";
  public static final String LIBELLE_LONG_DEMANDE_ATA_SUITE_IDE = "Demande suite inscription demandeur emploi";
  public static final String LIBELLE_COURT_DEMANDE_ATA_SUITE_REJET_ASU = "DREPSOLREJASU";
  public static final String LIBELLE_LONG_DEMANDE_ATA_SUITE_REJET_ASU = "demande reprise solidarité suite rejet ASU";
  public static final String LIBELLE_LONG_PTS = "demande PTS";
  public static final String LIBELLE_COURT_PTS = "PTS";
  public static final String LIBELLE_COURT_DEMANDE_AEPE_SUITE_REJET_ASS = "DAEPEREJASS";
  public static final String LIBELLE_LONG_DEMANDE_AEPE_SUITE_REJET_ASS = "Demande AEPE suite rejet ASS";
  public static final String LIBELLE_COURT_DEMANDE_AEPE_SUITE_REJET_ASU = "DREPSOLREJASU";
  public static final String LIBELLE_LONG_DEMANDE_AEPE_SUITE_REJET_ASU = "demande reprise solidarité suite rejet ASU";
  public static final String LIBELLE_COURT_DEMANDE_AEPE_SUIVI = "DAEPESUIVI";
  public static final String LIBELLE_LONG_DEMANDE_AEPE_SUIVI = "Demande AEPE suivi (plan de rebond sans AEPE)";
  public static final String LIBELLE_LONG_DAF_ASSEDIC = "Daf assedic";
  public static final String LIBELLE_COURT_DAF_ASSEDIC = "DAF_ASSEDIC";
  public static final String LIBELLE_LONG_DAF_ANPE = "Daf anpe";
  public static final String LIBELLE_COURT_DAF_ANPE = "DAF_ANPE";
  public static final String LIBELLE_LONG_RBF_AMO = "Demande d'aide à la mobilité";
  public static final String LIBELLE_COURT_RBF_AMO = "RBF_AMO";
  public static final String LIBELLE_LONG_RBF_AGEPI = "Demande AGEPI";
  public static final String LIBELLE_COURT_RBF_AGEPI = "RBF AGE";
  public static final String LIBELLE_LONG_RBF_AIDES = "Expérimentation APRE";
  public static final String LIBELLE_COURT_RBF_AIDES = "RBF AIDE";
  public static final String LIBELLE_LONG_FOR_AFF = "demande d'Aff";
  public static final String LIBELLE_COURT_FOR_AFF = "FOR_AFF";
  public static final String LIBELLE_LONG_FOR_RPS = "demande Rps";
  public static final String LIBELLE_COURT_FOR_RPS = "FOR_RPS";
  public static final String LIBELLE_LONG_FOR_RFPE = "demande RFPE";
  public static final String LIBELLE_COURT_FOR_RFPE = "FOR_RFPE";
  public static final String LIBELLE_LONG_INR_CES = "demande d'ACCRE";
  public static final String LIBELLE_COURT_INR_CES = "INR_CES";
  public static final String LIBELLE_LONG_INR_ARCE = "demande d'ARCE";
  public static final String LIBELLE_COURT_INR_ARCE = "INR_ARCE";
  public static final String LIBELLE_LONG_INR_ADR = "demande d'ADR";
  public static final String LIBELLE_COURT_INR_ADR = "INR_ADR";
  public static final String LIBELLE_LONG_INR_PAR = "demande de Prime au Reclasement";
  public static final String LIBELLE_COURT_INR_PAR = "INR_PAR";
  public static final String LIBELLE_LONG_PRR_FNE = "Adhésion FNE";
  public static final String LIBELLE_COURT_PRR_FNE = "PRR_FNE";
  public static final String LIBELLE_LONG_DEC = "Allocation décès";
  public static final String LIBELLE_COURT_DEC = "DEC";
  public static final int PRIORITE_ERE_ASU_ANTECEDENT = 21;
  public static final int PRIORITE_ERE_ASU_ANTECEDENT_EN_COURS_DOSSIER = 21;
  public static final int PRIORITE_ERE_ASU_REVISION = 20;
  public static final int PRIORITE_ERE_ASU_REVISION_2014 = 20;
  public static final int PRIORITE_ERE_ASU_ASSOCIEE = 20;
  public static final int PRIORITE_ERE_ASU_INSCRIPTION_ATP = 19;
  public static final int PRIORITE_ERE_ASU_BASCULE_CRP_CTP = 19;
  public static final int PRIORITE_ERE_ASU_FIN_ATP = 18;
  public static final int PRIORITE_ERE_ARI = 17;
  public static final int PRIORITE_ERE_ASU_INSCRIPTION_ASR = 16;
  public static final int PRIORITE_ERE_ASU_FIN_ASR = 15;
  public static final int PRIORITE_ERE_ASU_INSCRIPTION_ASP = 14;
  public static final int PRIORITE_ERE_ASU_FIN_ASP = 13;
  public static final int PRIORITE_ERE_ASU_RECHARGEMENT = 12;
  public static final int PRIORITE_ERE_ASU_REPRIVE_VERSEMENT = 12;
  public static final int PRIORITE_ERE_ASU_INSCRIPTION_DEMANDEUR_D_EMPLOI = 12;
  public static final int PRIORITE_ERE_ASU_FIN_DROIT_SPECTACLE = 11;
  public static final int PRIORITE_ERE_ARE_EFE = 11;
  public static final int PRIORITE_ERE_ASU_RETOUR_QUESTIONNAIRE = 10;
  public static final int PRIORITE_ERE_ASU_FIN_DROIT_SUITE_REPRISE_NON_SAISONNIERE = 9;
  public static final int PRIORITE_ERE_ASU_DEMANDE_EXPRESSE = 8;
  public static final int PRIORITE_ERE_APS_SUITE_REJET_ASU = 6;
  public static final int PRIORITE_ERE_APS_FIN_DROIT_SPECTACLE = 6;
  public static final int PRIORITE_ERE_APS_EFE = 6;
  public static final int PRIORITE_ERE_ASU_DV_FIL_EAU = 6;
  public static final int PRIORITE_ERE_ASU_PASSAGE_CP_SUITE_REJET_DV = 6;
  public static final int PRIORITE_ERE_AT_AFD_SUITE_REJET_ASU = 5;
  public static final int PRIORITE_ERE_AT_AFD_FIN_DROIT_SPECTACLE = 5;
  public static final int PRIORITE_ERE_AT_AFD_EFE = 5;
  public static final int PRIORITE_ERE_ASU_CLAUSE_RATTRAPAGE_SPECTACLE = 7;
  public static final int PRIORITE_ERE_RBF_DAF_ASSEDIC = 12;
  public static final int PRIORITE_ERE_RBF_DAF_ANPE = 11;
  public static final int PRIORITE_ERE_RBF_AMO = 10;
  public static final int PRIORITE_ERE_RBF_AGEPI = 9;
  public static final int PRIORITE_ERE_FOR_DEMANDE_AFF = 12;
  public static final int PRIORITE_ERE_FOR_DEMANDE_RPS = 11;
  public static final int PRIORITE_ERE_FOR_DEMANDE_RFPE = 10;
  public static final int PRIORITE_ERE_SOL_ANTECEDENT = 13;
  public static final int PRIORITE_ERE_SOL_DEMANDE_AER = 12;
  public static final int PRIORITE_ERE_SOL_DEMANDE_ATS = 12;
  public static final int PRIORITE_ERE_SOL_RENOUVELLEMENT_AER = 11;
  public static final int PRIORITE_ERE_SOL_REMISE_EN_COURS_ASS = 10;
  public static final int PRIORITE_ERE_SOL_SUITE_FIN_DROIT_ASU = 9;
  public static final int PRIORITE_ERE_SOL_SUITE_FIN_DROIT_SP = 9;
  public static final int PRIORITE_ERE_SOL_ASS_SUITE_DECHEANCE = 9;
  public static final int PRIORITE_ERE_SOL_DROIT_OPTION_ASS = 8;
  public static final int PRIORITE_ERE_SOL_REPRISE_SOLIDARITE_SUITE_REJET_ASU = 7;
  public static final int PRIORITE_ERE_SOL_RENOUVELLEMENT_ASS = 6;
  public static final int PRIORITE_ERE_SOL_CATEGORIE_PARTICULIERE_SUITE_REJET_ASU = 5;
  public static final int PRIORITE_ERE_SOL_DEMANDE_EXPRESSE_PLUS_DE_50_ANS = 4;
  public static final int PRIORITE_ERE_SOL_ATA_SUITE_FIN_DROIT_ASU = 3;
  public static final int PRIORITE_ERE_SOL_ATA_SUITE_FIN_DROIT_SP = 3;
  public static final int PRIORITE_ERE_SOL_ATA_SUITE_IDE = 3;
  public static final int PRIORITE_ERE_SOL_ATA_SUITE_REJET_ASU = 3;
  public static final int PRIORITE_ERE_SOL_REBOUVELLEMENT_ATA = 3;
  public static final int PRIORITE_ERE_SOL_REMISE_EN_COURS_ATA = 3;
  public static final int PRIORITE_ERE_INR_DEMANDE_ACCRE = 12;
  public static final int PRIORITE_ERE_INR_DEMANDE_ARCE = 12;
  public static final int PRIORITE_ERE_INR_DEMANDE_ADR = 12;
  public static final int PRIORITE_ERE_INR_DEMANDE_PAR = 12;
  
  public abstract String getLibelle();
  
  public abstract String getLibelleLong();
  
  public abstract String getTypeExamen();
  
  public abstract String getTypeSegment();
  
  public abstract Damj getDateDeclenchementExamen(DemandeSpec paramDemandeSpec);
  
  public abstract Damj getDateDeclenchementExamenPourAffichage(DemandeSpec paramDemandeSpec);
  
  public abstract Damj getDateExamen(DemandeSpec paramDemandeSpec);
  
  public abstract int getPriorite();
  
  public abstract void setDateEvenement(Damj paramDamj);
  
  public abstract void setDateDeclenchementExamen(Damj paramDamj);
  
  public abstract boolean mettreEnBasePivot();
  
  public abstract void verifierContexte(DemandeSpec paramDemandeSpec)
    throws ApplicativeException;
  
  public abstract void verifierContexteExamen(DemandeSpec paramDemandeSpec)
    throws ApplicativeException;
  
  public abstract void verifierPostContexte(DemandeSpec paramDemandeSpec)
    throws CoucheLogiqueException;
  
  public abstract Damj getDateEvenement();
  
  public abstract boolean verifierBesoinChargementTotalGaec();
  
  public abstract boolean mettreEnBasePivotAideNcp();
}

/* Location:
 * Qualified Name:     EvenementReferenceExamenSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */