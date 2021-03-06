package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.cohab.dom.ObjetChronoPeriodePriseEnCharge;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltrePeriodesPecAnnulees
  extends FiltrePeriodesComplementaires
  implements FiltreTemporel
{
  public FiltrePeriodesPecAnnulees() {}
  
  public FiltrePeriodesPecAnnulees(boolean p_filtreComplementaire)
  {
    super(p_filtreComplementaire);
  }
  
  public boolean accepter(Temporel p_temporel)
  {
    return super.getFiltreValorise(((ObjetChronoPeriodePriseEnCharge)p_temporel).isAnnulee());
  }
}

/* Location:
 * Qualified Name:     FiltrePeriodesPecAnnulees
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */