package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.autresdoms.ga.dom.ContratTravail;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltreContratPaysUnionEuropeenne
  implements FiltreTemporel
{
  public boolean accepter(Temporel p_temporel)
  {
    try
    {
      ActiviteSalarie periodeActiviteSalarie = (ActiviteSalarie)p_temporel;
      int paysContratTravail = periodeActiviteSalarie.getContrat().getPays();
      switch (paysContratTravail)
      {
      case 1: 
      case 17: 
      case 19: 
      case 20: 
      case 21: 
      case 22: 
      case 24: 
      case 25: 
      case 27: 
      case 32: 
      case 34: 
      case 36: 
      case 39: 
      case 40: 
      case 41: 
      case 42: 
        return true;
      }
      return false;
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
 * Qualified Name:     FiltreContratPaysUnionEuropeenne
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */