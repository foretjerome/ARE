package fr.unedic.cali.parcours;

import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;

public class ResultatPbjcDetailler
  extends Resultat
{
  private static final long serialVersionUID = -7094583825207106612L;
  private Damj dateDebut;
  private Damj dateFin;
  private Damj dateDepartRetraiteCalculee;
  private Damj dernierJourIndemnisable;
  private boolean isAnomalieBloquant;
  private String codeAnomalieCalcul;
  private String donneeAnomalieCalcul;
  private int refOdPjcPremierFaitGenerateur;
  private int refOdPjcFaitGenerateurOrigine;
  private int identifiantReprise;
  private int nbJoursImputes;
  private int nbJoursDecalage;
  private String naturePBJC;
  private String naturePbjcLibelle;
  private int reliquatDureeMax;
  private int reliquatDureeReglementaire;
  private String etatReglementaireOd;
  private String etatReglementaireOdLibelle;
  private String etatAdministratifOd;
  private String etatAdministratifOdLibelle;
  private String produit;
  private String typeCarence;
  private String categorieAttribution;
  private String categorieAttributionLibelle;
  private String justificationCalculMontant;
  private String justificationCalculMontantLibelle;
  private BigDecimal montantBrutJournalier;
  private BigDecimal totalBrutJournalier;
  private int statutPaiement;
  private String statutPaiementLibelle;
  private String codeMotifNonPaiement;
  private String codeMotifNonPaiementLibelle;
  private BigDecimal montantRessourceMensuel;
  private BigDecimal montantPensionInvalidite;
  private BigDecimal montantSalaireRevalorisePlafonne;
  private BigDecimal coefAvantageVieillesse;
  private BigDecimal montantCumuleRevaloriseAV;
  private String codeEtatPND;
  private BigDecimal montantBaseJustificatifPND;
  private int nbMoisActiviteReduite;
  private int cumulHeureActRed;
  private String typeDispositif;
  private String complementDeJustification0;
  private String complementDeJustification0Libelle;
  private String complementDeJustification1;
  private String complementDeJustification1Libelle;
  private String complementDeJustification2;
  private String complementDeJustification2Libelle;
  private String complementDeJustification3;
  private String complementDeJustification3Libelle;
  private String complementDeJustification4;
  private String complementDeJustification4Libelle;
  private String complementDeJustification5;
  private String complementDeJustification5Libelle;
  private String complementDeJustification6;
  private String complementDeJustification6Libelle;
  private String complementDeJustification7;
  private String complementDeJustification7Libelle;
  private String complementDeJustification8;
  private String complementDeJustification8Libelle;
  private String complementDeJustification9;
  private String complementDeJustification9Libelle;
  private String codeTypeMontant1;
  private int complementTypeMontant1;
  private String complementTypeMontant1Libelle;
  private BigDecimal assiette1;
  private BigDecimal baseDeCalcul1;
  private BigDecimal taux1;
  private BigDecimal resultatCalcul1;
  private String positionExoneration1;
  private String positionExoneration1Libelle;
  private String codeTypeMontant2;
  private int complementTypeMontant2;
  private String complementTypeMontant2Libelle;
  private BigDecimal assiette2;
  private BigDecimal baseDeCalcul2;
  private BigDecimal taux2;
  private BigDecimal resultatCalcul2;
  private String positionExoneration2;
  private String positionExoneration2Libelle;
  private String codeTypeMontant3;
  private int complementTypeMontant3;
  private String complementTypeMontant3Libelle;
  private BigDecimal assiette3;
  private BigDecimal baseDeCalcul3;
  private BigDecimal taux3;
  private BigDecimal resultatCalcul3;
  private String positionExoneration3;
  private String positionExoneration3Libelle;
  private String codeTypeMontant4;
  private int complementTypeMontant4;
  private String complementTypeMontant4Libelle;
  private BigDecimal assiette4;
  private BigDecimal baseDeCalcul4;
  private BigDecimal taux4;
  private BigDecimal resultatCalcul4;
  private String positionExoneration4;
  private String positionExoneration4Libelle;
  private String codeTypeMontant5;
  private int complementTypeMontant5;
  private String complementTypeMontant5Libelle;
  private BigDecimal assiette5;
  private BigDecimal baseDeCalcul5;
  private BigDecimal taux5;
  private BigDecimal resultatCalcul5;
  private String positionExoneration5;
  private String positionExoneration5Libelle;
  private String codeTypeMontant6;
  private int complementTypeMontant6;
  private String complementTypeMontant6Libelle;
  private BigDecimal assiette6;
  private BigDecimal baseDeCalcul6;
  private BigDecimal taux6;
  private BigDecimal resultatCalcul6;
  private String positionExoneration6;
  private String positionExoneration6Libelle;
  private String codeTypeMontant7;
  private int complementTypeMontant7;
  private String complementTypeMontant7Libelle;
  private BigDecimal assiette7;
  private BigDecimal baseDeCalcul7;
  private BigDecimal taux7;
  private BigDecimal resultatCalcul7;
  private String positionExoneration7;
  private String positionExoneration7Libelle;
  private String tsp;
  private int rangProlongation;
  private BigDecimal montantSjc;
  private BigDecimal coefTempsPartiel;
  private String situationParticuliere;
  private String situationParticuliereLibelle;
  private String codePays;
  private String libellePays;
  private String codeTypePopulation1;
  private String codeSousTypePopulation1;
  private String codeStatut1;
  private String codeTypePopulation2;
  private String codeSousTypePopulation2;
  private String codeStatut2;
  private String codeTypePopulation3;
  private String codeSousTypePopulation3;
  private String codeStatut3;
  private String codeTypePopulation4;
  private String codeSousTypePopulation4;
  private String codeStatut4;
  private String codeTypePopulation5;
  private String codeSousTypePopulation5;
  private String codeStatut5;
  private String libelleTypePopulation1;
  private String libelleSousTypePopulation1;
  private String libelleStatut1;
  private String libelleTypePopulation2;
  private String libelleSousTypePopulation2;
  private String libelleStatut2;
  private String libelleTypePopulation3;
  private String libelleSousTypePopulation3;
  private String libelleStatut3;
  private String libelleTypePopulation4;
  private String libelleSousTypePopulation4;
  private String libelleStatut4;
  private String libelleTypePopulation5;
  private String libelleSousTypePopulation5;
  private String libelleStatut5;
  private boolean presencePNDS;
  private BigDecimal montantContMensuelEmploiRepris;
  private BigDecimal excedentsRemunerationMois;
  private BigDecimal cumulAllongementPlan;
  private BigDecimal reliquatAllongementAref;
  private BigDecimal nbJourAllongementAref;
  
  public BigDecimal getCumulAllongementPlan()
  {
    return cumulAllongementPlan;
  }
  
  public void setCumulAllongementPlan(BigDecimal cumulAllongementPlan)
  {
    this.cumulAllongementPlan = cumulAllongementPlan;
  }
  
  public BigDecimal getReliquatAllongementAref()
  {
    return reliquatAllongementAref;
  }
  
  public void setReliquatAllongementAref(BigDecimal reliquatAllongementAref)
  {
    this.reliquatAllongementAref = reliquatAllongementAref;
  }
  
  public BigDecimal getNbJourAllongementAref()
  {
    return nbJourAllongementAref;
  }
  
  public void setNbJourAllongementAref(BigDecimal nbJourAllongementAref)
  {
    this.nbJourAllongementAref = nbJourAllongementAref;
  }
  
  public String getTsp()
  {
    return tsp;
  }
  
  public void setTsp(String ptsp)
  {
    tsp = ptsp;
  }
  
  public String getComplementDeJustification0Libelle()
  {
    return complementDeJustification0Libelle;
  }
  
  public void setComplementDeJustification0Libelle(String pcomplementDeJustification0Libelle)
  {
    complementDeJustification0Libelle = pcomplementDeJustification0Libelle;
  }
  
  public String getComplementDeJustification1Libelle()
  {
    return complementDeJustification1Libelle;
  }
  
  public void setComplementDeJustification1Libelle(String pcomplementDeJustification1Libelle)
  {
    complementDeJustification1Libelle = pcomplementDeJustification1Libelle;
  }
  
  public String getComplementDeJustification2Libelle()
  {
    return complementDeJustification2Libelle;
  }
  
  public void setComplementDeJustification2Libelle(String pcomplementDeJustification2Libelle)
  {
    complementDeJustification2Libelle = pcomplementDeJustification2Libelle;
  }
  
  public String getComplementDeJustification3Libelle()
  {
    return complementDeJustification3Libelle;
  }
  
  public void setComplementDeJustification3Libelle(String pcomplementDeJustification3Libelle)
  {
    complementDeJustification3Libelle = pcomplementDeJustification3Libelle;
  }
  
  public String getComplementDeJustification4Libelle()
  {
    return complementDeJustification4Libelle;
  }
  
  public void setComplementDeJustification4Libelle(String pcomplementDeJustification4Libelle)
  {
    complementDeJustification4Libelle = pcomplementDeJustification4Libelle;
  }
  
  public String getComplementDeJustification5Libelle()
  {
    return complementDeJustification5Libelle;
  }
  
  public void setComplementDeJustification5Libelle(String pcomplementDeJustification5Libelle)
  {
    complementDeJustification5Libelle = pcomplementDeJustification5Libelle;
  }
  
  public String getComplementDeJustification6Libelle()
  {
    return complementDeJustification6Libelle;
  }
  
  public void setComplementDeJustification6Libelle(String pcomplementDeJustification6Libelle)
  {
    complementDeJustification6Libelle = pcomplementDeJustification6Libelle;
  }
  
  public String getComplementDeJustification7Libelle()
  {
    return complementDeJustification7Libelle;
  }
  
  public void setComplementDeJustification7Libelle(String pcomplementDeJustification7Libelle)
  {
    complementDeJustification7Libelle = pcomplementDeJustification7Libelle;
  }
  
  public String getComplementDeJustification8Libelle()
  {
    return complementDeJustification8Libelle;
  }
  
  public void setComplementDeJustification8Libelle(String pcomplementDeJustification8Libelle)
  {
    complementDeJustification8Libelle = pcomplementDeJustification8Libelle;
  }
  
  public String getComplementDeJustification9Libelle()
  {
    return complementDeJustification9Libelle;
  }
  
  public void setComplementDeJustification9Libelle(String pcomplementDeJustification9Libelle)
  {
    complementDeJustification9Libelle = pcomplementDeJustification9Libelle;
  }
  
  public String getComplementDeJustification0()
  {
    return complementDeJustification0;
  }
  
  public void setComplementDeJustification0(String pcomplementDeJustification0)
  {
    complementDeJustification0 = pcomplementDeJustification0;
  }
  
  public String getComplementDeJustification1()
  {
    return complementDeJustification1;
  }
  
  public void setComplementDeJustification1(String pcomplementDeJustification1)
  {
    complementDeJustification1 = pcomplementDeJustification1;
  }
  
  public String getComplementDeJustification2()
  {
    return complementDeJustification2;
  }
  
  public void setComplementDeJustification2(String pcomplementDeJustification2)
  {
    complementDeJustification2 = pcomplementDeJustification2;
  }
  
  public String getComplementDeJustification3()
  {
    return complementDeJustification3;
  }
  
  public void setComplementDeJustification3(String pcomplementDeJustification3)
  {
    complementDeJustification3 = pcomplementDeJustification3;
  }
  
  public String getComplementDeJustification4()
  {
    return complementDeJustification4;
  }
  
  public void setComplementDeJustification4(String pcomplementDeJustification4)
  {
    complementDeJustification4 = pcomplementDeJustification4;
  }
  
  public String getComplementDeJustification5()
  {
    return complementDeJustification5;
  }
  
  public void setComplementDeJustification5(String pcomplementDeJustification5)
  {
    complementDeJustification5 = pcomplementDeJustification5;
  }
  
  public String getComplementDeJustification6()
  {
    return complementDeJustification6;
  }
  
  public void setComplementDeJustification6(String pcomplementDeJustification6)
  {
    complementDeJustification6 = pcomplementDeJustification6;
  }
  
  public String getComplementDeJustification7()
  {
    return complementDeJustification7;
  }
  
  public void setComplementDeJustification7(String pcomplementDeJustification7)
  {
    complementDeJustification7 = pcomplementDeJustification7;
  }
  
  public String getComplementDeJustification8()
  {
    return complementDeJustification8;
  }
  
  public void setComplementDeJustification8(String pcomplementDeJustification8)
  {
    complementDeJustification8 = pcomplementDeJustification8;
  }
  
  public String getComplementDeJustification9()
  {
    return complementDeJustification9;
  }
  
  public void setComplementDeJustification9(String pcomplementDeJustification9)
  {
    complementDeJustification9 = pcomplementDeJustification9;
  }
  
  public String getCodeEtatPND()
  {
    return codeEtatPND;
  }
  
  public void setCodeEtatPND(String pcodeEtatPND)
  {
    codeEtatPND = pcodeEtatPND;
  }
  
  public String getCodeMotifNonPaiement()
  {
    return codeMotifNonPaiement;
  }
  
  public void setCodeMotifNonPaiement(String pcodeMotifNonPaiement)
  {
    codeMotifNonPaiement = pcodeMotifNonPaiement;
  }
  
  public String getCodeMotifNonPaiementLibelle()
  {
    return codeMotifNonPaiementLibelle;
  }
  
  public void setCodeMotifNonPaiementLibelle(String pcodeMotifNonPaiementLibelle)
  {
    codeMotifNonPaiementLibelle = pcodeMotifNonPaiementLibelle;
  }
  
  public BigDecimal getCoefAvantageVieillesse()
  {
    return coefAvantageVieillesse;
  }
  
  public void setCoefAvantageVieillesse(BigDecimal pcoefAvantageVieillesse)
  {
    coefAvantageVieillesse = pcoefAvantageVieillesse;
  }
  
  public int getCumulHeureActRed()
  {
    return cumulHeureActRed;
  }
  
  public void setCumulHeureActRed(int pcumulHeureActRed)
  {
    cumulHeureActRed = pcumulHeureActRed;
  }
  
  public Damj getDateDebut()
  {
    return dateDebut;
  }
  
  public void setDateDebut(Damj pdateDebut)
  {
    dateDebut = pdateDebut;
  }
  
  public Damj getDateFin()
  {
    return dateFin;
  }
  
  public void setDateFin(Damj pdateFin)
  {
    dateFin = pdateFin;
  }
  
  public String getEtatAdministratifOd()
  {
    return etatAdministratifOd;
  }
  
  public void setEtatAdministratifOd(String petatAdministratifOd)
  {
    etatAdministratifOd = petatAdministratifOd;
  }
  
  public String getEtatAdministratifOdLibelle()
  {
    return etatAdministratifOdLibelle;
  }
  
  public void setEtatAdministratifOdLibelle(String petatAdministratifOdLibelle)
  {
    etatAdministratifOdLibelle = petatAdministratifOdLibelle;
  }
  
  public String getEtatReglementaireOd()
  {
    return etatReglementaireOd;
  }
  
  public void setEtatReglementaireOd(String petatReglementaireOd)
  {
    etatReglementaireOd = petatReglementaireOd;
  }
  
  public String getEtatReglementaireOdLibelle()
  {
    return etatReglementaireOdLibelle;
  }
  
  public void setEtatReglementaireOdLibelle(String petatReglementaireOdLibelle)
  {
    etatReglementaireOdLibelle = petatReglementaireOdLibelle;
  }
  
  public int getIdentifiantReprise()
  {
    return identifiantReprise;
  }
  
  public void setIdentifiantReprise(int pidentifiantReprise)
  {
    identifiantReprise = pidentifiantReprise;
  }
  
  public String getJustificationCalculMontant()
  {
    return justificationCalculMontant;
  }
  
  public void setJustificationCalculMontant(String pjustificationCalculMontant)
  {
    justificationCalculMontant = pjustificationCalculMontant;
  }
  
  public BigDecimal getMontantBaseJustificatifPND()
  {
    return montantBaseJustificatifPND;
  }
  
  public void setMontantBaseJustificatifPND(BigDecimal pmontantBaseJustificatifPND)
  {
    montantBaseJustificatifPND = pmontantBaseJustificatifPND;
  }
  
  public BigDecimal getMontantBrutJournalier()
  {
    return montantBrutJournalier;
  }
  
  public void setMontantBrutJournalier(BigDecimal pmontantBrutJournalier)
  {
    montantBrutJournalier = pmontantBrutJournalier;
  }
  
  public BigDecimal getMontantCumuleRevaloriseAV()
  {
    return montantCumuleRevaloriseAV;
  }
  
  public void setMontantCumuleRevaloriseAV(BigDecimal pmontantCumuleRevaloriseAV)
  {
    montantCumuleRevaloriseAV = pmontantCumuleRevaloriseAV;
  }
  
  public BigDecimal getMontantPensionInvalidite()
  {
    return montantPensionInvalidite;
  }
  
  public void setMontantPensionInvalidite(BigDecimal pmontantPensionInvalidite)
  {
    montantPensionInvalidite = pmontantPensionInvalidite;
  }
  
  public BigDecimal getMontantRessourceMensuel()
  {
    return montantRessourceMensuel;
  }
  
  public void setMontantRessourceMensuel(BigDecimal pmontantRessourceMensuel)
  {
    montantRessourceMensuel = pmontantRessourceMensuel;
  }
  
  public BigDecimal getMontantSalaireRevalorisePlafonne()
  {
    return montantSalaireRevalorisePlafonne;
  }
  
  public void setMontantSalaireRevalorisePlafonne(BigDecimal pmontantSalaireRevalorisePlafonne)
  {
    montantSalaireRevalorisePlafonne = pmontantSalaireRevalorisePlafonne;
  }
  
  public String getNaturePBJC()
  {
    return naturePBJC;
  }
  
  public void setNaturePBJC(String pnaturePBJC)
  {
    naturePBJC = pnaturePBJC;
  }
  
  public String getNaturePbjcLibelle()
  {
    return naturePbjcLibelle;
  }
  
  public void setNaturePbjcLibelle(String pnaturePbjcLibelle)
  {
    naturePbjcLibelle = pnaturePbjcLibelle;
  }
  
  public int getNbJoursDecalage()
  {
    return nbJoursDecalage;
  }
  
  public void setNbJoursDecalage(int pnbJoursDecalage)
  {
    nbJoursDecalage = pnbJoursDecalage;
  }
  
  public int getNbJoursImputes()
  {
    return nbJoursImputes;
  }
  
  public void setNbJoursImputes(int pnbJoursImputes)
  {
    nbJoursImputes = pnbJoursImputes;
  }
  
  public int getNbMoisActiviteReduite()
  {
    return nbMoisActiviteReduite;
  }
  
  public void setNbMoisActiviteReduite(int pnbMoisActiviteReduite)
  {
    nbMoisActiviteReduite = pnbMoisActiviteReduite;
  }
  
  public String getProduit()
  {
    return produit;
  }
  
  public void setProduit(String pproduit)
  {
    produit = pproduit;
  }
  
  public int getRefOdPjcFaitGenerateurOrigine()
  {
    return refOdPjcFaitGenerateurOrigine;
  }
  
  public void setRefOdPjcFaitGenerateurOrigine(int prefOdPjcFaitGenerateurOrigine)
  {
    refOdPjcFaitGenerateurOrigine = prefOdPjcFaitGenerateurOrigine;
  }
  
  public int getRefOdPjcPremierFaitGenerateur()
  {
    return refOdPjcPremierFaitGenerateur;
  }
  
  public void setRefOdPjcPremierFaitGenerateur(int prefOdPjcPremierFaitGenerateur)
  {
    refOdPjcPremierFaitGenerateur = prefOdPjcPremierFaitGenerateur;
  }
  
  public int getReliquatDureeMax()
  {
    return reliquatDureeMax;
  }
  
  public void setReliquatDureeMax(int preliquatDureeMax)
  {
    reliquatDureeMax = preliquatDureeMax;
  }
  
  public int getReliquatDureeReglementaire()
  {
    return reliquatDureeReglementaire;
  }
  
  public void setReliquatDureeReglementaire(int preliquatDureeReglementaire)
  {
    reliquatDureeReglementaire = preliquatDureeReglementaire;
  }
  
  public int getStatutPaiement()
  {
    return statutPaiement;
  }
  
  public void setStatutPaiement(int pstatutPaiement)
  {
    statutPaiement = pstatutPaiement;
  }
  
  public String getStatutPaiementLibelle()
  {
    return statutPaiementLibelle;
  }
  
  public void setStatutPaiementLibelle(String pstatutPaiementLibelle)
  {
    statutPaiementLibelle = pstatutPaiementLibelle;
  }
  
  public BigDecimal getTotalBrutJournalier()
  {
    return totalBrutJournalier;
  }
  
  public void setTotalBrutJournalier(BigDecimal ptotalBrutJournalier)
  {
    totalBrutJournalier = ptotalBrutJournalier;
  }
  
  public Damj getDateDepartRetraiteCalculee()
  {
    return dateDepartRetraiteCalculee;
  }
  
  public void setDateDepartRetraiteCalculee(Damj pdateDepartRetraiteCalculee)
  {
    dateDepartRetraiteCalculee = pdateDepartRetraiteCalculee;
  }
  
  public Damj getDernierJourIndemnisable()
  {
    return dernierJourIndemnisable;
  }
  
  public void setDernierJourIndemnisable(Damj pdernierJourIndemnisable)
  {
    dernierJourIndemnisable = pdernierJourIndemnisable;
  }
  
  public boolean isAnomalieBloquant()
  {
    return isAnomalieBloquant;
  }
  
  public void setAnomalieBloquant(boolean pisAnomalieBloquant)
  {
    isAnomalieBloquant = pisAnomalieBloquant;
  }
  
  public String getCodeAnomalieCalcul()
  {
    return codeAnomalieCalcul;
  }
  
  public void setCodeAnomalieCalcul(String pcodeAnomalieCalcul)
  {
    codeAnomalieCalcul = pcodeAnomalieCalcul;
  }
  
  public String getDonneeAnomalieCalcul()
  {
    return donneeAnomalieCalcul;
  }
  
  public void setDonneeAnomalieCalcul(String pdonneeAnomalieCalcul)
  {
    donneeAnomalieCalcul = pdonneeAnomalieCalcul;
  }
  
  public String getJustificationCalculMontantLibelle()
  {
    return justificationCalculMontantLibelle;
  }
  
  public void setJustificationCalculMontantLibelle(String pjustificationCalculMontantLibelle)
  {
    justificationCalculMontantLibelle = pjustificationCalculMontantLibelle;
  }
  
  public BigDecimal getAssiette1()
  {
    return assiette1;
  }
  
  public void setAssiette1(BigDecimal passiette1)
  {
    assiette1 = passiette1;
  }
  
  public BigDecimal getAssiette2()
  {
    return assiette2;
  }
  
  public void setAssiette2(BigDecimal passiette2)
  {
    assiette2 = passiette2;
  }
  
  public BigDecimal getAssiette3()
  {
    return assiette3;
  }
  
  public void setAssiette3(BigDecimal passiette3)
  {
    assiette3 = passiette3;
  }
  
  public BigDecimal getAssiette4()
  {
    return assiette4;
  }
  
  public void setAssiette4(BigDecimal passiette4)
  {
    assiette4 = passiette4;
  }
  
  public BigDecimal getAssiette5()
  {
    return assiette5;
  }
  
  public void setAssiette5(BigDecimal passiette5)
  {
    assiette5 = passiette5;
  }
  
  public BigDecimal getAssiette6()
  {
    return assiette6;
  }
  
  public void setAssiette6(BigDecimal passiette6)
  {
    assiette6 = passiette6;
  }
  
  public BigDecimal getAssiette7()
  {
    return assiette7;
  }
  
  public void setAssiette7(BigDecimal passiette7)
  {
    assiette7 = passiette7;
  }
  
  public BigDecimal getBaseDeCalcul1()
  {
    return baseDeCalcul1;
  }
  
  public void setBaseDeCalcul1(BigDecimal pbaseDeCalcul1)
  {
    baseDeCalcul1 = pbaseDeCalcul1;
  }
  
  public BigDecimal getBaseDeCalcul2()
  {
    return baseDeCalcul2;
  }
  
  public void setBaseDeCalcul2(BigDecimal pbaseDeCalcul2)
  {
    baseDeCalcul2 = pbaseDeCalcul2;
  }
  
  public BigDecimal getBaseDeCalcul3()
  {
    return baseDeCalcul3;
  }
  
  public void setBaseDeCalcul3(BigDecimal pbaseDeCalcul3)
  {
    baseDeCalcul3 = pbaseDeCalcul3;
  }
  
  public BigDecimal getBaseDeCalcul4()
  {
    return baseDeCalcul4;
  }
  
  public void setBaseDeCalcul4(BigDecimal pbaseDeCalcul4)
  {
    baseDeCalcul4 = pbaseDeCalcul4;
  }
  
  public BigDecimal getBaseDeCalcul5()
  {
    return baseDeCalcul5;
  }
  
  public void setBaseDeCalcul5(BigDecimal pbaseDeCalcul5)
  {
    baseDeCalcul5 = pbaseDeCalcul5;
  }
  
  public BigDecimal getBaseDeCalcul6()
  {
    return baseDeCalcul6;
  }
  
  public void setBaseDeCalcul6(BigDecimal pbaseDeCalcul6)
  {
    baseDeCalcul6 = pbaseDeCalcul6;
  }
  
  public BigDecimal getBaseDeCalcul7()
  {
    return baseDeCalcul7;
  }
  
  public void setBaseDeCalcul7(BigDecimal pbaseDeCalcul7)
  {
    baseDeCalcul7 = pbaseDeCalcul7;
  }
  
  public String getCodeTypeMontant1()
  {
    return codeTypeMontant1;
  }
  
  public void setCodeTypeMontant1(String pcodeTypeMontant1)
  {
    codeTypeMontant1 = pcodeTypeMontant1;
  }
  
  public String getCodeTypeMontant2()
  {
    return codeTypeMontant2;
  }
  
  public void setCodeTypeMontant2(String pcodeTypeMontant2)
  {
    codeTypeMontant2 = pcodeTypeMontant2;
  }
  
  public String getCodeTypeMontant3()
  {
    return codeTypeMontant3;
  }
  
  public void setCodeTypeMontant3(String pcodeTypeMontant3)
  {
    codeTypeMontant3 = pcodeTypeMontant3;
  }
  
  public String getCodeTypeMontant4()
  {
    return codeTypeMontant4;
  }
  
  public void setCodeTypeMontant4(String pcodeTypeMontant4)
  {
    codeTypeMontant4 = pcodeTypeMontant4;
  }
  
  public String getCodeTypeMontant5()
  {
    return codeTypeMontant5;
  }
  
  public void setCodeTypeMontant5(String pcodeTypeMontant5)
  {
    codeTypeMontant5 = pcodeTypeMontant5;
  }
  
  public String getCodeTypeMontant6()
  {
    return codeTypeMontant6;
  }
  
  public void setCodeTypeMontant6(String pcodeTypeMontant6)
  {
    codeTypeMontant6 = pcodeTypeMontant6;
  }
  
  public String getCodeTypeMontant7()
  {
    return codeTypeMontant7;
  }
  
  public void setCodeTypeMontant7(String pcodeTypeMontant7)
  {
    codeTypeMontant7 = pcodeTypeMontant7;
  }
  
  public int getComplementTypeMontant1()
  {
    return complementTypeMontant1;
  }
  
  public void setComplementTypeMontant1(int pcomplementTypeMontant1)
  {
    complementTypeMontant1 = pcomplementTypeMontant1;
  }
  
  public int getComplementTypeMontant2()
  {
    return complementTypeMontant2;
  }
  
  public void setComplementTypeMontant2(int pcomplementTypeMontant2)
  {
    complementTypeMontant2 = pcomplementTypeMontant2;
  }
  
  public int getComplementTypeMontant3()
  {
    return complementTypeMontant3;
  }
  
  public void setComplementTypeMontant3(int pcomplementTypeMontant3)
  {
    complementTypeMontant3 = pcomplementTypeMontant3;
  }
  
  public int getComplementTypeMontant4()
  {
    return complementTypeMontant4;
  }
  
  public void setComplementTypeMontant4(int pcomplementTypeMontant4)
  {
    complementTypeMontant4 = pcomplementTypeMontant4;
  }
  
  public int getComplementTypeMontant5()
  {
    return complementTypeMontant5;
  }
  
  public void setComplementTypeMontant5(int pcomplementTypeMontant5)
  {
    complementTypeMontant5 = pcomplementTypeMontant5;
  }
  
  public int getComplementTypeMontant6()
  {
    return complementTypeMontant6;
  }
  
  public void setComplementTypeMontant6(int pcomplementTypeMontant6)
  {
    complementTypeMontant6 = pcomplementTypeMontant6;
  }
  
  public int getComplementTypeMontant7()
  {
    return complementTypeMontant7;
  }
  
  public void setComplementTypeMontant7(int pcomplementTypeMontant7)
  {
    complementTypeMontant7 = pcomplementTypeMontant7;
  }
  
  public String getPositionExoneration1()
  {
    return positionExoneration1;
  }
  
  public void setPositionExoneration1(String ppositionExoneration1)
  {
    positionExoneration1 = ppositionExoneration1;
  }
  
  public String getPositionExoneration2()
  {
    return positionExoneration2;
  }
  
  public void setPositionExoneration2(String ppositionExoneration2)
  {
    positionExoneration2 = ppositionExoneration2;
  }
  
  public String getPositionExoneration3()
  {
    return positionExoneration3;
  }
  
  public void setPositionExoneration3(String ppositionExoneration3)
  {
    positionExoneration3 = ppositionExoneration3;
  }
  
  public String getPositionExoneration4()
  {
    return positionExoneration4;
  }
  
  public void setPositionExoneration4(String ppositionExoneration4)
  {
    positionExoneration4 = ppositionExoneration4;
  }
  
  public String getPositionExoneration5()
  {
    return positionExoneration5;
  }
  
  public void setPositionExoneration5(String ppositionExoneration5)
  {
    positionExoneration5 = ppositionExoneration5;
  }
  
  public String getPositionExoneration6()
  {
    return positionExoneration6;
  }
  
  public void setPositionExoneration6(String ppositionExoneration6)
  {
    positionExoneration6 = ppositionExoneration6;
  }
  
  public String getPositionExoneration7()
  {
    return positionExoneration7;
  }
  
  public void setPositionExoneration7(String ppositionExoneration7)
  {
    positionExoneration7 = ppositionExoneration7;
  }
  
  public BigDecimal getResultatCalcul1()
  {
    return resultatCalcul1;
  }
  
  public void setResultatCalcul1(BigDecimal presultatCalcul1)
  {
    resultatCalcul1 = presultatCalcul1;
  }
  
  public BigDecimal getResultatCalcul2()
  {
    return resultatCalcul2;
  }
  
  public void setResultatCalcul2(BigDecimal presultatCalcul2)
  {
    resultatCalcul2 = presultatCalcul2;
  }
  
  public BigDecimal getResultatCalcul3()
  {
    return resultatCalcul3;
  }
  
  public void setResultatCalcul3(BigDecimal presultatCalcul3)
  {
    resultatCalcul3 = presultatCalcul3;
  }
  
  public BigDecimal getResultatCalcul4()
  {
    return resultatCalcul4;
  }
  
  public void setResultatCalcul4(BigDecimal presultatCalcul4)
  {
    resultatCalcul4 = presultatCalcul4;
  }
  
  public BigDecimal getResultatCalcul5()
  {
    return resultatCalcul5;
  }
  
  public void setResultatCalcul5(BigDecimal presultatCalcul5)
  {
    resultatCalcul5 = presultatCalcul5;
  }
  
  public BigDecimal getResultatCalcul6()
  {
    return resultatCalcul6;
  }
  
  public void setResultatCalcul6(BigDecimal presultatCalcul6)
  {
    resultatCalcul6 = presultatCalcul6;
  }
  
  public BigDecimal getResultatCalcul7()
  {
    return resultatCalcul7;
  }
  
  public void setResultatCalcul7(BigDecimal presultatCalcul7)
  {
    resultatCalcul7 = presultatCalcul7;
  }
  
  public BigDecimal getTaux1()
  {
    return taux1;
  }
  
  public void setTaux1(BigDecimal ptaux1)
  {
    taux1 = ptaux1;
  }
  
  public BigDecimal getTaux2()
  {
    return taux2;
  }
  
  public void setTaux2(BigDecimal ptaux2)
  {
    taux2 = ptaux2;
  }
  
  public BigDecimal getTaux3()
  {
    return taux3;
  }
  
  public void setTaux3(BigDecimal ptaux3)
  {
    taux3 = ptaux3;
  }
  
  public BigDecimal getTaux4()
  {
    return taux4;
  }
  
  public void setTaux4(BigDecimal ptaux4)
  {
    taux4 = ptaux4;
  }
  
  public BigDecimal getTaux5()
  {
    return taux5;
  }
  
  public void setTaux5(BigDecimal ptaux5)
  {
    taux5 = ptaux5;
  }
  
  public BigDecimal getTaux6()
  {
    return taux6;
  }
  
  public void setTaux6(BigDecimal ptaux6)
  {
    taux6 = ptaux6;
  }
  
  public BigDecimal getTaux7()
  {
    return taux7;
  }
  
  public void setTaux7(BigDecimal ptaux7)
  {
    taux7 = ptaux7;
  }
  
  public String getComplementTypeMontant1Libelle()
  {
    return complementTypeMontant1Libelle;
  }
  
  public void setComplementTypeMontant1Libelle(String pcomplementTypeMontant1Libelle)
  {
    complementTypeMontant1Libelle = pcomplementTypeMontant1Libelle;
  }
  
  public String getComplementTypeMontant2Libelle()
  {
    return complementTypeMontant2Libelle;
  }
  
  public void setComplementTypeMontant2Libelle(String pcomplementTypeMontant2Libelle)
  {
    complementTypeMontant2Libelle = pcomplementTypeMontant2Libelle;
  }
  
  public String getComplementTypeMontant3Libelle()
  {
    return complementTypeMontant3Libelle;
  }
  
  public void setComplementTypeMontant3Libelle(String pcomplementTypeMontant3Libelle)
  {
    complementTypeMontant3Libelle = pcomplementTypeMontant3Libelle;
  }
  
  public String getComplementTypeMontant4Libelle()
  {
    return complementTypeMontant4Libelle;
  }
  
  public void setComplementTypeMontant4Libelle(String pcomplementTypeMontant4Libelle)
  {
    complementTypeMontant4Libelle = pcomplementTypeMontant4Libelle;
  }
  
  public String getComplementTypeMontant5Libelle()
  {
    return complementTypeMontant5Libelle;
  }
  
  public void setComplementTypeMontant5Libelle(String pcomplementTypeMontant5Libelle)
  {
    complementTypeMontant5Libelle = pcomplementTypeMontant5Libelle;
  }
  
  public String getComplementTypeMontant6Libelle()
  {
    return complementTypeMontant6Libelle;
  }
  
  public void setComplementTypeMontant6Libelle(String pcomplementTypeMontant6Libelle)
  {
    complementTypeMontant6Libelle = pcomplementTypeMontant6Libelle;
  }
  
  public String getComplementTypeMontant7Libelle()
  {
    return complementTypeMontant7Libelle;
  }
  
  public void setComplementTypeMontant7Libelle(String pcomplementTypeMontant7Libelle)
  {
    complementTypeMontant7Libelle = pcomplementTypeMontant7Libelle;
  }
  
  public String getPositionExoneration1Libelle()
  {
    return positionExoneration1Libelle;
  }
  
  public void setPositionExoneration1Libelle(String ppositionExoneration1Libelle)
  {
    positionExoneration1Libelle = ppositionExoneration1Libelle;
  }
  
  public String getPositionExoneration2Libelle()
  {
    return positionExoneration2Libelle;
  }
  
  public void setPositionExoneration2Libelle(String ppositionExoneration2Libelle)
  {
    positionExoneration2Libelle = ppositionExoneration2Libelle;
  }
  
  public String getPositionExoneration3Libelle()
  {
    return positionExoneration3Libelle;
  }
  
  public void setPositionExoneration3Libelle(String ppositionExoneration3Libelle)
  {
    positionExoneration3Libelle = ppositionExoneration3Libelle;
  }
  
  public String getPositionExoneration4Libelle()
  {
    return positionExoneration4Libelle;
  }
  
  public void setPositionExoneration4Libelle(String ppositionExoneration4Libelle)
  {
    positionExoneration4Libelle = ppositionExoneration4Libelle;
  }
  
  public String getPositionExoneration5Libelle()
  {
    return positionExoneration5Libelle;
  }
  
  public void setPositionExoneration5Libelle(String ppositionExoneration5Libelle)
  {
    positionExoneration5Libelle = ppositionExoneration5Libelle;
  }
  
  public String getPositionExoneration6Libelle()
  {
    return positionExoneration6Libelle;
  }
  
  public void setPositionExoneration6Libelle(String ppositionExoneration6Libelle)
  {
    positionExoneration6Libelle = ppositionExoneration6Libelle;
  }
  
  public String getPositionExoneration7Libelle()
  {
    return positionExoneration7Libelle;
  }
  
  public void setPositionExoneration7Libelle(String ppositionExoneration7Libelle)
  {
    positionExoneration7Libelle = ppositionExoneration7Libelle;
  }
  
  public static long getSerialVersionUID()
  {
    return -7094583825207106612L;
  }
  
  public BigDecimal getCoefTempsPartiel()
  {
    return coefTempsPartiel;
  }
  
  public void setCoefTempsPartiel(BigDecimal pcoefTempsPartiel)
  {
    coefTempsPartiel = pcoefTempsPartiel;
  }
  
  public BigDecimal getMontantSjc()
  {
    return montantSjc;
  }
  
  public void setMontantSjc(BigDecimal pmontantSjc)
  {
    montantSjc = pmontantSjc;
  }
  
  public int getRangProlongation()
  {
    return rangProlongation;
  }
  
  public void setRangProlongation(int prangProlongation)
  {
    rangProlongation = prangProlongation;
  }
  
  public String getSituationParticuliere()
  {
    return situationParticuliere;
  }
  
  public void setSituationParticuliere(String psituationParticuliere)
  {
    situationParticuliere = psituationParticuliere;
  }
  
  public String getSituationParticuliereLibelle()
  {
    return situationParticuliereLibelle;
  }
  
  public void setSituationParticuliereLibelle(String psituationParticuliereLibelle)
  {
    situationParticuliereLibelle = psituationParticuliereLibelle;
  }
  
  public String getCategorieAttribution()
  {
    return categorieAttribution;
  }
  
  public void setCategorieAttribution(String pcategorieAttribution)
  {
    categorieAttribution = pcategorieAttribution;
  }
  
  public String getCategorieAttributionLibelle()
  {
    return categorieAttributionLibelle;
  }
  
  public void setCategorieAttributionLibelle(String pcategorieAttributionLibelle)
  {
    categorieAttributionLibelle = pcategorieAttributionLibelle;
  }
  
  public String getTypeDispositif()
  {
    return typeDispositif;
  }
  
  public void setTypeDispositif(String ptypeDispositif)
  {
    typeDispositif = ptypeDispositif;
  }
  
  public String getCodePays()
  {
    return codePays;
  }
  
  public void setCodePays(String pcodePays)
  {
    codePays = pcodePays;
  }
  
  public String getLibellePays()
  {
    return libellePays;
  }
  
  public void setLibellePays(String plibellePays)
  {
    libellePays = plibellePays;
  }
  
  public String getCodeSousTypePopulation1()
  {
    return codeSousTypePopulation1;
  }
  
  public void setCodeSousTypePopulation1(String psousTypePopulation1)
  {
    codeSousTypePopulation1 = psousTypePopulation1;
  }
  
  public String getCodeSousTypePopulation2()
  {
    return codeSousTypePopulation2;
  }
  
  public void setCodeSousTypePopulation2(String psousTypePopulation2)
  {
    codeSousTypePopulation2 = psousTypePopulation2;
  }
  
  public String getCodeSousTypePopulation3()
  {
    return codeSousTypePopulation3;
  }
  
  public void setCodeSousTypePopulation3(String psousTypePopulation3)
  {
    codeSousTypePopulation3 = psousTypePopulation3;
  }
  
  public String getCodeSousTypePopulation4()
  {
    return codeSousTypePopulation4;
  }
  
  public void setCodeSousTypePopulation4(String psousTypePopulation4)
  {
    codeSousTypePopulation4 = psousTypePopulation4;
  }
  
  public String getCodeSousTypePopulation5()
  {
    return codeSousTypePopulation5;
  }
  
  public void setCodeSousTypePopulation5(String psousTypePopulation5)
  {
    codeSousTypePopulation5 = psousTypePopulation5;
  }
  
  public String getCodeStatut1()
  {
    return codeStatut1;
  }
  
  public void setCodeStatut1(String pstatut1)
  {
    codeStatut1 = pstatut1;
  }
  
  public String getCodeStatut2()
  {
    return codeStatut2;
  }
  
  public void setCodeStatut2(String pstatut2)
  {
    codeStatut2 = pstatut2;
  }
  
  public String getCodeStatut3()
  {
    return codeStatut3;
  }
  
  public void setCodeStatut3(String pstatut3)
  {
    codeStatut3 = pstatut3;
  }
  
  public String getCodeStatut4()
  {
    return codeStatut4;
  }
  
  public void setCodeStatut4(String pstatut4)
  {
    codeStatut4 = pstatut4;
  }
  
  public String getCodeStatut5()
  {
    return codeStatut5;
  }
  
  public void setCodeStatut5(String pstatut5)
  {
    codeStatut5 = pstatut5;
  }
  
  public String getCodeTypePopulation1()
  {
    return codeTypePopulation1;
  }
  
  public void setCodeTypePopulation1(String ptypePopulation1)
  {
    codeTypePopulation1 = ptypePopulation1;
  }
  
  public String getCodeTypePopulation2()
  {
    return codeTypePopulation2;
  }
  
  public void setCodeTypePopulation2(String ptypePopulation2)
  {
    codeTypePopulation2 = ptypePopulation2;
  }
  
  public String getCodeTypePopulation3()
  {
    return codeTypePopulation3;
  }
  
  public void setCodeTypePopulation3(String ptypePopulation3)
  {
    codeTypePopulation3 = ptypePopulation3;
  }
  
  public String getCodeTypePopulation4()
  {
    return codeTypePopulation4;
  }
  
  public void setCodeTypePopulation4(String ptypePopulation4)
  {
    codeTypePopulation4 = ptypePopulation4;
  }
  
  public String getCodeTypePopulation5()
  {
    return codeTypePopulation5;
  }
  
  public void setCodeTypePopulation5(String ptypePopulation5)
  {
    codeTypePopulation5 = ptypePopulation5;
  }
  
  public String getLibelleSousTypePopulation1()
  {
    return libelleSousTypePopulation1;
  }
  
  public void setLibelleSousTypePopulation1(String plibelleSousTypePopulation1)
  {
    libelleSousTypePopulation1 = plibelleSousTypePopulation1;
  }
  
  public String getLibelleSousTypePopulation2()
  {
    return libelleSousTypePopulation2;
  }
  
  public void setLibelleSousTypePopulation2(String plibelleSousTypePopulation2)
  {
    libelleSousTypePopulation2 = plibelleSousTypePopulation2;
  }
  
  public String getLibelleSousTypePopulation3()
  {
    return libelleSousTypePopulation3;
  }
  
  public void setLibelleSousTypePopulation3(String plibelleSousTypePopulation3)
  {
    libelleSousTypePopulation3 = plibelleSousTypePopulation3;
  }
  
  public String getLibelleSousTypePopulation4()
  {
    return libelleSousTypePopulation4;
  }
  
  public void setLibelleSousTypePopulation4(String plibelleSousTypePopulation4)
  {
    libelleSousTypePopulation4 = plibelleSousTypePopulation4;
  }
  
  public String getLibelleSousTypePopulation5()
  {
    return libelleSousTypePopulation5;
  }
  
  public void setLibelleSousTypePopulation5(String plibelleSousTypePopulation5)
  {
    libelleSousTypePopulation5 = plibelleSousTypePopulation5;
  }
  
  public String getLibelleStatut1()
  {
    return libelleStatut1;
  }
  
  public void setLibelleStatut1(String plibelleStatut1)
  {
    libelleStatut1 = plibelleStatut1;
  }
  
  public String getLibelleStatut2()
  {
    return libelleStatut2;
  }
  
  public void setLibelleStatut2(String plibelleStatut2)
  {
    libelleStatut2 = plibelleStatut2;
  }
  
  public String getLibelleStatut3()
  {
    return libelleStatut3;
  }
  
  public void setLibelleStatut3(String plibelleStatut3)
  {
    libelleStatut3 = plibelleStatut3;
  }
  
  public String getLibelleStatut4()
  {
    return libelleStatut4;
  }
  
  public void setLibelleStatut4(String plibelleStatut4)
  {
    libelleStatut4 = plibelleStatut4;
  }
  
  public String getLibelleStatut5()
  {
    return libelleStatut5;
  }
  
  public void setLibelleStatut5(String plibelleStatut5)
  {
    libelleStatut5 = plibelleStatut5;
  }
  
  public String getLibelleTypePopulation1()
  {
    return libelleTypePopulation1;
  }
  
  public void setLibelleTypePopulation1(String plibelleTypePopulation1)
  {
    libelleTypePopulation1 = plibelleTypePopulation1;
  }
  
  public String getLibelleTypePopulation2()
  {
    return libelleTypePopulation2;
  }
  
  public void setLibelleTypePopulation2(String plibelleTypePopulation2)
  {
    libelleTypePopulation2 = plibelleTypePopulation2;
  }
  
  public String getLibelleTypePopulation3()
  {
    return libelleTypePopulation3;
  }
  
  public void setLibelleTypePopulation3(String plibelleTypePopulation3)
  {
    libelleTypePopulation3 = plibelleTypePopulation3;
  }
  
  public String getLibelleTypePopulation4()
  {
    return libelleTypePopulation4;
  }
  
  public void setLibelleTypePopulation4(String plibelleTypePopulation4)
  {
    libelleTypePopulation4 = plibelleTypePopulation4;
  }
  
  public String getLibelleTypePopulation5()
  {
    return libelleTypePopulation5;
  }
  
  public void setLibelleTypePopulation5(String plibelleTypePopulation5)
  {
    libelleTypePopulation5 = plibelleTypePopulation5;
  }
  
  public boolean estPresencePNDS()
  {
    return presencePNDS;
  }
  
  public void setPresencePNDS(boolean ppresencePNDS)
  {
    presencePNDS = ppresencePNDS;
  }
  
  public BigDecimal getMontantContMensuelEmploiRepris()
  {
    return montantContMensuelEmploiRepris;
  }
  
  public void setMontantContMensuelEmploiRepris(BigDecimal montantContMensuelEmploiRepris)
  {
    this.montantContMensuelEmploiRepris = montantContMensuelEmploiRepris;
  }
  
  public BigDecimal getExcedentsRemunerationMois()
  {
    return excedentsRemunerationMois;
  }
  
  public void setExcedentsRemunerationMois(BigDecimal excedentsRemunerationMois)
  {
    this.excedentsRemunerationMois = excedentsRemunerationMois;
  }
  
  public String getTypeCarence()
  {
    return typeCarence;
  }
  
  public void setTypeCarence(String typeCarence)
  {
    this.typeCarence = typeCarence;
  }
}

/* Location:
 * Qualified Name:     ResultatPbjcDetailler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */