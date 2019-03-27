package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;

public abstract class FluxGUSO
{
  public static FluxGUSO getInstance()
  {
    return new _FluxGUSOImpl();
  }
  
  public abstract boolean isEnErreur();
  
  public abstract String getIdentifiant();
  
  public abstract void setIdentifiant(String paramString);
  
  public abstract String getCodeEtat();
  
  public abstract void setCodeEtat(String paramString);
  
  public abstract String getCodeMouvement();
  
  public abstract void setCodeMouvement(String paramString);
  
  public abstract String getCodeErreurCodeMouvement();
  
  public abstract void setCodeErreurCodeMouvement(String paramString);
  
  public abstract String getPrenomEmployeur();
  
  public abstract void setPrenomEmployeur(String paramString);
  
  public abstract String getCodeErreurPrenomEmployeur();
  
  public abstract void setCodeErreurPrenomEmployeur(String paramString);
  
  public abstract String getNumeroGuso();
  
  public abstract void setNumeroGuso(String paramString);
  
  public abstract String getCodeErreurNumeroGuso();
  
  public abstract void setCodeErreurNumeroGuso(String paramString);
  
  public abstract String getCodeNAF();
  
  public abstract void setCodeNAF(String paramString);
  
  public abstract String getCodeErreurCodeNAF();
  
  public abstract void setCodeErreurCodeNAF(String paramString);
  
  public abstract String getIdentifiantBNI();
  
  public abstract void setIdentifiantBNI(String paramString);
  
  public abstract String getCodeErreurIdentifiantBNI();
  
  public abstract void setCodeErreurIdentifiantBNI(String paramString);
  
  public abstract String getNom();
  
  public abstract void setNom(String paramString);
  
  public abstract String getCodeErreurNom();
  
  public abstract void setCodeErreurNom(String paramString);
  
  public abstract String getPrenom();
  
  public abstract void setPrenom(String paramString);
  
  public abstract String getCodeErreurPrenom();
  
  public abstract void setCodeErreurPrenom(String paramString);
  
  public abstract String getNIRIntermittent();
  
  public abstract void setNIRIntermittent(String paramString);
  
  public abstract String getCodeErreurNIRIntermittent();
  
  public abstract void setCodeErreurNIRIntermittent(String paramString);
  
  public abstract String getEmploiOccupe();
  
  public abstract void setEmploiOccupe(String paramString);
  
  public abstract String getCodeErreurEmploiOccupe();
  
  public abstract void setCodeErreurEmploiOccupe(String paramString);
  
  public abstract String getIdPrestation();
  
  public abstract void setIdPrestation(String paramString);
  
  public abstract String getCodeErreurIdPrestation();
  
  public abstract void setCodeErreurIdPrestation(String paramString);
  
  public abstract String getNatureActivite();
  
  public abstract void setNatureActivite(String paramString);
  
  public abstract String getCodeErreurNatureActivite();
  
  public abstract void setCodeErreurNatureActivite(String paramString);
  
  public abstract String getMotifFCT();
  
  public abstract void setMotifFCT(String paramString);
  
  public abstract String getCodeErreurMotifFCT();
  
  public abstract void setCodeErreurMotifFCT(String paramString);
  
  public abstract String getCodeDevise();
  
  public abstract void setCodeDevise(String paramString);
  
  public abstract String getCodeErreurCodeDevise();
  
  public abstract void setCodeErreurCodeDevise(String paramString);
  
  public abstract String getIdentifiantBNE();
  
  public abstract void setIdentifiantBNE(String paramString);
  
  public abstract String getCodeErreurIdentifiantBNE();
  
  public abstract void setCodeErreurIdentifiantBNE(String paramString);
  
  public abstract String getSiretBNE();
  
  public abstract void setSiretBNE(String paramString);
  
  public abstract String getCodeErreurSiretBNE();
  
  public abstract void setCodeErreurSiretBNE(String paramString);
  
  public abstract String getRaisonSocialeBNE();
  
  public abstract void setRaisonSocialeBNE(String paramString);
  
  public abstract String getCodeErreurRaisonSocialeBNE();
  
  public abstract void setCodeErreurRaisonSocialeBNE(String paramString);
  
  public abstract String getNumeroRueBNE();
  
  public abstract void setNumeroRueBNE(String paramString);
  
  public abstract String getCodeErreurNumeroRueBNE();
  
  public abstract void setCodeErreurNumeroRueBNE(String paramString);
  
  public abstract String getAdresse1BNE();
  
  public abstract void setAdresse1BNE(String paramString);
  
  public abstract String getCodeErreurAdresse1BNE();
  
  public abstract void setCodeErreurAdresse1BNE(String paramString);
  
  public abstract String getAdresse2BNE();
  
  public abstract void setAdresse2BNE(String paramString);
  
  public abstract String getCodeErreurAdresse2BNE();
  
  public abstract void setCodeErreurAdresse2BNE(String paramString);
  
  public abstract String getCodePostalBNE();
  
  public abstract void setCodePostalBNE(String paramString);
  
  public abstract String getCodeErreurCodePostalBNE();
  
  public abstract void setCodeErreurCodePostalBNE(String paramString);
  
  public abstract String getLibelleCommuneBNE();
  
  public abstract void setLibelleCommuneBNE(String paramString);
  
  public abstract String getCodeErreurLibelleCommuneBNE();
  
  public abstract void setCodeErreurLibelleCommuneBNE(String paramString);
  
  public abstract String getAssedicAffiliationBNE();
  
  public abstract void setAssedicAffiliationBNE(String paramString);
  
  public abstract String getCodeErreurAssedicAffiliationBNE();
  
  public abstract void setCodeErreurAssedicAffiliationBNE(String paramString);
  
  public abstract String getNumeroAffiliationBNE();
  
  public abstract void setNumeroAffiliationBNE(String paramString);
  
  public abstract String getCodeErreurNumeroAffiliationBNE();
  
  public abstract void setCodeErreurNumeroAffiliationBNE(String paramString);
  
  public abstract String getNouveauCodeNAF();
  
  public abstract void setNouveauCodeNAF(String paramString);
  
  public abstract String getCodeErreurNouveauCodeNAF();
  
  public abstract void setCodeErreurNouveauCodeNAF(String paramString);
  
  public abstract String getRaisonSocialeEmployeur();
  
  public abstract void setRaisonSocialeEmployeur(String paramString);
  
  public abstract String getCodeErreurRaisonSocialeEmployeur();
  
  public abstract void setCodeErreurRaisonSocialeEmployeur(String paramString);
  
  public abstract String getNumeroTelephone();
  
  public abstract void setNumeroTelephone(String paramString);
  
  public abstract String getCodeErreurNumeroTelephone();
  
  public abstract void setCodeErreurNumeroTelephone(String paramString);
  
  public abstract String getNumeroFax();
  
  public abstract void setNumeroFax(String paramString);
  
  public abstract String getCodeErreurNumeroFax();
  
  public abstract void setCodeErreurNumeroFax(String paramString);
  
  public abstract String getPremiereLigneAdresseEmployeurCourrier();
  
  public abstract void setPremiereLigneAdresseEmployeurCourrier(String paramString);
  
  public abstract String getCodeErreurPremiereLigneAdresseEmployeurCourrier();
  
  public abstract void setCodeErreurPremiereLigneAdresseEmployeurCourrier(String paramString);
  
  public abstract String getDeuxiemeLigneAdresseEmployeurCourrier();
  
  public abstract void setDeuxiemeLigneAdresseEmployeurCourrier(String paramString);
  
  public abstract String getCodeErreurDeuxiemeLigneAdresseEmployeurCourrier();
  
  public abstract void setCodeErreurDeuxiemeLigneAdresseEmployeurCourrier(String paramString);
  
  public abstract String getTroisiemeLigneAdresseEmployeurCourrier();
  
  public abstract void setTroisiemeLigneAdresseEmployeurCourrier(String paramString);
  
  public abstract String getCodeErreurTroisiemeLigneAdresseEmployeurCourrier();
  
  public abstract void setCodeErreurTroisiemeLigneAdresseEmployeurCourrier(String paramString);
  
  public abstract String getQuatriemeLigneAdresseEmployeurCourrier();
  
  public abstract void setQuatriemeLigneAdresseEmployeurCourrier(String paramString);
  
  public abstract String getCodeErreurQuatriemeLigneAdresseEmployeurCourrier();
  
  public abstract void setCodeErreurQuatriemeLigneAdresseEmployeurCourrier(String paramString);
  
  public abstract String getSiret();
  
  public abstract void setSiret(String paramString);
  
  public abstract String getCodeErreurSiret();
  
  public abstract void setCodeErreurSiret(String paramString);
  
  public abstract String getFormeJuridique();
  
  public abstract void setFormeJuridique(String paramString);
  
  public abstract String getCodeErreurFormeJuridique();
  
  public abstract void setCodeErreurFormeJuridique(String paramString);
  
  public abstract String getPseudo();
  
  public abstract void setPseudo(String paramString);
  
  public abstract String getCodeErreurPseudo();
  
  public abstract void setCodeErreurPseudo(String paramString);
  
  public abstract String getPremiereLigneAdresseIntermittentCourrier();
  
  public abstract void setPremiereLigneAdresseIntermittentCourrier(String paramString);
  
  public abstract String getCodeErreurPremiereLigneAdresseIntermittentCourrier();
  
  public abstract void setCodeErreurPremiereLigneAdresseIntermittentCourrier(String paramString);
  
  public abstract String getDeuxiemeLigneAdresseIntermittentCourrier();
  
  public abstract void setDeuxiemeLigneAdresseIntermittentCourrier(String paramString);
  
  public abstract String getCodeErreurDeuxiemeLigneAdresseIntermittentCourrier();
  
  public abstract void setCodeErreurDeuxiemeLigneAdresseIntermittentCourrier(String paramString);
  
  public abstract String getTroisiemeLigneAdresseIntermittentCourrier();
  
  public abstract void setTroisiemeLigneAdresseIntermittentCourrier(String paramString);
  
  public abstract String getCodeErreurTroisiemeLigneAdresseIntermittentCourrier();
  
  public abstract void setCodeErreurTroisiemeLigneAdresseIntermittentCourrier(String paramString);
  
  public abstract String getQuatriemeLigneAdresseIntermittentCourrier();
  
  public abstract void setQuatriemeLigneAdresseIntermittentCourrier(String paramString);
  
  public abstract String getCodeErreurQuatriemeLigneAdresseIntermittentCourrier();
  
  public abstract void setCodeErreurQuatriemeLigneAdresseIntermittentCourrier(String paramString);
  
  public abstract String getPositionEmployeur();
  
  public abstract void setPositionEmployeur(String paramString);
  
  public abstract String getCodeErreurPositionEmployeur();
  
  public abstract void setCodeErreurPositionEmployeur(String paramString);
  
  public abstract String getPositionAutreEmployeur();
  
  public abstract void setPositionAutreEmployeur(String paramString);
  
  public abstract String getCodeErreurPositionAutreEmployeur();
  
  public abstract void setCodeErreurPositionAutreEmployeur(String paramString);
  
  public abstract String getCodeAssedic();
  
  public abstract void setCodeAssedic(String paramString);
  
  public abstract String getCodeErreurCodeAssedic();
  
  public abstract void setCodeErreurCodeAssedic(String paramString);
  
  public abstract String getRsin();
  
  public abstract void setRsin(String paramString);
  
  public abstract String getCodeErreurRsin();
  
  public abstract void setCodeErreurRsin(String paramString);
  
  public abstract String getCodeNAFBNE();
  
  public abstract void setCodeNAFBNE(String paramString);
  
  public abstract String getCodeErreurCodeNAFBNE();
  
  public abstract void setCodeErreurCodeNAFBNE(String paramString);
  
  public abstract String getCodeEmploiOccupe();
  
  public abstract void setCodeEmploiOccupe(String paramString);
  
  public abstract String getCodeErreurCodeEmploiOccupe();
  
  public abstract void setCodeErreurCodeEmploiOccupe(String paramString);
  
  public abstract String getNumeroObjet();
  
  public abstract void setNumeroObjet(String paramString);
  
  public abstract String getCodeErreurNumeroObjet();
  
  public abstract void setCodeErreurNumeroObjet(String paramString);
  
  public abstract String getCadre();
  
  public abstract void setCadre(String paramString);
  
  public abstract String getCodeErreurCadre();
  
  public abstract void setCodeErreurCadre(String paramString);
  
  public abstract String getForfaitUrssaf();
  
  public abstract void setForfaitUrssaf(String paramString);
  
  public abstract String getCodeErreurForfaitUrssaf();
  
  public abstract void setCodeErreurForfaitUrssaf(String paramString);
  
  public abstract String getTopAlsaceMoselle();
  
  public abstract void setTopAlsaceMoselle(String paramString);
  
  public abstract String getCodeErreurTopAlsaceMoselle();
  
  public abstract void setCodeErreurTopAlsaceMoselle(String paramString);
  
  public abstract Damj getDateDebutContrat();
  
  public abstract void setDateDebutContrat(Damj paramDamj);
  
  public abstract String getCodeErreurDateDebutContrat();
  
  public abstract void setCodeErreurDateDebutContrat(String paramString);
  
  public abstract Damj getDateFinContrat();
  
  public abstract void setDateFinContrat(Damj paramDamj);
  
  public abstract String getCodeErreurDateFinContrat();
  
  public abstract void setCodeErreurDateFinContrat(String paramString);
  
  public abstract Damj getDateCreation();
  
  public abstract void setDateCreation(Damj paramDamj);
  
  public abstract String getCodeErreurDateCreation();
  
  public abstract void setCodeErreurDateCreation(String paramString);
  
  public abstract Damj getDateOrigineInformation();
  
  public abstract void setDateOrigineInformation(Damj paramDamj);
  
  public abstract String getCodeErreurDateOrigineInformation();
  
  public abstract void setCodeErreurDateOrigineInformation(String paramString);
  
  public abstract Damj getDateCreationFeuillet();
  
  public abstract void setDateCreationFeuillet(Damj paramDamj);
  
  public abstract String getCodeErreurDateCreationFeuillet();
  
  public abstract void setCodeErreurDateCreationFeuillet(String paramString);
  
  public abstract BigDecimal getNbJoursTravailles();
  
  public abstract void setNbJoursTravailles(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurNbJoursTravailles();
  
  public abstract void setCodeErreurNbJoursTravailles(String paramString);
  
  public abstract BigDecimal getNbHeuresTravaillees();
  
  public abstract void setNbHeuresTravaillees(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurNbHeuresTravaillees();
  
  public abstract void setCodeErreurNbHeuresTravaillees(String paramString);
  
  public abstract BigDecimal getNbCachets();
  
  public abstract void setNbCachets(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurNbCachets();
  
  public abstract void setCodeErreurNbCachets(String paramString);
  
  public abstract BigDecimal getSalaireBrutNonAbattu();
  
  public abstract void setSalaireBrutNonAbattu(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurSalaireBrutNonAbattu();
  
  public abstract void setCodeErreurSalaireBrutNonAbattu(String paramString);
  
  public abstract BigDecimal getSalaireBrutAbattu();
  
  public abstract void setSalaireBrutAbattu(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurSalaireBrutAbattu();
  
  public abstract void setCodeErreurSalaireBrutAbattu(String paramString);
  
  public abstract BigDecimal getNumeroChrono();
  
  public abstract void setNumeroChrono(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurNumeroChrono();
  
  public abstract void setCodeErreurNumeroChrono(String paramString);
  
  public abstract BigDecimal getMontantIccp();
  
  public abstract void setMontantIccp(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurMontantIccp();
  
  public abstract void setCodeErreurMontantIccp(String paramString);
  
  public abstract BigDecimal getMontantAvantageNature();
  
  public abstract void setMontantAvantageNature(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurMontantAvantageNature();
  
  public abstract void setCodeErreurMontantAvantageNature(String paramString);
  
  public abstract BigDecimal getMontantFraisProfessionnel();
  
  public abstract void setMontantFraisProfessionnel(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurMontantFraisProfessionnel();
  
  public abstract void setCodeErreurMontantFraisProfessionnel(String paramString);
  
  public abstract BigDecimal getTauxAbattement();
  
  public abstract void setTauxAbattement(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurTauxAbattement();
  
  public abstract void setCodeErreurTauxAbattement(String paramString);
}

/* Location:
 * Qualified Name:     FluxGUSO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */