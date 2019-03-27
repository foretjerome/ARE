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

public class _ResultatEcrireODFOut
  extends DataBeanImpl
  implements DataBean, Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  private String m__C_ETAT;
  private String m__IDENT;
  private _ResultatService m_resultatService;
  private String m_resultatService_C_ERR;
  
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
  
  public _ResultatService getResultatService()
  {
    return m_resultatService;
  }
  
  public String getResultatService_C_ERR()
  {
    return m_resultatService_C_ERR;
  }
  
  public void setResultatService(_ResultatService pValeur)
  {
    m_resultatService = pValeur;
  }
  
  public void setResultatService_C_ERR(String pValeur_C_ERR)
  {
    m_resultatService_C_ERR = pValeur_C_ERR;
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
    if ("m_resultatService_C_ERR".equals(attrName)) {
      return String.class;
    }
    return null;
  }
  
  public PropertyInfo _getPropertyInfo(String pElementName)
    throws TechniqueException
  {
    if ("ResultatService".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, _ResultatService.class, false);
      return info;
    }
    return null;
  }
  
  public int _getPropertyLength(String pElementName)
  {
    if ("ResultatService".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    return -1;
  }
  
  public Object _getProperty(String pName)
    throws Exception
  {
    if ("ResultatService".equals(pName)) {
      return m_resultatService;
    }
    return null;
  }
  
  public Iterator _getPropertyNames()
    throws Exception
  {
    ArrayList liste = new ArrayList();
    liste.add("ResultatService");
    return liste.iterator();
  }
  
  public ArrayList _getPropertyNames(ArrayList pListe)
    throws Exception
  {
    pListe.add("ResultatService");
    return pListe;
  }
  
  public void _setProperty(String pName, Object pValeur)
    throws Exception
  {
    if ("ResultatService".equals(pName)) {
      m_resultatService = ((_ResultatService)pValeur);
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
    if ("m_resultatService_C_ERR".equals(attrName)) {
      m_resultatService_C_ERR = pValeur;
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
    if ("m_resultatService_C_ERR".equals(attrName)) {
      return m_resultatService_C_ERR;
    }
    return null;
  }
  
  public boolean equals(Object pObjet)
  {
    if (!(pObjet instanceof _ResultatEcrireODFOut)) {
      return false;
    }
    _ResultatEcrireODFOut x = (_ResultatEcrireODFOut)pObjet;
    if (m_resultatService == null)
    {
      if (m_resultatService != null) {
        return false;
      }
    }
    else
    {
      if (m_resultatService == null) {
        return false;
      }
      if (!m_resultatService.equals(m_resultatService)) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int result = 0;
    if (m_resultatService != null) {
      result += m_resultatService.hashCode();
    }
    result *= 17;
    return result;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    _ResultatEcrireODFOut clone_ResultatEcrireODFOut = new _ResultatEcrireODFOut();
    clone_ResultatEcrireODFOut.populateFrom_ResultatEcrireODFOut(this);
    return clone_ResultatEcrireODFOut;
  }
  
  public void populateFrom_ResultatEcrireODFOut(_ResultatEcrireODFOut pSource)
  {
    setResultatService(pSource.getResultatService());
  }
  
  public String toString()
  {
    StringBuffer s = new StringBuffer("[_ResultatEcrireODFOut");
    subToString(s);
    s.append("]");
    return s.toString();
  }
  
  protected void subToString(StringBuffer pSource)
  {
    pSource.append(", ResultatService: ");
    pSource.append(m_resultatService);
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
    DataBean ResultatService_Value = getResultatService();
    GettersHandler ResultatService_GettersHandler = pHandler.property("ResultatService", ResultatService_Value, new Attribute[] { new StringAttribute("C_ERR", getResultatService_C_ERR()) });
    if ((ResultatService_GettersHandler != null) && (ResultatService_Value != null)) {
      ResultatService_Value.goThrough(ResultatService_GettersHandler);
    }
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
    setResultatService((_ResultatService)pHandler.databeanProperty("ResultatService", _ResultatService.class));
    setResultatService_C_ERR(pHandler.stringAttribute("ResultatService", "C_ERR"));
  }
  
  public String _getDatabeanName()
  {
    return "ResultatEcrireODFOut";
  }
  
  public boolean _isValidProperty(String pElementName)
  {
    if ("ResultatService".equals(pElementName)) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _ResultatEcrireODFOut
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */