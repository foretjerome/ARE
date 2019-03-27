package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltreDemandesDec
  implements FiltreTemporel
{
  private static final long serialVersionUID = 6472509907891346145L;
  
  public boolean accepter(Temporel p_temporel)
  {
    try
    {
      if (((DemandeSpec)p_temporel).getNumeroGamme() == 10) {
        return true;
      }
    }
    catch (ClassCastException e)
    {
      if (Log.isTraceActive(FiltreDemandesDec.class, Niveau.DEBUG)) {
        Log.ecritTrace(Niveau.DEBUG, FiltreDemandesDec.class, "accepter", e);
      }
      return false;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     FiltreDemandesDec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */