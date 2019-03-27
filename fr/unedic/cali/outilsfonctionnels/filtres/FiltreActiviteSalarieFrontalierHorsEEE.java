package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.autresdoms.ga.dom.ContratTravail;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltreActiviteSalarieFrontalierHorsEEE
  extends FiltrePeriodesComplementaires
  implements FiltreTemporel
{
  private static final long serialVersionUID = -3698377508303311173L;
  
  public FiltreActiviteSalarieFrontalierHorsEEE() {}
  
  public FiltreActiviteSalarieFrontalierHorsEEE(boolean p_filtreComplementaire)
  {
    super(p_filtreComplementaire);
  }
  
  public boolean accepter(Temporel p_temporel)
  {
    return (p_temporel.estType(ActiviteSalarie.class)) && (((ActiviteSalarie)p_temporel).getContrat().getPohf() == 8);
  }
}

/* Location:
 * Qualified Name:     FiltreActiviteSalarieFrontalierHorsEEE
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */