package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.spec.SalarieSpec;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltreTravailSalarie
  implements FiltreTemporel
{
  public boolean accepter(Temporel p_temporel)
  {
    return p_temporel.estType(SalarieSpec.class);
  }
}

/* Location:
 * Qualified Name:     FiltreTravailSalarie
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */