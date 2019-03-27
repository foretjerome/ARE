package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.calcul.dom.periode.PeriodePensionInvalidite;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltrePeriodePensionInvalidite
  implements FiltreTemporel
{
  private static final long serialVersionUID = -5892651966981691052L;
  
  public boolean accepter(Temporel p_temporel)
  {
    return p_temporel.estType(PeriodePensionInvalidite.class);
  }
}

/* Location:
 * Qualified Name:     FiltrePeriodePensionInvalidite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */