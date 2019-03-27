package fr.unedic.cali.outilsfonctionnels.strategies;

import fr.unedic.cali.calcul.dom.periode.PeriodeActiviteEmploiCalcul;

public abstract interface StrategieFluxEttSeulSansHeureSpec
  extends StrategieCorrectionSpec
{
  public abstract void determinerNombreHeureEttSeul(PeriodeActiviteEmploiCalcul paramPeriodeActiviteEmploiCalcul);
}

/* Location:
 * Qualified Name:     StrategieFluxEttSeulSansHeureSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */