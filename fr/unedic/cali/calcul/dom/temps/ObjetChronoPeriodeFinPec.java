package fr.unedic.cali.calcul.dom.temps;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class ObjetChronoPeriodeFinPec
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = -5483839714541128726L;
  private ObjetChronoPeriodePEC m_periodePEC = null;
  private ObjetChronoPeriodeNonPEC m_periodeNonPEC = null;
  private String m_motifAnnulationPEC;
  
  private ObjetChronoPeriodeFinPec() {}
  
  public ObjetChronoPeriodeFinPec(Damj p_dateDebut)
  {
    super(p_dateDebut, p_dateDebut);
  }
  
  public ObjetMetierSpec copie()
  {
    ObjetChronoPeriodeFinPec copie = new ObjetChronoPeriodeFinPec();
    copieElements(copie);
    return copie;
  }
  
  public String getMotifAnnulationPEC()
  {
    return m_motifAnnulationPEC;
  }
  
  public void setMotifAnnulationPEC(String p_motifAnnulationPEC)
  {
    m_motifAnnulationPEC = p_motifAnnulationPEC;
  }
  
  public ObjetChronoPeriodeNonPEC getPeriodeNonPEC()
  {
    return m_periodeNonPEC;
  }
  
  public void setPeriodeNonPEC(ObjetChronoPeriodeNonPEC p_periodeNonPEC)
  {
    m_periodeNonPEC = p_periodeNonPEC;
  }
  
  public ObjetChronoPeriodePEC getPeriodePEC()
  {
    return m_periodePEC;
  }
  
  public void setPeriodePEC(ObjetChronoPeriodePEC p_periodePEC)
  {
    m_periodePEC = p_periodePEC;
  }
  
  public ObjetChronoPeriodeNonPEC getNonPEC()
  {
    return m_periodeNonPEC;
  }
  
  public void setNonPEC(ObjetChronoPeriodeNonPEC p_periodeNonPEC)
  {
    m_periodeNonPEC = p_periodeNonPEC;
  }
  
  public ObjetChronoPeriodePEC getPEC()
  {
    return m_periodePEC;
  }
  
  public void setPEC(ObjetChronoPeriodePEC p_periodePEC)
  {
    m_periodePEC = p_periodePEC;
  }
}

/* Location:
 * Qualified Name:     ObjetChronoPeriodeFinPec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */