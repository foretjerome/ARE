package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.util.temps.Temporel;

public class FiltrePeriodesSansConflit
  extends FiltrePeriodesAvecConflit
{
  public boolean accepter(Temporel p_temporel)
  {
    return !super.accepter(p_temporel);
  }
}

/* Location:
 * Qualified Name:     FiltrePeriodesSansConflit
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */