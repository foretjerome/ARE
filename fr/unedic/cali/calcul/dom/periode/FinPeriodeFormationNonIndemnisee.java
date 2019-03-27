package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeCalculTransient;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class FinPeriodeFormationNonIndemnisee
  extends ObjetChronoPeriodeCalculTransient
{
  private PeriodeFormationNonIndemnisee m_periodeFormationNonIndemnisee = null;
  private Damj m_dateDebutFormation = null;
  private Damj m_dateFinFormation = null;
  
  protected FinPeriodeFormationNonIndemnisee() {}
  
  public FinPeriodeFormationNonIndemnisee(Damj p_date)
  {
    super(p_date, p_date);
  }
  
  public PeriodeFormationNonIndemnisee getPeriodeFormationNonIndemnisee()
  {
    return m_periodeFormationNonIndemnisee;
  }
  
  public void setPeriodeFormationNonIndemnisee(PeriodeFormationNonIndemnisee p_periodeFormationNonIndemnisee)
  {
    m_periodeFormationNonIndemnisee = p_periodeFormationNonIndemnisee;
  }
  
  public ObjetMetierSpec copie()
  {
    FinPeriodeFormationNonIndemnisee copie = new FinPeriodeFormationNonIndemnisee();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    FinPeriodeFormationNonIndemnisee copie = (FinPeriodeFormationNonIndemnisee)p_copie;
    super.copieElements(copie);
    m_periodeFormationNonIndemnisee = getPeriodeFormationNonIndemnisee();
  }
  
  public Damj getDateDebutFormation()
  {
    return m_dateDebutFormation;
  }
  
  public void setDateDebutFormation(Damj p_dateDebutFormation)
  {
    m_dateDebutFormation = p_dateDebutFormation;
  }
  
  public Damj getDateFinFormation()
  {
    return m_dateFinFormation;
  }
  
  public void setDateFinFormation(Damj p_dateFinFormation)
  {
    m_dateFinFormation = p_dateFinFormation;
  }
}

/* Location:
 * Qualified Name:     FinPeriodeFormationNonIndemnisee
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */