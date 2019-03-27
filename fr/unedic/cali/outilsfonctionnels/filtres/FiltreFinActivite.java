package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltreFinActivite
  implements FiltreTemporel
{
  public boolean accepter(Temporel p_temporel)
  {
    return p_temporel.getDateFin().estAvant(Damj.FIN_DES_TEMPS);
  }
}

/* Location:
 * Qualified Name:     FiltreFinActivite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */