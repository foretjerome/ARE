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

public class _FluxAEM
  extends DataBeanImpl
  implements DataBean, Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  private String m__C_ETAT;
  private String m__IDENT;
  private String m_bneSiret;
  private String m_bneSiret_C_ERR;
  private String m_bNEEmployeur;
  private String m_bNEEmployeur_C_ERR;
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
  private String m_codeAction;
  private String m_codeAction_C_ERR;
  private String m_indicateurType;
  private String m_indicateurType_C_ERR;
  private String m_numeroInitial;
  private String m_numeroInitial_C_ERR;
  private String m_numero;
  private String m_numero_C_ERR;
  private String m_siretEmployeur;
  private String m_siretEmployeur_C_ERR;
  private String m_codeNafApe;
  private String m_codeNafApe_C_ERR;
  private String m_numAssedicAffiliation;
  private String m_numAssedicAffiliation_C_ERR;
  private String m_numeroAffiliation;
  private String m_numeroAffiliation_C_ERR;
  private String m_raisonSociale;
  private String m_raisonSociale_C_ERR;
  private String m_adresseEmployeur;
  private String m_adresseEmployeur_C_ERR;
  private String m_complAdresseEmployeur;
  private String m_complAdresseEmployeur_C_ERR;
  private String m_telephoneEmployeur;
  private String m_telephoneEmployeur_C_ERR;
  private String m_faxEmployeur;
  private String m_faxEmployeur_C_ERR;
  private String m_courrielEmployeur;
  private String m_courrielEmployeur_C_ERR;
  private String m_codePostalEmployeur;
  private String m_codePostalEmployeur_C_ERR;
  private String m_communeEmployeur;
  private String m_communeEmployeur_C_ERR;
  private String m_formeJuridique;
  private String m_formeJuridique_C_ERR;
  private String m_activiteEmployeur;
  private String m_activiteEmployeur_C_ERR;
  private String m_licenceSpectacle;
  private String m_licenceSpectacle_C_ERR;
  private String m_numeroLicenceSpe;
  private String m_numeroLicenceSpe_C_ERR;
  private String m_organisateurOccasionnelspe;
  private String m_organisateurOccasionnelspe_C_ERR;
  private String m_titulaireLabelPresta;
  private String m_titulaireLabelPresta_C_ERR;
  private String m_numeroLabelPrestaSer;
  private String m_numeroLabelPrestaSer_C_ERR;
  private String m_numAffiCaisseConges;
  private String m_numAffiCaisseConges_C_ERR;
  private String m_nomSalarie;
  private String m_nomSalarie_C_ERR;
  private String m_prenomSalarie;
  private String m_prenomSalarie_C_ERR;
  private String m_nomUsuel;
  private String m_nomUsuel_C_ERR;
  private String m_telephoneSalarie;
  private String m_telephoneSalarie_C_ERR;
  private String m_NIR;
  private String m_NIR_C_ERR;
  private String m_adresseSalarie;
  private String m_adresseSalarie_C_ERR;
  private String m_complementAdresseSalarie;
  private String m_complementAdresseSalarie_C_ERR;
  private String m_codePostalSalarie;
  private String m_codePostalSalarie_C_ERR;
  private String m_communeSalarie;
  private String m_communeSalarie_C_ERR;
  private String m_lienParente;
  private String m_lienParente_C_ERR;
  private String m_typeLienParente;
  private String m_typeLienParente_C_ERR;
  private String m_codeEmploiOccupe;
  private String m_codeEmploiOccupe_C_ERR;
  private String m_codeQualification;
  private String m_codeQualification_C_ERR;
  private String m_regimeRetraiteCompl;
  private String m_regimeRetraiteCompl_C_ERR;
  private String m_statutCadre;
  private String m_statutCadre_C_ERR;
  private String m_contratEnCours;
  private String m_contratEnCours_C_ERR;
  private String m_motiFinContrat;
  private String m_motiFinContrat_C_ERR;
  private String m_nomEmployeur;
  private String m_nomEmployeur_C_ERR;
  private String m_prenomEmployeur;
  private String m_prenomEmployeur_C_ERR;
  private String m_qualite;
  private String m_qualite_C_ERR;
  private String m_motifRupture;
  private String m_motifRupture_C_ERR;
  private String m_communeSignature;
  private String m_communeSignature_C_ERR;
  private String m_contactAEM;
  private String m_contactAEM_C_ERR;
  private String m_telephoneTiers;
  private String m_telephoneTiers_C_ERR;
  private String m_codeOrganisme;
  private String m_codeOrganisme_C_ERR;
  private String m_nbJoursTravailles;
  private String m_nbJoursTravailles_C_ERR;
  private String m_numVersionAEM;
  private String m_numVersionAEM_C_ERR;
  private String m_affiCaisseConges;
  private String m_affiCaisseConges_C_ERR;
  private String m_numeroObjet;
  private String m_numeroObjet_C_ERR;
  private String m_indicateurHorsChamp;
  private String m_indicateurHorsChamp_C_ERR;
  private String m_nouveauCodeApeNaf;
  private String m_nouveauCodeApeNaf_C_ERR;
  private Damj m_dateNaissance;
  private String m_dateNaissance_C_ERR;
  private Damj m_dateFincontrat;
  private String m_dateFincontrat_C_ERR;
  private Damj m_dateEmbauche;
  private String m_dateEmbauche_C_ERR;
  private Damj m_dateSignature;
  private String m_dateSignature_C_ERR;
  private Damj m_dateFichierExt;
  private String m_dateFichierExt_C_ERR;
  private Damj m_dateCreation;
  private String m_dateCreation_C_ERR;
  private Damj m_dateInitialeFinCDD;
  private String m_dateInitialeFinCDD_C_ERR;
  private BigDecimal m_nbHeures;
  private String m_nbHeures_C_ERR;
  private BigDecimal m_nbCachets;
  private String m_nbCachets_C_ERR;
  private BigDecimal m_salaireBrutAvtAbatt;
  private String m_salaireBrutAvtAbatt_C_ERR;
  private BigDecimal m_salaireBrutAprAbatt;
  private String m_salaireBrutAprAbatt_C_ERR;
  private BigDecimal m_tauxAbatt;
  private String m_tauxAbatt_C_ERR;
  private BigDecimal m_contributionDues;
  private String m_contributionDues_C_ERR;
  private BigDecimal m_moisActualisation;
  private String m_moisActualisation_C_ERR;
  private BigDecimal m_anneeActualisation;
  private String m_anneeActualisation_C_ERR;
  private BigDecimal m_nbCachetsIsoles;
  private String m_nbCachetsIsoles_C_ERR;
  private BigDecimal m_nbCachetsGroupes;
  private String m_nbCachetsGroupes_C_ERR;
  private BigDecimal m_autresRemunerationsMontantBrut;
  private String m_autresRemunerationsMontantBrut_C_ERR;
  private BigDecimal m_autresRemunerationsTauxContributions;
  private String m_autresRemunerationsTauxContributions_C_ERR;
  private BigDecimal m_autresRemunerationsContributionsDues;
  private String m_autresRemunerationsContributionsDues_C_ERR;
  private BigDecimal m_totalContributionsDues;
  private String m_totalContributionsDues_C_ERR;
  private String m_bneCertifSociale;
  private String m_bneCertifSociale_C_ERR;
  private String m_idccEmployeur;
  private String m_idccEmployeur_C_ERR;
  private String m_idccPrestation;
  private String m_idccPrestation_C_ERR;
  private String m_ressortissant;
  private String m_ressortissant_C_ERR;
  private String m_indicateurCertifSociale;
  private String m_indicateurCertifSociale_C_ERR;
  private String m_numCertifSociale;
  private String m_numCertifSociale_C_ERR;
  
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
  
  public String getBNEEmployeur()
  {
    return m_bNEEmployeur;
  }
  
  public String getBNEEmployeur_C_ERR()
  {
    return m_bNEEmployeur_C_ERR;
  }
  
  public void setBNEEmployeur(String pValeur)
  {
    m_bNEEmployeur = pValeur;
  }
  
  public void setBNEEmployeur_C_ERR(String pValeur_C_ERR)
  {
    m_bNEEmployeur_C_ERR = pValeur_C_ERR;
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
  
  public String getIndicateurType()
  {
    return m_indicateurType;
  }
  
  public String getIndicateurType_C_ERR()
  {
    return m_indicateurType_C_ERR;
  }
  
  public void setIndicateurType(String pValeur)
  {
    m_indicateurType = pValeur;
  }
  
  public void setIndicateurType_C_ERR(String pValeur_C_ERR)
  {
    m_indicateurType_C_ERR = pValeur_C_ERR;
  }
  
  public String getNumeroInitial()
  {
    return m_numeroInitial;
  }
  
  public String getNumeroInitial_C_ERR()
  {
    return m_numeroInitial_C_ERR;
  }
  
  public void setNumeroInitial(String pValeur)
  {
    m_numeroInitial = pValeur;
  }
  
  public void setNumeroInitial_C_ERR(String pValeur_C_ERR)
  {
    m_numeroInitial_C_ERR = pValeur_C_ERR;
  }
  
  public String getNumero()
  {
    return m_numero;
  }
  
  public String getNumero_C_ERR()
  {
    return m_numero_C_ERR;
  }
  
  public void setNumero(String pValeur)
  {
    m_numero = pValeur;
  }
  
  public void setNumero_C_ERR(String pValeur_C_ERR)
  {
    m_numero_C_ERR = pValeur_C_ERR;
  }
  
  public String getSiretEmployeur()
  {
    return m_siretEmployeur;
  }
  
  public String getSiretEmployeur_C_ERR()
  {
    return m_siretEmployeur_C_ERR;
  }
  
  public void setSiretEmployeur(String pValeur)
  {
    m_siretEmployeur = pValeur;
  }
  
  public void setSiretEmployeur_C_ERR(String pValeur_C_ERR)
  {
    m_siretEmployeur_C_ERR = pValeur_C_ERR;
  }
  
  public String getCodeNafApe()
  {
    return m_codeNafApe;
  }
  
  public String getCodeNafApe_C_ERR()
  {
    return m_codeNafApe_C_ERR;
  }
  
  public void setCodeNafApe(String pValeur)
  {
    m_codeNafApe = pValeur;
  }
  
  public void setCodeNafApe_C_ERR(String pValeur_C_ERR)
  {
    m_codeNafApe_C_ERR = pValeur_C_ERR;
  }
  
  public String getNumAssedicAffiliation()
  {
    return m_numAssedicAffiliation;
  }
  
  public String getNumAssedicAffiliation_C_ERR()
  {
    return m_numAssedicAffiliation_C_ERR;
  }
  
  public void setNumAssedicAffiliation(String pValeur)
  {
    m_numAssedicAffiliation = pValeur;
  }
  
  public void setNumAssedicAffiliation_C_ERR(String pValeur_C_ERR)
  {
    m_numAssedicAffiliation_C_ERR = pValeur_C_ERR;
  }
  
  public String getNumeroAffiliation()
  {
    return m_numeroAffiliation;
  }
  
  public String getNumeroAffiliation_C_ERR()
  {
    return m_numeroAffiliation_C_ERR;
  }
  
  public void setNumeroAffiliation(String pValeur)
  {
    m_numeroAffiliation = pValeur;
  }
  
  public void setNumeroAffiliation_C_ERR(String pValeur_C_ERR)
  {
    m_numeroAffiliation_C_ERR = pValeur_C_ERR;
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
  
  public String getAdresseEmployeur()
  {
    return m_adresseEmployeur;
  }
  
  public String getAdresseEmployeur_C_ERR()
  {
    return m_adresseEmployeur_C_ERR;
  }
  
  public void setAdresseEmployeur(String pValeur)
  {
    m_adresseEmployeur = pValeur;
  }
  
  public void setAdresseEmployeur_C_ERR(String pValeur_C_ERR)
  {
    m_adresseEmployeur_C_ERR = pValeur_C_ERR;
  }
  
  public String getComplAdresseEmployeur()
  {
    return m_complAdresseEmployeur;
  }
  
  public String getComplAdresseEmployeur_C_ERR()
  {
    return m_complAdresseEmployeur_C_ERR;
  }
  
  public void setComplAdresseEmployeur(String pValeur)
  {
    m_complAdresseEmployeur = pValeur;
  }
  
  public void setComplAdresseEmployeur_C_ERR(String pValeur_C_ERR)
  {
    m_complAdresseEmployeur_C_ERR = pValeur_C_ERR;
  }
  
  public String getTelephoneEmployeur()
  {
    return m_telephoneEmployeur;
  }
  
  public String getTelephoneEmployeur_C_ERR()
  {
    return m_telephoneEmployeur_C_ERR;
  }
  
  public void setTelephoneEmployeur(String pValeur)
  {
    m_telephoneEmployeur = pValeur;
  }
  
  public void setTelephoneEmployeur_C_ERR(String pValeur_C_ERR)
  {
    m_telephoneEmployeur_C_ERR = pValeur_C_ERR;
  }
  
  public String getFaxEmployeur()
  {
    return m_faxEmployeur;
  }
  
  public String getFaxEmployeur_C_ERR()
  {
    return m_faxEmployeur_C_ERR;
  }
  
  public void setFaxEmployeur(String pValeur)
  {
    m_faxEmployeur = pValeur;
  }
  
  public void setFaxEmployeur_C_ERR(String pValeur_C_ERR)
  {
    m_faxEmployeur_C_ERR = pValeur_C_ERR;
  }
  
  public String getCourrielEmployeur()
  {
    return m_courrielEmployeur;
  }
  
  public String getCourrielEmployeur_C_ERR()
  {
    return m_courrielEmployeur_C_ERR;
  }
  
  public void setCourrielEmployeur(String pValeur)
  {
    m_courrielEmployeur = pValeur;
  }
  
  public void setCourrielEmployeur_C_ERR(String pValeur_C_ERR)
  {
    m_courrielEmployeur_C_ERR = pValeur_C_ERR;
  }
  
  public String getCodePostalEmployeur()
  {
    return m_codePostalEmployeur;
  }
  
  public String getCodePostalEmployeur_C_ERR()
  {
    return m_codePostalEmployeur_C_ERR;
  }
  
  public void setCodePostalEmployeur(String pValeur)
  {
    m_codePostalEmployeur = pValeur;
  }
  
  public void setCodePostalEmployeur_C_ERR(String pValeur_C_ERR)
  {
    m_codePostalEmployeur_C_ERR = pValeur_C_ERR;
  }
  
  public String getCommuneEmployeur()
  {
    return m_communeEmployeur;
  }
  
  public String getCommuneEmployeur_C_ERR()
  {
    return m_communeEmployeur_C_ERR;
  }
  
  public void setCommuneEmployeur(String pValeur)
  {
    m_communeEmployeur = pValeur;
  }
  
  public void setCommuneEmployeur_C_ERR(String pValeur_C_ERR)
  {
    m_communeEmployeur_C_ERR = pValeur_C_ERR;
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
  
  public String getActiviteEmployeur()
  {
    return m_activiteEmployeur;
  }
  
  public String getActiviteEmployeur_C_ERR()
  {
    return m_activiteEmployeur_C_ERR;
  }
  
  public void setActiviteEmployeur(String pValeur)
  {
    m_activiteEmployeur = pValeur;
  }
  
  public void setActiviteEmployeur_C_ERR(String pValeur_C_ERR)
  {
    m_activiteEmployeur_C_ERR = pValeur_C_ERR;
  }
  
  public String getLicenceSpectacle()
  {
    return m_licenceSpectacle;
  }
  
  public String getLicenceSpectacle_C_ERR()
  {
    return m_licenceSpectacle_C_ERR;
  }
  
  public void setLicenceSpectacle(String pValeur)
  {
    m_licenceSpectacle = pValeur;
  }
  
  public void setLicenceSpectacle_C_ERR(String pValeur_C_ERR)
  {
    m_licenceSpectacle_C_ERR = pValeur_C_ERR;
  }
  
  public String getNumeroLicenceSpe()
  {
    return m_numeroLicenceSpe;
  }
  
  public String getNumeroLicenceSpe_C_ERR()
  {
    return m_numeroLicenceSpe_C_ERR;
  }
  
  public void setNumeroLicenceSpe(String pValeur)
  {
    m_numeroLicenceSpe = pValeur;
  }
  
  public void setNumeroLicenceSpe_C_ERR(String pValeur_C_ERR)
  {
    m_numeroLicenceSpe_C_ERR = pValeur_C_ERR;
  }
  
  public String getOrganisateurOccasionnelspe()
  {
    return m_organisateurOccasionnelspe;
  }
  
  public String getOrganisateurOccasionnelspe_C_ERR()
  {
    return m_organisateurOccasionnelspe_C_ERR;
  }
  
  public void setOrganisateurOccasionnelspe(String pValeur)
  {
    m_organisateurOccasionnelspe = pValeur;
  }
  
  public void setOrganisateurOccasionnelspe_C_ERR(String pValeur_C_ERR)
  {
    m_organisateurOccasionnelspe_C_ERR = pValeur_C_ERR;
  }
  
  public String getTitulaireLabelPresta()
  {
    return m_titulaireLabelPresta;
  }
  
  public String getTitulaireLabelPresta_C_ERR()
  {
    return m_titulaireLabelPresta_C_ERR;
  }
  
  public void setTitulaireLabelPresta(String pValeur)
  {
    m_titulaireLabelPresta = pValeur;
  }
  
  public void setTitulaireLabelPresta_C_ERR(String pValeur_C_ERR)
  {
    m_titulaireLabelPresta_C_ERR = pValeur_C_ERR;
  }
  
  public String getNumeroLabelPrestaSer()
  {
    return m_numeroLabelPrestaSer;
  }
  
  public String getNumeroLabelPrestaSer_C_ERR()
  {
    return m_numeroLabelPrestaSer_C_ERR;
  }
  
  public void setNumeroLabelPrestaSer(String pValeur)
  {
    m_numeroLabelPrestaSer = pValeur;
  }
  
  public void setNumeroLabelPrestaSer_C_ERR(String pValeur_C_ERR)
  {
    m_numeroLabelPrestaSer_C_ERR = pValeur_C_ERR;
  }
  
  public String getNumAffiCaisseConges()
  {
    return m_numAffiCaisseConges;
  }
  
  public String getNumAffiCaisseConges_C_ERR()
  {
    return m_numAffiCaisseConges_C_ERR;
  }
  
  public void setNumAffiCaisseConges(String pValeur)
  {
    m_numAffiCaisseConges = pValeur;
  }
  
  public void setNumAffiCaisseConges_C_ERR(String pValeur_C_ERR)
  {
    m_numAffiCaisseConges_C_ERR = pValeur_C_ERR;
  }
  
  public String getNomSalarie()
  {
    return m_nomSalarie;
  }
  
  public String getNomSalarie_C_ERR()
  {
    return m_nomSalarie_C_ERR;
  }
  
  public void setNomSalarie(String pValeur)
  {
    m_nomSalarie = pValeur;
  }
  
  public void setNomSalarie_C_ERR(String pValeur_C_ERR)
  {
    m_nomSalarie_C_ERR = pValeur_C_ERR;
  }
  
  public String getPrenomSalarie()
  {
    return m_prenomSalarie;
  }
  
  public String getPrenomSalarie_C_ERR()
  {
    return m_prenomSalarie_C_ERR;
  }
  
  public void setPrenomSalarie(String pValeur)
  {
    m_prenomSalarie = pValeur;
  }
  
  public void setPrenomSalarie_C_ERR(String pValeur_C_ERR)
  {
    m_prenomSalarie_C_ERR = pValeur_C_ERR;
  }
  
  public String getNomUsuel()
  {
    return m_nomUsuel;
  }
  
  public String getNomUsuel_C_ERR()
  {
    return m_nomUsuel_C_ERR;
  }
  
  public void setNomUsuel(String pValeur)
  {
    m_nomUsuel = pValeur;
  }
  
  public void setNomUsuel_C_ERR(String pValeur_C_ERR)
  {
    m_nomUsuel_C_ERR = pValeur_C_ERR;
  }
  
  public String getTelephoneSalarie()
  {
    return m_telephoneSalarie;
  }
  
  public String getTelephoneSalarie_C_ERR()
  {
    return m_telephoneSalarie_C_ERR;
  }
  
  public void setTelephoneSalarie(String pValeur)
  {
    m_telephoneSalarie = pValeur;
  }
  
  public void setTelephoneSalarie_C_ERR(String pValeur_C_ERR)
  {
    m_telephoneSalarie_C_ERR = pValeur_C_ERR;
  }
  
  public String getNIR()
  {
    return m_NIR;
  }
  
  public String getNIR_C_ERR()
  {
    return m_NIR_C_ERR;
  }
  
  public void setNIR(String pValeur)
  {
    m_NIR = pValeur;
  }
  
  public void setNIR_C_ERR(String pValeur_C_ERR)
  {
    m_NIR_C_ERR = pValeur_C_ERR;
  }
  
  public String getAdresseSalarie()
  {
    return m_adresseSalarie;
  }
  
  public String getAdresseSalarie_C_ERR()
  {
    return m_adresseSalarie_C_ERR;
  }
  
  public void setAdresseSalarie(String pValeur)
  {
    m_adresseSalarie = pValeur;
  }
  
  public void setAdresseSalarie_C_ERR(String pValeur_C_ERR)
  {
    m_adresseSalarie_C_ERR = pValeur_C_ERR;
  }
  
  public String getComplementAdresseSalarie()
  {
    return m_complementAdresseSalarie;
  }
  
  public String getComplementAdresseSalarie_C_ERR()
  {
    return m_complementAdresseSalarie_C_ERR;
  }
  
  public void setComplementAdresseSalarie(String pValeur)
  {
    m_complementAdresseSalarie = pValeur;
  }
  
  public void setComplementAdresseSalarie_C_ERR(String pValeur_C_ERR)
  {
    m_complementAdresseSalarie_C_ERR = pValeur_C_ERR;
  }
  
  public String getCodePostalSalarie()
  {
    return m_codePostalSalarie;
  }
  
  public String getCodePostalSalarie_C_ERR()
  {
    return m_codePostalSalarie_C_ERR;
  }
  
  public void setCodePostalSalarie(String pValeur)
  {
    m_codePostalSalarie = pValeur;
  }
  
  public void setCodePostalSalarie_C_ERR(String pValeur_C_ERR)
  {
    m_codePostalSalarie_C_ERR = pValeur_C_ERR;
  }
  
  public String getCommuneSalarie()
  {
    return m_communeSalarie;
  }
  
  public String getCommuneSalarie_C_ERR()
  {
    return m_communeSalarie_C_ERR;
  }
  
  public void setCommuneSalarie(String pValeur)
  {
    m_communeSalarie = pValeur;
  }
  
  public void setCommuneSalarie_C_ERR(String pValeur_C_ERR)
  {
    m_communeSalarie_C_ERR = pValeur_C_ERR;
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
  
  public String getTypeLienParente()
  {
    return m_typeLienParente;
  }
  
  public String getTypeLienParente_C_ERR()
  {
    return m_typeLienParente_C_ERR;
  }
  
  public void setTypeLienParente(String pValeur)
  {
    m_typeLienParente = pValeur;
  }
  
  public void setTypeLienParente_C_ERR(String pValeur_C_ERR)
  {
    m_typeLienParente_C_ERR = pValeur_C_ERR;
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
  
  public String getCodeQualification()
  {
    return m_codeQualification;
  }
  
  public String getCodeQualification_C_ERR()
  {
    return m_codeQualification_C_ERR;
  }
  
  public void setCodeQualification(String pValeur)
  {
    m_codeQualification = pValeur;
  }
  
  public void setCodeQualification_C_ERR(String pValeur_C_ERR)
  {
    m_codeQualification_C_ERR = pValeur_C_ERR;
  }
  
  public String getRegimeRetraiteCompl()
  {
    return m_regimeRetraiteCompl;
  }
  
  public String getRegimeRetraiteCompl_C_ERR()
  {
    return m_regimeRetraiteCompl_C_ERR;
  }
  
  public void setRegimeRetraiteCompl(String pValeur)
  {
    m_regimeRetraiteCompl = pValeur;
  }
  
  public void setRegimeRetraiteCompl_C_ERR(String pValeur_C_ERR)
  {
    m_regimeRetraiteCompl_C_ERR = pValeur_C_ERR;
  }
  
  public String getStatutCadre()
  {
    return m_statutCadre;
  }
  
  public String getStatutCadre_C_ERR()
  {
    return m_statutCadre_C_ERR;
  }
  
  public void setStatutCadre(String pValeur)
  {
    m_statutCadre = pValeur;
  }
  
  public void setStatutCadre_C_ERR(String pValeur_C_ERR)
  {
    m_statutCadre_C_ERR = pValeur_C_ERR;
  }
  
  public String getContratEnCours()
  {
    return m_contratEnCours;
  }
  
  public String getContratEnCours_C_ERR()
  {
    return m_contratEnCours_C_ERR;
  }
  
  public void setContratEnCours(String pValeur)
  {
    m_contratEnCours = pValeur;
  }
  
  public void setContratEnCours_C_ERR(String pValeur_C_ERR)
  {
    m_contratEnCours_C_ERR = pValeur_C_ERR;
  }
  
  public String getMotiFinContrat()
  {
    return m_motiFinContrat;
  }
  
  public String getMotiFinContrat_C_ERR()
  {
    return m_motiFinContrat_C_ERR;
  }
  
  public void setMotiFinContrat(String pValeur)
  {
    m_motiFinContrat = pValeur;
  }
  
  public void setMotiFinContrat_C_ERR(String pValeur_C_ERR)
  {
    m_motiFinContrat_C_ERR = pValeur_C_ERR;
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
  
  public String getQualite()
  {
    return m_qualite;
  }
  
  public String getQualite_C_ERR()
  {
    return m_qualite_C_ERR;
  }
  
  public void setQualite(String pValeur)
  {
    m_qualite = pValeur;
  }
  
  public void setQualite_C_ERR(String pValeur_C_ERR)
  {
    m_qualite_C_ERR = pValeur_C_ERR;
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
  
  public String getCommuneSignature()
  {
    return m_communeSignature;
  }
  
  public String getCommuneSignature_C_ERR()
  {
    return m_communeSignature_C_ERR;
  }
  
  public void setCommuneSignature(String pValeur)
  {
    m_communeSignature = pValeur;
  }
  
  public void setCommuneSignature_C_ERR(String pValeur_C_ERR)
  {
    m_communeSignature_C_ERR = pValeur_C_ERR;
  }
  
  public String getContactAEM()
  {
    return m_contactAEM;
  }
  
  public String getContactAEM_C_ERR()
  {
    return m_contactAEM_C_ERR;
  }
  
  public void setContactAEM(String pValeur)
  {
    m_contactAEM = pValeur;
  }
  
  public void setContactAEM_C_ERR(String pValeur_C_ERR)
  {
    m_contactAEM_C_ERR = pValeur_C_ERR;
  }
  
  public String getTelephoneTiers()
  {
    return m_telephoneTiers;
  }
  
  public String getTelephoneTiers_C_ERR()
  {
    return m_telephoneTiers_C_ERR;
  }
  
  public void setTelephoneTiers(String pValeur)
  {
    m_telephoneTiers = pValeur;
  }
  
  public void setTelephoneTiers_C_ERR(String pValeur_C_ERR)
  {
    m_telephoneTiers_C_ERR = pValeur_C_ERR;
  }
  
  public String getCodeOrganisme()
  {
    return m_codeOrganisme;
  }
  
  public String getCodeOrganisme_C_ERR()
  {
    return m_codeOrganisme_C_ERR;
  }
  
  public void setCodeOrganisme(String pValeur)
  {
    m_codeOrganisme = pValeur;
  }
  
  public void setCodeOrganisme_C_ERR(String pValeur_C_ERR)
  {
    m_codeOrganisme_C_ERR = pValeur_C_ERR;
  }
  
  public String getNbJoursTravailles()
  {
    return m_nbJoursTravailles;
  }
  
  public String getNbJoursTravailles_C_ERR()
  {
    return m_nbJoursTravailles_C_ERR;
  }
  
  public void setNbJoursTravailles(String pValeur)
  {
    m_nbJoursTravailles = pValeur;
  }
  
  public void setNbJoursTravailles_C_ERR(String pValeur_C_ERR)
  {
    m_nbJoursTravailles_C_ERR = pValeur_C_ERR;
  }
  
  public String getNumVersionAEM()
  {
    return m_numVersionAEM;
  }
  
  public String getNumVersionAEM_C_ERR()
  {
    return m_numVersionAEM_C_ERR;
  }
  
  public void setNumVersionAEM(String pValeur)
  {
    m_numVersionAEM = pValeur;
  }
  
  public void setNumVersionAEM_C_ERR(String pValeur_C_ERR)
  {
    m_numVersionAEM_C_ERR = pValeur_C_ERR;
  }
  
  public String getAffiCaisseConges()
  {
    return m_affiCaisseConges;
  }
  
  public String getAffiCaisseConges_C_ERR()
  {
    return m_affiCaisseConges_C_ERR;
  }
  
  public void setAffiCaisseConges(String pValeur)
  {
    m_affiCaisseConges = pValeur;
  }
  
  public void setAffiCaisseConges_C_ERR(String pValeur_C_ERR)
  {
    m_affiCaisseConges_C_ERR = pValeur_C_ERR;
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
  
  public String getIndicateurHorsChamp()
  {
    return m_indicateurHorsChamp;
  }
  
  public String getIndicateurHorsChamp_C_ERR()
  {
    return m_indicateurHorsChamp_C_ERR;
  }
  
  public void setIndicateurHorsChamp(String pValeur)
  {
    m_indicateurHorsChamp = pValeur;
  }
  
  public void setIndicateurHorsChamp_C_ERR(String pValeur_C_ERR)
  {
    m_indicateurHorsChamp_C_ERR = pValeur_C_ERR;
  }
  
  public String getNouveauCodeApeNaf()
  {
    return m_nouveauCodeApeNaf;
  }
  
  public String getNouveauCodeApeNaf_C_ERR()
  {
    return m_nouveauCodeApeNaf_C_ERR;
  }
  
  public void setNouveauCodeApeNaf(String pValeur)
  {
    m_nouveauCodeApeNaf = pValeur;
  }
  
  public void setNouveauCodeApeNaf_C_ERR(String pValeur_C_ERR)
  {
    m_nouveauCodeApeNaf_C_ERR = pValeur_C_ERR;
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
  
  public Damj getDateFincontrat()
  {
    return m_dateFincontrat;
  }
  
  public String getDateFincontrat_C_ERR()
  {
    return m_dateFincontrat_C_ERR;
  }
  
  public void setDateFincontrat(Damj pValeur)
  {
    m_dateFincontrat = pValeur;
  }
  
  public void setDateFincontrat_C_ERR(String pValeur_C_ERR)
  {
    m_dateFincontrat_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDateEmbauche()
  {
    return m_dateEmbauche;
  }
  
  public String getDateEmbauche_C_ERR()
  {
    return m_dateEmbauche_C_ERR;
  }
  
  public void setDateEmbauche(Damj pValeur)
  {
    m_dateEmbauche = pValeur;
  }
  
  public void setDateEmbauche_C_ERR(String pValeur_C_ERR)
  {
    m_dateEmbauche_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDateSignature()
  {
    return m_dateSignature;
  }
  
  public String getDateSignature_C_ERR()
  {
    return m_dateSignature_C_ERR;
  }
  
  public void setDateSignature(Damj pValeur)
  {
    m_dateSignature = pValeur;
  }
  
  public void setDateSignature_C_ERR(String pValeur_C_ERR)
  {
    m_dateSignature_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDateFichierExt()
  {
    return m_dateFichierExt;
  }
  
  public String getDateFichierExt_C_ERR()
  {
    return m_dateFichierExt_C_ERR;
  }
  
  public void setDateFichierExt(Damj pValeur)
  {
    m_dateFichierExt = pValeur;
  }
  
  public void setDateFichierExt_C_ERR(String pValeur_C_ERR)
  {
    m_dateFichierExt_C_ERR = pValeur_C_ERR;
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
  
  public Damj getDateInitialeFinCDD()
  {
    return m_dateInitialeFinCDD;
  }
  
  public String getDateInitialeFinCDD_C_ERR()
  {
    return m_dateInitialeFinCDD_C_ERR;
  }
  
  public void setDateInitialeFinCDD(Damj pValeur)
  {
    m_dateInitialeFinCDD = pValeur;
  }
  
  public void setDateInitialeFinCDD_C_ERR(String pValeur_C_ERR)
  {
    m_dateInitialeFinCDD_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getNbHeures()
  {
    return m_nbHeures;
  }
  
  public String getNbHeures_C_ERR()
  {
    return m_nbHeures_C_ERR;
  }
  
  public void setNbHeures(BigDecimal pValeur)
  {
    m_nbHeures = pValeur;
  }
  
  public void setNbHeures_C_ERR(String pValeur_C_ERR)
  {
    m_nbHeures_C_ERR = pValeur_C_ERR;
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
  
  public BigDecimal getSalaireBrutAvtAbatt()
  {
    return m_salaireBrutAvtAbatt;
  }
  
  public String getSalaireBrutAvtAbatt_C_ERR()
  {
    return m_salaireBrutAvtAbatt_C_ERR;
  }
  
  public void setSalaireBrutAvtAbatt(BigDecimal pValeur)
  {
    m_salaireBrutAvtAbatt = pValeur;
  }
  
  public void setSalaireBrutAvtAbatt_C_ERR(String pValeur_C_ERR)
  {
    m_salaireBrutAvtAbatt_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getSalaireBrutAprAbatt()
  {
    return m_salaireBrutAprAbatt;
  }
  
  public String getSalaireBrutAprAbatt_C_ERR()
  {
    return m_salaireBrutAprAbatt_C_ERR;
  }
  
  public void setSalaireBrutAprAbatt(BigDecimal pValeur)
  {
    m_salaireBrutAprAbatt = pValeur;
  }
  
  public void setSalaireBrutAprAbatt_C_ERR(String pValeur_C_ERR)
  {
    m_salaireBrutAprAbatt_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getTauxAbatt()
  {
    return m_tauxAbatt;
  }
  
  public String getTauxAbatt_C_ERR()
  {
    return m_tauxAbatt_C_ERR;
  }
  
  public void setTauxAbatt(BigDecimal pValeur)
  {
    m_tauxAbatt = pValeur;
  }
  
  public void setTauxAbatt_C_ERR(String pValeur_C_ERR)
  {
    m_tauxAbatt_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getContributionDues()
  {
    return m_contributionDues;
  }
  
  public String getContributionDues_C_ERR()
  {
    return m_contributionDues_C_ERR;
  }
  
  public void setContributionDues(BigDecimal pValeur)
  {
    m_contributionDues = pValeur;
  }
  
  public void setContributionDues_C_ERR(String pValeur_C_ERR)
  {
    m_contributionDues_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getMoisActualisation()
  {
    return m_moisActualisation;
  }
  
  public String getMoisActualisation_C_ERR()
  {
    return m_moisActualisation_C_ERR;
  }
  
  public void setMoisActualisation(BigDecimal pValeur)
  {
    m_moisActualisation = pValeur;
  }
  
  public void setMoisActualisation_C_ERR(String pValeur_C_ERR)
  {
    m_moisActualisation_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getAnneeActualisation()
  {
    return m_anneeActualisation;
  }
  
  public String getAnneeActualisation_C_ERR()
  {
    return m_anneeActualisation_C_ERR;
  }
  
  public void setAnneeActualisation(BigDecimal pValeur)
  {
    m_anneeActualisation = pValeur;
  }
  
  public void setAnneeActualisation_C_ERR(String pValeur_C_ERR)
  {
    m_anneeActualisation_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getNbCachetsIsoles()
  {
    return m_nbCachetsIsoles;
  }
  
  public String getNbCachetsIsoles_C_ERR()
  {
    return m_nbCachetsIsoles_C_ERR;
  }
  
  public void setNbCachetsIsoles(BigDecimal pValeur)
  {
    m_nbCachetsIsoles = pValeur;
  }
  
  public void setNbCachetsIsoles_C_ERR(String pValeur_C_ERR)
  {
    m_nbCachetsIsoles_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getNbCachetsGroupes()
  {
    return m_nbCachetsGroupes;
  }
  
  public String getNbCachetsGroupes_C_ERR()
  {
    return m_nbCachetsGroupes_C_ERR;
  }
  
  public void setNbCachetsGroupes(BigDecimal pValeur)
  {
    m_nbCachetsGroupes = pValeur;
  }
  
  public void setNbCachetsGroupes_C_ERR(String pValeur_C_ERR)
  {
    m_nbCachetsGroupes_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getAutresRemunerationsMontantBrut()
  {
    return m_autresRemunerationsMontantBrut;
  }
  
  public String getAutresRemunerationsMontantBrut_C_ERR()
  {
    return m_autresRemunerationsMontantBrut_C_ERR;
  }
  
  public void setAutresRemunerationsMontantBrut(BigDecimal pValeur)
  {
    m_autresRemunerationsMontantBrut = pValeur;
  }
  
  public void setAutresRemunerationsMontantBrut_C_ERR(String pValeur_C_ERR)
  {
    m_autresRemunerationsMontantBrut_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getAutresRemunerationsTauxContributions()
  {
    return m_autresRemunerationsTauxContributions;
  }
  
  public String getAutresRemunerationsTauxContributions_C_ERR()
  {
    return m_autresRemunerationsTauxContributions_C_ERR;
  }
  
  public void setAutresRemunerationsTauxContributions(BigDecimal pValeur)
  {
    m_autresRemunerationsTauxContributions = pValeur;
  }
  
  public void setAutresRemunerationsTauxContributions_C_ERR(String pValeur_C_ERR)
  {
    m_autresRemunerationsTauxContributions_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getAutresRemunerationsContributionsDues()
  {
    return m_autresRemunerationsContributionsDues;
  }
  
  public String getAutresRemunerationsContributionsDues_C_ERR()
  {
    return m_autresRemunerationsContributionsDues_C_ERR;
  }
  
  public void setAutresRemunerationsContributionsDues(BigDecimal pValeur)
  {
    m_autresRemunerationsContributionsDues = pValeur;
  }
  
  public void setAutresRemunerationsContributionsDues_C_ERR(String pValeur_C_ERR)
  {
    m_autresRemunerationsContributionsDues_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getTotalContributionsDues()
  {
    return m_totalContributionsDues;
  }
  
  public String getTotalContributionsDues_C_ERR()
  {
    return m_totalContributionsDues_C_ERR;
  }
  
  public void setTotalContributionsDues(BigDecimal pValeur)
  {
    m_totalContributionsDues = pValeur;
  }
  
  public void setTotalContributionsDues_C_ERR(String pValeur_C_ERR)
  {
    m_totalContributionsDues_C_ERR = pValeur_C_ERR;
  }
  
  public String getBneCertifSociale()
  {
    return m_bneCertifSociale;
  }
  
  public String getBneCertifSociale_C_ERR()
  {
    return m_bneCertifSociale_C_ERR;
  }
  
  public void setBneCertifSociale(String pValeur)
  {
    m_bneCertifSociale = pValeur;
  }
  
  public void setBneCertifSociale_C_ERR(String pValeur_C_ERR)
  {
    m_bneCertifSociale_C_ERR = pValeur_C_ERR;
  }
  
  public String getIdccEmployeur()
  {
    return m_idccEmployeur;
  }
  
  public String getIdccEmployeur_C_ERR()
  {
    return m_idccEmployeur_C_ERR;
  }
  
  public void setIdccEmployeur(String pValeur)
  {
    m_idccEmployeur = pValeur;
  }
  
  public void setIdccEmployeur_C_ERR(String pValeur_C_ERR)
  {
    m_idccEmployeur_C_ERR = pValeur_C_ERR;
  }
  
  public String getIdccPrestation()
  {
    return m_idccPrestation;
  }
  
  public String getIdccPrestation_C_ERR()
  {
    return m_idccPrestation_C_ERR;
  }
  
  public void setIdccPrestation(String pValeur)
  {
    m_idccPrestation = pValeur;
  }
  
  public void setIdccPrestation_C_ERR(String pValeur_C_ERR)
  {
    m_idccPrestation_C_ERR = pValeur_C_ERR;
  }
  
  public String getRessortissant()
  {
    return m_ressortissant;
  }
  
  public String getRessortissant_C_ERR()
  {
    return m_ressortissant_C_ERR;
  }
  
  public void setRessortissant(String pValeur)
  {
    m_ressortissant = pValeur;
  }
  
  public void setRessortissant_C_ERR(String pValeur_C_ERR)
  {
    m_ressortissant_C_ERR = pValeur_C_ERR;
  }
  
  public String getIndicateurCertifSociale()
  {
    return m_indicateurCertifSociale;
  }
  
  public String getIndicateurCertifSociale_C_ERR()
  {
    return m_indicateurCertifSociale_C_ERR;
  }
  
  public void setIndicateurCertifSociale(String pValeur)
  {
    m_indicateurCertifSociale = pValeur;
  }
  
  public void setIndicateurCertifSociale_C_ERR(String pValeur_C_ERR)
  {
    m_indicateurCertifSociale_C_ERR = pValeur_C_ERR;
  }
  
  public String getNumCertifSociale()
  {
    return m_numCertifSociale;
  }
  
  public String getNumCertifSociale_C_ERR()
  {
    return m_numCertifSociale_C_ERR;
  }
  
  public void setNumCertifSociale(String pValeur)
  {
    m_numCertifSociale = pValeur;
  }
  
  public void setNumCertifSociale_C_ERR(String pValeur_C_ERR)
  {
    m_numCertifSociale_C_ERR = pValeur_C_ERR;
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
    if ("m_bneSiret_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_bNEEmployeur_C_ERR".equals(attrName)) {
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
    if ("m_codeAction_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_indicateurType_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_numeroInitial_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_numero_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_siretEmployeur_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_codeNafApe_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_numAssedicAffiliation_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_numeroAffiliation_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_raisonSociale_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_adresseEmployeur_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_complAdresseEmployeur_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_telephoneEmployeur_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_faxEmployeur_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_courrielEmployeur_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_codePostalEmployeur_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_communeEmployeur_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_formeJuridique_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_activiteEmployeur_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_licenceSpectacle_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_numeroLicenceSpe_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_organisateurOccasionnelspe_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_titulaireLabelPresta_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_numeroLabelPrestaSer_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_numAffiCaisseConges_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_nomSalarie_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_prenomSalarie_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_nomUsuel_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_telephoneSalarie_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_NIR_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_adresseSalarie_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_complementAdresseSalarie_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_codePostalSalarie_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_communeSalarie_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_lienParente_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_typeLienParente_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_codeEmploiOccupe_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_codeQualification_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_regimeRetraiteCompl_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_statutCadre_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_contratEnCours_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_motiFinContrat_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_nomEmployeur_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_prenomEmployeur_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_qualite_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_motifRupture_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_communeSignature_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_contactAEM_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_telephoneTiers_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_codeOrganisme_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_nbJoursTravailles_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_numVersionAEM_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_affiCaisseConges_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_numeroObjet_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_indicateurHorsChamp_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_nouveauCodeApeNaf_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateNaissance_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateFincontrat_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateEmbauche_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateSignature_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateFichierExt_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateCreation_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateInitialeFinCDD_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_nbHeures_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_nbCachets_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_salaireBrutAvtAbatt_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_salaireBrutAprAbatt_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_tauxAbatt_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_contributionDues_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_moisActualisation_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_anneeActualisation_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_nbCachetsIsoles_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_nbCachetsGroupes_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_autresRemunerationsMontantBrut_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_autresRemunerationsTauxContributions_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_autresRemunerationsContributionsDues_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_totalContributionsDues_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_bneCertifSociale_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_idccEmployeur_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_idccPrestation_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_ressortissant_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_indicateurCertifSociale_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_numCertifSociale_C_ERR".equals(attrName)) {
      return String.class;
    }
    return null;
  }
  
  public PropertyInfo _getPropertyInfo(String pElementName)
    throws TechniqueException
  {
    if ("BneSiret".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("BNEEmployeur".equals(pElementName))
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
    if ("CodeAction".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("IndicateurType".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("NumeroInitial".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("Numero".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("SiretEmployeur".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("CodeNafApe".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("NumAssedicAffiliation".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("NumeroAffiliation".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("RaisonSociale".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("AdresseEmployeur".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("ComplAdresseEmployeur".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("TelephoneEmployeur".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("FaxEmployeur".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("CourrielEmployeur".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("CodePostalEmployeur".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("CommuneEmployeur".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("FormeJuridique".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("ActiviteEmployeur".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("LicenceSpectacle".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("NumeroLicenceSpe".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("OrganisateurOccasionnelspe".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("TitulaireLabelPresta".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("NumeroLabelPrestaSer".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("NumAffiCaisseConges".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("NomSalarie".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("PrenomSalarie".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("NomUsuel".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("TelephoneSalarie".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("NIR".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("AdresseSalarie".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("ComplementAdresseSalarie".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("CodePostalSalarie".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("CommuneSalarie".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("LienParente".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("TypeLienParente".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("CodeEmploiOccupe".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("CodeQualification".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("RegimeRetraiteCompl".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("StatutCadre".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("ContratEnCours".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("MotiFinContrat".equals(pElementName))
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
    if ("Qualite".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("MotifRupture".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("CommuneSignature".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("ContactAEM".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("TelephoneTiers".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("CodeOrganisme".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("NbJoursTravailles".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("NumVersionAEM".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("AffiCaisseConges".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("NumeroObjet".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("IndicateurHorsChamp".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("NouveauCodeApeNaf".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("DateNaissance".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("DateFincontrat".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("DateEmbauche".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("DateSignature".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("DateFichierExt".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("DateCreation".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("DateInitialeFinCDD".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("NbHeures".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("NbCachets".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("SalaireBrutAvtAbatt".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("SalaireBrutAprAbatt".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("TauxAbatt".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("ContributionDues".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("MoisActualisation".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("AnneeActualisation".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("NbCachetsIsoles".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("NbCachetsGroupes".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("AutresRemunerationsMontantBrut".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("AutresRemunerationsTauxContributions".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("AutresRemunerationsContributionsDues".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("TotalContributionsDues".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("BneCertifSociale".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("IdccEmployeur".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("IdccPrestation".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("Ressortissant".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("IndicateurCertifSociale".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("NumCertifSociale".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    return null;
  }
  
  public int _getPropertyLength(String pElementName)
  {
    if ("BneSiret".equals(pElementName)) {
      return 14;
    }
    if ("BNEEmployeur".equals(pElementName)) {
      return 10;
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
    if ("CodeAction".equals(pElementName)) {
      return 1;
    }
    if ("IndicateurType".equals(pElementName)) {
      return 1;
    }
    if ("NumeroInitial".equals(pElementName)) {
      return 10;
    }
    if ("Numero".equals(pElementName)) {
      return 10;
    }
    if ("SiretEmployeur".equals(pElementName)) {
      return 14;
    }
    if ("CodeNafApe".equals(pElementName)) {
      return 4;
    }
    if ("NumAssedicAffiliation".equals(pElementName)) {
      return 2;
    }
    if ("NumeroAffiliation".equals(pElementName)) {
      return 15;
    }
    if ("RaisonSociale".equals(pElementName)) {
      return 27;
    }
    if ("AdresseEmployeur".equals(pElementName)) {
      return 32;
    }
    if ("ComplAdresseEmployeur".equals(pElementName)) {
      return 32;
    }
    if ("TelephoneEmployeur".equals(pElementName)) {
      return 11;
    }
    if ("FaxEmployeur".equals(pElementName)) {
      return 10;
    }
    if ("CourrielEmployeur".equals(pElementName)) {
      return 60;
    }
    if ("CodePostalEmployeur".equals(pElementName)) {
      return 5;
    }
    if ("CommuneEmployeur".equals(pElementName)) {
      return 32;
    }
    if ("FormeJuridique".equals(pElementName)) {
      return 5;
    }
    if ("ActiviteEmployeur".equals(pElementName)) {
      return 18;
    }
    if ("LicenceSpectacle".equals(pElementName)) {
      return 1;
    }
    if ("NumeroLicenceSpe".equals(pElementName)) {
      return 10;
    }
    if ("OrganisateurOccasionnelspe".equals(pElementName)) {
      return 1;
    }
    if ("TitulaireLabelPresta".equals(pElementName)) {
      return 1;
    }
    if ("NumeroLabelPrestaSer".equals(pElementName)) {
      return 3;
    }
    if ("NumAffiCaisseConges".equals(pElementName)) {
      return 10;
    }
    if ("NomSalarie".equals(pElementName)) {
      return 25;
    }
    if ("PrenomSalarie".equals(pElementName)) {
      return 25;
    }
    if ("NomUsuel".equals(pElementName)) {
      return 25;
    }
    if ("TelephoneSalarie".equals(pElementName)) {
      return 11;
    }
    if ("NIR".equals(pElementName)) {
      return 15;
    }
    if ("AdresseSalarie".equals(pElementName)) {
      return 32;
    }
    if ("ComplementAdresseSalarie".equals(pElementName)) {
      return 32;
    }
    if ("CodePostalSalarie".equals(pElementName)) {
      return 5;
    }
    if ("CommuneSalarie".equals(pElementName)) {
      return 32;
    }
    if ("LienParente".equals(pElementName)) {
      return 1;
    }
    if ("TypeLienParente".equals(pElementName)) {
      return 1;
    }
    if ("CodeEmploiOccupe".equals(pElementName)) {
      return 6;
    }
    if ("CodeQualification".equals(pElementName)) {
      return 1;
    }
    if ("RegimeRetraiteCompl".equals(pElementName)) {
      return 20;
    }
    if ("StatutCadre".equals(pElementName)) {
      return 1;
    }
    if ("ContratEnCours".equals(pElementName)) {
      return 1;
    }
    if ("MotiFinContrat".equals(pElementName)) {
      return 3;
    }
    if ("NomEmployeur".equals(pElementName)) {
      return 25;
    }
    if ("PrenomEmployeur".equals(pElementName)) {
      return 25;
    }
    if ("Qualite".equals(pElementName)) {
      return 1;
    }
    if ("MotifRupture".equals(pElementName)) {
      return 25;
    }
    if ("CommuneSignature".equals(pElementName)) {
      return 32;
    }
    if ("ContactAEM".equals(pElementName)) {
      return 25;
    }
    if ("TelephoneTiers".equals(pElementName)) {
      return 11;
    }
    if ("CodeOrganisme".equals(pElementName)) {
      return 2;
    }
    if ("NbJoursTravailles".equals(pElementName)) {
      return 2;
    }
    if ("NumVersionAEM".equals(pElementName)) {
      return 2;
    }
    if ("AffiCaisseConges".equals(pElementName)) {
      return 1;
    }
    if ("NumeroObjet".equals(pElementName)) {
      return 12;
    }
    if ("IndicateurHorsChamp".equals(pElementName)) {
      return 1;
    }
    if ("NouveauCodeApeNaf".equals(pElementName)) {
      return 5;
    }
    if ("DateNaissance".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("DateFincontrat".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("DateEmbauche".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("DateSignature".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("DateFichierExt".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("DateCreation".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("DateInitialeFinCDD".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("NbHeures".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("NbCachets".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("SalaireBrutAvtAbatt".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("SalaireBrutAprAbatt".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("TauxAbatt".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("ContributionDues".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("MoisActualisation".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("AnneeActualisation".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("NbCachetsIsoles".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("NbCachetsGroupes".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("AutresRemunerationsMontantBrut".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("AutresRemunerationsTauxContributions".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("AutresRemunerationsContributionsDues".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("TotalContributionsDues".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("BneCertifSociale".equals(pElementName)) {
      return 1;
    }
    if ("IdccEmployeur".equals(pElementName)) {
      return 4;
    }
    if ("IdccPrestation".equals(pElementName)) {
      return 4;
    }
    if ("Ressortissant".equals(pElementName)) {
      return 2;
    }
    if ("IndicateurCertifSociale".equals(pElementName)) {
      return 1;
    }
    if ("NumCertifSociale".equals(pElementName)) {
      return 10;
    }
    return -1;
  }
  
  public Object _getProperty(String pName)
    throws Exception
  {
    if ("BneSiret".equals(pName)) {
      return m_bneSiret;
    }
    if ("BNEEmployeur".equals(pName)) {
      return m_bNEEmployeur;
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
    if ("CodeAction".equals(pName)) {
      return m_codeAction;
    }
    if ("IndicateurType".equals(pName)) {
      return m_indicateurType;
    }
    if ("NumeroInitial".equals(pName)) {
      return m_numeroInitial;
    }
    if ("Numero".equals(pName)) {
      return m_numero;
    }
    if ("SiretEmployeur".equals(pName)) {
      return m_siretEmployeur;
    }
    if ("CodeNafApe".equals(pName)) {
      return m_codeNafApe;
    }
    if ("NumAssedicAffiliation".equals(pName)) {
      return m_numAssedicAffiliation;
    }
    if ("NumeroAffiliation".equals(pName)) {
      return m_numeroAffiliation;
    }
    if ("RaisonSociale".equals(pName)) {
      return m_raisonSociale;
    }
    if ("AdresseEmployeur".equals(pName)) {
      return m_adresseEmployeur;
    }
    if ("ComplAdresseEmployeur".equals(pName)) {
      return m_complAdresseEmployeur;
    }
    if ("TelephoneEmployeur".equals(pName)) {
      return m_telephoneEmployeur;
    }
    if ("FaxEmployeur".equals(pName)) {
      return m_faxEmployeur;
    }
    if ("CourrielEmployeur".equals(pName)) {
      return m_courrielEmployeur;
    }
    if ("CodePostalEmployeur".equals(pName)) {
      return m_codePostalEmployeur;
    }
    if ("CommuneEmployeur".equals(pName)) {
      return m_communeEmployeur;
    }
    if ("FormeJuridique".equals(pName)) {
      return m_formeJuridique;
    }
    if ("ActiviteEmployeur".equals(pName)) {
      return m_activiteEmployeur;
    }
    if ("LicenceSpectacle".equals(pName)) {
      return m_licenceSpectacle;
    }
    if ("NumeroLicenceSpe".equals(pName)) {
      return m_numeroLicenceSpe;
    }
    if ("OrganisateurOccasionnelspe".equals(pName)) {
      return m_organisateurOccasionnelspe;
    }
    if ("TitulaireLabelPresta".equals(pName)) {
      return m_titulaireLabelPresta;
    }
    if ("NumeroLabelPrestaSer".equals(pName)) {
      return m_numeroLabelPrestaSer;
    }
    if ("NumAffiCaisseConges".equals(pName)) {
      return m_numAffiCaisseConges;
    }
    if ("NomSalarie".equals(pName)) {
      return m_nomSalarie;
    }
    if ("PrenomSalarie".equals(pName)) {
      return m_prenomSalarie;
    }
    if ("NomUsuel".equals(pName)) {
      return m_nomUsuel;
    }
    if ("TelephoneSalarie".equals(pName)) {
      return m_telephoneSalarie;
    }
    if ("NIR".equals(pName)) {
      return m_NIR;
    }
    if ("AdresseSalarie".equals(pName)) {
      return m_adresseSalarie;
    }
    if ("ComplementAdresseSalarie".equals(pName)) {
      return m_complementAdresseSalarie;
    }
    if ("CodePostalSalarie".equals(pName)) {
      return m_codePostalSalarie;
    }
    if ("CommuneSalarie".equals(pName)) {
      return m_communeSalarie;
    }
    if ("LienParente".equals(pName)) {
      return m_lienParente;
    }
    if ("TypeLienParente".equals(pName)) {
      return m_typeLienParente;
    }
    if ("CodeEmploiOccupe".equals(pName)) {
      return m_codeEmploiOccupe;
    }
    if ("CodeQualification".equals(pName)) {
      return m_codeQualification;
    }
    if ("RegimeRetraiteCompl".equals(pName)) {
      return m_regimeRetraiteCompl;
    }
    if ("StatutCadre".equals(pName)) {
      return m_statutCadre;
    }
    if ("ContratEnCours".equals(pName)) {
      return m_contratEnCours;
    }
    if ("MotiFinContrat".equals(pName)) {
      return m_motiFinContrat;
    }
    if ("NomEmployeur".equals(pName)) {
      return m_nomEmployeur;
    }
    if ("PrenomEmployeur".equals(pName)) {
      return m_prenomEmployeur;
    }
    if ("Qualite".equals(pName)) {
      return m_qualite;
    }
    if ("MotifRupture".equals(pName)) {
      return m_motifRupture;
    }
    if ("CommuneSignature".equals(pName)) {
      return m_communeSignature;
    }
    if ("ContactAEM".equals(pName)) {
      return m_contactAEM;
    }
    if ("TelephoneTiers".equals(pName)) {
      return m_telephoneTiers;
    }
    if ("CodeOrganisme".equals(pName)) {
      return m_codeOrganisme;
    }
    if ("NbJoursTravailles".equals(pName)) {
      return m_nbJoursTravailles;
    }
    if ("NumVersionAEM".equals(pName)) {
      return m_numVersionAEM;
    }
    if ("AffiCaisseConges".equals(pName)) {
      return m_affiCaisseConges;
    }
    if ("NumeroObjet".equals(pName)) {
      return m_numeroObjet;
    }
    if ("IndicateurHorsChamp".equals(pName)) {
      return m_indicateurHorsChamp;
    }
    if ("NouveauCodeApeNaf".equals(pName)) {
      return m_nouveauCodeApeNaf;
    }
    if ("DateNaissance".equals(pName)) {
      return m_dateNaissance;
    }
    if ("DateFincontrat".equals(pName)) {
      return m_dateFincontrat;
    }
    if ("DateEmbauche".equals(pName)) {
      return m_dateEmbauche;
    }
    if ("DateSignature".equals(pName)) {
      return m_dateSignature;
    }
    if ("DateFichierExt".equals(pName)) {
      return m_dateFichierExt;
    }
    if ("DateCreation".equals(pName)) {
      return m_dateCreation;
    }
    if ("DateInitialeFinCDD".equals(pName)) {
      return m_dateInitialeFinCDD;
    }
    if ("NbHeures".equals(pName)) {
      return m_nbHeures;
    }
    if ("NbCachets".equals(pName)) {
      return m_nbCachets;
    }
    if ("SalaireBrutAvtAbatt".equals(pName)) {
      return m_salaireBrutAvtAbatt;
    }
    if ("SalaireBrutAprAbatt".equals(pName)) {
      return m_salaireBrutAprAbatt;
    }
    if ("TauxAbatt".equals(pName)) {
      return m_tauxAbatt;
    }
    if ("ContributionDues".equals(pName)) {
      return m_contributionDues;
    }
    if ("MoisActualisation".equals(pName)) {
      return m_moisActualisation;
    }
    if ("AnneeActualisation".equals(pName)) {
      return m_anneeActualisation;
    }
    if ("NbCachetsIsoles".equals(pName)) {
      return m_nbCachetsIsoles;
    }
    if ("NbCachetsGroupes".equals(pName)) {
      return m_nbCachetsGroupes;
    }
    if ("AutresRemunerationsMontantBrut".equals(pName)) {
      return m_autresRemunerationsMontantBrut;
    }
    if ("AutresRemunerationsTauxContributions".equals(pName)) {
      return m_autresRemunerationsTauxContributions;
    }
    if ("AutresRemunerationsContributionsDues".equals(pName)) {
      return m_autresRemunerationsContributionsDues;
    }
    if ("TotalContributionsDues".equals(pName)) {
      return m_totalContributionsDues;
    }
    if ("BneCertifSociale".equals(pName)) {
      return m_bneCertifSociale;
    }
    if ("IdccEmployeur".equals(pName)) {
      return m_idccEmployeur;
    }
    if ("IdccPrestation".equals(pName)) {
      return m_idccPrestation;
    }
    if ("Ressortissant".equals(pName)) {
      return m_ressortissant;
    }
    if ("IndicateurCertifSociale".equals(pName)) {
      return m_indicateurCertifSociale;
    }
    if ("NumCertifSociale".equals(pName)) {
      return m_numCertifSociale;
    }
    return null;
  }
  
  public Iterator _getPropertyNames()
    throws Exception
  {
    ArrayList liste = new ArrayList();
    liste.add("BneSiret");
    liste.add("BNEEmployeur");
    liste.add("BneRaisonSociale");
    liste.add("BneNumeroVoirie");
    liste.add("BneLibelleVoieAdresse");
    liste.add("BneComplAdresse");
    liste.add("BneCodePostal");
    liste.add("BneLibelleCommune");
    liste.add("BneAssedicAffiliation");
    liste.add("BneNumAffiliation");
    liste.add("CodeAction");
    liste.add("IndicateurType");
    liste.add("NumeroInitial");
    liste.add("Numero");
    liste.add("SiretEmployeur");
    liste.add("CodeNafApe");
    liste.add("NumAssedicAffiliation");
    liste.add("NumeroAffiliation");
    liste.add("RaisonSociale");
    liste.add("AdresseEmployeur");
    liste.add("ComplAdresseEmployeur");
    liste.add("TelephoneEmployeur");
    liste.add("FaxEmployeur");
    liste.add("CourrielEmployeur");
    liste.add("CodePostalEmployeur");
    liste.add("CommuneEmployeur");
    liste.add("FormeJuridique");
    liste.add("ActiviteEmployeur");
    liste.add("LicenceSpectacle");
    liste.add("NumeroLicenceSpe");
    liste.add("OrganisateurOccasionnelspe");
    liste.add("TitulaireLabelPresta");
    liste.add("NumeroLabelPrestaSer");
    liste.add("NumAffiCaisseConges");
    liste.add("NomSalarie");
    liste.add("PrenomSalarie");
    liste.add("NomUsuel");
    liste.add("TelephoneSalarie");
    liste.add("NIR");
    liste.add("AdresseSalarie");
    liste.add("ComplementAdresseSalarie");
    liste.add("CodePostalSalarie");
    liste.add("CommuneSalarie");
    liste.add("LienParente");
    liste.add("TypeLienParente");
    liste.add("CodeEmploiOccupe");
    liste.add("CodeQualification");
    liste.add("RegimeRetraiteCompl");
    liste.add("StatutCadre");
    liste.add("ContratEnCours");
    liste.add("MotiFinContrat");
    liste.add("NomEmployeur");
    liste.add("PrenomEmployeur");
    liste.add("Qualite");
    liste.add("MotifRupture");
    liste.add("CommuneSignature");
    liste.add("ContactAEM");
    liste.add("TelephoneTiers");
    liste.add("CodeOrganisme");
    liste.add("NbJoursTravailles");
    liste.add("NumVersionAEM");
    liste.add("AffiCaisseConges");
    liste.add("NumeroObjet");
    liste.add("IndicateurHorsChamp");
    liste.add("NouveauCodeApeNaf");
    liste.add("DateNaissance");
    liste.add("DateFincontrat");
    liste.add("DateEmbauche");
    liste.add("DateSignature");
    liste.add("DateFichierExt");
    liste.add("DateCreation");
    liste.add("DateInitialeFinCDD");
    liste.add("NbHeures");
    liste.add("NbCachets");
    liste.add("SalaireBrutAvtAbatt");
    liste.add("SalaireBrutAprAbatt");
    liste.add("TauxAbatt");
    liste.add("ContributionDues");
    liste.add("MoisActualisation");
    liste.add("AnneeActualisation");
    liste.add("NbCachetsIsoles");
    liste.add("NbCachetsGroupes");
    liste.add("AutresRemunerationsMontantBrut");
    liste.add("AutresRemunerationsTauxContributions");
    liste.add("AutresRemunerationsContributionsDues");
    liste.add("TotalContributionsDues");
    liste.add("BneCertifSociale");
    liste.add("IdccEmployeur");
    liste.add("IdccPrestation");
    liste.add("Ressortissant");
    liste.add("IndicateurCertifSociale");
    liste.add("NumCertifSociale");
    return liste.iterator();
  }
  
  public ArrayList _getPropertyNames(ArrayList pListe)
    throws Exception
  {
    pListe.add("BneSiret");
    pListe.add("BNEEmployeur");
    pListe.add("BneRaisonSociale");
    pListe.add("BneNumeroVoirie");
    pListe.add("BneLibelleVoieAdresse");
    pListe.add("BneComplAdresse");
    pListe.add("BneCodePostal");
    pListe.add("BneLibelleCommune");
    pListe.add("BneAssedicAffiliation");
    pListe.add("BneNumAffiliation");
    pListe.add("CodeAction");
    pListe.add("IndicateurType");
    pListe.add("NumeroInitial");
    pListe.add("Numero");
    pListe.add("SiretEmployeur");
    pListe.add("CodeNafApe");
    pListe.add("NumAssedicAffiliation");
    pListe.add("NumeroAffiliation");
    pListe.add("RaisonSociale");
    pListe.add("AdresseEmployeur");
    pListe.add("ComplAdresseEmployeur");
    pListe.add("TelephoneEmployeur");
    pListe.add("FaxEmployeur");
    pListe.add("CourrielEmployeur");
    pListe.add("CodePostalEmployeur");
    pListe.add("CommuneEmployeur");
    pListe.add("FormeJuridique");
    pListe.add("ActiviteEmployeur");
    pListe.add("LicenceSpectacle");
    pListe.add("NumeroLicenceSpe");
    pListe.add("OrganisateurOccasionnelspe");
    pListe.add("TitulaireLabelPresta");
    pListe.add("NumeroLabelPrestaSer");
    pListe.add("NumAffiCaisseConges");
    pListe.add("NomSalarie");
    pListe.add("PrenomSalarie");
    pListe.add("NomUsuel");
    pListe.add("TelephoneSalarie");
    pListe.add("NIR");
    pListe.add("AdresseSalarie");
    pListe.add("ComplementAdresseSalarie");
    pListe.add("CodePostalSalarie");
    pListe.add("CommuneSalarie");
    pListe.add("LienParente");
    pListe.add("TypeLienParente");
    pListe.add("CodeEmploiOccupe");
    pListe.add("CodeQualification");
    pListe.add("RegimeRetraiteCompl");
    pListe.add("StatutCadre");
    pListe.add("ContratEnCours");
    pListe.add("MotiFinContrat");
    pListe.add("NomEmployeur");
    pListe.add("PrenomEmployeur");
    pListe.add("Qualite");
    pListe.add("MotifRupture");
    pListe.add("CommuneSignature");
    pListe.add("ContactAEM");
    pListe.add("TelephoneTiers");
    pListe.add("CodeOrganisme");
    pListe.add("NbJoursTravailles");
    pListe.add("NumVersionAEM");
    pListe.add("AffiCaisseConges");
    pListe.add("NumeroObjet");
    pListe.add("IndicateurHorsChamp");
    pListe.add("NouveauCodeApeNaf");
    pListe.add("DateNaissance");
    pListe.add("DateFincontrat");
    pListe.add("DateEmbauche");
    pListe.add("DateSignature");
    pListe.add("DateFichierExt");
    pListe.add("DateCreation");
    pListe.add("DateInitialeFinCDD");
    pListe.add("NbHeures");
    pListe.add("NbCachets");
    pListe.add("SalaireBrutAvtAbatt");
    pListe.add("SalaireBrutAprAbatt");
    pListe.add("TauxAbatt");
    pListe.add("ContributionDues");
    pListe.add("MoisActualisation");
    pListe.add("AnneeActualisation");
    pListe.add("NbCachetsIsoles");
    pListe.add("NbCachetsGroupes");
    pListe.add("AutresRemunerationsMontantBrut");
    pListe.add("AutresRemunerationsTauxContributions");
    pListe.add("AutresRemunerationsContributionsDues");
    pListe.add("TotalContributionsDues");
    pListe.add("BneCertifSociale");
    pListe.add("IdccEmployeur");
    pListe.add("IdccPrestation");
    pListe.add("Ressortissant");
    pListe.add("IndicateurCertifSociale");
    pListe.add("NumCertifSociale");
    return pListe;
  }
  
  public void _setProperty(String pName, Object pValeur)
    throws Exception
  {
    if ("BneSiret".equals(pName)) {
      m_bneSiret = ((String)pValeur);
    }
    if ("BNEEmployeur".equals(pName)) {
      m_bNEEmployeur = ((String)pValeur);
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
    if ("CodeAction".equals(pName)) {
      m_codeAction = ((String)pValeur);
    }
    if ("IndicateurType".equals(pName)) {
      m_indicateurType = ((String)pValeur);
    }
    if ("NumeroInitial".equals(pName)) {
      m_numeroInitial = ((String)pValeur);
    }
    if ("Numero".equals(pName)) {
      m_numero = ((String)pValeur);
    }
    if ("SiretEmployeur".equals(pName)) {
      m_siretEmployeur = ((String)pValeur);
    }
    if ("CodeNafApe".equals(pName)) {
      m_codeNafApe = ((String)pValeur);
    }
    if ("NumAssedicAffiliation".equals(pName)) {
      m_numAssedicAffiliation = ((String)pValeur);
    }
    if ("NumeroAffiliation".equals(pName)) {
      m_numeroAffiliation = ((String)pValeur);
    }
    if ("RaisonSociale".equals(pName)) {
      m_raisonSociale = ((String)pValeur);
    }
    if ("AdresseEmployeur".equals(pName)) {
      m_adresseEmployeur = ((String)pValeur);
    }
    if ("ComplAdresseEmployeur".equals(pName)) {
      m_complAdresseEmployeur = ((String)pValeur);
    }
    if ("TelephoneEmployeur".equals(pName)) {
      m_telephoneEmployeur = ((String)pValeur);
    }
    if ("FaxEmployeur".equals(pName)) {
      m_faxEmployeur = ((String)pValeur);
    }
    if ("CourrielEmployeur".equals(pName)) {
      m_courrielEmployeur = ((String)pValeur);
    }
    if ("CodePostalEmployeur".equals(pName)) {
      m_codePostalEmployeur = ((String)pValeur);
    }
    if ("CommuneEmployeur".equals(pName)) {
      m_communeEmployeur = ((String)pValeur);
    }
    if ("FormeJuridique".equals(pName)) {
      m_formeJuridique = ((String)pValeur);
    }
    if ("ActiviteEmployeur".equals(pName)) {
      m_activiteEmployeur = ((String)pValeur);
    }
    if ("LicenceSpectacle".equals(pName)) {
      m_licenceSpectacle = ((String)pValeur);
    }
    if ("NumeroLicenceSpe".equals(pName)) {
      m_numeroLicenceSpe = ((String)pValeur);
    }
    if ("OrganisateurOccasionnelspe".equals(pName)) {
      m_organisateurOccasionnelspe = ((String)pValeur);
    }
    if ("TitulaireLabelPresta".equals(pName)) {
      m_titulaireLabelPresta = ((String)pValeur);
    }
    if ("NumeroLabelPrestaSer".equals(pName)) {
      m_numeroLabelPrestaSer = ((String)pValeur);
    }
    if ("NumAffiCaisseConges".equals(pName)) {
      m_numAffiCaisseConges = ((String)pValeur);
    }
    if ("NomSalarie".equals(pName)) {
      m_nomSalarie = ((String)pValeur);
    }
    if ("PrenomSalarie".equals(pName)) {
      m_prenomSalarie = ((String)pValeur);
    }
    if ("NomUsuel".equals(pName)) {
      m_nomUsuel = ((String)pValeur);
    }
    if ("TelephoneSalarie".equals(pName)) {
      m_telephoneSalarie = ((String)pValeur);
    }
    if ("NIR".equals(pName)) {
      m_NIR = ((String)pValeur);
    }
    if ("AdresseSalarie".equals(pName)) {
      m_adresseSalarie = ((String)pValeur);
    }
    if ("ComplementAdresseSalarie".equals(pName)) {
      m_complementAdresseSalarie = ((String)pValeur);
    }
    if ("CodePostalSalarie".equals(pName)) {
      m_codePostalSalarie = ((String)pValeur);
    }
    if ("CommuneSalarie".equals(pName)) {
      m_communeSalarie = ((String)pValeur);
    }
    if ("LienParente".equals(pName)) {
      m_lienParente = ((String)pValeur);
    }
    if ("TypeLienParente".equals(pName)) {
      m_typeLienParente = ((String)pValeur);
    }
    if ("CodeEmploiOccupe".equals(pName)) {
      m_codeEmploiOccupe = ((String)pValeur);
    }
    if ("CodeQualification".equals(pName)) {
      m_codeQualification = ((String)pValeur);
    }
    if ("RegimeRetraiteCompl".equals(pName)) {
      m_regimeRetraiteCompl = ((String)pValeur);
    }
    if ("StatutCadre".equals(pName)) {
      m_statutCadre = ((String)pValeur);
    }
    if ("ContratEnCours".equals(pName)) {
      m_contratEnCours = ((String)pValeur);
    }
    if ("MotiFinContrat".equals(pName)) {
      m_motiFinContrat = ((String)pValeur);
    }
    if ("NomEmployeur".equals(pName)) {
      m_nomEmployeur = ((String)pValeur);
    }
    if ("PrenomEmployeur".equals(pName)) {
      m_prenomEmployeur = ((String)pValeur);
    }
    if ("Qualite".equals(pName)) {
      m_qualite = ((String)pValeur);
    }
    if ("MotifRupture".equals(pName)) {
      m_motifRupture = ((String)pValeur);
    }
    if ("CommuneSignature".equals(pName)) {
      m_communeSignature = ((String)pValeur);
    }
    if ("ContactAEM".equals(pName)) {
      m_contactAEM = ((String)pValeur);
    }
    if ("TelephoneTiers".equals(pName)) {
      m_telephoneTiers = ((String)pValeur);
    }
    if ("CodeOrganisme".equals(pName)) {
      m_codeOrganisme = ((String)pValeur);
    }
    if ("NbJoursTravailles".equals(pName)) {
      m_nbJoursTravailles = ((String)pValeur);
    }
    if ("NumVersionAEM".equals(pName)) {
      m_numVersionAEM = ((String)pValeur);
    }
    if ("AffiCaisseConges".equals(pName)) {
      m_affiCaisseConges = ((String)pValeur);
    }
    if ("NumeroObjet".equals(pName)) {
      m_numeroObjet = ((String)pValeur);
    }
    if ("IndicateurHorsChamp".equals(pName)) {
      m_indicateurHorsChamp = ((String)pValeur);
    }
    if ("NouveauCodeApeNaf".equals(pName)) {
      m_nouveauCodeApeNaf = ((String)pValeur);
    }
    if ("DateNaissance".equals(pName)) {
      m_dateNaissance = ((Damj)pValeur);
    }
    if ("DateFincontrat".equals(pName)) {
      m_dateFincontrat = ((Damj)pValeur);
    }
    if ("DateEmbauche".equals(pName)) {
      m_dateEmbauche = ((Damj)pValeur);
    }
    if ("DateSignature".equals(pName)) {
      m_dateSignature = ((Damj)pValeur);
    }
    if ("DateFichierExt".equals(pName)) {
      m_dateFichierExt = ((Damj)pValeur);
    }
    if ("DateCreation".equals(pName)) {
      m_dateCreation = ((Damj)pValeur);
    }
    if ("DateInitialeFinCDD".equals(pName)) {
      m_dateInitialeFinCDD = ((Damj)pValeur);
    }
    if ("NbHeures".equals(pName)) {
      m_nbHeures = ((BigDecimal)pValeur);
    }
    if ("NbCachets".equals(pName)) {
      m_nbCachets = ((BigDecimal)pValeur);
    }
    if ("SalaireBrutAvtAbatt".equals(pName)) {
      m_salaireBrutAvtAbatt = ((BigDecimal)pValeur);
    }
    if ("SalaireBrutAprAbatt".equals(pName)) {
      m_salaireBrutAprAbatt = ((BigDecimal)pValeur);
    }
    if ("TauxAbatt".equals(pName)) {
      m_tauxAbatt = ((BigDecimal)pValeur);
    }
    if ("ContributionDues".equals(pName)) {
      m_contributionDues = ((BigDecimal)pValeur);
    }
    if ("MoisActualisation".equals(pName)) {
      m_moisActualisation = ((BigDecimal)pValeur);
    }
    if ("AnneeActualisation".equals(pName)) {
      m_anneeActualisation = ((BigDecimal)pValeur);
    }
    if ("NbCachetsIsoles".equals(pName)) {
      m_nbCachetsIsoles = ((BigDecimal)pValeur);
    }
    if ("NbCachetsGroupes".equals(pName)) {
      m_nbCachetsGroupes = ((BigDecimal)pValeur);
    }
    if ("AutresRemunerationsMontantBrut".equals(pName)) {
      m_autresRemunerationsMontantBrut = ((BigDecimal)pValeur);
    }
    if ("AutresRemunerationsTauxContributions".equals(pName)) {
      m_autresRemunerationsTauxContributions = ((BigDecimal)pValeur);
    }
    if ("AutresRemunerationsContributionsDues".equals(pName)) {
      m_autresRemunerationsContributionsDues = ((BigDecimal)pValeur);
    }
    if ("TotalContributionsDues".equals(pName)) {
      m_totalContributionsDues = ((BigDecimal)pValeur);
    }
    if ("BneCertifSociale".equals(pName)) {
      m_bneCertifSociale = ((String)pValeur);
    }
    if ("IdccEmployeur".equals(pName)) {
      m_idccEmployeur = ((String)pValeur);
    }
    if ("IdccPrestation".equals(pName)) {
      m_idccPrestation = ((String)pValeur);
    }
    if ("Ressortissant".equals(pName)) {
      m_ressortissant = ((String)pValeur);
    }
    if ("IndicateurCertifSociale".equals(pName)) {
      m_indicateurCertifSociale = ((String)pValeur);
    }
    if ("NumCertifSociale".equals(pName)) {
      m_numCertifSociale = ((String)pValeur);
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
    if ("m_bneSiret_C_ERR".equals(attrName)) {
      m_bneSiret_C_ERR = pValeur;
    }
    if ("m_bNEEmployeur_C_ERR".equals(attrName)) {
      m_bNEEmployeur_C_ERR = pValeur;
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
    if ("m_codeAction_C_ERR".equals(attrName)) {
      m_codeAction_C_ERR = pValeur;
    }
    if ("m_indicateurType_C_ERR".equals(attrName)) {
      m_indicateurType_C_ERR = pValeur;
    }
    if ("m_numeroInitial_C_ERR".equals(attrName)) {
      m_numeroInitial_C_ERR = pValeur;
    }
    if ("m_numero_C_ERR".equals(attrName)) {
      m_numero_C_ERR = pValeur;
    }
    if ("m_siretEmployeur_C_ERR".equals(attrName)) {
      m_siretEmployeur_C_ERR = pValeur;
    }
    if ("m_codeNafApe_C_ERR".equals(attrName)) {
      m_codeNafApe_C_ERR = pValeur;
    }
    if ("m_numAssedicAffiliation_C_ERR".equals(attrName)) {
      m_numAssedicAffiliation_C_ERR = pValeur;
    }
    if ("m_numeroAffiliation_C_ERR".equals(attrName)) {
      m_numeroAffiliation_C_ERR = pValeur;
    }
    if ("m_raisonSociale_C_ERR".equals(attrName)) {
      m_raisonSociale_C_ERR = pValeur;
    }
    if ("m_adresseEmployeur_C_ERR".equals(attrName)) {
      m_adresseEmployeur_C_ERR = pValeur;
    }
    if ("m_complAdresseEmployeur_C_ERR".equals(attrName)) {
      m_complAdresseEmployeur_C_ERR = pValeur;
    }
    if ("m_telephoneEmployeur_C_ERR".equals(attrName)) {
      m_telephoneEmployeur_C_ERR = pValeur;
    }
    if ("m_faxEmployeur_C_ERR".equals(attrName)) {
      m_faxEmployeur_C_ERR = pValeur;
    }
    if ("m_courrielEmployeur_C_ERR".equals(attrName)) {
      m_courrielEmployeur_C_ERR = pValeur;
    }
    if ("m_codePostalEmployeur_C_ERR".equals(attrName)) {
      m_codePostalEmployeur_C_ERR = pValeur;
    }
    if ("m_communeEmployeur_C_ERR".equals(attrName)) {
      m_communeEmployeur_C_ERR = pValeur;
    }
    if ("m_formeJuridique_C_ERR".equals(attrName)) {
      m_formeJuridique_C_ERR = pValeur;
    }
    if ("m_activiteEmployeur_C_ERR".equals(attrName)) {
      m_activiteEmployeur_C_ERR = pValeur;
    }
    if ("m_licenceSpectacle_C_ERR".equals(attrName)) {
      m_licenceSpectacle_C_ERR = pValeur;
    }
    if ("m_numeroLicenceSpe_C_ERR".equals(attrName)) {
      m_numeroLicenceSpe_C_ERR = pValeur;
    }
    if ("m_organisateurOccasionnelspe_C_ERR".equals(attrName)) {
      m_organisateurOccasionnelspe_C_ERR = pValeur;
    }
    if ("m_titulaireLabelPresta_C_ERR".equals(attrName)) {
      m_titulaireLabelPresta_C_ERR = pValeur;
    }
    if ("m_numeroLabelPrestaSer_C_ERR".equals(attrName)) {
      m_numeroLabelPrestaSer_C_ERR = pValeur;
    }
    if ("m_numAffiCaisseConges_C_ERR".equals(attrName)) {
      m_numAffiCaisseConges_C_ERR = pValeur;
    }
    if ("m_nomSalarie_C_ERR".equals(attrName)) {
      m_nomSalarie_C_ERR = pValeur;
    }
    if ("m_prenomSalarie_C_ERR".equals(attrName)) {
      m_prenomSalarie_C_ERR = pValeur;
    }
    if ("m_nomUsuel_C_ERR".equals(attrName)) {
      m_nomUsuel_C_ERR = pValeur;
    }
    if ("m_telephoneSalarie_C_ERR".equals(attrName)) {
      m_telephoneSalarie_C_ERR = pValeur;
    }
    if ("m_NIR_C_ERR".equals(attrName)) {
      m_NIR_C_ERR = pValeur;
    }
    if ("m_adresseSalarie_C_ERR".equals(attrName)) {
      m_adresseSalarie_C_ERR = pValeur;
    }
    if ("m_complementAdresseSalarie_C_ERR".equals(attrName)) {
      m_complementAdresseSalarie_C_ERR = pValeur;
    }
    if ("m_codePostalSalarie_C_ERR".equals(attrName)) {
      m_codePostalSalarie_C_ERR = pValeur;
    }
    if ("m_communeSalarie_C_ERR".equals(attrName)) {
      m_communeSalarie_C_ERR = pValeur;
    }
    if ("m_lienParente_C_ERR".equals(attrName)) {
      m_lienParente_C_ERR = pValeur;
    }
    if ("m_typeLienParente_C_ERR".equals(attrName)) {
      m_typeLienParente_C_ERR = pValeur;
    }
    if ("m_codeEmploiOccupe_C_ERR".equals(attrName)) {
      m_codeEmploiOccupe_C_ERR = pValeur;
    }
    if ("m_codeQualification_C_ERR".equals(attrName)) {
      m_codeQualification_C_ERR = pValeur;
    }
    if ("m_regimeRetraiteCompl_C_ERR".equals(attrName)) {
      m_regimeRetraiteCompl_C_ERR = pValeur;
    }
    if ("m_statutCadre_C_ERR".equals(attrName)) {
      m_statutCadre_C_ERR = pValeur;
    }
    if ("m_contratEnCours_C_ERR".equals(attrName)) {
      m_contratEnCours_C_ERR = pValeur;
    }
    if ("m_motiFinContrat_C_ERR".equals(attrName)) {
      m_motiFinContrat_C_ERR = pValeur;
    }
    if ("m_nomEmployeur_C_ERR".equals(attrName)) {
      m_nomEmployeur_C_ERR = pValeur;
    }
    if ("m_prenomEmployeur_C_ERR".equals(attrName)) {
      m_prenomEmployeur_C_ERR = pValeur;
    }
    if ("m_qualite_C_ERR".equals(attrName)) {
      m_qualite_C_ERR = pValeur;
    }
    if ("m_motifRupture_C_ERR".equals(attrName)) {
      m_motifRupture_C_ERR = pValeur;
    }
    if ("m_communeSignature_C_ERR".equals(attrName)) {
      m_communeSignature_C_ERR = pValeur;
    }
    if ("m_contactAEM_C_ERR".equals(attrName)) {
      m_contactAEM_C_ERR = pValeur;
    }
    if ("m_telephoneTiers_C_ERR".equals(attrName)) {
      m_telephoneTiers_C_ERR = pValeur;
    }
    if ("m_codeOrganisme_C_ERR".equals(attrName)) {
      m_codeOrganisme_C_ERR = pValeur;
    }
    if ("m_nbJoursTravailles_C_ERR".equals(attrName)) {
      m_nbJoursTravailles_C_ERR = pValeur;
    }
    if ("m_numVersionAEM_C_ERR".equals(attrName)) {
      m_numVersionAEM_C_ERR = pValeur;
    }
    if ("m_affiCaisseConges_C_ERR".equals(attrName)) {
      m_affiCaisseConges_C_ERR = pValeur;
    }
    if ("m_numeroObjet_C_ERR".equals(attrName)) {
      m_numeroObjet_C_ERR = pValeur;
    }
    if ("m_indicateurHorsChamp_C_ERR".equals(attrName)) {
      m_indicateurHorsChamp_C_ERR = pValeur;
    }
    if ("m_nouveauCodeApeNaf_C_ERR".equals(attrName)) {
      m_nouveauCodeApeNaf_C_ERR = pValeur;
    }
    if ("m_dateNaissance_C_ERR".equals(attrName)) {
      m_dateNaissance_C_ERR = pValeur;
    }
    if ("m_dateFincontrat_C_ERR".equals(attrName)) {
      m_dateFincontrat_C_ERR = pValeur;
    }
    if ("m_dateEmbauche_C_ERR".equals(attrName)) {
      m_dateEmbauche_C_ERR = pValeur;
    }
    if ("m_dateSignature_C_ERR".equals(attrName)) {
      m_dateSignature_C_ERR = pValeur;
    }
    if ("m_dateFichierExt_C_ERR".equals(attrName)) {
      m_dateFichierExt_C_ERR = pValeur;
    }
    if ("m_dateCreation_C_ERR".equals(attrName)) {
      m_dateCreation_C_ERR = pValeur;
    }
    if ("m_dateInitialeFinCDD_C_ERR".equals(attrName)) {
      m_dateInitialeFinCDD_C_ERR = pValeur;
    }
    if ("m_nbHeures_C_ERR".equals(attrName)) {
      m_nbHeures_C_ERR = pValeur;
    }
    if ("m_nbCachets_C_ERR".equals(attrName)) {
      m_nbCachets_C_ERR = pValeur;
    }
    if ("m_salaireBrutAvtAbatt_C_ERR".equals(attrName)) {
      m_salaireBrutAvtAbatt_C_ERR = pValeur;
    }
    if ("m_salaireBrutAprAbatt_C_ERR".equals(attrName)) {
      m_salaireBrutAprAbatt_C_ERR = pValeur;
    }
    if ("m_tauxAbatt_C_ERR".equals(attrName)) {
      m_tauxAbatt_C_ERR = pValeur;
    }
    if ("m_contributionDues_C_ERR".equals(attrName)) {
      m_contributionDues_C_ERR = pValeur;
    }
    if ("m_moisActualisation_C_ERR".equals(attrName)) {
      m_moisActualisation_C_ERR = pValeur;
    }
    if ("m_anneeActualisation_C_ERR".equals(attrName)) {
      m_anneeActualisation_C_ERR = pValeur;
    }
    if ("m_nbCachetsIsoles_C_ERR".equals(attrName)) {
      m_nbCachetsIsoles_C_ERR = pValeur;
    }
    if ("m_nbCachetsGroupes_C_ERR".equals(attrName)) {
      m_nbCachetsGroupes_C_ERR = pValeur;
    }
    if ("m_autresRemunerationsMontantBrut_C_ERR".equals(attrName)) {
      m_autresRemunerationsMontantBrut_C_ERR = pValeur;
    }
    if ("m_autresRemunerationsTauxContributions_C_ERR".equals(attrName)) {
      m_autresRemunerationsTauxContributions_C_ERR = pValeur;
    }
    if ("m_autresRemunerationsContributionsDues_C_ERR".equals(attrName)) {
      m_autresRemunerationsContributionsDues_C_ERR = pValeur;
    }
    if ("m_totalContributionsDues_C_ERR".equals(attrName)) {
      m_totalContributionsDues_C_ERR = pValeur;
    }
    if ("m_bneCertifSociale_C_ERR".equals(attrName)) {
      m_bneCertifSociale_C_ERR = pValeur;
    }
    if ("m_idccEmployeur_C_ERR".equals(attrName)) {
      m_idccEmployeur_C_ERR = pValeur;
    }
    if ("m_idccPrestation_C_ERR".equals(attrName)) {
      m_idccPrestation_C_ERR = pValeur;
    }
    if ("m_ressortissant_C_ERR".equals(attrName)) {
      m_ressortissant_C_ERR = pValeur;
    }
    if ("m_indicateurCertifSociale_C_ERR".equals(attrName)) {
      m_indicateurCertifSociale_C_ERR = pValeur;
    }
    if ("m_numCertifSociale_C_ERR".equals(attrName)) {
      m_numCertifSociale_C_ERR = pValeur;
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
    if ("m_bneSiret_C_ERR".equals(attrName)) {
      return m_bneSiret_C_ERR;
    }
    if ("m_bNEEmployeur_C_ERR".equals(attrName)) {
      return m_bNEEmployeur_C_ERR;
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
    if ("m_codeAction_C_ERR".equals(attrName)) {
      return m_codeAction_C_ERR;
    }
    if ("m_indicateurType_C_ERR".equals(attrName)) {
      return m_indicateurType_C_ERR;
    }
    if ("m_numeroInitial_C_ERR".equals(attrName)) {
      return m_numeroInitial_C_ERR;
    }
    if ("m_numero_C_ERR".equals(attrName)) {
      return m_numero_C_ERR;
    }
    if ("m_siretEmployeur_C_ERR".equals(attrName)) {
      return m_siretEmployeur_C_ERR;
    }
    if ("m_codeNafApe_C_ERR".equals(attrName)) {
      return m_codeNafApe_C_ERR;
    }
    if ("m_numAssedicAffiliation_C_ERR".equals(attrName)) {
      return m_numAssedicAffiliation_C_ERR;
    }
    if ("m_numeroAffiliation_C_ERR".equals(attrName)) {
      return m_numeroAffiliation_C_ERR;
    }
    if ("m_raisonSociale_C_ERR".equals(attrName)) {
      return m_raisonSociale_C_ERR;
    }
    if ("m_adresseEmployeur_C_ERR".equals(attrName)) {
      return m_adresseEmployeur_C_ERR;
    }
    if ("m_complAdresseEmployeur_C_ERR".equals(attrName)) {
      return m_complAdresseEmployeur_C_ERR;
    }
    if ("m_telephoneEmployeur_C_ERR".equals(attrName)) {
      return m_telephoneEmployeur_C_ERR;
    }
    if ("m_faxEmployeur_C_ERR".equals(attrName)) {
      return m_faxEmployeur_C_ERR;
    }
    if ("m_courrielEmployeur_C_ERR".equals(attrName)) {
      return m_courrielEmployeur_C_ERR;
    }
    if ("m_codePostalEmployeur_C_ERR".equals(attrName)) {
      return m_codePostalEmployeur_C_ERR;
    }
    if ("m_communeEmployeur_C_ERR".equals(attrName)) {
      return m_communeEmployeur_C_ERR;
    }
    if ("m_formeJuridique_C_ERR".equals(attrName)) {
      return m_formeJuridique_C_ERR;
    }
    if ("m_activiteEmployeur_C_ERR".equals(attrName)) {
      return m_activiteEmployeur_C_ERR;
    }
    if ("m_licenceSpectacle_C_ERR".equals(attrName)) {
      return m_licenceSpectacle_C_ERR;
    }
    if ("m_numeroLicenceSpe_C_ERR".equals(attrName)) {
      return m_numeroLicenceSpe_C_ERR;
    }
    if ("m_organisateurOccasionnelspe_C_ERR".equals(attrName)) {
      return m_organisateurOccasionnelspe_C_ERR;
    }
    if ("m_titulaireLabelPresta_C_ERR".equals(attrName)) {
      return m_titulaireLabelPresta_C_ERR;
    }
    if ("m_numeroLabelPrestaSer_C_ERR".equals(attrName)) {
      return m_numeroLabelPrestaSer_C_ERR;
    }
    if ("m_numAffiCaisseConges_C_ERR".equals(attrName)) {
      return m_numAffiCaisseConges_C_ERR;
    }
    if ("m_nomSalarie_C_ERR".equals(attrName)) {
      return m_nomSalarie_C_ERR;
    }
    if ("m_prenomSalarie_C_ERR".equals(attrName)) {
      return m_prenomSalarie_C_ERR;
    }
    if ("m_nomUsuel_C_ERR".equals(attrName)) {
      return m_nomUsuel_C_ERR;
    }
    if ("m_telephoneSalarie_C_ERR".equals(attrName)) {
      return m_telephoneSalarie_C_ERR;
    }
    if ("m_NIR_C_ERR".equals(attrName)) {
      return m_NIR_C_ERR;
    }
    if ("m_adresseSalarie_C_ERR".equals(attrName)) {
      return m_adresseSalarie_C_ERR;
    }
    if ("m_complementAdresseSalarie_C_ERR".equals(attrName)) {
      return m_complementAdresseSalarie_C_ERR;
    }
    if ("m_codePostalSalarie_C_ERR".equals(attrName)) {
      return m_codePostalSalarie_C_ERR;
    }
    if ("m_communeSalarie_C_ERR".equals(attrName)) {
      return m_communeSalarie_C_ERR;
    }
    if ("m_lienParente_C_ERR".equals(attrName)) {
      return m_lienParente_C_ERR;
    }
    if ("m_typeLienParente_C_ERR".equals(attrName)) {
      return m_typeLienParente_C_ERR;
    }
    if ("m_codeEmploiOccupe_C_ERR".equals(attrName)) {
      return m_codeEmploiOccupe_C_ERR;
    }
    if ("m_codeQualification_C_ERR".equals(attrName)) {
      return m_codeQualification_C_ERR;
    }
    if ("m_regimeRetraiteCompl_C_ERR".equals(attrName)) {
      return m_regimeRetraiteCompl_C_ERR;
    }
    if ("m_statutCadre_C_ERR".equals(attrName)) {
      return m_statutCadre_C_ERR;
    }
    if ("m_contratEnCours_C_ERR".equals(attrName)) {
      return m_contratEnCours_C_ERR;
    }
    if ("m_motiFinContrat_C_ERR".equals(attrName)) {
      return m_motiFinContrat_C_ERR;
    }
    if ("m_nomEmployeur_C_ERR".equals(attrName)) {
      return m_nomEmployeur_C_ERR;
    }
    if ("m_prenomEmployeur_C_ERR".equals(attrName)) {
      return m_prenomEmployeur_C_ERR;
    }
    if ("m_qualite_C_ERR".equals(attrName)) {
      return m_qualite_C_ERR;
    }
    if ("m_motifRupture_C_ERR".equals(attrName)) {
      return m_motifRupture_C_ERR;
    }
    if ("m_communeSignature_C_ERR".equals(attrName)) {
      return m_communeSignature_C_ERR;
    }
    if ("m_contactAEM_C_ERR".equals(attrName)) {
      return m_contactAEM_C_ERR;
    }
    if ("m_telephoneTiers_C_ERR".equals(attrName)) {
      return m_telephoneTiers_C_ERR;
    }
    if ("m_codeOrganisme_C_ERR".equals(attrName)) {
      return m_codeOrganisme_C_ERR;
    }
    if ("m_nbJoursTravailles_C_ERR".equals(attrName)) {
      return m_nbJoursTravailles_C_ERR;
    }
    if ("m_numVersionAEM_C_ERR".equals(attrName)) {
      return m_numVersionAEM_C_ERR;
    }
    if ("m_affiCaisseConges_C_ERR".equals(attrName)) {
      return m_affiCaisseConges_C_ERR;
    }
    if ("m_numeroObjet_C_ERR".equals(attrName)) {
      return m_numeroObjet_C_ERR;
    }
    if ("m_indicateurHorsChamp_C_ERR".equals(attrName)) {
      return m_indicateurHorsChamp_C_ERR;
    }
    if ("m_nouveauCodeApeNaf_C_ERR".equals(attrName)) {
      return m_nouveauCodeApeNaf_C_ERR;
    }
    if ("m_dateNaissance_C_ERR".equals(attrName)) {
      return m_dateNaissance_C_ERR;
    }
    if ("m_dateFincontrat_C_ERR".equals(attrName)) {
      return m_dateFincontrat_C_ERR;
    }
    if ("m_dateEmbauche_C_ERR".equals(attrName)) {
      return m_dateEmbauche_C_ERR;
    }
    if ("m_dateSignature_C_ERR".equals(attrName)) {
      return m_dateSignature_C_ERR;
    }
    if ("m_dateFichierExt_C_ERR".equals(attrName)) {
      return m_dateFichierExt_C_ERR;
    }
    if ("m_dateCreation_C_ERR".equals(attrName)) {
      return m_dateCreation_C_ERR;
    }
    if ("m_dateInitialeFinCDD_C_ERR".equals(attrName)) {
      return m_dateInitialeFinCDD_C_ERR;
    }
    if ("m_nbHeures_C_ERR".equals(attrName)) {
      return m_nbHeures_C_ERR;
    }
    if ("m_nbCachets_C_ERR".equals(attrName)) {
      return m_nbCachets_C_ERR;
    }
    if ("m_salaireBrutAvtAbatt_C_ERR".equals(attrName)) {
      return m_salaireBrutAvtAbatt_C_ERR;
    }
    if ("m_salaireBrutAprAbatt_C_ERR".equals(attrName)) {
      return m_salaireBrutAprAbatt_C_ERR;
    }
    if ("m_tauxAbatt_C_ERR".equals(attrName)) {
      return m_tauxAbatt_C_ERR;
    }
    if ("m_contributionDues_C_ERR".equals(attrName)) {
      return m_contributionDues_C_ERR;
    }
    if ("m_moisActualisation_C_ERR".equals(attrName)) {
      return m_moisActualisation_C_ERR;
    }
    if ("m_anneeActualisation_C_ERR".equals(attrName)) {
      return m_anneeActualisation_C_ERR;
    }
    if ("m_nbCachetsIsoles_C_ERR".equals(attrName)) {
      return m_nbCachetsIsoles_C_ERR;
    }
    if ("m_nbCachetsGroupes_C_ERR".equals(attrName)) {
      return m_nbCachetsGroupes_C_ERR;
    }
    if ("m_autresRemunerationsMontantBrut_C_ERR".equals(attrName)) {
      return m_autresRemunerationsMontantBrut_C_ERR;
    }
    if ("m_autresRemunerationsTauxContributions_C_ERR".equals(attrName)) {
      return m_autresRemunerationsTauxContributions_C_ERR;
    }
    if ("m_autresRemunerationsContributionsDues_C_ERR".equals(attrName)) {
      return m_autresRemunerationsContributionsDues_C_ERR;
    }
    if ("m_totalContributionsDues_C_ERR".equals(attrName)) {
      return m_totalContributionsDues_C_ERR;
    }
    if ("m_bneCertifSociale_C_ERR".equals(attrName)) {
      return m_bneCertifSociale_C_ERR;
    }
    if ("m_idccEmployeur_C_ERR".equals(attrName)) {
      return m_idccEmployeur_C_ERR;
    }
    if ("m_idccPrestation_C_ERR".equals(attrName)) {
      return m_idccPrestation_C_ERR;
    }
    if ("m_ressortissant_C_ERR".equals(attrName)) {
      return m_ressortissant_C_ERR;
    }
    if ("m_indicateurCertifSociale_C_ERR".equals(attrName)) {
      return m_indicateurCertifSociale_C_ERR;
    }
    if ("m_numCertifSociale_C_ERR".equals(attrName)) {
      return m_numCertifSociale_C_ERR;
    }
    return null;
  }
  
  public boolean equals(Object pObjet)
  {
    if (!(pObjet instanceof _FluxAEM)) {
      return false;
    }
    _FluxAEM x = (_FluxAEM)pObjet;
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
    if (m_bNEEmployeur == null)
    {
      if (m_bNEEmployeur != null) {
        return false;
      }
    }
    else
    {
      if (m_bNEEmployeur == null) {
        return false;
      }
      if (!m_bNEEmployeur.equals(m_bNEEmployeur)) {
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
    if (m_indicateurType == null)
    {
      if (m_indicateurType != null) {
        return false;
      }
    }
    else
    {
      if (m_indicateurType == null) {
        return false;
      }
      if (!m_indicateurType.equals(m_indicateurType)) {
        return false;
      }
    }
    if (m_numeroInitial == null)
    {
      if (m_numeroInitial != null) {
        return false;
      }
    }
    else
    {
      if (m_numeroInitial == null) {
        return false;
      }
      if (!m_numeroInitial.equals(m_numeroInitial)) {
        return false;
      }
    }
    if (m_numero == null)
    {
      if (m_numero != null) {
        return false;
      }
    }
    else
    {
      if (m_numero == null) {
        return false;
      }
      if (!m_numero.equals(m_numero)) {
        return false;
      }
    }
    if (m_siretEmployeur == null)
    {
      if (m_siretEmployeur != null) {
        return false;
      }
    }
    else
    {
      if (m_siretEmployeur == null) {
        return false;
      }
      if (!m_siretEmployeur.equals(m_siretEmployeur)) {
        return false;
      }
    }
    if (m_codeNafApe == null)
    {
      if (m_codeNafApe != null) {
        return false;
      }
    }
    else
    {
      if (m_codeNafApe == null) {
        return false;
      }
      if (!m_codeNafApe.equals(m_codeNafApe)) {
        return false;
      }
    }
    if (m_numAssedicAffiliation == null)
    {
      if (m_numAssedicAffiliation != null) {
        return false;
      }
    }
    else
    {
      if (m_numAssedicAffiliation == null) {
        return false;
      }
      if (!m_numAssedicAffiliation.equals(m_numAssedicAffiliation)) {
        return false;
      }
    }
    if (m_numeroAffiliation == null)
    {
      if (m_numeroAffiliation != null) {
        return false;
      }
    }
    else
    {
      if (m_numeroAffiliation == null) {
        return false;
      }
      if (!m_numeroAffiliation.equals(m_numeroAffiliation)) {
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
    if (m_adresseEmployeur == null)
    {
      if (m_adresseEmployeur != null) {
        return false;
      }
    }
    else
    {
      if (m_adresseEmployeur == null) {
        return false;
      }
      if (!m_adresseEmployeur.equals(m_adresseEmployeur)) {
        return false;
      }
    }
    if (m_complAdresseEmployeur == null)
    {
      if (m_complAdresseEmployeur != null) {
        return false;
      }
    }
    else
    {
      if (m_complAdresseEmployeur == null) {
        return false;
      }
      if (!m_complAdresseEmployeur.equals(m_complAdresseEmployeur)) {
        return false;
      }
    }
    if (m_telephoneEmployeur == null)
    {
      if (m_telephoneEmployeur != null) {
        return false;
      }
    }
    else
    {
      if (m_telephoneEmployeur == null) {
        return false;
      }
      if (!m_telephoneEmployeur.equals(m_telephoneEmployeur)) {
        return false;
      }
    }
    if (m_faxEmployeur == null)
    {
      if (m_faxEmployeur != null) {
        return false;
      }
    }
    else
    {
      if (m_faxEmployeur == null) {
        return false;
      }
      if (!m_faxEmployeur.equals(m_faxEmployeur)) {
        return false;
      }
    }
    if (m_courrielEmployeur == null)
    {
      if (m_courrielEmployeur != null) {
        return false;
      }
    }
    else
    {
      if (m_courrielEmployeur == null) {
        return false;
      }
      if (!m_courrielEmployeur.equals(m_courrielEmployeur)) {
        return false;
      }
    }
    if (m_codePostalEmployeur == null)
    {
      if (m_codePostalEmployeur != null) {
        return false;
      }
    }
    else
    {
      if (m_codePostalEmployeur == null) {
        return false;
      }
      if (!m_codePostalEmployeur.equals(m_codePostalEmployeur)) {
        return false;
      }
    }
    if (m_communeEmployeur == null)
    {
      if (m_communeEmployeur != null) {
        return false;
      }
    }
    else
    {
      if (m_communeEmployeur == null) {
        return false;
      }
      if (!m_communeEmployeur.equals(m_communeEmployeur)) {
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
    if (m_activiteEmployeur == null)
    {
      if (m_activiteEmployeur != null) {
        return false;
      }
    }
    else
    {
      if (m_activiteEmployeur == null) {
        return false;
      }
      if (!m_activiteEmployeur.equals(m_activiteEmployeur)) {
        return false;
      }
    }
    if (m_licenceSpectacle == null)
    {
      if (m_licenceSpectacle != null) {
        return false;
      }
    }
    else
    {
      if (m_licenceSpectacle == null) {
        return false;
      }
      if (!m_licenceSpectacle.equals(m_licenceSpectacle)) {
        return false;
      }
    }
    if (m_numeroLicenceSpe == null)
    {
      if (m_numeroLicenceSpe != null) {
        return false;
      }
    }
    else
    {
      if (m_numeroLicenceSpe == null) {
        return false;
      }
      if (!m_numeroLicenceSpe.equals(m_numeroLicenceSpe)) {
        return false;
      }
    }
    if (m_organisateurOccasionnelspe == null)
    {
      if (m_organisateurOccasionnelspe != null) {
        return false;
      }
    }
    else
    {
      if (m_organisateurOccasionnelspe == null) {
        return false;
      }
      if (!m_organisateurOccasionnelspe.equals(m_organisateurOccasionnelspe)) {
        return false;
      }
    }
    if (m_titulaireLabelPresta == null)
    {
      if (m_titulaireLabelPresta != null) {
        return false;
      }
    }
    else
    {
      if (m_titulaireLabelPresta == null) {
        return false;
      }
      if (!m_titulaireLabelPresta.equals(m_titulaireLabelPresta)) {
        return false;
      }
    }
    if (m_numeroLabelPrestaSer == null)
    {
      if (m_numeroLabelPrestaSer != null) {
        return false;
      }
    }
    else
    {
      if (m_numeroLabelPrestaSer == null) {
        return false;
      }
      if (!m_numeroLabelPrestaSer.equals(m_numeroLabelPrestaSer)) {
        return false;
      }
    }
    if (m_numAffiCaisseConges == null)
    {
      if (m_numAffiCaisseConges != null) {
        return false;
      }
    }
    else
    {
      if (m_numAffiCaisseConges == null) {
        return false;
      }
      if (!m_numAffiCaisseConges.equals(m_numAffiCaisseConges)) {
        return false;
      }
    }
    if (m_nomSalarie == null)
    {
      if (m_nomSalarie != null) {
        return false;
      }
    }
    else
    {
      if (m_nomSalarie == null) {
        return false;
      }
      if (!m_nomSalarie.equals(m_nomSalarie)) {
        return false;
      }
    }
    if (m_prenomSalarie == null)
    {
      if (m_prenomSalarie != null) {
        return false;
      }
    }
    else
    {
      if (m_prenomSalarie == null) {
        return false;
      }
      if (!m_prenomSalarie.equals(m_prenomSalarie)) {
        return false;
      }
    }
    if (m_nomUsuel == null)
    {
      if (m_nomUsuel != null) {
        return false;
      }
    }
    else
    {
      if (m_nomUsuel == null) {
        return false;
      }
      if (!m_nomUsuel.equals(m_nomUsuel)) {
        return false;
      }
    }
    if (m_telephoneSalarie == null)
    {
      if (m_telephoneSalarie != null) {
        return false;
      }
    }
    else
    {
      if (m_telephoneSalarie == null) {
        return false;
      }
      if (!m_telephoneSalarie.equals(m_telephoneSalarie)) {
        return false;
      }
    }
    if (m_NIR == null)
    {
      if (m_NIR != null) {
        return false;
      }
    }
    else
    {
      if (m_NIR == null) {
        return false;
      }
      if (!m_NIR.equals(m_NIR)) {
        return false;
      }
    }
    if (m_adresseSalarie == null)
    {
      if (m_adresseSalarie != null) {
        return false;
      }
    }
    else
    {
      if (m_adresseSalarie == null) {
        return false;
      }
      if (!m_adresseSalarie.equals(m_adresseSalarie)) {
        return false;
      }
    }
    if (m_complementAdresseSalarie == null)
    {
      if (m_complementAdresseSalarie != null) {
        return false;
      }
    }
    else
    {
      if (m_complementAdresseSalarie == null) {
        return false;
      }
      if (!m_complementAdresseSalarie.equals(m_complementAdresseSalarie)) {
        return false;
      }
    }
    if (m_codePostalSalarie == null)
    {
      if (m_codePostalSalarie != null) {
        return false;
      }
    }
    else
    {
      if (m_codePostalSalarie == null) {
        return false;
      }
      if (!m_codePostalSalarie.equals(m_codePostalSalarie)) {
        return false;
      }
    }
    if (m_communeSalarie == null)
    {
      if (m_communeSalarie != null) {
        return false;
      }
    }
    else
    {
      if (m_communeSalarie == null) {
        return false;
      }
      if (!m_communeSalarie.equals(m_communeSalarie)) {
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
    if (m_typeLienParente == null)
    {
      if (m_typeLienParente != null) {
        return false;
      }
    }
    else
    {
      if (m_typeLienParente == null) {
        return false;
      }
      if (!m_typeLienParente.equals(m_typeLienParente)) {
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
    if (m_codeQualification == null)
    {
      if (m_codeQualification != null) {
        return false;
      }
    }
    else
    {
      if (m_codeQualification == null) {
        return false;
      }
      if (!m_codeQualification.equals(m_codeQualification)) {
        return false;
      }
    }
    if (m_regimeRetraiteCompl == null)
    {
      if (m_regimeRetraiteCompl != null) {
        return false;
      }
    }
    else
    {
      if (m_regimeRetraiteCompl == null) {
        return false;
      }
      if (!m_regimeRetraiteCompl.equals(m_regimeRetraiteCompl)) {
        return false;
      }
    }
    if (m_statutCadre == null)
    {
      if (m_statutCadre != null) {
        return false;
      }
    }
    else
    {
      if (m_statutCadre == null) {
        return false;
      }
      if (!m_statutCadre.equals(m_statutCadre)) {
        return false;
      }
    }
    if (m_contratEnCours == null)
    {
      if (m_contratEnCours != null) {
        return false;
      }
    }
    else
    {
      if (m_contratEnCours == null) {
        return false;
      }
      if (!m_contratEnCours.equals(m_contratEnCours)) {
        return false;
      }
    }
    if (m_motiFinContrat == null)
    {
      if (m_motiFinContrat != null) {
        return false;
      }
    }
    else
    {
      if (m_motiFinContrat == null) {
        return false;
      }
      if (!m_motiFinContrat.equals(m_motiFinContrat)) {
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
    if (m_qualite == null)
    {
      if (m_qualite != null) {
        return false;
      }
    }
    else
    {
      if (m_qualite == null) {
        return false;
      }
      if (!m_qualite.equals(m_qualite)) {
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
    if (m_communeSignature == null)
    {
      if (m_communeSignature != null) {
        return false;
      }
    }
    else
    {
      if (m_communeSignature == null) {
        return false;
      }
      if (!m_communeSignature.equals(m_communeSignature)) {
        return false;
      }
    }
    if (m_contactAEM == null)
    {
      if (m_contactAEM != null) {
        return false;
      }
    }
    else
    {
      if (m_contactAEM == null) {
        return false;
      }
      if (!m_contactAEM.equals(m_contactAEM)) {
        return false;
      }
    }
    if (m_telephoneTiers == null)
    {
      if (m_telephoneTiers != null) {
        return false;
      }
    }
    else
    {
      if (m_telephoneTiers == null) {
        return false;
      }
      if (!m_telephoneTiers.equals(m_telephoneTiers)) {
        return false;
      }
    }
    if (m_codeOrganisme == null)
    {
      if (m_codeOrganisme != null) {
        return false;
      }
    }
    else
    {
      if (m_codeOrganisme == null) {
        return false;
      }
      if (!m_codeOrganisme.equals(m_codeOrganisme)) {
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
    if (m_numVersionAEM == null)
    {
      if (m_numVersionAEM != null) {
        return false;
      }
    }
    else
    {
      if (m_numVersionAEM == null) {
        return false;
      }
      if (!m_numVersionAEM.equals(m_numVersionAEM)) {
        return false;
      }
    }
    if (m_affiCaisseConges == null)
    {
      if (m_affiCaisseConges != null) {
        return false;
      }
    }
    else
    {
      if (m_affiCaisseConges == null) {
        return false;
      }
      if (!m_affiCaisseConges.equals(m_affiCaisseConges)) {
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
    if (m_indicateurHorsChamp == null)
    {
      if (m_indicateurHorsChamp != null) {
        return false;
      }
    }
    else
    {
      if (m_indicateurHorsChamp == null) {
        return false;
      }
      if (!m_indicateurHorsChamp.equals(m_indicateurHorsChamp)) {
        return false;
      }
    }
    if (m_nouveauCodeApeNaf == null)
    {
      if (m_nouveauCodeApeNaf != null) {
        return false;
      }
    }
    else
    {
      if (m_nouveauCodeApeNaf == null) {
        return false;
      }
      if (!m_nouveauCodeApeNaf.equals(m_nouveauCodeApeNaf)) {
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
    if (m_dateFincontrat == null)
    {
      if (m_dateFincontrat != null) {
        return false;
      }
    }
    else
    {
      if (m_dateFincontrat == null) {
        return false;
      }
      if (!m_dateFincontrat.equals(m_dateFincontrat)) {
        return false;
      }
    }
    if (m_dateEmbauche == null)
    {
      if (m_dateEmbauche != null) {
        return false;
      }
    }
    else
    {
      if (m_dateEmbauche == null) {
        return false;
      }
      if (!m_dateEmbauche.equals(m_dateEmbauche)) {
        return false;
      }
    }
    if (m_dateSignature == null)
    {
      if (m_dateSignature != null) {
        return false;
      }
    }
    else
    {
      if (m_dateSignature == null) {
        return false;
      }
      if (!m_dateSignature.equals(m_dateSignature)) {
        return false;
      }
    }
    if (m_dateFichierExt == null)
    {
      if (m_dateFichierExt != null) {
        return false;
      }
    }
    else
    {
      if (m_dateFichierExt == null) {
        return false;
      }
      if (!m_dateFichierExt.equals(m_dateFichierExt)) {
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
    if (m_dateInitialeFinCDD == null)
    {
      if (m_dateInitialeFinCDD != null) {
        return false;
      }
    }
    else
    {
      if (m_dateInitialeFinCDD == null) {
        return false;
      }
      if (!m_dateInitialeFinCDD.equals(m_dateInitialeFinCDD)) {
        return false;
      }
    }
    if (m_nbHeures == null)
    {
      if (m_nbHeures != null) {
        return false;
      }
    }
    else
    {
      if (m_nbHeures == null) {
        return false;
      }
      if (!m_nbHeures.equals(m_nbHeures)) {
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
    if (m_salaireBrutAvtAbatt == null)
    {
      if (m_salaireBrutAvtAbatt != null) {
        return false;
      }
    }
    else
    {
      if (m_salaireBrutAvtAbatt == null) {
        return false;
      }
      if (!m_salaireBrutAvtAbatt.equals(m_salaireBrutAvtAbatt)) {
        return false;
      }
    }
    if (m_salaireBrutAprAbatt == null)
    {
      if (m_salaireBrutAprAbatt != null) {
        return false;
      }
    }
    else
    {
      if (m_salaireBrutAprAbatt == null) {
        return false;
      }
      if (!m_salaireBrutAprAbatt.equals(m_salaireBrutAprAbatt)) {
        return false;
      }
    }
    if (m_tauxAbatt == null)
    {
      if (m_tauxAbatt != null) {
        return false;
      }
    }
    else
    {
      if (m_tauxAbatt == null) {
        return false;
      }
      if (!m_tauxAbatt.equals(m_tauxAbatt)) {
        return false;
      }
    }
    if (m_contributionDues == null)
    {
      if (m_contributionDues != null) {
        return false;
      }
    }
    else
    {
      if (m_contributionDues == null) {
        return false;
      }
      if (!m_contributionDues.equals(m_contributionDues)) {
        return false;
      }
    }
    if (m_moisActualisation == null)
    {
      if (m_moisActualisation != null) {
        return false;
      }
    }
    else
    {
      if (m_moisActualisation == null) {
        return false;
      }
      if (!m_moisActualisation.equals(m_moisActualisation)) {
        return false;
      }
    }
    if (m_anneeActualisation == null)
    {
      if (m_anneeActualisation != null) {
        return false;
      }
    }
    else
    {
      if (m_anneeActualisation == null) {
        return false;
      }
      if (!m_anneeActualisation.equals(m_anneeActualisation)) {
        return false;
      }
    }
    if (m_nbCachetsIsoles == null)
    {
      if (m_nbCachetsIsoles != null) {
        return false;
      }
    }
    else
    {
      if (m_nbCachetsIsoles == null) {
        return false;
      }
      if (!m_nbCachetsIsoles.equals(m_nbCachetsIsoles)) {
        return false;
      }
    }
    if (m_nbCachetsGroupes == null)
    {
      if (m_nbCachetsGroupes != null) {
        return false;
      }
    }
    else
    {
      if (m_nbCachetsGroupes == null) {
        return false;
      }
      if (!m_nbCachetsGroupes.equals(m_nbCachetsGroupes)) {
        return false;
      }
    }
    if (m_autresRemunerationsMontantBrut == null)
    {
      if (m_autresRemunerationsMontantBrut != null) {
        return false;
      }
    }
    else
    {
      if (m_autresRemunerationsMontantBrut == null) {
        return false;
      }
      if (!m_autresRemunerationsMontantBrut.equals(m_autresRemunerationsMontantBrut)) {
        return false;
      }
    }
    if (m_autresRemunerationsTauxContributions == null)
    {
      if (m_autresRemunerationsTauxContributions != null) {
        return false;
      }
    }
    else
    {
      if (m_autresRemunerationsTauxContributions == null) {
        return false;
      }
      if (!m_autresRemunerationsTauxContributions.equals(m_autresRemunerationsTauxContributions)) {
        return false;
      }
    }
    if (m_autresRemunerationsContributionsDues == null)
    {
      if (m_autresRemunerationsContributionsDues != null) {
        return false;
      }
    }
    else
    {
      if (m_autresRemunerationsContributionsDues == null) {
        return false;
      }
      if (!m_autresRemunerationsContributionsDues.equals(m_autresRemunerationsContributionsDues)) {
        return false;
      }
    }
    if (m_totalContributionsDues == null)
    {
      if (m_totalContributionsDues != null) {
        return false;
      }
    }
    else
    {
      if (m_totalContributionsDues == null) {
        return false;
      }
      if (!m_totalContributionsDues.equals(m_totalContributionsDues)) {
        return false;
      }
    }
    if (m_bneCertifSociale == null)
    {
      if (m_bneCertifSociale != null) {
        return false;
      }
    }
    else
    {
      if (m_bneCertifSociale == null) {
        return false;
      }
      if (!m_bneCertifSociale.equals(m_bneCertifSociale)) {
        return false;
      }
    }
    if (m_idccEmployeur == null)
    {
      if (m_idccEmployeur != null) {
        return false;
      }
    }
    else
    {
      if (m_idccEmployeur == null) {
        return false;
      }
      if (!m_idccEmployeur.equals(m_idccEmployeur)) {
        return false;
      }
    }
    if (m_idccPrestation == null)
    {
      if (m_idccPrestation != null) {
        return false;
      }
    }
    else
    {
      if (m_idccPrestation == null) {
        return false;
      }
      if (!m_idccPrestation.equals(m_idccPrestation)) {
        return false;
      }
    }
    if (m_ressortissant == null)
    {
      if (m_ressortissant != null) {
        return false;
      }
    }
    else
    {
      if (m_ressortissant == null) {
        return false;
      }
      if (!m_ressortissant.equals(m_ressortissant)) {
        return false;
      }
    }
    if (m_indicateurCertifSociale == null)
    {
      if (m_indicateurCertifSociale != null) {
        return false;
      }
    }
    else
    {
      if (m_indicateurCertifSociale == null) {
        return false;
      }
      if (!m_indicateurCertifSociale.equals(m_indicateurCertifSociale)) {
        return false;
      }
    }
    if (m_numCertifSociale == null)
    {
      if (m_numCertifSociale != null) {
        return false;
      }
    }
    else
    {
      if (m_numCertifSociale == null) {
        return false;
      }
      if (!m_numCertifSociale.equals(m_numCertifSociale)) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int result = 0;
    if (m_bneSiret != null) {
      result += m_bneSiret.hashCode();
    }
    if (m_bNEEmployeur != null) {
      result += m_bNEEmployeur.hashCode();
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
    if (m_codeAction != null) {
      result += m_codeAction.hashCode();
    }
    if (m_indicateurType != null) {
      result += m_indicateurType.hashCode();
    }
    if (m_numeroInitial != null) {
      result += m_numeroInitial.hashCode();
    }
    if (m_numero != null) {
      result += m_numero.hashCode();
    }
    if (m_siretEmployeur != null) {
      result += m_siretEmployeur.hashCode();
    }
    if (m_codeNafApe != null) {
      result += m_codeNafApe.hashCode();
    }
    if (m_numAssedicAffiliation != null) {
      result += m_numAssedicAffiliation.hashCode();
    }
    if (m_numeroAffiliation != null) {
      result += m_numeroAffiliation.hashCode();
    }
    if (m_raisonSociale != null) {
      result += m_raisonSociale.hashCode();
    }
    if (m_adresseEmployeur != null) {
      result += m_adresseEmployeur.hashCode();
    }
    if (m_complAdresseEmployeur != null) {
      result += m_complAdresseEmployeur.hashCode();
    }
    if (m_telephoneEmployeur != null) {
      result += m_telephoneEmployeur.hashCode();
    }
    if (m_faxEmployeur != null) {
      result += m_faxEmployeur.hashCode();
    }
    if (m_courrielEmployeur != null) {
      result += m_courrielEmployeur.hashCode();
    }
    if (m_codePostalEmployeur != null) {
      result += m_codePostalEmployeur.hashCode();
    }
    if (m_communeEmployeur != null) {
      result += m_communeEmployeur.hashCode();
    }
    if (m_formeJuridique != null) {
      result += m_formeJuridique.hashCode();
    }
    if (m_activiteEmployeur != null) {
      result += m_activiteEmployeur.hashCode();
    }
    if (m_licenceSpectacle != null) {
      result += m_licenceSpectacle.hashCode();
    }
    if (m_numeroLicenceSpe != null) {
      result += m_numeroLicenceSpe.hashCode();
    }
    if (m_organisateurOccasionnelspe != null) {
      result += m_organisateurOccasionnelspe.hashCode();
    }
    if (m_titulaireLabelPresta != null) {
      result += m_titulaireLabelPresta.hashCode();
    }
    if (m_numeroLabelPrestaSer != null) {
      result += m_numeroLabelPrestaSer.hashCode();
    }
    if (m_numAffiCaisseConges != null) {
      result += m_numAffiCaisseConges.hashCode();
    }
    if (m_nomSalarie != null) {
      result += m_nomSalarie.hashCode();
    }
    if (m_prenomSalarie != null) {
      result += m_prenomSalarie.hashCode();
    }
    if (m_nomUsuel != null) {
      result += m_nomUsuel.hashCode();
    }
    if (m_telephoneSalarie != null) {
      result += m_telephoneSalarie.hashCode();
    }
    if (m_NIR != null) {
      result += m_NIR.hashCode();
    }
    if (m_adresseSalarie != null) {
      result += m_adresseSalarie.hashCode();
    }
    if (m_complementAdresseSalarie != null) {
      result += m_complementAdresseSalarie.hashCode();
    }
    if (m_codePostalSalarie != null) {
      result += m_codePostalSalarie.hashCode();
    }
    if (m_communeSalarie != null) {
      result += m_communeSalarie.hashCode();
    }
    if (m_lienParente != null) {
      result += m_lienParente.hashCode();
    }
    if (m_typeLienParente != null) {
      result += m_typeLienParente.hashCode();
    }
    if (m_codeEmploiOccupe != null) {
      result += m_codeEmploiOccupe.hashCode();
    }
    if (m_codeQualification != null) {
      result += m_codeQualification.hashCode();
    }
    if (m_regimeRetraiteCompl != null) {
      result += m_regimeRetraiteCompl.hashCode();
    }
    if (m_statutCadre != null) {
      result += m_statutCadre.hashCode();
    }
    if (m_contratEnCours != null) {
      result += m_contratEnCours.hashCode();
    }
    if (m_motiFinContrat != null) {
      result += m_motiFinContrat.hashCode();
    }
    if (m_nomEmployeur != null) {
      result += m_nomEmployeur.hashCode();
    }
    if (m_prenomEmployeur != null) {
      result += m_prenomEmployeur.hashCode();
    }
    if (m_qualite != null) {
      result += m_qualite.hashCode();
    }
    if (m_motifRupture != null) {
      result += m_motifRupture.hashCode();
    }
    if (m_communeSignature != null) {
      result += m_communeSignature.hashCode();
    }
    if (m_contactAEM != null) {
      result += m_contactAEM.hashCode();
    }
    if (m_telephoneTiers != null) {
      result += m_telephoneTiers.hashCode();
    }
    if (m_codeOrganisme != null) {
      result += m_codeOrganisme.hashCode();
    }
    if (m_nbJoursTravailles != null) {
      result += m_nbJoursTravailles.hashCode();
    }
    if (m_numVersionAEM != null) {
      result += m_numVersionAEM.hashCode();
    }
    if (m_affiCaisseConges != null) {
      result += m_affiCaisseConges.hashCode();
    }
    if (m_numeroObjet != null) {
      result += m_numeroObjet.hashCode();
    }
    if (m_indicateurHorsChamp != null) {
      result += m_indicateurHorsChamp.hashCode();
    }
    if (m_nouveauCodeApeNaf != null) {
      result += m_nouveauCodeApeNaf.hashCode();
    }
    if (m_dateNaissance != null) {
      result += m_dateNaissance.hashCode();
    }
    if (m_dateFincontrat != null) {
      result += m_dateFincontrat.hashCode();
    }
    if (m_dateEmbauche != null) {
      result += m_dateEmbauche.hashCode();
    }
    if (m_dateSignature != null) {
      result += m_dateSignature.hashCode();
    }
    if (m_dateFichierExt != null) {
      result += m_dateFichierExt.hashCode();
    }
    if (m_dateCreation != null) {
      result += m_dateCreation.hashCode();
    }
    if (m_dateInitialeFinCDD != null) {
      result += m_dateInitialeFinCDD.hashCode();
    }
    if (m_nbHeures != null) {
      result += m_nbHeures.hashCode();
    }
    if (m_nbCachets != null) {
      result += m_nbCachets.hashCode();
    }
    if (m_salaireBrutAvtAbatt != null) {
      result += m_salaireBrutAvtAbatt.hashCode();
    }
    if (m_salaireBrutAprAbatt != null) {
      result += m_salaireBrutAprAbatt.hashCode();
    }
    if (m_tauxAbatt != null) {
      result += m_tauxAbatt.hashCode();
    }
    if (m_contributionDues != null) {
      result += m_contributionDues.hashCode();
    }
    if (m_moisActualisation != null) {
      result += m_moisActualisation.hashCode();
    }
    if (m_anneeActualisation != null) {
      result += m_anneeActualisation.hashCode();
    }
    if (m_nbCachetsIsoles != null) {
      result += m_nbCachetsIsoles.hashCode();
    }
    if (m_nbCachetsGroupes != null) {
      result += m_nbCachetsGroupes.hashCode();
    }
    if (m_autresRemunerationsMontantBrut != null) {
      result += m_autresRemunerationsMontantBrut.hashCode();
    }
    if (m_autresRemunerationsTauxContributions != null) {
      result += m_autresRemunerationsTauxContributions.hashCode();
    }
    if (m_autresRemunerationsContributionsDues != null) {
      result += m_autresRemunerationsContributionsDues.hashCode();
    }
    if (m_totalContributionsDues != null) {
      result += m_totalContributionsDues.hashCode();
    }
    if (m_bneCertifSociale != null) {
      result += m_bneCertifSociale.hashCode();
    }
    if (m_idccEmployeur != null) {
      result += m_idccEmployeur.hashCode();
    }
    if (m_idccPrestation != null) {
      result += m_idccPrestation.hashCode();
    }
    if (m_ressortissant != null) {
      result += m_ressortissant.hashCode();
    }
    if (m_indicateurCertifSociale != null) {
      result += m_indicateurCertifSociale.hashCode();
    }
    if (m_numCertifSociale != null) {
      result += m_numCertifSociale.hashCode();
    }
    result *= 17;
    return result;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    _FluxAEM clone_FluxAEM = new _FluxAEM();
    clone_FluxAEM.populateFrom_FluxAEM(this);
    return clone_FluxAEM;
  }
  
  public void populateFrom_FluxAEM(_FluxAEM pSource)
  {
    setBneSiret(pSource.getBneSiret());setBNEEmployeur(pSource.getBNEEmployeur());setBneRaisonSociale(pSource.getBneRaisonSociale());setBneNumeroVoirie(pSource.getBneNumeroVoirie());setBneLibelleVoieAdresse(pSource.getBneLibelleVoieAdresse());setBneComplAdresse(pSource.getBneComplAdresse());setBneCodePostal(pSource.getBneCodePostal());setBneLibelleCommune(pSource.getBneLibelleCommune());setBneAssedicAffiliation(pSource.getBneAssedicAffiliation());setBneNumAffiliation(pSource.getBneNumAffiliation());setCodeAction(pSource.getCodeAction());setIndicateurType(pSource.getIndicateurType());setNumeroInitial(pSource.getNumeroInitial());setNumero(pSource.getNumero());setSiretEmployeur(pSource.getSiretEmployeur());setCodeNafApe(pSource.getCodeNafApe());setNumAssedicAffiliation(pSource.getNumAssedicAffiliation());setNumeroAffiliation(pSource.getNumeroAffiliation());setRaisonSociale(pSource.getRaisonSociale());setAdresseEmployeur(pSource.getAdresseEmployeur());setComplAdresseEmployeur(pSource.getComplAdresseEmployeur());setTelephoneEmployeur(pSource.getTelephoneEmployeur());setFaxEmployeur(pSource.getFaxEmployeur());setCourrielEmployeur(pSource.getCourrielEmployeur());setCodePostalEmployeur(pSource.getCodePostalEmployeur());setCommuneEmployeur(pSource.getCommuneEmployeur());setFormeJuridique(pSource.getFormeJuridique());setActiviteEmployeur(pSource.getActiviteEmployeur());setLicenceSpectacle(pSource.getLicenceSpectacle());setNumeroLicenceSpe(pSource.getNumeroLicenceSpe());setOrganisateurOccasionnelspe(pSource.getOrganisateurOccasionnelspe());setTitulaireLabelPresta(pSource.getTitulaireLabelPresta());setNumeroLabelPrestaSer(pSource.getNumeroLabelPrestaSer());setNumAffiCaisseConges(pSource.getNumAffiCaisseConges());setNomSalarie(pSource.getNomSalarie());setPrenomSalarie(pSource.getPrenomSalarie());setNomUsuel(pSource.getNomUsuel());setTelephoneSalarie(pSource.getTelephoneSalarie());setNIR(pSource.getNIR());setAdresseSalarie(pSource.getAdresseSalarie());setComplementAdresseSalarie(pSource.getComplementAdresseSalarie());setCodePostalSalarie(pSource.getCodePostalSalarie());setCommuneSalarie(pSource.getCommuneSalarie());setLienParente(pSource.getLienParente());setTypeLienParente(pSource.getTypeLienParente());setCodeEmploiOccupe(pSource.getCodeEmploiOccupe());setCodeQualification(pSource.getCodeQualification());setRegimeRetraiteCompl(pSource.getRegimeRetraiteCompl());setStatutCadre(pSource.getStatutCadre());setContratEnCours(pSource.getContratEnCours());setMotiFinContrat(pSource.getMotiFinContrat());setNomEmployeur(pSource.getNomEmployeur());setPrenomEmployeur(pSource.getPrenomEmployeur());setQualite(pSource.getQualite());setMotifRupture(pSource.getMotifRupture());setCommuneSignature(pSource.getCommuneSignature());setContactAEM(pSource.getContactAEM());setTelephoneTiers(pSource.getTelephoneTiers());setCodeOrganisme(pSource.getCodeOrganisme());setNbJoursTravailles(pSource.getNbJoursTravailles());setNumVersionAEM(pSource.getNumVersionAEM());setAffiCaisseConges(pSource.getAffiCaisseConges());setNumeroObjet(pSource.getNumeroObjet());setIndicateurHorsChamp(pSource.getIndicateurHorsChamp());setNouveauCodeApeNaf(pSource.getNouveauCodeApeNaf());setDateNaissance(pSource.getDateNaissance());setDateFincontrat(pSource.getDateFincontrat());setDateEmbauche(pSource.getDateEmbauche());setDateSignature(pSource.getDateSignature());setDateFichierExt(pSource.getDateFichierExt());setDateCreation(pSource.getDateCreation());setDateInitialeFinCDD(pSource.getDateInitialeFinCDD());setNbHeures(pSource.getNbHeures());setNbCachets(pSource.getNbCachets());setSalaireBrutAvtAbatt(pSource.getSalaireBrutAvtAbatt());setSalaireBrutAprAbatt(pSource.getSalaireBrutAprAbatt());setTauxAbatt(pSource.getTauxAbatt());setContributionDues(pSource.getContributionDues());setMoisActualisation(pSource.getMoisActualisation());setAnneeActualisation(pSource.getAnneeActualisation());setNbCachetsIsoles(pSource.getNbCachetsIsoles());setNbCachetsGroupes(pSource.getNbCachetsGroupes());setAutresRemunerationsMontantBrut(pSource.getAutresRemunerationsMontantBrut());setAutresRemunerationsTauxContributions(pSource.getAutresRemunerationsTauxContributions());setAutresRemunerationsContributionsDues(pSource.getAutresRemunerationsContributionsDues());setTotalContributionsDues(pSource.getTotalContributionsDues());setBneCertifSociale(pSource.getBneCertifSociale());setIdccEmployeur(pSource.getIdccEmployeur());setIdccPrestation(pSource.getIdccPrestation());setRessortissant(pSource.getRessortissant());setIndicateurCertifSociale(pSource.getIndicateurCertifSociale());setNumCertifSociale(pSource.getNumCertifSociale());
  }
  
  public String toString()
  {
    StringBuffer s = new StringBuffer("[_FluxAEM");
    subToString(s);
    s.append("]");
    return s.toString();
  }
  
  protected void subToString(StringBuffer pSource)
  {
    pSource.append(", BneSiret: ");
    pSource.append(m_bneSiret);
    pSource.append(", BNEEmployeur: ");
    pSource.append(m_bNEEmployeur);
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
    pSource.append(", CodeAction: ");
    pSource.append(m_codeAction);
    pSource.append(", IndicateurType: ");
    pSource.append(m_indicateurType);
    pSource.append(", NumeroInitial: ");
    pSource.append(m_numeroInitial);
    pSource.append(", Numero: ");
    pSource.append(m_numero);
    pSource.append(", SiretEmployeur: ");
    pSource.append(m_siretEmployeur);
    pSource.append(", CodeNafApe: ");
    pSource.append(m_codeNafApe);
    pSource.append(", NumAssedicAffiliation: ");
    pSource.append(m_numAssedicAffiliation);
    pSource.append(", NumeroAffiliation: ");
    pSource.append(m_numeroAffiliation);
    pSource.append(", RaisonSociale: ");
    pSource.append(m_raisonSociale);
    pSource.append(", AdresseEmployeur: ");
    pSource.append(m_adresseEmployeur);
    pSource.append(", ComplAdresseEmployeur: ");
    pSource.append(m_complAdresseEmployeur);
    pSource.append(", TelephoneEmployeur: ");
    pSource.append(m_telephoneEmployeur);
    pSource.append(", FaxEmployeur: ");
    pSource.append(m_faxEmployeur);
    pSource.append(", CourrielEmployeur: ");
    pSource.append(m_courrielEmployeur);
    pSource.append(", CodePostalEmployeur: ");
    pSource.append(m_codePostalEmployeur);
    pSource.append(", CommuneEmployeur: ");
    pSource.append(m_communeEmployeur);
    pSource.append(", FormeJuridique: ");
    pSource.append(m_formeJuridique);
    pSource.append(", ActiviteEmployeur: ");
    pSource.append(m_activiteEmployeur);
    pSource.append(", LicenceSpectacle: ");
    pSource.append(m_licenceSpectacle);
    pSource.append(", NumeroLicenceSpe: ");
    pSource.append(m_numeroLicenceSpe);
    pSource.append(", OrganisateurOccasionnelspe: ");
    pSource.append(m_organisateurOccasionnelspe);
    pSource.append(", TitulaireLabelPresta: ");
    pSource.append(m_titulaireLabelPresta);
    pSource.append(", NumeroLabelPrestaSer: ");
    pSource.append(m_numeroLabelPrestaSer);
    pSource.append(", NumAffiCaisseConges: ");
    pSource.append(m_numAffiCaisseConges);
    pSource.append(", NomSalarie: ");
    pSource.append(m_nomSalarie);
    pSource.append(", PrenomSalarie: ");
    pSource.append(m_prenomSalarie);
    pSource.append(", NomUsuel: ");
    pSource.append(m_nomUsuel);
    pSource.append(", TelephoneSalarie: ");
    pSource.append(m_telephoneSalarie);
    pSource.append(", NIR: ");
    pSource.append(m_NIR);
    pSource.append(", AdresseSalarie: ");
    pSource.append(m_adresseSalarie);
    pSource.append(", ComplementAdresseSalarie: ");
    pSource.append(m_complementAdresseSalarie);
    pSource.append(", CodePostalSalarie: ");
    pSource.append(m_codePostalSalarie);
    pSource.append(", CommuneSalarie: ");
    pSource.append(m_communeSalarie);
    pSource.append(", LienParente: ");
    pSource.append(m_lienParente);
    pSource.append(", TypeLienParente: ");
    pSource.append(m_typeLienParente);
    pSource.append(", CodeEmploiOccupe: ");
    pSource.append(m_codeEmploiOccupe);
    pSource.append(", CodeQualification: ");
    pSource.append(m_codeQualification);
    pSource.append(", RegimeRetraiteCompl: ");
    pSource.append(m_regimeRetraiteCompl);
    pSource.append(", StatutCadre: ");
    pSource.append(m_statutCadre);
    pSource.append(", ContratEnCours: ");
    pSource.append(m_contratEnCours);
    pSource.append(", MotiFinContrat: ");
    pSource.append(m_motiFinContrat);
    pSource.append(", NomEmployeur: ");
    pSource.append(m_nomEmployeur);
    pSource.append(", PrenomEmployeur: ");
    pSource.append(m_prenomEmployeur);
    pSource.append(", Qualite: ");
    pSource.append(m_qualite);
    pSource.append(", MotifRupture: ");
    pSource.append(m_motifRupture);
    pSource.append(", CommuneSignature: ");
    pSource.append(m_communeSignature);
    pSource.append(", ContactAEM: ");
    pSource.append(m_contactAEM);
    pSource.append(", TelephoneTiers: ");
    pSource.append(m_telephoneTiers);
    pSource.append(", CodeOrganisme: ");
    pSource.append(m_codeOrganisme);
    pSource.append(", NbJoursTravailles: ");
    pSource.append(m_nbJoursTravailles);
    pSource.append(", NumVersionAEM: ");
    pSource.append(m_numVersionAEM);
    pSource.append(", AffiCaisseConges: ");
    pSource.append(m_affiCaisseConges);
    pSource.append(", NumeroObjet: ");
    pSource.append(m_numeroObjet);
    pSource.append(", IndicateurHorsChamp: ");
    pSource.append(m_indicateurHorsChamp);
    pSource.append(", NouveauCodeApeNaf: ");
    pSource.append(m_nouveauCodeApeNaf);
    pSource.append(", DateNaissance: ");
    pSource.append(m_dateNaissance);
    pSource.append(", DateFincontrat: ");
    pSource.append(m_dateFincontrat);
    pSource.append(", DateEmbauche: ");
    pSource.append(m_dateEmbauche);
    pSource.append(", DateSignature: ");
    pSource.append(m_dateSignature);
    pSource.append(", DateFichierExt: ");
    pSource.append(m_dateFichierExt);
    pSource.append(", DateCreation: ");
    pSource.append(m_dateCreation);
    pSource.append(", DateInitialeFinCDD: ");
    pSource.append(m_dateInitialeFinCDD);
    pSource.append(", NbHeures: ");
    pSource.append(m_nbHeures);
    pSource.append(", NbCachets: ");
    pSource.append(m_nbCachets);
    pSource.append(", SalaireBrutAvtAbatt: ");
    pSource.append(m_salaireBrutAvtAbatt);
    pSource.append(", SalaireBrutAprAbatt: ");
    pSource.append(m_salaireBrutAprAbatt);
    pSource.append(", TauxAbatt: ");
    pSource.append(m_tauxAbatt);
    pSource.append(", ContributionDues: ");
    pSource.append(m_contributionDues);
    pSource.append(", MoisActualisation: ");
    pSource.append(m_moisActualisation);
    pSource.append(", AnneeActualisation: ");
    pSource.append(m_anneeActualisation);
    pSource.append(", NbCachetsIsoles: ");
    pSource.append(m_nbCachetsIsoles);
    pSource.append(", NbCachetsGroupes: ");
    pSource.append(m_nbCachetsGroupes);
    pSource.append(", AutresRemunerationsMontantBrut: ");
    pSource.append(m_autresRemunerationsMontantBrut);
    pSource.append(", AutresRemunerationsTauxContributions: ");
    pSource.append(m_autresRemunerationsTauxContributions);
    pSource.append(", AutresRemunerationsContributionsDues: ");
    pSource.append(m_autresRemunerationsContributionsDues);
    pSource.append(", TotalContributionsDues: ");
    pSource.append(m_totalContributionsDues);
    pSource.append(", BneCertifSociale: ");
    pSource.append(m_bneCertifSociale);
    pSource.append(", IdccEmployeur: ");
    pSource.append(m_idccEmployeur);
    pSource.append(", IdccPrestation: ");
    pSource.append(m_idccPrestation);
    pSource.append(", Ressortissant: ");
    pSource.append(m_ressortissant);
    pSource.append(", IndicateurCertifSociale: ");
    pSource.append(m_indicateurCertifSociale);
    pSource.append(", NumCertifSociale: ");
    pSource.append(m_numCertifSociale);
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
    pHandler.property("BneSiret", getBneSiret(), new Attribute[] { new StringAttribute("C_ERR", getBneSiret_C_ERR()) });
    
    pHandler.property("BNEEmployeur", getBNEEmployeur(), new Attribute[] { new StringAttribute("C_ERR", getBNEEmployeur_C_ERR()) });
    
    pHandler.property("BneRaisonSociale", getBneRaisonSociale(), new Attribute[] { new StringAttribute("C_ERR", getBneRaisonSociale_C_ERR()) });
    
    pHandler.property("BneNumeroVoirie", getBneNumeroVoirie(), new Attribute[] { new StringAttribute("C_ERR", getBneNumeroVoirie_C_ERR()) });
    
    pHandler.property("BneLibelleVoieAdresse", getBneLibelleVoieAdresse(), new Attribute[] { new StringAttribute("C_ERR", getBneLibelleVoieAdresse_C_ERR()) });
    
    pHandler.property("BneComplAdresse", getBneComplAdresse(), new Attribute[] { new StringAttribute("C_ERR", getBneComplAdresse_C_ERR()) });
    
    pHandler.property("BneCodePostal", getBneCodePostal(), new Attribute[] { new StringAttribute("C_ERR", getBneCodePostal_C_ERR()) });
    
    pHandler.property("BneLibelleCommune", getBneLibelleCommune(), new Attribute[] { new StringAttribute("C_ERR", getBneLibelleCommune_C_ERR()) });
    
    pHandler.property("BneAssedicAffiliation", getBneAssedicAffiliation(), new Attribute[] { new StringAttribute("C_ERR", getBneAssedicAffiliation_C_ERR()) });
    
    pHandler.property("BneNumAffiliation", getBneNumAffiliation(), new Attribute[] { new StringAttribute("C_ERR", getBneNumAffiliation_C_ERR()) });
    
    pHandler.property("CodeAction", getCodeAction(), new Attribute[] { new StringAttribute("C_ERR", getCodeAction_C_ERR()) });
    
    pHandler.property("IndicateurType", getIndicateurType(), new Attribute[] { new StringAttribute("C_ERR", getIndicateurType_C_ERR()) });
    
    pHandler.property("NumeroInitial", getNumeroInitial(), new Attribute[] { new StringAttribute("C_ERR", getNumeroInitial_C_ERR()) });
    
    pHandler.property("Numero", getNumero(), new Attribute[] { new StringAttribute("C_ERR", getNumero_C_ERR()) });
    
    pHandler.property("SiretEmployeur", getSiretEmployeur(), new Attribute[] { new StringAttribute("C_ERR", getSiretEmployeur_C_ERR()) });
    
    pHandler.property("CodeNafApe", getCodeNafApe(), new Attribute[] { new StringAttribute("C_ERR", getCodeNafApe_C_ERR()) });
    
    pHandler.property("NumAssedicAffiliation", getNumAssedicAffiliation(), new Attribute[] { new StringAttribute("C_ERR", getNumAssedicAffiliation_C_ERR()) });
    
    pHandler.property("NumeroAffiliation", getNumeroAffiliation(), new Attribute[] { new StringAttribute("C_ERR", getNumeroAffiliation_C_ERR()) });
    
    pHandler.property("RaisonSociale", getRaisonSociale(), new Attribute[] { new StringAttribute("C_ERR", getRaisonSociale_C_ERR()) });
    
    pHandler.property("AdresseEmployeur", getAdresseEmployeur(), new Attribute[] { new StringAttribute("C_ERR", getAdresseEmployeur_C_ERR()) });
    
    pHandler.property("ComplAdresseEmployeur", getComplAdresseEmployeur(), new Attribute[] { new StringAttribute("C_ERR", getComplAdresseEmployeur_C_ERR()) });
    
    pHandler.property("TelephoneEmployeur", getTelephoneEmployeur(), new Attribute[] { new StringAttribute("C_ERR", getTelephoneEmployeur_C_ERR()) });
    
    pHandler.property("FaxEmployeur", getFaxEmployeur(), new Attribute[] { new StringAttribute("C_ERR", getFaxEmployeur_C_ERR()) });
    
    pHandler.property("CourrielEmployeur", getCourrielEmployeur(), new Attribute[] { new StringAttribute("C_ERR", getCourrielEmployeur_C_ERR()) });
    
    pHandler.property("CodePostalEmployeur", getCodePostalEmployeur(), new Attribute[] { new StringAttribute("C_ERR", getCodePostalEmployeur_C_ERR()) });
    
    pHandler.property("CommuneEmployeur", getCommuneEmployeur(), new Attribute[] { new StringAttribute("C_ERR", getCommuneEmployeur_C_ERR()) });
    
    pHandler.property("FormeJuridique", getFormeJuridique(), new Attribute[] { new StringAttribute("C_ERR", getFormeJuridique_C_ERR()) });
    
    pHandler.property("ActiviteEmployeur", getActiviteEmployeur(), new Attribute[] { new StringAttribute("C_ERR", getActiviteEmployeur_C_ERR()) });
    
    pHandler.property("LicenceSpectacle", getLicenceSpectacle(), new Attribute[] { new StringAttribute("C_ERR", getLicenceSpectacle_C_ERR()) });
    
    pHandler.property("NumeroLicenceSpe", getNumeroLicenceSpe(), new Attribute[] { new StringAttribute("C_ERR", getNumeroLicenceSpe_C_ERR()) });
    
    pHandler.property("OrganisateurOccasionnelspe", getOrganisateurOccasionnelspe(), new Attribute[] { new StringAttribute("C_ERR", getOrganisateurOccasionnelspe_C_ERR()) });
    
    pHandler.property("TitulaireLabelPresta", getTitulaireLabelPresta(), new Attribute[] { new StringAttribute("C_ERR", getTitulaireLabelPresta_C_ERR()) });
    
    pHandler.property("NumeroLabelPrestaSer", getNumeroLabelPrestaSer(), new Attribute[] { new StringAttribute("C_ERR", getNumeroLabelPrestaSer_C_ERR()) });
    
    pHandler.property("NumAffiCaisseConges", getNumAffiCaisseConges(), new Attribute[] { new StringAttribute("C_ERR", getNumAffiCaisseConges_C_ERR()) });
    
    pHandler.property("NomSalarie", getNomSalarie(), new Attribute[] { new StringAttribute("C_ERR", getNomSalarie_C_ERR()) });
    
    pHandler.property("PrenomSalarie", getPrenomSalarie(), new Attribute[] { new StringAttribute("C_ERR", getPrenomSalarie_C_ERR()) });
    
    pHandler.property("NomUsuel", getNomUsuel(), new Attribute[] { new StringAttribute("C_ERR", getNomUsuel_C_ERR()) });
    
    pHandler.property("TelephoneSalarie", getTelephoneSalarie(), new Attribute[] { new StringAttribute("C_ERR", getTelephoneSalarie_C_ERR()) });
    
    pHandler.property("NIR", getNIR(), new Attribute[] { new StringAttribute("C_ERR", getNIR_C_ERR()) });
    
    pHandler.property("AdresseSalarie", getAdresseSalarie(), new Attribute[] { new StringAttribute("C_ERR", getAdresseSalarie_C_ERR()) });
    
    pHandler.property("ComplementAdresseSalarie", getComplementAdresseSalarie(), new Attribute[] { new StringAttribute("C_ERR", getComplementAdresseSalarie_C_ERR()) });
    
    pHandler.property("CodePostalSalarie", getCodePostalSalarie(), new Attribute[] { new StringAttribute("C_ERR", getCodePostalSalarie_C_ERR()) });
    
    pHandler.property("CommuneSalarie", getCommuneSalarie(), new Attribute[] { new StringAttribute("C_ERR", getCommuneSalarie_C_ERR()) });
    
    pHandler.property("LienParente", getLienParente(), new Attribute[] { new StringAttribute("C_ERR", getLienParente_C_ERR()) });
    
    pHandler.property("TypeLienParente", getTypeLienParente(), new Attribute[] { new StringAttribute("C_ERR", getTypeLienParente_C_ERR()) });
    
    pHandler.property("CodeEmploiOccupe", getCodeEmploiOccupe(), new Attribute[] { new StringAttribute("C_ERR", getCodeEmploiOccupe_C_ERR()) });
    
    pHandler.property("CodeQualification", getCodeQualification(), new Attribute[] { new StringAttribute("C_ERR", getCodeQualification_C_ERR()) });
    
    pHandler.property("RegimeRetraiteCompl", getRegimeRetraiteCompl(), new Attribute[] { new StringAttribute("C_ERR", getRegimeRetraiteCompl_C_ERR()) });
    
    pHandler.property("StatutCadre", getStatutCadre(), new Attribute[] { new StringAttribute("C_ERR", getStatutCadre_C_ERR()) });
    
    pHandler.property("ContratEnCours", getContratEnCours(), new Attribute[] { new StringAttribute("C_ERR", getContratEnCours_C_ERR()) });
    
    pHandler.property("MotiFinContrat", getMotiFinContrat(), new Attribute[] { new StringAttribute("C_ERR", getMotiFinContrat_C_ERR()) });
    
    pHandler.property("NomEmployeur", getNomEmployeur(), new Attribute[] { new StringAttribute("C_ERR", getNomEmployeur_C_ERR()) });
    
    pHandler.property("PrenomEmployeur", getPrenomEmployeur(), new Attribute[] { new StringAttribute("C_ERR", getPrenomEmployeur_C_ERR()) });
    
    pHandler.property("Qualite", getQualite(), new Attribute[] { new StringAttribute("C_ERR", getQualite_C_ERR()) });
    
    pHandler.property("MotifRupture", getMotifRupture(), new Attribute[] { new StringAttribute("C_ERR", getMotifRupture_C_ERR()) });
    
    pHandler.property("CommuneSignature", getCommuneSignature(), new Attribute[] { new StringAttribute("C_ERR", getCommuneSignature_C_ERR()) });
    
    pHandler.property("ContactAEM", getContactAEM(), new Attribute[] { new StringAttribute("C_ERR", getContactAEM_C_ERR()) });
    
    pHandler.property("TelephoneTiers", getTelephoneTiers(), new Attribute[] { new StringAttribute("C_ERR", getTelephoneTiers_C_ERR()) });
    
    pHandler.property("CodeOrganisme", getCodeOrganisme(), new Attribute[] { new StringAttribute("C_ERR", getCodeOrganisme_C_ERR()) });
    
    pHandler.property("NbJoursTravailles", getNbJoursTravailles(), new Attribute[] { new StringAttribute("C_ERR", getNbJoursTravailles_C_ERR()) });
    
    pHandler.property("NumVersionAEM", getNumVersionAEM(), new Attribute[] { new StringAttribute("C_ERR", getNumVersionAEM_C_ERR()) });
    
    pHandler.property("AffiCaisseConges", getAffiCaisseConges(), new Attribute[] { new StringAttribute("C_ERR", getAffiCaisseConges_C_ERR()) });
    
    pHandler.property("NumeroObjet", getNumeroObjet(), new Attribute[] { new StringAttribute("C_ERR", getNumeroObjet_C_ERR()) });
    
    pHandler.property("IndicateurHorsChamp", getIndicateurHorsChamp(), new Attribute[] { new StringAttribute("C_ERR", getIndicateurHorsChamp_C_ERR()) });
    
    pHandler.property("NouveauCodeApeNaf", getNouveauCodeApeNaf(), new Attribute[] { new StringAttribute("C_ERR", getNouveauCodeApeNaf_C_ERR()) });
    
    pHandler.property("DateNaissance", getDateNaissance(), new Attribute[] { new StringAttribute("C_ERR", getDateNaissance_C_ERR()) });
    
    pHandler.property("DateFincontrat", getDateFincontrat(), new Attribute[] { new StringAttribute("C_ERR", getDateFincontrat_C_ERR()) });
    
    pHandler.property("DateEmbauche", getDateEmbauche(), new Attribute[] { new StringAttribute("C_ERR", getDateEmbauche_C_ERR()) });
    
    pHandler.property("DateSignature", getDateSignature(), new Attribute[] { new StringAttribute("C_ERR", getDateSignature_C_ERR()) });
    
    pHandler.property("DateFichierExt", getDateFichierExt(), new Attribute[] { new StringAttribute("C_ERR", getDateFichierExt_C_ERR()) });
    
    pHandler.property("DateCreation", getDateCreation(), new Attribute[] { new StringAttribute("C_ERR", getDateCreation_C_ERR()) });
    
    pHandler.property("DateInitialeFinCDD", getDateInitialeFinCDD(), new Attribute[] { new StringAttribute("C_ERR", getDateInitialeFinCDD_C_ERR()) });
    
    pHandler.property("NbHeures", getNbHeures(), new Attribute[] { new StringAttribute("C_ERR", getNbHeures_C_ERR()) });
    
    pHandler.property("NbCachets", getNbCachets(), new Attribute[] { new StringAttribute("C_ERR", getNbCachets_C_ERR()) });
    
    pHandler.property("SalaireBrutAvtAbatt", getSalaireBrutAvtAbatt(), new Attribute[] { new StringAttribute("C_ERR", getSalaireBrutAvtAbatt_C_ERR()) });
    
    pHandler.property("SalaireBrutAprAbatt", getSalaireBrutAprAbatt(), new Attribute[] { new StringAttribute("C_ERR", getSalaireBrutAprAbatt_C_ERR()) });
    
    pHandler.property("TauxAbatt", getTauxAbatt(), new Attribute[] { new StringAttribute("C_ERR", getTauxAbatt_C_ERR()) });
    
    pHandler.property("ContributionDues", getContributionDues(), new Attribute[] { new StringAttribute("C_ERR", getContributionDues_C_ERR()) });
    
    pHandler.property("MoisActualisation", getMoisActualisation(), new Attribute[] { new StringAttribute("C_ERR", getMoisActualisation_C_ERR()) });
    
    pHandler.property("AnneeActualisation", getAnneeActualisation(), new Attribute[] { new StringAttribute("C_ERR", getAnneeActualisation_C_ERR()) });
    
    pHandler.property("NbCachetsIsoles", getNbCachetsIsoles(), new Attribute[] { new StringAttribute("C_ERR", getNbCachetsIsoles_C_ERR()) });
    
    pHandler.property("NbCachetsGroupes", getNbCachetsGroupes(), new Attribute[] { new StringAttribute("C_ERR", getNbCachetsGroupes_C_ERR()) });
    
    pHandler.property("AutresRemunerationsMontantBrut", getAutresRemunerationsMontantBrut(), new Attribute[] { new StringAttribute("C_ERR", getAutresRemunerationsMontantBrut_C_ERR()) });
    
    pHandler.property("AutresRemunerationsTauxContributions", getAutresRemunerationsTauxContributions(), new Attribute[] { new StringAttribute("C_ERR", getAutresRemunerationsTauxContributions_C_ERR()) });
    
    pHandler.property("AutresRemunerationsContributionsDues", getAutresRemunerationsContributionsDues(), new Attribute[] { new StringAttribute("C_ERR", getAutresRemunerationsContributionsDues_C_ERR()) });
    
    pHandler.property("TotalContributionsDues", getTotalContributionsDues(), new Attribute[] { new StringAttribute("C_ERR", getTotalContributionsDues_C_ERR()) });
    
    pHandler.property("BneCertifSociale", getBneCertifSociale(), new Attribute[] { new StringAttribute("C_ERR", getBneCertifSociale_C_ERR()) });
    
    pHandler.property("IdccEmployeur", getIdccEmployeur(), new Attribute[] { new StringAttribute("C_ERR", getIdccEmployeur_C_ERR()) });
    
    pHandler.property("IdccPrestation", getIdccPrestation(), new Attribute[] { new StringAttribute("C_ERR", getIdccPrestation_C_ERR()) });
    
    pHandler.property("Ressortissant", getRessortissant(), new Attribute[] { new StringAttribute("C_ERR", getRessortissant_C_ERR()) });
    
    pHandler.property("IndicateurCertifSociale", getIndicateurCertifSociale(), new Attribute[] { new StringAttribute("C_ERR", getIndicateurCertifSociale_C_ERR()) });
    
    pHandler.property("NumCertifSociale", getNumCertifSociale(), new Attribute[] { new StringAttribute("C_ERR", getNumCertifSociale_C_ERR()) });
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
    setBneSiret((String)pHandler.objectProperty("BneSiret", String.class));
    setBneSiret_C_ERR(pHandler.stringAttribute("BneSiret", "C_ERR"));
    
    setBNEEmployeur((String)pHandler.objectProperty("BNEEmployeur", String.class));
    setBNEEmployeur_C_ERR(pHandler.stringAttribute("BNEEmployeur", "C_ERR"));
    
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
    
    setCodeAction((String)pHandler.objectProperty("CodeAction", String.class));
    setCodeAction_C_ERR(pHandler.stringAttribute("CodeAction", "C_ERR"));
    
    setIndicateurType((String)pHandler.objectProperty("IndicateurType", String.class));
    setIndicateurType_C_ERR(pHandler.stringAttribute("IndicateurType", "C_ERR"));
    
    setNumeroInitial((String)pHandler.objectProperty("NumeroInitial", String.class));
    setNumeroInitial_C_ERR(pHandler.stringAttribute("NumeroInitial", "C_ERR"));
    
    setNumero((String)pHandler.objectProperty("Numero", String.class));
    setNumero_C_ERR(pHandler.stringAttribute("Numero", "C_ERR"));
    
    setSiretEmployeur((String)pHandler.objectProperty("SiretEmployeur", String.class));
    setSiretEmployeur_C_ERR(pHandler.stringAttribute("SiretEmployeur", "C_ERR"));
    
    setCodeNafApe((String)pHandler.objectProperty("CodeNafApe", String.class));
    setCodeNafApe_C_ERR(pHandler.stringAttribute("CodeNafApe", "C_ERR"));
    
    setNumAssedicAffiliation((String)pHandler.objectProperty("NumAssedicAffiliation", String.class));
    setNumAssedicAffiliation_C_ERR(pHandler.stringAttribute("NumAssedicAffiliation", "C_ERR"));
    
    setNumeroAffiliation((String)pHandler.objectProperty("NumeroAffiliation", String.class));
    setNumeroAffiliation_C_ERR(pHandler.stringAttribute("NumeroAffiliation", "C_ERR"));
    
    setRaisonSociale((String)pHandler.objectProperty("RaisonSociale", String.class));
    setRaisonSociale_C_ERR(pHandler.stringAttribute("RaisonSociale", "C_ERR"));
    
    setAdresseEmployeur((String)pHandler.objectProperty("AdresseEmployeur", String.class));
    setAdresseEmployeur_C_ERR(pHandler.stringAttribute("AdresseEmployeur", "C_ERR"));
    
    setComplAdresseEmployeur((String)pHandler.objectProperty("ComplAdresseEmployeur", String.class));
    setComplAdresseEmployeur_C_ERR(pHandler.stringAttribute("ComplAdresseEmployeur", "C_ERR"));
    
    setTelephoneEmployeur((String)pHandler.objectProperty("TelephoneEmployeur", String.class));
    setTelephoneEmployeur_C_ERR(pHandler.stringAttribute("TelephoneEmployeur", "C_ERR"));
    
    setFaxEmployeur((String)pHandler.objectProperty("FaxEmployeur", String.class));
    setFaxEmployeur_C_ERR(pHandler.stringAttribute("FaxEmployeur", "C_ERR"));
    
    setCourrielEmployeur((String)pHandler.objectProperty("CourrielEmployeur", String.class));
    setCourrielEmployeur_C_ERR(pHandler.stringAttribute("CourrielEmployeur", "C_ERR"));
    
    setCodePostalEmployeur((String)pHandler.objectProperty("CodePostalEmployeur", String.class));
    setCodePostalEmployeur_C_ERR(pHandler.stringAttribute("CodePostalEmployeur", "C_ERR"));
    
    setCommuneEmployeur((String)pHandler.objectProperty("CommuneEmployeur", String.class));
    setCommuneEmployeur_C_ERR(pHandler.stringAttribute("CommuneEmployeur", "C_ERR"));
    
    setFormeJuridique((String)pHandler.objectProperty("FormeJuridique", String.class));
    setFormeJuridique_C_ERR(pHandler.stringAttribute("FormeJuridique", "C_ERR"));
    
    setActiviteEmployeur((String)pHandler.objectProperty("ActiviteEmployeur", String.class));
    setActiviteEmployeur_C_ERR(pHandler.stringAttribute("ActiviteEmployeur", "C_ERR"));
    
    setLicenceSpectacle((String)pHandler.objectProperty("LicenceSpectacle", String.class));
    setLicenceSpectacle_C_ERR(pHandler.stringAttribute("LicenceSpectacle", "C_ERR"));
    
    setNumeroLicenceSpe((String)pHandler.objectProperty("NumeroLicenceSpe", String.class));
    setNumeroLicenceSpe_C_ERR(pHandler.stringAttribute("NumeroLicenceSpe", "C_ERR"));
    
    setOrganisateurOccasionnelspe((String)pHandler.objectProperty("OrganisateurOccasionnelspe", String.class));
    setOrganisateurOccasionnelspe_C_ERR(pHandler.stringAttribute("OrganisateurOccasionnelspe", "C_ERR"));
    
    setTitulaireLabelPresta((String)pHandler.objectProperty("TitulaireLabelPresta", String.class));
    setTitulaireLabelPresta_C_ERR(pHandler.stringAttribute("TitulaireLabelPresta", "C_ERR"));
    
    setNumeroLabelPrestaSer((String)pHandler.objectProperty("NumeroLabelPrestaSer", String.class));
    setNumeroLabelPrestaSer_C_ERR(pHandler.stringAttribute("NumeroLabelPrestaSer", "C_ERR"));
    
    setNumAffiCaisseConges((String)pHandler.objectProperty("NumAffiCaisseConges", String.class));
    setNumAffiCaisseConges_C_ERR(pHandler.stringAttribute("NumAffiCaisseConges", "C_ERR"));
    
    setNomSalarie((String)pHandler.objectProperty("NomSalarie", String.class));
    setNomSalarie_C_ERR(pHandler.stringAttribute("NomSalarie", "C_ERR"));
    
    setPrenomSalarie((String)pHandler.objectProperty("PrenomSalarie", String.class));
    setPrenomSalarie_C_ERR(pHandler.stringAttribute("PrenomSalarie", "C_ERR"));
    
    setNomUsuel((String)pHandler.objectProperty("NomUsuel", String.class));
    setNomUsuel_C_ERR(pHandler.stringAttribute("NomUsuel", "C_ERR"));
    
    setTelephoneSalarie((String)pHandler.objectProperty("TelephoneSalarie", String.class));
    setTelephoneSalarie_C_ERR(pHandler.stringAttribute("TelephoneSalarie", "C_ERR"));
    
    setNIR((String)pHandler.objectProperty("NIR", String.class));
    setNIR_C_ERR(pHandler.stringAttribute("NIR", "C_ERR"));
    
    setAdresseSalarie((String)pHandler.objectProperty("AdresseSalarie", String.class));
    setAdresseSalarie_C_ERR(pHandler.stringAttribute("AdresseSalarie", "C_ERR"));
    
    setComplementAdresseSalarie((String)pHandler.objectProperty("ComplementAdresseSalarie", String.class));
    setComplementAdresseSalarie_C_ERR(pHandler.stringAttribute("ComplementAdresseSalarie", "C_ERR"));
    
    setCodePostalSalarie((String)pHandler.objectProperty("CodePostalSalarie", String.class));
    setCodePostalSalarie_C_ERR(pHandler.stringAttribute("CodePostalSalarie", "C_ERR"));
    
    setCommuneSalarie((String)pHandler.objectProperty("CommuneSalarie", String.class));
    setCommuneSalarie_C_ERR(pHandler.stringAttribute("CommuneSalarie", "C_ERR"));
    
    setLienParente((String)pHandler.objectProperty("LienParente", String.class));
    setLienParente_C_ERR(pHandler.stringAttribute("LienParente", "C_ERR"));
    
    setTypeLienParente((String)pHandler.objectProperty("TypeLienParente", String.class));
    setTypeLienParente_C_ERR(pHandler.stringAttribute("TypeLienParente", "C_ERR"));
    
    setCodeEmploiOccupe((String)pHandler.objectProperty("CodeEmploiOccupe", String.class));
    setCodeEmploiOccupe_C_ERR(pHandler.stringAttribute("CodeEmploiOccupe", "C_ERR"));
    
    setCodeQualification((String)pHandler.objectProperty("CodeQualification", String.class));
    setCodeQualification_C_ERR(pHandler.stringAttribute("CodeQualification", "C_ERR"));
    
    setRegimeRetraiteCompl((String)pHandler.objectProperty("RegimeRetraiteCompl", String.class));
    setRegimeRetraiteCompl_C_ERR(pHandler.stringAttribute("RegimeRetraiteCompl", "C_ERR"));
    
    setStatutCadre((String)pHandler.objectProperty("StatutCadre", String.class));
    setStatutCadre_C_ERR(pHandler.stringAttribute("StatutCadre", "C_ERR"));
    
    setContratEnCours((String)pHandler.objectProperty("ContratEnCours", String.class));
    setContratEnCours_C_ERR(pHandler.stringAttribute("ContratEnCours", "C_ERR"));
    
    setMotiFinContrat((String)pHandler.objectProperty("MotiFinContrat", String.class));
    setMotiFinContrat_C_ERR(pHandler.stringAttribute("MotiFinContrat", "C_ERR"));
    
    setNomEmployeur((String)pHandler.objectProperty("NomEmployeur", String.class));
    setNomEmployeur_C_ERR(pHandler.stringAttribute("NomEmployeur", "C_ERR"));
    
    setPrenomEmployeur((String)pHandler.objectProperty("PrenomEmployeur", String.class));
    setPrenomEmployeur_C_ERR(pHandler.stringAttribute("PrenomEmployeur", "C_ERR"));
    
    setQualite((String)pHandler.objectProperty("Qualite", String.class));
    setQualite_C_ERR(pHandler.stringAttribute("Qualite", "C_ERR"));
    
    setMotifRupture((String)pHandler.objectProperty("MotifRupture", String.class));
    setMotifRupture_C_ERR(pHandler.stringAttribute("MotifRupture", "C_ERR"));
    
    setCommuneSignature((String)pHandler.objectProperty("CommuneSignature", String.class));
    setCommuneSignature_C_ERR(pHandler.stringAttribute("CommuneSignature", "C_ERR"));
    
    setContactAEM((String)pHandler.objectProperty("ContactAEM", String.class));
    setContactAEM_C_ERR(pHandler.stringAttribute("ContactAEM", "C_ERR"));
    
    setTelephoneTiers((String)pHandler.objectProperty("TelephoneTiers", String.class));
    setTelephoneTiers_C_ERR(pHandler.stringAttribute("TelephoneTiers", "C_ERR"));
    
    setCodeOrganisme((String)pHandler.objectProperty("CodeOrganisme", String.class));
    setCodeOrganisme_C_ERR(pHandler.stringAttribute("CodeOrganisme", "C_ERR"));
    
    setNbJoursTravailles((String)pHandler.objectProperty("NbJoursTravailles", String.class));
    setNbJoursTravailles_C_ERR(pHandler.stringAttribute("NbJoursTravailles", "C_ERR"));
    
    setNumVersionAEM((String)pHandler.objectProperty("NumVersionAEM", String.class));
    setNumVersionAEM_C_ERR(pHandler.stringAttribute("NumVersionAEM", "C_ERR"));
    
    setAffiCaisseConges((String)pHandler.objectProperty("AffiCaisseConges", String.class));
    setAffiCaisseConges_C_ERR(pHandler.stringAttribute("AffiCaisseConges", "C_ERR"));
    
    setNumeroObjet((String)pHandler.objectProperty("NumeroObjet", String.class));
    setNumeroObjet_C_ERR(pHandler.stringAttribute("NumeroObjet", "C_ERR"));
    
    setIndicateurHorsChamp((String)pHandler.objectProperty("IndicateurHorsChamp", String.class));
    setIndicateurHorsChamp_C_ERR(pHandler.stringAttribute("IndicateurHorsChamp", "C_ERR"));
    
    setNouveauCodeApeNaf((String)pHandler.objectProperty("NouveauCodeApeNaf", String.class));
    setNouveauCodeApeNaf_C_ERR(pHandler.stringAttribute("NouveauCodeApeNaf", "C_ERR"));
    
    setDateNaissance((Damj)pHandler.objectProperty("DateNaissance", Damj.class));
    setDateNaissance_C_ERR(pHandler.stringAttribute("DateNaissance", "C_ERR"));
    
    setDateFincontrat((Damj)pHandler.objectProperty("DateFincontrat", Damj.class));
    setDateFincontrat_C_ERR(pHandler.stringAttribute("DateFincontrat", "C_ERR"));
    
    setDateEmbauche((Damj)pHandler.objectProperty("DateEmbauche", Damj.class));
    setDateEmbauche_C_ERR(pHandler.stringAttribute("DateEmbauche", "C_ERR"));
    
    setDateSignature((Damj)pHandler.objectProperty("DateSignature", Damj.class));
    setDateSignature_C_ERR(pHandler.stringAttribute("DateSignature", "C_ERR"));
    
    setDateFichierExt((Damj)pHandler.objectProperty("DateFichierExt", Damj.class));
    setDateFichierExt_C_ERR(pHandler.stringAttribute("DateFichierExt", "C_ERR"));
    
    setDateCreation((Damj)pHandler.objectProperty("DateCreation", Damj.class));
    setDateCreation_C_ERR(pHandler.stringAttribute("DateCreation", "C_ERR"));
    
    setDateInitialeFinCDD((Damj)pHandler.objectProperty("DateInitialeFinCDD", Damj.class));
    setDateInitialeFinCDD_C_ERR(pHandler.stringAttribute("DateInitialeFinCDD", "C_ERR"));
    
    setNbHeures((BigDecimal)pHandler.objectProperty("NbHeures", BigDecimal.class));
    setNbHeures_C_ERR(pHandler.stringAttribute("NbHeures", "C_ERR"));
    
    setNbCachets((BigDecimal)pHandler.objectProperty("NbCachets", BigDecimal.class));
    setNbCachets_C_ERR(pHandler.stringAttribute("NbCachets", "C_ERR"));
    
    setSalaireBrutAvtAbatt((BigDecimal)pHandler.objectProperty("SalaireBrutAvtAbatt", BigDecimal.class));
    setSalaireBrutAvtAbatt_C_ERR(pHandler.stringAttribute("SalaireBrutAvtAbatt", "C_ERR"));
    
    setSalaireBrutAprAbatt((BigDecimal)pHandler.objectProperty("SalaireBrutAprAbatt", BigDecimal.class));
    setSalaireBrutAprAbatt_C_ERR(pHandler.stringAttribute("SalaireBrutAprAbatt", "C_ERR"));
    
    setTauxAbatt((BigDecimal)pHandler.objectProperty("TauxAbatt", BigDecimal.class));
    setTauxAbatt_C_ERR(pHandler.stringAttribute("TauxAbatt", "C_ERR"));
    
    setContributionDues((BigDecimal)pHandler.objectProperty("ContributionDues", BigDecimal.class));
    setContributionDues_C_ERR(pHandler.stringAttribute("ContributionDues", "C_ERR"));
    
    setMoisActualisation((BigDecimal)pHandler.objectProperty("MoisActualisation", BigDecimal.class));
    setMoisActualisation_C_ERR(pHandler.stringAttribute("MoisActualisation", "C_ERR"));
    
    setAnneeActualisation((BigDecimal)pHandler.objectProperty("AnneeActualisation", BigDecimal.class));
    setAnneeActualisation_C_ERR(pHandler.stringAttribute("AnneeActualisation", "C_ERR"));
    
    setNbCachetsIsoles((BigDecimal)pHandler.objectProperty("NbCachetsIsoles", BigDecimal.class));
    setNbCachetsIsoles_C_ERR(pHandler.stringAttribute("NbCachetsIsoles", "C_ERR"));
    
    setNbCachetsGroupes((BigDecimal)pHandler.objectProperty("NbCachetsGroupes", BigDecimal.class));
    setNbCachetsGroupes_C_ERR(pHandler.stringAttribute("NbCachetsGroupes", "C_ERR"));
    
    setAutresRemunerationsMontantBrut((BigDecimal)pHandler.objectProperty("AutresRemunerationsMontantBrut", BigDecimal.class));
    setAutresRemunerationsMontantBrut_C_ERR(pHandler.stringAttribute("AutresRemunerationsMontantBrut", "C_ERR"));
    
    setAutresRemunerationsTauxContributions((BigDecimal)pHandler.objectProperty("AutresRemunerationsTauxContributions", BigDecimal.class));
    setAutresRemunerationsTauxContributions_C_ERR(pHandler.stringAttribute("AutresRemunerationsTauxContributions", "C_ERR"));
    
    setAutresRemunerationsContributionsDues((BigDecimal)pHandler.objectProperty("AutresRemunerationsContributionsDues", BigDecimal.class));
    setAutresRemunerationsContributionsDues_C_ERR(pHandler.stringAttribute("AutresRemunerationsContributionsDues", "C_ERR"));
    
    setTotalContributionsDues((BigDecimal)pHandler.objectProperty("TotalContributionsDues", BigDecimal.class));
    setTotalContributionsDues_C_ERR(pHandler.stringAttribute("TotalContributionsDues", "C_ERR"));
    
    setBneCertifSociale((String)pHandler.objectProperty("BneCertifSociale", String.class));
    setBneCertifSociale_C_ERR(pHandler.stringAttribute("BneCertifSociale", "C_ERR"));
    
    setIdccEmployeur((String)pHandler.objectProperty("IdccEmployeur", String.class));
    setIdccEmployeur_C_ERR(pHandler.stringAttribute("IdccEmployeur", "C_ERR"));
    
    setIdccPrestation((String)pHandler.objectProperty("IdccPrestation", String.class));
    setIdccPrestation_C_ERR(pHandler.stringAttribute("IdccPrestation", "C_ERR"));
    
    setRessortissant((String)pHandler.objectProperty("Ressortissant", String.class));
    setRessortissant_C_ERR(pHandler.stringAttribute("Ressortissant", "C_ERR"));
    
    setIndicateurCertifSociale((String)pHandler.objectProperty("IndicateurCertifSociale", String.class));
    setIndicateurCertifSociale_C_ERR(pHandler.stringAttribute("IndicateurCertifSociale", "C_ERR"));
    
    setNumCertifSociale((String)pHandler.objectProperty("NumCertifSociale", String.class));
    setNumCertifSociale_C_ERR(pHandler.stringAttribute("NumCertifSociale", "C_ERR"));
  }
  
  public String _getDatabeanName()
  {
    return "FluxAEM";
  }
  
  public boolean _isValidProperty(String pElementName)
  {
    if ("BneSiret".equals(pElementName)) {
      return true;
    }
    if ("BNEEmployeur".equals(pElementName)) {
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
    if ("CodeAction".equals(pElementName)) {
      return true;
    }
    if ("IndicateurType".equals(pElementName)) {
      return true;
    }
    if ("NumeroInitial".equals(pElementName)) {
      return true;
    }
    if ("Numero".equals(pElementName)) {
      return true;
    }
    if ("SiretEmployeur".equals(pElementName)) {
      return true;
    }
    if ("CodeNafApe".equals(pElementName)) {
      return true;
    }
    if ("NumAssedicAffiliation".equals(pElementName)) {
      return true;
    }
    if ("NumeroAffiliation".equals(pElementName)) {
      return true;
    }
    if ("RaisonSociale".equals(pElementName)) {
      return true;
    }
    if ("AdresseEmployeur".equals(pElementName)) {
      return true;
    }
    if ("ComplAdresseEmployeur".equals(pElementName)) {
      return true;
    }
    if ("TelephoneEmployeur".equals(pElementName)) {
      return true;
    }
    if ("FaxEmployeur".equals(pElementName)) {
      return true;
    }
    if ("CourrielEmployeur".equals(pElementName)) {
      return true;
    }
    if ("CodePostalEmployeur".equals(pElementName)) {
      return true;
    }
    if ("CommuneEmployeur".equals(pElementName)) {
      return true;
    }
    if ("FormeJuridique".equals(pElementName)) {
      return true;
    }
    if ("ActiviteEmployeur".equals(pElementName)) {
      return true;
    }
    if ("LicenceSpectacle".equals(pElementName)) {
      return true;
    }
    if ("NumeroLicenceSpe".equals(pElementName)) {
      return true;
    }
    if ("OrganisateurOccasionnelspe".equals(pElementName)) {
      return true;
    }
    if ("TitulaireLabelPresta".equals(pElementName)) {
      return true;
    }
    if ("NumeroLabelPrestaSer".equals(pElementName)) {
      return true;
    }
    if ("NumAffiCaisseConges".equals(pElementName)) {
      return true;
    }
    if ("NomSalarie".equals(pElementName)) {
      return true;
    }
    if ("PrenomSalarie".equals(pElementName)) {
      return true;
    }
    if ("NomUsuel".equals(pElementName)) {
      return true;
    }
    if ("TelephoneSalarie".equals(pElementName)) {
      return true;
    }
    if ("NIR".equals(pElementName)) {
      return true;
    }
    if ("AdresseSalarie".equals(pElementName)) {
      return true;
    }
    if ("ComplementAdresseSalarie".equals(pElementName)) {
      return true;
    }
    if ("CodePostalSalarie".equals(pElementName)) {
      return true;
    }
    if ("CommuneSalarie".equals(pElementName)) {
      return true;
    }
    if ("LienParente".equals(pElementName)) {
      return true;
    }
    if ("TypeLienParente".equals(pElementName)) {
      return true;
    }
    if ("CodeEmploiOccupe".equals(pElementName)) {
      return true;
    }
    if ("CodeQualification".equals(pElementName)) {
      return true;
    }
    if ("RegimeRetraiteCompl".equals(pElementName)) {
      return true;
    }
    if ("StatutCadre".equals(pElementName)) {
      return true;
    }
    if ("ContratEnCours".equals(pElementName)) {
      return true;
    }
    if ("MotiFinContrat".equals(pElementName)) {
      return true;
    }
    if ("NomEmployeur".equals(pElementName)) {
      return true;
    }
    if ("PrenomEmployeur".equals(pElementName)) {
      return true;
    }
    if ("Qualite".equals(pElementName)) {
      return true;
    }
    if ("MotifRupture".equals(pElementName)) {
      return true;
    }
    if ("CommuneSignature".equals(pElementName)) {
      return true;
    }
    if ("ContactAEM".equals(pElementName)) {
      return true;
    }
    if ("TelephoneTiers".equals(pElementName)) {
      return true;
    }
    if ("CodeOrganisme".equals(pElementName)) {
      return true;
    }
    if ("NbJoursTravailles".equals(pElementName)) {
      return true;
    }
    if ("NumVersionAEM".equals(pElementName)) {
      return true;
    }
    if ("AffiCaisseConges".equals(pElementName)) {
      return true;
    }
    if ("NumeroObjet".equals(pElementName)) {
      return true;
    }
    if ("IndicateurHorsChamp".equals(pElementName)) {
      return true;
    }
    if ("NouveauCodeApeNaf".equals(pElementName)) {
      return true;
    }
    if ("DateNaissance".equals(pElementName)) {
      return true;
    }
    if ("DateFincontrat".equals(pElementName)) {
      return true;
    }
    if ("DateEmbauche".equals(pElementName)) {
      return true;
    }
    if ("DateSignature".equals(pElementName)) {
      return true;
    }
    if ("DateFichierExt".equals(pElementName)) {
      return true;
    }
    if ("DateCreation".equals(pElementName)) {
      return true;
    }
    if ("DateInitialeFinCDD".equals(pElementName)) {
      return true;
    }
    if ("NbHeures".equals(pElementName)) {
      return true;
    }
    if ("NbCachets".equals(pElementName)) {
      return true;
    }
    if ("SalaireBrutAvtAbatt".equals(pElementName)) {
      return true;
    }
    if ("SalaireBrutAprAbatt".equals(pElementName)) {
      return true;
    }
    if ("TauxAbatt".equals(pElementName)) {
      return true;
    }
    if ("ContributionDues".equals(pElementName)) {
      return true;
    }
    if ("MoisActualisation".equals(pElementName)) {
      return true;
    }
    if ("AnneeActualisation".equals(pElementName)) {
      return true;
    }
    if ("NbCachetsIsoles".equals(pElementName)) {
      return true;
    }
    if ("NbCachetsGroupes".equals(pElementName)) {
      return true;
    }
    if ("AutresRemunerationsMontantBrut".equals(pElementName)) {
      return true;
    }
    if ("AutresRemunerationsTauxContributions".equals(pElementName)) {
      return true;
    }
    if ("AutresRemunerationsContributionsDues".equals(pElementName)) {
      return true;
    }
    if ("TotalContributionsDues".equals(pElementName)) {
      return true;
    }
    if ("BneCertifSociale".equals(pElementName)) {
      return true;
    }
    if ("IdccEmployeur".equals(pElementName)) {
      return true;
    }
    if ("IdccPrestation".equals(pElementName)) {
      return true;
    }
    if ("Ressortissant".equals(pElementName)) {
      return true;
    }
    if ("IndicateurCertifSociale".equals(pElementName)) {
      return true;
    }
    if ("NumCertifSociale".equals(pElementName)) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _FluxAEM
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */