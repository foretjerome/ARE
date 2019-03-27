package fr.unedic.cali.utilitaire.filtres.objetChronoPeriode;

import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.util.temps.Temporel;

public class FiltreActiviteSalarieFct
  extends FiltreActiviteSalarieAbstrait
{
  private static final long serialVersionUID = 1L;
  
  public FiltreActiviteSalarieFct()
  {
    super("");
  }
  
  public boolean accepterElement(Temporel p_temporel)
  {
    return ((ActiviteSalarie)p_temporel).estUneFct();
  }
}

/* Location:
 * Qualified Name:     FiltreActiviteSalarieFct
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */