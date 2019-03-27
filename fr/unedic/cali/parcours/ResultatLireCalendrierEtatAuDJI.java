package fr.unedic.cali.parcours;

import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;
import java.util.Map;

public class ResultatLireCalendrierEtatAuDJI
  extends Resultat
{
  private static final long serialVersionUID = 1L;
  private String tspEtatAuDJI = "";
  private String tspMontant = "";
  private String montantJustification = "";
  private String tspCalendrier = "";
  private String tspDispositif = "";
  private String typeDispositif = "";
  private boolean estDemandeFigee = false;
  private boolean montantPrecompteCRC = false;
  private boolean estGammeASU = false;
  private boolean estGammeARE = false;
  private boolean estAttenteRenouvellement = false;
  private boolean estGammeSOL = false;
  private boolean estProduitASS = false;
  private boolean estDispositif = false;
  private boolean estProduitARCe = false;
  private Damj dernierJourIndemnise = null;
  private Damj premierJourIndemnise = null;
  private Damj dernierJourIndemniseSuivi = null;
  private Damj dateDebutDispositif = null;
  private Damj dateFinDispostif = null;
  private BigDecimal cumulMoisActiviteReduite = null;
  private BigDecimal reliquatReliquatDureeIndemnisation = null;
  private BigDecimal montantBrut = null;
  private BigDecimal montantCRC = null;
  private BigDecimal cumulHeureActiviteReduite = null;
  private BigDecimal reliquatReliquatDureeIndemnisationASU = null;
  private BigDecimal reliquatDureeProlongationARE = null;
  private BigDecimal nombreJoursFormation = null;
  private BigDecimal reliquatDureeRenouvellementARE = null;
  private BigDecimal nombreMoisInactivite = null;
  private BigDecimal capitalVerseARCE = null;
  private String idEtatAttribution = null;
  private BigDecimal cumulJoursServis = null;
  private BigDecimal nombreMoisIndemnisesASU = null;
  private boolean estNbMoisIndemniseAsu = false;
  private BigDecimal capitalADRVerse = null;
  private boolean estProduitADR = false;
  private BigDecimal reliquatDureeFinancementAtp = null;
  private BigDecimal cumulJoursAR = null;
  private Map<?, ?> mapEtatAttribution;
  private Map<?, ?> mapJustificationCalculMontant;
  private Map<?, ?> mapTypeDispositif;
  private boolean calendrierExiste = false;
  private boolean calendrierAvantExiste = false;
  private Damj premierJourAvant = null;
  private Damj dernierJourAvant = null;
  private String calendrierAvantTSP = null;
  private String etatAuDernierAvantJourTSP = null;
  private Integer reliquatPMC = null;
  private Integer reliquatICCP = null;
  private Integer reliquatISLR = null;
  private Integer reliquatDelaiAttente = null;
  private String estDelaiAttenteEntame = null;
  private Damj debutPeriodeApplicationPMC = null;
  private Damj finPeriodeApplicationPMC = null;
  private Damj debutPeriodeApplicationICCP = null;
  private Damj finPeriodeApplicationICCP = null;
  private Damj debutPeriodeApplicationISLR = null;
  private Damj finPeriodeApplicationISLR = null;
  private Damj debutPeriodeApplicationDelai = null;
  private Damj finPeriodeApplicationDelai = null;
  private Integer dureeInitialePMC = null;
  private Integer dureeInitialeICCP = null;
  private Integer dureeInitialeISLR = null;
  private Integer dureeInitialeDelaiAttente = null;
  private Damj dateEpuisementDuree = null;
  private Damj dateDRV = null;
  private Damj dateDRVAvant = null;
  private Damj dateFinDispositifCSP = null;
  private BigDecimal reliquatDA = null;
  private BigDecimal reliquatTotalFranchiseCP = null;
  private BigDecimal reliquatTotalFranchiseSalaire = null;
  private Damj periodeDADebut = null;
  private Damj periodeDAFin = null;
  
  public BigDecimal getCapitalVerseARCE()
  {
    return capitalVerseARCE;
  }
  
  public void setCapitalVerseARCE(BigDecimal capitalVerseARCE)
  {
    this.capitalVerseARCE = capitalVerseARCE;
  }
  
  public BigDecimal getCumulHeureActiviteReduite()
  {
    return cumulHeureActiviteReduite;
  }
  
  public void setCumulHeureActiviteReduite(BigDecimal cumulHeureActiviteReduite)
  {
    this.cumulHeureActiviteReduite = cumulHeureActiviteReduite;
  }
  
  public BigDecimal getCumulMoisActiviteReduite()
  {
    return cumulMoisActiviteReduite;
  }
  
  public void setCumulMoisActiviteReduite(BigDecimal cumulMoisActiviteReduite)
  {
    this.cumulMoisActiviteReduite = cumulMoisActiviteReduite;
  }
  
  public Damj getDateDebutDispositif()
  {
    return dateDebutDispositif;
  }
  
  public void setDateDebutDispositif(Damj dateDebutDispositif)
  {
    this.dateDebutDispositif = dateDebutDispositif;
  }
  
  public Damj getDateFinDispostif()
  {
    return dateFinDispostif;
  }
  
  public void setDateFinDispostif(Damj dateFinDispostif)
  {
    this.dateFinDispostif = dateFinDispostif;
  }
  
  public Damj getDernierJourIndemnise()
  {
    return dernierJourIndemnise;
  }
  
  public void setDernierJourIndemnise(Damj dernierJourIndemnise)
  {
    this.dernierJourIndemnise = dernierJourIndemnise;
  }
  
  public Damj getDernierJourIndemniseSuivi()
  {
    return dernierJourIndemniseSuivi;
  }
  
  public void setDernierJourIndemniseSuivi(Damj dernierJourIndemniseSuivi)
  {
    this.dernierJourIndemniseSuivi = dernierJourIndemniseSuivi;
  }
  
  public boolean isEstAttenteRenouvellement()
  {
    return estAttenteRenouvellement;
  }
  
  public void setEstAttenteRenouvellement(boolean estAttenteRenouvellement)
  {
    this.estAttenteRenouvellement = estAttenteRenouvellement;
  }
  
  public boolean isEstDemandeFigee()
  {
    return estDemandeFigee;
  }
  
  public void setEstDemandeFigee(boolean estDemandeFigee)
  {
    this.estDemandeFigee = estDemandeFigee;
  }
  
  public boolean isEstDispositif()
  {
    return estDispositif;
  }
  
  public void setEstDispositif(boolean estDispositif)
  {
    this.estDispositif = estDispositif;
  }
  
  public boolean isEstGammeARE()
  {
    return estGammeARE;
  }
  
  public void setEstGammeARE(boolean estGammeARE)
  {
    this.estGammeARE = estGammeARE;
  }
  
  public boolean isEstGammeASU()
  {
    return estGammeASU;
  }
  
  public void setEstGammeASU(boolean estGammeASU)
  {
    this.estGammeASU = estGammeASU;
  }
  
  public boolean isEstGammeSOL()
  {
    return estGammeSOL;
  }
  
  public void setEstGammeSOL(boolean estGammeSOL)
  {
    this.estGammeSOL = estGammeSOL;
  }
  
  public boolean isEstProduitARCe()
  {
    return estProduitARCe;
  }
  
  public void setEstProduitARCe(boolean estProduitARCe)
  {
    this.estProduitARCe = estProduitARCe;
  }
  
  public boolean isEstProduitASS()
  {
    return estProduitASS;
  }
  
  public void setEstProduitASS(boolean estProduitASS)
  {
    this.estProduitASS = estProduitASS;
  }
  
  public String getIdEtatAttribution()
  {
    return idEtatAttribution;
  }
  
  public void setIdEtatAttribution(String idEtatAttribution)
  {
    this.idEtatAttribution = idEtatAttribution;
  }
  
  public Map<?, ?> getMapEtatAttribution()
  {
    return mapEtatAttribution;
  }
  
  public void setMapEtatAttribution(Map<?, ?> mapEtatAttribution)
  {
    this.mapEtatAttribution = mapEtatAttribution;
  }
  
  public Map<?, ?> getMapJustificationCalculMontant()
  {
    return mapJustificationCalculMontant;
  }
  
  public void setMapJustificationCalculMontant(Map<?, ?> mapJustificationCalculMontant)
  {
    this.mapJustificationCalculMontant = mapJustificationCalculMontant;
  }
  
  public Map<?, ?> getMapTypeDispositif()
  {
    return mapTypeDispositif;
  }
  
  public void setMapTypeDispositif(Map<?, ?> mapTypeDispositif)
  {
    this.mapTypeDispositif = mapTypeDispositif;
  }
  
  public BigDecimal getMontantBrut()
  {
    return montantBrut;
  }
  
  public void setMontantBrut(BigDecimal montantBrut)
  {
    this.montantBrut = montantBrut;
  }
  
  public BigDecimal getMontantCRC()
  {
    return montantCRC;
  }
  
  public void setMontantCRC(BigDecimal montantCRC)
  {
    this.montantCRC = montantCRC;
  }
  
  public String getMontantJustification()
  {
    return montantJustification;
  }
  
  public void setMontantJustification(String montantJustification)
  {
    this.montantJustification = montantJustification;
  }
  
  public boolean isMontantPrecompteCRC()
  {
    return montantPrecompteCRC;
  }
  
  public void setMontantPrecompteCRC(boolean montantPrecompteCRC)
  {
    this.montantPrecompteCRC = montantPrecompteCRC;
  }
  
  public BigDecimal getNombreJoursFormation()
  {
    return nombreJoursFormation;
  }
  
  public void setNombreJoursFormation(BigDecimal nombreJoursFormation)
  {
    this.nombreJoursFormation = nombreJoursFormation;
  }
  
  public BigDecimal getNombreMoisInactivite()
  {
    return nombreMoisInactivite;
  }
  
  public void setNombreMoisInactivite(BigDecimal nombreMoisInactivite)
  {
    this.nombreMoisInactivite = nombreMoisInactivite;
  }
  
  public Damj getPremierJourIndemnise()
  {
    return premierJourIndemnise;
  }
  
  public void setPremierJourIndemnise(Damj premierJourIndemnise)
  {
    this.premierJourIndemnise = premierJourIndemnise;
  }
  
  public BigDecimal getReliquatDureeProlongationARE()
  {
    return reliquatDureeProlongationARE;
  }
  
  public void setReliquatDureeProlongationARE(BigDecimal reliquatDureeProlongationARE)
  {
    this.reliquatDureeProlongationARE = reliquatDureeProlongationARE;
  }
  
  public BigDecimal getReliquatDureeRenouvellementARE()
  {
    return reliquatDureeRenouvellementARE;
  }
  
  public void setReliquatDureeRenouvellementARE(BigDecimal reliquatDureeRenouvellementARE)
  {
    this.reliquatDureeRenouvellementARE = reliquatDureeRenouvellementARE;
  }
  
  public BigDecimal getReliquatReliquatDureeIndemnisation()
  {
    return reliquatReliquatDureeIndemnisation;
  }
  
  public void setReliquatReliquatDureeIndemnisation(BigDecimal reliquatReliquatDureeIndemnisation)
  {
    this.reliquatReliquatDureeIndemnisation = reliquatReliquatDureeIndemnisation;
  }
  
  public BigDecimal getReliquatReliquatDureeIndemnisationASU()
  {
    return reliquatReliquatDureeIndemnisationASU;
  }
  
  public void setReliquatReliquatDureeIndemnisationASU(BigDecimal reliquatReliquatDureeIndemnisationASU)
  {
    this.reliquatReliquatDureeIndemnisationASU = reliquatReliquatDureeIndemnisationASU;
  }
  
  public String getTspCalendrier()
  {
    return tspCalendrier;
  }
  
  public void setTspCalendrier(String tspCalendrier)
  {
    this.tspCalendrier = tspCalendrier;
  }
  
  public String getTspDispositif()
  {
    return tspDispositif;
  }
  
  public void setTspDispositif(String tspDispositif)
  {
    this.tspDispositif = tspDispositif;
  }
  
  public String getTspEtatAuDJI()
  {
    return tspEtatAuDJI;
  }
  
  public void setTspEtatAuDJI(String tspEtatAuDJI)
  {
    this.tspEtatAuDJI = tspEtatAuDJI;
  }
  
  public String getTspMontant()
  {
    return tspMontant;
  }
  
  public void setTspMontant(String tspMontant)
  {
    this.tspMontant = tspMontant;
  }
  
  public String getTypeDispositif()
  {
    return typeDispositif;
  }
  
  public void setTypeDispositif(String typeDispositif)
  {
    this.typeDispositif = typeDispositif;
  }
  
  public BigDecimal getCapitalADRVerse()
  {
    return capitalADRVerse;
  }
  
  public void setCapitalADRVerse(BigDecimal capitalADRVerse)
  {
    this.capitalADRVerse = capitalADRVerse;
  }
  
  public BigDecimal getCumulJoursServis()
  {
    return cumulJoursServis;
  }
  
  public void setCumulJoursServis(BigDecimal cumulJoursServis)
  {
    this.cumulJoursServis = cumulJoursServis;
  }
  
  public BigDecimal getNombreMoisIndemnisesASU()
  {
    return nombreMoisIndemnisesASU;
  }
  
  public void setNombreMoisIndemnisesASU(BigDecimal nombreMoisIndemnisesASU)
  {
    this.nombreMoisIndemnisesASU = nombreMoisIndemnisesASU;
  }
  
  public boolean isEstProduitADR()
  {
    return estProduitADR;
  }
  
  public void setEstProduitADR(boolean estProduitADR)
  {
    this.estProduitADR = estProduitADR;
  }
  
  public boolean isEstNbMoisIndemniseAsu()
  {
    return estNbMoisIndemniseAsu;
  }
  
  public void setEstNbMoisIndemniseAsu(boolean estNbMoisIndemniseAsu)
  {
    this.estNbMoisIndemniseAsu = estNbMoisIndemniseAsu;
  }
  
  public BigDecimal getReliquatDureeFinancementAtp()
  {
    return reliquatDureeFinancementAtp;
  }
  
  public void setReliquatDureeFinancementAtp(BigDecimal reliquatDureeFinancementAtp)
  {
    this.reliquatDureeFinancementAtp = reliquatDureeFinancementAtp;
  }
  
  public BigDecimal getCumulJoursAR()
  {
    return cumulJoursAR;
  }
  
  public void setCumulJoursAR(BigDecimal cumulJoursActiviteReduite)
  {
    cumulJoursAR = cumulJoursActiviteReduite;
  }
  
  public boolean isCalendrierAvantExiste()
  {
    return calendrierAvantExiste;
  }
  
  public void setCalendrierAvantExiste(boolean calendrierAvantExiste)
  {
    this.calendrierAvantExiste = calendrierAvantExiste;
  }
  
  public String getCalendrierAvantTSP()
  {
    return calendrierAvantTSP;
  }
  
  public void setCalendrierAvantTSP(String calendrierAvantTSP)
  {
    this.calendrierAvantTSP = calendrierAvantTSP;
  }
  
  public boolean isCalendrierExiste()
  {
    return calendrierExiste;
  }
  
  public void setCalendrierExiste(boolean calendrierExiste)
  {
    this.calendrierExiste = calendrierExiste;
  }
  
  public Damj getDernierJourAvant()
  {
    return dernierJourAvant;
  }
  
  public void setDernierJourAvant(Damj dernierJourAvant)
  {
    this.dernierJourAvant = dernierJourAvant;
  }
  
  public String getEstDelaiAttenteEntame()
  {
    return estDelaiAttenteEntame;
  }
  
  public void setEstDelaiAttenteEntame(String estDelaiAttenteEntame)
  {
    this.estDelaiAttenteEntame = estDelaiAttenteEntame;
  }
  
  public String getEtatAuDernierAvantJourTSP()
  {
    return etatAuDernierAvantJourTSP;
  }
  
  public void setEtatAuDernierAvantJourTSP(String etatAuDernierAvantJourTSP)
  {
    this.etatAuDernierAvantJourTSP = etatAuDernierAvantJourTSP;
  }
  
  public Damj getPremierJourAvant()
  {
    return premierJourAvant;
  }
  
  public void setPremierJourAvant(Damj premierJourAvant)
  {
    this.premierJourAvant = premierJourAvant;
  }
  
  public Integer getReliquatDelaiAttente()
  {
    return reliquatDelaiAttente;
  }
  
  public void setReliquatDelaiAttente(Integer reliquatDelaiAttente)
  {
    this.reliquatDelaiAttente = reliquatDelaiAttente;
  }
  
  public Integer getReliquatICCP()
  {
    return reliquatICCP;
  }
  
  public void setReliquatICCP(Integer reliquatICCP)
  {
    this.reliquatICCP = reliquatICCP;
  }
  
  public Integer getReliquatISLR()
  {
    return reliquatISLR;
  }
  
  public void setReliquatISLR(Integer reliquatISLR)
  {
    this.reliquatISLR = reliquatISLR;
  }
  
  public Integer getReliquatPMC()
  {
    return reliquatPMC;
  }
  
  public void setReliquatPMC(Integer reliquatPMC)
  {
    this.reliquatPMC = reliquatPMC;
  }
  
  public Damj getDebutPeriodeApplicationDelai()
  {
    return debutPeriodeApplicationDelai;
  }
  
  public void setDebutPeriodeApplicationDelai(Damj debutPeriodeApplicationDelai)
  {
    this.debutPeriodeApplicationDelai = debutPeriodeApplicationDelai;
  }
  
  public Damj getDebutPeriodeApplicationICCP()
  {
    return debutPeriodeApplicationICCP;
  }
  
  public void setDebutPeriodeApplicationICCP(Damj debutPeriodeApplicationICCP)
  {
    this.debutPeriodeApplicationICCP = debutPeriodeApplicationICCP;
  }
  
  public Damj getDebutPeriodeApplicationISLR()
  {
    return debutPeriodeApplicationISLR;
  }
  
  public void setDebutPeriodeApplicationISLR(Damj debutPeriodeApplicationISLR)
  {
    this.debutPeriodeApplicationISLR = debutPeriodeApplicationISLR;
  }
  
  public Damj getDebutPeriodeApplicationPMC()
  {
    return debutPeriodeApplicationPMC;
  }
  
  public void setDebutPeriodeApplicationPMC(Damj debutPeriodeApplicationPMC)
  {
    this.debutPeriodeApplicationPMC = debutPeriodeApplicationPMC;
  }
  
  public Integer getDureeInitialeDelaiAttente()
  {
    return dureeInitialeDelaiAttente;
  }
  
  public void setDureeInitialeDelaiAttente(Integer dureeInitialeDelaiAttente)
  {
    this.dureeInitialeDelaiAttente = dureeInitialeDelaiAttente;
  }
  
  public Integer getDureeInitialeICCP()
  {
    return dureeInitialeICCP;
  }
  
  public void setDureeInitialeICCP(Integer dureeInitialeICCP)
  {
    this.dureeInitialeICCP = dureeInitialeICCP;
  }
  
  public Integer getDureeInitialeISLR()
  {
    return dureeInitialeISLR;
  }
  
  public void setDureeInitialeISLR(Integer dureeInitialeISLR)
  {
    this.dureeInitialeISLR = dureeInitialeISLR;
  }
  
  public Integer getDureeInitialePMC()
  {
    return dureeInitialePMC;
  }
  
  public void setDureeInitialePMC(Integer dureeInitialePMC)
  {
    this.dureeInitialePMC = dureeInitialePMC;
  }
  
  public Damj getFinPeriodeApplicationDelai()
  {
    return finPeriodeApplicationDelai;
  }
  
  public void setFinPeriodeApplicationDelai(Damj finPeriodeApplicationDelai)
  {
    this.finPeriodeApplicationDelai = finPeriodeApplicationDelai;
  }
  
  public Damj getFinPeriodeApplicationICCP()
  {
    return finPeriodeApplicationICCP;
  }
  
  public void setFinPeriodeApplicationICCP(Damj finPeriodeApplicationICCP)
  {
    this.finPeriodeApplicationICCP = finPeriodeApplicationICCP;
  }
  
  public Damj getFinPeriodeApplicationISLR()
  {
    return finPeriodeApplicationISLR;
  }
  
  public void setFinPeriodeApplicationISLR(Damj finPeriodeApplicationISLR)
  {
    this.finPeriodeApplicationISLR = finPeriodeApplicationISLR;
  }
  
  public Damj getFinPeriodeApplicationPMC()
  {
    return finPeriodeApplicationPMC;
  }
  
  public void setFinPeriodeApplicationPMC(Damj finPeriodeApplicationPMC)
  {
    this.finPeriodeApplicationPMC = finPeriodeApplicationPMC;
  }
  
  public void setDateEpuisementDuree(Damj dateEpuisementDuree)
  {
    this.dateEpuisementDuree = dateEpuisementDuree;
  }
  
  public Damj getDateEpuisementDuree()
  {
    return dateEpuisementDuree;
  }
  
  public void setDateDRV(Damj dateDRV)
  {
    this.dateDRV = dateDRV;
  }
  
  public Damj getDateDRV()
  {
    return dateDRV;
  }
  
  public void setDateFinDispositifCSP(Damj dateFinDispositifCSP)
  {
    this.dateFinDispositifCSP = dateFinDispositifCSP;
  }
  
  public Damj getDateFinDispositifCSP()
  {
    return dateFinDispositifCSP;
  }
  
  public void setDateDRVAvant(Damj dateDRVAvant)
  {
    this.dateDRVAvant = dateDRVAvant;
  }
  
  public Damj getDateDRVAvant()
  {
    return dateDRVAvant;
  }
  
  public BigDecimal getReliquatTotalFranchiseCP()
  {
    return reliquatTotalFranchiseCP;
  }
  
  public void setReliquatTotalFranchiseCP(BigDecimal reliquatTotalFranchiseCP)
  {
    this.reliquatTotalFranchiseCP = reliquatTotalFranchiseCP;
  }
  
  public BigDecimal getReliquatTotalFranchiseSalaire()
  {
    return reliquatTotalFranchiseSalaire;
  }
  
  public void setReliquatTotalFranchiseSalaire(BigDecimal reliquatTotalFranchiseSalaire)
  {
    this.reliquatTotalFranchiseSalaire = reliquatTotalFranchiseSalaire;
  }
  
  public Damj getPeriodeDADebut()
  {
    return periodeDADebut;
  }
  
  public void setPeriodeDADebut(Damj periodeDADebut)
  {
    this.periodeDADebut = periodeDADebut;
  }
  
  public Damj getPeriodeDAFin()
  {
    return periodeDAFin;
  }
  
  public void setPeriodeDAFin(Damj periodeDAFin)
  {
    this.periodeDAFin = periodeDAFin;
  }
  
  public BigDecimal getReliquatDA()
  {
    return reliquatDA;
  }
  
  public void setReliquatDA(BigDecimal reliquatDA)
  {
    this.reliquatDA = reliquatDA;
  }
}

/* Location:
 * Qualified Name:     ResultatLireCalendrierEtatAuDJI
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */