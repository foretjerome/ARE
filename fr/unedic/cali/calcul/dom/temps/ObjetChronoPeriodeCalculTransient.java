package fr.unedic.cali.calcul.dom.temps;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoPeriode;
import fr.unedic.util.temps.Periode;

public abstract class ObjetChronoPeriodeCalculTransient
  extends ObjetChronoPeriode
  implements ObjetChronoPeriodeCalcul, ObjetChronoPeriodeCalculSpec
{
  protected ObjetChronoPeriodeCalculTransient() {}
  
  public ObjetChronoPeriodeCalculTransient(Damj p_debut, Damj p_fin)
  {
    super(p_debut, p_fin);
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    ObjetChronoPeriodeCalcul copie = (ObjetChronoPeriodeCalcul)p_copie;
    copie.setDateDebut(getDateDebut());
    copie.setDateFin(getDateFin());
  }
  
  public Periode getPeriode()
  {
    return m_periode;
  }
  
  public void setPeriode(Periode p_periode)
  {
    m_periode = p_periode;
  }
  
  public void setDateDebut(Damj p_dateDebut)
  {
    Damj dateFin = getDateFin();
    if (p_dateDebut.estApres(dateFin)) {
      dateFin = p_dateDebut;
    }
    setPeriode(new Periode(p_dateDebut, dateFin));
  }
  
  public void setDateFin(Damj p_dateFin)
  {
    Damj dateDebut = getDateDebut();
    if (p_dateFin.estAvant(dateDebut)) {
      dateDebut = p_dateFin;
    }
    setPeriode(new Periode(dateDebut, p_dateFin));
  }
}

/* Location:
 * Qualified Name:     ObjetChronoPeriodeCalculTransient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */