package fr.unedic.cali.autresdoms.d12i.dom;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoPeriodeConcrete;

public class PeriodeAffiliationInstruction
  extends ObjetChronoPeriodeConcrete
{
  private static final long serialVersionUID = 5528498293583986244L;
  private String topPropositionCSP = "N";
  private Boolean topPropositionPap = Boolean.valueOf(false);
  
  public PeriodeAffiliationInstruction(Damj dateDebutCali, Damj dateFinCali)
  {
    super(dateDebutCali, dateFinCali);
  }
  
  public PeriodeAffiliationInstruction() {}
  
  public void setTopPropositionCSP(String topPropositionCSP)
  {
    this.topPropositionCSP = topPropositionCSP;
  }
  
  public String getTopPropositionCSP()
  {
    return topPropositionCSP;
  }
  
  public void setTopPropositionPAP(Boolean topPropositionPap)
  {
    this.topPropositionPap = topPropositionPap;
  }
  
  public Boolean getTopPropositionPAP()
  {
    return topPropositionPap;
  }
  
  public void copieElements(ObjetMetierSpec copie)
  {
    super.copieElements(copie);
    ((PeriodeAffiliationInstruction)copie).setTopPropositionCSP(getTopPropositionCSP());
  }
  
  public PeriodeAffiliationInstruction copie()
  {
    PeriodeAffiliationInstruction copie = new PeriodeAffiliationInstruction();
    copieElements(copie);
    return copie;
  }
}

/* Location:
 * Qualified Name:     PeriodeAffiliationInstruction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */