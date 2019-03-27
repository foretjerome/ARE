package fr.unedic.cali.dom.occasionnel;

import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;
import java.util.List;

public class DomLireIndividusListe
{
  private String m_cxass;
  private BigDecimal m_fonctRappId;
  private String m_codePopulation;
  private BigDecimal m_cxalaf;
  private String m_rsin;
  private String m_modeCreation;
  private BigDecimal m_deltaMtIndemnise;
  private BigDecimal m_deltaMtFinancement;
  private BigDecimal m_deltaMtCadt;
  private BigDecimal m_deltaMtCrc;
  private BigDecimal m_nbDemandes;
  private String m_antenne;
  private Damj m_dateReexamen;
  private List m_listeDemandes;
  private Damj m_datePassage;
  private String m_commentaire;
  private int m_etat;
  
  public String getCodePopulation()
  {
    return m_codePopulation;
  }
  
  public void setCodePopulation(String p_codePopulation)
  {
    m_codePopulation = p_codePopulation;
  }
  
  public BigDecimal getCxalaf()
  {
    return m_cxalaf;
  }
  
  public void setCxalaf(BigDecimal p_cxalaf)
  {
    m_cxalaf = p_cxalaf;
  }
  
  public String getCxass()
  {
    return m_cxass;
  }
  
  public void setCxass(String p_cxass)
  {
    m_cxass = p_cxass;
  }
  
  public BigDecimal getDeltaMtIndemnise()
  {
    return m_deltaMtIndemnise;
  }
  
  public void setDeltaMtIndemnise(BigDecimal p_deltaMtIndemnise)
  {
    m_deltaMtIndemnise = p_deltaMtIndemnise;
  }
  
  public BigDecimal getDeltaMtFinancement()
  {
    return m_deltaMtFinancement;
  }
  
  public void setDeltaMtFinancement(BigDecimal p_deltaMtFinancement)
  {
    m_deltaMtFinancement = p_deltaMtFinancement;
  }
  
  public BigDecimal getDeltaMtCadt()
  {
    return m_deltaMtCadt;
  }
  
  public void setDeltaMtCadt(BigDecimal p_deltaMtCadt)
  {
    m_deltaMtCadt = p_deltaMtCadt;
  }
  
  public BigDecimal getDeltaMtCrc()
  {
    return m_deltaMtCrc;
  }
  
  public void setDeltaMtCrc(BigDecimal p_deltaMtCrc)
  {
    m_deltaMtCrc = p_deltaMtCrc;
  }
  
  public BigDecimal getFonctRappId()
  {
    return m_fonctRappId;
  }
  
  public void setFonctRappId(BigDecimal p_fonctRappId)
  {
    m_fonctRappId = p_fonctRappId;
  }
  
  public List getListeDemandes()
  {
    return m_listeDemandes;
  }
  
  public void setListeDemandes(List p_listeDemandes)
  {
    m_listeDemandes = p_listeDemandes;
  }
  
  public String getModeCreation()
  {
    return m_modeCreation;
  }
  
  public void setModeCreation(String p_modeCreation)
  {
    m_modeCreation = p_modeCreation;
  }
  
  public String getRsin()
  {
    return m_rsin;
  }
  
  public void setRsin(String p_rsin)
  {
    m_rsin = p_rsin;
  }
  
  public BigDecimal getNbDemandes()
  {
    return m_nbDemandes;
  }
  
  public void setNbDemandes(BigDecimal p_nbDemandes)
  {
    m_nbDemandes = p_nbDemandes;
  }
  
  public Damj getDateReexamen()
  {
    return m_dateReexamen;
  }
  
  public void setDateReexamen(Damj p_dateReexamen)
  {
    m_dateReexamen = p_dateReexamen;
  }
  
  public String getAntenne()
  {
    return m_antenne;
  }
  
  public void setAntenne(String p_antenne)
  {
    m_antenne = p_antenne;
  }
  
  public Damj getDatePassage()
  {
    return m_datePassage;
  }
  
  public void setDatePassage(Damj p_datePassage)
  {
    m_datePassage = p_datePassage;
  }
  
  public String getCommentaire()
  {
    return m_commentaire;
  }
  
  public void setCommentaire(String p_commentaire)
  {
    m_commentaire = p_commentaire;
  }
  
  public int getEtat()
  {
    return m_etat;
  }
  
  public void setEtat(int p_etat)
  {
    m_etat = p_etat;
  }
}

/* Location:
 * Qualified Name:     DomLireIndividusListe
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */