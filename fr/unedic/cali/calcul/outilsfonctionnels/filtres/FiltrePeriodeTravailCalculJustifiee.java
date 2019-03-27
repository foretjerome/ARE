package fr.unedic.cali.calcul.outilsfonctionnels.filtres;

import fr.unedic.cali.calcul.dom.periode.PeriodeTravail;
import fr.unedic.cali.calcul.dom.periode.PeriodeTravailJustifiee;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltrePeriodeTravailCalculJustifiee
  implements FiltreTemporel
{
  public boolean accepter(Temporel p_temporel)
  {
    return ((p_temporel instanceof PeriodeTravail)) && ((p_temporel instanceof PeriodeTravailJustifiee));
  }
}

/* Location:
 * Qualified Name:     FiltrePeriodeTravailCalculJustifiee
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */