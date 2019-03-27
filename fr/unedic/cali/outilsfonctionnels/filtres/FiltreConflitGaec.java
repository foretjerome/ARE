package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.calcul.dom.periode.PeriodeConflitGAEC;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltreConflitGaec
  implements FiltreTemporel
{
  private static final long serialVersionUID = 1L;
  
  public boolean accepter(Temporel p_temporel)
  {
    return p_temporel.estType(PeriodeConflitGAEC.class);
  }
}

/* Location:
 * Qualified Name:     FiltreConflitGaec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */