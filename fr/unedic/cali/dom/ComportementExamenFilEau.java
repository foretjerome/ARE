package fr.unedic.cali.dom;

import fr.unedic.util.temps.Damj;

public class ComportementExamenFilEau
  implements ComportementExamenFilEauSpec
{
  private Integer m_identifiantComportement = null;
  private String m_libelleComportement = null;
  private boolean m_modeSimulationActif = true;
  private boolean m_calculAffiliationSimplifieeActif = true;
  private int m_nombreMaximumFctATraiter = 0;
  private Damj m_dateEvenementDeclencheur = null;
  private int m_natureEvenementDeclencheur = 0;
  
  public ComportementExamenFilEau(Integer p_identifiantComportement)
  {
    m_identifiantComportement = p_identifiantComportement;
  }
  
  public Integer getIdentifiantComportement()
  {
    return m_identifiantComportement;
  }
  
  public String getLibelleComportement()
  {
    return m_libelleComportement;
  }
  
  public boolean isCalculAffiliationSimplifieeActif()
  {
    return m_calculAffiliationSimplifieeActif;
  }
  
  public boolean isModeSimulationActif()
  {
    return m_modeSimulationActif;
  }
  
  public void setCalculAffiliationSimplifieeActif(boolean p_affiliationSimplifieActiif)
  {
    m_calculAffiliationSimplifieeActif = p_affiliationSimplifieActiif;
  }
  
  public void setLibelleComportement(String p_libelle)
  {
    m_libelleComportement = p_libelle;
  }
  
  public void setModeSimulationActif(boolean p_modeSimulation)
  {
    m_modeSimulationActif = p_modeSimulation;
  }
  
  public int getNombreMaximumFctATraiter()
  {
    return m_nombreMaximumFctATraiter;
  }
  
  public void setNombreMaximumFctATraiter(int p_nombreMaximumFctATraiter)
  {
    m_nombreMaximumFctATraiter = p_nombreMaximumFctATraiter;
  }
  
  public Damj getDateEvenementDeclencheur()
  {
    return m_dateEvenementDeclencheur;
  }
  
  public void setDateEvenementDeclencheur(Damj p_dateEvenementDeclencheur)
  {
    m_dateEvenementDeclencheur = p_dateEvenementDeclencheur;
  }
  
  public int getNatureEvenementDeclencheur()
  {
    return m_natureEvenementDeclencheur;
  }
  
  public void setNatureEvenementDeclencheur(int p_natureEvenementDeclencheur)
  {
    m_natureEvenementDeclencheur = p_natureEvenementDeclencheur;
  }
}

/* Location:
 * Qualified Name:     ComportementExamenFilEau
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */