package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;

public abstract class FluxBS
{
  public static FluxBS getInstance()
  {
    return new _FluxBSImpl();
  }
  
  public abstract boolean isEnErreur();
  
  public abstract String getIdentifiant();
  
  public abstract void setIdentifiant(String paramString);
  
  public abstract String getCodeEtat();
  
  public abstract void setCodeEtat(String paramString);
  
  public abstract String getBneIdentifiantBne();
  
  public abstract void setBneIdentifiantBne(String paramString);
  
  public abstract String getCodeErreurBneIdentifiantBne();
  
  public abstract void setCodeErreurBneIdentifiantBne(String paramString);
  
  public abstract String getBneSiret();
  
  public abstract void setBneSiret(String paramString);
  
  public abstract String getCodeErreurBneSiret();
  
  public abstract void setCodeErreurBneSiret(String paramString);
  
  public abstract String getBneRaisonSociale();
  
  public abstract void setBneRaisonSociale(String paramString);
  
  public abstract String getCodeErreurBneRaisonSociale();
  
  public abstract void setCodeErreurBneRaisonSociale(String paramString);
  
  public abstract String getBneNumeroVoirie();
  
  public abstract void setBneNumeroVoirie(String paramString);
  
  public abstract String getCodeErreurBneNumeroVoirie();
  
  public abstract void setCodeErreurBneNumeroVoirie(String paramString);
  
  public abstract String getBneLibelleVoieAdresse();
  
  public abstract void setBneLibelleVoieAdresse(String paramString);
  
  public abstract String getCodeErreurBneLibelleVoieAdresse();
  
  public abstract void setCodeErreurBneLibelleVoieAdresse(String paramString);
  
  public abstract String getBneComplAdresse();
  
  public abstract void setBneComplAdresse(String paramString);
  
  public abstract String getCodeErreurBneComplAdresse();
  
  public abstract void setCodeErreurBneComplAdresse(String paramString);
  
  public abstract String getBneCodePostal();
  
  public abstract void setBneCodePostal(String paramString);
  
  public abstract String getCodeErreurBneCodePostal();
  
  public abstract void setCodeErreurBneCodePostal(String paramString);
  
  public abstract String getBneLibelleCommune();
  
  public abstract void setBneLibelleCommune(String paramString);
  
  public abstract String getCodeErreurBneLibelleCommune();
  
  public abstract void setCodeErreurBneLibelleCommune(String paramString);
  
  public abstract String getBneAssedicAffiliation();
  
  public abstract void setBneAssedicAffiliation(String paramString);
  
  public abstract String getCodeErreurBneAssedicAffiliation();
  
  public abstract void setCodeErreurBneAssedicAffiliation(String paramString);
  
  public abstract String getBneNumAffiliation();
  
  public abstract void setBneNumAffiliation(String paramString);
  
  public abstract String getCodeErreurBneNumAffiliation();
  
  public abstract void setCodeErreurBneNumAffiliation(String paramString);
  
  public abstract String getCodeAssedic();
  
  public abstract void setCodeAssedic(String paramString);
  
  public abstract String getCodeErreurCodeAssedic();
  
  public abstract void setCodeErreurCodeAssedic(String paramString);
  
  public abstract String getNIR();
  
  public abstract void setNIR(String paramString);
  
  public abstract String getCodeErreurNIR();
  
  public abstract void setCodeErreurNIR(String paramString);
  
  public abstract String getTypeEnregistrement();
  
  public abstract void setTypeEnregistrement(String paramString);
  
  public abstract String getCodeErreurTypeEnregistrement();
  
  public abstract void setCodeErreurTypeEnregistrement(String paramString);
  
  public abstract String getCodeMonnaieSalaire();
  
  public abstract void setCodeMonnaieSalaire(String paramString);
  
  public abstract String getCodeErreurCodeMonnaieSalaire();
  
  public abstract void setCodeErreurCodeMonnaieSalaire(String paramString);
  
  public abstract String getCodeIntermittent();
  
  public abstract void setCodeIntermittent(String paramString);
  
  public abstract String getCodeErreurCodeIntermittent();
  
  public abstract void setCodeErreurCodeIntermittent(String paramString);
  
  public abstract String getReferenceEmployeur();
  
  public abstract void setReferenceEmployeur(String paramString);
  
  public abstract String getCodeErreurReferenceEmployeur();
  
  public abstract void setCodeErreurReferenceEmployeur(String paramString);
  
  public abstract String getCodePostalEmployeur();
  
  public abstract void setCodePostalEmployeur(String paramString);
  
  public abstract String getCodeErreurCodePostalEmployeur();
  
  public abstract void setCodeErreurCodePostalEmployeur(String paramString);
  
  public abstract String getCodeInformationEmployeur();
  
  public abstract void setCodeInformationEmployeur(String paramString);
  
  public abstract String getCodeErreurCodeInformationEmployeur();
  
  public abstract void setCodeErreurCodeInformationEmployeur(String paramString);
  
  public abstract String getCocheAlsaceMoselle();
  
  public abstract void setCocheAlsaceMoselle(String paramString);
  
  public abstract String getCodeErreurCocheAlsaceMoselle();
  
  public abstract void setCodeErreurCocheAlsaceMoselle(String paramString);
  
  public abstract String getUniteTravail();
  
  public abstract void setUniteTravail(String paramString);
  
  public abstract String getCodeErreurUniteTravail();
  
  public abstract void setCodeErreurUniteTravail(String paramString);
  
  public abstract String getSituationParticuliere();
  
  public abstract void setSituationParticuliere(String paramString);
  
  public abstract String getCodeErreurSituationParticuliere();
  
  public abstract void setCodeErreurSituationParticuliere(String paramString);
  
  public abstract Damj getDateDebutPeriode();
  
  public abstract void setDateDebutPeriode(Damj paramDamj);
  
  public abstract String getCodeErreurDateDebutPeriode();
  
  public abstract void setCodeErreurDateDebutPeriode(String paramString);
  
  public abstract Damj getDateFinPeriode();
  
  public abstract void setDateFinPeriode(Damj paramDamj);
  
  public abstract String getCodeErreurDateFinPeriode();
  
  public abstract void setCodeErreurDateFinPeriode(String paramString);
  
  public abstract Damj getDateFichierExterne();
  
  public abstract void setDateFichierExterne(Damj paramDamj);
  
  public abstract String getCodeErreurDateFichierExterne();
  
  public abstract void setCodeErreurDateFichierExterne(String paramString);
  
  public abstract Damj getDateSignature();
  
  public abstract void setDateSignature(Damj paramDamj);
  
  public abstract String getCodeErreurDateSignature();
  
  public abstract void setCodeErreurDateSignature(String paramString);
  
  public abstract BigDecimal getSalaireBrutAbattu();
  
  public abstract void setSalaireBrutAbattu(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurSalaireBrutAbattu();
  
  public abstract void setCodeErreurSalaireBrutAbattu(String paramString);
  
  public abstract BigDecimal getPrime();
  
  public abstract void setPrime(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurPrime();
  
  public abstract void setCodeErreurPrime(String paramString);
  
  public abstract BigDecimal getMontantIFMIPE();
  
  public abstract void setMontantIFMIPE(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurMontantIFMIPE();
  
  public abstract void setCodeErreurMontantIFMIPE(String paramString);
  
  public abstract BigDecimal getMontantICCP();
  
  public abstract void setMontantICCP(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurMontantICCP();
  
  public abstract void setCodeErreurMontantICCP(String paramString);
  
  public abstract BigDecimal getSalaireNet();
  
  public abstract void setSalaireNet(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurSalaireNet();
  
  public abstract void setCodeErreurSalaireNet(String paramString);
  
  public abstract BigDecimal getQteTravail();
  
  public abstract void setQteTravail(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurQteTravail();
  
  public abstract void setCodeErreurQteTravail(String paramString);
  
  public abstract BigDecimal getMontantPrecompteAC();
  
  public abstract void setMontantPrecompteAC(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurMontantPrecompteAC();
  
  public abstract void setCodeErreurMontantPrecompteAC(String paramString);
  
  public abstract String getIdDocumentNumerique();
  
  public abstract void setIdDocumentNumerique(String paramString);
  
  public abstract String getCodeErreurIdDocumentNumerique();
  
  public abstract void setCodeErreurIdDocumentNumerique(String paramString);
}

/* Location:
 * Qualified Name:     FluxBS
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */