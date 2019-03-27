package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.cohab.dom.ObjetChronoPeriodePriseEnCharge;
import fr.unedic.cali.outilsfonctionnels.OutillagePEC;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltrePecAutreEtatMembreCoordination
  extends FiltrePeriodesComplementaires
  implements FiltreTemporel
{
  private static final long serialVersionUID = -4030624696216966339L;
  
  public boolean accepter(Temporel p_temporel)
  {
    boolean retour = false;
    if (((p_temporel instanceof ObjetChronoPeriodePriseEnCharge)) && (OutillagePEC.estPecAutreEtatMembreCoordination((ObjetChronoPeriodePriseEnCharge)p_temporel))) {
      retour = true;
    }
    return retour;
  }
}

/* Location:
 * Qualified Name:     FiltrePecAutreEtatMembreCoordination
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */