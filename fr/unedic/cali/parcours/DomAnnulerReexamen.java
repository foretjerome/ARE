package fr.unedic.cali.parcours;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.util.services.ContexteService;

public class DomAnnulerReexamen
  extends DomCaliOptimise
  implements DomCali
{
  private IndividuSpec m_individu = null;
  private String m_idDemande = null;
  private DemandeSpec m_demande = null;
  private ContexteService m_contexteService;
  
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
  
  public DemandeSpec getDemande()
  {
    return m_demande;
  }
  
  public void setDemande(DemandeSpec p_demande)
  {
    m_demande = p_demande;
  }
  
  public String getIdDemande()
  {
    return m_idDemande;
  }
  
  public void setIdDemande(String p_idDemande)
  {
    m_idDemande = p_idDemande;
  }
}

/* Location:
 * Qualified Name:     DomAnnulerReexamen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */