package fr.unedic.cali.parcours;

import fr.unedic.cali.autresdoms.d90.dom.spec.RedressementSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;

public class DomReexecutionCali
  extends DomCaliOptimise
  implements DomCali
{
  private IndividuSpec m_individu;
  private Damj m_date;
  private ContexteService m_contexteService;
  private RedressementSpec m_redressement;
  private boolean m_estExecutionSimulation = false;
  private boolean m_restitutionVisu = false;
  
  public RedressementSpec getRedressement()
  {
    return m_redressement;
  }
  
  public void setRedressement(RedressementSpec p_redressement)
  {
    m_redressement = p_redressement;
  }
  
  public IndividuSpec getIndividu()
  {
    return m_individu;
  }
  
  public void setIndividu(IndividuSpec p_individu)
  {
    m_individu = p_individu;
  }
  
  public void setDate(Damj p_date)
  {
    m_date = p_date;
  }
  
  public Damj getDate()
  {
    return m_date;
  }
  
  public ContexteService getContexteService()
  {
    return m_contexteService;
  }
  
  public void setContexteService(ContexteService p_contexteService)
  {
    m_contexteService = p_contexteService;
  }
  
  public static ContexteService getContexteService(Contexte p_contexte)
  {
    return ((DomReexecutionCali)p_contexte.getDonnees()).getContexteService();
  }
  
  public boolean isEstExecutionSimulation()
  {
    return m_estExecutionSimulation;
  }
  
  public void setEstExecutionSimulation(boolean p_estExecutionSimulation)
  {
    m_estExecutionSimulation = p_estExecutionSimulation;
  }
  
  public boolean isRestitutionVisu()
  {
    return m_restitutionVisu;
  }
  
  public void setRestitutionVisu(boolean p_restitutionVisu)
  {
    m_restitutionVisu = p_restitutionVisu;
  }
}

/* Location:
 * Qualified Name:     DomReexecutionCali
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */