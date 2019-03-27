package fr.unedic.cali.dom;

import fr.unedic.util.temps.Damj;

public class ConteneurConventionGestion
{
  private String m_numeroConventionGestion;
  private String m_codeAffectation;
  private String m_donneePourBouchon;
  private Damj m_dateAppel;
  
  public ConteneurConventionGestion(String p_numeroConventionGestion, String p_codeAffectation, Damj p_dateAppel, String p_donneePourBouchon)
  {
    m_numeroConventionGestion = p_numeroConventionGestion;
    m_codeAffectation = p_codeAffectation;
    m_donneePourBouchon = p_donneePourBouchon;
    m_dateAppel = p_dateAppel;
  }
  
  public String getCodeAffectation()
  {
    return m_codeAffectation;
  }
  
  public void setCodeAffectation(String p_codeAffectation)
  {
    m_codeAffectation = p_codeAffectation;
  }
  
  public Damj getDateAppel()
  {
    return m_dateAppel;
  }
  
  public void setDateAppel(Damj p_dateAppel)
  {
    m_dateAppel = p_dateAppel;
  }
  
  public String getDonneePourBouchon()
  {
    return m_donneePourBouchon;
  }
  
  public void setDonneePourBouchon(String p_donneePourBouchon)
  {
    m_donneePourBouchon = p_donneePourBouchon;
  }
  
  public String getNumeroConventionGestion()
  {
    return m_numeroConventionGestion;
  }
  
  public void setNumeroConventionGestion(String p_numeroConventionGestion)
  {
    m_numeroConventionGestion = p_numeroConventionGestion;
  }
}

/* Location:
 * Qualified Name:     ConteneurConventionGestion
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */