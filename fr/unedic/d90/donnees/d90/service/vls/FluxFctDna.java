package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;

public abstract class FluxFctDna
{
  public static FluxFctDna getInstance()
  {
    return new _FluxFctDnaImpl();
  }
  
  public abstract boolean isEnErreur();
  
  public abstract String getIdentifiant();
  
  public abstract void setIdentifiant(String paramString);
  
  public abstract String getCodeEtat();
  
  public abstract void setCodeEtat(String paramString);
  
  public abstract ListeFluxFctDnaPreavis getListeFluxFctDnaPreavis();
  
  public abstract void setListeFluxFctDnaPreavis(ListeFluxFctDnaPreavis paramListeFluxFctDnaPreavis);
  
  public abstract ListeFluxFctDnaPreavis setNewListeFluxFctDnaPreavis();
  
  public abstract ListeFluxFctDnaIndemnitesVersees getListeFluxFctDnaIndemnitesVersees();
  
  public abstract void setListeFluxFctDnaIndemnitesVersees(ListeFluxFctDnaIndemnitesVersees paramListeFluxFctDnaIndemnitesVersees);
  
  public abstract ListeFluxFctDnaIndemnitesVersees setNewListeFluxFctDnaIndemnitesVersees();
  
  public abstract String getCodeMessage();
  
  public abstract void setCodeMessage(String paramString);
  
  public abstract String getCodeErreurCodeMessage();
  
  public abstract void setCodeErreurCodeMessage(String paramString);
  
  public abstract String getCodeAction();
  
  public abstract void setCodeAction(String paramString);
  
  public abstract String getCodeErreurCodeAction();
  
  public abstract void setCodeErreurCodeAction(String paramString);
  
  public abstract String getSIRET();
  
  public abstract void setSIRET(String paramString);
  
  public abstract String getCodeErreurSIRET();
  
  public abstract void setCodeErreurSIRET(String paramString);
  
  public abstract String getReferenceContrat();
  
  public abstract void setReferenceContrat(String paramString);
  
  public abstract String getCodeErreurReferenceContrat();
  
  public abstract void setCodeErreurReferenceContrat(String paramString);
  
  public abstract String getNatureContrat();
  
  public abstract void setNatureContrat(String paramString);
  
  public abstract String getCodeErreurNatureContrat();
  
  public abstract void setCodeErreurNatureContrat(String paramString);
  
  public abstract String getMotifRupture();
  
  public abstract void setMotifRupture(String paramString);
  
  public abstract String getCodeErreurMotifRupture();
  
  public abstract void setCodeErreurMotifRupture(String paramString);
  
  public abstract String getClauseNonConcurrence();
  
  public abstract void setClauseNonConcurrence(String paramString);
  
  public abstract String getCodeErreurClauseNonConcurrence();
  
  public abstract void setCodeErreurClauseNonConcurrence(String paramString);
  
  public abstract String getRegimeSpecialSS();
  
  public abstract void setRegimeSpecialSS(String paramString);
  
  public abstract String getCodeErreurRegimeSpecialSS();
  
  public abstract void setCodeErreurRegimeSpecialSS(String paramString);
  
  public abstract String getNumeroAffiRegimeSpecialSS();
  
  public abstract void setNumeroAffiRegimeSpecialSS(String paramString);
  
  public abstract String getCodeErreurNumeroAffiRegimeSpecialSS();
  
  public abstract void setCodeErreurNumeroAffiRegimeSpecialSS(String paramString);
  
  public abstract String getLienParente();
  
  public abstract void setLienParente(String paramString);
  
  public abstract String getCodeErreurLienParente();
  
  public abstract void setCodeErreurLienParente(String paramString);
  
  public abstract String getStatutParticulier();
  
  public abstract void setStatutParticulier(String paramString);
  
  public abstract String getCodeErreurStatutParticulier();
  
  public abstract void setCodeErreurStatutParticulier(String paramString);
  
  public abstract String getNiveauQualif();
  
  public abstract void setNiveauQualif(String paramString);
  
  public abstract String getCodeErreurNiveauQualif();
  
  public abstract void setCodeErreurNiveauQualif(String paramString);
  
  public abstract String getTopTransaction();
  
  public abstract void setTopTransaction(String paramString);
  
  public abstract String getCodeErreurTopTransaction();
  
  public abstract void setCodeErreurTopTransaction(String paramString);
  
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
  
  public abstract String getBneCodePostal();
  
  public abstract void setBneCodePostal(String paramString);
  
  public abstract String getCodeErreurBneCodePostal();
  
  public abstract void setCodeErreurBneCodePostal(String paramString);
  
  public abstract String getBneLibelleCommuneCNAVTS();
  
  public abstract void setBneLibelleCommuneCNAVTS(String paramString);
  
  public abstract String getCodeErreurBneLibelleCommuneCNAVTS();
  
  public abstract void setCodeErreurBneLibelleCommuneCNAVTS(String paramString);
  
  public abstract String getBneAssedicAffiliation();
  
  public abstract void setBneAssedicAffiliation(String paramString);
  
  public abstract String getCodeErreurBneAssedicAffiliation();
  
  public abstract void setCodeErreurBneAssedicAffiliation(String paramString);
  
  public abstract String getBneNumAffiliation();
  
  public abstract void setBneNumAffiliation(String paramString);
  
  public abstract String getCodeErreurBneNumAffiliation();
  
  public abstract void setCodeErreurBneNumAffiliation(String paramString);
  
  public abstract String getBneNouveauCodeNAF();
  
  public abstract void setBneNouveauCodeNAF(String paramString);
  
  public abstract String getCodeErreurBneNouveauCodeNAF();
  
  public abstract void setCodeErreurBneNouveauCodeNAF(String paramString);
  
  public abstract String getAbonnementProvisoire();
  
  public abstract void setAbonnementProvisoire(String paramString);
  
  public abstract String getCodeErreurAbonnementProvisoire();
  
  public abstract void setCodeErreurAbonnementProvisoire(String paramString);
  
  public abstract String getCodeRegimeCTP();
  
  public abstract void setCodeRegimeCTP(String paramString);
  
  public abstract String getCodeErreurCodeRegimeCTP();
  
  public abstract void setCodeErreurCodeRegimeCTP(String paramString);
  
  public abstract String getNomEmployeur();
  
  public abstract void setNomEmployeur(String paramString);
  
  public abstract String getCodeErreurNomEmployeur();
  
  public abstract void setCodeErreurNomEmployeur(String paramString);
  
  public abstract String getPrenomEmployeur();
  
  public abstract void setPrenomEmployeur(String paramString);
  
  public abstract String getCodeErreurPrenomEmployeur();
  
  public abstract void setCodeErreurPrenomEmployeur(String paramString);
  
  public abstract String getNumUrssaf();
  
  public abstract void setNumUrssaf(String paramString);
  
  public abstract String getCodeErreurNumUrssaf();
  
  public abstract void setCodeErreurNumUrssaf(String paramString);
  
  public abstract String getNumCESU();
  
  public abstract void setNumCESU(String paramString);
  
  public abstract String getCodeErreurNumCESU();
  
  public abstract void setCodeErreurNumCESU(String paramString);
  
  public abstract String getNumPAJEEMPLOI();
  
  public abstract void setNumPAJEEMPLOI(String paramString);
  
  public abstract String getCodeErreurNumPAJEEMPLOI();
  
  public abstract void setCodeErreurNumPAJEEMPLOI(String paramString);
  
  public abstract String getIdBNIRemplace();
  
  public abstract void setIdBNIRemplace(String paramString);
  
  public abstract String getCodeErreurIdBNIRemplace();
  
  public abstract void setCodeErreurIdBNIRemplace(String paramString);
  
  public abstract String getOrigineAE();
  
  public abstract void setOrigineAE(String paramString);
  
  public abstract String getCodeErreurOrigineAE();
  
  public abstract void setCodeErreurOrigineAE(String paramString);
  
  public abstract String getIndicChomSsRCT();
  
  public abstract void setIndicChomSsRCT(String paramString);
  
  public abstract String getCodeErreurIndicChomSsRCT();
  
  public abstract void setCodeErreurIndicChomSsRCT(String paramString);
  
  public abstract String getRefusAdhesionFNE();
  
  public abstract void setRefusAdhesionFNE(String paramString);
  
  public abstract String getCodeErreurRefusAdhesionFNE();
  
  public abstract void setCodeErreurRefusAdhesionFNE(String paramString);
  
  public abstract String getCodeStatutCadre();
  
  public abstract void setCodeStatutCadre(String paramString);
  
  public abstract String getCodeErreurCodeStatutCadre();
  
  public abstract void setCodeErreurCodeStatutCadre(String paramString);
  
  public abstract String getCocheAlsaceMoselle();
  
  public abstract void setCocheAlsaceMoselle(String paramString);
  
  public abstract String getCodeErreurCocheAlsaceMoselle();
  
  public abstract void setCodeErreurCocheAlsaceMoselle(String paramString);
  
  public abstract String getIndCotisationForfaitReel();
  
  public abstract void setIndCotisationForfaitReel(String paramString);
  
  public abstract String getCodeErreurIndCotisationForfaitReel();
  
  public abstract void setCodeErreurIndCotisationForfaitReel(String paramString);
  
  public abstract String getIndBrutNet();
  
  public abstract void setIndBrutNet(String paramString);
  
  public abstract String getCodeErreurIndBrutNet();
  
  public abstract void setCodeErreurIndBrutNet(String paramString);
  
  public abstract String getCodeCaisseCongesPayes();
  
  public abstract void setCodeCaisseCongesPayes(String paramString);
  
  public abstract String getCodeErreurCodeCaisseCongesPayes();
  
  public abstract void setCodeErreurCodeCaisseCongesPayes(String paramString);
  
  public abstract String getNumCaisseCP();
  
  public abstract void setNumCaisseCP(String paramString);
  
  public abstract String getCodeErreurNumCaisseCP();
  
  public abstract void setCodeErreurNumCaisseCP(String paramString);
  
  public abstract String getCodeARRCO();
  
  public abstract void setCodeARRCO(String paramString);
  
  public abstract String getCodeErreurCodeARRCO();
  
  public abstract void setCodeErreurCodeARRCO(String paramString);
  
  public abstract String getNumBneARRCO();
  
  public abstract void setNumBneARRCO(String paramString);
  
  public abstract String getCodeErreurNumBneARRCO();
  
  public abstract void setCodeErreurNumBneARRCO(String paramString);
  
  public abstract String getSigleARRCO();
  
  public abstract void setSigleARRCO(String paramString);
  
  public abstract String getCodeErreurSigleARRCO();
  
  public abstract void setCodeErreurSigleARRCO(String paramString);
  
  public abstract String getRaisonSocialeARRCO();
  
  public abstract void setRaisonSocialeARRCO(String paramString);
  
  public abstract String getCodeErreurRaisonSocialeARRCO();
  
  public abstract void setCodeErreurRaisonSocialeARRCO(String paramString);
  
  public abstract String getCodeAGIRC();
  
  public abstract void setCodeAGIRC(String paramString);
  
  public abstract String getCodeErreurCodeAGIRC();
  
  public abstract void setCodeErreurCodeAGIRC(String paramString);
  
  public abstract String getNumBneAGIRC();
  
  public abstract void setNumBneAGIRC(String paramString);
  
  public abstract String getCodeErreurNumBneAGIRC();
  
  public abstract void setCodeErreurNumBneAGIRC(String paramString);
  
  public abstract String getSigleAGIRC();
  
  public abstract void setSigleAGIRC(String paramString);
  
  public abstract String getCodeErreurSigleAGIRC();
  
  public abstract void setCodeErreurSigleAGIRC(String paramString);
  
  public abstract String getRaisonSocialeAGIRC();
  
  public abstract void setRaisonSocialeAGIRC(String paramString);
  
  public abstract String getCodeErreurRaisonSocialeAGIRC();
  
  public abstract void setCodeErreurRaisonSocialeAGIRC(String paramString);
  
  public abstract String getTypeContrat();
  
  public abstract void setTypeContrat(String paramString);
  
  public abstract String getCodeErreurTypeContrat();
  
  public abstract void setCodeErreurTypeContrat(String paramString);
  
  public abstract String getCodeRegimeEmployeur();
  
  public abstract void setCodeRegimeEmployeur(String paramString);
  
  public abstract String getCodeErreurCodeRegimeEmployeur();
  
  public abstract void setCodeErreurCodeRegimeEmployeur(String paramString);
  
  public abstract String getNumConventionGestion();
  
  public abstract void setNumConventionGestion(String paramString);
  
  public abstract String getCodeErreurNumConventionGestion();
  
  public abstract void setCodeErreurNumConventionGestion(String paramString);
  
  public abstract String getNomFamille();
  
  public abstract void setNomFamille(String paramString);
  
  public abstract String getCodeErreurNomFamille();
  
  public abstract void setCodeErreurNomFamille(String paramString);
  
  public abstract String getPrenom();
  
  public abstract void setPrenom(String paramString);
  
  public abstract String getCodeErreurPrenom();
  
  public abstract void setCodeErreurPrenom(String paramString);
  
  public abstract String getIndicMontantIndemnite();
  
  public abstract void setIndicMontantIndemnite(String paramString);
  
  public abstract String getCodeErreurIndicMontantIndemnite();
  
  public abstract void setCodeErreurIndicMontantIndemnite(String paramString);
  
  public abstract String getIndicSalaireHoraire();
  
  public abstract void setIndicSalaireHoraire(String paramString);
  
  public abstract String getCodeErreurIndicSalaireHoraire();
  
  public abstract void setCodeErreurIndicSalaireHoraire(String paramString);
  
  public abstract String getFillerUn();
  
  public abstract void setFillerUn(String paramString);
  
  public abstract String getCodeErreurFillerUn();
  
  public abstract void setCodeErreurFillerUn(String paramString);
  
  public abstract String getFillerDeux();
  
  public abstract void setFillerDeux(String paramString);
  
  public abstract String getCodeErreurFillerDeux();
  
  public abstract void setCodeErreurFillerDeux(String paramString);
  
  public abstract String getEmployAutoAssur();
  
  public abstract void setEmployAutoAssur(String paramString);
  
  public abstract String getCodeErreurEmployAutoAssur();
  
  public abstract void setCodeErreurEmployAutoAssur(String paramString);
  
  public abstract String getNumCG();
  
  public abstract void setNumCG(String paramString);
  
  public abstract String getCodeErreurNumCG();
  
  public abstract void setCodeErreurNumCG(String paramString);
  
  public abstract String getEtabFinanc();
  
  public abstract void setEtabFinanc(String paramString);
  
  public abstract String getCodeErreurEtabFinanc();
  
  public abstract void setCodeErreurEtabFinanc(String paramString);
  
  public abstract String getNumInterne();
  
  public abstract void setNumInterne(String paramString);
  
  public abstract String getCodeErreurNumInterne();
  
  public abstract void setCodeErreurNumInterne(String paramString);
  
  public abstract String getCodeAffect();
  
  public abstract void setCodeAffect(String paramString);
  
  public abstract String getCodeErreurCodeAffect();
  
  public abstract void setCodeErreurCodeAffect(String paramString);
  
  public abstract String getStatutSalarie();
  
  public abstract void setStatutSalarie(String paramString);
  
  public abstract String getCodeErreurStatutSalarie();
  
  public abstract void setCodeErreurStatutSalarie(String paramString);
  
  public abstract String getCodeStatutjuridique();
  
  public abstract void setCodeStatutjuridique(String paramString);
  
  public abstract String getCodeErreurCodeStatutjuridique();
  
  public abstract void setCodeErreurCodeStatutjuridique(String paramString);
  
  public abstract String getNomLogiciel();
  
  public abstract void setNomLogiciel(String paramString);
  
  public abstract String getCodeErreurNomLogiciel();
  
  public abstract void setCodeErreurNomLogiciel(String paramString);
  
  public abstract String getVersionLogiciel();
  
  public abstract void setVersionLogiciel(String paramString);
  
  public abstract String getCodeErreurVersionLogiciel();
  
  public abstract void setCodeErreurVersionLogiciel(String paramString);
  
  public abstract String getCategorieJuridiqueEntreprise();
  
  public abstract void setCategorieJuridiqueEntreprise(String paramString);
  
  public abstract String getCodeErreurCategorieJuridiqueEntreprise();
  
  public abstract void setCodeErreurCategorieJuridiqueEntreprise(String paramString);
  
  public abstract String getCodeRegimeEntreprise();
  
  public abstract void setCodeRegimeEntreprise(String paramString);
  
  public abstract String getCodeErreurCodeRegimeEntreprise();
  
  public abstract void setCodeErreurCodeRegimeEntreprise(String paramString);
  
  public abstract String getNatureEntreprise();
  
  public abstract void setNatureEntreprise(String paramString);
  
  public abstract String getCodeErreurNatureEntreprise();
  
  public abstract void setCodeErreurNatureEntreprise(String paramString);
  
  public abstract String getNumGusoEntreprise();
  
  public abstract void setNumGusoEntreprise(String paramString);
  
  public abstract String getCodeErreurNumGusoEntreprise();
  
  public abstract void setCodeErreurNumGusoEntreprise(String paramString);
  
  public abstract String getNumMSAEntreprise();
  
  public abstract void setNumMSAEntreprise(String paramString);
  
  public abstract String getCodeErreurNumMSAEntreprise();
  
  public abstract void setCodeErreurNumMSAEntreprise(String paramString);
  
  public abstract String getEntreprisePublique();
  
  public abstract void setEntreprisePublique(String paramString);
  
  public abstract String getCodeErreurEntreprisePublique();
  
  public abstract void setCodeErreurEntreprisePublique(String paramString);
  
  public abstract String getTrancheEffectifEntreprise();
  
  public abstract void setTrancheEffectifEntreprise(String paramString);
  
  public abstract String getCodeErreurTrancheEffectifEntreprise();
  
  public abstract void setCodeErreurTrancheEffectifEntreprise(String paramString);
  
  public abstract Damj getDateDebutContrat();
  
  public abstract void setDateDebutContrat(Damj paramDamj);
  
  public abstract String getCodeErreurDateDebutContrat();
  
  public abstract void setCodeErreurDateDebutContrat(String paramString);
  
  public abstract Damj getDateFinContrat();
  
  public abstract void setDateFinContrat(Damj paramDamj);
  
  public abstract String getCodeErreurDateFinContrat();
  
  public abstract void setCodeErreurDateFinContrat(String paramString);
  
  public abstract Damj getDateNotifRupture();
  
  public abstract void setDateNotifRupture(Damj paramDamj);
  
  public abstract String getCodeErreurDateNotifRupture();
  
  public abstract void setCodeErreurDateNotifRupture(String paramString);
  
  public abstract Damj getDateProcedureLicenciement();
  
  public abstract void setDateProcedureLicenciement(Damj paramDamj);
  
  public abstract String getCodeErreurDateProcedureLicenciement();
  
  public abstract void setCodeErreurDateProcedureLicenciement(String paramString);
  
  public abstract Damj getDateDJTP();
  
  public abstract void setDateDJTP(Damj paramDamj);
  
  public abstract String getCodeErreurDateDJTP();
  
  public abstract void setCodeErreurDateDJTP(String paramString);
  
  public abstract Damj getDateInitialeFinContrat();
  
  public abstract void setDateInitialeFinContrat(Damj paramDamj);
  
  public abstract String getCodeErreurDateInitialeFinContrat();
  
  public abstract void setCodeErreurDateInitialeFinContrat(String paramString);
  
  public abstract Damj getDateConnaissanceAE();
  
  public abstract void setDateConnaissanceAE(Damj paramDamj);
  
  public abstract String getCodeErreurDateConnaissanceAE();
  
  public abstract void setCodeErreurDateConnaissanceAE(String paramString);
  
  public abstract Damj getDateReprise();
  
  public abstract void setDateReprise(Damj paramDamj);
  
  public abstract String getCodeErreurDateReprise();
  
  public abstract void setCodeErreurDateReprise(String paramString);
  
  public abstract Damj getDateDebutIndemCP();
  
  public abstract void setDateDebutIndemCP(Damj paramDamj);
  
  public abstract String getCodeErreurDateDebutIndemCP();
  
  public abstract void setCodeErreurDateDebutIndemCP(String paramString);
  
  public abstract Damj getDateFinIndemCP();
  
  public abstract void setDateFinIndemCP(Damj paramDamj);
  
  public abstract String getCodeErreurDateFinIndemCP();
  
  public abstract void setCodeErreurDateFinIndemCP(String paramString);
  
  public abstract Damj getDateEffetCTP();
  
  public abstract void setDateEffetCTP(Damj paramDamj);
  
  public abstract String getCodeErreurDateEffetCTP();
  
  public abstract void setCodeErreurDateEffetCTP(String paramString);
  
  public abstract Damj getDateAdhesion();
  
  public abstract void setDateAdhesion(Damj paramDamj);
  
  public abstract String getCodeErreurDateAdhesion();
  
  public abstract void setCodeErreurDateAdhesion(String paramString);
  
  public abstract Damj getDateCessationActiviteEntreprise();
  
  public abstract void setDateCessationActiviteEntreprise(Damj paramDamj);
  
  public abstract String getCodeErreurDateCessationActiviteEntreprise();
  
  public abstract void setCodeErreurDateCessationActiviteEntreprise(String paramString);
  
  public abstract Damj getDateDebutPeriodeAffiliationEntreprise();
  
  public abstract void setDateDebutPeriodeAffiliationEntreprise(Damj paramDamj);
  
  public abstract String getCodeErreurDateDebutPeriodeAffiliationEntreprise();
  
  public abstract void setCodeErreurDateDebutPeriodeAffiliationEntreprise(String paramString);
  
  public abstract Damj getDateFinPeriodeAffiliationEntreprise();
  
  public abstract void setDateFinPeriodeAffiliationEntreprise(Damj paramDamj);
  
  public abstract String getCodeErreurDateFinPeriodeAffiliationEntreprise();
  
  public abstract void setCodeErreurDateFinPeriodeAffiliationEntreprise(String paramString);
  
  public abstract Damj getDateDebutEffetConGes();
  
  public abstract void setDateDebutEffetConGes(Damj paramDamj);
  
  public abstract String getCodeErreurDateDebutEffetConGes();
  
  public abstract void setCodeErreurDateDebutEffetConGes(String paramString);
  
  public abstract Damj getDateFinEffetConGes();
  
  public abstract void setDateFinEffetConGes(Damj paramDamj);
  
  public abstract String getCodeErreurDateFinEffetConGes();
  
  public abstract void setCodeErreurDateFinEffetConGes(String paramString);
  
  public abstract BigDecimal getNumeroVersion();
  
  public abstract void setNumeroVersion(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurNumeroVersion();
  
  public abstract void setCodeErreurNumeroVersion(String paramString);
  
  public abstract BigDecimal getIdTechContratDna();
  
  public abstract void setIdTechContratDna(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurIdTechContratDna();
  
  public abstract void setCodeErreurIdTechContratDna(String paramString);
  
  public abstract BigDecimal getNbCongesPayesRestant();
  
  public abstract void setNbCongesPayesRestant(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurNbCongesPayesRestant();
  
  public abstract void setCodeErreurNbCongesPayesRestant(String paramString);
  
  public abstract BigDecimal getMontantIndemnitePreavis();
  
  public abstract void setMontantIndemnitePreavis(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurMontantIndemnitePreavis();
  
  public abstract void setCodeErreurMontantIndemnitePreavis(String paramString);
  
  public abstract BigDecimal getNbHeuresDIF();
  
  public abstract void setNbHeuresDIF(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurNbHeuresDIF();
  
  public abstract void setCodeErreurNbHeuresDIF(String paramString);
  
  public abstract BigDecimal getSalaireHoraireNetSalarie();
  
  public abstract void setSalaireHoraireNetSalarie(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurSalaireHoraireNetSalarie();
  
  public abstract void setCodeErreurSalaireHoraireNetSalarie(String paramString);
  
  public abstract BigDecimal getIdTechContratRemplace();
  
  public abstract void setIdTechContratRemplace(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurIdTechContratRemplace();
  
  public abstract void setCodeErreurIdTechContratRemplace(String paramString);
  
  public abstract BigDecimal getNbPAS();
  
  public abstract void setNbPAS(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurNbPAS();
  
  public abstract void setCodeErreurNbPAS(String paramString);
  
  public abstract BigDecimal getNbSalariesEntreprise();
  
  public abstract void setNbSalariesEntreprise(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurNbSalariesEntreprise();
  
  public abstract void setCodeErreurNbSalariesEntreprise(String paramString);
  
  public abstract BigDecimal getNbMoisPreavis();
  
  public abstract void setNbMoisPreavis(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurNbMoisPreavis();
  
  public abstract void setCodeErreurNbMoisPreavis(String paramString);
}

/* Location:
 * Qualified Name:     FluxFctDna
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */