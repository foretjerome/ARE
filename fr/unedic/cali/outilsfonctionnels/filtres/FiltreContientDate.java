package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Periode;
import fr.unedic.util.temps.Temporel;

public class FiltreContientDate
  implements FiltreTemporel
{
  private Damj m_date = null;
  
  public FiltreContientDate(Damj p_date)
  {
    m_date = p_date;
  }
  
  public boolean accepter(Temporel p_temporel)
  {
    return new Periode(p_temporel.getDateDebut(), p_temporel.getDateFin()).contient(m_date);
  }
}

/* Location:
 * Qualified Name:     FiltreContientDate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */