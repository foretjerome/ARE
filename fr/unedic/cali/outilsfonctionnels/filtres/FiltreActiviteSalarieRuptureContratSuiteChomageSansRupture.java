package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.autresdoms.ga.dom.ContratTravail;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltreActiviteSalarieRuptureContratSuiteChomageSansRupture
  implements FiltreTemporel
{
  private static final long serialVersionUID = 1L;
  
  public boolean accepter(Temporel p_temporel)
  {
    if (p_temporel.estType(ActiviteSalarie.class))
    {
      ActiviteSalarie activiteSalarie = (ActiviteSalarie)p_temporel;
      return (activiteSalarie.getContrat().estDernierContratCaliCreePourDecoupage()) && (activiteSalarie.getContrat().estEnContexteDecoupage("CSR")) && (activiteSalarie.getDateFin() != null) && (!activiteSalarie.getDateFin().equals(Damj.FIN_DES_TEMPS));
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     FiltreActiviteSalarieRuptureContratSuiteChomageSansRupture
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */