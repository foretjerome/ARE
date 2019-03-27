package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.dom.affectation.Reglement;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;
import java.util.List;

public class FiltreAppartientReglements
  implements FiltreTemporel
{
  private List m_reglements = null;
  
  public FiltreAppartientReglements(List p_reglements)
  {
    m_reglements = p_reglements;
  }
  
  public boolean accepter(Temporel p_temporel)
  {
    Reglement reglementPeriode = null;
    try
    {
      if (p_temporel.estType(ActiviteSalarie.class))
      {
        reglementPeriode = ((ActiviteSalarie)p_temporel).getReglement();
        
        Reglement reglementCourant = null;
        for (int i = 0; i < m_reglements.size(); i++)
        {
          reglementCourant = (Reglement)m_reglements.get(i);
          if (reglementPeriode.equals(reglementCourant)) {
            return true;
          }
        }
        return false;
      }
      return false;
    }
    catch (ClassCastException ex)
    {
      if (Log.isTraceActive(FiltreAppartientReglements.class, Niveau.DEBUG)) {
        Log.ecritTrace(Niveau.DEBUG, FiltreAppartientReglements.class, "accepter", ex);
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     FiltreAppartientReglements
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */