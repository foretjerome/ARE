package fr.unedic.cali.calcul.dom;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoEvenement;

public class EvenementSanctionExclusionDefinitive
  extends ObjetChronoEvenement
  implements EvenementCalculSpec
{
  private String m_libelleEvenement = null;
  
  private EvenementSanctionExclusionDefinitive() {}
  
  public EvenementSanctionExclusionDefinitive(Damj p_date)
  {
    super(p_date);
  }
  
  public EvenementSanctionExclusionDefinitive(Damj p_date, String p_libelleEvt)
  {
    super(p_date);
    setLibelleEvenement(p_libelleEvt);
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
    return m_libelleEvenement;
  }
  
  public void setLibelleEvenement(String p_libelleEvenement)
  {
    m_libelleEvenement = p_libelleEvenement;
  }
  
  public ObjetMetierSpec copie()
  {
    EvenementSanctionExclusionDefinitive copie = new EvenementSanctionExclusionDefinitive();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    EvenementSanctionExclusionDefinitive copie = (EvenementSanctionExclusionDefinitive)p_copie;
    copie.setDateEvenement(getDateEvenement());
    copie.setLibelleEvenement(getLibelleEvenement());
  }
}

/* Location:
 * Qualified Name:     EvenementSanctionExclusionDefinitive
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */