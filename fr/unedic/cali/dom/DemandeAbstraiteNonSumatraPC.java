package fr.unedic.cali.dom;

import fr.unedic.cali.dom.pc.DemandeAbstraitePC;

public class DemandeAbstraiteNonSumatraPC
  extends DemandeAbstraitePC
{
  private DemandeAbstraiteNonSumatra m_om;
  
  public DemandeAbstraiteNonSumatraPC(DemandeAbstraiteNonSumatra p_sumatra)
  {
    m_om = p_sumatra;
  }
  
  public Object createOM()
  {
    return m_om;
  }
}

/* Location:
 * Qualified Name:     DemandeAbstraiteNonSumatraPC
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */