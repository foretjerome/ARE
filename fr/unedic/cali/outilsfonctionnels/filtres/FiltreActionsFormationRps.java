package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.ActionFormation;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltreActionsFormationRps
  implements FiltreTemporel
{
  private static final long serialVersionUID = 3810601793954860013L;
  
  public boolean accepter(Temporel temporel)
  {
    if (temporel.estType(ActionFormation.class))
    {
      ActionFormation actionFormation = (ActionFormation)temporel;
      if ("6".equals(actionFormation.getTypePlanFormation())) {
        return true;
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     FiltreActionsFormationRps
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */