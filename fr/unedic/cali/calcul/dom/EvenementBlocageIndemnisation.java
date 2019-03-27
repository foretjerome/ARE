package fr.unedic.cali.calcul.dom;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoEvenement;

public class EvenementBlocageIndemnisation
  extends ObjetChronoEvenement
  implements EvenementCalculSpec
{
  private EvenementBlocageIndemnisation() {}
  
  public EvenementBlocageIndemnisation(Damj p_date)
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
    EvenementBlocageIndemnisation copie = new EvenementBlocageIndemnisation();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    EvenementBlocageIndemnisation copie = (EvenementBlocageIndemnisation)p_copie;
    copie.setDateEvenement(getDateEvenement());
  }
}

/* Location:
 * Qualified Name:     EvenementBlocageIndemnisation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */