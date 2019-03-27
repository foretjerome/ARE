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

public class _ListeErreurs
  extends DataBeanImpl
  implements DataBean, Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  private DataList m_erreur = _getInstanceListe();
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
  
  public _Erreur[] getListeErreurs()
  {
    Object[] objTab = _getArrayFromList(m_erreur, _Erreur.class);
    int length = objTab.length;
    _Erreur[] tab = new _Erreur[length];
    for (int i = 0; i < length; i++) {
      tab[i] = ((_Erreur)objTab[i]);
    }
    return tab;
  }
  
  public DataList getInternalListeErreurs()
  {
    return m_erreur;
  }
  
  public int getNbListeErreurs()
  {
    return m_erreur.getNbElement();
  }
  
  public _Erreur getListeErreurs(int pIndex)
  {
    Object obj = m_erreur.getElement(pIndex);
    ExceptionUtil.assertInstanceOf("element", obj, _Erreur.class);
    return (_Erreur)obj;
  }
  
  public void addListeErreurs(_Erreur pElement)
  {
    ExceptionUtil.assertMethodParamNotNull("element", pElement);
    m_erreur.addElement(pElement);
  }
  
  public void removeErreur(int pIndex)
  {
    m_erreur.removeElement(pIndex);
  }
  
  public void removeErreur(_Erreur pElement)
  {
    m_erreur.removeElement(pElement);
  }
  
  public void setListeErreurs(_Erreur[] pIn)
  {
    _setArrayToList(pIn, m_erreur);
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
    if ("Erreur".equals(pElementName)) {
      resultat = new PropertyInfo(pElementName, true, false, _Erreur.class, false);
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
    if ("Erreur".equals(pName)) {
      resultat = m_erreur;
    }
    return resultat;
  }
  
  public Iterator _getPropertyNames()
    throws Exception
  {
    ArrayList liste = new ArrayList();
    
    liste.add("Erreur");
    
    return liste.iterator();
  }
  
  public ArrayList _getPropertyNames(ArrayList pListe)
    throws Exception
  {
    pListe.add("Erreur");
    
    return pListe;
  }
  
  public void _setProperty(String pName, Object pValeur)
    throws Exception
  {
    if ("Erreur".equals(pName))
    {
      ExceptionUtil.assertMethodParamNotNull("pValeur", pValeur, _Erreur.class);
      if (m_erreur != null)
      {
        m_erreur.addElement(pValeur);
      }
      else
      {
        m_erreur = _getInstanceListe();
        m_erreur.addElement(pValeur);
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
    if (!(pObjet instanceof _ListeErreurs)) {
      return false;
    }
    _ListeErreurs x = (_ListeErreurs)pObjet;
    if ((m_erreur == null) && (m_erreur == null)) {
      return true;
    }
    if ((m_erreur != null) && (m_erreur == null)) {
      return false;
    }
    if ((m_erreur == null) && (m_erreur != null)) {
      return false;
    }
    if (getListeErreurs().length != x.getListeErreurs().length) {
      return false;
    }
    for (int i = 0; i < getListeErreurs().length; i++) {
      if ((getListeErreurs()[i] != null) && 
        (!getListeErreurs()[i].equals(x.getListeErreurs()[i]))) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int resultat = 0;
    if (m_erreur != null) {
      for (int i = 0; i < getListeErreurs().length; i++) {
        if (getListeErreurs()[i] != null) {
          resultat += getListeErreurs()[i].hashCode();
        }
      }
    }
    return resultat;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    _ListeErreurs clone_ListeErreurs = new _ListeErreurs();
    
    clone_ListeErreurs.populateFrom_ListeErreurs(this);
    
    return clone_ListeErreurs;
  }
  
  public void populateFrom_ListeErreurs(_ListeErreurs pSource)
  {
    setListeErreurs(pSource.getListeErreurs());
  }
  
  public String toString()
  {
    StringBuffer s = new StringBuffer("[_ListeErreurs");
    
    subToString(s);
    
    s.append("]");
    
    return s.toString();
  }
  
  protected void subToString(StringBuffer pSource)
  {
    pSource.append(", Erreur: ");
    if (m_erreur == null)
    {
      pSource.append("null");
    }
    else
    {
      pSource.append("{");
      for (int i = 0; i < getListeErreurs().length; i++)
      {
        if (i > 0) {
          pSource.append(", ");
        }
        pSource.append(getListeErreurs()[i]);
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
    DataBean[] Erreur_Value = getListeErreurs();
    GettersHandler[] Erreur_GettersHandler = pHandler.property("Erreur", Erreur_Value, null);
    if ((Erreur_GettersHandler != null) && (Erreur_Value != null)) {
      for (int i = 0; i < Erreur_GettersHandler.length; i++) {
        if ((Erreur_GettersHandler[i] != null) && (Erreur_Value[i] != null)) {
          Erreur_Value[i].goThrough(Erreur_GettersHandler[i]);
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
    
    DataBean[] Erreur_dbs = pHandler.databeanArrayProperty("Erreur", _Erreur.class);
    if (Erreur_dbs == null)
    {
      setListeErreurs(null);
    }
    else
    {
      _Erreur[] Erreur_array = new _Erreur[Erreur_dbs.length];
      for (int i = 0; i < Erreur_dbs.length; i++) {
        Erreur_array[i] = ((_Erreur)Erreur_dbs[i]);
      }
      setListeErreurs(Erreur_array);
    }
  }
  
  public String _getDatabeanName()
  {
    return "ListeErreurs";
  }
  
  public boolean _isValidProperty(String pElementName)
  {
    if ("Erreur".equals(pElementName)) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _ListeErreurs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */