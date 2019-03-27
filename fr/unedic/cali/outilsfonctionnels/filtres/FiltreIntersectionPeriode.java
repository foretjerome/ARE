package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.ObjetChronoPeriode;
import fr.unedic.util.temps.Periode;
import fr.unedic.util.temps.Temporel;

public class FiltreIntersectionPeriode
  implements FiltreTemporel
{
  private Periode m_periodeChevauchement = null;
  
  public FiltreIntersectionPeriode(Periode p_periode)
  {
    m_periodeChevauchement = p_periode;
  }
  
  public boolean accepter(Temporel p_temporel)
  {
    if (p_temporel.estType(ObjetChronoPeriode.class))
    {
      Periode periode = m_periodeChevauchement.periodeIntersection(new Periode(p_temporel.getDateDebut(), p_temporel.getDateFin()));
      return periode != null;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     FiltreIntersectionPeriode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */