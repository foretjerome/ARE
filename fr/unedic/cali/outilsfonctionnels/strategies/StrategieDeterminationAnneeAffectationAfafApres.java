package fr.unedic.cali.outilsfonctionnels.strategies;

import fr.unedic.cali.autresdoms.ga.dom.ActionFormation;
import fr.unedic.cali.outilsfonctionnels.strategies.spec.StrategieDeterminationAnneeAffectationSpec;
import fr.unedic.util.temps.Damj;

public class StrategieDeterminationAnneeAffectationAfafApres
  implements StrategieDeterminationAnneeAffectationSpec
{
  private static final int ANNEE_DATE_FIN_AFAF = 2013;
  
  public int determinerAnneeAffectation(Damj p_datePremiereValidation, ActionFormation p_actionFormation)
  {
    return p_datePremiereValidation != null ? Math.min(p_datePremiereValidation.getAnnee(), 2013) : 0;
  }
}

/* Location:
 * Qualified Name:     StrategieDeterminationAnneeAffectationAfafApres
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */