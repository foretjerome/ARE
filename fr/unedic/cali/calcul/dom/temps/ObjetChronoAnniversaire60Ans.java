package fr.unedic.cali.calcul.dom.temps;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class ObjetChronoAnniversaire60Ans
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = 4963381813893420474L;
  
  private ObjetChronoAnniversaire60Ans() {}
  
  public ObjetChronoAnniversaire60Ans(Damj p_date)
  {
    super(p_date, p_date);
  }
  
  public ObjetMetierSpec copie()
  {
    ObjetChronoAnniversaire60Ans copie = new ObjetChronoAnniversaire60Ans();
    copieElements(copie);
    return copie;
  }
}

/* Location:
 * Qualified Name:     ObjetChronoAnniversaire60Ans
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */