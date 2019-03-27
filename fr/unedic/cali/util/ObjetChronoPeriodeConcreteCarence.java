package fr.unedic.cali.util;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoPeriodeConcrete;
import fr.unedic.util.temps.Periode;

public class ObjetChronoPeriodeConcreteCarence
  extends ObjetChronoPeriodeConcrete
{
  public ObjetChronoPeriodeConcreteCarence() {}
  
  public ObjetChronoPeriodeConcreteCarence(Damj p_dateDebut, Damj p_dateFin)
  {
    super(p_dateDebut, p_dateFin);
  }
  
  public ObjetChronoPeriodeConcreteCarence(Periode p_periode)
  {
    super(p_periode);
  }
  
  public int hashCode()
  {
    StringBuffer buffer = new StringBuffer();
    if (getDateDebut() != null) {
      buffer.append(getDateDebut());
    }
    if (getDateFin() != null) {
      buffer.append(getDateFin());
    }
    return buffer.toString().hashCode();
  }
  
  public boolean equals(Object p_objet)
  {
    boolean retour = false;
    if ((p_objet instanceof ObjetChronoPeriodeConcreteCarence))
    {
      ObjetChronoPeriodeConcreteCarence objetChronoPeriodeConcreteCarence = (ObjetChronoPeriodeConcreteCarence)p_objet;
      if ((getDateDebut().coincideAvec(objetChronoPeriodeConcreteCarence.getDateDebut())) && (getDateFin().coincideAvec(objetChronoPeriodeConcreteCarence.getDateFin()))) {
        retour = true;
      }
    }
    return retour;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    super.copieElements(p_copie);
  }
  
  public ObjetMetierSpec copie()
  {
    ObjetChronoPeriodeConcrete copie = new ObjetChronoPeriodeConcrete();
    copieElements(copie);
    return copie;
  }
}

/* Location:
 * Qualified Name:     ObjetChronoPeriodeConcreteCarence
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */