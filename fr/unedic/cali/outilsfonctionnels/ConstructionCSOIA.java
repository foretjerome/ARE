package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.util.services.CoucheLogiqueException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public final class ConstructionCSOIA
{
  private static HashMap<CleCSOIA, String> typeExamenDepuisV1 = new HashMap();
  private static HashMap<String, CleCSOIA> csoiaDepuisTypeExamen = new HashMap();
  private static List<String> listeCsoiaGammeAsu = new ArrayList();
  
  static
  {
    CleCSOIA cle = new CleCSOIA("ASU", null, null, "5");
    typeExamenDepuisV1.put(cle, "ASU_01");
    csoiaDepuisTypeExamen.put("ASU_01", cle);
    listeCsoiaGammeAsu.add("5");
    
    cle = new CleCSOIA("ASU", null, null, "8");
    typeExamenDepuisV1.put(cle, "ASU_02");
    csoiaDepuisTypeExamen.put("ASU_02", cle);
    listeCsoiaGammeAsu.add("8");
    
    cle = new CleCSOIA("ASU", null, null, "I");
    typeExamenDepuisV1.put(cle, "ASU_03");
    csoiaDepuisTypeExamen.put("ASU_03", cle);
    listeCsoiaGammeAsu.add("I");
    
    cle = new CleCSOIA("ASU", null, null, "Y");
    typeExamenDepuisV1.put(cle, "ASU_04");
    csoiaDepuisTypeExamen.put("ASU_04", cle);
    listeCsoiaGammeAsu.add("Y");
    
    cle = new CleCSOIA("ASU", null, null, "7");
    typeExamenDepuisV1.put(cle, "ASU_08");
    csoiaDepuisTypeExamen.put("ASU_08", cle);
    listeCsoiaGammeAsu.add("7");
    
    cle = new CleCSOIA(null, null, null, "U");
    typeExamenDepuisV1.put(cle, "ASU_05");
    csoiaDepuisTypeExamen.put("ASU_05", cle);
    listeCsoiaGammeAsu.add("U");
    
    cle = new CleCSOIA(null, null, null, "12");
    typeExamenDepuisV1.put(cle, "ASU_07");
    csoiaDepuisTypeExamen.put("ASU_07", cle);
    listeCsoiaGammeAsu.add("12");
    
    cle = new CleCSOIA("ASU", null, null, "72");
    typeExamenDepuisV1.put(cle, "ASU_22");
    csoiaDepuisTypeExamen.put("ASU_22", cle);
    listeCsoiaGammeAsu.add("72");
    
    cle = new CleCSOIA("ASU", null, null, "31");
    typeExamenDepuisV1.put(cle, "ASU_23");
    csoiaDepuisTypeExamen.put("ASU_23", cle);
    listeCsoiaGammeAsu.add("31");
    
    cle = new CleCSOIA("ASU", "ASU_SSP07", null, "R2");
    typeExamenDepuisV1.put(cle, "ASU_14");
    csoiaDepuisTypeExamen.put("ASU_14", cle);
    listeCsoiaGammeAsu.add("R2");
    
    cle = new CleCSOIA("ASU", "ASU_SSP07", null, "R1");
    typeExamenDepuisV1.put(cle, "ASU_11");
    csoiaDepuisTypeExamen.put("ASU_11", cle);
    listeCsoiaGammeAsu.add("R1");
    
    cle = new CleCSOIA("ASU", "ASU_SSP07", null, "R3");
    
    typeExamenDepuisV1.put(cle, "ASU_09");
    csoiaDepuisTypeExamen.put("ASU_09", cle);
    listeCsoiaGammeAsu.add("R3");
    
    cle = new CleCSOIA("ASU", "ASU_FDS12", null, "R5");
    
    typeExamenDepuisV1.put(cle, "ASU_15");
    csoiaDepuisTypeExamen.put("ASU_15", cle);
    listeCsoiaGammeAsu.add("R5");
    
    cle = new CleCSOIA("ASU", "ASU_FDS12", null, "R4");
    typeExamenDepuisV1.put(cle, "ASU_12");
    csoiaDepuisTypeExamen.put("ASU_12", cle);
    listeCsoiaGammeAsu.add("R4");
    
    cle = new CleCSOIA("ASU", "ASU_FDS12", null, "R6");
    typeExamenDepuisV1.put(cle, "ASU_10");
    csoiaDepuisTypeExamen.put("ASU_10", cle);
    listeCsoiaGammeAsu.add("R6");
    
    cle = new CleCSOIA("ASU", null, null, "71");
    typeExamenDepuisV1.put(cle, "ASU_13");
    csoiaDepuisTypeExamen.put("ASU_13", cle);
    listeCsoiaGammeAsu.add("71");
    
    cle = new CleCSOIA("ASU", null, null, "T");
    typeExamenDepuisV1.put(cle, "ASU_16");
    csoiaDepuisTypeExamen.put("ASU_16", cle);
    listeCsoiaGammeAsu.add("T");
    
    cle = new CleCSOIA("ASU", null, null, "T1");
    typeExamenDepuisV1.put(cle, "ASU_17");
    csoiaDepuisTypeExamen.put("ASU_17", cle);
    listeCsoiaGammeAsu.add("T1");
    
    cle = new CleCSOIA("ASU", null, null, "T2");
    typeExamenDepuisV1.put(cle, "ASU_18");
    csoiaDepuisTypeExamen.put("ASU_18", cle);
    listeCsoiaGammeAsu.add("T2");
    
    cle = new CleCSOIA("ASU", null, null, "T3");
    typeExamenDepuisV1.put(cle, "ASU_20");
    csoiaDepuisTypeExamen.put("ASU_20", cle);
    listeCsoiaGammeAsu.add("T3");
    
    cle = new CleCSOIA("ASU", null, null, "T4");
    typeExamenDepuisV1.put(cle, "ASU_19");
    csoiaDepuisTypeExamen.put("ASU_19", cle);
    listeCsoiaGammeAsu.add("T4");
    
    cle = new CleCSOIA(null, null, null, "13");
    typeExamenDepuisV1.put(cle, "ASU_21");
    csoiaDepuisTypeExamen.put("ASU_21", cle);
    listeCsoiaGammeAsu.add("13");
    
    cle = new CleCSOIA("ASU", null, null, "T5");
    typeExamenDepuisV1.put(cle, "ASU_24");
    csoiaDepuisTypeExamen.put("ASU_24", cle);
    listeCsoiaGammeAsu.add("T5");
    
    cle = new CleCSOIA("ASU", null, null, "T6");
    typeExamenDepuisV1.put(cle, "ASU_25");
    csoiaDepuisTypeExamen.put("ASU_25", cle);
    listeCsoiaGammeAsu.add("T6");
    
    cle = new CleCSOIA("ASU", null, null, "83");
    typeExamenDepuisV1.put(cle, "ASU_29");
    csoiaDepuisTypeExamen.put("ASU_29", cle);
    listeCsoiaGammeAsu.add("83");
    
    cle = new CleCSOIA("ASU", null, null, "82");
    typeExamenDepuisV1.put(cle, "ASU_28");
    csoiaDepuisTypeExamen.put("ASU_28", cle);
    listeCsoiaGammeAsu.add("82");
    
    cle = new CleCSOIA("ASU", null, null, "81");
    typeExamenDepuisV1.put(cle, "ASU_27");
    csoiaDepuisTypeExamen.put("ASU_27", cle);
    listeCsoiaGammeAsu.add("81");
    
    cle = new CleCSOIA("ASU", null, null, "84");
    typeExamenDepuisV1.put(cle, "ASU_30");
    csoiaDepuisTypeExamen.put("ASU_30", cle);
    listeCsoiaGammeAsu.add("84");
    
    cle = new CleCSOIA("ASU", null, null, "73");
    typeExamenDepuisV1.put(cle, "ASU_31");
    csoiaDepuisTypeExamen.put("ASU_31", cle);
    listeCsoiaGammeAsu.add("73");
    
    cle = new CleCSOIA("MNT", null, null, "07");
    typeExamenDepuisV1.put(cle, "ASU_06");
    csoiaDepuisTypeExamen.put("ASU_06", cle);
    
    cle = new CleCSOIA("SOL", "SOL_CGE01", null, "6");
    typeExamenDepuisV1.put(cle, "SOL_03");
    csoiaDepuisTypeExamen.put("SOL_03", cle);
    
    cle = new CleCSOIA("SOL", "SOL_CGE01", null, "N");
    typeExamenDepuisV1.put(cle, "SOL_06");
    csoiaDepuisTypeExamen.put("SOL_06", cle);
    
    cle = new CleCSOIA("SOL", "SOL_CGE01", null, "2");
    
    typeExamenDepuisV1.put(cle, "SOL_07");
    csoiaDepuisTypeExamen.put("SOL_07", cle);
    
    cle = new CleCSOIA("SOL", "SOL_CGE01", null, "W");
    
    typeExamenDepuisV1.put(cle, "SOL_09");
    csoiaDepuisTypeExamen.put("SOL_09", cle);
    
    cle = new CleCSOIA("SOL", "SOL_CGE01", null, "D");
    typeExamenDepuisV1.put(cle, "SOL_10");
    csoiaDepuisTypeExamen.put("SOL_10", cle);
    
    cle = new CleCSOIA("SOL", "SOL_CGE01", null, "3");
    typeExamenDepuisV1.put(cle, "SOL_04");
    csoiaDepuisTypeExamen.put("SOL_04", cle);
    
    cle = new CleCSOIA("SOL", "SOL_CGE01", null, "17");
    typeExamenDepuisV1.put(cle, "SOL_01");
    csoiaDepuisTypeExamen.put("SOL_01", cle);
    
    cle = new CleCSOIA("SOL", "SOL_CPA02", null, "9");
    typeExamenDepuisV1.put(cle, "SOL_05");
    csoiaDepuisTypeExamen.put("SOL_05", cle);
    
    cle = new CleCSOIA("SOL", "SOL_AER05", null, "P");
    typeExamenDepuisV1.put(cle, "SOL_08");
    csoiaDepuisTypeExamen.put("SOL_08", cle);
    
    cle = new CleCSOIA("SOL", "SOL_AER05", null, "P1");
    typeExamenDepuisV1.put(cle, "SOL_21");
    csoiaDepuisTypeExamen.put("SOL_21", cle);
    
    cle = new CleCSOIA("SOL", "SOL_AER05", null, "34");
    typeExamenDepuisV1.put(cle, "SOL_02");
    csoiaDepuisTypeExamen.put("SOL_02", cle);
    
    cle = new CleCSOIA("SOL", null, null, "91");
    typeExamenDepuisV1.put(cle, "SOL_20");
    csoiaDepuisTypeExamen.put("SOL_20", cle);
    
    cle = new CleCSOIA("SOL", null, null, "92");
    typeExamenDepuisV1.put(cle, "SOL_22");
    csoiaDepuisTypeExamen.put("SOL_22", cle);
    
    cle = new CleCSOIA("SOL", null, null, "93");
    typeExamenDepuisV1.put(cle, "SOL_23");
    csoiaDepuisTypeExamen.put("SOL_23", cle);
    
    cle = new CleCSOIA("SOL", null, null, "94");
    typeExamenDepuisV1.put(cle, "SOL_24");
    csoiaDepuisTypeExamen.put("SOL_24", cle);
    
    cle = new CleCSOIA("SOL", "SOL_CGE01", null, "61");
    typeExamenDepuisV1.put(cle, "SOL_26");
    csoiaDepuisTypeExamen.put("SOL_26", cle);
    
    String gammeATA = "SOL";
    String ligneATA = "SOL_ATA06";
    String produitATA = null;
    
    cle = new CleCSOIA(gammeATA, ligneATA, produitATA, "5");
    typeExamenDepuisV1.put(cle, "SOL_14");
    csoiaDepuisTypeExamen.put("SOL_14", cle);
    
    cle = new CleCSOIA(gammeATA, ligneATA, produitATA, "A");
    typeExamenDepuisV1.put(cle, "SOL_15");
    csoiaDepuisTypeExamen.put("SOL_15", cle);
    
    cle = new CleCSOIA(gammeATA, ligneATA, produitATA, "F");
    typeExamenDepuisV1.put(cle, "SOL_16");
    csoiaDepuisTypeExamen.put("SOL_16", cle);
    
    cle = new CleCSOIA(gammeATA, ligneATA, produitATA, "A2");
    typeExamenDepuisV1.put(cle, "SOL_13");
    csoiaDepuisTypeExamen.put("SOL_13", cle);
    
    cle = new CleCSOIA(gammeATA, ligneATA, produitATA, "17");
    typeExamenDepuisV1.put(cle, "SOL_11");
    csoiaDepuisTypeExamen.put("SOL_11", cle);
    
    cle = new CleCSOIA(gammeATA, ligneATA, produitATA, "A1");
    typeExamenDepuisV1.put(cle, "SOL_12");
    csoiaDepuisTypeExamen.put("SOL_12", cle);
    
    String gammeAEPE = "SOL";
    String ligneAEPE = "SOL_SUB09";
    String produitAEPE = null;
    
    cle = new CleCSOIA(gammeAEPE, ligneAEPE, produitAEPE, "A3");
    typeExamenDepuisV1.put(cle, "SOL_17");
    csoiaDepuisTypeExamen.put("SOL_17", cle);
    
    cle = new CleCSOIA(gammeAEPE, ligneAEPE, produitAEPE, "A4");
    typeExamenDepuisV1.put(cle, "SOL_18");
    csoiaDepuisTypeExamen.put("SOL_18", cle);
    
    cle = new CleCSOIA(gammeAEPE, ligneAEPE, produitAEPE, "A5");
    typeExamenDepuisV1.put(cle, "SOL_19");
    csoiaDepuisTypeExamen.put("SOL_19", cle);
    
    cle = new CleCSOIA("FOR", "FOR_AFF03", "FOR_AFF03_01", "7");
    typeExamenDepuisV1.put(cle, "FOR_02");
    csoiaDepuisTypeExamen.put("FOR_02", cle);
    
    cle = new CleCSOIA("FOR", "FOR_RFP04", "FOR_RFP04_01", "E1");
    typeExamenDepuisV1.put(cle, "FOR_03");
    csoiaDepuisTypeExamen.put("FOR_03", cle);
    
    cle = new CleCSOIA("FOR", "FOR_RPS02", "FOR_RPS02_01", "E");
    typeExamenDepuisV1.put(cle, "FOR_01");
    csoiaDepuisTypeExamen.put("FOR_01", cle);
    
    cle = new CleCSOIA("INR", "INR_CES06", "INR_CES06_01", "L");
    typeExamenDepuisV1.put(cle, "INR_01");
    csoiaDepuisTypeExamen.put("INR_01", cle);
    
    cle = new CleCSOIA("INR", "INR_RCE04", "INR_RCE04_01", "21");
    typeExamenDepuisV1.put(cle, "INR_02");
    csoiaDepuisTypeExamen.put("INR_02", cle);
    
    cle = new CleCSOIA("INR", "INR_ADR03", "INR_ADR03_02", "26");
    typeExamenDepuisV1.put(cle, "INR_03");
    csoiaDepuisTypeExamen.put("INR_03", cle);
    
    cle = new CleCSOIA("RBF", null, null, "10");
    typeExamenDepuisV1.put(cle, "RBF_01");
    csoiaDepuisTypeExamen.put("RBF_01", cle);
    
    cle = new CleCSOIA("RBF", null, null, "11");
    typeExamenDepuisV1.put(cle, "RBF_02");
    csoiaDepuisTypeExamen.put("RBF_02", cle);
    
    cle = new CleCSOIA("RBF", null, null, "14");
    typeExamenDepuisV1.put(cle, "RBF_03");
    csoiaDepuisTypeExamen.put("RBF_03", cle);
    
    cle = new CleCSOIA("RBF", null, null, "15");
    typeExamenDepuisV1.put(cle, "RBF_04");
    csoiaDepuisTypeExamen.put("RBF_04", cle);
    
    cle = new CleCSOIA("RBF", null, null, "16");
    typeExamenDepuisV1.put(cle, "RBF_05");
    csoiaDepuisTypeExamen.put("RBF_05", cle);
    
    cle = new CleCSOIA("ARI", null, null, "L");
    typeExamenDepuisV1.put(cle, "ARI_01");
    csoiaDepuisTypeExamen.put("ARI_01", cle);
    
    cle = new CleCSOIA("ARI", null, null, "P3");
    typeExamenDepuisV1.put(cle, "SOL_25");
    csoiaDepuisTypeExamen.put("SOL_25", cle);
    
    cle = new CleCSOIA("ARI", null, null, "18");
    typeExamenDepuisV1.put(cle, "ARI_02");
    csoiaDepuisTypeExamen.put("ARI_02", cle);
    
    cle = new CleCSOIA("PRR", "PRR_PRL02", "PRR_PRL02_01", "4");
    typeExamenDepuisV1.put(cle, "PRR_01");
    csoiaDepuisTypeExamen.put("PRR_01", cle);
    
    cle = new CleCSOIA("DEC", "DEC_CGE01", "DEC_CGE01_01", "87");
    typeExamenDepuisV1.put(cle, "DEC_01");
    csoiaDepuisTypeExamen.put("DEC_01", cle);
    
    cle = new CleCSOIA("INR", "INR_PAR09", "INR_PAR09_01", "29");
    typeExamenDepuisV1.put(cle, "INR_04");
    csoiaDepuisTypeExamen.put("INR_04", cle);
  }
  
  public static String getCSOIADepuisTypeExamen(String typeExamen)
  {
    CleCSOIA cle = (CleCSOIA)csoiaDepuisTypeExamen.get(typeExamen);
    if (cle != null) {
      return cle.getCsoia();
    }
    return null;
  }
  
  public static String getGammeDepuisTypeExamen(String typeExamen)
  {
    CleCSOIA cle = (CleCSOIA)csoiaDepuisTypeExamen.get(typeExamen);
    if (cle != null) {
      return cle.getGamme();
    }
    return null;
  }
  
  public static String getLigneDepuisTypeExamen(String typeExamen)
  {
    CleCSOIA cle = (CleCSOIA)csoiaDepuisTypeExamen.get(typeExamen);
    if (cle != null) {
      return cle.getLigne();
    }
    return null;
  }
  
  public static String getProduitDepuisTypeExamen(String typeExamen)
  {
    CleCSOIA cle = (CleCSOIA)csoiaDepuisTypeExamen.get(typeExamen);
    if (cle != null) {
      return cle.getProduit();
    }
    return null;
  }
  
  public static String getTypeExamenDepuisV1(String gamme, String ligne, String produit, String csoia)
    throws CoucheLogiqueException
  {
    CleCSOIA cle = new CleCSOIA(gamme, ligne, produit, csoia);
    if (typeExamenDepuisV1.containsKey(cle)) {
      return (String)typeExamenDepuisV1.get(cle);
    }
    StringBuilder message = new StringBuilder("Erreur : la gamme reçue sur la demande V1 n'est pas gérée par liquidation.");
    message.append("gamme [");
    message.append(gamme);
    message.append("], ligne [");
    message.append(ligne);
    message.append("], produit [");
    message.append(produit);
    message.append("], CSOIA [");
    message.append(csoia);
    message.append("]");
    
    throw new CoucheLogiqueException("HG_PR_CALI_L_ERR_GAMME_NON_GEREE_LIQ", message.toString(), null);
  }
  
  public static boolean estGammeAsu(String csioa)
  {
    boolean estAssurance = false;
    if (csioa != null) {
      estAssurance = listeCsoiaGammeAsu.contains(csioa);
    }
    return estAssurance;
  }
  
  public static String recupererTypeExamenDepuisCsoiaPourGamme(String csioa, String gamme)
  {
    Set<CleCSOIA> listeCles = typeExamenDepuisV1.keySet();
    String typeExamen = "";
    for (CleCSOIA cleCourante : listeCles) {
      if ((cleCourante.getCsoia().equals(csioa)) && ((cleCourante.getGamme() == null) || (cleCourante.getGamme().equals(gamme))))
      {
        typeExamen = (String)typeExamenDepuisV1.get(cleCourante);
        break;
      }
    }
    return typeExamen;
  }
}

/* Location:
 * Qualified Name:     ConstructionCSOIA
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */