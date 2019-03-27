package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltreDemandesEnReexamen
  extends FiltrePeriodesComplementaires
  implements FiltreTemporel
{
  public FiltreDemandesEnReexamen(boolean p_filtreComplementaire)
  {
    super(p_filtreComplementaire);
  }
  
  public boolean accepter(Temporel p_temporel)
  {
    if ((p_temporel instanceof DemandeSpec)) {
      return super.getFiltreValorise(((DemandeSpec)p_temporel).estEnReExamen());
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     FiltreDemandesEnReexamen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */