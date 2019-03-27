package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.PeriodeActiviteNonSalariePeriodique;
import fr.unedic.util.temps.Temporel;

public class FiltrePeriodeActiviteNonSalarieePeriodiqueAccordDDTE
  extends FiltrePeriodeActiviteNonSalarieePeriodique
{
  public boolean accepter(Temporel p_temporel)
  {
    return (super.accepter(p_temporel)) && (((PeriodeActiviteNonSalariePeriodique)p_temporel).getStatusDDTE() == 2);
  }
}

/* Location:
 * Qualified Name:     FiltrePeriodeActiviteNonSalarieePeriodiqueAccordDDTE
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */