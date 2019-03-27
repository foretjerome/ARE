package fr.unedic.cali.dom.affectation.outilsfonctionnels.qualification.strategies.spec;

import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.dom.affectation.Reglement;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieEvolutionReglementaireSpec;

public abstract interface StrategieCoordinationEuropeenneQualificationSpec
  extends StrategieEvolutionReglementaireSpec
{
  public abstract Reglement determineReglementPeriodeEnCoordinationEuropeenne(ActiviteSalarie paramActiviteSalarie);
}

/* Location:
 * Qualified Name:     StrategieCoordinationEuropeenneQualificationSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */