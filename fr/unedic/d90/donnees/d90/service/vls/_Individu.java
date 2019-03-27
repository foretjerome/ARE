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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;

public class _Individu
  extends DataBeanImpl
  implements DataBean, Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  private String m__C_ETAT;
  private String m__IDENT;
  private String m_identifiantSigma;
  private String m_identifiantSigma_C_ERR;
  private String m_codeAntenne;
  private String m_codeAntenne_C_ERR;
  private String m_nomPopulation;
  private String m_nomPopulation_C_ERR;
  private Damj m_dateReexecution;
  private String m_dateReexecution_C_ERR;
  private BigDecimal m_identifiantBNI;
  private String m_identifiantBNI_C_ERR;
  
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
  
  public String getIdentifiantSigma()
  {
    return m_identifiantSigma;
  }
  
  public String getIdentifiantSigma_C_ERR()
  {
    return m_identifiantSigma_C_ERR;
  }
  
  public void setIdentifiantSigma(String pValeur)
  {
    m_identifiantSigma = pValeur;
  }
  
  public void setIdentifiantSigma_C_ERR(String pValeur_C_ERR)
  {
    m_identifiantSigma_C_ERR = pValeur_C_ERR;
  }
  
  public String getCodeAntenne()
  {
    return m_codeAntenne;
  }
  
  public String getCodeAntenne_C_ERR()
  {
    return m_codeAntenne_C_ERR;
  }
  
  public void setCodeAntenne(String pValeur)
  {
    m_codeAntenne = pValeur;
  }
  
  public void setCodeAntenne_C_ERR(String pValeur_C_ERR)
  {
    m_codeAntenne_C_ERR = pValeur_C_ERR;
  }
  
  public String getNomPopulation()
  {
    return m_nomPopulation;
  }
  
  public String getNomPopulation_C_ERR()
  {
    return m_nomPopulation_C_ERR;
  }
  
  public void setNomPopulation(String pValeur)
  {
    m_nomPopulation = pValeur;
  }
  
  public void setNomPopulation_C_ERR(String pValeur_C_ERR)
  {
    m_nomPopulation_C_ERR = pValeur_C_ERR;
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
  
  public BigDecimal getIdentifiantBNI()
  {
    return m_identifiantBNI;
  }
  
  public String getIdentifiantBNI_C_ERR()
  {
    return m_identifiantBNI_C_ERR;
  }
  
  public void setIdentifiantBNI(BigDecimal pValeur)
  {
    m_identifiantBNI = pValeur;
  }
  
  public void setIdentifiantBNI_C_ERR(String pValeur_C_ERR)
  {
    m_identifiantBNI_C_ERR = pValeur_C_ERR;
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
    if ("m_identifiantSigma_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_codeAntenne_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_nomPopulation_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateReexecution_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_identifiantBNI_C_ERR".equals(attrName)) {
      return String.class;
    }
    return null;
  }
  
  public PropertyInfo _getPropertyInfo(String pElementName)
    throws TechniqueException
  {
    if ("IdentifiantSigma".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("CodeAntenne".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("NomPopulation".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("DateReexecution".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("IdentifiantBNI".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    return null;
  }
  
  public int _getPropertyLength(String pElementName)
  {
    if ("IdentifiantSigma".equals(pElementName)) {
      return 8;
    }
    if ("CodeAntenne".equals(pElementName)) {
      return 3;
    }
    if ("NomPopulation".equals(pElementName)) {
      return 50;
    }
    if ("DateReexecution".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("IdentifiantBNI".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    return -1;
  }
  
  public Object _getProperty(String pName)
    throws Exception
  {
    if ("IdentifiantSigma".equals(pName)) {
      return m_identifiantSigma;
    }
    if ("CodeAntenne".equals(pName)) {
      return m_codeAntenne;
    }
    if ("NomPopulation".equals(pName)) {
      return m_nomPopulation;
    }
    if ("DateReexecution".equals(pName)) {
      return m_dateReexecution;
    }
    if ("IdentifiantBNI".equals(pName)) {
      return m_identifiantBNI;
    }
    return null;
  }
  
  public Iterator _getPropertyNames()
    throws Exception
  {
    ArrayList liste = new ArrayList();
    liste.add("IdentifiantSigma");
    liste.add("CodeAntenne");
    liste.add("NomPopulation");
    liste.add("DateReexecution");
    liste.add("IdentifiantBNI");
    return liste.iterator();
  }
  
  public ArrayList _getPropertyNames(ArrayList pListe)
    throws Exception
  {
    pListe.add("IdentifiantSigma");
    pListe.add("CodeAntenne");
    pListe.add("NomPopulation");
    pListe.add("DateReexecution");
    pListe.add("IdentifiantBNI");
    return pListe;
  }
  
  public void _setProperty(String pName, Object pValeur)
    throws Exception
  {
    if ("IdentifiantSigma".equals(pName)) {
      m_identifiantSigma = ((String)pValeur);
    }
    if ("CodeAntenne".equals(pName)) {
      m_codeAntenne = ((String)pValeur);
    }
    if ("NomPopulation".equals(pName)) {
      m_nomPopulation = ((String)pValeur);
    }
    if ("DateReexecution".equals(pName)) {
      m_dateReexecution = ((Damj)pValeur);
    }
    if ("IdentifiantBNI".equals(pName)) {
      m_identifiantBNI = ((BigDecimal)pValeur);
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
    if ("m_identifiantSigma_C_ERR".equals(attrName)) {
      m_identifiantSigma_C_ERR = pValeur;
    }
    if ("m_codeAntenne_C_ERR".equals(attrName)) {
      m_codeAntenne_C_ERR = pValeur;
    }
    if ("m_nomPopulation_C_ERR".equals(attrName)) {
      m_nomPopulation_C_ERR = pValeur;
    }
    if ("m_dateReexecution_C_ERR".equals(attrName)) {
      m_dateReexecution_C_ERR = pValeur;
    }
    if ("m_identifiantBNI_C_ERR".equals(attrName)) {
      m_identifiantBNI_C_ERR = pValeur;
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
    if ("m_identifiantSigma_C_ERR".equals(attrName)) {
      return m_identifiantSigma_C_ERR;
    }
    if ("m_codeAntenne_C_ERR".equals(attrName)) {
      return m_codeAntenne_C_ERR;
    }
    if ("m_nomPopulation_C_ERR".equals(attrName)) {
      return m_nomPopulation_C_ERR;
    }
    if ("m_dateReexecution_C_ERR".equals(attrName)) {
      return m_dateReexecution_C_ERR;
    }
    if ("m_identifiantBNI_C_ERR".equals(attrName)) {
      return m_identifiantBNI_C_ERR;
    }
    return null;
  }
  
  public boolean equals(Object pObjet)
  {
    if (!(pObjet instanceof _Individu)) {
      return false;
    }
    _Individu x = (_Individu)pObjet;
    if (m_identifiantSigma == null)
    {
      if (m_identifiantSigma != null) {
        return false;
      }
    }
    else
    {
      if (m_identifiantSigma == null) {
        return false;
      }
      if (!m_identifiantSigma.equals(m_identifiantSigma)) {
        return false;
      }
    }
    if (m_codeAntenne == null)
    {
      if (m_codeAntenne != null) {
        return false;
      }
    }
    else
    {
      if (m_codeAntenne == null) {
        return false;
      }
      if (!m_codeAntenne.equals(m_codeAntenne)) {
        return false;
      }
    }
    if (m_nomPopulation == null)
    {
      if (m_nomPopulation != null) {
        return false;
      }
    }
    else
    {
      if (m_nomPopulation == null) {
        return false;
      }
      if (!m_nomPopulation.equals(m_nomPopulation)) {
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
    if (m_identifiantBNI == null)
    {
      if (m_identifiantBNI != null) {
        return false;
      }
    }
    else
    {
      if (m_identifiantBNI == null) {
        return false;
      }
      if (!m_identifiantBNI.equals(m_identifiantBNI)) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int result = 0;
    if (m_identifiantSigma != null) {
      result += m_identifiantSigma.hashCode();
    }
    if (m_codeAntenne != null) {
      result += m_codeAntenne.hashCode();
    }
    if (m_nomPopulation != null) {
      result += m_nomPopulation.hashCode();
    }
    if (m_dateReexecution != null) {
      result += m_dateReexecution.hashCode();
    }
    if (m_identifiantBNI != null) {
      result += m_identifiantBNI.hashCode();
    }
    result *= 17;
    return result;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    _Individu clone_Individu = new _Individu();
    clone_Individu.populateFrom_Individu(this);
    return clone_Individu;
  }
  
  public void populateFrom_Individu(_Individu pSource)
  {
    setIdentifiantSigma(pSource.getIdentifiantSigma());setCodeAntenne(pSource.getCodeAntenne());setNomPopulation(pSource.getNomPopulation());setDateReexecution(pSource.getDateReexecution());setIdentifiantBNI(pSource.getIdentifiantBNI());
  }
  
  public String toString()
  {
    StringBuffer s = new StringBuffer("[_Individu");
    subToString(s);
    s.append("]");
    return s.toString();
  }
  
  protected void subToString(StringBuffer pSource)
  {
    pSource.append(", IdentifiantSigma: ");
    pSource.append(m_identifiantSigma);
    pSource.append(", CodeAntenne: ");
    pSource.append(m_codeAntenne);
    pSource.append(", NomPopulation: ");
    pSource.append(m_nomPopulation);
    pSource.append(", DateReexecution: ");
    pSource.append(m_dateReexecution);
    pSource.append(", IdentifiantBNI: ");
    pSource.append(m_identifiantBNI);
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
    pHandler.property("IdentifiantSigma", getIdentifiantSigma(), new Attribute[] { new StringAttribute("C_ERR", getIdentifiantSigma_C_ERR()) });
    
    pHandler.property("CodeAntenne", getCodeAntenne(), new Attribute[] { new StringAttribute("C_ERR", getCodeAntenne_C_ERR()) });
    
    pHandler.property("NomPopulation", getNomPopulation(), new Attribute[] { new StringAttribute("C_ERR", getNomPopulation_C_ERR()) });
    
    pHandler.property("DateReexecution", getDateReexecution(), new Attribute[] { new StringAttribute("C_ERR", getDateReexecution_C_ERR()) });
    
    pHandler.property("IdentifiantBNI", getIdentifiantBNI(), new Attribute[] { new StringAttribute("C_ERR", getIdentifiantBNI_C_ERR()) });
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
    setIdentifiantSigma((String)pHandler.objectProperty("IdentifiantSigma", String.class));
    setIdentifiantSigma_C_ERR(pHandler.stringAttribute("IdentifiantSigma", "C_ERR"));
    
    setCodeAntenne((String)pHandler.objectProperty("CodeAntenne", String.class));
    setCodeAntenne_C_ERR(pHandler.stringAttribute("CodeAntenne", "C_ERR"));
    
    setNomPopulation((String)pHandler.objectProperty("NomPopulation", String.class));
    setNomPopulation_C_ERR(pHandler.stringAttribute("NomPopulation", "C_ERR"));
    
    setDateReexecution((Damj)pHandler.objectProperty("DateReexecution", Damj.class));
    setDateReexecution_C_ERR(pHandler.stringAttribute("DateReexecution", "C_ERR"));
    
    setIdentifiantBNI((BigDecimal)pHandler.objectProperty("IdentifiantBNI", BigDecimal.class));
    setIdentifiantBNI_C_ERR(pHandler.stringAttribute("IdentifiantBNI", "C_ERR"));
  }
  
  public String _getDatabeanName()
  {
    return "Individu";
  }
  
  public boolean _isValidProperty(String pElementName)
  {
    if ("IdentifiantSigma".equals(pElementName)) {
      return true;
    }
    if ("CodeAntenne".equals(pElementName)) {
      return true;
    }
    if ("NomPopulation".equals(pElementName)) {
      return true;
    }
    if ("DateReexecution".equals(pElementName)) {
      return true;
    }
    if ("IdentifiantBNI".equals(pElementName)) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _Individu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */