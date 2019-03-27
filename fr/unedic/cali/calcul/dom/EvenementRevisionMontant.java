package fr.unedic.cali.calcul.dom;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoEvenement;

public class EvenementRevisionMontant
  extends ObjetChronoEvenement
  implements EvenementCalculSpec
{
  private static final long serialVersionUID = 1L;
  public static final String LIBELLE_REVISION_MONTANT = "REVISION_MONTANT";
  
  private EvenementRevisionMontant() {}
  
  public EvenementRevisionMontant(Damj p_date)
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
    return "REVISION_MONTANT";
  }
  
  public ObjetMetierSpec copie()
  {
    EvenementRevisionMontant copie = new EvenementRevisionMontant();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    EvenementRevisionMontant copie = (EvenementRevisionMontant)p_copie;
    copie.setDateEvenement(getDateEvenement());
  }
}

/* Location:
 * Qualified Name:     EvenementRevisionMontant
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */