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

public class _FluxGUSO
  extends DataBeanImpl
  implements DataBean, Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  private String m__C_ETAT;
  private String m__IDENT;
  private String m_codeMouvement;
  private String m_codeMouvement_C_ERR;
  private String m_prenomEmployeur;
  private String m_prenomEmployeur_C_ERR;
  private String m_numeroGuso;
  private String m_numeroGuso_C_ERR;
  private String m_codeNAF;
  private String m_codeNAF_C_ERR;
  private String m_identifiantBNI;
  private String m_identifiantBNI_C_ERR;
  private String m_nom;
  private String m_nom_C_ERR;
  private String m_prenom;
  private String m_prenom_C_ERR;
  private String m_nIRIntermittent;
  private String m_nIRIntermittent_C_ERR;
  private String m_emploiOccupe;
  private String m_emploiOccupe_C_ERR;
  private String m_idPrestation;
  private String m_idPrestation_C_ERR;
  private String m_natureActivite;
  private String m_natureActivite_C_ERR;
  private String m_motifFCT;
  private String m_motifFCT_C_ERR;
  private String m_codeDevise;
  private String m_codeDevise_C_ERR;
  private String m_identifiantBNE;
  private String m_identifiantBNE_C_ERR;
  private String m_siretBNE;
  private String m_siretBNE_C_ERR;
  private String m_raisonSocialeBNE;
  private String m_raisonSocialeBNE_C_ERR;
  private String m_numeroRueBNE;
  private String m_numeroRueBNE_C_ERR;
  private String m_adresse1BNE;
  private String m_adresse1BNE_C_ERR;
  private String m_adresse2BNE;
  private String m_adresse2BNE_C_ERR;
  private String m_codePostalBNE;
  private String m_codePostalBNE_C_ERR;
  private String m_libelleCommuneBNE;
  private String m_libelleCommuneBNE_C_ERR;
  private String m_assedicAffiliationBNE;
  private String m_assedicAffiliationBNE_C_ERR;
  private String m_numeroAffiliationBNE;
  private String m_numeroAffiliationBNE_C_ERR;
  private String m_nouveauCodeNAF;
  private String m_nouveauCodeNAF_C_ERR;
  private String m_raisonSocialeEmployeur;
  private String m_raisonSocialeEmployeur_C_ERR;
  private String m_numeroTelephone;
  private String m_numeroTelephone_C_ERR;
  private String m_numeroFax;
  private String m_numeroFax_C_ERR;
  private String m_premiereLigneAdresseEmployeurCourrier;
  private String m_premiereLigneAdresseEmployeurCourrier_C_ERR;
  private String m_deuxiemeLigneAdresseEmployeurCourrier;
  private String m_deuxiemeLigneAdresseEmployeurCourrier_C_ERR;
  private String m_troisiemeLigneAdresseEmployeurCourrier;
  private String m_troisiemeLigneAdresseEmployeurCourrier_C_ERR;
  private String m_quatriemeLigneAdresseEmployeurCourrier;
  private String m_quatriemeLigneAdresseEmployeurCourrier_C_ERR;
  private String m_siret;
  private String m_siret_C_ERR;
  private String m_formeJuridique;
  private String m_formeJuridique_C_ERR;
  private String m_pseudo;
  private String m_pseudo_C_ERR;
  private String m_premiereLigneAdresseIntermittentCourrier;
  private String m_premiereLigneAdresseIntermittentCourrier_C_ERR;
  private String m_deuxiemeLigneAdresseIntermittentCourrier;
  private String m_deuxiemeLigneAdresseIntermittentCourrier_C_ERR;
  private String m_troisiemeLigneAdresseIntermittentCourrier;
  private String m_troisiemeLigneAdresseIntermittentCourrier_C_ERR;
  private String m_quatriemeLigneAdresseIntermittentCourrier;
  private String m_quatriemeLigneAdresseIntermittentCourrier_C_ERR;
  private String m_positionEmployeur;
  private String m_positionEmployeur_C_ERR;
  private String m_positionAutreEmployeur;
  private String m_positionAutreEmployeur_C_ERR;
  private String m_codeAssedic;
  private String m_codeAssedic_C_ERR;
  private String m_rsin;
  private String m_rsin_C_ERR;
  private String m_codeNAFBNE;
  private String m_codeNAFBNE_C_ERR;
  private String m_codeEmploiOccupe;
  private String m_codeEmploiOccupe_C_ERR;
  private String m_numeroObjet;
  private String m_numeroObjet_C_ERR;
  private String m_cadre;
  private String m_cadre_C_ERR;
  private String m_forfaitUrssaf;
  private String m_forfaitUrssaf_C_ERR;
  private String m_topAlsaceMoselle;
  private String m_topAlsaceMoselle_C_ERR;
  private Damj m_dateDebutContrat;
  private String m_dateDebutContrat_C_ERR;
  private Damj m_dateFinContrat;
  private String m_dateFinContrat_C_ERR;
  private Damj m_dateCreation;
  private String m_dateCreation_C_ERR;
  private Damj m_dateOrigineInformation;
  private String m_dateOrigineInformation_C_ERR;
  private Damj m_dateCreationFeuillet;
  private String m_dateCreationFeuillet_C_ERR;
  private BigDecimal m_nbJoursTravailles;
  private String m_nbJoursTravailles_C_ERR;
  private BigDecimal m_nbHeuresTravaillees;
  private String m_nbHeuresTravaillees_C_ERR;
  private BigDecimal m_nbCachets;
  private String m_nbCachets_C_ERR;
  private BigDecimal m_salaireBrutNonAbattu;
  private String m_salaireBrutNonAbattu_C_ERR;
  private BigDecimal m_salaireBrutAbattu;
  private String m_salaireBrutAbattu_C_ERR;
  private BigDecimal m_numeroChrono;
  private String m_numeroChrono_C_ERR;
  private BigDecimal m_montantIccp;
  private String m_montantIccp_C_ERR;
  private BigDecimal m_montantAvantageNature;
  private String m_montantAvantageNature_C_ERR;
  private BigDecimal m_montantFraisProfessionnel;
  private String m_montantFraisProfessionnel_C_ERR;
  private BigDecimal m_tauxAbattement;
  private String m_tauxAbattement_C_ERR;
  
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
  
  public String getCodeMouvement()
  {
    return m_codeMouvement;
  }
  
  public String getCodeMouvement_C_ERR()
  {
    return m_codeMouvement_C_ERR;
  }
  
  public void setCodeMouvement(String pValeur)
  {
    m_codeMouvement = pValeur;
  }
  
  public void setCodeMouvement_C_ERR(String pValeur_C_ERR)
  {
    m_codeMouvement_C_ERR = pValeur_C_ERR;
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
  
  public String getNumeroGuso()
  {
    return m_numeroGuso;
  }
  
  public String getNumeroGuso_C_ERR()
  {
    return m_numeroGuso_C_ERR;
  }
  
  public void setNumeroGuso(String pValeur)
  {
    m_numeroGuso = pValeur;
  }
  
  public void setNumeroGuso_C_ERR(String pValeur_C_ERR)
  {
    m_numeroGuso_C_ERR = pValeur_C_ERR;
  }
  
  public String getCodeNAF()
  {
    return m_codeNAF;
  }
  
  public String getCodeNAF_C_ERR()
  {
    return m_codeNAF_C_ERR;
  }
  
  public void setCodeNAF(String pValeur)
  {
    m_codeNAF = pValeur;
  }
  
  public void setCodeNAF_C_ERR(String pValeur_C_ERR)
  {
    m_codeNAF_C_ERR = pValeur_C_ERR;
  }
  
  public String getIdentifiantBNI()
  {
    return m_identifiantBNI;
  }
  
  public String getIdentifiantBNI_C_ERR()
  {
    return m_identifiantBNI_C_ERR;
  }
  
  public void setIdentifiantBNI(String pValeur)
  {
    m_identifiantBNI = pValeur;
  }
  
  public void setIdentifiantBNI_C_ERR(String pValeur_C_ERR)
  {
    m_identifiantBNI_C_ERR = pValeur_C_ERR;
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
  
  public String getNIRIntermittent()
  {
    return m_nIRIntermittent;
  }
  
  public String getNIRIntermittent_C_ERR()
  {
    return m_nIRIntermittent_C_ERR;
  }
  
  public void setNIRIntermittent(String pValeur)
  {
    m_nIRIntermittent = pValeur;
  }
  
  public void setNIRIntermittent_C_ERR(String pValeur_C_ERR)
  {
    m_nIRIntermittent_C_ERR = pValeur_C_ERR;
  }
  
  public String getEmploiOccupe()
  {
    return m_emploiOccupe;
  }
  
  public String getEmploiOccupe_C_ERR()
  {
    return m_emploiOccupe_C_ERR;
  }
  
  public void setEmploiOccupe(String pValeur)
  {
    m_emploiOccupe = pValeur;
  }
  
  public void setEmploiOccupe_C_ERR(String pValeur_C_ERR)
  {
    m_emploiOccupe_C_ERR = pValeur_C_ERR;
  }
  
  public String getIdPrestation()
  {
    return m_idPrestation;
  }
  
  public String getIdPrestation_C_ERR()
  {
    return m_idPrestation_C_ERR;
  }
  
  public void setIdPrestation(String pValeur)
  {
    m_idPrestation = pValeur;
  }
  
  public void setIdPrestation_C_ERR(String pValeur_C_ERR)
  {
    m_idPrestation_C_ERR = pValeur_C_ERR;
  }
  
  public String getNatureActivite()
  {
    return m_natureActivite;
  }
  
  public String getNatureActivite_C_ERR()
  {
    return m_natureActivite_C_ERR;
  }
  
  public void setNatureActivite(String pValeur)
  {
    m_natureActivite = pValeur;
  }
  
  public void setNatureActivite_C_ERR(String pValeur_C_ERR)
  {
    m_natureActivite_C_ERR = pValeur_C_ERR;
  }
  
  public String getMotifFCT()
  {
    return m_motifFCT;
  }
  
  public String getMotifFCT_C_ERR()
  {
    return m_motifFCT_C_ERR;
  }
  
  public void setMotifFCT(String pValeur)
  {
    m_motifFCT = pValeur;
  }
  
  public void setMotifFCT_C_ERR(String pValeur_C_ERR)
  {
    m_motifFCT_C_ERR = pValeur_C_ERR;
  }
  
  public String getCodeDevise()
  {
    return m_codeDevise;
  }
  
  public String getCodeDevise_C_ERR()
  {
    return m_codeDevise_C_ERR;
  }
  
  public void setCodeDevise(String pValeur)
  {
    m_codeDevise = pValeur;
  }
  
  public void setCodeDevise_C_ERR(String pValeur_C_ERR)
  {
    m_codeDevise_C_ERR = pValeur_C_ERR;
  }
  
  public String getIdentifiantBNE()
  {
    return m_identifiantBNE;
  }
  
  public String getIdentifiantBNE_C_ERR()
  {
    return m_identifiantBNE_C_ERR;
  }
  
  public void setIdentifiantBNE(String pValeur)
  {
    m_identifiantBNE = pValeur;
  }
  
  public void setIdentifiantBNE_C_ERR(String pValeur_C_ERR)
  {
    m_identifiantBNE_C_ERR = pValeur_C_ERR;
  }
  
  public String getSiretBNE()
  {
    return m_siretBNE;
  }
  
  public String getSiretBNE_C_ERR()
  {
    return m_siretBNE_C_ERR;
  }
  
  public void setSiretBNE(String pValeur)
  {
    m_siretBNE = pValeur;
  }
  
  public void setSiretBNE_C_ERR(String pValeur_C_ERR)
  {
    m_siretBNE_C_ERR = pValeur_C_ERR;
  }
  
  public String getRaisonSocialeBNE()
  {
    return m_raisonSocialeBNE;
  }
  
  public String getRaisonSocialeBNE_C_ERR()
  {
    return m_raisonSocialeBNE_C_ERR;
  }
  
  public void setRaisonSocialeBNE(String pValeur)
  {
    m_raisonSocialeBNE = pValeur;
  }
  
  public void setRaisonSocialeBNE_C_ERR(String pValeur_C_ERR)
  {
    m_raisonSocialeBNE_C_ERR = pValeur_C_ERR;
  }
  
  public String getNumeroRueBNE()
  {
    return m_numeroRueBNE;
  }
  
  public String getNumeroRueBNE_C_ERR()
  {
    return m_numeroRueBNE_C_ERR;
  }
  
  public void setNumeroRueBNE(String pValeur)
  {
    m_numeroRueBNE = pValeur;
  }
  
  public void setNumeroRueBNE_C_ERR(String pValeur_C_ERR)
  {
    m_numeroRueBNE_C_ERR = pValeur_C_ERR;
  }
  
  public String getAdresse1BNE()
  {
    return m_adresse1BNE;
  }
  
  public String getAdresse1BNE_C_ERR()
  {
    return m_adresse1BNE_C_ERR;
  }
  
  public void setAdresse1BNE(String pValeur)
  {
    m_adresse1BNE = pValeur;
  }
  
  public void setAdresse1BNE_C_ERR(String pValeur_C_ERR)
  {
    m_adresse1BNE_C_ERR = pValeur_C_ERR;
  }
  
  public String getAdresse2BNE()
  {
    return m_adresse2BNE;
  }
  
  public String getAdresse2BNE_C_ERR()
  {
    return m_adresse2BNE_C_ERR;
  }
  
  public void setAdresse2BNE(String pValeur)
  {
    m_adresse2BNE = pValeur;
  }
  
  public void setAdresse2BNE_C_ERR(String pValeur_C_ERR)
  {
    m_adresse2BNE_C_ERR = pValeur_C_ERR;
  }
  
  public String getCodePostalBNE()
  {
    return m_codePostalBNE;
  }
  
  public String getCodePostalBNE_C_ERR()
  {
    return m_codePostalBNE_C_ERR;
  }
  
  public void setCodePostalBNE(String pValeur)
  {
    m_codePostalBNE = pValeur;
  }
  
  public void setCodePostalBNE_C_ERR(String pValeur_C_ERR)
  {
    m_codePostalBNE_C_ERR = pValeur_C_ERR;
  }
  
  public String getLibelleCommuneBNE()
  {
    return m_libelleCommuneBNE;
  }
  
  public String getLibelleCommuneBNE_C_ERR()
  {
    return m_libelleCommuneBNE_C_ERR;
  }
  
  public void setLibelleCommuneBNE(String pValeur)
  {
    m_libelleCommuneBNE = pValeur;
  }
  
  public void setLibelleCommuneBNE_C_ERR(String pValeur_C_ERR)
  {
    m_libelleCommuneBNE_C_ERR = pValeur_C_ERR;
  }
  
  public String getAssedicAffiliationBNE()
  {
    return m_assedicAffiliationBNE;
  }
  
  public String getAssedicAffiliationBNE_C_ERR()
  {
    return m_assedicAffiliationBNE_C_ERR;
  }
  
  public void setAssedicAffiliationBNE(String pValeur)
  {
    m_assedicAffiliationBNE = pValeur;
  }
  
  public void setAssedicAffiliationBNE_C_ERR(String pValeur_C_ERR)
  {
    m_assedicAffiliationBNE_C_ERR = pValeur_C_ERR;
  }
  
  public String getNumeroAffiliationBNE()
  {
    return m_numeroAffiliationBNE;
  }
  
  public String getNumeroAffiliationBNE_C_ERR()
  {
    return m_numeroAffiliationBNE_C_ERR;
  }
  
  public void setNumeroAffiliationBNE(String pValeur)
  {
    m_numeroAffiliationBNE = pValeur;
  }
  
  public void setNumeroAffiliationBNE_C_ERR(String pValeur_C_ERR)
  {
    m_numeroAffiliationBNE_C_ERR = pValeur_C_ERR;
  }
  
  public String getNouveauCodeNAF()
  {
    return m_nouveauCodeNAF;
  }
  
  public String getNouveauCodeNAF_C_ERR()
  {
    return m_nouveauCodeNAF_C_ERR;
  }
  
  public void setNouveauCodeNAF(String pValeur)
  {
    m_nouveauCodeNAF = pValeur;
  }
  
  public void setNouveauCodeNAF_C_ERR(String pValeur_C_ERR)
  {
    m_nouveauCodeNAF_C_ERR = pValeur_C_ERR;
  }
  
  public String getRaisonSocialeEmployeur()
  {
    return m_raisonSocialeEmployeur;
  }
  
  public String getRaisonSocialeEmployeur_C_ERR()
  {
    return m_raisonSocialeEmployeur_C_ERR;
  }
  
  public void setRaisonSocialeEmployeur(String pValeur)
  {
    m_raisonSocialeEmployeur = pValeur;
  }
  
  public void setRaisonSocialeEmployeur_C_ERR(String pValeur_C_ERR)
  {
    m_raisonSocialeEmployeur_C_ERR = pValeur_C_ERR;
  }
  
  public String getNumeroTelephone()
  {
    return m_numeroTelephone;
  }
  
  public String getNumeroTelephone_C_ERR()
  {
    return m_numeroTelephone_C_ERR;
  }
  
  public void setNumeroTelephone(String pValeur)
  {
    m_numeroTelephone = pValeur;
  }
  
  public void setNumeroTelephone_C_ERR(String pValeur_C_ERR)
  {
    m_numeroTelephone_C_ERR = pValeur_C_ERR;
  }
  
  public String getNumeroFax()
  {
    return m_numeroFax;
  }
  
  public String getNumeroFax_C_ERR()
  {
    return m_numeroFax_C_ERR;
  }
  
  public void setNumeroFax(String pValeur)
  {
    m_numeroFax = pValeur;
  }
  
  public void setNumeroFax_C_ERR(String pValeur_C_ERR)
  {
    m_numeroFax_C_ERR = pValeur_C_ERR;
  }
  
  public String getPremiereLigneAdresseEmployeurCourrier()
  {
    return m_premiereLigneAdresseEmployeurCourrier;
  }
  
  public String getPremiereLigneAdresseEmployeurCourrier_C_ERR()
  {
    return m_premiereLigneAdresseEmployeurCourrier_C_ERR;
  }
  
  public void setPremiereLigneAdresseEmployeurCourrier(String pValeur)
  {
    m_premiereLigneAdresseEmployeurCourrier = pValeur;
  }
  
  public void setPremiereLigneAdresseEmployeurCourrier_C_ERR(String pValeur_C_ERR)
  {
    m_premiereLigneAdresseEmployeurCourrier_C_ERR = pValeur_C_ERR;
  }
  
  public String getDeuxiemeLigneAdresseEmployeurCourrier()
  {
    return m_deuxiemeLigneAdresseEmployeurCourrier;
  }
  
  public String getDeuxiemeLigneAdresseEmployeurCourrier_C_ERR()
  {
    return m_deuxiemeLigneAdresseEmployeurCourrier_C_ERR;
  }
  
  public void setDeuxiemeLigneAdresseEmployeurCourrier(String pValeur)
  {
    m_deuxiemeLigneAdresseEmployeurCourrier = pValeur;
  }
  
  public void setDeuxiemeLigneAdresseEmployeurCourrier_C_ERR(String pValeur_C_ERR)
  {
    m_deuxiemeLigneAdresseEmployeurCourrier_C_ERR = pValeur_C_ERR;
  }
  
  public String getTroisiemeLigneAdresseEmployeurCourrier()
  {
    return m_troisiemeLigneAdresseEmployeurCourrier;
  }
  
  public String getTroisiemeLigneAdresseEmployeurCourrier_C_ERR()
  {
    return m_troisiemeLigneAdresseEmployeurCourrier_C_ERR;
  }
  
  public void setTroisiemeLigneAdresseEmployeurCourrier(String pValeur)
  {
    m_troisiemeLigneAdresseEmployeurCourrier = pValeur;
  }
  
  public void setTroisiemeLigneAdresseEmployeurCourrier_C_ERR(String pValeur_C_ERR)
  {
    m_troisiemeLigneAdresseEmployeurCourrier_C_ERR = pValeur_C_ERR;
  }
  
  public String getQuatriemeLigneAdresseEmployeurCourrier()
  {
    return m_quatriemeLigneAdresseEmployeurCourrier;
  }
  
  public String getQuatriemeLigneAdresseEmployeurCourrier_C_ERR()
  {
    return m_quatriemeLigneAdresseEmployeurCourrier_C_ERR;
  }
  
  public void setQuatriemeLigneAdresseEmployeurCourrier(String pValeur)
  {
    m_quatriemeLigneAdresseEmployeurCourrier = pValeur;
  }
  
  public void setQuatriemeLigneAdresseEmployeurCourrier_C_ERR(String pValeur_C_ERR)
  {
    m_quatriemeLigneAdresseEmployeurCourrier_C_ERR = pValeur_C_ERR;
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
  
  public String getFormeJuridique()
  {
    return m_formeJuridique;
  }
  
  public String getFormeJuridique_C_ERR()
  {
    return m_formeJuridique_C_ERR;
  }
  
  public void setFormeJuridique(String pValeur)
  {
    m_formeJuridique = pValeur;
  }
  
  public void setFormeJuridique_C_ERR(String pValeur_C_ERR)
  {
    m_formeJuridique_C_ERR = pValeur_C_ERR;
  }
  
  public String getPseudo()
  {
    return m_pseudo;
  }
  
  public String getPseudo_C_ERR()
  {
    return m_pseudo_C_ERR;
  }
  
  public void setPseudo(String pValeur)
  {
    m_pseudo = pValeur;
  }
  
  public void setPseudo_C_ERR(String pValeur_C_ERR)
  {
    m_pseudo_C_ERR = pValeur_C_ERR;
  }
  
  public String getPremiereLigneAdresseIntermittentCourrier()
  {
    return m_premiereLigneAdresseIntermittentCourrier;
  }
  
  public String getPremiereLigneAdresseIntermittentCourrier_C_ERR()
  {
    return m_premiereLigneAdresseIntermittentCourrier_C_ERR;
  }
  
  public void setPremiereLigneAdresseIntermittentCourrier(String pValeur)
  {
    m_premiereLigneAdresseIntermittentCourrier = pValeur;
  }
  
  public void setPremiereLigneAdresseIntermittentCourrier_C_ERR(String pValeur_C_ERR)
  {
    m_premiereLigneAdresseIntermittentCourrier_C_ERR = pValeur_C_ERR;
  }
  
  public String getDeuxiemeLigneAdresseIntermittentCourrier()
  {
    return m_deuxiemeLigneAdresseIntermittentCourrier;
  }
  
  public String getDeuxiemeLigneAdresseIntermittentCourrier_C_ERR()
  {
    return m_deuxiemeLigneAdresseIntermittentCourrier_C_ERR;
  }
  
  public void setDeuxiemeLigneAdresseIntermittentCourrier(String pValeur)
  {
    m_deuxiemeLigneAdresseIntermittentCourrier = pValeur;
  }
  
  public void setDeuxiemeLigneAdresseIntermittentCourrier_C_ERR(String pValeur_C_ERR)
  {
    m_deuxiemeLigneAdresseIntermittentCourrier_C_ERR = pValeur_C_ERR;
  }
  
  public String getTroisiemeLigneAdresseIntermittentCourrier()
  {
    return m_troisiemeLigneAdresseIntermittentCourrier;
  }
  
  public String getTroisiemeLigneAdresseIntermittentCourrier_C_ERR()
  {
    return m_troisiemeLigneAdresseIntermittentCourrier_C_ERR;
  }
  
  public void setTroisiemeLigneAdresseIntermittentCourrier(String pValeur)
  {
    m_troisiemeLigneAdresseIntermittentCourrier = pValeur;
  }
  
  public void setTroisiemeLigneAdresseIntermittentCourrier_C_ERR(String pValeur_C_ERR)
  {
    m_troisiemeLigneAdresseIntermittentCourrier_C_ERR = pValeur_C_ERR;
  }
  
  public String getQuatriemeLigneAdresseIntermittentCourrier()
  {
    return m_quatriemeLigneAdresseIntermittentCourrier;
  }
  
  public String getQuatriemeLigneAdresseIntermittentCourrier_C_ERR()
  {
    return m_quatriemeLigneAdresseIntermittentCourrier_C_ERR;
  }
  
  public void setQuatriemeLigneAdresseIntermittentCourrier(String pValeur)
  {
    m_quatriemeLigneAdresseIntermittentCourrier = pValeur;
  }
  
  public void setQuatriemeLigneAdresseIntermittentCourrier_C_ERR(String pValeur_C_ERR)
  {
    m_quatriemeLigneAdresseIntermittentCourrier_C_ERR = pValeur_C_ERR;
  }
  
  public String getPositionEmployeur()
  {
    return m_positionEmployeur;
  }
  
  public String getPositionEmployeur_C_ERR()
  {
    return m_positionEmployeur_C_ERR;
  }
  
  public void setPositionEmployeur(String pValeur)
  {
    m_positionEmployeur = pValeur;
  }
  
  public void setPositionEmployeur_C_ERR(String pValeur_C_ERR)
  {
    m_positionEmployeur_C_ERR = pValeur_C_ERR;
  }
  
  public String getPositionAutreEmployeur()
  {
    return m_positionAutreEmployeur;
  }
  
  public String getPositionAutreEmployeur_C_ERR()
  {
    return m_positionAutreEmployeur_C_ERR;
  }
  
  public void setPositionAutreEmployeur(String pValeur)
  {
    m_positionAutreEmployeur = pValeur;
  }
  
  public void setPositionAutreEmployeur_C_ERR(String pValeur_C_ERR)
  {
    m_positionAutreEmployeur_C_ERR = pValeur_C_ERR;
  }
  
  public String getCodeAssedic()
  {
    return m_codeAssedic;
  }
  
  public String getCodeAssedic_C_ERR()
  {
    return m_codeAssedic_C_ERR;
  }
  
  public void setCodeAssedic(String pValeur)
  {
    m_codeAssedic = pValeur;
  }
  
  public void setCodeAssedic_C_ERR(String pValeur_C_ERR)
  {
    m_codeAssedic_C_ERR = pValeur_C_ERR;
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
  
  public String getCodeNAFBNE()
  {
    return m_codeNAFBNE;
  }
  
  public String getCodeNAFBNE_C_ERR()
  {
    return m_codeNAFBNE_C_ERR;
  }
  
  public void setCodeNAFBNE(String pValeur)
  {
    m_codeNAFBNE = pValeur;
  }
  
  public void setCodeNAFBNE_C_ERR(String pValeur_C_ERR)
  {
    m_codeNAFBNE_C_ERR = pValeur_C_ERR;
  }
  
  public String getCodeEmploiOccupe()
  {
    return m_codeEmploiOccupe;
  }
  
  public String getCodeEmploiOccupe_C_ERR()
  {
    return m_codeEmploiOccupe_C_ERR;
  }
  
  public void setCodeEmploiOccupe(String pValeur)
  {
    m_codeEmploiOccupe = pValeur;
  }
  
  public void setCodeEmploiOccupe_C_ERR(String pValeur_C_ERR)
  {
    m_codeEmploiOccupe_C_ERR = pValeur_C_ERR;
  }
  
  public String getNumeroObjet()
  {
    return m_numeroObjet;
  }
  
  public String getNumeroObjet_C_ERR()
  {
    return m_numeroObjet_C_ERR;
  }
  
  public void setNumeroObjet(String pValeur)
  {
    m_numeroObjet = pValeur;
  }
  
  public void setNumeroObjet_C_ERR(String pValeur_C_ERR)
  {
    m_numeroObjet_C_ERR = pValeur_C_ERR;
  }
  
  public String getCadre()
  {
    return m_cadre;
  }
  
  public String getCadre_C_ERR()
  {
    return m_cadre_C_ERR;
  }
  
  public void setCadre(String pValeur)
  {
    m_cadre = pValeur;
  }
  
  public void setCadre_C_ERR(String pValeur_C_ERR)
  {
    m_cadre_C_ERR = pValeur_C_ERR;
  }
  
  public String getForfaitUrssaf()
  {
    return m_forfaitUrssaf;
  }
  
  public String getForfaitUrssaf_C_ERR()
  {
    return m_forfaitUrssaf_C_ERR;
  }
  
  public void setForfaitUrssaf(String pValeur)
  {
    m_forfaitUrssaf = pValeur;
  }
  
  public void setForfaitUrssaf_C_ERR(String pValeur_C_ERR)
  {
    m_forfaitUrssaf_C_ERR = pValeur_C_ERR;
  }
  
  public String getTopAlsaceMoselle()
  {
    return m_topAlsaceMoselle;
  }
  
  public String getTopAlsaceMoselle_C_ERR()
  {
    return m_topAlsaceMoselle_C_ERR;
  }
  
  public void setTopAlsaceMoselle(String pValeur)
  {
    m_topAlsaceMoselle = pValeur;
  }
  
  public void setTopAlsaceMoselle_C_ERR(String pValeur_C_ERR)
  {
    m_topAlsaceMoselle_C_ERR = pValeur_C_ERR;
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
  
  public Damj getDateCreation()
  {
    return m_dateCreation;
  }
  
  public String getDateCreation_C_ERR()
  {
    return m_dateCreation_C_ERR;
  }
  
  public void setDateCreation(Damj pValeur)
  {
    m_dateCreation = pValeur;
  }
  
  public void setDateCreation_C_ERR(String pValeur_C_ERR)
  {
    m_dateCreation_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDateOrigineInformation()
  {
    return m_dateOrigineInformation;
  }
  
  public String getDateOrigineInformation_C_ERR()
  {
    return m_dateOrigineInformation_C_ERR;
  }
  
  public void setDateOrigineInformation(Damj pValeur)
  {
    m_dateOrigineInformation = pValeur;
  }
  
  public void setDateOrigineInformation_C_ERR(String pValeur_C_ERR)
  {
    m_dateOrigineInformation_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDateCreationFeuillet()
  {
    return m_dateCreationFeuillet;
  }
  
  public String getDateCreationFeuillet_C_ERR()
  {
    return m_dateCreationFeuillet_C_ERR;
  }
  
  public void setDateCreationFeuillet(Damj pValeur)
  {
    m_dateCreationFeuillet = pValeur;
  }
  
  public void setDateCreationFeuillet_C_ERR(String pValeur_C_ERR)
  {
    m_dateCreationFeuillet_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getNbJoursTravailles()
  {
    return m_nbJoursTravailles;
  }
  
  public String getNbJoursTravailles_C_ERR()
  {
    return m_nbJoursTravailles_C_ERR;
  }
  
  public void setNbJoursTravailles(BigDecimal pValeur)
  {
    m_nbJoursTravailles = pValeur;
  }
  
  public void setNbJoursTravailles_C_ERR(String pValeur_C_ERR)
  {
    m_nbJoursTravailles_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getNbHeuresTravaillees()
  {
    return m_nbHeuresTravaillees;
  }
  
  public String getNbHeuresTravaillees_C_ERR()
  {
    return m_nbHeuresTravaillees_C_ERR;
  }
  
  public void setNbHeuresTravaillees(BigDecimal pValeur)
  {
    m_nbHeuresTravaillees = pValeur;
  }
  
  public void setNbHeuresTravaillees_C_ERR(String pValeur_C_ERR)
  {
    m_nbHeuresTravaillees_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getNbCachets()
  {
    return m_nbCachets;
  }
  
  public String getNbCachets_C_ERR()
  {
    return m_nbCachets_C_ERR;
  }
  
  public void setNbCachets(BigDecimal pValeur)
  {
    m_nbCachets = pValeur;
  }
  
  public void setNbCachets_C_ERR(String pValeur_C_ERR)
  {
    m_nbCachets_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getSalaireBrutNonAbattu()
  {
    return m_salaireBrutNonAbattu;
  }
  
  public String getSalaireBrutNonAbattu_C_ERR()
  {
    return m_salaireBrutNonAbattu_C_ERR;
  }
  
  public void setSalaireBrutNonAbattu(BigDecimal pValeur)
  {
    m_salaireBrutNonAbattu = pValeur;
  }
  
  public void setSalaireBrutNonAbattu_C_ERR(String pValeur_C_ERR)
  {
    m_salaireBrutNonAbattu_C_ERR = pValeur_C_ERR;
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
  
  public BigDecimal getNumeroChrono()
  {
    return m_numeroChrono;
  }
  
  public String getNumeroChrono_C_ERR()
  {
    return m_numeroChrono_C_ERR;
  }
  
  public void setNumeroChrono(BigDecimal pValeur)
  {
    m_numeroChrono = pValeur;
  }
  
  public void setNumeroChrono_C_ERR(String pValeur_C_ERR)
  {
    m_numeroChrono_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getMontantIccp()
  {
    return m_montantIccp;
  }
  
  public String getMontantIccp_C_ERR()
  {
    return m_montantIccp_C_ERR;
  }
  
  public void setMontantIccp(BigDecimal pValeur)
  {
    m_montantIccp = pValeur;
  }
  
  public void setMontantIccp_C_ERR(String pValeur_C_ERR)
  {
    m_montantIccp_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getMontantAvantageNature()
  {
    return m_montantAvantageNature;
  }
  
  public String getMontantAvantageNature_C_ERR()
  {
    return m_montantAvantageNature_C_ERR;
  }
  
  public void setMontantAvantageNature(BigDecimal pValeur)
  {
    m_montantAvantageNature = pValeur;
  }
  
  public void setMontantAvantageNature_C_ERR(String pValeur_C_ERR)
  {
    m_montantAvantageNature_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getMontantFraisProfessionnel()
  {
    return m_montantFraisProfessionnel;
  }
  
  public String getMontantFraisProfessionnel_C_ERR()
  {
    return m_montantFraisProfessionnel_C_ERR;
  }
  
  public void setMontantFraisProfessionnel(BigDecimal pValeur)
  {
    m_montantFraisProfessionnel = pValeur;
  }
  
  public void setMontantFraisProfessionnel_C_ERR(String pValeur_C_ERR)
  {
    m_montantFraisProfessionnel_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getTauxAbattement()
  {
    return m_tauxAbattement;
  }
  
  public String getTauxAbattement_C_ERR()
  {
    return m_tauxAbattement_C_ERR;
  }
  
  public void setTauxAbattement(BigDecimal pValeur)
  {
    m_tauxAbattement = pValeur;
  }
  
  public void setTauxAbattement_C_ERR(String pValeur_C_ERR)
  {
    m_tauxAbattement_C_ERR = pValeur_C_ERR;
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
    if ("m_codeMouvement_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_prenomEmployeur_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_numeroGuso_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_codeNAF_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_identifiantBNI_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_nom_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_prenom_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_nIRIntermittent_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_emploiOccupe_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_idPrestation_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_natureActivite_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_motifFCT_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_codeDevise_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_identifiantBNE_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_siretBNE_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_raisonSocialeBNE_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_numeroRueBNE_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_adresse1BNE_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_adresse2BNE_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_codePostalBNE_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_libelleCommuneBNE_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_assedicAffiliationBNE_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_numeroAffiliationBNE_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_nouveauCodeNAF_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_raisonSocialeEmployeur_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_numeroTelephone_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_numeroFax_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_premiereLigneAdresseEmployeurCourrier_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_deuxiemeLigneAdresseEmployeurCourrier_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_troisiemeLigneAdresseEmployeurCourrier_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_quatriemeLigneAdresseEmployeurCourrier_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_siret_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_formeJuridique_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_pseudo_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_premiereLigneAdresseIntermittentCourrier_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_deuxiemeLigneAdresseIntermittentCourrier_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_troisiemeLigneAdresseIntermittentCourrier_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_quatriemeLigneAdresseIntermittentCourrier_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_positionEmployeur_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_positionAutreEmployeur_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_codeAssedic_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_rsin_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_codeNAFBNE_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_codeEmploiOccupe_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_numeroObjet_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_cadre_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_forfaitUrssaf_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_topAlsaceMoselle_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateDebutContrat_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateFinContrat_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateCreation_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateOrigineInformation_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateCreationFeuillet_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_nbJoursTravailles_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_nbHeuresTravaillees_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_nbCachets_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_salaireBrutNonAbattu_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_salaireBrutAbattu_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_numeroChrono_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_montantIccp_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_montantAvantageNature_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_montantFraisProfessionnel_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_tauxAbattement_C_ERR".equals(attrName)) {
      return String.class;
    }
    return null;
  }
  
  public PropertyInfo _getPropertyInfo(String pElementName)
    throws TechniqueException
  {
    if ("CodeMouvement".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("PrenomEmployeur".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("NumeroGuso".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("CodeNAF".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("IdentifiantBNI".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("Nom".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("Prenom".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("NIRIntermittent".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("EmploiOccupe".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("IdPrestation".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("NatureActivite".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("MotifFCT".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("CodeDevise".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("IdentifiantBNE".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("SiretBNE".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("RaisonSocialeBNE".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("NumeroRueBNE".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("Adresse1BNE".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("Adresse2BNE".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("CodePostalBNE".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("LibelleCommuneBNE".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("AssedicAffiliationBNE".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("NumeroAffiliationBNE".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("NouveauCodeNAF".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("RaisonSocialeEmployeur".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("NumeroTelephone".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("NumeroFax".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("PremiereLigneAdresseEmployeurCourrier".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("DeuxiemeLigneAdresseEmployeurCourrier".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("TroisiemeLigneAdresseEmployeurCourrier".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("QuatriemeLigneAdresseEmployeurCourrier".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("Siret".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("FormeJuridique".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("Pseudo".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("PremiereLigneAdresseIntermittentCourrier".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("DeuxiemeLigneAdresseIntermittentCourrier".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("TroisiemeLigneAdresseIntermittentCourrier".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("QuatriemeLigneAdresseIntermittentCourrier".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("PositionEmployeur".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("PositionAutreEmployeur".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("CodeAssedic".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("Rsin".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("CodeNAFBNE".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("CodeEmploiOccupe".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("NumeroObjet".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("Cadre".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("ForfaitUrssaf".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("TopAlsaceMoselle".equals(pElementName))
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
    if ("DateCreation".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("DateOrigineInformation".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("DateCreationFeuillet".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("NbJoursTravailles".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("NbHeuresTravaillees".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("NbCachets".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("SalaireBrutNonAbattu".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("SalaireBrutAbattu".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("NumeroChrono".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("MontantIccp".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("MontantAvantageNature".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("MontantFraisProfessionnel".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("TauxAbattement".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    return null;
  }
  
  public int _getPropertyLength(String pElementName)
  {
    if ("CodeMouvement".equals(pElementName)) {
      return 1;
    }
    if ("PrenomEmployeur".equals(pElementName)) {
      return 30;
    }
    if ("NumeroGuso".equals(pElementName)) {
      return 10;
    }
    if ("CodeNAF".equals(pElementName)) {
      return 4;
    }
    if ("IdentifiantBNI".equals(pElementName)) {
      return 10;
    }
    if ("Nom".equals(pElementName)) {
      return 20;
    }
    if ("Prenom".equals(pElementName)) {
      return 12;
    }
    if ("NIRIntermittent".equals(pElementName)) {
      return 15;
    }
    if ("EmploiOccupe".equals(pElementName)) {
      return 30;
    }
    if ("IdPrestation".equals(pElementName)) {
      return 10;
    }
    if ("NatureActivite".equals(pElementName)) {
      return 1;
    }
    if ("MotifFCT".equals(pElementName)) {
      return 2;
    }
    if ("CodeDevise".equals(pElementName)) {
      return 1;
    }
    if ("IdentifiantBNE".equals(pElementName)) {
      return 10;
    }
    if ("SiretBNE".equals(pElementName)) {
      return 14;
    }
    if ("RaisonSocialeBNE".equals(pElementName)) {
      return 40;
    }
    if ("NumeroRueBNE".equals(pElementName)) {
      return 5;
    }
    if ("Adresse1BNE".equals(pElementName)) {
      return 32;
    }
    if ("Adresse2BNE".equals(pElementName)) {
      return 40;
    }
    if ("CodePostalBNE".equals(pElementName)) {
      return 5;
    }
    if ("LibelleCommuneBNE".equals(pElementName)) {
      return 40;
    }
    if ("AssedicAffiliationBNE".equals(pElementName)) {
      return 3;
    }
    if ("NumeroAffiliationBNE".equals(pElementName)) {
      return 8;
    }
    if ("NouveauCodeNAF".equals(pElementName)) {
      return 5;
    }
    if ("RaisonSocialeEmployeur".equals(pElementName)) {
      return 30;
    }
    if ("NumeroTelephone".equals(pElementName)) {
      return 12;
    }
    if ("NumeroFax".equals(pElementName)) {
      return 12;
    }
    if ("PremiereLigneAdresseEmployeurCourrier".equals(pElementName)) {
      return 32;
    }
    if ("DeuxiemeLigneAdresseEmployeurCourrier".equals(pElementName)) {
      return 32;
    }
    if ("TroisiemeLigneAdresseEmployeurCourrier".equals(pElementName)) {
      return 32;
    }
    if ("QuatriemeLigneAdresseEmployeurCourrier".equals(pElementName)) {
      return 32;
    }
    if ("Siret".equals(pElementName)) {
      return 14;
    }
    if ("FormeJuridique".equals(pElementName)) {
      return 4;
    }
    if ("Pseudo".equals(pElementName)) {
      return 30;
    }
    if ("PremiereLigneAdresseIntermittentCourrier".equals(pElementName)) {
      return 32;
    }
    if ("DeuxiemeLigneAdresseIntermittentCourrier".equals(pElementName)) {
      return 32;
    }
    if ("TroisiemeLigneAdresseIntermittentCourrier".equals(pElementName)) {
      return 32;
    }
    if ("QuatriemeLigneAdresseIntermittentCourrier".equals(pElementName)) {
      return 32;
    }
    if ("PositionEmployeur".equals(pElementName)) {
      return 1;
    }
    if ("PositionAutreEmployeur".equals(pElementName)) {
      return 1;
    }
    if ("CodeAssedic".equals(pElementName)) {
      return 2;
    }
    if ("Rsin".equals(pElementName)) {
      return 8;
    }
    if ("CodeNAFBNE".equals(pElementName)) {
      return 5;
    }
    if ("CodeEmploiOccupe".equals(pElementName)) {
      return 6;
    }
    if ("NumeroObjet".equals(pElementName)) {
      return 12;
    }
    if ("Cadre".equals(pElementName)) {
      return 1;
    }
    if ("ForfaitUrssaf".equals(pElementName)) {
      return 1;
    }
    if ("TopAlsaceMoselle".equals(pElementName)) {
      return 1;
    }
    if ("DateDebutContrat".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("DateFinContrat".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("DateCreation".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("DateOrigineInformation".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("DateCreationFeuillet".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("NbJoursTravailles".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("NbHeuresTravaillees".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("NbCachets".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("SalaireBrutNonAbattu".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("SalaireBrutAbattu".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("NumeroChrono".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("MontantIccp".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("MontantAvantageNature".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("MontantFraisProfessionnel".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("TauxAbattement".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    return -1;
  }
  
  public Object _getProperty(String pName)
    throws Exception
  {
    if ("CodeMouvement".equals(pName)) {
      return m_codeMouvement;
    }
    if ("PrenomEmployeur".equals(pName)) {
      return m_prenomEmployeur;
    }
    if ("NumeroGuso".equals(pName)) {
      return m_numeroGuso;
    }
    if ("CodeNAF".equals(pName)) {
      return m_codeNAF;
    }
    if ("IdentifiantBNI".equals(pName)) {
      return m_identifiantBNI;
    }
    if ("Nom".equals(pName)) {
      return m_nom;
    }
    if ("Prenom".equals(pName)) {
      return m_prenom;
    }
    if ("NIRIntermittent".equals(pName)) {
      return m_nIRIntermittent;
    }
    if ("EmploiOccupe".equals(pName)) {
      return m_emploiOccupe;
    }
    if ("IdPrestation".equals(pName)) {
      return m_idPrestation;
    }
    if ("NatureActivite".equals(pName)) {
      return m_natureActivite;
    }
    if ("MotifFCT".equals(pName)) {
      return m_motifFCT;
    }
    if ("CodeDevise".equals(pName)) {
      return m_codeDevise;
    }
    if ("IdentifiantBNE".equals(pName)) {
      return m_identifiantBNE;
    }
    if ("SiretBNE".equals(pName)) {
      return m_siretBNE;
    }
    if ("RaisonSocialeBNE".equals(pName)) {
      return m_raisonSocialeBNE;
    }
    if ("NumeroRueBNE".equals(pName)) {
      return m_numeroRueBNE;
    }
    if ("Adresse1BNE".equals(pName)) {
      return m_adresse1BNE;
    }
    if ("Adresse2BNE".equals(pName)) {
      return m_adresse2BNE;
    }
    if ("CodePostalBNE".equals(pName)) {
      return m_codePostalBNE;
    }
    if ("LibelleCommuneBNE".equals(pName)) {
      return m_libelleCommuneBNE;
    }
    if ("AssedicAffiliationBNE".equals(pName)) {
      return m_assedicAffiliationBNE;
    }
    if ("NumeroAffiliationBNE".equals(pName)) {
      return m_numeroAffiliationBNE;
    }
    if ("NouveauCodeNAF".equals(pName)) {
      return m_nouveauCodeNAF;
    }
    if ("RaisonSocialeEmployeur".equals(pName)) {
      return m_raisonSocialeEmployeur;
    }
    if ("NumeroTelephone".equals(pName)) {
      return m_numeroTelephone;
    }
    if ("NumeroFax".equals(pName)) {
      return m_numeroFax;
    }
    if ("PremiereLigneAdresseEmployeurCourrier".equals(pName)) {
      return m_premiereLigneAdresseEmployeurCourrier;
    }
    if ("DeuxiemeLigneAdresseEmployeurCourrier".equals(pName)) {
      return m_deuxiemeLigneAdresseEmployeurCourrier;
    }
    if ("TroisiemeLigneAdresseEmployeurCourrier".equals(pName)) {
      return m_troisiemeLigneAdresseEmployeurCourrier;
    }
    if ("QuatriemeLigneAdresseEmployeurCourrier".equals(pName)) {
      return m_quatriemeLigneAdresseEmployeurCourrier;
    }
    if ("Siret".equals(pName)) {
      return m_siret;
    }
    if ("FormeJuridique".equals(pName)) {
      return m_formeJuridique;
    }
    if ("Pseudo".equals(pName)) {
      return m_pseudo;
    }
    if ("PremiereLigneAdresseIntermittentCourrier".equals(pName)) {
      return m_premiereLigneAdresseIntermittentCourrier;
    }
    if ("DeuxiemeLigneAdresseIntermittentCourrier".equals(pName)) {
      return m_deuxiemeLigneAdresseIntermittentCourrier;
    }
    if ("TroisiemeLigneAdresseIntermittentCourrier".equals(pName)) {
      return m_troisiemeLigneAdresseIntermittentCourrier;
    }
    if ("QuatriemeLigneAdresseIntermittentCourrier".equals(pName)) {
      return m_quatriemeLigneAdresseIntermittentCourrier;
    }
    if ("PositionEmployeur".equals(pName)) {
      return m_positionEmployeur;
    }
    if ("PositionAutreEmployeur".equals(pName)) {
      return m_positionAutreEmployeur;
    }
    if ("CodeAssedic".equals(pName)) {
      return m_codeAssedic;
    }
    if ("Rsin".equals(pName)) {
      return m_rsin;
    }
    if ("CodeNAFBNE".equals(pName)) {
      return m_codeNAFBNE;
    }
    if ("CodeEmploiOccupe".equals(pName)) {
      return m_codeEmploiOccupe;
    }
    if ("NumeroObjet".equals(pName)) {
      return m_numeroObjet;
    }
    if ("Cadre".equals(pName)) {
      return m_cadre;
    }
    if ("ForfaitUrssaf".equals(pName)) {
      return m_forfaitUrssaf;
    }
    if ("TopAlsaceMoselle".equals(pName)) {
      return m_topAlsaceMoselle;
    }
    if ("DateDebutContrat".equals(pName)) {
      return m_dateDebutContrat;
    }
    if ("DateFinContrat".equals(pName)) {
      return m_dateFinContrat;
    }
    if ("DateCreation".equals(pName)) {
      return m_dateCreation;
    }
    if ("DateOrigineInformation".equals(pName)) {
      return m_dateOrigineInformation;
    }
    if ("DateCreationFeuillet".equals(pName)) {
      return m_dateCreationFeuillet;
    }
    if ("NbJoursTravailles".equals(pName)) {
      return m_nbJoursTravailles;
    }
    if ("NbHeuresTravaillees".equals(pName)) {
      return m_nbHeuresTravaillees;
    }
    if ("NbCachets".equals(pName)) {
      return m_nbCachets;
    }
    if ("SalaireBrutNonAbattu".equals(pName)) {
      return m_salaireBrutNonAbattu;
    }
    if ("SalaireBrutAbattu".equals(pName)) {
      return m_salaireBrutAbattu;
    }
    if ("NumeroChrono".equals(pName)) {
      return m_numeroChrono;
    }
    if ("MontantIccp".equals(pName)) {
      return m_montantIccp;
    }
    if ("MontantAvantageNature".equals(pName)) {
      return m_montantAvantageNature;
    }
    if ("MontantFraisProfessionnel".equals(pName)) {
      return m_montantFraisProfessionnel;
    }
    if ("TauxAbattement".equals(pName)) {
      return m_tauxAbattement;
    }
    return null;
  }
  
  public Iterator _getPropertyNames()
    throws Exception
  {
    ArrayList liste = new ArrayList();
    liste.add("CodeMouvement");
    liste.add("PrenomEmployeur");
    liste.add("NumeroGuso");
    liste.add("CodeNAF");
    liste.add("IdentifiantBNI");
    liste.add("Nom");
    liste.add("Prenom");
    liste.add("NIRIntermittent");
    liste.add("EmploiOccupe");
    liste.add("IdPrestation");
    liste.add("NatureActivite");
    liste.add("MotifFCT");
    liste.add("CodeDevise");
    liste.add("IdentifiantBNE");
    liste.add("SiretBNE");
    liste.add("RaisonSocialeBNE");
    liste.add("NumeroRueBNE");
    liste.add("Adresse1BNE");
    liste.add("Adresse2BNE");
    liste.add("CodePostalBNE");
    liste.add("LibelleCommuneBNE");
    liste.add("AssedicAffiliationBNE");
    liste.add("NumeroAffiliationBNE");
    liste.add("NouveauCodeNAF");
    liste.add("RaisonSocialeEmployeur");
    liste.add("NumeroTelephone");
    liste.add("NumeroFax");
    liste.add("PremiereLigneAdresseEmployeurCourrier");
    liste.add("DeuxiemeLigneAdresseEmployeurCourrier");
    liste.add("TroisiemeLigneAdresseEmployeurCourrier");
    liste.add("QuatriemeLigneAdresseEmployeurCourrier");
    liste.add("Siret");
    liste.add("FormeJuridique");
    liste.add("Pseudo");
    liste.add("PremiereLigneAdresseIntermittentCourrier");
    liste.add("DeuxiemeLigneAdresseIntermittentCourrier");
    liste.add("TroisiemeLigneAdresseIntermittentCourrier");
    liste.add("QuatriemeLigneAdresseIntermittentCourrier");
    liste.add("PositionEmployeur");
    liste.add("PositionAutreEmployeur");
    liste.add("CodeAssedic");
    liste.add("Rsin");
    liste.add("CodeNAFBNE");
    liste.add("CodeEmploiOccupe");
    liste.add("NumeroObjet");
    liste.add("Cadre");
    liste.add("ForfaitUrssaf");
    liste.add("TopAlsaceMoselle");
    liste.add("DateDebutContrat");
    liste.add("DateFinContrat");
    liste.add("DateCreation");
    liste.add("DateOrigineInformation");
    liste.add("DateCreationFeuillet");
    liste.add("NbJoursTravailles");
    liste.add("NbHeuresTravaillees");
    liste.add("NbCachets");
    liste.add("SalaireBrutNonAbattu");
    liste.add("SalaireBrutAbattu");
    liste.add("NumeroChrono");
    liste.add("MontantIccp");
    liste.add("MontantAvantageNature");
    liste.add("MontantFraisProfessionnel");
    liste.add("TauxAbattement");
    return liste.iterator();
  }
  
  public ArrayList _getPropertyNames(ArrayList pListe)
    throws Exception
  {
    pListe.add("CodeMouvement");
    pListe.add("PrenomEmployeur");
    pListe.add("NumeroGuso");
    pListe.add("CodeNAF");
    pListe.add("IdentifiantBNI");
    pListe.add("Nom");
    pListe.add("Prenom");
    pListe.add("NIRIntermittent");
    pListe.add("EmploiOccupe");
    pListe.add("IdPrestation");
    pListe.add("NatureActivite");
    pListe.add("MotifFCT");
    pListe.add("CodeDevise");
    pListe.add("IdentifiantBNE");
    pListe.add("SiretBNE");
    pListe.add("RaisonSocialeBNE");
    pListe.add("NumeroRueBNE");
    pListe.add("Adresse1BNE");
    pListe.add("Adresse2BNE");
    pListe.add("CodePostalBNE");
    pListe.add("LibelleCommuneBNE");
    pListe.add("AssedicAffiliationBNE");
    pListe.add("NumeroAffiliationBNE");
    pListe.add("NouveauCodeNAF");
    pListe.add("RaisonSocialeEmployeur");
    pListe.add("NumeroTelephone");
    pListe.add("NumeroFax");
    pListe.add("PremiereLigneAdresseEmployeurCourrier");
    pListe.add("DeuxiemeLigneAdresseEmployeurCourrier");
    pListe.add("TroisiemeLigneAdresseEmployeurCourrier");
    pListe.add("QuatriemeLigneAdresseEmployeurCourrier");
    pListe.add("Siret");
    pListe.add("FormeJuridique");
    pListe.add("Pseudo");
    pListe.add("PremiereLigneAdresseIntermittentCourrier");
    pListe.add("DeuxiemeLigneAdresseIntermittentCourrier");
    pListe.add("TroisiemeLigneAdresseIntermittentCourrier");
    pListe.add("QuatriemeLigneAdresseIntermittentCourrier");
    pListe.add("PositionEmployeur");
    pListe.add("PositionAutreEmployeur");
    pListe.add("CodeAssedic");
    pListe.add("Rsin");
    pListe.add("CodeNAFBNE");
    pListe.add("CodeEmploiOccupe");
    pListe.add("NumeroObjet");
    pListe.add("Cadre");
    pListe.add("ForfaitUrssaf");
    pListe.add("TopAlsaceMoselle");
    pListe.add("DateDebutContrat");
    pListe.add("DateFinContrat");
    pListe.add("DateCreation");
    pListe.add("DateOrigineInformation");
    pListe.add("DateCreationFeuillet");
    pListe.add("NbJoursTravailles");
    pListe.add("NbHeuresTravaillees");
    pListe.add("NbCachets");
    pListe.add("SalaireBrutNonAbattu");
    pListe.add("SalaireBrutAbattu");
    pListe.add("NumeroChrono");
    pListe.add("MontantIccp");
    pListe.add("MontantAvantageNature");
    pListe.add("MontantFraisProfessionnel");
    pListe.add("TauxAbattement");
    return pListe;
  }
  
  public void _setProperty(String pName, Object pValeur)
    throws Exception
  {
    if ("CodeMouvement".equals(pName)) {
      m_codeMouvement = ((String)pValeur);
    }
    if ("PrenomEmployeur".equals(pName)) {
      m_prenomEmployeur = ((String)pValeur);
    }
    if ("NumeroGuso".equals(pName)) {
      m_numeroGuso = ((String)pValeur);
    }
    if ("CodeNAF".equals(pName)) {
      m_codeNAF = ((String)pValeur);
    }
    if ("IdentifiantBNI".equals(pName)) {
      m_identifiantBNI = ((String)pValeur);
    }
    if ("Nom".equals(pName)) {
      m_nom = ((String)pValeur);
    }
    if ("Prenom".equals(pName)) {
      m_prenom = ((String)pValeur);
    }
    if ("NIRIntermittent".equals(pName)) {
      m_nIRIntermittent = ((String)pValeur);
    }
    if ("EmploiOccupe".equals(pName)) {
      m_emploiOccupe = ((String)pValeur);
    }
    if ("IdPrestation".equals(pName)) {
      m_idPrestation = ((String)pValeur);
    }
    if ("NatureActivite".equals(pName)) {
      m_natureActivite = ((String)pValeur);
    }
    if ("MotifFCT".equals(pName)) {
      m_motifFCT = ((String)pValeur);
    }
    if ("CodeDevise".equals(pName)) {
      m_codeDevise = ((String)pValeur);
    }
    if ("IdentifiantBNE".equals(pName)) {
      m_identifiantBNE = ((String)pValeur);
    }
    if ("SiretBNE".equals(pName)) {
      m_siretBNE = ((String)pValeur);
    }
    if ("RaisonSocialeBNE".equals(pName)) {
      m_raisonSocialeBNE = ((String)pValeur);
    }
    if ("NumeroRueBNE".equals(pName)) {
      m_numeroRueBNE = ((String)pValeur);
    }
    if ("Adresse1BNE".equals(pName)) {
      m_adresse1BNE = ((String)pValeur);
    }
    if ("Adresse2BNE".equals(pName)) {
      m_adresse2BNE = ((String)pValeur);
    }
    if ("CodePostalBNE".equals(pName)) {
      m_codePostalBNE = ((String)pValeur);
    }
    if ("LibelleCommuneBNE".equals(pName)) {
      m_libelleCommuneBNE = ((String)pValeur);
    }
    if ("AssedicAffiliationBNE".equals(pName)) {
      m_assedicAffiliationBNE = ((String)pValeur);
    }
    if ("NumeroAffiliationBNE".equals(pName)) {
      m_numeroAffiliationBNE = ((String)pValeur);
    }
    if ("NouveauCodeNAF".equals(pName)) {
      m_nouveauCodeNAF = ((String)pValeur);
    }
    if ("RaisonSocialeEmployeur".equals(pName)) {
      m_raisonSocialeEmployeur = ((String)pValeur);
    }
    if ("NumeroTelephone".equals(pName)) {
      m_numeroTelephone = ((String)pValeur);
    }
    if ("NumeroFax".equals(pName)) {
      m_numeroFax = ((String)pValeur);
    }
    if ("PremiereLigneAdresseEmployeurCourrier".equals(pName)) {
      m_premiereLigneAdresseEmployeurCourrier = ((String)pValeur);
    }
    if ("DeuxiemeLigneAdresseEmployeurCourrier".equals(pName)) {
      m_deuxiemeLigneAdresseEmployeurCourrier = ((String)pValeur);
    }
    if ("TroisiemeLigneAdresseEmployeurCourrier".equals(pName)) {
      m_troisiemeLigneAdresseEmployeurCourrier = ((String)pValeur);
    }
    if ("QuatriemeLigneAdresseEmployeurCourrier".equals(pName)) {
      m_quatriemeLigneAdresseEmployeurCourrier = ((String)pValeur);
    }
    if ("Siret".equals(pName)) {
      m_siret = ((String)pValeur);
    }
    if ("FormeJuridique".equals(pName)) {
      m_formeJuridique = ((String)pValeur);
    }
    if ("Pseudo".equals(pName)) {
      m_pseudo = ((String)pValeur);
    }
    if ("PremiereLigneAdresseIntermittentCourrier".equals(pName)) {
      m_premiereLigneAdresseIntermittentCourrier = ((String)pValeur);
    }
    if ("DeuxiemeLigneAdresseIntermittentCourrier".equals(pName)) {
      m_deuxiemeLigneAdresseIntermittentCourrier = ((String)pValeur);
    }
    if ("TroisiemeLigneAdresseIntermittentCourrier".equals(pName)) {
      m_troisiemeLigneAdresseIntermittentCourrier = ((String)pValeur);
    }
    if ("QuatriemeLigneAdresseIntermittentCourrier".equals(pName)) {
      m_quatriemeLigneAdresseIntermittentCourrier = ((String)pValeur);
    }
    if ("PositionEmployeur".equals(pName)) {
      m_positionEmployeur = ((String)pValeur);
    }
    if ("PositionAutreEmployeur".equals(pName)) {
      m_positionAutreEmployeur = ((String)pValeur);
    }
    if ("CodeAssedic".equals(pName)) {
      m_codeAssedic = ((String)pValeur);
    }
    if ("Rsin".equals(pName)) {
      m_rsin = ((String)pValeur);
    }
    if ("CodeNAFBNE".equals(pName)) {
      m_codeNAFBNE = ((String)pValeur);
    }
    if ("CodeEmploiOccupe".equals(pName)) {
      m_codeEmploiOccupe = ((String)pValeur);
    }
    if ("NumeroObjet".equals(pName)) {
      m_numeroObjet = ((String)pValeur);
    }
    if ("Cadre".equals(pName)) {
      m_cadre = ((String)pValeur);
    }
    if ("ForfaitUrssaf".equals(pName)) {
      m_forfaitUrssaf = ((String)pValeur);
    }
    if ("TopAlsaceMoselle".equals(pName)) {
      m_topAlsaceMoselle = ((String)pValeur);
    }
    if ("DateDebutContrat".equals(pName)) {
      m_dateDebutContrat = ((Damj)pValeur);
    }
    if ("DateFinContrat".equals(pName)) {
      m_dateFinContrat = ((Damj)pValeur);
    }
    if ("DateCreation".equals(pName)) {
      m_dateCreation = ((Damj)pValeur);
    }
    if ("DateOrigineInformation".equals(pName)) {
      m_dateOrigineInformation = ((Damj)pValeur);
    }
    if ("DateCreationFeuillet".equals(pName)) {
      m_dateCreationFeuillet = ((Damj)pValeur);
    }
    if ("NbJoursTravailles".equals(pName)) {
      m_nbJoursTravailles = ((BigDecimal)pValeur);
    }
    if ("NbHeuresTravaillees".equals(pName)) {
      m_nbHeuresTravaillees = ((BigDecimal)pValeur);
    }
    if ("NbCachets".equals(pName)) {
      m_nbCachets = ((BigDecimal)pValeur);
    }
    if ("SalaireBrutNonAbattu".equals(pName)) {
      m_salaireBrutNonAbattu = ((BigDecimal)pValeur);
    }
    if ("SalaireBrutAbattu".equals(pName)) {
      m_salaireBrutAbattu = ((BigDecimal)pValeur);
    }
    if ("NumeroChrono".equals(pName)) {
      m_numeroChrono = ((BigDecimal)pValeur);
    }
    if ("MontantIccp".equals(pName)) {
      m_montantIccp = ((BigDecimal)pValeur);
    }
    if ("MontantAvantageNature".equals(pName)) {
      m_montantAvantageNature = ((BigDecimal)pValeur);
    }
    if ("MontantFraisProfessionnel".equals(pName)) {
      m_montantFraisProfessionnel = ((BigDecimal)pValeur);
    }
    if ("TauxAbattement".equals(pName)) {
      m_tauxAbattement = ((BigDecimal)pValeur);
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
    if ("m_codeMouvement_C_ERR".equals(attrName)) {
      m_codeMouvement_C_ERR = pValeur;
    }
    if ("m_prenomEmployeur_C_ERR".equals(attrName)) {
      m_prenomEmployeur_C_ERR = pValeur;
    }
    if ("m_numeroGuso_C_ERR".equals(attrName)) {
      m_numeroGuso_C_ERR = pValeur;
    }
    if ("m_codeNAF_C_ERR".equals(attrName)) {
      m_codeNAF_C_ERR = pValeur;
    }
    if ("m_identifiantBNI_C_ERR".equals(attrName)) {
      m_identifiantBNI_C_ERR = pValeur;
    }
    if ("m_nom_C_ERR".equals(attrName)) {
      m_nom_C_ERR = pValeur;
    }
    if ("m_prenom_C_ERR".equals(attrName)) {
      m_prenom_C_ERR = pValeur;
    }
    if ("m_nIRIntermittent_C_ERR".equals(attrName)) {
      m_nIRIntermittent_C_ERR = pValeur;
    }
    if ("m_emploiOccupe_C_ERR".equals(attrName)) {
      m_emploiOccupe_C_ERR = pValeur;
    }
    if ("m_idPrestation_C_ERR".equals(attrName)) {
      m_idPrestation_C_ERR = pValeur;
    }
    if ("m_natureActivite_C_ERR".equals(attrName)) {
      m_natureActivite_C_ERR = pValeur;
    }
    if ("m_motifFCT_C_ERR".equals(attrName)) {
      m_motifFCT_C_ERR = pValeur;
    }
    if ("m_codeDevise_C_ERR".equals(attrName)) {
      m_codeDevise_C_ERR = pValeur;
    }
    if ("m_identifiantBNE_C_ERR".equals(attrName)) {
      m_identifiantBNE_C_ERR = pValeur;
    }
    if ("m_siretBNE_C_ERR".equals(attrName)) {
      m_siretBNE_C_ERR = pValeur;
    }
    if ("m_raisonSocialeBNE_C_ERR".equals(attrName)) {
      m_raisonSocialeBNE_C_ERR = pValeur;
    }
    if ("m_numeroRueBNE_C_ERR".equals(attrName)) {
      m_numeroRueBNE_C_ERR = pValeur;
    }
    if ("m_adresse1BNE_C_ERR".equals(attrName)) {
      m_adresse1BNE_C_ERR = pValeur;
    }
    if ("m_adresse2BNE_C_ERR".equals(attrName)) {
      m_adresse2BNE_C_ERR = pValeur;
    }
    if ("m_codePostalBNE_C_ERR".equals(attrName)) {
      m_codePostalBNE_C_ERR = pValeur;
    }
    if ("m_libelleCommuneBNE_C_ERR".equals(attrName)) {
      m_libelleCommuneBNE_C_ERR = pValeur;
    }
    if ("m_assedicAffiliationBNE_C_ERR".equals(attrName)) {
      m_assedicAffiliationBNE_C_ERR = pValeur;
    }
    if ("m_numeroAffiliationBNE_C_ERR".equals(attrName)) {
      m_numeroAffiliationBNE_C_ERR = pValeur;
    }
    if ("m_nouveauCodeNAF_C_ERR".equals(attrName)) {
      m_nouveauCodeNAF_C_ERR = pValeur;
    }
    if ("m_raisonSocialeEmployeur_C_ERR".equals(attrName)) {
      m_raisonSocialeEmployeur_C_ERR = pValeur;
    }
    if ("m_numeroTelephone_C_ERR".equals(attrName)) {
      m_numeroTelephone_C_ERR = pValeur;
    }
    if ("m_numeroFax_C_ERR".equals(attrName)) {
      m_numeroFax_C_ERR = pValeur;
    }
    if ("m_premiereLigneAdresseEmployeurCourrier_C_ERR".equals(attrName)) {
      m_premiereLigneAdresseEmployeurCourrier_C_ERR = pValeur;
    }
    if ("m_deuxiemeLigneAdresseEmployeurCourrier_C_ERR".equals(attrName)) {
      m_deuxiemeLigneAdresseEmployeurCourrier_C_ERR = pValeur;
    }
    if ("m_troisiemeLigneAdresseEmployeurCourrier_C_ERR".equals(attrName)) {
      m_troisiemeLigneAdresseEmployeurCourrier_C_ERR = pValeur;
    }
    if ("m_quatriemeLigneAdresseEmployeurCourrier_C_ERR".equals(attrName)) {
      m_quatriemeLigneAdresseEmployeurCourrier_C_ERR = pValeur;
    }
    if ("m_siret_C_ERR".equals(attrName)) {
      m_siret_C_ERR = pValeur;
    }
    if ("m_formeJuridique_C_ERR".equals(attrName)) {
      m_formeJuridique_C_ERR = pValeur;
    }
    if ("m_pseudo_C_ERR".equals(attrName)) {
      m_pseudo_C_ERR = pValeur;
    }
    if ("m_premiereLigneAdresseIntermittentCourrier_C_ERR".equals(attrName)) {
      m_premiereLigneAdresseIntermittentCourrier_C_ERR = pValeur;
    }
    if ("m_deuxiemeLigneAdresseIntermittentCourrier_C_ERR".equals(attrName)) {
      m_deuxiemeLigneAdresseIntermittentCourrier_C_ERR = pValeur;
    }
    if ("m_troisiemeLigneAdresseIntermittentCourrier_C_ERR".equals(attrName)) {
      m_troisiemeLigneAdresseIntermittentCourrier_C_ERR = pValeur;
    }
    if ("m_quatriemeLigneAdresseIntermittentCourrier_C_ERR".equals(attrName)) {
      m_quatriemeLigneAdresseIntermittentCourrier_C_ERR = pValeur;
    }
    if ("m_positionEmployeur_C_ERR".equals(attrName)) {
      m_positionEmployeur_C_ERR = pValeur;
    }
    if ("m_positionAutreEmployeur_C_ERR".equals(attrName)) {
      m_positionAutreEmployeur_C_ERR = pValeur;
    }
    if ("m_codeAssedic_C_ERR".equals(attrName)) {
      m_codeAssedic_C_ERR = pValeur;
    }
    if ("m_rsin_C_ERR".equals(attrName)) {
      m_rsin_C_ERR = pValeur;
    }
    if ("m_codeNAFBNE_C_ERR".equals(attrName)) {
      m_codeNAFBNE_C_ERR = pValeur;
    }
    if ("m_codeEmploiOccupe_C_ERR".equals(attrName)) {
      m_codeEmploiOccupe_C_ERR = pValeur;
    }
    if ("m_numeroObjet_C_ERR".equals(attrName)) {
      m_numeroObjet_C_ERR = pValeur;
    }
    if ("m_cadre_C_ERR".equals(attrName)) {
      m_cadre_C_ERR = pValeur;
    }
    if ("m_forfaitUrssaf_C_ERR".equals(attrName)) {
      m_forfaitUrssaf_C_ERR = pValeur;
    }
    if ("m_topAlsaceMoselle_C_ERR".equals(attrName)) {
      m_topAlsaceMoselle_C_ERR = pValeur;
    }
    if ("m_dateDebutContrat_C_ERR".equals(attrName)) {
      m_dateDebutContrat_C_ERR = pValeur;
    }
    if ("m_dateFinContrat_C_ERR".equals(attrName)) {
      m_dateFinContrat_C_ERR = pValeur;
    }
    if ("m_dateCreation_C_ERR".equals(attrName)) {
      m_dateCreation_C_ERR = pValeur;
    }
    if ("m_dateOrigineInformation_C_ERR".equals(attrName)) {
      m_dateOrigineInformation_C_ERR = pValeur;
    }
    if ("m_dateCreationFeuillet_C_ERR".equals(attrName)) {
      m_dateCreationFeuillet_C_ERR = pValeur;
    }
    if ("m_nbJoursTravailles_C_ERR".equals(attrName)) {
      m_nbJoursTravailles_C_ERR = pValeur;
    }
    if ("m_nbHeuresTravaillees_C_ERR".equals(attrName)) {
      m_nbHeuresTravaillees_C_ERR = pValeur;
    }
    if ("m_nbCachets_C_ERR".equals(attrName)) {
      m_nbCachets_C_ERR = pValeur;
    }
    if ("m_salaireBrutNonAbattu_C_ERR".equals(attrName)) {
      m_salaireBrutNonAbattu_C_ERR = pValeur;
    }
    if ("m_salaireBrutAbattu_C_ERR".equals(attrName)) {
      m_salaireBrutAbattu_C_ERR = pValeur;
    }
    if ("m_numeroChrono_C_ERR".equals(attrName)) {
      m_numeroChrono_C_ERR = pValeur;
    }
    if ("m_montantIccp_C_ERR".equals(attrName)) {
      m_montantIccp_C_ERR = pValeur;
    }
    if ("m_montantAvantageNature_C_ERR".equals(attrName)) {
      m_montantAvantageNature_C_ERR = pValeur;
    }
    if ("m_montantFraisProfessionnel_C_ERR".equals(attrName)) {
      m_montantFraisProfessionnel_C_ERR = pValeur;
    }
    if ("m_tauxAbattement_C_ERR".equals(attrName)) {
      m_tauxAbattement_C_ERR = pValeur;
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
    if ("m_codeMouvement_C_ERR".equals(attrName)) {
      return m_codeMouvement_C_ERR;
    }
    if ("m_prenomEmployeur_C_ERR".equals(attrName)) {
      return m_prenomEmployeur_C_ERR;
    }
    if ("m_numeroGuso_C_ERR".equals(attrName)) {
      return m_numeroGuso_C_ERR;
    }
    if ("m_codeNAF_C_ERR".equals(attrName)) {
      return m_codeNAF_C_ERR;
    }
    if ("m_identifiantBNI_C_ERR".equals(attrName)) {
      return m_identifiantBNI_C_ERR;
    }
    if ("m_nom_C_ERR".equals(attrName)) {
      return m_nom_C_ERR;
    }
    if ("m_prenom_C_ERR".equals(attrName)) {
      return m_prenom_C_ERR;
    }
    if ("m_nIRIntermittent_C_ERR".equals(attrName)) {
      return m_nIRIntermittent_C_ERR;
    }
    if ("m_emploiOccupe_C_ERR".equals(attrName)) {
      return m_emploiOccupe_C_ERR;
    }
    if ("m_idPrestation_C_ERR".equals(attrName)) {
      return m_idPrestation_C_ERR;
    }
    if ("m_natureActivite_C_ERR".equals(attrName)) {
      return m_natureActivite_C_ERR;
    }
    if ("m_motifFCT_C_ERR".equals(attrName)) {
      return m_motifFCT_C_ERR;
    }
    if ("m_codeDevise_C_ERR".equals(attrName)) {
      return m_codeDevise_C_ERR;
    }
    if ("m_identifiantBNE_C_ERR".equals(attrName)) {
      return m_identifiantBNE_C_ERR;
    }
    if ("m_siretBNE_C_ERR".equals(attrName)) {
      return m_siretBNE_C_ERR;
    }
    if ("m_raisonSocialeBNE_C_ERR".equals(attrName)) {
      return m_raisonSocialeBNE_C_ERR;
    }
    if ("m_numeroRueBNE_C_ERR".equals(attrName)) {
      return m_numeroRueBNE_C_ERR;
    }
    if ("m_adresse1BNE_C_ERR".equals(attrName)) {
      return m_adresse1BNE_C_ERR;
    }
    if ("m_adresse2BNE_C_ERR".equals(attrName)) {
      return m_adresse2BNE_C_ERR;
    }
    if ("m_codePostalBNE_C_ERR".equals(attrName)) {
      return m_codePostalBNE_C_ERR;
    }
    if ("m_libelleCommuneBNE_C_ERR".equals(attrName)) {
      return m_libelleCommuneBNE_C_ERR;
    }
    if ("m_assedicAffiliationBNE_C_ERR".equals(attrName)) {
      return m_assedicAffiliationBNE_C_ERR;
    }
    if ("m_numeroAffiliationBNE_C_ERR".equals(attrName)) {
      return m_numeroAffiliationBNE_C_ERR;
    }
    if ("m_nouveauCodeNAF_C_ERR".equals(attrName)) {
      return m_nouveauCodeNAF_C_ERR;
    }
    if ("m_raisonSocialeEmployeur_C_ERR".equals(attrName)) {
      return m_raisonSocialeEmployeur_C_ERR;
    }
    if ("m_numeroTelephone_C_ERR".equals(attrName)) {
      return m_numeroTelephone_C_ERR;
    }
    if ("m_numeroFax_C_ERR".equals(attrName)) {
      return m_numeroFax_C_ERR;
    }
    if ("m_premiereLigneAdresseEmployeurCourrier_C_ERR".equals(attrName)) {
      return m_premiereLigneAdresseEmployeurCourrier_C_ERR;
    }
    if ("m_deuxiemeLigneAdresseEmployeurCourrier_C_ERR".equals(attrName)) {
      return m_deuxiemeLigneAdresseEmployeurCourrier_C_ERR;
    }
    if ("m_troisiemeLigneAdresseEmployeurCourrier_C_ERR".equals(attrName)) {
      return m_troisiemeLigneAdresseEmployeurCourrier_C_ERR;
    }
    if ("m_quatriemeLigneAdresseEmployeurCourrier_C_ERR".equals(attrName)) {
      return m_quatriemeLigneAdresseEmployeurCourrier_C_ERR;
    }
    if ("m_siret_C_ERR".equals(attrName)) {
      return m_siret_C_ERR;
    }
    if ("m_formeJuridique_C_ERR".equals(attrName)) {
      return m_formeJuridique_C_ERR;
    }
    if ("m_pseudo_C_ERR".equals(attrName)) {
      return m_pseudo_C_ERR;
    }
    if ("m_premiereLigneAdresseIntermittentCourrier_C_ERR".equals(attrName)) {
      return m_premiereLigneAdresseIntermittentCourrier_C_ERR;
    }
    if ("m_deuxiemeLigneAdresseIntermittentCourrier_C_ERR".equals(attrName)) {
      return m_deuxiemeLigneAdresseIntermittentCourrier_C_ERR;
    }
    if ("m_troisiemeLigneAdresseIntermittentCourrier_C_ERR".equals(attrName)) {
      return m_troisiemeLigneAdresseIntermittentCourrier_C_ERR;
    }
    if ("m_quatriemeLigneAdresseIntermittentCourrier_C_ERR".equals(attrName)) {
      return m_quatriemeLigneAdresseIntermittentCourrier_C_ERR;
    }
    if ("m_positionEmployeur_C_ERR".equals(attrName)) {
      return m_positionEmployeur_C_ERR;
    }
    if ("m_positionAutreEmployeur_C_ERR".equals(attrName)) {
      return m_positionAutreEmployeur_C_ERR;
    }
    if ("m_codeAssedic_C_ERR".equals(attrName)) {
      return m_codeAssedic_C_ERR;
    }
    if ("m_rsin_C_ERR".equals(attrName)) {
      return m_rsin_C_ERR;
    }
    if ("m_codeNAFBNE_C_ERR".equals(attrName)) {
      return m_codeNAFBNE_C_ERR;
    }
    if ("m_codeEmploiOccupe_C_ERR".equals(attrName)) {
      return m_codeEmploiOccupe_C_ERR;
    }
    if ("m_numeroObjet_C_ERR".equals(attrName)) {
      return m_numeroObjet_C_ERR;
    }
    if ("m_cadre_C_ERR".equals(attrName)) {
      return m_cadre_C_ERR;
    }
    if ("m_forfaitUrssaf_C_ERR".equals(attrName)) {
      return m_forfaitUrssaf_C_ERR;
    }
    if ("m_topAlsaceMoselle_C_ERR".equals(attrName)) {
      return m_topAlsaceMoselle_C_ERR;
    }
    if ("m_dateDebutContrat_C_ERR".equals(attrName)) {
      return m_dateDebutContrat_C_ERR;
    }
    if ("m_dateFinContrat_C_ERR".equals(attrName)) {
      return m_dateFinContrat_C_ERR;
    }
    if ("m_dateCreation_C_ERR".equals(attrName)) {
      return m_dateCreation_C_ERR;
    }
    if ("m_dateOrigineInformation_C_ERR".equals(attrName)) {
      return m_dateOrigineInformation_C_ERR;
    }
    if ("m_dateCreationFeuillet_C_ERR".equals(attrName)) {
      return m_dateCreationFeuillet_C_ERR;
    }
    if ("m_nbJoursTravailles_C_ERR".equals(attrName)) {
      return m_nbJoursTravailles_C_ERR;
    }
    if ("m_nbHeuresTravaillees_C_ERR".equals(attrName)) {
      return m_nbHeuresTravaillees_C_ERR;
    }
    if ("m_nbCachets_C_ERR".equals(attrName)) {
      return m_nbCachets_C_ERR;
    }
    if ("m_salaireBrutNonAbattu_C_ERR".equals(attrName)) {
      return m_salaireBrutNonAbattu_C_ERR;
    }
    if ("m_salaireBrutAbattu_C_ERR".equals(attrName)) {
      return m_salaireBrutAbattu_C_ERR;
    }
    if ("m_numeroChrono_C_ERR".equals(attrName)) {
      return m_numeroChrono_C_ERR;
    }
    if ("m_montantIccp_C_ERR".equals(attrName)) {
      return m_montantIccp_C_ERR;
    }
    if ("m_montantAvantageNature_C_ERR".equals(attrName)) {
      return m_montantAvantageNature_C_ERR;
    }
    if ("m_montantFraisProfessionnel_C_ERR".equals(attrName)) {
      return m_montantFraisProfessionnel_C_ERR;
    }
    if ("m_tauxAbattement_C_ERR".equals(attrName)) {
      return m_tauxAbattement_C_ERR;
    }
    return null;
  }
  
  public boolean equals(Object pObjet)
  {
    if (!(pObjet instanceof _FluxGUSO)) {
      return false;
    }
    _FluxGUSO x = (_FluxGUSO)pObjet;
    if (m_codeMouvement == null)
    {
      if (m_codeMouvement != null) {
        return false;
      }
    }
    else
    {
      if (m_codeMouvement == null) {
        return false;
      }
      if (!m_codeMouvement.equals(m_codeMouvement)) {
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
    if (m_numeroGuso == null)
    {
      if (m_numeroGuso != null) {
        return false;
      }
    }
    else
    {
      if (m_numeroGuso == null) {
        return false;
      }
      if (!m_numeroGuso.equals(m_numeroGuso)) {
        return false;
      }
    }
    if (m_codeNAF == null)
    {
      if (m_codeNAF != null) {
        return false;
      }
    }
    else
    {
      if (m_codeNAF == null) {
        return false;
      }
      if (!m_codeNAF.equals(m_codeNAF)) {
        return false;
      }
    }
    if (m_identifiantBNI == null)
    {
      if (m_identifiantBNI != null) {
        return false;
      }
    }
    else
    {
      if (m_identifiantBNI == null) {
        return false;
      }
      if (!m_identifiantBNI.equals(m_identifiantBNI)) {
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
    if (m_nIRIntermittent == null)
    {
      if (m_nIRIntermittent != null) {
        return false;
      }
    }
    else
    {
      if (m_nIRIntermittent == null) {
        return false;
      }
      if (!m_nIRIntermittent.equals(m_nIRIntermittent)) {
        return false;
      }
    }
    if (m_emploiOccupe == null)
    {
      if (m_emploiOccupe != null) {
        return false;
      }
    }
    else
    {
      if (m_emploiOccupe == null) {
        return false;
      }
      if (!m_emploiOccupe.equals(m_emploiOccupe)) {
        return false;
      }
    }
    if (m_idPrestation == null)
    {
      if (m_idPrestation != null) {
        return false;
      }
    }
    else
    {
      if (m_idPrestation == null) {
        return false;
      }
      if (!m_idPrestation.equals(m_idPrestation)) {
        return false;
      }
    }
    if (m_natureActivite == null)
    {
      if (m_natureActivite != null) {
        return false;
      }
    }
    else
    {
      if (m_natureActivite == null) {
        return false;
      }
      if (!m_natureActivite.equals(m_natureActivite)) {
        return false;
      }
    }
    if (m_motifFCT == null)
    {
      if (m_motifFCT != null) {
        return false;
      }
    }
    else
    {
      if (m_motifFCT == null) {
        return false;
      }
      if (!m_motifFCT.equals(m_motifFCT)) {
        return false;
      }
    }
    if (m_codeDevise == null)
    {
      if (m_codeDevise != null) {
        return false;
      }
    }
    else
    {
      if (m_codeDevise == null) {
        return false;
      }
      if (!m_codeDevise.equals(m_codeDevise)) {
        return false;
      }
    }
    if (m_identifiantBNE == null)
    {
      if (m_identifiantBNE != null) {
        return false;
      }
    }
    else
    {
      if (m_identifiantBNE == null) {
        return false;
      }
      if (!m_identifiantBNE.equals(m_identifiantBNE)) {
        return false;
      }
    }
    if (m_siretBNE == null)
    {
      if (m_siretBNE != null) {
        return false;
      }
    }
    else
    {
      if (m_siretBNE == null) {
        return false;
      }
      if (!m_siretBNE.equals(m_siretBNE)) {
        return false;
      }
    }
    if (m_raisonSocialeBNE == null)
    {
      if (m_raisonSocialeBNE != null) {
        return false;
      }
    }
    else
    {
      if (m_raisonSocialeBNE == null) {
        return false;
      }
      if (!m_raisonSocialeBNE.equals(m_raisonSocialeBNE)) {
        return false;
      }
    }
    if (m_numeroRueBNE == null)
    {
      if (m_numeroRueBNE != null) {
        return false;
      }
    }
    else
    {
      if (m_numeroRueBNE == null) {
        return false;
      }
      if (!m_numeroRueBNE.equals(m_numeroRueBNE)) {
        return false;
      }
    }
    if (m_adresse1BNE == null)
    {
      if (m_adresse1BNE != null) {
        return false;
      }
    }
    else
    {
      if (m_adresse1BNE == null) {
        return false;
      }
      if (!m_adresse1BNE.equals(m_adresse1BNE)) {
        return false;
      }
    }
    if (m_adresse2BNE == null)
    {
      if (m_adresse2BNE != null) {
        return false;
      }
    }
    else
    {
      if (m_adresse2BNE == null) {
        return false;
      }
      if (!m_adresse2BNE.equals(m_adresse2BNE)) {
        return false;
      }
    }
    if (m_codePostalBNE == null)
    {
      if (m_codePostalBNE != null) {
        return false;
      }
    }
    else
    {
      if (m_codePostalBNE == null) {
        return false;
      }
      if (!m_codePostalBNE.equals(m_codePostalBNE)) {
        return false;
      }
    }
    if (m_libelleCommuneBNE == null)
    {
      if (m_libelleCommuneBNE != null) {
        return false;
      }
    }
    else
    {
      if (m_libelleCommuneBNE == null) {
        return false;
      }
      if (!m_libelleCommuneBNE.equals(m_libelleCommuneBNE)) {
        return false;
      }
    }
    if (m_assedicAffiliationBNE == null)
    {
      if (m_assedicAffiliationBNE != null) {
        return false;
      }
    }
    else
    {
      if (m_assedicAffiliationBNE == null) {
        return false;
      }
      if (!m_assedicAffiliationBNE.equals(m_assedicAffiliationBNE)) {
        return false;
      }
    }
    if (m_numeroAffiliationBNE == null)
    {
      if (m_numeroAffiliationBNE != null) {
        return false;
      }
    }
    else
    {
      if (m_numeroAffiliationBNE == null) {
        return false;
      }
      if (!m_numeroAffiliationBNE.equals(m_numeroAffiliationBNE)) {
        return false;
      }
    }
    if (m_nouveauCodeNAF == null)
    {
      if (m_nouveauCodeNAF != null) {
        return false;
      }
    }
    else
    {
      if (m_nouveauCodeNAF == null) {
        return false;
      }
      if (!m_nouveauCodeNAF.equals(m_nouveauCodeNAF)) {
        return false;
      }
    }
    if (m_raisonSocialeEmployeur == null)
    {
      if (m_raisonSocialeEmployeur != null) {
        return false;
      }
    }
    else
    {
      if (m_raisonSocialeEmployeur == null) {
        return false;
      }
      if (!m_raisonSocialeEmployeur.equals(m_raisonSocialeEmployeur)) {
        return false;
      }
    }
    if (m_numeroTelephone == null)
    {
      if (m_numeroTelephone != null) {
        return false;
      }
    }
    else
    {
      if (m_numeroTelephone == null) {
        return false;
      }
      if (!m_numeroTelephone.equals(m_numeroTelephone)) {
        return false;
      }
    }
    if (m_numeroFax == null)
    {
      if (m_numeroFax != null) {
        return false;
      }
    }
    else
    {
      if (m_numeroFax == null) {
        return false;
      }
      if (!m_numeroFax.equals(m_numeroFax)) {
        return false;
      }
    }
    if (m_premiereLigneAdresseEmployeurCourrier == null)
    {
      if (m_premiereLigneAdresseEmployeurCourrier != null) {
        return false;
      }
    }
    else
    {
      if (m_premiereLigneAdresseEmployeurCourrier == null) {
        return false;
      }
      if (!m_premiereLigneAdresseEmployeurCourrier.equals(m_premiereLigneAdresseEmployeurCourrier)) {
        return false;
      }
    }
    if (m_deuxiemeLigneAdresseEmployeurCourrier == null)
    {
      if (m_deuxiemeLigneAdresseEmployeurCourrier != null) {
        return false;
      }
    }
    else
    {
      if (m_deuxiemeLigneAdresseEmployeurCourrier == null) {
        return false;
      }
      if (!m_deuxiemeLigneAdresseEmployeurCourrier.equals(m_deuxiemeLigneAdresseEmployeurCourrier)) {
        return false;
      }
    }
    if (m_troisiemeLigneAdresseEmployeurCourrier == null)
    {
      if (m_troisiemeLigneAdresseEmployeurCourrier != null) {
        return false;
      }
    }
    else
    {
      if (m_troisiemeLigneAdresseEmployeurCourrier == null) {
        return false;
      }
      if (!m_troisiemeLigneAdresseEmployeurCourrier.equals(m_troisiemeLigneAdresseEmployeurCourrier)) {
        return false;
      }
    }
    if (m_quatriemeLigneAdresseEmployeurCourrier == null)
    {
      if (m_quatriemeLigneAdresseEmployeurCourrier != null) {
        return false;
      }
    }
    else
    {
      if (m_quatriemeLigneAdresseEmployeurCourrier == null) {
        return false;
      }
      if (!m_quatriemeLigneAdresseEmployeurCourrier.equals(m_quatriemeLigneAdresseEmployeurCourrier)) {
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
    if (m_formeJuridique == null)
    {
      if (m_formeJuridique != null) {
        return false;
      }
    }
    else
    {
      if (m_formeJuridique == null) {
        return false;
      }
      if (!m_formeJuridique.equals(m_formeJuridique)) {
        return false;
      }
    }
    if (m_pseudo == null)
    {
      if (m_pseudo != null) {
        return false;
      }
    }
    else
    {
      if (m_pseudo == null) {
        return false;
      }
      if (!m_pseudo.equals(m_pseudo)) {
        return false;
      }
    }
    if (m_premiereLigneAdresseIntermittentCourrier == null)
    {
      if (m_premiereLigneAdresseIntermittentCourrier != null) {
        return false;
      }
    }
    else
    {
      if (m_premiereLigneAdresseIntermittentCourrier == null) {
        return false;
      }
      if (!m_premiereLigneAdresseIntermittentCourrier.equals(m_premiereLigneAdresseIntermittentCourrier)) {
        return false;
      }
    }
    if (m_deuxiemeLigneAdresseIntermittentCourrier == null)
    {
      if (m_deuxiemeLigneAdresseIntermittentCourrier != null) {
        return false;
      }
    }
    else
    {
      if (m_deuxiemeLigneAdresseIntermittentCourrier == null) {
        return false;
      }
      if (!m_deuxiemeLigneAdresseIntermittentCourrier.equals(m_deuxiemeLigneAdresseIntermittentCourrier)) {
        return false;
      }
    }
    if (m_troisiemeLigneAdresseIntermittentCourrier == null)
    {
      if (m_troisiemeLigneAdresseIntermittentCourrier != null) {
        return false;
      }
    }
    else
    {
      if (m_troisiemeLigneAdresseIntermittentCourrier == null) {
        return false;
      }
      if (!m_troisiemeLigneAdresseIntermittentCourrier.equals(m_troisiemeLigneAdresseIntermittentCourrier)) {
        return false;
      }
    }
    if (m_quatriemeLigneAdresseIntermittentCourrier == null)
    {
      if (m_quatriemeLigneAdresseIntermittentCourrier != null) {
        return false;
      }
    }
    else
    {
      if (m_quatriemeLigneAdresseIntermittentCourrier == null) {
        return false;
      }
      if (!m_quatriemeLigneAdresseIntermittentCourrier.equals(m_quatriemeLigneAdresseIntermittentCourrier)) {
        return false;
      }
    }
    if (m_positionEmployeur == null)
    {
      if (m_positionEmployeur != null) {
        return false;
      }
    }
    else
    {
      if (m_positionEmployeur == null) {
        return false;
      }
      if (!m_positionEmployeur.equals(m_positionEmployeur)) {
        return false;
      }
    }
    if (m_positionAutreEmployeur == null)
    {
      if (m_positionAutreEmployeur != null) {
        return false;
      }
    }
    else
    {
      if (m_positionAutreEmployeur == null) {
        return false;
      }
      if (!m_positionAutreEmployeur.equals(m_positionAutreEmployeur)) {
        return false;
      }
    }
    if (m_codeAssedic == null)
    {
      if (m_codeAssedic != null) {
        return false;
      }
    }
    else
    {
      if (m_codeAssedic == null) {
        return false;
      }
      if (!m_codeAssedic.equals(m_codeAssedic)) {
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
    if (m_codeNAFBNE == null)
    {
      if (m_codeNAFBNE != null) {
        return false;
      }
    }
    else
    {
      if (m_codeNAFBNE == null) {
        return false;
      }
      if (!m_codeNAFBNE.equals(m_codeNAFBNE)) {
        return false;
      }
    }
    if (m_codeEmploiOccupe == null)
    {
      if (m_codeEmploiOccupe != null) {
        return false;
      }
    }
    else
    {
      if (m_codeEmploiOccupe == null) {
        return false;
      }
      if (!m_codeEmploiOccupe.equals(m_codeEmploiOccupe)) {
        return false;
      }
    }
    if (m_numeroObjet == null)
    {
      if (m_numeroObjet != null) {
        return false;
      }
    }
    else
    {
      if (m_numeroObjet == null) {
        return false;
      }
      if (!m_numeroObjet.equals(m_numeroObjet)) {
        return false;
      }
    }
    if (m_cadre == null)
    {
      if (m_cadre != null) {
        return false;
      }
    }
    else
    {
      if (m_cadre == null) {
        return false;
      }
      if (!m_cadre.equals(m_cadre)) {
        return false;
      }
    }
    if (m_forfaitUrssaf == null)
    {
      if (m_forfaitUrssaf != null) {
        return false;
      }
    }
    else
    {
      if (m_forfaitUrssaf == null) {
        return false;
      }
      if (!m_forfaitUrssaf.equals(m_forfaitUrssaf)) {
        return false;
      }
    }
    if (m_topAlsaceMoselle == null)
    {
      if (m_topAlsaceMoselle != null) {
        return false;
      }
    }
    else
    {
      if (m_topAlsaceMoselle == null) {
        return false;
      }
      if (!m_topAlsaceMoselle.equals(m_topAlsaceMoselle)) {
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
    if (m_dateCreation == null)
    {
      if (m_dateCreation != null) {
        return false;
      }
    }
    else
    {
      if (m_dateCreation == null) {
        return false;
      }
      if (!m_dateCreation.equals(m_dateCreation)) {
        return false;
      }
    }
    if (m_dateOrigineInformation == null)
    {
      if (m_dateOrigineInformation != null) {
        return false;
      }
    }
    else
    {
      if (m_dateOrigineInformation == null) {
        return false;
      }
      if (!m_dateOrigineInformation.equals(m_dateOrigineInformation)) {
        return false;
      }
    }
    if (m_dateCreationFeuillet == null)
    {
      if (m_dateCreationFeuillet != null) {
        return false;
      }
    }
    else
    {
      if (m_dateCreationFeuillet == null) {
        return false;
      }
      if (!m_dateCreationFeuillet.equals(m_dateCreationFeuillet)) {
        return false;
      }
    }
    if (m_nbJoursTravailles == null)
    {
      if (m_nbJoursTravailles != null) {
        return false;
      }
    }
    else
    {
      if (m_nbJoursTravailles == null) {
        return false;
      }
      if (!m_nbJoursTravailles.equals(m_nbJoursTravailles)) {
        return false;
      }
    }
    if (m_nbHeuresTravaillees == null)
    {
      if (m_nbHeuresTravaillees != null) {
        return false;
      }
    }
    else
    {
      if (m_nbHeuresTravaillees == null) {
        return false;
      }
      if (!m_nbHeuresTravaillees.equals(m_nbHeuresTravaillees)) {
        return false;
      }
    }
    if (m_nbCachets == null)
    {
      if (m_nbCachets != null) {
        return false;
      }
    }
    else
    {
      if (m_nbCachets == null) {
        return false;
      }
      if (!m_nbCachets.equals(m_nbCachets)) {
        return false;
      }
    }
    if (m_salaireBrutNonAbattu == null)
    {
      if (m_salaireBrutNonAbattu != null) {
        return false;
      }
    }
    else
    {
      if (m_salaireBrutNonAbattu == null) {
        return false;
      }
      if (!m_salaireBrutNonAbattu.equals(m_salaireBrutNonAbattu)) {
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
    if (m_numeroChrono == null)
    {
      if (m_numeroChrono != null) {
        return false;
      }
    }
    else
    {
      if (m_numeroChrono == null) {
        return false;
      }
      if (!m_numeroChrono.equals(m_numeroChrono)) {
        return false;
      }
    }
    if (m_montantIccp == null)
    {
      if (m_montantIccp != null) {
        return false;
      }
    }
    else
    {
      if (m_montantIccp == null) {
        return false;
      }
      if (!m_montantIccp.equals(m_montantIccp)) {
        return false;
      }
    }
    if (m_montantAvantageNature == null)
    {
      if (m_montantAvantageNature != null) {
        return false;
      }
    }
    else
    {
      if (m_montantAvantageNature == null) {
        return false;
      }
      if (!m_montantAvantageNature.equals(m_montantAvantageNature)) {
        return false;
      }
    }
    if (m_montantFraisProfessionnel == null)
    {
      if (m_montantFraisProfessionnel != null) {
        return false;
      }
    }
    else
    {
      if (m_montantFraisProfessionnel == null) {
        return false;
      }
      if (!m_montantFraisProfessionnel.equals(m_montantFraisProfessionnel)) {
        return false;
      }
    }
    if (m_tauxAbattement == null)
    {
      if (m_tauxAbattement != null) {
        return false;
      }
    }
    else
    {
      if (m_tauxAbattement == null) {
        return false;
      }
      if (!m_tauxAbattement.equals(m_tauxAbattement)) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int result = 0;
    if (m_codeMouvement != null) {
      result += m_codeMouvement.hashCode();
    }
    if (m_prenomEmployeur != null) {
      result += m_prenomEmployeur.hashCode();
    }
    if (m_numeroGuso != null) {
      result += m_numeroGuso.hashCode();
    }
    if (m_codeNAF != null) {
      result += m_codeNAF.hashCode();
    }
    if (m_identifiantBNI != null) {
      result += m_identifiantBNI.hashCode();
    }
    if (m_nom != null) {
      result += m_nom.hashCode();
    }
    if (m_prenom != null) {
      result += m_prenom.hashCode();
    }
    if (m_nIRIntermittent != null) {
      result += m_nIRIntermittent.hashCode();
    }
    if (m_emploiOccupe != null) {
      result += m_emploiOccupe.hashCode();
    }
    if (m_idPrestation != null) {
      result += m_idPrestation.hashCode();
    }
    if (m_natureActivite != null) {
      result += m_natureActivite.hashCode();
    }
    if (m_motifFCT != null) {
      result += m_motifFCT.hashCode();
    }
    if (m_codeDevise != null) {
      result += m_codeDevise.hashCode();
    }
    if (m_identifiantBNE != null) {
      result += m_identifiantBNE.hashCode();
    }
    if (m_siretBNE != null) {
      result += m_siretBNE.hashCode();
    }
    if (m_raisonSocialeBNE != null) {
      result += m_raisonSocialeBNE.hashCode();
    }
    if (m_numeroRueBNE != null) {
      result += m_numeroRueBNE.hashCode();
    }
    if (m_adresse1BNE != null) {
      result += m_adresse1BNE.hashCode();
    }
    if (m_adresse2BNE != null) {
      result += m_adresse2BNE.hashCode();
    }
    if (m_codePostalBNE != null) {
      result += m_codePostalBNE.hashCode();
    }
    if (m_libelleCommuneBNE != null) {
      result += m_libelleCommuneBNE.hashCode();
    }
    if (m_assedicAffiliationBNE != null) {
      result += m_assedicAffiliationBNE.hashCode();
    }
    if (m_numeroAffiliationBNE != null) {
      result += m_numeroAffiliationBNE.hashCode();
    }
    if (m_nouveauCodeNAF != null) {
      result += m_nouveauCodeNAF.hashCode();
    }
    if (m_raisonSocialeEmployeur != null) {
      result += m_raisonSocialeEmployeur.hashCode();
    }
    if (m_numeroTelephone != null) {
      result += m_numeroTelephone.hashCode();
    }
    if (m_numeroFax != null) {
      result += m_numeroFax.hashCode();
    }
    if (m_premiereLigneAdresseEmployeurCourrier != null) {
      result += m_premiereLigneAdresseEmployeurCourrier.hashCode();
    }
    if (m_deuxiemeLigneAdresseEmployeurCourrier != null) {
      result += m_deuxiemeLigneAdresseEmployeurCourrier.hashCode();
    }
    if (m_troisiemeLigneAdresseEmployeurCourrier != null) {
      result += m_troisiemeLigneAdresseEmployeurCourrier.hashCode();
    }
    if (m_quatriemeLigneAdresseEmployeurCourrier != null) {
      result += m_quatriemeLigneAdresseEmployeurCourrier.hashCode();
    }
    if (m_siret != null) {
      result += m_siret.hashCode();
    }
    if (m_formeJuridique != null) {
      result += m_formeJuridique.hashCode();
    }
    if (m_pseudo != null) {
      result += m_pseudo.hashCode();
    }
    if (m_premiereLigneAdresseIntermittentCourrier != null) {
      result += m_premiereLigneAdresseIntermittentCourrier.hashCode();
    }
    if (m_deuxiemeLigneAdresseIntermittentCourrier != null) {
      result += m_deuxiemeLigneAdresseIntermittentCourrier.hashCode();
    }
    if (m_troisiemeLigneAdresseIntermittentCourrier != null) {
      result += m_troisiemeLigneAdresseIntermittentCourrier.hashCode();
    }
    if (m_quatriemeLigneAdresseIntermittentCourrier != null) {
      result += m_quatriemeLigneAdresseIntermittentCourrier.hashCode();
    }
    if (m_positionEmployeur != null) {
      result += m_positionEmployeur.hashCode();
    }
    if (m_positionAutreEmployeur != null) {
      result += m_positionAutreEmployeur.hashCode();
    }
    if (m_codeAssedic != null) {
      result += m_codeAssedic.hashCode();
    }
    if (m_rsin != null) {
      result += m_rsin.hashCode();
    }
    if (m_codeNAFBNE != null) {
      result += m_codeNAFBNE.hashCode();
    }
    if (m_codeEmploiOccupe != null) {
      result += m_codeEmploiOccupe.hashCode();
    }
    if (m_numeroObjet != null) {
      result += m_numeroObjet.hashCode();
    }
    if (m_cadre != null) {
      result += m_cadre.hashCode();
    }
    if (m_forfaitUrssaf != null) {
      result += m_forfaitUrssaf.hashCode();
    }
    if (m_topAlsaceMoselle != null) {
      result += m_topAlsaceMoselle.hashCode();
    }
    if (m_dateDebutContrat != null) {
      result += m_dateDebutContrat.hashCode();
    }
    if (m_dateFinContrat != null) {
      result += m_dateFinContrat.hashCode();
    }
    if (m_dateCreation != null) {
      result += m_dateCreation.hashCode();
    }
    if (m_dateOrigineInformation != null) {
      result += m_dateOrigineInformation.hashCode();
    }
    if (m_dateCreationFeuillet != null) {
      result += m_dateCreationFeuillet.hashCode();
    }
    if (m_nbJoursTravailles != null) {
      result += m_nbJoursTravailles.hashCode();
    }
    if (m_nbHeuresTravaillees != null) {
      result += m_nbHeuresTravaillees.hashCode();
    }
    if (m_nbCachets != null) {
      result += m_nbCachets.hashCode();
    }
    if (m_salaireBrutNonAbattu != null) {
      result += m_salaireBrutNonAbattu.hashCode();
    }
    if (m_salaireBrutAbattu != null) {
      result += m_salaireBrutAbattu.hashCode();
    }
    if (m_numeroChrono != null) {
      result += m_numeroChrono.hashCode();
    }
    if (m_montantIccp != null) {
      result += m_montantIccp.hashCode();
    }
    if (m_montantAvantageNature != null) {
      result += m_montantAvantageNature.hashCode();
    }
    if (m_montantFraisProfessionnel != null) {
      result += m_montantFraisProfessionnel.hashCode();
    }
    if (m_tauxAbattement != null) {
      result += m_tauxAbattement.hashCode();
    }
    result *= 17;
    return result;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    _FluxGUSO clone_FluxGUSO = new _FluxGUSO();
    clone_FluxGUSO.populateFrom_FluxGUSO(this);
    return clone_FluxGUSO;
  }
  
  public void populateFrom_FluxGUSO(_FluxGUSO pSource)
  {
    setCodeMouvement(pSource.getCodeMouvement());setPrenomEmployeur(pSource.getPrenomEmployeur());setNumeroGuso(pSource.getNumeroGuso());setCodeNAF(pSource.getCodeNAF());setIdentifiantBNI(pSource.getIdentifiantBNI());setNom(pSource.getNom());setPrenom(pSource.getPrenom());setNIRIntermittent(pSource.getNIRIntermittent());setEmploiOccupe(pSource.getEmploiOccupe());setIdPrestation(pSource.getIdPrestation());setNatureActivite(pSource.getNatureActivite());setMotifFCT(pSource.getMotifFCT());setCodeDevise(pSource.getCodeDevise());setIdentifiantBNE(pSource.getIdentifiantBNE());setSiretBNE(pSource.getSiretBNE());setRaisonSocialeBNE(pSource.getRaisonSocialeBNE());setNumeroRueBNE(pSource.getNumeroRueBNE());setAdresse1BNE(pSource.getAdresse1BNE());setAdresse2BNE(pSource.getAdresse2BNE());setCodePostalBNE(pSource.getCodePostalBNE());setLibelleCommuneBNE(pSource.getLibelleCommuneBNE());setAssedicAffiliationBNE(pSource.getAssedicAffiliationBNE());setNumeroAffiliationBNE(pSource.getNumeroAffiliationBNE());setNouveauCodeNAF(pSource.getNouveauCodeNAF());setRaisonSocialeEmployeur(pSource.getRaisonSocialeEmployeur());setNumeroTelephone(pSource.getNumeroTelephone());setNumeroFax(pSource.getNumeroFax());setPremiereLigneAdresseEmployeurCourrier(pSource.getPremiereLigneAdresseEmployeurCourrier());setDeuxiemeLigneAdresseEmployeurCourrier(pSource.getDeuxiemeLigneAdresseEmployeurCourrier());setTroisiemeLigneAdresseEmployeurCourrier(pSource.getTroisiemeLigneAdresseEmployeurCourrier());setQuatriemeLigneAdresseEmployeurCourrier(pSource.getQuatriemeLigneAdresseEmployeurCourrier());setSiret(pSource.getSiret());setFormeJuridique(pSource.getFormeJuridique());setPseudo(pSource.getPseudo());setPremiereLigneAdresseIntermittentCourrier(pSource.getPremiereLigneAdresseIntermittentCourrier());setDeuxiemeLigneAdresseIntermittentCourrier(pSource.getDeuxiemeLigneAdresseIntermittentCourrier());setTroisiemeLigneAdresseIntermittentCourrier(pSource.getTroisiemeLigneAdresseIntermittentCourrier());setQuatriemeLigneAdresseIntermittentCourrier(pSource.getQuatriemeLigneAdresseIntermittentCourrier());setPositionEmployeur(pSource.getPositionEmployeur());setPositionAutreEmployeur(pSource.getPositionAutreEmployeur());setCodeAssedic(pSource.getCodeAssedic());setRsin(pSource.getRsin());setCodeNAFBNE(pSource.getCodeNAFBNE());setCodeEmploiOccupe(pSource.getCodeEmploiOccupe());setNumeroObjet(pSource.getNumeroObjet());setCadre(pSource.getCadre());setForfaitUrssaf(pSource.getForfaitUrssaf());setTopAlsaceMoselle(pSource.getTopAlsaceMoselle());setDateDebutContrat(pSource.getDateDebutContrat());setDateFinContrat(pSource.getDateFinContrat());setDateCreation(pSource.getDateCreation());setDateOrigineInformation(pSource.getDateOrigineInformation());setDateCreationFeuillet(pSource.getDateCreationFeuillet());setNbJoursTravailles(pSource.getNbJoursTravailles());setNbHeuresTravaillees(pSource.getNbHeuresTravaillees());setNbCachets(pSource.getNbCachets());setSalaireBrutNonAbattu(pSource.getSalaireBrutNonAbattu());setSalaireBrutAbattu(pSource.getSalaireBrutAbattu());setNumeroChrono(pSource.getNumeroChrono());setMontantIccp(pSource.getMontantIccp());setMontantAvantageNature(pSource.getMontantAvantageNature());setMontantFraisProfessionnel(pSource.getMontantFraisProfessionnel());setTauxAbattement(pSource.getTauxAbattement());
  }
  
  public String toString()
  {
    StringBuffer s = new StringBuffer("[_FluxGUSO");
    subToString(s);
    s.append("]");
    return s.toString();
  }
  
  protected void subToString(StringBuffer pSource)
  {
    pSource.append(", CodeMouvement: ");
    pSource.append(m_codeMouvement);
    pSource.append(", PrenomEmployeur: ");
    pSource.append(m_prenomEmployeur);
    pSource.append(", NumeroGuso: ");
    pSource.append(m_numeroGuso);
    pSource.append(", CodeNAF: ");
    pSource.append(m_codeNAF);
    pSource.append(", IdentifiantBNI: ");
    pSource.append(m_identifiantBNI);
    pSource.append(", Nom: ");
    pSource.append(m_nom);
    pSource.append(", Prenom: ");
    pSource.append(m_prenom);
    pSource.append(", NIRIntermittent: ");
    pSource.append(m_nIRIntermittent);
    pSource.append(", EmploiOccupe: ");
    pSource.append(m_emploiOccupe);
    pSource.append(", IdPrestation: ");
    pSource.append(m_idPrestation);
    pSource.append(", NatureActivite: ");
    pSource.append(m_natureActivite);
    pSource.append(", MotifFCT: ");
    pSource.append(m_motifFCT);
    pSource.append(", CodeDevise: ");
    pSource.append(m_codeDevise);
    pSource.append(", IdentifiantBNE: ");
    pSource.append(m_identifiantBNE);
    pSource.append(", SiretBNE: ");
    pSource.append(m_siretBNE);
    pSource.append(", RaisonSocialeBNE: ");
    pSource.append(m_raisonSocialeBNE);
    pSource.append(", NumeroRueBNE: ");
    pSource.append(m_numeroRueBNE);
    pSource.append(", Adresse1BNE: ");
    pSource.append(m_adresse1BNE);
    pSource.append(", Adresse2BNE: ");
    pSource.append(m_adresse2BNE);
    pSource.append(", CodePostalBNE: ");
    pSource.append(m_codePostalBNE);
    pSource.append(", LibelleCommuneBNE: ");
    pSource.append(m_libelleCommuneBNE);
    pSource.append(", AssedicAffiliationBNE: ");
    pSource.append(m_assedicAffiliationBNE);
    pSource.append(", NumeroAffiliationBNE: ");
    pSource.append(m_numeroAffiliationBNE);
    pSource.append(", NouveauCodeNAF: ");
    pSource.append(m_nouveauCodeNAF);
    pSource.append(", RaisonSocialeEmployeur: ");
    pSource.append(m_raisonSocialeEmployeur);
    pSource.append(", NumeroTelephone: ");
    pSource.append(m_numeroTelephone);
    pSource.append(", NumeroFax: ");
    pSource.append(m_numeroFax);
    pSource.append(", PremiereLigneAdresseEmployeurCourrier: ");
    pSource.append(m_premiereLigneAdresseEmployeurCourrier);
    pSource.append(", DeuxiemeLigneAdresseEmployeurCourrier: ");
    pSource.append(m_deuxiemeLigneAdresseEmployeurCourrier);
    pSource.append(", TroisiemeLigneAdresseEmployeurCourrier: ");
    pSource.append(m_troisiemeLigneAdresseEmployeurCourrier);
    pSource.append(", QuatriemeLigneAdresseEmployeurCourrier: ");
    pSource.append(m_quatriemeLigneAdresseEmployeurCourrier);
    pSource.append(", Siret: ");
    pSource.append(m_siret);
    pSource.append(", FormeJuridique: ");
    pSource.append(m_formeJuridique);
    pSource.append(", Pseudo: ");
    pSource.append(m_pseudo);
    pSource.append(", PremiereLigneAdresseIntermittentCourrier: ");
    pSource.append(m_premiereLigneAdresseIntermittentCourrier);
    pSource.append(", DeuxiemeLigneAdresseIntermittentCourrier: ");
    pSource.append(m_deuxiemeLigneAdresseIntermittentCourrier);
    pSource.append(", TroisiemeLigneAdresseIntermittentCourrier: ");
    pSource.append(m_troisiemeLigneAdresseIntermittentCourrier);
    pSource.append(", QuatriemeLigneAdresseIntermittentCourrier: ");
    pSource.append(m_quatriemeLigneAdresseIntermittentCourrier);
    pSource.append(", PositionEmployeur: ");
    pSource.append(m_positionEmployeur);
    pSource.append(", PositionAutreEmployeur: ");
    pSource.append(m_positionAutreEmployeur);
    pSource.append(", CodeAssedic: ");
    pSource.append(m_codeAssedic);
    pSource.append(", Rsin: ");
    pSource.append(m_rsin);
    pSource.append(", CodeNAFBNE: ");
    pSource.append(m_codeNAFBNE);
    pSource.append(", CodeEmploiOccupe: ");
    pSource.append(m_codeEmploiOccupe);
    pSource.append(", NumeroObjet: ");
    pSource.append(m_numeroObjet);
    pSource.append(", Cadre: ");
    pSource.append(m_cadre);
    pSource.append(", ForfaitUrssaf: ");
    pSource.append(m_forfaitUrssaf);
    pSource.append(", TopAlsaceMoselle: ");
    pSource.append(m_topAlsaceMoselle);
    pSource.append(", DateDebutContrat: ");
    pSource.append(m_dateDebutContrat);
    pSource.append(", DateFinContrat: ");
    pSource.append(m_dateFinContrat);
    pSource.append(", DateCreation: ");
    pSource.append(m_dateCreation);
    pSource.append(", DateOrigineInformation: ");
    pSource.append(m_dateOrigineInformation);
    pSource.append(", DateCreationFeuillet: ");
    pSource.append(m_dateCreationFeuillet);
    pSource.append(", NbJoursTravailles: ");
    pSource.append(m_nbJoursTravailles);
    pSource.append(", NbHeuresTravaillees: ");
    pSource.append(m_nbHeuresTravaillees);
    pSource.append(", NbCachets: ");
    pSource.append(m_nbCachets);
    pSource.append(", SalaireBrutNonAbattu: ");
    pSource.append(m_salaireBrutNonAbattu);
    pSource.append(", SalaireBrutAbattu: ");
    pSource.append(m_salaireBrutAbattu);
    pSource.append(", NumeroChrono: ");
    pSource.append(m_numeroChrono);
    pSource.append(", MontantIccp: ");
    pSource.append(m_montantIccp);
    pSource.append(", MontantAvantageNature: ");
    pSource.append(m_montantAvantageNature);
    pSource.append(", MontantFraisProfessionnel: ");
    pSource.append(m_montantFraisProfessionnel);
    pSource.append(", TauxAbattement: ");
    pSource.append(m_tauxAbattement);
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
    pHandler.property("CodeMouvement", getCodeMouvement(), new Attribute[] { new StringAttribute("C_ERR", getCodeMouvement_C_ERR()) });
    
    pHandler.property("PrenomEmployeur", getPrenomEmployeur(), new Attribute[] { new StringAttribute("C_ERR", getPrenomEmployeur_C_ERR()) });
    
    pHandler.property("NumeroGuso", getNumeroGuso(), new Attribute[] { new StringAttribute("C_ERR", getNumeroGuso_C_ERR()) });
    
    pHandler.property("CodeNAF", getCodeNAF(), new Attribute[] { new StringAttribute("C_ERR", getCodeNAF_C_ERR()) });
    
    pHandler.property("IdentifiantBNI", getIdentifiantBNI(), new Attribute[] { new StringAttribute("C_ERR", getIdentifiantBNI_C_ERR()) });
    
    pHandler.property("Nom", getNom(), new Attribute[] { new StringAttribute("C_ERR", getNom_C_ERR()) });
    
    pHandler.property("Prenom", getPrenom(), new Attribute[] { new StringAttribute("C_ERR", getPrenom_C_ERR()) });
    
    pHandler.property("NIRIntermittent", getNIRIntermittent(), new Attribute[] { new StringAttribute("C_ERR", getNIRIntermittent_C_ERR()) });
    
    pHandler.property("EmploiOccupe", getEmploiOccupe(), new Attribute[] { new StringAttribute("C_ERR", getEmploiOccupe_C_ERR()) });
    
    pHandler.property("IdPrestation", getIdPrestation(), new Attribute[] { new StringAttribute("C_ERR", getIdPrestation_C_ERR()) });
    
    pHandler.property("NatureActivite", getNatureActivite(), new Attribute[] { new StringAttribute("C_ERR", getNatureActivite_C_ERR()) });
    
    pHandler.property("MotifFCT", getMotifFCT(), new Attribute[] { new StringAttribute("C_ERR", getMotifFCT_C_ERR()) });
    
    pHandler.property("CodeDevise", getCodeDevise(), new Attribute[] { new StringAttribute("C_ERR", getCodeDevise_C_ERR()) });
    
    pHandler.property("IdentifiantBNE", getIdentifiantBNE(), new Attribute[] { new StringAttribute("C_ERR", getIdentifiantBNE_C_ERR()) });
    
    pHandler.property("SiretBNE", getSiretBNE(), new Attribute[] { new StringAttribute("C_ERR", getSiretBNE_C_ERR()) });
    
    pHandler.property("RaisonSocialeBNE", getRaisonSocialeBNE(), new Attribute[] { new StringAttribute("C_ERR", getRaisonSocialeBNE_C_ERR()) });
    
    pHandler.property("NumeroRueBNE", getNumeroRueBNE(), new Attribute[] { new StringAttribute("C_ERR", getNumeroRueBNE_C_ERR()) });
    
    pHandler.property("Adresse1BNE", getAdresse1BNE(), new Attribute[] { new StringAttribute("C_ERR", getAdresse1BNE_C_ERR()) });
    
    pHandler.property("Adresse2BNE", getAdresse2BNE(), new Attribute[] { new StringAttribute("C_ERR", getAdresse2BNE_C_ERR()) });
    
    pHandler.property("CodePostalBNE", getCodePostalBNE(), new Attribute[] { new StringAttribute("C_ERR", getCodePostalBNE_C_ERR()) });
    
    pHandler.property("LibelleCommuneBNE", getLibelleCommuneBNE(), new Attribute[] { new StringAttribute("C_ERR", getLibelleCommuneBNE_C_ERR()) });
    
    pHandler.property("AssedicAffiliationBNE", getAssedicAffiliationBNE(), new Attribute[] { new StringAttribute("C_ERR", getAssedicAffiliationBNE_C_ERR()) });
    
    pHandler.property("NumeroAffiliationBNE", getNumeroAffiliationBNE(), new Attribute[] { new StringAttribute("C_ERR", getNumeroAffiliationBNE_C_ERR()) });
    
    pHandler.property("NouveauCodeNAF", getNouveauCodeNAF(), new Attribute[] { new StringAttribute("C_ERR", getNouveauCodeNAF_C_ERR()) });
    
    pHandler.property("RaisonSocialeEmployeur", getRaisonSocialeEmployeur(), new Attribute[] { new StringAttribute("C_ERR", getRaisonSocialeEmployeur_C_ERR()) });
    
    pHandler.property("NumeroTelephone", getNumeroTelephone(), new Attribute[] { new StringAttribute("C_ERR", getNumeroTelephone_C_ERR()) });
    
    pHandler.property("NumeroFax", getNumeroFax(), new Attribute[] { new StringAttribute("C_ERR", getNumeroFax_C_ERR()) });
    
    pHandler.property("PremiereLigneAdresseEmployeurCourrier", getPremiereLigneAdresseEmployeurCourrier(), new Attribute[] { new StringAttribute("C_ERR", getPremiereLigneAdresseEmployeurCourrier_C_ERR()) });
    
    pHandler.property("DeuxiemeLigneAdresseEmployeurCourrier", getDeuxiemeLigneAdresseEmployeurCourrier(), new Attribute[] { new StringAttribute("C_ERR", getDeuxiemeLigneAdresseEmployeurCourrier_C_ERR()) });
    
    pHandler.property("TroisiemeLigneAdresseEmployeurCourrier", getTroisiemeLigneAdresseEmployeurCourrier(), new Attribute[] { new StringAttribute("C_ERR", getTroisiemeLigneAdresseEmployeurCourrier_C_ERR()) });
    
    pHandler.property("QuatriemeLigneAdresseEmployeurCourrier", getQuatriemeLigneAdresseEmployeurCourrier(), new Attribute[] { new StringAttribute("C_ERR", getQuatriemeLigneAdresseEmployeurCourrier_C_ERR()) });
    
    pHandler.property("Siret", getSiret(), new Attribute[] { new StringAttribute("C_ERR", getSiret_C_ERR()) });
    
    pHandler.property("FormeJuridique", getFormeJuridique(), new Attribute[] { new StringAttribute("C_ERR", getFormeJuridique_C_ERR()) });
    
    pHandler.property("Pseudo", getPseudo(), new Attribute[] { new StringAttribute("C_ERR", getPseudo_C_ERR()) });
    
    pHandler.property("PremiereLigneAdresseIntermittentCourrier", getPremiereLigneAdresseIntermittentCourrier(), new Attribute[] { new StringAttribute("C_ERR", getPremiereLigneAdresseIntermittentCourrier_C_ERR()) });
    
    pHandler.property("DeuxiemeLigneAdresseIntermittentCourrier", getDeuxiemeLigneAdresseIntermittentCourrier(), new Attribute[] { new StringAttribute("C_ERR", getDeuxiemeLigneAdresseIntermittentCourrier_C_ERR()) });
    
    pHandler.property("TroisiemeLigneAdresseIntermittentCourrier", getTroisiemeLigneAdresseIntermittentCourrier(), new Attribute[] { new StringAttribute("C_ERR", getTroisiemeLigneAdresseIntermittentCourrier_C_ERR()) });
    
    pHandler.property("QuatriemeLigneAdresseIntermittentCourrier", getQuatriemeLigneAdresseIntermittentCourrier(), new Attribute[] { new StringAttribute("C_ERR", getQuatriemeLigneAdresseIntermittentCourrier_C_ERR()) });
    
    pHandler.property("PositionEmployeur", getPositionEmployeur(), new Attribute[] { new StringAttribute("C_ERR", getPositionEmployeur_C_ERR()) });
    
    pHandler.property("PositionAutreEmployeur", getPositionAutreEmployeur(), new Attribute[] { new StringAttribute("C_ERR", getPositionAutreEmployeur_C_ERR()) });
    
    pHandler.property("CodeAssedic", getCodeAssedic(), new Attribute[] { new StringAttribute("C_ERR", getCodeAssedic_C_ERR()) });
    
    pHandler.property("Rsin", getRsin(), new Attribute[] { new StringAttribute("C_ERR", getRsin_C_ERR()) });
    
    pHandler.property("CodeNAFBNE", getCodeNAFBNE(), new Attribute[] { new StringAttribute("C_ERR", getCodeNAFBNE_C_ERR()) });
    
    pHandler.property("CodeEmploiOccupe", getCodeEmploiOccupe(), new Attribute[] { new StringAttribute("C_ERR", getCodeEmploiOccupe_C_ERR()) });
    
    pHandler.property("NumeroObjet", getNumeroObjet(), new Attribute[] { new StringAttribute("C_ERR", getNumeroObjet_C_ERR()) });
    
    pHandler.property("Cadre", getCadre(), new Attribute[] { new StringAttribute("C_ERR", getCadre_C_ERR()) });
    
    pHandler.property("ForfaitUrssaf", getForfaitUrssaf(), new Attribute[] { new StringAttribute("C_ERR", getForfaitUrssaf_C_ERR()) });
    
    pHandler.property("TopAlsaceMoselle", getTopAlsaceMoselle(), new Attribute[] { new StringAttribute("C_ERR", getTopAlsaceMoselle_C_ERR()) });
    
    pHandler.property("DateDebutContrat", getDateDebutContrat(), new Attribute[] { new StringAttribute("C_ERR", getDateDebutContrat_C_ERR()) });
    
    pHandler.property("DateFinContrat", getDateFinContrat(), new Attribute[] { new StringAttribute("C_ERR", getDateFinContrat_C_ERR()) });
    
    pHandler.property("DateCreation", getDateCreation(), new Attribute[] { new StringAttribute("C_ERR", getDateCreation_C_ERR()) });
    
    pHandler.property("DateOrigineInformation", getDateOrigineInformation(), new Attribute[] { new StringAttribute("C_ERR", getDateOrigineInformation_C_ERR()) });
    
    pHandler.property("DateCreationFeuillet", getDateCreationFeuillet(), new Attribute[] { new StringAttribute("C_ERR", getDateCreationFeuillet_C_ERR()) });
    
    pHandler.property("NbJoursTravailles", getNbJoursTravailles(), new Attribute[] { new StringAttribute("C_ERR", getNbJoursTravailles_C_ERR()) });
    
    pHandler.property("NbHeuresTravaillees", getNbHeuresTravaillees(), new Attribute[] { new StringAttribute("C_ERR", getNbHeuresTravaillees_C_ERR()) });
    
    pHandler.property("NbCachets", getNbCachets(), new Attribute[] { new StringAttribute("C_ERR", getNbCachets_C_ERR()) });
    
    pHandler.property("SalaireBrutNonAbattu", getSalaireBrutNonAbattu(), new Attribute[] { new StringAttribute("C_ERR", getSalaireBrutNonAbattu_C_ERR()) });
    
    pHandler.property("SalaireBrutAbattu", getSalaireBrutAbattu(), new Attribute[] { new StringAttribute("C_ERR", getSalaireBrutAbattu_C_ERR()) });
    
    pHandler.property("NumeroChrono", getNumeroChrono(), new Attribute[] { new StringAttribute("C_ERR", getNumeroChrono_C_ERR()) });
    
    pHandler.property("MontantIccp", getMontantIccp(), new Attribute[] { new StringAttribute("C_ERR", getMontantIccp_C_ERR()) });
    
    pHandler.property("MontantAvantageNature", getMontantAvantageNature(), new Attribute[] { new StringAttribute("C_ERR", getMontantAvantageNature_C_ERR()) });
    
    pHandler.property("MontantFraisProfessionnel", getMontantFraisProfessionnel(), new Attribute[] { new StringAttribute("C_ERR", getMontantFraisProfessionnel_C_ERR()) });
    
    pHandler.property("TauxAbattement", getTauxAbattement(), new Attribute[] { new StringAttribute("C_ERR", getTauxAbattement_C_ERR()) });
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
    setCodeMouvement((String)pHandler.objectProperty("CodeMouvement", String.class));
    setCodeMouvement_C_ERR(pHandler.stringAttribute("CodeMouvement", "C_ERR"));
    
    setPrenomEmployeur((String)pHandler.objectProperty("PrenomEmployeur", String.class));
    setPrenomEmployeur_C_ERR(pHandler.stringAttribute("PrenomEmployeur", "C_ERR"));
    
    setNumeroGuso((String)pHandler.objectProperty("NumeroGuso", String.class));
    setNumeroGuso_C_ERR(pHandler.stringAttribute("NumeroGuso", "C_ERR"));
    
    setCodeNAF((String)pHandler.objectProperty("CodeNAF", String.class));
    setCodeNAF_C_ERR(pHandler.stringAttribute("CodeNAF", "C_ERR"));
    
    setIdentifiantBNI((String)pHandler.objectProperty("IdentifiantBNI", String.class));
    setIdentifiantBNI_C_ERR(pHandler.stringAttribute("IdentifiantBNI", "C_ERR"));
    
    setNom((String)pHandler.objectProperty("Nom", String.class));
    setNom_C_ERR(pHandler.stringAttribute("Nom", "C_ERR"));
    
    setPrenom((String)pHandler.objectProperty("Prenom", String.class));
    setPrenom_C_ERR(pHandler.stringAttribute("Prenom", "C_ERR"));
    
    setNIRIntermittent((String)pHandler.objectProperty("NIRIntermittent", String.class));
    setNIRIntermittent_C_ERR(pHandler.stringAttribute("NIRIntermittent", "C_ERR"));
    
    setEmploiOccupe((String)pHandler.objectProperty("EmploiOccupe", String.class));
    setEmploiOccupe_C_ERR(pHandler.stringAttribute("EmploiOccupe", "C_ERR"));
    
    setIdPrestation((String)pHandler.objectProperty("IdPrestation", String.class));
    setIdPrestation_C_ERR(pHandler.stringAttribute("IdPrestation", "C_ERR"));
    
    setNatureActivite((String)pHandler.objectProperty("NatureActivite", String.class));
    setNatureActivite_C_ERR(pHandler.stringAttribute("NatureActivite", "C_ERR"));
    
    setMotifFCT((String)pHandler.objectProperty("MotifFCT", String.class));
    setMotifFCT_C_ERR(pHandler.stringAttribute("MotifFCT", "C_ERR"));
    
    setCodeDevise((String)pHandler.objectProperty("CodeDevise", String.class));
    setCodeDevise_C_ERR(pHandler.stringAttribute("CodeDevise", "C_ERR"));
    
    setIdentifiantBNE((String)pHandler.objectProperty("IdentifiantBNE", String.class));
    setIdentifiantBNE_C_ERR(pHandler.stringAttribute("IdentifiantBNE", "C_ERR"));
    
    setSiretBNE((String)pHandler.objectProperty("SiretBNE", String.class));
    setSiretBNE_C_ERR(pHandler.stringAttribute("SiretBNE", "C_ERR"));
    
    setRaisonSocialeBNE((String)pHandler.objectProperty("RaisonSocialeBNE", String.class));
    setRaisonSocialeBNE_C_ERR(pHandler.stringAttribute("RaisonSocialeBNE", "C_ERR"));
    
    setNumeroRueBNE((String)pHandler.objectProperty("NumeroRueBNE", String.class));
    setNumeroRueBNE_C_ERR(pHandler.stringAttribute("NumeroRueBNE", "C_ERR"));
    
    setAdresse1BNE((String)pHandler.objectProperty("Adresse1BNE", String.class));
    setAdresse1BNE_C_ERR(pHandler.stringAttribute("Adresse1BNE", "C_ERR"));
    
    setAdresse2BNE((String)pHandler.objectProperty("Adresse2BNE", String.class));
    setAdresse2BNE_C_ERR(pHandler.stringAttribute("Adresse2BNE", "C_ERR"));
    
    setCodePostalBNE((String)pHandler.objectProperty("CodePostalBNE", String.class));
    setCodePostalBNE_C_ERR(pHandler.stringAttribute("CodePostalBNE", "C_ERR"));
    
    setLibelleCommuneBNE((String)pHandler.objectProperty("LibelleCommuneBNE", String.class));
    setLibelleCommuneBNE_C_ERR(pHandler.stringAttribute("LibelleCommuneBNE", "C_ERR"));
    
    setAssedicAffiliationBNE((String)pHandler.objectProperty("AssedicAffiliationBNE", String.class));
    setAssedicAffiliationBNE_C_ERR(pHandler.stringAttribute("AssedicAffiliationBNE", "C_ERR"));
    
    setNumeroAffiliationBNE((String)pHandler.objectProperty("NumeroAffiliationBNE", String.class));
    setNumeroAffiliationBNE_C_ERR(pHandler.stringAttribute("NumeroAffiliationBNE", "C_ERR"));
    
    setNouveauCodeNAF((String)pHandler.objectProperty("NouveauCodeNAF", String.class));
    setNouveauCodeNAF_C_ERR(pHandler.stringAttribute("NouveauCodeNAF", "C_ERR"));
    
    setRaisonSocialeEmployeur((String)pHandler.objectProperty("RaisonSocialeEmployeur", String.class));
    setRaisonSocialeEmployeur_C_ERR(pHandler.stringAttribute("RaisonSocialeEmployeur", "C_ERR"));
    
    setNumeroTelephone((String)pHandler.objectProperty("NumeroTelephone", String.class));
    setNumeroTelephone_C_ERR(pHandler.stringAttribute("NumeroTelephone", "C_ERR"));
    
    setNumeroFax((String)pHandler.objectProperty("NumeroFax", String.class));
    setNumeroFax_C_ERR(pHandler.stringAttribute("NumeroFax", "C_ERR"));
    
    setPremiereLigneAdresseEmployeurCourrier((String)pHandler.objectProperty("PremiereLigneAdresseEmployeurCourrier", String.class));
    setPremiereLigneAdresseEmployeurCourrier_C_ERR(pHandler.stringAttribute("PremiereLigneAdresseEmployeurCourrier", "C_ERR"));
    
    setDeuxiemeLigneAdresseEmployeurCourrier((String)pHandler.objectProperty("DeuxiemeLigneAdresseEmployeurCourrier", String.class));
    setDeuxiemeLigneAdresseEmployeurCourrier_C_ERR(pHandler.stringAttribute("DeuxiemeLigneAdresseEmployeurCourrier", "C_ERR"));
    
    setTroisiemeLigneAdresseEmployeurCourrier((String)pHandler.objectProperty("TroisiemeLigneAdresseEmployeurCourrier", String.class));
    setTroisiemeLigneAdresseEmployeurCourrier_C_ERR(pHandler.stringAttribute("TroisiemeLigneAdresseEmployeurCourrier", "C_ERR"));
    
    setQuatriemeLigneAdresseEmployeurCourrier((String)pHandler.objectProperty("QuatriemeLigneAdresseEmployeurCourrier", String.class));
    setQuatriemeLigneAdresseEmployeurCourrier_C_ERR(pHandler.stringAttribute("QuatriemeLigneAdresseEmployeurCourrier", "C_ERR"));
    
    setSiret((String)pHandler.objectProperty("Siret", String.class));
    setSiret_C_ERR(pHandler.stringAttribute("Siret", "C_ERR"));
    
    setFormeJuridique((String)pHandler.objectProperty("FormeJuridique", String.class));
    setFormeJuridique_C_ERR(pHandler.stringAttribute("FormeJuridique", "C_ERR"));
    
    setPseudo((String)pHandler.objectProperty("Pseudo", String.class));
    setPseudo_C_ERR(pHandler.stringAttribute("Pseudo", "C_ERR"));
    
    setPremiereLigneAdresseIntermittentCourrier((String)pHandler.objectProperty("PremiereLigneAdresseIntermittentCourrier", String.class));
    setPremiereLigneAdresseIntermittentCourrier_C_ERR(pHandler.stringAttribute("PremiereLigneAdresseIntermittentCourrier", "C_ERR"));
    
    setDeuxiemeLigneAdresseIntermittentCourrier((String)pHandler.objectProperty("DeuxiemeLigneAdresseIntermittentCourrier", String.class));
    setDeuxiemeLigneAdresseIntermittentCourrier_C_ERR(pHandler.stringAttribute("DeuxiemeLigneAdresseIntermittentCourrier", "C_ERR"));
    
    setTroisiemeLigneAdresseIntermittentCourrier((String)pHandler.objectProperty("TroisiemeLigneAdresseIntermittentCourrier", String.class));
    setTroisiemeLigneAdresseIntermittentCourrier_C_ERR(pHandler.stringAttribute("TroisiemeLigneAdresseIntermittentCourrier", "C_ERR"));
    
    setQuatriemeLigneAdresseIntermittentCourrier((String)pHandler.objectProperty("QuatriemeLigneAdresseIntermittentCourrier", String.class));
    setQuatriemeLigneAdresseIntermittentCourrier_C_ERR(pHandler.stringAttribute("QuatriemeLigneAdresseIntermittentCourrier", "C_ERR"));
    
    setPositionEmployeur((String)pHandler.objectProperty("PositionEmployeur", String.class));
    setPositionEmployeur_C_ERR(pHandler.stringAttribute("PositionEmployeur", "C_ERR"));
    
    setPositionAutreEmployeur((String)pHandler.objectProperty("PositionAutreEmployeur", String.class));
    setPositionAutreEmployeur_C_ERR(pHandler.stringAttribute("PositionAutreEmployeur", "C_ERR"));
    
    setCodeAssedic((String)pHandler.objectProperty("CodeAssedic", String.class));
    setCodeAssedic_C_ERR(pHandler.stringAttribute("CodeAssedic", "C_ERR"));
    
    setRsin((String)pHandler.objectProperty("Rsin", String.class));
    setRsin_C_ERR(pHandler.stringAttribute("Rsin", "C_ERR"));
    
    setCodeNAFBNE((String)pHandler.objectProperty("CodeNAFBNE", String.class));
    setCodeNAFBNE_C_ERR(pHandler.stringAttribute("CodeNAFBNE", "C_ERR"));
    
    setCodeEmploiOccupe((String)pHandler.objectProperty("CodeEmploiOccupe", String.class));
    setCodeEmploiOccupe_C_ERR(pHandler.stringAttribute("CodeEmploiOccupe", "C_ERR"));
    
    setNumeroObjet((String)pHandler.objectProperty("NumeroObjet", String.class));
    setNumeroObjet_C_ERR(pHandler.stringAttribute("NumeroObjet", "C_ERR"));
    
    setCadre((String)pHandler.objectProperty("Cadre", String.class));
    setCadre_C_ERR(pHandler.stringAttribute("Cadre", "C_ERR"));
    
    setForfaitUrssaf((String)pHandler.objectProperty("ForfaitUrssaf", String.class));
    setForfaitUrssaf_C_ERR(pHandler.stringAttribute("ForfaitUrssaf", "C_ERR"));
    
    setTopAlsaceMoselle((String)pHandler.objectProperty("TopAlsaceMoselle", String.class));
    setTopAlsaceMoselle_C_ERR(pHandler.stringAttribute("TopAlsaceMoselle", "C_ERR"));
    
    setDateDebutContrat((Damj)pHandler.objectProperty("DateDebutContrat", Damj.class));
    setDateDebutContrat_C_ERR(pHandler.stringAttribute("DateDebutContrat", "C_ERR"));
    
    setDateFinContrat((Damj)pHandler.objectProperty("DateFinContrat", Damj.class));
    setDateFinContrat_C_ERR(pHandler.stringAttribute("DateFinContrat", "C_ERR"));
    
    setDateCreation((Damj)pHandler.objectProperty("DateCreation", Damj.class));
    setDateCreation_C_ERR(pHandler.stringAttribute("DateCreation", "C_ERR"));
    
    setDateOrigineInformation((Damj)pHandler.objectProperty("DateOrigineInformation", Damj.class));
    setDateOrigineInformation_C_ERR(pHandler.stringAttribute("DateOrigineInformation", "C_ERR"));
    
    setDateCreationFeuillet((Damj)pHandler.objectProperty("DateCreationFeuillet", Damj.class));
    setDateCreationFeuillet_C_ERR(pHandler.stringAttribute("DateCreationFeuillet", "C_ERR"));
    
    setNbJoursTravailles((BigDecimal)pHandler.objectProperty("NbJoursTravailles", BigDecimal.class));
    setNbJoursTravailles_C_ERR(pHandler.stringAttribute("NbJoursTravailles", "C_ERR"));
    
    setNbHeuresTravaillees((BigDecimal)pHandler.objectProperty("NbHeuresTravaillees", BigDecimal.class));
    setNbHeuresTravaillees_C_ERR(pHandler.stringAttribute("NbHeuresTravaillees", "C_ERR"));
    
    setNbCachets((BigDecimal)pHandler.objectProperty("NbCachets", BigDecimal.class));
    setNbCachets_C_ERR(pHandler.stringAttribute("NbCachets", "C_ERR"));
    
    setSalaireBrutNonAbattu((BigDecimal)pHandler.objectProperty("SalaireBrutNonAbattu", BigDecimal.class));
    setSalaireBrutNonAbattu_C_ERR(pHandler.stringAttribute("SalaireBrutNonAbattu", "C_ERR"));
    
    setSalaireBrutAbattu((BigDecimal)pHandler.objectProperty("SalaireBrutAbattu", BigDecimal.class));
    setSalaireBrutAbattu_C_ERR(pHandler.stringAttribute("SalaireBrutAbattu", "C_ERR"));
    
    setNumeroChrono((BigDecimal)pHandler.objectProperty("NumeroChrono", BigDecimal.class));
    setNumeroChrono_C_ERR(pHandler.stringAttribute("NumeroChrono", "C_ERR"));
    
    setMontantIccp((BigDecimal)pHandler.objectProperty("MontantIccp", BigDecimal.class));
    setMontantIccp_C_ERR(pHandler.stringAttribute("MontantIccp", "C_ERR"));
    
    setMontantAvantageNature((BigDecimal)pHandler.objectProperty("MontantAvantageNature", BigDecimal.class));
    setMontantAvantageNature_C_ERR(pHandler.stringAttribute("MontantAvantageNature", "C_ERR"));
    
    setMontantFraisProfessionnel((BigDecimal)pHandler.objectProperty("MontantFraisProfessionnel", BigDecimal.class));
    setMontantFraisProfessionnel_C_ERR(pHandler.stringAttribute("MontantFraisProfessionnel", "C_ERR"));
    
    setTauxAbattement((BigDecimal)pHandler.objectProperty("TauxAbattement", BigDecimal.class));
    setTauxAbattement_C_ERR(pHandler.stringAttribute("TauxAbattement", "C_ERR"));
  }
  
  public String _getDatabeanName()
  {
    return "FluxGUSO";
  }
  
  public boolean _isValidProperty(String pElementName)
  {
    if ("CodeMouvement".equals(pElementName)) {
      return true;
    }
    if ("PrenomEmployeur".equals(pElementName)) {
      return true;
    }
    if ("NumeroGuso".equals(pElementName)) {
      return true;
    }
    if ("CodeNAF".equals(pElementName)) {
      return true;
    }
    if ("IdentifiantBNI".equals(pElementName)) {
      return true;
    }
    if ("Nom".equals(pElementName)) {
      return true;
    }
    if ("Prenom".equals(pElementName)) {
      return true;
    }
    if ("NIRIntermittent".equals(pElementName)) {
      return true;
    }
    if ("EmploiOccupe".equals(pElementName)) {
      return true;
    }
    if ("IdPrestation".equals(pElementName)) {
      return true;
    }
    if ("NatureActivite".equals(pElementName)) {
      return true;
    }
    if ("MotifFCT".equals(pElementName)) {
      return true;
    }
    if ("CodeDevise".equals(pElementName)) {
      return true;
    }
    if ("IdentifiantBNE".equals(pElementName)) {
      return true;
    }
    if ("SiretBNE".equals(pElementName)) {
      return true;
    }
    if ("RaisonSocialeBNE".equals(pElementName)) {
      return true;
    }
    if ("NumeroRueBNE".equals(pElementName)) {
      return true;
    }
    if ("Adresse1BNE".equals(pElementName)) {
      return true;
    }
    if ("Adresse2BNE".equals(pElementName)) {
      return true;
    }
    if ("CodePostalBNE".equals(pElementName)) {
      return true;
    }
    if ("LibelleCommuneBNE".equals(pElementName)) {
      return true;
    }
    if ("AssedicAffiliationBNE".equals(pElementName)) {
      return true;
    }
    if ("NumeroAffiliationBNE".equals(pElementName)) {
      return true;
    }
    if ("NouveauCodeNAF".equals(pElementName)) {
      return true;
    }
    if ("RaisonSocialeEmployeur".equals(pElementName)) {
      return true;
    }
    if ("NumeroTelephone".equals(pElementName)) {
      return true;
    }
    if ("NumeroFax".equals(pElementName)) {
      return true;
    }
    if ("PremiereLigneAdresseEmployeurCourrier".equals(pElementName)) {
      return true;
    }
    if ("DeuxiemeLigneAdresseEmployeurCourrier".equals(pElementName)) {
      return true;
    }
    if ("TroisiemeLigneAdresseEmployeurCourrier".equals(pElementName)) {
      return true;
    }
    if ("QuatriemeLigneAdresseEmployeurCourrier".equals(pElementName)) {
      return true;
    }
    if ("Siret".equals(pElementName)) {
      return true;
    }
    if ("FormeJuridique".equals(pElementName)) {
      return true;
    }
    if ("Pseudo".equals(pElementName)) {
      return true;
    }
    if ("PremiereLigneAdresseIntermittentCourrier".equals(pElementName)) {
      return true;
    }
    if ("DeuxiemeLigneAdresseIntermittentCourrier".equals(pElementName)) {
      return true;
    }
    if ("TroisiemeLigneAdresseIntermittentCourrier".equals(pElementName)) {
      return true;
    }
    if ("QuatriemeLigneAdresseIntermittentCourrier".equals(pElementName)) {
      return true;
    }
    if ("PositionEmployeur".equals(pElementName)) {
      return true;
    }
    if ("PositionAutreEmployeur".equals(pElementName)) {
      return true;
    }
    if ("CodeAssedic".equals(pElementName)) {
      return true;
    }
    if ("Rsin".equals(pElementName)) {
      return true;
    }
    if ("CodeNAFBNE".equals(pElementName)) {
      return true;
    }
    if ("CodeEmploiOccupe".equals(pElementName)) {
      return true;
    }
    if ("NumeroObjet".equals(pElementName)) {
      return true;
    }
    if ("Cadre".equals(pElementName)) {
      return true;
    }
    if ("ForfaitUrssaf".equals(pElementName)) {
      return true;
    }
    if ("TopAlsaceMoselle".equals(pElementName)) {
      return true;
    }
    if ("DateDebutContrat".equals(pElementName)) {
      return true;
    }
    if ("DateFinContrat".equals(pElementName)) {
      return true;
    }
    if ("DateCreation".equals(pElementName)) {
      return true;
    }
    if ("DateOrigineInformation".equals(pElementName)) {
      return true;
    }
    if ("DateCreationFeuillet".equals(pElementName)) {
      return true;
    }
    if ("NbJoursTravailles".equals(pElementName)) {
      return true;
    }
    if ("NbHeuresTravaillees".equals(pElementName)) {
      return true;
    }
    if ("NbCachets".equals(pElementName)) {
      return true;
    }
    if ("SalaireBrutNonAbattu".equals(pElementName)) {
      return true;
    }
    if ("SalaireBrutAbattu".equals(pElementName)) {
      return true;
    }
    if ("NumeroChrono".equals(pElementName)) {
      return true;
    }
    if ("MontantIccp".equals(pElementName)) {
      return true;
    }
    if ("MontantAvantageNature".equals(pElementName)) {
      return true;
    }
    if ("MontantFraisProfessionnel".equals(pElementName)) {
      return true;
    }
    if ("TauxAbattement".equals(pElementName)) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _FluxGUSO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */