package fr.unedic.cali.calcul.dom.temps;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class ObjetChronoPeriodeDemandeClassementSP
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = 1L;
  
  private ObjetChronoPeriodeDemandeClassementSP() {}
  
  public ObjetChronoPeriodeDemandeClassementSP(Damj p_date)
  {
    super(p_date, p_date);
  }
  
  public ObjetMetierSpec copie()
  {
    ObjetChronoPeriodeDemandeClassementSP copie = new ObjetChronoPeriodeDemandeClassementSP();
    copieElements(copie);
    return copie;
  }
}

/* Location:
 * Qualified Name:     ObjetChronoPeriodeDemandeClassementSP
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */