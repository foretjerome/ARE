package fr.unedic.cali.outilsfonctionnels.strategies;

import fr.unedic.cali.autresdoms.ga.dom.ActionFormation;
import fr.unedic.cali.outilsfonctionnels.strategies.spec.StrategieDeterminationAnneeAffectationSpec;
import fr.unedic.util.temps.Damj;

public class StrategieDeterminationAnneeAffectationAvant
  implements StrategieDeterminationAnneeAffectationSpec
{
  public int determinerAnneeAffectation(Damj p_datePremiereValidation, ActionFormation p_actionFormation)
  {
    return p_actionFormation.getDateDebut() != null ? p_actionFormation.getDateDebut().getAnnee() : 0;
  }
}

/* Location:
 * Qualified Name:     StrategieDeterminationAnneeAffectationAvant
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */