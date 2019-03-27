package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;

public abstract class FluxETT
{
  public static FluxETT getInstance()
  {
    return new _FluxETTImpl();
  }
  
  public abstract boolean isEnErreur();
  
  public abstract String getIdentifiant();
  
  public abstract void setIdentifiant(String paramString);
  
  public abstract String getCodeEtat();
  
  public abstract void setCodeEtat(String paramString);
  
  public abstract String getNir();
  
  public abstract void setNir(String paramString);
  
  public abstract String getCodeErreurNir();
  
  public abstract void setCodeErreurNir(String paramString);
  
  public abstract String getNom();
  
  public abstract void setNom(String paramString);
  
  public abstract String getCodeErreurNom();
  
  public abstract void setCodeErreurNom(String paramString);
  
  public abstract String getPrenom();
  
  public abstract void setPrenom(String paramString);
  
  public abstract String getCodeErreurPrenom();
  
  public abstract void setCodeErreurPrenom(String paramString);
  
  public abstract String getCodeNationalite();
  
  public abstract void setCodeNationalite(String paramString);
  
  public abstract String getCodeErreurCodeNationalite();
  
  public abstract void setCodeErreurCodeNationalite(String paramString);
  
  public abstract String getCodePostal();
  
  public abstract void setCodePostal(String paramString);
  
  public abstract String getCodeErreurCodePostal();
  
  public abstract void setCodeErreurCodePostal(String paramString);
  
  public abstract String getIdentifiantBNE();
  
  public abstract void setIdentifiantBNE(String paramString);
  
  public abstract String getCodeErreurIdentifiantBNE();
  
  public abstract void setCodeErreurIdentifiantBNE(String paramString);
  
  public abstract String getSiret();
  
  public abstract void setSiret(String paramString);
  
  public abstract String getCodeErreurSiret();
  
  public abstract void setCodeErreurSiret(String paramString);
  
  public abstract String getRaisonSociale();
  
  public abstract void setRaisonSociale(String paramString);
  
  public abstract String getCodeErreurRaisonSociale();
  
  public abstract void setCodeErreurRaisonSociale(String paramString);
  
  public abstract String getNumeroVoie();
  
  public abstract void setNumeroVoie(String paramString);
  
  public abstract String getCodeErreurNumeroVoie();
  
  public abstract void setCodeErreurNumeroVoie(String paramString);
  
  public abstract String getLibelleVoie();
  
  public abstract void setLibelleVoie(String paramString);
  
  public abstract String getCodeErreurLibelleVoie();
  
  public abstract void setCodeErreurLibelleVoie(String paramString);
  
  public abstract String getComplementAdresse();
  
  public abstract void setComplementAdresse(String paramString);
  
  public abstract String getCodeErreurComplementAdresse();
  
  public abstract void setCodeErreurComplementAdresse(String paramString);
  
  public abstract String getCodePostalETT();
  
  public abstract void setCodePostalETT(String paramString);
  
  public abstract String getCodeErreurCodePostalETT();
  
  public abstract void setCodeErreurCodePostalETT(String paramString);
  
  public abstract String getLibelleCommuneCNAVTS();
  
  public abstract void setLibelleCommuneCNAVTS(String paramString);
  
  public abstract String getCodeErreurLibelleCommuneCNAVTS();
  
  public abstract void setCodeErreurLibelleCommuneCNAVTS(String paramString);
  
  public abstract String getIndicateurRappelSalaire();
  
  public abstract void setIndicateurRappelSalaire(String paramString);
  
  public abstract String getCodeErreurIndicateurRappelSalaire();
  
  public abstract void setCodeErreurIndicateurRappelSalaire(String paramString);
  
  public abstract String getCodeMonnaie();
  
  public abstract void setCodeMonnaie(String paramString);
  
  public abstract String getCodeErreurCodeMonnaie();
  
  public abstract void setCodeErreurCodeMonnaie(String paramString);
  
  public abstract String getMotifFinContrat();
  
  public abstract void setMotifFinContrat(String paramString);
  
  public abstract String getCodeErreurMotifFinContrat();
  
  public abstract void setCodeErreurMotifFinContrat(String paramString);
  
  public abstract String getNumeroContrat();
  
  public abstract void setNumeroContrat(String paramString);
  
  public abstract String getCodeErreurNumeroContrat();
  
  public abstract void setCodeErreurNumeroContrat(String paramString);
  
  public abstract String getCaisseAgirc();
  
  public abstract void setCaisseAgirc(String paramString);
  
  public abstract String getCodeErreurCaisseAgirc();
  
  public abstract void setCodeErreurCaisseAgirc(String paramString);
  
  public abstract String getCaisseArrco();
  
  public abstract void setCaisseArrco(String paramString);
  
  public abstract String getCodeErreurCaisseArrco();
  
  public abstract void setCodeErreurCaisseArrco(String paramString);
  
  public abstract String getCadre();
  
  public abstract void setCadre(String paramString);
  
  public abstract String getCodeErreurCadre();
  
  public abstract void setCodeErreurCadre(String paramString);
  
  public abstract String getDernierEmploiTenu();
  
  public abstract void setDernierEmploiTenu(String paramString);
  
  public abstract String getCodeErreurDernierEmploiTenu();
  
  public abstract void setCodeErreurDernierEmploiTenu(String paramString);
  
  public abstract String getNiveauQualification();
  
  public abstract void setNiveauQualification(String paramString);
  
  public abstract String getCodeErreurNiveauQualification();
  
  public abstract void setCodeErreurNiveauQualification(String paramString);
  
  public abstract String getIndicateurQualiteNIR();
  
  public abstract void setIndicateurQualiteNIR(String paramString);
  
  public abstract String getCodeErreurIndicateurQualiteNIR();
  
  public abstract void setCodeErreurIndicateurQualiteNIR(String paramString);
  
  public abstract String getLieuMission();
  
  public abstract void setLieuMission(String paramString);
  
  public abstract String getCodeErreurLieuMission();
  
  public abstract void setCodeErreurLieuMission(String paramString);
  
  public abstract String getFiller();
  
  public abstract void setFiller(String paramString);
  
  public abstract String getCodeErreurFiller();
  
  public abstract void setCodeErreurFiller(String paramString);
  
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
  
  public abstract String getBneRetraiteAgirc1();
  
  public abstract void setBneRetraiteAgirc1(String paramString);
  
  public abstract String getCodeErreurBneRetraiteAgirc1();
  
  public abstract void setCodeErreurBneRetraiteAgirc1(String paramString);
  
  public abstract String getBneRetraiteAgirc2();
  
  public abstract void setBneRetraiteAgirc2(String paramString);
  
  public abstract String getCodeErreurBneRetraiteAgirc2();
  
  public abstract void setCodeErreurBneRetraiteAgirc2(String paramString);
  
  public abstract String getBneLibelleRetraiteAgirc1();
  
  public abstract void setBneLibelleRetraiteAgirc1(String paramString);
  
  public abstract String getCodeErreurBneLibelleRetraiteAgirc1();
  
  public abstract void setCodeErreurBneLibelleRetraiteAgirc1(String paramString);
  
  public abstract String getBneLibelleRetraiteAgirc2();
  
  public abstract void setBneLibelleRetraiteAgirc2(String paramString);
  
  public abstract String getCodeErreurBneLibelleRetraiteAgirc2();
  
  public abstract void setCodeErreurBneLibelleRetraiteAgirc2(String paramString);
  
  public abstract String getBneIdentifiantBne();
  
  public abstract void setBneIdentifiantBne(String paramString);
  
  public abstract String getCodeErreurBneIdentifiantBne();
  
  public abstract void setCodeErreurBneIdentifiantBne(String paramString);
  
  public abstract String getIndicateurMontantIccp();
  
  public abstract void setIndicateurMontantIccp(String paramString);
  
  public abstract String getCodeErreurIndicateurMontantIccp();
  
  public abstract void setCodeErreurIndicateurMontantIccp(String paramString);
  
  public abstract String getIndicateurMotifFinContrat();
  
  public abstract void setIndicateurMotifFinContrat(String paramString);
  
  public abstract String getCodeErreurIndicateurMotifFinContrat();
  
  public abstract void setCodeErreurIndicateurMotifFinContrat(String paramString);
  
  public abstract String getIndicateurNombreHeuresMision();
  
  public abstract void setIndicateurNombreHeuresMision(String paramString);
  
  public abstract String getCodeErreurIndicateurNombreHeuresMision();
  
  public abstract void setCodeErreurIndicateurNombreHeuresMision(String paramString);
  
  public abstract String getIndicateurMontantIfm();
  
  public abstract void setIndicateurMontantIfm(String paramString);
  
  public abstract String getCodeErreurIndicateurMontantIfm();
  
  public abstract void setCodeErreurIndicateurMontantIfm(String paramString);
  
  public abstract String getIndicateurRappelMission();
  
  public abstract void setIndicateurRappelMission(String paramString);
  
  public abstract String getCodeErreurIndicateurRappelMission();
  
  public abstract void setCodeErreurIndicateurRappelMission(String paramString);
  
  public abstract String getIndicateurNouveauProtocole();
  
  public abstract void setIndicateurNouveauProtocole(String paramString);
  
  public abstract String getCodeErreurIndicateurNouveauProtocole();
  
  public abstract void setCodeErreurIndicateurNouveauProtocole(String paramString);
  
  public abstract Damj getDateNaissance();
  
  public abstract void setDateNaissance(Damj paramDamj);
  
  public abstract String getCodeErreurDateNaissance();
  
  public abstract void setCodeErreurDateNaissance(String paramString);
  
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
  
  public abstract Damj getDateTraitement();
  
  public abstract void setDateTraitement(Damj paramDamj);
  
  public abstract String getCodeErreurDateTraitement();
  
  public abstract void setCodeErreurDateTraitement(String paramString);
  
  public abstract BigDecimal getSieclePeriodeRef();
  
  public abstract void setSieclePeriodeRef(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurSieclePeriodeRef();
  
  public abstract void setCodeErreurSieclePeriodeRef(String paramString);
  
  public abstract BigDecimal getMoisPeriodeRef();
  
  public abstract void setMoisPeriodeRef(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurMoisPeriodeRef();
  
  public abstract void setCodeErreurMoisPeriodeRef(String paramString);
  
  public abstract BigDecimal getSalaireBrut();
  
  public abstract void setSalaireBrut(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurSalaireBrut();
  
  public abstract void setCodeErreurSalaireBrut(String paramString);
  
  public abstract BigDecimal getMontantIccp();
  
  public abstract void setMontantIccp(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurMontantIccp();
  
  public abstract void setCodeErreurMontantIccp(String paramString);
  
  public abstract BigDecimal getNombreHeuresMission();
  
  public abstract void setNombreHeuresMission(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurNombreHeuresMission();
  
  public abstract void setCodeErreurNombreHeuresMission(String paramString);
  
  public abstract BigDecimal getMontantIfm();
  
  public abstract void setMontantIfm(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurMontantIfm();
  
  public abstract void setCodeErreurMontantIfm(String paramString);
}

/* Location:
 * Qualified Name:     FluxETT
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */