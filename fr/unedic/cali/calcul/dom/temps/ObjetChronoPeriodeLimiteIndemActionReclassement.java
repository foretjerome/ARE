package fr.unedic.cali.calcul.dom.temps;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class ObjetChronoPeriodeLimiteIndemActionReclassement
  extends ObjetChronoPeriodeCalculTransient
{
  private ObjetChronoPeriodeLimiteIndemActionReclassement() {}
  
  public ObjetChronoPeriodeLimiteIndemActionReclassement(Damj p_debut, Damj p_fin)
  {
    super(p_debut, p_fin);
  }
  
  public ObjetMetierSpec copie()
  {
    ObjetChronoPeriodeLimiteIndemActionReclassement copie = new ObjetChronoPeriodeLimiteIndemActionReclassement();
    copieElements(copie);
    return copie;
  }
}

/* Location:
 * Qualified Name:     ObjetChronoPeriodeLimiteIndemActionReclassement
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */