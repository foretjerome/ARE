package fr.unedic.cali.calcul.dom.temps;

import fr.unedic.cali.dom.Retraite;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class ObjetChronoPeriodeRetraite
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = -5815377285661340826L;
  private boolean nbTrimestreInconnu;
  private transient Retraite retraite;
  
  private ObjetChronoPeriodeRetraite() {}
  
  public ObjetChronoPeriodeRetraite(Retraite retraite, Damj fin)
  {
    super(retraite.getDate(), fin);
    this.retraite = retraite;
  }
  
  public ObjetMetierSpec copie()
  {
    ObjetChronoPeriodeRetraite copie = new ObjetChronoPeriodeRetraite();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec omSpec)
  {
    ObjetChronoPeriodeRetraite copie = (ObjetChronoPeriodeRetraite)omSpec;
    super.copieElements(copie);
    nbTrimestreInconnu = estNbTrimestreInconnu();
    retraite = getRetraite();
  }
  
  public Retraite getRetraite()
  {
    return retraite;
  }
  
  public void setRetraite(Retraite retraite)
  {
    this.retraite = retraite;
  }
  
  public boolean estNbTrimestreInconnu()
  {
    return nbTrimestreInconnu;
  }
  
  public void setNbTrimestreInconnu(boolean nbTrimestreInconnu)
  {
    this.nbTrimestreInconnu = nbTrimestreInconnu;
  }
}

/* Location:
 * Qualified Name:     ObjetChronoPeriodeRetraite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */