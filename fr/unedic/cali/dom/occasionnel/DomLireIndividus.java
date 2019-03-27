package fr.unedic.cali.dom.occasionnel;

import fr.unedic.util.services.Dom;
import java.math.BigDecimal;
import java.util.List;

public class DomLireIndividus
  implements Dom
{
  private String m_cxass;
  private BigDecimal m_fonctRappId;
  private String m_codePopulation;
  private String m_rsin;
  private BigDecimal m_demandeId;
  private boolean m_recupDemandes;
  private boolean m_recupEltComp;
  private BigDecimal m_indexDebutListeIndividus;
  private BigDecimal m_nbIndividusRecuperes;
  private boolean m_estFiltreDeReexamen;
  private boolean m_estFiltreDeDeltaMontantIndemnise;
  private boolean m_estFiltreDeDeltaMontantFinancement;
  private boolean m_estFiltreDeDeltaMontantCadt;
  private boolean m_estFiltreDeDeltaMontantCrc;
  private String m_antenne;
  private List m_listeIndividus;
  private BigDecimal m_nbIndividusTotalSelectionnes;
  private String m_champATrier;
  private String m_sensTri;
  private List m_listeIDRapport;
  
  public List getListeIDRapport()
  {
    return m_listeIDRapport;
  }
  
  public void setListeIDRapport(List p_listeIDRapport)
  {
    m_listeIDRapport = p_listeIDRapport;
  }
  
  public String getCodePopulation()
  {
    return m_codePopulation;
  }
  
  public void setCodePopulation(String p_codePopulation)
  {
    m_codePopulation = p_codePopulation;
  }
  
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
  
  public List getListeIndividus()
  {
    return m_listeIndividus;
  }
  
  public void setListeIndividus(List p_listeIndividus)
  {
    m_listeIndividus = p_listeIndividus;
  }
  
  public String getRsin()
  {
    return m_rsin;
  }
  
  public void setRsin(String p_rsin)
  {
    m_rsin = p_rsin;
  }
  
  public BigDecimal getDemandeId()
  {
    return m_demandeId;
  }
  
  public void setDemandeId(BigDecimal p_demandeId)
  {
    m_demandeId = p_demandeId;
  }
  
  public boolean isRecupDemandes()
  {
    return m_recupDemandes;
  }
  
  public void setRecupDemandes(boolean p_recupDemandes)
  {
    m_recupDemandes = p_recupDemandes;
  }
  
  public boolean isRecupEltComp()
  {
    return m_recupEltComp;
  }
  
  public void setRecupEltComp(boolean p_recupEltComp)
  {
    m_recupEltComp = p_recupEltComp;
  }
  
  public BigDecimal getIndexDebutListeIndividus()
  {
    return m_indexDebutListeIndividus;
  }
  
  public void setIndexDebutListeIndividus(BigDecimal p_indexDebutListeIndividus)
  {
    m_indexDebutListeIndividus = p_indexDebutListeIndividus;
  }
  
  public BigDecimal getNbIndividusRecuperes()
  {
    return m_nbIndividusRecuperes;
  }
  
  public void setNbIndividusRecuperes(BigDecimal p_nbIndividusRecuperes)
  {
    m_nbIndividusRecuperes = p_nbIndividusRecuperes;
  }
  
  public boolean isEstFiltreDeDeltaMontantIndemnise()
  {
    return m_estFiltreDeDeltaMontantIndemnise;
  }
  
  public void setEstFiltreDeDeltaMontantIndemnise(boolean p_estFiltreDeDeltaMontantIndemnise)
  {
    m_estFiltreDeDeltaMontantIndemnise = p_estFiltreDeDeltaMontantIndemnise;
  }
  
  public boolean isEstFiltreDeDeltaMontantFinancement()
  {
    return m_estFiltreDeDeltaMontantFinancement;
  }
  
  public void setEstFiltreDeDeltaMontantFinancement(boolean p_estFiltreDeDeltaMontantFinancement)
  {
    m_estFiltreDeDeltaMontantFinancement = p_estFiltreDeDeltaMontantFinancement;
  }
  
  public boolean isEstFiltreDeDeltaMontantCadt()
  {
    return m_estFiltreDeDeltaMontantCadt;
  }
  
  public void setEstFiltreDeDeltaMontantCadt(boolean p_estFiltreDeDeltaMontantCadt)
  {
    m_estFiltreDeDeltaMontantCadt = p_estFiltreDeDeltaMontantCadt;
  }
  
  public boolean isEstFiltreDeDeltaMontantCrc()
  {
    return m_estFiltreDeDeltaMontantCrc;
  }
  
  public void setEstFiltreDeDeltaMontantCrc(boolean p_estFiltreDeDeltaMontantCrc)
  {
    m_estFiltreDeDeltaMontantCrc = p_estFiltreDeDeltaMontantCrc;
  }
  
  public boolean isEstFiltreDeReexamen()
  {
    return m_estFiltreDeReexamen;
  }
  
  public void setEstFiltreDeReexamen(boolean p_estFiltreDeReexamen)
  {
    m_estFiltreDeReexamen = p_estFiltreDeReexamen;
  }
  
  public String getAntenne()
  {
    return m_antenne;
  }
  
  public void setAntenne(String p_antenne)
  {
    m_antenne = p_antenne;
  }
  
  public BigDecimal getNbIndividusTotalSelectionnes()
  {
    return m_nbIndividusTotalSelectionnes;
  }
  
  public void setNbIndividusTotalSelectionnes(BigDecimal p_nbIndividusTotalSelectionnes)
  {
    m_nbIndividusTotalSelectionnes = p_nbIndividusTotalSelectionnes;
  }
  
  public String getChampATrier()
  {
    return m_champATrier;
  }
  
  public void setChampATrier(String p_champATrier)
  {
    m_champATrier = p_champATrier;
  }
  
  public String getSensTri()
  {
    return m_sensTri;
  }
  
  public void setSensTri(String p_sensTri)
  {
    m_sensTri = p_sensTri;
  }
}

/* Location:
 * Qualified Name:     DomLireIndividus
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */