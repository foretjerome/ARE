package fr.unedic.cali.utilitaire.filtres.objetChronoPeriode;

import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.util.temps.Temporel;

public class FiltreActiviteSalariePourChampApplication
  extends FiltreActiviteSalarieAbstrait
{
  private static final long serialVersionUID = 1L;
  private int m_champApplication;
  
  public FiltreActiviteSalariePourChampApplication(int p_champApplication)
  {
    super("");
    m_champApplication = p_champApplication;
  }
  
  public boolean accepterElement(Temporel p_temporel)
  {
    return ((ActiviteSalarie)p_temporel).getChampApplication() == m_champApplication;
  }
}

/* Location:
 * Qualified Name:     FiltreActiviteSalariePourChampApplication
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */