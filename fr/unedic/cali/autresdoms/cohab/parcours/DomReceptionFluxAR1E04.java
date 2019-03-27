package fr.unedic.cali.autresdoms.cohab.parcours;

import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteService;

public class DomReceptionFluxAR1E04
  extends DomReceptionFluxV1
{
  private ContexteService m_contexteService;
  
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
    return ((DomReceptionFluxAR1E04)p_contexte.getDonnees()).getContexteService();
  }
}

/* Location:
 * Qualified Name:     DomReceptionFluxAR1E04
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */