package fr.unedic.cali.avant;

import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.util.services.CoucheLogiqueException;
import java.util.HashMap;
import java.util.Map;

public final class FacadeAvantProduitFactory
{
  private static final String FACADE_ASU_CGE01_P02 = "fr.unedic.cali.asu.cge01.p02.avant.FacadeAvantProduitImpl";
  private static final String FACADE_ASU_CGE01_P03 = "fr.unedic.cali.asu.cge01.p03.avant.FacadeAvantProduitImpl";
  private static final String FACADE_ASU_CGE01_P04 = "fr.unedic.cali.asu.cge01.p04.avant.FacadeAvantProduitImpl";
  private static final String FACADE_ASU_CGE01_P05 = "fr.unedic.cali.asu.cge01.p05.avant.FacadeAvantProduitImpl";
  private static final String FACADE_ASU_CGE01_P06 = "fr.unedic.cali.asu.cge01.p6b.avant.FacadeAvantProduitImpl";
  private static final String FACADE_ASU_CGE01_P6B = "fr.unedic.cali.asu.cge01.p6b.avant.FacadeAvantProduitImpl";
  private static final String FACADE_ASU_CGE01_P07 = "fr.unedic.cali.asu.cge01.p07.avant.FacadeAvantProduitImpl";
  private static final String FACADE_ASU_CSA06_P01 = "fr.unedic.cali.asu.cge01.p02.avant.FacadeAvantProduitImpl";
  private static final String FACADE_ASU_CSA06_P02 = "fr.unedic.cali.asu.csa06.p02.avant.FacadeAvantProduitImpl";
  private static final String FACADE_ASU_CSA06_P03 = "fr.unedic.cali.asu.csa06.p03.avant.FacadeAvantProduitImpl";
  private static final String FACADE_ASU_CSA06_P04 = "fr.unedic.cali.asu.csa06.p04.avant.FacadeAvantProduitImpl";
  private static final String FACADE_ASU_CSA06_P05 = "fr.unedic.cali.asu.csa06.p5b.avant.FacadeAvantProduitImpl";
  private static final String FACADE_ASU_CSA06_P5B = "fr.unedic.cali.asu.csa06.p5b.avant.FacadeAvantProduitImpl";
  private static final String FACADE_ASU_CSA06_P06 = "fr.unedic.cali.asu.csa06.p5b.avant.FacadeAvantProduitImpl";
  private static final String FACADE_ASU_SPE02_P01 = "fr.unedic.cali.asu.spe02.p01.avant.FacadeAvantProduitImpl";
  private static final String FACADE_ASU_SPE02_P03 = "fr.unedic.cali.asu.spe02.p03.avant.FacadeAvantProduitImpl";
  private static final String FACADE_ASU_SPE02_P04 = "fr.unedic.cali.asu.spe02.p04.avant.FacadeAvantProduitImpl";
  private static final String FACADE_ASU_SPE02_P05 = "fr.unedic.cali.asu.spe02.p05.avant.FacadeAvantProduitImpl";
  private static final String FACADE_ASU_FDS12_P03 = "fr.unedic.cali.asu.fds12.p03.avant.FacadeAvantProduitImpl";
  private static final String FACADE_SOL_CGE01_P01 = "fr.unedic.cali.sol.cge01.p01.avant.FacadeAvantProduitImpl";
  private static final String FACADE_ASU_SSP07_P03 = "fr.unedic.cali.asu.ssp07.p03.avant.FacadeAvantProduitImpl";
  private static final String FACADE_ASU_SSP07_P04 = "fr.unedic.cali.asu.ssp07.p04.avant.FacadeAvantProduitImpl";
  private static final String FACADE_ASU_SSP07_P05 = "fr.unedic.cali.asu.ssp07.p05.avant.FacadeAvantProduitImpl";
  private static final String FACADE_ASU_CSR04_P01 = "fr.unedic.cali.asu.csr04.p01.avant.FacadeAvantProduitImpl";
  private static final String FACADE_PRR_PRL02_P01 = "fr.unedic.cali.prr.prl02.p01.avant.FacadeAvantProduitImpl";
  private static final String FACADE_ASU_EXP03_P01 = "fr.unedic.cali.asu.exp03.p01.avant.FacadeAvantProduitImpl";
  private static final String FACADE_ASU_MAY17_P02 = "fr.unedic.cali.asu.may17.p02.avant.FacadeAvantProduitImpl";
  private static final String FACADE_ASU_CAA14_P02 = "fr.unedic.cali.asu.caa14.p02.avant.FacadeAvantProduitImpl";
  private static final String FACADE_ASU_CAA14_P03 = "fr.unedic.cali.asu.caa14.p03.avant.FacadeAvantProduitImpl";
  private static final String FACADE_ASU_CVA10_P03 = "fr.unedic.cali.asu.cva10.p03.avant.FacadeAvantProduitImpl";
  private static FacadeAvantProduitFactory instance = null;
  private Map<String, String> classesGestionnairesProduitMap = null;
  private Map<String, FacadeAvantProduitSpec> instancesGestionnairesProduitMap = null;
  
  private FacadeAvantProduitFactory()
  {
    classesGestionnairesProduitMap = new HashMap();
    instancesGestionnairesProduitMap = new HashMap();
    
    classesGestionnairesProduitMap.put("ASU_CGE01_02", "fr.unedic.cali.asu.cge01.p02.avant.FacadeAvantProduitImpl");
    classesGestionnairesProduitMap.put("ASU_CGE01_03", "fr.unedic.cali.asu.cge01.p03.avant.FacadeAvantProduitImpl");
    classesGestionnairesProduitMap.put("ASU_CGE01_04", "fr.unedic.cali.asu.cge01.p04.avant.FacadeAvantProduitImpl");
    classesGestionnairesProduitMap.put("ASU_CGE01_05", "fr.unedic.cali.asu.cge01.p05.avant.FacadeAvantProduitImpl");
    classesGestionnairesProduitMap.put("ASU_CGE01_06", "fr.unedic.cali.asu.cge01.p6b.avant.FacadeAvantProduitImpl");
    classesGestionnairesProduitMap.put("ASU_CGE01_6B", "fr.unedic.cali.asu.cge01.p6b.avant.FacadeAvantProduitImpl");
    classesGestionnairesProduitMap.put("ASU_CGE01_07", "fr.unedic.cali.asu.cge01.p07.avant.FacadeAvantProduitImpl");
    classesGestionnairesProduitMap.put("ASU_CSA06_01", "fr.unedic.cali.asu.cge01.p02.avant.FacadeAvantProduitImpl");
    classesGestionnairesProduitMap.put("ASU_CSA06_02", "fr.unedic.cali.asu.csa06.p02.avant.FacadeAvantProduitImpl");
    classesGestionnairesProduitMap.put("ASU_CSA06_03", "fr.unedic.cali.asu.csa06.p03.avant.FacadeAvantProduitImpl");
    classesGestionnairesProduitMap.put("ASU_CSA06_04", "fr.unedic.cali.asu.csa06.p04.avant.FacadeAvantProduitImpl");
    classesGestionnairesProduitMap.put("ASU_CSA06_05", "fr.unedic.cali.asu.csa06.p5b.avant.FacadeAvantProduitImpl");
    classesGestionnairesProduitMap.put("ASU_CSA06_5B", "fr.unedic.cali.asu.csa06.p5b.avant.FacadeAvantProduitImpl");
    classesGestionnairesProduitMap.put("ASU_CSA06_06", "fr.unedic.cali.asu.csa06.p5b.avant.FacadeAvantProduitImpl");
    classesGestionnairesProduitMap.put("ASU_SPE02_01", "fr.unedic.cali.asu.spe02.p01.avant.FacadeAvantProduitImpl");
    classesGestionnairesProduitMap.put("ASU_SPE02_03", "fr.unedic.cali.asu.spe02.p03.avant.FacadeAvantProduitImpl");
    classesGestionnairesProduitMap.put("ASU_SPE02_04", "fr.unedic.cali.asu.spe02.p04.avant.FacadeAvantProduitImpl");
    classesGestionnairesProduitMap.put("ASU_SPE02_05", "fr.unedic.cali.asu.spe02.p05.avant.FacadeAvantProduitImpl");
    classesGestionnairesProduitMap.put("ASU_SPE02_06", "fr.unedic.cali.asu.spe02.p05.avant.FacadeAvantProduitImpl");
    classesGestionnairesProduitMap.put("SOL_CGE01_01", "fr.unedic.cali.sol.cge01.p01.avant.FacadeAvantProduitImpl");
    classesGestionnairesProduitMap.put("ASU_SSP07_03", "fr.unedic.cali.asu.ssp07.p03.avant.FacadeAvantProduitImpl");
    classesGestionnairesProduitMap.put("ASU_SSP07_04", "fr.unedic.cali.asu.ssp07.p04.avant.FacadeAvantProduitImpl");
    classesGestionnairesProduitMap.put("ASU_SSP07_05", "fr.unedic.cali.asu.ssp07.p05.avant.FacadeAvantProduitImpl");
    classesGestionnairesProduitMap.put("ASU_FDS12_03", "fr.unedic.cali.asu.fds12.p03.avant.FacadeAvantProduitImpl");
    classesGestionnairesProduitMap.put("ASU_CSR04_01", "fr.unedic.cali.asu.csr04.p01.avant.FacadeAvantProduitImpl");
    classesGestionnairesProduitMap.put("PRR_PRL02_01", "fr.unedic.cali.prr.prl02.p01.avant.FacadeAvantProduitImpl");
    classesGestionnairesProduitMap.put("ASU_EXP03_01", "fr.unedic.cali.asu.exp03.p01.avant.FacadeAvantProduitImpl");
    classesGestionnairesProduitMap.put("ASU_MAY17_02", "fr.unedic.cali.asu.may17.p02.avant.FacadeAvantProduitImpl");
    classesGestionnairesProduitMap.put("ASU_MAY17_03", "fr.unedic.cali.asu.may17.p02.avant.FacadeAvantProduitImpl");
    classesGestionnairesProduitMap.put("ASU_CAA14_02", "fr.unedic.cali.asu.caa14.p02.avant.FacadeAvantProduitImpl");
    classesGestionnairesProduitMap.put("ASU_CAA14_03", "fr.unedic.cali.asu.caa14.p03.avant.FacadeAvantProduitImpl");
    classesGestionnairesProduitMap.put("ASU_CVA10_03", "fr.unedic.cali.asu.cva10.p03.avant.FacadeAvantProduitImpl");
  }
  
  private static synchronized void creationInstance()
  {
    if (instance == null) {
      instance = new FacadeAvantProduitFactory();
    }
  }
  
  public static FacadeAvantProduitFactory getInstance()
  {
    if (instance == null) {
      creationInstance();
    }
    return instance;
  }
  
  public FacadeAvantProduitSpec getInstanceFacadeAvantProduit(ProduitSpec produit)
    throws CoucheLogiqueException
  {
    return getInstanceFacadeAvantProduit(produit.getNom());
  }
  
  public FacadeAvantProduitSpec getInstanceFacadeAvantProduit(String nomProduit)
    throws CoucheLogiqueException
  {
    FacadeAvantProduitSpec instanceGestionnaire = null;
    if (nomProduit == null) {
      throw new CoucheLogiqueException("HG_PR_CALI_L_FACADE_AVANT_PRODUIT_NUL", "Impossible de créer la façade avant Calcul du produit", null);
    }
    if (instancesGestionnairesProduitMap.containsKey(nomProduit)) {
      instanceGestionnaire = (FacadeAvantProduitSpec)instancesGestionnairesProduitMap.get(nomProduit);
    } else {
      instanceGestionnaire = creationInstanceFacadeAvantProduit(nomProduit);
    }
    return instanceGestionnaire;
  }
  
  private synchronized FacadeAvantProduitSpec creationInstanceFacadeAvantProduit(String nomProduit)
    throws CoucheLogiqueException
  {
    String nomClasseGestionnaire = null;
    Class<?> classeGestionnaire = null;
    FacadeAvantProduitSpec instanceGestionnaire = null;
    String creationInstance = "creationInstanceFacadeAvantProduit";
    if (instancesGestionnairesProduitMap.containsKey(nomProduit))
    {
      instanceGestionnaire = (FacadeAvantProduitSpec)instancesGestionnairesProduitMap.get(nomProduit);
    }
    else
    {
      nomClasseGestionnaire = (String)classesGestionnairesProduitMap.get(nomProduit);
      if ((nomClasseGestionnaire == null) || ("".equals(nomClasseGestionnaire))) {
        throw new CoucheLogiqueException("HG_PR_CALI_L_FACADE_AVANT_GESTIONNAIRE_INTROUVABLE", "Pas de gestionnaire pour l'avant du produit", null);
      }
      try
      {
        classeGestionnaire = Class.forName(nomClasseGestionnaire);
        instanceGestionnaire = (FacadeAvantProduitSpec)classeGestionnaire.newInstance();
      }
      catch (ClassNotFoundException e)
      {
        if (Log.isTraceActive(FacadeAvantProduitFactory.class, Niveau.WARN)) {
          Log.ecritTrace(Niveau.WARN, FacadeAvantProduitFactory.class, creationInstance, e.getMessage());
        }
        throw new CoucheLogiqueException("HG_PR_CALI_L_ERR_GENERIQUE_CLASSE_NON_TROUVE", "Classe non trouvee:" + e.getMessage(), e);
      }
      catch (IllegalAccessException iae)
      {
        if (Log.isTraceActive(FacadeAvantProduitFactory.class, Niveau.WARN)) {
          Log.ecritTrace(Niveau.WARN, FacadeAvantProduitFactory.class, creationInstance, iae.getMessage());
        }
        throw new CoucheLogiqueException("HG_PR_CALI_L_PROBLEME_D_INSTANCIATION", "Impossible d'instancier un objet", iae);
      }
      catch (InstantiationException ie)
      {
        if (Log.isTraceActive(FacadeAvantProduitFactory.class, Niveau.WARN)) {
          Log.ecritTrace(Niveau.WARN, FacadeAvantProduitFactory.class, creationInstance, ie.getMessage());
        }
        throw new CoucheLogiqueException("HG_PR_CALI_L_PROBLEME_D_INSTANCIATION", "Impossible d'instancier un objet", ie);
      }
      instancesGestionnairesProduitMap.put(nomProduit, instanceGestionnaire);
    }
    return instanceGestionnaire;
  }
}

/* Location:
 * Qualified Name:     FacadeAvantProduitFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */