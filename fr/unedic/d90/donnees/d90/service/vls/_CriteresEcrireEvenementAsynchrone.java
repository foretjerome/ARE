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

public class _CriteresEcrireEvenementAsynchrone
  extends DataBeanImpl
  implements DataBean, Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  private String m__C_ETAT;
  private String m__IDENT;
  private _ContexteService m_contexteService;
  private String m_contexteService_C_ERR;
  private _ListeParametres m_listeParametres;
  private String m_listeParametres_C_ERR;
  private _Flux m_flux;
  private String m_flux_C_ERR;
  
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
  
  public _ListeParametres getListeParametres()
  {
    return m_listeParametres;
  }
  
  public String getListeParametres_C_ERR()
  {
    return m_listeParametres_C_ERR;
  }
  
  public void setListeParametres(_ListeParametres pValeur)
  {
    m_listeParametres = pValeur;
  }
  
  public void setListeParametres_C_ERR(String pValeur_C_ERR)
  {
    m_listeParametres_C_ERR = pValeur_C_ERR;
  }
  
  public _Flux getFlux()
  {
    return m_flux;
  }
  
  public String getFlux_C_ERR()
  {
    return m_flux_C_ERR;
  }
  
  public void setFlux(_Flux pValeur)
  {
    m_flux = pValeur;
  }
  
  public void setFlux_C_ERR(String pValeur_C_ERR)
  {
    m_flux_C_ERR = pValeur_C_ERR;
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
    if ("m_listeParametres_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_flux_C_ERR".equals(attrName)) {
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
    if ("ListeParametres".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, _ListeParametres.class, false);
      return info;
    }
    if ("Flux".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, _Flux.class, false);
      return info;
    }
    return null;
  }
  
  public int _getPropertyLength(String pElementName)
  {
    if ("ContexteService".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("ListeParametres".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("Flux".equals(pElementName)) {
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
    if ("ListeParametres".equals(pName)) {
      return m_listeParametres;
    }
    if ("Flux".equals(pName)) {
      return m_flux;
    }
    return null;
  }
  
  public Iterator _getPropertyNames()
    throws Exception
  {
    ArrayList liste = new ArrayList();
    liste.add("ContexteService");
    liste.add("ListeParametres");
    liste.add("Flux");
    return liste.iterator();
  }
  
  public ArrayList _getPropertyNames(ArrayList pListe)
    throws Exception
  {
    pListe.add("ContexteService");
    pListe.add("ListeParametres");
    pListe.add("Flux");
    return pListe;
  }
  
  public void _setProperty(String pName, Object pValeur)
    throws Exception
  {
    if ("ContexteService".equals(pName)) {
      m_contexteService = ((_ContexteService)pValeur);
    }
    if ("ListeParametres".equals(pName)) {
      m_listeParametres = ((_ListeParametres)pValeur);
    }
    if ("Flux".equals(pName)) {
      m_flux = ((_Flux)pValeur);
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
    if ("m_listeParametres_C_ERR".equals(attrName)) {
      m_listeParametres_C_ERR = pValeur;
    }
    if ("m_flux_C_ERR".equals(attrName)) {
      m_flux_C_ERR = pValeur;
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
    if ("m_listeParametres_C_ERR".equals(attrName)) {
      return m_listeParametres_C_ERR;
    }
    if ("m_flux_C_ERR".equals(attrName)) {
      return m_flux_C_ERR;
    }
    return null;
  }
  
  public boolean equals(Object pObjet)
  {
    if (!(pObjet instanceof _CriteresEcrireEvenementAsynchrone)) {
      return false;
    }
    _CriteresEcrireEvenementAsynchrone x = (_CriteresEcrireEvenementAsynchrone)pObjet;
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
    if (m_listeParametres == null)
    {
      if (m_listeParametres != null) {
        return false;
      }
    }
    else
    {
      if (m_listeParametres == null) {
        return false;
      }
      if (!m_listeParametres.equals(m_listeParametres)) {
        return false;
      }
    }
    if (m_flux == null)
    {
      if (m_flux != null) {
        return false;
      }
    }
    else
    {
      if (m_flux == null) {
        return false;
      }
      if (!m_flux.equals(m_flux)) {
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
    if (m_listeParametres != null) {
      result += m_listeParametres.hashCode();
    }
    if (m_flux != null) {
      result += m_flux.hashCode();
    }
    result *= 17;
    return result;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    _CriteresEcrireEvenementAsynchrone clone_CriteresEcrireEvenementAsynchrone = new _CriteresEcrireEvenementAsynchrone();
    clone_CriteresEcrireEvenementAsynchrone.populateFrom_CriteresEcrireEvenementAsynchrone(this);
    return clone_CriteresEcrireEvenementAsynchrone;
  }
  
  public void populateFrom_CriteresEcrireEvenementAsynchrone(_CriteresEcrireEvenementAsynchrone pSource)
  {
    setContexteService(pSource.getContexteService());setListeParametres(pSource.getListeParametres());setFlux(pSource.getFlux());
  }
  
  public String toString()
  {
    StringBuffer s = new StringBuffer("[_CriteresEcrireEvenementAsynchrone");
    subToString(s);
    s.append("]");
    return s.toString();
  }
  
  protected void subToString(StringBuffer pSource)
  {
    pSource.append(", ContexteService: ");
    pSource.append(m_contexteService);
    pSource.append(", ListeParametres: ");
    pSource.append(m_listeParametres);
    pSource.append(", Flux: ");
    pSource.append(m_flux);
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
    DataBean ListeParametres_Value = getListeParametres();
    GettersHandler ListeParametres_GettersHandler = pHandler.property("ListeParametres", ListeParametres_Value, new Attribute[] { new StringAttribute("C_ERR", getListeParametres_C_ERR()) });
    if ((ListeParametres_GettersHandler != null) && (ListeParametres_Value != null)) {
      ListeParametres_Value.goThrough(ListeParametres_GettersHandler);
    }
    DataBean Flux_Value = getFlux();
    GettersHandler Flux_GettersHandler = pHandler.property("Flux", Flux_Value, new Attribute[] { new StringAttribute("C_ERR", getFlux_C_ERR()) });
    if ((Flux_GettersHandler != null) && (Flux_Value != null)) {
      Flux_Value.goThrough(Flux_GettersHandler);
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
    setListeParametres((_ListeParametres)pHandler.databeanProperty("ListeParametres", _ListeParametres.class));
    setListeParametres_C_ERR(pHandler.stringAttribute("ListeParametres", "C_ERR"));
    setFlux((_Flux)pHandler.databeanProperty("Flux", _Flux.class));
    setFlux_C_ERR(pHandler.stringAttribute("Flux", "C_ERR"));
  }
  
  public String _getDatabeanName()
  {
    return "CriteresEcrireEvenementAsynchrone";
  }
  
  public boolean _isValidProperty(String pElementName)
  {
    if ("ContexteService".equals(pElementName)) {
      return true;
    }
    if ("ListeParametres".equals(pElementName)) {
      return true;
    }
    if ("Flux".equals(pElementName)) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _CriteresEcrireEvenementAsynchrone
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */