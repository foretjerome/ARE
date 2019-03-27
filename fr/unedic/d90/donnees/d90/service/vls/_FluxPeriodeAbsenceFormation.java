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

public class _FluxPeriodeAbsenceFormation
  extends DataBeanImpl
  implements DataBean, Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  private String m__C_ETAT;
  private String m__IDENT;
  private Damj m_dateDebutAbsence;
  private String m_dateDebutAbsence_C_ERR;
  private Damj m_dateFinAbsence;
  private String m_dateFinAbsence_C_ERR;
  private String m_codeAction;
  private String m_codeAction_C_ERR;
  private String m_motifAbsence;
  private String m_motifAbsence_C_ERR;
  
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
  
  public Damj getDateDebutAbsence()
  {
    return m_dateDebutAbsence;
  }
  
  public String getDateDebutAbsence_C_ERR()
  {
    return m_dateDebutAbsence_C_ERR;
  }
  
  public void setDateDebutAbsence(Damj pValeur)
  {
    m_dateDebutAbsence = pValeur;
  }
  
  public void setDateDebutAbsence_C_ERR(String pValeur_C_ERR)
  {
    m_dateDebutAbsence_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDateFinAbsence()
  {
    return m_dateFinAbsence;
  }
  
  public String getDateFinAbsence_C_ERR()
  {
    return m_dateFinAbsence_C_ERR;
  }
  
  public void setDateFinAbsence(Damj pValeur)
  {
    m_dateFinAbsence = pValeur;
  }
  
  public void setDateFinAbsence_C_ERR(String pValeur_C_ERR)
  {
    m_dateFinAbsence_C_ERR = pValeur_C_ERR;
  }
  
  public String getCodeAction()
  {
    return m_codeAction;
  }
  
  public String getCodeAction_C_ERR()
  {
    return m_codeAction_C_ERR;
  }
  
  public void setCodeAction(String pValeur)
  {
    m_codeAction = pValeur;
  }
  
  public void setCodeAction_C_ERR(String pValeur_C_ERR)
  {
    m_codeAction_C_ERR = pValeur_C_ERR;
  }
  
  public String getMotifAbsence()
  {
    return m_motifAbsence;
  }
  
  public String getMotifAbsence_C_ERR()
  {
    return m_motifAbsence_C_ERR;
  }
  
  public void setMotifAbsence(String pValeur)
  {
    m_motifAbsence = pValeur;
  }
  
  public void setMotifAbsence_C_ERR(String pValeur_C_ERR)
  {
    m_motifAbsence_C_ERR = pValeur_C_ERR;
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
    if ("m_dateDebutAbsence_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateFinAbsence_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_codeAction_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_motifAbsence_C_ERR".equals(attrName)) {
      return String.class;
    }
    return null;
  }
  
  public PropertyInfo _getPropertyInfo(String pElementName)
    throws TechniqueException
  {
    if ("dateDebutAbsence".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("dateFinAbsence".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("codeAction".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("motifAbsence".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    return null;
  }
  
  public int _getPropertyLength(String pElementName)
  {
    if ("dateDebutAbsence".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("dateFinAbsence".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("codeAction".equals(pElementName)) {
      return 1;
    }
    if ("motifAbsence".equals(pElementName)) {
      return 2;
    }
    return -1;
  }
  
  public Object _getProperty(String pName)
    throws Exception
  {
    if ("dateDebutAbsence".equals(pName)) {
      return m_dateDebutAbsence;
    }
    if ("dateFinAbsence".equals(pName)) {
      return m_dateFinAbsence;
    }
    if ("codeAction".equals(pName)) {
      return m_codeAction;
    }
    if ("motifAbsence".equals(pName)) {
      return m_motifAbsence;
    }
    return null;
  }
  
  public Iterator _getPropertyNames()
    throws Exception
  {
    ArrayList liste = new ArrayList();
    liste.add("dateDebutAbsence");
    liste.add("dateFinAbsence");
    liste.add("codeAction");
    liste.add("motifAbsence");
    return liste.iterator();
  }
  
  public ArrayList _getPropertyNames(ArrayList pListe)
    throws Exception
  {
    pListe.add("dateDebutAbsence");
    pListe.add("dateFinAbsence");
    pListe.add("codeAction");
    pListe.add("motifAbsence");
    return pListe;
  }
  
  public void _setProperty(String pName, Object pValeur)
    throws Exception
  {
    if ("dateDebutAbsence".equals(pName)) {
      m_dateDebutAbsence = ((Damj)pValeur);
    }
    if ("dateFinAbsence".equals(pName)) {
      m_dateFinAbsence = ((Damj)pValeur);
    }
    if ("codeAction".equals(pName)) {
      m_codeAction = ((String)pValeur);
    }
    if ("motifAbsence".equals(pName)) {
      m_motifAbsence = ((String)pValeur);
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
    if ("m_dateDebutAbsence_C_ERR".equals(attrName)) {
      m_dateDebutAbsence_C_ERR = pValeur;
    }
    if ("m_dateFinAbsence_C_ERR".equals(attrName)) {
      m_dateFinAbsence_C_ERR = pValeur;
    }
    if ("m_codeAction_C_ERR".equals(attrName)) {
      m_codeAction_C_ERR = pValeur;
    }
    if ("m_motifAbsence_C_ERR".equals(attrName)) {
      m_motifAbsence_C_ERR = pValeur;
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
    if ("m_dateDebutAbsence_C_ERR".equals(attrName)) {
      return m_dateDebutAbsence_C_ERR;
    }
    if ("m_dateFinAbsence_C_ERR".equals(attrName)) {
      return m_dateFinAbsence_C_ERR;
    }
    if ("m_codeAction_C_ERR".equals(attrName)) {
      return m_codeAction_C_ERR;
    }
    if ("m_motifAbsence_C_ERR".equals(attrName)) {
      return m_motifAbsence_C_ERR;
    }
    return null;
  }
  
  public boolean equals(Object pObjet)
  {
    if (!(pObjet instanceof _FluxPeriodeAbsenceFormation)) {
      return false;
    }
    _FluxPeriodeAbsenceFormation x = (_FluxPeriodeAbsenceFormation)pObjet;
    if (m_dateDebutAbsence == null)
    {
      if (m_dateDebutAbsence != null) {
        return false;
      }
    }
    else
    {
      if (m_dateDebutAbsence == null) {
        return false;
      }
      if (!m_dateDebutAbsence.equals(m_dateDebutAbsence)) {
        return false;
      }
    }
    if (m_dateFinAbsence == null)
    {
      if (m_dateFinAbsence != null) {
        return false;
      }
    }
    else
    {
      if (m_dateFinAbsence == null) {
        return false;
      }
      if (!m_dateFinAbsence.equals(m_dateFinAbsence)) {
        return false;
      }
    }
    if (m_codeAction == null)
    {
      if (m_codeAction != null) {
        return false;
      }
    }
    else
    {
      if (m_codeAction == null) {
        return false;
      }
      if (!m_codeAction.equals(m_codeAction)) {
        return false;
      }
    }
    if (m_motifAbsence == null)
    {
      if (m_motifAbsence != null) {
        return false;
      }
    }
    else
    {
      if (m_motifAbsence == null) {
        return false;
      }
      if (!m_motifAbsence.equals(m_motifAbsence)) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int result = 0;
    if (m_dateDebutAbsence != null) {
      result += m_dateDebutAbsence.hashCode();
    }
    if (m_dateFinAbsence != null) {
      result += m_dateFinAbsence.hashCode();
    }
    if (m_codeAction != null) {
      result += m_codeAction.hashCode();
    }
    if (m_motifAbsence != null) {
      result += m_motifAbsence.hashCode();
    }
    result *= 17;
    return result;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    _FluxPeriodeAbsenceFormation clone_FluxPeriodeAbsenceFormation = new _FluxPeriodeAbsenceFormation();
    clone_FluxPeriodeAbsenceFormation.populateFrom_FluxPeriodeAbsenceFormation(this);
    return clone_FluxPeriodeAbsenceFormation;
  }
  
  public void populateFrom_FluxPeriodeAbsenceFormation(_FluxPeriodeAbsenceFormation pSource)
  {
    setDateDebutAbsence(pSource.getDateDebutAbsence());setDateFinAbsence(pSource.getDateFinAbsence());setCodeAction(pSource.getCodeAction());setMotifAbsence(pSource.getMotifAbsence());
  }
  
  public String toString()
  {
    StringBuffer s = new StringBuffer("[_FluxPeriodeAbsenceFormation");
    subToString(s);
    s.append("]");
    return s.toString();
  }
  
  protected void subToString(StringBuffer pSource)
  {
    pSource.append(", dateDebutAbsence: ");
    pSource.append(m_dateDebutAbsence);
    pSource.append(", dateFinAbsence: ");
    pSource.append(m_dateFinAbsence);
    pSource.append(", codeAction: ");
    pSource.append(m_codeAction);
    pSource.append(", motifAbsence: ");
    pSource.append(m_motifAbsence);
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
    pHandler.property("dateDebutAbsence", getDateDebutAbsence(), new Attribute[] { new StringAttribute("C_ERR", getDateDebutAbsence_C_ERR()) });
    
    pHandler.property("dateFinAbsence", getDateFinAbsence(), new Attribute[] { new StringAttribute("C_ERR", getDateFinAbsence_C_ERR()) });
    
    pHandler.property("codeAction", getCodeAction(), new Attribute[] { new StringAttribute("C_ERR", getCodeAction_C_ERR()) });
    
    pHandler.property("motifAbsence", getMotifAbsence(), new Attribute[] { new StringAttribute("C_ERR", getMotifAbsence_C_ERR()) });
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
    setDateDebutAbsence((Damj)pHandler.objectProperty("dateDebutAbsence", Damj.class));
    setDateDebutAbsence_C_ERR(pHandler.stringAttribute("dateDebutAbsence", "C_ERR"));
    
    setDateFinAbsence((Damj)pHandler.objectProperty("dateFinAbsence", Damj.class));
    setDateFinAbsence_C_ERR(pHandler.stringAttribute("dateFinAbsence", "C_ERR"));
    
    setCodeAction((String)pHandler.objectProperty("codeAction", String.class));
    setCodeAction_C_ERR(pHandler.stringAttribute("codeAction", "C_ERR"));
    
    setMotifAbsence((String)pHandler.objectProperty("motifAbsence", String.class));
    setMotifAbsence_C_ERR(pHandler.stringAttribute("motifAbsence", "C_ERR"));
  }
  
  public String _getDatabeanName()
  {
    return "FluxPeriodeAbsenceFormation";
  }
  
  public boolean _isValidProperty(String pElementName)
  {
    if ("dateDebutAbsence".equals(pElementName)) {
      return true;
    }
    if ("dateFinAbsence".equals(pElementName)) {
      return true;
    }
    if ("codeAction".equals(pElementName)) {
      return true;
    }
    if ("motifAbsence".equals(pElementName)) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _FluxPeriodeAbsenceFormation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */