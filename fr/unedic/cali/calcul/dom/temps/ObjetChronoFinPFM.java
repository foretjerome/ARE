package fr.unedic.cali.calcul.dom.temps;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class ObjetChronoFinPFM
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = 6481176979490177603L;
  
  private ObjetChronoFinPFM() {}
  
  public ObjetChronoFinPFM(Damj p_date)
  {
    super(p_date, p_date);
  }
  
  public ObjetMetierSpec copie()
  {
    ObjetChronoFinPFM copie = new ObjetChronoFinPFM();
    copieElements(copie);
    return copie;
  }
}

/* Location:
 * Qualified Name:     ObjetChronoFinPFM
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */