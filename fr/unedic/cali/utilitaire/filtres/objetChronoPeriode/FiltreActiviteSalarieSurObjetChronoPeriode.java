package fr.unedic.cali.utilitaire.filtres.objetChronoPeriode;

import fr.unedic.util.temps.Temporel;

public class FiltreActiviteSalarieSurObjetChronoPeriode
  extends FiltreActiviteSalarieAbstrait
{
  private static final long serialVersionUID = 1L;
  
  public FiltreActiviteSalarieSurObjetChronoPeriode()
  {
    super("");
  }
  
  public boolean accepterElement(Temporel p_temporel)
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     FiltreActiviteSalarieSurObjetChronoPeriode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */