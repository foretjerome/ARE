package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeCalculTransient;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public abstract class FinPeriodeSanction
  extends ObjetChronoPeriodeCalculTransient
{
  public String m_codeSanction;
  
  protected FinPeriodeSanction() {}
  
  public FinPeriodeSanction(Damj p_date)
  {
    super(p_date, p_date);
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    FinPeriodeSanction copie = (FinPeriodeSanction)p_copie;
    
    super.copieElements(p_copie);
    
    m_codeSanction = getCodeSanction();
  }
  
  public String getCodeSanction()
  {
    return m_codeSanction;
  }
  
  public void setCodeSanction(String p_codeSanction)
  {
    m_codeSanction = p_codeSanction;
  }
}

/* Location:
 * Qualified Name:     FinPeriodeSanction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */