package fr.unedic.cali.dom;

import fr.unedic.util.temps.Damj;

public class BorneDemande
{
  private DemandeSpec m_demande;
  private Damj m_pji;
  private Damj m_dji;
  
  private BorneDemande() {}
  
  public BorneDemande(DemandeSpec p_demande)
  {
    m_demande = p_demande;
  }
  
  public DemandeSpec getDemande()
  {
    return m_demande;
  }
  
  public void setDemande(DemandeSpec p_demande)
  {
    m_demande = p_demande;
  }
  
  public Damj getDji()
  {
    return m_dji;
  }
  
  public void setDji(Damj p_dji)
  {
    m_dji = p_dji;
  }
  
  public Damj getPji()
  {
    return m_pji;
  }
  
  public void setPji(Damj p_pji)
  {
    m_pji = p_pji;
  }
}

/* Location:
 * Qualified Name:     BorneDemande
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */