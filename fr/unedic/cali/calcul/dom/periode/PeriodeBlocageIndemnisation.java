package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeCalculTransient;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class PeriodeBlocageIndemnisation
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = 5369846143528537072L;
  
  protected PeriodeBlocageIndemnisation() {}
  
  public PeriodeBlocageIndemnisation(Damj p_dateDebut)
  {
    super(p_dateDebut, Damj.FIN_DES_TEMPS);
  }
  
  public ObjetMetierSpec copie()
  {
    PeriodeBlocageIndemnisation copie = new PeriodeBlocageIndemnisation();
    copieElements(copie);
    return copie;
  }
}

/* Location:
 * Qualified Name:     PeriodeBlocageIndemnisation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */