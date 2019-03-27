package fr.unedic.cali.calcul.dom;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoEvenement;

public class EvenementMaintienEuropeenPJI
  extends ObjetChronoEvenement
  implements EvenementCalculSpec
{
  private static final long serialVersionUID = 1L;
  public static final String LIBELLE_EVENEMENT = "EVENEMENT_PJI_MAINTIEN";
  
  private EvenementMaintienEuropeenPJI() {}
  
  public EvenementMaintienEuropeenPJI(Damj p_date)
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
  
  public String getLibelleEvenement()
  {
    return "EVENEMENT_PJI_MAINTIEN";
  }
  
  public ObjetMetierSpec copie()
  {
    EvenementMaintienEuropeenPJI copie = new EvenementMaintienEuropeenPJI();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    EvenementMaintienEuropeenPJI copie = (EvenementMaintienEuropeenPJI)p_copie;
    copie.setDateEvenement(getDateEvenement());
  }
}

/* Location:
 * Qualified Name:     EvenementMaintienEuropeenPJI
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */