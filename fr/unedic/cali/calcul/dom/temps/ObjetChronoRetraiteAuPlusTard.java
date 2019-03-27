package fr.unedic.cali.calcul.dom.temps;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class ObjetChronoRetraiteAuPlusTard
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = 1L;
  
  private ObjetChronoRetraiteAuPlusTard() {}
  
  public ObjetChronoRetraiteAuPlusTard(Damj p_date)
  {
    super(p_date, p_date);
  }
  
  public ObjetMetierSpec copie()
  {
    ObjetChronoRetraiteAuPlusTard copie = new ObjetChronoRetraiteAuPlusTard();
    copieElements(copie);
    return copie;
  }
}

/* Location:
 * Qualified Name:     ObjetChronoRetraiteAuPlusTard
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */