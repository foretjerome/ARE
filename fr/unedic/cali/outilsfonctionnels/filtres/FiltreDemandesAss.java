package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.EvenementReferenceExamenSpec;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltreDemandesAss
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
      if ((typeExamen.equalsIgnoreCase("SOL_05")) || (typeExamen.equalsIgnoreCase("SOL_09")) || (typeExamen.equalsIgnoreCase("SOL_04")) || (typeExamen.equalsIgnoreCase("SOL_07")) || (typeExamen.equalsIgnoreCase("SOL_06")) || (typeExamen.equalsIgnoreCase("SOL_03")) || (typeExamen.equalsIgnoreCase("SOL_10")) || (typeExamen.equalsIgnoreCase("SOL_01")) || (typeExamen.equalsIgnoreCase("SOL_26"))) {
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
 * Qualified Name:     FiltreDemandesAss
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */