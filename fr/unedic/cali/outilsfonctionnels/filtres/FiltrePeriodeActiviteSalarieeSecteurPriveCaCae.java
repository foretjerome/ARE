package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltrePeriodeActiviteSalarieeSecteurPriveCaCae
  implements FiltreTemporel
{
  public boolean accepter(Temporel p_temporel)
  {
    return (p_temporel.estType(ActiviteSalarie.class)) && (((ActiviteSalarie)p_temporel).getChampApplication() == 9);
  }
}

/* Location:
 * Qualified Name:     FiltrePeriodeActiviteSalarieeSecteurPriveCaCae
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */