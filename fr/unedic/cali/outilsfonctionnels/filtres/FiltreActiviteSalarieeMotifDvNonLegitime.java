package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.autresdoms.ga.dom.ContratTravail;
import fr.unedic.cali.outilsfonctionnels.DetectionTypeChomage;
import fr.unedic.util.temps.Temporel;

public class FiltreActiviteSalarieeMotifDvNonLegitime
  extends FiltrePeriodesComplementaires
{
  public boolean accepter(Temporel p_temporel)
  {
    if (!p_temporel.estType(ActiviteSalarie.class)) {
      return false;
    }
    int codeMotifFin = ((ActiviteSalarie)p_temporel).getCodeMotifFin();
    int contexteDemission = ((ActiviteSalarie)p_temporel).getContrat().getContexteDemission();
    return !DetectionTypeChomage.estChomageLegitime(codeMotifFin, contexteDemission);
  }
}

/* Location:
 * Qualified Name:     FiltreActiviteSalarieeMotifDvNonLegitime
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */