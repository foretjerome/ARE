package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;

public abstract class FluxAEM
{
  public static FluxAEM getInstance()
  {
    return new _FluxAEMImpl();
  }
  
  public abstract boolean isEnErreur();
  
  public abstract String getIdentifiant();
  
  public abstract void setIdentifiant(String paramString);
  
  public abstract String getCodeEtat();
  
  public abstract void setCodeEtat(String paramString);
  
  public abstract String getBneSiret();
  
  public abstract void setBneSiret(String paramString);
  
  public abstract String getCodeErreurBneSiret();
  
  public abstract void setCodeErreurBneSiret(String paramString);
  
  public abstract String getBNEEmployeur();
  
  public abstract void setBNEEmployeur(String paramString);
  
  public abstract String getCodeErreurBNEEmployeur();
  
  public abstract void setCodeErreurBNEEmployeur(String paramString);
  
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
  
  public abstract String getCodeAction();
  
  public abstract void setCodeAction(String paramString);
  
  public abstract String getCodeErreurCodeAction();
  
  public abstract void setCodeErreurCodeAction(String paramString);
  
  public abstract String getIndicateurType();
  
  public abstract void setIndicateurType(String paramString);
  
  public abstract String getCodeErreurIndicateurType();
  
  public abstract void setCodeErreurIndicateurType(String paramString);
  
  public abstract String getNumeroInitial();
  
  public abstract void setNumeroInitial(String paramString);
  
  public abstract String getCodeErreurNumeroInitial();
  
  public abstract void setCodeErreurNumeroInitial(String paramString);
  
  public abstract String getNumero();
  
  public abstract void setNumero(String paramString);
  
  public abstract String getCodeErreurNumero();
  
  public abstract void setCodeErreurNumero(String paramString);
  
  public abstract String getSiretEmployeur();
  
  public abstract void setSiretEmployeur(String paramString);
  
  public abstract String getCodeErreurSiretEmployeur();
  
  public abstract void setCodeErreurSiretEmployeur(String paramString);
  
  public abstract String getCodeNafApe();
  
  public abstract void setCodeNafApe(String paramString);
  
  public abstract String getCodeErreurCodeNafApe();
  
  public abstract void setCodeErreurCodeNafApe(String paramString);
  
  public abstract String getNumAssedicAffiliation();
  
  public abstract void setNumAssedicAffiliation(String paramString);
  
  public abstract String getCodeErreurNumAssedicAffiliation();
  
  public abstract void setCodeErreurNumAssedicAffiliation(String paramString);
  
  public abstract String getNumeroAffiliation();
  
  public abstract void setNumeroAffiliation(String paramString);
  
  public abstract String getCodeErreurNumeroAffiliation();
  
  public abstract void setCodeErreurNumeroAffiliation(String paramString);
  
  public abstract String getRaisonSociale();
  
  public abstract void setRaisonSociale(String paramString);
  
  public abstract String getCodeErreurRaisonSociale();
  
  public abstract void setCodeErreurRaisonSociale(String paramString);
  
  public abstract String getAdresseEmployeur();
  
  public abstract void setAdresseEmployeur(String paramString);
  
  public abstract String getCodeErreurAdresseEmployeur();
  
  public abstract void setCodeErreurAdresseEmployeur(String paramString);
  
  public abstract String getComplAdresseEmployeur();
  
  public abstract void setComplAdresseEmployeur(String paramString);
  
  public abstract String getCodeErreurComplAdresseEmployeur();
  
  public abstract void setCodeErreurComplAdresseEmployeur(String paramString);
  
  public abstract String getTelephoneEmployeur();
  
  public abstract void setTelephoneEmployeur(String paramString);
  
  public abstract String getCodeErreurTelephoneEmployeur();
  
  public abstract void setCodeErreurTelephoneEmployeur(String paramString);
  
  public abstract String getFaxEmployeur();
  
  public abstract void setFaxEmployeur(String paramString);
  
  public abstract String getCodeErreurFaxEmployeur();
  
  public abstract void setCodeErreurFaxEmployeur(String paramString);
  
  public abstract String getCourrielEmployeur();
  
  public abstract void setCourrielEmployeur(String paramString);
  
  public abstract String getCodeErreurCourrielEmployeur();
  
  public abstract void setCodeErreurCourrielEmployeur(String paramString);
  
  public abstract String getCodePostalEmployeur();
  
  public abstract void setCodePostalEmployeur(String paramString);
  
  public abstract String getCodeErreurCodePostalEmployeur();
  
  public abstract void setCodeErreurCodePostalEmployeur(String paramString);
  
  public abstract String getCommuneEmployeur();
  
  public abstract void setCommuneEmployeur(String paramString);
  
  public abstract String getCodeErreurCommuneEmployeur();
  
  public abstract void setCodeErreurCommuneEmployeur(String paramString);
  
  public abstract String getFormeJuridique();
  
  public abstract void setFormeJuridique(String paramString);
  
  public abstract String getCodeErreurFormeJuridique();
  
  public abstract void setCodeErreurFormeJuridique(String paramString);
  
  public abstract String getActiviteEmployeur();
  
  public abstract void setActiviteEmployeur(String paramString);
  
  public abstract String getCodeErreurActiviteEmployeur();
  
  public abstract void setCodeErreurActiviteEmployeur(String paramString);
  
  public abstract String getLicenceSpectacle();
  
  public abstract void setLicenceSpectacle(String paramString);
  
  public abstract String getCodeErreurLicenceSpectacle();
  
  public abstract void setCodeErreurLicenceSpectacle(String paramString);
  
  public abstract String getNumeroLicenceSpe();
  
  public abstract void setNumeroLicenceSpe(String paramString);
  
  public abstract String getCodeErreurNumeroLicenceSpe();
  
  public abstract void setCodeErreurNumeroLicenceSpe(String paramString);
  
  public abstract String getOrganisateurOccasionnelspe();
  
  public abstract void setOrganisateurOccasionnelspe(String paramString);
  
  public abstract String getCodeErreurOrganisateurOccasionnelspe();
  
  public abstract void setCodeErreurOrganisateurOccasionnelspe(String paramString);
  
  public abstract String getTitulaireLabelPresta();
  
  public abstract void setTitulaireLabelPresta(String paramString);
  
  public abstract String getCodeErreurTitulaireLabelPresta();
  
  public abstract void setCodeErreurTitulaireLabelPresta(String paramString);
  
  public abstract String getNumeroLabelPrestaSer();
  
  public abstract void setNumeroLabelPrestaSer(String paramString);
  
  public abstract String getCodeErreurNumeroLabelPrestaSer();
  
  public abstract void setCodeErreurNumeroLabelPrestaSer(String paramString);
  
  public abstract String getNumAffiCaisseConges();
  
  public abstract void setNumAffiCaisseConges(String paramString);
  
  public abstract String getCodeErreurNumAffiCaisseConges();
  
  public abstract void setCodeErreurNumAffiCaisseConges(String paramString);
  
  public abstract String getNomSalarie();
  
  public abstract void setNomSalarie(String paramString);
  
  public abstract String getCodeErreurNomSalarie();
  
  public abstract void setCodeErreurNomSalarie(String paramString);
  
  public abstract String getPrenomSalarie();
  
  public abstract void setPrenomSalarie(String paramString);
  
  public abstract String getCodeErreurPrenomSalarie();
  
  public abstract void setCodeErreurPrenomSalarie(String paramString);
  
  public abstract String getNomUsuel();
  
  public abstract void setNomUsuel(String paramString);
  
  public abstract String getCodeErreurNomUsuel();
  
  public abstract void setCodeErreurNomUsuel(String paramString);
  
  public abstract String getTelephoneSalarie();
  
  public abstract void setTelephoneSalarie(String paramString);
  
  public abstract String getCodeErreurTelephoneSalarie();
  
  public abstract void setCodeErreurTelephoneSalarie(String paramString);
  
  public abstract String getNIR();
  
  public abstract void setNIR(String paramString);
  
  public abstract String getCodeErreurNIR();
  
  public abstract void setCodeErreurNIR(String paramString);
  
  public abstract String getAdresseSalarie();
  
  public abstract void setAdresseSalarie(String paramString);
  
  public abstract String getCodeErreurAdresseSalarie();
  
  public abstract void setCodeErreurAdresseSalarie(String paramString);
  
  public abstract String getComplementAdresseSalarie();
  
  public abstract void setComplementAdresseSalarie(String paramString);
  
  public abstract String getCodeErreurComplementAdresseSalarie();
  
  public abstract void setCodeErreurComplementAdresseSalarie(String paramString);
  
  public abstract String getCodePostalSalarie();
  
  public abstract void setCodePostalSalarie(String paramString);
  
  public abstract String getCodeErreurCodePostalSalarie();
  
  public abstract void setCodeErreurCodePostalSalarie(String paramString);
  
  public abstract String getCommuneSalarie();
  
  public abstract void setCommuneSalarie(String paramString);
  
  public abstract String getCodeErreurCommuneSalarie();
  
  public abstract void setCodeErreurCommuneSalarie(String paramString);
  
  public abstract String getLienParente();
  
  public abstract void setLienParente(String paramString);
  
  public abstract String getCodeErreurLienParente();
  
  public abstract void setCodeErreurLienParente(String paramString);
  
  public abstract String getTypeLienParente();
  
  public abstract void setTypeLienParente(String paramString);
  
  public abstract String getCodeErreurTypeLienParente();
  
  public abstract void setCodeErreurTypeLienParente(String paramString);
  
  public abstract String getCodeEmploiOccupe();
  
  public abstract void setCodeEmploiOccupe(String paramString);
  
  public abstract String getCodeErreurCodeEmploiOccupe();
  
  public abstract void setCodeErreurCodeEmploiOccupe(String paramString);
  
  public abstract String getCodeQualification();
  
  public abstract void setCodeQualification(String paramString);
  
  public abstract String getCodeErreurCodeQualification();
  
  public abstract void setCodeErreurCodeQualification(String paramString);
  
  public abstract String getRegimeRetraiteCompl();
  
  public abstract void setRegimeRetraiteCompl(String paramString);
  
  public abstract String getCodeErreurRegimeRetraiteCompl();
  
  public abstract void setCodeErreurRegimeRetraiteCompl(String paramString);
  
  public abstract String getStatutCadre();
  
  public abstract void setStatutCadre(String paramString);
  
  public abstract String getCodeErreurStatutCadre();
  
  public abstract void setCodeErreurStatutCadre(String paramString);
  
  public abstract String getContratEnCours();
  
  public abstract void setContratEnCours(String paramString);
  
  public abstract String getCodeErreurContratEnCours();
  
  public abstract void setCodeErreurContratEnCours(String paramString);
  
  public abstract String getMotiFinContrat();
  
  public abstract void setMotiFinContrat(String paramString);
  
  public abstract String getCodeErreurMotiFinContrat();
  
  public abstract void setCodeErreurMotiFinContrat(String paramString);
  
  public abstract String getNomEmployeur();
  
  public abstract void setNomEmployeur(String paramString);
  
  public abstract String getCodeErreurNomEmployeur();
  
  public abstract void setCodeErreurNomEmployeur(String paramString);
  
  public abstract String getPrenomEmployeur();
  
  public abstract void setPrenomEmployeur(String paramString);
  
  public abstract String getCodeErreurPrenomEmployeur();
  
  public abstract void setCodeErreurPrenomEmployeur(String paramString);
  
  public abstract String getQualite();
  
  public abstract void setQualite(String paramString);
  
  public abstract String getCodeErreurQualite();
  
  public abstract void setCodeErreurQualite(String paramString);
  
  public abstract String getMotifRupture();
  
  public abstract void setMotifRupture(String paramString);
  
  public abstract String getCodeErreurMotifRupture();
  
  public abstract void setCodeErreurMotifRupture(String paramString);
  
  public abstract String getCommuneSignature();
  
  public abstract void setCommuneSignature(String paramString);
  
  public abstract String getCodeErreurCommuneSignature();
  
  public abstract void setCodeErreurCommuneSignature(String paramString);
  
  public abstract String getContactAEM();
  
  public abstract void setContactAEM(String paramString);
  
  public abstract String getCodeErreurContactAEM();
  
  public abstract void setCodeErreurContactAEM(String paramString);
  
  public abstract String getTelephoneTiers();
  
  public abstract void setTelephoneTiers(String paramString);
  
  public abstract String getCodeErreurTelephoneTiers();
  
  public abstract void setCodeErreurTelephoneTiers(String paramString);
  
  public abstract String getCodeOrganisme();
  
  public abstract void setCodeOrganisme(String paramString);
  
  public abstract String getCodeErreurCodeOrganisme();
  
  public abstract void setCodeErreurCodeOrganisme(String paramString);
  
  public abstract String getNbJoursTravailles();
  
  public abstract void setNbJoursTravailles(String paramString);
  
  public abstract String getCodeErreurNbJoursTravailles();
  
  public abstract void setCodeErreurNbJoursTravailles(String paramString);
  
  public abstract String getNumVersionAEM();
  
  public abstract void setNumVersionAEM(String paramString);
  
  public abstract String getCodeErreurNumVersionAEM();
  
  public abstract void setCodeErreurNumVersionAEM(String paramString);
  
  public abstract String getAffiCaisseConges();
  
  public abstract void setAffiCaisseConges(String paramString);
  
  public abstract String getCodeErreurAffiCaisseConges();
  
  public abstract void setCodeErreurAffiCaisseConges(String paramString);
  
  public abstract String getNumeroObjet();
  
  public abstract void setNumeroObjet(String paramString);
  
  public abstract String getCodeErreurNumeroObjet();
  
  public abstract void setCodeErreurNumeroObjet(String paramString);
  
  public abstract String getIndicateurHorsChamp();
  
  public abstract void setIndicateurHorsChamp(String paramString);
  
  public abstract String getCodeErreurIndicateurHorsChamp();
  
  public abstract void setCodeErreurIndicateurHorsChamp(String paramString);
  
  public abstract String getNouveauCodeApeNaf();
  
  public abstract void setNouveauCodeApeNaf(String paramString);
  
  public abstract String getCodeErreurNouveauCodeApeNaf();
  
  public abstract void setCodeErreurNouveauCodeApeNaf(String paramString);
  
  public abstract Damj getDateNaissance();
  
  public abstract void setDateNaissance(Damj paramDamj);
  
  public abstract String getCodeErreurDateNaissance();
  
  public abstract void setCodeErreurDateNaissance(String paramString);
  
  public abstract Damj getDateFincontrat();
  
  public abstract void setDateFincontrat(Damj paramDamj);
  
  public abstract String getCodeErreurDateFincontrat();
  
  public abstract void setCodeErreurDateFincontrat(String paramString);
  
  public abstract Damj getDateEmbauche();
  
  public abstract void setDateEmbauche(Damj paramDamj);
  
  public abstract String getCodeErreurDateEmbauche();
  
  public abstract void setCodeErreurDateEmbauche(String paramString);
  
  public abstract Damj getDateSignature();
  
  public abstract void setDateSignature(Damj paramDamj);
  
  public abstract String getCodeErreurDateSignature();
  
  public abstract void setCodeErreurDateSignature(String paramString);
  
  public abstract Damj getDateFichierExt();
  
  public abstract void setDateFichierExt(Damj paramDamj);
  
  public abstract String getCodeErreurDateFichierExt();
  
  public abstract void setCodeErreurDateFichierExt(String paramString);
  
  public abstract Damj getDateCreation();
  
  public abstract void setDateCreation(Damj paramDamj);
  
  public abstract String getCodeErreurDateCreation();
  
  public abstract void setCodeErreurDateCreation(String paramString);
  
  public abstract Damj getDateInitialeFinCDD();
  
  public abstract void setDateInitialeFinCDD(Damj paramDamj);
  
  public abstract String getCodeErreurDateInitialeFinCDD();
  
  public abstract void setCodeErreurDateInitialeFinCDD(String paramString);
  
  public abstract BigDecimal getNbHeures();
  
  public abstract void setNbHeures(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurNbHeures();
  
  public abstract void setCodeErreurNbHeures(String paramString);
  
  public abstract BigDecimal getNbCachets();
  
  public abstract void setNbCachets(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurNbCachets();
  
  public abstract void setCodeErreurNbCachets(String paramString);
  
  public abstract BigDecimal getSalaireBrutAvtAbatt();
  
  public abstract void setSalaireBrutAvtAbatt(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurSalaireBrutAvtAbatt();
  
  public abstract void setCodeErreurSalaireBrutAvtAbatt(String paramString);
  
  public abstract BigDecimal getSalaireBrutAprAbatt();
  
  public abstract void setSalaireBrutAprAbatt(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurSalaireBrutAprAbatt();
  
  public abstract void setCodeErreurSalaireBrutAprAbatt(String paramString);
  
  public abstract BigDecimal getTauxAbatt();
  
  public abstract void setTauxAbatt(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurTauxAbatt();
  
  public abstract void setCodeErreurTauxAbatt(String paramString);
  
  public abstract BigDecimal getContributionDues();
  
  public abstract void setContributionDues(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurContributionDues();
  
  public abstract void setCodeErreurContributionDues(String paramString);
  
  public abstract BigDecimal getMoisActualisation();
  
  public abstract void setMoisActualisation(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurMoisActualisation();
  
  public abstract void setCodeErreurMoisActualisation(String paramString);
  
  public abstract BigDecimal getAnneeActualisation();
  
  public abstract void setAnneeActualisation(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurAnneeActualisation();
  
  public abstract void setCodeErreurAnneeActualisation(String paramString);
  
  public abstract BigDecimal getNbCachetsIsoles();
  
  public abstract void setNbCachetsIsoles(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurNbCachetsIsoles();
  
  public abstract void setCodeErreurNbCachetsIsoles(String paramString);
  
  public abstract BigDecimal getNbCachetsGroupes();
  
  public abstract void setNbCachetsGroupes(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurNbCachetsGroupes();
  
  public abstract void setCodeErreurNbCachetsGroupes(String paramString);
  
  public abstract BigDecimal getAutresRemunerationsMontantBrut();
  
  public abstract void setAutresRemunerationsMontantBrut(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurAutresRemunerationsMontantBrut();
  
  public abstract void setCodeErreurAutresRemunerationsMontantBrut(String paramString);
  
  public abstract BigDecimal getAutresRemunerationsTauxContributions();
  
  public abstract void setAutresRemunerationsTauxContributions(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurAutresRemunerationsTauxContributions();
  
  public abstract void setCodeErreurAutresRemunerationsTauxContributions(String paramString);
  
  public abstract BigDecimal getAutresRemunerationsContributionsDues();
  
  public abstract void setAutresRemunerationsContributionsDues(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurAutresRemunerationsContributionsDues();
  
  public abstract void setCodeErreurAutresRemunerationsContributionsDues(String paramString);
  
  public abstract BigDecimal getTotalContributionsDues();
  
  public abstract void setTotalContributionsDues(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurTotalContributionsDues();
  
  public abstract void setCodeErreurTotalContributionsDues(String paramString);
  
  public abstract String getBneCertifSociale();
  
  public abstract void setBneCertifSociale(String paramString);
  
  public abstract String getCodeErreurBneCertifSociale();
  
  public abstract void setCodeErreurBneCertifSociale(String paramString);
  
  public abstract String getIdccEmployeur();
  
  public abstract void setIdccEmployeur(String paramString);
  
  public abstract String getCodeErreurIdccEmployeur();
  
  public abstract void setCodeErreurIdccEmployeur(String paramString);
  
  public abstract String getIdccPrestation();
  
  public abstract void setIdccPrestation(String paramString);
  
  public abstract String getCodeErreurIdccPrestation();
  
  public abstract void setCodeErreurIdccPrestation(String paramString);
  
  public abstract String getRessortissant();
  
  public abstract void setRessortissant(String paramString);
  
  public abstract String getCodeErreurRessortissant();
  
  public abstract void setCodeErreurRessortissant(String paramString);
  
  public abstract String getIndicateurCertifSociale();
  
  public abstract void setIndicateurCertifSociale(String paramString);
  
  public abstract String getCodeErreurIndicateurCertifSociale();
  
  public abstract void setCodeErreurIndicateurCertifSociale(String paramString);
  
  public abstract String getNumCertifSociale();
  
  public abstract void setNumCertifSociale(String paramString);
  
  public abstract String getCodeErreurNumCertifSociale();
  
  public abstract void setCodeErreurNumCertifSociale(String paramString);
}

/* Location:
 * Qualified Name:     FluxAEM
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */