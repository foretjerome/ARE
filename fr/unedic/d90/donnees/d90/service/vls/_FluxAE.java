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

public class _FluxAE
  extends DataBeanImpl
  implements DataBean, Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  private String m__C_ETAT;
  private String m__IDENT;
  private _ListeFluxFctDnaPreavis m_listeFluxFctDnaPreavis;
  private String m_listeFluxFctDnaPreavis_C_ERR;
  private _ListeFluxFctDnaIndemnitesVersees m_listeFluxFctDnaIndemnitesVersees;
  private String m_listeFluxFctDnaIndemnitesVersees_C_ERR;
  private _ListeFluxPasDna m_listeFluxPasDna;
  private String m_listeFluxPasDna_C_ERR;
  private String m_codeMessage;
  private String m_codeMessage_C_ERR;
  private String m_codeAction;
  private String m_codeAction_C_ERR;
  private String m_SIRET;
  private String m_SIRET_C_ERR;
  private String m_referenceContrat;
  private String m_referenceContrat_C_ERR;
  private String m_natureContrat;
  private String m_natureContrat_C_ERR;
  private String m_motifRupture;
  private String m_motifRupture_C_ERR;
  private String m_clauseNonConcurrence;
  private String m_clauseNonConcurrence_C_ERR;
  private String m_regimeSpecialSS;
  private String m_regimeSpecialSS_C_ERR;
  private String m_numeroAffiRegimeSpecialSS;
  private String m_numeroAffiRegimeSpecialSS_C_ERR;
  private String m_lienParente;
  private String m_lienParente_C_ERR;
  private String m_statutParticulier;
  private String m_statutParticulier_C_ERR;
  private String m_niveauQualif;
  private String m_niveauQualif_C_ERR;
  private String m_topTransaction;
  private String m_topTransaction_C_ERR;
  private String m_bneIdentifiantBne;
  private String m_bneIdentifiantBne_C_ERR;
  private String m_bneSiret;
  private String m_bneSiret_C_ERR;
  private String m_bneRaisonSociale;
  private String m_bneRaisonSociale_C_ERR;
  private String m_bneCodePostal;
  private String m_bneCodePostal_C_ERR;
  private String m_bneLibelleCommuneCNAVTS;
  private String m_bneLibelleCommuneCNAVTS_C_ERR;
  private String m_bneAssedicAffiliation;
  private String m_bneAssedicAffiliation_C_ERR;
  private String m_bneNumAffiliation;
  private String m_bneNumAffiliation_C_ERR;
  private String m_bneNouveauCodeNAF;
  private String m_bneNouveauCodeNAF_C_ERR;
  private String m_abonnementProvisoire;
  private String m_abonnementProvisoire_C_ERR;
  private String m_codeRegimeCTP;
  private String m_codeRegimeCTP_C_ERR;
  private String m_nomEmployeur;
  private String m_nomEmployeur_C_ERR;
  private String m_prenomEmployeur;
  private String m_prenomEmployeur_C_ERR;
  private String m_numUrssaf;
  private String m_numUrssaf_C_ERR;
  private String m_numCESU;
  private String m_numCESU_C_ERR;
  private String m_numPAJEEMPLOI;
  private String m_numPAJEEMPLOI_C_ERR;
  private String m_idBNIRemplace;
  private String m_idBNIRemplace_C_ERR;
  private String m_origineAE;
  private String m_origineAE_C_ERR;
  private String m_indicChomSsRCT;
  private String m_indicChomSsRCT_C_ERR;
  private String m_refusAdhesionFNE;
  private String m_refusAdhesionFNE_C_ERR;
  private String m_codeStatutCadre;
  private String m_codeStatutCadre_C_ERR;
  private String m_cocheAlsaceMoselle;
  private String m_cocheAlsaceMoselle_C_ERR;
  private String m_indCotisationForfaitReel;
  private String m_indCotisationForfaitReel_C_ERR;
  private String m_indBrutNet;
  private String m_indBrutNet_C_ERR;
  private String m_codeCaisseCongesPayes;
  private String m_codeCaisseCongesPayes_C_ERR;
  private String m_numCaisseCP;
  private String m_numCaisseCP_C_ERR;
  private String m_codeARRCO;
  private String m_codeARRCO_C_ERR;
  private String m_numBneARRCO;
  private String m_numBneARRCO_C_ERR;
  private String m_sigleARRCO;
  private String m_sigleARRCO_C_ERR;
  private String m_raisonSocialeARRCO;
  private String m_raisonSocialeARRCO_C_ERR;
  private String m_codeAGIRC;
  private String m_codeAGIRC_C_ERR;
  private String m_numBneAGIRC;
  private String m_numBneAGIRC_C_ERR;
  private String m_sigleAGIRC;
  private String m_sigleAGIRC_C_ERR;
  private String m_raisonSocialeAGIRC;
  private String m_raisonSocialeAGIRC_C_ERR;
  private String m_typeContrat;
  private String m_typeContrat_C_ERR;
  private String m_codeRegimeEmployeur;
  private String m_codeRegimeEmployeur_C_ERR;
  private String m_numConventionGestion;
  private String m_numConventionGestion_C_ERR;
  private String m_nomFamille;
  private String m_nomFamille_C_ERR;
  private String m_prenom;
  private String m_prenom_C_ERR;
  private String m_indicMontantIndemnite;
  private String m_indicMontantIndemnite_C_ERR;
  private String m_indicSalaireHoraire;
  private String m_indicSalaireHoraire_C_ERR;
  private String m_fillerUn;
  private String m_fillerUn_C_ERR;
  private String m_fillerDeux;
  private String m_fillerDeux_C_ERR;
  private String m_employAutoAssur;
  private String m_employAutoAssur_C_ERR;
  private String m_numCG;
  private String m_numCG_C_ERR;
  private String m_etabFinanc;
  private String m_etabFinanc_C_ERR;
  private String m_numInterne;
  private String m_numInterne_C_ERR;
  private String m_codeAffect;
  private String m_codeAffect_C_ERR;
  private String m_statutSalarie;
  private String m_statutSalarie_C_ERR;
  private String m_codeStatutjuridique;
  private String m_codeStatutjuridique_C_ERR;
  private String m_nomLogiciel;
  private String m_nomLogiciel_C_ERR;
  private String m_versionLogiciel;
  private String m_versionLogiciel_C_ERR;
  private String m_categorieJuridiqueEntreprise;
  private String m_categorieJuridiqueEntreprise_C_ERR;
  private String m_codeRegimeEntreprise;
  private String m_codeRegimeEntreprise_C_ERR;
  private String m_natureEntreprise;
  private String m_natureEntreprise_C_ERR;
  private String m_numGusoEntreprise;
  private String m_numGusoEntreprise_C_ERR;
  private String m_numMSAEntreprise;
  private String m_numMSAEntreprise_C_ERR;
  private String m_entreprisePublique;
  private String m_entreprisePublique_C_ERR;
  private String m_trancheEffectifEntreprise;
  private String m_trancheEffectifEntreprise_C_ERR;
  private Damj m_dateDebutContrat;
  private String m_dateDebutContrat_C_ERR;
  private Damj m_dateFinContrat;
  private String m_dateFinContrat_C_ERR;
  private Damj m_dateNotifRupture;
  private String m_dateNotifRupture_C_ERR;
  private Damj m_dateProcedureLicenciement;
  private String m_dateProcedureLicenciement_C_ERR;
  private Damj m_dateDJTP;
  private String m_dateDJTP_C_ERR;
  private Damj m_dateInitialeFinContrat;
  private String m_dateInitialeFinContrat_C_ERR;
  private Damj m_dateConnaissanceAE;
  private String m_dateConnaissanceAE_C_ERR;
  private Damj m_dateReprise;
  private String m_dateReprise_C_ERR;
  private Damj m_dateDebutIndemCP;
  private String m_dateDebutIndemCP_C_ERR;
  private Damj m_dateFinIndemCP;
  private String m_dateFinIndemCP_C_ERR;
  private Damj m_dateEffetCTP;
  private String m_dateEffetCTP_C_ERR;
  private Damj m_dateAdhesion;
  private String m_dateAdhesion_C_ERR;
  private Damj m_dateCessationActiviteEntreprise;
  private String m_dateCessationActiviteEntreprise_C_ERR;
  private Damj m_dateDebutPeriodeAffiliationEntreprise;
  private String m_dateDebutPeriodeAffiliationEntreprise_C_ERR;
  private Damj m_dateFinPeriodeAffiliationEntreprise;
  private String m_dateFinPeriodeAffiliationEntreprise_C_ERR;
  private Damj m_dateDebutEffetConGes;
  private String m_dateDebutEffetConGes_C_ERR;
  private Damj m_dateFinEffetConGes;
  private String m_dateFinEffetConGes_C_ERR;
  private BigDecimal m_numeroVersion;
  private String m_numeroVersion_C_ERR;
  private BigDecimal m_idTechContratDna;
  private String m_idTechContratDna_C_ERR;
  private BigDecimal m_nbCongesPayesRestant;
  private String m_nbCongesPayesRestant_C_ERR;
  private BigDecimal m_montantIndemnitePreavis;
  private String m_montantIndemnitePreavis_C_ERR;
  private BigDecimal m_nbHeuresDIF;
  private String m_nbHeuresDIF_C_ERR;
  private BigDecimal m_salaireHoraireNetSalarie;
  private String m_salaireHoraireNetSalarie_C_ERR;
  private BigDecimal m_idTechContratRemplace;
  private String m_idTechContratRemplace_C_ERR;
  private BigDecimal m_nbPAS;
  private String m_nbPAS_C_ERR;
  private BigDecimal m_nbSalariesEntreprise;
  private String m_nbSalariesEntreprise_C_ERR;
  private BigDecimal m_nbMoisPreavis;
  private String m_nbMoisPreavis_C_ERR;
  private Damj m_dateDebutPeriodeInactivite;
  private String m_dateDebutPeriodeInactivite_C_ERR;
  private Damj m_dateFinPeriodeInactivite;
  private String m_dateFinPeriodeInactivite_C_ERR;
  private String m_motifPeriodeInactivite;
  private String m_motifPeriodeInactivite_C_ERR;
  private Damj m_dateDebutAGS;
  private String m_dateDebutAGS_C_ERR;
  private Damj m_dateFinAGS;
  private String m_dateFinAGS_C_ERR;
  private Damj m_dateDebutAdhesionRevocable;
  private String m_dateDebutAdhesionRevocable_C_ERR;
  private Damj m_dateFinAdhesionRevocable;
  private String m_dateFinAdhesionRevocable_C_ERR;
  private String m_identiteDeclaree;
  private String m_identiteDeclaree_C_ERR;
  private String m_doute;
  private String m_doute_C_ERR;
  private String m_idDocumentNumerique;
  private String m_idDocumentNumerique_C_ERR;
  private BigDecimal m_ancienneteMois = new BigDecimal(0);
  private String m_ancienneteMois_C_ERR;
  private BigDecimal m_ancienneteAnnee = new BigDecimal(0);
  private String m_ancienneteAnnee_C_ERR;
  private String m_motifRecours;
  private String m_motifRecours_C_ERR;
  
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
  
  public _ListeFluxFctDnaPreavis getListeFluxFctDnaPreavis()
  {
    return m_listeFluxFctDnaPreavis;
  }
  
  public String getListeFluxFctDnaPreavis_C_ERR()
  {
    return m_listeFluxFctDnaPreavis_C_ERR;
  }
  
  public void setListeFluxFctDnaPreavis(_ListeFluxFctDnaPreavis pValeur)
  {
    m_listeFluxFctDnaPreavis = pValeur;
  }
  
  public void setListeFluxFctDnaPreavis_C_ERR(String pValeur_C_ERR)
  {
    m_listeFluxFctDnaPreavis_C_ERR = pValeur_C_ERR;
  }
  
  public _ListeFluxFctDnaIndemnitesVersees getListeFluxFctDnaIndemnitesVersees()
  {
    return m_listeFluxFctDnaIndemnitesVersees;
  }
  
  public String getListeFluxFctDnaIndemnitesVersees_C_ERR()
  {
    return m_listeFluxFctDnaIndemnitesVersees_C_ERR;
  }
  
  public void setListeFluxFctDnaIndemnitesVersees(_ListeFluxFctDnaIndemnitesVersees pValeur)
  {
    m_listeFluxFctDnaIndemnitesVersees = pValeur;
  }
  
  public void setListeFluxFctDnaIndemnitesVersees_C_ERR(String pValeur_C_ERR)
  {
    m_listeFluxFctDnaIndemnitesVersees_C_ERR = pValeur_C_ERR;
  }
  
  public _ListeFluxPasDna getListeFluxPasDna()
  {
    return m_listeFluxPasDna;
  }
  
  public String getListeFluxPasDna_C_ERR()
  {
    return m_listeFluxPasDna_C_ERR;
  }
  
  public void setListeFluxPasDna(_ListeFluxPasDna pValeur)
  {
    m_listeFluxPasDna = pValeur;
  }
  
  public void setListeFluxPasDna_C_ERR(String pValeur_C_ERR)
  {
    m_listeFluxPasDna_C_ERR = pValeur_C_ERR;
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
  
  public String getSIRET()
  {
    return m_SIRET;
  }
  
  public String getSIRET_C_ERR()
  {
    return m_SIRET_C_ERR;
  }
  
  public void setSIRET(String pValeur)
  {
    m_SIRET = pValeur;
  }
  
  public void setSIRET_C_ERR(String pValeur_C_ERR)
  {
    m_SIRET_C_ERR = pValeur_C_ERR;
  }
  
  public String getReferenceContrat()
  {
    return m_referenceContrat;
  }
  
  public String getReferenceContrat_C_ERR()
  {
    return m_referenceContrat_C_ERR;
  }
  
  public void setReferenceContrat(String pValeur)
  {
    m_referenceContrat = pValeur;
  }
  
  public void setReferenceContrat_C_ERR(String pValeur_C_ERR)
  {
    m_referenceContrat_C_ERR = pValeur_C_ERR;
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
  
  public String getMotifRupture()
  {
    return m_motifRupture;
  }
  
  public String getMotifRupture_C_ERR()
  {
    return m_motifRupture_C_ERR;
  }
  
  public void setMotifRupture(String pValeur)
  {
    m_motifRupture = pValeur;
  }
  
  public void setMotifRupture_C_ERR(String pValeur_C_ERR)
  {
    m_motifRupture_C_ERR = pValeur_C_ERR;
  }
  
  public String getClauseNonConcurrence()
  {
    return m_clauseNonConcurrence;
  }
  
  public String getClauseNonConcurrence_C_ERR()
  {
    return m_clauseNonConcurrence_C_ERR;
  }
  
  public void setClauseNonConcurrence(String pValeur)
  {
    m_clauseNonConcurrence = pValeur;
  }
  
  public void setClauseNonConcurrence_C_ERR(String pValeur_C_ERR)
  {
    m_clauseNonConcurrence_C_ERR = pValeur_C_ERR;
  }
  
  public String getRegimeSpecialSS()
  {
    return m_regimeSpecialSS;
  }
  
  public String getRegimeSpecialSS_C_ERR()
  {
    return m_regimeSpecialSS_C_ERR;
  }
  
  public void setRegimeSpecialSS(String pValeur)
  {
    m_regimeSpecialSS = pValeur;
  }
  
  public void setRegimeSpecialSS_C_ERR(String pValeur_C_ERR)
  {
    m_regimeSpecialSS_C_ERR = pValeur_C_ERR;
  }
  
  public String getNumeroAffiRegimeSpecialSS()
  {
    return m_numeroAffiRegimeSpecialSS;
  }
  
  public String getNumeroAffiRegimeSpecialSS_C_ERR()
  {
    return m_numeroAffiRegimeSpecialSS_C_ERR;
  }
  
  public void setNumeroAffiRegimeSpecialSS(String pValeur)
  {
    m_numeroAffiRegimeSpecialSS = pValeur;
  }
  
  public void setNumeroAffiRegimeSpecialSS_C_ERR(String pValeur_C_ERR)
  {
    m_numeroAffiRegimeSpecialSS_C_ERR = pValeur_C_ERR;
  }
  
  public String getLienParente()
  {
    return m_lienParente;
  }
  
  public String getLienParente_C_ERR()
  {
    return m_lienParente_C_ERR;
  }
  
  public void setLienParente(String pValeur)
  {
    m_lienParente = pValeur;
  }
  
  public void setLienParente_C_ERR(String pValeur_C_ERR)
  {
    m_lienParente_C_ERR = pValeur_C_ERR;
  }
  
  public String getStatutParticulier()
  {
    return m_statutParticulier;
  }
  
  public String getStatutParticulier_C_ERR()
  {
    return m_statutParticulier_C_ERR;
  }
  
  public void setStatutParticulier(String pValeur)
  {
    m_statutParticulier = pValeur;
  }
  
  public void setStatutParticulier_C_ERR(String pValeur_C_ERR)
  {
    m_statutParticulier_C_ERR = pValeur_C_ERR;
  }
  
  public String getNiveauQualif()
  {
    return m_niveauQualif;
  }
  
  public String getNiveauQualif_C_ERR()
  {
    return m_niveauQualif_C_ERR;
  }
  
  public void setNiveauQualif(String pValeur)
  {
    m_niveauQualif = pValeur;
  }
  
  public void setNiveauQualif_C_ERR(String pValeur_C_ERR)
  {
    m_niveauQualif_C_ERR = pValeur_C_ERR;
  }
  
  public String getTopTransaction()
  {
    return m_topTransaction;
  }
  
  public String getTopTransaction_C_ERR()
  {
    return m_topTransaction_C_ERR;
  }
  
  public void setTopTransaction(String pValeur)
  {
    m_topTransaction = pValeur;
  }
  
  public void setTopTransaction_C_ERR(String pValeur_C_ERR)
  {
    m_topTransaction_C_ERR = pValeur_C_ERR;
  }
  
  public String getBneIdentifiantBne()
  {
    return m_bneIdentifiantBne;
  }
  
  public String getBneIdentifiantBne_C_ERR()
  {
    return m_bneIdentifiantBne_C_ERR;
  }
  
  public void setBneIdentifiantBne(String pValeur)
  {
    m_bneIdentifiantBne = pValeur;
  }
  
  public void setBneIdentifiantBne_C_ERR(String pValeur_C_ERR)
  {
    m_bneIdentifiantBne_C_ERR = pValeur_C_ERR;
  }
  
  public String getBneSiret()
  {
    return m_bneSiret;
  }
  
  public String getBneSiret_C_ERR()
  {
    return m_bneSiret_C_ERR;
  }
  
  public void setBneSiret(String pValeur)
  {
    m_bneSiret = pValeur;
  }
  
  public void setBneSiret_C_ERR(String pValeur_C_ERR)
  {
    m_bneSiret_C_ERR = pValeur_C_ERR;
  }
  
  public String getBneRaisonSociale()
  {
    return m_bneRaisonSociale;
  }
  
  public String getBneRaisonSociale_C_ERR()
  {
    return m_bneRaisonSociale_C_ERR;
  }
  
  public void setBneRaisonSociale(String pValeur)
  {
    m_bneRaisonSociale = pValeur;
  }
  
  public void setBneRaisonSociale_C_ERR(String pValeur_C_ERR)
  {
    m_bneRaisonSociale_C_ERR = pValeur_C_ERR;
  }
  
  public String getBneCodePostal()
  {
    return m_bneCodePostal;
  }
  
  public String getBneCodePostal_C_ERR()
  {
    return m_bneCodePostal_C_ERR;
  }
  
  public void setBneCodePostal(String pValeur)
  {
    m_bneCodePostal = pValeur;
  }
  
  public void setBneCodePostal_C_ERR(String pValeur_C_ERR)
  {
    m_bneCodePostal_C_ERR = pValeur_C_ERR;
  }
  
  public String getBneLibelleCommuneCNAVTS()
  {
    return m_bneLibelleCommuneCNAVTS;
  }
  
  public String getBneLibelleCommuneCNAVTS_C_ERR()
  {
    return m_bneLibelleCommuneCNAVTS_C_ERR;
  }
  
  public void setBneLibelleCommuneCNAVTS(String pValeur)
  {
    m_bneLibelleCommuneCNAVTS = pValeur;
  }
  
  public void setBneLibelleCommuneCNAVTS_C_ERR(String pValeur_C_ERR)
  {
    m_bneLibelleCommuneCNAVTS_C_ERR = pValeur_C_ERR;
  }
  
  public String getBneAssedicAffiliation()
  {
    return m_bneAssedicAffiliation;
  }
  
  public String getBneAssedicAffiliation_C_ERR()
  {
    return m_bneAssedicAffiliation_C_ERR;
  }
  
  public void setBneAssedicAffiliation(String pValeur)
  {
    m_bneAssedicAffiliation = pValeur;
  }
  
  public void setBneAssedicAffiliation_C_ERR(String pValeur_C_ERR)
  {
    m_bneAssedicAffiliation_C_ERR = pValeur_C_ERR;
  }
  
  public String getBneNumAffiliation()
  {
    return m_bneNumAffiliation;
  }
  
  public String getBneNumAffiliation_C_ERR()
  {
    return m_bneNumAffiliation_C_ERR;
  }
  
  public void setBneNumAffiliation(String pValeur)
  {
    m_bneNumAffiliation = pValeur;
  }
  
  public void setBneNumAffiliation_C_ERR(String pValeur_C_ERR)
  {
    m_bneNumAffiliation_C_ERR = pValeur_C_ERR;
  }
  
  public String getBneNouveauCodeNAF()
  {
    return m_bneNouveauCodeNAF;
  }
  
  public String getBneNouveauCodeNAF_C_ERR()
  {
    return m_bneNouveauCodeNAF_C_ERR;
  }
  
  public void setBneNouveauCodeNAF(String pValeur)
  {
    m_bneNouveauCodeNAF = pValeur;
  }
  
  public void setBneNouveauCodeNAF_C_ERR(String pValeur_C_ERR)
  {
    m_bneNouveauCodeNAF_C_ERR = pValeur_C_ERR;
  }
  
  public String getAbonnementProvisoire()
  {
    return m_abonnementProvisoire;
  }
  
  public String getAbonnementProvisoire_C_ERR()
  {
    return m_abonnementProvisoire_C_ERR;
  }
  
  public void setAbonnementProvisoire(String pValeur)
  {
    m_abonnementProvisoire = pValeur;
  }
  
  public void setAbonnementProvisoire_C_ERR(String pValeur_C_ERR)
  {
    m_abonnementProvisoire_C_ERR = pValeur_C_ERR;
  }
  
  public String getCodeRegimeCTP()
  {
    return m_codeRegimeCTP;
  }
  
  public String getCodeRegimeCTP_C_ERR()
  {
    return m_codeRegimeCTP_C_ERR;
  }
  
  public void setCodeRegimeCTP(String pValeur)
  {
    m_codeRegimeCTP = pValeur;
  }
  
  public void setCodeRegimeCTP_C_ERR(String pValeur_C_ERR)
  {
    m_codeRegimeCTP_C_ERR = pValeur_C_ERR;
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
  
  public String getNumUrssaf()
  {
    return m_numUrssaf;
  }
  
  public String getNumUrssaf_C_ERR()
  {
    return m_numUrssaf_C_ERR;
  }
  
  public void setNumUrssaf(String pValeur)
  {
    m_numUrssaf = pValeur;
  }
  
  public void setNumUrssaf_C_ERR(String pValeur_C_ERR)
  {
    m_numUrssaf_C_ERR = pValeur_C_ERR;
  }
  
  public String getNumCESU()
  {
    return m_numCESU;
  }
  
  public String getNumCESU_C_ERR()
  {
    return m_numCESU_C_ERR;
  }
  
  public void setNumCESU(String pValeur)
  {
    m_numCESU = pValeur;
  }
  
  public void setNumCESU_C_ERR(String pValeur_C_ERR)
  {
    m_numCESU_C_ERR = pValeur_C_ERR;
  }
  
  public String getNumPAJEEMPLOI()
  {
    return m_numPAJEEMPLOI;
  }
  
  public String getNumPAJEEMPLOI_C_ERR()
  {
    return m_numPAJEEMPLOI_C_ERR;
  }
  
  public void setNumPAJEEMPLOI(String pValeur)
  {
    m_numPAJEEMPLOI = pValeur;
  }
  
  public void setNumPAJEEMPLOI_C_ERR(String pValeur_C_ERR)
  {
    m_numPAJEEMPLOI_C_ERR = pValeur_C_ERR;
  }
  
  public String getIdBNIRemplace()
  {
    return m_idBNIRemplace;
  }
  
  public String getIdBNIRemplace_C_ERR()
  {
    return m_idBNIRemplace_C_ERR;
  }
  
  public void setIdBNIRemplace(String pValeur)
  {
    m_idBNIRemplace = pValeur;
  }
  
  public void setIdBNIRemplace_C_ERR(String pValeur_C_ERR)
  {
    m_idBNIRemplace_C_ERR = pValeur_C_ERR;
  }
  
  public String getOrigineAE()
  {
    return m_origineAE;
  }
  
  public String getOrigineAE_C_ERR()
  {
    return m_origineAE_C_ERR;
  }
  
  public void setOrigineAE(String pValeur)
  {
    m_origineAE = pValeur;
  }
  
  public void setOrigineAE_C_ERR(String pValeur_C_ERR)
  {
    m_origineAE_C_ERR = pValeur_C_ERR;
  }
  
  public String getIndicChomSsRCT()
  {
    return m_indicChomSsRCT;
  }
  
  public String getIndicChomSsRCT_C_ERR()
  {
    return m_indicChomSsRCT_C_ERR;
  }
  
  public void setIndicChomSsRCT(String pValeur)
  {
    m_indicChomSsRCT = pValeur;
  }
  
  public void setIndicChomSsRCT_C_ERR(String pValeur_C_ERR)
  {
    m_indicChomSsRCT_C_ERR = pValeur_C_ERR;
  }
  
  public String getRefusAdhesionFNE()
  {
    return m_refusAdhesionFNE;
  }
  
  public String getRefusAdhesionFNE_C_ERR()
  {
    return m_refusAdhesionFNE_C_ERR;
  }
  
  public void setRefusAdhesionFNE(String pValeur)
  {
    m_refusAdhesionFNE = pValeur;
  }
  
  public void setRefusAdhesionFNE_C_ERR(String pValeur_C_ERR)
  {
    m_refusAdhesionFNE_C_ERR = pValeur_C_ERR;
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
  
  public String getCocheAlsaceMoselle()
  {
    return m_cocheAlsaceMoselle;
  }
  
  public String getCocheAlsaceMoselle_C_ERR()
  {
    return m_cocheAlsaceMoselle_C_ERR;
  }
  
  public void setCocheAlsaceMoselle(String pValeur)
  {
    m_cocheAlsaceMoselle = pValeur;
  }
  
  public void setCocheAlsaceMoselle_C_ERR(String pValeur_C_ERR)
  {
    m_cocheAlsaceMoselle_C_ERR = pValeur_C_ERR;
  }
  
  public String getIndCotisationForfaitReel()
  {
    return m_indCotisationForfaitReel;
  }
  
  public String getIndCotisationForfaitReel_C_ERR()
  {
    return m_indCotisationForfaitReel_C_ERR;
  }
  
  public void setIndCotisationForfaitReel(String pValeur)
  {
    m_indCotisationForfaitReel = pValeur;
  }
  
  public void setIndCotisationForfaitReel_C_ERR(String pValeur_C_ERR)
  {
    m_indCotisationForfaitReel_C_ERR = pValeur_C_ERR;
  }
  
  public String getIndBrutNet()
  {
    return m_indBrutNet;
  }
  
  public String getIndBrutNet_C_ERR()
  {
    return m_indBrutNet_C_ERR;
  }
  
  public void setIndBrutNet(String pValeur)
  {
    m_indBrutNet = pValeur;
  }
  
  public void setIndBrutNet_C_ERR(String pValeur_C_ERR)
  {
    m_indBrutNet_C_ERR = pValeur_C_ERR;
  }
  
  public String getCodeCaisseCongesPayes()
  {
    return m_codeCaisseCongesPayes;
  }
  
  public String getCodeCaisseCongesPayes_C_ERR()
  {
    return m_codeCaisseCongesPayes_C_ERR;
  }
  
  public void setCodeCaisseCongesPayes(String pValeur)
  {
    m_codeCaisseCongesPayes = pValeur;
  }
  
  public void setCodeCaisseCongesPayes_C_ERR(String pValeur_C_ERR)
  {
    m_codeCaisseCongesPayes_C_ERR = pValeur_C_ERR;
  }
  
  public String getNumCaisseCP()
  {
    return m_numCaisseCP;
  }
  
  public String getNumCaisseCP_C_ERR()
  {
    return m_numCaisseCP_C_ERR;
  }
  
  public void setNumCaisseCP(String pValeur)
  {
    m_numCaisseCP = pValeur;
  }
  
  public void setNumCaisseCP_C_ERR(String pValeur_C_ERR)
  {
    m_numCaisseCP_C_ERR = pValeur_C_ERR;
  }
  
  public String getCodeARRCO()
  {
    return m_codeARRCO;
  }
  
  public String getCodeARRCO_C_ERR()
  {
    return m_codeARRCO_C_ERR;
  }
  
  public void setCodeARRCO(String pValeur)
  {
    m_codeARRCO = pValeur;
  }
  
  public void setCodeARRCO_C_ERR(String pValeur_C_ERR)
  {
    m_codeARRCO_C_ERR = pValeur_C_ERR;
  }
  
  public String getNumBneARRCO()
  {
    return m_numBneARRCO;
  }
  
  public String getNumBneARRCO_C_ERR()
  {
    return m_numBneARRCO_C_ERR;
  }
  
  public void setNumBneARRCO(String pValeur)
  {
    m_numBneARRCO = pValeur;
  }
  
  public void setNumBneARRCO_C_ERR(String pValeur_C_ERR)
  {
    m_numBneARRCO_C_ERR = pValeur_C_ERR;
  }
  
  public String getSigleARRCO()
  {
    return m_sigleARRCO;
  }
  
  public String getSigleARRCO_C_ERR()
  {
    return m_sigleARRCO_C_ERR;
  }
  
  public void setSigleARRCO(String pValeur)
  {
    m_sigleARRCO = pValeur;
  }
  
  public void setSigleARRCO_C_ERR(String pValeur_C_ERR)
  {
    m_sigleARRCO_C_ERR = pValeur_C_ERR;
  }
  
  public String getRaisonSocialeARRCO()
  {
    return m_raisonSocialeARRCO;
  }
  
  public String getRaisonSocialeARRCO_C_ERR()
  {
    return m_raisonSocialeARRCO_C_ERR;
  }
  
  public void setRaisonSocialeARRCO(String pValeur)
  {
    m_raisonSocialeARRCO = pValeur;
  }
  
  public void setRaisonSocialeARRCO_C_ERR(String pValeur_C_ERR)
  {
    m_raisonSocialeARRCO_C_ERR = pValeur_C_ERR;
  }
  
  public String getCodeAGIRC()
  {
    return m_codeAGIRC;
  }
  
  public String getCodeAGIRC_C_ERR()
  {
    return m_codeAGIRC_C_ERR;
  }
  
  public void setCodeAGIRC(String pValeur)
  {
    m_codeAGIRC = pValeur;
  }
  
  public void setCodeAGIRC_C_ERR(String pValeur_C_ERR)
  {
    m_codeAGIRC_C_ERR = pValeur_C_ERR;
  }
  
  public String getNumBneAGIRC()
  {
    return m_numBneAGIRC;
  }
  
  public String getNumBneAGIRC_C_ERR()
  {
    return m_numBneAGIRC_C_ERR;
  }
  
  public void setNumBneAGIRC(String pValeur)
  {
    m_numBneAGIRC = pValeur;
  }
  
  public void setNumBneAGIRC_C_ERR(String pValeur_C_ERR)
  {
    m_numBneAGIRC_C_ERR = pValeur_C_ERR;
  }
  
  public String getSigleAGIRC()
  {
    return m_sigleAGIRC;
  }
  
  public String getSigleAGIRC_C_ERR()
  {
    return m_sigleAGIRC_C_ERR;
  }
  
  public void setSigleAGIRC(String pValeur)
  {
    m_sigleAGIRC = pValeur;
  }
  
  public void setSigleAGIRC_C_ERR(String pValeur_C_ERR)
  {
    m_sigleAGIRC_C_ERR = pValeur_C_ERR;
  }
  
  public String getRaisonSocialeAGIRC()
  {
    return m_raisonSocialeAGIRC;
  }
  
  public String getRaisonSocialeAGIRC_C_ERR()
  {
    return m_raisonSocialeAGIRC_C_ERR;
  }
  
  public void setRaisonSocialeAGIRC(String pValeur)
  {
    m_raisonSocialeAGIRC = pValeur;
  }
  
  public void setRaisonSocialeAGIRC_C_ERR(String pValeur_C_ERR)
  {
    m_raisonSocialeAGIRC_C_ERR = pValeur_C_ERR;
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
  
  public String getCodeRegimeEmployeur()
  {
    return m_codeRegimeEmployeur;
  }
  
  public String getCodeRegimeEmployeur_C_ERR()
  {
    return m_codeRegimeEmployeur_C_ERR;
  }
  
  public void setCodeRegimeEmployeur(String pValeur)
  {
    m_codeRegimeEmployeur = pValeur;
  }
  
  public void setCodeRegimeEmployeur_C_ERR(String pValeur_C_ERR)
  {
    m_codeRegimeEmployeur_C_ERR = pValeur_C_ERR;
  }
  
  public String getNumConventionGestion()
  {
    return m_numConventionGestion;
  }
  
  public String getNumConventionGestion_C_ERR()
  {
    return m_numConventionGestion_C_ERR;
  }
  
  public void setNumConventionGestion(String pValeur)
  {
    m_numConventionGestion = pValeur;
  }
  
  public void setNumConventionGestion_C_ERR(String pValeur_C_ERR)
  {
    m_numConventionGestion_C_ERR = pValeur_C_ERR;
  }
  
  public String getNomFamille()
  {
    return m_nomFamille;
  }
  
  public String getNomFamille_C_ERR()
  {
    return m_nomFamille_C_ERR;
  }
  
  public void setNomFamille(String pValeur)
  {
    m_nomFamille = pValeur;
  }
  
  public void setNomFamille_C_ERR(String pValeur_C_ERR)
  {
    m_nomFamille_C_ERR = pValeur_C_ERR;
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
  
  public String getIndicMontantIndemnite()
  {
    return m_indicMontantIndemnite;
  }
  
  public String getIndicMontantIndemnite_C_ERR()
  {
    return m_indicMontantIndemnite_C_ERR;
  }
  
  public void setIndicMontantIndemnite(String pValeur)
  {
    m_indicMontantIndemnite = pValeur;
  }
  
  public void setIndicMontantIndemnite_C_ERR(String pValeur_C_ERR)
  {
    m_indicMontantIndemnite_C_ERR = pValeur_C_ERR;
  }
  
  public String getIndicSalaireHoraire()
  {
    return m_indicSalaireHoraire;
  }
  
  public String getIndicSalaireHoraire_C_ERR()
  {
    return m_indicSalaireHoraire_C_ERR;
  }
  
  public void setIndicSalaireHoraire(String pValeur)
  {
    m_indicSalaireHoraire = pValeur;
  }
  
  public void setIndicSalaireHoraire_C_ERR(String pValeur_C_ERR)
  {
    m_indicSalaireHoraire_C_ERR = pValeur_C_ERR;
  }
  
  public String getFillerUn()
  {
    return m_fillerUn;
  }
  
  public String getFillerUn_C_ERR()
  {
    return m_fillerUn_C_ERR;
  }
  
  public void setFillerUn(String pValeur)
  {
    m_fillerUn = pValeur;
  }
  
  public void setFillerUn_C_ERR(String pValeur_C_ERR)
  {
    m_fillerUn_C_ERR = pValeur_C_ERR;
  }
  
  public String getFillerDeux()
  {
    return m_fillerDeux;
  }
  
  public String getFillerDeux_C_ERR()
  {
    return m_fillerDeux_C_ERR;
  }
  
  public void setFillerDeux(String pValeur)
  {
    m_fillerDeux = pValeur;
  }
  
  public void setFillerDeux_C_ERR(String pValeur_C_ERR)
  {
    m_fillerDeux_C_ERR = pValeur_C_ERR;
  }
  
  public String getEmployAutoAssur()
  {
    return m_employAutoAssur;
  }
  
  public String getEmployAutoAssur_C_ERR()
  {
    return m_employAutoAssur_C_ERR;
  }
  
  public void setEmployAutoAssur(String pValeur)
  {
    m_employAutoAssur = pValeur;
  }
  
  public void setEmployAutoAssur_C_ERR(String pValeur_C_ERR)
  {
    m_employAutoAssur_C_ERR = pValeur_C_ERR;
  }
  
  public String getNumCG()
  {
    return m_numCG;
  }
  
  public String getNumCG_C_ERR()
  {
    return m_numCG_C_ERR;
  }
  
  public void setNumCG(String pValeur)
  {
    m_numCG = pValeur;
  }
  
  public void setNumCG_C_ERR(String pValeur_C_ERR)
  {
    m_numCG_C_ERR = pValeur_C_ERR;
  }
  
  public String getEtabFinanc()
  {
    return m_etabFinanc;
  }
  
  public String getEtabFinanc_C_ERR()
  {
    return m_etabFinanc_C_ERR;
  }
  
  public void setEtabFinanc(String pValeur)
  {
    m_etabFinanc = pValeur;
  }
  
  public void setEtabFinanc_C_ERR(String pValeur_C_ERR)
  {
    m_etabFinanc_C_ERR = pValeur_C_ERR;
  }
  
  public String getNumInterne()
  {
    return m_numInterne;
  }
  
  public String getNumInterne_C_ERR()
  {
    return m_numInterne_C_ERR;
  }
  
  public void setNumInterne(String pValeur)
  {
    m_numInterne = pValeur;
  }
  
  public void setNumInterne_C_ERR(String pValeur_C_ERR)
  {
    m_numInterne_C_ERR = pValeur_C_ERR;
  }
  
  public String getCodeAffect()
  {
    return m_codeAffect;
  }
  
  public String getCodeAffect_C_ERR()
  {
    return m_codeAffect_C_ERR;
  }
  
  public void setCodeAffect(String pValeur)
  {
    m_codeAffect = pValeur;
  }
  
  public void setCodeAffect_C_ERR(String pValeur_C_ERR)
  {
    m_codeAffect_C_ERR = pValeur_C_ERR;
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
  
  public String getCodeStatutjuridique()
  {
    return m_codeStatutjuridique;
  }
  
  public String getCodeStatutjuridique_C_ERR()
  {
    return m_codeStatutjuridique_C_ERR;
  }
  
  public void setCodeStatutjuridique(String pValeur)
  {
    m_codeStatutjuridique = pValeur;
  }
  
  public void setCodeStatutjuridique_C_ERR(String pValeur_C_ERR)
  {
    m_codeStatutjuridique_C_ERR = pValeur_C_ERR;
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
  
  public String getCategorieJuridiqueEntreprise()
  {
    return m_categorieJuridiqueEntreprise;
  }
  
  public String getCategorieJuridiqueEntreprise_C_ERR()
  {
    return m_categorieJuridiqueEntreprise_C_ERR;
  }
  
  public void setCategorieJuridiqueEntreprise(String pValeur)
  {
    m_categorieJuridiqueEntreprise = pValeur;
  }
  
  public void setCategorieJuridiqueEntreprise_C_ERR(String pValeur_C_ERR)
  {
    m_categorieJuridiqueEntreprise_C_ERR = pValeur_C_ERR;
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
  
  public String getNumGusoEntreprise()
  {
    return m_numGusoEntreprise;
  }
  
  public String getNumGusoEntreprise_C_ERR()
  {
    return m_numGusoEntreprise_C_ERR;
  }
  
  public void setNumGusoEntreprise(String pValeur)
  {
    m_numGusoEntreprise = pValeur;
  }
  
  public void setNumGusoEntreprise_C_ERR(String pValeur_C_ERR)
  {
    m_numGusoEntreprise_C_ERR = pValeur_C_ERR;
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
  
  public String getEntreprisePublique()
  {
    return m_entreprisePublique;
  }
  
  public String getEntreprisePublique_C_ERR()
  {
    return m_entreprisePublique_C_ERR;
  }
  
  public void setEntreprisePublique(String pValeur)
  {
    m_entreprisePublique = pValeur;
  }
  
  public void setEntreprisePublique_C_ERR(String pValeur_C_ERR)
  {
    m_entreprisePublique_C_ERR = pValeur_C_ERR;
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
  
  public Damj getDateNotifRupture()
  {
    return m_dateNotifRupture;
  }
  
  public String getDateNotifRupture_C_ERR()
  {
    return m_dateNotifRupture_C_ERR;
  }
  
  public void setDateNotifRupture(Damj pValeur)
  {
    m_dateNotifRupture = pValeur;
  }
  
  public void setDateNotifRupture_C_ERR(String pValeur_C_ERR)
  {
    m_dateNotifRupture_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDateProcedureLicenciement()
  {
    return m_dateProcedureLicenciement;
  }
  
  public String getDateProcedureLicenciement_C_ERR()
  {
    return m_dateProcedureLicenciement_C_ERR;
  }
  
  public void setDateProcedureLicenciement(Damj pValeur)
  {
    m_dateProcedureLicenciement = pValeur;
  }
  
  public void setDateProcedureLicenciement_C_ERR(String pValeur_C_ERR)
  {
    m_dateProcedureLicenciement_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDateDJTP()
  {
    return m_dateDJTP;
  }
  
  public String getDateDJTP_C_ERR()
  {
    return m_dateDJTP_C_ERR;
  }
  
  public void setDateDJTP(Damj pValeur)
  {
    m_dateDJTP = pValeur;
  }
  
  public void setDateDJTP_C_ERR(String pValeur_C_ERR)
  {
    m_dateDJTP_C_ERR = pValeur_C_ERR;
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
  
  public Damj getDateConnaissanceAE()
  {
    return m_dateConnaissanceAE;
  }
  
  public String getDateConnaissanceAE_C_ERR()
  {
    return m_dateConnaissanceAE_C_ERR;
  }
  
  public void setDateConnaissanceAE(Damj pValeur)
  {
    m_dateConnaissanceAE = pValeur;
  }
  
  public void setDateConnaissanceAE_C_ERR(String pValeur_C_ERR)
  {
    m_dateConnaissanceAE_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDateReprise()
  {
    return m_dateReprise;
  }
  
  public String getDateReprise_C_ERR()
  {
    return m_dateReprise_C_ERR;
  }
  
  public void setDateReprise(Damj pValeur)
  {
    m_dateReprise = pValeur;
  }
  
  public void setDateReprise_C_ERR(String pValeur_C_ERR)
  {
    m_dateReprise_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDateDebutIndemCP()
  {
    return m_dateDebutIndemCP;
  }
  
  public String getDateDebutIndemCP_C_ERR()
  {
    return m_dateDebutIndemCP_C_ERR;
  }
  
  public void setDateDebutIndemCP(Damj pValeur)
  {
    m_dateDebutIndemCP = pValeur;
  }
  
  public void setDateDebutIndemCP_C_ERR(String pValeur_C_ERR)
  {
    m_dateDebutIndemCP_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDateFinIndemCP()
  {
    return m_dateFinIndemCP;
  }
  
  public String getDateFinIndemCP_C_ERR()
  {
    return m_dateFinIndemCP_C_ERR;
  }
  
  public void setDateFinIndemCP(Damj pValeur)
  {
    m_dateFinIndemCP = pValeur;
  }
  
  public void setDateFinIndemCP_C_ERR(String pValeur_C_ERR)
  {
    m_dateFinIndemCP_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDateEffetCTP()
  {
    return m_dateEffetCTP;
  }
  
  public String getDateEffetCTP_C_ERR()
  {
    return m_dateEffetCTP_C_ERR;
  }
  
  public void setDateEffetCTP(Damj pValeur)
  {
    m_dateEffetCTP = pValeur;
  }
  
  public void setDateEffetCTP_C_ERR(String pValeur_C_ERR)
  {
    m_dateEffetCTP_C_ERR = pValeur_C_ERR;
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
  
  public Damj getDateCessationActiviteEntreprise()
  {
    return m_dateCessationActiviteEntreprise;
  }
  
  public String getDateCessationActiviteEntreprise_C_ERR()
  {
    return m_dateCessationActiviteEntreprise_C_ERR;
  }
  
  public void setDateCessationActiviteEntreprise(Damj pValeur)
  {
    m_dateCessationActiviteEntreprise = pValeur;
  }
  
  public void setDateCessationActiviteEntreprise_C_ERR(String pValeur_C_ERR)
  {
    m_dateCessationActiviteEntreprise_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDateDebutPeriodeAffiliationEntreprise()
  {
    return m_dateDebutPeriodeAffiliationEntreprise;
  }
  
  public String getDateDebutPeriodeAffiliationEntreprise_C_ERR()
  {
    return m_dateDebutPeriodeAffiliationEntreprise_C_ERR;
  }
  
  public void setDateDebutPeriodeAffiliationEntreprise(Damj pValeur)
  {
    m_dateDebutPeriodeAffiliationEntreprise = pValeur;
  }
  
  public void setDateDebutPeriodeAffiliationEntreprise_C_ERR(String pValeur_C_ERR)
  {
    m_dateDebutPeriodeAffiliationEntreprise_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDateFinPeriodeAffiliationEntreprise()
  {
    return m_dateFinPeriodeAffiliationEntreprise;
  }
  
  public String getDateFinPeriodeAffiliationEntreprise_C_ERR()
  {
    return m_dateFinPeriodeAffiliationEntreprise_C_ERR;
  }
  
  public void setDateFinPeriodeAffiliationEntreprise(Damj pValeur)
  {
    m_dateFinPeriodeAffiliationEntreprise = pValeur;
  }
  
  public void setDateFinPeriodeAffiliationEntreprise_C_ERR(String pValeur_C_ERR)
  {
    m_dateFinPeriodeAffiliationEntreprise_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDateDebutEffetConGes()
  {
    return m_dateDebutEffetConGes;
  }
  
  public String getDateDebutEffetConGes_C_ERR()
  {
    return m_dateDebutEffetConGes_C_ERR;
  }
  
  public void setDateDebutEffetConGes(Damj pValeur)
  {
    m_dateDebutEffetConGes = pValeur;
  }
  
  public void setDateDebutEffetConGes_C_ERR(String pValeur_C_ERR)
  {
    m_dateDebutEffetConGes_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDateFinEffetConGes()
  {
    return m_dateFinEffetConGes;
  }
  
  public String getDateFinEffetConGes_C_ERR()
  {
    return m_dateFinEffetConGes_C_ERR;
  }
  
  public void setDateFinEffetConGes(Damj pValeur)
  {
    m_dateFinEffetConGes = pValeur;
  }
  
  public void setDateFinEffetConGes_C_ERR(String pValeur_C_ERR)
  {
    m_dateFinEffetConGes_C_ERR = pValeur_C_ERR;
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
  
  public BigDecimal getIdTechContratDna()
  {
    return m_idTechContratDna;
  }
  
  public String getIdTechContratDna_C_ERR()
  {
    return m_idTechContratDna_C_ERR;
  }
  
  public void setIdTechContratDna(BigDecimal pValeur)
  {
    m_idTechContratDna = pValeur;
  }
  
  public void setIdTechContratDna_C_ERR(String pValeur_C_ERR)
  {
    m_idTechContratDna_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getNbCongesPayesRestant()
  {
    return m_nbCongesPayesRestant;
  }
  
  public String getNbCongesPayesRestant_C_ERR()
  {
    return m_nbCongesPayesRestant_C_ERR;
  }
  
  public void setNbCongesPayesRestant(BigDecimal pValeur)
  {
    m_nbCongesPayesRestant = pValeur;
  }
  
  public void setNbCongesPayesRestant_C_ERR(String pValeur_C_ERR)
  {
    m_nbCongesPayesRestant_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getMontantIndemnitePreavis()
  {
    return m_montantIndemnitePreavis;
  }
  
  public String getMontantIndemnitePreavis_C_ERR()
  {
    return m_montantIndemnitePreavis_C_ERR;
  }
  
  public void setMontantIndemnitePreavis(BigDecimal pValeur)
  {
    m_montantIndemnitePreavis = pValeur;
  }
  
  public void setMontantIndemnitePreavis_C_ERR(String pValeur_C_ERR)
  {
    m_montantIndemnitePreavis_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getNbHeuresDIF()
  {
    return m_nbHeuresDIF;
  }
  
  public String getNbHeuresDIF_C_ERR()
  {
    return m_nbHeuresDIF_C_ERR;
  }
  
  public void setNbHeuresDIF(BigDecimal pValeur)
  {
    m_nbHeuresDIF = pValeur;
  }
  
  public void setNbHeuresDIF_C_ERR(String pValeur_C_ERR)
  {
    m_nbHeuresDIF_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getSalaireHoraireNetSalarie()
  {
    return m_salaireHoraireNetSalarie;
  }
  
  public String getSalaireHoraireNetSalarie_C_ERR()
  {
    return m_salaireHoraireNetSalarie_C_ERR;
  }
  
  public void setSalaireHoraireNetSalarie(BigDecimal pValeur)
  {
    m_salaireHoraireNetSalarie = pValeur;
  }
  
  public void setSalaireHoraireNetSalarie_C_ERR(String pValeur_C_ERR)
  {
    m_salaireHoraireNetSalarie_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getIdTechContratRemplace()
  {
    return m_idTechContratRemplace;
  }
  
  public String getIdTechContratRemplace_C_ERR()
  {
    return m_idTechContratRemplace_C_ERR;
  }
  
  public void setIdTechContratRemplace(BigDecimal pValeur)
  {
    m_idTechContratRemplace = pValeur;
  }
  
  public void setIdTechContratRemplace_C_ERR(String pValeur_C_ERR)
  {
    m_idTechContratRemplace_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getNbPAS()
  {
    return m_nbPAS;
  }
  
  public String getNbPAS_C_ERR()
  {
    return m_nbPAS_C_ERR;
  }
  
  public void setNbPAS(BigDecimal pValeur)
  {
    m_nbPAS = pValeur;
  }
  
  public void setNbPAS_C_ERR(String pValeur_C_ERR)
  {
    m_nbPAS_C_ERR = pValeur_C_ERR;
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
  
  public BigDecimal getNbMoisPreavis()
  {
    return m_nbMoisPreavis;
  }
  
  public String getNbMoisPreavis_C_ERR()
  {
    return m_nbMoisPreavis_C_ERR;
  }
  
  public void setNbMoisPreavis(BigDecimal pValeur)
  {
    m_nbMoisPreavis = pValeur;
  }
  
  public void setNbMoisPreavis_C_ERR(String pValeur_C_ERR)
  {
    m_nbMoisPreavis_C_ERR = pValeur_C_ERR;
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
  
  public Damj getDateDebutAGS()
  {
    return m_dateDebutAGS;
  }
  
  public String getDateDebutAGS_C_ERR()
  {
    return m_dateDebutAGS_C_ERR;
  }
  
  public void setDateDebutAGS(Damj pValeur)
  {
    m_dateDebutAGS = pValeur;
  }
  
  public void setDateDebutAGS_C_ERR(String pValeur_C_ERR)
  {
    m_dateDebutAGS_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDateFinAGS()
  {
    return m_dateFinAGS;
  }
  
  public String getDateFinAGS_C_ERR()
  {
    return m_dateFinAGS_C_ERR;
  }
  
  public void setDateFinAGS(Damj pValeur)
  {
    m_dateFinAGS = pValeur;
  }
  
  public void setDateFinAGS_C_ERR(String pValeur_C_ERR)
  {
    m_dateFinAGS_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDateDebutAdhesionRevocable()
  {
    return m_dateDebutAdhesionRevocable;
  }
  
  public String getDateDebutAdhesionRevocable_C_ERR()
  {
    return m_dateDebutAdhesionRevocable_C_ERR;
  }
  
  public void setDateDebutAdhesionRevocable(Damj pValeur)
  {
    m_dateDebutAdhesionRevocable = pValeur;
  }
  
  public void setDateDebutAdhesionRevocable_C_ERR(String pValeur_C_ERR)
  {
    m_dateDebutAdhesionRevocable_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDateFinAdhesionRevocable()
  {
    return m_dateFinAdhesionRevocable;
  }
  
  public String getDateFinAdhesionRevocable_C_ERR()
  {
    return m_dateFinAdhesionRevocable_C_ERR;
  }
  
  public void setDateFinAdhesionRevocable(Damj pValeur)
  {
    m_dateFinAdhesionRevocable = pValeur;
  }
  
  public void setDateFinAdhesionRevocable_C_ERR(String pValeur_C_ERR)
  {
    m_dateFinAdhesionRevocable_C_ERR = pValeur_C_ERR;
  }
  
  public String getIdentiteDeclaree()
  {
    return m_identiteDeclaree;
  }
  
  public String getIdentiteDeclaree_C_ERR()
  {
    return m_identiteDeclaree_C_ERR;
  }
  
  public void setIdentiteDeclaree(String pValeur)
  {
    m_identiteDeclaree = pValeur;
  }
  
  public void setIdentiteDeclaree_C_ERR(String pValeur_C_ERR)
  {
    m_identiteDeclaree_C_ERR = pValeur_C_ERR;
  }
  
  public String getDoute()
  {
    return m_doute;
  }
  
  public String getDoute_C_ERR()
  {
    return m_doute_C_ERR;
  }
  
  public void setDoute(String pValeur)
  {
    m_doute = pValeur;
  }
  
  public void setDoute_C_ERR(String pValeur_C_ERR)
  {
    m_doute_C_ERR = pValeur_C_ERR;
  }
  
  public String getIdDocumentNumerique()
  {
    return m_idDocumentNumerique;
  }
  
  public String getIdDocumentNumerique_C_ERR()
  {
    return m_idDocumentNumerique_C_ERR;
  }
  
  public void setIdDocumentNumerique(String pValeur)
  {
    m_idDocumentNumerique = pValeur;
  }
  
  public void setIdDocumentNumerique_C_ERR(String pValeur_C_ERR)
  {
    m_idDocumentNumerique_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getAncienneteMois()
  {
    return m_ancienneteMois;
  }
  
  public String getAncienneteMois_C_ERR()
  {
    return m_ancienneteMois_C_ERR;
  }
  
  public void setAncienneteMois(BigDecimal pValeur)
  {
    m_ancienneteMois = pValeur;
  }
  
  public void setAncienneteMois_C_ERR(String pValeur_C_ERR)
  {
    m_ancienneteMois_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getAncienneteAnnee()
  {
    return m_ancienneteAnnee;
  }
  
  public String getAncienneteAnnee_C_ERR()
  {
    return m_ancienneteAnnee_C_ERR;
  }
  
  public void setAncienneteAnnee(BigDecimal pValeur)
  {
    m_ancienneteAnnee = pValeur;
  }
  
  public void setAncienneteAnnee_C_ERR(String pValeur_C_ERR)
  {
    m_ancienneteAnnee_C_ERR = pValeur_C_ERR;
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
    if ("m_listeFluxFctDnaPreavis_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_listeFluxFctDnaIndemnitesVersees_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_listeFluxPasDna_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_codeMessage_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_codeAction_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_SIRET_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_referenceContrat_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_natureContrat_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_motifRupture_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_clauseNonConcurrence_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_regimeSpecialSS_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_numeroAffiRegimeSpecialSS_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_lienParente_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_statutParticulier_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_niveauQualif_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_topTransaction_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_bneIdentifiantBne_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_bneSiret_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_bneRaisonSociale_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_bneCodePostal_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_bneLibelleCommuneCNAVTS_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_bneAssedicAffiliation_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_bneNumAffiliation_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_bneNouveauCodeNAF_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_abonnementProvisoire_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_codeRegimeCTP_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_nomEmployeur_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_prenomEmployeur_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_numUrssaf_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_numCESU_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_numPAJEEMPLOI_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_idBNIRemplace_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_origineAE_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_indicChomSsRCT_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_refusAdhesionFNE_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_codeStatutCadre_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_cocheAlsaceMoselle_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_indCotisationForfaitReel_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_indBrutNet_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_codeCaisseCongesPayes_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_numCaisseCP_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_codeARRCO_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_numBneARRCO_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_sigleARRCO_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_raisonSocialeARRCO_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_codeAGIRC_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_numBneAGIRC_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_sigleAGIRC_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_raisonSocialeAGIRC_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_typeContrat_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_codeRegimeEmployeur_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_numConventionGestion_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_nomFamille_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_prenom_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_indicMontantIndemnite_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_indicSalaireHoraire_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_fillerUn_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_fillerDeux_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_employAutoAssur_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_numCG_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_etabFinanc_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_numInterne_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_codeAffect_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_statutSalarie_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_codeStatutjuridique_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_nomLogiciel_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_versionLogiciel_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_categorieJuridiqueEntreprise_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_codeRegimeEntreprise_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_natureEntreprise_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_numGusoEntreprise_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_numMSAEntreprise_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_entreprisePublique_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_trancheEffectifEntreprise_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateDebutContrat_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateFinContrat_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateNotifRupture_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateProcedureLicenciement_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateDJTP_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateInitialeFinContrat_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateConnaissanceAE_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateReprise_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateDebutIndemCP_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateFinIndemCP_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateEffetCTP_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateAdhesion_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateCessationActiviteEntreprise_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateDebutPeriodeAffiliationEntreprise_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateFinPeriodeAffiliationEntreprise_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateDebutEffetConGes_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateFinEffetConGes_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_numeroVersion_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_idTechContratDna_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_nbCongesPayesRestant_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_montantIndemnitePreavis_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_nbHeuresDIF_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_salaireHoraireNetSalarie_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_idTechContratRemplace_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_nbPAS_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_nbSalariesEntreprise_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_nbMoisPreavis_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateDebutPeriodeInactivite_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateFinPeriodeInactivite_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_motifPeriodeInactivite_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateDebutAGS_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateFinAGS_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateDebutAdhesionRevocable_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateFinAdhesionRevocable_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_identiteDeclaree_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_doute_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_idDocumentNumerique_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_ancienneteMois_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_ancienneteAnnee_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_motifRecours_C_ERR".equals(attrName)) {
      return String.class;
    }
    return null;
  }
  
  public PropertyInfo _getPropertyInfo(String pElementName)
    throws TechniqueException
  {
    if ("ListeFluxFctDnaPreavis".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, _ListeFluxFctDnaPreavis.class, false);
      return info;
    }
    if ("ListeFluxFctDnaIndemnitesVersees".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, _ListeFluxFctDnaIndemnitesVersees.class, false);
      return info;
    }
    if ("ListeFluxPasDna".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, _ListeFluxPasDna.class, false);
      return info;
    }
    if ("CodeMessage".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("CodeAction".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("SIRET".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("ReferenceContrat".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("NatureContrat".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("MotifRupture".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("ClauseNonConcurrence".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("RegimeSpecialSS".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("NumeroAffiRegimeSpecialSS".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("LienParente".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("StatutParticulier".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("NiveauQualif".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("TopTransaction".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("BneIdentifiantBne".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("BneSiret".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("BneRaisonSociale".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("BneCodePostal".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("BneLibelleCommuneCNAVTS".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("BneAssedicAffiliation".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("BneNumAffiliation".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("BneNouveauCodeNAF".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("AbonnementProvisoire".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("CodeRegimeCTP".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("NomEmployeur".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("PrenomEmployeur".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("NumUrssaf".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("NumCESU".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("NumPAJEEMPLOI".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("IdBNIRemplace".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("OrigineAE".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("IndicChomSsRCT".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("RefusAdhesionFNE".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("CodeStatutCadre".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("CocheAlsaceMoselle".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("IndCotisationForfaitReel".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("IndBrutNet".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("CodeCaisseCongesPayes".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("NumCaisseCP".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("CodeARRCO".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("NumBneARRCO".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("SigleARRCO".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("RaisonSocialeARRCO".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("CodeAGIRC".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("NumBneAGIRC".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("SigleAGIRC".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("RaisonSocialeAGIRC".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("TypeContrat".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("CodeRegimeEmployeur".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("NumConventionGestion".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("NomFamille".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("Prenom".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("IndicMontantIndemnite".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("IndicSalaireHoraire".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("FillerUn".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("FillerDeux".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("EmployAutoAssur".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("NumCG".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("EtabFinanc".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("NumInterne".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("CodeAffect".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("StatutSalarie".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("CodeStatutjuridique".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("NomLogiciel".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("VersionLogiciel".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("CategorieJuridiqueEntreprise".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("CodeRegimeEntreprise".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("NatureEntreprise".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("NumGusoEntreprise".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("NumMSAEntreprise".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("EntreprisePublique".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("TrancheEffectifEntreprise".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("DateDebutContrat".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("DateFinContrat".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("DateNotifRupture".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("DateProcedureLicenciement".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("DateDJTP".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("DateInitialeFinContrat".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("DateConnaissanceAE".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("DateReprise".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("DateDebutIndemCP".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("DateFinIndemCP".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("DateEffetCTP".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("DateAdhesion".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("DateCessationActiviteEntreprise".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("DateDebutPeriodeAffiliationEntreprise".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("DateFinPeriodeAffiliationEntreprise".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("DateDebutEffetConGes".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("DateFinEffetConGes".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("NumeroVersion".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("IdTechContratDna".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("NbCongesPayesRestant".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("MontantIndemnitePreavis".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("NbHeuresDIF".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("SalaireHoraireNetSalarie".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("IdTechContratRemplace".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("NbPAS".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("NbSalariesEntreprise".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("NbMoisPreavis".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("DateDebutPeriodeInactivite".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("DateFinPeriodeInactivite".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("MotifPeriodeInactivite".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("DateDebutAGS".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("DateFinAGS".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("DateDebutAdhesionRevocable".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("DateFinAdhesionRevocable".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("IdentiteDeclaree".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("Doute".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("IdDocumentNumerique".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("AncienneteMois".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("AncienneteAnnee".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("MotifRecours".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    return null;
  }
  
  public int _getPropertyLength(String pElementName)
  {
    if ("ListeFluxFctDnaPreavis".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("ListeFluxFctDnaIndemnitesVersees".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("ListeFluxPasDna".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("CodeMessage".equals(pElementName)) {
      return 3;
    }
    if ("CodeAction".equals(pElementName)) {
      return 1;
    }
    if ("SIRET".equals(pElementName)) {
      return 14;
    }
    if ("ReferenceContrat".equals(pElementName)) {
      return 20;
    }
    if ("NatureContrat".equals(pElementName)) {
      return 2;
    }
    if ("MotifRupture".equals(pElementName)) {
      return 2;
    }
    if ("ClauseNonConcurrence".equals(pElementName)) {
      return 2;
    }
    if ("RegimeSpecialSS".equals(pElementName)) {
      return 3;
    }
    if ("NumeroAffiRegimeSpecialSS".equals(pElementName)) {
      return 15;
    }
    if ("LienParente".equals(pElementName)) {
      return 2;
    }
    if ("StatutParticulier".equals(pElementName)) {
      return 2;
    }
    if ("NiveauQualif".equals(pElementName)) {
      return 5;
    }
    if ("TopTransaction".equals(pElementName)) {
      return 1;
    }
    if ("BneIdentifiantBne".equals(pElementName)) {
      return 10;
    }
    if ("BneSiret".equals(pElementName)) {
      return 14;
    }
    if ("BneRaisonSociale".equals(pElementName)) {
      return 60;
    }
    if ("BneCodePostal".equals(pElementName)) {
      return 5;
    }
    if ("BneLibelleCommuneCNAVTS".equals(pElementName)) {
      return 50;
    }
    if ("BneAssedicAffiliation".equals(pElementName)) {
      return 3;
    }
    if ("BneNumAffiliation".equals(pElementName)) {
      return 14;
    }
    if ("BneNouveauCodeNAF".equals(pElementName)) {
      return 5;
    }
    if ("AbonnementProvisoire".equals(pElementName)) {
      return 1;
    }
    if ("CodeRegimeCTP".equals(pElementName)) {
      return 5;
    }
    if ("NomEmployeur".equals(pElementName)) {
      return 80;
    }
    if ("PrenomEmployeur".equals(pElementName)) {
      return 40;
    }
    if ("NumUrssaf".equals(pElementName)) {
      return 18;
    }
    if ("NumCESU".equals(pElementName)) {
      return 15;
    }
    if ("NumPAJEEMPLOI".equals(pElementName)) {
      return 15;
    }
    if ("IdBNIRemplace".equals(pElementName)) {
      return 10;
    }
    if ("OrigineAE".equals(pElementName)) {
      return 2;
    }
    if ("IndicChomSsRCT".equals(pElementName)) {
      return 2;
    }
    if ("RefusAdhesionFNE".equals(pElementName)) {
      return 2;
    }
    if ("CodeStatutCadre".equals(pElementName)) {
      return 2;
    }
    if ("CocheAlsaceMoselle".equals(pElementName)) {
      return 2;
    }
    if ("IndCotisationForfaitReel".equals(pElementName)) {
      return 1;
    }
    if ("IndBrutNet".equals(pElementName)) {
      return 1;
    }
    if ("CodeCaisseCongesPayes".equals(pElementName)) {
      return 2;
    }
    if ("NumCaisseCP".equals(pElementName)) {
      return 2;
    }
    if ("CodeARRCO".equals(pElementName)) {
      return 4;
    }
    if ("NumBneARRCO".equals(pElementName)) {
      return 10;
    }
    if ("SigleARRCO".equals(pElementName)) {
      return 10;
    }
    if ("RaisonSocialeARRCO".equals(pElementName)) {
      return 40;
    }
    if ("CodeAGIRC".equals(pElementName)) {
      return 4;
    }
    if ("NumBneAGIRC".equals(pElementName)) {
      return 10;
    }
    if ("SigleAGIRC".equals(pElementName)) {
      return 10;
    }
    if ("RaisonSocialeAGIRC".equals(pElementName)) {
      return 40;
    }
    if ("TypeContrat".equals(pElementName)) {
      return 2;
    }
    if ("CodeRegimeEmployeur".equals(pElementName)) {
      return 2;
    }
    if ("NumConventionGestion".equals(pElementName)) {
      return 10;
    }
    if ("NomFamille".equals(pElementName)) {
      return 80;
    }
    if ("Prenom".equals(pElementName)) {
      return 40;
    }
    if ("IndicMontantIndemnite".equals(pElementName)) {
      return 1;
    }
    if ("IndicSalaireHoraire".equals(pElementName)) {
      return 1;
    }
    if ("FillerUn".equals(pElementName)) {
      return 150;
    }
    if ("FillerDeux".equals(pElementName)) {
      return 193;
    }
    if ("EmployAutoAssur".equals(pElementName)) {
      return 2;
    }
    if ("NumCG".equals(pElementName)) {
      return 7;
    }
    if ("EtabFinanc".equals(pElementName)) {
      return 3;
    }
    if ("NumInterne".equals(pElementName)) {
      return 30;
    }
    if ("CodeAffect".equals(pElementName)) {
      return 6;
    }
    if ("StatutSalarie".equals(pElementName)) {
      return 3;
    }
    if ("CodeStatutjuridique".equals(pElementName)) {
      return 3;
    }
    if ("NomLogiciel".equals(pElementName)) {
      return 20;
    }
    if ("VersionLogiciel".equals(pElementName)) {
      return 10;
    }
    if ("CategorieJuridiqueEntreprise".equals(pElementName)) {
      return 4;
    }
    if ("CodeRegimeEntreprise".equals(pElementName)) {
      return 2;
    }
    if ("NatureEntreprise".equals(pElementName)) {
      return 1;
    }
    if ("NumGusoEntreprise".equals(pElementName)) {
      return 10;
    }
    if ("NumMSAEntreprise".equals(pElementName)) {
      return 20;
    }
    if ("EntreprisePublique".equals(pElementName)) {
      return 1;
    }
    if ("TrancheEffectifEntreprise".equals(pElementName)) {
      return 1;
    }
    if ("DateDebutContrat".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("DateFinContrat".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("DateNotifRupture".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("DateProcedureLicenciement".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("DateDJTP".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("DateInitialeFinContrat".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("DateConnaissanceAE".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("DateReprise".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("DateDebutIndemCP".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("DateFinIndemCP".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("DateEffetCTP".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("DateAdhesion".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("DateCessationActiviteEntreprise".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("DateDebutPeriodeAffiliationEntreprise".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("DateFinPeriodeAffiliationEntreprise".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("DateDebutEffetConGes".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("DateFinEffetConGes".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("NumeroVersion".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("IdTechContratDna".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("NbCongesPayesRestant".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("MontantIndemnitePreavis".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("NbHeuresDIF".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("SalaireHoraireNetSalarie".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("IdTechContratRemplace".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("NbPAS".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("NbSalariesEntreprise".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("NbMoisPreavis".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("DateDebutPeriodeInactivite".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("DateFinPeriodeInactivite".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("MotifPeriodeInactivite".equals(pElementName)) {
      return 3;
    }
    if ("DateDebutAGS".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("DateFinAGS".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("DateDebutAdhesionRevocable".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("DateFinAdhesionRevocable".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("IdentiteDeclaree".equals(pElementName)) {
      return 2;
    }
    if ("Doute".equals(pElementName)) {
      return 2;
    }
    if ("IdDocumentNumerique".equals(pElementName)) {
      return 13;
    }
    if ("AncienneteMois".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("AncienneteAnnee".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("MotifRecours".equals(pElementName)) {
      return 2;
    }
    return -1;
  }
  
  public Object _getProperty(String pName)
    throws Exception
  {
    if ("ListeFluxFctDnaPreavis".equals(pName)) {
      return m_listeFluxFctDnaPreavis;
    }
    if ("ListeFluxFctDnaIndemnitesVersees".equals(pName)) {
      return m_listeFluxFctDnaIndemnitesVersees;
    }
    if ("ListeFluxPasDna".equals(pName)) {
      return m_listeFluxPasDna;
    }
    if ("CodeMessage".equals(pName)) {
      return m_codeMessage;
    }
    if ("CodeAction".equals(pName)) {
      return m_codeAction;
    }
    if ("SIRET".equals(pName)) {
      return m_SIRET;
    }
    if ("ReferenceContrat".equals(pName)) {
      return m_referenceContrat;
    }
    if ("NatureContrat".equals(pName)) {
      return m_natureContrat;
    }
    if ("MotifRupture".equals(pName)) {
      return m_motifRupture;
    }
    if ("ClauseNonConcurrence".equals(pName)) {
      return m_clauseNonConcurrence;
    }
    if ("RegimeSpecialSS".equals(pName)) {
      return m_regimeSpecialSS;
    }
    if ("NumeroAffiRegimeSpecialSS".equals(pName)) {
      return m_numeroAffiRegimeSpecialSS;
    }
    if ("LienParente".equals(pName)) {
      return m_lienParente;
    }
    if ("StatutParticulier".equals(pName)) {
      return m_statutParticulier;
    }
    if ("NiveauQualif".equals(pName)) {
      return m_niveauQualif;
    }
    if ("TopTransaction".equals(pName)) {
      return m_topTransaction;
    }
    if ("BneIdentifiantBne".equals(pName)) {
      return m_bneIdentifiantBne;
    }
    if ("BneSiret".equals(pName)) {
      return m_bneSiret;
    }
    if ("BneRaisonSociale".equals(pName)) {
      return m_bneRaisonSociale;
    }
    if ("BneCodePostal".equals(pName)) {
      return m_bneCodePostal;
    }
    if ("BneLibelleCommuneCNAVTS".equals(pName)) {
      return m_bneLibelleCommuneCNAVTS;
    }
    if ("BneAssedicAffiliation".equals(pName)) {
      return m_bneAssedicAffiliation;
    }
    if ("BneNumAffiliation".equals(pName)) {
      return m_bneNumAffiliation;
    }
    if ("BneNouveauCodeNAF".equals(pName)) {
      return m_bneNouveauCodeNAF;
    }
    if ("AbonnementProvisoire".equals(pName)) {
      return m_abonnementProvisoire;
    }
    if ("CodeRegimeCTP".equals(pName)) {
      return m_codeRegimeCTP;
    }
    if ("NomEmployeur".equals(pName)) {
      return m_nomEmployeur;
    }
    if ("PrenomEmployeur".equals(pName)) {
      return m_prenomEmployeur;
    }
    if ("NumUrssaf".equals(pName)) {
      return m_numUrssaf;
    }
    if ("NumCESU".equals(pName)) {
      return m_numCESU;
    }
    if ("NumPAJEEMPLOI".equals(pName)) {
      return m_numPAJEEMPLOI;
    }
    if ("IdBNIRemplace".equals(pName)) {
      return m_idBNIRemplace;
    }
    if ("OrigineAE".equals(pName)) {
      return m_origineAE;
    }
    if ("IndicChomSsRCT".equals(pName)) {
      return m_indicChomSsRCT;
    }
    if ("RefusAdhesionFNE".equals(pName)) {
      return m_refusAdhesionFNE;
    }
    if ("CodeStatutCadre".equals(pName)) {
      return m_codeStatutCadre;
    }
    if ("CocheAlsaceMoselle".equals(pName)) {
      return m_cocheAlsaceMoselle;
    }
    if ("IndCotisationForfaitReel".equals(pName)) {
      return m_indCotisationForfaitReel;
    }
    if ("IndBrutNet".equals(pName)) {
      return m_indBrutNet;
    }
    if ("CodeCaisseCongesPayes".equals(pName)) {
      return m_codeCaisseCongesPayes;
    }
    if ("NumCaisseCP".equals(pName)) {
      return m_numCaisseCP;
    }
    if ("CodeARRCO".equals(pName)) {
      return m_codeARRCO;
    }
    if ("NumBneARRCO".equals(pName)) {
      return m_numBneARRCO;
    }
    if ("SigleARRCO".equals(pName)) {
      return m_sigleARRCO;
    }
    if ("RaisonSocialeARRCO".equals(pName)) {
      return m_raisonSocialeARRCO;
    }
    if ("CodeAGIRC".equals(pName)) {
      return m_codeAGIRC;
    }
    if ("NumBneAGIRC".equals(pName)) {
      return m_numBneAGIRC;
    }
    if ("SigleAGIRC".equals(pName)) {
      return m_sigleAGIRC;
    }
    if ("RaisonSocialeAGIRC".equals(pName)) {
      return m_raisonSocialeAGIRC;
    }
    if ("TypeContrat".equals(pName)) {
      return m_typeContrat;
    }
    if ("CodeRegimeEmployeur".equals(pName)) {
      return m_codeRegimeEmployeur;
    }
    if ("NumConventionGestion".equals(pName)) {
      return m_numConventionGestion;
    }
    if ("NomFamille".equals(pName)) {
      return m_nomFamille;
    }
    if ("Prenom".equals(pName)) {
      return m_prenom;
    }
    if ("IndicMontantIndemnite".equals(pName)) {
      return m_indicMontantIndemnite;
    }
    if ("IndicSalaireHoraire".equals(pName)) {
      return m_indicSalaireHoraire;
    }
    if ("FillerUn".equals(pName)) {
      return m_fillerUn;
    }
    if ("FillerDeux".equals(pName)) {
      return m_fillerDeux;
    }
    if ("EmployAutoAssur".equals(pName)) {
      return m_employAutoAssur;
    }
    if ("NumCG".equals(pName)) {
      return m_numCG;
    }
    if ("EtabFinanc".equals(pName)) {
      return m_etabFinanc;
    }
    if ("NumInterne".equals(pName)) {
      return m_numInterne;
    }
    if ("CodeAffect".equals(pName)) {
      return m_codeAffect;
    }
    if ("StatutSalarie".equals(pName)) {
      return m_statutSalarie;
    }
    if ("CodeStatutjuridique".equals(pName)) {
      return m_codeStatutjuridique;
    }
    if ("NomLogiciel".equals(pName)) {
      return m_nomLogiciel;
    }
    if ("VersionLogiciel".equals(pName)) {
      return m_versionLogiciel;
    }
    if ("CategorieJuridiqueEntreprise".equals(pName)) {
      return m_categorieJuridiqueEntreprise;
    }
    if ("CodeRegimeEntreprise".equals(pName)) {
      return m_codeRegimeEntreprise;
    }
    if ("NatureEntreprise".equals(pName)) {
      return m_natureEntreprise;
    }
    if ("NumGusoEntreprise".equals(pName)) {
      return m_numGusoEntreprise;
    }
    if ("NumMSAEntreprise".equals(pName)) {
      return m_numMSAEntreprise;
    }
    if ("EntreprisePublique".equals(pName)) {
      return m_entreprisePublique;
    }
    if ("TrancheEffectifEntreprise".equals(pName)) {
      return m_trancheEffectifEntreprise;
    }
    if ("DateDebutContrat".equals(pName)) {
      return m_dateDebutContrat;
    }
    if ("DateFinContrat".equals(pName)) {
      return m_dateFinContrat;
    }
    if ("DateNotifRupture".equals(pName)) {
      return m_dateNotifRupture;
    }
    if ("DateProcedureLicenciement".equals(pName)) {
      return m_dateProcedureLicenciement;
    }
    if ("DateDJTP".equals(pName)) {
      return m_dateDJTP;
    }
    if ("DateInitialeFinContrat".equals(pName)) {
      return m_dateInitialeFinContrat;
    }
    if ("DateConnaissanceAE".equals(pName)) {
      return m_dateConnaissanceAE;
    }
    if ("DateReprise".equals(pName)) {
      return m_dateReprise;
    }
    if ("DateDebutIndemCP".equals(pName)) {
      return m_dateDebutIndemCP;
    }
    if ("DateFinIndemCP".equals(pName)) {
      return m_dateFinIndemCP;
    }
    if ("DateEffetCTP".equals(pName)) {
      return m_dateEffetCTP;
    }
    if ("DateAdhesion".equals(pName)) {
      return m_dateAdhesion;
    }
    if ("DateCessationActiviteEntreprise".equals(pName)) {
      return m_dateCessationActiviteEntreprise;
    }
    if ("DateDebutPeriodeAffiliationEntreprise".equals(pName)) {
      return m_dateDebutPeriodeAffiliationEntreprise;
    }
    if ("DateFinPeriodeAffiliationEntreprise".equals(pName)) {
      return m_dateFinPeriodeAffiliationEntreprise;
    }
    if ("DateDebutEffetConGes".equals(pName)) {
      return m_dateDebutEffetConGes;
    }
    if ("DateFinEffetConGes".equals(pName)) {
      return m_dateFinEffetConGes;
    }
    if ("NumeroVersion".equals(pName)) {
      return m_numeroVersion;
    }
    if ("IdTechContratDna".equals(pName)) {
      return m_idTechContratDna;
    }
    if ("NbCongesPayesRestant".equals(pName)) {
      return m_nbCongesPayesRestant;
    }
    if ("MontantIndemnitePreavis".equals(pName)) {
      return m_montantIndemnitePreavis;
    }
    if ("NbHeuresDIF".equals(pName)) {
      return m_nbHeuresDIF;
    }
    if ("SalaireHoraireNetSalarie".equals(pName)) {
      return m_salaireHoraireNetSalarie;
    }
    if ("IdTechContratRemplace".equals(pName)) {
      return m_idTechContratRemplace;
    }
    if ("NbPAS".equals(pName)) {
      return m_nbPAS;
    }
    if ("NbSalariesEntreprise".equals(pName)) {
      return m_nbSalariesEntreprise;
    }
    if ("NbMoisPreavis".equals(pName)) {
      return m_nbMoisPreavis;
    }
    if ("DateDebutPeriodeInactivite".equals(pName)) {
      return m_dateDebutPeriodeInactivite;
    }
    if ("DateFinPeriodeInactivite".equals(pName)) {
      return m_dateFinPeriodeInactivite;
    }
    if ("MotifPeriodeInactivite".equals(pName)) {
      return m_motifPeriodeInactivite;
    }
    if ("DateDebutAGS".equals(pName)) {
      return m_dateDebutAGS;
    }
    if ("DateFinAGS".equals(pName)) {
      return m_dateFinAGS;
    }
    if ("DateDebutAdhesionRevocable".equals(pName)) {
      return m_dateDebutAdhesionRevocable;
    }
    if ("DateFinAdhesionRevocable".equals(pName)) {
      return m_dateFinAdhesionRevocable;
    }
    if ("IdentiteDeclaree".equals(pName)) {
      return m_identiteDeclaree;
    }
    if ("Doute".equals(pName)) {
      return m_doute;
    }
    if ("IdDocumentNumerique".equals(pName)) {
      return m_idDocumentNumerique;
    }
    if ("AncienneteMois".equals(pName)) {
      return m_ancienneteMois;
    }
    if ("AncienneteAnnee".equals(pName)) {
      return m_ancienneteAnnee;
    }
    if ("MotifRecours".equals(pName)) {
      return m_motifRecours;
    }
    return null;
  }
  
  public Iterator _getPropertyNames()
    throws Exception
  {
    ArrayList liste = new ArrayList();
    liste.add("ListeFluxFctDnaPreavis");
    liste.add("ListeFluxFctDnaIndemnitesVersees");
    liste.add("ListeFluxPasDna");
    liste.add("CodeMessage");
    liste.add("CodeAction");
    liste.add("SIRET");
    liste.add("ReferenceContrat");
    liste.add("NatureContrat");
    liste.add("MotifRupture");
    liste.add("ClauseNonConcurrence");
    liste.add("RegimeSpecialSS");
    liste.add("NumeroAffiRegimeSpecialSS");
    liste.add("LienParente");
    liste.add("StatutParticulier");
    liste.add("NiveauQualif");
    liste.add("TopTransaction");
    liste.add("BneIdentifiantBne");
    liste.add("BneSiret");
    liste.add("BneRaisonSociale");
    liste.add("BneCodePostal");
    liste.add("BneLibelleCommuneCNAVTS");
    liste.add("BneAssedicAffiliation");
    liste.add("BneNumAffiliation");
    liste.add("BneNouveauCodeNAF");
    liste.add("AbonnementProvisoire");
    liste.add("CodeRegimeCTP");
    liste.add("NomEmployeur");
    liste.add("PrenomEmployeur");
    liste.add("NumUrssaf");
    liste.add("NumCESU");
    liste.add("NumPAJEEMPLOI");
    liste.add("IdBNIRemplace");
    liste.add("OrigineAE");
    liste.add("IndicChomSsRCT");
    liste.add("RefusAdhesionFNE");
    liste.add("CodeStatutCadre");
    liste.add("CocheAlsaceMoselle");
    liste.add("IndCotisationForfaitReel");
    liste.add("IndBrutNet");
    liste.add("CodeCaisseCongesPayes");
    liste.add("NumCaisseCP");
    liste.add("CodeARRCO");
    liste.add("NumBneARRCO");
    liste.add("SigleARRCO");
    liste.add("RaisonSocialeARRCO");
    liste.add("CodeAGIRC");
    liste.add("NumBneAGIRC");
    liste.add("SigleAGIRC");
    liste.add("RaisonSocialeAGIRC");
    liste.add("TypeContrat");
    liste.add("CodeRegimeEmployeur");
    liste.add("NumConventionGestion");
    liste.add("NomFamille");
    liste.add("Prenom");
    liste.add("IndicMontantIndemnite");
    liste.add("IndicSalaireHoraire");
    liste.add("FillerUn");
    liste.add("FillerDeux");
    liste.add("EmployAutoAssur");
    liste.add("NumCG");
    liste.add("EtabFinanc");
    liste.add("NumInterne");
    liste.add("CodeAffect");
    liste.add("StatutSalarie");
    liste.add("CodeStatutjuridique");
    liste.add("NomLogiciel");
    liste.add("VersionLogiciel");
    liste.add("CategorieJuridiqueEntreprise");
    liste.add("CodeRegimeEntreprise");
    liste.add("NatureEntreprise");
    liste.add("NumGusoEntreprise");
    liste.add("NumMSAEntreprise");
    liste.add("EntreprisePublique");
    liste.add("TrancheEffectifEntreprise");
    liste.add("DateDebutContrat");
    liste.add("DateFinContrat");
    liste.add("DateNotifRupture");
    liste.add("DateProcedureLicenciement");
    liste.add("DateDJTP");
    liste.add("DateInitialeFinContrat");
    liste.add("DateConnaissanceAE");
    liste.add("DateReprise");
    liste.add("DateDebutIndemCP");
    liste.add("DateFinIndemCP");
    liste.add("DateEffetCTP");
    liste.add("DateAdhesion");
    liste.add("DateCessationActiviteEntreprise");
    liste.add("DateDebutPeriodeAffiliationEntreprise");
    liste.add("DateFinPeriodeAffiliationEntreprise");
    liste.add("DateDebutEffetConGes");
    liste.add("DateFinEffetConGes");
    liste.add("NumeroVersion");
    liste.add("IdTechContratDna");
    liste.add("NbCongesPayesRestant");
    liste.add("MontantIndemnitePreavis");
    liste.add("NbHeuresDIF");
    liste.add("SalaireHoraireNetSalarie");
    liste.add("IdTechContratRemplace");
    liste.add("NbPAS");
    liste.add("NbSalariesEntreprise");
    liste.add("NbMoisPreavis");
    liste.add("DateDebutPeriodeInactivite");
    liste.add("DateFinPeriodeInactivite");
    liste.add("MotifPeriodeInactivite");
    liste.add("DateDebutAGS");
    liste.add("DateFinAGS");
    liste.add("DateDebutAdhesionRevocable");
    liste.add("DateFinAdhesionRevocable");
    liste.add("IdentiteDeclaree");
    liste.add("Doute");
    liste.add("IdDocumentNumerique");
    liste.add("AncienneteMois");
    liste.add("AncienneteAnnee");
    liste.add("MotifRecours");
    return liste.iterator();
  }
  
  public ArrayList _getPropertyNames(ArrayList pListe)
    throws Exception
  {
    pListe.add("ListeFluxFctDnaPreavis");
    pListe.add("ListeFluxFctDnaIndemnitesVersees");
    pListe.add("ListeFluxPasDna");
    pListe.add("CodeMessage");
    pListe.add("CodeAction");
    pListe.add("SIRET");
    pListe.add("ReferenceContrat");
    pListe.add("NatureContrat");
    pListe.add("MotifRupture");
    pListe.add("ClauseNonConcurrence");
    pListe.add("RegimeSpecialSS");
    pListe.add("NumeroAffiRegimeSpecialSS");
    pListe.add("LienParente");
    pListe.add("StatutParticulier");
    pListe.add("NiveauQualif");
    pListe.add("TopTransaction");
    pListe.add("BneIdentifiantBne");
    pListe.add("BneSiret");
    pListe.add("BneRaisonSociale");
    pListe.add("BneCodePostal");
    pListe.add("BneLibelleCommuneCNAVTS");
    pListe.add("BneAssedicAffiliation");
    pListe.add("BneNumAffiliation");
    pListe.add("BneNouveauCodeNAF");
    pListe.add("AbonnementProvisoire");
    pListe.add("CodeRegimeCTP");
    pListe.add("NomEmployeur");
    pListe.add("PrenomEmployeur");
    pListe.add("NumUrssaf");
    pListe.add("NumCESU");
    pListe.add("NumPAJEEMPLOI");
    pListe.add("IdBNIRemplace");
    pListe.add("OrigineAE");
    pListe.add("IndicChomSsRCT");
    pListe.add("RefusAdhesionFNE");
    pListe.add("CodeStatutCadre");
    pListe.add("CocheAlsaceMoselle");
    pListe.add("IndCotisationForfaitReel");
    pListe.add("IndBrutNet");
    pListe.add("CodeCaisseCongesPayes");
    pListe.add("NumCaisseCP");
    pListe.add("CodeARRCO");
    pListe.add("NumBneARRCO");
    pListe.add("SigleARRCO");
    pListe.add("RaisonSocialeARRCO");
    pListe.add("CodeAGIRC");
    pListe.add("NumBneAGIRC");
    pListe.add("SigleAGIRC");
    pListe.add("RaisonSocialeAGIRC");
    pListe.add("TypeContrat");
    pListe.add("CodeRegimeEmployeur");
    pListe.add("NumConventionGestion");
    pListe.add("NomFamille");
    pListe.add("Prenom");
    pListe.add("IndicMontantIndemnite");
    pListe.add("IndicSalaireHoraire");
    pListe.add("FillerUn");
    pListe.add("FillerDeux");
    pListe.add("EmployAutoAssur");
    pListe.add("NumCG");
    pListe.add("EtabFinanc");
    pListe.add("NumInterne");
    pListe.add("CodeAffect");
    pListe.add("StatutSalarie");
    pListe.add("CodeStatutjuridique");
    pListe.add("NomLogiciel");
    pListe.add("VersionLogiciel");
    pListe.add("CategorieJuridiqueEntreprise");
    pListe.add("CodeRegimeEntreprise");
    pListe.add("NatureEntreprise");
    pListe.add("NumGusoEntreprise");
    pListe.add("NumMSAEntreprise");
    pListe.add("EntreprisePublique");
    pListe.add("TrancheEffectifEntreprise");
    pListe.add("DateDebutContrat");
    pListe.add("DateFinContrat");
    pListe.add("DateNotifRupture");
    pListe.add("DateProcedureLicenciement");
    pListe.add("DateDJTP");
    pListe.add("DateInitialeFinContrat");
    pListe.add("DateConnaissanceAE");
    pListe.add("DateReprise");
    pListe.add("DateDebutIndemCP");
    pListe.add("DateFinIndemCP");
    pListe.add("DateEffetCTP");
    pListe.add("DateAdhesion");
    pListe.add("DateCessationActiviteEntreprise");
    pListe.add("DateDebutPeriodeAffiliationEntreprise");
    pListe.add("DateFinPeriodeAffiliationEntreprise");
    pListe.add("DateDebutEffetConGes");
    pListe.add("DateFinEffetConGes");
    pListe.add("NumeroVersion");
    pListe.add("IdTechContratDna");
    pListe.add("NbCongesPayesRestant");
    pListe.add("MontantIndemnitePreavis");
    pListe.add("NbHeuresDIF");
    pListe.add("SalaireHoraireNetSalarie");
    pListe.add("IdTechContratRemplace");
    pListe.add("NbPAS");
    pListe.add("NbSalariesEntreprise");
    pListe.add("NbMoisPreavis");
    pListe.add("DateDebutPeriodeInactivite");
    pListe.add("DateFinPeriodeInactivite");
    pListe.add("MotifPeriodeInactivite");
    pListe.add("DateDebutAGS");
    pListe.add("DateFinAGS");
    pListe.add("DateDebutAdhesionRevocable");
    pListe.add("DateFinAdhesionRevocable");
    pListe.add("IdentiteDeclaree");
    pListe.add("Doute");
    pListe.add("IdDocumentNumerique");
    pListe.add("AncienneteMois");
    pListe.add("AncienneteAnnee");
    pListe.add("MotifRecours");
    return pListe;
  }
  
  public void _setProperty(String pName, Object pValeur)
    throws Exception
  {
    if ("ListeFluxFctDnaPreavis".equals(pName)) {
      m_listeFluxFctDnaPreavis = ((_ListeFluxFctDnaPreavis)pValeur);
    }
    if ("ListeFluxFctDnaIndemnitesVersees".equals(pName)) {
      m_listeFluxFctDnaIndemnitesVersees = ((_ListeFluxFctDnaIndemnitesVersees)pValeur);
    }
    if ("ListeFluxPasDna".equals(pName)) {
      m_listeFluxPasDna = ((_ListeFluxPasDna)pValeur);
    }
    if ("CodeMessage".equals(pName)) {
      m_codeMessage = ((String)pValeur);
    }
    if ("CodeAction".equals(pName)) {
      m_codeAction = ((String)pValeur);
    }
    if ("SIRET".equals(pName)) {
      m_SIRET = ((String)pValeur);
    }
    if ("ReferenceContrat".equals(pName)) {
      m_referenceContrat = ((String)pValeur);
    }
    if ("NatureContrat".equals(pName)) {
      m_natureContrat = ((String)pValeur);
    }
    if ("MotifRupture".equals(pName)) {
      m_motifRupture = ((String)pValeur);
    }
    if ("ClauseNonConcurrence".equals(pName)) {
      m_clauseNonConcurrence = ((String)pValeur);
    }
    if ("RegimeSpecialSS".equals(pName)) {
      m_regimeSpecialSS = ((String)pValeur);
    }
    if ("NumeroAffiRegimeSpecialSS".equals(pName)) {
      m_numeroAffiRegimeSpecialSS = ((String)pValeur);
    }
    if ("LienParente".equals(pName)) {
      m_lienParente = ((String)pValeur);
    }
    if ("StatutParticulier".equals(pName)) {
      m_statutParticulier = ((String)pValeur);
    }
    if ("NiveauQualif".equals(pName)) {
      m_niveauQualif = ((String)pValeur);
    }
    if ("TopTransaction".equals(pName)) {
      m_topTransaction = ((String)pValeur);
    }
    if ("BneIdentifiantBne".equals(pName)) {
      m_bneIdentifiantBne = ((String)pValeur);
    }
    if ("BneSiret".equals(pName)) {
      m_bneSiret = ((String)pValeur);
    }
    if ("BneRaisonSociale".equals(pName)) {
      m_bneRaisonSociale = ((String)pValeur);
    }
    if ("BneCodePostal".equals(pName)) {
      m_bneCodePostal = ((String)pValeur);
    }
    if ("BneLibelleCommuneCNAVTS".equals(pName)) {
      m_bneLibelleCommuneCNAVTS = ((String)pValeur);
    }
    if ("BneAssedicAffiliation".equals(pName)) {
      m_bneAssedicAffiliation = ((String)pValeur);
    }
    if ("BneNumAffiliation".equals(pName)) {
      m_bneNumAffiliation = ((String)pValeur);
    }
    if ("BneNouveauCodeNAF".equals(pName)) {
      m_bneNouveauCodeNAF = ((String)pValeur);
    }
    if ("AbonnementProvisoire".equals(pName)) {
      m_abonnementProvisoire = ((String)pValeur);
    }
    if ("CodeRegimeCTP".equals(pName)) {
      m_codeRegimeCTP = ((String)pValeur);
    }
    if ("NomEmployeur".equals(pName)) {
      m_nomEmployeur = ((String)pValeur);
    }
    if ("PrenomEmployeur".equals(pName)) {
      m_prenomEmployeur = ((String)pValeur);
    }
    if ("NumUrssaf".equals(pName)) {
      m_numUrssaf = ((String)pValeur);
    }
    if ("NumCESU".equals(pName)) {
      m_numCESU = ((String)pValeur);
    }
    if ("NumPAJEEMPLOI".equals(pName)) {
      m_numPAJEEMPLOI = ((String)pValeur);
    }
    if ("IdBNIRemplace".equals(pName)) {
      m_idBNIRemplace = ((String)pValeur);
    }
    if ("OrigineAE".equals(pName)) {
      m_origineAE = ((String)pValeur);
    }
    if ("IndicChomSsRCT".equals(pName)) {
      m_indicChomSsRCT = ((String)pValeur);
    }
    if ("RefusAdhesionFNE".equals(pName)) {
      m_refusAdhesionFNE = ((String)pValeur);
    }
    if ("CodeStatutCadre".equals(pName)) {
      m_codeStatutCadre = ((String)pValeur);
    }
    if ("CocheAlsaceMoselle".equals(pName)) {
      m_cocheAlsaceMoselle = ((String)pValeur);
    }
    if ("IndCotisationForfaitReel".equals(pName)) {
      m_indCotisationForfaitReel = ((String)pValeur);
    }
    if ("IndBrutNet".equals(pName)) {
      m_indBrutNet = ((String)pValeur);
    }
    if ("CodeCaisseCongesPayes".equals(pName)) {
      m_codeCaisseCongesPayes = ((String)pValeur);
    }
    if ("NumCaisseCP".equals(pName)) {
      m_numCaisseCP = ((String)pValeur);
    }
    if ("CodeARRCO".equals(pName)) {
      m_codeARRCO = ((String)pValeur);
    }
    if ("NumBneARRCO".equals(pName)) {
      m_numBneARRCO = ((String)pValeur);
    }
    if ("SigleARRCO".equals(pName)) {
      m_sigleARRCO = ((String)pValeur);
    }
    if ("RaisonSocialeARRCO".equals(pName)) {
      m_raisonSocialeARRCO = ((String)pValeur);
    }
    if ("CodeAGIRC".equals(pName)) {
      m_codeAGIRC = ((String)pValeur);
    }
    if ("NumBneAGIRC".equals(pName)) {
      m_numBneAGIRC = ((String)pValeur);
    }
    if ("SigleAGIRC".equals(pName)) {
      m_sigleAGIRC = ((String)pValeur);
    }
    if ("RaisonSocialeAGIRC".equals(pName)) {
      m_raisonSocialeAGIRC = ((String)pValeur);
    }
    if ("TypeContrat".equals(pName)) {
      m_typeContrat = ((String)pValeur);
    }
    if ("CodeRegimeEmployeur".equals(pName)) {
      m_codeRegimeEmployeur = ((String)pValeur);
    }
    if ("NumConventionGestion".equals(pName)) {
      m_numConventionGestion = ((String)pValeur);
    }
    if ("NomFamille".equals(pName)) {
      m_nomFamille = ((String)pValeur);
    }
    if ("Prenom".equals(pName)) {
      m_prenom = ((String)pValeur);
    }
    if ("IndicMontantIndemnite".equals(pName)) {
      m_indicMontantIndemnite = ((String)pValeur);
    }
    if ("IndicSalaireHoraire".equals(pName)) {
      m_indicSalaireHoraire = ((String)pValeur);
    }
    if ("FillerUn".equals(pName)) {
      m_fillerUn = ((String)pValeur);
    }
    if ("FillerDeux".equals(pName)) {
      m_fillerDeux = ((String)pValeur);
    }
    if ("EmployAutoAssur".equals(pName)) {
      m_employAutoAssur = ((String)pValeur);
    }
    if ("NumCG".equals(pName)) {
      m_numCG = ((String)pValeur);
    }
    if ("EtabFinanc".equals(pName)) {
      m_etabFinanc = ((String)pValeur);
    }
    if ("NumInterne".equals(pName)) {
      m_numInterne = ((String)pValeur);
    }
    if ("CodeAffect".equals(pName)) {
      m_codeAffect = ((String)pValeur);
    }
    if ("StatutSalarie".equals(pName)) {
      m_statutSalarie = ((String)pValeur);
    }
    if ("CodeStatutjuridique".equals(pName)) {
      m_codeStatutjuridique = ((String)pValeur);
    }
    if ("NomLogiciel".equals(pName)) {
      m_nomLogiciel = ((String)pValeur);
    }
    if ("VersionLogiciel".equals(pName)) {
      m_versionLogiciel = ((String)pValeur);
    }
    if ("CategorieJuridiqueEntreprise".equals(pName)) {
      m_categorieJuridiqueEntreprise = ((String)pValeur);
    }
    if ("CodeRegimeEntreprise".equals(pName)) {
      m_codeRegimeEntreprise = ((String)pValeur);
    }
    if ("NatureEntreprise".equals(pName)) {
      m_natureEntreprise = ((String)pValeur);
    }
    if ("NumGusoEntreprise".equals(pName)) {
      m_numGusoEntreprise = ((String)pValeur);
    }
    if ("NumMSAEntreprise".equals(pName)) {
      m_numMSAEntreprise = ((String)pValeur);
    }
    if ("EntreprisePublique".equals(pName)) {
      m_entreprisePublique = ((String)pValeur);
    }
    if ("TrancheEffectifEntreprise".equals(pName)) {
      m_trancheEffectifEntreprise = ((String)pValeur);
    }
    if ("DateDebutContrat".equals(pName)) {
      m_dateDebutContrat = ((Damj)pValeur);
    }
    if ("DateFinContrat".equals(pName)) {
      m_dateFinContrat = ((Damj)pValeur);
    }
    if ("DateNotifRupture".equals(pName)) {
      m_dateNotifRupture = ((Damj)pValeur);
    }
    if ("DateProcedureLicenciement".equals(pName)) {
      m_dateProcedureLicenciement = ((Damj)pValeur);
    }
    if ("DateDJTP".equals(pName)) {
      m_dateDJTP = ((Damj)pValeur);
    }
    if ("DateInitialeFinContrat".equals(pName)) {
      m_dateInitialeFinContrat = ((Damj)pValeur);
    }
    if ("DateConnaissanceAE".equals(pName)) {
      m_dateConnaissanceAE = ((Damj)pValeur);
    }
    if ("DateReprise".equals(pName)) {
      m_dateReprise = ((Damj)pValeur);
    }
    if ("DateDebutIndemCP".equals(pName)) {
      m_dateDebutIndemCP = ((Damj)pValeur);
    }
    if ("DateFinIndemCP".equals(pName)) {
      m_dateFinIndemCP = ((Damj)pValeur);
    }
    if ("DateEffetCTP".equals(pName)) {
      m_dateEffetCTP = ((Damj)pValeur);
    }
    if ("DateAdhesion".equals(pName)) {
      m_dateAdhesion = ((Damj)pValeur);
    }
    if ("DateCessationActiviteEntreprise".equals(pName)) {
      m_dateCessationActiviteEntreprise = ((Damj)pValeur);
    }
    if ("DateDebutPeriodeAffiliationEntreprise".equals(pName)) {
      m_dateDebutPeriodeAffiliationEntreprise = ((Damj)pValeur);
    }
    if ("DateFinPeriodeAffiliationEntreprise".equals(pName)) {
      m_dateFinPeriodeAffiliationEntreprise = ((Damj)pValeur);
    }
    if ("DateDebutEffetConGes".equals(pName)) {
      m_dateDebutEffetConGes = ((Damj)pValeur);
    }
    if ("DateFinEffetConGes".equals(pName)) {
      m_dateFinEffetConGes = ((Damj)pValeur);
    }
    if ("NumeroVersion".equals(pName)) {
      m_numeroVersion = ((BigDecimal)pValeur);
    }
    if ("IdTechContratDna".equals(pName)) {
      m_idTechContratDna = ((BigDecimal)pValeur);
    }
    if ("NbCongesPayesRestant".equals(pName)) {
      m_nbCongesPayesRestant = ((BigDecimal)pValeur);
    }
    if ("MontantIndemnitePreavis".equals(pName)) {
      m_montantIndemnitePreavis = ((BigDecimal)pValeur);
    }
    if ("NbHeuresDIF".equals(pName)) {
      m_nbHeuresDIF = ((BigDecimal)pValeur);
    }
    if ("SalaireHoraireNetSalarie".equals(pName)) {
      m_salaireHoraireNetSalarie = ((BigDecimal)pValeur);
    }
    if ("IdTechContratRemplace".equals(pName)) {
      m_idTechContratRemplace = ((BigDecimal)pValeur);
    }
    if ("NbPAS".equals(pName)) {
      m_nbPAS = ((BigDecimal)pValeur);
    }
    if ("NbSalariesEntreprise".equals(pName)) {
      m_nbSalariesEntreprise = ((BigDecimal)pValeur);
    }
    if ("NbMoisPreavis".equals(pName)) {
      m_nbMoisPreavis = ((BigDecimal)pValeur);
    }
    if ("DateDebutPeriodeInactivite".equals(pName)) {
      m_dateDebutPeriodeInactivite = ((Damj)pValeur);
    }
    if ("DateFinPeriodeInactivite".equals(pName)) {
      m_dateFinPeriodeInactivite = ((Damj)pValeur);
    }
    if ("MotifPeriodeInactivite".equals(pName)) {
      m_motifPeriodeInactivite = ((String)pValeur);
    }
    if ("DateDebutAGS".equals(pName)) {
      m_dateDebutAGS = ((Damj)pValeur);
    }
    if ("DateFinAGS".equals(pName)) {
      m_dateFinAGS = ((Damj)pValeur);
    }
    if ("DateDebutAdhesionRevocable".equals(pName)) {
      m_dateDebutAdhesionRevocable = ((Damj)pValeur);
    }
    if ("DateFinAdhesionRevocable".equals(pName)) {
      m_dateFinAdhesionRevocable = ((Damj)pValeur);
    }
    if ("IdentiteDeclaree".equals(pName)) {
      m_identiteDeclaree = ((String)pValeur);
    }
    if ("Doute".equals(pName)) {
      m_doute = ((String)pValeur);
    }
    if ("IdDocumentNumerique".equals(pName)) {
      m_idDocumentNumerique = ((String)pValeur);
    }
    if ("AncienneteMois".equals(pName)) {
      m_ancienneteMois = ((BigDecimal)pValeur);
    }
    if ("AncienneteAnnee".equals(pName)) {
      m_ancienneteAnnee = ((BigDecimal)pValeur);
    }
    if ("MotifRecours".equals(pName)) {
      m_motifRecours = ((String)pValeur);
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
    if ("m_listeFluxFctDnaPreavis_C_ERR".equals(attrName)) {
      m_listeFluxFctDnaPreavis_C_ERR = pValeur;
    }
    if ("m_listeFluxFctDnaIndemnitesVersees_C_ERR".equals(attrName)) {
      m_listeFluxFctDnaIndemnitesVersees_C_ERR = pValeur;
    }
    if ("m_listeFluxPasDna_C_ERR".equals(attrName)) {
      m_listeFluxPasDna_C_ERR = pValeur;
    }
    if ("m_codeMessage_C_ERR".equals(attrName)) {
      m_codeMessage_C_ERR = pValeur;
    }
    if ("m_codeAction_C_ERR".equals(attrName)) {
      m_codeAction_C_ERR = pValeur;
    }
    if ("m_SIRET_C_ERR".equals(attrName)) {
      m_SIRET_C_ERR = pValeur;
    }
    if ("m_referenceContrat_C_ERR".equals(attrName)) {
      m_referenceContrat_C_ERR = pValeur;
    }
    if ("m_natureContrat_C_ERR".equals(attrName)) {
      m_natureContrat_C_ERR = pValeur;
    }
    if ("m_motifRupture_C_ERR".equals(attrName)) {
      m_motifRupture_C_ERR = pValeur;
    }
    if ("m_clauseNonConcurrence_C_ERR".equals(attrName)) {
      m_clauseNonConcurrence_C_ERR = pValeur;
    }
    if ("m_regimeSpecialSS_C_ERR".equals(attrName)) {
      m_regimeSpecialSS_C_ERR = pValeur;
    }
    if ("m_numeroAffiRegimeSpecialSS_C_ERR".equals(attrName)) {
      m_numeroAffiRegimeSpecialSS_C_ERR = pValeur;
    }
    if ("m_lienParente_C_ERR".equals(attrName)) {
      m_lienParente_C_ERR = pValeur;
    }
    if ("m_statutParticulier_C_ERR".equals(attrName)) {
      m_statutParticulier_C_ERR = pValeur;
    }
    if ("m_niveauQualif_C_ERR".equals(attrName)) {
      m_niveauQualif_C_ERR = pValeur;
    }
    if ("m_topTransaction_C_ERR".equals(attrName)) {
      m_topTransaction_C_ERR = pValeur;
    }
    if ("m_bneIdentifiantBne_C_ERR".equals(attrName)) {
      m_bneIdentifiantBne_C_ERR = pValeur;
    }
    if ("m_bneSiret_C_ERR".equals(attrName)) {
      m_bneSiret_C_ERR = pValeur;
    }
    if ("m_bneRaisonSociale_C_ERR".equals(attrName)) {
      m_bneRaisonSociale_C_ERR = pValeur;
    }
    if ("m_bneCodePostal_C_ERR".equals(attrName)) {
      m_bneCodePostal_C_ERR = pValeur;
    }
    if ("m_bneLibelleCommuneCNAVTS_C_ERR".equals(attrName)) {
      m_bneLibelleCommuneCNAVTS_C_ERR = pValeur;
    }
    if ("m_bneAssedicAffiliation_C_ERR".equals(attrName)) {
      m_bneAssedicAffiliation_C_ERR = pValeur;
    }
    if ("m_bneNumAffiliation_C_ERR".equals(attrName)) {
      m_bneNumAffiliation_C_ERR = pValeur;
    }
    if ("m_bneNouveauCodeNAF_C_ERR".equals(attrName)) {
      m_bneNouveauCodeNAF_C_ERR = pValeur;
    }
    if ("m_abonnementProvisoire_C_ERR".equals(attrName)) {
      m_abonnementProvisoire_C_ERR = pValeur;
    }
    if ("m_codeRegimeCTP_C_ERR".equals(attrName)) {
      m_codeRegimeCTP_C_ERR = pValeur;
    }
    if ("m_nomEmployeur_C_ERR".equals(attrName)) {
      m_nomEmployeur_C_ERR = pValeur;
    }
    if ("m_prenomEmployeur_C_ERR".equals(attrName)) {
      m_prenomEmployeur_C_ERR = pValeur;
    }
    if ("m_numUrssaf_C_ERR".equals(attrName)) {
      m_numUrssaf_C_ERR = pValeur;
    }
    if ("m_numCESU_C_ERR".equals(attrName)) {
      m_numCESU_C_ERR = pValeur;
    }
    if ("m_numPAJEEMPLOI_C_ERR".equals(attrName)) {
      m_numPAJEEMPLOI_C_ERR = pValeur;
    }
    if ("m_idBNIRemplace_C_ERR".equals(attrName)) {
      m_idBNIRemplace_C_ERR = pValeur;
    }
    if ("m_origineAE_C_ERR".equals(attrName)) {
      m_origineAE_C_ERR = pValeur;
    }
    if ("m_indicChomSsRCT_C_ERR".equals(attrName)) {
      m_indicChomSsRCT_C_ERR = pValeur;
    }
    if ("m_refusAdhesionFNE_C_ERR".equals(attrName)) {
      m_refusAdhesionFNE_C_ERR = pValeur;
    }
    if ("m_codeStatutCadre_C_ERR".equals(attrName)) {
      m_codeStatutCadre_C_ERR = pValeur;
    }
    if ("m_cocheAlsaceMoselle_C_ERR".equals(attrName)) {
      m_cocheAlsaceMoselle_C_ERR = pValeur;
    }
    if ("m_indCotisationForfaitReel_C_ERR".equals(attrName)) {
      m_indCotisationForfaitReel_C_ERR = pValeur;
    }
    if ("m_indBrutNet_C_ERR".equals(attrName)) {
      m_indBrutNet_C_ERR = pValeur;
    }
    if ("m_codeCaisseCongesPayes_C_ERR".equals(attrName)) {
      m_codeCaisseCongesPayes_C_ERR = pValeur;
    }
    if ("m_numCaisseCP_C_ERR".equals(attrName)) {
      m_numCaisseCP_C_ERR = pValeur;
    }
    if ("m_codeARRCO_C_ERR".equals(attrName)) {
      m_codeARRCO_C_ERR = pValeur;
    }
    if ("m_numBneARRCO_C_ERR".equals(attrName)) {
      m_numBneARRCO_C_ERR = pValeur;
    }
    if ("m_sigleARRCO_C_ERR".equals(attrName)) {
      m_sigleARRCO_C_ERR = pValeur;
    }
    if ("m_raisonSocialeARRCO_C_ERR".equals(attrName)) {
      m_raisonSocialeARRCO_C_ERR = pValeur;
    }
    if ("m_codeAGIRC_C_ERR".equals(attrName)) {
      m_codeAGIRC_C_ERR = pValeur;
    }
    if ("m_numBneAGIRC_C_ERR".equals(attrName)) {
      m_numBneAGIRC_C_ERR = pValeur;
    }
    if ("m_sigleAGIRC_C_ERR".equals(attrName)) {
      m_sigleAGIRC_C_ERR = pValeur;
    }
    if ("m_raisonSocialeAGIRC_C_ERR".equals(attrName)) {
      m_raisonSocialeAGIRC_C_ERR = pValeur;
    }
    if ("m_typeContrat_C_ERR".equals(attrName)) {
      m_typeContrat_C_ERR = pValeur;
    }
    if ("m_codeRegimeEmployeur_C_ERR".equals(attrName)) {
      m_codeRegimeEmployeur_C_ERR = pValeur;
    }
    if ("m_numConventionGestion_C_ERR".equals(attrName)) {
      m_numConventionGestion_C_ERR = pValeur;
    }
    if ("m_nomFamille_C_ERR".equals(attrName)) {
      m_nomFamille_C_ERR = pValeur;
    }
    if ("m_prenom_C_ERR".equals(attrName)) {
      m_prenom_C_ERR = pValeur;
    }
    if ("m_indicMontantIndemnite_C_ERR".equals(attrName)) {
      m_indicMontantIndemnite_C_ERR = pValeur;
    }
    if ("m_indicSalaireHoraire_C_ERR".equals(attrName)) {
      m_indicSalaireHoraire_C_ERR = pValeur;
    }
    if ("m_fillerUn_C_ERR".equals(attrName)) {
      m_fillerUn_C_ERR = pValeur;
    }
    if ("m_fillerDeux_C_ERR".equals(attrName)) {
      m_fillerDeux_C_ERR = pValeur;
    }
    if ("m_employAutoAssur_C_ERR".equals(attrName)) {
      m_employAutoAssur_C_ERR = pValeur;
    }
    if ("m_numCG_C_ERR".equals(attrName)) {
      m_numCG_C_ERR = pValeur;
    }
    if ("m_etabFinanc_C_ERR".equals(attrName)) {
      m_etabFinanc_C_ERR = pValeur;
    }
    if ("m_numInterne_C_ERR".equals(attrName)) {
      m_numInterne_C_ERR = pValeur;
    }
    if ("m_codeAffect_C_ERR".equals(attrName)) {
      m_codeAffect_C_ERR = pValeur;
    }
    if ("m_statutSalarie_C_ERR".equals(attrName)) {
      m_statutSalarie_C_ERR = pValeur;
    }
    if ("m_codeStatutjuridique_C_ERR".equals(attrName)) {
      m_codeStatutjuridique_C_ERR = pValeur;
    }
    if ("m_nomLogiciel_C_ERR".equals(attrName)) {
      m_nomLogiciel_C_ERR = pValeur;
    }
    if ("m_versionLogiciel_C_ERR".equals(attrName)) {
      m_versionLogiciel_C_ERR = pValeur;
    }
    if ("m_categorieJuridiqueEntreprise_C_ERR".equals(attrName)) {
      m_categorieJuridiqueEntreprise_C_ERR = pValeur;
    }
    if ("m_codeRegimeEntreprise_C_ERR".equals(attrName)) {
      m_codeRegimeEntreprise_C_ERR = pValeur;
    }
    if ("m_natureEntreprise_C_ERR".equals(attrName)) {
      m_natureEntreprise_C_ERR = pValeur;
    }
    if ("m_numGusoEntreprise_C_ERR".equals(attrName)) {
      m_numGusoEntreprise_C_ERR = pValeur;
    }
    if ("m_numMSAEntreprise_C_ERR".equals(attrName)) {
      m_numMSAEntreprise_C_ERR = pValeur;
    }
    if ("m_entreprisePublique_C_ERR".equals(attrName)) {
      m_entreprisePublique_C_ERR = pValeur;
    }
    if ("m_trancheEffectifEntreprise_C_ERR".equals(attrName)) {
      m_trancheEffectifEntreprise_C_ERR = pValeur;
    }
    if ("m_dateDebutContrat_C_ERR".equals(attrName)) {
      m_dateDebutContrat_C_ERR = pValeur;
    }
    if ("m_dateFinContrat_C_ERR".equals(attrName)) {
      m_dateFinContrat_C_ERR = pValeur;
    }
    if ("m_dateNotifRupture_C_ERR".equals(attrName)) {
      m_dateNotifRupture_C_ERR = pValeur;
    }
    if ("m_dateProcedureLicenciement_C_ERR".equals(attrName)) {
      m_dateProcedureLicenciement_C_ERR = pValeur;
    }
    if ("m_dateDJTP_C_ERR".equals(attrName)) {
      m_dateDJTP_C_ERR = pValeur;
    }
    if ("m_dateInitialeFinContrat_C_ERR".equals(attrName)) {
      m_dateInitialeFinContrat_C_ERR = pValeur;
    }
    if ("m_dateConnaissanceAE_C_ERR".equals(attrName)) {
      m_dateConnaissanceAE_C_ERR = pValeur;
    }
    if ("m_dateReprise_C_ERR".equals(attrName)) {
      m_dateReprise_C_ERR = pValeur;
    }
    if ("m_dateDebutIndemCP_C_ERR".equals(attrName)) {
      m_dateDebutIndemCP_C_ERR = pValeur;
    }
    if ("m_dateFinIndemCP_C_ERR".equals(attrName)) {
      m_dateFinIndemCP_C_ERR = pValeur;
    }
    if ("m_dateEffetCTP_C_ERR".equals(attrName)) {
      m_dateEffetCTP_C_ERR = pValeur;
    }
    if ("m_dateAdhesion_C_ERR".equals(attrName)) {
      m_dateAdhesion_C_ERR = pValeur;
    }
    if ("m_dateCessationActiviteEntreprise_C_ERR".equals(attrName)) {
      m_dateCessationActiviteEntreprise_C_ERR = pValeur;
    }
    if ("m_dateDebutPeriodeAffiliationEntreprise_C_ERR".equals(attrName)) {
      m_dateDebutPeriodeAffiliationEntreprise_C_ERR = pValeur;
    }
    if ("m_dateFinPeriodeAffiliationEntreprise_C_ERR".equals(attrName)) {
      m_dateFinPeriodeAffiliationEntreprise_C_ERR = pValeur;
    }
    if ("m_dateDebutEffetConGes_C_ERR".equals(attrName)) {
      m_dateDebutEffetConGes_C_ERR = pValeur;
    }
    if ("m_dateFinEffetConGes_C_ERR".equals(attrName)) {
      m_dateFinEffetConGes_C_ERR = pValeur;
    }
    if ("m_numeroVersion_C_ERR".equals(attrName)) {
      m_numeroVersion_C_ERR = pValeur;
    }
    if ("m_idTechContratDna_C_ERR".equals(attrName)) {
      m_idTechContratDna_C_ERR = pValeur;
    }
    if ("m_nbCongesPayesRestant_C_ERR".equals(attrName)) {
      m_nbCongesPayesRestant_C_ERR = pValeur;
    }
    if ("m_montantIndemnitePreavis_C_ERR".equals(attrName)) {
      m_montantIndemnitePreavis_C_ERR = pValeur;
    }
    if ("m_nbHeuresDIF_C_ERR".equals(attrName)) {
      m_nbHeuresDIF_C_ERR = pValeur;
    }
    if ("m_salaireHoraireNetSalarie_C_ERR".equals(attrName)) {
      m_salaireHoraireNetSalarie_C_ERR = pValeur;
    }
    if ("m_idTechContratRemplace_C_ERR".equals(attrName)) {
      m_idTechContratRemplace_C_ERR = pValeur;
    }
    if ("m_nbPAS_C_ERR".equals(attrName)) {
      m_nbPAS_C_ERR = pValeur;
    }
    if ("m_nbSalariesEntreprise_C_ERR".equals(attrName)) {
      m_nbSalariesEntreprise_C_ERR = pValeur;
    }
    if ("m_nbMoisPreavis_C_ERR".equals(attrName)) {
      m_nbMoisPreavis_C_ERR = pValeur;
    }
    if ("m_dateDebutPeriodeInactivite_C_ERR".equals(attrName)) {
      m_dateDebutPeriodeInactivite_C_ERR = pValeur;
    }
    if ("m_dateFinPeriodeInactivite_C_ERR".equals(attrName)) {
      m_dateFinPeriodeInactivite_C_ERR = pValeur;
    }
    if ("m_motifPeriodeInactivite_C_ERR".equals(attrName)) {
      m_motifPeriodeInactivite_C_ERR = pValeur;
    }
    if ("m_dateDebutAGS_C_ERR".equals(attrName)) {
      m_dateDebutAGS_C_ERR = pValeur;
    }
    if ("m_dateFinAGS_C_ERR".equals(attrName)) {
      m_dateFinAGS_C_ERR = pValeur;
    }
    if ("m_dateDebutAdhesionRevocable_C_ERR".equals(attrName)) {
      m_dateDebutAdhesionRevocable_C_ERR = pValeur;
    }
    if ("m_dateFinAdhesionRevocable_C_ERR".equals(attrName)) {
      m_dateFinAdhesionRevocable_C_ERR = pValeur;
    }
    if ("m_identiteDeclaree_C_ERR".equals(attrName)) {
      m_identiteDeclaree_C_ERR = pValeur;
    }
    if ("m_doute_C_ERR".equals(attrName)) {
      m_doute_C_ERR = pValeur;
    }
    if ("m_idDocumentNumerique_C_ERR".equals(attrName)) {
      m_idDocumentNumerique_C_ERR = pValeur;
    }
    if ("m_ancienneteMois_C_ERR".equals(attrName)) {
      m_ancienneteMois_C_ERR = pValeur;
    }
    if ("m_ancienneteAnnee_C_ERR".equals(attrName)) {
      m_ancienneteAnnee_C_ERR = pValeur;
    }
    if ("m_motifRecours_C_ERR".equals(attrName)) {
      m_motifRecours_C_ERR = pValeur;
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
    if ("m_listeFluxFctDnaPreavis_C_ERR".equals(attrName)) {
      return m_listeFluxFctDnaPreavis_C_ERR;
    }
    if ("m_listeFluxFctDnaIndemnitesVersees_C_ERR".equals(attrName)) {
      return m_listeFluxFctDnaIndemnitesVersees_C_ERR;
    }
    if ("m_listeFluxPasDna_C_ERR".equals(attrName)) {
      return m_listeFluxPasDna_C_ERR;
    }
    if ("m_codeMessage_C_ERR".equals(attrName)) {
      return m_codeMessage_C_ERR;
    }
    if ("m_codeAction_C_ERR".equals(attrName)) {
      return m_codeAction_C_ERR;
    }
    if ("m_SIRET_C_ERR".equals(attrName)) {
      return m_SIRET_C_ERR;
    }
    if ("m_referenceContrat_C_ERR".equals(attrName)) {
      return m_referenceContrat_C_ERR;
    }
    if ("m_natureContrat_C_ERR".equals(attrName)) {
      return m_natureContrat_C_ERR;
    }
    if ("m_motifRupture_C_ERR".equals(attrName)) {
      return m_motifRupture_C_ERR;
    }
    if ("m_clauseNonConcurrence_C_ERR".equals(attrName)) {
      return m_clauseNonConcurrence_C_ERR;
    }
    if ("m_regimeSpecialSS_C_ERR".equals(attrName)) {
      return m_regimeSpecialSS_C_ERR;
    }
    if ("m_numeroAffiRegimeSpecialSS_C_ERR".equals(attrName)) {
      return m_numeroAffiRegimeSpecialSS_C_ERR;
    }
    if ("m_lienParente_C_ERR".equals(attrName)) {
      return m_lienParente_C_ERR;
    }
    if ("m_statutParticulier_C_ERR".equals(attrName)) {
      return m_statutParticulier_C_ERR;
    }
    if ("m_niveauQualif_C_ERR".equals(attrName)) {
      return m_niveauQualif_C_ERR;
    }
    if ("m_topTransaction_C_ERR".equals(attrName)) {
      return m_topTransaction_C_ERR;
    }
    if ("m_bneIdentifiantBne_C_ERR".equals(attrName)) {
      return m_bneIdentifiantBne_C_ERR;
    }
    if ("m_bneSiret_C_ERR".equals(attrName)) {
      return m_bneSiret_C_ERR;
    }
    if ("m_bneRaisonSociale_C_ERR".equals(attrName)) {
      return m_bneRaisonSociale_C_ERR;
    }
    if ("m_bneCodePostal_C_ERR".equals(attrName)) {
      return m_bneCodePostal_C_ERR;
    }
    if ("m_bneLibelleCommuneCNAVTS_C_ERR".equals(attrName)) {
      return m_bneLibelleCommuneCNAVTS_C_ERR;
    }
    if ("m_bneAssedicAffiliation_C_ERR".equals(attrName)) {
      return m_bneAssedicAffiliation_C_ERR;
    }
    if ("m_bneNumAffiliation_C_ERR".equals(attrName)) {
      return m_bneNumAffiliation_C_ERR;
    }
    if ("m_bneNouveauCodeNAF_C_ERR".equals(attrName)) {
      return m_bneNouveauCodeNAF_C_ERR;
    }
    if ("m_abonnementProvisoire_C_ERR".equals(attrName)) {
      return m_abonnementProvisoire_C_ERR;
    }
    if ("m_codeRegimeCTP_C_ERR".equals(attrName)) {
      return m_codeRegimeCTP_C_ERR;
    }
    if ("m_nomEmployeur_C_ERR".equals(attrName)) {
      return m_nomEmployeur_C_ERR;
    }
    if ("m_prenomEmployeur_C_ERR".equals(attrName)) {
      return m_prenomEmployeur_C_ERR;
    }
    if ("m_numUrssaf_C_ERR".equals(attrName)) {
      return m_numUrssaf_C_ERR;
    }
    if ("m_numCESU_C_ERR".equals(attrName)) {
      return m_numCESU_C_ERR;
    }
    if ("m_numPAJEEMPLOI_C_ERR".equals(attrName)) {
      return m_numPAJEEMPLOI_C_ERR;
    }
    if ("m_idBNIRemplace_C_ERR".equals(attrName)) {
      return m_idBNIRemplace_C_ERR;
    }
    if ("m_origineAE_C_ERR".equals(attrName)) {
      return m_origineAE_C_ERR;
    }
    if ("m_indicChomSsRCT_C_ERR".equals(attrName)) {
      return m_indicChomSsRCT_C_ERR;
    }
    if ("m_refusAdhesionFNE_C_ERR".equals(attrName)) {
      return m_refusAdhesionFNE_C_ERR;
    }
    if ("m_codeStatutCadre_C_ERR".equals(attrName)) {
      return m_codeStatutCadre_C_ERR;
    }
    if ("m_cocheAlsaceMoselle_C_ERR".equals(attrName)) {
      return m_cocheAlsaceMoselle_C_ERR;
    }
    if ("m_indCotisationForfaitReel_C_ERR".equals(attrName)) {
      return m_indCotisationForfaitReel_C_ERR;
    }
    if ("m_indBrutNet_C_ERR".equals(attrName)) {
      return m_indBrutNet_C_ERR;
    }
    if ("m_codeCaisseCongesPayes_C_ERR".equals(attrName)) {
      return m_codeCaisseCongesPayes_C_ERR;
    }
    if ("m_numCaisseCP_C_ERR".equals(attrName)) {
      return m_numCaisseCP_C_ERR;
    }
    if ("m_codeARRCO_C_ERR".equals(attrName)) {
      return m_codeARRCO_C_ERR;
    }
    if ("m_numBneARRCO_C_ERR".equals(attrName)) {
      return m_numBneARRCO_C_ERR;
    }
    if ("m_sigleARRCO_C_ERR".equals(attrName)) {
      return m_sigleARRCO_C_ERR;
    }
    if ("m_raisonSocialeARRCO_C_ERR".equals(attrName)) {
      return m_raisonSocialeARRCO_C_ERR;
    }
    if ("m_codeAGIRC_C_ERR".equals(attrName)) {
      return m_codeAGIRC_C_ERR;
    }
    if ("m_numBneAGIRC_C_ERR".equals(attrName)) {
      return m_numBneAGIRC_C_ERR;
    }
    if ("m_sigleAGIRC_C_ERR".equals(attrName)) {
      return m_sigleAGIRC_C_ERR;
    }
    if ("m_raisonSocialeAGIRC_C_ERR".equals(attrName)) {
      return m_raisonSocialeAGIRC_C_ERR;
    }
    if ("m_typeContrat_C_ERR".equals(attrName)) {
      return m_typeContrat_C_ERR;
    }
    if ("m_codeRegimeEmployeur_C_ERR".equals(attrName)) {
      return m_codeRegimeEmployeur_C_ERR;
    }
    if ("m_numConventionGestion_C_ERR".equals(attrName)) {
      return m_numConventionGestion_C_ERR;
    }
    if ("m_nomFamille_C_ERR".equals(attrName)) {
      return m_nomFamille_C_ERR;
    }
    if ("m_prenom_C_ERR".equals(attrName)) {
      return m_prenom_C_ERR;
    }
    if ("m_indicMontantIndemnite_C_ERR".equals(attrName)) {
      return m_indicMontantIndemnite_C_ERR;
    }
    if ("m_indicSalaireHoraire_C_ERR".equals(attrName)) {
      return m_indicSalaireHoraire_C_ERR;
    }
    if ("m_fillerUn_C_ERR".equals(attrName)) {
      return m_fillerUn_C_ERR;
    }
    if ("m_fillerDeux_C_ERR".equals(attrName)) {
      return m_fillerDeux_C_ERR;
    }
    if ("m_employAutoAssur_C_ERR".equals(attrName)) {
      return m_employAutoAssur_C_ERR;
    }
    if ("m_numCG_C_ERR".equals(attrName)) {
      return m_numCG_C_ERR;
    }
    if ("m_etabFinanc_C_ERR".equals(attrName)) {
      return m_etabFinanc_C_ERR;
    }
    if ("m_numInterne_C_ERR".equals(attrName)) {
      return m_numInterne_C_ERR;
    }
    if ("m_codeAffect_C_ERR".equals(attrName)) {
      return m_codeAffect_C_ERR;
    }
    if ("m_statutSalarie_C_ERR".equals(attrName)) {
      return m_statutSalarie_C_ERR;
    }
    if ("m_codeStatutjuridique_C_ERR".equals(attrName)) {
      return m_codeStatutjuridique_C_ERR;
    }
    if ("m_nomLogiciel_C_ERR".equals(attrName)) {
      return m_nomLogiciel_C_ERR;
    }
    if ("m_versionLogiciel_C_ERR".equals(attrName)) {
      return m_versionLogiciel_C_ERR;
    }
    if ("m_categorieJuridiqueEntreprise_C_ERR".equals(attrName)) {
      return m_categorieJuridiqueEntreprise_C_ERR;
    }
    if ("m_codeRegimeEntreprise_C_ERR".equals(attrName)) {
      return m_codeRegimeEntreprise_C_ERR;
    }
    if ("m_natureEntreprise_C_ERR".equals(attrName)) {
      return m_natureEntreprise_C_ERR;
    }
    if ("m_numGusoEntreprise_C_ERR".equals(attrName)) {
      return m_numGusoEntreprise_C_ERR;
    }
    if ("m_numMSAEntreprise_C_ERR".equals(attrName)) {
      return m_numMSAEntreprise_C_ERR;
    }
    if ("m_entreprisePublique_C_ERR".equals(attrName)) {
      return m_entreprisePublique_C_ERR;
    }
    if ("m_trancheEffectifEntreprise_C_ERR".equals(attrName)) {
      return m_trancheEffectifEntreprise_C_ERR;
    }
    if ("m_dateDebutContrat_C_ERR".equals(attrName)) {
      return m_dateDebutContrat_C_ERR;
    }
    if ("m_dateFinContrat_C_ERR".equals(attrName)) {
      return m_dateFinContrat_C_ERR;
    }
    if ("m_dateNotifRupture_C_ERR".equals(attrName)) {
      return m_dateNotifRupture_C_ERR;
    }
    if ("m_dateProcedureLicenciement_C_ERR".equals(attrName)) {
      return m_dateProcedureLicenciement_C_ERR;
    }
    if ("m_dateDJTP_C_ERR".equals(attrName)) {
      return m_dateDJTP_C_ERR;
    }
    if ("m_dateInitialeFinContrat_C_ERR".equals(attrName)) {
      return m_dateInitialeFinContrat_C_ERR;
    }
    if ("m_dateConnaissanceAE_C_ERR".equals(attrName)) {
      return m_dateConnaissanceAE_C_ERR;
    }
    if ("m_dateReprise_C_ERR".equals(attrName)) {
      return m_dateReprise_C_ERR;
    }
    if ("m_dateDebutIndemCP_C_ERR".equals(attrName)) {
      return m_dateDebutIndemCP_C_ERR;
    }
    if ("m_dateFinIndemCP_C_ERR".equals(attrName)) {
      return m_dateFinIndemCP_C_ERR;
    }
    if ("m_dateEffetCTP_C_ERR".equals(attrName)) {
      return m_dateEffetCTP_C_ERR;
    }
    if ("m_dateAdhesion_C_ERR".equals(attrName)) {
      return m_dateAdhesion_C_ERR;
    }
    if ("m_dateCessationActiviteEntreprise_C_ERR".equals(attrName)) {
      return m_dateCessationActiviteEntreprise_C_ERR;
    }
    if ("m_dateDebutPeriodeAffiliationEntreprise_C_ERR".equals(attrName)) {
      return m_dateDebutPeriodeAffiliationEntreprise_C_ERR;
    }
    if ("m_dateFinPeriodeAffiliationEntreprise_C_ERR".equals(attrName)) {
      return m_dateFinPeriodeAffiliationEntreprise_C_ERR;
    }
    if ("m_dateDebutEffetConGes_C_ERR".equals(attrName)) {
      return m_dateDebutEffetConGes_C_ERR;
    }
    if ("m_dateFinEffetConGes_C_ERR".equals(attrName)) {
      return m_dateFinEffetConGes_C_ERR;
    }
    if ("m_numeroVersion_C_ERR".equals(attrName)) {
      return m_numeroVersion_C_ERR;
    }
    if ("m_idTechContratDna_C_ERR".equals(attrName)) {
      return m_idTechContratDna_C_ERR;
    }
    if ("m_nbCongesPayesRestant_C_ERR".equals(attrName)) {
      return m_nbCongesPayesRestant_C_ERR;
    }
    if ("m_montantIndemnitePreavis_C_ERR".equals(attrName)) {
      return m_montantIndemnitePreavis_C_ERR;
    }
    if ("m_nbHeuresDIF_C_ERR".equals(attrName)) {
      return m_nbHeuresDIF_C_ERR;
    }
    if ("m_salaireHoraireNetSalarie_C_ERR".equals(attrName)) {
      return m_salaireHoraireNetSalarie_C_ERR;
    }
    if ("m_idTechContratRemplace_C_ERR".equals(attrName)) {
      return m_idTechContratRemplace_C_ERR;
    }
    if ("m_nbPAS_C_ERR".equals(attrName)) {
      return m_nbPAS_C_ERR;
    }
    if ("m_nbSalariesEntreprise_C_ERR".equals(attrName)) {
      return m_nbSalariesEntreprise_C_ERR;
    }
    if ("m_nbMoisPreavis_C_ERR".equals(attrName)) {
      return m_nbMoisPreavis_C_ERR;
    }
    if ("m_dateDebutPeriodeInactivite_C_ERR".equals(attrName)) {
      return m_dateDebutPeriodeInactivite_C_ERR;
    }
    if ("m_dateFinPeriodeInactivite_C_ERR".equals(attrName)) {
      return m_dateFinPeriodeInactivite_C_ERR;
    }
    if ("m_motifPeriodeInactivite_C_ERR".equals(attrName)) {
      return m_motifPeriodeInactivite_C_ERR;
    }
    if ("m_dateDebutAGS_C_ERR".equals(attrName)) {
      return m_dateDebutAGS_C_ERR;
    }
    if ("m_dateFinAGS_C_ERR".equals(attrName)) {
      return m_dateFinAGS_C_ERR;
    }
    if ("m_dateDebutAdhesionRevocable_C_ERR".equals(attrName)) {
      return m_dateDebutAdhesionRevocable_C_ERR;
    }
    if ("m_dateFinAdhesionRevocable_C_ERR".equals(attrName)) {
      return m_dateFinAdhesionRevocable_C_ERR;
    }
    if ("m_identiteDeclaree_C_ERR".equals(attrName)) {
      return m_identiteDeclaree_C_ERR;
    }
    if ("m_doute_C_ERR".equals(attrName)) {
      return m_doute_C_ERR;
    }
    if ("m_idDocumentNumerique_C_ERR".equals(attrName)) {
      return m_idDocumentNumerique_C_ERR;
    }
    if ("m_ancienneteMois_C_ERR".equals(attrName)) {
      return m_ancienneteMois_C_ERR;
    }
    if ("m_ancienneteAnnee_C_ERR".equals(attrName)) {
      return m_ancienneteAnnee_C_ERR;
    }
    if ("m_motifRecours_C_ERR".equals(attrName)) {
      return m_motifRecours_C_ERR;
    }
    return null;
  }
  
  public boolean equals(Object pObjet)
  {
    if (!(pObjet instanceof _FluxAE)) {
      return false;
    }
    _FluxAE x = (_FluxAE)pObjet;
    if (m_listeFluxFctDnaPreavis == null)
    {
      if (m_listeFluxFctDnaPreavis != null) {
        return false;
      }
    }
    else
    {
      if (m_listeFluxFctDnaPreavis == null) {
        return false;
      }
      if (!m_listeFluxFctDnaPreavis.equals(m_listeFluxFctDnaPreavis)) {
        return false;
      }
    }
    if (m_listeFluxFctDnaIndemnitesVersees == null)
    {
      if (m_listeFluxFctDnaIndemnitesVersees != null) {
        return false;
      }
    }
    else
    {
      if (m_listeFluxFctDnaIndemnitesVersees == null) {
        return false;
      }
      if (!m_listeFluxFctDnaIndemnitesVersees.equals(m_listeFluxFctDnaIndemnitesVersees)) {
        return false;
      }
    }
    if (m_listeFluxPasDna == null)
    {
      if (m_listeFluxPasDna != null) {
        return false;
      }
    }
    else
    {
      if (m_listeFluxPasDna == null) {
        return false;
      }
      if (!m_listeFluxPasDna.equals(m_listeFluxPasDna)) {
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
    if (m_SIRET == null)
    {
      if (m_SIRET != null) {
        return false;
      }
    }
    else
    {
      if (m_SIRET == null) {
        return false;
      }
      if (!m_SIRET.equals(m_SIRET)) {
        return false;
      }
    }
    if (m_referenceContrat == null)
    {
      if (m_referenceContrat != null) {
        return false;
      }
    }
    else
    {
      if (m_referenceContrat == null) {
        return false;
      }
      if (!m_referenceContrat.equals(m_referenceContrat)) {
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
    if (m_motifRupture == null)
    {
      if (m_motifRupture != null) {
        return false;
      }
    }
    else
    {
      if (m_motifRupture == null) {
        return false;
      }
      if (!m_motifRupture.equals(m_motifRupture)) {
        return false;
      }
    }
    if (m_clauseNonConcurrence == null)
    {
      if (m_clauseNonConcurrence != null) {
        return false;
      }
    }
    else
    {
      if (m_clauseNonConcurrence == null) {
        return false;
      }
      if (!m_clauseNonConcurrence.equals(m_clauseNonConcurrence)) {
        return false;
      }
    }
    if (m_regimeSpecialSS == null)
    {
      if (m_regimeSpecialSS != null) {
        return false;
      }
    }
    else
    {
      if (m_regimeSpecialSS == null) {
        return false;
      }
      if (!m_regimeSpecialSS.equals(m_regimeSpecialSS)) {
        return false;
      }
    }
    if (m_numeroAffiRegimeSpecialSS == null)
    {
      if (m_numeroAffiRegimeSpecialSS != null) {
        return false;
      }
    }
    else
    {
      if (m_numeroAffiRegimeSpecialSS == null) {
        return false;
      }
      if (!m_numeroAffiRegimeSpecialSS.equals(m_numeroAffiRegimeSpecialSS)) {
        return false;
      }
    }
    if (m_lienParente == null)
    {
      if (m_lienParente != null) {
        return false;
      }
    }
    else
    {
      if (m_lienParente == null) {
        return false;
      }
      if (!m_lienParente.equals(m_lienParente)) {
        return false;
      }
    }
    if (m_statutParticulier == null)
    {
      if (m_statutParticulier != null) {
        return false;
      }
    }
    else
    {
      if (m_statutParticulier == null) {
        return false;
      }
      if (!m_statutParticulier.equals(m_statutParticulier)) {
        return false;
      }
    }
    if (m_niveauQualif == null)
    {
      if (m_niveauQualif != null) {
        return false;
      }
    }
    else
    {
      if (m_niveauQualif == null) {
        return false;
      }
      if (!m_niveauQualif.equals(m_niveauQualif)) {
        return false;
      }
    }
    if (m_topTransaction == null)
    {
      if (m_topTransaction != null) {
        return false;
      }
    }
    else
    {
      if (m_topTransaction == null) {
        return false;
      }
      if (!m_topTransaction.equals(m_topTransaction)) {
        return false;
      }
    }
    if (m_bneIdentifiantBne == null)
    {
      if (m_bneIdentifiantBne != null) {
        return false;
      }
    }
    else
    {
      if (m_bneIdentifiantBne == null) {
        return false;
      }
      if (!m_bneIdentifiantBne.equals(m_bneIdentifiantBne)) {
        return false;
      }
    }
    if (m_bneSiret == null)
    {
      if (m_bneSiret != null) {
        return false;
      }
    }
    else
    {
      if (m_bneSiret == null) {
        return false;
      }
      if (!m_bneSiret.equals(m_bneSiret)) {
        return false;
      }
    }
    if (m_bneRaisonSociale == null)
    {
      if (m_bneRaisonSociale != null) {
        return false;
      }
    }
    else
    {
      if (m_bneRaisonSociale == null) {
        return false;
      }
      if (!m_bneRaisonSociale.equals(m_bneRaisonSociale)) {
        return false;
      }
    }
    if (m_bneCodePostal == null)
    {
      if (m_bneCodePostal != null) {
        return false;
      }
    }
    else
    {
      if (m_bneCodePostal == null) {
        return false;
      }
      if (!m_bneCodePostal.equals(m_bneCodePostal)) {
        return false;
      }
    }
    if (m_bneLibelleCommuneCNAVTS == null)
    {
      if (m_bneLibelleCommuneCNAVTS != null) {
        return false;
      }
    }
    else
    {
      if (m_bneLibelleCommuneCNAVTS == null) {
        return false;
      }
      if (!m_bneLibelleCommuneCNAVTS.equals(m_bneLibelleCommuneCNAVTS)) {
        return false;
      }
    }
    if (m_bneAssedicAffiliation == null)
    {
      if (m_bneAssedicAffiliation != null) {
        return false;
      }
    }
    else
    {
      if (m_bneAssedicAffiliation == null) {
        return false;
      }
      if (!m_bneAssedicAffiliation.equals(m_bneAssedicAffiliation)) {
        return false;
      }
    }
    if (m_bneNumAffiliation == null)
    {
      if (m_bneNumAffiliation != null) {
        return false;
      }
    }
    else
    {
      if (m_bneNumAffiliation == null) {
        return false;
      }
      if (!m_bneNumAffiliation.equals(m_bneNumAffiliation)) {
        return false;
      }
    }
    if (m_bneNouveauCodeNAF == null)
    {
      if (m_bneNouveauCodeNAF != null) {
        return false;
      }
    }
    else
    {
      if (m_bneNouveauCodeNAF == null) {
        return false;
      }
      if (!m_bneNouveauCodeNAF.equals(m_bneNouveauCodeNAF)) {
        return false;
      }
    }
    if (m_abonnementProvisoire == null)
    {
      if (m_abonnementProvisoire != null) {
        return false;
      }
    }
    else
    {
      if (m_abonnementProvisoire == null) {
        return false;
      }
      if (!m_abonnementProvisoire.equals(m_abonnementProvisoire)) {
        return false;
      }
    }
    if (m_codeRegimeCTP == null)
    {
      if (m_codeRegimeCTP != null) {
        return false;
      }
    }
    else
    {
      if (m_codeRegimeCTP == null) {
        return false;
      }
      if (!m_codeRegimeCTP.equals(m_codeRegimeCTP)) {
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
    if (m_numUrssaf == null)
    {
      if (m_numUrssaf != null) {
        return false;
      }
    }
    else
    {
      if (m_numUrssaf == null) {
        return false;
      }
      if (!m_numUrssaf.equals(m_numUrssaf)) {
        return false;
      }
    }
    if (m_numCESU == null)
    {
      if (m_numCESU != null) {
        return false;
      }
    }
    else
    {
      if (m_numCESU == null) {
        return false;
      }
      if (!m_numCESU.equals(m_numCESU)) {
        return false;
      }
    }
    if (m_numPAJEEMPLOI == null)
    {
      if (m_numPAJEEMPLOI != null) {
        return false;
      }
    }
    else
    {
      if (m_numPAJEEMPLOI == null) {
        return false;
      }
      if (!m_numPAJEEMPLOI.equals(m_numPAJEEMPLOI)) {
        return false;
      }
    }
    if (m_idBNIRemplace == null)
    {
      if (m_idBNIRemplace != null) {
        return false;
      }
    }
    else
    {
      if (m_idBNIRemplace == null) {
        return false;
      }
      if (!m_idBNIRemplace.equals(m_idBNIRemplace)) {
        return false;
      }
    }
    if (m_origineAE == null)
    {
      if (m_origineAE != null) {
        return false;
      }
    }
    else
    {
      if (m_origineAE == null) {
        return false;
      }
      if (!m_origineAE.equals(m_origineAE)) {
        return false;
      }
    }
    if (m_indicChomSsRCT == null)
    {
      if (m_indicChomSsRCT != null) {
        return false;
      }
    }
    else
    {
      if (m_indicChomSsRCT == null) {
        return false;
      }
      if (!m_indicChomSsRCT.equals(m_indicChomSsRCT)) {
        return false;
      }
    }
    if (m_refusAdhesionFNE == null)
    {
      if (m_refusAdhesionFNE != null) {
        return false;
      }
    }
    else
    {
      if (m_refusAdhesionFNE == null) {
        return false;
      }
      if (!m_refusAdhesionFNE.equals(m_refusAdhesionFNE)) {
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
    if (m_cocheAlsaceMoselle == null)
    {
      if (m_cocheAlsaceMoselle != null) {
        return false;
      }
    }
    else
    {
      if (m_cocheAlsaceMoselle == null) {
        return false;
      }
      if (!m_cocheAlsaceMoselle.equals(m_cocheAlsaceMoselle)) {
        return false;
      }
    }
    if (m_indCotisationForfaitReel == null)
    {
      if (m_indCotisationForfaitReel != null) {
        return false;
      }
    }
    else
    {
      if (m_indCotisationForfaitReel == null) {
        return false;
      }
      if (!m_indCotisationForfaitReel.equals(m_indCotisationForfaitReel)) {
        return false;
      }
    }
    if (m_indBrutNet == null)
    {
      if (m_indBrutNet != null) {
        return false;
      }
    }
    else
    {
      if (m_indBrutNet == null) {
        return false;
      }
      if (!m_indBrutNet.equals(m_indBrutNet)) {
        return false;
      }
    }
    if (m_codeCaisseCongesPayes == null)
    {
      if (m_codeCaisseCongesPayes != null) {
        return false;
      }
    }
    else
    {
      if (m_codeCaisseCongesPayes == null) {
        return false;
      }
      if (!m_codeCaisseCongesPayes.equals(m_codeCaisseCongesPayes)) {
        return false;
      }
    }
    if (m_numCaisseCP == null)
    {
      if (m_numCaisseCP != null) {
        return false;
      }
    }
    else
    {
      if (m_numCaisseCP == null) {
        return false;
      }
      if (!m_numCaisseCP.equals(m_numCaisseCP)) {
        return false;
      }
    }
    if (m_codeARRCO == null)
    {
      if (m_codeARRCO != null) {
        return false;
      }
    }
    else
    {
      if (m_codeARRCO == null) {
        return false;
      }
      if (!m_codeARRCO.equals(m_codeARRCO)) {
        return false;
      }
    }
    if (m_numBneARRCO == null)
    {
      if (m_numBneARRCO != null) {
        return false;
      }
    }
    else
    {
      if (m_numBneARRCO == null) {
        return false;
      }
      if (!m_numBneARRCO.equals(m_numBneARRCO)) {
        return false;
      }
    }
    if (m_sigleARRCO == null)
    {
      if (m_sigleARRCO != null) {
        return false;
      }
    }
    else
    {
      if (m_sigleARRCO == null) {
        return false;
      }
      if (!m_sigleARRCO.equals(m_sigleARRCO)) {
        return false;
      }
    }
    if (m_raisonSocialeARRCO == null)
    {
      if (m_raisonSocialeARRCO != null) {
        return false;
      }
    }
    else
    {
      if (m_raisonSocialeARRCO == null) {
        return false;
      }
      if (!m_raisonSocialeARRCO.equals(m_raisonSocialeARRCO)) {
        return false;
      }
    }
    if (m_codeAGIRC == null)
    {
      if (m_codeAGIRC != null) {
        return false;
      }
    }
    else
    {
      if (m_codeAGIRC == null) {
        return false;
      }
      if (!m_codeAGIRC.equals(m_codeAGIRC)) {
        return false;
      }
    }
    if (m_numBneAGIRC == null)
    {
      if (m_numBneAGIRC != null) {
        return false;
      }
    }
    else
    {
      if (m_numBneAGIRC == null) {
        return false;
      }
      if (!m_numBneAGIRC.equals(m_numBneAGIRC)) {
        return false;
      }
    }
    if (m_sigleAGIRC == null)
    {
      if (m_sigleAGIRC != null) {
        return false;
      }
    }
    else
    {
      if (m_sigleAGIRC == null) {
        return false;
      }
      if (!m_sigleAGIRC.equals(m_sigleAGIRC)) {
        return false;
      }
    }
    if (m_raisonSocialeAGIRC == null)
    {
      if (m_raisonSocialeAGIRC != null) {
        return false;
      }
    }
    else
    {
      if (m_raisonSocialeAGIRC == null) {
        return false;
      }
      if (!m_raisonSocialeAGIRC.equals(m_raisonSocialeAGIRC)) {
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
    if (m_codeRegimeEmployeur == null)
    {
      if (m_codeRegimeEmployeur != null) {
        return false;
      }
    }
    else
    {
      if (m_codeRegimeEmployeur == null) {
        return false;
      }
      if (!m_codeRegimeEmployeur.equals(m_codeRegimeEmployeur)) {
        return false;
      }
    }
    if (m_numConventionGestion == null)
    {
      if (m_numConventionGestion != null) {
        return false;
      }
    }
    else
    {
      if (m_numConventionGestion == null) {
        return false;
      }
      if (!m_numConventionGestion.equals(m_numConventionGestion)) {
        return false;
      }
    }
    if (m_nomFamille == null)
    {
      if (m_nomFamille != null) {
        return false;
      }
    }
    else
    {
      if (m_nomFamille == null) {
        return false;
      }
      if (!m_nomFamille.equals(m_nomFamille)) {
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
    if (m_indicMontantIndemnite == null)
    {
      if (m_indicMontantIndemnite != null) {
        return false;
      }
    }
    else
    {
      if (m_indicMontantIndemnite == null) {
        return false;
      }
      if (!m_indicMontantIndemnite.equals(m_indicMontantIndemnite)) {
        return false;
      }
    }
    if (m_indicSalaireHoraire == null)
    {
      if (m_indicSalaireHoraire != null) {
        return false;
      }
    }
    else
    {
      if (m_indicSalaireHoraire == null) {
        return false;
      }
      if (!m_indicSalaireHoraire.equals(m_indicSalaireHoraire)) {
        return false;
      }
    }
    if (m_fillerUn == null)
    {
      if (m_fillerUn != null) {
        return false;
      }
    }
    else
    {
      if (m_fillerUn == null) {
        return false;
      }
      if (!m_fillerUn.equals(m_fillerUn)) {
        return false;
      }
    }
    if (m_fillerDeux == null)
    {
      if (m_fillerDeux != null) {
        return false;
      }
    }
    else
    {
      if (m_fillerDeux == null) {
        return false;
      }
      if (!m_fillerDeux.equals(m_fillerDeux)) {
        return false;
      }
    }
    if (m_employAutoAssur == null)
    {
      if (m_employAutoAssur != null) {
        return false;
      }
    }
    else
    {
      if (m_employAutoAssur == null) {
        return false;
      }
      if (!m_employAutoAssur.equals(m_employAutoAssur)) {
        return false;
      }
    }
    if (m_numCG == null)
    {
      if (m_numCG != null) {
        return false;
      }
    }
    else
    {
      if (m_numCG == null) {
        return false;
      }
      if (!m_numCG.equals(m_numCG)) {
        return false;
      }
    }
    if (m_etabFinanc == null)
    {
      if (m_etabFinanc != null) {
        return false;
      }
    }
    else
    {
      if (m_etabFinanc == null) {
        return false;
      }
      if (!m_etabFinanc.equals(m_etabFinanc)) {
        return false;
      }
    }
    if (m_numInterne == null)
    {
      if (m_numInterne != null) {
        return false;
      }
    }
    else
    {
      if (m_numInterne == null) {
        return false;
      }
      if (!m_numInterne.equals(m_numInterne)) {
        return false;
      }
    }
    if (m_codeAffect == null)
    {
      if (m_codeAffect != null) {
        return false;
      }
    }
    else
    {
      if (m_codeAffect == null) {
        return false;
      }
      if (!m_codeAffect.equals(m_codeAffect)) {
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
    if (m_codeStatutjuridique == null)
    {
      if (m_codeStatutjuridique != null) {
        return false;
      }
    }
    else
    {
      if (m_codeStatutjuridique == null) {
        return false;
      }
      if (!m_codeStatutjuridique.equals(m_codeStatutjuridique)) {
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
    if (m_categorieJuridiqueEntreprise == null)
    {
      if (m_categorieJuridiqueEntreprise != null) {
        return false;
      }
    }
    else
    {
      if (m_categorieJuridiqueEntreprise == null) {
        return false;
      }
      if (!m_categorieJuridiqueEntreprise.equals(m_categorieJuridiqueEntreprise)) {
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
    if (m_numGusoEntreprise == null)
    {
      if (m_numGusoEntreprise != null) {
        return false;
      }
    }
    else
    {
      if (m_numGusoEntreprise == null) {
        return false;
      }
      if (!m_numGusoEntreprise.equals(m_numGusoEntreprise)) {
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
    if (m_entreprisePublique == null)
    {
      if (m_entreprisePublique != null) {
        return false;
      }
    }
    else
    {
      if (m_entreprisePublique == null) {
        return false;
      }
      if (!m_entreprisePublique.equals(m_entreprisePublique)) {
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
    if (m_dateNotifRupture == null)
    {
      if (m_dateNotifRupture != null) {
        return false;
      }
    }
    else
    {
      if (m_dateNotifRupture == null) {
        return false;
      }
      if (!m_dateNotifRupture.equals(m_dateNotifRupture)) {
        return false;
      }
    }
    if (m_dateProcedureLicenciement == null)
    {
      if (m_dateProcedureLicenciement != null) {
        return false;
      }
    }
    else
    {
      if (m_dateProcedureLicenciement == null) {
        return false;
      }
      if (!m_dateProcedureLicenciement.equals(m_dateProcedureLicenciement)) {
        return false;
      }
    }
    if (m_dateDJTP == null)
    {
      if (m_dateDJTP != null) {
        return false;
      }
    }
    else
    {
      if (m_dateDJTP == null) {
        return false;
      }
      if (!m_dateDJTP.equals(m_dateDJTP)) {
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
    if (m_dateConnaissanceAE == null)
    {
      if (m_dateConnaissanceAE != null) {
        return false;
      }
    }
    else
    {
      if (m_dateConnaissanceAE == null) {
        return false;
      }
      if (!m_dateConnaissanceAE.equals(m_dateConnaissanceAE)) {
        return false;
      }
    }
    if (m_dateReprise == null)
    {
      if (m_dateReprise != null) {
        return false;
      }
    }
    else
    {
      if (m_dateReprise == null) {
        return false;
      }
      if (!m_dateReprise.equals(m_dateReprise)) {
        return false;
      }
    }
    if (m_dateDebutIndemCP == null)
    {
      if (m_dateDebutIndemCP != null) {
        return false;
      }
    }
    else
    {
      if (m_dateDebutIndemCP == null) {
        return false;
      }
      if (!m_dateDebutIndemCP.equals(m_dateDebutIndemCP)) {
        return false;
      }
    }
    if (m_dateFinIndemCP == null)
    {
      if (m_dateFinIndemCP != null) {
        return false;
      }
    }
    else
    {
      if (m_dateFinIndemCP == null) {
        return false;
      }
      if (!m_dateFinIndemCP.equals(m_dateFinIndemCP)) {
        return false;
      }
    }
    if (m_dateEffetCTP == null)
    {
      if (m_dateEffetCTP != null) {
        return false;
      }
    }
    else
    {
      if (m_dateEffetCTP == null) {
        return false;
      }
      if (!m_dateEffetCTP.equals(m_dateEffetCTP)) {
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
    if (m_dateCessationActiviteEntreprise == null)
    {
      if (m_dateCessationActiviteEntreprise != null) {
        return false;
      }
    }
    else
    {
      if (m_dateCessationActiviteEntreprise == null) {
        return false;
      }
      if (!m_dateCessationActiviteEntreprise.equals(m_dateCessationActiviteEntreprise)) {
        return false;
      }
    }
    if (m_dateDebutPeriodeAffiliationEntreprise == null)
    {
      if (m_dateDebutPeriodeAffiliationEntreprise != null) {
        return false;
      }
    }
    else
    {
      if (m_dateDebutPeriodeAffiliationEntreprise == null) {
        return false;
      }
      if (!m_dateDebutPeriodeAffiliationEntreprise.equals(m_dateDebutPeriodeAffiliationEntreprise)) {
        return false;
      }
    }
    if (m_dateFinPeriodeAffiliationEntreprise == null)
    {
      if (m_dateFinPeriodeAffiliationEntreprise != null) {
        return false;
      }
    }
    else
    {
      if (m_dateFinPeriodeAffiliationEntreprise == null) {
        return false;
      }
      if (!m_dateFinPeriodeAffiliationEntreprise.equals(m_dateFinPeriodeAffiliationEntreprise)) {
        return false;
      }
    }
    if (m_dateDebutEffetConGes == null)
    {
      if (m_dateDebutEffetConGes != null) {
        return false;
      }
    }
    else
    {
      if (m_dateDebutEffetConGes == null) {
        return false;
      }
      if (!m_dateDebutEffetConGes.equals(m_dateDebutEffetConGes)) {
        return false;
      }
    }
    if (m_dateFinEffetConGes == null)
    {
      if (m_dateFinEffetConGes != null) {
        return false;
      }
    }
    else
    {
      if (m_dateFinEffetConGes == null) {
        return false;
      }
      if (!m_dateFinEffetConGes.equals(m_dateFinEffetConGes)) {
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
    if (m_idTechContratDna == null)
    {
      if (m_idTechContratDna != null) {
        return false;
      }
    }
    else
    {
      if (m_idTechContratDna == null) {
        return false;
      }
      if (!m_idTechContratDna.equals(m_idTechContratDna)) {
        return false;
      }
    }
    if (m_nbCongesPayesRestant == null)
    {
      if (m_nbCongesPayesRestant != null) {
        return false;
      }
    }
    else
    {
      if (m_nbCongesPayesRestant == null) {
        return false;
      }
      if (!m_nbCongesPayesRestant.equals(m_nbCongesPayesRestant)) {
        return false;
      }
    }
    if (m_montantIndemnitePreavis == null)
    {
      if (m_montantIndemnitePreavis != null) {
        return false;
      }
    }
    else
    {
      if (m_montantIndemnitePreavis == null) {
        return false;
      }
      if (!m_montantIndemnitePreavis.equals(m_montantIndemnitePreavis)) {
        return false;
      }
    }
    if (m_nbHeuresDIF == null)
    {
      if (m_nbHeuresDIF != null) {
        return false;
      }
    }
    else
    {
      if (m_nbHeuresDIF == null) {
        return false;
      }
      if (!m_nbHeuresDIF.equals(m_nbHeuresDIF)) {
        return false;
      }
    }
    if (m_salaireHoraireNetSalarie == null)
    {
      if (m_salaireHoraireNetSalarie != null) {
        return false;
      }
    }
    else
    {
      if (m_salaireHoraireNetSalarie == null) {
        return false;
      }
      if (!m_salaireHoraireNetSalarie.equals(m_salaireHoraireNetSalarie)) {
        return false;
      }
    }
    if (m_idTechContratRemplace == null)
    {
      if (m_idTechContratRemplace != null) {
        return false;
      }
    }
    else
    {
      if (m_idTechContratRemplace == null) {
        return false;
      }
      if (!m_idTechContratRemplace.equals(m_idTechContratRemplace)) {
        return false;
      }
    }
    if (m_nbPAS == null)
    {
      if (m_nbPAS != null) {
        return false;
      }
    }
    else
    {
      if (m_nbPAS == null) {
        return false;
      }
      if (!m_nbPAS.equals(m_nbPAS)) {
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
    if (m_nbMoisPreavis == null)
    {
      if (m_nbMoisPreavis != null) {
        return false;
      }
    }
    else
    {
      if (m_nbMoisPreavis == null) {
        return false;
      }
      if (!m_nbMoisPreavis.equals(m_nbMoisPreavis)) {
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
    if (m_dateDebutAGS == null)
    {
      if (m_dateDebutAGS != null) {
        return false;
      }
    }
    else
    {
      if (m_dateDebutAGS == null) {
        return false;
      }
      if (!m_dateDebutAGS.equals(m_dateDebutAGS)) {
        return false;
      }
    }
    if (m_dateFinAGS == null)
    {
      if (m_dateFinAGS != null) {
        return false;
      }
    }
    else
    {
      if (m_dateFinAGS == null) {
        return false;
      }
      if (!m_dateFinAGS.equals(m_dateFinAGS)) {
        return false;
      }
    }
    if (m_dateDebutAdhesionRevocable == null)
    {
      if (m_dateDebutAdhesionRevocable != null) {
        return false;
      }
    }
    else
    {
      if (m_dateDebutAdhesionRevocable == null) {
        return false;
      }
      if (!m_dateDebutAdhesionRevocable.equals(m_dateDebutAdhesionRevocable)) {
        return false;
      }
    }
    if (m_dateFinAdhesionRevocable == null)
    {
      if (m_dateFinAdhesionRevocable != null) {
        return false;
      }
    }
    else
    {
      if (m_dateFinAdhesionRevocable == null) {
        return false;
      }
      if (!m_dateFinAdhesionRevocable.equals(m_dateFinAdhesionRevocable)) {
        return false;
      }
    }
    if (m_identiteDeclaree == null)
    {
      if (m_identiteDeclaree != null) {
        return false;
      }
    }
    else
    {
      if (m_identiteDeclaree == null) {
        return false;
      }
      if (!m_identiteDeclaree.equals(m_identiteDeclaree)) {
        return false;
      }
    }
    if (m_doute == null)
    {
      if (m_doute != null) {
        return false;
      }
    }
    else
    {
      if (m_doute == null) {
        return false;
      }
      if (!m_doute.equals(m_doute)) {
        return false;
      }
    }
    if (m_idDocumentNumerique == null)
    {
      if (m_idDocumentNumerique != null) {
        return false;
      }
    }
    else
    {
      if (m_idDocumentNumerique == null) {
        return false;
      }
      if (!m_idDocumentNumerique.equals(m_idDocumentNumerique)) {
        return false;
      }
    }
    if (m_ancienneteMois == null)
    {
      if (m_ancienneteMois != null) {
        return false;
      }
    }
    else
    {
      if (m_ancienneteMois == null) {
        return false;
      }
      if (!m_ancienneteMois.equals(m_ancienneteMois)) {
        return false;
      }
    }
    if (m_ancienneteAnnee == null)
    {
      if (m_ancienneteAnnee != null) {
        return false;
      }
    }
    else
    {
      if (m_ancienneteAnnee == null) {
        return false;
      }
      if (!m_ancienneteAnnee.equals(m_ancienneteAnnee)) {
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
    return true;
  }
  
  public int hashCode()
  {
    int result = 0;
    if (m_listeFluxFctDnaPreavis != null) {
      result += m_listeFluxFctDnaPreavis.hashCode();
    }
    if (m_listeFluxFctDnaIndemnitesVersees != null) {
      result += m_listeFluxFctDnaIndemnitesVersees.hashCode();
    }
    if (m_listeFluxPasDna != null) {
      result += m_listeFluxPasDna.hashCode();
    }
    if (m_codeMessage != null) {
      result += m_codeMessage.hashCode();
    }
    if (m_codeAction != null) {
      result += m_codeAction.hashCode();
    }
    if (m_SIRET != null) {
      result += m_SIRET.hashCode();
    }
    if (m_referenceContrat != null) {
      result += m_referenceContrat.hashCode();
    }
    if (m_natureContrat != null) {
      result += m_natureContrat.hashCode();
    }
    if (m_motifRupture != null) {
      result += m_motifRupture.hashCode();
    }
    if (m_clauseNonConcurrence != null) {
      result += m_clauseNonConcurrence.hashCode();
    }
    if (m_regimeSpecialSS != null) {
      result += m_regimeSpecialSS.hashCode();
    }
    if (m_numeroAffiRegimeSpecialSS != null) {
      result += m_numeroAffiRegimeSpecialSS.hashCode();
    }
    if (m_lienParente != null) {
      result += m_lienParente.hashCode();
    }
    if (m_statutParticulier != null) {
      result += m_statutParticulier.hashCode();
    }
    if (m_niveauQualif != null) {
      result += m_niveauQualif.hashCode();
    }
    if (m_topTransaction != null) {
      result += m_topTransaction.hashCode();
    }
    if (m_bneIdentifiantBne != null) {
      result += m_bneIdentifiantBne.hashCode();
    }
    if (m_bneSiret != null) {
      result += m_bneSiret.hashCode();
    }
    if (m_bneRaisonSociale != null) {
      result += m_bneRaisonSociale.hashCode();
    }
    if (m_bneCodePostal != null) {
      result += m_bneCodePostal.hashCode();
    }
    if (m_bneLibelleCommuneCNAVTS != null) {
      result += m_bneLibelleCommuneCNAVTS.hashCode();
    }
    if (m_bneAssedicAffiliation != null) {
      result += m_bneAssedicAffiliation.hashCode();
    }
    if (m_bneNumAffiliation != null) {
      result += m_bneNumAffiliation.hashCode();
    }
    if (m_bneNouveauCodeNAF != null) {
      result += m_bneNouveauCodeNAF.hashCode();
    }
    if (m_abonnementProvisoire != null) {
      result += m_abonnementProvisoire.hashCode();
    }
    if (m_codeRegimeCTP != null) {
      result += m_codeRegimeCTP.hashCode();
    }
    if (m_nomEmployeur != null) {
      result += m_nomEmployeur.hashCode();
    }
    if (m_prenomEmployeur != null) {
      result += m_prenomEmployeur.hashCode();
    }
    if (m_numUrssaf != null) {
      result += m_numUrssaf.hashCode();
    }
    if (m_numCESU != null) {
      result += m_numCESU.hashCode();
    }
    if (m_numPAJEEMPLOI != null) {
      result += m_numPAJEEMPLOI.hashCode();
    }
    if (m_idBNIRemplace != null) {
      result += m_idBNIRemplace.hashCode();
    }
    if (m_origineAE != null) {
      result += m_origineAE.hashCode();
    }
    if (m_indicChomSsRCT != null) {
      result += m_indicChomSsRCT.hashCode();
    }
    if (m_refusAdhesionFNE != null) {
      result += m_refusAdhesionFNE.hashCode();
    }
    if (m_codeStatutCadre != null) {
      result += m_codeStatutCadre.hashCode();
    }
    if (m_cocheAlsaceMoselle != null) {
      result += m_cocheAlsaceMoselle.hashCode();
    }
    if (m_indCotisationForfaitReel != null) {
      result += m_indCotisationForfaitReel.hashCode();
    }
    if (m_indBrutNet != null) {
      result += m_indBrutNet.hashCode();
    }
    if (m_codeCaisseCongesPayes != null) {
      result += m_codeCaisseCongesPayes.hashCode();
    }
    if (m_numCaisseCP != null) {
      result += m_numCaisseCP.hashCode();
    }
    if (m_codeARRCO != null) {
      result += m_codeARRCO.hashCode();
    }
    if (m_numBneARRCO != null) {
      result += m_numBneARRCO.hashCode();
    }
    if (m_sigleARRCO != null) {
      result += m_sigleARRCO.hashCode();
    }
    if (m_raisonSocialeARRCO != null) {
      result += m_raisonSocialeARRCO.hashCode();
    }
    if (m_codeAGIRC != null) {
      result += m_codeAGIRC.hashCode();
    }
    if (m_numBneAGIRC != null) {
      result += m_numBneAGIRC.hashCode();
    }
    if (m_sigleAGIRC != null) {
      result += m_sigleAGIRC.hashCode();
    }
    if (m_raisonSocialeAGIRC != null) {
      result += m_raisonSocialeAGIRC.hashCode();
    }
    if (m_typeContrat != null) {
      result += m_typeContrat.hashCode();
    }
    if (m_codeRegimeEmployeur != null) {
      result += m_codeRegimeEmployeur.hashCode();
    }
    if (m_numConventionGestion != null) {
      result += m_numConventionGestion.hashCode();
    }
    if (m_nomFamille != null) {
      result += m_nomFamille.hashCode();
    }
    if (m_prenom != null) {
      result += m_prenom.hashCode();
    }
    if (m_indicMontantIndemnite != null) {
      result += m_indicMontantIndemnite.hashCode();
    }
    if (m_indicSalaireHoraire != null) {
      result += m_indicSalaireHoraire.hashCode();
    }
    if (m_fillerUn != null) {
      result += m_fillerUn.hashCode();
    }
    if (m_fillerDeux != null) {
      result += m_fillerDeux.hashCode();
    }
    if (m_employAutoAssur != null) {
      result += m_employAutoAssur.hashCode();
    }
    if (m_numCG != null) {
      result += m_numCG.hashCode();
    }
    if (m_etabFinanc != null) {
      result += m_etabFinanc.hashCode();
    }
    if (m_numInterne != null) {
      result += m_numInterne.hashCode();
    }
    if (m_codeAffect != null) {
      result += m_codeAffect.hashCode();
    }
    if (m_statutSalarie != null) {
      result += m_statutSalarie.hashCode();
    }
    if (m_codeStatutjuridique != null) {
      result += m_codeStatutjuridique.hashCode();
    }
    if (m_nomLogiciel != null) {
      result += m_nomLogiciel.hashCode();
    }
    if (m_versionLogiciel != null) {
      result += m_versionLogiciel.hashCode();
    }
    if (m_categorieJuridiqueEntreprise != null) {
      result += m_categorieJuridiqueEntreprise.hashCode();
    }
    if (m_codeRegimeEntreprise != null) {
      result += m_codeRegimeEntreprise.hashCode();
    }
    if (m_natureEntreprise != null) {
      result += m_natureEntreprise.hashCode();
    }
    if (m_numGusoEntreprise != null) {
      result += m_numGusoEntreprise.hashCode();
    }
    if (m_numMSAEntreprise != null) {
      result += m_numMSAEntreprise.hashCode();
    }
    if (m_entreprisePublique != null) {
      result += m_entreprisePublique.hashCode();
    }
    if (m_trancheEffectifEntreprise != null) {
      result += m_trancheEffectifEntreprise.hashCode();
    }
    if (m_dateDebutContrat != null) {
      result += m_dateDebutContrat.hashCode();
    }
    if (m_dateFinContrat != null) {
      result += m_dateFinContrat.hashCode();
    }
    if (m_dateNotifRupture != null) {
      result += m_dateNotifRupture.hashCode();
    }
    if (m_dateProcedureLicenciement != null) {
      result += m_dateProcedureLicenciement.hashCode();
    }
    if (m_dateDJTP != null) {
      result += m_dateDJTP.hashCode();
    }
    if (m_dateInitialeFinContrat != null) {
      result += m_dateInitialeFinContrat.hashCode();
    }
    if (m_dateConnaissanceAE != null) {
      result += m_dateConnaissanceAE.hashCode();
    }
    if (m_dateReprise != null) {
      result += m_dateReprise.hashCode();
    }
    if (m_dateDebutIndemCP != null) {
      result += m_dateDebutIndemCP.hashCode();
    }
    if (m_dateFinIndemCP != null) {
      result += m_dateFinIndemCP.hashCode();
    }
    if (m_dateEffetCTP != null) {
      result += m_dateEffetCTP.hashCode();
    }
    if (m_dateAdhesion != null) {
      result += m_dateAdhesion.hashCode();
    }
    if (m_dateCessationActiviteEntreprise != null) {
      result += m_dateCessationActiviteEntreprise.hashCode();
    }
    if (m_dateDebutPeriodeAffiliationEntreprise != null) {
      result += m_dateDebutPeriodeAffiliationEntreprise.hashCode();
    }
    if (m_dateFinPeriodeAffiliationEntreprise != null) {
      result += m_dateFinPeriodeAffiliationEntreprise.hashCode();
    }
    if (m_dateDebutEffetConGes != null) {
      result += m_dateDebutEffetConGes.hashCode();
    }
    if (m_dateFinEffetConGes != null) {
      result += m_dateFinEffetConGes.hashCode();
    }
    if (m_numeroVersion != null) {
      result += m_numeroVersion.hashCode();
    }
    if (m_idTechContratDna != null) {
      result += m_idTechContratDna.hashCode();
    }
    if (m_nbCongesPayesRestant != null) {
      result += m_nbCongesPayesRestant.hashCode();
    }
    if (m_montantIndemnitePreavis != null) {
      result += m_montantIndemnitePreavis.hashCode();
    }
    if (m_nbHeuresDIF != null) {
      result += m_nbHeuresDIF.hashCode();
    }
    if (m_salaireHoraireNetSalarie != null) {
      result += m_salaireHoraireNetSalarie.hashCode();
    }
    if (m_idTechContratRemplace != null) {
      result += m_idTechContratRemplace.hashCode();
    }
    if (m_nbPAS != null) {
      result += m_nbPAS.hashCode();
    }
    if (m_nbSalariesEntreprise != null) {
      result += m_nbSalariesEntreprise.hashCode();
    }
    if (m_nbMoisPreavis != null) {
      result += m_nbMoisPreavis.hashCode();
    }
    if (m_dateDebutPeriodeInactivite != null) {
      result += m_dateDebutPeriodeInactivite.hashCode();
    }
    if (m_dateFinPeriodeInactivite != null) {
      result += m_dateFinPeriodeInactivite.hashCode();
    }
    if (m_motifPeriodeInactivite != null) {
      result += m_motifPeriodeInactivite.hashCode();
    }
    if (m_dateDebutAGS != null) {
      result += m_dateDebutAGS.hashCode();
    }
    if (m_dateFinAGS != null) {
      result += m_dateFinAGS.hashCode();
    }
    if (m_dateDebutAdhesionRevocable != null) {
      result += m_dateDebutAdhesionRevocable.hashCode();
    }
    if (m_dateFinAdhesionRevocable != null) {
      result += m_dateFinAdhesionRevocable.hashCode();
    }
    if (m_identiteDeclaree != null) {
      result += m_identiteDeclaree.hashCode();
    }
    if (m_doute != null) {
      result += m_doute.hashCode();
    }
    if (m_idDocumentNumerique != null) {
      result += m_idDocumentNumerique.hashCode();
    }
    if (m_ancienneteMois != null) {
      result += m_ancienneteMois.hashCode();
    }
    if (m_ancienneteAnnee != null) {
      result += m_ancienneteAnnee.hashCode();
    }
    if (m_motifRecours != null) {
      result += m_motifRecours.hashCode();
    }
    result *= 17;
    return result;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    _FluxAE clone_FluxAE = new _FluxAE();
    clone_FluxAE.populateFrom_FluxAE(this);
    return clone_FluxAE;
  }
  
  public void populateFrom_FluxAE(_FluxAE pSource)
  {
    setListeFluxFctDnaPreavis(pSource.getListeFluxFctDnaPreavis());setListeFluxFctDnaIndemnitesVersees(pSource.getListeFluxFctDnaIndemnitesVersees());setListeFluxPasDna(pSource.getListeFluxPasDna());setCodeMessage(pSource.getCodeMessage());setCodeAction(pSource.getCodeAction());setSIRET(pSource.getSIRET());setReferenceContrat(pSource.getReferenceContrat());setNatureContrat(pSource.getNatureContrat());setMotifRupture(pSource.getMotifRupture());setClauseNonConcurrence(pSource.getClauseNonConcurrence());setRegimeSpecialSS(pSource.getRegimeSpecialSS());setNumeroAffiRegimeSpecialSS(pSource.getNumeroAffiRegimeSpecialSS());setLienParente(pSource.getLienParente());setStatutParticulier(pSource.getStatutParticulier());setNiveauQualif(pSource.getNiveauQualif());setTopTransaction(pSource.getTopTransaction());setBneIdentifiantBne(pSource.getBneIdentifiantBne());setBneSiret(pSource.getBneSiret());setBneRaisonSociale(pSource.getBneRaisonSociale());setBneCodePostal(pSource.getBneCodePostal());setBneLibelleCommuneCNAVTS(pSource.getBneLibelleCommuneCNAVTS());setBneAssedicAffiliation(pSource.getBneAssedicAffiliation());setBneNumAffiliation(pSource.getBneNumAffiliation());setBneNouveauCodeNAF(pSource.getBneNouveauCodeNAF());setAbonnementProvisoire(pSource.getAbonnementProvisoire());setCodeRegimeCTP(pSource.getCodeRegimeCTP());setNomEmployeur(pSource.getNomEmployeur());setPrenomEmployeur(pSource.getPrenomEmployeur());setNumUrssaf(pSource.getNumUrssaf());setNumCESU(pSource.getNumCESU());setNumPAJEEMPLOI(pSource.getNumPAJEEMPLOI());setIdBNIRemplace(pSource.getIdBNIRemplace());setOrigineAE(pSource.getOrigineAE());setIndicChomSsRCT(pSource.getIndicChomSsRCT());setRefusAdhesionFNE(pSource.getRefusAdhesionFNE());setCodeStatutCadre(pSource.getCodeStatutCadre());setCocheAlsaceMoselle(pSource.getCocheAlsaceMoselle());setIndCotisationForfaitReel(pSource.getIndCotisationForfaitReel());setIndBrutNet(pSource.getIndBrutNet());setCodeCaisseCongesPayes(pSource.getCodeCaisseCongesPayes());setNumCaisseCP(pSource.getNumCaisseCP());setCodeARRCO(pSource.getCodeARRCO());setNumBneARRCO(pSource.getNumBneARRCO());setSigleARRCO(pSource.getSigleARRCO());setRaisonSocialeARRCO(pSource.getRaisonSocialeARRCO());setCodeAGIRC(pSource.getCodeAGIRC());setNumBneAGIRC(pSource.getNumBneAGIRC());setSigleAGIRC(pSource.getSigleAGIRC());setRaisonSocialeAGIRC(pSource.getRaisonSocialeAGIRC());setTypeContrat(pSource.getTypeContrat());setCodeRegimeEmployeur(pSource.getCodeRegimeEmployeur());setNumConventionGestion(pSource.getNumConventionGestion());setNomFamille(pSource.getNomFamille());setPrenom(pSource.getPrenom());setIndicMontantIndemnite(pSource.getIndicMontantIndemnite());setIndicSalaireHoraire(pSource.getIndicSalaireHoraire());setFillerUn(pSource.getFillerUn());setFillerDeux(pSource.getFillerDeux());setEmployAutoAssur(pSource.getEmployAutoAssur());setNumCG(pSource.getNumCG());setEtabFinanc(pSource.getEtabFinanc());setNumInterne(pSource.getNumInterne());setCodeAffect(pSource.getCodeAffect());setStatutSalarie(pSource.getStatutSalarie());setCodeStatutjuridique(pSource.getCodeStatutjuridique());setNomLogiciel(pSource.getNomLogiciel());setVersionLogiciel(pSource.getVersionLogiciel());setCategorieJuridiqueEntreprise(pSource.getCategorieJuridiqueEntreprise());setCodeRegimeEntreprise(pSource.getCodeRegimeEntreprise());setNatureEntreprise(pSource.getNatureEntreprise());setNumGusoEntreprise(pSource.getNumGusoEntreprise());setNumMSAEntreprise(pSource.getNumMSAEntreprise());setEntreprisePublique(pSource.getEntreprisePublique());setTrancheEffectifEntreprise(pSource.getTrancheEffectifEntreprise());setDateDebutContrat(pSource.getDateDebutContrat());setDateFinContrat(pSource.getDateFinContrat());setDateNotifRupture(pSource.getDateNotifRupture());setDateProcedureLicenciement(pSource.getDateProcedureLicenciement());setDateDJTP(pSource.getDateDJTP());setDateInitialeFinContrat(pSource.getDateInitialeFinContrat());setDateConnaissanceAE(pSource.getDateConnaissanceAE());setDateReprise(pSource.getDateReprise());setDateDebutIndemCP(pSource.getDateDebutIndemCP());setDateFinIndemCP(pSource.getDateFinIndemCP());setDateEffetCTP(pSource.getDateEffetCTP());setDateAdhesion(pSource.getDateAdhesion());setDateCessationActiviteEntreprise(pSource.getDateCessationActiviteEntreprise());setDateDebutPeriodeAffiliationEntreprise(pSource.getDateDebutPeriodeAffiliationEntreprise());setDateFinPeriodeAffiliationEntreprise(pSource.getDateFinPeriodeAffiliationEntreprise());setDateDebutEffetConGes(pSource.getDateDebutEffetConGes());setDateFinEffetConGes(pSource.getDateFinEffetConGes());setNumeroVersion(pSource.getNumeroVersion());setIdTechContratDna(pSource.getIdTechContratDna());setNbCongesPayesRestant(pSource.getNbCongesPayesRestant());setMontantIndemnitePreavis(pSource.getMontantIndemnitePreavis());setNbHeuresDIF(pSource.getNbHeuresDIF());setSalaireHoraireNetSalarie(pSource.getSalaireHoraireNetSalarie());setIdTechContratRemplace(pSource.getIdTechContratRemplace());setNbPAS(pSource.getNbPAS());setNbSalariesEntreprise(pSource.getNbSalariesEntreprise());setNbMoisPreavis(pSource.getNbMoisPreavis());setDateDebutPeriodeInactivite(pSource.getDateDebutPeriodeInactivite());setDateFinPeriodeInactivite(pSource.getDateFinPeriodeInactivite());setMotifPeriodeInactivite(pSource.getMotifPeriodeInactivite());setDateDebutAGS(pSource.getDateDebutAGS());setDateFinAGS(pSource.getDateFinAGS());setDateDebutAdhesionRevocable(pSource.getDateDebutAdhesionRevocable());setDateFinAdhesionRevocable(pSource.getDateFinAdhesionRevocable());setIdentiteDeclaree(pSource.getIdentiteDeclaree());setDoute(pSource.getDoute());setIdDocumentNumerique(pSource.getIdDocumentNumerique());setAncienneteMois(pSource.getAncienneteMois());setAncienneteAnnee(pSource.getAncienneteAnnee());setMotifRecours(pSource.getMotifRecours());
  }
  
  public String toString()
  {
    StringBuffer s = new StringBuffer("[_FluxAE");
    subToString(s);
    s.append("]");
    return s.toString();
  }
  
  protected void subToString(StringBuffer pSource)
  {
    pSource.append(", ListeFluxFctDnaPreavis: ");
    pSource.append(m_listeFluxFctDnaPreavis);
    pSource.append(", ListeFluxFctDnaIndemnitesVersees: ");
    pSource.append(m_listeFluxFctDnaIndemnitesVersees);
    pSource.append(", ListeFluxPasDna: ");
    pSource.append(m_listeFluxPasDna);
    pSource.append(", CodeMessage: ");
    pSource.append(m_codeMessage);
    pSource.append(", CodeAction: ");
    pSource.append(m_codeAction);
    pSource.append(", SIRET: ");
    pSource.append(m_SIRET);
    pSource.append(", ReferenceContrat: ");
    pSource.append(m_referenceContrat);
    pSource.append(", NatureContrat: ");
    pSource.append(m_natureContrat);
    pSource.append(", MotifRupture: ");
    pSource.append(m_motifRupture);
    pSource.append(", ClauseNonConcurrence: ");
    pSource.append(m_clauseNonConcurrence);
    pSource.append(", RegimeSpecialSS: ");
    pSource.append(m_regimeSpecialSS);
    pSource.append(", NumeroAffiRegimeSpecialSS: ");
    pSource.append(m_numeroAffiRegimeSpecialSS);
    pSource.append(", LienParente: ");
    pSource.append(m_lienParente);
    pSource.append(", StatutParticulier: ");
    pSource.append(m_statutParticulier);
    pSource.append(", NiveauQualif: ");
    pSource.append(m_niveauQualif);
    pSource.append(", TopTransaction: ");
    pSource.append(m_topTransaction);
    pSource.append(", BneIdentifiantBne: ");
    pSource.append(m_bneIdentifiantBne);
    pSource.append(", BneSiret: ");
    pSource.append(m_bneSiret);
    pSource.append(", BneRaisonSociale: ");
    pSource.append(m_bneRaisonSociale);
    pSource.append(", BneCodePostal: ");
    pSource.append(m_bneCodePostal);
    pSource.append(", BneLibelleCommuneCNAVTS: ");
    pSource.append(m_bneLibelleCommuneCNAVTS);
    pSource.append(", BneAssedicAffiliation: ");
    pSource.append(m_bneAssedicAffiliation);
    pSource.append(", BneNumAffiliation: ");
    pSource.append(m_bneNumAffiliation);
    pSource.append(", BneNouveauCodeNAF: ");
    pSource.append(m_bneNouveauCodeNAF);
    pSource.append(", AbonnementProvisoire: ");
    pSource.append(m_abonnementProvisoire);
    pSource.append(", CodeRegimeCTP: ");
    pSource.append(m_codeRegimeCTP);
    pSource.append(", NomEmployeur: ");
    pSource.append(m_nomEmployeur);
    pSource.append(", PrenomEmployeur: ");
    pSource.append(m_prenomEmployeur);
    pSource.append(", NumUrssaf: ");
    pSource.append(m_numUrssaf);
    pSource.append(", NumCESU: ");
    pSource.append(m_numCESU);
    pSource.append(", NumPAJEEMPLOI: ");
    pSource.append(m_numPAJEEMPLOI);
    pSource.append(", IdBNIRemplace: ");
    pSource.append(m_idBNIRemplace);
    pSource.append(", OrigineAE: ");
    pSource.append(m_origineAE);
    pSource.append(", IndicChomSsRCT: ");
    pSource.append(m_indicChomSsRCT);
    pSource.append(", RefusAdhesionFNE: ");
    pSource.append(m_refusAdhesionFNE);
    pSource.append(", CodeStatutCadre: ");
    pSource.append(m_codeStatutCadre);
    pSource.append(", CocheAlsaceMoselle: ");
    pSource.append(m_cocheAlsaceMoselle);
    pSource.append(", IndCotisationForfaitReel: ");
    pSource.append(m_indCotisationForfaitReel);
    pSource.append(", IndBrutNet: ");
    pSource.append(m_indBrutNet);
    pSource.append(", CodeCaisseCongesPayes: ");
    pSource.append(m_codeCaisseCongesPayes);
    pSource.append(", NumCaisseCP: ");
    pSource.append(m_numCaisseCP);
    pSource.append(", CodeARRCO: ");
    pSource.append(m_codeARRCO);
    pSource.append(", NumBneARRCO: ");
    pSource.append(m_numBneARRCO);
    pSource.append(", SigleARRCO: ");
    pSource.append(m_sigleARRCO);
    pSource.append(", RaisonSocialeARRCO: ");
    pSource.append(m_raisonSocialeARRCO);
    pSource.append(", CodeAGIRC: ");
    pSource.append(m_codeAGIRC);
    pSource.append(", NumBneAGIRC: ");
    pSource.append(m_numBneAGIRC);
    pSource.append(", SigleAGIRC: ");
    pSource.append(m_sigleAGIRC);
    pSource.append(", RaisonSocialeAGIRC: ");
    pSource.append(m_raisonSocialeAGIRC);
    pSource.append(", TypeContrat: ");
    pSource.append(m_typeContrat);
    pSource.append(", CodeRegimeEmployeur: ");
    pSource.append(m_codeRegimeEmployeur);
    pSource.append(", NumConventionGestion: ");
    pSource.append(m_numConventionGestion);
    pSource.append(", NomFamille: ");
    pSource.append(m_nomFamille);
    pSource.append(", Prenom: ");
    pSource.append(m_prenom);
    pSource.append(", IndicMontantIndemnite: ");
    pSource.append(m_indicMontantIndemnite);
    pSource.append(", IndicSalaireHoraire: ");
    pSource.append(m_indicSalaireHoraire);
    pSource.append(", FillerUn: ");
    pSource.append(m_fillerUn);
    pSource.append(", FillerDeux: ");
    pSource.append(m_fillerDeux);
    pSource.append(", EmployAutoAssur: ");
    pSource.append(m_employAutoAssur);
    pSource.append(", NumCG: ");
    pSource.append(m_numCG);
    pSource.append(", EtabFinanc: ");
    pSource.append(m_etabFinanc);
    pSource.append(", NumInterne: ");
    pSource.append(m_numInterne);
    pSource.append(", CodeAffect: ");
    pSource.append(m_codeAffect);
    pSource.append(", StatutSalarie: ");
    pSource.append(m_statutSalarie);
    pSource.append(", CodeStatutjuridique: ");
    pSource.append(m_codeStatutjuridique);
    pSource.append(", NomLogiciel: ");
    pSource.append(m_nomLogiciel);
    pSource.append(", VersionLogiciel: ");
    pSource.append(m_versionLogiciel);
    pSource.append(", CategorieJuridiqueEntreprise: ");
    pSource.append(m_categorieJuridiqueEntreprise);
    pSource.append(", CodeRegimeEntreprise: ");
    pSource.append(m_codeRegimeEntreprise);
    pSource.append(", NatureEntreprise: ");
    pSource.append(m_natureEntreprise);
    pSource.append(", NumGusoEntreprise: ");
    pSource.append(m_numGusoEntreprise);
    pSource.append(", NumMSAEntreprise: ");
    pSource.append(m_numMSAEntreprise);
    pSource.append(", EntreprisePublique: ");
    pSource.append(m_entreprisePublique);
    pSource.append(", TrancheEffectifEntreprise: ");
    pSource.append(m_trancheEffectifEntreprise);
    pSource.append(", DateDebutContrat: ");
    pSource.append(m_dateDebutContrat);
    pSource.append(", DateFinContrat: ");
    pSource.append(m_dateFinContrat);
    pSource.append(", DateNotifRupture: ");
    pSource.append(m_dateNotifRupture);
    pSource.append(", DateProcedureLicenciement: ");
    pSource.append(m_dateProcedureLicenciement);
    pSource.append(", DateDJTP: ");
    pSource.append(m_dateDJTP);
    pSource.append(", DateInitialeFinContrat: ");
    pSource.append(m_dateInitialeFinContrat);
    pSource.append(", DateConnaissanceAE: ");
    pSource.append(m_dateConnaissanceAE);
    pSource.append(", DateReprise: ");
    pSource.append(m_dateReprise);
    pSource.append(", DateDebutIndemCP: ");
    pSource.append(m_dateDebutIndemCP);
    pSource.append(", DateFinIndemCP: ");
    pSource.append(m_dateFinIndemCP);
    pSource.append(", DateEffetCTP: ");
    pSource.append(m_dateEffetCTP);
    pSource.append(", DateAdhesion: ");
    pSource.append(m_dateAdhesion);
    pSource.append(", DateCessationActiviteEntreprise: ");
    pSource.append(m_dateCessationActiviteEntreprise);
    pSource.append(", DateDebutPeriodeAffiliationEntreprise: ");
    pSource.append(m_dateDebutPeriodeAffiliationEntreprise);
    pSource.append(", DateFinPeriodeAffiliationEntreprise: ");
    pSource.append(m_dateFinPeriodeAffiliationEntreprise);
    pSource.append(", DateDebutEffetConGes: ");
    pSource.append(m_dateDebutEffetConGes);
    pSource.append(", DateFinEffetConGes: ");
    pSource.append(m_dateFinEffetConGes);
    pSource.append(", NumeroVersion: ");
    pSource.append(m_numeroVersion);
    pSource.append(", IdTechContratDna: ");
    pSource.append(m_idTechContratDna);
    pSource.append(", NbCongesPayesRestant: ");
    pSource.append(m_nbCongesPayesRestant);
    pSource.append(", MontantIndemnitePreavis: ");
    pSource.append(m_montantIndemnitePreavis);
    pSource.append(", NbHeuresDIF: ");
    pSource.append(m_nbHeuresDIF);
    pSource.append(", SalaireHoraireNetSalarie: ");
    pSource.append(m_salaireHoraireNetSalarie);
    pSource.append(", IdTechContratRemplace: ");
    pSource.append(m_idTechContratRemplace);
    pSource.append(", NbPAS: ");
    pSource.append(m_nbPAS);
    pSource.append(", NbSalariesEntreprise: ");
    pSource.append(m_nbSalariesEntreprise);
    pSource.append(", NbMoisPreavis: ");
    pSource.append(m_nbMoisPreavis);
    pSource.append(", DateDebutPeriodeInactivite: ");
    pSource.append(m_dateDebutPeriodeInactivite);
    pSource.append(", DateFinPeriodeInactivite: ");
    pSource.append(m_dateFinPeriodeInactivite);
    pSource.append(", MotifPeriodeInactivite: ");
    pSource.append(m_motifPeriodeInactivite);
    pSource.append(", DateDebutAGS: ");
    pSource.append(m_dateDebutAGS);
    pSource.append(", DateFinAGS: ");
    pSource.append(m_dateFinAGS);
    pSource.append(", DateDebutAdhesionRevocable: ");
    pSource.append(m_dateDebutAdhesionRevocable);
    pSource.append(", DateFinAdhesionRevocable: ");
    pSource.append(m_dateFinAdhesionRevocable);
    pSource.append(", IdentiteDeclaree: ");
    pSource.append(m_identiteDeclaree);
    pSource.append(", Doute: ");
    pSource.append(m_doute);
    pSource.append(", IdDocumentNumerique: ");
    pSource.append(m_idDocumentNumerique);
    pSource.append(", AncienneteMois: ");
    pSource.append(m_ancienneteMois);
    pSource.append(", AncienneteAnnee: ");
    pSource.append(m_ancienneteAnnee);
    pSource.append(", MotifRecours: ");
    pSource.append(m_motifRecours);
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
    DataBean ListeFluxFctDnaPreavis_Value = getListeFluxFctDnaPreavis();
    GettersHandler ListeFluxFctDnaPreavis_GettersHandler = pHandler.property("ListeFluxFctDnaPreavis", ListeFluxFctDnaPreavis_Value, new Attribute[] { new StringAttribute("C_ERR", getListeFluxFctDnaPreavis_C_ERR()) });
    if ((ListeFluxFctDnaPreavis_GettersHandler != null) && (ListeFluxFctDnaPreavis_Value != null)) {
      ListeFluxFctDnaPreavis_Value.goThrough(ListeFluxFctDnaPreavis_GettersHandler);
    }
    DataBean ListeFluxFctDnaIndemnitesVersees_Value = getListeFluxFctDnaIndemnitesVersees();
    GettersHandler ListeFluxFctDnaIndemnitesVersees_GettersHandler = pHandler.property("ListeFluxFctDnaIndemnitesVersees", ListeFluxFctDnaIndemnitesVersees_Value, new Attribute[] { new StringAttribute("C_ERR", getListeFluxFctDnaIndemnitesVersees_C_ERR()) });
    if ((ListeFluxFctDnaIndemnitesVersees_GettersHandler != null) && (ListeFluxFctDnaIndemnitesVersees_Value != null)) {
      ListeFluxFctDnaIndemnitesVersees_Value.goThrough(ListeFluxFctDnaIndemnitesVersees_GettersHandler);
    }
    DataBean ListeFluxPasDna_Value = getListeFluxPasDna();
    GettersHandler ListeFluxPasDna_GettersHandler = pHandler.property("ListeFluxPasDna", ListeFluxPasDna_Value, new Attribute[] { new StringAttribute("C_ERR", getListeFluxPasDna_C_ERR()) });
    if ((ListeFluxPasDna_GettersHandler != null) && (ListeFluxPasDna_Value != null)) {
      ListeFluxPasDna_Value.goThrough(ListeFluxPasDna_GettersHandler);
    }
    pHandler.property("CodeMessage", getCodeMessage(), new Attribute[] { new StringAttribute("C_ERR", getCodeMessage_C_ERR()) });
    
    pHandler.property("CodeAction", getCodeAction(), new Attribute[] { new StringAttribute("C_ERR", getCodeAction_C_ERR()) });
    
    pHandler.property("SIRET", getSIRET(), new Attribute[] { new StringAttribute("C_ERR", getSIRET_C_ERR()) });
    
    pHandler.property("ReferenceContrat", getReferenceContrat(), new Attribute[] { new StringAttribute("C_ERR", getReferenceContrat_C_ERR()) });
    
    pHandler.property("NatureContrat", getNatureContrat(), new Attribute[] { new StringAttribute("C_ERR", getNatureContrat_C_ERR()) });
    
    pHandler.property("MotifRupture", getMotifRupture(), new Attribute[] { new StringAttribute("C_ERR", getMotifRupture_C_ERR()) });
    
    pHandler.property("ClauseNonConcurrence", getClauseNonConcurrence(), new Attribute[] { new StringAttribute("C_ERR", getClauseNonConcurrence_C_ERR()) });
    
    pHandler.property("RegimeSpecialSS", getRegimeSpecialSS(), new Attribute[] { new StringAttribute("C_ERR", getRegimeSpecialSS_C_ERR()) });
    
    pHandler.property("NumeroAffiRegimeSpecialSS", getNumeroAffiRegimeSpecialSS(), new Attribute[] { new StringAttribute("C_ERR", getNumeroAffiRegimeSpecialSS_C_ERR()) });
    
    pHandler.property("LienParente", getLienParente(), new Attribute[] { new StringAttribute("C_ERR", getLienParente_C_ERR()) });
    
    pHandler.property("StatutParticulier", getStatutParticulier(), new Attribute[] { new StringAttribute("C_ERR", getStatutParticulier_C_ERR()) });
    
    pHandler.property("NiveauQualif", getNiveauQualif(), new Attribute[] { new StringAttribute("C_ERR", getNiveauQualif_C_ERR()) });
    
    pHandler.property("TopTransaction", getTopTransaction(), new Attribute[] { new StringAttribute("C_ERR", getTopTransaction_C_ERR()) });
    
    pHandler.property("BneIdentifiantBne", getBneIdentifiantBne(), new Attribute[] { new StringAttribute("C_ERR", getBneIdentifiantBne_C_ERR()) });
    
    pHandler.property("BneSiret", getBneSiret(), new Attribute[] { new StringAttribute("C_ERR", getBneSiret_C_ERR()) });
    
    pHandler.property("BneRaisonSociale", getBneRaisonSociale(), new Attribute[] { new StringAttribute("C_ERR", getBneRaisonSociale_C_ERR()) });
    
    pHandler.property("BneCodePostal", getBneCodePostal(), new Attribute[] { new StringAttribute("C_ERR", getBneCodePostal_C_ERR()) });
    
    pHandler.property("BneLibelleCommuneCNAVTS", getBneLibelleCommuneCNAVTS(), new Attribute[] { new StringAttribute("C_ERR", getBneLibelleCommuneCNAVTS_C_ERR()) });
    
    pHandler.property("BneAssedicAffiliation", getBneAssedicAffiliation(), new Attribute[] { new StringAttribute("C_ERR", getBneAssedicAffiliation_C_ERR()) });
    
    pHandler.property("BneNumAffiliation", getBneNumAffiliation(), new Attribute[] { new StringAttribute("C_ERR", getBneNumAffiliation_C_ERR()) });
    
    pHandler.property("BneNouveauCodeNAF", getBneNouveauCodeNAF(), new Attribute[] { new StringAttribute("C_ERR", getBneNouveauCodeNAF_C_ERR()) });
    
    pHandler.property("AbonnementProvisoire", getAbonnementProvisoire(), new Attribute[] { new StringAttribute("C_ERR", getAbonnementProvisoire_C_ERR()) });
    
    pHandler.property("CodeRegimeCTP", getCodeRegimeCTP(), new Attribute[] { new StringAttribute("C_ERR", getCodeRegimeCTP_C_ERR()) });
    
    pHandler.property("NomEmployeur", getNomEmployeur(), new Attribute[] { new StringAttribute("C_ERR", getNomEmployeur_C_ERR()) });
    
    pHandler.property("PrenomEmployeur", getPrenomEmployeur(), new Attribute[] { new StringAttribute("C_ERR", getPrenomEmployeur_C_ERR()) });
    
    pHandler.property("NumUrssaf", getNumUrssaf(), new Attribute[] { new StringAttribute("C_ERR", getNumUrssaf_C_ERR()) });
    
    pHandler.property("NumCESU", getNumCESU(), new Attribute[] { new StringAttribute("C_ERR", getNumCESU_C_ERR()) });
    
    pHandler.property("NumPAJEEMPLOI", getNumPAJEEMPLOI(), new Attribute[] { new StringAttribute("C_ERR", getNumPAJEEMPLOI_C_ERR()) });
    
    pHandler.property("IdBNIRemplace", getIdBNIRemplace(), new Attribute[] { new StringAttribute("C_ERR", getIdBNIRemplace_C_ERR()) });
    
    pHandler.property("OrigineAE", getOrigineAE(), new Attribute[] { new StringAttribute("C_ERR", getOrigineAE_C_ERR()) });
    
    pHandler.property("IndicChomSsRCT", getIndicChomSsRCT(), new Attribute[] { new StringAttribute("C_ERR", getIndicChomSsRCT_C_ERR()) });
    
    pHandler.property("RefusAdhesionFNE", getRefusAdhesionFNE(), new Attribute[] { new StringAttribute("C_ERR", getRefusAdhesionFNE_C_ERR()) });
    
    pHandler.property("CodeStatutCadre", getCodeStatutCadre(), new Attribute[] { new StringAttribute("C_ERR", getCodeStatutCadre_C_ERR()) });
    
    pHandler.property("CocheAlsaceMoselle", getCocheAlsaceMoselle(), new Attribute[] { new StringAttribute("C_ERR", getCocheAlsaceMoselle_C_ERR()) });
    
    pHandler.property("IndCotisationForfaitReel", getIndCotisationForfaitReel(), new Attribute[] { new StringAttribute("C_ERR", getIndCotisationForfaitReel_C_ERR()) });
    
    pHandler.property("IndBrutNet", getIndBrutNet(), new Attribute[] { new StringAttribute("C_ERR", getIndBrutNet_C_ERR()) });
    
    pHandler.property("CodeCaisseCongesPayes", getCodeCaisseCongesPayes(), new Attribute[] { new StringAttribute("C_ERR", getCodeCaisseCongesPayes_C_ERR()) });
    
    pHandler.property("NumCaisseCP", getNumCaisseCP(), new Attribute[] { new StringAttribute("C_ERR", getNumCaisseCP_C_ERR()) });
    
    pHandler.property("CodeARRCO", getCodeARRCO(), new Attribute[] { new StringAttribute("C_ERR", getCodeARRCO_C_ERR()) });
    
    pHandler.property("NumBneARRCO", getNumBneARRCO(), new Attribute[] { new StringAttribute("C_ERR", getNumBneARRCO_C_ERR()) });
    
    pHandler.property("SigleARRCO", getSigleARRCO(), new Attribute[] { new StringAttribute("C_ERR", getSigleARRCO_C_ERR()) });
    
    pHandler.property("RaisonSocialeARRCO", getRaisonSocialeARRCO(), new Attribute[] { new StringAttribute("C_ERR", getRaisonSocialeARRCO_C_ERR()) });
    
    pHandler.property("CodeAGIRC", getCodeAGIRC(), new Attribute[] { new StringAttribute("C_ERR", getCodeAGIRC_C_ERR()) });
    
    pHandler.property("NumBneAGIRC", getNumBneAGIRC(), new Attribute[] { new StringAttribute("C_ERR", getNumBneAGIRC_C_ERR()) });
    
    pHandler.property("SigleAGIRC", getSigleAGIRC(), new Attribute[] { new StringAttribute("C_ERR", getSigleAGIRC_C_ERR()) });
    
    pHandler.property("RaisonSocialeAGIRC", getRaisonSocialeAGIRC(), new Attribute[] { new StringAttribute("C_ERR", getRaisonSocialeAGIRC_C_ERR()) });
    
    pHandler.property("TypeContrat", getTypeContrat(), new Attribute[] { new StringAttribute("C_ERR", getTypeContrat_C_ERR()) });
    
    pHandler.property("CodeRegimeEmployeur", getCodeRegimeEmployeur(), new Attribute[] { new StringAttribute("C_ERR", getCodeRegimeEmployeur_C_ERR()) });
    
    pHandler.property("NumConventionGestion", getNumConventionGestion(), new Attribute[] { new StringAttribute("C_ERR", getNumConventionGestion_C_ERR()) });
    
    pHandler.property("NomFamille", getNomFamille(), new Attribute[] { new StringAttribute("C_ERR", getNomFamille_C_ERR()) });
    
    pHandler.property("Prenom", getPrenom(), new Attribute[] { new StringAttribute("C_ERR", getPrenom_C_ERR()) });
    
    pHandler.property("IndicMontantIndemnite", getIndicMontantIndemnite(), new Attribute[] { new StringAttribute("C_ERR", getIndicMontantIndemnite_C_ERR()) });
    
    pHandler.property("IndicSalaireHoraire", getIndicSalaireHoraire(), new Attribute[] { new StringAttribute("C_ERR", getIndicSalaireHoraire_C_ERR()) });
    
    pHandler.property("FillerUn", getFillerUn(), new Attribute[] { new StringAttribute("C_ERR", getFillerUn_C_ERR()) });
    
    pHandler.property("FillerDeux", getFillerDeux(), new Attribute[] { new StringAttribute("C_ERR", getFillerDeux_C_ERR()) });
    
    pHandler.property("EmployAutoAssur", getEmployAutoAssur(), new Attribute[] { new StringAttribute("C_ERR", getEmployAutoAssur_C_ERR()) });
    
    pHandler.property("NumCG", getNumCG(), new Attribute[] { new StringAttribute("C_ERR", getNumCG_C_ERR()) });
    
    pHandler.property("EtabFinanc", getEtabFinanc(), new Attribute[] { new StringAttribute("C_ERR", getEtabFinanc_C_ERR()) });
    
    pHandler.property("NumInterne", getNumInterne(), new Attribute[] { new StringAttribute("C_ERR", getNumInterne_C_ERR()) });
    
    pHandler.property("CodeAffect", getCodeAffect(), new Attribute[] { new StringAttribute("C_ERR", getCodeAffect_C_ERR()) });
    
    pHandler.property("StatutSalarie", getStatutSalarie(), new Attribute[] { new StringAttribute("C_ERR", getStatutSalarie_C_ERR()) });
    
    pHandler.property("CodeStatutjuridique", getCodeStatutjuridique(), new Attribute[] { new StringAttribute("C_ERR", getCodeStatutjuridique_C_ERR()) });
    
    pHandler.property("NomLogiciel", getNomLogiciel(), new Attribute[] { new StringAttribute("C_ERR", getNomLogiciel_C_ERR()) });
    
    pHandler.property("VersionLogiciel", getVersionLogiciel(), new Attribute[] { new StringAttribute("C_ERR", getVersionLogiciel_C_ERR()) });
    
    pHandler.property("CategorieJuridiqueEntreprise", getCategorieJuridiqueEntreprise(), new Attribute[] { new StringAttribute("C_ERR", getCategorieJuridiqueEntreprise_C_ERR()) });
    
    pHandler.property("CodeRegimeEntreprise", getCodeRegimeEntreprise(), new Attribute[] { new StringAttribute("C_ERR", getCodeRegimeEntreprise_C_ERR()) });
    
    pHandler.property("NatureEntreprise", getNatureEntreprise(), new Attribute[] { new StringAttribute("C_ERR", getNatureEntreprise_C_ERR()) });
    
    pHandler.property("NumGusoEntreprise", getNumGusoEntreprise(), new Attribute[] { new StringAttribute("C_ERR", getNumGusoEntreprise_C_ERR()) });
    
    pHandler.property("NumMSAEntreprise", getNumMSAEntreprise(), new Attribute[] { new StringAttribute("C_ERR", getNumMSAEntreprise_C_ERR()) });
    
    pHandler.property("EntreprisePublique", getEntreprisePublique(), new Attribute[] { new StringAttribute("C_ERR", getEntreprisePublique_C_ERR()) });
    
    pHandler.property("TrancheEffectifEntreprise", getTrancheEffectifEntreprise(), new Attribute[] { new StringAttribute("C_ERR", getTrancheEffectifEntreprise_C_ERR()) });
    
    pHandler.property("DateDebutContrat", getDateDebutContrat(), new Attribute[] { new StringAttribute("C_ERR", getDateDebutContrat_C_ERR()) });
    
    pHandler.property("DateFinContrat", getDateFinContrat(), new Attribute[] { new StringAttribute("C_ERR", getDateFinContrat_C_ERR()) });
    
    pHandler.property("DateNotifRupture", getDateNotifRupture(), new Attribute[] { new StringAttribute("C_ERR", getDateNotifRupture_C_ERR()) });
    
    pHandler.property("DateProcedureLicenciement", getDateProcedureLicenciement(), new Attribute[] { new StringAttribute("C_ERR", getDateProcedureLicenciement_C_ERR()) });
    
    pHandler.property("DateDJTP", getDateDJTP(), new Attribute[] { new StringAttribute("C_ERR", getDateDJTP_C_ERR()) });
    
    pHandler.property("DateInitialeFinContrat", getDateInitialeFinContrat(), new Attribute[] { new StringAttribute("C_ERR", getDateInitialeFinContrat_C_ERR()) });
    
    pHandler.property("DateConnaissanceAE", getDateConnaissanceAE(), new Attribute[] { new StringAttribute("C_ERR", getDateConnaissanceAE_C_ERR()) });
    
    pHandler.property("DateReprise", getDateReprise(), new Attribute[] { new StringAttribute("C_ERR", getDateReprise_C_ERR()) });
    
    pHandler.property("DateDebutIndemCP", getDateDebutIndemCP(), new Attribute[] { new StringAttribute("C_ERR", getDateDebutIndemCP_C_ERR()) });
    
    pHandler.property("DateFinIndemCP", getDateFinIndemCP(), new Attribute[] { new StringAttribute("C_ERR", getDateFinIndemCP_C_ERR()) });
    
    pHandler.property("DateEffetCTP", getDateEffetCTP(), new Attribute[] { new StringAttribute("C_ERR", getDateEffetCTP_C_ERR()) });
    
    pHandler.property("DateAdhesion", getDateAdhesion(), new Attribute[] { new StringAttribute("C_ERR", getDateAdhesion_C_ERR()) });
    
    pHandler.property("DateCessationActiviteEntreprise", getDateCessationActiviteEntreprise(), new Attribute[] { new StringAttribute("C_ERR", getDateCessationActiviteEntreprise_C_ERR()) });
    
    pHandler.property("DateDebutPeriodeAffiliationEntreprise", getDateDebutPeriodeAffiliationEntreprise(), new Attribute[] { new StringAttribute("C_ERR", getDateDebutPeriodeAffiliationEntreprise_C_ERR()) });
    
    pHandler.property("DateFinPeriodeAffiliationEntreprise", getDateFinPeriodeAffiliationEntreprise(), new Attribute[] { new StringAttribute("C_ERR", getDateFinPeriodeAffiliationEntreprise_C_ERR()) });
    
    pHandler.property("DateDebutEffetConGes", getDateDebutEffetConGes(), new Attribute[] { new StringAttribute("C_ERR", getDateDebutEffetConGes_C_ERR()) });
    
    pHandler.property("DateFinEffetConGes", getDateFinEffetConGes(), new Attribute[] { new StringAttribute("C_ERR", getDateFinEffetConGes_C_ERR()) });
    
    pHandler.property("NumeroVersion", getNumeroVersion(), new Attribute[] { new StringAttribute("C_ERR", getNumeroVersion_C_ERR()) });
    
    pHandler.property("IdTechContratDna", getIdTechContratDna(), new Attribute[] { new StringAttribute("C_ERR", getIdTechContratDna_C_ERR()) });
    
    pHandler.property("NbCongesPayesRestant", getNbCongesPayesRestant(), new Attribute[] { new StringAttribute("C_ERR", getNbCongesPayesRestant_C_ERR()) });
    
    pHandler.property("MontantIndemnitePreavis", getMontantIndemnitePreavis(), new Attribute[] { new StringAttribute("C_ERR", getMontantIndemnitePreavis_C_ERR()) });
    
    pHandler.property("NbHeuresDIF", getNbHeuresDIF(), new Attribute[] { new StringAttribute("C_ERR", getNbHeuresDIF_C_ERR()) });
    
    pHandler.property("SalaireHoraireNetSalarie", getSalaireHoraireNetSalarie(), new Attribute[] { new StringAttribute("C_ERR", getSalaireHoraireNetSalarie_C_ERR()) });
    
    pHandler.property("IdTechContratRemplace", getIdTechContratRemplace(), new Attribute[] { new StringAttribute("C_ERR", getIdTechContratRemplace_C_ERR()) });
    
    pHandler.property("NbPAS", getNbPAS(), new Attribute[] { new StringAttribute("C_ERR", getNbPAS_C_ERR()) });
    
    pHandler.property("NbSalariesEntreprise", getNbSalariesEntreprise(), new Attribute[] { new StringAttribute("C_ERR", getNbSalariesEntreprise_C_ERR()) });
    
    pHandler.property("NbMoisPreavis", getNbMoisPreavis(), new Attribute[] { new StringAttribute("C_ERR", getNbMoisPreavis_C_ERR()) });
    
    pHandler.property("DateDebutPeriodeInactivite", getDateDebutPeriodeInactivite(), new Attribute[] { new StringAttribute("C_ERR", getDateDebutPeriodeInactivite_C_ERR()) });
    
    pHandler.property("DateFinPeriodeInactivite", getDateFinPeriodeInactivite(), new Attribute[] { new StringAttribute("C_ERR", getDateFinPeriodeInactivite_C_ERR()) });
    
    pHandler.property("MotifPeriodeInactivite", getMotifPeriodeInactivite(), new Attribute[] { new StringAttribute("C_ERR", getMotifPeriodeInactivite_C_ERR()) });
    
    pHandler.property("DateDebutAGS", getDateDebutAGS(), new Attribute[] { new StringAttribute("C_ERR", getDateDebutAGS_C_ERR()) });
    
    pHandler.property("DateFinAGS", getDateFinAGS(), new Attribute[] { new StringAttribute("C_ERR", getDateFinAGS_C_ERR()) });
    
    pHandler.property("DateDebutAdhesionRevocable", getDateDebutAdhesionRevocable(), new Attribute[] { new StringAttribute("C_ERR", getDateDebutAdhesionRevocable_C_ERR()) });
    
    pHandler.property("DateFinAdhesionRevocable", getDateFinAdhesionRevocable(), new Attribute[] { new StringAttribute("C_ERR", getDateFinAdhesionRevocable_C_ERR()) });
    
    pHandler.property("IdentiteDeclaree", getIdentiteDeclaree(), new Attribute[] { new StringAttribute("C_ERR", getIdentiteDeclaree_C_ERR()) });
    
    pHandler.property("Doute", getDoute(), new Attribute[] { new StringAttribute("C_ERR", getDoute_C_ERR()) });
    
    pHandler.property("IdDocumentNumerique", getIdDocumentNumerique(), new Attribute[] { new StringAttribute("C_ERR", getIdDocumentNumerique_C_ERR()) });
    
    pHandler.property("AncienneteMois", getAncienneteMois(), new Attribute[] { new StringAttribute("C_ERR", getAncienneteMois_C_ERR()) });
    
    pHandler.property("AncienneteAnnee", getAncienneteAnnee(), new Attribute[] { new StringAttribute("C_ERR", getAncienneteAnnee_C_ERR()) });
    
    pHandler.property("MotifRecours", getMotifRecours(), new Attribute[] { new StringAttribute("C_ERR", getMotifRecours_C_ERR()) });
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
    setListeFluxFctDnaPreavis((_ListeFluxFctDnaPreavis)pHandler.databeanProperty("ListeFluxFctDnaPreavis", _ListeFluxFctDnaPreavis.class));
    setListeFluxFctDnaPreavis_C_ERR(pHandler.stringAttribute("ListeFluxFctDnaPreavis", "C_ERR"));
    setListeFluxFctDnaIndemnitesVersees((_ListeFluxFctDnaIndemnitesVersees)pHandler.databeanProperty("ListeFluxFctDnaIndemnitesVersees", _ListeFluxFctDnaIndemnitesVersees.class));
    setListeFluxFctDnaIndemnitesVersees_C_ERR(pHandler.stringAttribute("ListeFluxFctDnaIndemnitesVersees", "C_ERR"));
    setListeFluxPasDna((_ListeFluxPasDna)pHandler.databeanProperty("ListeFluxPasDna", _ListeFluxPasDna.class));
    setListeFluxPasDna_C_ERR(pHandler.stringAttribute("ListeFluxPasDna", "C_ERR"));
    setCodeMessage((String)pHandler.objectProperty("CodeMessage", String.class));
    setCodeMessage_C_ERR(pHandler.stringAttribute("CodeMessage", "C_ERR"));
    
    setCodeAction((String)pHandler.objectProperty("CodeAction", String.class));
    setCodeAction_C_ERR(pHandler.stringAttribute("CodeAction", "C_ERR"));
    
    setSIRET((String)pHandler.objectProperty("SIRET", String.class));
    setSIRET_C_ERR(pHandler.stringAttribute("SIRET", "C_ERR"));
    
    setReferenceContrat((String)pHandler.objectProperty("ReferenceContrat", String.class));
    setReferenceContrat_C_ERR(pHandler.stringAttribute("ReferenceContrat", "C_ERR"));
    
    setNatureContrat((String)pHandler.objectProperty("NatureContrat", String.class));
    setNatureContrat_C_ERR(pHandler.stringAttribute("NatureContrat", "C_ERR"));
    
    setMotifRupture((String)pHandler.objectProperty("MotifRupture", String.class));
    setMotifRupture_C_ERR(pHandler.stringAttribute("MotifRupture", "C_ERR"));
    
    setClauseNonConcurrence((String)pHandler.objectProperty("ClauseNonConcurrence", String.class));
    setClauseNonConcurrence_C_ERR(pHandler.stringAttribute("ClauseNonConcurrence", "C_ERR"));
    
    setRegimeSpecialSS((String)pHandler.objectProperty("RegimeSpecialSS", String.class));
    setRegimeSpecialSS_C_ERR(pHandler.stringAttribute("RegimeSpecialSS", "C_ERR"));
    
    setNumeroAffiRegimeSpecialSS((String)pHandler.objectProperty("NumeroAffiRegimeSpecialSS", String.class));
    setNumeroAffiRegimeSpecialSS_C_ERR(pHandler.stringAttribute("NumeroAffiRegimeSpecialSS", "C_ERR"));
    
    setLienParente((String)pHandler.objectProperty("LienParente", String.class));
    setLienParente_C_ERR(pHandler.stringAttribute("LienParente", "C_ERR"));
    
    setStatutParticulier((String)pHandler.objectProperty("StatutParticulier", String.class));
    setStatutParticulier_C_ERR(pHandler.stringAttribute("StatutParticulier", "C_ERR"));
    
    setNiveauQualif((String)pHandler.objectProperty("NiveauQualif", String.class));
    setNiveauQualif_C_ERR(pHandler.stringAttribute("NiveauQualif", "C_ERR"));
    
    setTopTransaction((String)pHandler.objectProperty("TopTransaction", String.class));
    setTopTransaction_C_ERR(pHandler.stringAttribute("TopTransaction", "C_ERR"));
    
    setBneIdentifiantBne((String)pHandler.objectProperty("BneIdentifiantBne", String.class));
    setBneIdentifiantBne_C_ERR(pHandler.stringAttribute("BneIdentifiantBne", "C_ERR"));
    
    setBneSiret((String)pHandler.objectProperty("BneSiret", String.class));
    setBneSiret_C_ERR(pHandler.stringAttribute("BneSiret", "C_ERR"));
    
    setBneRaisonSociale((String)pHandler.objectProperty("BneRaisonSociale", String.class));
    setBneRaisonSociale_C_ERR(pHandler.stringAttribute("BneRaisonSociale", "C_ERR"));
    
    setBneCodePostal((String)pHandler.objectProperty("BneCodePostal", String.class));
    setBneCodePostal_C_ERR(pHandler.stringAttribute("BneCodePostal", "C_ERR"));
    
    setBneLibelleCommuneCNAVTS((String)pHandler.objectProperty("BneLibelleCommuneCNAVTS", String.class));
    setBneLibelleCommuneCNAVTS_C_ERR(pHandler.stringAttribute("BneLibelleCommuneCNAVTS", "C_ERR"));
    
    setBneAssedicAffiliation((String)pHandler.objectProperty("BneAssedicAffiliation", String.class));
    setBneAssedicAffiliation_C_ERR(pHandler.stringAttribute("BneAssedicAffiliation", "C_ERR"));
    
    setBneNumAffiliation((String)pHandler.objectProperty("BneNumAffiliation", String.class));
    setBneNumAffiliation_C_ERR(pHandler.stringAttribute("BneNumAffiliation", "C_ERR"));
    
    setBneNouveauCodeNAF((String)pHandler.objectProperty("BneNouveauCodeNAF", String.class));
    setBneNouveauCodeNAF_C_ERR(pHandler.stringAttribute("BneNouveauCodeNAF", "C_ERR"));
    
    setAbonnementProvisoire((String)pHandler.objectProperty("AbonnementProvisoire", String.class));
    setAbonnementProvisoire_C_ERR(pHandler.stringAttribute("AbonnementProvisoire", "C_ERR"));
    
    setCodeRegimeCTP((String)pHandler.objectProperty("CodeRegimeCTP", String.class));
    setCodeRegimeCTP_C_ERR(pHandler.stringAttribute("CodeRegimeCTP", "C_ERR"));
    
    setNomEmployeur((String)pHandler.objectProperty("NomEmployeur", String.class));
    setNomEmployeur_C_ERR(pHandler.stringAttribute("NomEmployeur", "C_ERR"));
    
    setPrenomEmployeur((String)pHandler.objectProperty("PrenomEmployeur", String.class));
    setPrenomEmployeur_C_ERR(pHandler.stringAttribute("PrenomEmployeur", "C_ERR"));
    
    setNumUrssaf((String)pHandler.objectProperty("NumUrssaf", String.class));
    setNumUrssaf_C_ERR(pHandler.stringAttribute("NumUrssaf", "C_ERR"));
    
    setNumCESU((String)pHandler.objectProperty("NumCESU", String.class));
    setNumCESU_C_ERR(pHandler.stringAttribute("NumCESU", "C_ERR"));
    
    setNumPAJEEMPLOI((String)pHandler.objectProperty("NumPAJEEMPLOI", String.class));
    setNumPAJEEMPLOI_C_ERR(pHandler.stringAttribute("NumPAJEEMPLOI", "C_ERR"));
    
    setIdBNIRemplace((String)pHandler.objectProperty("IdBNIRemplace", String.class));
    setIdBNIRemplace_C_ERR(pHandler.stringAttribute("IdBNIRemplace", "C_ERR"));
    
    setOrigineAE((String)pHandler.objectProperty("OrigineAE", String.class));
    setOrigineAE_C_ERR(pHandler.stringAttribute("OrigineAE", "C_ERR"));
    
    setIndicChomSsRCT((String)pHandler.objectProperty("IndicChomSsRCT", String.class));
    setIndicChomSsRCT_C_ERR(pHandler.stringAttribute("IndicChomSsRCT", "C_ERR"));
    
    setRefusAdhesionFNE((String)pHandler.objectProperty("RefusAdhesionFNE", String.class));
    setRefusAdhesionFNE_C_ERR(pHandler.stringAttribute("RefusAdhesionFNE", "C_ERR"));
    
    setCodeStatutCadre((String)pHandler.objectProperty("CodeStatutCadre", String.class));
    setCodeStatutCadre_C_ERR(pHandler.stringAttribute("CodeStatutCadre", "C_ERR"));
    
    setCocheAlsaceMoselle((String)pHandler.objectProperty("CocheAlsaceMoselle", String.class));
    setCocheAlsaceMoselle_C_ERR(pHandler.stringAttribute("CocheAlsaceMoselle", "C_ERR"));
    
    setIndCotisationForfaitReel((String)pHandler.objectProperty("IndCotisationForfaitReel", String.class));
    setIndCotisationForfaitReel_C_ERR(pHandler.stringAttribute("IndCotisationForfaitReel", "C_ERR"));
    
    setIndBrutNet((String)pHandler.objectProperty("IndBrutNet", String.class));
    setIndBrutNet_C_ERR(pHandler.stringAttribute("IndBrutNet", "C_ERR"));
    
    setCodeCaisseCongesPayes((String)pHandler.objectProperty("CodeCaisseCongesPayes", String.class));
    setCodeCaisseCongesPayes_C_ERR(pHandler.stringAttribute("CodeCaisseCongesPayes", "C_ERR"));
    
    setNumCaisseCP((String)pHandler.objectProperty("NumCaisseCP", String.class));
    setNumCaisseCP_C_ERR(pHandler.stringAttribute("NumCaisseCP", "C_ERR"));
    
    setCodeARRCO((String)pHandler.objectProperty("CodeARRCO", String.class));
    setCodeARRCO_C_ERR(pHandler.stringAttribute("CodeARRCO", "C_ERR"));
    
    setNumBneARRCO((String)pHandler.objectProperty("NumBneARRCO", String.class));
    setNumBneARRCO_C_ERR(pHandler.stringAttribute("NumBneARRCO", "C_ERR"));
    
    setSigleARRCO((String)pHandler.objectProperty("SigleARRCO", String.class));
    setSigleARRCO_C_ERR(pHandler.stringAttribute("SigleARRCO", "C_ERR"));
    
    setRaisonSocialeARRCO((String)pHandler.objectProperty("RaisonSocialeARRCO", String.class));
    setRaisonSocialeARRCO_C_ERR(pHandler.stringAttribute("RaisonSocialeARRCO", "C_ERR"));
    
    setCodeAGIRC((String)pHandler.objectProperty("CodeAGIRC", String.class));
    setCodeAGIRC_C_ERR(pHandler.stringAttribute("CodeAGIRC", "C_ERR"));
    
    setNumBneAGIRC((String)pHandler.objectProperty("NumBneAGIRC", String.class));
    setNumBneAGIRC_C_ERR(pHandler.stringAttribute("NumBneAGIRC", "C_ERR"));
    
    setSigleAGIRC((String)pHandler.objectProperty("SigleAGIRC", String.class));
    setSigleAGIRC_C_ERR(pHandler.stringAttribute("SigleAGIRC", "C_ERR"));
    
    setRaisonSocialeAGIRC((String)pHandler.objectProperty("RaisonSocialeAGIRC", String.class));
    setRaisonSocialeAGIRC_C_ERR(pHandler.stringAttribute("RaisonSocialeAGIRC", "C_ERR"));
    
    setTypeContrat((String)pHandler.objectProperty("TypeContrat", String.class));
    setTypeContrat_C_ERR(pHandler.stringAttribute("TypeContrat", "C_ERR"));
    
    setCodeRegimeEmployeur((String)pHandler.objectProperty("CodeRegimeEmployeur", String.class));
    setCodeRegimeEmployeur_C_ERR(pHandler.stringAttribute("CodeRegimeEmployeur", "C_ERR"));
    
    setNumConventionGestion((String)pHandler.objectProperty("NumConventionGestion", String.class));
    setNumConventionGestion_C_ERR(pHandler.stringAttribute("NumConventionGestion", "C_ERR"));
    
    setNomFamille((String)pHandler.objectProperty("NomFamille", String.class));
    setNomFamille_C_ERR(pHandler.stringAttribute("NomFamille", "C_ERR"));
    
    setPrenom((String)pHandler.objectProperty("Prenom", String.class));
    setPrenom_C_ERR(pHandler.stringAttribute("Prenom", "C_ERR"));
    
    setIndicMontantIndemnite((String)pHandler.objectProperty("IndicMontantIndemnite", String.class));
    setIndicMontantIndemnite_C_ERR(pHandler.stringAttribute("IndicMontantIndemnite", "C_ERR"));
    
    setIndicSalaireHoraire((String)pHandler.objectProperty("IndicSalaireHoraire", String.class));
    setIndicSalaireHoraire_C_ERR(pHandler.stringAttribute("IndicSalaireHoraire", "C_ERR"));
    
    setFillerUn((String)pHandler.objectProperty("FillerUn", String.class));
    setFillerUn_C_ERR(pHandler.stringAttribute("FillerUn", "C_ERR"));
    
    setFillerDeux((String)pHandler.objectProperty("FillerDeux", String.class));
    setFillerDeux_C_ERR(pHandler.stringAttribute("FillerDeux", "C_ERR"));
    
    setEmployAutoAssur((String)pHandler.objectProperty("EmployAutoAssur", String.class));
    setEmployAutoAssur_C_ERR(pHandler.stringAttribute("EmployAutoAssur", "C_ERR"));
    
    setNumCG((String)pHandler.objectProperty("NumCG", String.class));
    setNumCG_C_ERR(pHandler.stringAttribute("NumCG", "C_ERR"));
    
    setEtabFinanc((String)pHandler.objectProperty("EtabFinanc", String.class));
    setEtabFinanc_C_ERR(pHandler.stringAttribute("EtabFinanc", "C_ERR"));
    
    setNumInterne((String)pHandler.objectProperty("NumInterne", String.class));
    setNumInterne_C_ERR(pHandler.stringAttribute("NumInterne", "C_ERR"));
    
    setCodeAffect((String)pHandler.objectProperty("CodeAffect", String.class));
    setCodeAffect_C_ERR(pHandler.stringAttribute("CodeAffect", "C_ERR"));
    
    setStatutSalarie((String)pHandler.objectProperty("StatutSalarie", String.class));
    setStatutSalarie_C_ERR(pHandler.stringAttribute("StatutSalarie", "C_ERR"));
    
    setCodeStatutjuridique((String)pHandler.objectProperty("CodeStatutjuridique", String.class));
    setCodeStatutjuridique_C_ERR(pHandler.stringAttribute("CodeStatutjuridique", "C_ERR"));
    
    setNomLogiciel((String)pHandler.objectProperty("NomLogiciel", String.class));
    setNomLogiciel_C_ERR(pHandler.stringAttribute("NomLogiciel", "C_ERR"));
    
    setVersionLogiciel((String)pHandler.objectProperty("VersionLogiciel", String.class));
    setVersionLogiciel_C_ERR(pHandler.stringAttribute("VersionLogiciel", "C_ERR"));
    
    setCategorieJuridiqueEntreprise((String)pHandler.objectProperty("CategorieJuridiqueEntreprise", String.class));
    setCategorieJuridiqueEntreprise_C_ERR(pHandler.stringAttribute("CategorieJuridiqueEntreprise", "C_ERR"));
    
    setCodeRegimeEntreprise((String)pHandler.objectProperty("CodeRegimeEntreprise", String.class));
    setCodeRegimeEntreprise_C_ERR(pHandler.stringAttribute("CodeRegimeEntreprise", "C_ERR"));
    
    setNatureEntreprise((String)pHandler.objectProperty("NatureEntreprise", String.class));
    setNatureEntreprise_C_ERR(pHandler.stringAttribute("NatureEntreprise", "C_ERR"));
    
    setNumGusoEntreprise((String)pHandler.objectProperty("NumGusoEntreprise", String.class));
    setNumGusoEntreprise_C_ERR(pHandler.stringAttribute("NumGusoEntreprise", "C_ERR"));
    
    setNumMSAEntreprise((String)pHandler.objectProperty("NumMSAEntreprise", String.class));
    setNumMSAEntreprise_C_ERR(pHandler.stringAttribute("NumMSAEntreprise", "C_ERR"));
    
    setEntreprisePublique((String)pHandler.objectProperty("EntreprisePublique", String.class));
    setEntreprisePublique_C_ERR(pHandler.stringAttribute("EntreprisePublique", "C_ERR"));
    
    setTrancheEffectifEntreprise((String)pHandler.objectProperty("TrancheEffectifEntreprise", String.class));
    setTrancheEffectifEntreprise_C_ERR(pHandler.stringAttribute("TrancheEffectifEntreprise", "C_ERR"));
    
    setDateDebutContrat((Damj)pHandler.objectProperty("DateDebutContrat", Damj.class));
    setDateDebutContrat_C_ERR(pHandler.stringAttribute("DateDebutContrat", "C_ERR"));
    
    setDateFinContrat((Damj)pHandler.objectProperty("DateFinContrat", Damj.class));
    setDateFinContrat_C_ERR(pHandler.stringAttribute("DateFinContrat", "C_ERR"));
    
    setDateNotifRupture((Damj)pHandler.objectProperty("DateNotifRupture", Damj.class));
    setDateNotifRupture_C_ERR(pHandler.stringAttribute("DateNotifRupture", "C_ERR"));
    
    setDateProcedureLicenciement((Damj)pHandler.objectProperty("DateProcedureLicenciement", Damj.class));
    setDateProcedureLicenciement_C_ERR(pHandler.stringAttribute("DateProcedureLicenciement", "C_ERR"));
    
    setDateDJTP((Damj)pHandler.objectProperty("DateDJTP", Damj.class));
    setDateDJTP_C_ERR(pHandler.stringAttribute("DateDJTP", "C_ERR"));
    
    setDateInitialeFinContrat((Damj)pHandler.objectProperty("DateInitialeFinContrat", Damj.class));
    setDateInitialeFinContrat_C_ERR(pHandler.stringAttribute("DateInitialeFinContrat", "C_ERR"));
    
    setDateConnaissanceAE((Damj)pHandler.objectProperty("DateConnaissanceAE", Damj.class));
    setDateConnaissanceAE_C_ERR(pHandler.stringAttribute("DateConnaissanceAE", "C_ERR"));
    
    setDateReprise((Damj)pHandler.objectProperty("DateReprise", Damj.class));
    setDateReprise_C_ERR(pHandler.stringAttribute("DateReprise", "C_ERR"));
    
    setDateDebutIndemCP((Damj)pHandler.objectProperty("DateDebutIndemCP", Damj.class));
    setDateDebutIndemCP_C_ERR(pHandler.stringAttribute("DateDebutIndemCP", "C_ERR"));
    
    setDateFinIndemCP((Damj)pHandler.objectProperty("DateFinIndemCP", Damj.class));
    setDateFinIndemCP_C_ERR(pHandler.stringAttribute("DateFinIndemCP", "C_ERR"));
    
    setDateEffetCTP((Damj)pHandler.objectProperty("DateEffetCTP", Damj.class));
    setDateEffetCTP_C_ERR(pHandler.stringAttribute("DateEffetCTP", "C_ERR"));
    
    setDateAdhesion((Damj)pHandler.objectProperty("DateAdhesion", Damj.class));
    setDateAdhesion_C_ERR(pHandler.stringAttribute("DateAdhesion", "C_ERR"));
    
    setDateCessationActiviteEntreprise((Damj)pHandler.objectProperty("DateCessationActiviteEntreprise", Damj.class));
    setDateCessationActiviteEntreprise_C_ERR(pHandler.stringAttribute("DateCessationActiviteEntreprise", "C_ERR"));
    
    setDateDebutPeriodeAffiliationEntreprise((Damj)pHandler.objectProperty("DateDebutPeriodeAffiliationEntreprise", Damj.class));
    setDateDebutPeriodeAffiliationEntreprise_C_ERR(pHandler.stringAttribute("DateDebutPeriodeAffiliationEntreprise", "C_ERR"));
    
    setDateFinPeriodeAffiliationEntreprise((Damj)pHandler.objectProperty("DateFinPeriodeAffiliationEntreprise", Damj.class));
    setDateFinPeriodeAffiliationEntreprise_C_ERR(pHandler.stringAttribute("DateFinPeriodeAffiliationEntreprise", "C_ERR"));
    
    setDateDebutEffetConGes((Damj)pHandler.objectProperty("DateDebutEffetConGes", Damj.class));
    setDateDebutEffetConGes_C_ERR(pHandler.stringAttribute("DateDebutEffetConGes", "C_ERR"));
    
    setDateFinEffetConGes((Damj)pHandler.objectProperty("DateFinEffetConGes", Damj.class));
    setDateFinEffetConGes_C_ERR(pHandler.stringAttribute("DateFinEffetConGes", "C_ERR"));
    
    setNumeroVersion((BigDecimal)pHandler.objectProperty("NumeroVersion", BigDecimal.class));
    setNumeroVersion_C_ERR(pHandler.stringAttribute("NumeroVersion", "C_ERR"));
    
    setIdTechContratDna((BigDecimal)pHandler.objectProperty("IdTechContratDna", BigDecimal.class));
    setIdTechContratDna_C_ERR(pHandler.stringAttribute("IdTechContratDna", "C_ERR"));
    
    setNbCongesPayesRestant((BigDecimal)pHandler.objectProperty("NbCongesPayesRestant", BigDecimal.class));
    setNbCongesPayesRestant_C_ERR(pHandler.stringAttribute("NbCongesPayesRestant", "C_ERR"));
    
    setMontantIndemnitePreavis((BigDecimal)pHandler.objectProperty("MontantIndemnitePreavis", BigDecimal.class));
    setMontantIndemnitePreavis_C_ERR(pHandler.stringAttribute("MontantIndemnitePreavis", "C_ERR"));
    
    setNbHeuresDIF((BigDecimal)pHandler.objectProperty("NbHeuresDIF", BigDecimal.class));
    setNbHeuresDIF_C_ERR(pHandler.stringAttribute("NbHeuresDIF", "C_ERR"));
    
    setSalaireHoraireNetSalarie((BigDecimal)pHandler.objectProperty("SalaireHoraireNetSalarie", BigDecimal.class));
    setSalaireHoraireNetSalarie_C_ERR(pHandler.stringAttribute("SalaireHoraireNetSalarie", "C_ERR"));
    
    setIdTechContratRemplace((BigDecimal)pHandler.objectProperty("IdTechContratRemplace", BigDecimal.class));
    setIdTechContratRemplace_C_ERR(pHandler.stringAttribute("IdTechContratRemplace", "C_ERR"));
    
    setNbPAS((BigDecimal)pHandler.objectProperty("NbPAS", BigDecimal.class));
    setNbPAS_C_ERR(pHandler.stringAttribute("NbPAS", "C_ERR"));
    
    setNbSalariesEntreprise((BigDecimal)pHandler.objectProperty("NbSalariesEntreprise", BigDecimal.class));
    setNbSalariesEntreprise_C_ERR(pHandler.stringAttribute("NbSalariesEntreprise", "C_ERR"));
    
    setNbMoisPreavis((BigDecimal)pHandler.objectProperty("NbMoisPreavis", BigDecimal.class));
    setNbMoisPreavis_C_ERR(pHandler.stringAttribute("NbMoisPreavis", "C_ERR"));
    
    setDateDebutPeriodeInactivite((Damj)pHandler.objectProperty("DateDebutPeriodeInactivite", Damj.class));
    setDateDebutPeriodeInactivite_C_ERR(pHandler.stringAttribute("DateDebutPeriodeInactivite", "C_ERR"));
    
    setDateFinPeriodeInactivite((Damj)pHandler.objectProperty("DateFinPeriodeInactivite", Damj.class));
    setDateFinPeriodeInactivite_C_ERR(pHandler.stringAttribute("DateFinPeriodeInactivite", "C_ERR"));
    
    setMotifPeriodeInactivite((String)pHandler.objectProperty("MotifPeriodeInactivite", String.class));
    setMotifPeriodeInactivite_C_ERR(pHandler.stringAttribute("MotifPeriodeInactivite", "C_ERR"));
    
    setDateDebutAGS((Damj)pHandler.objectProperty("DateDebutAGS", Damj.class));
    setDateDebutAGS_C_ERR(pHandler.stringAttribute("DateDebutAGS", "C_ERR"));
    
    setDateFinAGS((Damj)pHandler.objectProperty("DateFinAGS", Damj.class));
    setDateFinAGS_C_ERR(pHandler.stringAttribute("DateFinAGS", "C_ERR"));
    
    setDateDebutAdhesionRevocable((Damj)pHandler.objectProperty("DateDebutAdhesionRevocable", Damj.class));
    setDateDebutAdhesionRevocable_C_ERR(pHandler.stringAttribute("DateDebutAdhesionRevocable", "C_ERR"));
    
    setDateFinAdhesionRevocable((Damj)pHandler.objectProperty("DateFinAdhesionRevocable", Damj.class));
    setDateFinAdhesionRevocable_C_ERR(pHandler.stringAttribute("DateFinAdhesionRevocable", "C_ERR"));
    
    setIdentiteDeclaree((String)pHandler.objectProperty("IdentiteDeclaree", String.class));
    setIdentiteDeclaree_C_ERR(pHandler.stringAttribute("IdentiteDeclaree", "C_ERR"));
    
    setDoute((String)pHandler.objectProperty("Doute", String.class));
    setDoute_C_ERR(pHandler.stringAttribute("Doute", "C_ERR"));
    
    setIdDocumentNumerique((String)pHandler.objectProperty("IdDocumentNumerique", String.class));
    setIdDocumentNumerique_C_ERR(pHandler.stringAttribute("IdDocumentNumerique", "C_ERR"));
    
    setAncienneteMois((BigDecimal)pHandler.objectProperty("AncienneteMois", BigDecimal.class));
    setAncienneteMois_C_ERR(pHandler.stringAttribute("AncienneteMois", "C_ERR"));
    
    setAncienneteAnnee((BigDecimal)pHandler.objectProperty("AncienneteAnnee", BigDecimal.class));
    setAncienneteAnnee_C_ERR(pHandler.stringAttribute("AncienneteAnnee", "C_ERR"));
    
    setMotifRecours((String)pHandler.objectProperty("MotifRecours", String.class));
    setMotifRecours_C_ERR(pHandler.stringAttribute("MotifRecours", "C_ERR"));
  }
  
  public String _getDatabeanName()
  {
    return "FluxAE";
  }
  
  public boolean _isValidProperty(String pElementName)
  {
    if ("ListeFluxFctDnaPreavis".equals(pElementName)) {
      return true;
    }
    if ("ListeFluxFctDnaIndemnitesVersees".equals(pElementName)) {
      return true;
    }
    if ("ListeFluxPasDna".equals(pElementName)) {
      return true;
    }
    if ("CodeMessage".equals(pElementName)) {
      return true;
    }
    if ("CodeAction".equals(pElementName)) {
      return true;
    }
    if ("SIRET".equals(pElementName)) {
      return true;
    }
    if ("ReferenceContrat".equals(pElementName)) {
      return true;
    }
    if ("NatureContrat".equals(pElementName)) {
      return true;
    }
    if ("MotifRupture".equals(pElementName)) {
      return true;
    }
    if ("ClauseNonConcurrence".equals(pElementName)) {
      return true;
    }
    if ("RegimeSpecialSS".equals(pElementName)) {
      return true;
    }
    if ("NumeroAffiRegimeSpecialSS".equals(pElementName)) {
      return true;
    }
    if ("LienParente".equals(pElementName)) {
      return true;
    }
    if ("StatutParticulier".equals(pElementName)) {
      return true;
    }
    if ("NiveauQualif".equals(pElementName)) {
      return true;
    }
    if ("TopTransaction".equals(pElementName)) {
      return true;
    }
    if ("BneIdentifiantBne".equals(pElementName)) {
      return true;
    }
    if ("BneSiret".equals(pElementName)) {
      return true;
    }
    if ("BneRaisonSociale".equals(pElementName)) {
      return true;
    }
    if ("BneCodePostal".equals(pElementName)) {
      return true;
    }
    if ("BneLibelleCommuneCNAVTS".equals(pElementName)) {
      return true;
    }
    if ("BneAssedicAffiliation".equals(pElementName)) {
      return true;
    }
    if ("BneNumAffiliation".equals(pElementName)) {
      return true;
    }
    if ("BneNouveauCodeNAF".equals(pElementName)) {
      return true;
    }
    if ("AbonnementProvisoire".equals(pElementName)) {
      return true;
    }
    if ("CodeRegimeCTP".equals(pElementName)) {
      return true;
    }
    if ("NomEmployeur".equals(pElementName)) {
      return true;
    }
    if ("PrenomEmployeur".equals(pElementName)) {
      return true;
    }
    if ("NumUrssaf".equals(pElementName)) {
      return true;
    }
    if ("NumCESU".equals(pElementName)) {
      return true;
    }
    if ("NumPAJEEMPLOI".equals(pElementName)) {
      return true;
    }
    if ("IdBNIRemplace".equals(pElementName)) {
      return true;
    }
    if ("OrigineAE".equals(pElementName)) {
      return true;
    }
    if ("IndicChomSsRCT".equals(pElementName)) {
      return true;
    }
    if ("RefusAdhesionFNE".equals(pElementName)) {
      return true;
    }
    if ("CodeStatutCadre".equals(pElementName)) {
      return true;
    }
    if ("CocheAlsaceMoselle".equals(pElementName)) {
      return true;
    }
    if ("IndCotisationForfaitReel".equals(pElementName)) {
      return true;
    }
    if ("IndBrutNet".equals(pElementName)) {
      return true;
    }
    if ("CodeCaisseCongesPayes".equals(pElementName)) {
      return true;
    }
    if ("NumCaisseCP".equals(pElementName)) {
      return true;
    }
    if ("CodeARRCO".equals(pElementName)) {
      return true;
    }
    if ("NumBneARRCO".equals(pElementName)) {
      return true;
    }
    if ("SigleARRCO".equals(pElementName)) {
      return true;
    }
    if ("RaisonSocialeARRCO".equals(pElementName)) {
      return true;
    }
    if ("CodeAGIRC".equals(pElementName)) {
      return true;
    }
    if ("NumBneAGIRC".equals(pElementName)) {
      return true;
    }
    if ("SigleAGIRC".equals(pElementName)) {
      return true;
    }
    if ("RaisonSocialeAGIRC".equals(pElementName)) {
      return true;
    }
    if ("TypeContrat".equals(pElementName)) {
      return true;
    }
    if ("CodeRegimeEmployeur".equals(pElementName)) {
      return true;
    }
    if ("NumConventionGestion".equals(pElementName)) {
      return true;
    }
    if ("NomFamille".equals(pElementName)) {
      return true;
    }
    if ("Prenom".equals(pElementName)) {
      return true;
    }
    if ("IndicMontantIndemnite".equals(pElementName)) {
      return true;
    }
    if ("IndicSalaireHoraire".equals(pElementName)) {
      return true;
    }
    if ("FillerUn".equals(pElementName)) {
      return true;
    }
    if ("FillerDeux".equals(pElementName)) {
      return true;
    }
    if ("EmployAutoAssur".equals(pElementName)) {
      return true;
    }
    if ("NumCG".equals(pElementName)) {
      return true;
    }
    if ("EtabFinanc".equals(pElementName)) {
      return true;
    }
    if ("NumInterne".equals(pElementName)) {
      return true;
    }
    if ("CodeAffect".equals(pElementName)) {
      return true;
    }
    if ("StatutSalarie".equals(pElementName)) {
      return true;
    }
    if ("CodeStatutjuridique".equals(pElementName)) {
      return true;
    }
    if ("NomLogiciel".equals(pElementName)) {
      return true;
    }
    if ("VersionLogiciel".equals(pElementName)) {
      return true;
    }
    if ("CategorieJuridiqueEntreprise".equals(pElementName)) {
      return true;
    }
    if ("CodeRegimeEntreprise".equals(pElementName)) {
      return true;
    }
    if ("NatureEntreprise".equals(pElementName)) {
      return true;
    }
    if ("NumGusoEntreprise".equals(pElementName)) {
      return true;
    }
    if ("NumMSAEntreprise".equals(pElementName)) {
      return true;
    }
    if ("EntreprisePublique".equals(pElementName)) {
      return true;
    }
    if ("TrancheEffectifEntreprise".equals(pElementName)) {
      return true;
    }
    if ("DateDebutContrat".equals(pElementName)) {
      return true;
    }
    if ("DateFinContrat".equals(pElementName)) {
      return true;
    }
    if ("DateNotifRupture".equals(pElementName)) {
      return true;
    }
    if ("DateProcedureLicenciement".equals(pElementName)) {
      return true;
    }
    if ("DateDJTP".equals(pElementName)) {
      return true;
    }
    if ("DateInitialeFinContrat".equals(pElementName)) {
      return true;
    }
    if ("DateConnaissanceAE".equals(pElementName)) {
      return true;
    }
    if ("DateReprise".equals(pElementName)) {
      return true;
    }
    if ("DateDebutIndemCP".equals(pElementName)) {
      return true;
    }
    if ("DateFinIndemCP".equals(pElementName)) {
      return true;
    }
    if ("DateEffetCTP".equals(pElementName)) {
      return true;
    }
    if ("DateAdhesion".equals(pElementName)) {
      return true;
    }
    if ("DateCessationActiviteEntreprise".equals(pElementName)) {
      return true;
    }
    if ("DateDebutPeriodeAffiliationEntreprise".equals(pElementName)) {
      return true;
    }
    if ("DateFinPeriodeAffiliationEntreprise".equals(pElementName)) {
      return true;
    }
    if ("DateDebutEffetConGes".equals(pElementName)) {
      return true;
    }
    if ("DateFinEffetConGes".equals(pElementName)) {
      return true;
    }
    if ("NumeroVersion".equals(pElementName)) {
      return true;
    }
    if ("IdTechContratDna".equals(pElementName)) {
      return true;
    }
    if ("NbCongesPayesRestant".equals(pElementName)) {
      return true;
    }
    if ("MontantIndemnitePreavis".equals(pElementName)) {
      return true;
    }
    if ("NbHeuresDIF".equals(pElementName)) {
      return true;
    }
    if ("SalaireHoraireNetSalarie".equals(pElementName)) {
      return true;
    }
    if ("IdTechContratRemplace".equals(pElementName)) {
      return true;
    }
    if ("NbPAS".equals(pElementName)) {
      return true;
    }
    if ("NbSalariesEntreprise".equals(pElementName)) {
      return true;
    }
    if ("NbMoisPreavis".equals(pElementName)) {
      return true;
    }
    if ("DateDebutPeriodeInactivite".equals(pElementName)) {
      return true;
    }
    if ("DateFinPeriodeInactivite".equals(pElementName)) {
      return true;
    }
    if ("MotifPeriodeInactivite".equals(pElementName)) {
      return true;
    }
    if ("DateDebutAGS".equals(pElementName)) {
      return true;
    }
    if ("DateFinAGS".equals(pElementName)) {
      return true;
    }
    if ("DateDebutAdhesionRevocable".equals(pElementName)) {
      return true;
    }
    if ("DateFinAdhesionRevocable".equals(pElementName)) {
      return true;
    }
    if ("IdentiteDeclaree".equals(pElementName)) {
      return true;
    }
    if ("Doute".equals(pElementName)) {
      return true;
    }
    if ("IdDocumentNumerique".equals(pElementName)) {
      return true;
    }
    if ("AncienneteMois".equals(pElementName)) {
      return true;
    }
    if ("AncienneteAnnee".equals(pElementName)) {
      return true;
    }
    if ("MotifRecours".equals(pElementName)) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _FluxAE
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */