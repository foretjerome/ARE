package fr.unedic.cali.calcul.dom;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoEvenement;

public class EvenementDateLimiteIndemnisation
  extends ObjetChronoEvenement
  implements EvenementCalculSpec
{
  private EvenementDateLimiteIndemnisation() {}
  
  public EvenementDateLimiteIndemnisation(Damj date)
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
    EvenementDateLimiteIndemnisation copie = new EvenementDateLimiteIndemnisation();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec paramCopie)
  {
    EvenementDateLimiteIndemnisation copie = (EvenementDateLimiteIndemnisation)paramCopie;
    copie.setDateEvenement(getDateEvenement());
  }
}

/* Location:
 * Qualified Name:     EvenementDateLimiteIndemnisation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */