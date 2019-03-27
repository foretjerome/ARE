package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.PeriodeActiviteNonSalariePeriodique;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltrePeriodeActiviteSalarieeRejetMandataire
  extends FiltrePeriodesComplementaires
  implements FiltreTemporel
{
  private static final long serialVersionUID = 8534681811339482521L;
  
  public FiltrePeriodeActiviteSalarieeRejetMandataire() {}
  
  public FiltrePeriodeActiviteSalarieeRejetMandataire(boolean filtreComplementaire)
  {
    super(filtreComplementaire);
  }
  
  public boolean accepter(Temporel temporel)
  {
    return (temporel.estType(PeriodeActiviteNonSalariePeriodique.class)) && (super.getFiltreValorise("4".equals(((PeriodeActiviteNonSalariePeriodique)temporel).getEtudeMandataire())));
  }
}

/* Location:
 * Qualified Name:     FiltrePeriodeActiviteSalarieeRejetMandataire
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */