package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.EvenementReferenceExamenSpec;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltreDemandesAer
  implements FiltreTemporel
{
  public boolean accepter(Temporel p_temporel)
  {
    try
    {
      EvenementReferenceExamenSpec ere = ((DemandeSpec)p_temporel).getEvenementReferenceExamen();
      if (ere == null) {
        return false;
      }
      String typeExamen = ere.getTypeExamen();
      if ((typeExamen.equalsIgnoreCase("SOL_08")) || (typeExamen.equalsIgnoreCase("SOL_02"))) {
        return true;
      }
    }
    catch (ClassCastException e)
    {
      if (Log.isTraceActive(FiltreDemandesAer.class, Niveau.DEBUG)) {
        Log.ecritTrace(Niveau.DEBUG, FiltreDemandesAer.class, "accepter", e);
      }
      return false;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     FiltreDemandesAer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */