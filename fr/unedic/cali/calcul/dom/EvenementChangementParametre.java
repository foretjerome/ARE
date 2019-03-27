package fr.unedic.cali.calcul.dom;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoEvenementDebut;

public class EvenementChangementParametre
  extends ObjetChronoEvenementDebut
  implements EvenementCalculSpec
{
  private static final long serialVersionUID = 1L;
  public static final String REVALORISATION = "REVALORISATION";
  public static final String CHANGEMENT_PARAMETRE = "NV PARAMETRE";
  private String m_nomParametre = null;
  
  private EvenementChangementParametre() {}
  
  public EvenementChangementParametre(String p_param, Damj p_date)
  {
    super(p_date);
    setNomParametre(p_param);
  }
  
  public void setNomParametre(String p_param)
  {
    m_nomParametre = p_param;
  }
  
  public String getNomParametre()
  {
    return m_nomParametre;
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
    EvenementChangementParametre copie = new EvenementChangementParametre();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    EvenementChangementParametre copie = (EvenementChangementParametre)p_copie;
    copie.setDateEvenement(getDateEvenement());
    m_nomParametre = getNomParametre();
  }
}

/* Location:
 * Qualified Name:     EvenementChangementParametre
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */