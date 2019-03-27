package fr.unedic.cali.autresdoms.ga.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.spec.IncidentSpec;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltreSuspensionChomageSansRupture
  implements FiltreTemporel
{
  public boolean accepter(Temporel p_temporel)
  {
    if (p_temporel.estType(IncidentSpec.class))
    {
      IncidentSpec incident = (IncidentSpec)p_temporel;
      if (incident.getNature() == 14) {
        return true;
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     FiltreSuspensionChomageSansRupture
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */