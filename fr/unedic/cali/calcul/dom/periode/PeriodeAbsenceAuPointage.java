package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class PeriodeAbsenceAuPointage
  extends PeriodeEvenementActualisation
{
  protected PeriodeAbsenceAuPointage() {}
  
  public PeriodeAbsenceAuPointage(Damj p_dateDebut, Damj p_dateFin)
  {
    super(p_dateDebut, p_dateFin);
  }
  
  public ObjetMetierSpec copie()
  {
    PeriodeAbsenceAuPointage copie = new PeriodeAbsenceAuPointage();
    copieElements(copie);
    return copie;
  }
}

/* Location:
 * Qualified Name:     PeriodeAbsenceAuPointage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */