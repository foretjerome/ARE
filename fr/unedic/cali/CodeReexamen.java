package fr.unedic.cali;

import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.util.services.ContexteService;
import java.util.HashMap;
import java.util.Map;

public final class CodeReexamen
{
  public static final Integer UN = Integer.valueOf(1);
  public static final Integer DEUX = Integer.valueOf(2);
  public static final Integer TROIS = Integer.valueOf(3);
  public static final String CODE_REEXAMEN_SANS_OBJET = "0";
  public static final String CODE_DEMANDE_REEXAMEN_MANUEL = "1";
  private static final String LIB_DEMANDE_REEXAMEN_MANUEL = "Demande de réexamen manuelle";
  public static final String CODE_DECISION_PRECEDENTE_EN_ATTENTE_REEXAMEN = "2";
  private static final String LIB_DECISION_PRECEDENTE_EN_ATTENTE_REEXAMEN = "Décision précédente en attente de réexamen";
  public static final String CODE_ANNULATION_DECISION_PRECEDENTE = "3";
  private static final String LIB_ANNULATION_DECISION_PRECEDENTE = "Annulation décision précédente";
  public static final String CODE_REMISE_EN_CAUSE_DECISION_PRECEDENTE = "4";
  private static final String LIB_REMISE_EN_CAUSE_DECISION_PRECEDENTE = "Remise en cause de la décision précédente";
  public static final String CODE_MODIFICATION_GAEC = "5";
  private static final String LIB_MODIFICATION_GAEC = "Modification de période(s) activité(s) événement(s) client";
  public static final String CODE_MODIFICATION_RESSOURCES = "7";
  private static final String LIB_MODIFICATION_RESSOURCES = "Modification des ressources";
  public static final String CODE_MODIFICATION_DATE_NAISSANCE = "8";
  private static final String LIB_MODIFICATION_DATE_NAISSANCE = "Modification de la date de naissance";
  public static final String CODE_MODIFICATION_PEC = "9";
  private static final String LIB_MODIFICATION_PEC = "Modification de la date de PEC (ide)";
  public static final String CODE_CHANGEMENT_REGLEMENTAIRE = "12";
  private static final String LIB_CHANGEMENT_REGLEMENTAIRE = "Changement réglementaire ou correctif";
  public static final String CODE_MODIFICATION_MONTANT_INVALIDITE = "17";
  private static final String LIB_MODIFICATION_MONTANT_INVALIDITE = "Modification du montant de la pension invalidité";
  public static final String CODE_MODIFICATION_DONNEES_DAL_OU_FORCEES = "25";
  private static final String LIB_MODIFICATION_DONNEES_DAL_OU_FORCEES = "Modification données imposées et/ou complémentaires";
  public static final String CODE_MODIFICATION_AVANTAGE_VIEILLESSE = "26";
  private static final String LIB_MODIFICATION_AVANTAGE_VIEILLESSE = "Modification avantage vieillesse";
  public static final String CODE_REEXECUTION_DEMANDE_PRECEDENTE = "27";
  private static final String LIB_REEXECUTION_DEMANDE_PRECEDENTE = "Ré-exécution demande précédente";
  public static final String CODE_MODIFICATION_ACTION_FORMATION = "28";
  private static final String LIB_MODIFICATION_ACTION_FORMATION = "Modification action de formation";
  public static final String CODE_MODIFICATION_REFUS_FNE = "29";
  private static final String LIB_MODIFICATION_REFUS_FNE = "Modification refus FNE";
  public static final String CODE_MODIFICATION_COMPLETUDE_DAL = "30";
  private static final String LIB_MODIFICATION_COMPLETUDE_DAL = "Modification complétude DAL";
  public static final String CODE_MODIFICATION_TRIMESTRES = "31";
  private static final String LIB_MODIFICATION_TRIMESTRES = "Modification des trimestres";
  public static final String CODE_FORCAGE_DONNEES_MIGRATION_CALCUL = "32";
  private static final String LIB_FORCAGE_DONNEES_MIGRATION_CALCUL = "Forcage des données migrattion calcul";
  public static final String LIB_PRESENCE_DONNEES_FORCEES = " (Présence de données forcées)";
  protected static final String CODE_MA03 = "MA03";
  protected static final String CODE_MA14 = "MA14";
  protected static final String CODE_MA15 = "MA15";
  protected static final String CODE_MA16 = "MA16";
  protected static final String CODE_MA44 = "MA44";
  protected static final String CODE_MA8A = "MA8A";
  protected static final String CODE_MA8K = "MA8K";
  protected static final String CODE_MA98 = "MA98";
  protected static final String CODE_MA9B = "MA9B";
  protected static final String CODE_MAJ1 = "MAJ1";
  protected static final String CODE_ME2C = "ME2C";
  protected static final String CODE_ME78 = "ME78";
  protected static final String CODE_MF03 = "MF03";
  protected static final String CODE_MK02 = "MK02";
  protected static final String CODE_MK30 = "MK30";
  protected static final String CODE_MK31 = "MK31";
  protected static final String CODE_MK54 = "MK54";
  public static final String CODE_FLUX_ORIGINE_GAEC = "GAEC";
  protected static final String CODE_ACT_AEM = "AEM";
  protected static final String CODE_ACT_BS = "BS";
  protected static final String CODE_ACT_CAR = "CAR";
  protected static final String CODE_ACT_CLCA = "CLCA";
  protected static final String CODE_ACT_CLCAR = "CLCAR";
  protected static final String CODE_ACT_IJSS = "IJSS";
  protected static final String CODE_ACT_ETT = "ETT";
  protected static final String CODE_ACT_ETTR = "ETTR";
  protected static final String CODE_ACT_GUSO = "GUSO";
  protected static final String CODE_ACT_CALI = "CALI";
  protected static final String CODE_ACT_DSM = "DSM";
  protected static final String CODE_ACT_SDSM = "SDSM";
  protected static final String CODE_ACT_GRCA = "GRCA";
  protected static final String CODE_ACT_CALIC = "CALIC";
  protected static final String CODE_ACT_CALIR = "CALIR";
  protected static final String CODE_BATCH_AZC01 = "AZC01";
  protected static final String CODE_BATCH_KZCSL = "KZCSL";
  protected static final String CODE_BATCH_EZCCS = "EZCCS";
  protected static final String CODE_BATCH_EZC01 = "EZC01";
  private static Map<String, String> libelleMotifsReexamen = new HashMap();
  private static Map<String, Integer> prioriteMotifsReexamen;
  private static Map<String, String> tableCodeTransactionCodeReexamen;
  private static Map<String, String> tableCodeActiviteCodeReexamen;
  
  static
  {
    libelleMotifsReexamen.put("1", "Demande de réexamen manuelle");
    libelleMotifsReexamen.put("2", "Décision précédente en attente de réexamen");
    libelleMotifsReexamen.put("3", "Annulation décision précédente");
    libelleMotifsReexamen.put("4", "Remise en cause de la décision précédente");
    libelleMotifsReexamen.put("5", "Modification de période(s) activité(s) événement(s) client");
    libelleMotifsReexamen.put("7", "Modification des ressources");
    libelleMotifsReexamen.put("8", "Modification de la date de naissance");
    libelleMotifsReexamen.put("9", "Modification de la date de PEC (ide)");
    libelleMotifsReexamen.put("12", "Changement réglementaire ou correctif");
    libelleMotifsReexamen.put("17", "Modification du montant de la pension invalidité");
    libelleMotifsReexamen.put("25", "Modification données imposées et/ou complémentaires");
    libelleMotifsReexamen.put("26", "Modification avantage vieillesse");
    libelleMotifsReexamen.put("27", "Ré-exécution demande précédente");
    libelleMotifsReexamen.put("28", "Modification action de formation");
    libelleMotifsReexamen.put("29", "Modification refus FNE");
    libelleMotifsReexamen.put("30", "Modification complétude DAL");
    libelleMotifsReexamen.put("31", "Modification des trimestres");
    libelleMotifsReexamen.put("32", "Forcage des données migrattion calcul");
    
    prioriteMotifsReexamen = new HashMap();
    prioriteMotifsReexamen.put("1", DEUX);
    prioriteMotifsReexamen.put("2", TROIS);
    prioriteMotifsReexamen.put("3", TROIS);
    prioriteMotifsReexamen.put("4", TROIS);
    prioriteMotifsReexamen.put("5", DEUX);
    prioriteMotifsReexamen.put("7", UN);
    prioriteMotifsReexamen.put("8", UN);
    prioriteMotifsReexamen.put("9", UN);
    prioriteMotifsReexamen.put("12", UN);
    prioriteMotifsReexamen.put("17", DEUX);
    prioriteMotifsReexamen.put("25", DEUX);
    prioriteMotifsReexamen.put("26", DEUX);
    prioriteMotifsReexamen.put("27", TROIS);
    prioriteMotifsReexamen.put("28", DEUX);
    prioriteMotifsReexamen.put("29", UN);
    prioriteMotifsReexamen.put("30", UN);
    prioriteMotifsReexamen.put("31", UN);
    
    tableCodeTransactionCodeReexamen = new HashMap();
    tableCodeTransactionCodeReexamen.put("MA03", "8");
    tableCodeTransactionCodeReexamen.put("MA14", "9");
    tableCodeTransactionCodeReexamen.put("MA15", "9");
    tableCodeTransactionCodeReexamen.put("MA16", "9");
    tableCodeTransactionCodeReexamen.put("MA44", "28");
    tableCodeTransactionCodeReexamen.put("MA8A", "28");
    tableCodeTransactionCodeReexamen.put("MA8K", "28");
    tableCodeTransactionCodeReexamen.put("MA98", "9");
    tableCodeTransactionCodeReexamen.put("MA9B", "8");
    tableCodeTransactionCodeReexamen.put("MAJ1", "28");
    tableCodeTransactionCodeReexamen.put("ME2C", "29");
    tableCodeTransactionCodeReexamen.put("ME78", "17");
    tableCodeTransactionCodeReexamen.put("MF03", "4");
    tableCodeTransactionCodeReexamen.put("MK02", "30");
    tableCodeTransactionCodeReexamen.put("MK30", "7");
    tableCodeTransactionCodeReexamen.put("MK31", "31");
    tableCodeTransactionCodeReexamen.put("MK54", "26");
    tableCodeTransactionCodeReexamen.put("GAEC", "5");
    
    tableCodeActiviteCodeReexamen = new HashMap();
    tableCodeActiviteCodeReexamen.put("AEM", "5");
    tableCodeActiviteCodeReexamen.put("BS", "5");
    tableCodeActiviteCodeReexamen.put("CAR", "5");
    tableCodeActiviteCodeReexamen.put("CLCA", "5");
    tableCodeActiviteCodeReexamen.put("CLCAR", "5");
    tableCodeActiviteCodeReexamen.put("IJSS", "5");
    tableCodeActiviteCodeReexamen.put("ETT", "5");
    tableCodeActiviteCodeReexamen.put("ETTR", "5");
    tableCodeActiviteCodeReexamen.put("GUSO", "5");
    tableCodeActiviteCodeReexamen.put("CALI", "9");
    tableCodeActiviteCodeReexamen.put("DSM", "5");
    tableCodeActiviteCodeReexamen.put("SDSM", "5");
    tableCodeActiviteCodeReexamen.put("GRCA", "12");
    tableCodeActiviteCodeReexamen.put("CALIC", "0");
    tableCodeActiviteCodeReexamen.put("CALIR", "0");
  }
  
  public static String getLibelle(String codeReexamen)
  {
    return (String)libelleMotifsReexamen.get(codeReexamen);
  }
  
  public static String determineCodeReexamen(ContexteService contexteService)
  {
    String codeReexamen = "1";
    
    String contexteEmission = contexteService.getContexteEmission();
    if (contexteEmission != null)
    {
      if (contexteEmission.equals("TP")) {
        codeReexamen = determineCodeReexamenTP(contexteService);
      } else if (contexteEmission.equals("TD")) {
        codeReexamen = determineCodeReexamenTD(contexteService);
      } else if (Log.isTraceActive(CodeReexamen.class, Niveau.DEBUG)) {
        Log.ecritTrace(Niveau.DEBUG, CodeReexamen.class, "determineCodeReexamen", "Contexte Emission mal renseigné dans ContexteService. Valeur attendue : 'TP' ou 'TD'. Valeur : " + contexteEmission);
      }
    }
    else if (Log.isTraceActive(CodeReexamen.class, Niveau.DEBUG)) {
      Log.ecritTrace(Niveau.DEBUG, CodeReexamen.class, "determineCodeReexamen", "Contexte Emission non renseigné dans ContexteService. Valeur attendue : 'TP' ou 'TD'");
    }
    return codeReexamen;
  }
  
  private static String determineCodeReexamenTP(ContexteService contexteService)
  {
    return determineCodeReexamenTP(contexteService.getSrcCodeTransaction());
  }
  
  public static String determineCodeReexamenTP(String codeTransaction)
  {
    String codeReexamen = (String)tableCodeTransactionCodeReexamen.get(codeTransaction);
    if (codeReexamen == null)
    {
      codeReexamen = "1";
      if (Log.isTraceActive(CodeReexamen.class, Niveau.INFO)) {
        Log.ecritTrace(Niveau.INFO, CodeReexamen.class, "determineCodeReexamenTP", "Pas de code Reexamen dans la table pour code transaction : " + codeTransaction);
      }
    }
    return codeReexamen;
  }
  
  private static String determineCodeReexamenTD(ContexteService contexteService)
  {
    String codeActivite = contexteService.getCodeActivite();
    String codeTransaction = contexteService.getSrcCodeTransaction();
    String codeReexamen = (String)tableCodeActiviteCodeReexamen.get(codeActivite);
    if (codeReexamen == null)
    {
      codeReexamen = "1";
      if (Log.isTraceActive(CodeReexamen.class, Niveau.INFO)) {
        Log.ecritTrace(Niveau.INFO, CodeReexamen.class, "determineCodeReexamenTD", "Pas de code Reexamen dans la table pour code activité : " + codeActivite);
      }
    }
    if (codeActivite.equals("CALI"))
    {
      if ((codeTransaction != null) && ((codeTransaction.equals("AZC01")) || (codeTransaction.equals("KZCSL")))) {
        codeReexamen = "0";
      }
    }
    else if ((codeActivite.equals("CALIC")) || (codeActivite.equals("CALIR"))) {
      codeReexamen = "0";
    }
    return codeReexamen;
  }
}

/* Location:
 * Qualified Name:     CodeReexamen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */