package fr.unedic.cali.dom.occasionnel;

import fr.unedic.util.services.Dom;
import java.math.BigDecimal;

public class DomStatsAntenne
  implements Dom
{
  private String m_codePoleEmploi;
  private BigDecimal m_idRapport;
  private String m_codeAntenne;
  private String m_codePopulation;
  private BigDecimal m_nbDeltaMtNeg;
  private BigDecimal m_nbDeltaMtPos;
  private BigDecimal m_nbDeReexamen;
  private BigDecimal m_nbDeReexecute;
  private BigDecimal m_nbDeTraite;
  private BigDecimal m_nbDeltaMontantTranche1;
  private BigDecimal m_nbDeltaMontantTranche2;
  private BigDecimal m_nbDeltaMontantTranche3;
  private BigDecimal m_nbDeltaMontantTranche4;
  private BigDecimal m_nbDeltaMontantTranche5;
  private BigDecimal m_nbDeltaMontantTranche6;
  private BigDecimal m_nbDeltaMontantTranche7;
  private BigDecimal m_nbDeltaMontantTranche8;
  private BigDecimal m_sommeDeltaMtNeg;
  private BigDecimal m_sommeDeltaMtPos;
  
  public String getCodeAntenne()
  {
    return m_codeAntenne;
  }
  
  public void setCodeAntenne(String p_codeAntenne)
  {
    m_codeAntenne = p_codeAntenne;
  }
  
  public String getCodePoleEmploi()
  {
    return m_codePoleEmploi;
  }
  
  public void setCodePoleEmploi(String p_codePoleEmploi)
  {
    m_codePoleEmploi = p_codePoleEmploi;
  }
  
  public String getCodePopulation()
  {
    return m_codePopulation;
  }
  
  public void setCodePopulation(String p_codePopulation)
  {
    m_codePopulation = p_codePopulation;
  }
  
  public BigDecimal getIdRapport()
  {
    return m_idRapport;
  }
  
  public void setIdRapport(BigDecimal p_idRapport)
  {
    m_idRapport = p_idRapport;
  }
  
  public BigDecimal getNbDeltaMontantTranche1()
  {
    return m_nbDeltaMontantTranche1;
  }
  
  public void setNbDeltaMontantTranche1(BigDecimal p_nbDeltaMontantTranche1)
  {
    m_nbDeltaMontantTranche1 = p_nbDeltaMontantTranche1;
  }
  
  public BigDecimal getNbDeltaMontantTranche2()
  {
    return m_nbDeltaMontantTranche2;
  }
  
  public void setNbDeltaMontantTranche2(BigDecimal p_nbDeltaMontantTranche2)
  {
    m_nbDeltaMontantTranche2 = p_nbDeltaMontantTranche2;
  }
  
  public BigDecimal getNbDeltaMontantTranche3()
  {
    return m_nbDeltaMontantTranche3;
  }
  
  public void setNbDeltaMontantTranche3(BigDecimal p_nbDeltaMontantTranche3)
  {
    m_nbDeltaMontantTranche3 = p_nbDeltaMontantTranche3;
  }
  
  public BigDecimal getNbDeltaMontantTranche4()
  {
    return m_nbDeltaMontantTranche4;
  }
  
  public void setNbDeltaMontantTranche4(BigDecimal p_nbDeltaMontantTranche4)
  {
    m_nbDeltaMontantTranche4 = p_nbDeltaMontantTranche4;
  }
  
  public BigDecimal getNbDeltaMontantTranche5()
  {
    return m_nbDeltaMontantTranche5;
  }
  
  public void setNbDeltaMontantTranche5(BigDecimal p_nbDeltaMontantTranche5)
  {
    m_nbDeltaMontantTranche5 = p_nbDeltaMontantTranche5;
  }
  
  public BigDecimal getNbDeltaMontantTranche6()
  {
    return m_nbDeltaMontantTranche6;
  }
  
  public void setNbDeltaMontantTranche6(BigDecimal p_nbDeltaMontantTranche6)
  {
    m_nbDeltaMontantTranche6 = p_nbDeltaMontantTranche6;
  }
  
  public BigDecimal getNbDeltaMontantTranche7()
  {
    return m_nbDeltaMontantTranche7;
  }
  
  public void setNbDeltaMontantTranche7(BigDecimal p_nbDeltaMontantTranche7)
  {
    m_nbDeltaMontantTranche7 = p_nbDeltaMontantTranche7;
  }
  
  public BigDecimal getNbDeltaMontantTranche8()
  {
    return m_nbDeltaMontantTranche8;
  }
  
  public void setNbDeltaMontantTranche8(BigDecimal p_nbDeltaMontantTranche8)
  {
    m_nbDeltaMontantTranche8 = p_nbDeltaMontantTranche8;
  }
  
  public BigDecimal getNbDeltaMtNeg()
  {
    return m_nbDeltaMtNeg;
  }
  
  public void setNbDeltaMtNeg(BigDecimal p_nbDeltaMtNeg)
  {
    m_nbDeltaMtNeg = p_nbDeltaMtNeg;
  }
  
  public BigDecimal getNbDeltaMtPos()
  {
    return m_nbDeltaMtPos;
  }
  
  public void setNbDeltaMtPos(BigDecimal p_nbDeltaMtPos)
  {
    m_nbDeltaMtPos = p_nbDeltaMtPos;
  }
  
  public BigDecimal getNbDeReexamen()
  {
    return m_nbDeReexamen;
  }
  
  public void setNbDeReexamen(BigDecimal p_nbDeReexamen)
  {
    m_nbDeReexamen = p_nbDeReexamen;
  }
  
  public BigDecimal getNbDeReexecute()
  {
    return m_nbDeReexecute;
  }
  
  public void setNbDeReexecute(BigDecimal p_nbDeReexecute)
  {
    m_nbDeReexecute = p_nbDeReexecute;
  }
  
  public BigDecimal getNbDeTraite()
  {
    return m_nbDeTraite;
  }
  
  public void setNbDeTraite(BigDecimal p_nbDeTraite)
  {
    m_nbDeTraite = p_nbDeTraite;
  }
  
  public BigDecimal getSommeDeltaMtNeg()
  {
    return m_sommeDeltaMtNeg;
  }
  
  public void setSommeDeltaMtNeg(BigDecimal p_sommeDeltaMtNeg)
  {
    m_sommeDeltaMtNeg = p_sommeDeltaMtNeg;
  }
  
  public BigDecimal getSommeDeltaMtPos()
  {
    return m_sommeDeltaMtPos;
  }
  
  public void setSommeDeltaMtPos(BigDecimal p_sommeDeltaMtPos)
  {
    m_sommeDeltaMtPos = p_sommeDeltaMtPos;
  }
}

/* Location:
 * Qualified Name:     DomStatsAntenne
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */