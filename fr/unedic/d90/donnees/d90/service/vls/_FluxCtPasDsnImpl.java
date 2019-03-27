package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import fr.unedic.util.temps.Damj;
import java.io.Serializable;
import java.math.BigDecimal;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _FluxCtPasDsnImpl
  extends FluxCtPasDsn
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _FluxCtPasDsn m_fluxCtPasDsnInfra;
  
  public _FluxCtPasDsnImpl()
  {
    m_fluxCtPasDsnInfra = new _FluxCtPasDsn();
  }
  
  public _FluxCtPasDsnImpl(_FluxCtPasDsn pValeur)
  {
    ExceptionUtil.assertMethodParamNotNull("FluxCtPasDsnInfra", pValeur);
    
    m_fluxCtPasDsnInfra = pValeur;
  }
  
  public Object getObjet()
  {
    return m_fluxCtPasDsnInfra;
  }
  
  public String getIdentifiant()
  {
    return m_fluxCtPasDsnInfra.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_fluxCtPasDsnInfra.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_fluxCtPasDsnInfra.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_fluxCtPasDsnInfra.set_C_ETAT(pCode);
  }
  
  public String getTypeEnreg()
  {
    return m_fluxCtPasDsnInfra.getTypeEnreg();
  }
  
  public String getCodeErreurTypeEnreg()
  {
    return m_fluxCtPasDsnInfra.getTypeEnreg_C_ERR();
  }
  
  public void setTypeEnreg(String pValeur)
  {
    m_fluxCtPasDsnInfra.setTypeEnreg(pValeur);
  }
  
  public void setCodeErreurTypeEnreg(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setTypeEnreg_C_ERR(pCodeErreur);
  }
  
  public String getNumNIRCertifie()
  {
    return m_fluxCtPasDsnInfra.getNumNIRCertifie();
  }
  
  public String getCodeErreurNumNIRCertifie()
  {
    return m_fluxCtPasDsnInfra.getNumNIRCertifie_C_ERR();
  }
  
  public void setNumNIRCertifie(String pValeur)
  {
    m_fluxCtPasDsnInfra.setNumNIRCertifie(pValeur);
  }
  
  public void setCodeErreurNumNIRCertifie(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setNumNIRCertifie_C_ERR(pCodeErreur);
  }
  
  public String getNomDeclare()
  {
    return m_fluxCtPasDsnInfra.getNomDeclare();
  }
  
  public String getCodeErreurNomDeclare()
  {
    return m_fluxCtPasDsnInfra.getNomDeclare_C_ERR();
  }
  
  public void setNomDeclare(String pValeur)
  {
    m_fluxCtPasDsnInfra.setNomDeclare(pValeur);
  }
  
  public void setCodeErreurNomDeclare(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setNomDeclare_C_ERR(pCodeErreur);
  }
  
  public String getPrenomDeclare()
  {
    return m_fluxCtPasDsnInfra.getPrenomDeclare();
  }
  
  public String getCodeErreurPrenomDeclare()
  {
    return m_fluxCtPasDsnInfra.getPrenomDeclare_C_ERR();
  }
  
  public void setPrenomDeclare(String pValeur)
  {
    m_fluxCtPasDsnInfra.setPrenomDeclare(pValeur);
  }
  
  public void setCodeErreurPrenomDeclare(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setPrenomDeclare_C_ERR(pCodeErreur);
  }
  
  public Damj getDateNaissance()
  {
    return m_fluxCtPasDsnInfra.getDateNaissance();
  }
  
  public String getCodeErreurDateNaissance()
  {
    return m_fluxCtPasDsnInfra.getDateNaissance_C_ERR();
  }
  
  public void setDateNaissance(Damj pValeur)
  {
    m_fluxCtPasDsnInfra.setDateNaissance(pValeur);
  }
  
  public void setCodeErreurDateNaissance(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setDateNaissance_C_ERR(pCodeErreur);
  }
  
  public String getContexteEmission()
  {
    return m_fluxCtPasDsnInfra.getContexteEmission();
  }
  
  public String getCodeErreurContexteEmission()
  {
    return m_fluxCtPasDsnInfra.getContexteEmission_C_ERR();
  }
  
  public void setContexteEmission(String pValeur)
  {
    m_fluxCtPasDsnInfra.setContexteEmission(pValeur);
  }
  
  public void setCodeErreurContexteEmission(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setContexteEmission_C_ERR(pCodeErreur);
  }
  
  public String getNatureJustificatif()
  {
    return m_fluxCtPasDsnInfra.getNatureJustificatif();
  }
  
  public String getCodeErreurNatureJustificatif()
  {
    return m_fluxCtPasDsnInfra.getNatureJustificatif_C_ERR();
  }
  
  public void setNatureJustificatif(String pValeur)
  {
    m_fluxCtPasDsnInfra.setNatureJustificatif(pValeur);
  }
  
  public void setCodeErreurNatureJustificatif(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setNatureJustificatif_C_ERR(pCodeErreur);
  }
  
  public String getCodeMessage()
  {
    return m_fluxCtPasDsnInfra.getCodeMessage();
  }
  
  public String getCodeErreurCodeMessage()
  {
    return m_fluxCtPasDsnInfra.getCodeMessage_C_ERR();
  }
  
  public void setCodeMessage(String pValeur)
  {
    m_fluxCtPasDsnInfra.setCodeMessage(pValeur);
  }
  
  public void setCodeErreurCodeMessage(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setCodeMessage_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getNumeroVersion()
  {
    return m_fluxCtPasDsnInfra.getNumeroVersion();
  }
  
  public String getCodeErreurNumeroVersion()
  {
    return m_fluxCtPasDsnInfra.getNumeroVersion_C_ERR();
  }
  
  public void setNumeroVersion(BigDecimal pValeur)
  {
    m_fluxCtPasDsnInfra.setNumeroVersion(pValeur);
  }
  
  public void setCodeErreurNumeroVersion(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setNumeroVersion_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getNumeroSousVersion()
  {
    return m_fluxCtPasDsnInfra.getNumeroSousVersion();
  }
  
  public String getCodeErreurNumeroSousVersion()
  {
    return m_fluxCtPasDsnInfra.getNumeroSousVersion_C_ERR();
  }
  
  public void setNumeroSousVersion(BigDecimal pValeur)
  {
    m_fluxCtPasDsnInfra.setNumeroSousVersion(pValeur);
  }
  
  public void setCodeErreurNumeroSousVersion(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setNumeroSousVersion_C_ERR(pCodeErreur);
  }
  
  public String getCodeAction()
  {
    return m_fluxCtPasDsnInfra.getCodeAction();
  }
  
  public String getCodeErreurCodeAction()
  {
    return m_fluxCtPasDsnInfra.getCodeAction_C_ERR();
  }
  
  public void setCodeAction(String pValeur)
  {
    m_fluxCtPasDsnInfra.setCodeAction(pValeur);
  }
  
  public void setCodeErreurCodeAction(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setCodeAction_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getIdTechnique()
  {
    return m_fluxCtPasDsnInfra.getIdTechnique();
  }
  
  public String getCodeErreurIdTechnique()
  {
    return m_fluxCtPasDsnInfra.getIdTechnique_C_ERR();
  }
  
  public void setIdTechnique(BigDecimal pValeur)
  {
    m_fluxCtPasDsnInfra.setIdTechnique(pValeur);
  }
  
  public void setCodeErreurIdTechnique(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setIdTechnique_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getIdRCE()
  {
    return m_fluxCtPasDsnInfra.getIdRCE();
  }
  
  public String getCodeErreurIdRCE()
  {
    return m_fluxCtPasDsnInfra.getIdRCE_C_ERR();
  }
  
  public void setIdRCE(BigDecimal pValeur)
  {
    m_fluxCtPasDsnInfra.setIdRCE(pValeur);
  }
  
  public void setCodeErreurIdRCE(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setIdRCE_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getSiretDeclare()
  {
    return m_fluxCtPasDsnInfra.getSiretDeclare();
  }
  
  public String getCodeErreurSiretDeclare()
  {
    return m_fluxCtPasDsnInfra.getSiretDeclare_C_ERR();
  }
  
  public void setSiretDeclare(BigDecimal pValeur)
  {
    m_fluxCtPasDsnInfra.setSiretDeclare(pValeur);
  }
  
  public void setCodeErreurSiretDeclare(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setSiretDeclare_C_ERR(pCodeErreur);
  }
  
  public String getRefContratEmployeur()
  {
    return m_fluxCtPasDsnInfra.getRefContratEmployeur();
  }
  
  public String getCodeErreurRefContratEmployeur()
  {
    return m_fluxCtPasDsnInfra.getRefContratEmployeur_C_ERR();
  }
  
  public void setRefContratEmployeur(String pValeur)
  {
    m_fluxCtPasDsnInfra.setRefContratEmployeur(pValeur);
  }
  
  public void setCodeErreurRefContratEmployeur(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setRefContratEmployeur_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getNbMessagesPrimesIndemnites()
  {
    return m_fluxCtPasDsnInfra.getNbMessagesPrimesIndemnites();
  }
  
  public String getCodeErreurNbMessagesPrimesIndemnites()
  {
    return m_fluxCtPasDsnInfra.getNbMessagesPrimesIndemnites_C_ERR();
  }
  
  public void setNbMessagesPrimesIndemnites(BigDecimal pValeur)
  {
    m_fluxCtPasDsnInfra.setNbMessagesPrimesIndemnites(pValeur);
  }
  
  public void setCodeErreurNbMessagesPrimesIndemnites(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setNbMessagesPrimesIndemnites_C_ERR(pCodeErreur);
  }
  
  public Damj getDateConnaissanceMensuelle()
  {
    return m_fluxCtPasDsnInfra.getDateConnaissanceMensuelle();
  }
  
  public String getCodeErreurDateConnaissanceMensuelle()
  {
    return m_fluxCtPasDsnInfra.getDateConnaissanceMensuelle_C_ERR();
  }
  
  public void setDateConnaissanceMensuelle(Damj pValeur)
  {
    m_fluxCtPasDsnInfra.setDateConnaissanceMensuelle(pValeur);
  }
  
  public void setCodeErreurDateConnaissanceMensuelle(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setDateConnaissanceMensuelle_C_ERR(pCodeErreur);
  }
  
  public Damj getDateMoisDeclare()
  {
    return m_fluxCtPasDsnInfra.getDateMoisDeclare();
  }
  
  public String getCodeErreurDateMoisDeclare()
  {
    return m_fluxCtPasDsnInfra.getDateMoisDeclare_C_ERR();
  }
  
  public void setDateMoisDeclare(Damj pValeur)
  {
    m_fluxCtPasDsnInfra.setDateMoisDeclare(pValeur);
  }
  
  public void setCodeErreurDateMoisDeclare(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setDateMoisDeclare_C_ERR(pCodeErreur);
  }
  
  public Damj getDateDebutContrat()
  {
    return m_fluxCtPasDsnInfra.getDateDebutContrat();
  }
  
  public String getCodeErreurDateDebutContrat()
  {
    return m_fluxCtPasDsnInfra.getDateDebutContrat_C_ERR();
  }
  
  public void setDateDebutContrat(Damj pValeur)
  {
    m_fluxCtPasDsnInfra.setDateDebutContrat(pValeur);
  }
  
  public void setCodeErreurDateDebutContrat(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setDateDebutContrat_C_ERR(pCodeErreur);
  }
  
  public Damj getDateFinContrat()
  {
    return m_fluxCtPasDsnInfra.getDateFinContrat();
  }
  
  public String getCodeErreurDateFinContrat()
  {
    return m_fluxCtPasDsnInfra.getDateFinContrat_C_ERR();
  }
  
  public void setDateFinContrat(Damj pValeur)
  {
    m_fluxCtPasDsnInfra.setDateFinContrat(pValeur);
  }
  
  public void setCodeErreurDateFinContrat(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setDateFinContrat_C_ERR(pCodeErreur);
  }
  
  public String getNatureContrat()
  {
    return m_fluxCtPasDsnInfra.getNatureContrat();
  }
  
  public String getCodeErreurNatureContrat()
  {
    return m_fluxCtPasDsnInfra.getNatureContrat_C_ERR();
  }
  
  public void setNatureContrat(String pValeur)
  {
    m_fluxCtPasDsnInfra.setNatureContrat(pValeur);
  }
  
  public void setCodeErreurNatureContrat(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setNatureContrat_C_ERR(pCodeErreur);
  }
  
  public String getTypeContrat()
  {
    return m_fluxCtPasDsnInfra.getTypeContrat();
  }
  
  public String getCodeErreurTypeContrat()
  {
    return m_fluxCtPasDsnInfra.getTypeContrat_C_ERR();
  }
  
  public void setTypeContrat(String pValeur)
  {
    m_fluxCtPasDsnInfra.setTypeContrat(pValeur);
  }
  
  public void setCodeErreurTypeContrat(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setTypeContrat_C_ERR(pCodeErreur);
  }
  
  public String getCodeStatutCadre()
  {
    return m_fluxCtPasDsnInfra.getCodeStatutCadre();
  }
  
  public String getCodeErreurCodeStatutCadre()
  {
    return m_fluxCtPasDsnInfra.getCodeStatutCadre_C_ERR();
  }
  
  public void setCodeStatutCadre(String pValeur)
  {
    m_fluxCtPasDsnInfra.setCodeStatutCadre(pValeur);
  }
  
  public void setCodeErreurCodeStatutCadre(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setCodeStatutCadre_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getHoraireSalarie()
  {
    return m_fluxCtPasDsnInfra.getHoraireSalarie();
  }
  
  public String getCodeErreurHoraireSalarie()
  {
    return m_fluxCtPasDsnInfra.getHoraireSalarie_C_ERR();
  }
  
  public void setHoraireSalarie(BigDecimal pValeur)
  {
    m_fluxCtPasDsnInfra.setHoraireSalarie(pValeur);
  }
  
  public void setCodeErreurHoraireSalarie(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setHoraireSalarie_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getHoraireEntreprise()
  {
    return m_fluxCtPasDsnInfra.getHoraireEntreprise();
  }
  
  public String getCodeErreurHoraireEntreprise()
  {
    return m_fluxCtPasDsnInfra.getHoraireEntreprise_C_ERR();
  }
  
  public void setHoraireEntreprise(BigDecimal pValeur)
  {
    m_fluxCtPasDsnInfra.setHoraireEntreprise(pValeur);
  }
  
  public void setCodeErreurHoraireEntreprise(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setHoraireEntreprise_C_ERR(pCodeErreur);
  }
  
  public String getUniteTempsTravail()
  {
    return m_fluxCtPasDsnInfra.getUniteTempsTravail();
  }
  
  public String getCodeErreurUniteTempsTravail()
  {
    return m_fluxCtPasDsnInfra.getUniteTempsTravail_C_ERR();
  }
  
  public void setUniteTempsTravail(String pValeur)
  {
    m_fluxCtPasDsnInfra.setUniteTempsTravail(pValeur);
  }
  
  public void setCodeErreurUniteTempsTravail(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setUniteTempsTravail_C_ERR(pCodeErreur);
  }
  
  public String getAlsaceMoselle()
  {
    return m_fluxCtPasDsnInfra.getAlsaceMoselle();
  }
  
  public String getCodeErreurAlsaceMoselle()
  {
    return m_fluxCtPasDsnInfra.getAlsaceMoselle_C_ERR();
  }
  
  public void setAlsaceMoselle(String pValeur)
  {
    m_fluxCtPasDsnInfra.setAlsaceMoselle(pValeur);
  }
  
  public void setCodeErreurAlsaceMoselle(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setAlsaceMoselle_C_ERR(pCodeErreur);
  }
  
  public String getRegimeSpecialSecuriteSoc()
  {
    return m_fluxCtPasDsnInfra.getRegimeSpecialSecuriteSoc();
  }
  
  public String getCodeErreurRegimeSpecialSecuriteSoc()
  {
    return m_fluxCtPasDsnInfra.getRegimeSpecialSecuriteSoc_C_ERR();
  }
  
  public void setRegimeSpecialSecuriteSoc(String pValeur)
  {
    m_fluxCtPasDsnInfra.setRegimeSpecialSecuriteSoc(pValeur);
  }
  
  public void setCodeErreurRegimeSpecialSecuriteSoc(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setRegimeSpecialSecuriteSoc_C_ERR(pCodeErreur);
  }
  
  public String getTypeCaisseCP()
  {
    return m_fluxCtPasDsnInfra.getTypeCaisseCP();
  }
  
  public String getCodeErreurTypeCaisseCP()
  {
    return m_fluxCtPasDsnInfra.getTypeCaisseCP_C_ERR();
  }
  
  public void setTypeCaisseCP(String pValeur)
  {
    m_fluxCtPasDsnInfra.setTypeCaisseCP(pValeur);
  }
  
  public void setCodeErreurTypeCaisseCP(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setTypeCaisseCP_C_ERR(pCodeErreur);
  }
  
  public String getNiveauQualification()
  {
    return m_fluxCtPasDsnInfra.getNiveauQualification();
  }
  
  public String getCodeErreurNiveauQualification()
  {
    return m_fluxCtPasDsnInfra.getNiveauQualification_C_ERR();
  }
  
  public void setNiveauQualification(String pValeur)
  {
    m_fluxCtPasDsnInfra.setNiveauQualification(pValeur);
  }
  
  public void setCodeErreurNiveauQualification(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setNiveauQualification_C_ERR(pCodeErreur);
  }
  
  public String getCodeCaisseRetraiteCompl()
  {
    return m_fluxCtPasDsnInfra.getCodeCaisseRetraiteCompl();
  }
  
  public String getCodeErreurCodeCaisseRetraiteCompl()
  {
    return m_fluxCtPasDsnInfra.getCodeCaisseRetraiteCompl_C_ERR();
  }
  
  public void setCodeCaisseRetraiteCompl(String pValeur)
  {
    m_fluxCtPasDsnInfra.setCodeCaisseRetraiteCompl(pValeur);
  }
  
  public void setCodeErreurCodeCaisseRetraiteCompl(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setCodeCaisseRetraiteCompl_C_ERR(pCodeErreur);
  }
  
  public String getChampApplicationEmployeur()
  {
    return m_fluxCtPasDsnInfra.getChampApplicationEmployeur();
  }
  
  public String getCodeErreurChampApplicationEmployeur()
  {
    return m_fluxCtPasDsnInfra.getChampApplicationEmployeur_C_ERR();
  }
  
  public void setChampApplicationEmployeur(String pValeur)
  {
    m_fluxCtPasDsnInfra.setChampApplicationEmployeur(pValeur);
  }
  
  public void setCodeErreurChampApplicationEmployeur(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setChampApplicationEmployeur_C_ERR(pCodeErreur);
  }
  
  public String getNumConventionGestionEmpPublic()
  {
    return m_fluxCtPasDsnInfra.getNumConventionGestionEmpPublic();
  }
  
  public String getCodeErreurNumConventionGestionEmpPublic()
  {
    return m_fluxCtPasDsnInfra.getNumConventionGestionEmpPublic_C_ERR();
  }
  
  public void setNumConventionGestionEmpPublic(String pValeur)
  {
    m_fluxCtPasDsnInfra.setNumConventionGestionEmpPublic(pValeur);
  }
  
  public void setCodeErreurNumConventionGestionEmpPublic(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setNumConventionGestionEmpPublic_C_ERR(pCodeErreur);
  }
  
  public String getEtablissementFinancier()
  {
    return m_fluxCtPasDsnInfra.getEtablissementFinancier();
  }
  
  public String getCodeErreurEtablissementFinancier()
  {
    return m_fluxCtPasDsnInfra.getEtablissementFinancier_C_ERR();
  }
  
  public void setEtablissementFinancier(String pValeur)
  {
    m_fluxCtPasDsnInfra.setEtablissementFinancier(pValeur);
  }
  
  public void setCodeErreurEtablissementFinancier(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setEtablissementFinancier_C_ERR(pCodeErreur);
  }
  
  public String getCodeAffectation()
  {
    return m_fluxCtPasDsnInfra.getCodeAffectation();
  }
  
  public String getCodeErreurCodeAffectation()
  {
    return m_fluxCtPasDsnInfra.getCodeAffectation_C_ERR();
  }
  
  public void setCodeAffectation(String pValeur)
  {
    m_fluxCtPasDsnInfra.setCodeAffectation(pValeur);
  }
  
  public void setCodeErreurCodeAffectation(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setCodeAffectation_C_ERR(pCodeErreur);
  }
  
  public String getNumInterneEmpPublic()
  {
    return m_fluxCtPasDsnInfra.getNumInterneEmpPublic();
  }
  
  public String getCodeErreurNumInterneEmpPublic()
  {
    return m_fluxCtPasDsnInfra.getNumInterneEmpPublic_C_ERR();
  }
  
  public void setNumInterneEmpPublic(String pValeur)
  {
    m_fluxCtPasDsnInfra.setNumInterneEmpPublic(pValeur);
  }
  
  public void setCodeErreurNumInterneEmpPublic(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setNumInterneEmpPublic_C_ERR(pCodeErreur);
  }
  
  public String getStatutSalarie()
  {
    return m_fluxCtPasDsnInfra.getStatutSalarie();
  }
  
  public String getCodeErreurStatutSalarie()
  {
    return m_fluxCtPasDsnInfra.getStatutSalarie_C_ERR();
  }
  
  public void setStatutSalarie(String pValeur)
  {
    m_fluxCtPasDsnInfra.setStatutSalarie(pValeur);
  }
  
  public void setCodeErreurStatutSalarie(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setStatutSalarie_C_ERR(pCodeErreur);
  }
  
  public Damj getDateAdhesion()
  {
    return m_fluxCtPasDsnInfra.getDateAdhesion();
  }
  
  public String getCodeErreurDateAdhesion()
  {
    return m_fluxCtPasDsnInfra.getDateAdhesion_C_ERR();
  }
  
  public void setDateAdhesion(Damj pValeur)
  {
    m_fluxCtPasDsnInfra.setDateAdhesion(pValeur);
  }
  
  public void setCodeErreurDateAdhesion(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setDateAdhesion_C_ERR(pCodeErreur);
  }
  
  public String getMotifPeriodeInactivite()
  {
    return m_fluxCtPasDsnInfra.getMotifPeriodeInactivite();
  }
  
  public String getCodeErreurMotifPeriodeInactivite()
  {
    return m_fluxCtPasDsnInfra.getMotifPeriodeInactivite_C_ERR();
  }
  
  public void setMotifPeriodeInactivite(String pValeur)
  {
    m_fluxCtPasDsnInfra.setMotifPeriodeInactivite(pValeur);
  }
  
  public void setCodeErreurMotifPeriodeInactivite(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setMotifPeriodeInactivite_C_ERR(pCodeErreur);
  }
  
  public Damj getDateDebutPeriodeInactivite()
  {
    return m_fluxCtPasDsnInfra.getDateDebutPeriodeInactivite();
  }
  
  public String getCodeErreurDateDebutPeriodeInactivite()
  {
    return m_fluxCtPasDsnInfra.getDateDebutPeriodeInactivite_C_ERR();
  }
  
  public void setDateDebutPeriodeInactivite(Damj pValeur)
  {
    m_fluxCtPasDsnInfra.setDateDebutPeriodeInactivite(pValeur);
  }
  
  public void setCodeErreurDateDebutPeriodeInactivite(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setDateDebutPeriodeInactivite_C_ERR(pCodeErreur);
  }
  
  public Damj getDateFinPeriodeInactivite()
  {
    return m_fluxCtPasDsnInfra.getDateFinPeriodeInactivite();
  }
  
  public String getCodeErreurDateFinPeriodeInactivite()
  {
    return m_fluxCtPasDsnInfra.getDateFinPeriodeInactivite_C_ERR();
  }
  
  public void setDateFinPeriodeInactivite(Damj pValeur)
  {
    m_fluxCtPasDsnInfra.setDateFinPeriodeInactivite(pValeur);
  }
  
  public void setCodeErreurDateFinPeriodeInactivite(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setDateFinPeriodeInactivite_C_ERR(pCodeErreur);
  }
  
  public Damj getDateDebutPeriodeSalaire()
  {
    return m_fluxCtPasDsnInfra.getDateDebutPeriodeSalaire();
  }
  
  public String getCodeErreurDateDebutPeriodeSalaire()
  {
    return m_fluxCtPasDsnInfra.getDateDebutPeriodeSalaire_C_ERR();
  }
  
  public void setDateDebutPeriodeSalaire(Damj pValeur)
  {
    m_fluxCtPasDsnInfra.setDateDebutPeriodeSalaire(pValeur);
  }
  
  public void setCodeErreurDateDebutPeriodeSalaire(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setDateDebutPeriodeSalaire_C_ERR(pCodeErreur);
  }
  
  public Damj getDateFinPeriodeSalaire()
  {
    return m_fluxCtPasDsnInfra.getDateFinPeriodeSalaire();
  }
  
  public String getCodeErreurDateFinPeriodeSalaire()
  {
    return m_fluxCtPasDsnInfra.getDateFinPeriodeSalaire_C_ERR();
  }
  
  public void setDateFinPeriodeSalaire(Damj pValeur)
  {
    m_fluxCtPasDsnInfra.setDateFinPeriodeSalaire(pValeur);
  }
  
  public void setCodeErreurDateFinPeriodeSalaire(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setDateFinPeriodeSalaire_C_ERR(pCodeErreur);
  }
  
  public String getCodePcsEse()
  {
    return m_fluxCtPasDsnInfra.getCodePcsEse();
  }
  
  public String getCodeErreurCodePcsEse()
  {
    return m_fluxCtPasDsnInfra.getCodePcsEse_C_ERR();
  }
  
  public void setCodePcsEse(String pValeur)
  {
    m_fluxCtPasDsnInfra.setCodePcsEse(pValeur);
  }
  
  public void setCodeErreurCodePcsEse(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setCodePcsEse_C_ERR(pCodeErreur);
  }
  
  public String getCodeComplementPcsEse()
  {
    return m_fluxCtPasDsnInfra.getCodeComplementPcsEse();
  }
  
  public String getCodeErreurCodeComplementPcsEse()
  {
    return m_fluxCtPasDsnInfra.getCodeComplementPcsEse_C_ERR();
  }
  
  public void setCodeComplementPcsEse(String pValeur)
  {
    m_fluxCtPasDsnInfra.setCodeComplementPcsEse(pValeur);
  }
  
  public void setCodeErreurCodeComplementPcsEse(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setCodeComplementPcsEse_C_ERR(pCodeErreur);
  }
  
  public String getSigneSalaireBrutAbattu()
  {
    return m_fluxCtPasDsnInfra.getSigneSalaireBrutAbattu();
  }
  
  public String getCodeErreurSigneSalaireBrutAbattu()
  {
    return m_fluxCtPasDsnInfra.getSigneSalaireBrutAbattu_C_ERR();
  }
  
  public void setSigneSalaireBrutAbattu(String pValeur)
  {
    m_fluxCtPasDsnInfra.setSigneSalaireBrutAbattu(pValeur);
  }
  
  public void setCodeErreurSigneSalaireBrutAbattu(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setSigneSalaireBrutAbattu_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getSalaireBrutAbattu()
  {
    return m_fluxCtPasDsnInfra.getSalaireBrutAbattu();
  }
  
  public String getCodeErreurSalaireBrutAbattu()
  {
    return m_fluxCtPasDsnInfra.getSalaireBrutAbattu_C_ERR();
  }
  
  public void setSalaireBrutAbattu(BigDecimal pValeur)
  {
    m_fluxCtPasDsnInfra.setSalaireBrutAbattu(pValeur);
  }
  
  public void setCodeErreurSalaireBrutAbattu(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setSalaireBrutAbattu_C_ERR(pCodeErreur);
  }
  
  public Damj getDatePaiement()
  {
    return m_fluxCtPasDsnInfra.getDatePaiement();
  }
  
  public String getCodeErreurDatePaiement()
  {
    return m_fluxCtPasDsnInfra.getDatePaiement_C_ERR();
  }
  
  public void setDatePaiement(Damj pValeur)
  {
    m_fluxCtPasDsnInfra.setDatePaiement(pValeur);
  }
  
  public void setCodeErreurDatePaiement(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setDatePaiement_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getDureeAbsence()
  {
    return m_fluxCtPasDsnInfra.getDureeAbsence();
  }
  
  public String getCodeErreurDureeAbsence()
  {
    return m_fluxCtPasDsnInfra.getDureeAbsence_C_ERR();
  }
  
  public void setDureeAbsence(BigDecimal pValeur)
  {
    m_fluxCtPasDsnInfra.setDureeAbsence(pValeur);
  }
  
  public void setCodeErreurDureeAbsence(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setDureeAbsence_C_ERR(pCodeErreur);
  }
  
  public String getUniteAbsence()
  {
    return m_fluxCtPasDsnInfra.getUniteAbsence();
  }
  
  public String getCodeErreurUniteAbsence()
  {
    return m_fluxCtPasDsnInfra.getUniteAbsence_C_ERR();
  }
  
  public void setUniteAbsence(String pValeur)
  {
    m_fluxCtPasDsnInfra.setUniteAbsence(pValeur);
  }
  
  public void setCodeErreurUniteAbsence(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setUniteAbsence_C_ERR(pCodeErreur);
  }
  
  public String getNomLogiciel()
  {
    return m_fluxCtPasDsnInfra.getNomLogiciel();
  }
  
  public String getCodeErreurNomLogiciel()
  {
    return m_fluxCtPasDsnInfra.getNomLogiciel_C_ERR();
  }
  
  public void setNomLogiciel(String pValeur)
  {
    m_fluxCtPasDsnInfra.setNomLogiciel(pValeur);
  }
  
  public void setCodeErreurNomLogiciel(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setNomLogiciel_C_ERR(pCodeErreur);
  }
  
  public String getVersionLogiciel()
  {
    return m_fluxCtPasDsnInfra.getVersionLogiciel();
  }
  
  public String getCodeErreurVersionLogiciel()
  {
    return m_fluxCtPasDsnInfra.getVersionLogiciel_C_ERR();
  }
  
  public void setVersionLogiciel(String pValeur)
  {
    m_fluxCtPasDsnInfra.setVersionLogiciel(pValeur);
  }
  
  public void setCodeErreurVersionLogiciel(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setVersionLogiciel_C_ERR(pCodeErreur);
  }
  
  public String getNumeroRCI()
  {
    return m_fluxCtPasDsnInfra.getNumeroRCI();
  }
  
  public String getCodeErreurNumeroRCI()
  {
    return m_fluxCtPasDsnInfra.getNumeroRCI_C_ERR();
  }
  
  public void setNumeroRCI(String pValeur)
  {
    m_fluxCtPasDsnInfra.setNumeroRCI(pValeur);
  }
  
  public void setCodeErreurNumeroRCI(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setNumeroRCI_C_ERR(pCodeErreur);
  }
  
  public String getCxass()
  {
    return m_fluxCtPasDsnInfra.getCxass();
  }
  
  public String getCodeErreurCxass()
  {
    return m_fluxCtPasDsnInfra.getCxass_C_ERR();
  }
  
  public void setCxass(String pValeur)
  {
    m_fluxCtPasDsnInfra.setCxass(pValeur);
  }
  
  public void setCodeErreurCxass(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setCxass_C_ERR(pCodeErreur);
  }
  
  public String getRsin()
  {
    return m_fluxCtPasDsnInfra.getRsin();
  }
  
  public String getCodeErreurRsin()
  {
    return m_fluxCtPasDsnInfra.getRsin_C_ERR();
  }
  
  public void setRsin(String pValeur)
  {
    m_fluxCtPasDsnInfra.setRsin(pValeur);
  }
  
  public void setCodeErreurRsin(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setRsin_C_ERR(pCodeErreur);
  }
  
  public String getNom()
  {
    return m_fluxCtPasDsnInfra.getNom();
  }
  
  public String getCodeErreurNom()
  {
    return m_fluxCtPasDsnInfra.getNom_C_ERR();
  }
  
  public void setNom(String pValeur)
  {
    m_fluxCtPasDsnInfra.setNom(pValeur);
  }
  
  public void setCodeErreurNom(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setNom_C_ERR(pCodeErreur);
  }
  
  public String getPrenom()
  {
    return m_fluxCtPasDsnInfra.getPrenom();
  }
  
  public String getCodeErreurPrenom()
  {
    return m_fluxCtPasDsnInfra.getPrenom_C_ERR();
  }
  
  public void setPrenom(String pValeur)
  {
    m_fluxCtPasDsnInfra.setPrenom(pValeur);
  }
  
  public void setCodeErreurPrenom(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setPrenom_C_ERR(pCodeErreur);
  }
  
  public String getPeAffi()
  {
    return m_fluxCtPasDsnInfra.getPeAffi();
  }
  
  public String getCodeErreurPeAffi()
  {
    return m_fluxCtPasDsnInfra.getPeAffi_C_ERR();
  }
  
  public void setPeAffi(String pValeur)
  {
    m_fluxCtPasDsnInfra.setPeAffi(pValeur);
  }
  
  public void setCodeErreurPeAffi(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setPeAffi_C_ERR(pCodeErreur);
  }
  
  public String getSiret()
  {
    return m_fluxCtPasDsnInfra.getSiret();
  }
  
  public String getCodeErreurSiret()
  {
    return m_fluxCtPasDsnInfra.getSiret_C_ERR();
  }
  
  public void setSiret(String pValeur)
  {
    m_fluxCtPasDsnInfra.setSiret(pValeur);
  }
  
  public void setCodeErreurSiret(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setSiret_C_ERR(pCodeErreur);
  }
  
  public String getEmplNumAffi()
  {
    return m_fluxCtPasDsnInfra.getEmplNumAffi();
  }
  
  public String getCodeErreurEmplNumAffi()
  {
    return m_fluxCtPasDsnInfra.getEmplNumAffi_C_ERR();
  }
  
  public void setEmplNumAffi(String pValeur)
  {
    m_fluxCtPasDsnInfra.setEmplNumAffi(pValeur);
  }
  
  public void setCodeErreurEmplNumAffi(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setEmplNumAffi_C_ERR(pCodeErreur);
  }
  
  public String getEmplRaisonSociale()
  {
    return m_fluxCtPasDsnInfra.getEmplRaisonSociale();
  }
  
  public String getCodeErreurEmplRaisonSociale()
  {
    return m_fluxCtPasDsnInfra.getEmplRaisonSociale_C_ERR();
  }
  
  public void setEmplRaisonSociale(String pValeur)
  {
    m_fluxCtPasDsnInfra.setEmplRaisonSociale(pValeur);
  }
  
  public void setCodeErreurEmplRaisonSociale(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setEmplRaisonSociale_C_ERR(pCodeErreur);
  }
  
  public String getEmplNAF()
  {
    return m_fluxCtPasDsnInfra.getEmplNAF();
  }
  
  public String getCodeErreurEmplNAF()
  {
    return m_fluxCtPasDsnInfra.getEmplNAF_C_ERR();
  }
  
  public void setEmplNAF(String pValeur)
  {
    m_fluxCtPasDsnInfra.setEmplNAF(pValeur);
  }
  
  public void setCodeErreurEmplNAF(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setEmplNAF_C_ERR(pCodeErreur);
  }
  
  public String getEmplCommune()
  {
    return m_fluxCtPasDsnInfra.getEmplCommune();
  }
  
  public String getCodeErreurEmplCommune()
  {
    return m_fluxCtPasDsnInfra.getEmplCommune_C_ERR();
  }
  
  public void setEmplCommune(String pValeur)
  {
    m_fluxCtPasDsnInfra.setEmplCommune(pValeur);
  }
  
  public void setCodeErreurEmplCommune(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setEmplCommune_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getEmplCP()
  {
    return m_fluxCtPasDsnInfra.getEmplCP();
  }
  
  public String getCodeErreurEmplCP()
  {
    return m_fluxCtPasDsnInfra.getEmplCP_C_ERR();
  }
  
  public void setEmplCP(BigDecimal pValeur)
  {
    m_fluxCtPasDsnInfra.setEmplCP(pValeur);
  }
  
  public void setCodeErreurEmplCP(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setEmplCP_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getIdBNEArrco()
  {
    return m_fluxCtPasDsnInfra.getIdBNEArrco();
  }
  
  public String getCodeErreurIdBNEArrco()
  {
    return m_fluxCtPasDsnInfra.getIdBNEArrco_C_ERR();
  }
  
  public void setIdBNEArrco(BigDecimal pValeur)
  {
    m_fluxCtPasDsnInfra.setIdBNEArrco(pValeur);
  }
  
  public void setCodeErreurIdBNEArrco(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setIdBNEArrco_C_ERR(pCodeErreur);
  }
  
  public String getArrcoSigle()
  {
    return m_fluxCtPasDsnInfra.getArrcoSigle();
  }
  
  public String getCodeErreurArrcoSigle()
  {
    return m_fluxCtPasDsnInfra.getArrcoSigle_C_ERR();
  }
  
  public void setArrcoSigle(String pValeur)
  {
    m_fluxCtPasDsnInfra.setArrcoSigle(pValeur);
  }
  
  public void setCodeErreurArrcoSigle(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setArrcoSigle_C_ERR(pCodeErreur);
  }
  
  public String getArrcoRaisonSociale()
  {
    return m_fluxCtPasDsnInfra.getArrcoRaisonSociale();
  }
  
  public String getCodeErreurArrcoRaisonSociale()
  {
    return m_fluxCtPasDsnInfra.getArrcoRaisonSociale_C_ERR();
  }
  
  public void setArrcoRaisonSociale(String pValeur)
  {
    m_fluxCtPasDsnInfra.setArrcoRaisonSociale(pValeur);
  }
  
  public void setCodeErreurArrcoRaisonSociale(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setArrcoRaisonSociale_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getIdBNEAgirc()
  {
    return m_fluxCtPasDsnInfra.getIdBNEAgirc();
  }
  
  public String getCodeErreurIdBNEAgirc()
  {
    return m_fluxCtPasDsnInfra.getIdBNEAgirc_C_ERR();
  }
  
  public void setIdBNEAgirc(BigDecimal pValeur)
  {
    m_fluxCtPasDsnInfra.setIdBNEAgirc(pValeur);
  }
  
  public void setCodeErreurIdBNEAgirc(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setIdBNEAgirc_C_ERR(pCodeErreur);
  }
  
  public String getAgircSigle()
  {
    return m_fluxCtPasDsnInfra.getAgircSigle();
  }
  
  public String getCodeErreurAgircSigle()
  {
    return m_fluxCtPasDsnInfra.getAgircSigle_C_ERR();
  }
  
  public void setAgircSigle(String pValeur)
  {
    m_fluxCtPasDsnInfra.setAgircSigle(pValeur);
  }
  
  public void setCodeErreurAgircSigle(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setAgircSigle_C_ERR(pCodeErreur);
  }
  
  public String getAgircRaisonSociale()
  {
    return m_fluxCtPasDsnInfra.getAgircRaisonSociale();
  }
  
  public String getCodeErreurAgircRaisonSociale()
  {
    return m_fluxCtPasDsnInfra.getAgircRaisonSociale_C_ERR();
  }
  
  public void setAgircRaisonSociale(String pValeur)
  {
    m_fluxCtPasDsnInfra.setAgircRaisonSociale(pValeur);
  }
  
  public void setCodeErreurAgircRaisonSociale(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setAgircRaisonSociale_C_ERR(pCodeErreur);
  }
  
  public String getCodeRegimeCrpCtp()
  {
    return m_fluxCtPasDsnInfra.getCodeRegimeCrpCtp();
  }
  
  public String getCodeErreurCodeRegimeCrpCtp()
  {
    return m_fluxCtPasDsnInfra.getCodeRegimeCrpCtp_C_ERR();
  }
  
  public void setCodeRegimeCrpCtp(String pValeur)
  {
    m_fluxCtPasDsnInfra.setCodeRegimeCrpCtp(pValeur);
  }
  
  public void setCodeErreurCodeRegimeCrpCtp(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setCodeRegimeCrpCtp_C_ERR(pCodeErreur);
  }
  
  public Damj getDateEffetRegimeCrpCtp()
  {
    return m_fluxCtPasDsnInfra.getDateEffetRegimeCrpCtp();
  }
  
  public String getCodeErreurDateEffetRegimeCrpCtp()
  {
    return m_fluxCtPasDsnInfra.getDateEffetRegimeCrpCtp_C_ERR();
  }
  
  public void setDateEffetRegimeCrpCtp(Damj pValeur)
  {
    m_fluxCtPasDsnInfra.setDateEffetRegimeCrpCtp(pValeur);
  }
  
  public void setCodeErreurDateEffetRegimeCrpCtp(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setDateEffetRegimeCrpCtp_C_ERR(pCodeErreur);
  }
  
  public String getEmplNumConventionGestion()
  {
    return m_fluxCtPasDsnInfra.getEmplNumConventionGestion();
  }
  
  public String getCodeErreurEmplNumConventionGestion()
  {
    return m_fluxCtPasDsnInfra.getEmplNumConventionGestion_C_ERR();
  }
  
  public void setEmplNumConventionGestion(String pValeur)
  {
    m_fluxCtPasDsnInfra.setEmplNumConventionGestion(pValeur);
  }
  
  public void setCodeErreurEmplNumConventionGestion(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setEmplNumConventionGestion_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getNbSalariesEntreprise()
  {
    return m_fluxCtPasDsnInfra.getNbSalariesEntreprise();
  }
  
  public String getCodeErreurNbSalariesEntreprise()
  {
    return m_fluxCtPasDsnInfra.getNbSalariesEntreprise_C_ERR();
  }
  
  public void setNbSalariesEntreprise(BigDecimal pValeur)
  {
    m_fluxCtPasDsnInfra.setNbSalariesEntreprise(pValeur);
  }
  
  public void setCodeErreurNbSalariesEntreprise(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setNbSalariesEntreprise_C_ERR(pCodeErreur);
  }
  
  public String getNomEmployeur()
  {
    return m_fluxCtPasDsnInfra.getNomEmployeur();
  }
  
  public String getCodeErreurNomEmployeur()
  {
    return m_fluxCtPasDsnInfra.getNomEmployeur_C_ERR();
  }
  
  public void setNomEmployeur(String pValeur)
  {
    m_fluxCtPasDsnInfra.setNomEmployeur(pValeur);
  }
  
  public void setCodeErreurNomEmployeur(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setNomEmployeur_C_ERR(pCodeErreur);
  }
  
  public String getPrenomEmployeur()
  {
    return m_fluxCtPasDsnInfra.getPrenomEmployeur();
  }
  
  public String getCodeErreurPrenomEmployeur()
  {
    return m_fluxCtPasDsnInfra.getPrenomEmployeur_C_ERR();
  }
  
  public void setPrenomEmployeur(String pValeur)
  {
    m_fluxCtPasDsnInfra.setPrenomEmployeur(pValeur);
  }
  
  public void setCodeErreurPrenomEmployeur(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setPrenomEmployeur_C_ERR(pCodeErreur);
  }
  
  public String getCategorieJuridique()
  {
    return m_fluxCtPasDsnInfra.getCategorieJuridique();
  }
  
  public String getCodeErreurCategorieJuridique()
  {
    return m_fluxCtPasDsnInfra.getCategorieJuridique_C_ERR();
  }
  
  public void setCategorieJuridique(String pValeur)
  {
    m_fluxCtPasDsnInfra.setCategorieJuridique(pValeur);
  }
  
  public void setCodeErreurCategorieJuridique(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setCategorieJuridique_C_ERR(pCodeErreur);
  }
  
  public String getCodeRegimeEntreprise()
  {
    return m_fluxCtPasDsnInfra.getCodeRegimeEntreprise();
  }
  
  public String getCodeErreurCodeRegimeEntreprise()
  {
    return m_fluxCtPasDsnInfra.getCodeRegimeEntreprise_C_ERR();
  }
  
  public void setCodeRegimeEntreprise(String pValeur)
  {
    m_fluxCtPasDsnInfra.setCodeRegimeEntreprise(pValeur);
  }
  
  public void setCodeErreurCodeRegimeEntreprise(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setCodeRegimeEntreprise_C_ERR(pCodeErreur);
  }
  
  public Damj getDateCessationEntreprise()
  {
    return m_fluxCtPasDsnInfra.getDateCessationEntreprise();
  }
  
  public String getCodeErreurDateCessationEntreprise()
  {
    return m_fluxCtPasDsnInfra.getDateCessationEntreprise_C_ERR();
  }
  
  public void setDateCessationEntreprise(Damj pValeur)
  {
    m_fluxCtPasDsnInfra.setDateCessationEntreprise(pValeur);
  }
  
  public void setCodeErreurDateCessationEntreprise(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setDateCessationEntreprise_C_ERR(pCodeErreur);
  }
  
  public String getNatureEntreprise()
  {
    return m_fluxCtPasDsnInfra.getNatureEntreprise();
  }
  
  public String getCodeErreurNatureEntreprise()
  {
    return m_fluxCtPasDsnInfra.getNatureEntreprise_C_ERR();
  }
  
  public void setNatureEntreprise(String pValeur)
  {
    m_fluxCtPasDsnInfra.setNatureEntreprise(pValeur);
  }
  
  public void setCodeErreurNatureEntreprise(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setNatureEntreprise_C_ERR(pCodeErreur);
  }
  
  public String getNumMSAEntreprise()
  {
    return m_fluxCtPasDsnInfra.getNumMSAEntreprise();
  }
  
  public String getCodeErreurNumMSAEntreprise()
  {
    return m_fluxCtPasDsnInfra.getNumMSAEntreprise_C_ERR();
  }
  
  public void setNumMSAEntreprise(String pValeur)
  {
    m_fluxCtPasDsnInfra.setNumMSAEntreprise(pValeur);
  }
  
  public void setCodeErreurNumMSAEntreprise(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setNumMSAEntreprise_C_ERR(pCodeErreur);
  }
  
  public Damj getDebutPeriodeAffiliationEntreprise()
  {
    return m_fluxCtPasDsnInfra.getDebutPeriodeAffiliationEntreprise();
  }
  
  public String getCodeErreurDebutPeriodeAffiliationEntreprise()
  {
    return m_fluxCtPasDsnInfra.getDebutPeriodeAffiliationEntreprise_C_ERR();
  }
  
  public void setDebutPeriodeAffiliationEntreprise(Damj pValeur)
  {
    m_fluxCtPasDsnInfra.setDebutPeriodeAffiliationEntreprise(pValeur);
  }
  
  public void setCodeErreurDebutPeriodeAffiliationEntreprise(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setDebutPeriodeAffiliationEntreprise_C_ERR(pCodeErreur);
  }
  
  public Damj getFinPeriodeAffiliationEntreprise()
  {
    return m_fluxCtPasDsnInfra.getFinPeriodeAffiliationEntreprise();
  }
  
  public String getCodeErreurFinPeriodeAffiliationEntreprise()
  {
    return m_fluxCtPasDsnInfra.getFinPeriodeAffiliationEntreprise_C_ERR();
  }
  
  public void setFinPeriodeAffiliationEntreprise(Damj pValeur)
  {
    m_fluxCtPasDsnInfra.setFinPeriodeAffiliationEntreprise(pValeur);
  }
  
  public void setCodeErreurFinPeriodeAffiliationEntreprise(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setFinPeriodeAffiliationEntreprise_C_ERR(pCodeErreur);
  }
  
  public Damj getDebutConventionGestion()
  {
    return m_fluxCtPasDsnInfra.getDebutConventionGestion();
  }
  
  public String getCodeErreurDebutConventionGestion()
  {
    return m_fluxCtPasDsnInfra.getDebutConventionGestion_C_ERR();
  }
  
  public void setDebutConventionGestion(Damj pValeur)
  {
    m_fluxCtPasDsnInfra.setDebutConventionGestion(pValeur);
  }
  
  public void setCodeErreurDebutConventionGestion(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setDebutConventionGestion_C_ERR(pCodeErreur);
  }
  
  public Damj getFinConventionGestion()
  {
    return m_fluxCtPasDsnInfra.getFinConventionGestion();
  }
  
  public String getCodeErreurFinConventionGestion()
  {
    return m_fluxCtPasDsnInfra.getFinConventionGestion_C_ERR();
  }
  
  public void setFinConventionGestion(Damj pValeur)
  {
    m_fluxCtPasDsnInfra.setFinConventionGestion(pValeur);
  }
  
  public void setCodeErreurFinConventionGestion(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setFinConventionGestion_C_ERR(pCodeErreur);
  }
  
  public String getSecteurPublic()
  {
    return m_fluxCtPasDsnInfra.getSecteurPublic();
  }
  
  public String getCodeErreurSecteurPublic()
  {
    return m_fluxCtPasDsnInfra.getSecteurPublic_C_ERR();
  }
  
  public void setSecteurPublic(String pValeur)
  {
    m_fluxCtPasDsnInfra.setSecteurPublic(pValeur);
  }
  
  public void setCodeErreurSecteurPublic(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setSecteurPublic_C_ERR(pCodeErreur);
  }
  
  public String getTrancheEffectifEntreprise()
  {
    return m_fluxCtPasDsnInfra.getTrancheEffectifEntreprise();
  }
  
  public String getCodeErreurTrancheEffectifEntreprise()
  {
    return m_fluxCtPasDsnInfra.getTrancheEffectifEntreprise_C_ERR();
  }
  
  public void setTrancheEffectifEntreprise(String pValeur)
  {
    m_fluxCtPasDsnInfra.setTrancheEffectifEntreprise(pValeur);
  }
  
  public void setCodeErreurTrancheEffectifEntreprise(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setTrancheEffectifEntreprise_C_ERR(pCodeErreur);
  }
  
  public Damj getDebutAGS()
  {
    return m_fluxCtPasDsnInfra.getDebutAGS();
  }
  
  public String getCodeErreurDebutAGS()
  {
    return m_fluxCtPasDsnInfra.getDebutAGS_C_ERR();
  }
  
  public void setDebutAGS(Damj pValeur)
  {
    m_fluxCtPasDsnInfra.setDebutAGS(pValeur);
  }
  
  public void setCodeErreurDebutAGS(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setDebutAGS_C_ERR(pCodeErreur);
  }
  
  public Damj getFinAGS()
  {
    return m_fluxCtPasDsnInfra.getFinAGS();
  }
  
  public String getCodeErreurFinAGS()
  {
    return m_fluxCtPasDsnInfra.getFinAGS_C_ERR();
  }
  
  public void setFinAGS(Damj pValeur)
  {
    m_fluxCtPasDsnInfra.setFinAGS(pValeur);
  }
  
  public void setCodeErreurFinAGS(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setFinAGS_C_ERR(pCodeErreur);
  }
  
  public Damj getDebutAdhesionRevocable()
  {
    return m_fluxCtPasDsnInfra.getDebutAdhesionRevocable();
  }
  
  public String getCodeErreurDebutAdhesionRevocable()
  {
    return m_fluxCtPasDsnInfra.getDebutAdhesionRevocable_C_ERR();
  }
  
  public void setDebutAdhesionRevocable(Damj pValeur)
  {
    m_fluxCtPasDsnInfra.setDebutAdhesionRevocable(pValeur);
  }
  
  public void setCodeErreurDebutAdhesionRevocable(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setDebutAdhesionRevocable_C_ERR(pCodeErreur);
  }
  
  public Damj getFinAdhesionRevocable()
  {
    return m_fluxCtPasDsnInfra.getFinAdhesionRevocable();
  }
  
  public String getCodeErreurFinAdhesionRevocable()
  {
    return m_fluxCtPasDsnInfra.getFinAdhesionRevocable_C_ERR();
  }
  
  public void setFinAdhesionRevocable(Damj pValeur)
  {
    m_fluxCtPasDsnInfra.setFinAdhesionRevocable(pValeur);
  }
  
  public void setCodeErreurFinAdhesionRevocable(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setFinAdhesionRevocable_C_ERR(pCodeErreur);
  }
  
  public ListeFluxQuantiteTravailDsn getListeFluxQuantiteTravailDsn()
  {
    _ListeFluxQuantiteTravailDsn infraItem = m_fluxCtPasDsnInfra.getListeFluxQuantiteTravailDsn();
    _ListeFluxQuantiteTravailDsnImpl resultat = null;
    if (infraItem != null) {
      resultat = new _ListeFluxQuantiteTravailDsnImpl(infraItem);
    }
    return resultat;
  }
  
  public void setListeFluxQuantiteTravailDsn(ListeFluxQuantiteTravailDsn pValeur)
  {
    if (pValeur == null)
    {
      m_fluxCtPasDsnInfra.setListeFluxQuantiteTravailDsn(null);
    }
    else
    {
      _ListeFluxQuantiteTravailDsnImpl subImpl = (_ListeFluxQuantiteTravailDsnImpl)pValeur;
      m_fluxCtPasDsnInfra.setListeFluxQuantiteTravailDsn(subImpl.getListeFluxQuantiteTravailDsnInfra());
    }
  }
  
  public ListeFluxQuantiteTravailDsn setNewListeFluxQuantiteTravailDsn()
  {
    _ListeFluxQuantiteTravailDsnImpl item = new _ListeFluxQuantiteTravailDsnImpl();
    m_fluxCtPasDsnInfra.setListeFluxQuantiteTravailDsn(item.getListeFluxQuantiteTravailDsnInfra());
    return item;
  }
  
  /**
   * @deprecated
   */
  public ListeFluxQuantiteTravailDsn setNewListeFluxQuantiteTravailDsn_listeFluxQuantiteTravailDsn()
  {
    return setNewListeFluxQuantiteTravailDsn();
  }
  
  public String getMotifFinContrat()
  {
    return m_fluxCtPasDsnInfra.getMotifFinContrat();
  }
  
  public String getCodeErreurMotifFinContrat()
  {
    return m_fluxCtPasDsnInfra.getMotifFinContrat_C_ERR();
  }
  
  public void setMotifFinContrat(String pValeur)
  {
    m_fluxCtPasDsnInfra.setMotifFinContrat(pValeur);
  }
  
  public void setCodeErreurMotifFinContrat(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setMotifFinContrat_C_ERR(pCodeErreur);
  }
  
  public Damj getDateInitialeFinContrat()
  {
    return m_fluxCtPasDsnInfra.getDateInitialeFinContrat();
  }
  
  public String getCodeErreurDateInitialeFinContrat()
  {
    return m_fluxCtPasDsnInfra.getDateInitialeFinContrat_C_ERR();
  }
  
  public void setDateInitialeFinContrat(Damj pValeur)
  {
    m_fluxCtPasDsnInfra.setDateInitialeFinContrat(pValeur);
  }
  
  public void setCodeErreurDateInitialeFinContrat(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setDateInitialeFinContrat_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getIdActiviteDsnPe()
  {
    return m_fluxCtPasDsnInfra.getIdActiviteDsnPe();
  }
  
  public String getCodeErreurIdActiviteDsnPe()
  {
    return m_fluxCtPasDsnInfra.getIdActiviteDsnPe_C_ERR();
  }
  
  public void setIdActiviteDsnPe(BigDecimal pValeur)
  {
    m_fluxCtPasDsnInfra.setIdActiviteDsnPe(pValeur);
  }
  
  public void setCodeErreurIdActiviteDsnPe(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setIdActiviteDsnPe_C_ERR(pCodeErreur);
  }
  
  public String getSigneDureeAbsence()
  {
    return m_fluxCtPasDsnInfra.getSigneDureeAbsence();
  }
  
  public String getCodeErreurSigneDureeAbsence()
  {
    return m_fluxCtPasDsnInfra.getSigneDureeAbsence_C_ERR();
  }
  
  public void setSigneDureeAbsence(String pValeur)
  {
    m_fluxCtPasDsnInfra.setSigneDureeAbsence(pValeur);
  }
  
  public void setCodeErreurSigneDureeAbsence(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setSigneDureeAbsence_C_ERR(pCodeErreur);
  }
  
  public ListeFluxPrimeIndemDsn getListeFluxPrimeIndemDsn()
  {
    _ListeFluxPrimeIndemDsn infraItem = m_fluxCtPasDsnInfra.getListeFluxPrimeIndemDsn();
    _ListeFluxPrimeIndemDsnImpl resultat = null;
    if (infraItem != null) {
      resultat = new _ListeFluxPrimeIndemDsnImpl(infraItem);
    }
    return resultat;
  }
  
  public void setListeFluxPrimeIndemDsn(ListeFluxPrimeIndemDsn pValeur)
  {
    if (pValeur == null)
    {
      m_fluxCtPasDsnInfra.setListeFluxPrimeIndemDsn(null);
    }
    else
    {
      _ListeFluxPrimeIndemDsnImpl subImpl = (_ListeFluxPrimeIndemDsnImpl)pValeur;
      m_fluxCtPasDsnInfra.setListeFluxPrimeIndemDsn(subImpl.getListeFluxPrimeIndemDsnInfra());
    }
  }
  
  public ListeFluxPrimeIndemDsn setNewListeFluxPrimeIndemDsn()
  {
    _ListeFluxPrimeIndemDsnImpl item = new _ListeFluxPrimeIndemDsnImpl();
    m_fluxCtPasDsnInfra.setListeFluxPrimeIndemDsn(item.getListeFluxPrimeIndemDsnInfra());
    return item;
  }
  
  /**
   * @deprecated
   */
  public ListeFluxPrimeIndemDsn setNewListeFluxPrimeIndemDsn_listeFluxPrimeIndemDsn()
  {
    return setNewListeFluxPrimeIndemDsn();
  }
  
  public String getIdentDeclPri()
  {
    return m_fluxCtPasDsnInfra.getIdentDeclPri();
  }
  
  public String getCodeErreurIdentDeclPri()
  {
    return m_fluxCtPasDsnInfra.getIdentDeclPri_C_ERR();
  }
  
  public void setIdentDeclPri(String pValeur)
  {
    m_fluxCtPasDsnInfra.setIdentDeclPri(pValeur);
  }
  
  public void setCodeErreurIdentDeclPri(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setIdentDeclPri_C_ERR(pCodeErreur);
  }
  
  public String getIdentDeclSec()
  {
    return m_fluxCtPasDsnInfra.getIdentDeclSec();
  }
  
  public String getCodeErreurIdentDeclSec()
  {
    return m_fluxCtPasDsnInfra.getIdentDeclSec_C_ERR();
  }
  
  public void setIdentDeclSec(String pValeur)
  {
    m_fluxCtPasDsnInfra.setIdentDeclSec(pValeur);
  }
  
  public void setCodeErreurIdentDeclSec(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setIdentDeclSec_C_ERR(pCodeErreur);
  }
  
  public String getMotifRecours()
  {
    return m_fluxCtPasDsnInfra.getMotifRecours();
  }
  
  public String getCodeErreurMotifRecours()
  {
    return m_fluxCtPasDsnInfra.getMotifRecours_C_ERR();
  }
  
  public void setMotifRecours(String pValeur)
  {
    m_fluxCtPasDsnInfra.setMotifRecours(pValeur);
  }
  
  public void setCodeErreurMotifRecours(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setMotifRecours_C_ERR(pCodeErreur);
  }
  
  public String getModaliteDeclarativeFinContrat()
  {
    return m_fluxCtPasDsnInfra.getModaliteDeclarativeFinContrat();
  }
  
  public String getCodeErreurModaliteDeclarativeFinContrat()
  {
    return m_fluxCtPasDsnInfra.getModaliteDeclarativeFinContrat_C_ERR();
  }
  
  public void setModaliteDeclarativeFinContrat(String pValeur)
  {
    m_fluxCtPasDsnInfra.setModaliteDeclarativeFinContrat(pValeur);
  }
  
  public void setCodeErreurModaliteDeclarativeFinContrat(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setModaliteDeclarativeFinContrat_C_ERR(pCodeErreur);
  }
  
  public Damj getDjtp()
  {
    return m_fluxCtPasDsnInfra.getDjtp();
  }
  
  public String getCodeErreurDjtp()
  {
    return m_fluxCtPasDsnInfra.getDjtp_C_ERR();
  }
  
  public void setDjtp(Damj pValeur)
  {
    m_fluxCtPasDsnInfra.setDjtp(pValeur);
  }
  
  public void setCodeErreurDjtp(String pCodeErreur)
  {
    m_fluxCtPasDsnInfra.setDjtp_C_ERR(pCodeErreur);
  }
  
  public _FluxCtPasDsn getFluxCtPasDsnInfra()
  {
    return m_fluxCtPasDsnInfra;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    if ((getCodeErreurTypeEnreg() != null) && 
      ("".equals(getCodeErreurTypeEnreg()))) {
      return true;
    }
    if ((getCodeErreurNumNIRCertifie() != null) && 
      ("".equals(getCodeErreurNumNIRCertifie()))) {
      return true;
    }
    if ((getCodeErreurNomDeclare() != null) && 
      ("".equals(getCodeErreurNomDeclare()))) {
      return true;
    }
    if ((getCodeErreurPrenomDeclare() != null) && 
      ("".equals(getCodeErreurPrenomDeclare()))) {
      return true;
    }
    if ((getCodeErreurDateNaissance() != null) && 
      ("".equals(getCodeErreurDateNaissance()))) {
      return true;
    }
    if ((getCodeErreurContexteEmission() != null) && 
      ("".equals(getCodeErreurContexteEmission()))) {
      return true;
    }
    if ((getCodeErreurNatureJustificatif() != null) && 
      ("".equals(getCodeErreurNatureJustificatif()))) {
      return true;
    }
    if ((getCodeErreurCodeMessage() != null) && 
      ("".equals(getCodeErreurCodeMessage()))) {
      return true;
    }
    if ((getCodeErreurNumeroVersion() != null) && 
      ("".equals(getCodeErreurNumeroVersion()))) {
      return true;
    }
    if ((getCodeErreurNumeroSousVersion() != null) && 
      ("".equals(getCodeErreurNumeroSousVersion()))) {
      return true;
    }
    if ((getCodeErreurCodeAction() != null) && 
      ("".equals(getCodeErreurCodeAction()))) {
      return true;
    }
    if ((getCodeErreurIdTechnique() != null) && 
      ("".equals(getCodeErreurIdTechnique()))) {
      return true;
    }
    if ((getCodeErreurIdRCE() != null) && 
      ("".equals(getCodeErreurIdRCE()))) {
      return true;
    }
    if ((getCodeErreurSiretDeclare() != null) && 
      ("".equals(getCodeErreurSiretDeclare()))) {
      return true;
    }
    if ((getCodeErreurRefContratEmployeur() != null) && 
      ("".equals(getCodeErreurRefContratEmployeur()))) {
      return true;
    }
    if ((getCodeErreurNbMessagesPrimesIndemnites() != null) && 
      ("".equals(getCodeErreurNbMessagesPrimesIndemnites()))) {
      return true;
    }
    if ((getCodeErreurDateConnaissanceMensuelle() != null) && 
      ("".equals(getCodeErreurDateConnaissanceMensuelle()))) {
      return true;
    }
    if ((getCodeErreurDateMoisDeclare() != null) && 
      ("".equals(getCodeErreurDateMoisDeclare()))) {
      return true;
    }
    if ((getCodeErreurDateDebutContrat() != null) && 
      ("".equals(getCodeErreurDateDebutContrat()))) {
      return true;
    }
    if ((getCodeErreurDateFinContrat() != null) && 
      ("".equals(getCodeErreurDateFinContrat()))) {
      return true;
    }
    if ((getCodeErreurNatureContrat() != null) && 
      ("".equals(getCodeErreurNatureContrat()))) {
      return true;
    }
    if ((getCodeErreurTypeContrat() != null) && 
      ("".equals(getCodeErreurTypeContrat()))) {
      return true;
    }
    if ((getCodeErreurCodeStatutCadre() != null) && 
      ("".equals(getCodeErreurCodeStatutCadre()))) {
      return true;
    }
    if ((getCodeErreurHoraireSalarie() != null) && 
      ("".equals(getCodeErreurHoraireSalarie()))) {
      return true;
    }
    if ((getCodeErreurHoraireEntreprise() != null) && 
      ("".equals(getCodeErreurHoraireEntreprise()))) {
      return true;
    }
    if ((getCodeErreurUniteTempsTravail() != null) && 
      ("".equals(getCodeErreurUniteTempsTravail()))) {
      return true;
    }
    if ((getCodeErreurAlsaceMoselle() != null) && 
      ("".equals(getCodeErreurAlsaceMoselle()))) {
      return true;
    }
    if ((getCodeErreurRegimeSpecialSecuriteSoc() != null) && 
      ("".equals(getCodeErreurRegimeSpecialSecuriteSoc()))) {
      return true;
    }
    if ((getCodeErreurTypeCaisseCP() != null) && 
      ("".equals(getCodeErreurTypeCaisseCP()))) {
      return true;
    }
    if ((getCodeErreurNiveauQualification() != null) && 
      ("".equals(getCodeErreurNiveauQualification()))) {
      return true;
    }
    if ((getCodeErreurCodeCaisseRetraiteCompl() != null) && 
      ("".equals(getCodeErreurCodeCaisseRetraiteCompl()))) {
      return true;
    }
    if ((getCodeErreurChampApplicationEmployeur() != null) && 
      ("".equals(getCodeErreurChampApplicationEmployeur()))) {
      return true;
    }
    if ((getCodeErreurNumConventionGestionEmpPublic() != null) && 
      ("".equals(getCodeErreurNumConventionGestionEmpPublic()))) {
      return true;
    }
    if ((getCodeErreurEtablissementFinancier() != null) && 
      ("".equals(getCodeErreurEtablissementFinancier()))) {
      return true;
    }
    if ((getCodeErreurCodeAffectation() != null) && 
      ("".equals(getCodeErreurCodeAffectation()))) {
      return true;
    }
    if ((getCodeErreurNumInterneEmpPublic() != null) && 
      ("".equals(getCodeErreurNumInterneEmpPublic()))) {
      return true;
    }
    if ((getCodeErreurStatutSalarie() != null) && 
      ("".equals(getCodeErreurStatutSalarie()))) {
      return true;
    }
    if ((getCodeErreurDateAdhesion() != null) && 
      ("".equals(getCodeErreurDateAdhesion()))) {
      return true;
    }
    if ((getCodeErreurMotifPeriodeInactivite() != null) && 
      ("".equals(getCodeErreurMotifPeriodeInactivite()))) {
      return true;
    }
    if ((getCodeErreurDateDebutPeriodeInactivite() != null) && 
      ("".equals(getCodeErreurDateDebutPeriodeInactivite()))) {
      return true;
    }
    if ((getCodeErreurDateFinPeriodeInactivite() != null) && 
      ("".equals(getCodeErreurDateFinPeriodeInactivite()))) {
      return true;
    }
    if ((getCodeErreurDateDebutPeriodeSalaire() != null) && 
      ("".equals(getCodeErreurDateDebutPeriodeSalaire()))) {
      return true;
    }
    if ((getCodeErreurDateFinPeriodeSalaire() != null) && 
      ("".equals(getCodeErreurDateFinPeriodeSalaire()))) {
      return true;
    }
    if ((getCodeErreurCodePcsEse() != null) && 
      ("".equals(getCodeErreurCodePcsEse()))) {
      return true;
    }
    if ((getCodeErreurCodeComplementPcsEse() != null) && 
      ("".equals(getCodeErreurCodeComplementPcsEse()))) {
      return true;
    }
    if ((getCodeErreurSigneSalaireBrutAbattu() != null) && 
      ("".equals(getCodeErreurSigneSalaireBrutAbattu()))) {
      return true;
    }
    if ((getCodeErreurSalaireBrutAbattu() != null) && 
      ("".equals(getCodeErreurSalaireBrutAbattu()))) {
      return true;
    }
    if ((getCodeErreurDatePaiement() != null) && 
      ("".equals(getCodeErreurDatePaiement()))) {
      return true;
    }
    if ((getCodeErreurDureeAbsence() != null) && 
      ("".equals(getCodeErreurDureeAbsence()))) {
      return true;
    }
    if ((getCodeErreurUniteAbsence() != null) && 
      ("".equals(getCodeErreurUniteAbsence()))) {
      return true;
    }
    if ((getCodeErreurNomLogiciel() != null) && 
      ("".equals(getCodeErreurNomLogiciel()))) {
      return true;
    }
    if ((getCodeErreurVersionLogiciel() != null) && 
      ("".equals(getCodeErreurVersionLogiciel()))) {
      return true;
    }
    if ((getCodeErreurNumeroRCI() != null) && 
      ("".equals(getCodeErreurNumeroRCI()))) {
      return true;
    }
    if ((getCodeErreurCxass() != null) && 
      ("".equals(getCodeErreurCxass()))) {
      return true;
    }
    if ((getCodeErreurRsin() != null) && 
      ("".equals(getCodeErreurRsin()))) {
      return true;
    }
    if ((getCodeErreurNom() != null) && 
      ("".equals(getCodeErreurNom()))) {
      return true;
    }
    if ((getCodeErreurPrenom() != null) && 
      ("".equals(getCodeErreurPrenom()))) {
      return true;
    }
    if ((getCodeErreurPeAffi() != null) && 
      ("".equals(getCodeErreurPeAffi()))) {
      return true;
    }
    if ((getCodeErreurSiret() != null) && 
      ("".equals(getCodeErreurSiret()))) {
      return true;
    }
    if ((getCodeErreurEmplNumAffi() != null) && 
      ("".equals(getCodeErreurEmplNumAffi()))) {
      return true;
    }
    if ((getCodeErreurEmplRaisonSociale() != null) && 
      ("".equals(getCodeErreurEmplRaisonSociale()))) {
      return true;
    }
    if ((getCodeErreurEmplNAF() != null) && 
      ("".equals(getCodeErreurEmplNAF()))) {
      return true;
    }
    if ((getCodeErreurEmplCommune() != null) && 
      ("".equals(getCodeErreurEmplCommune()))) {
      return true;
    }
    if ((getCodeErreurEmplCP() != null) && 
      ("".equals(getCodeErreurEmplCP()))) {
      return true;
    }
    if ((getCodeErreurIdBNEArrco() != null) && 
      ("".equals(getCodeErreurIdBNEArrco()))) {
      return true;
    }
    if ((getCodeErreurArrcoSigle() != null) && 
      ("".equals(getCodeErreurArrcoSigle()))) {
      return true;
    }
    if ((getCodeErreurArrcoRaisonSociale() != null) && 
      ("".equals(getCodeErreurArrcoRaisonSociale()))) {
      return true;
    }
    if ((getCodeErreurIdBNEAgirc() != null) && 
      ("".equals(getCodeErreurIdBNEAgirc()))) {
      return true;
    }
    if ((getCodeErreurAgircSigle() != null) && 
      ("".equals(getCodeErreurAgircSigle()))) {
      return true;
    }
    if ((getCodeErreurAgircRaisonSociale() != null) && 
      ("".equals(getCodeErreurAgircRaisonSociale()))) {
      return true;
    }
    if ((getCodeErreurCodeRegimeCrpCtp() != null) && 
      ("".equals(getCodeErreurCodeRegimeCrpCtp()))) {
      return true;
    }
    if ((getCodeErreurDateEffetRegimeCrpCtp() != null) && 
      ("".equals(getCodeErreurDateEffetRegimeCrpCtp()))) {
      return true;
    }
    if ((getCodeErreurEmplNumConventionGestion() != null) && 
      ("".equals(getCodeErreurEmplNumConventionGestion()))) {
      return true;
    }
    if ((getCodeErreurNbSalariesEntreprise() != null) && 
      ("".equals(getCodeErreurNbSalariesEntreprise()))) {
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
    if ((getCodeErreurCategorieJuridique() != null) && 
      ("".equals(getCodeErreurCategorieJuridique()))) {
      return true;
    }
    if ((getCodeErreurCodeRegimeEntreprise() != null) && 
      ("".equals(getCodeErreurCodeRegimeEntreprise()))) {
      return true;
    }
    if ((getCodeErreurDateCessationEntreprise() != null) && 
      ("".equals(getCodeErreurDateCessationEntreprise()))) {
      return true;
    }
    if ((getCodeErreurNatureEntreprise() != null) && 
      ("".equals(getCodeErreurNatureEntreprise()))) {
      return true;
    }
    if ((getCodeErreurNumMSAEntreprise() != null) && 
      ("".equals(getCodeErreurNumMSAEntreprise()))) {
      return true;
    }
    if ((getCodeErreurDebutPeriodeAffiliationEntreprise() != null) && 
      ("".equals(getCodeErreurDebutPeriodeAffiliationEntreprise()))) {
      return true;
    }
    if ((getCodeErreurFinPeriodeAffiliationEntreprise() != null) && 
      ("".equals(getCodeErreurFinPeriodeAffiliationEntreprise()))) {
      return true;
    }
    if ((getCodeErreurDebutConventionGestion() != null) && 
      ("".equals(getCodeErreurDebutConventionGestion()))) {
      return true;
    }
    if ((getCodeErreurFinConventionGestion() != null) && 
      ("".equals(getCodeErreurFinConventionGestion()))) {
      return true;
    }
    if ((getCodeErreurSecteurPublic() != null) && 
      ("".equals(getCodeErreurSecteurPublic()))) {
      return true;
    }
    if ((getCodeErreurTrancheEffectifEntreprise() != null) && 
      ("".equals(getCodeErreurTrancheEffectifEntreprise()))) {
      return true;
    }
    if ((getCodeErreurDebutAGS() != null) && 
      ("".equals(getCodeErreurDebutAGS()))) {
      return true;
    }
    if ((getCodeErreurFinAGS() != null) && 
      ("".equals(getCodeErreurFinAGS()))) {
      return true;
    }
    if ((getCodeErreurDebutAdhesionRevocable() != null) && 
      ("".equals(getCodeErreurDebutAdhesionRevocable()))) {
      return true;
    }
    if ((getCodeErreurFinAdhesionRevocable() != null) && 
      ("".equals(getCodeErreurFinAdhesionRevocable()))) {
      return true;
    }
    Object objListeFluxQuantiteTravailDsn = getListeFluxQuantiteTravailDsn();
    if ((objListeFluxQuantiteTravailDsn != null) && 
      (getListeFluxQuantiteTravailDsn().isEnErreur())) {
      return true;
    }
    if ((getCodeErreurMotifFinContrat() != null) && 
      ("".equals(getCodeErreurMotifFinContrat()))) {
      return true;
    }
    if ((getCodeErreurDateInitialeFinContrat() != null) && 
      ("".equals(getCodeErreurDateInitialeFinContrat()))) {
      return true;
    }
    if ((getCodeErreurIdActiviteDsnPe() != null) && 
      ("".equals(getCodeErreurIdActiviteDsnPe()))) {
      return true;
    }
    if ((getCodeErreurSigneDureeAbsence() != null) && 
      ("".equals(getCodeErreurSigneDureeAbsence()))) {
      return true;
    }
    Object objListeFluxPrimeIndemDsn = getListeFluxPrimeIndemDsn();
    if ((objListeFluxPrimeIndemDsn != null) && 
      (getListeFluxPrimeIndemDsn().isEnErreur())) {
      return true;
    }
    if ((getCodeErreurIdentDeclPri() != null) && 
      ("".equals(getCodeErreurIdentDeclPri()))) {
      return true;
    }
    if ((getCodeErreurIdentDeclSec() != null) && 
      ("".equals(getCodeErreurIdentDeclSec()))) {
      return true;
    }
    if ((getCodeErreurMotifRecours() != null) && 
      ("".equals(getCodeErreurMotifRecours()))) {
      return true;
    }
    if ((getCodeErreurModaliteDeclarativeFinContrat() != null) && 
      ("".equals(getCodeErreurModaliteDeclarativeFinContrat()))) {
      return true;
    }
    if ((getCodeErreurDjtp() != null) && 
      ("".equals(getCodeErreurDjtp()))) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _FluxCtPasDsnImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */