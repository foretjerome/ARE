package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.databean.Attribute;
import fr.unedic.archi.databean.DataBean;
import fr.unedic.archi.databean.DataBeanImpl;
import fr.unedic.archi.databean.GettersHandler;
import fr.unedic.archi.databean.PropertyInfo;
import fr.unedic.archi.databean.SettersHandler;
import fr.unedic.archi.databean.StringAttribute;
import fr.unedic.util.temps.Damj;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;

public class _FluxCtPasDsn
  extends DataBeanImpl
  implements DataBean, Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  private String m__C_ETAT;
  private String m__IDENT;
  private String m_typeEnreg;
  private String m_typeEnreg_C_ERR;
  private String m_numNIRCertifie;
  private String m_numNIRCertifie_C_ERR;
  private String m_nomDeclare;
  private String m_nomDeclare_C_ERR;
  private String m_prenomDeclare;
  private String m_prenomDeclare_C_ERR;
  private Damj m_dateNaissance;
  private String m_dateNaissance_C_ERR;
  private String m_contexteEmission;
  private String m_contexteEmission_C_ERR;
  private String m_natureJustificatif;
  private String m_natureJustificatif_C_ERR;
  private String m_codeMessage;
  private String m_codeMessage_C_ERR;
  private BigDecimal m_numeroVersion;
  private String m_numeroVersion_C_ERR;
  private BigDecimal m_numeroSousVersion;
  private String m_numeroSousVersion_C_ERR;
  private String m_codeAction;
  private String m_codeAction_C_ERR;
  private BigDecimal m_idTechnique;
  private String m_idTechnique_C_ERR;
  private BigDecimal m_idRCE;
  private String m_idRCE_C_ERR;
  private BigDecimal m_siretDeclare;
  private String m_siretDeclare_C_ERR;
  private String m_refContratEmployeur;
  private String m_refContratEmployeur_C_ERR;
  private BigDecimal m_nbMessagesPrimesIndemnites;
  private String m_nbMessagesPrimesIndemnites_C_ERR;
  private Damj m_dateConnaissanceMensuelle;
  private String m_dateConnaissanceMensuelle_C_ERR;
  private Damj m_dateMoisDeclare;
  private String m_dateMoisDeclare_C_ERR;
  private Damj m_dateDebutContrat;
  private String m_dateDebutContrat_C_ERR;
  private Damj m_dateFinContrat;
  private String m_dateFinContrat_C_ERR;
  private String m_natureContrat;
  private String m_natureContrat_C_ERR;
  private String m_typeContrat;
  private String m_typeContrat_C_ERR;
  private String m_codeStatutCadre;
  private String m_codeStatutCadre_C_ERR;
  private BigDecimal m_horaireSalarie;
  private String m_horaireSalarie_C_ERR;
  private BigDecimal m_horaireEntreprise;
  private String m_horaireEntreprise_C_ERR;
  private String m_uniteTempsTravail;
  private String m_uniteTempsTravail_C_ERR;
  private String m_alsaceMoselle;
  private String m_alsaceMoselle_C_ERR;
  private String m_regimeSpecialSecuriteSoc;
  private String m_regimeSpecialSecuriteSoc_C_ERR;
  private String m_typeCaisseCP;
  private String m_typeCaisseCP_C_ERR;
  private String m_niveauQualification;
  private String m_niveauQualification_C_ERR;
  private String m_codeCaisseRetraiteCompl;
  private String m_codeCaisseRetraiteCompl_C_ERR;
  private String m_champApplicationEmployeur;
  private String m_champApplicationEmployeur_C_ERR;
  private String m_numConventionGestionEmpPublic;
  private String m_numConventionGestionEmpPublic_C_ERR;
  private String m_etablissementFinancier;
  private String m_etablissementFinancier_C_ERR;
  private String m_codeAffectation;
  private String m_codeAffectation_C_ERR;
  private String m_numInterneEmpPublic;
  private String m_numInterneEmpPublic_C_ERR;
  private String m_statutSalarie;
  private String m_statutSalarie_C_ERR;
  private Damj m_dateAdhesion;
  private String m_dateAdhesion_C_ERR;
  private String m_motifPeriodeInactivite;
  private String m_motifPeriodeInactivite_C_ERR;
  private Damj m_dateDebutPeriodeInactivite;
  private String m_dateDebutPeriodeInactivite_C_ERR;
  private Damj m_dateFinPeriodeInactivite;
  private String m_dateFinPeriodeInactivite_C_ERR;
  private Damj m_dateDebutPeriodeSalaire;
  private String m_dateDebutPeriodeSalaire_C_ERR;
  private Damj m_dateFinPeriodeSalaire;
  private String m_dateFinPeriodeSalaire_C_ERR;
  private String m_codePcsEse;
  private String m_codePcsEse_C_ERR;
  private String m_codeComplementPcsEse;
  private String m_codeComplementPcsEse_C_ERR;
  private String m_signeSalaireBrutAbattu;
  private String m_signeSalaireBrutAbattu_C_ERR;
  private BigDecimal m_salaireBrutAbattu;
  private String m_salaireBrutAbattu_C_ERR;
  private Damj m_datePaiement;
  private String m_datePaiement_C_ERR;
  private BigDecimal m_dureeAbsence;
  private String m_dureeAbsence_C_ERR;
  private String m_uniteAbsence;
  private String m_uniteAbsence_C_ERR;
  private String m_nomLogiciel;
  private String m_nomLogiciel_C_ERR;
  private String m_versionLogiciel;
  private String m_versionLogiciel_C_ERR;
  private String m_numeroRCI;
  private String m_numeroRCI_C_ERR;
  private String m_cxass;
  private String m_cxass_C_ERR;
  private String m_rsin;
  private String m_rsin_C_ERR;
  private String m_nom;
  private String m_nom_C_ERR;
  private String m_prenom;
  private String m_prenom_C_ERR;
  private String m_peAffi;
  private String m_peAffi_C_ERR;
  private String m_siret;
  private String m_siret_C_ERR;
  private String m_emplNumAffi;
  private String m_emplNumAffi_C_ERR;
  private String m_emplRaisonSociale;
  private String m_emplRaisonSociale_C_ERR;
  private String m_emplNAF;
  private String m_emplNAF_C_ERR;
  private String m_emplCommune;
  private String m_emplCommune_C_ERR;
  private BigDecimal m_emplCP;
  private String m_emplCP_C_ERR;
  private BigDecimal m_idBNEArrco;
  private String m_idBNEArrco_C_ERR;
  private String m_arrcoSigle;
  private String m_arrcoSigle_C_ERR;
  private String m_arrcoRaisonSociale;
  private String m_arrcoRaisonSociale_C_ERR;
  private BigDecimal m_idBNEAgirc;
  private String m_idBNEAgirc_C_ERR;
  private String m_agircSigle;
  private String m_agircSigle_C_ERR;
  private String m_agircRaisonSociale;
  private String m_agircRaisonSociale_C_ERR;
  private String m_codeRegimeCrpCtp;
  private String m_codeRegimeCrpCtp_C_ERR;
  private Damj m_dateEffetRegimeCrpCtp;
  private String m_dateEffetRegimeCrpCtp_C_ERR;
  private String m_emplNumConventionGestion;
  private String m_emplNumConventionGestion_C_ERR;
  private BigDecimal m_nbSalariesEntreprise;
  private String m_nbSalariesEntreprise_C_ERR;
  private String m_nomEmployeur;
  private String m_nomEmployeur_C_ERR;
  private String m_prenomEmployeur;
  private String m_prenomEmployeur_C_ERR;
  private String m_categorieJuridique;
  private String m_categorieJuridique_C_ERR;
  private String m_codeRegimeEntreprise;
  private String m_codeRegimeEntreprise_C_ERR;
  private Damj m_dateCessationEntreprise;
  private String m_dateCessationEntreprise_C_ERR;
  private String m_natureEntreprise;
  private String m_natureEntreprise_C_ERR;
  private String m_numMSAEntreprise;
  private String m_numMSAEntreprise_C_ERR;
  private Damj m_debutPeriodeAffiliationEntreprise;
  private String m_debutPeriodeAffiliationEntreprise_C_ERR;
  private Damj m_finPeriodeAffiliationEntreprise;
  private String m_finPeriodeAffiliationEntreprise_C_ERR;
  private Damj m_debutConventionGestion;
  private String m_debutConventionGestion_C_ERR;
  private Damj m_finConventionGestion;
  private String m_finConventionGestion_C_ERR;
  private String m_secteurPublic;
  private String m_secteurPublic_C_ERR;
  private String m_trancheEffectifEntreprise;
  private String m_trancheEffectifEntreprise_C_ERR;
  private Damj m_debutAGS;
  private String m_debutAGS_C_ERR;
  private Damj m_finAGS;
  private String m_finAGS_C_ERR;
  private Damj m_debutAdhesionRevocable;
  private String m_debutAdhesionRevocable_C_ERR;
  private Damj m_finAdhesionRevocable;
  private String m_finAdhesionRevocable_C_ERR;
  private _ListeFluxQuantiteTravailDsn m_listeFluxQuantiteTravailDsn;
  private String m_listeFluxQuantiteTravailDsn_C_ERR;
  private String m_motifFinContrat;
  private String m_motifFinContrat_C_ERR;
  private Damj m_dateInitialeFinContrat;
  private String m_dateInitialeFinContrat_C_ERR;
  private BigDecimal m_idActiviteDsnPe;
  private String m_idActiviteDsnPe_C_ERR;
  private String m_signeDureeAbsence;
  private String m_signeDureeAbsence_C_ERR;
  private _ListeFluxPrimeIndemDsn m_listeFluxPrimeIndemDsn;
  private String m_listeFluxPrimeIndemDsn_C_ERR;
  private String m_identDeclPri;
  private String m_identDeclPri_C_ERR;
  private String m_identDeclSec;
  private String m_identDeclSec_C_ERR;
  private String m_motifRecours;
  private String m_motifRecours_C_ERR;
  private String m_modaliteDeclarativeFinContrat;
  private String m_modaliteDeclarativeFinContrat_C_ERR;
  private Damj m_djtp;
  private String m_djtp_C_ERR;
  
  public String get_C_ETAT()
  {
    return m__C_ETAT;
  }
  
  public String get_IDENT()
  {
    return m__IDENT;
  }
  
  public void set_C_ETAT(String pCETAT)
  {
    m__C_ETAT = pCETAT;
  }
  
  public void set_IDENT(String pIDENT)
  {
    m__IDENT = pIDENT;
  }
  
  public String getTypeEnreg()
  {
    return m_typeEnreg;
  }
  
  public String getTypeEnreg_C_ERR()
  {
    return m_typeEnreg_C_ERR;
  }
  
  public void setTypeEnreg(String pValeur)
  {
    m_typeEnreg = pValeur;
  }
  
  public void setTypeEnreg_C_ERR(String pValeur_C_ERR)
  {
    m_typeEnreg_C_ERR = pValeur_C_ERR;
  }
  
  public String getNumNIRCertifie()
  {
    return m_numNIRCertifie;
  }
  
  public String getNumNIRCertifie_C_ERR()
  {
    return m_numNIRCertifie_C_ERR;
  }
  
  public void setNumNIRCertifie(String pValeur)
  {
    m_numNIRCertifie = pValeur;
  }
  
  public void setNumNIRCertifie_C_ERR(String pValeur_C_ERR)
  {
    m_numNIRCertifie_C_ERR = pValeur_C_ERR;
  }
  
  public String getNomDeclare()
  {
    return m_nomDeclare;
  }
  
  public String getNomDeclare_C_ERR()
  {
    return m_nomDeclare_C_ERR;
  }
  
  public void setNomDeclare(String pValeur)
  {
    m_nomDeclare = pValeur;
  }
  
  public void setNomDeclare_C_ERR(String pValeur_C_ERR)
  {
    m_nomDeclare_C_ERR = pValeur_C_ERR;
  }
  
  public String getPrenomDeclare()
  {
    return m_prenomDeclare;
  }
  
  public String getPrenomDeclare_C_ERR()
  {
    return m_prenomDeclare_C_ERR;
  }
  
  public void setPrenomDeclare(String pValeur)
  {
    m_prenomDeclare = pValeur;
  }
  
  public void setPrenomDeclare_C_ERR(String pValeur_C_ERR)
  {
    m_prenomDeclare_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDateNaissance()
  {
    return m_dateNaissance;
  }
  
  public String getDateNaissance_C_ERR()
  {
    return m_dateNaissance_C_ERR;
  }
  
  public void setDateNaissance(Damj pValeur)
  {
    m_dateNaissance = pValeur;
  }
  
  public void setDateNaissance_C_ERR(String pValeur_C_ERR)
  {
    m_dateNaissance_C_ERR = pValeur_C_ERR;
  }
  
  public String getContexteEmission()
  {
    return m_contexteEmission;
  }
  
  public String getContexteEmission_C_ERR()
  {
    return m_contexteEmission_C_ERR;
  }
  
  public void setContexteEmission(String pValeur)
  {
    m_contexteEmission = pValeur;
  }
  
  public void setContexteEmission_C_ERR(String pValeur_C_ERR)
  {
    m_contexteEmission_C_ERR = pValeur_C_ERR;
  }
  
  public String getNatureJustificatif()
  {
    return m_natureJustificatif;
  }
  
  public String getNatureJustificatif_C_ERR()
  {
    return m_natureJustificatif_C_ERR;
  }
  
  public void setNatureJustificatif(String pValeur)
  {
    m_natureJustificatif = pValeur;
  }
  
  public void setNatureJustificatif_C_ERR(String pValeur_C_ERR)
  {
    m_natureJustificatif_C_ERR = pValeur_C_ERR;
  }
  
  public String getCodeMessage()
  {
    return m_codeMessage;
  }
  
  public String getCodeMessage_C_ERR()
  {
    return m_codeMessage_C_ERR;
  }
  
  public void setCodeMessage(String pValeur)
  {
    m_codeMessage = pValeur;
  }
  
  public void setCodeMessage_C_ERR(String pValeur_C_ERR)
  {
    m_codeMessage_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getNumeroVersion()
  {
    return m_numeroVersion;
  }
  
  public String getNumeroVersion_C_ERR()
  {
    return m_numeroVersion_C_ERR;
  }
  
  public void setNumeroVersion(BigDecimal pValeur)
  {
    m_numeroVersion = pValeur;
  }
  
  public void setNumeroVersion_C_ERR(String pValeur_C_ERR)
  {
    m_numeroVersion_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getNumeroSousVersion()
  {
    return m_numeroSousVersion;
  }
  
  public String getNumeroSousVersion_C_ERR()
  {
    return m_numeroSousVersion_C_ERR;
  }
  
  public void setNumeroSousVersion(BigDecimal pValeur)
  {
    m_numeroSousVersion = pValeur;
  }
  
  public void setNumeroSousVersion_C_ERR(String pValeur_C_ERR)
  {
    m_numeroSousVersion_C_ERR = pValeur_C_ERR;
  }
  
  public String getCodeAction()
  {
    return m_codeAction;
  }
  
  public String getCodeAction_C_ERR()
  {
    return m_codeAction_C_ERR;
  }
  
  public void setCodeAction(String pValeur)
  {
    m_codeAction = pValeur;
  }
  
  public void setCodeAction_C_ERR(String pValeur_C_ERR)
  {
    m_codeAction_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getIdTechnique()
  {
    return m_idTechnique;
  }
  
  public String getIdTechnique_C_ERR()
  {
    return m_idTechnique_C_ERR;
  }
  
  public void setIdTechnique(BigDecimal pValeur)
  {
    m_idTechnique = pValeur;
  }
  
  public void setIdTechnique_C_ERR(String pValeur_C_ERR)
  {
    m_idTechnique_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getIdRCE()
  {
    return m_idRCE;
  }
  
  public String getIdRCE_C_ERR()
  {
    return m_idRCE_C_ERR;
  }
  
  public void setIdRCE(BigDecimal pValeur)
  {
    m_idRCE = pValeur;
  }
  
  public void setIdRCE_C_ERR(String pValeur_C_ERR)
  {
    m_idRCE_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getSiretDeclare()
  {
    return m_siretDeclare;
  }
  
  public String getSiretDeclare_C_ERR()
  {
    return m_siretDeclare_C_ERR;
  }
  
  public void setSiretDeclare(BigDecimal pValeur)
  {
    m_siretDeclare = pValeur;
  }
  
  public void setSiretDeclare_C_ERR(String pValeur_C_ERR)
  {
    m_siretDeclare_C_ERR = pValeur_C_ERR;
  }
  
  public String getRefContratEmployeur()
  {
    return m_refContratEmployeur;
  }
  
  public String getRefContratEmployeur_C_ERR()
  {
    return m_refContratEmployeur_C_ERR;
  }
  
  public void setRefContratEmployeur(String pValeur)
  {
    m_refContratEmployeur = pValeur;
  }
  
  public void setRefContratEmployeur_C_ERR(String pValeur_C_ERR)
  {
    m_refContratEmployeur_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getNbMessagesPrimesIndemnites()
  {
    return m_nbMessagesPrimesIndemnites;
  }
  
  public String getNbMessagesPrimesIndemnites_C_ERR()
  {
    return m_nbMessagesPrimesIndemnites_C_ERR;
  }
  
  public void setNbMessagesPrimesIndemnites(BigDecimal pValeur)
  {
    m_nbMessagesPrimesIndemnites = pValeur;
  }
  
  public void setNbMessagesPrimesIndemnites_C_ERR(String pValeur_C_ERR)
  {
    m_nbMessagesPrimesIndemnites_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDateConnaissanceMensuelle()
  {
    return m_dateConnaissanceMensuelle;
  }
  
  public String getDateConnaissanceMensuelle_C_ERR()
  {
    return m_dateConnaissanceMensuelle_C_ERR;
  }
  
  public void setDateConnaissanceMensuelle(Damj pValeur)
  {
    m_dateConnaissanceMensuelle = pValeur;
  }
  
  public void setDateConnaissanceMensuelle_C_ERR(String pValeur_C_ERR)
  {
    m_dateConnaissanceMensuelle_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDateMoisDeclare()
  {
    return m_dateMoisDeclare;
  }
  
  public String getDateMoisDeclare_C_ERR()
  {
    return m_dateMoisDeclare_C_ERR;
  }
  
  public void setDateMoisDeclare(Damj pValeur)
  {
    m_dateMoisDeclare = pValeur;
  }
  
  public void setDateMoisDeclare_C_ERR(String pValeur_C_ERR)
  {
    m_dateMoisDeclare_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDateDebutContrat()
  {
    return m_dateDebutContrat;
  }
  
  public String getDateDebutContrat_C_ERR()
  {
    return m_dateDebutContrat_C_ERR;
  }
  
  public void setDateDebutContrat(Damj pValeur)
  {
    m_dateDebutContrat = pValeur;
  }
  
  public void setDateDebutContrat_C_ERR(String pValeur_C_ERR)
  {
    m_dateDebutContrat_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDateFinContrat()
  {
    return m_dateFinContrat;
  }
  
  public String getDateFinContrat_C_ERR()
  {
    return m_dateFinContrat_C_ERR;
  }
  
  public void setDateFinContrat(Damj pValeur)
  {
    m_dateFinContrat = pValeur;
  }
  
  public void setDateFinContrat_C_ERR(String pValeur_C_ERR)
  {
    m_dateFinContrat_C_ERR = pValeur_C_ERR;
  }
  
  public String getNatureContrat()
  {
    return m_natureContrat;
  }
  
  public String getNatureContrat_C_ERR()
  {
    return m_natureContrat_C_ERR;
  }
  
  public void setNatureContrat(String pValeur)
  {
    m_natureContrat = pValeur;
  }
  
  public void setNatureContrat_C_ERR(String pValeur_C_ERR)
  {
    m_natureContrat_C_ERR = pValeur_C_ERR;
  }
  
  public String getTypeContrat()
  {
    return m_typeContrat;
  }
  
  public String getTypeContrat_C_ERR()
  {
    return m_typeContrat_C_ERR;
  }
  
  public void setTypeContrat(String pValeur)
  {
    m_typeContrat = pValeur;
  }
  
  public void setTypeContrat_C_ERR(String pValeur_C_ERR)
  {
    m_typeContrat_C_ERR = pValeur_C_ERR;
  }
  
  public String getCodeStatutCadre()
  {
    return m_codeStatutCadre;
  }
  
  public String getCodeStatutCadre_C_ERR()
  {
    return m_codeStatutCadre_C_ERR;
  }
  
  public void setCodeStatutCadre(String pValeur)
  {
    m_codeStatutCadre = pValeur;
  }
  
  public void setCodeStatutCadre_C_ERR(String pValeur_C_ERR)
  {
    m_codeStatutCadre_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getHoraireSalarie()
  {
    return m_horaireSalarie;
  }
  
  public String getHoraireSalarie_C_ERR()
  {
    return m_horaireSalarie_C_ERR;
  }
  
  public void setHoraireSalarie(BigDecimal pValeur)
  {
    m_horaireSalarie = pValeur;
  }
  
  public void setHoraireSalarie_C_ERR(String pValeur_C_ERR)
  {
    m_horaireSalarie_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getHoraireEntreprise()
  {
    return m_horaireEntreprise;
  }
  
  public String getHoraireEntreprise_C_ERR()
  {
    return m_horaireEntreprise_C_ERR;
  }
  
  public void setHoraireEntreprise(BigDecimal pValeur)
  {
    m_horaireEntreprise = pValeur;
  }
  
  public void setHoraireEntreprise_C_ERR(String pValeur_C_ERR)
  {
    m_horaireEntreprise_C_ERR = pValeur_C_ERR;
  }
  
  public String getUniteTempsTravail()
  {
    return m_uniteTempsTravail;
  }
  
  public String getUniteTempsTravail_C_ERR()
  {
    return m_uniteTempsTravail_C_ERR;
  }
  
  public void setUniteTempsTravail(String pValeur)
  {
    m_uniteTempsTravail = pValeur;
  }
  
  public void setUniteTempsTravail_C_ERR(String pValeur_C_ERR)
  {
    m_uniteTempsTravail_C_ERR = pValeur_C_ERR;
  }
  
  public String getAlsaceMoselle()
  {
    return m_alsaceMoselle;
  }
  
  public String getAlsaceMoselle_C_ERR()
  {
    return m_alsaceMoselle_C_ERR;
  }
  
  public void setAlsaceMoselle(String pValeur)
  {
    m_alsaceMoselle = pValeur;
  }
  
  public void setAlsaceMoselle_C_ERR(String pValeur_C_ERR)
  {
    m_alsaceMoselle_C_ERR = pValeur_C_ERR;
  }
  
  public String getRegimeSpecialSecuriteSoc()
  {
    return m_regimeSpecialSecuriteSoc;
  }
  
  public String getRegimeSpecialSecuriteSoc_C_ERR()
  {
    return m_regimeSpecialSecuriteSoc_C_ERR;
  }
  
  public void setRegimeSpecialSecuriteSoc(String pValeur)
  {
    m_regimeSpecialSecuriteSoc = pValeur;
  }
  
  public void setRegimeSpecialSecuriteSoc_C_ERR(String pValeur_C_ERR)
  {
    m_regimeSpecialSecuriteSoc_C_ERR = pValeur_C_ERR;
  }
  
  public String getTypeCaisseCP()
  {
    return m_typeCaisseCP;
  }
  
  public String getTypeCaisseCP_C_ERR()
  {
    return m_typeCaisseCP_C_ERR;
  }
  
  public void setTypeCaisseCP(String pValeur)
  {
    m_typeCaisseCP = pValeur;
  }
  
  public void setTypeCaisseCP_C_ERR(String pValeur_C_ERR)
  {
    m_typeCaisseCP_C_ERR = pValeur_C_ERR;
  }
  
  public String getNiveauQualification()
  {
    return m_niveauQualification;
  }
  
  public String getNiveauQualification_C_ERR()
  {
    return m_niveauQualification_C_ERR;
  }
  
  public void setNiveauQualification(String pValeur)
  {
    m_niveauQualification = pValeur;
  }
  
  public void setNiveauQualification_C_ERR(String pValeur_C_ERR)
  {
    m_niveauQualification_C_ERR = pValeur_C_ERR;
  }
  
  public String getCodeCaisseRetraiteCompl()
  {
    return m_codeCaisseRetraiteCompl;
  }
  
  public String getCodeCaisseRetraiteCompl_C_ERR()
  {
    return m_codeCaisseRetraiteCompl_C_ERR;
  }
  
  public void setCodeCaisseRetraiteCompl(String pValeur)
  {
    m_codeCaisseRetraiteCompl = pValeur;
  }
  
  public void setCodeCaisseRetraiteCompl_C_ERR(String pValeur_C_ERR)
  {
    m_codeCaisseRetraiteCompl_C_ERR = pValeur_C_ERR;
  }
  
  public String getChampApplicationEmployeur()
  {
    return m_champApplicationEmployeur;
  }
  
  public String getChampApplicationEmployeur_C_ERR()
  {
    return m_champApplicationEmployeur_C_ERR;
  }
  
  public void setChampApplicationEmployeur(String pValeur)
  {
    m_champApplicationEmployeur = pValeur;
  }
  
  public void setChampApplicationEmployeur_C_ERR(String pValeur_C_ERR)
  {
    m_champApplicationEmployeur_C_ERR = pValeur_C_ERR;
  }
  
  public String getNumConventionGestionEmpPublic()
  {
    return m_numConventionGestionEmpPublic;
  }
  
  public String getNumConventionGestionEmpPublic_C_ERR()
  {
    return m_numConventionGestionEmpPublic_C_ERR;
  }
  
  public void setNumConventionGestionEmpPublic(String pValeur)
  {
    m_numConventionGestionEmpPublic = pValeur;
  }
  
  public void setNumConventionGestionEmpPublic_C_ERR(String pValeur_C_ERR)
  {
    m_numConventionGestionEmpPublic_C_ERR = pValeur_C_ERR;
  }
  
  public String getEtablissementFinancier()
  {
    return m_etablissementFinancier;
  }
  
  public String getEtablissementFinancier_C_ERR()
  {
    return m_etablissementFinancier_C_ERR;
  }
  
  public void setEtablissementFinancier(String pValeur)
  {
    m_etablissementFinancier = pValeur;
  }
  
  public void setEtablissementFinancier_C_ERR(String pValeur_C_ERR)
  {
    m_etablissementFinancier_C_ERR = pValeur_C_ERR;
  }
  
  public String getCodeAffectation()
  {
    return m_codeAffectation;
  }
  
  public String getCodeAffectation_C_ERR()
  {
    return m_codeAffectation_C_ERR;
  }
  
  public void setCodeAffectation(String pValeur)
  {
    m_codeAffectation = pValeur;
  }
  
  public void setCodeAffectation_C_ERR(String pValeur_C_ERR)
  {
    m_codeAffectation_C_ERR = pValeur_C_ERR;
  }
  
  public String getNumInterneEmpPublic()
  {
    return m_numInterneEmpPublic;
  }
  
  public String getNumInterneEmpPublic_C_ERR()
  {
    return m_numInterneEmpPublic_C_ERR;
  }
  
  public void setNumInterneEmpPublic(String pValeur)
  {
    m_numInterneEmpPublic = pValeur;
  }
  
  public void setNumInterneEmpPublic_C_ERR(String pValeur_C_ERR)
  {
    m_numInterneEmpPublic_C_ERR = pValeur_C_ERR;
  }
  
  public String getStatutSalarie()
  {
    return m_statutSalarie;
  }
  
  public String getStatutSalarie_C_ERR()
  {
    return m_statutSalarie_C_ERR;
  }
  
  public void setStatutSalarie(String pValeur)
  {
    m_statutSalarie = pValeur;
  }
  
  public void setStatutSalarie_C_ERR(String pValeur_C_ERR)
  {
    m_statutSalarie_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDateAdhesion()
  {
    return m_dateAdhesion;
  }
  
  public String getDateAdhesion_C_ERR()
  {
    return m_dateAdhesion_C_ERR;
  }
  
  public void setDateAdhesion(Damj pValeur)
  {
    m_dateAdhesion = pValeur;
  }
  
  public void setDateAdhesion_C_ERR(String pValeur_C_ERR)
  {
    m_dateAdhesion_C_ERR = pValeur_C_ERR;
  }
  
  public String getMotifPeriodeInactivite()
  {
    return m_motifPeriodeInactivite;
  }
  
  public String getMotifPeriodeInactivite_C_ERR()
  {
    return m_motifPeriodeInactivite_C_ERR;
  }
  
  public void setMotifPeriodeInactivite(String pValeur)
  {
    m_motifPeriodeInactivite = pValeur;
  }
  
  public void setMotifPeriodeInactivite_C_ERR(String pValeur_C_ERR)
  {
    m_motifPeriodeInactivite_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDateDebutPeriodeInactivite()
  {
    return m_dateDebutPeriodeInactivite;
  }
  
  public String getDateDebutPeriodeInactivite_C_ERR()
  {
    return m_dateDebutPeriodeInactivite_C_ERR;
  }
  
  public void setDateDebutPeriodeInactivite(Damj pValeur)
  {
    m_dateDebutPeriodeInactivite = pValeur;
  }
  
  public void setDateDebutPeriodeInactivite_C_ERR(String pValeur_C_ERR)
  {
    m_dateDebutPeriodeInactivite_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDateFinPeriodeInactivite()
  {
    return m_dateFinPeriodeInactivite;
  }
  
  public String getDateFinPeriodeInactivite_C_ERR()
  {
    return m_dateFinPeriodeInactivite_C_ERR;
  }
  
  public void setDateFinPeriodeInactivite(Damj pValeur)
  {
    m_dateFinPeriodeInactivite = pValeur;
  }
  
  public void setDateFinPeriodeInactivite_C_ERR(String pValeur_C_ERR)
  {
    m_dateFinPeriodeInactivite_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDateDebutPeriodeSalaire()
  {
    return m_dateDebutPeriodeSalaire;
  }
  
  public String getDateDebutPeriodeSalaire_C_ERR()
  {
    return m_dateDebutPeriodeSalaire_C_ERR;
  }
  
  public void setDateDebutPeriodeSalaire(Damj pValeur)
  {
    m_dateDebutPeriodeSalaire = pValeur;
  }
  
  public void setDateDebutPeriodeSalaire_C_ERR(String pValeur_C_ERR)
  {
    m_dateDebutPeriodeSalaire_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDateFinPeriodeSalaire()
  {
    return m_dateFinPeriodeSalaire;
  }
  
  public String getDateFinPeriodeSalaire_C_ERR()
  {
    return m_dateFinPeriodeSalaire_C_ERR;
  }
  
  public void setDateFinPeriodeSalaire(Damj pValeur)
  {
    m_dateFinPeriodeSalaire = pValeur;
  }
  
  public void setDateFinPeriodeSalaire_C_ERR(String pValeur_C_ERR)
  {
    m_dateFinPeriodeSalaire_C_ERR = pValeur_C_ERR;
  }
  
  public String getCodePcsEse()
  {
    return m_codePcsEse;
  }
  
  public String getCodePcsEse_C_ERR()
  {
    return m_codePcsEse_C_ERR;
  }
  
  public void setCodePcsEse(String pValeur)
  {
    m_codePcsEse = pValeur;
  }
  
  public void setCodePcsEse_C_ERR(String pValeur_C_ERR)
  {
    m_codePcsEse_C_ERR = pValeur_C_ERR;
  }
  
  public String getCodeComplementPcsEse()
  {
    return m_codeComplementPcsEse;
  }
  
  public String getCodeComplementPcsEse_C_ERR()
  {
    return m_codeComplementPcsEse_C_ERR;
  }
  
  public void setCodeComplementPcsEse(String pValeur)
  {
    m_codeComplementPcsEse = pValeur;
  }
  
  public void setCodeComplementPcsEse_C_ERR(String pValeur_C_ERR)
  {
    m_codeComplementPcsEse_C_ERR = pValeur_C_ERR;
  }
  
  public String getSigneSalaireBrutAbattu()
  {
    return m_signeSalaireBrutAbattu;
  }
  
  public String getSigneSalaireBrutAbattu_C_ERR()
  {
    return m_signeSalaireBrutAbattu_C_ERR;
  }
  
  public void setSigneSalaireBrutAbattu(String pValeur)
  {
    m_signeSalaireBrutAbattu = pValeur;
  }
  
  public void setSigneSalaireBrutAbattu_C_ERR(String pValeur_C_ERR)
  {
    m_signeSalaireBrutAbattu_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getSalaireBrutAbattu()
  {
    return m_salaireBrutAbattu;
  }
  
  public String getSalaireBrutAbattu_C_ERR()
  {
    return m_salaireBrutAbattu_C_ERR;
  }
  
  public void setSalaireBrutAbattu(BigDecimal pValeur)
  {
    m_salaireBrutAbattu = pValeur;
  }
  
  public void setSalaireBrutAbattu_C_ERR(String pValeur_C_ERR)
  {
    m_salaireBrutAbattu_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDatePaiement()
  {
    return m_datePaiement;
  }
  
  public String getDatePaiement_C_ERR()
  {
    return m_datePaiement_C_ERR;
  }
  
  public void setDatePaiement(Damj pValeur)
  {
    m_datePaiement = pValeur;
  }
  
  public void setDatePaiement_C_ERR(String pValeur_C_ERR)
  {
    m_datePaiement_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getDureeAbsence()
  {
    return m_dureeAbsence;
  }
  
  public String getDureeAbsence_C_ERR()
  {
    return m_dureeAbsence_C_ERR;
  }
  
  public void setDureeAbsence(BigDecimal pValeur)
  {
    m_dureeAbsence = pValeur;
  }
  
  public void setDureeAbsence_C_ERR(String pValeur_C_ERR)
  {
    m_dureeAbsence_C_ERR = pValeur_C_ERR;
  }
  
  public String getUniteAbsence()
  {
    return m_uniteAbsence;
  }
  
  public String getUniteAbsence_C_ERR()
  {
    return m_uniteAbsence_C_ERR;
  }
  
  public void setUniteAbsence(String pValeur)
  {
    m_uniteAbsence = pValeur;
  }
  
  public void setUniteAbsence_C_ERR(String pValeur_C_ERR)
  {
    m_uniteAbsence_C_ERR = pValeur_C_ERR;
  }
  
  public String getNomLogiciel()
  {
    return m_nomLogiciel;
  }
  
  public String getNomLogiciel_C_ERR()
  {
    return m_nomLogiciel_C_ERR;
  }
  
  public void setNomLogiciel(String pValeur)
  {
    m_nomLogiciel = pValeur;
  }
  
  public void setNomLogiciel_C_ERR(String pValeur_C_ERR)
  {
    m_nomLogiciel_C_ERR = pValeur_C_ERR;
  }
  
  public String getVersionLogiciel()
  {
    return m_versionLogiciel;
  }
  
  public String getVersionLogiciel_C_ERR()
  {
    return m_versionLogiciel_C_ERR;
  }
  
  public void setVersionLogiciel(String pValeur)
  {
    m_versionLogiciel = pValeur;
  }
  
  public void setVersionLogiciel_C_ERR(String pValeur_C_ERR)
  {
    m_versionLogiciel_C_ERR = pValeur_C_ERR;
  }
  
  public String getNumeroRCI()
  {
    return m_numeroRCI;
  }
  
  public String getNumeroRCI_C_ERR()
  {
    return m_numeroRCI_C_ERR;
  }
  
  public void setNumeroRCI(String pValeur)
  {
    m_numeroRCI = pValeur;
  }
  
  public void setNumeroRCI_C_ERR(String pValeur_C_ERR)
  {
    m_numeroRCI_C_ERR = pValeur_C_ERR;
  }
  
  public String getCxass()
  {
    return m_cxass;
  }
  
  public String getCxass_C_ERR()
  {
    return m_cxass_C_ERR;
  }
  
  public void setCxass(String pValeur)
  {
    m_cxass = pValeur;
  }
  
  public void setCxass_C_ERR(String pValeur_C_ERR)
  {
    m_cxass_C_ERR = pValeur_C_ERR;
  }
  
  public String getRsin()
  {
    return m_rsin;
  }
  
  public String getRsin_C_ERR()
  {
    return m_rsin_C_ERR;
  }
  
  public void setRsin(String pValeur)
  {
    m_rsin = pValeur;
  }
  
  public void setRsin_C_ERR(String pValeur_C_ERR)
  {
    m_rsin_C_ERR = pValeur_C_ERR;
  }
  
  public String getNom()
  {
    return m_nom;
  }
  
  public String getNom_C_ERR()
  {
    return m_nom_C_ERR;
  }
  
  public void setNom(String pValeur)
  {
    m_nom = pValeur;
  }
  
  public void setNom_C_ERR(String pValeur_C_ERR)
  {
    m_nom_C_ERR = pValeur_C_ERR;
  }
  
  public String getPrenom()
  {
    return m_prenom;
  }
  
  public String getPrenom_C_ERR()
  {
    return m_prenom_C_ERR;
  }
  
  public void setPrenom(String pValeur)
  {
    m_prenom = pValeur;
  }
  
  public void setPrenom_C_ERR(String pValeur_C_ERR)
  {
    m_prenom_C_ERR = pValeur_C_ERR;
  }
  
  public String getPeAffi()
  {
    return m_peAffi;
  }
  
  public String getPeAffi_C_ERR()
  {
    return m_peAffi_C_ERR;
  }
  
  public void setPeAffi(String pValeur)
  {
    m_peAffi = pValeur;
  }
  
  public void setPeAffi_C_ERR(String pValeur_C_ERR)
  {
    m_peAffi_C_ERR = pValeur_C_ERR;
  }
  
  public String getSiret()
  {
    return m_siret;
  }
  
  public String getSiret_C_ERR()
  {
    return m_siret_C_ERR;
  }
  
  public void setSiret(String pValeur)
  {
    m_siret = pValeur;
  }
  
  public void setSiret_C_ERR(String pValeur_C_ERR)
  {
    m_siret_C_ERR = pValeur_C_ERR;
  }
  
  public String getEmplNumAffi()
  {
    return m_emplNumAffi;
  }
  
  public String getEmplNumAffi_C_ERR()
  {
    return m_emplNumAffi_C_ERR;
  }
  
  public void setEmplNumAffi(String pValeur)
  {
    m_emplNumAffi = pValeur;
  }
  
  public void setEmplNumAffi_C_ERR(String pValeur_C_ERR)
  {
    m_emplNumAffi_C_ERR = pValeur_C_ERR;
  }
  
  public String getEmplRaisonSociale()
  {
    return m_emplRaisonSociale;
  }
  
  public String getEmplRaisonSociale_C_ERR()
  {
    return m_emplRaisonSociale_C_ERR;
  }
  
  public void setEmplRaisonSociale(String pValeur)
  {
    m_emplRaisonSociale = pValeur;
  }
  
  public void setEmplRaisonSociale_C_ERR(String pValeur_C_ERR)
  {
    m_emplRaisonSociale_C_ERR = pValeur_C_ERR;
  }
  
  public String getEmplNAF()
  {
    return m_emplNAF;
  }
  
  public String getEmplNAF_C_ERR()
  {
    return m_emplNAF_C_ERR;
  }
  
  public void setEmplNAF(String pValeur)
  {
    m_emplNAF = pValeur;
  }
  
  public void setEmplNAF_C_ERR(String pValeur_C_ERR)
  {
    m_emplNAF_C_ERR = pValeur_C_ERR;
  }
  
  public String getEmplCommune()
  {
    return m_emplCommune;
  }
  
  public String getEmplCommune_C_ERR()
  {
    return m_emplCommune_C_ERR;
  }
  
  public void setEmplCommune(String pValeur)
  {
    m_emplCommune = pValeur;
  }
  
  public void setEmplCommune_C_ERR(String pValeur_C_ERR)
  {
    m_emplCommune_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getEmplCP()
  {
    return m_emplCP;
  }
  
  public String getEmplCP_C_ERR()
  {
    return m_emplCP_C_ERR;
  }
  
  public void setEmplCP(BigDecimal pValeur)
  {
    m_emplCP = pValeur;
  }
  
  public void setEmplCP_C_ERR(String pValeur_C_ERR)
  {
    m_emplCP_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getIdBNEArrco()
  {
    return m_idBNEArrco;
  }
  
  public String getIdBNEArrco_C_ERR()
  {
    return m_idBNEArrco_C_ERR;
  }
  
  public void setIdBNEArrco(BigDecimal pValeur)
  {
    m_idBNEArrco = pValeur;
  }
  
  public void setIdBNEArrco_C_ERR(String pValeur_C_ERR)
  {
    m_idBNEArrco_C_ERR = pValeur_C_ERR;
  }
  
  public String getArrcoSigle()
  {
    return m_arrcoSigle;
  }
  
  public String getArrcoSigle_C_ERR()
  {
    return m_arrcoSigle_C_ERR;
  }
  
  public void setArrcoSigle(String pValeur)
  {
    m_arrcoSigle = pValeur;
  }
  
  public void setArrcoSigle_C_ERR(String pValeur_C_ERR)
  {
    m_arrcoSigle_C_ERR = pValeur_C_ERR;
  }
  
  public String getArrcoRaisonSociale()
  {
    return m_arrcoRaisonSociale;
  }
  
  public String getArrcoRaisonSociale_C_ERR()
  {
    return m_arrcoRaisonSociale_C_ERR;
  }
  
  public void setArrcoRaisonSociale(String pValeur)
  {
    m_arrcoRaisonSociale = pValeur;
  }
  
  public void setArrcoRaisonSociale_C_ERR(String pValeur_C_ERR)
  {
    m_arrcoRaisonSociale_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getIdBNEAgirc()
  {
    return m_idBNEAgirc;
  }
  
  public String getIdBNEAgirc_C_ERR()
  {
    return m_idBNEAgirc_C_ERR;
  }
  
  public void setIdBNEAgirc(BigDecimal pValeur)
  {
    m_idBNEAgirc = pValeur;
  }
  
  public void setIdBNEAgirc_C_ERR(String pValeur_C_ERR)
  {
    m_idBNEAgirc_C_ERR = pValeur_C_ERR;
  }
  
  public String getAgircSigle()
  {
    return m_agircSigle;
  }
  
  public String getAgircSigle_C_ERR()
  {
    return m_agircSigle_C_ERR;
  }
  
  public void setAgircSigle(String pValeur)
  {
    m_agircSigle = pValeur;
  }
  
  public void setAgircSigle_C_ERR(String pValeur_C_ERR)
  {
    m_agircSigle_C_ERR = pValeur_C_ERR;
  }
  
  public String getAgircRaisonSociale()
  {
    return m_agircRaisonSociale;
  }
  
  public String getAgircRaisonSociale_C_ERR()
  {
    return m_agircRaisonSociale_C_ERR;
  }
  
  public void setAgircRaisonSociale(String pValeur)
  {
    m_agircRaisonSociale = pValeur;
  }
  
  public void setAgircRaisonSociale_C_ERR(String pValeur_C_ERR)
  {
    m_agircRaisonSociale_C_ERR = pValeur_C_ERR;
  }
  
  public String getCodeRegimeCrpCtp()
  {
    return m_codeRegimeCrpCtp;
  }
  
  public String getCodeRegimeCrpCtp_C_ERR()
  {
    return m_codeRegimeCrpCtp_C_ERR;
  }
  
  public void setCodeRegimeCrpCtp(String pValeur)
  {
    m_codeRegimeCrpCtp = pValeur;
  }
  
  public void setCodeRegimeCrpCtp_C_ERR(String pValeur_C_ERR)
  {
    m_codeRegimeCrpCtp_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDateEffetRegimeCrpCtp()
  {
    return m_dateEffetRegimeCrpCtp;
  }
  
  public String getDateEffetRegimeCrpCtp_C_ERR()
  {
    return m_dateEffetRegimeCrpCtp_C_ERR;
  }
  
  public void setDateEffetRegimeCrpCtp(Damj pValeur)
  {
    m_dateEffetRegimeCrpCtp = pValeur;
  }
  
  public void setDateEffetRegimeCrpCtp_C_ERR(String pValeur_C_ERR)
  {
    m_dateEffetRegimeCrpCtp_C_ERR = pValeur_C_ERR;
  }
  
  public String getEmplNumConventionGestion()
  {
    return m_emplNumConventionGestion;
  }
  
  public String getEmplNumConventionGestion_C_ERR()
  {
    return m_emplNumConventionGestion_C_ERR;
  }
  
  public void setEmplNumConventionGestion(String pValeur)
  {
    m_emplNumConventionGestion = pValeur;
  }
  
  public void setEmplNumConventionGestion_C_ERR(String pValeur_C_ERR)
  {
    m_emplNumConventionGestion_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getNbSalariesEntreprise()
  {
    return m_nbSalariesEntreprise;
  }
  
  public String getNbSalariesEntreprise_C_ERR()
  {
    return m_nbSalariesEntreprise_C_ERR;
  }
  
  public void setNbSalariesEntreprise(BigDecimal pValeur)
  {
    m_nbSalariesEntreprise = pValeur;
  }
  
  public void setNbSalariesEntreprise_C_ERR(String pValeur_C_ERR)
  {
    m_nbSalariesEntreprise_C_ERR = pValeur_C_ERR;
  }
  
  public String getNomEmployeur()
  {
    return m_nomEmployeur;
  }
  
  public String getNomEmployeur_C_ERR()
  {
    return m_nomEmployeur_C_ERR;
  }
  
  public void setNomEmployeur(String pValeur)
  {
    m_nomEmployeur = pValeur;
  }
  
  public void setNomEmployeur_C_ERR(String pValeur_C_ERR)
  {
    m_nomEmployeur_C_ERR = pValeur_C_ERR;
  }
  
  public String getPrenomEmployeur()
  {
    return m_prenomEmployeur;
  }
  
  public String getPrenomEmployeur_C_ERR()
  {
    return m_prenomEmployeur_C_ERR;
  }
  
  public void setPrenomEmployeur(String pValeur)
  {
    m_prenomEmployeur = pValeur;
  }
  
  public void setPrenomEmployeur_C_ERR(String pValeur_C_ERR)
  {
    m_prenomEmployeur_C_ERR = pValeur_C_ERR;
  }
  
  public String getCategorieJuridique()
  {
    return m_categorieJuridique;
  }
  
  public String getCategorieJuridique_C_ERR()
  {
    return m_categorieJuridique_C_ERR;
  }
  
  public void setCategorieJuridique(String pValeur)
  {
    m_categorieJuridique = pValeur;
  }
  
  public void setCategorieJuridique_C_ERR(String pValeur_C_ERR)
  {
    m_categorieJuridique_C_ERR = pValeur_C_ERR;
  }
  
  public String getCodeRegimeEntreprise()
  {
    return m_codeRegimeEntreprise;
  }
  
  public String getCodeRegimeEntreprise_C_ERR()
  {
    return m_codeRegimeEntreprise_C_ERR;
  }
  
  public void setCodeRegimeEntreprise(String pValeur)
  {
    m_codeRegimeEntreprise = pValeur;
  }
  
  public void setCodeRegimeEntreprise_C_ERR(String pValeur_C_ERR)
  {
    m_codeRegimeEntreprise_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDateCessationEntreprise()
  {
    return m_dateCessationEntreprise;
  }
  
  public String getDateCessationEntreprise_C_ERR()
  {
    return m_dateCessationEntreprise_C_ERR;
  }
  
  public void setDateCessationEntreprise(Damj pValeur)
  {
    m_dateCessationEntreprise = pValeur;
  }
  
  public void setDateCessationEntreprise_C_ERR(String pValeur_C_ERR)
  {
    m_dateCessationEntreprise_C_ERR = pValeur_C_ERR;
  }
  
  public String getNatureEntreprise()
  {
    return m_natureEntreprise;
  }
  
  public String getNatureEntreprise_C_ERR()
  {
    return m_natureEntreprise_C_ERR;
  }
  
  public void setNatureEntreprise(String pValeur)
  {
    m_natureEntreprise = pValeur;
  }
  
  public void setNatureEntreprise_C_ERR(String pValeur_C_ERR)
  {
    m_natureEntreprise_C_ERR = pValeur_C_ERR;
  }
  
  public String getNumMSAEntreprise()
  {
    return m_numMSAEntreprise;
  }
  
  public String getNumMSAEntreprise_C_ERR()
  {
    return m_numMSAEntreprise_C_ERR;
  }
  
  public void setNumMSAEntreprise(String pValeur)
  {
    m_numMSAEntreprise = pValeur;
  }
  
  public void setNumMSAEntreprise_C_ERR(String pValeur_C_ERR)
  {
    m_numMSAEntreprise_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDebutPeriodeAffiliationEntreprise()
  {
    return m_debutPeriodeAffiliationEntreprise;
  }
  
  public String getDebutPeriodeAffiliationEntreprise_C_ERR()
  {
    return m_debutPeriodeAffiliationEntreprise_C_ERR;
  }
  
  public void setDebutPeriodeAffiliationEntreprise(Damj pValeur)
  {
    m_debutPeriodeAffiliationEntreprise = pValeur;
  }
  
  public void setDebutPeriodeAffiliationEntreprise_C_ERR(String pValeur_C_ERR)
  {
    m_debutPeriodeAffiliationEntreprise_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getFinPeriodeAffiliationEntreprise()
  {
    return m_finPeriodeAffiliationEntreprise;
  }
  
  public String getFinPeriodeAffiliationEntreprise_C_ERR()
  {
    return m_finPeriodeAffiliationEntreprise_C_ERR;
  }
  
  public void setFinPeriodeAffiliationEntreprise(Damj pValeur)
  {
    m_finPeriodeAffiliationEntreprise = pValeur;
  }
  
  public void setFinPeriodeAffiliationEntreprise_C_ERR(String pValeur_C_ERR)
  {
    m_finPeriodeAffiliationEntreprise_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDebutConventionGestion()
  {
    return m_debutConventionGestion;
  }
  
  public String getDebutConventionGestion_C_ERR()
  {
    return m_debutConventionGestion_C_ERR;
  }
  
  public void setDebutConventionGestion(Damj pValeur)
  {
    m_debutConventionGestion = pValeur;
  }
  
  public void setDebutConventionGestion_C_ERR(String pValeur_C_ERR)
  {
    m_debutConventionGestion_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getFinConventionGestion()
  {
    return m_finConventionGestion;
  }
  
  public String getFinConventionGestion_C_ERR()
  {
    return m_finConventionGestion_C_ERR;
  }
  
  public void setFinConventionGestion(Damj pValeur)
  {
    m_finConventionGestion = pValeur;
  }
  
  public void setFinConventionGestion_C_ERR(String pValeur_C_ERR)
  {
    m_finConventionGestion_C_ERR = pValeur_C_ERR;
  }
  
  public String getSecteurPublic()
  {
    return m_secteurPublic;
  }
  
  public String getSecteurPublic_C_ERR()
  {
    return m_secteurPublic_C_ERR;
  }
  
  public void setSecteurPublic(String pValeur)
  {
    m_secteurPublic = pValeur;
  }
  
  public void setSecteurPublic_C_ERR(String pValeur_C_ERR)
  {
    m_secteurPublic_C_ERR = pValeur_C_ERR;
  }
  
  public String getTrancheEffectifEntreprise()
  {
    return m_trancheEffectifEntreprise;
  }
  
  public String getTrancheEffectifEntreprise_C_ERR()
  {
    return m_trancheEffectifEntreprise_C_ERR;
  }
  
  public void setTrancheEffectifEntreprise(String pValeur)
  {
    m_trancheEffectifEntreprise = pValeur;
  }
  
  public void setTrancheEffectifEntreprise_C_ERR(String pValeur_C_ERR)
  {
    m_trancheEffectifEntreprise_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDebutAGS()
  {
    return m_debutAGS;
  }
  
  public String getDebutAGS_C_ERR()
  {
    return m_debutAGS_C_ERR;
  }
  
  public void setDebutAGS(Damj pValeur)
  {
    m_debutAGS = pValeur;
  }
  
  public void setDebutAGS_C_ERR(String pValeur_C_ERR)
  {
    m_debutAGS_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getFinAGS()
  {
    return m_finAGS;
  }
  
  public String getFinAGS_C_ERR()
  {
    return m_finAGS_C_ERR;
  }
  
  public void setFinAGS(Damj pValeur)
  {
    m_finAGS = pValeur;
  }
  
  public void setFinAGS_C_ERR(String pValeur_C_ERR)
  {
    m_finAGS_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDebutAdhesionRevocable()
  {
    return m_debutAdhesionRevocable;
  }
  
  public String getDebutAdhesionRevocable_C_ERR()
  {
    return m_debutAdhesionRevocable_C_ERR;
  }
  
  public void setDebutAdhesionRevocable(Damj pValeur)
  {
    m_debutAdhesionRevocable = pValeur;
  }
  
  public void setDebutAdhesionRevocable_C_ERR(String pValeur_C_ERR)
  {
    m_debutAdhesionRevocable_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getFinAdhesionRevocable()
  {
    return m_finAdhesionRevocable;
  }
  
  public String getFinAdhesionRevocable_C_ERR()
  {
    return m_finAdhesionRevocable_C_ERR;
  }
  
  public void setFinAdhesionRevocable(Damj pValeur)
  {
    m_finAdhesionRevocable = pValeur;
  }
  
  public void setFinAdhesionRevocable_C_ERR(String pValeur_C_ERR)
  {
    m_finAdhesionRevocable_C_ERR = pValeur_C_ERR;
  }
  
  public _ListeFluxQuantiteTravailDsn getListeFluxQuantiteTravailDsn()
  {
    return m_listeFluxQuantiteTravailDsn;
  }
  
  public String getListeFluxQuantiteTravailDsn_C_ERR()
  {
    return m_listeFluxQuantiteTravailDsn_C_ERR;
  }
  
  public void setListeFluxQuantiteTravailDsn(_ListeFluxQuantiteTravailDsn pValeur)
  {
    m_listeFluxQuantiteTravailDsn = pValeur;
  }
  
  public void setListeFluxQuantiteTravailDsn_C_ERR(String pValeur_C_ERR)
  {
    m_listeFluxQuantiteTravailDsn_C_ERR = pValeur_C_ERR;
  }
  
  public String getMotifFinContrat()
  {
    return m_motifFinContrat;
  }
  
  public String getMotifFinContrat_C_ERR()
  {
    return m_motifFinContrat_C_ERR;
  }
  
  public void setMotifFinContrat(String pValeur)
  {
    m_motifFinContrat = pValeur;
  }
  
  public void setMotifFinContrat_C_ERR(String pValeur_C_ERR)
  {
    m_motifFinContrat_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDateInitialeFinContrat()
  {
    return m_dateInitialeFinContrat;
  }
  
  public String getDateInitialeFinContrat_C_ERR()
  {
    return m_dateInitialeFinContrat_C_ERR;
  }
  
  public void setDateInitialeFinContrat(Damj pValeur)
  {
    m_dateInitialeFinContrat = pValeur;
  }
  
  public void setDateInitialeFinContrat_C_ERR(String pValeur_C_ERR)
  {
    m_dateInitialeFinContrat_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getIdActiviteDsnPe()
  {
    return m_idActiviteDsnPe;
  }
  
  public String getIdActiviteDsnPe_C_ERR()
  {
    return m_idActiviteDsnPe_C_ERR;
  }
  
  public void setIdActiviteDsnPe(BigDecimal pValeur)
  {
    m_idActiviteDsnPe = pValeur;
  }
  
  public void setIdActiviteDsnPe_C_ERR(String pValeur_C_ERR)
  {
    m_idActiviteDsnPe_C_ERR = pValeur_C_ERR;
  }
  
  public String getSigneDureeAbsence()
  {
    return m_signeDureeAbsence;
  }
  
  public String getSigneDureeAbsence_C_ERR()
  {
    return m_signeDureeAbsence_C_ERR;
  }
  
  public void setSigneDureeAbsence(String pValeur)
  {
    m_signeDureeAbsence = pValeur;
  }
  
  public void setSigneDureeAbsence_C_ERR(String pValeur_C_ERR)
  {
    m_signeDureeAbsence_C_ERR = pValeur_C_ERR;
  }
  
  public _ListeFluxPrimeIndemDsn getListeFluxPrimeIndemDsn()
  {
    return m_listeFluxPrimeIndemDsn;
  }
  
  public String getListeFluxPrimeIndemDsn_C_ERR()
  {
    return m_listeFluxPrimeIndemDsn_C_ERR;
  }
  
  public void setListeFluxPrimeIndemDsn(_ListeFluxPrimeIndemDsn pValeur)
  {
    m_listeFluxPrimeIndemDsn = pValeur;
  }
  
  public void setListeFluxPrimeIndemDsn_C_ERR(String pValeur_C_ERR)
  {
    m_listeFluxPrimeIndemDsn_C_ERR = pValeur_C_ERR;
  }
  
  public String getIdentDeclPri()
  {
    return m_identDeclPri;
  }
  
  public String getIdentDeclPri_C_ERR()
  {
    return m_identDeclPri_C_ERR;
  }
  
  public void setIdentDeclPri(String pValeur)
  {
    m_identDeclPri = pValeur;
  }
  
  public void setIdentDeclPri_C_ERR(String pValeur_C_ERR)
  {
    m_identDeclPri_C_ERR = pValeur_C_ERR;
  }
  
  public String getIdentDeclSec()
  {
    return m_identDeclSec;
  }
  
  public String getIdentDeclSec_C_ERR()
  {
    return m_identDeclSec_C_ERR;
  }
  
  public void setIdentDeclSec(String pValeur)
  {
    m_identDeclSec = pValeur;
  }
  
  public void setIdentDeclSec_C_ERR(String pValeur_C_ERR)
  {
    m_identDeclSec_C_ERR = pValeur_C_ERR;
  }
  
  public String getMotifRecours()
  {
    return m_motifRecours;
  }
  
  public String getMotifRecours_C_ERR()
  {
    return m_motifRecours_C_ERR;
  }
  
  public void setMotifRecours(String pValeur)
  {
    m_motifRecours = pValeur;
  }
  
  public void setMotifRecours_C_ERR(String pValeur_C_ERR)
  {
    m_motifRecours_C_ERR = pValeur_C_ERR;
  }
  
  public String getModaliteDeclarativeFinContrat()
  {
    return m_modaliteDeclarativeFinContrat;
  }
  
  public String getModaliteDeclarativeFinContrat_C_ERR()
  {
    return m_modaliteDeclarativeFinContrat_C_ERR;
  }
  
  public void setModaliteDeclarativeFinContrat(String pValeur)
  {
    m_modaliteDeclarativeFinContrat = pValeur;
  }
  
  public void setModaliteDeclarativeFinContrat_C_ERR(String pValeur_C_ERR)
  {
    m_modaliteDeclarativeFinContrat_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDjtp()
  {
    return m_djtp;
  }
  
  public String getDjtp_C_ERR()
  {
    return m_djtp_C_ERR;
  }
  
  public void setDjtp(Damj pValeur)
  {
    m_djtp = pValeur;
  }
  
  public void setDjtp_C_ERR(String pValeur_C_ERR)
  {
    m_djtp_C_ERR = pValeur_C_ERR;
  }
  
  public Class _getAttributeType(String pPropertyName, String pAttributeName)
  {
    StringBuffer attr = new StringBuffer();
    attr.append("m_");
    if (pPropertyName != null) {
      attr.append(pPropertyName);
    }
    attr.append("_").append(pAttributeName);
    String attrName = attr.toString();
    if ("m__C_ETAT".equals(attrName)) {
      return String.class;
    }
    if ("m__IDENT".equals(attrName)) {
      return String.class;
    }
    if ("m_typeEnreg_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_numNIRCertifie_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_nomDeclare_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_prenomDeclare_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateNaissance_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_contexteEmission_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_natureJustificatif_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_codeMessage_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_numeroVersion_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_numeroSousVersion_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_codeAction_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_idTechnique_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_idRCE_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_siretDeclare_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_refContratEmployeur_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_nbMessagesPrimesIndemnites_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateConnaissanceMensuelle_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateMoisDeclare_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateDebutContrat_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateFinContrat_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_natureContrat_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_typeContrat_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_codeStatutCadre_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_horaireSalarie_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_horaireEntreprise_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_uniteTempsTravail_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_alsaceMoselle_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_regimeSpecialSecuriteSoc_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_typeCaisseCP_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_niveauQualification_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_codeCaisseRetraiteCompl_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_champApplicationEmployeur_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_numConventionGestionEmpPublic_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_etablissementFinancier_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_codeAffectation_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_numInterneEmpPublic_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_statutSalarie_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateAdhesion_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_motifPeriodeInactivite_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateDebutPeriodeInactivite_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateFinPeriodeInactivite_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateDebutPeriodeSalaire_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateFinPeriodeSalaire_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_codePcsEse_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_codeComplementPcsEse_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_signeSalaireBrutAbattu_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_salaireBrutAbattu_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_datePaiement_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dureeAbsence_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_uniteAbsence_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_nomLogiciel_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_versionLogiciel_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_numeroRCI_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_cxass_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_rsin_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_nom_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_prenom_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_peAffi_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_siret_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_emplNumAffi_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_emplRaisonSociale_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_emplNAF_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_emplCommune_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_emplCP_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_idBNEArrco_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_arrcoSigle_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_arrcoRaisonSociale_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_idBNEAgirc_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_agircSigle_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_agircRaisonSociale_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_codeRegimeCrpCtp_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateEffetRegimeCrpCtp_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_emplNumConventionGestion_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_nbSalariesEntreprise_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_nomEmployeur_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_prenomEmployeur_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_categorieJuridique_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_codeRegimeEntreprise_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateCessationEntreprise_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_natureEntreprise_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_numMSAEntreprise_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_debutPeriodeAffiliationEntreprise_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_finPeriodeAffiliationEntreprise_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_debutConventionGestion_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_finConventionGestion_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_secteurPublic_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_trancheEffectifEntreprise_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_debutAGS_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_finAGS_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_debutAdhesionRevocable_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_finAdhesionRevocable_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_listeFluxQuantiteTravailDsn_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_motifFinContrat_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateInitialeFinContrat_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_idActiviteDsnPe_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_signeDureeAbsence_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_listeFluxPrimeIndemDsn_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_identDeclPri_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_identDeclSec_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_motifRecours_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_modaliteDeclarativeFinContrat_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_djtp_C_ERR".equals(attrName)) {
      return String.class;
    }
    return null;
  }
  
  public PropertyInfo _getPropertyInfo(String pElementName)
    throws TechniqueException
  {
    if ("typeEnreg".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("numNIRCertifie".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("nomDeclare".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("prenomDeclare".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("dateNaissance".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("contexteEmission".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("natureJustificatif".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("codeMessage".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("numeroVersion".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("numeroSousVersion".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("codeAction".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("idTechnique".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("idRCE".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("siretDeclare".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("refContratEmployeur".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("nbMessagesPrimesIndemnites".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("dateConnaissanceMensuelle".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("dateMoisDeclare".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("dateDebutContrat".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("dateFinContrat".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("natureContrat".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("typeContrat".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("codeStatutCadre".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("horaireSalarie".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("horaireEntreprise".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("uniteTempsTravail".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("alsaceMoselle".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("regimeSpecialSecuriteSoc".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("typeCaisseCP".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("niveauQualification".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("codeCaisseRetraiteCompl".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("champApplicationEmployeur".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("numConventionGestionEmpPublic".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("etablissementFinancier".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("codeAffectation".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("numInterneEmpPublic".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("statutSalarie".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("dateAdhesion".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("motifPeriodeInactivite".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("dateDebutPeriodeInactivite".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("dateFinPeriodeInactivite".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("dateDebutPeriodeSalaire".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("dateFinPeriodeSalaire".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("codePcsEse".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("codeComplementPcsEse".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("signeSalaireBrutAbattu".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("salaireBrutAbattu".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("datePaiement".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("dureeAbsence".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("uniteAbsence".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("nomLogiciel".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("versionLogiciel".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("numeroRCI".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("cxass".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("rsin".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("nom".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("prenom".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("peAffi".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("siret".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("emplNumAffi".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("emplRaisonSociale".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("emplNAF".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("emplCommune".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("emplCP".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("idBNEArrco".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("arrcoSigle".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("arrcoRaisonSociale".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("idBNEAgirc".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("agircSigle".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("agircRaisonSociale".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("codeRegimeCrpCtp".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("dateEffetRegimeCrpCtp".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("emplNumConventionGestion".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("nbSalariesEntreprise".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("nomEmployeur".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("prenomEmployeur".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("categorieJuridique".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("codeRegimeEntreprise".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("dateCessationEntreprise".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("natureEntreprise".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("numMSAEntreprise".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("debutPeriodeAffiliationEntreprise".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("finPeriodeAffiliationEntreprise".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("debutConventionGestion".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("finConventionGestion".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("secteurPublic".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("trancheEffectifEntreprise".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("debutAGS".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("finAGS".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("debutAdhesionRevocable".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("finAdhesionRevocable".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("ListeFluxQuantiteTravailDsn".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, _ListeFluxQuantiteTravailDsn.class, false);
      return info;
    }
    if ("motifFinContrat".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("dateInitialeFinContrat".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("idActiviteDsnPe".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("signeDureeAbsence".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("ListeFluxPrimeIndemDsn".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, _ListeFluxPrimeIndemDsn.class, false);
      return info;
    }
    if ("identDeclPri".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("identDeclSec".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("motifRecours".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("modaliteDeclarativeFinContrat".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("djtp".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    return null;
  }
  
  public int _getPropertyLength(String pElementName)
  {
    if ("typeEnreg".equals(pElementName)) {
      return 2;
    }
    if ("numNIRCertifie".equals(pElementName)) {
      return 13;
    }
    if ("nomDeclare".equals(pElementName)) {
      return 80;
    }
    if ("prenomDeclare".equals(pElementName)) {
      return 40;
    }
    if ("dateNaissance".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("contexteEmission".equals(pElementName)) {
      return 2;
    }
    if ("natureJustificatif".equals(pElementName)) {
      return 1;
    }
    if ("codeMessage".equals(pElementName)) {
      return 3;
    }
    if ("numeroVersion".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("numeroSousVersion".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("codeAction".equals(pElementName)) {
      return 1;
    }
    if ("idTechnique".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("idRCE".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("siretDeclare".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("refContratEmployeur".equals(pElementName)) {
      return 20;
    }
    if ("nbMessagesPrimesIndemnites".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("dateConnaissanceMensuelle".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("dateMoisDeclare".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("dateDebutContrat".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("dateFinContrat".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("natureContrat".equals(pElementName)) {
      return 2;
    }
    if ("typeContrat".equals(pElementName)) {
      return 2;
    }
    if ("codeStatutCadre".equals(pElementName)) {
      return 2;
    }
    if ("horaireSalarie".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("horaireEntreprise".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("uniteTempsTravail".equals(pElementName)) {
      return 2;
    }
    if ("alsaceMoselle".equals(pElementName)) {
      return 2;
    }
    if ("regimeSpecialSecuriteSoc".equals(pElementName)) {
      return 3;
    }
    if ("typeCaisseCP".equals(pElementName)) {
      return 2;
    }
    if ("niveauQualification".equals(pElementName)) {
      return 2;
    }
    if ("codeCaisseRetraiteCompl".equals(pElementName)) {
      return 8;
    }
    if ("champApplicationEmployeur".equals(pElementName)) {
      return 2;
    }
    if ("numConventionGestionEmpPublic".equals(pElementName)) {
      return 7;
    }
    if ("etablissementFinancier".equals(pElementName)) {
      return 3;
    }
    if ("codeAffectation".equals(pElementName)) {
      return 6;
    }
    if ("numInterneEmpPublic".equals(pElementName)) {
      return 30;
    }
    if ("statutSalarie".equals(pElementName)) {
      return 3;
    }
    if ("dateAdhesion".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("motifPeriodeInactivite".equals(pElementName)) {
      return 5;
    }
    if ("dateDebutPeriodeInactivite".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("dateFinPeriodeInactivite".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("dateDebutPeriodeSalaire".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("dateFinPeriodeSalaire".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("codePcsEse".equals(pElementName)) {
      return 4;
    }
    if ("codeComplementPcsEse".equals(pElementName)) {
      return 6;
    }
    if ("signeSalaireBrutAbattu".equals(pElementName)) {
      return 1;
    }
    if ("salaireBrutAbattu".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("datePaiement".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("dureeAbsence".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("uniteAbsence".equals(pElementName)) {
      return 2;
    }
    if ("nomLogiciel".equals(pElementName)) {
      return 20;
    }
    if ("versionLogiciel".equals(pElementName)) {
      return 10;
    }
    if ("numeroRCI".equals(pElementName)) {
      return 10;
    }
    if ("cxass".equals(pElementName)) {
      return 2;
    }
    if ("rsin".equals(pElementName)) {
      return 8;
    }
    if ("nom".equals(pElementName)) {
      return 80;
    }
    if ("prenom".equals(pElementName)) {
      return 40;
    }
    if ("peAffi".equals(pElementName)) {
      return 2;
    }
    if ("siret".equals(pElementName)) {
      return 14;
    }
    if ("emplNumAffi".equals(pElementName)) {
      return 14;
    }
    if ("emplRaisonSociale".equals(pElementName)) {
      return 60;
    }
    if ("emplNAF".equals(pElementName)) {
      return 5;
    }
    if ("emplCommune".equals(pElementName)) {
      return 50;
    }
    if ("emplCP".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("idBNEArrco".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("arrcoSigle".equals(pElementName)) {
      return 10;
    }
    if ("arrcoRaisonSociale".equals(pElementName)) {
      return 40;
    }
    if ("idBNEAgirc".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("agircSigle".equals(pElementName)) {
      return 10;
    }
    if ("agircRaisonSociale".equals(pElementName)) {
      return 40;
    }
    if ("codeRegimeCrpCtp".equals(pElementName)) {
      return 5;
    }
    if ("dateEffetRegimeCrpCtp".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("emplNumConventionGestion".equals(pElementName)) {
      return 10;
    }
    if ("nbSalariesEntreprise".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("nomEmployeur".equals(pElementName)) {
      return 80;
    }
    if ("prenomEmployeur".equals(pElementName)) {
      return 40;
    }
    if ("categorieJuridique".equals(pElementName)) {
      return 4;
    }
    if ("codeRegimeEntreprise".equals(pElementName)) {
      return 2;
    }
    if ("dateCessationEntreprise".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("natureEntreprise".equals(pElementName)) {
      return 1;
    }
    if ("numMSAEntreprise".equals(pElementName)) {
      return 20;
    }
    if ("debutPeriodeAffiliationEntreprise".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("finPeriodeAffiliationEntreprise".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("debutConventionGestion".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("finConventionGestion".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("secteurPublic".equals(pElementName)) {
      return 1;
    }
    if ("trancheEffectifEntreprise".equals(pElementName)) {
      return 2;
    }
    if ("debutAGS".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("finAGS".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("debutAdhesionRevocable".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("finAdhesionRevocable".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("ListeFluxQuantiteTravailDsn".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("motifFinContrat".equals(pElementName)) {
      return 3;
    }
    if ("dateInitialeFinContrat".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("idActiviteDsnPe".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("signeDureeAbsence".equals(pElementName)) {
      return 1;
    }
    if ("ListeFluxPrimeIndemDsn".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("identDeclPri".equals(pElementName)) {
      return 50;
    }
    if ("identDeclSec".equals(pElementName)) {
      return 50;
    }
    if ("motifRecours".equals(pElementName)) {
      return 2;
    }
    if ("modaliteDeclarativeFinContrat".equals(pElementName)) {
      return 2;
    }
    if ("djtp".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    return -1;
  }
  
  public Object _getProperty(String pName)
    throws Exception
  {
    if ("typeEnreg".equals(pName)) {
      return m_typeEnreg;
    }
    if ("numNIRCertifie".equals(pName)) {
      return m_numNIRCertifie;
    }
    if ("nomDeclare".equals(pName)) {
      return m_nomDeclare;
    }
    if ("prenomDeclare".equals(pName)) {
      return m_prenomDeclare;
    }
    if ("dateNaissance".equals(pName)) {
      return m_dateNaissance;
    }
    if ("contexteEmission".equals(pName)) {
      return m_contexteEmission;
    }
    if ("natureJustificatif".equals(pName)) {
      return m_natureJustificatif;
    }
    if ("codeMessage".equals(pName)) {
      return m_codeMessage;
    }
    if ("numeroVersion".equals(pName)) {
      return m_numeroVersion;
    }
    if ("numeroSousVersion".equals(pName)) {
      return m_numeroSousVersion;
    }
    if ("codeAction".equals(pName)) {
      return m_codeAction;
    }
    if ("idTechnique".equals(pName)) {
      return m_idTechnique;
    }
    if ("idRCE".equals(pName)) {
      return m_idRCE;
    }
    if ("siretDeclare".equals(pName)) {
      return m_siretDeclare;
    }
    if ("refContratEmployeur".equals(pName)) {
      return m_refContratEmployeur;
    }
    if ("nbMessagesPrimesIndemnites".equals(pName)) {
      return m_nbMessagesPrimesIndemnites;
    }
    if ("dateConnaissanceMensuelle".equals(pName)) {
      return m_dateConnaissanceMensuelle;
    }
    if ("dateMoisDeclare".equals(pName)) {
      return m_dateMoisDeclare;
    }
    if ("dateDebutContrat".equals(pName)) {
      return m_dateDebutContrat;
    }
    if ("dateFinContrat".equals(pName)) {
      return m_dateFinContrat;
    }
    if ("natureContrat".equals(pName)) {
      return m_natureContrat;
    }
    if ("typeContrat".equals(pName)) {
      return m_typeContrat;
    }
    if ("codeStatutCadre".equals(pName)) {
      return m_codeStatutCadre;
    }
    if ("horaireSalarie".equals(pName)) {
      return m_horaireSalarie;
    }
    if ("horaireEntreprise".equals(pName)) {
      return m_horaireEntreprise;
    }
    if ("uniteTempsTravail".equals(pName)) {
      return m_uniteTempsTravail;
    }
    if ("alsaceMoselle".equals(pName)) {
      return m_alsaceMoselle;
    }
    if ("regimeSpecialSecuriteSoc".equals(pName)) {
      return m_regimeSpecialSecuriteSoc;
    }
    if ("typeCaisseCP".equals(pName)) {
      return m_typeCaisseCP;
    }
    if ("niveauQualification".equals(pName)) {
      return m_niveauQualification;
    }
    if ("codeCaisseRetraiteCompl".equals(pName)) {
      return m_codeCaisseRetraiteCompl;
    }
    if ("champApplicationEmployeur".equals(pName)) {
      return m_champApplicationEmployeur;
    }
    if ("numConventionGestionEmpPublic".equals(pName)) {
      return m_numConventionGestionEmpPublic;
    }
    if ("etablissementFinancier".equals(pName)) {
      return m_etablissementFinancier;
    }
    if ("codeAffectation".equals(pName)) {
      return m_codeAffectation;
    }
    if ("numInterneEmpPublic".equals(pName)) {
      return m_numInterneEmpPublic;
    }
    if ("statutSalarie".equals(pName)) {
      return m_statutSalarie;
    }
    if ("dateAdhesion".equals(pName)) {
      return m_dateAdhesion;
    }
    if ("motifPeriodeInactivite".equals(pName)) {
      return m_motifPeriodeInactivite;
    }
    if ("dateDebutPeriodeInactivite".equals(pName)) {
      return m_dateDebutPeriodeInactivite;
    }
    if ("dateFinPeriodeInactivite".equals(pName)) {
      return m_dateFinPeriodeInactivite;
    }
    if ("dateDebutPeriodeSalaire".equals(pName)) {
      return m_dateDebutPeriodeSalaire;
    }
    if ("dateFinPeriodeSalaire".equals(pName)) {
      return m_dateFinPeriodeSalaire;
    }
    if ("codePcsEse".equals(pName)) {
      return m_codePcsEse;
    }
    if ("codeComplementPcsEse".equals(pName)) {
      return m_codeComplementPcsEse;
    }
    if ("signeSalaireBrutAbattu".equals(pName)) {
      return m_signeSalaireBrutAbattu;
    }
    if ("salaireBrutAbattu".equals(pName)) {
      return m_salaireBrutAbattu;
    }
    if ("datePaiement".equals(pName)) {
      return m_datePaiement;
    }
    if ("dureeAbsence".equals(pName)) {
      return m_dureeAbsence;
    }
    if ("uniteAbsence".equals(pName)) {
      return m_uniteAbsence;
    }
    if ("nomLogiciel".equals(pName)) {
      return m_nomLogiciel;
    }
    if ("versionLogiciel".equals(pName)) {
      return m_versionLogiciel;
    }
    if ("numeroRCI".equals(pName)) {
      return m_numeroRCI;
    }
    if ("cxass".equals(pName)) {
      return m_cxass;
    }
    if ("rsin".equals(pName)) {
      return m_rsin;
    }
    if ("nom".equals(pName)) {
      return m_nom;
    }
    if ("prenom".equals(pName)) {
      return m_prenom;
    }
    if ("peAffi".equals(pName)) {
      return m_peAffi;
    }
    if ("siret".equals(pName)) {
      return m_siret;
    }
    if ("emplNumAffi".equals(pName)) {
      return m_emplNumAffi;
    }
    if ("emplRaisonSociale".equals(pName)) {
      return m_emplRaisonSociale;
    }
    if ("emplNAF".equals(pName)) {
      return m_emplNAF;
    }
    if ("emplCommune".equals(pName)) {
      return m_emplCommune;
    }
    if ("emplCP".equals(pName)) {
      return m_emplCP;
    }
    if ("idBNEArrco".equals(pName)) {
      return m_idBNEArrco;
    }
    if ("arrcoSigle".equals(pName)) {
      return m_arrcoSigle;
    }
    if ("arrcoRaisonSociale".equals(pName)) {
      return m_arrcoRaisonSociale;
    }
    if ("idBNEAgirc".equals(pName)) {
      return m_idBNEAgirc;
    }
    if ("agircSigle".equals(pName)) {
      return m_agircSigle;
    }
    if ("agircRaisonSociale".equals(pName)) {
      return m_agircRaisonSociale;
    }
    if ("codeRegimeCrpCtp".equals(pName)) {
      return m_codeRegimeCrpCtp;
    }
    if ("dateEffetRegimeCrpCtp".equals(pName)) {
      return m_dateEffetRegimeCrpCtp;
    }
    if ("emplNumConventionGestion".equals(pName)) {
      return m_emplNumConventionGestion;
    }
    if ("nbSalariesEntreprise".equals(pName)) {
      return m_nbSalariesEntreprise;
    }
    if ("nomEmployeur".equals(pName)) {
      return m_nomEmployeur;
    }
    if ("prenomEmployeur".equals(pName)) {
      return m_prenomEmployeur;
    }
    if ("categorieJuridique".equals(pName)) {
      return m_categorieJuridique;
    }
    if ("codeRegimeEntreprise".equals(pName)) {
      return m_codeRegimeEntreprise;
    }
    if ("dateCessationEntreprise".equals(pName)) {
      return m_dateCessationEntreprise;
    }
    if ("natureEntreprise".equals(pName)) {
      return m_natureEntreprise;
    }
    if ("numMSAEntreprise".equals(pName)) {
      return m_numMSAEntreprise;
    }
    if ("debutPeriodeAffiliationEntreprise".equals(pName)) {
      return m_debutPeriodeAffiliationEntreprise;
    }
    if ("finPeriodeAffiliationEntreprise".equals(pName)) {
      return m_finPeriodeAffiliationEntreprise;
    }
    if ("debutConventionGestion".equals(pName)) {
      return m_debutConventionGestion;
    }
    if ("finConventionGestion".equals(pName)) {
      return m_finConventionGestion;
    }
    if ("secteurPublic".equals(pName)) {
      return m_secteurPublic;
    }
    if ("trancheEffectifEntreprise".equals(pName)) {
      return m_trancheEffectifEntreprise;
    }
    if ("debutAGS".equals(pName)) {
      return m_debutAGS;
    }
    if ("finAGS".equals(pName)) {
      return m_finAGS;
    }
    if ("debutAdhesionRevocable".equals(pName)) {
      return m_debutAdhesionRevocable;
    }
    if ("finAdhesionRevocable".equals(pName)) {
      return m_finAdhesionRevocable;
    }
    if ("ListeFluxQuantiteTravailDsn".equals(pName)) {
      return m_listeFluxQuantiteTravailDsn;
    }
    if ("motifFinContrat".equals(pName)) {
      return m_motifFinContrat;
    }
    if ("dateInitialeFinContrat".equals(pName)) {
      return m_dateInitialeFinContrat;
    }
    if ("idActiviteDsnPe".equals(pName)) {
      return m_idActiviteDsnPe;
    }
    if ("signeDureeAbsence".equals(pName)) {
      return m_signeDureeAbsence;
    }
    if ("ListeFluxPrimeIndemDsn".equals(pName)) {
      return m_listeFluxPrimeIndemDsn;
    }
    if ("identDeclPri".equals(pName)) {
      return m_identDeclPri;
    }
    if ("identDeclSec".equals(pName)) {
      return m_identDeclSec;
    }
    if ("motifRecours".equals(pName)) {
      return m_motifRecours;
    }
    if ("modaliteDeclarativeFinContrat".equals(pName)) {
      return m_modaliteDeclarativeFinContrat;
    }
    if ("djtp".equals(pName)) {
      return m_djtp;
    }
    return null;
  }
  
  public Iterator _getPropertyNames()
    throws Exception
  {
    ArrayList liste = new ArrayList();
    liste.add("typeEnreg");
    liste.add("numNIRCertifie");
    liste.add("nomDeclare");
    liste.add("prenomDeclare");
    liste.add("dateNaissance");
    liste.add("contexteEmission");
    liste.add("natureJustificatif");
    liste.add("codeMessage");
    liste.add("numeroVersion");
    liste.add("numeroSousVersion");
    liste.add("codeAction");
    liste.add("idTechnique");
    liste.add("idRCE");
    liste.add("siretDeclare");
    liste.add("refContratEmployeur");
    liste.add("nbMessagesPrimesIndemnites");
    liste.add("dateConnaissanceMensuelle");
    liste.add("dateMoisDeclare");
    liste.add("dateDebutContrat");
    liste.add("dateFinContrat");
    liste.add("natureContrat");
    liste.add("typeContrat");
    liste.add("codeStatutCadre");
    liste.add("horaireSalarie");
    liste.add("horaireEntreprise");
    liste.add("uniteTempsTravail");
    liste.add("alsaceMoselle");
    liste.add("regimeSpecialSecuriteSoc");
    liste.add("typeCaisseCP");
    liste.add("niveauQualification");
    liste.add("codeCaisseRetraiteCompl");
    liste.add("champApplicationEmployeur");
    liste.add("numConventionGestionEmpPublic");
    liste.add("etablissementFinancier");
    liste.add("codeAffectation");
    liste.add("numInterneEmpPublic");
    liste.add("statutSalarie");
    liste.add("dateAdhesion");
    liste.add("motifPeriodeInactivite");
    liste.add("dateDebutPeriodeInactivite");
    liste.add("dateFinPeriodeInactivite");
    liste.add("dateDebutPeriodeSalaire");
    liste.add("dateFinPeriodeSalaire");
    liste.add("codePcsEse");
    liste.add("codeComplementPcsEse");
    liste.add("signeSalaireBrutAbattu");
    liste.add("salaireBrutAbattu");
    liste.add("datePaiement");
    liste.add("dureeAbsence");
    liste.add("uniteAbsence");
    liste.add("nomLogiciel");
    liste.add("versionLogiciel");
    liste.add("numeroRCI");
    liste.add("cxass");
    liste.add("rsin");
    liste.add("nom");
    liste.add("prenom");
    liste.add("peAffi");
    liste.add("siret");
    liste.add("emplNumAffi");
    liste.add("emplRaisonSociale");
    liste.add("emplNAF");
    liste.add("emplCommune");
    liste.add("emplCP");
    liste.add("idBNEArrco");
    liste.add("arrcoSigle");
    liste.add("arrcoRaisonSociale");
    liste.add("idBNEAgirc");
    liste.add("agircSigle");
    liste.add("agircRaisonSociale");
    liste.add("codeRegimeCrpCtp");
    liste.add("dateEffetRegimeCrpCtp");
    liste.add("emplNumConventionGestion");
    liste.add("nbSalariesEntreprise");
    liste.add("nomEmployeur");
    liste.add("prenomEmployeur");
    liste.add("categorieJuridique");
    liste.add("codeRegimeEntreprise");
    liste.add("dateCessationEntreprise");
    liste.add("natureEntreprise");
    liste.add("numMSAEntreprise");
    liste.add("debutPeriodeAffiliationEntreprise");
    liste.add("finPeriodeAffiliationEntreprise");
    liste.add("debutConventionGestion");
    liste.add("finConventionGestion");
    liste.add("secteurPublic");
    liste.add("trancheEffectifEntreprise");
    liste.add("debutAGS");
    liste.add("finAGS");
    liste.add("debutAdhesionRevocable");
    liste.add("finAdhesionRevocable");
    liste.add("ListeFluxQuantiteTravailDsn");
    liste.add("motifFinContrat");
    liste.add("dateInitialeFinContrat");
    liste.add("idActiviteDsnPe");
    liste.add("signeDureeAbsence");
    liste.add("ListeFluxPrimeIndemDsn");
    liste.add("identDeclPri");
    liste.add("identDeclSec");
    liste.add("motifRecours");
    liste.add("modaliteDeclarativeFinContrat");
    liste.add("djtp");
    return liste.iterator();
  }
  
  public ArrayList _getPropertyNames(ArrayList pListe)
    throws Exception
  {
    pListe.add("typeEnreg");
    pListe.add("numNIRCertifie");
    pListe.add("nomDeclare");
    pListe.add("prenomDeclare");
    pListe.add("dateNaissance");
    pListe.add("contexteEmission");
    pListe.add("natureJustificatif");
    pListe.add("codeMessage");
    pListe.add("numeroVersion");
    pListe.add("numeroSousVersion");
    pListe.add("codeAction");
    pListe.add("idTechnique");
    pListe.add("idRCE");
    pListe.add("siretDeclare");
    pListe.add("refContratEmployeur");
    pListe.add("nbMessagesPrimesIndemnites");
    pListe.add("dateConnaissanceMensuelle");
    pListe.add("dateMoisDeclare");
    pListe.add("dateDebutContrat");
    pListe.add("dateFinContrat");
    pListe.add("natureContrat");
    pListe.add("typeContrat");
    pListe.add("codeStatutCadre");
    pListe.add("horaireSalarie");
    pListe.add("horaireEntreprise");
    pListe.add("uniteTempsTravail");
    pListe.add("alsaceMoselle");
    pListe.add("regimeSpecialSecuriteSoc");
    pListe.add("typeCaisseCP");
    pListe.add("niveauQualification");
    pListe.add("codeCaisseRetraiteCompl");
    pListe.add("champApplicationEmployeur");
    pListe.add("numConventionGestionEmpPublic");
    pListe.add("etablissementFinancier");
    pListe.add("codeAffectation");
    pListe.add("numInterneEmpPublic");
    pListe.add("statutSalarie");
    pListe.add("dateAdhesion");
    pListe.add("motifPeriodeInactivite");
    pListe.add("dateDebutPeriodeInactivite");
    pListe.add("dateFinPeriodeInactivite");
    pListe.add("dateDebutPeriodeSalaire");
    pListe.add("dateFinPeriodeSalaire");
    pListe.add("codePcsEse");
    pListe.add("codeComplementPcsEse");
    pListe.add("signeSalaireBrutAbattu");
    pListe.add("salaireBrutAbattu");
    pListe.add("datePaiement");
    pListe.add("dureeAbsence");
    pListe.add("uniteAbsence");
    pListe.add("nomLogiciel");
    pListe.add("versionLogiciel");
    pListe.add("numeroRCI");
    pListe.add("cxass");
    pListe.add("rsin");
    pListe.add("nom");
    pListe.add("prenom");
    pListe.add("peAffi");
    pListe.add("siret");
    pListe.add("emplNumAffi");
    pListe.add("emplRaisonSociale");
    pListe.add("emplNAF");
    pListe.add("emplCommune");
    pListe.add("emplCP");
    pListe.add("idBNEArrco");
    pListe.add("arrcoSigle");
    pListe.add("arrcoRaisonSociale");
    pListe.add("idBNEAgirc");
    pListe.add("agircSigle");
    pListe.add("agircRaisonSociale");
    pListe.add("codeRegimeCrpCtp");
    pListe.add("dateEffetRegimeCrpCtp");
    pListe.add("emplNumConventionGestion");
    pListe.add("nbSalariesEntreprise");
    pListe.add("nomEmployeur");
    pListe.add("prenomEmployeur");
    pListe.add("categorieJuridique");
    pListe.add("codeRegimeEntreprise");
    pListe.add("dateCessationEntreprise");
    pListe.add("natureEntreprise");
    pListe.add("numMSAEntreprise");
    pListe.add("debutPeriodeAffiliationEntreprise");
    pListe.add("finPeriodeAffiliationEntreprise");
    pListe.add("debutConventionGestion");
    pListe.add("finConventionGestion");
    pListe.add("secteurPublic");
    pListe.add("trancheEffectifEntreprise");
    pListe.add("debutAGS");
    pListe.add("finAGS");
    pListe.add("debutAdhesionRevocable");
    pListe.add("finAdhesionRevocable");
    pListe.add("ListeFluxQuantiteTravailDsn");
    pListe.add("motifFinContrat");
    pListe.add("dateInitialeFinContrat");
    pListe.add("idActiviteDsnPe");
    pListe.add("signeDureeAbsence");
    pListe.add("ListeFluxPrimeIndemDsn");
    pListe.add("identDeclPri");
    pListe.add("identDeclSec");
    pListe.add("motifRecours");
    pListe.add("modaliteDeclarativeFinContrat");
    pListe.add("djtp");
    return pListe;
  }
  
  public void _setProperty(String pName, Object pValeur)
    throws Exception
  {
    if ("typeEnreg".equals(pName)) {
      m_typeEnreg = ((String)pValeur);
    }
    if ("numNIRCertifie".equals(pName)) {
      m_numNIRCertifie = ((String)pValeur);
    }
    if ("nomDeclare".equals(pName)) {
      m_nomDeclare = ((String)pValeur);
    }
    if ("prenomDeclare".equals(pName)) {
      m_prenomDeclare = ((String)pValeur);
    }
    if ("dateNaissance".equals(pName)) {
      m_dateNaissance = ((Damj)pValeur);
    }
    if ("contexteEmission".equals(pName)) {
      m_contexteEmission = ((String)pValeur);
    }
    if ("natureJustificatif".equals(pName)) {
      m_natureJustificatif = ((String)pValeur);
    }
    if ("codeMessage".equals(pName)) {
      m_codeMessage = ((String)pValeur);
    }
    if ("numeroVersion".equals(pName)) {
      m_numeroVersion = ((BigDecimal)pValeur);
    }
    if ("numeroSousVersion".equals(pName)) {
      m_numeroSousVersion = ((BigDecimal)pValeur);
    }
    if ("codeAction".equals(pName)) {
      m_codeAction = ((String)pValeur);
    }
    if ("idTechnique".equals(pName)) {
      m_idTechnique = ((BigDecimal)pValeur);
    }
    if ("idRCE".equals(pName)) {
      m_idRCE = ((BigDecimal)pValeur);
    }
    if ("siretDeclare".equals(pName)) {
      m_siretDeclare = ((BigDecimal)pValeur);
    }
    if ("refContratEmployeur".equals(pName)) {
      m_refContratEmployeur = ((String)pValeur);
    }
    if ("nbMessagesPrimesIndemnites".equals(pName)) {
      m_nbMessagesPrimesIndemnites = ((BigDecimal)pValeur);
    }
    if ("dateConnaissanceMensuelle".equals(pName)) {
      m_dateConnaissanceMensuelle = ((Damj)pValeur);
    }
    if ("dateMoisDeclare".equals(pName)) {
      m_dateMoisDeclare = ((Damj)pValeur);
    }
    if ("dateDebutContrat".equals(pName)) {
      m_dateDebutContrat = ((Damj)pValeur);
    }
    if ("dateFinContrat".equals(pName)) {
      m_dateFinContrat = ((Damj)pValeur);
    }
    if ("natureContrat".equals(pName)) {
      m_natureContrat = ((String)pValeur);
    }
    if ("typeContrat".equals(pName)) {
      m_typeContrat = ((String)pValeur);
    }
    if ("codeStatutCadre".equals(pName)) {
      m_codeStatutCadre = ((String)pValeur);
    }
    if ("horaireSalarie".equals(pName)) {
      m_horaireSalarie = ((BigDecimal)pValeur);
    }
    if ("horaireEntreprise".equals(pName)) {
      m_horaireEntreprise = ((BigDecimal)pValeur);
    }
    if ("uniteTempsTravail".equals(pName)) {
      m_uniteTempsTravail = ((String)pValeur);
    }
    if ("alsaceMoselle".equals(pName)) {
      m_alsaceMoselle = ((String)pValeur);
    }
    if ("regimeSpecialSecuriteSoc".equals(pName)) {
      m_regimeSpecialSecuriteSoc = ((String)pValeur);
    }
    if ("typeCaisseCP".equals(pName)) {
      m_typeCaisseCP = ((String)pValeur);
    }
    if ("niveauQualification".equals(pName)) {
      m_niveauQualification = ((String)pValeur);
    }
    if ("codeCaisseRetraiteCompl".equals(pName)) {
      m_codeCaisseRetraiteCompl = ((String)pValeur);
    }
    if ("champApplicationEmployeur".equals(pName)) {
      m_champApplicationEmployeur = ((String)pValeur);
    }
    if ("numConventionGestionEmpPublic".equals(pName)) {
      m_numConventionGestionEmpPublic = ((String)pValeur);
    }
    if ("etablissementFinancier".equals(pName)) {
      m_etablissementFinancier = ((String)pValeur);
    }
    if ("codeAffectation".equals(pName)) {
      m_codeAffectation = ((String)pValeur);
    }
    if ("numInterneEmpPublic".equals(pName)) {
      m_numInterneEmpPublic = ((String)pValeur);
    }
    if ("statutSalarie".equals(pName)) {
      m_statutSalarie = ((String)pValeur);
    }
    if ("dateAdhesion".equals(pName)) {
      m_dateAdhesion = ((Damj)pValeur);
    }
    if ("motifPeriodeInactivite".equals(pName)) {
      m_motifPeriodeInactivite = ((String)pValeur);
    }
    if ("dateDebutPeriodeInactivite".equals(pName)) {
      m_dateDebutPeriodeInactivite = ((Damj)pValeur);
    }
    if ("dateFinPeriodeInactivite".equals(pName)) {
      m_dateFinPeriodeInactivite = ((Damj)pValeur);
    }
    if ("dateDebutPeriodeSalaire".equals(pName)) {
      m_dateDebutPeriodeSalaire = ((Damj)pValeur);
    }
    if ("dateFinPeriodeSalaire".equals(pName)) {
      m_dateFinPeriodeSalaire = ((Damj)pValeur);
    }
    if ("codePcsEse".equals(pName)) {
      m_codePcsEse = ((String)pValeur);
    }
    if ("codeComplementPcsEse".equals(pName)) {
      m_codeComplementPcsEse = ((String)pValeur);
    }
    if ("signeSalaireBrutAbattu".equals(pName)) {
      m_signeSalaireBrutAbattu = ((String)pValeur);
    }
    if ("salaireBrutAbattu".equals(pName)) {
      m_salaireBrutAbattu = ((BigDecimal)pValeur);
    }
    if ("datePaiement".equals(pName)) {
      m_datePaiement = ((Damj)pValeur);
    }
    if ("dureeAbsence".equals(pName)) {
      m_dureeAbsence = ((BigDecimal)pValeur);
    }
    if ("uniteAbsence".equals(pName)) {
      m_uniteAbsence = ((String)pValeur);
    }
    if ("nomLogiciel".equals(pName)) {
      m_nomLogiciel = ((String)pValeur);
    }
    if ("versionLogiciel".equals(pName)) {
      m_versionLogiciel = ((String)pValeur);
    }
    if ("numeroRCI".equals(pName)) {
      m_numeroRCI = ((String)pValeur);
    }
    if ("cxass".equals(pName)) {
      m_cxass = ((String)pValeur);
    }
    if ("rsin".equals(pName)) {
      m_rsin = ((String)pValeur);
    }
    if ("nom".equals(pName)) {
      m_nom = ((String)pValeur);
    }
    if ("prenom".equals(pName)) {
      m_prenom = ((String)pValeur);
    }
    if ("peAffi".equals(pName)) {
      m_peAffi = ((String)pValeur);
    }
    if ("siret".equals(pName)) {
      m_siret = ((String)pValeur);
    }
    if ("emplNumAffi".equals(pName)) {
      m_emplNumAffi = ((String)pValeur);
    }
    if ("emplRaisonSociale".equals(pName)) {
      m_emplRaisonSociale = ((String)pValeur);
    }
    if ("emplNAF".equals(pName)) {
      m_emplNAF = ((String)pValeur);
    }
    if ("emplCommune".equals(pName)) {
      m_emplCommune = ((String)pValeur);
    }
    if ("emplCP".equals(pName)) {
      m_emplCP = ((BigDecimal)pValeur);
    }
    if ("idBNEArrco".equals(pName)) {
      m_idBNEArrco = ((BigDecimal)pValeur);
    }
    if ("arrcoSigle".equals(pName)) {
      m_arrcoSigle = ((String)pValeur);
    }
    if ("arrcoRaisonSociale".equals(pName)) {
      m_arrcoRaisonSociale = ((String)pValeur);
    }
    if ("idBNEAgirc".equals(pName)) {
      m_idBNEAgirc = ((BigDecimal)pValeur);
    }
    if ("agircSigle".equals(pName)) {
      m_agircSigle = ((String)pValeur);
    }
    if ("agircRaisonSociale".equals(pName)) {
      m_agircRaisonSociale = ((String)pValeur);
    }
    if ("codeRegimeCrpCtp".equals(pName)) {
      m_codeRegimeCrpCtp = ((String)pValeur);
    }
    if ("dateEffetRegimeCrpCtp".equals(pName)) {
      m_dateEffetRegimeCrpCtp = ((Damj)pValeur);
    }
    if ("emplNumConventionGestion".equals(pName)) {
      m_emplNumConventionGestion = ((String)pValeur);
    }
    if ("nbSalariesEntreprise".equals(pName)) {
      m_nbSalariesEntreprise = ((BigDecimal)pValeur);
    }
    if ("nomEmployeur".equals(pName)) {
      m_nomEmployeur = ((String)pValeur);
    }
    if ("prenomEmployeur".equals(pName)) {
      m_prenomEmployeur = ((String)pValeur);
    }
    if ("categorieJuridique".equals(pName)) {
      m_categorieJuridique = ((String)pValeur);
    }
    if ("codeRegimeEntreprise".equals(pName)) {
      m_codeRegimeEntreprise = ((String)pValeur);
    }
    if ("dateCessationEntreprise".equals(pName)) {
      m_dateCessationEntreprise = ((Damj)pValeur);
    }
    if ("natureEntreprise".equals(pName)) {
      m_natureEntreprise = ((String)pValeur);
    }
    if ("numMSAEntreprise".equals(pName)) {
      m_numMSAEntreprise = ((String)pValeur);
    }
    if ("debutPeriodeAffiliationEntreprise".equals(pName)) {
      m_debutPeriodeAffiliationEntreprise = ((Damj)pValeur);
    }
    if ("finPeriodeAffiliationEntreprise".equals(pName)) {
      m_finPeriodeAffiliationEntreprise = ((Damj)pValeur);
    }
    if ("debutConventionGestion".equals(pName)) {
      m_debutConventionGestion = ((Damj)pValeur);
    }
    if ("finConventionGestion".equals(pName)) {
      m_finConventionGestion = ((Damj)pValeur);
    }
    if ("secteurPublic".equals(pName)) {
      m_secteurPublic = ((String)pValeur);
    }
    if ("trancheEffectifEntreprise".equals(pName)) {
      m_trancheEffectifEntreprise = ((String)pValeur);
    }
    if ("debutAGS".equals(pName)) {
      m_debutAGS = ((Damj)pValeur);
    }
    if ("finAGS".equals(pName)) {
      m_finAGS = ((Damj)pValeur);
    }
    if ("debutAdhesionRevocable".equals(pName)) {
      m_debutAdhesionRevocable = ((Damj)pValeur);
    }
    if ("finAdhesionRevocable".equals(pName)) {
      m_finAdhesionRevocable = ((Damj)pValeur);
    }
    if ("ListeFluxQuantiteTravailDsn".equals(pName)) {
      m_listeFluxQuantiteTravailDsn = ((_ListeFluxQuantiteTravailDsn)pValeur);
    }
    if ("motifFinContrat".equals(pName)) {
      m_motifFinContrat = ((String)pValeur);
    }
    if ("dateInitialeFinContrat".equals(pName)) {
      m_dateInitialeFinContrat = ((Damj)pValeur);
    }
    if ("idActiviteDsnPe".equals(pName)) {
      m_idActiviteDsnPe = ((BigDecimal)pValeur);
    }
    if ("signeDureeAbsence".equals(pName)) {
      m_signeDureeAbsence = ((String)pValeur);
    }
    if ("ListeFluxPrimeIndemDsn".equals(pName)) {
      m_listeFluxPrimeIndemDsn = ((_ListeFluxPrimeIndemDsn)pValeur);
    }
    if ("identDeclPri".equals(pName)) {
      m_identDeclPri = ((String)pValeur);
    }
    if ("identDeclSec".equals(pName)) {
      m_identDeclSec = ((String)pValeur);
    }
    if ("motifRecours".equals(pName)) {
      m_motifRecours = ((String)pValeur);
    }
    if ("modaliteDeclarativeFinContrat".equals(pName)) {
      m_modaliteDeclarativeFinContrat = ((String)pValeur);
    }
    if ("djtp".equals(pName)) {
      m_djtp = ((Damj)pValeur);
    }
  }
  
  public void _setAttribute(String pPropertyName, String pAttributeName, String pValeur)
    throws Exception
  {
    StringBuffer attr = new StringBuffer();
    attr.append("m_");
    if (pPropertyName != null) {
      attr.append(pPropertyName);
    }
    attr.append("_").append(pAttributeName);
    String attrName = attr.toString();
    if ("m__C_ETAT".equals(attrName)) {
      m__C_ETAT = pValeur;
    }
    if ("m__IDENT".equals(attrName)) {
      m__IDENT = pValeur;
    }
    if ("m_typeEnreg_C_ERR".equals(attrName)) {
      m_typeEnreg_C_ERR = pValeur;
    }
    if ("m_numNIRCertifie_C_ERR".equals(attrName)) {
      m_numNIRCertifie_C_ERR = pValeur;
    }
    if ("m_nomDeclare_C_ERR".equals(attrName)) {
      m_nomDeclare_C_ERR = pValeur;
    }
    if ("m_prenomDeclare_C_ERR".equals(attrName)) {
      m_prenomDeclare_C_ERR = pValeur;
    }
    if ("m_dateNaissance_C_ERR".equals(attrName)) {
      m_dateNaissance_C_ERR = pValeur;
    }
    if ("m_contexteEmission_C_ERR".equals(attrName)) {
      m_contexteEmission_C_ERR = pValeur;
    }
    if ("m_natureJustificatif_C_ERR".equals(attrName)) {
      m_natureJustificatif_C_ERR = pValeur;
    }
    if ("m_codeMessage_C_ERR".equals(attrName)) {
      m_codeMessage_C_ERR = pValeur;
    }
    if ("m_numeroVersion_C_ERR".equals(attrName)) {
      m_numeroVersion_C_ERR = pValeur;
    }
    if ("m_numeroSousVersion_C_ERR".equals(attrName)) {
      m_numeroSousVersion_C_ERR = pValeur;
    }
    if ("m_codeAction_C_ERR".equals(attrName)) {
      m_codeAction_C_ERR = pValeur;
    }
    if ("m_idTechnique_C_ERR".equals(attrName)) {
      m_idTechnique_C_ERR = pValeur;
    }
    if ("m_idRCE_C_ERR".equals(attrName)) {
      m_idRCE_C_ERR = pValeur;
    }
    if ("m_siretDeclare_C_ERR".equals(attrName)) {
      m_siretDeclare_C_ERR = pValeur;
    }
    if ("m_refContratEmployeur_C_ERR".equals(attrName)) {
      m_refContratEmployeur_C_ERR = pValeur;
    }
    if ("m_nbMessagesPrimesIndemnites_C_ERR".equals(attrName)) {
      m_nbMessagesPrimesIndemnites_C_ERR = pValeur;
    }
    if ("m_dateConnaissanceMensuelle_C_ERR".equals(attrName)) {
      m_dateConnaissanceMensuelle_C_ERR = pValeur;
    }
    if ("m_dateMoisDeclare_C_ERR".equals(attrName)) {
      m_dateMoisDeclare_C_ERR = pValeur;
    }
    if ("m_dateDebutContrat_C_ERR".equals(attrName)) {
      m_dateDebutContrat_C_ERR = pValeur;
    }
    if ("m_dateFinContrat_C_ERR".equals(attrName)) {
      m_dateFinContrat_C_ERR = pValeur;
    }
    if ("m_natureContrat_C_ERR".equals(attrName)) {
      m_natureContrat_C_ERR = pValeur;
    }
    if ("m_typeContrat_C_ERR".equals(attrName)) {
      m_typeContrat_C_ERR = pValeur;
    }
    if ("m_codeStatutCadre_C_ERR".equals(attrName)) {
      m_codeStatutCadre_C_ERR = pValeur;
    }
    if ("m_horaireSalarie_C_ERR".equals(attrName)) {
      m_horaireSalarie_C_ERR = pValeur;
    }
    if ("m_horaireEntreprise_C_ERR".equals(attrName)) {
      m_horaireEntreprise_C_ERR = pValeur;
    }
    if ("m_uniteTempsTravail_C_ERR".equals(attrName)) {
      m_uniteTempsTravail_C_ERR = pValeur;
    }
    if ("m_alsaceMoselle_C_ERR".equals(attrName)) {
      m_alsaceMoselle_C_ERR = pValeur;
    }
    if ("m_regimeSpecialSecuriteSoc_C_ERR".equals(attrName)) {
      m_regimeSpecialSecuriteSoc_C_ERR = pValeur;
    }
    if ("m_typeCaisseCP_C_ERR".equals(attrName)) {
      m_typeCaisseCP_C_ERR = pValeur;
    }
    if ("m_niveauQualification_C_ERR".equals(attrName)) {
      m_niveauQualification_C_ERR = pValeur;
    }
    if ("m_codeCaisseRetraiteCompl_C_ERR".equals(attrName)) {
      m_codeCaisseRetraiteCompl_C_ERR = pValeur;
    }
    if ("m_champApplicationEmployeur_C_ERR".equals(attrName)) {
      m_champApplicationEmployeur_C_ERR = pValeur;
    }
    if ("m_numConventionGestionEmpPublic_C_ERR".equals(attrName)) {
      m_numConventionGestionEmpPublic_C_ERR = pValeur;
    }
    if ("m_etablissementFinancier_C_ERR".equals(attrName)) {
      m_etablissementFinancier_C_ERR = pValeur;
    }
    if ("m_codeAffectation_C_ERR".equals(attrName)) {
      m_codeAffectation_C_ERR = pValeur;
    }
    if ("m_numInterneEmpPublic_C_ERR".equals(attrName)) {
      m_numInterneEmpPublic_C_ERR = pValeur;
    }
    if ("m_statutSalarie_C_ERR".equals(attrName)) {
      m_statutSalarie_C_ERR = pValeur;
    }
    if ("m_dateAdhesion_C_ERR".equals(attrName)) {
      m_dateAdhesion_C_ERR = pValeur;
    }
    if ("m_motifPeriodeInactivite_C_ERR".equals(attrName)) {
      m_motifPeriodeInactivite_C_ERR = pValeur;
    }
    if ("m_dateDebutPeriodeInactivite_C_ERR".equals(attrName)) {
      m_dateDebutPeriodeInactivite_C_ERR = pValeur;
    }
    if ("m_dateFinPeriodeInactivite_C_ERR".equals(attrName)) {
      m_dateFinPeriodeInactivite_C_ERR = pValeur;
    }
    if ("m_dateDebutPeriodeSalaire_C_ERR".equals(attrName)) {
      m_dateDebutPeriodeSalaire_C_ERR = pValeur;
    }
    if ("m_dateFinPeriodeSalaire_C_ERR".equals(attrName)) {
      m_dateFinPeriodeSalaire_C_ERR = pValeur;
    }
    if ("m_codePcsEse_C_ERR".equals(attrName)) {
      m_codePcsEse_C_ERR = pValeur;
    }
    if ("m_codeComplementPcsEse_C_ERR".equals(attrName)) {
      m_codeComplementPcsEse_C_ERR = pValeur;
    }
    if ("m_signeSalaireBrutAbattu_C_ERR".equals(attrName)) {
      m_signeSalaireBrutAbattu_C_ERR = pValeur;
    }
    if ("m_salaireBrutAbattu_C_ERR".equals(attrName)) {
      m_salaireBrutAbattu_C_ERR = pValeur;
    }
    if ("m_datePaiement_C_ERR".equals(attrName)) {
      m_datePaiement_C_ERR = pValeur;
    }
    if ("m_dureeAbsence_C_ERR".equals(attrName)) {
      m_dureeAbsence_C_ERR = pValeur;
    }
    if ("m_uniteAbsence_C_ERR".equals(attrName)) {
      m_uniteAbsence_C_ERR = pValeur;
    }
    if ("m_nomLogiciel_C_ERR".equals(attrName)) {
      m_nomLogiciel_C_ERR = pValeur;
    }
    if ("m_versionLogiciel_C_ERR".equals(attrName)) {
      m_versionLogiciel_C_ERR = pValeur;
    }
    if ("m_numeroRCI_C_ERR".equals(attrName)) {
      m_numeroRCI_C_ERR = pValeur;
    }
    if ("m_cxass_C_ERR".equals(attrName)) {
      m_cxass_C_ERR = pValeur;
    }
    if ("m_rsin_C_ERR".equals(attrName)) {
      m_rsin_C_ERR = pValeur;
    }
    if ("m_nom_C_ERR".equals(attrName)) {
      m_nom_C_ERR = pValeur;
    }
    if ("m_prenom_C_ERR".equals(attrName)) {
      m_prenom_C_ERR = pValeur;
    }
    if ("m_peAffi_C_ERR".equals(attrName)) {
      m_peAffi_C_ERR = pValeur;
    }
    if ("m_siret_C_ERR".equals(attrName)) {
      m_siret_C_ERR = pValeur;
    }
    if ("m_emplNumAffi_C_ERR".equals(attrName)) {
      m_emplNumAffi_C_ERR = pValeur;
    }
    if ("m_emplRaisonSociale_C_ERR".equals(attrName)) {
      m_emplRaisonSociale_C_ERR = pValeur;
    }
    if ("m_emplNAF_C_ERR".equals(attrName)) {
      m_emplNAF_C_ERR = pValeur;
    }
    if ("m_emplCommune_C_ERR".equals(attrName)) {
      m_emplCommune_C_ERR = pValeur;
    }
    if ("m_emplCP_C_ERR".equals(attrName)) {
      m_emplCP_C_ERR = pValeur;
    }
    if ("m_idBNEArrco_C_ERR".equals(attrName)) {
      m_idBNEArrco_C_ERR = pValeur;
    }
    if ("m_arrcoSigle_C_ERR".equals(attrName)) {
      m_arrcoSigle_C_ERR = pValeur;
    }
    if ("m_arrcoRaisonSociale_C_ERR".equals(attrName)) {
      m_arrcoRaisonSociale_C_ERR = pValeur;
    }
    if ("m_idBNEAgirc_C_ERR".equals(attrName)) {
      m_idBNEAgirc_C_ERR = pValeur;
    }
    if ("m_agircSigle_C_ERR".equals(attrName)) {
      m_agircSigle_C_ERR = pValeur;
    }
    if ("m_agircRaisonSociale_C_ERR".equals(attrName)) {
      m_agircRaisonSociale_C_ERR = pValeur;
    }
    if ("m_codeRegimeCrpCtp_C_ERR".equals(attrName)) {
      m_codeRegimeCrpCtp_C_ERR = pValeur;
    }
    if ("m_dateEffetRegimeCrpCtp_C_ERR".equals(attrName)) {
      m_dateEffetRegimeCrpCtp_C_ERR = pValeur;
    }
    if ("m_emplNumConventionGestion_C_ERR".equals(attrName)) {
      m_emplNumConventionGestion_C_ERR = pValeur;
    }
    if ("m_nbSalariesEntreprise_C_ERR".equals(attrName)) {
      m_nbSalariesEntreprise_C_ERR = pValeur;
    }
    if ("m_nomEmployeur_C_ERR".equals(attrName)) {
      m_nomEmployeur_C_ERR = pValeur;
    }
    if ("m_prenomEmployeur_C_ERR".equals(attrName)) {
      m_prenomEmployeur_C_ERR = pValeur;
    }
    if ("m_categorieJuridique_C_ERR".equals(attrName)) {
      m_categorieJuridique_C_ERR = pValeur;
    }
    if ("m_codeRegimeEntreprise_C_ERR".equals(attrName)) {
      m_codeRegimeEntreprise_C_ERR = pValeur;
    }
    if ("m_dateCessationEntreprise_C_ERR".equals(attrName)) {
      m_dateCessationEntreprise_C_ERR = pValeur;
    }
    if ("m_natureEntreprise_C_ERR".equals(attrName)) {
      m_natureEntreprise_C_ERR = pValeur;
    }
    if ("m_numMSAEntreprise_C_ERR".equals(attrName)) {
      m_numMSAEntreprise_C_ERR = pValeur;
    }
    if ("m_debutPeriodeAffiliationEntreprise_C_ERR".equals(attrName)) {
      m_debutPeriodeAffiliationEntreprise_C_ERR = pValeur;
    }
    if ("m_finPeriodeAffiliationEntreprise_C_ERR".equals(attrName)) {
      m_finPeriodeAffiliationEntreprise_C_ERR = pValeur;
    }
    if ("m_debutConventionGestion_C_ERR".equals(attrName)) {
      m_debutConventionGestion_C_ERR = pValeur;
    }
    if ("m_finConventionGestion_C_ERR".equals(attrName)) {
      m_finConventionGestion_C_ERR = pValeur;
    }
    if ("m_secteurPublic_C_ERR".equals(attrName)) {
      m_secteurPublic_C_ERR = pValeur;
    }
    if ("m_trancheEffectifEntreprise_C_ERR".equals(attrName)) {
      m_trancheEffectifEntreprise_C_ERR = pValeur;
    }
    if ("m_debutAGS_C_ERR".equals(attrName)) {
      m_debutAGS_C_ERR = pValeur;
    }
    if ("m_finAGS_C_ERR".equals(attrName)) {
      m_finAGS_C_ERR = pValeur;
    }
    if ("m_debutAdhesionRevocable_C_ERR".equals(attrName)) {
      m_debutAdhesionRevocable_C_ERR = pValeur;
    }
    if ("m_finAdhesionRevocable_C_ERR".equals(attrName)) {
      m_finAdhesionRevocable_C_ERR = pValeur;
    }
    if ("m_listeFluxQuantiteTravailDsn_C_ERR".equals(attrName)) {
      m_listeFluxQuantiteTravailDsn_C_ERR = pValeur;
    }
    if ("m_motifFinContrat_C_ERR".equals(attrName)) {
      m_motifFinContrat_C_ERR = pValeur;
    }
    if ("m_dateInitialeFinContrat_C_ERR".equals(attrName)) {
      m_dateInitialeFinContrat_C_ERR = pValeur;
    }
    if ("m_idActiviteDsnPe_C_ERR".equals(attrName)) {
      m_idActiviteDsnPe_C_ERR = pValeur;
    }
    if ("m_signeDureeAbsence_C_ERR".equals(attrName)) {
      m_signeDureeAbsence_C_ERR = pValeur;
    }
    if ("m_listeFluxPrimeIndemDsn_C_ERR".equals(attrName)) {
      m_listeFluxPrimeIndemDsn_C_ERR = pValeur;
    }
    if ("m_identDeclPri_C_ERR".equals(attrName)) {
      m_identDeclPri_C_ERR = pValeur;
    }
    if ("m_identDeclSec_C_ERR".equals(attrName)) {
      m_identDeclSec_C_ERR = pValeur;
    }
    if ("m_motifRecours_C_ERR".equals(attrName)) {
      m_motifRecours_C_ERR = pValeur;
    }
    if ("m_modaliteDeclarativeFinContrat_C_ERR".equals(attrName)) {
      m_modaliteDeclarativeFinContrat_C_ERR = pValeur;
    }
    if ("m_djtp_C_ERR".equals(attrName)) {
      m_djtp_C_ERR = pValeur;
    }
  }
  
  public String _getAttribute(String pPropertyName, String pAttributeName)
  {
    StringBuffer attr = new StringBuffer();
    attr.append("m_");
    if (pPropertyName != null) {
      attr.append(pPropertyName);
    }
    attr.append("_").append(pAttributeName);
    String attrName = attr.toString();
    if ("m__C_ETAT".equals(attrName)) {
      return m__C_ETAT;
    }
    if ("m__IDENT".equals(attrName)) {
      return m__IDENT;
    }
    if ("m_typeEnreg_C_ERR".equals(attrName)) {
      return m_typeEnreg_C_ERR;
    }
    if ("m_numNIRCertifie_C_ERR".equals(attrName)) {
      return m_numNIRCertifie_C_ERR;
    }
    if ("m_nomDeclare_C_ERR".equals(attrName)) {
      return m_nomDeclare_C_ERR;
    }
    if ("m_prenomDeclare_C_ERR".equals(attrName)) {
      return m_prenomDeclare_C_ERR;
    }
    if ("m_dateNaissance_C_ERR".equals(attrName)) {
      return m_dateNaissance_C_ERR;
    }
    if ("m_contexteEmission_C_ERR".equals(attrName)) {
      return m_contexteEmission_C_ERR;
    }
    if ("m_natureJustificatif_C_ERR".equals(attrName)) {
      return m_natureJustificatif_C_ERR;
    }
    if ("m_codeMessage_C_ERR".equals(attrName)) {
      return m_codeMessage_C_ERR;
    }
    if ("m_numeroVersion_C_ERR".equals(attrName)) {
      return m_numeroVersion_C_ERR;
    }
    if ("m_numeroSousVersion_C_ERR".equals(attrName)) {
      return m_numeroSousVersion_C_ERR;
    }
    if ("m_codeAction_C_ERR".equals(attrName)) {
      return m_codeAction_C_ERR;
    }
    if ("m_idTechnique_C_ERR".equals(attrName)) {
      return m_idTechnique_C_ERR;
    }
    if ("m_idRCE_C_ERR".equals(attrName)) {
      return m_idRCE_C_ERR;
    }
    if ("m_siretDeclare_C_ERR".equals(attrName)) {
      return m_siretDeclare_C_ERR;
    }
    if ("m_refContratEmployeur_C_ERR".equals(attrName)) {
      return m_refContratEmployeur_C_ERR;
    }
    if ("m_nbMessagesPrimesIndemnites_C_ERR".equals(attrName)) {
      return m_nbMessagesPrimesIndemnites_C_ERR;
    }
    if ("m_dateConnaissanceMensuelle_C_ERR".equals(attrName)) {
      return m_dateConnaissanceMensuelle_C_ERR;
    }
    if ("m_dateMoisDeclare_C_ERR".equals(attrName)) {
      return m_dateMoisDeclare_C_ERR;
    }
    if ("m_dateDebutContrat_C_ERR".equals(attrName)) {
      return m_dateDebutContrat_C_ERR;
    }
    if ("m_dateFinContrat_C_ERR".equals(attrName)) {
      return m_dateFinContrat_C_ERR;
    }
    if ("m_natureContrat_C_ERR".equals(attrName)) {
      return m_natureContrat_C_ERR;
    }
    if ("m_typeContrat_C_ERR".equals(attrName)) {
      return m_typeContrat_C_ERR;
    }
    if ("m_codeStatutCadre_C_ERR".equals(attrName)) {
      return m_codeStatutCadre_C_ERR;
    }
    if ("m_horaireSalarie_C_ERR".equals(attrName)) {
      return m_horaireSalarie_C_ERR;
    }
    if ("m_horaireEntreprise_C_ERR".equals(attrName)) {
      return m_horaireEntreprise_C_ERR;
    }
    if ("m_uniteTempsTravail_C_ERR".equals(attrName)) {
      return m_uniteTempsTravail_C_ERR;
    }
    if ("m_alsaceMoselle_C_ERR".equals(attrName)) {
      return m_alsaceMoselle_C_ERR;
    }
    if ("m_regimeSpecialSecuriteSoc_C_ERR".equals(attrName)) {
      return m_regimeSpecialSecuriteSoc_C_ERR;
    }
    if ("m_typeCaisseCP_C_ERR".equals(attrName)) {
      return m_typeCaisseCP_C_ERR;
    }
    if ("m_niveauQualification_C_ERR".equals(attrName)) {
      return m_niveauQualification_C_ERR;
    }
    if ("m_codeCaisseRetraiteCompl_C_ERR".equals(attrName)) {
      return m_codeCaisseRetraiteCompl_C_ERR;
    }
    if ("m_champApplicationEmployeur_C_ERR".equals(attrName)) {
      return m_champApplicationEmployeur_C_ERR;
    }
    if ("m_numConventionGestionEmpPublic_C_ERR".equals(attrName)) {
      return m_numConventionGestionEmpPublic_C_ERR;
    }
    if ("m_etablissementFinancier_C_ERR".equals(attrName)) {
      return m_etablissementFinancier_C_ERR;
    }
    if ("m_codeAffectation_C_ERR".equals(attrName)) {
      return m_codeAffectation_C_ERR;
    }
    if ("m_numInterneEmpPublic_C_ERR".equals(attrName)) {
      return m_numInterneEmpPublic_C_ERR;
    }
    if ("m_statutSalarie_C_ERR".equals(attrName)) {
      return m_statutSalarie_C_ERR;
    }
    if ("m_dateAdhesion_C_ERR".equals(attrName)) {
      return m_dateAdhesion_C_ERR;
    }
    if ("m_motifPeriodeInactivite_C_ERR".equals(attrName)) {
      return m_motifPeriodeInactivite_C_ERR;
    }
    if ("m_dateDebutPeriodeInactivite_C_ERR".equals(attrName)) {
      return m_dateDebutPeriodeInactivite_C_ERR;
    }
    if ("m_dateFinPeriodeInactivite_C_ERR".equals(attrName)) {
      return m_dateFinPeriodeInactivite_C_ERR;
    }
    if ("m_dateDebutPeriodeSalaire_C_ERR".equals(attrName)) {
      return m_dateDebutPeriodeSalaire_C_ERR;
    }
    if ("m_dateFinPeriodeSalaire_C_ERR".equals(attrName)) {
      return m_dateFinPeriodeSalaire_C_ERR;
    }
    if ("m_codePcsEse_C_ERR".equals(attrName)) {
      return m_codePcsEse_C_ERR;
    }
    if ("m_codeComplementPcsEse_C_ERR".equals(attrName)) {
      return m_codeComplementPcsEse_C_ERR;
    }
    if ("m_signeSalaireBrutAbattu_C_ERR".equals(attrName)) {
      return m_signeSalaireBrutAbattu_C_ERR;
    }
    if ("m_salaireBrutAbattu_C_ERR".equals(attrName)) {
      return m_salaireBrutAbattu_C_ERR;
    }
    if ("m_datePaiement_C_ERR".equals(attrName)) {
      return m_datePaiement_C_ERR;
    }
    if ("m_dureeAbsence_C_ERR".equals(attrName)) {
      return m_dureeAbsence_C_ERR;
    }
    if ("m_uniteAbsence_C_ERR".equals(attrName)) {
      return m_uniteAbsence_C_ERR;
    }
    if ("m_nomLogiciel_C_ERR".equals(attrName)) {
      return m_nomLogiciel_C_ERR;
    }
    if ("m_versionLogiciel_C_ERR".equals(attrName)) {
      return m_versionLogiciel_C_ERR;
    }
    if ("m_numeroRCI_C_ERR".equals(attrName)) {
      return m_numeroRCI_C_ERR;
    }
    if ("m_cxass_C_ERR".equals(attrName)) {
      return m_cxass_C_ERR;
    }
    if ("m_rsin_C_ERR".equals(attrName)) {
      return m_rsin_C_ERR;
    }
    if ("m_nom_C_ERR".equals(attrName)) {
      return m_nom_C_ERR;
    }
    if ("m_prenom_C_ERR".equals(attrName)) {
      return m_prenom_C_ERR;
    }
    if ("m_peAffi_C_ERR".equals(attrName)) {
      return m_peAffi_C_ERR;
    }
    if ("m_siret_C_ERR".equals(attrName)) {
      return m_siret_C_ERR;
    }
    if ("m_emplNumAffi_C_ERR".equals(attrName)) {
      return m_emplNumAffi_C_ERR;
    }
    if ("m_emplRaisonSociale_C_ERR".equals(attrName)) {
      return m_emplRaisonSociale_C_ERR;
    }
    if ("m_emplNAF_C_ERR".equals(attrName)) {
      return m_emplNAF_C_ERR;
    }
    if ("m_emplCommune_C_ERR".equals(attrName)) {
      return m_emplCommune_C_ERR;
    }
    if ("m_emplCP_C_ERR".equals(attrName)) {
      return m_emplCP_C_ERR;
    }
    if ("m_idBNEArrco_C_ERR".equals(attrName)) {
      return m_idBNEArrco_C_ERR;
    }
    if ("m_arrcoSigle_C_ERR".equals(attrName)) {
      return m_arrcoSigle_C_ERR;
    }
    if ("m_arrcoRaisonSociale_C_ERR".equals(attrName)) {
      return m_arrcoRaisonSociale_C_ERR;
    }
    if ("m_idBNEAgirc_C_ERR".equals(attrName)) {
      return m_idBNEAgirc_C_ERR;
    }
    if ("m_agircSigle_C_ERR".equals(attrName)) {
      return m_agircSigle_C_ERR;
    }
    if ("m_agircRaisonSociale_C_ERR".equals(attrName)) {
      return m_agircRaisonSociale_C_ERR;
    }
    if ("m_codeRegimeCrpCtp_C_ERR".equals(attrName)) {
      return m_codeRegimeCrpCtp_C_ERR;
    }
    if ("m_dateEffetRegimeCrpCtp_C_ERR".equals(attrName)) {
      return m_dateEffetRegimeCrpCtp_C_ERR;
    }
    if ("m_emplNumConventionGestion_C_ERR".equals(attrName)) {
      return m_emplNumConventionGestion_C_ERR;
    }
    if ("m_nbSalariesEntreprise_C_ERR".equals(attrName)) {
      return m_nbSalariesEntreprise_C_ERR;
    }
    if ("m_nomEmployeur_C_ERR".equals(attrName)) {
      return m_nomEmployeur_C_ERR;
    }
    if ("m_prenomEmployeur_C_ERR".equals(attrName)) {
      return m_prenomEmployeur_C_ERR;
    }
    if ("m_categorieJuridique_C_ERR".equals(attrName)) {
      return m_categorieJuridique_C_ERR;
    }
    if ("m_codeRegimeEntreprise_C_ERR".equals(attrName)) {
      return m_codeRegimeEntreprise_C_ERR;
    }
    if ("m_dateCessationEntreprise_C_ERR".equals(attrName)) {
      return m_dateCessationEntreprise_C_ERR;
    }
    if ("m_natureEntreprise_C_ERR".equals(attrName)) {
      return m_natureEntreprise_C_ERR;
    }
    if ("m_numMSAEntreprise_C_ERR".equals(attrName)) {
      return m_numMSAEntreprise_C_ERR;
    }
    if ("m_debutPeriodeAffiliationEntreprise_C_ERR".equals(attrName)) {
      return m_debutPeriodeAffiliationEntreprise_C_ERR;
    }
    if ("m_finPeriodeAffiliationEntreprise_C_ERR".equals(attrName)) {
      return m_finPeriodeAffiliationEntreprise_C_ERR;
    }
    if ("m_debutConventionGestion_C_ERR".equals(attrName)) {
      return m_debutConventionGestion_C_ERR;
    }
    if ("m_finConventionGestion_C_ERR".equals(attrName)) {
      return m_finConventionGestion_C_ERR;
    }
    if ("m_secteurPublic_C_ERR".equals(attrName)) {
      return m_secteurPublic_C_ERR;
    }
    if ("m_trancheEffectifEntreprise_C_ERR".equals(attrName)) {
      return m_trancheEffectifEntreprise_C_ERR;
    }
    if ("m_debutAGS_C_ERR".equals(attrName)) {
      return m_debutAGS_C_ERR;
    }
    if ("m_finAGS_C_ERR".equals(attrName)) {
      return m_finAGS_C_ERR;
    }
    if ("m_debutAdhesionRevocable_C_ERR".equals(attrName)) {
      return m_debutAdhesionRevocable_C_ERR;
    }
    if ("m_finAdhesionRevocable_C_ERR".equals(attrName)) {
      return m_finAdhesionRevocable_C_ERR;
    }
    if ("m_listeFluxQuantiteTravailDsn_C_ERR".equals(attrName)) {
      return m_listeFluxQuantiteTravailDsn_C_ERR;
    }
    if ("m_motifFinContrat_C_ERR".equals(attrName)) {
      return m_motifFinContrat_C_ERR;
    }
    if ("m_dateInitialeFinContrat_C_ERR".equals(attrName)) {
      return m_dateInitialeFinContrat_C_ERR;
    }
    if ("m_idActiviteDsnPe_C_ERR".equals(attrName)) {
      return m_idActiviteDsnPe_C_ERR;
    }
    if ("m_signeDureeAbsence_C_ERR".equals(attrName)) {
      return m_signeDureeAbsence_C_ERR;
    }
    if ("m_listeFluxPrimeIndemDsn_C_ERR".equals(attrName)) {
      return m_listeFluxPrimeIndemDsn_C_ERR;
    }
    if ("m_identDeclPri_C_ERR".equals(attrName)) {
      return m_identDeclPri_C_ERR;
    }
    if ("m_identDeclSec_C_ERR".equals(attrName)) {
      return m_identDeclSec_C_ERR;
    }
    if ("m_motifRecours_C_ERR".equals(attrName)) {
      return m_motifRecours_C_ERR;
    }
    if ("m_modaliteDeclarativeFinContrat_C_ERR".equals(attrName)) {
      return m_modaliteDeclarativeFinContrat_C_ERR;
    }
    if ("m_djtp_C_ERR".equals(attrName)) {
      return m_djtp_C_ERR;
    }
    return null;
  }
  
  public boolean equals(Object pObjet)
  {
    if (!(pObjet instanceof _FluxCtPasDsn)) {
      return false;
    }
    _FluxCtPasDsn x = (_FluxCtPasDsn)pObjet;
    if (m_typeEnreg == null)
    {
      if (m_typeEnreg != null) {
        return false;
      }
    }
    else
    {
      if (m_typeEnreg == null) {
        return false;
      }
      if (!m_typeEnreg.equals(m_typeEnreg)) {
        return false;
      }
    }
    if (m_numNIRCertifie == null)
    {
      if (m_numNIRCertifie != null) {
        return false;
      }
    }
    else
    {
      if (m_numNIRCertifie == null) {
        return false;
      }
      if (!m_numNIRCertifie.equals(m_numNIRCertifie)) {
        return false;
      }
    }
    if (m_nomDeclare == null)
    {
      if (m_nomDeclare != null) {
        return false;
      }
    }
    else
    {
      if (m_nomDeclare == null) {
        return false;
      }
      if (!m_nomDeclare.equals(m_nomDeclare)) {
        return false;
      }
    }
    if (m_prenomDeclare == null)
    {
      if (m_prenomDeclare != null) {
        return false;
      }
    }
    else
    {
      if (m_prenomDeclare == null) {
        return false;
      }
      if (!m_prenomDeclare.equals(m_prenomDeclare)) {
        return false;
      }
    }
    if (m_dateNaissance == null)
    {
      if (m_dateNaissance != null) {
        return false;
      }
    }
    else
    {
      if (m_dateNaissance == null) {
        return false;
      }
      if (!m_dateNaissance.equals(m_dateNaissance)) {
        return false;
      }
    }
    if (m_contexteEmission == null)
    {
      if (m_contexteEmission != null) {
        return false;
      }
    }
    else
    {
      if (m_contexteEmission == null) {
        return false;
      }
      if (!m_contexteEmission.equals(m_contexteEmission)) {
        return false;
      }
    }
    if (m_natureJustificatif == null)
    {
      if (m_natureJustificatif != null) {
        return false;
      }
    }
    else
    {
      if (m_natureJustificatif == null) {
        return false;
      }
      if (!m_natureJustificatif.equals(m_natureJustificatif)) {
        return false;
      }
    }
    if (m_codeMessage == null)
    {
      if (m_codeMessage != null) {
        return false;
      }
    }
    else
    {
      if (m_codeMessage == null) {
        return false;
      }
      if (!m_codeMessage.equals(m_codeMessage)) {
        return false;
      }
    }
    if (m_numeroVersion == null)
    {
      if (m_numeroVersion != null) {
        return false;
      }
    }
    else
    {
      if (m_numeroVersion == null) {
        return false;
      }
      if (!m_numeroVersion.equals(m_numeroVersion)) {
        return false;
      }
    }
    if (m_numeroSousVersion == null)
    {
      if (m_numeroSousVersion != null) {
        return false;
      }
    }
    else
    {
      if (m_numeroSousVersion == null) {
        return false;
      }
      if (!m_numeroSousVersion.equals(m_numeroSousVersion)) {
        return false;
      }
    }
    if (m_codeAction == null)
    {
      if (m_codeAction != null) {
        return false;
      }
    }
    else
    {
      if (m_codeAction == null) {
        return false;
      }
      if (!m_codeAction.equals(m_codeAction)) {
        return false;
      }
    }
    if (m_idTechnique == null)
    {
      if (m_idTechnique != null) {
        return false;
      }
    }
    else
    {
      if (m_idTechnique == null) {
        return false;
      }
      if (!m_idTechnique.equals(m_idTechnique)) {
        return false;
      }
    }
    if (m_idRCE == null)
    {
      if (m_idRCE != null) {
        return false;
      }
    }
    else
    {
      if (m_idRCE == null) {
        return false;
      }
      if (!m_idRCE.equals(m_idRCE)) {
        return false;
      }
    }
    if (m_siretDeclare == null)
    {
      if (m_siretDeclare != null) {
        return false;
      }
    }
    else
    {
      if (m_siretDeclare == null) {
        return false;
      }
      if (!m_siretDeclare.equals(m_siretDeclare)) {
        return false;
      }
    }
    if (m_refContratEmployeur == null)
    {
      if (m_refContratEmployeur != null) {
        return false;
      }
    }
    else
    {
      if (m_refContratEmployeur == null) {
        return false;
      }
      if (!m_refContratEmployeur.equals(m_refContratEmployeur)) {
        return false;
      }
    }
    if (m_nbMessagesPrimesIndemnites == null)
    {
      if (m_nbMessagesPrimesIndemnites != null) {
        return false;
      }
    }
    else
    {
      if (m_nbMessagesPrimesIndemnites == null) {
        return false;
      }
      if (!m_nbMessagesPrimesIndemnites.equals(m_nbMessagesPrimesIndemnites)) {
        return false;
      }
    }
    if (m_dateConnaissanceMensuelle == null)
    {
      if (m_dateConnaissanceMensuelle != null) {
        return false;
      }
    }
    else
    {
      if (m_dateConnaissanceMensuelle == null) {
        return false;
      }
      if (!m_dateConnaissanceMensuelle.equals(m_dateConnaissanceMensuelle)) {
        return false;
      }
    }
    if (m_dateMoisDeclare == null)
    {
      if (m_dateMoisDeclare != null) {
        return false;
      }
    }
    else
    {
      if (m_dateMoisDeclare == null) {
        return false;
      }
      if (!m_dateMoisDeclare.equals(m_dateMoisDeclare)) {
        return false;
      }
    }
    if (m_dateDebutContrat == null)
    {
      if (m_dateDebutContrat != null) {
        return false;
      }
    }
    else
    {
      if (m_dateDebutContrat == null) {
        return false;
      }
      if (!m_dateDebutContrat.equals(m_dateDebutContrat)) {
        return false;
      }
    }
    if (m_dateFinContrat == null)
    {
      if (m_dateFinContrat != null) {
        return false;
      }
    }
    else
    {
      if (m_dateFinContrat == null) {
        return false;
      }
      if (!m_dateFinContrat.equals(m_dateFinContrat)) {
        return false;
      }
    }
    if (m_natureContrat == null)
    {
      if (m_natureContrat != null) {
        return false;
      }
    }
    else
    {
      if (m_natureContrat == null) {
        return false;
      }
      if (!m_natureContrat.equals(m_natureContrat)) {
        return false;
      }
    }
    if (m_typeContrat == null)
    {
      if (m_typeContrat != null) {
        return false;
      }
    }
    else
    {
      if (m_typeContrat == null) {
        return false;
      }
      if (!m_typeContrat.equals(m_typeContrat)) {
        return false;
      }
    }
    if (m_codeStatutCadre == null)
    {
      if (m_codeStatutCadre != null) {
        return false;
      }
    }
    else
    {
      if (m_codeStatutCadre == null) {
        return false;
      }
      if (!m_codeStatutCadre.equals(m_codeStatutCadre)) {
        return false;
      }
    }
    if (m_horaireSalarie == null)
    {
      if (m_horaireSalarie != null) {
        return false;
      }
    }
    else
    {
      if (m_horaireSalarie == null) {
        return false;
      }
      if (!m_horaireSalarie.equals(m_horaireSalarie)) {
        return false;
      }
    }
    if (m_horaireEntreprise == null)
    {
      if (m_horaireEntreprise != null) {
        return false;
      }
    }
    else
    {
      if (m_horaireEntreprise == null) {
        return false;
      }
      if (!m_horaireEntreprise.equals(m_horaireEntreprise)) {
        return false;
      }
    }
    if (m_uniteTempsTravail == null)
    {
      if (m_uniteTempsTravail != null) {
        return false;
      }
    }
    else
    {
      if (m_uniteTempsTravail == null) {
        return false;
      }
      if (!m_uniteTempsTravail.equals(m_uniteTempsTravail)) {
        return false;
      }
    }
    if (m_alsaceMoselle == null)
    {
      if (m_alsaceMoselle != null) {
        return false;
      }
    }
    else
    {
      if (m_alsaceMoselle == null) {
        return false;
      }
      if (!m_alsaceMoselle.equals(m_alsaceMoselle)) {
        return false;
      }
    }
    if (m_regimeSpecialSecuriteSoc == null)
    {
      if (m_regimeSpecialSecuriteSoc != null) {
        return false;
      }
    }
    else
    {
      if (m_regimeSpecialSecuriteSoc == null) {
        return false;
      }
      if (!m_regimeSpecialSecuriteSoc.equals(m_regimeSpecialSecuriteSoc)) {
        return false;
      }
    }
    if (m_typeCaisseCP == null)
    {
      if (m_typeCaisseCP != null) {
        return false;
      }
    }
    else
    {
      if (m_typeCaisseCP == null) {
        return false;
      }
      if (!m_typeCaisseCP.equals(m_typeCaisseCP)) {
        return false;
      }
    }
    if (m_niveauQualification == null)
    {
      if (m_niveauQualification != null) {
        return false;
      }
    }
    else
    {
      if (m_niveauQualification == null) {
        return false;
      }
      if (!m_niveauQualification.equals(m_niveauQualification)) {
        return false;
      }
    }
    if (m_codeCaisseRetraiteCompl == null)
    {
      if (m_codeCaisseRetraiteCompl != null) {
        return false;
      }
    }
    else
    {
      if (m_codeCaisseRetraiteCompl == null) {
        return false;
      }
      if (!m_codeCaisseRetraiteCompl.equals(m_codeCaisseRetraiteCompl)) {
        return false;
      }
    }
    if (m_champApplicationEmployeur == null)
    {
      if (m_champApplicationEmployeur != null) {
        return false;
      }
    }
    else
    {
      if (m_champApplicationEmployeur == null) {
        return false;
      }
      if (!m_champApplicationEmployeur.equals(m_champApplicationEmployeur)) {
        return false;
      }
    }
    if (m_numConventionGestionEmpPublic == null)
    {
      if (m_numConventionGestionEmpPublic != null) {
        return false;
      }
    }
    else
    {
      if (m_numConventionGestionEmpPublic == null) {
        return false;
      }
      if (!m_numConventionGestionEmpPublic.equals(m_numConventionGestionEmpPublic)) {
        return false;
      }
    }
    if (m_etablissementFinancier == null)
    {
      if (m_etablissementFinancier != null) {
        return false;
      }
    }
    else
    {
      if (m_etablissementFinancier == null) {
        return false;
      }
      if (!m_etablissementFinancier.equals(m_etablissementFinancier)) {
        return false;
      }
    }
    if (m_codeAffectation == null)
    {
      if (m_codeAffectation != null) {
        return false;
      }
    }
    else
    {
      if (m_codeAffectation == null) {
        return false;
      }
      if (!m_codeAffectation.equals(m_codeAffectation)) {
        return false;
      }
    }
    if (m_numInterneEmpPublic == null)
    {
      if (m_numInterneEmpPublic != null) {
        return false;
      }
    }
    else
    {
      if (m_numInterneEmpPublic == null) {
        return false;
      }
      if (!m_numInterneEmpPublic.equals(m_numInterneEmpPublic)) {
        return false;
      }
    }
    if (m_statutSalarie == null)
    {
      if (m_statutSalarie != null) {
        return false;
      }
    }
    else
    {
      if (m_statutSalarie == null) {
        return false;
      }
      if (!m_statutSalarie.equals(m_statutSalarie)) {
        return false;
      }
    }
    if (m_dateAdhesion == null)
    {
      if (m_dateAdhesion != null) {
        return false;
      }
    }
    else
    {
      if (m_dateAdhesion == null) {
        return false;
      }
      if (!m_dateAdhesion.equals(m_dateAdhesion)) {
        return false;
      }
    }
    if (m_motifPeriodeInactivite == null)
    {
      if (m_motifPeriodeInactivite != null) {
        return false;
      }
    }
    else
    {
      if (m_motifPeriodeInactivite == null) {
        return false;
      }
      if (!m_motifPeriodeInactivite.equals(m_motifPeriodeInactivite)) {
        return false;
      }
    }
    if (m_dateDebutPeriodeInactivite == null)
    {
      if (m_dateDebutPeriodeInactivite != null) {
        return false;
      }
    }
    else
    {
      if (m_dateDebutPeriodeInactivite == null) {
        return false;
      }
      if (!m_dateDebutPeriodeInactivite.equals(m_dateDebutPeriodeInactivite)) {
        return false;
      }
    }
    if (m_dateFinPeriodeInactivite == null)
    {
      if (m_dateFinPeriodeInactivite != null) {
        return false;
      }
    }
    else
    {
      if (m_dateFinPeriodeInactivite == null) {
        return false;
      }
      if (!m_dateFinPeriodeInactivite.equals(m_dateFinPeriodeInactivite)) {
        return false;
      }
    }
    if (m_dateDebutPeriodeSalaire == null)
    {
      if (m_dateDebutPeriodeSalaire != null) {
        return false;
      }
    }
    else
    {
      if (m_dateDebutPeriodeSalaire == null) {
        return false;
      }
      if (!m_dateDebutPeriodeSalaire.equals(m_dateDebutPeriodeSalaire)) {
        return false;
      }
    }
    if (m_dateFinPeriodeSalaire == null)
    {
      if (m_dateFinPeriodeSalaire != null) {
        return false;
      }
    }
    else
    {
      if (m_dateFinPeriodeSalaire == null) {
        return false;
      }
      if (!m_dateFinPeriodeSalaire.equals(m_dateFinPeriodeSalaire)) {
        return false;
      }
    }
    if (m_codePcsEse == null)
    {
      if (m_codePcsEse != null) {
        return false;
      }
    }
    else
    {
      if (m_codePcsEse == null) {
        return false;
      }
      if (!m_codePcsEse.equals(m_codePcsEse)) {
        return false;
      }
    }
    if (m_codeComplementPcsEse == null)
    {
      if (m_codeComplementPcsEse != null) {
        return false;
      }
    }
    else
    {
      if (m_codeComplementPcsEse == null) {
        return false;
      }
      if (!m_codeComplementPcsEse.equals(m_codeComplementPcsEse)) {
        return false;
      }
    }
    if (m_signeSalaireBrutAbattu == null)
    {
      if (m_signeSalaireBrutAbattu != null) {
        return false;
      }
    }
    else
    {
      if (m_signeSalaireBrutAbattu == null) {
        return false;
      }
      if (!m_signeSalaireBrutAbattu.equals(m_signeSalaireBrutAbattu)) {
        return false;
      }
    }
    if (m_salaireBrutAbattu == null)
    {
      if (m_salaireBrutAbattu != null) {
        return false;
      }
    }
    else
    {
      if (m_salaireBrutAbattu == null) {
        return false;
      }
      if (!m_salaireBrutAbattu.equals(m_salaireBrutAbattu)) {
        return false;
      }
    }
    if (m_datePaiement == null)
    {
      if (m_datePaiement != null) {
        return false;
      }
    }
    else
    {
      if (m_datePaiement == null) {
        return false;
      }
      if (!m_datePaiement.equals(m_datePaiement)) {
        return false;
      }
    }
    if (m_dureeAbsence == null)
    {
      if (m_dureeAbsence != null) {
        return false;
      }
    }
    else
    {
      if (m_dureeAbsence == null) {
        return false;
      }
      if (!m_dureeAbsence.equals(m_dureeAbsence)) {
        return false;
      }
    }
    if (m_uniteAbsence == null)
    {
      if (m_uniteAbsence != null) {
        return false;
      }
    }
    else
    {
      if (m_uniteAbsence == null) {
        return false;
      }
      if (!m_uniteAbsence.equals(m_uniteAbsence)) {
        return false;
      }
    }
    if (m_nomLogiciel == null)
    {
      if (m_nomLogiciel != null) {
        return false;
      }
    }
    else
    {
      if (m_nomLogiciel == null) {
        return false;
      }
      if (!m_nomLogiciel.equals(m_nomLogiciel)) {
        return false;
      }
    }
    if (m_versionLogiciel == null)
    {
      if (m_versionLogiciel != null) {
        return false;
      }
    }
    else
    {
      if (m_versionLogiciel == null) {
        return false;
      }
      if (!m_versionLogiciel.equals(m_versionLogiciel)) {
        return false;
      }
    }
    if (m_numeroRCI == null)
    {
      if (m_numeroRCI != null) {
        return false;
      }
    }
    else
    {
      if (m_numeroRCI == null) {
        return false;
      }
      if (!m_numeroRCI.equals(m_numeroRCI)) {
        return false;
      }
    }
    if (m_cxass == null)
    {
      if (m_cxass != null) {
        return false;
      }
    }
    else
    {
      if (m_cxass == null) {
        return false;
      }
      if (!m_cxass.equals(m_cxass)) {
        return false;
      }
    }
    if (m_rsin == null)
    {
      if (m_rsin != null) {
        return false;
      }
    }
    else
    {
      if (m_rsin == null) {
        return false;
      }
      if (!m_rsin.equals(m_rsin)) {
        return false;
      }
    }
    if (m_nom == null)
    {
      if (m_nom != null) {
        return false;
      }
    }
    else
    {
      if (m_nom == null) {
        return false;
      }
      if (!m_nom.equals(m_nom)) {
        return false;
      }
    }
    if (m_prenom == null)
    {
      if (m_prenom != null) {
        return false;
      }
    }
    else
    {
      if (m_prenom == null) {
        return false;
      }
      if (!m_prenom.equals(m_prenom)) {
        return false;
      }
    }
    if (m_peAffi == null)
    {
      if (m_peAffi != null) {
        return false;
      }
    }
    else
    {
      if (m_peAffi == null) {
        return false;
      }
      if (!m_peAffi.equals(m_peAffi)) {
        return false;
      }
    }
    if (m_siret == null)
    {
      if (m_siret != null) {
        return false;
      }
    }
    else
    {
      if (m_siret == null) {
        return false;
      }
      if (!m_siret.equals(m_siret)) {
        return false;
      }
    }
    if (m_emplNumAffi == null)
    {
      if (m_emplNumAffi != null) {
        return false;
      }
    }
    else
    {
      if (m_emplNumAffi == null) {
        return false;
      }
      if (!m_emplNumAffi.equals(m_emplNumAffi)) {
        return false;
      }
    }
    if (m_emplRaisonSociale == null)
    {
      if (m_emplRaisonSociale != null) {
        return false;
      }
    }
    else
    {
      if (m_emplRaisonSociale == null) {
        return false;
      }
      if (!m_emplRaisonSociale.equals(m_emplRaisonSociale)) {
        return false;
      }
    }
    if (m_emplNAF == null)
    {
      if (m_emplNAF != null) {
        return false;
      }
    }
    else
    {
      if (m_emplNAF == null) {
        return false;
      }
      if (!m_emplNAF.equals(m_emplNAF)) {
        return false;
      }
    }
    if (m_emplCommune == null)
    {
      if (m_emplCommune != null) {
        return false;
      }
    }
    else
    {
      if (m_emplCommune == null) {
        return false;
      }
      if (!m_emplCommune.equals(m_emplCommune)) {
        return false;
      }
    }
    if (m_emplCP == null)
    {
      if (m_emplCP != null) {
        return false;
      }
    }
    else
    {
      if (m_emplCP == null) {
        return false;
      }
      if (!m_emplCP.equals(m_emplCP)) {
        return false;
      }
    }
    if (m_idBNEArrco == null)
    {
      if (m_idBNEArrco != null) {
        return false;
      }
    }
    else
    {
      if (m_idBNEArrco == null) {
        return false;
      }
      if (!m_idBNEArrco.equals(m_idBNEArrco)) {
        return false;
      }
    }
    if (m_arrcoSigle == null)
    {
      if (m_arrcoSigle != null) {
        return false;
      }
    }
    else
    {
      if (m_arrcoSigle == null) {
        return false;
      }
      if (!m_arrcoSigle.equals(m_arrcoSigle)) {
        return false;
      }
    }
    if (m_arrcoRaisonSociale == null)
    {
      if (m_arrcoRaisonSociale != null) {
        return false;
      }
    }
    else
    {
      if (m_arrcoRaisonSociale == null) {
        return false;
      }
      if (!m_arrcoRaisonSociale.equals(m_arrcoRaisonSociale)) {
        return false;
      }
    }
    if (m_idBNEAgirc == null)
    {
      if (m_idBNEAgirc != null) {
        return false;
      }
    }
    else
    {
      if (m_idBNEAgirc == null) {
        return false;
      }
      if (!m_idBNEAgirc.equals(m_idBNEAgirc)) {
        return false;
      }
    }
    if (m_agircSigle == null)
    {
      if (m_agircSigle != null) {
        return false;
      }
    }
    else
    {
      if (m_agircSigle == null) {
        return false;
      }
      if (!m_agircSigle.equals(m_agircSigle)) {
        return false;
      }
    }
    if (m_agircRaisonSociale == null)
    {
      if (m_agircRaisonSociale != null) {
        return false;
      }
    }
    else
    {
      if (m_agircRaisonSociale == null) {
        return false;
      }
      if (!m_agircRaisonSociale.equals(m_agircRaisonSociale)) {
        return false;
      }
    }
    if (m_codeRegimeCrpCtp == null)
    {
      if (m_codeRegimeCrpCtp != null) {
        return false;
      }
    }
    else
    {
      if (m_codeRegimeCrpCtp == null) {
        return false;
      }
      if (!m_codeRegimeCrpCtp.equals(m_codeRegimeCrpCtp)) {
        return false;
      }
    }
    if (m_dateEffetRegimeCrpCtp == null)
    {
      if (m_dateEffetRegimeCrpCtp != null) {
        return false;
      }
    }
    else
    {
      if (m_dateEffetRegimeCrpCtp == null) {
        return false;
      }
      if (!m_dateEffetRegimeCrpCtp.equals(m_dateEffetRegimeCrpCtp)) {
        return false;
      }
    }
    if (m_emplNumConventionGestion == null)
    {
      if (m_emplNumConventionGestion != null) {
        return false;
      }
    }
    else
    {
      if (m_emplNumConventionGestion == null) {
        return false;
      }
      if (!m_emplNumConventionGestion.equals(m_emplNumConventionGestion)) {
        return false;
      }
    }
    if (m_nbSalariesEntreprise == null)
    {
      if (m_nbSalariesEntreprise != null) {
        return false;
      }
    }
    else
    {
      if (m_nbSalariesEntreprise == null) {
        return false;
      }
      if (!m_nbSalariesEntreprise.equals(m_nbSalariesEntreprise)) {
        return false;
      }
    }
    if (m_nomEmployeur == null)
    {
      if (m_nomEmployeur != null) {
        return false;
      }
    }
    else
    {
      if (m_nomEmployeur == null) {
        return false;
      }
      if (!m_nomEmployeur.equals(m_nomEmployeur)) {
        return false;
      }
    }
    if (m_prenomEmployeur == null)
    {
      if (m_prenomEmployeur != null) {
        return false;
      }
    }
    else
    {
      if (m_prenomEmployeur == null) {
        return false;
      }
      if (!m_prenomEmployeur.equals(m_prenomEmployeur)) {
        return false;
      }
    }
    if (m_categorieJuridique == null)
    {
      if (m_categorieJuridique != null) {
        return false;
      }
    }
    else
    {
      if (m_categorieJuridique == null) {
        return false;
      }
      if (!m_categorieJuridique.equals(m_categorieJuridique)) {
        return false;
      }
    }
    if (m_codeRegimeEntreprise == null)
    {
      if (m_codeRegimeEntreprise != null) {
        return false;
      }
    }
    else
    {
      if (m_codeRegimeEntreprise == null) {
        return false;
      }
      if (!m_codeRegimeEntreprise.equals(m_codeRegimeEntreprise)) {
        return false;
      }
    }
    if (m_dateCessationEntreprise == null)
    {
      if (m_dateCessationEntreprise != null) {
        return false;
      }
    }
    else
    {
      if (m_dateCessationEntreprise == null) {
        return false;
      }
      if (!m_dateCessationEntreprise.equals(m_dateCessationEntreprise)) {
        return false;
      }
    }
    if (m_natureEntreprise == null)
    {
      if (m_natureEntreprise != null) {
        return false;
      }
    }
    else
    {
      if (m_natureEntreprise == null) {
        return false;
      }
      if (!m_natureEntreprise.equals(m_natureEntreprise)) {
        return false;
      }
    }
    if (m_numMSAEntreprise == null)
    {
      if (m_numMSAEntreprise != null) {
        return false;
      }
    }
    else
    {
      if (m_numMSAEntreprise == null) {
        return false;
      }
      if (!m_numMSAEntreprise.equals(m_numMSAEntreprise)) {
        return false;
      }
    }
    if (m_debutPeriodeAffiliationEntreprise == null)
    {
      if (m_debutPeriodeAffiliationEntreprise != null) {
        return false;
      }
    }
    else
    {
      if (m_debutPeriodeAffiliationEntreprise == null) {
        return false;
      }
      if (!m_debutPeriodeAffiliationEntreprise.equals(m_debutPeriodeAffiliationEntreprise)) {
        return false;
      }
    }
    if (m_finPeriodeAffiliationEntreprise == null)
    {
      if (m_finPeriodeAffiliationEntreprise != null) {
        return false;
      }
    }
    else
    {
      if (m_finPeriodeAffiliationEntreprise == null) {
        return false;
      }
      if (!m_finPeriodeAffiliationEntreprise.equals(m_finPeriodeAffiliationEntreprise)) {
        return false;
      }
    }
    if (m_debutConventionGestion == null)
    {
      if (m_debutConventionGestion != null) {
        return false;
      }
    }
    else
    {
      if (m_debutConventionGestion == null) {
        return false;
      }
      if (!m_debutConventionGestion.equals(m_debutConventionGestion)) {
        return false;
      }
    }
    if (m_finConventionGestion == null)
    {
      if (m_finConventionGestion != null) {
        return false;
      }
    }
    else
    {
      if (m_finConventionGestion == null) {
        return false;
      }
      if (!m_finConventionGestion.equals(m_finConventionGestion)) {
        return false;
      }
    }
    if (m_secteurPublic == null)
    {
      if (m_secteurPublic != null) {
        return false;
      }
    }
    else
    {
      if (m_secteurPublic == null) {
        return false;
      }
      if (!m_secteurPublic.equals(m_secteurPublic)) {
        return false;
      }
    }
    if (m_trancheEffectifEntreprise == null)
    {
      if (m_trancheEffectifEntreprise != null) {
        return false;
      }
    }
    else
    {
      if (m_trancheEffectifEntreprise == null) {
        return false;
      }
      if (!m_trancheEffectifEntreprise.equals(m_trancheEffectifEntreprise)) {
        return false;
      }
    }
    if (m_debutAGS == null)
    {
      if (m_debutAGS != null) {
        return false;
      }
    }
    else
    {
      if (m_debutAGS == null) {
        return false;
      }
      if (!m_debutAGS.equals(m_debutAGS)) {
        return false;
      }
    }
    if (m_finAGS == null)
    {
      if (m_finAGS != null) {
        return false;
      }
    }
    else
    {
      if (m_finAGS == null) {
        return false;
      }
      if (!m_finAGS.equals(m_finAGS)) {
        return false;
      }
    }
    if (m_debutAdhesionRevocable == null)
    {
      if (m_debutAdhesionRevocable != null) {
        return false;
      }
    }
    else
    {
      if (m_debutAdhesionRevocable == null) {
        return false;
      }
      if (!m_debutAdhesionRevocable.equals(m_debutAdhesionRevocable)) {
        return false;
      }
    }
    if (m_finAdhesionRevocable == null)
    {
      if (m_finAdhesionRevocable != null) {
        return false;
      }
    }
    else
    {
      if (m_finAdhesionRevocable == null) {
        return false;
      }
      if (!m_finAdhesionRevocable.equals(m_finAdhesionRevocable)) {
        return false;
      }
    }
    if (m_listeFluxQuantiteTravailDsn == null)
    {
      if (m_listeFluxQuantiteTravailDsn != null) {
        return false;
      }
    }
    else
    {
      if (m_listeFluxQuantiteTravailDsn == null) {
        return false;
      }
      if (!m_listeFluxQuantiteTravailDsn.equals(m_listeFluxQuantiteTravailDsn)) {
        return false;
      }
    }
    if (m_motifFinContrat == null)
    {
      if (m_motifFinContrat != null) {
        return false;
      }
    }
    else
    {
      if (m_motifFinContrat == null) {
        return false;
      }
      if (!m_motifFinContrat.equals(m_motifFinContrat)) {
        return false;
      }
    }
    if (m_dateInitialeFinContrat == null)
    {
      if (m_dateInitialeFinContrat != null) {
        return false;
      }
    }
    else
    {
      if (m_dateInitialeFinContrat == null) {
        return false;
      }
      if (!m_dateInitialeFinContrat.equals(m_dateInitialeFinContrat)) {
        return false;
      }
    }
    if (m_idActiviteDsnPe == null)
    {
      if (m_idActiviteDsnPe != null) {
        return false;
      }
    }
    else
    {
      if (m_idActiviteDsnPe == null) {
        return false;
      }
      if (!m_idActiviteDsnPe.equals(m_idActiviteDsnPe)) {
        return false;
      }
    }
    if (m_signeDureeAbsence == null)
    {
      if (m_signeDureeAbsence != null) {
        return false;
      }
    }
    else
    {
      if (m_signeDureeAbsence == null) {
        return false;
      }
      if (!m_signeDureeAbsence.equals(m_signeDureeAbsence)) {
        return false;
      }
    }
    if (m_listeFluxPrimeIndemDsn == null)
    {
      if (m_listeFluxPrimeIndemDsn != null) {
        return false;
      }
    }
    else
    {
      if (m_listeFluxPrimeIndemDsn == null) {
        return false;
      }
      if (!m_listeFluxPrimeIndemDsn.equals(m_listeFluxPrimeIndemDsn)) {
        return false;
      }
    }
    if (m_identDeclPri == null)
    {
      if (m_identDeclPri != null) {
        return false;
      }
    }
    else
    {
      if (m_identDeclPri == null) {
        return false;
      }
      if (!m_identDeclPri.equals(m_identDeclPri)) {
        return false;
      }
    }
    if (m_identDeclSec == null)
    {
      if (m_identDeclSec != null) {
        return false;
      }
    }
    else
    {
      if (m_identDeclSec == null) {
        return false;
      }
      if (!m_identDeclSec.equals(m_identDeclSec)) {
        return false;
      }
    }
    if (m_motifRecours == null)
    {
      if (m_motifRecours != null) {
        return false;
      }
    }
    else
    {
      if (m_motifRecours == null) {
        return false;
      }
      if (!m_motifRecours.equals(m_motifRecours)) {
        return false;
      }
    }
    if (m_modaliteDeclarativeFinContrat == null)
    {
      if (m_modaliteDeclarativeFinContrat != null) {
        return false;
      }
    }
    else
    {
      if (m_modaliteDeclarativeFinContrat == null) {
        return false;
      }
      if (!m_modaliteDeclarativeFinContrat.equals(m_modaliteDeclarativeFinContrat)) {
        return false;
      }
    }
    if (m_djtp == null)
    {
      if (m_djtp != null) {
        return false;
      }
    }
    else
    {
      if (m_djtp == null) {
        return false;
      }
      if (!m_djtp.equals(m_djtp)) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int result = 0;
    if (m_typeEnreg != null) {
      result += m_typeEnreg.hashCode();
    }
    if (m_numNIRCertifie != null) {
      result += m_numNIRCertifie.hashCode();
    }
    if (m_nomDeclare != null) {
      result += m_nomDeclare.hashCode();
    }
    if (m_prenomDeclare != null) {
      result += m_prenomDeclare.hashCode();
    }
    if (m_dateNaissance != null) {
      result += m_dateNaissance.hashCode();
    }
    if (m_contexteEmission != null) {
      result += m_contexteEmission.hashCode();
    }
    if (m_natureJustificatif != null) {
      result += m_natureJustificatif.hashCode();
    }
    if (m_codeMessage != null) {
      result += m_codeMessage.hashCode();
    }
    if (m_numeroVersion != null) {
      result += m_numeroVersion.hashCode();
    }
    if (m_numeroSousVersion != null) {
      result += m_numeroSousVersion.hashCode();
    }
    if (m_codeAction != null) {
      result += m_codeAction.hashCode();
    }
    if (m_idTechnique != null) {
      result += m_idTechnique.hashCode();
    }
    if (m_idRCE != null) {
      result += m_idRCE.hashCode();
    }
    if (m_siretDeclare != null) {
      result += m_siretDeclare.hashCode();
    }
    if (m_refContratEmployeur != null) {
      result += m_refContratEmployeur.hashCode();
    }
    if (m_nbMessagesPrimesIndemnites != null) {
      result += m_nbMessagesPrimesIndemnites.hashCode();
    }
    if (m_dateConnaissanceMensuelle != null) {
      result += m_dateConnaissanceMensuelle.hashCode();
    }
    if (m_dateMoisDeclare != null) {
      result += m_dateMoisDeclare.hashCode();
    }
    if (m_dateDebutContrat != null) {
      result += m_dateDebutContrat.hashCode();
    }
    if (m_dateFinContrat != null) {
      result += m_dateFinContrat.hashCode();
    }
    if (m_natureContrat != null) {
      result += m_natureContrat.hashCode();
    }
    if (m_typeContrat != null) {
      result += m_typeContrat.hashCode();
    }
    if (m_codeStatutCadre != null) {
      result += m_codeStatutCadre.hashCode();
    }
    if (m_horaireSalarie != null) {
      result += m_horaireSalarie.hashCode();
    }
    if (m_horaireEntreprise != null) {
      result += m_horaireEntreprise.hashCode();
    }
    if (m_uniteTempsTravail != null) {
      result += m_uniteTempsTravail.hashCode();
    }
    if (m_alsaceMoselle != null) {
      result += m_alsaceMoselle.hashCode();
    }
    if (m_regimeSpecialSecuriteSoc != null) {
      result += m_regimeSpecialSecuriteSoc.hashCode();
    }
    if (m_typeCaisseCP != null) {
      result += m_typeCaisseCP.hashCode();
    }
    if (m_niveauQualification != null) {
      result += m_niveauQualification.hashCode();
    }
    if (m_codeCaisseRetraiteCompl != null) {
      result += m_codeCaisseRetraiteCompl.hashCode();
    }
    if (m_champApplicationEmployeur != null) {
      result += m_champApplicationEmployeur.hashCode();
    }
    if (m_numConventionGestionEmpPublic != null) {
      result += m_numConventionGestionEmpPublic.hashCode();
    }
    if (m_etablissementFinancier != null) {
      result += m_etablissementFinancier.hashCode();
    }
    if (m_codeAffectation != null) {
      result += m_codeAffectation.hashCode();
    }
    if (m_numInterneEmpPublic != null) {
      result += m_numInterneEmpPublic.hashCode();
    }
    if (m_statutSalarie != null) {
      result += m_statutSalarie.hashCode();
    }
    if (m_dateAdhesion != null) {
      result += m_dateAdhesion.hashCode();
    }
    if (m_motifPeriodeInactivite != null) {
      result += m_motifPeriodeInactivite.hashCode();
    }
    if (m_dateDebutPeriodeInactivite != null) {
      result += m_dateDebutPeriodeInactivite.hashCode();
    }
    if (m_dateFinPeriodeInactivite != null) {
      result += m_dateFinPeriodeInactivite.hashCode();
    }
    if (m_dateDebutPeriodeSalaire != null) {
      result += m_dateDebutPeriodeSalaire.hashCode();
    }
    if (m_dateFinPeriodeSalaire != null) {
      result += m_dateFinPeriodeSalaire.hashCode();
    }
    if (m_codePcsEse != null) {
      result += m_codePcsEse.hashCode();
    }
    if (m_codeComplementPcsEse != null) {
      result += m_codeComplementPcsEse.hashCode();
    }
    if (m_signeSalaireBrutAbattu != null) {
      result += m_signeSalaireBrutAbattu.hashCode();
    }
    if (m_salaireBrutAbattu != null) {
      result += m_salaireBrutAbattu.hashCode();
    }
    if (m_datePaiement != null) {
      result += m_datePaiement.hashCode();
    }
    if (m_dureeAbsence != null) {
      result += m_dureeAbsence.hashCode();
    }
    if (m_uniteAbsence != null) {
      result += m_uniteAbsence.hashCode();
    }
    if (m_nomLogiciel != null) {
      result += m_nomLogiciel.hashCode();
    }
    if (m_versionLogiciel != null) {
      result += m_versionLogiciel.hashCode();
    }
    if (m_numeroRCI != null) {
      result += m_numeroRCI.hashCode();
    }
    if (m_cxass != null) {
      result += m_cxass.hashCode();
    }
    if (m_rsin != null) {
      result += m_rsin.hashCode();
    }
    if (m_nom != null) {
      result += m_nom.hashCode();
    }
    if (m_prenom != null) {
      result += m_prenom.hashCode();
    }
    if (m_peAffi != null) {
      result += m_peAffi.hashCode();
    }
    if (m_siret != null) {
      result += m_siret.hashCode();
    }
    if (m_emplNumAffi != null) {
      result += m_emplNumAffi.hashCode();
    }
    if (m_emplRaisonSociale != null) {
      result += m_emplRaisonSociale.hashCode();
    }
    if (m_emplNAF != null) {
      result += m_emplNAF.hashCode();
    }
    if (m_emplCommune != null) {
      result += m_emplCommune.hashCode();
    }
    if (m_emplCP != null) {
      result += m_emplCP.hashCode();
    }
    if (m_idBNEArrco != null) {
      result += m_idBNEArrco.hashCode();
    }
    if (m_arrcoSigle != null) {
      result += m_arrcoSigle.hashCode();
    }
    if (m_arrcoRaisonSociale != null) {
      result += m_arrcoRaisonSociale.hashCode();
    }
    if (m_idBNEAgirc != null) {
      result += m_idBNEAgirc.hashCode();
    }
    if (m_agircSigle != null) {
      result += m_agircSigle.hashCode();
    }
    if (m_agircRaisonSociale != null) {
      result += m_agircRaisonSociale.hashCode();
    }
    if (m_codeRegimeCrpCtp != null) {
      result += m_codeRegimeCrpCtp.hashCode();
    }
    if (m_dateEffetRegimeCrpCtp != null) {
      result += m_dateEffetRegimeCrpCtp.hashCode();
    }
    if (m_emplNumConventionGestion != null) {
      result += m_emplNumConventionGestion.hashCode();
    }
    if (m_nbSalariesEntreprise != null) {
      result += m_nbSalariesEntreprise.hashCode();
    }
    if (m_nomEmployeur != null) {
      result += m_nomEmployeur.hashCode();
    }
    if (m_prenomEmployeur != null) {
      result += m_prenomEmployeur.hashCode();
    }
    if (m_categorieJuridique != null) {
      result += m_categorieJuridique.hashCode();
    }
    if (m_codeRegimeEntreprise != null) {
      result += m_codeRegimeEntreprise.hashCode();
    }
    if (m_dateCessationEntreprise != null) {
      result += m_dateCessationEntreprise.hashCode();
    }
    if (m_natureEntreprise != null) {
      result += m_natureEntreprise.hashCode();
    }
    if (m_numMSAEntreprise != null) {
      result += m_numMSAEntreprise.hashCode();
    }
    if (m_debutPeriodeAffiliationEntreprise != null) {
      result += m_debutPeriodeAffiliationEntreprise.hashCode();
    }
    if (m_finPeriodeAffiliationEntreprise != null) {
      result += m_finPeriodeAffiliationEntreprise.hashCode();
    }
    if (m_debutConventionGestion != null) {
      result += m_debutConventionGestion.hashCode();
    }
    if (m_finConventionGestion != null) {
      result += m_finConventionGestion.hashCode();
    }
    if (m_secteurPublic != null) {
      result += m_secteurPublic.hashCode();
    }
    if (m_trancheEffectifEntreprise != null) {
      result += m_trancheEffectifEntreprise.hashCode();
    }
    if (m_debutAGS != null) {
      result += m_debutAGS.hashCode();
    }
    if (m_finAGS != null) {
      result += m_finAGS.hashCode();
    }
    if (m_debutAdhesionRevocable != null) {
      result += m_debutAdhesionRevocable.hashCode();
    }
    if (m_finAdhesionRevocable != null) {
      result += m_finAdhesionRevocable.hashCode();
    }
    if (m_listeFluxQuantiteTravailDsn != null) {
      result += m_listeFluxQuantiteTravailDsn.hashCode();
    }
    if (m_motifFinContrat != null) {
      result += m_motifFinContrat.hashCode();
    }
    if (m_dateInitialeFinContrat != null) {
      result += m_dateInitialeFinContrat.hashCode();
    }
    if (m_idActiviteDsnPe != null) {
      result += m_idActiviteDsnPe.hashCode();
    }
    if (m_signeDureeAbsence != null) {
      result += m_signeDureeAbsence.hashCode();
    }
    if (m_listeFluxPrimeIndemDsn != null) {
      result += m_listeFluxPrimeIndemDsn.hashCode();
    }
    if (m_identDeclPri != null) {
      result += m_identDeclPri.hashCode();
    }
    if (m_identDeclSec != null) {
      result += m_identDeclSec.hashCode();
    }
    if (m_motifRecours != null) {
      result += m_motifRecours.hashCode();
    }
    if (m_modaliteDeclarativeFinContrat != null) {
      result += m_modaliteDeclarativeFinContrat.hashCode();
    }
    if (m_djtp != null) {
      result += m_djtp.hashCode();
    }
    result *= 17;
    return result;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    _FluxCtPasDsn clone_FluxCtPasDsn = new _FluxCtPasDsn();
    clone_FluxCtPasDsn.populateFrom_FluxCtPasDsn(this);
    return clone_FluxCtPasDsn;
  }
  
  public void populateFrom_FluxCtPasDsn(_FluxCtPasDsn pSource)
  {
    setTypeEnreg(pSource.getTypeEnreg());setNumNIRCertifie(pSource.getNumNIRCertifie());setNomDeclare(pSource.getNomDeclare());setPrenomDeclare(pSource.getPrenomDeclare());setDateNaissance(pSource.getDateNaissance());setContexteEmission(pSource.getContexteEmission());setNatureJustificatif(pSource.getNatureJustificatif());setCodeMessage(pSource.getCodeMessage());setNumeroVersion(pSource.getNumeroVersion());setNumeroSousVersion(pSource.getNumeroSousVersion());setCodeAction(pSource.getCodeAction());setIdTechnique(pSource.getIdTechnique());setIdRCE(pSource.getIdRCE());setSiretDeclare(pSource.getSiretDeclare());setRefContratEmployeur(pSource.getRefContratEmployeur());setNbMessagesPrimesIndemnites(pSource.getNbMessagesPrimesIndemnites());setDateConnaissanceMensuelle(pSource.getDateConnaissanceMensuelle());setDateMoisDeclare(pSource.getDateMoisDeclare());setDateDebutContrat(pSource.getDateDebutContrat());setDateFinContrat(pSource.getDateFinContrat());setNatureContrat(pSource.getNatureContrat());setTypeContrat(pSource.getTypeContrat());setCodeStatutCadre(pSource.getCodeStatutCadre());setHoraireSalarie(pSource.getHoraireSalarie());setHoraireEntreprise(pSource.getHoraireEntreprise());setUniteTempsTravail(pSource.getUniteTempsTravail());setAlsaceMoselle(pSource.getAlsaceMoselle());setRegimeSpecialSecuriteSoc(pSource.getRegimeSpecialSecuriteSoc());setTypeCaisseCP(pSource.getTypeCaisseCP());setNiveauQualification(pSource.getNiveauQualification());setCodeCaisseRetraiteCompl(pSource.getCodeCaisseRetraiteCompl());setChampApplicationEmployeur(pSource.getChampApplicationEmployeur());setNumConventionGestionEmpPublic(pSource.getNumConventionGestionEmpPublic());setEtablissementFinancier(pSource.getEtablissementFinancier());setCodeAffectation(pSource.getCodeAffectation());setNumInterneEmpPublic(pSource.getNumInterneEmpPublic());setStatutSalarie(pSource.getStatutSalarie());setDateAdhesion(pSource.getDateAdhesion());setMotifPeriodeInactivite(pSource.getMotifPeriodeInactivite());setDateDebutPeriodeInactivite(pSource.getDateDebutPeriodeInactivite());setDateFinPeriodeInactivite(pSource.getDateFinPeriodeInactivite());setDateDebutPeriodeSalaire(pSource.getDateDebutPeriodeSalaire());setDateFinPeriodeSalaire(pSource.getDateFinPeriodeSalaire());setCodePcsEse(pSource.getCodePcsEse());setCodeComplementPcsEse(pSource.getCodeComplementPcsEse());setSigneSalaireBrutAbattu(pSource.getSigneSalaireBrutAbattu());setSalaireBrutAbattu(pSource.getSalaireBrutAbattu());setDatePaiement(pSource.getDatePaiement());setDureeAbsence(pSource.getDureeAbsence());setUniteAbsence(pSource.getUniteAbsence());setNomLogiciel(pSource.getNomLogiciel());setVersionLogiciel(pSource.getVersionLogiciel());setNumeroRCI(pSource.getNumeroRCI());setCxass(pSource.getCxass());setRsin(pSource.getRsin());setNom(pSource.getNom());setPrenom(pSource.getPrenom());setPeAffi(pSource.getPeAffi());setSiret(pSource.getSiret());setEmplNumAffi(pSource.getEmplNumAffi());setEmplRaisonSociale(pSource.getEmplRaisonSociale());setEmplNAF(pSource.getEmplNAF());setEmplCommune(pSource.getEmplCommune());setEmplCP(pSource.getEmplCP());setIdBNEArrco(pSource.getIdBNEArrco());setArrcoSigle(pSource.getArrcoSigle());setArrcoRaisonSociale(pSource.getArrcoRaisonSociale());setIdBNEAgirc(pSource.getIdBNEAgirc());setAgircSigle(pSource.getAgircSigle());setAgircRaisonSociale(pSource.getAgircRaisonSociale());setCodeRegimeCrpCtp(pSource.getCodeRegimeCrpCtp());setDateEffetRegimeCrpCtp(pSource.getDateEffetRegimeCrpCtp());setEmplNumConventionGestion(pSource.getEmplNumConventionGestion());setNbSalariesEntreprise(pSource.getNbSalariesEntreprise());setNomEmployeur(pSource.getNomEmployeur());setPrenomEmployeur(pSource.getPrenomEmployeur());setCategorieJuridique(pSource.getCategorieJuridique());setCodeRegimeEntreprise(pSource.getCodeRegimeEntreprise());setDateCessationEntreprise(pSource.getDateCessationEntreprise());setNatureEntreprise(pSource.getNatureEntreprise());setNumMSAEntreprise(pSource.getNumMSAEntreprise());setDebutPeriodeAffiliationEntreprise(pSource.getDebutPeriodeAffiliationEntreprise());setFinPeriodeAffiliationEntreprise(pSource.getFinPeriodeAffiliationEntreprise());setDebutConventionGestion(pSource.getDebutConventionGestion());setFinConventionGestion(pSource.getFinConventionGestion());setSecteurPublic(pSource.getSecteurPublic());setTrancheEffectifEntreprise(pSource.getTrancheEffectifEntreprise());setDebutAGS(pSource.getDebutAGS());setFinAGS(pSource.getFinAGS());setDebutAdhesionRevocable(pSource.getDebutAdhesionRevocable());setFinAdhesionRevocable(pSource.getFinAdhesionRevocable());setListeFluxQuantiteTravailDsn(pSource.getListeFluxQuantiteTravailDsn());setMotifFinContrat(pSource.getMotifFinContrat());setDateInitialeFinContrat(pSource.getDateInitialeFinContrat());setIdActiviteDsnPe(pSource.getIdActiviteDsnPe());setSigneDureeAbsence(pSource.getSigneDureeAbsence());setListeFluxPrimeIndemDsn(pSource.getListeFluxPrimeIndemDsn());setIdentDeclPri(pSource.getIdentDeclPri());setIdentDeclSec(pSource.getIdentDeclSec());setMotifRecours(pSource.getMotifRecours());setModaliteDeclarativeFinContrat(pSource.getModaliteDeclarativeFinContrat());setDjtp(pSource.getDjtp());
  }
  
  public String toString()
  {
    StringBuffer s = new StringBuffer("[_FluxCtPasDsn");
    subToString(s);
    s.append("]");
    return s.toString();
  }
  
  protected void subToString(StringBuffer pSource)
  {
    pSource.append(", typeEnreg: ");
    pSource.append(m_typeEnreg);
    pSource.append(", numNIRCertifie: ");
    pSource.append(m_numNIRCertifie);
    pSource.append(", nomDeclare: ");
    pSource.append(m_nomDeclare);
    pSource.append(", prenomDeclare: ");
    pSource.append(m_prenomDeclare);
    pSource.append(", dateNaissance: ");
    pSource.append(m_dateNaissance);
    pSource.append(", contexteEmission: ");
    pSource.append(m_contexteEmission);
    pSource.append(", natureJustificatif: ");
    pSource.append(m_natureJustificatif);
    pSource.append(", codeMessage: ");
    pSource.append(m_codeMessage);
    pSource.append(", numeroVersion: ");
    pSource.append(m_numeroVersion);
    pSource.append(", numeroSousVersion: ");
    pSource.append(m_numeroSousVersion);
    pSource.append(", codeAction: ");
    pSource.append(m_codeAction);
    pSource.append(", idTechnique: ");
    pSource.append(m_idTechnique);
    pSource.append(", idRCE: ");
    pSource.append(m_idRCE);
    pSource.append(", siretDeclare: ");
    pSource.append(m_siretDeclare);
    pSource.append(", refContratEmployeur: ");
    pSource.append(m_refContratEmployeur);
    pSource.append(", nbMessagesPrimesIndemnites: ");
    pSource.append(m_nbMessagesPrimesIndemnites);
    pSource.append(", dateConnaissanceMensuelle: ");
    pSource.append(m_dateConnaissanceMensuelle);
    pSource.append(", dateMoisDeclare: ");
    pSource.append(m_dateMoisDeclare);
    pSource.append(", dateDebutContrat: ");
    pSource.append(m_dateDebutContrat);
    pSource.append(", dateFinContrat: ");
    pSource.append(m_dateFinContrat);
    pSource.append(", natureContrat: ");
    pSource.append(m_natureContrat);
    pSource.append(", typeContrat: ");
    pSource.append(m_typeContrat);
    pSource.append(", codeStatutCadre: ");
    pSource.append(m_codeStatutCadre);
    pSource.append(", horaireSalarie: ");
    pSource.append(m_horaireSalarie);
    pSource.append(", horaireEntreprise: ");
    pSource.append(m_horaireEntreprise);
    pSource.append(", uniteTempsTravail: ");
    pSource.append(m_uniteTempsTravail);
    pSource.append(", alsaceMoselle: ");
    pSource.append(m_alsaceMoselle);
    pSource.append(", regimeSpecialSecuriteSoc: ");
    pSource.append(m_regimeSpecialSecuriteSoc);
    pSource.append(", typeCaisseCP: ");
    pSource.append(m_typeCaisseCP);
    pSource.append(", niveauQualification: ");
    pSource.append(m_niveauQualification);
    pSource.append(", codeCaisseRetraiteCompl: ");
    pSource.append(m_codeCaisseRetraiteCompl);
    pSource.append(", champApplicationEmployeur: ");
    pSource.append(m_champApplicationEmployeur);
    pSource.append(", numConventionGestionEmpPublic: ");
    pSource.append(m_numConventionGestionEmpPublic);
    pSource.append(", etablissementFinancier: ");
    pSource.append(m_etablissementFinancier);
    pSource.append(", codeAffectation: ");
    pSource.append(m_codeAffectation);
    pSource.append(", numInterneEmpPublic: ");
    pSource.append(m_numInterneEmpPublic);
    pSource.append(", statutSalarie: ");
    pSource.append(m_statutSalarie);
    pSource.append(", dateAdhesion: ");
    pSource.append(m_dateAdhesion);
    pSource.append(", motifPeriodeInactivite: ");
    pSource.append(m_motifPeriodeInactivite);
    pSource.append(", dateDebutPeriodeInactivite: ");
    pSource.append(m_dateDebutPeriodeInactivite);
    pSource.append(", dateFinPeriodeInactivite: ");
    pSource.append(m_dateFinPeriodeInactivite);
    pSource.append(", dateDebutPeriodeSalaire: ");
    pSource.append(m_dateDebutPeriodeSalaire);
    pSource.append(", dateFinPeriodeSalaire: ");
    pSource.append(m_dateFinPeriodeSalaire);
    pSource.append(", codePcsEse: ");
    pSource.append(m_codePcsEse);
    pSource.append(", codeComplementPcsEse: ");
    pSource.append(m_codeComplementPcsEse);
    pSource.append(", signeSalaireBrutAbattu: ");
    pSource.append(m_signeSalaireBrutAbattu);
    pSource.append(", salaireBrutAbattu: ");
    pSource.append(m_salaireBrutAbattu);
    pSource.append(", datePaiement: ");
    pSource.append(m_datePaiement);
    pSource.append(", dureeAbsence: ");
    pSource.append(m_dureeAbsence);
    pSource.append(", uniteAbsence: ");
    pSource.append(m_uniteAbsence);
    pSource.append(", nomLogiciel: ");
    pSource.append(m_nomLogiciel);
    pSource.append(", versionLogiciel: ");
    pSource.append(m_versionLogiciel);
    pSource.append(", numeroRCI: ");
    pSource.append(m_numeroRCI);
    pSource.append(", cxass: ");
    pSource.append(m_cxass);
    pSource.append(", rsin: ");
    pSource.append(m_rsin);
    pSource.append(", nom: ");
    pSource.append(m_nom);
    pSource.append(", prenom: ");
    pSource.append(m_prenom);
    pSource.append(", peAffi: ");
    pSource.append(m_peAffi);
    pSource.append(", siret: ");
    pSource.append(m_siret);
    pSource.append(", emplNumAffi: ");
    pSource.append(m_emplNumAffi);
    pSource.append(", emplRaisonSociale: ");
    pSource.append(m_emplRaisonSociale);
    pSource.append(", emplNAF: ");
    pSource.append(m_emplNAF);
    pSource.append(", emplCommune: ");
    pSource.append(m_emplCommune);
    pSource.append(", emplCP: ");
    pSource.append(m_emplCP);
    pSource.append(", idBNEArrco: ");
    pSource.append(m_idBNEArrco);
    pSource.append(", arrcoSigle: ");
    pSource.append(m_arrcoSigle);
    pSource.append(", arrcoRaisonSociale: ");
    pSource.append(m_arrcoRaisonSociale);
    pSource.append(", idBNEAgirc: ");
    pSource.append(m_idBNEAgirc);
    pSource.append(", agircSigle: ");
    pSource.append(m_agircSigle);
    pSource.append(", agircRaisonSociale: ");
    pSource.append(m_agircRaisonSociale);
    pSource.append(", codeRegimeCrpCtp: ");
    pSource.append(m_codeRegimeCrpCtp);
    pSource.append(", dateEffetRegimeCrpCtp: ");
    pSource.append(m_dateEffetRegimeCrpCtp);
    pSource.append(", emplNumConventionGestion: ");
    pSource.append(m_emplNumConventionGestion);
    pSource.append(", nbSalariesEntreprise: ");
    pSource.append(m_nbSalariesEntreprise);
    pSource.append(", nomEmployeur: ");
    pSource.append(m_nomEmployeur);
    pSource.append(", prenomEmployeur: ");
    pSource.append(m_prenomEmployeur);
    pSource.append(", categorieJuridique: ");
    pSource.append(m_categorieJuridique);
    pSource.append(", codeRegimeEntreprise: ");
    pSource.append(m_codeRegimeEntreprise);
    pSource.append(", dateCessationEntreprise: ");
    pSource.append(m_dateCessationEntreprise);
    pSource.append(", natureEntreprise: ");
    pSource.append(m_natureEntreprise);
    pSource.append(", numMSAEntreprise: ");
    pSource.append(m_numMSAEntreprise);
    pSource.append(", debutPeriodeAffiliationEntreprise: ");
    pSource.append(m_debutPeriodeAffiliationEntreprise);
    pSource.append(", finPeriodeAffiliationEntreprise: ");
    pSource.append(m_finPeriodeAffiliationEntreprise);
    pSource.append(", debutConventionGestion: ");
    pSource.append(m_debutConventionGestion);
    pSource.append(", finConventionGestion: ");
    pSource.append(m_finConventionGestion);
    pSource.append(", secteurPublic: ");
    pSource.append(m_secteurPublic);
    pSource.append(", trancheEffectifEntreprise: ");
    pSource.append(m_trancheEffectifEntreprise);
    pSource.append(", debutAGS: ");
    pSource.append(m_debutAGS);
    pSource.append(", finAGS: ");
    pSource.append(m_finAGS);
    pSource.append(", debutAdhesionRevocable: ");
    pSource.append(m_debutAdhesionRevocable);
    pSource.append(", finAdhesionRevocable: ");
    pSource.append(m_finAdhesionRevocable);
    pSource.append(", ListeFluxQuantiteTravailDsn: ");
    pSource.append(m_listeFluxQuantiteTravailDsn);
    pSource.append(", motifFinContrat: ");
    pSource.append(m_motifFinContrat);
    pSource.append(", dateInitialeFinContrat: ");
    pSource.append(m_dateInitialeFinContrat);
    pSource.append(", idActiviteDsnPe: ");
    pSource.append(m_idActiviteDsnPe);
    pSource.append(", signeDureeAbsence: ");
    pSource.append(m_signeDureeAbsence);
    pSource.append(", ListeFluxPrimeIndemDsn: ");
    pSource.append(m_listeFluxPrimeIndemDsn);
    pSource.append(", identDeclPri: ");
    pSource.append(m_identDeclPri);
    pSource.append(", identDeclSec: ");
    pSource.append(m_identDeclSec);
    pSource.append(", motifRecours: ");
    pSource.append(m_motifRecours);
    pSource.append(", modaliteDeclarativeFinContrat: ");
    pSource.append(m_modaliteDeclarativeFinContrat);
    pSource.append(", djtp: ");
    pSource.append(m_djtp);
  }
  
  public void goThrough(GettersHandler pHandler)
    throws Exception
  {
    pHandler.startGoThrough(new Attribute[] { new StringAttribute("C_ETAT", get_C_ETAT()), new StringAttribute("IDENT", get_IDENT()) });
    
    subGoThrough(pHandler);
    
    pHandler.endGoThrough();
  }
  
  protected void subGoThrough(GettersHandler pHandler)
    throws Exception
  {
    pHandler.property("typeEnreg", getTypeEnreg(), new Attribute[] { new StringAttribute("C_ERR", getTypeEnreg_C_ERR()) });
    
    pHandler.property("numNIRCertifie", getNumNIRCertifie(), new Attribute[] { new StringAttribute("C_ERR", getNumNIRCertifie_C_ERR()) });
    
    pHandler.property("nomDeclare", getNomDeclare(), new Attribute[] { new StringAttribute("C_ERR", getNomDeclare_C_ERR()) });
    
    pHandler.property("prenomDeclare", getPrenomDeclare(), new Attribute[] { new StringAttribute("C_ERR", getPrenomDeclare_C_ERR()) });
    
    pHandler.property("dateNaissance", getDateNaissance(), new Attribute[] { new StringAttribute("C_ERR", getDateNaissance_C_ERR()) });
    
    pHandler.property("contexteEmission", getContexteEmission(), new Attribute[] { new StringAttribute("C_ERR", getContexteEmission_C_ERR()) });
    
    pHandler.property("natureJustificatif", getNatureJustificatif(), new Attribute[] { new StringAttribute("C_ERR", getNatureJustificatif_C_ERR()) });
    
    pHandler.property("codeMessage", getCodeMessage(), new Attribute[] { new StringAttribute("C_ERR", getCodeMessage_C_ERR()) });
    
    pHandler.property("numeroVersion", getNumeroVersion(), new Attribute[] { new StringAttribute("C_ERR", getNumeroVersion_C_ERR()) });
    
    pHandler.property("numeroSousVersion", getNumeroSousVersion(), new Attribute[] { new StringAttribute("C_ERR", getNumeroSousVersion_C_ERR()) });
    
    pHandler.property("codeAction", getCodeAction(), new Attribute[] { new StringAttribute("C_ERR", getCodeAction_C_ERR()) });
    
    pHandler.property("idTechnique", getIdTechnique(), new Attribute[] { new StringAttribute("C_ERR", getIdTechnique_C_ERR()) });
    
    pHandler.property("idRCE", getIdRCE(), new Attribute[] { new StringAttribute("C_ERR", getIdRCE_C_ERR()) });
    
    pHandler.property("siretDeclare", getSiretDeclare(), new Attribute[] { new StringAttribute("C_ERR", getSiretDeclare_C_ERR()) });
    
    pHandler.property("refContratEmployeur", getRefContratEmployeur(), new Attribute[] { new StringAttribute("C_ERR", getRefContratEmployeur_C_ERR()) });
    
    pHandler.property("nbMessagesPrimesIndemnites", getNbMessagesPrimesIndemnites(), new Attribute[] { new StringAttribute("C_ERR", getNbMessagesPrimesIndemnites_C_ERR()) });
    
    pHandler.property("dateConnaissanceMensuelle", getDateConnaissanceMensuelle(), new Attribute[] { new StringAttribute("C_ERR", getDateConnaissanceMensuelle_C_ERR()) });
    
    pHandler.property("dateMoisDeclare", getDateMoisDeclare(), new Attribute[] { new StringAttribute("C_ERR", getDateMoisDeclare_C_ERR()) });
    
    pHandler.property("dateDebutContrat", getDateDebutContrat(), new Attribute[] { new StringAttribute("C_ERR", getDateDebutContrat_C_ERR()) });
    
    pHandler.property("dateFinContrat", getDateFinContrat(), new Attribute[] { new StringAttribute("C_ERR", getDateFinContrat_C_ERR()) });
    
    pHandler.property("natureContrat", getNatureContrat(), new Attribute[] { new StringAttribute("C_ERR", getNatureContrat_C_ERR()) });
    
    pHandler.property("typeContrat", getTypeContrat(), new Attribute[] { new StringAttribute("C_ERR", getTypeContrat_C_ERR()) });
    
    pHandler.property("codeStatutCadre", getCodeStatutCadre(), new Attribute[] { new StringAttribute("C_ERR", getCodeStatutCadre_C_ERR()) });
    
    pHandler.property("horaireSalarie", getHoraireSalarie(), new Attribute[] { new StringAttribute("C_ERR", getHoraireSalarie_C_ERR()) });
    
    pHandler.property("horaireEntreprise", getHoraireEntreprise(), new Attribute[] { new StringAttribute("C_ERR", getHoraireEntreprise_C_ERR()) });
    
    pHandler.property("uniteTempsTravail", getUniteTempsTravail(), new Attribute[] { new StringAttribute("C_ERR", getUniteTempsTravail_C_ERR()) });
    
    pHandler.property("alsaceMoselle", getAlsaceMoselle(), new Attribute[] { new StringAttribute("C_ERR", getAlsaceMoselle_C_ERR()) });
    
    pHandler.property("regimeSpecialSecuriteSoc", getRegimeSpecialSecuriteSoc(), new Attribute[] { new StringAttribute("C_ERR", getRegimeSpecialSecuriteSoc_C_ERR()) });
    
    pHandler.property("typeCaisseCP", getTypeCaisseCP(), new Attribute[] { new StringAttribute("C_ERR", getTypeCaisseCP_C_ERR()) });
    
    pHandler.property("niveauQualification", getNiveauQualification(), new Attribute[] { new StringAttribute("C_ERR", getNiveauQualification_C_ERR()) });
    
    pHandler.property("codeCaisseRetraiteCompl", getCodeCaisseRetraiteCompl(), new Attribute[] { new StringAttribute("C_ERR", getCodeCaisseRetraiteCompl_C_ERR()) });
    
    pHandler.property("champApplicationEmployeur", getChampApplicationEmployeur(), new Attribute[] { new StringAttribute("C_ERR", getChampApplicationEmployeur_C_ERR()) });
    
    pHandler.property("numConventionGestionEmpPublic", getNumConventionGestionEmpPublic(), new Attribute[] { new StringAttribute("C_ERR", getNumConventionGestionEmpPublic_C_ERR()) });
    
    pHandler.property("etablissementFinancier", getEtablissementFinancier(), new Attribute[] { new StringAttribute("C_ERR", getEtablissementFinancier_C_ERR()) });
    
    pHandler.property("codeAffectation", getCodeAffectation(), new Attribute[] { new StringAttribute("C_ERR", getCodeAffectation_C_ERR()) });
    
    pHandler.property("numInterneEmpPublic", getNumInterneEmpPublic(), new Attribute[] { new StringAttribute("C_ERR", getNumInterneEmpPublic_C_ERR()) });
    
    pHandler.property("statutSalarie", getStatutSalarie(), new Attribute[] { new StringAttribute("C_ERR", getStatutSalarie_C_ERR()) });
    
    pHandler.property("dateAdhesion", getDateAdhesion(), new Attribute[] { new StringAttribute("C_ERR", getDateAdhesion_C_ERR()) });
    
    pHandler.property("motifPeriodeInactivite", getMotifPeriodeInactivite(), new Attribute[] { new StringAttribute("C_ERR", getMotifPeriodeInactivite_C_ERR()) });
    
    pHandler.property("dateDebutPeriodeInactivite", getDateDebutPeriodeInactivite(), new Attribute[] { new StringAttribute("C_ERR", getDateDebutPeriodeInactivite_C_ERR()) });
    
    pHandler.property("dateFinPeriodeInactivite", getDateFinPeriodeInactivite(), new Attribute[] { new StringAttribute("C_ERR", getDateFinPeriodeInactivite_C_ERR()) });
    
    pHandler.property("dateDebutPeriodeSalaire", getDateDebutPeriodeSalaire(), new Attribute[] { new StringAttribute("C_ERR", getDateDebutPeriodeSalaire_C_ERR()) });
    
    pHandler.property("dateFinPeriodeSalaire", getDateFinPeriodeSalaire(), new Attribute[] { new StringAttribute("C_ERR", getDateFinPeriodeSalaire_C_ERR()) });
    
    pHandler.property("codePcsEse", getCodePcsEse(), new Attribute[] { new StringAttribute("C_ERR", getCodePcsEse_C_ERR()) });
    
    pHandler.property("codeComplementPcsEse", getCodeComplementPcsEse(), new Attribute[] { new StringAttribute("C_ERR", getCodeComplementPcsEse_C_ERR()) });
    
    pHandler.property("signeSalaireBrutAbattu", getSigneSalaireBrutAbattu(), new Attribute[] { new StringAttribute("C_ERR", getSigneSalaireBrutAbattu_C_ERR()) });
    
    pHandler.property("salaireBrutAbattu", getSalaireBrutAbattu(), new Attribute[] { new StringAttribute("C_ERR", getSalaireBrutAbattu_C_ERR()) });
    
    pHandler.property("datePaiement", getDatePaiement(), new Attribute[] { new StringAttribute("C_ERR", getDatePaiement_C_ERR()) });
    
    pHandler.property("dureeAbsence", getDureeAbsence(), new Attribute[] { new StringAttribute("C_ERR", getDureeAbsence_C_ERR()) });
    
    pHandler.property("uniteAbsence", getUniteAbsence(), new Attribute[] { new StringAttribute("C_ERR", getUniteAbsence_C_ERR()) });
    
    pHandler.property("nomLogiciel", getNomLogiciel(), new Attribute[] { new StringAttribute("C_ERR", getNomLogiciel_C_ERR()) });
    
    pHandler.property("versionLogiciel", getVersionLogiciel(), new Attribute[] { new StringAttribute("C_ERR", getVersionLogiciel_C_ERR()) });
    
    pHandler.property("numeroRCI", getNumeroRCI(), new Attribute[] { new StringAttribute("C_ERR", getNumeroRCI_C_ERR()) });
    
    pHandler.property("cxass", getCxass(), new Attribute[] { new StringAttribute("C_ERR", getCxass_C_ERR()) });
    
    pHandler.property("rsin", getRsin(), new Attribute[] { new StringAttribute("C_ERR", getRsin_C_ERR()) });
    
    pHandler.property("nom", getNom(), new Attribute[] { new StringAttribute("C_ERR", getNom_C_ERR()) });
    
    pHandler.property("prenom", getPrenom(), new Attribute[] { new StringAttribute("C_ERR", getPrenom_C_ERR()) });
    
    pHandler.property("peAffi", getPeAffi(), new Attribute[] { new StringAttribute("C_ERR", getPeAffi_C_ERR()) });
    
    pHandler.property("siret", getSiret(), new Attribute[] { new StringAttribute("C_ERR", getSiret_C_ERR()) });
    
    pHandler.property("emplNumAffi", getEmplNumAffi(), new Attribute[] { new StringAttribute("C_ERR", getEmplNumAffi_C_ERR()) });
    
    pHandler.property("emplRaisonSociale", getEmplRaisonSociale(), new Attribute[] { new StringAttribute("C_ERR", getEmplRaisonSociale_C_ERR()) });
    
    pHandler.property("emplNAF", getEmplNAF(), new Attribute[] { new StringAttribute("C_ERR", getEmplNAF_C_ERR()) });
    
    pHandler.property("emplCommune", getEmplCommune(), new Attribute[] { new StringAttribute("C_ERR", getEmplCommune_C_ERR()) });
    
    pHandler.property("emplCP", getEmplCP(), new Attribute[] { new StringAttribute("C_ERR", getEmplCP_C_ERR()) });
    
    pHandler.property("idBNEArrco", getIdBNEArrco(), new Attribute[] { new StringAttribute("C_ERR", getIdBNEArrco_C_ERR()) });
    
    pHandler.property("arrcoSigle", getArrcoSigle(), new Attribute[] { new StringAttribute("C_ERR", getArrcoSigle_C_ERR()) });
    
    pHandler.property("arrcoRaisonSociale", getArrcoRaisonSociale(), new Attribute[] { new StringAttribute("C_ERR", getArrcoRaisonSociale_C_ERR()) });
    
    pHandler.property("idBNEAgirc", getIdBNEAgirc(), new Attribute[] { new StringAttribute("C_ERR", getIdBNEAgirc_C_ERR()) });
    
    pHandler.property("agircSigle", getAgircSigle(), new Attribute[] { new StringAttribute("C_ERR", getAgircSigle_C_ERR()) });
    
    pHandler.property("agircRaisonSociale", getAgircRaisonSociale(), new Attribute[] { new StringAttribute("C_ERR", getAgircRaisonSociale_C_ERR()) });
    
    pHandler.property("codeRegimeCrpCtp", getCodeRegimeCrpCtp(), new Attribute[] { new StringAttribute("C_ERR", getCodeRegimeCrpCtp_C_ERR()) });
    
    pHandler.property("dateEffetRegimeCrpCtp", getDateEffetRegimeCrpCtp(), new Attribute[] { new StringAttribute("C_ERR", getDateEffetRegimeCrpCtp_C_ERR()) });
    
    pHandler.property("emplNumConventionGestion", getEmplNumConventionGestion(), new Attribute[] { new StringAttribute("C_ERR", getEmplNumConventionGestion_C_ERR()) });
    
    pHandler.property("nbSalariesEntreprise", getNbSalariesEntreprise(), new Attribute[] { new StringAttribute("C_ERR", getNbSalariesEntreprise_C_ERR()) });
    
    pHandler.property("nomEmployeur", getNomEmployeur(), new Attribute[] { new StringAttribute("C_ERR", getNomEmployeur_C_ERR()) });
    
    pHandler.property("prenomEmployeur", getPrenomEmployeur(), new Attribute[] { new StringAttribute("C_ERR", getPrenomEmployeur_C_ERR()) });
    
    pHandler.property("categorieJuridique", getCategorieJuridique(), new Attribute[] { new StringAttribute("C_ERR", getCategorieJuridique_C_ERR()) });
    
    pHandler.property("codeRegimeEntreprise", getCodeRegimeEntreprise(), new Attribute[] { new StringAttribute("C_ERR", getCodeRegimeEntreprise_C_ERR()) });
    
    pHandler.property("dateCessationEntreprise", getDateCessationEntreprise(), new Attribute[] { new StringAttribute("C_ERR", getDateCessationEntreprise_C_ERR()) });
    
    pHandler.property("natureEntreprise", getNatureEntreprise(), new Attribute[] { new StringAttribute("C_ERR", getNatureEntreprise_C_ERR()) });
    
    pHandler.property("numMSAEntreprise", getNumMSAEntreprise(), new Attribute[] { new StringAttribute("C_ERR", getNumMSAEntreprise_C_ERR()) });
    
    pHandler.property("debutPeriodeAffiliationEntreprise", getDebutPeriodeAffiliationEntreprise(), new Attribute[] { new StringAttribute("C_ERR", getDebutPeriodeAffiliationEntreprise_C_ERR()) });
    
    pHandler.property("finPeriodeAffiliationEntreprise", getFinPeriodeAffiliationEntreprise(), new Attribute[] { new StringAttribute("C_ERR", getFinPeriodeAffiliationEntreprise_C_ERR()) });
    
    pHandler.property("debutConventionGestion", getDebutConventionGestion(), new Attribute[] { new StringAttribute("C_ERR", getDebutConventionGestion_C_ERR()) });
    
    pHandler.property("finConventionGestion", getFinConventionGestion(), new Attribute[] { new StringAttribute("C_ERR", getFinConventionGestion_C_ERR()) });
    
    pHandler.property("secteurPublic", getSecteurPublic(), new Attribute[] { new StringAttribute("C_ERR", getSecteurPublic_C_ERR()) });
    
    pHandler.property("trancheEffectifEntreprise", getTrancheEffectifEntreprise(), new Attribute[] { new StringAttribute("C_ERR", getTrancheEffectifEntreprise_C_ERR()) });
    
    pHandler.property("debutAGS", getDebutAGS(), new Attribute[] { new StringAttribute("C_ERR", getDebutAGS_C_ERR()) });
    
    pHandler.property("finAGS", getFinAGS(), new Attribute[] { new StringAttribute("C_ERR", getFinAGS_C_ERR()) });
    
    pHandler.property("debutAdhesionRevocable", getDebutAdhesionRevocable(), new Attribute[] { new StringAttribute("C_ERR", getDebutAdhesionRevocable_C_ERR()) });
    
    pHandler.property("finAdhesionRevocable", getFinAdhesionRevocable(), new Attribute[] { new StringAttribute("C_ERR", getFinAdhesionRevocable_C_ERR()) });
    
    DataBean ListeFluxQuantiteTravailDsn_Value = getListeFluxQuantiteTravailDsn();
    GettersHandler ListeFluxQuantiteTravailDsn_GettersHandler = pHandler.property("ListeFluxQuantiteTravailDsn", ListeFluxQuantiteTravailDsn_Value, new Attribute[] { new StringAttribute("C_ERR", getListeFluxQuantiteTravailDsn_C_ERR()) });
    if ((ListeFluxQuantiteTravailDsn_GettersHandler != null) && (ListeFluxQuantiteTravailDsn_Value != null)) {
      ListeFluxQuantiteTravailDsn_Value.goThrough(ListeFluxQuantiteTravailDsn_GettersHandler);
    }
    pHandler.property("motifFinContrat", getMotifFinContrat(), new Attribute[] { new StringAttribute("C_ERR", getMotifFinContrat_C_ERR()) });
    
    pHandler.property("dateInitialeFinContrat", getDateInitialeFinContrat(), new Attribute[] { new StringAttribute("C_ERR", getDateInitialeFinContrat_C_ERR()) });
    
    pHandler.property("idActiviteDsnPe", getIdActiviteDsnPe(), new Attribute[] { new StringAttribute("C_ERR", getIdActiviteDsnPe_C_ERR()) });
    
    pHandler.property("signeDureeAbsence", getSigneDureeAbsence(), new Attribute[] { new StringAttribute("C_ERR", getSigneDureeAbsence_C_ERR()) });
    
    DataBean ListeFluxPrimeIndemDsn_Value = getListeFluxPrimeIndemDsn();
    GettersHandler ListeFluxPrimeIndemDsn_GettersHandler = pHandler.property("ListeFluxPrimeIndemDsn", ListeFluxPrimeIndemDsn_Value, new Attribute[] { new StringAttribute("C_ERR", getListeFluxPrimeIndemDsn_C_ERR()) });
    if ((ListeFluxPrimeIndemDsn_GettersHandler != null) && (ListeFluxPrimeIndemDsn_Value != null)) {
      ListeFluxPrimeIndemDsn_Value.goThrough(ListeFluxPrimeIndemDsn_GettersHandler);
    }
    pHandler.property("identDeclPri", getIdentDeclPri(), new Attribute[] { new StringAttribute("C_ERR", getIdentDeclPri_C_ERR()) });
    
    pHandler.property("identDeclSec", getIdentDeclSec(), new Attribute[] { new StringAttribute("C_ERR", getIdentDeclSec_C_ERR()) });
    
    pHandler.property("motifRecours", getMotifRecours(), new Attribute[] { new StringAttribute("C_ERR", getMotifRecours_C_ERR()) });
    
    pHandler.property("modaliteDeclarativeFinContrat", getModaliteDeclarativeFinContrat(), new Attribute[] { new StringAttribute("C_ERR", getModaliteDeclarativeFinContrat_C_ERR()) });
    
    pHandler.property("djtp", getDjtp(), new Attribute[] { new StringAttribute("C_ERR", getDjtp_C_ERR()) });
  }
  
  public void goThrough(SettersHandler pHandler)
    throws Exception
  {
    pHandler.startGoThrough();
    
    subGoThrough(pHandler);
    
    pHandler.endGoThrough();
  }
  
  protected void subGoThrough(SettersHandler pHandler)
    throws Exception
  {
    set_C_ETAT(pHandler.stringAttribute("C_ETAT"));
    set_IDENT(pHandler.stringAttribute("IDENT"));
    setTypeEnreg((String)pHandler.objectProperty("typeEnreg", String.class));
    setTypeEnreg_C_ERR(pHandler.stringAttribute("typeEnreg", "C_ERR"));
    
    setNumNIRCertifie((String)pHandler.objectProperty("numNIRCertifie", String.class));
    setNumNIRCertifie_C_ERR(pHandler.stringAttribute("numNIRCertifie", "C_ERR"));
    
    setNomDeclare((String)pHandler.objectProperty("nomDeclare", String.class));
    setNomDeclare_C_ERR(pHandler.stringAttribute("nomDeclare", "C_ERR"));
    
    setPrenomDeclare((String)pHandler.objectProperty("prenomDeclare", String.class));
    setPrenomDeclare_C_ERR(pHandler.stringAttribute("prenomDeclare", "C_ERR"));
    
    setDateNaissance((Damj)pHandler.objectProperty("dateNaissance", Damj.class));
    setDateNaissance_C_ERR(pHandler.stringAttribute("dateNaissance", "C_ERR"));
    
    setContexteEmission((String)pHandler.objectProperty("contexteEmission", String.class));
    setContexteEmission_C_ERR(pHandler.stringAttribute("contexteEmission", "C_ERR"));
    
    setNatureJustificatif((String)pHandler.objectProperty("natureJustificatif", String.class));
    setNatureJustificatif_C_ERR(pHandler.stringAttribute("natureJustificatif", "C_ERR"));
    
    setCodeMessage((String)pHandler.objectProperty("codeMessage", String.class));
    setCodeMessage_C_ERR(pHandler.stringAttribute("codeMessage", "C_ERR"));
    
    setNumeroVersion((BigDecimal)pHandler.objectProperty("numeroVersion", BigDecimal.class));
    setNumeroVersion_C_ERR(pHandler.stringAttribute("numeroVersion", "C_ERR"));
    
    setNumeroSousVersion((BigDecimal)pHandler.objectProperty("numeroSousVersion", BigDecimal.class));
    setNumeroSousVersion_C_ERR(pHandler.stringAttribute("numeroSousVersion", "C_ERR"));
    
    setCodeAction((String)pHandler.objectProperty("codeAction", String.class));
    setCodeAction_C_ERR(pHandler.stringAttribute("codeAction", "C_ERR"));
    
    setIdTechnique((BigDecimal)pHandler.objectProperty("idTechnique", BigDecimal.class));
    setIdTechnique_C_ERR(pHandler.stringAttribute("idTechnique", "C_ERR"));
    
    setIdRCE((BigDecimal)pHandler.objectProperty("idRCE", BigDecimal.class));
    setIdRCE_C_ERR(pHandler.stringAttribute("idRCE", "C_ERR"));
    
    setSiretDeclare((BigDecimal)pHandler.objectProperty("siretDeclare", BigDecimal.class));
    setSiretDeclare_C_ERR(pHandler.stringAttribute("siretDeclare", "C_ERR"));
    
    setRefContratEmployeur((String)pHandler.objectProperty("refContratEmployeur", String.class));
    setRefContratEmployeur_C_ERR(pHandler.stringAttribute("refContratEmployeur", "C_ERR"));
    
    setNbMessagesPrimesIndemnites((BigDecimal)pHandler.objectProperty("nbMessagesPrimesIndemnites", BigDecimal.class));
    setNbMessagesPrimesIndemnites_C_ERR(pHandler.stringAttribute("nbMessagesPrimesIndemnites", "C_ERR"));
    
    setDateConnaissanceMensuelle((Damj)pHandler.objectProperty("dateConnaissanceMensuelle", Damj.class));
    setDateConnaissanceMensuelle_C_ERR(pHandler.stringAttribute("dateConnaissanceMensuelle", "C_ERR"));
    
    setDateMoisDeclare((Damj)pHandler.objectProperty("dateMoisDeclare", Damj.class));
    setDateMoisDeclare_C_ERR(pHandler.stringAttribute("dateMoisDeclare", "C_ERR"));
    
    setDateDebutContrat((Damj)pHandler.objectProperty("dateDebutContrat", Damj.class));
    setDateDebutContrat_C_ERR(pHandler.stringAttribute("dateDebutContrat", "C_ERR"));
    
    setDateFinContrat((Damj)pHandler.objectProperty("dateFinContrat", Damj.class));
    setDateFinContrat_C_ERR(pHandler.stringAttribute("dateFinContrat", "C_ERR"));
    
    setNatureContrat((String)pHandler.objectProperty("natureContrat", String.class));
    setNatureContrat_C_ERR(pHandler.stringAttribute("natureContrat", "C_ERR"));
    
    setTypeContrat((String)pHandler.objectProperty("typeContrat", String.class));
    setTypeContrat_C_ERR(pHandler.stringAttribute("typeContrat", "C_ERR"));
    
    setCodeStatutCadre((String)pHandler.objectProperty("codeStatutCadre", String.class));
    setCodeStatutCadre_C_ERR(pHandler.stringAttribute("codeStatutCadre", "C_ERR"));
    
    setHoraireSalarie((BigDecimal)pHandler.objectProperty("horaireSalarie", BigDecimal.class));
    setHoraireSalarie_C_ERR(pHandler.stringAttribute("horaireSalarie", "C_ERR"));
    
    setHoraireEntreprise((BigDecimal)pHandler.objectProperty("horaireEntreprise", BigDecimal.class));
    setHoraireEntreprise_C_ERR(pHandler.stringAttribute("horaireEntreprise", "C_ERR"));
    
    setUniteTempsTravail((String)pHandler.objectProperty("uniteTempsTravail", String.class));
    setUniteTempsTravail_C_ERR(pHandler.stringAttribute("uniteTempsTravail", "C_ERR"));
    
    setAlsaceMoselle((String)pHandler.objectProperty("alsaceMoselle", String.class));
    setAlsaceMoselle_C_ERR(pHandler.stringAttribute("alsaceMoselle", "C_ERR"));
    
    setRegimeSpecialSecuriteSoc((String)pHandler.objectProperty("regimeSpecialSecuriteSoc", String.class));
    setRegimeSpecialSecuriteSoc_C_ERR(pHandler.stringAttribute("regimeSpecialSecuriteSoc", "C_ERR"));
    
    setTypeCaisseCP((String)pHandler.objectProperty("typeCaisseCP", String.class));
    setTypeCaisseCP_C_ERR(pHandler.stringAttribute("typeCaisseCP", "C_ERR"));
    
    setNiveauQualification((String)pHandler.objectProperty("niveauQualification", String.class));
    setNiveauQualification_C_ERR(pHandler.stringAttribute("niveauQualification", "C_ERR"));
    
    setCodeCaisseRetraiteCompl((String)pHandler.objectProperty("codeCaisseRetraiteCompl", String.class));
    setCodeCaisseRetraiteCompl_C_ERR(pHandler.stringAttribute("codeCaisseRetraiteCompl", "C_ERR"));
    
    setChampApplicationEmployeur((String)pHandler.objectProperty("champApplicationEmployeur", String.class));
    setChampApplicationEmployeur_C_ERR(pHandler.stringAttribute("champApplicationEmployeur", "C_ERR"));
    
    setNumConventionGestionEmpPublic((String)pHandler.objectProperty("numConventionGestionEmpPublic", String.class));
    setNumConventionGestionEmpPublic_C_ERR(pHandler.stringAttribute("numConventionGestionEmpPublic", "C_ERR"));
    
    setEtablissementFinancier((String)pHandler.objectProperty("etablissementFinancier", String.class));
    setEtablissementFinancier_C_ERR(pHandler.stringAttribute("etablissementFinancier", "C_ERR"));
    
    setCodeAffectation((String)pHandler.objectProperty("codeAffectation", String.class));
    setCodeAffectation_C_ERR(pHandler.stringAttribute("codeAffectation", "C_ERR"));
    
    setNumInterneEmpPublic((String)pHandler.objectProperty("numInterneEmpPublic", String.class));
    setNumInterneEmpPublic_C_ERR(pHandler.stringAttribute("numInterneEmpPublic", "C_ERR"));
    
    setStatutSalarie((String)pHandler.objectProperty("statutSalarie", String.class));
    setStatutSalarie_C_ERR(pHandler.stringAttribute("statutSalarie", "C_ERR"));
    
    setDateAdhesion((Damj)pHandler.objectProperty("dateAdhesion", Damj.class));
    setDateAdhesion_C_ERR(pHandler.stringAttribute("dateAdhesion", "C_ERR"));
    
    setMotifPeriodeInactivite((String)pHandler.objectProperty("motifPeriodeInactivite", String.class));
    setMotifPeriodeInactivite_C_ERR(pHandler.stringAttribute("motifPeriodeInactivite", "C_ERR"));
    
    setDateDebutPeriodeInactivite((Damj)pHandler.objectProperty("dateDebutPeriodeInactivite", Damj.class));
    setDateDebutPeriodeInactivite_C_ERR(pHandler.stringAttribute("dateDebutPeriodeInactivite", "C_ERR"));
    
    setDateFinPeriodeInactivite((Damj)pHandler.objectProperty("dateFinPeriodeInactivite", Damj.class));
    setDateFinPeriodeInactivite_C_ERR(pHandler.stringAttribute("dateFinPeriodeInactivite", "C_ERR"));
    
    setDateDebutPeriodeSalaire((Damj)pHandler.objectProperty("dateDebutPeriodeSalaire", Damj.class));
    setDateDebutPeriodeSalaire_C_ERR(pHandler.stringAttribute("dateDebutPeriodeSalaire", "C_ERR"));
    
    setDateFinPeriodeSalaire((Damj)pHandler.objectProperty("dateFinPeriodeSalaire", Damj.class));
    setDateFinPeriodeSalaire_C_ERR(pHandler.stringAttribute("dateFinPeriodeSalaire", "C_ERR"));
    
    setCodePcsEse((String)pHandler.objectProperty("codePcsEse", String.class));
    setCodePcsEse_C_ERR(pHandler.stringAttribute("codePcsEse", "C_ERR"));
    
    setCodeComplementPcsEse((String)pHandler.objectProperty("codeComplementPcsEse", String.class));
    setCodeComplementPcsEse_C_ERR(pHandler.stringAttribute("codeComplementPcsEse", "C_ERR"));
    
    setSigneSalaireBrutAbattu((String)pHandler.objectProperty("signeSalaireBrutAbattu", String.class));
    setSigneSalaireBrutAbattu_C_ERR(pHandler.stringAttribute("signeSalaireBrutAbattu", "C_ERR"));
    
    setSalaireBrutAbattu((BigDecimal)pHandler.objectProperty("salaireBrutAbattu", BigDecimal.class));
    setSalaireBrutAbattu_C_ERR(pHandler.stringAttribute("salaireBrutAbattu", "C_ERR"));
    
    setDatePaiement((Damj)pHandler.objectProperty("datePaiement", Damj.class));
    setDatePaiement_C_ERR(pHandler.stringAttribute("datePaiement", "C_ERR"));
    
    setDureeAbsence((BigDecimal)pHandler.objectProperty("dureeAbsence", BigDecimal.class));
    setDureeAbsence_C_ERR(pHandler.stringAttribute("dureeAbsence", "C_ERR"));
    
    setUniteAbsence((String)pHandler.objectProperty("uniteAbsence", String.class));
    setUniteAbsence_C_ERR(pHandler.stringAttribute("uniteAbsence", "C_ERR"));
    
    setNomLogiciel((String)pHandler.objectProperty("nomLogiciel", String.class));
    setNomLogiciel_C_ERR(pHandler.stringAttribute("nomLogiciel", "C_ERR"));
    
    setVersionLogiciel((String)pHandler.objectProperty("versionLogiciel", String.class));
    setVersionLogiciel_C_ERR(pHandler.stringAttribute("versionLogiciel", "C_ERR"));
    
    setNumeroRCI((String)pHandler.objectProperty("numeroRCI", String.class));
    setNumeroRCI_C_ERR(pHandler.stringAttribute("numeroRCI", "C_ERR"));
    
    setCxass((String)pHandler.objectProperty("cxass", String.class));
    setCxass_C_ERR(pHandler.stringAttribute("cxass", "C_ERR"));
    
    setRsin((String)pHandler.objectProperty("rsin", String.class));
    setRsin_C_ERR(pHandler.stringAttribute("rsin", "C_ERR"));
    
    setNom((String)pHandler.objectProperty("nom", String.class));
    setNom_C_ERR(pHandler.stringAttribute("nom", "C_ERR"));
    
    setPrenom((String)pHandler.objectProperty("prenom", String.class));
    setPrenom_C_ERR(pHandler.stringAttribute("prenom", "C_ERR"));
    
    setPeAffi((String)pHandler.objectProperty("peAffi", String.class));
    setPeAffi_C_ERR(pHandler.stringAttribute("peAffi", "C_ERR"));
    
    setSiret((String)pHandler.objectProperty("siret", String.class));
    setSiret_C_ERR(pHandler.stringAttribute("siret", "C_ERR"));
    
    setEmplNumAffi((String)pHandler.objectProperty("emplNumAffi", String.class));
    setEmplNumAffi_C_ERR(pHandler.stringAttribute("emplNumAffi", "C_ERR"));
    
    setEmplRaisonSociale((String)pHandler.objectProperty("emplRaisonSociale", String.class));
    setEmplRaisonSociale_C_ERR(pHandler.stringAttribute("emplRaisonSociale", "C_ERR"));
    
    setEmplNAF((String)pHandler.objectProperty("emplNAF", String.class));
    setEmplNAF_C_ERR(pHandler.stringAttribute("emplNAF", "C_ERR"));
    
    setEmplCommune((String)pHandler.objectProperty("emplCommune", String.class));
    setEmplCommune_C_ERR(pHandler.stringAttribute("emplCommune", "C_ERR"));
    
    setEmplCP((BigDecimal)pHandler.objectProperty("emplCP", BigDecimal.class));
    setEmplCP_C_ERR(pHandler.stringAttribute("emplCP", "C_ERR"));
    
    setIdBNEArrco((BigDecimal)pHandler.objectProperty("idBNEArrco", BigDecimal.class));
    setIdBNEArrco_C_ERR(pHandler.stringAttribute("idBNEArrco", "C_ERR"));
    
    setArrcoSigle((String)pHandler.objectProperty("arrcoSigle", String.class));
    setArrcoSigle_C_ERR(pHandler.stringAttribute("arrcoSigle", "C_ERR"));
    
    setArrcoRaisonSociale((String)pHandler.objectProperty("arrcoRaisonSociale", String.class));
    setArrcoRaisonSociale_C_ERR(pHandler.stringAttribute("arrcoRaisonSociale", "C_ERR"));
    
    setIdBNEAgirc((BigDecimal)pHandler.objectProperty("idBNEAgirc", BigDecimal.class));
    setIdBNEAgirc_C_ERR(pHandler.stringAttribute("idBNEAgirc", "C_ERR"));
    
    setAgircSigle((String)pHandler.objectProperty("agircSigle", String.class));
    setAgircSigle_C_ERR(pHandler.stringAttribute("agircSigle", "C_ERR"));
    
    setAgircRaisonSociale((String)pHandler.objectProperty("agircRaisonSociale", String.class));
    setAgircRaisonSociale_C_ERR(pHandler.stringAttribute("agircRaisonSociale", "C_ERR"));
    
    setCodeRegimeCrpCtp((String)pHandler.objectProperty("codeRegimeCrpCtp", String.class));
    setCodeRegimeCrpCtp_C_ERR(pHandler.stringAttribute("codeRegimeCrpCtp", "C_ERR"));
    
    setDateEffetRegimeCrpCtp((Damj)pHandler.objectProperty("dateEffetRegimeCrpCtp", Damj.class));
    setDateEffetRegimeCrpCtp_C_ERR(pHandler.stringAttribute("dateEffetRegimeCrpCtp", "C_ERR"));
    
    setEmplNumConventionGestion((String)pHandler.objectProperty("emplNumConventionGestion", String.class));
    setEmplNumConventionGestion_C_ERR(pHandler.stringAttribute("emplNumConventionGestion", "C_ERR"));
    
    setNbSalariesEntreprise((BigDecimal)pHandler.objectProperty("nbSalariesEntreprise", BigDecimal.class));
    setNbSalariesEntreprise_C_ERR(pHandler.stringAttribute("nbSalariesEntreprise", "C_ERR"));
    
    setNomEmployeur((String)pHandler.objectProperty("nomEmployeur", String.class));
    setNomEmployeur_C_ERR(pHandler.stringAttribute("nomEmployeur", "C_ERR"));
    
    setPrenomEmployeur((String)pHandler.objectProperty("prenomEmployeur", String.class));
    setPrenomEmployeur_C_ERR(pHandler.stringAttribute("prenomEmployeur", "C_ERR"));
    
    setCategorieJuridique((String)pHandler.objectProperty("categorieJuridique", String.class));
    setCategorieJuridique_C_ERR(pHandler.stringAttribute("categorieJuridique", "C_ERR"));
    
    setCodeRegimeEntreprise((String)pHandler.objectProperty("codeRegimeEntreprise", String.class));
    setCodeRegimeEntreprise_C_ERR(pHandler.stringAttribute("codeRegimeEntreprise", "C_ERR"));
    
    setDateCessationEntreprise((Damj)pHandler.objectProperty("dateCessationEntreprise", Damj.class));
    setDateCessationEntreprise_C_ERR(pHandler.stringAttribute("dateCessationEntreprise", "C_ERR"));
    
    setNatureEntreprise((String)pHandler.objectProperty("natureEntreprise", String.class));
    setNatureEntreprise_C_ERR(pHandler.stringAttribute("natureEntreprise", "C_ERR"));
    
    setNumMSAEntreprise((String)pHandler.objectProperty("numMSAEntreprise", String.class));
    setNumMSAEntreprise_C_ERR(pHandler.stringAttribute("numMSAEntreprise", "C_ERR"));
    
    setDebutPeriodeAffiliationEntreprise((Damj)pHandler.objectProperty("debutPeriodeAffiliationEntreprise", Damj.class));
    setDebutPeriodeAffiliationEntreprise_C_ERR(pHandler.stringAttribute("debutPeriodeAffiliationEntreprise", "C_ERR"));
    
    setFinPeriodeAffiliationEntreprise((Damj)pHandler.objectProperty("finPeriodeAffiliationEntreprise", Damj.class));
    setFinPeriodeAffiliationEntreprise_C_ERR(pHandler.stringAttribute("finPeriodeAffiliationEntreprise", "C_ERR"));
    
    setDebutConventionGestion((Damj)pHandler.objectProperty("debutConventionGestion", Damj.class));
    setDebutConventionGestion_C_ERR(pHandler.stringAttribute("debutConventionGestion", "C_ERR"));
    
    setFinConventionGestion((Damj)pHandler.objectProperty("finConventionGestion", Damj.class));
    setFinConventionGestion_C_ERR(pHandler.stringAttribute("finConventionGestion", "C_ERR"));
    
    setSecteurPublic((String)pHandler.objectProperty("secteurPublic", String.class));
    setSecteurPublic_C_ERR(pHandler.stringAttribute("secteurPublic", "C_ERR"));
    
    setTrancheEffectifEntreprise((String)pHandler.objectProperty("trancheEffectifEntreprise", String.class));
    setTrancheEffectifEntreprise_C_ERR(pHandler.stringAttribute("trancheEffectifEntreprise", "C_ERR"));
    
    setDebutAGS((Damj)pHandler.objectProperty("debutAGS", Damj.class));
    setDebutAGS_C_ERR(pHandler.stringAttribute("debutAGS", "C_ERR"));
    
    setFinAGS((Damj)pHandler.objectProperty("finAGS", Damj.class));
    setFinAGS_C_ERR(pHandler.stringAttribute("finAGS", "C_ERR"));
    
    setDebutAdhesionRevocable((Damj)pHandler.objectProperty("debutAdhesionRevocable", Damj.class));
    setDebutAdhesionRevocable_C_ERR(pHandler.stringAttribute("debutAdhesionRevocable", "C_ERR"));
    
    setFinAdhesionRevocable((Damj)pHandler.objectProperty("finAdhesionRevocable", Damj.class));
    setFinAdhesionRevocable_C_ERR(pHandler.stringAttribute("finAdhesionRevocable", "C_ERR"));
    
    setListeFluxQuantiteTravailDsn((_ListeFluxQuantiteTravailDsn)pHandler.databeanProperty("ListeFluxQuantiteTravailDsn", _ListeFluxQuantiteTravailDsn.class));
    setListeFluxQuantiteTravailDsn_C_ERR(pHandler.stringAttribute("ListeFluxQuantiteTravailDsn", "C_ERR"));
    setMotifFinContrat((String)pHandler.objectProperty("motifFinContrat", String.class));
    setMotifFinContrat_C_ERR(pHandler.stringAttribute("motifFinContrat", "C_ERR"));
    
    setDateInitialeFinContrat((Damj)pHandler.objectProperty("dateInitialeFinContrat", Damj.class));
    setDateInitialeFinContrat_C_ERR(pHandler.stringAttribute("dateInitialeFinContrat", "C_ERR"));
    
    setIdActiviteDsnPe((BigDecimal)pHandler.objectProperty("idActiviteDsnPe", BigDecimal.class));
    setIdActiviteDsnPe_C_ERR(pHandler.stringAttribute("idActiviteDsnPe", "C_ERR"));
    
    setSigneDureeAbsence((String)pHandler.objectProperty("signeDureeAbsence", String.class));
    setSigneDureeAbsence_C_ERR(pHandler.stringAttribute("signeDureeAbsence", "C_ERR"));
    
    setListeFluxPrimeIndemDsn((_ListeFluxPrimeIndemDsn)pHandler.databeanProperty("ListeFluxPrimeIndemDsn", _ListeFluxPrimeIndemDsn.class));
    setListeFluxPrimeIndemDsn_C_ERR(pHandler.stringAttribute("ListeFluxPrimeIndemDsn", "C_ERR"));
    setIdentDeclPri((String)pHandler.objectProperty("identDeclPri", String.class));
    setIdentDeclPri_C_ERR(pHandler.stringAttribute("identDeclPri", "C_ERR"));
    
    setIdentDeclSec((String)pHandler.objectProperty("identDeclSec", String.class));
    setIdentDeclSec_C_ERR(pHandler.stringAttribute("identDeclSec", "C_ERR"));
    
    setMotifRecours((String)pHandler.objectProperty("motifRecours", String.class));
    setMotifRecours_C_ERR(pHandler.stringAttribute("motifRecours", "C_ERR"));
    
    setModaliteDeclarativeFinContrat((String)pHandler.objectProperty("modaliteDeclarativeFinContrat", String.class));
    setModaliteDeclarativeFinContrat_C_ERR(pHandler.stringAttribute("modaliteDeclarativeFinContrat", "C_ERR"));
    
    setDjtp((Damj)pHandler.objectProperty("djtp", Damj.class));
    setDjtp_C_ERR(pHandler.stringAttribute("djtp", "C_ERR"));
  }
  
  public String _getDatabeanName()
  {
    return "FluxCtPasDsn";
  }
  
  public boolean _isValidProperty(String pElementName)
  {
    if ("typeEnreg".equals(pElementName)) {
      return true;
    }
    if ("numNIRCertifie".equals(pElementName)) {
      return true;
    }
    if ("nomDeclare".equals(pElementName)) {
      return true;
    }
    if ("prenomDeclare".equals(pElementName)) {
      return true;
    }
    if ("dateNaissance".equals(pElementName)) {
      return true;
    }
    if ("contexteEmission".equals(pElementName)) {
      return true;
    }
    if ("natureJustificatif".equals(pElementName)) {
      return true;
    }
    if ("codeMessage".equals(pElementName)) {
      return true;
    }
    if ("numeroVersion".equals(pElementName)) {
      return true;
    }
    if ("numeroSousVersion".equals(pElementName)) {
      return true;
    }
    if ("codeAction".equals(pElementName)) {
      return true;
    }
    if ("idTechnique".equals(pElementName)) {
      return true;
    }
    if ("idRCE".equals(pElementName)) {
      return true;
    }
    if ("siretDeclare".equals(pElementName)) {
      return true;
    }
    if ("refContratEmployeur".equals(pElementName)) {
      return true;
    }
    if ("nbMessagesPrimesIndemnites".equals(pElementName)) {
      return true;
    }
    if ("dateConnaissanceMensuelle".equals(pElementName)) {
      return true;
    }
    if ("dateMoisDeclare".equals(pElementName)) {
      return true;
    }
    if ("dateDebutContrat".equals(pElementName)) {
      return true;
    }
    if ("dateFinContrat".equals(pElementName)) {
      return true;
    }
    if ("natureContrat".equals(pElementName)) {
      return true;
    }
    if ("typeContrat".equals(pElementName)) {
      return true;
    }
    if ("codeStatutCadre".equals(pElementName)) {
      return true;
    }
    if ("horaireSalarie".equals(pElementName)) {
      return true;
    }
    if ("horaireEntreprise".equals(pElementName)) {
      return true;
    }
    if ("uniteTempsTravail".equals(pElementName)) {
      return true;
    }
    if ("alsaceMoselle".equals(pElementName)) {
      return true;
    }
    if ("regimeSpecialSecuriteSoc".equals(pElementName)) {
      return true;
    }
    if ("typeCaisseCP".equals(pElementName)) {
      return true;
    }
    if ("niveauQualification".equals(pElementName)) {
      return true;
    }
    if ("codeCaisseRetraiteCompl".equals(pElementName)) {
      return true;
    }
    if ("champApplicationEmployeur".equals(pElementName)) {
      return true;
    }
    if ("numConventionGestionEmpPublic".equals(pElementName)) {
      return true;
    }
    if ("etablissementFinancier".equals(pElementName)) {
      return true;
    }
    if ("codeAffectation".equals(pElementName)) {
      return true;
    }
    if ("numInterneEmpPublic".equals(pElementName)) {
      return true;
    }
    if ("statutSalarie".equals(pElementName)) {
      return true;
    }
    if ("dateAdhesion".equals(pElementName)) {
      return true;
    }
    if ("motifPeriodeInactivite".equals(pElementName)) {
      return true;
    }
    if ("dateDebutPeriodeInactivite".equals(pElementName)) {
      return true;
    }
    if ("dateFinPeriodeInactivite".equals(pElementName)) {
      return true;
    }
    if ("dateDebutPeriodeSalaire".equals(pElementName)) {
      return true;
    }
    if ("dateFinPeriodeSalaire".equals(pElementName)) {
      return true;
    }
    if ("codePcsEse".equals(pElementName)) {
      return true;
    }
    if ("codeComplementPcsEse".equals(pElementName)) {
      return true;
    }
    if ("signeSalaireBrutAbattu".equals(pElementName)) {
      return true;
    }
    if ("salaireBrutAbattu".equals(pElementName)) {
      return true;
    }
    if ("datePaiement".equals(pElementName)) {
      return true;
    }
    if ("dureeAbsence".equals(pElementName)) {
      return true;
    }
    if ("uniteAbsence".equals(pElementName)) {
      return true;
    }
    if ("nomLogiciel".equals(pElementName)) {
      return true;
    }
    if ("versionLogiciel".equals(pElementName)) {
      return true;
    }
    if ("numeroRCI".equals(pElementName)) {
      return true;
    }
    if ("cxass".equals(pElementName)) {
      return true;
    }
    if ("rsin".equals(pElementName)) {
      return true;
    }
    if ("nom".equals(pElementName)) {
      return true;
    }
    if ("prenom".equals(pElementName)) {
      return true;
    }
    if ("peAffi".equals(pElementName)) {
      return true;
    }
    if ("siret".equals(pElementName)) {
      return true;
    }
    if ("emplNumAffi".equals(pElementName)) {
      return true;
    }
    if ("emplRaisonSociale".equals(pElementName)) {
      return true;
    }
    if ("emplNAF".equals(pElementName)) {
      return true;
    }
    if ("emplCommune".equals(pElementName)) {
      return true;
    }
    if ("emplCP".equals(pElementName)) {
      return true;
    }
    if ("idBNEArrco".equals(pElementName)) {
      return true;
    }
    if ("arrcoSigle".equals(pElementName)) {
      return true;
    }
    if ("arrcoRaisonSociale".equals(pElementName)) {
      return true;
    }
    if ("idBNEAgirc".equals(pElementName)) {
      return true;
    }
    if ("agircSigle".equals(pElementName)) {
      return true;
    }
    if ("agircRaisonSociale".equals(pElementName)) {
      return true;
    }
    if ("codeRegimeCrpCtp".equals(pElementName)) {
      return true;
    }
    if ("dateEffetRegimeCrpCtp".equals(pElementName)) {
      return true;
    }
    if ("emplNumConventionGestion".equals(pElementName)) {
      return true;
    }
    if ("nbSalariesEntreprise".equals(pElementName)) {
      return true;
    }
    if ("nomEmployeur".equals(pElementName)) {
      return true;
    }
    if ("prenomEmployeur".equals(pElementName)) {
      return true;
    }
    if ("categorieJuridique".equals(pElementName)) {
      return true;
    }
    if ("codeRegimeEntreprise".equals(pElementName)) {
      return true;
    }
    if ("dateCessationEntreprise".equals(pElementName)) {
      return true;
    }
    if ("natureEntreprise".equals(pElementName)) {
      return true;
    }
    if ("numMSAEntreprise".equals(pElementName)) {
      return true;
    }
    if ("debutPeriodeAffiliationEntreprise".equals(pElementName)) {
      return true;
    }
    if ("finPeriodeAffiliationEntreprise".equals(pElementName)) {
      return true;
    }
    if ("debutConventionGestion".equals(pElementName)) {
      return true;
    }
    if ("finConventionGestion".equals(pElementName)) {
      return true;
    }
    if ("secteurPublic".equals(pElementName)) {
      return true;
    }
    if ("trancheEffectifEntreprise".equals(pElementName)) {
      return true;
    }
    if ("debutAGS".equals(pElementName)) {
      return true;
    }
    if ("finAGS".equals(pElementName)) {
      return true;
    }
    if ("debutAdhesionRevocable".equals(pElementName)) {
      return true;
    }
    if ("finAdhesionRevocable".equals(pElementName)) {
      return true;
    }
    if ("ListeFluxQuantiteTravailDsn".equals(pElementName)) {
      return true;
    }
    if ("motifFinContrat".equals(pElementName)) {
      return true;
    }
    if ("dateInitialeFinContrat".equals(pElementName)) {
      return true;
    }
    if ("idActiviteDsnPe".equals(pElementName)) {
      return true;
    }
    if ("signeDureeAbsence".equals(pElementName)) {
      return true;
    }
    if ("ListeFluxPrimeIndemDsn".equals(pElementName)) {
      return true;
    }
    if ("identDeclPri".equals(pElementName)) {
      return true;
    }
    if ("identDeclSec".equals(pElementName)) {
      return true;
    }
    if ("motifRecours".equals(pElementName)) {
      return true;
    }
    if ("modaliteDeclarativeFinContrat".equals(pElementName)) {
      return true;
    }
    if ("djtp".equals(pElementName)) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _FluxCtPasDsn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */