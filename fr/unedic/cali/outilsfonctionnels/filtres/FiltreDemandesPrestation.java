package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltreDemandesPrestation
  implements FiltreTemporel
{
  private static final long serialVersionUID = -1460811202395533650L;
  
  public boolean accepter(Temporel p_temporel)
  {
    return ((DemandeSpec)p_temporel).estUneDemandePrestation();
  }
}

/* Location:
 * Qualified Name:     FiltreDemandesPrestation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */