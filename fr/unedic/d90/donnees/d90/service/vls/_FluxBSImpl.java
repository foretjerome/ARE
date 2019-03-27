package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import fr.unedic.util.temps.Damj;
import java.io.Serializable;
import java.math.BigDecimal;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _FluxBSImpl
  extends FluxBS
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _FluxBS m_fluxBSInfra;
  
  public _FluxBSImpl()
  {
    m_fluxBSInfra = new _FluxBS();
  }
  
  public _FluxBSImpl(_FluxBS pValeur)
  {
    ExceptionUtil.assertMethodParamNotNull("FluxBSInfra", pValeur);
    
    m_fluxBSInfra = pValeur;
  }
  
  public Object getObjet()
  {
    return m_fluxBSInfra;
  }
  
  public String getIdentifiant()
  {
    return m_fluxBSInfra.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_fluxBSInfra.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_fluxBSInfra.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_fluxBSInfra.set_C_ETAT(pCode);
  }
  
  public String getBneIdentifiantBne()
  {
    return m_fluxBSInfra.getBneIdentifiantBne();
  }
  
  public String getCodeErreurBneIdentifiantBne()
  {
    return m_fluxBSInfra.getBneIdentifiantBne_C_ERR();
  }
  
  public void setBneIdentifiantBne(String pValeur)
  {
    m_fluxBSInfra.setBneIdentifiantBne(pValeur);
  }
  
  public void setCodeErreurBneIdentifiantBne(String pCodeErreur)
  {
    m_fluxBSInfra.setBneIdentifiantBne_C_ERR(pCodeErreur);
  }
  
  public String getBneSiret()
  {
    return m_fluxBSInfra.getBneSiret();
  }
  
  public String getCodeErreurBneSiret()
  {
    return m_fluxBSInfra.getBneSiret_C_ERR();
  }
  
  public void setBneSiret(String pValeur)
  {
    m_fluxBSInfra.setBneSiret(pValeur);
  }
  
  public void setCodeErreurBneSiret(String pCodeErreur)
  {
    m_fluxBSInfra.setBneSiret_C_ERR(pCodeErreur);
  }
  
  public String getBneRaisonSociale()
  {
    return m_fluxBSInfra.getBneRaisonSociale();
  }
  
  public String getCodeErreurBneRaisonSociale()
  {
    return m_fluxBSInfra.getBneRaisonSociale_C_ERR();
  }
  
  public void setBneRaisonSociale(String pValeur)
  {
    m_fluxBSInfra.setBneRaisonSociale(pValeur);
  }
  
  public void setCodeErreurBneRaisonSociale(String pCodeErreur)
  {
    m_fluxBSInfra.setBneRaisonSociale_C_ERR(pCodeErreur);
  }
  
  public String getBneNumeroVoirie()
  {
    return m_fluxBSInfra.getBneNumeroVoirie();
  }
  
  public String getCodeErreurBneNumeroVoirie()
  {
    return m_fluxBSInfra.getBneNumeroVoirie_C_ERR();
  }
  
  public void setBneNumeroVoirie(String pValeur)
  {
    m_fluxBSInfra.setBneNumeroVoirie(pValeur);
  }
  
  public void setCodeErreurBneNumeroVoirie(String pCodeErreur)
  {
    m_fluxBSInfra.setBneNumeroVoirie_C_ERR(pCodeErreur);
  }
  
  public String getBneLibelleVoieAdresse()
  {
    return m_fluxBSInfra.getBneLibelleVoieAdresse();
  }
  
  public String getCodeErreurBneLibelleVoieAdresse()
  {
    return m_fluxBSInfra.getBneLibelleVoieAdresse_C_ERR();
  }
  
  public void setBneLibelleVoieAdresse(String pValeur)
  {
    m_fluxBSInfra.setBneLibelleVoieAdresse(pValeur);
  }
  
  public void setCodeErreurBneLibelleVoieAdresse(String pCodeErreur)
  {
    m_fluxBSInfra.setBneLibelleVoieAdresse_C_ERR(pCodeErreur);
  }
  
  public String getBneComplAdresse()
  {
    return m_fluxBSInfra.getBneComplAdresse();
  }
  
  public String getCodeErreurBneComplAdresse()
  {
    return m_fluxBSInfra.getBneComplAdresse_C_ERR();
  }
  
  public void setBneComplAdresse(String pValeur)
  {
    m_fluxBSInfra.setBneComplAdresse(pValeur);
  }
  
  public void setCodeErreurBneComplAdresse(String pCodeErreur)
  {
    m_fluxBSInfra.setBneComplAdresse_C_ERR(pCodeErreur);
  }
  
  public String getBneCodePostal()
  {
    return m_fluxBSInfra.getBneCodePostal();
  }
  
  public String getCodeErreurBneCodePostal()
  {
    return m_fluxBSInfra.getBneCodePostal_C_ERR();
  }
  
  public void setBneCodePostal(String pValeur)
  {
    m_fluxBSInfra.setBneCodePostal(pValeur);
  }
  
  public void setCodeErreurBneCodePostal(String pCodeErreur)
  {
    m_fluxBSInfra.setBneCodePostal_C_ERR(pCodeErreur);
  }
  
  public String getBneLibelleCommune()
  {
    return m_fluxBSInfra.getBneLibelleCommune();
  }
  
  public String getCodeErreurBneLibelleCommune()
  {
    return m_fluxBSInfra.getBneLibelleCommune_C_ERR();
  }
  
  public void setBneLibelleCommune(String pValeur)
  {
    m_fluxBSInfra.setBneLibelleCommune(pValeur);
  }
  
  public void setCodeErreurBneLibelleCommune(String pCodeErreur)
  {
    m_fluxBSInfra.setBneLibelleCommune_C_ERR(pCodeErreur);
  }
  
  public String getBneAssedicAffiliation()
  {
    return m_fluxBSInfra.getBneAssedicAffiliation();
  }
  
  public String getCodeErreurBneAssedicAffiliation()
  {
    return m_fluxBSInfra.getBneAssedicAffiliation_C_ERR();
  }
  
  public void setBneAssedicAffiliation(String pValeur)
  {
    m_fluxBSInfra.setBneAssedicAffiliation(pValeur);
  }
  
  public void setCodeErreurBneAssedicAffiliation(String pCodeErreur)
  {
    m_fluxBSInfra.setBneAssedicAffiliation_C_ERR(pCodeErreur);
  }
  
  public String getBneNumAffiliation()
  {
    return m_fluxBSInfra.getBneNumAffiliation();
  }
  
  public String getCodeErreurBneNumAffiliation()
  {
    return m_fluxBSInfra.getBneNumAffiliation_C_ERR();
  }
  
  public void setBneNumAffiliation(String pValeur)
  {
    m_fluxBSInfra.setBneNumAffiliation(pValeur);
  }
  
  public void setCodeErreurBneNumAffiliation(String pCodeErreur)
  {
    m_fluxBSInfra.setBneNumAffiliation_C_ERR(pCodeErreur);
  }
  
  public String getCodeAssedic()
  {
    return m_fluxBSInfra.getCodeAssedic();
  }
  
  public String getCodeErreurCodeAssedic()
  {
    return m_fluxBSInfra.getCodeAssedic_C_ERR();
  }
  
  public void setCodeAssedic(String pValeur)
  {
    m_fluxBSInfra.setCodeAssedic(pValeur);
  }
  
  public void setCodeErreurCodeAssedic(String pCodeErreur)
  {
    m_fluxBSInfra.setCodeAssedic_C_ERR(pCodeErreur);
  }
  
  public String getNIR()
  {
    return m_fluxBSInfra.getNIR();
  }
  
  public String getCodeErreurNIR()
  {
    return m_fluxBSInfra.getNIR_C_ERR();
  }
  
  public void setNIR(String pValeur)
  {
    m_fluxBSInfra.setNIR(pValeur);
  }
  
  public void setCodeErreurNIR(String pCodeErreur)
  {
    m_fluxBSInfra.setNIR_C_ERR(pCodeErreur);
  }
  
  public String getTypeEnregistrement()
  {
    return m_fluxBSInfra.getTypeEnregistrement();
  }
  
  public String getCodeErreurTypeEnregistrement()
  {
    return m_fluxBSInfra.getTypeEnregistrement_C_ERR();
  }
  
  public void setTypeEnregistrement(String pValeur)
  {
    m_fluxBSInfra.setTypeEnregistrement(pValeur);
  }
  
  public void setCodeErreurTypeEnregistrement(String pCodeErreur)
  {
    m_fluxBSInfra.setTypeEnregistrement_C_ERR(pCodeErreur);
  }
  
  public String getCodeMonnaieSalaire()
  {
    return m_fluxBSInfra.getCodeMonnaieSalaire();
  }
  
  public String getCodeErreurCodeMonnaieSalaire()
  {
    return m_fluxBSInfra.getCodeMonnaieSalaire_C_ERR();
  }
  
  public void setCodeMonnaieSalaire(String pValeur)
  {
    m_fluxBSInfra.setCodeMonnaieSalaire(pValeur);
  }
  
  public void setCodeErreurCodeMonnaieSalaire(String pCodeErreur)
  {
    m_fluxBSInfra.setCodeMonnaieSalaire_C_ERR(pCodeErreur);
  }
  
  public String getCodeIntermittent()
  {
    return m_fluxBSInfra.getCodeIntermittent();
  }
  
  public String getCodeErreurCodeIntermittent()
  {
    return m_fluxBSInfra.getCodeIntermittent_C_ERR();
  }
  
  public void setCodeIntermittent(String pValeur)
  {
    m_fluxBSInfra.setCodeIntermittent(pValeur);
  }
  
  public void setCodeErreurCodeIntermittent(String pCodeErreur)
  {
    m_fluxBSInfra.setCodeIntermittent_C_ERR(pCodeErreur);
  }
  
  public String getReferenceEmployeur()
  {
    return m_fluxBSInfra.getReferenceEmployeur();
  }
  
  public String getCodeErreurReferenceEmployeur()
  {
    return m_fluxBSInfra.getReferenceEmployeur_C_ERR();
  }
  
  public void setReferenceEmployeur(String pValeur)
  {
    m_fluxBSInfra.setReferenceEmployeur(pValeur);
  }
  
  public void setCodeErreurReferenceEmployeur(String pCodeErreur)
  {
    m_fluxBSInfra.setReferenceEmployeur_C_ERR(pCodeErreur);
  }
  
  public String getCodePostalEmployeur()
  {
    return m_fluxBSInfra.getCodePostalEmployeur();
  }
  
  public String getCodeErreurCodePostalEmployeur()
  {
    return m_fluxBSInfra.getCodePostalEmployeur_C_ERR();
  }
  
  public void setCodePostalEmployeur(String pValeur)
  {
    m_fluxBSInfra.setCodePostalEmployeur(pValeur);
  }
  
  public void setCodeErreurCodePostalEmployeur(String pCodeErreur)
  {
    m_fluxBSInfra.setCodePostalEmployeur_C_ERR(pCodeErreur);
  }
  
  public String getCodeInformationEmployeur()
  {
    return m_fluxBSInfra.getCodeInformationEmployeur();
  }
  
  public String getCodeErreurCodeInformationEmployeur()
  {
    return m_fluxBSInfra.getCodeInformationEmployeur_C_ERR();
  }
  
  public void setCodeInformationEmployeur(String pValeur)
  {
    m_fluxBSInfra.setCodeInformationEmployeur(pValeur);
  }
  
  public void setCodeErreurCodeInformationEmployeur(String pCodeErreur)
  {
    m_fluxBSInfra.setCodeInformationEmployeur_C_ERR(pCodeErreur);
  }
  
  public String getCocheAlsaceMoselle()
  {
    return m_fluxBSInfra.getCocheAlsaceMoselle();
  }
  
  public String getCodeErreurCocheAlsaceMoselle()
  {
    return m_fluxBSInfra.getCocheAlsaceMoselle_C_ERR();
  }
  
  public void setCocheAlsaceMoselle(String pValeur)
  {
    m_fluxBSInfra.setCocheAlsaceMoselle(pValeur);
  }
  
  public void setCodeErreurCocheAlsaceMoselle(String pCodeErreur)
  {
    m_fluxBSInfra.setCocheAlsaceMoselle_C_ERR(pCodeErreur);
  }
  
  public String getUniteTravail()
  {
    return m_fluxBSInfra.getUniteTravail();
  }
  
  public String getCodeErreurUniteTravail()
  {
    return m_fluxBSInfra.getUniteTravail_C_ERR();
  }
  
  public void setUniteTravail(String pValeur)
  {
    m_fluxBSInfra.setUniteTravail(pValeur);
  }
  
  public void setCodeErreurUniteTravail(String pCodeErreur)
  {
    m_fluxBSInfra.setUniteTravail_C_ERR(pCodeErreur);
  }
  
  public String getSituationParticuliere()
  {
    return m_fluxBSInfra.getSituationParticuliere();
  }
  
  public String getCodeErreurSituationParticuliere()
  {
    return m_fluxBSInfra.getSituationParticuliere_C_ERR();
  }
  
  public void setSituationParticuliere(String pValeur)
  {
    m_fluxBSInfra.setSituationParticuliere(pValeur);
  }
  
  public void setCodeErreurSituationParticuliere(String pCodeErreur)
  {
    m_fluxBSInfra.setSituationParticuliere_C_ERR(pCodeErreur);
  }
  
  public Damj getDateDebutPeriode()
  {
    return m_fluxBSInfra.getDateDebutPeriode();
  }
  
  public String getCodeErreurDateDebutPeriode()
  {
    return m_fluxBSInfra.getDateDebutPeriode_C_ERR();
  }
  
  public void setDateDebutPeriode(Damj pValeur)
  {
    m_fluxBSInfra.setDateDebutPeriode(pValeur);
  }
  
  public void setCodeErreurDateDebutPeriode(String pCodeErreur)
  {
    m_fluxBSInfra.setDateDebutPeriode_C_ERR(pCodeErreur);
  }
  
  public Damj getDateFinPeriode()
  {
    return m_fluxBSInfra.getDateFinPeriode();
  }
  
  public String getCodeErreurDateFinPeriode()
  {
    return m_fluxBSInfra.getDateFinPeriode_C_ERR();
  }
  
  public void setDateFinPeriode(Damj pValeur)
  {
    m_fluxBSInfra.setDateFinPeriode(pValeur);
  }
  
  public void setCodeErreurDateFinPeriode(String pCodeErreur)
  {
    m_fluxBSInfra.setDateFinPeriode_C_ERR(pCodeErreur);
  }
  
  public Damj getDateFichierExterne()
  {
    return m_fluxBSInfra.getDateFichierExterne();
  }
  
  public String getCodeErreurDateFichierExterne()
  {
    return m_fluxBSInfra.getDateFichierExterne_C_ERR();
  }
  
  public void setDateFichierExterne(Damj pValeur)
  {
    m_fluxBSInfra.setDateFichierExterne(pValeur);
  }
  
  public void setCodeErreurDateFichierExterne(String pCodeErreur)
  {
    m_fluxBSInfra.setDateFichierExterne_C_ERR(pCodeErreur);
  }
  
  public Damj getDateSignature()
  {
    return m_fluxBSInfra.getDateSignature();
  }
  
  public String getCodeErreurDateSignature()
  {
    return m_fluxBSInfra.getDateSignature_C_ERR();
  }
  
  public void setDateSignature(Damj pValeur)
  {
    m_fluxBSInfra.setDateSignature(pValeur);
  }
  
  public void setCodeErreurDateSignature(String pCodeErreur)
  {
    m_fluxBSInfra.setDateSignature_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getSalaireBrutAbattu()
  {
    return m_fluxBSInfra.getSalaireBrutAbattu();
  }
  
  public String getCodeErreurSalaireBrutAbattu()
  {
    return m_fluxBSInfra.getSalaireBrutAbattu_C_ERR();
  }
  
  public void setSalaireBrutAbattu(BigDecimal pValeur)
  {
    m_fluxBSInfra.setSalaireBrutAbattu(pValeur);
  }
  
  public void setCodeErreurSalaireBrutAbattu(String pCodeErreur)
  {
    m_fluxBSInfra.setSalaireBrutAbattu_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getPrime()
  {
    return m_fluxBSInfra.getPrime();
  }
  
  public String getCodeErreurPrime()
  {
    return m_fluxBSInfra.getPrime_C_ERR();
  }
  
  public void setPrime(BigDecimal pValeur)
  {
    m_fluxBSInfra.setPrime(pValeur);
  }
  
  public void setCodeErreurPrime(String pCodeErreur)
  {
    m_fluxBSInfra.setPrime_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getMontantIFMIPE()
  {
    return m_fluxBSInfra.getMontantIFMIPE();
  }
  
  public String getCodeErreurMontantIFMIPE()
  {
    return m_fluxBSInfra.getMontantIFMIPE_C_ERR();
  }
  
  public void setMontantIFMIPE(BigDecimal pValeur)
  {
    m_fluxBSInfra.setMontantIFMIPE(pValeur);
  }
  
  public void setCodeErreurMontantIFMIPE(String pCodeErreur)
  {
    m_fluxBSInfra.setMontantIFMIPE_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getMontantICCP()
  {
    return m_fluxBSInfra.getMontantICCP();
  }
  
  public String getCodeErreurMontantICCP()
  {
    return m_fluxBSInfra.getMontantICCP_C_ERR();
  }
  
  public void setMontantICCP(BigDecimal pValeur)
  {
    m_fluxBSInfra.setMontantICCP(pValeur);
  }
  
  public void setCodeErreurMontantICCP(String pCodeErreur)
  {
    m_fluxBSInfra.setMontantICCP_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getSalaireNet()
  {
    return m_fluxBSInfra.getSalaireNet();
  }
  
  public String getCodeErreurSalaireNet()
  {
    return m_fluxBSInfra.getSalaireNet_C_ERR();
  }
  
  public void setSalaireNet(BigDecimal pValeur)
  {
    m_fluxBSInfra.setSalaireNet(pValeur);
  }
  
  public void setCodeErreurSalaireNet(String pCodeErreur)
  {
    m_fluxBSInfra.setSalaireNet_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getQteTravail()
  {
    return m_fluxBSInfra.getQteTravail();
  }
  
  public String getCodeErreurQteTravail()
  {
    return m_fluxBSInfra.getQteTravail_C_ERR();
  }
  
  public void setQteTravail(BigDecimal pValeur)
  {
    m_fluxBSInfra.setQteTravail(pValeur);
  }
  
  public void setCodeErreurQteTravail(String pCodeErreur)
  {
    m_fluxBSInfra.setQteTravail_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getMontantPrecompteAC()
  {
    return m_fluxBSInfra.getMontantPrecompteAC();
  }
  
  public String getCodeErreurMontantPrecompteAC()
  {
    return m_fluxBSInfra.getMontantPrecompteAC_C_ERR();
  }
  
  public void setMontantPrecompteAC(BigDecimal pValeur)
  {
    m_fluxBSInfra.setMontantPrecompteAC(pValeur);
  }
  
  public void setCodeErreurMontantPrecompteAC(String pCodeErreur)
  {
    m_fluxBSInfra.setMontantPrecompteAC_C_ERR(pCodeErreur);
  }
  
  public String getIdDocumentNumerique()
  {
    return m_fluxBSInfra.getIdDocumentNumerique();
  }
  
  public String getCodeErreurIdDocumentNumerique()
  {
    return m_fluxBSInfra.getIdDocumentNumerique_C_ERR();
  }
  
  public void setIdDocumentNumerique(String pValeur)
  {
    m_fluxBSInfra.setIdDocumentNumerique(pValeur);
  }
  
  public void setCodeErreurIdDocumentNumerique(String pCodeErreur)
  {
    m_fluxBSInfra.setIdDocumentNumerique_C_ERR(pCodeErreur);
  }
  
  public _FluxBS getFluxBSInfra()
  {
    return m_fluxBSInfra;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    if ((getCodeErreurBneIdentifiantBne() != null) && 
      ("".equals(getCodeErreurBneIdentifiantBne()))) {
      return true;
    }
    if ((getCodeErreurBneSiret() != null) && 
      ("".equals(getCodeErreurBneSiret()))) {
      return true;
    }
    if ((getCodeErreurBneRaisonSociale() != null) && 
      ("".equals(getCodeErreurBneRaisonSociale()))) {
      return true;
    }
    if ((getCodeErreurBneNumeroVoirie() != null) && 
      ("".equals(getCodeErreurBneNumeroVoirie()))) {
      return true;
    }
    if ((getCodeErreurBneLibelleVoieAdresse() != null) && 
      ("".equals(getCodeErreurBneLibelleVoieAdresse()))) {
      return true;
    }
    if ((getCodeErreurBneComplAdresse() != null) && 
      ("".equals(getCodeErreurBneComplAdresse()))) {
      return true;
    }
    if ((getCodeErreurBneCodePostal() != null) && 
      ("".equals(getCodeErreurBneCodePostal()))) {
      return true;
    }
    if ((getCodeErreurBneLibelleCommune() != null) && 
      ("".equals(getCodeErreurBneLibelleCommune()))) {
      return true;
    }
    if ((getCodeErreurBneAssedicAffiliation() != null) && 
      ("".equals(getCodeErreurBneAssedicAffiliation()))) {
      return true;
    }
    if ((getCodeErreurBneNumAffiliation() != null) && 
      ("".equals(getCodeErreurBneNumAffiliation()))) {
      return true;
    }
    if ((getCodeErreurCodeAssedic() != null) && 
      ("".equals(getCodeErreurCodeAssedic()))) {
      return true;
    }
    if ((getCodeErreurNIR() != null) && 
      ("".equals(getCodeErreurNIR()))) {
      return true;
    }
    if ((getCodeErreurTypeEnregistrement() != null) && 
      ("".equals(getCodeErreurTypeEnregistrement()))) {
      return true;
    }
    if ((getCodeErreurCodeMonnaieSalaire() != null) && 
      ("".equals(getCodeErreurCodeMonnaieSalaire()))) {
      return true;
    }
    if ((getCodeErreurCodeIntermittent() != null) && 
      ("".equals(getCodeErreurCodeIntermittent()))) {
      return true;
    }
    if ((getCodeErreurReferenceEmployeur() != null) && 
      ("".equals(getCodeErreurReferenceEmployeur()))) {
      return true;
    }
    if ((getCodeErreurCodePostalEmployeur() != null) && 
      ("".equals(getCodeErreurCodePostalEmployeur()))) {
      return true;
    }
    if ((getCodeErreurCodeInformationEmployeur() != null) && 
      ("".equals(getCodeErreurCodeInformationEmployeur()))) {
      return true;
    }
    if ((getCodeErreurCocheAlsaceMoselle() != null) && 
      ("".equals(getCodeErreurCocheAlsaceMoselle()))) {
      return true;
    }
    if ((getCodeErreurUniteTravail() != null) && 
      ("".equals(getCodeErreurUniteTravail()))) {
      return true;
    }
    if ((getCodeErreurSituationParticuliere() != null) && 
      ("".equals(getCodeErreurSituationParticuliere()))) {
      return true;
    }
    if ((getCodeErreurDateDebutPeriode() != null) && 
      ("".equals(getCodeErreurDateDebutPeriode()))) {
      return true;
    }
    if ((getCodeErreurDateFinPeriode() != null) && 
      ("".equals(getCodeErreurDateFinPeriode()))) {
      return true;
    }
    if ((getCodeErreurDateFichierExterne() != null) && 
      ("".equals(getCodeErreurDateFichierExterne()))) {
      return true;
    }
    if ((getCodeErreurDateSignature() != null) && 
      ("".equals(getCodeErreurDateSignature()))) {
      return true;
    }
    if ((getCodeErreurSalaireBrutAbattu() != null) && 
      ("".equals(getCodeErreurSalaireBrutAbattu()))) {
      return true;
    }
    if ((getCodeErreurPrime() != null) && 
      ("".equals(getCodeErreurPrime()))) {
      return true;
    }
    if ((getCodeErreurMontantIFMIPE() != null) && 
      ("".equals(getCodeErreurMontantIFMIPE()))) {
      return true;
    }
    if ((getCodeErreurMontantICCP() != null) && 
      ("".equals(getCodeErreurMontantICCP()))) {
      return true;
    }
    if ((getCodeErreurSalaireNet() != null) && 
      ("".equals(getCodeErreurSalaireNet()))) {
      return true;
    }
    if ((getCodeErreurQteTravail() != null) && 
      ("".equals(getCodeErreurQteTravail()))) {
      return true;
    }
    if ((getCodeErreurMontantPrecompteAC() != null) && 
      ("".equals(getCodeErreurMontantPrecompteAC()))) {
      return true;
    }
    if ((getCodeErreurIdDocumentNumerique() != null) && 
      ("".equals(getCodeErreurIdDocumentNumerique()))) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _FluxBSImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */