package fr.unedic.cali.dom.occasionnel;

import java.math.BigDecimal;

public class DomLireStatistiquesListe
{
  private String m_poleEmploi;
  private BigDecimal m_nbDeTraites;
  private BigDecimal m_nbReexamen;
  private BigDecimal m_nbDeltamontant;
  private BigDecimal m_nbDeltaMontantNegatif;
  private BigDecimal m_sommeDeltaMontantNegatif;
  private BigDecimal m_nbDeltaMontantPositif;
  private BigDecimal m_sommeDeltaMontantPositif;
  private BigDecimal m_nbDeltaMontantPosSup500;
  private BigDecimal m_nbDeltaMontantPosEntre100Et500;
  private BigDecimal m_nbDeltaMontantPosEntre0Et100;
  private BigDecimal m_nbDeltaMontantNegEntre0Et100;
  private BigDecimal m_nbDeltaMontantNegEntre100Et500;
  private BigDecimal m_nbDeltaMontantNegInf500;
  private String m_codeAntenne;
  
  public BigDecimal getNbDeltamontant()
  {
    return m_nbDeltamontant;
  }
  
  public void setNbDeltamontant(BigDecimal p_nbDeltamontant)
  {
    m_nbDeltamontant = p_nbDeltamontant;
  }
  
  public BigDecimal getNbDeltaMontantNegatif()
  {
    return m_nbDeltaMontantNegatif;
  }
  
  public void setNbDeltaMontantNegatif(BigDecimal p_nbDeltaMontantNegatif)
  {
    m_nbDeltaMontantNegatif = p_nbDeltaMontantNegatif;
  }
  
  public BigDecimal getNbDeltaMontantPositif()
  {
    return m_nbDeltaMontantPositif;
  }
  
  public void setNbDeltaMontantPositif(BigDecimal p_nbDeltaMontantPositif)
  {
    m_nbDeltaMontantPositif = p_nbDeltaMontantPositif;
  }
  
  public BigDecimal getNbDeTraites()
  {
    return m_nbDeTraites;
  }
  
  public void setNbDeTraites(BigDecimal p_nbDeTraites)
  {
    m_nbDeTraites = p_nbDeTraites;
  }
  
  public BigDecimal getNbReexamen()
  {
    return m_nbReexamen;
  }
  
  public void setNbReexamen(BigDecimal p_nbReexamen)
  {
    m_nbReexamen = p_nbReexamen;
  }
  
  public String getPoleEmploi()
  {
    return m_poleEmploi;
  }
  
  public void setPoleEmploi(String p_poleEmploi)
  {
    m_poleEmploi = p_poleEmploi;
  }
  
  public BigDecimal getSommeDeltaMontantNegatif()
  {
    return m_sommeDeltaMontantNegatif;
  }
  
  public void setSommeDeltaMontantNegatif(BigDecimal p_sommeDeltaMontantNegatif)
  {
    m_sommeDeltaMontantNegatif = p_sommeDeltaMontantNegatif;
  }
  
  public BigDecimal getSommeDeltaMontantPositif()
  {
    return m_sommeDeltaMontantPositif;
  }
  
  public void setSommeDeltaMontantPositif(BigDecimal p_sommeDeltaMontantPositif)
  {
    m_sommeDeltaMontantPositif = p_sommeDeltaMontantPositif;
  }
  
  public BigDecimal getNbDeltaMontantNegEntre0Et100()
  {
    return m_nbDeltaMontantNegEntre0Et100;
  }
  
  public void setNbDeltaMontantNegEntre0Et100(BigDecimal p_nbDeltaMontantNegEntre0Et100)
  {
    m_nbDeltaMontantNegEntre0Et100 = p_nbDeltaMontantNegEntre0Et100;
  }
  
  public BigDecimal getNbDeltaMontantNegEntre100Et500()
  {
    return m_nbDeltaMontantNegEntre100Et500;
  }
  
  public void setNbDeltaMontantNegEntre100Et500(BigDecimal p_nbDeltaMontantNegEntre100Et500)
  {
    m_nbDeltaMontantNegEntre100Et500 = p_nbDeltaMontantNegEntre100Et500;
  }
  
  public BigDecimal getNbDeltaMontantNegInf500()
  {
    return m_nbDeltaMontantNegInf500;
  }
  
  public void setNbDeltaMontantNegInf500(BigDecimal p_nbDeltaMontantNegInf500)
  {
    m_nbDeltaMontantNegInf500 = p_nbDeltaMontantNegInf500;
  }
  
  public BigDecimal getNbDeltaMontantPosEntre0Et100()
  {
    return m_nbDeltaMontantPosEntre0Et100;
  }
  
  public void setNbDeltaMontantPosEntre0Et100(BigDecimal p_nbDeltaMontantPosEntre0Et100)
  {
    m_nbDeltaMontantPosEntre0Et100 = p_nbDeltaMontantPosEntre0Et100;
  }
  
  public BigDecimal getNbDeltaMontantPosEntre100Et500()
  {
    return m_nbDeltaMontantPosEntre100Et500;
  }
  
  public void setNbDeltaMontantPosEntre100Et500(BigDecimal p_nbDeltaMontantPosEntre100Et500)
  {
    m_nbDeltaMontantPosEntre100Et500 = p_nbDeltaMontantPosEntre100Et500;
  }
  
  public BigDecimal getNbDeltaMontantPosSup500()
  {
    return m_nbDeltaMontantPosSup500;
  }
  
  public void setNbDeltaMontantPosSup500(BigDecimal p_nbDeltaMontantPosSup500)
  {
    m_nbDeltaMontantPosSup500 = p_nbDeltaMontantPosSup500;
  }
  
  public String getCodeAntenne()
  {
    return m_codeAntenne;
  }
  
  public void setCodeAntenne(String p_codeAntenne)
  {
    m_codeAntenne = p_codeAntenne;
  }
}

/* Location:
 * Qualified Name:     DomLireStatistiquesListe
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */