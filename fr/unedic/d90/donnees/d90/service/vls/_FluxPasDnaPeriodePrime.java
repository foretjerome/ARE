package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.databean.Attribute;
import fr.unedic.archi.databean.DataBean;
import fr.unedic.archi.databean.DataBeanImpl;
import fr.unedic.archi.databean.GettersHandler;
import fr.unedic.archi.databean.PropertyInfo;
import fr.unedic.archi.databean.SettersHandler;
import fr.unedic.archi.databean.StringAttribute;
import fr.unedic.util.temps.Damj;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;

public class _FluxPasDnaPeriodePrime
  extends DataBeanImpl
  implements DataBean, Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  private String m__C_ETAT;
  private String m__IDENT;
  private String m_nature;
  private String m_nature_C_ERR;
  private String m_type;
  private String m_type_C_ERR;
  private String m_indicMontant;
  private String m_indicMontant_C_ERR;
  private Damj m_dateDebutPrime;
  private String m_dateDebutPrime_C_ERR;
  private Damj m_dateFinPrime;
  private String m_dateFinPrime_C_ERR;
  private BigDecimal m_montantPrime;
  private String m_montantPrime_C_ERR;
  
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
  
  public String getNature()
  {
    return m_nature;
  }
  
  public String getNature_C_ERR()
  {
    return m_nature_C_ERR;
  }
  
  public void setNature(String pValeur)
  {
    m_nature = pValeur;
  }
  
  public void setNature_C_ERR(String pValeur_C_ERR)
  {
    m_nature_C_ERR = pValeur_C_ERR;
  }
  
  public String getType()
  {
    return m_type;
  }
  
  public String getType_C_ERR()
  {
    return m_type_C_ERR;
  }
  
  public void setType(String pValeur)
  {
    m_type = pValeur;
  }
  
  public void setType_C_ERR(String pValeur_C_ERR)
  {
    m_type_C_ERR = pValeur_C_ERR;
  }
  
  public String getIndicMontant()
  {
    return m_indicMontant;
  }
  
  public String getIndicMontant_C_ERR()
  {
    return m_indicMontant_C_ERR;
  }
  
  public void setIndicMontant(String pValeur)
  {
    m_indicMontant = pValeur;
  }
  
  public void setIndicMontant_C_ERR(String pValeur_C_ERR)
  {
    m_indicMontant_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDateDebutPrime()
  {
    return m_dateDebutPrime;
  }
  
  public String getDateDebutPrime_C_ERR()
  {
    return m_dateDebutPrime_C_ERR;
  }
  
  public void setDateDebutPrime(Damj pValeur)
  {
    m_dateDebutPrime = pValeur;
  }
  
  public void setDateDebutPrime_C_ERR(String pValeur_C_ERR)
  {
    m_dateDebutPrime_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDateFinPrime()
  {
    return m_dateFinPrime;
  }
  
  public String getDateFinPrime_C_ERR()
  {
    return m_dateFinPrime_C_ERR;
  }
  
  public void setDateFinPrime(Damj pValeur)
  {
    m_dateFinPrime = pValeur;
  }
  
  public void setDateFinPrime_C_ERR(String pValeur_C_ERR)
  {
    m_dateFinPrime_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getMontantPrime()
  {
    return m_montantPrime;
  }
  
  public String getMontantPrime_C_ERR()
  {
    return m_montantPrime_C_ERR;
  }
  
  public void setMontantPrime(BigDecimal pValeur)
  {
    m_montantPrime = pValeur;
  }
  
  public void setMontantPrime_C_ERR(String pValeur_C_ERR)
  {
    m_montantPrime_C_ERR = pValeur_C_ERR;
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
    if ("m_nature_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_type_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_indicMontant_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateDebutPrime_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateFinPrime_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_montantPrime_C_ERR".equals(attrName)) {
      return String.class;
    }
    return null;
  }
  
  public PropertyInfo _getPropertyInfo(String pElementName)
    throws TechniqueException
  {
    if ("Nature".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("Type".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("IndicMontant".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("DateDebutPrime".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("DateFinPrime".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("MontantPrime".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    return null;
  }
  
  public int _getPropertyLength(String pElementName)
  {
    if ("Nature".equals(pElementName)) {
      return 1;
    }
    if ("Type".equals(pElementName)) {
      return 3;
    }
    if ("IndicMontant".equals(pElementName)) {
      return 1;
    }
    if ("DateDebutPrime".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("DateFinPrime".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("MontantPrime".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    return -1;
  }
  
  public Object _getProperty(String pName)
    throws Exception
  {
    if ("Nature".equals(pName)) {
      return m_nature;
    }
    if ("Type".equals(pName)) {
      return m_type;
    }
    if ("IndicMontant".equals(pName)) {
      return m_indicMontant;
    }
    if ("DateDebutPrime".equals(pName)) {
      return m_dateDebutPrime;
    }
    if ("DateFinPrime".equals(pName)) {
      return m_dateFinPrime;
    }
    if ("MontantPrime".equals(pName)) {
      return m_montantPrime;
    }
    return null;
  }
  
  public Iterator _getPropertyNames()
    throws Exception
  {
    ArrayList liste = new ArrayList();
    liste.add("Nature");
    liste.add("Type");
    liste.add("IndicMontant");
    liste.add("DateDebutPrime");
    liste.add("DateFinPrime");
    liste.add("MontantPrime");
    return liste.iterator();
  }
  
  public ArrayList _getPropertyNames(ArrayList pListe)
    throws Exception
  {
    pListe.add("Nature");
    pListe.add("Type");
    pListe.add("IndicMontant");
    pListe.add("DateDebutPrime");
    pListe.add("DateFinPrime");
    pListe.add("MontantPrime");
    return pListe;
  }
  
  public void _setProperty(String pName, Object pValeur)
    throws Exception
  {
    if ("Nature".equals(pName)) {
      m_nature = ((String)pValeur);
    }
    if ("Type".equals(pName)) {
      m_type = ((String)pValeur);
    }
    if ("IndicMontant".equals(pName)) {
      m_indicMontant = ((String)pValeur);
    }
    if ("DateDebutPrime".equals(pName)) {
      m_dateDebutPrime = ((Damj)pValeur);
    }
    if ("DateFinPrime".equals(pName)) {
      m_dateFinPrime = ((Damj)pValeur);
    }
    if ("MontantPrime".equals(pName)) {
      m_montantPrime = ((BigDecimal)pValeur);
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
    if ("m_nature_C_ERR".equals(attrName)) {
      m_nature_C_ERR = pValeur;
    }
    if ("m_type_C_ERR".equals(attrName)) {
      m_type_C_ERR = pValeur;
    }
    if ("m_indicMontant_C_ERR".equals(attrName)) {
      m_indicMontant_C_ERR = pValeur;
    }
    if ("m_dateDebutPrime_C_ERR".equals(attrName)) {
      m_dateDebutPrime_C_ERR = pValeur;
    }
    if ("m_dateFinPrime_C_ERR".equals(attrName)) {
      m_dateFinPrime_C_ERR = pValeur;
    }
    if ("m_montantPrime_C_ERR".equals(attrName)) {
      m_montantPrime_C_ERR = pValeur;
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
    if ("m_nature_C_ERR".equals(attrName)) {
      return m_nature_C_ERR;
    }
    if ("m_type_C_ERR".equals(attrName)) {
      return m_type_C_ERR;
    }
    if ("m_indicMontant_C_ERR".equals(attrName)) {
      return m_indicMontant_C_ERR;
    }
    if ("m_dateDebutPrime_C_ERR".equals(attrName)) {
      return m_dateDebutPrime_C_ERR;
    }
    if ("m_dateFinPrime_C_ERR".equals(attrName)) {
      return m_dateFinPrime_C_ERR;
    }
    if ("m_montantPrime_C_ERR".equals(attrName)) {
      return m_montantPrime_C_ERR;
    }
    return null;
  }
  
  public boolean equals(Object pObjet)
  {
    if (!(pObjet instanceof _FluxPasDnaPeriodePrime)) {
      return false;
    }
    _FluxPasDnaPeriodePrime x = (_FluxPasDnaPeriodePrime)pObjet;
    if (m_nature == null)
    {
      if (m_nature != null) {
        return false;
      }
    }
    else
    {
      if (m_nature == null) {
        return false;
      }
      if (!m_nature.equals(m_nature)) {
        return false;
      }
    }
    if (m_type == null)
    {
      if (m_type != null) {
        return false;
      }
    }
    else
    {
      if (m_type == null) {
        return false;
      }
      if (!m_type.equals(m_type)) {
        return false;
      }
    }
    if (m_indicMontant == null)
    {
      if (m_indicMontant != null) {
        return false;
      }
    }
    else
    {
      if (m_indicMontant == null) {
        return false;
      }
      if (!m_indicMontant.equals(m_indicMontant)) {
        return false;
      }
    }
    if (m_dateDebutPrime == null)
    {
      if (m_dateDebutPrime != null) {
        return false;
      }
    }
    else
    {
      if (m_dateDebutPrime == null) {
        return false;
      }
      if (!m_dateDebutPrime.equals(m_dateDebutPrime)) {
        return false;
      }
    }
    if (m_dateFinPrime == null)
    {
      if (m_dateFinPrime != null) {
        return false;
      }
    }
    else
    {
      if (m_dateFinPrime == null) {
        return false;
      }
      if (!m_dateFinPrime.equals(m_dateFinPrime)) {
        return false;
      }
    }
    if (m_montantPrime == null)
    {
      if (m_montantPrime != null) {
        return false;
      }
    }
    else
    {
      if (m_montantPrime == null) {
        return false;
      }
      if (!m_montantPrime.equals(m_montantPrime)) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int result = 0;
    if (m_nature != null) {
      result += m_nature.hashCode();
    }
    if (m_type != null) {
      result += m_type.hashCode();
    }
    if (m_indicMontant != null) {
      result += m_indicMontant.hashCode();
    }
    if (m_dateDebutPrime != null) {
      result += m_dateDebutPrime.hashCode();
    }
    if (m_dateFinPrime != null) {
      result += m_dateFinPrime.hashCode();
    }
    if (m_montantPrime != null) {
      result += m_montantPrime.hashCode();
    }
    result *= 17;
    return result;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    _FluxPasDnaPeriodePrime clone_FluxPasDnaPeriodePrime = new _FluxPasDnaPeriodePrime();
    clone_FluxPasDnaPeriodePrime.populateFrom_FluxPasDnaPeriodePrime(this);
    return clone_FluxPasDnaPeriodePrime;
  }
  
  public void populateFrom_FluxPasDnaPeriodePrime(_FluxPasDnaPeriodePrime pSource)
  {
    setNature(pSource.getNature());setType(pSource.getType());setIndicMontant(pSource.getIndicMontant());setDateDebutPrime(pSource.getDateDebutPrime());setDateFinPrime(pSource.getDateFinPrime());setMontantPrime(pSource.getMontantPrime());
  }
  
  public String toString()
  {
    StringBuffer s = new StringBuffer("[_FluxPasDnaPeriodePrime");
    subToString(s);
    s.append("]");
    return s.toString();
  }
  
  protected void subToString(StringBuffer pSource)
  {
    pSource.append(", Nature: ");
    pSource.append(m_nature);
    pSource.append(", Type: ");
    pSource.append(m_type);
    pSource.append(", IndicMontant: ");
    pSource.append(m_indicMontant);
    pSource.append(", DateDebutPrime: ");
    pSource.append(m_dateDebutPrime);
    pSource.append(", DateFinPrime: ");
    pSource.append(m_dateFinPrime);
    pSource.append(", MontantPrime: ");
    pSource.append(m_montantPrime);
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
    pHandler.property("Nature", getNature(), new Attribute[] { new StringAttribute("C_ERR", getNature_C_ERR()) });
    
    pHandler.property("Type", getType(), new Attribute[] { new StringAttribute("C_ERR", getType_C_ERR()) });
    
    pHandler.property("IndicMontant", getIndicMontant(), new Attribute[] { new StringAttribute("C_ERR", getIndicMontant_C_ERR()) });
    
    pHandler.property("DateDebutPrime", getDateDebutPrime(), new Attribute[] { new StringAttribute("C_ERR", getDateDebutPrime_C_ERR()) });
    
    pHandler.property("DateFinPrime", getDateFinPrime(), new Attribute[] { new StringAttribute("C_ERR", getDateFinPrime_C_ERR()) });
    
    pHandler.property("MontantPrime", getMontantPrime(), new Attribute[] { new StringAttribute("C_ERR", getMontantPrime_C_ERR()) });
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
    setNature((String)pHandler.objectProperty("Nature", String.class));
    setNature_C_ERR(pHandler.stringAttribute("Nature", "C_ERR"));
    
    setType((String)pHandler.objectProperty("Type", String.class));
    setType_C_ERR(pHandler.stringAttribute("Type", "C_ERR"));
    
    setIndicMontant((String)pHandler.objectProperty("IndicMontant", String.class));
    setIndicMontant_C_ERR(pHandler.stringAttribute("IndicMontant", "C_ERR"));
    
    setDateDebutPrime((Damj)pHandler.objectProperty("DateDebutPrime", Damj.class));
    setDateDebutPrime_C_ERR(pHandler.stringAttribute("DateDebutPrime", "C_ERR"));
    
    setDateFinPrime((Damj)pHandler.objectProperty("DateFinPrime", Damj.class));
    setDateFinPrime_C_ERR(pHandler.stringAttribute("DateFinPrime", "C_ERR"));
    
    setMontantPrime((BigDecimal)pHandler.objectProperty("MontantPrime", BigDecimal.class));
    setMontantPrime_C_ERR(pHandler.stringAttribute("MontantPrime", "C_ERR"));
  }
  
  public String _getDatabeanName()
  {
    return "FluxPasDnaPeriodePrime";
  }
  
  public boolean _isValidProperty(String pElementName)
  {
    if ("Nature".equals(pElementName)) {
      return true;
    }
    if ("Type".equals(pElementName)) {
      return true;
    }
    if ("IndicMontant".equals(pElementName)) {
      return true;
    }
    if ("DateDebutPrime".equals(pElementName)) {
      return true;
    }
    if ("DateFinPrime".equals(pElementName)) {
      return true;
    }
    if ("MontantPrime".equals(pElementName)) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _FluxPasDnaPeriodePrime
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */