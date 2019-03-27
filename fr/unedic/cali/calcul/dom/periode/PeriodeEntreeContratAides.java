package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeCalculTransient;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class PeriodeEntreeContratAides
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = 7873078443974951238L;
  
  private PeriodeEntreeContratAides() {}
  
  public PeriodeEntreeContratAides(Damj p_dateDebut, Damj p_dateFin)
  {
    super(p_dateDebut, p_dateFin);
  }
  
  public ObjetMetierSpec copie()
  {
    PeriodeEntreeContratAides copie = new PeriodeEntreeContratAides();
    copieElements(copie);
    return copie;
  }
}

/* Location:
 * Qualified Name:     PeriodeEntreeContratAides
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */