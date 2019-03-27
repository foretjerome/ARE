package fr.unedic.cali.dom;

import fr.unedic.util.temps.Damj;

public class ElementConditionValiditeReliquat
{
  public static final int SATISFAIT = 0;
  public static final int NON_SATISFAIT = 1;
  public static final int SANS_OBJET = 2;
  private int m_etat;
  private int m_codeMotifEchec;
  private Damj m_dateDecheance = null;
  private int m_motifNonValidite;
  private int m_causeExtinction;
  
  public int getCauseExtinction()
  {
    return m_causeExtinction;
  }
  
  public void setCauseExtinction(int p_causeExtinction)
  {
    m_causeExtinction = p_causeExtinction;
  }
  
  public int getCodeMotifEchec()
  {
    return m_codeMotifEchec;
  }
  
  public void setCodeMotifEchec(int p_codeMotifEchec)
  {
    m_codeMotifEchec = p_codeMotifEchec;
  }
  
  public Damj getDateDecheance()
  {
    return m_dateDecheance;
  }
  
  public void setDateDecheance(Damj p_dateDecheance)
  {
    m_dateDecheance = p_dateDecheance;
  }
  
  public int getEtat()
  {
    return m_etat;
  }
  
  public void setEtat(int p_etat)
  {
    m_etat = p_etat;
  }
  
  public int getMotifNonValidite()
  {
    return m_motifNonValidite;
  }
  
  public void setMotifNonValidite(int p_motifNonValidite)
  {
    m_motifNonValidite = p_motifNonValidite;
  }
}

/* Location:
 * Qualified Name:     ElementConditionValiditeReliquat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */