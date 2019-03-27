package fr.unedic.cali.calcul.outilsfonctionnels.filtres;

import fr.unedic.cali.calcul.dom.periode.PeriodeActiviteEmploiCalcul;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltrePeriodeTravailCalculPAEC
  implements FiltreTemporel
{
  private static final long serialVersionUID = 1L;
  
  public boolean accepter(Temporel temporel)
  {
    return temporel instanceof PeriodeActiviteEmploiCalcul;
  }
}

/* Location:
 * Qualified Name:     FiltrePeriodeTravailCalculPAEC
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */