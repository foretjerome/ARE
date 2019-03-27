package fr.unedic.cali.calcul.dom.temps;

import fr.unedic.cali.autresdoms.ga.dom.PeriodeActiviteNonSalariePeriodique;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class ObjetChronoPeriodeFinDureeACCREASSSuiteAccord
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = -190663058099966762L;
  private PeriodeActiviteNonSalariePeriodique m_pansLiee;
  
  private ObjetChronoPeriodeFinDureeACCREASSSuiteAccord() {}
  
  public ObjetChronoPeriodeFinDureeACCREASSSuiteAccord(Damj p_date, PeriodeActiviteNonSalariePeriodique p_pans)
  {
    super(p_date, p_date);
    setPansLiee(p_pans);
  }
  
  public ObjetMetierSpec copie()
  {
    ObjetChronoPeriodeFinDureeACCREASSSuiteAccord copie = new ObjetChronoPeriodeFinDureeACCREASSSuiteAccord();
    copieElements(copie);
    return copie;
  }
  
  public PeriodeActiviteNonSalariePeriodique getPansLiee()
  {
    return m_pansLiee;
  }
  
  public void setPansLiee(PeriodeActiviteNonSalariePeriodique p_pansLiee)
  {
    m_pansLiee = p_pansLiee;
  }
}

/* Location:
 * Qualified Name:     ObjetChronoPeriodeFinDureeACCREASSSuiteAccord
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */