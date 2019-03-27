package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.autresdoms.ga.dom.spec.IncidentSpec;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltreActiviteSalarieAvecIncident
  implements FiltreTemporel
{
  private static final long serialVersionUID = -4567909118088159040L;
  private IncidentSpec incident;
  
  public FiltreActiviteSalarieAvecIncident(IncidentSpec incident)
  {
    this.incident = incident;
  }
  
  public boolean accepter(Temporel temporel)
  {
    if (temporel.estType(ActiviteSalarie.class))
    {
      ActiviteSalarie activite = (ActiviteSalarie)temporel;
      Chronologie chronoIncidents = activite.getListePeriodesIncident();
      return (chronoIncidents != null) && (chronoIncidents.contientElement(incident));
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     FiltreActiviteSalarieAvecIncident
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */