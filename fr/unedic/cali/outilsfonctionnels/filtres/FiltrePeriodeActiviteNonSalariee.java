package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.TravailNonSalarie;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltrePeriodeActiviteNonSalariee
  extends FiltrePeriodesComplementaires
  implements FiltreTemporel
{
  public FiltrePeriodeActiviteNonSalariee() {}
  
  public FiltrePeriodeActiviteNonSalariee(boolean p_filtreComplementaire)
  {
    super(p_filtreComplementaire);
  }
  
  public boolean accepter(Temporel p_temporel)
  {
    return super.getFiltreValorise(p_temporel.estType(TravailNonSalarie.class));
  }
}

/* Location:
 * Qualified Name:     FiltrePeriodeActiviteNonSalariee
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */