package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.spec.SalarieSpec;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltrePeriodeTravailSalarie
  extends FiltrePeriodesComplementaires
  implements FiltreTemporel
{
  public FiltrePeriodeTravailSalarie()
  {
    super(true);
  }
  
  public FiltrePeriodeTravailSalarie(boolean p_filtreComplementaire)
  {
    super(p_filtreComplementaire);
  }
  
  public boolean accepter(Temporel p_temporel)
  {
    return super.getFiltreValorise(p_temporel.estType(SalarieSpec.class));
  }
}

/* Location:
 * Qualified Name:     FiltrePeriodeTravailSalarie
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */