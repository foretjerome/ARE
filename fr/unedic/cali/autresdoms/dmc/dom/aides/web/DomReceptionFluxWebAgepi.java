package fr.unedic.cali.autresdoms.dmc.dom.aides.web;

import fr.unedic.util.temps.Damj;

public class DomReceptionFluxWebAgepi
  extends DomReceptionFluxWebAbstrait
{
  private Damj dateDebutDemande;
  private Damj dateFinDemande;
  private Integer nombreEnfants;
  private Integer nombreEnfantMoins10Ans;
  private Boolean topParentEnfantMoins10Ans;
  private Boolean topParentIsole;
  
  public Damj getDateDebutDemande()
  {
    return dateDebutDemande;
  }
  
  public void setDateDebutDemande(Damj dateDebutDemande)
  {
    this.dateDebutDemande = dateDebutDemande;
  }
  
  public Damj getDateFinDemande()
  {
    return dateFinDemande;
  }
  
  public void setDateFinDemande(Damj dateFinDemande)
  {
    this.dateFinDemande = dateFinDemande;
  }
  
  public Integer getNombreEnfants()
  {
    return nombreEnfants;
  }
  
  public void setNombreEnfants(Integer nombreEnfants)
  {
    this.nombreEnfants = nombreEnfants;
  }
  
  public Integer getNombreEnfantMoins10Ans()
  {
    return nombreEnfantMoins10Ans;
  }
  
  public void setNombreEnfantMoins10Ans(Integer nombreEnfantMoins10Ans)
  {
    this.nombreEnfantMoins10Ans = nombreEnfantMoins10Ans;
  }
  
  public Boolean getTopParentEnfantMoins10Ans()
  {
    return topParentEnfantMoins10Ans;
  }
  
  public void setTopParentEnfantMoins10Ans(Boolean topParentEnfantMoins10Ans)
  {
    this.topParentEnfantMoins10Ans = topParentEnfantMoins10Ans;
  }
  
  public Boolean getTopParentIsole()
  {
    return topParentIsole;
  }
  
  public void setTopParentIsole(Boolean topParentIsole)
  {
    this.topParentIsole = topParentIsole;
  }
}

/* Location:
 * Qualified Name:     DomReceptionFluxWebAgepi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */