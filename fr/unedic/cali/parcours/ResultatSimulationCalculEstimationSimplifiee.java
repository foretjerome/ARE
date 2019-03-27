package fr.unedic.cali.parcours;

import fr.unedic.util.services.Resultat;
import java.util.Hashtable;

public class ResultatSimulationCalculEstimationSimplifiee
  extends Resultat
{
  private static final long serialVersionUID = -3807085796950778307L;
  private Hashtable m_tableSimulations = null;
  
  public Hashtable getTableSimulations()
  {
    return m_tableSimulations;
  }
  
  public void setTableSimulations(Hashtable p_tableSimulations)
  {
    m_tableSimulations = p_tableSimulations;
  }
}

/* Location:
 * Qualified Name:     ResultatSimulationCalculEstimationSimplifiee
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */