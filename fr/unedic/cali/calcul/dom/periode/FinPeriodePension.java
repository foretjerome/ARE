package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeCalculTransient;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.QuantiteEuro;
import fr.unedic.util.temps.Damj;

public abstract class FinPeriodePension
  extends ObjetChronoPeriodeCalculTransient
{
  private QuantiteEuro m_quantiteEuro = null;
  
  protected FinPeriodePension() {}
  
  public FinPeriodePension(Damj p_date)
  {
    super(p_date, p_date);
  }
  
  public QuantiteEuro getQuantiteEuro()
  {
    return m_quantiteEuro;
  }
  
  public void setQuantiteEuro(QuantiteEuro p_quantiteEuro)
  {
    m_quantiteEuro = p_quantiteEuro;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    FinPeriodePension copie = (FinPeriodePension)p_copie;
    
    super.copieElements(copie);
    
    m_quantiteEuro = getQuantiteEuro();
  }
}

/* Location:
 * Qualified Name:     FinPeriodePension
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */