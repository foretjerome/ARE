package fr.unedic.cali.calcul.dom.temps;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class ObjetChronoPeriodeLimiteIndemnisationPMVS
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = 1L;
  private String m_rsod;
  
  public ObjetChronoPeriodeLimiteIndemnisationPMVS() {}
  
  public ObjetChronoPeriodeLimiteIndemnisationPMVS(Damj p_date, String p_rsod)
  {
    super(p_date, p_date);
    setRsod(p_rsod);
  }
  
  public ObjetMetierSpec copie()
  {
    ObjetChronoPeriodeLimiteIndemnisationPMVS copie = new ObjetChronoPeriodeLimiteIndemnisationPMVS();
    copieElements(copie);
    return copie;
  }
  
  public String getRsod()
  {
    return m_rsod;
  }
  
  public void setRsod(String p_rsod)
  {
    m_rsod = p_rsod;
  }
  
  public String toString()
  {
    return "ObjetChrono:   type element (" + getTypeElement() + ")," + "\n" + "date Debut (" + getDateDebut().toString() + ")," + "date Fin (" + getDateFin().toString() + ")," + "type date Effet (" + getTypeDateEffet() + ")," + "rsod (" + getRsod() + ")," + "priorite (" + getPriorite() + ")";
  }
}

/* Location:
 * Qualified Name:     ObjetChronoPeriodeLimiteIndemnisationPMVS
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */