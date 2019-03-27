package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltrePeriodeFctPrincipale
  implements FiltreTemporel
{
  private Damj m_dateFin = null;
  
  public FiltrePeriodeFctPrincipale(Damj p_dateFin)
  {
    m_dateFin = p_dateFin;
  }
  
  public boolean accepter(Temporel p_temporel)
  {
    return (p_temporel.estType(ActiviteSalarie.class)) && (((ActiviteSalarie)p_temporel).getDateFin().equals(m_dateFin)) && (((ActiviteSalarie)p_temporel).estFctPrincipale());
  }
}

/* Location:
 * Qualified Name:     FiltrePeriodeFctPrincipale
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */