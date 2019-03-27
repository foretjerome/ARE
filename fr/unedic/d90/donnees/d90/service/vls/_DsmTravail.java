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

public class _DsmTravail
  extends DataBeanImpl
  implements DataBean, Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  private String m__C_ETAT;
  private String m__IDENT;
  private String m_raisonSociale;
  private String m_raisonSociale_C_ERR;
  private Damj m_dateDebutTravail;
  private String m_dateDebutTravail_C_ERR;
  private Damj m_dateFinTravail;
  private String m_dateFinTravail_C_ERR;
  private BigDecimal m_salaireBrut;
  private String m_salaireBrut_C_ERR;
  private BigDecimal m_nbreHeuresDeclarees;
  private String m_nbreHeuresDeclarees_C_ERR;
  private BigDecimal m_nbreCachetsDeclares;
  private String m_nbreCachetsDeclares_C_ERR;
  
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
  
  public String getRaisonSociale()
  {
    return m_raisonSociale;
  }
  
  public String getRaisonSociale_C_ERR()
  {
    return m_raisonSociale_C_ERR;
  }
  
  public void setRaisonSociale(String pValeur)
  {
    m_raisonSociale = pValeur;
  }
  
  public void setRaisonSociale_C_ERR(String pValeur_C_ERR)
  {
    m_raisonSociale_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDateDebutTravail()
  {
    return m_dateDebutTravail;
  }
  
  public String getDateDebutTravail_C_ERR()
  {
    return m_dateDebutTravail_C_ERR;
  }
  
  public void setDateDebutTravail(Damj pValeur)
  {
    m_dateDebutTravail = pValeur;
  }
  
  public void setDateDebutTravail_C_ERR(String pValeur_C_ERR)
  {
    m_dateDebutTravail_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDateFinTravail()
  {
    return m_dateFinTravail;
  }
  
  public String getDateFinTravail_C_ERR()
  {
    return m_dateFinTravail_C_ERR;
  }
  
  public void setDateFinTravail(Damj pValeur)
  {
    m_dateFinTravail = pValeur;
  }
  
  public void setDateFinTravail_C_ERR(String pValeur_C_ERR)
  {
    m_dateFinTravail_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getSalaireBrut()
  {
    return m_salaireBrut;
  }
  
  public String getSalaireBrut_C_ERR()
  {
    return m_salaireBrut_C_ERR;
  }
  
  public void setSalaireBrut(BigDecimal pValeur)
  {
    m_salaireBrut = pValeur;
  }
  
  public void setSalaireBrut_C_ERR(String pValeur_C_ERR)
  {
    m_salaireBrut_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getNbreHeuresDeclarees()
  {
    return m_nbreHeuresDeclarees;
  }
  
  public String getNbreHeuresDeclarees_C_ERR()
  {
    return m_nbreHeuresDeclarees_C_ERR;
  }
  
  public void setNbreHeuresDeclarees(BigDecimal pValeur)
  {
    m_nbreHeuresDeclarees = pValeur;
  }
  
  public void setNbreHeuresDeclarees_C_ERR(String pValeur_C_ERR)
  {
    m_nbreHeuresDeclarees_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getNbreCachetsDeclares()
  {
    return m_nbreCachetsDeclares;
  }
  
  public String getNbreCachetsDeclares_C_ERR()
  {
    return m_nbreCachetsDeclares_C_ERR;
  }
  
  public void setNbreCachetsDeclares(BigDecimal pValeur)
  {
    m_nbreCachetsDeclares = pValeur;
  }
  
  public void setNbreCachetsDeclares_C_ERR(String pValeur_C_ERR)
  {
    m_nbreCachetsDeclares_C_ERR = pValeur_C_ERR;
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
    if ("m_raisonSociale_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateDebutTravail_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateFinTravail_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_salaireBrut_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_nbreHeuresDeclarees_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_nbreCachetsDeclares_C_ERR".equals(attrName)) {
      return String.class;
    }
    return null;
  }
  
  public PropertyInfo _getPropertyInfo(String pElementName)
    throws TechniqueException
  {
    if ("RaisonSociale".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("DateDebutTravail".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("DateFinTravail".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("SalaireBrut".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("NbreHeuresDeclarees".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("NbreCachetsDeclares".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    return null;
  }
  
  public int _getPropertyLength(String pElementName)
  {
    if ("RaisonSociale".equals(pElementName)) {
      return 27;
    }
    if ("DateDebutTravail".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("DateFinTravail".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("SalaireBrut".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("NbreHeuresDeclarees".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("NbreCachetsDeclares".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    return -1;
  }
  
  public Object _getProperty(String pName)
    throws Exception
  {
    if ("RaisonSociale".equals(pName)) {
      return m_raisonSociale;
    }
    if ("DateDebutTravail".equals(pName)) {
      return m_dateDebutTravail;
    }
    if ("DateFinTravail".equals(pName)) {
      return m_dateFinTravail;
    }
    if ("SalaireBrut".equals(pName)) {
      return m_salaireBrut;
    }
    if ("NbreHeuresDeclarees".equals(pName)) {
      return m_nbreHeuresDeclarees;
    }
    if ("NbreCachetsDeclares".equals(pName)) {
      return m_nbreCachetsDeclares;
    }
    return null;
  }
  
  public Iterator _getPropertyNames()
    throws Exception
  {
    ArrayList liste = new ArrayList();
    liste.add("RaisonSociale");
    liste.add("DateDebutTravail");
    liste.add("DateFinTravail");
    liste.add("SalaireBrut");
    liste.add("NbreHeuresDeclarees");
    liste.add("NbreCachetsDeclares");
    return liste.iterator();
  }
  
  public ArrayList _getPropertyNames(ArrayList pListe)
    throws Exception
  {
    pListe.add("RaisonSociale");
    pListe.add("DateDebutTravail");
    pListe.add("DateFinTravail");
    pListe.add("SalaireBrut");
    pListe.add("NbreHeuresDeclarees");
    pListe.add("NbreCachetsDeclares");
    return pListe;
  }
  
  public void _setProperty(String pName, Object pValeur)
    throws Exception
  {
    if ("RaisonSociale".equals(pName)) {
      m_raisonSociale = ((String)pValeur);
    }
    if ("DateDebutTravail".equals(pName)) {
      m_dateDebutTravail = ((Damj)pValeur);
    }
    if ("DateFinTravail".equals(pName)) {
      m_dateFinTravail = ((Damj)pValeur);
    }
    if ("SalaireBrut".equals(pName)) {
      m_salaireBrut = ((BigDecimal)pValeur);
    }
    if ("NbreHeuresDeclarees".equals(pName)) {
      m_nbreHeuresDeclarees = ((BigDecimal)pValeur);
    }
    if ("NbreCachetsDeclares".equals(pName)) {
      m_nbreCachetsDeclares = ((BigDecimal)pValeur);
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
    if ("m_raisonSociale_C_ERR".equals(attrName)) {
      m_raisonSociale_C_ERR = pValeur;
    }
    if ("m_dateDebutTravail_C_ERR".equals(attrName)) {
      m_dateDebutTravail_C_ERR = pValeur;
    }
    if ("m_dateFinTravail_C_ERR".equals(attrName)) {
      m_dateFinTravail_C_ERR = pValeur;
    }
    if ("m_salaireBrut_C_ERR".equals(attrName)) {
      m_salaireBrut_C_ERR = pValeur;
    }
    if ("m_nbreHeuresDeclarees_C_ERR".equals(attrName)) {
      m_nbreHeuresDeclarees_C_ERR = pValeur;
    }
    if ("m_nbreCachetsDeclares_C_ERR".equals(attrName)) {
      m_nbreCachetsDeclares_C_ERR = pValeur;
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
    if ("m_raisonSociale_C_ERR".equals(attrName)) {
      return m_raisonSociale_C_ERR;
    }
    if ("m_dateDebutTravail_C_ERR".equals(attrName)) {
      return m_dateDebutTravail_C_ERR;
    }
    if ("m_dateFinTravail_C_ERR".equals(attrName)) {
      return m_dateFinTravail_C_ERR;
    }
    if ("m_salaireBrut_C_ERR".equals(attrName)) {
      return m_salaireBrut_C_ERR;
    }
    if ("m_nbreHeuresDeclarees_C_ERR".equals(attrName)) {
      return m_nbreHeuresDeclarees_C_ERR;
    }
    if ("m_nbreCachetsDeclares_C_ERR".equals(attrName)) {
      return m_nbreCachetsDeclares_C_ERR;
    }
    return null;
  }
  
  public boolean equals(Object pObjet)
  {
    if (!(pObjet instanceof _DsmTravail)) {
      return false;
    }
    _DsmTravail x = (_DsmTravail)pObjet;
    if (m_raisonSociale == null)
    {
      if (m_raisonSociale != null) {
        return false;
      }
    }
    else
    {
      if (m_raisonSociale == null) {
        return false;
      }
      if (!m_raisonSociale.equals(m_raisonSociale)) {
        return false;
      }
    }
    if (m_dateDebutTravail == null)
    {
      if (m_dateDebutTravail != null) {
        return false;
      }
    }
    else
    {
      if (m_dateDebutTravail == null) {
        return false;
      }
      if (!m_dateDebutTravail.equals(m_dateDebutTravail)) {
        return false;
      }
    }
    if (m_dateFinTravail == null)
    {
      if (m_dateFinTravail != null) {
        return false;
      }
    }
    else
    {
      if (m_dateFinTravail == null) {
        return false;
      }
      if (!m_dateFinTravail.equals(m_dateFinTravail)) {
        return false;
      }
    }
    if (m_salaireBrut == null)
    {
      if (m_salaireBrut != null) {
        return false;
      }
    }
    else
    {
      if (m_salaireBrut == null) {
        return false;
      }
      if (!m_salaireBrut.equals(m_salaireBrut)) {
        return false;
      }
    }
    if (m_nbreHeuresDeclarees == null)
    {
      if (m_nbreHeuresDeclarees != null) {
        return false;
      }
    }
    else
    {
      if (m_nbreHeuresDeclarees == null) {
        return false;
      }
      if (!m_nbreHeuresDeclarees.equals(m_nbreHeuresDeclarees)) {
        return false;
      }
    }
    if (m_nbreCachetsDeclares == null)
    {
      if (m_nbreCachetsDeclares != null) {
        return false;
      }
    }
    else
    {
      if (m_nbreCachetsDeclares == null) {
        return false;
      }
      if (!m_nbreCachetsDeclares.equals(m_nbreCachetsDeclares)) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int result = 0;
    if (m_raisonSociale != null) {
      result += m_raisonSociale.hashCode();
    }
    if (m_dateDebutTravail != null) {
      result += m_dateDebutTravail.hashCode();
    }
    if (m_dateFinTravail != null) {
      result += m_dateFinTravail.hashCode();
    }
    if (m_salaireBrut != null) {
      result += m_salaireBrut.hashCode();
    }
    if (m_nbreHeuresDeclarees != null) {
      result += m_nbreHeuresDeclarees.hashCode();
    }
    if (m_nbreCachetsDeclares != null) {
      result += m_nbreCachetsDeclares.hashCode();
    }
    result *= 17;
    return result;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    _DsmTravail clone_DsmTravail = new _DsmTravail();
    clone_DsmTravail.populateFrom_DsmTravail(this);
    return clone_DsmTravail;
  }
  
  public void populateFrom_DsmTravail(_DsmTravail pSource)
  {
    setRaisonSociale(pSource.getRaisonSociale());setDateDebutTravail(pSource.getDateDebutTravail());setDateFinTravail(pSource.getDateFinTravail());setSalaireBrut(pSource.getSalaireBrut());setNbreHeuresDeclarees(pSource.getNbreHeuresDeclarees());setNbreCachetsDeclares(pSource.getNbreCachetsDeclares());
  }
  
  public String toString()
  {
    StringBuffer s = new StringBuffer("[_DsmTravail");
    subToString(s);
    s.append("]");
    return s.toString();
  }
  
  protected void subToString(StringBuffer pSource)
  {
    pSource.append(", RaisonSociale: ");
    pSource.append(m_raisonSociale);
    pSource.append(", DateDebutTravail: ");
    pSource.append(m_dateDebutTravail);
    pSource.append(", DateFinTravail: ");
    pSource.append(m_dateFinTravail);
    pSource.append(", SalaireBrut: ");
    pSource.append(m_salaireBrut);
    pSource.append(", NbreHeuresDeclarees: ");
    pSource.append(m_nbreHeuresDeclarees);
    pSource.append(", NbreCachetsDeclares: ");
    pSource.append(m_nbreCachetsDeclares);
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
    pHandler.property("RaisonSociale", getRaisonSociale(), new Attribute[] { new StringAttribute("C_ERR", getRaisonSociale_C_ERR()) });
    
    pHandler.property("DateDebutTravail", getDateDebutTravail(), new Attribute[] { new StringAttribute("C_ERR", getDateDebutTravail_C_ERR()) });
    
    pHandler.property("DateFinTravail", getDateFinTravail(), new Attribute[] { new StringAttribute("C_ERR", getDateFinTravail_C_ERR()) });
    
    pHandler.property("SalaireBrut", getSalaireBrut(), new Attribute[] { new StringAttribute("C_ERR", getSalaireBrut_C_ERR()) });
    
    pHandler.property("NbreHeuresDeclarees", getNbreHeuresDeclarees(), new Attribute[] { new StringAttribute("C_ERR", getNbreHeuresDeclarees_C_ERR()) });
    
    pHandler.property("NbreCachetsDeclares", getNbreCachetsDeclares(), new Attribute[] { new StringAttribute("C_ERR", getNbreCachetsDeclares_C_ERR()) });
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
    setRaisonSociale((String)pHandler.objectProperty("RaisonSociale", String.class));
    setRaisonSociale_C_ERR(pHandler.stringAttribute("RaisonSociale", "C_ERR"));
    
    setDateDebutTravail((Damj)pHandler.objectProperty("DateDebutTravail", Damj.class));
    setDateDebutTravail_C_ERR(pHandler.stringAttribute("DateDebutTravail", "C_ERR"));
    
    setDateFinTravail((Damj)pHandler.objectProperty("DateFinTravail", Damj.class));
    setDateFinTravail_C_ERR(pHandler.stringAttribute("DateFinTravail", "C_ERR"));
    
    setSalaireBrut((BigDecimal)pHandler.objectProperty("SalaireBrut", BigDecimal.class));
    setSalaireBrut_C_ERR(pHandler.stringAttribute("SalaireBrut", "C_ERR"));
    
    setNbreHeuresDeclarees((BigDecimal)pHandler.objectProperty("NbreHeuresDeclarees", BigDecimal.class));
    setNbreHeuresDeclarees_C_ERR(pHandler.stringAttribute("NbreHeuresDeclarees", "C_ERR"));
    
    setNbreCachetsDeclares((BigDecimal)pHandler.objectProperty("NbreCachetsDeclares", BigDecimal.class));
    setNbreCachetsDeclares_C_ERR(pHandler.stringAttribute("NbreCachetsDeclares", "C_ERR"));
  }
  
  public String _getDatabeanName()
  {
    return "DsmTravail";
  }
  
  public boolean _isValidProperty(String pElementName)
  {
    if ("RaisonSociale".equals(pElementName)) {
      return true;
    }
    if ("DateDebutTravail".equals(pElementName)) {
      return true;
    }
    if ("DateFinTravail".equals(pElementName)) {
      return true;
    }
    if ("SalaireBrut".equals(pElementName)) {
      return true;
    }
    if ("NbreHeuresDeclarees".equals(pElementName)) {
      return true;
    }
    if ("NbreCachetsDeclares".equals(pElementName)) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _DsmTravail
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */