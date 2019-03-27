package fr.pe.cali.reglementaire.regles.assurance.cep.reglementapplicable.dom;

import fr.pe.cali.reglementaire.regles.assurance.cep.reglementapplicable.outils.spec.IOutilFonctionnelReglementApplicable;
import fr.unedic.cali.dom.affectation.Reglement;
import fr.unedic.util.temps.Chronologie;

public class DonneesEntreesRegleReglementApplicable
{
  private Reglement reglementValidationProduit;
  private Reglement reglementDernierSinistre;
  Chronologie passeProfessionnel;
  IOutilFonctionnelReglementApplicable outilFonctionnel;
  boolean affiliationForcee;
  boolean droitInterimaireForcee;
  
  public Reglement getReglementValidationProduit()
  {
    return reglementValidationProduit;
  }
  
  public void setReglementValidationProduit(Reglement reglementValidationProduit)
  {
    this.reglementValidationProduit = reglementValidationProduit;
  }
  
  public Reglement getReglementDernierSinistre()
  {
    return reglementDernierSinistre;
  }
  
  public void setReglementDernierSinistre(Reglement reglementDernierSinistre)
  {
    this.reglementDernierSinistre = reglementDernierSinistre;
  }
  
  public Chronologie getPasseProfessionnel()
  {
    return passeProfessionnel;
  }
  
  public void setPasseProfessionnel(Chronologie passeProfessionnel)
  {
    this.passeProfessionnel = passeProfessionnel;
  }
  
  public IOutilFonctionnelReglementApplicable getOutilFonctionnel()
  {
    return outilFonctionnel;
  }
  
  public void setOutilFonctionnel(IOutilFonctionnelReglementApplicable outilFonctionnel)
  {
    this.outilFonctionnel = outilFonctionnel;
  }
  
  public boolean isAffiliationForcee()
  {
    return affiliationForcee;
  }
  
  public void setAffiliationForcee(boolean estAffiliationForcee)
  {
    affiliationForcee = estAffiliationForcee;
  }
  
  public boolean isDroitInterimaireForcee()
  {
    return droitInterimaireForcee;
  }
  
  public void setDroitInterimaireForcee(boolean estDroitInterimaireForcee)
  {
    droitInterimaireForcee = estDroitInterimaireForcee;
  }
}

/* Location:
 * Qualified Name:     DonneesEntreesRegleReglementApplicable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */