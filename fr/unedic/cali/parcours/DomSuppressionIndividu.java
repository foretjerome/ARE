package fr.unedic.cali.parcours;

import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.util.services.ContexteService;

public class DomSuppressionIndividu
  extends DomCaliOptimise
  implements DomCali
{
  private IndividuSpec m_individu = null;
  private ContexteService m_contexteService;
  
  public ContexteService getContexteService()
  {
    return m_contexteService;
  }
  
  public IndividuSpec getIndividu()
  {
    return m_individu;
  }
  
  public void setContexteService(ContexteService p_contexteService)
  {
    m_contexteService = p_contexteService;
  }
  
  public void setIndividu(IndividuSpec p_individu)
  {
    m_individu = p_individu;
  }
}

/* Location:
 * Qualified Name:     DomSuppressionIndividu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */