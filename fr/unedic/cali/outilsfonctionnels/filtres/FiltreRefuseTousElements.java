package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltreRefuseTousElements
  implements FiltreTemporel
{
  private static final long serialVersionUID = 1L;
  
  public boolean accepter(Temporel p_temporel)
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     FiltreRefuseTousElements
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */