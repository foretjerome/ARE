package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.databean.Attribute;
import fr.unedic.archi.databean.DataBean;
import fr.unedic.archi.databean.DataBeanImpl;
import fr.unedic.archi.databean.DataList;
import fr.unedic.archi.databean.GettersHandler;
import fr.unedic.archi.databean.PropertyInfo;
import fr.unedic.archi.databean.SettersHandler;
import fr.unedic.archi.databean.StringAttribute;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class _ListeDSMTravail
  extends DataBeanImpl
  implements DataBean, Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  private DataList m_dsmTravail = _getInstanceListe();
  private String m__C_ETAT;
  private String m__IDENT;
  
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
  
  public _DsmTravail[] getListeDSMTravail()
  {
    Object[] objTab = _getArrayFromList(m_dsmTravail, _DsmTravail.class);
    int length = objTab.length;
    _DsmTravail[] tab = new _DsmTravail[length];
    for (int i = 0; i < length; i++) {
      tab[i] = ((_DsmTravail)objTab[i]);
    }
    return tab;
  }
  
  public DataList getInternalListeDSMTravail()
  {
    return m_dsmTravail;
  }
  
  public int getNbListeDSMTravail()
  {
    return m_dsmTravail.getNbElement();
  }
  
  public _DsmTravail getListeDSMTravail(int pIndex)
  {
    Object obj = m_dsmTravail.getElement(pIndex);
    ExceptionUtil.assertInstanceOf("element", obj, _DsmTravail.class);
    return (_DsmTravail)obj;
  }
  
  public void addListeDSMTravail(_DsmTravail pElement)
  {
    ExceptionUtil.assertMethodParamNotNull("element", pElement);
    m_dsmTravail.addElement(pElement);
  }
  
  public void removeDsmTravail(int pIndex)
  {
    m_dsmTravail.removeElement(pIndex);
  }
  
  public void removeDsmTravail(_DsmTravail pElement)
  {
    m_dsmTravail.removeElement(pElement);
  }
  
  public void setListeDSMTravail(_DsmTravail[] pIn)
  {
    _setArrayToList(pIn, m_dsmTravail);
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
    return null;
  }
  
  public PropertyInfo _getPropertyInfo(String pElementName)
    throws TechniqueException
  {
    PropertyInfo resultat = null;
    if ("DsmTravail".equals(pElementName)) {
      resultat = new PropertyInfo(pElementName, true, false, _DsmTravail.class, false);
    }
    return resultat;
  }
  
  public int _getPropertyLength(String pElementName)
  {
    return -1;
  }
  
  public Object _getProperty(String pName)
    throws Exception
  {
    Object resultat = null;
    if ("DsmTravail".equals(pName)) {
      resultat = m_dsmTravail;
    }
    return resultat;
  }
  
  public Iterator _getPropertyNames()
    throws Exception
  {
    ArrayList liste = new ArrayList();
    
    liste.add("DsmTravail");
    
    return liste.iterator();
  }
  
  public ArrayList _getPropertyNames(ArrayList pListe)
    throws Exception
  {
    pListe.add("DsmTravail");
    
    return pListe;
  }
  
  public void _setProperty(String pName, Object pValeur)
    throws Exception
  {
    if ("DsmTravail".equals(pName))
    {
      ExceptionUtil.assertMethodParamNotNull("pValeur", pValeur, _DsmTravail.class);
      if (m_dsmTravail != null)
      {
        m_dsmTravail.addElement(pValeur);
      }
      else
      {
        m_dsmTravail = _getInstanceListe();
        m_dsmTravail.addElement(pValeur);
      }
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
  }
  
  public String _getAttribute(String pPropertyName, String pAttributeName)
  {
    String resultat = null;
    StringBuffer attr = new StringBuffer();
    attr.append("m_");
    if (pPropertyName != null) {
      attr.append(pPropertyName);
    }
    attr.append("_").append(pAttributeName);
    String attrName = attr.toString();
    if ("m__C_ETAT".equals(attrName)) {
      resultat = m__C_ETAT;
    }
    if ("m__IDENT".equals(attrName)) {
      resultat = m__IDENT;
    }
    return resultat;
  }
  
  public boolean equals(Object pObjet)
  {
    if (!(pObjet instanceof _ListeDSMTravail)) {
      return false;
    }
    _ListeDSMTravail x = (_ListeDSMTravail)pObjet;
    if ((m_dsmTravail == null) && (m_dsmTravail == null)) {
      return true;
    }
    if ((m_dsmTravail != null) && (m_dsmTravail == null)) {
      return false;
    }
    if ((m_dsmTravail == null) && (m_dsmTravail != null)) {
      return false;
    }
    if (getListeDSMTravail().length != x.getListeDSMTravail().length) {
      return false;
    }
    for (int i = 0; i < getListeDSMTravail().length; i++) {
      if ((getListeDSMTravail()[i] != null) && 
        (!getListeDSMTravail()[i].equals(x.getListeDSMTravail()[i]))) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int resultat = 0;
    if (m_dsmTravail != null) {
      for (int i = 0; i < getListeDSMTravail().length; i++) {
        if (getListeDSMTravail()[i] != null) {
          resultat += getListeDSMTravail()[i].hashCode();
        }
      }
    }
    return resultat;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    _ListeDSMTravail clone_ListeDSMTravail = new _ListeDSMTravail();
    
    clone_ListeDSMTravail.populateFrom_ListeDSMTravail(this);
    
    return clone_ListeDSMTravail;
  }
  
  public void populateFrom_ListeDSMTravail(_ListeDSMTravail pSource)
  {
    setListeDSMTravail(pSource.getListeDSMTravail());
  }
  
  public String toString()
  {
    StringBuffer s = new StringBuffer("[_ListeDSMTravail");
    
    subToString(s);
    
    s.append("]");
    
    return s.toString();
  }
  
  protected void subToString(StringBuffer pSource)
  {
    pSource.append(", DsmTravail: ");
    if (m_dsmTravail == null)
    {
      pSource.append("null");
    }
    else
    {
      pSource.append("{");
      for (int i = 0; i < getListeDSMTravail().length; i++)
      {
        if (i > 0) {
          pSource.append(", ");
        }
        pSource.append(getListeDSMTravail()[i]);
      }
      pSource.append("}");
    }
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
    DataBean[] DsmTravail_Value = getListeDSMTravail();
    GettersHandler[] DsmTravail_GettersHandler = pHandler.property("DsmTravail", DsmTravail_Value, null);
    if ((DsmTravail_GettersHandler != null) && (DsmTravail_Value != null)) {
      for (int i = 0; i < DsmTravail_GettersHandler.length; i++) {
        if ((DsmTravail_GettersHandler[i] != null) && (DsmTravail_Value[i] != null)) {
          DsmTravail_Value[i].goThrough(DsmTravail_GettersHandler[i]);
        }
      }
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
    
    DataBean[] DsmTravail_dbs = pHandler.databeanArrayProperty("DsmTravail", _DsmTravail.class);
    if (DsmTravail_dbs == null)
    {
      setListeDSMTravail(null);
    }
    else
    {
      _DsmTravail[] DsmTravail_array = new _DsmTravail[DsmTravail_dbs.length];
      for (int i = 0; i < DsmTravail_dbs.length; i++) {
        DsmTravail_array[i] = ((_DsmTravail)DsmTravail_dbs[i]);
      }
      setListeDSMTravail(DsmTravail_array);
    }
  }
  
  public String _getDatabeanName()
  {
    return "ListeDSMTravail";
  }
  
  public boolean _isValidProperty(String pElementName)
  {
    if ("DsmTravail".equals(pElementName)) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _ListeDSMTravail
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */