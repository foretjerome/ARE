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

public class _FluxCPAM
  extends DataBeanImpl
  implements DataBean, Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  private String m__C_ETAT;
  private String m__IDENT;
  private String m_numeroAllocataire;
  private String m_numeroAllocataire_C_ERR;
  private String m_indicateurCarence;
  private String m_indicateurCarence_C_ERR;
  private String m_nir;
  private String m_nir_C_ERR;
  private String m_nom;
  private String m_nom_C_ERR;
  private String m_nomUsuel;
  private String m_nomUsuel_C_ERR;
  private String m_prenom;
  private String m_prenom_C_ERR;
  private String m_codeAssedic;
  private String m_codeAssedic_C_ERR;
  private String m_codePostal;
  private String m_codePostal_C_ERR;
  private Damj m_dateDebut;
  private String m_dateDebut_C_ERR;
  private Damj m_dateFin;
  private String m_dateFin_C_ERR;
  private Damj m_dateNaissance;
  private String m_dateNaissance_C_ERR;
  private BigDecimal m_numeroCPAM;
  private String m_numeroCPAM_C_ERR;
  
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
  
  public String getIndicateurCarence()
  {
    return m_indicateurCarence;
  }
  
  public String getIndicateurCarence_C_ERR()
  {
    return m_indicateurCarence_C_ERR;
  }
  
  public void setIndicateurCarence(String pValeur)
  {
    m_indicateurCarence = pValeur;
  }
  
  public void setIndicateurCarence_C_ERR(String pValeur_C_ERR)
  {
    m_indicateurCarence_C_ERR = pValeur_C_ERR;
  }
  
  public String getNir()
  {
    return m_nir;
  }
  
  public String getNir_C_ERR()
  {
    return m_nir_C_ERR;
  }
  
  public void setNir(String pValeur)
  {
    m_nir = pValeur;
  }
  
  public void setNir_C_ERR(String pValeur_C_ERR)
  {
    m_nir_C_ERR = pValeur_C_ERR;
  }
  
  public String getNom()
  {
    return m_nom;
  }
  
  public String getNom_C_ERR()
  {
    return m_nom_C_ERR;
  }
  
  public void setNom(String pValeur)
  {
    m_nom = pValeur;
  }
  
  public void setNom_C_ERR(String pValeur_C_ERR)
  {
    m_nom_C_ERR = pValeur_C_ERR;
  }
  
  public String getNomUsuel()
  {
    return m_nomUsuel;
  }
  
  public String getNomUsuel_C_ERR()
  {
    return m_nomUsuel_C_ERR;
  }
  
  public void setNomUsuel(String pValeur)
  {
    m_nomUsuel = pValeur;
  }
  
  public void setNomUsuel_C_ERR(String pValeur_C_ERR)
  {
    m_nomUsuel_C_ERR = pValeur_C_ERR;
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
  
  public String getCodeAssedic()
  {
    return m_codeAssedic;
  }
  
  public String getCodeAssedic_C_ERR()
  {
    return m_codeAssedic_C_ERR;
  }
  
  public void setCodeAssedic(String pValeur)
  {
    m_codeAssedic = pValeur;
  }
  
  public void setCodeAssedic_C_ERR(String pValeur_C_ERR)
  {
    m_codeAssedic_C_ERR = pValeur_C_ERR;
  }
  
  public String getCodePostal()
  {
    return m_codePostal;
  }
  
  public String getCodePostal_C_ERR()
  {
    return m_codePostal_C_ERR;
  }
  
  public void setCodePostal(String pValeur)
  {
    m_codePostal = pValeur;
  }
  
  public void setCodePostal_C_ERR(String pValeur_C_ERR)
  {
    m_codePostal_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDateDebut()
  {
    return m_dateDebut;
  }
  
  public String getDateDebut_C_ERR()
  {
    return m_dateDebut_C_ERR;
  }
  
  public void setDateDebut(Damj pValeur)
  {
    m_dateDebut = pValeur;
  }
  
  public void setDateDebut_C_ERR(String pValeur_C_ERR)
  {
    m_dateDebut_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDateFin()
  {
    return m_dateFin;
  }
  
  public String getDateFin_C_ERR()
  {
    return m_dateFin_C_ERR;
  }
  
  public void setDateFin(Damj pValeur)
  {
    m_dateFin = pValeur;
  }
  
  public void setDateFin_C_ERR(String pValeur_C_ERR)
  {
    m_dateFin_C_ERR = pValeur_C_ERR;
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
  
  public BigDecimal getNumeroCPAM()
  {
    return m_numeroCPAM;
  }
  
  public String getNumeroCPAM_C_ERR()
  {
    return m_numeroCPAM_C_ERR;
  }
  
  public void setNumeroCPAM(BigDecimal pValeur)
  {
    m_numeroCPAM = pValeur;
  }
  
  public void setNumeroCPAM_C_ERR(String pValeur_C_ERR)
  {
    m_numeroCPAM_C_ERR = pValeur_C_ERR;
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
    if ("m_numeroAllocataire_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_indicateurCarence_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_nir_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_nom_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_nomUsuel_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_prenom_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_codeAssedic_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_codePostal_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateDebut_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateFin_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateNaissance_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_numeroCPAM_C_ERR".equals(attrName)) {
      return String.class;
    }
    return null;
  }
  
  public PropertyInfo _getPropertyInfo(String pElementName)
    throws TechniqueException
  {
    if ("NumeroAllocataire".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("IndicateurCarence".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("Nir".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("Nom".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("NomUsuel".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("Prenom".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("CodeAssedic".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("CodePostal".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("DateDebut".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("DateFin".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("DateNaissance".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("NumeroCPAM".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    return null;
  }
  
  public int _getPropertyLength(String pElementName)
  {
    if ("NumeroAllocataire".equals(pElementName)) {
      return 10;
    }
    if ("IndicateurCarence".equals(pElementName)) {
      return 1;
    }
    if ("Nir".equals(pElementName)) {
      return 15;
    }
    if ("Nom".equals(pElementName)) {
      return 25;
    }
    if ("NomUsuel".equals(pElementName)) {
      return 25;
    }
    if ("Prenom".equals(pElementName)) {
      return 15;
    }
    if ("CodeAssedic".equals(pElementName)) {
      return 2;
    }
    if ("CodePostal".equals(pElementName)) {
      return 5;
    }
    if ("DateDebut".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("DateFin".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("DateNaissance".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("NumeroCPAM".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    return -1;
  }
  
  public Object _getProperty(String pName)
    throws Exception
  {
    if ("NumeroAllocataire".equals(pName)) {
      return m_numeroAllocataire;
    }
    if ("IndicateurCarence".equals(pName)) {
      return m_indicateurCarence;
    }
    if ("Nir".equals(pName)) {
      return m_nir;
    }
    if ("Nom".equals(pName)) {
      return m_nom;
    }
    if ("NomUsuel".equals(pName)) {
      return m_nomUsuel;
    }
    if ("Prenom".equals(pName)) {
      return m_prenom;
    }
    if ("CodeAssedic".equals(pName)) {
      return m_codeAssedic;
    }
    if ("CodePostal".equals(pName)) {
      return m_codePostal;
    }
    if ("DateDebut".equals(pName)) {
      return m_dateDebut;
    }
    if ("DateFin".equals(pName)) {
      return m_dateFin;
    }
    if ("DateNaissance".equals(pName)) {
      return m_dateNaissance;
    }
    if ("NumeroCPAM".equals(pName)) {
      return m_numeroCPAM;
    }
    return null;
  }
  
  public Iterator _getPropertyNames()
    throws Exception
  {
    ArrayList liste = new ArrayList();
    liste.add("NumeroAllocataire");
    liste.add("IndicateurCarence");
    liste.add("Nir");
    liste.add("Nom");
    liste.add("NomUsuel");
    liste.add("Prenom");
    liste.add("CodeAssedic");
    liste.add("CodePostal");
    liste.add("DateDebut");
    liste.add("DateFin");
    liste.add("DateNaissance");
    liste.add("NumeroCPAM");
    return liste.iterator();
  }
  
  public ArrayList _getPropertyNames(ArrayList pListe)
    throws Exception
  {
    pListe.add("NumeroAllocataire");
    pListe.add("IndicateurCarence");
    pListe.add("Nir");
    pListe.add("Nom");
    pListe.add("NomUsuel");
    pListe.add("Prenom");
    pListe.add("CodeAssedic");
    pListe.add("CodePostal");
    pListe.add("DateDebut");
    pListe.add("DateFin");
    pListe.add("DateNaissance");
    pListe.add("NumeroCPAM");
    return pListe;
  }
  
  public void _setProperty(String pName, Object pValeur)
    throws Exception
  {
    if ("NumeroAllocataire".equals(pName)) {
      m_numeroAllocataire = ((String)pValeur);
    }
    if ("IndicateurCarence".equals(pName)) {
      m_indicateurCarence = ((String)pValeur);
    }
    if ("Nir".equals(pName)) {
      m_nir = ((String)pValeur);
    }
    if ("Nom".equals(pName)) {
      m_nom = ((String)pValeur);
    }
    if ("NomUsuel".equals(pName)) {
      m_nomUsuel = ((String)pValeur);
    }
    if ("Prenom".equals(pName)) {
      m_prenom = ((String)pValeur);
    }
    if ("CodeAssedic".equals(pName)) {
      m_codeAssedic = ((String)pValeur);
    }
    if ("CodePostal".equals(pName)) {
      m_codePostal = ((String)pValeur);
    }
    if ("DateDebut".equals(pName)) {
      m_dateDebut = ((Damj)pValeur);
    }
    if ("DateFin".equals(pName)) {
      m_dateFin = ((Damj)pValeur);
    }
    if ("DateNaissance".equals(pName)) {
      m_dateNaissance = ((Damj)pValeur);
    }
    if ("NumeroCPAM".equals(pName)) {
      m_numeroCPAM = ((BigDecimal)pValeur);
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
    if ("m_numeroAllocataire_C_ERR".equals(attrName)) {
      m_numeroAllocataire_C_ERR = pValeur;
    }
    if ("m_indicateurCarence_C_ERR".equals(attrName)) {
      m_indicateurCarence_C_ERR = pValeur;
    }
    if ("m_nir_C_ERR".equals(attrName)) {
      m_nir_C_ERR = pValeur;
    }
    if ("m_nom_C_ERR".equals(attrName)) {
      m_nom_C_ERR = pValeur;
    }
    if ("m_nomUsuel_C_ERR".equals(attrName)) {
      m_nomUsuel_C_ERR = pValeur;
    }
    if ("m_prenom_C_ERR".equals(attrName)) {
      m_prenom_C_ERR = pValeur;
    }
    if ("m_codeAssedic_C_ERR".equals(attrName)) {
      m_codeAssedic_C_ERR = pValeur;
    }
    if ("m_codePostal_C_ERR".equals(attrName)) {
      m_codePostal_C_ERR = pValeur;
    }
    if ("m_dateDebut_C_ERR".equals(attrName)) {
      m_dateDebut_C_ERR = pValeur;
    }
    if ("m_dateFin_C_ERR".equals(attrName)) {
      m_dateFin_C_ERR = pValeur;
    }
    if ("m_dateNaissance_C_ERR".equals(attrName)) {
      m_dateNaissance_C_ERR = pValeur;
    }
    if ("m_numeroCPAM_C_ERR".equals(attrName)) {
      m_numeroCPAM_C_ERR = pValeur;
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
    if ("m_numeroAllocataire_C_ERR".equals(attrName)) {
      return m_numeroAllocataire_C_ERR;
    }
    if ("m_indicateurCarence_C_ERR".equals(attrName)) {
      return m_indicateurCarence_C_ERR;
    }
    if ("m_nir_C_ERR".equals(attrName)) {
      return m_nir_C_ERR;
    }
    if ("m_nom_C_ERR".equals(attrName)) {
      return m_nom_C_ERR;
    }
    if ("m_nomUsuel_C_ERR".equals(attrName)) {
      return m_nomUsuel_C_ERR;
    }
    if ("m_prenom_C_ERR".equals(attrName)) {
      return m_prenom_C_ERR;
    }
    if ("m_codeAssedic_C_ERR".equals(attrName)) {
      return m_codeAssedic_C_ERR;
    }
    if ("m_codePostal_C_ERR".equals(attrName)) {
      return m_codePostal_C_ERR;
    }
    if ("m_dateDebut_C_ERR".equals(attrName)) {
      return m_dateDebut_C_ERR;
    }
    if ("m_dateFin_C_ERR".equals(attrName)) {
      return m_dateFin_C_ERR;
    }
    if ("m_dateNaissance_C_ERR".equals(attrName)) {
      return m_dateNaissance_C_ERR;
    }
    if ("m_numeroCPAM_C_ERR".equals(attrName)) {
      return m_numeroCPAM_C_ERR;
    }
    return null;
  }
  
  public boolean equals(Object pObjet)
  {
    if (!(pObjet instanceof _FluxCPAM)) {
      return false;
    }
    _FluxCPAM x = (_FluxCPAM)pObjet;
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
    if (m_indicateurCarence == null)
    {
      if (m_indicateurCarence != null) {
        return false;
      }
    }
    else
    {
      if (m_indicateurCarence == null) {
        return false;
      }
      if (!m_indicateurCarence.equals(m_indicateurCarence)) {
        return false;
      }
    }
    if (m_nir == null)
    {
      if (m_nir != null) {
        return false;
      }
    }
    else
    {
      if (m_nir == null) {
        return false;
      }
      if (!m_nir.equals(m_nir)) {
        return false;
      }
    }
    if (m_nom == null)
    {
      if (m_nom != null) {
        return false;
      }
    }
    else
    {
      if (m_nom == null) {
        return false;
      }
      if (!m_nom.equals(m_nom)) {
        return false;
      }
    }
    if (m_nomUsuel == null)
    {
      if (m_nomUsuel != null) {
        return false;
      }
    }
    else
    {
      if (m_nomUsuel == null) {
        return false;
      }
      if (!m_nomUsuel.equals(m_nomUsuel)) {
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
    if (m_codeAssedic == null)
    {
      if (m_codeAssedic != null) {
        return false;
      }
    }
    else
    {
      if (m_codeAssedic == null) {
        return false;
      }
      if (!m_codeAssedic.equals(m_codeAssedic)) {
        return false;
      }
    }
    if (m_codePostal == null)
    {
      if (m_codePostal != null) {
        return false;
      }
    }
    else
    {
      if (m_codePostal == null) {
        return false;
      }
      if (!m_codePostal.equals(m_codePostal)) {
        return false;
      }
    }
    if (m_dateDebut == null)
    {
      if (m_dateDebut != null) {
        return false;
      }
    }
    else
    {
      if (m_dateDebut == null) {
        return false;
      }
      if (!m_dateDebut.equals(m_dateDebut)) {
        return false;
      }
    }
    if (m_dateFin == null)
    {
      if (m_dateFin != null) {
        return false;
      }
    }
    else
    {
      if (m_dateFin == null) {
        return false;
      }
      if (!m_dateFin.equals(m_dateFin)) {
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
    if (m_numeroCPAM == null)
    {
      if (m_numeroCPAM != null) {
        return false;
      }
    }
    else
    {
      if (m_numeroCPAM == null) {
        return false;
      }
      if (!m_numeroCPAM.equals(m_numeroCPAM)) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int result = 0;
    if (m_numeroAllocataire != null) {
      result += m_numeroAllocataire.hashCode();
    }
    if (m_indicateurCarence != null) {
      result += m_indicateurCarence.hashCode();
    }
    if (m_nir != null) {
      result += m_nir.hashCode();
    }
    if (m_nom != null) {
      result += m_nom.hashCode();
    }
    if (m_nomUsuel != null) {
      result += m_nomUsuel.hashCode();
    }
    if (m_prenom != null) {
      result += m_prenom.hashCode();
    }
    if (m_codeAssedic != null) {
      result += m_codeAssedic.hashCode();
    }
    if (m_codePostal != null) {
      result += m_codePostal.hashCode();
    }
    if (m_dateDebut != null) {
      result += m_dateDebut.hashCode();
    }
    if (m_dateFin != null) {
      result += m_dateFin.hashCode();
    }
    if (m_dateNaissance != null) {
      result += m_dateNaissance.hashCode();
    }
    if (m_numeroCPAM != null) {
      result += m_numeroCPAM.hashCode();
    }
    result *= 17;
    return result;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    _FluxCPAM clone_FluxCPAM = new _FluxCPAM();
    clone_FluxCPAM.populateFrom_FluxCPAM(this);
    return clone_FluxCPAM;
  }
  
  public void populateFrom_FluxCPAM(_FluxCPAM pSource)
  {
    setNumeroAllocataire(pSource.getNumeroAllocataire());setIndicateurCarence(pSource.getIndicateurCarence());setNir(pSource.getNir());setNom(pSource.getNom());setNomUsuel(pSource.getNomUsuel());setPrenom(pSource.getPrenom());setCodeAssedic(pSource.getCodeAssedic());setCodePostal(pSource.getCodePostal());setDateDebut(pSource.getDateDebut());setDateFin(pSource.getDateFin());setDateNaissance(pSource.getDateNaissance());setNumeroCPAM(pSource.getNumeroCPAM());
  }
  
  public String toString()
  {
    StringBuffer s = new StringBuffer("[_FluxCPAM");
    subToString(s);
    s.append("]");
    return s.toString();
  }
  
  protected void subToString(StringBuffer pSource)
  {
    pSource.append(", NumeroAllocataire: ");
    pSource.append(m_numeroAllocataire);
    pSource.append(", IndicateurCarence: ");
    pSource.append(m_indicateurCarence);
    pSource.append(", Nir: ");
    pSource.append(m_nir);
    pSource.append(", Nom: ");
    pSource.append(m_nom);
    pSource.append(", NomUsuel: ");
    pSource.append(m_nomUsuel);
    pSource.append(", Prenom: ");
    pSource.append(m_prenom);
    pSource.append(", CodeAssedic: ");
    pSource.append(m_codeAssedic);
    pSource.append(", CodePostal: ");
    pSource.append(m_codePostal);
    pSource.append(", DateDebut: ");
    pSource.append(m_dateDebut);
    pSource.append(", DateFin: ");
    pSource.append(m_dateFin);
    pSource.append(", DateNaissance: ");
    pSource.append(m_dateNaissance);
    pSource.append(", NumeroCPAM: ");
    pSource.append(m_numeroCPAM);
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
    pHandler.property("NumeroAllocataire", getNumeroAllocataire(), new Attribute[] { new StringAttribute("C_ERR", getNumeroAllocataire_C_ERR()) });
    
    pHandler.property("IndicateurCarence", getIndicateurCarence(), new Attribute[] { new StringAttribute("C_ERR", getIndicateurCarence_C_ERR()) });
    
    pHandler.property("Nir", getNir(), new Attribute[] { new StringAttribute("C_ERR", getNir_C_ERR()) });
    
    pHandler.property("Nom", getNom(), new Attribute[] { new StringAttribute("C_ERR", getNom_C_ERR()) });
    
    pHandler.property("NomUsuel", getNomUsuel(), new Attribute[] { new StringAttribute("C_ERR", getNomUsuel_C_ERR()) });
    
    pHandler.property("Prenom", getPrenom(), new Attribute[] { new StringAttribute("C_ERR", getPrenom_C_ERR()) });
    
    pHandler.property("CodeAssedic", getCodeAssedic(), new Attribute[] { new StringAttribute("C_ERR", getCodeAssedic_C_ERR()) });
    
    pHandler.property("CodePostal", getCodePostal(), new Attribute[] { new StringAttribute("C_ERR", getCodePostal_C_ERR()) });
    
    pHandler.property("DateDebut", getDateDebut(), new Attribute[] { new StringAttribute("C_ERR", getDateDebut_C_ERR()) });
    
    pHandler.property("DateFin", getDateFin(), new Attribute[] { new StringAttribute("C_ERR", getDateFin_C_ERR()) });
    
    pHandler.property("DateNaissance", getDateNaissance(), new Attribute[] { new StringAttribute("C_ERR", getDateNaissance_C_ERR()) });
    
    pHandler.property("NumeroCPAM", getNumeroCPAM(), new Attribute[] { new StringAttribute("C_ERR", getNumeroCPAM_C_ERR()) });
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
    setNumeroAllocataire((String)pHandler.objectProperty("NumeroAllocataire", String.class));
    setNumeroAllocataire_C_ERR(pHandler.stringAttribute("NumeroAllocataire", "C_ERR"));
    
    setIndicateurCarence((String)pHandler.objectProperty("IndicateurCarence", String.class));
    setIndicateurCarence_C_ERR(pHandler.stringAttribute("IndicateurCarence", "C_ERR"));
    
    setNir((String)pHandler.objectProperty("Nir", String.class));
    setNir_C_ERR(pHandler.stringAttribute("Nir", "C_ERR"));
    
    setNom((String)pHandler.objectProperty("Nom", String.class));
    setNom_C_ERR(pHandler.stringAttribute("Nom", "C_ERR"));
    
    setNomUsuel((String)pHandler.objectProperty("NomUsuel", String.class));
    setNomUsuel_C_ERR(pHandler.stringAttribute("NomUsuel", "C_ERR"));
    
    setPrenom((String)pHandler.objectProperty("Prenom", String.class));
    setPrenom_C_ERR(pHandler.stringAttribute("Prenom", "C_ERR"));
    
    setCodeAssedic((String)pHandler.objectProperty("CodeAssedic", String.class));
    setCodeAssedic_C_ERR(pHandler.stringAttribute("CodeAssedic", "C_ERR"));
    
    setCodePostal((String)pHandler.objectProperty("CodePostal", String.class));
    setCodePostal_C_ERR(pHandler.stringAttribute("CodePostal", "C_ERR"));
    
    setDateDebut((Damj)pHandler.objectProperty("DateDebut", Damj.class));
    setDateDebut_C_ERR(pHandler.stringAttribute("DateDebut", "C_ERR"));
    
    setDateFin((Damj)pHandler.objectProperty("DateFin", Damj.class));
    setDateFin_C_ERR(pHandler.stringAttribute("DateFin", "C_ERR"));
    
    setDateNaissance((Damj)pHandler.objectProperty("DateNaissance", Damj.class));
    setDateNaissance_C_ERR(pHandler.stringAttribute("DateNaissance", "C_ERR"));
    
    setNumeroCPAM((BigDecimal)pHandler.objectProperty("NumeroCPAM", BigDecimal.class));
    setNumeroCPAM_C_ERR(pHandler.stringAttribute("NumeroCPAM", "C_ERR"));
  }
  
  public String _getDatabeanName()
  {
    return "FluxCPAM";
  }
  
  public boolean _isValidProperty(String pElementName)
  {
    if ("NumeroAllocataire".equals(pElementName)) {
      return true;
    }
    if ("IndicateurCarence".equals(pElementName)) {
      return true;
    }
    if ("Nir".equals(pElementName)) {
      return true;
    }
    if ("Nom".equals(pElementName)) {
      return true;
    }
    if ("NomUsuel".equals(pElementName)) {
      return true;
    }
    if ("Prenom".equals(pElementName)) {
      return true;
    }
    if ("CodeAssedic".equals(pElementName)) {
      return true;
    }
    if ("CodePostal".equals(pElementName)) {
      return true;
    }
    if ("DateDebut".equals(pElementName)) {
      return true;
    }
    if ("DateFin".equals(pElementName)) {
      return true;
    }
    if ("DateNaissance".equals(pElementName)) {
      return true;
    }
    if ("NumeroCPAM".equals(pElementName)) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _FluxCPAM
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */