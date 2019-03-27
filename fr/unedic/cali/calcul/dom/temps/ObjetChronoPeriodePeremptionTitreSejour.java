package fr.unedic.cali.calcul.dom.temps;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class ObjetChronoPeriodePeremptionTitreSejour
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = -5815377285661340826L;
  
  private ObjetChronoPeriodePeremptionTitreSejour() {}
  
  public ObjetChronoPeriodePeremptionTitreSejour(Damj p_date)
  {
    super(p_date, p_date);
  }
  
  public ObjetMetierSpec copie()
  {
    ObjetChronoPeriodePeremptionTitreSejour copie = new ObjetChronoPeriodePeremptionTitreSejour();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    ObjetChronoPeriodePeremptionTitreSejour copie = (ObjetChronoPeriodePeremptionTitreSejour)p_copie;
    super.copieElements(copie);
  }
}

/* Location:
 * Qualified Name:     ObjetChronoPeriodePeremptionTitreSejour
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */