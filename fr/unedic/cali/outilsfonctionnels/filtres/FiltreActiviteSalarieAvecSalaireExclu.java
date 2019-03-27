package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltreActiviteSalarieAvecSalaireExclu
  implements FiltreTemporel
{
  private static final long serialVersionUID = -462793164167281184L;
  
  public boolean accepter(Temporel p_temporel)
  {
    if (p_temporel.estType(ActiviteSalarie.class))
    {
      Chronologie chronoSalaires = ((ActiviteSalarie)p_temporel).getListeSalaires();
      if (chronoSalaires != null)
      {
        Chronologie chronoSalairesExclus = chronoSalaires.copier(new FiltrePeriodeSalaireExclu());
        return (chronoSalairesExclus != null) && (!chronoSalairesExclus.estVide());
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     FiltreActiviteSalarieAvecSalaireExclu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */