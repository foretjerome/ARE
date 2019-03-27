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
import java.util.ArrayList;
import java.util.Iterator;

public class _FluxCaliDeseng
  extends DataBeanImpl
  implements DataBean, Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  private String m__C_ETAT;
  private String m__IDENT;
  private String m_cxala;
  private String m_cxala_C_ERR;
  private String m_rsin;
  private String m_rsin_C_ERR;
  private String m_cxass;
  private String m_cxass_C_ERR;
  private Damj m_dateAppel;
  private String m_dateAppel_C_ERR;
  private String m_idAide;
  private String m_idAide_C_ERR;
  
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
  
  public String getCxala()
  {
    return m_cxala;
  }
  
  public String getCxala_C_ERR()
  {
    return m_cxala_C_ERR;
  }
  
  public void setCxala(String pValeur)
  {
    m_cxala = pValeur;
  }
  
  public void setCxala_C_ERR(String pValeur_C_ERR)
  {
    m_cxala_C_ERR = pValeur_C_ERR;
  }
  
  public String getRsin()
  {
    return m_rsin;
  }
  
  public String getRsin_C_ERR()
  {
    return m_rsin_C_ERR;
  }
  
  public void setRsin(String pValeur)
  {
    m_rsin = pValeur;
  }
  
  public void setRsin_C_ERR(String pValeur_C_ERR)
  {
    m_rsin_C_ERR = pValeur_C_ERR;
  }
  
  public String getCxass()
  {
    return m_cxass;
  }
  
  public String getCxass_C_ERR()
  {
    return m_cxass_C_ERR;
  }
  
  public void setCxass(String pValeur)
  {
    m_cxass = pValeur;
  }
  
  public void setCxass_C_ERR(String pValeur_C_ERR)
  {
    m_cxass_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDateAppel()
  {
    return m_dateAppel;
  }
  
  public String getDateAppel_C_ERR()
  {
    return m_dateAppel_C_ERR;
  }
  
  public void setDateAppel(Damj pValeur)
  {
    m_dateAppel = pValeur;
  }
  
  public void setDateAppel_C_ERR(String pValeur_C_ERR)
  {
    m_dateAppel_C_ERR = pValeur_C_ERR;
  }
  
  public String getIdAide()
  {
    return m_idAide;
  }
  
  public String getIdAide_C_ERR()
  {
    return m_idAide_C_ERR;
  }
  
  public void setIdAide(String pValeur)
  {
    m_idAide = pValeur;
  }
  
  public void setIdAide_C_ERR(String pValeur_C_ERR)
  {
    m_idAide_C_ERR = pValeur_C_ERR;
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
    if ("m_cxala_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_rsin_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_cxass_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateAppel_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_idAide_C_ERR".equals(attrName)) {
      return String.class;
    }
    return null;
  }
  
  public PropertyInfo _getPropertyInfo(String pElementName)
    throws TechniqueException
  {
    if ("Cxala".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("Rsin".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("Cxass".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("DateAppel".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("IdAide".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    return null;
  }
  
  public int _getPropertyLength(String pElementName)
  {
    if ("Cxala".equals(pElementName)) {
      return 10;
    }
    if ("Rsin".equals(pElementName)) {
      return 7;
    }
    if ("Cxass".equals(pElementName)) {
      return 2;
    }
    if ("DateAppel".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("IdAide".equals(pElementName)) {
      return 7;
    }
    return -1;
  }
  
  public Object _getProperty(String pName)
    throws Exception
  {
    if ("Cxala".equals(pName)) {
      return m_cxala;
    }
    if ("Rsin".equals(pName)) {
      return m_rsin;
    }
    if ("Cxass".equals(pName)) {
      return m_cxass;
    }
    if ("DateAppel".equals(pName)) {
      return m_dateAppel;
    }
    if ("IdAide".equals(pName)) {
      return m_idAide;
    }
    return null;
  }
  
  public Iterator _getPropertyNames()
    throws Exception
  {
    ArrayList liste = new ArrayList();
    liste.add("Cxala");
    liste.add("Rsin");
    liste.add("Cxass");
    liste.add("DateAppel");
    liste.add("IdAide");
    return liste.iterator();
  }
  
  public ArrayList _getPropertyNames(ArrayList pListe)
    throws Exception
  {
    pListe.add("Cxala");
    pListe.add("Rsin");
    pListe.add("Cxass");
    pListe.add("DateAppel");
    pListe.add("IdAide");
    return pListe;
  }
  
  public void _setProperty(String pName, Object pValeur)
    throws Exception
  {
    if ("Cxala".equals(pName)) {
      m_cxala = ((String)pValeur);
    }
    if ("Rsin".equals(pName)) {
      m_rsin = ((String)pValeur);
    }
    if ("Cxass".equals(pName)) {
      m_cxass = ((String)pValeur);
    }
    if ("DateAppel".equals(pName)) {
      m_dateAppel = ((Damj)pValeur);
    }
    if ("IdAide".equals(pName)) {
      m_idAide = ((String)pValeur);
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
    if ("m_cxala_C_ERR".equals(attrName)) {
      m_cxala_C_ERR = pValeur;
    }
    if ("m_rsin_C_ERR".equals(attrName)) {
      m_rsin_C_ERR = pValeur;
    }
    if ("m_cxass_C_ERR".equals(attrName)) {
      m_cxass_C_ERR = pValeur;
    }
    if ("m_dateAppel_C_ERR".equals(attrName)) {
      m_dateAppel_C_ERR = pValeur;
    }
    if ("m_idAide_C_ERR".equals(attrName)) {
      m_idAide_C_ERR = pValeur;
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
    if ("m_cxala_C_ERR".equals(attrName)) {
      return m_cxala_C_ERR;
    }
    if ("m_rsin_C_ERR".equals(attrName)) {
      return m_rsin_C_ERR;
    }
    if ("m_cxass_C_ERR".equals(attrName)) {
      return m_cxass_C_ERR;
    }
    if ("m_dateAppel_C_ERR".equals(attrName)) {
      return m_dateAppel_C_ERR;
    }
    if ("m_idAide_C_ERR".equals(attrName)) {
      return m_idAide_C_ERR;
    }
    return null;
  }
  
  public boolean equals(Object pObjet)
  {
    if (!(pObjet instanceof _FluxCaliDeseng)) {
      return false;
    }
    _FluxCaliDeseng x = (_FluxCaliDeseng)pObjet;
    if (m_cxala == null)
    {
      if (m_cxala != null) {
        return false;
      }
    }
    else
    {
      if (m_cxala == null) {
        return false;
      }
      if (!m_cxala.equals(m_cxala)) {
        return false;
      }
    }
    if (m_rsin == null)
    {
      if (m_rsin != null) {
        return false;
      }
    }
    else
    {
      if (m_rsin == null) {
        return false;
      }
      if (!m_rsin.equals(m_rsin)) {
        return false;
      }
    }
    if (m_cxass == null)
    {
      if (m_cxass != null) {
        return false;
      }
    }
    else
    {
      if (m_cxass == null) {
        return false;
      }
      if (!m_cxass.equals(m_cxass)) {
        return false;
      }
    }
    if (m_dateAppel == null)
    {
      if (m_dateAppel != null) {
        return false;
      }
    }
    else
    {
      if (m_dateAppel == null) {
        return false;
      }
      if (!m_dateAppel.equals(m_dateAppel)) {
        return false;
      }
    }
    if (m_idAide == null)
    {
      if (m_idAide != null) {
        return false;
      }
    }
    else
    {
      if (m_idAide == null) {
        return false;
      }
      if (!m_idAide.equals(m_idAide)) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int result = 0;
    if (m_cxala != null) {
      result += m_cxala.hashCode();
    }
    if (m_rsin != null) {
      result += m_rsin.hashCode();
    }
    if (m_cxass != null) {
      result += m_cxass.hashCode();
    }
    if (m_dateAppel != null) {
      result += m_dateAppel.hashCode();
    }
    if (m_idAide != null) {
      result += m_idAide.hashCode();
    }
    result *= 17;
    return result;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    _FluxCaliDeseng clone_FluxCaliDeseng = new _FluxCaliDeseng();
    clone_FluxCaliDeseng.populateFrom_FluxCaliDeseng(this);
    return clone_FluxCaliDeseng;
  }
  
  public void populateFrom_FluxCaliDeseng(_FluxCaliDeseng pSource)
  {
    setCxala(pSource.getCxala());setRsin(pSource.getRsin());setCxass(pSource.getCxass());setDateAppel(pSource.getDateAppel());setIdAide(pSource.getIdAide());
  }
  
  public String toString()
  {
    StringBuffer s = new StringBuffer("[_FluxCaliDeseng");
    subToString(s);
    s.append("]");
    return s.toString();
  }
  
  protected void subToString(StringBuffer pSource)
  {
    pSource.append(", Cxala: ");
    pSource.append(m_cxala);
    pSource.append(", Rsin: ");
    pSource.append(m_rsin);
    pSource.append(", Cxass: ");
    pSource.append(m_cxass);
    pSource.append(", DateAppel: ");
    pSource.append(m_dateAppel);
    pSource.append(", IdAide: ");
    pSource.append(m_idAide);
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
    pHandler.property("Cxala", getCxala(), new Attribute[] { new StringAttribute("C_ERR", getCxala_C_ERR()) });
    
    pHandler.property("Rsin", getRsin(), new Attribute[] { new StringAttribute("C_ERR", getRsin_C_ERR()) });
    
    pHandler.property("Cxass", getCxass(), new Attribute[] { new StringAttribute("C_ERR", getCxass_C_ERR()) });
    
    pHandler.property("DateAppel", getDateAppel(), new Attribute[] { new StringAttribute("C_ERR", getDateAppel_C_ERR()) });
    
    pHandler.property("IdAide", getIdAide(), new Attribute[] { new StringAttribute("C_ERR", getIdAide_C_ERR()) });
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
    setCxala((String)pHandler.objectProperty("Cxala", String.class));
    setCxala_C_ERR(pHandler.stringAttribute("Cxala", "C_ERR"));
    
    setRsin((String)pHandler.objectProperty("Rsin", String.class));
    setRsin_C_ERR(pHandler.stringAttribute("Rsin", "C_ERR"));
    
    setCxass((String)pHandler.objectProperty("Cxass", String.class));
    setCxass_C_ERR(pHandler.stringAttribute("Cxass", "C_ERR"));
    
    setDateAppel((Damj)pHandler.objectProperty("DateAppel", Damj.class));
    setDateAppel_C_ERR(pHandler.stringAttribute("DateAppel", "C_ERR"));
    
    setIdAide((String)pHandler.objectProperty("IdAide", String.class));
    setIdAide_C_ERR(pHandler.stringAttribute("IdAide", "C_ERR"));
  }
  
  public String _getDatabeanName()
  {
    return "FluxCaliDeseng";
  }
  
  public boolean _isValidProperty(String pElementName)
  {
    if ("Cxala".equals(pElementName)) {
      return true;
    }
    if ("Rsin".equals(pElementName)) {
      return true;
    }
    if ("Cxass".equals(pElementName)) {
      return true;
    }
    if ("DateAppel".equals(pElementName)) {
      return true;
    }
    if ("IdAide".equals(pElementName)) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _FluxCaliDeseng
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */