package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.autresdoms.ga.dom.ContratTravail;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltrePeriodeActiviteSalarieHorsFrance
  extends FiltrePeriodesComplementaires
  implements FiltreTemporel
{
  public FiltrePeriodeActiviteSalarieHorsFrance(boolean p_filtreComplementaire)
  {
    super(p_filtreComplementaire);
  }
  
  public FiltrePeriodeActiviteSalarieHorsFrance() {}
  
  public boolean accepter(Temporel p_temporel)
  {
    if ((p_temporel instanceof ActiviteSalarie)) {
      return super.getFiltreValorise((((ActiviteSalarie)p_temporel).getContrat().getPohf() == 6) || (((ActiviteSalarie)p_temporel).getContrat().getPohf() == 7) || (((ActiviteSalarie)p_temporel).getContrat().getPohf() == 8) || (((ActiviteSalarie)p_temporel).getContrat().getPohf() == 9));
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     FiltrePeriodeActiviteSalarieHorsFrance
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */