package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.autresdoms.ga.dom.ContratTravail;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltrePeriodeExpatries
  implements FiltreTemporel
{
  private static final long serialVersionUID = 1L;
  
  public boolean accepter(Temporel p_temporel)
  {
    if ((p_temporel instanceof ActiviteSalarie)) {
      return (((ActiviteSalarie)p_temporel).getContrat().getPohf() == 2) || (((ActiviteSalarie)p_temporel).getContrat().getPohf() == 3) || (((ActiviteSalarie)p_temporel).getContrat().getPohf() == 5) || (((ActiviteSalarie)p_temporel).getContrat().getPohf() == 10);
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     FiltrePeriodeExpatries
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */