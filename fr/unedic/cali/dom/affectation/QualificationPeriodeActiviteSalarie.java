package fr.unedic.cali.dom.affectation;

import fr.unedic.cali.affectation.parametres.CriteresQualification;

public class QualificationPeriodeActiviteSalarie
{
  private Reglement m_reglement;
  private String m_nomReglement;
  private int m_codeProduit;
  private CriteresQualification m_criteresQualification;
  
  private QualificationPeriodeActiviteSalarie() {}
  
  public QualificationPeriodeActiviteSalarie(Reglement p_reglement, CriteresQualification p_criteresQualification)
  {
    setReglement(p_reglement);
    setCriteresQualification(p_criteresQualification);
  }
  
  public String getNomReglement()
  {
    return m_nomReglement;
  }
  
  public void setNomReglement(String p_nomReglement)
  {
    m_nomReglement = p_nomReglement;
  }
  
  public Reglement getReglement()
  {
    if (m_reglement == null) {
      m_reglement = Parametres.getReglement(m_nomReglement, Parametres.getProduit(m_codeProduit));
    }
    return m_reglement;
  }
  
  public void setReglement(Reglement p_reglement)
  {
    m_reglement = p_reglement;
    m_nomReglement = p_reglement.getNomReglement();
    m_codeProduit = p_reglement.getProduit().getCode();
  }
  
  public CriteresQualification getCriteresQualification()
  {
    return m_criteresQualification;
  }
  
  public void setCriteresQualification(CriteresQualification p_criteresQualification)
  {
    m_criteresQualification = p_criteresQualification;
  }
}

/* Location:
 * Qualified Name:     QualificationPeriodeActiviteSalarie
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */