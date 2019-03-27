package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltreDemandesHorsGammeRbf
  implements FiltreTemporel
{
  public boolean accepter(Temporel p_temporel)
  {
    try
    {
      if (((DemandeSpec)p_temporel).getNumeroGamme() != 3) {
        return true;
      }
    }
    catch (ClassCastException e)
    {
      if (Log.isTraceActive(FiltreDemandesHorsGammeRbf.class, Niveau.DEBUG)) {
        Log.ecritTrace(Niveau.DEBUG, FiltreDemandesHorsGammeRbf.class, "accepter", e);
      }
      return false;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     FiltreDemandesHorsGammeRbf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */