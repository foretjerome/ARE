package fr.unedic.cali.autresdoms.d90.dom;

import fr.unedic.util.temps.Damj;

public class InfoReexecution
{
  private boolean m_executable = false;
  private Damj m_dateExecution;
  
  public Damj getDateExecution()
  {
    return m_dateExecution;
  }
  
  public void setDateExecution(Damj p_dateExecution)
  {
    m_dateExecution = p_dateExecution;
  }
  
  public boolean isExecutable()
  {
    return m_executable;
  }
  
  public void setExecutable(boolean p_executable)
  {
    m_executable = p_executable;
  }
}

/* Location:
 * Qualified Name:     InfoReexecution
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */