package fr.unedic.cali.dom;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class NaturesDecisions
{
  public static final int TYPE_DECISION = 0;
  public static final int TYPE_ATTRIBUTION = 1;
  public static final int TYPE_REJET = 2;
  public static final int TYPE_OD = 3;
  public static final int TYPE_AUTRE = 4;
  public static final int TYPE_INCONNU = -1;
  public static final int TYPE_REPRISE = 5;
  public static final int TYPE_NOVATION = 6;
  public static final int TYPE_RENOUVELLEMENT = 7;
  public static final int TYPE_POURSUITE = 8;
  public static final int OBJECTIF_ADMISSION = 1;
  public static final int OBJECTIF_REPRISE = 2;
  public static final int OBJECTIF_RENOUVELLEMENT = 3;
  public static final int OBJECTIF_REVISION = 4;
  public static final int OBJECTIF_NOVATION = 5;
  public static final int OBJECTIF_POURSUITE_INDEMNISATION = 6;
  public static final int ADMISSION = 10;
  private static final String LIB_ADMISSION = "Admission";
  public static final int ADMISSION_RENOUVELLEMENT = 7;
  private static final String LIB_ADMISSION_RENOUVELLEMENT = "Renouvellement";
  public static final int ADMISSION_REMISE_EN_COURS = 8;
  private static final String LIB_ADMISSION_REMISE_EN_COURS = "Remise en cours";
  public static final int ADMISSION_READMISSION_PRECEDENT = 11;
  private static final String LIB_ADMISSION_READMISSION_PRECEDENT = "Réadmission sur droit précédent";
  public static final int ADMISSION_READMISSION_COURANT = 12;
  private static final String LIB_ADMISSION_READMISSION_COURANT = "Réadmission sur droit courant";
  public static final int ADMISSION_READMISSION_RESULTANT = 26;
  private static final String LIB_ADMISSION_READMISSION_RESULTANT = "Réadmission sur produit résultant";
  public static final int ADMISSION_MAINTIEN = 23;
  private static final String LIB_ADMISSION_MAINTIEN = "Maintien";
  public static final int ADMISSION_ATTENTE_CP = 24;
  private static final String LIB_ADMISSION_ATTENTE_CP = "Attente IPR";
  public static final int ADMISSION_ATTENTE_QUESTIONNAIRE = 25;
  private static final String LIB_ADMISSION_ATTENTE_QUESTIONNAIRE = "Attente questionnaire";
  public static final int ADMISSION_PREVISIONNELLE = 21;
  private static final String LIB_ADMISSION_PREVISIONNELLE = "Attribution prévisionnelle";
  public static final int ADMISSION_EFFECTIVE = 22;
  private static final String LIB_ADMISSION_EFFECTIVE = "Attribution effective";
  public static final String LIB_ATTRIBUTION = "Attribution";
  public static final int REVISION = 30;
  private static final String LIB_REVISION = "Révision";
  public static final int REVISION_ADMISSION = 45;
  private static final String LIB_REVISION_ADMISSION = "Révision";
  public static final int ADMISSION_READMISSION_FIN_ASR = 40;
  private static final String LIB_ADMISSION_READMISSION_FIN_ASR = "Réadmission Fin Asr";
  public static final int ADMISSION_FIN_ASR = 32;
  private static final String LIB_ADMISSION_FIN_ASR = "Admission Fin Asr";
  public static final int OD_ASSOCIEE = 35;
  private static final String LIB_OD_ASSOCIEE = "Financement";
  public static final int REPRISE_ASSOCIEE = 46;
  private static final String LIB_REPRISE_ASSOCIEE = "Financement";
  public static final int ANTECEDENT = 38;
  private static final String LIB_ANTECEDENT = "Installation d'un antécédent";
  public static final int POURSUITE = 39;
  private static final String LIB_POURSUITE = "Installation d'un antécédent exécutable";
  public static final int ATTRIBUTION_DEROGATOIRE = 41;
  private static final String LIB_ATTRIBUTION_DEROGATOIRE = "Attribution dérogatoire";
  public static final int PROPOSITION_ATTRIBUTION = 42;
  private static final String LIB_PROPOSITION_ATTRIBUTION = "Proposition d'attribution";
  public static final int PROPOSITION_ATTRIBUTION_DEROGATOIRE = 43;
  private static final String LIB_PROPOSITION_ATTRIBUTION_DEROGATOIRE = "Proposition d'attribution dérogatoire";
  public static final int ADMISSION_RECHARGEMENT = 44;
  private static final String LIB_ADMISSION_RECHARGEMENT = "Rechargement";
  public static final int ADMISSION_ENTREE_CSP = 47;
  private static final String LIB_ADMISSION_ENTREE_CSP = "Admission entrée en CSP / PAP";
  public static final int ADMISSION_SORTIE_CSP = 48;
  private static final String LIB_ADMISSION_SORTIE_CSP = "Admission sortie CSP";
  public static final int REPRISE = 3;
  private static final String LIB_REPRISE = "Reprise";
  public static final int REPRISE_DROIT_COMMUN = 13;
  private static final String LIB_REPRISE_DROIT_COMMUN = "Reprise de droit commun";
  public static final int REPRISE_CONTEXTUELLE = 14;
  private static final String LIB_REPRISE_CONTEXTUELLE = "Reprise contextuelle";
  public static final int REPRISE_SYSTEMATIQUE = 15;
  private static final String LIB_REPRISE_SYSTEMATIQUE = "Reprise systématique";
  public static final int REPRISE_AUTOMATIQUE = 27;
  private static final String LIB_REPRISE_AUTOMATIQUE = "Reprise automatique";
  public static final int REPRISE_SECTEUR_PUBLIC = 50;
  private static final String LIB_REPRISE_SECTEUR_PUBLIC = "Reprise SP";
  public static final int POURSUITE_INDEMNISATION = 49;
  private static final String LIB_POURSUITE_INDEMNISATION = "Poursuite de l'indemnisation";
  public static final int REJET = 16;
  private static final String LIB_REJET = "Rejet";
  public static final int REJET_NON_RENOUVELLEMENT = 17;
  private static final String LIB_REJET_NON_RENOUVELLEMENT = "Non Renouvellement";
  public static final int REJET_NON_REMISE_EN_COURS = 18;
  private static final String LIB_REJET_NON_REMISE_EN_COURS = "Non Remise en cours";
  public static final int REJET_ECHEC = 19;
  private static final String LIB_REJET_ECHEC = "Echec";
  public static final int REJET_AUTOMATIQUE = 28;
  private static final String LIB_REJET_AUTOMATIQUE = "Rejet automatique";
  public static final int REJET_ECHEC_REVISION = 29;
  private static final String LIB_REJET_ECHEC_REVISION = "Echec";
  public static final int NON_FINANCEMENT = 36;
  private static final String LIB_NON_FINANCEMENT = "Non financement";
  public static final int FINANCEMENT_ETAT = 37;
  private static final String LIB_FINANCEMENT_ETAT = "Non financement";
  public static final int TYPE_EXAMEN = 0;
  public static final int CLASSEE = 20;
  private static final String LIB_CLASSEE = "Classée";
  public static final int RENONCEMENT = 31;
  public static final int REJET_SIMPLIFIEE = 33;
  private static final String LIB_REJET_SIMPLIFIEE = "Rejet simplifié";
  public static final int REPRISE_SIMPLIFIEE = 34;
  private static final String LIB_REPRISE_SIMPLIFIEE = "Reprise simplifiée";
  public static HashMap<BigDecimal, String> s_libelleObjectifDecision = new HashMap();
  public static HashMap<BigDecimal, BigDecimal> s_typeDecision = new HashMap();
  public static HashMap<BigDecimal, List<BigDecimal>> s_groupeTypesDecision = new HashMap();
  
  static
  {
    declarerDecision(10, "Admission", 3);
    declarerDecision(11, "Réadmission sur droit précédent", 3);
    declarerDecision(12, "Réadmission sur droit courant", 3);
    declarerDecision(26, "Réadmission sur produit résultant", 3);
    declarerDecision(22, "Attribution effective", 3);
    declarerDecision(21, "Attribution prévisionnelle", 3);
    declarerDecision(35, "Financement", 3);
    declarerDecision(37, "Non financement", 3);
    declarerDecision(38, "Installation d'un antécédent", 3);
    declarerDecision(39, "Installation d'un antécédent exécutable", 3);
    declarerDecision(32, "Admission Fin Asr", 3);
    declarerDecision(40, "Réadmission Fin Asr", 3);
    declarerDecision(41, "Attribution dérogatoire", 3);
    declarerDecision(42, "Proposition d'attribution", 3);
    declarerDecision(43, "Proposition d'attribution dérogatoire", 3);
    declarerDecision(44, "Rechargement", 3);
    
    declarerDecision(7, "Renouvellement", 1);
    declarerDecision(8, "Remise en cours", 7);
    declarerDecision(30, "Révision", 1);
    declarerDecision(45, "Révision", 1);
    
    declarerDecision(47, "Admission entrée en CSP / PAP", 6);
    declarerDecision(48, "Admission sortie CSP", 6);
    
    declarerDecision(3, "Reprise", 5);
    declarerDecision(13, "Reprise de droit commun", 5);
    declarerDecision(14, "Reprise contextuelle", 5);
    declarerDecision(15, "Reprise systématique", 5);
    declarerDecision(27, "Reprise automatique", 5);
    declarerDecision(34, "Reprise simplifiée", 5);
    declarerDecision(46, "Financement", 5);
    declarerDecision(50, "Reprise SP", 0);
    
    declarerDecision(49, "Poursuite de l'indemnisation", 8);
    
    declarerDecision(24, "Attente IPR", 0);
    declarerDecision(25, "Attente questionnaire", 0);
    declarerDecision(20, "Classée", 0);
    declarerDecision(23, "Maintien", 0);
    
    declarerDecision(16, "Rejet", 2);
    declarerDecision(28, "Rejet automatique", 2);
    declarerDecision(17, "Non Renouvellement", 2);
    declarerDecision(18, "Non Remise en cours", 2);
    declarerDecision(19, "Echec", 2);
    declarerDecision(29, "Echec", 2);
    declarerDecision(33, "Rejet simplifié", 2);
    declarerDecision(36, "Non financement", 2);
    
    List<BigDecimal> listeTypeDecision = new ArrayList();
    listeTypeDecision.add(new BigDecimal(0));
    listeTypeDecision.add(new BigDecimal(1));
    listeTypeDecision.add(new BigDecimal(2));
    listeTypeDecision.add(new BigDecimal(3));
    listeTypeDecision.add(new BigDecimal(5));
    listeTypeDecision.add(new BigDecimal(7));
    listeTypeDecision.add(new BigDecimal(6));
    listeTypeDecision.add(new BigDecimal(8));
    s_groupeTypesDecision.put(new BigDecimal(0), listeTypeDecision);
    
    List<BigDecimal> listeTypeAttribution = new ArrayList();
    listeTypeAttribution.add(new BigDecimal(1));
    listeTypeAttribution.add(new BigDecimal(3));
    listeTypeAttribution.add(new BigDecimal(5));
    listeTypeAttribution.add(new BigDecimal(7));
    listeTypeAttribution.add(new BigDecimal(6));
    s_groupeTypesDecision.put(new BigDecimal(1), listeTypeAttribution);
    
    List<BigDecimal> listeTypeRejet = new ArrayList();
    listeTypeRejet.add(new BigDecimal(2));
    s_groupeTypesDecision.put(new BigDecimal(2), listeTypeRejet);
    
    List<BigDecimal> listeTypeOd = new ArrayList();
    listeTypeOd.add(new BigDecimal(3));
    s_groupeTypesDecision.put(new BigDecimal(3), listeTypeOd);
    
    List<BigDecimal> listeTypeReprises = new ArrayList();
    listeTypeReprises.add(new BigDecimal(5));
    s_groupeTypesDecision.put(new BigDecimal(5), listeTypeReprises);
    
    List<BigDecimal> listeTypeNovation = new ArrayList();
    listeTypeNovation.add(new BigDecimal(6));
    s_groupeTypesDecision.put(new BigDecimal(6), listeTypeNovation);
    
    List<BigDecimal> listeTypePoursuite = new ArrayList();
    listeTypePoursuite.add(new BigDecimal(8));
    s_groupeTypesDecision.put(new BigDecimal(8), listeTypePoursuite);
  }
  
  public static void declarerDecision(int decision, String libelleDecision, int typeDecision)
  {
    s_libelleObjectifDecision.put(new BigDecimal(decision), libelleDecision);
    s_typeDecision.put(new BigDecimal(decision), new BigDecimal(typeDecision));
  }
  
  private static int trouverTypeDecision(int decision)
  {
    BigDecimal typeDecision = (BigDecimal)s_typeDecision.get(new BigDecimal(decision));
    return typeDecision != null ? typeDecision.intValue() : -1;
  }
  
  public static boolean estDuType(int type, int decision)
  {
    int typeDecision = trouverTypeDecision(decision);
    if (typeDecision == -1) {
      return false;
    }
    List<BigDecimal> listeTypeAttribution = (List)s_groupeTypesDecision.get(new BigDecimal(type));
    return listeTypeAttribution.contains(new BigDecimal(typeDecision));
  }
  
  public static boolean estdeTypeAttribution(int decision)
  {
    return estDuType(1, decision);
  }
  
  public static boolean estdeTypeRejet(int decision)
  {
    return estDuType(2, decision);
  }
  
  public static boolean estdeTypeOd(int decision)
  {
    return estDuType(3, decision);
  }
  
  public static boolean estdeTypeReprise(int decision)
  {
    return estDuType(5, decision);
  }
  
  public static boolean estdeTypeNovation(int decision)
  {
    return estDuType(6, decision);
  }
  
  public static boolean estdeTypePoursuite(int decision)
  {
    return estDuType(8, decision);
  }
}

/* Location:
 * Qualified Name:     NaturesDecisions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */