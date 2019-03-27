package fr.unedic.cali.autresdoms.ga.dom;

import fr.unedic.util.temps.Damj;

public class InformationPeriodeGlobale
{
  private transient Damj m_dateDebutPeriode = null;
  private transient Damj m_dateFinPeriode = null;
  private transient Damj m_dateRuptureContratTravail = null;
  private transient String m_motifFin = null;
  
  public Damj getDateDebutPeriode()
  {
    return m_dateDebutPeriode;
  }
  
  public void setDateDebutPeriode(Damj p_dateDebutPeriode)
  {
    m_dateDebutPeriode = p_dateDebutPeriode;
  }
  
  public Damj getDateFinPeriode()
  {
    return m_dateFinPeriode;
  }
  
  public void setDateFinPeriode(Damj p_dateFinPeriode)
  {
    m_dateFinPeriode = p_dateFinPeriode;
  }
  
  public Damj getDateRuptureContratTravail()
  {
    return m_dateRuptureContratTravail;
  }
  
  public void setDateRuptureContratTravail(Damj p_dateRuptureContratTravail)
  {
    m_dateRuptureContratTravail = p_dateRuptureContratTravail;
  }
  
  public String getMotifFin()
  {
    return m_motifFin;
  }
  
  public void setMotifFin(String p_motifFin)
  {
    m_motifFin = p_motifFin;
  }
}

/* Location:
 * Qualified Name:     InformationPeriodeGlobale
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */