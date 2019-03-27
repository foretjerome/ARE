package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeCalculTransient;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class PeriodeChevauchementSanction
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = 370005783521139850L;
  
  protected PeriodeChevauchementSanction() {}
  
  public PeriodeChevauchementSanction(Damj p_debut)
  {
    super(p_debut, p_debut);
  }
  
  public ObjetMetierSpec copie()
  {
    PeriodeChevauchementSanction copie = new PeriodeChevauchementSanction();
    copieElements(copie);
    return copie;
  }
}

/* Location:
 * Qualified Name:     PeriodeChevauchementSanction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */