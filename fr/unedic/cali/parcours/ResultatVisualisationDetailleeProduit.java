package fr.unedic.cali.parcours;

import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.util.temps.Damj;

public class ResultatVisualisationDetailleeProduit
{
  private AttributionSpec m_attribution = null;
  private Damj m_pjiAvant;
  private Damj m_pjiApres;
  private Damj m_djiAvant;
  private Damj m_djiApres;
  
  public final void setAttribution(AttributionSpec p_attribution)
  {
    m_attribution = p_attribution;
  }
  
  public final AttributionSpec getAttribution()
  {
    return m_attribution;
  }
  
  public Damj getPjiAvant()
  {
    return m_pjiAvant;
  }
  
  public void setPjiAvant(Damj p_pjiAvant)
  {
    m_pjiAvant = p_pjiAvant;
  }
  
  public Damj getPjiApres()
  {
    return m_pjiApres;
  }
  
  public void setPjiApres(Damj p_pjiApres)
  {
    m_pjiApres = p_pjiApres;
  }
  
  public Damj getDjiAvant()
  {
    return m_djiAvant;
  }
  
  public void setDjiAvant(Damj p_djiAvant)
  {
    m_djiAvant = p_djiAvant;
  }
  
  public Damj getDjiApres()
  {
    return m_djiApres;
  }
  
  public void setDjiApres(Damj p_djiApres)
  {
    m_djiApres = p_djiApres;
  }
}

/* Location:
 * Qualified Name:     ResultatVisualisationDetailleeProduit
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */