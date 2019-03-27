package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.EvenementReferenceExamenSpec;
import fr.unedic.cali.outilsfonctionnels.OutilTrace;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltreDemandeAEPE
  implements FiltreTemporel
{
  private static final long serialVersionUID = 1L;
  
  public boolean accepter(Temporel p_temporel)
  {
    try
    {
      EvenementReferenceExamenSpec ere = ((DemandeSpec)p_temporel).getEvenementReferenceExamen();
      if (ere == null) {
        return false;
      }
      String typeExamen = ere.getTypeExamen();
      if ((typeExamen.equalsIgnoreCase("SOL_17")) || (typeExamen.equalsIgnoreCase("SOL_18"))) {
        return true;
      }
    }
    catch (ClassCastException e)
    {
      OutilTrace.ecrireTrace(Niveau.DEBUG, new Object[] { "Erreur sur accepter : ", e });
      return false;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     FiltreDemandeAEPE
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */