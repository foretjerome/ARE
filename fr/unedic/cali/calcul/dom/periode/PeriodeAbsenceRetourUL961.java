package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class PeriodeAbsenceRetourUL961
  extends PeriodeEvenementActualisation
{
  protected PeriodeAbsenceRetourUL961() {}
  
  public PeriodeAbsenceRetourUL961(Damj p_dateDebut, Damj p_dateFin)
  {
    super(p_dateDebut, p_dateFin);
  }
  
  public ObjetMetierSpec copie()
  {
    PeriodeAbsenceRetourUL961 copie = new PeriodeAbsenceRetourUL961();
    copieElements(copie);
    return copie;
  }
}

/* Location:
 * Qualified Name:     PeriodeAbsenceRetourUL961
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */