package fr.unedic.cali.calcul.dom.temps;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class ObjetChronoPeriodeNonPEC
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = -2371670552108633117L;
  
  private ObjetChronoPeriodeNonPEC() {}
  
  public ObjetChronoPeriodeNonPEC(Damj p_debut, Damj p_fin)
  {
    super(p_debut, p_fin);
  }
  
  public ObjetMetierSpec copie()
  {
    ObjetChronoPeriodeNonPEC copie = new ObjetChronoPeriodeNonPEC();
    copieElements(copie);
    return copie;
  }
}

/* Location:
 * Qualified Name:     ObjetChronoPeriodeNonPEC
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */