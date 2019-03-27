package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.ObjetChronoPeriode;
import fr.unedic.util.temps.Temporel;

public class FiltreDateFinPeriode
  implements FiltreTemporel
{
  private static final long serialVersionUID = -1345828157975070441L;
  private Damj m_dateFin;
  
  public FiltreDateFinPeriode(Damj p_dateFin)
  {
    m_dateFin = p_dateFin;
  }
  
  public boolean accepter(Temporel p_temporel)
  {
    if ((p_temporel instanceof ObjetChronoPeriode))
    {
      if (((ObjetChronoPeriode)p_temporel).getDateFin() == null) {
        return false;
      }
      return ((ObjetChronoPeriode)p_temporel).getDateFin().coincideAvec(m_dateFin);
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     FiltreDateFinPeriode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */