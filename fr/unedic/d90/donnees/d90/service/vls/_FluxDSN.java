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

public class _FluxDSN
  extends DataBeanImpl
  implements DataBean, Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  private String m__C_ETAT;
  private String m__IDENT;
  private _FluxCtPasDsn m_fluxCtPasDsn;
  private String m_fluxCtPasDsn_C_ERR;
  private _ListeFluxPrimIndemDsn m_listeFluxPrimIndemDsn;
  private String m_listeFluxPrimIndemDsn_C_ERR;
  
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
  
  public _FluxCtPasDsn getFluxCtPasDsn()
  {
    return m_fluxCtPasDsn;
  }
  
  public String getFluxCtPasDsn_C_ERR()
  {
    return m_fluxCtPasDsn_C_ERR;
  }
  
  public void setFluxCtPasDsn(_FluxCtPasDsn pValeur)
  {
    m_fluxCtPasDsn = pValeur;
  }
  
  public void setFluxCtPasDsn_C_ERR(String pValeur_C_ERR)
  {
    m_fluxCtPasDsn_C_ERR = pValeur_C_ERR;
  }
  
  public _ListeFluxPrimIndemDsn getListeFluxPrimIndemDsn()
  {
    return m_listeFluxPrimIndemDsn;
  }
  
  public _ListeFluxPrimIndemDsn getListeFluxPrimeIndemDsn()
  {
    return m_listeFluxPrimIndemDsn;
  }
  
  public String getListeFluxPrimIndemDsn_C_ERR()
  {
    return m_listeFluxPrimIndemDsn_C_ERR;
  }
  
  public String getListeFluxPrimeIndemDsn_C_ERR()
  {
    return m_listeFluxPrimIndemDsn_C_ERR;
  }
  
  public void setListeFluxPrimIndemDsn(_ListeFluxPrimIndemDsn pValeur)
  {
    m_listeFluxPrimIndemDsn = pValeur;
  }
  
  public void setListeFluxPrimeIndemDsn(_ListeFluxPrimIndemDsn pValeur)
  {
    m_listeFluxPrimIndemDsn = pValeur;
  }
  
  public void setListeFluxPrimIndemDsn_C_ERR(String pValeur_C_ERR)
  {
    m_listeFluxPrimIndemDsn_C_ERR = pValeur_C_ERR;
  }
  
  public void setListeFluxPrimeIndemDsn_C_ERR(String pValeur_C_ERR)
  {
    m_listeFluxPrimIndemDsn_C_ERR = pValeur_C_ERR;
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
    if ("m_fluxCtPasDsn_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_listeFluxPrimIndemDsn_C_ERR".equals(attrName)) {
      return String.class;
    }
    return null;
  }
  
  public PropertyInfo _getPropertyInfo(String pElementName)
    throws TechniqueException
  {
    if ("FluxCtPasDsn".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, _FluxCtPasDsn.class, false);
      return info;
    }
    if ("ListeFluxPrimIndemDsn".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, _ListeFluxPrimIndemDsn.class, false);
      return info;
    }
    return null;
  }
  
  public int _getPropertyLength(String pElementName)
  {
    if ("FluxCtPasDsn".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("ListeFluxPrimIndemDsn".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    return -1;
  }
  
  public Object _getProperty(String pName)
    throws Exception
  {
    if ("FluxCtPasDsn".equals(pName)) {
      return m_fluxCtPasDsn;
    }
    if ("ListeFluxPrimIndemDsn".equals(pName)) {
      return m_listeFluxPrimIndemDsn;
    }
    return null;
  }
  
  public Iterator _getPropertyNames()
    throws Exception
  {
    ArrayList liste = new ArrayList();
    liste.add("FluxCtPasDsn");
    liste.add("ListeFluxPrimIndemDsn");
    return liste.iterator();
  }
  
  public ArrayList _getPropertyNames(ArrayList pListe)
    throws Exception
  {
    pListe.add("FluxCtPasDsn");
    pListe.add("ListeFluxPrimIndemDsn");
    return pListe;
  }
  
  public void _setProperty(String pName, Object pValeur)
    throws Exception
  {
    if ("FluxCtPasDsn".equals(pName)) {
      m_fluxCtPasDsn = ((_FluxCtPasDsn)pValeur);
    }
    if ("ListeFluxPrimIndemDsn".equals(pName)) {
      m_listeFluxPrimIndemDsn = ((_ListeFluxPrimIndemDsn)pValeur);
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
    if ("m_fluxCtPasDsn_C_ERR".equals(attrName)) {
      m_fluxCtPasDsn_C_ERR = pValeur;
    }
    if ("m_listeFluxPrimIndemDsn_C_ERR".equals(attrName)) {
      m_listeFluxPrimIndemDsn_C_ERR = pValeur;
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
    if ("m_fluxCtPasDsn_C_ERR".equals(attrName)) {
      return m_fluxCtPasDsn_C_ERR;
    }
    if ("m_listeFluxPrimIndemDsn_C_ERR".equals(attrName)) {
      return m_listeFluxPrimIndemDsn_C_ERR;
    }
    return null;
  }
  
  public boolean equals(Object pObjet)
  {
    if (!(pObjet instanceof _FluxDSN)) {
      return false;
    }
    _FluxDSN x = (_FluxDSN)pObjet;
    if (m_fluxCtPasDsn == null)
    {
      if (m_fluxCtPasDsn != null) {
        return false;
      }
    }
    else
    {
      if (m_fluxCtPasDsn == null) {
        return false;
      }
      if (!m_fluxCtPasDsn.equals(m_fluxCtPasDsn)) {
        return false;
      }
    }
    if (m_listeFluxPrimIndemDsn == null)
    {
      if (m_listeFluxPrimIndemDsn != null) {
        return false;
      }
    }
    else
    {
      if (m_listeFluxPrimIndemDsn == null) {
        return false;
      }
      if (!m_listeFluxPrimIndemDsn.equals(m_listeFluxPrimIndemDsn)) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int result = 0;
    if (m_fluxCtPasDsn != null) {
      result += m_fluxCtPasDsn.hashCode();
    }
    if (m_listeFluxPrimIndemDsn != null) {
      result += m_listeFluxPrimIndemDsn.hashCode();
    }
    result *= 17;
    return result;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    _FluxDSN clone_FluxDSN = new _FluxDSN();
    clone_FluxDSN.populateFrom_FluxDSN(this);
    return clone_FluxDSN;
  }
  
  public void populateFrom_FluxDSN(_FluxDSN pSource)
  {
    setFluxCtPasDsn(pSource.getFluxCtPasDsn());setListeFluxPrimIndemDsn(pSource.getListeFluxPrimIndemDsn());
  }
  
  public String toString()
  {
    StringBuffer s = new StringBuffer("[_FluxDSN");
    subToString(s);
    s.append("]");
    return s.toString();
  }
  
  protected void subToString(StringBuffer pSource)
  {
    pSource.append(", FluxCtPasDsn: ");
    pSource.append(m_fluxCtPasDsn);
    pSource.append(", ListeFluxPrimIndemDsn: ");
    pSource.append(m_listeFluxPrimIndemDsn);
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
    DataBean FluxCtPasDsn_Value = getFluxCtPasDsn();
    GettersHandler FluxCtPasDsn_GettersHandler = pHandler.property("FluxCtPasDsn", FluxCtPasDsn_Value, new Attribute[] { new StringAttribute("C_ERR", getFluxCtPasDsn_C_ERR()) });
    if ((FluxCtPasDsn_GettersHandler != null) && (FluxCtPasDsn_Value != null)) {
      FluxCtPasDsn_Value.goThrough(FluxCtPasDsn_GettersHandler);
    }
    DataBean ListeFluxPrimIndemDsn_Value = getListeFluxPrimIndemDsn();
    GettersHandler ListeFluxPrimIndemDsn_GettersHandler = pHandler.property("ListeFluxPrimIndemDsn", ListeFluxPrimIndemDsn_Value, new Attribute[] { new StringAttribute("C_ERR", getListeFluxPrimIndemDsn_C_ERR()) });
    if ((ListeFluxPrimIndemDsn_GettersHandler != null) && (ListeFluxPrimIndemDsn_Value != null)) {
      ListeFluxPrimIndemDsn_Value.goThrough(ListeFluxPrimIndemDsn_GettersHandler);
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
    setFluxCtPasDsn((_FluxCtPasDsn)pHandler.databeanProperty("FluxCtPasDsn", _FluxCtPasDsn.class));
    setFluxCtPasDsn_C_ERR(pHandler.stringAttribute("FluxCtPasDsn", "C_ERR"));
    setListeFluxPrimIndemDsn((_ListeFluxPrimIndemDsn)pHandler.databeanProperty("ListeFluxPrimIndemDsn", _ListeFluxPrimIndemDsn.class));
    setListeFluxPrimIndemDsn_C_ERR(pHandler.stringAttribute("ListeFluxPrimIndemDsn", "C_ERR"));
  }
  
  public String _getDatabeanName()
  {
    return "FluxDSN";
  }
  
  public boolean _isValidProperty(String pElementName)
  {
    if ("FluxCtPasDsn".equals(pElementName)) {
      return true;
    }
    if ("ListeFluxPrimIndemDsn".equals(pElementName)) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _FluxDSN
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */