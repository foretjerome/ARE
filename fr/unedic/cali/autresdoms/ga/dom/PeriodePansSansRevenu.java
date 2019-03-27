package fr.unedic.cali.autresdoms.ga.dom;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoPeriode;
import fr.unedic.util.temps.Periode;

public class PeriodePansSansRevenu
  extends ObjetChronoPeriode
{
  private static final long serialVersionUID = 1L;
  private int natureRemuneration;
  
  public int getNatureRemuneration()
  {
    return natureRemuneration;
  }
  
  public void setNatureRemuneration(int natureRemuneration)
  {
    this.natureRemuneration = natureRemuneration;
  }
  
  public PeriodePansSansRevenu(Damj p_dateDebut, Damj p_dateFin)
  {
    super(p_dateDebut, p_dateFin);
  }
  
  public PeriodePansSansRevenu(Periode p_periode)
  {
    super(p_periode);
  }
  
  public ObjetMetierSpec copie()
  {
    return this;
  }
  
  public Periode getPeriode()
  {
    return super.getPeriode();
  }
}

/* Location:
 * Qualified Name:     PeriodePansSansRevenu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */