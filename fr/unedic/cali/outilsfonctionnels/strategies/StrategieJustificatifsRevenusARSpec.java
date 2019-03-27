package fr.unedic.cali.outilsfonctionnels.strategies;

import fr.unedic.cali.calcul.dom.periode.PeriodeActiviteEmploiCalcul;

public abstract interface StrategieJustificatifsRevenusARSpec
  extends StrategieEvolutionReglementaireSpec
{
  public abstract boolean verifierConditionsRevenus(PeriodeActiviteEmploiCalcul paramPeriodeActiviteEmploiCalcul);
}

/* Location:
 * Qualified Name:     StrategieJustificatifsRevenusARSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */