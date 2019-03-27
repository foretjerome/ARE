package fr.unedic.cali.calcul.dom;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoEvenementDebut;

public class EvenementFinATA
  extends ObjetChronoEvenementDebut
  implements EvenementCalculSpec
{
  private static final long serialVersionUID = -2541942738596669567L;
  
  private EvenementFinATA() {}
  
  public EvenementFinATA(Damj date)
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
    EvenementFinATA copie = new EvenementFinATA();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec pcopie)
  {
    EvenementFinATA copie = (EvenementFinATA)pcopie;
    copie.setDateEvenement(getDateEvenement());
  }
}

/* Location:
 * Qualified Name:     EvenementFinATA
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */