package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.PeriodeEvenementPersonnelIndemnisable;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltrePeriodeIndemnisationIjss
  implements FiltreTemporel
{
  public boolean accepter(Temporel p_temporel)
  {
    boolean accepter = false;
    if (p_temporel.estType(PeriodeEvenementPersonnelIndemnisable.class))
    {
      PeriodeEvenementPersonnelIndemnisable periode = (PeriodeEvenementPersonnelIndemnisable)p_temporel;
      accepter = (periode.getTypePep() == 2) || (periode.getTypePep() == 3);
    }
    return accepter;
  }
}

/* Location:
 * Qualified Name:     FiltrePeriodeIndemnisationIjss
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */