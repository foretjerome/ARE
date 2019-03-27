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

public class _CriteresEcrireEvtDesengAide_listeParametres
  extends DataBeanImpl
  implements DataBean, Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  private DataList m_parametre = _getInstanceListe();
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
  
  public _Parametre[] getListeParametres()
  {
    Object[] objTab = _getArrayFromList(m_parametre, _Parametre.class);
    int length = objTab.length;
    _Parametre[] tab = new _Parametre[length];
    for (int i = 0; i < length; i++) {
      tab[i] = ((_Parametre)objTab[i]);
    }
    return tab;
  }
  
  public DataList getInternalCriteresEcrireEvtDesengAide_listeParametres()
  {
    return m_parametre;
  }
  
  public int getNbCriteresEcrireEvtDesengAide_listeParametres()
  {
    return m_parametre.getNbElement();
  }
  
  public _Parametre getListeParametres(int pIndex)
  {
    Object obj = m_parametre.getElement(pIndex);
    ExceptionUtil.assertInstanceOf("element", obj, _Parametre.class);
    return (_Parametre)obj;
  }
  
  public void addListeParametres(_Parametre pElement)
  {
    ExceptionUtil.assertMethodParamNotNull("element", pElement);
    m_parametre.addElement(pElement);
  }
  
  public void removeParametre(int pIndex)
  {
    m_parametre.removeElement(pIndex);
  }
  
  public void removeParametre(_Parametre pElement)
  {
    m_parametre.removeElement(pElement);
  }
  
  public void setListeParametres(_Parametre[] pIn)
  {
    _setArrayToList(pIn, m_parametre);
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
    if ("Parametre".equals(pElementName)) {
      resultat = new PropertyInfo(pElementName, true, false, _Parametre.class, false);
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
    if ("Parametre".equals(pName)) {
      resultat = m_parametre;
    }
    return resultat;
  }
  
  public Iterator _getPropertyNames()
    throws Exception
  {
    ArrayList liste = new ArrayList();
    
    liste.add("Parametre");
    
    return liste.iterator();
  }
  
  public ArrayList _getPropertyNames(ArrayList pListe)
    throws Exception
  {
    pListe.add("Parametre");
    
    return pListe;
  }
  
  public void _setProperty(String pName, Object pValeur)
    throws Exception
  {
    if ("Parametre".equals(pName))
    {
      ExceptionUtil.assertMethodParamNotNull("pValeur", pValeur, _Parametre.class);
      if (m_parametre != null)
      {
        m_parametre.addElement(pValeur);
      }
      else
      {
        m_parametre = _getInstanceListe();
        m_parametre.addElement(pValeur);
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
    if (!(pObjet instanceof _CriteresEcrireEvtDesengAide_listeParametres)) {
      return false;
    }
    _CriteresEcrireEvtDesengAide_listeParametres x = (_CriteresEcrireEvtDesengAide_listeParametres)pObjet;
    if ((m_parametre == null) && (m_parametre == null)) {
      return true;
    }
    if ((m_parametre != null) && (m_parametre == null)) {
      return false;
    }
    if ((m_parametre == null) && (m_parametre != null)) {
      return false;
    }
    if (getListeParametres().length != x.getListeParametres().length) {
      return false;
    }
    for (int i = 0; i < getListeParametres().length; i++) {
      if ((getListeParametres()[i] != null) && 
        (!getListeParametres()[i].equals(x.getListeParametres()[i]))) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int resultat = 0;
    if (m_parametre != null) {
      for (int i = 0; i < getListeParametres().length; i++) {
        if (getListeParametres()[i] != null) {
          resultat += getListeParametres()[i].hashCode();
        }
      }
    }
    return resultat;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    _CriteresEcrireEvtDesengAide_listeParametres clone_CriteresEcrireEvtDesengAide_listeParametres = new _CriteresEcrireEvtDesengAide_listeParametres();
    
    clone_CriteresEcrireEvtDesengAide_listeParametres.populateFrom_CriteresEcrireEvtDesengAide_listeParametres(this);
    
    return clone_CriteresEcrireEvtDesengAide_listeParametres;
  }
  
  public void populateFrom_CriteresEcrireEvtDesengAide_listeParametres(_CriteresEcrireEvtDesengAide_listeParametres pSource)
  {
    setListeParametres(pSource.getListeParametres());
  }
  
  public String toString()
  {
    StringBuffer s = new StringBuffer("[_CriteresEcrireEvtDesengAide_listeParametres");
    
    subToString(s);
    
    s.append("]");
    
    return s.toString();
  }
  
  protected void subToString(StringBuffer pSource)
  {
    pSource.append(", Parametre: ");
    if (m_parametre == null)
    {
      pSource.append("null");
    }
    else
    {
      pSource.append("{");
      for (int i = 0; i < getListeParametres().length; i++)
      {
        if (i > 0) {
          pSource.append(", ");
        }
        pSource.append(getListeParametres()[i]);
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
    DataBean[] Parametre_Value = getListeParametres();
    GettersHandler[] Parametre_GettersHandler = pHandler.property("Parametre", Parametre_Value, null);
    if ((Parametre_GettersHandler != null) && (Parametre_Value != null)) {
      for (int i = 0; i < Parametre_GettersHandler.length; i++) {
        if ((Parametre_GettersHandler[i] != null) && (Parametre_Value[i] != null)) {
          Parametre_Value[i].goThrough(Parametre_GettersHandler[i]);
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
    
    DataBean[] Parametre_dbs = pHandler.databeanArrayProperty("Parametre", _Parametre.class);
    if (Parametre_dbs == null)
    {
      setListeParametres(null);
    }
    else
    {
      _Parametre[] Parametre_array = new _Parametre[Parametre_dbs.length];
      for (int i = 0; i < Parametre_dbs.length; i++) {
        Parametre_array[i] = ((_Parametre)Parametre_dbs[i]);
      }
      setListeParametres(Parametre_array);
    }
  }
  
  public String _getDatabeanName()
  {
    return "CriteresEcrireEvtDesengAide_listeParametres";
  }
  
  public boolean _isValidProperty(String pElementName)
  {
    if ("Parametre".equals(pElementName)) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _CriteresEcrireEvtDesengAide_listeParametres
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */