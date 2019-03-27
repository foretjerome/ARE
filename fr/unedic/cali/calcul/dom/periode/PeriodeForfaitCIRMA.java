package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.util.ObjetMetierSpec;

public class PeriodeForfaitCIRMA
  extends PeriodeTravailJustifiee
{
  private static final long serialVersionUID = 1L;
  private boolean m_forfait = false;
  
  public boolean isForfait()
  {
    return m_forfait;
  }
  
  public void setForfait(boolean p_forfait)
  {
    m_forfait = p_forfait;
  }
  
  public ObjetMetierSpec copie()
  {
    PeriodeForfaitCIRMA copie = new PeriodeForfaitCIRMA();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    PeriodeForfaitCIRMA copie = (PeriodeForfaitCIRMA)p_copie;
    super.copieElements(copie);
    copie.setForfait(isForfait());
  }
}

/* Location:
 * Qualified Name:     PeriodeForfaitCIRMA
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */