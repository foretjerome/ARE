package fr.unedic.cali.dom.occasionnel;

import fr.unedic.util.services.Dom;
import fr.unedic.util.temps.Damj;
import java.util.List;

public class DomLireStatistiques
  implements Dom
{
  private String m_nomChaine;
  private Damj m_datePassage;
  private String m_poleEmploi;
  private boolean m_estRecherchePE;
  private List m_listeRetour;
  private String m_libelleOccasionnel;
  private boolean m_estRechercheParAntenne;
  
  public Damj getDatePassage()
  {
    return m_datePassage;
  }
  
  public void setDatePassage(Damj p_datePassage)
  {
    m_datePassage = p_datePassage;
  }
  
  public String getNomChaine()
  {
    return m_nomChaine;
  }
  
  public void setNomChaine(String p_nomChaine)
  {
    m_nomChaine = p_nomChaine;
  }
  
  public List getListeRetour()
  {
    return m_listeRetour;
  }
  
  public void setListeRetour(List p_listeRetour)
  {
    m_listeRetour = p_listeRetour;
  }
  
  public String getPoleEmploi()
  {
    return m_poleEmploi;
  }
  
  public void setPoleEmploi(String p_poleEmploi)
  {
    m_poleEmploi = p_poleEmploi;
  }
  
  public boolean isEstRecherchePE()
  {
    return m_estRecherchePE;
  }
  
  public void setEstRecherchePE(boolean p_estRecherchePE)
  {
    m_estRecherchePE = p_estRecherchePE;
  }
  
  public String getLibelleOccasionnel()
  {
    return m_libelleOccasionnel;
  }
  
  public void setLibelleOccasionnel(String p_libelleOccasionnel)
  {
    m_libelleOccasionnel = p_libelleOccasionnel;
  }
  
  public boolean isEstRechercheParAntenne()
  {
    return m_estRechercheParAntenne;
  }
  
  public void setEstRechercheParAntenne(boolean p_estRechercheParAntenne)
  {
    m_estRechercheParAntenne = p_estRechercheParAntenne;
  }
}

/* Location:
 * Qualified Name:     DomLireStatistiques
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */