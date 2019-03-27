package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeCalculTransient;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class PeriodeFormationNonIndemniseeAbsenceHeure
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = -5502761697058993184L;
  
  private PeriodeFormationNonIndemniseeAbsenceHeure() {}
  
  public PeriodeFormationNonIndemniseeAbsenceHeure(Damj p_dateDebut, Damj p_dateFin)
  {
    super(p_dateDebut, p_dateFin);
  }
  
  public ObjetMetierSpec copie()
  {
    PeriodeFormationNonIndemniseeAbsenceHeure copie = new PeriodeFormationNonIndemniseeAbsenceHeure();
    copieElements(copie);
    return copie;
  }
}

/* Location:
 * Qualified Name:     PeriodeFormationNonIndemniseeAbsenceHeure
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */