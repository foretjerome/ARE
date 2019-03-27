package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.databean.Attribute;
import fr.unedic.archi.databean.DataBean;
import fr.unedic.archi.databean.DataBeanImpl;
import fr.unedic.archi.databean.GettersHandler;
import fr.unedic.archi.databean.PropertyInfo;
import fr.unedic.archi.databean.SettersHandler;
import fr.unedic.archi.databean.StringAttribute;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class _Parametre
  extends DataBeanImpl
  implements DataBean, Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  private String m__C_ETAT;
  private String m__IDENT;
  private String m_id;
  private String m_id_C_ERR;
  private String m_valeur;
  private String m_valeur_C_ERR;
  
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
  
  public String getId()
  {
    return m_id;
  }
  
  public String getId_C_ERR()
  {
    return m_id_C_ERR;
  }
  
  public void setId(String pValeur)
  {
    m_id = pValeur;
  }
  
  public void setId_C_ERR(String pValeur_C_ERR)
  {
    m_id_C_ERR = pValeur_C_ERR;
  }
  
  public String getValeur()
  {
    return m_valeur;
  }
  
  public String getValeur_C_ERR()
  {
    return m_valeur_C_ERR;
  }
  
  public void setValeur(String pValeur)
  {
    m_valeur = pValeur;
  }
  
  public void setValeur_C_ERR(String pValeur_C_ERR)
  {
    m_valeur_C_ERR = pValeur_C_ERR;
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
    if ("m_id_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_valeur_C_ERR".equals(attrName)) {
      return String.class;
    }
    return null;
  }
  
  public PropertyInfo _getPropertyInfo(String pElementName)
    throws TechniqueException
  {
    if ("Id".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("Valeur".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    return null;
  }
  
  public int _getPropertyLength(String pElementName)
  {
    if ("Id".equals(pElementName)) {
      return 50;
    }
    if ("Valeur".equals(pElementName)) {
      return 50;
    }
    return -1;
  }
  
  public Object _getProperty(String pName)
    throws Exception
  {
    if ("Id".equals(pName)) {
      return m_id;
    }
    if ("Valeur".equals(pName)) {
      return m_valeur;
    }
    return null;
  }
  
  public Iterator _getPropertyNames()
    throws Exception
  {
    ArrayList liste = new ArrayList();
    liste.add("Id");
    liste.add("Valeur");
    return liste.iterator();
  }
  
  public ArrayList _getPropertyNames(ArrayList pListe)
    throws Exception
  {
    pListe.add("Id");
    pListe.add("Valeur");
    return pListe;
  }
  
  public void _setProperty(String pName, Object pValeur)
    throws Exception
  {
    if ("Id".equals(pName)) {
      m_id = ((String)pValeur);
    }
    if ("Valeur".equals(pName)) {
      m_valeur = ((String)pValeur);
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
    if ("m_id_C_ERR".equals(attrName)) {
      m_id_C_ERR = pValeur;
    }
    if ("m_valeur_C_ERR".equals(attrName)) {
      m_valeur_C_ERR = pValeur;
    }
  }
  
  public String _getAttribute(String pPropertyName, String pAttributeName)
  {
    StringBuffer attr = new StringBuffer();
    attr.append("m_");
    if (pPropertyName != null) {
      attr.append(pPropertyName);
    }
    attr.append("_").append(pAttributeName);
    String attrName = attr.toString();
    if ("m__C_ETAT".equals(attrName)) {
      return m__C_ETAT;
    }
    if ("m__IDENT".equals(attrName)) {
      return m__IDENT;
    }
    if ("m_id_C_ERR".equals(attrName)) {
      return m_id_C_ERR;
    }
    if ("m_valeur_C_ERR".equals(attrName)) {
      return m_valeur_C_ERR;
    }
    return null;
  }
  
  public boolean equals(Object pObjet)
  {
    if (!(pObjet instanceof _Parametre)) {
      return false;
    }
    _Parametre x = (_Parametre)pObjet;
    if (m_id == null)
    {
      if (m_id != null) {
        return false;
      }
    }
    else
    {
      if (m_id == null) {
        return false;
      }
      if (!m_id.equals(m_id)) {
        return false;
      }
    }
    if (m_valeur == null)
    {
      if (m_valeur != null) {
        return false;
      }
    }
    else
    {
      if (m_valeur == null) {
        return false;
      }
      if (!m_valeur.equals(m_valeur)) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int result = 0;
    if (m_id != null) {
      result += m_id.hashCode();
    }
    if (m_valeur != null) {
      result += m_valeur.hashCode();
    }
    result *= 17;
    return result;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    _Parametre clone_Parametre = new _Parametre();
    clone_Parametre.populateFrom_Parametre(this);
    return clone_Parametre;
  }
  
  public void populateFrom_Parametre(_Parametre pSource)
  {
    setId(pSource.getId());setValeur(pSource.getValeur());
  }
  
  public String toString()
  {
    StringBuffer s = new StringBuffer("[_Parametre");
    subToString(s);
    s.append("]");
    return s.toString();
  }
  
  protected void subToString(StringBuffer pSource)
  {
    pSource.append(", Id: ");
    pSource.append(m_id);
    pSource.append(", Valeur: ");
    pSource.append(m_valeur);
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
    pHandler.property("Id", getId(), new Attribute[] { new StringAttribute("C_ERR", getId_C_ERR()) });
    
    pHandler.property("Valeur", getValeur(), new Attribute[] { new StringAttribute("C_ERR", getValeur_C_ERR()) });
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
    setId((String)pHandler.objectProperty("Id", String.class));
    setId_C_ERR(pHandler.stringAttribute("Id", "C_ERR"));
    
    setValeur((String)pHandler.objectProperty("Valeur", String.class));
    setValeur_C_ERR(pHandler.stringAttribute("Valeur", "C_ERR"));
  }
  
  public String _getDatabeanName()
  {
    return "Parametre";
  }
  
  public boolean _isValidProperty(String pElementName)
  {
    if ("Id".equals(pElementName)) {
      return true;
    }
    if ("Valeur".equals(pElementName)) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _Parametre
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */