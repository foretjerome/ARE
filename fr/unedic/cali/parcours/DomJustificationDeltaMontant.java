package fr.unedic.cali.parcours;

import fr.unedic.util.services.Dom;
import java.math.BigDecimal;

public class DomJustificationDeltaMontant
  implements Dom
{
  private String m_cxass;
  private BigDecimal m_cxalaf;
  private BigDecimal m_fonctRappId;
  private String m_codePopulation;
  
  public String getCxass()
  {
    return m_cxass;
  }
  
  public void setCxass(String p_cxass)
  {
    m_cxass = p_cxass;
  }
  
  public BigDecimal getCxalaf()
  {
    return m_cxalaf;
  }
  
  public void setCxalaf(BigDecimal p_cxalaf)
  {
    m_cxalaf = p_cxalaf;
  }
  
  public BigDecimal getFonctRappId()
  {
    return m_fonctRappId;
  }
  
  public void setFonctRappId(BigDecimal p_fonctRappId)
  {
    m_fonctRappId = p_fonctRappId;
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
 * Qualified Name:     DomJustificationDeltaMontant
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */