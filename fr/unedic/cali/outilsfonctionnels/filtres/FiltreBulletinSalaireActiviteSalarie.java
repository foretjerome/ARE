package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.autresdoms.ga.dom.BulletinSalaire;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltreBulletinSalaireActiviteSalarie
  extends FiltrePeriodesComplementaires
  implements FiltreTemporel
{
  public boolean accepter(Temporel p_temporel)
  {
    return (p_temporel.estType(BulletinSalaire.class)) || (super.getFiltreValorise(p_temporel.estType(ActiviteSalarie.class)));
  }
}

/* Location:
 * Qualified Name:     FiltreBulletinSalaireActiviteSalarie
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */