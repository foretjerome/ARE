package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class PeriodeAbsenceActualisationMaintienEuropeen
  extends PeriodeEvenementActualisation
{
  private static final long serialVersionUID = 1L;
  
  protected PeriodeAbsenceActualisationMaintienEuropeen() {}
  
  public PeriodeAbsenceActualisationMaintienEuropeen(Damj p_dateDebut, Damj p_dateFin)
  {
    super(p_dateDebut, p_dateFin);
  }
  
  public ObjetMetierSpec copie()
  {
    PeriodeAbsenceActualisationMaintienEuropeen copie = new PeriodeAbsenceActualisationMaintienEuropeen();
    copieElements(copie);
    return copie;
  }
}

/* Location:
 * Qualified Name:     PeriodeAbsenceActualisationMaintienEuropeen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */