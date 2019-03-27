package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeCalculTransient;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class FinPeriodeFormation
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = -4046297190747980429L;
  private ActionFormation m_actionFormation = null;
  
  protected FinPeriodeFormation() {}
  
  public FinPeriodeFormation(Damj p_date)
  {
    super(p_date, p_date);
  }
  
  public ActionFormation getActionFormation()
  {
    return m_actionFormation;
  }
  
  public void setActionFormation(ActionFormation p_actionFormation)
  {
    m_actionFormation = p_actionFormation;
  }
  
  public ObjetMetierSpec copie()
  {
    FinPeriodeFormation copie = new FinPeriodeFormation();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    FinPeriodeFormation copie = (FinPeriodeFormation)p_copie;
    super.copieElements(copie);
    m_actionFormation = getActionFormation();
  }
}

/* Location:
 * Qualified Name:     FinPeriodeFormation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */