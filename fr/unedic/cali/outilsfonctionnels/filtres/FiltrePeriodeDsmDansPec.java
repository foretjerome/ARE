package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.cohab.dom.ObjetChronoPeriodePriseEnCharge;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeDeclare;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;
import java.util.Iterator;

public class FiltrePeriodeDsmDansPec
  implements FiltreTemporel
{
  private Chronologie m_chronologiesPec = null;
  
  public FiltrePeriodeDsmDansPec(Chronologie p_chronologiePec)
  {
    m_chronologiesPec = p_chronologiePec;
  }
  
  public boolean accepter(Temporel p_temporel)
  {
    PeriodeDeclare periodeDSM = null;
    boolean retour;
    boolean retour;
    if (p_temporel.estType(PeriodeDeclare.class))
    {
      periodeDSM = (PeriodeDeclare)p_temporel;
      Iterator iterPec = m_chronologiesPec.iterer();
      while (iterPec.hasNext())
      {
        ObjetChronoPeriodePriseEnCharge periodePec = (ObjetChronoPeriodePriseEnCharge)iterPec.next();
        if ((periodePec.getDateDebut().estAvantOuCoincideAvec(periodeDSM.getDateDebut())) && (periodePec.getDateFin().estApresOuCoincideAvec(periodeDSM.getDateDebut()))) {
          return true;
        }
      }
      retour = false;
    }
    else
    {
      retour = true;
    }
    return retour;
  }
}

/* Location:
 * Qualified Name:     FiltrePeriodeDsmDansPec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */