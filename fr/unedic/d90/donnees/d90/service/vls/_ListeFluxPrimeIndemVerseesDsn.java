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

public class _ListeFluxPrimeIndemVerseesDsn
  extends DataBeanImpl
  implements DataBean, Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  private DataList m_fluxPrimesIndemVerseesDsn = _getInstanceListe();
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
  
  public _FluxPrimesIndemVerseesDsn[] getListeFluxPrimeIndemVerseesDsn()
  {
    Object[] objTab = _getArrayFromList(m_fluxPrimesIndemVerseesDsn, _FluxPrimesIndemVerseesDsn.class);
    int length = objTab.length;
    _FluxPrimesIndemVerseesDsn[] tab = new _FluxPrimesIndemVerseesDsn[length];
    for (int i = 0; i < length; i++) {
      tab[i] = ((_FluxPrimesIndemVerseesDsn)objTab[i]);
    }
    return tab;
  }
  
  public DataList getInternalListeFluxPrimeIndemVerseesDsn()
  {
    return m_fluxPrimesIndemVerseesDsn;
  }
  
  public int getNbListeFluxPrimeIndemVerseesDsn()
  {
    return m_fluxPrimesIndemVerseesDsn.getNbElement();
  }
  
  public _FluxPrimesIndemVerseesDsn getListeFluxPrimeIndemVerseesDsn(int pIndex)
  {
    Object obj = m_fluxPrimesIndemVerseesDsn.getElement(pIndex);
    ExceptionUtil.assertInstanceOf("element", obj, _FluxPrimesIndemVerseesDsn.class);
    return (_FluxPrimesIndemVerseesDsn)obj;
  }
  
  public void addListeFluxPrimeIndemVerseesDsn(_FluxPrimesIndemVerseesDsn pElement)
  {
    ExceptionUtil.assertMethodParamNotNull("element", pElement);
    m_fluxPrimesIndemVerseesDsn.addElement(pElement);
  }
  
  public void removeFluxPrimesIndemVerseesDsn(int pIndex)
  {
    m_fluxPrimesIndemVerseesDsn.removeElement(pIndex);
  }
  
  public void removeFluxPrimesIndemVerseesDsn(_FluxPrimesIndemVerseesDsn pElement)
  {
    m_fluxPrimesIndemVerseesDsn.removeElement(pElement);
  }
  
  public void setListeFluxPrimeIndemVerseesDsn(_FluxPrimesIndemVerseesDsn[] pIn)
  {
    _setArrayToList(pIn, m_fluxPrimesIndemVerseesDsn);
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
    if ("FluxPrimesIndemVerseesDsn".equals(pElementName)) {
      resultat = new PropertyInfo(pElementName, true, false, _FluxPrimesIndemVerseesDsn.class, false);
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
    if ("FluxPrimesIndemVerseesDsn".equals(pName)) {
      resultat = m_fluxPrimesIndemVerseesDsn;
    }
    return resultat;
  }
  
  public Iterator _getPropertyNames()
    throws Exception
  {
    ArrayList liste = new ArrayList();
    
    liste.add("FluxPrimesIndemVerseesDsn");
    
    return liste.iterator();
  }
  
  public ArrayList _getPropertyNames(ArrayList pListe)
    throws Exception
  {
    pListe.add("FluxPrimesIndemVerseesDsn");
    
    return pListe;
  }
  
  public void _setProperty(String pName, Object pValeur)
    throws Exception
  {
    if ("FluxPrimesIndemVerseesDsn".equals(pName))
    {
      ExceptionUtil.assertMethodParamNotNull("pValeur", pValeur, _FluxPrimesIndemVerseesDsn.class);
      if (m_fluxPrimesIndemVerseesDsn != null)
      {
        m_fluxPrimesIndemVerseesDsn.addElement(pValeur);
      }
      else
      {
        m_fluxPrimesIndemVerseesDsn = _getInstanceListe();
        m_fluxPrimesIndemVerseesDsn.addElement(pValeur);
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
    if (!(pObjet instanceof _ListeFluxPrimeIndemVerseesDsn)) {
      return false;
    }
    _ListeFluxPrimeIndemVerseesDsn x = (_ListeFluxPrimeIndemVerseesDsn)pObjet;
    if ((m_fluxPrimesIndemVerseesDsn == null) && (m_fluxPrimesIndemVerseesDsn == null)) {
      return true;
    }
    if ((m_fluxPrimesIndemVerseesDsn != null) && (m_fluxPrimesIndemVerseesDsn == null)) {
      return false;
    }
    if ((m_fluxPrimesIndemVerseesDsn == null) && (m_fluxPrimesIndemVerseesDsn != null)) {
      return false;
    }
    if (getListeFluxPrimeIndemVerseesDsn().length != x.getListeFluxPrimeIndemVerseesDsn().length) {
      return false;
    }
    for (int i = 0; i < getListeFluxPrimeIndemVerseesDsn().length; i++) {
      if ((getListeFluxPrimeIndemVerseesDsn()[i] != null) && 
        (!getListeFluxPrimeIndemVerseesDsn()[i].equals(x.getListeFluxPrimeIndemVerseesDsn()[i]))) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int resultat = 0;
    if (m_fluxPrimesIndemVerseesDsn != null) {
      for (int i = 0; i < getListeFluxPrimeIndemVerseesDsn().length; i++) {
        if (getListeFluxPrimeIndemVerseesDsn()[i] != null) {
          resultat += getListeFluxPrimeIndemVerseesDsn()[i].hashCode();
        }
      }
    }
    return resultat;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    _ListeFluxPrimeIndemVerseesDsn clone_ListeFluxPrimeIndemVerseesDsn = new _ListeFluxPrimeIndemVerseesDsn();
    
    clone_ListeFluxPrimeIndemVerseesDsn.populateFrom_ListeFluxPrimeIndemVerseesDsn(this);
    
    return clone_ListeFluxPrimeIndemVerseesDsn;
  }
  
  public void populateFrom_ListeFluxPrimeIndemVerseesDsn(_ListeFluxPrimeIndemVerseesDsn pSource)
  {
    setListeFluxPrimeIndemVerseesDsn(pSource.getListeFluxPrimeIndemVerseesDsn());
  }
  
  public String toString()
  {
    StringBuffer s = new StringBuffer("[_ListeFluxPrimeIndemVerseesDsn");
    
    subToString(s);
    
    s.append("]");
    
    return s.toString();
  }
  
  protected void subToString(StringBuffer pSource)
  {
    pSource.append(", FluxPrimesIndemVerseesDsn: ");
    if (m_fluxPrimesIndemVerseesDsn == null)
    {
      pSource.append("null");
    }
    else
    {
      pSource.append("{");
      for (int i = 0; i < getListeFluxPrimeIndemVerseesDsn().length; i++)
      {
        if (i > 0) {
          pSource.append(", ");
        }
        pSource.append(getListeFluxPrimeIndemVerseesDsn()[i]);
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
    DataBean[] FluxPrimesIndemVerseesDsn_Value = getListeFluxPrimeIndemVerseesDsn();
    GettersHandler[] FluxPrimesIndemVerseesDsn_GettersHandler = pHandler.property("FluxPrimesIndemVerseesDsn", FluxPrimesIndemVerseesDsn_Value, null);
    if ((FluxPrimesIndemVerseesDsn_GettersHandler != null) && (FluxPrimesIndemVerseesDsn_Value != null)) {
      for (int i = 0; i < FluxPrimesIndemVerseesDsn_GettersHandler.length; i++) {
        if ((FluxPrimesIndemVerseesDsn_GettersHandler[i] != null) && (FluxPrimesIndemVerseesDsn_Value[i] != null)) {
          FluxPrimesIndemVerseesDsn_Value[i].goThrough(FluxPrimesIndemVerseesDsn_GettersHandler[i]);
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
    
    DataBean[] FluxPrimesIndemVerseesDsn_dbs = pHandler.databeanArrayProperty("FluxPrimesIndemVerseesDsn", _FluxPrimesIndemVerseesDsn.class);
    if (FluxPrimesIndemVerseesDsn_dbs == null)
    {
      setListeFluxPrimeIndemVerseesDsn(null);
    }
    else
    {
      _FluxPrimesIndemVerseesDsn[] FluxPrimesIndemVerseesDsn_array = new _FluxPrimesIndemVerseesDsn[FluxPrimesIndemVerseesDsn_dbs.length];
      for (int i = 0; i < FluxPrimesIndemVerseesDsn_dbs.length; i++) {
        FluxPrimesIndemVerseesDsn_array[i] = ((_FluxPrimesIndemVerseesDsn)FluxPrimesIndemVerseesDsn_dbs[i]);
      }
      setListeFluxPrimeIndemVerseesDsn(FluxPrimesIndemVerseesDsn_array);
    }
  }
  
  public String _getDatabeanName()
  {
    return "ListeFluxPrimeIndemVerseesDsn";
  }
  
  public boolean _isValidProperty(String pElementName)
  {
    if ("FluxPrimesIndemVerseesDsn".equals(pElementName)) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _ListeFluxPrimeIndemVerseesDsn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */