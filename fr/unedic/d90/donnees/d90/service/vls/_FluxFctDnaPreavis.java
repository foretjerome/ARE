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

public class _FluxFctDnaPreavis
  extends DataBeanImpl
  implements DataBean, Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  private String m__C_ETAT;
  private String m__IDENT;
  private String m_typePreavis;
  private String m_typePreavis_C_ERR;
  private Damj m_dateDebutPreavis;
  private String m_dateDebutPreavis_C_ERR;
  private Damj m_dateFinPreavis;
  private String m_dateFinPreavis_C_ERR;
  
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
  
  public String getTypePreavis()
  {
    return m_typePreavis;
  }
  
  public String getTypePreavis_C_ERR()
  {
    return m_typePreavis_C_ERR;
  }
  
  public void setTypePreavis(String pValeur)
  {
    m_typePreavis = pValeur;
  }
  
  public void setTypePreavis_C_ERR(String pValeur_C_ERR)
  {
    m_typePreavis_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDateDebutPreavis()
  {
    return m_dateDebutPreavis;
  }
  
  public String getDateDebutPreavis_C_ERR()
  {
    return m_dateDebutPreavis_C_ERR;
  }
  
  public void setDateDebutPreavis(Damj pValeur)
  {
    m_dateDebutPreavis = pValeur;
  }
  
  public void setDateDebutPreavis_C_ERR(String pValeur_C_ERR)
  {
    m_dateDebutPreavis_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDateFinPreavis()
  {
    return m_dateFinPreavis;
  }
  
  public String getDateFinPreavis_C_ERR()
  {
    return m_dateFinPreavis_C_ERR;
  }
  
  public void setDateFinPreavis(Damj pValeur)
  {
    m_dateFinPreavis = pValeur;
  }
  
  public void setDateFinPreavis_C_ERR(String pValeur_C_ERR)
  {
    m_dateFinPreavis_C_ERR = pValeur_C_ERR;
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
    if ("m_typePreavis_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateDebutPreavis_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateFinPreavis_C_ERR".equals(attrName)) {
      return String.class;
    }
    return null;
  }
  
  public PropertyInfo _getPropertyInfo(String pElementName)
    throws TechniqueException
  {
    if ("TypePreavis".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("DateDebutPreavis".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("DateFinPreavis".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    return null;
  }
  
  public int _getPropertyLength(String pElementName)
  {
    if ("TypePreavis".equals(pElementName)) {
      return 2;
    }
    if ("DateDebutPreavis".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("DateFinPreavis".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    return -1;
  }
  
  public Object _getProperty(String pName)
    throws Exception
  {
    if ("TypePreavis".equals(pName)) {
      return m_typePreavis;
    }
    if ("DateDebutPreavis".equals(pName)) {
      return m_dateDebutPreavis;
    }
    if ("DateFinPreavis".equals(pName)) {
      return m_dateFinPreavis;
    }
    return null;
  }
  
  public Iterator _getPropertyNames()
    throws Exception
  {
    ArrayList liste = new ArrayList();
    liste.add("TypePreavis");
    liste.add("DateDebutPreavis");
    liste.add("DateFinPreavis");
    return liste.iterator();
  }
  
  public ArrayList _getPropertyNames(ArrayList pListe)
    throws Exception
  {
    pListe.add("TypePreavis");
    pListe.add("DateDebutPreavis");
    pListe.add("DateFinPreavis");
    return pListe;
  }
  
  public void _setProperty(String pName, Object pValeur)
    throws Exception
  {
    if ("TypePreavis".equals(pName)) {
      m_typePreavis = ((String)pValeur);
    }
    if ("DateDebutPreavis".equals(pName)) {
      m_dateDebutPreavis = ((Damj)pValeur);
    }
    if ("DateFinPreavis".equals(pName)) {
      m_dateFinPreavis = ((Damj)pValeur);
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
    if ("m_typePreavis_C_ERR".equals(attrName)) {
      m_typePreavis_C_ERR = pValeur;
    }
    if ("m_dateDebutPreavis_C_ERR".equals(attrName)) {
      m_dateDebutPreavis_C_ERR = pValeur;
    }
    if ("m_dateFinPreavis_C_ERR".equals(attrName)) {
      m_dateFinPreavis_C_ERR = pValeur;
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
    if ("m_typePreavis_C_ERR".equals(attrName)) {
      return m_typePreavis_C_ERR;
    }
    if ("m_dateDebutPreavis_C_ERR".equals(attrName)) {
      return m_dateDebutPreavis_C_ERR;
    }
    if ("m_dateFinPreavis_C_ERR".equals(attrName)) {
      return m_dateFinPreavis_C_ERR;
    }
    return null;
  }
  
  public boolean equals(Object pObjet)
  {
    if (!(pObjet instanceof _FluxFctDnaPreavis)) {
      return false;
    }
    _FluxFctDnaPreavis x = (_FluxFctDnaPreavis)pObjet;
    if (m_typePreavis == null)
    {
      if (m_typePreavis != null) {
        return false;
      }
    }
    else
    {
      if (m_typePreavis == null) {
        return false;
      }
      if (!m_typePreavis.equals(m_typePreavis)) {
        return false;
      }
    }
    if (m_dateDebutPreavis == null)
    {
      if (m_dateDebutPreavis != null) {
        return false;
      }
    }
    else
    {
      if (m_dateDebutPreavis == null) {
        return false;
      }
      if (!m_dateDebutPreavis.equals(m_dateDebutPreavis)) {
        return false;
      }
    }
    if (m_dateFinPreavis == null)
    {
      if (m_dateFinPreavis != null) {
        return false;
      }
    }
    else
    {
      if (m_dateFinPreavis == null) {
        return false;
      }
      if (!m_dateFinPreavis.equals(m_dateFinPreavis)) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int result = 0;
    if (m_typePreavis != null) {
      result += m_typePreavis.hashCode();
    }
    if (m_dateDebutPreavis != null) {
      result += m_dateDebutPreavis.hashCode();
    }
    if (m_dateFinPreavis != null) {
      result += m_dateFinPreavis.hashCode();
    }
    result *= 17;
    return result;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    _FluxFctDnaPreavis clone_FluxFctDnaPreavis = new _FluxFctDnaPreavis();
    clone_FluxFctDnaPreavis.populateFrom_FluxFctDnaPreavis(this);
    return clone_FluxFctDnaPreavis;
  }
  
  public void populateFrom_FluxFctDnaPreavis(_FluxFctDnaPreavis pSource)
  {
    setTypePreavis(pSource.getTypePreavis());setDateDebutPreavis(pSource.getDateDebutPreavis());setDateFinPreavis(pSource.getDateFinPreavis());
  }
  
  public String toString()
  {
    StringBuffer s = new StringBuffer("[_FluxFctDnaPreavis");
    subToString(s);
    s.append("]");
    return s.toString();
  }
  
  protected void subToString(StringBuffer pSource)
  {
    pSource.append(", TypePreavis: ");
    pSource.append(m_typePreavis);
    pSource.append(", DateDebutPreavis: ");
    pSource.append(m_dateDebutPreavis);
    pSource.append(", DateFinPreavis: ");
    pSource.append(m_dateFinPreavis);
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
    pHandler.property("TypePreavis", getTypePreavis(), new Attribute[] { new StringAttribute("C_ERR", getTypePreavis_C_ERR()) });
    
    pHandler.property("DateDebutPreavis", getDateDebutPreavis(), new Attribute[] { new StringAttribute("C_ERR", getDateDebutPreavis_C_ERR()) });
    
    pHandler.property("DateFinPreavis", getDateFinPreavis(), new Attribute[] { new StringAttribute("C_ERR", getDateFinPreavis_C_ERR()) });
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
    setTypePreavis((String)pHandler.objectProperty("TypePreavis", String.class));
    setTypePreavis_C_ERR(pHandler.stringAttribute("TypePreavis", "C_ERR"));
    
    setDateDebutPreavis((Damj)pHandler.objectProperty("DateDebutPreavis", Damj.class));
    setDateDebutPreavis_C_ERR(pHandler.stringAttribute("DateDebutPreavis", "C_ERR"));
    
    setDateFinPreavis((Damj)pHandler.objectProperty("DateFinPreavis", Damj.class));
    setDateFinPreavis_C_ERR(pHandler.stringAttribute("DateFinPreavis", "C_ERR"));
  }
  
  public String _getDatabeanName()
  {
    return "FluxFctDnaPreavis";
  }
  
  public boolean _isValidProperty(String pElementName)
  {
    if ("TypePreavis".equals(pElementName)) {
      return true;
    }
    if ("DateDebutPreavis".equals(pElementName)) {
      return true;
    }
    if ("DateFinPreavis".equals(pElementName)) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _FluxFctDnaPreavis
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */