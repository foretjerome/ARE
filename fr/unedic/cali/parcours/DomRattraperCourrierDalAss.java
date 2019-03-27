package fr.unedic.cali.parcours;

import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;

public class DomRattraperCourrierDalAss
  extends DomCaliOptimise
  implements DomCali
{
  private IndividuSpec m_individu;
  private Damj m_date;
  private ContexteService m_contexteService;
  
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
    return ((DomRattraperCourrierDalAss)p_contexte.getDonnees()).getContexteService();
  }
}

/* Location:
 * Qualified Name:     DomRattraperCourrierDalAss
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */