package fr.unedic.cali.autresdoms.d90.dom;

import fr.unedic.cali.autresdoms.d90.dom.spec.RedressementSpec;
import fr.unedic.util.services.Dom;
import java.math.BigDecimal;

public class DomFinaliserRapportOccasionnel
  implements Dom
{
  private String m_nomOccasionnel;
  private String m_nomChaine;
  private String m_modeOccasionnel;
  private String m_modeRedressement;
  private String m_identifiantRedressement;
  private String m_codeAssedic;
  private BigDecimal m_numeroPassage;
  private RedressementSpec m_redressement;
  
  public RedressementSpec getRedressement()
  {
    return m_redressement;
  }
  
  public void setRedressement(RedressementSpec p_redressement)
  {
    m_redressement = p_redressement;
  }
  
  public String getCodeAssedic()
  {
    return m_codeAssedic;
  }
  
  public void setCodeAssedic(String p_codeAssedic)
  {
    m_codeAssedic = p_codeAssedic;
  }
  
  public String getIdentifiantRedressement()
  {
    return m_identifiantRedressement;
  }
  
  public void setIdentifiantRedressement(String p_identifiantRedressement)
  {
    m_identifiantRedressement = p_identifiantRedressement;
  }
  
  public String getModeOccasionnel()
  {
    return m_modeOccasionnel;
  }
  
  public void setModeOccasionnel(String p_modeOccasionnel)
  {
    m_modeOccasionnel = p_modeOccasionnel;
  }
  
  public String getNomChaine()
  {
    return m_nomChaine;
  }
  
  public void setNomChaine(String p_nomChaine)
  {
    m_nomChaine = p_nomChaine;
  }
  
  public String getNomOccasionnel()
  {
    return m_nomOccasionnel;
  }
  
  public void setNomOccasionnel(String p_nomOccasionnel)
  {
    m_nomOccasionnel = p_nomOccasionnel;
  }
  
  public BigDecimal getNumeroPassage()
  {
    return m_numeroPassage;
  }
  
  public void setNumeroPassage(BigDecimal p_numeroPassage)
  {
    m_numeroPassage = p_numeroPassage;
  }
  
  public String getModeRedressement()
  {
    return m_modeRedressement;
  }
  
  public void setModeRedressement(String p_modeRedressement)
  {
    m_modeRedressement = p_modeRedressement;
  }
}

/* Location:
 * Qualified Name:     DomFinaliserRapportOccasionnel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */