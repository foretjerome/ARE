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

public class _FluxPrimesIndemVerseesDsn
  extends DataBeanImpl
  implements DataBean, Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  private String m__C_ETAT;
  private String m__IDENT;
  private String m_typePrimeIndem;
  private String m_typePrimeIndem_C_ERR;
  private String m_signeMtantPrimeIndem;
  private String m_signeMtantPrimeIndem_C_ERR;
  private BigDecimal m_montantPrimeIndem;
  private String m_montantPrimeIndem_C_ERR;
  private Damj m_dateDebutPrime;
  private String m_dateDebutPrime_C_ERR;
  private Damj m_dateFinPrime;
  private String m_dateFinPrime_C_ERR;
  private Damj m_datePaiement;
  private String m_datePaiement_C_ERR;
  
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
  
  public String getTypePrimeIndem()
  {
    return m_typePrimeIndem;
  }
  
  public String getTypePrimeIndem_C_ERR()
  {
    return m_typePrimeIndem_C_ERR;
  }
  
  public void setTypePrimeIndem(String pValeur)
  {
    m_typePrimeIndem = pValeur;
  }
  
  public void setTypePrimeIndem_C_ERR(String pValeur_C_ERR)
  {
    m_typePrimeIndem_C_ERR = pValeur_C_ERR;
  }
  
  public String getSigneMtantPrimeIndem()
  {
    return m_signeMtantPrimeIndem;
  }
  
  public String getSigneMtantPrimeIndem_C_ERR()
  {
    return m_signeMtantPrimeIndem_C_ERR;
  }
  
  public void setSigneMtantPrimeIndem(String pValeur)
  {
    m_signeMtantPrimeIndem = pValeur;
  }
  
  public void setSigneMtantPrimeIndem_C_ERR(String pValeur_C_ERR)
  {
    m_signeMtantPrimeIndem_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getMontantPrimeIndem()
  {
    return m_montantPrimeIndem;
  }
  
  public String getMontantPrimeIndem_C_ERR()
  {
    return m_montantPrimeIndem_C_ERR;
  }
  
  public void setMontantPrimeIndem(BigDecimal pValeur)
  {
    m_montantPrimeIndem = pValeur;
  }
  
  public void setMontantPrimeIndem_C_ERR(String pValeur_C_ERR)
  {
    m_montantPrimeIndem_C_ERR = pValeur_C_ERR;
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
  
  public Damj getDatePaiement()
  {
    return m_datePaiement;
  }
  
  public String getDatePaiement_C_ERR()
  {
    return m_datePaiement_C_ERR;
  }
  
  public void setDatePaiement(Damj pValeur)
  {
    m_datePaiement = pValeur;
  }
  
  public void setDatePaiement_C_ERR(String pValeur_C_ERR)
  {
    m_datePaiement_C_ERR = pValeur_C_ERR;
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
    if ("m_typePrimeIndem_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_signeMtantPrimeIndem_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_montantPrimeIndem_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateDebutPrime_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateFinPrime_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_datePaiement_C_ERR".equals(attrName)) {
      return String.class;
    }
    return null;
  }
  
  public PropertyInfo _getPropertyInfo(String pElementName)
    throws TechniqueException
  {
    if ("typePrimeIndem".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("signeMtantPrimeIndem".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("montantPrimeIndem".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("dateDebutPrime".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("dateFinPrime".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("datePaiement".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    return null;
  }
  
  public int _getPropertyLength(String pElementName)
  {
    if ("typePrimeIndem".equals(pElementName)) {
      return 6;
    }
    if ("signeMtantPrimeIndem".equals(pElementName)) {
      return 1;
    }
    if ("montantPrimeIndem".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("dateDebutPrime".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("dateFinPrime".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("datePaiement".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    return -1;
  }
  
  public Object _getProperty(String pName)
    throws Exception
  {
    if ("typePrimeIndem".equals(pName)) {
      return m_typePrimeIndem;
    }
    if ("signeMtantPrimeIndem".equals(pName)) {
      return m_signeMtantPrimeIndem;
    }
    if ("montantPrimeIndem".equals(pName)) {
      return m_montantPrimeIndem;
    }
    if ("dateDebutPrime".equals(pName)) {
      return m_dateDebutPrime;
    }
    if ("dateFinPrime".equals(pName)) {
      return m_dateFinPrime;
    }
    if ("datePaiement".equals(pName)) {
      return m_datePaiement;
    }
    return null;
  }
  
  public Iterator _getPropertyNames()
    throws Exception
  {
    ArrayList liste = new ArrayList();
    liste.add("typePrimeIndem");
    liste.add("signeMtantPrimeIndem");
    liste.add("montantPrimeIndem");
    liste.add("dateDebutPrime");
    liste.add("dateFinPrime");
    liste.add("datePaiement");
    return liste.iterator();
  }
  
  public ArrayList _getPropertyNames(ArrayList pListe)
    throws Exception
  {
    pListe.add("typePrimeIndem");
    pListe.add("signeMtantPrimeIndem");
    pListe.add("montantPrimeIndem");
    pListe.add("dateDebutPrime");
    pListe.add("dateFinPrime");
    pListe.add("datePaiement");
    return pListe;
  }
  
  public void _setProperty(String pName, Object pValeur)
    throws Exception
  {
    if ("typePrimeIndem".equals(pName)) {
      m_typePrimeIndem = ((String)pValeur);
    }
    if ("signeMtantPrimeIndem".equals(pName)) {
      m_signeMtantPrimeIndem = ((String)pValeur);
    }
    if ("montantPrimeIndem".equals(pName)) {
      m_montantPrimeIndem = ((BigDecimal)pValeur);
    }
    if ("dateDebutPrime".equals(pName)) {
      m_dateDebutPrime = ((Damj)pValeur);
    }
    if ("dateFinPrime".equals(pName)) {
      m_dateFinPrime = ((Damj)pValeur);
    }
    if ("datePaiement".equals(pName)) {
      m_datePaiement = ((Damj)pValeur);
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
    if ("m_typePrimeIndem_C_ERR".equals(attrName)) {
      m_typePrimeIndem_C_ERR = pValeur;
    }
    if ("m_signeMtantPrimeIndem_C_ERR".equals(attrName)) {
      m_signeMtantPrimeIndem_C_ERR = pValeur;
    }
    if ("m_montantPrimeIndem_C_ERR".equals(attrName)) {
      m_montantPrimeIndem_C_ERR = pValeur;
    }
    if ("m_dateDebutPrime_C_ERR".equals(attrName)) {
      m_dateDebutPrime_C_ERR = pValeur;
    }
    if ("m_dateFinPrime_C_ERR".equals(attrName)) {
      m_dateFinPrime_C_ERR = pValeur;
    }
    if ("m_datePaiement_C_ERR".equals(attrName)) {
      m_datePaiement_C_ERR = pValeur;
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
    if ("m_typePrimeIndem_C_ERR".equals(attrName)) {
      return m_typePrimeIndem_C_ERR;
    }
    if ("m_signeMtantPrimeIndem_C_ERR".equals(attrName)) {
      return m_signeMtantPrimeIndem_C_ERR;
    }
    if ("m_montantPrimeIndem_C_ERR".equals(attrName)) {
      return m_montantPrimeIndem_C_ERR;
    }
    if ("m_dateDebutPrime_C_ERR".equals(attrName)) {
      return m_dateDebutPrime_C_ERR;
    }
    if ("m_dateFinPrime_C_ERR".equals(attrName)) {
      return m_dateFinPrime_C_ERR;
    }
    if ("m_datePaiement_C_ERR".equals(attrName)) {
      return m_datePaiement_C_ERR;
    }
    return null;
  }
  
  public boolean equals(Object pObjet)
  {
    if (!(pObjet instanceof _FluxPrimesIndemVerseesDsn)) {
      return false;
    }
    _FluxPrimesIndemVerseesDsn x = (_FluxPrimesIndemVerseesDsn)pObjet;
    if (m_typePrimeIndem == null)
    {
      if (m_typePrimeIndem != null) {
        return false;
      }
    }
    else
    {
      if (m_typePrimeIndem == null) {
        return false;
      }
      if (!m_typePrimeIndem.equals(m_typePrimeIndem)) {
        return false;
      }
    }
    if (m_signeMtantPrimeIndem == null)
    {
      if (m_signeMtantPrimeIndem != null) {
        return false;
      }
    }
    else
    {
      if (m_signeMtantPrimeIndem == null) {
        return false;
      }
      if (!m_signeMtantPrimeIndem.equals(m_signeMtantPrimeIndem)) {
        return false;
      }
    }
    if (m_montantPrimeIndem == null)
    {
      if (m_montantPrimeIndem != null) {
        return false;
      }
    }
    else
    {
      if (m_montantPrimeIndem == null) {
        return false;
      }
      if (!m_montantPrimeIndem.equals(m_montantPrimeIndem)) {
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
    if (m_datePaiement == null)
    {
      if (m_datePaiement != null) {
        return false;
      }
    }
    else
    {
      if (m_datePaiement == null) {
        return false;
      }
      if (!m_datePaiement.equals(m_datePaiement)) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int result = 0;
    if (m_typePrimeIndem != null) {
      result += m_typePrimeIndem.hashCode();
    }
    if (m_signeMtantPrimeIndem != null) {
      result += m_signeMtantPrimeIndem.hashCode();
    }
    if (m_montantPrimeIndem != null) {
      result += m_montantPrimeIndem.hashCode();
    }
    if (m_dateDebutPrime != null) {
      result += m_dateDebutPrime.hashCode();
    }
    if (m_dateFinPrime != null) {
      result += m_dateFinPrime.hashCode();
    }
    if (m_datePaiement != null) {
      result += m_datePaiement.hashCode();
    }
    result *= 17;
    return result;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    _FluxPrimesIndemVerseesDsn clone_FluxPrimesIndemVerseesDsn = new _FluxPrimesIndemVerseesDsn();
    clone_FluxPrimesIndemVerseesDsn.populateFrom_FluxPrimesIndemVerseesDsn(this);
    return clone_FluxPrimesIndemVerseesDsn;
  }
  
  public void populateFrom_FluxPrimesIndemVerseesDsn(_FluxPrimesIndemVerseesDsn pSource)
  {
    setTypePrimeIndem(pSource.getTypePrimeIndem());setSigneMtantPrimeIndem(pSource.getSigneMtantPrimeIndem());setMontantPrimeIndem(pSource.getMontantPrimeIndem());setDateDebutPrime(pSource.getDateDebutPrime());setDateFinPrime(pSource.getDateFinPrime());setDatePaiement(pSource.getDatePaiement());
  }
  
  public String toString()
  {
    StringBuffer s = new StringBuffer("[_FluxPrimesIndemVerseesDsn");
    subToString(s);
    s.append("]");
    return s.toString();
  }
  
  protected void subToString(StringBuffer pSource)
  {
    pSource.append(", typePrimeIndem: ");
    pSource.append(m_typePrimeIndem);
    pSource.append(", signeMtantPrimeIndem: ");
    pSource.append(m_signeMtantPrimeIndem);
    pSource.append(", montantPrimeIndem: ");
    pSource.append(m_montantPrimeIndem);
    pSource.append(", dateDebutPrime: ");
    pSource.append(m_dateDebutPrime);
    pSource.append(", dateFinPrime: ");
    pSource.append(m_dateFinPrime);
    pSource.append(", datePaiement: ");
    pSource.append(m_datePaiement);
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
    pHandler.property("typePrimeIndem", getTypePrimeIndem(), new Attribute[] { new StringAttribute("C_ERR", getTypePrimeIndem_C_ERR()) });
    
    pHandler.property("signeMtantPrimeIndem", getSigneMtantPrimeIndem(), new Attribute[] { new StringAttribute("C_ERR", getSigneMtantPrimeIndem_C_ERR()) });
    
    pHandler.property("montantPrimeIndem", getMontantPrimeIndem(), new Attribute[] { new StringAttribute("C_ERR", getMontantPrimeIndem_C_ERR()) });
    
    pHandler.property("dateDebutPrime", getDateDebutPrime(), new Attribute[] { new StringAttribute("C_ERR", getDateDebutPrime_C_ERR()) });
    
    pHandler.property("dateFinPrime", getDateFinPrime(), new Attribute[] { new StringAttribute("C_ERR", getDateFinPrime_C_ERR()) });
    
    pHandler.property("datePaiement", getDatePaiement(), new Attribute[] { new StringAttribute("C_ERR", getDatePaiement_C_ERR()) });
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
    setTypePrimeIndem((String)pHandler.objectProperty("typePrimeIndem", String.class));
    setTypePrimeIndem_C_ERR(pHandler.stringAttribute("typePrimeIndem", "C_ERR"));
    
    setSigneMtantPrimeIndem((String)pHandler.objectProperty("signeMtantPrimeIndem", String.class));
    setSigneMtantPrimeIndem_C_ERR(pHandler.stringAttribute("signeMtantPrimeIndem", "C_ERR"));
    
    setMontantPrimeIndem((BigDecimal)pHandler.objectProperty("montantPrimeIndem", BigDecimal.class));
    setMontantPrimeIndem_C_ERR(pHandler.stringAttribute("montantPrimeIndem", "C_ERR"));
    
    setDateDebutPrime((Damj)pHandler.objectProperty("dateDebutPrime", Damj.class));
    setDateDebutPrime_C_ERR(pHandler.stringAttribute("dateDebutPrime", "C_ERR"));
    
    setDateFinPrime((Damj)pHandler.objectProperty("dateFinPrime", Damj.class));
    setDateFinPrime_C_ERR(pHandler.stringAttribute("dateFinPrime", "C_ERR"));
    
    setDatePaiement((Damj)pHandler.objectProperty("datePaiement", Damj.class));
    setDatePaiement_C_ERR(pHandler.stringAttribute("datePaiement", "C_ERR"));
  }
  
  public String _getDatabeanName()
  {
    return "FluxPrimesIndemVerseesDsn";
  }
  
  public boolean _isValidProperty(String pElementName)
  {
    if ("typePrimeIndem".equals(pElementName)) {
      return true;
    }
    if ("signeMtantPrimeIndem".equals(pElementName)) {
      return true;
    }
    if ("montantPrimeIndem".equals(pElementName)) {
      return true;
    }
    if ("dateDebutPrime".equals(pElementName)) {
      return true;
    }
    if ("dateFinPrime".equals(pElementName)) {
      return true;
    }
    if ("datePaiement".equals(pElementName)) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _FluxPrimesIndemVerseesDsn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */