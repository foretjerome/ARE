package fr.unedic.cali.calcul.dom;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoEvenement;

public class EvenementActDateFin
  extends ObjetChronoEvenement
  implements EvenementCalculSpec
{
  private EvenementActDateFin() {}
  
  public EvenementActDateFin(Damj p_date)
  {
    super(p_date);
  }
  
  public Damj getDateEvenement()
  {
    return m_dateEvenement;
  }
  
  public void setDateEvenement(Damj p_dateEvenement)
  {
    m_dateEvenement = p_dateEvenement;
  }
  
  public ObjetMetierSpec copie()
  {
    EvenementActDateFin copie = new EvenementActDateFin();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    EvenementActDateFin copie = (EvenementActDateFin)p_copie;
    copie.setDateEvenement(getDateEvenement());
  }
}

/* Location:
 * Qualified Name:     EvenementActDateFin
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */