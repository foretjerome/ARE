package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.Prime;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltrePrimesNormales
  implements FiltreTemporel
{
  public boolean accepter(Temporel p_temporel)
  {
    if ((p_temporel instanceof Prime)) {
      return ((Prime)p_temporel).getTypePrime() == 1;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     FiltrePrimesNormales
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */