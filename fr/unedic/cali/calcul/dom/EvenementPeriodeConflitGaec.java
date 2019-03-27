package fr.unedic.cali.calcul.dom;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoEvenement;

public class EvenementPeriodeConflitGaec
  extends ObjetChronoEvenement
  implements EvenementCalculSpec
{
  private EvenementPeriodeConflitGaec() {}
  
  public EvenementPeriodeConflitGaec(Damj p_date)
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
    EvenementPeriodeConflitGaec copie = new EvenementPeriodeConflitGaec();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    EvenementPeriodeConflitGaec copie = (EvenementPeriodeConflitGaec)p_copie;
    copie.setDateEvenement(getDateEvenement());
  }
}

/* Location:
 * Qualified Name:     EvenementPeriodeConflitGaec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */