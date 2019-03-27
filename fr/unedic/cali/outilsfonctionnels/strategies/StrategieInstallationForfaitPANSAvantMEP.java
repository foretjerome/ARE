package fr.unedic.cali.outilsfonctionnels.strategies;

import fr.unedic.cali.autresdoms.ga.dom.PeriodeActiviteNonSalariePeriodique;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.PeriodeActivite;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.DureeCalendaire;

public class StrategieInstallationForfaitPANSAvantMEP
  implements StrategieInstallationForfaitPANSSpec
{
  public Damj getDateFinGenerationForfaitPans(Damj dateDebut, Damj fin, Damj dernierJourAtteste)
  {
    Damj dateFin = fin;
    if (dateFin.coincideAvec(Damj.FIN_DES_TEMPS)) {
      if (dernierJourAtteste != null) {
        dateFin = dernierJourAtteste.deplacerVersAvant(new DureeCalendaire(2));
      } else {
        dateFin = dateDebut.deplacerVersAvant(new DureeCalendaire(2));
      }
    }
    return dateFin;
  }
  
  public ChronologiePeriodes recupererPeriodesSansRevenu(PeriodeActivite periodeActivite, PeriodeActiviteNonSalariePeriodique periodeActiviteNonSalariePeriodique, Damj dernierJourAtteste)
    throws CoucheLogiqueException
  {
    return new ChronologiePeriodes();
  }
}

/* Location:
 * Qualified Name:     StrategieInstallationForfaitPANSAvantMEP
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */