package fr.unedic.cali.autresdoms.cohab.sigma.detectionsuivi.dom.spec;

import fr.unedic.util.temps.Damj;

public abstract interface DecisionSuiviSpec
{
  public static final String SUSPENSION_DUREE_DROIT = "1";
  public static final String SUSPENSION_NON_DUREE_DROIT = "2";
  public static final String DECISION_MAJORATION = "MA";
  public static final String DECISION_REFUS_MAJORATION = "RM";
  public static final String DECISION_MAINTIEN_RETRAITE = "MT";
  public static final String DECISION_REFUS_MAINTIEN_RETRAITE = "RT";
  public static final String DECISION_ACCEPT_ALLOC_DECES = "AD";
  public static final String DECISION_REFUS_ACCEPT_ALLOC_DECES = "RD";
  public static final String DECISION_PROLONGATION = "PR";
  public static final String DECISION_REFUS_PROLONGATION = "RP";
  public static final String DECISION_SUSPENSION_PREFIX = "SP";
  public static final String DECISION_SUSPENSION_ASSEDIC_ACT_NON_DECLAREES = "ST";
  public static final String DECISION_INTERRUPTION_PENSION = "PI";
  public static final String DECISION_POURSUITE_PENSION = "PP";
  public static final String DECISION_ARI = "AR";
  public static final String DECISION_POURSUITE = "PO";
  public static final String DECISION_REFUS_POURSUITE = "RO";
  public static final String DECISION_MAINT_6MOIS_ACT_REDUITE = "ZO";
  public static final String DECISION_INTERRUPTION_6MOIS_ACT_REDUITE = "IN";
  public static final String DECISION_SUSPENSION_CONGE_MATERNITE = "SM";
  public static final String DECISION_SUSPENSION_APE = "SN";
  public static final String DECISION_ACCEPT_CUMUL_ACT_GRP3 = "AC";
  public static final String DECISION_REFUS_CUMUL_ACT_GRP3 = "RC";
  public static final String DECISION_ACCEPT_FORFAIT_MENSUEL_ASA = "AS";
  public static final String DECISION_REFUS_ASA = "RA";
  public static final String DECISION_AUE = "CE";
  public static final String DECISION_NON_PRESENTATION_ENTRETIEN_PAP = "SR";
  public static final String DECISION_NON_PRESENTATION_ENTRE_PAP_ET_RECOURS = "SS";
  public static final String DECISION_ABS_DECISION_RENOUV_182J = "RB";
  public static final String DECISION_ATTENTE_DECISION_RENOUV_182J = "RX";
  public static final String DECISION_RENOUV_182J_AVEC_NOTIFICATION = "RE";
  public static final String DECISION_RENOUV_182J_SANS_NOTIFICATION = "RS";
  public static final String DECISION_SUSPENSION_TITRE_CONSERVATOIRE = "SC";
  public static final String DECISION_EXCLU_DECISION_ADMIN = "EA";
  public static final String DECISION_EXCLU_DEFINITIVE_DDTE = "EX";
  public static final String DECISION_EXCLU_DEFINITIVE_DDTE_122J = "ED";
  public static final String DECISION_SUSP_DUREE_DDTE = "SD";
  public static final String DECISION_SUSP_DUREE_DDTE_122J = "SE";
  public static final String DECISION_ACCEPT_ACT_REDUITE_FNE_PAR_DDTE = "AF";
  public static final String DECISION_REFUS_ACT_REDUITE_FNE_PAR_DDTE = "RF";
  public static final String DECISION_ACCEPT_CUMUL_ACT_RED_RSN_PAR_DDTE = "AN";
  public static final String DECISION_REFUS_CUMUL_ACT_RED_RSN_PAR_DDTE = "RN";
  public static final String DECISION_NON_MAINTIEN_AI_ASS_ET_ATA = "NM";
  public static final String DECISION_MAINT_AI_DEMANDEUR_ASILE = "MZ";
  public static final String DECISION_SUSP_AI_DEMANDEUR_ASILE = "SZ";
  public static final String DECISION_SUSPENSIION_ASSEDIC_AUTO_122J = "SA";
  public static final String DECISION_SUSPENSION_ASSEDIC_MANU_122J = "SB";
  public static final String DECISION_SUSPENSION_ASSEDIC_DOUBLE_INDEM = "SF";
  public static final String DECISION_REDUC_20P_MONTANT_JOURNALIER_BRUT = "R1";
  public static final String DECISION_REDUC_50P_MONTANT_JOURNALIER_BRUT = "R2";
  public static final String DECISION_CHEVAUCHEMENT_SANCTION = "C";
  public static final String DECISION_PRISE_EN_CHARGE_DEFINITIVE_DEMANDE_ASILE = "IA";
  public static final String DECISION_DESISTEMENT_DEMANDE_ASILE_OU_PROTECTION = "IB";
  public static final String DECISION_PRISE_EN_CHARGE_CENTRE_D_ACCUEIL = "IC";
  public static final String DECISION_REFUS_PRISE_EN_CHARGE_OFFRE_BENEFICIAIRE = "ID";
  
  public abstract String getIdentifiantOuvertureDroit();
  
  public abstract void setIdentifiantOuvertureDroit(String paramString);
  
  public abstract String getNatureDecision();
  
  public abstract void setNatureDecision(String paramString);
  
  public abstract Damj getDateEffet();
  
  public abstract void setDateEffet(Damj paramDamj);
  
  public abstract int getDureeDecision();
  
  public abstract void setDureeDecision(int paramInt);
  
  public abstract Damj getDateFin();
  
  public abstract void setDateFin(Damj paramDamj);
  
  public abstract String getNatureSuspension();
  
  public abstract void setNatureSuspension(String paramString);
  
  public abstract int getRangProlongation();
  
  public abstract void setRangProlongation(int paramInt);
  
  public abstract boolean getChevauchementSanction();
  
  public abstract void setChevauchementSanction(boolean paramBoolean);
}

/* Location:
 * Qualified Name:     DecisionSuiviSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */