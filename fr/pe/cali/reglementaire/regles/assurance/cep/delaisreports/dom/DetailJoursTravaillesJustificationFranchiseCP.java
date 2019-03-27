package fr.pe.cali.reglementaire.regles.assurance.cep.delaisreports.dom;

import fr.unedic.util.temps.Periode;

public class DetailJoursTravaillesJustificationFranchiseCP
{
  private String raisonSociale;
  private Periode periodeContrat;
  private int nombresJoursTravaillesAttestes;
  
  public String getRaisonSociale()
  {
    return raisonSociale;
  }
  
  public void setRaisonSociale(String raisonSociale)
  {
    this.raisonSociale = raisonSociale;
  }
  
  public Periode getPeriodeContrat()
  {
    return periodeContrat;
  }
  
  public void setPeriodeContrat(Periode periodeContrat)
  {
    this.periodeContrat = periodeContrat;
  }
  
  public int getNombresJoursTravaillesAttestes()
  {
    return nombresJoursTravaillesAttestes;
  }
  
  public void setNombresJoursTravaillesAttestes(int nombresJoursTravaillesAttestes)
  {
    this.nombresJoursTravaillesAttestes = nombresJoursTravaillesAttestes;
  }
}

/* Location:
 * Qualified Name:     DetailJoursTravaillesJustificationFranchiseCP
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */