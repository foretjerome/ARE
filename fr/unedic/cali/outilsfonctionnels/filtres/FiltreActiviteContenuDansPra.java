package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.utilitaire.filtres.objetChronoPeriode.FiltreObjetChronoPeriodeChevauchePeriode;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Periode;
import fr.unedic.util.temps.Temporel;

public class FiltreActiviteContenuDansPra
  implements FiltreTemporel
{
  private static final long serialVersionUID = 1L;
  private Periode m_periode;
  
  public FiltreActiviteContenuDansPra(Periode p_periode)
  {
    m_periode = p_periode;
  }
  
  public boolean accepter(Temporel p_temporel)
  {
    FiltreObjetChronoPeriodeChevauchePeriode filtre = new FiltreObjetChronoPeriodeChevauchePeriode(m_periode, "MVS");
    return filtre.accepter(p_temporel);
  }
}

/* Location:
 * Qualified Name:     FiltreActiviteContenuDansPra
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */