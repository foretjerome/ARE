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

public class _FluxPasDnaQuantiteTravail
  extends DataBeanImpl
  implements DataBean, Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  private String m__C_ETAT;
  private String m__IDENT;
  private String m_uniteTravail;
  private String m_uniteTravail_C_ERR;
  private BigDecimal m_quantiteTravail;
  private String m_quantiteTravail_C_ERR;
  
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
  
  public String getUniteTravail()
  {
    return m_uniteTravail;
  }
  
  public String getUniteTravail_C_ERR()
  {
    return m_uniteTravail_C_ERR;
  }
  
  public void setUniteTravail(String pValeur)
  {
    m_uniteTravail = pValeur;
  }
  
  public void setUniteTravail_C_ERR(String pValeur_C_ERR)
  {
    m_uniteTravail_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getQuantiteTravail()
  {
    return m_quantiteTravail;
  }
  
  public String getQuantiteTravail_C_ERR()
  {
    return m_quantiteTravail_C_ERR;
  }
  
  public void setQuantiteTravail(BigDecimal pValeur)
  {
    m_quantiteTravail = pValeur;
  }
  
  public void setQuantiteTravail_C_ERR(String pValeur_C_ERR)
  {
    m_quantiteTravail_C_ERR = pValeur_C_ERR;
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
    if ("m_uniteTravail_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_quantiteTravail_C_ERR".equals(attrName)) {
      return String.class;
    }
    return null;
  }
  
  public PropertyInfo _getPropertyInfo(String pElementName)
    throws TechniqueException
  {
    if ("UniteTravail".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("QuantiteTravail".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    return null;
  }
  
  public int _getPropertyLength(String pElementName)
  {
    if ("UniteTravail".equals(pElementName)) {
      return 2;
    }
    if ("QuantiteTravail".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    return -1;
  }
  
  public Object _getProperty(String pName)
    throws Exception
  {
    if ("UniteTravail".equals(pName)) {
      return m_uniteTravail;
    }
    if ("QuantiteTravail".equals(pName)) {
      return m_quantiteTravail;
    }
    return null;
  }
  
  public Iterator _getPropertyNames()
    throws Exception
  {
    ArrayList liste = new ArrayList();
    liste.add("UniteTravail");
    liste.add("QuantiteTravail");
    return liste.iterator();
  }
  
  public ArrayList _getPropertyNames(ArrayList pListe)
    throws Exception
  {
    pListe.add("UniteTravail");
    pListe.add("QuantiteTravail");
    return pListe;
  }
  
  public void _setProperty(String pName, Object pValeur)
    throws Exception
  {
    if ("UniteTravail".equals(pName)) {
      m_uniteTravail = ((String)pValeur);
    }
    if ("QuantiteTravail".equals(pName)) {
      m_quantiteTravail = ((BigDecimal)pValeur);
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
    if ("m_uniteTravail_C_ERR".equals(attrName)) {
      m_uniteTravail_C_ERR = pValeur;
    }
    if ("m_quantiteTravail_C_ERR".equals(attrName)) {
      m_quantiteTravail_C_ERR = pValeur;
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
    if ("m_uniteTravail_C_ERR".equals(attrName)) {
      return m_uniteTravail_C_ERR;
    }
    if ("m_quantiteTravail_C_ERR".equals(attrName)) {
      return m_quantiteTravail_C_ERR;
    }
    return null;
  }
  
  public boolean equals(Object pObjet)
  {
    if (!(pObjet instanceof _FluxPasDnaQuantiteTravail)) {
      return false;
    }
    _FluxPasDnaQuantiteTravail x = (_FluxPasDnaQuantiteTravail)pObjet;
    if (m_uniteTravail == null)
    {
      if (m_uniteTravail != null) {
        return false;
      }
    }
    else
    {
      if (m_uniteTravail == null) {
        return false;
      }
      if (!m_uniteTravail.equals(m_uniteTravail)) {
        return false;
      }
    }
    if (m_quantiteTravail == null)
    {
      if (m_quantiteTravail != null) {
        return false;
      }
    }
    else
    {
      if (m_quantiteTravail == null) {
        return false;
      }
      if (!m_quantiteTravail.equals(m_quantiteTravail)) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int result = 0;
    if (m_uniteTravail != null) {
      result += m_uniteTravail.hashCode();
    }
    if (m_quantiteTravail != null) {
      result += m_quantiteTravail.hashCode();
    }
    result *= 17;
    return result;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    _FluxPasDnaQuantiteTravail clone_FluxPasDnaQuantiteTravail = new _FluxPasDnaQuantiteTravail();
    clone_FluxPasDnaQuantiteTravail.populateFrom_FluxPasDnaQuantiteTravail(this);
    return clone_FluxPasDnaQuantiteTravail;
  }
  
  public void populateFrom_FluxPasDnaQuantiteTravail(_FluxPasDnaQuantiteTravail pSource)
  {
    setUniteTravail(pSource.getUniteTravail());setQuantiteTravail(pSource.getQuantiteTravail());
  }
  
  public String toString()
  {
    StringBuffer s = new StringBuffer("[_FluxPasDnaQuantiteTravail");
    subToString(s);
    s.append("]");
    return s.toString();
  }
  
  protected void subToString(StringBuffer pSource)
  {
    pSource.append(", UniteTravail: ");
    pSource.append(m_uniteTravail);
    pSource.append(", QuantiteTravail: ");
    pSource.append(m_quantiteTravail);
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
    pHandler.property("UniteTravail", getUniteTravail(), new Attribute[] { new StringAttribute("C_ERR", getUniteTravail_C_ERR()) });
    
    pHandler.property("QuantiteTravail", getQuantiteTravail(), new Attribute[] { new StringAttribute("C_ERR", getQuantiteTravail_C_ERR()) });
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
    setUniteTravail((String)pHandler.objectProperty("UniteTravail", String.class));
    setUniteTravail_C_ERR(pHandler.stringAttribute("UniteTravail", "C_ERR"));
    
    setQuantiteTravail((BigDecimal)pHandler.objectProperty("QuantiteTravail", BigDecimal.class));
    setQuantiteTravail_C_ERR(pHandler.stringAttribute("QuantiteTravail", "C_ERR"));
  }
  
  public String _getDatabeanName()
  {
    return "FluxPasDnaQuantiteTravail";
  }
  
  public boolean _isValidProperty(String pElementName)
  {
    if ("UniteTravail".equals(pElementName)) {
      return true;
    }
    if ("QuantiteTravail".equals(pElementName)) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _FluxPasDnaQuantiteTravail
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */