package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.FiltresTemporel;
import fr.unedic.util.temps.Periode;
import fr.unedic.util.temps.Temporel;

public class FiltrePeriodeHorsAttributionODA4
  extends FiltresTemporel
{
  private static final long serialVersionUID = 1L;
  private Periode m_periode = null;
  
  public FiltrePeriodeHorsAttributionODA4(Periode p_periode)
  {
    m_periode = p_periode;
  }
  
  public boolean accepter(Temporel p_temporel)
  {
    return estDansPeriode(p_temporel);
  }
  
  private boolean estDansPeriode(Temporel p_temporel)
  {
    if ((m_periode.chevauche(new Periode(p_temporel.getDateDebut(), p_temporel.getDateFin()))) && (p_temporel.getDateFin().estAvantOuCoincideAvec(m_periode.getFin()))) {
      return false;
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     FiltrePeriodeHorsAttributionODA4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */