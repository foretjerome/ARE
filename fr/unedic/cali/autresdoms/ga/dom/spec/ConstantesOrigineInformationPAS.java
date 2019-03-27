package fr.unedic.cali.autresdoms.ga.dom.spec;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public abstract class ConstantesOrigineInformationPAS
{
  public static final int INDETERMINE = 0;
  public static final String LIB_ORIGINE_INDETERMINE = "Indéterminé";
  public static final int ATTESTATION_EMPLOYEUR = 1;
  public static final String LIB_ORIGINE_ATTESTATION_EMPLOYEUR = "AE";
  public static final int AE_WEB = 2;
  public static final int CONTRAT_TRAVAIL = 3;
  public static final String LIB_ORIGINE_CONTRAT_TRAVAIL = "CoT";
  public static final int AEM = 4;
  public static final String LIB_ORIGINE_AEM = "AEM";
  public static final int FEUILLET_GUSO = 5;
  public static final String LIB_ORIGINE_FEUILLET_GUSO = "GUSO";
  public static final int FEUILLET_PONT_GUSO = 6;
  public static final String LIB_ORIGINE_FEUILLET_PONT_GUSO = "GUSO";
  public static final int DDTE = 8;
  public static final int DECLARATION_MENSUELLE_MISSION = 9;
  public static final String LIB_ORIGINE_DECLARATION_MENSUELLE_MISSION = "DMM";
  public static final int E301 = 10;
  public static final String LIB_ORIGINE_E301 = "E301";
  public static final int CERTIFICAT_TRAVAIL = 11;
  public static final String LIB_ORIGINE_CERTIFICAT_TRAVAIL = "CeT";
  public static final int BULLETIN_SALAIRE = 12;
  public static final int BULLETIN_SALAIRE_IMPORTE = 15;
  public static final int COMMISSION_PARITAIRE_DELEGATAIRE = 13;
  public static final int JUGEMENT_PRUDHOMMAL = 14;
  public static final int DOCUMENT_AA_13_5 = 71;
  public static final String LIB_ORIGINE_DOCUMENT_AA_13_5 = "A13§5A";
  public static final int LETTRE_LICENCIEMENT = 72;
  public static final int AUTRE_DOCUMENT = 73;
  public static final int TESA = 74;
  public static final String LIB_ORIGINE_TESA = "TESA";
  public static final int ETT = 16;
  public static final int CT_CRP = 33;
  public static final String LIB_ORIGINE_CT_CRP = "AE CRP";
  public static final int CT_CTP = 34;
  public static final String LIB_ORIGINE_CT_CTP = "AE CTP";
  public static final int CT_CSP = 56;
  public static final String LIB_ORIGINE_CT_CSP = "AE CSP";
  public static final int AE_FNE = 39;
  public static final int DSN = 110;
  public static final String LIB_ORIGINE_DSN = "DSN";
  public static final int AFFICHAGE_BS_PLUSIEURS = 999;
  public static final int AFFICHAGE_CERTIFICAT_TRAVAIL_AVEC_BS = 998;
  public static final String LIB_AFFICHAGE_ORIGINE_CERTIFICAT_TRAVAIL_AVEC_BS = "CeT+BS";
  public static final int AFFICHAGE_CONTRAT_TRAVAIL_AVEC_BS = 997;
  public static final String LIB_AFFICHAGE_ORIGINE_CONTRAT_TRAVAIL_AVEC_BS = "CoT+BS";
  public static final int PRIORITE_CERTIF_TRAVAIL = 3;
  public static final int PRIORITE_DSN = 2;
  public static final int PRIORITE_CONTRAT_TRAVAIL = 4;
  public static final int PRIORITE_AE_EQUIV = 1;
  public static final int PRIORITE_BS = 5;
  public static final int PRIORITE_AUTRES = 0;
  private static Map<BigDecimal, String> libelleOrigineInformation = new HashMap();
  
  static
  {
    libelleOrigineInformation.put(BigDecimal.valueOf(1L), "AE");
    libelleOrigineInformation.put(BigDecimal.valueOf(3L), "CoT");
    libelleOrigineInformation.put(BigDecimal.valueOf(4L), "AEM");
    libelleOrigineInformation.put(BigDecimal.valueOf(6L), "GUSO");
    libelleOrigineInformation.put(BigDecimal.valueOf(5L), "GUSO");
    libelleOrigineInformation.put(BigDecimal.valueOf(9L), "DMM");
    libelleOrigineInformation.put(BigDecimal.valueOf(10L), "E301");
    libelleOrigineInformation.put(BigDecimal.valueOf(11L), "CeT");
    libelleOrigineInformation.put(BigDecimal.valueOf(71L), "A13§5A");
    libelleOrigineInformation.put(BigDecimal.valueOf(74L), "TESA");
    libelleOrigineInformation.put(BigDecimal.valueOf(998L), "CeT+BS");
    libelleOrigineInformation.put(BigDecimal.valueOf(997L), "CoT+BS");
    libelleOrigineInformation.put(BigDecimal.valueOf(33L), "AE CRP");
    libelleOrigineInformation.put(BigDecimal.valueOf(34L), "AE CTP");
    libelleOrigineInformation.put(BigDecimal.valueOf(56L), "AE CSP");
    libelleOrigineInformation.put(BigDecimal.valueOf(110L), "DSN");
  }
  
  public static String getOrigineInformation(BigDecimal code)
  {
    return (String)libelleOrigineInformation.get(code);
  }
}

/* Location:
 * Qualified Name:     ConstantesOrigineInformationPAS
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */