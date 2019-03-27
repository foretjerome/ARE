package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.PeriodeEvenementPersonnel;
import fr.unedic.cali.autresdoms.ga.dom.spec.DeclareSpec;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltrePeriodeActiviteAutreQuePeriodeDsm
  implements FiltreTemporel
{
  public boolean accepter(Temporel p_temporel)
  {
    return (!(p_temporel instanceof DeclareSpec)) || ((p_temporel instanceof PeriodeEvenementPersonnel));
  }
}

/* Location:
 * Qualified Name:     FiltrePeriodeActiviteAutreQuePeriodeDsm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */