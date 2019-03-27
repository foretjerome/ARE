package fr.unedic.cali.calcul.dom.temps;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class ObjetChronoPeriodeSuspensionPTSParAutreProduit
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = 1L;
  
  private ObjetChronoPeriodeSuspensionPTSParAutreProduit() {}
  
  public ObjetChronoPeriodeSuspensionPTSParAutreProduit(Damj dateDebut, Damj dateFin)
  {
    super(dateDebut, dateFin);
  }
  
  public ObjetChronoPeriodeSuspensionPTSParAutreProduit(Periode periode)
  {
    super(periode.getDebut(), periode.getFin());
  }
  
  public ObjetMetierSpec copie()
  {
    ObjetChronoPeriodeSuspensionPTSParAutreProduit copie = new ObjetChronoPeriodeSuspensionPTSParAutreProduit();
    copieElements(copie);
    return copie;
  }
}

/* Location:
 * Qualified Name:     ObjetChronoPeriodeSuspensionPTSParAutreProduit
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */