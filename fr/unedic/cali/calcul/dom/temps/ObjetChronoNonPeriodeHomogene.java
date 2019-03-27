package fr.unedic.cali.calcul.dom.temps;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class ObjetChronoNonPeriodeHomogene
  extends ObjetChronoPeriodeCalculTransient
{
  public ObjetChronoNonPeriodeHomogene() {}
  
  public ObjetChronoNonPeriodeHomogene(Damj p_debut, Damj p_fin)
  {
    super(p_debut, p_fin);
  }
  
  public ObjetMetierSpec copie()
  {
    ObjetChronoNonPeriodeHomogene copie = new ObjetChronoNonPeriodeHomogene();
    copieElements(copie);
    return copie;
  }
}

/* Location:
 * Qualified Name:     ObjetChronoNonPeriodeHomogene
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */