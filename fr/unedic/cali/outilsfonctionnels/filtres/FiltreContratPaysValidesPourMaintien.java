package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.autresdoms.ga.dom.ContratTravail;
import fr.unedic.util.temps.Temporel;

public class FiltreContratPaysValidesPourMaintien
  extends FiltreContratPaysUnionEuropeenne
{
  public boolean accepter(Temporel p_temporel)
  {
    try
    {
      ActiviteSalarie periodeActiviteSalarie = (ActiviteSalarie)p_temporel;
      int paysContratTravail = periodeActiviteSalarie.getContrat().getPays();
      if (!super.accepter(p_temporel))
      {
        switch (paysContratTravail)
        {
        case 2: 
        case 4: 
        case 5: 
        case 6: 
        case 46: 
        case 47: 
        case 48: 
        case 49: 
        case 50: 
        case 51: 
        case 52: 
        case 53: 
        case 54: 
        case 55: 
        case 56: 
        case 59: 
          return true;
        }
        return false;
      }
      return true;
    }
    catch (ClassCastException e)
    {
      if (Log.isTraceActive(FiltreContratPaysUnionEuropeenne.class, Niveau.DEBUG)) {
        Log.ecritTrace(Niveau.DEBUG, FiltreContratPaysUnionEuropeenne.class, "accepter", e);
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     FiltreContratPaysValidesPourMaintien
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */