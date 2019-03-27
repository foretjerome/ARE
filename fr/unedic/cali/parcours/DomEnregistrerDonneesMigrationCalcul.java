package fr.unedic.cali.parcours;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.util.services.ContexteService;

public class DomEnregistrerDonneesMigrationCalcul
  extends DomCaliOptimise
  implements DomCali
{
  private IndividuSpec m_individu;
  private String m_idDemande;
  private DemandeSpec m_demande;
  private ContexteService m_contexteService;
  private int m_reliquatIndemnisation;
  private int m_cumulMoisActiviteReduite;
  private int m_cumulHeuresActiviteReduite;
  
  public DomEnregistrerDonneesMigrationCalcul()
  {
    m_individu = null;
    m_idDemande = null;
    m_demande = null;
    m_contexteService = null;
    m_reliquatIndemnisation = 0;
    m_cumulMoisActiviteReduite = 0;
    m_cumulHeuresActiviteReduite = 0;
  }
  
  public ContexteService getContexteService()
  {
    return m_contexteService;
  }
  
  public void setContexteService(ContexteService p_contexteService)
  {
    m_contexteService = p_contexteService;
  }
  
  public IndividuSpec getIndividu()
  {
    return m_individu;
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
  
  public int getCumulHeuresActiviteReduite()
  {
    return m_cumulHeuresActiviteReduite;
  }
  
  public void setCumulHeuresActiviteReduite(int p_cumulHeuresActiviteReduite)
  {
    m_cumulHeuresActiviteReduite = p_cumulHeuresActiviteReduite;
  }
  
  public int getCumulMoisActiviteReduite()
  {
    return m_cumulMoisActiviteReduite;
  }
  
  public void setCumulMoisActiviteReduite(int p_cumulMoisActiviteReduite)
  {
    m_cumulMoisActiviteReduite = p_cumulMoisActiviteReduite;
  }
  
  public int getReliquatIndemnisation()
  {
    return m_reliquatIndemnisation;
  }
  
  public void setReliquatIndemnisation(int p_reliquatIndemnisation)
  {
    m_reliquatIndemnisation = p_reliquatIndemnisation;
  }
}

/* Location:
 * Qualified Name:     DomEnregistrerDonneesMigrationCalcul
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */