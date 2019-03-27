package fr.unedic.cali.calcul.dom;

import fr.unedic.cali.dom.QuantiteDroitSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoEvenementDebut;

public class EvenementLendemainFinQuantiteDroit
  extends ObjetChronoEvenementDebut
  implements EvenementCalculSpec
{
  private boolean m_estCauseFinProduit = false;
  private QuantiteDroitSpec m_quantiteDroit;
  
  private EvenementLendemainFinQuantiteDroit() {}
  
  public EvenementLendemainFinQuantiteDroit(Damj p_dateEffet, QuantiteDroitSpec p_quantiteDroit)
  {
    super(p_dateEffet);
    setQuantiteDroit(p_quantiteDroit);
  }
  
  public QuantiteDroitSpec getQuantiteDroit()
  {
    return m_quantiteDroit;
  }
  
  public void setQuantiteDroit(QuantiteDroitSpec p_quantiteDroit)
  {
    m_quantiteDroit = p_quantiteDroit;
  }
  
  public boolean estCauseFinProduit()
  {
    return m_estCauseFinProduit;
  }
  
  public void setEstCauseFinProduit(boolean p_estCauseFinProduit)
  {
    m_estCauseFinProduit = p_estCauseFinProduit;
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
    EvenementLendemainFinQuantiteDroit copie = new EvenementLendemainFinQuantiteDroit();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    EvenementLendemainFinQuantiteDroit copie = (EvenementLendemainFinQuantiteDroit)p_copie;
    copie.setDateEvenement(getDateEvenement());
    
    m_estCauseFinProduit = estCauseFinProduit();
    if (getQuantiteDroit() != null) {
      m_quantiteDroit = ((QuantiteDroitSpec)getQuantiteDroit().copie());
    }
  }
}

/* Location:
 * Qualified Name:     EvenementLendemainFinQuantiteDroit
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */