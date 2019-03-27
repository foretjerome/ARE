package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.calcul.dom.periode.DsmTravail;
import fr.unedic.cali.calcul.dom.periode.PeriodePrime;
import fr.unedic.cali.calcul.dom.periode.PeriodeTravailJustifiee;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltreTravail
  implements FiltreTemporel
{
  private static final long serialVersionUID = 1L;
  
  public boolean accepter(Temporel p_temporel)
  {
    return (p_temporel.estType(PeriodeTravailJustifiee.class)) || (p_temporel.estType(DsmTravail.class)) || (p_temporel.estType(PeriodePrime.class));
  }
}

/* Location:
 * Qualified Name:     FiltreTravail
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */