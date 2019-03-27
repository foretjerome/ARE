package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.PeriodeIndemnisationCaf;
import fr.unedic.util.temps.Temporel;

public class FiltrePeriodeIndemnisationCafTauxPlein
  extends FiltrePeriodeIndemnisationCaf
{
  public boolean accepter(Temporel p_temporel)
  {
    return (super.accepter(p_temporel)) && (((PeriodeIndemnisationCaf)p_temporel).estTempsPlein());
  }
}

/* Location:
 * Qualified Name:     FiltrePeriodeIndemnisationCafTauxPlein
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */