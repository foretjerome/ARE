package fr.unedic.cali.autresdoms.d90.dom;

import fr.unedic.cali.autresdoms.d90.dom.spec.RedressementSpec;
import fr.unedic.util.temps.Damj;
import java.util.ArrayList;
import java.util.List;

public class Redressement
  implements RedressementSpec
{
  private String m_numeroPassage;
  private String m_codeAssedic;
  private String m_identifiantRapport;
  private Damj m_datePassage;
  private String m_modeRedressement;
  private String m_libelleRedressement;
  private List m_listePopulation;
  
  public Redressement()
  {
    m_listePopulation = new ArrayList();
  }
  
  public List getListePopulation()
  {
    return m_listePopulation;
  }
  
  public void setListePopulation(List p_listePopulation)
  {
    m_listePopulation = p_listePopulation;
  }
  
  public Damj getDatePassage()
  {
    return m_datePassage;
  }
  
  public void setDatePassage(Damj p_datePassage)
  {
    m_datePassage = p_datePassage;
  }
  
  public String getLibelleRedressement()
  {
    return m_libelleRedressement;
  }
  
  public void setLibelleRedressement(String p_libelleRedressement)
  {
    m_libelleRedressement = p_libelleRedressement;
  }
  
  public String getModeRedressement()
  {
    return m_modeRedressement;
  }
  
  public void setModeRedressement(String p_modeRedressement)
  {
    m_modeRedressement = p_modeRedressement;
  }
  
  public String getNumeroPassage()
  {
    return m_numeroPassage;
  }
  
  public void setNumeroPassage(String p_numeroPassage)
  {
    m_numeroPassage = p_numeroPassage;
  }
  
  public String getCodeAssedic()
  {
    return m_codeAssedic;
  }
  
  public void setCodeAssedic(String p_codeAssedic)
  {
    m_codeAssedic = p_codeAssedic;
  }
  
  public String getIdentifiantRapport()
  {
    return m_identifiantRapport;
  }
  
  public void setIdentifiantRapport(String p_identifiantRapport)
  {
    m_identifiantRapport = p_identifiantRapport;
  }
}

/* Location:
 * Qualified Name:     Redressement
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */