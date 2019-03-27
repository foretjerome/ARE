package fr.unedic.cali.outilsfonctionnels.strategies;

import fr.unedic.cali.calcul.dom.periode.PeriodeActiviteEmploiCalcul;
import fr.unedic.cali.calcul.outilsfonctionnels.DeterminerJustificatifsRevenusAR;
import fr.unedic.util.temps.ChronologiePeriodes;

public class StrategieFluxEttSeulSansHeureApresMEP
  implements StrategieFluxEttSeulSansHeureSpec
{
  public void determinerNombreHeureEttSeul(PeriodeActiviteEmploiCalcul p_periodeActiviteEmploiCalcul)
  {
    ChronologiePeriodes chronoPaec = new ChronologiePeriodes();
    chronoPaec.ajouter(p_periodeActiviteEmploiCalcul);
    DeterminerJustificatifsRevenusAR.traitementRevenusBS(chronoPaec, p_periodeActiviteEmploiCalcul.getDateDebut(), null);
  }
}

/* Location:
 * Qualified Name:     StrategieFluxEttSeulSansHeureApresMEP
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */