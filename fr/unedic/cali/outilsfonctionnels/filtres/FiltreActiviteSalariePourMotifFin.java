package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltreActiviteSalariePourMotifFin
  implements FiltreTemporel
{
  private int m_motifFin;
  private static final long serialVersionUID = 1L;
  
  public FiltreActiviteSalariePourMotifFin(int p_motifFin)
  {
    m_motifFin = p_motifFin;
  }
  
  public boolean accepter(Temporel p_temporel)
  {
    boolean accepter = false;
    FiltreActiviteSalarie filtreActiviteSalarie = new FiltreActiviteSalarie();
    accepter = filtreActiviteSalarie.accepter(p_temporel);
    if (accepter) {
      accepter = m_motifFin == Integer.parseInt(((ActiviteSalarie)p_temporel).getMotifFin());
    }
    return accepter;
  }
}

/* Location:
 * Qualified Name:     FiltreActiviteSalariePourMotifFin
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */