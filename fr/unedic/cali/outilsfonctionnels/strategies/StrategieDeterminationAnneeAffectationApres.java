package fr.unedic.cali.outilsfonctionnels.strategies;

import fr.unedic.cali.autresdoms.ga.dom.ActionFormation;
import fr.unedic.cali.outilsfonctionnels.strategies.spec.StrategieDeterminationAnneeAffectationSpec;
import fr.unedic.util.temps.Damj;

public class StrategieDeterminationAnneeAffectationApres
  implements StrategieDeterminationAnneeAffectationSpec
{
  public int determinerAnneeAffectation(Damj p_datePremiereValidation, ActionFormation p_actionFormation)
  {
    return p_datePremiereValidation != null ? p_datePremiereValidation.getAnnee() : 0;
  }
}

/* Location:
 * Qualified Name:     StrategieDeterminationAnneeAffectationApres
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */