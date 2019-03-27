package fr.unedic.cali.calcul.dom.temps;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class ObjetChronoPeriodeLimiteIndemnisationATAcatPart
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = 1L;
  private String rsod;
  
  public ObjetChronoPeriodeLimiteIndemnisationATAcatPart() {}
  
  public ObjetChronoPeriodeLimiteIndemnisationATAcatPart(Damj date, String rsod)
  {
    super(date, date);
    setRsod(rsod);
  }
  
  public ObjetMetierSpec copie()
  {
    ObjetChronoPeriodeLimiteIndemnisationATAcatPart copie = new ObjetChronoPeriodeLimiteIndemnisationATAcatPart();
    copieElements(copie);
    return copie;
  }
  
  public String getRsod()
  {
    return rsod;
  }
  
  public void setRsod(String rsod)
  {
    this.rsod = rsod;
  }
}

/* Location:
 * Qualified Name:     ObjetChronoPeriodeLimiteIndemnisationATAcatPart
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */