package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeGaec;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltrePeriodeMemeIdentifiant
  implements FiltreTemporel
{
  private String m_identifiantRecherche = null;
  
  public FiltrePeriodeMemeIdentifiant(String p_identifiantRecherche)
  {
    m_identifiantRecherche = p_identifiantRecherche;
  }
  
  public boolean accepter(Temporel p_temporel)
  {
    try
    {
      String identifiantCourant = ((PeriodeGaec)p_temporel).getIdentifiant();
      if (identifiantCourant.equalsIgnoreCase(m_identifiantRecherche)) {
        return true;
      }
    }
    catch (ClassCastException e)
    {
      if (Log.isTraceActive(FiltrePeriodeMemeIdentifiant.class, Niveau.DEBUG)) {
        Log.ecritTrace(Niveau.DEBUG, FiltrePeriodeMemeIdentifiant.class, "accepter", e);
      }
      return false;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     FiltrePeriodeMemeIdentifiant
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */