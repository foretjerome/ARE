package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.Prime;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltrePrimesICRS
  implements FiltreTemporel
{
  public boolean accepter(Temporel p_temporel)
  {
    if ((p_temporel instanceof Prime)) {
      return ((Prime)p_temporel).getTypePrime() == 5;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     FiltrePrimesICRS
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */