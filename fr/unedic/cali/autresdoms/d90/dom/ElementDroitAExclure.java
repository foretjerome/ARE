package fr.unedic.cali.autresdoms.d90.dom;

public class ElementDroitAExclure
{
  private String m_libelleElementAExclure;
  private String m_libelleGamme;
  private int m_codeProduit;
  
  public ElementDroitAExclure()
  {
    m_libelleElementAExclure = null;
    m_libelleGamme = null;
    
    m_codeProduit = -1;
  }
  
  public ElementDroitAExclure(String p_libelleElementAExclure, String p_codeGamme, int p_codeProduit)
  {
    m_libelleElementAExclure = p_libelleElementAExclure;
    m_libelleGamme = p_codeGamme;
    m_codeProduit = p_codeProduit;
  }
  
  public int getCodeProduit()
  {
    return m_codeProduit;
  }
  
  public void setCodeProduit(int p_codeProduit)
  {
    m_codeProduit = p_codeProduit;
  }
  
  public String getLibelleGamme()
  {
    return m_libelleGamme;
  }
  
  public void setLibelleGamme(String p_libelleGamme)
  {
    m_libelleGamme = p_libelleGamme;
  }
  
  public String getLibelleElementAExclure()
  {
    return m_libelleElementAExclure;
  }
  
  public void setLibelleElementAExclure(String p_libelleElementAExclure)
  {
    m_libelleElementAExclure = p_libelleElementAExclure;
  }
}

/* Location:
 * Qualified Name:     ElementDroitAExclure
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */