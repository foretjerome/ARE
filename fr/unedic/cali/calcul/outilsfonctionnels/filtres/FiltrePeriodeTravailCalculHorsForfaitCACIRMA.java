package fr.unedic.cali.calcul.outilsfonctionnels.filtres;

import fr.unedic.cali.calcul.dom.periode.PeriodeForfaitCA;
import fr.unedic.cali.calcul.dom.periode.PeriodeForfaitCIRMA;
import fr.unedic.util.temps.FiltresTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltrePeriodeTravailCalculHorsForfaitCACIRMA
  extends FiltresTemporel
{
  private static final long serialVersionUID = 1L;
  
  public boolean accepter(Temporel p_temporel)
  {
    return (!(p_temporel instanceof PeriodeForfaitCA)) && (!(p_temporel instanceof PeriodeForfaitCIRMA));
  }
}

/* Location:
 * Qualified Name:     FiltrePeriodeTravailCalculHorsForfaitCACIRMA
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */