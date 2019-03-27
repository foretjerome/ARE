package fr.unedic.cali.calcul.dom.temps;

import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class ObjetChronoPeriodeSuspensionIslr
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = 1L;
  private Damj dateFct;
  private ActiviteSalarie activite;
  private ObjetChronoPeriodeSuspensionIslr periodeGlobaleSuspensionISLR;
  
  private ObjetChronoPeriodeSuspensionIslr() {}
  
  public ObjetChronoPeriodeSuspensionIslr(ActiviteSalarie activite)
  {
    super(activite.getDateFin().lendemain(), activite.getDateFin().lendemain());
    setActivite(activite);
    setDateFct(activite.getDateFin());
  }
  
  public ObjetMetierSpec copie()
  {
    ObjetChronoPeriodeSuspensionIslr copie = new ObjetChronoPeriodeSuspensionIslr();
    copieElements(copie);
    copie.setActivite(getActivite());
    copie.setDateFct(getDateFct());
    copie.setPeriodeGlobaleSuspensionISLR(getPeriodeGlobaleSuspensionISLR());
    return copie;
  }
  
  public Damj getDateFct()
  {
    return dateFct;
  }
  
  public void setDateFct(Damj dateFct)
  {
    this.dateFct = dateFct;
  }
  
  public ActiviteSalarie getActivite()
  {
    return activite;
  }
  
  public void setActivite(ActiviteSalarie activite)
  {
    this.activite = activite;
  }
  
  public ObjetChronoPeriodeSuspensionIslr getPeriodeGlobaleSuspensionISLR()
  {
    return periodeGlobaleSuspensionISLR;
  }
  
  public void setPeriodeGlobaleSuspensionISLR(ObjetChronoPeriodeSuspensionIslr p_periodeGlobaleSuspensionISLR)
  {
    periodeGlobaleSuspensionISLR = p_periodeGlobaleSuspensionISLR;
  }
}

/* Location:
 * Qualified Name:     ObjetChronoPeriodeSuspensionIslr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */