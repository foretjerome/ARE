package fr.pe.cali.reglementaire.regles.assurance.cep.datelimite.dom;

import fr.unedic.util.temps.Damj;

public class DonneesSortieDateLimiteSpectacle
{
  private Damj dateLimiteIndemnisation;
  private JustificationDateLimiteDateLimite justification;
  
  public Damj getDateLimiteIndemnisation()
  {
    return dateLimiteIndemnisation;
  }
  
  public void setDateLimiteIndemnisation(Damj dateLimiteIndemnisation)
  {
    this.dateLimiteIndemnisation = dateLimiteIndemnisation;
  }
  
  public JustificationDateLimiteDateLimite getJustification()
  {
    return justification;
  }
  
  public void setJustification(JustificationDateLimiteDateLimite justification)
  {
    this.justification = justification;
  }
}

/* Location:
 * Qualified Name:     DonneesSortieDateLimiteSpectacle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */