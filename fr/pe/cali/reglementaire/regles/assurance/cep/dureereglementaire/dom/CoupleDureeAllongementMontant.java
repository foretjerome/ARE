package fr.pe.cali.reglementaire.regles.assurance.cep.dureereglementaire.dom;

import java.math.BigDecimal;

public class CoupleDureeAllongementMontant
{
  private int dureeAllongement;
  private BigDecimal montant;
  
  public int getDureeAllongement()
  {
    return dureeAllongement;
  }
  
  public void setDureeAllongement(int duree)
  {
    dureeAllongement = duree;
  }
  
  public BigDecimal getMontant()
  {
    return montant;
  }
  
  public void setMontant(BigDecimal montant)
  {
    this.montant = montant;
  }
}

/* Location:
 * Qualified Name:     CoupleDureeAllongementMontant
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */