package fr.pe.d12dal.service.es.dal;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.databean.Attribute;
import fr.unedic.archi.databean.DataBean;
import fr.unedic.archi.databean.DataBeanImpl;
import fr.unedic.archi.databean.GettersHandler;
import fr.unedic.archi.databean.PropertyInfo;
import fr.unedic.archi.databean.SettersHandler;
import fr.unedic.archi.databean.StringAttribute;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class _InfosDalCALI
  extends DataBeanImpl
  implements DataBean, Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  private String m__C_ETAT;
  private String m__IDENT;
  private String m_refusPropositionFNE;
  private String m_refusPropositionFNE_C_ERR;
  private Boolean m_artisteNonSalarie = null;
  private String m_artisteNonSalarie_C_ERR;
  private Boolean m_marinPecheur = null;
  private String m_marinPecheur_C_ERR;
  private Boolean m_dockerOccasionnel = null;
  private String m_dockerOccasionnel_C_ERR;
  private Boolean m_detenuLibere = null;
  private String m_detenuLibere_C_ERR;
  private Boolean m_salarieExpatrie = null;
  private String m_salarieExpatrie_C_ERR;
  private String m_statutDemande;
  private String m_statutDemande_C_ERR;
  private String m_refExterne;
  private String m_refExterne_C_ERR;
  private _InfosDalCALI_periodesAffiliations m_infosDalCALI_periodesAffiliations;
  private String m_infosDalCALI_periodesAffiliations_C_ERR;
  private _InfosLiquidationDal m_infosLiquidationDal;
  private String m_infosLiquidationDal_C_ERR;
  private String m_identifiantDemandeInstruction;
  private String m_identifiantDemandeInstruction_C_ERR;
  private Date m_dateDJA;
  private String m_dateDJA_C_ERR;
  
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
  
  public String getRefusPropositionFNE()
  {
    return m_refusPropositionFNE;
  }
  
  public String getRefusPropositionFNE_C_ERR()
  {
    return m_refusPropositionFNE_C_ERR;
  }
  
  public void setRefusPropositionFNE(String pValeur)
  {
    if (pValeur != null)
    {
      ExceptionUtil.assertMethodParamNotNull("pValeur (refusPropositionFNE)", pValeur, String.class);
      if (pValeur.length() > _getPropertyLength("refusPropositionFNE"))
      {
        TechniqueException t = new TechniqueException("JXX0100G", "Valeur trop longue pour l'attribut pValeur (refusPropositionFNE).");
        throw new IndexOutOfBoundsException(t.toString());
      }
    }
    m_refusPropositionFNE = pValeur;
  }
  
  public void setRefusPropositionFNE_C_ERR(String pValeur_C_ERR)
  {
    m_refusPropositionFNE_C_ERR = pValeur_C_ERR;
  }
  
  public Boolean getArtisteNonSalarie()
  {
    return m_artisteNonSalarie;
  }
  
  public String getArtisteNonSalarie_C_ERR()
  {
    return m_artisteNonSalarie_C_ERR;
  }
  
  public void setArtisteNonSalarie(Boolean pValeur)
  {
    m_artisteNonSalarie = pValeur;
  }
  
  public void setArtisteNonSalarie_C_ERR(String pValeur_C_ERR)
  {
    m_artisteNonSalarie_C_ERR = pValeur_C_ERR;
  }
  
  public Boolean getMarinPecheur()
  {
    return m_marinPecheur;
  }
  
  public String getMarinPecheur_C_ERR()
  {
    return m_marinPecheur_C_ERR;
  }
  
  public void setMarinPecheur(Boolean pValeur)
  {
    m_marinPecheur = pValeur;
  }
  
  public void setMarinPecheur_C_ERR(String pValeur_C_ERR)
  {
    m_marinPecheur_C_ERR = pValeur_C_ERR;
  }
  
  public Boolean getDockerOccasionnel()
  {
    return m_dockerOccasionnel;
  }
  
  public String getDockerOccasionnel_C_ERR()
  {
    return m_dockerOccasionnel_C_ERR;
  }
  
  public void setDockerOccasionnel(Boolean pValeur)
  {
    m_dockerOccasionnel = pValeur;
  }
  
  public void setDockerOccasionnel_C_ERR(String pValeur_C_ERR)
  {
    m_dockerOccasionnel_C_ERR = pValeur_C_ERR;
  }
  
  public Boolean getDetenuLibere()
  {
    return m_detenuLibere;
  }
  
  public String getDetenuLibere_C_ERR()
  {
    return m_detenuLibere_C_ERR;
  }
  
  public void setDetenuLibere(Boolean pValeur)
  {
    m_detenuLibere = pValeur;
  }
  
  public void setDetenuLibere_C_ERR(String pValeur_C_ERR)
  {
    m_detenuLibere_C_ERR = pValeur_C_ERR;
  }
  
  public Boolean getSalarieExpatrie()
  {
    return m_salarieExpatrie;
  }
  
  public String getSalarieExpatrie_C_ERR()
  {
    return m_salarieExpatrie_C_ERR;
  }
  
  public void setSalarieExpatrie(Boolean pValeur)
  {
    m_salarieExpatrie = pValeur;
  }
  
  public void setSalarieExpatrie_C_ERR(String pValeur_C_ERR)
  {
    m_salarieExpatrie_C_ERR = pValeur_C_ERR;
  }
  
  public String getStatutDemande()
  {
    return m_statutDemande;
  }
  
  public String getStatutDemande_C_ERR()
  {
    return m_statutDemande_C_ERR;
  }
  
  public void setStatutDemande(String pValeur)
  {
    if (pValeur != null)
    {
      ExceptionUtil.assertMethodParamNotNull("pValeur (statutDemande)", pValeur, String.class);
      if (pValeur.length() > _getPropertyLength("statutDemande"))
      {
        TechniqueException t = new TechniqueException("JXX0100G", "Valeur trop longue pour l'attribut pValeur (statutDemande).");
        throw new IndexOutOfBoundsException(t.toString());
      }
    }
    m_statutDemande = pValeur;
  }
  
  public void setStatutDemande_C_ERR(String pValeur_C_ERR)
  {
    m_statutDemande_C_ERR = pValeur_C_ERR;
  }
  
  public String getRefExterne()
  {
    return m_refExterne;
  }
  
  public String getRefExterne_C_ERR()
  {
    return m_refExterne_C_ERR;
  }
  
  public void setRefExterne(String pValeur)
  {
    if (pValeur != null)
    {
      ExceptionUtil.assertMethodParamNotNull("pValeur (refExterne)", pValeur, String.class);
      if (pValeur.length() > _getPropertyLength("refExterne"))
      {
        TechniqueException t = new TechniqueException("JXX0100G", "Valeur trop longue pour l'attribut pValeur (refExterne).");
        throw new IndexOutOfBoundsException(t.toString());
      }
    }
    m_refExterne = pValeur;
  }
  
  public void setRefExterne_C_ERR(String pValeur_C_ERR)
  {
    m_refExterne_C_ERR = pValeur_C_ERR;
  }
  
  public _InfosDalCALI_periodesAffiliations getPeriodesAffiliations()
  {
    return m_infosDalCALI_periodesAffiliations;
  }
  
  public String getPeriodesAffiliations_C_ERR()
  {
    return m_infosDalCALI_periodesAffiliations_C_ERR;
  }
  
  public void setPeriodesAffiliations(_InfosDalCALI_periodesAffiliations pValeur)
  {
    m_infosDalCALI_periodesAffiliations = pValeur;
  }
  
  public void setPeriodesAffiliations_C_ERR(String pValeur_C_ERR)
  {
    m_infosDalCALI_periodesAffiliations_C_ERR = pValeur_C_ERR;
  }
  
  public _InfosLiquidationDal getInfosLiquidationDAL()
  {
    return m_infosLiquidationDal;
  }
  
  public String getInfosLiquidationDAL_C_ERR()
  {
    return m_infosLiquidationDal_C_ERR;
  }
  
  public void setInfosLiquidationDAL(_InfosLiquidationDal pValeur)
  {
    m_infosLiquidationDal = pValeur;
  }
  
  public void setInfosLiquidationDAL_C_ERR(String pValeur_C_ERR)
  {
    m_infosLiquidationDal_C_ERR = pValeur_C_ERR;
  }
  
  public String getIdentifiantDemandeInstruction()
  {
    return m_identifiantDemandeInstruction;
  }
  
  public String getIdentifiantDemandeInstruction_C_ERR()
  {
    return m_identifiantDemandeInstruction_C_ERR;
  }
  
  public void setIdentifiantDemandeInstruction(String pValeur)
  {
    if (pValeur != null)
    {
      ExceptionUtil.assertMethodParamNotNull("pValeur (identifiantDemandeInstruction)", pValeur, String.class);
      if (pValeur.length() > _getPropertyLength("identifiantDemandeInstruction"))
      {
        TechniqueException t = new TechniqueException("JXX0100G", "Valeur trop longue pour l'attribut pValeur (identifiantDemandeInstruction).");
        throw new IndexOutOfBoundsException(t.toString());
      }
    }
    m_identifiantDemandeInstruction = pValeur;
  }
  
  public void setIdentifiantDemandeInstruction_C_ERR(String pValeur_C_ERR)
  {
    m_identifiantDemandeInstruction_C_ERR = pValeur_C_ERR;
  }
  
  public Date getDateDJA()
  {
    return m_dateDJA;
  }
  
  public String getDateDJA_C_ERR()
  {
    return m_dateDJA_C_ERR;
  }
  
  public void setDateDJA(Date pValeur)
  {
    m_dateDJA = pValeur;
  }
  
  public void setDateDJA_C_ERR(String pValeur_C_ERR)
  {
    m_dateDJA_C_ERR = pValeur_C_ERR;
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
    if ("m_refusPropositionFNE_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_artisteNonSalarie_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_marinPecheur_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dockerOccasionnel_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_detenuLibere_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_salarieExpatrie_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_statutDemande_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_refExterne_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_infosDalCALI_periodesAffiliations_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_infosLiquidationDal_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_identifiantDemandeInstruction_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateDJA_C_ERR".equals(attrName)) {
      return String.class;
    }
    return null;
  }
  
  public PropertyInfo _getPropertyInfo(String pElementName)
    throws TechniqueException
  {
    if ("refusPropositionFNE".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("artisteNonSalarie".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Boolean.class, false);
      return info;
    }
    if ("marinPecheur".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Boolean.class, false);
      return info;
    }
    if ("dockerOccasionnel".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Boolean.class, false);
      return info;
    }
    if ("detenuLibere".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Boolean.class, false);
      return info;
    }
    if ("salarieExpatrie".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Boolean.class, false);
      return info;
    }
    if ("statutDemande".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("refExterne".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("InfosDalCALI_periodesAffiliations".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, _InfosDalCALI_periodesAffiliations.class, false);
      return info;
    }
    if ("InfosLiquidationDal".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, _InfosLiquidationDal.class, false);
      return info;
    }
    if ("identifiantDemandeInstruction".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("dateDJA".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Date.class, false);
      return info;
    }
    return null;
  }
  
  public int _getPropertyLength(String pElementName)
  {
    if ("refusPropositionFNE".equals(pElementName)) {
      return 1;
    }
    if ("artisteNonSalarie".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("marinPecheur".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("dockerOccasionnel".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("detenuLibere".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("salarieExpatrie".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("statutDemande".equals(pElementName)) {
      return 2;
    }
    if ("refExterne".equals(pElementName)) {
      return 7;
    }
    if ("InfosDalCALI_periodesAffiliations".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("InfosLiquidationDal".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("identifiantDemandeInstruction".equals(pElementName)) {
      return 30;
    }
    if ("dateDJA".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    return -1;
  }
  
  public Object _getProperty(String pName)
    throws Exception
  {
    if ("refusPropositionFNE".equals(pName)) {
      return m_refusPropositionFNE;
    }
    if ("artisteNonSalarie".equals(pName)) {
      return m_artisteNonSalarie;
    }
    if ("marinPecheur".equals(pName)) {
      return m_marinPecheur;
    }
    if ("dockerOccasionnel".equals(pName)) {
      return m_dockerOccasionnel;
    }
    if ("detenuLibere".equals(pName)) {
      return m_detenuLibere;
    }
    if ("salarieExpatrie".equals(pName)) {
      return m_salarieExpatrie;
    }
    if ("statutDemande".equals(pName)) {
      return m_statutDemande;
    }
    if ("refExterne".equals(pName)) {
      return m_refExterne;
    }
    if ("InfosDalCALI_periodesAffiliations".equals(pName)) {
      return m_infosDalCALI_periodesAffiliations;
    }
    if ("InfosLiquidationDal".equals(pName)) {
      return m_infosLiquidationDal;
    }
    if ("identifiantDemandeInstruction".equals(pName)) {
      return m_identifiantDemandeInstruction;
    }
    if ("dateDJA".equals(pName)) {
      return m_dateDJA;
    }
    return null;
  }
  
  public Iterator _getPropertyNames()
    throws Exception
  {
    ArrayList liste = new ArrayList();
    liste.add("refusPropositionFNE");
    liste.add("artisteNonSalarie");
    liste.add("marinPecheur");
    liste.add("dockerOccasionnel");
    liste.add("detenuLibere");
    liste.add("salarieExpatrie");
    liste.add("statutDemande");
    liste.add("refExterne");
    liste.add("InfosDalCALI_periodesAffiliations");
    liste.add("InfosLiquidationDal");
    liste.add("identifiantDemandeInstruction");
    liste.add("dateDJA");
    return liste.iterator();
  }
  
  public ArrayList _getPropertyNames(ArrayList pListe)
    throws Exception
  {
    pListe.add("refusPropositionFNE");
    pListe.add("artisteNonSalarie");
    pListe.add("marinPecheur");
    pListe.add("dockerOccasionnel");
    pListe.add("detenuLibere");
    pListe.add("salarieExpatrie");
    pListe.add("statutDemande");
    pListe.add("refExterne");
    pListe.add("InfosDalCALI_periodesAffiliations");
    pListe.add("InfosLiquidationDal");
    pListe.add("identifiantDemandeInstruction");
    pListe.add("dateDJA");
    return pListe;
  }
  
  public void _setProperty(String pName, Object pValeur)
    throws Exception
  {
    if ("refusPropositionFNE".equals(pName))
    {
      if ((pValeur != null) && 
        (((String)pValeur).length() > _getPropertyLength("refusPropositionFNE")))
      {
        TechniqueException t = new TechniqueException("JXX0100G", "Valeur trop longue pour l'attribut refusPropositionFNE.");
        throw new IndexOutOfBoundsException(t.toString());
      }
      m_refusPropositionFNE = ((String)pValeur);
    }
    if ("artisteNonSalarie".equals(pName)) {
      m_artisteNonSalarie = ((Boolean)pValeur);
    }
    if ("marinPecheur".equals(pName)) {
      m_marinPecheur = ((Boolean)pValeur);
    }
    if ("dockerOccasionnel".equals(pName)) {
      m_dockerOccasionnel = ((Boolean)pValeur);
    }
    if ("detenuLibere".equals(pName)) {
      m_detenuLibere = ((Boolean)pValeur);
    }
    if ("salarieExpatrie".equals(pName)) {
      m_salarieExpatrie = ((Boolean)pValeur);
    }
    if ("statutDemande".equals(pName))
    {
      if ((pValeur != null) && 
        (((String)pValeur).length() > _getPropertyLength("statutDemande")))
      {
        TechniqueException t = new TechniqueException("JXX0100G", "Valeur trop longue pour l'attribut statutDemande.");
        throw new IndexOutOfBoundsException(t.toString());
      }
      m_statutDemande = ((String)pValeur);
    }
    if ("refExterne".equals(pName))
    {
      if ((pValeur != null) && 
        (((String)pValeur).length() > _getPropertyLength("refExterne")))
      {
        TechniqueException t = new TechniqueException("JXX0100G", "Valeur trop longue pour l'attribut refExterne.");
        throw new IndexOutOfBoundsException(t.toString());
      }
      m_refExterne = ((String)pValeur);
    }
    if ("InfosDalCALI_periodesAffiliations".equals(pName)) {
      m_infosDalCALI_periodesAffiliations = ((_InfosDalCALI_periodesAffiliations)pValeur);
    }
    if ("InfosLiquidationDal".equals(pName)) {
      m_infosLiquidationDal = ((_InfosLiquidationDal)pValeur);
    }
    if ("identifiantDemandeInstruction".equals(pName))
    {
      if ((pValeur != null) && 
        (((String)pValeur).length() > _getPropertyLength("identifiantDemandeInstruction")))
      {
        TechniqueException t = new TechniqueException("JXX0100G", "Valeur trop longue pour l'attribut identifiantDemandeInstruction.");
        throw new IndexOutOfBoundsException(t.toString());
      }
      m_identifiantDemandeInstruction = ((String)pValeur);
    }
    if ("dateDJA".equals(pName)) {
      m_dateDJA = ((Date)pValeur);
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
    if ("m_refusPropositionFNE_C_ERR".equals(attrName)) {
      m_refusPropositionFNE_C_ERR = pValeur;
    }
    if ("m_artisteNonSalarie_C_ERR".equals(attrName)) {
      m_artisteNonSalarie_C_ERR = pValeur;
    }
    if ("m_marinPecheur_C_ERR".equals(attrName)) {
      m_marinPecheur_C_ERR = pValeur;
    }
    if ("m_dockerOccasionnel_C_ERR".equals(attrName)) {
      m_dockerOccasionnel_C_ERR = pValeur;
    }
    if ("m_detenuLibere_C_ERR".equals(attrName)) {
      m_detenuLibere_C_ERR = pValeur;
    }
    if ("m_salarieExpatrie_C_ERR".equals(attrName)) {
      m_salarieExpatrie_C_ERR = pValeur;
    }
    if ("m_statutDemande_C_ERR".equals(attrName)) {
      m_statutDemande_C_ERR = pValeur;
    }
    if ("m_refExterne_C_ERR".equals(attrName)) {
      m_refExterne_C_ERR = pValeur;
    }
    if ("m_infosDalCALI_periodesAffiliations_C_ERR".equals(attrName)) {
      m_infosDalCALI_periodesAffiliations_C_ERR = pValeur;
    }
    if ("m_infosLiquidationDal_C_ERR".equals(attrName)) {
      m_infosLiquidationDal_C_ERR = pValeur;
    }
    if ("m_identifiantDemandeInstruction_C_ERR".equals(attrName)) {
      m_identifiantDemandeInstruction_C_ERR = pValeur;
    }
    if ("m_dateDJA_C_ERR".equals(attrName)) {
      m_dateDJA_C_ERR = pValeur;
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
    if ("m_refusPropositionFNE_C_ERR".equals(attrName)) {
      return m_refusPropositionFNE_C_ERR;
    }
    if ("m_artisteNonSalarie_C_ERR".equals(attrName)) {
      return m_artisteNonSalarie_C_ERR;
    }
    if ("m_marinPecheur_C_ERR".equals(attrName)) {
      return m_marinPecheur_C_ERR;
    }
    if ("m_dockerOccasionnel_C_ERR".equals(attrName)) {
      return m_dockerOccasionnel_C_ERR;
    }
    if ("m_detenuLibere_C_ERR".equals(attrName)) {
      return m_detenuLibere_C_ERR;
    }
    if ("m_salarieExpatrie_C_ERR".equals(attrName)) {
      return m_salarieExpatrie_C_ERR;
    }
    if ("m_statutDemande_C_ERR".equals(attrName)) {
      return m_statutDemande_C_ERR;
    }
    if ("m_refExterne_C_ERR".equals(attrName)) {
      return m_refExterne_C_ERR;
    }
    if ("m_infosDalCALI_periodesAffiliations_C_ERR".equals(attrName)) {
      return m_infosDalCALI_periodesAffiliations_C_ERR;
    }
    if ("m_infosLiquidationDal_C_ERR".equals(attrName)) {
      return m_infosLiquidationDal_C_ERR;
    }
    if ("m_identifiantDemandeInstruction_C_ERR".equals(attrName)) {
      return m_identifiantDemandeInstruction_C_ERR;
    }
    if ("m_dateDJA_C_ERR".equals(attrName)) {
      return m_dateDJA_C_ERR;
    }
    return null;
  }
  
  public boolean equals(Object pObjet)
  {
    if (!(pObjet instanceof _InfosDalCALI)) {
      return false;
    }
    _InfosDalCALI x = (_InfosDalCALI)pObjet;
    if (m_refusPropositionFNE == null)
    {
      if (m_refusPropositionFNE != null) {
        return false;
      }
    }
    else
    {
      if (m_refusPropositionFNE == null) {
        return false;
      }
      if (!m_refusPropositionFNE.equals(m_refusPropositionFNE)) {
        return false;
      }
    }
    if (m_artisteNonSalarie == null)
    {
      if (m_artisteNonSalarie != null) {
        return false;
      }
    }
    else
    {
      if (m_artisteNonSalarie == null) {
        return false;
      }
      if (!m_artisteNonSalarie.equals(m_artisteNonSalarie)) {
        return false;
      }
    }
    if (m_marinPecheur == null)
    {
      if (m_marinPecheur != null) {
        return false;
      }
    }
    else
    {
      if (m_marinPecheur == null) {
        return false;
      }
      if (!m_marinPecheur.equals(m_marinPecheur)) {
        return false;
      }
    }
    if (m_dockerOccasionnel == null)
    {
      if (m_dockerOccasionnel != null) {
        return false;
      }
    }
    else
    {
      if (m_dockerOccasionnel == null) {
        return false;
      }
      if (!m_dockerOccasionnel.equals(m_dockerOccasionnel)) {
        return false;
      }
    }
    if (m_detenuLibere == null)
    {
      if (m_detenuLibere != null) {
        return false;
      }
    }
    else
    {
      if (m_detenuLibere == null) {
        return false;
      }
      if (!m_detenuLibere.equals(m_detenuLibere)) {
        return false;
      }
    }
    if (m_salarieExpatrie == null)
    {
      if (m_salarieExpatrie != null) {
        return false;
      }
    }
    else
    {
      if (m_salarieExpatrie == null) {
        return false;
      }
      if (!m_salarieExpatrie.equals(m_salarieExpatrie)) {
        return false;
      }
    }
    if (m_statutDemande == null)
    {
      if (m_statutDemande != null) {
        return false;
      }
    }
    else
    {
      if (m_statutDemande == null) {
        return false;
      }
      if (!m_statutDemande.equals(m_statutDemande)) {
        return false;
      }
    }
    if (m_refExterne == null)
    {
      if (m_refExterne != null) {
        return false;
      }
    }
    else
    {
      if (m_refExterne == null) {
        return false;
      }
      if (!m_refExterne.equals(m_refExterne)) {
        return false;
      }
    }
    if (m_infosDalCALI_periodesAffiliations == null)
    {
      if (m_infosDalCALI_periodesAffiliations != null) {
        return false;
      }
    }
    else
    {
      if (m_infosDalCALI_periodesAffiliations == null) {
        return false;
      }
      if (!m_infosDalCALI_periodesAffiliations.equals(m_infosDalCALI_periodesAffiliations)) {
        return false;
      }
    }
    if (m_infosLiquidationDal == null)
    {
      if (m_infosLiquidationDal != null) {
        return false;
      }
    }
    else
    {
      if (m_infosLiquidationDal == null) {
        return false;
      }
      if (!m_infosLiquidationDal.equals(m_infosLiquidationDal)) {
        return false;
      }
    }
    if (m_identifiantDemandeInstruction == null)
    {
      if (m_identifiantDemandeInstruction != null) {
        return false;
      }
    }
    else
    {
      if (m_identifiantDemandeInstruction == null) {
        return false;
      }
      if (!m_identifiantDemandeInstruction.equals(m_identifiantDemandeInstruction)) {
        return false;
      }
    }
    if (m_dateDJA == null)
    {
      if (m_dateDJA != null) {
        return false;
      }
    }
    else
    {
      if (m_dateDJA == null) {
        return false;
      }
      if (!m_dateDJA.equals(m_dateDJA)) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int result = 0;
    if (m_refusPropositionFNE != null) {
      result += m_refusPropositionFNE.hashCode();
    }
    if (m_artisteNonSalarie != null) {
      result += m_artisteNonSalarie.hashCode();
    }
    if (m_marinPecheur != null) {
      result += m_marinPecheur.hashCode();
    }
    if (m_dockerOccasionnel != null) {
      result += m_dockerOccasionnel.hashCode();
    }
    if (m_detenuLibere != null) {
      result += m_detenuLibere.hashCode();
    }
    if (m_salarieExpatrie != null) {
      result += m_salarieExpatrie.hashCode();
    }
    if (m_statutDemande != null) {
      result += m_statutDemande.hashCode();
    }
    if (m_refExterne != null) {
      result += m_refExterne.hashCode();
    }
    if (m_infosDalCALI_periodesAffiliations != null) {
      result += m_infosDalCALI_periodesAffiliations.hashCode();
    }
    if (m_infosLiquidationDal != null) {
      result += m_infosLiquidationDal.hashCode();
    }
    if (m_identifiantDemandeInstruction != null) {
      result += m_identifiantDemandeInstruction.hashCode();
    }
    if (m_dateDJA != null) {
      result += m_dateDJA.hashCode();
    }
    result *= 17;
    return result;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    _InfosDalCALI clone_InfosDalCALI = new _InfosDalCALI();
    clone_InfosDalCALI.populateFrom_InfosDalCALI(this);
    return clone_InfosDalCALI;
  }
  
  public void populateFrom_InfosDalCALI(_InfosDalCALI pSource)
  {
    setRefusPropositionFNE(pSource.getRefusPropositionFNE());setArtisteNonSalarie(pSource.getArtisteNonSalarie());setMarinPecheur(pSource.getMarinPecheur());setDockerOccasionnel(pSource.getDockerOccasionnel());setDetenuLibere(pSource.getDetenuLibere());setSalarieExpatrie(pSource.getSalarieExpatrie());setStatutDemande(pSource.getStatutDemande());setRefExterne(pSource.getRefExterne());setPeriodesAffiliations(pSource.getPeriodesAffiliations());setInfosLiquidationDAL(pSource.getInfosLiquidationDAL());setIdentifiantDemandeInstruction(pSource.getIdentifiantDemandeInstruction());setDateDJA(pSource.getDateDJA());
  }
  
  public String toString()
  {
    StringBuffer s = new StringBuffer("[_InfosDalCALI");
    subToString(s);
    s.append("]");
    return s.toString();
  }
  
  protected void subToString(StringBuffer pSource)
  {
    pSource.append(", refusPropositionFNE: ");
    pSource.append(m_refusPropositionFNE);
    pSource.append(", artisteNonSalarie: ");
    pSource.append(m_artisteNonSalarie);
    pSource.append(", marinPecheur: ");
    pSource.append(m_marinPecheur);
    pSource.append(", dockerOccasionnel: ");
    pSource.append(m_dockerOccasionnel);
    pSource.append(", detenuLibere: ");
    pSource.append(m_detenuLibere);
    pSource.append(", salarieExpatrie: ");
    pSource.append(m_salarieExpatrie);
    pSource.append(", statutDemande: ");
    pSource.append(m_statutDemande);
    pSource.append(", refExterne: ");
    pSource.append(m_refExterne);
    pSource.append(", InfosDalCALI_periodesAffiliations: ");
    pSource.append(m_infosDalCALI_periodesAffiliations);
    pSource.append(", InfosLiquidationDal: ");
    pSource.append(m_infosLiquidationDal);
    pSource.append(", identifiantDemandeInstruction: ");
    pSource.append(m_identifiantDemandeInstruction);
    pSource.append(", dateDJA: ");
    pSource.append(m_dateDJA);
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
    pHandler.property("refusPropositionFNE", getRefusPropositionFNE(), new Attribute[] { new StringAttribute("C_ERR", getRefusPropositionFNE_C_ERR()) });
    
    pHandler.property("artisteNonSalarie", getArtisteNonSalarie(), new Attribute[] { new StringAttribute("C_ERR", getArtisteNonSalarie_C_ERR()) });
    
    pHandler.property("marinPecheur", getMarinPecheur(), new Attribute[] { new StringAttribute("C_ERR", getMarinPecheur_C_ERR()) });
    
    pHandler.property("dockerOccasionnel", getDockerOccasionnel(), new Attribute[] { new StringAttribute("C_ERR", getDockerOccasionnel_C_ERR()) });
    
    pHandler.property("detenuLibere", getDetenuLibere(), new Attribute[] { new StringAttribute("C_ERR", getDetenuLibere_C_ERR()) });
    
    pHandler.property("salarieExpatrie", getSalarieExpatrie(), new Attribute[] { new StringAttribute("C_ERR", getSalarieExpatrie_C_ERR()) });
    
    pHandler.property("statutDemande", getStatutDemande(), new Attribute[] { new StringAttribute("C_ERR", getStatutDemande_C_ERR()) });
    
    pHandler.property("refExterne", getRefExterne(), new Attribute[] { new StringAttribute("C_ERR", getRefExterne_C_ERR()) });
    
    DataBean InfosDalCALI_periodesAffiliations_Value = getPeriodesAffiliations();
    GettersHandler InfosDalCALI_periodesAffiliations_GettersHandler = pHandler.property("InfosDalCALI_periodesAffiliations", InfosDalCALI_periodesAffiliations_Value, new Attribute[] { new StringAttribute("C_ERR", getPeriodesAffiliations_C_ERR()) });
    if ((InfosDalCALI_periodesAffiliations_GettersHandler != null) && (InfosDalCALI_periodesAffiliations_Value != null)) {
      InfosDalCALI_periodesAffiliations_Value.goThrough(InfosDalCALI_periodesAffiliations_GettersHandler);
    }
    DataBean InfosLiquidationDal_Value = getInfosLiquidationDAL();
    GettersHandler InfosLiquidationDal_GettersHandler = pHandler.property("InfosLiquidationDal", InfosLiquidationDal_Value, new Attribute[] { new StringAttribute("C_ERR", getInfosLiquidationDAL_C_ERR()) });
    if ((InfosLiquidationDal_GettersHandler != null) && (InfosLiquidationDal_Value != null)) {
      InfosLiquidationDal_Value.goThrough(InfosLiquidationDal_GettersHandler);
    }
    pHandler.property("identifiantDemandeInstruction", getIdentifiantDemandeInstruction(), new Attribute[] { new StringAttribute("C_ERR", getIdentifiantDemandeInstruction_C_ERR()) });
    
    pHandler.property("dateDJA", getDateDJA(), new Attribute[] { new StringAttribute("C_ERR", getDateDJA_C_ERR()) });
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
    setRefusPropositionFNE((String)pHandler.objectProperty("refusPropositionFNE", String.class));
    setRefusPropositionFNE_C_ERR(pHandler.stringAttribute("refusPropositionFNE", "C_ERR"));
    
    setArtisteNonSalarie((Boolean)pHandler.objectProperty("artisteNonSalarie", Boolean.class));
    setArtisteNonSalarie_C_ERR(pHandler.stringAttribute("artisteNonSalarie", "C_ERR"));
    
    setMarinPecheur((Boolean)pHandler.objectProperty("marinPecheur", Boolean.class));
    setMarinPecheur_C_ERR(pHandler.stringAttribute("marinPecheur", "C_ERR"));
    
    setDockerOccasionnel((Boolean)pHandler.objectProperty("dockerOccasionnel", Boolean.class));
    setDockerOccasionnel_C_ERR(pHandler.stringAttribute("dockerOccasionnel", "C_ERR"));
    
    setDetenuLibere((Boolean)pHandler.objectProperty("detenuLibere", Boolean.class));
    setDetenuLibere_C_ERR(pHandler.stringAttribute("detenuLibere", "C_ERR"));
    
    setSalarieExpatrie((Boolean)pHandler.objectProperty("salarieExpatrie", Boolean.class));
    setSalarieExpatrie_C_ERR(pHandler.stringAttribute("salarieExpatrie", "C_ERR"));
    
    setStatutDemande((String)pHandler.objectProperty("statutDemande", String.class));
    setStatutDemande_C_ERR(pHandler.stringAttribute("statutDemande", "C_ERR"));
    
    setRefExterne((String)pHandler.objectProperty("refExterne", String.class));
    setRefExterne_C_ERR(pHandler.stringAttribute("refExterne", "C_ERR"));
    
    setPeriodesAffiliations((_InfosDalCALI_periodesAffiliations)pHandler.databeanProperty("InfosDalCALI_periodesAffiliations", _InfosDalCALI_periodesAffiliations.class));
    setPeriodesAffiliations_C_ERR(pHandler.stringAttribute("InfosDalCALI_periodesAffiliations", "C_ERR"));
    setInfosLiquidationDAL((_InfosLiquidationDal)pHandler.databeanProperty("InfosLiquidationDal", _InfosLiquidationDal.class));
    setInfosLiquidationDAL_C_ERR(pHandler.stringAttribute("InfosLiquidationDal", "C_ERR"));
    setIdentifiantDemandeInstruction((String)pHandler.objectProperty("identifiantDemandeInstruction", String.class));
    setIdentifiantDemandeInstruction_C_ERR(pHandler.stringAttribute("identifiantDemandeInstruction", "C_ERR"));
    
    setDateDJA((Date)pHandler.objectProperty("dateDJA", Date.class));
    setDateDJA_C_ERR(pHandler.stringAttribute("dateDJA", "C_ERR"));
  }
  
  public String _getDatabeanName()
  {
    return "InfosDalCALI";
  }
  
  public boolean _isValidProperty(String pElementName)
  {
    if ("refusPropositionFNE".equals(pElementName)) {
      return true;
    }
    if ("artisteNonSalarie".equals(pElementName)) {
      return true;
    }
    if ("marinPecheur".equals(pElementName)) {
      return true;
    }
    if ("dockerOccasionnel".equals(pElementName)) {
      return true;
    }
    if ("detenuLibere".equals(pElementName)) {
      return true;
    }
    if ("salarieExpatrie".equals(pElementName)) {
      return true;
    }
    if ("statutDemande".equals(pElementName)) {
      return true;
    }
    if ("refExterne".equals(pElementName)) {
      return true;
    }
    if ("InfosDalCALI_periodesAffiliations".equals(pElementName)) {
      return true;
    }
    if ("InfosLiquidationDal".equals(pElementName)) {
      return true;
    }
    if ("identifiantDemandeInstruction".equals(pElementName)) {
      return true;
    }
    if ("dateDJA".equals(pElementName)) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _InfosDalCALI
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */