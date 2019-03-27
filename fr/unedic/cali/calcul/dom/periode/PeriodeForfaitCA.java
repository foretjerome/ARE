package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.util.ObjetMetierSpec;

public class PeriodeForfaitCA
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
    PeriodeForfaitCA copie = new PeriodeForfaitCA();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    PeriodeForfaitCA copie = (PeriodeForfaitCA)p_copie;
    super.copieElements(copie);
    copie.setForfait(isForfait());
  }
}

/* Location:
 * Qualified Name:     PeriodeForfaitCA
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */