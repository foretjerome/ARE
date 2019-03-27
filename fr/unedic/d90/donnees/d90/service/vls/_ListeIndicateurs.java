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

public class _ListeIndicateurs
  extends DataBeanImpl
  implements DataBean, Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  private DataList m_indicateur = _getInstanceListe();
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
  
  public _Indicateur[] getListeIndicateurs()
  {
    Object[] objTab = _getArrayFromList(m_indicateur, _Indicateur.class);
    int length = objTab.length;
    _Indicateur[] tab = new _Indicateur[length];
    for (int i = 0; i < length; i++) {
      tab[i] = ((_Indicateur)objTab[i]);
    }
    return tab;
  }
  
  public DataList getInternalListeIndicateurs()
  {
    return m_indicateur;
  }
  
  public int getNbListeIndicateurs()
  {
    return m_indicateur.getNbElement();
  }
  
  public _Indicateur getListeIndicateurs(int pIndex)
  {
    Object obj = m_indicateur.getElement(pIndex);
    ExceptionUtil.assertInstanceOf("element", obj, _Indicateur.class);
    return (_Indicateur)obj;
  }
  
  public void addListeIndicateurs(_Indicateur pElement)
  {
    ExceptionUtil.assertMethodParamNotNull("element", pElement);
    m_indicateur.addElement(pElement);
  }
  
  public void removeIndicateur(int pIndex)
  {
    m_indicateur.removeElement(pIndex);
  }
  
  public void removeIndicateur(_Indicateur pElement)
  {
    m_indicateur.removeElement(pElement);
  }
  
  public void setListeIndicateurs(_Indicateur[] pIn)
  {
    _setArrayToList(pIn, m_indicateur);
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
    if ("Indicateur".equals(pElementName)) {
      resultat = new PropertyInfo(pElementName, true, false, _Indicateur.class, false);
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
    if ("Indicateur".equals(pName)) {
      resultat = m_indicateur;
    }
    return resultat;
  }
  
  public Iterator _getPropertyNames()
    throws Exception
  {
    ArrayList liste = new ArrayList();
    
    liste.add("Indicateur");
    
    return liste.iterator();
  }
  
  public ArrayList _getPropertyNames(ArrayList pListe)
    throws Exception
  {
    pListe.add("Indicateur");
    
    return pListe;
  }
  
  public void _setProperty(String pName, Object pValeur)
    throws Exception
  {
    if ("Indicateur".equals(pName))
    {
      ExceptionUtil.assertMethodParamNotNull("pValeur", pValeur, _Indicateur.class);
      if (m_indicateur != null)
      {
        m_indicateur.addElement(pValeur);
      }
      else
      {
        m_indicateur = _getInstanceListe();
        m_indicateur.addElement(pValeur);
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
    if (!(pObjet instanceof _ListeIndicateurs)) {
      return false;
    }
    _ListeIndicateurs x = (_ListeIndicateurs)pObjet;
    if ((m_indicateur == null) && (m_indicateur == null)) {
      return true;
    }
    if ((m_indicateur != null) && (m_indicateur == null)) {
      return false;
    }
    if ((m_indicateur == null) && (m_indicateur != null)) {
      return false;
    }
    if (getListeIndicateurs().length != x.getListeIndicateurs().length) {
      return false;
    }
    for (int i = 0; i < getListeIndicateurs().length; i++) {
      if ((getListeIndicateurs()[i] != null) && 
        (!getListeIndicateurs()[i].equals(x.getListeIndicateurs()[i]))) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int resultat = 0;
    if (m_indicateur != null) {
      for (int i = 0; i < getListeIndicateurs().length; i++) {
        if (getListeIndicateurs()[i] != null) {
          resultat += getListeIndicateurs()[i].hashCode();
        }
      }
    }
    return resultat;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    _ListeIndicateurs clone_ListeIndicateurs = new _ListeIndicateurs();
    
    clone_ListeIndicateurs.populateFrom_ListeIndicateurs(this);
    
    return clone_ListeIndicateurs;
  }
  
  public void populateFrom_ListeIndicateurs(_ListeIndicateurs pSource)
  {
    setListeIndicateurs(pSource.getListeIndicateurs());
  }
  
  public String toString()
  {
    StringBuffer s = new StringBuffer("[_ListeIndicateurs");
    
    subToString(s);
    
    s.append("]");
    
    return s.toString();
  }
  
  protected void subToString(StringBuffer pSource)
  {
    pSource.append(", Indicateur: ");
    if (m_indicateur == null)
    {
      pSource.append("null");
    }
    else
    {
      pSource.append("{");
      for (int i = 0; i < getListeIndicateurs().length; i++)
      {
        if (i > 0) {
          pSource.append(", ");
        }
        pSource.append(getListeIndicateurs()[i]);
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
    DataBean[] Indicateur_Value = getListeIndicateurs();
    GettersHandler[] Indicateur_GettersHandler = pHandler.property("Indicateur", Indicateur_Value, null);
    if ((Indicateur_GettersHandler != null) && (Indicateur_Value != null)) {
      for (int i = 0; i < Indicateur_GettersHandler.length; i++) {
        if ((Indicateur_GettersHandler[i] != null) && (Indicateur_Value[i] != null)) {
          Indicateur_Value[i].goThrough(Indicateur_GettersHandler[i]);
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
    
    DataBean[] Indicateur_dbs = pHandler.databeanArrayProperty("Indicateur", _Indicateur.class);
    if (Indicateur_dbs == null)
    {
      setListeIndicateurs(null);
    }
    else
    {
      _Indicateur[] Indicateur_array = new _Indicateur[Indicateur_dbs.length];
      for (int i = 0; i < Indicateur_dbs.length; i++) {
        Indicateur_array[i] = ((_Indicateur)Indicateur_dbs[i]);
      }
      setListeIndicateurs(Indicateur_array);
    }
  }
  
  public String _getDatabeanName()
  {
    return "ListeIndicateurs";
  }
  
  public boolean _isValidProperty(String pElementName)
  {
    if ("Indicateur".equals(pElementName)) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _ListeIndicateurs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */