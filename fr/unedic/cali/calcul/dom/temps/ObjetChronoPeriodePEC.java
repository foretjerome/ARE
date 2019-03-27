package fr.unedic.cali.calcul.dom.temps;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class ObjetChronoPeriodePEC
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = -9087118644694030648L;
  
  private ObjetChronoPeriodePEC() {}
  
  public ObjetChronoPeriodePEC(Damj p_debut, Damj p_fin)
  {
    super(p_debut, p_fin);
  }
  
  public ObjetMetierSpec copie()
  {
    ObjetChronoPeriodePEC copie = new ObjetChronoPeriodePEC();
    copieElements(copie);
    return copie;
  }
}

/* Location:
 * Qualified Name:     ObjetChronoPeriodePEC
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */