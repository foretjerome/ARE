package fr.pe.d12dal.service.es.dal;

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

public class _RetourLireDALCALI_listeInfosDALCALI
  extends DataBeanImpl
  implements DataBean, Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  private DataList m_infosDalCALI = _getInstanceListe();
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
  
  public _InfosDalCALI[] getListeInfosDALCALI()
  {
    Object[] objTab = _getArrayFromList(m_infosDalCALI, _InfosDalCALI.class);
    int length = objTab.length;
    _InfosDalCALI[] tab = new _InfosDalCALI[length];
    for (int i = 0; i < length; i++) {
      tab[i] = ((_InfosDalCALI)objTab[i]);
    }
    return tab;
  }
  
  public DataList getInternalRetourLireDALCALI_listeInfosDALCALI()
  {
    return m_infosDalCALI;
  }
  
  public int getNbRetourLireDALCALI_listeInfosDALCALI()
  {
    return m_infosDalCALI.getNbElement();
  }
  
  public _InfosDalCALI getListeInfosDALCALI(int pIndex)
  {
    Object obj = m_infosDalCALI.getElement(pIndex);
    ExceptionUtil.assertInstanceOf("element", obj, _InfosDalCALI.class);
    return (_InfosDalCALI)obj;
  }
  
  public void addListeInfosDALCALI(_InfosDalCALI pElement)
  {
    ExceptionUtil.assertMethodParamNotNull("element", pElement);
    m_infosDalCALI.addElement(pElement);
  }
  
  public void removeInfosDalCALI(int pIndex)
  {
    m_infosDalCALI.removeElement(pIndex);
  }
  
  public void removeInfosDalCALI(_InfosDalCALI pElement)
  {
    m_infosDalCALI.removeElement(pElement);
  }
  
  public void setListeInfosDALCALI(_InfosDalCALI[] pIn)
  {
    _setArrayToList(pIn, m_infosDalCALI);
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
    if ("InfosDalCALI".equals(pElementName)) {
      resultat = new PropertyInfo(pElementName, true, false, _InfosDalCALI.class, false);
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
    if ("InfosDalCALI".equals(pName)) {
      resultat = m_infosDalCALI;
    }
    return resultat;
  }
  
  public Iterator _getPropertyNames()
    throws Exception
  {
    ArrayList liste = new ArrayList();
    
    liste.add("InfosDalCALI");
    
    return liste.iterator();
  }
  
  public ArrayList _getPropertyNames(ArrayList pListe)
    throws Exception
  {
    pListe.add("InfosDalCALI");
    
    return pListe;
  }
  
  public void _setProperty(String pName, Object pValeur)
    throws Exception
  {
    if ("InfosDalCALI".equals(pName))
    {
      ExceptionUtil.assertMethodParamNotNull("pValeur", pValeur, _InfosDalCALI.class);
      if (m_infosDalCALI != null)
      {
        m_infosDalCALI.addElement(pValeur);
      }
      else
      {
        m_infosDalCALI = _getInstanceListe();
        m_infosDalCALI.addElement(pValeur);
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
    if (!(pObjet instanceof _RetourLireDALCALI_listeInfosDALCALI)) {
      return false;
    }
    _RetourLireDALCALI_listeInfosDALCALI x = (_RetourLireDALCALI_listeInfosDALCALI)pObjet;
    if ((m_infosDalCALI == null) && (m_infosDalCALI == null)) {
      return true;
    }
    if ((m_infosDalCALI != null) && (m_infosDalCALI == null)) {
      return false;
    }
    if ((m_infosDalCALI == null) && (m_infosDalCALI != null)) {
      return false;
    }
    if (getListeInfosDALCALI().length != x.getListeInfosDALCALI().length) {
      return false;
    }
    for (int i = 0; i < getListeInfosDALCALI().length; i++) {
      if ((getListeInfosDALCALI()[i] != null) && 
        (!getListeInfosDALCALI()[i].equals(x.getListeInfosDALCALI()[i]))) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int resultat = 0;
    if (m_infosDalCALI != null) {
      for (int i = 0; i < getListeInfosDALCALI().length; i++) {
        if (getListeInfosDALCALI()[i] != null) {
          resultat += getListeInfosDALCALI()[i].hashCode();
        }
      }
    }
    return resultat;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    _RetourLireDALCALI_listeInfosDALCALI clone_RetourLireDALCALI_listeInfosDALCALI = new _RetourLireDALCALI_listeInfosDALCALI();
    
    clone_RetourLireDALCALI_listeInfosDALCALI.populateFrom_RetourLireDALCALI_listeInfosDALCALI(this);
    
    return clone_RetourLireDALCALI_listeInfosDALCALI;
  }
  
  public void populateFrom_RetourLireDALCALI_listeInfosDALCALI(_RetourLireDALCALI_listeInfosDALCALI pSource)
  {
    setListeInfosDALCALI(pSource.getListeInfosDALCALI());
  }
  
  public String toString()
  {
    StringBuffer s = new StringBuffer("[_RetourLireDALCALI_listeInfosDALCALI");
    
    subToString(s);
    
    s.append("]");
    
    return s.toString();
  }
  
  protected void subToString(StringBuffer pSource)
  {
    pSource.append(", InfosDalCALI: ");
    if (m_infosDalCALI == null)
    {
      pSource.append("null");
    }
    else
    {
      pSource.append("{");
      for (int i = 0; i < getListeInfosDALCALI().length; i++)
      {
        if (i > 0) {
          pSource.append(", ");
        }
        pSource.append(getListeInfosDALCALI()[i]);
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
    DataBean[] InfosDalCALI_Value = getListeInfosDALCALI();
    GettersHandler[] InfosDalCALI_GettersHandler = pHandler.property("InfosDalCALI", InfosDalCALI_Value, null);
    if ((InfosDalCALI_GettersHandler != null) && (InfosDalCALI_Value != null)) {
      for (int i = 0; i < InfosDalCALI_GettersHandler.length; i++) {
        if ((InfosDalCALI_GettersHandler[i] != null) && (InfosDalCALI_Value[i] != null)) {
          InfosDalCALI_Value[i].goThrough(InfosDalCALI_GettersHandler[i]);
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
    
    DataBean[] InfosDalCALI_dbs = pHandler.databeanArrayProperty("InfosDalCALI", _InfosDalCALI.class);
    if (InfosDalCALI_dbs == null)
    {
      setListeInfosDALCALI(null);
    }
    else
    {
      _InfosDalCALI[] InfosDalCALI_array = new _InfosDalCALI[InfosDalCALI_dbs.length];
      for (int i = 0; i < InfosDalCALI_dbs.length; i++) {
        InfosDalCALI_array[i] = ((_InfosDalCALI)InfosDalCALI_dbs[i]);
      }
      setListeInfosDALCALI(InfosDalCALI_array);
    }
  }
  
  public String _getDatabeanName()
  {
    return "RetourLireDALCALI_listeInfosDALCALI";
  }
  
  public boolean _isValidProperty(String pElementName)
  {
    if ("InfosDalCALI".equals(pElementName)) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _RetourLireDALCALI_listeInfosDALCALI
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */