package fr.unedic.cali.parcours;

import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;

public class DomLirePeriodesActivites
  extends DomCaliOptimise
  implements DomCali
{
  private IndividuSpec m_individu;
  private ContexteService m_contexteService;
  private String m_idDemande;
  private Damj m_dateDebutRecherche;
  
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
  
  public String getIdDemande()
  {
    return m_idDemande;
  }
  
  public void setIdDemande(String p_idDemande)
  {
    m_idDemande = p_idDemande;
  }
  
  public Damj getDateDebutRecherche()
  {
    return m_dateDebutRecherche;
  }
  
  public void setDateDebutRecherche(Damj p_dateDebutRecherche)
  {
    m_dateDebutRecherche = p_dateDebutRecherche;
  }
}

/* Location:
 * Qualified Name:     DomLirePeriodesActivites
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */