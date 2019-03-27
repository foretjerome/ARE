package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.PeriodeEvenementPersonnelIndemnisable;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltreMaladieGrave
  implements FiltreTemporel
{
  private static final long serialVersionUID = 1L;
  
  public boolean accepter(Temporel p_temporel)
  {
    if (p_temporel.estType(PeriodeEvenementPersonnelIndemnisable.class))
    {
      PeriodeEvenementPersonnelIndemnisable periode = (PeriodeEvenementPersonnelIndemnisable)p_temporel;
      return periode.isMaladieGrave();
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     FiltreMaladieGrave
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */