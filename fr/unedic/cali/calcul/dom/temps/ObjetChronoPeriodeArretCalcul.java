package fr.unedic.cali.calcul.dom.temps;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class ObjetChronoPeriodeArretCalcul
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = -7234883592080622002L;
  
  private ObjetChronoPeriodeArretCalcul() {}
  
  public ObjetChronoPeriodeArretCalcul(Damj p_date)
  {
    super(p_date, p_date);
  }
  
  public ObjetMetierSpec copie()
  {
    ObjetChronoPeriodeArretCalcul copie = new ObjetChronoPeriodeArretCalcul();
    copieElements(copie);
    return copie;
  }
}

/* Location:
 * Qualified Name:     ObjetChronoPeriodeArretCalcul
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */