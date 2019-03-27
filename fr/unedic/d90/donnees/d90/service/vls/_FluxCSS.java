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
import java.util.ArrayList;
import java.util.Iterator;

public class _FluxCSS
  extends DataBeanImpl
  implements DataBean, Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  private String m__C_ETAT;
  private String m__IDENT;
  private String m_referenceFormulaire;
  private String m_referenceFormulaire_C_ERR;
  private String m_motif;
  private String m_motif_C_ERR;
  
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
  
  public String getReferenceFormulaire()
  {
    return m_referenceFormulaire;
  }
  
  public String getReferenceFormulaire_C_ERR()
  {
    return m_referenceFormulaire_C_ERR;
  }
  
  public void setReferenceFormulaire(String pValeur)
  {
    m_referenceFormulaire = pValeur;
  }
  
  public void setReferenceFormulaire_C_ERR(String pValeur_C_ERR)
  {
    m_referenceFormulaire_C_ERR = pValeur_C_ERR;
  }
  
  public String getMotif()
  {
    return m_motif;
  }
  
  public String getMotif_C_ERR()
  {
    return m_motif_C_ERR;
  }
  
  public void setMotif(String pValeur)
  {
    m_motif = pValeur;
  }
  
  public void setMotif_C_ERR(String pValeur_C_ERR)
  {
    m_motif_C_ERR = pValeur_C_ERR;
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
    if ("m_referenceFormulaire_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_motif_C_ERR".equals(attrName)) {
      return String.class;
    }
    return null;
  }
  
  public PropertyInfo _getPropertyInfo(String pElementName)
    throws TechniqueException
  {
    if ("ReferenceFormulaire".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("Motif".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    return null;
  }
  
  public int _getPropertyLength(String pElementName)
  {
    if ("ReferenceFormulaire".equals(pElementName)) {
      return 7;
    }
    if ("Motif".equals(pElementName)) {
      return 10;
    }
    return -1;
  }
  
  public Object _getProperty(String pName)
    throws Exception
  {
    if ("ReferenceFormulaire".equals(pName)) {
      return m_referenceFormulaire;
    }
    if ("Motif".equals(pName)) {
      return m_motif;
    }
    return null;
  }
  
  public Iterator _getPropertyNames()
    throws Exception
  {
    ArrayList liste = new ArrayList();
    liste.add("ReferenceFormulaire");
    liste.add("Motif");
    return liste.iterator();
  }
  
  public ArrayList _getPropertyNames(ArrayList pListe)
    throws Exception
  {
    pListe.add("ReferenceFormulaire");
    pListe.add("Motif");
    return pListe;
  }
  
  public void _setProperty(String pName, Object pValeur)
    throws Exception
  {
    if ("ReferenceFormulaire".equals(pName)) {
      m_referenceFormulaire = ((String)pValeur);
    }
    if ("Motif".equals(pName)) {
      m_motif = ((String)pValeur);
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
    if ("m_referenceFormulaire_C_ERR".equals(attrName)) {
      m_referenceFormulaire_C_ERR = pValeur;
    }
    if ("m_motif_C_ERR".equals(attrName)) {
      m_motif_C_ERR = pValeur;
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
    if ("m_referenceFormulaire_C_ERR".equals(attrName)) {
      return m_referenceFormulaire_C_ERR;
    }
    if ("m_motif_C_ERR".equals(attrName)) {
      return m_motif_C_ERR;
    }
    return null;
  }
  
  public boolean equals(Object pObjet)
  {
    if (!(pObjet instanceof _FluxCSS)) {
      return false;
    }
    _FluxCSS x = (_FluxCSS)pObjet;
    if (m_referenceFormulaire == null)
    {
      if (m_referenceFormulaire != null) {
        return false;
      }
    }
    else
    {
      if (m_referenceFormulaire == null) {
        return false;
      }
      if (!m_referenceFormulaire.equals(m_referenceFormulaire)) {
        return false;
      }
    }
    if (m_motif == null)
    {
      if (m_motif != null) {
        return false;
      }
    }
    else
    {
      if (m_motif == null) {
        return false;
      }
      if (!m_motif.equals(m_motif)) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int result = 0;
    if (m_referenceFormulaire != null) {
      result += m_referenceFormulaire.hashCode();
    }
    if (m_motif != null) {
      result += m_motif.hashCode();
    }
    result *= 17;
    return result;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    _FluxCSS clone_FluxCSS = new _FluxCSS();
    clone_FluxCSS.populateFrom_FluxCSS(this);
    return clone_FluxCSS;
  }
  
  public void populateFrom_FluxCSS(_FluxCSS pSource)
  {
    setReferenceFormulaire(pSource.getReferenceFormulaire());setMotif(pSource.getMotif());
  }
  
  public String toString()
  {
    StringBuffer s = new StringBuffer("[_FluxCSS");
    subToString(s);
    s.append("]");
    return s.toString();
  }
  
  protected void subToString(StringBuffer pSource)
  {
    pSource.append(", ReferenceFormulaire: ");
    pSource.append(m_referenceFormulaire);
    pSource.append(", Motif: ");
    pSource.append(m_motif);
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
    pHandler.property("ReferenceFormulaire", getReferenceFormulaire(), new Attribute[] { new StringAttribute("C_ERR", getReferenceFormulaire_C_ERR()) });
    
    pHandler.property("Motif", getMotif(), new Attribute[] { new StringAttribute("C_ERR", getMotif_C_ERR()) });
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
    setReferenceFormulaire((String)pHandler.objectProperty("ReferenceFormulaire", String.class));
    setReferenceFormulaire_C_ERR(pHandler.stringAttribute("ReferenceFormulaire", "C_ERR"));
    
    setMotif((String)pHandler.objectProperty("Motif", String.class));
    setMotif_C_ERR(pHandler.stringAttribute("Motif", "C_ERR"));
  }
  
  public String _getDatabeanName()
  {
    return "FluxCSS";
  }
  
  public boolean _isValidProperty(String pElementName)
  {
    if ("ReferenceFormulaire".equals(pElementName)) {
      return true;
    }
    if ("Motif".equals(pElementName)) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _FluxCSS
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */