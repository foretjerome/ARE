package fr.unedic.cali.calcul.outilsfonctionnels.filtres;

import fr.unedic.cali.calcul.dom.periode.PeriodeInterStageFormation;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltrePeriodeInterstage
  implements FiltreTemporel
{
  private static final long serialVersionUID = 1L;
  
  public boolean accepter(Temporel p_temporel)
  {
    return p_temporel.estType(PeriodeInterStageFormation.class);
  }
}

/* Location:
 * Qualified Name:     FiltrePeriodeInterstage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */