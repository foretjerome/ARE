package fr.unedic.cali.calcul.dom.temps;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class ObjetChronoAnniversaire50Ans
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = 4112858351328944845L;
  
  private ObjetChronoAnniversaire50Ans() {}
  
  public ObjetChronoAnniversaire50Ans(Damj p_date)
  {
    super(p_date, p_date);
  }
  
  public ObjetMetierSpec copie()
  {
    ObjetChronoAnniversaire50Ans copie = new ObjetChronoAnniversaire50Ans();
    copieElements(copie);
    return copie;
  }
}

/* Location:
 * Qualified Name:     ObjetChronoAnniversaire50Ans
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */