package fr.unedic.cali.parcours;

import fr.unedic.cali.autresdoms.d90.dom.spec.RedressementSpec;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.services.batch.ContexteOccasionnel;
import java.util.List;

public class DomSelectionOccasionnel
  extends ContexteOccasionnel
{
  private List m_population;
  private String m_borneInf;
  private String m_borneSup;
  private RedressementSpec m_redressement;
  private ContexteService m_contexteService;
  
  public List getPopulation()
  {
    return m_population;
  }
  
  public void setPopulation(List p_population)
  {
    m_population = p_population;
  }
  
  public String getBorneInf()
  {
    return m_borneInf;
  }
  
  public void setBorneInf(String p_borneInf)
  {
    m_borneInf = p_borneInf;
  }
  
  public String getBorneSup()
  {
    return m_borneSup;
  }
  
  public void setBorneSup(String p_borneSup)
  {
    m_borneSup = p_borneSup;
  }
  
  public ContexteService getContexteService()
  {
    return m_contexteService;
  }
  
  public void setContexteService(ContexteService p_contexteService)
  {
    m_contexteService = p_contexteService;
  }
  
  public RedressementSpec getRedressement()
  {
    return m_redressement;
  }
  
  public void setRedressement(RedressementSpec p_redressement)
  {
    m_redressement = p_redressement;
  }
}

/* Location:
 * Qualified Name:     DomSelectionOccasionnel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */