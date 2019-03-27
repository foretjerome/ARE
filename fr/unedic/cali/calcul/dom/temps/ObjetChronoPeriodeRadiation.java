package fr.unedic.cali.calcul.dom.temps;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class ObjetChronoPeriodeRadiation
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = 750257756316607035L;
  private ObjetChronoPeriodePEC m_periodePEC = null;
  private ObjetChronoPeriodeNonPEC m_periodeNonPEC = null;
  private String m_motifAnnulationPEC;
  private boolean estTypeArce;
  
  public boolean isEstTypeArce()
  {
    return estTypeArce;
  }
  
  public void setEstTypeArce(boolean estTypeArce)
  {
    this.estTypeArce = estTypeArce;
  }
  
  private ObjetChronoPeriodeRadiation() {}
  
  public ObjetChronoPeriodeRadiation(Damj p_date)
  {
    super(p_date, p_date);
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
  
  public String getMotifAnnulationPEC()
  {
    return m_motifAnnulationPEC;
  }
  
  public void setMotifAnnulationPEC(String p_motifAnnulationPEC)
  {
    m_motifAnnulationPEC = p_motifAnnulationPEC;
  }
  
  public ObjetMetierSpec copie()
  {
    ObjetChronoPeriodeRadiation copie = new ObjetChronoPeriodeRadiation();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    ObjetChronoPeriodeRadiation copie = (ObjetChronoPeriodeRadiation)p_copie;
    super.copieElements(copie);
    if (getPEC() != null) {
      m_periodePEC = ((ObjetChronoPeriodePEC)getPEC().copie());
    }
    if (getNonPEC() != null) {
      m_periodeNonPEC = ((ObjetChronoPeriodeNonPEC)getNonPEC().copie());
    }
    m_motifAnnulationPEC = getMotifAnnulationPEC();
  }
}

/* Location:
 * Qualified Name:     ObjetChronoPeriodeRadiation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */