package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltrePeriodeActiviteSalarieeSecteurPublicFonctionnaire
  implements FiltreTemporel
{
  private static final Damj DEB_CHAMP_APPLICATION_FONCTIONNAIRE = new Damj(2007, 1, 31);
  
  public boolean accepter(Temporel p_temporel)
  {
    return (p_temporel.estType(ActiviteSalarie.class)) && (((ActiviteSalarie)p_temporel).getChampApplication() == 8) && (((ActiviteSalarie)p_temporel).getDateFin().estApres(DEB_CHAMP_APPLICATION_FONCTIONNAIRE));
  }
}

/* Location:
 * Qualified Name:     FiltrePeriodeActiviteSalarieeSecteurPublicFonctionnaire
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */