package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.autresdoms.ga.dom.ContratTravail;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltrePeriodeActiviteSalarieeE301NonFrontalier
  extends FiltrePeriodesComplementaires
  implements FiltreTemporel
{
  private static final long serialVersionUID = 1709896481708955904L;
  
  public FiltrePeriodeActiviteSalarieeE301NonFrontalier() {}
  
  public FiltrePeriodeActiviteSalarieeE301NonFrontalier(boolean p_filtreComplementaire)
  {
    super(p_filtreComplementaire);
  }
  
  public boolean accepter(Temporel p_temporel)
  {
    return super.getFiltreValorise((p_temporel.estType(ActiviteSalarie.class)) && (((ActiviteSalarie)p_temporel).getContrat().getPohf() == 9));
  }
}

/* Location:
 * Qualified Name:     FiltrePeriodeActiviteSalarieeE301NonFrontalier
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */