package fr.unedic.cali.calcul.dom;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoEvenementDebut;

public class EvenementFinCumul
  extends ObjetChronoEvenementDebut
  implements EvenementCalculSpec
{
  private EvenementFinCumul() {}
  
  public EvenementFinCumul(Damj p_date)
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
    EvenementFinCumul copie = new EvenementFinCumul();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    EvenementFinCumul copie = (EvenementFinCumul)p_copie;
    copie.setDateEvenement(getDateEvenement());
  }
}

/* Location:
 * Qualified Name:     EvenementFinCumul
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */