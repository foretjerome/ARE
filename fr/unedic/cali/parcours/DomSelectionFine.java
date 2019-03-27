package fr.unedic.cali.parcours;

import fr.unedic.util.temps.Damj;

public class DomSelectionFine
  extends DomTraitementOccasionnel
{
  private boolean m_estAReexecuter;
  private Damj m_dateReexecution;
  
  public boolean isEstAReexecuter()
  {
    return m_estAReexecuter;
  }
  
  public void setEstAReexecuter(boolean p_estAReexecuter)
  {
    m_estAReexecuter = p_estAReexecuter;
  }
  
  public Damj getDateReexecution()
  {
    return m_dateReexecution;
  }
  
  public void setDateReexecution(Damj p_dateReexecution)
  {
    m_dateReexecution = p_dateReexecution;
  }
}

/* Location:
 * Qualified Name:     DomSelectionFine
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */