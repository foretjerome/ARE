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

public class _ListeFluxPasDnaQuantiteTravail
  extends DataBeanImpl
  implements DataBean, Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  private DataList m_fluxPasDnaQuantiteTravail = _getInstanceListe();
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
  
  public _FluxPasDnaQuantiteTravail[] getListeFluxPasDnaQuantiteTravail()
  {
    Object[] objTab = _getArrayFromList(m_fluxPasDnaQuantiteTravail, _FluxPasDnaQuantiteTravail.class);
    int length = objTab.length;
    _FluxPasDnaQuantiteTravail[] tab = new _FluxPasDnaQuantiteTravail[length];
    for (int i = 0; i < length; i++) {
      tab[i] = ((_FluxPasDnaQuantiteTravail)objTab[i]);
    }
    return tab;
  }
  
  public DataList getInternalListeFluxPasDnaQuantiteTravail()
  {
    return m_fluxPasDnaQuantiteTravail;
  }
  
  public int getNbListeFluxPasDnaQuantiteTravail()
  {
    return m_fluxPasDnaQuantiteTravail.getNbElement();
  }
  
  public _FluxPasDnaQuantiteTravail getListeFluxPasDnaQuantiteTravail(int pIndex)
  {
    Object obj = m_fluxPasDnaQuantiteTravail.getElement(pIndex);
    ExceptionUtil.assertInstanceOf("element", obj, _FluxPasDnaQuantiteTravail.class);
    return (_FluxPasDnaQuantiteTravail)obj;
  }
  
  public void addListeFluxPasDnaQuantiteTravail(_FluxPasDnaQuantiteTravail pElement)
  {
    ExceptionUtil.assertMethodParamNotNull("element", pElement);
    m_fluxPasDnaQuantiteTravail.addElement(pElement);
  }
  
  public void removeFluxPasDnaQuantiteTravail(int pIndex)
  {
    m_fluxPasDnaQuantiteTravail.removeElement(pIndex);
  }
  
  public void removeFluxPasDnaQuantiteTravail(_FluxPasDnaQuantiteTravail pElement)
  {
    m_fluxPasDnaQuantiteTravail.removeElement(pElement);
  }
  
  public void setListeFluxPasDnaQuantiteTravail(_FluxPasDnaQuantiteTravail[] pIn)
  {
    _setArrayToList(pIn, m_fluxPasDnaQuantiteTravail);
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
    if ("FluxPasDnaQuantiteTravail".equals(pElementName)) {
      resultat = new PropertyInfo(pElementName, true, false, _FluxPasDnaQuantiteTravail.class, false);
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
    if ("FluxPasDnaQuantiteTravail".equals(pName)) {
      resultat = m_fluxPasDnaQuantiteTravail;
    }
    return resultat;
  }
  
  public Iterator _getPropertyNames()
    throws Exception
  {
    ArrayList liste = new ArrayList();
    
    liste.add("FluxPasDnaQuantiteTravail");
    
    return liste.iterator();
  }
  
  public ArrayList _getPropertyNames(ArrayList pListe)
    throws Exception
  {
    pListe.add("FluxPasDnaQuantiteTravail");
    
    return pListe;
  }
  
  public void _setProperty(String pName, Object pValeur)
    throws Exception
  {
    if ("FluxPasDnaQuantiteTravail".equals(pName))
    {
      ExceptionUtil.assertMethodParamNotNull("pValeur", pValeur, _FluxPasDnaQuantiteTravail.class);
      if (m_fluxPasDnaQuantiteTravail != null)
      {
        m_fluxPasDnaQuantiteTravail.addElement(pValeur);
      }
      else
      {
        m_fluxPasDnaQuantiteTravail = _getInstanceListe();
        m_fluxPasDnaQuantiteTravail.addElement(pValeur);
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
    if (!(pObjet instanceof _ListeFluxPasDnaQuantiteTravail)) {
      return false;
    }
    _ListeFluxPasDnaQuantiteTravail x = (_ListeFluxPasDnaQuantiteTravail)pObjet;
    if ((m_fluxPasDnaQuantiteTravail == null) && (m_fluxPasDnaQuantiteTravail == null)) {
      return true;
    }
    if ((m_fluxPasDnaQuantiteTravail != null) && (m_fluxPasDnaQuantiteTravail == null)) {
      return false;
    }
    if ((m_fluxPasDnaQuantiteTravail == null) && (m_fluxPasDnaQuantiteTravail != null)) {
      return false;
    }
    if (getListeFluxPasDnaQuantiteTravail().length != x.getListeFluxPasDnaQuantiteTravail().length) {
      return false;
    }
    for (int i = 0; i < getListeFluxPasDnaQuantiteTravail().length; i++) {
      if ((getListeFluxPasDnaQuantiteTravail()[i] != null) && 
        (!getListeFluxPasDnaQuantiteTravail()[i].equals(x.getListeFluxPasDnaQuantiteTravail()[i]))) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int resultat = 0;
    if (m_fluxPasDnaQuantiteTravail != null) {
      for (int i = 0; i < getListeFluxPasDnaQuantiteTravail().length; i++) {
        if (getListeFluxPasDnaQuantiteTravail()[i] != null) {
          resultat += getListeFluxPasDnaQuantiteTravail()[i].hashCode();
        }
      }
    }
    return resultat;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    _ListeFluxPasDnaQuantiteTravail clone_ListeFluxPasDnaQuantiteTravail = new _ListeFluxPasDnaQuantiteTravail();
    
    clone_ListeFluxPasDnaQuantiteTravail.populateFrom_ListeFluxPasDnaQuantiteTravail(this);
    
    return clone_ListeFluxPasDnaQuantiteTravail;
  }
  
  public void populateFrom_ListeFluxPasDnaQuantiteTravail(_ListeFluxPasDnaQuantiteTravail pSource)
  {
    setListeFluxPasDnaQuantiteTravail(pSource.getListeFluxPasDnaQuantiteTravail());
  }
  
  public String toString()
  {
    StringBuffer s = new StringBuffer("[_ListeFluxPasDnaQuantiteTravail");
    
    subToString(s);
    
    s.append("]");
    
    return s.toString();
  }
  
  protected void subToString(StringBuffer pSource)
  {
    pSource.append(", FluxPasDnaQuantiteTravail: ");
    if (m_fluxPasDnaQuantiteTravail == null)
    {
      pSource.append("null");
    }
    else
    {
      pSource.append("{");
      for (int i = 0; i < getListeFluxPasDnaQuantiteTravail().length; i++)
      {
        if (i > 0) {
          pSource.append(", ");
        }
        pSource.append(getListeFluxPasDnaQuantiteTravail()[i]);
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
    DataBean[] FluxPasDnaQuantiteTravail_Value = getListeFluxPasDnaQuantiteTravail();
    GettersHandler[] FluxPasDnaQuantiteTravail_GettersHandler = pHandler.property("FluxPasDnaQuantiteTravail", FluxPasDnaQuantiteTravail_Value, null);
    if ((FluxPasDnaQuantiteTravail_GettersHandler != null) && (FluxPasDnaQuantiteTravail_Value != null)) {
      for (int i = 0; i < FluxPasDnaQuantiteTravail_GettersHandler.length; i++) {
        if ((FluxPasDnaQuantiteTravail_GettersHandler[i] != null) && (FluxPasDnaQuantiteTravail_Value[i] != null)) {
          FluxPasDnaQuantiteTravail_Value[i].goThrough(FluxPasDnaQuantiteTravail_GettersHandler[i]);
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
    
    DataBean[] FluxPasDnaQuantiteTravail_dbs = pHandler.databeanArrayProperty("FluxPasDnaQuantiteTravail", _FluxPasDnaQuantiteTravail.class);
    if (FluxPasDnaQuantiteTravail_dbs == null)
    {
      setListeFluxPasDnaQuantiteTravail(null);
    }
    else
    {
      _FluxPasDnaQuantiteTravail[] FluxPasDnaQuantiteTravail_array = new _FluxPasDnaQuantiteTravail[FluxPasDnaQuantiteTravail_dbs.length];
      for (int i = 0; i < FluxPasDnaQuantiteTravail_dbs.length; i++) {
        FluxPasDnaQuantiteTravail_array[i] = ((_FluxPasDnaQuantiteTravail)FluxPasDnaQuantiteTravail_dbs[i]);
      }
      setListeFluxPasDnaQuantiteTravail(FluxPasDnaQuantiteTravail_array);
    }
  }
  
  public String _getDatabeanName()
  {
    return "ListeFluxPasDnaQuantiteTravail";
  }
  
  public boolean _isValidProperty(String pElementName)
  {
    if ("FluxPasDnaQuantiteTravail".equals(pElementName)) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _ListeFluxPasDnaQuantiteTravail
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */