package fr.unedic.cali.calcul;

import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculSpec;
import fr.unedic.cali.calcul.outilsfonctionnels.OutilGestionPoursuite;
import fr.unedic.cali.calcul.outilsfonctionnels.dom.RegleMultiProduitCouple;
import fr.unedic.cali.calcul.outilsfonctionnels.dom.RegleMultiProduitCoupleSpec;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologieStandard;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public final class FonctionnelMultiProduits
{
  public static List<?> recupererReglesMultiProduits()
  {
    List<RegleMultiProduitCouple> listeRegles = null;
    
    listeRegles = new ArrayList();
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_02", 3, "SOL_AER05_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_03", 3, "SOL_AER05_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_04", 3, "SOL_AER05_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_05", 3, "SOL_AER05_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_06", 3, "SOL_AER05_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_6B", 3, "SOL_AER05_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_07", 3, "SOL_AER05_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_SPE02_03", 3, "SOL_AER05_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_SPE02_04", 3, "SOL_AER05_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_SPE02_05", 3, "SOL_AER05_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_SPE02_06", 3, "SOL_AER05_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_01", 3, "SOL_AER05_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_02", 3, "SOL_AER05_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_03", 3, "SOL_AER05_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_04", 3, "SOL_AER05_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_05", 3, "SOL_AER05_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_5B", 3, "SOL_AER05_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CAA14_01", 3, "SOL_AER05_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CVE13_01", 3, "SOL_AER05_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CAA14_02", 3, "SOL_AER05_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CAA14_03", 3, "SOL_AER05_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CVA10_01", 3, "SOL_AER05_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CVA10_02", 3, "SOL_AER05_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CVA10_03", 3, "SOL_AER05_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_02", 3, "SOL_AER05_04", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_03", 3, "SOL_AER05_04", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_04", 3, "SOL_AER05_04", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_05", 3, "SOL_AER05_04", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_06", 3, "SOL_AER05_04", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_6B", 3, "SOL_AER05_04", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_07", 3, "SOL_AER05_04", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_SPE02_03", 3, "SOL_AER05_04", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_SPE02_04", 3, "SOL_AER05_04", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_SPE02_05", 3, "SOL_AER05_04", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_SPE02_06", 3, "SOL_AER05_04", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_01", 3, "SOL_AER05_04", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_02", 3, "SOL_AER05_04", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_03", 3, "SOL_AER05_04", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_04", 3, "SOL_AER05_04", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_05", 3, "SOL_AER05_04", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_5B", 3, "SOL_AER05_04", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CAA14_01", 3, "SOL_AER05_04", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CVE13_01", 3, "SOL_AER05_04", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CAA14_02", 3, "SOL_AER05_04", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CAA14_03", 3, "SOL_AER05_04", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CVA10_01", 3, "SOL_AER05_04", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CVA10_02", 3, "SOL_AER05_04", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CVA10_03", 3, "SOL_AER05_04", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_02", 3, "SOL_AER05_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_03", 3, "SOL_AER05_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_04", 3, "SOL_AER05_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_05", 3, "SOL_AER05_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_06", 3, "SOL_AER05_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_6B", 3, "SOL_AER05_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_07", 3, "SOL_AER05_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_SPE02_03", 3, "SOL_AER05_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_SPE02_04", 3, "SOL_AER05_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_SPE02_05", 3, "SOL_AER05_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_SPE02_06", 3, "SOL_AER05_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_01", 3, "SOL_AER05_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_02", 3, "SOL_AER05_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_03", 3, "SOL_AER05_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_04", 3, "SOL_AER05_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_05", 3, "SOL_AER05_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_5B", 3, "SOL_AER05_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CAA14_01", 3, "SOL_AER05_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CVE13_01", 3, "SOL_AER05_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CAA14_02", 3, "SOL_AER05_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CAA14_03", 3, "SOL_AER05_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CVA10_01", 3, "SOL_AER05_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CVA10_02", 3, "SOL_AER05_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CVA10_03", 3, "SOL_AER05_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_02", 3, "SOL_AER05_03", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_03", 3, "SOL_AER05_03", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_04", 3, "SOL_AER05_03", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_05", 3, "SOL_AER05_03", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_06", 3, "SOL_AER05_03", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_6B", 3, "SOL_AER05_03", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_07", 3, "SOL_AER05_03", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_SPE02_03", 3, "SOL_AER05_03", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_SPE02_04", 3, "SOL_AER05_03", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_SPE02_05", 3, "SOL_AER05_03", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_SPE02_06", 3, "SOL_AER05_03", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_01", 3, "SOL_AER05_03", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_02", 3, "SOL_AER05_03", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_03", 3, "SOL_AER05_03", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_04", 3, "SOL_AER05_03", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_05", 3, "SOL_AER05_03", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_5B", 3, "SOL_AER05_03", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CAA14_01", 3, "SOL_AER05_03", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CVE13_01", 3, "SOL_AER05_03", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CAA14_02", 3, "SOL_AER05_03", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CAA14_03", 3, "SOL_AER05_03", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CVA10_01", 3, "SOL_AER05_03", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CVA10_02", 3, "SOL_AER05_03", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CVA10_03", 3, "SOL_AER05_03", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_02", 3, "SOL_CGE01_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_03", 3, "SOL_CGE01_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_04", 3, "SOL_CGE01_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_05", 3, "SOL_CGE01_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_06", 3, "SOL_CGE01_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_6B", 3, "SOL_CGE01_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_07", 3, "SOL_CGE01_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_SPE02_03", 3, "SOL_CGE01_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_SPE02_04", 3, "SOL_CGE01_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_SPE02_05", 3, "SOL_CGE01_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_SPE02_06", 3, "SOL_CGE01_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_01", 3, "SOL_CGE01_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_02", 3, "SOL_CGE01_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_03", 3, "SOL_CGE01_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_04", 3, "SOL_CGE01_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_05", 3, "SOL_CGE01_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_5B", 3, "SOL_CGE01_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CAA14_01", 3, "SOL_CGE01_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CVE13_01", 3, "SOL_CGE01_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CAA14_02", 3, "SOL_CGE01_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CAA14_03", 3, "SOL_CGE01_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CVA10_01", 3, "SOL_CGE01_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CVA10_02", 3, "SOL_CGE01_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CVA10_03", 3, "SOL_CGE01_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_02", 3, "SOL_CPA02_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_03", 3, "SOL_CPA02_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_04", 3, "SOL_CPA02_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_05", 3, "SOL_CPA02_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_06", 3, "SOL_CPA02_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_6B", 3, "SOL_CPA02_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_07", 3, "SOL_CPA02_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_SPE02_03", 3, "SOL_CPA02_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_SPE02_04", 3, "SOL_CPA02_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_SPE02_05", 3, "SOL_CPA02_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_SPE02_06", 3, "SOL_CPA02_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_01", 3, "SOL_CPA02_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_02", 3, "SOL_CPA02_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_03", 3, "SOL_CPA02_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_04", 3, "SOL_CPA02_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_05", 3, "SOL_CPA02_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_5B", 3, "SOL_CPA02_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CAA14_01", 3, "SOL_CPA02_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CVE13_01", 3, "SOL_CPA02_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CAA14_02", 3, "SOL_CPA02_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CAA14_03", 3, "SOL_CPA02_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CVA10_01", 3, "SOL_CPA02_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CVA10_02", 3, "SOL_CPA02_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CVA10_03", 3, "SOL_CPA02_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "FOR_AFF03_01", 3, "SOL_CGE01_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "FOR_AFF03_01", 3, "SOL_CPA02_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "RBF_RTN03_01", 3, "RBF_HBT01_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "RBF_TPT02_01", 3, "RBF_HBT01_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "RBF_RTN03_01", 3, "RBF_TPT02_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_02", 3, "RBF_HBT01_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_02", 3, "RBF_RTN03_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_02", 3, "RBF_TPT02_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_03", 3, "RBF_HBT01_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_04", 3, "RBF_HBT01_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_05", 3, "RBF_HBT01_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_06", 3, "RBF_HBT01_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_6B", 3, "RBF_HBT01_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_07", 3, "RBF_HBT01_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_03", 3, "RBF_RTN03_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_04", 3, "RBF_RTN03_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_05", 3, "RBF_RTN03_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_06", 3, "RBF_RTN03_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_6B", 3, "RBF_RTN03_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_07", 3, "RBF_RTN03_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_03", 3, "RBF_TPT02_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_04", 3, "RBF_TPT02_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_05", 3, "RBF_TPT02_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_06", 3, "RBF_TPT02_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_6B", 3, "RBF_TPT02_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_07", 3, "RBF_TPT02_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_SPE02_03", 3, "RBF_HBT01_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_SPE02_03", 3, "RBF_RTN03_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_SPE02_03", 3, "RBF_TPT02_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_SPE02_04", 3, "RBF_HBT01_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_SPE02_04", 3, "RBF_RTN03_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_SPE02_04", 3, "RBF_TPT02_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_SPE02_05", 3, "RBF_HBT01_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_SPE02_06", 3, "RBF_HBT01_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_SPE02_05", 3, "RBF_RTN03_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_SPE02_06", 3, "RBF_RTN03_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_SPE02_05", 3, "RBF_TPT02_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_SPE02_06", 3, "RBF_TPT02_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_01", 3, "RBF_HBT01_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_01", 3, "RBF_RTN03_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_01", 3, "RBF_TPT02_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_02", 3, "RBF_HBT01_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_02", 3, "RBF_RTN03_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_02", 3, "RBF_TPT02_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_03", 3, "RBF_HBT01_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_03", 3, "RBF_RTN03_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_03", 3, "RBF_TPT02_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_04", 3, "RBF_HBT01_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_04", 3, "RBF_RTN03_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_04", 3, "RBF_TPT02_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_05", 3, "RBF_HBT01_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_05", 3, "RBF_RTN03_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_05", 3, "RBF_TPT02_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_5B", 3, "RBF_HBT01_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_5B", 3, "RBF_RTN03_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_5B", 3, "RBF_TPT02_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CAA14_01", 3, "RBF_HBT01_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CVE13_01", 3, "RBF_HBT01_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CAA14_02", 3, "RBF_HBT01_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CAA14_03", 3, "RBF_HBT01_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CAA14_01", 3, "RBF_RTN03_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CVE13_01", 3, "RBF_RTN03_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CAA14_02", 3, "RBF_RTN03_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CAA14_03", 3, "RBF_RTN03_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CAA14_01", 3, "RBF_TPT02_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CVE13_01", 3, "RBF_TPT02_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CAA14_02", 3, "RBF_TPT02_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CAA14_03", 3, "RBF_TPT02_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CVA10_01", 3, "RBF_HBT01_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CVA10_01", 3, "RBF_RTN03_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CVA10_01", 3, "RBF_TPT02_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CVA10_02", 3, "RBF_HBT01_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CVA10_02", 3, "RBF_RTN03_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CVA10_02", 3, "RBF_TPT02_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CVA10_03", 3, "RBF_HBT01_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CVA10_03", 3, "RBF_RTN03_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CVA10_03", 3, "RBF_TPT02_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "SOL_CGE01_01", 3, "INR_PFM01_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "SOL_CPA02_01", 3, "INR_PFM01_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "SOL_CGE01_01", 3, "INR_CES06_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "SOL_CPA02_01", 3, "INR_CES06_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "FOR_AFF03_01", 3, "INR_CES06_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "RBF_RTN03_02", 3, "RBF_HBT01_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "RBF_TPT02_02", 3, "RBF_HBT01_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "RBF_RTN03_02", 3, "RBF_TPT02_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_02", 3, "RBF_HBT01_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_02", 3, "RBF_RTN03_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_02", 3, "RBF_TPT02_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_03", 3, "RBF_HBT01_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_04", 3, "RBF_HBT01_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_05", 3, "RBF_HBT01_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_06", 3, "RBF_HBT01_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_6B", 3, "RBF_HBT01_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_07", 3, "RBF_HBT01_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_03", 3, "RBF_RTN03_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_04", 3, "RBF_RTN03_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_05", 3, "RBF_RTN03_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_06", 3, "RBF_RTN03_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_6B", 3, "RBF_RTN03_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_07", 3, "RBF_RTN03_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_03", 3, "RBF_TPT02_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_04", 3, "RBF_TPT02_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_05", 3, "RBF_TPT02_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_06", 3, "RBF_TPT02_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_6B", 3, "RBF_TPT02_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CGE01_07", 3, "RBF_TPT02_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_SPE02_03", 3, "RBF_HBT01_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_SPE02_03", 3, "RBF_RTN03_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_SPE02_03", 3, "RBF_TPT02_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_SPE02_04", 3, "RBF_HBT01_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_SPE02_04", 3, "RBF_RTN03_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_SPE02_04", 3, "RBF_TPT02_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_SPE02_05", 3, "RBF_HBT01_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_SPE02_06", 3, "RBF_HBT01_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_SPE02_05", 3, "RBF_RTN03_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_SPE02_06", 3, "RBF_RTN03_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_SPE02_05", 3, "RBF_TPT02_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_SPE02_06", 3, "RBF_TPT02_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_01", 3, "RBF_HBT01_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_01", 3, "RBF_RTN03_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_02", 3, "RBF_TPT02_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_02", 3, "RBF_HBT01_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_02", 3, "RBF_RTN03_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_03", 3, "RBF_HBT01_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_03", 3, "RBF_RTN03_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_03", 3, "RBF_TPT02_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_04", 3, "RBF_HBT01_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_04", 3, "RBF_RTN03_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_04", 3, "RBF_TPT02_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_05", 3, "RBF_HBT01_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_05", 3, "RBF_RTN03_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_05", 3, "RBF_TPT02_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_5B", 3, "RBF_HBT01_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_5B", 3, "RBF_RTN03_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CSA06_5B", 3, "RBF_TPT02_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CAA14_01", 3, "RBF_HBT01_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CVE13_01", 3, "RBF_HBT01_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CAA14_02", 3, "RBF_HBT01_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CAA14_03", 3, "RBF_HBT01_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CAA14_01", 3, "RBF_RTN03_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CVE13_01", 3, "RBF_RTN03_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CAA14_02", 3, "RBF_RTN03_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CAA14_03", 3, "RBF_RTN03_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CAA14_01", 3, "RBF_TPT02_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CVE13_01", 3, "RBF_TPT02_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CAA14_02", 3, "RBF_TPT02_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CAA14_03", 3, "RBF_TPT02_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CVA10_01", 3, "RBF_HBT01_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CVA10_01", 3, "RBF_RTN03_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CVA10_01", 3, "RBF_TPT02_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CVA10_02", 3, "RBF_HBT01_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CVA10_02", 3, "RBF_RTN03_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CVA10_02", 3, "RBF_TPT02_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CVA10_03", 3, "RBF_HBT01_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CVA10_03", 3, "RBF_RTN03_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "ASU_CVA10_03", 3, "RBF_TPT02_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "FOR_RFP04_01", 3, "ASU_CGE01_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "FOR_RFP04_01", 3, "ASU_CGE01_03", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "FOR_RFP04_01", 3, "ASU_CGE01_04", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "FOR_RFP04_01", 3, "ASU_CGE01_05", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "FOR_RFP04_01", 3, "ASU_CGE01_06", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "FOR_RFP04_01", 3, "ASU_CGE01_6B", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "FOR_RFP04_01", 3, "ASU_CGE01_07", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "FOR_RFP04_01", 3, "ASU_CSA06_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "FOR_RFP04_01", 3, "ASU_CSA06_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "FOR_RFP04_01", 3, "ASU_CSA06_03", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "FOR_RFP04_01", 3, "ASU_CSA06_04", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "FOR_RFP04_01", 3, "ASU_CSA06_05", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "FOR_RFP04_01", 3, "ASU_CSA06_5B", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "FOR_RFP04_01", 3, "ASU_CSR04_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "FOR_RFP04_01", 3, "ASU_CSR04_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "FOR_RFP04_01", 3, "SOL_CGE01_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "FOR_RFP04_01", 3, "ASU_FDS12_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "FOR_RFP04_01", 3, "ASU_FDS12_03", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "FOR_RFP04_01", 3, "ASU_SSP07_03", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "FOR_RFP04_01", 3, "ASU_SSP07_04", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "FOR_RFP04_01", 3, "ASU_SSP07_05", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "FOR_RFP04_01", 3, "SOL_CPA02_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "FOR_RFP04_01", 3, "SOL_ATA06_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "FOR_RFP04_01", 3, "SOL_SUB09_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "FOR_RFP04_01", 3, "SOL_AER05_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "FOR_AFF03_03", 3, "SOL_CGE01_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "FOR_AFF03_03", 3, "SOL_CPA02_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "FOR_AFF03_03", 3, "INR_CES06_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "FOR_AFF03_03", 3, "SOL_AER05_04", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "SOL_CGE01_01", 3, "SOL_AER05_04", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "SOL_CPA02_01", 3, "SOL_AER05_04", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "INR_ADR03_02", 3, "RBF_RTN03_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "INR_ADR03_02", 3, "RBF_TPT02_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "INR_ADR03_02", 3, "RBF_HBT01_01", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "INR_ADR03_02", 3, "RBF_RTN03_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "INR_ADR03_02", 3, "RBF_TPT02_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "INR_ADR03_02", 3, "RBF_HBT01_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "INR_ADR03_02", 3, "RBF_HBT01_02", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "INR_PFM01_01", 3, "RBF_MOB07_01_HE", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "INR_PFM01_01", 3, "RBF_MOB07_01_RE", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "INR_PFM01_01", 3, "RBF_MOB07_01_TR", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "INR_PFM01_01", 3, "RBF_MOB07_01_DE", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "RBF_MOB07_01_RE", 3, "RBF_MOB07_01_HE", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "RBF_MOB07_01_TR", 3, "RBF_MOB07_01_HE", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "RBF_MOB07_01_TR", 3, "RBF_MOB07_01_RE", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "RBF_MOB07_01_DE", 3, "RBF_MOB07_01_HE", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "RBF_MOB07_01_DE", 3, "RBF_MOB07_01_RE", 3));
    
    listeRegles.add(new RegleMultiProduitCouple(1, "RBF_MOB07_01_DE", 3, "RBF_MOB07_01_TR", 3));
    
    return listeRegles;
  }
  
  public static List<?> getAttributionsCandidates(Periode periode, Map<?, ?> calendriers)
    throws CoucheLogiqueException
  {
    List<AttributionSpec> attributionsCandidates = new ArrayList();
    
    Collection<?> attributions = calendriers.keySet();
    Iterator<?> iterator = attributions.iterator();
    while (iterator.hasNext())
    {
      AttributionSpec attribution = (AttributionSpec)iterator.next();
      CalendrierExecutionCalculSpec calendrier = (CalendrierExecutionCalculSpec)calendriers.get(attribution);
      if (calendrier.getEtatAttribution() == 1)
      {
        Damj pjeNcp = OutilGestionPoursuite.getInstance().recupererPremierJourExecutableNcp(attribution);
        if (periode.contient(pjeNcp)) {
          attributionsCandidates.add(attribution);
        }
      }
      else if (calendrier.getEtatAttribution() == 2)
      {
        attributionsCandidates.add(attribution);
      }
    }
    return attributionsCandidates;
  }
  
  public static List<?> getAttributionsOrdonnees(List<?> p_attributionsCandidates)
  {
    ArrayList<?> attributionsList = null;
    TreeMap<Integer, Chronologie> attributionsOrdonnees = new TreeMap();
    
    HashMap<String, Integer> produitsOrdonneesParPriorite = intialiseProduitsMap(p_attributionsCandidates);
    
    appliqueReglesPrioritesSurProduits(produitsOrdonneesParPriorite, recupererReglesMultiProduits());
    
    attributionsOrdonnees = priseEnCompteOrdrePrioriteSurAttributions(produitsOrdonneesParPriorite, p_attributionsCandidates);
    
    attributionsList = mapperHashMapVersArrayList(attributionsOrdonnees);
    
    return attributionsList;
  }
  
  private static void appliqueReglesPrioritesSurProduits(HashMap<String, Integer> produitsMap, List<?> reglesMultiProduits)
  {
    int sommePrioritesIntiale = calculSommePriorites(produitsMap);
    
    Iterator<?> it = reglesMultiProduits.iterator();
    while (it.hasNext())
    {
      RegleMultiProduitCoupleSpec regle = null;
      try
      {
        regle = (RegleMultiProduitCoupleSpec)it.next();
      }
      catch (ClassCastException e) {}
      continue;
      if ((produitsMap.containsKey(regle.getNomPremier())) && (produitsMap.containsKey(regle.getNomDeuxieme())) && 
      
        (regle.getTypeRegle() == 1)) {
        if ((regle.getTypePremier() == 3) && (regle.getTypeDeuxieme() == 3)) {
          appliqueReglesPrioritesProduit(regle, produitsMap);
        }
      }
    }
    if (sommePrioritesIntiale != calculSommePriorites(produitsMap)) {
      appliqueReglesPrioritesSurProduits(produitsMap, reglesMultiProduits);
    }
  }
  
  private static int calculSommePriorites(HashMap<String, Integer> produitsMap)
  {
    int result = 0;
    Iterator<Integer> it = produitsMap.values().iterator();
    while (it.hasNext()) {
      result += ((Integer)it.next()).intValue();
    }
    return result;
  }
  
  private static TreeMap<Integer, Chronologie> priseEnCompteOrdrePrioriteSurAttributions(HashMap<String, Integer> produitsMap, List<?> attributionsCandidates)
  {
    TreeMap<Integer, Chronologie> attributionsOrdonnees = new TreeMap();
    
    Iterator<?> it = produitsMap.entrySet().iterator();
    while (it.hasNext())
    {
      Map.Entry entree = (Map.Entry)it.next();
      Integer priorite = (Integer)entree.getValue();
      String nomProduit = (String)entree.getKey();
      
      Chronologie attrs = (Chronologie)attributionsOrdonnees.get(priorite);
      if (attrs == null)
      {
        attrs = new ChronologieStandard();
        attrs.setComparateur(new ComparateurTemporelAttributionPourCalcul());
        
        attributionsOrdonnees.put(priorite, attrs);
      }
      attrs.ajouter(getAttributionsParType(nomProduit, attributionsCandidates));
    }
    return attributionsOrdonnees;
  }
  
  private static void appliqueReglesPrioritesProduit(RegleMultiProduitCoupleSpec regle, HashMap<String, Integer> produitsMap)
  {
    String nomProduitPrioritaire = regle.getNomPremier();
    String nomProduitSecondaire = regle.getNomDeuxieme();
    
    int priorite = ((Integer)produitsMap.get(nomProduitPrioritaire)).intValue();
    int prioriteProduitSecondaire = ((Integer)produitsMap.get(nomProduitSecondaire)).intValue();
    if (priorite <= prioriteProduitSecondaire) {
      produitsMap.put(nomProduitPrioritaire, Integer.valueOf(prioriteProduitSecondaire + 1));
    }
  }
  
  private static HashMap<String, Integer> intialiseProduitsMap(List<?> attributionsCandidates)
  {
    HashMap<String, Integer> map = new HashMap();
    
    Iterator<?> it = attributionsCandidates.iterator();
    while (it.hasNext())
    {
      AttributionSpec attr = (AttributionSpec)it.next();
      map.put(attr.getProduit().getNom(), Integer.valueOf("0"));
    }
    return map;
  }
  
  private static Collection<AttributionSpec> getAttributionsParType(String nomProduit, List<?> attributionsCandidates)
  {
    ArrayList<AttributionSpec> attributionsType = new ArrayList();
    Iterator<?> it = attributionsCandidates.iterator();
    while (it.hasNext())
    {
      AttributionSpec attr = (AttributionSpec)it.next();
      if (nomProduit.equals(attr.getProduit().getNom())) {
        attributionsType.add(attr);
      }
    }
    return attributionsType;
  }
  
  private static ArrayList<?> mapperHashMapVersArrayList(Map<Integer, Chronologie> attributionsOrdonnees)
  {
    ArrayList<?> attrs = new ArrayList();
    
    ArrayList<Integer> listeAttribution = new ArrayList();
    Iterator<Integer> iterateur = attributionsOrdonnees.keySet().iterator();
    while (iterateur.hasNext()) {
      listeAttribution.add((Integer)iterateur.next());
    }
    for (int i = 1; i <= listeAttribution.size(); i++) {
      attrs.addAll(((Chronologie)attributionsOrdonnees.get(listeAttribution.get(listeAttribution.size() - i))).mapperVersCollection());
    }
    return attrs;
  }
}

/* Location:
 * Qualified Name:     FonctionnelMultiProduits
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */