package fr.unedic.cali.dom.affectation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang.StringUtils;

public class Parametres
{
  private static HashMap tableGammes;
  private static HashMap tableLignes;
  private static HashMap tableProduits;
  private static HashMap tableProduitsParDefaut;
  private static ProduitAbstrait[] listeProduits;
  private static boolean estParametreInitialise;
  
  public static synchronized void initialiserParametres()
  {
    if (!estParametreInitialise) {
      initialisationParametres();
    }
  }
  
  private static void initialisationParametres()
  {
    estParametreInitialise = true;
    
    tableGammes = new HashMap();
    
    tableLignes = new HashMap();
    
    tableProduits = new HashMap();
    
    tableProduitsParDefaut = new HashMap();
    
    tableGammes.put("ASU", GammeAsu.getInstancePourInitialisation());
    tableGammes.put("MNT", GammeMnt.getInstancePourInitialisation());
    tableGammes.put("SOL", GammeSol.getInstancePourInitialisation());
    tableGammes.put("RBF", GammeRbf.getInstancePourInitialisation());
    tableGammes.put("FOR", GammeFor.getInstancePourInitialisation());
    tableGammes.put("INR", GammeInr.getInstancePourInitialisation());
    tableGammes.put("ARI", GammeAri.getInstancePourInitialisation());
    tableGammes.put("RET", GammeRet.getInstancePourInitialisation());
    tableGammes.put("PRR", GammePrr.getInstancePourInitialisation());
    tableGammes.put("DEC", GammeDec.getInstancePourInitialisation());
    
    tableLignes.put("ASU_CGE01", LigneAsuCge01.getInstancePourInitialisation());
    tableLignes.put("ASU_SPE02", LigneAsuSpe02.getInstancePourInitialisation());
    tableLignes.put("ASU_SSP07", LigneAsuSsp07.getInstancePourInitialisation());
    tableLignes.put("ASU_FDS12", LigneAsuFds12.getInstancePourInitialisation());
    tableLignes.put("ASU_CSA06", LigneAsuCsa06.getInstancePourInitialisation());
    tableLignes.put("ASU_CAA14", LigneAsuCaa14.getInstancePourInitialisation());
    tableLignes.put("ASU_CVA10", LigneAsuCva10.getInstancePourInitialisation());
    tableLignes.put("ASU_CVE13", LigneAsuCve13.getInstancePourInitialisation());
    tableLignes.put("ASU_EUR05", LigneAsuEur05.getInstancePourInitialisation());
    tableLignes.put("ASU_DDM16", LigneAsuDdm16.getInstancePourInitialisation());
    tableLignes.put("ASU_MAY17", LigneAsuMay17.getInstancePourInitialisation());
    tableLignes.put("ASU_EXP03", LigneAsuExp03.getInstancePourInitialisation());
    tableLignes.put("SOL_CGE01", LigneSolCge01.getInstancePourInitialisation());
    tableLignes.put("SOL_CPA02", LigneSolCpa02.getInstancePourInitialisation());
    tableLignes.put("SOL_AER05", LigneSolAer05.getInstancePourInitialisation());
    tableLignes.put("SOL_ATA06", LigneSolAta06.getInstancePourInitialisation());
    tableLignes.put("SOL_SUB09", LigneSolSub09.getInstancePourInitialisation());
    tableLignes.put("RBF_HBT01", LigneRbfHbt01.getInstancePourInitialisation());
    tableLignes.put("RBF_TPT02", LigneRbfTpt02.getInstancePourInitialisation());
    tableLignes.put("RBF_RTN03", LigneRbfRtn03.getInstancePourInitialisation());
    tableLignes.put("RBF_FPO04", LigneRbfFpo04.getInstancePourInitialisation());
    tableLignes.put("RBF_MOB07", LigneRbfMob07.getInstancePourInitialisation());
    tableLignes.put("RBF_AGE08", LigneRbfAge08.getInstancePourInitialisation());
    tableLignes.put("RBF_AIDES", LigneRbfAides.getInstancePourInitialisation());
    tableLignes.put("FOR_AFF03", LigneForAff03.getInstancePourInitialisation());
    tableLignes.put("FOR_RFP04", LigneForRfp04.getInstancePourInitialisation());
    tableLignes.put("FOR_RPS02", LigneForRps02.getInstancePourInitialisation());
    tableLignes.put("FOR_CSP05", LigneForCsp05.getInstancePourInitialisation());
    tableLignes.put("INR_CES06", LigneInrCes06.getInstancePourInitialisation());
    tableLignes.put("INR_PFM01", LigneInrPfm01.getInstancePourInitialisation());
    tableLignes.put("INR_RCE04", LigneInrRce04.getInstancePourInitialisation());
    tableLignes.put("ASU_CSR04", LigneAsuCSR04.getInstancePourInitialisation());
    tableLignes.put("INR_ADR03", LigneInrAdr03.getInstancePourInitialisation());
    tableLignes.put("RET_ACO01", LigneRetAco01.getInstancePourInitialisation());
    tableLignes.put("PRR_PRL02", LignePrrPrl02.getInstancePourInitialisation());
    tableLignes.put("PRR_PLF03", LignePrrPlf03.getInstancePourInitialisation());
    tableLignes.put("DEC_CGE01", LigneDecCge01.getInstancePourInitialisation());
    tableLignes.put("INR_PAR09", LigneInrPar09.getInstancePourInitialisation());
    
    tableProduits.put("ASU_CGE01_02", ProduitAsuCge01P02.getInstancePourInitialisation());
    tableProduits.put("ASU_CGE01_03", ProduitAsuCge01P03.getInstancePourInitialisation());
    tableProduits.put("ASU_SPE02_01", ProduitAsuSpe02P01.getInstancePourInitialisation());
    tableProduits.put("ASU_SPE02_03", ProduitAsuSpe02P03.getInstancePourInitialisation());
    tableProduits.put("ASU_SSP07_03", ProduitAsuSsp07P03.getInstancePourInitialisation());
    tableProduits.put("ASU_FDS12_02", ProduitAsuFds12P02.getInstancePourInitialisation());
    tableProduits.put("ASU_CSA06_01", ProduitAsuCsa06P01.getInstancePourInitialisation());
    tableProduits.put("ASU_CSA06_02", ProduitAsuCsa06P02.getInstancePourInitialisation());
    tableProduits.put("ASU_CAA14_01", ProduitAsuCaa14P01.getInstancePourInitialisation());
    tableProduits.put("ASU_CVA10_01", ProduitAsuCva10P01.getInstancePourInitialisation());
    tableProduits.put("ASU_CSR04_01", ProduitAsuCSR04P01.getInstancePourInitialisation());
    tableProduits.put("ASU_CGE01_04", ProduitAsuCge01P04.getInstancePourInitialisation());
    tableProduits.put("ASU_CSA06_03", ProduitAsuCsa06P03.getInstancePourInitialisation());
    tableProduits.put("ASU_CVE13_01", ProduitAsuCve13P01.getInstancePourInitialisation());
    tableProduits.put("ASU_EUR05_01", ProduitAsuEur05P01.getInstancePourInitialisation());
    tableProduits.put("ASU_DDM16_01", ProduitAsuDdm16P01.getInstancePourInitialisation());
    tableProduits.put("ASU_EXP03_01", ProduitAsuExp03P01.getInstancePourInitialisation());
    tableProduits.put("ASU_CGE01_05", ProduitAsuCge01P05.getInstancePourInitialisation());
    tableProduits.put("ASU_CSA06_04", ProduitAsuCsa06P04.getInstancePourInitialisation());
    tableProduits.put("ASU_MAY17_02", ProduitAsuMay17P02.getInstancePourInitialisation());
    tableProduits.put("ASU_MAY17_03", ProduitAsuMay17P03.getInstancePourInitialisation());
    tableProduits.put("SOL_CGE01_01", ProduitSolCge01P01.getInstancePourInitialisation());
    tableProduits.put("SOL_CPA02_01", ProduitSolCpa02P01.getInstancePourInitialisation());
    tableProduits.put("SOL_AER05_01", ProduitSolAer05P01.getInstancePourInitialisation());
    tableProduits.put("SOL_AER05_02", ProduitSolAer05P02.getInstancePourInitialisation());
    tableProduits.put("SOL_AER05_03", ProduitSolAer05P03.getInstancePourInitialisation());
    tableProduits.put("SOL_AER05_04", ProduitSolAer05P04.getInstancePourInitialisation());
    tableProduits.put("SOL_ATA06_01", ProduitSolAta06P01.getInstancePourInitialisation());
    tableProduits.put("SOL_SUB09_01", ProduitSolSub09P01.getInstancePourInitialisation());
    tableProduits.put("RBF_HBT01_01", ProduitRbfHbt01P01.getInstancePourInitialisation());
    tableProduits.put("RBF_TPT02_01", ProduitRbfTpt02P01.getInstancePourInitialisation());
    tableProduits.put("RBF_RTN03_01", ProduitRbfRtn03P01.getInstancePourInitialisation());
    tableProduits.put("RBF_FPO04_01", ProduitRbfFpo04P01.getInstancePourInitialisation());
    tableProduits.put("RBF_FPO04_02", ProduitRbfFpo04P02.getInstancePourInitialisation());
    tableProduits.put("RBF_HBT01_02", ProduitRbfHbt01P02.getInstancePourInitialisation());
    tableProduits.put("RBF_TPT02_02", ProduitRbfTpt02P02.getInstancePourInitialisation());
    tableProduits.put("RBF_RTN03_02", ProduitRbfRtn03P02.getInstancePourInitialisation());
    tableProduits.put("RBF_MOB07_01", ProduitRbfMob07P01.getInstancePourInitialisation());
    tableProduits.put("RBF_AGE08_01", ProduitRbfAge08P01.getInstancePourInitialisation());
    tableProduits.put("RBF_AIDES_01", ProduitRbfAidesBan.getInstancePourInitialisation());
    tableProduits.put("FOR_AFF03_01", ProduitForAff03P01.getInstancePourInitialisation());
    tableProduits.put("FOR_AFF03_03", ProduitForAff03P03.getInstancePourInitialisation());
    tableProduits.put("FOR_RPS02_01", ProduitForRps02P01.getInstancePourInitialisation());
    tableProduits.put("FOR_RFP04_01", ProduitForRfp04P01.getInstancePourInitialisation());
    tableProduits.put("FOR_CSP05_01", ProduitForCsp05P01.getInstancePourInitialisation());
    tableProduits.put("INR_CES06_01", ProduitInrCes06P01.getInstancePourInitialisation());
    tableProduits.put("INR_PFM01_01", ProduitInrPfm01P01.getInstancePourInitialisation());
    tableProduits.put("INR_RCE04_01", ProduitInrRce04P01.getInstancePourInitialisation());
    tableProduits.put("INR_ADR03_02", ProduitInrAdr03P02.getInstancePourInitialisation());
    tableProduits.put("INR_PAR09_01", ProduitInrPar09P01.getInstancePourInitialisation());
    tableProduits.put("RET_ACO01_01", ProduitRetAco01P01.getInstancePourInitialisation());
    tableProduits.put("PRR_PRL02_01", ProduitPrrPrl02P01.getInstancePourInitialisation());
    tableProduits.put("PRR_PLF03_01", ProduitPrrPlf03P01.getInstancePourInitialisation());
    tableProduits.put("ASU_MNT09_01", ProduitAsuMnt09P01.getInstancePourInitialisation());
    tableProduits.put("ASU_CAA14_02", ProduitAsuCaa14P02.getInstancePourInitialisation());
    tableProduits.put("ASU_CVA10_02", ProduitAsuCva10P02.getInstancePourInitialisation());
    tableProduits.put("ASU_CAA14_03", ProduitAsuCaa14P03.getInstancePourInitialisation());
    tableProduits.put("ASU_CVA10_03", ProduitAsuCva10P03.getInstancePourInitialisation());
    tableProduits.put("DEC_CGE01_01", ProduitDecCge01P01.getInstancePourInitialisation());
    tableProduits.put("ASU_CGE01_06", ProduitAsuCge01P06.getInstancePourInitialisation());
    tableProduits.put("ASU_CGE01_07", ProduitAsuCge01P07.getInstancePourInitialisation());
    tableProduits.put("ASU_CSA06_05", ProduitAsuCsa06P05.getInstancePourInitialisation());
    tableProduits.put("ASU_CGE01_6B", ProduitAsuCge01P6B.getInstancePourInitialisation());
    tableProduits.put("ASU_CSA06_5B", ProduitAsuCsa06P5B.getInstancePourInitialisation());
    tableProduits.put("ASU_CSA06_06", ProduitAsuCsa06P06.getInstancePourInitialisation());
    tableProduits.put("ASU_SPE02_04", ProduitAsuSpe02P04.getInstancePourInitialisation());
    tableProduits.put("ASU_SSP07_04", ProduitAsuSsp07P04.getInstancePourInitialisation());
    tableProduits.put("ASU_SPE02_05", ProduitAsuSpe02P05.getInstancePourInitialisation());
    tableProduits.put("ASU_SPE02_06", ProduitAsuSpe02P06.getInstancePourInitialisation());
    tableProduits.put("ASU_SSP07_05", ProduitAsuSsp07P05.getInstancePourInitialisation());
    tableProduits.put("ASU_FDS12_03", ProduitAsuFds12P03.getInstancePourInitialisation());
    
    tableProduitsParDefaut.put("ASU_CGE01_02", ProduitAsuCge01P02.getInstancePourInitialisation());
    tableProduitsParDefaut.put("ASU_CGE01_03", ProduitAsuCge01P03.getInstancePourInitialisation());
    tableProduitsParDefaut.put("ASU_CGE01_04", ProduitAsuCge01P04.getInstancePourInitialisation());
    tableProduitsParDefaut.put("ASU_CGE01_05", ProduitAsuCge01P05.getInstancePourInitialisation());
    tableProduitsParDefaut.put("ASU_CGE01_06", ProduitAsuCge01P06.getInstancePourInitialisation());
    tableProduitsParDefaut.put("ASU_CGE01_6B", ProduitAsuCge01P6B.getInstancePourInitialisation());
    tableProduitsParDefaut.put("ASU_CGE01_07", ProduitAsuCge01P07.getInstancePourInitialisation());
    
    Iterator iter = tableProduits.keySet().iterator();
    int taille = 0;
    while (iter.hasNext())
    {
      ProduitAbstrait produit = (ProduitAbstrait)tableProduits.get(iter.next());
      if (produit.getCode() > taille) {
        taille = produit.getCode();
      }
    }
    taille++;
    listeProduits = new ProduitAbstrait[taille];
    
    Iterator iter1 = tableProduits.keySet().iterator();
    while (iter1.hasNext())
    {
      ProduitAbstrait produit = (ProduitAbstrait)tableProduits.get(iter1.next());
      listeProduits[produit.getCode()] = produit;
    }
  }
  
  public static GammeSpec getGamme(String nomUnique)
  {
    initialiserParametres();
    return (GammeSpec)tableGammes.get(nomUnique);
  }
  
  public static LigneSpec getLigne(String nomUnique)
  {
    initialiserParametres();
    return (LigneSpec)tableLignes.get(nomUnique);
  }
  
  public static ProduitSpec getProduit(String nomUnique)
  {
    initialiserParametres();
    return (ProduitSpec)tableProduits.get(nomUnique);
  }
  
  public static boolean isProduitParDefaut(String nomUnique)
  {
    initialiserParametres();
    return tableProduitsParDefaut.get(nomUnique) != null;
  }
  
  public static ProduitSpec getProduit(int code)
  {
    initialiserParametres();
    return listeProduits[code];
  }
  
  public static Reglement getReglement(String nomReglement, ProduitSpec produit)
  {
    initialiserParametres();
    return Reglement.getInstance(nomReglement, produit);
  }
  
  public static int getCodeGamme(String libelleGamme)
  {
    initialiserParametres();
    
    int resultat = 0;
    if (StringUtils.equals(libelleGamme, "ASU")) {
      resultat = 1;
    } else if (StringUtils.equals(libelleGamme, "FOR")) {
      resultat = 5;
    } else if (StringUtils.equals(libelleGamme, "INR")) {
      resultat = 6;
    } else if (StringUtils.equals(libelleGamme, "MNT")) {
      resultat = 2;
    } else if (StringUtils.equals(libelleGamme, "RBF")) {
      resultat = 4;
    } else if (StringUtils.equals(libelleGamme, "SOL")) {
      resultat = 3;
    } else if (StringUtils.equals(libelleGamme, "PRR")) {
      resultat = 9;
    } else if (StringUtils.equals(libelleGamme, "RET")) {
      resultat = 7;
    } else if (StringUtils.equals(libelleGamme, "ARI")) {
      resultat = 8;
    } else if (StringUtils.equals(libelleGamme, "DEC")) {
      resultat = 10;
    }
    return resultat;
  }
  
  public static List getGammes()
  {
    initialiserParametres();
    List liste = new ArrayList();
    Iterator i = tableGammes.keySet().iterator();
    while (i.hasNext()) {
      liste.add(tableGammes.get(i.next()));
    }
    return liste;
  }
}

/* Location:
 * Qualified Name:     Parametres
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */