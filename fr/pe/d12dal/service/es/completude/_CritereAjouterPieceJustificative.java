package fr.pe.d12dal.service.es.completude;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.databean.Attribute;
import fr.unedic.archi.databean.DataBean;
import fr.unedic.archi.databean.DataBeanImpl;
import fr.unedic.archi.databean.GettersHandler;
import fr.unedic.archi.databean.PropertyInfo;
import fr.unedic.archi.databean.SettersHandler;
import fr.unedic.archi.databean.StringAttribute;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class _CritereAjouterPieceJustificative
  extends DataBeanImpl
  implements DataBean, Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  private String m__C_ETAT;
  private String m__IDENT;
  private _ContexteServiceES m_contexteServiceES;
  private String m_contexteServiceES_C_ERR;
  private String m_cxalaf;
  private String m_cxalaf_C_ERR;
  private String m_codePE;
  private String m_codePE_C_ERR;
  private String m_refExterne;
  private String m_refExterne_C_ERR;
  private String m_casUtilisation;
  private String m_casUtilisation_C_ERR;
  private String m_idPeriodeGAEC;
  private String m_idPeriodeGAEC_C_ERR;
  private String m_rsin;
  private String m_rsin_C_ERR;
  
  public String get_C_ETAT()
  {
    return m__C_ETAT;
  }
  
  public String get_IDENT()
  {
    return m__IDENT;
  }
  
  public void set_C_ETAT(String pCETAT)
  {
    m__C_ETAT = pCETAT;
  }
  
  public void set_IDENT(String pIDENT)
  {
    m__IDENT = pIDENT;
  }
  
  public _ContexteServiceES getContexteService()
  {
    return m_contexteServiceES;
  }
  
  public String getContexteService_C_ERR()
  {
    return m_contexteServiceES_C_ERR;
  }
  
  public void setContexteService(_ContexteServiceES pValeur)
  {
    m_contexteServiceES = pValeur;
  }
  
  public void setContexteService_C_ERR(String pValeur_C_ERR)
  {
    m_contexteServiceES_C_ERR = pValeur_C_ERR;
  }
  
  public String getCxalaf()
  {
    return m_cxalaf;
  }
  
  public String getCxalaf_C_ERR()
  {
    return m_cxalaf_C_ERR;
  }
  
  public void setCxalaf(String pValeur)
  {
    if (pValeur != null)
    {
      ExceptionUtil.assertMethodParamNotNull("pValeur (cxalaf)", pValeur, String.class);
      if (pValeur.length() > _getPropertyLength("cxalaf"))
      {
        TechniqueException t = new TechniqueException("JXX0100G", "Valeur trop longue pour l'attribut pValeur (cxalaf).");
        throw new IndexOutOfBoundsException(t.toString());
      }
    }
    m_cxalaf = pValeur;
  }
  
  public void setCxalaf_C_ERR(String pValeur_C_ERR)
  {
    m_cxalaf_C_ERR = pValeur_C_ERR;
  }
  
  public String getCodePE()
  {
    return m_codePE;
  }
  
  public String getCodePE_C_ERR()
  {
    return m_codePE_C_ERR;
  }
  
  public void setCodePE(String pValeur)
  {
    if (pValeur != null)
    {
      ExceptionUtil.assertMethodParamNotNull("pValeur (codePE)", pValeur, String.class);
      if (pValeur.length() > _getPropertyLength("codePE"))
      {
        TechniqueException t = new TechniqueException("JXX0100G", "Valeur trop longue pour l'attribut pValeur (codePE).");
        throw new IndexOutOfBoundsException(t.toString());
      }
    }
    m_codePE = pValeur;
  }
  
  public void setCodePE_C_ERR(String pValeur_C_ERR)
  {
    m_codePE_C_ERR = pValeur_C_ERR;
  }
  
  public String getRefExterne()
  {
    return m_refExterne;
  }
  
  public String getRefExterne_C_ERR()
  {
    return m_refExterne_C_ERR;
  }
  
  public void setRefExterne(String pValeur)
  {
    if (pValeur != null)
    {
      ExceptionUtil.assertMethodParamNotNull("pValeur (refExterne)", pValeur, String.class);
      if (pValeur.length() > _getPropertyLength("refExterne"))
      {
        TechniqueException t = new TechniqueException("JXX0100G", "Valeur trop longue pour l'attribut pValeur (refExterne).");
        throw new IndexOutOfBoundsException(t.toString());
      }
    }
    m_refExterne = pValeur;
  }
  
  public void setRefExterne_C_ERR(String pValeur_C_ERR)
  {
    m_refExterne_C_ERR = pValeur_C_ERR;
  }
  
  public String getCasUtilisation()
  {
    return m_casUtilisation;
  }
  
  public String getCasUtilisation_C_ERR()
  {
    return m_casUtilisation_C_ERR;
  }
  
  public void setCasUtilisation(String pValeur)
  {
    m_casUtilisation = pValeur;
  }
  
  public void setCasUtilisation_C_ERR(String pValeur_C_ERR)
  {
    m_casUtilisation_C_ERR = pValeur_C_ERR;
  }
  
  public String getIdPeriodeGAEC()
  {
    return m_idPeriodeGAEC;
  }
  
  public String getIdPeriodeGAEC_C_ERR()
  {
    return m_idPeriodeGAEC_C_ERR;
  }
  
  public void setIdPeriodeGAEC(String pValeur)
  {
    if (pValeur != null)
    {
      ExceptionUtil.assertMethodParamNotNull("pValeur (idPeriodeGAEC)", pValeur, String.class);
      if (pValeur.length() > _getPropertyLength("idPeriodeGAEC"))
      {
        TechniqueException t = new TechniqueException("JXX0100G", "Valeur trop longue pour l'attribut pValeur (idPeriodeGAEC).");
        throw new IndexOutOfBoundsException(t.toString());
      }
    }
    m_idPeriodeGAEC = pValeur;
  }
  
  public void setIdPeriodeGAEC_C_ERR(String pValeur_C_ERR)
  {
    m_idPeriodeGAEC_C_ERR = pValeur_C_ERR;
  }
  
  public String getRsin()
  {
    return m_rsin;
  }
  
  public String getRsin_C_ERR()
  {
    return m_rsin_C_ERR;
  }
  
  public void setRsin(String pValeur)
  {
    if (pValeur != null)
    {
      ExceptionUtil.assertMethodParamNotNull("pValeur (rsin)", pValeur, String.class);
      if (pValeur.length() > _getPropertyLength("rsin"))
      {
        TechniqueException t = new TechniqueException("JXX0100G", "Valeur trop longue pour l'attribut pValeur (rsin).");
        throw new IndexOutOfBoundsException(t.toString());
      }
    }
    m_rsin = pValeur;
  }
  
  public void setRsin_C_ERR(String pValeur_C_ERR)
  {
    m_rsin_C_ERR = pValeur_C_ERR;
  }
  
  public Class _getAttributeType(String pPropertyName, String pAttributeName)
  {
    StringBuffer attr = new StringBuffer();
    attr.append("m_");
    if (pPropertyName != null) {
      attr.append(pPropertyName);
    }
    attr.append("_").append(pAttributeName);
    String attrName = attr.toString();
    if ("m__C_ETAT".equals(attrName)) {
      return String.class;
    }
    if ("m__IDENT".equals(attrName)) {
      return String.class;
    }
    if ("m_contexteServiceES_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_cxalaf_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_codePE_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_refExterne_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_casUtilisation_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_idPeriodeGAEC_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_rsin_C_ERR".equals(attrName)) {
      return String.class;
    }
    return null;
  }
  
  public PropertyInfo _getPropertyInfo(String pElementName)
    throws TechniqueException
  {
    if ("ContexteServiceES".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, _ContexteServiceES.class, false);
      return info;
    }
    if ("cxalaf".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("codePE".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("refExterne".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("casUtilisation".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("idPeriodeGAEC".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("rsin".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    return null;
  }
  
  public int _getPropertyLength(String pElementName)
  {
    if ("ContexteServiceES".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("cxalaf".equals(pElementName)) {
      return 10;
    }
    if ("codePE".equals(pElementName)) {
      return 3;
    }
    if ("refExterne".equals(pElementName)) {
      return 7;
    }
    if ("casUtilisation".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("idPeriodeGAEC".equals(pElementName)) {
      return 17;
    }
    if ("rsin".equals(pElementName)) {
      return 8;
    }
    return -1;
  }
  
  public Object _getProperty(String pName)
    throws Exception
  {
    if ("ContexteServiceES".equals(pName)) {
      return m_contexteServiceES;
    }
    if ("cxalaf".equals(pName)) {
      return m_cxalaf;
    }
    if ("codePE".equals(pName)) {
      return m_codePE;
    }
    if ("refExterne".equals(pName)) {
      return m_refExterne;
    }
    if ("casUtilisation".equals(pName)) {
      return m_casUtilisation;
    }
    if ("idPeriodeGAEC".equals(pName)) {
      return m_idPeriodeGAEC;
    }
    if ("rsin".equals(pName)) {
      return m_rsin;
    }
    return null;
  }
  
  public Iterator _getPropertyNames()
    throws Exception
  {
    ArrayList liste = new ArrayList();
    liste.add("ContexteServiceES");
    liste.add("cxalaf");
    liste.add("codePE");
    liste.add("refExterne");
    liste.add("casUtilisation");
    liste.add("idPeriodeGAEC");
    liste.add("rsin");
    return liste.iterator();
  }
  
  public ArrayList _getPropertyNames(ArrayList pListe)
    throws Exception
  {
    pListe.add("ContexteServiceES");
    pListe.add("cxalaf");
    pListe.add("codePE");
    pListe.add("refExterne");
    pListe.add("casUtilisation");
    pListe.add("idPeriodeGAEC");
    pListe.add("rsin");
    return pListe;
  }
  
  public void _setProperty(String pName, Object pValeur)
    throws Exception
  {
    if ("ContexteServiceES".equals(pName)) {
      m_contexteServiceES = ((_ContexteServiceES)pValeur);
    }
    if ("cxalaf".equals(pName))
    {
      if ((pValeur != null) && 
        (((String)pValeur).length() > _getPropertyLength("cxalaf")))
      {
        TechniqueException t = new TechniqueException("JXX0100G", "Valeur trop longue pour l'attribut cxalaf.");
        throw new IndexOutOfBoundsException(t.toString());
      }
      m_cxalaf = ((String)pValeur);
    }
    if ("codePE".equals(pName))
    {
      if ((pValeur != null) && 
        (((String)pValeur).length() > _getPropertyLength("codePE")))
      {
        TechniqueException t = new TechniqueException("JXX0100G", "Valeur trop longue pour l'attribut codePE.");
        throw new IndexOutOfBoundsException(t.toString());
      }
      m_codePE = ((String)pValeur);
    }
    if ("refExterne".equals(pName))
    {
      if ((pValeur != null) && 
        (((String)pValeur).length() > _getPropertyLength("refExterne")))
      {
        TechniqueException t = new TechniqueException("JXX0100G", "Valeur trop longue pour l'attribut refExterne.");
        throw new IndexOutOfBoundsException(t.toString());
      }
      m_refExterne = ((String)pValeur);
    }
    if ("casUtilisation".equals(pName)) {
      m_casUtilisation = ((String)pValeur);
    }
    if ("idPeriodeGAEC".equals(pName))
    {
      if ((pValeur != null) && 
        (((String)pValeur).length() > _getPropertyLength("idPeriodeGAEC")))
      {
        TechniqueException t = new TechniqueException("JXX0100G", "Valeur trop longue pour l'attribut idPeriodeGAEC.");
        throw new IndexOutOfBoundsException(t.toString());
      }
      m_idPeriodeGAEC = ((String)pValeur);
    }
    if ("rsin".equals(pName))
    {
      if ((pValeur != null) && 
        (((String)pValeur).length() > _getPropertyLength("rsin")))
      {
        TechniqueException t = new TechniqueException("JXX0100G", "Valeur trop longue pour l'attribut rsin.");
        throw new IndexOutOfBoundsException(t.toString());
      }
      m_rsin = ((String)pValeur);
    }
  }
  
  public void _setAttribute(String pPropertyName, String pAttributeName, String pValeur)
    throws Exception
  {
    StringBuffer attr = new StringBuffer();
    attr.append("m_");
    if (pPropertyName != null) {
      attr.append(pPropertyName);
    }
    attr.append("_").append(pAttributeName);
    String attrName = attr.toString();
    if ("m__C_ETAT".equals(attrName)) {
      m__C_ETAT = pValeur;
    }
    if ("m__IDENT".equals(attrName)) {
      m__IDENT = pValeur;
    }
    if ("m_contexteServiceES_C_ERR".equals(attrName)) {
      m_contexteServiceES_C_ERR = pValeur;
    }
    if ("m_cxalaf_C_ERR".equals(attrName)) {
      m_cxalaf_C_ERR = pValeur;
    }
    if ("m_codePE_C_ERR".equals(attrName)) {
      m_codePE_C_ERR = pValeur;
    }
    if ("m_refExterne_C_ERR".equals(attrName)) {
      m_refExterne_C_ERR = pValeur;
    }
    if ("m_casUtilisation_C_ERR".equals(attrName)) {
      m_casUtilisation_C_ERR = pValeur;
    }
    if ("m_idPeriodeGAEC_C_ERR".equals(attrName)) {
      m_idPeriodeGAEC_C_ERR = pValeur;
    }
    if ("m_rsin_C_ERR".equals(attrName)) {
      m_rsin_C_ERR = pValeur;
    }
  }
  
  public String _getAttribute(String pPropertyName, String pAttributeName)
  {
    StringBuffer attr = new StringBuffer();
    attr.append("m_");
    if (pPropertyName != null) {
      attr.append(pPropertyName);
    }
    attr.append("_").append(pAttributeName);
    String attrName = attr.toString();
    if ("m__C_ETAT".equals(attrName)) {
      return m__C_ETAT;
    }
    if ("m__IDENT".equals(attrName)) {
      return m__IDENT;
    }
    if ("m_contexteServiceES_C_ERR".equals(attrName)) {
      return m_contexteServiceES_C_ERR;
    }
    if ("m_cxalaf_C_ERR".equals(attrName)) {
      return m_cxalaf_C_ERR;
    }
    if ("m_codePE_C_ERR".equals(attrName)) {
      return m_codePE_C_ERR;
    }
    if ("m_refExterne_C_ERR".equals(attrName)) {
      return m_refExterne_C_ERR;
    }
    if ("m_casUtilisation_C_ERR".equals(attrName)) {
      return m_casUtilisation_C_ERR;
    }
    if ("m_idPeriodeGAEC_C_ERR".equals(attrName)) {
      return m_idPeriodeGAEC_C_ERR;
    }
    if ("m_rsin_C_ERR".equals(attrName)) {
      return m_rsin_C_ERR;
    }
    return null;
  }
  
  public boolean equals(Object pObjet)
  {
    if (!(pObjet instanceof _CritereAjouterPieceJustificative)) {
      return false;
    }
    _CritereAjouterPieceJustificative x = (_CritereAjouterPieceJustificative)pObjet;
    if (m_contexteServiceES == null)
    {
      if (m_contexteServiceES != null) {
        return false;
      }
    }
    else
    {
      if (m_contexteServiceES == null) {
        return false;
      }
      if (!m_contexteServiceES.equals(m_contexteServiceES)) {
        return false;
      }
    }
    if (m_cxalaf == null)
    {
      if (m_cxalaf != null) {
        return false;
      }
    }
    else
    {
      if (m_cxalaf == null) {
        return false;
      }
      if (!m_cxalaf.equals(m_cxalaf)) {
        return false;
      }
    }
    if (m_codePE == null)
    {
      if (m_codePE != null) {
        return false;
      }
    }
    else
    {
      if (m_codePE == null) {
        return false;
      }
      if (!m_codePE.equals(m_codePE)) {
        return false;
      }
    }
    if (m_refExterne == null)
    {
      if (m_refExterne != null) {
        return false;
      }
    }
    else
    {
      if (m_refExterne == null) {
        return false;
      }
      if (!m_refExterne.equals(m_refExterne)) {
        return false;
      }
    }
    if (m_idPeriodeGAEC == null)
    {
      if (m_idPeriodeGAEC != null) {
        return false;
      }
    }
    else
    {
      if (m_idPeriodeGAEC == null) {
        return false;
      }
      if (!m_idPeriodeGAEC.equals(m_idPeriodeGAEC)) {
        return false;
      }
    }
    if (m_rsin == null)
    {
      if (m_rsin != null) {
        return false;
      }
    }
    else
    {
      if (m_rsin == null) {
        return false;
      }
      if (!m_rsin.equals(m_rsin)) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int result = 0;
    if (m_contexteServiceES != null) {
      result += m_contexteServiceES.hashCode();
    }
    if (m_cxalaf != null) {
      result += m_cxalaf.hashCode();
    }
    if (m_codePE != null) {
      result += m_codePE.hashCode();
    }
    if (m_refExterne != null) {
      result += m_refExterne.hashCode();
    }
    if (m_casUtilisation != null) {
      result += m_casUtilisation.hashCode();
    }
    if (m_idPeriodeGAEC != null) {
      result += m_idPeriodeGAEC.hashCode();
    }
    if (m_rsin != null) {
      result += m_rsin.hashCode();
    }
    result *= 17;
    return result;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    _CritereAjouterPieceJustificative clone_CritereAjouterPieceJustificative = new _CritereAjouterPieceJustificative();
    clone_CritereAjouterPieceJustificative.populateFrom_CritereAjouterPieceJustificative(this);
    return clone_CritereAjouterPieceJustificative;
  }
  
  public void populateFrom_CritereAjouterPieceJustificative(_CritereAjouterPieceJustificative pSource)
  {
    setContexteService(pSource.getContexteService());setCxalaf(pSource.getCxalaf());setCodePE(pSource.getCodePE());setRefExterne(pSource.getRefExterne());setCasUtilisation(pSource.getCasUtilisation());setIdPeriodeGAEC(pSource.getIdPeriodeGAEC());setRsin(pSource.getRsin());
  }
  
  public String toString()
  {
    StringBuffer s = new StringBuffer("[_CritereAjouterPieceJustificative");
    subToString(s);
    s.append("]");
    return s.toString();
  }
  
  protected void subToString(StringBuffer pSource)
  {
    pSource.append(", ContexteServiceES: ");
    pSource.append(m_contexteServiceES);
    pSource.append(", cxalaf: ");
    pSource.append(m_cxalaf);
    pSource.append(", codePE: ");
    pSource.append(m_codePE);
    pSource.append(", refExterne: ");
    pSource.append(m_refExterne);
    pSource.append(", casUtilisation: ");
    pSource.append(m_casUtilisation);
    pSource.append(", idPeriodeGAEC: ");
    pSource.append(m_idPeriodeGAEC);
    pSource.append(", rsin: ");
    pSource.append(m_rsin);
  }
  
  public void goThrough(GettersHandler pHandler)
    throws Exception
  {
    pHandler.startGoThrough(new Attribute[] { new StringAttribute("C_ETAT", get_C_ETAT()), new StringAttribute("IDENT", get_IDENT()) });
    
    subGoThrough(pHandler);
    
    pHandler.endGoThrough();
  }
  
  protected void subGoThrough(GettersHandler pHandler)
    throws Exception
  {
    DataBean ContexteServiceES_Value = getContexteService();
    GettersHandler ContexteServiceES_GettersHandler = pHandler.property("ContexteServiceES", ContexteServiceES_Value, new Attribute[] { new StringAttribute("C_ERR", getContexteService_C_ERR()) });
    if ((ContexteServiceES_GettersHandler != null) && (ContexteServiceES_Value != null)) {
      ContexteServiceES_Value.goThrough(ContexteServiceES_GettersHandler);
    }
    pHandler.property("cxalaf", getCxalaf(), new Attribute[] { new StringAttribute("C_ERR", getCxalaf_C_ERR()) });
    
    pHandler.property("codePE", getCodePE(), new Attribute[] { new StringAttribute("C_ERR", getCodePE_C_ERR()) });
    
    pHandler.property("refExterne", getRefExterne(), new Attribute[] { new StringAttribute("C_ERR", getRefExterne_C_ERR()) });
    
    pHandler.property("casUtilisation", getCasUtilisation(), new Attribute[] { new StringAttribute("C_ERR", getCasUtilisation_C_ERR()) });
    
    pHandler.property("idPeriodeGAEC", getIdPeriodeGAEC(), new Attribute[] { new StringAttribute("C_ERR", getIdPeriodeGAEC_C_ERR()) });
    
    pHandler.property("rsin", getRsin(), new Attribute[] { new StringAttribute("C_ERR", getRsin_C_ERR()) });
  }
  
  public void goThrough(SettersHandler pHandler)
    throws Exception
  {
    pHandler.startGoThrough();
    
    subGoThrough(pHandler);
    
    pHandler.endGoThrough();
  }
  
  protected void subGoThrough(SettersHandler pHandler)
    throws Exception
  {
    set_C_ETAT(pHandler.stringAttribute("C_ETAT"));
    set_IDENT(pHandler.stringAttribute("IDENT"));
    setContexteService((_ContexteServiceES)pHandler.databeanProperty("ContexteServiceES", _ContexteServiceES.class));
    setContexteService_C_ERR(pHandler.stringAttribute("ContexteServiceES", "C_ERR"));
    setCxalaf((String)pHandler.objectProperty("cxalaf", String.class));
    setCxalaf_C_ERR(pHandler.stringAttribute("cxalaf", "C_ERR"));
    
    setCodePE((String)pHandler.objectProperty("codePE", String.class));
    setCodePE_C_ERR(pHandler.stringAttribute("codePE", "C_ERR"));
    
    setRefExterne((String)pHandler.objectProperty("refExterne", String.class));
    setRefExterne_C_ERR(pHandler.stringAttribute("refExterne", "C_ERR"));
    
    setCasUtilisation((String)pHandler.objectProperty("casUtilisation", String.class));
    setCasUtilisation_C_ERR(pHandler.stringAttribute("casUtilisation", "C_ERR"));
    
    setIdPeriodeGAEC((String)pHandler.objectProperty("idPeriodeGAEC", String.class));
    setIdPeriodeGAEC_C_ERR(pHandler.stringAttribute("idPeriodeGAEC", "C_ERR"));
    
    setRsin((String)pHandler.objectProperty("rsin", String.class));
    setRsin_C_ERR(pHandler.stringAttribute("rsin", "C_ERR"));
  }
  
  public String _getDatabeanName()
  {
    return "CritereAjouterPieceJustificative";
  }
  
  public boolean _isValidProperty(String pElementName)
  {
    if ("ContexteServiceES".equals(pElementName)) {
      return true;
    }
    if ("cxalaf".equals(pElementName)) {
      return true;
    }
    if ("codePE".equals(pElementName)) {
      return true;
    }
    if ("refExterne".equals(pElementName)) {
      return true;
    }
    if ("casUtilisation".equals(pElementName)) {
      return true;
    }
    if ("idPeriodeGAEC".equals(pElementName)) {
      return true;
    }
    if ("rsin".equals(pElementName)) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _CritereAjouterPieceJustificative
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */