package fr.pe.cali.reglementaire.regles.assurance.cep.sjr.diviseur.dom;

import java.math.BigDecimal;

public class ResultatCalculDiviseur
{
  private BigDecimal diviseur;
  private BigDecimal diviseurTravaille;
  private BigDecimal coefficientAbsence;
  private String formuleCalculDiviseur;
  private String formuleCalculCoefficientAbsence;
  
  public BigDecimal getDiviseur()
  {
    return diviseur;
  }
  
  public void setDiviseur(BigDecimal diviseur)
  {
    this.diviseur = diviseur;
  }
  
  public BigDecimal getCoefficientAbsence()
  {
    return coefficientAbsence;
  }
  
  public void setCoefficientAbsence(BigDecimal coefficientAbsence)
  {
    this.coefficientAbsence = coefficientAbsence;
  }
  
  public String getFormuleCalculDiviseur()
  {
    return formuleCalculDiviseur;
  }
  
  public void setFormuleCalculDiviseur(String formuleCalculDiviseur)
  {
    this.formuleCalculDiviseur = formuleCalculDiviseur;
  }
  
  public String getFormuleCalculCoefficientAbsence()
  {
    return formuleCalculCoefficientAbsence;
  }
  
  public void setFormuleCalculCoefficientAbsence(String formuleCalculCoefficientAbsence)
  {
    this.formuleCalculCoefficientAbsence = formuleCalculCoefficientAbsence;
  }
  
  public BigDecimal getDiviseurTravaille()
  {
    return diviseurTravaille;
  }
  
  public void setDiviseurTravaille(BigDecimal diviseurTravaille)
  {
    this.diviseurTravaille = diviseurTravaille;
  }
}

/* Location:
 * Qualified Name:     ResultatCalculDiviseur
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */