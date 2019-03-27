package fr.unedic.cali.calcul.outilsfonctionnels.filtres;

import fr.unedic.cali.calcul.dom.periode.PeriodeEvenementPersonnel;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltrePeriodeEvenementPersonnel
  implements FiltreTemporel
{
  public boolean accepter(Temporel p_temporel)
  {
    return p_temporel.estType(PeriodeEvenementPersonnel.class);
  }
}

/* Location:
 * Qualified Name:     FiltrePeriodeEvenementPersonnel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */