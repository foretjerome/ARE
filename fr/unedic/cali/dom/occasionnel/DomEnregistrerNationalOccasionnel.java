package fr.unedic.cali.dom.occasionnel;

import fr.unedic.util.services.ContexteService;
import fr.unedic.util.services.Dom;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;

public class DomEnregistrerNationalOccasionnel
  implements Dom
{
  private String m_cxass;
  private String m_codePopulation;
  private BigDecimal m_cxala;
  private BigDecimal m_rapportId;
  private String m_consigne1;
  private String m_consigne2;
  private String m_consigne3;
  private Damj m_dateTraitement;
  private ContexteService m_contexteService;
  
  public String getCodePopulation()
  {
    return m_codePopulation;
  }
  
  public void setCodePopulation(String p_codePopulation)
  {
    m_codePopulation = p_codePopulation;
  }
  
  public String getConsigne1()
  {
    return m_consigne1;
  }
  
  public void setConsigne1(String p_consigne1)
  {
    m_consigne1 = p_consigne1;
  }
  
  public String getConsigne2()
  {
    return m_consigne2;
  }
  
  public void setConsigne2(String p_consigne2)
  {
    m_consigne2 = p_consigne2;
  }
  
  public String getConsigne3()
  {
    return m_consigne3;
  }
  
  public void setConsigne3(String p_consigne3)
  {
    m_consigne3 = p_consigne3;
  }
  
  public ContexteService getContexteService()
  {
    return m_contexteService;
  }
  
  public void setContexteService(ContexteService p_contexteService)
  {
    m_contexteService = p_contexteService;
  }
  
  public BigDecimal getCxala()
  {
    return m_cxala;
  }
  
  public void setCxala(BigDecimal p_cxala)
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
  
  public Damj getDateTraitement()
  {
    return m_dateTraitement;
  }
  
  public void setDateTraitement(Damj p_dateTraitement)
  {
    m_dateTraitement = p_dateTraitement;
  }
  
  public BigDecimal getRapportId()
  {
    return m_rapportId;
  }
  
  public void setRapportId(BigDecimal p_rapportId)
  {
    m_rapportId = p_rapportId;
  }
}

/* Location:
 * Qualified Name:     DomEnregistrerNationalOccasionnel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */