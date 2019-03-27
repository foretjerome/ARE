package fr.unedic.cali.dom.occasionnel;

import fr.unedic.util.services.Dom;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;
import java.util.List;

public class DomLirePopulations
  implements Dom
{
  private String m_cxass;
  private BigDecimal m_fonctRappId;
  private String m_nomChaine;
  private Damj m_datePassage;
  private boolean m_estDsi;
  private List m_listeRetour;
  private String m_libelleOccasionnel;
  private List m_listeIdRapport;
  private String m_codePopulation;
  
  public String getCxass()
  {
    return m_cxass;
  }
  
  public void setCxass(String p_cxass)
  {
    m_cxass = p_cxass;
  }
  
  public BigDecimal getFonctRappId()
  {
    return m_fonctRappId;
  }
  
  public void setFonctRappId(BigDecimal p_fonctRappId)
  {
    m_fonctRappId = p_fonctRappId;
  }
  
  public List getListeRetour()
  {
    return m_listeRetour;
  }
  
  public void setListeRetour(List p_listeRetour)
  {
    m_listeRetour = p_listeRetour;
  }
  
  public Damj getDatePassage()
  {
    return m_datePassage;
  }
  
  public void setDatePassage(Damj p_datePassage)
  {
    m_datePassage = p_datePassage;
  }
  
  public boolean isEstDsi()
  {
    return m_estDsi;
  }
  
  public void setEstDsi(boolean p_estDsi)
  {
    m_estDsi = p_estDsi;
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
  
  public List getListeIdRapport()
  {
    return m_listeIdRapport;
  }
  
  public void setListeIdRapport(List p_listeIdRapport)
  {
    m_listeIdRapport = p_listeIdRapport;
  }
  
  public String getCodePopulation()
  {
    return m_codePopulation;
  }
  
  public void setCodePopulation(String p_codePopulation)
  {
    m_codePopulation = p_codePopulation;
  }
}

/* Location:
 * Qualified Name:     DomLirePopulations
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */