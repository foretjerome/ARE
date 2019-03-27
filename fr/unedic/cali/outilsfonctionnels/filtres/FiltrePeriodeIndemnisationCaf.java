package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.PeriodeIndemnisationCaf;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltrePeriodeIndemnisationCaf
  implements FiltreTemporel
{
  private static final long serialVersionUID = 6008903522640336420L;
  
  public boolean accepter(Temporel p_temporel)
  {
    return p_temporel.estType(PeriodeIndemnisationCaf.class);
  }
}

/* Location:
 * Qualified Name:     FiltrePeriodeIndemnisationCaf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */