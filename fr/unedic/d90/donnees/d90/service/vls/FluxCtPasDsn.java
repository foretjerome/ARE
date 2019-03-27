package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;

public abstract class FluxCtPasDsn
{
  public static FluxCtPasDsn getInstance()
  {
    return new _FluxCtPasDsnImpl();
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
  
  public abstract String getNatureJustificatif();
  
  public abstract void setNatureJustificatif(String paramString);
  
  public abstract String getCodeErreurNatureJustificatif();
  
  public abstract void setCodeErreurNatureJustificatif(String paramString);
  
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
  
  public abstract BigDecimal getIdRCE();
  
  public abstract void setIdRCE(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurIdRCE();
  
  public abstract void setCodeErreurIdRCE(String paramString);
  
  public abstract BigDecimal getSiretDeclare();
  
  public abstract void setSiretDeclare(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurSiretDeclare();
  
  public abstract void setCodeErreurSiretDeclare(String paramString);
  
  public abstract String getRefContratEmployeur();
  
  public abstract void setRefContratEmployeur(String paramString);
  
  public abstract String getCodeErreurRefContratEmployeur();
  
  public abstract void setCodeErreurRefContratEmployeur(String paramString);
  
  public abstract BigDecimal getNbMessagesPrimesIndemnites();
  
  public abstract void setNbMessagesPrimesIndemnites(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurNbMessagesPrimesIndemnites();
  
  public abstract void setCodeErreurNbMessagesPrimesIndemnites(String paramString);
  
  public abstract Damj getDateConnaissanceMensuelle();
  
  public abstract void setDateConnaissanceMensuelle(Damj paramDamj);
  
  public abstract String getCodeErreurDateConnaissanceMensuelle();
  
  public abstract void setCodeErreurDateConnaissanceMensuelle(String paramString);
  
  public abstract Damj getDateMoisDeclare();
  
  public abstract void setDateMoisDeclare(Damj paramDamj);
  
  public abstract String getCodeErreurDateMoisDeclare();
  
  public abstract void setCodeErreurDateMoisDeclare(String paramString);
  
  public abstract Damj getDateDebutContrat();
  
  public abstract void setDateDebutContrat(Damj paramDamj);
  
  public abstract String getCodeErreurDateDebutContrat();
  
  public abstract void setCodeErreurDateDebutContrat(String paramString);
  
  public abstract Damj getDateFinContrat();
  
  public abstract void setDateFinContrat(Damj paramDamj);
  
  public abstract String getCodeErreurDateFinContrat();
  
  public abstract void setCodeErreurDateFinContrat(String paramString);
  
  public abstract String getNatureContrat();
  
  public abstract void setNatureContrat(String paramString);
  
  public abstract String getCodeErreurNatureContrat();
  
  public abstract void setCodeErreurNatureContrat(String paramString);
  
  public abstract String getTypeContrat();
  
  public abstract void setTypeContrat(String paramString);
  
  public abstract String getCodeErreurTypeContrat();
  
  public abstract void setCodeErreurTypeContrat(String paramString);
  
  public abstract String getCodeStatutCadre();
  
  public abstract void setCodeStatutCadre(String paramString);
  
  public abstract String getCodeErreurCodeStatutCadre();
  
  public abstract void setCodeErreurCodeStatutCadre(String paramString);
  
  public abstract BigDecimal getHoraireSalarie();
  
  public abstract void setHoraireSalarie(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurHoraireSalarie();
  
  public abstract void setCodeErreurHoraireSalarie(String paramString);
  
  public abstract BigDecimal getHoraireEntreprise();
  
  public abstract void setHoraireEntreprise(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurHoraireEntreprise();
  
  public abstract void setCodeErreurHoraireEntreprise(String paramString);
  
  public abstract String getUniteTempsTravail();
  
  public abstract void setUniteTempsTravail(String paramString);
  
  public abstract String getCodeErreurUniteTempsTravail();
  
  public abstract void setCodeErreurUniteTempsTravail(String paramString);
  
  public abstract String getAlsaceMoselle();
  
  public abstract void setAlsaceMoselle(String paramString);
  
  public abstract String getCodeErreurAlsaceMoselle();
  
  public abstract void setCodeErreurAlsaceMoselle(String paramString);
  
  public abstract String getRegimeSpecialSecuriteSoc();
  
  public abstract void setRegimeSpecialSecuriteSoc(String paramString);
  
  public abstract String getCodeErreurRegimeSpecialSecuriteSoc();
  
  public abstract void setCodeErreurRegimeSpecialSecuriteSoc(String paramString);
  
  public abstract String getTypeCaisseCP();
  
  public abstract void setTypeCaisseCP(String paramString);
  
  public abstract String getCodeErreurTypeCaisseCP();
  
  public abstract void setCodeErreurTypeCaisseCP(String paramString);
  
  public abstract String getNiveauQualification();
  
  public abstract void setNiveauQualification(String paramString);
  
  public abstract String getCodeErreurNiveauQualification();
  
  public abstract void setCodeErreurNiveauQualification(String paramString);
  
  public abstract String getCodeCaisseRetraiteCompl();
  
  public abstract void setCodeCaisseRetraiteCompl(String paramString);
  
  public abstract String getCodeErreurCodeCaisseRetraiteCompl();
  
  public abstract void setCodeErreurCodeCaisseRetraiteCompl(String paramString);
  
  public abstract String getChampApplicationEmployeur();
  
  public abstract void setChampApplicationEmployeur(String paramString);
  
  public abstract String getCodeErreurChampApplicationEmployeur();
  
  public abstract void setCodeErreurChampApplicationEmployeur(String paramString);
  
  public abstract String getNumConventionGestionEmpPublic();
  
  public abstract void setNumConventionGestionEmpPublic(String paramString);
  
  public abstract String getCodeErreurNumConventionGestionEmpPublic();
  
  public abstract void setCodeErreurNumConventionGestionEmpPublic(String paramString);
  
  public abstract String getEtablissementFinancier();
  
  public abstract void setEtablissementFinancier(String paramString);
  
  public abstract String getCodeErreurEtablissementFinancier();
  
  public abstract void setCodeErreurEtablissementFinancier(String paramString);
  
  public abstract String getCodeAffectation();
  
  public abstract void setCodeAffectation(String paramString);
  
  public abstract String getCodeErreurCodeAffectation();
  
  public abstract void setCodeErreurCodeAffectation(String paramString);
  
  public abstract String getNumInterneEmpPublic();
  
  public abstract void setNumInterneEmpPublic(String paramString);
  
  public abstract String getCodeErreurNumInterneEmpPublic();
  
  public abstract void setCodeErreurNumInterneEmpPublic(String paramString);
  
  public abstract String getStatutSalarie();
  
  public abstract void setStatutSalarie(String paramString);
  
  public abstract String getCodeErreurStatutSalarie();
  
  public abstract void setCodeErreurStatutSalarie(String paramString);
  
  public abstract Damj getDateAdhesion();
  
  public abstract void setDateAdhesion(Damj paramDamj);
  
  public abstract String getCodeErreurDateAdhesion();
  
  public abstract void setCodeErreurDateAdhesion(String paramString);
  
  public abstract String getMotifPeriodeInactivite();
  
  public abstract void setMotifPeriodeInactivite(String paramString);
  
  public abstract String getCodeErreurMotifPeriodeInactivite();
  
  public abstract void setCodeErreurMotifPeriodeInactivite(String paramString);
  
  public abstract Damj getDateDebutPeriodeInactivite();
  
  public abstract void setDateDebutPeriodeInactivite(Damj paramDamj);
  
  public abstract String getCodeErreurDateDebutPeriodeInactivite();
  
  public abstract void setCodeErreurDateDebutPeriodeInactivite(String paramString);
  
  public abstract Damj getDateFinPeriodeInactivite();
  
  public abstract void setDateFinPeriodeInactivite(Damj paramDamj);
  
  public abstract String getCodeErreurDateFinPeriodeInactivite();
  
  public abstract void setCodeErreurDateFinPeriodeInactivite(String paramString);
  
  public abstract Damj getDateDebutPeriodeSalaire();
  
  public abstract void setDateDebutPeriodeSalaire(Damj paramDamj);
  
  public abstract String getCodeErreurDateDebutPeriodeSalaire();
  
  public abstract void setCodeErreurDateDebutPeriodeSalaire(String paramString);
  
  public abstract Damj getDateFinPeriodeSalaire();
  
  public abstract void setDateFinPeriodeSalaire(Damj paramDamj);
  
  public abstract String getCodeErreurDateFinPeriodeSalaire();
  
  public abstract void setCodeErreurDateFinPeriodeSalaire(String paramString);
  
  public abstract String getCodePcsEse();
  
  public abstract void setCodePcsEse(String paramString);
  
  public abstract String getCodeErreurCodePcsEse();
  
  public abstract void setCodeErreurCodePcsEse(String paramString);
  
  public abstract String getCodeComplementPcsEse();
  
  public abstract void setCodeComplementPcsEse(String paramString);
  
  public abstract String getCodeErreurCodeComplementPcsEse();
  
  public abstract void setCodeErreurCodeComplementPcsEse(String paramString);
  
  public abstract String getSigneSalaireBrutAbattu();
  
  public abstract void setSigneSalaireBrutAbattu(String paramString);
  
  public abstract String getCodeErreurSigneSalaireBrutAbattu();
  
  public abstract void setCodeErreurSigneSalaireBrutAbattu(String paramString);
  
  public abstract BigDecimal getSalaireBrutAbattu();
  
  public abstract void setSalaireBrutAbattu(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurSalaireBrutAbattu();
  
  public abstract void setCodeErreurSalaireBrutAbattu(String paramString);
  
  public abstract Damj getDatePaiement();
  
  public abstract void setDatePaiement(Damj paramDamj);
  
  public abstract String getCodeErreurDatePaiement();
  
  public abstract void setCodeErreurDatePaiement(String paramString);
  
  public abstract BigDecimal getDureeAbsence();
  
  public abstract void setDureeAbsence(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurDureeAbsence();
  
  public abstract void setCodeErreurDureeAbsence(String paramString);
  
  public abstract String getUniteAbsence();
  
  public abstract void setUniteAbsence(String paramString);
  
  public abstract String getCodeErreurUniteAbsence();
  
  public abstract void setCodeErreurUniteAbsence(String paramString);
  
  public abstract String getNomLogiciel();
  
  public abstract void setNomLogiciel(String paramString);
  
  public abstract String getCodeErreurNomLogiciel();
  
  public abstract void setCodeErreurNomLogiciel(String paramString);
  
  public abstract String getVersionLogiciel();
  
  public abstract void setVersionLogiciel(String paramString);
  
  public abstract String getCodeErreurVersionLogiciel();
  
  public abstract void setCodeErreurVersionLogiciel(String paramString);
  
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
  
  public abstract String getNom();
  
  public abstract void setNom(String paramString);
  
  public abstract String getCodeErreurNom();
  
  public abstract void setCodeErreurNom(String paramString);
  
  public abstract String getPrenom();
  
  public abstract void setPrenom(String paramString);
  
  public abstract String getCodeErreurPrenom();
  
  public abstract void setCodeErreurPrenom(String paramString);
  
  public abstract String getPeAffi();
  
  public abstract void setPeAffi(String paramString);
  
  public abstract String getCodeErreurPeAffi();
  
  public abstract void setCodeErreurPeAffi(String paramString);
  
  public abstract String getSiret();
  
  public abstract void setSiret(String paramString);
  
  public abstract String getCodeErreurSiret();
  
  public abstract void setCodeErreurSiret(String paramString);
  
  public abstract String getEmplNumAffi();
  
  public abstract void setEmplNumAffi(String paramString);
  
  public abstract String getCodeErreurEmplNumAffi();
  
  public abstract void setCodeErreurEmplNumAffi(String paramString);
  
  public abstract String getEmplRaisonSociale();
  
  public abstract void setEmplRaisonSociale(String paramString);
  
  public abstract String getCodeErreurEmplRaisonSociale();
  
  public abstract void setCodeErreurEmplRaisonSociale(String paramString);
  
  public abstract String getEmplNAF();
  
  public abstract void setEmplNAF(String paramString);
  
  public abstract String getCodeErreurEmplNAF();
  
  public abstract void setCodeErreurEmplNAF(String paramString);
  
  public abstract String getEmplCommune();
  
  public abstract void setEmplCommune(String paramString);
  
  public abstract String getCodeErreurEmplCommune();
  
  public abstract void setCodeErreurEmplCommune(String paramString);
  
  public abstract BigDecimal getEmplCP();
  
  public abstract void setEmplCP(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurEmplCP();
  
  public abstract void setCodeErreurEmplCP(String paramString);
  
  public abstract BigDecimal getIdBNEArrco();
  
  public abstract void setIdBNEArrco(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurIdBNEArrco();
  
  public abstract void setCodeErreurIdBNEArrco(String paramString);
  
  public abstract String getArrcoSigle();
  
  public abstract void setArrcoSigle(String paramString);
  
  public abstract String getCodeErreurArrcoSigle();
  
  public abstract void setCodeErreurArrcoSigle(String paramString);
  
  public abstract String getArrcoRaisonSociale();
  
  public abstract void setArrcoRaisonSociale(String paramString);
  
  public abstract String getCodeErreurArrcoRaisonSociale();
  
  public abstract void setCodeErreurArrcoRaisonSociale(String paramString);
  
  public abstract BigDecimal getIdBNEAgirc();
  
  public abstract void setIdBNEAgirc(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurIdBNEAgirc();
  
  public abstract void setCodeErreurIdBNEAgirc(String paramString);
  
  public abstract String getAgircSigle();
  
  public abstract void setAgircSigle(String paramString);
  
  public abstract String getCodeErreurAgircSigle();
  
  public abstract void setCodeErreurAgircSigle(String paramString);
  
  public abstract String getAgircRaisonSociale();
  
  public abstract void setAgircRaisonSociale(String paramString);
  
  public abstract String getCodeErreurAgircRaisonSociale();
  
  public abstract void setCodeErreurAgircRaisonSociale(String paramString);
  
  public abstract String getCodeRegimeCrpCtp();
  
  public abstract void setCodeRegimeCrpCtp(String paramString);
  
  public abstract String getCodeErreurCodeRegimeCrpCtp();
  
  public abstract void setCodeErreurCodeRegimeCrpCtp(String paramString);
  
  public abstract Damj getDateEffetRegimeCrpCtp();
  
  public abstract void setDateEffetRegimeCrpCtp(Damj paramDamj);
  
  public abstract String getCodeErreurDateEffetRegimeCrpCtp();
  
  public abstract void setCodeErreurDateEffetRegimeCrpCtp(String paramString);
  
  public abstract String getEmplNumConventionGestion();
  
  public abstract void setEmplNumConventionGestion(String paramString);
  
  public abstract String getCodeErreurEmplNumConventionGestion();
  
  public abstract void setCodeErreurEmplNumConventionGestion(String paramString);
  
  public abstract BigDecimal getNbSalariesEntreprise();
  
  public abstract void setNbSalariesEntreprise(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurNbSalariesEntreprise();
  
  public abstract void setCodeErreurNbSalariesEntreprise(String paramString);
  
  public abstract String getNomEmployeur();
  
  public abstract void setNomEmployeur(String paramString);
  
  public abstract String getCodeErreurNomEmployeur();
  
  public abstract void setCodeErreurNomEmployeur(String paramString);
  
  public abstract String getPrenomEmployeur();
  
  public abstract void setPrenomEmployeur(String paramString);
  
  public abstract String getCodeErreurPrenomEmployeur();
  
  public abstract void setCodeErreurPrenomEmployeur(String paramString);
  
  public abstract String getCategorieJuridique();
  
  public abstract void setCategorieJuridique(String paramString);
  
  public abstract String getCodeErreurCategorieJuridique();
  
  public abstract void setCodeErreurCategorieJuridique(String paramString);
  
  public abstract String getCodeRegimeEntreprise();
  
  public abstract void setCodeRegimeEntreprise(String paramString);
  
  public abstract String getCodeErreurCodeRegimeEntreprise();
  
  public abstract void setCodeErreurCodeRegimeEntreprise(String paramString);
  
  public abstract Damj getDateCessationEntreprise();
  
  public abstract void setDateCessationEntreprise(Damj paramDamj);
  
  public abstract String getCodeErreurDateCessationEntreprise();
  
  public abstract void setCodeErreurDateCessationEntreprise(String paramString);
  
  public abstract String getNatureEntreprise();
  
  public abstract void setNatureEntreprise(String paramString);
  
  public abstract String getCodeErreurNatureEntreprise();
  
  public abstract void setCodeErreurNatureEntreprise(String paramString);
  
  public abstract String getNumMSAEntreprise();
  
  public abstract void setNumMSAEntreprise(String paramString);
  
  public abstract String getCodeErreurNumMSAEntreprise();
  
  public abstract void setCodeErreurNumMSAEntreprise(String paramString);
  
  public abstract Damj getDebutPeriodeAffiliationEntreprise();
  
  public abstract void setDebutPeriodeAffiliationEntreprise(Damj paramDamj);
  
  public abstract String getCodeErreurDebutPeriodeAffiliationEntreprise();
  
  public abstract void setCodeErreurDebutPeriodeAffiliationEntreprise(String paramString);
  
  public abstract Damj getFinPeriodeAffiliationEntreprise();
  
  public abstract void setFinPeriodeAffiliationEntreprise(Damj paramDamj);
  
  public abstract String getCodeErreurFinPeriodeAffiliationEntreprise();
  
  public abstract void setCodeErreurFinPeriodeAffiliationEntreprise(String paramString);
  
  public abstract Damj getDebutConventionGestion();
  
  public abstract void setDebutConventionGestion(Damj paramDamj);
  
  public abstract String getCodeErreurDebutConventionGestion();
  
  public abstract void setCodeErreurDebutConventionGestion(String paramString);
  
  public abstract Damj getFinConventionGestion();
  
  public abstract void setFinConventionGestion(Damj paramDamj);
  
  public abstract String getCodeErreurFinConventionGestion();
  
  public abstract void setCodeErreurFinConventionGestion(String paramString);
  
  public abstract String getSecteurPublic();
  
  public abstract void setSecteurPublic(String paramString);
  
  public abstract String getCodeErreurSecteurPublic();
  
  public abstract void setCodeErreurSecteurPublic(String paramString);
  
  public abstract String getTrancheEffectifEntreprise();
  
  public abstract void setTrancheEffectifEntreprise(String paramString);
  
  public abstract String getCodeErreurTrancheEffectifEntreprise();
  
  public abstract void setCodeErreurTrancheEffectifEntreprise(String paramString);
  
  public abstract Damj getDebutAGS();
  
  public abstract void setDebutAGS(Damj paramDamj);
  
  public abstract String getCodeErreurDebutAGS();
  
  public abstract void setCodeErreurDebutAGS(String paramString);
  
  public abstract Damj getFinAGS();
  
  public abstract void setFinAGS(Damj paramDamj);
  
  public abstract String getCodeErreurFinAGS();
  
  public abstract void setCodeErreurFinAGS(String paramString);
  
  public abstract Damj getDebutAdhesionRevocable();
  
  public abstract void setDebutAdhesionRevocable(Damj paramDamj);
  
  public abstract String getCodeErreurDebutAdhesionRevocable();
  
  public abstract void setCodeErreurDebutAdhesionRevocable(String paramString);
  
  public abstract Damj getFinAdhesionRevocable();
  
  public abstract void setFinAdhesionRevocable(Damj paramDamj);
  
  public abstract String getCodeErreurFinAdhesionRevocable();
  
  public abstract void setCodeErreurFinAdhesionRevocable(String paramString);
  
  public abstract ListeFluxQuantiteTravailDsn getListeFluxQuantiteTravailDsn();
  
  public abstract void setListeFluxQuantiteTravailDsn(ListeFluxQuantiteTravailDsn paramListeFluxQuantiteTravailDsn);
  
  public abstract ListeFluxQuantiteTravailDsn setNewListeFluxQuantiteTravailDsn();
  
  public abstract String getMotifFinContrat();
  
  public abstract void setMotifFinContrat(String paramString);
  
  public abstract String getCodeErreurMotifFinContrat();
  
  public abstract void setCodeErreurMotifFinContrat(String paramString);
  
  public abstract Damj getDateInitialeFinContrat();
  
  public abstract void setDateInitialeFinContrat(Damj paramDamj);
  
  public abstract String getCodeErreurDateInitialeFinContrat();
  
  public abstract void setCodeErreurDateInitialeFinContrat(String paramString);
  
  public abstract BigDecimal getIdActiviteDsnPe();
  
  public abstract void setIdActiviteDsnPe(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurIdActiviteDsnPe();
  
  public abstract void setCodeErreurIdActiviteDsnPe(String paramString);
  
  public abstract String getSigneDureeAbsence();
  
  public abstract void setSigneDureeAbsence(String paramString);
  
  public abstract String getCodeErreurSigneDureeAbsence();
  
  public abstract void setCodeErreurSigneDureeAbsence(String paramString);
  
  public abstract ListeFluxPrimeIndemDsn getListeFluxPrimeIndemDsn();
  
  public abstract void setListeFluxPrimeIndemDsn(ListeFluxPrimeIndemDsn paramListeFluxPrimeIndemDsn);
  
  public abstract ListeFluxPrimeIndemDsn setNewListeFluxPrimeIndemDsn();
  
  public abstract String getIdentDeclPri();
  
  public abstract void setIdentDeclPri(String paramString);
  
  public abstract String getCodeErreurIdentDeclPri();
  
  public abstract void setCodeErreurIdentDeclPri(String paramString);
  
  public abstract String getIdentDeclSec();
  
  public abstract void setIdentDeclSec(String paramString);
  
  public abstract String getCodeErreurIdentDeclSec();
  
  public abstract void setCodeErreurIdentDeclSec(String paramString);
  
  public abstract String getMotifRecours();
  
  public abstract void setMotifRecours(String paramString);
  
  public abstract String getCodeErreurMotifRecours();
  
  public abstract void setCodeErreurMotifRecours(String paramString);
  
  public abstract String getModaliteDeclarativeFinContrat();
  
  public abstract void setModaliteDeclarativeFinContrat(String paramString);
  
  public abstract String getCodeErreurModaliteDeclarativeFinContrat();
  
  public abstract void setCodeErreurModaliteDeclarativeFinContrat(String paramString);
  
  public abstract Damj getDjtp();
  
  public abstract void setDjtp(Damj paramDamj);
  
  public abstract String getCodeErreurDjtp();
  
  public abstract void setCodeErreurDjtp(String paramString);
}

/* Location:
 * Qualified Name:     FluxCtPasDsn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */