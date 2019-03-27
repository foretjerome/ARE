package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeCalculTransient;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public abstract class PeriodeEvenementActualisation
  extends ObjetChronoPeriodeCalculTransient
{
  protected PeriodeEvenementActualisation() {}
  
  public PeriodeEvenementActualisation(Damj p_dateDebut, Damj p_dateFin)
  {
    super(p_dateDebut, p_dateFin);
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    PeriodeEvenementActualisation copie = (PeriodeEvenementActualisation)p_copie;
    super.copieElements(copie);
  }
}

/* Location:
 * Qualified Name:     PeriodeEvenementActualisation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */