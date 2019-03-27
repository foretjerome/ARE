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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;

public class _Indicateur
  extends DataBeanImpl
  implements DataBean, Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  private String m__C_ETAT;
  private String m__IDENT;
  private String m_nom;
  private String m_nom_C_ERR;
  private BigDecimal m_valeur;
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
  
  public String getNom()
  {
    return m_nom;
  }
  
  public String getNom_C_ERR()
  {
    return m_nom_C_ERR;
  }
  
  public void setNom(String pValeur)
  {
    m_nom = pValeur;
  }
  
  public void setNom_C_ERR(String pValeur_C_ERR)
  {
    m_nom_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getValeur()
  {
    return m_valeur;
  }
  
  public String getValeur_C_ERR()
  {
    return m_valeur_C_ERR;
  }
  
  public void setValeur(BigDecimal pValeur)
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
    if ("m_nom_C_ERR".equals(attrName)) {
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
    if ("Nom".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("Valeur".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    return null;
  }
  
  public int _getPropertyLength(String pElementName)
  {
    if ("Nom".equals(pElementName)) {
      return 30;
    }
    if ("Valeur".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    return -1;
  }
  
  public Object _getProperty(String pName)
    throws Exception
  {
    if ("Nom".equals(pName)) {
      return m_nom;
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
    liste.add("Nom");
    liste.add("Valeur");
    return liste.iterator();
  }
  
  public ArrayList _getPropertyNames(ArrayList pListe)
    throws Exception
  {
    pListe.add("Nom");
    pListe.add("Valeur");
    return pListe;
  }
  
  public void _setProperty(String pName, Object pValeur)
    throws Exception
  {
    if ("Nom".equals(pName)) {
      m_nom = ((String)pValeur);
    }
    if ("Valeur".equals(pName)) {
      m_valeur = ((BigDecimal)pValeur);
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
    if ("m_nom_C_ERR".equals(attrName)) {
      m_nom_C_ERR = pValeur;
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
    if ("m_nom_C_ERR".equals(attrName)) {
      return m_nom_C_ERR;
    }
    if ("m_valeur_C_ERR".equals(attrName)) {
      return m_valeur_C_ERR;
    }
    return null;
  }
  
  public boolean equals(Object pObjet)
  {
    if (!(pObjet instanceof _Indicateur)) {
      return false;
    }
    _Indicateur x = (_Indicateur)pObjet;
    if (m_nom == null)
    {
      if (m_nom != null) {
        return false;
      }
    }
    else
    {
      if (m_nom == null) {
        return false;
      }
      if (!m_nom.equals(m_nom)) {
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
    if (m_nom != null) {
      result += m_nom.hashCode();
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
    _Indicateur clone_Indicateur = new _Indicateur();
    clone_Indicateur.populateFrom_Indicateur(this);
    return clone_Indicateur;
  }
  
  public void populateFrom_Indicateur(_Indicateur pSource)
  {
    setNom(pSource.getNom());setValeur(pSource.getValeur());
  }
  
  public String toString()
  {
    StringBuffer s = new StringBuffer("[_Indicateur");
    subToString(s);
    s.append("]");
    return s.toString();
  }
  
  protected void subToString(StringBuffer pSource)
  {
    pSource.append(", Nom: ");
    pSource.append(m_nom);
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
    pHandler.property("Nom", getNom(), new Attribute[] { new StringAttribute("C_ERR", getNom_C_ERR()) });
    
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
    setNom((String)pHandler.objectProperty("Nom", String.class));
    setNom_C_ERR(pHandler.stringAttribute("Nom", "C_ERR"));
    
    setValeur((BigDecimal)pHandler.objectProperty("Valeur", BigDecimal.class));
    setValeur_C_ERR(pHandler.stringAttribute("Valeur", "C_ERR"));
  }
  
  public String _getDatabeanName()
  {
    return "Indicateur";
  }
  
  public boolean _isValidProperty(String pElementName)
  {
    if ("Nom".equals(pElementName)) {
      return true;
    }
    if ("Valeur".equals(pElementName)) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _Indicateur
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */