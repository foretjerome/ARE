package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.util.temps.Temporel;

public class FiltreActiviteSalarieEtantFCT
  extends FiltreActiviteSalarie
{
  private static final long serialVersionUID = 539517369877380388L;
  
  public boolean accepter(Temporel p_temporel)
  {
    boolean estUneActiviteSalarieEtantFct = false;
    if (super.accepter(p_temporel))
    {
      ActiviteSalarie activite = (ActiviteSalarie)p_temporel;
      estUneActiviteSalarieEtantFct = activite.estUneFct();
    }
    return estUneActiviteSalarieEtantFct;
  }
}

/* Location:
 * Qualified Name:     FiltreActiviteSalarieEtantFCT
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */