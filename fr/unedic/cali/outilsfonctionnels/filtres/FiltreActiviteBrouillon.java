package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeActiviteSalarie;
import fr.unedic.cali.autresdoms.ga.dom.spec.ConstantesContratTravail;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;
import java.math.BigDecimal;

public class FiltreActiviteBrouillon
  extends FiltrePeriodesComplementaires
  implements FiltreTemporel
{
  public FiltreActiviteBrouillon()
  {
    super(true);
  }
  
  public FiltreActiviteBrouillon(boolean p_filtreComplementaire)
  {
    super(p_filtreComplementaire);
  }
  
  public boolean accepter(Temporel p_temporel)
  {
    boolean estASBrouillon = false;
    if (p_temporel.estType(ActiviteSalarie.class))
    {
      ActiviteSalarie as = (ActiviteSalarie)p_temporel;
      if (as.getPeriodeActiviteSalarieGaec().getIncomplete() != null) {
        estASBrouillon = as.getPeriodeActiviteSalarieGaec().getIncomplete().equals(ConstantesContratTravail.BROUILLON);
      }
    }
    return super.getFiltreValorise(estASBrouillon);
  }
}

/* Location:
 * Qualified Name:     FiltreActiviteBrouillon
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */