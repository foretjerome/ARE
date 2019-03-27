package fr.unedic.d90.service.rac.commun.d90;

public abstract interface D90Constantes
{
  public static final String TYPE_FLUX_AEM = "AEM";
  public static final String TYPE_FLUX_BS = "BS";
  public static final String TYPE_FLUX_CAF = "CLCA";
  public static final String TYPE_FLUX_CAFR = "CLCAR";
  public static final String TYPE_FLUX_MSA = "MSA";
  public static final String TYPE_FLUX_CPAM = "IJSS";
  public static final String TYPE_FLUX_DSM = "DSM";
  public static final String TYPE_FLUX_DSM_SPECTACLE = "SDSM";
  public static final String TYPE_FLUX_ETT = "ETT";
  public static final String TYPE_FLUX_ETTR = "ETTR";
  public static final String TYPE_FLUX_GUSO = "GUSO";
  public static final String TYPE_FLUX_CALIX = "CALIX";
  public static final String TYPE_FLUX_CALI = "CALI";
  public static final String TYPE_FLUX_OCC_CALCUL = "GRCA";
  public static final String TYPE_FLUX_OCC_CALCUL_ST = "GRST";
  public static final String TYPE_FLUX_OCC_CALI_STEP_CINQ = "GRC5";
  public static final String TYPE_FLUX_OCC_CALI_SECUR_A = "GRSA";
  public static final String TYPE_FLUX_OCC_CALI_SECUR_B = "GRSB";
  public static final String TYPE_FLUX_OCC_CALCUL_SIMU_REGLE = "GRSC";
  public static final String TYPE_FLUX_OCC_MASSE_CALI_1 = "90AK1";
  public static final String TYPE_FLUX_OCC_MASSE_CALI_SIMU_1 = "90A1K";
  public static final String TYPE_FLUX_OCC_MASSE_CALI_2 = "90AK2";
  public static final String TYPE_FLUX_OCC_MASSE_CALI_SIMU_2 = "90A2K";
  public static final String TYPE_FLUX_OCC_MASSE_CALI_3 = "90AK3";
  public static final String TYPE_FLUX_OCC_MASSE_CALI_SIMU_3 = "90A3K";
  public static final String TYPE_FLUX_OCC_MASSE_CALI_4 = "90AK4";
  public static final String TYPE_FLUX_OCC_MASSE_CALI_SIMU_4 = "90A4K";
  public static final String TYPE_FLUX_OCC_MASSE_CALI_5 = "90AK5";
  public static final String TYPE_FLUX_OCC_MASSE_CALI_SIMU_5 = "90A5K";
  public static final String TYPE_FLUX_OCC_MASSE_CALI_6 = "90AK6";
  public static final String TYPE_FLUX_OCC_MASSE_CALI_SIMU_6 = "90A6K";
  public static final String TYPE_FLUX_OCC_MASSE_GAEC_1 = "90AM1";
  public static final String TYPE_FLUX_OCC_MASSE_GAEC_SIMU_1 = "90A1M";
  public static final String TYPE_FLUX_OCC_MASSE_GAEC_2 = "90AM2";
  public static final String TYPE_FLUX_OCC_MASSE_GAEC_SIMU_2 = "90A2M";
  public static final String TYPE_FLUX_OCC_MASSE_GAEC_3 = "90AM3";
  public static final String TYPE_FLUX_OCC_MASSE_GAEC_SIMU_3 = "90A3M";
  public static final String TYPE_FLUX_CALIM = "CALIM";
  public static final String TYPE_FLUX_CALIR = "CALIR";
  public static final String TYPE_FLUX_OCC_CSS = "CALIC";
  public static final String TYPE_FLUX_OCC_REEXAMEN = "GRREEXAM";
  public static final String TYPE_FLUX_OCC_GAEC = "GRGA";
  public static final String TYPE_FLUX_OCC_GAEC_ST = "GAST";
  public static final String TYPE_FLUX_MIGRATION = "MIGR";
  public static final String TYPE_FLUX_EPUR_MIGR = "EMIGR";
  public static final String TYPE_FLUX_EPUR_TRAN = "ETRAN";
  public static final String CODE_FLUX_OCCASIONEL_CALCUL_1 = "OCCAT1";
  public static final String CODE_FLUX_OCCASIONEL_CALCUL_2 = "OCCAT2";
  public static final String TYPE_FLUX_PASDNA = "PSDNA";
  public static final String TYPE_FLUX_FCTDNA = "FCDNA";
  public static final String TYPE_FLUX_AETESSI = "AETES";
  public static final String TYPE_FLUX_STOCK = "STOCK";
  public static final String MODE_NORMAL = "Normal";
  public static final String MODE_SANS_TRACKER = "SansTracker";
  public static final String MODE_NORMAL_AVEC_TRACKER = "NormalAvecTracker";
  public static final String MODE_NORMAL_SANS_TRACKER = "NormalSansTracker";
  public static final String MODE_SIMU_SANS_TRACKER = "SimuSansTracker";
  public static final String MODE_LISTE = "List";
  public static final String MODE_OCCASIONNEL_GAEC = "GAEC";
  public static final String TYPE_FLUX_EPUR_DEMON = "DEMON";
  public static final String MODE_DEGRADE = "Degrade";
  public static final String TYPE_FLUX_REPRISE_DMMICCP = "DMMV4";
  public static final String TYPE_FLUX_DMM = "DMM";
  public static final String TYPE_FLUX_DMMR = "DMMR";
  public static final String TYPE_FLUX_EAEM = "EAEM";
  public static final String TYPE_FLUX_EGUSO = "EGUSO";
  public static final String TYPE_FLUX_IAEM = "IAEM";
  public static final String TYPE_FLUX_IGUSO = "IGUSO";
  public static final String MODE_LOURD = "Lourd";
  public static final String MODE_LOURD_SANS_TRACKER = "LourdSansTracker";
  public static final String TYPE_FLUX_OCC_LOURD = "GRGX";
  public static final String CODE_FLUX_OCCASIONEL_PF = "OCCAPF";
  public static final String OCCAPF_SEL_LOURDE_1 = "SelectionLourdPop01";
  public static final String OCCAPF_SEL_LOURDE_2 = "SelectionLourdPop02";
  public static final String OCCAPF_SEL_LOURDE_3 = "SelectionLourdPop03";
  public static final String CAS_UTILISATION = "CasUtilisation";
  public static final String CAS_UTILISATION_DEMANDE_ECRIRE_EVT_ASYNC = "DemandeEcrireEvtAsync";
  public static final String CAS_UTILISATION_ANNULATION_ECRIRE_EVT_ASYNC = "AnnulerEcrireEvtAsync";
  public static final String CODE_FLUX_CALI_DEMANDE_ECRIRE_EVT_ASYNC = "DCADI";
  public static final String CODE_FLUX_CALI_ANNULATION_ECRIRE_EVT_ASYNC = "ACADI";
  public static final String CODE_FLUX_CALI_EMISSION_ECRIRE_EVT_ASYNC = "ECADI";
  public static final String TYPE_FLUX_MIGSP = "MIGSP";
  public static final String TYPE_FLUX_MA7R = "MA7R";
  public static final String TYPE_FLUX_MA7T = "MA7T";
  public static final String TYPE_FLUX_MA7U = "MA7U";
  public static final String TYPE_FLUX_MA7W = "MA7W";
  public static final String TYPE_FLUX_ODF = "ODF";
  public static final String MODE_SANS_TRACES_EMISSION = "SansTracesEmission";
  public static final String TYPE_FLUX_KC08 = "KC08";
  public static final String TYPE_FLUX_MA7V = "MA7V";
  public static final String TYPE_FLUX_AIS = "CALIA";
  public static final String TYPE_FLUX_DPAE = "DPAE";
  public static final String CAS_UTILISATION_DEMANDE_ECRIRE_EVT_DESENG_AIDE = "DemandeEcrireEvtDesengAide";
  public static final String CAS_UTILISATION_SUPPR_ECRIRE_EVT_DESENG_AIDE = "SupprEcrireEvtDesengAide";
  public static final String TYPE_FLUX_DESAID = "DESAI";
  public static final String CODE_FLUX_CALI_DEMANDE_ECRIRE_EVT_DESENG_AIDE = "DDSAI";
  public static final String CODE_FLUX_CALI_SUPPR_ECRIRE_EVT_DESENG_AIDE = "SDSAI";
}

/* Location:
 * Qualified Name:     D90Constantes
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */