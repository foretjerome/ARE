package fr.unedic.cali.parcours;

import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;

public class DomEnregistrerCalendrierEtatAuDJI
  extends DomCaliOptimise
  implements DomCali
{
  private IndividuSpec m_individu;
  private String m_idDemande;
  private ContexteService m_contexteService;
  private String m_etatAuDJITSP = null;
  private String m_montantTSP = null;
  private String m_montantJustification = null;
  private String m_calendrierTSP = null;
  private String m_dispositifASSTSP = null;
  private String m_dispositifASSType = null;
  private boolean m_etatAuDJIDemandeFigee = false;
  private boolean m_montantMontantPrecompteCRC = false;
  private boolean m_gammeASUExiste = false;
  private boolean m_gammeAREExiste = false;
  private boolean m_gammeAREAttenteRenouvellement = false;
  private boolean m_gammeSOLExiste = false;
  private boolean m_gammeASSCGEExiste = false;
  private boolean m_dispositifASSExiste = false;
  private boolean m_gammeARCEExiste = false;
  private Damj m_calendrierDJI = null;
  private Damj m_calendrierPJI = null;
  private Damj m_calendrierDJISuivi = null;
  private Damj m_dispositifASSDebut = null;
  private Damj m_dispositifASSFin = null;
  private BigDecimal m_activiteReduiteCumulMoisActiviteReduite = null;
  private BigDecimal m_reliquatReliquatDureeIndemnisation = null;
  private BigDecimal m_montantMontantBrut = null;
  private BigDecimal m_montantMontantCRC = null;
  private BigDecimal m_activiteReduiteCumulHeureActiviteReduite = null;
  private BigDecimal m_gammeASUReliquatDureeIndemn = null;
  private BigDecimal m_gammeASUReliquatDureeProlongation = null;
  private BigDecimal m_gammeASUNombreJoursAREF = null;
  private BigDecimal m_gammeAREReliquatDureeRenouvellement = null;
  private BigDecimal m_gammeASSCGENombreMoisInactivite = null;
  private BigDecimal m_gammeARCECapitalVerse = null;
  private String m_etatAttribution = null;
  private BigDecimal m_nombreMoisInactivite = null;
  private boolean m_estAttributionPFMDemandee = false;
  private BigDecimal m_cumulJoursServis = null;
  private BigDecimal m_gammeASUNombreMoisIndemnisesASU = null;
  private boolean m_gammeASUisEstNbMoisIndemniseAsu = false;
  private BigDecimal m_capitalADRVerse = null;
  private BigDecimal m_reliquatDureeFinancementAtp = null;
  private BigDecimal m_activiteReduiteCumulJoursActiviteReduite = null;
  private boolean m_calendrierExiste = false;
  private boolean m_calendrierAvantExiste = false;
  private Damj m_premierJourAvant = null;
  private Damj m_dernierJourAvant = null;
  private String m_calendrierAvantTSP = null;
  private String m_etatAuDernierAvantJourTSP = null;
  private Integer m_reliquatPMC = null;
  private Integer m_reliquatICCP = null;
  private Integer m_reliquatISLR = null;
  private Integer m_reliquatDelaiAttente = null;
  private boolean m_delaiAttenteEntame = false;
  private Damj m_debutPeriodeApplicationPMC = null;
  private Damj m_finPeriodeApplicationPMC = null;
  private Damj m_debutPeriodeApplicationICCP = null;
  private Damj m_finPeriodeApplicationICCP = null;
  private Damj m_debutPeriodeApplicationISLR = null;
  private Damj m_finPeriodeApplicationISLR = null;
  private Damj m_debutPeriodeApplicationDelai = null;
  private Damj m_finPeriodeApplicationDelai = null;
  private Integer m_dureeInitialePMC = null;
  private Integer m_dureeInitialeICCP = null;
  private Integer m_dureeInitialeISLR = null;
  private Integer m_dureeInitialeDelaiAttente = null;
  
  public IndividuSpec getIndividu()
  {
    return m_individu;
  }
  
  public void setIndividu(IndividuSpec p_individu)
  {
    m_individu = p_individu;
  }
  
  public ContexteService getContexteService()
  {
    return m_contexteService;
  }
  
  public void setContexteService(ContexteService p_contexteService)
  {
    m_contexteService = p_contexteService;
  }
  
  public BigDecimal getActiviteReduiteCumulHeureActiviteReduite()
  {
    return m_activiteReduiteCumulHeureActiviteReduite;
  }
  
  public void setActiviteReduiteCumulHeureActiviteReduite(BigDecimal p_activiteReduiteCumulHeureActiviteReduite)
  {
    m_activiteReduiteCumulHeureActiviteReduite = p_activiteReduiteCumulHeureActiviteReduite;
  }
  
  public BigDecimal getActiviteReduiteCumulMoisActiviteReduite()
  {
    return m_activiteReduiteCumulMoisActiviteReduite;
  }
  
  public void setActiviteReduiteCumulMoisActiviteReduite(BigDecimal p_activiteReduiteCumulMoisActiviteReduite)
  {
    m_activiteReduiteCumulMoisActiviteReduite = p_activiteReduiteCumulMoisActiviteReduite;
  }
  
  public Damj getCalendrierDJI()
  {
    return m_calendrierDJI;
  }
  
  public void setCalendrierDJI(Damj p_calendrierDJI)
  {
    m_calendrierDJI = p_calendrierDJI;
  }
  
  public Damj getCalendrierDJISuivi()
  {
    return m_calendrierDJISuivi;
  }
  
  public void setCalendrierDJISuivi(Damj p_calendrierDJISuivi)
  {
    m_calendrierDJISuivi = p_calendrierDJISuivi;
  }
  
  public Damj getCalendrierPJI()
  {
    return m_calendrierPJI;
  }
  
  public void setCalendrierPJI(Damj p_calendrierPJI)
  {
    m_calendrierPJI = p_calendrierPJI;
  }
  
  public String getCalendrierTSP()
  {
    return m_calendrierTSP;
  }
  
  public void setCalendrierTSP(String p_calendrierTSP)
  {
    m_calendrierTSP = p_calendrierTSP;
  }
  
  public Damj getDispositifASSDebut()
  {
    return m_dispositifASSDebut;
  }
  
  public void setDispositifASSDebut(Damj p_dispositifASSDebut)
  {
    m_dispositifASSDebut = p_dispositifASSDebut;
  }
  
  public boolean isDispositifASSExiste()
  {
    return m_dispositifASSExiste;
  }
  
  public void setDispositifASSExiste(boolean p_dispositifASSExiste)
  {
    m_dispositifASSExiste = p_dispositifASSExiste;
  }
  
  public Damj getDispositifASSFin()
  {
    return m_dispositifASSFin;
  }
  
  public void setDispositifASSFin(Damj p_dispositifASSFin)
  {
    m_dispositifASSFin = p_dispositifASSFin;
  }
  
  public String getDispositifASSTSP()
  {
    return m_dispositifASSTSP;
  }
  
  public void setDispositifASSTSP(String p_dispositifASSTSP)
  {
    m_dispositifASSTSP = p_dispositifASSTSP;
  }
  
  public String getDispositifASSType()
  {
    return m_dispositifASSType;
  }
  
  public void setDispositifASSType(String p_dispositifASSType)
  {
    m_dispositifASSType = p_dispositifASSType;
  }
  
  public boolean isEtatAuDJIDemandeFigee()
  {
    return m_etatAuDJIDemandeFigee;
  }
  
  public void setEtatAuDJIDemandeFigee(boolean p_etatAuDJIDemandeFigee)
  {
    m_etatAuDJIDemandeFigee = p_etatAuDJIDemandeFigee;
  }
  
  public String getEtatAuDJITSP()
  {
    return m_etatAuDJITSP;
  }
  
  public void setEtatAuDJITSP(String p_etatAuDJITSP)
  {
    m_etatAuDJITSP = p_etatAuDJITSP;
  }
  
  public BigDecimal getGammeARCECapitalVerse()
  {
    return m_gammeARCECapitalVerse;
  }
  
  public void setGammeARCECapitalVerse(BigDecimal p_gammeARCECapitalVerse)
  {
    m_gammeARCECapitalVerse = p_gammeARCECapitalVerse;
  }
  
  public boolean isGammeARCEExiste()
  {
    return m_gammeARCEExiste;
  }
  
  public void setGammeARCEExiste(boolean p_gammeARCEExiste)
  {
    m_gammeARCEExiste = p_gammeARCEExiste;
  }
  
  public boolean isGammeAREAttenteRenouvellement()
  {
    return m_gammeAREAttenteRenouvellement;
  }
  
  public void setGammeAREAttenteRenouvellement(boolean p_gammeAREAttenteRenouvellement)
  {
    m_gammeAREAttenteRenouvellement = p_gammeAREAttenteRenouvellement;
  }
  
  public boolean isGammeAREExiste()
  {
    return m_gammeAREExiste;
  }
  
  public void setGammeAREExiste(boolean p_gammeAREExiste)
  {
    m_gammeAREExiste = p_gammeAREExiste;
  }
  
  public BigDecimal getGammeAREReliquatDureeRenouvellement()
  {
    return m_gammeAREReliquatDureeRenouvellement;
  }
  
  public void setGammeAREReliquatDureeRenouvellement(BigDecimal p_gammeAREReliquatDureeRenouvellement)
  {
    m_gammeAREReliquatDureeRenouvellement = p_gammeAREReliquatDureeRenouvellement;
  }
  
  public boolean isGammeASSCGEExiste()
  {
    return m_gammeASSCGEExiste;
  }
  
  public void setGammeASSCGEExiste(boolean p_gammeASSCGEExiste)
  {
    m_gammeASSCGEExiste = p_gammeASSCGEExiste;
  }
  
  public BigDecimal getGammeASSCGENombreMoisInactivite()
  {
    return m_gammeASSCGENombreMoisInactivite;
  }
  
  public void setGammeASSCGENombreMoisInactivite(BigDecimal p_gammeASSCGENombreMoisInactivite)
  {
    m_gammeASSCGENombreMoisInactivite = p_gammeASSCGENombreMoisInactivite;
  }
  
  public boolean isGammeASUExiste()
  {
    return m_gammeASUExiste;
  }
  
  public void setGammeASUExiste(boolean p_gammeASUExiste)
  {
    m_gammeASUExiste = p_gammeASUExiste;
  }
  
  public BigDecimal getGammeASUNombreJoursAREF()
  {
    return m_gammeASUNombreJoursAREF;
  }
  
  public void setGammeASUNombreJoursAREF(BigDecimal p_gammeASUNombreJoursAREF)
  {
    m_gammeASUNombreJoursAREF = p_gammeASUNombreJoursAREF;
  }
  
  public BigDecimal getGammeASUReliquatDureeIndemn()
  {
    return m_gammeASUReliquatDureeIndemn;
  }
  
  public void setGammeASUReliquatDureeIndemn(BigDecimal p_gammeASUReliquatDureeIndemn)
  {
    m_gammeASUReliquatDureeIndemn = p_gammeASUReliquatDureeIndemn;
  }
  
  public BigDecimal getGammeASUReliquatDureeProlongation()
  {
    return m_gammeASUReliquatDureeProlongation;
  }
  
  public void setGammeASUReliquatDureeProlongation(BigDecimal p_gammeASUReliquatDureeProlongation)
  {
    m_gammeASUReliquatDureeProlongation = p_gammeASUReliquatDureeProlongation;
  }
  
  public boolean isGammeSOLExiste()
  {
    return m_gammeSOLExiste;
  }
  
  public void setGammeSOLExiste(boolean p_gammeSOLExiste)
  {
    m_gammeSOLExiste = p_gammeSOLExiste;
  }
  
  public String getMontantJustification()
  {
    return m_montantJustification;
  }
  
  public void setMontantJustification(String p_montantJustification)
  {
    m_montantJustification = p_montantJustification;
  }
  
  public BigDecimal getMontantMontantBrut()
  {
    return m_montantMontantBrut;
  }
  
  public void setMontantMontantBrut(BigDecimal p_montantMontantBrut)
  {
    m_montantMontantBrut = p_montantMontantBrut;
  }
  
  public BigDecimal getMontantMontantCRC()
  {
    return m_montantMontantCRC;
  }
  
  public void setMontantMontantCRC(BigDecimal p_montantMontantCRC)
  {
    m_montantMontantCRC = p_montantMontantCRC;
  }
  
  public boolean isMontantMontantPrecompteCRC()
  {
    return m_montantMontantPrecompteCRC;
  }
  
  public void setMontantMontantPrecompteCRC(boolean p_montantMontantPrecompteCRC)
  {
    m_montantMontantPrecompteCRC = p_montantMontantPrecompteCRC;
  }
  
  public String getMontantTSP()
  {
    return m_montantTSP;
  }
  
  public void setMontantTSP(String p_montantTSP)
  {
    m_montantTSP = p_montantTSP;
  }
  
  public BigDecimal getReliquatReliquatDureeIndemnisation()
  {
    return m_reliquatReliquatDureeIndemnisation;
  }
  
  public void setReliquatReliquatDureeIndemnisation(BigDecimal p_reliquatReliquatDureeIndemnisation)
  {
    m_reliquatReliquatDureeIndemnisation = p_reliquatReliquatDureeIndemnisation;
  }
  
  public static ContexteService getContexteService(Contexte p_contexte)
  {
    return ((DomReexecutionCali)p_contexte.getDonnees()).getContexteService();
  }
  
  public String getEtatAttribution()
  {
    return m_etatAttribution;
  }
  
  public void setEtatAttribution(String p_etatAttribution)
  {
    m_etatAttribution = p_etatAttribution;
  }
  
  public BigDecimal getNombreMoisInactivite()
  {
    return m_nombreMoisInactivite;
  }
  
  public void setNombreMoisInactivite(BigDecimal p_nombreMoisInactivite)
  {
    m_nombreMoisInactivite = p_nombreMoisInactivite;
  }
  
  public String getIdDemande()
  {
    return m_idDemande;
  }
  
  public void setIdDemande(String p_idDemande)
  {
    m_idDemande = p_idDemande;
  }
  
  public boolean isEstAttributionPFMDemandee()
  {
    return m_estAttributionPFMDemandee;
  }
  
  public void setEstAttributionPFMDemandee(boolean p_estAttributionPFMDemandee)
  {
    m_estAttributionPFMDemandee = p_estAttributionPFMDemandee;
  }
  
  public BigDecimal getCapitalADRVerse()
  {
    return m_capitalADRVerse;
  }
  
  public void setCapitalADRVerse(BigDecimal p_capitalADRVerse)
  {
    m_capitalADRVerse = p_capitalADRVerse;
  }
  
  public BigDecimal getCumulJoursServis()
  {
    return m_cumulJoursServis;
  }
  
  public void setCumulJoursServis(BigDecimal p_cumulJoursServis)
  {
    m_cumulJoursServis = p_cumulJoursServis;
  }
  
  public BigDecimal getGammeASUNombreMoisIndemnisesASU()
  {
    return m_gammeASUNombreMoisIndemnisesASU;
  }
  
  public void setGammeASUNombreMoisIndemnisesASU(BigDecimal p_gammeASUNombreMoisIndemnisesASU)
  {
    m_gammeASUNombreMoisIndemnisesASU = p_gammeASUNombreMoisIndemnisesASU;
  }
  
  public boolean isGammeASUisEstNbMoisIndemniseAsu()
  {
    return m_gammeASUisEstNbMoisIndemniseAsu;
  }
  
  public void setGammeASUisEstNbMoisIndemniseAsu(boolean p_gammeASUisEstNbMoisIndemniseAsu)
  {
    m_gammeASUisEstNbMoisIndemniseAsu = p_gammeASUisEstNbMoisIndemniseAsu;
  }
  
  public BigDecimal getReliquatDureeFinancementAtp()
  {
    return m_reliquatDureeFinancementAtp;
  }
  
  public void setReliquatDureeFinancementAtp(BigDecimal p_reliquatDureeFinancementAtp)
  {
    m_reliquatDureeFinancementAtp = p_reliquatDureeFinancementAtp;
  }
  
  public BigDecimal getActiviteReduiteCumulJoursActiviteReduite()
  {
    return m_activiteReduiteCumulJoursActiviteReduite;
  }
  
  public void setActiviteReduiteCumulJoursActiviteReduite(BigDecimal p_activiteReduiteCumulJoursActiviteReduite)
  {
    m_activiteReduiteCumulJoursActiviteReduite = p_activiteReduiteCumulJoursActiviteReduite;
  }
  
  public boolean isCalendrierAvantExiste()
  {
    return m_calendrierAvantExiste;
  }
  
  public void setCalendrierAvantExiste(boolean p_calendrierAvantExiste)
  {
    m_calendrierAvantExiste = p_calendrierAvantExiste;
  }
  
  public String getCalendrierAvantTSP()
  {
    return m_calendrierAvantTSP;
  }
  
  public void setCalendrierAvantTSP(String p_calendrierAvantTSP)
  {
    m_calendrierAvantTSP = p_calendrierAvantTSP;
  }
  
  public boolean isCalendrierExiste()
  {
    return m_calendrierExiste;
  }
  
  public void setCalendrierExiste(boolean p_calendrierExiste)
  {
    m_calendrierExiste = p_calendrierExiste;
  }
  
  public Damj getDernierJourAvant()
  {
    return m_dernierJourAvant;
  }
  
  public void setDernierJourAvant(Damj p_dernierJourAvant)
  {
    m_dernierJourAvant = p_dernierJourAvant;
  }
  
  public String getEtatAuDernierAvantJourTSP()
  {
    return m_etatAuDernierAvantJourTSP;
  }
  
  public void setEtatAuDernierAvantJourTSP(String p_etatAuDernierAvantJourTSP)
  {
    m_etatAuDernierAvantJourTSP = p_etatAuDernierAvantJourTSP;
  }
  
  public Damj getPremierJourAvant()
  {
    return m_premierJourAvant;
  }
  
  public void setPremierJourAvant(Damj p_premierJourAvant)
  {
    m_premierJourAvant = p_premierJourAvant;
  }
  
  public Integer getReliquatDelaiAttente()
  {
    return m_reliquatDelaiAttente;
  }
  
  public void setReliquatDelaiAttente(Integer p_reliquatDelaiAttente)
  {
    m_reliquatDelaiAttente = p_reliquatDelaiAttente;
  }
  
  public Integer getReliquatICCP()
  {
    return m_reliquatICCP;
  }
  
  public void setReliquatICCP(Integer p_reliquatICCP)
  {
    m_reliquatICCP = p_reliquatICCP;
  }
  
  public Integer getReliquatISLR()
  {
    return m_reliquatISLR;
  }
  
  public void setReliquatISLR(Integer p_reliquatISLR)
  {
    m_reliquatISLR = p_reliquatISLR;
  }
  
  public Integer getReliquatPMC()
  {
    return m_reliquatPMC;
  }
  
  public void setReliquatPMC(Integer p_reliquatPMC)
  {
    m_reliquatPMC = p_reliquatPMC;
  }
  
  public boolean isDelaiAttenteEntame()
  {
    return m_delaiAttenteEntame;
  }
  
  public void setDelaiAttenteEntame(boolean p_delaiAttenteEntame)
  {
    m_delaiAttenteEntame = p_delaiAttenteEntame;
  }
  
  public Damj getDebutPeriodeApplicationDelai()
  {
    return m_debutPeriodeApplicationDelai;
  }
  
  public void setDebutPeriodeApplicationDelai(Damj p_debutPeriodeApplicationDelai)
  {
    m_debutPeriodeApplicationDelai = p_debutPeriodeApplicationDelai;
  }
  
  public Damj getDebutPeriodeApplicationICCP()
  {
    return m_debutPeriodeApplicationICCP;
  }
  
  public void setDebutPeriodeApplicationICCP(Damj p_debutPeriodeApplicationICCP)
  {
    m_debutPeriodeApplicationICCP = p_debutPeriodeApplicationICCP;
  }
  
  public Damj getDebutPeriodeApplicationISLR()
  {
    return m_debutPeriodeApplicationISLR;
  }
  
  public void setDebutPeriodeApplicationISLR(Damj p_debutPeriodeApplicationISLR)
  {
    m_debutPeriodeApplicationISLR = p_debutPeriodeApplicationISLR;
  }
  
  public Damj getDebutPeriodeApplicationPMC()
  {
    return m_debutPeriodeApplicationPMC;
  }
  
  public void setDebutPeriodeApplicationPMC(Damj p_debutPeriodeApplicationPMC)
  {
    m_debutPeriodeApplicationPMC = p_debutPeriodeApplicationPMC;
  }
  
  public Integer getDureeInitialeDelaiAttente()
  {
    return m_dureeInitialeDelaiAttente;
  }
  
  public void setDureeInitialeDelaiAttente(Integer p_dureeInitialeDelaiAttente)
  {
    m_dureeInitialeDelaiAttente = p_dureeInitialeDelaiAttente;
  }
  
  public Integer getDureeInitialeICCP()
  {
    return m_dureeInitialeICCP;
  }
  
  public void setDureeInitialeICCP(Integer p_dureeInitialeICCP)
  {
    m_dureeInitialeICCP = p_dureeInitialeICCP;
  }
  
  public Integer getDureeInitialeISLR()
  {
    return m_dureeInitialeISLR;
  }
  
  public void setDureeInitialeISLR(Integer p_dureeInitialeISLR)
  {
    m_dureeInitialeISLR = p_dureeInitialeISLR;
  }
  
  public Integer getDureeInitialePMC()
  {
    return m_dureeInitialePMC;
  }
  
  public void setDureeInitialePMC(Integer p_dureeInitialePMC)
  {
    m_dureeInitialePMC = p_dureeInitialePMC;
  }
  
  public Damj getFinPeriodeApplicationDelai()
  {
    return m_finPeriodeApplicationDelai;
  }
  
  public void setFinPeriodeApplicationDelai(Damj p_finPeriodeApplicationDelai)
  {
    m_finPeriodeApplicationDelai = p_finPeriodeApplicationDelai;
  }
  
  public Damj getFinPeriodeApplicationICCP()
  {
    return m_finPeriodeApplicationICCP;
  }
  
  public void setFinPeriodeApplicationICCP(Damj p_finPeriodeApplicationICCP)
  {
    m_finPeriodeApplicationICCP = p_finPeriodeApplicationICCP;
  }
  
  public Damj getFinPeriodeApplicationISLR()
  {
    return m_finPeriodeApplicationISLR;
  }
  
  public void setFinPeriodeApplicationISLR(Damj p_finPeriodeApplicationISLR)
  {
    m_finPeriodeApplicationISLR = p_finPeriodeApplicationISLR;
  }
  
  public Damj getFinPeriodeApplicationPMC()
  {
    return m_finPeriodeApplicationPMC;
  }
  
  public void setFinPeriodeApplicationPMC(Damj p_finPeriodeApplicationPMC)
  {
    m_finPeriodeApplicationPMC = p_finPeriodeApplicationPMC;
  }
}

/* Location:
 * Qualified Name:     DomEnregistrerCalendrierEtatAuDJI
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */