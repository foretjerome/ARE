package fr.unedic.cali.autresdoms.ga.dom;

import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class DeclareMaladie
  extends PeriodeDeclare
{
  public DeclareMaladie(Periode p_periode)
  {
    super(p_periode);
  }
  
  public DeclareMaladie(Damj p_dateDebut, Damj p_dateFin)
  {
    super(p_dateDebut, p_dateFin);
  }
}

/* Location:
 * Qualified Name:     DeclareMaladie
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */