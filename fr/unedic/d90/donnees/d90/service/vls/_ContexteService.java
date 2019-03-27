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
import fr.unedic.util.temps.Heure;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;

public class _ContexteService
  extends DataBeanImpl
  implements DataBean, Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  private String m__C_ETAT;
  private String m__IDENT;
  private String m_idFlux;
  private String m_idFlux_C_ERR;
  private String m_contexteEmission;
  private String m_contexteEmission_C_ERR;
  private String m_srcCodeAssedic;
  private String m_srcCodeAssedic_C_ERR;
  private String m_srcCodeApplication;
  private String m_srcCodeApplication_C_ERR;
  private String m_srcCodeDomaine;
  private String m_srcCodeDomaine_C_ERR;
  private String m_srcCodeProcessus;
  private String m_srcCodeProcessus_C_ERR;
  private String m_srcCodeTransaction;
  private String m_srcCodeTransaction_C_ERR;
  private String m_srcCodeProgramme;
  private String m_srcCodeProgramme_C_ERR;
  private String m_srcCodeAgent;
  private String m_srcCodeAgent_C_ERR;
  private String m_dstCodeAssedic;
  private String m_dstCodeAssedic_C_ERR;
  private String m_dstCodeApplication;
  private String m_dstCodeApplication_C_ERR;
  private String m_dstCodeDomaine;
  private String m_dstCodeDomaine_C_ERR;
  private String m_codeActivite;
  private String m_codeActivite_C_ERR;
  private String m_idCourantTracker;
  private String m_idCourantTracker_C_ERR;
  private String m_idOrigineTracker;
  private String m_idOrigineTracker_C_ERR;
  private String m_idPrecedentTracker;
  private String m_idPrecedentTracker_C_ERR;
  private String m_codeFlux;
  private String m_codeFlux_C_ERR;
  private String m_envtNature;
  private String m_envtNature_C_ERR;
  private String m_envtBase;
  private String m_envtBase_C_ERR;
  private String m_envtServeur;
  private String m_envtServeur_C_ERR;
  private String m_adresseIP;
  private String m_adresseIP_C_ERR;
  private String m_typeEntite;
  private String m_typeEntite_C_ERR;
  private String m_rsin;
  private String m_rsin_C_ERR;
  private String m_idEntiteAutre;
  private String m_idEntiteAutre_C_ERR;
  private String m_codeAntenne;
  private String m_codeAntenne_C_ERR;
  private Damj m_dateCreation;
  private String m_dateCreation_C_ERR;
  private Damj m_dateTraitement;
  private String m_dateTraitement_C_ERR;
  private Heure m_heureCreation;
  private String m_heureCreation_C_ERR;
  private BigDecimal m_cxala;
  private String m_cxala_C_ERR;
  
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
  
  public String getIdFlux()
  {
    return m_idFlux;
  }
  
  public String getIdFlux_C_ERR()
  {
    return m_idFlux_C_ERR;
  }
  
  public void setIdFlux(String pValeur)
  {
    m_idFlux = pValeur;
  }
  
  public void setIdFlux_C_ERR(String pValeur_C_ERR)
  {
    m_idFlux_C_ERR = pValeur_C_ERR;
  }
  
  public String getContexteEmission()
  {
    return m_contexteEmission;
  }
  
  public String getContexteEmission_C_ERR()
  {
    return m_contexteEmission_C_ERR;
  }
  
  public void setContexteEmission(String pValeur)
  {
    m_contexteEmission = pValeur;
  }
  
  public void setContexteEmission_C_ERR(String pValeur_C_ERR)
  {
    m_contexteEmission_C_ERR = pValeur_C_ERR;
  }
  
  public String getSrcCodeAssedic()
  {
    return m_srcCodeAssedic;
  }
  
  public String getSrcCodeAssedic_C_ERR()
  {
    return m_srcCodeAssedic_C_ERR;
  }
  
  public void setSrcCodeAssedic(String pValeur)
  {
    m_srcCodeAssedic = pValeur;
  }
  
  public void setSrcCodeAssedic_C_ERR(String pValeur_C_ERR)
  {
    m_srcCodeAssedic_C_ERR = pValeur_C_ERR;
  }
  
  public String getSrcCodeApplication()
  {
    return m_srcCodeApplication;
  }
  
  public String getSrcCodeApplication_C_ERR()
  {
    return m_srcCodeApplication_C_ERR;
  }
  
  public void setSrcCodeApplication(String pValeur)
  {
    m_srcCodeApplication = pValeur;
  }
  
  public void setSrcCodeApplication_C_ERR(String pValeur_C_ERR)
  {
    m_srcCodeApplication_C_ERR = pValeur_C_ERR;
  }
  
  public String getSrcCodeDomaine()
  {
    return m_srcCodeDomaine;
  }
  
  public String getSrcCodeDomaine_C_ERR()
  {
    return m_srcCodeDomaine_C_ERR;
  }
  
  public void setSrcCodeDomaine(String pValeur)
  {
    m_srcCodeDomaine = pValeur;
  }
  
  public void setSrcCodeDomaine_C_ERR(String pValeur_C_ERR)
  {
    m_srcCodeDomaine_C_ERR = pValeur_C_ERR;
  }
  
  public String getSrcCodeProcessus()
  {
    return m_srcCodeProcessus;
  }
  
  public String getSrcCodeProcessus_C_ERR()
  {
    return m_srcCodeProcessus_C_ERR;
  }
  
  public void setSrcCodeProcessus(String pValeur)
  {
    m_srcCodeProcessus = pValeur;
  }
  
  public void setSrcCodeProcessus_C_ERR(String pValeur_C_ERR)
  {
    m_srcCodeProcessus_C_ERR = pValeur_C_ERR;
  }
  
  public String getSrcCodeTransaction()
  {
    return m_srcCodeTransaction;
  }
  
  public String getSrcCodeTransaction_C_ERR()
  {
    return m_srcCodeTransaction_C_ERR;
  }
  
  public void setSrcCodeTransaction(String pValeur)
  {
    m_srcCodeTransaction = pValeur;
  }
  
  public void setSrcCodeTransaction_C_ERR(String pValeur_C_ERR)
  {
    m_srcCodeTransaction_C_ERR = pValeur_C_ERR;
  }
  
  public String getSrcCodeProgramme()
  {
    return m_srcCodeProgramme;
  }
  
  public String getSrcCodeProgramme_C_ERR()
  {
    return m_srcCodeProgramme_C_ERR;
  }
  
  public void setSrcCodeProgramme(String pValeur)
  {
    m_srcCodeProgramme = pValeur;
  }
  
  public void setSrcCodeProgramme_C_ERR(String pValeur_C_ERR)
  {
    m_srcCodeProgramme_C_ERR = pValeur_C_ERR;
  }
  
  public String getSrcCodeAgent()
  {
    return m_srcCodeAgent;
  }
  
  public String getSrcCodeAgent_C_ERR()
  {
    return m_srcCodeAgent_C_ERR;
  }
  
  public void setSrcCodeAgent(String pValeur)
  {
    m_srcCodeAgent = pValeur;
  }
  
  public void setSrcCodeAgent_C_ERR(String pValeur_C_ERR)
  {
    m_srcCodeAgent_C_ERR = pValeur_C_ERR;
  }
  
  public String getDstCodeAssedic()
  {
    return m_dstCodeAssedic;
  }
  
  public String getDstCodeAssedic_C_ERR()
  {
    return m_dstCodeAssedic_C_ERR;
  }
  
  public void setDstCodeAssedic(String pValeur)
  {
    m_dstCodeAssedic = pValeur;
  }
  
  public void setDstCodeAssedic_C_ERR(String pValeur_C_ERR)
  {
    m_dstCodeAssedic_C_ERR = pValeur_C_ERR;
  }
  
  public String getDstCodeApplication()
  {
    return m_dstCodeApplication;
  }
  
  public String getDstCodeApplication_C_ERR()
  {
    return m_dstCodeApplication_C_ERR;
  }
  
  public void setDstCodeApplication(String pValeur)
  {
    m_dstCodeApplication = pValeur;
  }
  
  public void setDstCodeApplication_C_ERR(String pValeur_C_ERR)
  {
    m_dstCodeApplication_C_ERR = pValeur_C_ERR;
  }
  
  public String getDstCodeDomaine()
  {
    return m_dstCodeDomaine;
  }
  
  public String getDstCodeDomaine_C_ERR()
  {
    return m_dstCodeDomaine_C_ERR;
  }
  
  public void setDstCodeDomaine(String pValeur)
  {
    m_dstCodeDomaine = pValeur;
  }
  
  public void setDstCodeDomaine_C_ERR(String pValeur_C_ERR)
  {
    m_dstCodeDomaine_C_ERR = pValeur_C_ERR;
  }
  
  public String getCodeActivite()
  {
    return m_codeActivite;
  }
  
  public String getCodeActivite_C_ERR()
  {
    return m_codeActivite_C_ERR;
  }
  
  public void setCodeActivite(String pValeur)
  {
    m_codeActivite = pValeur;
  }
  
  public void setCodeActivite_C_ERR(String pValeur_C_ERR)
  {
    m_codeActivite_C_ERR = pValeur_C_ERR;
  }
  
  public String getIdCourantTracker()
  {
    return m_idCourantTracker;
  }
  
  public String getIdCourantTracker_C_ERR()
  {
    return m_idCourantTracker_C_ERR;
  }
  
  public void setIdCourantTracker(String pValeur)
  {
    m_idCourantTracker = pValeur;
  }
  
  public void setIdCourantTracker_C_ERR(String pValeur_C_ERR)
  {
    m_idCourantTracker_C_ERR = pValeur_C_ERR;
  }
  
  public String getIdOrigineTracker()
  {
    return m_idOrigineTracker;
  }
  
  public String getIdOrigineTracker_C_ERR()
  {
    return m_idOrigineTracker_C_ERR;
  }
  
  public void setIdOrigineTracker(String pValeur)
  {
    m_idOrigineTracker = pValeur;
  }
  
  public void setIdOrigineTracker_C_ERR(String pValeur_C_ERR)
  {
    m_idOrigineTracker_C_ERR = pValeur_C_ERR;
  }
  
  public String getIdPrecedentTracker()
  {
    return m_idPrecedentTracker;
  }
  
  public String getIdPrecedentTracker_C_ERR()
  {
    return m_idPrecedentTracker_C_ERR;
  }
  
  public void setIdPrecedentTracker(String pValeur)
  {
    m_idPrecedentTracker = pValeur;
  }
  
  public void setIdPrecedentTracker_C_ERR(String pValeur_C_ERR)
  {
    m_idPrecedentTracker_C_ERR = pValeur_C_ERR;
  }
  
  public String getCodeFlux()
  {
    return m_codeFlux;
  }
  
  public String getCodeFlux_C_ERR()
  {
    return m_codeFlux_C_ERR;
  }
  
  public void setCodeFlux(String pValeur)
  {
    m_codeFlux = pValeur;
  }
  
  public void setCodeFlux_C_ERR(String pValeur_C_ERR)
  {
    m_codeFlux_C_ERR = pValeur_C_ERR;
  }
  
  public String getEnvtNature()
  {
    return m_envtNature;
  }
  
  public String getEnvtNature_C_ERR()
  {
    return m_envtNature_C_ERR;
  }
  
  public void setEnvtNature(String pValeur)
  {
    m_envtNature = pValeur;
  }
  
  public void setEnvtNature_C_ERR(String pValeur_C_ERR)
  {
    m_envtNature_C_ERR = pValeur_C_ERR;
  }
  
  public String getEnvtBase()
  {
    return m_envtBase;
  }
  
  public String getEnvtBase_C_ERR()
  {
    return m_envtBase_C_ERR;
  }
  
  public void setEnvtBase(String pValeur)
  {
    m_envtBase = pValeur;
  }
  
  public void setEnvtBase_C_ERR(String pValeur_C_ERR)
  {
    m_envtBase_C_ERR = pValeur_C_ERR;
  }
  
  public String getEnvtServeur()
  {
    return m_envtServeur;
  }
  
  public String getEnvtServeur_C_ERR()
  {
    return m_envtServeur_C_ERR;
  }
  
  public void setEnvtServeur(String pValeur)
  {
    m_envtServeur = pValeur;
  }
  
  public void setEnvtServeur_C_ERR(String pValeur_C_ERR)
  {
    m_envtServeur_C_ERR = pValeur_C_ERR;
  }
  
  public String getAdresseIP()
  {
    return m_adresseIP;
  }
  
  public String getAdresseIP_C_ERR()
  {
    return m_adresseIP_C_ERR;
  }
  
  public void setAdresseIP(String pValeur)
  {
    m_adresseIP = pValeur;
  }
  
  public void setAdresseIP_C_ERR(String pValeur_C_ERR)
  {
    m_adresseIP_C_ERR = pValeur_C_ERR;
  }
  
  public String getTypeEntite()
  {
    return m_typeEntite;
  }
  
  public String getTypeEntite_C_ERR()
  {
    return m_typeEntite_C_ERR;
  }
  
  public void setTypeEntite(String pValeur)
  {
    m_typeEntite = pValeur;
  }
  
  public void setTypeEntite_C_ERR(String pValeur_C_ERR)
  {
    m_typeEntite_C_ERR = pValeur_C_ERR;
  }
  
  public String getRsin()
  {
    return m_rsin;
  }
  
  public String getRsin_C_ERR()
  {
    return m_rsin_C_ERR;
  }
  
  public void setRsin(String pValeur)
  {
    m_rsin = pValeur;
  }
  
  public void setRsin_C_ERR(String pValeur_C_ERR)
  {
    m_rsin_C_ERR = pValeur_C_ERR;
  }
  
  public String getIdEntiteAutre()
  {
    return m_idEntiteAutre;
  }
  
  public String getIdEntiteAutre_C_ERR()
  {
    return m_idEntiteAutre_C_ERR;
  }
  
  public void setIdEntiteAutre(String pValeur)
  {
    m_idEntiteAutre = pValeur;
  }
  
  public void setIdEntiteAutre_C_ERR(String pValeur_C_ERR)
  {
    m_idEntiteAutre_C_ERR = pValeur_C_ERR;
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
  
  public Damj getDateCreation()
  {
    return m_dateCreation;
  }
  
  public String getDateCreation_C_ERR()
  {
    return m_dateCreation_C_ERR;
  }
  
  public void setDateCreation(Damj pValeur)
  {
    m_dateCreation = pValeur;
  }
  
  public void setDateCreation_C_ERR(String pValeur_C_ERR)
  {
    m_dateCreation_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDateTraitement()
  {
    return m_dateTraitement;
  }
  
  public String getDateTraitement_C_ERR()
  {
    return m_dateTraitement_C_ERR;
  }
  
  public void setDateTraitement(Damj pValeur)
  {
    m_dateTraitement = pValeur;
  }
  
  public void setDateTraitement_C_ERR(String pValeur_C_ERR)
  {
    m_dateTraitement_C_ERR = pValeur_C_ERR;
  }
  
  public Heure getHeureCreation()
  {
    return m_heureCreation;
  }
  
  public String getHeureCreation_C_ERR()
  {
    return m_heureCreation_C_ERR;
  }
  
  public void setHeureCreation(Heure pValeur)
  {
    m_heureCreation = pValeur;
  }
  
  public void setHeureCreation_C_ERR(String pValeur_C_ERR)
  {
    m_heureCreation_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getCxala()
  {
    return m_cxala;
  }
  
  public String getCxala_C_ERR()
  {
    return m_cxala_C_ERR;
  }
  
  public void setCxala(BigDecimal pValeur)
  {
    m_cxala = pValeur;
  }
  
  public void setCxala_C_ERR(String pValeur_C_ERR)
  {
    m_cxala_C_ERR = pValeur_C_ERR;
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
    if ("m_idFlux_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_contexteEmission_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_srcCodeAssedic_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_srcCodeApplication_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_srcCodeDomaine_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_srcCodeProcessus_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_srcCodeTransaction_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_srcCodeProgramme_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_srcCodeAgent_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dstCodeAssedic_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dstCodeApplication_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dstCodeDomaine_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_codeActivite_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_idCourantTracker_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_idOrigineTracker_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_idPrecedentTracker_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_codeFlux_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_envtNature_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_envtBase_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_envtServeur_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_adresseIP_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_typeEntite_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_rsin_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_idEntiteAutre_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_codeAntenne_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateCreation_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateTraitement_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_heureCreation_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_cxala_C_ERR".equals(attrName)) {
      return String.class;
    }
    return null;
  }
  
  public PropertyInfo _getPropertyInfo(String pElementName)
    throws TechniqueException
  {
    if ("IdFlux".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("ContexteEmission".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("SrcCodeAssedic".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("SrcCodeApplication".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("SrcCodeDomaine".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("SrcCodeProcessus".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("SrcCodeTransaction".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("SrcCodeProgramme".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("SrcCodeAgent".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("DstCodeAssedic".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("DstCodeApplication".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("DstCodeDomaine".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("CodeActivite".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("IdCourantTracker".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("IdOrigineTracker".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("IdPrecedentTracker".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("CodeFlux".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("EnvtNature".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("EnvtBase".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("EnvtServeur".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("AdresseIP".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("TypeEntite".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("Rsin".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("IdEntiteAutre".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("CodeAntenne".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("DateCreation".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("DateTraitement".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("HeureCreation".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Heure.class, false);
      return info;
    }
    if ("Cxala".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    return null;
  }
  
  public int _getPropertyLength(String pElementName)
  {
    if ("IdFlux".equals(pElementName)) {
      return 10;
    }
    if ("ContexteEmission".equals(pElementName)) {
      return 2;
    }
    if ("SrcCodeAssedic".equals(pElementName)) {
      return 3;
    }
    if ("SrcCodeApplication".equals(pElementName)) {
      return 12;
    }
    if ("SrcCodeDomaine".equals(pElementName)) {
      return 3;
    }
    if ("SrcCodeProcessus".equals(pElementName)) {
      return 30;
    }
    if ("SrcCodeTransaction".equals(pElementName)) {
      return 30;
    }
    if ("SrcCodeProgramme".equals(pElementName)) {
      return 30;
    }
    if ("SrcCodeAgent".equals(pElementName)) {
      return 8;
    }
    if ("DstCodeAssedic".equals(pElementName)) {
      return 3;
    }
    if ("DstCodeApplication".equals(pElementName)) {
      return 12;
    }
    if ("DstCodeDomaine".equals(pElementName)) {
      return 3;
    }
    if ("CodeActivite".equals(pElementName)) {
      return 5;
    }
    if ("IdCourantTracker".equals(pElementName)) {
      return 62;
    }
    if ("IdOrigineTracker".equals(pElementName)) {
      return 62;
    }
    if ("IdPrecedentTracker".equals(pElementName)) {
      return 62;
    }
    if ("CodeFlux".equals(pElementName)) {
      return 6;
    }
    if ("EnvtNature".equals(pElementName)) {
      return 20;
    }
    if ("EnvtBase".equals(pElementName)) {
      return 3;
    }
    if ("EnvtServeur".equals(pElementName)) {
      return 20;
    }
    if ("AdresseIP".equals(pElementName)) {
      return 15;
    }
    if ("TypeEntite".equals(pElementName)) {
      return 3;
    }
    if ("Rsin".equals(pElementName)) {
      return 8;
    }
    if ("IdEntiteAutre".equals(pElementName)) {
      return 25;
    }
    if ("CodeAntenne".equals(pElementName)) {
      return 3;
    }
    if ("DateCreation".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("DateTraitement".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("HeureCreation".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("Cxala".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    return -1;
  }
  
  public Object _getProperty(String pName)
    throws Exception
  {
    if ("IdFlux".equals(pName)) {
      return m_idFlux;
    }
    if ("ContexteEmission".equals(pName)) {
      return m_contexteEmission;
    }
    if ("SrcCodeAssedic".equals(pName)) {
      return m_srcCodeAssedic;
    }
    if ("SrcCodeApplication".equals(pName)) {
      return m_srcCodeApplication;
    }
    if ("SrcCodeDomaine".equals(pName)) {
      return m_srcCodeDomaine;
    }
    if ("SrcCodeProcessus".equals(pName)) {
      return m_srcCodeProcessus;
    }
    if ("SrcCodeTransaction".equals(pName)) {
      return m_srcCodeTransaction;
    }
    if ("SrcCodeProgramme".equals(pName)) {
      return m_srcCodeProgramme;
    }
    if ("SrcCodeAgent".equals(pName)) {
      return m_srcCodeAgent;
    }
    if ("DstCodeAssedic".equals(pName)) {
      return m_dstCodeAssedic;
    }
    if ("DstCodeApplication".equals(pName)) {
      return m_dstCodeApplication;
    }
    if ("DstCodeDomaine".equals(pName)) {
      return m_dstCodeDomaine;
    }
    if ("CodeActivite".equals(pName)) {
      return m_codeActivite;
    }
    if ("IdCourantTracker".equals(pName)) {
      return m_idCourantTracker;
    }
    if ("IdOrigineTracker".equals(pName)) {
      return m_idOrigineTracker;
    }
    if ("IdPrecedentTracker".equals(pName)) {
      return m_idPrecedentTracker;
    }
    if ("CodeFlux".equals(pName)) {
      return m_codeFlux;
    }
    if ("EnvtNature".equals(pName)) {
      return m_envtNature;
    }
    if ("EnvtBase".equals(pName)) {
      return m_envtBase;
    }
    if ("EnvtServeur".equals(pName)) {
      return m_envtServeur;
    }
    if ("AdresseIP".equals(pName)) {
      return m_adresseIP;
    }
    if ("TypeEntite".equals(pName)) {
      return m_typeEntite;
    }
    if ("Rsin".equals(pName)) {
      return m_rsin;
    }
    if ("IdEntiteAutre".equals(pName)) {
      return m_idEntiteAutre;
    }
    if ("CodeAntenne".equals(pName)) {
      return m_codeAntenne;
    }
    if ("DateCreation".equals(pName)) {
      return m_dateCreation;
    }
    if ("DateTraitement".equals(pName)) {
      return m_dateTraitement;
    }
    if ("HeureCreation".equals(pName)) {
      return m_heureCreation;
    }
    if ("Cxala".equals(pName)) {
      return m_cxala;
    }
    return null;
  }
  
  public Iterator _getPropertyNames()
    throws Exception
  {
    ArrayList liste = new ArrayList();
    liste.add("IdFlux");
    liste.add("ContexteEmission");
    liste.add("SrcCodeAssedic");
    liste.add("SrcCodeApplication");
    liste.add("SrcCodeDomaine");
    liste.add("SrcCodeProcessus");
    liste.add("SrcCodeTransaction");
    liste.add("SrcCodeProgramme");
    liste.add("SrcCodeAgent");
    liste.add("DstCodeAssedic");
    liste.add("DstCodeApplication");
    liste.add("DstCodeDomaine");
    liste.add("CodeActivite");
    liste.add("IdCourantTracker");
    liste.add("IdOrigineTracker");
    liste.add("IdPrecedentTracker");
    liste.add("CodeFlux");
    liste.add("EnvtNature");
    liste.add("EnvtBase");
    liste.add("EnvtServeur");
    liste.add("AdresseIP");
    liste.add("TypeEntite");
    liste.add("Rsin");
    liste.add("IdEntiteAutre");
    liste.add("CodeAntenne");
    liste.add("DateCreation");
    liste.add("DateTraitement");
    liste.add("HeureCreation");
    liste.add("Cxala");
    return liste.iterator();
  }
  
  public ArrayList _getPropertyNames(ArrayList pListe)
    throws Exception
  {
    pListe.add("IdFlux");
    pListe.add("ContexteEmission");
    pListe.add("SrcCodeAssedic");
    pListe.add("SrcCodeApplication");
    pListe.add("SrcCodeDomaine");
    pListe.add("SrcCodeProcessus");
    pListe.add("SrcCodeTransaction");
    pListe.add("SrcCodeProgramme");
    pListe.add("SrcCodeAgent");
    pListe.add("DstCodeAssedic");
    pListe.add("DstCodeApplication");
    pListe.add("DstCodeDomaine");
    pListe.add("CodeActivite");
    pListe.add("IdCourantTracker");
    pListe.add("IdOrigineTracker");
    pListe.add("IdPrecedentTracker");
    pListe.add("CodeFlux");
    pListe.add("EnvtNature");
    pListe.add("EnvtBase");
    pListe.add("EnvtServeur");
    pListe.add("AdresseIP");
    pListe.add("TypeEntite");
    pListe.add("Rsin");
    pListe.add("IdEntiteAutre");
    pListe.add("CodeAntenne");
    pListe.add("DateCreation");
    pListe.add("DateTraitement");
    pListe.add("HeureCreation");
    pListe.add("Cxala");
    return pListe;
  }
  
  public void _setProperty(String pName, Object pValeur)
    throws Exception
  {
    if ("IdFlux".equals(pName)) {
      m_idFlux = ((String)pValeur);
    }
    if ("ContexteEmission".equals(pName)) {
      m_contexteEmission = ((String)pValeur);
    }
    if ("SrcCodeAssedic".equals(pName)) {
      m_srcCodeAssedic = ((String)pValeur);
    }
    if ("SrcCodeApplication".equals(pName)) {
      m_srcCodeApplication = ((String)pValeur);
    }
    if ("SrcCodeDomaine".equals(pName)) {
      m_srcCodeDomaine = ((String)pValeur);
    }
    if ("SrcCodeProcessus".equals(pName)) {
      m_srcCodeProcessus = ((String)pValeur);
    }
    if ("SrcCodeTransaction".equals(pName)) {
      m_srcCodeTransaction = ((String)pValeur);
    }
    if ("SrcCodeProgramme".equals(pName)) {
      m_srcCodeProgramme = ((String)pValeur);
    }
    if ("SrcCodeAgent".equals(pName)) {
      m_srcCodeAgent = ((String)pValeur);
    }
    if ("DstCodeAssedic".equals(pName)) {
      m_dstCodeAssedic = ((String)pValeur);
    }
    if ("DstCodeApplication".equals(pName)) {
      m_dstCodeApplication = ((String)pValeur);
    }
    if ("DstCodeDomaine".equals(pName)) {
      m_dstCodeDomaine = ((String)pValeur);
    }
    if ("CodeActivite".equals(pName)) {
      m_codeActivite = ((String)pValeur);
    }
    if ("IdCourantTracker".equals(pName)) {
      m_idCourantTracker = ((String)pValeur);
    }
    if ("IdOrigineTracker".equals(pName)) {
      m_idOrigineTracker = ((String)pValeur);
    }
    if ("IdPrecedentTracker".equals(pName)) {
      m_idPrecedentTracker = ((String)pValeur);
    }
    if ("CodeFlux".equals(pName)) {
      m_codeFlux = ((String)pValeur);
    }
    if ("EnvtNature".equals(pName)) {
      m_envtNature = ((String)pValeur);
    }
    if ("EnvtBase".equals(pName)) {
      m_envtBase = ((String)pValeur);
    }
    if ("EnvtServeur".equals(pName)) {
      m_envtServeur = ((String)pValeur);
    }
    if ("AdresseIP".equals(pName)) {
      m_adresseIP = ((String)pValeur);
    }
    if ("TypeEntite".equals(pName)) {
      m_typeEntite = ((String)pValeur);
    }
    if ("Rsin".equals(pName)) {
      m_rsin = ((String)pValeur);
    }
    if ("IdEntiteAutre".equals(pName)) {
      m_idEntiteAutre = ((String)pValeur);
    }
    if ("CodeAntenne".equals(pName)) {
      m_codeAntenne = ((String)pValeur);
    }
    if ("DateCreation".equals(pName)) {
      m_dateCreation = ((Damj)pValeur);
    }
    if ("DateTraitement".equals(pName)) {
      m_dateTraitement = ((Damj)pValeur);
    }
    if ("HeureCreation".equals(pName)) {
      m_heureCreation = ((Heure)pValeur);
    }
    if ("Cxala".equals(pName)) {
      m_cxala = ((BigDecimal)pValeur);
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
    if ("m_idFlux_C_ERR".equals(attrName)) {
      m_idFlux_C_ERR = pValeur;
    }
    if ("m_contexteEmission_C_ERR".equals(attrName)) {
      m_contexteEmission_C_ERR = pValeur;
    }
    if ("m_srcCodeAssedic_C_ERR".equals(attrName)) {
      m_srcCodeAssedic_C_ERR = pValeur;
    }
    if ("m_srcCodeApplication_C_ERR".equals(attrName)) {
      m_srcCodeApplication_C_ERR = pValeur;
    }
    if ("m_srcCodeDomaine_C_ERR".equals(attrName)) {
      m_srcCodeDomaine_C_ERR = pValeur;
    }
    if ("m_srcCodeProcessus_C_ERR".equals(attrName)) {
      m_srcCodeProcessus_C_ERR = pValeur;
    }
    if ("m_srcCodeTransaction_C_ERR".equals(attrName)) {
      m_srcCodeTransaction_C_ERR = pValeur;
    }
    if ("m_srcCodeProgramme_C_ERR".equals(attrName)) {
      m_srcCodeProgramme_C_ERR = pValeur;
    }
    if ("m_srcCodeAgent_C_ERR".equals(attrName)) {
      m_srcCodeAgent_C_ERR = pValeur;
    }
    if ("m_dstCodeAssedic_C_ERR".equals(attrName)) {
      m_dstCodeAssedic_C_ERR = pValeur;
    }
    if ("m_dstCodeApplication_C_ERR".equals(attrName)) {
      m_dstCodeApplication_C_ERR = pValeur;
    }
    if ("m_dstCodeDomaine_C_ERR".equals(attrName)) {
      m_dstCodeDomaine_C_ERR = pValeur;
    }
    if ("m_codeActivite_C_ERR".equals(attrName)) {
      m_codeActivite_C_ERR = pValeur;
    }
    if ("m_idCourantTracker_C_ERR".equals(attrName)) {
      m_idCourantTracker_C_ERR = pValeur;
    }
    if ("m_idOrigineTracker_C_ERR".equals(attrName)) {
      m_idOrigineTracker_C_ERR = pValeur;
    }
    if ("m_idPrecedentTracker_C_ERR".equals(attrName)) {
      m_idPrecedentTracker_C_ERR = pValeur;
    }
    if ("m_codeFlux_C_ERR".equals(attrName)) {
      m_codeFlux_C_ERR = pValeur;
    }
    if ("m_envtNature_C_ERR".equals(attrName)) {
      m_envtNature_C_ERR = pValeur;
    }
    if ("m_envtBase_C_ERR".equals(attrName)) {
      m_envtBase_C_ERR = pValeur;
    }
    if ("m_envtServeur_C_ERR".equals(attrName)) {
      m_envtServeur_C_ERR = pValeur;
    }
    if ("m_adresseIP_C_ERR".equals(attrName)) {
      m_adresseIP_C_ERR = pValeur;
    }
    if ("m_typeEntite_C_ERR".equals(attrName)) {
      m_typeEntite_C_ERR = pValeur;
    }
    if ("m_rsin_C_ERR".equals(attrName)) {
      m_rsin_C_ERR = pValeur;
    }
    if ("m_idEntiteAutre_C_ERR".equals(attrName)) {
      m_idEntiteAutre_C_ERR = pValeur;
    }
    if ("m_codeAntenne_C_ERR".equals(attrName)) {
      m_codeAntenne_C_ERR = pValeur;
    }
    if ("m_dateCreation_C_ERR".equals(attrName)) {
      m_dateCreation_C_ERR = pValeur;
    }
    if ("m_dateTraitement_C_ERR".equals(attrName)) {
      m_dateTraitement_C_ERR = pValeur;
    }
    if ("m_heureCreation_C_ERR".equals(attrName)) {
      m_heureCreation_C_ERR = pValeur;
    }
    if ("m_cxala_C_ERR".equals(attrName)) {
      m_cxala_C_ERR = pValeur;
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
    if ("m_idFlux_C_ERR".equals(attrName)) {
      return m_idFlux_C_ERR;
    }
    if ("m_contexteEmission_C_ERR".equals(attrName)) {
      return m_contexteEmission_C_ERR;
    }
    if ("m_srcCodeAssedic_C_ERR".equals(attrName)) {
      return m_srcCodeAssedic_C_ERR;
    }
    if ("m_srcCodeApplication_C_ERR".equals(attrName)) {
      return m_srcCodeApplication_C_ERR;
    }
    if ("m_srcCodeDomaine_C_ERR".equals(attrName)) {
      return m_srcCodeDomaine_C_ERR;
    }
    if ("m_srcCodeProcessus_C_ERR".equals(attrName)) {
      return m_srcCodeProcessus_C_ERR;
    }
    if ("m_srcCodeTransaction_C_ERR".equals(attrName)) {
      return m_srcCodeTransaction_C_ERR;
    }
    if ("m_srcCodeProgramme_C_ERR".equals(attrName)) {
      return m_srcCodeProgramme_C_ERR;
    }
    if ("m_srcCodeAgent_C_ERR".equals(attrName)) {
      return m_srcCodeAgent_C_ERR;
    }
    if ("m_dstCodeAssedic_C_ERR".equals(attrName)) {
      return m_dstCodeAssedic_C_ERR;
    }
    if ("m_dstCodeApplication_C_ERR".equals(attrName)) {
      return m_dstCodeApplication_C_ERR;
    }
    if ("m_dstCodeDomaine_C_ERR".equals(attrName)) {
      return m_dstCodeDomaine_C_ERR;
    }
    if ("m_codeActivite_C_ERR".equals(attrName)) {
      return m_codeActivite_C_ERR;
    }
    if ("m_idCourantTracker_C_ERR".equals(attrName)) {
      return m_idCourantTracker_C_ERR;
    }
    if ("m_idOrigineTracker_C_ERR".equals(attrName)) {
      return m_idOrigineTracker_C_ERR;
    }
    if ("m_idPrecedentTracker_C_ERR".equals(attrName)) {
      return m_idPrecedentTracker_C_ERR;
    }
    if ("m_codeFlux_C_ERR".equals(attrName)) {
      return m_codeFlux_C_ERR;
    }
    if ("m_envtNature_C_ERR".equals(attrName)) {
      return m_envtNature_C_ERR;
    }
    if ("m_envtBase_C_ERR".equals(attrName)) {
      return m_envtBase_C_ERR;
    }
    if ("m_envtServeur_C_ERR".equals(attrName)) {
      return m_envtServeur_C_ERR;
    }
    if ("m_adresseIP_C_ERR".equals(attrName)) {
      return m_adresseIP_C_ERR;
    }
    if ("m_typeEntite_C_ERR".equals(attrName)) {
      return m_typeEntite_C_ERR;
    }
    if ("m_rsin_C_ERR".equals(attrName)) {
      return m_rsin_C_ERR;
    }
    if ("m_idEntiteAutre_C_ERR".equals(attrName)) {
      return m_idEntiteAutre_C_ERR;
    }
    if ("m_codeAntenne_C_ERR".equals(attrName)) {
      return m_codeAntenne_C_ERR;
    }
    if ("m_dateCreation_C_ERR".equals(attrName)) {
      return m_dateCreation_C_ERR;
    }
    if ("m_dateTraitement_C_ERR".equals(attrName)) {
      return m_dateTraitement_C_ERR;
    }
    if ("m_heureCreation_C_ERR".equals(attrName)) {
      return m_heureCreation_C_ERR;
    }
    if ("m_cxala_C_ERR".equals(attrName)) {
      return m_cxala_C_ERR;
    }
    return null;
  }
  
  public boolean equals(Object pObjet)
  {
    if (!(pObjet instanceof _ContexteService)) {
      return false;
    }
    _ContexteService x = (_ContexteService)pObjet;
    if (m_idFlux == null)
    {
      if (m_idFlux != null) {
        return false;
      }
    }
    else
    {
      if (m_idFlux == null) {
        return false;
      }
      if (!m_idFlux.equals(m_idFlux)) {
        return false;
      }
    }
    if (m_contexteEmission == null)
    {
      if (m_contexteEmission != null) {
        return false;
      }
    }
    else
    {
      if (m_contexteEmission == null) {
        return false;
      }
      if (!m_contexteEmission.equals(m_contexteEmission)) {
        return false;
      }
    }
    if (m_srcCodeAssedic == null)
    {
      if (m_srcCodeAssedic != null) {
        return false;
      }
    }
    else
    {
      if (m_srcCodeAssedic == null) {
        return false;
      }
      if (!m_srcCodeAssedic.equals(m_srcCodeAssedic)) {
        return false;
      }
    }
    if (m_srcCodeApplication == null)
    {
      if (m_srcCodeApplication != null) {
        return false;
      }
    }
    else
    {
      if (m_srcCodeApplication == null) {
        return false;
      }
      if (!m_srcCodeApplication.equals(m_srcCodeApplication)) {
        return false;
      }
    }
    if (m_srcCodeDomaine == null)
    {
      if (m_srcCodeDomaine != null) {
        return false;
      }
    }
    else
    {
      if (m_srcCodeDomaine == null) {
        return false;
      }
      if (!m_srcCodeDomaine.equals(m_srcCodeDomaine)) {
        return false;
      }
    }
    if (m_srcCodeProcessus == null)
    {
      if (m_srcCodeProcessus != null) {
        return false;
      }
    }
    else
    {
      if (m_srcCodeProcessus == null) {
        return false;
      }
      if (!m_srcCodeProcessus.equals(m_srcCodeProcessus)) {
        return false;
      }
    }
    if (m_srcCodeTransaction == null)
    {
      if (m_srcCodeTransaction != null) {
        return false;
      }
    }
    else
    {
      if (m_srcCodeTransaction == null) {
        return false;
      }
      if (!m_srcCodeTransaction.equals(m_srcCodeTransaction)) {
        return false;
      }
    }
    if (m_srcCodeProgramme == null)
    {
      if (m_srcCodeProgramme != null) {
        return false;
      }
    }
    else
    {
      if (m_srcCodeProgramme == null) {
        return false;
      }
      if (!m_srcCodeProgramme.equals(m_srcCodeProgramme)) {
        return false;
      }
    }
    if (m_srcCodeAgent == null)
    {
      if (m_srcCodeAgent != null) {
        return false;
      }
    }
    else
    {
      if (m_srcCodeAgent == null) {
        return false;
      }
      if (!m_srcCodeAgent.equals(m_srcCodeAgent)) {
        return false;
      }
    }
    if (m_dstCodeAssedic == null)
    {
      if (m_dstCodeAssedic != null) {
        return false;
      }
    }
    else
    {
      if (m_dstCodeAssedic == null) {
        return false;
      }
      if (!m_dstCodeAssedic.equals(m_dstCodeAssedic)) {
        return false;
      }
    }
    if (m_dstCodeApplication == null)
    {
      if (m_dstCodeApplication != null) {
        return false;
      }
    }
    else
    {
      if (m_dstCodeApplication == null) {
        return false;
      }
      if (!m_dstCodeApplication.equals(m_dstCodeApplication)) {
        return false;
      }
    }
    if (m_dstCodeDomaine == null)
    {
      if (m_dstCodeDomaine != null) {
        return false;
      }
    }
    else
    {
      if (m_dstCodeDomaine == null) {
        return false;
      }
      if (!m_dstCodeDomaine.equals(m_dstCodeDomaine)) {
        return false;
      }
    }
    if (m_codeActivite == null)
    {
      if (m_codeActivite != null) {
        return false;
      }
    }
    else
    {
      if (m_codeActivite == null) {
        return false;
      }
      if (!m_codeActivite.equals(m_codeActivite)) {
        return false;
      }
    }
    if (m_idCourantTracker == null)
    {
      if (m_idCourantTracker != null) {
        return false;
      }
    }
    else
    {
      if (m_idCourantTracker == null) {
        return false;
      }
      if (!m_idCourantTracker.equals(m_idCourantTracker)) {
        return false;
      }
    }
    if (m_idOrigineTracker == null)
    {
      if (m_idOrigineTracker != null) {
        return false;
      }
    }
    else
    {
      if (m_idOrigineTracker == null) {
        return false;
      }
      if (!m_idOrigineTracker.equals(m_idOrigineTracker)) {
        return false;
      }
    }
    if (m_idPrecedentTracker == null)
    {
      if (m_idPrecedentTracker != null) {
        return false;
      }
    }
    else
    {
      if (m_idPrecedentTracker == null) {
        return false;
      }
      if (!m_idPrecedentTracker.equals(m_idPrecedentTracker)) {
        return false;
      }
    }
    if (m_codeFlux == null)
    {
      if (m_codeFlux != null) {
        return false;
      }
    }
    else
    {
      if (m_codeFlux == null) {
        return false;
      }
      if (!m_codeFlux.equals(m_codeFlux)) {
        return false;
      }
    }
    if (m_envtNature == null)
    {
      if (m_envtNature != null) {
        return false;
      }
    }
    else
    {
      if (m_envtNature == null) {
        return false;
      }
      if (!m_envtNature.equals(m_envtNature)) {
        return false;
      }
    }
    if (m_envtBase == null)
    {
      if (m_envtBase != null) {
        return false;
      }
    }
    else
    {
      if (m_envtBase == null) {
        return false;
      }
      if (!m_envtBase.equals(m_envtBase)) {
        return false;
      }
    }
    if (m_envtServeur == null)
    {
      if (m_envtServeur != null) {
        return false;
      }
    }
    else
    {
      if (m_envtServeur == null) {
        return false;
      }
      if (!m_envtServeur.equals(m_envtServeur)) {
        return false;
      }
    }
    if (m_adresseIP == null)
    {
      if (m_adresseIP != null) {
        return false;
      }
    }
    else
    {
      if (m_adresseIP == null) {
        return false;
      }
      if (!m_adresseIP.equals(m_adresseIP)) {
        return false;
      }
    }
    if (m_typeEntite == null)
    {
      if (m_typeEntite != null) {
        return false;
      }
    }
    else
    {
      if (m_typeEntite == null) {
        return false;
      }
      if (!m_typeEntite.equals(m_typeEntite)) {
        return false;
      }
    }
    if (m_rsin == null)
    {
      if (m_rsin != null) {
        return false;
      }
    }
    else
    {
      if (m_rsin == null) {
        return false;
      }
      if (!m_rsin.equals(m_rsin)) {
        return false;
      }
    }
    if (m_idEntiteAutre == null)
    {
      if (m_idEntiteAutre != null) {
        return false;
      }
    }
    else
    {
      if (m_idEntiteAutre == null) {
        return false;
      }
      if (!m_idEntiteAutre.equals(m_idEntiteAutre)) {
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
    if (m_dateCreation == null)
    {
      if (m_dateCreation != null) {
        return false;
      }
    }
    else
    {
      if (m_dateCreation == null) {
        return false;
      }
      if (!m_dateCreation.equals(m_dateCreation)) {
        return false;
      }
    }
    if (m_dateTraitement == null)
    {
      if (m_dateTraitement != null) {
        return false;
      }
    }
    else
    {
      if (m_dateTraitement == null) {
        return false;
      }
      if (!m_dateTraitement.equals(m_dateTraitement)) {
        return false;
      }
    }
    if (m_heureCreation == null)
    {
      if (m_heureCreation != null) {
        return false;
      }
    }
    else
    {
      if (m_heureCreation == null) {
        return false;
      }
      if (!m_heureCreation.equals(m_heureCreation)) {
        return false;
      }
    }
    if (m_cxala == null)
    {
      if (m_cxala != null) {
        return false;
      }
    }
    else
    {
      if (m_cxala == null) {
        return false;
      }
      if (!m_cxala.equals(m_cxala)) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int result = 0;
    if (m_idFlux != null) {
      result += m_idFlux.hashCode();
    }
    if (m_contexteEmission != null) {
      result += m_contexteEmission.hashCode();
    }
    if (m_srcCodeAssedic != null) {
      result += m_srcCodeAssedic.hashCode();
    }
    if (m_srcCodeApplication != null) {
      result += m_srcCodeApplication.hashCode();
    }
    if (m_srcCodeDomaine != null) {
      result += m_srcCodeDomaine.hashCode();
    }
    if (m_srcCodeProcessus != null) {
      result += m_srcCodeProcessus.hashCode();
    }
    if (m_srcCodeTransaction != null) {
      result += m_srcCodeTransaction.hashCode();
    }
    if (m_srcCodeProgramme != null) {
      result += m_srcCodeProgramme.hashCode();
    }
    if (m_srcCodeAgent != null) {
      result += m_srcCodeAgent.hashCode();
    }
    if (m_dstCodeAssedic != null) {
      result += m_dstCodeAssedic.hashCode();
    }
    if (m_dstCodeApplication != null) {
      result += m_dstCodeApplication.hashCode();
    }
    if (m_dstCodeDomaine != null) {
      result += m_dstCodeDomaine.hashCode();
    }
    if (m_codeActivite != null) {
      result += m_codeActivite.hashCode();
    }
    if (m_idCourantTracker != null) {
      result += m_idCourantTracker.hashCode();
    }
    if (m_idOrigineTracker != null) {
      result += m_idOrigineTracker.hashCode();
    }
    if (m_idPrecedentTracker != null) {
      result += m_idPrecedentTracker.hashCode();
    }
    if (m_codeFlux != null) {
      result += m_codeFlux.hashCode();
    }
    if (m_envtNature != null) {
      result += m_envtNature.hashCode();
    }
    if (m_envtBase != null) {
      result += m_envtBase.hashCode();
    }
    if (m_envtServeur != null) {
      result += m_envtServeur.hashCode();
    }
    if (m_adresseIP != null) {
      result += m_adresseIP.hashCode();
    }
    if (m_typeEntite != null) {
      result += m_typeEntite.hashCode();
    }
    if (m_rsin != null) {
      result += m_rsin.hashCode();
    }
    if (m_idEntiteAutre != null) {
      result += m_idEntiteAutre.hashCode();
    }
    if (m_codeAntenne != null) {
      result += m_codeAntenne.hashCode();
    }
    if (m_dateCreation != null) {
      result += m_dateCreation.hashCode();
    }
    if (m_dateTraitement != null) {
      result += m_dateTraitement.hashCode();
    }
    if (m_heureCreation != null) {
      result += m_heureCreation.hashCode();
    }
    if (m_cxala != null) {
      result += m_cxala.hashCode();
    }
    result *= 17;
    return result;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    _ContexteService clone_ContexteService = new _ContexteService();
    clone_ContexteService.populateFrom_ContexteService(this);
    return clone_ContexteService;
  }
  
  public void populateFrom_ContexteService(_ContexteService pSource)
  {
    setIdFlux(pSource.getIdFlux());setContexteEmission(pSource.getContexteEmission());setSrcCodeAssedic(pSource.getSrcCodeAssedic());setSrcCodeApplication(pSource.getSrcCodeApplication());setSrcCodeDomaine(pSource.getSrcCodeDomaine());setSrcCodeProcessus(pSource.getSrcCodeProcessus());setSrcCodeTransaction(pSource.getSrcCodeTransaction());setSrcCodeProgramme(pSource.getSrcCodeProgramme());setSrcCodeAgent(pSource.getSrcCodeAgent());setDstCodeAssedic(pSource.getDstCodeAssedic());setDstCodeApplication(pSource.getDstCodeApplication());setDstCodeDomaine(pSource.getDstCodeDomaine());setCodeActivite(pSource.getCodeActivite());setIdCourantTracker(pSource.getIdCourantTracker());setIdOrigineTracker(pSource.getIdOrigineTracker());setIdPrecedentTracker(pSource.getIdPrecedentTracker());setCodeFlux(pSource.getCodeFlux());setEnvtNature(pSource.getEnvtNature());setEnvtBase(pSource.getEnvtBase());setEnvtServeur(pSource.getEnvtServeur());setAdresseIP(pSource.getAdresseIP());setTypeEntite(pSource.getTypeEntite());setRsin(pSource.getRsin());setIdEntiteAutre(pSource.getIdEntiteAutre());setCodeAntenne(pSource.getCodeAntenne());setDateCreation(pSource.getDateCreation());setDateTraitement(pSource.getDateTraitement());setHeureCreation(pSource.getHeureCreation());setCxala(pSource.getCxala());
  }
  
  public String toString()
  {
    StringBuffer s = new StringBuffer("[_ContexteService");
    subToString(s);
    s.append("]");
    return s.toString();
  }
  
  protected void subToString(StringBuffer pSource)
  {
    pSource.append(", IdFlux: ");
    pSource.append(m_idFlux);
    pSource.append(", ContexteEmission: ");
    pSource.append(m_contexteEmission);
    pSource.append(", SrcCodeAssedic: ");
    pSource.append(m_srcCodeAssedic);
    pSource.append(", SrcCodeApplication: ");
    pSource.append(m_srcCodeApplication);
    pSource.append(", SrcCodeDomaine: ");
    pSource.append(m_srcCodeDomaine);
    pSource.append(", SrcCodeProcessus: ");
    pSource.append(m_srcCodeProcessus);
    pSource.append(", SrcCodeTransaction: ");
    pSource.append(m_srcCodeTransaction);
    pSource.append(", SrcCodeProgramme: ");
    pSource.append(m_srcCodeProgramme);
    pSource.append(", SrcCodeAgent: ");
    pSource.append(m_srcCodeAgent);
    pSource.append(", DstCodeAssedic: ");
    pSource.append(m_dstCodeAssedic);
    pSource.append(", DstCodeApplication: ");
    pSource.append(m_dstCodeApplication);
    pSource.append(", DstCodeDomaine: ");
    pSource.append(m_dstCodeDomaine);
    pSource.append(", CodeActivite: ");
    pSource.append(m_codeActivite);
    pSource.append(", IdCourantTracker: ");
    pSource.append(m_idCourantTracker);
    pSource.append(", IdOrigineTracker: ");
    pSource.append(m_idOrigineTracker);
    pSource.append(", IdPrecedentTracker: ");
    pSource.append(m_idPrecedentTracker);
    pSource.append(", CodeFlux: ");
    pSource.append(m_codeFlux);
    pSource.append(", EnvtNature: ");
    pSource.append(m_envtNature);
    pSource.append(", EnvtBase: ");
    pSource.append(m_envtBase);
    pSource.append(", EnvtServeur: ");
    pSource.append(m_envtServeur);
    pSource.append(", AdresseIP: ");
    pSource.append(m_adresseIP);
    pSource.append(", TypeEntite: ");
    pSource.append(m_typeEntite);
    pSource.append(", Rsin: ");
    pSource.append(m_rsin);
    pSource.append(", IdEntiteAutre: ");
    pSource.append(m_idEntiteAutre);
    pSource.append(", CodeAntenne: ");
    pSource.append(m_codeAntenne);
    pSource.append(", DateCreation: ");
    pSource.append(m_dateCreation);
    pSource.append(", DateTraitement: ");
    pSource.append(m_dateTraitement);
    pSource.append(", HeureCreation: ");
    pSource.append(m_heureCreation);
    pSource.append(", Cxala: ");
    pSource.append(m_cxala);
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
    pHandler.property("IdFlux", getIdFlux(), new Attribute[] { new StringAttribute("C_ERR", getIdFlux_C_ERR()) });
    
    pHandler.property("ContexteEmission", getContexteEmission(), new Attribute[] { new StringAttribute("C_ERR", getContexteEmission_C_ERR()) });
    
    pHandler.property("SrcCodeAssedic", getSrcCodeAssedic(), new Attribute[] { new StringAttribute("C_ERR", getSrcCodeAssedic_C_ERR()) });
    
    pHandler.property("SrcCodeApplication", getSrcCodeApplication(), new Attribute[] { new StringAttribute("C_ERR", getSrcCodeApplication_C_ERR()) });
    
    pHandler.property("SrcCodeDomaine", getSrcCodeDomaine(), new Attribute[] { new StringAttribute("C_ERR", getSrcCodeDomaine_C_ERR()) });
    
    pHandler.property("SrcCodeProcessus", getSrcCodeProcessus(), new Attribute[] { new StringAttribute("C_ERR", getSrcCodeProcessus_C_ERR()) });
    
    pHandler.property("SrcCodeTransaction", getSrcCodeTransaction(), new Attribute[] { new StringAttribute("C_ERR", getSrcCodeTransaction_C_ERR()) });
    
    pHandler.property("SrcCodeProgramme", getSrcCodeProgramme(), new Attribute[] { new StringAttribute("C_ERR", getSrcCodeProgramme_C_ERR()) });
    
    pHandler.property("SrcCodeAgent", getSrcCodeAgent(), new Attribute[] { new StringAttribute("C_ERR", getSrcCodeAgent_C_ERR()) });
    
    pHandler.property("DstCodeAssedic", getDstCodeAssedic(), new Attribute[] { new StringAttribute("C_ERR", getDstCodeAssedic_C_ERR()) });
    
    pHandler.property("DstCodeApplication", getDstCodeApplication(), new Attribute[] { new StringAttribute("C_ERR", getDstCodeApplication_C_ERR()) });
    
    pHandler.property("DstCodeDomaine", getDstCodeDomaine(), new Attribute[] { new StringAttribute("C_ERR", getDstCodeDomaine_C_ERR()) });
    
    pHandler.property("CodeActivite", getCodeActivite(), new Attribute[] { new StringAttribute("C_ERR", getCodeActivite_C_ERR()) });
    
    pHandler.property("IdCourantTracker", getIdCourantTracker(), new Attribute[] { new StringAttribute("C_ERR", getIdCourantTracker_C_ERR()) });
    
    pHandler.property("IdOrigineTracker", getIdOrigineTracker(), new Attribute[] { new StringAttribute("C_ERR", getIdOrigineTracker_C_ERR()) });
    
    pHandler.property("IdPrecedentTracker", getIdPrecedentTracker(), new Attribute[] { new StringAttribute("C_ERR", getIdPrecedentTracker_C_ERR()) });
    
    pHandler.property("CodeFlux", getCodeFlux(), new Attribute[] { new StringAttribute("C_ERR", getCodeFlux_C_ERR()) });
    
    pHandler.property("EnvtNature", getEnvtNature(), new Attribute[] { new StringAttribute("C_ERR", getEnvtNature_C_ERR()) });
    
    pHandler.property("EnvtBase", getEnvtBase(), new Attribute[] { new StringAttribute("C_ERR", getEnvtBase_C_ERR()) });
    
    pHandler.property("EnvtServeur", getEnvtServeur(), new Attribute[] { new StringAttribute("C_ERR", getEnvtServeur_C_ERR()) });
    
    pHandler.property("AdresseIP", getAdresseIP(), new Attribute[] { new StringAttribute("C_ERR", getAdresseIP_C_ERR()) });
    
    pHandler.property("TypeEntite", getTypeEntite(), new Attribute[] { new StringAttribute("C_ERR", getTypeEntite_C_ERR()) });
    
    pHandler.property("Rsin", getRsin(), new Attribute[] { new StringAttribute("C_ERR", getRsin_C_ERR()) });
    
    pHandler.property("IdEntiteAutre", getIdEntiteAutre(), new Attribute[] { new StringAttribute("C_ERR", getIdEntiteAutre_C_ERR()) });
    
    pHandler.property("CodeAntenne", getCodeAntenne(), new Attribute[] { new StringAttribute("C_ERR", getCodeAntenne_C_ERR()) });
    
    pHandler.property("DateCreation", getDateCreation(), new Attribute[] { new StringAttribute("C_ERR", getDateCreation_C_ERR()) });
    
    pHandler.property("DateTraitement", getDateTraitement(), new Attribute[] { new StringAttribute("C_ERR", getDateTraitement_C_ERR()) });
    
    pHandler.property("HeureCreation", getHeureCreation(), new Attribute[] { new StringAttribute("C_ERR", getHeureCreation_C_ERR()) });
    
    pHandler.property("Cxala", getCxala(), new Attribute[] { new StringAttribute("C_ERR", getCxala_C_ERR()) });
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
    setIdFlux((String)pHandler.objectProperty("IdFlux", String.class));
    setIdFlux_C_ERR(pHandler.stringAttribute("IdFlux", "C_ERR"));
    
    setContexteEmission((String)pHandler.objectProperty("ContexteEmission", String.class));
    setContexteEmission_C_ERR(pHandler.stringAttribute("ContexteEmission", "C_ERR"));
    
    setSrcCodeAssedic((String)pHandler.objectProperty("SrcCodeAssedic", String.class));
    setSrcCodeAssedic_C_ERR(pHandler.stringAttribute("SrcCodeAssedic", "C_ERR"));
    
    setSrcCodeApplication((String)pHandler.objectProperty("SrcCodeApplication", String.class));
    setSrcCodeApplication_C_ERR(pHandler.stringAttribute("SrcCodeApplication", "C_ERR"));
    
    setSrcCodeDomaine((String)pHandler.objectProperty("SrcCodeDomaine", String.class));
    setSrcCodeDomaine_C_ERR(pHandler.stringAttribute("SrcCodeDomaine", "C_ERR"));
    
    setSrcCodeProcessus((String)pHandler.objectProperty("SrcCodeProcessus", String.class));
    setSrcCodeProcessus_C_ERR(pHandler.stringAttribute("SrcCodeProcessus", "C_ERR"));
    
    setSrcCodeTransaction((String)pHandler.objectProperty("SrcCodeTransaction", String.class));
    setSrcCodeTransaction_C_ERR(pHandler.stringAttribute("SrcCodeTransaction", "C_ERR"));
    
    setSrcCodeProgramme((String)pHandler.objectProperty("SrcCodeProgramme", String.class));
    setSrcCodeProgramme_C_ERR(pHandler.stringAttribute("SrcCodeProgramme", "C_ERR"));
    
    setSrcCodeAgent((String)pHandler.objectProperty("SrcCodeAgent", String.class));
    setSrcCodeAgent_C_ERR(pHandler.stringAttribute("SrcCodeAgent", "C_ERR"));
    
    setDstCodeAssedic((String)pHandler.objectProperty("DstCodeAssedic", String.class));
    setDstCodeAssedic_C_ERR(pHandler.stringAttribute("DstCodeAssedic", "C_ERR"));
    
    setDstCodeApplication((String)pHandler.objectProperty("DstCodeApplication", String.class));
    setDstCodeApplication_C_ERR(pHandler.stringAttribute("DstCodeApplication", "C_ERR"));
    
    setDstCodeDomaine((String)pHandler.objectProperty("DstCodeDomaine", String.class));
    setDstCodeDomaine_C_ERR(pHandler.stringAttribute("DstCodeDomaine", "C_ERR"));
    
    setCodeActivite((String)pHandler.objectProperty("CodeActivite", String.class));
    setCodeActivite_C_ERR(pHandler.stringAttribute("CodeActivite", "C_ERR"));
    
    setIdCourantTracker((String)pHandler.objectProperty("IdCourantTracker", String.class));
    setIdCourantTracker_C_ERR(pHandler.stringAttribute("IdCourantTracker", "C_ERR"));
    
    setIdOrigineTracker((String)pHandler.objectProperty("IdOrigineTracker", String.class));
    setIdOrigineTracker_C_ERR(pHandler.stringAttribute("IdOrigineTracker", "C_ERR"));
    
    setIdPrecedentTracker((String)pHandler.objectProperty("IdPrecedentTracker", String.class));
    setIdPrecedentTracker_C_ERR(pHandler.stringAttribute("IdPrecedentTracker", "C_ERR"));
    
    setCodeFlux((String)pHandler.objectProperty("CodeFlux", String.class));
    setCodeFlux_C_ERR(pHandler.stringAttribute("CodeFlux", "C_ERR"));
    
    setEnvtNature((String)pHandler.objectProperty("EnvtNature", String.class));
    setEnvtNature_C_ERR(pHandler.stringAttribute("EnvtNature", "C_ERR"));
    
    setEnvtBase((String)pHandler.objectProperty("EnvtBase", String.class));
    setEnvtBase_C_ERR(pHandler.stringAttribute("EnvtBase", "C_ERR"));
    
    setEnvtServeur((String)pHandler.objectProperty("EnvtServeur", String.class));
    setEnvtServeur_C_ERR(pHandler.stringAttribute("EnvtServeur", "C_ERR"));
    
    setAdresseIP((String)pHandler.objectProperty("AdresseIP", String.class));
    setAdresseIP_C_ERR(pHandler.stringAttribute("AdresseIP", "C_ERR"));
    
    setTypeEntite((String)pHandler.objectProperty("TypeEntite", String.class));
    setTypeEntite_C_ERR(pHandler.stringAttribute("TypeEntite", "C_ERR"));
    
    setRsin((String)pHandler.objectProperty("Rsin", String.class));
    setRsin_C_ERR(pHandler.stringAttribute("Rsin", "C_ERR"));
    
    setIdEntiteAutre((String)pHandler.objectProperty("IdEntiteAutre", String.class));
    setIdEntiteAutre_C_ERR(pHandler.stringAttribute("IdEntiteAutre", "C_ERR"));
    
    setCodeAntenne((String)pHandler.objectProperty("CodeAntenne", String.class));
    setCodeAntenne_C_ERR(pHandler.stringAttribute("CodeAntenne", "C_ERR"));
    
    setDateCreation((Damj)pHandler.objectProperty("DateCreation", Damj.class));
    setDateCreation_C_ERR(pHandler.stringAttribute("DateCreation", "C_ERR"));
    
    setDateTraitement((Damj)pHandler.objectProperty("DateTraitement", Damj.class));
    setDateTraitement_C_ERR(pHandler.stringAttribute("DateTraitement", "C_ERR"));
    
    setHeureCreation((Heure)pHandler.objectProperty("HeureCreation", Heure.class));
    setHeureCreation_C_ERR(pHandler.stringAttribute("HeureCreation", "C_ERR"));
    
    setCxala((BigDecimal)pHandler.objectProperty("Cxala", BigDecimal.class));
    setCxala_C_ERR(pHandler.stringAttribute("Cxala", "C_ERR"));
  }
  
  public String _getDatabeanName()
  {
    return "ContexteService";
  }
  
  public boolean _isValidProperty(String pElementName)
  {
    if ("IdFlux".equals(pElementName)) {
      return true;
    }
    if ("ContexteEmission".equals(pElementName)) {
      return true;
    }
    if ("SrcCodeAssedic".equals(pElementName)) {
      return true;
    }
    if ("SrcCodeApplication".equals(pElementName)) {
      return true;
    }
    if ("SrcCodeDomaine".equals(pElementName)) {
      return true;
    }
    if ("SrcCodeProcessus".equals(pElementName)) {
      return true;
    }
    if ("SrcCodeTransaction".equals(pElementName)) {
      return true;
    }
    if ("SrcCodeProgramme".equals(pElementName)) {
      return true;
    }
    if ("SrcCodeAgent".equals(pElementName)) {
      return true;
    }
    if ("DstCodeAssedic".equals(pElementName)) {
      return true;
    }
    if ("DstCodeApplication".equals(pElementName)) {
      return true;
    }
    if ("DstCodeDomaine".equals(pElementName)) {
      return true;
    }
    if ("CodeActivite".equals(pElementName)) {
      return true;
    }
    if ("IdCourantTracker".equals(pElementName)) {
      return true;
    }
    if ("IdOrigineTracker".equals(pElementName)) {
      return true;
    }
    if ("IdPrecedentTracker".equals(pElementName)) {
      return true;
    }
    if ("CodeFlux".equals(pElementName)) {
      return true;
    }
    if ("EnvtNature".equals(pElementName)) {
      return true;
    }
    if ("EnvtBase".equals(pElementName)) {
      return true;
    }
    if ("EnvtServeur".equals(pElementName)) {
      return true;
    }
    if ("AdresseIP".equals(pElementName)) {
      return true;
    }
    if ("TypeEntite".equals(pElementName)) {
      return true;
    }
    if ("Rsin".equals(pElementName)) {
      return true;
    }
    if ("IdEntiteAutre".equals(pElementName)) {
      return true;
    }
    if ("CodeAntenne".equals(pElementName)) {
      return true;
    }
    if ("DateCreation".equals(pElementName)) {
      return true;
    }
    if ("DateTraitement".equals(pElementName)) {
      return true;
    }
    if ("HeureCreation".equals(pElementName)) {
      return true;
    }
    if ("Cxala".equals(pElementName)) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _ContexteService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */