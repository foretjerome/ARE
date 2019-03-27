package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltreDemandeValideNonEnReexamen
  implements FiltreTemporel
{
  public boolean accepter(Temporel p_temporel)
  {
    if ((p_temporel instanceof DemandeSpec)) {
      return (((DemandeSpec)p_temporel).estValide()) && (!((DemandeSpec)p_temporel).estEnReExamen());
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     FiltreDemandeValideNonEnReexamen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */