package fr.unedic.cali.autresdoms.ga.outilsfonctionnels;

import fr.unedic.cali.autresdoms.ga.dom.PeriodeActiviteSalarie;
import fr.unedic.cali.autresdoms.ga.dom.spec.IncidentSpec;
import fr.unedic.cali.autresdoms.ga.outilsfonctionnels.filtres.FiltreSuspensionChomageSansRupture;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.affectation.LigneSpec;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.EvenementPersonnel;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.EvenementPersonnelComplet;
import fr.unedic.util.services.OutilFonctionnel;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.FiltreDebutApresDate;

public class OutilsChomageSansRupture
  implements OutilFonctionnel
{
  public static boolean estUnEvenementDeTypeChomageSansRCT(EvenementPersonnelComplet evenementPersonnel)
  {
    return Integer.parseInt(evenementPersonnel.getEvenementPersonnel().getNature()) == 14;
  }
  
  public static boolean estUnePeriodeActiviteSalarieeAvecChomageSansRupture(PeriodeActiviteSalarie periodeActiviteSalarieGaec)
  {
    return !rechercherListePeriodesSuspensionChomageSansRupture(periodeActiviteSalarieGaec).estVide();
  }
  
  public static IncidentSpec rechercherProchainePeriodeSuspensionChomageSansRupture(PeriodeActiviteSalarie periodeActiviteSalarieGaec, Damj dateMinAInclureDansRecherche)
  {
    Chronologie listePeriodeSuspensionChomageSansRupture = rechercherListePeriodesSuspensionChomageSansRupture(periodeActiviteSalarieGaec);
    Chronologie listePeriodeSuspensionChomageSansRuptureApresDate = listePeriodeSuspensionChomageSansRupture.copier(new FiltreDebutApresDate(dateMinAInclureDansRecherche));
    if (!listePeriodeSuspensionChomageSansRuptureApresDate.estVide()) {
      return (IncidentSpec)listePeriodeSuspensionChomageSansRuptureApresDate.premierElement();
    }
    return null;
  }
  
  public static Chronologie rechercherListePeriodesSuspensionChomageSansRupture(PeriodeActiviteSalarie periodeActiviteSalarieGaec)
  {
    if (periodeActiviteSalarieGaec != null) {
      return periodeActiviteSalarieGaec.getListePeriodesIncident().copier(new FiltreSuspensionChomageSansRupture());
    }
    return null;
  }
  
  public static boolean estUnProduitDeChomageSansRupture(AttributionSpec attribution)
  {
    return attribution.getProduit().getLigne().getNomUnique().equals("ASU_CSR04");
  }
}

/* Location:
 * Qualified Name:     OutilsChomageSansRupture
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */