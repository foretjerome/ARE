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

public class _ListeFluxFctDnaPreavis
  extends DataBeanImpl
  implements DataBean, Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  private DataList m_fluxFctDnaPreavis = _getInstanceListe();
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
  
  public _FluxFctDnaPreavis[] getListeFluxFctDnaPreavis()
  {
    Object[] objTab = _getArrayFromList(m_fluxFctDnaPreavis, _FluxFctDnaPreavis.class);
    int length = objTab.length;
    _FluxFctDnaPreavis[] tab = new _FluxFctDnaPreavis[length];
    for (int i = 0; i < length; i++) {
      tab[i] = ((_FluxFctDnaPreavis)objTab[i]);
    }
    return tab;
  }
  
  public DataList getInternalListeFluxFctDnaPreavis()
  {
    return m_fluxFctDnaPreavis;
  }
  
  public int getNbListeFluxFctDnaPreavis()
  {
    return m_fluxFctDnaPreavis.getNbElement();
  }
  
  public _FluxFctDnaPreavis getListeFluxFctDnaPreavis(int pIndex)
  {
    Object obj = m_fluxFctDnaPreavis.getElement(pIndex);
    ExceptionUtil.assertInstanceOf("element", obj, _FluxFctDnaPreavis.class);
    return (_FluxFctDnaPreavis)obj;
  }
  
  public void addListeFluxFctDnaPreavis(_FluxFctDnaPreavis pElement)
  {
    ExceptionUtil.assertMethodParamNotNull("element", pElement);
    m_fluxFctDnaPreavis.addElement(pElement);
  }
  
  public void removeFluxFctDnaPreavis(int pIndex)
  {
    m_fluxFctDnaPreavis.removeElement(pIndex);
  }
  
  public void removeFluxFctDnaPreavis(_FluxFctDnaPreavis pElement)
  {
    m_fluxFctDnaPreavis.removeElement(pElement);
  }
  
  public void setListeFluxFctDnaPreavis(_FluxFctDnaPreavis[] pIn)
  {
    _setArrayToList(pIn, m_fluxFctDnaPreavis);
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
    if ("FluxFctDnaPreavis".equals(pElementName)) {
      resultat = new PropertyInfo(pElementName, true, false, _FluxFctDnaPreavis.class, false);
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
    if ("FluxFctDnaPreavis".equals(pName)) {
      resultat = m_fluxFctDnaPreavis;
    }
    return resultat;
  }
  
  public Iterator _getPropertyNames()
    throws Exception
  {
    ArrayList liste = new ArrayList();
    
    liste.add("FluxFctDnaPreavis");
    
    return liste.iterator();
  }
  
  public ArrayList _getPropertyNames(ArrayList pListe)
    throws Exception
  {
    pListe.add("FluxFctDnaPreavis");
    
    return pListe;
  }
  
  public void _setProperty(String pName, Object pValeur)
    throws Exception
  {
    if ("FluxFctDnaPreavis".equals(pName))
    {
      ExceptionUtil.assertMethodParamNotNull("pValeur", pValeur, _FluxFctDnaPreavis.class);
      if (m_fluxFctDnaPreavis != null)
      {
        m_fluxFctDnaPreavis.addElement(pValeur);
      }
      else
      {
        m_fluxFctDnaPreavis = _getInstanceListe();
        m_fluxFctDnaPreavis.addElement(pValeur);
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
    if (!(pObjet instanceof _ListeFluxFctDnaPreavis)) {
      return false;
    }
    _ListeFluxFctDnaPreavis x = (_ListeFluxFctDnaPreavis)pObjet;
    if ((m_fluxFctDnaPreavis == null) && (m_fluxFctDnaPreavis == null)) {
      return true;
    }
    if ((m_fluxFctDnaPreavis != null) && (m_fluxFctDnaPreavis == null)) {
      return false;
    }
    if ((m_fluxFctDnaPreavis == null) && (m_fluxFctDnaPreavis != null)) {
      return false;
    }
    if (getListeFluxFctDnaPreavis().length != x.getListeFluxFctDnaPreavis().length) {
      return false;
    }
    for (int i = 0; i < getListeFluxFctDnaPreavis().length; i++) {
      if ((getListeFluxFctDnaPreavis()[i] != null) && 
        (!getListeFluxFctDnaPreavis()[i].equals(x.getListeFluxFctDnaPreavis()[i]))) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int resultat = 0;
    if (m_fluxFctDnaPreavis != null) {
      for (int i = 0; i < getListeFluxFctDnaPreavis().length; i++) {
        if (getListeFluxFctDnaPreavis()[i] != null) {
          resultat += getListeFluxFctDnaPreavis()[i].hashCode();
        }
      }
    }
    return resultat;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    _ListeFluxFctDnaPreavis clone_ListeFluxFctDnaPreavis = new _ListeFluxFctDnaPreavis();
    
    clone_ListeFluxFctDnaPreavis.populateFrom_ListeFluxFctDnaPreavis(this);
    
    return clone_ListeFluxFctDnaPreavis;
  }
  
  public void populateFrom_ListeFluxFctDnaPreavis(_ListeFluxFctDnaPreavis pSource)
  {
    setListeFluxFctDnaPreavis(pSource.getListeFluxFctDnaPreavis());
  }
  
  public String toString()
  {
    StringBuffer s = new StringBuffer("[_ListeFluxFctDnaPreavis");
    
    subToString(s);
    
    s.append("]");
    
    return s.toString();
  }
  
  protected void subToString(StringBuffer pSource)
  {
    pSource.append(", FluxFctDnaPreavis: ");
    if (m_fluxFctDnaPreavis == null)
    {
      pSource.append("null");
    }
    else
    {
      pSource.append("{");
      for (int i = 0; i < getListeFluxFctDnaPreavis().length; i++)
      {
        if (i > 0) {
          pSource.append(", ");
        }
        pSource.append(getListeFluxFctDnaPreavis()[i]);
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
    DataBean[] FluxFctDnaPreavis_Value = getListeFluxFctDnaPreavis();
    GettersHandler[] FluxFctDnaPreavis_GettersHandler = pHandler.property("FluxFctDnaPreavis", FluxFctDnaPreavis_Value, null);
    if ((FluxFctDnaPreavis_GettersHandler != null) && (FluxFctDnaPreavis_Value != null)) {
      for (int i = 0; i < FluxFctDnaPreavis_GettersHandler.length; i++) {
        if ((FluxFctDnaPreavis_GettersHandler[i] != null) && (FluxFctDnaPreavis_Value[i] != null)) {
          FluxFctDnaPreavis_Value[i].goThrough(FluxFctDnaPreavis_GettersHandler[i]);
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
    
    DataBean[] FluxFctDnaPreavis_dbs = pHandler.databeanArrayProperty("FluxFctDnaPreavis", _FluxFctDnaPreavis.class);
    if (FluxFctDnaPreavis_dbs == null)
    {
      setListeFluxFctDnaPreavis(null);
    }
    else
    {
      _FluxFctDnaPreavis[] FluxFctDnaPreavis_array = new _FluxFctDnaPreavis[FluxFctDnaPreavis_dbs.length];
      for (int i = 0; i < FluxFctDnaPreavis_dbs.length; i++) {
        FluxFctDnaPreavis_array[i] = ((_FluxFctDnaPreavis)FluxFctDnaPreavis_dbs[i]);
      }
      setListeFluxFctDnaPreavis(FluxFctDnaPreavis_array);
    }
  }
  
  public String _getDatabeanName()
  {
    return "ListeFluxFctDnaPreavis";
  }
  
  public boolean _isValidProperty(String pElementName)
  {
    if ("FluxFctDnaPreavis".equals(pElementName)) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _ListeFluxFctDnaPreavis
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */