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

public class _ListeFluxQuantiteTravailDsn
  extends DataBeanImpl
  implements DataBean, Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  private DataList m_fluxQuantiteTravailDsn = _getInstanceListe();
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
  
  public _FluxQuantiteTravailDsn[] getListeFluxQuantiteTravailDsn()
  {
    Object[] objTab = _getArrayFromList(m_fluxQuantiteTravailDsn, _FluxQuantiteTravailDsn.class);
    int length = objTab.length;
    _FluxQuantiteTravailDsn[] tab = new _FluxQuantiteTravailDsn[length];
    for (int i = 0; i < length; i++) {
      tab[i] = ((_FluxQuantiteTravailDsn)objTab[i]);
    }
    return tab;
  }
  
  public DataList getInternalListeFluxQuantiteTravailDsn()
  {
    return m_fluxQuantiteTravailDsn;
  }
  
  public int getNbListeFluxQuantiteTravailDsn()
  {
    return m_fluxQuantiteTravailDsn.getNbElement();
  }
  
  public _FluxQuantiteTravailDsn getListeFluxQuantiteTravailDsn(int pIndex)
  {
    Object obj = m_fluxQuantiteTravailDsn.getElement(pIndex);
    ExceptionUtil.assertInstanceOf("element", obj, _FluxQuantiteTravailDsn.class);
    return (_FluxQuantiteTravailDsn)obj;
  }
  
  public void addListeFluxQuantiteTravailDsn(_FluxQuantiteTravailDsn pElement)
  {
    ExceptionUtil.assertMethodParamNotNull("element", pElement);
    m_fluxQuantiteTravailDsn.addElement(pElement);
  }
  
  public void removeFluxQuantiteTravailDsn(int pIndex)
  {
    m_fluxQuantiteTravailDsn.removeElement(pIndex);
  }
  
  public void removeFluxQuantiteTravailDsn(_FluxQuantiteTravailDsn pElement)
  {
    m_fluxQuantiteTravailDsn.removeElement(pElement);
  }
  
  public void setListeFluxQuantiteTravailDsn(_FluxQuantiteTravailDsn[] pIn)
  {
    _setArrayToList(pIn, m_fluxQuantiteTravailDsn);
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
    if ("FluxQuantiteTravailDsn".equals(pElementName)) {
      resultat = new PropertyInfo(pElementName, true, false, _FluxQuantiteTravailDsn.class, false);
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
    if ("FluxQuantiteTravailDsn".equals(pName)) {
      resultat = m_fluxQuantiteTravailDsn;
    }
    return resultat;
  }
  
  public Iterator _getPropertyNames()
    throws Exception
  {
    ArrayList liste = new ArrayList();
    
    liste.add("FluxQuantiteTravailDsn");
    
    return liste.iterator();
  }
  
  public ArrayList _getPropertyNames(ArrayList pListe)
    throws Exception
  {
    pListe.add("FluxQuantiteTravailDsn");
    
    return pListe;
  }
  
  public void _setProperty(String pName, Object pValeur)
    throws Exception
  {
    if ("FluxQuantiteTravailDsn".equals(pName))
    {
      ExceptionUtil.assertMethodParamNotNull("pValeur", pValeur, _FluxQuantiteTravailDsn.class);
      if (m_fluxQuantiteTravailDsn != null)
      {
        m_fluxQuantiteTravailDsn.addElement(pValeur);
      }
      else
      {
        m_fluxQuantiteTravailDsn = _getInstanceListe();
        m_fluxQuantiteTravailDsn.addElement(pValeur);
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
    if (!(pObjet instanceof _ListeFluxQuantiteTravailDsn)) {
      return false;
    }
    _ListeFluxQuantiteTravailDsn x = (_ListeFluxQuantiteTravailDsn)pObjet;
    if ((m_fluxQuantiteTravailDsn == null) && (m_fluxQuantiteTravailDsn == null)) {
      return true;
    }
    if ((m_fluxQuantiteTravailDsn != null) && (m_fluxQuantiteTravailDsn == null)) {
      return false;
    }
    if ((m_fluxQuantiteTravailDsn == null) && (m_fluxQuantiteTravailDsn != null)) {
      return false;
    }
    if (getListeFluxQuantiteTravailDsn().length != x.getListeFluxQuantiteTravailDsn().length) {
      return false;
    }
    for (int i = 0; i < getListeFluxQuantiteTravailDsn().length; i++) {
      if ((getListeFluxQuantiteTravailDsn()[i] != null) && 
        (!getListeFluxQuantiteTravailDsn()[i].equals(x.getListeFluxQuantiteTravailDsn()[i]))) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int resultat = 0;
    if (m_fluxQuantiteTravailDsn != null) {
      for (int i = 0; i < getListeFluxQuantiteTravailDsn().length; i++) {
        if (getListeFluxQuantiteTravailDsn()[i] != null) {
          resultat += getListeFluxQuantiteTravailDsn()[i].hashCode();
        }
      }
    }
    return resultat;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    _ListeFluxQuantiteTravailDsn clone_ListeFluxQuantiteTravailDsn = new _ListeFluxQuantiteTravailDsn();
    
    clone_ListeFluxQuantiteTravailDsn.populateFrom_ListeFluxQuantiteTravailDsn(this);
    
    return clone_ListeFluxQuantiteTravailDsn;
  }
  
  public void populateFrom_ListeFluxQuantiteTravailDsn(_ListeFluxQuantiteTravailDsn pSource)
  {
    setListeFluxQuantiteTravailDsn(pSource.getListeFluxQuantiteTravailDsn());
  }
  
  public String toString()
  {
    StringBuffer s = new StringBuffer("[_ListeFluxQuantiteTravailDsn");
    
    subToString(s);
    
    s.append("]");
    
    return s.toString();
  }
  
  protected void subToString(StringBuffer pSource)
  {
    pSource.append(", FluxQuantiteTravailDsn: ");
    if (m_fluxQuantiteTravailDsn == null)
    {
      pSource.append("null");
    }
    else
    {
      pSource.append("{");
      for (int i = 0; i < getListeFluxQuantiteTravailDsn().length; i++)
      {
        if (i > 0) {
          pSource.append(", ");
        }
        pSource.append(getListeFluxQuantiteTravailDsn()[i]);
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
    DataBean[] FluxQuantiteTravailDsn_Value = getListeFluxQuantiteTravailDsn();
    GettersHandler[] FluxQuantiteTravailDsn_GettersHandler = pHandler.property("FluxQuantiteTravailDsn", FluxQuantiteTravailDsn_Value, null);
    if ((FluxQuantiteTravailDsn_GettersHandler != null) && (FluxQuantiteTravailDsn_Value != null)) {
      for (int i = 0; i < FluxQuantiteTravailDsn_GettersHandler.length; i++) {
        if ((FluxQuantiteTravailDsn_GettersHandler[i] != null) && (FluxQuantiteTravailDsn_Value[i] != null)) {
          FluxQuantiteTravailDsn_Value[i].goThrough(FluxQuantiteTravailDsn_GettersHandler[i]);
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
    
    DataBean[] FluxQuantiteTravailDsn_dbs = pHandler.databeanArrayProperty("FluxQuantiteTravailDsn", _FluxQuantiteTravailDsn.class);
    if (FluxQuantiteTravailDsn_dbs == null)
    {
      setListeFluxQuantiteTravailDsn(null);
    }
    else
    {
      _FluxQuantiteTravailDsn[] FluxQuantiteTravailDsn_array = new _FluxQuantiteTravailDsn[FluxQuantiteTravailDsn_dbs.length];
      for (int i = 0; i < FluxQuantiteTravailDsn_dbs.length; i++) {
        FluxQuantiteTravailDsn_array[i] = ((_FluxQuantiteTravailDsn)FluxQuantiteTravailDsn_dbs[i]);
      }
      setListeFluxQuantiteTravailDsn(FluxQuantiteTravailDsn_array);
    }
  }
  
  public String _getDatabeanName()
  {
    return "ListeFluxQuantiteTravailDsn";
  }
  
  public boolean _isValidProperty(String pElementName)
  {
    if ("FluxQuantiteTravailDsn".equals(pElementName)) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _ListeFluxQuantiteTravailDsn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */