package fr.unedic.cali.calcul.dom;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoEvenement;

public class EvenementPeriodesSuspensivesDisponibilite
  extends ObjetChronoEvenement
  implements EvenementCalculSpec
{
  private static final long serialVersionUID = 1L;
  private transient String codeLibelle = null;
  
  private EvenementPeriodesSuspensivesDisponibilite() {}
  
  public EvenementPeriodesSuspensivesDisponibilite(Damj date, String codeLibelle)
  {
    super(date);
    this.codeLibelle = codeLibelle;
  }
  
  public Damj getDateEvenement()
  {
    return m_dateEvenement;
  }
  
  public void setDateEvenement(Damj dateEvenement)
  {
    m_dateEvenement = dateEvenement;
  }
  
  public String getCodeLibelle()
  {
    return codeLibelle;
  }
  
  public void setCodeLibelle(String codeLibelle)
  {
    this.codeLibelle = codeLibelle;
  }
  
  public ObjetMetierSpec copie()
  {
    EvenementPeriodesSuspensivesDisponibilite copie = new EvenementPeriodesSuspensivesDisponibilite();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec copie)
  {
    EvenementPeriodesSuspensivesDisponibilite copieEvt = (EvenementPeriodesSuspensivesDisponibilite)copie;
    copieEvt.setDateEvenement(getDateEvenement());
    copieEvt.setCodeLibelle(getCodeLibelle());
  }
}

/* Location:
 * Qualified Name:     EvenementPeriodesSuspensivesDisponibilite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */