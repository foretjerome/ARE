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

public class _FluxDMM
  extends DataBeanImpl
  implements DataBean, Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  private String m__C_ETAT;
  private String m__IDENT;
  private String m_nir;
  private String m_nir_C_ERR;
  private String m_nom;
  private String m_nom_C_ERR;
  private String m_prenom;
  private String m_prenom_C_ERR;
  private String m_codeNationalite;
  private String m_codeNationalite_C_ERR;
  private String m_codePostal;
  private String m_codePostal_C_ERR;
  private String m_identifiantBNE;
  private String m_identifiantBNE_C_ERR;
  private String m_siret;
  private String m_siret_C_ERR;
  private String m_raisonSociale;
  private String m_raisonSociale_C_ERR;
  private String m_numeroVoie;
  private String m_numeroVoie_C_ERR;
  private String m_libelleVoie;
  private String m_libelleVoie_C_ERR;
  private String m_complementAdresse;
  private String m_complementAdresse_C_ERR;
  private String m_codePostalETT;
  private String m_codePostalETT_C_ERR;
  private String m_libelleCommuneCNAVTS;
  private String m_libelleCommuneCNAVTS_C_ERR;
  private String m_indicateurRappelSalaire;
  private String m_indicateurRappelSalaire_C_ERR;
  private String m_codeMonnaie;
  private String m_codeMonnaie_C_ERR;
  private String m_motifFinContrat;
  private String m_motifFinContrat_C_ERR;
  private String m_numeroContrat;
  private String m_numeroContrat_C_ERR;
  private String m_caisseAgirc;
  private String m_caisseAgirc_C_ERR;
  private String m_caisseArrco;
  private String m_caisseArrco_C_ERR;
  private String m_cadre;
  private String m_cadre_C_ERR;
  private String m_dernierEmploiTenu;
  private String m_dernierEmploiTenu_C_ERR;
  private String m_niveauQualification;
  private String m_niveauQualification_C_ERR;
  private String m_indicateurQualiteNIR;
  private String m_indicateurQualiteNIR_C_ERR;
  private String m_lieuMission;
  private String m_lieuMission_C_ERR;
  private String m_filler;
  private String m_filler_C_ERR;
  private String m_bneSiret;
  private String m_bneSiret_C_ERR;
  private String m_bneRaisonSociale;
  private String m_bneRaisonSociale_C_ERR;
  private String m_bneNumeroVoirie;
  private String m_bneNumeroVoirie_C_ERR;
  private String m_bneLibelleVoieAdresse;
  private String m_bneLibelleVoieAdresse_C_ERR;
  private String m_bneComplAdresse;
  private String m_bneComplAdresse_C_ERR;
  private String m_bneCodePostal;
  private String m_bneCodePostal_C_ERR;
  private String m_bneLibelleCommune;
  private String m_bneLibelleCommune_C_ERR;
  private String m_bneAssedicAffiliation;
  private String m_bneAssedicAffiliation_C_ERR;
  private String m_bneNumAffiliation;
  private String m_bneNumAffiliation_C_ERR;
  private String m_bneRetraiteAgirc1;
  private String m_bneRetraiteAgirc1_C_ERR;
  private String m_bneRetraiteAgirc2;
  private String m_bneRetraiteAgirc2_C_ERR;
  private String m_bneLibelleRetraiteAgirc1;
  private String m_bneLibelleRetraiteAgirc1_C_ERR;
  private String m_bneLibelleRetraiteAgirc2;
  private String m_bneLibelleRetraiteAgirc2_C_ERR;
  private String m_bneIdentifiantBne;
  private String m_bneIdentifiantBne_C_ERR;
  private String m_indicateurMontantIccp;
  private String m_indicateurMontantIccp_C_ERR;
  private String m_indicateurMotifFinContrat;
  private String m_indicateurMotifFinContrat_C_ERR;
  private String m_indicateurNombreHeuresMision;
  private String m_indicateurNombreHeuresMision_C_ERR;
  private String m_indicateurMontantIfm;
  private String m_indicateurMontantIfm_C_ERR;
  private String m_indicateurRappelMission;
  private String m_indicateurRappelMission_C_ERR;
  private String m_indicateurNouveauProtocole;
  private String m_indicateurNouveauProtocole_C_ERR;
  private String m_numeroDocument;
  private String m_numeroDocument_C_ERR;
  private Damj m_dateNaissance;
  private String m_dateNaissance_C_ERR;
  private Damj m_dateDebutPeriode;
  private String m_dateDebutPeriode_C_ERR;
  private Damj m_dateFinPeriode;
  private String m_dateFinPeriode_C_ERR;
  private Damj m_dateFichierExterne;
  private String m_dateFichierExterne_C_ERR;
  private Damj m_dateTraitement;
  private String m_dateTraitement_C_ERR;
  private BigDecimal m_sieclePeriodeRef;
  private String m_sieclePeriodeRef_C_ERR;
  private BigDecimal m_moisPeriodeRef;
  private String m_moisPeriodeRef_C_ERR;
  private BigDecimal m_salaireBrut;
  private String m_salaireBrut_C_ERR;
  private BigDecimal m_montantIccp;
  private String m_montantIccp_C_ERR;
  private BigDecimal m_nombreHeuresMission;
  private String m_nombreHeuresMission_C_ERR;
  private BigDecimal m_montantIfm;
  private String m_montantIfm_C_ERR;
  
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
  
  public String getNir()
  {
    return m_nir;
  }
  
  public String getNir_C_ERR()
  {
    return m_nir_C_ERR;
  }
  
  public void setNir(String pValeur)
  {
    m_nir = pValeur;
  }
  
  public void setNir_C_ERR(String pValeur_C_ERR)
  {
    m_nir_C_ERR = pValeur_C_ERR;
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
  
  public String getCodeNationalite()
  {
    return m_codeNationalite;
  }
  
  public String getCodeNationalite_C_ERR()
  {
    return m_codeNationalite_C_ERR;
  }
  
  public void setCodeNationalite(String pValeur)
  {
    m_codeNationalite = pValeur;
  }
  
  public void setCodeNationalite_C_ERR(String pValeur_C_ERR)
  {
    m_codeNationalite_C_ERR = pValeur_C_ERR;
  }
  
  public String getCodePostal()
  {
    return m_codePostal;
  }
  
  public String getCodePostal_C_ERR()
  {
    return m_codePostal_C_ERR;
  }
  
  public void setCodePostal(String pValeur)
  {
    m_codePostal = pValeur;
  }
  
  public void setCodePostal_C_ERR(String pValeur_C_ERR)
  {
    m_codePostal_C_ERR = pValeur_C_ERR;
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
  
  public String getRaisonSociale()
  {
    return m_raisonSociale;
  }
  
  public String getRaisonSociale_C_ERR()
  {
    return m_raisonSociale_C_ERR;
  }
  
  public void setRaisonSociale(String pValeur)
  {
    m_raisonSociale = pValeur;
  }
  
  public void setRaisonSociale_C_ERR(String pValeur_C_ERR)
  {
    m_raisonSociale_C_ERR = pValeur_C_ERR;
  }
  
  public String getNumeroVoie()
  {
    return m_numeroVoie;
  }
  
  public String getNumeroVoie_C_ERR()
  {
    return m_numeroVoie_C_ERR;
  }
  
  public void setNumeroVoie(String pValeur)
  {
    m_numeroVoie = pValeur;
  }
  
  public void setNumeroVoie_C_ERR(String pValeur_C_ERR)
  {
    m_numeroVoie_C_ERR = pValeur_C_ERR;
  }
  
  public String getLibelleVoie()
  {
    return m_libelleVoie;
  }
  
  public String getLibelleVoie_C_ERR()
  {
    return m_libelleVoie_C_ERR;
  }
  
  public void setLibelleVoie(String pValeur)
  {
    m_libelleVoie = pValeur;
  }
  
  public void setLibelleVoie_C_ERR(String pValeur_C_ERR)
  {
    m_libelleVoie_C_ERR = pValeur_C_ERR;
  }
  
  public String getComplementAdresse()
  {
    return m_complementAdresse;
  }
  
  public String getComplementAdresse_C_ERR()
  {
    return m_complementAdresse_C_ERR;
  }
  
  public void setComplementAdresse(String pValeur)
  {
    m_complementAdresse = pValeur;
  }
  
  public void setComplementAdresse_C_ERR(String pValeur_C_ERR)
  {
    m_complementAdresse_C_ERR = pValeur_C_ERR;
  }
  
  public String getCodePostalETT()
  {
    return m_codePostalETT;
  }
  
  public String getCodePostalETT_C_ERR()
  {
    return m_codePostalETT_C_ERR;
  }
  
  public void setCodePostalETT(String pValeur)
  {
    m_codePostalETT = pValeur;
  }
  
  public void setCodePostalETT_C_ERR(String pValeur_C_ERR)
  {
    m_codePostalETT_C_ERR = pValeur_C_ERR;
  }
  
  public String getLibelleCommuneCNAVTS()
  {
    return m_libelleCommuneCNAVTS;
  }
  
  public String getLibelleCommuneCNAVTS_C_ERR()
  {
    return m_libelleCommuneCNAVTS_C_ERR;
  }
  
  public void setLibelleCommuneCNAVTS(String pValeur)
  {
    m_libelleCommuneCNAVTS = pValeur;
  }
  
  public void setLibelleCommuneCNAVTS_C_ERR(String pValeur_C_ERR)
  {
    m_libelleCommuneCNAVTS_C_ERR = pValeur_C_ERR;
  }
  
  public String getIndicateurRappelSalaire()
  {
    return m_indicateurRappelSalaire;
  }
  
  public String getIndicateurRappelSalaire_C_ERR()
  {
    return m_indicateurRappelSalaire_C_ERR;
  }
  
  public void setIndicateurRappelSalaire(String pValeur)
  {
    m_indicateurRappelSalaire = pValeur;
  }
  
  public void setIndicateurRappelSalaire_C_ERR(String pValeur_C_ERR)
  {
    m_indicateurRappelSalaire_C_ERR = pValeur_C_ERR;
  }
  
  public String getCodeMonnaie()
  {
    return m_codeMonnaie;
  }
  
  public String getCodeMonnaie_C_ERR()
  {
    return m_codeMonnaie_C_ERR;
  }
  
  public void setCodeMonnaie(String pValeur)
  {
    m_codeMonnaie = pValeur;
  }
  
  public void setCodeMonnaie_C_ERR(String pValeur_C_ERR)
  {
    m_codeMonnaie_C_ERR = pValeur_C_ERR;
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
  
  public String getNumeroContrat()
  {
    return m_numeroContrat;
  }
  
  public String getNumeroContrat_C_ERR()
  {
    return m_numeroContrat_C_ERR;
  }
  
  public void setNumeroContrat(String pValeur)
  {
    m_numeroContrat = pValeur;
  }
  
  public void setNumeroContrat_C_ERR(String pValeur_C_ERR)
  {
    m_numeroContrat_C_ERR = pValeur_C_ERR;
  }
  
  public String getCaisseAgirc()
  {
    return m_caisseAgirc;
  }
  
  public String getCaisseAgirc_C_ERR()
  {
    return m_caisseAgirc_C_ERR;
  }
  
  public void setCaisseAgirc(String pValeur)
  {
    m_caisseAgirc = pValeur;
  }
  
  public void setCaisseAgirc_C_ERR(String pValeur_C_ERR)
  {
    m_caisseAgirc_C_ERR = pValeur_C_ERR;
  }
  
  public String getCaisseArrco()
  {
    return m_caisseArrco;
  }
  
  public String getCaisseArrco_C_ERR()
  {
    return m_caisseArrco_C_ERR;
  }
  
  public void setCaisseArrco(String pValeur)
  {
    m_caisseArrco = pValeur;
  }
  
  public void setCaisseArrco_C_ERR(String pValeur_C_ERR)
  {
    m_caisseArrco_C_ERR = pValeur_C_ERR;
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
  
  public String getDernierEmploiTenu()
  {
    return m_dernierEmploiTenu;
  }
  
  public String getDernierEmploiTenu_C_ERR()
  {
    return m_dernierEmploiTenu_C_ERR;
  }
  
  public void setDernierEmploiTenu(String pValeur)
  {
    m_dernierEmploiTenu = pValeur;
  }
  
  public void setDernierEmploiTenu_C_ERR(String pValeur_C_ERR)
  {
    m_dernierEmploiTenu_C_ERR = pValeur_C_ERR;
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
  
  public String getIndicateurQualiteNIR()
  {
    return m_indicateurQualiteNIR;
  }
  
  public String getIndicateurQualiteNIR_C_ERR()
  {
    return m_indicateurQualiteNIR_C_ERR;
  }
  
  public void setIndicateurQualiteNIR(String pValeur)
  {
    m_indicateurQualiteNIR = pValeur;
  }
  
  public void setIndicateurQualiteNIR_C_ERR(String pValeur_C_ERR)
  {
    m_indicateurQualiteNIR_C_ERR = pValeur_C_ERR;
  }
  
  public String getLieuMission()
  {
    return m_lieuMission;
  }
  
  public String getLieuMission_C_ERR()
  {
    return m_lieuMission_C_ERR;
  }
  
  public void setLieuMission(String pValeur)
  {
    m_lieuMission = pValeur;
  }
  
  public void setLieuMission_C_ERR(String pValeur_C_ERR)
  {
    m_lieuMission_C_ERR = pValeur_C_ERR;
  }
  
  public String getFiller()
  {
    return m_filler;
  }
  
  public String getFiller_C_ERR()
  {
    return m_filler_C_ERR;
  }
  
  public void setFiller(String pValeur)
  {
    m_filler = pValeur;
  }
  
  public void setFiller_C_ERR(String pValeur_C_ERR)
  {
    m_filler_C_ERR = pValeur_C_ERR;
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
  
  public String getBneNumeroVoirie()
  {
    return m_bneNumeroVoirie;
  }
  
  public String getBneNumeroVoirie_C_ERR()
  {
    return m_bneNumeroVoirie_C_ERR;
  }
  
  public void setBneNumeroVoirie(String pValeur)
  {
    m_bneNumeroVoirie = pValeur;
  }
  
  public void setBneNumeroVoirie_C_ERR(String pValeur_C_ERR)
  {
    m_bneNumeroVoirie_C_ERR = pValeur_C_ERR;
  }
  
  public String getBneLibelleVoieAdresse()
  {
    return m_bneLibelleVoieAdresse;
  }
  
  public String getBneLibelleVoieAdresse_C_ERR()
  {
    return m_bneLibelleVoieAdresse_C_ERR;
  }
  
  public void setBneLibelleVoieAdresse(String pValeur)
  {
    m_bneLibelleVoieAdresse = pValeur;
  }
  
  public void setBneLibelleVoieAdresse_C_ERR(String pValeur_C_ERR)
  {
    m_bneLibelleVoieAdresse_C_ERR = pValeur_C_ERR;
  }
  
  public String getBneComplAdresse()
  {
    return m_bneComplAdresse;
  }
  
  public String getBneComplAdresse_C_ERR()
  {
    return m_bneComplAdresse_C_ERR;
  }
  
  public void setBneComplAdresse(String pValeur)
  {
    m_bneComplAdresse = pValeur;
  }
  
  public void setBneComplAdresse_C_ERR(String pValeur_C_ERR)
  {
    m_bneComplAdresse_C_ERR = pValeur_C_ERR;
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
  
  public String getBneLibelleCommune()
  {
    return m_bneLibelleCommune;
  }
  
  public String getBneLibelleCommune_C_ERR()
  {
    return m_bneLibelleCommune_C_ERR;
  }
  
  public void setBneLibelleCommune(String pValeur)
  {
    m_bneLibelleCommune = pValeur;
  }
  
  public void setBneLibelleCommune_C_ERR(String pValeur_C_ERR)
  {
    m_bneLibelleCommune_C_ERR = pValeur_C_ERR;
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
  
  public String getBneRetraiteAgirc1()
  {
    return m_bneRetraiteAgirc1;
  }
  
  public String getBneRetraiteAgirc1_C_ERR()
  {
    return m_bneRetraiteAgirc1_C_ERR;
  }
  
  public void setBneRetraiteAgirc1(String pValeur)
  {
    m_bneRetraiteAgirc1 = pValeur;
  }
  
  public void setBneRetraiteAgirc1_C_ERR(String pValeur_C_ERR)
  {
    m_bneRetraiteAgirc1_C_ERR = pValeur_C_ERR;
  }
  
  public String getBneRetraiteAgirc2()
  {
    return m_bneRetraiteAgirc2;
  }
  
  public String getBneRetraiteAgirc2_C_ERR()
  {
    return m_bneRetraiteAgirc2_C_ERR;
  }
  
  public void setBneRetraiteAgirc2(String pValeur)
  {
    m_bneRetraiteAgirc2 = pValeur;
  }
  
  public void setBneRetraiteAgirc2_C_ERR(String pValeur_C_ERR)
  {
    m_bneRetraiteAgirc2_C_ERR = pValeur_C_ERR;
  }
  
  public String getBneLibelleRetraiteAgirc1()
  {
    return m_bneLibelleRetraiteAgirc1;
  }
  
  public String getBneLibelleRetraiteAgirc1_C_ERR()
  {
    return m_bneLibelleRetraiteAgirc1_C_ERR;
  }
  
  public void setBneLibelleRetraiteAgirc1(String pValeur)
  {
    m_bneLibelleRetraiteAgirc1 = pValeur;
  }
  
  public void setBneLibelleRetraiteAgirc1_C_ERR(String pValeur_C_ERR)
  {
    m_bneLibelleRetraiteAgirc1_C_ERR = pValeur_C_ERR;
  }
  
  public String getBneLibelleRetraiteAgirc2()
  {
    return m_bneLibelleRetraiteAgirc2;
  }
  
  public String getBneLibelleRetraiteAgirc2_C_ERR()
  {
    return m_bneLibelleRetraiteAgirc2_C_ERR;
  }
  
  public void setBneLibelleRetraiteAgirc2(String pValeur)
  {
    m_bneLibelleRetraiteAgirc2 = pValeur;
  }
  
  public void setBneLibelleRetraiteAgirc2_C_ERR(String pValeur_C_ERR)
  {
    m_bneLibelleRetraiteAgirc2_C_ERR = pValeur_C_ERR;
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
  
  public String getIndicateurMontantIccp()
  {
    return m_indicateurMontantIccp;
  }
  
  public String getIndicateurMontantIccp_C_ERR()
  {
    return m_indicateurMontantIccp_C_ERR;
  }
  
  public void setIndicateurMontantIccp(String pValeur)
  {
    m_indicateurMontantIccp = pValeur;
  }
  
  public void setIndicateurMontantIccp_C_ERR(String pValeur_C_ERR)
  {
    m_indicateurMontantIccp_C_ERR = pValeur_C_ERR;
  }
  
  public String getIndicateurMotifFinContrat()
  {
    return m_indicateurMotifFinContrat;
  }
  
  public String getIndicateurMotifFinContrat_C_ERR()
  {
    return m_indicateurMotifFinContrat_C_ERR;
  }
  
  public void setIndicateurMotifFinContrat(String pValeur)
  {
    m_indicateurMotifFinContrat = pValeur;
  }
  
  public void setIndicateurMotifFinContrat_C_ERR(String pValeur_C_ERR)
  {
    m_indicateurMotifFinContrat_C_ERR = pValeur_C_ERR;
  }
  
  public String getIndicateurNombreHeuresMision()
  {
    return m_indicateurNombreHeuresMision;
  }
  
  public String getIndicateurNombreHeuresMision_C_ERR()
  {
    return m_indicateurNombreHeuresMision_C_ERR;
  }
  
  public void setIndicateurNombreHeuresMision(String pValeur)
  {
    m_indicateurNombreHeuresMision = pValeur;
  }
  
  public void setIndicateurNombreHeuresMision_C_ERR(String pValeur_C_ERR)
  {
    m_indicateurNombreHeuresMision_C_ERR = pValeur_C_ERR;
  }
  
  public String getIndicateurMontantIfm()
  {
    return m_indicateurMontantIfm;
  }
  
  public String getIndicateurMontantIfm_C_ERR()
  {
    return m_indicateurMontantIfm_C_ERR;
  }
  
  public void setIndicateurMontantIfm(String pValeur)
  {
    m_indicateurMontantIfm = pValeur;
  }
  
  public void setIndicateurMontantIfm_C_ERR(String pValeur_C_ERR)
  {
    m_indicateurMontantIfm_C_ERR = pValeur_C_ERR;
  }
  
  public String getIndicateurRappelMission()
  {
    return m_indicateurRappelMission;
  }
  
  public String getIndicateurRappelMission_C_ERR()
  {
    return m_indicateurRappelMission_C_ERR;
  }
  
  public void setIndicateurRappelMission(String pValeur)
  {
    m_indicateurRappelMission = pValeur;
  }
  
  public void setIndicateurRappelMission_C_ERR(String pValeur_C_ERR)
  {
    m_indicateurRappelMission_C_ERR = pValeur_C_ERR;
  }
  
  public String getIndicateurNouveauProtocole()
  {
    return m_indicateurNouveauProtocole;
  }
  
  public String getIndicateurNouveauProtocole_C_ERR()
  {
    return m_indicateurNouveauProtocole_C_ERR;
  }
  
  public void setIndicateurNouveauProtocole(String pValeur)
  {
    m_indicateurNouveauProtocole = pValeur;
  }
  
  public void setIndicateurNouveauProtocole_C_ERR(String pValeur_C_ERR)
  {
    m_indicateurNouveauProtocole_C_ERR = pValeur_C_ERR;
  }
  
  public String getNumeroDocument()
  {
    return m_numeroDocument;
  }
  
  public String getNumeroDocument_C_ERR()
  {
    return m_numeroDocument_C_ERR;
  }
  
  public void setNumeroDocument(String pValeur)
  {
    m_numeroDocument = pValeur;
  }
  
  public void setNumeroDocument_C_ERR(String pValeur_C_ERR)
  {
    m_numeroDocument_C_ERR = pValeur_C_ERR;
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
  
  public Damj getDateDebutPeriode()
  {
    return m_dateDebutPeriode;
  }
  
  public String getDateDebutPeriode_C_ERR()
  {
    return m_dateDebutPeriode_C_ERR;
  }
  
  public void setDateDebutPeriode(Damj pValeur)
  {
    m_dateDebutPeriode = pValeur;
  }
  
  public void setDateDebutPeriode_C_ERR(String pValeur_C_ERR)
  {
    m_dateDebutPeriode_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDateFinPeriode()
  {
    return m_dateFinPeriode;
  }
  
  public String getDateFinPeriode_C_ERR()
  {
    return m_dateFinPeriode_C_ERR;
  }
  
  public void setDateFinPeriode(Damj pValeur)
  {
    m_dateFinPeriode = pValeur;
  }
  
  public void setDateFinPeriode_C_ERR(String pValeur_C_ERR)
  {
    m_dateFinPeriode_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDateFichierExterne()
  {
    return m_dateFichierExterne;
  }
  
  public String getDateFichierExterne_C_ERR()
  {
    return m_dateFichierExterne_C_ERR;
  }
  
  public void setDateFichierExterne(Damj pValeur)
  {
    m_dateFichierExterne = pValeur;
  }
  
  public void setDateFichierExterne_C_ERR(String pValeur_C_ERR)
  {
    m_dateFichierExterne_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDateTraitement()
  {
    return m_dateTraitement;
  }
  
  public String getDateTraitement_C_ERR()
  {
    return m_dateTraitement_C_ERR;
  }
  
  public void setDateTraitement(Damj pValeur)
  {
    m_dateTraitement = pValeur;
  }
  
  public void setDateTraitement_C_ERR(String pValeur_C_ERR)
  {
    m_dateTraitement_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getSieclePeriodeRef()
  {
    return m_sieclePeriodeRef;
  }
  
  public String getSieclePeriodeRef_C_ERR()
  {
    return m_sieclePeriodeRef_C_ERR;
  }
  
  public void setSieclePeriodeRef(BigDecimal pValeur)
  {
    m_sieclePeriodeRef = pValeur;
  }
  
  public void setSieclePeriodeRef_C_ERR(String pValeur_C_ERR)
  {
    m_sieclePeriodeRef_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getMoisPeriodeRef()
  {
    return m_moisPeriodeRef;
  }
  
  public String getMoisPeriodeRef_C_ERR()
  {
    return m_moisPeriodeRef_C_ERR;
  }
  
  public void setMoisPeriodeRef(BigDecimal pValeur)
  {
    m_moisPeriodeRef = pValeur;
  }
  
  public void setMoisPeriodeRef_C_ERR(String pValeur_C_ERR)
  {
    m_moisPeriodeRef_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getSalaireBrut()
  {
    return m_salaireBrut;
  }
  
  public String getSalaireBrut_C_ERR()
  {
    return m_salaireBrut_C_ERR;
  }
  
  public void setSalaireBrut(BigDecimal pValeur)
  {
    m_salaireBrut = pValeur;
  }
  
  public void setSalaireBrut_C_ERR(String pValeur_C_ERR)
  {
    m_salaireBrut_C_ERR = pValeur_C_ERR;
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
  
  public BigDecimal getNombreHeuresMission()
  {
    return m_nombreHeuresMission;
  }
  
  public String getNombreHeuresMission_C_ERR()
  {
    return m_nombreHeuresMission_C_ERR;
  }
  
  public void setNombreHeuresMission(BigDecimal pValeur)
  {
    m_nombreHeuresMission = pValeur;
  }
  
  public void setNombreHeuresMission_C_ERR(String pValeur_C_ERR)
  {
    m_nombreHeuresMission_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getMontantIfm()
  {
    return m_montantIfm;
  }
  
  public String getMontantIfm_C_ERR()
  {
    return m_montantIfm_C_ERR;
  }
  
  public void setMontantIfm(BigDecimal pValeur)
  {
    m_montantIfm = pValeur;
  }
  
  public void setMontantIfm_C_ERR(String pValeur_C_ERR)
  {
    m_montantIfm_C_ERR = pValeur_C_ERR;
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
    if ("m_nir_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_nom_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_prenom_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_codeNationalite_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_codePostal_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_identifiantBNE_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_siret_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_raisonSociale_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_numeroVoie_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_libelleVoie_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_complementAdresse_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_codePostalETT_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_libelleCommuneCNAVTS_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_indicateurRappelSalaire_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_codeMonnaie_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_motifFinContrat_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_numeroContrat_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_caisseAgirc_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_caisseArrco_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_cadre_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dernierEmploiTenu_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_niveauQualification_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_indicateurQualiteNIR_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_lieuMission_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_filler_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_bneSiret_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_bneRaisonSociale_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_bneNumeroVoirie_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_bneLibelleVoieAdresse_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_bneComplAdresse_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_bneCodePostal_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_bneLibelleCommune_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_bneAssedicAffiliation_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_bneNumAffiliation_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_bneRetraiteAgirc1_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_bneRetraiteAgirc2_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_bneLibelleRetraiteAgirc1_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_bneLibelleRetraiteAgirc2_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_bneIdentifiantBne_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_indicateurMontantIccp_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_indicateurMotifFinContrat_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_indicateurNombreHeuresMision_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_indicateurMontantIfm_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_indicateurRappelMission_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_indicateurNouveauProtocole_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_numeroDocument_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateNaissance_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateDebutPeriode_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateFinPeriode_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateFichierExterne_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateTraitement_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_sieclePeriodeRef_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_moisPeriodeRef_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_salaireBrut_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_montantIccp_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_nombreHeuresMission_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_montantIfm_C_ERR".equals(attrName)) {
      return String.class;
    }
    return null;
  }
  
  public PropertyInfo _getPropertyInfo(String pElementName)
    throws TechniqueException
  {
    if ("Nir".equals(pElementName))
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
    if ("CodeNationalite".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("CodePostal".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("IdentifiantBNE".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("Siret".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("RaisonSociale".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("NumeroVoie".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("LibelleVoie".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("ComplementAdresse".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("CodePostalETT".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("LibelleCommuneCNAVTS".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("IndicateurRappelSalaire".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("CodeMonnaie".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("MotifFinContrat".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("NumeroContrat".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("CaisseAgirc".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("CaisseArrco".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("Cadre".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("DernierEmploiTenu".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("NiveauQualification".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("IndicateurQualiteNIR".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("LieuMission".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("Filler".equals(pElementName))
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
    if ("BneNumeroVoirie".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("BneLibelleVoieAdresse".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("BneComplAdresse".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("BneCodePostal".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("BneLibelleCommune".equals(pElementName))
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
    if ("BneRetraiteAgirc1".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("BneRetraiteAgirc2".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("BneLibelleRetraiteAgirc1".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("BneLibelleRetraiteAgirc2".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("BneIdentifiantBne".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("IndicateurMontantIccp".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("IndicateurMotifFinContrat".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("IndicateurNombreHeuresMision".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("IndicateurMontantIfm".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("IndicateurRappelMission".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("IndicateurNouveauProtocole".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("NumeroDocument".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("DateNaissance".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("DateDebutPeriode".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("DateFinPeriode".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("DateFichierExterne".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("DateTraitement".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("SieclePeriodeRef".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("MoisPeriodeRef".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("SalaireBrut".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("MontantIccp".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("NombreHeuresMission".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("MontantIfm".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    return null;
  }
  
  public int _getPropertyLength(String pElementName)
  {
    if ("Nir".equals(pElementName)) {
      return 15;
    }
    if ("Nom".equals(pElementName)) {
      return 30;
    }
    if ("Prenom".equals(pElementName)) {
      return 20;
    }
    if ("CodeNationalite".equals(pElementName)) {
      return 2;
    }
    if ("CodePostal".equals(pElementName)) {
      return 5;
    }
    if ("IdentifiantBNE".equals(pElementName)) {
      return 10;
    }
    if ("Siret".equals(pElementName)) {
      return 14;
    }
    if ("RaisonSociale".equals(pElementName)) {
      return 32;
    }
    if ("NumeroVoie".equals(pElementName)) {
      return 5;
    }
    if ("LibelleVoie".equals(pElementName)) {
      return 26;
    }
    if ("ComplementAdresse".equals(pElementName)) {
      return 32;
    }
    if ("CodePostalETT".equals(pElementName)) {
      return 5;
    }
    if ("LibelleCommuneCNAVTS".equals(pElementName)) {
      return 26;
    }
    if ("IndicateurRappelSalaire".equals(pElementName)) {
      return 1;
    }
    if ("CodeMonnaie".equals(pElementName)) {
      return 3;
    }
    if ("MotifFinContrat".equals(pElementName)) {
      return 3;
    }
    if ("NumeroContrat".equals(pElementName)) {
      return 12;
    }
    if ("CaisseAgirc".equals(pElementName)) {
      return 4;
    }
    if ("CaisseArrco".equals(pElementName)) {
      return 4;
    }
    if ("Cadre".equals(pElementName)) {
      return 3;
    }
    if ("DernierEmploiTenu".equals(pElementName)) {
      return 4;
    }
    if ("NiveauQualification".equals(pElementName)) {
      return 12;
    }
    if ("IndicateurQualiteNIR".equals(pElementName)) {
      return 1;
    }
    if ("LieuMission".equals(pElementName)) {
      return 2;
    }
    if ("Filler".equals(pElementName)) {
      return 48;
    }
    if ("BneSiret".equals(pElementName)) {
      return 14;
    }
    if ("BneRaisonSociale".equals(pElementName)) {
      return 40;
    }
    if ("BneNumeroVoirie".equals(pElementName)) {
      return 5;
    }
    if ("BneLibelleVoieAdresse".equals(pElementName)) {
      return 32;
    }
    if ("BneComplAdresse".equals(pElementName)) {
      return 40;
    }
    if ("BneCodePostal".equals(pElementName)) {
      return 5;
    }
    if ("BneLibelleCommune".equals(pElementName)) {
      return 40;
    }
    if ("BneAssedicAffiliation".equals(pElementName)) {
      return 3;
    }
    if ("BneNumAffiliation".equals(pElementName)) {
      return 8;
    }
    if ("BneRetraiteAgirc1".equals(pElementName)) {
      return 10;
    }
    if ("BneRetraiteAgirc2".equals(pElementName)) {
      return 10;
    }
    if ("BneLibelleRetraiteAgirc1".equals(pElementName)) {
      return 40;
    }
    if ("BneLibelleRetraiteAgirc2".equals(pElementName)) {
      return 40;
    }
    if ("BneIdentifiantBne".equals(pElementName)) {
      return 10;
    }
    if ("IndicateurMontantIccp".equals(pElementName)) {
      return 1;
    }
    if ("IndicateurMotifFinContrat".equals(pElementName)) {
      return 1;
    }
    if ("IndicateurNombreHeuresMision".equals(pElementName)) {
      return 1;
    }
    if ("IndicateurMontantIfm".equals(pElementName)) {
      return 1;
    }
    if ("IndicateurRappelMission".equals(pElementName)) {
      return 1;
    }
    if ("IndicateurNouveauProtocole".equals(pElementName)) {
      return 1;
    }
    if ("NumeroDocument".equals(pElementName)) {
      return 10;
    }
    if ("DateNaissance".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("DateDebutPeriode".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("DateFinPeriode".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("DateFichierExterne".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("DateTraitement".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("SieclePeriodeRef".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("MoisPeriodeRef".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("SalaireBrut".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("MontantIccp".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("NombreHeuresMission".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("MontantIfm".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    return -1;
  }
  
  public Object _getProperty(String pName)
    throws Exception
  {
    if ("Nir".equals(pName)) {
      return m_nir;
    }
    if ("Nom".equals(pName)) {
      return m_nom;
    }
    if ("Prenom".equals(pName)) {
      return m_prenom;
    }
    if ("CodeNationalite".equals(pName)) {
      return m_codeNationalite;
    }
    if ("CodePostal".equals(pName)) {
      return m_codePostal;
    }
    if ("IdentifiantBNE".equals(pName)) {
      return m_identifiantBNE;
    }
    if ("Siret".equals(pName)) {
      return m_siret;
    }
    if ("RaisonSociale".equals(pName)) {
      return m_raisonSociale;
    }
    if ("NumeroVoie".equals(pName)) {
      return m_numeroVoie;
    }
    if ("LibelleVoie".equals(pName)) {
      return m_libelleVoie;
    }
    if ("ComplementAdresse".equals(pName)) {
      return m_complementAdresse;
    }
    if ("CodePostalETT".equals(pName)) {
      return m_codePostalETT;
    }
    if ("LibelleCommuneCNAVTS".equals(pName)) {
      return m_libelleCommuneCNAVTS;
    }
    if ("IndicateurRappelSalaire".equals(pName)) {
      return m_indicateurRappelSalaire;
    }
    if ("CodeMonnaie".equals(pName)) {
      return m_codeMonnaie;
    }
    if ("MotifFinContrat".equals(pName)) {
      return m_motifFinContrat;
    }
    if ("NumeroContrat".equals(pName)) {
      return m_numeroContrat;
    }
    if ("CaisseAgirc".equals(pName)) {
      return m_caisseAgirc;
    }
    if ("CaisseArrco".equals(pName)) {
      return m_caisseArrco;
    }
    if ("Cadre".equals(pName)) {
      return m_cadre;
    }
    if ("DernierEmploiTenu".equals(pName)) {
      return m_dernierEmploiTenu;
    }
    if ("NiveauQualification".equals(pName)) {
      return m_niveauQualification;
    }
    if ("IndicateurQualiteNIR".equals(pName)) {
      return m_indicateurQualiteNIR;
    }
    if ("LieuMission".equals(pName)) {
      return m_lieuMission;
    }
    if ("Filler".equals(pName)) {
      return m_filler;
    }
    if ("BneSiret".equals(pName)) {
      return m_bneSiret;
    }
    if ("BneRaisonSociale".equals(pName)) {
      return m_bneRaisonSociale;
    }
    if ("BneNumeroVoirie".equals(pName)) {
      return m_bneNumeroVoirie;
    }
    if ("BneLibelleVoieAdresse".equals(pName)) {
      return m_bneLibelleVoieAdresse;
    }
    if ("BneComplAdresse".equals(pName)) {
      return m_bneComplAdresse;
    }
    if ("BneCodePostal".equals(pName)) {
      return m_bneCodePostal;
    }
    if ("BneLibelleCommune".equals(pName)) {
      return m_bneLibelleCommune;
    }
    if ("BneAssedicAffiliation".equals(pName)) {
      return m_bneAssedicAffiliation;
    }
    if ("BneNumAffiliation".equals(pName)) {
      return m_bneNumAffiliation;
    }
    if ("BneRetraiteAgirc1".equals(pName)) {
      return m_bneRetraiteAgirc1;
    }
    if ("BneRetraiteAgirc2".equals(pName)) {
      return m_bneRetraiteAgirc2;
    }
    if ("BneLibelleRetraiteAgirc1".equals(pName)) {
      return m_bneLibelleRetraiteAgirc1;
    }
    if ("BneLibelleRetraiteAgirc2".equals(pName)) {
      return m_bneLibelleRetraiteAgirc2;
    }
    if ("BneIdentifiantBne".equals(pName)) {
      return m_bneIdentifiantBne;
    }
    if ("IndicateurMontantIccp".equals(pName)) {
      return m_indicateurMontantIccp;
    }
    if ("IndicateurMotifFinContrat".equals(pName)) {
      return m_indicateurMotifFinContrat;
    }
    if ("IndicateurNombreHeuresMision".equals(pName)) {
      return m_indicateurNombreHeuresMision;
    }
    if ("IndicateurMontantIfm".equals(pName)) {
      return m_indicateurMontantIfm;
    }
    if ("IndicateurRappelMission".equals(pName)) {
      return m_indicateurRappelMission;
    }
    if ("IndicateurNouveauProtocole".equals(pName)) {
      return m_indicateurNouveauProtocole;
    }
    if ("NumeroDocument".equals(pName)) {
      return m_numeroDocument;
    }
    if ("DateNaissance".equals(pName)) {
      return m_dateNaissance;
    }
    if ("DateDebutPeriode".equals(pName)) {
      return m_dateDebutPeriode;
    }
    if ("DateFinPeriode".equals(pName)) {
      return m_dateFinPeriode;
    }
    if ("DateFichierExterne".equals(pName)) {
      return m_dateFichierExterne;
    }
    if ("DateTraitement".equals(pName)) {
      return m_dateTraitement;
    }
    if ("SieclePeriodeRef".equals(pName)) {
      return m_sieclePeriodeRef;
    }
    if ("MoisPeriodeRef".equals(pName)) {
      return m_moisPeriodeRef;
    }
    if ("SalaireBrut".equals(pName)) {
      return m_salaireBrut;
    }
    if ("MontantIccp".equals(pName)) {
      return m_montantIccp;
    }
    if ("NombreHeuresMission".equals(pName)) {
      return m_nombreHeuresMission;
    }
    if ("MontantIfm".equals(pName)) {
      return m_montantIfm;
    }
    return null;
  }
  
  public Iterator _getPropertyNames()
    throws Exception
  {
    ArrayList liste = new ArrayList();
    liste.add("Nir");
    liste.add("Nom");
    liste.add("Prenom");
    liste.add("CodeNationalite");
    liste.add("CodePostal");
    liste.add("IdentifiantBNE");
    liste.add("Siret");
    liste.add("RaisonSociale");
    liste.add("NumeroVoie");
    liste.add("LibelleVoie");
    liste.add("ComplementAdresse");
    liste.add("CodePostalETT");
    liste.add("LibelleCommuneCNAVTS");
    liste.add("IndicateurRappelSalaire");
    liste.add("CodeMonnaie");
    liste.add("MotifFinContrat");
    liste.add("NumeroContrat");
    liste.add("CaisseAgirc");
    liste.add("CaisseArrco");
    liste.add("Cadre");
    liste.add("DernierEmploiTenu");
    liste.add("NiveauQualification");
    liste.add("IndicateurQualiteNIR");
    liste.add("LieuMission");
    liste.add("Filler");
    liste.add("BneSiret");
    liste.add("BneRaisonSociale");
    liste.add("BneNumeroVoirie");
    liste.add("BneLibelleVoieAdresse");
    liste.add("BneComplAdresse");
    liste.add("BneCodePostal");
    liste.add("BneLibelleCommune");
    liste.add("BneAssedicAffiliation");
    liste.add("BneNumAffiliation");
    liste.add("BneRetraiteAgirc1");
    liste.add("BneRetraiteAgirc2");
    liste.add("BneLibelleRetraiteAgirc1");
    liste.add("BneLibelleRetraiteAgirc2");
    liste.add("BneIdentifiantBne");
    liste.add("IndicateurMontantIccp");
    liste.add("IndicateurMotifFinContrat");
    liste.add("IndicateurNombreHeuresMision");
    liste.add("IndicateurMontantIfm");
    liste.add("IndicateurRappelMission");
    liste.add("IndicateurNouveauProtocole");
    liste.add("NumeroDocument");
    liste.add("DateNaissance");
    liste.add("DateDebutPeriode");
    liste.add("DateFinPeriode");
    liste.add("DateFichierExterne");
    liste.add("DateTraitement");
    liste.add("SieclePeriodeRef");
    liste.add("MoisPeriodeRef");
    liste.add("SalaireBrut");
    liste.add("MontantIccp");
    liste.add("NombreHeuresMission");
    liste.add("MontantIfm");
    return liste.iterator();
  }
  
  public ArrayList _getPropertyNames(ArrayList pListe)
    throws Exception
  {
    pListe.add("Nir");
    pListe.add("Nom");
    pListe.add("Prenom");
    pListe.add("CodeNationalite");
    pListe.add("CodePostal");
    pListe.add("IdentifiantBNE");
    pListe.add("Siret");
    pListe.add("RaisonSociale");
    pListe.add("NumeroVoie");
    pListe.add("LibelleVoie");
    pListe.add("ComplementAdresse");
    pListe.add("CodePostalETT");
    pListe.add("LibelleCommuneCNAVTS");
    pListe.add("IndicateurRappelSalaire");
    pListe.add("CodeMonnaie");
    pListe.add("MotifFinContrat");
    pListe.add("NumeroContrat");
    pListe.add("CaisseAgirc");
    pListe.add("CaisseArrco");
    pListe.add("Cadre");
    pListe.add("DernierEmploiTenu");
    pListe.add("NiveauQualification");
    pListe.add("IndicateurQualiteNIR");
    pListe.add("LieuMission");
    pListe.add("Filler");
    pListe.add("BneSiret");
    pListe.add("BneRaisonSociale");
    pListe.add("BneNumeroVoirie");
    pListe.add("BneLibelleVoieAdresse");
    pListe.add("BneComplAdresse");
    pListe.add("BneCodePostal");
    pListe.add("BneLibelleCommune");
    pListe.add("BneAssedicAffiliation");
    pListe.add("BneNumAffiliation");
    pListe.add("BneRetraiteAgirc1");
    pListe.add("BneRetraiteAgirc2");
    pListe.add("BneLibelleRetraiteAgirc1");
    pListe.add("BneLibelleRetraiteAgirc2");
    pListe.add("BneIdentifiantBne");
    pListe.add("IndicateurMontantIccp");
    pListe.add("IndicateurMotifFinContrat");
    pListe.add("IndicateurNombreHeuresMision");
    pListe.add("IndicateurMontantIfm");
    pListe.add("IndicateurRappelMission");
    pListe.add("IndicateurNouveauProtocole");
    pListe.add("NumeroDocument");
    pListe.add("DateNaissance");
    pListe.add("DateDebutPeriode");
    pListe.add("DateFinPeriode");
    pListe.add("DateFichierExterne");
    pListe.add("DateTraitement");
    pListe.add("SieclePeriodeRef");
    pListe.add("MoisPeriodeRef");
    pListe.add("SalaireBrut");
    pListe.add("MontantIccp");
    pListe.add("NombreHeuresMission");
    pListe.add("MontantIfm");
    return pListe;
  }
  
  public void _setProperty(String pName, Object pValeur)
    throws Exception
  {
    if ("Nir".equals(pName)) {
      m_nir = ((String)pValeur);
    }
    if ("Nom".equals(pName)) {
      m_nom = ((String)pValeur);
    }
    if ("Prenom".equals(pName)) {
      m_prenom = ((String)pValeur);
    }
    if ("CodeNationalite".equals(pName)) {
      m_codeNationalite = ((String)pValeur);
    }
    if ("CodePostal".equals(pName)) {
      m_codePostal = ((String)pValeur);
    }
    if ("IdentifiantBNE".equals(pName)) {
      m_identifiantBNE = ((String)pValeur);
    }
    if ("Siret".equals(pName)) {
      m_siret = ((String)pValeur);
    }
    if ("RaisonSociale".equals(pName)) {
      m_raisonSociale = ((String)pValeur);
    }
    if ("NumeroVoie".equals(pName)) {
      m_numeroVoie = ((String)pValeur);
    }
    if ("LibelleVoie".equals(pName)) {
      m_libelleVoie = ((String)pValeur);
    }
    if ("ComplementAdresse".equals(pName)) {
      m_complementAdresse = ((String)pValeur);
    }
    if ("CodePostalETT".equals(pName)) {
      m_codePostalETT = ((String)pValeur);
    }
    if ("LibelleCommuneCNAVTS".equals(pName)) {
      m_libelleCommuneCNAVTS = ((String)pValeur);
    }
    if ("IndicateurRappelSalaire".equals(pName)) {
      m_indicateurRappelSalaire = ((String)pValeur);
    }
    if ("CodeMonnaie".equals(pName)) {
      m_codeMonnaie = ((String)pValeur);
    }
    if ("MotifFinContrat".equals(pName)) {
      m_motifFinContrat = ((String)pValeur);
    }
    if ("NumeroContrat".equals(pName)) {
      m_numeroContrat = ((String)pValeur);
    }
    if ("CaisseAgirc".equals(pName)) {
      m_caisseAgirc = ((String)pValeur);
    }
    if ("CaisseArrco".equals(pName)) {
      m_caisseArrco = ((String)pValeur);
    }
    if ("Cadre".equals(pName)) {
      m_cadre = ((String)pValeur);
    }
    if ("DernierEmploiTenu".equals(pName)) {
      m_dernierEmploiTenu = ((String)pValeur);
    }
    if ("NiveauQualification".equals(pName)) {
      m_niveauQualification = ((String)pValeur);
    }
    if ("IndicateurQualiteNIR".equals(pName)) {
      m_indicateurQualiteNIR = ((String)pValeur);
    }
    if ("LieuMission".equals(pName)) {
      m_lieuMission = ((String)pValeur);
    }
    if ("Filler".equals(pName)) {
      m_filler = ((String)pValeur);
    }
    if ("BneSiret".equals(pName)) {
      m_bneSiret = ((String)pValeur);
    }
    if ("BneRaisonSociale".equals(pName)) {
      m_bneRaisonSociale = ((String)pValeur);
    }
    if ("BneNumeroVoirie".equals(pName)) {
      m_bneNumeroVoirie = ((String)pValeur);
    }
    if ("BneLibelleVoieAdresse".equals(pName)) {
      m_bneLibelleVoieAdresse = ((String)pValeur);
    }
    if ("BneComplAdresse".equals(pName)) {
      m_bneComplAdresse = ((String)pValeur);
    }
    if ("BneCodePostal".equals(pName)) {
      m_bneCodePostal = ((String)pValeur);
    }
    if ("BneLibelleCommune".equals(pName)) {
      m_bneLibelleCommune = ((String)pValeur);
    }
    if ("BneAssedicAffiliation".equals(pName)) {
      m_bneAssedicAffiliation = ((String)pValeur);
    }
    if ("BneNumAffiliation".equals(pName)) {
      m_bneNumAffiliation = ((String)pValeur);
    }
    if ("BneRetraiteAgirc1".equals(pName)) {
      m_bneRetraiteAgirc1 = ((String)pValeur);
    }
    if ("BneRetraiteAgirc2".equals(pName)) {
      m_bneRetraiteAgirc2 = ((String)pValeur);
    }
    if ("BneLibelleRetraiteAgirc1".equals(pName)) {
      m_bneLibelleRetraiteAgirc1 = ((String)pValeur);
    }
    if ("BneLibelleRetraiteAgirc2".equals(pName)) {
      m_bneLibelleRetraiteAgirc2 = ((String)pValeur);
    }
    if ("BneIdentifiantBne".equals(pName)) {
      m_bneIdentifiantBne = ((String)pValeur);
    }
    if ("IndicateurMontantIccp".equals(pName)) {
      m_indicateurMontantIccp = ((String)pValeur);
    }
    if ("IndicateurMotifFinContrat".equals(pName)) {
      m_indicateurMotifFinContrat = ((String)pValeur);
    }
    if ("IndicateurNombreHeuresMision".equals(pName)) {
      m_indicateurNombreHeuresMision = ((String)pValeur);
    }
    if ("IndicateurMontantIfm".equals(pName)) {
      m_indicateurMontantIfm = ((String)pValeur);
    }
    if ("IndicateurRappelMission".equals(pName)) {
      m_indicateurRappelMission = ((String)pValeur);
    }
    if ("IndicateurNouveauProtocole".equals(pName)) {
      m_indicateurNouveauProtocole = ((String)pValeur);
    }
    if ("NumeroDocument".equals(pName)) {
      m_numeroDocument = ((String)pValeur);
    }
    if ("DateNaissance".equals(pName)) {
      m_dateNaissance = ((Damj)pValeur);
    }
    if ("DateDebutPeriode".equals(pName)) {
      m_dateDebutPeriode = ((Damj)pValeur);
    }
    if ("DateFinPeriode".equals(pName)) {
      m_dateFinPeriode = ((Damj)pValeur);
    }
    if ("DateFichierExterne".equals(pName)) {
      m_dateFichierExterne = ((Damj)pValeur);
    }
    if ("DateTraitement".equals(pName)) {
      m_dateTraitement = ((Damj)pValeur);
    }
    if ("SieclePeriodeRef".equals(pName)) {
      m_sieclePeriodeRef = ((BigDecimal)pValeur);
    }
    if ("MoisPeriodeRef".equals(pName)) {
      m_moisPeriodeRef = ((BigDecimal)pValeur);
    }
    if ("SalaireBrut".equals(pName)) {
      m_salaireBrut = ((BigDecimal)pValeur);
    }
    if ("MontantIccp".equals(pName)) {
      m_montantIccp = ((BigDecimal)pValeur);
    }
    if ("NombreHeuresMission".equals(pName)) {
      m_nombreHeuresMission = ((BigDecimal)pValeur);
    }
    if ("MontantIfm".equals(pName)) {
      m_montantIfm = ((BigDecimal)pValeur);
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
    if ("m_nir_C_ERR".equals(attrName)) {
      m_nir_C_ERR = pValeur;
    }
    if ("m_nom_C_ERR".equals(attrName)) {
      m_nom_C_ERR = pValeur;
    }
    if ("m_prenom_C_ERR".equals(attrName)) {
      m_prenom_C_ERR = pValeur;
    }
    if ("m_codeNationalite_C_ERR".equals(attrName)) {
      m_codeNationalite_C_ERR = pValeur;
    }
    if ("m_codePostal_C_ERR".equals(attrName)) {
      m_codePostal_C_ERR = pValeur;
    }
    if ("m_identifiantBNE_C_ERR".equals(attrName)) {
      m_identifiantBNE_C_ERR = pValeur;
    }
    if ("m_siret_C_ERR".equals(attrName)) {
      m_siret_C_ERR = pValeur;
    }
    if ("m_raisonSociale_C_ERR".equals(attrName)) {
      m_raisonSociale_C_ERR = pValeur;
    }
    if ("m_numeroVoie_C_ERR".equals(attrName)) {
      m_numeroVoie_C_ERR = pValeur;
    }
    if ("m_libelleVoie_C_ERR".equals(attrName)) {
      m_libelleVoie_C_ERR = pValeur;
    }
    if ("m_complementAdresse_C_ERR".equals(attrName)) {
      m_complementAdresse_C_ERR = pValeur;
    }
    if ("m_codePostalETT_C_ERR".equals(attrName)) {
      m_codePostalETT_C_ERR = pValeur;
    }
    if ("m_libelleCommuneCNAVTS_C_ERR".equals(attrName)) {
      m_libelleCommuneCNAVTS_C_ERR = pValeur;
    }
    if ("m_indicateurRappelSalaire_C_ERR".equals(attrName)) {
      m_indicateurRappelSalaire_C_ERR = pValeur;
    }
    if ("m_codeMonnaie_C_ERR".equals(attrName)) {
      m_codeMonnaie_C_ERR = pValeur;
    }
    if ("m_motifFinContrat_C_ERR".equals(attrName)) {
      m_motifFinContrat_C_ERR = pValeur;
    }
    if ("m_numeroContrat_C_ERR".equals(attrName)) {
      m_numeroContrat_C_ERR = pValeur;
    }
    if ("m_caisseAgirc_C_ERR".equals(attrName)) {
      m_caisseAgirc_C_ERR = pValeur;
    }
    if ("m_caisseArrco_C_ERR".equals(attrName)) {
      m_caisseArrco_C_ERR = pValeur;
    }
    if ("m_cadre_C_ERR".equals(attrName)) {
      m_cadre_C_ERR = pValeur;
    }
    if ("m_dernierEmploiTenu_C_ERR".equals(attrName)) {
      m_dernierEmploiTenu_C_ERR = pValeur;
    }
    if ("m_niveauQualification_C_ERR".equals(attrName)) {
      m_niveauQualification_C_ERR = pValeur;
    }
    if ("m_indicateurQualiteNIR_C_ERR".equals(attrName)) {
      m_indicateurQualiteNIR_C_ERR = pValeur;
    }
    if ("m_lieuMission_C_ERR".equals(attrName)) {
      m_lieuMission_C_ERR = pValeur;
    }
    if ("m_filler_C_ERR".equals(attrName)) {
      m_filler_C_ERR = pValeur;
    }
    if ("m_bneSiret_C_ERR".equals(attrName)) {
      m_bneSiret_C_ERR = pValeur;
    }
    if ("m_bneRaisonSociale_C_ERR".equals(attrName)) {
      m_bneRaisonSociale_C_ERR = pValeur;
    }
    if ("m_bneNumeroVoirie_C_ERR".equals(attrName)) {
      m_bneNumeroVoirie_C_ERR = pValeur;
    }
    if ("m_bneLibelleVoieAdresse_C_ERR".equals(attrName)) {
      m_bneLibelleVoieAdresse_C_ERR = pValeur;
    }
    if ("m_bneComplAdresse_C_ERR".equals(attrName)) {
      m_bneComplAdresse_C_ERR = pValeur;
    }
    if ("m_bneCodePostal_C_ERR".equals(attrName)) {
      m_bneCodePostal_C_ERR = pValeur;
    }
    if ("m_bneLibelleCommune_C_ERR".equals(attrName)) {
      m_bneLibelleCommune_C_ERR = pValeur;
    }
    if ("m_bneAssedicAffiliation_C_ERR".equals(attrName)) {
      m_bneAssedicAffiliation_C_ERR = pValeur;
    }
    if ("m_bneNumAffiliation_C_ERR".equals(attrName)) {
      m_bneNumAffiliation_C_ERR = pValeur;
    }
    if ("m_bneRetraiteAgirc1_C_ERR".equals(attrName)) {
      m_bneRetraiteAgirc1_C_ERR = pValeur;
    }
    if ("m_bneRetraiteAgirc2_C_ERR".equals(attrName)) {
      m_bneRetraiteAgirc2_C_ERR = pValeur;
    }
    if ("m_bneLibelleRetraiteAgirc1_C_ERR".equals(attrName)) {
      m_bneLibelleRetraiteAgirc1_C_ERR = pValeur;
    }
    if ("m_bneLibelleRetraiteAgirc2_C_ERR".equals(attrName)) {
      m_bneLibelleRetraiteAgirc2_C_ERR = pValeur;
    }
    if ("m_bneIdentifiantBne_C_ERR".equals(attrName)) {
      m_bneIdentifiantBne_C_ERR = pValeur;
    }
    if ("m_indicateurMontantIccp_C_ERR".equals(attrName)) {
      m_indicateurMontantIccp_C_ERR = pValeur;
    }
    if ("m_indicateurMotifFinContrat_C_ERR".equals(attrName)) {
      m_indicateurMotifFinContrat_C_ERR = pValeur;
    }
    if ("m_indicateurNombreHeuresMision_C_ERR".equals(attrName)) {
      m_indicateurNombreHeuresMision_C_ERR = pValeur;
    }
    if ("m_indicateurMontantIfm_C_ERR".equals(attrName)) {
      m_indicateurMontantIfm_C_ERR = pValeur;
    }
    if ("m_indicateurRappelMission_C_ERR".equals(attrName)) {
      m_indicateurRappelMission_C_ERR = pValeur;
    }
    if ("m_indicateurNouveauProtocole_C_ERR".equals(attrName)) {
      m_indicateurNouveauProtocole_C_ERR = pValeur;
    }
    if ("m_numeroDocument_C_ERR".equals(attrName)) {
      m_numeroDocument_C_ERR = pValeur;
    }
    if ("m_dateNaissance_C_ERR".equals(attrName)) {
      m_dateNaissance_C_ERR = pValeur;
    }
    if ("m_dateDebutPeriode_C_ERR".equals(attrName)) {
      m_dateDebutPeriode_C_ERR = pValeur;
    }
    if ("m_dateFinPeriode_C_ERR".equals(attrName)) {
      m_dateFinPeriode_C_ERR = pValeur;
    }
    if ("m_dateFichierExterne_C_ERR".equals(attrName)) {
      m_dateFichierExterne_C_ERR = pValeur;
    }
    if ("m_dateTraitement_C_ERR".equals(attrName)) {
      m_dateTraitement_C_ERR = pValeur;
    }
    if ("m_sieclePeriodeRef_C_ERR".equals(attrName)) {
      m_sieclePeriodeRef_C_ERR = pValeur;
    }
    if ("m_moisPeriodeRef_C_ERR".equals(attrName)) {
      m_moisPeriodeRef_C_ERR = pValeur;
    }
    if ("m_salaireBrut_C_ERR".equals(attrName)) {
      m_salaireBrut_C_ERR = pValeur;
    }
    if ("m_montantIccp_C_ERR".equals(attrName)) {
      m_montantIccp_C_ERR = pValeur;
    }
    if ("m_nombreHeuresMission_C_ERR".equals(attrName)) {
      m_nombreHeuresMission_C_ERR = pValeur;
    }
    if ("m_montantIfm_C_ERR".equals(attrName)) {
      m_montantIfm_C_ERR = pValeur;
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
    if ("m_nir_C_ERR".equals(attrName)) {
      return m_nir_C_ERR;
    }
    if ("m_nom_C_ERR".equals(attrName)) {
      return m_nom_C_ERR;
    }
    if ("m_prenom_C_ERR".equals(attrName)) {
      return m_prenom_C_ERR;
    }
    if ("m_codeNationalite_C_ERR".equals(attrName)) {
      return m_codeNationalite_C_ERR;
    }
    if ("m_codePostal_C_ERR".equals(attrName)) {
      return m_codePostal_C_ERR;
    }
    if ("m_identifiantBNE_C_ERR".equals(attrName)) {
      return m_identifiantBNE_C_ERR;
    }
    if ("m_siret_C_ERR".equals(attrName)) {
      return m_siret_C_ERR;
    }
    if ("m_raisonSociale_C_ERR".equals(attrName)) {
      return m_raisonSociale_C_ERR;
    }
    if ("m_numeroVoie_C_ERR".equals(attrName)) {
      return m_numeroVoie_C_ERR;
    }
    if ("m_libelleVoie_C_ERR".equals(attrName)) {
      return m_libelleVoie_C_ERR;
    }
    if ("m_complementAdresse_C_ERR".equals(attrName)) {
      return m_complementAdresse_C_ERR;
    }
    if ("m_codePostalETT_C_ERR".equals(attrName)) {
      return m_codePostalETT_C_ERR;
    }
    if ("m_libelleCommuneCNAVTS_C_ERR".equals(attrName)) {
      return m_libelleCommuneCNAVTS_C_ERR;
    }
    if ("m_indicateurRappelSalaire_C_ERR".equals(attrName)) {
      return m_indicateurRappelSalaire_C_ERR;
    }
    if ("m_codeMonnaie_C_ERR".equals(attrName)) {
      return m_codeMonnaie_C_ERR;
    }
    if ("m_motifFinContrat_C_ERR".equals(attrName)) {
      return m_motifFinContrat_C_ERR;
    }
    if ("m_numeroContrat_C_ERR".equals(attrName)) {
      return m_numeroContrat_C_ERR;
    }
    if ("m_caisseAgirc_C_ERR".equals(attrName)) {
      return m_caisseAgirc_C_ERR;
    }
    if ("m_caisseArrco_C_ERR".equals(attrName)) {
      return m_caisseArrco_C_ERR;
    }
    if ("m_cadre_C_ERR".equals(attrName)) {
      return m_cadre_C_ERR;
    }
    if ("m_dernierEmploiTenu_C_ERR".equals(attrName)) {
      return m_dernierEmploiTenu_C_ERR;
    }
    if ("m_niveauQualification_C_ERR".equals(attrName)) {
      return m_niveauQualification_C_ERR;
    }
    if ("m_indicateurQualiteNIR_C_ERR".equals(attrName)) {
      return m_indicateurQualiteNIR_C_ERR;
    }
    if ("m_lieuMission_C_ERR".equals(attrName)) {
      return m_lieuMission_C_ERR;
    }
    if ("m_filler_C_ERR".equals(attrName)) {
      return m_filler_C_ERR;
    }
    if ("m_bneSiret_C_ERR".equals(attrName)) {
      return m_bneSiret_C_ERR;
    }
    if ("m_bneRaisonSociale_C_ERR".equals(attrName)) {
      return m_bneRaisonSociale_C_ERR;
    }
    if ("m_bneNumeroVoirie_C_ERR".equals(attrName)) {
      return m_bneNumeroVoirie_C_ERR;
    }
    if ("m_bneLibelleVoieAdresse_C_ERR".equals(attrName)) {
      return m_bneLibelleVoieAdresse_C_ERR;
    }
    if ("m_bneComplAdresse_C_ERR".equals(attrName)) {
      return m_bneComplAdresse_C_ERR;
    }
    if ("m_bneCodePostal_C_ERR".equals(attrName)) {
      return m_bneCodePostal_C_ERR;
    }
    if ("m_bneLibelleCommune_C_ERR".equals(attrName)) {
      return m_bneLibelleCommune_C_ERR;
    }
    if ("m_bneAssedicAffiliation_C_ERR".equals(attrName)) {
      return m_bneAssedicAffiliation_C_ERR;
    }
    if ("m_bneNumAffiliation_C_ERR".equals(attrName)) {
      return m_bneNumAffiliation_C_ERR;
    }
    if ("m_bneRetraiteAgirc1_C_ERR".equals(attrName)) {
      return m_bneRetraiteAgirc1_C_ERR;
    }
    if ("m_bneRetraiteAgirc2_C_ERR".equals(attrName)) {
      return m_bneRetraiteAgirc2_C_ERR;
    }
    if ("m_bneLibelleRetraiteAgirc1_C_ERR".equals(attrName)) {
      return m_bneLibelleRetraiteAgirc1_C_ERR;
    }
    if ("m_bneLibelleRetraiteAgirc2_C_ERR".equals(attrName)) {
      return m_bneLibelleRetraiteAgirc2_C_ERR;
    }
    if ("m_bneIdentifiantBne_C_ERR".equals(attrName)) {
      return m_bneIdentifiantBne_C_ERR;
    }
    if ("m_indicateurMontantIccp_C_ERR".equals(attrName)) {
      return m_indicateurMontantIccp_C_ERR;
    }
    if ("m_indicateurMotifFinContrat_C_ERR".equals(attrName)) {
      return m_indicateurMotifFinContrat_C_ERR;
    }
    if ("m_indicateurNombreHeuresMision_C_ERR".equals(attrName)) {
      return m_indicateurNombreHeuresMision_C_ERR;
    }
    if ("m_indicateurMontantIfm_C_ERR".equals(attrName)) {
      return m_indicateurMontantIfm_C_ERR;
    }
    if ("m_indicateurRappelMission_C_ERR".equals(attrName)) {
      return m_indicateurRappelMission_C_ERR;
    }
    if ("m_indicateurNouveauProtocole_C_ERR".equals(attrName)) {
      return m_indicateurNouveauProtocole_C_ERR;
    }
    if ("m_numeroDocument_C_ERR".equals(attrName)) {
      return m_numeroDocument_C_ERR;
    }
    if ("m_dateNaissance_C_ERR".equals(attrName)) {
      return m_dateNaissance_C_ERR;
    }
    if ("m_dateDebutPeriode_C_ERR".equals(attrName)) {
      return m_dateDebutPeriode_C_ERR;
    }
    if ("m_dateFinPeriode_C_ERR".equals(attrName)) {
      return m_dateFinPeriode_C_ERR;
    }
    if ("m_dateFichierExterne_C_ERR".equals(attrName)) {
      return m_dateFichierExterne_C_ERR;
    }
    if ("m_dateTraitement_C_ERR".equals(attrName)) {
      return m_dateTraitement_C_ERR;
    }
    if ("m_sieclePeriodeRef_C_ERR".equals(attrName)) {
      return m_sieclePeriodeRef_C_ERR;
    }
    if ("m_moisPeriodeRef_C_ERR".equals(attrName)) {
      return m_moisPeriodeRef_C_ERR;
    }
    if ("m_salaireBrut_C_ERR".equals(attrName)) {
      return m_salaireBrut_C_ERR;
    }
    if ("m_montantIccp_C_ERR".equals(attrName)) {
      return m_montantIccp_C_ERR;
    }
    if ("m_nombreHeuresMission_C_ERR".equals(attrName)) {
      return m_nombreHeuresMission_C_ERR;
    }
    if ("m_montantIfm_C_ERR".equals(attrName)) {
      return m_montantIfm_C_ERR;
    }
    return null;
  }
  
  public boolean equals(Object pObjet)
  {
    if (!(pObjet instanceof _FluxDMM)) {
      return false;
    }
    _FluxDMM x = (_FluxDMM)pObjet;
    if (m_nir == null)
    {
      if (m_nir != null) {
        return false;
      }
    }
    else
    {
      if (m_nir == null) {
        return false;
      }
      if (!m_nir.equals(m_nir)) {
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
    if (m_codeNationalite == null)
    {
      if (m_codeNationalite != null) {
        return false;
      }
    }
    else
    {
      if (m_codeNationalite == null) {
        return false;
      }
      if (!m_codeNationalite.equals(m_codeNationalite)) {
        return false;
      }
    }
    if (m_codePostal == null)
    {
      if (m_codePostal != null) {
        return false;
      }
    }
    else
    {
      if (m_codePostal == null) {
        return false;
      }
      if (!m_codePostal.equals(m_codePostal)) {
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
    if (m_raisonSociale == null)
    {
      if (m_raisonSociale != null) {
        return false;
      }
    }
    else
    {
      if (m_raisonSociale == null) {
        return false;
      }
      if (!m_raisonSociale.equals(m_raisonSociale)) {
        return false;
      }
    }
    if (m_numeroVoie == null)
    {
      if (m_numeroVoie != null) {
        return false;
      }
    }
    else
    {
      if (m_numeroVoie == null) {
        return false;
      }
      if (!m_numeroVoie.equals(m_numeroVoie)) {
        return false;
      }
    }
    if (m_libelleVoie == null)
    {
      if (m_libelleVoie != null) {
        return false;
      }
    }
    else
    {
      if (m_libelleVoie == null) {
        return false;
      }
      if (!m_libelleVoie.equals(m_libelleVoie)) {
        return false;
      }
    }
    if (m_complementAdresse == null)
    {
      if (m_complementAdresse != null) {
        return false;
      }
    }
    else
    {
      if (m_complementAdresse == null) {
        return false;
      }
      if (!m_complementAdresse.equals(m_complementAdresse)) {
        return false;
      }
    }
    if (m_codePostalETT == null)
    {
      if (m_codePostalETT != null) {
        return false;
      }
    }
    else
    {
      if (m_codePostalETT == null) {
        return false;
      }
      if (!m_codePostalETT.equals(m_codePostalETT)) {
        return false;
      }
    }
    if (m_libelleCommuneCNAVTS == null)
    {
      if (m_libelleCommuneCNAVTS != null) {
        return false;
      }
    }
    else
    {
      if (m_libelleCommuneCNAVTS == null) {
        return false;
      }
      if (!m_libelleCommuneCNAVTS.equals(m_libelleCommuneCNAVTS)) {
        return false;
      }
    }
    if (m_indicateurRappelSalaire == null)
    {
      if (m_indicateurRappelSalaire != null) {
        return false;
      }
    }
    else
    {
      if (m_indicateurRappelSalaire == null) {
        return false;
      }
      if (!m_indicateurRappelSalaire.equals(m_indicateurRappelSalaire)) {
        return false;
      }
    }
    if (m_codeMonnaie == null)
    {
      if (m_codeMonnaie != null) {
        return false;
      }
    }
    else
    {
      if (m_codeMonnaie == null) {
        return false;
      }
      if (!m_codeMonnaie.equals(m_codeMonnaie)) {
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
    if (m_numeroContrat == null)
    {
      if (m_numeroContrat != null) {
        return false;
      }
    }
    else
    {
      if (m_numeroContrat == null) {
        return false;
      }
      if (!m_numeroContrat.equals(m_numeroContrat)) {
        return false;
      }
    }
    if (m_caisseAgirc == null)
    {
      if (m_caisseAgirc != null) {
        return false;
      }
    }
    else
    {
      if (m_caisseAgirc == null) {
        return false;
      }
      if (!m_caisseAgirc.equals(m_caisseAgirc)) {
        return false;
      }
    }
    if (m_caisseArrco == null)
    {
      if (m_caisseArrco != null) {
        return false;
      }
    }
    else
    {
      if (m_caisseArrco == null) {
        return false;
      }
      if (!m_caisseArrco.equals(m_caisseArrco)) {
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
    if (m_dernierEmploiTenu == null)
    {
      if (m_dernierEmploiTenu != null) {
        return false;
      }
    }
    else
    {
      if (m_dernierEmploiTenu == null) {
        return false;
      }
      if (!m_dernierEmploiTenu.equals(m_dernierEmploiTenu)) {
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
    if (m_indicateurQualiteNIR == null)
    {
      if (m_indicateurQualiteNIR != null) {
        return false;
      }
    }
    else
    {
      if (m_indicateurQualiteNIR == null) {
        return false;
      }
      if (!m_indicateurQualiteNIR.equals(m_indicateurQualiteNIR)) {
        return false;
      }
    }
    if (m_lieuMission == null)
    {
      if (m_lieuMission != null) {
        return false;
      }
    }
    else
    {
      if (m_lieuMission == null) {
        return false;
      }
      if (!m_lieuMission.equals(m_lieuMission)) {
        return false;
      }
    }
    if (m_filler == null)
    {
      if (m_filler != null) {
        return false;
      }
    }
    else
    {
      if (m_filler == null) {
        return false;
      }
      if (!m_filler.equals(m_filler)) {
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
    if (m_bneNumeroVoirie == null)
    {
      if (m_bneNumeroVoirie != null) {
        return false;
      }
    }
    else
    {
      if (m_bneNumeroVoirie == null) {
        return false;
      }
      if (!m_bneNumeroVoirie.equals(m_bneNumeroVoirie)) {
        return false;
      }
    }
    if (m_bneLibelleVoieAdresse == null)
    {
      if (m_bneLibelleVoieAdresse != null) {
        return false;
      }
    }
    else
    {
      if (m_bneLibelleVoieAdresse == null) {
        return false;
      }
      if (!m_bneLibelleVoieAdresse.equals(m_bneLibelleVoieAdresse)) {
        return false;
      }
    }
    if (m_bneComplAdresse == null)
    {
      if (m_bneComplAdresse != null) {
        return false;
      }
    }
    else
    {
      if (m_bneComplAdresse == null) {
        return false;
      }
      if (!m_bneComplAdresse.equals(m_bneComplAdresse)) {
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
    if (m_bneLibelleCommune == null)
    {
      if (m_bneLibelleCommune != null) {
        return false;
      }
    }
    else
    {
      if (m_bneLibelleCommune == null) {
        return false;
      }
      if (!m_bneLibelleCommune.equals(m_bneLibelleCommune)) {
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
    if (m_bneRetraiteAgirc1 == null)
    {
      if (m_bneRetraiteAgirc1 != null) {
        return false;
      }
    }
    else
    {
      if (m_bneRetraiteAgirc1 == null) {
        return false;
      }
      if (!m_bneRetraiteAgirc1.equals(m_bneRetraiteAgirc1)) {
        return false;
      }
    }
    if (m_bneRetraiteAgirc2 == null)
    {
      if (m_bneRetraiteAgirc2 != null) {
        return false;
      }
    }
    else
    {
      if (m_bneRetraiteAgirc2 == null) {
        return false;
      }
      if (!m_bneRetraiteAgirc2.equals(m_bneRetraiteAgirc2)) {
        return false;
      }
    }
    if (m_bneLibelleRetraiteAgirc1 == null)
    {
      if (m_bneLibelleRetraiteAgirc1 != null) {
        return false;
      }
    }
    else
    {
      if (m_bneLibelleRetraiteAgirc1 == null) {
        return false;
      }
      if (!m_bneLibelleRetraiteAgirc1.equals(m_bneLibelleRetraiteAgirc1)) {
        return false;
      }
    }
    if (m_bneLibelleRetraiteAgirc2 == null)
    {
      if (m_bneLibelleRetraiteAgirc2 != null) {
        return false;
      }
    }
    else
    {
      if (m_bneLibelleRetraiteAgirc2 == null) {
        return false;
      }
      if (!m_bneLibelleRetraiteAgirc2.equals(m_bneLibelleRetraiteAgirc2)) {
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
    if (m_indicateurMontantIccp == null)
    {
      if (m_indicateurMontantIccp != null) {
        return false;
      }
    }
    else
    {
      if (m_indicateurMontantIccp == null) {
        return false;
      }
      if (!m_indicateurMontantIccp.equals(m_indicateurMontantIccp)) {
        return false;
      }
    }
    if (m_indicateurMotifFinContrat == null)
    {
      if (m_indicateurMotifFinContrat != null) {
        return false;
      }
    }
    else
    {
      if (m_indicateurMotifFinContrat == null) {
        return false;
      }
      if (!m_indicateurMotifFinContrat.equals(m_indicateurMotifFinContrat)) {
        return false;
      }
    }
    if (m_indicateurNombreHeuresMision == null)
    {
      if (m_indicateurNombreHeuresMision != null) {
        return false;
      }
    }
    else
    {
      if (m_indicateurNombreHeuresMision == null) {
        return false;
      }
      if (!m_indicateurNombreHeuresMision.equals(m_indicateurNombreHeuresMision)) {
        return false;
      }
    }
    if (m_indicateurMontantIfm == null)
    {
      if (m_indicateurMontantIfm != null) {
        return false;
      }
    }
    else
    {
      if (m_indicateurMontantIfm == null) {
        return false;
      }
      if (!m_indicateurMontantIfm.equals(m_indicateurMontantIfm)) {
        return false;
      }
    }
    if (m_indicateurRappelMission == null)
    {
      if (m_indicateurRappelMission != null) {
        return false;
      }
    }
    else
    {
      if (m_indicateurRappelMission == null) {
        return false;
      }
      if (!m_indicateurRappelMission.equals(m_indicateurRappelMission)) {
        return false;
      }
    }
    if (m_indicateurNouveauProtocole == null)
    {
      if (m_indicateurNouveauProtocole != null) {
        return false;
      }
    }
    else
    {
      if (m_indicateurNouveauProtocole == null) {
        return false;
      }
      if (!m_indicateurNouveauProtocole.equals(m_indicateurNouveauProtocole)) {
        return false;
      }
    }
    if (m_numeroDocument == null)
    {
      if (m_numeroDocument != null) {
        return false;
      }
    }
    else
    {
      if (m_numeroDocument == null) {
        return false;
      }
      if (!m_numeroDocument.equals(m_numeroDocument)) {
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
    if (m_dateDebutPeriode == null)
    {
      if (m_dateDebutPeriode != null) {
        return false;
      }
    }
    else
    {
      if (m_dateDebutPeriode == null) {
        return false;
      }
      if (!m_dateDebutPeriode.equals(m_dateDebutPeriode)) {
        return false;
      }
    }
    if (m_dateFinPeriode == null)
    {
      if (m_dateFinPeriode != null) {
        return false;
      }
    }
    else
    {
      if (m_dateFinPeriode == null) {
        return false;
      }
      if (!m_dateFinPeriode.equals(m_dateFinPeriode)) {
        return false;
      }
    }
    if (m_dateFichierExterne == null)
    {
      if (m_dateFichierExterne != null) {
        return false;
      }
    }
    else
    {
      if (m_dateFichierExterne == null) {
        return false;
      }
      if (!m_dateFichierExterne.equals(m_dateFichierExterne)) {
        return false;
      }
    }
    if (m_dateTraitement == null)
    {
      if (m_dateTraitement != null) {
        return false;
      }
    }
    else
    {
      if (m_dateTraitement == null) {
        return false;
      }
      if (!m_dateTraitement.equals(m_dateTraitement)) {
        return false;
      }
    }
    if (m_sieclePeriodeRef == null)
    {
      if (m_sieclePeriodeRef != null) {
        return false;
      }
    }
    else
    {
      if (m_sieclePeriodeRef == null) {
        return false;
      }
      if (!m_sieclePeriodeRef.equals(m_sieclePeriodeRef)) {
        return false;
      }
    }
    if (m_moisPeriodeRef == null)
    {
      if (m_moisPeriodeRef != null) {
        return false;
      }
    }
    else
    {
      if (m_moisPeriodeRef == null) {
        return false;
      }
      if (!m_moisPeriodeRef.equals(m_moisPeriodeRef)) {
        return false;
      }
    }
    if (m_salaireBrut == null)
    {
      if (m_salaireBrut != null) {
        return false;
      }
    }
    else
    {
      if (m_salaireBrut == null) {
        return false;
      }
      if (!m_salaireBrut.equals(m_salaireBrut)) {
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
    if (m_nombreHeuresMission == null)
    {
      if (m_nombreHeuresMission != null) {
        return false;
      }
    }
    else
    {
      if (m_nombreHeuresMission == null) {
        return false;
      }
      if (!m_nombreHeuresMission.equals(m_nombreHeuresMission)) {
        return false;
      }
    }
    if (m_montantIfm == null)
    {
      if (m_montantIfm != null) {
        return false;
      }
    }
    else
    {
      if (m_montantIfm == null) {
        return false;
      }
      if (!m_montantIfm.equals(m_montantIfm)) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int result = 0;
    if (m_nir != null) {
      result += m_nir.hashCode();
    }
    if (m_nom != null) {
      result += m_nom.hashCode();
    }
    if (m_prenom != null) {
      result += m_prenom.hashCode();
    }
    if (m_codeNationalite != null) {
      result += m_codeNationalite.hashCode();
    }
    if (m_codePostal != null) {
      result += m_codePostal.hashCode();
    }
    if (m_identifiantBNE != null) {
      result += m_identifiantBNE.hashCode();
    }
    if (m_siret != null) {
      result += m_siret.hashCode();
    }
    if (m_raisonSociale != null) {
      result += m_raisonSociale.hashCode();
    }
    if (m_numeroVoie != null) {
      result += m_numeroVoie.hashCode();
    }
    if (m_libelleVoie != null) {
      result += m_libelleVoie.hashCode();
    }
    if (m_complementAdresse != null) {
      result += m_complementAdresse.hashCode();
    }
    if (m_codePostalETT != null) {
      result += m_codePostalETT.hashCode();
    }
    if (m_libelleCommuneCNAVTS != null) {
      result += m_libelleCommuneCNAVTS.hashCode();
    }
    if (m_indicateurRappelSalaire != null) {
      result += m_indicateurRappelSalaire.hashCode();
    }
    if (m_codeMonnaie != null) {
      result += m_codeMonnaie.hashCode();
    }
    if (m_motifFinContrat != null) {
      result += m_motifFinContrat.hashCode();
    }
    if (m_numeroContrat != null) {
      result += m_numeroContrat.hashCode();
    }
    if (m_caisseAgirc != null) {
      result += m_caisseAgirc.hashCode();
    }
    if (m_caisseArrco != null) {
      result += m_caisseArrco.hashCode();
    }
    if (m_cadre != null) {
      result += m_cadre.hashCode();
    }
    if (m_dernierEmploiTenu != null) {
      result += m_dernierEmploiTenu.hashCode();
    }
    if (m_niveauQualification != null) {
      result += m_niveauQualification.hashCode();
    }
    if (m_indicateurQualiteNIR != null) {
      result += m_indicateurQualiteNIR.hashCode();
    }
    if (m_lieuMission != null) {
      result += m_lieuMission.hashCode();
    }
    if (m_filler != null) {
      result += m_filler.hashCode();
    }
    if (m_bneSiret != null) {
      result += m_bneSiret.hashCode();
    }
    if (m_bneRaisonSociale != null) {
      result += m_bneRaisonSociale.hashCode();
    }
    if (m_bneNumeroVoirie != null) {
      result += m_bneNumeroVoirie.hashCode();
    }
    if (m_bneLibelleVoieAdresse != null) {
      result += m_bneLibelleVoieAdresse.hashCode();
    }
    if (m_bneComplAdresse != null) {
      result += m_bneComplAdresse.hashCode();
    }
    if (m_bneCodePostal != null) {
      result += m_bneCodePostal.hashCode();
    }
    if (m_bneLibelleCommune != null) {
      result += m_bneLibelleCommune.hashCode();
    }
    if (m_bneAssedicAffiliation != null) {
      result += m_bneAssedicAffiliation.hashCode();
    }
    if (m_bneNumAffiliation != null) {
      result += m_bneNumAffiliation.hashCode();
    }
    if (m_bneRetraiteAgirc1 != null) {
      result += m_bneRetraiteAgirc1.hashCode();
    }
    if (m_bneRetraiteAgirc2 != null) {
      result += m_bneRetraiteAgirc2.hashCode();
    }
    if (m_bneLibelleRetraiteAgirc1 != null) {
      result += m_bneLibelleRetraiteAgirc1.hashCode();
    }
    if (m_bneLibelleRetraiteAgirc2 != null) {
      result += m_bneLibelleRetraiteAgirc2.hashCode();
    }
    if (m_bneIdentifiantBne != null) {
      result += m_bneIdentifiantBne.hashCode();
    }
    if (m_indicateurMontantIccp != null) {
      result += m_indicateurMontantIccp.hashCode();
    }
    if (m_indicateurMotifFinContrat != null) {
      result += m_indicateurMotifFinContrat.hashCode();
    }
    if (m_indicateurNombreHeuresMision != null) {
      result += m_indicateurNombreHeuresMision.hashCode();
    }
    if (m_indicateurMontantIfm != null) {
      result += m_indicateurMontantIfm.hashCode();
    }
    if (m_indicateurRappelMission != null) {
      result += m_indicateurRappelMission.hashCode();
    }
    if (m_indicateurNouveauProtocole != null) {
      result += m_indicateurNouveauProtocole.hashCode();
    }
    if (m_numeroDocument != null) {
      result += m_numeroDocument.hashCode();
    }
    if (m_dateNaissance != null) {
      result += m_dateNaissance.hashCode();
    }
    if (m_dateDebutPeriode != null) {
      result += m_dateDebutPeriode.hashCode();
    }
    if (m_dateFinPeriode != null) {
      result += m_dateFinPeriode.hashCode();
    }
    if (m_dateFichierExterne != null) {
      result += m_dateFichierExterne.hashCode();
    }
    if (m_dateTraitement != null) {
      result += m_dateTraitement.hashCode();
    }
    if (m_sieclePeriodeRef != null) {
      result += m_sieclePeriodeRef.hashCode();
    }
    if (m_moisPeriodeRef != null) {
      result += m_moisPeriodeRef.hashCode();
    }
    if (m_salaireBrut != null) {
      result += m_salaireBrut.hashCode();
    }
    if (m_montantIccp != null) {
      result += m_montantIccp.hashCode();
    }
    if (m_nombreHeuresMission != null) {
      result += m_nombreHeuresMission.hashCode();
    }
    if (m_montantIfm != null) {
      result += m_montantIfm.hashCode();
    }
    result *= 17;
    return result;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    _FluxDMM clone_FluxDMM = new _FluxDMM();
    clone_FluxDMM.populateFrom_FluxDMM(this);
    return clone_FluxDMM;
  }
  
  public void populateFrom_FluxDMM(_FluxDMM pSource)
  {
    setNir(pSource.getNir());setNom(pSource.getNom());setPrenom(pSource.getPrenom());setCodeNationalite(pSource.getCodeNationalite());setCodePostal(pSource.getCodePostal());setIdentifiantBNE(pSource.getIdentifiantBNE());setSiret(pSource.getSiret());setRaisonSociale(pSource.getRaisonSociale());setNumeroVoie(pSource.getNumeroVoie());setLibelleVoie(pSource.getLibelleVoie());setComplementAdresse(pSource.getComplementAdresse());setCodePostalETT(pSource.getCodePostalETT());setLibelleCommuneCNAVTS(pSource.getLibelleCommuneCNAVTS());setIndicateurRappelSalaire(pSource.getIndicateurRappelSalaire());setCodeMonnaie(pSource.getCodeMonnaie());setMotifFinContrat(pSource.getMotifFinContrat());setNumeroContrat(pSource.getNumeroContrat());setCaisseAgirc(pSource.getCaisseAgirc());setCaisseArrco(pSource.getCaisseArrco());setCadre(pSource.getCadre());setDernierEmploiTenu(pSource.getDernierEmploiTenu());setNiveauQualification(pSource.getNiveauQualification());setIndicateurQualiteNIR(pSource.getIndicateurQualiteNIR());setLieuMission(pSource.getLieuMission());setFiller(pSource.getFiller());setBneSiret(pSource.getBneSiret());setBneRaisonSociale(pSource.getBneRaisonSociale());setBneNumeroVoirie(pSource.getBneNumeroVoirie());setBneLibelleVoieAdresse(pSource.getBneLibelleVoieAdresse());setBneComplAdresse(pSource.getBneComplAdresse());setBneCodePostal(pSource.getBneCodePostal());setBneLibelleCommune(pSource.getBneLibelleCommune());setBneAssedicAffiliation(pSource.getBneAssedicAffiliation());setBneNumAffiliation(pSource.getBneNumAffiliation());setBneRetraiteAgirc1(pSource.getBneRetraiteAgirc1());setBneRetraiteAgirc2(pSource.getBneRetraiteAgirc2());setBneLibelleRetraiteAgirc1(pSource.getBneLibelleRetraiteAgirc1());setBneLibelleRetraiteAgirc2(pSource.getBneLibelleRetraiteAgirc2());setBneIdentifiantBne(pSource.getBneIdentifiantBne());setIndicateurMontantIccp(pSource.getIndicateurMontantIccp());setIndicateurMotifFinContrat(pSource.getIndicateurMotifFinContrat());setIndicateurNombreHeuresMision(pSource.getIndicateurNombreHeuresMision());setIndicateurMontantIfm(pSource.getIndicateurMontantIfm());setIndicateurRappelMission(pSource.getIndicateurRappelMission());setIndicateurNouveauProtocole(pSource.getIndicateurNouveauProtocole());setNumeroDocument(pSource.getNumeroDocument());setDateNaissance(pSource.getDateNaissance());setDateDebutPeriode(pSource.getDateDebutPeriode());setDateFinPeriode(pSource.getDateFinPeriode());setDateFichierExterne(pSource.getDateFichierExterne());setDateTraitement(pSource.getDateTraitement());setSieclePeriodeRef(pSource.getSieclePeriodeRef());setMoisPeriodeRef(pSource.getMoisPeriodeRef());setSalaireBrut(pSource.getSalaireBrut());setMontantIccp(pSource.getMontantIccp());setNombreHeuresMission(pSource.getNombreHeuresMission());setMontantIfm(pSource.getMontantIfm());
  }
  
  public String toString()
  {
    StringBuffer s = new StringBuffer("[_FluxDMM");
    subToString(s);
    s.append("]");
    return s.toString();
  }
  
  protected void subToString(StringBuffer pSource)
  {
    pSource.append(", Nir: ");
    pSource.append(m_nir);
    pSource.append(", Nom: ");
    pSource.append(m_nom);
    pSource.append(", Prenom: ");
    pSource.append(m_prenom);
    pSource.append(", CodeNationalite: ");
    pSource.append(m_codeNationalite);
    pSource.append(", CodePostal: ");
    pSource.append(m_codePostal);
    pSource.append(", IdentifiantBNE: ");
    pSource.append(m_identifiantBNE);
    pSource.append(", Siret: ");
    pSource.append(m_siret);
    pSource.append(", RaisonSociale: ");
    pSource.append(m_raisonSociale);
    pSource.append(", NumeroVoie: ");
    pSource.append(m_numeroVoie);
    pSource.append(", LibelleVoie: ");
    pSource.append(m_libelleVoie);
    pSource.append(", ComplementAdresse: ");
    pSource.append(m_complementAdresse);
    pSource.append(", CodePostalETT: ");
    pSource.append(m_codePostalETT);
    pSource.append(", LibelleCommuneCNAVTS: ");
    pSource.append(m_libelleCommuneCNAVTS);
    pSource.append(", IndicateurRappelSalaire: ");
    pSource.append(m_indicateurRappelSalaire);
    pSource.append(", CodeMonnaie: ");
    pSource.append(m_codeMonnaie);
    pSource.append(", MotifFinContrat: ");
    pSource.append(m_motifFinContrat);
    pSource.append(", NumeroContrat: ");
    pSource.append(m_numeroContrat);
    pSource.append(", CaisseAgirc: ");
    pSource.append(m_caisseAgirc);
    pSource.append(", CaisseArrco: ");
    pSource.append(m_caisseArrco);
    pSource.append(", Cadre: ");
    pSource.append(m_cadre);
    pSource.append(", DernierEmploiTenu: ");
    pSource.append(m_dernierEmploiTenu);
    pSource.append(", NiveauQualification: ");
    pSource.append(m_niveauQualification);
    pSource.append(", IndicateurQualiteNIR: ");
    pSource.append(m_indicateurQualiteNIR);
    pSource.append(", LieuMission: ");
    pSource.append(m_lieuMission);
    pSource.append(", Filler: ");
    pSource.append(m_filler);
    pSource.append(", BneSiret: ");
    pSource.append(m_bneSiret);
    pSource.append(", BneRaisonSociale: ");
    pSource.append(m_bneRaisonSociale);
    pSource.append(", BneNumeroVoirie: ");
    pSource.append(m_bneNumeroVoirie);
    pSource.append(", BneLibelleVoieAdresse: ");
    pSource.append(m_bneLibelleVoieAdresse);
    pSource.append(", BneComplAdresse: ");
    pSource.append(m_bneComplAdresse);
    pSource.append(", BneCodePostal: ");
    pSource.append(m_bneCodePostal);
    pSource.append(", BneLibelleCommune: ");
    pSource.append(m_bneLibelleCommune);
    pSource.append(", BneAssedicAffiliation: ");
    pSource.append(m_bneAssedicAffiliation);
    pSource.append(", BneNumAffiliation: ");
    pSource.append(m_bneNumAffiliation);
    pSource.append(", BneRetraiteAgirc1: ");
    pSource.append(m_bneRetraiteAgirc1);
    pSource.append(", BneRetraiteAgirc2: ");
    pSource.append(m_bneRetraiteAgirc2);
    pSource.append(", BneLibelleRetraiteAgirc1: ");
    pSource.append(m_bneLibelleRetraiteAgirc1);
    pSource.append(", BneLibelleRetraiteAgirc2: ");
    pSource.append(m_bneLibelleRetraiteAgirc2);
    pSource.append(", BneIdentifiantBne: ");
    pSource.append(m_bneIdentifiantBne);
    pSource.append(", IndicateurMontantIccp: ");
    pSource.append(m_indicateurMontantIccp);
    pSource.append(", IndicateurMotifFinContrat: ");
    pSource.append(m_indicateurMotifFinContrat);
    pSource.append(", IndicateurNombreHeuresMision: ");
    pSource.append(m_indicateurNombreHeuresMision);
    pSource.append(", IndicateurMontantIfm: ");
    pSource.append(m_indicateurMontantIfm);
    pSource.append(", IndicateurRappelMission: ");
    pSource.append(m_indicateurRappelMission);
    pSource.append(", IndicateurNouveauProtocole: ");
    pSource.append(m_indicateurNouveauProtocole);
    pSource.append(", NumeroDocument: ");
    pSource.append(m_numeroDocument);
    pSource.append(", DateNaissance: ");
    pSource.append(m_dateNaissance);
    pSource.append(", DateDebutPeriode: ");
    pSource.append(m_dateDebutPeriode);
    pSource.append(", DateFinPeriode: ");
    pSource.append(m_dateFinPeriode);
    pSource.append(", DateFichierExterne: ");
    pSource.append(m_dateFichierExterne);
    pSource.append(", DateTraitement: ");
    pSource.append(m_dateTraitement);
    pSource.append(", SieclePeriodeRef: ");
    pSource.append(m_sieclePeriodeRef);
    pSource.append(", MoisPeriodeRef: ");
    pSource.append(m_moisPeriodeRef);
    pSource.append(", SalaireBrut: ");
    pSource.append(m_salaireBrut);
    pSource.append(", MontantIccp: ");
    pSource.append(m_montantIccp);
    pSource.append(", NombreHeuresMission: ");
    pSource.append(m_nombreHeuresMission);
    pSource.append(", MontantIfm: ");
    pSource.append(m_montantIfm);
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
    pHandler.property("Nir", getNir(), new Attribute[] { new StringAttribute("C_ERR", getNir_C_ERR()) });
    
    pHandler.property("Nom", getNom(), new Attribute[] { new StringAttribute("C_ERR", getNom_C_ERR()) });
    
    pHandler.property("Prenom", getPrenom(), new Attribute[] { new StringAttribute("C_ERR", getPrenom_C_ERR()) });
    
    pHandler.property("CodeNationalite", getCodeNationalite(), new Attribute[] { new StringAttribute("C_ERR", getCodeNationalite_C_ERR()) });
    
    pHandler.property("CodePostal", getCodePostal(), new Attribute[] { new StringAttribute("C_ERR", getCodePostal_C_ERR()) });
    
    pHandler.property("IdentifiantBNE", getIdentifiantBNE(), new Attribute[] { new StringAttribute("C_ERR", getIdentifiantBNE_C_ERR()) });
    
    pHandler.property("Siret", getSiret(), new Attribute[] { new StringAttribute("C_ERR", getSiret_C_ERR()) });
    
    pHandler.property("RaisonSociale", getRaisonSociale(), new Attribute[] { new StringAttribute("C_ERR", getRaisonSociale_C_ERR()) });
    
    pHandler.property("NumeroVoie", getNumeroVoie(), new Attribute[] { new StringAttribute("C_ERR", getNumeroVoie_C_ERR()) });
    
    pHandler.property("LibelleVoie", getLibelleVoie(), new Attribute[] { new StringAttribute("C_ERR", getLibelleVoie_C_ERR()) });
    
    pHandler.property("ComplementAdresse", getComplementAdresse(), new Attribute[] { new StringAttribute("C_ERR", getComplementAdresse_C_ERR()) });
    
    pHandler.property("CodePostalETT", getCodePostalETT(), new Attribute[] { new StringAttribute("C_ERR", getCodePostalETT_C_ERR()) });
    
    pHandler.property("LibelleCommuneCNAVTS", getLibelleCommuneCNAVTS(), new Attribute[] { new StringAttribute("C_ERR", getLibelleCommuneCNAVTS_C_ERR()) });
    
    pHandler.property("IndicateurRappelSalaire", getIndicateurRappelSalaire(), new Attribute[] { new StringAttribute("C_ERR", getIndicateurRappelSalaire_C_ERR()) });
    
    pHandler.property("CodeMonnaie", getCodeMonnaie(), new Attribute[] { new StringAttribute("C_ERR", getCodeMonnaie_C_ERR()) });
    
    pHandler.property("MotifFinContrat", getMotifFinContrat(), new Attribute[] { new StringAttribute("C_ERR", getMotifFinContrat_C_ERR()) });
    
    pHandler.property("NumeroContrat", getNumeroContrat(), new Attribute[] { new StringAttribute("C_ERR", getNumeroContrat_C_ERR()) });
    
    pHandler.property("CaisseAgirc", getCaisseAgirc(), new Attribute[] { new StringAttribute("C_ERR", getCaisseAgirc_C_ERR()) });
    
    pHandler.property("CaisseArrco", getCaisseArrco(), new Attribute[] { new StringAttribute("C_ERR", getCaisseArrco_C_ERR()) });
    
    pHandler.property("Cadre", getCadre(), new Attribute[] { new StringAttribute("C_ERR", getCadre_C_ERR()) });
    
    pHandler.property("DernierEmploiTenu", getDernierEmploiTenu(), new Attribute[] { new StringAttribute("C_ERR", getDernierEmploiTenu_C_ERR()) });
    
    pHandler.property("NiveauQualification", getNiveauQualification(), new Attribute[] { new StringAttribute("C_ERR", getNiveauQualification_C_ERR()) });
    
    pHandler.property("IndicateurQualiteNIR", getIndicateurQualiteNIR(), new Attribute[] { new StringAttribute("C_ERR", getIndicateurQualiteNIR_C_ERR()) });
    
    pHandler.property("LieuMission", getLieuMission(), new Attribute[] { new StringAttribute("C_ERR", getLieuMission_C_ERR()) });
    
    pHandler.property("Filler", getFiller(), new Attribute[] { new StringAttribute("C_ERR", getFiller_C_ERR()) });
    
    pHandler.property("BneSiret", getBneSiret(), new Attribute[] { new StringAttribute("C_ERR", getBneSiret_C_ERR()) });
    
    pHandler.property("BneRaisonSociale", getBneRaisonSociale(), new Attribute[] { new StringAttribute("C_ERR", getBneRaisonSociale_C_ERR()) });
    
    pHandler.property("BneNumeroVoirie", getBneNumeroVoirie(), new Attribute[] { new StringAttribute("C_ERR", getBneNumeroVoirie_C_ERR()) });
    
    pHandler.property("BneLibelleVoieAdresse", getBneLibelleVoieAdresse(), new Attribute[] { new StringAttribute("C_ERR", getBneLibelleVoieAdresse_C_ERR()) });
    
    pHandler.property("BneComplAdresse", getBneComplAdresse(), new Attribute[] { new StringAttribute("C_ERR", getBneComplAdresse_C_ERR()) });
    
    pHandler.property("BneCodePostal", getBneCodePostal(), new Attribute[] { new StringAttribute("C_ERR", getBneCodePostal_C_ERR()) });
    
    pHandler.property("BneLibelleCommune", getBneLibelleCommune(), new Attribute[] { new StringAttribute("C_ERR", getBneLibelleCommune_C_ERR()) });
    
    pHandler.property("BneAssedicAffiliation", getBneAssedicAffiliation(), new Attribute[] { new StringAttribute("C_ERR", getBneAssedicAffiliation_C_ERR()) });
    
    pHandler.property("BneNumAffiliation", getBneNumAffiliation(), new Attribute[] { new StringAttribute("C_ERR", getBneNumAffiliation_C_ERR()) });
    
    pHandler.property("BneRetraiteAgirc1", getBneRetraiteAgirc1(), new Attribute[] { new StringAttribute("C_ERR", getBneRetraiteAgirc1_C_ERR()) });
    
    pHandler.property("BneRetraiteAgirc2", getBneRetraiteAgirc2(), new Attribute[] { new StringAttribute("C_ERR", getBneRetraiteAgirc2_C_ERR()) });
    
    pHandler.property("BneLibelleRetraiteAgirc1", getBneLibelleRetraiteAgirc1(), new Attribute[] { new StringAttribute("C_ERR", getBneLibelleRetraiteAgirc1_C_ERR()) });
    
    pHandler.property("BneLibelleRetraiteAgirc2", getBneLibelleRetraiteAgirc2(), new Attribute[] { new StringAttribute("C_ERR", getBneLibelleRetraiteAgirc2_C_ERR()) });
    
    pHandler.property("BneIdentifiantBne", getBneIdentifiantBne(), new Attribute[] { new StringAttribute("C_ERR", getBneIdentifiantBne_C_ERR()) });
    
    pHandler.property("IndicateurMontantIccp", getIndicateurMontantIccp(), new Attribute[] { new StringAttribute("C_ERR", getIndicateurMontantIccp_C_ERR()) });
    
    pHandler.property("IndicateurMotifFinContrat", getIndicateurMotifFinContrat(), new Attribute[] { new StringAttribute("C_ERR", getIndicateurMotifFinContrat_C_ERR()) });
    
    pHandler.property("IndicateurNombreHeuresMision", getIndicateurNombreHeuresMision(), new Attribute[] { new StringAttribute("C_ERR", getIndicateurNombreHeuresMision_C_ERR()) });
    
    pHandler.property("IndicateurMontantIfm", getIndicateurMontantIfm(), new Attribute[] { new StringAttribute("C_ERR", getIndicateurMontantIfm_C_ERR()) });
    
    pHandler.property("IndicateurRappelMission", getIndicateurRappelMission(), new Attribute[] { new StringAttribute("C_ERR", getIndicateurRappelMission_C_ERR()) });
    
    pHandler.property("IndicateurNouveauProtocole", getIndicateurNouveauProtocole(), new Attribute[] { new StringAttribute("C_ERR", getIndicateurNouveauProtocole_C_ERR()) });
    
    pHandler.property("NumeroDocument", getNumeroDocument(), new Attribute[] { new StringAttribute("C_ERR", getNumeroDocument_C_ERR()) });
    
    pHandler.property("DateNaissance", getDateNaissance(), new Attribute[] { new StringAttribute("C_ERR", getDateNaissance_C_ERR()) });
    
    pHandler.property("DateDebutPeriode", getDateDebutPeriode(), new Attribute[] { new StringAttribute("C_ERR", getDateDebutPeriode_C_ERR()) });
    
    pHandler.property("DateFinPeriode", getDateFinPeriode(), new Attribute[] { new StringAttribute("C_ERR", getDateFinPeriode_C_ERR()) });
    
    pHandler.property("DateFichierExterne", getDateFichierExterne(), new Attribute[] { new StringAttribute("C_ERR", getDateFichierExterne_C_ERR()) });
    
    pHandler.property("DateTraitement", getDateTraitement(), new Attribute[] { new StringAttribute("C_ERR", getDateTraitement_C_ERR()) });
    
    pHandler.property("SieclePeriodeRef", getSieclePeriodeRef(), new Attribute[] { new StringAttribute("C_ERR", getSieclePeriodeRef_C_ERR()) });
    
    pHandler.property("MoisPeriodeRef", getMoisPeriodeRef(), new Attribute[] { new StringAttribute("C_ERR", getMoisPeriodeRef_C_ERR()) });
    
    pHandler.property("SalaireBrut", getSalaireBrut(), new Attribute[] { new StringAttribute("C_ERR", getSalaireBrut_C_ERR()) });
    
    pHandler.property("MontantIccp", getMontantIccp(), new Attribute[] { new StringAttribute("C_ERR", getMontantIccp_C_ERR()) });
    
    pHandler.property("NombreHeuresMission", getNombreHeuresMission(), new Attribute[] { new StringAttribute("C_ERR", getNombreHeuresMission_C_ERR()) });
    
    pHandler.property("MontantIfm", getMontantIfm(), new Attribute[] { new StringAttribute("C_ERR", getMontantIfm_C_ERR()) });
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
    setNir((String)pHandler.objectProperty("Nir", String.class));
    setNir_C_ERR(pHandler.stringAttribute("Nir", "C_ERR"));
    
    setNom((String)pHandler.objectProperty("Nom", String.class));
    setNom_C_ERR(pHandler.stringAttribute("Nom", "C_ERR"));
    
    setPrenom((String)pHandler.objectProperty("Prenom", String.class));
    setPrenom_C_ERR(pHandler.stringAttribute("Prenom", "C_ERR"));
    
    setCodeNationalite((String)pHandler.objectProperty("CodeNationalite", String.class));
    setCodeNationalite_C_ERR(pHandler.stringAttribute("CodeNationalite", "C_ERR"));
    
    setCodePostal((String)pHandler.objectProperty("CodePostal", String.class));
    setCodePostal_C_ERR(pHandler.stringAttribute("CodePostal", "C_ERR"));
    
    setIdentifiantBNE((String)pHandler.objectProperty("IdentifiantBNE", String.class));
    setIdentifiantBNE_C_ERR(pHandler.stringAttribute("IdentifiantBNE", "C_ERR"));
    
    setSiret((String)pHandler.objectProperty("Siret", String.class));
    setSiret_C_ERR(pHandler.stringAttribute("Siret", "C_ERR"));
    
    setRaisonSociale((String)pHandler.objectProperty("RaisonSociale", String.class));
    setRaisonSociale_C_ERR(pHandler.stringAttribute("RaisonSociale", "C_ERR"));
    
    setNumeroVoie((String)pHandler.objectProperty("NumeroVoie", String.class));
    setNumeroVoie_C_ERR(pHandler.stringAttribute("NumeroVoie", "C_ERR"));
    
    setLibelleVoie((String)pHandler.objectProperty("LibelleVoie", String.class));
    setLibelleVoie_C_ERR(pHandler.stringAttribute("LibelleVoie", "C_ERR"));
    
    setComplementAdresse((String)pHandler.objectProperty("ComplementAdresse", String.class));
    setComplementAdresse_C_ERR(pHandler.stringAttribute("ComplementAdresse", "C_ERR"));
    
    setCodePostalETT((String)pHandler.objectProperty("CodePostalETT", String.class));
    setCodePostalETT_C_ERR(pHandler.stringAttribute("CodePostalETT", "C_ERR"));
    
    setLibelleCommuneCNAVTS((String)pHandler.objectProperty("LibelleCommuneCNAVTS", String.class));
    setLibelleCommuneCNAVTS_C_ERR(pHandler.stringAttribute("LibelleCommuneCNAVTS", "C_ERR"));
    
    setIndicateurRappelSalaire((String)pHandler.objectProperty("IndicateurRappelSalaire", String.class));
    setIndicateurRappelSalaire_C_ERR(pHandler.stringAttribute("IndicateurRappelSalaire", "C_ERR"));
    
    setCodeMonnaie((String)pHandler.objectProperty("CodeMonnaie", String.class));
    setCodeMonnaie_C_ERR(pHandler.stringAttribute("CodeMonnaie", "C_ERR"));
    
    setMotifFinContrat((String)pHandler.objectProperty("MotifFinContrat", String.class));
    setMotifFinContrat_C_ERR(pHandler.stringAttribute("MotifFinContrat", "C_ERR"));
    
    setNumeroContrat((String)pHandler.objectProperty("NumeroContrat", String.class));
    setNumeroContrat_C_ERR(pHandler.stringAttribute("NumeroContrat", "C_ERR"));
    
    setCaisseAgirc((String)pHandler.objectProperty("CaisseAgirc", String.class));
    setCaisseAgirc_C_ERR(pHandler.stringAttribute("CaisseAgirc", "C_ERR"));
    
    setCaisseArrco((String)pHandler.objectProperty("CaisseArrco", String.class));
    setCaisseArrco_C_ERR(pHandler.stringAttribute("CaisseArrco", "C_ERR"));
    
    setCadre((String)pHandler.objectProperty("Cadre", String.class));
    setCadre_C_ERR(pHandler.stringAttribute("Cadre", "C_ERR"));
    
    setDernierEmploiTenu((String)pHandler.objectProperty("DernierEmploiTenu", String.class));
    setDernierEmploiTenu_C_ERR(pHandler.stringAttribute("DernierEmploiTenu", "C_ERR"));
    
    setNiveauQualification((String)pHandler.objectProperty("NiveauQualification", String.class));
    setNiveauQualification_C_ERR(pHandler.stringAttribute("NiveauQualification", "C_ERR"));
    
    setIndicateurQualiteNIR((String)pHandler.objectProperty("IndicateurQualiteNIR", String.class));
    setIndicateurQualiteNIR_C_ERR(pHandler.stringAttribute("IndicateurQualiteNIR", "C_ERR"));
    
    setLieuMission((String)pHandler.objectProperty("LieuMission", String.class));
    setLieuMission_C_ERR(pHandler.stringAttribute("LieuMission", "C_ERR"));
    
    setFiller((String)pHandler.objectProperty("Filler", String.class));
    setFiller_C_ERR(pHandler.stringAttribute("Filler", "C_ERR"));
    
    setBneSiret((String)pHandler.objectProperty("BneSiret", String.class));
    setBneSiret_C_ERR(pHandler.stringAttribute("BneSiret", "C_ERR"));
    
    setBneRaisonSociale((String)pHandler.objectProperty("BneRaisonSociale", String.class));
    setBneRaisonSociale_C_ERR(pHandler.stringAttribute("BneRaisonSociale", "C_ERR"));
    
    setBneNumeroVoirie((String)pHandler.objectProperty("BneNumeroVoirie", String.class));
    setBneNumeroVoirie_C_ERR(pHandler.stringAttribute("BneNumeroVoirie", "C_ERR"));
    
    setBneLibelleVoieAdresse((String)pHandler.objectProperty("BneLibelleVoieAdresse", String.class));
    setBneLibelleVoieAdresse_C_ERR(pHandler.stringAttribute("BneLibelleVoieAdresse", "C_ERR"));
    
    setBneComplAdresse((String)pHandler.objectProperty("BneComplAdresse", String.class));
    setBneComplAdresse_C_ERR(pHandler.stringAttribute("BneComplAdresse", "C_ERR"));
    
    setBneCodePostal((String)pHandler.objectProperty("BneCodePostal", String.class));
    setBneCodePostal_C_ERR(pHandler.stringAttribute("BneCodePostal", "C_ERR"));
    
    setBneLibelleCommune((String)pHandler.objectProperty("BneLibelleCommune", String.class));
    setBneLibelleCommune_C_ERR(pHandler.stringAttribute("BneLibelleCommune", "C_ERR"));
    
    setBneAssedicAffiliation((String)pHandler.objectProperty("BneAssedicAffiliation", String.class));
    setBneAssedicAffiliation_C_ERR(pHandler.stringAttribute("BneAssedicAffiliation", "C_ERR"));
    
    setBneNumAffiliation((String)pHandler.objectProperty("BneNumAffiliation", String.class));
    setBneNumAffiliation_C_ERR(pHandler.stringAttribute("BneNumAffiliation", "C_ERR"));
    
    setBneRetraiteAgirc1((String)pHandler.objectProperty("BneRetraiteAgirc1", String.class));
    setBneRetraiteAgirc1_C_ERR(pHandler.stringAttribute("BneRetraiteAgirc1", "C_ERR"));
    
    setBneRetraiteAgirc2((String)pHandler.objectProperty("BneRetraiteAgirc2", String.class));
    setBneRetraiteAgirc2_C_ERR(pHandler.stringAttribute("BneRetraiteAgirc2", "C_ERR"));
    
    setBneLibelleRetraiteAgirc1((String)pHandler.objectProperty("BneLibelleRetraiteAgirc1", String.class));
    setBneLibelleRetraiteAgirc1_C_ERR(pHandler.stringAttribute("BneLibelleRetraiteAgirc1", "C_ERR"));
    
    setBneLibelleRetraiteAgirc2((String)pHandler.objectProperty("BneLibelleRetraiteAgirc2", String.class));
    setBneLibelleRetraiteAgirc2_C_ERR(pHandler.stringAttribute("BneLibelleRetraiteAgirc2", "C_ERR"));
    
    setBneIdentifiantBne((String)pHandler.objectProperty("BneIdentifiantBne", String.class));
    setBneIdentifiantBne_C_ERR(pHandler.stringAttribute("BneIdentifiantBne", "C_ERR"));
    
    setIndicateurMontantIccp((String)pHandler.objectProperty("IndicateurMontantIccp", String.class));
    setIndicateurMontantIccp_C_ERR(pHandler.stringAttribute("IndicateurMontantIccp", "C_ERR"));
    
    setIndicateurMotifFinContrat((String)pHandler.objectProperty("IndicateurMotifFinContrat", String.class));
    setIndicateurMotifFinContrat_C_ERR(pHandler.stringAttribute("IndicateurMotifFinContrat", "C_ERR"));
    
    setIndicateurNombreHeuresMision((String)pHandler.objectProperty("IndicateurNombreHeuresMision", String.class));
    setIndicateurNombreHeuresMision_C_ERR(pHandler.stringAttribute("IndicateurNombreHeuresMision", "C_ERR"));
    
    setIndicateurMontantIfm((String)pHandler.objectProperty("IndicateurMontantIfm", String.class));
    setIndicateurMontantIfm_C_ERR(pHandler.stringAttribute("IndicateurMontantIfm", "C_ERR"));
    
    setIndicateurRappelMission((String)pHandler.objectProperty("IndicateurRappelMission", String.class));
    setIndicateurRappelMission_C_ERR(pHandler.stringAttribute("IndicateurRappelMission", "C_ERR"));
    
    setIndicateurNouveauProtocole((String)pHandler.objectProperty("IndicateurNouveauProtocole", String.class));
    setIndicateurNouveauProtocole_C_ERR(pHandler.stringAttribute("IndicateurNouveauProtocole", "C_ERR"));
    
    setNumeroDocument((String)pHandler.objectProperty("NumeroDocument", String.class));
    setNumeroDocument_C_ERR(pHandler.stringAttribute("NumeroDocument", "C_ERR"));
    
    setDateNaissance((Damj)pHandler.objectProperty("DateNaissance", Damj.class));
    setDateNaissance_C_ERR(pHandler.stringAttribute("DateNaissance", "C_ERR"));
    
    setDateDebutPeriode((Damj)pHandler.objectProperty("DateDebutPeriode", Damj.class));
    setDateDebutPeriode_C_ERR(pHandler.stringAttribute("DateDebutPeriode", "C_ERR"));
    
    setDateFinPeriode((Damj)pHandler.objectProperty("DateFinPeriode", Damj.class));
    setDateFinPeriode_C_ERR(pHandler.stringAttribute("DateFinPeriode", "C_ERR"));
    
    setDateFichierExterne((Damj)pHandler.objectProperty("DateFichierExterne", Damj.class));
    setDateFichierExterne_C_ERR(pHandler.stringAttribute("DateFichierExterne", "C_ERR"));
    
    setDateTraitement((Damj)pHandler.objectProperty("DateTraitement", Damj.class));
    setDateTraitement_C_ERR(pHandler.stringAttribute("DateTraitement", "C_ERR"));
    
    setSieclePeriodeRef((BigDecimal)pHandler.objectProperty("SieclePeriodeRef", BigDecimal.class));
    setSieclePeriodeRef_C_ERR(pHandler.stringAttribute("SieclePeriodeRef", "C_ERR"));
    
    setMoisPeriodeRef((BigDecimal)pHandler.objectProperty("MoisPeriodeRef", BigDecimal.class));
    setMoisPeriodeRef_C_ERR(pHandler.stringAttribute("MoisPeriodeRef", "C_ERR"));
    
    setSalaireBrut((BigDecimal)pHandler.objectProperty("SalaireBrut", BigDecimal.class));
    setSalaireBrut_C_ERR(pHandler.stringAttribute("SalaireBrut", "C_ERR"));
    
    setMontantIccp((BigDecimal)pHandler.objectProperty("MontantIccp", BigDecimal.class));
    setMontantIccp_C_ERR(pHandler.stringAttribute("MontantIccp", "C_ERR"));
    
    setNombreHeuresMission((BigDecimal)pHandler.objectProperty("NombreHeuresMission", BigDecimal.class));
    setNombreHeuresMission_C_ERR(pHandler.stringAttribute("NombreHeuresMission", "C_ERR"));
    
    setMontantIfm((BigDecimal)pHandler.objectProperty("MontantIfm", BigDecimal.class));
    setMontantIfm_C_ERR(pHandler.stringAttribute("MontantIfm", "C_ERR"));
  }
  
  public String _getDatabeanName()
  {
    return "FluxDMM";
  }
  
  public boolean _isValidProperty(String pElementName)
  {
    if ("Nir".equals(pElementName)) {
      return true;
    }
    if ("Nom".equals(pElementName)) {
      return true;
    }
    if ("Prenom".equals(pElementName)) {
      return true;
    }
    if ("CodeNationalite".equals(pElementName)) {
      return true;
    }
    if ("CodePostal".equals(pElementName)) {
      return true;
    }
    if ("IdentifiantBNE".equals(pElementName)) {
      return true;
    }
    if ("Siret".equals(pElementName)) {
      return true;
    }
    if ("RaisonSociale".equals(pElementName)) {
      return true;
    }
    if ("NumeroVoie".equals(pElementName)) {
      return true;
    }
    if ("LibelleVoie".equals(pElementName)) {
      return true;
    }
    if ("ComplementAdresse".equals(pElementName)) {
      return true;
    }
    if ("CodePostalETT".equals(pElementName)) {
      return true;
    }
    if ("LibelleCommuneCNAVTS".equals(pElementName)) {
      return true;
    }
    if ("IndicateurRappelSalaire".equals(pElementName)) {
      return true;
    }
    if ("CodeMonnaie".equals(pElementName)) {
      return true;
    }
    if ("MotifFinContrat".equals(pElementName)) {
      return true;
    }
    if ("NumeroContrat".equals(pElementName)) {
      return true;
    }
    if ("CaisseAgirc".equals(pElementName)) {
      return true;
    }
    if ("CaisseArrco".equals(pElementName)) {
      return true;
    }
    if ("Cadre".equals(pElementName)) {
      return true;
    }
    if ("DernierEmploiTenu".equals(pElementName)) {
      return true;
    }
    if ("NiveauQualification".equals(pElementName)) {
      return true;
    }
    if ("IndicateurQualiteNIR".equals(pElementName)) {
      return true;
    }
    if ("LieuMission".equals(pElementName)) {
      return true;
    }
    if ("Filler".equals(pElementName)) {
      return true;
    }
    if ("BneSiret".equals(pElementName)) {
      return true;
    }
    if ("BneRaisonSociale".equals(pElementName)) {
      return true;
    }
    if ("BneNumeroVoirie".equals(pElementName)) {
      return true;
    }
    if ("BneLibelleVoieAdresse".equals(pElementName)) {
      return true;
    }
    if ("BneComplAdresse".equals(pElementName)) {
      return true;
    }
    if ("BneCodePostal".equals(pElementName)) {
      return true;
    }
    if ("BneLibelleCommune".equals(pElementName)) {
      return true;
    }
    if ("BneAssedicAffiliation".equals(pElementName)) {
      return true;
    }
    if ("BneNumAffiliation".equals(pElementName)) {
      return true;
    }
    if ("BneRetraiteAgirc1".equals(pElementName)) {
      return true;
    }
    if ("BneRetraiteAgirc2".equals(pElementName)) {
      return true;
    }
    if ("BneLibelleRetraiteAgirc1".equals(pElementName)) {
      return true;
    }
    if ("BneLibelleRetraiteAgirc2".equals(pElementName)) {
      return true;
    }
    if ("BneIdentifiantBne".equals(pElementName)) {
      return true;
    }
    if ("IndicateurMontantIccp".equals(pElementName)) {
      return true;
    }
    if ("IndicateurMotifFinContrat".equals(pElementName)) {
      return true;
    }
    if ("IndicateurNombreHeuresMision".equals(pElementName)) {
      return true;
    }
    if ("IndicateurMontantIfm".equals(pElementName)) {
      return true;
    }
    if ("IndicateurRappelMission".equals(pElementName)) {
      return true;
    }
    if ("IndicateurNouveauProtocole".equals(pElementName)) {
      return true;
    }
    if ("NumeroDocument".equals(pElementName)) {
      return true;
    }
    if ("DateNaissance".equals(pElementName)) {
      return true;
    }
    if ("DateDebutPeriode".equals(pElementName)) {
      return true;
    }
    if ("DateFinPeriode".equals(pElementName)) {
      return true;
    }
    if ("DateFichierExterne".equals(pElementName)) {
      return true;
    }
    if ("DateTraitement".equals(pElementName)) {
      return true;
    }
    if ("SieclePeriodeRef".equals(pElementName)) {
      return true;
    }
    if ("MoisPeriodeRef".equals(pElementName)) {
      return true;
    }
    if ("SalaireBrut".equals(pElementName)) {
      return true;
    }
    if ("MontantIccp".equals(pElementName)) {
      return true;
    }
    if ("NombreHeuresMission".equals(pElementName)) {
      return true;
    }
    if ("MontantIfm".equals(pElementName)) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _FluxDMM
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */