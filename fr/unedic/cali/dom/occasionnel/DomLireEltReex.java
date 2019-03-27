package fr.unedic.cali.dom.occasionnel;

import fr.unedic.util.services.Dom;
import fr.unedic.util.temps.Damj;
import java.util.List;

public class DomLireEltReex
  implements Dom
{
  private String m_cxass;
  private String m_nomChaine;
  private Damj m_datePassage;
  private List m_listeEltExclu;
  private String m_libelleOccasionnel;
  private List m_listeIdRapport;
  private String m_codePopulation;
  private String m_libElement;
  
  public String getCxass()
  {
    return m_cxass;
  }
  
  public void setCxass(String p_cxass)
  {
    m_cxass = p_cxass;
  }
  
  public List getListeEltExclu()
  {
    return m_listeEltExclu;
  }
  
  public void setListeEltExclu(List p_listeEltExclu)
  {
    m_listeEltExclu = p_listeEltExclu;
  }
  
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
  
  public String getLibelleOccasionnel()
  {
    return m_libelleOccasionnel;
  }
  
  public void setLibelleOccasionnel(String p_libelleOccasionnel)
  {
    m_libelleOccasionnel = p_libelleOccasionnel;
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
  
  public String getLibElement()
  {
    return m_libElement;
  }
  
  public void setLibElement(String p_libElement)
  {
    m_libElement = p_libElement;
  }
}

/* Location:
 * Qualified Name:     DomLireEltReex
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */