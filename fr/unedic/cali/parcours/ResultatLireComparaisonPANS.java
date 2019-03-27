package fr.unedic.cali.parcours;

import fr.unedic.util.services.Resultat;
import java.util.List;

public class ResultatLireComparaisonPANS
  extends Resultat
{
  private static final long serialVersionUID = 1L;
  private List m_listeAvantCalcul;
  private List m_listeApresCalcul;
  private List m_listeAvantCali;
  private List m_listeApresCali;
  private List m_listeCalcul;
  private List m_listeCali;
  
  public List getListeCalcul()
  {
    return m_listeCalcul;
  }
  
  public void setListeCalcul(List p_listeCalcul)
  {
    m_listeCalcul = p_listeCalcul;
  }
  
  public List getListeCali()
  {
    return m_listeCali;
  }
  
  public void setListeCali(List p_listeCali)
  {
    m_listeCali = p_listeCali;
  }
  
  public List getListeApresCalcul()
  {
    return m_listeApresCalcul;
  }
  
  public void setListeApresCalcul(List p_listeApresCalcul)
  {
    m_listeApresCalcul = p_listeApresCalcul;
  }
  
  public List getListeAvantCalcul()
  {
    return m_listeAvantCalcul;
  }
  
  public void setListeAvantCalcul(List p_listeAvantCalcul)
  {
    m_listeAvantCalcul = p_listeAvantCalcul;
  }
  
  public List getListeApresCali()
  {
    return m_listeApresCali;
  }
  
  public void setListeApresCali(List p_listeApresCali)
  {
    m_listeApresCali = p_listeApresCali;
  }
  
  public List getListeAvantCali()
  {
    return m_listeAvantCali;
  }
  
  public void setListeAvantCali(List p_listeAvantCali)
  {
    m_listeAvantCali = p_listeAvantCali;
  }
}

/* Location:
 * Qualified Name:     ResultatLireComparaisonPANS
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */