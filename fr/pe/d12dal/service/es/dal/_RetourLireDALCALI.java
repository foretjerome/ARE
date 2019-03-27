package fr.pe.d12dal.service.es.dal;

import fr.unedic.archi.commun.exception.TechniqueException;
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

public class _RetourLireDALCALI
  extends DataBeanImpl
  implements DataBean, Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  private String m__C_ETAT;
  private String m__IDENT;
  private _RetourLireDALCALI_listeInfosDALCALI m_retourLireDALCALI_listeInfosDALCALI;
  private String m_retourLireDALCALI_listeInfosDALCALI_C_ERR;
  
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
  
  public _RetourLireDALCALI_listeInfosDALCALI getListeInfosDALCALI()
  {
    return m_retourLireDALCALI_listeInfosDALCALI;
  }
  
  public String getListeInfosDALCALI_C_ERR()
  {
    return m_retourLireDALCALI_listeInfosDALCALI_C_ERR;
  }
  
  public void setListeInfosDALCALI(_RetourLireDALCALI_listeInfosDALCALI pValeur)
  {
    m_retourLireDALCALI_listeInfosDALCALI = pValeur;
  }
  
  public void setListeInfosDALCALI_C_ERR(String pValeur_C_ERR)
  {
    m_retourLireDALCALI_listeInfosDALCALI_C_ERR = pValeur_C_ERR;
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
    if ("m_retourLireDALCALI_listeInfosDALCALI_C_ERR".equals(attrName)) {
      return String.class;
    }
    return null;
  }
  
  public PropertyInfo _getPropertyInfo(String pElementName)
    throws TechniqueException
  {
    if ("RetourLireDALCALI_listeInfosDALCALI".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, _RetourLireDALCALI_listeInfosDALCALI.class, false);
      return info;
    }
    return null;
  }
  
  public int _getPropertyLength(String pElementName)
  {
    if ("RetourLireDALCALI_listeInfosDALCALI".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    return -1;
  }
  
  public Object _getProperty(String pName)
    throws Exception
  {
    if ("RetourLireDALCALI_listeInfosDALCALI".equals(pName)) {
      return m_retourLireDALCALI_listeInfosDALCALI;
    }
    return null;
  }
  
  public Iterator _getPropertyNames()
    throws Exception
  {
    ArrayList liste = new ArrayList();
    liste.add("RetourLireDALCALI_listeInfosDALCALI");
    return liste.iterator();
  }
  
  public ArrayList _getPropertyNames(ArrayList pListe)
    throws Exception
  {
    pListe.add("RetourLireDALCALI_listeInfosDALCALI");
    return pListe;
  }
  
  public void _setProperty(String pName, Object pValeur)
    throws Exception
  {
    if ("RetourLireDALCALI_listeInfosDALCALI".equals(pName)) {
      m_retourLireDALCALI_listeInfosDALCALI = ((_RetourLireDALCALI_listeInfosDALCALI)pValeur);
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
    if ("m_retourLireDALCALI_listeInfosDALCALI_C_ERR".equals(attrName)) {
      m_retourLireDALCALI_listeInfosDALCALI_C_ERR = pValeur;
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
    if ("m_retourLireDALCALI_listeInfosDALCALI_C_ERR".equals(attrName)) {
      return m_retourLireDALCALI_listeInfosDALCALI_C_ERR;
    }
    return null;
  }
  
  public boolean equals(Object pObjet)
  {
    if (!(pObjet instanceof _RetourLireDALCALI)) {
      return false;
    }
    _RetourLireDALCALI x = (_RetourLireDALCALI)pObjet;
    if (m_retourLireDALCALI_listeInfosDALCALI == null)
    {
      if (m_retourLireDALCALI_listeInfosDALCALI != null) {
        return false;
      }
    }
    else
    {
      if (m_retourLireDALCALI_listeInfosDALCALI == null) {
        return false;
      }
      if (!m_retourLireDALCALI_listeInfosDALCALI.equals(m_retourLireDALCALI_listeInfosDALCALI)) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int result = 0;
    if (m_retourLireDALCALI_listeInfosDALCALI != null) {
      result += m_retourLireDALCALI_listeInfosDALCALI.hashCode();
    }
    result *= 17;
    return result;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    _RetourLireDALCALI clone_RetourLireDALCALI = new _RetourLireDALCALI();
    clone_RetourLireDALCALI.populateFrom_RetourLireDALCALI(this);
    return clone_RetourLireDALCALI;
  }
  
  public void populateFrom_RetourLireDALCALI(_RetourLireDALCALI pSource)
  {
    setListeInfosDALCALI(pSource.getListeInfosDALCALI());
  }
  
  public String toString()
  {
    StringBuffer s = new StringBuffer("[_RetourLireDALCALI");
    subToString(s);
    s.append("]");
    return s.toString();
  }
  
  protected void subToString(StringBuffer pSource)
  {
    pSource.append(", RetourLireDALCALI_listeInfosDALCALI: ");
    pSource.append(m_retourLireDALCALI_listeInfosDALCALI);
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
    DataBean RetourLireDALCALI_listeInfosDALCALI_Value = getListeInfosDALCALI();
    GettersHandler RetourLireDALCALI_listeInfosDALCALI_GettersHandler = pHandler.property("RetourLireDALCALI_listeInfosDALCALI", RetourLireDALCALI_listeInfosDALCALI_Value, new Attribute[] { new StringAttribute("C_ERR", getListeInfosDALCALI_C_ERR()) });
    if ((RetourLireDALCALI_listeInfosDALCALI_GettersHandler != null) && (RetourLireDALCALI_listeInfosDALCALI_Value != null)) {
      RetourLireDALCALI_listeInfosDALCALI_Value.goThrough(RetourLireDALCALI_listeInfosDALCALI_GettersHandler);
    }
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
    setListeInfosDALCALI((_RetourLireDALCALI_listeInfosDALCALI)pHandler.databeanProperty("RetourLireDALCALI_listeInfosDALCALI", _RetourLireDALCALI_listeInfosDALCALI.class));
    setListeInfosDALCALI_C_ERR(pHandler.stringAttribute("RetourLireDALCALI_listeInfosDALCALI", "C_ERR"));
  }
  
  public String _getDatabeanName()
  {
    return "RetourLireDALCALI";
  }
  
  public boolean _isValidProperty(String pElementName)
  {
    if ("RetourLireDALCALI_listeInfosDALCALI".equals(pElementName)) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _RetourLireDALCALI
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */