package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeCalculTransient;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class PeriodeInterStageFormation
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = -1654303270347390499L;
  private ActionFormation m_actionFormation = null;
  private PeriodeFormation m_periodeFormation = null;
  
  public PeriodeInterStageFormation() {}
  
  public PeriodeInterStageFormation(Damj p_debut, Damj p_fin)
  {
    super(p_debut, p_fin);
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
    PeriodeInterStageFormation copie = new PeriodeInterStageFormation();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    PeriodeInterStageFormation copie = (PeriodeInterStageFormation)p_copie;
    super.copieElements(copie);
    m_actionFormation = getActionFormation();
    copie.setPeriodeFormation(getPeriodeFormation());
  }
  
  public PeriodeFormation getPeriodeFormation()
  {
    return m_periodeFormation;
  }
  
  public void setPeriodeFormation(PeriodeFormation p_periodeFormation)
  {
    m_periodeFormation = p_periodeFormation;
  }
}

/* Location:
 * Qualified Name:     PeriodeInterStageFormation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */