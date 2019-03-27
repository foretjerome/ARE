package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltreActiviteSalarie
  extends FiltrePeriodesComplementaires
  implements FiltreTemporel
{
  private static final long serialVersionUID = 1L;
  
  public FiltreActiviteSalarie()
  {
    super(true);
  }
  
  public FiltreActiviteSalarie(boolean filtreComplementaire)
  {
    super(filtreComplementaire);
  }
  
  public boolean accepter(Temporel temporel)
  {
    return super.getFiltreValorise(temporel instanceof ActiviteSalarie);
  }
}

/* Location:
 * Qualified Name:     FiltreActiviteSalarie
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */