package fr.unedic.cali.utilitaire.comparateurs;

import fr.unedic.cali.dom.PeriodeDroitAAH;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.io.Serializable;
import java.util.Comparator;

public class ComparateurPeriodeAAHSurDateCroissante
  implements Comparator<Object>, Serializable
{
  public int compare(Object objet1, Object objet2)
  {
    PeriodeDroitAAH periodeaah1 = (PeriodeDroitAAH)objet1;
    PeriodeDroitAAH periodeaah2 = (PeriodeDroitAAH)objet2;
    Damj dateDebut1 = periodeaah1.getPeriodeDroit().getDebut();
    Damj dateDebut2 = periodeaah2.getPeriodeDroit().getDebut();
    if (dateDebut1.estAvant(dateDebut2)) {
      return -1;
    }
    if (dateDebut1.estApres(dateDebut2)) {
      return 1;
    }
    return 0;
  }
}

/* Location:
 * Qualified Name:     ComparateurPeriodeAAHSurDateCroissante
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */