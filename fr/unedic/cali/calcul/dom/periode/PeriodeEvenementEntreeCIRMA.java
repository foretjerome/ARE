package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeCalculTransient;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class PeriodeEvenementEntreeCIRMA
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = 8176922897755583305L;
  
  private PeriodeEvenementEntreeCIRMA() {}
  
  public PeriodeEvenementEntreeCIRMA(Damj p_dateDebut, Damj p_dateFin)
  {
    super(p_dateDebut, p_dateFin);
  }
  
  public ObjetMetierSpec copie()
  {
    PeriodeEvenementEntreeCIRMA copie = new PeriodeEvenementEntreeCIRMA();
    copieElements(copie);
    return copie;
  }
}

/* Location:
 * Qualified Name:     PeriodeEvenementEntreeCIRMA
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */