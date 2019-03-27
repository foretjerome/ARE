package fr.unedic.cali.dom;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoPeriode;
import fr.unedic.util.temps.Periode;

public class PeriodeChomageAtteste
  extends ObjetChronoPeriode
{
  public PeriodeChomageAtteste() {}
  
  public PeriodeChomageAtteste(Damj p_dateDebut, Damj p_dateFin)
  {
    super(p_dateDebut, p_dateFin);
  }
  
  public PeriodeChomageAtteste(Periode p_periode)
  {
    super(p_periode);
  }
  
  public void setDateDebut(Damj p_date)
  {
    super.setDateDebut(p_date);
  }
  
  public ObjetMetierSpec copie()
  {
    return this;
  }
}

/* Location:
 * Qualified Name:     PeriodeChomageAtteste
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */