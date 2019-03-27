package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DossierExamenSpec;
import fr.unedic.cali.dom.OdSpec;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;
import java.util.List;

public class FiltreOD
  implements FiltreTemporel
{
  public boolean accepter(Temporel p_temporel)
  {
    try
    {
      if ((!((DemandeSpec)p_temporel).getListeDossiersExamen().isEmpty()) && 
        (((DemandeSpec)p_temporel).getListeDossiersExamen().get(0) != null) && (((DossierExamenSpec)((DemandeSpec)p_temporel).getListeDossiersExamen().get(0) instanceof OdSpec))) {
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
 * Qualified Name:     FiltreOD
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */