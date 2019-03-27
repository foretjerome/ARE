package fr.unedic.cali.outilsfonctionnels.strategies.spec;

import fr.unedic.cali.autresdoms.ga.dom.ActionFormation;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieEvolutionReglementaireSpec;
import fr.unedic.util.temps.Damj;

public abstract interface StrategieDeterminationAnneeAffectationSpec
  extends StrategieEvolutionReglementaireSpec
{
  public abstract int determinerAnneeAffectation(Damj paramDamj, ActionFormation paramActionFormation);
}

/* Location:
 * Qualified Name:     StrategieDeterminationAnneeAffectationSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */