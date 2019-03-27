package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltrePeriodeActiviteSalarieeHorsChamp
  extends FiltrePeriodesComplementaires
  implements FiltreTemporel
{
  public FiltrePeriodeActiviteSalarieeHorsChamp() {}
  
  public FiltrePeriodeActiviteSalarieeHorsChamp(boolean p_filtreComplementaire)
  {
    super(p_filtreComplementaire);
  }
  
  public boolean accepter(Temporel p_temporel)
  {
    if (p_temporel.estType(ActiviteSalarie.class)) {}
    return super.getFiltreValorise(((ActiviteSalarie)p_temporel).getChampApplication() == 2);
  }
}

/* Location:
 * Qualified Name:     FiltrePeriodeActiviteSalarieeHorsChamp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */