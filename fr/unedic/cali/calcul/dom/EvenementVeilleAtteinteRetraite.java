package fr.unedic.cali.calcul.dom;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoEvenement;

public class EvenementVeilleAtteinteRetraite
  extends ObjetChronoEvenement
  implements EvenementCalculSpec
{
  private static final long serialVersionUID = 1L;
  
  private EvenementVeilleAtteinteRetraite() {}
  
  public EvenementVeilleAtteinteRetraite(Damj p_date)
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
    EvenementVeilleAtteinteRetraite copie = new EvenementVeilleAtteinteRetraite();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    EvenementVeilleAtteinteRetraite copie = (EvenementVeilleAtteinteRetraite)p_copie;
    copie.setDateEvenement(getDateEvenement());
  }
}

/* Location:
 * Qualified Name:     EvenementVeilleAtteinteRetraite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */