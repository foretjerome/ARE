package fr.pe.cali.reglementaire.regles.solidarite.cap.beneficiaireaah.dom;

import fr.unedic.cali.dom.PeriodeDroitAAH;

public class DonneesSortieBeneficiaireAAH
{
  private boolean satisfait;
  private PeriodeDroitAAH periodeDroitAAH;
  
  public boolean isSatisfait()
  {
    return satisfait;
  }
  
  public void setSatisfait(boolean satisfait)
  {
    this.satisfait = satisfait;
  }
  
  public PeriodeDroitAAH getPeriodeDroitAAH()
  {
    return periodeDroitAAH;
  }
  
  public void setPeriodeDroitAAH(PeriodeDroitAAH periodeDroitAAH)
  {
    this.periodeDroitAAH = periodeDroitAAH;
  }
}

/* Location:
 * Qualified Name:     DonneesSortieBeneficiaireAAH
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */