package fr.unedic.cali.calcul.dom.temps;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class ObjetChronoPeriodeSeuilMoisNi
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = 1748167430687999062L;
  
  public ObjetChronoPeriodeSeuilMoisNi() {}
  
  public ObjetChronoPeriodeSeuilMoisNi(Damj p_dateDebut, Damj p_dateFin)
  {
    super(p_dateDebut, p_dateFin);
  }
  
  public ObjetMetierSpec copie()
  {
    ObjetChronoPeriodeSeuilMoisNi copie = new ObjetChronoPeriodeSeuilMoisNi();
    copieElements(copie);
    return copie;
  }
}

/* Location:
 * Qualified Name:     ObjetChronoPeriodeSeuilMoisNi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */