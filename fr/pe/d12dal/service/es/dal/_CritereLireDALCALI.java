package fr.pe.d12dal.service.es.dal;

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

public class _CritereLireDALCALI
  extends DataBeanImpl
  implements DataBean, Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  private String m__C_ETAT;
  private String m__IDENT;
  private String m_cxalaf;
  private String m_cxalaf_C_ERR;
  private String m_codePE;
  private String m_codePE_C_ERR;
  private String m_refExterne;
  private String m_refExterne_C_ERR;
  
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
    if ("m_cxalaf_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_codePE_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_refExterne_C_ERR".equals(attrName)) {
      return String.class;
    }
    return null;
  }
  
  public PropertyInfo _getPropertyInfo(String pElementName)
    throws TechniqueException
  {
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
    return null;
  }
  
  public int _getPropertyLength(String pElementName)
  {
    if ("cxalaf".equals(pElementName)) {
      return 10;
    }
    if ("codePE".equals(pElementName)) {
      return 3;
    }
    if ("refExterne".equals(pElementName)) {
      return 7;
    }
    return -1;
  }
  
  public Object _getProperty(String pName)
    throws Exception
  {
    if ("cxalaf".equals(pName)) {
      return m_cxalaf;
    }
    if ("codePE".equals(pName)) {
      return m_codePE;
    }
    if ("refExterne".equals(pName)) {
      return m_refExterne;
    }
    return null;
  }
  
  public Iterator _getPropertyNames()
    throws Exception
  {
    ArrayList liste = new ArrayList();
    liste.add("cxalaf");
    liste.add("codePE");
    liste.add("refExterne");
    return liste.iterator();
  }
  
  public ArrayList _getPropertyNames(ArrayList pListe)
    throws Exception
  {
    pListe.add("cxalaf");
    pListe.add("codePE");
    pListe.add("refExterne");
    return pListe;
  }
  
  public void _setProperty(String pName, Object pValeur)
    throws Exception
  {
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
    if ("m_cxalaf_C_ERR".equals(attrName)) {
      m_cxalaf_C_ERR = pValeur;
    }
    if ("m_codePE_C_ERR".equals(attrName)) {
      m_codePE_C_ERR = pValeur;
    }
    if ("m_refExterne_C_ERR".equals(attrName)) {
      m_refExterne_C_ERR = pValeur;
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
    if ("m_cxalaf_C_ERR".equals(attrName)) {
      return m_cxalaf_C_ERR;
    }
    if ("m_codePE_C_ERR".equals(attrName)) {
      return m_codePE_C_ERR;
    }
    if ("m_refExterne_C_ERR".equals(attrName)) {
      return m_refExterne_C_ERR;
    }
    return null;
  }
  
  public boolean equals(Object pObjet)
  {
    if (!(pObjet instanceof _CritereLireDALCALI)) {
      return false;
    }
    _CritereLireDALCALI x = (_CritereLireDALCALI)pObjet;
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
    return true;
  }
  
  public int hashCode()
  {
    int result = 0;
    if (m_cxalaf != null) {
      result += m_cxalaf.hashCode();
    }
    if (m_codePE != null) {
      result += m_codePE.hashCode();
    }
    if (m_refExterne != null) {
      result += m_refExterne.hashCode();
    }
    result *= 17;
    return result;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    _CritereLireDALCALI clone_CritereLireDALCALI = new _CritereLireDALCALI();
    clone_CritereLireDALCALI.populateFrom_CritereLireDALCALI(this);
    return clone_CritereLireDALCALI;
  }
  
  public void populateFrom_CritereLireDALCALI(_CritereLireDALCALI pSource)
  {
    setCxalaf(pSource.getCxalaf());setCodePE(pSource.getCodePE());setRefExterne(pSource.getRefExterne());
  }
  
  public String toString()
  {
    StringBuffer s = new StringBuffer("[_CritereLireDALCALI");
    subToString(s);
    s.append("]");
    return s.toString();
  }
  
  protected void subToString(StringBuffer pSource)
  {
    pSource.append(", cxalaf: ");
    pSource.append(m_cxalaf);
    pSource.append(", codePE: ");
    pSource.append(m_codePE);
    pSource.append(", refExterne: ");
    pSource.append(m_refExterne);
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
    pHandler.property("cxalaf", getCxalaf(), new Attribute[] { new StringAttribute("C_ERR", getCxalaf_C_ERR()) });
    
    pHandler.property("codePE", getCodePE(), new Attribute[] { new StringAttribute("C_ERR", getCodePE_C_ERR()) });
    
    pHandler.property("refExterne", getRefExterne(), new Attribute[] { new StringAttribute("C_ERR", getRefExterne_C_ERR()) });
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
    setCxalaf((String)pHandler.objectProperty("cxalaf", String.class));
    setCxalaf_C_ERR(pHandler.stringAttribute("cxalaf", "C_ERR"));
    
    setCodePE((String)pHandler.objectProperty("codePE", String.class));
    setCodePE_C_ERR(pHandler.stringAttribute("codePE", "C_ERR"));
    
    setRefExterne((String)pHandler.objectProperty("refExterne", String.class));
    setRefExterne_C_ERR(pHandler.stringAttribute("refExterne", "C_ERR"));
  }
  
  public String _getDatabeanName()
  {
    return "CritereLireDALCALI";
  }
  
  public boolean _isValidProperty(String pElementName)
  {
    if ("cxalaf".equals(pElementName)) {
      return true;
    }
    if ("codePE".equals(pElementName)) {
      return true;
    }
    if ("refExterne".equals(pElementName)) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _CritereLireDALCALI
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */