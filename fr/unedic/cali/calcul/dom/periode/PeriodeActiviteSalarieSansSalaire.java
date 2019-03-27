package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeCalculTransient;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class PeriodeActiviteSalarieSansSalaire
  extends ObjetChronoPeriodeCalculTransient
{
  protected PeriodeActiviteSalarieSansSalaire() {}
  
  public PeriodeActiviteSalarieSansSalaire(Damj p_dateDebut, Damj p_dateFin)
  {
    super(p_dateDebut, p_dateFin);
  }
  
  public ObjetMetierSpec copie()
  {
    PeriodeActiviteSalarieSansSalaire copie = new PeriodeActiviteSalarieSansSalaire();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    PeriodeActiviteSalarieSansSalaire copie = (PeriodeActiviteSalarieSansSalaire)p_copie;
    super.copieElements(copie);
  }
}

/* Location:
 * Qualified Name:     PeriodeActiviteSalarieSansSalaire
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */