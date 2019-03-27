package fr.unedic.cali.calcul.dom;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoEvenement;

public class EvenementMaintien
  extends ObjetChronoEvenement
  implements EvenementCalculSpec
{
  private static final long serialVersionUID = 1L;
  public static final String LIBELLE_EVENEMENT_MTIEN = "MTIEN";
  
  private EvenementMaintien() {}
  
  public EvenementMaintien(Damj p_date)
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
    return "MTIEN";
  }
  
  public ObjetMetierSpec copie()
  {
    EvenementMaintien copie = new EvenementMaintien();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    EvenementMaintien copie = (EvenementMaintien)p_copie;
    copie.setDateEvenement(getDateEvenement());
  }
}

/* Location:
 * Qualified Name:     EvenementMaintien
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */