package fr.unedic.cali.parcours;

import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;

public class DomCreerDemande
  extends DomLiquidationDemande
{
  private ContexteService m_contexteService;
  private IndividuSpec m_individu;
  private Damj m_dateDepot;
  private String m_typeDemande;
  
  public ContexteService getContexteService()
  {
    return m_contexteService;
  }
  
  public IndividuSpec getIndividu()
  {
    return m_individu;
  }
  
  public void setContexteService(ContexteService p_contexteService)
  {
    m_contexteService = p_contexteService;
  }
  
  public void setIndividu(IndividuSpec p_individu)
  {
    m_individu = p_individu;
  }
  
  public Damj getDateDepot()
  {
    return m_dateDepot;
  }
  
  public void setDateDepot(Damj p_dateDepot)
  {
    m_dateDepot = p_dateDepot;
  }
  
  public String getTypeDemande()
  {
    return m_typeDemande;
  }
  
  public void setTypeDemande(String p_typeDemande)
  {
    m_typeDemande = p_typeDemande;
  }
}

/* Location:
 * Qualified Name:     DomCreerDemande
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */