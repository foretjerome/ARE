package fr.unedic.cali.autresdoms.cohab.sigma.evtactualisation.dom;

import fr.unedic.cali.autresdoms.cohab.sigma.evtactualisation.dom.spec.DonneesEvtActuSpec;

public class DonneesEvtActu
  implements DonneesEvtActuSpec
{
  private String m_topMandatement;
  private int m_annee = 0;
  private int m_mois = 0;
  private String m_topCoherenceTravailA8A10;
  
  public DonneesEvtActu() {}
  
  public DonneesEvtActu(int p_annee, int p_mois, String p_topMandatement)
  {
    m_annee = p_annee;
    m_mois = p_mois;
    m_topMandatement = p_topMandatement;
  }
  
  public DonneesEvtActu(int p_annee, int p_mois, String p_topMandatement, String p_topCoherenceTravailA8A10)
  {
    m_annee = p_annee;
    m_mois = p_mois;
    m_topMandatement = p_topMandatement;
    m_topCoherenceTravailA8A10 = p_topCoherenceTravailA8A10;
  }
  
  public int getAnnee()
  {
    return m_annee;
  }
  
  public int getMois()
  {
    return m_mois;
  }
  
  public String getTopMandatement()
  {
    return m_topMandatement;
  }
  
  public void setTopMandatement(String p_topMandatement)
  {
    m_topMandatement = p_topMandatement;
  }
  
  public void setAnnee(int p_annee)
  {
    m_annee = p_annee;
  }
  
  public void setMois(int p_mois)
  {
    m_mois = p_mois;
  }
  
  public String getTopCoherenceTravailA8A10()
  {
    return m_topCoherenceTravailA8A10;
  }
  
  public void setTopCoherenceTravailA8A10(String p_topCoherenceTravailA8A10)
  {
    m_topCoherenceTravailA8A10 = p_topCoherenceTravailA8A10;
  }
}

/* Location:
 * Qualified Name:     DonneesEvtActu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */