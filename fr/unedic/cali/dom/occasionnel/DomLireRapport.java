package fr.unedic.cali.dom.occasionnel;

import fr.unedic.util.services.Dom;
import java.util.List;

public class DomLireRapport
  implements Dom
{
  private String m_cxass;
  private String m_rsin;
  private String m_cxala;
  private String m_antenne;
  private List m_listeRetour;
  private boolean m_chargementReduit;
  private boolean m_estSimulationChangement;
  
  public String getCxass()
  {
    return m_cxass;
  }
  
  public void setCxass(String p_cxass)
  {
    m_cxass = p_cxass;
  }
  
  public List getListeRetour()
  {
    return m_listeRetour;
  }
  
  public void setListeRetour(List p_listeRetour)
  {
    m_listeRetour = p_listeRetour;
  }
  
  public String getRsin()
  {
    return m_rsin;
  }
  
  public void setRsin(String p_rsin)
  {
    m_rsin = p_rsin;
  }
  
  public String getAntenne()
  {
    return m_antenne;
  }
  
  public void setAntenne(String p_antenne)
  {
    m_antenne = p_antenne;
  }
  
  public String getCxala()
  {
    return m_cxala;
  }
  
  public void setCxala(String p_cxala)
  {
    m_cxala = p_cxala;
  }
  
  public boolean isChargementReduit()
  {
    return m_chargementReduit;
  }
  
  public void setChargementReduit(boolean p_chargementReduit)
  {
    m_chargementReduit = p_chargementReduit;
  }
  
  public boolean isEstSimulationChangement()
  {
    return m_estSimulationChangement;
  }
  
  public void setEstSimulationChangement(boolean p_estSimulationChangement)
  {
    m_estSimulationChangement = p_estSimulationChangement;
  }
}

/* Location:
 * Qualified Name:     DomLireRapport
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */