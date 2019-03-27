package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class PansNonInstallee
  extends PeriodeTravailJustifiee
{
  protected PansNonInstallee() {}
  
  public PansNonInstallee(Damj p_dateDebut, Damj p_dateFin)
  {
    super(p_dateDebut, p_dateFin);
  }
  
  public ObjetMetierSpec copie()
  {
    PansNonInstallee copie = new PansNonInstallee();
    copieElements(copie);
    return copie;
  }
}

/* Location:
 * Qualified Name:     PansNonInstallee
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */