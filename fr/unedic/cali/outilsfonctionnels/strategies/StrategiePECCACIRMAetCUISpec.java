package fr.unedic.cali.outilsfonctionnels.strategies;

import fr.unedic.cali.autresdoms.cohab.dom.ObjetChronoPeriodePriseEnChargeSansFiltre;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public abstract interface StrategiePECCACIRMAetCUISpec
  extends StrategieEvolutionReglementaireSpec
{
  public static final Damj DATE_PIVOT_PEC_ACTUALISABLE = new Damj(2010, 1, 1);
  
  public abstract int mapperTypeContratParticulier(int paramInt);
  
  public abstract void ajouterEvenementCA(ChronologiePeriodes paramChronologiePeriodes, ObjetChronoPeriodePriseEnChargeSansFiltre paramObjetChronoPeriodePriseEnChargeSansFiltre, Periode paramPeriode, Damj paramDamj);
  
  public abstract void ajouterEvenementCIRMA(ChronologiePeriodes paramChronologiePeriodes, ObjetChronoPeriodePriseEnChargeSansFiltre paramObjetChronoPeriodePriseEnChargeSansFiltre, Periode paramPeriode, Damj paramDamj);
  
  public abstract boolean estActiviteChevauchantPecTypeParticulierPourNeutralisationPFM(ObjetChronoPeriodePriseEnChargeSansFiltre paramObjetChronoPeriodePriseEnChargeSansFiltre);
  
  public abstract void ajouterAnomalieM09(ObjetChronoPeriodePriseEnChargeSansFiltre paramObjetChronoPeriodePriseEnChargeSansFiltre, Damj paramDamj, IndividuSpec paramIndividuSpec)
    throws CoucheLogiqueException;
}

/* Location:
 * Qualified Name:     StrategiePECCACIRMAetCUISpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */