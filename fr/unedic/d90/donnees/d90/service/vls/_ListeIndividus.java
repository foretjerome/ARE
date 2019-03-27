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

public class _ListeIndividus
  extends DataBeanImpl
  implements DataBean, Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  private DataList m_individu = _getInstanceListe();
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
  
  public _Individu[] getListeIndividus()
  {
    Object[] objTab = _getArrayFromList(m_individu, _Individu.class);
    int length = objTab.length;
    _Individu[] tab = new _Individu[length];
    for (int i = 0; i < length; i++) {
      tab[i] = ((_Individu)objTab[i]);
    }
    return tab;
  }
  
  public DataList getInternalListeIndividus()
  {
    return m_individu;
  }
  
  public int getNbListeIndividus()
  {
    return m_individu.getNbElement();
  }
  
  public _Individu getListeIndividus(int pIndex)
  {
    Object obj = m_individu.getElement(pIndex);
    ExceptionUtil.assertInstanceOf("element", obj, _Individu.class);
    return (_Individu)obj;
  }
  
  public void addListeIndividus(_Individu pElement)
  {
    ExceptionUtil.assertMethodParamNotNull("element", pElement);
    m_individu.addElement(pElement);
  }
  
  public void removeIndividu(int pIndex)
  {
    m_individu.removeElement(pIndex);
  }
  
  public void removeIndividu(_Individu pElement)
  {
    m_individu.removeElement(pElement);
  }
  
  public void setListeIndividus(_Individu[] pIn)
  {
    _setArrayToList(pIn, m_individu);
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
    if ("Individu".equals(pElementName)) {
      resultat = new PropertyInfo(pElementName, true, false, _Individu.class, false);
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
    if ("Individu".equals(pName)) {
      resultat = m_individu;
    }
    return resultat;
  }
  
  public Iterator _getPropertyNames()
    throws Exception
  {
    ArrayList liste = new ArrayList();
    
    liste.add("Individu");
    
    return liste.iterator();
  }
  
  public ArrayList _getPropertyNames(ArrayList pListe)
    throws Exception
  {
    pListe.add("Individu");
    
    return pListe;
  }
  
  public void _setProperty(String pName, Object pValeur)
    throws Exception
  {
    if ("Individu".equals(pName))
    {
      ExceptionUtil.assertMethodParamNotNull("pValeur", pValeur, _Individu.class);
      if (m_individu != null)
      {
        m_individu.addElement(pValeur);
      }
      else
      {
        m_individu = _getInstanceListe();
        m_individu.addElement(pValeur);
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
    if (!(pObjet instanceof _ListeIndividus)) {
      return false;
    }
    _ListeIndividus x = (_ListeIndividus)pObjet;
    if ((m_individu == null) && (m_individu == null)) {
      return true;
    }
    if ((m_individu != null) && (m_individu == null)) {
      return false;
    }
    if ((m_individu == null) && (m_individu != null)) {
      return false;
    }
    if (getListeIndividus().length != x.getListeIndividus().length) {
      return false;
    }
    for (int i = 0; i < getListeIndividus().length; i++) {
      if ((getListeIndividus()[i] != null) && 
        (!getListeIndividus()[i].equals(x.getListeIndividus()[i]))) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int resultat = 0;
    if (m_individu != null) {
      for (int i = 0; i < getListeIndividus().length; i++) {
        if (getListeIndividus()[i] != null) {
          resultat += getListeIndividus()[i].hashCode();
        }
      }
    }
    return resultat;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    _ListeIndividus clone_ListeIndividus = new _ListeIndividus();
    
    clone_ListeIndividus.populateFrom_ListeIndividus(this);
    
    return clone_ListeIndividus;
  }
  
  public void populateFrom_ListeIndividus(_ListeIndividus pSource)
  {
    setListeIndividus(pSource.getListeIndividus());
  }
  
  public String toString()
  {
    StringBuffer s = new StringBuffer("[_ListeIndividus");
    
    subToString(s);
    
    s.append("]");
    
    return s.toString();
  }
  
  protected void subToString(StringBuffer pSource)
  {
    pSource.append(", Individu: ");
    if (m_individu == null)
    {
      pSource.append("null");
    }
    else
    {
      pSource.append("{");
      for (int i = 0; i < getListeIndividus().length; i++)
      {
        if (i > 0) {
          pSource.append(", ");
        }
        pSource.append(getListeIndividus()[i]);
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
    DataBean[] Individu_Value = getListeIndividus();
    GettersHandler[] Individu_GettersHandler = pHandler.property("Individu", Individu_Value, null);
    if ((Individu_GettersHandler != null) && (Individu_Value != null)) {
      for (int i = 0; i < Individu_GettersHandler.length; i++) {
        if ((Individu_GettersHandler[i] != null) && (Individu_Value[i] != null)) {
          Individu_Value[i].goThrough(Individu_GettersHandler[i]);
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
    
    DataBean[] Individu_dbs = pHandler.databeanArrayProperty("Individu", _Individu.class);
    if (Individu_dbs == null)
    {
      setListeIndividus(null);
    }
    else
    {
      _Individu[] Individu_array = new _Individu[Individu_dbs.length];
      for (int i = 0; i < Individu_dbs.length; i++) {
        Individu_array[i] = ((_Individu)Individu_dbs[i]);
      }
      setListeIndividus(Individu_array);
    }
  }
  
  public String _getDatabeanName()
  {
    return "ListeIndividus";
  }
  
  public boolean _isValidProperty(String pElementName)
  {
    if ("Individu".equals(pElementName)) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _ListeIndividus
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */