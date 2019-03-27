package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class PeriodePensionInvalidite
  extends PeriodePension
{
  protected PeriodePensionInvalidite() {}
  
  public PeriodePensionInvalidite(Damj p_debut, Damj p_fin)
  {
    super(p_debut, p_fin);
  }
  
  public ObjetMetierSpec copie()
  {
    PeriodePensionInvalidite copie = new PeriodePensionInvalidite();
    copieElements(copie);
    return copie;
  }
}

/* Location:
 * Qualified Name:     PeriodePensionInvalidite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */