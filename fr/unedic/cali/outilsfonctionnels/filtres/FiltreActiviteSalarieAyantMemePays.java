package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.autresdoms.ga.dom.ContratTravail;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltreActiviteSalarieAyantMemePays
  implements FiltreTemporel
{
  private static final long serialVersionUID = -3325862751601103827L;
  private int m_pays = 0;
  
  public FiltreActiviteSalarieAyantMemePays(int p_pays)
  {
    m_pays = p_pays;
  }
  
  public boolean accepter(Temporel p_temporel)
  {
    if ((p_temporel.estType(ActiviteSalarie.class)) && (((ActiviteSalarie)p_temporel).getContrat() != null) && (((ActiviteSalarie)p_temporel).getContrat().getPays() == m_pays)) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     FiltreActiviteSalarieAyantMemePays
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */