package fr.unedic.cali.calcul.dom;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoEvenement;

public class EvenementBlocageActiviteConservee
  extends ObjetChronoEvenement
  implements EvenementCalculSpec
{
  private EvenementBlocageActiviteConservee() {}
  
  public EvenementBlocageActiviteConservee(Damj p_date)
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
    EvenementBlocageActiviteConservee copie = new EvenementBlocageActiviteConservee();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    EvenementBlocageActiviteConservee copie = (EvenementBlocageActiviteConservee)p_copie;
    copie.setDateEvenement(getDateEvenement());
  }
}

/* Location:
 * Qualified Name:     EvenementBlocageActiviteConservee
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */