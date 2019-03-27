package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.autresdoms.ga.dom.ContratTravail;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltreActiviteSalarieAvecChomageTotalSansRupture
  implements FiltreTemporel
{
  public boolean accepter(Temporel p_temporel)
  {
    if (p_temporel.estType(ActiviteSalarie.class))
    {
      ActiviteSalarie activiteSalarie = (ActiviteSalarie)p_temporel;
      return activiteSalarie.getContrat().getCodeMotifFin() == 99;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     FiltreActiviteSalarieAvecChomageTotalSansRupture
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */