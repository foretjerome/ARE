package fr.unedic.cali.calcul.dom.temps;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class ObjetChronoAnniversaire65Ans
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = 2924446061708665552L;
  
  private ObjetChronoAnniversaire65Ans() {}
  
  public ObjetChronoAnniversaire65Ans(Damj p_date)
  {
    super(p_date, p_date);
  }
  
  public ObjetMetierSpec copie()
  {
    ObjetChronoAnniversaire65Ans copie = new ObjetChronoAnniversaire65Ans();
    copieElements(copie);
    return copie;
  }
}

/* Location:
 * Qualified Name:     ObjetChronoAnniversaire65Ans
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */