package fr.unedic.cali.outilsfonctionnels.strategies;

import fr.unedic.cali.autresdoms.ga.dom.PeriodeActiviteNonSalariePeriodique;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.PeriodeActivite;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;

public abstract interface StrategieInstallationForfaitPANSSpec
  extends StrategieCorrectionSpec
{
  public abstract Damj getDateFinGenerationForfaitPans(Damj paramDamj1, Damj paramDamj2, Damj paramDamj3);
  
  public abstract ChronologiePeriodes recupererPeriodesSansRevenu(PeriodeActivite paramPeriodeActivite, PeriodeActiviteNonSalariePeriodique paramPeriodeActiviteNonSalariePeriodique, Damj paramDamj)
    throws CoucheLogiqueException;
}

/* Location:
 * Qualified Name:     StrategieInstallationForfaitPANSSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */