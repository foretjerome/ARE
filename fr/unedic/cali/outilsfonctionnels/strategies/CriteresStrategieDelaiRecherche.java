package fr.unedic.cali.outilsfonctionnels.strategies;

import fr.unedic.util.Quantite;

public class CriteresStrategieDelaiRecherche
  extends CritereStrategie
{
  private int m_typeCoordinationEuropeenne = 0;
  private Quantite m_sjrForce = null;
  
  public int getTypeCoordinationEuropeenne()
  {
    return m_typeCoordinationEuropeenne;
  }
  
  public void setTypeCoordinationEuropeenne(int p_typeCoordinationEuropeenne)
  {
    m_typeCoordinationEuropeenne = p_typeCoordinationEuropeenne;
  }
  
  public Quantite getSjrForce()
  {
    return m_sjrForce;
  }
  
  public void setSjrForce(Quantite p_sjrForce)
  {
    m_sjrForce = p_sjrForce;
  }
}

/* Location:
 * Qualified Name:     CriteresStrategieDelaiRecherche
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */