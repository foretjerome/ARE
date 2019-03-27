package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeCalculTransient;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class PeriodeInassiduiteFormation
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = 1709309789771513175L;
  private ActionFormation m_actionFormation;
  
  protected PeriodeInassiduiteFormation() {}
  
  public PeriodeInassiduiteFormation(Damj p_debut, Damj p_fin)
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
    PeriodeInassiduiteFormation copie = new PeriodeInassiduiteFormation();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    PeriodeInassiduiteFormation copie = (PeriodeInassiduiteFormation)p_copie;
    super.copieElements(copie);
    m_actionFormation = getActionFormation();
  }
}

/* Location:
 * Qualified Name:     PeriodeInassiduiteFormation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */