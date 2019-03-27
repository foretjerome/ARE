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

public class _InfosDalCALI_periodesAffiliations
  extends DataBeanImpl
  implements DataBean, Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  private DataList m_periodeAffiliation = _getInstanceListe();
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
  
  public _PeriodeAffiliation[] getPeriodesAffiliations()
  {
    Object[] objTab = _getArrayFromList(m_periodeAffiliation, _PeriodeAffiliation.class);
    int length = objTab.length;
    _PeriodeAffiliation[] tab = new _PeriodeAffiliation[length];
    for (int i = 0; i < length; i++) {
      tab[i] = ((_PeriodeAffiliation)objTab[i]);
    }
    return tab;
  }
  
  public DataList getInternalInfosDalCALI_periodesAffiliations()
  {
    return m_periodeAffiliation;
  }
  
  public int getNbInfosDalCALI_periodesAffiliations()
  {
    return m_periodeAffiliation.getNbElement();
  }
  
  public _PeriodeAffiliation getPeriodesAffiliations(int pIndex)
  {
    Object obj = m_periodeAffiliation.getElement(pIndex);
    ExceptionUtil.assertInstanceOf("element", obj, _PeriodeAffiliation.class);
    return (_PeriodeAffiliation)obj;
  }
  
  public void addPeriodesAffiliations(_PeriodeAffiliation pElement)
  {
    ExceptionUtil.assertMethodParamNotNull("element", pElement);
    m_periodeAffiliation.addElement(pElement);
  }
  
  public void removePeriodeAffiliation(int pIndex)
  {
    m_periodeAffiliation.removeElement(pIndex);
  }
  
  public void removePeriodeAffiliation(_PeriodeAffiliation pElement)
  {
    m_periodeAffiliation.removeElement(pElement);
  }
  
  public void setPeriodesAffiliations(_PeriodeAffiliation[] pIn)
  {
    _setArrayToList(pIn, m_periodeAffiliation);
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
    if ("PeriodeAffiliation".equals(pElementName)) {
      resultat = new PropertyInfo(pElementName, true, false, _PeriodeAffiliation.class, false);
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
    if ("PeriodeAffiliation".equals(pName)) {
      resultat = m_periodeAffiliation;
    }
    return resultat;
  }
  
  public Iterator _getPropertyNames()
    throws Exception
  {
    ArrayList liste = new ArrayList();
    
    liste.add("PeriodeAffiliation");
    
    return liste.iterator();
  }
  
  public ArrayList _getPropertyNames(ArrayList pListe)
    throws Exception
  {
    pListe.add("PeriodeAffiliation");
    
    return pListe;
  }
  
  public void _setProperty(String pName, Object pValeur)
    throws Exception
  {
    if ("PeriodeAffiliation".equals(pName))
    {
      ExceptionUtil.assertMethodParamNotNull("pValeur", pValeur, _PeriodeAffiliation.class);
      if (m_periodeAffiliation != null)
      {
        m_periodeAffiliation.addElement(pValeur);
      }
      else
      {
        m_periodeAffiliation = _getInstanceListe();
        m_periodeAffiliation.addElement(pValeur);
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
    if (!(pObjet instanceof _InfosDalCALI_periodesAffiliations)) {
      return false;
    }
    _InfosDalCALI_periodesAffiliations x = (_InfosDalCALI_periodesAffiliations)pObjet;
    if ((m_periodeAffiliation == null) && (m_periodeAffiliation == null)) {
      return true;
    }
    if ((m_periodeAffiliation != null) && (m_periodeAffiliation == null)) {
      return false;
    }
    if ((m_periodeAffiliation == null) && (m_periodeAffiliation != null)) {
      return false;
    }
    if (getPeriodesAffiliations().length != x.getPeriodesAffiliations().length) {
      return false;
    }
    for (int i = 0; i < getPeriodesAffiliations().length; i++) {
      if ((getPeriodesAffiliations()[i] != null) && 
        (!getPeriodesAffiliations()[i].equals(x.getPeriodesAffiliations()[i]))) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int resultat = 0;
    if (m_periodeAffiliation != null) {
      for (int i = 0; i < getPeriodesAffiliations().length; i++) {
        if (getPeriodesAffiliations()[i] != null) {
          resultat += getPeriodesAffiliations()[i].hashCode();
        }
      }
    }
    return resultat;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    _InfosDalCALI_periodesAffiliations clone_InfosDalCALI_periodesAffiliations = new _InfosDalCALI_periodesAffiliations();
    
    clone_InfosDalCALI_periodesAffiliations.populateFrom_InfosDalCALI_periodesAffiliations(this);
    
    return clone_InfosDalCALI_periodesAffiliations;
  }
  
  public void populateFrom_InfosDalCALI_periodesAffiliations(_InfosDalCALI_periodesAffiliations pSource)
  {
    setPeriodesAffiliations(pSource.getPeriodesAffiliations());
  }
  
  public String toString()
  {
    StringBuffer s = new StringBuffer("[_InfosDalCALI_periodesAffiliations");
    
    subToString(s);
    
    s.append("]");
    
    return s.toString();
  }
  
  protected void subToString(StringBuffer pSource)
  {
    pSource.append(", PeriodeAffiliation: ");
    if (m_periodeAffiliation == null)
    {
      pSource.append("null");
    }
    else
    {
      pSource.append("{");
      for (int i = 0; i < getPeriodesAffiliations().length; i++)
      {
        if (i > 0) {
          pSource.append(", ");
        }
        pSource.append(getPeriodesAffiliations()[i]);
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
    DataBean[] PeriodeAffiliation_Value = getPeriodesAffiliations();
    GettersHandler[] PeriodeAffiliation_GettersHandler = pHandler.property("PeriodeAffiliation", PeriodeAffiliation_Value, null);
    if ((PeriodeAffiliation_GettersHandler != null) && (PeriodeAffiliation_Value != null)) {
      for (int i = 0; i < PeriodeAffiliation_GettersHandler.length; i++) {
        if ((PeriodeAffiliation_GettersHandler[i] != null) && (PeriodeAffiliation_Value[i] != null)) {
          PeriodeAffiliation_Value[i].goThrough(PeriodeAffiliation_GettersHandler[i]);
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
    
    DataBean[] PeriodeAffiliation_dbs = pHandler.databeanArrayProperty("PeriodeAffiliation", _PeriodeAffiliation.class);
    if (PeriodeAffiliation_dbs == null)
    {
      setPeriodesAffiliations(null);
    }
    else
    {
      _PeriodeAffiliation[] PeriodeAffiliation_array = new _PeriodeAffiliation[PeriodeAffiliation_dbs.length];
      for (int i = 0; i < PeriodeAffiliation_dbs.length; i++) {
        PeriodeAffiliation_array[i] = ((_PeriodeAffiliation)PeriodeAffiliation_dbs[i]);
      }
      setPeriodesAffiliations(PeriodeAffiliation_array);
    }
  }
  
  public String _getDatabeanName()
  {
    return "InfosDalCALI_periodesAffiliations";
  }
  
  public boolean _isValidProperty(String pElementName)
  {
    if ("PeriodeAffiliation".equals(pElementName)) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _InfosDalCALI_periodesAffiliations
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */