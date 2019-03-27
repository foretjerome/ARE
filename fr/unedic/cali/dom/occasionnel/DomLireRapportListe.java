package fr.unedic.cali.dom.occasionnel;

import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;
import java.util.List;

public class DomLireRapportListe
{
  private String m_cxass;
  private String m_libRapport;
  private String m_nomChaine;
  private String m_modeOccas;
  private Damj m_datePassage;
  private BigDecimal m_fonctRappId;
  private List m_libPopulation;
  private List m_codePopulation;
  private BigDecimal m_nombreDe;
  private List m_listeRapport;
  private boolean m_affichableIhmVisu;
  private boolean m_affichableSimuChangement;
  private Damj m_dateTraitement;
  
  public Damj getDateTraitement()
  {
    return m_dateTraitement;
  }
  
  public void setDateTraitement(Damj p_dateTraitement)
  {
    m_dateTraitement = p_dateTraitement;
  }
  
  public Damj getDatePassage()
  {
    return m_datePassage;
  }
  
  public void setDatePassage(Damj p_datePassage)
  {
    m_datePassage = p_datePassage;
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
  
  public String getModeOccas()
  {
    return m_modeOccas;
  }
  
  public void setModeOccas(String p_modeOccas)
  {
    m_modeOccas = p_modeOccas;
  }
  
  public String getNomChaine()
  {
    return m_nomChaine;
  }
  
  public void setNomChaine(String p_nomChaine)
  {
    m_nomChaine = p_nomChaine;
  }
  
  public String getLibRapport()
  {
    return m_libRapport;
  }
  
  public void setLibRapport(String p_libRapport)
  {
    m_libRapport = p_libRapport;
  }
  
  public List getCodePopulation()
  {
    return m_codePopulation;
  }
  
  public void setCodePopulation(List p_codePopulation)
  {
    m_codePopulation = p_codePopulation;
  }
  
  public List getLibPopulation()
  {
    return m_libPopulation;
  }
  
  public void setLibPopulation(List p_libPopulation)
  {
    m_libPopulation = p_libPopulation;
  }
  
  public BigDecimal getNombreDe()
  {
    return m_nombreDe;
  }
  
  public void setNombreDe(BigDecimal p_nombreDe)
  {
    m_nombreDe = p_nombreDe;
  }
  
  public List getListeRapport()
  {
    return m_listeRapport;
  }
  
  public void setListeRapport(List p_listeRapport)
  {
    m_listeRapport = p_listeRapport;
  }
  
  public boolean isAffichableIhmVisu()
  {
    return m_affichableIhmVisu;
  }
  
  public void setAffichableIhmVisu(boolean p_affichableIhmVisu)
  {
    m_affichableIhmVisu = p_affichableIhmVisu;
  }
  
  public boolean isAffichableSimuChangement()
  {
    return m_affichableSimuChangement;
  }
  
  public void setAffichableSimuChangement(boolean p_estAffichableSimuOccasionnel)
  {
    m_affichableSimuChangement = p_estAffichableSimuOccasionnel;
  }
  
  public DomLireRapportListe copie()
  {
    DomLireRapportListe copie = new DomLireRapportListe();
    copie.setCxass(getCxass());
    copie.setLibRapport(getLibRapport());
    copie.setNomChaine(getNomChaine());
    copie.setModeOccas(getModeOccas());
    copie.setDatePassage(getDatePassage());
    copie.setFonctRappId(getFonctRappId());
    copie.setLibPopulation(getLibPopulation());
    copie.setCodePopulation(getCodePopulation());
    copie.setNombreDe(getNombreDe());
    copie.setListeRapport(getListeRapport());
    return copie;
  }
}

/* Location:
 * Qualified Name:     DomLireRapportListe
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */