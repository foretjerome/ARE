package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.PeriodeEvenementPersonnel;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltrePeriodeServiceNational
  implements FiltreTemporel
{
  private static final long serialVersionUID = -3298100148902315374L;
  
  public boolean accepter(Temporel p_temporel)
  {
    return (p_temporel.estType(PeriodeEvenementPersonnel.class)) && (((PeriodeEvenementPersonnel)p_temporel).getTypePep() == 0) && (((PeriodeEvenementPersonnel)p_temporel).getNature() == 36);
  }
}

/* Location:
 * Qualified Name:     FiltrePeriodeServiceNational
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */