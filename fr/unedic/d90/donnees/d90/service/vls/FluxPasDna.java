package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;

public abstract class FluxPasDna
{
  public static FluxPasDna getInstance()
  {
    return new _FluxPasDnaImpl();
  }
  
  public abstract boolean isEnErreur();
  
  public abstract String getIdentifiant();
  
  public abstract void setIdentifiant(String paramString);
  
  public abstract String getCodeEtat();
  
  public abstract void setCodeEtat(String paramString);
  
  public abstract ListeFluxPasDnaQuantiteTravail getListeFluxPasDnaQuantiteTravail();
  
  public abstract void setListeFluxPasDnaQuantiteTravail(ListeFluxPasDnaQuantiteTravail paramListeFluxPasDnaQuantiteTravail);
  
  public abstract ListeFluxPasDnaQuantiteTravail setNewListeFluxPasDnaQuantiteTravail();
  
  public abstract ListeFluxPasDnaPeriodesPrime getListeFluxPasDnaPeriodesPrime();
  
  public abstract void setListeFluxPasDnaPeriodesPrime(ListeFluxPasDnaPeriodesPrime paramListeFluxPasDnaPeriodesPrime);
  
  public abstract ListeFluxPasDnaPeriodesPrime setNewListeFluxPasDnaPeriodesPrime();
  
  public abstract String getCodeMessage();
  
  public abstract void setCodeMessage(String paramString);
  
  public abstract String getCodeErreurCodeMessage();
  
  public abstract void setCodeErreurCodeMessage(String paramString);
  
  public abstract String getReferenceContrat();
  
  public abstract void setReferenceContrat(String paramString);
  
  public abstract String getCodeErreurReferenceContrat();
  
  public abstract void setCodeErreurReferenceContrat(String paramString);
  
  public abstract String getUniteAbsence();
  
  public abstract void setUniteAbsence(String paramString);
  
  public abstract String getCodeErreurUniteAbsence();
  
  public abstract void setCodeErreurUniteAbsence(String paramString);
  
  public abstract String getPeriodiciteHoraireTravail();
  
  public abstract void setPeriodiciteHoraireTravail(String paramString);
  
  public abstract String getCodeErreurPeriodiciteHoraireTravail();
  
  public abstract void setCodeErreurPeriodiciteHoraireTravail(String paramString);
  
  public abstract String getCategorieEmploiParticulier();
  
  public abstract void setCategorieEmploiParticulier(String paramString);
  
  public abstract String getCodeErreurCategorieEmploiParticulier();
  
  public abstract void setCodeErreurCategorieEmploiParticulier(String paramString);
  
  public abstract String getCodeMetierPCS();
  
  public abstract void setCodeMetierPCS(String paramString);
  
  public abstract String getCodeErreurCodeMetierPCS();
  
  public abstract void setCodeErreurCodeMetierPCS(String paramString);
  
  public abstract String getAbonnementProvisoire();
  
  public abstract void setAbonnementProvisoire(String paramString);
  
  public abstract String getCodeErreurAbonnementProvisoire();
  
  public abstract void setCodeErreurAbonnementProvisoire(String paramString);
  
  public abstract String getUniteIntensite();
  
  public abstract void setUniteIntensite(String paramString);
  
  public abstract String getCodeErreurUniteIntensite();
  
  public abstract void setCodeErreurUniteIntensite(String paramString);
  
  public abstract String getNomFamille();
  
  public abstract void setNomFamille(String paramString);
  
  public abstract String getCodeErreurNomFamille();
  
  public abstract void setCodeErreurNomFamille(String paramString);
  
  public abstract String getPrenom();
  
  public abstract void setPrenom(String paramString);
  
  public abstract String getCodeErreurPrenom();
  
  public abstract void setCodeErreurPrenom(String paramString);
  
  public abstract String getIndicSalaireBrut();
  
  public abstract void setIndicSalaireBrut(String paramString);
  
  public abstract String getCodeErreurIndicSalaireBrut();
  
  public abstract void setCodeErreurIndicSalaireBrut(String paramString);
  
  public abstract String getIndicPrecompte();
  
  public abstract void setIndicPrecompte(String paramString);
  
  public abstract String getCodeErreurIndicPrecompte();
  
  public abstract void setCodeErreurIndicPrecompte(String paramString);
  
  public abstract String getFillerUn();
  
  public abstract void setFillerUn(String paramString);
  
  public abstract String getCodeErreurFillerUn();
  
  public abstract void setCodeErreurFillerUn(String paramString);
  
  public abstract String getFillerDeux();
  
  public abstract void setFillerDeux(String paramString);
  
  public abstract String getCodeErreurFillerDeux();
  
  public abstract void setCodeErreurFillerDeux(String paramString);
  
  public abstract String getFonctionPublique();
  
  public abstract void setFonctionPublique(String paramString);
  
  public abstract String getCodeErreurFonctionPublique();
  
  public abstract void setCodeErreurFonctionPublique(String paramString);
  
  public abstract Damj getDateDebutPeriode();
  
  public abstract void setDateDebutPeriode(Damj paramDamj);
  
  public abstract String getCodeErreurDateDebutPeriode();
  
  public abstract void setCodeErreurDateDebutPeriode(String paramString);
  
  public abstract Damj getDateFinPeriode();
  
  public abstract void setDateFinPeriode(Damj paramDamj);
  
  public abstract String getCodeErreurDateFinPeriode();
  
  public abstract void setCodeErreurDateFinPeriode(String paramString);
  
  public abstract Damj getDateVersementSalaire();
  
  public abstract void setDateVersementSalaire(Damj paramDamj);
  
  public abstract String getCodeErreurDateVersementSalaire();
  
  public abstract void setCodeErreurDateVersementSalaire(String paramString);
  
  public abstract BigDecimal getNumeroVersion();
  
  public abstract void setNumeroVersion(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurNumeroVersion();
  
  public abstract void setCodeErreurNumeroVersion(String paramString);
  
  public abstract BigDecimal getSalaireBrutAbattu();
  
  public abstract void setSalaireBrutAbattu(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurSalaireBrutAbattu();
  
  public abstract void setCodeErreurSalaireBrutAbattu(String paramString);
  
  public abstract BigDecimal getMontantPrecompteAC();
  
  public abstract void setMontantPrecompteAC(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurMontantPrecompteAC();
  
  public abstract void setCodeErreurMontantPrecompteAC(String paramString);
  
  public abstract BigDecimal getQuantiteAbsence();
  
  public abstract void setQuantiteAbsence(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurQuantiteAbsence();
  
  public abstract void setCodeErreurQuantiteAbsence(String paramString);
  
  public abstract BigDecimal getHoraireSalarie();
  
  public abstract void setHoraireSalarie(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurHoraireSalarie();
  
  public abstract void setCodeErreurHoraireSalarie(String paramString);
  
  public abstract BigDecimal getHoraireEntreprise();
  
  public abstract void setHoraireEntreprise(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurHoraireEntreprise();
  
  public abstract void setCodeErreurHoraireEntreprise(String paramString);
  
  public abstract BigDecimal getIdTechPasDna();
  
  public abstract void setIdTechPasDna(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurIdTechPasDna();
  
  public abstract void setCodeErreurIdTechPasDna(String paramString);
  
  public abstract BigDecimal getIdTechContratDna();
  
  public abstract void setIdTechContratDna(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurIdTechContratDna();
  
  public abstract void setCodeErreurIdTechContratDna(String paramString);
}

/* Location:
 * Qualified Name:     FluxPasDna
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */