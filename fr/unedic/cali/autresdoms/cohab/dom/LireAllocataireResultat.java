package fr.unedic.cali.autresdoms.cohab.dom;

import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;

public class LireAllocataireResultat
{
  private String m_nom;
  private String m_prenom;
  private Damj m_dateDeNaissance;
  private Damj m_dateDeces;
  private Damj m_dernierJourAtteste;
  private boolean m_estCAN;
  private Damj m_dateLiquidationRetraite;
  private Damj dateRetraiteAnticipe;
  private String motifRetraiteAnticipe;
  private Damj m_dateValeurTrimestre;
  private BigDecimal m_nbTrimestresAcquis;
  private boolean m_estBeneficiaireSapa;
  private boolean m_estBeneficiaireRsa;
  private boolean m_estExclusionIndividuelle;
  private boolean m_estAcompteNonSolde;
  private Damj m_dateCentTrimestres;
  private Damj m_dateBlocageIndemnisation;
  private String m_idDemandeSigmaTransfert;
  private String m_rsodDerniereAdmission;
  private String m_etatMigration;
  private boolean m_estMigre;
  private Damj m_ddorkb;
  private Damj m_datePeremptionTitreSejour;
  private Damj m_djams;
  private boolean m_estAlerteAD;
  
  public Damj getDateDeNaissance()
  {
    return m_dateDeNaissance;
  }
  
  public Damj getDernierJourAtteste()
  {
    return m_dernierJourAtteste;
  }
  
  public Damj getDateValeurTrimestre()
  {
    return m_dateValeurTrimestre;
  }
  
  public boolean isEstCAN()
  {
    return m_estCAN;
  }
  
  public BigDecimal getNbTrimestresAcquis()
  {
    return m_nbTrimestresAcquis;
  }
  
  public String getNom()
  {
    return m_nom;
  }
  
  public String getPrenom()
  {
    return m_prenom;
  }
  
  public Damj getDateCentTrimestres()
  {
    return m_dateCentTrimestres;
  }
  
  public void setDateDeNaissance(Damj p_damj)
  {
    m_dateDeNaissance = p_damj;
  }
  
  public void setDernierJourAtteste(Damj p_damj)
  {
    m_dernierJourAtteste = p_damj;
  }
  
  public void setDateValeurTrimestre(Damj p_damj)
  {
    m_dateValeurTrimestre = p_damj;
  }
  
  public void setEstCAN(boolean p_b)
  {
    m_estCAN = p_b;
  }
  
  public void setNbTrimestresAcquis(BigDecimal p_decimal)
  {
    m_nbTrimestresAcquis = p_decimal;
  }
  
  public void setNom(String p_string)
  {
    m_nom = p_string;
  }
  
  public void setPrenom(String p_string)
  {
    m_prenom = p_string;
  }
  
  public void setDateCentTrimestres(Damj p_damj)
  {
    m_dateCentTrimestres = p_damj;
  }
  
  public Damj getDateLiquidationRetraite()
  {
    return m_dateLiquidationRetraite;
  }
  
  public void setDateLiquidationRetraite(Damj p_damj)
  {
    m_dateLiquidationRetraite = p_damj;
  }
  
  public boolean estAcompteNonSolde()
  {
    return m_estAcompteNonSolde;
  }
  
  public boolean estBeneficiaireSapa()
  {
    return m_estBeneficiaireSapa;
  }
  
  public boolean estExclusionIndividuelle()
  {
    return m_estExclusionIndividuelle;
  }
  
  public void setEstAcompteNonSolde(boolean p_isAcompteNonSolde)
  {
    m_estAcompteNonSolde = p_isAcompteNonSolde;
  }
  
  public void setEstBeneficiaireSapa(boolean p_isBeneficiaireSapa)
  {
    m_estBeneficiaireSapa = p_isBeneficiaireSapa;
  }
  
  public void setEstExclusionIndividuelle(boolean p_isExclusionIndividuelle)
  {
    m_estExclusionIndividuelle = p_isExclusionIndividuelle;
  }
  
  public Damj getDateBlocageIndemnisation()
  {
    return m_dateBlocageIndemnisation;
  }
  
  public void setDateBlocageIndemnisation(Damj p_dateBlocageIndemnisation)
  {
    m_dateBlocageIndemnisation = p_dateBlocageIndemnisation;
  }
  
  public String getIdDemandeSigmaTransfert()
  {
    return m_idDemandeSigmaTransfert;
  }
  
  public void setIdDemandeSigmaTransfert(String p_idDemandeSigmaTransfert)
  {
    m_idDemandeSigmaTransfert = p_idDemandeSigmaTransfert;
  }
  
  public String getRsodDerniereAdmission()
  {
    return m_rsodDerniereAdmission;
  }
  
  public void setRsodDerniereAdmission(String p_rsodDerniereAdmission)
  {
    m_rsodDerniereAdmission = p_rsodDerniereAdmission;
  }
  
  public String getEtatMigration()
  {
    return m_etatMigration;
  }
  
  public void setEtatMigration(String p_etatMigration)
  {
    m_etatMigration = p_etatMigration;
  }
  
  public boolean estIndividuMigre()
  {
    return m_estMigre;
  }
  
  public void setIndividuMigre(boolean p_estMigre)
  {
    m_estMigre = p_estMigre;
  }
  
  public Damj getDdorkb()
  {
    return m_ddorkb;
  }
  
  public void setDdorkb(Damj p_ddorkb)
  {
    m_ddorkb = p_ddorkb;
  }
  
  public Damj getDatePeremptionTitreSejour()
  {
    return m_datePeremptionTitreSejour;
  }
  
  public void setDatePeremptionTitreSejour(Damj p_datePeremptionTitreSejour)
  {
    m_datePeremptionTitreSejour = p_datePeremptionTitreSejour;
  }
  
  public Damj getDjams()
  {
    return m_djams;
  }
  
  public void setDjams(Damj p_djams)
  {
    m_djams = p_djams;
  }
  
  public boolean estAlerteAD()
  {
    return m_estAlerteAD;
  }
  
  public void setEstAlerteAD(boolean p_estAlerteAD)
  {
    m_estAlerteAD = p_estAlerteAD;
  }
  
  public Damj getDateDeces()
  {
    return m_dateDeces;
  }
  
  public void setDateDeces(Damj p_dateDeces)
  {
    m_dateDeces = p_dateDeces;
  }
  
  public boolean isEstBeneficiaireRsa()
  {
    return m_estBeneficiaireRsa;
  }
  
  public void setEstBeneficiaireRsa(boolean p_estBeneficiaireRsa)
  {
    m_estBeneficiaireRsa = p_estBeneficiaireRsa;
  }
  
  public Damj getDateRetraiteAnticipe()
  {
    return dateRetraiteAnticipe;
  }
  
  public void setDateRetraiteAnticipe(Damj dateRetraiteAnticipe)
  {
    this.dateRetraiteAnticipe = dateRetraiteAnticipe;
  }
  
  public String getMotifRetraiteAnticipe()
  {
    return motifRetraiteAnticipe;
  }
  
  public void setMotifRetraiteAnticipe(String motifRetraiteAnticipe)
  {
    this.motifRetraiteAnticipe = motifRetraiteAnticipe;
  }
}

/* Location:
 * Qualified Name:     LireAllocataireResultat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */