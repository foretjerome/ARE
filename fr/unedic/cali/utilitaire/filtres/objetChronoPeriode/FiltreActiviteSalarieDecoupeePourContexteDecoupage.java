package fr.unedic.cali.utilitaire.filtres.objetChronoPeriode;

import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.autresdoms.ga.dom.ContratTravail;
import fr.unedic.util.temps.Temporel;

public class FiltreActiviteSalarieDecoupeePourContexteDecoupage
  extends FiltreActiviteSalarieAbstrait
{
  private static final long serialVersionUID = 1L;
  private String m_contexteDecoupage;
  
  public FiltreActiviteSalarieDecoupeePourContexteDecoupage(String p_contexteDecoupage)
  {
    super(p_contexteDecoupage);
    m_contexteDecoupage = p_contexteDecoupage;
  }
  
  public boolean accepterElement(Temporel p_temporel)
  {
    return ((ActiviteSalarie)p_temporel).getContrat().estEnContexteDecoupage(m_contexteDecoupage);
  }
}

/* Location:
 * Qualified Name:     FiltreActiviteSalarieDecoupeePourContexteDecoupage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */