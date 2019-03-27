package fr.pe.d12dal.service.es.completude;

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

public class _RetourAjouterPieceJustificative
  extends DataBeanImpl
  implements DataBean, Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  private String m__C_ETAT;
  private String m__IDENT;
  private String m_codeRetour;
  private String m_codeRetour_C_ERR;
  
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
  
  public String getCodeRetour()
  {
    return m_codeRetour;
  }
  
  public String getCodeRetour_C_ERR()
  {
    return m_codeRetour_C_ERR;
  }
  
  public void setCodeRetour(String pValeur)
  {
    m_codeRetour = pValeur;
  }
  
  public void setCodeRetour_C_ERR(String pValeur_C_ERR)
  {
    m_codeRetour_C_ERR = pValeur_C_ERR;
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
    if ("m_codeRetour_C_ERR".equals(attrName)) {
      return String.class;
    }
    return null;
  }
  
  public PropertyInfo _getPropertyInfo(String pElementName)
    throws TechniqueException
  {
    if ("codeRetour".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    return null;
  }
  
  public int _getPropertyLength(String pElementName)
  {
    if ("codeRetour".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    return -1;
  }
  
  public Object _getProperty(String pName)
    throws Exception
  {
    if ("codeRetour".equals(pName)) {
      return m_codeRetour;
    }
    return null;
  }
  
  public Iterator _getPropertyNames()
    throws Exception
  {
    ArrayList liste = new ArrayList();
    liste.add("codeRetour");
    return liste.iterator();
  }
  
  public ArrayList _getPropertyNames(ArrayList pListe)
    throws Exception
  {
    pListe.add("codeRetour");
    return pListe;
  }
  
  public void _setProperty(String pName, Object pValeur)
    throws Exception
  {
    if ("codeRetour".equals(pName)) {
      m_codeRetour = ((String)pValeur);
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
    if ("m_codeRetour_C_ERR".equals(attrName)) {
      m_codeRetour_C_ERR = pValeur;
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
    if ("m_codeRetour_C_ERR".equals(attrName)) {
      return m_codeRetour_C_ERR;
    }
    return null;
  }
  
  public boolean equals(Object pObjet)
  {
    if (!(pObjet instanceof _RetourAjouterPieceJustificative)) {
      return false;
    }
    _RetourAjouterPieceJustificative x = (_RetourAjouterPieceJustificative)pObjet;
    
    return true;
  }
  
  public int hashCode()
  {
    int result = 0;
    if (m_codeRetour != null) {
      result += m_codeRetour.hashCode();
    }
    result *= 17;
    return result;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    _RetourAjouterPieceJustificative clone_RetourAjouterPieceJustificative = new _RetourAjouterPieceJustificative();
    clone_RetourAjouterPieceJustificative.populateFrom_RetourAjouterPieceJustificative(this);
    return clone_RetourAjouterPieceJustificative;
  }
  
  public void populateFrom_RetourAjouterPieceJustificative(_RetourAjouterPieceJustificative pSource)
  {
    setCodeRetour(pSource.getCodeRetour());
  }
  
  public String toString()
  {
    StringBuffer s = new StringBuffer("[_RetourAjouterPieceJustificative");
    subToString(s);
    s.append("]");
    return s.toString();
  }
  
  protected void subToString(StringBuffer pSource)
  {
    pSource.append(", codeRetour: ");
    pSource.append(m_codeRetour);
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
    pHandler.property("codeRetour", getCodeRetour(), new Attribute[] { new StringAttribute("C_ERR", getCodeRetour_C_ERR()) });
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
    setCodeRetour((String)pHandler.objectProperty("codeRetour", String.class));
    setCodeRetour_C_ERR(pHandler.stringAttribute("codeRetour", "C_ERR"));
  }
  
  public String _getDatabeanName()
  {
    return "RetourAjouterPieceJustificative";
  }
  
  public boolean _isValidProperty(String pElementName)
  {
    if ("codeRetour".equals(pElementName)) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _RetourAjouterPieceJustificative
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */