package fr.unedic.cali.calcul.dom;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoEvenement;

public class EvenementAAH
  extends ObjetChronoEvenement
  implements EvenementCalculSpec
{
  private static final long serialVersionUID = 424087568402909851L;
  
  private EvenementAAH() {}
  
  public EvenementAAH(Damj date)
  {
    super(date);
  }
  
  public Damj getDateEvenement()
  {
    return m_dateEvenement;
  }
  
  public void setDateEvenement(Damj dateEvenement)
  {
    m_dateEvenement = dateEvenement;
  }
  
  public ObjetMetierSpec copie()
  {
    EvenementAAH copie = new EvenementAAH();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec copie)
  {
    EvenementAAH evenementAAH = (EvenementAAH)copie;
    evenementAAH.setDateEvenement(getDateEvenement());
  }
}

/* Location:
 * Qualified Name:     EvenementAAH
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */