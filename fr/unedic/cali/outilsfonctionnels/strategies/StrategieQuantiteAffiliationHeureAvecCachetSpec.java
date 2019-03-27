package fr.unedic.cali.outilsfonctionnels.strategies;

import fr.unedic.cali.calcul.dom.periode.PeriodeActiviteEmploiCalcul;
import fr.unedic.util.Quantite;

public abstract interface StrategieQuantiteAffiliationHeureAvecCachetSpec
  extends StrategieCorrectionSpec
{
  public abstract void determinerQuantiteAffiliationHeureAvecCachet(PeriodeActiviteEmploiCalcul paramPeriodeActiviteEmploiCalcul, Quantite paramQuantite);
}

/* Location:
 * Qualified Name:     StrategieQuantiteAffiliationHeureAvecCachetSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */