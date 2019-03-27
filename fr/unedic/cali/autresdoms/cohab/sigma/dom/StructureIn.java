package fr.unedic.cali.autresdoms.cohab.sigma.dom;

import fr.unedic.cali.autresdoms.cohab.sigma.dom.Spec.StructureInSpec;
import fr.unedic.util.services.ContexteServiceSpec;

public abstract class StructureIn
  implements StructureInSpec
{
  private String m_identifiantIndividu;
  private String m_codeAssedic;
  private ContexteServiceSpec m_contexteService;
  
  public String getIdentifiantIndividu()
  {
    return m_identifiantIndividu;
  }
  
  public void setIdentifiantIndividu(String p_identifiantIndividu)
  {
    m_identifiantIndividu = p_identifiantIndividu;
  }
  
  public String getCodeAssedic()
  {
    return m_codeAssedic;
  }
  
  public void setCodeAssedic(String p_codeAssedic)
  {
    m_codeAssedic = p_codeAssedic;
  }
  
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
 * Qualified Name:     StructureIn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */