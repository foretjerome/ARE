package fr.unedic.cali.calcul.aides;

import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.util.services.CoucheLogiqueException;
import java.util.HashMap;
import java.util.Map;

public class FacadeAidesProduitFactory
{
  private static final String FACADE_RBF_AGE08 = "fr.unedic.cali.rbf.age08.p01.calcul.aide.FacadeAideProduitImpl";
  private static final String FACADE_RBF_AIDES_P01 = "fr.unedic.cali.rbf.aides.calcul.aide.FacadeAideProduitImpl";
  private static final String FACADE_RBF_MOB07_P01_HBT = "fr.unedic.cali.rbf.mob07.p01.calcul.aide.FacadeAIDEHbtImpl";
  private static final String FACADE_RBF_MOB07_P01_NSN = "fr.unedic.cali.rbf.mob07.p01.calcul.aide.FacadeAIDENsnImpl";
  private static final String FACADE_RBF_MOB07_P01_RTN = "fr.unedic.cali.rbf.mob07.p01.calcul.aide.FacadeAIDERtnImpl";
  private static final String FACADE_RBF_MOB07_P01_TPT = "fr.unedic.cali.rbf.mob07.p01.calcul.aide.FacadeAIDETptImpl";
  private static final String FACADE_RBF_MOB07_P01 = "fr.unedic.cali.rbf.sta.calcul.aide.FacadeAIDEProduitImpl";
  private static FacadeAidesProduitFactory s_instance = null;
  private Map m_classesGestionnairesProduitMap = null;
  private Map m_instancesGestionnairesProduitMap = null;
  
  private FacadeAidesProduitFactory()
  {
    m_classesGestionnairesProduitMap = new HashMap();
    m_instancesGestionnairesProduitMap = new HashMap();
    
    m_classesGestionnairesProduitMap.put("RBF_AIDES_01", "fr.unedic.cali.rbf.aides.calcul.aide.FacadeAideProduitImpl");
    m_classesGestionnairesProduitMap.put("RBF_AGE08_01", "fr.unedic.cali.rbf.age08.p01.calcul.aide.FacadeAideProduitImpl");
    m_classesGestionnairesProduitMap.put("RBF_MOB07_01_HE", "fr.unedic.cali.rbf.mob07.p01.calcul.aide.FacadeAIDEHbtImpl");
    m_classesGestionnairesProduitMap.put("RBF_MOB07_01_DE", "fr.unedic.cali.rbf.mob07.p01.calcul.aide.FacadeAIDENsnImpl");
    m_classesGestionnairesProduitMap.put("RBF_MOB07_01_RE", "fr.unedic.cali.rbf.mob07.p01.calcul.aide.FacadeAIDERtnImpl");
    m_classesGestionnairesProduitMap.put("RBF_MOB07_01_TR", "fr.unedic.cali.rbf.mob07.p01.calcul.aide.FacadeAIDETptImpl");
    m_classesGestionnairesProduitMap.put("RBF_MOB07_01", "fr.unedic.cali.rbf.sta.calcul.aide.FacadeAIDEProduitImpl");
  }
  
  private static synchronized void creationInstance()
  {
    if (s_instance == null) {
      s_instance = new FacadeAidesProduitFactory();
    }
  }
  
  public static FacadeAidesProduitFactory getInstance()
  {
    if (s_instance == null) {
      creationInstance();
    }
    return s_instance;
  }
  
  public FacadeAidesProduitSpec getInstanceGestionnaireAidesProduit(ProduitSpec p_produit)
    throws CoucheLogiqueException
  {
    return getInstanceGestionnaireAidesProduit(p_produit.getNom());
  }
  
  public FacadeAidesProduitSpec getInstanceGestionnaireAidesProduit(String p_nomProduit)
    throws CoucheLogiqueException
  {
    FacadeAidesProduitSpec instanceGestionnaire = null;
    if (p_nomProduit == null) {
      throw new CoucheLogiqueException("HG_PR_CALI_L_FACADE_AIDE_PRODUIT_NUL", "Impossible de créer la façade Calcul pour AIDE du produit", null);
    }
    if (m_instancesGestionnairesProduitMap.containsKey(p_nomProduit)) {
      instanceGestionnaire = (FacadeAidesProduitSpec)m_instancesGestionnairesProduitMap.get(p_nomProduit);
    } else {
      instanceGestionnaire = creationInstanceGestionnaireAideProduit(p_nomProduit);
    }
    return instanceGestionnaire;
  }
  
  private synchronized FacadeAidesProduitSpec creationInstanceGestionnaireAideProduit(String p_nomProduit)
    throws CoucheLogiqueException
  {
    String nomClasseGestionnaire = null;
    Class classeGestionnaire = null;
    FacadeAidesProduitSpec instanceGestionnaire = null;
    if (m_instancesGestionnairesProduitMap.containsKey(p_nomProduit))
    {
      instanceGestionnaire = (FacadeAidesProduitSpec)m_instancesGestionnairesProduitMap.get(p_nomProduit);
    }
    else
    {
      nomClasseGestionnaire = (String)m_classesGestionnairesProduitMap.get(p_nomProduit);
      if ((nomClasseGestionnaire == null) || ("".equals(nomClasseGestionnaire)))
      {
        if (Log.isTraceActive(FacadeAidesProduitFactory.class, Niveau.DEBUG)) {
          Log.ecritTrace(Niveau.DEBUG, FacadeAidesProduitFactory.class, "creationInstanceGestionnairePBJCProduit", "Classe de la facade produit pour AIDE introuvable");
        }
        throw new CoucheLogiqueException("HG_PR_CALI_L_FACADE_POUR_AIDE_INTROUVABLE", "Classe de la facade produit pour AIDE introuvable", null);
      }
      try
      {
        classeGestionnaire = Class.forName(nomClasseGestionnaire);
        instanceGestionnaire = (FacadeAidesProduitSpec)classeGestionnaire.newInstance();
      }
      catch (ClassNotFoundException e)
      {
        if (Log.isTraceActive(FacadeAidesProduitFactory.class, Niveau.WARN)) {
          Log.ecritTrace(Niveau.WARN, FacadeAidesProduitFactory.class, "creationInstanceGestionnaireAIDEProduit", e.getMessage());
        }
        throw new CoucheLogiqueException("HG_PR_CALI_L_ERR_GENERIQUE_CLASSE_NON_TROUVE", "Classe non trouvee:" + e.getMessage(), e);
      }
      catch (IllegalAccessException iae)
      {
        if (Log.isTraceActive(FacadeAidesProduitFactory.class, Niveau.WARN)) {
          Log.ecritTrace(Niveau.WARN, FacadeAidesProduitFactory.class, "creationInstanceGestionnaireAIDEProduit", iae.getMessage());
        }
        throw new CoucheLogiqueException("HG_PR_CALI_L_PROBLEME_D_INSTANCIATION", "Impossible d'instancier un objet", iae);
      }
      catch (InstantiationException ie)
      {
        if (Log.isTraceActive(FacadeAidesProduitFactory.class, Niveau.WARN)) {
          Log.ecritTrace(Niveau.WARN, FacadeAidesProduitFactory.class, "creationInstanceGestionnaireAIDEProduit", ie.getMessage());
        }
        throw new CoucheLogiqueException("HG_PR_CALI_L_PROBLEME_D_INSTANCIATION", "Impossible d'instancier un objet", ie);
      }
      m_instancesGestionnairesProduitMap.put(p_nomProduit, instanceGestionnaire);
    }
    return instanceGestionnaire;
  }
}

/* Location:
 * Qualified Name:     FacadeAidesProduitFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */