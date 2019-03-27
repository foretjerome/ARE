package fr.unedic.cali.dom.occasionnel;

import fr.unedic.util.services.Dom;
import java.math.BigDecimal;

public class DomEcritureStat
  implements Dom
{
  private String m_codePoleEmploi;
  private BigDecimal m_rapportId;
  private String m_codePopulation;
  private boolean m_ecrireStatPE = true;
  
  public boolean isEcrireStatPE()
  {
    return m_ecrireStatPE;
  }
  
  public void setEcrireStatPE(boolean p_ecrireStatPE)
  {
    m_ecrireStatPE = p_ecrireStatPE;
  }
  
  public String getCodePopulation()
  {
    return m_codePopulation;
  }
  
  public void setCodePopulation(String p_codePopulation)
  {
    m_codePopulation = p_codePopulation;
  }
  
  public String getCodePoleEmploi()
  {
    return m_codePoleEmploi;
  }
  
  public void setCodePoleEmploi(String p_codePoleEmploi)
  {
    m_codePoleEmploi = p_codePoleEmploi;
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
 * Qualified Name:     DomEcritureStat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */