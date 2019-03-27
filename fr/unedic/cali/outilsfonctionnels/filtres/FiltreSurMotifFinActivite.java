package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltreSurMotifFinActivite
  implements FiltreTemporel
{
  private int m_motifFin;
  
  public FiltreSurMotifFinActivite(int p_motifFin)
  {
    m_motifFin = p_motifFin;
  }
  
  public boolean accepter(Temporel p_temporel)
  {
    return (p_temporel.estType(ActiviteSalarie.class)) && (((ActiviteSalarie)p_temporel).getCodeMotifFin() == m_motifFin);
  }
}

/* Location:
 * Qualified Name:     FiltreSurMotifFinActivite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */