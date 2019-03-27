package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.affectation.GammeSpec;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltreAttributionAutreQueRenoncement
  implements FiltreTemporel
{
  private static final long serialVersionUID = -4922747950675644684L;
  
  public boolean accepter(Temporel p_temporel)
  {
    try
    {
      DemandeSpec demande = (DemandeSpec)p_temporel;
      if ((demande != null) && (demande.getGamme() != null) && (!demande.getGamme().estDecisionRenoncement(demande))) {
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
 * Qualified Name:     FiltreAttributionAutreQueRenoncement
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */