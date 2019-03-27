package fr.unedic.cali.parcours;

import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;

public class DomLireAttribution
  extends DomCaliOptimise
  implements DomCali
{
  private IndividuSpec m_individu;
  private Damj m_dateDebut;
  private Damj m_dateFin;
  private ContexteService m_contexteService;
  
  public IndividuSpec getIndividu()
  {
    return m_individu;
  }
  
  public void setIndividu(IndividuSpec p_individu)
  {
    m_individu = p_individu;
  }
  
  public Damj getDateDebut()
  {
    return m_dateDebut;
  }
  
  public Damj getDateFin()
  {
    return m_dateFin;
  }
  
  public void setDateDebut(Damj p_dateDebut)
  {
    m_dateDebut = p_dateDebut;
  }
  
  public void setDateFin(Damj p_dateFin)
  {
    m_dateFin = p_dateFin;
  }
  
  public ContexteService getContexteService()
  {
    return m_contexteService;
  }
  
  public void setContexteService(ContexteService p_contexteService)
  {
    m_contexteService = p_contexteService;
  }
}

/* Location:
 * Qualified Name:     DomLireAttribution
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */