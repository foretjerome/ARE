package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.spec.IncidentSpec;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltreIncident
  implements FiltreTemporel
{
  public boolean accepter(Temporel p_temporel)
  {
    return p_temporel instanceof IncidentSpec;
  }
}

/* Location:
 * Qualified Name:     FiltreIncident
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */