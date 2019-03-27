package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.calcul.dom.temps.ObjetChronoRemplissage;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltreObjetChronoPeriodeCalculRemplissage
  implements FiltreTemporel
{
  private static final long serialVersionUID = -6902017670408263447L;
  
  public boolean accepter(Temporel p_temporel)
  {
    if ((p_temporel instanceof ObjetChronoRemplissage)) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     FiltreObjetChronoPeriodeCalculRemplissage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */