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

public class _Flux
  extends DataBeanImpl
  implements DataBean, Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  private String m__C_ETAT;
  private String m__IDENT;
  private _FluxCAF m_fluxCAF;
  private String m_fluxCAF_C_ERR;
  private _FluxETT m_fluxETT;
  private String m_fluxETT_C_ERR;
  private _FluxCSS m_fluxCSS;
  private String m_fluxCSS_C_ERR;
  private _FluxDSM m_fluxDSM;
  private String m_fluxDSM_C_ERR;
  private _FluxGUSO m_fluxGUSO;
  private String m_fluxGUSO_C_ERR;
  private _FluxCPAM m_fluxCPAM;
  private String m_fluxCPAM_C_ERR;
  private _FluxAEM m_fluxAEM;
  private String m_fluxAEM_C_ERR;
  private _FluxBS m_fluxBS;
  private String m_fluxBS_C_ERR;
  private _FluxPasDna m_fluxPasDna;
  private String m_fluxPasDna_C_ERR;
  private _FluxFctDna m_fluxFctDna;
  private String m_fluxFctDna_C_ERR;
  private _FluxCali m_fluxCali;
  private String m_fluxCali_C_ERR;
  private _FluxMSA m_fluxMSA;
  private String m_fluxMSA_C_ERR;
  private _FluxDMM m_fluxDMM;
  private String m_fluxDMM_C_ERR;
  private _FluxAE m_fluxAE;
  private String m_fluxAE_C_ERR;
  private String m_motifAnomalie;
  private String m_motifAnomalie_C_ERR;
  private String m_commentaire;
  private String m_commentaire_C_ERR;
  private String m_typeFlux;
  private String m_typeFlux_C_ERR;
  private String m_idFlux;
  private String m_idFlux_C_ERR;
  private String m_version;
  private String m_version_C_ERR;
  private String m_idTechPas;
  private String m_idTechPas_C_ERR;
  private String m_numeroContrat;
  private String m_numeroContrat_C_ERR;
  private Damj m_dateTraitement;
  private String m_dateTraitement_C_ERR;
  private Damj m_dateVisa;
  private String m_dateVisa_C_ERR;
  private Damj m_dateConnaissanceInfo;
  private String m_dateConnaissanceInfo_C_ERR;
  private BigDecimal m_indicateurOrigine;
  private String m_indicateurOrigine_C_ERR;
  private BigDecimal m_idPeriodeActivite;
  private String m_idPeriodeActivite_C_ERR;
  private _FluxDSN m_fluxDSN;
  private String m_fluxDSN_C_ERR;
  private _FluxCtPasDsn m_fluxCtPasDsn;
  private String m_fluxCtPasDsn_C_ERR;
  private _FluxPrimeIndemDsn m_fluxPrimeIndemDsn;
  private String m_fluxPrimeIndemDsn_C_ERR;
  private _FluxAbsenceFormation m_fluxAbsenceFormation;
  private String m_fluxAbsenceFormation_C_ERR;
  private _FluxPeriodeAbsenceFormation m_fluxPeriodeAbsenceFormation;
  private String m_fluxPeriodeAbsenceFormation_C_ERR;
  private _FluxCaliDeseng m_fluxCaliDeseng;
  private String m_fluxCaliDeseng_C_ERR;
  
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
  
  public _FluxCAF getFluxCAF()
  {
    return m_fluxCAF;
  }
  
  public String getFluxCAF_C_ERR()
  {
    return m_fluxCAF_C_ERR;
  }
  
  public void setFluxCAF(_FluxCAF pValeur)
  {
    m_fluxCAF = pValeur;
  }
  
  public void setFluxCAF_C_ERR(String pValeur_C_ERR)
  {
    m_fluxCAF_C_ERR = pValeur_C_ERR;
  }
  
  public _FluxETT getFluxETT()
  {
    return m_fluxETT;
  }
  
  public String getFluxETT_C_ERR()
  {
    return m_fluxETT_C_ERR;
  }
  
  public void setFluxETT(_FluxETT pValeur)
  {
    m_fluxETT = pValeur;
  }
  
  public void setFluxETT_C_ERR(String pValeur_C_ERR)
  {
    m_fluxETT_C_ERR = pValeur_C_ERR;
  }
  
  public _FluxCSS getFluxCSS()
  {
    return m_fluxCSS;
  }
  
  public String getFluxCSS_C_ERR()
  {
    return m_fluxCSS_C_ERR;
  }
  
  public void setFluxCSS(_FluxCSS pValeur)
  {
    m_fluxCSS = pValeur;
  }
  
  public void setFluxCSS_C_ERR(String pValeur_C_ERR)
  {
    m_fluxCSS_C_ERR = pValeur_C_ERR;
  }
  
  public _FluxDSM getFluxDSM()
  {
    return m_fluxDSM;
  }
  
  public String getFluxDSM_C_ERR()
  {
    return m_fluxDSM_C_ERR;
  }
  
  public void setFluxDSM(_FluxDSM pValeur)
  {
    m_fluxDSM = pValeur;
  }
  
  public void setFluxDSM_C_ERR(String pValeur_C_ERR)
  {
    m_fluxDSM_C_ERR = pValeur_C_ERR;
  }
  
  public _FluxGUSO getFluxGUSO()
  {
    return m_fluxGUSO;
  }
  
  public String getFluxGUSO_C_ERR()
  {
    return m_fluxGUSO_C_ERR;
  }
  
  public void setFluxGUSO(_FluxGUSO pValeur)
  {
    m_fluxGUSO = pValeur;
  }
  
  public void setFluxGUSO_C_ERR(String pValeur_C_ERR)
  {
    m_fluxGUSO_C_ERR = pValeur_C_ERR;
  }
  
  public _FluxCPAM getFluxCPAM()
  {
    return m_fluxCPAM;
  }
  
  public String getFluxCPAM_C_ERR()
  {
    return m_fluxCPAM_C_ERR;
  }
  
  public void setFluxCPAM(_FluxCPAM pValeur)
  {
    m_fluxCPAM = pValeur;
  }
  
  public void setFluxCPAM_C_ERR(String pValeur_C_ERR)
  {
    m_fluxCPAM_C_ERR = pValeur_C_ERR;
  }
  
  public _FluxAEM getFluxAEM()
  {
    return m_fluxAEM;
  }
  
  public String getFluxAEM_C_ERR()
  {
    return m_fluxAEM_C_ERR;
  }
  
  public void setFluxAEM(_FluxAEM pValeur)
  {
    m_fluxAEM = pValeur;
  }
  
  public void setFluxAEM_C_ERR(String pValeur_C_ERR)
  {
    m_fluxAEM_C_ERR = pValeur_C_ERR;
  }
  
  public _FluxBS getFluxBS()
  {
    return m_fluxBS;
  }
  
  public String getFluxBS_C_ERR()
  {
    return m_fluxBS_C_ERR;
  }
  
  public void setFluxBS(_FluxBS pValeur)
  {
    m_fluxBS = pValeur;
  }
  
  public void setFluxBS_C_ERR(String pValeur_C_ERR)
  {
    m_fluxBS_C_ERR = pValeur_C_ERR;
  }
  
  public _FluxPasDna getFluxPasDna()
  {
    return m_fluxPasDna;
  }
  
  public String getFluxPasDna_C_ERR()
  {
    return m_fluxPasDna_C_ERR;
  }
  
  public void setFluxPasDna(_FluxPasDna pValeur)
  {
    m_fluxPasDna = pValeur;
  }
  
  public void setFluxPasDna_C_ERR(String pValeur_C_ERR)
  {
    m_fluxPasDna_C_ERR = pValeur_C_ERR;
  }
  
  public _FluxFctDna getFluxFctDna()
  {
    return m_fluxFctDna;
  }
  
  public String getFluxFctDna_C_ERR()
  {
    return m_fluxFctDna_C_ERR;
  }
  
  public void setFluxFctDna(_FluxFctDna pValeur)
  {
    m_fluxFctDna = pValeur;
  }
  
  public void setFluxFctDna_C_ERR(String pValeur_C_ERR)
  {
    m_fluxFctDna_C_ERR = pValeur_C_ERR;
  }
  
  public _FluxCali getFluxCali()
  {
    return m_fluxCali;
  }
  
  public String getFluxCali_C_ERR()
  {
    return m_fluxCali_C_ERR;
  }
  
  public void setFluxCali(_FluxCali pValeur)
  {
    m_fluxCali = pValeur;
  }
  
  public void setFluxCali_C_ERR(String pValeur_C_ERR)
  {
    m_fluxCali_C_ERR = pValeur_C_ERR;
  }
  
  public _FluxMSA getFluxMSA()
  {
    return m_fluxMSA;
  }
  
  public String getFluxMSA_C_ERR()
  {
    return m_fluxMSA_C_ERR;
  }
  
  public void setFluxMSA(_FluxMSA pValeur)
  {
    m_fluxMSA = pValeur;
  }
  
  public void setFluxMSA_C_ERR(String pValeur_C_ERR)
  {
    m_fluxMSA_C_ERR = pValeur_C_ERR;
  }
  
  public _FluxDMM getFluxDMM()
  {
    return m_fluxDMM;
  }
  
  public String getFluxDMM_C_ERR()
  {
    return m_fluxDMM_C_ERR;
  }
  
  public void setFluxDMM(_FluxDMM pValeur)
  {
    m_fluxDMM = pValeur;
  }
  
  public void setFluxDMM_C_ERR(String pValeur_C_ERR)
  {
    m_fluxDMM_C_ERR = pValeur_C_ERR;
  }
  
  public _FluxAE getFluxAE()
  {
    return m_fluxAE;
  }
  
  public String getFluxAE_C_ERR()
  {
    return m_fluxAE_C_ERR;
  }
  
  public void setFluxAE(_FluxAE pValeur)
  {
    m_fluxAE = pValeur;
  }
  
  public void setFluxAE_C_ERR(String pValeur_C_ERR)
  {
    m_fluxAE_C_ERR = pValeur_C_ERR;
  }
  
  public String getMotifAnomalie()
  {
    return m_motifAnomalie;
  }
  
  public String getMotifAnomalie_C_ERR()
  {
    return m_motifAnomalie_C_ERR;
  }
  
  public void setMotifAnomalie(String pValeur)
  {
    m_motifAnomalie = pValeur;
  }
  
  public void setMotifAnomalie_C_ERR(String pValeur_C_ERR)
  {
    m_motifAnomalie_C_ERR = pValeur_C_ERR;
  }
  
  public String getCommentaire()
  {
    return m_commentaire;
  }
  
  public String getCommentaire_C_ERR()
  {
    return m_commentaire_C_ERR;
  }
  
  public void setCommentaire(String pValeur)
  {
    m_commentaire = pValeur;
  }
  
  public void setCommentaire_C_ERR(String pValeur_C_ERR)
  {
    m_commentaire_C_ERR = pValeur_C_ERR;
  }
  
  public String getTypeFlux()
  {
    return m_typeFlux;
  }
  
  public String getTypeFlux_C_ERR()
  {
    return m_typeFlux_C_ERR;
  }
  
  public void setTypeFlux(String pValeur)
  {
    m_typeFlux = pValeur;
  }
  
  public void setTypeFlux_C_ERR(String pValeur_C_ERR)
  {
    m_typeFlux_C_ERR = pValeur_C_ERR;
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
  
  public String getVersion()
  {
    return m_version;
  }
  
  public String getVersion_C_ERR()
  {
    return m_version_C_ERR;
  }
  
  public void setVersion(String pValeur)
  {
    m_version = pValeur;
  }
  
  public void setVersion_C_ERR(String pValeur_C_ERR)
  {
    m_version_C_ERR = pValeur_C_ERR;
  }
  
  public String getIdTechPas()
  {
    return m_idTechPas;
  }
  
  public String getIdTechPas_C_ERR()
  {
    return m_idTechPas_C_ERR;
  }
  
  public void setIdTechPas(String pValeur)
  {
    m_idTechPas = pValeur;
  }
  
  public void setIdTechPas_C_ERR(String pValeur_C_ERR)
  {
    m_idTechPas_C_ERR = pValeur_C_ERR;
  }
  
  public String getNumeroContrat()
  {
    return m_numeroContrat;
  }
  
  public String getNumeroContrat_C_ERR()
  {
    return m_numeroContrat_C_ERR;
  }
  
  public void setNumeroContrat(String pValeur)
  {
    m_numeroContrat = pValeur;
  }
  
  public void setNumeroContrat_C_ERR(String pValeur_C_ERR)
  {
    m_numeroContrat_C_ERR = pValeur_C_ERR;
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
  
  public Damj getDateVisa()
  {
    return m_dateVisa;
  }
  
  public String getDateVisa_C_ERR()
  {
    return m_dateVisa_C_ERR;
  }
  
  public void setDateVisa(Damj pValeur)
  {
    m_dateVisa = pValeur;
  }
  
  public void setDateVisa_C_ERR(String pValeur_C_ERR)
  {
    m_dateVisa_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDateConnaissanceInfo()
  {
    return m_dateConnaissanceInfo;
  }
  
  public String getDateConnaissanceInfo_C_ERR()
  {
    return m_dateConnaissanceInfo_C_ERR;
  }
  
  public void setDateConnaissanceInfo(Damj pValeur)
  {
    m_dateConnaissanceInfo = pValeur;
  }
  
  public void setDateConnaissanceInfo_C_ERR(String pValeur_C_ERR)
  {
    m_dateConnaissanceInfo_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getIndicateurOrigine()
  {
    return m_indicateurOrigine;
  }
  
  public String getIndicateurOrigine_C_ERR()
  {
    return m_indicateurOrigine_C_ERR;
  }
  
  public void setIndicateurOrigine(BigDecimal pValeur)
  {
    m_indicateurOrigine = pValeur;
  }
  
  public void setIndicateurOrigine_C_ERR(String pValeur_C_ERR)
  {
    m_indicateurOrigine_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getIdPeriodeActivite()
  {
    return m_idPeriodeActivite;
  }
  
  public String getIdPeriodeActivite_C_ERR()
  {
    return m_idPeriodeActivite_C_ERR;
  }
  
  public void setIdPeriodeActivite(BigDecimal pValeur)
  {
    m_idPeriodeActivite = pValeur;
  }
  
  public void setIdPeriodeActivite_C_ERR(String pValeur_C_ERR)
  {
    m_idPeriodeActivite_C_ERR = pValeur_C_ERR;
  }
  
  public _FluxDSN getFluxDSN()
  {
    return m_fluxDSN;
  }
  
  public String getFluxDSN_C_ERR()
  {
    return m_fluxDSN_C_ERR;
  }
  
  public void setFluxDSN(_FluxDSN pValeur)
  {
    m_fluxDSN = pValeur;
  }
  
  public void setFluxDSN_C_ERR(String pValeur_C_ERR)
  {
    m_fluxDSN_C_ERR = pValeur_C_ERR;
  }
  
  public _FluxCtPasDsn getFluxCtPasDsn()
  {
    return m_fluxCtPasDsn;
  }
  
  public String getFluxCtPasDsn_C_ERR()
  {
    return m_fluxCtPasDsn_C_ERR;
  }
  
  public void setFluxCtPasDsn(_FluxCtPasDsn pValeur)
  {
    m_fluxCtPasDsn = pValeur;
  }
  
  public void setFluxCtPasDsn_C_ERR(String pValeur_C_ERR)
  {
    m_fluxCtPasDsn_C_ERR = pValeur_C_ERR;
  }
  
  public _FluxPrimeIndemDsn getFluxPrimeIndemDsn()
  {
    return m_fluxPrimeIndemDsn;
  }
  
  public String getFluxPrimeIndemDsn_C_ERR()
  {
    return m_fluxPrimeIndemDsn_C_ERR;
  }
  
  public void setFluxPrimeIndemDsn(_FluxPrimeIndemDsn pValeur)
  {
    m_fluxPrimeIndemDsn = pValeur;
  }
  
  public void setFluxPrimeIndemDsn_C_ERR(String pValeur_C_ERR)
  {
    m_fluxPrimeIndemDsn_C_ERR = pValeur_C_ERR;
  }
  
  public _FluxAbsenceFormation getFluxAbsenceFormation()
  {
    return m_fluxAbsenceFormation;
  }
  
  public String getFluxAbsenceFormation_C_ERR()
  {
    return m_fluxAbsenceFormation_C_ERR;
  }
  
  public void setFluxAbsenceFormation(_FluxAbsenceFormation pValeur)
  {
    m_fluxAbsenceFormation = pValeur;
  }
  
  public void setFluxAbsenceFormation_C_ERR(String pValeur_C_ERR)
  {
    m_fluxAbsenceFormation_C_ERR = pValeur_C_ERR;
  }
  
  public _FluxPeriodeAbsenceFormation getFluxPeriodeAbsenceFormation()
  {
    return m_fluxPeriodeAbsenceFormation;
  }
  
  public String getFluxPeriodeAbsenceFormation_C_ERR()
  {
    return m_fluxPeriodeAbsenceFormation_C_ERR;
  }
  
  public void setFluxPeriodeAbsenceFormation(_FluxPeriodeAbsenceFormation pValeur)
  {
    m_fluxPeriodeAbsenceFormation = pValeur;
  }
  
  public void setFluxPeriodeAbsenceFormation_C_ERR(String pValeur_C_ERR)
  {
    m_fluxPeriodeAbsenceFormation_C_ERR = pValeur_C_ERR;
  }
  
  public _FluxCaliDeseng getFluxCaliDeseng()
  {
    return m_fluxCaliDeseng;
  }
  
  public String getFluxCaliDeseng_C_ERR()
  {
    return m_fluxCaliDeseng_C_ERR;
  }
  
  public void setFluxCaliDeseng(_FluxCaliDeseng pValeur)
  {
    m_fluxCaliDeseng = pValeur;
  }
  
  public void setFluxCaliDeseng_C_ERR(String pValeur_C_ERR)
  {
    m_fluxCaliDeseng_C_ERR = pValeur_C_ERR;
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
    if ("m_fluxCAF_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_fluxETT_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_fluxCSS_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_fluxDSM_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_fluxGUSO_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_fluxCPAM_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_fluxAEM_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_fluxBS_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_fluxPasDna_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_fluxFctDna_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_fluxCali_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_fluxMSA_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_fluxDMM_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_fluxAE_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_motifAnomalie_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_commentaire_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_typeFlux_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_idFlux_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_version_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_idTechPas_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_numeroContrat_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateTraitement_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateVisa_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateConnaissanceInfo_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_indicateurOrigine_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_idPeriodeActivite_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_fluxDSN_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_fluxCtPasDsn_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_fluxPrimeIndemDsn_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_fluxAbsenceFormation_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_fluxPeriodeAbsenceFormation_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_fluxCaliDeseng_C_ERR".equals(attrName)) {
      return String.class;
    }
    return null;
  }
  
  public PropertyInfo _getPropertyInfo(String pElementName)
    throws TechniqueException
  {
    if ("FluxCAF".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, _FluxCAF.class, false);
      return info;
    }
    if ("FluxETT".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, _FluxETT.class, false);
      return info;
    }
    if ("FluxCSS".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, _FluxCSS.class, false);
      return info;
    }
    if ("FluxDSM".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, _FluxDSM.class, false);
      return info;
    }
    if ("FluxGUSO".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, _FluxGUSO.class, false);
      return info;
    }
    if ("FluxCPAM".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, _FluxCPAM.class, false);
      return info;
    }
    if ("FluxAEM".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, _FluxAEM.class, false);
      return info;
    }
    if ("FluxBS".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, _FluxBS.class, false);
      return info;
    }
    if ("FluxPasDna".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, _FluxPasDna.class, false);
      return info;
    }
    if ("FluxFctDna".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, _FluxFctDna.class, false);
      return info;
    }
    if ("FluxCali".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, _FluxCali.class, false);
      return info;
    }
    if ("FluxMSA".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, _FluxMSA.class, false);
      return info;
    }
    if ("FluxDMM".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, _FluxDMM.class, false);
      return info;
    }
    if ("FluxAE".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, _FluxAE.class, false);
      return info;
    }
    if ("MotifAnomalie".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("Commentaire".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("TypeFlux".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("IdFlux".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("Version".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("IdTechPas".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("NumeroContrat".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("DateTraitement".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("DateVisa".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("DateConnaissanceInfo".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("IndicateurOrigine".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("IdPeriodeActivite".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("FluxDSN".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, _FluxDSN.class, false);
      return info;
    }
    if ("FluxCtPasDsn".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, _FluxCtPasDsn.class, false);
      return info;
    }
    if ("FluxPrimeIndemDsn".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, _FluxPrimeIndemDsn.class, false);
      return info;
    }
    if ("FluxAbsenceFormation".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, _FluxAbsenceFormation.class, false);
      return info;
    }
    if ("FluxPeriodeAbsenceFormation".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, _FluxPeriodeAbsenceFormation.class, false);
      return info;
    }
    if ("FluxCaliDeseng".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, _FluxCaliDeseng.class, false);
      return info;
    }
    return null;
  }
  
  public int _getPropertyLength(String pElementName)
  {
    if ("FluxCAF".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("FluxETT".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("FluxCSS".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("FluxDSM".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("FluxGUSO".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("FluxCPAM".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("FluxAEM".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("FluxBS".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("FluxPasDna".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("FluxFctDna".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("FluxCali".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("FluxMSA".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("FluxDMM".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("FluxAE".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("MotifAnomalie".equals(pElementName)) {
      return 100;
    }
    if ("Commentaire".equals(pElementName)) {
      return 60;
    }
    if ("TypeFlux".equals(pElementName)) {
      return 5;
    }
    if ("IdFlux".equals(pElementName)) {
      return 10;
    }
    if ("Version".equals(pElementName)) {
      return 5;
    }
    if ("IdTechPas".equals(pElementName)) {
      return 13;
    }
    if ("NumeroContrat".equals(pElementName)) {
      return 13;
    }
    if ("DateTraitement".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("DateVisa".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("DateConnaissanceInfo".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("IndicateurOrigine".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("IdPeriodeActivite".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("FluxDSN".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("FluxCtPasDsn".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("FluxPrimeIndemDsn".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("FluxAbsenceFormation".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("FluxPeriodeAbsenceFormation".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("FluxCaliDeseng".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    return -1;
  }
  
  public Object _getProperty(String pName)
    throws Exception
  {
    if ("FluxCAF".equals(pName)) {
      return m_fluxCAF;
    }
    if ("FluxETT".equals(pName)) {
      return m_fluxETT;
    }
    if ("FluxCSS".equals(pName)) {
      return m_fluxCSS;
    }
    if ("FluxDSM".equals(pName)) {
      return m_fluxDSM;
    }
    if ("FluxGUSO".equals(pName)) {
      return m_fluxGUSO;
    }
    if ("FluxCPAM".equals(pName)) {
      return m_fluxCPAM;
    }
    if ("FluxAEM".equals(pName)) {
      return m_fluxAEM;
    }
    if ("FluxBS".equals(pName)) {
      return m_fluxBS;
    }
    if ("FluxPasDna".equals(pName)) {
      return m_fluxPasDna;
    }
    if ("FluxFctDna".equals(pName)) {
      return m_fluxFctDna;
    }
    if ("FluxCali".equals(pName)) {
      return m_fluxCali;
    }
    if ("FluxMSA".equals(pName)) {
      return m_fluxMSA;
    }
    if ("FluxDMM".equals(pName)) {
      return m_fluxDMM;
    }
    if ("FluxAE".equals(pName)) {
      return m_fluxAE;
    }
    if ("MotifAnomalie".equals(pName)) {
      return m_motifAnomalie;
    }
    if ("Commentaire".equals(pName)) {
      return m_commentaire;
    }
    if ("TypeFlux".equals(pName)) {
      return m_typeFlux;
    }
    if ("IdFlux".equals(pName)) {
      return m_idFlux;
    }
    if ("Version".equals(pName)) {
      return m_version;
    }
    if ("IdTechPas".equals(pName)) {
      return m_idTechPas;
    }
    if ("NumeroContrat".equals(pName)) {
      return m_numeroContrat;
    }
    if ("DateTraitement".equals(pName)) {
      return m_dateTraitement;
    }
    if ("DateVisa".equals(pName)) {
      return m_dateVisa;
    }
    if ("DateConnaissanceInfo".equals(pName)) {
      return m_dateConnaissanceInfo;
    }
    if ("IndicateurOrigine".equals(pName)) {
      return m_indicateurOrigine;
    }
    if ("IdPeriodeActivite".equals(pName)) {
      return m_idPeriodeActivite;
    }
    if ("FluxDSN".equals(pName)) {
      return m_fluxDSN;
    }
    if ("FluxCtPasDsn".equals(pName)) {
      return m_fluxCtPasDsn;
    }
    if ("FluxPrimeIndemDsn".equals(pName)) {
      return m_fluxPrimeIndemDsn;
    }
    if ("FluxAbsenceFormation".equals(pName)) {
      return m_fluxAbsenceFormation;
    }
    if ("FluxPeriodeAbsenceFormation".equals(pName)) {
      return m_fluxPeriodeAbsenceFormation;
    }
    if ("FluxCaliDeseng".equals(pName)) {
      return m_fluxCaliDeseng;
    }
    return null;
  }
  
  public Iterator _getPropertyNames()
    throws Exception
  {
    ArrayList liste = new ArrayList();
    liste.add("FluxCAF");
    liste.add("FluxETT");
    liste.add("FluxCSS");
    liste.add("FluxDSM");
    liste.add("FluxGUSO");
    liste.add("FluxCPAM");
    liste.add("FluxAEM");
    liste.add("FluxBS");
    liste.add("FluxPasDna");
    liste.add("FluxFctDna");
    liste.add("FluxCali");
    liste.add("FluxMSA");
    liste.add("FluxDMM");
    liste.add("FluxAE");
    liste.add("MotifAnomalie");
    liste.add("Commentaire");
    liste.add("TypeFlux");
    liste.add("IdFlux");
    liste.add("Version");
    liste.add("IdTechPas");
    liste.add("NumeroContrat");
    liste.add("DateTraitement");
    liste.add("DateVisa");
    liste.add("DateConnaissanceInfo");
    liste.add("IndicateurOrigine");
    liste.add("IdPeriodeActivite");
    liste.add("FluxDSN");
    liste.add("FluxCtPasDsn");
    liste.add("FluxPrimeIndemDsn");
    liste.add("FluxAbsenceFormation");
    liste.add("FluxPeriodeAbsenceFormation");
    liste.add("FluxCaliDeseng");
    return liste.iterator();
  }
  
  public ArrayList _getPropertyNames(ArrayList pListe)
    throws Exception
  {
    pListe.add("FluxCAF");
    pListe.add("FluxETT");
    pListe.add("FluxCSS");
    pListe.add("FluxDSM");
    pListe.add("FluxGUSO");
    pListe.add("FluxCPAM");
    pListe.add("FluxAEM");
    pListe.add("FluxBS");
    pListe.add("FluxPasDna");
    pListe.add("FluxFctDna");
    pListe.add("FluxCali");
    pListe.add("FluxMSA");
    pListe.add("FluxDMM");
    pListe.add("FluxAE");
    pListe.add("MotifAnomalie");
    pListe.add("Commentaire");
    pListe.add("TypeFlux");
    pListe.add("IdFlux");
    pListe.add("Version");
    pListe.add("IdTechPas");
    pListe.add("NumeroContrat");
    pListe.add("DateTraitement");
    pListe.add("DateVisa");
    pListe.add("DateConnaissanceInfo");
    pListe.add("IndicateurOrigine");
    pListe.add("IdPeriodeActivite");
    pListe.add("FluxDSN");
    pListe.add("FluxCtPasDsn");
    pListe.add("FluxPrimeIndemDsn");
    pListe.add("FluxAbsenceFormation");
    pListe.add("FluxPeriodeAbsenceFormation");
    pListe.add("FluxCaliDeseng");
    return pListe;
  }
  
  public void _setProperty(String pName, Object pValeur)
    throws Exception
  {
    if ("FluxCAF".equals(pName)) {
      m_fluxCAF = ((_FluxCAF)pValeur);
    }
    if ("FluxETT".equals(pName)) {
      m_fluxETT = ((_FluxETT)pValeur);
    }
    if ("FluxCSS".equals(pName)) {
      m_fluxCSS = ((_FluxCSS)pValeur);
    }
    if ("FluxDSM".equals(pName)) {
      m_fluxDSM = ((_FluxDSM)pValeur);
    }
    if ("FluxGUSO".equals(pName)) {
      m_fluxGUSO = ((_FluxGUSO)pValeur);
    }
    if ("FluxCPAM".equals(pName)) {
      m_fluxCPAM = ((_FluxCPAM)pValeur);
    }
    if ("FluxAEM".equals(pName)) {
      m_fluxAEM = ((_FluxAEM)pValeur);
    }
    if ("FluxBS".equals(pName)) {
      m_fluxBS = ((_FluxBS)pValeur);
    }
    if ("FluxPasDna".equals(pName)) {
      m_fluxPasDna = ((_FluxPasDna)pValeur);
    }
    if ("FluxFctDna".equals(pName)) {
      m_fluxFctDna = ((_FluxFctDna)pValeur);
    }
    if ("FluxCali".equals(pName)) {
      m_fluxCali = ((_FluxCali)pValeur);
    }
    if ("FluxMSA".equals(pName)) {
      m_fluxMSA = ((_FluxMSA)pValeur);
    }
    if ("FluxDMM".equals(pName)) {
      m_fluxDMM = ((_FluxDMM)pValeur);
    }
    if ("FluxAE".equals(pName)) {
      m_fluxAE = ((_FluxAE)pValeur);
    }
    if ("MotifAnomalie".equals(pName)) {
      m_motifAnomalie = ((String)pValeur);
    }
    if ("Commentaire".equals(pName)) {
      m_commentaire = ((String)pValeur);
    }
    if ("TypeFlux".equals(pName)) {
      m_typeFlux = ((String)pValeur);
    }
    if ("IdFlux".equals(pName)) {
      m_idFlux = ((String)pValeur);
    }
    if ("Version".equals(pName)) {
      m_version = ((String)pValeur);
    }
    if ("IdTechPas".equals(pName)) {
      m_idTechPas = ((String)pValeur);
    }
    if ("NumeroContrat".equals(pName)) {
      m_numeroContrat = ((String)pValeur);
    }
    if ("DateTraitement".equals(pName)) {
      m_dateTraitement = ((Damj)pValeur);
    }
    if ("DateVisa".equals(pName)) {
      m_dateVisa = ((Damj)pValeur);
    }
    if ("DateConnaissanceInfo".equals(pName)) {
      m_dateConnaissanceInfo = ((Damj)pValeur);
    }
    if ("IndicateurOrigine".equals(pName)) {
      m_indicateurOrigine = ((BigDecimal)pValeur);
    }
    if ("IdPeriodeActivite".equals(pName)) {
      m_idPeriodeActivite = ((BigDecimal)pValeur);
    }
    if ("FluxDSN".equals(pName)) {
      m_fluxDSN = ((_FluxDSN)pValeur);
    }
    if ("FluxCtPasDsn".equals(pName)) {
      m_fluxCtPasDsn = ((_FluxCtPasDsn)pValeur);
    }
    if ("FluxPrimeIndemDsn".equals(pName)) {
      m_fluxPrimeIndemDsn = ((_FluxPrimeIndemDsn)pValeur);
    }
    if ("FluxAbsenceFormation".equals(pName)) {
      m_fluxAbsenceFormation = ((_FluxAbsenceFormation)pValeur);
    }
    if ("FluxPeriodeAbsenceFormation".equals(pName)) {
      m_fluxPeriodeAbsenceFormation = ((_FluxPeriodeAbsenceFormation)pValeur);
    }
    if ("FluxCaliDeseng".equals(pName)) {
      m_fluxCaliDeseng = ((_FluxCaliDeseng)pValeur);
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
    if ("m_fluxCAF_C_ERR".equals(attrName)) {
      m_fluxCAF_C_ERR = pValeur;
    }
    if ("m_fluxETT_C_ERR".equals(attrName)) {
      m_fluxETT_C_ERR = pValeur;
    }
    if ("m_fluxCSS_C_ERR".equals(attrName)) {
      m_fluxCSS_C_ERR = pValeur;
    }
    if ("m_fluxDSM_C_ERR".equals(attrName)) {
      m_fluxDSM_C_ERR = pValeur;
    }
    if ("m_fluxGUSO_C_ERR".equals(attrName)) {
      m_fluxGUSO_C_ERR = pValeur;
    }
    if ("m_fluxCPAM_C_ERR".equals(attrName)) {
      m_fluxCPAM_C_ERR = pValeur;
    }
    if ("m_fluxAEM_C_ERR".equals(attrName)) {
      m_fluxAEM_C_ERR = pValeur;
    }
    if ("m_fluxBS_C_ERR".equals(attrName)) {
      m_fluxBS_C_ERR = pValeur;
    }
    if ("m_fluxPasDna_C_ERR".equals(attrName)) {
      m_fluxPasDna_C_ERR = pValeur;
    }
    if ("m_fluxFctDna_C_ERR".equals(attrName)) {
      m_fluxFctDna_C_ERR = pValeur;
    }
    if ("m_fluxCali_C_ERR".equals(attrName)) {
      m_fluxCali_C_ERR = pValeur;
    }
    if ("m_fluxMSA_C_ERR".equals(attrName)) {
      m_fluxMSA_C_ERR = pValeur;
    }
    if ("m_fluxDMM_C_ERR".equals(attrName)) {
      m_fluxDMM_C_ERR = pValeur;
    }
    if ("m_fluxAE_C_ERR".equals(attrName)) {
      m_fluxAE_C_ERR = pValeur;
    }
    if ("m_motifAnomalie_C_ERR".equals(attrName)) {
      m_motifAnomalie_C_ERR = pValeur;
    }
    if ("m_commentaire_C_ERR".equals(attrName)) {
      m_commentaire_C_ERR = pValeur;
    }
    if ("m_typeFlux_C_ERR".equals(attrName)) {
      m_typeFlux_C_ERR = pValeur;
    }
    if ("m_idFlux_C_ERR".equals(attrName)) {
      m_idFlux_C_ERR = pValeur;
    }
    if ("m_version_C_ERR".equals(attrName)) {
      m_version_C_ERR = pValeur;
    }
    if ("m_idTechPas_C_ERR".equals(attrName)) {
      m_idTechPas_C_ERR = pValeur;
    }
    if ("m_numeroContrat_C_ERR".equals(attrName)) {
      m_numeroContrat_C_ERR = pValeur;
    }
    if ("m_dateTraitement_C_ERR".equals(attrName)) {
      m_dateTraitement_C_ERR = pValeur;
    }
    if ("m_dateVisa_C_ERR".equals(attrName)) {
      m_dateVisa_C_ERR = pValeur;
    }
    if ("m_dateConnaissanceInfo_C_ERR".equals(attrName)) {
      m_dateConnaissanceInfo_C_ERR = pValeur;
    }
    if ("m_indicateurOrigine_C_ERR".equals(attrName)) {
      m_indicateurOrigine_C_ERR = pValeur;
    }
    if ("m_idPeriodeActivite_C_ERR".equals(attrName)) {
      m_idPeriodeActivite_C_ERR = pValeur;
    }
    if ("m_fluxDSN_C_ERR".equals(attrName)) {
      m_fluxDSN_C_ERR = pValeur;
    }
    if ("m_fluxCtPasDsn_C_ERR".equals(attrName)) {
      m_fluxCtPasDsn_C_ERR = pValeur;
    }
    if ("m_fluxPrimeIndemDsn_C_ERR".equals(attrName)) {
      m_fluxPrimeIndemDsn_C_ERR = pValeur;
    }
    if ("m_fluxAbsenceFormation_C_ERR".equals(attrName)) {
      m_fluxAbsenceFormation_C_ERR = pValeur;
    }
    if ("m_fluxPeriodeAbsenceFormation_C_ERR".equals(attrName)) {
      m_fluxPeriodeAbsenceFormation_C_ERR = pValeur;
    }
    if ("m_fluxCaliDeseng_C_ERR".equals(attrName)) {
      m_fluxCaliDeseng_C_ERR = pValeur;
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
    if ("m_fluxCAF_C_ERR".equals(attrName)) {
      return m_fluxCAF_C_ERR;
    }
    if ("m_fluxETT_C_ERR".equals(attrName)) {
      return m_fluxETT_C_ERR;
    }
    if ("m_fluxCSS_C_ERR".equals(attrName)) {
      return m_fluxCSS_C_ERR;
    }
    if ("m_fluxDSM_C_ERR".equals(attrName)) {
      return m_fluxDSM_C_ERR;
    }
    if ("m_fluxGUSO_C_ERR".equals(attrName)) {
      return m_fluxGUSO_C_ERR;
    }
    if ("m_fluxCPAM_C_ERR".equals(attrName)) {
      return m_fluxCPAM_C_ERR;
    }
    if ("m_fluxAEM_C_ERR".equals(attrName)) {
      return m_fluxAEM_C_ERR;
    }
    if ("m_fluxBS_C_ERR".equals(attrName)) {
      return m_fluxBS_C_ERR;
    }
    if ("m_fluxPasDna_C_ERR".equals(attrName)) {
      return m_fluxPasDna_C_ERR;
    }
    if ("m_fluxFctDna_C_ERR".equals(attrName)) {
      return m_fluxFctDna_C_ERR;
    }
    if ("m_fluxCali_C_ERR".equals(attrName)) {
      return m_fluxCali_C_ERR;
    }
    if ("m_fluxMSA_C_ERR".equals(attrName)) {
      return m_fluxMSA_C_ERR;
    }
    if ("m_fluxDMM_C_ERR".equals(attrName)) {
      return m_fluxDMM_C_ERR;
    }
    if ("m_fluxAE_C_ERR".equals(attrName)) {
      return m_fluxAE_C_ERR;
    }
    if ("m_motifAnomalie_C_ERR".equals(attrName)) {
      return m_motifAnomalie_C_ERR;
    }
    if ("m_commentaire_C_ERR".equals(attrName)) {
      return m_commentaire_C_ERR;
    }
    if ("m_typeFlux_C_ERR".equals(attrName)) {
      return m_typeFlux_C_ERR;
    }
    if ("m_idFlux_C_ERR".equals(attrName)) {
      return m_idFlux_C_ERR;
    }
    if ("m_version_C_ERR".equals(attrName)) {
      return m_version_C_ERR;
    }
    if ("m_idTechPas_C_ERR".equals(attrName)) {
      return m_idTechPas_C_ERR;
    }
    if ("m_numeroContrat_C_ERR".equals(attrName)) {
      return m_numeroContrat_C_ERR;
    }
    if ("m_dateTraitement_C_ERR".equals(attrName)) {
      return m_dateTraitement_C_ERR;
    }
    if ("m_dateVisa_C_ERR".equals(attrName)) {
      return m_dateVisa_C_ERR;
    }
    if ("m_dateConnaissanceInfo_C_ERR".equals(attrName)) {
      return m_dateConnaissanceInfo_C_ERR;
    }
    if ("m_indicateurOrigine_C_ERR".equals(attrName)) {
      return m_indicateurOrigine_C_ERR;
    }
    if ("m_idPeriodeActivite_C_ERR".equals(attrName)) {
      return m_idPeriodeActivite_C_ERR;
    }
    if ("m_fluxDSN_C_ERR".equals(attrName)) {
      return m_fluxDSN_C_ERR;
    }
    if ("m_fluxCtPasDsn_C_ERR".equals(attrName)) {
      return m_fluxCtPasDsn_C_ERR;
    }
    if ("m_fluxPrimeIndemDsn_C_ERR".equals(attrName)) {
      return m_fluxPrimeIndemDsn_C_ERR;
    }
    if ("m_fluxAbsenceFormation_C_ERR".equals(attrName)) {
      return m_fluxAbsenceFormation_C_ERR;
    }
    if ("m_fluxPeriodeAbsenceFormation_C_ERR".equals(attrName)) {
      return m_fluxPeriodeAbsenceFormation_C_ERR;
    }
    if ("m_fluxCaliDeseng_C_ERR".equals(attrName)) {
      return m_fluxCaliDeseng_C_ERR;
    }
    return null;
  }
  
  public boolean equals(Object pObjet)
  {
    if (!(pObjet instanceof _Flux)) {
      return false;
    }
    _Flux x = (_Flux)pObjet;
    if (m_fluxCAF == null)
    {
      if (m_fluxCAF != null) {
        return false;
      }
    }
    else
    {
      if (m_fluxCAF == null) {
        return false;
      }
      if (!m_fluxCAF.equals(m_fluxCAF)) {
        return false;
      }
    }
    if (m_fluxETT == null)
    {
      if (m_fluxETT != null) {
        return false;
      }
    }
    else
    {
      if (m_fluxETT == null) {
        return false;
      }
      if (!m_fluxETT.equals(m_fluxETT)) {
        return false;
      }
    }
    if (m_fluxCSS == null)
    {
      if (m_fluxCSS != null) {
        return false;
      }
    }
    else
    {
      if (m_fluxCSS == null) {
        return false;
      }
      if (!m_fluxCSS.equals(m_fluxCSS)) {
        return false;
      }
    }
    if (m_fluxDSM == null)
    {
      if (m_fluxDSM != null) {
        return false;
      }
    }
    else
    {
      if (m_fluxDSM == null) {
        return false;
      }
      if (!m_fluxDSM.equals(m_fluxDSM)) {
        return false;
      }
    }
    if (m_fluxGUSO == null)
    {
      if (m_fluxGUSO != null) {
        return false;
      }
    }
    else
    {
      if (m_fluxGUSO == null) {
        return false;
      }
      if (!m_fluxGUSO.equals(m_fluxGUSO)) {
        return false;
      }
    }
    if (m_fluxCPAM == null)
    {
      if (m_fluxCPAM != null) {
        return false;
      }
    }
    else
    {
      if (m_fluxCPAM == null) {
        return false;
      }
      if (!m_fluxCPAM.equals(m_fluxCPAM)) {
        return false;
      }
    }
    if (m_fluxAEM == null)
    {
      if (m_fluxAEM != null) {
        return false;
      }
    }
    else
    {
      if (m_fluxAEM == null) {
        return false;
      }
      if (!m_fluxAEM.equals(m_fluxAEM)) {
        return false;
      }
    }
    if (m_fluxBS == null)
    {
      if (m_fluxBS != null) {
        return false;
      }
    }
    else
    {
      if (m_fluxBS == null) {
        return false;
      }
      if (!m_fluxBS.equals(m_fluxBS)) {
        return false;
      }
    }
    if (m_fluxPasDna == null)
    {
      if (m_fluxPasDna != null) {
        return false;
      }
    }
    else
    {
      if (m_fluxPasDna == null) {
        return false;
      }
      if (!m_fluxPasDna.equals(m_fluxPasDna)) {
        return false;
      }
    }
    if (m_fluxFctDna == null)
    {
      if (m_fluxFctDna != null) {
        return false;
      }
    }
    else
    {
      if (m_fluxFctDna == null) {
        return false;
      }
      if (!m_fluxFctDna.equals(m_fluxFctDna)) {
        return false;
      }
    }
    if (m_fluxCali == null)
    {
      if (m_fluxCali != null) {
        return false;
      }
    }
    else
    {
      if (m_fluxCali == null) {
        return false;
      }
      if (!m_fluxCali.equals(m_fluxCali)) {
        return false;
      }
    }
    if (m_fluxMSA == null)
    {
      if (m_fluxMSA != null) {
        return false;
      }
    }
    else
    {
      if (m_fluxMSA == null) {
        return false;
      }
      if (!m_fluxMSA.equals(m_fluxMSA)) {
        return false;
      }
    }
    if (m_fluxDMM == null)
    {
      if (m_fluxDMM != null) {
        return false;
      }
    }
    else
    {
      if (m_fluxDMM == null) {
        return false;
      }
      if (!m_fluxDMM.equals(m_fluxDMM)) {
        return false;
      }
    }
    if (m_fluxAE == null)
    {
      if (m_fluxAE != null) {
        return false;
      }
    }
    else
    {
      if (m_fluxAE == null) {
        return false;
      }
      if (!m_fluxAE.equals(m_fluxAE)) {
        return false;
      }
    }
    if (m_motifAnomalie == null)
    {
      if (m_motifAnomalie != null) {
        return false;
      }
    }
    else
    {
      if (m_motifAnomalie == null) {
        return false;
      }
      if (!m_motifAnomalie.equals(m_motifAnomalie)) {
        return false;
      }
    }
    if (m_commentaire == null)
    {
      if (m_commentaire != null) {
        return false;
      }
    }
    else
    {
      if (m_commentaire == null) {
        return false;
      }
      if (!m_commentaire.equals(m_commentaire)) {
        return false;
      }
    }
    if (m_typeFlux == null)
    {
      if (m_typeFlux != null) {
        return false;
      }
    }
    else
    {
      if (m_typeFlux == null) {
        return false;
      }
      if (!m_typeFlux.equals(m_typeFlux)) {
        return false;
      }
    }
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
    if (m_version == null)
    {
      if (m_version != null) {
        return false;
      }
    }
    else
    {
      if (m_version == null) {
        return false;
      }
      if (!m_version.equals(m_version)) {
        return false;
      }
    }
    if (m_idTechPas == null)
    {
      if (m_idTechPas != null) {
        return false;
      }
    }
    else
    {
      if (m_idTechPas == null) {
        return false;
      }
      if (!m_idTechPas.equals(m_idTechPas)) {
        return false;
      }
    }
    if (m_numeroContrat == null)
    {
      if (m_numeroContrat != null) {
        return false;
      }
    }
    else
    {
      if (m_numeroContrat == null) {
        return false;
      }
      if (!m_numeroContrat.equals(m_numeroContrat)) {
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
    if (m_dateVisa == null)
    {
      if (m_dateVisa != null) {
        return false;
      }
    }
    else
    {
      if (m_dateVisa == null) {
        return false;
      }
      if (!m_dateVisa.equals(m_dateVisa)) {
        return false;
      }
    }
    if (m_dateConnaissanceInfo == null)
    {
      if (m_dateConnaissanceInfo != null) {
        return false;
      }
    }
    else
    {
      if (m_dateConnaissanceInfo == null) {
        return false;
      }
      if (!m_dateConnaissanceInfo.equals(m_dateConnaissanceInfo)) {
        return false;
      }
    }
    if (m_indicateurOrigine == null)
    {
      if (m_indicateurOrigine != null) {
        return false;
      }
    }
    else
    {
      if (m_indicateurOrigine == null) {
        return false;
      }
      if (!m_indicateurOrigine.equals(m_indicateurOrigine)) {
        return false;
      }
    }
    if (m_idPeriodeActivite == null)
    {
      if (m_idPeriodeActivite != null) {
        return false;
      }
    }
    else
    {
      if (m_idPeriodeActivite == null) {
        return false;
      }
      if (!m_idPeriodeActivite.equals(m_idPeriodeActivite)) {
        return false;
      }
    }
    if (m_fluxDSN == null)
    {
      if (m_fluxDSN != null) {
        return false;
      }
    }
    else
    {
      if (m_fluxDSN == null) {
        return false;
      }
      if (!m_fluxDSN.equals(m_fluxDSN)) {
        return false;
      }
    }
    if (m_fluxCtPasDsn == null)
    {
      if (m_fluxCtPasDsn != null) {
        return false;
      }
    }
    else
    {
      if (m_fluxCtPasDsn == null) {
        return false;
      }
      if (!m_fluxCtPasDsn.equals(m_fluxCtPasDsn)) {
        return false;
      }
    }
    if (m_fluxPrimeIndemDsn == null)
    {
      if (m_fluxPrimeIndemDsn != null) {
        return false;
      }
    }
    else
    {
      if (m_fluxPrimeIndemDsn == null) {
        return false;
      }
      if (!m_fluxPrimeIndemDsn.equals(m_fluxPrimeIndemDsn)) {
        return false;
      }
    }
    if (m_fluxAbsenceFormation == null)
    {
      if (m_fluxAbsenceFormation != null) {
        return false;
      }
    }
    else
    {
      if (m_fluxAbsenceFormation == null) {
        return false;
      }
      if (!m_fluxAbsenceFormation.equals(m_fluxAbsenceFormation)) {
        return false;
      }
    }
    if (m_fluxPeriodeAbsenceFormation == null)
    {
      if (m_fluxPeriodeAbsenceFormation != null) {
        return false;
      }
    }
    else
    {
      if (m_fluxPeriodeAbsenceFormation == null) {
        return false;
      }
      if (!m_fluxPeriodeAbsenceFormation.equals(m_fluxPeriodeAbsenceFormation)) {
        return false;
      }
    }
    if (m_fluxCaliDeseng == null)
    {
      if (m_fluxCaliDeseng != null) {
        return false;
      }
    }
    else
    {
      if (m_fluxCaliDeseng == null) {
        return false;
      }
      if (!m_fluxCaliDeseng.equals(m_fluxCaliDeseng)) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int result = 0;
    if (m_fluxCAF != null) {
      result += m_fluxCAF.hashCode();
    }
    if (m_fluxETT != null) {
      result += m_fluxETT.hashCode();
    }
    if (m_fluxCSS != null) {
      result += m_fluxCSS.hashCode();
    }
    if (m_fluxDSM != null) {
      result += m_fluxDSM.hashCode();
    }
    if (m_fluxGUSO != null) {
      result += m_fluxGUSO.hashCode();
    }
    if (m_fluxCPAM != null) {
      result += m_fluxCPAM.hashCode();
    }
    if (m_fluxAEM != null) {
      result += m_fluxAEM.hashCode();
    }
    if (m_fluxBS != null) {
      result += m_fluxBS.hashCode();
    }
    if (m_fluxPasDna != null) {
      result += m_fluxPasDna.hashCode();
    }
    if (m_fluxFctDna != null) {
      result += m_fluxFctDna.hashCode();
    }
    if (m_fluxCali != null) {
      result += m_fluxCali.hashCode();
    }
    if (m_fluxMSA != null) {
      result += m_fluxMSA.hashCode();
    }
    if (m_fluxDMM != null) {
      result += m_fluxDMM.hashCode();
    }
    if (m_fluxAE != null) {
      result += m_fluxAE.hashCode();
    }
    if (m_motifAnomalie != null) {
      result += m_motifAnomalie.hashCode();
    }
    if (m_commentaire != null) {
      result += m_commentaire.hashCode();
    }
    if (m_typeFlux != null) {
      result += m_typeFlux.hashCode();
    }
    if (m_idFlux != null) {
      result += m_idFlux.hashCode();
    }
    if (m_version != null) {
      result += m_version.hashCode();
    }
    if (m_idTechPas != null) {
      result += m_idTechPas.hashCode();
    }
    if (m_numeroContrat != null) {
      result += m_numeroContrat.hashCode();
    }
    if (m_dateTraitement != null) {
      result += m_dateTraitement.hashCode();
    }
    if (m_dateVisa != null) {
      result += m_dateVisa.hashCode();
    }
    if (m_dateConnaissanceInfo != null) {
      result += m_dateConnaissanceInfo.hashCode();
    }
    if (m_indicateurOrigine != null) {
      result += m_indicateurOrigine.hashCode();
    }
    if (m_idPeriodeActivite != null) {
      result += m_idPeriodeActivite.hashCode();
    }
    if (m_fluxDSN != null) {
      result += m_fluxDSN.hashCode();
    }
    if (m_fluxCtPasDsn != null) {
      result += m_fluxCtPasDsn.hashCode();
    }
    if (m_fluxPrimeIndemDsn != null) {
      result += m_fluxPrimeIndemDsn.hashCode();
    }
    if (m_fluxAbsenceFormation != null) {
      result += m_fluxAbsenceFormation.hashCode();
    }
    if (m_fluxPeriodeAbsenceFormation != null) {
      result += m_fluxPeriodeAbsenceFormation.hashCode();
    }
    if (m_fluxCaliDeseng != null) {
      result += m_fluxCaliDeseng.hashCode();
    }
    result *= 17;
    return result;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    _Flux clone_Flux = new _Flux();
    clone_Flux.populateFrom_Flux(this);
    return clone_Flux;
  }
  
  public void populateFrom_Flux(_Flux pSource)
  {
    setFluxCAF(pSource.getFluxCAF());setFluxETT(pSource.getFluxETT());setFluxCSS(pSource.getFluxCSS());setFluxDSM(pSource.getFluxDSM());setFluxGUSO(pSource.getFluxGUSO());setFluxCPAM(pSource.getFluxCPAM());setFluxAEM(pSource.getFluxAEM());setFluxBS(pSource.getFluxBS());setFluxPasDna(pSource.getFluxPasDna());setFluxFctDna(pSource.getFluxFctDna());setFluxCali(pSource.getFluxCali());setFluxMSA(pSource.getFluxMSA());setFluxDMM(pSource.getFluxDMM());setFluxAE(pSource.getFluxAE());setMotifAnomalie(pSource.getMotifAnomalie());setCommentaire(pSource.getCommentaire());setTypeFlux(pSource.getTypeFlux());setIdFlux(pSource.getIdFlux());setVersion(pSource.getVersion());setIdTechPas(pSource.getIdTechPas());setNumeroContrat(pSource.getNumeroContrat());setDateTraitement(pSource.getDateTraitement());setDateVisa(pSource.getDateVisa());setDateConnaissanceInfo(pSource.getDateConnaissanceInfo());setIndicateurOrigine(pSource.getIndicateurOrigine());setIdPeriodeActivite(pSource.getIdPeriodeActivite());setFluxDSN(pSource.getFluxDSN());setFluxCtPasDsn(pSource.getFluxCtPasDsn());setFluxPrimeIndemDsn(pSource.getFluxPrimeIndemDsn());setFluxAbsenceFormation(pSource.getFluxAbsenceFormation());setFluxPeriodeAbsenceFormation(pSource.getFluxPeriodeAbsenceFormation());setFluxCaliDeseng(pSource.getFluxCaliDeseng());
  }
  
  public String toString()
  {
    StringBuffer s = new StringBuffer("[_Flux");
    subToString(s);
    s.append("]");
    return s.toString();
  }
  
  protected void subToString(StringBuffer pSource)
  {
    pSource.append(", FluxCAF: ");
    pSource.append(m_fluxCAF);
    pSource.append(", FluxETT: ");
    pSource.append(m_fluxETT);
    pSource.append(", FluxCSS: ");
    pSource.append(m_fluxCSS);
    pSource.append(", FluxDSM: ");
    pSource.append(m_fluxDSM);
    pSource.append(", FluxGUSO: ");
    pSource.append(m_fluxGUSO);
    pSource.append(", FluxCPAM: ");
    pSource.append(m_fluxCPAM);
    pSource.append(", FluxAEM: ");
    pSource.append(m_fluxAEM);
    pSource.append(", FluxBS: ");
    pSource.append(m_fluxBS);
    pSource.append(", FluxPasDna: ");
    pSource.append(m_fluxPasDna);
    pSource.append(", FluxFctDna: ");
    pSource.append(m_fluxFctDna);
    pSource.append(", FluxCali: ");
    pSource.append(m_fluxCali);
    pSource.append(", FluxMSA: ");
    pSource.append(m_fluxMSA);
    pSource.append(", FluxDMM: ");
    pSource.append(m_fluxDMM);
    pSource.append(", FluxAE: ");
    pSource.append(m_fluxAE);
    pSource.append(", MotifAnomalie: ");
    pSource.append(m_motifAnomalie);
    pSource.append(", Commentaire: ");
    pSource.append(m_commentaire);
    pSource.append(", TypeFlux: ");
    pSource.append(m_typeFlux);
    pSource.append(", IdFlux: ");
    pSource.append(m_idFlux);
    pSource.append(", Version: ");
    pSource.append(m_version);
    pSource.append(", IdTechPas: ");
    pSource.append(m_idTechPas);
    pSource.append(", NumeroContrat: ");
    pSource.append(m_numeroContrat);
    pSource.append(", DateTraitement: ");
    pSource.append(m_dateTraitement);
    pSource.append(", DateVisa: ");
    pSource.append(m_dateVisa);
    pSource.append(", DateConnaissanceInfo: ");
    pSource.append(m_dateConnaissanceInfo);
    pSource.append(", IndicateurOrigine: ");
    pSource.append(m_indicateurOrigine);
    pSource.append(", IdPeriodeActivite: ");
    pSource.append(m_idPeriodeActivite);
    pSource.append(", FluxDSN: ");
    pSource.append(m_fluxDSN);
    pSource.append(", FluxCtPasDsn: ");
    pSource.append(m_fluxCtPasDsn);
    pSource.append(", FluxPrimeIndemDsn: ");
    pSource.append(m_fluxPrimeIndemDsn);
    pSource.append(", FluxAbsenceFormation: ");
    pSource.append(m_fluxAbsenceFormation);
    pSource.append(", FluxPeriodeAbsenceFormation: ");
    pSource.append(m_fluxPeriodeAbsenceFormation);
    pSource.append(", FluxCaliDeseng: ");
    pSource.append(m_fluxCaliDeseng);
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
    DataBean FluxCAF_Value = getFluxCAF();
    GettersHandler FluxCAF_GettersHandler = pHandler.property("FluxCAF", FluxCAF_Value, new Attribute[] { new StringAttribute("C_ERR", getFluxCAF_C_ERR()) });
    if ((FluxCAF_GettersHandler != null) && (FluxCAF_Value != null)) {
      FluxCAF_Value.goThrough(FluxCAF_GettersHandler);
    }
    DataBean FluxETT_Value = getFluxETT();
    GettersHandler FluxETT_GettersHandler = pHandler.property("FluxETT", FluxETT_Value, new Attribute[] { new StringAttribute("C_ERR", getFluxETT_C_ERR()) });
    if ((FluxETT_GettersHandler != null) && (FluxETT_Value != null)) {
      FluxETT_Value.goThrough(FluxETT_GettersHandler);
    }
    DataBean FluxCSS_Value = getFluxCSS();
    GettersHandler FluxCSS_GettersHandler = pHandler.property("FluxCSS", FluxCSS_Value, new Attribute[] { new StringAttribute("C_ERR", getFluxCSS_C_ERR()) });
    if ((FluxCSS_GettersHandler != null) && (FluxCSS_Value != null)) {
      FluxCSS_Value.goThrough(FluxCSS_GettersHandler);
    }
    DataBean FluxDSM_Value = getFluxDSM();
    GettersHandler FluxDSM_GettersHandler = pHandler.property("FluxDSM", FluxDSM_Value, new Attribute[] { new StringAttribute("C_ERR", getFluxDSM_C_ERR()) });
    if ((FluxDSM_GettersHandler != null) && (FluxDSM_Value != null)) {
      FluxDSM_Value.goThrough(FluxDSM_GettersHandler);
    }
    DataBean FluxGUSO_Value = getFluxGUSO();
    GettersHandler FluxGUSO_GettersHandler = pHandler.property("FluxGUSO", FluxGUSO_Value, new Attribute[] { new StringAttribute("C_ERR", getFluxGUSO_C_ERR()) });
    if ((FluxGUSO_GettersHandler != null) && (FluxGUSO_Value != null)) {
      FluxGUSO_Value.goThrough(FluxGUSO_GettersHandler);
    }
    DataBean FluxCPAM_Value = getFluxCPAM();
    GettersHandler FluxCPAM_GettersHandler = pHandler.property("FluxCPAM", FluxCPAM_Value, new Attribute[] { new StringAttribute("C_ERR", getFluxCPAM_C_ERR()) });
    if ((FluxCPAM_GettersHandler != null) && (FluxCPAM_Value != null)) {
      FluxCPAM_Value.goThrough(FluxCPAM_GettersHandler);
    }
    DataBean FluxAEM_Value = getFluxAEM();
    GettersHandler FluxAEM_GettersHandler = pHandler.property("FluxAEM", FluxAEM_Value, new Attribute[] { new StringAttribute("C_ERR", getFluxAEM_C_ERR()) });
    if ((FluxAEM_GettersHandler != null) && (FluxAEM_Value != null)) {
      FluxAEM_Value.goThrough(FluxAEM_GettersHandler);
    }
    DataBean FluxBS_Value = getFluxBS();
    GettersHandler FluxBS_GettersHandler = pHandler.property("FluxBS", FluxBS_Value, new Attribute[] { new StringAttribute("C_ERR", getFluxBS_C_ERR()) });
    if ((FluxBS_GettersHandler != null) && (FluxBS_Value != null)) {
      FluxBS_Value.goThrough(FluxBS_GettersHandler);
    }
    DataBean FluxPasDna_Value = getFluxPasDna();
    GettersHandler FluxPasDna_GettersHandler = pHandler.property("FluxPasDna", FluxPasDna_Value, new Attribute[] { new StringAttribute("C_ERR", getFluxPasDna_C_ERR()) });
    if ((FluxPasDna_GettersHandler != null) && (FluxPasDna_Value != null)) {
      FluxPasDna_Value.goThrough(FluxPasDna_GettersHandler);
    }
    DataBean FluxFctDna_Value = getFluxFctDna();
    GettersHandler FluxFctDna_GettersHandler = pHandler.property("FluxFctDna", FluxFctDna_Value, new Attribute[] { new StringAttribute("C_ERR", getFluxFctDna_C_ERR()) });
    if ((FluxFctDna_GettersHandler != null) && (FluxFctDna_Value != null)) {
      FluxFctDna_Value.goThrough(FluxFctDna_GettersHandler);
    }
    DataBean FluxCali_Value = getFluxCali();
    GettersHandler FluxCali_GettersHandler = pHandler.property("FluxCali", FluxCali_Value, new Attribute[] { new StringAttribute("C_ERR", getFluxCali_C_ERR()) });
    if ((FluxCali_GettersHandler != null) && (FluxCali_Value != null)) {
      FluxCali_Value.goThrough(FluxCali_GettersHandler);
    }
    DataBean FluxMSA_Value = getFluxMSA();
    GettersHandler FluxMSA_GettersHandler = pHandler.property("FluxMSA", FluxMSA_Value, new Attribute[] { new StringAttribute("C_ERR", getFluxMSA_C_ERR()) });
    if ((FluxMSA_GettersHandler != null) && (FluxMSA_Value != null)) {
      FluxMSA_Value.goThrough(FluxMSA_GettersHandler);
    }
    DataBean FluxDMM_Value = getFluxDMM();
    GettersHandler FluxDMM_GettersHandler = pHandler.property("FluxDMM", FluxDMM_Value, new Attribute[] { new StringAttribute("C_ERR", getFluxDMM_C_ERR()) });
    if ((FluxDMM_GettersHandler != null) && (FluxDMM_Value != null)) {
      FluxDMM_Value.goThrough(FluxDMM_GettersHandler);
    }
    DataBean FluxAE_Value = getFluxAE();
    GettersHandler FluxAE_GettersHandler = pHandler.property("FluxAE", FluxAE_Value, new Attribute[] { new StringAttribute("C_ERR", getFluxAE_C_ERR()) });
    if ((FluxAE_GettersHandler != null) && (FluxAE_Value != null)) {
      FluxAE_Value.goThrough(FluxAE_GettersHandler);
    }
    pHandler.property("MotifAnomalie", getMotifAnomalie(), new Attribute[] { new StringAttribute("C_ERR", getMotifAnomalie_C_ERR()) });
    
    pHandler.property("Commentaire", getCommentaire(), new Attribute[] { new StringAttribute("C_ERR", getCommentaire_C_ERR()) });
    
    pHandler.property("TypeFlux", getTypeFlux(), new Attribute[] { new StringAttribute("C_ERR", getTypeFlux_C_ERR()) });
    
    pHandler.property("IdFlux", getIdFlux(), new Attribute[] { new StringAttribute("C_ERR", getIdFlux_C_ERR()) });
    
    pHandler.property("Version", getVersion(), new Attribute[] { new StringAttribute("C_ERR", getVersion_C_ERR()) });
    
    pHandler.property("IdTechPas", getIdTechPas(), new Attribute[] { new StringAttribute("C_ERR", getIdTechPas_C_ERR()) });
    
    pHandler.property("NumeroContrat", getNumeroContrat(), new Attribute[] { new StringAttribute("C_ERR", getNumeroContrat_C_ERR()) });
    
    pHandler.property("DateTraitement", getDateTraitement(), new Attribute[] { new StringAttribute("C_ERR", getDateTraitement_C_ERR()) });
    
    pHandler.property("DateVisa", getDateVisa(), new Attribute[] { new StringAttribute("C_ERR", getDateVisa_C_ERR()) });
    
    pHandler.property("DateConnaissanceInfo", getDateConnaissanceInfo(), new Attribute[] { new StringAttribute("C_ERR", getDateConnaissanceInfo_C_ERR()) });
    
    pHandler.property("IndicateurOrigine", getIndicateurOrigine(), new Attribute[] { new StringAttribute("C_ERR", getIndicateurOrigine_C_ERR()) });
    
    pHandler.property("IdPeriodeActivite", getIdPeriodeActivite(), new Attribute[] { new StringAttribute("C_ERR", getIdPeriodeActivite_C_ERR()) });
    
    DataBean FluxDSN_Value = getFluxDSN();
    GettersHandler FluxDSN_GettersHandler = pHandler.property("FluxDSN", FluxDSN_Value, new Attribute[] { new StringAttribute("C_ERR", getFluxDSN_C_ERR()) });
    if ((FluxDSN_GettersHandler != null) && (FluxDSN_Value != null)) {
      FluxDSN_Value.goThrough(FluxDSN_GettersHandler);
    }
    DataBean FluxCtPasDsn_Value = getFluxCtPasDsn();
    GettersHandler FluxCtPasDsn_GettersHandler = pHandler.property("FluxCtPasDsn", FluxCtPasDsn_Value, new Attribute[] { new StringAttribute("C_ERR", getFluxCtPasDsn_C_ERR()) });
    if ((FluxCtPasDsn_GettersHandler != null) && (FluxCtPasDsn_Value != null)) {
      FluxCtPasDsn_Value.goThrough(FluxCtPasDsn_GettersHandler);
    }
    DataBean FluxPrimeIndemDsn_Value = getFluxPrimeIndemDsn();
    GettersHandler FluxPrimeIndemDsn_GettersHandler = pHandler.property("FluxPrimeIndemDsn", FluxPrimeIndemDsn_Value, new Attribute[] { new StringAttribute("C_ERR", getFluxPrimeIndemDsn_C_ERR()) });
    if ((FluxPrimeIndemDsn_GettersHandler != null) && (FluxPrimeIndemDsn_Value != null)) {
      FluxPrimeIndemDsn_Value.goThrough(FluxPrimeIndemDsn_GettersHandler);
    }
    DataBean FluxAbsenceFormation_Value = getFluxAbsenceFormation();
    GettersHandler FluxAbsenceFormation_GettersHandler = pHandler.property("FluxAbsenceFormation", FluxAbsenceFormation_Value, new Attribute[] { new StringAttribute("C_ERR", getFluxAbsenceFormation_C_ERR()) });
    if ((FluxAbsenceFormation_GettersHandler != null) && (FluxAbsenceFormation_Value != null)) {
      FluxAbsenceFormation_Value.goThrough(FluxAbsenceFormation_GettersHandler);
    }
    DataBean FluxPeriodeAbsenceFormation_Value = getFluxPeriodeAbsenceFormation();
    GettersHandler FluxPeriodeAbsenceFormation_GettersHandler = pHandler.property("FluxPeriodeAbsenceFormation", FluxPeriodeAbsenceFormation_Value, new Attribute[] { new StringAttribute("C_ERR", getFluxPeriodeAbsenceFormation_C_ERR()) });
    if ((FluxPeriodeAbsenceFormation_GettersHandler != null) && (FluxPeriodeAbsenceFormation_Value != null)) {
      FluxPeriodeAbsenceFormation_Value.goThrough(FluxPeriodeAbsenceFormation_GettersHandler);
    }
    DataBean FluxCaliDeseng_Value = getFluxCaliDeseng();
    GettersHandler FluxCaliDeseng_GettersHandler = pHandler.property("FluxCaliDeseng", FluxCaliDeseng_Value, new Attribute[] { new StringAttribute("C_ERR", getFluxCaliDeseng_C_ERR()) });
    if ((FluxCaliDeseng_GettersHandler != null) && (FluxCaliDeseng_Value != null)) {
      FluxCaliDeseng_Value.goThrough(FluxCaliDeseng_GettersHandler);
    }
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
    setFluxCAF((_FluxCAF)pHandler.databeanProperty("FluxCAF", _FluxCAF.class));
    setFluxCAF_C_ERR(pHandler.stringAttribute("FluxCAF", "C_ERR"));
    setFluxETT((_FluxETT)pHandler.databeanProperty("FluxETT", _FluxETT.class));
    setFluxETT_C_ERR(pHandler.stringAttribute("FluxETT", "C_ERR"));
    setFluxCSS((_FluxCSS)pHandler.databeanProperty("FluxCSS", _FluxCSS.class));
    setFluxCSS_C_ERR(pHandler.stringAttribute("FluxCSS", "C_ERR"));
    setFluxDSM((_FluxDSM)pHandler.databeanProperty("FluxDSM", _FluxDSM.class));
    setFluxDSM_C_ERR(pHandler.stringAttribute("FluxDSM", "C_ERR"));
    setFluxGUSO((_FluxGUSO)pHandler.databeanProperty("FluxGUSO", _FluxGUSO.class));
    setFluxGUSO_C_ERR(pHandler.stringAttribute("FluxGUSO", "C_ERR"));
    setFluxCPAM((_FluxCPAM)pHandler.databeanProperty("FluxCPAM", _FluxCPAM.class));
    setFluxCPAM_C_ERR(pHandler.stringAttribute("FluxCPAM", "C_ERR"));
    setFluxAEM((_FluxAEM)pHandler.databeanProperty("FluxAEM", _FluxAEM.class));
    setFluxAEM_C_ERR(pHandler.stringAttribute("FluxAEM", "C_ERR"));
    setFluxBS((_FluxBS)pHandler.databeanProperty("FluxBS", _FluxBS.class));
    setFluxBS_C_ERR(pHandler.stringAttribute("FluxBS", "C_ERR"));
    setFluxPasDna((_FluxPasDna)pHandler.databeanProperty("FluxPasDna", _FluxPasDna.class));
    setFluxPasDna_C_ERR(pHandler.stringAttribute("FluxPasDna", "C_ERR"));
    setFluxFctDna((_FluxFctDna)pHandler.databeanProperty("FluxFctDna", _FluxFctDna.class));
    setFluxFctDna_C_ERR(pHandler.stringAttribute("FluxFctDna", "C_ERR"));
    setFluxCali((_FluxCali)pHandler.databeanProperty("FluxCali", _FluxCali.class));
    setFluxCali_C_ERR(pHandler.stringAttribute("FluxCali", "C_ERR"));
    setFluxMSA((_FluxMSA)pHandler.databeanProperty("FluxMSA", _FluxMSA.class));
    setFluxMSA_C_ERR(pHandler.stringAttribute("FluxMSA", "C_ERR"));
    setFluxDMM((_FluxDMM)pHandler.databeanProperty("FluxDMM", _FluxDMM.class));
    setFluxDMM_C_ERR(pHandler.stringAttribute("FluxDMM", "C_ERR"));
    setFluxAE((_FluxAE)pHandler.databeanProperty("FluxAE", _FluxAE.class));
    setFluxAE_C_ERR(pHandler.stringAttribute("FluxAE", "C_ERR"));
    setMotifAnomalie((String)pHandler.objectProperty("MotifAnomalie", String.class));
    setMotifAnomalie_C_ERR(pHandler.stringAttribute("MotifAnomalie", "C_ERR"));
    
    setCommentaire((String)pHandler.objectProperty("Commentaire", String.class));
    setCommentaire_C_ERR(pHandler.stringAttribute("Commentaire", "C_ERR"));
    
    setTypeFlux((String)pHandler.objectProperty("TypeFlux", String.class));
    setTypeFlux_C_ERR(pHandler.stringAttribute("TypeFlux", "C_ERR"));
    
    setIdFlux((String)pHandler.objectProperty("IdFlux", String.class));
    setIdFlux_C_ERR(pHandler.stringAttribute("IdFlux", "C_ERR"));
    
    setVersion((String)pHandler.objectProperty("Version", String.class));
    setVersion_C_ERR(pHandler.stringAttribute("Version", "C_ERR"));
    
    setIdTechPas((String)pHandler.objectProperty("IdTechPas", String.class));
    setIdTechPas_C_ERR(pHandler.stringAttribute("IdTechPas", "C_ERR"));
    
    setNumeroContrat((String)pHandler.objectProperty("NumeroContrat", String.class));
    setNumeroContrat_C_ERR(pHandler.stringAttribute("NumeroContrat", "C_ERR"));
    
    setDateTraitement((Damj)pHandler.objectProperty("DateTraitement", Damj.class));
    setDateTraitement_C_ERR(pHandler.stringAttribute("DateTraitement", "C_ERR"));
    
    setDateVisa((Damj)pHandler.objectProperty("DateVisa", Damj.class));
    setDateVisa_C_ERR(pHandler.stringAttribute("DateVisa", "C_ERR"));
    
    setDateConnaissanceInfo((Damj)pHandler.objectProperty("DateConnaissanceInfo", Damj.class));
    setDateConnaissanceInfo_C_ERR(pHandler.stringAttribute("DateConnaissanceInfo", "C_ERR"));
    
    setIndicateurOrigine((BigDecimal)pHandler.objectProperty("IndicateurOrigine", BigDecimal.class));
    setIndicateurOrigine_C_ERR(pHandler.stringAttribute("IndicateurOrigine", "C_ERR"));
    
    setIdPeriodeActivite((BigDecimal)pHandler.objectProperty("IdPeriodeActivite", BigDecimal.class));
    setIdPeriodeActivite_C_ERR(pHandler.stringAttribute("IdPeriodeActivite", "C_ERR"));
    
    setFluxDSN((_FluxDSN)pHandler.databeanProperty("FluxDSN", _FluxDSN.class));
    setFluxDSN_C_ERR(pHandler.stringAttribute("FluxDSN", "C_ERR"));
    setFluxCtPasDsn((_FluxCtPasDsn)pHandler.databeanProperty("FluxCtPasDsn", _FluxCtPasDsn.class));
    setFluxCtPasDsn_C_ERR(pHandler.stringAttribute("FluxCtPasDsn", "C_ERR"));
    setFluxPrimeIndemDsn((_FluxPrimeIndemDsn)pHandler.databeanProperty("FluxPrimeIndemDsn", _FluxPrimeIndemDsn.class));
    setFluxPrimeIndemDsn_C_ERR(pHandler.stringAttribute("FluxPrimeIndemDsn", "C_ERR"));
    setFluxAbsenceFormation((_FluxAbsenceFormation)pHandler.databeanProperty("FluxAbsenceFormation", _FluxAbsenceFormation.class));
    setFluxAbsenceFormation_C_ERR(pHandler.stringAttribute("FluxAbsenceFormation", "C_ERR"));
    setFluxPeriodeAbsenceFormation((_FluxPeriodeAbsenceFormation)pHandler.databeanProperty("FluxPeriodeAbsenceFormation", _FluxPeriodeAbsenceFormation.class));
    setFluxPeriodeAbsenceFormation_C_ERR(pHandler.stringAttribute("FluxPeriodeAbsenceFormation", "C_ERR"));
    setFluxCaliDeseng((_FluxCaliDeseng)pHandler.databeanProperty("FluxCaliDeseng", _FluxCaliDeseng.class));
    setFluxCaliDeseng_C_ERR(pHandler.stringAttribute("FluxCaliDeseng", "C_ERR"));
  }
  
  public String _getDatabeanName()
  {
    return "Flux";
  }
  
  public boolean _isValidProperty(String pElementName)
  {
    if ("FluxCAF".equals(pElementName)) {
      return true;
    }
    if ("FluxETT".equals(pElementName)) {
      return true;
    }
    if ("FluxCSS".equals(pElementName)) {
      return true;
    }
    if ("FluxDSM".equals(pElementName)) {
      return true;
    }
    if ("FluxGUSO".equals(pElementName)) {
      return true;
    }
    if ("FluxCPAM".equals(pElementName)) {
      return true;
    }
    if ("FluxAEM".equals(pElementName)) {
      return true;
    }
    if ("FluxBS".equals(pElementName)) {
      return true;
    }
    if ("FluxPasDna".equals(pElementName)) {
      return true;
    }
    if ("FluxFctDna".equals(pElementName)) {
      return true;
    }
    if ("FluxCali".equals(pElementName)) {
      return true;
    }
    if ("FluxMSA".equals(pElementName)) {
      return true;
    }
    if ("FluxDMM".equals(pElementName)) {
      return true;
    }
    if ("FluxAE".equals(pElementName)) {
      return true;
    }
    if ("MotifAnomalie".equals(pElementName)) {
      return true;
    }
    if ("Commentaire".equals(pElementName)) {
      return true;
    }
    if ("TypeFlux".equals(pElementName)) {
      return true;
    }
    if ("IdFlux".equals(pElementName)) {
      return true;
    }
    if ("Version".equals(pElementName)) {
      return true;
    }
    if ("IdTechPas".equals(pElementName)) {
      return true;
    }
    if ("NumeroContrat".equals(pElementName)) {
      return true;
    }
    if ("DateTraitement".equals(pElementName)) {
      return true;
    }
    if ("DateVisa".equals(pElementName)) {
      return true;
    }
    if ("DateConnaissanceInfo".equals(pElementName)) {
      return true;
    }
    if ("IndicateurOrigine".equals(pElementName)) {
      return true;
    }
    if ("IdPeriodeActivite".equals(pElementName)) {
      return true;
    }
    if ("FluxDSN".equals(pElementName)) {
      return true;
    }
    if ("FluxCtPasDsn".equals(pElementName)) {
      return true;
    }
    if ("FluxPrimeIndemDsn".equals(pElementName)) {
      return true;
    }
    if ("FluxAbsenceFormation".equals(pElementName)) {
      return true;
    }
    if ("FluxPeriodeAbsenceFormation".equals(pElementName)) {
      return true;
    }
    if ("FluxCaliDeseng".equals(pElementName)) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _Flux
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */