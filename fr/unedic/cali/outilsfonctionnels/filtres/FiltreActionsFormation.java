package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.ActionFormation;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltreActionsFormation
  implements FiltreTemporel
{
  public boolean accepter(Temporel p_temporel)
  {
    if (p_temporel.estType(ActionFormation.class))
    {
      ActionFormation actionFormation = (ActionFormation)p_temporel;
      if ("7".equals(actionFormation.getTypePlanFormation())) {
        return true;
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     FiltreActionsFormation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */