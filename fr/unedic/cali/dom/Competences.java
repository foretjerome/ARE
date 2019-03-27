package fr.unedic.cali.dom;

import fr.unedic.cali.dom.spec.ConventionGestionSpec;

public class Competences
{
  private int m_competenceFinanciere;
  private int m_competenceAdministrative;
  private boolean m_estPCRCForce;
  private ConventionGestionSpec m_conventionGestion;
  
  public int getCompetenceFinanciere()
  {
    return m_competenceFinanciere;
  }
  
  public int getCompetenceAdministrative()
  {
    return m_competenceAdministrative;
  }
  
  public void setCompetenceAdministrative(int p_competenceAdministrative)
  {
    m_competenceAdministrative = p_competenceAdministrative;
  }
  
  public void setCompetenceFinanciere(int p_competenceFinanciere)
  {
    m_competenceFinanciere = p_competenceFinanciere;
  }
  
  public ConventionGestionSpec getConventionGestion()
  {
    return m_conventionGestion;
  }
  
  public void setConventionGestion(ConventionGestionSpec p_conventionGestion)
  {
    m_conventionGestion = p_conventionGestion;
  }
  
  public void setEstPCRCForce(boolean p_estPCRCForce)
  {
    m_estPCRCForce = p_estPCRCForce;
  }
  
  public boolean isEstPCRCForce()
  {
    return m_estPCRCForce;
  }
}

/* Location:
 * Qualified Name:     Competences
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */