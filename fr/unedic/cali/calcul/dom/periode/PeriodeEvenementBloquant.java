package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class PeriodeEvenementBloquant
  extends PeriodeEvenementActualisation
{
  private transient String m_libelleEvtBloquant;
  
  protected PeriodeEvenementBloquant() {}
  
  public PeriodeEvenementBloquant(Damj p_dateDebut)
  {
    super(p_dateDebut, Damj.FIN_DES_TEMPS);
  }
  
  public String getLibelleEvtBloquant()
  {
    return m_libelleEvtBloquant;
  }
  
  public void setLibelleEvtBloquant(String p_libelleEvtBloquant)
  {
    m_libelleEvtBloquant = p_libelleEvtBloquant;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    PeriodeEvenementBloquant copie = (PeriodeEvenementBloquant)p_copie;
    
    super.copieElements(copie);
    
    m_libelleEvtBloquant = getLibelleEvtBloquant();
  }
  
  public ObjetMetierSpec copie()
  {
    PeriodeEvenementBloquant copie = new PeriodeEvenementBloquant();
    copieElements(copie);
    return copie;
  }
}

/* Location:
 * Qualified Name:     PeriodeEvenementBloquant
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */