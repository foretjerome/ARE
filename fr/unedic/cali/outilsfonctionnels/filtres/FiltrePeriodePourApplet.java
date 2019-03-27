package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.PeriodeActiviteNonSalariePeriodique;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeEvenementPersonnel;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeFormation;
import fr.unedic.util.temps.Temporel;

public class FiltrePeriodePourApplet
  extends FiltrePeriodesQualifiables
{
  public boolean accepter(Temporel p_temporel)
  {
    return (super.accepter(p_temporel)) || (p_temporel.estType(PeriodeEvenementPersonnel.class)) || (p_temporel.estType(PeriodeFormation.class)) || (p_temporel.estType(PeriodeActiviteNonSalariePeriodique.class));
  }
}

/* Location:
 * Qualified Name:     FiltrePeriodePourApplet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */