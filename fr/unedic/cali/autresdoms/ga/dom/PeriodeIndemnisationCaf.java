package fr.unedic.cali.autresdoms.ga.dom;

import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class PeriodeIndemnisationCaf
  extends PeriodeEvenementPersonnelIndemnisable
{
  int m_natureAllocation;
  
  public PeriodeIndemnisationCaf()
  {
    initInstance();
  }
  
  public PeriodeIndemnisationCaf(Damj p_dateDebut, Damj p_dateFin)
  {
    setPeriode(new Periode(p_dateDebut, p_dateFin));
    initInstance();
  }
  
  public PeriodeIndemnisationCaf(Periode p_periode)
  {
    setPeriode(p_periode);
    initInstance();
  }
  
  public int getNatureAllocation()
  {
    return m_natureAllocation;
  }
  
  public void setNatureAllocation(int p_natureAllocation)
  {
    m_natureAllocation = p_natureAllocation;
  }
}

/* Location:
 * Qualified Name:     PeriodeIndemnisationCaf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */