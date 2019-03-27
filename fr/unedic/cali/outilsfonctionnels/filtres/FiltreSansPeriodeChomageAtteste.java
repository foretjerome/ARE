package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.dom.PeriodeChomageAtteste;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltreSansPeriodeChomageAtteste
  implements FiltreTemporel
{
  public boolean accepter(Temporel p_temporel)
  {
    return !(p_temporel instanceof PeriodeChomageAtteste);
  }
}

/* Location:
 * Qualified Name:     FiltreSansPeriodeChomageAtteste
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */