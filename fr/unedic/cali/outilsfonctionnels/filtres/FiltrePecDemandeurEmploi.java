package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.cohab.dom.ObjetChronoPeriodePriseEnCharge;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltrePecDemandeurEmploi
  extends FiltrePeriodesComplementaires
  implements FiltreTemporel
{
  public FiltrePecDemandeurEmploi() {}
  
  public FiltrePecDemandeurEmploi(boolean p_filtreComplementaire)
  {
    super(p_filtreComplementaire);
  }
  
  public boolean accepter(Temporel p_temporel)
  {
    return super.getFiltreValorise(((ObjetChronoPeriodePriseEnCharge)p_temporel).getDemandeurEmploi());
  }
}

/* Location:
 * Qualified Name:     FiltrePecDemandeurEmploi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */