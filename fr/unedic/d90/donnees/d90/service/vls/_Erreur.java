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

public class _Erreur
  extends DataBeanImpl
  implements DataBean, Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  private String m__C_ETAT;
  private String m__IDENT;
  private String m_code;
  private String m_code_C_ERR;
  private String m_libelle;
  private String m_libelle_C_ERR;
  private String m_item;
  private String m_item_C_ERR;
  private String m_parametres;
  private String m_parametres_C_ERR;
  private BigDecimal m_niveau;
  private String m_niveau_C_ERR;
  
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
  
  public String getCode()
  {
    return m_code;
  }
  
  public String getCode_C_ERR()
  {
    return m_code_C_ERR;
  }
  
  public void setCode(String pValeur)
  {
    m_code = pValeur;
  }
  
  public void setCode_C_ERR(String pValeur_C_ERR)
  {
    m_code_C_ERR = pValeur_C_ERR;
  }
  
  public String getLibelle()
  {
    return m_libelle;
  }
  
  public String getLibelle_C_ERR()
  {
    return m_libelle_C_ERR;
  }
  
  public void setLibelle(String pValeur)
  {
    m_libelle = pValeur;
  }
  
  public void setLibelle_C_ERR(String pValeur_C_ERR)
  {
    m_libelle_C_ERR = pValeur_C_ERR;
  }
  
  public String getItem()
  {
    return m_item;
  }
  
  public String getItem_C_ERR()
  {
    return m_item_C_ERR;
  }
  
  public void setItem(String pValeur)
  {
    m_item = pValeur;
  }
  
  public void setItem_C_ERR(String pValeur_C_ERR)
  {
    m_item_C_ERR = pValeur_C_ERR;
  }
  
  public String getParametres()
  {
    return m_parametres;
  }
  
  public String getParametres_C_ERR()
  {
    return m_parametres_C_ERR;
  }
  
  public void setParametres(String pValeur)
  {
    m_parametres = pValeur;
  }
  
  public void setParametres_C_ERR(String pValeur_C_ERR)
  {
    m_parametres_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getNiveau()
  {
    return m_niveau;
  }
  
  public String getNiveau_C_ERR()
  {
    return m_niveau_C_ERR;
  }
  
  public void setNiveau(BigDecimal pValeur)
  {
    m_niveau = pValeur;
  }
  
  public void setNiveau_C_ERR(String pValeur_C_ERR)
  {
    m_niveau_C_ERR = pValeur_C_ERR;
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
    if ("m_code_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_libelle_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_item_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_parametres_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_niveau_C_ERR".equals(attrName)) {
      return String.class;
    }
    return null;
  }
  
  public PropertyInfo _getPropertyInfo(String pElementName)
    throws TechniqueException
  {
    if ("Code".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("Libelle".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("Item".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("Parametres".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("Niveau".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    return null;
  }
  
  public int _getPropertyLength(String pElementName)
  {
    if ("Code".equals(pElementName)) {
      return 100;
    }
    if ("Libelle".equals(pElementName)) {
      return 500;
    }
    if ("Item".equals(pElementName)) {
      return 50;
    }
    if ("Parametres".equals(pElementName)) {
      return 999;
    }
    if ("Niveau".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    return -1;
  }
  
  public Object _getProperty(String pName)
    throws Exception
  {
    if ("Code".equals(pName)) {
      return m_code;
    }
    if ("Libelle".equals(pName)) {
      return m_libelle;
    }
    if ("Item".equals(pName)) {
      return m_item;
    }
    if ("Parametres".equals(pName)) {
      return m_parametres;
    }
    if ("Niveau".equals(pName)) {
      return m_niveau;
    }
    return null;
  }
  
  public Iterator _getPropertyNames()
    throws Exception
  {
    ArrayList liste = new ArrayList();
    liste.add("Code");
    liste.add("Libelle");
    liste.add("Item");
    liste.add("Parametres");
    liste.add("Niveau");
    return liste.iterator();
  }
  
  public ArrayList _getPropertyNames(ArrayList pListe)
    throws Exception
  {
    pListe.add("Code");
    pListe.add("Libelle");
    pListe.add("Item");
    pListe.add("Parametres");
    pListe.add("Niveau");
    return pListe;
  }
  
  public void _setProperty(String pName, Object pValeur)
    throws Exception
  {
    if ("Code".equals(pName)) {
      m_code = ((String)pValeur);
    }
    if ("Libelle".equals(pName)) {
      m_libelle = ((String)pValeur);
    }
    if ("Item".equals(pName)) {
      m_item = ((String)pValeur);
    }
    if ("Parametres".equals(pName)) {
      m_parametres = ((String)pValeur);
    }
    if ("Niveau".equals(pName)) {
      m_niveau = ((BigDecimal)pValeur);
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
    if ("m_code_C_ERR".equals(attrName)) {
      m_code_C_ERR = pValeur;
    }
    if ("m_libelle_C_ERR".equals(attrName)) {
      m_libelle_C_ERR = pValeur;
    }
    if ("m_item_C_ERR".equals(attrName)) {
      m_item_C_ERR = pValeur;
    }
    if ("m_parametres_C_ERR".equals(attrName)) {
      m_parametres_C_ERR = pValeur;
    }
    if ("m_niveau_C_ERR".equals(attrName)) {
      m_niveau_C_ERR = pValeur;
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
    if ("m_code_C_ERR".equals(attrName)) {
      return m_code_C_ERR;
    }
    if ("m_libelle_C_ERR".equals(attrName)) {
      return m_libelle_C_ERR;
    }
    if ("m_item_C_ERR".equals(attrName)) {
      return m_item_C_ERR;
    }
    if ("m_parametres_C_ERR".equals(attrName)) {
      return m_parametres_C_ERR;
    }
    if ("m_niveau_C_ERR".equals(attrName)) {
      return m_niveau_C_ERR;
    }
    return null;
  }
  
  public boolean equals(Object pObjet)
  {
    if (!(pObjet instanceof _Erreur)) {
      return false;
    }
    _Erreur x = (_Erreur)pObjet;
    if (m_code == null)
    {
      if (m_code != null) {
        return false;
      }
    }
    else
    {
      if (m_code == null) {
        return false;
      }
      if (!m_code.equals(m_code)) {
        return false;
      }
    }
    if (m_libelle == null)
    {
      if (m_libelle != null) {
        return false;
      }
    }
    else
    {
      if (m_libelle == null) {
        return false;
      }
      if (!m_libelle.equals(m_libelle)) {
        return false;
      }
    }
    if (m_item == null)
    {
      if (m_item != null) {
        return false;
      }
    }
    else
    {
      if (m_item == null) {
        return false;
      }
      if (!m_item.equals(m_item)) {
        return false;
      }
    }
    if (m_parametres == null)
    {
      if (m_parametres != null) {
        return false;
      }
    }
    else
    {
      if (m_parametres == null) {
        return false;
      }
      if (!m_parametres.equals(m_parametres)) {
        return false;
      }
    }
    if (m_niveau == null)
    {
      if (m_niveau != null) {
        return false;
      }
    }
    else
    {
      if (m_niveau == null) {
        return false;
      }
      if (!m_niveau.equals(m_niveau)) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int result = 0;
    if (m_code != null) {
      result += m_code.hashCode();
    }
    if (m_libelle != null) {
      result += m_libelle.hashCode();
    }
    if (m_item != null) {
      result += m_item.hashCode();
    }
    if (m_parametres != null) {
      result += m_parametres.hashCode();
    }
    if (m_niveau != null) {
      result += m_niveau.hashCode();
    }
    result *= 17;
    return result;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    _Erreur clone_Erreur = new _Erreur();
    clone_Erreur.populateFrom_Erreur(this);
    return clone_Erreur;
  }
  
  public void populateFrom_Erreur(_Erreur pSource)
  {
    setCode(pSource.getCode());setLibelle(pSource.getLibelle());setItem(pSource.getItem());setParametres(pSource.getParametres());setNiveau(pSource.getNiveau());
  }
  
  public String toString()
  {
    StringBuffer s = new StringBuffer("[_Erreur");
    subToString(s);
    s.append("]");
    return s.toString();
  }
  
  protected void subToString(StringBuffer pSource)
  {
    pSource.append(", Code: ");
    pSource.append(m_code);
    pSource.append(", Libelle: ");
    pSource.append(m_libelle);
    pSource.append(", Item: ");
    pSource.append(m_item);
    pSource.append(", Parametres: ");
    pSource.append(m_parametres);
    pSource.append(", Niveau: ");
    pSource.append(m_niveau);
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
    pHandler.property("Code", getCode(), new Attribute[] { new StringAttribute("C_ERR", getCode_C_ERR()) });
    
    pHandler.property("Libelle", getLibelle(), new Attribute[] { new StringAttribute("C_ERR", getLibelle_C_ERR()) });
    
    pHandler.property("Item", getItem(), new Attribute[] { new StringAttribute("C_ERR", getItem_C_ERR()) });
    
    pHandler.property("Parametres", getParametres(), new Attribute[] { new StringAttribute("C_ERR", getParametres_C_ERR()) });
    
    pHandler.property("Niveau", getNiveau(), new Attribute[] { new StringAttribute("C_ERR", getNiveau_C_ERR()) });
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
    setCode((String)pHandler.objectProperty("Code", String.class));
    setCode_C_ERR(pHandler.stringAttribute("Code", "C_ERR"));
    
    setLibelle((String)pHandler.objectProperty("Libelle", String.class));
    setLibelle_C_ERR(pHandler.stringAttribute("Libelle", "C_ERR"));
    
    setItem((String)pHandler.objectProperty("Item", String.class));
    setItem_C_ERR(pHandler.stringAttribute("Item", "C_ERR"));
    
    setParametres((String)pHandler.objectProperty("Parametres", String.class));
    setParametres_C_ERR(pHandler.stringAttribute("Parametres", "C_ERR"));
    
    setNiveau((BigDecimal)pHandler.objectProperty("Niveau", BigDecimal.class));
    setNiveau_C_ERR(pHandler.stringAttribute("Niveau", "C_ERR"));
  }
  
  public String _getDatabeanName()
  {
    return "Erreur";
  }
  
  public boolean _isValidProperty(String pElementName)
  {
    if ("Code".equals(pElementName)) {
      return true;
    }
    if ("Libelle".equals(pElementName)) {
      return true;
    }
    if ("Item".equals(pElementName)) {
      return true;
    }
    if ("Parametres".equals(pElementName)) {
      return true;
    }
    if ("Niveau".equals(pElementName)) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _Erreur
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */