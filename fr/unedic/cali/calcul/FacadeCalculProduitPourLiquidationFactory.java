package fr.unedic.cali.calcul;

import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.util.services.CoucheLogiqueException;
import java.util.HashMap;
import java.util.Map;

public final class FacadeCalculProduitPourLiquidationFactory
{
  private static final String FACADE_ASU_CGE01_P02 = "fr.unedic.cali.asu.cge01.p02.calcul.FacadeCalculProduitPourLiquidationImpl";
  private static final String FACADE_ASU_CGE01_P03 = "fr.unedic.cali.asu.cge01.p03.calcul.FacadeCalculProduitPourLiquidationImpl";
  private static final String FACADE_ASU_CGE01_P04 = "fr.unedic.cali.asu.cge01.p04.calcul.FacadeCalculProduitPourLiquidationImpl";
  private static final String FACADE_ASU_CGE01_P05 = "fr.unedic.cali.asu.cge01.p05.calcul.FacadeCalculProduitPourLiquidationImpl";
  private static final String FACADE_ASU_CGE01_P06 = "fr.unedic.cali.asu.cge01.p6b.calcul.FacadeCalculProduitPourLiquidationImpl";
  private static final String FACADE_ASU_CGE01_P6B = "fr.unedic.cali.asu.cge01.p6b.calcul.FacadeCalculProduitPourLiquidationImpl";
  private static final String FACADE_ASU_CGE01_P07 = "fr.unedic.cali.asu.cge01.p07.calcul.FacadeCalculProduitPourLiquidationImpl";
  private static final String FACADE_ASU_CSA06_P01 = "fr.unedic.cali.asu.csa06.p01.calcul.FacadeCalculProduitPourLiquidationImpl";
  private static final String FACADE_ASU_CSA06_P02 = "fr.unedic.cali.asu.csa06.p02.calcul.FacadeCalculProduitPourLiquidationImpl";
  private static final String FACADE_ASU_CSA06_P03 = "fr.unedic.cali.asu.csa06.p03.calcul.FacadeCalculProduitPourLiquidationImpl";
  private static final String FACADE_ASU_CSA06_P04 = "fr.unedic.cali.asu.csa06.p04.calcul.FacadeCalculProduitPourLiquidationImpl";
  private static final String FACADE_ASU_CSA06_P05 = "fr.unedic.cali.asu.csa06.p5b.calcul.FacadeCalculProduitPourLiquidationImpl";
  private static final String FACADE_ASU_CSA06_P5B = "fr.unedic.cali.asu.csa06.p5b.calcul.FacadeCalculProduitPourLiquidationImpl";
  private static final String FACADE_ASU_CSA06_P06 = "fr.unedic.cali.asu.csa06.p5b.calcul.FacadeCalculProduitPourLiquidationImpl";
  private static final String FACADE_ASU_SPE02_P01 = "fr.unedic.cali.asu.spe02.p01.calcul.FacadeCalculProduitPourLiquidationImpl";
  private static final String FACADE_ASU_CSR04_P01 = "fr.unedic.cali.asu.csr04.p01.calcul.FacadeCalculProduitPourLiquidationImpl";
  private static final String FACADE_SOL_AER05_P01 = "fr.unedic.cali.sol.aer05.p01.calcul.FacadeCalculProduitPourLiquidationImpl";
  private static final String FACADE_SOL_CGE01_P01 = "fr.unedic.cali.sol.cge01.p01.calcul.FacadeCalculProduitPourLiquidationImpl";
  private static final String FACADE_SOL_ATA06_P01 = "fr.unedic.cali.sol.ata06.p01.calcul.FacadeCalculProduitPourLiquidationImpl";
  private static final String FACADE_SOL_CPA02_P01 = "fr.unedic.cali.sol.cpa02.p01.calcul.FacadeCalculProduitPourLiquidationImpl";
  private static final String FACADE_SOL_SUB09_P01 = "fr.unedic.cali.sol.sub09.p01.calcul.FacadeCalculProduitPourLiquidationImpl";
  private static final String FACADE_FOR_RPS02_P01 = "fr.unedic.cali.form.rps02.p01.calcul.FacadeCalculProduitPourLiquidationImpl";
  private static final String FACADE_FOR_RFP04_P01 = "fr.unedic.cali.form.rfp04.p01.calcul.FacadeCalculProduitPourLiquidationImpl";
  private static final String FACADE_FOR_AFF03_P01 = "fr.unedic.cali.form.aff03.p01.calcul.FacadeCalculProduitPourLiquidationImpl";
  private static final String FACADE_FOR_AFF03_P03 = "fr.unedic.cali.form.aff03.p03.calcul.FacadeCalculProduitPourLiquidationImpl";
  private static final String FACADE_INR_CES06_P01 = "fr.unedic.cali.inr.ces06.p01.calcul.FacadeCalculProduitPourLiquidationImpl";
  private static final String FACADE_ASU_SPE02_P03 = "fr.unedic.cali.asu.spe02.p03.calcul.FacadeCalculProduitPourLiquidationImpl";
  private static final String FACADE_ASU_SPE02_P04 = "fr.unedic.cali.asu.spe02.p04.calcul.FacadeCalculProduitPourLiquidationImpl";
  private static final String FACADE_ASU_SPE02_P05 = "fr.unedic.cali.asu.spe02.p05.calcul.FacadeCalculProduitPourLiquidationImpl";
  private static final String FACADE_ASU_SPE02_P06 = "fr.unedic.cali.asu.spe02.p05.calcul.FacadeCalculProduitPourLiquidationImpl";
  private static final String FACADE_ASU_SSP07_P03 = "fr.unedic.cali.asu.ssp07.p03.calcul.FacadeCalculProduitPourLiquidationImpl";
  private static final String FACADE_ASU_SSP07_P04 = "fr.unedic.cali.asu.ssp07.p04.calcul.FacadeCalculProduitPourLiquidationImpl";
  private static final String FACADE_ASU_SSP07_P05 = "fr.unedic.cali.asu.ssp07.p05.calcul.FacadeCalculProduitPourLiquidationImpl";
  private static final String FACADE_ASU_FDS12_P01 = "fr.unedic.cali.asu.fds12.p01.calcul.FacadeCalculProduitPourLiquidationImpl";
  private static final String FACADE_ASU_FDS12_P02 = "fr.unedic.cali.asu.fds12.p02.calcul.FacadeCalculProduitPourLiquidationImpl";
  private static final String FACADE_ASU_CVA10_P01 = "fr.unedic.cali.asu.cva10.p01.calcul.FacadeCalculProduitPourLiquidationImpl";
  private static final String FACADE_ASU_CAA14_P01 = "fr.unedic.cali.asu.caa14.p01.calcul.FacadeCalculProduitPourLiquidationImpl";
  private static final String FACADE_INR_ADR03_P02 = "fr.unedic.cali.inr.adr03.p02.calcul.FacadeCalculProduitPourLiquidationImpl";
  private static final String FACADE_ASU_CVE13_P01 = "fr.unedic.cali.asu.cve13.p01.calcul.FacadeCalculProduitPourLiquidationImpl";
  private static final String FACADE_RET_ACO01_P01 = "fr.unedic.cali.ret.aco01.p01.calcul.FacadeCalculProduitPourLiquidationImpl";
  private static final String FACADE_ASU_EUR05_P01 = "fr.unedic.cali.asu.eur05.p01.calcul.FacadeCalculProduitPourLiquidationImpl";
  private static final String FACADE_ASU_DDM16_P01 = "fr.unedic.cali.asu.ddm16.p01.calcul.FacadeCalculProduitPourLiquidationImpl";
  private static final String FACADE_PRR_PRL02_P01 = "fr.unedic.cali.prr.prl02.p01.calcul.FacadeCalculProduitPourLiquidationImpl";
  private static final String FACADE_ASU_EXP03_P01 = "fr.unedic.cali.asu.exp03.p01.calcul.FacadeCalculProduitPourLiquidationImpl";
  private static final String FACADE_ASU_CVA10_P02 = "fr.unedic.cali.asu.cva10.p02.calcul.FacadeCalculProduitPourLiquidationImpl";
  private static final String FACADE_ASU_CVA10_P03 = "fr.unedic.cali.asu.cva10.p03.calcul.FacadeCalculProduitPourLiquidationImpl";
  private static final String FACADE_ASU_CAA14_P02 = "fr.unedic.cali.asu.caa14.p02.calcul.FacadeCalculProduitPourLiquidationImpl";
  private static final String FACADE_ASU_CAA14_P03 = "fr.unedic.cali.asu.caa14.p03.calcul.FacadeCalculProduitPourLiquidationImpl";
  private static final String FACADE_SOL_AER05_P02 = "fr.unedic.cali.sol.aer05.p02.calcul.FacadeCalculProduitPourLiquidationImpl";
  private static final String FACADE_DEC_CGE01_P01 = "fr.unedic.cali.dec.cge01.p01.calcul.FacadeCalculProduitPourLiquidationImpl";
  private static final String FACADE_ASU_MAY17_P02 = "fr.unedic.cali.asu.may17.p02.calcul.FacadeCalculProduitPourLiquidationImpl";
  private static final String FACADE_SOL_AER05_P03 = "fr.unedic.cali.sol.aer05.p03.calcul.FacadeCalculProduitPourLiquidationImpl";
  private static final String FACADE_RBF_MOB07_01 = "fr.unedic.cali.rbf.sta.calcul.FacadeCalculProduitPourLiquidationImpl";
  private static final String FACADE_RBF_AGE08_01 = "fr.unedic.cali.rbf.age08.p01.calcul.FacadeCalculProduitPourLiquidationImpl";
  private static final String FACADE_RBF_AIDES_P01 = "fr.unedic.cali.rbf.aides.calcul.FacadeCalculProduitPourLiquidationImpl";
  private static final String FACADE_FOR_CSP05_P01 = "fr.unedic.cali.form.csp05.p01.calcul.FacadeCalculProduitPourLiquidationImpl";
  private static final String FACADE_SOL_AER05_P04 = "fr.unedic.cali.sol.aer05.p04.calcul.FacadeCalculProduitPourLiquidationImpl";
  private static FacadeCalculProduitPourLiquidationFactory instance = null;
  private Map<String, String> classesGestionnairesProduitMap = null;
  private Map<String, FacadeCalculProduitPourLiquidationSpec> instancesGestionnairesProduitMap = null;
  
  private FacadeCalculProduitPourLiquidationFactory()
  {
    classesGestionnairesProduitMap = new HashMap();
    instancesGestionnairesProduitMap = new HashMap();
    
    classesGestionnairesProduitMap.put("ASU_CGE01_02", "fr.unedic.cali.asu.cge01.p02.calcul.FacadeCalculProduitPourLiquidationImpl");
    classesGestionnairesProduitMap.put("ASU_CGE01_03", "fr.unedic.cali.asu.cge01.p03.calcul.FacadeCalculProduitPourLiquidationImpl");
    classesGestionnairesProduitMap.put("ASU_CGE01_04", "fr.unedic.cali.asu.cge01.p04.calcul.FacadeCalculProduitPourLiquidationImpl");
    classesGestionnairesProduitMap.put("ASU_CGE01_05", "fr.unedic.cali.asu.cge01.p05.calcul.FacadeCalculProduitPourLiquidationImpl");
    classesGestionnairesProduitMap.put("ASU_CGE01_06", "fr.unedic.cali.asu.cge01.p6b.calcul.FacadeCalculProduitPourLiquidationImpl");
    classesGestionnairesProduitMap.put("ASU_CGE01_6B", "fr.unedic.cali.asu.cge01.p6b.calcul.FacadeCalculProduitPourLiquidationImpl");
    classesGestionnairesProduitMap.put("ASU_CGE01_07", "fr.unedic.cali.asu.cge01.p07.calcul.FacadeCalculProduitPourLiquidationImpl");
    classesGestionnairesProduitMap.put("ASU_CSA06_01", "fr.unedic.cali.asu.csa06.p01.calcul.FacadeCalculProduitPourLiquidationImpl");
    classesGestionnairesProduitMap.put("ASU_CSA06_02", "fr.unedic.cali.asu.csa06.p02.calcul.FacadeCalculProduitPourLiquidationImpl");
    classesGestionnairesProduitMap.put("ASU_CSA06_03", "fr.unedic.cali.asu.csa06.p03.calcul.FacadeCalculProduitPourLiquidationImpl");
    classesGestionnairesProduitMap.put("ASU_CSA06_04", "fr.unedic.cali.asu.csa06.p04.calcul.FacadeCalculProduitPourLiquidationImpl");
    classesGestionnairesProduitMap.put("ASU_CSA06_05", "fr.unedic.cali.asu.csa06.p5b.calcul.FacadeCalculProduitPourLiquidationImpl");
    classesGestionnairesProduitMap.put("ASU_CSA06_06", "fr.unedic.cali.asu.csa06.p5b.calcul.FacadeCalculProduitPourLiquidationImpl");
    classesGestionnairesProduitMap.put("ASU_CSA06_5B", "fr.unedic.cali.asu.csa06.p5b.calcul.FacadeCalculProduitPourLiquidationImpl");
    classesGestionnairesProduitMap.put("ASU_SPE02_01", "fr.unedic.cali.asu.spe02.p01.calcul.FacadeCalculProduitPourLiquidationImpl");
    classesGestionnairesProduitMap.put("ASU_CSR04_01", "fr.unedic.cali.asu.csr04.p01.calcul.FacadeCalculProduitPourLiquidationImpl");
    classesGestionnairesProduitMap.put("SOL_AER05_01", "fr.unedic.cali.sol.aer05.p01.calcul.FacadeCalculProduitPourLiquidationImpl");
    classesGestionnairesProduitMap.put("SOL_CGE01_01", "fr.unedic.cali.sol.cge01.p01.calcul.FacadeCalculProduitPourLiquidationImpl");
    classesGestionnairesProduitMap.put("SOL_ATA06_01", "fr.unedic.cali.sol.ata06.p01.calcul.FacadeCalculProduitPourLiquidationImpl");
    classesGestionnairesProduitMap.put("SOL_CPA02_01", "fr.unedic.cali.sol.cpa02.p01.calcul.FacadeCalculProduitPourLiquidationImpl");
    classesGestionnairesProduitMap.put("FOR_RPS02_01", "fr.unedic.cali.form.rps02.p01.calcul.FacadeCalculProduitPourLiquidationImpl");
    classesGestionnairesProduitMap.put("FOR_RFP04_01", "fr.unedic.cali.form.rfp04.p01.calcul.FacadeCalculProduitPourLiquidationImpl");
    classesGestionnairesProduitMap.put("INR_CES06_01", "fr.unedic.cali.inr.ces06.p01.calcul.FacadeCalculProduitPourLiquidationImpl");
    classesGestionnairesProduitMap.put("ASU_SPE02_03", "fr.unedic.cali.asu.spe02.p03.calcul.FacadeCalculProduitPourLiquidationImpl");
    classesGestionnairesProduitMap.put("ASU_SPE02_04", "fr.unedic.cali.asu.spe02.p04.calcul.FacadeCalculProduitPourLiquidationImpl");
    classesGestionnairesProduitMap.put("ASU_SPE02_05", "fr.unedic.cali.asu.spe02.p05.calcul.FacadeCalculProduitPourLiquidationImpl");
    classesGestionnairesProduitMap.put("ASU_SPE02_06", "fr.unedic.cali.asu.spe02.p05.calcul.FacadeCalculProduitPourLiquidationImpl");
    classesGestionnairesProduitMap.put("ASU_SSP07_03", "fr.unedic.cali.asu.ssp07.p03.calcul.FacadeCalculProduitPourLiquidationImpl");
    classesGestionnairesProduitMap.put("ASU_SSP07_04", "fr.unedic.cali.asu.ssp07.p04.calcul.FacadeCalculProduitPourLiquidationImpl");
    classesGestionnairesProduitMap.put("ASU_SSP07_05", "fr.unedic.cali.asu.ssp07.p05.calcul.FacadeCalculProduitPourLiquidationImpl");
    classesGestionnairesProduitMap.put("ASU_FDS12_01", "fr.unedic.cali.asu.fds12.p01.calcul.FacadeCalculProduitPourLiquidationImpl");
    classesGestionnairesProduitMap.put("ASU_FDS12_02", "fr.unedic.cali.asu.fds12.p02.calcul.FacadeCalculProduitPourLiquidationImpl");
    classesGestionnairesProduitMap.put("ASU_FDS12_03", "fr.unedic.cali.asu.fds12.p02.calcul.FacadeCalculProduitPourLiquidationImpl");
    classesGestionnairesProduitMap.put("ASU_CVA10_01", "fr.unedic.cali.asu.cva10.p01.calcul.FacadeCalculProduitPourLiquidationImpl");
    classesGestionnairesProduitMap.put("ASU_CAA14_01", "fr.unedic.cali.asu.caa14.p01.calcul.FacadeCalculProduitPourLiquidationImpl");
    classesGestionnairesProduitMap.put("INR_ADR03_02", "fr.unedic.cali.inr.adr03.p02.calcul.FacadeCalculProduitPourLiquidationImpl");
    classesGestionnairesProduitMap.put("ASU_CVE13_01", "fr.unedic.cali.asu.cve13.p01.calcul.FacadeCalculProduitPourLiquidationImpl");
    classesGestionnairesProduitMap.put("SOL_SUB09_01", "fr.unedic.cali.sol.sub09.p01.calcul.FacadeCalculProduitPourLiquidationImpl");
    classesGestionnairesProduitMap.put("RET_ACO01_01", "fr.unedic.cali.ret.aco01.p01.calcul.FacadeCalculProduitPourLiquidationImpl");
    classesGestionnairesProduitMap.put("ASU_EUR05_01", "fr.unedic.cali.asu.eur05.p01.calcul.FacadeCalculProduitPourLiquidationImpl");
    classesGestionnairesProduitMap.put("ASU_DDM16_01", "fr.unedic.cali.asu.ddm16.p01.calcul.FacadeCalculProduitPourLiquidationImpl");
    classesGestionnairesProduitMap.put("PRR_PRL02_01", "fr.unedic.cali.prr.prl02.p01.calcul.FacadeCalculProduitPourLiquidationImpl");
    classesGestionnairesProduitMap.put("ASU_EXP03_01", "fr.unedic.cali.asu.exp03.p01.calcul.FacadeCalculProduitPourLiquidationImpl");
    classesGestionnairesProduitMap.put("FOR_AFF03_01", "fr.unedic.cali.form.aff03.p01.calcul.FacadeCalculProduitPourLiquidationImpl");
    classesGestionnairesProduitMap.put("FOR_AFF03_03", "fr.unedic.cali.form.aff03.p03.calcul.FacadeCalculProduitPourLiquidationImpl");
    classesGestionnairesProduitMap.put("ASU_CVA10_02", "fr.unedic.cali.asu.cva10.p02.calcul.FacadeCalculProduitPourLiquidationImpl");
    classesGestionnairesProduitMap.put("ASU_CVA10_03", "fr.unedic.cali.asu.cva10.p03.calcul.FacadeCalculProduitPourLiquidationImpl");
    classesGestionnairesProduitMap.put("FOR_AFF03_01", "fr.unedic.cali.form.aff03.p01.calcul.FacadeCalculProduitPourLiquidationImpl");
    classesGestionnairesProduitMap.put("ASU_CAA14_02", "fr.unedic.cali.asu.caa14.p02.calcul.FacadeCalculProduitPourLiquidationImpl");
    classesGestionnairesProduitMap.put("ASU_CAA14_03", "fr.unedic.cali.asu.caa14.p03.calcul.FacadeCalculProduitPourLiquidationImpl");
    classesGestionnairesProduitMap.put("SOL_AER05_02", "fr.unedic.cali.sol.aer05.p02.calcul.FacadeCalculProduitPourLiquidationImpl");
    classesGestionnairesProduitMap.put("SOL_AER05_04", "fr.unedic.cali.sol.aer05.p04.calcul.FacadeCalculProduitPourLiquidationImpl");
    classesGestionnairesProduitMap.put("DEC_CGE01_01", "fr.unedic.cali.dec.cge01.p01.calcul.FacadeCalculProduitPourLiquidationImpl");
    classesGestionnairesProduitMap.put("ASU_MAY17_02", "fr.unedic.cali.asu.may17.p02.calcul.FacadeCalculProduitPourLiquidationImpl");
    classesGestionnairesProduitMap.put("ASU_MAY17_03", "fr.unedic.cali.asu.may17.p02.calcul.FacadeCalculProduitPourLiquidationImpl");
    classesGestionnairesProduitMap.put("SOL_AER05_03", "fr.unedic.cali.sol.aer05.p03.calcul.FacadeCalculProduitPourLiquidationImpl");
    classesGestionnairesProduitMap.put("RBF_MOB07_01", "fr.unedic.cali.rbf.sta.calcul.FacadeCalculProduitPourLiquidationImpl");
    classesGestionnairesProduitMap.put("RBF_AGE08_01", "fr.unedic.cali.rbf.age08.p01.calcul.FacadeCalculProduitPourLiquidationImpl");
    classesGestionnairesProduitMap.put("RBF_MOB07_01_DE", "fr.unedic.cali.rbf.aides.calcul.FacadeCalculProduitPourLiquidationImpl");
    classesGestionnairesProduitMap.put("RBF_MOB07_01_HE", "fr.unedic.cali.rbf.aides.calcul.FacadeCalculProduitPourLiquidationImpl");
    classesGestionnairesProduitMap.put("RBF_MOB07_01_TR", "fr.unedic.cali.rbf.aides.calcul.FacadeCalculProduitPourLiquidationImpl");
    classesGestionnairesProduitMap.put("RBF_MOB07_01_RE", "fr.unedic.cali.rbf.aides.calcul.FacadeCalculProduitPourLiquidationImpl");
    classesGestionnairesProduitMap.put("FOR_CSP05_01", "fr.unedic.cali.form.csp05.p01.calcul.FacadeCalculProduitPourLiquidationImpl");
  }
  
  private static synchronized void creationInstance()
  {
    if (instance == null) {
      instance = new FacadeCalculProduitPourLiquidationFactory();
    }
  }
  
  public static FacadeCalculProduitPourLiquidationFactory getInstance()
  {
    if (instance == null) {
      creationInstance();
    }
    return instance;
  }
  
  public FacadeCalculProduitPourLiquidationSpec getInstanceGestionnaireCalculProduit(ProduitSpec produit)
    throws CoucheLogiqueException
  {
    return getInstanceGestionnaireCalculProduit(produit.getNom());
  }
  
  public FacadeCalculProduitPourLiquidationSpec getInstanceGestionnaireCalculProduit(String nomProduit)
    throws CoucheLogiqueException
  {
    FacadeCalculProduitPourLiquidationSpec instanceGestionnaire = null;
    if (nomProduit == null) {
      throw new CoucheLogiqueException("HG_PR_CALI_L_FACADE_LIQUIDATION_PRODUIT_NUL", "Impossible de créer la façade Calcul pour Liquidation du produit", null);
    }
    if (instancesGestionnairesProduitMap.containsKey(nomProduit)) {
      instanceGestionnaire = (FacadeCalculProduitPourLiquidationSpec)instancesGestionnairesProduitMap.get(nomProduit);
    } else {
      instanceGestionnaire = creationInstanceGestionnaireCalculProduit(nomProduit);
    }
    return instanceGestionnaire;
  }
  
  private synchronized FacadeCalculProduitPourLiquidationSpec creationInstanceGestionnaireCalculProduit(String nomProduit)
    throws CoucheLogiqueException
  {
    String nomClasseGestionnaire = null;
    Class<?> classeGestionnaire = null;
    FacadeCalculProduitPourLiquidationSpec instanceGestionnaire = null;
    String creationInstance = "creationInstanceGestionnaireCalculProduit";
    if (instancesGestionnairesProduitMap.containsKey(nomProduit))
    {
      instanceGestionnaire = (FacadeCalculProduitPourLiquidationSpec)instancesGestionnairesProduitMap.get(nomProduit);
    }
    else
    {
      nomClasseGestionnaire = (String)classesGestionnairesProduitMap.get(nomProduit);
      if ((nomClasseGestionnaire == null) || ("".equals(nomClasseGestionnaire))) {
        throw new CoucheLogiqueException("HG_PR_CALI_L_FACADE_POUR_LIQ_INTROUVABLE", "Classe de la facade produit pour Liquidation introuvable", null);
      }
      try
      {
        classeGestionnaire = Class.forName(nomClasseGestionnaire);
        instanceGestionnaire = (FacadeCalculProduitPourLiquidationSpec)classeGestionnaire.newInstance();
      }
      catch (ClassNotFoundException e)
      {
        if (Log.isTraceActive(FacadeCalculProduitPourLiquidationFactory.class, Niveau.WARN)) {
          Log.ecritTrace(Niveau.WARN, FacadeCalculProduitPourLiquidationFactory.class, creationInstance, e.getMessage());
        }
        throw new CoucheLogiqueException("HG_PR_CALI_L_ERR_GENERIQUE_CLASSE_NON_TROUVE", "Classe non trouvee:" + e.getMessage(), e);
      }
      catch (IllegalAccessException iae)
      {
        if (Log.isTraceActive(FacadeCalculProduitPourLiquidationFactory.class, Niveau.WARN)) {
          Log.ecritTrace(Niveau.WARN, FacadeCalculProduitPourLiquidationFactory.class, creationInstance, iae.getMessage());
        }
        throw new CoucheLogiqueException("HG_PR_CALI_L_PROBLEME_D_INSTANCIATION", "Impossible d'instancier un objet", iae);
      }
      catch (InstantiationException ie)
      {
        if (Log.isTraceActive(FacadeCalculProduitPourLiquidationFactory.class, Niveau.WARN)) {
          Log.ecritTrace(Niveau.WARN, FacadeCalculProduitPourLiquidationFactory.class, creationInstance, ie.getMessage());
        }
        throw new CoucheLogiqueException("HG_PR_CALI_L_PROBLEME_D_INSTANCIATION", "Impossible d'instancier un objet", ie);
      }
      instancesGestionnairesProduitMap.put(nomProduit, instanceGestionnaire);
    }
    return instanceGestionnaire;
  }
}

/* Location:
 * Qualified Name:     FacadeCalculProduitPourLiquidationFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */