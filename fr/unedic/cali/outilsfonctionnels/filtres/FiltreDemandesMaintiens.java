package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltreDemandesMaintiens
  implements FiltreTemporel
{
  public boolean accepter(Temporel p_temporel)
  {
    boolean accepter = false;
    DemandeSpec demande = (DemandeSpec)p_temporel;
    if (demande.getNumeroGamme() == 5) {
      accepter = true;
    }
    return accepter;
  }
}

/* Location:
 * Qualified Name:     FiltreDemandesMaintiens
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */