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

public class _FluxDSM
  extends DataBeanImpl
  implements DataBean, Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  private String m__C_ETAT;
  private String m__IDENT;
  private _ListeDSMTravail m_listeDSMTravail;
  private String m_listeDSMTravail_C_ERR;
  private String m_flagA8A10;
  private String m_flagA8A10_C_ERR;
  private String m_declareJustifie;
  private String m_declareJustifie_C_ERR;
  private String m_indicateurPresenceTravail;
  private String m_indicateurPresenceTravail_C_ERR;
  private String m_origineSaisieDsm;
  private String m_origineSaisieDsm_C_ERR;
  private Damj m_dateDebutFormation;
  private String m_dateDebutFormation_C_ERR;
  private Damj m_dateFinFormation;
  private String m_dateFinFormation_C_ERR;
  private Damj m_dateDebutMaladie;
  private String m_dateDebutMaladie_C_ERR;
  private Damj m_dateFinMaladie;
  private String m_dateFinMaladie_C_ERR;
  private Damj m_moisActualisation;
  private String m_moisActualisation_C_ERR;
  private BigDecimal m_nbreHeuresActRed;
  private String m_nbreHeuresActRed_C_ERR;
  
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
  
  public _ListeDSMTravail getListeDSMTravail()
  {
    return m_listeDSMTravail;
  }
  
  public String getListeDSMTravail_C_ERR()
  {
    return m_listeDSMTravail_C_ERR;
  }
  
  public void setListeDSMTravail(_ListeDSMTravail pValeur)
  {
    m_listeDSMTravail = pValeur;
  }
  
  public void setListeDSMTravail_C_ERR(String pValeur_C_ERR)
  {
    m_listeDSMTravail_C_ERR = pValeur_C_ERR;
  }
  
  public String getFlagA8A10()
  {
    return m_flagA8A10;
  }
  
  public String getFlagA8A10_C_ERR()
  {
    return m_flagA8A10_C_ERR;
  }
  
  public void setFlagA8A10(String pValeur)
  {
    m_flagA8A10 = pValeur;
  }
  
  public void setFlagA8A10_C_ERR(String pValeur_C_ERR)
  {
    m_flagA8A10_C_ERR = pValeur_C_ERR;
  }
  
  public String getDeclareJustifie()
  {
    return m_declareJustifie;
  }
  
  public String getDeclareJustifie_C_ERR()
  {
    return m_declareJustifie_C_ERR;
  }
  
  public void setDeclareJustifie(String pValeur)
  {
    m_declareJustifie = pValeur;
  }
  
  public void setDeclareJustifie_C_ERR(String pValeur_C_ERR)
  {
    m_declareJustifie_C_ERR = pValeur_C_ERR;
  }
  
  public String getIndicateurPresenceTravail()
  {
    return m_indicateurPresenceTravail;
  }
  
  public String getIndicateurPresenceTravail_C_ERR()
  {
    return m_indicateurPresenceTravail_C_ERR;
  }
  
  public void setIndicateurPresenceTravail(String pValeur)
  {
    m_indicateurPresenceTravail = pValeur;
  }
  
  public void setIndicateurPresenceTravail_C_ERR(String pValeur_C_ERR)
  {
    m_indicateurPresenceTravail_C_ERR = pValeur_C_ERR;
  }
  
  public String getOrigineSaisieDsm()
  {
    return m_origineSaisieDsm;
  }
  
  public String getOrigineSaisieDsm_C_ERR()
  {
    return m_origineSaisieDsm_C_ERR;
  }
  
  public void setOrigineSaisieDsm(String pValeur)
  {
    m_origineSaisieDsm = pValeur;
  }
  
  public void setOrigineSaisieDsm_C_ERR(String pValeur_C_ERR)
  {
    m_origineSaisieDsm_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDateDebutFormation()
  {
    return m_dateDebutFormation;
  }
  
  public String getDateDebutFormation_C_ERR()
  {
    return m_dateDebutFormation_C_ERR;
  }
  
  public void setDateDebutFormation(Damj pValeur)
  {
    m_dateDebutFormation = pValeur;
  }
  
  public void setDateDebutFormation_C_ERR(String pValeur_C_ERR)
  {
    m_dateDebutFormation_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDateFinFormation()
  {
    return m_dateFinFormation;
  }
  
  public String getDateFinFormation_C_ERR()
  {
    return m_dateFinFormation_C_ERR;
  }
  
  public void setDateFinFormation(Damj pValeur)
  {
    m_dateFinFormation = pValeur;
  }
  
  public void setDateFinFormation_C_ERR(String pValeur_C_ERR)
  {
    m_dateFinFormation_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDateDebutMaladie()
  {
    return m_dateDebutMaladie;
  }
  
  public String getDateDebutMaladie_C_ERR()
  {
    return m_dateDebutMaladie_C_ERR;
  }
  
  public void setDateDebutMaladie(Damj pValeur)
  {
    m_dateDebutMaladie = pValeur;
  }
  
  public void setDateDebutMaladie_C_ERR(String pValeur_C_ERR)
  {
    m_dateDebutMaladie_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDateFinMaladie()
  {
    return m_dateFinMaladie;
  }
  
  public String getDateFinMaladie_C_ERR()
  {
    return m_dateFinMaladie_C_ERR;
  }
  
  public void setDateFinMaladie(Damj pValeur)
  {
    m_dateFinMaladie = pValeur;
  }
  
  public void setDateFinMaladie_C_ERR(String pValeur_C_ERR)
  {
    m_dateFinMaladie_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getMoisActualisation()
  {
    return m_moisActualisation;
  }
  
  public String getMoisActualisation_C_ERR()
  {
    return m_moisActualisation_C_ERR;
  }
  
  public void setMoisActualisation(Damj pValeur)
  {
    m_moisActualisation = pValeur;
  }
  
  public void setMoisActualisation_C_ERR(String pValeur_C_ERR)
  {
    m_moisActualisation_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getNbreHeuresActRed()
  {
    return m_nbreHeuresActRed;
  }
  
  public String getNbreHeuresActRed_C_ERR()
  {
    return m_nbreHeuresActRed_C_ERR;
  }
  
  public void setNbreHeuresActRed(BigDecimal pValeur)
  {
    m_nbreHeuresActRed = pValeur;
  }
  
  public void setNbreHeuresActRed_C_ERR(String pValeur_C_ERR)
  {
    m_nbreHeuresActRed_C_ERR = pValeur_C_ERR;
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
    if ("m_listeDSMTravail_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_flagA8A10_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_declareJustifie_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_indicateurPresenceTravail_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_origineSaisieDsm_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateDebutFormation_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateFinFormation_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateDebutMaladie_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateFinMaladie_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_moisActualisation_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_nbreHeuresActRed_C_ERR".equals(attrName)) {
      return String.class;
    }
    return null;
  }
  
  public PropertyInfo _getPropertyInfo(String pElementName)
    throws TechniqueException
  {
    if ("ListeDSMTravail".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, _ListeDSMTravail.class, false);
      return info;
    }
    if ("FlagA8A10".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("DeclareJustifie".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("IndicateurPresenceTravail".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("OrigineSaisieDsm".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("DateDebutFormation".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("DateFinFormation".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("DateDebutMaladie".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("DateFinMaladie".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("MoisActualisation".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("NbreHeuresActRed".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    return null;
  }
  
  public int _getPropertyLength(String pElementName)
  {
    if ("ListeDSMTravail".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("FlagA8A10".equals(pElementName)) {
      return 1;
    }
    if ("DeclareJustifie".equals(pElementName)) {
      return 1;
    }
    if ("IndicateurPresenceTravail".equals(pElementName)) {
      return 1;
    }
    if ("OrigineSaisieDsm".equals(pElementName)) {
      return 1;
    }
    if ("DateDebutFormation".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("DateFinFormation".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("DateDebutMaladie".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("DateFinMaladie".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("MoisActualisation".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("NbreHeuresActRed".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    return -1;
  }
  
  public Object _getProperty(String pName)
    throws Exception
  {
    if ("ListeDSMTravail".equals(pName)) {
      return m_listeDSMTravail;
    }
    if ("FlagA8A10".equals(pName)) {
      return m_flagA8A10;
    }
    if ("DeclareJustifie".equals(pName)) {
      return m_declareJustifie;
    }
    if ("IndicateurPresenceTravail".equals(pName)) {
      return m_indicateurPresenceTravail;
    }
    if ("OrigineSaisieDsm".equals(pName)) {
      return m_origineSaisieDsm;
    }
    if ("DateDebutFormation".equals(pName)) {
      return m_dateDebutFormation;
    }
    if ("DateFinFormation".equals(pName)) {
      return m_dateFinFormation;
    }
    if ("DateDebutMaladie".equals(pName)) {
      return m_dateDebutMaladie;
    }
    if ("DateFinMaladie".equals(pName)) {
      return m_dateFinMaladie;
    }
    if ("MoisActualisation".equals(pName)) {
      return m_moisActualisation;
    }
    if ("NbreHeuresActRed".equals(pName)) {
      return m_nbreHeuresActRed;
    }
    return null;
  }
  
  public Iterator _getPropertyNames()
    throws Exception
  {
    ArrayList liste = new ArrayList();
    liste.add("ListeDSMTravail");
    liste.add("FlagA8A10");
    liste.add("DeclareJustifie");
    liste.add("IndicateurPresenceTravail");
    liste.add("OrigineSaisieDsm");
    liste.add("DateDebutFormation");
    liste.add("DateFinFormation");
    liste.add("DateDebutMaladie");
    liste.add("DateFinMaladie");
    liste.add("MoisActualisation");
    liste.add("NbreHeuresActRed");
    return liste.iterator();
  }
  
  public ArrayList _getPropertyNames(ArrayList pListe)
    throws Exception
  {
    pListe.add("ListeDSMTravail");
    pListe.add("FlagA8A10");
    pListe.add("DeclareJustifie");
    pListe.add("IndicateurPresenceTravail");
    pListe.add("OrigineSaisieDsm");
    pListe.add("DateDebutFormation");
    pListe.add("DateFinFormation");
    pListe.add("DateDebutMaladie");
    pListe.add("DateFinMaladie");
    pListe.add("MoisActualisation");
    pListe.add("NbreHeuresActRed");
    return pListe;
  }
  
  public void _setProperty(String pName, Object pValeur)
    throws Exception
  {
    if ("ListeDSMTravail".equals(pName)) {
      m_listeDSMTravail = ((_ListeDSMTravail)pValeur);
    }
    if ("FlagA8A10".equals(pName)) {
      m_flagA8A10 = ((String)pValeur);
    }
    if ("DeclareJustifie".equals(pName)) {
      m_declareJustifie = ((String)pValeur);
    }
    if ("IndicateurPresenceTravail".equals(pName)) {
      m_indicateurPresenceTravail = ((String)pValeur);
    }
    if ("OrigineSaisieDsm".equals(pName)) {
      m_origineSaisieDsm = ((String)pValeur);
    }
    if ("DateDebutFormation".equals(pName)) {
      m_dateDebutFormation = ((Damj)pValeur);
    }
    if ("DateFinFormation".equals(pName)) {
      m_dateFinFormation = ((Damj)pValeur);
    }
    if ("DateDebutMaladie".equals(pName)) {
      m_dateDebutMaladie = ((Damj)pValeur);
    }
    if ("DateFinMaladie".equals(pName)) {
      m_dateFinMaladie = ((Damj)pValeur);
    }
    if ("MoisActualisation".equals(pName)) {
      m_moisActualisation = ((Damj)pValeur);
    }
    if ("NbreHeuresActRed".equals(pName)) {
      m_nbreHeuresActRed = ((BigDecimal)pValeur);
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
    if ("m_listeDSMTravail_C_ERR".equals(attrName)) {
      m_listeDSMTravail_C_ERR = pValeur;
    }
    if ("m_flagA8A10_C_ERR".equals(attrName)) {
      m_flagA8A10_C_ERR = pValeur;
    }
    if ("m_declareJustifie_C_ERR".equals(attrName)) {
      m_declareJustifie_C_ERR = pValeur;
    }
    if ("m_indicateurPresenceTravail_C_ERR".equals(attrName)) {
      m_indicateurPresenceTravail_C_ERR = pValeur;
    }
    if ("m_origineSaisieDsm_C_ERR".equals(attrName)) {
      m_origineSaisieDsm_C_ERR = pValeur;
    }
    if ("m_dateDebutFormation_C_ERR".equals(attrName)) {
      m_dateDebutFormation_C_ERR = pValeur;
    }
    if ("m_dateFinFormation_C_ERR".equals(attrName)) {
      m_dateFinFormation_C_ERR = pValeur;
    }
    if ("m_dateDebutMaladie_C_ERR".equals(attrName)) {
      m_dateDebutMaladie_C_ERR = pValeur;
    }
    if ("m_dateFinMaladie_C_ERR".equals(attrName)) {
      m_dateFinMaladie_C_ERR = pValeur;
    }
    if ("m_moisActualisation_C_ERR".equals(attrName)) {
      m_moisActualisation_C_ERR = pValeur;
    }
    if ("m_nbreHeuresActRed_C_ERR".equals(attrName)) {
      m_nbreHeuresActRed_C_ERR = pValeur;
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
    if ("m_listeDSMTravail_C_ERR".equals(attrName)) {
      return m_listeDSMTravail_C_ERR;
    }
    if ("m_flagA8A10_C_ERR".equals(attrName)) {
      return m_flagA8A10_C_ERR;
    }
    if ("m_declareJustifie_C_ERR".equals(attrName)) {
      return m_declareJustifie_C_ERR;
    }
    if ("m_indicateurPresenceTravail_C_ERR".equals(attrName)) {
      return m_indicateurPresenceTravail_C_ERR;
    }
    if ("m_origineSaisieDsm_C_ERR".equals(attrName)) {
      return m_origineSaisieDsm_C_ERR;
    }
    if ("m_dateDebutFormation_C_ERR".equals(attrName)) {
      return m_dateDebutFormation_C_ERR;
    }
    if ("m_dateFinFormation_C_ERR".equals(attrName)) {
      return m_dateFinFormation_C_ERR;
    }
    if ("m_dateDebutMaladie_C_ERR".equals(attrName)) {
      return m_dateDebutMaladie_C_ERR;
    }
    if ("m_dateFinMaladie_C_ERR".equals(attrName)) {
      return m_dateFinMaladie_C_ERR;
    }
    if ("m_moisActualisation_C_ERR".equals(attrName)) {
      return m_moisActualisation_C_ERR;
    }
    if ("m_nbreHeuresActRed_C_ERR".equals(attrName)) {
      return m_nbreHeuresActRed_C_ERR;
    }
    return null;
  }
  
  public boolean equals(Object pObjet)
  {
    if (!(pObjet instanceof _FluxDSM)) {
      return false;
    }
    _FluxDSM x = (_FluxDSM)pObjet;
    if (m_listeDSMTravail == null)
    {
      if (m_listeDSMTravail != null) {
        return false;
      }
    }
    else
    {
      if (m_listeDSMTravail == null) {
        return false;
      }
      if (!m_listeDSMTravail.equals(m_listeDSMTravail)) {
        return false;
      }
    }
    if (m_flagA8A10 == null)
    {
      if (m_flagA8A10 != null) {
        return false;
      }
    }
    else
    {
      if (m_flagA8A10 == null) {
        return false;
      }
      if (!m_flagA8A10.equals(m_flagA8A10)) {
        return false;
      }
    }
    if (m_declareJustifie == null)
    {
      if (m_declareJustifie != null) {
        return false;
      }
    }
    else
    {
      if (m_declareJustifie == null) {
        return false;
      }
      if (!m_declareJustifie.equals(m_declareJustifie)) {
        return false;
      }
    }
    if (m_indicateurPresenceTravail == null)
    {
      if (m_indicateurPresenceTravail != null) {
        return false;
      }
    }
    else
    {
      if (m_indicateurPresenceTravail == null) {
        return false;
      }
      if (!m_indicateurPresenceTravail.equals(m_indicateurPresenceTravail)) {
        return false;
      }
    }
    if (m_origineSaisieDsm == null)
    {
      if (m_origineSaisieDsm != null) {
        return false;
      }
    }
    else
    {
      if (m_origineSaisieDsm == null) {
        return false;
      }
      if (!m_origineSaisieDsm.equals(m_origineSaisieDsm)) {
        return false;
      }
    }
    if (m_dateDebutFormation == null)
    {
      if (m_dateDebutFormation != null) {
        return false;
      }
    }
    else
    {
      if (m_dateDebutFormation == null) {
        return false;
      }
      if (!m_dateDebutFormation.equals(m_dateDebutFormation)) {
        return false;
      }
    }
    if (m_dateFinFormation == null)
    {
      if (m_dateFinFormation != null) {
        return false;
      }
    }
    else
    {
      if (m_dateFinFormation == null) {
        return false;
      }
      if (!m_dateFinFormation.equals(m_dateFinFormation)) {
        return false;
      }
    }
    if (m_dateDebutMaladie == null)
    {
      if (m_dateDebutMaladie != null) {
        return false;
      }
    }
    else
    {
      if (m_dateDebutMaladie == null) {
        return false;
      }
      if (!m_dateDebutMaladie.equals(m_dateDebutMaladie)) {
        return false;
      }
    }
    if (m_dateFinMaladie == null)
    {
      if (m_dateFinMaladie != null) {
        return false;
      }
    }
    else
    {
      if (m_dateFinMaladie == null) {
        return false;
      }
      if (!m_dateFinMaladie.equals(m_dateFinMaladie)) {
        return false;
      }
    }
    if (m_moisActualisation == null)
    {
      if (m_moisActualisation != null) {
        return false;
      }
    }
    else
    {
      if (m_moisActualisation == null) {
        return false;
      }
      if (!m_moisActualisation.equals(m_moisActualisation)) {
        return false;
      }
    }
    if (m_nbreHeuresActRed == null)
    {
      if (m_nbreHeuresActRed != null) {
        return false;
      }
    }
    else
    {
      if (m_nbreHeuresActRed == null) {
        return false;
      }
      if (!m_nbreHeuresActRed.equals(m_nbreHeuresActRed)) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int result = 0;
    if (m_listeDSMTravail != null) {
      result += m_listeDSMTravail.hashCode();
    }
    if (m_flagA8A10 != null) {
      result += m_flagA8A10.hashCode();
    }
    if (m_declareJustifie != null) {
      result += m_declareJustifie.hashCode();
    }
    if (m_indicateurPresenceTravail != null) {
      result += m_indicateurPresenceTravail.hashCode();
    }
    if (m_origineSaisieDsm != null) {
      result += m_origineSaisieDsm.hashCode();
    }
    if (m_dateDebutFormation != null) {
      result += m_dateDebutFormation.hashCode();
    }
    if (m_dateFinFormation != null) {
      result += m_dateFinFormation.hashCode();
    }
    if (m_dateDebutMaladie != null) {
      result += m_dateDebutMaladie.hashCode();
    }
    if (m_dateFinMaladie != null) {
      result += m_dateFinMaladie.hashCode();
    }
    if (m_moisActualisation != null) {
      result += m_moisActualisation.hashCode();
    }
    if (m_nbreHeuresActRed != null) {
      result += m_nbreHeuresActRed.hashCode();
    }
    result *= 17;
    return result;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    _FluxDSM clone_FluxDSM = new _FluxDSM();
    clone_FluxDSM.populateFrom_FluxDSM(this);
    return clone_FluxDSM;
  }
  
  public void populateFrom_FluxDSM(_FluxDSM pSource)
  {
    setListeDSMTravail(pSource.getListeDSMTravail());setFlagA8A10(pSource.getFlagA8A10());setDeclareJustifie(pSource.getDeclareJustifie());setIndicateurPresenceTravail(pSource.getIndicateurPresenceTravail());setOrigineSaisieDsm(pSource.getOrigineSaisieDsm());setDateDebutFormation(pSource.getDateDebutFormation());setDateFinFormation(pSource.getDateFinFormation());setDateDebutMaladie(pSource.getDateDebutMaladie());setDateFinMaladie(pSource.getDateFinMaladie());setMoisActualisation(pSource.getMoisActualisation());setNbreHeuresActRed(pSource.getNbreHeuresActRed());
  }
  
  public String toString()
  {
    StringBuffer s = new StringBuffer("[_FluxDSM");
    subToString(s);
    s.append("]");
    return s.toString();
  }
  
  protected void subToString(StringBuffer pSource)
  {
    pSource.append(", ListeDSMTravail: ");
    pSource.append(m_listeDSMTravail);
    pSource.append(", FlagA8A10: ");
    pSource.append(m_flagA8A10);
    pSource.append(", DeclareJustifie: ");
    pSource.append(m_declareJustifie);
    pSource.append(", IndicateurPresenceTravail: ");
    pSource.append(m_indicateurPresenceTravail);
    pSource.append(", OrigineSaisieDsm: ");
    pSource.append(m_origineSaisieDsm);
    pSource.append(", DateDebutFormation: ");
    pSource.append(m_dateDebutFormation);
    pSource.append(", DateFinFormation: ");
    pSource.append(m_dateFinFormation);
    pSource.append(", DateDebutMaladie: ");
    pSource.append(m_dateDebutMaladie);
    pSource.append(", DateFinMaladie: ");
    pSource.append(m_dateFinMaladie);
    pSource.append(", MoisActualisation: ");
    pSource.append(m_moisActualisation);
    pSource.append(", NbreHeuresActRed: ");
    pSource.append(m_nbreHeuresActRed);
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
    DataBean ListeDSMTravail_Value = getListeDSMTravail();
    GettersHandler ListeDSMTravail_GettersHandler = pHandler.property("ListeDSMTravail", ListeDSMTravail_Value, new Attribute[] { new StringAttribute("C_ERR", getListeDSMTravail_C_ERR()) });
    if ((ListeDSMTravail_GettersHandler != null) && (ListeDSMTravail_Value != null)) {
      ListeDSMTravail_Value.goThrough(ListeDSMTravail_GettersHandler);
    }
    pHandler.property("FlagA8A10", getFlagA8A10(), new Attribute[] { new StringAttribute("C_ERR", getFlagA8A10_C_ERR()) });
    
    pHandler.property("DeclareJustifie", getDeclareJustifie(), new Attribute[] { new StringAttribute("C_ERR", getDeclareJustifie_C_ERR()) });
    
    pHandler.property("IndicateurPresenceTravail", getIndicateurPresenceTravail(), new Attribute[] { new StringAttribute("C_ERR", getIndicateurPresenceTravail_C_ERR()) });
    
    pHandler.property("OrigineSaisieDsm", getOrigineSaisieDsm(), new Attribute[] { new StringAttribute("C_ERR", getOrigineSaisieDsm_C_ERR()) });
    
    pHandler.property("DateDebutFormation", getDateDebutFormation(), new Attribute[] { new StringAttribute("C_ERR", getDateDebutFormation_C_ERR()) });
    
    pHandler.property("DateFinFormation", getDateFinFormation(), new Attribute[] { new StringAttribute("C_ERR", getDateFinFormation_C_ERR()) });
    
    pHandler.property("DateDebutMaladie", getDateDebutMaladie(), new Attribute[] { new StringAttribute("C_ERR", getDateDebutMaladie_C_ERR()) });
    
    pHandler.property("DateFinMaladie", getDateFinMaladie(), new Attribute[] { new StringAttribute("C_ERR", getDateFinMaladie_C_ERR()) });
    
    pHandler.property("MoisActualisation", getMoisActualisation(), new Attribute[] { new StringAttribute("C_ERR", getMoisActualisation_C_ERR()) });
    
    pHandler.property("NbreHeuresActRed", getNbreHeuresActRed(), new Attribute[] { new StringAttribute("C_ERR", getNbreHeuresActRed_C_ERR()) });
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
    setListeDSMTravail((_ListeDSMTravail)pHandler.databeanProperty("ListeDSMTravail", _ListeDSMTravail.class));
    setListeDSMTravail_C_ERR(pHandler.stringAttribute("ListeDSMTravail", "C_ERR"));
    setFlagA8A10((String)pHandler.objectProperty("FlagA8A10", String.class));
    setFlagA8A10_C_ERR(pHandler.stringAttribute("FlagA8A10", "C_ERR"));
    
    setDeclareJustifie((String)pHandler.objectProperty("DeclareJustifie", String.class));
    setDeclareJustifie_C_ERR(pHandler.stringAttribute("DeclareJustifie", "C_ERR"));
    
    setIndicateurPresenceTravail((String)pHandler.objectProperty("IndicateurPresenceTravail", String.class));
    setIndicateurPresenceTravail_C_ERR(pHandler.stringAttribute("IndicateurPresenceTravail", "C_ERR"));
    
    setOrigineSaisieDsm((String)pHandler.objectProperty("OrigineSaisieDsm", String.class));
    setOrigineSaisieDsm_C_ERR(pHandler.stringAttribute("OrigineSaisieDsm", "C_ERR"));
    
    setDateDebutFormation((Damj)pHandler.objectProperty("DateDebutFormation", Damj.class));
    setDateDebutFormation_C_ERR(pHandler.stringAttribute("DateDebutFormation", "C_ERR"));
    
    setDateFinFormation((Damj)pHandler.objectProperty("DateFinFormation", Damj.class));
    setDateFinFormation_C_ERR(pHandler.stringAttribute("DateFinFormation", "C_ERR"));
    
    setDateDebutMaladie((Damj)pHandler.objectProperty("DateDebutMaladie", Damj.class));
    setDateDebutMaladie_C_ERR(pHandler.stringAttribute("DateDebutMaladie", "C_ERR"));
    
    setDateFinMaladie((Damj)pHandler.objectProperty("DateFinMaladie", Damj.class));
    setDateFinMaladie_C_ERR(pHandler.stringAttribute("DateFinMaladie", "C_ERR"));
    
    setMoisActualisation((Damj)pHandler.objectProperty("MoisActualisation", Damj.class));
    setMoisActualisation_C_ERR(pHandler.stringAttribute("MoisActualisation", "C_ERR"));
    
    setNbreHeuresActRed((BigDecimal)pHandler.objectProperty("NbreHeuresActRed", BigDecimal.class));
    setNbreHeuresActRed_C_ERR(pHandler.stringAttribute("NbreHeuresActRed", "C_ERR"));
  }
  
  public String _getDatabeanName()
  {
    return "FluxDSM";
  }
  
  public boolean _isValidProperty(String pElementName)
  {
    if ("ListeDSMTravail".equals(pElementName)) {
      return true;
    }
    if ("FlagA8A10".equals(pElementName)) {
      return true;
    }
    if ("DeclareJustifie".equals(pElementName)) {
      return true;
    }
    if ("IndicateurPresenceTravail".equals(pElementName)) {
      return true;
    }
    if ("OrigineSaisieDsm".equals(pElementName)) {
      return true;
    }
    if ("DateDebutFormation".equals(pElementName)) {
      return true;
    }
    if ("DateFinFormation".equals(pElementName)) {
      return true;
    }
    if ("DateDebutMaladie".equals(pElementName)) {
      return true;
    }
    if ("DateFinMaladie".equals(pElementName)) {
      return true;
    }
    if ("MoisActualisation".equals(pElementName)) {
      return true;
    }
    if ("NbreHeuresActRed".equals(pElementName)) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _FluxDSM
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */