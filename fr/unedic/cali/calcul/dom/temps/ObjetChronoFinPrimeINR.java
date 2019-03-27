package fr.unedic.cali.calcul.dom.temps;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class ObjetChronoFinPrimeINR
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = -6015667362783492396L;
  
  private ObjetChronoFinPrimeINR() {}
  
  public ObjetChronoFinPrimeINR(Damj date)
  {
    super(date, date);
  }
  
  public ObjetMetierSpec copie()
  {
    ObjetChronoFinPrimeINR copie = new ObjetChronoFinPrimeINR();
    copieElements(copie);
    return copie;
  }
}

/* Location:
 * Qualified Name:     ObjetChronoFinPrimeINR
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */