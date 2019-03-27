package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.outilsfonctionnels.OutilDemande;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltreDemandeAre
  implements FiltreTemporel
{
  private static final long serialVersionUID = 1L;
  
  public boolean accepter(Temporel p_temporel)
  {
    boolean estAccepte = false;
    try
    {
      estAccepte = OutilDemande.estUneDemandeAre((DemandeSpec)p_temporel);
    }
    catch (Exception e)
    {
      estAccepte = false;
    }
    return estAccepte;
  }
}

/* Location:
 * Qualified Name:     FiltreDemandeAre
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */