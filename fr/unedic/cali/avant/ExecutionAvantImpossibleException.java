package fr.unedic.cali.avant;

import fr.unedic.cali.dom.AttributionSpec;

public class ExecutionAvantImpossibleException
  extends Exception
{
  AttributionSpec m_attribution = null;
  
  public ExecutionAvantImpossibleException(String p_message, AttributionSpec p_attribution)
  {
    super(p_message);
    
    m_attribution = p_attribution;
  }
  
  public ExecutionAvantImpossibleException(String p_message)
  {
    super(p_message);
  }
  
  public AttributionSpec getAttribution()
  {
    return m_attribution;
  }
  
  public void setAttribution(AttributionSpec p_attribution)
  {
    m_attribution = p_attribution;
  }
}

/* Location:
 * Qualified Name:     ExecutionAvantImpossibleException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */