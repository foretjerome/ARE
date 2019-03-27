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

public class _FluxQuantiteTravailDsn
  extends DataBeanImpl
  implements DataBean, Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  private String m__C_ETAT;
  private String m__IDENT;
  private String m_uniteTempsTravail;
  private String m_uniteTempsTravail_C_ERR;
  private BigDecimal m_quantiteTempsTravail;
  private String m_quantiteTempsTravail_C_ERR;
  private String m_signeQuantiteTempsTravail;
  private String m_signeQuantiteTempsTravail_C_ERR;
  
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
  
  public String getUniteTempsTravail()
  {
    return m_uniteTempsTravail;
  }
  
  public String getUniteTempsTravail_C_ERR()
  {
    return m_uniteTempsTravail_C_ERR;
  }
  
  public void setUniteTempsTravail(String pValeur)
  {
    m_uniteTempsTravail = pValeur;
  }
  
  public void setUniteTempsTravail_C_ERR(String pValeur_C_ERR)
  {
    m_uniteTempsTravail_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getQuantiteTempsTravail()
  {
    return m_quantiteTempsTravail;
  }
  
  public String getQuantiteTempsTravail_C_ERR()
  {
    return m_quantiteTempsTravail_C_ERR;
  }
  
  public void setQuantiteTempsTravail(BigDecimal pValeur)
  {
    m_quantiteTempsTravail = pValeur;
  }
  
  public void setQuantiteTempsTravail_C_ERR(String pValeur_C_ERR)
  {
    m_quantiteTempsTravail_C_ERR = pValeur_C_ERR;
  }
  
  public String getSigneQuantiteTempsTravail()
  {
    return m_signeQuantiteTempsTravail;
  }
  
  public String getSigneQuantiteTempsTravail_C_ERR()
  {
    return m_signeQuantiteTempsTravail_C_ERR;
  }
  
  public void setSigneQuantiteTempsTravail(String pValeur)
  {
    m_signeQuantiteTempsTravail = pValeur;
  }
  
  public void setSigneQuantiteTempsTravail_C_ERR(String pValeur_C_ERR)
  {
    m_signeQuantiteTempsTravail_C_ERR = pValeur_C_ERR;
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
    if ("m_uniteTempsTravail_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_quantiteTempsTravail_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_signeQuantiteTempsTravail_C_ERR".equals(attrName)) {
      return String.class;
    }
    return null;
  }
  
  public PropertyInfo _getPropertyInfo(String pElementName)
    throws TechniqueException
  {
    if ("uniteTempsTravail".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("quantiteTempsTravail".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("signeQuantiteTempsTravail".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    return null;
  }
  
  public int _getPropertyLength(String pElementName)
  {
    if ("uniteTempsTravail".equals(pElementName)) {
      return 2;
    }
    if ("quantiteTempsTravail".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("signeQuantiteTempsTravail".equals(pElementName)) {
      return 1;
    }
    return -1;
  }
  
  public Object _getProperty(String pName)
    throws Exception
  {
    if ("uniteTempsTravail".equals(pName)) {
      return m_uniteTempsTravail;
    }
    if ("quantiteTempsTravail".equals(pName)) {
      return m_quantiteTempsTravail;
    }
    if ("signeQuantiteTempsTravail".equals(pName)) {
      return m_signeQuantiteTempsTravail;
    }
    return null;
  }
  
  public Iterator _getPropertyNames()
    throws Exception
  {
    ArrayList liste = new ArrayList();
    liste.add("uniteTempsTravail");
    liste.add("quantiteTempsTravail");
    liste.add("signeQuantiteTempsTravail");
    return liste.iterator();
  }
  
  public ArrayList _getPropertyNames(ArrayList pListe)
    throws Exception
  {
    pListe.add("uniteTempsTravail");
    pListe.add("quantiteTempsTravail");
    pListe.add("signeQuantiteTempsTravail");
    return pListe;
  }
  
  public void _setProperty(String pName, Object pValeur)
    throws Exception
  {
    if ("uniteTempsTravail".equals(pName)) {
      m_uniteTempsTravail = ((String)pValeur);
    }
    if ("quantiteTempsTravail".equals(pName)) {
      m_quantiteTempsTravail = ((BigDecimal)pValeur);
    }
    if ("signeQuantiteTempsTravail".equals(pName)) {
      m_signeQuantiteTempsTravail = ((String)pValeur);
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
    if ("m_uniteTempsTravail_C_ERR".equals(attrName)) {
      m_uniteTempsTravail_C_ERR = pValeur;
    }
    if ("m_quantiteTempsTravail_C_ERR".equals(attrName)) {
      m_quantiteTempsTravail_C_ERR = pValeur;
    }
    if ("m_signeQuantiteTempsTravail_C_ERR".equals(attrName)) {
      m_signeQuantiteTempsTravail_C_ERR = pValeur;
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
    if ("m_uniteTempsTravail_C_ERR".equals(attrName)) {
      return m_uniteTempsTravail_C_ERR;
    }
    if ("m_quantiteTempsTravail_C_ERR".equals(attrName)) {
      return m_quantiteTempsTravail_C_ERR;
    }
    if ("m_signeQuantiteTempsTravail_C_ERR".equals(attrName)) {
      return m_signeQuantiteTempsTravail_C_ERR;
    }
    return null;
  }
  
  public boolean equals(Object pObjet)
  {
    if (!(pObjet instanceof _FluxQuantiteTravailDsn)) {
      return false;
    }
    _FluxQuantiteTravailDsn x = (_FluxQuantiteTravailDsn)pObjet;
    if (m_uniteTempsTravail == null)
    {
      if (m_uniteTempsTravail != null) {
        return false;
      }
    }
    else
    {
      if (m_uniteTempsTravail == null) {
        return false;
      }
      if (!m_uniteTempsTravail.equals(m_uniteTempsTravail)) {
        return false;
      }
    }
    if (m_quantiteTempsTravail == null)
    {
      if (m_quantiteTempsTravail != null) {
        return false;
      }
    }
    else
    {
      if (m_quantiteTempsTravail == null) {
        return false;
      }
      if (!m_quantiteTempsTravail.equals(m_quantiteTempsTravail)) {
        return false;
      }
    }
    if (m_signeQuantiteTempsTravail == null)
    {
      if (m_signeQuantiteTempsTravail != null) {
        return false;
      }
    }
    else
    {
      if (m_signeQuantiteTempsTravail == null) {
        return false;
      }
      if (!m_signeQuantiteTempsTravail.equals(m_signeQuantiteTempsTravail)) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int result = 0;
    if (m_uniteTempsTravail != null) {
      result += m_uniteTempsTravail.hashCode();
    }
    if (m_quantiteTempsTravail != null) {
      result += m_quantiteTempsTravail.hashCode();
    }
    if (m_signeQuantiteTempsTravail != null) {
      result += m_signeQuantiteTempsTravail.hashCode();
    }
    result *= 17;
    return result;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    _FluxQuantiteTravailDsn clone_FluxQuantiteTravailDsn = new _FluxQuantiteTravailDsn();
    clone_FluxQuantiteTravailDsn.populateFrom_FluxQuantiteTravailDsn(this);
    return clone_FluxQuantiteTravailDsn;
  }
  
  public void populateFrom_FluxQuantiteTravailDsn(_FluxQuantiteTravailDsn pSource)
  {
    setUniteTempsTravail(pSource.getUniteTempsTravail());setQuantiteTempsTravail(pSource.getQuantiteTempsTravail());setSigneQuantiteTempsTravail(pSource.getSigneQuantiteTempsTravail());
  }
  
  public String toString()
  {
    StringBuffer s = new StringBuffer("[_FluxQuantiteTravailDsn");
    subToString(s);
    s.append("]");
    return s.toString();
  }
  
  protected void subToString(StringBuffer pSource)
  {
    pSource.append(", uniteTempsTravail: ");
    pSource.append(m_uniteTempsTravail);
    pSource.append(", quantiteTempsTravail: ");
    pSource.append(m_quantiteTempsTravail);
    pSource.append(", signeQuantiteTempsTravail: ");
    pSource.append(m_signeQuantiteTempsTravail);
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
    pHandler.property("uniteTempsTravail", getUniteTempsTravail(), new Attribute[] { new StringAttribute("C_ERR", getUniteTempsTravail_C_ERR()) });
    
    pHandler.property("quantiteTempsTravail", getQuantiteTempsTravail(), new Attribute[] { new StringAttribute("C_ERR", getQuantiteTempsTravail_C_ERR()) });
    
    pHandler.property("signeQuantiteTempsTravail", getSigneQuantiteTempsTravail(), new Attribute[] { new StringAttribute("C_ERR", getSigneQuantiteTempsTravail_C_ERR()) });
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
    setUniteTempsTravail((String)pHandler.objectProperty("uniteTempsTravail", String.class));
    setUniteTempsTravail_C_ERR(pHandler.stringAttribute("uniteTempsTravail", "C_ERR"));
    
    setQuantiteTempsTravail((BigDecimal)pHandler.objectProperty("quantiteTempsTravail", BigDecimal.class));
    setQuantiteTempsTravail_C_ERR(pHandler.stringAttribute("quantiteTempsTravail", "C_ERR"));
    
    setSigneQuantiteTempsTravail((String)pHandler.objectProperty("signeQuantiteTempsTravail", String.class));
    setSigneQuantiteTempsTravail_C_ERR(pHandler.stringAttribute("signeQuantiteTempsTravail", "C_ERR"));
  }
  
  public String _getDatabeanName()
  {
    return "FluxQuantiteTravailDsn";
  }
  
  public boolean _isValidProperty(String pElementName)
  {
    if ("uniteTempsTravail".equals(pElementName)) {
      return true;
    }
    if ("quantiteTempsTravail".equals(pElementName)) {
      return true;
    }
    if ("signeQuantiteTempsTravail".equals(pElementName)) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _FluxQuantiteTravailDsn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */