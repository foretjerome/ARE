package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeCalculTransient;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class PeriodeConflitGAEC
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = 1028800747257578088L;
  
  private PeriodeConflitGAEC() {}
  
  public PeriodeConflitGAEC(Damj p_dateDebut, Damj p_dateFin)
  {
    super(p_dateDebut, p_dateFin);
  }
  
  public ObjetMetierSpec copie()
  {
    PeriodeConflitGAEC copie = new PeriodeConflitGAEC();
    copieElements(copie);
    return copie;
  }
}

/* Location:
 * Qualified Name:     PeriodeConflitGAEC
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */