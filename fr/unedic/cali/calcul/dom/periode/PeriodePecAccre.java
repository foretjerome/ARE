package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeCalculTransient;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class PeriodePecAccre
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = 3604425100783088280L;
  
  private PeriodePecAccre() {}
  
  public PeriodePecAccre(Damj p_dateDebut, Damj p_dateFin)
  {
    super(p_dateDebut, p_dateFin);
  }
  
  public ObjetMetierSpec copie()
  {
    PeriodePecAccre copie = new PeriodePecAccre();
    copieElements(copie);
    return copie;
  }
}

/* Location:
 * Qualified Name:     PeriodePecAccre
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */