package fr.unedic.cali.dom.occasionnel;

import fr.unedic.util.services.Dom;
import fr.unedic.util.temps.Damj;
import java.util.List;

public class DomLireMotifsReexamen
  implements Dom
{
  private String m_nomChaine;
  private Damj m_datePassage;
  private List m_listeRetour;
  private List m_listeIdRapport;
  private String m_codePopulation;
  
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
  
  public String getCodePopulation()
  {
    return m_codePopulation;
  }
  
  public void setCodePopulation(String p_codePopulation)
  {
    m_codePopulation = p_codePopulation;
  }
  
  public List getListeIdRapport()
  {
    return m_listeIdRapport;
  }
  
  public void setListeIdRapport(List p_listeIdRapport)
  {
    m_listeIdRapport = p_listeIdRapport;
  }
}

/* Location:
 * Qualified Name:     DomLireMotifsReexamen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */