package fr.unedic.cali.calcul.outilsfonctionnels.filtres;

import fr.unedic.cali.calcul.dom.periode.DsmTravail;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltrePeriodeTravailCalculOrigineDsm
  implements FiltreTemporel
{
  public boolean accepter(Temporel p_temporel)
  {
    return (p_temporel.estType(DsmTravail.class)) && (((DsmTravail)p_temporel).getOrigineInfo().equals(Integer.toString(61))) && (((DsmTravail)p_temporel).getOrigineInfo().equals(Integer.toString(62)));
  }
}

/* Location:
 * Qualified Name:     FiltrePeriodeTravailCalculOrigineDsm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */