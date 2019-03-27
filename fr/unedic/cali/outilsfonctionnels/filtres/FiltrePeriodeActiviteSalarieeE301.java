package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;
import java.util.Collection;

public class FiltrePeriodeActiviteSalarieeE301
  extends FiltrePeriodesComplementaires
  implements FiltreTemporel
{
  private static final long serialVersionUID = -8787213613175655545L;
  
  public FiltrePeriodeActiviteSalarieeE301() {}
  
  public FiltrePeriodeActiviteSalarieeE301(boolean p_filtreComplementaire)
  {
    super(p_filtreComplementaire);
  }
  
  public boolean accepter(Temporel p_temporel)
  {
    return super.getFiltreValorise((p_temporel.estType(ActiviteSalarie.class)) && (((ActiviteSalarie)p_temporel).getCollectionOrigineInformationPAS().contains(Integer.valueOf(10))));
  }
}

/* Location:
 * Qualified Name:     FiltrePeriodeActiviteSalarieeE301
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */