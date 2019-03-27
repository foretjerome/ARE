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

public class _ListeFluxPasDna
  extends DataBeanImpl
  implements DataBean, Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  private DataList m_fluxPasDna = _getInstanceListe();
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
  
  public _FluxPasDna[] getListeFluxPasDna()
  {
    Object[] objTab = _getArrayFromList(m_fluxPasDna, _FluxPasDna.class);
    int length = objTab.length;
    _FluxPasDna[] tab = new _FluxPasDna[length];
    for (int i = 0; i < length; i++) {
      tab[i] = ((_FluxPasDna)objTab[i]);
    }
    return tab;
  }
  
  public DataList getInternalListeFluxPasDna()
  {
    return m_fluxPasDna;
  }
  
  public int getNbListeFluxPasDna()
  {
    return m_fluxPasDna.getNbElement();
  }
  
  public _FluxPasDna getListeFluxPasDna(int pIndex)
  {
    Object obj = m_fluxPasDna.getElement(pIndex);
    ExceptionUtil.assertInstanceOf("element", obj, _FluxPasDna.class);
    return (_FluxPasDna)obj;
  }
  
  public void addListeFluxPasDna(_FluxPasDna pElement)
  {
    ExceptionUtil.assertMethodParamNotNull("element", pElement);
    m_fluxPasDna.addElement(pElement);
  }
  
  public void removeFluxPasDna(int pIndex)
  {
    m_fluxPasDna.removeElement(pIndex);
  }
  
  public void removeFluxPasDna(_FluxPasDna pElement)
  {
    m_fluxPasDna.removeElement(pElement);
  }
  
  public void setListeFluxPasDna(_FluxPasDna[] pIn)
  {
    _setArrayToList(pIn, m_fluxPasDna);
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
    if ("FluxPasDna".equals(pElementName)) {
      resultat = new PropertyInfo(pElementName, true, false, _FluxPasDna.class, false);
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
    if ("FluxPasDna".equals(pName)) {
      resultat = m_fluxPasDna;
    }
    return resultat;
  }
  
  public Iterator _getPropertyNames()
    throws Exception
  {
    ArrayList liste = new ArrayList();
    
    liste.add("FluxPasDna");
    
    return liste.iterator();
  }
  
  public ArrayList _getPropertyNames(ArrayList pListe)
    throws Exception
  {
    pListe.add("FluxPasDna");
    
    return pListe;
  }
  
  public void _setProperty(String pName, Object pValeur)
    throws Exception
  {
    if ("FluxPasDna".equals(pName))
    {
      ExceptionUtil.assertMethodParamNotNull("pValeur", pValeur, _FluxPasDna.class);
      if (m_fluxPasDna != null)
      {
        m_fluxPasDna.addElement(pValeur);
      }
      else
      {
        m_fluxPasDna = _getInstanceListe();
        m_fluxPasDna.addElement(pValeur);
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
    if (!(pObjet instanceof _ListeFluxPasDna)) {
      return false;
    }
    _ListeFluxPasDna x = (_ListeFluxPasDna)pObjet;
    if ((m_fluxPasDna == null) && (m_fluxPasDna == null)) {
      return true;
    }
    if ((m_fluxPasDna != null) && (m_fluxPasDna == null)) {
      return false;
    }
    if ((m_fluxPasDna == null) && (m_fluxPasDna != null)) {
      return false;
    }
    if (getListeFluxPasDna().length != x.getListeFluxPasDna().length) {
      return false;
    }
    for (int i = 0; i < getListeFluxPasDna().length; i++) {
      if ((getListeFluxPasDna()[i] != null) && 
        (!getListeFluxPasDna()[i].equals(x.getListeFluxPasDna()[i]))) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int resultat = 0;
    if (m_fluxPasDna != null) {
      for (int i = 0; i < getListeFluxPasDna().length; i++) {
        if (getListeFluxPasDna()[i] != null) {
          resultat += getListeFluxPasDna()[i].hashCode();
        }
      }
    }
    return resultat;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    _ListeFluxPasDna clone_ListeFluxPasDna = new _ListeFluxPasDna();
    
    clone_ListeFluxPasDna.populateFrom_ListeFluxPasDna(this);
    
    return clone_ListeFluxPasDna;
  }
  
  public void populateFrom_ListeFluxPasDna(_ListeFluxPasDna pSource)
  {
    setListeFluxPasDna(pSource.getListeFluxPasDna());
  }
  
  public String toString()
  {
    StringBuffer s = new StringBuffer("[_ListeFluxPasDna");
    
    subToString(s);
    
    s.append("]");
    
    return s.toString();
  }
  
  protected void subToString(StringBuffer pSource)
  {
    pSource.append(", FluxPasDna: ");
    if (m_fluxPasDna == null)
    {
      pSource.append("null");
    }
    else
    {
      pSource.append("{");
      for (int i = 0; i < getListeFluxPasDna().length; i++)
      {
        if (i > 0) {
          pSource.append(", ");
        }
        pSource.append(getListeFluxPasDna()[i]);
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
    DataBean[] FluxPasDna_Value = getListeFluxPasDna();
    GettersHandler[] FluxPasDna_GettersHandler = pHandler.property("FluxPasDna", FluxPasDna_Value, null);
    if ((FluxPasDna_GettersHandler != null) && (FluxPasDna_Value != null)) {
      for (int i = 0; i < FluxPasDna_GettersHandler.length; i++) {
        if ((FluxPasDna_GettersHandler[i] != null) && (FluxPasDna_Value[i] != null)) {
          FluxPasDna_Value[i].goThrough(FluxPasDna_GettersHandler[i]);
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
    
    DataBean[] FluxPasDna_dbs = pHandler.databeanArrayProperty("FluxPasDna", _FluxPasDna.class);
    if (FluxPasDna_dbs == null)
    {
      setListeFluxPasDna(null);
    }
    else
    {
      _FluxPasDna[] FluxPasDna_array = new _FluxPasDna[FluxPasDna_dbs.length];
      for (int i = 0; i < FluxPasDna_dbs.length; i++) {
        FluxPasDna_array[i] = ((_FluxPasDna)FluxPasDna_dbs[i]);
      }
      setListeFluxPasDna(FluxPasDna_array);
    }
  }
  
  public String _getDatabeanName()
  {
    return "ListeFluxPasDna";
  }
  
  public boolean _isValidProperty(String pElementName)
  {
    if ("FluxPasDna".equals(pElementName)) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _ListeFluxPasDna
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */