package fr.pe.cali.reglementaire.regles.assurance.cep.sjr.diviseur.dom;

import java.math.BigDecimal;

public class DonneesEntreesCalculDiviseur
{
  private int nombreJoursEmploi;
  private int nombreJoursContratPlafonnes;
  private BigDecimal nombreJoursAbsence;
  
  public int getNombreJoursEmploi()
  {
    return nombreJoursEmploi;
  }
  
  public void setNombreJoursEmploi(int nombreJoursEmploi)
  {
    this.nombreJoursEmploi = nombreJoursEmploi;
  }
  
  public int getNombreJoursContratPlafonnes()
  {
    return nombreJoursContratPlafonnes;
  }
  
  public void setNombreJoursContratPlafonnes(int nombreJoursContratPlafonnes)
  {
    this.nombreJoursContratPlafonnes = nombreJoursContratPlafonnes;
  }
  
  public BigDecimal getNombreJoursAbsence()
  {
    return nombreJoursAbsence;
  }
  
  public void setNombreJoursAbsence(BigDecimal nombreJoursAbsence)
  {
    this.nombreJoursAbsence = nombreJoursAbsence;
  }
}

/* Location:
 * Qualified Name:     DonneesEntreesCalculDiviseur
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */