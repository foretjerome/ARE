package fr.unedic.cali.calcul.dom.temps;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class ObjetChronoPeriodeSegmentationARI
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = 4079476960298698062L;
  
  public ObjetChronoPeriodeSegmentationARI() {}
  
  public ObjetChronoPeriodeSegmentationARI(Damj p_date)
  {
    super(p_date, p_date);
  }
  
  public ObjetMetierSpec copie()
  {
    ObjetChronoPeriodeSegmentationARI copie = new ObjetChronoPeriodeSegmentationARI();
    copieElements(copie);
    return copie;
  }
}

/* Location:
 * Qualified Name:     ObjetChronoPeriodeSegmentationARI
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */