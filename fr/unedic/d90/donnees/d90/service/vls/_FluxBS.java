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

public class _FluxBS
  extends DataBeanImpl
  implements DataBean, Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  private String m__C_ETAT;
  private String m__IDENT;
  private String m_bneIdentifiantBne;
  private String m_bneIdentifiantBne_C_ERR;
  private String m_bneSiret;
  private String m_bneSiret_C_ERR;
  private String m_bneRaisonSociale;
  private String m_bneRaisonSociale_C_ERR;
  private String m_bneNumeroVoirie;
  private String m_bneNumeroVoirie_C_ERR;
  private String m_bneLibelleVoieAdresse;
  private String m_bneLibelleVoieAdresse_C_ERR;
  private String m_bneComplAdresse;
  private String m_bneComplAdresse_C_ERR;
  private String m_bneCodePostal;
  private String m_bneCodePostal_C_ERR;
  private String m_bneLibelleCommune;
  private String m_bneLibelleCommune_C_ERR;
  private String m_bneAssedicAffiliation;
  private String m_bneAssedicAffiliation_C_ERR;
  private String m_bneNumAffiliation;
  private String m_bneNumAffiliation_C_ERR;
  private String m_codeAssedic;
  private String m_codeAssedic_C_ERR;
  private String m_NIR;
  private String m_NIR_C_ERR;
  private String m_typeEnregistrement;
  private String m_typeEnregistrement_C_ERR;
  private String m_codeMonnaieSalaire;
  private String m_codeMonnaieSalaire_C_ERR;
  private String m_codeIntermittent;
  private String m_codeIntermittent_C_ERR;
  private String m_referenceEmployeur;
  private String m_referenceEmployeur_C_ERR;
  private String m_codePostalEmployeur;
  private String m_codePostalEmployeur_C_ERR;
  private String m_codeInformationEmployeur;
  private String m_codeInformationEmployeur_C_ERR;
  private String m_cocheAlsaceMoselle;
  private String m_cocheAlsaceMoselle_C_ERR;
  private String m_uniteTravail;
  private String m_uniteTravail_C_ERR;
  private String m_situationParticuliere;
  private String m_situationParticuliere_C_ERR;
  private Damj m_dateDebutPeriode;
  private String m_dateDebutPeriode_C_ERR;
  private Damj m_dateFinPeriode;
  private String m_dateFinPeriode_C_ERR;
  private Damj m_dateFichierExterne;
  private String m_dateFichierExterne_C_ERR;
  private Damj m_dateSignature;
  private String m_dateSignature_C_ERR;
  private BigDecimal m_salaireBrutAbattu;
  private String m_salaireBrutAbattu_C_ERR;
  private BigDecimal m_prime;
  private String m_prime_C_ERR;
  private BigDecimal m_montantIFMIPE;
  private String m_montantIFMIPE_C_ERR;
  private BigDecimal m_montantICCP;
  private String m_montantICCP_C_ERR;
  private BigDecimal m_salaireNet;
  private String m_salaireNet_C_ERR;
  private BigDecimal m_qteTravail;
  private String m_qteTravail_C_ERR;
  private BigDecimal m_montantPrecompteAC;
  private String m_montantPrecompteAC_C_ERR;
  private String m_idDocumentNumerique;
  private String m_idDocumentNumerique_C_ERR;
  
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
  
  public String getBneIdentifiantBne()
  {
    return m_bneIdentifiantBne;
  }
  
  public String getBneIdentifiantBne_C_ERR()
  {
    return m_bneIdentifiantBne_C_ERR;
  }
  
  public void setBneIdentifiantBne(String pValeur)
  {
    m_bneIdentifiantBne = pValeur;
  }
  
  public void setBneIdentifiantBne_C_ERR(String pValeur_C_ERR)
  {
    m_bneIdentifiantBne_C_ERR = pValeur_C_ERR;
  }
  
  public String getBneSiret()
  {
    return m_bneSiret;
  }
  
  public String getBneSiret_C_ERR()
  {
    return m_bneSiret_C_ERR;
  }
  
  public void setBneSiret(String pValeur)
  {
    m_bneSiret = pValeur;
  }
  
  public void setBneSiret_C_ERR(String pValeur_C_ERR)
  {
    m_bneSiret_C_ERR = pValeur_C_ERR;
  }
  
  public String getBneRaisonSociale()
  {
    return m_bneRaisonSociale;
  }
  
  public String getBneRaisonSociale_C_ERR()
  {
    return m_bneRaisonSociale_C_ERR;
  }
  
  public void setBneRaisonSociale(String pValeur)
  {
    m_bneRaisonSociale = pValeur;
  }
  
  public void setBneRaisonSociale_C_ERR(String pValeur_C_ERR)
  {
    m_bneRaisonSociale_C_ERR = pValeur_C_ERR;
  }
  
  public String getBneNumeroVoirie()
  {
    return m_bneNumeroVoirie;
  }
  
  public String getBneNumeroVoirie_C_ERR()
  {
    return m_bneNumeroVoirie_C_ERR;
  }
  
  public void setBneNumeroVoirie(String pValeur)
  {
    m_bneNumeroVoirie = pValeur;
  }
  
  public void setBneNumeroVoirie_C_ERR(String pValeur_C_ERR)
  {
    m_bneNumeroVoirie_C_ERR = pValeur_C_ERR;
  }
  
  public String getBneLibelleVoieAdresse()
  {
    return m_bneLibelleVoieAdresse;
  }
  
  public String getBneLibelleVoieAdresse_C_ERR()
  {
    return m_bneLibelleVoieAdresse_C_ERR;
  }
  
  public void setBneLibelleVoieAdresse(String pValeur)
  {
    m_bneLibelleVoieAdresse = pValeur;
  }
  
  public void setBneLibelleVoieAdresse_C_ERR(String pValeur_C_ERR)
  {
    m_bneLibelleVoieAdresse_C_ERR = pValeur_C_ERR;
  }
  
  public String getBneComplAdresse()
  {
    return m_bneComplAdresse;
  }
  
  public String getBneComplAdresse_C_ERR()
  {
    return m_bneComplAdresse_C_ERR;
  }
  
  public void setBneComplAdresse(String pValeur)
  {
    m_bneComplAdresse = pValeur;
  }
  
  public void setBneComplAdresse_C_ERR(String pValeur_C_ERR)
  {
    m_bneComplAdresse_C_ERR = pValeur_C_ERR;
  }
  
  public String getBneCodePostal()
  {
    return m_bneCodePostal;
  }
  
  public String getBneCodePostal_C_ERR()
  {
    return m_bneCodePostal_C_ERR;
  }
  
  public void setBneCodePostal(String pValeur)
  {
    m_bneCodePostal = pValeur;
  }
  
  public void setBneCodePostal_C_ERR(String pValeur_C_ERR)
  {
    m_bneCodePostal_C_ERR = pValeur_C_ERR;
  }
  
  public String getBneLibelleCommune()
  {
    return m_bneLibelleCommune;
  }
  
  public String getBneLibelleCommune_C_ERR()
  {
    return m_bneLibelleCommune_C_ERR;
  }
  
  public void setBneLibelleCommune(String pValeur)
  {
    m_bneLibelleCommune = pValeur;
  }
  
  public void setBneLibelleCommune_C_ERR(String pValeur_C_ERR)
  {
    m_bneLibelleCommune_C_ERR = pValeur_C_ERR;
  }
  
  public String getBneAssedicAffiliation()
  {
    return m_bneAssedicAffiliation;
  }
  
  public String getBneAssedicAffiliation_C_ERR()
  {
    return m_bneAssedicAffiliation_C_ERR;
  }
  
  public void setBneAssedicAffiliation(String pValeur)
  {
    m_bneAssedicAffiliation = pValeur;
  }
  
  public void setBneAssedicAffiliation_C_ERR(String pValeur_C_ERR)
  {
    m_bneAssedicAffiliation_C_ERR = pValeur_C_ERR;
  }
  
  public String getBneNumAffiliation()
  {
    return m_bneNumAffiliation;
  }
  
  public String getBneNumAffiliation_C_ERR()
  {
    return m_bneNumAffiliation_C_ERR;
  }
  
  public void setBneNumAffiliation(String pValeur)
  {
    m_bneNumAffiliation = pValeur;
  }
  
  public void setBneNumAffiliation_C_ERR(String pValeur_C_ERR)
  {
    m_bneNumAffiliation_C_ERR = pValeur_C_ERR;
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
  
  public String getCodeMonnaieSalaire()
  {
    return m_codeMonnaieSalaire;
  }
  
  public String getCodeMonnaieSalaire_C_ERR()
  {
    return m_codeMonnaieSalaire_C_ERR;
  }
  
  public void setCodeMonnaieSalaire(String pValeur)
  {
    m_codeMonnaieSalaire = pValeur;
  }
  
  public void setCodeMonnaieSalaire_C_ERR(String pValeur_C_ERR)
  {
    m_codeMonnaieSalaire_C_ERR = pValeur_C_ERR;
  }
  
  public String getCodeIntermittent()
  {
    return m_codeIntermittent;
  }
  
  public String getCodeIntermittent_C_ERR()
  {
    return m_codeIntermittent_C_ERR;
  }
  
  public void setCodeIntermittent(String pValeur)
  {
    m_codeIntermittent = pValeur;
  }
  
  public void setCodeIntermittent_C_ERR(String pValeur_C_ERR)
  {
    m_codeIntermittent_C_ERR = pValeur_C_ERR;
  }
  
  public String getReferenceEmployeur()
  {
    return m_referenceEmployeur;
  }
  
  public String getReferenceEmployeur_C_ERR()
  {
    return m_referenceEmployeur_C_ERR;
  }
  
  public void setReferenceEmployeur(String pValeur)
  {
    m_referenceEmployeur = pValeur;
  }
  
  public void setReferenceEmployeur_C_ERR(String pValeur_C_ERR)
  {
    m_referenceEmployeur_C_ERR = pValeur_C_ERR;
  }
  
  public String getCodePostalEmployeur()
  {
    return m_codePostalEmployeur;
  }
  
  public String getCodePostalEmployeur_C_ERR()
  {
    return m_codePostalEmployeur_C_ERR;
  }
  
  public void setCodePostalEmployeur(String pValeur)
  {
    m_codePostalEmployeur = pValeur;
  }
  
  public void setCodePostalEmployeur_C_ERR(String pValeur_C_ERR)
  {
    m_codePostalEmployeur_C_ERR = pValeur_C_ERR;
  }
  
  public String getCodeInformationEmployeur()
  {
    return m_codeInformationEmployeur;
  }
  
  public String getCodeInformationEmployeur_C_ERR()
  {
    return m_codeInformationEmployeur_C_ERR;
  }
  
  public void setCodeInformationEmployeur(String pValeur)
  {
    m_codeInformationEmployeur = pValeur;
  }
  
  public void setCodeInformationEmployeur_C_ERR(String pValeur_C_ERR)
  {
    m_codeInformationEmployeur_C_ERR = pValeur_C_ERR;
  }
  
  public String getCocheAlsaceMoselle()
  {
    return m_cocheAlsaceMoselle;
  }
  
  public String getCocheAlsaceMoselle_C_ERR()
  {
    return m_cocheAlsaceMoselle_C_ERR;
  }
  
  public void setCocheAlsaceMoselle(String pValeur)
  {
    m_cocheAlsaceMoselle = pValeur;
  }
  
  public void setCocheAlsaceMoselle_C_ERR(String pValeur_C_ERR)
  {
    m_cocheAlsaceMoselle_C_ERR = pValeur_C_ERR;
  }
  
  public String getUniteTravail()
  {
    return m_uniteTravail;
  }
  
  public String getUniteTravail_C_ERR()
  {
    return m_uniteTravail_C_ERR;
  }
  
  public void setUniteTravail(String pValeur)
  {
    m_uniteTravail = pValeur;
  }
  
  public void setUniteTravail_C_ERR(String pValeur_C_ERR)
  {
    m_uniteTravail_C_ERR = pValeur_C_ERR;
  }
  
  public String getSituationParticuliere()
  {
    return m_situationParticuliere;
  }
  
  public String getSituationParticuliere_C_ERR()
  {
    return m_situationParticuliere_C_ERR;
  }
  
  public void setSituationParticuliere(String pValeur)
  {
    m_situationParticuliere = pValeur;
  }
  
  public void setSituationParticuliere_C_ERR(String pValeur_C_ERR)
  {
    m_situationParticuliere_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDateDebutPeriode()
  {
    return m_dateDebutPeriode;
  }
  
  public String getDateDebutPeriode_C_ERR()
  {
    return m_dateDebutPeriode_C_ERR;
  }
  
  public void setDateDebutPeriode(Damj pValeur)
  {
    m_dateDebutPeriode = pValeur;
  }
  
  public void setDateDebutPeriode_C_ERR(String pValeur_C_ERR)
  {
    m_dateDebutPeriode_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDateFinPeriode()
  {
    return m_dateFinPeriode;
  }
  
  public String getDateFinPeriode_C_ERR()
  {
    return m_dateFinPeriode_C_ERR;
  }
  
  public void setDateFinPeriode(Damj pValeur)
  {
    m_dateFinPeriode = pValeur;
  }
  
  public void setDateFinPeriode_C_ERR(String pValeur_C_ERR)
  {
    m_dateFinPeriode_C_ERR = pValeur_C_ERR;
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
  
  public Damj getDateSignature()
  {
    return m_dateSignature;
  }
  
  public String getDateSignature_C_ERR()
  {
    return m_dateSignature_C_ERR;
  }
  
  public void setDateSignature(Damj pValeur)
  {
    m_dateSignature = pValeur;
  }
  
  public void setDateSignature_C_ERR(String pValeur_C_ERR)
  {
    m_dateSignature_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getSalaireBrutAbattu()
  {
    return m_salaireBrutAbattu;
  }
  
  public String getSalaireBrutAbattu_C_ERR()
  {
    return m_salaireBrutAbattu_C_ERR;
  }
  
  public void setSalaireBrutAbattu(BigDecimal pValeur)
  {
    m_salaireBrutAbattu = pValeur;
  }
  
  public void setSalaireBrutAbattu_C_ERR(String pValeur_C_ERR)
  {
    m_salaireBrutAbattu_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getPrime()
  {
    return m_prime;
  }
  
  public String getPrime_C_ERR()
  {
    return m_prime_C_ERR;
  }
  
  public void setPrime(BigDecimal pValeur)
  {
    m_prime = pValeur;
  }
  
  public void setPrime_C_ERR(String pValeur_C_ERR)
  {
    m_prime_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getMontantIFMIPE()
  {
    return m_montantIFMIPE;
  }
  
  public String getMontantIFMIPE_C_ERR()
  {
    return m_montantIFMIPE_C_ERR;
  }
  
  public void setMontantIFMIPE(BigDecimal pValeur)
  {
    m_montantIFMIPE = pValeur;
  }
  
  public void setMontantIFMIPE_C_ERR(String pValeur_C_ERR)
  {
    m_montantIFMIPE_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getMontantICCP()
  {
    return m_montantICCP;
  }
  
  public String getMontantICCP_C_ERR()
  {
    return m_montantICCP_C_ERR;
  }
  
  public void setMontantICCP(BigDecimal pValeur)
  {
    m_montantICCP = pValeur;
  }
  
  public void setMontantICCP_C_ERR(String pValeur_C_ERR)
  {
    m_montantICCP_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getSalaireNet()
  {
    return m_salaireNet;
  }
  
  public String getSalaireNet_C_ERR()
  {
    return m_salaireNet_C_ERR;
  }
  
  public void setSalaireNet(BigDecimal pValeur)
  {
    m_salaireNet = pValeur;
  }
  
  public void setSalaireNet_C_ERR(String pValeur_C_ERR)
  {
    m_salaireNet_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getQteTravail()
  {
    return m_qteTravail;
  }
  
  public String getQteTravail_C_ERR()
  {
    return m_qteTravail_C_ERR;
  }
  
  public void setQteTravail(BigDecimal pValeur)
  {
    m_qteTravail = pValeur;
  }
  
  public void setQteTravail_C_ERR(String pValeur_C_ERR)
  {
    m_qteTravail_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getMontantPrecompteAC()
  {
    return m_montantPrecompteAC;
  }
  
  public String getMontantPrecompteAC_C_ERR()
  {
    return m_montantPrecompteAC_C_ERR;
  }
  
  public void setMontantPrecompteAC(BigDecimal pValeur)
  {
    m_montantPrecompteAC = pValeur;
  }
  
  public void setMontantPrecompteAC_C_ERR(String pValeur_C_ERR)
  {
    m_montantPrecompteAC_C_ERR = pValeur_C_ERR;
  }
  
  public String getIdDocumentNumerique()
  {
    return m_idDocumentNumerique;
  }
  
  public String getIdDocumentNumerique_C_ERR()
  {
    return m_idDocumentNumerique_C_ERR;
  }
  
  public void setIdDocumentNumerique(String pValeur)
  {
    m_idDocumentNumerique = pValeur;
  }
  
  public void setIdDocumentNumerique_C_ERR(String pValeur_C_ERR)
  {
    m_idDocumentNumerique_C_ERR = pValeur_C_ERR;
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
    if ("m_bneIdentifiantBne_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_bneSiret_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_bneRaisonSociale_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_bneNumeroVoirie_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_bneLibelleVoieAdresse_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_bneComplAdresse_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_bneCodePostal_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_bneLibelleCommune_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_bneAssedicAffiliation_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_bneNumAffiliation_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_codeAssedic_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_NIR_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_typeEnregistrement_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_codeMonnaieSalaire_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_codeIntermittent_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_referenceEmployeur_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_codePostalEmployeur_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_codeInformationEmployeur_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_cocheAlsaceMoselle_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_uniteTravail_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_situationParticuliere_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateDebutPeriode_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateFinPeriode_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateFichierExterne_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateSignature_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_salaireBrutAbattu_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_prime_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_montantIFMIPE_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_montantICCP_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_salaireNet_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_qteTravail_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_montantPrecompteAC_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_idDocumentNumerique_C_ERR".equals(attrName)) {
      return String.class;
    }
    return null;
  }
  
  public PropertyInfo _getPropertyInfo(String pElementName)
    throws TechniqueException
  {
    if ("BneIdentifiantBne".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("BneSiret".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("BneRaisonSociale".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("BneNumeroVoirie".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("BneLibelleVoieAdresse".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("BneComplAdresse".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("BneCodePostal".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("BneLibelleCommune".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("BneAssedicAffiliation".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("BneNumAffiliation".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("CodeAssedic".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("NIR".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("TypeEnregistrement".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("CodeMonnaieSalaire".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("CodeIntermittent".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("ReferenceEmployeur".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("CodePostalEmployeur".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("CodeInformationEmployeur".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("CocheAlsaceMoselle".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("UniteTravail".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("SituationParticuliere".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("DateDebutPeriode".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("DateFinPeriode".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("DateFichierExterne".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("DateSignature".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("SalaireBrutAbattu".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("Prime".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("MontantIFMIPE".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("MontantICCP".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("SalaireNet".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("QteTravail".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("MontantPrecompteAC".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("IdDocumentNumerique".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    return null;
  }
  
  public int _getPropertyLength(String pElementName)
  {
    if ("BneIdentifiantBne".equals(pElementName)) {
      return 10;
    }
    if ("BneSiret".equals(pElementName)) {
      return 14;
    }
    if ("BneRaisonSociale".equals(pElementName)) {
      return 40;
    }
    if ("BneNumeroVoirie".equals(pElementName)) {
      return 5;
    }
    if ("BneLibelleVoieAdresse".equals(pElementName)) {
      return 32;
    }
    if ("BneComplAdresse".equals(pElementName)) {
      return 40;
    }
    if ("BneCodePostal".equals(pElementName)) {
      return 5;
    }
    if ("BneLibelleCommune".equals(pElementName)) {
      return 40;
    }
    if ("BneAssedicAffiliation".equals(pElementName)) {
      return 3;
    }
    if ("BneNumAffiliation".equals(pElementName)) {
      return 8;
    }
    if ("CodeAssedic".equals(pElementName)) {
      return 3;
    }
    if ("NIR".equals(pElementName)) {
      return 8;
    }
    if ("TypeEnregistrement".equals(pElementName)) {
      return 1;
    }
    if ("CodeMonnaieSalaire".equals(pElementName)) {
      return 1;
    }
    if ("CodeIntermittent".equals(pElementName)) {
      return 1;
    }
    if ("ReferenceEmployeur".equals(pElementName)) {
      return 20;
    }
    if ("CodePostalEmployeur".equals(pElementName)) {
      return 5;
    }
    if ("CodeInformationEmployeur".equals(pElementName)) {
      return 1;
    }
    if ("CocheAlsaceMoselle".equals(pElementName)) {
      return 1;
    }
    if ("UniteTravail".equals(pElementName)) {
      return 1;
    }
    if ("SituationParticuliere".equals(pElementName)) {
      return 3;
    }
    if ("DateDebutPeriode".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("DateFinPeriode".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("DateFichierExterne".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("DateSignature".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("SalaireBrutAbattu".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("Prime".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("MontantIFMIPE".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("MontantICCP".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("SalaireNet".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("QteTravail".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("MontantPrecompteAC".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("IdDocumentNumerique".equals(pElementName)) {
      return 13;
    }
    return -1;
  }
  
  public Object _getProperty(String pName)
    throws Exception
  {
    if ("BneIdentifiantBne".equals(pName)) {
      return m_bneIdentifiantBne;
    }
    if ("BneSiret".equals(pName)) {
      return m_bneSiret;
    }
    if ("BneRaisonSociale".equals(pName)) {
      return m_bneRaisonSociale;
    }
    if ("BneNumeroVoirie".equals(pName)) {
      return m_bneNumeroVoirie;
    }
    if ("BneLibelleVoieAdresse".equals(pName)) {
      return m_bneLibelleVoieAdresse;
    }
    if ("BneComplAdresse".equals(pName)) {
      return m_bneComplAdresse;
    }
    if ("BneCodePostal".equals(pName)) {
      return m_bneCodePostal;
    }
    if ("BneLibelleCommune".equals(pName)) {
      return m_bneLibelleCommune;
    }
    if ("BneAssedicAffiliation".equals(pName)) {
      return m_bneAssedicAffiliation;
    }
    if ("BneNumAffiliation".equals(pName)) {
      return m_bneNumAffiliation;
    }
    if ("CodeAssedic".equals(pName)) {
      return m_codeAssedic;
    }
    if ("NIR".equals(pName)) {
      return m_NIR;
    }
    if ("TypeEnregistrement".equals(pName)) {
      return m_typeEnregistrement;
    }
    if ("CodeMonnaieSalaire".equals(pName)) {
      return m_codeMonnaieSalaire;
    }
    if ("CodeIntermittent".equals(pName)) {
      return m_codeIntermittent;
    }
    if ("ReferenceEmployeur".equals(pName)) {
      return m_referenceEmployeur;
    }
    if ("CodePostalEmployeur".equals(pName)) {
      return m_codePostalEmployeur;
    }
    if ("CodeInformationEmployeur".equals(pName)) {
      return m_codeInformationEmployeur;
    }
    if ("CocheAlsaceMoselle".equals(pName)) {
      return m_cocheAlsaceMoselle;
    }
    if ("UniteTravail".equals(pName)) {
      return m_uniteTravail;
    }
    if ("SituationParticuliere".equals(pName)) {
      return m_situationParticuliere;
    }
    if ("DateDebutPeriode".equals(pName)) {
      return m_dateDebutPeriode;
    }
    if ("DateFinPeriode".equals(pName)) {
      return m_dateFinPeriode;
    }
    if ("DateFichierExterne".equals(pName)) {
      return m_dateFichierExterne;
    }
    if ("DateSignature".equals(pName)) {
      return m_dateSignature;
    }
    if ("SalaireBrutAbattu".equals(pName)) {
      return m_salaireBrutAbattu;
    }
    if ("Prime".equals(pName)) {
      return m_prime;
    }
    if ("MontantIFMIPE".equals(pName)) {
      return m_montantIFMIPE;
    }
    if ("MontantICCP".equals(pName)) {
      return m_montantICCP;
    }
    if ("SalaireNet".equals(pName)) {
      return m_salaireNet;
    }
    if ("QteTravail".equals(pName)) {
      return m_qteTravail;
    }
    if ("MontantPrecompteAC".equals(pName)) {
      return m_montantPrecompteAC;
    }
    if ("IdDocumentNumerique".equals(pName)) {
      return m_idDocumentNumerique;
    }
    return null;
  }
  
  public Iterator _getPropertyNames()
    throws Exception
  {
    ArrayList liste = new ArrayList();
    liste.add("BneIdentifiantBne");
    liste.add("BneSiret");
    liste.add("BneRaisonSociale");
    liste.add("BneNumeroVoirie");
    liste.add("BneLibelleVoieAdresse");
    liste.add("BneComplAdresse");
    liste.add("BneCodePostal");
    liste.add("BneLibelleCommune");
    liste.add("BneAssedicAffiliation");
    liste.add("BneNumAffiliation");
    liste.add("CodeAssedic");
    liste.add("NIR");
    liste.add("TypeEnregistrement");
    liste.add("CodeMonnaieSalaire");
    liste.add("CodeIntermittent");
    liste.add("ReferenceEmployeur");
    liste.add("CodePostalEmployeur");
    liste.add("CodeInformationEmployeur");
    liste.add("CocheAlsaceMoselle");
    liste.add("UniteTravail");
    liste.add("SituationParticuliere");
    liste.add("DateDebutPeriode");
    liste.add("DateFinPeriode");
    liste.add("DateFichierExterne");
    liste.add("DateSignature");
    liste.add("SalaireBrutAbattu");
    liste.add("Prime");
    liste.add("MontantIFMIPE");
    liste.add("MontantICCP");
    liste.add("SalaireNet");
    liste.add("QteTravail");
    liste.add("MontantPrecompteAC");
    liste.add("IdDocumentNumerique");
    return liste.iterator();
  }
  
  public ArrayList _getPropertyNames(ArrayList pListe)
    throws Exception
  {
    pListe.add("BneIdentifiantBne");
    pListe.add("BneSiret");
    pListe.add("BneRaisonSociale");
    pListe.add("BneNumeroVoirie");
    pListe.add("BneLibelleVoieAdresse");
    pListe.add("BneComplAdresse");
    pListe.add("BneCodePostal");
    pListe.add("BneLibelleCommune");
    pListe.add("BneAssedicAffiliation");
    pListe.add("BneNumAffiliation");
    pListe.add("CodeAssedic");
    pListe.add("NIR");
    pListe.add("TypeEnregistrement");
    pListe.add("CodeMonnaieSalaire");
    pListe.add("CodeIntermittent");
    pListe.add("ReferenceEmployeur");
    pListe.add("CodePostalEmployeur");
    pListe.add("CodeInformationEmployeur");
    pListe.add("CocheAlsaceMoselle");
    pListe.add("UniteTravail");
    pListe.add("SituationParticuliere");
    pListe.add("DateDebutPeriode");
    pListe.add("DateFinPeriode");
    pListe.add("DateFichierExterne");
    pListe.add("DateSignature");
    pListe.add("SalaireBrutAbattu");
    pListe.add("Prime");
    pListe.add("MontantIFMIPE");
    pListe.add("MontantICCP");
    pListe.add("SalaireNet");
    pListe.add("QteTravail");
    pListe.add("MontantPrecompteAC");
    pListe.add("IdDocumentNumerique");
    return pListe;
  }
  
  public void _setProperty(String pName, Object pValeur)
    throws Exception
  {
    if ("BneIdentifiantBne".equals(pName)) {
      m_bneIdentifiantBne = ((String)pValeur);
    }
    if ("BneSiret".equals(pName)) {
      m_bneSiret = ((String)pValeur);
    }
    if ("BneRaisonSociale".equals(pName)) {
      m_bneRaisonSociale = ((String)pValeur);
    }
    if ("BneNumeroVoirie".equals(pName)) {
      m_bneNumeroVoirie = ((String)pValeur);
    }
    if ("BneLibelleVoieAdresse".equals(pName)) {
      m_bneLibelleVoieAdresse = ((String)pValeur);
    }
    if ("BneComplAdresse".equals(pName)) {
      m_bneComplAdresse = ((String)pValeur);
    }
    if ("BneCodePostal".equals(pName)) {
      m_bneCodePostal = ((String)pValeur);
    }
    if ("BneLibelleCommune".equals(pName)) {
      m_bneLibelleCommune = ((String)pValeur);
    }
    if ("BneAssedicAffiliation".equals(pName)) {
      m_bneAssedicAffiliation = ((String)pValeur);
    }
    if ("BneNumAffiliation".equals(pName)) {
      m_bneNumAffiliation = ((String)pValeur);
    }
    if ("CodeAssedic".equals(pName)) {
      m_codeAssedic = ((String)pValeur);
    }
    if ("NIR".equals(pName)) {
      m_NIR = ((String)pValeur);
    }
    if ("TypeEnregistrement".equals(pName)) {
      m_typeEnregistrement = ((String)pValeur);
    }
    if ("CodeMonnaieSalaire".equals(pName)) {
      m_codeMonnaieSalaire = ((String)pValeur);
    }
    if ("CodeIntermittent".equals(pName)) {
      m_codeIntermittent = ((String)pValeur);
    }
    if ("ReferenceEmployeur".equals(pName)) {
      m_referenceEmployeur = ((String)pValeur);
    }
    if ("CodePostalEmployeur".equals(pName)) {
      m_codePostalEmployeur = ((String)pValeur);
    }
    if ("CodeInformationEmployeur".equals(pName)) {
      m_codeInformationEmployeur = ((String)pValeur);
    }
    if ("CocheAlsaceMoselle".equals(pName)) {
      m_cocheAlsaceMoselle = ((String)pValeur);
    }
    if ("UniteTravail".equals(pName)) {
      m_uniteTravail = ((String)pValeur);
    }
    if ("SituationParticuliere".equals(pName)) {
      m_situationParticuliere = ((String)pValeur);
    }
    if ("DateDebutPeriode".equals(pName)) {
      m_dateDebutPeriode = ((Damj)pValeur);
    }
    if ("DateFinPeriode".equals(pName)) {
      m_dateFinPeriode = ((Damj)pValeur);
    }
    if ("DateFichierExterne".equals(pName)) {
      m_dateFichierExterne = ((Damj)pValeur);
    }
    if ("DateSignature".equals(pName)) {
      m_dateSignature = ((Damj)pValeur);
    }
    if ("SalaireBrutAbattu".equals(pName)) {
      m_salaireBrutAbattu = ((BigDecimal)pValeur);
    }
    if ("Prime".equals(pName)) {
      m_prime = ((BigDecimal)pValeur);
    }
    if ("MontantIFMIPE".equals(pName)) {
      m_montantIFMIPE = ((BigDecimal)pValeur);
    }
    if ("MontantICCP".equals(pName)) {
      m_montantICCP = ((BigDecimal)pValeur);
    }
    if ("SalaireNet".equals(pName)) {
      m_salaireNet = ((BigDecimal)pValeur);
    }
    if ("QteTravail".equals(pName)) {
      m_qteTravail = ((BigDecimal)pValeur);
    }
    if ("MontantPrecompteAC".equals(pName)) {
      m_montantPrecompteAC = ((BigDecimal)pValeur);
    }
    if ("IdDocumentNumerique".equals(pName)) {
      m_idDocumentNumerique = ((String)pValeur);
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
    if ("m_bneIdentifiantBne_C_ERR".equals(attrName)) {
      m_bneIdentifiantBne_C_ERR = pValeur;
    }
    if ("m_bneSiret_C_ERR".equals(attrName)) {
      m_bneSiret_C_ERR = pValeur;
    }
    if ("m_bneRaisonSociale_C_ERR".equals(attrName)) {
      m_bneRaisonSociale_C_ERR = pValeur;
    }
    if ("m_bneNumeroVoirie_C_ERR".equals(attrName)) {
      m_bneNumeroVoirie_C_ERR = pValeur;
    }
    if ("m_bneLibelleVoieAdresse_C_ERR".equals(attrName)) {
      m_bneLibelleVoieAdresse_C_ERR = pValeur;
    }
    if ("m_bneComplAdresse_C_ERR".equals(attrName)) {
      m_bneComplAdresse_C_ERR = pValeur;
    }
    if ("m_bneCodePostal_C_ERR".equals(attrName)) {
      m_bneCodePostal_C_ERR = pValeur;
    }
    if ("m_bneLibelleCommune_C_ERR".equals(attrName)) {
      m_bneLibelleCommune_C_ERR = pValeur;
    }
    if ("m_bneAssedicAffiliation_C_ERR".equals(attrName)) {
      m_bneAssedicAffiliation_C_ERR = pValeur;
    }
    if ("m_bneNumAffiliation_C_ERR".equals(attrName)) {
      m_bneNumAffiliation_C_ERR = pValeur;
    }
    if ("m_codeAssedic_C_ERR".equals(attrName)) {
      m_codeAssedic_C_ERR = pValeur;
    }
    if ("m_NIR_C_ERR".equals(attrName)) {
      m_NIR_C_ERR = pValeur;
    }
    if ("m_typeEnregistrement_C_ERR".equals(attrName)) {
      m_typeEnregistrement_C_ERR = pValeur;
    }
    if ("m_codeMonnaieSalaire_C_ERR".equals(attrName)) {
      m_codeMonnaieSalaire_C_ERR = pValeur;
    }
    if ("m_codeIntermittent_C_ERR".equals(attrName)) {
      m_codeIntermittent_C_ERR = pValeur;
    }
    if ("m_referenceEmployeur_C_ERR".equals(attrName)) {
      m_referenceEmployeur_C_ERR = pValeur;
    }
    if ("m_codePostalEmployeur_C_ERR".equals(attrName)) {
      m_codePostalEmployeur_C_ERR = pValeur;
    }
    if ("m_codeInformationEmployeur_C_ERR".equals(attrName)) {
      m_codeInformationEmployeur_C_ERR = pValeur;
    }
    if ("m_cocheAlsaceMoselle_C_ERR".equals(attrName)) {
      m_cocheAlsaceMoselle_C_ERR = pValeur;
    }
    if ("m_uniteTravail_C_ERR".equals(attrName)) {
      m_uniteTravail_C_ERR = pValeur;
    }
    if ("m_situationParticuliere_C_ERR".equals(attrName)) {
      m_situationParticuliere_C_ERR = pValeur;
    }
    if ("m_dateDebutPeriode_C_ERR".equals(attrName)) {
      m_dateDebutPeriode_C_ERR = pValeur;
    }
    if ("m_dateFinPeriode_C_ERR".equals(attrName)) {
      m_dateFinPeriode_C_ERR = pValeur;
    }
    if ("m_dateFichierExterne_C_ERR".equals(attrName)) {
      m_dateFichierExterne_C_ERR = pValeur;
    }
    if ("m_dateSignature_C_ERR".equals(attrName)) {
      m_dateSignature_C_ERR = pValeur;
    }
    if ("m_salaireBrutAbattu_C_ERR".equals(attrName)) {
      m_salaireBrutAbattu_C_ERR = pValeur;
    }
    if ("m_prime_C_ERR".equals(attrName)) {
      m_prime_C_ERR = pValeur;
    }
    if ("m_montantIFMIPE_C_ERR".equals(attrName)) {
      m_montantIFMIPE_C_ERR = pValeur;
    }
    if ("m_montantICCP_C_ERR".equals(attrName)) {
      m_montantICCP_C_ERR = pValeur;
    }
    if ("m_salaireNet_C_ERR".equals(attrName)) {
      m_salaireNet_C_ERR = pValeur;
    }
    if ("m_qteTravail_C_ERR".equals(attrName)) {
      m_qteTravail_C_ERR = pValeur;
    }
    if ("m_montantPrecompteAC_C_ERR".equals(attrName)) {
      m_montantPrecompteAC_C_ERR = pValeur;
    }
    if ("m_idDocumentNumerique_C_ERR".equals(attrName)) {
      m_idDocumentNumerique_C_ERR = pValeur;
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
    if ("m_bneIdentifiantBne_C_ERR".equals(attrName)) {
      return m_bneIdentifiantBne_C_ERR;
    }
    if ("m_bneSiret_C_ERR".equals(attrName)) {
      return m_bneSiret_C_ERR;
    }
    if ("m_bneRaisonSociale_C_ERR".equals(attrName)) {
      return m_bneRaisonSociale_C_ERR;
    }
    if ("m_bneNumeroVoirie_C_ERR".equals(attrName)) {
      return m_bneNumeroVoirie_C_ERR;
    }
    if ("m_bneLibelleVoieAdresse_C_ERR".equals(attrName)) {
      return m_bneLibelleVoieAdresse_C_ERR;
    }
    if ("m_bneComplAdresse_C_ERR".equals(attrName)) {
      return m_bneComplAdresse_C_ERR;
    }
    if ("m_bneCodePostal_C_ERR".equals(attrName)) {
      return m_bneCodePostal_C_ERR;
    }
    if ("m_bneLibelleCommune_C_ERR".equals(attrName)) {
      return m_bneLibelleCommune_C_ERR;
    }
    if ("m_bneAssedicAffiliation_C_ERR".equals(attrName)) {
      return m_bneAssedicAffiliation_C_ERR;
    }
    if ("m_bneNumAffiliation_C_ERR".equals(attrName)) {
      return m_bneNumAffiliation_C_ERR;
    }
    if ("m_codeAssedic_C_ERR".equals(attrName)) {
      return m_codeAssedic_C_ERR;
    }
    if ("m_NIR_C_ERR".equals(attrName)) {
      return m_NIR_C_ERR;
    }
    if ("m_typeEnregistrement_C_ERR".equals(attrName)) {
      return m_typeEnregistrement_C_ERR;
    }
    if ("m_codeMonnaieSalaire_C_ERR".equals(attrName)) {
      return m_codeMonnaieSalaire_C_ERR;
    }
    if ("m_codeIntermittent_C_ERR".equals(attrName)) {
      return m_codeIntermittent_C_ERR;
    }
    if ("m_referenceEmployeur_C_ERR".equals(attrName)) {
      return m_referenceEmployeur_C_ERR;
    }
    if ("m_codePostalEmployeur_C_ERR".equals(attrName)) {
      return m_codePostalEmployeur_C_ERR;
    }
    if ("m_codeInformationEmployeur_C_ERR".equals(attrName)) {
      return m_codeInformationEmployeur_C_ERR;
    }
    if ("m_cocheAlsaceMoselle_C_ERR".equals(attrName)) {
      return m_cocheAlsaceMoselle_C_ERR;
    }
    if ("m_uniteTravail_C_ERR".equals(attrName)) {
      return m_uniteTravail_C_ERR;
    }
    if ("m_situationParticuliere_C_ERR".equals(attrName)) {
      return m_situationParticuliere_C_ERR;
    }
    if ("m_dateDebutPeriode_C_ERR".equals(attrName)) {
      return m_dateDebutPeriode_C_ERR;
    }
    if ("m_dateFinPeriode_C_ERR".equals(attrName)) {
      return m_dateFinPeriode_C_ERR;
    }
    if ("m_dateFichierExterne_C_ERR".equals(attrName)) {
      return m_dateFichierExterne_C_ERR;
    }
    if ("m_dateSignature_C_ERR".equals(attrName)) {
      return m_dateSignature_C_ERR;
    }
    if ("m_salaireBrutAbattu_C_ERR".equals(attrName)) {
      return m_salaireBrutAbattu_C_ERR;
    }
    if ("m_prime_C_ERR".equals(attrName)) {
      return m_prime_C_ERR;
    }
    if ("m_montantIFMIPE_C_ERR".equals(attrName)) {
      return m_montantIFMIPE_C_ERR;
    }
    if ("m_montantICCP_C_ERR".equals(attrName)) {
      return m_montantICCP_C_ERR;
    }
    if ("m_salaireNet_C_ERR".equals(attrName)) {
      return m_salaireNet_C_ERR;
    }
    if ("m_qteTravail_C_ERR".equals(attrName)) {
      return m_qteTravail_C_ERR;
    }
    if ("m_montantPrecompteAC_C_ERR".equals(attrName)) {
      return m_montantPrecompteAC_C_ERR;
    }
    if ("m_idDocumentNumerique_C_ERR".equals(attrName)) {
      return m_idDocumentNumerique_C_ERR;
    }
    return null;
  }
  
  public boolean equals(Object pObjet)
  {
    if (!(pObjet instanceof _FluxBS)) {
      return false;
    }
    _FluxBS x = (_FluxBS)pObjet;
    if (m_bneIdentifiantBne == null)
    {
      if (m_bneIdentifiantBne != null) {
        return false;
      }
    }
    else
    {
      if (m_bneIdentifiantBne == null) {
        return false;
      }
      if (!m_bneIdentifiantBne.equals(m_bneIdentifiantBne)) {
        return false;
      }
    }
    if (m_bneSiret == null)
    {
      if (m_bneSiret != null) {
        return false;
      }
    }
    else
    {
      if (m_bneSiret == null) {
        return false;
      }
      if (!m_bneSiret.equals(m_bneSiret)) {
        return false;
      }
    }
    if (m_bneRaisonSociale == null)
    {
      if (m_bneRaisonSociale != null) {
        return false;
      }
    }
    else
    {
      if (m_bneRaisonSociale == null) {
        return false;
      }
      if (!m_bneRaisonSociale.equals(m_bneRaisonSociale)) {
        return false;
      }
    }
    if (m_bneNumeroVoirie == null)
    {
      if (m_bneNumeroVoirie != null) {
        return false;
      }
    }
    else
    {
      if (m_bneNumeroVoirie == null) {
        return false;
      }
      if (!m_bneNumeroVoirie.equals(m_bneNumeroVoirie)) {
        return false;
      }
    }
    if (m_bneLibelleVoieAdresse == null)
    {
      if (m_bneLibelleVoieAdresse != null) {
        return false;
      }
    }
    else
    {
      if (m_bneLibelleVoieAdresse == null) {
        return false;
      }
      if (!m_bneLibelleVoieAdresse.equals(m_bneLibelleVoieAdresse)) {
        return false;
      }
    }
    if (m_bneComplAdresse == null)
    {
      if (m_bneComplAdresse != null) {
        return false;
      }
    }
    else
    {
      if (m_bneComplAdresse == null) {
        return false;
      }
      if (!m_bneComplAdresse.equals(m_bneComplAdresse)) {
        return false;
      }
    }
    if (m_bneCodePostal == null)
    {
      if (m_bneCodePostal != null) {
        return false;
      }
    }
    else
    {
      if (m_bneCodePostal == null) {
        return false;
      }
      if (!m_bneCodePostal.equals(m_bneCodePostal)) {
        return false;
      }
    }
    if (m_bneLibelleCommune == null)
    {
      if (m_bneLibelleCommune != null) {
        return false;
      }
    }
    else
    {
      if (m_bneLibelleCommune == null) {
        return false;
      }
      if (!m_bneLibelleCommune.equals(m_bneLibelleCommune)) {
        return false;
      }
    }
    if (m_bneAssedicAffiliation == null)
    {
      if (m_bneAssedicAffiliation != null) {
        return false;
      }
    }
    else
    {
      if (m_bneAssedicAffiliation == null) {
        return false;
      }
      if (!m_bneAssedicAffiliation.equals(m_bneAssedicAffiliation)) {
        return false;
      }
    }
    if (m_bneNumAffiliation == null)
    {
      if (m_bneNumAffiliation != null) {
        return false;
      }
    }
    else
    {
      if (m_bneNumAffiliation == null) {
        return false;
      }
      if (!m_bneNumAffiliation.equals(m_bneNumAffiliation)) {
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
    if (m_codeMonnaieSalaire == null)
    {
      if (m_codeMonnaieSalaire != null) {
        return false;
      }
    }
    else
    {
      if (m_codeMonnaieSalaire == null) {
        return false;
      }
      if (!m_codeMonnaieSalaire.equals(m_codeMonnaieSalaire)) {
        return false;
      }
    }
    if (m_codeIntermittent == null)
    {
      if (m_codeIntermittent != null) {
        return false;
      }
    }
    else
    {
      if (m_codeIntermittent == null) {
        return false;
      }
      if (!m_codeIntermittent.equals(m_codeIntermittent)) {
        return false;
      }
    }
    if (m_referenceEmployeur == null)
    {
      if (m_referenceEmployeur != null) {
        return false;
      }
    }
    else
    {
      if (m_referenceEmployeur == null) {
        return false;
      }
      if (!m_referenceEmployeur.equals(m_referenceEmployeur)) {
        return false;
      }
    }
    if (m_codePostalEmployeur == null)
    {
      if (m_codePostalEmployeur != null) {
        return false;
      }
    }
    else
    {
      if (m_codePostalEmployeur == null) {
        return false;
      }
      if (!m_codePostalEmployeur.equals(m_codePostalEmployeur)) {
        return false;
      }
    }
    if (m_codeInformationEmployeur == null)
    {
      if (m_codeInformationEmployeur != null) {
        return false;
      }
    }
    else
    {
      if (m_codeInformationEmployeur == null) {
        return false;
      }
      if (!m_codeInformationEmployeur.equals(m_codeInformationEmployeur)) {
        return false;
      }
    }
    if (m_cocheAlsaceMoselle == null)
    {
      if (m_cocheAlsaceMoselle != null) {
        return false;
      }
    }
    else
    {
      if (m_cocheAlsaceMoselle == null) {
        return false;
      }
      if (!m_cocheAlsaceMoselle.equals(m_cocheAlsaceMoselle)) {
        return false;
      }
    }
    if (m_uniteTravail == null)
    {
      if (m_uniteTravail != null) {
        return false;
      }
    }
    else
    {
      if (m_uniteTravail == null) {
        return false;
      }
      if (!m_uniteTravail.equals(m_uniteTravail)) {
        return false;
      }
    }
    if (m_situationParticuliere == null)
    {
      if (m_situationParticuliere != null) {
        return false;
      }
    }
    else
    {
      if (m_situationParticuliere == null) {
        return false;
      }
      if (!m_situationParticuliere.equals(m_situationParticuliere)) {
        return false;
      }
    }
    if (m_dateDebutPeriode == null)
    {
      if (m_dateDebutPeriode != null) {
        return false;
      }
    }
    else
    {
      if (m_dateDebutPeriode == null) {
        return false;
      }
      if (!m_dateDebutPeriode.equals(m_dateDebutPeriode)) {
        return false;
      }
    }
    if (m_dateFinPeriode == null)
    {
      if (m_dateFinPeriode != null) {
        return false;
      }
    }
    else
    {
      if (m_dateFinPeriode == null) {
        return false;
      }
      if (!m_dateFinPeriode.equals(m_dateFinPeriode)) {
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
    if (m_dateSignature == null)
    {
      if (m_dateSignature != null) {
        return false;
      }
    }
    else
    {
      if (m_dateSignature == null) {
        return false;
      }
      if (!m_dateSignature.equals(m_dateSignature)) {
        return false;
      }
    }
    if (m_salaireBrutAbattu == null)
    {
      if (m_salaireBrutAbattu != null) {
        return false;
      }
    }
    else
    {
      if (m_salaireBrutAbattu == null) {
        return false;
      }
      if (!m_salaireBrutAbattu.equals(m_salaireBrutAbattu)) {
        return false;
      }
    }
    if (m_prime == null)
    {
      if (m_prime != null) {
        return false;
      }
    }
    else
    {
      if (m_prime == null) {
        return false;
      }
      if (!m_prime.equals(m_prime)) {
        return false;
      }
    }
    if (m_montantIFMIPE == null)
    {
      if (m_montantIFMIPE != null) {
        return false;
      }
    }
    else
    {
      if (m_montantIFMIPE == null) {
        return false;
      }
      if (!m_montantIFMIPE.equals(m_montantIFMIPE)) {
        return false;
      }
    }
    if (m_montantICCP == null)
    {
      if (m_montantICCP != null) {
        return false;
      }
    }
    else
    {
      if (m_montantICCP == null) {
        return false;
      }
      if (!m_montantICCP.equals(m_montantICCP)) {
        return false;
      }
    }
    if (m_salaireNet == null)
    {
      if (m_salaireNet != null) {
        return false;
      }
    }
    else
    {
      if (m_salaireNet == null) {
        return false;
      }
      if (!m_salaireNet.equals(m_salaireNet)) {
        return false;
      }
    }
    if (m_qteTravail == null)
    {
      if (m_qteTravail != null) {
        return false;
      }
    }
    else
    {
      if (m_qteTravail == null) {
        return false;
      }
      if (!m_qteTravail.equals(m_qteTravail)) {
        return false;
      }
    }
    if (m_montantPrecompteAC == null)
    {
      if (m_montantPrecompteAC != null) {
        return false;
      }
    }
    else
    {
      if (m_montantPrecompteAC == null) {
        return false;
      }
      if (!m_montantPrecompteAC.equals(m_montantPrecompteAC)) {
        return false;
      }
    }
    if (m_idDocumentNumerique == null)
    {
      if (m_idDocumentNumerique != null) {
        return false;
      }
    }
    else
    {
      if (m_idDocumentNumerique == null) {
        return false;
      }
      if (!m_idDocumentNumerique.equals(m_idDocumentNumerique)) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int result = 0;
    if (m_bneIdentifiantBne != null) {
      result += m_bneIdentifiantBne.hashCode();
    }
    if (m_bneSiret != null) {
      result += m_bneSiret.hashCode();
    }
    if (m_bneRaisonSociale != null) {
      result += m_bneRaisonSociale.hashCode();
    }
    if (m_bneNumeroVoirie != null) {
      result += m_bneNumeroVoirie.hashCode();
    }
    if (m_bneLibelleVoieAdresse != null) {
      result += m_bneLibelleVoieAdresse.hashCode();
    }
    if (m_bneComplAdresse != null) {
      result += m_bneComplAdresse.hashCode();
    }
    if (m_bneCodePostal != null) {
      result += m_bneCodePostal.hashCode();
    }
    if (m_bneLibelleCommune != null) {
      result += m_bneLibelleCommune.hashCode();
    }
    if (m_bneAssedicAffiliation != null) {
      result += m_bneAssedicAffiliation.hashCode();
    }
    if (m_bneNumAffiliation != null) {
      result += m_bneNumAffiliation.hashCode();
    }
    if (m_codeAssedic != null) {
      result += m_codeAssedic.hashCode();
    }
    if (m_NIR != null) {
      result += m_NIR.hashCode();
    }
    if (m_typeEnregistrement != null) {
      result += m_typeEnregistrement.hashCode();
    }
    if (m_codeMonnaieSalaire != null) {
      result += m_codeMonnaieSalaire.hashCode();
    }
    if (m_codeIntermittent != null) {
      result += m_codeIntermittent.hashCode();
    }
    if (m_referenceEmployeur != null) {
      result += m_referenceEmployeur.hashCode();
    }
    if (m_codePostalEmployeur != null) {
      result += m_codePostalEmployeur.hashCode();
    }
    if (m_codeInformationEmployeur != null) {
      result += m_codeInformationEmployeur.hashCode();
    }
    if (m_cocheAlsaceMoselle != null) {
      result += m_cocheAlsaceMoselle.hashCode();
    }
    if (m_uniteTravail != null) {
      result += m_uniteTravail.hashCode();
    }
    if (m_situationParticuliere != null) {
      result += m_situationParticuliere.hashCode();
    }
    if (m_dateDebutPeriode != null) {
      result += m_dateDebutPeriode.hashCode();
    }
    if (m_dateFinPeriode != null) {
      result += m_dateFinPeriode.hashCode();
    }
    if (m_dateFichierExterne != null) {
      result += m_dateFichierExterne.hashCode();
    }
    if (m_dateSignature != null) {
      result += m_dateSignature.hashCode();
    }
    if (m_salaireBrutAbattu != null) {
      result += m_salaireBrutAbattu.hashCode();
    }
    if (m_prime != null) {
      result += m_prime.hashCode();
    }
    if (m_montantIFMIPE != null) {
      result += m_montantIFMIPE.hashCode();
    }
    if (m_montantICCP != null) {
      result += m_montantICCP.hashCode();
    }
    if (m_salaireNet != null) {
      result += m_salaireNet.hashCode();
    }
    if (m_qteTravail != null) {
      result += m_qteTravail.hashCode();
    }
    if (m_montantPrecompteAC != null) {
      result += m_montantPrecompteAC.hashCode();
    }
    if (m_idDocumentNumerique != null) {
      result += m_idDocumentNumerique.hashCode();
    }
    result *= 17;
    return result;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    _FluxBS clone_FluxBS = new _FluxBS();
    clone_FluxBS.populateFrom_FluxBS(this);
    return clone_FluxBS;
  }
  
  public void populateFrom_FluxBS(_FluxBS pSource)
  {
    setBneIdentifiantBne(pSource.getBneIdentifiantBne());setBneSiret(pSource.getBneSiret());setBneRaisonSociale(pSource.getBneRaisonSociale());setBneNumeroVoirie(pSource.getBneNumeroVoirie());setBneLibelleVoieAdresse(pSource.getBneLibelleVoieAdresse());setBneComplAdresse(pSource.getBneComplAdresse());setBneCodePostal(pSource.getBneCodePostal());setBneLibelleCommune(pSource.getBneLibelleCommune());setBneAssedicAffiliation(pSource.getBneAssedicAffiliation());setBneNumAffiliation(pSource.getBneNumAffiliation());setCodeAssedic(pSource.getCodeAssedic());setNIR(pSource.getNIR());setTypeEnregistrement(pSource.getTypeEnregistrement());setCodeMonnaieSalaire(pSource.getCodeMonnaieSalaire());setCodeIntermittent(pSource.getCodeIntermittent());setReferenceEmployeur(pSource.getReferenceEmployeur());setCodePostalEmployeur(pSource.getCodePostalEmployeur());setCodeInformationEmployeur(pSource.getCodeInformationEmployeur());setCocheAlsaceMoselle(pSource.getCocheAlsaceMoselle());setUniteTravail(pSource.getUniteTravail());setSituationParticuliere(pSource.getSituationParticuliere());setDateDebutPeriode(pSource.getDateDebutPeriode());setDateFinPeriode(pSource.getDateFinPeriode());setDateFichierExterne(pSource.getDateFichierExterne());setDateSignature(pSource.getDateSignature());setSalaireBrutAbattu(pSource.getSalaireBrutAbattu());setPrime(pSource.getPrime());setMontantIFMIPE(pSource.getMontantIFMIPE());setMontantICCP(pSource.getMontantICCP());setSalaireNet(pSource.getSalaireNet());setQteTravail(pSource.getQteTravail());setMontantPrecompteAC(pSource.getMontantPrecompteAC());setIdDocumentNumerique(pSource.getIdDocumentNumerique());
  }
  
  public String toString()
  {
    StringBuffer s = new StringBuffer("[_FluxBS");
    subToString(s);
    s.append("]");
    return s.toString();
  }
  
  protected void subToString(StringBuffer pSource)
  {
    pSource.append(", BneIdentifiantBne: ");
    pSource.append(m_bneIdentifiantBne);
    pSource.append(", BneSiret: ");
    pSource.append(m_bneSiret);
    pSource.append(", BneRaisonSociale: ");
    pSource.append(m_bneRaisonSociale);
    pSource.append(", BneNumeroVoirie: ");
    pSource.append(m_bneNumeroVoirie);
    pSource.append(", BneLibelleVoieAdresse: ");
    pSource.append(m_bneLibelleVoieAdresse);
    pSource.append(", BneComplAdresse: ");
    pSource.append(m_bneComplAdresse);
    pSource.append(", BneCodePostal: ");
    pSource.append(m_bneCodePostal);
    pSource.append(", BneLibelleCommune: ");
    pSource.append(m_bneLibelleCommune);
    pSource.append(", BneAssedicAffiliation: ");
    pSource.append(m_bneAssedicAffiliation);
    pSource.append(", BneNumAffiliation: ");
    pSource.append(m_bneNumAffiliation);
    pSource.append(", CodeAssedic: ");
    pSource.append(m_codeAssedic);
    pSource.append(", NIR: ");
    pSource.append(m_NIR);
    pSource.append(", TypeEnregistrement: ");
    pSource.append(m_typeEnregistrement);
    pSource.append(", CodeMonnaieSalaire: ");
    pSource.append(m_codeMonnaieSalaire);
    pSource.append(", CodeIntermittent: ");
    pSource.append(m_codeIntermittent);
    pSource.append(", ReferenceEmployeur: ");
    pSource.append(m_referenceEmployeur);
    pSource.append(", CodePostalEmployeur: ");
    pSource.append(m_codePostalEmployeur);
    pSource.append(", CodeInformationEmployeur: ");
    pSource.append(m_codeInformationEmployeur);
    pSource.append(", CocheAlsaceMoselle: ");
    pSource.append(m_cocheAlsaceMoselle);
    pSource.append(", UniteTravail: ");
    pSource.append(m_uniteTravail);
    pSource.append(", SituationParticuliere: ");
    pSource.append(m_situationParticuliere);
    pSource.append(", DateDebutPeriode: ");
    pSource.append(m_dateDebutPeriode);
    pSource.append(", DateFinPeriode: ");
    pSource.append(m_dateFinPeriode);
    pSource.append(", DateFichierExterne: ");
    pSource.append(m_dateFichierExterne);
    pSource.append(", DateSignature: ");
    pSource.append(m_dateSignature);
    pSource.append(", SalaireBrutAbattu: ");
    pSource.append(m_salaireBrutAbattu);
    pSource.append(", Prime: ");
    pSource.append(m_prime);
    pSource.append(", MontantIFMIPE: ");
    pSource.append(m_montantIFMIPE);
    pSource.append(", MontantICCP: ");
    pSource.append(m_montantICCP);
    pSource.append(", SalaireNet: ");
    pSource.append(m_salaireNet);
    pSource.append(", QteTravail: ");
    pSource.append(m_qteTravail);
    pSource.append(", MontantPrecompteAC: ");
    pSource.append(m_montantPrecompteAC);
    pSource.append(", IdDocumentNumerique: ");
    pSource.append(m_idDocumentNumerique);
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
    pHandler.property("BneIdentifiantBne", getBneIdentifiantBne(), new Attribute[] { new StringAttribute("C_ERR", getBneIdentifiantBne_C_ERR()) });
    
    pHandler.property("BneSiret", getBneSiret(), new Attribute[] { new StringAttribute("C_ERR", getBneSiret_C_ERR()) });
    
    pHandler.property("BneRaisonSociale", getBneRaisonSociale(), new Attribute[] { new StringAttribute("C_ERR", getBneRaisonSociale_C_ERR()) });
    
    pHandler.property("BneNumeroVoirie", getBneNumeroVoirie(), new Attribute[] { new StringAttribute("C_ERR", getBneNumeroVoirie_C_ERR()) });
    
    pHandler.property("BneLibelleVoieAdresse", getBneLibelleVoieAdresse(), new Attribute[] { new StringAttribute("C_ERR", getBneLibelleVoieAdresse_C_ERR()) });
    
    pHandler.property("BneComplAdresse", getBneComplAdresse(), new Attribute[] { new StringAttribute("C_ERR", getBneComplAdresse_C_ERR()) });
    
    pHandler.property("BneCodePostal", getBneCodePostal(), new Attribute[] { new StringAttribute("C_ERR", getBneCodePostal_C_ERR()) });
    
    pHandler.property("BneLibelleCommune", getBneLibelleCommune(), new Attribute[] { new StringAttribute("C_ERR", getBneLibelleCommune_C_ERR()) });
    
    pHandler.property("BneAssedicAffiliation", getBneAssedicAffiliation(), new Attribute[] { new StringAttribute("C_ERR", getBneAssedicAffiliation_C_ERR()) });
    
    pHandler.property("BneNumAffiliation", getBneNumAffiliation(), new Attribute[] { new StringAttribute("C_ERR", getBneNumAffiliation_C_ERR()) });
    
    pHandler.property("CodeAssedic", getCodeAssedic(), new Attribute[] { new StringAttribute("C_ERR", getCodeAssedic_C_ERR()) });
    
    pHandler.property("NIR", getNIR(), new Attribute[] { new StringAttribute("C_ERR", getNIR_C_ERR()) });
    
    pHandler.property("TypeEnregistrement", getTypeEnregistrement(), new Attribute[] { new StringAttribute("C_ERR", getTypeEnregistrement_C_ERR()) });
    
    pHandler.property("CodeMonnaieSalaire", getCodeMonnaieSalaire(), new Attribute[] { new StringAttribute("C_ERR", getCodeMonnaieSalaire_C_ERR()) });
    
    pHandler.property("CodeIntermittent", getCodeIntermittent(), new Attribute[] { new StringAttribute("C_ERR", getCodeIntermittent_C_ERR()) });
    
    pHandler.property("ReferenceEmployeur", getReferenceEmployeur(), new Attribute[] { new StringAttribute("C_ERR", getReferenceEmployeur_C_ERR()) });
    
    pHandler.property("CodePostalEmployeur", getCodePostalEmployeur(), new Attribute[] { new StringAttribute("C_ERR", getCodePostalEmployeur_C_ERR()) });
    
    pHandler.property("CodeInformationEmployeur", getCodeInformationEmployeur(), new Attribute[] { new StringAttribute("C_ERR", getCodeInformationEmployeur_C_ERR()) });
    
    pHandler.property("CocheAlsaceMoselle", getCocheAlsaceMoselle(), new Attribute[] { new StringAttribute("C_ERR", getCocheAlsaceMoselle_C_ERR()) });
    
    pHandler.property("UniteTravail", getUniteTravail(), new Attribute[] { new StringAttribute("C_ERR", getUniteTravail_C_ERR()) });
    
    pHandler.property("SituationParticuliere", getSituationParticuliere(), new Attribute[] { new StringAttribute("C_ERR", getSituationParticuliere_C_ERR()) });
    
    pHandler.property("DateDebutPeriode", getDateDebutPeriode(), new Attribute[] { new StringAttribute("C_ERR", getDateDebutPeriode_C_ERR()) });
    
    pHandler.property("DateFinPeriode", getDateFinPeriode(), new Attribute[] { new StringAttribute("C_ERR", getDateFinPeriode_C_ERR()) });
    
    pHandler.property("DateFichierExterne", getDateFichierExterne(), new Attribute[] { new StringAttribute("C_ERR", getDateFichierExterne_C_ERR()) });
    
    pHandler.property("DateSignature", getDateSignature(), new Attribute[] { new StringAttribute("C_ERR", getDateSignature_C_ERR()) });
    
    pHandler.property("SalaireBrutAbattu", getSalaireBrutAbattu(), new Attribute[] { new StringAttribute("C_ERR", getSalaireBrutAbattu_C_ERR()) });
    
    pHandler.property("Prime", getPrime(), new Attribute[] { new StringAttribute("C_ERR", getPrime_C_ERR()) });
    
    pHandler.property("MontantIFMIPE", getMontantIFMIPE(), new Attribute[] { new StringAttribute("C_ERR", getMontantIFMIPE_C_ERR()) });
    
    pHandler.property("MontantICCP", getMontantICCP(), new Attribute[] { new StringAttribute("C_ERR", getMontantICCP_C_ERR()) });
    
    pHandler.property("SalaireNet", getSalaireNet(), new Attribute[] { new StringAttribute("C_ERR", getSalaireNet_C_ERR()) });
    
    pHandler.property("QteTravail", getQteTravail(), new Attribute[] { new StringAttribute("C_ERR", getQteTravail_C_ERR()) });
    
    pHandler.property("MontantPrecompteAC", getMontantPrecompteAC(), new Attribute[] { new StringAttribute("C_ERR", getMontantPrecompteAC_C_ERR()) });
    
    pHandler.property("IdDocumentNumerique", getIdDocumentNumerique(), new Attribute[] { new StringAttribute("C_ERR", getIdDocumentNumerique_C_ERR()) });
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
    setBneIdentifiantBne((String)pHandler.objectProperty("BneIdentifiantBne", String.class));
    setBneIdentifiantBne_C_ERR(pHandler.stringAttribute("BneIdentifiantBne", "C_ERR"));
    
    setBneSiret((String)pHandler.objectProperty("BneSiret", String.class));
    setBneSiret_C_ERR(pHandler.stringAttribute("BneSiret", "C_ERR"));
    
    setBneRaisonSociale((String)pHandler.objectProperty("BneRaisonSociale", String.class));
    setBneRaisonSociale_C_ERR(pHandler.stringAttribute("BneRaisonSociale", "C_ERR"));
    
    setBneNumeroVoirie((String)pHandler.objectProperty("BneNumeroVoirie", String.class));
    setBneNumeroVoirie_C_ERR(pHandler.stringAttribute("BneNumeroVoirie", "C_ERR"));
    
    setBneLibelleVoieAdresse((String)pHandler.objectProperty("BneLibelleVoieAdresse", String.class));
    setBneLibelleVoieAdresse_C_ERR(pHandler.stringAttribute("BneLibelleVoieAdresse", "C_ERR"));
    
    setBneComplAdresse((String)pHandler.objectProperty("BneComplAdresse", String.class));
    setBneComplAdresse_C_ERR(pHandler.stringAttribute("BneComplAdresse", "C_ERR"));
    
    setBneCodePostal((String)pHandler.objectProperty("BneCodePostal", String.class));
    setBneCodePostal_C_ERR(pHandler.stringAttribute("BneCodePostal", "C_ERR"));
    
    setBneLibelleCommune((String)pHandler.objectProperty("BneLibelleCommune", String.class));
    setBneLibelleCommune_C_ERR(pHandler.stringAttribute("BneLibelleCommune", "C_ERR"));
    
    setBneAssedicAffiliation((String)pHandler.objectProperty("BneAssedicAffiliation", String.class));
    setBneAssedicAffiliation_C_ERR(pHandler.stringAttribute("BneAssedicAffiliation", "C_ERR"));
    
    setBneNumAffiliation((String)pHandler.objectProperty("BneNumAffiliation", String.class));
    setBneNumAffiliation_C_ERR(pHandler.stringAttribute("BneNumAffiliation", "C_ERR"));
    
    setCodeAssedic((String)pHandler.objectProperty("CodeAssedic", String.class));
    setCodeAssedic_C_ERR(pHandler.stringAttribute("CodeAssedic", "C_ERR"));
    
    setNIR((String)pHandler.objectProperty("NIR", String.class));
    setNIR_C_ERR(pHandler.stringAttribute("NIR", "C_ERR"));
    
    setTypeEnregistrement((String)pHandler.objectProperty("TypeEnregistrement", String.class));
    setTypeEnregistrement_C_ERR(pHandler.stringAttribute("TypeEnregistrement", "C_ERR"));
    
    setCodeMonnaieSalaire((String)pHandler.objectProperty("CodeMonnaieSalaire", String.class));
    setCodeMonnaieSalaire_C_ERR(pHandler.stringAttribute("CodeMonnaieSalaire", "C_ERR"));
    
    setCodeIntermittent((String)pHandler.objectProperty("CodeIntermittent", String.class));
    setCodeIntermittent_C_ERR(pHandler.stringAttribute("CodeIntermittent", "C_ERR"));
    
    setReferenceEmployeur((String)pHandler.objectProperty("ReferenceEmployeur", String.class));
    setReferenceEmployeur_C_ERR(pHandler.stringAttribute("ReferenceEmployeur", "C_ERR"));
    
    setCodePostalEmployeur((String)pHandler.objectProperty("CodePostalEmployeur", String.class));
    setCodePostalEmployeur_C_ERR(pHandler.stringAttribute("CodePostalEmployeur", "C_ERR"));
    
    setCodeInformationEmployeur((String)pHandler.objectProperty("CodeInformationEmployeur", String.class));
    setCodeInformationEmployeur_C_ERR(pHandler.stringAttribute("CodeInformationEmployeur", "C_ERR"));
    
    setCocheAlsaceMoselle((String)pHandler.objectProperty("CocheAlsaceMoselle", String.class));
    setCocheAlsaceMoselle_C_ERR(pHandler.stringAttribute("CocheAlsaceMoselle", "C_ERR"));
    
    setUniteTravail((String)pHandler.objectProperty("UniteTravail", String.class));
    setUniteTravail_C_ERR(pHandler.stringAttribute("UniteTravail", "C_ERR"));
    
    setSituationParticuliere((String)pHandler.objectProperty("SituationParticuliere", String.class));
    setSituationParticuliere_C_ERR(pHandler.stringAttribute("SituationParticuliere", "C_ERR"));
    
    setDateDebutPeriode((Damj)pHandler.objectProperty("DateDebutPeriode", Damj.class));
    setDateDebutPeriode_C_ERR(pHandler.stringAttribute("DateDebutPeriode", "C_ERR"));
    
    setDateFinPeriode((Damj)pHandler.objectProperty("DateFinPeriode", Damj.class));
    setDateFinPeriode_C_ERR(pHandler.stringAttribute("DateFinPeriode", "C_ERR"));
    
    setDateFichierExterne((Damj)pHandler.objectProperty("DateFichierExterne", Damj.class));
    setDateFichierExterne_C_ERR(pHandler.stringAttribute("DateFichierExterne", "C_ERR"));
    
    setDateSignature((Damj)pHandler.objectProperty("DateSignature", Damj.class));
    setDateSignature_C_ERR(pHandler.stringAttribute("DateSignature", "C_ERR"));
    
    setSalaireBrutAbattu((BigDecimal)pHandler.objectProperty("SalaireBrutAbattu", BigDecimal.class));
    setSalaireBrutAbattu_C_ERR(pHandler.stringAttribute("SalaireBrutAbattu", "C_ERR"));
    
    setPrime((BigDecimal)pHandler.objectProperty("Prime", BigDecimal.class));
    setPrime_C_ERR(pHandler.stringAttribute("Prime", "C_ERR"));
    
    setMontantIFMIPE((BigDecimal)pHandler.objectProperty("MontantIFMIPE", BigDecimal.class));
    setMontantIFMIPE_C_ERR(pHandler.stringAttribute("MontantIFMIPE", "C_ERR"));
    
    setMontantICCP((BigDecimal)pHandler.objectProperty("MontantICCP", BigDecimal.class));
    setMontantICCP_C_ERR(pHandler.stringAttribute("MontantICCP", "C_ERR"));
    
    setSalaireNet((BigDecimal)pHandler.objectProperty("SalaireNet", BigDecimal.class));
    setSalaireNet_C_ERR(pHandler.stringAttribute("SalaireNet", "C_ERR"));
    
    setQteTravail((BigDecimal)pHandler.objectProperty("QteTravail", BigDecimal.class));
    setQteTravail_C_ERR(pHandler.stringAttribute("QteTravail", "C_ERR"));
    
    setMontantPrecompteAC((BigDecimal)pHandler.objectProperty("MontantPrecompteAC", BigDecimal.class));
    setMontantPrecompteAC_C_ERR(pHandler.stringAttribute("MontantPrecompteAC", "C_ERR"));
    
    setIdDocumentNumerique((String)pHandler.objectProperty("IdDocumentNumerique", String.class));
    setIdDocumentNumerique_C_ERR(pHandler.stringAttribute("IdDocumentNumerique", "C_ERR"));
  }
  
  public String _getDatabeanName()
  {
    return "FluxBS";
  }
  
  public boolean _isValidProperty(String pElementName)
  {
    if ("BneIdentifiantBne".equals(pElementName)) {
      return true;
    }
    if ("BneSiret".equals(pElementName)) {
      return true;
    }
    if ("BneRaisonSociale".equals(pElementName)) {
      return true;
    }
    if ("BneNumeroVoirie".equals(pElementName)) {
      return true;
    }
    if ("BneLibelleVoieAdresse".equals(pElementName)) {
      return true;
    }
    if ("BneComplAdresse".equals(pElementName)) {
      return true;
    }
    if ("BneCodePostal".equals(pElementName)) {
      return true;
    }
    if ("BneLibelleCommune".equals(pElementName)) {
      return true;
    }
    if ("BneAssedicAffiliation".equals(pElementName)) {
      return true;
    }
    if ("BneNumAffiliation".equals(pElementName)) {
      return true;
    }
    if ("CodeAssedic".equals(pElementName)) {
      return true;
    }
    if ("NIR".equals(pElementName)) {
      return true;
    }
    if ("TypeEnregistrement".equals(pElementName)) {
      return true;
    }
    if ("CodeMonnaieSalaire".equals(pElementName)) {
      return true;
    }
    if ("CodeIntermittent".equals(pElementName)) {
      return true;
    }
    if ("ReferenceEmployeur".equals(pElementName)) {
      return true;
    }
    if ("CodePostalEmployeur".equals(pElementName)) {
      return true;
    }
    if ("CodeInformationEmployeur".equals(pElementName)) {
      return true;
    }
    if ("CocheAlsaceMoselle".equals(pElementName)) {
      return true;
    }
    if ("UniteTravail".equals(pElementName)) {
      return true;
    }
    if ("SituationParticuliere".equals(pElementName)) {
      return true;
    }
    if ("DateDebutPeriode".equals(pElementName)) {
      return true;
    }
    if ("DateFinPeriode".equals(pElementName)) {
      return true;
    }
    if ("DateFichierExterne".equals(pElementName)) {
      return true;
    }
    if ("DateSignature".equals(pElementName)) {
      return true;
    }
    if ("SalaireBrutAbattu".equals(pElementName)) {
      return true;
    }
    if ("Prime".equals(pElementName)) {
      return true;
    }
    if ("MontantIFMIPE".equals(pElementName)) {
      return true;
    }
    if ("MontantICCP".equals(pElementName)) {
      return true;
    }
    if ("SalaireNet".equals(pElementName)) {
      return true;
    }
    if ("QteTravail".equals(pElementName)) {
      return true;
    }
    if ("MontantPrecompteAC".equals(pElementName)) {
      return true;
    }
    if ("IdDocumentNumerique".equals(pElementName)) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _FluxBS
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */