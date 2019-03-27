package fr.unedic.cali.calcul.outilsfonctionnels.filtres;

import fr.unedic.cali.calcul.dom.periode.PeriodePrime;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltrePeriodePrimeCalcul
  implements FiltreTemporel
{
  public boolean accepter(Temporel p_temporel)
  {
    return p_temporel instanceof PeriodePrime;
  }
}

/* Location:
 * Qualified Name:     FiltrePeriodePrimeCalcul
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */