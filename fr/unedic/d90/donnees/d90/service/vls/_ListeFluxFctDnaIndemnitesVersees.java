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

public class _ListeFluxFctDnaIndemnitesVersees
  extends DataBeanImpl
  implements DataBean, Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  private DataList m_fluxFctDnaIndemniteVersee = _getInstanceListe();
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
  
  public _FluxFctDnaIndemniteVersee[] getListeFluxFctDnaIndemnitesVersees()
  {
    Object[] objTab = _getArrayFromList(m_fluxFctDnaIndemniteVersee, _FluxFctDnaIndemniteVersee.class);
    int length = objTab.length;
    _FluxFctDnaIndemniteVersee[] tab = new _FluxFctDnaIndemniteVersee[length];
    for (int i = 0; i < length; i++) {
      tab[i] = ((_FluxFctDnaIndemniteVersee)objTab[i]);
    }
    return tab;
  }
  
  public DataList getInternalListeFluxFctDnaIndemnitesVersees()
  {
    return m_fluxFctDnaIndemniteVersee;
  }
  
  public int getNbListeFluxFctDnaIndemnitesVersees()
  {
    return m_fluxFctDnaIndemniteVersee.getNbElement();
  }
  
  public _FluxFctDnaIndemniteVersee getListeFluxFctDnaIndemnitesVersees(int pIndex)
  {
    Object obj = m_fluxFctDnaIndemniteVersee.getElement(pIndex);
    ExceptionUtil.assertInstanceOf("element", obj, _FluxFctDnaIndemniteVersee.class);
    return (_FluxFctDnaIndemniteVersee)obj;
  }
  
  public void addListeFluxFctDnaIndemnitesVersees(_FluxFctDnaIndemniteVersee pElement)
  {
    ExceptionUtil.assertMethodParamNotNull("element", pElement);
    m_fluxFctDnaIndemniteVersee.addElement(pElement);
  }
  
  public void removeFluxFctDnaIndemniteVersee(int pIndex)
  {
    m_fluxFctDnaIndemniteVersee.removeElement(pIndex);
  }
  
  public void removeFluxFctDnaIndemniteVersee(_FluxFctDnaIndemniteVersee pElement)
  {
    m_fluxFctDnaIndemniteVersee.removeElement(pElement);
  }
  
  public void setListeFluxFctDnaIndemnitesVersees(_FluxFctDnaIndemniteVersee[] pIn)
  {
    _setArrayToList(pIn, m_fluxFctDnaIndemniteVersee);
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
    if ("FluxFctDnaIndemniteVersee".equals(pElementName)) {
      resultat = new PropertyInfo(pElementName, true, false, _FluxFctDnaIndemniteVersee.class, false);
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
    if ("FluxFctDnaIndemniteVersee".equals(pName)) {
      resultat = m_fluxFctDnaIndemniteVersee;
    }
    return resultat;
  }
  
  public Iterator _getPropertyNames()
    throws Exception
  {
    ArrayList liste = new ArrayList();
    
    liste.add("FluxFctDnaIndemniteVersee");
    
    return liste.iterator();
  }
  
  public ArrayList _getPropertyNames(ArrayList pListe)
    throws Exception
  {
    pListe.add("FluxFctDnaIndemniteVersee");
    
    return pListe;
  }
  
  public void _setProperty(String pName, Object pValeur)
    throws Exception
  {
    if ("FluxFctDnaIndemniteVersee".equals(pName))
    {
      ExceptionUtil.assertMethodParamNotNull("pValeur", pValeur, _FluxFctDnaIndemniteVersee.class);
      if (m_fluxFctDnaIndemniteVersee != null)
      {
        m_fluxFctDnaIndemniteVersee.addElement(pValeur);
      }
      else
      {
        m_fluxFctDnaIndemniteVersee = _getInstanceListe();
        m_fluxFctDnaIndemniteVersee.addElement(pValeur);
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
    if (!(pObjet instanceof _ListeFluxFctDnaIndemnitesVersees)) {
      return false;
    }
    _ListeFluxFctDnaIndemnitesVersees x = (_ListeFluxFctDnaIndemnitesVersees)pObjet;
    if ((m_fluxFctDnaIndemniteVersee == null) && (m_fluxFctDnaIndemniteVersee == null)) {
      return true;
    }
    if ((m_fluxFctDnaIndemniteVersee != null) && (m_fluxFctDnaIndemniteVersee == null)) {
      return false;
    }
    if ((m_fluxFctDnaIndemniteVersee == null) && (m_fluxFctDnaIndemniteVersee != null)) {
      return false;
    }
    if (getListeFluxFctDnaIndemnitesVersees().length != x.getListeFluxFctDnaIndemnitesVersees().length) {
      return false;
    }
    for (int i = 0; i < getListeFluxFctDnaIndemnitesVersees().length; i++) {
      if ((getListeFluxFctDnaIndemnitesVersees()[i] != null) && 
        (!getListeFluxFctDnaIndemnitesVersees()[i].equals(x.getListeFluxFctDnaIndemnitesVersees()[i]))) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int resultat = 0;
    if (m_fluxFctDnaIndemniteVersee != null) {
      for (int i = 0; i < getListeFluxFctDnaIndemnitesVersees().length; i++) {
        if (getListeFluxFctDnaIndemnitesVersees()[i] != null) {
          resultat += getListeFluxFctDnaIndemnitesVersees()[i].hashCode();
        }
      }
    }
    return resultat;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    _ListeFluxFctDnaIndemnitesVersees clone_ListeFluxFctDnaIndemnitesVersees = new _ListeFluxFctDnaIndemnitesVersees();
    
    clone_ListeFluxFctDnaIndemnitesVersees.populateFrom_ListeFluxFctDnaIndemnitesVersees(this);
    
    return clone_ListeFluxFctDnaIndemnitesVersees;
  }
  
  public void populateFrom_ListeFluxFctDnaIndemnitesVersees(_ListeFluxFctDnaIndemnitesVersees pSource)
  {
    setListeFluxFctDnaIndemnitesVersees(pSource.getListeFluxFctDnaIndemnitesVersees());
  }
  
  public String toString()
  {
    StringBuffer s = new StringBuffer("[_ListeFluxFctDnaIndemnitesVersees");
    
    subToString(s);
    
    s.append("]");
    
    return s.toString();
  }
  
  protected void subToString(StringBuffer pSource)
  {
    pSource.append(", FluxFctDnaIndemniteVersee: ");
    if (m_fluxFctDnaIndemniteVersee == null)
    {
      pSource.append("null");
    }
    else
    {
      pSource.append("{");
      for (int i = 0; i < getListeFluxFctDnaIndemnitesVersees().length; i++)
      {
        if (i > 0) {
          pSource.append(", ");
        }
        pSource.append(getListeFluxFctDnaIndemnitesVersees()[i]);
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
    DataBean[] FluxFctDnaIndemniteVersee_Value = getListeFluxFctDnaIndemnitesVersees();
    GettersHandler[] FluxFctDnaIndemniteVersee_GettersHandler = pHandler.property("FluxFctDnaIndemniteVersee", FluxFctDnaIndemniteVersee_Value, null);
    if ((FluxFctDnaIndemniteVersee_GettersHandler != null) && (FluxFctDnaIndemniteVersee_Value != null)) {
      for (int i = 0; i < FluxFctDnaIndemniteVersee_GettersHandler.length; i++) {
        if ((FluxFctDnaIndemniteVersee_GettersHandler[i] != null) && (FluxFctDnaIndemniteVersee_Value[i] != null)) {
          FluxFctDnaIndemniteVersee_Value[i].goThrough(FluxFctDnaIndemniteVersee_GettersHandler[i]);
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
    
    DataBean[] FluxFctDnaIndemniteVersee_dbs = pHandler.databeanArrayProperty("FluxFctDnaIndemniteVersee", _FluxFctDnaIndemniteVersee.class);
    if (FluxFctDnaIndemniteVersee_dbs == null)
    {
      setListeFluxFctDnaIndemnitesVersees(null);
    }
    else
    {
      _FluxFctDnaIndemniteVersee[] FluxFctDnaIndemniteVersee_array = new _FluxFctDnaIndemniteVersee[FluxFctDnaIndemniteVersee_dbs.length];
      for (int i = 0; i < FluxFctDnaIndemniteVersee_dbs.length; i++) {
        FluxFctDnaIndemniteVersee_array[i] = ((_FluxFctDnaIndemniteVersee)FluxFctDnaIndemniteVersee_dbs[i]);
      }
      setListeFluxFctDnaIndemnitesVersees(FluxFctDnaIndemniteVersee_array);
    }
  }
  
  public String _getDatabeanName()
  {
    return "ListeFluxFctDnaIndemnitesVersees";
  }
  
  public boolean _isValidProperty(String pElementName)
  {
    if ("FluxFctDnaIndemniteVersee".equals(pElementName)) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _ListeFluxFctDnaIndemnitesVersees
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */