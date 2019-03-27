package fr.unedic.cali.dom.dossiersLourds;

import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.parcours.DomCali;
import fr.unedic.cali.parcours.DomCaliOptimise;
import fr.unedic.util.services.ContexteService;
import java.util.List;

public class DomDossiersLourdsChargerServices
  extends DomCaliOptimise
  implements DomCali
{
  private IndividuSpec m_individu;
  private List m_listeDecisions;
  private List m_listeDemandes;
  private List m_listeServices;
  private ContexteService m_contexteService;
  
  public IndividuSpec getIndividu()
  {
    return m_individu;
  }
  
  public void setIndividu(IndividuSpec p_individu)
  {
    m_individu = p_individu;
  }
  
  public List getListeDecisions()
  {
    return m_listeDecisions;
  }
  
  public void setListeDecisions(List p_listeDecisions)
  {
    m_listeDecisions = p_listeDecisions;
  }
  
  public List getListeDemandes()
  {
    return m_listeDemandes;
  }
  
  public void setListeDemandes(List p_listeDemandes)
  {
    m_listeDemandes = p_listeDemandes;
  }
  
  public List getListeServices()
  {
    return m_listeServices;
  }
  
  public void setListeServices(List p_listeServices)
  {
    m_listeServices = p_listeServices;
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
 * Qualified Name:     DomDossiersLourdsChargerServices
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */