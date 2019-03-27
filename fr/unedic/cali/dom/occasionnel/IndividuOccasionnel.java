package fr.unedic.cali.dom.occasionnel;

import fr.unedic.util.temps.Damj;

public class IndividuOccasionnel
{
  private String m_cxass;
  private String m_cxala;
  private String m_commentaire;
  private String m_codeAntenne;
  private String m_rsin;
  private Damj m_dateTraitement;
  private int m_etat;
  private int m_rapportId;
  
  public int getRapportId()
  {
    return m_rapportId;
  }
  
  public void setRapportId(int p_rapportId)
  {
    m_rapportId = p_rapportId;
  }
  
  public String getCodeAntenne()
  {
    return m_codeAntenne;
  }
  
  public void setCodeAntenne(String p_codeAntenne)
  {
    m_codeAntenne = p_codeAntenne;
  }
  
  public String getCommentaire()
  {
    return m_commentaire;
  }
  
  public void setCommentaire(String p_commentaire)
  {
    m_commentaire = p_commentaire;
  }
  
  public String getCxala()
  {
    return m_cxala;
  }
  
  public void setCxala(String p_cxala)
  {
    m_cxala = p_cxala;
  }
  
  public String getCxass()
  {
    return m_cxass;
  }
  
  public void setCxass(String p_cxass)
  {
    m_cxass = p_cxass;
  }
  
  public Damj getDateTraitement()
  {
    return m_dateTraitement;
  }
  
  public void setDateTraitement(Damj p_dateTraitement)
  {
    m_dateTraitement = p_dateTraitement;
  }
  
  public int getEtat()
  {
    return m_etat;
  }
  
  public void setEtat(int p_etat)
  {
    m_etat = p_etat;
  }
  
  public String getRsin()
  {
    return m_rsin;
  }
  
  public void setRsin(String p_rsin)
  {
    m_rsin = p_rsin;
  }
}

/* Location:
 * Qualified Name:     IndividuOccasionnel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */