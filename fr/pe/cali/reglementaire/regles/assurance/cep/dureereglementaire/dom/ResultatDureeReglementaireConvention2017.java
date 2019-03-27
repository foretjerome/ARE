package fr.pe.cali.reglementaire.regles.assurance.cep.dureereglementaire.dom;

import fr.unedic.util.Unite;

public class ResultatDureeReglementaireConvention2017
{
  private int dureeTheoriqueDroitCourant = 0;
  private int dureeTheoriqueAvantImputation = 0;
  private int dureeImputationFormation = 0;
  private int dureeImputationForcee = 0;
  private boolean eligibleAllongement = false;
  private int dureeAllongementPossible = 0;
  private int dureeAllongementPossibleDroitSousJacent = 0;
  private Unite uniteRetenu = null;
  private boolean plusieursUnites = false;
  private int dureeMinimale = 0;
  private int dureeMaximale = 0;
  private int dureeCalculeeAvantPlafondPlancher = 0;
  
  public int getDureeTheoriqueDroitCourant()
  {
    return dureeTheoriqueDroitCourant;
  }
  
  public void setDureeTheoriqueDroitCourant(int dureeTheoriqueDroitCourant)
  {
    this.dureeTheoriqueDroitCourant = dureeTheoriqueDroitCourant;
  }
  
  public int getDureeImputationFormation()
  {
    return dureeImputationFormation;
  }
  
  public void setDureeImputationFormation(int dureeImputationFormation)
  {
    this.dureeImputationFormation = dureeImputationFormation;
  }
  
  public int getDureeImputationForcee()
  {
    return dureeImputationForcee;
  }
  
  public void setDureeImputationForcee(int dureeImputationForcee)
  {
    this.dureeImputationForcee = dureeImputationForcee;
  }
  
  public int getDureeTheoriqueAvantImputation()
  {
    return dureeTheoriqueAvantImputation;
  }
  
  public void setDureeTheoriqueAvantImputation(int dureeTheoriqueAvantImputation)
  {
    this.dureeTheoriqueAvantImputation = dureeTheoriqueAvantImputation;
  }
  
  public boolean isEligibleAllongement()
  {
    return eligibleAllongement;
  }
  
  public void setEligibleAllongement(boolean eligibleAllongement)
  {
    this.eligibleAllongement = eligibleAllongement;
  }
  
  public int getDureeAllongementPossible()
  {
    return dureeAllongementPossible;
  }
  
  public void setDureeAllongementPossible(int dureeAllongementPossible)
  {
    this.dureeAllongementPossible = dureeAllongementPossible;
  }
  
  public int getDureeAllongementPossibleDroitSousJacent()
  {
    return dureeAllongementPossibleDroitSousJacent;
  }
  
  public void setDureeAllongementPossibleDroitSousJacent(int dureeAllongementPossibleDroitSousJacent)
  {
    this.dureeAllongementPossibleDroitSousJacent = dureeAllongementPossibleDroitSousJacent;
  }
  
  public Unite getUniteRetenu()
  {
    return uniteRetenu;
  }
  
  public void setUniteRetenu(Unite uniteRetenu)
  {
    this.uniteRetenu = uniteRetenu;
  }
  
  public boolean isPlusieursUnites()
  {
    return plusieursUnites;
  }
  
  public void setPlusieursUnites(boolean plusieursUnites)
  {
    this.plusieursUnites = plusieursUnites;
  }
  
  public int getDureeMinimale()
  {
    return dureeMinimale;
  }
  
  public void setDureeMinimale(int dureeMinimale)
  {
    this.dureeMinimale = dureeMinimale;
  }
  
  public int getDureeMaximale()
  {
    return dureeMaximale;
  }
  
  public void setDureeMaximale(int dureeMaximale)
  {
    this.dureeMaximale = dureeMaximale;
  }
  
  public int getDureeCalculeeAvantPlafondPlancher()
  {
    return dureeCalculeeAvantPlafondPlancher;
  }
  
  public void setDureeCalculeeAvantPlafondPlancher(int dureeCalculeeAvantPlafond)
  {
    dureeCalculeeAvantPlafondPlancher = dureeCalculeeAvantPlafond;
  }
}

/* Location:
 * Qualified Name:     ResultatDureeReglementaireConvention2017
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */