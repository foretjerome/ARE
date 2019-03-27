package fr.unedic.cali.dom.spec;

import java.util.HashMap;
import java.util.Map;

public final class ConstantesCategorieTableEchange
{
  public static final String CODE_SOUS_PRODUIT_AFF = "";
  public static final String CODE_SOUS_PRODUIT_AFDEF = "20";
  public static final String CODE_SOUS_PRODUIT_AFDEF_2010 = "21";
  public static final String CODE_SOUS_PRODUIT_ANNEXE_7 = "07";
  public static final String CODE_SOUS_PRODUIT_RFF_2012 = "22";
  public static final String CODE_SOUS_PRODUIT_RFF_2013 = "23";
  public static final String CODE_SOUS_PRODUIT_RFF_2014 = "24";
  public static final String CODE_SOUS_PRODUIT_RFF_2015 = "25";
  public static final String CODE_SOUS_PRODUIT_RFF_2016 = "26";
  public static final String CODE_SOUS_PRODUIT_RFF_2017 = "27";
  public static final String CAT_DEMANDEUR_ASILE_TABLE_ECHANGE = "04";
  public static final String CAT_DETENUS_TABLE_ECHANGE = "05";
  public static final String CAT_BENEFICIAIRE_PROTECTION_TEMPORAIRE_TABLE_ECHANGE = "06";
  public static final String CAT_BENEFICIAIRE_PROTECTION_SUBSIDIAIRE_TABLE_ECHANGE = "07";
  public static final String CAT_VICTIME_TRAITE_HUMAINE_TABLE_ECHANGE = "08";
  public static final String CAT_APATRIDES_TABLE_ECHANGE = "09";
  public static final String CAT_EXPATRIES_TABLE_ECHANGE = "10";
  public static final String INDETERMINE = "0";
  public static final String TRAVAILLEURS_SAL_SANS_EMPLOI = "11";
  public static final String PUBLIC_SITU_FAMIL_PARTIC = "12";
  public static final String DE_HANDICAPES = "13";
  public static final String TRAVAILLEURS_SAL_SANS_EMPLOI_HANDICAPES = "14";
  public static final String PRIMO_DEMANDEUR_MOIS_DE_18_ANS = "15";
  public static final String PRIMO_DEMANDEUR_DE_18_A_20_ANS = "16";
  public static final String PRIMO_DEMANDEUR_DE_21_A_25_ANS = "17";
  public static final String PRIMO_DEMANDEUR_PLUS_DE_25_ANS = "18";
  public static final String PRIMO_DEMANDEUR = "19";
  public static final String CODE_SOUS_PRODUIT_AER_2009 = "11";
  public static final String CODE_SOUS_PRODUIT_ARCE_2009 = "09";
  public static final String CODE_SOUS_PRODUIT_ARCE_2011 = "11";
  public static final String CODE_SOUS_PRODUIT_ARCE_2011_45 = "45";
  public static final String CODE_SOUS_PRODUIT_ARCE_2016_SPE02_05 = "A8";
  public static final String CODE_SOUS_PRODUIT_ARCE_2017 = "17";
  public static final String CODE_SOUS_PRODUIT_ADR_2011 = "11";
  public static final String REDUCTION_ACTIVITE = "01";
  public static final String SINISTRE = "02";
  public static final String COORDINATION_REGIME_CEE = "03";
  public static final String APPRENTI = "24";
  public static final String PMVS = "MV";
  public static final String CODE_SOUS_PRODUIT_CLAUSE_RATTRAPAGE = "CR";
  public static final String BASSIN_EMPLOI_CTP06 = "22";
  public static final String BASSIN_EMPLOI_CTP09 = "23";
  public static final String BASSIN_EMPLOI_CRP = "03";
  public static final String ASP_DC_SUPERIEUR_2_ANS = "01";
  public static final String ASP_DC_SUPERIEUR_2_ANS_PMVS = "M1";
  public static final String ASP_DC_SUPERIEUR_1_AN = "02";
  public static final String ASP_DC_SUPERIEUR_1_AN_PMVS = "M2";
  public static final String ASP_ARE = "";
  public static final String PAP_ARE = "05";
  public static final String PAP_DC_SUPERIEUR_1_AN = "06";
  public static final String PAP_DC_SUPERIEUR_2_ANS = "06";
  public static final String PAP_ARE_PARLEMENTAIRE = "07";
  public static final String PAP_DC_SUPERIEUR_1_AN_PARLEMENTAIRE = "08";
  public static final String PAP_DC_SUPERIEUR_2_ANS_PARLEMENTAIRE = "08";
  public static final String CODE_SOUS_PRODUIT_RBF = "AP";
  public static final String CODE_SOUS_PRODUIT_APRE = "RH";
  public static final String CODE_SOUS_PRODUIT_ACTIONS_LOCALES = "AL";
  public static final Map CATEGORIE_TABLE_ECHANGE = new HashMap();
  public static final Map LIB_CATEGORIE_ATTRIBUTION;
  
  static
  {
    CATEGORIE_TABLE_ECHANGE.put("SOL_ATA06_01" + Integer.toString(4), "04");
    CATEGORIE_TABLE_ECHANGE.put("SOL_ATA06_01" + Integer.toString(5), "05");
    CATEGORIE_TABLE_ECHANGE.put("SOL_ATA06_01" + Integer.toString(6), "06");
    CATEGORIE_TABLE_ECHANGE.put("SOL_ATA06_01" + Integer.toString(7), "07");
    CATEGORIE_TABLE_ECHANGE.put("SOL_ATA06_01" + Integer.toString(8), "08");
    CATEGORIE_TABLE_ECHANGE.put("SOL_ATA06_01" + Integer.toString(9), "09");
    CATEGORIE_TABLE_ECHANGE.put("SOL_ATA06_01" + Integer.toString(10), "10");
    
    CATEGORIE_TABLE_ECHANGE.put("FOR_RFP04_01" + Integer.toString(0), "0");
    CATEGORIE_TABLE_ECHANGE.put("FOR_RFP04_01" + Integer.toString(11), "11");
    CATEGORIE_TABLE_ECHANGE.put("FOR_RFP04_01" + Integer.toString(12), "12");
    CATEGORIE_TABLE_ECHANGE.put("FOR_RFP04_01" + Integer.toString(13), "13");
    CATEGORIE_TABLE_ECHANGE.put("FOR_RFP04_01" + Integer.toString(14), "14");
    CATEGORIE_TABLE_ECHANGE.put("FOR_RFP04_01" + Integer.toString(15), "15");
    CATEGORIE_TABLE_ECHANGE.put("FOR_RFP04_01" + Integer.toString(16), "16");
    CATEGORIE_TABLE_ECHANGE.put("FOR_RFP04_01" + Integer.toString(17), "17");
    CATEGORIE_TABLE_ECHANGE.put("FOR_RFP04_01" + Integer.toString(18), "18");
    
    CATEGORIE_TABLE_ECHANGE.put("FOR_AFF03_0120", "20");
    CATEGORIE_TABLE_ECHANGE.put("FOR_AFF03_0121", "21");
    CATEGORIE_TABLE_ECHANGE.put("FOR_AFF03_0322", "22");
    CATEGORIE_TABLE_ECHANGE.put("FOR_AFF03_0323", "23");
    
    CATEGORIE_TABLE_ECHANGE.put("ASU_CVE13_01" + Integer.toString(1), "22");
    CATEGORIE_TABLE_ECHANGE.put("ASU_CVE13_01" + Integer.toString(2), "23");
    CATEGORIE_TABLE_ECHANGE.put("ASU_CVE13_01" + Integer.toString(3), "23");
    
    CATEGORIE_TABLE_ECHANGE.put("FOR_RPS02_01" + Integer.toString(11), "11");
    CATEGORIE_TABLE_ECHANGE.put("FOR_RPS02_01" + Integer.toString(12), "12");
    CATEGORIE_TABLE_ECHANGE.put("FOR_RPS02_01" + Integer.toString(19), "19");
    CATEGORIE_TABLE_ECHANGE.put("FOR_RPS02_01" + Integer.toString(15), "15");
    CATEGORIE_TABLE_ECHANGE.put("FOR_RPS02_01" + Integer.toString(16), "16");
    CATEGORIE_TABLE_ECHANGE.put("FOR_RPS02_01" + Integer.toString(17), "17");
    CATEGORIE_TABLE_ECHANGE.put("FOR_RPS02_01" + Integer.toString(18), "18");
    
    CATEGORIE_TABLE_ECHANGE.put("RBF_FPO04_02AP", "AP");
    CATEGORIE_TABLE_ECHANGE.put("RBF_HBT01_02AP", "AP");
    CATEGORIE_TABLE_ECHANGE.put("RBF_RTN03_02AP", "AP");
    CATEGORIE_TABLE_ECHANGE.put("RBF_TPT02_02AP", "AP");
    CATEGORIE_TABLE_ECHANGE.put("RBF_AIDES_01RH", "RH");
    CATEGORIE_TABLE_ECHANGE.put("RBF_AIDES_01AL", "AL");
    
    LIB_CATEGORIE_ATTRIBUTION = new HashMap();
    
    LIB_CATEGORIE_ATTRIBUTION.put("SOL_ATA06_0104", "DEMANDEURS D'ASILE");
    LIB_CATEGORIE_ATTRIBUTION.put("SOL_ATA06_0105", "DETENUS LIBERES");
    LIB_CATEGORIE_ATTRIBUTION.put("SOL_ATA06_0106", "BENEF. PROTEC. TEMPORAIRE");
    LIB_CATEGORIE_ATTRIBUTION.put("SOL_ATA06_0107", "BENEF. PROTEC. SUBSIDIAIRE");
    LIB_CATEGORIE_ATTRIBUTION.put("SOL_ATA06_0108", "VICTIMES TRAITE HUMAINE");
    LIB_CATEGORIE_ATTRIBUTION.put("SOL_ATA06_0109", "APATRIDES");
    LIB_CATEGORIE_ATTRIBUTION.put("SOL_ATA06_0110", "EXPATRIES");
    
    LIB_CATEGORIE_ATTRIBUTION.put("FOR_RFP04_010", "INDETERMINE");
    LIB_CATEGORIE_ATTRIBUTION.put("FOR_RFP04_0111", "TRAVAILLEURS SAL SANS EMPLOI");
    LIB_CATEGORIE_ATTRIBUTION.put("FOR_RFP04_0112", "PUBLIC SITU FAMIL PARTIC");
    LIB_CATEGORIE_ATTRIBUTION.put("FOR_RFP04_0113", "DE HANDICAPES");
    LIB_CATEGORIE_ATTRIBUTION.put("FOR_RFP04_0114", "TRAVAILLEURS SAL SS EMPL HAND");
    LIB_CATEGORIE_ATTRIBUTION.put("FOR_RFP04_0115", "PRIMO DEMANDEUR MOIS DE 18 ANS");
    LIB_CATEGORIE_ATTRIBUTION.put("FOR_RFP04_0116", "PRIMO DEMANDEUR DE 18 A 20 ANS");
    LIB_CATEGORIE_ATTRIBUTION.put("FOR_RFP04_0117", "PRIMO DEMANDEUR DE 21 A 25 ANS");
    LIB_CATEGORIE_ATTRIBUTION.put("FOR_RFP04_0118", "PRIMO DEMANDEUR PLUS DE 25 ANS");
    
    LIB_CATEGORIE_ATTRIBUTION.put("FOR_RPS02_0111", "TRAVAILLEURS_SAL_SANS_EMPLOI");
    LIB_CATEGORIE_ATTRIBUTION.put("FOR_RPS02_0112", "PUBLIC_SITU_FAMIL_PARTIC");
    LIB_CATEGORIE_ATTRIBUTION.put("FOR_RPS02_0119", "PRIMO_DEMANDEUR");
    LIB_CATEGORIE_ATTRIBUTION.put("FOR_RPS02_0115", "PRIMO_DEMANDEUR_MOIS_DE_18_ANS");
    LIB_CATEGORIE_ATTRIBUTION.put("FOR_RPS02_0116", "PRIMO_DEMANDEUR_DE_18_A_20_ANS");
    LIB_CATEGORIE_ATTRIBUTION.put("FOR_RPS02_0117", "PRIMO_DEMANDEUR_DE_21_A_25_ANS");
    LIB_CATEGORIE_ATTRIBUTION.put("FOR_RPS02_0118", "PRIMO_DEMANDEUR_PLUS_DE_25_ANS");
    
    LIB_CATEGORIE_ATTRIBUTION.put("FOR_AFF03_0120", "AFFDEF");
    LIB_CATEGORIE_ATTRIBUTION.put("FOR_AFF03_0121", "AFFDEF2010");
    LIB_CATEGORIE_ATTRIBUTION.put("FOR_AFF03_0322", "RFF2012");
    LIB_CATEGORIE_ATTRIBUTION.put("FOR_AFF03_0323", "RFF2013");
    
    LIB_CATEGORIE_ATTRIBUTION.put("ASU_CVE13_0103", "BASSIN CRP");
    LIB_CATEGORIE_ATTRIBUTION.put("ASU_CVE13_0122", "BASSIN CTP 06");
    LIB_CATEGORIE_ATTRIBUTION.put("ASU_CVE13_0123", "BASSIN CTP 09");
    
    LIB_CATEGORIE_ATTRIBUTION.put("SOL_AER05_0111", "AER 2009");
    
    LIB_CATEGORIE_ATTRIBUTION.put("INR_RCE04_0109", "ARCE 2009");
    LIB_CATEGORIE_ATTRIBUTION.put("INR_RCE04_0111", "ARCE 2011");
    LIB_CATEGORIE_ATTRIBUTION.put("INR_RCE04_0145", "ARCE 2011");
    LIB_CATEGORIE_ATTRIBUTION.put("INR_RCE04_01A8", "ARCE SPE 2016");
    
    LIB_CATEGORIE_ATTRIBUTION.put("INR_ADR03_0211", "ADR 2011");
    
    LIB_CATEGORIE_ATTRIBUTION.put("RBF_FPO04_02AP", "APRE");
    LIB_CATEGORIE_ATTRIBUTION.put("RBF_HBT01_02AP", "APRE");
    LIB_CATEGORIE_ATTRIBUTION.put("RBF_RTN03_02AP", "APRE");
    LIB_CATEGORIE_ATTRIBUTION.put("RBF_TPT02_02AP", "APRE");
    LIB_CATEGORIE_ATTRIBUTION.put("RBF_AIDES_01RH", "APRE");
    LIB_CATEGORIE_ATTRIBUTION.put("RBF_AIDES_01AL", "APRE");
  }
}

/* Location:
 * Qualified Name:     ConstantesCategorieTableEchange
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */