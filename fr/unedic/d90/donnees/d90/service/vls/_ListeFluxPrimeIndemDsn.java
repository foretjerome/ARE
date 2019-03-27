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

public class _ListeFluxPrimeIndemDsn
  extends DataBeanImpl
  implements DataBean, Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  private DataList m_fluxPrimeIndemDsn = _getInstanceListe();
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
  
  public _FluxPrimeIndemDsn[] getListeFluxPrimeIndemDsn()
  {
    Object[] objTab = _getArrayFromList(m_fluxPrimeIndemDsn, _FluxPrimeIndemDsn.class);
    int length = objTab.length;
    _FluxPrimeIndemDsn[] tab = new _FluxPrimeIndemDsn[length];
    for (int i = 0; i < length; i++) {
      tab[i] = ((_FluxPrimeIndemDsn)objTab[i]);
    }
    return tab;
  }
  
  public DataList getInternalListeFluxPrimeIndemDsn()
  {
    return m_fluxPrimeIndemDsn;
  }
  
  public int getNbListeFluxPrimeIndemDsn()
  {
    return m_fluxPrimeIndemDsn.getNbElement();
  }
  
  public _FluxPrimeIndemDsn getListeFluxPrimeIndemDsn(int pIndex)
  {
    Object obj = m_fluxPrimeIndemDsn.getElement(pIndex);
    ExceptionUtil.assertInstanceOf("element", obj, _FluxPrimeIndemDsn.class);
    return (_FluxPrimeIndemDsn)obj;
  }
  
  public void addListeFluxPrimeIndemDsn(_FluxPrimeIndemDsn pElement)
  {
    ExceptionUtil.assertMethodParamNotNull("element", pElement);
    m_fluxPrimeIndemDsn.addElement(pElement);
  }
  
  public void removeFluxPrimeIndemDsn(int pIndex)
  {
    m_fluxPrimeIndemDsn.removeElement(pIndex);
  }
  
  public void removeFluxPrimeIndemDsn(_FluxPrimeIndemDsn pElement)
  {
    m_fluxPrimeIndemDsn.removeElement(pElement);
  }
  
  public void setListeFluxPrimeIndemDsn(_FluxPrimeIndemDsn[] pIn)
  {
    _setArrayToList(pIn, m_fluxPrimeIndemDsn);
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
    if ("FluxPrimeIndemDsn".equals(pElementName)) {
      resultat = new PropertyInfo(pElementName, true, false, _FluxPrimeIndemDsn.class, false);
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
    if ("FluxPrimeIndemDsn".equals(pName)) {
      resultat = m_fluxPrimeIndemDsn;
    }
    return resultat;
  }
  
  public Iterator _getPropertyNames()
    throws Exception
  {
    ArrayList liste = new ArrayList();
    
    liste.add("FluxPrimeIndemDsn");
    
    return liste.iterator();
  }
  
  public ArrayList _getPropertyNames(ArrayList pListe)
    throws Exception
  {
    pListe.add("FluxPrimeIndemDsn");
    
    return pListe;
  }
  
  public void _setProperty(String pName, Object pValeur)
    throws Exception
  {
    if ("FluxPrimeIndemDsn".equals(pName))
    {
      ExceptionUtil.assertMethodParamNotNull("pValeur", pValeur, _FluxPrimeIndemDsn.class);
      if (m_fluxPrimeIndemDsn != null)
      {
        m_fluxPrimeIndemDsn.addElement(pValeur);
      }
      else
      {
        m_fluxPrimeIndemDsn = _getInstanceListe();
        m_fluxPrimeIndemDsn.addElement(pValeur);
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
    if (!(pObjet instanceof _ListeFluxPrimeIndemDsn)) {
      return false;
    }
    _ListeFluxPrimeIndemDsn x = (_ListeFluxPrimeIndemDsn)pObjet;
    if ((m_fluxPrimeIndemDsn == null) && (m_fluxPrimeIndemDsn == null)) {
      return true;
    }
    if ((m_fluxPrimeIndemDsn != null) && (m_fluxPrimeIndemDsn == null)) {
      return false;
    }
    if ((m_fluxPrimeIndemDsn == null) && (m_fluxPrimeIndemDsn != null)) {
      return false;
    }
    if (getListeFluxPrimeIndemDsn().length != x.getListeFluxPrimeIndemDsn().length) {
      return false;
    }
    for (int i = 0; i < getListeFluxPrimeIndemDsn().length; i++) {
      if ((getListeFluxPrimeIndemDsn()[i] != null) && 
        (!getListeFluxPrimeIndemDsn()[i].equals(x.getListeFluxPrimeIndemDsn()[i]))) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int resultat = 0;
    if (m_fluxPrimeIndemDsn != null) {
      for (int i = 0; i < getListeFluxPrimeIndemDsn().length; i++) {
        if (getListeFluxPrimeIndemDsn()[i] != null) {
          resultat += getListeFluxPrimeIndemDsn()[i].hashCode();
        }
      }
    }
    return resultat;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    _ListeFluxPrimeIndemDsn clone_ListeFluxPrimeIndemDsn = new _ListeFluxPrimeIndemDsn();
    
    clone_ListeFluxPrimeIndemDsn.populateFrom_ListeFluxPrimeIndemDsn(this);
    
    return clone_ListeFluxPrimeIndemDsn;
  }
  
  public void populateFrom_ListeFluxPrimeIndemDsn(_ListeFluxPrimeIndemDsn pSource)
  {
    setListeFluxPrimeIndemDsn(pSource.getListeFluxPrimeIndemDsn());
  }
  
  public String toString()
  {
    StringBuffer s = new StringBuffer("[_ListeFluxPrimeIndemDsn");
    
    subToString(s);
    
    s.append("]");
    
    return s.toString();
  }
  
  protected void subToString(StringBuffer pSource)
  {
    pSource.append(", FluxPrimeIndemDsn: ");
    if (m_fluxPrimeIndemDsn == null)
    {
      pSource.append("null");
    }
    else
    {
      pSource.append("{");
      for (int i = 0; i < getListeFluxPrimeIndemDsn().length; i++)
      {
        if (i > 0) {
          pSource.append(", ");
        }
        pSource.append(getListeFluxPrimeIndemDsn()[i]);
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
    DataBean[] FluxPrimeIndemDsn_Value = getListeFluxPrimeIndemDsn();
    GettersHandler[] FluxPrimeIndemDsn_GettersHandler = pHandler.property("FluxPrimeIndemDsn", FluxPrimeIndemDsn_Value, null);
    if ((FluxPrimeIndemDsn_GettersHandler != null) && (FluxPrimeIndemDsn_Value != null)) {
      for (int i = 0; i < FluxPrimeIndemDsn_GettersHandler.length; i++) {
        if ((FluxPrimeIndemDsn_GettersHandler[i] != null) && (FluxPrimeIndemDsn_Value[i] != null)) {
          FluxPrimeIndemDsn_Value[i].goThrough(FluxPrimeIndemDsn_GettersHandler[i]);
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
    
    DataBean[] FluxPrimeIndemDsn_dbs = pHandler.databeanArrayProperty("FluxPrimeIndemDsn", _FluxPrimeIndemDsn.class);
    if (FluxPrimeIndemDsn_dbs == null)
    {
      setListeFluxPrimeIndemDsn(null);
    }
    else
    {
      _FluxPrimeIndemDsn[] FluxPrimeIndemDsn_array = new _FluxPrimeIndemDsn[FluxPrimeIndemDsn_dbs.length];
      for (int i = 0; i < FluxPrimeIndemDsn_dbs.length; i++) {
        FluxPrimeIndemDsn_array[i] = ((_FluxPrimeIndemDsn)FluxPrimeIndemDsn_dbs[i]);
      }
      setListeFluxPrimeIndemDsn(FluxPrimeIndemDsn_array);
    }
  }
  
  public String _getDatabeanName()
  {
    return "ListeFluxPrimeIndemDsn";
  }
  
  public boolean _isValidProperty(String pElementName)
  {
    if ("FluxPrimeIndemDsn".equals(pElementName)) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _ListeFluxPrimeIndemDsn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */