package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltreActiviteSalarieAutreQueFormationCifCdd
  implements FiltreTemporel
{
  public boolean accepter(Temporel p_temporel)
  {
    if (p_temporel.estType(ActiviteSalarie.class)) {
      return ((ActiviteSalarie)p_temporel).getContratTypeParticulier() != 8;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     FiltreActiviteSalarieAutreQueFormationCifCdd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */