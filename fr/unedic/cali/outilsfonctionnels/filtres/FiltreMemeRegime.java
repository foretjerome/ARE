package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.dom.affectation.DecorReglementaire;
import fr.unedic.cali.dom.affectation.ProduitAbstrait;
import fr.unedic.cali.dom.affectation.Reglement;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;
import java.util.Iterator;
import java.util.List;

public class FiltreMemeRegime
  implements FiltreTemporel
{
  private Reglement m_reglement = null;
  
  public FiltreMemeRegime(String p_nomReglement, DecorReglementaire p_decor)
  {
    List listeProduitsDuDecor = p_decor.getListeProduits();
    
    Iterator iter = listeProduitsDuDecor.iterator();
    while (iter.hasNext())
    {
      m_reglement = ((ProduitAbstrait)iter.next()).getReglement(p_nomReglement);
      if (m_reglement != null) {
        break;
      }
    }
  }
  
  public boolean accepter(Temporel p_temporel)
  {
    Reglement reglement = null;
    try
    {
      if (p_temporel.estType(ActiviteSalarie.class))
      {
        reglement = ((ActiviteSalarie)p_temporel).getReglement();
        if (reglement != null)
        {
          if (m_reglement != null) {
            return reglement.estNomReglementIdentique(m_reglement.getNomReglement());
          }
          return false;
        }
        return false;
      }
      return false;
    }
    catch (ClassCastException ex)
    {
      if (Log.isTraceActive(FiltreMemeRegime.class, Niveau.DEBUG)) {
        Log.ecritTrace(Niveau.DEBUG, FiltreMemeRegime.class, "accepter", ex);
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     FiltreMemeRegime
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */