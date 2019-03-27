package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.PeriodeActiviteNonSalariePeriodique;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltrePeriodeActiviteNonSalarieePeriodique
  implements FiltreTemporel
{
  public boolean accepter(Temporel p_temporel)
  {
    return p_temporel.estType(PeriodeActiviteNonSalariePeriodique.class);
  }
}

/* Location:
 * Qualified Name:     FiltrePeriodeActiviteNonSalarieePeriodique
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */