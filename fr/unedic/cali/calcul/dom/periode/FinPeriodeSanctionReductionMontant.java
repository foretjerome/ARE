package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class FinPeriodeSanctionReductionMontant
  extends FinPeriodeSanction
{
  protected FinPeriodeSanctionReductionMontant() {}
  
  public FinPeriodeSanctionReductionMontant(Damj p_date)
  {
    super(p_date);
  }
  
  public ObjetMetierSpec copie()
  {
    FinPeriodeSanctionReductionMontant copie = new FinPeriodeSanctionReductionMontant();
    copieElements(copie);
    return copie;
  }
}

/* Location:
 * Qualified Name:     FinPeriodeSanctionReductionMontant
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */