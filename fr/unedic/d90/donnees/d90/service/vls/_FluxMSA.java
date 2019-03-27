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

public class _FluxMSA
  extends DataBeanImpl
  implements DataBean, Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  private String m__C_ETAT;
  private String m__IDENT;
  private String m_typeEnregistrement;
  private String m_typeEnregistrement_C_ERR;
  private String m_codeMSA;
  private String m_codeMSA_C_ERR;
  private String m_numeroAllocataire;
  private String m_numeroAllocataire_C_ERR;
  private String m_nIRRectifie;
  private String m_nIRRectifie_C_ERR;
  private String m_identifiantEchangeMSA;
  private String m_identifiantEchangeMSA_C_ERR;
  private String m_nomPatronymique;
  private String m_nomPatronymique_C_ERR;
  private String m_prenom;
  private String m_prenom_C_ERR;
  private String m_codePopulation;
  private String m_codePopulation_C_ERR;
  private String m_deptNumeroInseeCommune;
  private String m_deptNumeroInseeCommune_C_ERR;
  private String m_numeroIdentification;
  private String m_numeroIdentification_C_ERR;
  private String m_codeStatut;
  private String m_codeStatut_C_ERR;
  private String m_identifiantIndividuBNI;
  private String m_identifiantIndividuBNI_C_ERR;
  private String m_nomMarital;
  private String m_nomMarital_C_ERR;
  private String m_codeAnteriorite;
  private String m_codeAnteriorite_C_ERR;
  private String m_zoneInfos;
  private String m_zoneInfos_C_ERR;
  private Damj m_dateDebutClcaAjpp;
  private String m_dateDebutClcaAjpp_C_ERR;
  private Damj m_dateFinClcaAjpp;
  private String m_dateFinClcaAjpp_C_ERR;
  private Damj m_dateNaissance;
  private String m_dateNaissance_C_ERR;
  
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
  
  public String getTypeEnregistrement()
  {
    return m_typeEnregistrement;
  }
  
  public String getTypeEnregistrement_C_ERR()
  {
    return m_typeEnregistrement_C_ERR;
  }
  
  public void setTypeEnregistrement(String pValeur)
  {
    m_typeEnregistrement = pValeur;
  }
  
  public void setTypeEnregistrement_C_ERR(String pValeur_C_ERR)
  {
    m_typeEnregistrement_C_ERR = pValeur_C_ERR;
  }
  
  public String getCodeMSA()
  {
    return m_codeMSA;
  }
  
  public String getCodeMSA_C_ERR()
  {
    return m_codeMSA_C_ERR;
  }
  
  public void setCodeMSA(String pValeur)
  {
    m_codeMSA = pValeur;
  }
  
  public void setCodeMSA_C_ERR(String pValeur_C_ERR)
  {
    m_codeMSA_C_ERR = pValeur_C_ERR;
  }
  
  public String getNumeroAllocataire()
  {
    return m_numeroAllocataire;
  }
  
  public String getNumeroAllocataire_C_ERR()
  {
    return m_numeroAllocataire_C_ERR;
  }
  
  public void setNumeroAllocataire(String pValeur)
  {
    m_numeroAllocataire = pValeur;
  }
  
  public void setNumeroAllocataire_C_ERR(String pValeur_C_ERR)
  {
    m_numeroAllocataire_C_ERR = pValeur_C_ERR;
  }
  
  public String getNIRRectifie()
  {
    return m_nIRRectifie;
  }
  
  public String getNIRRectifie_C_ERR()
  {
    return m_nIRRectifie_C_ERR;
  }
  
  public void setNIRRectifie(String pValeur)
  {
    m_nIRRectifie = pValeur;
  }
  
  public void setNIRRectifie_C_ERR(String pValeur_C_ERR)
  {
    m_nIRRectifie_C_ERR = pValeur_C_ERR;
  }
  
  public String getIdentifiantEchangeMSA()
  {
    return m_identifiantEchangeMSA;
  }
  
  public String getIdentifiantEchangeMSA_C_ERR()
  {
    return m_identifiantEchangeMSA_C_ERR;
  }
  
  public void setIdentifiantEchangeMSA(String pValeur)
  {
    m_identifiantEchangeMSA = pValeur;
  }
  
  public void setIdentifiantEchangeMSA_C_ERR(String pValeur_C_ERR)
  {
    m_identifiantEchangeMSA_C_ERR = pValeur_C_ERR;
  }
  
  public String getNomPatronymique()
  {
    return m_nomPatronymique;
  }
  
  public String getNomPatronymique_C_ERR()
  {
    return m_nomPatronymique_C_ERR;
  }
  
  public void setNomPatronymique(String pValeur)
  {
    m_nomPatronymique = pValeur;
  }
  
  public void setNomPatronymique_C_ERR(String pValeur_C_ERR)
  {
    m_nomPatronymique_C_ERR = pValeur_C_ERR;
  }
  
  public String getPrenom()
  {
    return m_prenom;
  }
  
  public String getPrenom_C_ERR()
  {
    return m_prenom_C_ERR;
  }
  
  public void setPrenom(String pValeur)
  {
    m_prenom = pValeur;
  }
  
  public void setPrenom_C_ERR(String pValeur_C_ERR)
  {
    m_prenom_C_ERR = pValeur_C_ERR;
  }
  
  public String getCodePopulation()
  {
    return m_codePopulation;
  }
  
  public String getCodePopulation_C_ERR()
  {
    return m_codePopulation_C_ERR;
  }
  
  public void setCodePopulation(String pValeur)
  {
    m_codePopulation = pValeur;
  }
  
  public void setCodePopulation_C_ERR(String pValeur_C_ERR)
  {
    m_codePopulation_C_ERR = pValeur_C_ERR;
  }
  
  public String getDeptNumeroInseeCommune()
  {
    return m_deptNumeroInseeCommune;
  }
  
  public String getDeptNumeroInseeCommune_C_ERR()
  {
    return m_deptNumeroInseeCommune_C_ERR;
  }
  
  public void setDeptNumeroInseeCommune(String pValeur)
  {
    m_deptNumeroInseeCommune = pValeur;
  }
  
  public void setDeptNumeroInseeCommune_C_ERR(String pValeur_C_ERR)
  {
    m_deptNumeroInseeCommune_C_ERR = pValeur_C_ERR;
  }
  
  public String getNumeroIdentification()
  {
    return m_numeroIdentification;
  }
  
  public String getNumeroIdentification_C_ERR()
  {
    return m_numeroIdentification_C_ERR;
  }
  
  public void setNumeroIdentification(String pValeur)
  {
    m_numeroIdentification = pValeur;
  }
  
  public void setNumeroIdentification_C_ERR(String pValeur_C_ERR)
  {
    m_numeroIdentification_C_ERR = pValeur_C_ERR;
  }
  
  public String getCodeStatut()
  {
    return m_codeStatut;
  }
  
  public String getCodeStatut_C_ERR()
  {
    return m_codeStatut_C_ERR;
  }
  
  public void setCodeStatut(String pValeur)
  {
    m_codeStatut = pValeur;
  }
  
  public void setCodeStatut_C_ERR(String pValeur_C_ERR)
  {
    m_codeStatut_C_ERR = pValeur_C_ERR;
  }
  
  public String getIdentifiantIndividuBNI()
  {
    return m_identifiantIndividuBNI;
  }
  
  public String getIdentifiantIndividuBNI_C_ERR()
  {
    return m_identifiantIndividuBNI_C_ERR;
  }
  
  public void setIdentifiantIndividuBNI(String pValeur)
  {
    m_identifiantIndividuBNI = pValeur;
  }
  
  public void setIdentifiantIndividuBNI_C_ERR(String pValeur_C_ERR)
  {
    m_identifiantIndividuBNI_C_ERR = pValeur_C_ERR;
  }
  
  public String getNomMarital()
  {
    return m_nomMarital;
  }
  
  public String getNomMarital_C_ERR()
  {
    return m_nomMarital_C_ERR;
  }
  
  public void setNomMarital(String pValeur)
  {
    m_nomMarital = pValeur;
  }
  
  public void setNomMarital_C_ERR(String pValeur_C_ERR)
  {
    m_nomMarital_C_ERR = pValeur_C_ERR;
  }
  
  public String getCodeAnteriorite()
  {
    return m_codeAnteriorite;
  }
  
  public String getCodeAnteriorite_C_ERR()
  {
    return m_codeAnteriorite_C_ERR;
  }
  
  public void setCodeAnteriorite(String pValeur)
  {
    m_codeAnteriorite = pValeur;
  }
  
  public void setCodeAnteriorite_C_ERR(String pValeur_C_ERR)
  {
    m_codeAnteriorite_C_ERR = pValeur_C_ERR;
  }
  
  public String getZoneInfos()
  {
    return m_zoneInfos;
  }
  
  public String getZoneInfos_C_ERR()
  {
    return m_zoneInfos_C_ERR;
  }
  
  public void setZoneInfos(String pValeur)
  {
    m_zoneInfos = pValeur;
  }
  
  public void setZoneInfos_C_ERR(String pValeur_C_ERR)
  {
    m_zoneInfos_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDateDebutClcaAjpp()
  {
    return m_dateDebutClcaAjpp;
  }
  
  public String getDateDebutClcaAjpp_C_ERR()
  {
    return m_dateDebutClcaAjpp_C_ERR;
  }
  
  public void setDateDebutClcaAjpp(Damj pValeur)
  {
    m_dateDebutClcaAjpp = pValeur;
  }
  
  public void setDateDebutClcaAjpp_C_ERR(String pValeur_C_ERR)
  {
    m_dateDebutClcaAjpp_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDateFinClcaAjpp()
  {
    return m_dateFinClcaAjpp;
  }
  
  public String getDateFinClcaAjpp_C_ERR()
  {
    return m_dateFinClcaAjpp_C_ERR;
  }
  
  public void setDateFinClcaAjpp(Damj pValeur)
  {
    m_dateFinClcaAjpp = pValeur;
  }
  
  public void setDateFinClcaAjpp_C_ERR(String pValeur_C_ERR)
  {
    m_dateFinClcaAjpp_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDateNaissance()
  {
    return m_dateNaissance;
  }
  
  public String getDateNaissance_C_ERR()
  {
    return m_dateNaissance_C_ERR;
  }
  
  public void setDateNaissance(Damj pValeur)
  {
    m_dateNaissance = pValeur;
  }
  
  public void setDateNaissance_C_ERR(String pValeur_C_ERR)
  {
    m_dateNaissance_C_ERR = pValeur_C_ERR;
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
    if ("m_typeEnregistrement_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_codeMSA_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_numeroAllocataire_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_nIRRectifie_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_identifiantEchangeMSA_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_nomPatronymique_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_prenom_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_codePopulation_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_deptNumeroInseeCommune_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_numeroIdentification_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_codeStatut_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_identifiantIndividuBNI_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_nomMarital_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_codeAnteriorite_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_zoneInfos_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateDebutClcaAjpp_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateFinClcaAjpp_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateNaissance_C_ERR".equals(attrName)) {
      return String.class;
    }
    return null;
  }
  
  public PropertyInfo _getPropertyInfo(String pElementName)
    throws TechniqueException
  {
    if ("TypeEnregistrement".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("CodeMSA".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("NumeroAllocataire".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("NIRRectifie".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("IdentifiantEchangeMSA".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("NomPatronymique".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("Prenom".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("CodePopulation".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("DeptNumeroInseeCommune".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("NumeroIdentification".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("CodeStatut".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("IdentifiantIndividuBNI".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("NomMarital".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("CodeAnteriorite".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("ZoneInfos".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("DateDebutClcaAjpp".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("DateFinClcaAjpp".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("DateNaissance".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    return null;
  }
  
  public int _getPropertyLength(String pElementName)
  {
    if ("TypeEnregistrement".equals(pElementName)) {
      return 1;
    }
    if ("CodeMSA".equals(pElementName)) {
      return 3;
    }
    if ("NumeroAllocataire".equals(pElementName)) {
      return 10;
    }
    if ("NIRRectifie".equals(pElementName)) {
      return 10;
    }
    if ("IdentifiantEchangeMSA".equals(pElementName)) {
      return 13;
    }
    if ("NomPatronymique".equals(pElementName)) {
      return 25;
    }
    if ("Prenom".equals(pElementName)) {
      return 25;
    }
    if ("CodePopulation".equals(pElementName)) {
      return 3;
    }
    if ("DeptNumeroInseeCommune".equals(pElementName)) {
      return 5;
    }
    if ("NumeroIdentification".equals(pElementName)) {
      return 13;
    }
    if ("CodeStatut".equals(pElementName)) {
      return 1;
    }
    if ("IdentifiantIndividuBNI".equals(pElementName)) {
      return 10;
    }
    if ("NomMarital".equals(pElementName)) {
      return 25;
    }
    if ("CodeAnteriorite".equals(pElementName)) {
      return 1;
    }
    if ("ZoneInfos".equals(pElementName)) {
      return 10;
    }
    if ("DateDebutClcaAjpp".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("DateFinClcaAjpp".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("DateNaissance".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    return -1;
  }
  
  public Object _getProperty(String pName)
    throws Exception
  {
    if ("TypeEnregistrement".equals(pName)) {
      return m_typeEnregistrement;
    }
    if ("CodeMSA".equals(pName)) {
      return m_codeMSA;
    }
    if ("NumeroAllocataire".equals(pName)) {
      return m_numeroAllocataire;
    }
    if ("NIRRectifie".equals(pName)) {
      return m_nIRRectifie;
    }
    if ("IdentifiantEchangeMSA".equals(pName)) {
      return m_identifiantEchangeMSA;
    }
    if ("NomPatronymique".equals(pName)) {
      return m_nomPatronymique;
    }
    if ("Prenom".equals(pName)) {
      return m_prenom;
    }
    if ("CodePopulation".equals(pName)) {
      return m_codePopulation;
    }
    if ("DeptNumeroInseeCommune".equals(pName)) {
      return m_deptNumeroInseeCommune;
    }
    if ("NumeroIdentification".equals(pName)) {
      return m_numeroIdentification;
    }
    if ("CodeStatut".equals(pName)) {
      return m_codeStatut;
    }
    if ("IdentifiantIndividuBNI".equals(pName)) {
      return m_identifiantIndividuBNI;
    }
    if ("NomMarital".equals(pName)) {
      return m_nomMarital;
    }
    if ("CodeAnteriorite".equals(pName)) {
      return m_codeAnteriorite;
    }
    if ("ZoneInfos".equals(pName)) {
      return m_zoneInfos;
    }
    if ("DateDebutClcaAjpp".equals(pName)) {
      return m_dateDebutClcaAjpp;
    }
    if ("DateFinClcaAjpp".equals(pName)) {
      return m_dateFinClcaAjpp;
    }
    if ("DateNaissance".equals(pName)) {
      return m_dateNaissance;
    }
    return null;
  }
  
  public Iterator _getPropertyNames()
    throws Exception
  {
    ArrayList liste = new ArrayList();
    liste.add("TypeEnregistrement");
    liste.add("CodeMSA");
    liste.add("NumeroAllocataire");
    liste.add("NIRRectifie");
    liste.add("IdentifiantEchangeMSA");
    liste.add("NomPatronymique");
    liste.add("Prenom");
    liste.add("CodePopulation");
    liste.add("DeptNumeroInseeCommune");
    liste.add("NumeroIdentification");
    liste.add("CodeStatut");
    liste.add("IdentifiantIndividuBNI");
    liste.add("NomMarital");
    liste.add("CodeAnteriorite");
    liste.add("ZoneInfos");
    liste.add("DateDebutClcaAjpp");
    liste.add("DateFinClcaAjpp");
    liste.add("DateNaissance");
    return liste.iterator();
  }
  
  public ArrayList _getPropertyNames(ArrayList pListe)
    throws Exception
  {
    pListe.add("TypeEnregistrement");
    pListe.add("CodeMSA");
    pListe.add("NumeroAllocataire");
    pListe.add("NIRRectifie");
    pListe.add("IdentifiantEchangeMSA");
    pListe.add("NomPatronymique");
    pListe.add("Prenom");
    pListe.add("CodePopulation");
    pListe.add("DeptNumeroInseeCommune");
    pListe.add("NumeroIdentification");
    pListe.add("CodeStatut");
    pListe.add("IdentifiantIndividuBNI");
    pListe.add("NomMarital");
    pListe.add("CodeAnteriorite");
    pListe.add("ZoneInfos");
    pListe.add("DateDebutClcaAjpp");
    pListe.add("DateFinClcaAjpp");
    pListe.add("DateNaissance");
    return pListe;
  }
  
  public void _setProperty(String pName, Object pValeur)
    throws Exception
  {
    if ("TypeEnregistrement".equals(pName)) {
      m_typeEnregistrement = ((String)pValeur);
    }
    if ("CodeMSA".equals(pName)) {
      m_codeMSA = ((String)pValeur);
    }
    if ("NumeroAllocataire".equals(pName)) {
      m_numeroAllocataire = ((String)pValeur);
    }
    if ("NIRRectifie".equals(pName)) {
      m_nIRRectifie = ((String)pValeur);
    }
    if ("IdentifiantEchangeMSA".equals(pName)) {
      m_identifiantEchangeMSA = ((String)pValeur);
    }
    if ("NomPatronymique".equals(pName)) {
      m_nomPatronymique = ((String)pValeur);
    }
    if ("Prenom".equals(pName)) {
      m_prenom = ((String)pValeur);
    }
    if ("CodePopulation".equals(pName)) {
      m_codePopulation = ((String)pValeur);
    }
    if ("DeptNumeroInseeCommune".equals(pName)) {
      m_deptNumeroInseeCommune = ((String)pValeur);
    }
    if ("NumeroIdentification".equals(pName)) {
      m_numeroIdentification = ((String)pValeur);
    }
    if ("CodeStatut".equals(pName)) {
      m_codeStatut = ((String)pValeur);
    }
    if ("IdentifiantIndividuBNI".equals(pName)) {
      m_identifiantIndividuBNI = ((String)pValeur);
    }
    if ("NomMarital".equals(pName)) {
      m_nomMarital = ((String)pValeur);
    }
    if ("CodeAnteriorite".equals(pName)) {
      m_codeAnteriorite = ((String)pValeur);
    }
    if ("ZoneInfos".equals(pName)) {
      m_zoneInfos = ((String)pValeur);
    }
    if ("DateDebutClcaAjpp".equals(pName)) {
      m_dateDebutClcaAjpp = ((Damj)pValeur);
    }
    if ("DateFinClcaAjpp".equals(pName)) {
      m_dateFinClcaAjpp = ((Damj)pValeur);
    }
    if ("DateNaissance".equals(pName)) {
      m_dateNaissance = ((Damj)pValeur);
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
    if ("m_typeEnregistrement_C_ERR".equals(attrName)) {
      m_typeEnregistrement_C_ERR = pValeur;
    }
    if ("m_codeMSA_C_ERR".equals(attrName)) {
      m_codeMSA_C_ERR = pValeur;
    }
    if ("m_numeroAllocataire_C_ERR".equals(attrName)) {
      m_numeroAllocataire_C_ERR = pValeur;
    }
    if ("m_nIRRectifie_C_ERR".equals(attrName)) {
      m_nIRRectifie_C_ERR = pValeur;
    }
    if ("m_identifiantEchangeMSA_C_ERR".equals(attrName)) {
      m_identifiantEchangeMSA_C_ERR = pValeur;
    }
    if ("m_nomPatronymique_C_ERR".equals(attrName)) {
      m_nomPatronymique_C_ERR = pValeur;
    }
    if ("m_prenom_C_ERR".equals(attrName)) {
      m_prenom_C_ERR = pValeur;
    }
    if ("m_codePopulation_C_ERR".equals(attrName)) {
      m_codePopulation_C_ERR = pValeur;
    }
    if ("m_deptNumeroInseeCommune_C_ERR".equals(attrName)) {
      m_deptNumeroInseeCommune_C_ERR = pValeur;
    }
    if ("m_numeroIdentification_C_ERR".equals(attrName)) {
      m_numeroIdentification_C_ERR = pValeur;
    }
    if ("m_codeStatut_C_ERR".equals(attrName)) {
      m_codeStatut_C_ERR = pValeur;
    }
    if ("m_identifiantIndividuBNI_C_ERR".equals(attrName)) {
      m_identifiantIndividuBNI_C_ERR = pValeur;
    }
    if ("m_nomMarital_C_ERR".equals(attrName)) {
      m_nomMarital_C_ERR = pValeur;
    }
    if ("m_codeAnteriorite_C_ERR".equals(attrName)) {
      m_codeAnteriorite_C_ERR = pValeur;
    }
    if ("m_zoneInfos_C_ERR".equals(attrName)) {
      m_zoneInfos_C_ERR = pValeur;
    }
    if ("m_dateDebutClcaAjpp_C_ERR".equals(attrName)) {
      m_dateDebutClcaAjpp_C_ERR = pValeur;
    }
    if ("m_dateFinClcaAjpp_C_ERR".equals(attrName)) {
      m_dateFinClcaAjpp_C_ERR = pValeur;
    }
    if ("m_dateNaissance_C_ERR".equals(attrName)) {
      m_dateNaissance_C_ERR = pValeur;
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
    if ("m_typeEnregistrement_C_ERR".equals(attrName)) {
      return m_typeEnregistrement_C_ERR;
    }
    if ("m_codeMSA_C_ERR".equals(attrName)) {
      return m_codeMSA_C_ERR;
    }
    if ("m_numeroAllocataire_C_ERR".equals(attrName)) {
      return m_numeroAllocataire_C_ERR;
    }
    if ("m_nIRRectifie_C_ERR".equals(attrName)) {
      return m_nIRRectifie_C_ERR;
    }
    if ("m_identifiantEchangeMSA_C_ERR".equals(attrName)) {
      return m_identifiantEchangeMSA_C_ERR;
    }
    if ("m_nomPatronymique_C_ERR".equals(attrName)) {
      return m_nomPatronymique_C_ERR;
    }
    if ("m_prenom_C_ERR".equals(attrName)) {
      return m_prenom_C_ERR;
    }
    if ("m_codePopulation_C_ERR".equals(attrName)) {
      return m_codePopulation_C_ERR;
    }
    if ("m_deptNumeroInseeCommune_C_ERR".equals(attrName)) {
      return m_deptNumeroInseeCommune_C_ERR;
    }
    if ("m_numeroIdentification_C_ERR".equals(attrName)) {
      return m_numeroIdentification_C_ERR;
    }
    if ("m_codeStatut_C_ERR".equals(attrName)) {
      return m_codeStatut_C_ERR;
    }
    if ("m_identifiantIndividuBNI_C_ERR".equals(attrName)) {
      return m_identifiantIndividuBNI_C_ERR;
    }
    if ("m_nomMarital_C_ERR".equals(attrName)) {
      return m_nomMarital_C_ERR;
    }
    if ("m_codeAnteriorite_C_ERR".equals(attrName)) {
      return m_codeAnteriorite_C_ERR;
    }
    if ("m_zoneInfos_C_ERR".equals(attrName)) {
      return m_zoneInfos_C_ERR;
    }
    if ("m_dateDebutClcaAjpp_C_ERR".equals(attrName)) {
      return m_dateDebutClcaAjpp_C_ERR;
    }
    if ("m_dateFinClcaAjpp_C_ERR".equals(attrName)) {
      return m_dateFinClcaAjpp_C_ERR;
    }
    if ("m_dateNaissance_C_ERR".equals(attrName)) {
      return m_dateNaissance_C_ERR;
    }
    return null;
  }
  
  public boolean equals(Object pObjet)
  {
    if (!(pObjet instanceof _FluxMSA)) {
      return false;
    }
    _FluxMSA x = (_FluxMSA)pObjet;
    if (m_typeEnregistrement == null)
    {
      if (m_typeEnregistrement != null) {
        return false;
      }
    }
    else
    {
      if (m_typeEnregistrement == null) {
        return false;
      }
      if (!m_typeEnregistrement.equals(m_typeEnregistrement)) {
        return false;
      }
    }
    if (m_codeMSA == null)
    {
      if (m_codeMSA != null) {
        return false;
      }
    }
    else
    {
      if (m_codeMSA == null) {
        return false;
      }
      if (!m_codeMSA.equals(m_codeMSA)) {
        return false;
      }
    }
    if (m_numeroAllocataire == null)
    {
      if (m_numeroAllocataire != null) {
        return false;
      }
    }
    else
    {
      if (m_numeroAllocataire == null) {
        return false;
      }
      if (!m_numeroAllocataire.equals(m_numeroAllocataire)) {
        return false;
      }
    }
    if (m_nIRRectifie == null)
    {
      if (m_nIRRectifie != null) {
        return false;
      }
    }
    else
    {
      if (m_nIRRectifie == null) {
        return false;
      }
      if (!m_nIRRectifie.equals(m_nIRRectifie)) {
        return false;
      }
    }
    if (m_identifiantEchangeMSA == null)
    {
      if (m_identifiantEchangeMSA != null) {
        return false;
      }
    }
    else
    {
      if (m_identifiantEchangeMSA == null) {
        return false;
      }
      if (!m_identifiantEchangeMSA.equals(m_identifiantEchangeMSA)) {
        return false;
      }
    }
    if (m_nomPatronymique == null)
    {
      if (m_nomPatronymique != null) {
        return false;
      }
    }
    else
    {
      if (m_nomPatronymique == null) {
        return false;
      }
      if (!m_nomPatronymique.equals(m_nomPatronymique)) {
        return false;
      }
    }
    if (m_prenom == null)
    {
      if (m_prenom != null) {
        return false;
      }
    }
    else
    {
      if (m_prenom == null) {
        return false;
      }
      if (!m_prenom.equals(m_prenom)) {
        return false;
      }
    }
    if (m_codePopulation == null)
    {
      if (m_codePopulation != null) {
        return false;
      }
    }
    else
    {
      if (m_codePopulation == null) {
        return false;
      }
      if (!m_codePopulation.equals(m_codePopulation)) {
        return false;
      }
    }
    if (m_deptNumeroInseeCommune == null)
    {
      if (m_deptNumeroInseeCommune != null) {
        return false;
      }
    }
    else
    {
      if (m_deptNumeroInseeCommune == null) {
        return false;
      }
      if (!m_deptNumeroInseeCommune.equals(m_deptNumeroInseeCommune)) {
        return false;
      }
    }
    if (m_numeroIdentification == null)
    {
      if (m_numeroIdentification != null) {
        return false;
      }
    }
    else
    {
      if (m_numeroIdentification == null) {
        return false;
      }
      if (!m_numeroIdentification.equals(m_numeroIdentification)) {
        return false;
      }
    }
    if (m_codeStatut == null)
    {
      if (m_codeStatut != null) {
        return false;
      }
    }
    else
    {
      if (m_codeStatut == null) {
        return false;
      }
      if (!m_codeStatut.equals(m_codeStatut)) {
        return false;
      }
    }
    if (m_identifiantIndividuBNI == null)
    {
      if (m_identifiantIndividuBNI != null) {
        return false;
      }
    }
    else
    {
      if (m_identifiantIndividuBNI == null) {
        return false;
      }
      if (!m_identifiantIndividuBNI.equals(m_identifiantIndividuBNI)) {
        return false;
      }
    }
    if (m_nomMarital == null)
    {
      if (m_nomMarital != null) {
        return false;
      }
    }
    else
    {
      if (m_nomMarital == null) {
        return false;
      }
      if (!m_nomMarital.equals(m_nomMarital)) {
        return false;
      }
    }
    if (m_codeAnteriorite == null)
    {
      if (m_codeAnteriorite != null) {
        return false;
      }
    }
    else
    {
      if (m_codeAnteriorite == null) {
        return false;
      }
      if (!m_codeAnteriorite.equals(m_codeAnteriorite)) {
        return false;
      }
    }
    if (m_zoneInfos == null)
    {
      if (m_zoneInfos != null) {
        return false;
      }
    }
    else
    {
      if (m_zoneInfos == null) {
        return false;
      }
      if (!m_zoneInfos.equals(m_zoneInfos)) {
        return false;
      }
    }
    if (m_dateDebutClcaAjpp == null)
    {
      if (m_dateDebutClcaAjpp != null) {
        return false;
      }
    }
    else
    {
      if (m_dateDebutClcaAjpp == null) {
        return false;
      }
      if (!m_dateDebutClcaAjpp.equals(m_dateDebutClcaAjpp)) {
        return false;
      }
    }
    if (m_dateFinClcaAjpp == null)
    {
      if (m_dateFinClcaAjpp != null) {
        return false;
      }
    }
    else
    {
      if (m_dateFinClcaAjpp == null) {
        return false;
      }
      if (!m_dateFinClcaAjpp.equals(m_dateFinClcaAjpp)) {
        return false;
      }
    }
    if (m_dateNaissance == null)
    {
      if (m_dateNaissance != null) {
        return false;
      }
    }
    else
    {
      if (m_dateNaissance == null) {
        return false;
      }
      if (!m_dateNaissance.equals(m_dateNaissance)) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int result = 0;
    if (m_typeEnregistrement != null) {
      result += m_typeEnregistrement.hashCode();
    }
    if (m_codeMSA != null) {
      result += m_codeMSA.hashCode();
    }
    if (m_numeroAllocataire != null) {
      result += m_numeroAllocataire.hashCode();
    }
    if (m_nIRRectifie != null) {
      result += m_nIRRectifie.hashCode();
    }
    if (m_identifiantEchangeMSA != null) {
      result += m_identifiantEchangeMSA.hashCode();
    }
    if (m_nomPatronymique != null) {
      result += m_nomPatronymique.hashCode();
    }
    if (m_prenom != null) {
      result += m_prenom.hashCode();
    }
    if (m_codePopulation != null) {
      result += m_codePopulation.hashCode();
    }
    if (m_deptNumeroInseeCommune != null) {
      result += m_deptNumeroInseeCommune.hashCode();
    }
    if (m_numeroIdentification != null) {
      result += m_numeroIdentification.hashCode();
    }
    if (m_codeStatut != null) {
      result += m_codeStatut.hashCode();
    }
    if (m_identifiantIndividuBNI != null) {
      result += m_identifiantIndividuBNI.hashCode();
    }
    if (m_nomMarital != null) {
      result += m_nomMarital.hashCode();
    }
    if (m_codeAnteriorite != null) {
      result += m_codeAnteriorite.hashCode();
    }
    if (m_zoneInfos != null) {
      result += m_zoneInfos.hashCode();
    }
    if (m_dateDebutClcaAjpp != null) {
      result += m_dateDebutClcaAjpp.hashCode();
    }
    if (m_dateFinClcaAjpp != null) {
      result += m_dateFinClcaAjpp.hashCode();
    }
    if (m_dateNaissance != null) {
      result += m_dateNaissance.hashCode();
    }
    result *= 17;
    return result;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    _FluxMSA clone_FluxMSA = new _FluxMSA();
    clone_FluxMSA.populateFrom_FluxMSA(this);
    return clone_FluxMSA;
  }
  
  public void populateFrom_FluxMSA(_FluxMSA pSource)
  {
    setTypeEnregistrement(pSource.getTypeEnregistrement());setCodeMSA(pSource.getCodeMSA());setNumeroAllocataire(pSource.getNumeroAllocataire());setNIRRectifie(pSource.getNIRRectifie());setIdentifiantEchangeMSA(pSource.getIdentifiantEchangeMSA());setNomPatronymique(pSource.getNomPatronymique());setPrenom(pSource.getPrenom());setCodePopulation(pSource.getCodePopulation());setDeptNumeroInseeCommune(pSource.getDeptNumeroInseeCommune());setNumeroIdentification(pSource.getNumeroIdentification());setCodeStatut(pSource.getCodeStatut());setIdentifiantIndividuBNI(pSource.getIdentifiantIndividuBNI());setNomMarital(pSource.getNomMarital());setCodeAnteriorite(pSource.getCodeAnteriorite());setZoneInfos(pSource.getZoneInfos());setDateDebutClcaAjpp(pSource.getDateDebutClcaAjpp());setDateFinClcaAjpp(pSource.getDateFinClcaAjpp());setDateNaissance(pSource.getDateNaissance());
  }
  
  public String toString()
  {
    StringBuffer s = new StringBuffer("[_FluxMSA");
    subToString(s);
    s.append("]");
    return s.toString();
  }
  
  protected void subToString(StringBuffer pSource)
  {
    pSource.append(", TypeEnregistrement: ");
    pSource.append(m_typeEnregistrement);
    pSource.append(", CodeMSA: ");
    pSource.append(m_codeMSA);
    pSource.append(", NumeroAllocataire: ");
    pSource.append(m_numeroAllocataire);
    pSource.append(", NIRRectifie: ");
    pSource.append(m_nIRRectifie);
    pSource.append(", IdentifiantEchangeMSA: ");
    pSource.append(m_identifiantEchangeMSA);
    pSource.append(", NomPatronymique: ");
    pSource.append(m_nomPatronymique);
    pSource.append(", Prenom: ");
    pSource.append(m_prenom);
    pSource.append(", CodePopulation: ");
    pSource.append(m_codePopulation);
    pSource.append(", DeptNumeroInseeCommune: ");
    pSource.append(m_deptNumeroInseeCommune);
    pSource.append(", NumeroIdentification: ");
    pSource.append(m_numeroIdentification);
    pSource.append(", CodeStatut: ");
    pSource.append(m_codeStatut);
    pSource.append(", IdentifiantIndividuBNI: ");
    pSource.append(m_identifiantIndividuBNI);
    pSource.append(", NomMarital: ");
    pSource.append(m_nomMarital);
    pSource.append(", CodeAnteriorite: ");
    pSource.append(m_codeAnteriorite);
    pSource.append(", ZoneInfos: ");
    pSource.append(m_zoneInfos);
    pSource.append(", DateDebutClcaAjpp: ");
    pSource.append(m_dateDebutClcaAjpp);
    pSource.append(", DateFinClcaAjpp: ");
    pSource.append(m_dateFinClcaAjpp);
    pSource.append(", DateNaissance: ");
    pSource.append(m_dateNaissance);
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
    pHandler.property("TypeEnregistrement", getTypeEnregistrement(), new Attribute[] { new StringAttribute("C_ERR", getTypeEnregistrement_C_ERR()) });
    
    pHandler.property("CodeMSA", getCodeMSA(), new Attribute[] { new StringAttribute("C_ERR", getCodeMSA_C_ERR()) });
    
    pHandler.property("NumeroAllocataire", getNumeroAllocataire(), new Attribute[] { new StringAttribute("C_ERR", getNumeroAllocataire_C_ERR()) });
    
    pHandler.property("NIRRectifie", getNIRRectifie(), new Attribute[] { new StringAttribute("C_ERR", getNIRRectifie_C_ERR()) });
    
    pHandler.property("IdentifiantEchangeMSA", getIdentifiantEchangeMSA(), new Attribute[] { new StringAttribute("C_ERR", getIdentifiantEchangeMSA_C_ERR()) });
    
    pHandler.property("NomPatronymique", getNomPatronymique(), new Attribute[] { new StringAttribute("C_ERR", getNomPatronymique_C_ERR()) });
    
    pHandler.property("Prenom", getPrenom(), new Attribute[] { new StringAttribute("C_ERR", getPrenom_C_ERR()) });
    
    pHandler.property("CodePopulation", getCodePopulation(), new Attribute[] { new StringAttribute("C_ERR", getCodePopulation_C_ERR()) });
    
    pHandler.property("DeptNumeroInseeCommune", getDeptNumeroInseeCommune(), new Attribute[] { new StringAttribute("C_ERR", getDeptNumeroInseeCommune_C_ERR()) });
    
    pHandler.property("NumeroIdentification", getNumeroIdentification(), new Attribute[] { new StringAttribute("C_ERR", getNumeroIdentification_C_ERR()) });
    
    pHandler.property("CodeStatut", getCodeStatut(), new Attribute[] { new StringAttribute("C_ERR", getCodeStatut_C_ERR()) });
    
    pHandler.property("IdentifiantIndividuBNI", getIdentifiantIndividuBNI(), new Attribute[] { new StringAttribute("C_ERR", getIdentifiantIndividuBNI_C_ERR()) });
    
    pHandler.property("NomMarital", getNomMarital(), new Attribute[] { new StringAttribute("C_ERR", getNomMarital_C_ERR()) });
    
    pHandler.property("CodeAnteriorite", getCodeAnteriorite(), new Attribute[] { new StringAttribute("C_ERR", getCodeAnteriorite_C_ERR()) });
    
    pHandler.property("ZoneInfos", getZoneInfos(), new Attribute[] { new StringAttribute("C_ERR", getZoneInfos_C_ERR()) });
    
    pHandler.property("DateDebutClcaAjpp", getDateDebutClcaAjpp(), new Attribute[] { new StringAttribute("C_ERR", getDateDebutClcaAjpp_C_ERR()) });
    
    pHandler.property("DateFinClcaAjpp", getDateFinClcaAjpp(), new Attribute[] { new StringAttribute("C_ERR", getDateFinClcaAjpp_C_ERR()) });
    
    pHandler.property("DateNaissance", getDateNaissance(), new Attribute[] { new StringAttribute("C_ERR", getDateNaissance_C_ERR()) });
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
    setTypeEnregistrement((String)pHandler.objectProperty("TypeEnregistrement", String.class));
    setTypeEnregistrement_C_ERR(pHandler.stringAttribute("TypeEnregistrement", "C_ERR"));
    
    setCodeMSA((String)pHandler.objectProperty("CodeMSA", String.class));
    setCodeMSA_C_ERR(pHandler.stringAttribute("CodeMSA", "C_ERR"));
    
    setNumeroAllocataire((String)pHandler.objectProperty("NumeroAllocataire", String.class));
    setNumeroAllocataire_C_ERR(pHandler.stringAttribute("NumeroAllocataire", "C_ERR"));
    
    setNIRRectifie((String)pHandler.objectProperty("NIRRectifie", String.class));
    setNIRRectifie_C_ERR(pHandler.stringAttribute("NIRRectifie", "C_ERR"));
    
    setIdentifiantEchangeMSA((String)pHandler.objectProperty("IdentifiantEchangeMSA", String.class));
    setIdentifiantEchangeMSA_C_ERR(pHandler.stringAttribute("IdentifiantEchangeMSA", "C_ERR"));
    
    setNomPatronymique((String)pHandler.objectProperty("NomPatronymique", String.class));
    setNomPatronymique_C_ERR(pHandler.stringAttribute("NomPatronymique", "C_ERR"));
    
    setPrenom((String)pHandler.objectProperty("Prenom", String.class));
    setPrenom_C_ERR(pHandler.stringAttribute("Prenom", "C_ERR"));
    
    setCodePopulation((String)pHandler.objectProperty("CodePopulation", String.class));
    setCodePopulation_C_ERR(pHandler.stringAttribute("CodePopulation", "C_ERR"));
    
    setDeptNumeroInseeCommune((String)pHandler.objectProperty("DeptNumeroInseeCommune", String.class));
    setDeptNumeroInseeCommune_C_ERR(pHandler.stringAttribute("DeptNumeroInseeCommune", "C_ERR"));
    
    setNumeroIdentification((String)pHandler.objectProperty("NumeroIdentification", String.class));
    setNumeroIdentification_C_ERR(pHandler.stringAttribute("NumeroIdentification", "C_ERR"));
    
    setCodeStatut((String)pHandler.objectProperty("CodeStatut", String.class));
    setCodeStatut_C_ERR(pHandler.stringAttribute("CodeStatut", "C_ERR"));
    
    setIdentifiantIndividuBNI((String)pHandler.objectProperty("IdentifiantIndividuBNI", String.class));
    setIdentifiantIndividuBNI_C_ERR(pHandler.stringAttribute("IdentifiantIndividuBNI", "C_ERR"));
    
    setNomMarital((String)pHandler.objectProperty("NomMarital", String.class));
    setNomMarital_C_ERR(pHandler.stringAttribute("NomMarital", "C_ERR"));
    
    setCodeAnteriorite((String)pHandler.objectProperty("CodeAnteriorite", String.class));
    setCodeAnteriorite_C_ERR(pHandler.stringAttribute("CodeAnteriorite", "C_ERR"));
    
    setZoneInfos((String)pHandler.objectProperty("ZoneInfos", String.class));
    setZoneInfos_C_ERR(pHandler.stringAttribute("ZoneInfos", "C_ERR"));
    
    setDateDebutClcaAjpp((Damj)pHandler.objectProperty("DateDebutClcaAjpp", Damj.class));
    setDateDebutClcaAjpp_C_ERR(pHandler.stringAttribute("DateDebutClcaAjpp", "C_ERR"));
    
    setDateFinClcaAjpp((Damj)pHandler.objectProperty("DateFinClcaAjpp", Damj.class));
    setDateFinClcaAjpp_C_ERR(pHandler.stringAttribute("DateFinClcaAjpp", "C_ERR"));
    
    setDateNaissance((Damj)pHandler.objectProperty("DateNaissance", Damj.class));
    setDateNaissance_C_ERR(pHandler.stringAttribute("DateNaissance", "C_ERR"));
  }
  
  public String _getDatabeanName()
  {
    return "FluxMSA";
  }
  
  public boolean _isValidProperty(String pElementName)
  {
    if ("TypeEnregistrement".equals(pElementName)) {
      return true;
    }
    if ("CodeMSA".equals(pElementName)) {
      return true;
    }
    if ("NumeroAllocataire".equals(pElementName)) {
      return true;
    }
    if ("NIRRectifie".equals(pElementName)) {
      return true;
    }
    if ("IdentifiantEchangeMSA".equals(pElementName)) {
      return true;
    }
    if ("NomPatronymique".equals(pElementName)) {
      return true;
    }
    if ("Prenom".equals(pElementName)) {
      return true;
    }
    if ("CodePopulation".equals(pElementName)) {
      return true;
    }
    if ("DeptNumeroInseeCommune".equals(pElementName)) {
      return true;
    }
    if ("NumeroIdentification".equals(pElementName)) {
      return true;
    }
    if ("CodeStatut".equals(pElementName)) {
      return true;
    }
    if ("IdentifiantIndividuBNI".equals(pElementName)) {
      return true;
    }
    if ("NomMarital".equals(pElementName)) {
      return true;
    }
    if ("CodeAnteriorite".equals(pElementName)) {
      return true;
    }
    if ("ZoneInfos".equals(pElementName)) {
      return true;
    }
    if ("DateDebutClcaAjpp".equals(pElementName)) {
      return true;
    }
    if ("DateFinClcaAjpp".equals(pElementName)) {
      return true;
    }
    if ("DateNaissance".equals(pElementName)) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _FluxMSA
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */