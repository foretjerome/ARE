package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.dom.PeriodeChomageAtteste;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltrePeriodeChomageAtteste
  implements FiltreTemporel
{
  public boolean accepter(Temporel p_temporel)
  {
    return p_temporel.estType(PeriodeChomageAtteste.class);
  }
}

/* Location:
 * Qualified Name:     FiltrePeriodeChomageAtteste
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */