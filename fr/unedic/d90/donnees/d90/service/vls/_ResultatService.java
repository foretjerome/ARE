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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;

public class _ResultatService
  extends DataBeanImpl
  implements DataBean, Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  private String m__C_ETAT;
  private String m__IDENT;
  private _ListeErreurs m_listeErreurs;
  private String m_listeErreurs_C_ERR;
  private _ListeIndicateurs m_listeIndicateurs;
  private String m_listeIndicateurs_C_ERR;
  private BigDecimal m_etat;
  private String m_etat_C_ERR;
  private BigDecimal m_individuNCP;
  private String m_individuNCP_C_ERR;
  
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
  
  public _ListeErreurs getListeErreurs()
  {
    return m_listeErreurs;
  }
  
  public String getListeErreurs_C_ERR()
  {
    return m_listeErreurs_C_ERR;
  }
  
  public void setListeErreurs(_ListeErreurs pValeur)
  {
    m_listeErreurs = pValeur;
  }
  
  public void setListeErreurs_C_ERR(String pValeur_C_ERR)
  {
    m_listeErreurs_C_ERR = pValeur_C_ERR;
  }
  
  public _ListeIndicateurs getListeIndicateurs()
  {
    return m_listeIndicateurs;
  }
  
  public String getListeIndicateurs_C_ERR()
  {
    return m_listeIndicateurs_C_ERR;
  }
  
  public void setListeIndicateurs(_ListeIndicateurs pValeur)
  {
    m_listeIndicateurs = pValeur;
  }
  
  public void setListeIndicateurs_C_ERR(String pValeur_C_ERR)
  {
    m_listeIndicateurs_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getEtat()
  {
    return m_etat;
  }
  
  public String getEtat_C_ERR()
  {
    return m_etat_C_ERR;
  }
  
  public void setEtat(BigDecimal pValeur)
  {
    m_etat = pValeur;
  }
  
  public void setEtat_C_ERR(String pValeur_C_ERR)
  {
    m_etat_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getIndividuNCP()
  {
    return m_individuNCP;
  }
  
  public String getIndividuNCP_C_ERR()
  {
    return m_individuNCP_C_ERR;
  }
  
  public void setIndividuNCP(BigDecimal pValeur)
  {
    m_individuNCP = pValeur;
  }
  
  public void setIndividuNCP_C_ERR(String pValeur_C_ERR)
  {
    m_individuNCP_C_ERR = pValeur_C_ERR;
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
    if ("m_listeErreurs_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_listeIndicateurs_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_etat_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_individuNCP_C_ERR".equals(attrName)) {
      return String.class;
    }
    return null;
  }
  
  public PropertyInfo _getPropertyInfo(String pElementName)
    throws TechniqueException
  {
    if ("ListeErreurs".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, _ListeErreurs.class, false);
      return info;
    }
    if ("ListeIndicateurs".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, _ListeIndicateurs.class, false);
      return info;
    }
    if ("Etat".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("IndividuNCP".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    return null;
  }
  
  public int _getPropertyLength(String pElementName)
  {
    if ("ListeErreurs".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("ListeIndicateurs".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("Etat".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("IndividuNCP".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    return -1;
  }
  
  public Object _getProperty(String pName)
    throws Exception
  {
    if ("ListeErreurs".equals(pName)) {
      return m_listeErreurs;
    }
    if ("ListeIndicateurs".equals(pName)) {
      return m_listeIndicateurs;
    }
    if ("Etat".equals(pName)) {
      return m_etat;
    }
    if ("IndividuNCP".equals(pName)) {
      return m_individuNCP;
    }
    return null;
  }
  
  public Iterator _getPropertyNames()
    throws Exception
  {
    ArrayList liste = new ArrayList();
    liste.add("ListeErreurs");
    liste.add("ListeIndicateurs");
    liste.add("Etat");
    liste.add("IndividuNCP");
    return liste.iterator();
  }
  
  public ArrayList _getPropertyNames(ArrayList pListe)
    throws Exception
  {
    pListe.add("ListeErreurs");
    pListe.add("ListeIndicateurs");
    pListe.add("Etat");
    pListe.add("IndividuNCP");
    return pListe;
  }
  
  public void _setProperty(String pName, Object pValeur)
    throws Exception
  {
    if ("ListeErreurs".equals(pName)) {
      m_listeErreurs = ((_ListeErreurs)pValeur);
    }
    if ("ListeIndicateurs".equals(pName)) {
      m_listeIndicateurs = ((_ListeIndicateurs)pValeur);
    }
    if ("Etat".equals(pName)) {
      m_etat = ((BigDecimal)pValeur);
    }
    if ("IndividuNCP".equals(pName)) {
      m_individuNCP = ((BigDecimal)pValeur);
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
    if ("m_listeErreurs_C_ERR".equals(attrName)) {
      m_listeErreurs_C_ERR = pValeur;
    }
    if ("m_listeIndicateurs_C_ERR".equals(attrName)) {
      m_listeIndicateurs_C_ERR = pValeur;
    }
    if ("m_etat_C_ERR".equals(attrName)) {
      m_etat_C_ERR = pValeur;
    }
    if ("m_individuNCP_C_ERR".equals(attrName)) {
      m_individuNCP_C_ERR = pValeur;
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
    if ("m_listeErreurs_C_ERR".equals(attrName)) {
      return m_listeErreurs_C_ERR;
    }
    if ("m_listeIndicateurs_C_ERR".equals(attrName)) {
      return m_listeIndicateurs_C_ERR;
    }
    if ("m_etat_C_ERR".equals(attrName)) {
      return m_etat_C_ERR;
    }
    if ("m_individuNCP_C_ERR".equals(attrName)) {
      return m_individuNCP_C_ERR;
    }
    return null;
  }
  
  public boolean equals(Object pObjet)
  {
    if (!(pObjet instanceof _ResultatService)) {
      return false;
    }
    _ResultatService x = (_ResultatService)pObjet;
    if (m_listeErreurs == null)
    {
      if (m_listeErreurs != null) {
        return false;
      }
    }
    else
    {
      if (m_listeErreurs == null) {
        return false;
      }
      if (!m_listeErreurs.equals(m_listeErreurs)) {
        return false;
      }
    }
    if (m_listeIndicateurs == null)
    {
      if (m_listeIndicateurs != null) {
        return false;
      }
    }
    else
    {
      if (m_listeIndicateurs == null) {
        return false;
      }
      if (!m_listeIndicateurs.equals(m_listeIndicateurs)) {
        return false;
      }
    }
    if (m_etat == null)
    {
      if (m_etat != null) {
        return false;
      }
    }
    else
    {
      if (m_etat == null) {
        return false;
      }
      if (!m_etat.equals(m_etat)) {
        return false;
      }
    }
    if (m_individuNCP == null)
    {
      if (m_individuNCP != null) {
        return false;
      }
    }
    else
    {
      if (m_individuNCP == null) {
        return false;
      }
      if (!m_individuNCP.equals(m_individuNCP)) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int result = 0;
    if (m_listeErreurs != null) {
      result += m_listeErreurs.hashCode();
    }
    if (m_listeIndicateurs != null) {
      result += m_listeIndicateurs.hashCode();
    }
    if (m_etat != null) {
      result += m_etat.hashCode();
    }
    if (m_individuNCP != null) {
      result += m_individuNCP.hashCode();
    }
    result *= 17;
    return result;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    _ResultatService clone_ResultatService = new _ResultatService();
    clone_ResultatService.populateFrom_ResultatService(this);
    return clone_ResultatService;
  }
  
  public void populateFrom_ResultatService(_ResultatService pSource)
  {
    setListeErreurs(pSource.getListeErreurs());setListeIndicateurs(pSource.getListeIndicateurs());setEtat(pSource.getEtat());setIndividuNCP(pSource.getIndividuNCP());
  }
  
  public String toString()
  {
    StringBuffer s = new StringBuffer("[_ResultatService");
    subToString(s);
    s.append("]");
    return s.toString();
  }
  
  protected void subToString(StringBuffer pSource)
  {
    pSource.append(", ListeErreurs: ");
    pSource.append(m_listeErreurs);
    pSource.append(", ListeIndicateurs: ");
    pSource.append(m_listeIndicateurs);
    pSource.append(", Etat: ");
    pSource.append(m_etat);
    pSource.append(", IndividuNCP: ");
    pSource.append(m_individuNCP);
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
    DataBean ListeErreurs_Value = getListeErreurs();
    GettersHandler ListeErreurs_GettersHandler = pHandler.property("ListeErreurs", ListeErreurs_Value, new Attribute[] { new StringAttribute("C_ERR", getListeErreurs_C_ERR()) });
    if ((ListeErreurs_GettersHandler != null) && (ListeErreurs_Value != null)) {
      ListeErreurs_Value.goThrough(ListeErreurs_GettersHandler);
    }
    DataBean ListeIndicateurs_Value = getListeIndicateurs();
    GettersHandler ListeIndicateurs_GettersHandler = pHandler.property("ListeIndicateurs", ListeIndicateurs_Value, new Attribute[] { new StringAttribute("C_ERR", getListeIndicateurs_C_ERR()) });
    if ((ListeIndicateurs_GettersHandler != null) && (ListeIndicateurs_Value != null)) {
      ListeIndicateurs_Value.goThrough(ListeIndicateurs_GettersHandler);
    }
    pHandler.property("Etat", getEtat(), new Attribute[] { new StringAttribute("C_ERR", getEtat_C_ERR()) });
    
    pHandler.property("IndividuNCP", getIndividuNCP(), new Attribute[] { new StringAttribute("C_ERR", getIndividuNCP_C_ERR()) });
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
    setListeErreurs((_ListeErreurs)pHandler.databeanProperty("ListeErreurs", _ListeErreurs.class));
    setListeErreurs_C_ERR(pHandler.stringAttribute("ListeErreurs", "C_ERR"));
    setListeIndicateurs((_ListeIndicateurs)pHandler.databeanProperty("ListeIndicateurs", _ListeIndicateurs.class));
    setListeIndicateurs_C_ERR(pHandler.stringAttribute("ListeIndicateurs", "C_ERR"));
    setEtat((BigDecimal)pHandler.objectProperty("Etat", BigDecimal.class));
    setEtat_C_ERR(pHandler.stringAttribute("Etat", "C_ERR"));
    
    setIndividuNCP((BigDecimal)pHandler.objectProperty("IndividuNCP", BigDecimal.class));
    setIndividuNCP_C_ERR(pHandler.stringAttribute("IndividuNCP", "C_ERR"));
  }
  
  public String _getDatabeanName()
  {
    return "ResultatService";
  }
  
  public boolean _isValidProperty(String pElementName)
  {
    if ("ListeErreurs".equals(pElementName)) {
      return true;
    }
    if ("ListeIndicateurs".equals(pElementName)) {
      return true;
    }
    if ("Etat".equals(pElementName)) {
      return true;
    }
    if ("IndividuNCP".equals(pElementName)) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _ResultatService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */