package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DossierExamenSpec;
import fr.unedic.cali.dom.RepriseSpec;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;
import java.util.List;

public class FiltreReprise
  implements FiltreTemporel
{
  public boolean accepter(Temporel p_temporel)
  {
    try
    {
      if ((!((DemandeSpec)p_temporel).getListeDossiersExamen().isEmpty()) && 
        (((DemandeSpec)p_temporel).getListeDossiersExamen().get(0) != null) && (((DossierExamenSpec)((DemandeSpec)p_temporel).getListeDossiersExamen().get(0) instanceof RepriseSpec))) {
        return true;
      }
    }
    catch (ClassCastException e)
    {
      return false;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     FiltreReprise
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */