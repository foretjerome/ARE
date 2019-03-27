package fr.unedic.cali.parcours;

import fr.unedic.util.services.Resultat;

public class ResultatLireDonneesMigrationCalcul
  extends Resultat
{
  private int m_reliquatIndemnisation;
  private int m_cumulMoisActiviteReduite;
  private int m_cumulHeuresActiviteReduite;
  
  public ResultatLireDonneesMigrationCalcul()
  {
    m_reliquatIndemnisation = 0;
    m_cumulMoisActiviteReduite = 0;
    m_cumulHeuresActiviteReduite = 0;
  }
  
  public int getReliquatIndemnisation()
  {
    return m_reliquatIndemnisation;
  }
  
  public void setReliquatIndemnisation(int p_reliquatIndemnisation)
  {
    m_reliquatIndemnisation = p_reliquatIndemnisation;
  }
  
  public int getCumulMoisActiviteReduite()
  {
    return m_cumulMoisActiviteReduite;
  }
  
  public void setCumulMoisActiviteReduite(int p_cumulMoisActiviteReduite)
  {
    m_cumulMoisActiviteReduite = p_cumulMoisActiviteReduite;
  }
  
  public int getCumulHeuresActiviteReduite()
  {
    return m_cumulHeuresActiviteReduite;
  }
  
  public void setCumulHeuresActiviteReduite(int p_cumulHeuresActiviteReduite)
  {
    m_cumulHeuresActiviteReduite = p_cumulHeuresActiviteReduite;
  }
}

/* Location:
 * Qualified Name:     ResultatLireDonneesMigrationCalcul
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */