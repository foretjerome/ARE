package fr.unedic.cali.calcul.dom.temps;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class ObjetChronoPeriodeSuspensionPfmParAutreProduit
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = 1L;
  
  private ObjetChronoPeriodeSuspensionPfmParAutreProduit() {}
  
  public ObjetChronoPeriodeSuspensionPfmParAutreProduit(Damj p_dateDebut, Damj p_dateFin)
  {
    super(p_dateDebut, p_dateFin);
  }
  
  public ObjetMetierSpec copie()
  {
    ObjetChronoPeriodeSuspensionPfmParAutreProduit copie = new ObjetChronoPeriodeSuspensionPfmParAutreProduit();
    copieElements(copie);
    return copie;
  }
}

/* Location:
 * Qualified Name:     ObjetChronoPeriodeSuspensionPfmParAutreProduit
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */