package fr.unedic.cali.calcul.dom.temps;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class ObjetChronoPeriodeLimiteIndemnisationPTS
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = 1L;
  private String rsod;
  
  public ObjetChronoPeriodeLimiteIndemnisationPTS() {}
  
  public ObjetChronoPeriodeLimiteIndemnisationPTS(Damj date, String rsod)
  {
    super(date, date);
    setRsod(rsod);
  }
  
  public ObjetChronoPeriodeLimiteIndemnisationPTS(Damj date)
  {
    super(date, date);
  }
  
  public ObjetMetierSpec copie()
  {
    ObjetChronoPeriodeLimiteIndemnisationPTS copie = new ObjetChronoPeriodeLimiteIndemnisationPTS();
    copieElements(copie);
    return copie;
  }
  
  public String getRsod()
  {
    return rsod;
  }
  
  public void setRsod(String prsod)
  {
    rsod = prsod;
  }
}

/* Location:
 * Qualified Name:     ObjetChronoPeriodeLimiteIndemnisationPTS
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */