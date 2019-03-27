package fr.unedic.cali.calcul.dom;

import fr.unedic.cali.dom.QuantiteDroitSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoEvenement;

public class EvenementDebutQuantiteDroit
  extends ObjetChronoEvenement
  implements EvenementCalculSpec
{
  private QuantiteDroitSpec m_quantiteDroit;
  private Damj m_dateEvenement;
  private static final long serialVersionUID = -5418058023164761486L;
  
  public EvenementDebutQuantiteDroit() {}
  
  public EvenementDebutQuantiteDroit(Damj p_dateEffet, QuantiteDroitSpec p_quantiteDroit)
  {
    setDateEvenement(p_dateEffet);
    setQuantiteDroit(p_quantiteDroit);
  }
  
  public ObjetMetierSpec copie()
  {
    EvenementDebutQuantiteDroit copie = new EvenementDebutQuantiteDroit();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    EvenementDebutQuantiteDroit copie = (EvenementDebutQuantiteDroit)p_copie;
    if (getDateEvenement() != null) {
      copie.setDateEvenement(getDateEvenement());
    }
    copie.setDateEvenement(getDateEvenement());
    if (getQuantiteDroit() != null) {
      copie.setQuantiteDroit((QuantiteDroitSpec)getQuantiteDroit().copie());
    }
  }
  
  public QuantiteDroitSpec getQuantiteDroit()
  {
    return m_quantiteDroit;
  }
  
  public void setQuantiteDroit(QuantiteDroitSpec p_quantiteDroit)
  {
    m_quantiteDroit = p_quantiteDroit;
  }
  
  public Damj getDateEvenement()
  {
    return m_dateEvenement;
  }
  
  public void setDateEvenement(Damj p_dateEvenement)
  {
    m_dateEvenement = p_dateEvenement;
  }
}

/* Location:
 * Qualified Name:     EvenementDebutQuantiteDroit
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */