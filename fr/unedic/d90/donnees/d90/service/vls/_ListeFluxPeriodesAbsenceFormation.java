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

public class _ListeFluxPeriodesAbsenceFormation
  extends DataBeanImpl
  implements DataBean, Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  private DataList m_fluxPeriodeAbsenceFormation = _getInstanceListe();
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
  
  public _FluxPeriodeAbsenceFormation[] getListeFluxPeriodesAbsenceFormation()
  {
    Object[] objTab = _getArrayFromList(m_fluxPeriodeAbsenceFormation, _FluxPeriodeAbsenceFormation.class);
    int length = objTab.length;
    _FluxPeriodeAbsenceFormation[] tab = new _FluxPeriodeAbsenceFormation[length];
    for (int i = 0; i < length; i++) {
      tab[i] = ((_FluxPeriodeAbsenceFormation)objTab[i]);
    }
    return tab;
  }
  
  public DataList getInternalListeFluxPeriodesAbsenceFormation()
  {
    return m_fluxPeriodeAbsenceFormation;
  }
  
  public int getNbListeFluxPeriodesAbsenceFormation()
  {
    return m_fluxPeriodeAbsenceFormation.getNbElement();
  }
  
  public _FluxPeriodeAbsenceFormation getListeFluxPeriodesAbsenceFormation(int pIndex)
  {
    Object obj = m_fluxPeriodeAbsenceFormation.getElement(pIndex);
    ExceptionUtil.assertInstanceOf("element", obj, _FluxPeriodeAbsenceFormation.class);
    return (_FluxPeriodeAbsenceFormation)obj;
  }
  
  public void addListeFluxPeriodesAbsenceFormation(_FluxPeriodeAbsenceFormation pElement)
  {
    ExceptionUtil.assertMethodParamNotNull("element", pElement);
    m_fluxPeriodeAbsenceFormation.addElement(pElement);
  }
  
  public void removeFluxPeriodeAbsenceFormation(int pIndex)
  {
    m_fluxPeriodeAbsenceFormation.removeElement(pIndex);
  }
  
  public void removeFluxPeriodeAbsenceFormation(_FluxPeriodeAbsenceFormation pElement)
  {
    m_fluxPeriodeAbsenceFormation.removeElement(pElement);
  }
  
  public void setListeFluxPeriodesAbsenceFormation(_FluxPeriodeAbsenceFormation[] pIn)
  {
    _setArrayToList(pIn, m_fluxPeriodeAbsenceFormation);
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
    if ("FluxPeriodeAbsenceFormation".equals(pElementName)) {
      resultat = new PropertyInfo(pElementName, true, false, _FluxPeriodeAbsenceFormation.class, false);
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
    if ("FluxPeriodeAbsenceFormation".equals(pName)) {
      resultat = m_fluxPeriodeAbsenceFormation;
    }
    return resultat;
  }
  
  public Iterator _getPropertyNames()
    throws Exception
  {
    ArrayList liste = new ArrayList();
    
    liste.add("FluxPeriodeAbsenceFormation");
    
    return liste.iterator();
  }
  
  public ArrayList _getPropertyNames(ArrayList pListe)
    throws Exception
  {
    pListe.add("FluxPeriodeAbsenceFormation");
    
    return pListe;
  }
  
  public void _setProperty(String pName, Object pValeur)
    throws Exception
  {
    if ("FluxPeriodeAbsenceFormation".equals(pName))
    {
      ExceptionUtil.assertMethodParamNotNull("pValeur", pValeur, _FluxPeriodeAbsenceFormation.class);
      if (m_fluxPeriodeAbsenceFormation != null)
      {
        m_fluxPeriodeAbsenceFormation.addElement(pValeur);
      }
      else
      {
        m_fluxPeriodeAbsenceFormation = _getInstanceListe();
        m_fluxPeriodeAbsenceFormation.addElement(pValeur);
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
    if (!(pObjet instanceof _ListeFluxPeriodesAbsenceFormation)) {
      return false;
    }
    _ListeFluxPeriodesAbsenceFormation x = (_ListeFluxPeriodesAbsenceFormation)pObjet;
    if ((m_fluxPeriodeAbsenceFormation == null) && (m_fluxPeriodeAbsenceFormation == null)) {
      return true;
    }
    if ((m_fluxPeriodeAbsenceFormation != null) && (m_fluxPeriodeAbsenceFormation == null)) {
      return false;
    }
    if ((m_fluxPeriodeAbsenceFormation == null) && (m_fluxPeriodeAbsenceFormation != null)) {
      return false;
    }
    if (getListeFluxPeriodesAbsenceFormation().length != x.getListeFluxPeriodesAbsenceFormation().length) {
      return false;
    }
    for (int i = 0; i < getListeFluxPeriodesAbsenceFormation().length; i++) {
      if ((getListeFluxPeriodesAbsenceFormation()[i] != null) && 
        (!getListeFluxPeriodesAbsenceFormation()[i].equals(x.getListeFluxPeriodesAbsenceFormation()[i]))) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int resultat = 0;
    if (m_fluxPeriodeAbsenceFormation != null) {
      for (int i = 0; i < getListeFluxPeriodesAbsenceFormation().length; i++) {
        if (getListeFluxPeriodesAbsenceFormation()[i] != null) {
          resultat += getListeFluxPeriodesAbsenceFormation()[i].hashCode();
        }
      }
    }
    return resultat;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    _ListeFluxPeriodesAbsenceFormation clone_ListeFluxPeriodesAbsenceFormation = new _ListeFluxPeriodesAbsenceFormation();
    
    clone_ListeFluxPeriodesAbsenceFormation.populateFrom_ListeFluxPeriodesAbsenceFormation(this);
    
    return clone_ListeFluxPeriodesAbsenceFormation;
  }
  
  public void populateFrom_ListeFluxPeriodesAbsenceFormation(_ListeFluxPeriodesAbsenceFormation pSource)
  {
    setListeFluxPeriodesAbsenceFormation(pSource.getListeFluxPeriodesAbsenceFormation());
  }
  
  public String toString()
  {
    StringBuffer s = new StringBuffer("[_ListeFluxPeriodesAbsenceFormation");
    
    subToString(s);
    
    s.append("]");
    
    return s.toString();
  }
  
  protected void subToString(StringBuffer pSource)
  {
    pSource.append(", FluxPeriodeAbsenceFormation: ");
    if (m_fluxPeriodeAbsenceFormation == null)
    {
      pSource.append("null");
    }
    else
    {
      pSource.append("{");
      for (int i = 0; i < getListeFluxPeriodesAbsenceFormation().length; i++)
      {
        if (i > 0) {
          pSource.append(", ");
        }
        pSource.append(getListeFluxPeriodesAbsenceFormation()[i]);
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
    DataBean[] FluxPeriodeAbsenceFormation_Value = getListeFluxPeriodesAbsenceFormation();
    GettersHandler[] FluxPeriodeAbsenceFormation_GettersHandler = pHandler.property("FluxPeriodeAbsenceFormation", FluxPeriodeAbsenceFormation_Value, null);
    if ((FluxPeriodeAbsenceFormation_GettersHandler != null) && (FluxPeriodeAbsenceFormation_Value != null)) {
      for (int i = 0; i < FluxPeriodeAbsenceFormation_GettersHandler.length; i++) {
        if ((FluxPeriodeAbsenceFormation_GettersHandler[i] != null) && (FluxPeriodeAbsenceFormation_Value[i] != null)) {
          FluxPeriodeAbsenceFormation_Value[i].goThrough(FluxPeriodeAbsenceFormation_GettersHandler[i]);
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
    
    DataBean[] FluxPeriodeAbsenceFormation_dbs = pHandler.databeanArrayProperty("FluxPeriodeAbsenceFormation", _FluxPeriodeAbsenceFormation.class);
    if (FluxPeriodeAbsenceFormation_dbs == null)
    {
      setListeFluxPeriodesAbsenceFormation(null);
    }
    else
    {
      _FluxPeriodeAbsenceFormation[] FluxPeriodeAbsenceFormation_array = new _FluxPeriodeAbsenceFormation[FluxPeriodeAbsenceFormation_dbs.length];
      for (int i = 0; i < FluxPeriodeAbsenceFormation_dbs.length; i++) {
        FluxPeriodeAbsenceFormation_array[i] = ((_FluxPeriodeAbsenceFormation)FluxPeriodeAbsenceFormation_dbs[i]);
      }
      setListeFluxPeriodesAbsenceFormation(FluxPeriodeAbsenceFormation_array);
    }
  }
  
  public String _getDatabeanName()
  {
    return "ListeFluxPeriodesAbsenceFormation";
  }
  
  public boolean _isValidProperty(String pElementName)
  {
    if ("FluxPeriodeAbsenceFormation".equals(pElementName)) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _ListeFluxPeriodesAbsenceFormation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */