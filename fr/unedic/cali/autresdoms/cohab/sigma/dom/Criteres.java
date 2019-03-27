package fr.unedic.cali.autresdoms.cohab.sigma.dom;

import fr.unedic.cali.autresdoms.cohab.sigma.dom.Spec.CriteresSpec;
import fr.unedic.util.services.ContexteServiceSpec;

public class Criteres
  implements CriteresSpec
{
  private ContexteServiceSpec m_contexteService;
  
  public void setContexteService(ContexteServiceSpec p_contexteService)
  {
    m_contexteService = p_contexteService;
  }
  
  public ContexteServiceSpec getContexteService()
  {
    return m_contexteService;
  }
}

/* Location:
 * Qualified Name:     Criteres
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */