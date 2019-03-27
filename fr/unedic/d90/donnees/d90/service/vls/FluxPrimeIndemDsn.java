package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;

public abstract class FluxPrimeIndemDsn
{
  public static FluxPrimeIndemDsn getInstance()
  {
    return new _FluxPrimeIndemDsnImpl();
  }
  
  public abstract boolean isEnErreur();
  
  public abstract String getIdentifiant();
  
  public abstract void setIdentifiant(String paramString);
  
  public abstract String getCodeEtat();
  
  public abstract void setCodeEtat(String paramString);
  
  public abstract String getTypeEnreg();
  
  public abstract void setTypeEnreg(String paramString);
  
  public abstract String getCodeErreurTypeEnreg();
  
  public abstract void setCodeErreurTypeEnreg(String paramString);
  
  public abstract String getNumNIRCertifie();
  
  public abstract void setNumNIRCertifie(String paramString);
  
  public abstract String getCodeErreurNumNIRCertifie();
  
  public abstract void setCodeErreurNumNIRCertifie(String paramString);
  
  public abstract String getNomDeclare();
  
  public abstract void setNomDeclare(String paramString);
  
  public abstract String getCodeErreurNomDeclare();
  
  public abstract void setCodeErreurNomDeclare(String paramString);
  
  public abstract String getPrenomDeclare();
  
  public abstract void setPrenomDeclare(String paramString);
  
  public abstract String getCodeErreurPrenomDeclare();
  
  public abstract void setCodeErreurPrenomDeclare(String paramString);
  
  public abstract Damj getDateNaissance();
  
  public abstract void setDateNaissance(Damj paramDamj);
  
  public abstract String getCodeErreurDateNaissance();
  
  public abstract void setCodeErreurDateNaissance(String paramString);
  
  public abstract String getContexteEmission();
  
  public abstract void setContexteEmission(String paramString);
  
  public abstract String getCodeErreurContexteEmission();
  
  public abstract void setCodeErreurContexteEmission(String paramString);
  
  public abstract String getCodeMessage();
  
  public abstract void setCodeMessage(String paramString);
  
  public abstract String getCodeErreurCodeMessage();
  
  public abstract void setCodeErreurCodeMessage(String paramString);
  
  public abstract BigDecimal getNumeroVersion();
  
  public abstract void setNumeroVersion(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurNumeroVersion();
  
  public abstract void setCodeErreurNumeroVersion(String paramString);
  
  public abstract BigDecimal getNumeroSousVersion();
  
  public abstract void setNumeroSousVersion(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurNumeroSousVersion();
  
  public abstract void setCodeErreurNumeroSousVersion(String paramString);
  
  public abstract String getCodeAction();
  
  public abstract void setCodeAction(String paramString);
  
  public abstract String getCodeErreurCodeAction();
  
  public abstract void setCodeErreurCodeAction(String paramString);
  
  public abstract BigDecimal getIdTechnique();
  
  public abstract void setIdTechnique(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurIdTechnique();
  
  public abstract void setCodeErreurIdTechnique(String paramString);
  
  public abstract String getNumeroRCI();
  
  public abstract void setNumeroRCI(String paramString);
  
  public abstract String getCodeErreurNumeroRCI();
  
  public abstract void setCodeErreurNumeroRCI(String paramString);
  
  public abstract String getCxass();
  
  public abstract void setCxass(String paramString);
  
  public abstract String getCodeErreurCxass();
  
  public abstract void setCodeErreurCxass(String paramString);
  
  public abstract String getRsin();
  
  public abstract void setRsin(String paramString);
  
  public abstract String getCodeErreurRsin();
  
  public abstract void setCodeErreurRsin(String paramString);
  
  public abstract ListeFluxPrimeIndemVerseesDsn getListeFluxPrimeIndemVerseesDsn();
  
  /**
   * @deprecated
   */
  public abstract ListeFluxPrimeIndemVerseesDsn getListeFluxPrimIndemVerseesDsn();
  
  public abstract void setListeFluxPrimeIndemVerseesDsn(ListeFluxPrimeIndemVerseesDsn paramListeFluxPrimeIndemVerseesDsn);
  
  public abstract void setListeFluxPrimIndemVerseesDsn(ListeFluxPrimeIndemVerseesDsn paramListeFluxPrimeIndemVerseesDsn);
  
  public abstract ListeFluxPrimeIndemVerseesDsn setNewListeFluxPrimeIndemVerseesDsn();
  
  /**
   * @deprecated
   */
  public abstract ListeFluxPrimeIndemVerseesDsn setNewListeFluxPrimIndemVerseesDsn();
  
  public abstract String getIdFlux();
  
  public abstract void setIdFlux(String paramString);
  
  public abstract String getCodeErreurIdFlux();
  
  public abstract void setCodeErreurIdFlux(String paramString);
}

/* Location:
 * Qualified Name:     FluxPrimeIndemDsn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */