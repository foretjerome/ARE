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

public class _FluxFctDnaIndemniteVersee
  extends DataBeanImpl
  implements DataBean, Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  private String m__C_ETAT;
  private String m__IDENT;
  private String m_typeIndemnite;
  private String m_typeIndemnite_C_ERR;
  private String m_nature;
  private String m_nature_C_ERR;
  private String m_indicMontant;
  private String m_indicMontant_C_ERR;
  private Damj m_dateDebut;
  private String m_dateDebut_C_ERR;
  private Damj m_dateFin;
  private String m_dateFin_C_ERR;
  private BigDecimal m_montantIndemnite;
  private String m_montantIndemnite_C_ERR;
  
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
  
  public String getTypeIndemnite()
  {
    return m_typeIndemnite;
  }
  
  public String getTypeIndemnite_C_ERR()
  {
    return m_typeIndemnite_C_ERR;
  }
  
  public void setTypeIndemnite(String pValeur)
  {
    m_typeIndemnite = pValeur;
  }
  
  public void setTypeIndemnite_C_ERR(String pValeur_C_ERR)
  {
    m_typeIndemnite_C_ERR = pValeur_C_ERR;
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
  
  public Damj getDateDebut()
  {
    return m_dateDebut;
  }
  
  public String getDateDebut_C_ERR()
  {
    return m_dateDebut_C_ERR;
  }
  
  public void setDateDebut(Damj pValeur)
  {
    m_dateDebut = pValeur;
  }
  
  public void setDateDebut_C_ERR(String pValeur_C_ERR)
  {
    m_dateDebut_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDateFin()
  {
    return m_dateFin;
  }
  
  public String getDateFin_C_ERR()
  {
    return m_dateFin_C_ERR;
  }
  
  public void setDateFin(Damj pValeur)
  {
    m_dateFin = pValeur;
  }
  
  public void setDateFin_C_ERR(String pValeur_C_ERR)
  {
    m_dateFin_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getMontantIndemnite()
  {
    return m_montantIndemnite;
  }
  
  public String getMontantIndemnite_C_ERR()
  {
    return m_montantIndemnite_C_ERR;
  }
  
  public void setMontantIndemnite(BigDecimal pValeur)
  {
    m_montantIndemnite = pValeur;
  }
  
  public void setMontantIndemnite_C_ERR(String pValeur_C_ERR)
  {
    m_montantIndemnite_C_ERR = pValeur_C_ERR;
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
    if ("m_typeIndemnite_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_nature_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_indicMontant_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateDebut_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateFin_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_montantIndemnite_C_ERR".equals(attrName)) {
      return String.class;
    }
    return null;
  }
  
  public PropertyInfo _getPropertyInfo(String pElementName)
    throws TechniqueException
  {
    if ("TypeIndemnite".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("Nature".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("IndicMontant".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("DateDebut".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("DateFin".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("MontantIndemnite".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    return null;
  }
  
  public int _getPropertyLength(String pElementName)
  {
    if ("TypeIndemnite".equals(pElementName)) {
      return 3;
    }
    if ("Nature".equals(pElementName)) {
      return 1;
    }
    if ("IndicMontant".equals(pElementName)) {
      return 1;
    }
    if ("DateDebut".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("DateFin".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("MontantIndemnite".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    return -1;
  }
  
  public Object _getProperty(String pName)
    throws Exception
  {
    if ("TypeIndemnite".equals(pName)) {
      return m_typeIndemnite;
    }
    if ("Nature".equals(pName)) {
      return m_nature;
    }
    if ("IndicMontant".equals(pName)) {
      return m_indicMontant;
    }
    if ("DateDebut".equals(pName)) {
      return m_dateDebut;
    }
    if ("DateFin".equals(pName)) {
      return m_dateFin;
    }
    if ("MontantIndemnite".equals(pName)) {
      return m_montantIndemnite;
    }
    return null;
  }
  
  public Iterator _getPropertyNames()
    throws Exception
  {
    ArrayList liste = new ArrayList();
    liste.add("TypeIndemnite");
    liste.add("Nature");
    liste.add("IndicMontant");
    liste.add("DateDebut");
    liste.add("DateFin");
    liste.add("MontantIndemnite");
    return liste.iterator();
  }
  
  public ArrayList _getPropertyNames(ArrayList pListe)
    throws Exception
  {
    pListe.add("TypeIndemnite");
    pListe.add("Nature");
    pListe.add("IndicMontant");
    pListe.add("DateDebut");
    pListe.add("DateFin");
    pListe.add("MontantIndemnite");
    return pListe;
  }
  
  public void _setProperty(String pName, Object pValeur)
    throws Exception
  {
    if ("TypeIndemnite".equals(pName)) {
      m_typeIndemnite = ((String)pValeur);
    }
    if ("Nature".equals(pName)) {
      m_nature = ((String)pValeur);
    }
    if ("IndicMontant".equals(pName)) {
      m_indicMontant = ((String)pValeur);
    }
    if ("DateDebut".equals(pName)) {
      m_dateDebut = ((Damj)pValeur);
    }
    if ("DateFin".equals(pName)) {
      m_dateFin = ((Damj)pValeur);
    }
    if ("MontantIndemnite".equals(pName)) {
      m_montantIndemnite = ((BigDecimal)pValeur);
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
    if ("m_typeIndemnite_C_ERR".equals(attrName)) {
      m_typeIndemnite_C_ERR = pValeur;
    }
    if ("m_nature_C_ERR".equals(attrName)) {
      m_nature_C_ERR = pValeur;
    }
    if ("m_indicMontant_C_ERR".equals(attrName)) {
      m_indicMontant_C_ERR = pValeur;
    }
    if ("m_dateDebut_C_ERR".equals(attrName)) {
      m_dateDebut_C_ERR = pValeur;
    }
    if ("m_dateFin_C_ERR".equals(attrName)) {
      m_dateFin_C_ERR = pValeur;
    }
    if ("m_montantIndemnite_C_ERR".equals(attrName)) {
      m_montantIndemnite_C_ERR = pValeur;
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
    if ("m_typeIndemnite_C_ERR".equals(attrName)) {
      return m_typeIndemnite_C_ERR;
    }
    if ("m_nature_C_ERR".equals(attrName)) {
      return m_nature_C_ERR;
    }
    if ("m_indicMontant_C_ERR".equals(attrName)) {
      return m_indicMontant_C_ERR;
    }
    if ("m_dateDebut_C_ERR".equals(attrName)) {
      return m_dateDebut_C_ERR;
    }
    if ("m_dateFin_C_ERR".equals(attrName)) {
      return m_dateFin_C_ERR;
    }
    if ("m_montantIndemnite_C_ERR".equals(attrName)) {
      return m_montantIndemnite_C_ERR;
    }
    return null;
  }
  
  public boolean equals(Object pObjet)
  {
    if (!(pObjet instanceof _FluxFctDnaIndemniteVersee)) {
      return false;
    }
    _FluxFctDnaIndemniteVersee x = (_FluxFctDnaIndemniteVersee)pObjet;
    if (m_typeIndemnite == null)
    {
      if (m_typeIndemnite != null) {
        return false;
      }
    }
    else
    {
      if (m_typeIndemnite == null) {
        return false;
      }
      if (!m_typeIndemnite.equals(m_typeIndemnite)) {
        return false;
      }
    }
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
    if (m_montantIndemnite == null)
    {
      if (m_montantIndemnite != null) {
        return false;
      }
    }
    else
    {
      if (m_montantIndemnite == null) {
        return false;
      }
      if (!m_montantIndemnite.equals(m_montantIndemnite)) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int result = 0;
    if (m_typeIndemnite != null) {
      result += m_typeIndemnite.hashCode();
    }
    if (m_nature != null) {
      result += m_nature.hashCode();
    }
    if (m_indicMontant != null) {
      result += m_indicMontant.hashCode();
    }
    if (m_dateDebut != null) {
      result += m_dateDebut.hashCode();
    }
    if (m_dateFin != null) {
      result += m_dateFin.hashCode();
    }
    if (m_montantIndemnite != null) {
      result += m_montantIndemnite.hashCode();
    }
    result *= 17;
    return result;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    _FluxFctDnaIndemniteVersee clone_FluxFctDnaIndemniteVersee = new _FluxFctDnaIndemniteVersee();
    clone_FluxFctDnaIndemniteVersee.populateFrom_FluxFctDnaIndemniteVersee(this);
    return clone_FluxFctDnaIndemniteVersee;
  }
  
  public void populateFrom_FluxFctDnaIndemniteVersee(_FluxFctDnaIndemniteVersee pSource)
  {
    setTypeIndemnite(pSource.getTypeIndemnite());setNature(pSource.getNature());setIndicMontant(pSource.getIndicMontant());setDateDebut(pSource.getDateDebut());setDateFin(pSource.getDateFin());setMontantIndemnite(pSource.getMontantIndemnite());
  }
  
  public String toString()
  {
    StringBuffer s = new StringBuffer("[_FluxFctDnaIndemniteVersee");
    subToString(s);
    s.append("]");
    return s.toString();
  }
  
  protected void subToString(StringBuffer pSource)
  {
    pSource.append(", TypeIndemnite: ");
    pSource.append(m_typeIndemnite);
    pSource.append(", Nature: ");
    pSource.append(m_nature);
    pSource.append(", IndicMontant: ");
    pSource.append(m_indicMontant);
    pSource.append(", DateDebut: ");
    pSource.append(m_dateDebut);
    pSource.append(", DateFin: ");
    pSource.append(m_dateFin);
    pSource.append(", MontantIndemnite: ");
    pSource.append(m_montantIndemnite);
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
    pHandler.property("TypeIndemnite", getTypeIndemnite(), new Attribute[] { new StringAttribute("C_ERR", getTypeIndemnite_C_ERR()) });
    
    pHandler.property("Nature", getNature(), new Attribute[] { new StringAttribute("C_ERR", getNature_C_ERR()) });
    
    pHandler.property("IndicMontant", getIndicMontant(), new Attribute[] { new StringAttribute("C_ERR", getIndicMontant_C_ERR()) });
    
    pHandler.property("DateDebut", getDateDebut(), new Attribute[] { new StringAttribute("C_ERR", getDateDebut_C_ERR()) });
    
    pHandler.property("DateFin", getDateFin(), new Attribute[] { new StringAttribute("C_ERR", getDateFin_C_ERR()) });
    
    pHandler.property("MontantIndemnite", getMontantIndemnite(), new Attribute[] { new StringAttribute("C_ERR", getMontantIndemnite_C_ERR()) });
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
    setTypeIndemnite((String)pHandler.objectProperty("TypeIndemnite", String.class));
    setTypeIndemnite_C_ERR(pHandler.stringAttribute("TypeIndemnite", "C_ERR"));
    
    setNature((String)pHandler.objectProperty("Nature", String.class));
    setNature_C_ERR(pHandler.stringAttribute("Nature", "C_ERR"));
    
    setIndicMontant((String)pHandler.objectProperty("IndicMontant", String.class));
    setIndicMontant_C_ERR(pHandler.stringAttribute("IndicMontant", "C_ERR"));
    
    setDateDebut((Damj)pHandler.objectProperty("DateDebut", Damj.class));
    setDateDebut_C_ERR(pHandler.stringAttribute("DateDebut", "C_ERR"));
    
    setDateFin((Damj)pHandler.objectProperty("DateFin", Damj.class));
    setDateFin_C_ERR(pHandler.stringAttribute("DateFin", "C_ERR"));
    
    setMontantIndemnite((BigDecimal)pHandler.objectProperty("MontantIndemnite", BigDecimal.class));
    setMontantIndemnite_C_ERR(pHandler.stringAttribute("MontantIndemnite", "C_ERR"));
  }
  
  public String _getDatabeanName()
  {
    return "FluxFctDnaIndemniteVersee";
  }
  
  public boolean _isValidProperty(String pElementName)
  {
    if ("TypeIndemnite".equals(pElementName)) {
      return true;
    }
    if ("Nature".equals(pElementName)) {
      return true;
    }
    if ("IndicMontant".equals(pElementName)) {
      return true;
    }
    if ("DateDebut".equals(pElementName)) {
      return true;
    }
    if ("DateFin".equals(pElementName)) {
      return true;
    }
    if ("MontantIndemnite".equals(pElementName)) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _FluxFctDnaIndemniteVersee
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */