package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class FinPeriodePensionInvalidite
  extends FinPeriodePension
{
  protected FinPeriodePensionInvalidite() {}
  
  public FinPeriodePensionInvalidite(Damj p_date)
  {
    super(p_date);
  }
  
  public ObjetMetierSpec copie()
  {
    FinPeriodePensionInvalidite copie = new FinPeriodePensionInvalidite();
    copieElements(copie);
    return copie;
  }
}

/* Location:
 * Qualified Name:     FinPeriodePensionInvalidite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */