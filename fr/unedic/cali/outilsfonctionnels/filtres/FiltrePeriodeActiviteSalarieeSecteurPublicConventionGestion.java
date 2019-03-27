package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltrePeriodeActiviteSalarieeSecteurPublicConventionGestion
  implements FiltreTemporel
{
  public boolean accepter(Temporel p_temporel)
  {
    return (p_temporel.estType(ActiviteSalarie.class)) && (((ActiviteSalarie)p_temporel).getChampApplication() == 4);
  }
}

/* Location:
 * Qualified Name:     FiltrePeriodeActiviteSalarieeSecteurPublicConventionGestion
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */