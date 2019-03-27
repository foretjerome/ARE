package fr.unedic.cali.dom.conteneurs;

import fr.unedic.cali.dom.SalaireReferenceSpec;
import fr.unedic.cali.dom.affectation.Reglement;
import fr.unedic.util.Quantite;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;

public class DonneesCalculMontantSpectacle
{
  private Reglement reglementApplicable;
  private Quantite affiliationRequisePourPRA;
  private SalaireReferenceSpec salaireReference;
  private BigDecimal nombreHeureTravaillesEtendu;
  private BigDecimal nombreHeuresTravailleesPlafonnees = null;
  private BigDecimal nombreHeuresTravailleesMajorees = null;
  private int coefficientHoraireJour = 0;
  private int nbJoursEmploiSurPrc;
  private Periode prc;
  private int rangAllongementPRA = 0;
  private BigDecimal montantCRA = null;
  private boolean clauseRattrapage = false;
  private int nombreJoursInactivite = 0;
  
  public Quantite getAffiliationRequisePourPRA()
  {
    return affiliationRequisePourPRA;
  }
  
  public void setAffiliationRequisePourPRA(Quantite affiliationRequisePourPRA)
  {
    this.affiliationRequisePourPRA = affiliationRequisePourPRA;
  }
  
  public int getCoefficientHoraireJour()
  {
    return coefficientHoraireJour;
  }
  
  public void setCoefficientHoraireJour(int coefficientHoraireJour)
  {
    this.coefficientHoraireJour = coefficientHoraireJour;
  }
  
  public int getNbJoursEmploiSurPrc()
  {
    return nbJoursEmploiSurPrc;
  }
  
  public void setNbJoursEmploiSurPrc(int nbJoursEmploiSurPrc)
  {
    this.nbJoursEmploiSurPrc = nbJoursEmploiSurPrc;
  }
  
  public BigDecimal getNombreHeuresTravailleesPlafonnees()
  {
    return nombreHeuresTravailleesPlafonnees;
  }
  
  public void setNombreHeuresTravailleesPlafonnees(BigDecimal nombreHeuresTravailleesPlafonnees)
  {
    this.nombreHeuresTravailleesPlafonnees = nombreHeuresTravailleesPlafonnees;
  }
  
  public BigDecimal getNombreHeureTravaillesEtendu()
  {
    return nombreHeureTravaillesEtendu;
  }
  
  public void setNombreHeureTravaillesEtendu(BigDecimal nombreHeureTravaillesEtendu)
  {
    this.nombreHeureTravaillesEtendu = nombreHeureTravaillesEtendu;
  }
  
  public Reglement getReglementApplicable()
  {
    return reglementApplicable;
  }
  
  public void setReglementApplicable(Reglement reglementApplicable)
  {
    this.reglementApplicable = reglementApplicable;
  }
  
  public SalaireReferenceSpec getSalaireReference()
  {
    return salaireReference;
  }
  
  public void setSalaireReference(SalaireReferenceSpec salaireReference)
  {
    this.salaireReference = salaireReference;
  }
  
  public Periode getPrc()
  {
    return prc;
  }
  
  public void setPrc(Periode prc)
  {
    this.prc = prc;
  }
  
  public DonneesCalculMontantSpectacle copie()
  {
    DonneesCalculMontantSpectacle copie = new DonneesCalculMontantSpectacle();
    copie.setAffiliationRequisePourPRA(getAffiliationRequisePourPRA());
    copie.setCoefficientHoraireJour(getCoefficientHoraireJour());
    copie.setNbJoursEmploiSurPrc(getNbJoursEmploiSurPrc());
    copie.setNombreHeuresTravailleesPlafonnees(getNombreHeuresTravailleesPlafonnees());
    copie.setNombreHeureTravaillesEtendu(getNombreHeureTravaillesEtendu());
    copie.setNombreHeuresTravailleesMajorees(getNombreHeuresTravailleesMajorees());
    if (getPrc() != null) {
      copie.setPrc((Periode)getPrc().copie());
    }
    copie.setReglementApplicable(getReglementApplicable());
    if (getSalaireReference() != null) {
      copie.setSalaireReference((SalaireReferenceSpec)getSalaireReference().copie());
    }
    copie.setRangAllongementPRA(getRangAllongementPRA());
    return copie;
  }
  
  public int getRangAllongementPRA()
  {
    return rangAllongementPRA;
  }
  
  public void setRangAllongementPRA(int rangAllongementPRA)
  {
    this.rangAllongementPRA = rangAllongementPRA;
  }
  
  public BigDecimal getNombreHeuresTravailleesMajorees()
  {
    return nombreHeuresTravailleesMajorees;
  }
  
  public void setNombreHeuresTravailleesMajorees(BigDecimal nombreHeuresTravailleesMajorees)
  {
    this.nombreHeuresTravailleesMajorees = nombreHeuresTravailleesMajorees;
  }
  
  public BigDecimal getMontantCRA()
  {
    return montantCRA;
  }
  
  public void setMontantCRA(BigDecimal montantCRA)
  {
    this.montantCRA = montantCRA;
  }
  
  public boolean isClauseRattrapage()
  {
    return clauseRattrapage;
  }
  
  public void setClauseRattrapage(boolean clauseRattrapage)
  {
    this.clauseRattrapage = clauseRattrapage;
  }
  
  public int getNombreJoursInactivite()
  {
    return nombreJoursInactivite;
  }
  
  public void setNombreJoursInactivite(int nombreJoursInactivite)
  {
    this.nombreJoursInactivite = nombreJoursInactivite;
  }
}

/* Location:
 * Qualified Name:     DonneesCalculMontantSpectacle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */