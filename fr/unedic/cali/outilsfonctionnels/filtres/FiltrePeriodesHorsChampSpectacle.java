package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeActiviteSalarie;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltrePeriodesHorsChampSpectacle
  extends FiltrePeriodesComplementaires
  implements FiltreTemporel
{
  public FiltrePeriodesHorsChampSpectacle() {}
  
  public FiltrePeriodesHorsChampSpectacle(boolean p_filtreComplementaire)
  {
    super(p_filtreComplementaire);
  }
  
  public boolean accepter(Temporel p_temporel)
  {
    return (p_temporel.estType(ActiviteSalarie.class)) && (((ActiviteSalarie)p_temporel).getPeriodeActiviteSalarieGaec().isHorsChampsSpectacle());
  }
}

/* Location:
 * Qualified Name:     FiltrePeriodesHorsChampSpectacle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */