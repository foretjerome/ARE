package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;
import java.util.List;

public class FiltreAttributionToutesCompetencesAdministratives
  implements FiltreTemporel
{
  public boolean accepter(Temporel p_temporel)
  {
    List listDossierExamen = ((DemandeSpec)p_temporel).getListeDossiersExamen();
    try
    {
      if ((listDossierExamen != null) && (!listDossierExamen.isEmpty()) && ((listDossierExamen.get(0) instanceof AttributionSpec))) {
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
 * Qualified Name:     FiltreAttributionToutesCompetencesAdministratives
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */