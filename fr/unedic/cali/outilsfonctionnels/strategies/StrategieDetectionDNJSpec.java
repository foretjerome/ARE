package fr.unedic.cali.outilsfonctionnels.strategies;

import fr.unedic.cali.autresdoms.ga.dom.DeclareTravail;
import fr.unedic.cali.calcul.dom.UniteTraitement;
import fr.unedic.cali.calcul.dom.periode.DsmTravail;
import java.util.Collection;

public abstract interface StrategieDetectionDNJSpec
  extends StrategieCorrectionSpec
{
  public abstract void determinerStatutPeriodeDeclaree(DeclareTravail paramDeclareTravail);
  
  public abstract void enrichirListeDNJ(DsmTravail paramDsmTravail, UniteTraitement paramUniteTraitement, Collection paramCollection);
}

/* Location:
 * Qualified Name:     StrategieDetectionDNJSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */