package fr.unedic.cali.calcul.dom;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoEvenement;

public class EvenementRevisionAdr
  extends ObjetChronoEvenement
  implements EvenementCalculSpec
{
  private static final long serialVersionUID = 1L;
  
  private EvenementRevisionAdr() {}
  
  public EvenementRevisionAdr(Damj p_date)
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
    EvenementRevisionAdr copie = new EvenementRevisionAdr();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    EvenementRevisionAdr copie = (EvenementRevisionAdr)p_copie;
    copie.setDateEvenement(getDateEvenement());
  }
}

/* Location:
 * Qualified Name:     EvenementRevisionAdr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */