package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.DeclareTravail;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltrePeriodeDsmTravailNonJustifiee
  implements FiltreTemporel
{
  public boolean accepter(Temporel p_temporel)
  {
    return (p_temporel.estType(DeclareTravail.class)) && (!((DeclareTravail)p_temporel).estJustifie());
  }
}

/* Location:
 * Qualified Name:     FiltrePeriodeDsmTravailNonJustifiee
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */