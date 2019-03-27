package fr.unedic.cali.autresdoms.cohab.sigma.individu.dom;

import fr.unedic.cali.autresdoms.cohab.sigma.individu.dom.spec.IndividuSpec;
import fr.unedic.cali.autresdoms.cohab.sigma.individu.dom.spec.TrimestreRetraiteSpec;
import fr.unedic.util.temps.Damj;

public class Individu
  implements IndividuSpec
{
  private String m_numeroAllocataire;
  private String m_nom;
  private String m_marital;
  private String m_prenom;
  private Damj m_dateNaissance;
  private Damj m_dateDeces;
  private Damj m_dateLiquidationRetraite = null;
  private Damj dateRetraiteAnticipe = null;
  private String motifRetraiteAnticipe;
  private TrimestreRetraiteSpec m_trimestreRetraite = null;
  private String m_etatCivil;
  private boolean m_beneficiaireSapa;
  private boolean m_beneficiaireRsa;
  private boolean m_acompteNonSolde;
  private boolean m_exclusionIndividuelle;
  private boolean m_individuMigre;
  private Damj m_dernierJourAtteste;
  private String m_etatMigration;
  private Damj m_dateLimiteIndemnisation;
  private String m_codeAntenne;
  private String m_referenceExterne;
  private String m_rsodDernierAdmission;
  private int m_codeEtatTransfert;
  private Damj m_dateCalculAuPlusTot;
  private Damj m_datePeremptionTitreSejour;
  private Damj m_djams;
  private Damj m_dateDerniereOD;
  private boolean m_estAlerteAD;
  private boolean m_estDeployeeAD;
  
  public Damj getDernierJourAtteste()
  {
    return m_dernierJourAtteste;
  }
  
  public Damj getDateLiquidationRetraite()
  {
    return m_dateLiquidationRetraite;
  }
  
  public Damj getDateNaissance()
  {
    return m_dateNaissance;
  }
  
  public Damj getDateDeces()
  {
    return m_dateDeces;
  }
  
  public String getNom()
  {
    return m_nom;
  }
  
  public String getNumeroAllocataire()
  {
    return m_numeroAllocataire;
  }
  
  public String getPrenom()
  {
    return m_prenom;
  }
  
  public TrimestreRetraiteSpec getTrimestreRetraite()
  {
    return m_trimestreRetraite;
  }
  
  public void setDateLiquidationRetraite(Damj p_dateLiquidationRetraite)
  {
    m_dateLiquidationRetraite = p_dateLiquidationRetraite;
  }
  
  public void setDateNaissance(Damj p_dateNaissance)
  {
    m_dateNaissance = p_dateNaissance;
  }
  
  public void setDateDeces(Damj p_dateDeces)
  {
    m_dateDeces = p_dateDeces;
  }
  
  public void setNom(String p_nom)
  {
    m_nom = p_nom;
  }
  
  public void setNumeroAllocataire(String p_numeroAllocataire)
  {
    m_numeroAllocataire = p_numeroAllocataire;
  }
  
  public void setPrenom(String p_prenom)
  {
    m_prenom = p_prenom;
  }
  
  public void setTrimestreRetraite(TrimestreRetraiteSpec p_nombreTrimestreRetraite)
  {
    m_trimestreRetraite = p_nombreTrimestreRetraite;
  }
  
  public String getEtatCivil()
  {
    return m_etatCivil;
  }
  
  public boolean isAcompteNonSolde()
  {
    return m_acompteNonSolde;
  }
  
  public boolean isBeneficiaireSapa()
  {
    return m_beneficiaireSapa;
  }
  
  public boolean isExclusionIndividuelle()
  {
    return m_exclusionIndividuelle;
  }
  
  public void setDernierJourAtteste(Damj p_dernierJourAtteste)
  {
    m_dernierJourAtteste = p_dernierJourAtteste;
  }
  
  public void setAcompteNonSolde(boolean p_acompteNonSolde)
  {
    m_acompteNonSolde = p_acompteNonSolde;
  }
  
  public void setBeneficiaireSapa(boolean p_beneficiaraSAPA)
  {
    m_beneficiaireSapa = p_beneficiaraSAPA;
  }
  
  public void setEtatCivil(String p_etatCivil)
  {
    m_etatCivil = p_etatCivil;
  }
  
  public void setExclusionIndividuelle(boolean p_exclusionIndividuelle)
  {
    m_exclusionIndividuelle = p_exclusionIndividuelle;
  }
  
  public boolean isIndividuMigre()
  {
    return m_individuMigre;
  }
  
  public void setIndividuMigre(boolean p_individuMigre)
  {
    m_individuMigre = p_individuMigre;
  }
  
  public String toString()
  {
    return getEtatCivil() + " " + getPrenom() + " " + getNom() + " - " + getNumeroAllocataire() + " (" + getDateNaissance() + ")\n" + "Migré                  ? " + (isIndividuMigre() ? "Oui" : "Non") + "\n" + "Date Retraite          : " + getDateLiquidationRetraite() + "\n" + "Exclusion Individuelle ? " + (isExclusionIndividuelle() ? "Oui" : "Non") + "\n" + "Bénéficiare SAPA       ? " + (isBeneficiaireSapa() ? "Oui" : "Non") + "\n" + "Trimestre Retraite     : " + getTrimestreRetraite() + "\n" + "Dernier jour attesté   : " + getDernierJourAtteste() + "\n" + "Date Péremption Séjour : " + getDatePeremptionTitreSejour();
  }
  
  public String getEtatMigration()
  {
    return m_etatMigration;
  }
  
  public void setEtatMigration(String p_etatMigration)
  {
    m_etatMigration = p_etatMigration;
  }
  
  public Damj getDateLimiteIndemnisation()
  {
    return m_dateLimiteIndemnisation;
  }
  
  public void setDateLimiteIndemnisation(Damj p_dateLimiteIndemnisation)
  {
    m_dateLimiteIndemnisation = p_dateLimiteIndemnisation;
  }
  
  public String getCodeAntenne()
  {
    return m_codeAntenne;
  }
  
  public void setCodeAntenne(String p_codeAntenne)
  {
    m_codeAntenne = p_codeAntenne;
  }
  
  public String getReferenceExterne()
  {
    return m_referenceExterne;
  }
  
  public void setReferenceExterne(String p_referenceExterne)
  {
    m_referenceExterne = p_referenceExterne;
  }
  
  public String getNomMarital()
  {
    return m_marital;
  }
  
  public void setNomMarital(String p_marital)
  {
    m_marital = p_marital;
  }
  
  public String getRsodDernierAdmission()
  {
    return m_rsodDernierAdmission;
  }
  
  public void setRsodDernierAdmission(String p_rsodDernierAdmission)
  {
    m_rsodDernierAdmission = p_rsodDernierAdmission;
  }
  
  public int getCodeEtatTransfert()
  {
    return m_codeEtatTransfert;
  }
  
  public void setCodeEtatTransfert(int p_codeEtatTransfert)
  {
    m_codeEtatTransfert = p_codeEtatTransfert;
  }
  
  public Damj getDateDeCalculAuPlusTot()
  {
    return m_dateCalculAuPlusTot;
  }
  
  public void setDateDeCalculAuPlusTot(Damj p_dateDeCalculAuPlusTot)
  {
    m_dateCalculAuPlusTot = p_dateDeCalculAuPlusTot;
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
  
  public Damj getDateDerniereOD()
  {
    return m_dateDerniereOD;
  }
  
  public void setDateDerniereOD(Damj p_derniereOD)
  {
    m_dateDerniereOD = p_derniereOD;
  }
  
  public boolean estAlerteAD()
  {
    return m_estAlerteAD;
  }
  
  public void setEstAlerteAD(boolean p_estAlerteAD)
  {
    m_estAlerteAD = p_estAlerteAD;
  }
  
  public boolean estDeployeeAD()
  {
    return m_estDeployeeAD;
  }
  
  public void setEstDeployeeAD(boolean p_estDeployeAD)
  {
    m_estDeployeeAD = p_estDeployeAD;
  }
  
  public boolean isBeneficiaireRsa()
  {
    return m_beneficiaireRsa;
  }
  
  public void setBeneficiaireRsa(boolean p_beneficiaireRsa)
  {
    m_beneficiaireRsa = p_beneficiaireRsa;
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
 * Qualified Name:     Individu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */