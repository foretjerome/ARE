package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeCalculTransient;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class FinActionFormationInterruptive
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = -4046297190747980429L;
  private ActionFormation actionFormation = null;
  
  private FinActionFormationInterruptive() {}
  
  public FinActionFormationInterruptive(Damj date)
  {
    super(date, date);
  }
  
  public ActionFormation getActionFormation()
  {
    return actionFormation;
  }
  
  public void setActionFormation(ActionFormation actionFormation)
  {
    this.actionFormation = actionFormation;
  }
  
  public ObjetMetierSpec copie()
  {
    FinActionFormationInterruptive copie = new FinActionFormationInterruptive();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec copie)
  {
    FinActionFormationInterruptive copieFAFI = (FinActionFormationInterruptive)copie;
    super.copieElements(copieFAFI);
    actionFormation = getActionFormation();
  }
}

/* Location:
 * Qualified Name:     FinActionFormationInterruptive
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */