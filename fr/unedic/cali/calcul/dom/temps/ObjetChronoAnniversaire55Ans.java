package fr.unedic.cali.calcul.dom.temps;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class ObjetChronoAnniversaire55Ans
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = -1453833241813104113L;
  
  private ObjetChronoAnniversaire55Ans() {}
  
  public ObjetChronoAnniversaire55Ans(Damj p_date)
  {
    super(p_date, p_date);
  }
  
  public ObjetMetierSpec copie()
  {
    ObjetChronoAnniversaire55Ans copie = new ObjetChronoAnniversaire55Ans();
    copieElements(copie);
    return copie;
  }
}

/* Location:
 * Qualified Name:     ObjetChronoAnniversaire55Ans
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */