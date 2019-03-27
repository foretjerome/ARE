package fr.unedic.cali.parcours;

import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteService;

public class DomEnquetesNcpListerParIndividu
  extends DomCaliOptimise
  implements DomCali
{
  private IndividuSpec m_individu;
  private ContexteService m_contexteService;
  
  public IndividuSpec getIndividu()
  {
    return m_individu;
  }
  
  public void setIndividu(IndividuSpec p_individu)
  {
    m_individu = p_individu;
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
}

/* Location:
 * Qualified Name:     DomEnquetesNcpListerParIndividu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */