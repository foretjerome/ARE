package fr.unedic.cali.dom.echange;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public final class ConstantesBaseEchange
{
  private static final String SANS_OBJET = "SANS OBJET";
  public static final int DEFAULT_INT = 0;
  public static final String DEFAULT_STRING = "";
  public static final Integer DEFAULT_INTEGER = null;
  public static final BigDecimal DEFAULT_BIGDECIMAL = null;
  public static final int ETAT_DEMANDE_SANS_OBJET = 0;
  public static final int ETAT_DEMANDE_VALIDEE = 1;
  public static final int ETAT_DEMANDE_EN_REEXAMEN = 2;
  protected static final Map<Integer, String> LIB_ETAT_DEMANDE = new HashMap();
  public static final int TOP_FAUX = 0;
  public static final int TOP_VRAI = 1;
  public static final int TOP_ASS_SUITE_CRP = 2;
  public static final int JUSTIF_PAS_ATTENTE = 0;
  public static final int JUSTIF_ATTENTE_DECISION = 1;
  public static final int JUSTIF_ATTENTE_JUSTIF = 2;
  public static final String SEGMENT_LE1D = "LE1D";
  public static final String SEGMENT_LK1B = "LK1B";
  protected static final Map<String, String> LIB_SEGMENT;
  public static final int TYPE_ECHEC_EXAMEN_SANS_OBJET = 0;
  public static final int TYPE_ECHEC_EXAMEN_REJET_AUTO = 1;
  public static final int TYPE_ECHEC_EXAMEN_REPRISE_AUTO = 2;
  public static final int TYPE_ECHEC_EXAMEN_DEMANDE_SIMPLIFIEE = 3;
  protected static final Map<Integer, String> LIB_TYPE_ECHEC;
  public static final String CLASSEMENT_AUCUN = "";
  public static final String CLASSEMENT_SANS_SUITE = "SS";
  public static final String CLASSEMENT_SANS_OBJET = "SO";
  public static final String CLASSEMENT_PRESCRIPTION = "PS";
  public static final String CLASSEMENT_COMPETENCE_SECTEUR_PUBLIC = "SP";
  public static final String CLASSEMENT_DEPOT_TARDIF = "DT";
  protected static final Map<String, String> LIB_CLASSEMENT;
  public static final int ORIGINE_DECISION_SANS_OBJET = 0;
  public static final int ORIGINE_DECISION_ASSEDIC = 0;
  public static final int ORIGINE_DECISION_AUTOMATIQUE = 1;
  public static final int ORIGINE_DECISION_DDTE = 2;
  public static final int ORIGINE_DECISION_COMMISSION_PARITAIRE = 3;
  public static final int ORIGINE_DECISION_MIGRATION = 3;
  protected static final Map<Integer, String> LIB_ORIGINE_DECISION;
  public static final int NATURE_DECISION_SANS_OBJET = 0;
  public static final int NATURE_DECISION_ADMISSION = 10;
  public static final int NATURE_DECISION_READMISSION = 11;
  public static final int NATURE_DECISION_RESULTANT = 26;
  public static final int NATURE_DECISION_REPRISE_CONTEXTUELLE = 14;
  public static final int NATURE_DECISION_REPRISE_DROIT_COMMUN = 13;
  public static final int NATURE_DECISION_REPRISE_SYSTEMATIQUE = 15;
  public static final int NATURE_DECISION_REPRISE_AUTOMATIQUE = 27;
  public static final int NATURE_DECISION_REJET = 16;
  public static final int NATURE_DECISION_REJET_AUTOMATIQUE = 28;
  public static final int NATURE_DECISION_REMISE_EN_COURS = 8;
  public static final int NATURE_DECISION_NON_RENOUVELLEMENT = 17;
  public static final int NATURE_DECISION_RENONCEMENT = 98;
  public static final String COMPETENCE_ADMINISTRATIVE_UNEDIC = "AC";
  public static final String COMPETENCE_ADMINISTRATIVE_SP = "SP";
  public static final String CONVENTION_GESTION = "CG";
  protected static final Map<String, String> LIB_COMPETENCE_ADMINISTRATIVE;
  public static final int STATUT_PREVISIONNEL = 0;
  public static final int STATUT_EFFECTIF = 1;
  protected static final Map<Integer, String> LIB_STATUT;
  public static final int REJET_AUTOMATIQUE_NON_EFFECTUE = 87;
  public static final int REPRISE_AUTOMATIQUE_NON_EFFECTUE = 88;
  public static final int REJET_NCP_REPRISE_AUTO = 89;
  public static final int LIQUIDATION_SIMPLIFIEE_ENVOI_DAL = 90;
  public static final int DEMANDES_EN_REEXAMEN_LE1D = 0;
  public static final int DEMANDES_EN_REEXAMEN_AUCUNE = 1;
  public static final int DEMANDES_EN_REEXAMEN_NON_LE1D = 2;
  public static final String EXAMEN_APS_FDD = "R1";
  public static final String EXAMEN_APS_FIL_EAU = "R2";
  public static final String EXAMEN_APS_IDE = "R3";
  public static final String EXAMEN_AT_AFD_FDD = "R4";
  public static final String EXAMEN_AT_AFD_FIL_EAU = "R5";
  public static final String EXAMEN_AT_AFD_IDE = "R6";
  public static final String EXAMEN_ARE_FIL_EAU = "71";
  public static final String EXAMEN_SOL_ATA_SUITE_REJET_ASU = "A2";
  public static final String TYPE_ACTION_CREATION_ATTENTE = "CA";
  public static final String TYPE_ACTION_CREATION_DAL = "CD";
  public static final String EXAMEN_ASR_FDD = "6";
  public static final String TYPE_BON_AUCUN = " ";
  public static final String TYPE_BON_AIDE_MOBILITE = "M";
  public static final String TYPE_BON_TRANSPORT = "T";
  public static final String TYPE_BON_SNCF = "R";
  public static final String TYPE_VNE1_DV = "A";
  public static final String TYPE_VNE2_AM = "B";
  public static final String TYPE_VNE3_A9 = "C";
  public static final String TYPE_VNE4_A8 = "D";
  public static final String TYPE_VNE4_A10 = "E";
  public static final String TYPE_VNE5_UE = "F";
  public static final String TYPE_VNE6_MD = "G";
  public static final String TYPE_VNE7_SP = "H";
  public static final String TYPE_BLS2_BO = "I";
  public static final String TYPE_DEC_A8_A10 = "J";
  public static final String TYPE_ATTE_RECHARGEMENT = "R";
  public static final String TYPE_ATTE_DROIT_APPRENTI = "Z";
  public static final String EST_PREMIERE_DEMANDE_POST_PRIME = "1";
  public static final String EST_DIMINUTION_MONTANT_CSP = "1";
  public static final String EST_DUREE_CSP_ALLONGEE = "1";
  public static final int TYPE_OBJECTIF_LIQUIDATION_DROIT_OPTION_SP = 4;
  public static final String TYPE_REPRISE_ASS = "A";
  public static final String ATTENTE = "ATTE";
  
  static
  {
    LIB_ETAT_DEMANDE.put(Integer.valueOf(0), "SANS OBJET");
    LIB_ETAT_DEMANDE.put(Integer.valueOf(1), "VALIDEE");
    LIB_ETAT_DEMANDE.put(Integer.valueOf(2), "EN REEXAMEN");
    
    LIB_SEGMENT = new HashMap();
    
    LIB_SEGMENT.put("LE1D", "RETOUR DAL");
    LIB_SEGMENT.put("LK1B", "RENOUVELLEMENT");
    LIB_SEGMENT.put("", "SANS OBJET");
    
    LIB_TYPE_ECHEC = new HashMap();
    
    LIB_TYPE_ECHEC.put(Integer.valueOf(0), "SANS OBJET");
    LIB_TYPE_ECHEC.put(Integer.valueOf(1), "REJET AUTO");
    LIB_TYPE_ECHEC.put(Integer.valueOf(2), "REPRISE AUTO");
    LIB_TYPE_ECHEC.put(Integer.valueOf(3), "DEMANDE SIMPLIFIEE");
    
    LIB_CLASSEMENT = new HashMap();
    
    LIB_CLASSEMENT.put("", "AUCUN");
    LIB_CLASSEMENT.put("SS", "SANS SUITE");
    LIB_CLASSEMENT.put("SO", "SANS OBJET");
    LIB_CLASSEMENT.put("PS", "PRESCRIPTION");
    LIB_CLASSEMENT.put("SP", "COMPETENCE SECTEUR PUBLIC");
    LIB_CLASSEMENT.put("DT", "DEPOT TARDIF");
    
    LIB_ORIGINE_DECISION = new HashMap();
    
    LIB_ORIGINE_DECISION.put(Integer.valueOf(0), "SANS OBJET");
    LIB_ORIGINE_DECISION.put(Integer.valueOf(0), "ASSEDIC");
    LIB_ORIGINE_DECISION.put(Integer.valueOf(1), "AUTOMATIQUE");
    LIB_ORIGINE_DECISION.put(Integer.valueOf(2), "DDTE");
    LIB_ORIGINE_DECISION.put(Integer.valueOf(3), "COMMISSION_PARITAIRE");
    LIB_ORIGINE_DECISION.put(Integer.valueOf(3), "MIGRATION");
    
    LIB_COMPETENCE_ADMINISTRATIVE = new HashMap();
    
    LIB_COMPETENCE_ADMINISTRATIVE.put("AC", "UNEDIC");
    LIB_COMPETENCE_ADMINISTRATIVE.put("SP", "SECTEUR PUBLIC");
    
    LIB_STATUT = new HashMap();
    
    LIB_STATUT.put(Integer.valueOf(0), "PREVISIONNEL");
    LIB_STATUT.put(Integer.valueOf(1), "EFFECTIF");
  }
  
  public static Map<Integer, String> getLibEtatDemande()
  {
    return LIB_ETAT_DEMANDE;
  }
  
  public static Map<String, String> getLibSegment()
  {
    return LIB_SEGMENT;
  }
  
  public static Map<Integer, String> getLibTypeEchec()
  {
    return LIB_TYPE_ECHEC;
  }
  
  public static Map<Integer, String> getLibOrigineDecision()
  {
    return LIB_ORIGINE_DECISION;
  }
  
  public static Map<String, String> getLibCompetenceAdministrative()
  {
    return LIB_COMPETENCE_ADMINISTRATIVE;
  }
  
  public static Map<Integer, String> getLibStatut()
  {
    return LIB_STATUT;
  }
  
  public static Map<String, String> getLibClassement()
  {
    return LIB_CLASSEMENT;
  }
}

/* Location:
 * Qualified Name:     ConstantesBaseEchange
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */