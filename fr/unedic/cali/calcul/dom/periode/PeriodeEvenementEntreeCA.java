package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeCalculTransient;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class PeriodeEvenementEntreeCA
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = -2236869554554103987L;
  
  private PeriodeEvenementEntreeCA() {}
  
  public PeriodeEvenementEntreeCA(Damj p_dateDebut, Damj p_dateFin)
  {
    super(p_dateDebut, p_dateFin);
  }
  
  public ObjetMetierSpec copie()
  {
    PeriodeEvenementEntreeCA copie = new PeriodeEvenementEntreeCA();
    copieElements(copie);
    return copie;
  }
}

/* Location:
 * Qualified Name:     PeriodeEvenementEntreeCA
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */