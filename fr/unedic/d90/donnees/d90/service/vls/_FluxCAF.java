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

public class _FluxCAF
  extends DataBeanImpl
  implements DataBean, Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  private String m__C_ETAT;
  private String m__IDENT;
  private String m_typeEnregistrement;
  private String m_typeEnregistrement_C_ERR;
  private String m_codeCAF;
  private String m_codeCAF_C_ERR;
  private String m_numeroAllocataire;
  private String m_numeroAllocataire_C_ERR;
  private String m_NIR;
  private String m_NIR_C_ERR;
  private String m_identifiantDemandeurCAF;
  private String m_identifiantDemandeurCAF_C_ERR;
  private String m_nomPatronymique;
  private String m_nomPatronymique_C_ERR;
  private String m_prenom;
  private String m_prenom_C_ERR;
  private String m_codePopulation;
  private String m_codePopulation_C_ERR;
  private String m_numeroInseeCommune;
  private String m_numeroInseeCommune_C_ERR;
  private String m_numeroIdentification;
  private String m_numeroIdentification_C_ERR;
  private String m_codeStatut;
  private String m_codeStatut_C_ERR;
  private String m_identifiantIndividuRNA;
  private String m_identifiantIndividuRNA_C_ERR;
  private String m_nomMarital;
  private String m_nomMarital_C_ERR;
  private String m_codeAnteriorite;
  private String m_codeAnteriorite_C_ERR;
  private String m_zoneInfos;
  private String m_zoneInfos_C_ERR;
  private String m_moisEntree;
  private String m_moisEntree_C_ERR;
  private String m_moisSortie;
  private String m_moisSortie_C_ERR;
  private Damj m_dateNaissance;
  private String m_dateNaissance_C_ERR;
  private Damj m_dateFichierExterne;
  private String m_dateFichierExterne_C_ERR;
  
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
  
  public String getCodeCAF()
  {
    return m_codeCAF;
  }
  
  public String getCodeCAF_C_ERR()
  {
    return m_codeCAF_C_ERR;
  }
  
  public void setCodeCAF(String pValeur)
  {
    m_codeCAF = pValeur;
  }
  
  public void setCodeCAF_C_ERR(String pValeur_C_ERR)
  {
    m_codeCAF_C_ERR = pValeur_C_ERR;
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
  
  public String getNIR()
  {
    return m_NIR;
  }
  
  public String getNIR_C_ERR()
  {
    return m_NIR_C_ERR;
  }
  
  public void setNIR(String pValeur)
  {
    m_NIR = pValeur;
  }
  
  public void setNIR_C_ERR(String pValeur_C_ERR)
  {
    m_NIR_C_ERR = pValeur_C_ERR;
  }
  
  public String getIdentifiantDemandeurCAF()
  {
    return m_identifiantDemandeurCAF;
  }
  
  public String getIdentifiantDemandeurCAF_C_ERR()
  {
    return m_identifiantDemandeurCAF_C_ERR;
  }
  
  public void setIdentifiantDemandeurCAF(String pValeur)
  {
    m_identifiantDemandeurCAF = pValeur;
  }
  
  public void setIdentifiantDemandeurCAF_C_ERR(String pValeur_C_ERR)
  {
    m_identifiantDemandeurCAF_C_ERR = pValeur_C_ERR;
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
  
  public String getNumeroInseeCommune()
  {
    return m_numeroInseeCommune;
  }
  
  public String getNumeroInseeCommune_C_ERR()
  {
    return m_numeroInseeCommune_C_ERR;
  }
  
  public void setNumeroInseeCommune(String pValeur)
  {
    m_numeroInseeCommune = pValeur;
  }
  
  public void setNumeroInseeCommune_C_ERR(String pValeur_C_ERR)
  {
    m_numeroInseeCommune_C_ERR = pValeur_C_ERR;
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
  
  public String getIdentifiantIndividuRNA()
  {
    return m_identifiantIndividuRNA;
  }
  
  public String getIdentifiantIndividuRNA_C_ERR()
  {
    return m_identifiantIndividuRNA_C_ERR;
  }
  
  public void setIdentifiantIndividuRNA(String pValeur)
  {
    m_identifiantIndividuRNA = pValeur;
  }
  
  public void setIdentifiantIndividuRNA_C_ERR(String pValeur_C_ERR)
  {
    m_identifiantIndividuRNA_C_ERR = pValeur_C_ERR;
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
  
  public String getMoisEntree()
  {
    return m_moisEntree;
  }
  
  public String getMoisEntree_C_ERR()
  {
    return m_moisEntree_C_ERR;
  }
  
  public void setMoisEntree(String pValeur)
  {
    m_moisEntree = pValeur;
  }
  
  public void setMoisEntree_C_ERR(String pValeur_C_ERR)
  {
    m_moisEntree_C_ERR = pValeur_C_ERR;
  }
  
  public String getMoisSortie()
  {
    return m_moisSortie;
  }
  
  public String getMoisSortie_C_ERR()
  {
    return m_moisSortie_C_ERR;
  }
  
  public void setMoisSortie(String pValeur)
  {
    m_moisSortie = pValeur;
  }
  
  public void setMoisSortie_C_ERR(String pValeur_C_ERR)
  {
    m_moisSortie_C_ERR = pValeur_C_ERR;
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
  
  public Damj getDateFichierExterne()
  {
    return m_dateFichierExterne;
  }
  
  public String getDateFichierExterne_C_ERR()
  {
    return m_dateFichierExterne_C_ERR;
  }
  
  public void setDateFichierExterne(Damj pValeur)
  {
    m_dateFichierExterne = pValeur;
  }
  
  public void setDateFichierExterne_C_ERR(String pValeur_C_ERR)
  {
    m_dateFichierExterne_C_ERR = pValeur_C_ERR;
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
    if ("m_codeCAF_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_numeroAllocataire_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_NIR_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_identifiantDemandeurCAF_C_ERR".equals(attrName)) {
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
    if ("m_numeroInseeCommune_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_numeroIdentification_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_codeStatut_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_identifiantIndividuRNA_C_ERR".equals(attrName)) {
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
    if ("m_moisEntree_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_moisSortie_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateNaissance_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateFichierExterne_C_ERR".equals(attrName)) {
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
    if ("CodeCAF".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("NumeroAllocataire".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("NIR".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("IdentifiantDemandeurCAF".equals(pElementName))
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
    if ("NumeroInseeCommune".equals(pElementName))
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
    if ("IdentifiantIndividuRNA".equals(pElementName))
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
    if ("MoisEntree".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("MoisSortie".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("DateNaissance".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("DateFichierExterne".equals(pElementName))
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
    if ("CodeCAF".equals(pElementName)) {
      return 3;
    }
    if ("NumeroAllocataire".equals(pElementName)) {
      return 10;
    }
    if ("NIR".equals(pElementName)) {
      return 15;
    }
    if ("IdentifiantDemandeurCAF".equals(pElementName)) {
      return 15;
    }
    if ("NomPatronymique".equals(pElementName)) {
      return 16;
    }
    if ("Prenom".equals(pElementName)) {
      return 10;
    }
    if ("CodePopulation".equals(pElementName)) {
      return 1;
    }
    if ("NumeroInseeCommune".equals(pElementName)) {
      return 5;
    }
    if ("NumeroIdentification".equals(pElementName)) {
      return 13;
    }
    if ("CodeStatut".equals(pElementName)) {
      return 1;
    }
    if ("IdentifiantIndividuRNA".equals(pElementName)) {
      return 10;
    }
    if ("NomMarital".equals(pElementName)) {
      return 16;
    }
    if ("CodeAnteriorite".equals(pElementName)) {
      return 1;
    }
    if ("ZoneInfos".equals(pElementName)) {
      return 10;
    }
    if ("MoisEntree".equals(pElementName)) {
      return 6;
    }
    if ("MoisSortie".equals(pElementName)) {
      return 6;
    }
    if ("DateNaissance".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("DateFichierExterne".equals(pElementName)) {
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
    if ("CodeCAF".equals(pName)) {
      return m_codeCAF;
    }
    if ("NumeroAllocataire".equals(pName)) {
      return m_numeroAllocataire;
    }
    if ("NIR".equals(pName)) {
      return m_NIR;
    }
    if ("IdentifiantDemandeurCAF".equals(pName)) {
      return m_identifiantDemandeurCAF;
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
    if ("NumeroInseeCommune".equals(pName)) {
      return m_numeroInseeCommune;
    }
    if ("NumeroIdentification".equals(pName)) {
      return m_numeroIdentification;
    }
    if ("CodeStatut".equals(pName)) {
      return m_codeStatut;
    }
    if ("IdentifiantIndividuRNA".equals(pName)) {
      return m_identifiantIndividuRNA;
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
    if ("MoisEntree".equals(pName)) {
      return m_moisEntree;
    }
    if ("MoisSortie".equals(pName)) {
      return m_moisSortie;
    }
    if ("DateNaissance".equals(pName)) {
      return m_dateNaissance;
    }
    if ("DateFichierExterne".equals(pName)) {
      return m_dateFichierExterne;
    }
    return null;
  }
  
  public Iterator _getPropertyNames()
    throws Exception
  {
    ArrayList liste = new ArrayList();
    liste.add("TypeEnregistrement");
    liste.add("CodeCAF");
    liste.add("NumeroAllocataire");
    liste.add("NIR");
    liste.add("IdentifiantDemandeurCAF");
    liste.add("NomPatronymique");
    liste.add("Prenom");
    liste.add("CodePopulation");
    liste.add("NumeroInseeCommune");
    liste.add("NumeroIdentification");
    liste.add("CodeStatut");
    liste.add("IdentifiantIndividuRNA");
    liste.add("NomMarital");
    liste.add("CodeAnteriorite");
    liste.add("ZoneInfos");
    liste.add("MoisEntree");
    liste.add("MoisSortie");
    liste.add("DateNaissance");
    liste.add("DateFichierExterne");
    return liste.iterator();
  }
  
  public ArrayList _getPropertyNames(ArrayList pListe)
    throws Exception
  {
    pListe.add("TypeEnregistrement");
    pListe.add("CodeCAF");
    pListe.add("NumeroAllocataire");
    pListe.add("NIR");
    pListe.add("IdentifiantDemandeurCAF");
    pListe.add("NomPatronymique");
    pListe.add("Prenom");
    pListe.add("CodePopulation");
    pListe.add("NumeroInseeCommune");
    pListe.add("NumeroIdentification");
    pListe.add("CodeStatut");
    pListe.add("IdentifiantIndividuRNA");
    pListe.add("NomMarital");
    pListe.add("CodeAnteriorite");
    pListe.add("ZoneInfos");
    pListe.add("MoisEntree");
    pListe.add("MoisSortie");
    pListe.add("DateNaissance");
    pListe.add("DateFichierExterne");
    return pListe;
  }
  
  public void _setProperty(String pName, Object pValeur)
    throws Exception
  {
    if ("TypeEnregistrement".equals(pName)) {
      m_typeEnregistrement = ((String)pValeur);
    }
    if ("CodeCAF".equals(pName)) {
      m_codeCAF = ((String)pValeur);
    }
    if ("NumeroAllocataire".equals(pName)) {
      m_numeroAllocataire = ((String)pValeur);
    }
    if ("NIR".equals(pName)) {
      m_NIR = ((String)pValeur);
    }
    if ("IdentifiantDemandeurCAF".equals(pName)) {
      m_identifiantDemandeurCAF = ((String)pValeur);
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
    if ("NumeroInseeCommune".equals(pName)) {
      m_numeroInseeCommune = ((String)pValeur);
    }
    if ("NumeroIdentification".equals(pName)) {
      m_numeroIdentification = ((String)pValeur);
    }
    if ("CodeStatut".equals(pName)) {
      m_codeStatut = ((String)pValeur);
    }
    if ("IdentifiantIndividuRNA".equals(pName)) {
      m_identifiantIndividuRNA = ((String)pValeur);
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
    if ("MoisEntree".equals(pName)) {
      m_moisEntree = ((String)pValeur);
    }
    if ("MoisSortie".equals(pName)) {
      m_moisSortie = ((String)pValeur);
    }
    if ("DateNaissance".equals(pName)) {
      m_dateNaissance = ((Damj)pValeur);
    }
    if ("DateFichierExterne".equals(pName)) {
      m_dateFichierExterne = ((Damj)pValeur);
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
    if ("m_codeCAF_C_ERR".equals(attrName)) {
      m_codeCAF_C_ERR = pValeur;
    }
    if ("m_numeroAllocataire_C_ERR".equals(attrName)) {
      m_numeroAllocataire_C_ERR = pValeur;
    }
    if ("m_NIR_C_ERR".equals(attrName)) {
      m_NIR_C_ERR = pValeur;
    }
    if ("m_identifiantDemandeurCAF_C_ERR".equals(attrName)) {
      m_identifiantDemandeurCAF_C_ERR = pValeur;
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
    if ("m_numeroInseeCommune_C_ERR".equals(attrName)) {
      m_numeroInseeCommune_C_ERR = pValeur;
    }
    if ("m_numeroIdentification_C_ERR".equals(attrName)) {
      m_numeroIdentification_C_ERR = pValeur;
    }
    if ("m_codeStatut_C_ERR".equals(attrName)) {
      m_codeStatut_C_ERR = pValeur;
    }
    if ("m_identifiantIndividuRNA_C_ERR".equals(attrName)) {
      m_identifiantIndividuRNA_C_ERR = pValeur;
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
    if ("m_moisEntree_C_ERR".equals(attrName)) {
      m_moisEntree_C_ERR = pValeur;
    }
    if ("m_moisSortie_C_ERR".equals(attrName)) {
      m_moisSortie_C_ERR = pValeur;
    }
    if ("m_dateNaissance_C_ERR".equals(attrName)) {
      m_dateNaissance_C_ERR = pValeur;
    }
    if ("m_dateFichierExterne_C_ERR".equals(attrName)) {
      m_dateFichierExterne_C_ERR = pValeur;
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
    if ("m_codeCAF_C_ERR".equals(attrName)) {
      return m_codeCAF_C_ERR;
    }
    if ("m_numeroAllocataire_C_ERR".equals(attrName)) {
      return m_numeroAllocataire_C_ERR;
    }
    if ("m_NIR_C_ERR".equals(attrName)) {
      return m_NIR_C_ERR;
    }
    if ("m_identifiantDemandeurCAF_C_ERR".equals(attrName)) {
      return m_identifiantDemandeurCAF_C_ERR;
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
    if ("m_numeroInseeCommune_C_ERR".equals(attrName)) {
      return m_numeroInseeCommune_C_ERR;
    }
    if ("m_numeroIdentification_C_ERR".equals(attrName)) {
      return m_numeroIdentification_C_ERR;
    }
    if ("m_codeStatut_C_ERR".equals(attrName)) {
      return m_codeStatut_C_ERR;
    }
    if ("m_identifiantIndividuRNA_C_ERR".equals(attrName)) {
      return m_identifiantIndividuRNA_C_ERR;
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
    if ("m_moisEntree_C_ERR".equals(attrName)) {
      return m_moisEntree_C_ERR;
    }
    if ("m_moisSortie_C_ERR".equals(attrName)) {
      return m_moisSortie_C_ERR;
    }
    if ("m_dateNaissance_C_ERR".equals(attrName)) {
      return m_dateNaissance_C_ERR;
    }
    if ("m_dateFichierExterne_C_ERR".equals(attrName)) {
      return m_dateFichierExterne_C_ERR;
    }
    return null;
  }
  
  public boolean equals(Object pObjet)
  {
    if (!(pObjet instanceof _FluxCAF)) {
      return false;
    }
    _FluxCAF x = (_FluxCAF)pObjet;
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
    if (m_codeCAF == null)
    {
      if (m_codeCAF != null) {
        return false;
      }
    }
    else
    {
      if (m_codeCAF == null) {
        return false;
      }
      if (!m_codeCAF.equals(m_codeCAF)) {
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
    if (m_NIR == null)
    {
      if (m_NIR != null) {
        return false;
      }
    }
    else
    {
      if (m_NIR == null) {
        return false;
      }
      if (!m_NIR.equals(m_NIR)) {
        return false;
      }
    }
    if (m_identifiantDemandeurCAF == null)
    {
      if (m_identifiantDemandeurCAF != null) {
        return false;
      }
    }
    else
    {
      if (m_identifiantDemandeurCAF == null) {
        return false;
      }
      if (!m_identifiantDemandeurCAF.equals(m_identifiantDemandeurCAF)) {
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
    if (m_numeroInseeCommune == null)
    {
      if (m_numeroInseeCommune != null) {
        return false;
      }
    }
    else
    {
      if (m_numeroInseeCommune == null) {
        return false;
      }
      if (!m_numeroInseeCommune.equals(m_numeroInseeCommune)) {
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
    if (m_identifiantIndividuRNA == null)
    {
      if (m_identifiantIndividuRNA != null) {
        return false;
      }
    }
    else
    {
      if (m_identifiantIndividuRNA == null) {
        return false;
      }
      if (!m_identifiantIndividuRNA.equals(m_identifiantIndividuRNA)) {
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
    if (m_moisEntree == null)
    {
      if (m_moisEntree != null) {
        return false;
      }
    }
    else
    {
      if (m_moisEntree == null) {
        return false;
      }
      if (!m_moisEntree.equals(m_moisEntree)) {
        return false;
      }
    }
    if (m_moisSortie == null)
    {
      if (m_moisSortie != null) {
        return false;
      }
    }
    else
    {
      if (m_moisSortie == null) {
        return false;
      }
      if (!m_moisSortie.equals(m_moisSortie)) {
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
    if (m_dateFichierExterne == null)
    {
      if (m_dateFichierExterne != null) {
        return false;
      }
    }
    else
    {
      if (m_dateFichierExterne == null) {
        return false;
      }
      if (!m_dateFichierExterne.equals(m_dateFichierExterne)) {
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
    if (m_codeCAF != null) {
      result += m_codeCAF.hashCode();
    }
    if (m_numeroAllocataire != null) {
      result += m_numeroAllocataire.hashCode();
    }
    if (m_NIR != null) {
      result += m_NIR.hashCode();
    }
    if (m_identifiantDemandeurCAF != null) {
      result += m_identifiantDemandeurCAF.hashCode();
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
    if (m_numeroInseeCommune != null) {
      result += m_numeroInseeCommune.hashCode();
    }
    if (m_numeroIdentification != null) {
      result += m_numeroIdentification.hashCode();
    }
    if (m_codeStatut != null) {
      result += m_codeStatut.hashCode();
    }
    if (m_identifiantIndividuRNA != null) {
      result += m_identifiantIndividuRNA.hashCode();
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
    if (m_moisEntree != null) {
      result += m_moisEntree.hashCode();
    }
    if (m_moisSortie != null) {
      result += m_moisSortie.hashCode();
    }
    if (m_dateNaissance != null) {
      result += m_dateNaissance.hashCode();
    }
    if (m_dateFichierExterne != null) {
      result += m_dateFichierExterne.hashCode();
    }
    result *= 17;
    return result;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    _FluxCAF clone_FluxCAF = new _FluxCAF();
    clone_FluxCAF.populateFrom_FluxCAF(this);
    return clone_FluxCAF;
  }
  
  public void populateFrom_FluxCAF(_FluxCAF pSource)
  {
    setTypeEnregistrement(pSource.getTypeEnregistrement());setCodeCAF(pSource.getCodeCAF());setNumeroAllocataire(pSource.getNumeroAllocataire());setNIR(pSource.getNIR());setIdentifiantDemandeurCAF(pSource.getIdentifiantDemandeurCAF());setNomPatronymique(pSource.getNomPatronymique());setPrenom(pSource.getPrenom());setCodePopulation(pSource.getCodePopulation());setNumeroInseeCommune(pSource.getNumeroInseeCommune());setNumeroIdentification(pSource.getNumeroIdentification());setCodeStatut(pSource.getCodeStatut());setIdentifiantIndividuRNA(pSource.getIdentifiantIndividuRNA());setNomMarital(pSource.getNomMarital());setCodeAnteriorite(pSource.getCodeAnteriorite());setZoneInfos(pSource.getZoneInfos());setMoisEntree(pSource.getMoisEntree());setMoisSortie(pSource.getMoisSortie());setDateNaissance(pSource.getDateNaissance());setDateFichierExterne(pSource.getDateFichierExterne());
  }
  
  public String toString()
  {
    StringBuffer s = new StringBuffer("[_FluxCAF");
    subToString(s);
    s.append("]");
    return s.toString();
  }
  
  protected void subToString(StringBuffer pSource)
  {
    pSource.append(", TypeEnregistrement: ");
    pSource.append(m_typeEnregistrement);
    pSource.append(", CodeCAF: ");
    pSource.append(m_codeCAF);
    pSource.append(", NumeroAllocataire: ");
    pSource.append(m_numeroAllocataire);
    pSource.append(", NIR: ");
    pSource.append(m_NIR);
    pSource.append(", IdentifiantDemandeurCAF: ");
    pSource.append(m_identifiantDemandeurCAF);
    pSource.append(", NomPatronymique: ");
    pSource.append(m_nomPatronymique);
    pSource.append(", Prenom: ");
    pSource.append(m_prenom);
    pSource.append(", CodePopulation: ");
    pSource.append(m_codePopulation);
    pSource.append(", NumeroInseeCommune: ");
    pSource.append(m_numeroInseeCommune);
    pSource.append(", NumeroIdentification: ");
    pSource.append(m_numeroIdentification);
    pSource.append(", CodeStatut: ");
    pSource.append(m_codeStatut);
    pSource.append(", IdentifiantIndividuRNA: ");
    pSource.append(m_identifiantIndividuRNA);
    pSource.append(", NomMarital: ");
    pSource.append(m_nomMarital);
    pSource.append(", CodeAnteriorite: ");
    pSource.append(m_codeAnteriorite);
    pSource.append(", ZoneInfos: ");
    pSource.append(m_zoneInfos);
    pSource.append(", MoisEntree: ");
    pSource.append(m_moisEntree);
    pSource.append(", MoisSortie: ");
    pSource.append(m_moisSortie);
    pSource.append(", DateNaissance: ");
    pSource.append(m_dateNaissance);
    pSource.append(", DateFichierExterne: ");
    pSource.append(m_dateFichierExterne);
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
    
    pHandler.property("CodeCAF", getCodeCAF(), new Attribute[] { new StringAttribute("C_ERR", getCodeCAF_C_ERR()) });
    
    pHandler.property("NumeroAllocataire", getNumeroAllocataire(), new Attribute[] { new StringAttribute("C_ERR", getNumeroAllocataire_C_ERR()) });
    
    pHandler.property("NIR", getNIR(), new Attribute[] { new StringAttribute("C_ERR", getNIR_C_ERR()) });
    
    pHandler.property("IdentifiantDemandeurCAF", getIdentifiantDemandeurCAF(), new Attribute[] { new StringAttribute("C_ERR", getIdentifiantDemandeurCAF_C_ERR()) });
    
    pHandler.property("NomPatronymique", getNomPatronymique(), new Attribute[] { new StringAttribute("C_ERR", getNomPatronymique_C_ERR()) });
    
    pHandler.property("Prenom", getPrenom(), new Attribute[] { new StringAttribute("C_ERR", getPrenom_C_ERR()) });
    
    pHandler.property("CodePopulation", getCodePopulation(), new Attribute[] { new StringAttribute("C_ERR", getCodePopulation_C_ERR()) });
    
    pHandler.property("NumeroInseeCommune", getNumeroInseeCommune(), new Attribute[] { new StringAttribute("C_ERR", getNumeroInseeCommune_C_ERR()) });
    
    pHandler.property("NumeroIdentification", getNumeroIdentification(), new Attribute[] { new StringAttribute("C_ERR", getNumeroIdentification_C_ERR()) });
    
    pHandler.property("CodeStatut", getCodeStatut(), new Attribute[] { new StringAttribute("C_ERR", getCodeStatut_C_ERR()) });
    
    pHandler.property("IdentifiantIndividuRNA", getIdentifiantIndividuRNA(), new Attribute[] { new StringAttribute("C_ERR", getIdentifiantIndividuRNA_C_ERR()) });
    
    pHandler.property("NomMarital", getNomMarital(), new Attribute[] { new StringAttribute("C_ERR", getNomMarital_C_ERR()) });
    
    pHandler.property("CodeAnteriorite", getCodeAnteriorite(), new Attribute[] { new StringAttribute("C_ERR", getCodeAnteriorite_C_ERR()) });
    
    pHandler.property("ZoneInfos", getZoneInfos(), new Attribute[] { new StringAttribute("C_ERR", getZoneInfos_C_ERR()) });
    
    pHandler.property("MoisEntree", getMoisEntree(), new Attribute[] { new StringAttribute("C_ERR", getMoisEntree_C_ERR()) });
    
    pHandler.property("MoisSortie", getMoisSortie(), new Attribute[] { new StringAttribute("C_ERR", getMoisSortie_C_ERR()) });
    
    pHandler.property("DateNaissance", getDateNaissance(), new Attribute[] { new StringAttribute("C_ERR", getDateNaissance_C_ERR()) });
    
    pHandler.property("DateFichierExterne", getDateFichierExterne(), new Attribute[] { new StringAttribute("C_ERR", getDateFichierExterne_C_ERR()) });
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
    
    setCodeCAF((String)pHandler.objectProperty("CodeCAF", String.class));
    setCodeCAF_C_ERR(pHandler.stringAttribute("CodeCAF", "C_ERR"));
    
    setNumeroAllocataire((String)pHandler.objectProperty("NumeroAllocataire", String.class));
    setNumeroAllocataire_C_ERR(pHandler.stringAttribute("NumeroAllocataire", "C_ERR"));
    
    setNIR((String)pHandler.objectProperty("NIR", String.class));
    setNIR_C_ERR(pHandler.stringAttribute("NIR", "C_ERR"));
    
    setIdentifiantDemandeurCAF((String)pHandler.objectProperty("IdentifiantDemandeurCAF", String.class));
    setIdentifiantDemandeurCAF_C_ERR(pHandler.stringAttribute("IdentifiantDemandeurCAF", "C_ERR"));
    
    setNomPatronymique((String)pHandler.objectProperty("NomPatronymique", String.class));
    setNomPatronymique_C_ERR(pHandler.stringAttribute("NomPatronymique", "C_ERR"));
    
    setPrenom((String)pHandler.objectProperty("Prenom", String.class));
    setPrenom_C_ERR(pHandler.stringAttribute("Prenom", "C_ERR"));
    
    setCodePopulation((String)pHandler.objectProperty("CodePopulation", String.class));
    setCodePopulation_C_ERR(pHandler.stringAttribute("CodePopulation", "C_ERR"));
    
    setNumeroInseeCommune((String)pHandler.objectProperty("NumeroInseeCommune", String.class));
    setNumeroInseeCommune_C_ERR(pHandler.stringAttribute("NumeroInseeCommune", "C_ERR"));
    
    setNumeroIdentification((String)pHandler.objectProperty("NumeroIdentification", String.class));
    setNumeroIdentification_C_ERR(pHandler.stringAttribute("NumeroIdentification", "C_ERR"));
    
    setCodeStatut((String)pHandler.objectProperty("CodeStatut", String.class));
    setCodeStatut_C_ERR(pHandler.stringAttribute("CodeStatut", "C_ERR"));
    
    setIdentifiantIndividuRNA((String)pHandler.objectProperty("IdentifiantIndividuRNA", String.class));
    setIdentifiantIndividuRNA_C_ERR(pHandler.stringAttribute("IdentifiantIndividuRNA", "C_ERR"));
    
    setNomMarital((String)pHandler.objectProperty("NomMarital", String.class));
    setNomMarital_C_ERR(pHandler.stringAttribute("NomMarital", "C_ERR"));
    
    setCodeAnteriorite((String)pHandler.objectProperty("CodeAnteriorite", String.class));
    setCodeAnteriorite_C_ERR(pHandler.stringAttribute("CodeAnteriorite", "C_ERR"));
    
    setZoneInfos((String)pHandler.objectProperty("ZoneInfos", String.class));
    setZoneInfos_C_ERR(pHandler.stringAttribute("ZoneInfos", "C_ERR"));
    
    setMoisEntree((String)pHandler.objectProperty("MoisEntree", String.class));
    setMoisEntree_C_ERR(pHandler.stringAttribute("MoisEntree", "C_ERR"));
    
    setMoisSortie((String)pHandler.objectProperty("MoisSortie", String.class));
    setMoisSortie_C_ERR(pHandler.stringAttribute("MoisSortie", "C_ERR"));
    
    setDateNaissance((Damj)pHandler.objectProperty("DateNaissance", Damj.class));
    setDateNaissance_C_ERR(pHandler.stringAttribute("DateNaissance", "C_ERR"));
    
    setDateFichierExterne((Damj)pHandler.objectProperty("DateFichierExterne", Damj.class));
    setDateFichierExterne_C_ERR(pHandler.stringAttribute("DateFichierExterne", "C_ERR"));
  }
  
  public String _getDatabeanName()
  {
    return "FluxCAF";
  }
  
  public boolean _isValidProperty(String pElementName)
  {
    if ("TypeEnregistrement".equals(pElementName)) {
      return true;
    }
    if ("CodeCAF".equals(pElementName)) {
      return true;
    }
    if ("NumeroAllocataire".equals(pElementName)) {
      return true;
    }
    if ("NIR".equals(pElementName)) {
      return true;
    }
    if ("IdentifiantDemandeurCAF".equals(pElementName)) {
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
    if ("NumeroInseeCommune".equals(pElementName)) {
      return true;
    }
    if ("NumeroIdentification".equals(pElementName)) {
      return true;
    }
    if ("CodeStatut".equals(pElementName)) {
      return true;
    }
    if ("IdentifiantIndividuRNA".equals(pElementName)) {
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
    if ("MoisEntree".equals(pElementName)) {
      return true;
    }
    if ("MoisSortie".equals(pElementName)) {
      return true;
    }
    if ("DateNaissance".equals(pElementName)) {
      return true;
    }
    if ("DateFichierExterne".equals(pElementName)) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _FluxCAF
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */