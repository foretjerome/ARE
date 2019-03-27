package fr.unedic.cali.parcours;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cohabitation.sigma.migration.dom.DemandeMigreeAsuV1;
import fr.unedic.util.services.ContexteService;

public class DomEnregistrerDecisionMigreeEnReexamen
  extends DomCaliOptimise
  implements DomCali
{
  private IndividuSpec m_individu = null;
  private String m_idDemande = null;
  private DemandeSpec m_demande = null;
  private DemandeMigreeAsuV1 m_demandeAEnregistrer = null;
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
  
  public DemandeMigreeAsuV1 getDemandeAEnregistrer()
  {
    return m_demandeAEnregistrer;
  }
  
  public void setDemandeAEnregistrer(DemandeMigreeAsuV1 p_demandeAEnregistrer)
  {
    m_demandeAEnregistrer = p_demandeAEnregistrer;
  }
}

/* Location:
 * Qualified Name:     DomEnregistrerDecisionMigreeEnReexamen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */