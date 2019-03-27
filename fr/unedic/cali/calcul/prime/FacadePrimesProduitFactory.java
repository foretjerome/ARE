package fr.unedic.cali.calcul.prime;

import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.util.services.CoucheLogiqueException;
import java.util.HashMap;
import java.util.Map;

public class FacadePrimesProduitFactory
{
  private static final String FACADE_INR_PFM01_P01 = "fr.unedic.cali.inr.pfm01.p01.calcul.prime.FacadePrimeProduitImpl";
  private static final String FACADE_INR_RCE04_P01 = "fr.unedic.cali.inr.rce04.p01.calcul.prime.FacadePrimeProduitImpl";
  private static final String FACADE_DEC_CGE01_P01 = "fr.unedic.cali.dec.cge01.p01.calcul.prime.FacadePrimeProduitImpl";
  private static final String FACADE_FOR_CSP05_P01 = "fr.unedic.cali.form.csp05.p01.calcul.prime.FacadePrimeProduitImpl";
  private static final String FACADE_INR_PAR09_P01 = "fr.unedic.cali.inr.par09.p01.calcul.prime.FacadePrimeProduitImpl";
  private static final String FACADE_SOL_AER05_P04 = "fr.unedic.cali.sol.aer05.p04.calcul.prime.FacadePrimeProduitImpl";
  private static FacadePrimesProduitFactory s_instance = null;
  private Map m_classesGestionnairesProduitMap = null;
  private Map m_instancesGestionnairesProduitMap = null;
  
  private FacadePrimesProduitFactory()
  {
    m_classesGestionnairesProduitMap = new HashMap();
    m_instancesGestionnairesProduitMap = new HashMap();
    
    m_classesGestionnairesProduitMap.put("INR_PFM01_01", "fr.unedic.cali.inr.pfm01.p01.calcul.prime.FacadePrimeProduitImpl");
    m_classesGestionnairesProduitMap.put("INR_RCE04_01", "fr.unedic.cali.inr.rce04.p01.calcul.prime.FacadePrimeProduitImpl");
    m_classesGestionnairesProduitMap.put("INR_PAR09_01", "fr.unedic.cali.inr.par09.p01.calcul.prime.FacadePrimeProduitImpl");
    m_classesGestionnairesProduitMap.put("DEC_CGE01_01", "fr.unedic.cali.dec.cge01.p01.calcul.prime.FacadePrimeProduitImpl");
    m_classesGestionnairesProduitMap.put("SOL_AER05_04", "fr.unedic.cali.sol.aer05.p04.calcul.prime.FacadePrimeProduitImpl");
    m_classesGestionnairesProduitMap.put("FOR_CSP05_01", "fr.unedic.cali.form.csp05.p01.calcul.prime.FacadePrimeProduitImpl");
  }
  
  private static synchronized void creationInstance()
  {
    if (s_instance == null) {
      s_instance = new FacadePrimesProduitFactory();
    }
  }
  
  public static FacadePrimesProduitFactory getInstance()
  {
    if (s_instance == null) {
      creationInstance();
    }
    return s_instance;
  }
  
  public FacadePrimeProduitSpec getInstanceGestionnairePBJCProduit(ProduitSpec p_produit)
    throws CoucheLogiqueException
  {
    return getInstanceGestionnairePBJCProduit(p_produit.getNom());
  }
  
  public FacadePrimeProduitSpec getInstanceGestionnairePBJCProduit(String p_nomProduit)
    throws CoucheLogiqueException
  {
    FacadePrimeProduitSpec instanceGestionnaire = null;
    if (p_nomProduit == null) {
      throw new CoucheLogiqueException("HG_PR_CALI_L_FACADE_PBJC_PRODUIT_NUL", "Impossible de créer la façade Calcul pour PBJC du produit", null);
    }
    if (m_instancesGestionnairesProduitMap.containsKey(p_nomProduit)) {
      instanceGestionnaire = (FacadePrimeProduitSpec)m_instancesGestionnairesProduitMap.get(p_nomProduit);
    } else {
      instanceGestionnaire = creationInstanceGestionnairePBJCProduit(p_nomProduit);
    }
    return instanceGestionnaire;
  }
  
  private synchronized FacadePrimeProduitSpec creationInstanceGestionnairePBJCProduit(String p_nomProduit)
    throws CoucheLogiqueException
  {
    String nomClasseGestionnaire = null;
    Class classeGestionnaire = null;
    FacadePrimeProduitSpec instanceGestionnaire = null;
    if (m_instancesGestionnairesProduitMap.containsKey(p_nomProduit))
    {
      instanceGestionnaire = (FacadePrimeProduitSpec)m_instancesGestionnairesProduitMap.get(p_nomProduit);
    }
    else
    {
      nomClasseGestionnaire = (String)m_classesGestionnairesProduitMap.get(p_nomProduit);
      if ((nomClasseGestionnaire == null) || ("".equals(nomClasseGestionnaire)))
      {
        if (Log.isTraceActive(FacadePrimesProduitFactory.class, Niveau.DEBUG)) {
          Log.ecritTrace(Niveau.DEBUG, FacadePrimesProduitFactory.class, "creationInstanceGestionnairePBJCProduit", "Classe de la facade produit pour PBJC introuvable");
        }
        throw new CoucheLogiqueException("HG_PR_CALI_L_FACADE_POUR_PBJC_INTROUVABLE", "Classe de la facade produit pour PBJC introuvable", null);
      }
      try
      {
        classeGestionnaire = Class.forName(nomClasseGestionnaire);
        instanceGestionnaire = (FacadePrimeProduitSpec)classeGestionnaire.newInstance();
      }
      catch (ClassNotFoundException e)
      {
        if (Log.isTraceActive(FacadePrimesProduitFactory.class, Niveau.WARN)) {
          Log.ecritTrace(Niveau.WARN, FacadePrimesProduitFactory.class, "creationInstanceGestionnairePBJCProduit", e.getMessage());
        }
        throw new CoucheLogiqueException("HG_PR_CALI_L_ERR_GENERIQUE_CLASSE_NON_TROUVE", "Classe non trouvee:" + e.getMessage(), e);
      }
      catch (IllegalAccessException iae)
      {
        if (Log.isTraceActive(FacadePrimesProduitFactory.class, Niveau.WARN)) {
          Log.ecritTrace(Niveau.WARN, FacadePrimesProduitFactory.class, "creationInstanceGestionnairePBJCProduit", iae.getMessage());
        }
        throw new CoucheLogiqueException("HG_PR_CALI_L_PROBLEME_D_INSTANCIATION", "Impossible d'instancier un objet", iae);
      }
      catch (InstantiationException ie)
      {
        if (Log.isTraceActive(FacadePrimesProduitFactory.class, Niveau.WARN)) {
          Log.ecritTrace(Niveau.WARN, FacadePrimesProduitFactory.class, "creationInstanceGestionnairePBJCProduit", ie.getMessage());
        }
        throw new CoucheLogiqueException("HG_PR_CALI_L_PROBLEME_D_INSTANCIATION", "Impossible d'instancier un objet", ie);
      }
      m_instancesGestionnairesProduitMap.put(p_nomProduit, instanceGestionnaire);
    }
    return instanceGestionnaire;
  }
}

/* Location:
 * Qualified Name:     FacadePrimesProduitFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */