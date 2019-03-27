package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltrePASOrigineContratTravail
  implements FiltreTemporel
{
  public boolean accepter(Temporel p_temporel)
  {
    if (!p_temporel.estType(ActiviteSalarie.class)) {
      return false;
    }
    ActiviteSalarie pas = (ActiviteSalarie)p_temporel;
    return pas.getOrigineInformation() == 1;
  }
}

/* Location:
 * Qualified Name:     FiltrePASOrigineContratTravail
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */