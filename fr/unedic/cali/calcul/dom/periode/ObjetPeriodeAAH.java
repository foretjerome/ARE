package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeCalculTransient;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class ObjetPeriodeAAH
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = 1028800747257578088L;
  private Damj dateDebutPeriode;
  
  private ObjetPeriodeAAH() {}
  
  public ObjetPeriodeAAH(Damj debut, Damj fin)
  {
    super(debut, fin);
    dateDebutPeriode = debut;
  }
  
  public ObjetMetierSpec copie()
  {
    ObjetPeriodeAAH copie = new ObjetPeriodeAAH();
    copieElements(copie);
    copie.setDateDebutPeriode(getDateDebutPeriode());
    return copie;
  }
  
  public Damj getDateDebutPeriode()
  {
    return dateDebutPeriode;
  }
  
  public void setDateDebutPeriode(Damj dateDebut)
  {
    dateDebutPeriode = dateDebut;
  }
}

/* Location:
 * Qualified Name:     ObjetPeriodeAAH
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */