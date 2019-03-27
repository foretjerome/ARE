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

public class _FluxCali
  extends DataBeanImpl
  implements DataBean, Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  private String m__C_ETAT;
  private String m__IDENT;
  private String m_cxass;
  private String m_cxass_C_ERR;
  private String m_rsin;
  private String m_rsin_C_ERR;
  private String m_cxala;
  private String m_cxala_C_ERR;
  private Damj m_dateTraitement;
  private String m_dateTraitement_C_ERR;
  private Damj m_dateReexecution;
  private String m_dateReexecution_C_ERR;
  
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
  
  public Damj getDateTraitement()
  {
    return m_dateTraitement;
  }
  
  public String getDateTraitement_C_ERR()
  {
    return m_dateTraitement_C_ERR;
  }
  
  public void setDateTraitement(Damj pValeur)
  {
    m_dateTraitement = pValeur;
  }
  
  public void setDateTraitement_C_ERR(String pValeur_C_ERR)
  {
    m_dateTraitement_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDateReexecution()
  {
    return m_dateReexecution;
  }
  
  public String getDateReexecution_C_ERR()
  {
    return m_dateReexecution_C_ERR;
  }
  
  public void setDateReexecution(Damj pValeur)
  {
    m_dateReexecution = pValeur;
  }
  
  public void setDateReexecution_C_ERR(String pValeur_C_ERR)
  {
    m_dateReexecution_C_ERR = pValeur_C_ERR;
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
    if ("m_cxass_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_rsin_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_cxala_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateTraitement_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateReexecution_C_ERR".equals(attrName)) {
      return String.class;
    }
    return null;
  }
  
  public PropertyInfo _getPropertyInfo(String pElementName)
    throws TechniqueException
  {
    if ("Cxass".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("Rsin".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("Cxala".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("DateTraitement".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("DateReexecution".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    return null;
  }
  
  public int _getPropertyLength(String pElementName)
  {
    if ("Cxass".equals(pElementName)) {
      return 2;
    }
    if ("Rsin".equals(pElementName)) {
      return 7;
    }
    if ("Cxala".equals(pElementName)) {
      return 10;
    }
    if ("DateTraitement".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("DateReexecution".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    return -1;
  }
  
  public Object _getProperty(String pName)
    throws Exception
  {
    if ("Cxass".equals(pName)) {
      return m_cxass;
    }
    if ("Rsin".equals(pName)) {
      return m_rsin;
    }
    if ("Cxala".equals(pName)) {
      return m_cxala;
    }
    if ("DateTraitement".equals(pName)) {
      return m_dateTraitement;
    }
    if ("DateReexecution".equals(pName)) {
      return m_dateReexecution;
    }
    return null;
  }
  
  public Iterator _getPropertyNames()
    throws Exception
  {
    ArrayList liste = new ArrayList();
    liste.add("Cxass");
    liste.add("Rsin");
    liste.add("Cxala");
    liste.add("DateTraitement");
    liste.add("DateReexecution");
    return liste.iterator();
  }
  
  public ArrayList _getPropertyNames(ArrayList pListe)
    throws Exception
  {
    pListe.add("Cxass");
    pListe.add("Rsin");
    pListe.add("Cxala");
    pListe.add("DateTraitement");
    pListe.add("DateReexecution");
    return pListe;
  }
  
  public void _setProperty(String pName, Object pValeur)
    throws Exception
  {
    if ("Cxass".equals(pName)) {
      m_cxass = ((String)pValeur);
    }
    if ("Rsin".equals(pName)) {
      m_rsin = ((String)pValeur);
    }
    if ("Cxala".equals(pName)) {
      m_cxala = ((String)pValeur);
    }
    if ("DateTraitement".equals(pName)) {
      m_dateTraitement = ((Damj)pValeur);
    }
    if ("DateReexecution".equals(pName)) {
      m_dateReexecution = ((Damj)pValeur);
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
    if ("m_cxass_C_ERR".equals(attrName)) {
      m_cxass_C_ERR = pValeur;
    }
    if ("m_rsin_C_ERR".equals(attrName)) {
      m_rsin_C_ERR = pValeur;
    }
    if ("m_cxala_C_ERR".equals(attrName)) {
      m_cxala_C_ERR = pValeur;
    }
    if ("m_dateTraitement_C_ERR".equals(attrName)) {
      m_dateTraitement_C_ERR = pValeur;
    }
    if ("m_dateReexecution_C_ERR".equals(attrName)) {
      m_dateReexecution_C_ERR = pValeur;
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
    if ("m_cxass_C_ERR".equals(attrName)) {
      return m_cxass_C_ERR;
    }
    if ("m_rsin_C_ERR".equals(attrName)) {
      return m_rsin_C_ERR;
    }
    if ("m_cxala_C_ERR".equals(attrName)) {
      return m_cxala_C_ERR;
    }
    if ("m_dateTraitement_C_ERR".equals(attrName)) {
      return m_dateTraitement_C_ERR;
    }
    if ("m_dateReexecution_C_ERR".equals(attrName)) {
      return m_dateReexecution_C_ERR;
    }
    return null;
  }
  
  public boolean equals(Object pObjet)
  {
    if (!(pObjet instanceof _FluxCali)) {
      return false;
    }
    _FluxCali x = (_FluxCali)pObjet;
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
    if (m_dateTraitement == null)
    {
      if (m_dateTraitement != null) {
        return false;
      }
    }
    else
    {
      if (m_dateTraitement == null) {
        return false;
      }
      if (!m_dateTraitement.equals(m_dateTraitement)) {
        return false;
      }
    }
    if (m_dateReexecution == null)
    {
      if (m_dateReexecution != null) {
        return false;
      }
    }
    else
    {
      if (m_dateReexecution == null) {
        return false;
      }
      if (!m_dateReexecution.equals(m_dateReexecution)) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int result = 0;
    if (m_cxass != null) {
      result += m_cxass.hashCode();
    }
    if (m_rsin != null) {
      result += m_rsin.hashCode();
    }
    if (m_cxala != null) {
      result += m_cxala.hashCode();
    }
    if (m_dateTraitement != null) {
      result += m_dateTraitement.hashCode();
    }
    if (m_dateReexecution != null) {
      result += m_dateReexecution.hashCode();
    }
    result *= 17;
    return result;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    _FluxCali clone_FluxCali = new _FluxCali();
    clone_FluxCali.populateFrom_FluxCali(this);
    return clone_FluxCali;
  }
  
  public void populateFrom_FluxCali(_FluxCali pSource)
  {
    setCxass(pSource.getCxass());setRsin(pSource.getRsin());setCxala(pSource.getCxala());setDateTraitement(pSource.getDateTraitement());setDateReexecution(pSource.getDateReexecution());
  }
  
  public String toString()
  {
    StringBuffer s = new StringBuffer("[_FluxCali");
    subToString(s);
    s.append("]");
    return s.toString();
  }
  
  protected void subToString(StringBuffer pSource)
  {
    pSource.append(", Cxass: ");
    pSource.append(m_cxass);
    pSource.append(", Rsin: ");
    pSource.append(m_rsin);
    pSource.append(", Cxala: ");
    pSource.append(m_cxala);
    pSource.append(", DateTraitement: ");
    pSource.append(m_dateTraitement);
    pSource.append(", DateReexecution: ");
    pSource.append(m_dateReexecution);
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
    pHandler.property("Cxass", getCxass(), new Attribute[] { new StringAttribute("C_ERR", getCxass_C_ERR()) });
    
    pHandler.property("Rsin", getRsin(), new Attribute[] { new StringAttribute("C_ERR", getRsin_C_ERR()) });
    
    pHandler.property("Cxala", getCxala(), new Attribute[] { new StringAttribute("C_ERR", getCxala_C_ERR()) });
    
    pHandler.property("DateTraitement", getDateTraitement(), new Attribute[] { new StringAttribute("C_ERR", getDateTraitement_C_ERR()) });
    
    pHandler.property("DateReexecution", getDateReexecution(), new Attribute[] { new StringAttribute("C_ERR", getDateReexecution_C_ERR()) });
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
    setCxass((String)pHandler.objectProperty("Cxass", String.class));
    setCxass_C_ERR(pHandler.stringAttribute("Cxass", "C_ERR"));
    
    setRsin((String)pHandler.objectProperty("Rsin", String.class));
    setRsin_C_ERR(pHandler.stringAttribute("Rsin", "C_ERR"));
    
    setCxala((String)pHandler.objectProperty("Cxala", String.class));
    setCxala_C_ERR(pHandler.stringAttribute("Cxala", "C_ERR"));
    
    setDateTraitement((Damj)pHandler.objectProperty("DateTraitement", Damj.class));
    setDateTraitement_C_ERR(pHandler.stringAttribute("DateTraitement", "C_ERR"));
    
    setDateReexecution((Damj)pHandler.objectProperty("DateReexecution", Damj.class));
    setDateReexecution_C_ERR(pHandler.stringAttribute("DateReexecution", "C_ERR"));
  }
  
  public String _getDatabeanName()
  {
    return "FluxCali";
  }
  
  public boolean _isValidProperty(String pElementName)
  {
    if ("Cxass".equals(pElementName)) {
      return true;
    }
    if ("Rsin".equals(pElementName)) {
      return true;
    }
    if ("Cxala".equals(pElementName)) {
      return true;
    }
    if ("DateTraitement".equals(pElementName)) {
      return true;
    }
    if ("DateReexecution".equals(pElementName)) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _FluxCali
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */