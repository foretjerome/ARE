package fr.unedic.cohabitation.sigma.migration.dom;

import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;
import org.apache.commons.lang.builder.EqualsBuilder;

public abstract class DecisionMigreeV1
{
  private BigDecimal m_natureDecision;
  private Damj m_dateAttribution;
  private Damj m_dateDerniereValidation;
  private Damj m_pji;
  private BigDecimal m_idAdmission;
  private BigDecimal m_idReprise;
  private String m_situationParticuliere;
  private DemandeMigreeV1 m_demandeMigree;
  
  protected DecisionMigreeV1()
  {
    initInstance();
  }
  
  private void initInstance() {}
  
  public DemandeMigreeV1 getDemandeMigree()
  {
    return m_demandeMigree;
  }
  
  public void setDemandeMigree(DemandeMigreeV1 p_demandeMigree)
  {
    m_demandeMigree = p_demandeMigree;
  }
  
  public Damj getDateAttribution()
  {
    return m_dateAttribution;
  }
  
  public void setDateAttribution(Damj p_dateAttribution)
  {
    m_dateAttribution = p_dateAttribution;
  }
  
  public int getNatureDecision()
  {
    if (m_natureDecision != null) {
      return m_natureDecision.intValue();
    }
    return -1;
  }
  
  public void setNatureDecision(BigDecimal p_natureDecision)
  {
    m_natureDecision = p_natureDecision;
  }
  
  public Damj getPji()
  {
    return m_pji;
  }
  
  public void setPji(Damj p_pji)
  {
    m_pji = p_pji;
  }
  
  public Damj getDateDerniereValidation()
  {
    return m_dateDerniereValidation;
  }
  
  public void setDateDerniereValidation(Damj p_dateDerniereValidation)
  {
    m_dateDerniereValidation = p_dateDerniereValidation;
  }
  
  public BigDecimal getIdAdmission()
  {
    return m_idAdmission;
  }
  
  public void setIdAdmission(BigDecimal p_idAdmission)
  {
    m_idAdmission = p_idAdmission;
  }
  
  public BigDecimal getIdReprise()
  {
    return m_idReprise;
  }
  
  public void setIdReprise(BigDecimal p_idReprise)
  {
    m_idReprise = p_idReprise;
  }
  
  public String getSituationParticuliere()
  {
    if (m_situationParticuliere == null) {
      return "";
    }
    return m_situationParticuliere;
  }
  
  public void setSituationParticuliere(String p_situationParticuliere)
  {
    m_situationParticuliere = p_situationParticuliere;
  }
  
  public boolean equals(Object p_arg0)
  {
    boolean isEqual = false;
    if ((p_arg0 instanceof DecisionMigreeV1))
    {
      DecisionMigreeV1 demandeV1 = (DecisionMigreeV1)p_arg0;
      
      EqualsBuilder eqb = new EqualsBuilder();
      
      isEqual = eqb.append(getDateAttribution(), demandeV1.getDateAttribution()).append(getDateDerniereValidation(), demandeV1.getDateDerniereValidation()).append(getIdAdmission(), demandeV1.getIdAdmission()).append(getIdReprise(), demandeV1.getIdReprise()).append(getNatureDecision(), demandeV1.getNatureDecision()).append(getPji(), demandeV1.getPji()).isEquals();
    }
    return isEqual;
  }
}

/* Location:
 * Qualified Name:     DecisionMigreeV1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */