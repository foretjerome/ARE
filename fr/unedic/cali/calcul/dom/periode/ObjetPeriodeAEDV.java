package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeCalculTransient;
import fr.unedic.util.ObjetMetierSpec;

public class ObjetPeriodeAEDV
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = 1028800747257578088L;
  private ActiviteSalarie activiteSalarie;
  
  private ObjetPeriodeAEDV() {}
  
  public ObjetPeriodeAEDV(ActiviteSalarie periodeAct)
  {
    super(periodeAct.getDateFin(), periodeAct.getDateFin());
    setActiviteSalarie(periodeAct);
  }
  
  public ObjetMetierSpec copie()
  {
    ObjetPeriodeAEDV copie = new ObjetPeriodeAEDV();
    copieElements(copie);
    copie.setActiviteSalarie(activiteSalarie);
    return copie;
  }
  
  public ActiviteSalarie getActiviteSalarie()
  {
    return activiteSalarie;
  }
  
  public void setActiviteSalarie(ActiviteSalarie activiteSalarie)
  {
    this.activiteSalarie = activiteSalarie;
  }
}

/* Location:
 * Qualified Name:     ObjetPeriodeAEDV
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */