package fr.pe.d12dal.service.es.dal;

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

public class _InfosLiquidationDal
  extends DataBeanImpl
  implements DataBean, Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  private String m__C_ETAT;
  private String m__IDENT;
  private Boolean m_topPresenceFormation = null;
  private String m_topPresenceFormation_C_ERR;
  private Boolean m_topDemandeLiquidable = null;
  private String m_topDemandeLiquidable_C_ERR;
  private Boolean m_topDemandeComplete = null;
  private String m_topDemandeComplete_C_ERR;
  private Boolean m_topLiquidationAuto = null;
  private String m_topLiquidationAuto_C_ERR;
  private Boolean m_topDemandeWebKO = null;
  private String m_topDemandeWebKO_C_ERR;
  private Boolean m_topLiquidationStandardAuto = null;
  private String m_topLiquidationStandardAuto_C_ERR;
  
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
  
  public Boolean getTopPresenceFormation()
  {
    return m_topPresenceFormation;
  }
  
  public String getTopPresenceFormation_C_ERR()
  {
    return m_topPresenceFormation_C_ERR;
  }
  
  public void setTopPresenceFormation(Boolean pValeur)
  {
    m_topPresenceFormation = pValeur;
  }
  
  public void setTopPresenceFormation_C_ERR(String pValeur_C_ERR)
  {
    m_topPresenceFormation_C_ERR = pValeur_C_ERR;
  }
  
  public Boolean getTopDemandeLiquidable()
  {
    return m_topDemandeLiquidable;
  }
  
  public String getTopDemandeLiquidable_C_ERR()
  {
    return m_topDemandeLiquidable_C_ERR;
  }
  
  public void setTopDemandeLiquidable(Boolean pValeur)
  {
    m_topDemandeLiquidable = pValeur;
  }
  
  public void setTopDemandeLiquidable_C_ERR(String pValeur_C_ERR)
  {
    m_topDemandeLiquidable_C_ERR = pValeur_C_ERR;
  }
  
  public Boolean getTopDemandeComplete()
  {
    return m_topDemandeComplete;
  }
  
  public String getTopDemandeComplete_C_ERR()
  {
    return m_topDemandeComplete_C_ERR;
  }
  
  public void setTopDemandeComplete(Boolean pValeur)
  {
    m_topDemandeComplete = pValeur;
  }
  
  public void setTopDemandeComplete_C_ERR(String pValeur_C_ERR)
  {
    m_topDemandeComplete_C_ERR = pValeur_C_ERR;
  }
  
  public Boolean getTopLiquidationAuto()
  {
    return m_topLiquidationAuto;
  }
  
  public String getTopLiquidationAuto_C_ERR()
  {
    return m_topLiquidationAuto_C_ERR;
  }
  
  public void setTopLiquidationAuto(Boolean pValeur)
  {
    m_topLiquidationAuto = pValeur;
  }
  
  public void setTopLiquidationAuto_C_ERR(String pValeur_C_ERR)
  {
    m_topLiquidationAuto_C_ERR = pValeur_C_ERR;
  }
  
  public Boolean getTopDemandeWebKO()
  {
    return m_topDemandeWebKO;
  }
  
  public String getTopDemandeWebKO_C_ERR()
  {
    return m_topDemandeWebKO_C_ERR;
  }
  
  public void setTopDemandeWebKO(Boolean pValeur)
  {
    m_topDemandeWebKO = pValeur;
  }
  
  public void setTopDemandeWebKO_C_ERR(String pValeur_C_ERR)
  {
    m_topDemandeWebKO_C_ERR = pValeur_C_ERR;
  }
  
  public Boolean getTopLiquidationStandardAuto()
  {
    return m_topLiquidationStandardAuto;
  }
  
  public String getTopLiquidationStandardAuto_C_ERR()
  {
    return m_topLiquidationStandardAuto_C_ERR;
  }
  
  public void setTopLiquidationStandardAuto(Boolean pValeur)
  {
    m_topLiquidationStandardAuto = pValeur;
  }
  
  public void setTopLiquidationStandardAuto_C_ERR(String pValeur_C_ERR)
  {
    m_topLiquidationStandardAuto_C_ERR = pValeur_C_ERR;
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
    if ("m_topPresenceFormation_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_topDemandeLiquidable_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_topDemandeComplete_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_topLiquidationAuto_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_topDemandeWebKO_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_topLiquidationStandardAuto_C_ERR".equals(attrName)) {
      return String.class;
    }
    return null;
  }
  
  public PropertyInfo _getPropertyInfo(String pElementName)
    throws TechniqueException
  {
    if ("topPresenceFormation".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Boolean.class, false);
      return info;
    }
    if ("topDemandeLiquidable".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Boolean.class, false);
      return info;
    }
    if ("topDemandeComplete".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Boolean.class, false);
      return info;
    }
    if ("topLiquidationAuto".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Boolean.class, false);
      return info;
    }
    if ("topDemandeWebKO".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Boolean.class, false);
      return info;
    }
    if ("topLiquidationStandardAuto".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Boolean.class, false);
      return info;
    }
    return null;
  }
  
  public int _getPropertyLength(String pElementName)
  {
    if ("topPresenceFormation".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("topDemandeLiquidable".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("topDemandeComplete".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("topLiquidationAuto".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("topDemandeWebKO".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("topLiquidationStandardAuto".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    return -1;
  }
  
  public Object _getProperty(String pName)
    throws Exception
  {
    if ("topPresenceFormation".equals(pName)) {
      return m_topPresenceFormation;
    }
    if ("topDemandeLiquidable".equals(pName)) {
      return m_topDemandeLiquidable;
    }
    if ("topDemandeComplete".equals(pName)) {
      return m_topDemandeComplete;
    }
    if ("topLiquidationAuto".equals(pName)) {
      return m_topLiquidationAuto;
    }
    if ("topDemandeWebKO".equals(pName)) {
      return m_topDemandeWebKO;
    }
    if ("topLiquidationStandardAuto".equals(pName)) {
      return m_topLiquidationStandardAuto;
    }
    return null;
  }
  
  public Iterator _getPropertyNames()
    throws Exception
  {
    ArrayList liste = new ArrayList();
    liste.add("topPresenceFormation");
    liste.add("topDemandeLiquidable");
    liste.add("topDemandeComplete");
    liste.add("topLiquidationAuto");
    liste.add("topDemandeWebKO");
    liste.add("topLiquidationStandardAuto");
    return liste.iterator();
  }
  
  public ArrayList _getPropertyNames(ArrayList pListe)
    throws Exception
  {
    pListe.add("topPresenceFormation");
    pListe.add("topDemandeLiquidable");
    pListe.add("topDemandeComplete");
    pListe.add("topLiquidationAuto");
    pListe.add("topDemandeWebKO");
    pListe.add("topLiquidationStandardAuto");
    return pListe;
  }
  
  public void _setProperty(String pName, Object pValeur)
    throws Exception
  {
    if ("topPresenceFormation".equals(pName)) {
      m_topPresenceFormation = ((Boolean)pValeur);
    }
    if ("topDemandeLiquidable".equals(pName)) {
      m_topDemandeLiquidable = ((Boolean)pValeur);
    }
    if ("topDemandeComplete".equals(pName)) {
      m_topDemandeComplete = ((Boolean)pValeur);
    }
    if ("topLiquidationAuto".equals(pName)) {
      m_topLiquidationAuto = ((Boolean)pValeur);
    }
    if ("topDemandeWebKO".equals(pName)) {
      m_topDemandeWebKO = ((Boolean)pValeur);
    }
    if ("topLiquidationStandardAuto".equals(pName)) {
      m_topLiquidationStandardAuto = ((Boolean)pValeur);
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
    if ("m_topPresenceFormation_C_ERR".equals(attrName)) {
      m_topPresenceFormation_C_ERR = pValeur;
    }
    if ("m_topDemandeLiquidable_C_ERR".equals(attrName)) {
      m_topDemandeLiquidable_C_ERR = pValeur;
    }
    if ("m_topDemandeComplete_C_ERR".equals(attrName)) {
      m_topDemandeComplete_C_ERR = pValeur;
    }
    if ("m_topLiquidationAuto_C_ERR".equals(attrName)) {
      m_topLiquidationAuto_C_ERR = pValeur;
    }
    if ("m_topDemandeWebKO_C_ERR".equals(attrName)) {
      m_topDemandeWebKO_C_ERR = pValeur;
    }
    if ("m_topLiquidationStandardAuto_C_ERR".equals(attrName)) {
      m_topLiquidationStandardAuto_C_ERR = pValeur;
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
    if ("m_topPresenceFormation_C_ERR".equals(attrName)) {
      return m_topPresenceFormation_C_ERR;
    }
    if ("m_topDemandeLiquidable_C_ERR".equals(attrName)) {
      return m_topDemandeLiquidable_C_ERR;
    }
    if ("m_topDemandeComplete_C_ERR".equals(attrName)) {
      return m_topDemandeComplete_C_ERR;
    }
    if ("m_topLiquidationAuto_C_ERR".equals(attrName)) {
      return m_topLiquidationAuto_C_ERR;
    }
    if ("m_topDemandeWebKO_C_ERR".equals(attrName)) {
      return m_topDemandeWebKO_C_ERR;
    }
    if ("m_topLiquidationStandardAuto_C_ERR".equals(attrName)) {
      return m_topLiquidationStandardAuto_C_ERR;
    }
    return null;
  }
  
  public boolean equals(Object pObjet)
  {
    if (!(pObjet instanceof _InfosLiquidationDal)) {
      return false;
    }
    _InfosLiquidationDal x = (_InfosLiquidationDal)pObjet;
    if (m_topPresenceFormation == null)
    {
      if (m_topPresenceFormation != null) {
        return false;
      }
    }
    else
    {
      if (m_topPresenceFormation == null) {
        return false;
      }
      if (!m_topPresenceFormation.equals(m_topPresenceFormation)) {
        return false;
      }
    }
    if (m_topDemandeLiquidable == null)
    {
      if (m_topDemandeLiquidable != null) {
        return false;
      }
    }
    else
    {
      if (m_topDemandeLiquidable == null) {
        return false;
      }
      if (!m_topDemandeLiquidable.equals(m_topDemandeLiquidable)) {
        return false;
      }
    }
    if (m_topDemandeComplete == null)
    {
      if (m_topDemandeComplete != null) {
        return false;
      }
    }
    else
    {
      if (m_topDemandeComplete == null) {
        return false;
      }
      if (!m_topDemandeComplete.equals(m_topDemandeComplete)) {
        return false;
      }
    }
    if (m_topLiquidationAuto == null)
    {
      if (m_topLiquidationAuto != null) {
        return false;
      }
    }
    else
    {
      if (m_topLiquidationAuto == null) {
        return false;
      }
      if (!m_topLiquidationAuto.equals(m_topLiquidationAuto)) {
        return false;
      }
    }
    if (m_topDemandeWebKO == null)
    {
      if (m_topDemandeWebKO != null) {
        return false;
      }
    }
    else
    {
      if (m_topDemandeWebKO == null) {
        return false;
      }
      if (!m_topDemandeWebKO.equals(m_topDemandeWebKO)) {
        return false;
      }
    }
    if (m_topLiquidationStandardAuto == null)
    {
      if (m_topLiquidationStandardAuto != null) {
        return false;
      }
    }
    else
    {
      if (m_topLiquidationStandardAuto == null) {
        return false;
      }
      if (!m_topLiquidationStandardAuto.equals(m_topLiquidationStandardAuto)) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int result = 0;
    if (m_topPresenceFormation != null) {
      result += m_topPresenceFormation.hashCode();
    }
    if (m_topDemandeLiquidable != null) {
      result += m_topDemandeLiquidable.hashCode();
    }
    if (m_topDemandeComplete != null) {
      result += m_topDemandeComplete.hashCode();
    }
    if (m_topLiquidationAuto != null) {
      result += m_topLiquidationAuto.hashCode();
    }
    if (m_topDemandeWebKO != null) {
      result += m_topDemandeWebKO.hashCode();
    }
    if (m_topLiquidationStandardAuto != null) {
      result += m_topLiquidationStandardAuto.hashCode();
    }
    result *= 17;
    return result;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    _InfosLiquidationDal clone_InfosLiquidationDal = new _InfosLiquidationDal();
    clone_InfosLiquidationDal.populateFrom_InfosLiquidationDal(this);
    return clone_InfosLiquidationDal;
  }
  
  public void populateFrom_InfosLiquidationDal(_InfosLiquidationDal pSource)
  {
    setTopPresenceFormation(pSource.getTopPresenceFormation());setTopDemandeLiquidable(pSource.getTopDemandeLiquidable());setTopDemandeComplete(pSource.getTopDemandeComplete());setTopLiquidationAuto(pSource.getTopLiquidationAuto());setTopDemandeWebKO(pSource.getTopDemandeWebKO());setTopLiquidationStandardAuto(pSource.getTopLiquidationStandardAuto());
  }
  
  public String toString()
  {
    StringBuffer s = new StringBuffer("[_InfosLiquidationDal");
    subToString(s);
    s.append("]");
    return s.toString();
  }
  
  protected void subToString(StringBuffer pSource)
  {
    pSource.append(", topPresenceFormation: ");
    pSource.append(m_topPresenceFormation);
    pSource.append(", topDemandeLiquidable: ");
    pSource.append(m_topDemandeLiquidable);
    pSource.append(", topDemandeComplete: ");
    pSource.append(m_topDemandeComplete);
    pSource.append(", topLiquidationAuto: ");
    pSource.append(m_topLiquidationAuto);
    pSource.append(", topDemandeWebKO: ");
    pSource.append(m_topDemandeWebKO);
    pSource.append(", topLiquidationStandardAuto: ");
    pSource.append(m_topLiquidationStandardAuto);
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
    pHandler.property("topPresenceFormation", getTopPresenceFormation(), new Attribute[] { new StringAttribute("C_ERR", getTopPresenceFormation_C_ERR()) });
    
    pHandler.property("topDemandeLiquidable", getTopDemandeLiquidable(), new Attribute[] { new StringAttribute("C_ERR", getTopDemandeLiquidable_C_ERR()) });
    
    pHandler.property("topDemandeComplete", getTopDemandeComplete(), new Attribute[] { new StringAttribute("C_ERR", getTopDemandeComplete_C_ERR()) });
    
    pHandler.property("topLiquidationAuto", getTopLiquidationAuto(), new Attribute[] { new StringAttribute("C_ERR", getTopLiquidationAuto_C_ERR()) });
    
    pHandler.property("topDemandeWebKO", getTopDemandeWebKO(), new Attribute[] { new StringAttribute("C_ERR", getTopDemandeWebKO_C_ERR()) });
    
    pHandler.property("topLiquidationStandardAuto", getTopLiquidationStandardAuto(), new Attribute[] { new StringAttribute("C_ERR", getTopLiquidationStandardAuto_C_ERR()) });
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
    setTopPresenceFormation((Boolean)pHandler.objectProperty("topPresenceFormation", Boolean.class));
    setTopPresenceFormation_C_ERR(pHandler.stringAttribute("topPresenceFormation", "C_ERR"));
    
    setTopDemandeLiquidable((Boolean)pHandler.objectProperty("topDemandeLiquidable", Boolean.class));
    setTopDemandeLiquidable_C_ERR(pHandler.stringAttribute("topDemandeLiquidable", "C_ERR"));
    
    setTopDemandeComplete((Boolean)pHandler.objectProperty("topDemandeComplete", Boolean.class));
    setTopDemandeComplete_C_ERR(pHandler.stringAttribute("topDemandeComplete", "C_ERR"));
    
    setTopLiquidationAuto((Boolean)pHandler.objectProperty("topLiquidationAuto", Boolean.class));
    setTopLiquidationAuto_C_ERR(pHandler.stringAttribute("topLiquidationAuto", "C_ERR"));
    
    setTopDemandeWebKO((Boolean)pHandler.objectProperty("topDemandeWebKO", Boolean.class));
    setTopDemandeWebKO_C_ERR(pHandler.stringAttribute("topDemandeWebKO", "C_ERR"));
    
    setTopLiquidationStandardAuto((Boolean)pHandler.objectProperty("topLiquidationStandardAuto", Boolean.class));
    setTopLiquidationStandardAuto_C_ERR(pHandler.stringAttribute("topLiquidationStandardAuto", "C_ERR"));
  }
  
  public String _getDatabeanName()
  {
    return "InfosLiquidationDal";
  }
  
  public boolean _isValidProperty(String pElementName)
  {
    if ("topPresenceFormation".equals(pElementName)) {
      return true;
    }
    if ("topDemandeLiquidable".equals(pElementName)) {
      return true;
    }
    if ("topDemandeComplete".equals(pElementName)) {
      return true;
    }
    if ("topLiquidationAuto".equals(pElementName)) {
      return true;
    }
    if ("topDemandeWebKO".equals(pElementName)) {
      return true;
    }
    if ("topLiquidationStandardAuto".equals(pElementName)) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _InfosLiquidationDal
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */