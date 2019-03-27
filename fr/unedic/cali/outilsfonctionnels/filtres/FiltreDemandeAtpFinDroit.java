package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.outilsfonctionnels.OutilDemande;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltreDemandeAtpFinDroit
  implements FiltreTemporel
{
  private static final long serialVersionUID = -5127078627664959616L;
  
  public boolean accepter(Temporel p_temporel)
  {
    boolean estAccepte = false;
    try
    {
      DemandeSpec demande = (DemandeSpec)p_temporel;
      if (OutilDemande.estUneDemandeFinDroitAtp(demande)) {
        estAccepte = true;
      }
    }
    catch (Exception e)
    {
      estAccepte = false;
    }
    return estAccepte;
  }
}

/* Location:
 * Qualified Name:     FiltreDemandeAtpFinDroit
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */