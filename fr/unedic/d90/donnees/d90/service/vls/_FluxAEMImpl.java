package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import fr.unedic.util.temps.Damj;
import java.io.Serializable;
import java.math.BigDecimal;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _FluxAEMImpl
  extends FluxAEM
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _FluxAEM m_fluxAEMInfra;
  
  public _FluxAEMImpl()
  {
    m_fluxAEMInfra = new _FluxAEM();
  }
  
  public _FluxAEMImpl(_FluxAEM pValeur)
  {
    ExceptionUtil.assertMethodParamNotNull("FluxAEMInfra", pValeur);
    
    m_fluxAEMInfra = pValeur;
  }
  
  public Object getObjet()
  {
    return m_fluxAEMInfra;
  }
  
  public String getIdentifiant()
  {
    return m_fluxAEMInfra.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_fluxAEMInfra.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_fluxAEMInfra.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_fluxAEMInfra.set_C_ETAT(pCode);
  }
  
  public String getBneSiret()
  {
    return m_fluxAEMInfra.getBneSiret();
  }
  
  public String getCodeErreurBneSiret()
  {
    return m_fluxAEMInfra.getBneSiret_C_ERR();
  }
  
  public void setBneSiret(String pValeur)
  {
    m_fluxAEMInfra.setBneSiret(pValeur);
  }
  
  public void setCodeErreurBneSiret(String pCodeErreur)
  {
    m_fluxAEMInfra.setBneSiret_C_ERR(pCodeErreur);
  }
  
  public String getBNEEmployeur()
  {
    return m_fluxAEMInfra.getBNEEmployeur();
  }
  
  public String getCodeErreurBNEEmployeur()
  {
    return m_fluxAEMInfra.getBNEEmployeur_C_ERR();
  }
  
  public void setBNEEmployeur(String pValeur)
  {
    m_fluxAEMInfra.setBNEEmployeur(pValeur);
  }
  
  public void setCodeErreurBNEEmployeur(String pCodeErreur)
  {
    m_fluxAEMInfra.setBNEEmployeur_C_ERR(pCodeErreur);
  }
  
  public String getBneRaisonSociale()
  {
    return m_fluxAEMInfra.getBneRaisonSociale();
  }
  
  public String getCodeErreurBneRaisonSociale()
  {
    return m_fluxAEMInfra.getBneRaisonSociale_C_ERR();
  }
  
  public void setBneRaisonSociale(String pValeur)
  {
    m_fluxAEMInfra.setBneRaisonSociale(pValeur);
  }
  
  public void setCodeErreurBneRaisonSociale(String pCodeErreur)
  {
    m_fluxAEMInfra.setBneRaisonSociale_C_ERR(pCodeErreur);
  }
  
  public String getBneNumeroVoirie()
  {
    return m_fluxAEMInfra.getBneNumeroVoirie();
  }
  
  public String getCodeErreurBneNumeroVoirie()
  {
    return m_fluxAEMInfra.getBneNumeroVoirie_C_ERR();
  }
  
  public void setBneNumeroVoirie(String pValeur)
  {
    m_fluxAEMInfra.setBneNumeroVoirie(pValeur);
  }
  
  public void setCodeErreurBneNumeroVoirie(String pCodeErreur)
  {
    m_fluxAEMInfra.setBneNumeroVoirie_C_ERR(pCodeErreur);
  }
  
  public String getBneLibelleVoieAdresse()
  {
    return m_fluxAEMInfra.getBneLibelleVoieAdresse();
  }
  
  public String getCodeErreurBneLibelleVoieAdresse()
  {
    return m_fluxAEMInfra.getBneLibelleVoieAdresse_C_ERR();
  }
  
  public void setBneLibelleVoieAdresse(String pValeur)
  {
    m_fluxAEMInfra.setBneLibelleVoieAdresse(pValeur);
  }
  
  public void setCodeErreurBneLibelleVoieAdresse(String pCodeErreur)
  {
    m_fluxAEMInfra.setBneLibelleVoieAdresse_C_ERR(pCodeErreur);
  }
  
  public String getBneComplAdresse()
  {
    return m_fluxAEMInfra.getBneComplAdresse();
  }
  
  public String getCodeErreurBneComplAdresse()
  {
    return m_fluxAEMInfra.getBneComplAdresse_C_ERR();
  }
  
  public void setBneComplAdresse(String pValeur)
  {
    m_fluxAEMInfra.setBneComplAdresse(pValeur);
  }
  
  public void setCodeErreurBneComplAdresse(String pCodeErreur)
  {
    m_fluxAEMInfra.setBneComplAdresse_C_ERR(pCodeErreur);
  }
  
  public String getBneCodePostal()
  {
    return m_fluxAEMInfra.getBneCodePostal();
  }
  
  public String getCodeErreurBneCodePostal()
  {
    return m_fluxAEMInfra.getBneCodePostal_C_ERR();
  }
  
  public void setBneCodePostal(String pValeur)
  {
    m_fluxAEMInfra.setBneCodePostal(pValeur);
  }
  
  public void setCodeErreurBneCodePostal(String pCodeErreur)
  {
    m_fluxAEMInfra.setBneCodePostal_C_ERR(pCodeErreur);
  }
  
  public String getBneLibelleCommune()
  {
    return m_fluxAEMInfra.getBneLibelleCommune();
  }
  
  public String getCodeErreurBneLibelleCommune()
  {
    return m_fluxAEMInfra.getBneLibelleCommune_C_ERR();
  }
  
  public void setBneLibelleCommune(String pValeur)
  {
    m_fluxAEMInfra.setBneLibelleCommune(pValeur);
  }
  
  public void setCodeErreurBneLibelleCommune(String pCodeErreur)
  {
    m_fluxAEMInfra.setBneLibelleCommune_C_ERR(pCodeErreur);
  }
  
  public String getBneAssedicAffiliation()
  {
    return m_fluxAEMInfra.getBneAssedicAffiliation();
  }
  
  public String getCodeErreurBneAssedicAffiliation()
  {
    return m_fluxAEMInfra.getBneAssedicAffiliation_C_ERR();
  }
  
  public void setBneAssedicAffiliation(String pValeur)
  {
    m_fluxAEMInfra.setBneAssedicAffiliation(pValeur);
  }
  
  public void setCodeErreurBneAssedicAffiliation(String pCodeErreur)
  {
    m_fluxAEMInfra.setBneAssedicAffiliation_C_ERR(pCodeErreur);
  }
  
  public String getBneNumAffiliation()
  {
    return m_fluxAEMInfra.getBneNumAffiliation();
  }
  
  public String getCodeErreurBneNumAffiliation()
  {
    return m_fluxAEMInfra.getBneNumAffiliation_C_ERR();
  }
  
  public void setBneNumAffiliation(String pValeur)
  {
    m_fluxAEMInfra.setBneNumAffiliation(pValeur);
  }
  
  public void setCodeErreurBneNumAffiliation(String pCodeErreur)
  {
    m_fluxAEMInfra.setBneNumAffiliation_C_ERR(pCodeErreur);
  }
  
  public String getCodeAction()
  {
    return m_fluxAEMInfra.getCodeAction();
  }
  
  public String getCodeErreurCodeAction()
  {
    return m_fluxAEMInfra.getCodeAction_C_ERR();
  }
  
  public void setCodeAction(String pValeur)
  {
    m_fluxAEMInfra.setCodeAction(pValeur);
  }
  
  public void setCodeErreurCodeAction(String pCodeErreur)
  {
    m_fluxAEMInfra.setCodeAction_C_ERR(pCodeErreur);
  }
  
  public String getIndicateurType()
  {
    return m_fluxAEMInfra.getIndicateurType();
  }
  
  public String getCodeErreurIndicateurType()
  {
    return m_fluxAEMInfra.getIndicateurType_C_ERR();
  }
  
  public void setIndicateurType(String pValeur)
  {
    m_fluxAEMInfra.setIndicateurType(pValeur);
  }
  
  public void setCodeErreurIndicateurType(String pCodeErreur)
  {
    m_fluxAEMInfra.setIndicateurType_C_ERR(pCodeErreur);
  }
  
  public String getNumeroInitial()
  {
    return m_fluxAEMInfra.getNumeroInitial();
  }
  
  public String getCodeErreurNumeroInitial()
  {
    return m_fluxAEMInfra.getNumeroInitial_C_ERR();
  }
  
  public void setNumeroInitial(String pValeur)
  {
    m_fluxAEMInfra.setNumeroInitial(pValeur);
  }
  
  public void setCodeErreurNumeroInitial(String pCodeErreur)
  {
    m_fluxAEMInfra.setNumeroInitial_C_ERR(pCodeErreur);
  }
  
  public String getNumero()
  {
    return m_fluxAEMInfra.getNumero();
  }
  
  public String getCodeErreurNumero()
  {
    return m_fluxAEMInfra.getNumero_C_ERR();
  }
  
  public void setNumero(String pValeur)
  {
    m_fluxAEMInfra.setNumero(pValeur);
  }
  
  public void setCodeErreurNumero(String pCodeErreur)
  {
    m_fluxAEMInfra.setNumero_C_ERR(pCodeErreur);
  }
  
  public String getSiretEmployeur()
  {
    return m_fluxAEMInfra.getSiretEmployeur();
  }
  
  public String getCodeErreurSiretEmployeur()
  {
    return m_fluxAEMInfra.getSiretEmployeur_C_ERR();
  }
  
  public void setSiretEmployeur(String pValeur)
  {
    m_fluxAEMInfra.setSiretEmployeur(pValeur);
  }
  
  public void setCodeErreurSiretEmployeur(String pCodeErreur)
  {
    m_fluxAEMInfra.setSiretEmployeur_C_ERR(pCodeErreur);
  }
  
  public String getCodeNafApe()
  {
    return m_fluxAEMInfra.getCodeNafApe();
  }
  
  public String getCodeErreurCodeNafApe()
  {
    return m_fluxAEMInfra.getCodeNafApe_C_ERR();
  }
  
  public void setCodeNafApe(String pValeur)
  {
    m_fluxAEMInfra.setCodeNafApe(pValeur);
  }
  
  public void setCodeErreurCodeNafApe(String pCodeErreur)
  {
    m_fluxAEMInfra.setCodeNafApe_C_ERR(pCodeErreur);
  }
  
  public String getNumAssedicAffiliation()
  {
    return m_fluxAEMInfra.getNumAssedicAffiliation();
  }
  
  public String getCodeErreurNumAssedicAffiliation()
  {
    return m_fluxAEMInfra.getNumAssedicAffiliation_C_ERR();
  }
  
  public void setNumAssedicAffiliation(String pValeur)
  {
    m_fluxAEMInfra.setNumAssedicAffiliation(pValeur);
  }
  
  public void setCodeErreurNumAssedicAffiliation(String pCodeErreur)
  {
    m_fluxAEMInfra.setNumAssedicAffiliation_C_ERR(pCodeErreur);
  }
  
  public String getNumeroAffiliation()
  {
    return m_fluxAEMInfra.getNumeroAffiliation();
  }
  
  public String getCodeErreurNumeroAffiliation()
  {
    return m_fluxAEMInfra.getNumeroAffiliation_C_ERR();
  }
  
  public void setNumeroAffiliation(String pValeur)
  {
    m_fluxAEMInfra.setNumeroAffiliation(pValeur);
  }
  
  public void setCodeErreurNumeroAffiliation(String pCodeErreur)
  {
    m_fluxAEMInfra.setNumeroAffiliation_C_ERR(pCodeErreur);
  }
  
  public String getRaisonSociale()
  {
    return m_fluxAEMInfra.getRaisonSociale();
  }
  
  public String getCodeErreurRaisonSociale()
  {
    return m_fluxAEMInfra.getRaisonSociale_C_ERR();
  }
  
  public void setRaisonSociale(String pValeur)
  {
    m_fluxAEMInfra.setRaisonSociale(pValeur);
  }
  
  public void setCodeErreurRaisonSociale(String pCodeErreur)
  {
    m_fluxAEMInfra.setRaisonSociale_C_ERR(pCodeErreur);
  }
  
  public String getAdresseEmployeur()
  {
    return m_fluxAEMInfra.getAdresseEmployeur();
  }
  
  public String getCodeErreurAdresseEmployeur()
  {
    return m_fluxAEMInfra.getAdresseEmployeur_C_ERR();
  }
  
  public void setAdresseEmployeur(String pValeur)
  {
    m_fluxAEMInfra.setAdresseEmployeur(pValeur);
  }
  
  public void setCodeErreurAdresseEmployeur(String pCodeErreur)
  {
    m_fluxAEMInfra.setAdresseEmployeur_C_ERR(pCodeErreur);
  }
  
  public String getComplAdresseEmployeur()
  {
    return m_fluxAEMInfra.getComplAdresseEmployeur();
  }
  
  public String getCodeErreurComplAdresseEmployeur()
  {
    return m_fluxAEMInfra.getComplAdresseEmployeur_C_ERR();
  }
  
  public void setComplAdresseEmployeur(String pValeur)
  {
    m_fluxAEMInfra.setComplAdresseEmployeur(pValeur);
  }
  
  public void setCodeErreurComplAdresseEmployeur(String pCodeErreur)
  {
    m_fluxAEMInfra.setComplAdresseEmployeur_C_ERR(pCodeErreur);
  }
  
  public String getTelephoneEmployeur()
  {
    return m_fluxAEMInfra.getTelephoneEmployeur();
  }
  
  public String getCodeErreurTelephoneEmployeur()
  {
    return m_fluxAEMInfra.getTelephoneEmployeur_C_ERR();
  }
  
  public void setTelephoneEmployeur(String pValeur)
  {
    m_fluxAEMInfra.setTelephoneEmployeur(pValeur);
  }
  
  public void setCodeErreurTelephoneEmployeur(String pCodeErreur)
  {
    m_fluxAEMInfra.setTelephoneEmployeur_C_ERR(pCodeErreur);
  }
  
  public String getFaxEmployeur()
  {
    return m_fluxAEMInfra.getFaxEmployeur();
  }
  
  public String getCodeErreurFaxEmployeur()
  {
    return m_fluxAEMInfra.getFaxEmployeur_C_ERR();
  }
  
  public void setFaxEmployeur(String pValeur)
  {
    m_fluxAEMInfra.setFaxEmployeur(pValeur);
  }
  
  public void setCodeErreurFaxEmployeur(String pCodeErreur)
  {
    m_fluxAEMInfra.setFaxEmployeur_C_ERR(pCodeErreur);
  }
  
  public String getCourrielEmployeur()
  {
    return m_fluxAEMInfra.getCourrielEmployeur();
  }
  
  public String getCodeErreurCourrielEmployeur()
  {
    return m_fluxAEMInfra.getCourrielEmployeur_C_ERR();
  }
  
  public void setCourrielEmployeur(String pValeur)
  {
    m_fluxAEMInfra.setCourrielEmployeur(pValeur);
  }
  
  public void setCodeErreurCourrielEmployeur(String pCodeErreur)
  {
    m_fluxAEMInfra.setCourrielEmployeur_C_ERR(pCodeErreur);
  }
  
  public String getCodePostalEmployeur()
  {
    return m_fluxAEMInfra.getCodePostalEmployeur();
  }
  
  public String getCodeErreurCodePostalEmployeur()
  {
    return m_fluxAEMInfra.getCodePostalEmployeur_C_ERR();
  }
  
  public void setCodePostalEmployeur(String pValeur)
  {
    m_fluxAEMInfra.setCodePostalEmployeur(pValeur);
  }
  
  public void setCodeErreurCodePostalEmployeur(String pCodeErreur)
  {
    m_fluxAEMInfra.setCodePostalEmployeur_C_ERR(pCodeErreur);
  }
  
  public String getCommuneEmployeur()
  {
    return m_fluxAEMInfra.getCommuneEmployeur();
  }
  
  public String getCodeErreurCommuneEmployeur()
  {
    return m_fluxAEMInfra.getCommuneEmployeur_C_ERR();
  }
  
  public void setCommuneEmployeur(String pValeur)
  {
    m_fluxAEMInfra.setCommuneEmployeur(pValeur);
  }
  
  public void setCodeErreurCommuneEmployeur(String pCodeErreur)
  {
    m_fluxAEMInfra.setCommuneEmployeur_C_ERR(pCodeErreur);
  }
  
  public String getFormeJuridique()
  {
    return m_fluxAEMInfra.getFormeJuridique();
  }
  
  public String getCodeErreurFormeJuridique()
  {
    return m_fluxAEMInfra.getFormeJuridique_C_ERR();
  }
  
  public void setFormeJuridique(String pValeur)
  {
    m_fluxAEMInfra.setFormeJuridique(pValeur);
  }
  
  public void setCodeErreurFormeJuridique(String pCodeErreur)
  {
    m_fluxAEMInfra.setFormeJuridique_C_ERR(pCodeErreur);
  }
  
  public String getActiviteEmployeur()
  {
    return m_fluxAEMInfra.getActiviteEmployeur();
  }
  
  public String getCodeErreurActiviteEmployeur()
  {
    return m_fluxAEMInfra.getActiviteEmployeur_C_ERR();
  }
  
  public void setActiviteEmployeur(String pValeur)
  {
    m_fluxAEMInfra.setActiviteEmployeur(pValeur);
  }
  
  public void setCodeErreurActiviteEmployeur(String pCodeErreur)
  {
    m_fluxAEMInfra.setActiviteEmployeur_C_ERR(pCodeErreur);
  }
  
  public String getLicenceSpectacle()
  {
    return m_fluxAEMInfra.getLicenceSpectacle();
  }
  
  public String getCodeErreurLicenceSpectacle()
  {
    return m_fluxAEMInfra.getLicenceSpectacle_C_ERR();
  }
  
  public void setLicenceSpectacle(String pValeur)
  {
    m_fluxAEMInfra.setLicenceSpectacle(pValeur);
  }
  
  public void setCodeErreurLicenceSpectacle(String pCodeErreur)
  {
    m_fluxAEMInfra.setLicenceSpectacle_C_ERR(pCodeErreur);
  }
  
  public String getNumeroLicenceSpe()
  {
    return m_fluxAEMInfra.getNumeroLicenceSpe();
  }
  
  public String getCodeErreurNumeroLicenceSpe()
  {
    return m_fluxAEMInfra.getNumeroLicenceSpe_C_ERR();
  }
  
  public void setNumeroLicenceSpe(String pValeur)
  {
    m_fluxAEMInfra.setNumeroLicenceSpe(pValeur);
  }
  
  public void setCodeErreurNumeroLicenceSpe(String pCodeErreur)
  {
    m_fluxAEMInfra.setNumeroLicenceSpe_C_ERR(pCodeErreur);
  }
  
  public String getOrganisateurOccasionnelspe()
  {
    return m_fluxAEMInfra.getOrganisateurOccasionnelspe();
  }
  
  public String getCodeErreurOrganisateurOccasionnelspe()
  {
    return m_fluxAEMInfra.getOrganisateurOccasionnelspe_C_ERR();
  }
  
  public void setOrganisateurOccasionnelspe(String pValeur)
  {
    m_fluxAEMInfra.setOrganisateurOccasionnelspe(pValeur);
  }
  
  public void setCodeErreurOrganisateurOccasionnelspe(String pCodeErreur)
  {
    m_fluxAEMInfra.setOrganisateurOccasionnelspe_C_ERR(pCodeErreur);
  }
  
  public String getTitulaireLabelPresta()
  {
    return m_fluxAEMInfra.getTitulaireLabelPresta();
  }
  
  public String getCodeErreurTitulaireLabelPresta()
  {
    return m_fluxAEMInfra.getTitulaireLabelPresta_C_ERR();
  }
  
  public void setTitulaireLabelPresta(String pValeur)
  {
    m_fluxAEMInfra.setTitulaireLabelPresta(pValeur);
  }
  
  public void setCodeErreurTitulaireLabelPresta(String pCodeErreur)
  {
    m_fluxAEMInfra.setTitulaireLabelPresta_C_ERR(pCodeErreur);
  }
  
  public String getNumeroLabelPrestaSer()
  {
    return m_fluxAEMInfra.getNumeroLabelPrestaSer();
  }
  
  public String getCodeErreurNumeroLabelPrestaSer()
  {
    return m_fluxAEMInfra.getNumeroLabelPrestaSer_C_ERR();
  }
  
  public void setNumeroLabelPrestaSer(String pValeur)
  {
    m_fluxAEMInfra.setNumeroLabelPrestaSer(pValeur);
  }
  
  public void setCodeErreurNumeroLabelPrestaSer(String pCodeErreur)
  {
    m_fluxAEMInfra.setNumeroLabelPrestaSer_C_ERR(pCodeErreur);
  }
  
  public String getNumAffiCaisseConges()
  {
    return m_fluxAEMInfra.getNumAffiCaisseConges();
  }
  
  public String getCodeErreurNumAffiCaisseConges()
  {
    return m_fluxAEMInfra.getNumAffiCaisseConges_C_ERR();
  }
  
  public void setNumAffiCaisseConges(String pValeur)
  {
    m_fluxAEMInfra.setNumAffiCaisseConges(pValeur);
  }
  
  public void setCodeErreurNumAffiCaisseConges(String pCodeErreur)
  {
    m_fluxAEMInfra.setNumAffiCaisseConges_C_ERR(pCodeErreur);
  }
  
  public String getNomSalarie()
  {
    return m_fluxAEMInfra.getNomSalarie();
  }
  
  public String getCodeErreurNomSalarie()
  {
    return m_fluxAEMInfra.getNomSalarie_C_ERR();
  }
  
  public void setNomSalarie(String pValeur)
  {
    m_fluxAEMInfra.setNomSalarie(pValeur);
  }
  
  public void setCodeErreurNomSalarie(String pCodeErreur)
  {
    m_fluxAEMInfra.setNomSalarie_C_ERR(pCodeErreur);
  }
  
  public String getPrenomSalarie()
  {
    return m_fluxAEMInfra.getPrenomSalarie();
  }
  
  public String getCodeErreurPrenomSalarie()
  {
    return m_fluxAEMInfra.getPrenomSalarie_C_ERR();
  }
  
  public void setPrenomSalarie(String pValeur)
  {
    m_fluxAEMInfra.setPrenomSalarie(pValeur);
  }
  
  public void setCodeErreurPrenomSalarie(String pCodeErreur)
  {
    m_fluxAEMInfra.setPrenomSalarie_C_ERR(pCodeErreur);
  }
  
  public String getNomUsuel()
  {
    return m_fluxAEMInfra.getNomUsuel();
  }
  
  public String getCodeErreurNomUsuel()
  {
    return m_fluxAEMInfra.getNomUsuel_C_ERR();
  }
  
  public void setNomUsuel(String pValeur)
  {
    m_fluxAEMInfra.setNomUsuel(pValeur);
  }
  
  public void setCodeErreurNomUsuel(String pCodeErreur)
  {
    m_fluxAEMInfra.setNomUsuel_C_ERR(pCodeErreur);
  }
  
  public String getTelephoneSalarie()
  {
    return m_fluxAEMInfra.getTelephoneSalarie();
  }
  
  public String getCodeErreurTelephoneSalarie()
  {
    return m_fluxAEMInfra.getTelephoneSalarie_C_ERR();
  }
  
  public void setTelephoneSalarie(String pValeur)
  {
    m_fluxAEMInfra.setTelephoneSalarie(pValeur);
  }
  
  public void setCodeErreurTelephoneSalarie(String pCodeErreur)
  {
    m_fluxAEMInfra.setTelephoneSalarie_C_ERR(pCodeErreur);
  }
  
  public String getNIR()
  {
    return m_fluxAEMInfra.getNIR();
  }
  
  public String getCodeErreurNIR()
  {
    return m_fluxAEMInfra.getNIR_C_ERR();
  }
  
  public void setNIR(String pValeur)
  {
    m_fluxAEMInfra.setNIR(pValeur);
  }
  
  public void setCodeErreurNIR(String pCodeErreur)
  {
    m_fluxAEMInfra.setNIR_C_ERR(pCodeErreur);
  }
  
  public String getAdresseSalarie()
  {
    return m_fluxAEMInfra.getAdresseSalarie();
  }
  
  public String getCodeErreurAdresseSalarie()
  {
    return m_fluxAEMInfra.getAdresseSalarie_C_ERR();
  }
  
  public void setAdresseSalarie(String pValeur)
  {
    m_fluxAEMInfra.setAdresseSalarie(pValeur);
  }
  
  public void setCodeErreurAdresseSalarie(String pCodeErreur)
  {
    m_fluxAEMInfra.setAdresseSalarie_C_ERR(pCodeErreur);
  }
  
  public String getComplementAdresseSalarie()
  {
    return m_fluxAEMInfra.getComplementAdresseSalarie();
  }
  
  public String getCodeErreurComplementAdresseSalarie()
  {
    return m_fluxAEMInfra.getComplementAdresseSalarie_C_ERR();
  }
  
  public void setComplementAdresseSalarie(String pValeur)
  {
    m_fluxAEMInfra.setComplementAdresseSalarie(pValeur);
  }
  
  public void setCodeErreurComplementAdresseSalarie(String pCodeErreur)
  {
    m_fluxAEMInfra.setComplementAdresseSalarie_C_ERR(pCodeErreur);
  }
  
  public String getCodePostalSalarie()
  {
    return m_fluxAEMInfra.getCodePostalSalarie();
  }
  
  public String getCodeErreurCodePostalSalarie()
  {
    return m_fluxAEMInfra.getCodePostalSalarie_C_ERR();
  }
  
  public void setCodePostalSalarie(String pValeur)
  {
    m_fluxAEMInfra.setCodePostalSalarie(pValeur);
  }
  
  public void setCodeErreurCodePostalSalarie(String pCodeErreur)
  {
    m_fluxAEMInfra.setCodePostalSalarie_C_ERR(pCodeErreur);
  }
  
  public String getCommuneSalarie()
  {
    return m_fluxAEMInfra.getCommuneSalarie();
  }
  
  public String getCodeErreurCommuneSalarie()
  {
    return m_fluxAEMInfra.getCommuneSalarie_C_ERR();
  }
  
  public void setCommuneSalarie(String pValeur)
  {
    m_fluxAEMInfra.setCommuneSalarie(pValeur);
  }
  
  public void setCodeErreurCommuneSalarie(String pCodeErreur)
  {
    m_fluxAEMInfra.setCommuneSalarie_C_ERR(pCodeErreur);
  }
  
  public String getLienParente()
  {
    return m_fluxAEMInfra.getLienParente();
  }
  
  public String getCodeErreurLienParente()
  {
    return m_fluxAEMInfra.getLienParente_C_ERR();
  }
  
  public void setLienParente(String pValeur)
  {
    m_fluxAEMInfra.setLienParente(pValeur);
  }
  
  public void setCodeErreurLienParente(String pCodeErreur)
  {
    m_fluxAEMInfra.setLienParente_C_ERR(pCodeErreur);
  }
  
  public String getTypeLienParente()
  {
    return m_fluxAEMInfra.getTypeLienParente();
  }
  
  public String getCodeErreurTypeLienParente()
  {
    return m_fluxAEMInfra.getTypeLienParente_C_ERR();
  }
  
  public void setTypeLienParente(String pValeur)
  {
    m_fluxAEMInfra.setTypeLienParente(pValeur);
  }
  
  public void setCodeErreurTypeLienParente(String pCodeErreur)
  {
    m_fluxAEMInfra.setTypeLienParente_C_ERR(pCodeErreur);
  }
  
  public String getCodeEmploiOccupe()
  {
    return m_fluxAEMInfra.getCodeEmploiOccupe();
  }
  
  public String getCodeErreurCodeEmploiOccupe()
  {
    return m_fluxAEMInfra.getCodeEmploiOccupe_C_ERR();
  }
  
  public void setCodeEmploiOccupe(String pValeur)
  {
    m_fluxAEMInfra.setCodeEmploiOccupe(pValeur);
  }
  
  public void setCodeErreurCodeEmploiOccupe(String pCodeErreur)
  {
    m_fluxAEMInfra.setCodeEmploiOccupe_C_ERR(pCodeErreur);
  }
  
  public String getCodeQualification()
  {
    return m_fluxAEMInfra.getCodeQualification();
  }
  
  public String getCodeErreurCodeQualification()
  {
    return m_fluxAEMInfra.getCodeQualification_C_ERR();
  }
  
  public void setCodeQualification(String pValeur)
  {
    m_fluxAEMInfra.setCodeQualification(pValeur);
  }
  
  public void setCodeErreurCodeQualification(String pCodeErreur)
  {
    m_fluxAEMInfra.setCodeQualification_C_ERR(pCodeErreur);
  }
  
  public String getRegimeRetraiteCompl()
  {
    return m_fluxAEMInfra.getRegimeRetraiteCompl();
  }
  
  public String getCodeErreurRegimeRetraiteCompl()
  {
    return m_fluxAEMInfra.getRegimeRetraiteCompl_C_ERR();
  }
  
  public void setRegimeRetraiteCompl(String pValeur)
  {
    m_fluxAEMInfra.setRegimeRetraiteCompl(pValeur);
  }
  
  public void setCodeErreurRegimeRetraiteCompl(String pCodeErreur)
  {
    m_fluxAEMInfra.setRegimeRetraiteCompl_C_ERR(pCodeErreur);
  }
  
  public String getStatutCadre()
  {
    return m_fluxAEMInfra.getStatutCadre();
  }
  
  public String getCodeErreurStatutCadre()
  {
    return m_fluxAEMInfra.getStatutCadre_C_ERR();
  }
  
  public void setStatutCadre(String pValeur)
  {
    m_fluxAEMInfra.setStatutCadre(pValeur);
  }
  
  public void setCodeErreurStatutCadre(String pCodeErreur)
  {
    m_fluxAEMInfra.setStatutCadre_C_ERR(pCodeErreur);
  }
  
  public String getContratEnCours()
  {
    return m_fluxAEMInfra.getContratEnCours();
  }
  
  public String getCodeErreurContratEnCours()
  {
    return m_fluxAEMInfra.getContratEnCours_C_ERR();
  }
  
  public void setContratEnCours(String pValeur)
  {
    m_fluxAEMInfra.setContratEnCours(pValeur);
  }
  
  public void setCodeErreurContratEnCours(String pCodeErreur)
  {
    m_fluxAEMInfra.setContratEnCours_C_ERR(pCodeErreur);
  }
  
  public String getMotiFinContrat()
  {
    return m_fluxAEMInfra.getMotiFinContrat();
  }
  
  public String getCodeErreurMotiFinContrat()
  {
    return m_fluxAEMInfra.getMotiFinContrat_C_ERR();
  }
  
  public void setMotiFinContrat(String pValeur)
  {
    m_fluxAEMInfra.setMotiFinContrat(pValeur);
  }
  
  public void setCodeErreurMotiFinContrat(String pCodeErreur)
  {
    m_fluxAEMInfra.setMotiFinContrat_C_ERR(pCodeErreur);
  }
  
  public String getNomEmployeur()
  {
    return m_fluxAEMInfra.getNomEmployeur();
  }
  
  public String getCodeErreurNomEmployeur()
  {
    return m_fluxAEMInfra.getNomEmployeur_C_ERR();
  }
  
  public void setNomEmployeur(String pValeur)
  {
    m_fluxAEMInfra.setNomEmployeur(pValeur);
  }
  
  public void setCodeErreurNomEmployeur(String pCodeErreur)
  {
    m_fluxAEMInfra.setNomEmployeur_C_ERR(pCodeErreur);
  }
  
  public String getPrenomEmployeur()
  {
    return m_fluxAEMInfra.getPrenomEmployeur();
  }
  
  public String getCodeErreurPrenomEmployeur()
  {
    return m_fluxAEMInfra.getPrenomEmployeur_C_ERR();
  }
  
  public void setPrenomEmployeur(String pValeur)
  {
    m_fluxAEMInfra.setPrenomEmployeur(pValeur);
  }
  
  public void setCodeErreurPrenomEmployeur(String pCodeErreur)
  {
    m_fluxAEMInfra.setPrenomEmployeur_C_ERR(pCodeErreur);
  }
  
  public String getQualite()
  {
    return m_fluxAEMInfra.getQualite();
  }
  
  public String getCodeErreurQualite()
  {
    return m_fluxAEMInfra.getQualite_C_ERR();
  }
  
  public void setQualite(String pValeur)
  {
    m_fluxAEMInfra.setQualite(pValeur);
  }
  
  public void setCodeErreurQualite(String pCodeErreur)
  {
    m_fluxAEMInfra.setQualite_C_ERR(pCodeErreur);
  }
  
  public String getMotifRupture()
  {
    return m_fluxAEMInfra.getMotifRupture();
  }
  
  public String getCodeErreurMotifRupture()
  {
    return m_fluxAEMInfra.getMotifRupture_C_ERR();
  }
  
  public void setMotifRupture(String pValeur)
  {
    m_fluxAEMInfra.setMotifRupture(pValeur);
  }
  
  public void setCodeErreurMotifRupture(String pCodeErreur)
  {
    m_fluxAEMInfra.setMotifRupture_C_ERR(pCodeErreur);
  }
  
  public String getCommuneSignature()
  {
    return m_fluxAEMInfra.getCommuneSignature();
  }
  
  public String getCodeErreurCommuneSignature()
  {
    return m_fluxAEMInfra.getCommuneSignature_C_ERR();
  }
  
  public void setCommuneSignature(String pValeur)
  {
    m_fluxAEMInfra.setCommuneSignature(pValeur);
  }
  
  public void setCodeErreurCommuneSignature(String pCodeErreur)
  {
    m_fluxAEMInfra.setCommuneSignature_C_ERR(pCodeErreur);
  }
  
  public String getContactAEM()
  {
    return m_fluxAEMInfra.getContactAEM();
  }
  
  public String getCodeErreurContactAEM()
  {
    return m_fluxAEMInfra.getContactAEM_C_ERR();
  }
  
  public void setContactAEM(String pValeur)
  {
    m_fluxAEMInfra.setContactAEM(pValeur);
  }
  
  public void setCodeErreurContactAEM(String pCodeErreur)
  {
    m_fluxAEMInfra.setContactAEM_C_ERR(pCodeErreur);
  }
  
  public String getTelephoneTiers()
  {
    return m_fluxAEMInfra.getTelephoneTiers();
  }
  
  public String getCodeErreurTelephoneTiers()
  {
    return m_fluxAEMInfra.getTelephoneTiers_C_ERR();
  }
  
  public void setTelephoneTiers(String pValeur)
  {
    m_fluxAEMInfra.setTelephoneTiers(pValeur);
  }
  
  public void setCodeErreurTelephoneTiers(String pCodeErreur)
  {
    m_fluxAEMInfra.setTelephoneTiers_C_ERR(pCodeErreur);
  }
  
  public String getCodeOrganisme()
  {
    return m_fluxAEMInfra.getCodeOrganisme();
  }
  
  public String getCodeErreurCodeOrganisme()
  {
    return m_fluxAEMInfra.getCodeOrganisme_C_ERR();
  }
  
  public void setCodeOrganisme(String pValeur)
  {
    m_fluxAEMInfra.setCodeOrganisme(pValeur);
  }
  
  public void setCodeErreurCodeOrganisme(String pCodeErreur)
  {
    m_fluxAEMInfra.setCodeOrganisme_C_ERR(pCodeErreur);
  }
  
  public String getNbJoursTravailles()
  {
    return m_fluxAEMInfra.getNbJoursTravailles();
  }
  
  public String getCodeErreurNbJoursTravailles()
  {
    return m_fluxAEMInfra.getNbJoursTravailles_C_ERR();
  }
  
  public void setNbJoursTravailles(String pValeur)
  {
    m_fluxAEMInfra.setNbJoursTravailles(pValeur);
  }
  
  public void setCodeErreurNbJoursTravailles(String pCodeErreur)
  {
    m_fluxAEMInfra.setNbJoursTravailles_C_ERR(pCodeErreur);
  }
  
  public String getNumVersionAEM()
  {
    return m_fluxAEMInfra.getNumVersionAEM();
  }
  
  public String getCodeErreurNumVersionAEM()
  {
    return m_fluxAEMInfra.getNumVersionAEM_C_ERR();
  }
  
  public void setNumVersionAEM(String pValeur)
  {
    m_fluxAEMInfra.setNumVersionAEM(pValeur);
  }
  
  public void setCodeErreurNumVersionAEM(String pCodeErreur)
  {
    m_fluxAEMInfra.setNumVersionAEM_C_ERR(pCodeErreur);
  }
  
  public String getAffiCaisseConges()
  {
    return m_fluxAEMInfra.getAffiCaisseConges();
  }
  
  public String getCodeErreurAffiCaisseConges()
  {
    return m_fluxAEMInfra.getAffiCaisseConges_C_ERR();
  }
  
  public void setAffiCaisseConges(String pValeur)
  {
    m_fluxAEMInfra.setAffiCaisseConges(pValeur);
  }
  
  public void setCodeErreurAffiCaisseConges(String pCodeErreur)
  {
    m_fluxAEMInfra.setAffiCaisseConges_C_ERR(pCodeErreur);
  }
  
  public String getNumeroObjet()
  {
    return m_fluxAEMInfra.getNumeroObjet();
  }
  
  public String getCodeErreurNumeroObjet()
  {
    return m_fluxAEMInfra.getNumeroObjet_C_ERR();
  }
  
  public void setNumeroObjet(String pValeur)
  {
    m_fluxAEMInfra.setNumeroObjet(pValeur);
  }
  
  public void setCodeErreurNumeroObjet(String pCodeErreur)
  {
    m_fluxAEMInfra.setNumeroObjet_C_ERR(pCodeErreur);
  }
  
  public String getIndicateurHorsChamp()
  {
    return m_fluxAEMInfra.getIndicateurHorsChamp();
  }
  
  public String getCodeErreurIndicateurHorsChamp()
  {
    return m_fluxAEMInfra.getIndicateurHorsChamp_C_ERR();
  }
  
  public void setIndicateurHorsChamp(String pValeur)
  {
    m_fluxAEMInfra.setIndicateurHorsChamp(pValeur);
  }
  
  public void setCodeErreurIndicateurHorsChamp(String pCodeErreur)
  {
    m_fluxAEMInfra.setIndicateurHorsChamp_C_ERR(pCodeErreur);
  }
  
  public String getNouveauCodeApeNaf()
  {
    return m_fluxAEMInfra.getNouveauCodeApeNaf();
  }
  
  public String getCodeErreurNouveauCodeApeNaf()
  {
    return m_fluxAEMInfra.getNouveauCodeApeNaf_C_ERR();
  }
  
  public void setNouveauCodeApeNaf(String pValeur)
  {
    m_fluxAEMInfra.setNouveauCodeApeNaf(pValeur);
  }
  
  public void setCodeErreurNouveauCodeApeNaf(String pCodeErreur)
  {
    m_fluxAEMInfra.setNouveauCodeApeNaf_C_ERR(pCodeErreur);
  }
  
  public Damj getDateNaissance()
  {
    return m_fluxAEMInfra.getDateNaissance();
  }
  
  public String getCodeErreurDateNaissance()
  {
    return m_fluxAEMInfra.getDateNaissance_C_ERR();
  }
  
  public void setDateNaissance(Damj pValeur)
  {
    m_fluxAEMInfra.setDateNaissance(pValeur);
  }
  
  public void setCodeErreurDateNaissance(String pCodeErreur)
  {
    m_fluxAEMInfra.setDateNaissance_C_ERR(pCodeErreur);
  }
  
  public Damj getDateFincontrat()
  {
    return m_fluxAEMInfra.getDateFincontrat();
  }
  
  public String getCodeErreurDateFincontrat()
  {
    return m_fluxAEMInfra.getDateFincontrat_C_ERR();
  }
  
  public void setDateFincontrat(Damj pValeur)
  {
    m_fluxAEMInfra.setDateFincontrat(pValeur);
  }
  
  public void setCodeErreurDateFincontrat(String pCodeErreur)
  {
    m_fluxAEMInfra.setDateFincontrat_C_ERR(pCodeErreur);
  }
  
  public Damj getDateEmbauche()
  {
    return m_fluxAEMInfra.getDateEmbauche();
  }
  
  public String getCodeErreurDateEmbauche()
  {
    return m_fluxAEMInfra.getDateEmbauche_C_ERR();
  }
  
  public void setDateEmbauche(Damj pValeur)
  {
    m_fluxAEMInfra.setDateEmbauche(pValeur);
  }
  
  public void setCodeErreurDateEmbauche(String pCodeErreur)
  {
    m_fluxAEMInfra.setDateEmbauche_C_ERR(pCodeErreur);
  }
  
  public Damj getDateSignature()
  {
    return m_fluxAEMInfra.getDateSignature();
  }
  
  public String getCodeErreurDateSignature()
  {
    return m_fluxAEMInfra.getDateSignature_C_ERR();
  }
  
  public void setDateSignature(Damj pValeur)
  {
    m_fluxAEMInfra.setDateSignature(pValeur);
  }
  
  public void setCodeErreurDateSignature(String pCodeErreur)
  {
    m_fluxAEMInfra.setDateSignature_C_ERR(pCodeErreur);
  }
  
  public Damj getDateFichierExt()
  {
    return m_fluxAEMInfra.getDateFichierExt();
  }
  
  public String getCodeErreurDateFichierExt()
  {
    return m_fluxAEMInfra.getDateFichierExt_C_ERR();
  }
  
  public void setDateFichierExt(Damj pValeur)
  {
    m_fluxAEMInfra.setDateFichierExt(pValeur);
  }
  
  public void setCodeErreurDateFichierExt(String pCodeErreur)
  {
    m_fluxAEMInfra.setDateFichierExt_C_ERR(pCodeErreur);
  }
  
  public Damj getDateCreation()
  {
    return m_fluxAEMInfra.getDateCreation();
  }
  
  public String getCodeErreurDateCreation()
  {
    return m_fluxAEMInfra.getDateCreation_C_ERR();
  }
  
  public void setDateCreation(Damj pValeur)
  {
    m_fluxAEMInfra.setDateCreation(pValeur);
  }
  
  public void setCodeErreurDateCreation(String pCodeErreur)
  {
    m_fluxAEMInfra.setDateCreation_C_ERR(pCodeErreur);
  }
  
  public Damj getDateInitialeFinCDD()
  {
    return m_fluxAEMInfra.getDateInitialeFinCDD();
  }
  
  public String getCodeErreurDateInitialeFinCDD()
  {
    return m_fluxAEMInfra.getDateInitialeFinCDD_C_ERR();
  }
  
  public void setDateInitialeFinCDD(Damj pValeur)
  {
    m_fluxAEMInfra.setDateInitialeFinCDD(pValeur);
  }
  
  public void setCodeErreurDateInitialeFinCDD(String pCodeErreur)
  {
    m_fluxAEMInfra.setDateInitialeFinCDD_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getNbHeures()
  {
    return m_fluxAEMInfra.getNbHeures();
  }
  
  public String getCodeErreurNbHeures()
  {
    return m_fluxAEMInfra.getNbHeures_C_ERR();
  }
  
  public void setNbHeures(BigDecimal pValeur)
  {
    m_fluxAEMInfra.setNbHeures(pValeur);
  }
  
  public void setCodeErreurNbHeures(String pCodeErreur)
  {
    m_fluxAEMInfra.setNbHeures_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getNbCachets()
  {
    return m_fluxAEMInfra.getNbCachets();
  }
  
  public String getCodeErreurNbCachets()
  {
    return m_fluxAEMInfra.getNbCachets_C_ERR();
  }
  
  public void setNbCachets(BigDecimal pValeur)
  {
    m_fluxAEMInfra.setNbCachets(pValeur);
  }
  
  public void setCodeErreurNbCachets(String pCodeErreur)
  {
    m_fluxAEMInfra.setNbCachets_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getSalaireBrutAvtAbatt()
  {
    return m_fluxAEMInfra.getSalaireBrutAvtAbatt();
  }
  
  public String getCodeErreurSalaireBrutAvtAbatt()
  {
    return m_fluxAEMInfra.getSalaireBrutAvtAbatt_C_ERR();
  }
  
  public void setSalaireBrutAvtAbatt(BigDecimal pValeur)
  {
    m_fluxAEMInfra.setSalaireBrutAvtAbatt(pValeur);
  }
  
  public void setCodeErreurSalaireBrutAvtAbatt(String pCodeErreur)
  {
    m_fluxAEMInfra.setSalaireBrutAvtAbatt_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getSalaireBrutAprAbatt()
  {
    return m_fluxAEMInfra.getSalaireBrutAprAbatt();
  }
  
  public String getCodeErreurSalaireBrutAprAbatt()
  {
    return m_fluxAEMInfra.getSalaireBrutAprAbatt_C_ERR();
  }
  
  public void setSalaireBrutAprAbatt(BigDecimal pValeur)
  {
    m_fluxAEMInfra.setSalaireBrutAprAbatt(pValeur);
  }
  
  public void setCodeErreurSalaireBrutAprAbatt(String pCodeErreur)
  {
    m_fluxAEMInfra.setSalaireBrutAprAbatt_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getTauxAbatt()
  {
    return m_fluxAEMInfra.getTauxAbatt();
  }
  
  public String getCodeErreurTauxAbatt()
  {
    return m_fluxAEMInfra.getTauxAbatt_C_ERR();
  }
  
  public void setTauxAbatt(BigDecimal pValeur)
  {
    m_fluxAEMInfra.setTauxAbatt(pValeur);
  }
  
  public void setCodeErreurTauxAbatt(String pCodeErreur)
  {
    m_fluxAEMInfra.setTauxAbatt_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getContributionDues()
  {
    return m_fluxAEMInfra.getContributionDues();
  }
  
  public String getCodeErreurContributionDues()
  {
    return m_fluxAEMInfra.getContributionDues_C_ERR();
  }
  
  public void setContributionDues(BigDecimal pValeur)
  {
    m_fluxAEMInfra.setContributionDues(pValeur);
  }
  
  public void setCodeErreurContributionDues(String pCodeErreur)
  {
    m_fluxAEMInfra.setContributionDues_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getMoisActualisation()
  {
    return m_fluxAEMInfra.getMoisActualisation();
  }
  
  public String getCodeErreurMoisActualisation()
  {
    return m_fluxAEMInfra.getMoisActualisation_C_ERR();
  }
  
  public void setMoisActualisation(BigDecimal pValeur)
  {
    m_fluxAEMInfra.setMoisActualisation(pValeur);
  }
  
  public void setCodeErreurMoisActualisation(String pCodeErreur)
  {
    m_fluxAEMInfra.setMoisActualisation_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getAnneeActualisation()
  {
    return m_fluxAEMInfra.getAnneeActualisation();
  }
  
  public String getCodeErreurAnneeActualisation()
  {
    return m_fluxAEMInfra.getAnneeActualisation_C_ERR();
  }
  
  public void setAnneeActualisation(BigDecimal pValeur)
  {
    m_fluxAEMInfra.setAnneeActualisation(pValeur);
  }
  
  public void setCodeErreurAnneeActualisation(String pCodeErreur)
  {
    m_fluxAEMInfra.setAnneeActualisation_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getNbCachetsIsoles()
  {
    return m_fluxAEMInfra.getNbCachetsIsoles();
  }
  
  public String getCodeErreurNbCachetsIsoles()
  {
    return m_fluxAEMInfra.getNbCachetsIsoles_C_ERR();
  }
  
  public void setNbCachetsIsoles(BigDecimal pValeur)
  {
    m_fluxAEMInfra.setNbCachetsIsoles(pValeur);
  }
  
  public void setCodeErreurNbCachetsIsoles(String pCodeErreur)
  {
    m_fluxAEMInfra.setNbCachetsIsoles_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getNbCachetsGroupes()
  {
    return m_fluxAEMInfra.getNbCachetsGroupes();
  }
  
  public String getCodeErreurNbCachetsGroupes()
  {
    return m_fluxAEMInfra.getNbCachetsGroupes_C_ERR();
  }
  
  public void setNbCachetsGroupes(BigDecimal pValeur)
  {
    m_fluxAEMInfra.setNbCachetsGroupes(pValeur);
  }
  
  public void setCodeErreurNbCachetsGroupes(String pCodeErreur)
  {
    m_fluxAEMInfra.setNbCachetsGroupes_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getAutresRemunerationsMontantBrut()
  {
    return m_fluxAEMInfra.getAutresRemunerationsMontantBrut();
  }
  
  public String getCodeErreurAutresRemunerationsMontantBrut()
  {
    return m_fluxAEMInfra.getAutresRemunerationsMontantBrut_C_ERR();
  }
  
  public void setAutresRemunerationsMontantBrut(BigDecimal pValeur)
  {
    m_fluxAEMInfra.setAutresRemunerationsMontantBrut(pValeur);
  }
  
  public void setCodeErreurAutresRemunerationsMontantBrut(String pCodeErreur)
  {
    m_fluxAEMInfra.setAutresRemunerationsMontantBrut_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getAutresRemunerationsTauxContributions()
  {
    return m_fluxAEMInfra.getAutresRemunerationsTauxContributions();
  }
  
  public String getCodeErreurAutresRemunerationsTauxContributions()
  {
    return m_fluxAEMInfra.getAutresRemunerationsTauxContributions_C_ERR();
  }
  
  public void setAutresRemunerationsTauxContributions(BigDecimal pValeur)
  {
    m_fluxAEMInfra.setAutresRemunerationsTauxContributions(pValeur);
  }
  
  public void setCodeErreurAutresRemunerationsTauxContributions(String pCodeErreur)
  {
    m_fluxAEMInfra.setAutresRemunerationsTauxContributions_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getAutresRemunerationsContributionsDues()
  {
    return m_fluxAEMInfra.getAutresRemunerationsContributionsDues();
  }
  
  public String getCodeErreurAutresRemunerationsContributionsDues()
  {
    return m_fluxAEMInfra.getAutresRemunerationsContributionsDues_C_ERR();
  }
  
  public void setAutresRemunerationsContributionsDues(BigDecimal pValeur)
  {
    m_fluxAEMInfra.setAutresRemunerationsContributionsDues(pValeur);
  }
  
  public void setCodeErreurAutresRemunerationsContributionsDues(String pCodeErreur)
  {
    m_fluxAEMInfra.setAutresRemunerationsContributionsDues_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getTotalContributionsDues()
  {
    return m_fluxAEMInfra.getTotalContributionsDues();
  }
  
  public String getCodeErreurTotalContributionsDues()
  {
    return m_fluxAEMInfra.getTotalContributionsDues_C_ERR();
  }
  
  public void setTotalContributionsDues(BigDecimal pValeur)
  {
    m_fluxAEMInfra.setTotalContributionsDues(pValeur);
  }
  
  public void setCodeErreurTotalContributionsDues(String pCodeErreur)
  {
    m_fluxAEMInfra.setTotalContributionsDues_C_ERR(pCodeErreur);
  }
  
  public String getBneCertifSociale()
  {
    return m_fluxAEMInfra.getBneCertifSociale();
  }
  
  public String getCodeErreurBneCertifSociale()
  {
    return m_fluxAEMInfra.getBneCertifSociale_C_ERR();
  }
  
  public void setBneCertifSociale(String pValeur)
  {
    m_fluxAEMInfra.setBneCertifSociale(pValeur);
  }
  
  public void setCodeErreurBneCertifSociale(String pCodeErreur)
  {
    m_fluxAEMInfra.setBneCertifSociale_C_ERR(pCodeErreur);
  }
  
  public String getIdccEmployeur()
  {
    return m_fluxAEMInfra.getIdccEmployeur();
  }
  
  public String getCodeErreurIdccEmployeur()
  {
    return m_fluxAEMInfra.getIdccEmployeur_C_ERR();
  }
  
  public void setIdccEmployeur(String pValeur)
  {
    m_fluxAEMInfra.setIdccEmployeur(pValeur);
  }
  
  public void setCodeErreurIdccEmployeur(String pCodeErreur)
  {
    m_fluxAEMInfra.setIdccEmployeur_C_ERR(pCodeErreur);
  }
  
  public String getIdccPrestation()
  {
    return m_fluxAEMInfra.getIdccPrestation();
  }
  
  public String getCodeErreurIdccPrestation()
  {
    return m_fluxAEMInfra.getIdccPrestation_C_ERR();
  }
  
  public void setIdccPrestation(String pValeur)
  {
    m_fluxAEMInfra.setIdccPrestation(pValeur);
  }
  
  public void setCodeErreurIdccPrestation(String pCodeErreur)
  {
    m_fluxAEMInfra.setIdccPrestation_C_ERR(pCodeErreur);
  }
  
  public String getRessortissant()
  {
    return m_fluxAEMInfra.getRessortissant();
  }
  
  public String getCodeErreurRessortissant()
  {
    return m_fluxAEMInfra.getRessortissant_C_ERR();
  }
  
  public void setRessortissant(String pValeur)
  {
    m_fluxAEMInfra.setRessortissant(pValeur);
  }
  
  public void setCodeErreurRessortissant(String pCodeErreur)
  {
    m_fluxAEMInfra.setRessortissant_C_ERR(pCodeErreur);
  }
  
  public String getIndicateurCertifSociale()
  {
    return m_fluxAEMInfra.getIndicateurCertifSociale();
  }
  
  public String getCodeErreurIndicateurCertifSociale()
  {
    return m_fluxAEMInfra.getIndicateurCertifSociale_C_ERR();
  }
  
  public void setIndicateurCertifSociale(String pValeur)
  {
    m_fluxAEMInfra.setIndicateurCertifSociale(pValeur);
  }
  
  public void setCodeErreurIndicateurCertifSociale(String pCodeErreur)
  {
    m_fluxAEMInfra.setIndicateurCertifSociale_C_ERR(pCodeErreur);
  }
  
  public String getNumCertifSociale()
  {
    return m_fluxAEMInfra.getNumCertifSociale();
  }
  
  public String getCodeErreurNumCertifSociale()
  {
    return m_fluxAEMInfra.getNumCertifSociale_C_ERR();
  }
  
  public void setNumCertifSociale(String pValeur)
  {
    m_fluxAEMInfra.setNumCertifSociale(pValeur);
  }
  
  public void setCodeErreurNumCertifSociale(String pCodeErreur)
  {
    m_fluxAEMInfra.setNumCertifSociale_C_ERR(pCodeErreur);
  }
  
  public _FluxAEM getFluxAEMInfra()
  {
    return m_fluxAEMInfra;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    if ((getCodeErreurBneSiret() != null) && 
      ("".equals(getCodeErreurBneSiret()))) {
      return true;
    }
    if ((getCodeErreurBNEEmployeur() != null) && 
      ("".equals(getCodeErreurBNEEmployeur()))) {
      return true;
    }
    if ((getCodeErreurBneRaisonSociale() != null) && 
      ("".equals(getCodeErreurBneRaisonSociale()))) {
      return true;
    }
    if ((getCodeErreurBneNumeroVoirie() != null) && 
      ("".equals(getCodeErreurBneNumeroVoirie()))) {
      return true;
    }
    if ((getCodeErreurBneLibelleVoieAdresse() != null) && 
      ("".equals(getCodeErreurBneLibelleVoieAdresse()))) {
      return true;
    }
    if ((getCodeErreurBneComplAdresse() != null) && 
      ("".equals(getCodeErreurBneComplAdresse()))) {
      return true;
    }
    if ((getCodeErreurBneCodePostal() != null) && 
      ("".equals(getCodeErreurBneCodePostal()))) {
      return true;
    }
    if ((getCodeErreurBneLibelleCommune() != null) && 
      ("".equals(getCodeErreurBneLibelleCommune()))) {
      return true;
    }
    if ((getCodeErreurBneAssedicAffiliation() != null) && 
      ("".equals(getCodeErreurBneAssedicAffiliation()))) {
      return true;
    }
    if ((getCodeErreurBneNumAffiliation() != null) && 
      ("".equals(getCodeErreurBneNumAffiliation()))) {
      return true;
    }
    if ((getCodeErreurCodeAction() != null) && 
      ("".equals(getCodeErreurCodeAction()))) {
      return true;
    }
    if ((getCodeErreurIndicateurType() != null) && 
      ("".equals(getCodeErreurIndicateurType()))) {
      return true;
    }
    if ((getCodeErreurNumeroInitial() != null) && 
      ("".equals(getCodeErreurNumeroInitial()))) {
      return true;
    }
    if ((getCodeErreurNumero() != null) && 
      ("".equals(getCodeErreurNumero()))) {
      return true;
    }
    if ((getCodeErreurSiretEmployeur() != null) && 
      ("".equals(getCodeErreurSiretEmployeur()))) {
      return true;
    }
    if ((getCodeErreurCodeNafApe() != null) && 
      ("".equals(getCodeErreurCodeNafApe()))) {
      return true;
    }
    if ((getCodeErreurNumAssedicAffiliation() != null) && 
      ("".equals(getCodeErreurNumAssedicAffiliation()))) {
      return true;
    }
    if ((getCodeErreurNumeroAffiliation() != null) && 
      ("".equals(getCodeErreurNumeroAffiliation()))) {
      return true;
    }
    if ((getCodeErreurRaisonSociale() != null) && 
      ("".equals(getCodeErreurRaisonSociale()))) {
      return true;
    }
    if ((getCodeErreurAdresseEmployeur() != null) && 
      ("".equals(getCodeErreurAdresseEmployeur()))) {
      return true;
    }
    if ((getCodeErreurComplAdresseEmployeur() != null) && 
      ("".equals(getCodeErreurComplAdresseEmployeur()))) {
      return true;
    }
    if ((getCodeErreurTelephoneEmployeur() != null) && 
      ("".equals(getCodeErreurTelephoneEmployeur()))) {
      return true;
    }
    if ((getCodeErreurFaxEmployeur() != null) && 
      ("".equals(getCodeErreurFaxEmployeur()))) {
      return true;
    }
    if ((getCodeErreurCourrielEmployeur() != null) && 
      ("".equals(getCodeErreurCourrielEmployeur()))) {
      return true;
    }
    if ((getCodeErreurCodePostalEmployeur() != null) && 
      ("".equals(getCodeErreurCodePostalEmployeur()))) {
      return true;
    }
    if ((getCodeErreurCommuneEmployeur() != null) && 
      ("".equals(getCodeErreurCommuneEmployeur()))) {
      return true;
    }
    if ((getCodeErreurFormeJuridique() != null) && 
      ("".equals(getCodeErreurFormeJuridique()))) {
      return true;
    }
    if ((getCodeErreurActiviteEmployeur() != null) && 
      ("".equals(getCodeErreurActiviteEmployeur()))) {
      return true;
    }
    if ((getCodeErreurLicenceSpectacle() != null) && 
      ("".equals(getCodeErreurLicenceSpectacle()))) {
      return true;
    }
    if ((getCodeErreurNumeroLicenceSpe() != null) && 
      ("".equals(getCodeErreurNumeroLicenceSpe()))) {
      return true;
    }
    if ((getCodeErreurOrganisateurOccasionnelspe() != null) && 
      ("".equals(getCodeErreurOrganisateurOccasionnelspe()))) {
      return true;
    }
    if ((getCodeErreurTitulaireLabelPresta() != null) && 
      ("".equals(getCodeErreurTitulaireLabelPresta()))) {
      return true;
    }
    if ((getCodeErreurNumeroLabelPrestaSer() != null) && 
      ("".equals(getCodeErreurNumeroLabelPrestaSer()))) {
      return true;
    }
    if ((getCodeErreurNumAffiCaisseConges() != null) && 
      ("".equals(getCodeErreurNumAffiCaisseConges()))) {
      return true;
    }
    if ((getCodeErreurNomSalarie() != null) && 
      ("".equals(getCodeErreurNomSalarie()))) {
      return true;
    }
    if ((getCodeErreurPrenomSalarie() != null) && 
      ("".equals(getCodeErreurPrenomSalarie()))) {
      return true;
    }
    if ((getCodeErreurNomUsuel() != null) && 
      ("".equals(getCodeErreurNomUsuel()))) {
      return true;
    }
    if ((getCodeErreurTelephoneSalarie() != null) && 
      ("".equals(getCodeErreurTelephoneSalarie()))) {
      return true;
    }
    if ((getCodeErreurNIR() != null) && 
      ("".equals(getCodeErreurNIR()))) {
      return true;
    }
    if ((getCodeErreurAdresseSalarie() != null) && 
      ("".equals(getCodeErreurAdresseSalarie()))) {
      return true;
    }
    if ((getCodeErreurComplementAdresseSalarie() != null) && 
      ("".equals(getCodeErreurComplementAdresseSalarie()))) {
      return true;
    }
    if ((getCodeErreurCodePostalSalarie() != null) && 
      ("".equals(getCodeErreurCodePostalSalarie()))) {
      return true;
    }
    if ((getCodeErreurCommuneSalarie() != null) && 
      ("".equals(getCodeErreurCommuneSalarie()))) {
      return true;
    }
    if ((getCodeErreurLienParente() != null) && 
      ("".equals(getCodeErreurLienParente()))) {
      return true;
    }
    if ((getCodeErreurTypeLienParente() != null) && 
      ("".equals(getCodeErreurTypeLienParente()))) {
      return true;
    }
    if ((getCodeErreurCodeEmploiOccupe() != null) && 
      ("".equals(getCodeErreurCodeEmploiOccupe()))) {
      return true;
    }
    if ((getCodeErreurCodeQualification() != null) && 
      ("".equals(getCodeErreurCodeQualification()))) {
      return true;
    }
    if ((getCodeErreurRegimeRetraiteCompl() != null) && 
      ("".equals(getCodeErreurRegimeRetraiteCompl()))) {
      return true;
    }
    if ((getCodeErreurStatutCadre() != null) && 
      ("".equals(getCodeErreurStatutCadre()))) {
      return true;
    }
    if ((getCodeErreurContratEnCours() != null) && 
      ("".equals(getCodeErreurContratEnCours()))) {
      return true;
    }
    if ((getCodeErreurMotiFinContrat() != null) && 
      ("".equals(getCodeErreurMotiFinContrat()))) {
      return true;
    }
    if ((getCodeErreurNomEmployeur() != null) && 
      ("".equals(getCodeErreurNomEmployeur()))) {
      return true;
    }
    if ((getCodeErreurPrenomEmployeur() != null) && 
      ("".equals(getCodeErreurPrenomEmployeur()))) {
      return true;
    }
    if ((getCodeErreurQualite() != null) && 
      ("".equals(getCodeErreurQualite()))) {
      return true;
    }
    if ((getCodeErreurMotifRupture() != null) && 
      ("".equals(getCodeErreurMotifRupture()))) {
      return true;
    }
    if ((getCodeErreurCommuneSignature() != null) && 
      ("".equals(getCodeErreurCommuneSignature()))) {
      return true;
    }
    if ((getCodeErreurContactAEM() != null) && 
      ("".equals(getCodeErreurContactAEM()))) {
      return true;
    }
    if ((getCodeErreurTelephoneTiers() != null) && 
      ("".equals(getCodeErreurTelephoneTiers()))) {
      return true;
    }
    if ((getCodeErreurCodeOrganisme() != null) && 
      ("".equals(getCodeErreurCodeOrganisme()))) {
      return true;
    }
    if ((getCodeErreurNbJoursTravailles() != null) && 
      ("".equals(getCodeErreurNbJoursTravailles()))) {
      return true;
    }
    if ((getCodeErreurNumVersionAEM() != null) && 
      ("".equals(getCodeErreurNumVersionAEM()))) {
      return true;
    }
    if ((getCodeErreurAffiCaisseConges() != null) && 
      ("".equals(getCodeErreurAffiCaisseConges()))) {
      return true;
    }
    if ((getCodeErreurNumeroObjet() != null) && 
      ("".equals(getCodeErreurNumeroObjet()))) {
      return true;
    }
    if ((getCodeErreurIndicateurHorsChamp() != null) && 
      ("".equals(getCodeErreurIndicateurHorsChamp()))) {
      return true;
    }
    if ((getCodeErreurNouveauCodeApeNaf() != null) && 
      ("".equals(getCodeErreurNouveauCodeApeNaf()))) {
      return true;
    }
    if ((getCodeErreurDateNaissance() != null) && 
      ("".equals(getCodeErreurDateNaissance()))) {
      return true;
    }
    if ((getCodeErreurDateFincontrat() != null) && 
      ("".equals(getCodeErreurDateFincontrat()))) {
      return true;
    }
    if ((getCodeErreurDateEmbauche() != null) && 
      ("".equals(getCodeErreurDateEmbauche()))) {
      return true;
    }
    if ((getCodeErreurDateSignature() != null) && 
      ("".equals(getCodeErreurDateSignature()))) {
      return true;
    }
    if ((getCodeErreurDateFichierExt() != null) && 
      ("".equals(getCodeErreurDateFichierExt()))) {
      return true;
    }
    if ((getCodeErreurDateCreation() != null) && 
      ("".equals(getCodeErreurDateCreation()))) {
      return true;
    }
    if ((getCodeErreurDateInitialeFinCDD() != null) && 
      ("".equals(getCodeErreurDateInitialeFinCDD()))) {
      return true;
    }
    if ((getCodeErreurNbHeures() != null) && 
      ("".equals(getCodeErreurNbHeures()))) {
      return true;
    }
    if ((getCodeErreurNbCachets() != null) && 
      ("".equals(getCodeErreurNbCachets()))) {
      return true;
    }
    if ((getCodeErreurSalaireBrutAvtAbatt() != null) && 
      ("".equals(getCodeErreurSalaireBrutAvtAbatt()))) {
      return true;
    }
    if ((getCodeErreurSalaireBrutAprAbatt() != null) && 
      ("".equals(getCodeErreurSalaireBrutAprAbatt()))) {
      return true;
    }
    if ((getCodeErreurTauxAbatt() != null) && 
      ("".equals(getCodeErreurTauxAbatt()))) {
      return true;
    }
    if ((getCodeErreurContributionDues() != null) && 
      ("".equals(getCodeErreurContributionDues()))) {
      return true;
    }
    if ((getCodeErreurMoisActualisation() != null) && 
      ("".equals(getCodeErreurMoisActualisation()))) {
      return true;
    }
    if ((getCodeErreurAnneeActualisation() != null) && 
      ("".equals(getCodeErreurAnneeActualisation()))) {
      return true;
    }
    if ((getCodeErreurNbCachetsIsoles() != null) && 
      ("".equals(getCodeErreurNbCachetsIsoles()))) {
      return true;
    }
    if ((getCodeErreurNbCachetsGroupes() != null) && 
      ("".equals(getCodeErreurNbCachetsGroupes()))) {
      return true;
    }
    if ((getCodeErreurAutresRemunerationsMontantBrut() != null) && 
      ("".equals(getCodeErreurAutresRemunerationsMontantBrut()))) {
      return true;
    }
    if ((getCodeErreurAutresRemunerationsTauxContributions() != null) && 
      ("".equals(getCodeErreurAutresRemunerationsTauxContributions()))) {
      return true;
    }
    if ((getCodeErreurAutresRemunerationsContributionsDues() != null) && 
      ("".equals(getCodeErreurAutresRemunerationsContributionsDues()))) {
      return true;
    }
    if ((getCodeErreurTotalContributionsDues() != null) && 
      ("".equals(getCodeErreurTotalContributionsDues()))) {
      return true;
    }
    if ((getCodeErreurBneCertifSociale() != null) && 
      ("".equals(getCodeErreurBneCertifSociale()))) {
      return true;
    }
    if ((getCodeErreurIdccEmployeur() != null) && 
      ("".equals(getCodeErreurIdccEmployeur()))) {
      return true;
    }
    if ((getCodeErreurIdccPrestation() != null) && 
      ("".equals(getCodeErreurIdccPrestation()))) {
      return true;
    }
    if ((getCodeErreurRessortissant() != null) && 
      ("".equals(getCodeErreurRessortissant()))) {
      return true;
    }
    if ((getCodeErreurIndicateurCertifSociale() != null) && 
      ("".equals(getCodeErreurIndicateurCertifSociale()))) {
      return true;
    }
    if ((getCodeErreurNumCertifSociale() != null) && 
      ("".equals(getCodeErreurNumCertifSociale()))) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _FluxAEMImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */