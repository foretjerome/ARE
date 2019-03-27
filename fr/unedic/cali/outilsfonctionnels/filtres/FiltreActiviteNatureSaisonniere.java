package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.autresdoms.ga.outilsfonctionnels.DeterminationSecteurActivite;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltreActiviteNatureSaisonniere
  implements FiltreTemporel
{
  public boolean accepter(Temporel p_temporel)
  {
    boolean periodeRetenue = false;
    if (p_temporel.estType(ActiviteSalarie.class))
    {
      ActiviteSalarie periodeCourante = (ActiviteSalarie)p_temporel;
      return DeterminationSecteurActivite.estSaisonnier(periodeCourante);
    }
    return periodeRetenue;
  }
}

/* Location:
 * Qualified Name:     FiltreActiviteNatureSaisonniere
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */