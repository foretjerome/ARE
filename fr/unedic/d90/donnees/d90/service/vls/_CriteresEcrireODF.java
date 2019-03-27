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

public class _CriteresEcrireODF
  extends DataBeanImpl
  implements DataBean, Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  private String m__C_ETAT;
  private String m__IDENT;
  private _ContexteService m_contexteService;
  private String m_contexteService_C_ERR;
  private _ListeRSOD m_listeRSOD;
  private String m_listeRSOD_C_ERR;
  
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
  
  public _ContexteService getContexteService()
  {
    return m_contexteService;
  }
  
  public String getContexteService_C_ERR()
  {
    return m_contexteService_C_ERR;
  }
  
  public void setContexteService(_ContexteService pValeur)
  {
    m_contexteService = pValeur;
  }
  
  public void setContexteService_C_ERR(String pValeur_C_ERR)
  {
    m_contexteService_C_ERR = pValeur_C_ERR;
  }
  
  public _ListeRSOD getListeRSOD()
  {
    return m_listeRSOD;
  }
  
  public String getListeRSOD_C_ERR()
  {
    return m_listeRSOD_C_ERR;
  }
  
  public void setListeRSOD(_ListeRSOD pValeur)
  {
    m_listeRSOD = pValeur;
  }
  
  public void setListeRSOD_C_ERR(String pValeur_C_ERR)
  {
    m_listeRSOD_C_ERR = pValeur_C_ERR;
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
    if ("m_contexteService_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_listeRSOD_C_ERR".equals(attrName)) {
      return String.class;
    }
    return null;
  }
  
  public PropertyInfo _getPropertyInfo(String pElementName)
    throws TechniqueException
  {
    if ("ContexteService".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, _ContexteService.class, false);
      return info;
    }
    if ("ListeRSOD".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, _ListeRSOD.class, false);
      return info;
    }
    return null;
  }
  
  public int _getPropertyLength(String pElementName)
  {
    if ("ContexteService".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("ListeRSOD".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    return -1;
  }
  
  public Object _getProperty(String pName)
    throws Exception
  {
    if ("ContexteService".equals(pName)) {
      return m_contexteService;
    }
    if ("ListeRSOD".equals(pName)) {
      return m_listeRSOD;
    }
    return null;
  }
  
  public Iterator _getPropertyNames()
    throws Exception
  {
    ArrayList liste = new ArrayList();
    liste.add("ContexteService");
    liste.add("ListeRSOD");
    return liste.iterator();
  }
  
  public ArrayList _getPropertyNames(ArrayList pListe)
    throws Exception
  {
    pListe.add("ContexteService");
    pListe.add("ListeRSOD");
    return pListe;
  }
  
  public void _setProperty(String pName, Object pValeur)
    throws Exception
  {
    if ("ContexteService".equals(pName)) {
      m_contexteService = ((_ContexteService)pValeur);
    }
    if ("ListeRSOD".equals(pName)) {
      m_listeRSOD = ((_ListeRSOD)pValeur);
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
    if ("m_contexteService_C_ERR".equals(attrName)) {
      m_contexteService_C_ERR = pValeur;
    }
    if ("m_listeRSOD_C_ERR".equals(attrName)) {
      m_listeRSOD_C_ERR = pValeur;
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
    if ("m_contexteService_C_ERR".equals(attrName)) {
      return m_contexteService_C_ERR;
    }
    if ("m_listeRSOD_C_ERR".equals(attrName)) {
      return m_listeRSOD_C_ERR;
    }
    return null;
  }
  
  public boolean equals(Object pObjet)
  {
    if (!(pObjet instanceof _CriteresEcrireODF)) {
      return false;
    }
    _CriteresEcrireODF x = (_CriteresEcrireODF)pObjet;
    if (m_contexteService == null)
    {
      if (m_contexteService != null) {
        return false;
      }
    }
    else
    {
      if (m_contexteService == null) {
        return false;
      }
      if (!m_contexteService.equals(m_contexteService)) {
        return false;
      }
    }
    if (m_listeRSOD == null)
    {
      if (m_listeRSOD != null) {
        return false;
      }
    }
    else
    {
      if (m_listeRSOD == null) {
        return false;
      }
      if (!m_listeRSOD.equals(m_listeRSOD)) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int result = 0;
    if (m_contexteService != null) {
      result += m_contexteService.hashCode();
    }
    if (m_listeRSOD != null) {
      result += m_listeRSOD.hashCode();
    }
    result *= 17;
    return result;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    _CriteresEcrireODF clone_CriteresEcrireODF = new _CriteresEcrireODF();
    clone_CriteresEcrireODF.populateFrom_CriteresEcrireODF(this);
    return clone_CriteresEcrireODF;
  }
  
  public void populateFrom_CriteresEcrireODF(_CriteresEcrireODF pSource)
  {
    setContexteService(pSource.getContexteService());setListeRSOD(pSource.getListeRSOD());
  }
  
  public String toString()
  {
    StringBuffer s = new StringBuffer("[_CriteresEcrireODF");
    subToString(s);
    s.append("]");
    return s.toString();
  }
  
  protected void subToString(StringBuffer pSource)
  {
    pSource.append(", ContexteService: ");
    pSource.append(m_contexteService);
    pSource.append(", ListeRSOD: ");
    pSource.append(m_listeRSOD);
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
    DataBean ContexteService_Value = getContexteService();
    GettersHandler ContexteService_GettersHandler = pHandler.property("ContexteService", ContexteService_Value, new Attribute[] { new StringAttribute("C_ERR", getContexteService_C_ERR()) });
    if ((ContexteService_GettersHandler != null) && (ContexteService_Value != null)) {
      ContexteService_Value.goThrough(ContexteService_GettersHandler);
    }
    DataBean ListeRSOD_Value = getListeRSOD();
    GettersHandler ListeRSOD_GettersHandler = pHandler.property("ListeRSOD", ListeRSOD_Value, new Attribute[] { new StringAttribute("C_ERR", getListeRSOD_C_ERR()) });
    if ((ListeRSOD_GettersHandler != null) && (ListeRSOD_Value != null)) {
      ListeRSOD_Value.goThrough(ListeRSOD_GettersHandler);
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
    setContexteService((_ContexteService)pHandler.databeanProperty("ContexteService", _ContexteService.class));
    setContexteService_C_ERR(pHandler.stringAttribute("ContexteService", "C_ERR"));
    setListeRSOD((_ListeRSOD)pHandler.databeanProperty("ListeRSOD", _ListeRSOD.class));
    setListeRSOD_C_ERR(pHandler.stringAttribute("ListeRSOD", "C_ERR"));
  }
  
  public String _getDatabeanName()
  {
    return "CriteresEcrireODF";
  }
  
  public boolean _isValidProperty(String pElementName)
  {
    if ("ContexteService".equals(pElementName)) {
      return true;
    }
    if ("ListeRSOD".equals(pElementName)) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _CriteresEcrireODF
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */