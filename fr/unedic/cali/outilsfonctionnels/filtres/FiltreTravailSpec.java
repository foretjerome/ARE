package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.spec.TravailSpec;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltreTravailSpec
  implements FiltreTemporel
{
  public boolean accepter(Temporel p_temporel)
  {
    return p_temporel.estType(TravailSpec.class);
  }
}

/* Location:
 * Qualified Name:     FiltreTravailSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */