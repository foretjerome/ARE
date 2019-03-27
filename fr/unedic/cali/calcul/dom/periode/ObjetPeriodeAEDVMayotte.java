package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeCalculTransient;
import fr.unedic.util.ObjetMetierSpec;

public class ObjetPeriodeAEDVMayotte
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = 1028800747257578088L;
  private ActiviteSalarie activiteSalarie;
  
  public ObjetPeriodeAEDVMayotte(ActiviteSalarie periodeAct)
  {
    super(periodeAct.getDateFin(), periodeAct.getDateFin());
    activiteSalarie = periodeAct;
  }
  
  public ObjetMetierSpec copie()
  {
    return null;
  }
  
  public void setActiviteSalarie(ActiviteSalarie activiteSalarie)
  {
    this.activiteSalarie = activiteSalarie;
  }
  
  public ActiviteSalarie getActiviteSalarie()
  {
    return activiteSalarie;
  }
}

/* Location:
 * Qualified Name:     ObjetPeriodeAEDVMayotte
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */