package fr.unedic.cali.autresdoms.ga.mapping;

import fr.unedic.util.temps.ChronologiePeriodes;

public class LireListePeriodeResultat
{
  private ChronologiePeriodes m_chronoPeriodesPasseProfessionnel;
  private ChronologiePeriodes m_chronoPeriodesPasseProfessionnelFrauduleusesEcartees;
  
  public ChronologiePeriodes getChronoPeriodesPasseProfessionnel()
  {
    if (m_chronoPeriodesPasseProfessionnel == null) {
      m_chronoPeriodesPasseProfessionnel = new ChronologiePeriodes();
    }
    return m_chronoPeriodesPasseProfessionnel;
  }
  
  public void setChronoPeriodesPasseProfessionnel(ChronologiePeriodes p_chronoPeriodesPasseProfessionnel)
  {
    m_chronoPeriodesPasseProfessionnel = p_chronoPeriodesPasseProfessionnel;
  }
  
  public ChronologiePeriodes getChronoPeriodesPasseProfessionnelEcartees()
  {
    if (m_chronoPeriodesPasseProfessionnelFrauduleusesEcartees == null) {
      m_chronoPeriodesPasseProfessionnelFrauduleusesEcartees = new ChronologiePeriodes();
    }
    return m_chronoPeriodesPasseProfessionnelFrauduleusesEcartees;
  }
  
  public void setChronoPeriodesPasseProfessionnelEcartees(ChronologiePeriodes p_chronoPeriodesPasseProfessionnelEcartees)
  {
    m_chronoPeriodesPasseProfessionnelFrauduleusesEcartees = p_chronoPeriodesPasseProfessionnelEcartees;
  }
}

/* Location:
 * Qualified Name:     LireListePeriodeResultat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */