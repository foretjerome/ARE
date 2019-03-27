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

public class _ListeRSOD
  extends DataBeanImpl
  implements DataBean, Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  private DataList m_RSOD = _getInstanceListe();
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
  
  public _RSOD[] getListeRSOD()
  {
    Object[] objTab = _getArrayFromList(m_RSOD, _RSOD.class);
    int length = objTab.length;
    _RSOD[] tab = new _RSOD[length];
    for (int i = 0; i < length; i++) {
      tab[i] = ((_RSOD)objTab[i]);
    }
    return tab;
  }
  
  public DataList getInternalListeRSOD()
  {
    return m_RSOD;
  }
  
  public int getNbListeRSOD()
  {
    return m_RSOD.getNbElement();
  }
  
  public _RSOD getListeRSOD(int pIndex)
  {
    Object obj = m_RSOD.getElement(pIndex);
    ExceptionUtil.assertInstanceOf("element", obj, _RSOD.class);
    return (_RSOD)obj;
  }
  
  public void addListeRSOD(_RSOD pElement)
  {
    ExceptionUtil.assertMethodParamNotNull("element", pElement);
    m_RSOD.addElement(pElement);
  }
  
  public void removeRSOD(int pIndex)
  {
    m_RSOD.removeElement(pIndex);
  }
  
  public void removeRSOD(_RSOD pElement)
  {
    m_RSOD.removeElement(pElement);
  }
  
  public void setListeRSOD(_RSOD[] pIn)
  {
    _setArrayToList(pIn, m_RSOD);
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
    if ("RSOD".equals(pElementName)) {
      resultat = new PropertyInfo(pElementName, true, false, _RSOD.class, false);
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
    if ("RSOD".equals(pName)) {
      resultat = m_RSOD;
    }
    return resultat;
  }
  
  public Iterator _getPropertyNames()
    throws Exception
  {
    ArrayList liste = new ArrayList();
    
    liste.add("RSOD");
    
    return liste.iterator();
  }
  
  public ArrayList _getPropertyNames(ArrayList pListe)
    throws Exception
  {
    pListe.add("RSOD");
    
    return pListe;
  }
  
  public void _setProperty(String pName, Object pValeur)
    throws Exception
  {
    if ("RSOD".equals(pName))
    {
      ExceptionUtil.assertMethodParamNotNull("pValeur", pValeur, _RSOD.class);
      if (m_RSOD != null)
      {
        m_RSOD.addElement(pValeur);
      }
      else
      {
        m_RSOD = _getInstanceListe();
        m_RSOD.addElement(pValeur);
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
    if (!(pObjet instanceof _ListeRSOD)) {
      return false;
    }
    _ListeRSOD x = (_ListeRSOD)pObjet;
    if ((m_RSOD == null) && (m_RSOD == null)) {
      return true;
    }
    if ((m_RSOD != null) && (m_RSOD == null)) {
      return false;
    }
    if ((m_RSOD == null) && (m_RSOD != null)) {
      return false;
    }
    if (getListeRSOD().length != x.getListeRSOD().length) {
      return false;
    }
    for (int i = 0; i < getListeRSOD().length; i++) {
      if ((getListeRSOD()[i] != null) && 
        (!getListeRSOD()[i].equals(x.getListeRSOD()[i]))) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int resultat = 0;
    if (m_RSOD != null) {
      for (int i = 0; i < getListeRSOD().length; i++) {
        if (getListeRSOD()[i] != null) {
          resultat += getListeRSOD()[i].hashCode();
        }
      }
    }
    return resultat;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    _ListeRSOD clone_ListeRSOD = new _ListeRSOD();
    
    clone_ListeRSOD.populateFrom_ListeRSOD(this);
    
    return clone_ListeRSOD;
  }
  
  public void populateFrom_ListeRSOD(_ListeRSOD pSource)
  {
    setListeRSOD(pSource.getListeRSOD());
  }
  
  public String toString()
  {
    StringBuffer s = new StringBuffer("[_ListeRSOD");
    
    subToString(s);
    
    s.append("]");
    
    return s.toString();
  }
  
  protected void subToString(StringBuffer pSource)
  {
    pSource.append(", RSOD: ");
    if (m_RSOD == null)
    {
      pSource.append("null");
    }
    else
    {
      pSource.append("{");
      for (int i = 0; i < getListeRSOD().length; i++)
      {
        if (i > 0) {
          pSource.append(", ");
        }
        pSource.append(getListeRSOD()[i]);
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
    DataBean[] RSOD_Value = getListeRSOD();
    GettersHandler[] RSOD_GettersHandler = pHandler.property("RSOD", RSOD_Value, null);
    if ((RSOD_GettersHandler != null) && (RSOD_Value != null)) {
      for (int i = 0; i < RSOD_GettersHandler.length; i++) {
        if ((RSOD_GettersHandler[i] != null) && (RSOD_Value[i] != null)) {
          RSOD_Value[i].goThrough(RSOD_GettersHandler[i]);
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
    
    DataBean[] RSOD_dbs = pHandler.databeanArrayProperty("RSOD", _RSOD.class);
    if (RSOD_dbs == null)
    {
      setListeRSOD(null);
    }
    else
    {
      _RSOD[] RSOD_array = new _RSOD[RSOD_dbs.length];
      for (int i = 0; i < RSOD_dbs.length; i++) {
        RSOD_array[i] = ((_RSOD)RSOD_dbs[i]);
      }
      setListeRSOD(RSOD_array);
    }
  }
  
  public String _getDatabeanName()
  {
    return "ListeRSOD";
  }
  
  public boolean _isValidProperty(String pElementName)
  {
    if ("RSOD".equals(pElementName)) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _ListeRSOD
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */