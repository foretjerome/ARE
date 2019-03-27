package fr.unedic.cali.calcul.dom.temps;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class ObjetChronoPeriodeHomogene
  extends ObjetChronoPeriodeCalculTransient
{
  private ObjetChronoPeriodeHomogene() {}
  
  public ObjetChronoPeriodeHomogene(Damj p_debut, Damj p_fin)
  {
    super(p_debut, p_fin);
  }
  
  public ObjetMetierSpec copie()
  {
    ObjetChronoPeriodeHomogene copie = new ObjetChronoPeriodeHomogene();
    copieElements(copie);
    return copie;
  }
}

/* Location:
 * Qualified Name:     ObjetChronoPeriodeHomogene
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */