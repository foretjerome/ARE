package fr.pe.d12dal.service.es.dal;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.databean.Attribute;
import fr.unedic.archi.databean.DataBean;
import fr.unedic.archi.databean.DataBeanImpl;
import fr.unedic.archi.databean.GettersHandler;
import fr.unedic.archi.databean.PropertyInfo;
import fr.unedic.archi.databean.SettersHandler;
import fr.unedic.archi.databean.StringAttribute;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class _PeriodeAffiliation
  extends DataBeanImpl
  implements DataBean, Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  private String m__C_ETAT;
  private String m__IDENT;
  private Date m_dateDebut;
  private String m_dateDebut_C_ERR;
  private Date m_dateFin;
  private String m_dateFin_C_ERR;
  private String m_topPropositionCSP;
  private String m_topPropositionCSP_C_ERR;
  private String m_statutDeclaration;
  private String m_statutDeclaration_C_ERR;
  private String m_topPropositionPAP;
  private String m_topPropositionPAP_C_ERR;
  
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
  
  public Date getDateDebut()
  {
    return m_dateDebut;
  }
  
  public String getDateDebut_C_ERR()
  {
    return m_dateDebut_C_ERR;
  }
  
  public void setDateDebut(Date pValeur)
  {
    m_dateDebut = pValeur;
  }
  
  public void setDateDebut_C_ERR(String pValeur_C_ERR)
  {
    m_dateDebut_C_ERR = pValeur_C_ERR;
  }
  
  public Date getDateFin()
  {
    return m_dateFin;
  }
  
  public String getDateFin_C_ERR()
  {
    return m_dateFin_C_ERR;
  }
  
  public void setDateFin(Date pValeur)
  {
    m_dateFin = pValeur;
  }
  
  public void setDateFin_C_ERR(String pValeur_C_ERR)
  {
    m_dateFin_C_ERR = pValeur_C_ERR;
  }
  
  public String getTopPropositionCSP()
  {
    return m_topPropositionCSP;
  }
  
  public String getTopPropositionCSP_C_ERR()
  {
    return m_topPropositionCSP_C_ERR;
  }
  
  public void setTopPropositionCSP(String pValeur)
  {
    if (pValeur != null)
    {
      ExceptionUtil.assertMethodParamNotNull("pValeur (topPropositionCSP)", pValeur, String.class);
      if (pValeur.length() > _getPropertyLength("topPropositionCSP"))
      {
        TechniqueException t = new TechniqueException("JXX0100G", "Valeur trop longue pour l'attribut pValeur (topPropositionCSP).");
        throw new IndexOutOfBoundsException(t.toString());
      }
    }
    m_topPropositionCSP = pValeur;
  }
  
  public void setTopPropositionCSP_C_ERR(String pValeur_C_ERR)
  {
    m_topPropositionCSP_C_ERR = pValeur_C_ERR;
  }
  
  public String getStatutDeclaration()
  {
    return m_statutDeclaration;
  }
  
  public String getStatutDeclaration_C_ERR()
  {
    return m_statutDeclaration_C_ERR;
  }
  
  public void setStatutDeclaration(String pValeur)
  {
    if (pValeur != null)
    {
      ExceptionUtil.assertMethodParamNotNull("pValeur (statutDeclaration)", pValeur, String.class);
      if (pValeur.length() > _getPropertyLength("statutDeclaration"))
      {
        TechniqueException t = new TechniqueException("JXX0100G", "Valeur trop longue pour l'attribut pValeur (statutDeclaration).");
        throw new IndexOutOfBoundsException(t.toString());
      }
    }
    m_statutDeclaration = pValeur;
  }
  
  public void setStatutDeclaration_C_ERR(String pValeur_C_ERR)
  {
    m_statutDeclaration_C_ERR = pValeur_C_ERR;
  }
  
  public String getTopPropositionPAP()
  {
    return m_topPropositionPAP;
  }
  
  public String getTopPropositionPAP_C_ERR()
  {
    return m_topPropositionPAP_C_ERR;
  }
  
  public void setTopPropositionPAP(String pValeur)
  {
    if (pValeur != null)
    {
      ExceptionUtil.assertMethodParamNotNull("pValeur (topPropositionPAP)", pValeur, String.class);
      if (pValeur.length() > _getPropertyLength("topPropositionPAP"))
      {
        TechniqueException t = new TechniqueException("JXX0100G", "Valeur trop longue pour l'attribut pValeur (topPropositionPAP).");
        throw new IndexOutOfBoundsException(t.toString());
      }
    }
    m_topPropositionPAP = pValeur;
  }
  
  public void setTopPropositionPAP_C_ERR(String pValeur_C_ERR)
  {
    m_topPropositionPAP_C_ERR = pValeur_C_ERR;
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
    if ("m_dateDebut_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateFin_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_topPropositionCSP_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_statutDeclaration_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_topPropositionPAP_C_ERR".equals(attrName)) {
      return String.class;
    }
    return null;
  }
  
  public PropertyInfo _getPropertyInfo(String pElementName)
    throws TechniqueException
  {
    if ("dateDebut".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Date.class, false);
      return info;
    }
    if ("dateFin".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Date.class, false);
      return info;
    }
    if ("topPropositionCSP".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("statutDeclaration".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("topPropositionPAP".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    return null;
  }
  
  public int _getPropertyLength(String pElementName)
  {
    if ("dateDebut".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("dateFin".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("topPropositionCSP".equals(pElementName)) {
      return 1;
    }
    if ("statutDeclaration".equals(pElementName)) {
      return 1;
    }
    if ("topPropositionPAP".equals(pElementName)) {
      return 1;
    }
    return -1;
  }
  
  public Object _getProperty(String pName)
    throws Exception
  {
    if ("dateDebut".equals(pName)) {
      return m_dateDebut;
    }
    if ("dateFin".equals(pName)) {
      return m_dateFin;
    }
    if ("topPropositionCSP".equals(pName)) {
      return m_topPropositionCSP;
    }
    if ("statutDeclaration".equals(pName)) {
      return m_statutDeclaration;
    }
    if ("topPropositionPAP".equals(pName)) {
      return m_topPropositionPAP;
    }
    return null;
  }
  
  public Iterator _getPropertyNames()
    throws Exception
  {
    ArrayList liste = new ArrayList();
    liste.add("dateDebut");
    liste.add("dateFin");
    liste.add("topPropositionCSP");
    liste.add("statutDeclaration");
    liste.add("topPropositionPAP");
    return liste.iterator();
  }
  
  public ArrayList _getPropertyNames(ArrayList pListe)
    throws Exception
  {
    pListe.add("dateDebut");
    pListe.add("dateFin");
    pListe.add("topPropositionCSP");
    pListe.add("statutDeclaration");
    pListe.add("topPropositionPAP");
    return pListe;
  }
  
  public void _setProperty(String pName, Object pValeur)
    throws Exception
  {
    if ("dateDebut".equals(pName)) {
      m_dateDebut = ((Date)pValeur);
    }
    if ("dateFin".equals(pName)) {
      m_dateFin = ((Date)pValeur);
    }
    if ("topPropositionCSP".equals(pName))
    {
      if ((pValeur != null) && 
        (((String)pValeur).length() > _getPropertyLength("topPropositionCSP")))
      {
        TechniqueException t = new TechniqueException("JXX0100G", "Valeur trop longue pour l'attribut topPropositionCSP.");
        throw new IndexOutOfBoundsException(t.toString());
      }
      m_topPropositionCSP = ((String)pValeur);
    }
    if ("statutDeclaration".equals(pName))
    {
      if ((pValeur != null) && 
        (((String)pValeur).length() > _getPropertyLength("statutDeclaration")))
      {
        TechniqueException t = new TechniqueException("JXX0100G", "Valeur trop longue pour l'attribut statutDeclaration.");
        throw new IndexOutOfBoundsException(t.toString());
      }
      m_statutDeclaration = ((String)pValeur);
    }
    if ("topPropositionPAP".equals(pName))
    {
      if ((pValeur != null) && 
        (((String)pValeur).length() > _getPropertyLength("topPropositionPAP")))
      {
        TechniqueException t = new TechniqueException("JXX0100G", "Valeur trop longue pour l'attribut topPropositionPAP.");
        throw new IndexOutOfBoundsException(t.toString());
      }
      m_topPropositionPAP = ((String)pValeur);
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
    if ("m_dateDebut_C_ERR".equals(attrName)) {
      m_dateDebut_C_ERR = pValeur;
    }
    if ("m_dateFin_C_ERR".equals(attrName)) {
      m_dateFin_C_ERR = pValeur;
    }
    if ("m_topPropositionCSP_C_ERR".equals(attrName)) {
      m_topPropositionCSP_C_ERR = pValeur;
    }
    if ("m_statutDeclaration_C_ERR".equals(attrName)) {
      m_statutDeclaration_C_ERR = pValeur;
    }
    if ("m_topPropositionPAP_C_ERR".equals(attrName)) {
      m_topPropositionPAP_C_ERR = pValeur;
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
    if ("m_dateDebut_C_ERR".equals(attrName)) {
      return m_dateDebut_C_ERR;
    }
    if ("m_dateFin_C_ERR".equals(attrName)) {
      return m_dateFin_C_ERR;
    }
    if ("m_topPropositionCSP_C_ERR".equals(attrName)) {
      return m_topPropositionCSP_C_ERR;
    }
    if ("m_statutDeclaration_C_ERR".equals(attrName)) {
      return m_statutDeclaration_C_ERR;
    }
    if ("m_topPropositionPAP_C_ERR".equals(attrName)) {
      return m_topPropositionPAP_C_ERR;
    }
    return null;
  }
  
  public boolean equals(Object pObjet)
  {
    if (!(pObjet instanceof _PeriodeAffiliation)) {
      return false;
    }
    _PeriodeAffiliation x = (_PeriodeAffiliation)pObjet;
    if (m_dateDebut == null)
    {
      if (m_dateDebut != null) {
        return false;
      }
    }
    else
    {
      if (m_dateDebut == null) {
        return false;
      }
      if (!m_dateDebut.equals(m_dateDebut)) {
        return false;
      }
    }
    if (m_dateFin == null)
    {
      if (m_dateFin != null) {
        return false;
      }
    }
    else
    {
      if (m_dateFin == null) {
        return false;
      }
      if (!m_dateFin.equals(m_dateFin)) {
        return false;
      }
    }
    if (m_topPropositionCSP == null)
    {
      if (m_topPropositionCSP != null) {
        return false;
      }
    }
    else
    {
      if (m_topPropositionCSP == null) {
        return false;
      }
      if (!m_topPropositionCSP.equals(m_topPropositionCSP)) {
        return false;
      }
    }
    if (m_statutDeclaration == null)
    {
      if (m_statutDeclaration != null) {
        return false;
      }
    }
    else
    {
      if (m_statutDeclaration == null) {
        return false;
      }
      if (!m_statutDeclaration.equals(m_statutDeclaration)) {
        return false;
      }
    }
    if (m_topPropositionPAP == null)
    {
      if (m_topPropositionPAP != null) {
        return false;
      }
    }
    else
    {
      if (m_topPropositionPAP == null) {
        return false;
      }
      if (!m_topPropositionPAP.equals(m_topPropositionPAP)) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int result = 0;
    if (m_dateDebut != null) {
      result += m_dateDebut.hashCode();
    }
    if (m_dateFin != null) {
      result += m_dateFin.hashCode();
    }
    if (m_topPropositionCSP != null) {
      result += m_topPropositionCSP.hashCode();
    }
    if (m_statutDeclaration != null) {
      result += m_statutDeclaration.hashCode();
    }
    if (m_topPropositionPAP != null) {
      result += m_topPropositionPAP.hashCode();
    }
    result *= 17;
    return result;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    _PeriodeAffiliation clone_PeriodeAffiliation = new _PeriodeAffiliation();
    clone_PeriodeAffiliation.populateFrom_PeriodeAffiliation(this);
    return clone_PeriodeAffiliation;
  }
  
  public void populateFrom_PeriodeAffiliation(_PeriodeAffiliation pSource)
  {
    setDateDebut(pSource.getDateDebut());setDateFin(pSource.getDateFin());setTopPropositionCSP(pSource.getTopPropositionCSP());setStatutDeclaration(pSource.getStatutDeclaration());setTopPropositionPAP(pSource.getTopPropositionPAP());
  }
  
  public String toString()
  {
    StringBuffer s = new StringBuffer("[_PeriodeAffiliation");
    subToString(s);
    s.append("]");
    return s.toString();
  }
  
  protected void subToString(StringBuffer pSource)
  {
    pSource.append(", dateDebut: ");
    pSource.append(m_dateDebut);
    pSource.append(", dateFin: ");
    pSource.append(m_dateFin);
    pSource.append(", topPropositionCSP: ");
    pSource.append(m_topPropositionCSP);
    pSource.append(", statutDeclaration: ");
    pSource.append(m_statutDeclaration);
    pSource.append(", topPropositionPAP: ");
    pSource.append(m_topPropositionPAP);
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
    pHandler.property("dateDebut", getDateDebut(), new Attribute[] { new StringAttribute("C_ERR", getDateDebut_C_ERR()) });
    
    pHandler.property("dateFin", getDateFin(), new Attribute[] { new StringAttribute("C_ERR", getDateFin_C_ERR()) });
    
    pHandler.property("topPropositionCSP", getTopPropositionCSP(), new Attribute[] { new StringAttribute("C_ERR", getTopPropositionCSP_C_ERR()) });
    
    pHandler.property("statutDeclaration", getStatutDeclaration(), new Attribute[] { new StringAttribute("C_ERR", getStatutDeclaration_C_ERR()) });
    
    pHandler.property("topPropositionPAP", getTopPropositionPAP(), new Attribute[] { new StringAttribute("C_ERR", getTopPropositionPAP_C_ERR()) });
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
    setDateDebut((Date)pHandler.objectProperty("dateDebut", Date.class));
    setDateDebut_C_ERR(pHandler.stringAttribute("dateDebut", "C_ERR"));
    
    setDateFin((Date)pHandler.objectProperty("dateFin", Date.class));
    setDateFin_C_ERR(pHandler.stringAttribute("dateFin", "C_ERR"));
    
    setTopPropositionCSP((String)pHandler.objectProperty("topPropositionCSP", String.class));
    setTopPropositionCSP_C_ERR(pHandler.stringAttribute("topPropositionCSP", "C_ERR"));
    
    setStatutDeclaration((String)pHandler.objectProperty("statutDeclaration", String.class));
    setStatutDeclaration_C_ERR(pHandler.stringAttribute("statutDeclaration", "C_ERR"));
    
    setTopPropositionPAP((String)pHandler.objectProperty("topPropositionPAP", String.class));
    setTopPropositionPAP_C_ERR(pHandler.stringAttribute("topPropositionPAP", "C_ERR"));
  }
  
  public String _getDatabeanName()
  {
    return "PeriodeAffiliation";
  }
  
  public boolean _isValidProperty(String pElementName)
  {
    if ("dateDebut".equals(pElementName)) {
      return true;
    }
    if ("dateFin".equals(pElementName)) {
      return true;
    }
    if ("topPropositionCSP".equals(pElementName)) {
      return true;
    }
    if ("statutDeclaration".equals(pElementName)) {
      return true;
    }
    if ("topPropositionPAP".equals(pElementName)) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _PeriodeAffiliation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */