package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.dom.ClassementSansObjet;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltreClassementSansObjet
  implements FiltreTemporel
{
  public boolean accepter(Temporel p_temporel)
  {
    boolean estAccepte = false;
    try
    {
      DemandeSpec demande = (DemandeSpec)p_temporel;
      if ((demande.getClassementAdministratif() instanceof ClassementSansObjet)) {
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
 * Qualified Name:     FiltreClassementSansObjet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */