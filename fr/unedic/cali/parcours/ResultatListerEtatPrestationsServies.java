package fr.unedic.cali.parcours;

import java.util.Map;

public class ResultatListerEtatPrestationsServies
  extends ResultatReexecutionCali
{
  private static final long serialVersionUID = 1L;
  private String m_rsin;
  private String m_cxala;
  private String m_cxass;
  private String m_codeErreur;
  private Map m_mapEtatPrestationsServies;
  private boolean m_contexteOccasionnel;
  
  public String getCodeErreur()
  {
    return m_codeErreur;
  }
  
  public void setCodeErreur(String p_codeErreur)
  {
    m_codeErreur = p_codeErreur;
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
  
  public Map getMapEtatPrestationsServies()
  {
    return m_mapEtatPrestationsServies;
  }
  
  public void setMapEtatPrestationsServies(Map p_mapEtatPrestationsServies)
  {
    m_mapEtatPrestationsServies = p_mapEtatPrestationsServies;
  }
  
  public String getRsin()
  {
    return m_rsin;
  }
  
  public void setRsin(String p_rsin)
  {
    m_rsin = p_rsin;
  }
  
  public boolean isContexteOccasionnel()
  {
    return m_contexteOccasionnel;
  }
  
  public void setContexteOccasionnel(boolean p_contexteOccasionnel)
  {
    m_contexteOccasionnel = p_contexteOccasionnel;
  }
}

/* Location:
 * Qualified Name:     ResultatListerEtatPrestationsServies
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */