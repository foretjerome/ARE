package fr.pe.cali.reglementaire.regles.assurance.cep.reglementapplicable.dom;

import fr.unedic.cali.dom.affectation.Reglement;

public class ResultatRegleReglementApplicable
{
  private Reglement reglementApplicable;
  private boolean droitInterimaire;
  
  public Reglement getReglementApplicable()
  {
    return reglementApplicable;
  }
  
  public void setReglementApplicable(Reglement reglementApplicable)
  {
    this.reglementApplicable = reglementApplicable;
  }
  
  public boolean isDroitInterimaire()
  {
    return droitInterimaire;
  }
  
  public void setDroitInterimaire(boolean droitInterimaire)
  {
    this.droitInterimaire = droitInterimaire;
  }
}

/* Location:
 * Qualified Name:     ResultatRegleReglementApplicable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */